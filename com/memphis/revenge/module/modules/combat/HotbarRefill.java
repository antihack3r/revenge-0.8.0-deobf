//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.module.modules.combat;

import com.memphis.revenge.module.*;
import com.memphis.revenge.setting.settings.*;
import com.memphis.revenge.util.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.inventory.*;
import net.minecraft.entity.player.*;

public class HotbarRefill extends Module
{
    SettingInteger delay;
    SettingInteger crystals;
    SettingInteger exp;
    SettingInteger gapples;
    private final Timer timer;
    private final ArrayList<Item> Hotbar;
    
    public HotbarRefill() {
        super("HotbarRefill", "", 0, Module.Category.COMBAT);
        this.delay = this.register("Delay", 1, 0, 10);
        this.crystals = this.register("Crystals", 32, 1, 64);
        this.exp = this.register("EXP", 32, 1, 64);
        this.gapples = this.register("Gapples", 32, 1, 64);
        this.timer = new Timer();
        this.Hotbar = new ArrayList<Item>();
    }
    
    public void onEnable() {
        this.Hotbar.clear();
        for (int i = 0; i < 9; ++i) {
            final ItemStack Stack = HotbarRefill.mc.player.inventory.getStackInSlot(i);
            if (!Stack.isEmpty() && !this.Hotbar.contains(Stack.getItem())) {
                this.Hotbar.add(Stack.getItem());
            }
            else {
                this.Hotbar.add(Items.AIR);
            }
        }
    }
    
    public void update() {
        if (HotbarRefill.mc.currentScreen != null) {
            return;
        }
        if (!this.timer.passedMs(this.delay.getValue() * 1000L)) {
            return;
        }
        for (int i = 0; i < 9; ++i) {
            if (this.RefillSlotIfNeed(i)) {
                this.timer.reset();
                return;
            }
        }
    }
    
    private boolean RefillSlotIfNeed(final int p_Slot) {
        final ItemStack Stack = HotbarRefill.mc.player.inventory.getStackInSlot(p_Slot);
        if (Stack.isEmpty() || Stack.getItem() == Items.AIR) {
            return false;
        }
        if (!Stack.isStackable()) {
            return false;
        }
        if (Stack.getCount() >= Stack.getMaxStackSize()) {
            return false;
        }
        if (Stack.getItem().equals(Items.GOLDEN_APPLE) && Stack.getCount() >= this.gapples.getValue()) {
            return false;
        }
        if (Stack.getItem().equals(Items.EXPERIENCE_BOTTLE) && Stack.getCount() > this.exp.getValue()) {
            return false;
        }
        if (Stack.getItem().equals(Items.END_CRYSTAL) && Stack.getCount() >= this.crystals.getValue()) {
            return false;
        }
        for (int i = 9; i < 36; ++i) {
            final ItemStack Item = HotbarRefill.mc.player.inventory.getStackInSlot(i);
            if (!Item.isEmpty() && this.CanItemBeMergedWith(Stack, Item)) {
                HotbarRefill.mc.playerController.windowClick(HotbarRefill.mc.player.inventoryContainer.windowId, i, 0, ClickType.QUICK_MOVE, (EntityPlayer)HotbarRefill.mc.player);
                HotbarRefill.mc.playerController.updateController();
                return true;
            }
        }
        return false;
    }
    
    private boolean CanItemBeMergedWith(final ItemStack p_Source, final ItemStack p_Target) {
        return p_Source.getItem() == p_Target.getItem() && p_Source.getDisplayName().equals(p_Target.getDisplayName());
    }
}
