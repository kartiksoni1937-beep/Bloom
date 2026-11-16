/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.render.SkyRendering
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.ModifyVariable
 */
package net.caffeinemc.mods.lithium.lattice.bundle.overlay.relay;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.FieldVolumeCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.ShellArrayCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.LerpZoneBuffer;
import net.minecraft.client.render.SkyRendering;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value={SkyRendering.class})
public class RenderSkyState {
    @ModifyVariable(method={"renderSun(FLnet/minecraft/client/util/math/MatrixStack;)V"}, at=@At(value="HEAD"), argsOnly=true, ordinal=0, require=0)
    private float a(float var1) {
        try {
            FieldVolumeCache.dy = true;
            FieldVolumeCache.dz = true;
            FieldVolumeCache.ea = var1;
            return LerpZoneBuffer.IDLE ? var1 : var1 * FieldVolumeCache.c();
        }
        catch (Throwable var3) {
            return var1;
        }
    }

    @ModifyVariable(method={"renderMoon(Lnet/minecraft/world/MoonPhase;FLnet/minecraft/client/util/math/MatrixStack;)V"}, at=@At(value="HEAD"), argsOnly=true, ordinal=0, require=0)
    private float b(float var1) {
        try {
            if (LerpZoneBuffer.IDLE) {
                return var1;
            }
            float var2 = ShellArrayCache.ao;
            return var2 > 0.0f ? var1 * (1.0f - (var2 > 1.0f ? 1.0f : var2)) : var1;
        }
        catch (Throwable var3) {
            return var1;
        }
    }
}
