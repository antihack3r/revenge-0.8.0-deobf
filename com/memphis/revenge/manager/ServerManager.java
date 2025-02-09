//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.manager;

import net.minecraft.client.*;
import net.minecraft.client.network.*;
import java.util.*;

public class ServerManager
{
    public static final Minecraft mc;
    
    public int getPing() {
        if (ServerManager.mc.world == null || ServerManager.mc.player == null) {
            return 0;
        }
        try {
            return Objects.requireNonNull(ServerManager.mc.getConnection()).getPlayerInfo(ServerManager.mc.getConnection().getGameProfile().getId()).getResponseTime();
        }
        catch (Exception e) {
            return 0;
        }
    }
    
    static {
        mc = Minecraft.getMinecraft();
    }
}
