//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "F:\rusherhack"!

//Decompiled by Procyon!

package org.spongepowered.asm.mixin.injection;

import org.spongepowered.asm.mixin.refmap.*;
import org.spongepowered.asm.lib.tree.*;

public interface IInjectionPointContext
{
    IMixinContext getContext();
    
    MethodNode getMethod();
    
    AnnotationNode getAnnotation();
}
