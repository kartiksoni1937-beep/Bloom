package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.util.Identifier;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public final class RasterCache {
   private static final Identifier s = Identifier.of("lithium", "roun" + "d" + "_soft");
   private static final int t = 64;
   private static boolean u = false;
   private static final Identifier v = Identifier.of("lithium", "status_i" + "c" + "o" + "ns");
   private static final int w = 32;
   private static final int x = 3;
   private static boolean y = false;
   private static volatile int[] z;
   private static volatile int[] aa;
   private static volatile boolean ab = false;
   private static boolean ac = false;
   private static boolean ad = false;
   private static boolean ae = false;
   private static final Identifier af = Identifier.of("lithium", "round_e" + "x" + "a" + "ct");
   private static final int ag = 256;
   private static final int ah = 48;
   private static final int[] ai = new int[49];
   private static final int[] aj = new int[49];
   private static boolean ak = false;
   private static boolean al = false;
   public static final int G_FPS = 0;
   public static final int G_PING = 1;
   public static final int G_TPS = 2;
   public static final int G_FLOWER = 3;
   public static final int G_KEYS = 4;
   public static final int G_EYE = 5;
   public static final int G_ARROW = 6;
   private static final int am = 7;
   private static final Identifier an = Identifier.of("lithium", "hud_g" + "lyphs");
   private static boolean ao = false;

   private RasterCache() {
   }

   private static void a() {

      if (!u) {
         u = true;

         try {
            NativeImage var0 = new NativeImage(NativeImage.Format.RGBA, 64, 64, false);
            double var1 = 32.0;
            double var3 = 32.0;
            byte var5 = 4;

            for (int var6 = 0; var6 < 64; var6++) {
               for (int var7 = 0; var7 < 64; var7++) {
                  int var8 = 0;

                  for (int var9 = 0; var9 < var5; var9++) {
                     for (int var10 = 0; var10 < var5; var10++) {
                        double var11 = (double)var7 + ((double)var10 + 0.5) / (double)var5;
                        double var13 = (double)var6 + ((double)var9 + 0.5) / (double)var5;
                        double var15 = var11 - var1;
                        double var17 = var13 - var1;
                        if (var15 * var15 + var17 * var17 <= var3 * var3) {
                           var8++;
                        }
                     }
                  }

                  int var20 = (int)Math.round(255.0 * (double)var8 / (double)(var5 * var5));
                  var0.setColorArgb(var7, var6, var20 << 24 | -1997775866 ^ -2011978759);
               }
            }

            MinecraftClient.getInstance().getTextureManager().registerTexture(s, new NativeImageBackedTexture(() -> {

               return "lithium-round-soft";
            }, var0));
         } catch (Throwable var19) {
         }
      }
   }

   public static void b(DrawContext var0, int var1, int var2, int var3, int var4, int var5, int var6) {

      if (var3 > 0 && var4 > 0 && (var6 >>> 24 & (1471888711 ^ 1471888824)) != 0) {
         var5 = Math.min(var5, Math.min(var3 / 2, var4 / 2));
         if (var5 < 1) {
            var0.fill(var1, var2, var1 + var3, var2 + var4, var6);
         } else {
            if (!u) {
               a();
            }

            byte var7 = 32;
            var0.fill(var1 + var5, var2, var1 + var3 - var5, var2 + var4, var6);
            var0.fill(var1, var2 + var5, var1 + var5, var2 + var4 - var5, var6);
            var0.fill(var1 + var3 - var5, var2 + var5, var1 + var3, var2 + var4 - var5, var6);

            try {
               var0.drawTexture(RenderPipelines.GUI_TEXTURED, s, var1, var2, 0.0F, 0.0F, var5, var5, 32, 32, 64, 64, var6);
               var0.drawTexture(RenderPipelines.GUI_TEXTURED, s, var1 + var3 - var5, var2, (float)var7, 0.0F, var5, var5, 32, 32, 64, 64, var6);
               var0.drawTexture(RenderPipelines.GUI_TEXTURED, s, var1, var2 + var4 - var5, 0.0F, (float)var7, var5, var5, 32, 32, 64, 64, var6);
               var0.drawTexture(RenderPipelines.GUI_TEXTURED, s, var1 + var3 - var5, var2 + var4 - var5, (float)var7, (float)var7, var5, var5, 32, 32, 64, 64, var6);
            } catch (Throwable var9) {
               var0.fill(var1, var2, var1 + var5, var2 + var5, var6);
               var0.fill(var1 + var3 - var5, var2, var1 + var3, var2 + var5, var6);
               var0.fill(var1, var2 + var4 - var5, var1 + var5, var2 + var4, var6);
               var0.fill(var1 + var3 - var5, var2 + var4 - var5, var1 + var3, var2 + var4, var6);
            }
         }
      }
   }

   private static double c(double var0, double var2, double var4, double var6, double var8, double var10) {

      double var12 = var8 - var4;
      double var14 = var10 - var6;
      double var16 = var12 * var12 + var14 * var14;
      double var18 = var16 <= 0.0 ? 0.0 : Math.max(0.0, Math.min(1.0, ((var0 - var4) * var12 + (var2 - var6) * var14) / var16));
      double var20 = var0 - (var4 + var18 * var12);
      double var22 = var2 - (var6 + var18 * var14);
      return Math.sqrt(var20 * var20 + var22 * var22);
   }

   private static boolean d(int var0, double var1, double var3) {

      if (var0 == 0) {
         double var12 = 0.088;
         return c(var1, var3, 0.2, 0.54, 0.42, 0.76) <= var12 || c(var1, var3, 0.42, 0.76, 0.8, 0.26) <= var12;
      } else if (var0 == 1) {
         double var11 = 0.082;
         return c(var1, var3, 0.26, 0.26, 0.74, 0.74) <= var11 || c(var1, var3, 0.74, 0.26, 0.26, 0.74) <= var11;
      } else {
         double var5 = 0.082;
         double var7 = var1 - 0.5;
         double var9 = var3 - 0.235;
         return var7 * var7 + var9 * var9 <= 0.011024999999999998 || c(var1, var3, 0.5, 0.44, 0.5, 0.78) <= var5;
      }
   }

   private static void e() {

      if (!ac) {
         ac = true;

         try {
            Thread var0 = new Thread(RasterCache::f, "Wor" + "ker-Lithium-Raster");
            var0.setDaemon(true);
            var0.start();
         } catch (Throwable var1) {
            ab = true;
         }
      }
   }

   private static void f() {

      try {
         z = g(3, false);
         aa = g(7, true);
      } catch (Throwable var1) {
         ab = true;
      }
   }

   private static int[] g(int var0, boolean var1) {

      int var2 = 32 * var0;
      int[] var3 = new int[var2 * 32];
      byte var4 = 4;

      for (int var5 = 0; var5 < var0; var5++) {
         for (int var6 = 0; var6 < 32; var6++) {
            for (int var7 = 0; var7 < 32; var7++) {
               int var8 = 0;

               for (int var9 = 0; var9 < var4; var9++) {
                  for (int var10 = 0; var10 < var4; var10++) {
                     double var11 = ((double)var7 + ((double)var10 + 0.5) / (double)var4) / 32.0;
                     double var13 = ((double)var6 + ((double)var9 + 0.5) / (double)var4) / 32.0;
                     if (var1 ? n(var5, var11, var13) : d(var5, var11, var13)) {
                        var8++;
                     }
                  }
               }

               int var15 = (int)Math.round(255.0 * (double)var8 / (double)(var4 * var4));
               var3[var6 * var2 + var5 * 32 + var7] = var15 << 24 | 1187432368 ^ 1178155087;
            }
         }
      }

      return var3;
   }

   private static boolean h(Identifier var0, String var1, int[] var2, int var3, int var4, boolean var5) {

      try {
         NativeImage var6 = new NativeImage(NativeImage.Format.RGBA, var3, var4, false);

         for (int var7 = 0; var7 < var4; var7++) {
            for (int var8 = 0; var8 < var3; var8++) {
               var6.setColorArgb(var8, var7, var2[var7 * var3 + var8]);
            }
         }

         if (var5) {
            MinecraftClient.getInstance().getTextureManager().registerTexture(var0, new LayerTextureCache(var1, var6));
         } else {
            MinecraftClient.getInstance().getTextureManager().registerTexture(var0, new NativeImageBackedTexture(() -> {

               return var1;
            }, var6));
         }

         return true;
      } catch (Throwable var9) {
         return false;
      }
   }

   private static boolean i() {

      if (ad) {
         return true;
      } else if (!y && !ab) {
         e();
         int[] var0 = z;
         if (var0 == null) {
            return false;
         } else {
            z = null;
            y = true;
            ad = h(v, "lithium-stat" + "u" + "s-icons", var0, 96, 32, false);
            return ad;
         }
      } else {
         return false;
      }
   }

   public static void j(DrawContext var0, int var1, int var2, int var3, int var4, int var5) {

      if (var4 > 0 && (var5 >>> 24 & (1871361924 ^ 1871361915)) != 0) {
         int var6 = var1 >= 0 && var1 < 3 ? var1 : 2;
         if (ad || i()) {
            try {
               var0.drawTexture(RenderPipelines.GUI_TEXTURED, v, var2, var3, (float)(var6 * 32), 0.0F, var4, var4, 32, 32, 96, 32, var5);
            } catch (Throwable var8) {
            }
         }
      }
   }

   private static void k() {

      if (!ak) {
         ak = true;

         try {
            int var0 = 0;
            int var1 = 0;
            int var2 = 0;

            for (int var3 = 48; var3 >= 1; var3--) {
               if (var0 + var3 > (1143532296 ^ 1143532040)) {
                  var1 += var2;
                  var0 = 0;
                  var2 = 0;
               }

               if (var2 == 0) {
                  var2 = var3;
               }

               ai[var3] = var0;
               aj[var3] = var1;
               var0 += var3;
            }

            NativeImage var18 = new NativeImage(NativeImage.Format.RGBA, 868131129 ^ 868130873, 1339094722 ^ 1339094978, false);

            for (int var4 = 0; var4 < (2035823070 ^ 2035822814); var4++) {
               for (int var5 = 0; var5 < (1410813591 ^ 1410813847); var5++) {
                  var18.setColorArgb(var5, var4, 1030047164 ^ 1033550403);
               }
            }

            byte var19 = 8;

            for (int var20 = 1; var20 <= 48; var20++) {
               double var6 = (double)var20 * (double)var20;

               for (int var8 = 0; var8 < var20; var8++) {
                  for (int var9 = 0; var9 < var20; var9++) {
                     int var10 = 0;

                     for (int var11 = 0; var11 < var19; var11++) {
                        double var12 = (double)var8 + ((double)var11 + 0.5) / (double)var19 - (double)var20;

                        for (int var14 = 0; var14 < var19; var14++) {
                           double var15 = (double)var9 + ((double)var14 + 0.5) / (double)var19 - (double)var20;
                           if (var15 * var15 + var12 * var12 <= var6) {
                              var10++;
                           }
                        }
                     }

                     int var21 = (int)Math.round(255.0 * (double)var10 / (double)(var19 * var19));
                     var18.setColorArgb(ai[var20] + var9, aj[var20] + var8, var21 << 24 | 1874558311 ^ 1866760856);
                  }
               }
            }

            MinecraftClient.getInstance().getTextureManager().registerTexture(af, new NativeImageBackedTexture(() -> {

               return "lithium" + "-round-ex" + "act";
            }, var18));
            al = true;
         } catch (Throwable var17) {
            al = false;
         }
      }
   }

   public static void l(
      DrawContext var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, boolean var9, boolean var10, boolean var11
   ) {

      if (var3 > 0 && var4 > 0 && (var6 >>> 24 & (896521810 ^ 896521901)) != 0) {
         var5 = Math.min(var5, Math.min(var3 / 2, var4 / 2));
         if (var5 < 1) {
            var0.fill(var1, var2, var1 + var3, var2 + var4, var6);
         } else {
            if (!ak) {
               k();
            }

            if (var3 > 2 * var5) {
               var0.fill(var1 + var5, var2, var1 + var3 - var5, var2 + var4, var6);
            }

            if (var4 > 2 * var5) {
               var0.fill(var1, var2 + var5, var1 + var5, var2 + var4 - var5, var6);
               var0.fill(var1 + var3 - var5, var2 + var5, var1 + var3, var2 + var4 - var5, var6);
            }

            int var12 = var5 * Math.max(1, var7);
            if (var12 > 48) {
               var12 = 48;
            }

            if (!al) {
               var0.fill(var1, var2, var1 + var5, var2 + var5, var6);
               var0.fill(var1 + var3 - var5, var2, var1 + var3, var2 + var5, var6);
               var0.fill(var1, var2 + var4 - var5, var1 + var5, var2 + var4, var6);
               var0.fill(var1 + var3 - var5, var2 + var4 - var5, var1 + var3, var2 + var4, var6);
            } else {
               try {
                  int var13 = ai[var12];
                  int var14 = aj[var12];
                  if (var8) {
                     var0.drawTexture(
                        RenderPipelines.GUI_TEXTURED,
                        af,
                        var1,
                        var2,
                        (float)var13,
                        (float)var14,
                        var5,
                        var5,
                        var12,
                        var12,
                        421585242 ^ 421584986,
                        540334796 ^ 540335052,
                        var6
                     );
                  } else {
                     var0.fill(var1, var2, var1 + var5, var2 + var5, var6);
                  }

                  if (var9) {
                     var0.drawTexture(
                        RenderPipelines.GUI_TEXTURED,
                        af,
                        var1 + var3 - var5,
                        var2,
                        (float)(var13 + var12),
                        (float)var14,
                        var5,
                        var5,
                        -var12,
                        var12,
                        382636061 ^ 382636317,
                        2064569938 ^ 2064570194,
                        var6
                     );
                  } else {
                     var0.fill(var1 + var3 - var5, var2, var1 + var3, var2 + var5, var6);
                  }

                  if (var10) {
                     var0.drawTexture(
                        RenderPipelines.GUI_TEXTURED,
                        af,
                        var1,
                        var2 + var4 - var5,
                        (float)var13,
                        (float)(var14 + var12),
                        var5,
                        var5,
                        var12,
                        -var12,
                        -324025531 ^ -324025787,
                        1412871852 ^ 1412872108,
                        var6
                     );
                  } else {
                     var0.fill(var1, var2 + var4 - var5, var1 + var5, var2 + var4, var6);
                  }

                  if (var11) {
                     var0.drawTexture(
                        RenderPipelines.GUI_TEXTURED,
                        af,
                        var1 + var3 - var5,
                        var2 + var4 - var5,
                        (float)(var13 + var12),
                        (float)(var14 + var12),
                        var5,
                        var5,
                        -var12,
                        -var12,
                        534227121 ^ 534227377,
                        -215384099 ^ -215384355,
                        var6
                     );
                  } else {
                     var0.fill(var1 + var3 - var5, var2 + var4 - var5, var1 + var3, var2 + var4, var6);
                  }
               } catch (Throwable var15) {
                  var0.fill(var1, var2, var1 + var5, var2 + var5, var6);
                  var0.fill(var1 + var3 - var5, var2, var1 + var3, var2 + var5, var6);
                  var0.fill(var1, var2 + var4 - var5, var1 + var5, var2 + var4, var6);
                  var0.fill(var1 + var3 - var5, var2 + var4 - var5, var1 + var3, var2 + var4, var6);
               }
            }
         }
      }
   }

   private static double m(double var0, double var2, double var4, double var6, double var8, double var10, double var12) {

      double var14 = Math.abs(var0 - var4) - (var8 - var12);
      double var16 = Math.abs(var2 - var6) - (var10 - var12);
      double var18 = Math.max(var14, 0.0);
      double var20 = Math.max(var16, 0.0);
      return Math.sqrt(var18 * var18 + var20 * var20) + Math.min(Math.max(var14, var16), 0.0) - var12;
   }

   private static boolean n(int var0, double var1, double var3) {

      switch (var0) {
         case 0:
            double var26 = m(var1, var3, 0.5, 0.42, 0.4, 0.28, 0.08);
            return Math.abs(var26) <= 0.055 || c(var1, var3, 0.5, 0.7, 0.5, 0.82) <= 0.05 || c(var1, var3, 0.32, 0.86, 0.68, 0.86) <= 0.055;
         case 1:
            double var25 = var1 - 0.5;
            double var30 = var3 - 0.8;
            if (var25 * var25 + var30 * var30 <= 0.005625) {
               return true;
            } else {
               if (!(var30 >= 0.0) && !(Math.abs(var25) > -var30 * 1.05)) {
                  double var33 = Math.sqrt(var25 * var25 + var30 * var30);
                  return Math.abs(var33 - 0.26) <= 0.055 || Math.abs(var33 - 0.45) <= 0.055 || Math.abs(var33 - 0.64) <= 0.055;
               }

               return false;
            }
         case 2:
            double var24 = var1 - 0.5;
            double var29 = var3 - 0.5;
            double var32 = Math.sqrt(var24 * var24 + var29 * var29);
            return Math.abs(var32 - 0.38) <= 0.06 || c(var1, var3, 0.5, 0.5, 0.5, 0.27) <= 0.05 || c(var1, var3, 0.5, 0.5, 0.67, 0.58) <= 0.05;
         case 3:
            double var23 = var1 - 0.5;
            double var28 = var3 - 0.5;
            if (var23 * var23 + var28 * var28 <= 0.007225000000000001) {
               return false;
            } else {
               for (int var31 = 0; var31 < 5; var31++) {
                  double var10 = (-Math.PI / 2) + (double)var31 * (Math.PI * 2.0 / 5.0);
                  double var12 = Math.cos(var10);
                  double var14 = Math.sin(var10);
                  double var16 = var23 * var12 + var28 * var14 - 0.25;
                  double var18 = -var23 * var14 + var28 * var12;
                  if (var16 / 0.21 * (var16 / 0.21) + var18 / 0.135 * (var18 / 0.135) <= 1.0) {
                     double var20 = var16 - 0.215;
                     if (var20 * var20 + var18 * var18 > 0.004900000000000001) {
                        return true;
                     }
                  }
               }

               return false;
            }
         case 4:
            double var22 = m(var1, var3, 0.5, 0.5, 0.44, 0.27, 0.07);
            if (Math.abs(var22) <= 0.05) {
               return true;
            } else {
               for (int var27 = 0; var27 < 4; var27++) {
                  double var8 = 0.25 + (double)var27 * 0.1667;
                  if (m(var1, var3, var8, 0.4, 0.045, 0.045, 0.015) <= 0.0) {
                     return true;
                  }
               }

               return c(var1, var3, 0.33, 0.6, 0.67, 0.6) <= 0.045;
            }
         case 5:
            double var5 = (var1 - 0.5) / 0.44;
            double var7 = (var3 - 0.5) / 0.26;
            double var9 = Math.sqrt(var5 * var5 + var7 * var7);
            double var11 = var1 - 0.5;
            double var13 = var3 - 0.5;
            return Math.abs(var9 - 1.0) * 0.26 <= 0.05 || var11 * var11 + var13 * var13 <= 0.0144;
         default:
            return c(var1, var3, 0.22, 0.66, 0.5, 0.36) <= 0.08 || c(var1, var3, 0.5, 0.36, 0.78, 0.66) <= 0.08;
      }
   }

   private static boolean o() {

      if (ae) {
         return true;
      } else if (!ao && !ab) {
         e();
         int[] var0 = aa;
         if (var0 == null) {
            return false;
         } else {
            aa = null;
            ao = true;
            ae = h(an, "lithium-" + "hud-glyphs", var0, 405115768 ^ 405115800, 32, true);
            return ae;
         }
      } else {
         return false;
      }
   }

   public static void glyph(DrawContext var0, int var1, int var2, int var3, int var4, int var5) {

      if (var4 > 0 && (var5 >>> 24 & (1218218027 ^ 1218218196)) != 0 && var1 >= 0 && var1 < 7) {
         if (ae || o()) {
            try {
               var0.drawTexture(RenderPipelines.GUI_TEXTURED, an, var2, var3, (float)(var1 * 32), 0.0F, var4, var4, 32, 32, 1507329508 ^ 1507329284, 32, var5);
            } catch (Throwable var7) {
            }
         }
      }
   }
}
