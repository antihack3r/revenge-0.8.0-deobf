//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.mixin.mixins;

import org.spongepowered.asm.mixin.*;
import net.minecraft.client.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import com.google.common.base.*;
import com.memphis.revenge.manager.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ Minecraft.class })
public class MixinMinecraft
{
    @Inject(method = { "shutdown" }, at = { @At("HEAD") })
    public void onShutdown(final CallbackInfo ci) {
        final Stopwatch watch = Stopwatch.createStarted();
        S1ashConfigManager.save();
        System.out.printf("revenge save config took %sms", watch.stop());
    }
}
