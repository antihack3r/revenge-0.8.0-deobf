//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.module.modules.combat;

import com.memphis.revenge.module.*;
import com.memphis.revenge.setting.settings.*;
import net.minecraft.client.gui.inventory.*;
import net.minecraft.init.*;
import net.minecraft.inventory.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.client.entity.*;
import java.util.*;

public class AutoTotem extends Module
{
    private SettingBoolean soft;
    private boolean dragging;
    private int totems;
    
    public AutoTotem() {
        super("AutoTotem", "", 0, Module.Category.COMBAT);
        this.soft = this.register("Soft", false);
        this.dragging = false;
        this.totems = 0;
    }
    
    public void update() {
        if (AutoTotem.mc.currentScreen instanceof GuiContainer && !(AutoTotem.mc.currentScreen instanceof GuiInventory)) {
            return;
        }
        final EntityPlayerSP player = AutoTotem.mc.player;
        if (player == null) {
            return;
        }
        if (!player.inventory.getItemStack().isEmpty() && !this.dragging) {
            for (int i = 0; i < 45; ++i) {
                if (player.inventory.getStackInSlot(i).isEmpty() || player.inventory.getStackInSlot(i).getItem() == Items.AIR) {
                    final int slot = (i < 9) ? (i + 36) : i;
                    AutoTotem.mc.playerController.windowClick(0, slot, 0, ClickType.PICKUP, (EntityPlayer)player);
                    return;
                }
            }
        }
        this.totems = 0;
        for (final ItemStack stack : player.inventory.mainInventory) {
            if (stack.getItem() == Items.TOTEM_OF_UNDYING) {
                this.totems += stack.getCount();
            }
        }
        if (player.getHeldItemOffhand().getItem() == Items.TOTEM_OF_UNDYING) {
            this.totems += player.getHeldItemOffhand().getCount();
            return;
        }
        if (this.soft.getValue() && !player.getHeldItemOffhand().isEmpty()) {
            return;
        }
        if (this.dragging) {
            AutoTotem.mc.playerController.windowClick(0, 45, 0, ClickType.PICKUP, (EntityPlayer)player);
            this.dragging = false;
            return;
        }
        for (int i = 0; i < 45; ++i) {
            if (player.inventory.getStackInSlot(i).getItem() == Items.TOTEM_OF_UNDYING) {
                final int slot = (i < 9) ? (i + 36) : i;
                AutoTotem.mc.playerController.windowClick(0, slot, 0, ClickType.PICKUP, (EntityPlayer)player);
                this.dragging = true;
                return;
            }
        }
    }
}
