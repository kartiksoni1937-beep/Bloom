/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.hud.InGameHud
 *  net.minecraft.client.render.RenderTickCounter
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.caffeinemc.mods.lithium.lattice.bundle.overlay.relay;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.module.EventAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.RenderKernel;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.NoticeQueue;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.CoreZoneProcessor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.NodeZoneRenderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.RenderTickCounter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={InGameHud.class})
public class CacheDelegate {
    @Unique
    private static long g;
    @Unique
    private static boolean h;

    @Unique
    private static boolean a() {
        long var0 = System.nanoTime();
        if (!h || var0 - g > 2000000L || var0 - g < 0L) {
            h = ConfigBridge.c != null && ConfigBridge.c.a();
            g = var0;
        }
        return h;
    }

    @Inject(method={"render(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/client/render/RenderTickCounter;)V"}, at={@At(value="TAIL")})
    private void b(DrawContext var1, RenderTickCounter var2, CallbackInfo var3) {
        if (ConfigBridge.c != null && CacheDelegate.a()) {
            try {
                EventAdapter.a(new RenderKernel(var1));
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            try {
                CoreZoneProcessor.l(var1);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            if (NodeZoneRenderer.ON || NodeZoneRenderer.LINGER) {
                try {
                    NodeZoneRenderer.ck(var1);
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
            try {
                NoticeQueue.e(var1, MinecraftClient.getInstance().getWindow().getScaledWidth());
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }

    @Inject(method={"renderMainHud(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/client/render/RenderTickCounter;)V"}, at={@At(value="HEAD")}, cancellable=true, require=0)
    private void c(DrawContext var1, RenderTickCounter var2, CallbackInfo var3) {
        if (ConfigBridge.c != null && CoreZoneProcessor.HOTBAR_ON) {
            try {
                if (CacheDelegate.a() && CoreZoneProcessor.m(var1, var2)) {
                    var3.cancel();
                }
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }

    @Inject(method={"renderStatusEffectOverlay(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/client/render/RenderTickCounter;)V"}, at={@At(value="HEAD")}, cancellable=true, require=0)
    private void d(DrawContext var1, RenderTickCounter var2, CallbackInfo var3) {
        if (ConfigBridge.c != null && CoreZoneProcessor.POTIONS_ON) {
            try {
                if (CacheDelegate.a()) {
                    var3.cancel();
                }
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }

    @Inject(method={"renderOverlayMessage(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/client/render/RenderTickCounter;)V"}, at={@At(value="HEAD")}, require=0)
    private void e(DrawContext var1, RenderTickCounter var2, CallbackInfo var3) {
        float var4;
        CoreZoneProcessor.LIFT_PUSHED = false;
        if (ConfigBridge.c != null && CoreZoneProcessor.HOTBAR_ON && !((var4 = CoreZoneProcessor.ACTION_LIFT) <= 0.0f)) {
            try {
                if (CacheDelegate.a()) {
                    var1.getMatrices().pushMatrix();
                    CoreZoneProcessor.LIFT_PUSHED = true;
                    var1.getMatrices().translate(0.0f, -var4);
                }
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }

    @Inject(method={"renderOverlayMessage(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/client/render/RenderTickCounter;)V"}, at={@At(value="RETURN")}, require=0)
    private void f(DrawContext var1, RenderTickCounter var2, CallbackInfo var3) {
        if (CoreZoneProcessor.LIFT_PUSHED) {
            CoreZoneProcessor.LIFT_PUSHED = false;
            try {
                var1.getMatrices().popMatrix();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }
}
