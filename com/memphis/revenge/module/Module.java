//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.module;

import net.minecraft.client.*;
import com.memphis.revenge.*;
import net.minecraftforge.common.*;
import com.mojang.realmsclient.gui.*;
import com.memphis.revenge.command.*;
import java.util.*;
import com.memphis.revenge.setting.settings.*;

public class Module
{
    public static final Minecraft mc;
    public String name;
    public String description;
    public int key;
    public Category category;
    public boolean toggled;
    
    public Module(final String name, final String description, final int key, final Category category) {
        this.name = name;
        this.description = description;
        this.key = key;
        this.category = category;
    }
    
    public void enable() {
        Revenge.EVENT_BUS.subscribe((Object)this);
        MinecraftForge.EVENT_BUS.register((Object)this);
        this.onEnable();
        Messages.sendClientMessage(new String[] { ChatFormatting.BOLD + this.getName() + ChatFormatting.GREEN + " enabled." });
    }
    
    public void disable() {
        Revenge.EVENT_BUS.unsubscribe((Object)this);
        MinecraftForge.EVENT_BUS.unregister((Object)this);
        this.onDisable();
        Messages.sendClientMessage(new String[] { ChatFormatting.BOLD + this.getName() + ChatFormatting.RED + " disabled." });
    }
    
    public void toggle() {
        this.toggled = !this.toggled;
        if (this.toggled) {
            this.enable();
        }
        else {
            this.disable();
        }
    }
    
    public void update() {
    }
    
    public void render() {
    }
    
    public void onEnable() {
    }
    
    public void onDisable() {
    }
    
    public void onToggle() {
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(final String description) {
        this.description = description;
    }
    
    public int getKey() {
        return this.key;
    }
    
    public void setKey(final int key) {
        this.key = key;
    }
    
    public Category getCategory() {
        return this.category;
    }
    
    public void setCategory(final Category category) {
        this.category = category;
    }
    
    public boolean isToggled() {
        return this.toggled;
    }
    
    public void setToggled(final boolean toggled) {
        this.toggled = toggled;
    }
    
    public SettingBoolean register(final String name, final boolean value) {
        final SettingBoolean set = new SettingBoolean(name, this, value);
        final Revenge instance = Revenge.instance;
        Revenge.settingsManager.settings.add(set);
        return set;
    }
    
    public SettingMode register(final String name, final ArrayList<String> values, final String value) {
        final SettingMode set = new SettingMode(name, this, values, value);
        final Revenge instance = Revenge.instance;
        Revenge.settingsManager.settings.add(set);
        return set;
    }
    
    public SettingInteger register(final String name, final int value, final int min, final int max) {
        final SettingInteger set = new SettingInteger(name, this, value, min, max);
        final Revenge instance = Revenge.instance;
        Revenge.settingsManager.settings.add(set);
        return set;
    }
    
    public SettingDouble register(final String name, final double value, final double min, final double max) {
        final SettingDouble set = new SettingDouble(name, this, (int)value, (int)min, (int)max);
        final Revenge instance = Revenge.instance;
        Revenge.settingsManager.settings.add(set);
        return set;
    }
    
    public boolean nullCheck() {
        return Module.mc.player == null || Module.mc.world == null;
    }
    
    static {
        mc = Minecraft.getMinecraft();
    }
    
    public enum Category
    {
        MAIN, 
        COMBAT, 
        MOVEMENT, 
        RENDER, 
        MISC, 
        PLAYER;
    }
}
