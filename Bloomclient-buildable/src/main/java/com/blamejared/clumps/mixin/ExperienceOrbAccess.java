/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.ExperienceOrbEntity
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package com.blamejared.clumps.mixin;

import net.minecraft.entity.ExperienceOrbEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={ExperienceOrbEntity.class})
public interface ExperienceOrbAccess {
    @Accessor(value="orbAge")
    public int clumps$getAge();

    @Accessor(value="orbAge")
    public void clumps$setAge(int var1);

    @Accessor(value="pickingCount")
    public void clumps$setCount(int var1);
}
