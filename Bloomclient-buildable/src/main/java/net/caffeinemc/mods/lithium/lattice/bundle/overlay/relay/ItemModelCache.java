package net.caffeinemc.mods.lithium.lattice.bundle.overlay.relay;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.BevelPassCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.CalculateInterface;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.LinkCacheLoader;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.NodeZoneRenderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Arm;
import net.minecraft.util.Hand;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({HeldItemRenderer.class})
public class ItemModelCache {
   @Unique
   private static float o;
   @Unique
   private static long p;
   @Unique
   private static BuilderFactory q;
   @Unique
   private static final float r = 0.18F;
   @Unique
   private static final float s = 0.22F;
   @Unique
   private static final long t = 250000000L;
   @Unique
   private static final float u = 0.6F;
   @Unique
   private static final float v = 1.25F;
   @Unique
   private static float w;
   @Unique
   private static float x;
   @Unique
   private static long y;
   @Unique
   private static float z;
   @Unique
   private static boolean aa;
   @Unique
   private static float ab;
   @Unique
   private static float ac;
   @Unique
   private static float ad;
   @Unique
   private static float ae;
   @Unique
   private static float af;
   @Unique
   private static float ag;
   @Unique
   private static float ah;
   @Unique
   private static float ai;

   @Inject(
      method = {"renderItem(FLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/command/OrderedRenderCommandQueue;Lnet/minecraft/client/network/ClientPlayerEntity;I)V"},
      at = {@At("HEAD")},
      require = 0
   )
   private void a(float var1, MatrixStack var2, OrderedRenderCommandQueue var3, ClientPlayerEntity var4, int var5, CallbackInfo var6) {
      boolean var7 = ConfigBridge.c != null && NodeZoneRenderer.HAND_ON;
      boolean var8 = var7 || x != 0.0F;
      boolean var9 = ConfigBridge.c != null && (BevelPassCache.ON || BevelPassCache.LIVE);
      boolean var10 = (var8 || var9) && b();
      if (!var8) {
         aa = false;
      } else {
         d(var7, var10);
      }

      if (var9) {
         c(var4, var10);
      }
   }

   @Unique
   private static boolean b() {
      try {
         return ConfigBridge.c != null && ConfigBridge.c.a();
      } catch (Throwable var1) {
         return false;
      }
   }

   @Unique
   private static void c(ClientPlayerEntity var0, boolean var1) {
      try {
         if (!BevelPassCache.ON || !var1) {
            BevelPassCache.off();
            return;
         }

         BevelPassCache.i(var0);
      } catch (Throwable var3) {
         BevelPassCache.off();
      }
   }

   @Unique
   private static void d(boolean var0, boolean var1) {
      Object var2 = null;

      try {
         aa = false;
         if (!var1) {
            x = 0.0F;
            y = 0L;
            z = 0.0F;
            return;
         }

         var2 = NodeZoneRenderer.HAND;
         long var3 = System.nanoTime();
         long var5 = y;
         float var7 = x;
         boolean var8 = var5 != 0L && var3 - var5 > 250000000L;
         float var9 = 0.0F;
         if (var5 != 0L && !var8) {
            var9 = (float)(var3 - var5) / 1.0E9F;
            if (var9 < 0.0F) {
               var9 = 0.0F;
            } else if (var9 > 0.1F) {
               var9 = 0.1F;
            }
         }

         float var10 = var8 ? (var0 ? 1.0F : 0.0F) : (var0 ? Math.min(1.0F, var7 + var9 / 0.18F) : Math.max(0.0F, var7 - var9 / 0.22F));
         x = var10;
         y = !var0 && var10 <= 0.0F ? 0L : var3;
         if (var10 <= 0.0F) {
            z = 0.0F;
            return;
         }

         float var11 = (Float)((Object[])var2)[6];
         float var12 = var11 == 1.0F ? 1.0F : 0.0F;
         float var13 = var11 == 2.0F ? 1.0F : 0.0F;
         if (!var8 && !(var7 <= 0.0F)) {
            float var14 = 1.0F - (float)Math.exp(-12.0 * var9);
            ab = e(ab, (Float)((Object[])var2)[1], var14);
            ac = e(ac, (Float)((Object[])var2)[2], var14);
            ad = e(ad, (Float)((Object[])var2)[3], var14);
            ae = e(ae, (Float)((Object[])var2)[4], var14);
            float var15 = af;
            float var16 = ag;
            af = var12 > var15 ? Math.min(var12, var15 + var9 / 0.18F) : Math.max(var12, var15 - var9 / 0.22F);
            ag = var13 > var16 ? Math.min(var13, var16 + var9 / 0.18F) : Math.max(var13, var16 - var9 / 0.22F);
         } else {
            ab = (Float)((Object[])var2)[1];
            ac = (Float)((Object[])var2)[2];
            ad = (Float)((Object[])var2)[3];
            ae = (Float)((Object[])var2)[4];
            af = var12;
            ag = var13;
         }

         float var21 = var10 * var10 * (3.0F - 2.0F * var10);
         float var22 = af;
         float var23 = ag;
         z = var21;
         ah = var21 * var22 * var22 * (3.0F - 2.0F * var22);
         ai = var21 * var23 * var23 * (3.0F - 2.0F * var23);
         float var17 = 0.72F - ae * var21;
         float var18 = 0.76F * (var17 > 0.3F ? var17 : 0.3F) + 0.65F * (1.0F + (ab - 1.0F) * var21) + ad * var21 - 0.52F;
         w = var18 > 0.6F ? var18 : 0.6F;
         aa = true;
      } catch (Throwable var19) {
      }
   }

   @Unique
   private static float e(float var0, float var1, float var2) {
      float var3 = var0 + (var1 - var0) * var2;
      return Math.abs(var1 - var3) < 1.0E-4F ? var1 : var3;
   }

   @Inject(
      method = {"applyEquipOffset(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/util/Arm;F)V"},
      at = {@At("TAIL")},
      require = 0
   )
   private void f(MatrixStack var1, Arm var2, float var3, CallbackInfo var4) {
      if (aa) {
         h(var1, var2);
      }

      if (ConfigBridge.c != null && BevelPassCache.VAN_LIVE) {
         g(var1, var2);
      }
   }

   @Unique
   private static void g(MatrixStack var0, Arm var1) {
      Object var2 = null;

      try {
         var2 = MinecraftClient.getInstance();
         if (((MinecraftClient)var2).player != null && var1 == ((MinecraftClient)var2).player.getMainArm()) {
            BevelPassCache.u(var0, var1 == Arm.RIGHT);
         }
      } catch (Throwable var4) {
      }
   }

   @Unique
   private static void h(MatrixStack var0, Arm var1) {
      Object var2 = null;
      Object var3 = null;

      try {
         var2 = MinecraftClient.getInstance();
         if (((MinecraftClient)var2).player == null) {
            return;
         }

         float var4 = z;
         float var5 = var1 == Arm.RIGHT ? 1.0F : -1.0F;
         boolean var6 = var1 != ((MinecraftClient)var2).player.getMainArm();
         var0.translate(var5 * ac * var4, ad * var4 + (var6 ? -0.22F * ah : 0.0F), ae * var4);
         boolean var7 = NodeZoneRenderer.HAND[5] > 0.5F;
         if (var7 || o > 0.0F) {
            long var8 = System.nanoTime();
            double var10 = var8 * 1.0E-9;
            float var12 = 0.0F;
            if (var7) {
               var3 = ((MinecraftClient)var2).player.getVelocity();
               double var13 = Math.sqrt(((Vec3d)var3).x * ((Vec3d)var3).x + ((Vec3d)var3).z * ((Vec3d)var3).z);
               float var15 = 1.0F - (float)Math.min(1.0, var13 / 0.15);
               var12 = var15 * var15 * (3.0F - 2.0F * var15);
            }

            float var20 = p == 0L ? 0.0F : (float)(var8 - p) / 1.0E9F;
            p = var8;
            if (var20 < 0.0F) {
               var20 = 0.0F;
            } else if (var20 > 0.1F) {
               var20 = 0.1F;
            }

            o = o + (var12 - o) * (1.0F - (float)Math.exp(-7.0 * var20));
            if (Math.abs(var12 - o) < 0.002F) {
               o = var12;
            }

            if (!var7 && o <= 0.0F) {
               p = 0L;
            }

            float var14 = o * var4;
            if (var14 > 0.0F) {
               var0.translate((float)(var5 * Math.cos(0.9 * var10) * 0.006 * var14), (float)(Math.sin(1.8 * var10) * 0.008 * var14), 0.0F);
               var0.multiply(RotationAxis.POSITIVE_Z.rotationDegrees((float)(var5 * Math.sin(0.9 * var10) * 0.7 * var14)));
            }
         }

         float var19 = 1.0F + (ab - 1.0F) * var4;
         if (Math.abs(var19 - 1.0F) > 0.001F && var19 > 0.0F) {
            var0.scale(var19, var19, var19);
         }
      } catch (Throwable var16) {
      }
   }

   @Inject(
      method = {"renderFirstPersonItem(Lnet/minecraft/client/network/AbstractClientPlayerEntity;FFLnet/minecraft/util/Hand;FLnet/minecraft/item/ItemStack;FLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/command/OrderedRenderCommandQueue;I)V"},
      at = {@At("HEAD")},
      cancellable = true,
      require = 0
   )
   private void i(
      AbstractClientPlayerEntity var1,
      float var2,
      float var3,
      Hand var4,
      float var5,
      ItemStack var6,
      float var7,
      MatrixStack var8,
      OrderedRenderCommandQueue var9,
      int var10,
      CallbackInfo var11
   ) {
      if (var4 == Hand.MAIN_HAND) {
         if (ConfigBridge.c != null && BevelPassCache.LIVE && j(var1, var5, var6, var7, var8, var9, var10)) {
            var11.cancel();
         }
      } else if (aa) {
         try {
            if (ai >= 1.0F) {
               var11.cancel();
            }
         } catch (Throwable var13) {
         }
      }
   }

   @Unique
   private static boolean j(AbstractClientPlayerEntity var0, float var1, ItemStack var2, float var3, MatrixStack var4, OrderedRenderCommandQueue var5, int var6) {
      Object var7 = null;

      try {
         if (!var0.isUsingSpyglass() && (!var0.isUsingItem() || var0.getActiveHand() != Hand.MAIN_HAND) && BevelPassCache.e(var2)) {
            var7 = var0.getMainArm();
            boolean var8 = var7 == Arm.RIGHT;
            boolean var9 = false;
            var4.push();

            try {
               var4.translate(var8 ? 0.56F : -0.56F, -0.52F + var3 * -0.6F, -0.72F);
               if (aa) {
                  h(var4, (Arm)var7);
               }

               BevelPassCache.n(var4, var8);
               var9 = BevelPassCache.o(var0, var2, var4, var5, var6, var1, var3);
            } finally {
               var4.pop();
            }

            return var9;
         } else {
            return false;
         }
      } catch (Throwable var141) {
         return false;
      }
   }

   @Inject(
      method = {"renderArmHoldingItem(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/command/OrderedRenderCommandQueue;IFFLnet/minecraft/util/Arm;)V"},
      at = {@At("HEAD")},
      cancellable = true,
      require = 0
   )
   private void k(MatrixStack var1, OrderedRenderCommandQueue var2, int var3, float var4, float var5, Arm var6, CallbackInfo var7) {
      if (ConfigBridge.c != null && BevelPassCache.ARM_ALT && l(var1, var2, var4, var5, var6)) {
         var7.cancel();
      }
   }

   @Unique
   private static boolean l(MatrixStack var0, OrderedRenderCommandQueue var1, float var2, float var3, Arm var4) {
      try {
         return BevelPassCache.t(var0, var1, var2, var3, var4 != Arm.LEFT);
      } catch (Throwable var6) {
         return false;
      }
   }

   @Inject(
      method = {"renderFirstPersonItem(Lnet/minecraft/client/network/AbstractClientPlayerEntity;FFLnet/minecraft/util/Hand;FLnet/minecraft/item/ItemStack;FLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/command/OrderedRenderCommandQueue;I)V"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/n;push()V",
         ordinal = 0,
         shift = Shift.AFTER
      )},
      require = 0
   )
   private void m(
      AbstractClientPlayerEntity var1,
      float var2,
      float var3,
      Hand var4,
      float var5,
      ItemStack var6,
      float var7,
      MatrixStack var8,
      OrderedRenderCommandQueue var9,
      int var10,
      CallbackInfo var11
   ) {
      if (aa && var4 == Hand.OFF_HAND) {
         try {
            float var12 = ai;
            if (var12 > 0.0F) {
               float var13 = w;
               if (var13 < 1.25F && var6 != null && var6.contains(DataComponentTypes.MAP_ID)) {
                  var13 = 1.25F;
               }

               var8.translate(0.0F, -var13 * var12, 0.0F);
            }
         } catch (Throwable var14) {
         }
      }
   }

   @Inject(
      method = {"shouldSkipHandAnimationOnSwap(Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ItemStack;)Z"},
      at = {@At("HEAD")},
      cancellable = true,
      require = 0
   )
   private void n(ItemStack var1, ItemStack var2, CallbackInfoReturnable<Boolean> var3) {
      try {
         if (q == null) {
            if (ConfigBridge.c == null || ConfigBridge.c.c() == null) {
               return;
            }

            q = ConfigBridge.c.c().a(CalculateInterface.class);
         }

         BuilderFactory var4 = q;
         if ((var4 == null || !var4.f) && (!LinkCacheLoader.NB || var2 == null || !var2.isOf(Items.END_CRYSTAL))
            || ConfigBridge.c == null
            || !ConfigBridge.c.a()) {
            return;
         }

         if (var1 != null && var2 != null && !var1.isEmpty() && !var2.isEmpty() && var1.isOf(var2.getItem())) {
            var3.setReturnValue(true);
         }
      } catch (Throwable var5) {
      }
   }
}
