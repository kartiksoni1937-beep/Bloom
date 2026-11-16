/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.decoration.DisplayEntity$TextDisplayEntity
 *  net.minecraft.entity.decoration.DisplayEntity$TextDisplayEntity$LineSplitter
 *  net.minecraft.entity.decoration.DisplayEntity$TextDisplayEntity$TextLines
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.caffeinemc.mods.lithium.lattice.bundle.overlay.relay;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.ProfileTextCache;
import net.minecraft.entity.decoration.DisplayEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={DisplayEntity.TextDisplayEntity.class})
public abstract class TextDisplayCache {
    @Shadow
    private DisplayEntity.TextDisplayEntity.TextLines textLines;
    @Unique
    private int b;

    @Inject(method={"splitLines(Lnet/minecraft/entity/decoration/DisplayEntity$TextDisplayEntity$LineSplitter;)Lnet/minecraft/entity/decoration/DisplayEntity$TextDisplayEntity$TextLines;"}, at={@At(value="HEAD")})
    private void a(DisplayEntity.TextDisplayEntity.LineSplitter var1, CallbackInfoReturnable<DisplayEntity.TextDisplayEntity.TextLines> var2) {
        int var3 = ProfileTextCache.GEN;
        if (this.b != var3) {
            this.b = var3;
            this.textLines = null;
        }
    }
}
