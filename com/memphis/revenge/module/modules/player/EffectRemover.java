//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.module.modules.player;

import com.memphis.revenge.module.*;
import com.memphis.revenge.setting.settings.*;
import net.minecraft.potion.*;
import java.util.*;

public class EffectRemover extends Module
{
    SettingBoolean levitation;
    SettingBoolean jumpBoost;
    
    public EffectRemover() {
        super("EffectRemover", "Removes the effects from you.", 0, Module.Category.PLAYER);
        this.levitation = this.register("Levitation", true);
        this.jumpBoost = this.register("JumpBoost", true);
    }
    
    public void update() {
        if (this.levitation.getValue() && EffectRemover.mc.player.isPotionActive((Potion)Objects.requireNonNull(Potion.getPotionFromResourceLocation("levitation")))) {
            EffectRemover.mc.player.removeActivePotionEffect(Potion.getPotionFromResourceLocation("levitation"));
        }
        if (this.jumpBoost.getValue() && EffectRemover.mc.player.isPotionActive((Potion)Objects.requireNonNull(Potion.getPotionFromResourceLocation("jump_boost")))) {
            EffectRemover.mc.player.removeActivePotionEffect(Potion.getPotionFromResourceLocation("jump_boost"));
        }
    }
}
