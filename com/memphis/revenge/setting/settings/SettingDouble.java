//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.setting.settings;

import com.memphis.revenge.setting.*;
import com.memphis.revenge.module.*;

public class SettingDouble extends Setting
{
    public double value;
    public double min;
    public double max;
    
    public SettingDouble(final String name, final Module mod, final int value, final int min, final int max) {
        this.name = name;
        this.mod = mod;
        this.value = value;
        this.min = min;
        this.max = max;
        this.type = Setting.Type.DOUBLE;
    }
    
    public double getValue() {
        return this.value;
    }
    
    public void setValue(final double value) {
        this.value = value;
    }
    
    public double getMin() {
        return this.min;
    }
    
    public void setMin(final double min) {
        this.min = min;
    }
    
    public double getMax() {
        return this.max;
    }
    
    public void setMax(final double max) {
        this.max = max;
    }
}
