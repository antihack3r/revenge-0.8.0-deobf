//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.module.modules.main;

import com.memphis.revenge.module.*;
import com.memphis.revenge.setting.settings.*;
import net.minecraftforge.client.event.*;
import com.memphis.revenge.*;
import net.minecraft.client.multiplayer.*;
import java.text.*;
import java.util.*;
import java.awt.*;
import com.memphis.revenge.util.*;
import net.minecraft.client.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class Hud extends Module
{
    SettingBoolean csgowatermark;
    SettingBoolean watermark;
    SettingBoolean greeter;
    SettingBoolean ping;
    SettingBoolean fps;
    
    public Hud() {
        super("Hud", "wow", 0, Module.Category.MAIN);
        this.csgowatermark = this.register("CSGOWatermark", true);
        this.watermark = this.register("Watermark", true);
        this.greeter = this.register("Greeter", true);
        this.ping = this.register("Ping", true);
        this.fps = this.register("Fps", true);
    }
    
    @SubscribeEvent
    public void renderOverlay(final RenderGameOverlayEvent event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.HOTBAR && this.csgowatermark.getValue()) {
            final String ping = Revenge.serverManager.getPing() + "MS ";
            final String server = Hud.mc.isSingleplayer() ? "singleplayer".toUpperCase() : Objects.requireNonNull(Hud.mc.getCurrentServerData()).serverIP.toUpperCase();
            final String time = new SimpleDateFormat("h:mma").format(new Date());
            final String text = " Revenge | " + time + " | " + server + " | " + ping;
            final float width = (float)(Revenge.fontManager.getStringWidth(text) + 6);
            final int height = 20;
            final int posX = 2;
            final int posY = 2;
            RenderUtil.drawRect(posX, posY, posX + width + 2.0f, posY + height, new Color(5, 5, 5, 255).getRGB());
            RenderUtil.drawBorderedRect(posX + 0.5, posY + 0.5, posX + width + 1.5, posY + height - 0.5, 0.5, new Color(40, 40, 40, 255).getRGB(), new Color(60, 60, 60, 255).getRGB(), true);
            RenderUtil.drawBorderedRect(posX + 2, posY + 2, posX + width, posY + height - 2, 0.5, new Color(22, 22, 22, 255).getRGB(), new Color(60, 60, 60, 255).getRGB(), true);
            RenderUtil.drawRect(posX + 2.5, posY + 2.5, posX + width - 0.5, posY + 4.5, new Color(9, 9, 9, 255).getRGB());
            RenderUtil.drawGradientSideways(4.0, posY + 3, 4.0f + width / 3.0f, posY + 4, new Color(81, 149, 219, 255).getRGB(), new Color(180, 49, 218, 255).getRGB());
            RenderUtil.drawGradientSideways(4.0f + width / 3.0f, posY + 3, 4.0f + width / 3.0f * 2.0f, posY + 4, new Color(180, 49, 218, 255).getRGB(), new Color(236, 93, 128, 255).getRGB());
            RenderUtil.drawGradientSideways(4.0f + width / 3.0f * 2.0f, posY + 3, width / 3.0f * 3.0f + 1.0f, posY + 4, new Color(236, 93, 128, 255).getRGB(), new Color(235, 255, 0, 255).getRGB());
            Revenge.fontManager.drawStringWithShadow(text, (float)(4 + posX), (float)(8 + posY), -1);
        }
        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            if (this.greeter.getValue()) {
                Revenge.fontManager.drawStringWithShadow("Welcome to Revenge, " + Hud.mc.player.getName(), 410.0f, 2.0f, -51);
            }
            int i = -8;
            if (this.watermark.getValue()) {
                i += 10;
                Revenge.fontManager.drawStringWithShadow("Revenge - 0.8.0-build842210eb", 2.0f, (float)i, -51);
            }
            if (this.ping.getValue()) {
                i += 10;
                final String ping2 = "Ping " + Revenge.serverManager.getPing();
                Revenge.fontManager.drawStringWithShadow(ping2, 2.0f, (float)i, -51);
            }
            if (this.fps.getValue()) {
                i += 10;
                final String fps = "FPS " + Minecraft.debugFPS;
                Revenge.fontManager.drawStringWithShadow(fps, 2.0f, (float)i, -51);
            }
        }
    }
}
