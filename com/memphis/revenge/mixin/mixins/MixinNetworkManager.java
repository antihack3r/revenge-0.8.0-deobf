//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.mixin.mixins;

import org.spongepowered.asm.mixin.*;
import net.minecraft.network.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import com.memphis.revenge.*;
import org.spongepowered.asm.mixin.injection.*;
import com.memphis.revenge.event.events.*;
import io.netty.channel.*;

@Mixin({ NetworkManager.class })
public class MixinNetworkManager
{
    @Inject(method = { "sendPacket(Lnet/minecraft/network/Packet;)V" }, at = { @At("HEAD") }, cancellable = true)
    private void onSendPacket(final Packet<?> p_Packet, final CallbackInfo callbackInfo) {
        final NetworkPacketEvent event = new NetworkPacketEvent((Packet)p_Packet);
        Revenge.EVENT_BUS.post((Object)event);
        if (event.isCancelled()) {
            callbackInfo.cancel();
        }
    }
    
    @Inject(method = { "sendPacket(Lnet/minecraft/network/Packet;)V" }, at = { @At("HEAD") }, cancellable = true)
    private void preSendPacket(final Packet<?> packet, final CallbackInfo callbackInfo) {
        final PacketEvent.Send event = new PacketEvent.Send((Packet)packet);
        Revenge.EVENT_BUS.post((Object)event);
        if (event.isCancelled()) {
            callbackInfo.cancel();
        }
    }
    
    @Inject(method = { "channelRead0" }, at = { @At("HEAD") }, cancellable = true)
    private void preChannelRead(final ChannelHandlerContext context, final Packet<?> packet, final CallbackInfo callbackInfo) {
        final PacketEvent.Receive event = new PacketEvent.Receive((Packet)packet);
        Revenge.EVENT_BUS.post((Object)event);
        if (event.isCancelled()) {
            callbackInfo.cancel();
        }
    }
    
    @Inject(method = { "sendPacket(Lnet/minecraft/network/Packet;)V" }, at = { @At("TAIL") }, cancellable = true)
    private void postSendPacket(final Packet<?> packet, final CallbackInfo callbackInfo) {
        final PacketEvent.PostSend event = new PacketEvent.PostSend((Packet)packet);
        Revenge.EVENT_BUS.post((Object)event);
        if (event.isCancelled()) {
            callbackInfo.cancel();
        }
    }
    
    @Inject(method = { "channelRead0" }, at = { @At("TAIL") }, cancellable = true)
    private void postChannelRead(final ChannelHandlerContext context, final Packet<?> packet, final CallbackInfo callbackInfo) {
        final PacketEvent.PostReceive event = new PacketEvent.PostReceive((Packet)packet);
        Revenge.EVENT_BUS.post((Object)event);
        if (event.isCancelled()) {
            callbackInfo.cancel();
        }
    }
}
