//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.module.modules.main;

import com.memphis.revenge.module.*;
import com.memphis.revenge.*;
import net.minecraft.client.gui.*;

public class ClickGuiModule extends Module
{
    public ClickGuiModule() {
        super("ClickGui", "Displays Gui screen.", 54, Module.Category.MAIN);
    }
    
    public void onEnable() {
        ClickGuiModule.mc.displayGuiScreen((GuiScreen)Revenge.instance.clickGui);
        this.toggle();
    }
}
