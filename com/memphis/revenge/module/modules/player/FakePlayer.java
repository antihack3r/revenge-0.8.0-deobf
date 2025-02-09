//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.module.modules.player;

import com.memphis.revenge.module.*;
import net.minecraft.client.entity.*;
import java.util.*;
import com.mojang.authlib.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;

public class FakePlayer extends Module
{
    private EntityOtherPlayerMP bot;
    
    public FakePlayer() {
        super("FakePlayer", "Spawns a bot", 0, Module.Category.PLAYER);
    }
    
    public void onEnable() {
        if (FakePlayer.mc.player.isDead) {
            this.disable();
            return;
        }
        (this.bot = new EntityOtherPlayerMP((World)FakePlayer.mc.world, new GameProfile(UUID.fromString("0d14a8d5-4576-4ab8-a610-88c542c9fcbf"), "cattyn"))).copyLocationAndAnglesFrom((Entity)FakePlayer.mc.player);
        this.bot.rotationYawHead = FakePlayer.mc.player.rotationYawHead;
        this.bot.rotationYaw = FakePlayer.mc.player.rotationYaw;
        this.bot.rotationPitch = FakePlayer.mc.player.rotationPitch;
        this.bot.setGameType(GameType.SURVIVAL);
        this.bot.setHealth(20.0f);
        FakePlayer.mc.world.addEntityToWorld(-1337, (Entity)this.bot);
        this.bot.onLivingUpdate();
    }
    
    public void onDisable() {
        if (FakePlayer.mc.world != null) {
            FakePlayer.mc.world.removeEntityFromWorld(-1337);
        }
    }
}
