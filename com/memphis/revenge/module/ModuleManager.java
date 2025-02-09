//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.module;

import net.minecraftforge.common.*;
import com.memphis.revenge.module.modules.render.*;
import com.memphis.revenge.module.modules.movement.*;
import com.memphis.revenge.module.modules.misc.*;
import com.memphis.revenge.module.modules.player.*;
import com.memphis.revenge.module.modules.main.*;
import com.memphis.revenge.module.modules.combat.*;
import java.util.*;
import org.lwjgl.input.*;
import net.minecraftforge.fml.common.eventhandler.*;
import net.minecraftforge.fml.common.gameevent.*;
import net.minecraft.client.*;
import net.minecraftforge.client.event.*;

public class ModuleManager
{
    public ArrayList<Module> modules;
    
    public ModuleManager() {
        this.modules = new ArrayList<Module>();
        MinecraftForge.EVENT_BUS.register((Object)this);
        this.init();
    }
    
    public void init() {
        this.modules.add(new ClickGuiModule());
        this.modules.add(new FakePlayer());
        this.modules.add(new IceSpeed());
        this.modules.add(new ReverseStep());
        this.modules.add(new Step());
        this.modules.add(new Sprint());
        this.modules.add(new Velocity());
        this.modules.add(new AutoWalk());
        this.modules.add(new ChorusBlink());
        this.modules.add(new FullBright());
        this.modules.add(new Gamemode());
        this.modules.add(new AutoRespawn());
        this.modules.add(new AntiHunger());
        this.modules.add(new CustomTime());
        this.modules.add(new AutoFish());
        this.modules.add(new FastBow());
        this.modules.add(new AntiVoid());
        this.modules.add(new SoundRemover());
        this.modules.add(new NoRender());
        this.modules.add(new FastPlace());
        this.modules.add(new ChestStealer());
        this.modules.add(new EntitySpeed());
        this.modules.add(new Vanish());
        this.modules.add(new BoatPlace());
        this.modules.add(new MCP());
        this.modules.add(new KillAura());
        this.modules.add(new Hud());
        this.modules.add(new CustomFont());
        this.modules.add(new CustomFOV());
        this.modules.add(new HotbarRefill());
        this.modules.add(new SilentEXP());
        this.modules.add(new MCF());
        this.modules.add(new Surround());
        this.modules.add(new GUIBlur());
        this.modules.add(new AutoTotem());
    }
    
    public ArrayList<Module> getModules() {
        return this.modules;
    }
    
    public Module getModule(final String name) {
        for (final Module m : this.modules) {
            if (m.getName().equalsIgnoreCase(name)) {
                return m;
            }
        }
        return null;
    }
    
    public ArrayList<Module> getModsInCategory(final Module.Category cat) {
        final ArrayList<Module> mods = new ArrayList<Module>();
        for (final Module m : this.modules) {
            if (m.getCategory() == cat) {
                mods.add(m);
            }
        }
        return mods;
    }
    
    @SubscribeEvent
    public void onKey(final InputEvent.KeyInputEvent event) {
        if (Keyboard.getEventKeyState()) {
            for (final Module m : this.modules) {
                if (m.getKey() == Keyboard.getEventKey()) {
                    m.toggle();
                }
            }
        }
    }
    
    @SubscribeEvent
    public void onTick(final TickEvent.ClientTickEvent event) {
        if (Minecraft.getMinecraft().player == null || Minecraft.getMinecraft().world == null) {
            return;
        }
        for (final Module m : this.modules) {
            if (m.isToggled()) {
                m.update();
            }
        }
    }
    
    @SubscribeEvent
    public void onRender(final RenderWorldLastEvent event) {
        for (final Module m : this.modules) {
            if (m.isToggled()) {
                m.render();
            }
        }
    }
}
