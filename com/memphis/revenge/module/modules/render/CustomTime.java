//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.module.modules.render;

import com.memphis.revenge.module.*;
import com.memphis.revenge.setting.settings.*;
import com.memphis.revenge.event.events.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.network.play.server.*;

public class CustomTime extends Module
{
    long time;
    SettingDouble clientTime;
    @EventHandler
    private final Listener<PacketEvent.Receive> receiveListener;
    
    public CustomTime() {
        super("CustomTime", "Allows you to change game time.", 0, Module.Category.RENDER);
        this.time = 0L;
        this.clientTime = this.register("Time", 18000.0, 0.0, 23992.0);
        this.receiveListener = (Listener<PacketEvent.Receive>)new Listener(event -> {
            if (event.getPacket() instanceof SPacketTimeUpdate) {
                event.cancel();
            }
        }, new Predicate[0]);
    }
    
    public void onEnable() {
        this.time = CustomTime.mc.world.getWorldTime();
    }
    
    public void update() {
        CustomTime.mc.world.setWorldTime((long)this.clientTime.getValue());
    }
    
    public void onDisable() {
        CustomTime.mc.world.setWorldTime(this.time);
    }
}
