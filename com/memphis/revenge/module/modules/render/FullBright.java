//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.module.modules.render;

import com.memphis.revenge.module.*;

public class FullBright extends Module
{
    public FullBright() {
        super("FullBright", "Turns up brightness to see in the dark.", 0, Module.Category.RENDER);
    }
    
    public void update() {
        FullBright.mc.gameSettings.gammaSetting = 100.0f;
    }
    
    public void onDisable() {
        FullBright.mc.gameSettings.gammaSetting = 1.0f;
    }
}
