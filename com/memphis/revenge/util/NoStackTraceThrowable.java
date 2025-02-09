//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.util;

public class NoStackTraceThrowable extends RuntimeException
{
    public NoStackTraceThrowable(final String msg) {
        super(msg);
        this.setStackTrace(new StackTraceElement[0]);
    }
    
    @Override
    public String toString() {
        return "0.8.0-build842210eb";
    }
    
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
