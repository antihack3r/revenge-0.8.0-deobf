//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.module.modules.player;

import com.memphis.revenge.module.*;
import net.minecraft.world.*;

public class Gamemode extends Module
{
    public Gamemode() {
        super("Gamemode", "Fake gamemode 1.", 0, Module.Category.PLAYER);
    }
    
    public void onEnable() {
        super.onEnable();
        Gamemode.mc.playerController.setGameType(GameType.CREATIVE);
    }
    
    public void onDisable() {
        super.onDisable();
        Gamemode.mc.playerController.setGameType(GameType.SURVIVAL);
    }
}
