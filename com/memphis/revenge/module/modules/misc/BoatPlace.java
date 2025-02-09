//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.module.modules.misc;

import com.memphis.revenge.module.*;
import com.memphis.revenge.event.events.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.network.play.client.*;
import net.minecraft.item.*;

public class BoatPlace extends Module
{
    @EventHandler
    private final Listener<PacketEvent.Send> receiveListener;
    
    public BoatPlace() {
        super("BoatPlace", "Allows you to place the boat on servers where it is patched.", 0, Module.Category.MISC);
        this.receiveListener = (Listener<PacketEvent.Send>)new Listener(event -> {
            if ((event.getPacket() instanceof CPacketPlayerTryUseItemOnBlock && BoatPlace.mc.player.getHeldItemMainhand().getItem() instanceof ItemBoat) || BoatPlace.mc.player.getHeldItemOffhand().getItem() instanceof ItemBoat) {
                event.cancel();
            }
        }, new Predicate[0]);
    }
}
