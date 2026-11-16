/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.Mouse
 *  net.minecraft.client.gui.screen.ingame.InventoryScreen
 *  net.minecraft.client.network.ClientPlayerEntity
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.caffeinemc.mods.lithium.lattice.bundle.overlay.element;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.SyncDispatcher;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.FrameClockCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.LockD;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.ClickZoneResolver;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.NodeFilterCache;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={Mouse.class})
public class SortableData {
    @Inject(method={"onCursorPos(JDD)V"}, at={@At(value="HEAD")}, cancellable=true, require=0)
    private void a(long var1, double var3, double var5, CallbackInfo var7) {
        MinecraftClient var8;
        if (LockD.a && (var8 = MinecraftClient.getInstance()) != null && var8.currentScreen instanceof InventoryScreen && ConfigBridge.c != null && ConfigBridge.c.a()) {
            var7.cancel();
        }
    }

    @Redirect(method={"updateMouse(D)V"}, at=@At(value="INVOKE", target="Lnet/minecraft/n;changeLookDirection(DD)V"), require=0)
    private void b(ClientPlayerEntity var1, double var2, double var4) {
        if (System.nanoTime() >= LockD.b) {
            if (ConfigBridge.c != null && LockD.g) {
                try {
                    NodeFilterCache var7;
                    SyncDispatcher var6;
                    if (ConfigBridge.c.a() && (var6 = ConfigBridge.c.c()) != null && (var7 = var6.a(NodeFilterCache.class)) != null && var7.f() && var7.d_r26()) {
                        var7.c(var2, var4);
                        return;
                    }
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
            var1.changeLookDirection(var2, var4);
        }
    }

    @Inject(method={"updateMouse(D)V"}, at={@At(value="HEAD")}, require=0)
    private void c(double var1, CallbackInfo var3) {
        Runnable var11;
        Runnable var5;
        Runnable var4 = LockD.c;
        if (var4 != null) {
            try {
                var4.run();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (ConfigBridge.c != null && (var5 = LockD.e) != null) {
            try {
                if (ConfigBridge.c.a()) {
                    var5.run();
                }
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if ((var11 = LockD.d) != null) {
            try {
                if (ConfigBridge.c != null && ConfigBridge.c.a()) {
                    var11.run();
                }
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (LockD.h) {
            try {
                ClickZoneResolver.b();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }

    @Inject(method={"tick()V"}, at={@At(value="HEAD")}, require=0)
    private void d(CallbackInfo var1) {
        if (FrameClockCache.any) {
            try {
                FrameClockCache.e();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }
}
