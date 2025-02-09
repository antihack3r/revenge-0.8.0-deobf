//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package com.memphis.revenge.module.modules.player;

import com.memphis.revenge.module.*;
import net.minecraftforge.fml.common.gameevent.*;
import me.zero.alpine.listener.*;
import java.util.function.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.player.*;
import org.lwjgl.input.*;
import com.memphis.revenge.manager.*;
import com.memphis.revenge.command.*;

public class MCF extends Module
{
    @EventHandler
    private final Listener<InputEvent.MouseInputEvent> listener;
    
    public MCF() {
        super("MCF", "Middle click friend.", 0, Module.Category.PLAYER);
        this.listener = (Listener<InputEvent.MouseInputEvent>)new Listener(event -> {
            if (MCF.mc.objectMouseOver.typeOfHit.equals((Object)RayTraceResult.Type.ENTITY) && MCF.mc.objectMouseOver.entityHit instanceof EntityPlayer && Mouse.isButtonDown(2)) {
                if (S1ashFriendsManager.isFriend(MCF.mc.objectMouseOver.entityHit.getName())) {
                    S1ashFriendsManager.removeFriend(MCF.mc.objectMouseOver.entityHit.getName());
                    Messages.sendClientMessage(new String[] { "removed friend: " + MCF.mc.objectMouseOver.entityHit.getName() });
                }
                else {
                    S1ashFriendsManager.addFriend(MCF.mc.objectMouseOver.entityHit.getName());
                    Messages.sendSilentMessage(new String[] { "added friend: " + MCF.mc.objectMouseOver.entityHit.getName() });
                }
            }
        }, new Predicate[0]);
    }
}
