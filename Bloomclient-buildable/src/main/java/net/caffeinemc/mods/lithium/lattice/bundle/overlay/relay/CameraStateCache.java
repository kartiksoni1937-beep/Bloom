/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.render.Camera
 *  net.minecraft.entity.Entity
 *  net.minecraft.world.World
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.caffeinemc.mods.lithium.lattice.bundle.overlay.relay;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.SyncDispatcher;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.LockD;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.NodeFilterCache;
import net.minecraft.client.render.Camera;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={Camera.class})
public abstract class CameraStateCache {
    @Shadow
    private boolean thirdPerson;

    @Shadow
    protected abstract void setPos(double var1, double var3, double var5);

    @Shadow
    protected abstract void setRotation(float var1, float var2);

    @Inject(method={"update(Lnet/minecraft/world/World;Lnet/minecraft/entity/Entity;ZZF)V"}, at={@At(value="RETURN")}, require=0)
    private void a(World var1, Entity var2, boolean var3, boolean var4, float var5, CallbackInfo var6) {
        if (ConfigBridge.c != null && LockD.g) {
            try {
                SyncDispatcher var7;
                if (!ConfigBridge.c.a() || (var7 = ConfigBridge.c.c()) == null) {
                    return;
                }
                NodeFilterCache var8 = var7.a(NodeFilterCache.class);
                if (var8 == null || !var8.f() || !var8.d_r26()) {
                    return;
                }
                this.setRotation(var8.f_r28(), var8.g_r29());
                this.setPos(var8.h(var5), var8.i(var5), var8.j(var5));
                this.thirdPerson = true;
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }
}
