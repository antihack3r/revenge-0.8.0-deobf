//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.module.modules.main;

import com.memphis.revenge.module.*;
import com.memphis.revenge.setting.settings.*;

public class CustomFOV extends Module
{
    float defaultFov;
    SettingInteger fov;
    
    public CustomFOV() {
        super("CustomFOV", "Allows you to change game FOV what you want.", 0, Module.Category.MAIN);
        this.fov = this.register("FOV", 140, 30, 170);
    }
    
    public void onEnable() {
        super.onEnable();
        this.defaultFov = CustomFOV.mc.gameSettings.fovSetting;
    }
    
    public void update() {
        super.update();
        CustomFOV.mc.gameSettings.fovSetting = (float)this.fov.getValue();
    }
    
    public void onDisable() {
        super.onDisable();
        CustomFOV.mc.gameSettings.fovSetting = this.defaultFov;
    }
}
