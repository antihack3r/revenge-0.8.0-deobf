//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.util;

import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.vertex.*;
import org.lwjgl.opengl.*;

public class RenderUtil implements Global
{
    private static final BufferBuilder bufferbuilder;
    private static final Tessellator tessellator;
    
    public static void drawRect(double left, double top, double right, double bottom, final int color) {
        if (left < right) {
            final double i = left;
            left = right;
            right = i;
        }
        if (top < bottom) {
            final double j = top;
            top = bottom;
            bottom = j;
        }
        final float f3 = (color >> 24 & 0xFF) / 255.0f;
        final float f4 = (color >> 16 & 0xFF) / 255.0f;
        final float f5 = (color >> 8 & 0xFF) / 255.0f;
        final float f6 = (color & 0xFF) / 255.0f;
        final Tessellator tessellator = Tessellator.getInstance();
        final BufferBuilder bufferBuilder = tessellator.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.color(f4, f5, f6, f3);
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION);
        bufferBuilder.pos(left, bottom, 0.0).endVertex();
        bufferBuilder.pos(right, bottom, 0.0).endVertex();
        bufferBuilder.pos(right, top, 0.0).endVertex();
        bufferBuilder.pos(left, top, 0.0).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }
    
    public static void drawBorderedRect(final double left, final double top, final double right, final double bottom, final double borderWidth, final int insideColor, final int borderColor, final boolean borderIncludedInBounds) {
        drawRect(left - (borderIncludedInBounds ? 0.0 : borderWidth), top - (borderIncludedInBounds ? 0.0 : borderWidth), right + (borderIncludedInBounds ? 0.0 : borderWidth), bottom + (borderIncludedInBounds ? 0.0 : borderWidth), borderColor);
        drawRect(left + (borderIncludedInBounds ? borderWidth : 0.0), top + (borderIncludedInBounds ? borderWidth : 0.0), right - (borderIncludedInBounds ? borderWidth : 0.0), bottom - (borderIncludedInBounds ? borderWidth : 0.0), insideColor);
    }
    
    public static void drawGradientSideways(final double left, final double top, final double right, final double bottom, final int col1, final int col2) {
        final float f = (col1 >> 24 & 0xFF) / 255.0f;
        final float f2 = (col1 >> 16 & 0xFF) / 255.0f;
        final float f3 = (col1 >> 8 & 0xFF) / 255.0f;
        final float f4 = (col1 & 0xFF) / 255.0f;
        final float f5 = (col2 >> 24 & 0xFF) / 255.0f;
        final float f6 = (col2 >> 16 & 0xFF) / 255.0f;
        final float f7 = (col2 >> 8 & 0xFF) / 255.0f;
        final float f8 = (col2 & 0xFF) / 255.0f;
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glShadeModel(7425);
        GL11.glPushMatrix();
        GL11.glBegin(7);
        GL11.glColor4f(f2, f3, f4, f);
        GL11.glVertex2d(left, top);
        GL11.glVertex2d(left, bottom);
        GL11.glColor4f(f6, f7, f8, f5);
        GL11.glVertex2d(right, bottom);
        GL11.glVertex2d(right, top);
        GL11.glEnd();
        GL11.glPopMatrix();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
    }
    
    public static void drawBorderedRect(final int left, final double top, final int right, final double bottom, final int borderWidth, int insideColor, int borderColor, final boolean hover) {
        if (hover) {
            insideColor = ColourUtil.shadeColour(insideColor, -20);
            borderColor = ColourUtil.shadeColour(borderColor, -20);
        }
        drawRectBase(left + borderWidth, top + borderWidth, right - borderWidth, bottom - borderWidth, insideColor);
        drawRectBase(left, top + borderWidth, left + borderWidth, bottom - borderWidth, borderColor);
        drawRectBase(right - borderWidth, top + borderWidth, right, bottom - borderWidth, borderColor);
        drawRectBase(left, top, right, top + borderWidth, borderColor);
        drawRectBase(left, bottom - borderWidth, right, bottom, borderColor);
    }
    
    public static void drawSidewaysGradientRect(final int left, final int top, final int right, final int bottom, final int startColor, final int endColor) {
        final float c = (startColor >> 24 & 0xFF) / 255.0f;
        final float c2 = (startColor >> 16 & 0xFF) / 255.0f;
        final float c3 = (startColor >> 8 & 0xFF) / 255.0f;
        final float c4 = (startColor & 0xFF) / 255.0f;
        final float c5 = (endColor >> 24 & 0xFF) / 255.0f;
        final float c6 = (endColor >> 16 & 0xFF) / 255.0f;
        final float c7 = (endColor >> 8 & 0xFF) / 255.0f;
        final float c8 = (endColor & 0xFF) / 255.0f;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel(7425);
        final Tessellator tessellator = Tessellator.getInstance();
        final BufferBuilder bufferbuilder = tessellator.getBuffer();
        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
        bufferbuilder.pos((double)right, (double)top, 0.0).color(c2, c3, c4, c).endVertex();
        bufferbuilder.pos((double)left, (double)top, 0.0).color(c6, c7, c8, c5).endVertex();
        bufferbuilder.pos((double)left, (double)bottom, 0.0).color(c6, c7, c8, c5).endVertex();
        bufferbuilder.pos((double)right, (double)bottom, 0.0).color(c2, c3, c4, c).endVertex();
        tessellator.draw();
        GlStateManager.shadeModel(7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }
    
    public static void drawHLineG(final int x, final int y, final int length, final int color, final int color2) {
        drawSidewaysGradientRect(x, y, x + length, y + 1, color, color2);
    }
    
    public static void drawRectBase(int left, double top, double right, double bottom, final int color) {
        if (left < right) {
            final double side = left;
            left = (int)right;
            right = (int)side;
        }
        if (top < bottom) {
            final double side = top;
            top = bottom;
            bottom = side;
        }
        GlStateManager.enableBlend();
        GL11.glDisable(3042);
        GL11.glDisable(3008);
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.color((color >> 16 & 0xFF) / 255.0f, (color >> 8 & 0xFF) / 255.0f, (color & 0xFF) / 255.0f, (color >> 24 & 0xFF) / 255.0f);
        RenderUtil.bufferbuilder.begin(7, DefaultVertexFormats.POSITION);
        RenderUtil.bufferbuilder.pos((double)left, bottom, 0.0).endVertex();
        RenderUtil.bufferbuilder.pos(right, bottom, 0.0).endVertex();
        RenderUtil.bufferbuilder.pos(right, top, 0.0).endVertex();
        RenderUtil.bufferbuilder.pos((double)left, top, 0.0).endVertex();
        RenderUtil.tessellator.draw();
        GL11.glEnable(3042);
        GL11.glEnable(3008);
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }
    
    static {
        bufferbuilder = Tessellator.getInstance().getBuffer();
        tessellator = Tessellator.getInstance();
    }
}
