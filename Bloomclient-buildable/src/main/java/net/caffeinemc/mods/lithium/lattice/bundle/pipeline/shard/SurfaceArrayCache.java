package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import net.minecraft.util.math.MathHelper;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
public final class SurfaceArrayCache {
   public static final int W = 512;
   public static final int H = 128;
   private static final int m = 128;
   private static final int n = 0;
   private static final int o = 1;
   private static final int p = 2;
   private static final int q = 3;
   private static final int[] r = new int[]{
      16750130,
      16755265,
      16763000,
      16762980,
      16752790,
      15091310,
      16738615,
      16747570,
      16759150,
      16750220,
      16759160,
      16775393,
      16766634,
      16755350,
      16747725,
      11568383,
      16744634,
      9213695
   };
   private static final int[] s = new int[]{
      16752700,
      16758342,
      16766080,
      16764265,
      16757320,
      16088360,
      16747568,
      16755782,
      16765052,
      16757360,
      16764034,
      16775126,
      16767136,
      16758902,
      16761966,
      7652538,
      16752212,
      8432383
   };
   private static final int[] t = new int[54];
   private static float u = -1.0F;
   private static final int v = 13;
   private static final float[] w = new float[52];
   private static final float[] x = new float[]{0.62F, 0.34F, -0.1F, -0.38F, -0.7F, -1.02F};
   private static final float[] y = new float[]{0.03F, 0.055F, 0.022F, 0.075F, 0.048F, 0.13F};
   private static final int[] z = new int[]{1, 3, 1, 3, 3, 3};
   private static final float[] aa = new float[]{0.08F, 0.035F, 0.07F, 0.03F, 0.035F, 0.02F};
   private static int ab = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   private SurfaceArrayCache() {
   }

   public static int[] a() {

      int[] var0 = new int[65536];

      for (int var1 = 0; var1 < (209861661 ^ 209861789); var1++) {
         double var2 = ((double)var1 + 0.5) / 64.0 - 1.0;
         int var4 = var1 * (1629657288 ^ 1629657800);

         for (int var5 = 0; var5 < (-933688526 ^ -933688398); var5++) {
            double var6 = ((double)var5 + 0.5) / 64.0 - 1.0;
            var0[var4 + var5] = b(var6, var2);
            var0[var4 + (639971659 ^ 639971787) + var5] = d(var6, var2);
            var0[var4 + (1056336768 ^ 1056336512) + var5] = e(var6, var2);
            var0[var4 + (-743969581 ^ -743969453) + var5] = f(var6, var2);
         }
      }

      return var0;
   }

   private static int b(double var0, double var2) {

      double var4 = Math.sqrt(var0 * var0 + var2 * var2);
      double var6 = 0.8;
      double var8 = (var6 - var4) * 64.0 / 1.6 + 0.5;
      var8 = var8 < 0.0 ? 0.0 : (var8 > 1.0 ? 1.0 : var8);
      double var10 = var4 / var6;
      double var12 = var10 >= 1.0 ? 0.0 : 1.0 - var10 * var10;
      double var14 = 1.0;
      double var16 = 0.45 + 0.54 * var12;
      double var18 = 0.22 + 0.72 * var12;
      double var20 = var4 - var6;
      double var22;
      if (var20 <= 0.0) {
         var22 = 0.4;
      } else if (var20 >= 0.1) {
         var22 = 0.0;
      } else {
         double var24 = 1.0 - var20 / 0.1;
         var22 = 0.4 * Math.exp(-var20 / 0.028) * var24 * var24;
      }

      double var39 = 1.0;
      double var26 = 0.7;
      double var28 = 0.38;
      double var30 = var8 + (1.0 - var8) * var22;
      if (var30 <= 0.0) {
         return h(0.0, var39, var26, var28);
      } else {
         double var32 = var8 * var14 + (1.0 - var8) * var22 * var39;
         double var34 = var8 * var16 + (1.0 - var8) * var22 * var26;
         double var36 = var8 * var18 + (1.0 - var8) * var22 * var28;
         return h(var30, var32 / var30, var34 / var30, var36 / var30);
      }
   }

   private static double c(double var0) {

      double var2 = var0 / 0.955;
      if (var2 >= 1.0) {
         return 0.0;
      } else {
         double var4 = 1.0 - var2 * var2;
         double var6 = Math.exp(-var2 * var2 / 0.0128);
         double var8 = var4 * var4 * var4 / (1.0 + 5.0 * var2 * var2);
         return 0.2 * var6 * var4 + 0.8 * var8;
      }
   }

   private static int d(double var0, double var2) {

      return h(c(Math.sqrt(var0 * var0 + var2 * var2)), 1.0, 1.0, 1.0);
   }

   private static int e(double var0, double var2) {

      double var4 = (0.955 - var2) / 1.91;
      if (!(var4 <= 0.0) && !(var4 >= 1.0) && !(Math.abs(var0) >= 0.955)) {
         double var6 = 0.2 + 0.12 * var4;
         double var8 = 1.0 - var0 / 0.955 * (var0 / 0.955);
         double var10 = Math.exp(-0.5 * (var0 / var6) * (var0 / var6)) * var8 * var8;
         double var12 = g(var4 / 0.1);
         double var14 = Math.pow(1.0 - var4, 1.6);
         return h(var10 * var12 * var14, 1.0, 1.0, 1.0);
      } else {
         return h(0.0, 1.0, 1.0, 1.0);
      }
   }

   private static int f(double var0, double var2) {

      double var4 = Math.abs(var0);
      double var6 = Math.abs(var2);
      double var8 = 0.78;
      double var10 = Math.max(var6, var4 * 0.8660254 + var6 * 0.5) - var8;
      double var12 = 1.0 - g((var10 + 0.05) / 0.09);
      double var14 = (var10 + 0.085) / 0.075;
      double var16 = Math.exp(-var14 * var14);
      double var18 = Math.sqrt(var0 * var0 + var2 * var2) / var8;
      double var20 = 0.3 + 0.2 * Math.min(1.0, var18 * var18);
      double var22 = var12 * (var20 + 0.45 * var16);
      return h(var22 > 1.0 ? 1.0 : var22, 1.0, 1.0, 1.0);
   }

   private static double g(double var0) {

      var0 = var0 < 0.0 ? 0.0 : (var0 > 1.0 ? 1.0 : var0);
      return var0 * var0 * (3.0 - 2.0 * var0);
   }

   private static int h(double var0, double var2, double var4, double var6) {

      int var8 = (int)((var0 < 0.0 ? 0.0 : (var0 > 1.0 ? 1.0 : var0)) * 255.0 + 0.5);
      int var9 = (int)((var2 < 0.0 ? 0.0 : (var2 > 1.0 ? 1.0 : var2)) * 255.0 + 0.5);
      int var10 = (int)((var4 < 0.0 ? 0.0 : (var4 > 1.0 ? 1.0 : var4)) * 255.0 + 0.5);
      int var11 = (int)((var6 < 0.0 ? 0.0 : (var6 > 1.0 ? 1.0 : var6)) * 255.0 + 0.5);
      return var8 << 24 | var9 << 16 | var10 << 8 | var11;
   }

   private static void i(float var0) {
      int var1 = 0;
      int var2 = 0;
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;
      int var7 = 0;
      byte var8 = 0;

      while (true) {
         switch (var8) {
            case 0:
            default:
               if (ab != 0) {
                  new Object().hashCode();
                  var8 = 2;
                  break;
               }
            case 2:
               if (var0 > u - 0.002F && var0 < u + 0.002F) {
                  return;
               }
            case 4:
               u = var0;
               var1 = 0;
               var8 = 1;
               break;
            case 1:
               if (var1 < 18) {
                  var2 = r[var1];
                  var3 = s[var1];
                  var4 = 0;
                  var8 = 6;
                  break;
               }

               return;
            case 5:
               return;
            case 6:
               if (var4 < 3) {
                  var5 = 16 - var4 * 8;
                  var6 = var2 >> var5 & (1921222720 ^ 1921222847);
                  var7 = var3 >> var5 & (-1493717607 ^ -1493717658);
                  t[var1 * 3 + var4] = (int)((float)var6 + (float)(var7 - var6) * var0 + 0.5F);
                  var4++;
                  var8 = 6;
                  break;
               }
            case 3:
               var1++;
               var8 = 1;
         }
      }
   }

   public static void j(
      VertexConsumer var0,
      MatrixStack.Entry var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      double var8,
      float[] var10,
      float var11,
      float var12
   ) {

      if (var6 > 0.004F && var5 > 0.0F) {
         if (var6 > 1.0F) {
            var6 = 1.0F;
         }

         float var13 = var12 < 0.0F ? 0.0F : (var12 > 1.0F ? 1.0F : var12);
         if (!(var13 > u - 0.002F) || !(var13 < u + 0.002F)) {
            i(var13);
         }

         int[] var14 = t;
         float var15 = MathHelper.sqrt(var2 * var2 + var3 * var3 + var4 * var4);
         if (var15 > 1.0F) {
            float var16 = var7 < 0.0F ? 0.0F : (var7 > 1.0F ? 1.0F : var7);
            float var17 = var5;
            float var18 = var6 * (0.55F + 0.35F * var16);
            float var19 = var6 * (0.3F + 1.0F * var16);
            float var20 = var6 * (0.05F + 1.0F * var16);
            float var21 = var2 / var15;
            float var22 = var3 / var15;
            float var23 = var4 / var15;
            float var24 = var22 * var10[5] - var23 * var10[4];
            float var25 = var23 * var10[3] - var21 * var10[5];
            float var26 = var21 * var10[4] - var22 * var10[3];
            float var27 = MathHelper.sqrt(var24 * var24 + var25 * var25 + var26 * var26);
            if (var27 < 0.05F) {
               float var28 = var21 * var10[0] + var22 * var10[1] + var23 * var10[2];
               var24 = var10[0] - var21 * var28;
               var25 = var10[1] - var22 * var28;
               var26 = var10[2] - var23 * var28;
               var27 = MathHelper.sqrt(var24 * var24 + var25 * var25 + var26 * var26);
               if (var27 < 1.0E-4F) {
                  return;
               }
            }

            var24 /= var27;
            var25 /= var27;
            var26 /= var27;
            float var81 = var25 * var23 - var26 * var22;
            float var29 = var26 * var21 - var24 * var23;
            float var30 = var24 * var22 - var25 * var21;
            float var31 = -var23;
            float var33 = MathHelper.sqrt(var31 * var31 + var21 * var21);
            if (!(var33 < 0.001F)) {
               var31 /= var33;
               float var32 = var21 / var33;
               float var34 = -var32 * var22;
               float var35 = var32 * var21 - var31 * var23;
               float var36 = var31 * var22;
               float var37 = var3 - var5 * 0.065F;
               k(
                  var0,
                  var1,
                  var2,
                  var37,
                  var4,
                  var31 * var5 * 2.0F,
                  0.0F,
                  var32 * var5 * 2.0F,
                  0.0F,
                  var5 * 0.15F,
                  0.0F,
                  1,
                  var14[0],
                  var14[1],
                  var14[2],
                  0.45F * var19
               );

               for (byte var38 = -1; var38 <= 1; var38 += 2) {
                  float var39 = (float)var38 * var17 * 0.46F;
                  k(
                     var0,
                     var1,
                     var2 + var31 * var39,
                     var37 + var17 * 0.028F,
                     var4 + var32 * var39,
                     var31 * var17 * 0.95F,
                     0.0F,
                     var32 * var17 * 0.95F,
                     0.0F,
                     var17 * 0.09F,
                     0.0F,
                     1,
                     var14[3],
                     var14[4],
                     var14[5],
                     0.42F * var19
                  );
               }

               k(
                  var0,
                  var1,
                  var2,
                  var37,
                  var4,
                  var31 * var17 * 0.7F,
                  0.0F,
                  var32 * var17 * 0.7F,
                  0.0F,
                  var17 * 0.03F,
                  0.0F,
                  1,
                  var14[6],
                  var14[7],
                  var14[8],
                  0.2F * var19
               );
               byte var83 = 13;
               float var84 = (float)(var8 * 0.011 % (Math.PI * 2));
               float var40 = 0.50097656F;
               float var41 = 0.74902344F;
               float var42 = 0.00390625F;
               float var43 = 0.99609375F;

               for (int var44 = 0; var44 < var83; var44++) {
                  int var45 = var44 * 4;
                  float var46 = w[var45];
                  float var47 = w[var45 + 1];
                  float var48 = w[var45 + 2];
                  float var49 = w[var45 + 3];
                  float var50 = var84 + ((float)var44 + (var46 - 0.5F) * 0.6F) * ((float) (Math.PI * 2) / (float)var83);
                  float var51 = MathHelper.cos((double)var50);
                  float var52 = MathHelper.sin((double)var50);
                  float var53 = var24 * var51 + var81 * var52;
                  float var54 = var25 * var51 + var29 * var52;
                  float var55 = var26 * var51 + var30 * var52;
                  float var56 = var24 * var52 - var81 * var51;
                  float var57 = var25 * var52 - var29 * var51;
                  float var58 = var26 * var52 - var30 * var51;
                  float var59 = var17 * (0.2F + 0.28F * var47);
                  float var60 = var17 * (0.05F + 0.06F * var48);
                  float var61 = 0.5F + 0.5F * MathHelper.sin(var8 * (0.09 + 0.12 * (double)var49) + (double)(var46 * (float) (Math.PI * 2)));
                  float var62 = (var54 + 0.55F) / 0.9F;
                  var62 = var62 < 0.0F ? 0.0F : (var62 > 1.0F ? 1.0F : var62);
                  float var63 = (0.35F + 0.65F * var49) * (0.35F + 0.65F * var61) * (0.25F + 0.75F * var62);
                  int var64 = (int)(0.07F * var20 * var63 * 255.0F + 0.5F);
                  if (var64 > 1) {
                     if (var64 > (-448584110 ^ -448584019)) {
                        var64 = 1524813001 ^ 1524812854;
                     }

                     int var65 = (var44 & 1) == 0 ? 9 : 12;
                     int var66 = var14[var65];
                     int var67 = var14[var65 + 1];
                     int var68 = var14[var65 + 2];
                     float var69 = var53 * var59;
                     float var70 = var54 * var59;
                     float var71 = var55 * var59;
                     float var72 = var2 + var69;
                     float var73 = var3 + var70;
                     float var74 = var4 + var71;
                     float var75 = var56 * var60;
                     float var76 = var57 * var60;
                     float var77 = var58 * var60;
                     var0.vertex(var1, var72 - var75 - var69, var73 - var76 - var70, var74 - var77 - var71)
                        .texture(var40, var43)
                        .color(var66, var67, var68, var64);
                     var0.vertex(var1, var72 - var75 + var69, var73 - var76 + var70, var74 - var77 + var71)
                        .texture(var40, var42)
                        .color(var66, var67, var68, var64);
                     var0.vertex(var1, var72 + var75 + var69, var73 + var76 + var70, var74 + var77 + var71)
                        .texture(var41, var42)
                        .color(var66, var67, var68, var64);
                     var0.vertex(var1, var72 + var75 - var69, var73 + var76 - var70, var74 + var77 - var71)
                        .texture(var41, var43)
                        .color(var66, var67, var68, var64);
                  }
               }

               k(
                  var0,
                  var1,
                  var2,
                  var3,
                  var4,
                  var31 * var17 * 1.7F,
                  0.0F,
                  var32 * var17 * 1.7F,
                  var34 * var17 * 0.8F,
                  var35 * var17 * 0.8F,
                  var36 * var17 * 0.8F,
                  1,
                  var14[15],
                  var14[16],
                  var14[17],
                  0.16F * var19
               );
               k(
                  var0,
                  var1,
                  var2,
                  var3,
                  var4,
                  var31 * var17 * 1.15F,
                  0.0F,
                  var32 * var17 * 1.15F,
                  var34 * var17 * 0.6F,
                  var35 * var17 * 0.6F,
                  var36 * var17 * 0.6F,
                  1,
                  var14[18],
                  var14[19],
                  var14[20],
                  0.26F * var19
               );
               k(
                  var0,
                  var1,
                  var2,
                  var3,
                  var4,
                  var31 * var17 * 0.52F,
                  0.0F,
                  var32 * var17 * 0.52F,
                  var34 * var17 * 0.42F,
                  var35 * var17 * 0.42F,
                  var36 * var17 * 0.42F,
                  1,
                  var14[21],
                  var14[22],
                  var14[23],
                  0.32F * var18
               );
               float var85 = var17 * 0.168F;
               k(
                  var0,
                  var1,
                  var2,
                  var3,
                  var4,
                  var24 * var85,
                  var25 * var85,
                  var26 * var85,
                  var81 * var85,
                  var29 * var85,
                  var30 * var85,
                  1,
                  var14[24],
                  var14[25],
                  var14[26],
                  0.08F * var18
               );

               for (int var86 = 0; var86 < 3; var86++) {
                  double var88 = var8 * 0.0032 + (double)var86 * 0.37;
                  float var91 = (float)(var88 - Math.floor(var88));
                  float var93 = MathHelper.sin((double)(var91 * (float) Math.PI));
                  var93 *= var93;
                  float var96 = (var86 & 1) == 0 ? 1.0F : -1.0F;
                  float var98 = (var91 - 0.5F) * var17 * 0.6F * var96;
                  float var100 = var3 + var17 * (var86 == 0 ? 0.115F : (var86 == 1 ? 0.085F : 0.15F));
                  float var102 = var17 * (var86 == 0 ? 0.3F : (var86 == 1 ? 0.22F : 0.42F));
                  float var105 = var17 * (var86 == 0 ? 0.027F : (var86 == 1 ? 0.02F : 0.034F));
                  float var108 = var98 / (var17 * 0.3F);
                  float var110 = 1.0F / (1.0F + var108 * var108);
                  float var112 = 0.6F * var19 * var93 * (0.35F + 0.65F * var110) * (var86 == 2 ? 0.7F : 1.0F);
                  float var114 = var98 - var102 * 0.42F * var96;
                  float var116 = var98 + var102 * 0.3F * var96;
                  k(
                     var0,
                     var1,
                     var2 + var31 * var114,
                     var100,
                     var4 + var32 * var114,
                     var31 * var102 * 0.55F,
                     0.0F,
                     var32 * var102 * 0.55F,
                     0.0F,
                     var105,
                     0.0F,
                     1,
                     var14[27],
                     var14[28],
                     var14[29],
                     0.18F * var112
                  );
                  k(
                     var0,
                     var1,
                     var2 + var31 * var116,
                     var100 - var17 * 0.004F,
                     var4 + var32 * var116,
                     var31 * var102 * 0.75F,
                     0.0F,
                     var32 * var102 * 0.75F,
                     0.0F,
                     var105 * 0.75F,
                     0.0F,
                     1,
                     var14[30],
                     var14[31],
                     var14[32],
                     0.21F * var112
                  );
               }

               float var87 = 0.985F + 0.015F * MathHelper.sin(var8 * 0.7);
               float var89 = var17 * 0.07F;
               k(
                  var0,
                  var1,
                  var2,
                  var3,
                  var4,
                  var24 * var89,
                  var25 * var89,
                  var26 * var89,
                  var81 * var89,
                  var29 * var89,
                  var30 * var89,
                  0,
                  var14[33],
                  var14[34],
                  var14[35],
                  0.85F * var6 * (1.5F - 0.5F * var6) * var87
               );
               if (var11 > 0.003F) {
                  float var90 = var21 * var10[0] + var22 * var10[1] + var23 * var10[2];
                  float var92 = var21 * var10[3] + var22 * var10[4] + var23 * var10[5];
                  float var95 = var21 * var10[6] + var22 * var10[7] + var23 * var10[8];
                  if (var95 > 0.2F) {
                     float var97 = var90 / var95;
                     float var99 = var92 / var95;
                     float var101 = MathHelper.sqrt(var97 * var97 + var99 * var99);
                     float var103 = (var101 - 0.3F) / 1.1F;
                     float var106 = (var101 - 0.05F) / 0.3F;
                     var103 = var103 < 0.0F ? 0.0F : (var103 > 1.0F ? 1.0F : var103);
                     var106 = var106 < 0.0F ? 0.0F : (var106 > 1.0F ? 1.0F : var106);
                     float var109 = (1.0F - var103 * var103 * (3.0F - 2.0F * var103)) * var106 * var106 * (3.0F - 2.0F * var106);
                     float var111 = (var11 < 0.0F ? 0.0F : (var11 > 1.0F ? 1.0F : var11)) * var6 * var109 * (0.55F + 0.45F * var16);
                     if (var111 > 0.003F) {
                        float var113 = 0.6F;

                        for (int var115 = 0; var115 < 6; var115++) {
                           float var117 = x[var115];
                           float var118 = var97 * var117;
                           float var119 = var99 * var117;
                           float var121 = var113 * (var10[6] + var10[0] * var118 + var10[3] * var119);
                           float var122 = var113 * (var10[7] + var10[1] * var118 + var10[4] * var119);
                           float var123 = var113 * (var10[8] + var10[2] * var118 + var10[5] * var119);
                           float var124 = var113 * y[var115];
                           int var125 = 36 + var115 * 3;
                           k(
                              var0,
                              var1,
                              var121,
                              var122,
                              var123,
                              var10[0] * var124,
                              var10[1] * var124,
                              var10[2] * var124,
                              var10[3] * var124,
                              var10[4] * var124,
                              var10[5] * var124,
                              z[var115],
                              var14[var125],
                              var14[var125 + 1],
                              var14[var125 + 2],
                              aa[var115] * var111
                           );
                        }
                     }
                  }
               }
            }
         }
      }
   }

   private static void k(
      VertexConsumer var0,
      MatrixStack.Entry var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      int var11,
      int var12,
      int var13,
      int var14,
      float var15
   ) {

      int var16 = (int)(var15 * 255.0F + 0.5F);
      if (var16 > 1) {
         if (var16 > (425386955 ^ 425386804)) {
            var16 = 796648883 ^ 796648780;
         }

         float var17 = (float)var11 * 0.25F + 9.765625E-4F;
         float var18 = (float)(var11 + 1) * 0.25F - 9.765625E-4F;
         float var19 = 0.00390625F;
         float var20 = 0.99609375F;
         var0.vertex(var1, var2 - var5 - var8, var3 - var6 - var9, var4 - var7 - var10)
            .texture(var17, var20)
            .color(var12, var13, var14, var16);
         var0.vertex(var1, var2 - var5 + var8, var3 - var6 + var9, var4 - var7 + var10)
            .texture(var17, var19)
            .color(var12, var13, var14, var16);
         var0.vertex(var1, var2 + var5 + var8, var3 + var6 + var9, var4 + var7 + var10)
            .texture(var18, var19)
            .color(var12, var13, var14, var16);
         var0.vertex(var1, var2 + var5 - var8, var3 + var6 - var9, var4 + var7 - var10)
            .texture(var18, var20)
            .color(var12, var13, var14, var16);
      }
   }

   private static float l(int var0, int var1) {

      int var2 = var0 * (-1556517543 ^ 1024333032) + var1 * (-1512407006 ^ 540101193);
      var2 ^= var2 >>> 15;
      var2 *= -867347196 ^ -531207831;
      var2 ^= var2 >>> 12;
      var2 *= 1815959280 ^ 1162312649;
      var2 ^= var2 >>> 15;
      return (float)(var2 >>> 8) * 5.9604645E-8F;
   }

   static {
      for (int var0 = 0; var0 < 13; var0++) {
         for (int var1 = 1; var1 <= 4; var1++) {
            w[var0 * 4 + var1 - 1] = l(var0, var1);
         }
      }
   }
}
