//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.module.modules.movement;

import com.memphis.revenge.module.*;
import net.minecraft.init.*;

public class IceSpeed extends Module
{
    public IceSpeed() {
        super("IceSpeed", "", 0, Module.Category.MOVEMENT);
    }
    
    public void update() {
        Blocks.ICE.slipperiness = 0.4f;
        Blocks.PACKED_ICE.slipperiness = 0.4f;
        Blocks.FROSTED_ICE.slipperiness = 0.4f;
    }
    
    public void onDisable() {
        Blocks.ICE.slipperiness = 0.98f;
        Blocks.PACKED_ICE.slipperiness = 0.98f;
        Blocks.FROSTED_ICE.slipperiness = 0.98f;
    }
}
