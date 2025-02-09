//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.module.modules.movement;

import com.memphis.revenge.module.*;
import com.memphis.revenge.setting.settings.*;
import net.minecraft.client.entity.*;

public class ReverseStep extends Module
{
    SettingDouble speed;
    
    public ReverseStep() {
        super("ReverseStep", "", 0, Module.Category.MOVEMENT);
        this.speed = this.register("Speed", 5.0, 0.0, 20.0);
    }
    
    public void update() {
        if (ReverseStep.mc.player.isInWater() || ReverseStep.mc.player.isInLava()) {
            return;
        }
        if (ReverseStep.mc.player.onGround) {
            final EntityPlayerSP player = ReverseStep.mc.player;
            player.motionY -= this.speed.getValue() / 10.0;
        }
    }
}
