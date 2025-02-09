//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.module.modules.player;

import com.memphis.revenge.module.*;

public class AntiVoid extends Module
{
    public AntiVoid() {
        super("AntiVoid", "", 0, Module.Category.PLAYER);
    }
    
    public void update() {
        if (AntiVoid.mc.player.posY <= 0.5) {
            AntiVoid.mc.player.moveVertical = 10.0f;
            AntiVoid.mc.player.jump();
        }
        else {
            AntiVoid.mc.player.moveVertical = 0.0f;
        }
    }
    
    public void onDisable() {
        AntiVoid.mc.player.moveVertical = 0.0f;
    }
}
