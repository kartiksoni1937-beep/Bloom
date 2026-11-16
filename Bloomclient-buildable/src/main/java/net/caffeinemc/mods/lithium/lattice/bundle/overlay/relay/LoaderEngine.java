/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.buffers.GpuBufferSlice
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.render.Camera
 *  net.minecraft.client.render.RenderTickCounter
 *  net.minecraft.client.render.WorldRenderer
 *  net.minecraft.client.util.ObjectAllocator
 *  org.joml.Matrix4f
 *  org.joml.Vector4f
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.caffeinemc.mods.lithium.lattice.bundle.overlay.relay;

import com.mojang.blaze3d.buffers.GpuBufferSlice;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.BoundQuadCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.CoreOptimizer;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.NodeCacheGroup;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.ViewContextHandler;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.ObjectAllocator;
import org.joml.Matrix4f;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={WorldRenderer.class})
public class LoaderEngine {
    @Inject(method={"render(Lnet/minecraft/n;Lnet/minecraft/n;ZLnet/minecraft/n;Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;Lcom/mojang/blaze3d/buffers/GpuBufferSlice;Lorg/joml/Vector4f;Z)V"}, at={@At(value="HEAD")})
    private void a(ObjectAllocator var1, RenderTickCounter var2, boolean var3, Camera var4, Matrix4f var5, Matrix4f var6, Matrix4f var7, GpuBufferSlice var8, Vector4f var9, boolean var10, CallbackInfo var11) {
        CoreOptimizer.a(var6, var5);
        if (ConfigBridge.c != null && BoundQuadCache.OL && System.identityHashCode(MinecraftClient.getInstance().world) != BoundQuadCache.OWID) {
            BoundQuadCache.OL = false;
        }
    }

    @Inject(method={"render(Lnet/minecraft/n;Lnet/minecraft/n;ZLnet/minecraft/n;Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;Lcom/mojang/blaze3d/buffers/GpuBufferSlice;Lorg/joml/Vector4f;Z)V"}, at={@At(value="TAIL")})
    private void b(ObjectAllocator var1, RenderTickCounter var2, boolean var3, Camera var4, Matrix4f var5, Matrix4f var6, Matrix4f var7, GpuBufferSlice var8, Vector4f var9, boolean var10, CallbackInfo var11) {
        if (ConfigBridge.c != null) {
            boolean var12 = NodeCacheGroup.RUN;
            boolean var13 = ViewContextHandler.RUN;
            if (var12 || var13) {
                boolean var14;
                try {
                    var14 = ConfigBridge.c.a();
                }
                catch (Throwable var18) {
                    return;
                }
                if (var14) {
                    if (var12) {
                        try {
                            NodeCacheGroup.a(var6, var5);
                        }
                        catch (Throwable throwable) {
                            // empty catch block
                        }
                    }
                    if (var13) {
                        try {
                            ViewContextHandler.a(var6, var5);
                        }
                        catch (Throwable throwable) {
                            // empty catch block
                        }
                    }
                }
            }
        }
    }
}
