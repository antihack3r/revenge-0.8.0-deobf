//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.module.modules.player;

import com.memphis.revenge.module.*;
import net.minecraft.entity.*;
import net.minecraft.client.network.*;
import java.util.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;

public class Vanish extends Module
{
    Entity entity;
    
    public Vanish() {
        super("Vanish", "", 0, Module.Category.PLAYER);
    }
    
    public void onEnable() {
        if (Vanish.mc.player.getRidingEntity() != null) {
            this.entity = Vanish.mc.player.getRidingEntity();
            Vanish.mc.player.dismountRidingEntity();
            Vanish.mc.world.removeEntity(this.entity);
        }
    }
    
    public void update() {
        if (this.nullCheck()) {
            this.disable();
            return;
        }
        if (this.entity != null) {
            try {
                this.entity.posX = Vanish.mc.player.posX;
                this.entity.posY = Vanish.mc.player.posY;
                this.entity.posZ = Vanish.mc.player.posZ;
                Objects.requireNonNull(Vanish.mc.getConnection()).sendPacket((Packet)new CPacketVehicleMove(this.entity));
            }
            catch (Exception ex) {}
        }
    }
}
