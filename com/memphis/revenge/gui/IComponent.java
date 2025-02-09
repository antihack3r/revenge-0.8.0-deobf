//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.gui;

import net.minecraft.client.gui.*;
import java.awt.*;
import net.minecraft.client.renderer.*;
import com.memphis.revenge.*;

public interface IComponent
{
    void draw();
    
    void handleButton(final int p0);
    
    void keyTyped(final int p0, final char p1);
    
    int getAbsoluteHeight();
    
    void addChild(final IComponent p0);
    
    Rectangle getRect();
    
    void setRect(final Rectangle p0);
    
    default void fillRect(final Rectangle rect, final Color color) {
        Gui.drawRect(rect.x, rect.y, rect.x + rect.width, rect.y + rect.height, color.getRGB());
    }
    
    default void drawString(final String text, final Point pos, final Color color) {
        GlStateManager.enableTexture2D();
        Revenge.fontManager.drawStringWithShadow(text, (float)pos.x, (float)pos.y, color.getRGB());
        GlStateManager.disableTexture2D();
    }
}
