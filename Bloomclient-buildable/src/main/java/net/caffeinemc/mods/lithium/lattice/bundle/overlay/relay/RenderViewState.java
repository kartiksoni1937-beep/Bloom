/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.render.GameRenderer
 *  org.joml.Matrix4f
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyArg
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.caffeinemc.mods.lithium.lattice.bundle.overlay.relay;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.element.FrameKeeper;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.SyncDispatcher;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.LockD;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.NodeFilterCache;
import net.minecraft.client.render.GameRenderer;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={GameRenderer.class})
public class RenderViewState {
    @ModifyArg(method={"renderWorld(Lnet/minecraft/client/render/RenderTickCounter;)V"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/render/WorldRenderer;render(Lnet/minecraft/client/util/ObjectAllocator;Lnet/minecraft/client/render/RenderTickCounter;ZLnet/minecraft/client/render/Camera;Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;Lcom/mojang/blaze3d/buffers/GpuBufferSlice;Lorg/joml/Vector4f;Z)V"), index=4, require=0)
    private Matrix4f a(Matrix4f var1) {
        if (FrameKeeper.ag) {
            try {
                var1.get(FrameKeeper.VIEW);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        return var1;
    }

    @ModifyArg(method={"renderWorld(Lnet/minecraft/client/render/RenderTickCounter;)V"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/render/WorldRenderer;render(Lnet/minecraft/client/util/ObjectAllocator;Lnet/minecraft/client/render/RenderTickCounter;ZLnet/minecraft/client/render/Camera;Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;Lcom/mojang/blaze3d/buffers/GpuBufferSlice;Lorg/joml/Vector4f;Z)V"), index=5, require=0)
    private Matrix4f b(Matrix4f var1) {
        if (FrameKeeper.ag) {
            try {
                var1.get(FrameKeeper.PROJ);
                FrameKeeper.ai = true;
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        return var1;
    }

    @Inject(method={"renderHand(FZLorg/joml/Matrix4f;)V"}, at={@At(value="HEAD")}, cancellable=true, require=0)
    private void c(float var1, boolean var2, Matrix4f var3, CallbackInfo var4) {
        if (ConfigBridge.c != null && LockD.g) {
            try {
                NodeFilterCache var6;
                SyncDispatcher var5;
                if (ConfigBridge.c.a() && (var5 = ConfigBridge.c.c()) != null && (var6 = var5.a(NodeFilterCache.class)) != null && var6.f() && var6.d_r26()) {
                    var4.cancel();
                }
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }
}
