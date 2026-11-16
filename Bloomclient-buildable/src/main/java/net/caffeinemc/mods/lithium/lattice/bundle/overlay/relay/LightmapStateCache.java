/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.render.LightmapTextureManager
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyArg
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.caffeinemc.mods.lithium.lattice.bundle.overlay.relay;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.NodeZoneRenderer;
import net.minecraft.client.render.LightmapTextureManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={LightmapTextureManager.class})
public class LightmapStateCache {
    @Shadow
    private boolean dirty;
    @Unique
    private static float c;
    @Unique
    private static float d;
    @Unique
    private static float e;
    @Unique
    private static float f;
    @Unique
    private static boolean g;
    @Unique
    private static long h;

    @Inject(method={"update(F)V"}, at={@At(value="HEAD")}, require=0)
    private void a(float var1, CallbackInfo var2) {
        if (NodeZoneRenderer.FB_HOT) {
            try {
                boolean var3 = ConfigBridge.c != null && ConfigBridge.c.a();
                float var4 = var3 ? NodeZoneRenderer.FB_TA : 0.0f;
                float var5 = var3 ? NodeZoneRenderer.FB_TN : 0.0f;
                long var6 = System.nanoTime();
                float var8 = h == 0L ? 0.0f : (float)(var6 - h) / 1.0E9f;
                h = var6;
                if (var8 < 0.0f) {
                    var8 = 0.0f;
                }
                if (var8 > 0.1f) {
                    var8 = 0.1f;
                }
                if (!var3) {
                    c = 0.0f;
                    d = 0.0f;
                } else {
                    float var9 = 1.0f - (float)Math.exp(-9.0 * (double)var8);
                    if (Math.abs(var4 - (c += (var4 - c) * var9)) < 0.004f) {
                        c = var4;
                    }
                    if (Math.abs(var5 - (d += (var5 - d) * var9)) < 0.004f) {
                        d = var5;
                    }
                }
                NodeZoneRenderer.FB_AMB = c;
                NodeZoneRenderer.FB_NV = d;
                long l = NodeZoneRenderer.FB_LIVE = var6 == 0L ? 1L : var6;
                if (!g || c != e || d != f) {
                    this.dirty = true;
                    e = c;
                    f = d;
                    g = true;
                }
                if (var4 == 0.0f && var5 == 0.0f && c == 0.0f && d == 0.0f) {
                    NodeZoneRenderer.FB_HOT = false;
                    h = 0L;
                }
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }

    @ModifyArg(method={"update(F)V"}, at=@At(value="INVOKE", target="Lcom/mojang/blaze3d/buffers/Std140Builder;putFloat(F)Lcom/mojang/blaze3d/buffers/Std140Builder;", ordinal=3), index=0, require=0)
    private float b(float var1) {
        float var2 = NodeZoneRenderer.FB_NV;
        return var2 > var1 ? var2 : var1;
    }
}
