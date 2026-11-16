package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import java.util.Arrays;

public final class LevelArrayCache {
   public static final int W = 512;
   public static final int H = 512;
   private static final int ae = 128;
   private static final int af = 16384;
   private static final double ag = 1.1;
   private static final int ah = 3000;
   private static final int ai = 128;
   private static final int aj = 0;
   private static final int ak = 1;
   private static final int al = 2;
   private static final int am = 3;
   private static final int an = 4;
   private static final int ao = 5;
   private static final int ap = 6;
   private static final int aq = 7;
   private static final int ar = 8;
   private static final int as = 9;
   private static final int at = 10;
   private static final int au = 11;
   private static final int av = 12;
   private static final int aw = 13;
   private static final int ax = 14;
   private static final int ay = 15;
   private static final int az = 16;
   private static final int ba = 17;
   private static final int bb = 18;
   private static final int bc = 19;
   private static final int bd = 20;
   private static final int be = 21;
   private static final int bf = 22;
   private static final int bg = 23;
   private static final int bh = 24;
   private static final int bi = 25;
   private static final int[][] bj = new int[][]{
      {16102204, 15493666, 13775132, 8264210, 16304226, 16226862, 11543066, 12600360, 15712894, 15243876, 14185295, 16244144},
      {11565620, 10636322, 8665628, 4858898, 13804642, 11049534, 7089174, 10251320, 13410416, 12616792, 11103308, 15190686},
      {13615676, 15976236, 15771430, 9852956, 16375930, 16308296, 13930016, 12101706, 14471806, 15455878, 15319668, 16181940},
      {14524730, 13400618, 10376742, 5582874, 15252582, 14988356, 8143904, 9333306, 14727806, 13934438, 12091474, 15784104}
   };

   private LevelArrayCache() {
   }

   public static int[] a() {

      int[] var0 = new int[262144];
      double[] var1 = new double[6000];
      double[] var2 = new double[1536];
      double[] var3 = new double[896];
      double[] var4 = new double[25];
      double[] var5 = new double[256];
      float[] var6 = new float[16384];
      float[] var7 = new float[16384];
      float[] var8 = new float[16384];
      float[] var9 = new float[16384];
      float[] var10 = new float[16384];
      float[] var11 = new float[16384];
      float[] var12 = new float[16384];
      float[] var13 = new float[16384];
      float[] var14 = new float[16384];
      float[] var15 = new float[16384];
      float[] var16 = new float[16384];
      float[] var17 = new float[16384];
      float[] var18 = new float[16384];
      float[] var19 = new float[65536];
      float[] var20 = new float[65536];
      int[] var21 = new int[16384];
      float[] var22 = t();

      for (int var23 = 0; var23 < 4; var23++) {
         Arrays.fill(var4, 0.0);
         int var24;
         if (var23 == 0) {
            var24 = c(var2, var4, var5);
         } else if (var23 == 1) {
            var24 = e(var2, var4, var5);
         } else {
            var24 = f(var23, var2, var4, var5);
         }

         int var26 = var24 >>> 16;
         var24 &= -980851624 ^ -980837465;
         int var25 = k(var2, var26, var1);
         l(var23, var1, var25, var4);
         int var27 = p(var23, var4, var5, var24, var3);
         q(var1, var25, var6);
         r(var23, var4, var6, var7);
         s(var3, var27, var6, var8, var9, var10);
         u(var22, var16, 0.055, 3.0 + (double)var23 * 7.0, 11.0 + (double)var23 * 5.0, 3);
         u(var22, var17, 0.11, 29.0 + (double)var23 * 3.0, 7.0 + (double)var23 * 13.0, 2);
         v(var23, var18, 5.2 + (var23 == 3 ? -0.8 : 0.0));
         w(var23, var4, var6, var11, var13);
         aa(var13, var14, var15);
         x(var23, var6, var8, var9, var10, var13, var16, var12);

         for (int var28 = 0; var28 < 2; var28++) {
            Arrays.fill(var19, 0.0F);
            y(var23, var28, var4, var6, var7, var8, var9, var11, var12, var13, var14, var16, var17, var18, var19);
            ab(var23 * 2 + var28, var19, var20, var21, var0);
         }
      }

      return var0;
   }

   private static int b(double[] var0, int var1, double var2, double var4, double var6) {

      var0[var1 * 3] = var2;
      var0[var1 * 3 + 1] = var4;
      var0[var1 * 3 + 2] = var6;
      return var1 + 1;
   }

   private static int c(double[] var0, double[] var1, double[] var2) {

      double var3 = 64.0;
      double var5 = 70.0;
      double var7 = 1.08;
      var1[0] = var3;
      var1[1] = var5;
      var1[2] = 56.0 * var7;
      double[] var9 = new double[]{
         0.0,
         56.0,
         0.0,
         1.0,
         0.0,
         7.5,
         41.0,
         0.14,
         0.0,
         0.0,
         15.5,
         46.0,
         0.0,
         2.0,
         0.0,
         20.0,
         34.5,
         0.16,
         0.0,
         0.0,
         30.0,
         21.0,
         0.42,
         0.0,
         0.0,
         42.0,
         33.0,
         0.0,
         2.0,
         60.0,
         46.0,
         31.5,
         0.14,
         0.0,
         0.0,
         60.0,
         54.0,
         0.0,
         1.0,
         60.0,
         67.5,
         40.0,
         0.14,
         0.0,
         0.0,
         74.0,
         43.0,
         0.0,
         2.0,
         60.0,
         81.0,
         30.0,
         0.18,
         0.0,
         0.0,
         96.0,
         18.0,
         0.42,
         0.0,
         0.0,
         107.0,
         28.5,
         0.0,
         2.0,
         123.0,
         112.0,
         26.0,
         0.14,
         0.0,
         0.0,
         123.0,
         36.0,
         0.0,
         1.0,
         123.0,
         135.0,
         22.0,
         0.2,
         0.0,
         0.0,
         150.0,
         14.0,
         0.35,
         0.0,
         0.0,
         170.0,
         7.5,
         0.3,
         0.0,
         0.0
      };
      int var10 = var9.length / 5;
      int var11 = 0;
      int var12 = 0;

      for (int var13 = 0; var13 < 2; var13++) {
         for (int var14 = 0; var14 < var10; var14++) {
            int var15 = var13 == 0 ? var14 : var10 - 1 - var14;
            if (var13 != 1 || var15 != 0) {
               double var16 = var9[var15 * 5];
               double var18 = var9[var15 * 5 + 1] * var7;
               double var20 = var9[var15 * 5 + 2];
               int var22 = (int)var9[var15 * 5 + 3];
               if (var13 == 1) {
                  var16 = -var16 - 2.5 * ac(0, var15, 1) * (var15 > 0 ? 1.0 : 0.0);
                  var18 *= 1.0 + 0.045 * ac(0, var15, 2);
               }

               double var23 = Math.toRadians(var16);
               double var25 = var3 + Math.sin(var23) * var18;
               double var27 = var5 - Math.cos(var23) * var18;
               var11 = b(var0, var11, var25, var27, var20);
               if (var22 > 0) {
                  double var29 = var9[var15 * 5 + 4] * (var13 == 1 ? -1.0 : 1.0);
                  var2[var12 * 4] = var25;
                  var2[var12 * 4 + 1] = var27;
                  var2[var12 * 4 + 2] = var22 == 1 ? 1.0 : 0.6;
                  var2[var12 * 4 + 3] = var29;
                  var12++;
               }
            }
         }
      }

      var1[3] = var3;
      var1[4] = var5 - 2.0;
      var1[5] = var3 + 1.5;
      var1[6] = var5 + 24.0;
      var1[7] = var3 + 7.0;
      var1[8] = 116.0;
      var1[9] = 1.55;
      var1[10] = 1.0;

      for (int var31 = 0; var31 < var12; var31++) {
         if (var2[var31 * 4 + 2] > 0.99 && var2[var31 * 4 + 3] < -30.0 && var2[var31 * 4 + 3] > -90.0) {
            d(var1, var3, var5, var2[var31 * 4], var2[var31 * 4 + 1], 17.0, 13.0);
         }
      }

      return var11 << 16 | var12;
   }

   private static void d(double[] var0, double var1, double var3, double var5, double var7, double var9, double var11) {

      double var13 = var5 - var1;
      double var15 = var7 - var3;
      double var17 = Math.sqrt(var13 * var13 + var15 * var15);
      var0[11] = 1.0;
      var0[12] = var5;
      var0[13] = var7;
      var0[14] = var13 / var17;
      var0[15] = var15 / var17;
      var0[16] = var9;
      var0[17] = var11;
   }

   private static int e(double[] var0, double[] var1, double[] var2) {

      double var3 = 64.0;
      double var5 = 108.5;
      double var7 = 97.0;
      var1[0] = var3;
      var1[1] = var5;
      var1[2] = var7;
      double[] var9 = new double[]{
         0.04,
         0.012,
         0.1,
         0.04,
         0.045,
         0.1,
         0.225,
         0.175,
         0.075,
         0.245,
         0.345,
         0.335,
         0.1,
         0.425,
         0.405,
         0.52,
         0.105,
         0.62,
         0.345,
         0.705,
         0.085,
         0.79,
         0.215,
         0.86
      };
      double[] var10 = new double[]{
         0.04, 0.012, 0.11, 0.05, 0.05, 0.125, 0.25, 0.215, 0.085, 0.29, 0.365, 0.39, 0.105, 0.485, 0.39, 0.58, 0.1, 0.675, 0.3, 0.755, 0.07, 0.83, 0.17, 0.89
      };
      int var11 = 0;
      int var12 = 0;
      var11 = b(var0, var11, var3, var5 + 1.0, 0.3);

      for (byte var13 = -1; var13 <= 1; var13 += 2) {
         double[] var14 = var13 < 0 ? var10 : var9;
         int var15 = var14.length / 4;
         double[] var17 = new double[var15 * 3 * 3];
         int var18 = 0;

         for (int var19 = 0; var19 < var15; var19++) {
            double var20 = var14[var19 * 4];
            double var22 = var14[var19 * 4 + 1];
            double var24 = var14[var19 * 4 + 2] * (1.0 + 0.05 * ac(1, var19 * 2 + (var13 > 0 ? 1 : 0), 3));
            double var26 = var14[var19 * 4 + 3];
            double var28 = var19 + 1 < var15 ? var14[(var19 + 1) * 4 + 1] : 0.94;
            double var30 = (var28 - var22) * 0.5;
            var17[var18 * 3] = var20;
            var17[var18 * 3 + 1] = var22;
            var17[var18 * 3 + 2] = 0.32;
            var18++;
            var17[var18 * 3] = var24 * 0.93;
            var17[var18 * 3 + 1] = var26 - var30 * 0.42;
            var17[var18 * 3 + 2] = 0.5;
            var18++;
            var17[var18 * 3] = var24;
            var17[var18 * 3 + 1] = var26 + var30 * 0.28;
            var17[var18 * 3 + 2] = 0.5;
            var18++;
            var2[var12 * 4] = var3 + (double)var13 * var24 * 0.98 * var7;
            var2[var12 * 4 + 1] = var5 - (var26 + var30 * 0.02) * var7;
            var2[var12 * 4 + 2] = 0.75;
            var2[var12 * 4 + 3] = var26;
            var12++;
         }

         if (var13 >= 0) {
            for (int var40 = var18 - 1; var40 >= 0; var40--) {
               var11 = b(var0, var11, var3 + var17[var40 * 3] * var7, var5 - var17[var40 * 3 + 1] * var7, var17[var40 * 3 + 2]);
            }
         } else {
            for (int var39 = 0; var39 < var18; var39++) {
               var11 = b(var0, var11, var3 - var17[var39 * 3] * var7, var5 - var17[var39 * 3 + 1] * var7, var17[var39 * 3 + 2]);
            }

            var11 = b(var0, var11, var3 - 0.055 * var7, var5 - 0.915 * var7, 0.3);
            var11 = b(var0, var11, var3 - 0.115 * var7, var5 - 0.965 * var7, 0.5);
            var11 = b(var0, var11, var3 + 0.01 * var7, var5 - 1.0 * var7, 0.5);
            var11 = b(var0, var11, var3 + 0.105 * var7, var5 - 0.955 * var7, 0.5);
            var11 = b(var0, var11, var3 + 0.05 * var7, var5 - 0.905 * var7, 0.3);
         }
      }

      var1[3] = var3;
      var1[4] = var5 - 3.0;
      var1[5] = var3 - 0.5;
      var1[6] = var5 + 4.0;
      var1[7] = var3 - 3.0;
      var1[8] = 116.0;
      var1[9] = 1.6;
      var1[10] = 1.25;
      d(var1, var3 + 0.12 * var7, var5 - 0.5 * var7, var3 + 0.4 * var7, var5 - 0.53 * var7, 14.0, 12.0);
      return var11 << 16 | var12;
   }

   private static int f(int var0, double[] var1, double[] var2, double[] var3) {

      boolean var4 = var0 == 3;
      double var5 = 64.0;
      double var7 = var4 ? 110.0 : 101.0;
      double var9 = var4 ? 99.0 : 86.0;
      double var11 = var4 ? 0.29 : 0.375;
      double var13 = var4 ? 0.5 : 0.3;
      int var15 = var4 ? 11 : 8;
      double var16 = var4 ? 2.7 : 3.4;
      double var18 = var4 ? 1.3 : 1.6;
      double var20 = var4 ? 0.8 : 0.9;
      var2[0] = var5;
      var2[1] = var7;
      var2[2] = var9;
      var2[22] = var11;
      var2[23] = var13;
      var2[24] = 0.0;
      int var22 = 0;
      int var23 = 0;
      var22 = b(var1, var22, var5, var7 + 0.5, 0.3);
      double[] var24 = new double[(var15 * 4 + 8) * 5];

      for (byte var25 = -1; var25 <= 1; var25 += 2) {
         double var26 = var4 && var25 > 0 ? 0.075 : 0.0;
         double var28 = var26 + 0.075;
         double var30 = var4 ? 0.935 : 0.9;
         double var32 = (var30 - var28) / (double)var15;
         int var34 = 0;
         var34 = h(var24, var34, 0.0, var26 + 0.012, 0.35, 0, 0.0);

         for (int var35 = 0; var35 < var15; var35++) {
            double var36 = var28 + var32 * (double)var35;
            double var38 = var4 ? 1.0 - ad(0.8, 0.96, var36) : 1.0 - ad(0.66, 0.86, var36);
            double var40 = 1.0 + 0.14 * ac(var0, var35 * 2 + (var25 > 0 ? 1 : 0), 7);
            var34 = h(var24, var34, -var20 * var38, var36, 0.25, 0, 0.0);
            var34 = h(var24, var34, var18 * var38 * var40, var36 + var32 * 0.4, 0.0, 0, 0.45);
            var34 = h(var24, var34, -var20 * 0.35 * var38, var36 + var32 * 0.54, 0.2, 0, 0.0);
            var34 = h(var24, var34, var16 * var38 * var40, var36 + var32 * 0.88, 0.0, var35 < var15 - 1 ? 1 : 0, 0.55);
         }

         for (int var69 = 0; var69 < var34; var69++) {
            double var72 = var24[var69 * 5 + 1];
            double var73 = var24[var69 * 5];
            double var74 = i(var4, var72, var26, var13, var11);
            double var42 = 0.004;
            double var44 = (i(var4, var72 + var42, var26, var13, var11) - i(var4, var72 - var42, var26, var13, var11)) / (2.0 * var42);
            double var46 = (j(var0, var72 + var42) - j(var0, var72 - var42)) / (2.0 * var42);
            double var48 = (double)var25 * var44 + var46;
            double var50 = -1.0;
            double var52 = Math.sqrt(var48 * var48 + var50 * var50);
            var48 /= var52;
            var50 /= var52;
            double var54 = (double)var25 * -var50;
            double var56 = (double)var25 * var48;
            double var58 = var24[var69 * 5 + 4];
            double var60 = var5 + (double)var25 * var74 * var9 + j(var0, var72) * var9 + var54 * var73 + var48 * var73 * var58;
            double var62 = var7 - var72 * var9 + var56 * var73 + var50 * var73 * var58;
            var24[var69 * 5] = var60;
            var24[var69 * 5 + 1] = var62;
         }

         if (var25 < 0) {
            for (int var71 = 0; var71 < var34; var71++) {
               var22 = b(var1, var22, var24[var71 * 5], var24[var71 * 5 + 1], var24[var71 * 5 + 2]);
               if (var24[var71 * 5 + 3] > 0.0) {
                  var23 = g(var3, var23, var24[var71 * 5], var24[var71 * 5 + 1], 0.6, (var7 - var24[var71 * 5 + 1]) / var9);
               }
            }

            var22 = b(var1, var22, var5 + j(var0, 1.0) * var9, var7 - var9, 0.0);
         } else {
            for (int var70 = var34 - 1; var70 >= 0; var70--) {
               var22 = b(var1, var22, var24[var70 * 5], var24[var70 * 5 + 1], var24[var70 * 5 + 2]);
               if (var24[var70 * 5 + 3] > 0.0) {
                  var23 = g(var3, var23, var24[var70 * 5], var24[var70 * 5 + 1], 0.6, (var7 - var24[var70 * 5 + 1]) / var9);
               }
            }

            if (var4) {
               var22 = b(var1, var22, var5 + 1.0, var7 - var26 * var9 + 1.0, 0.4);
            }
         }
      }

      var2[3] = var5;
      var2[4] = var7 - 3.0;
      var2[5] = var5 - (var4 ? 0.5 : 2.0);
      var2[6] = var7 + (var4 ? 3.0 : 8.0);
      var2[7] = var5 - (var4 ? 2.0 : 5.0);
      var2[8] = 116.0;
      var2[9] = var4 ? 1.35 : 1.15;
      var2[10] = var4 ? 1.0 : 0.8;
      var2[11] = 2.0;
      var2[18] = var4 ? -1.0 : 1.0;
      var2[19] = var4 ? 0.3 : 0.2;
      var2[20] = var4 ? 0.74 : 0.62;
      var2[21] = var4 ? 4.6 : 5.0;
      return var22 << 16 | var23;
   }

   private static int g(double[] var0, int var1, double var2, double var4, double var6, double var8) {

      var0[var1 * 4] = var2;
      var0[var1 * 4 + 1] = var4;
      var0[var1 * 4 + 2] = var6;
      var0[var1 * 4 + 3] = var8;
      return var1 + 1;
   }

   private static int h(double[] var0, int var1, double var2, double var4, double var6, int var8, double var9) {

      var0[var1 * 5] = var2;
      var0[var1 * 5 + 1] = var4;
      var0[var1 * 5 + 2] = var6;
      var0[var1 * 5 + 3] = (double)var8;
      var0[var1 * 5 + 4] = var9;
      return var1 + 1;
   }

   private static double i(boolean var0, double var1, double var3, double var5, double var7) {

      if (var1 <= var3) {
         return 0.0;
      } else if (var1 < var5) {
         double var11 = (var1 - var3) / (var5 - var3);
         return var7 * Math.pow(Math.sin(var11 * Math.PI * 0.5), var0 ? 0.75 : 0.5);
      } else {
         double var9 = (var1 - var5) / (1.0 - var5);
         return var9 >= 1.0 ? 0.0 : var7 * Math.pow(Math.cos(var9 * Math.PI * 0.5), var0 ? 1.05 : 1.3);
      }
   }

   private static double j(int var0, double var1) {

      if (var0 == 2) {
         double var3 = (var1 - 0.7) / 0.3;
         return var3 > 0.0 ? -0.05 * var3 * var3 : 0.0;
      } else {
         return 0.035 * var1 * (1.0 - var1) * 4.0 * 0.5;
      }
   }

   private static int k(double[] var0, int var1, double[] var2) {

      int var3 = 0;

      for (int var4 = 0; var4 < var1; var4++) {
         int var5 = (var4 + var1 - 1) % var1;
         int var6 = (var4 + 1) % var1;
         double var7 = var0[var4 * 3];
         double var9 = var0[var4 * 3 + 1];
         double var11 = var0[var4 * 3 + 2];
         if (var11 <= 0.0) {
            var2[var3 * 2] = var7;
            var2[var3 * 2 + 1] = var9;
            var3++;
         } else {
            double var13 = var7 + (var0[var5 * 3] - var7) * var11;
            double var15 = var9 + (var0[var5 * 3 + 1] - var9) * var11;
            double var17 = var7 + (var0[var6 * 3] - var7) * var11;
            double var19 = var9 + (var0[var6 * 3 + 1] - var9) * var11;
            byte var21 = 10;

            for (int var22 = 0; var22 <= var21; var22++) {
               double var23 = (double)var22 / (double)var21;
               double var25 = (1.0 - var23) * (1.0 - var23);
               double var27 = 2.0 * var23 * (1.0 - var23);
               double var29 = var23 * var23;
               var2[var3 * 2] = var25 * var13 + var27 * var7 + var29 * var17;
               var2[var3 * 2 + 1] = var25 * var15 + var27 * var9 + var29 * var19;
               var3++;
            }
         }
      }

      return var3;
   }

   private static void l(int var0, double[] var1, int var2, double[] var3) {

      for (int var4 = 0; var4 < var2; var4++) {
         double var5 = var1[var4 * 2];
         double var7 = var1[var4 * 2 + 1];
         double var9 = m(var0, var3, var5, var7);
         if (!(var9 <= 0.0)) {
            if (var3[11] == 1.0) {
               double var11 = 0.26 * var3[16] * var9 * var9;
               var1[var4 * 2] = var5 - var3[14] * var11;
               var1[var4 * 2 + 1] = var7 - var3[15] * var11;
            } else {
               double var19 = var3[2];
               double var13 = (var3[1] - var7) / var19;
               double var15 = var3[0] + j(var0, var13) * var19;
               double var17 = 0.42 * var3[21] * var9;
               var1[var4 * 2] = var5 - Math.signum(var5 - var15) * var17;
            }
         }
      }
   }

   private static double m(int var0, double[] var1, double var2, double var4) {

      if (var1[11] == 1.0) {
         double var18 = var1[12] - var2;
         double var19 = var1[13] - var4;
         double var20 = var18 * var1[14] + var19 * var1[15];
         double var21 = Math.abs(var18 * var1[15] - var19 * var1[14]);
         return !(var20 < -3.0) && !(var20 > var1[16]) ? (1.0 - ad(0.0, var1[16], var20)) * (1.0 - ad(var1[17] * 0.55, var1[17], var21)) : 0.0;
      } else if (var1[11] != 2.0) {
         return 0.0;
      } else {
         double var6 = var1[2];
         double var8 = (var1[1] - var4) / var6;
         double var10 = (var2 - var1[0] - j(var0, var8) * var6) * var1[18];
         if (var10 <= 0.0) {
            return 0.0;
         } else {
            double var12 = i(var0 == 3, var8, var1[24], var1[23], var1[22]) * var6;
            double var14 = var1[21];
            double var16 = ad(var1[19], var1[19] + 0.09, var8) * (1.0 - ad(var1[20] - 0.09, var1[20], var8));
            return var16 * ad(var12 - var14, var12 - var14 * 0.2, var10);
         }
      }
   }

   private static int n(double[] var0, int var1, double var2, double var4, double var6, double var8, double var10, double var12, double var14) {

      if (var1 >= (-636486180 ^ -636486308)) {
         return var1;
      } else {
         int var16 = var1 * 7;
         var0[var16] = var2;
         var0[var16 + 1] = var4;
         var0[var16 + 2] = var6;
         var0[var16 + 3] = var8;
         var0[var16 + 4] = var10;
         var0[var16 + 5] = var12;
         var0[var16 + 6] = var14;
         return var1 + 1;
      }
   }

   private static int o(
      double[] var0, int var1, double var2, double var4, double var6, double var8, double var10, double var12, double var14, double var16, double var18
   ) {

      double var20 = var2;
      double var22 = var4;
      double var24 = var14;

      for (int var26 = 1; var26 <= 3; var26++) {
         double var27 = (double)var26 / 3.0;
         double var29 = (1.0 - var27) * (1.0 - var27);
         double var31 = 2.0 * var27 * (1.0 - var27);
         double var33 = var27 * var27;
         double var35 = var29 * var2 + var31 * var6 + var33 * var10;
         double var37 = var29 * var4 + var31 * var8 + var33 * var12;
         double var39 = var14 + (var16 - var14) * var27;
         var1 = n(var0, var1, var20, var22, var35, var37, var24, var39, var18);
         var20 = var35;
         var22 = var37;
         var24 = var39;
      }

      return var1;
   }

   private static int p(int var0, double[] var1, double[] var2, int var3, double[] var4) {

      int var5 = 0;
      double var6 = var1[0];
      double var8 = var1[1];
      double var10 = var1[2];
      if (var0 == 0) {
         for (int var52 = 0; var52 < var3; var52++) {
            if (!(var2[var52 * 4 + 2] < 0.99)) {
               double var55 = var2[var52 * 4];
               double var58 = var2[var52 * 4 + 1];
               double var61 = var6 + (var55 - var6) * 0.93;
               double var65 = var8 + (var58 - var8) * 0.93;
               double var21 = var6 + (var55 - var6) * 0.5 + (var58 - var8) * 0.04;
               double var23 = var8 + (var58 - var8) * 0.5 - (var55 - var6) * 0.04;
               var5 = o(var4, var5, var6, var8, var21, var23, var61, var65, 1.25, 0.35, 1.0);
            }
         }

         for (int var53 = 0; var53 < var3; var53++) {
            if (!(var2[var53 * 4 + 2] > 0.99)) {
               double var56 = var2[var53 * 4];
               double var59 = var2[var53 * 4 + 1];
               double var62 = Math.toRadians(var2[var53 * 4 + 3]);
               double var66 = Math.sin(var62);
               double var69 = -Math.cos(var62);
               double var72 = ((var56 - var6) * var66 + (var59 - var8) * var69) * 0.52;
               double var25 = var6 + var66 * var72;
               double var27 = var8 + var69 * var72;
               double var29 = var25 + (var56 - var25) * 0.9;
               double var31 = var27 + (var59 - var27) * 0.9;
               var5 = o(
                  var4,
                  var5,
                  var25,
                  var27,
                  var25 + (var56 - var25) * 0.45 + var66 * 3.0,
                  var27 + (var59 - var27) * 0.45 + var69 * 3.0,
                  var29,
                  var31,
                  0.7,
                  0.28,
                  0.62
               );
            }
         }

         for (int var54 = 0; var54 < var3; var54++) {
            if (!(var2[var54 * 4 + 2] < 0.99)) {
               double var57 = var2[var54 * 4];
               double var60 = var2[var54 * 4 + 1];
               double var63 = Math.sqrt((var57 - var6) * (var57 - var6) + (var60 - var8) * (var60 - var8));
               double var67 = (var57 - var6) / var63;
               double var70 = (var60 - var8) / var63;

               for (int var73 = 0; var73 < 2; var73++) {
                  double var75 = var63 * (0.3 + 0.28 * (double)var73);
                  double var77 = var6 + var67 * var75;
                  double var78 = var8 + var70 * var75;

                  for (byte var79 = -1; var79 <= 1; var79 += 2) {
                     double var80 = Math.cos(Math.toRadians(50.0));
                     double var33 = Math.sin(Math.toRadians(50.0)) * (double)var79;
                     double var35 = var67 * var80 - var70 * var33;
                     double var37 = var67 * var33 + var70 * var80;
                     double var39 = var63 * (0.2 - 0.05 * (double)var73);
                     var5 = n(var4, var5, var77, var78, var77 + var35 * var39, var78 + var37 * var39, 0.42, 0.18, 0.4);
                  }
               }
            }
         }

         return var5;
      } else {
         byte var12 = 6;
         double var13 = var6 + j(var0, -0.02) * var10;
         double var15 = var8 + 0.02 * var10;
         double var17 = var0 == 1 ? 1.4 : (var0 == 3 ? 1.3 : 1.15);

         for (int var19 = 1; var19 <= var12; var19++) {
            double var20 = -0.02 + 0.99 * (double)var19 / (double)var12;
            double var22 = var6 + j(var0, var20) * var10;
            double var24 = var8 - var20 * var10;
            double var26 = var17 * (1.0 - 0.72 * (double)var19 / (double)var12);
            var5 = n(var4, var5, var13, var15, var22, var24, var17 * (1.0 - 0.72 * (double)(var19 - 1) / (double)var12), var26, 1.0);
            var13 = var22;
            var15 = var24;
         }

         for (int var64 = 0; var64 < var3; var64++) {
            double var68 = var2[var64 * 4];
            double var71 = var2[var64 * 4 + 1];
            double var74 = (var8 - var71) / var10;
            double var76 = var6 + j(var0, var74) * var10;
            double var28 = Math.abs(var68 - var76) / var10;
            double var30 = var74 - var28 * (var0 == 1 ? 0.62 : (var0 == 3 ? 0.78 : 0.72));
            if (var30 < 0.015) {
               var30 = 0.015;
            }

            double var32 = var6 + j(var0, var30) * var10;
            double var34 = var8 - var30 * var10;
            double var36 = var32 + (var68 - var32) * 0.9;
            double var38 = var34 + (var71 - var34) * 0.9;
            double var40 = var32 + (var68 - var32) * 0.5;
            double var42 = var34 + (var71 - var34) * 0.5 - (var0 == 1 ? 3.0 : 1.2);
            double var44 = var0 == 1 ? 0.85 : (var0 == 3 ? 0.62 : 0.66);
            var5 = o(var4, var5, var32, var34, var40, var42, var36, var38, var44, 0.25, 0.62);
            if (var0 == 1) {
               double var46 = var32 + (var68 - var32) * 0.35;
               double var48 = var34 + (var71 - var34) * 0.35;
               double var50 = Math.atan2(var71 - var34, var68 - var32) + (var68 > var76 ? -0.9 : 0.9);
               var5 = n(var4, var5, var46, var48, var46 + Math.cos(var50) * 8.0, var48 + Math.sin(var50) * 8.0, 0.36, 0.15, 0.4);
            }
         }

         return var5;
      }
   }

   private static void q(double[] var0, int var1, float[] var2) {

      int var3 = (var1 + 15) / 16;
      double[] var4 = new double[var3 * 4];

      for (int var5 = 0; var5 < var3; var5++) {
         double var6 = 1.0E9;
         double var8 = 1.0E9;
         double var10 = -1.0E9;
         double var12 = -1.0E9;

         for (int var14 = var5 * 16; var14 <= Math.min(var1, var5 * 16 + 16); var14++) {
            int var15 = var14 % var1;
            var6 = Math.min(var6, var0[var15 * 2]);
            var10 = Math.max(var10, var0[var15 * 2]);
            var8 = Math.min(var8, var0[var15 * 2 + 1]);
            var12 = Math.max(var12, var0[var15 * 2 + 1]);
         }

         var4[var5 * 4] = var6;
         var4[var5 * 4 + 1] = var8;
         var4[var5 * 4 + 2] = var10;
         var4[var5 * 4 + 3] = var12;
      }

      double[] var43 = new double[256];

      for (int var44 = 0; var44 < (-558907043 ^ -558906915); var44++) {
         double var7 = (double)var44 + 0.5;
         int var9 = 0;

         for (int var45 = 0; var45 < var1; var45++) {
            int var11 = var45 + 1 == var1 ? 0 : var45 + 1;
            double var48 = var0[var45 * 2 + 1];
            double var50 = var0[var11 * 2 + 1];
            if (var48 <= var7 && var50 > var7 || var50 <= var7 && var48 > var7) {
               double var16 = (var7 - var48) / (var50 - var48);
               double var18 = var0[var45 * 2] + (var0[var11 * 2] - var0[var45 * 2]) * var16;
               if (var9 < var43.length) {
                  int var20;
                  for (var20 = var9++; var20 > 0 && var43[var20 - 1] > var18; var20--) {
                     var43[var20] = var43[var20 - 1];
                  }

                  var43[var20] = var18;
               }
            }
         }

         int var46 = 0;

         for (int var47 = 0; var47 < (-1596513572 ^ -1596513700); var47++) {
            double var49 = (double)var47 + 0.5;

            while (var46 < var9 && var43[var46] < var49) {
               var46++;
            }

            boolean var51 = (var46 & 1) == 1;
            double var52 = 1.0E18;

            for (int var17 = 0; var17 < var3; var17++) {
               double var54 = Math.max(Math.max(var4[var17 * 4] - var49, var49 - var4[var17 * 4 + 2]), 0.0);
               double var55 = Math.max(Math.max(var4[var17 * 4 + 1] - var7, var7 - var4[var17 * 4 + 3]), 0.0);
               if (!(var54 * var54 + var55 * var55 >= var52)) {
                  int var22 = Math.min(var1, var17 * 16 + 16);

                  for (int var23 = var17 * 16; var23 < var22; var23++) {
                     int var24 = var23 + 1 == var1 ? 0 : var23 + 1;
                     double var25 = var0[var23 * 2];
                     double var27 = var0[var23 * 2 + 1];
                     double var29 = var0[var24 * 2] - var25;
                     double var31 = var0[var24 * 2 + 1] - var27;
                     double var33 = var49 - var25;
                     double var35 = var7 - var27;
                     double var37 = var29 * var29 + var31 * var31;
                     double var39 = var37 > 1.0E-12 ? (var33 * var29 + var35 * var31) / var37 : 0.0;
                     var39 = var39 < 0.0 ? 0.0 : (var39 > 1.0 ? 1.0 : var39);
                     var33 -= var29 * var39;
                     var35 -= var31 * var39;
                     double var41 = var33 * var33 + var35 * var35;
                     if (var41 < var52) {
                        var52 = var41;
                     }
                  }
               }
            }

            double var53 = Math.sqrt(var52);
            var2[var44 * (1518478367 ^ 1518478495) + var47] = (float)(var51 ? -var53 : var53);
         }
      }
   }

   private static void r(int var0, double[] var1, float[] var2, float[] var3) {

      double var4 = var1[3];
      double var6 = var1[4];
      double var8 = var1[5];
      double var10 = var1[6];
      double var12 = var1[7];
      double var14 = var1[8];
      double var16 = var1[9];
      double var18 = var1[10];
      byte var20 = 8;
      double[] var21 = new double[var20 + 1];
      double[] var22 = new double[var20 + 1];

      for (int var23 = 0; var23 <= var20; var23++) {
         double var24 = (double)var23 / (double)var20;
         double var26 = (1.0 - var24) * (1.0 - var24);
         double var28 = 2.0 * var24 * (1.0 - var24);
         double var30 = var24 * var24;
         var21[var23] = var26 * var4 + var28 * var8 + var30 * var12;
         var22[var23] = var26 * var6 + var28 * var10 + var30 * var14;
      }

      double[] var49 = var0 == 1
         ? new double[]{var1[0] + 12.0, var1[1] - 50.0, 2.1, var1[0] - 20.0, var1[1] - 70.0, 1.5}
         : (var0 == 3 ? new double[]{var1[0] + 9.0, var1[1] - 58.0, 1.7} : new double[0]);

      for (int var50 = 0; var50 < (1255643036 ^ 1255642908); var50++) {
         double var25 = (double)var50 + 0.5;

         for (int var27 = 0; var27 < (-1843584245 ^ -1843584117); var27++) {
            double var51 = (double)var27 + 0.5;
            double var52 = 1.0E9;

            for (int var32 = 0; var32 < var20; var32++) {
               double var33 = var21[var32 + 1] - var21[var32];
               double var35 = var22[var32 + 1] - var22[var32];
               double var37 = var51 - var21[var32];
               double var39 = var25 - var22[var32];
               double var41 = var33 * var33 + var35 * var35;
               double var43 = var41 > 1.0E-12 ? (var37 * var33 + var39 * var35) / var41 : 0.0;
               var43 = var43 < 0.0 ? 0.0 : (var43 > 1.0 ? 1.0 : var43);
               var37 -= var33 * var43;
               var39 -= var35 * var43;
               double var45 = ((double)var32 + var43) / (double)var20;
               double var47 = Math.sqrt(var37 * var37 + var39 * var39) - (var16 + (var18 - var16) * var45);
               if (var47 < var52) {
                  var52 = var47;
               }
            }

            double var53 = var51 - var12;
            double var34 = var25 - var14;
            double var36 = Math.sqrt(var53 * var53 + var34 * var34) - (var18 + 0.55);
            if (var36 < var52) {
               var52 = var36;
            }

            int var38 = var50 * (439212508 ^ 439212380) + var27;
            var3[var38] = (float)var52;
            double var56 = (double)var2[var38];

            for (byte var57 = 0; var57 + 2 < var49.length; var57 += 3) {
               double var42 = var51 - var49[var57];
               double var44 = var25 - var49[var57 + 1];
               double var46 = var49[var57 + 2] - Math.sqrt(var42 * var42 + var44 * var44);
               if (var46 > var56) {
                  var56 = var46;
               }
            }

            var2[var38] = (float)var56;
         }
      }
   }

   private static void s(double[] var0, int var1, float[] var2, float[] var3, float[] var4, float[] var5) {

      for (int var6 = 0; var6 < (-1110499648 ^ -1110499776); var6++) {
         double var7 = (double)var6 + 0.5;

         for (int var9 = 0; var9 < (2110731402 ^ 2110731274); var9++) {
            int var10 = var6 * (1675225756 ^ 1675225628) + var9;
            if (var2[var10] > 2.0F) {
               var3[var10] = 99.0F;
               var4[var10] = 0.0F;
               var5[var10] = 99.0F;
            } else {
               double var11 = (double)var9 + 0.5;
               double var13 = 1.0E9;
               double var15 = 0.0;
               double var17 = 1.0E9;

               for (int var19 = 0; var19 < var1; var19++) {
                  int var20 = var19 * 7;
                  double var21 = var0[var20];
                  double var23 = var0[var20 + 1];
                  double var25 = var0[var20 + 2] - var21;
                  double var27 = var0[var20 + 3] - var23;
                  double var29 = var11 - var21;
                  double var31 = var7 - var23;
                  double var33 = var25 * var25 + var27 * var27;
                  double var35 = var33 > 1.0E-12 ? (var29 * var25 + var31 * var27) / var33 : 0.0;
                  var35 = var35 < 0.0 ? 0.0 : (var35 > 1.0 ? 1.0 : var35);
                  var29 -= var25 * var35;
                  var31 -= var27 * var35;
                  double var37 = Math.sqrt(var29 * var29 + var31 * var31);
                  double var39 = var37 - (var0[var20 + 4] + (var0[var20 + 5] - var0[var20 + 4]) * var35);
                  if (var39 < var13) {
                     var13 = var39;
                     var15 = var0[var20 + 6];
                  }

                  if (var0[var20 + 6] > 0.99 && var37 < var17) {
                     var17 = var37;
                  }
               }

               var3[var10] = (float)var13;
               var4[var10] = (float)var15;
               var5[var10] = (float)var17;
            }
         }
      }
   }

   private static float[] t() {

      float[] var0 = new float[4096];

      for (int var1 = 0; var1 < var0.length; var1++) {
         int var2 = var1 * (1052975561 ^ -1594599312) + (-880260979 ^ -1585336598);
         var2 ^= var2 >>> 16;
         var2 *= -514730763 ^ 1689919134;
         var2 ^= var2 >>> 13;
         var2 *= -1376600785 ^ 1866470170;
         var2 ^= var2 >>> 16;
         var0[var1] = (float)(var2 & (-10448011 ^ -10457974)) / 65535.0F;
      }

      return var0;
   }

   private static void u(float[] var0, float[] var1, double var2, double var4, double var6, int var8) {

      for (int var9 = 0; var9 < (475510009 ^ 475509881); var9++) {
         for (int var10 = 0; var10 < (566911546 ^ 566911674); var10++) {
            double var11 = ((double)var10 + 0.5) * var2 + var4;
            double var13 = ((double)var9 + 0.5) * var2 + var6;
            double var15 = 0.0;
            double var17 = 0.5;
            double var19 = 0.0;

            for (int var21 = 0; var21 < var8; var21++) {
               int var22 = (int)Math.floor(var11);
               int var23 = (int)Math.floor(var13);
               double var24 = var11 - (double)var22;
               double var26 = var13 - (double)var23;
               var24 = var24 * var24 * (3.0 - 2.0 * var24);
               var26 = var26 * var26 * (3.0 - 2.0 * var26);
               int var28 = (var23 & 63) << 6;
               int var29 = (var23 + 1 & 63) << 6;
               int var30 = var22 & 63;
               int var31 = var22 + 1 & 63;
               double var32 = (double)var0[var28 | var30] + (double)(var0[var28 | var31] - var0[var28 | var30]) * var24;
               double var34 = (double)var0[var29 | var30] + (double)(var0[var29 | var31] - var0[var29 | var30]) * var24;
               var15 += var17 * (var32 + (var34 - var32) * var26);
               var19 += var17;
               var17 *= 0.5;
               var11 = var11 * 2.03 + 17.0;
               var13 = var13 * 2.03 + 5.0;
            }

            var1[var9 * (88324100 ^ 88324228) + var10] = (float)(var15 / var19);
         }
      }
   }

   private static void v(int var0, float[] var1, double var2) {

      int var4 = (int)Math.ceil(128.0 / var2) + 2;
      double[] var5 = new double[var4 * var4];
      double[] var6 = new double[var4 * var4];

      for (int var7 = 0; var7 < var4; var7++) {
         for (int var8 = 0; var8 < var4; var8++) {
            var5[var7 * var4 + var8] = ((double)var8 + 0.5 + 0.42 * ac(var0 + 11, var7 * var4 + var8, 1)) * var2;
            var6[var7 * var4 + var8] = ((double)var7 + 0.5 + 0.42 * ac(var0 + 11, var7 * var4 + var8, 2)) * var2;
         }
      }

      for (int var27 = 0; var27 < (1348157175 ^ 1348157047); var27++) {
         for (int var28 = 0; var28 < (398022473 ^ 398022601); var28++) {
            double var9 = (double)var28 + 0.5;
            double var11 = (double)var27 + 0.5;
            int var13 = (int)(var9 / var2);
            int var14 = (int)(var11 / var2);
            double var15 = 1.0E9;
            double var17 = 1.0E9;

            for (int var19 = var14 - 1; var19 <= var14 + 1; var19++) {
               if (var19 >= 0 && var19 < var4) {
                  for (int var20 = var13 - 1; var20 <= var13 + 1; var20++) {
                     if (var20 >= 0 && var20 < var4) {
                        double var21 = var9 - var5[var19 * var4 + var20];
                        double var23 = var11 - var6[var19 * var4 + var20];
                        double var25 = Math.sqrt(var21 * var21 + var23 * var23);
                        if (var25 < var15) {
                           var17 = var15;
                           var15 = var25;
                        } else if (var25 < var17) {
                           var17 = var25;
                        }
                     }
                  }
               }
            }

            double var29 = (var17 - var15) / 1.1;
            var29 = var29 < 0.0 ? 0.0 : (var29 > 1.0 ? 1.0 : var29);
            var1[var27 * (617690201 ^ 617690329) + var28] = (float)(1.0 - var29 * var29 * (3.0 - 2.0 * var29));
         }
      }
   }

   private static void w(int var0, double[] var1, float[] var2, float[] var3, float[] var4) {

      assert var0 >= 0
         && var0 < 4
         && var1 != null
         && var2 != null
         && var3 != null
         && var4 != null
         && var1.length == 25
         && var2.length == (-759694859 ^ -759711243)
         && var3.length == (535031600 ^ 535015216)
         && var4.length == (1845335164 ^ 1845351548)
         && var2 != var3
         && var2 != var4
         && var3 != var4
         && var1[2] > 0.0
         && var1[2] <= 128.0
         && var1[0] >= 0.0
         && var1[0] <= 128.0
         && var1[1] >= 0.0
         && var1[1] <= 128.0 : "coords: bad args";

      try {
         double var5 = var1[0];
         double var7 = var1[1];
         double var9 = var1[2];

         for (int var11 = 0; var11 < (-88991735 ^ -88991607); var11++) {
            for (int var12 = 0; var12 < (-1278126971 ^ -1278127099); var12++) {
               int var13 = var11 * (-62282257 ^ -62282385) + var12;
               double var14 = (double)var12 + 0.5;
               double var16 = (double)var11 + 0.5;
               double var18 = (double)(-var2[var13]);
               double var20 = var18 / 15.0;
               var20 = var20 < 0.0 ? 0.0 : (var20 > 1.0 ? 1.0 : var20);
               var20 = 1.0 - var20 * var20 * (3.0 - 2.0 * var20);
               double var22;
               if (var0 == 0) {
                  double var24 = var14 - var5;
                  double var26 = var16 - var7;
                  double var28 = Math.sqrt(var24 * var24 + var26 * var26) / var9;
                  var22 = 0.62 * var28 + 0.5 * var20;
               } else {
                  double var33 = (var7 - var16) / var9;
                  var22 = 0.55 * var33 + 0.55 * var20;
               }

               var3[var13] = (float)(var22 < 0.0 ? 0.0 : (var22 > 1.0 ? 1.0 : var22));
               var4[var13] = var18 > -1.5 ? (float)m(var0, var1, var14, var16) : 0.0F;
            }
         }
      } catch (RuntimeException var30) {
         throw var30;
      }
   }

   private static void x(int var0, float[] var1, float[] var2, float[] var3, float[] var4, float[] var5, float[] var6, float[] var7) {

      assert var0 >= 0
         && var0 < 4
         && var1 != null
         && var2 != null
         && var3 != null
         && var4 != null
         && var5 != null
         && var6 != null
         && var7 != null
         && var1.length == (-456247046 ^ -456230662)
         && var2.length == (1463630358 ^ 1463646742)
         && var3.length == (373492206 ^ 373508590)
         && var4.length == (1045979269 ^ 1045962885)
         && var5.length == (1735090873 ^ 1735074489)
         && var6.length == (-223416441 ^ -223432825)
         && var7.length == (-173030030 ^ -173046414)
         && var7 != var1
         && var7 != var2
         && var7 != var4
         && var7 != var5
         && var7 != var6 : "heig" + "ht: ba" + "d a" + "rgs";

      try {
         double var8 = var0 == 0 ? 2.2 : 3.0;
         double var10 = var0 == 0 ? 2.6 : (var0 == 1 ? 1.2 : 1.0);
         double var12 = var0 == 3 ? 0.9 : (var0 == 2 ? 0.45 : 0.35);

         for (int var14 = 0; var14 < (1191443133 ^ 1191426749); var14++) {
            double var15 = (double)(-var1[var14]);
            double var17 = var15 / 20.0;
            var17 = var17 < 0.0 ? 0.0 : (var17 > 1.0 ? 1.0 : var17);
            double var19 = var8 * (1.0 - var17 * var17 * (3.0 - 2.0 * var17));
            var19 -= var10 * Math.exp(-Math.max((double)var4[var14], 0.0) / 6.0);
            double var21 = (double)var2[var14] / 3.5;
            var21 = var21 < 0.0 ? 0.0 : (var21 > 1.0 ? 1.0 : var21);
            var19 += var12 * var21 * var21 * (3.0 - 2.0 * var21);
            var19 += 0.5 * ((double)var6[var14] - 0.5);
            double var23 = (double)var5[var14];
            var19 += 5.0 * Math.sqrt(var23);
            var7[var14] = (float)var19;
         }
      } catch (RuntimeException var25) {
         throw var25;
      }
   }

   private static void y(
      int var0,
      int var1,
      double[] var2,
      float[] var3,
      float[] var4,
      float[] var5,
      float[] var6,
      float[] var7,
      float[] var8,
      float[] var9,
      float[] var10,
      float[] var11,
      float[] var12,
      float[] var13,
      float[] var14
   ) {

      assert var0 >= 0
         && var0 < 4
         && (var1 == 0 || var1 == 1)
         && var2 != null
         && var3 != null
         && var4 != null
         && var5 != null
         && var6 != null
         && var7 != null
         && var8 != null
         && var9 != null
         && var10 != null
         && var11 != null
         && var12 != null
         && var13 != null
         && var14 != null
         && var2.length == 25
         && var3.length == (-1756048178 ^ -1756064562)
         && var4.length == (1085804796 ^ 1085821180)
         && var5.length == (266048277 ^ 266064661)
         && var6.length == (2022585954 ^ 2022602338)
         && var7.length == (-1599375558 ^ -1599391942)
         && var8.length == (-1377251323 ^ -1377267707)
         && var9.length == (-1352268018 ^ -1352251634)
         && var10.length == (1874501721 ^ 1874518105)
         && var11.length == (1453327407 ^ 1453343791)
         && var12.length == (960289209 ^ 960272825)
         && var13.length == (23216960 ^ 23200576)
         && var14.length == (1109192175 ^ 1109257711)
         && bj.length == 4
         && bj[var0].length == 12 : "paint: bad a" + "rgs";

      try {
         int[] var15 = bj[var0];
         boolean var16 = var1 == 1;
         double var17 = -0.42;
         double var19 = -0.58;
         double var21 = 0.7;
         double var23 = Math.sqrt(var17 * var17 + var19 * var19 + var21 * var21);
         var17 /= var23;
         var19 /= var23;
         var21 /= var23;
         double var29 = var21 + 1.0;
         double var31 = Math.sqrt(var17 * var17 + var19 * var19 + var29 * var29);
         double var25 = var17 / var31;
         double var27 = var19 / var31;
         var29 /= var31;
         double var33 = var16 ? 0.34 : 0.26;
         double[] var35 = z(var0, var2);

         for (int var36 = 0; var36 < (327915865 ^ 327915993); var36++) {
            for (int var37 = 0; var37 < (288558227 ^ 288558099); var37++) {
               int var38 = var36 * (-1665948651 ^ -1665948523) + var37;
               double var39 = (double)var3[var38];
               double var41 = (double)var4[var38];
               double var43 = var39 < var41 ? var39 : var41;
               double var45 = 0.5 - var43 / 1.1;
               if (!(var45 <= 0.0)) {
                  if (var45 > 1.0) {
                     var45 = 1.0;
                  }

                  double var47 = -var39;
                  double var49 = (double)var7[var38];
                  int var51 = var16 ? var15[8] : var15[0];
                  int var52 = var16 ? var15[9] : var15[1];
                  int var53 = var16 ? var15[10] : var15[2];
                  double var54;
                  double var56;
                  double var58;
                  if (var49 < 0.5) {
                     double var60 = var49 * 2.0;
                     var60 = var60 * var60 * (3.0 - 2.0 * var60);
                     var54 = (double)(var51 >> 16 & (1555907169 ^ 1555907230))
                        + (double)((var52 >> 16 & (1185651485 ^ 1185651682)) - (var51 >> 16 & (1324809541 ^ 1324809658))) * var60;
                     var56 = (double)(var51 >> 8 & (-57207965 ^ -57207908))
                        + (double)((var52 >> 8 & (2080182765 ^ 2080182546)) - (var51 >> 8 & (-1574394736 ^ -1574394769))) * var60;
                     var58 = (double)(var51 & (-92622025 ^ -92621880))
                        + (double)((var52 & (-1030117696 ^ -1030117825)) - (var51 & (-297535281 ^ -297535440))) * var60;
                  } else {
                     double var150 = var49 * 2.0 - 1.0;
                     var150 = var150 * var150 * (3.0 - 2.0 * var150);
                     var54 = (double)(var52 >> 16 & (1057586212 ^ 1057586395))
                        + (double)((var53 >> 16 & (2774774 ^ 2774537)) - (var52 >> 16 & (-1670442727 ^ -1670442522))) * var150;
                     var56 = (double)(var52 >> 8 & (976989434 ^ 976989189))
                        + (double)((var53 >> 8 & (-2086464043 ^ -2086464214)) - (var52 >> 8 & (2050285168 ^ 2050285199))) * var150;
                     var58 = (double)(var52 & (1572037718 ^ 1572037801))
                        + (double)((var53 & (-1541079600 ^ -1541079761)) - (var52 & (-1524260650 ^ -1524260823))) * var150;
                  }

                  double var152 = ((double)var11[var38] - 0.54) / 0.24;
                  var152 = var152 < 0.0 ? 0.0 : (var152 > 1.0 ? 1.0 : var152);
                  var152 = var152 * var152 * (3.0 - 2.0 * var152) * (var16 ? 0.35 : 0.6);
                  int var62 = var15[5];
                  var54 += ((double)(var62 >> 16 & (-904303115 ^ -904303350)) - var54) * var152;
                  var56 += ((double)(var62 >> 8 & (-2090534675 ^ -2090534894)) - var56) * var152;
                  var58 += ((double)(var62 & (2106609336 ^ 2106609223)) - var58) * var152;
                  double var63 = ((double)var12[var38] - 0.6) / 0.26;
                  var63 = var63 < 0.0 ? 0.0 : (var63 > 1.0 ? 1.0 : var63);
                  var63 = var63 * var63 * (3.0 - 2.0 * var63) * (var16 ? 0.3 : 0.55);
                  int var65 = var15[6];
                  var54 += ((double)(var65 >> 16 & (832359724 ^ 832359891)) - var54) * var63;
                  var56 += ((double)(var65 >> 8 & (459668386 ^ 459668317)) - var56) * var63;
                  var58 += ((double)(var65 & (96750808 ^ 96750631)) - var58) * var63;
                  double var66 = ((double)var5[var38] - 0.4) / 4.6;
                  var66 = var66 < 0.0 ? 0.0 : (var66 > 1.0 ? 1.0 : var66);
                  var66 = var66 * var66 * (3.0 - 2.0 * var66) * (var16 ? 0.05 : 0.08);
                  var54 += (255.0 - var54) * var66 * 0.6;
                  var56 += (235.0 - var56) * var66 * 0.5;
                  var58 += (160.0 - var58) * var66 * 0.2;
                  double var68 = ((double)var5[var38] - 0.5) / 2.0;
                  var68 = var68 < 0.0 ? 0.0 : (var68 > 1.0 ? 1.0 : var68);
                  double var70 = (var47 - 0.5) / 2.5;
                  var70 = var70 < 0.0 ? 0.0 : (var70 > 1.0 ? 1.0 : var70);
                  double var72 = (double)var13[var38] * var68 * var68 * (3.0 - 2.0 * var68) * var70 * var70 * (3.0 - 2.0 * var70);
                  if (var16) {
                     var54 += (255.0 - var54) * var72 * 0.14;
                     var56 += (240.0 - var56) * var72 * 0.14;
                     var58 += (200.0 - var58) * var72 * 0.14;
                  } else {
                     var54 *= 1.0 - var72 * 0.1;
                     var56 *= 1.0 - var72 * 0.13;
                     var58 *= 1.0 - var72 * 0.13;
                  }

                  double var74 = ((double)var5[var38] + 0.35) / 0.9;
                  var74 = var74 < 0.0 ? 0.0 : (var74 > 1.0 ? 1.0 : var74);
                  var74 = (1.0 - var74 * var74 * (3.0 - 2.0 * var74)) * (0.55 + 0.45 * (double)var6[var38]);
                  int var76 = var16 ? var15[11] : var15[4];
                  double var77 = var74 * (var16 ? 0.92 : (var0 == 0 ? 0.5 : 0.62));
                  var54 += ((double)(var76 >> 16 & (2321508 ^ 2321563)) - var54) * var77;
                  var56 += ((double)(var76 >> 8 & (-724646134 ^ -724645899)) - var56) * var77;
                  var58 += ((double)(var76 & (-1395374190 ^ -1395374227)) - var58) * var77;
                  double var79 = 0.9 + 2.6 * (double)var12[var38] + (var0 != 1 && var0 != 3 ? 0.0 : 1.2);
                  double var81 = var47 / var79;
                  var81 = var81 < 0.0 ? 0.0 : (var81 > 1.0 ? 1.0 : var81);
                  var81 = (1.0 - var81 * var81 * (3.0 - 2.0 * var81)) * (var16 ? 0.55 : 0.8);
                  int var83 = var15[3];
                  var54 += ((double)(var83 >> 16 & (-618131879 ^ -618131802)) - var54) * var81;
                  var56 += ((double)(var83 >> 8 & (722976991 ^ 722976800)) - var56) * var81;
                  var58 += ((double)(var83 & (-755247638 ^ -755247851)) - var58) * var81;

                  for (byte var84 = 0; var84 + 3 < var35.length; var84 += 4) {
                     double var85 = (double)var37 + 0.5 - var35[var84];
                     double var87 = (double)var36 + 0.5 - var35[var84 + 1];
                     double var89 = var35[var84 + 2];
                     double var91 = var85 * var85 + var87 * var87;
                     double var93 = var89 * (var35[var84 + 3] > 0.0 ? 2.7 : 1.0) + 1.0;
                     if (!(var91 > var93 * var93)) {
                        double var95 = Math.sqrt(var91);
                        if (var35[var84 + 3] > 0.0) {
                           double var97 = (var95 - var89) / (var89 * 2.7 - var89);
                           var97 = var97 < 0.0 ? 0.0 : (var97 > 1.0 ? 1.0 : var97);
                           var97 = (1.0 - var97 * var97 * (3.0 - 2.0 * var97)) * (var16 ? 0.2 : 0.45) * var35[var84 + 3];
                           var54 += (250.0 - var54) * var97;
                           var56 += (210.0 - var56) * var97;
                           var58 += (70.0 - var58) * var97;
                        }

                        double var183 = (var95 - (var89 - 0.55)) / (var89 + 0.45 - (var89 - 0.55));
                        var183 = var183 < 0.0 ? 0.0 : (var183 > 1.0 ? 1.0 : var183);
                        var183 = (1.0 - var183 * var183 * (3.0 - 2.0 * var183)) * (var16 ? 0.45 : 0.88);
                        double var99 = var35[var84 + 3] > 0.5 ? 34.0 : 92.0;
                        double var101 = var35[var84 + 3] > 0.5 ? 24.0 : 52.0;
                        double var103 = var35[var84 + 3] > 0.5 ? 18.0 : 24.0;
                        var54 += (var99 - var54) * var183;
                        var56 += (var101 - var56) * var183;
                        var58 += (var103 - var58) * var183;
                     }
                  }

                  double var165 = (var39 - var41 + 0.7) / 1.4;
                  var165 = var165 < 0.0 ? 0.0 : (var165 > 1.0 ? 1.0 : var165);
                  var165 = var165 * var165 * (3.0 - 2.0 * var165);
                  if (var165 > 0.0) {
                     double var86 = ((double)var36 + 0.5 - var2[4]) / Math.max(1.0, var2[8] - var2[4]);
                     var86 = var86 < 0.0 ? 0.0 : (var86 > 1.0 ? 1.0 : var86);
                     int var88 = var15[7];
                     double var172 = -var41 / Math.max(0.6, var2[9] + (var2[10] - var2[9]) * var86);
                     var172 = var172 < 0.0 ? 0.0 : (var172 > 1.0 ? 1.0 : var172);
                     double var175 = 0.72 + 0.28 * Math.sqrt(var172);
                     double var176 = (double)(var88 >> 16 & (577439428 ^ 577439291)) * (1.0 - 0.3 * var86) * var175;
                     double var179 = (double)(var88 >> 8 & (846451309 ^ 846451346)) * (1.0 - 0.38 * var86) * var175;
                     double var186 = (double)(var88 & (-162068903 ^ -162068826)) * (1.0 - 0.38 * var86) * var175;
                     if (var16) {
                        var176 += (240.0 - var176) * 0.12;
                        var179 += (220.0 - var179) * 0.12;
                        var186 += (190.0 - var186) * 0.12;
                     }

                     var54 += (var176 - var54) * var165;
                     var56 += (var179 - var56) * var165;
                     var58 += (var186 - var58) * var165;
                  }

                  int var169 = var37 > 0 ? var38 - 1 : var38;
                  int var170 = var37 < 127 ? var38 + 1 : var38;
                  int var171 = var36 > 0 ? var38 - (1211811088 ^ 1211811216) : var38;
                  int var174 = var36 < 127 ? var38 + (1595323572 ^ 1595323444) : var38;
                  double var90 = (double)(var8[var170] - var8[var169]) * 0.5;
                  double var92 = (double)(var8[var174] - var8[var171]) * 0.5;
                  double var94 = ((double)var5[var38] + 0.6) / 1.7000000000000002;
                  var94 = var94 < 0.0 ? 0.0 : (var94 > 1.0 ? 1.0 : var94);
                  var94 = 1.0 - var94 * var94 * (3.0 - 2.0 * var94);
                  double var96 = -var90 * var33;
                  double var98 = -var92 * var33;
                  double var100 = 1.0;
                  double var102 = Math.sqrt(var96 * var96 + var98 * var98 + var100 * var100);
                  var96 /= var102;
                  var98 /= var102;
                  var100 /= var102;
                  double var104 = var96 * var17 + var98 * var19 + var100 * var21;
                  double var106 = 0.64 + 0.36 * var104 / var21;
                  if (var16) {
                     var106 *= 1.0 + 0.1 * var94 * (double)var6[var38];
                  } else {
                     var106 *= 1.0 - 0.1 * var94 * (double)var6[var38];
                  }

                  var54 *= var106;
                  var56 *= var106;
                  var58 *= var106;
                  if (!var16) {
                     double var108 = var96 * var25 + var98 * var27 + var100 * var29;
                     double var110 = Math.pow(Math.max(var108, 0.0), 40.0) * 0.22 + Math.pow(Math.max(var108, 0.0), 6.0) * 0.06;
                     var54 += (255.0 - var54) * var110;
                     var56 += (244.0 - var56) * var110;
                     var58 += (225.0 - var58) * var110;
                  }

                  double var190 = (double)var9[var38];
                  if (var190 > 0.0) {
                     if (!var16) {
                        int var191 = var15[8];
                        int var111 = var15[9];
                        double var112 = (double)(var191 >> 16 & (1237596945 ^ 1237597166))
                           + (double)((var111 >> 16 & (-1177809230 ^ -1177809331)) - (var191 >> 16 & (676106237 ^ 676105986))) * var49;
                        double var114 = (double)(var191 >> 8 & (-2020698568 ^ -2020698425))
                           + (double)((var111 >> 8 & (902538039 ^ 902538184)) - (var191 >> 8 & (-153082936 ^ -153083081))) * var49;
                        double var116 = (double)(var191 & (-209471210 ^ -209470999))
                           + (double)((var111 & (1083163591 ^ 1083163448)) - (var191 & (-1937344377 ^ -1937344392))) * var49;
                        double var118 = (var190 - 0.15) / 0.44999999999999996;
                        var118 = var118 < 0.0 ? 0.0 : (var118 > 1.0 ? 1.0 : var118);
                        var118 = var118 * var118 * (3.0 - 2.0 * var118);
                        var54 += (var112 * 1.06 - var54) * var118;
                        var56 += (var114 * 1.04 - var56) * var118;
                        var58 += (var116 - var58) * var118;
                     } else {
                        double var192 = (var190 - 0.2) / 0.6000000000000001;
                        var192 = var192 < 0.0 ? 0.0 : (var192 > 1.0 ? 1.0 : var192);
                        var192 = var192 * var192 * (3.0 - 2.0 * var192) * 0.12;
                        var54 += (255.0 - var54) * var192;
                        var56 += (240.0 - var56) * var192;
                        var58 += (215.0 - var58) * var192;
                     }
                  }

                  double var195 = (double)var10[var38];
                  if (var195 > 0.0) {
                     double var196 = var195 * 0.3;
                     var54 *= 1.0 - var196 * 0.8;
                     var56 *= 1.0 - var196;
                     var58 *= 1.0 - var196 * 0.9;
                  }

                  var54 = var54 < 0.0 ? 0.0 : (var54 > 255.0 ? 255.0 : var54);
                  var56 = var56 < 0.0 ? 0.0 : (var56 > 255.0 ? 255.0 : var56);
                  var58 = var58 < 0.0 ? 0.0 : (var58 > 255.0 ? 255.0 : var58);
                  int var197 = var38 * 4;
                  var14[var197] = (float)(var54 / 255.0 * var45);
                  var14[var197 + 1] = (float)(var56 / 255.0 * var45);
                  var14[var197 + 2] = (float)(var58 / 255.0 * var45);
                  var14[var197 + 3] = (float)var45;
               }
            }
         }
      } catch (RuntimeException var120) {
         throw var120;
      }
   }

   private static double[] z(int var0, double[] var1) {

      double var2 = var1[0];
      double var4 = var1[1];
      if (var0 == 0) {
         return new double[]{var2 + 14.0, var4 - 26.0, 2.3, 1.0, var2 - 21.0, var4 - 9.0, 1.5, 1.0};
      } else if (var0 == 2) {
         return new double[]{
            var2 - 9.0, var4 - 30.0, 1.5, 0.6, var2 + 14.0, var4 - 18.0, 1.2, 0.6, var2 + 4.0, var4 - 55.0, 1.0, 0.6, var2 - 15.0, var4 - 14.0, 0.9, 0.6
         };
      } else if (var0 != 3) {
         return new double[0];
      } else {
         byte var6 = 22;
         double[] var7 = new double[(var6 + 1) * 4];
         double var8 = var1[2];

         for (int var10 = 0; var10 < var6; var10++) {
            double var11 = 0.12 + 0.72 * (0.5 + 0.5 * ac(3, var10, 31));
            double var13 = 0.2 * ac(3, var10, 32) * Math.sin(Math.PI * var11);
            var7[var10 * 4] = var2 + var13 * var8;
            var7[var10 * 4 + 1] = var4 - var11 * var8;
            var7[var10 * 4 + 2] = 0.6 + 0.45 * (0.5 + 0.5 * ac(3, var10, 33));
            var7[var10 * 4 + 3] = 0.0;
         }

         var7[var6 * 4] = var2 + 7.0;
         var7[var6 * 4 + 1] = var4 - 0.62 * var8;
         var7[var6 * 4 + 2] = 2.0;
         var7[var6 * 4 + 3] = 0.6;
         return var7;
      }
   }

   private static void aa(float[] var0, float[] var1, float[] var2) {

      byte var3 = 3;
      float var4 = 1.0F / (float)(2 * var3 + 1);

      for (int var5 = 0; var5 < (-864738050 ^ -864738178); var5++) {
         float var6 = 0.0F;

         for (int var7 = -var3; var7 <= var3; var7++) {
            var6 += var7 >= 0 && var7 < (-1342012148 ^ -1342012020) ? var0[var5 * (1891712564 ^ 1891712692) + var7] : 0.0F;
         }

         for (int var16 = 0; var16 < (-761340247 ^ -761340375); var16++) {
            var2[var5 * (2117563624 ^ 2117563496) + var16] = var6 * var4;
            int var8 = var16 - var3;
            int var9 = var16 + var3 + 1;
            var6 -= var8 >= 0 ? var0[var5 * (-1386420583 ^ -1386420711) + var8] : 0.0F;
            var6 += var9 < (-1741583580 ^ -1741583452) ? var0[var5 * (-1437904104 ^ -1437903976) + var9] : 0.0F;
         }
      }

      for (int var12 = 0; var12 < (1310865241 ^ 1310865369); var12++) {
         float var14 = 0.0F;

         for (int var17 = -var3; var17 <= var3; var17++) {
            var14 += var17 >= 0 && var17 < (165265805 ^ 165265677) ? var2[var17 * (-1919993659 ^ -1919993787) + var12] : 0.0F;
         }

         for (int var18 = 0; var18 < (-51617893 ^ -51618021); var18++) {
            float var19 = var14 * var4;
            float var20 = var0[var18 * (-708601464 ^ -708601592) + var12];
            var1[var18 * (-1637807272 ^ -1637807144) + var12] = var20 > 0.05F ? 0.0F : Math.min(1.0F, var19 * 2.2F);
            int var10 = var18 - var3;
            int var11 = var18 + var3 + 1;
            var14 -= var10 >= 0 ? var2[var10 * (1497580280 ^ 1497580152) + var12] : 0.0F;
            var14 += var11 < (-630618267 ^ -630618139) ? var2[var11 * (1802895862 ^ 1802895734) + var12] : 0.0F;
         }
      }
   }

   private static void ab(int var0, float[] var1, float[] var2, int[] var3, int[] var4) {

      for (int var5 = 0; var5 < 4; var5++) {
         int var6 = (-2032488385 ^ -2032488257) >> var5;
         int var7 = var6 * var6;
         int var8 = 7 - var5;
         int var9 = var6 - 1;
         int var10;
         int var11;
         if (var5 == 0) {
            var10 = (var0 & 3) * (1101882454 ^ 1101882582);
            var11 = (var0 >> 2) * (1116610312 ^ 1116610440);
         } else if (var5 == 1) {
            var10 = (var0 & 3) * 64;
            var11 = (2040430106 ^ 2040430362) + (var0 >> 2) * 64;
         } else if (var5 == 2) {
            var10 = (-1164157180 ^ -1164157436) + (var0 & 3) * 32;
            var11 = (-2026921977 ^ -2026921721) + (var0 >> 2) * 32;
         } else {
            var10 = (-240476614 ^ -240476230) + (var0 & 3) * 16;
            var11 = (38783456 ^ 38783200) + (var0 >> 2) * 16;
         }

         if (var5 > 0) {
            int var12 = var6 * 8;

            for (int var13 = 0; var13 < var6; var13++) {
               for (int var14 = 0; var14 < var6; var14++) {
                  int var15 = (var13 * 2 * var6 * 2 + var14 * 2) * 4;
                  int var16 = var15 + var12;
                  int var17 = (var13 * var6 + var14) * 4;
                  var1[var17] = (var1[var15] + var1[var15 + 4] + var1[var16] + var1[var16 + 4]) * 0.25F;
                  var1[var17 + 1] = (var1[var15 + 1] + var1[var15 + 5] + var1[var16 + 1] + var1[var16 + 5]) * 0.25F;
                  var1[var17 + 2] = (var1[var15 + 2] + var1[var15 + 6] + var1[var16 + 2] + var1[var16 + 6]) * 0.25F;
                  var1[var17 + 3] = (var1[var15 + 3] + var1[var15 + 7] + var1[var16 + 3] + var1[var16 + 7]) * 0.25F;
               }
            }
         }

         for (int var29 = 0; var29 < var7; var29++) {
            int var34 = var29 * 4;
            float var39 = var1[var34 + 3];
            if (var39 >= 0.0019607844F) {
               float var44 = 1.0F / var39;
               var2[var34] = var1[var34] * var44;
               var2[var34 + 1] = var1[var34 + 1] * var44;
               var2[var34 + 2] = var1[var34 + 2] * var44;
               var2[var34 + 3] = var39;
               var3[var29] = var29;
            } else {
               var2[var34] = 0.0F;
               var2[var34 + 1] = 0.0F;
               var2[var34 + 2] = 0.0F;
               var2[var34 + 3] = 0.0F;
               var3[var29] = -1;
            }
         }

         for (int var30 = 0; var30 < var6; var30++) {
            for (int var35 = 0; var35 < var6; var35++) {
               int var40 = var30 * var6 + var35;
               if (var3[var40] >= 0) {
                  int var45 = var40 * 4;
                  float var49 = var1[var45];
                  float var52 = var1[var45 + 1];
                  float var18 = var1[var45 + 2];
                  float var19 = var1[var45 + 3];

                  for (int var20 = var30 - 1; var20 <= var30 + 1; var20++) {
                     if (var20 >= 0 && var20 < var6) {
                        for (int var21 = var35 - 1; var21 <= var35 + 1; var21++) {
                           if (var21 >= 0 && var21 < var6) {
                              int var22 = var20 * var6 + var21;
                              if (var3[var22] < 0) {
                                 int var23 = var22 * 4;
                                 var2[var23] += var49;
                                 var2[var23 + 1] = var2[var23 + 1] + var52;
                                 var2[var23 + 2] = var2[var23 + 2] + var18;
                                 var2[var23 + 3] = var2[var23 + 3] + var19;
                              }
                           }
                        }
                     }
                  }
               }
            }
         }

         for (int var31 = 0; var31 < var7; var31++) {
            int var36 = var31 * 4;
            float var41 = var2[var36 + 3];
            if (var3[var31] < 0 && var41 > 0.0F) {
               float var46 = 1.0F / var41;
               var2[var36] *= var46;
               var2[var36 + 1] = var2[var36 + 1] * var46;
               var2[var36 + 2] = var2[var36 + 2] * var46;
               var2[var36 + 3] = 0.0F;
               var3[var31] = var31;
            }
         }

         for (int var32 = 0; var32 < 2; var32++) {
            int var37 = var32 == 0 ? 1 : -1;
            int var42 = var32 == 0 ? 0 : var6 - 1;

            for (int var47 = 0; var47 < var6; var47++) {
               int var50 = var42 + var37 * var47;

               for (int var53 = 0; var53 < var6; var53++) {
                  int var55 = var42 + var37 * var53;
                  int var57 = var50 * var6 + var55;
                  int var59 = var3[var57];
                  int var61 = 1044208826 ^ 1103274821;
                  if (var59 >= 0) {
                     int var63 = (var59 & var9) - var55;
                     int var65 = (var59 >> var8) - var50;
                     var61 = var63 * var63 + var65 * var65;
                     if (var61 == 0) {
                        continue;
                     }
                  }

                  for (int var64 = 0; var64 < 4; var64++) {
                     int var66 = var64 == 2 ? var55 : (var64 == 3 ? var55 + var37 : var55 - var37);
                     int var24 = var64 == 0 ? var50 : var50 - var37;
                     if (var66 >= 0 && var24 >= 0 && var66 < var6 && var24 < var6) {
                        int var25 = var3[var24 * var6 + var66];
                        if (var25 >= 0) {
                           int var26 = (var25 & var9) - var55;
                           int var27 = (var25 >> var8) - var50;
                           int var28 = var26 * var26 + var27 * var27;
                           if (var28 < var61) {
                              var61 = var28;
                              var59 = var25;
                           }
                        }
                     }
                  }

                  var3[var57] = var59;
               }
            }
         }

         for (int var33 = 0; var33 < var6; var33++) {
            for (int var38 = 0; var38 < var6; var38++) {
               int var43 = var33 * var6 + var38;
               int var48 = var3[var43];
               int var51 = (int)(var2[var43 * 4 + 3] * 255.0F + 0.5F);
               int var54 = 0;
               if (var48 >= 0) {
                  int var56 = var48 * 4;
                  int var58 = (int)(var2[var56] * 255.0F + 0.5F);
                  int var60 = (int)(var2[var56 + 1] * 255.0F + 0.5F);
                  int var62 = (int)(var2[var56 + 2] * 255.0F + 0.5F);
                  var54 = (var58 > (-71853140 ^ -71853229) ? 315072676 ^ 315072603 : var58) << 16
                     | (var60 > (-1951099221 ^ -1951099308) ? 1530135006 ^ 1530134817 : var60) << 8
                     | (var62 > (-1790338170 ^ -1790338183) ? 587442505 ^ 587442614 : var62);
               }

               var4[(var11 + var33) * (144391322 ^ 144391834) + var10 + var38] = (var51 > (299028446 ^ 299028257) ? 1861895744 ^ 1861895871 : var51) << 24
                  | var54;
            }
         }
      }
   }

   private static double ac(int var0, int var1, int var2) {

      int var3 = var0 * (-1135506390 ^ -1685756153) ^ var1 * (-1041124080 ^ -676867423) ^ var2 * (1233493395 ^ 676142036);
      var3 ^= var3 >>> 15;
      var3 *= -518366425 ^ -855546038;
      var3 ^= var3 >>> 12;
      var3 *= 210096133 ^ 637533500;
      var3 ^= var3 >>> 15;
      return (double)(var3 & (-89204377 ^ -95345000)) / 8388607.0 - 1.0;
   }

   private static double ad(double var0, double var2, double var4) {

      double var6 = (var4 - var0) / (var2 - var0);
      var6 = var6 < 0.0 ? 0.0 : (var6 > 1.0 ? 1.0 : var6);
      return var6 * var6 * (3.0 - 2.0 * var6);
   }
}
