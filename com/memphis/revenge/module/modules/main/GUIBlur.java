//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.module.modules.main;

import com.memphis.revenge.module.*;
import com.memphis.revenge.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;

public class GUIBlur extends Module
{
    public GUIBlur() {
        super("GUIBlur", "", 0, Module.Category.MAIN);
    }
    
    public void onDisable() {
        if (GUIBlur.mc.world != null) {
            GUIBlur.mc.entityRenderer.getShaderGroup().deleteShaderGroup();
        }
    }
    
    public void update() {
        if (GUIBlur.mc.world != null) {
            if (GUIBlur.mc.currentScreen == Revenge.instance.clickGui) {
                if (OpenGlHelper.shadersSupported && GUIBlur.mc.getRenderViewEntity() instanceof EntityPlayer) {
                    if (GUIBlur.mc.entityRenderer.getShaderGroup() != null) {
                        GUIBlur.mc.entityRenderer.getShaderGroup().deleteShaderGroup();
                    }
                    try {
                        GUIBlur.mc.entityRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else if (GUIBlur.mc.entityRenderer.getShaderGroup() != null && GUIBlur.mc.currentScreen == null) {
                    GUIBlur.mc.entityRenderer.getShaderGroup().deleteShaderGroup();
                }
            }
            else if (GUIBlur.mc.entityRenderer.getShaderGroup() != null) {
                GUIBlur.mc.entityRenderer.getShaderGroup().deleteShaderGroup();
            }
        }
    }
}
