package net.caffeinemc.mods.lithium.lattice.bundle.overlay.relay;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.module.EventAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.BufferEncoder;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.CheckerAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.LinkerFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.SyncDispatcher;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.BufferNormalizer;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.FrameClockCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.LockD;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.AdjustRange;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.BufferJoinController;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.PoolCoordProvider;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.PoolCoordResolver;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.NodeFilterCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.RenderCZ;
import net.minecraft.client.MinecraftClient;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.util.hit.HitResult.Type;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({MinecraftClient.class})
public class DataBridge {
   @Unique
   private static boolean h;

   @Inject(
      method = {"tick()V"},
      at = {@At("HEAD")}
   )
   private void a(CallbackInfo var1) {
      if (ConfigBridge.c != null && AdjustRange.HOLD) {
         try {
            AdjustRange.m_r110();
         } catch (Throwable var7) {
            AdjustRange.HOLD = false;
         }
      }

      if (ConfigBridge.c != null && ConfigBridge.c.a()) {
         FrameClockCache.n = true;

         try {
            EventAdapter.a(new CheckerAdapter());
         } finally {
            FrameClockCache.n = false;
         }
      }
   }

   @Inject(
      method = {"doItemUse"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void b(CallbackInfo var1) {
      if (ConfigBridge.c != null && LockD.g && f()) {
         if (BufferNormalizer.a(1)) {
            BufferNormalizer.b.put(1, false);
         }

         var1.cancel();
      } else {
         if (ConfigBridge.c != null && ConfigBridge.c.a()) {
            BufferEncoder var2 = new BufferEncoder();
            EventAdapter.a(var2);
            if (var2.c()) {
               var1.cancel();
            }
         }

         if (BufferNormalizer.a(1)) {
            BufferNormalizer.b.put(1, false);
            var1.cancel();
         }
      }
   }

   @Inject(
      method = {"doAttack"},
      at = {@At("HEAD")},
      cancellable = true,
      require = 0
   )
   private void c(CallbackInfoReturnable<Boolean> var1) {
      if (ConfigBridge.c != null && LockD.g && f()) {
         if (BufferNormalizer.a(0)) {
            BufferNormalizer.b.put(0, false);
         }

         var1.setReturnValue(false);
      } else {
         MinecraftClient var2 = (MinecraftClient)(Object)this;
         if (ConfigBridge.c != null && ConfigBridge.c.a()) {
            if ((PoolCoordProvider.ARM || PoolCoordResolver.ARM)
               && var2.crosshairTarget != null
               && var2.crosshairTarget.getType() == Type.BLOCK
               && var2.player != null
               && !var2.player.getMainHandStack().contains(DataComponentTypes.PIERCING_WEAPON)) {
               var1.setReturnValue(false);
            } else {
               LinkerFactory var3 = new LinkerFactory();
               EventAdapter.a(var3);
               if (var3.c()) {
                  var1.setReturnValue(false);
               }
            }
         }

         if (BufferNormalizer.a(0)) {
            BufferNormalizer.b.put(0, false);
            var1.setReturnValue(false);
         }
      }
   }

   @Inject(
      method = {"doAttack"},
      at = {@At("RETURN")},
      require = 0
   )
   private void d(CallbackInfoReturnable<Boolean> var1) {
      try {
         BufferJoinController.g_r111();
      } catch (Throwable var3) {
      }
   }

   @Inject(
      method = {"handleBlockBreaking"},
      at = {@At("HEAD")},
      cancellable = true,
      require = 0
   )
   private void e(boolean var1, CallbackInfo var2) {
      Boolean var3 = (Boolean)BufferNormalizer.b.get(0);
      if (var3 != null && var3) {
         BufferNormalizer.b.put(0, false);
         var2.cancel();
      } else if (var1 && ConfigBridge.c != null && LockD.g && f()) {
         var2.cancel();
      } else if (var1 && ConfigBridge.c != null && (PoolCoordProvider.ARM || PoolCoordResolver.ARM) && ConfigBridge.c.a()) {
         MinecraftClient var4 = (MinecraftClient)(Object)this;
         if (var4.crosshairTarget != null && var4.crosshairTarget.getType() == Type.BLOCK) {
            var2.cancel();
            if (!h && var4.interactionManager != null && var4.interactionManager.isBreakingBlock() && var4.player != null && !var4.player.isUsingItem()) {
               var4.interactionManager.cancelBlockBreaking();
            }
         }

         if (var4.player != null && !var4.player.isUsingItem()) {
            h = true;
         }
      } else {
         h = false;
      }
   }

   @Unique
   private static boolean f() {
      try {
         SyncDispatcher var0;
         if (ConfigBridge.c.a() && (var0 = ConfigBridge.c.c()) != null) {
            NodeFilterCache var1 = (NodeFilterCache)var0.a(NodeFilterCache.class);
            return var1 != null && var1.f() && var1.e_r27();
         }
      } catch (Throwable var2) {
      }

      return false;
   }

   @Inject(
      method = {"handleInputEvents()V"},
      at = {@At("RETURN")},
      require = 0
   )
   private void g(CallbackInfo var1) {
      PoolCoordResolver var2 = PoolCoordResolver.I;

      try {
         if (var2 != null && var2.f && ConfigBridge.c != null && ConfigBridge.c.a()) {
            PoolCoordResolver.b();
         }
      } catch (Throwable var6) {
      }

      try {
         if (ConfigBridge.c != null && RenderCZ.MANUAL && ConfigBridge.c.a()) {
            RenderCZ.ab();
         }
      } catch (Throwable var5) {
      }

      try {
         if (ConfigBridge.c != null && AdjustRange.PEND && ConfigBridge.c.a()) {
            AdjustRange.g_r109();
         }
      } catch (Throwable var4) {
      }
   }
}
