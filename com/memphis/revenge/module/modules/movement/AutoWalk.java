//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.module.modules.movement;

import com.memphis.revenge.module.*;
import net.minecraft.client.settings.*;

public class AutoWalk extends Module
{
    public AutoWalk() {
        super("AutoWalk", "Presses the move forward key.", 0, Module.Category.MOVEMENT);
    }
    
    public void update() {
        KeyBinding.setKeyBindState(AutoWalk.mc.gameSettings.keyBindForward.getKeyCode(), true);
    }
}
