//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.manager;

import java.nio.file.*;
import com.memphis.revenge.*;
import com.memphis.revenge.module.*;
import com.memphis.revenge.setting.settings.*;
import java.io.*;
import java.nio.file.attribute.*;
import java.nio.charset.*;
import java.util.*;
import com.memphis.revenge.setting.*;
import com.google.gson.*;

public class S1ashConfigManager
{
    private static final String CONFIG_FOLDER = "revenge/";
    private static final Gson GSON;
    private static final JsonParser PARSER;
    
    private S1ashConfigManager() {
    }
    
    public static void load() {
        if (Files.notExists(Paths.get("revenge/", new String[0]), new LinkOption[0])) {
            return;
        }
        if (Files.exists(Paths.get("revenge/other/friends.json", new String[0]), new LinkOption[0])) {
            try (final InputStream stream = Files.newInputStream(Paths.get("revenge/other/friends.json", new String[0]), new OpenOption[0])) {
                S1ashFriendsManager.deserialize(S1ashConfigManager.PARSER.parse((Reader)new InputStreamReader(stream)).getAsJsonArray());
            }
            catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        for (final Module module : Revenge.moduleManager.getModules()) {
            if (Files.notExists(Paths.get("revenge/" + module.getCategory().name() + "/" + module.getName() + ".json", new String[0]), new LinkOption[0])) {
                continue;
            }
            try (final InputStream stream2 = Files.newInputStream(Paths.get("revenge/" + module.getCategory().name() + "/" + module.getName() + ".json", new String[0]), new OpenOption[0])) {
                final JsonElement el = S1ashConfigManager.PARSER.parse((Reader)new InputStreamReader(stream2));
                if (!(!el.isJsonObject())) {
                    final JsonObject obj = el.getAsJsonObject();
                    if (obj.has("bind")) {
                        module.setKey(obj.get("bind").getAsInt());
                    }
                    if (obj.has("enabled")) {
                        module.setToggled(obj.get("enabled").getAsBoolean());
                    }
                    if (obj.has("settings")) {
                        final JsonObject setObj = obj.getAsJsonObject("settings");
                        final JsonObject jsonObject;
                        Revenge.settingsManager.getSettingsInMod(module).forEach(s -> {
                            if (jsonObject.has(s.getName())) {
                                switch (s.getType()) {
                                    case INTEGER: {
                                        ((SettingInteger)s).setValue(jsonObject.get(s.getName()).getAsInt());
                                        break;
                                    }
                                    case DOUBLE: {
                                        ((SettingDouble)s).setValue(jsonObject.get(s.getName()).getAsDouble());
                                        break;
                                    }
                                    case BOOLEAN: {
                                        ((SettingBoolean)s).setValue(jsonObject.get(s.getName()).getAsBoolean());
                                        break;
                                    }
                                    case MODE: {
                                        s.setValue(jsonObject.get(s.getName()).getAsString());
                                        break;
                                    }
                                }
                            }
                            return;
                        });
                    }
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void save() {
        if (Files.notExists(Paths.get("revenge/other", new String[0]), new LinkOption[0])) {
            try {
                Files.createDirectories(Paths.get("revenge/other", new String[0]), (FileAttribute<?>[])new FileAttribute[0]);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (!S1ashFriendsManager.FRIENDS.isEmpty()) {
            final String json = S1ashConfigManager.GSON.toJson((JsonElement)S1ashFriendsManager.serialize());
            try {
                Files.write(Paths.get("revenge/other/friends.json", new String[0]), json.getBytes(StandardCharsets.UTF_8), new OpenOption[0]);
            }
            catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        for (final Module.Category category : Module.Category.values()) {
            if (Files.notExists(Paths.get("revenge/" + category.name().toLowerCase(Locale.ROOT), new String[0]), new LinkOption[0])) {
                try {
                    Files.createDirectories(Paths.get("revenge/" + category.name().toLowerCase(Locale.ROOT), new String[0]), (FileAttribute<?>[])new FileAttribute[0]);
                }
                catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            for (final Module module : Revenge.moduleManager.getModsInCategory(category)) {
                final JsonObject obj = new JsonObject();
                obj.addProperty("bind", (Number)module.getKey());
                obj.addProperty("enabled", Boolean.valueOf(module.isToggled()));
                final JsonObject setObj = new JsonObject();
                final JsonObject jsonObject;
                Revenge.settingsManager.getSettingsInMod(module).forEach(s -> {
                    switch (s.getType()) {
                        case INTEGER: {
                            jsonObject.addProperty(s.getName(), (Number)((SettingInteger)s).getValue());
                            break;
                        }
                        case DOUBLE: {
                            jsonObject.addProperty(s.getName(), (Number)((SettingDouble)s).getValue());
                            break;
                        }
                        case BOOLEAN: {
                            jsonObject.addProperty(s.getName(), Boolean.valueOf(((SettingBoolean)s).getValue()));
                            break;
                        }
                        case MODE: {
                            jsonObject.addProperty(s.getName(), s.getValue());
                            break;
                        }
                    }
                    return;
                });
                obj.add("settings", (JsonElement)setObj);
                final String json2 = S1ashConfigManager.GSON.toJson((JsonElement)obj);
                try {
                    Files.write(Paths.get("revenge/" + category.name().toLowerCase(Locale.ROOT) + "/" + module.getName() + ".json", new String[0]), json2.getBytes(StandardCharsets.UTF_8), new OpenOption[0]);
                }
                catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }
    
    static {
        GSON = new GsonBuilder().setPrettyPrinting().create();
        PARSER = new JsonParser();
    }
}
