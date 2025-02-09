//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.mixin.mixins;

import org.spongepowered.asm.mixin.*;
import net.minecraft.client.gui.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import com.memphis.revenge.*;
import net.minecraft.util.text.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ GuiMainMenu.class })
public class MixinGuiMainMenu extends GuiScreen
{
    @Inject(method = { "drawScreen" }, at = { @At("TAIL") }, cancellable = true)
    public void drawText(final CallbackInfo ci) {
        Revenge.fontManager.drawStringWithShadow(TextFormatting.WHITE + "revenge " + TextFormatting.GRAY + "0.8.0-build842210eb", 1.0f, 1.0f, -51);
    }
}
