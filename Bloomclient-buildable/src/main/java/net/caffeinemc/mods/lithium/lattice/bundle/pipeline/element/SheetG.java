package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.element;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.HudFont;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.util.Identifier;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import org.joml.Matrix3x2fStack;

final class SheetG {
   private static final int n = 64;
   private static final double o = 1.64;
   private static final HashMap<Integer, SheetG.Atlas> p = new HashMap<>();
   private static volatile SheetG.Bake q;
   private static volatile boolean r;
   private static volatile boolean s;
   private static final AtomicInteger t = new AtomicInteger();

   private SheetG() {
   }

   static boolean a(DrawContext var0, float var1, float var2, float var3, float var4, int var5, int var6, int var7, int var8, int var9) {

      if (!s && !(var3 <= 0.0F) && !(var4 <= 0.0F)) {
         MinecraftClient var10 = MinecraftClient.getInstance();
         Matrix3x2fStack var11 = var0.getMatrices();
         double var12 = Math.max(1.0, (double)var10.getWindow().getScaleFactor());
         double var14 = Math.sqrt((double)(var11.m00 * var11.m00 + var11.m01 * var11.m01)) * var12;
         int var16 = (int)Math.max(1L, Math.min(3L, Math.round(var14)));
         d();
         e(var16, var5);
         SheetG.Atlas var17 = c(var16, var5);
         if (var17 == null) {
            return false;
         } else {
            int var18 = (int)Math.round((double)(var11.m00 * var1 + var11.m10 * var2 + var11.m20) * var12);
            int var19 = (int)Math.round((double)(var11.m01 * var1 + var11.m11 * var2 + var11.m21) * var12);
            int var20 = (int)Math.round((double)(var11.m00 * (var1 + var3) + var11.m10 * var2 + var11.m20) * var12);
            int var21 = (int)Math.round((double)(var11.m01 * var1 + var11.m11 * (var2 + var4) + var11.m21) * var12);
            int var22 = var20 - var18;
            int var23 = var21 - var19;
            if (var22 > 0 && var23 > 0) {
               int[] var24 = new int[]{var6, var7, var8, var9};
               int var25 = 0;

               for (int var29 : var24) {
                  if ((var29 >>> 24 & (1860250726 ^ 1860250777)) != 0) {
                     var25++;
                  }
               }

               if (var25 == 0) {
                  return true;
               } else {
                  float[] var36 = new float[var25 * 9 * 8];
                  int[] var37 = new int[var25 * 9];
                  int var38 = 0;

                  for (int var39 = 0; var39 < 4; var39++) {
                     if ((var24[var39] >>> 24 & (-1797404624 ^ -1797404465)) != 0) {
                        var38 = k(
                           var36,
                           var37,
                           var38,
                           var18,
                           var19,
                           var22,
                           var23,
                           var17.pad,
                           var17.cap,
                           64,
                           var17.aw,
                           4 * var17.hc,
                           var39 * var17.hc,
                           var17.hc,
                           var24[var39]
                        );
                     }
                  }

                  if (var38 == 0) {
                     return true;
                  } else {
                     var11.pushMatrix();

                     boolean var30;
                     try {
                        var11.identity();
                        var11.scale((float)(1.0 / var12), (float)(1.0 / var12));
                        HudFont.ae(var0, var17.id, var36, var37, var38);
                        return true;
                     } catch (Throwable var34) {
                        var30 = false;
                     } finally {
                        var11.popMatrix();
                     }

                     return var30;
                  }
               }
            } else {
               return false;
            }
         }
      } else {
         return false;
      }
   }

   private static int b(int var0, int var1) {

      return var0 * (-704856094 ^ -704857078) + var1;
   }

   private static SheetG.Atlas c(int var0, int var1) {

      SheetG.Atlas var2 = p.get(b(var0, var1));
      if (var2 != null) {
         return var2;
      } else {
         for (int var3 = 1; var3 <= 3; var3++) {
            var2 = p.get(b(var3, var1));
            if (var2 != null) {
               return var2;
            }
         }

         return null;
      }
   }

   private static void d() {

      SheetG.Bake var0 = q;
      if (var0 != null) {
         q = null;
         SheetG.Atlas var1 = new SheetG.Atlas(var0.key);

         try {
            MinecraftClient.getInstance().getTextureManager().registerTexture(var1.id, new SheetG.LinearTex(() -> {

               return "lithium-" + var1.id.getPath();
            }, var0.img));
            var1.pad = var0.pad;
            var1.cap = var0.cap;
            var1.aw = var0.aw;
            var1.hc = var0.hc;
            p.put(var0.key, var1);
         } catch (Throwable var5) {
            try {
               var0.img.close();
            } catch (Throwable var4) {
            }

            if (t.incrementAndGet() >= 3) {
               s = true;
            }
         }

         r = false;
      }
   }

   private static void e(int var0, int var1) {

      if (!s && !r && p.size() < 24 && !p.containsKey(b(var0, var1))) {
         r = true;
         Thread var4 = new Thread(() -> {

            try {
               q = f(var0, var1);
            } catch (Throwable var3) {
               if (t.incrementAndGet() >= 3) {
                  s = true;
               }

               r = false;
            }
         }, "lit" + "hium-glass-bake");

         try {
            var4.setDaemon(true);
            var4.start();
         } catch (Throwable var6) {
            if (t.incrementAndGet() >= 3) {
               s = true;
            }

            r = false;
         }
      }
   }

   private static SheetG.Bake f(int var0, int var1) {

      double var2 = 1.64 / (double)var0;
      int var4 = (int)Math.ceil(30.0 / var2) + 2;
      int var5 = var1 * var0;
      double var6 = (double)var5 * var2;
      int var8 = Math.max(var5, (int)Math.ceil(54.0 / var2));
      int var9 = var4 + var8;
      int var10 = 2 * var9 + 1;
      int var11 = 2 * var9 + 64;
      NativeImage var12 = new NativeImage(NativeImage.Format.RGBA, var10, 4 * var11, false);

      try {
         g(var12, var4, var9, var10, var11, var8, var6, var2);
      } catch (Throwable var14) {
         var12.close();
         throw var14;
      }

      return new SheetG.Bake(var12, var0, b(var0, var1), var4, var9, var10, var11);
   }

   private static void g(NativeImage var0, int var1, int var2, int var3, int var4, int var5, double var6, double var8) {

      double var10 = ((double)var3 - 2.0 * (double)var1) * var8 / 2.0;
      double var12 = ((double)var4 - 2.0 * (double)var1) * var8 / 2.0;
      double var14 = (double)var3 / 2.0;
      double var16 = (double)var4 / 2.0;
      int var18 = (var3 + 1) / 2;

      for (int var19 = 0; var19 < var4; var19++) {
         double var20 = ((double)var19 + 0.5 - var16) * var8;
         double var22 = (double)var19 + 0.5 - (double)var1;
         double var24 = j(1.0 - (var22 - (double)var5) / 64.0);
         double var26 = Math.pow(var24, 1.8);

         for (int var28 = 0; var28 < var18; var28++) {
            double var29 = ((double)var28 + 0.5 - var14) * var8;
            double var31 = Math.abs(var29) - (var10 - var6);
            double var33 = Math.abs(var20) - (var12 - var6);
            double var35 = Math.max(var31, 0.0);
            double var37 = Math.max(var33, 0.0);
            double var39 = Math.sqrt(var35 * var35 + var37 * var37) + Math.min(Math.max(var31, var33), 0.0) - var6;
            double var41 = j(0.5 - var39);
            double var43 = Math.max(0.0, -var39);
            double var47 = var41 <= 0.0 ? 0.0 : var41 * (0.6 + 0.4 * Math.exp(-var43 / 18.0)) * (0.84 + 0.16 * var24);
            double var49 = var41 <= 0.0 ? 0.0 : var41 * Math.min(1.0, 0.55 * var26 + 0.5 * Math.exp(-var43 / 8.0));
            double var51 = h(var39);
            i(var0, var28, var19, var3, var4, 0, var41);
            i(var0, var28, var19, var3, var4, 1, var47);
            i(var0, var28, var19, var3, var4, 2, var49);
            i(var0, var28, var19, var3, var4, 3, var51);
         }
      }
   }

   private static double h(double var0) {

      double var2 = 0.9 * j(2.0 - Math.abs(var0));
      double var4 = var0 > 0.0 ? 0.09 * Math.exp(-(var0 * var0) / 100.0) : 0.06 * Math.exp(-(var0 * var0) / 36.0);
      return Math.max(var2, var4);
   }

   private static void i(NativeImage var0, int var1, int var2, int var3, int var4, int var5, double var6) {

      int var8 = (int)Math.round(255.0 * j(var6));
      int var9 = var8 << 24 | -300813223 ^ -286389338;
      var0.setColorArgb(var1, var5 * var4 + var2, var9);
      var0.setColorArgb(var3 - 1 - var1, var5 * var4 + var2, var9);
   }

   private static double j(double var0) {

      return var0 < 0.0 ? 0.0 : (var0 > 1.0 ? 1.0 : var0);
   }

   private static int k(
      float[] var0,
      int[] var1,
      int var2,
      int var3,
      int var4,
      int var5,
      int var6,
      int var7,
      int var8,
      int var9,
      int var10,
      int var11,
      int var12,
      int var13,
      int var14
   ) {

      int var15 = var3 - var7;
      int var16 = var3 + var5 + var7;
      int var17 = Math.min(var8, var7 + var5 / 2);
      int var18 = Math.min(var8, var7 + var5 - var5 / 2);
      int var19 = var15 + var17;
      int var20 = var16 - var18;
      int var21 = var4 - var7;
      int var22 = var4 + var6 + var7;
      int var23 = Math.min(var8, var7 + var6 / 2);
      int var24 = Math.min(var8, var7 + var6 - var6 / 2);
      int var25 = var21 + var23;
      int var26 = var22 - var24;
      float var27 = (float)var10;
      float var28 = (float)var11;
      float var29 = ((float)var8 + 0.5F) / var27;
      float[] var30 = new float[]{(float)var15, (float)var19, (float)var19, (float)var20, (float)var20, (float)var16};
      float[] var31 = new float[]{0.0F, (float)var17 / var27, var29, var29, (float)(var10 - var18) / var27, 1.0F};
      float var32;
      float var33;
      if (var9 <= 1) {
         var32 = var33 = ((float)(var12 + var8) + 0.5F) / var28;
      } else {
         var32 = (float)(var12 + var8) / var28;
         var33 = (float)(var12 + var8 + var9) / var28;
      }

      float[] var34 = new float[]{(float)var21, (float)var25, (float)var25, (float)var26, (float)var26, (float)var22};
      float[] var35 = new float[]{
         (float)var12 / var28, (float)(var12 + var23) / var28, var32, var33, (float)(var12 + var13 - var24) / var28, (float)(var12 + var13) / var28
      };

      for (int var36 = 0; var36 < 3; var36++) {
         float var37 = var34[var36 * 2];
         float var38 = var34[var36 * 2 + 1];
         if (!(var38 <= var37)) {
            for (int var39 = 0; var39 < 3; var39++) {
               float var40 = var30[var39 * 2];
               float var41 = var30[var39 * 2 + 1];
               if (!(var41 <= var40)) {
                  int var42 = var2 * 8;
                  var0[var42] = var40;
                  var0[var42 + 1] = var37;
                  var0[var42 + 2] = var41;
                  var0[var42 + 3] = var38;
                  var0[var42 + 4] = var31[var39 * 2];
                  var0[var42 + 5] = var35[var36 * 2];
                  var0[var42 + 6] = var31[var39 * 2 + 1];
                  var0[var42 + 7] = var35[var36 * 2 + 1];
                  var1[var2++] = var14;
               }
            }
         }
      }

      return var2;
   }

   private static final class Atlas {
      final Identifier id;
      int pad;
      int cap;
      int aw;
      int hc;
      private static int a = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

      Atlas(int var1) {
         this.id = Identifier.of("lithium", "s" + "heet_glass_" + var1);
      }
   }

   private static final class Bake {
      final NativeImage img;
      final int rs;
      final int key;
      final int pad;
      final int cap;
      final int aw;
      final int hc;
      private static int a = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

      Bake(NativeImage var1, int var2, int var3, int var4, int var5, int var6, int var7) {
         this.img = var1;
         this.rs = var2;
         this.key = var3;
         this.pad = var4;
         this.cap = var5;
         this.aw = var6;
         this.hc = var7;
      }
   }

   private static final class LinearTex extends NativeImageBackedTexture {
      private static int a = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

      LinearTex(Supplier<String> var1, NativeImage var2) {
         super(var1, var2);

         try {
            this.sampler = RenderSystem.getSamplerCache().get(FilterMode.LINEAR);
         } catch (Throwable var4) {
         }
      }
   }
}
