/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Mouse
 *  net.minecraft.client.input.MouseInput
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 *  org.spongepowered.asm.mixin.gen.Invoker
 */
package net.caffeinemc.mods.lithium.lattice.bundle.overlay.element;

import net.minecraft.client.Mouse;
import net.minecraft.client.input.MouseInput;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value={Mouse.class})
public interface SortableComposer {
    @Invoker(value="onMouseButton")
    public void iOMB(long var1, MouseInput var3, int var4);

    @Accessor(value="cursorDeltaX")
    public double g3Dx();

    @Accessor(value="cursorDeltaY")
    public double g3Dy();

    @Accessor(value="x")
    public void g3SetX(double var1);

    @Accessor(value="y")
    public void g3SetY(double var1);
}
