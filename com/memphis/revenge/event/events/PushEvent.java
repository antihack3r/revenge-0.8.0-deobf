//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.event.events;

import com.memphis.revenge.event.*;
import net.minecraft.client.*;
import net.minecraft.entity.*;

public class PushEvent extends Event
{
    public static final Minecraft mc;
    public double x;
    public double y;
    public double z;
    public Entity entity;
    
    public PushEvent(final Entity entity, final double x, final double y, final double z) {
        this.entity = entity;
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    static {
        mc = Minecraft.getMinecraft();
    }
}
