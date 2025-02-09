//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.module.modules.misc;

import com.memphis.revenge.module.*;
import com.memphis.revenge.event.events.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.network.play.client.*;
import net.minecraft.item.*;

public class ChorusBlink extends Module
{
    @EventHandler
    private final Listener<PacketEvent.Send> receiveListener;
    
    public ChorusBlink() {
        super("ChorusBlink", "Fake chorus teleport.", 0, Module.Category.MISC);
        this.receiveListener = (Listener<PacketEvent.Send>)new Listener(event -> {
            if ((event.getPacket() instanceof CPacketConfirmTeleport && ChorusBlink.mc.player.getHeldItemMainhand().getItem() instanceof ItemChorusFruit) || ChorusBlink.mc.player.getHeldItemOffhand().getItem() instanceof ItemChorusFruit) {
                event.cancel();
            }
        }, new Predicate[0]);
    }
}
