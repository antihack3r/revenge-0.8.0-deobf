//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.util;

public class Timer
{
    private long time;
    
    public Timer() {
        this.time = -1L;
    }
    
    public long getMs(final long time) {
        return time / 1000000L;
    }
    
    public boolean passedMs(final long ms) {
        return this.getMs(System.nanoTime() - this.time) >= ms;
    }
    
    public void reset() {
        this.time = System.nanoTime();
    }
}
