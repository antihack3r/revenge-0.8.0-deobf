//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.event.events;

import com.memphis.revenge.event.*;
import net.minecraft.network.*;

public class NetworkPacketEvent extends Event
{
    public Packet m_Packet;
    
    public NetworkPacketEvent(final Packet p_Packet) {
        this.m_Packet = p_Packet;
    }
    
    public Packet GetPacket() {
        return this.m_Packet;
    }
    
    public Packet getPacket() {
        return this.m_Packet;
    }
}
