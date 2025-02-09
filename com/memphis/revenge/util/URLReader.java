//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.util;

import java.util.*;
import java.net.*;
import java.io.*;

public class URLReader
{
    public static List<String> readURL() {
        final List<String> s = new ArrayList<String>();
        try {
            final URL url = new URL("https://pastebin.com/raw/n0DPyEDN");
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            String hwid;
            while ((hwid = bufferedReader.readLine()) != null) {
                s.add(hwid);
            }
        }
        catch (Exception ex) {}
        return s;
    }
}
