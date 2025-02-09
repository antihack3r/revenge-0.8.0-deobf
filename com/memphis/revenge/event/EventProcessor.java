//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.event;

import net.minecraftforge.common.*;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraftforge.fml.common.gameevent.*;
import net.minecraftforge.client.event.*;
import com.memphis.revenge.*;

public class EventProcessor
{
    public EventProcessor() {
        MinecraftForge.EVENT_BUS.register((Object)this);
    }
    
    @SubscribeEvent
    public void onKey(final InputEvent.KeyInputEvent event) {
    }
    
    @SubscribeEvent
    public void onTick(final TickEvent.ClientTickEvent event) {
    }
    
    @SubscribeEvent
    public void onRender(final RenderGameOverlayEvent event) {
    }
    
    @SubscribeEvent
    public void onRenderWorld(final RenderWorldLastEvent event) {
        Revenge.EVENT_BUS.post((Object)event);
    }
}
