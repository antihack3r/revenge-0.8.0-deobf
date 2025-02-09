//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.module.modules.main;

import com.memphis.revenge.module.*;
import com.memphis.revenge.*;

public class CustomFont extends Module
{
    public CustomFont() {
        super("CustomFont", "", 0, Module.Category.MAIN);
    }
    
    public void onEnable() {
        Revenge.fontManager.setCustomFont(true);
    }
    
    public void onDisable() {
        Revenge.fontManager.setCustomFont(false);
    }
}
