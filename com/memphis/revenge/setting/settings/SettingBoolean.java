//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.setting.settings;

import com.memphis.revenge.setting.*;
import com.memphis.revenge.module.*;

public class SettingBoolean extends Setting
{
    public boolean value;
    
    public SettingBoolean(final String name, final Module mod, final Boolean value) {
        this.name = name;
        this.mod = mod;
        this.value = value;
        this.type = Setting.Type.BOOLEAN;
    }
    
    public boolean getValue() {
        return this.value;
    }
    
    public void setValue(final boolean value) {
        this.value = value;
    }
}
