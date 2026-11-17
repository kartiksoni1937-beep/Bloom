/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.network.ClientPlayerEntity
 *  net.minecraft.client.network.ClientPlayerInteractionManager
 *  net.minecraft.component.type.PiercingWeaponComponent
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.util.ActionResult
 *  net.minecraft.util.Hand
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.util.hit.EntityHitResult
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.caffeinemc.mods.lithium.lattice.bundle.overlay.relay;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.FrameClockCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.LockD;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.CoreCacheKeeper;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.NodeCacheGroup;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.NodeZoneRenderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.component.type.PiercingWeaponComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={ClientPlayerInteractionManager.class})
public class InteractionProbe {
    @Inject(method={"attackEntity(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/entity/Entity;)V"}, at={@At(value="HEAD")}, require=0)
    private void a(PlayerEntity var1, Entity var2, CallbackInfo var3) {
        NodeZoneRenderer var4 = null;
        try {
            FrameClockCache.l = var1.age;
            if (ConfigBridge.c == null || !ConfigBridge.c.a() || ConfigBridge.c.c() == null) {
                return;
            }
            LockD.f = System.nanoTime();
            if (NodeCacheGroup.RUN && var2 instanceof LivingEntity) {
                NodeCacheGroup.HIT_ID = var2.getId();
                NodeCacheGroup.HIT_NS = System.nanoTime();
            }
            if (NodeZoneRenderer.ON && (var4 = ConfigBridge.c.c().a(NodeZoneRenderer.class)) != null && var4.f()) {
                var4.bn(var2);
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    @Inject(method={"interactBlock(Lnet/minecraft/client/network/ClientPlayerEntity;Lnet/minecraft/util/Hand;Lnet/minecraft/util/hit/BlockHitResult;)Lnet/minecraft/util/ActionResult;"}, at={@At(value="HEAD")}, require=0)
    private void b(ClientPlayerEntity var1, Hand var2, BlockHitResult var3, CallbackInfoReturnable<ActionResult> var4) {
        try {
            FrameClockCache.l = var1.age;
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    @Inject(method={"interactItem(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/Hand;)Lnet/minecraft/util/ActionResult;"}, at={@At(value="HEAD")}, require=0)
    private void c(PlayerEntity var1, Hand var2, CallbackInfoReturnable<ActionResult> var3) {
        try {
            FrameClockCache.l = var1.age;
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    @Inject(method={"interactEntity(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/entity/Entity;Lnet/minecraft/util/Hand;)Lnet/minecraft/util/ActionResult;"}, at={@At(value="HEAD")}, require=0)
    private void d(PlayerEntity var1, Entity var2, Hand var3, CallbackInfoReturnable<ActionResult> var4) {
        try {
            FrameClockCache.l = var1.age;
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    @Inject(method={"interactEntityAtLocation(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/entity/Entity;Lnet/minecraft/util/hit/EntityHitResult;Lnet/minecraft/util/Hand;)Lnet/minecraft/util/ActionResult;"}, at={@At(value="HEAD")}, require=0)
    private void e(PlayerEntity var1, Entity var2, EntityHitResult var3, Hand var4, CallbackInfoReturnable<ActionResult> var5) {
        try {
            FrameClockCache.l = var1.age;
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    @Inject(method={"attackBlock(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/Direction;)Z"}, at={@At(value="HEAD")}, require=0)
    private void f(BlockPos var1, Direction var2, CallbackInfoReturnable<Boolean> var3) {
        MinecraftClient var4 = MinecraftClient.getInstance();
        try {
            if (var4 != null && var4.player != null) {
                FrameClockCache.l = var4.player.age;
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    @Inject(method={"attackWithPiercingWeapon(Lnet/minecraft/component/type/PiercingWeaponComponent;)V"}, at={@At(value="HEAD")}, require=0)
    private void g(PiercingWeaponComponent var1, CallbackInfo var2) {
        MinecraftClient var3 = MinecraftClient.getInstance();
        try {
            if (var3 != null && var3.player != null) {
                FrameClockCache.l = var3.player.age;
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    @Inject(method={"attackEntity(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/entity/Entity;)V"}, at={@At(value="RETURN")}, require=0)
    private void h(PlayerEntity var1, Entity var2, CallbackInfo var3) {
        CoreCacheKeeper var4 = null;
        try {
            if (ConfigBridge.c == null || !CoreCacheKeeper.ON || !ConfigBridge.c.a() || ConfigBridge.c.c() == null) {
                return;
            }
            var4 = ConfigBridge.c.c().a(CoreCacheKeeper.class);
            if (var4 != null && var4.f()) {
                CoreCacheKeeper.d(var2);
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }
}
