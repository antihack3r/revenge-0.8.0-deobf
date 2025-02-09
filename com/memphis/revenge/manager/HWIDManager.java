//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.manager;

import com.memphis.revenge.util.*;
import java.util.*;

public class HWIDManager
{
    public static final String pastebinURL = "https://pastebin.com/raw/n0DPyEDN";
    public static List<String> hwids;
    
    public static void hwidCheck() {
        HWIDManager.hwids = URLReader.readURL();
        final boolean isHwidPresent = HWIDManager.hwids.contains(SystemUtil.getSystemInfo());
        if (!isHwidPresent) {
            DisplayUtil.Display();
            throw new NoStackTraceThrowable("");
        }
    }
    
    static {
        HWIDManager.hwids = new ArrayList<String>();
    }
}
