//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge;

import net.minecraftforge.fml.common.*;
import me.zero.alpine.*;
import com.memphis.revenge.module.*;
import com.memphis.revenge.setting.*;
import com.memphis.revenge.gui.*;
import net.minecraftforge.common.*;
import com.memphis.revenge.event.*;
import com.google.common.base.*;
import com.memphis.revenge.manager.*;
import net.minecraftforge.fml.common.event.*;
import org.lwjgl.opengl.*;

@Mod(modid = "revenge", name = "revenge", version = "0.8.0-build842210eb")
public class Revenge
{
    public static final String MODID = "revenge";
    public static final String NAME = "revenge";
    public static final String VERSION = "0.8.0-build842210eb";
    public static final String NAME_VERSION = "Revenge - 0.8.0-build842210eb";
    @Mod.Instance
    public static Revenge instance;
    public static final EventManager EVENT_BUS;
    public static ModuleManager moduleManager;
    public static SettingsManager settingsManager;
    public static FontManager fontManager;
    public static ServerManager serverManager;
    public static RotationManager rotationManager;
    public static PositionManager positionManager;
    public Screen clickGui;
    
    @Mod.EventHandler
    public void preInit(final FMLPreInitializationEvent event) {
        HWIDManager.hwidCheck();
    }
    
    @Mod.EventHandler
    public void init(final FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register((Object)Revenge.instance);
        Revenge.settingsManager = new SettingsManager();
        Revenge.moduleManager = new ModuleManager();
        Revenge.fontManager = new FontManager();
        Revenge.serverManager = new ServerManager();
        Revenge.rotationManager = new RotationManager();
        Revenge.positionManager = new PositionManager();
        new EventProcessor();
        this.clickGui = new Screen();
        final Stopwatch watch = Stopwatch.createStarted();
        S1ashConfigManager.load();
        System.out.printf("revenge load config took %sms", watch.stop());
    }
    
    @Mod.EventHandler
    public void init(final FMLInitializationEvent event) {
        Display.setTitle("revenge - 0.8.0-build842210eb");
    }
    
    static {
        Revenge.instance = new Revenge();
        EVENT_BUS = new EventManager();
    }
}
