//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.gui;

import net.minecraft.client.gui.*;
import java.util.*;
import com.memphis.revenge.module.*;
import java.awt.*;
import com.memphis.revenge.*;
import com.memphis.revenge.setting.settings.*;
import com.memphis.revenge.setting.*;

public class Screen extends GuiScreen
{
    public static final Point MOUSE;
    private final List<IComponent> PANELS;
    
    public Screen() {
        this.PANELS = new ArrayList<IComponent>();
        final Point offset = new Point(10, 10);
        for (final Module.Category cat : Module.Category.values()) {
            final PanelComponent panel = new PanelComponent(new Rectangle(new Point(offset), new Dimension(100, 10)), cat.name());
            final Revenge instance = Revenge.instance;
            final ModuleComponent module;
            final Revenge instance2;
            final ModuleComponent moduleComponent;
            final PanelComponent panelComponent;
            Revenge.moduleManager.getModsInCategory(cat).forEach(m -> {
                module = new ModuleComponent(m);
                instance2 = Revenge.instance;
                Revenge.settingsManager.getSettingsInMod(m).forEach(s -> {
                    switch (s.getType()) {
                        case INTEGER: {
                            moduleComponent.addChild((IComponent)new SliderInteger((SettingInteger)s));
                            break;
                        }
                        case BOOLEAN: {
                            moduleComponent.addChild((IComponent)new BooleanComponent((SettingBoolean)s));
                            break;
                        }
                        case DOUBLE: {
                            moduleComponent.addChild((IComponent)new SliderDouble((SettingDouble)s));
                            break;
                        }
                        case MODE: {
                            moduleComponent.addChild((IComponent)new ModeComponent((SettingMode)s));
                            break;
                        }
                    }
                    return;
                });
                module.addChild((IComponent)new KeybindComponent(m));
                panelComponent.addChild((IComponent)module);
                return;
            });
            this.PANELS.add((IComponent)panel);
            offset.translate(120, 0);
        }
    }
    
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
        Screen.MOUSE.setLocation(mouseX, mouseY);
        this.PANELS.forEach(IComponent::draw);
    }
    
    protected void mouseClicked(final int mouseX, final int mouseY, final int mouseButton) {
        Screen.MOUSE.setLocation(mouseX, mouseY);
        this.PANELS.forEach(p -> p.handleButton(mouseButton));
    }
    
    protected void mouseReleased(final int mouseX, final int mouseY, final int state) {
        Screen.MOUSE.setLocation(mouseX, mouseY);
        this.PANELS.forEach(p -> p.handleButton(-1));
    }
    
    protected void keyTyped(final char typedChar, final int keyCode) {
        if (keyCode == 1) {
            this.mc.displayGuiScreen((GuiScreen)null);
        }
        this.PANELS.forEach(p -> p.keyTyped(keyCode, typedChar));
    }
    
    static {
        MOUSE = new Point();
    }
}
