//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.lukflug.panelstudio.hud;

import java.awt.*;

public interface HUDList
{
    int getSize();
    
    String getItem(final int p0);
    
    Color getItemColor(final int p0);
    
    boolean sortUp();
    
    boolean sortRight();
}
