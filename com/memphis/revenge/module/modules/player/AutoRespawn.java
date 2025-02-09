//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.module.modules.player;

import com.memphis.revenge.module.*;
import com.memphis.revenge.setting.settings.*;
import net.minecraft.client.gui.*;
import com.memphis.revenge.command.*;

public class AutoRespawn extends Module
{
    SettingBoolean coords;
    
    public AutoRespawn() {
        super("AutoRespawn", "Removes the death screen.", 0, Module.Category.PLAYER);
        this.coords = this.register("DeathCoords", true);
    }
    
    public void update() {
        super.update();
        if (AutoRespawn.mc.currentScreen instanceof GuiGameOver) {
            AutoRespawn.mc.player.respawnPlayer();
            AutoRespawn.mc.displayGuiScreen((GuiScreen)null);
        }
        if (this.coords.getValue() && AutoRespawn.mc.currentScreen instanceof GuiGameOver) {
            Messages.sendClientMessage(new String[] { "You have died at x" + (int)AutoRespawn.mc.player.posX + " y" + (int)AutoRespawn.mc.player.posY + " z" + (int)AutoRespawn.mc.player.posZ });
        }
    }
}
