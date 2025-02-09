//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.module.modules.misc;

import com.memphis.revenge.module.*;
import com.memphis.revenge.setting.settings.*;
import net.minecraftforge.event.entity.*;
import net.minecraft.init.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class SoundRemover extends Module
{
    SettingBoolean fireworks;
    SettingBoolean bats;
    SettingBoolean snowballs;
    
    public SoundRemover() {
        super("SoundRemover", "Removes sounds", 0, Module.Category.MISC);
        this.fireworks = this.register("Fireworks", false);
        this.bats = this.register("Bats", false);
        this.snowballs = this.register("Snowballs", false);
    }
    
    @SubscribeEvent
    public void onPlaySound(final PlaySoundAtEntityEvent event) {
        if ((this.bats.getValue() && event.getSound().equals(SoundEvents.ENTITY_BAT_AMBIENT)) || event.getSound().equals(SoundEvents.ENTITY_BAT_DEATH) || event.getSound().equals(SoundEvents.ENTITY_BAT_HURT) || event.getSound().equals(SoundEvents.ENTITY_BAT_LOOP) || event.getSound().equals(SoundEvents.ENTITY_BAT_TAKEOFF)) {
            event.setVolume(0.0f);
            event.setPitch(0.0f);
            event.setCanceled(true);
        }
        if ((this.fireworks.getValue() && event.getSound().equals(SoundEvents.ENTITY_FIREWORK_BLAST)) || event.getSound().equals(SoundEvents.ENTITY_FIREWORK_BLAST_FAR) || event.getSound().equals(SoundEvents.ENTITY_FIREWORK_LARGE_BLAST) || event.getSound().equals(SoundEvents.ENTITY_FIREWORK_SHOOT) || event.getSound().equals(SoundEvents.ENTITY_FIREWORK_LAUNCH) || event.getSound().equals(SoundEvents.ENTITY_FIREWORK_TWINKLE) || event.getSound().equals(SoundEvents.ENTITY_FIREWORK_TWINKLE_FAR) || event.getSound().equals(SoundEvents.ENTITY_FIREWORK_LARGE_BLAST_FAR)) {
            event.setVolume(0.0f);
            event.setPitch(0.0f);
            event.setCanceled(true);
        }
        if (this.snowballs.getValue() && event.getSound().equals(SoundEvents.ENTITY_SNOWBALL_THROW)) {
            event.setVolume(0.0f);
            event.setPitch(0.0f);
            event.setCanceled(true);
        }
    }
}
