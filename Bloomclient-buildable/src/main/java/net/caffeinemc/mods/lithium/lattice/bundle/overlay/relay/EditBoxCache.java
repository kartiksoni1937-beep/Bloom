/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.widget.EditBoxWidget
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.caffeinemc.mods.lithium.lattice.bundle.overlay.relay;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.ProfileTextCache;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.EditBoxWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={EditBoxWidget.class})
public abstract class EditBoxCache {
    @Inject(method={"renderContents(Lnet/minecraft/n;IIF)V"}, at={@At(value="HEAD")})
    private void a(DrawContext var1, int var2, int var3, float var4, CallbackInfo var5) {
        ProfileTextCache.EDIT = true;
    }

    @Inject(method={"renderContents(Lnet/minecraft/n;IIF)V"}, at={@At(value="RETURN")})
    private void b(DrawContext var1, int var2, int var3, float var4, CallbackInfo var5) {
        ProfileTextCache.EDIT = false;
    }
}
