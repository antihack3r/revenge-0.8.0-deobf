//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.lukflug.panelstudio;

import java.awt.*;

public interface FixedComponent extends Component
{
    Point getPosition(final Interface p0);
    
    void setPosition(final Interface p0, final Point p1);
    
    int getWidth(final Interface p0);
    
    void saveConfig(final Interface p0, final PanelConfig p1);
    
    void loadConfig(final Interface p0, final PanelConfig p1);
}
