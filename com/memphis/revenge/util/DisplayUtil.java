//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.util;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.*;

public class DisplayUtil
{
    public static void Display() {
        final Frame frame = new Frame();
        frame.setVisible(false);
        throw new NoStackTraceThrowable("Verification was unsuccessful!");
    }
    
    public static class Frame extends JFrame
    {
        public Frame() {
            this.setTitle("Verification failed.");
            this.setDefaultCloseOperation(2);
            this.setLocationRelativeTo(null);
            copyToClipboard();
            final String message = "Sorry, you are not on the HWID list.\nHWID: " + SystemUtil.getSystemInfo() + "\n(Copied to clipboard.)";
            JOptionPane.showMessageDialog(this, message, "Could not verify your HWID successfully.", -1, UIManager.getIcon("OptionPane.errorIcon"));
        }
        
        public static void copyToClipboard() {
            final StringSelection selection = new StringSelection(SystemUtil.getSystemInfo());
            final Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(selection, selection);
        }
    }
}
