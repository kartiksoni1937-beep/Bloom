package net.caffeinemc.mods.lithium.lattice.bundle.overlay.relay;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.BoundQuadCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.AdjustRange;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.DataContextor;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({Entity.class})
public class SyncFactory {
   @Unique
   private static long h;
   @Unique
   private static boolean i;

   @Unique
   private static boolean a(long var0) {
      if (var0 != h) {
         i = ConfigBridge.c.a();
         h = var0;
      }

      return i;
   }

   @Unique
   private static int b(int var0) {
      int var1 = BoundQuadCache.OCUR;
      int[] var2 = BoundQuadCache.OGEN;
      int[] var3 = BoundQuadCache.OID;
      int var4 = var0 * -1640531535 >>> 22;

      for (int var5 = 0; var5 < 1024; var5++) {
         if (var2[var4] != var1) {
            return -1;
         }

         if (var3[var4] == var0) {
            return var4;
         }

         var4 = var4 + 1 & 1023;
      }

      return -1;
   }

   @Unique
   private static boolean c(boolean var0, boolean var1, boolean var2) {
      return var0 && (var2 || (var1 ? BoundQuadCache.OLM : BoundQuadCache.OLX));
   }

   @Unique
   private static int d(boolean var0, int var1, boolean var2, boolean var3, boolean var4) {
      if (var2) {
         int var5 = b(var1);
         if (var5 >= 0) {
            return var5;
         }
      }

      return var3 && (var0 || !var4) ? -2 : -1;
   }

   @Inject(
      method = {"isGlowing"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void e(CallbackInfoReturnable<Boolean> var1) {
      if (ConfigBridge.c != null) {
         boolean var2 = DataContextor.ON;
         boolean var3 = BoundQuadCache.OL;
         if (var2 || var3) {
            Entity var4 = (Entity)(Object)this;

            try {
               boolean var5 = var4 instanceof LivingEntity;
               boolean var6 = var4 instanceof PlayerEntity;
               boolean var7 = c(var3, var5, var6);
               boolean var8 = var2 && var5;
               if ((var7 || var8) && var4.getEntityWorld().isClient()) {
                  long var9 = System.currentTimeMillis();
                  if (!a(var9)) {
                     return;
                  }

                  boolean var11 = false;
                  if (var8) {
                     if (var9 != DataContextor.GMS) {
                        DataContextor.a(var9);
                     }

                     var11 = DataContextor.G_PO;
                  }

                  if (d(var6, var4.getId(), var7, var8, var11) != -1) {
                     var1.setReturnValue(true);
                  }
               }
            } catch (Exception var12) {
            }
         }
      }
   }

   @Inject(
      method = {"getTeamColorValue"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void f(CallbackInfoReturnable<Integer> var1) {
      if (ConfigBridge.c != null) {
         boolean var2 = DataContextor.ON;
         boolean var3 = BoundQuadCache.OL;
         if (var2 || var3) {
            Entity var4 = (Entity)(Object)this;

            try {
               boolean var5 = var4 instanceof LivingEntity;
               boolean var6 = var4 instanceof PlayerEntity;
               boolean var7 = c(var3, var5, var6);
               boolean var8 = var2 && var5;
               if ((var7 || var8) && var4.getEntityWorld().isClient()) {
                  long var9 = System.currentTimeMillis();
                  if (!a(var9)) {
                     return;
                  }

                  boolean var11 = false;
                  if (var8) {
                     if (var9 != DataContextor.GMS) {
                        DataContextor.a(var9);
                     }

                     var11 = DataContextor.G_PO;
                  }

                  int var12 = d(var6, var4.getId(), var7, var8, var11);
                  if (var12 >= 0) {
                     BoundQuadCache.OHIT[var12] = BoundQuadCache.OCUR;
                     var1.setReturnValue(BoundQuadCache.OCOL[var12]);
                  } else if (var12 == -2) {
                     var1.setReturnValue(DataContextor.G_COL);
                  }
               }
            } catch (Exception var13) {
            }
         }
      }
   }

   @Inject(
      method = {"setVelocityClient(Lnet/minecraft/util/math/Vec3d;)V"},
      at = {@At("TAIL")}
   )
   private void g(Vec3d var1, CallbackInfo var2) {
      if (ConfigBridge.c != null && AdjustRange.ON && (Object)this instanceof ClientPlayerEntity) {
         AdjustRange.KB = true;
      }
   }
}
