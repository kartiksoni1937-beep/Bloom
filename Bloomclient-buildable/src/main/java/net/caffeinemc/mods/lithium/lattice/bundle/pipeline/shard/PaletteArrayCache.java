package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import java.util.Arrays;

public final class PaletteArrayCache {
   public static final int W = 512;
   public static final int H = 512;
   private static final int aa = 128;
   private static final int ab = 16384;
   private static final double ac = 1.45;
   private static final int ad = 0;
   private static final int ae = 1;
   private static final int af = 2;
   private static final int ag = 3;
   private static final int ah = 4;
   private static final int ai = 5;
   private static final int aj = 6;
   private static final int ak = 7;
   private static final int al = 8;
   private static final int am = 9;
   private static final int an = 10;
   private static final int ao = 11;
   private static final int ap = 12;
   private static final int aq = 13;
   private static final int ar = 14;
   private static final int as = 15;
   private static final int at = 16;
   private static final int au = 17;
   private static final int av = 18;
   private static final int aw = 19;
   private static final int ax = 20;
   private static final int ay = 21;
   private static final int az = 22;
   private static final int ba = 23;
   private static final int bb = 24;
   private static final int bc = 25;
   private static final int bd = 26;
   private static final int be = 27;
   private static int[] bf;
   private static int bh = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   private PaletteArrayCache() {
   }

   public static synchronized int[] a() {
      byte var0 = 0;

      while (true) {
         switch (var0) {
            case 0:
            default:
               if (bh != 0) {
                  System.nanoTime();
                  var0 = 1;
                  break;
               }
            case 1:
               if (bf == null) {
                  bf = b();
                  var0 = 2;
                  break;
               }

               return bf;
            case 2:
               return bf;
         }
      }
   }

   private static int[] b() {

      int[] var0 = new int[262144];
      float[] var1 = new float[65536];
      float[] var2 = new float[16384];
      float[] var3 = new float[16384];
      float[] var4 = new float[16384];
      byte[] var5 = new byte[16384];
      double[] var6 = new double[27];
      float[] var7 = new float[65536];
      int[] var8 = new int[16384];
      int[] var9 = new int[16384];
      float[] var10 = new float[3];

      for (int var11 = 0; var11 < 8; var11++) {
         Arrays.fill(var1, 0.0F);
         Arrays.fill(var9, 0);
         if (var11 < 4) {
            c(var11, var1, var2, var3, var4, var5, var9, var6, var10);
         } else if (var11 < 7) {
            d(var11, var1, var2, var3, var4, var5, var9, var6, var10);
         } else {
            e(var1, var2, var3, var4, var5, var9, var6, var10);
         }

         p(var1, var9);
         w(var11, var1, var7, var8, var0);
      }

      return var0;
   }

   private static void c(int var0, float[] var1, float[] var2, float[] var3, float[] var4, byte[] var5, int[] var6, double[] var7, float[] var8) {

      double var11 = 64.0;
      if (var0 == 0) {
         double var9 = 92.0;
         double var13 = 113.0;
         g(var7, var11, var13, 0.0, var9);
         i(var7, 0.32, 0.62, 1.8, 0.21, 0.34, 0.035, -0.12, 0.0, -0.05);
         j(var7, 1969955362 ^ 1975480925, 1655871260 ^ 1650257795, 1330304372 ^ 1337098175, 0.24, -0.3, 0.66, 0.12, -0.1, 0.88, 0.0, 0.0);
      } else if (var0 == 1) {
         double var15 = 93.0;
         double var18 = 114.0;
         g(var7, var11 - 3.0, var18, -4.0, var15);
         i(var7, 0.265, 0.64, 1.7, 0.22, 0.36, -0.06, 0.16, 0.07, 0.1);
         j(var7, 1671530214 ^ 1668401818, 239120169 ^ 246209460, 1535876453 ^ 1534868396, 0.22, 0.25, 0.64, -0.22, -0.1, 0.88, 0.0, 0.0);
      } else if (var0 == 2) {
         double var16 = 94.0;
         double var19 = 113.0;
         g(var7, var11, var19, 2.0, var16);
         i(var7, 0.31, 0.6, 1.8, 0.2, 0.32, 0.04, -0.08, -0.03, -0.1);
         j(var7, -21431418 ^ -25903632, -813157934 ^ -815773875, 883553969 ^ 877680766, 0.2, 0.4, 0.62, 0.95, -0.05, 0.92, 0.38, 0.0);
      } else {
         double var17 = 88.0;
         double var20 = 110.0;
         g(var7, var11, var20, 0.0, var17);
         i(var7, 0.355, 0.62, 1.35, 0.21, 0.36, -0.045, 0.1, 0.0, 0.04);
         var7[26] = 0.35;
         j(var7, 1277675090 ^ 1289877538, -2022154982 ^ -2019676282, 268731260 ^ 284304820, 0.22, -0.2, 0.68, 0.1, 0.06, 0.98, 0.0, 0.0);
      }

      n(var7, var1, var2, var3, var4, var5, var6, var8, 0.0);
   }

   private static void d(int var0, float[] var1, float[] var2, float[] var3, float[] var4, byte[] var5, int[] var6, double[] var7, float[] var8) {

      double var9 = 64.0;
      double var11 = 64.0;
      double var13 = 52.0;
      double var15 = 2.5;
      int var17;
      int var18;
      int var19;
      double var20;
      double var22;
      if (var0 == 4) {
         var17 = 1954486566 ^ 1957382489;
         var18 = 1099012964 ^ 1097590722;
         var19 = -708724743 ^ -717677003;
         var20 = -6.0;
         var22 = 0.35;
      } else if (var0 == 5) {
         var17 = -1315287689 ^ -1322878177;
         var18 = -424816378 ^ -428437878;
         var19 = 1317594773 ^ 1316514592;
         var20 = 20.0;
         var22 = 0.45;
      } else {
         var17 = -2020350630 ^ -2025343024;
         var18 = -673993296 ^ -683791585;
         var19 = 1015161057 ^ 1014534962;
         var20 = 4.0;
         var22 = 1.0;
      }

      q(var1, var9, var11, 19.0, var17, 1.0);
      int[] var24 = new int[]{1, 3, 4, 0, 2};

      for (int var25 = 0; var25 < 5; var25++) {
         int var26 = var24[var25];
         double var27 = z(var0, var26, 1) * 7.0 * var22;
         double var29 = z(var0, var26, 2) * 0.07 * var22;
         double var31 = z(var0, var26, 3) * 0.06 * var22;
         double var33 = var20 + 72.0 * (double)var26 + var27;
         double var35 = Math.toRadians(var33);
         double var37 = var13 * (1.0 + var29) - var15;
         g(var7, var9 + Math.sin(var35) * var15, var11 - Math.cos(var35) * var15, var33, var37);
         i(
            var7,
            0.46 + var31,
            0.6,
            1.2,
            0.15 + 0.03 * z(var0, var26, 4) * var22,
            0.3,
            0.02 * z(var0, var26, 5) * var22,
            0.1 * z(var0, var26, 6) * var22,
            0.05 * z(var0, var26, 7) * var22,
            0.06 * z(var0, var26, 8) * var22
         );
         j(var7, var17, var18, var19, 0.28, -0.2 + 0.3 * z(var0, var26, 9), 0.66, 0.15 * z(var0, var26, 10), 0.0, 0.85, 0.0, 0.0);
         n(var7, var1, var2, var3, var4, var5, var6, var8, 0.45);
      }

      double var39 = var0 == 5 ? 0.5 : 0.45;
      s(var1, var9, var11, 1.0, 0.0, 0.0, 1.0, 2.0, 9.0, Math.toRadians(var20), 0.25, -1991651856 ^ -1987445334, var39);
      t(var1, var0, var9, var11, 1.0, 0.0, var20, var13);
   }

   private static void e(float[] var0, float[] var1, float[] var2, float[] var3, byte[] var4, int[] var5, double[] var6, float[] var7) {

      double var8 = 64.0;
      double var10 = 76.0;
      double var12 = 50.0;
      double var14 = 2.5;
      double var16 = Math.toRadians(42.0);
      double var18 = Math.toRadians(32.0);
      double var20 = Math.cos(var16);
      double var22 = Math.sin(var16);
      double var24 = Math.cos(var18);
      double var26 = Math.sin(var18);
      double var28 = 8.0;
      double[] var30 = new double[5];
      int[] var31 = new int[5];

      for (int var32 = 0; var32 < 5; var31[var32] = var32++) {
         double var33 = Math.toRadians(var28 + 72.0 * (double)var32);
         double var35 = Math.cos(var33) * (var14 + 0.5 * var12 * var24);
         double var37 = 0.5 * var12 * var26;
         var30[var32] = -var35 * var22 + var37 * var20;
      }

      for (int var61 = 1; var61 < 5; var61++) {
         int var63 = var31[var61];

         int var34;
         for (var34 = var61 - 1; var34 >= 0 && var30[var31[var34]] > var30[var63]; var34--) {
            var31[var34 + 1] = var31[var34];
         }

         var31[var34 + 1] = var63;
      }

      boolean var62 = false;

      for (int var64 = 0; var64 < 5; var64++) {
         int var65 = var31[var64];
         if (!var62 && var30[var65] > 12.0) {
            var62 = true;
            f(var0, 7, var8, var10, var20, var22, var28, var12);
         }

         double var66 = Math.toRadians(var28 + 72.0 * (double)var65 + 5.0 * z(7, var65, 1));
         double var67 = Math.sin(var66);
         double var39 = Math.cos(var66);
         double var41 = var67 * var24;
         double var43 = var39 * var24;
         double var47 = var12 * (1.0 + 0.05 * z(7, var65, 2)) - var14;
         double var49 = var41 * var47;
         double var51 = -(var43 * var20 + var26 * var22) * var47;
         double var53 = var39 * var47;
         double var55 = var67 * var20 * var47;
         h(var6, var8 + var67 * var14, var10 - var39 * var14 * var20, var53, var55, var49, var51);
         i(var6, 0.46, 0.6, 1.2, 0.15, 0.3, 0.0, 0.05 * z(7, var65, 3), 0.03 * z(7, var65, 4), 0.04 * z(7, var65, 5));
         double var57 = var39 * var26 * var22 + var24 * var20;
         double var59 = var57 < 0.0 ? 0.35 : 0.0;
         j(var6, 19594988 ^ 33468051, -1446632991 ^ -1456626871, 363718512 ^ 357849023, 0.26, -0.2, 0.66, 0.1 * z(7, var65, 6), 0.0, 0.85, 0.0, var59);
         n(var6, var0, var1, var2, var3, var4, var5, var7, 0.45);
      }

      if (!var62) {
         f(var0, 7, var8, var10, var20, var22, var28, var12);
      }
   }

   private static void f(float[] var0, int var1, double var2, double var4, double var6, double var8, double var10, double var12) {

      r(var0, var2, var4, var6, 16.0, 1092006259 ^ 1103290636);
      s(var0, var2, var4, 1.0, 0.0, 0.0, 1.0 / var6, 2.0, 9.0, Math.toRadians(var10), 0.25, -1151780121 ^ -1147598147, 0.45);
      t(var0, var1, var2, var4, var6, var8, var10, var12);
   }

   private static void g(double[] var0, double var1, double var3, double var5, double var7) {

      double var9 = Math.toRadians(var5);
      double var11 = Math.cos(var9);
      double var13 = Math.sin(var9);
      var0[0] = var1;
      var0[1] = var3;
      var0[2] = var11 / var7;
      var0[3] = var13 / var7;
      var0[4] = var13 / var7;
      var0[5] = -var11 / var7;
   }

   private static void h(double[] var0, double var1, double var3, double var5, double var7, double var9, double var11) {

      double var13 = var5 * var11 - var9 * var7;
      if (Math.abs(var13) < 1.0E-6) {
         var13 = var13 < 0.0 ? -1.0E-6 : 1.0E-6;
      }

      var0[0] = var1;
      var0[1] = var3;
      var0[2] = var11 / var13;
      var0[3] = -var9 / var13;
      var0[4] = -var7 / var13;
      var0[5] = var5 / var13;
   }

   private static void i(double[] var0, double var1, double var3, double var5, double var7, double var9, double var11, double var13, double var15, double var17) {

      var0[6] = var1;
      var0[7] = var3;
      var0[8] = var5;
      var0[9] = var7;
      var0[10] = var9;
      var0[11] = var11;
      var0[12] = var13;
      var0[13] = var15;
      var0[14] = var17;
      var0[26] = 0.0;
   }

   private static void j(
      double[] var0, int var1, int var2, int var3, double var4, double var6, double var8, double var10, double var12, double var14, double var16, double var18
   ) {

      var0[15] = (double)var1;
      var0[16] = (double)var2;
      var0[17] = (double)var3;
      var0[18] = var4;
      var0[19] = var6;
      var0[20] = var8;
      var0[21] = var10;
      var0[22] = var12;
      var0[23] = var14;
      var0[24] = var16;
      var0[25] = var18;
   }

   private static double k(double[] var0, double var1, double var3) {

      double var5 = var0[6] * (var1 >= 0.0 ? 1.0 + var0[14] : 1.0 - var0[14]);
      double var7 = var0[7];
      double var9 = var3 - var0[12] * var1 * var3;
      if (var9 <= var7) {
         double var19 = var9 / var7;
         if (var19 <= 0.0) {
            return 0.0;
         } else {
            double var13 = var0[8];
            double var15 = var5 * var19 * (var13 + var19 * (3.0 - 2.0 * var13 + var19 * (var13 - 2.0)));
            double var17 = 1.0 - var9 / 0.18;
            if (var17 > 0.0) {
               var15 = Math.sqrt(var15 * var15 + 0.07 * var9 * var17 * var17);
            }

            return var15;
         }
      } else {
         double var11 = (var9 - var7) / (1.0 - var7);
         return var11 >= 1.0 ? 0.0 : var5 * Math.sqrt(1.0 - var11 * var11 * Math.sqrt(var11));
      }
   }

   private static boolean l(double[] var0, double var1, double var3) {

      assert var0 != null
         && var0.length == 27
         && var1 >= -1.0
         && var1 <= 129.0
         && var3 >= -1.0
         && var3 <= 129.0
         && var0[6] > 0.0
         && var0[7] > 0.0
         && var0[7] < 1.0
         && var0[10] > 0.0
         && var0[26] >= 0.0
         && var0[26] < 1.0 : "inside: bad sample";

      try {
         double var5 = var1 - var0[0];
         double var7 = var3 - var0[1];
         double var9 = var0[4] * var5 + var0[5] * var7;
         if (!(var9 <= 0.0) && !(var9 >= 1.0)) {
            double var11 = var0[2] * var5 + var0[3] * var7 - var0[13] * var9 * var9;
            double var13 = var0[6] * (var11 >= 0.0 ? 1.0 + var0[14] : 1.0 - var0[14]);
            double var15 = var0[7];
            double var17 = var9 - var0[12] * var11 * var9;
            if (var17 <= var15) {
               double var19 = var17 / var15;
               if (var19 <= 0.0) {
                  var13 = 0.0;
               } else {
                  double var21 = var0[8];
                  double var23 = var13 * var19 * (var21 + var19 * (3.0 - 2.0 * var21 + var19 * (var21 - 2.0)));
                  double var25 = 1.0 - var17 / 0.18;
                  if (var25 > 0.0) {
                     var23 = Math.sqrt(var23 * var23 + 0.07 * var17 * var25 * var25);
                  }

                  var13 = var23;
               }
            } else {
               double var29 = (var17 - var15) / (1.0 - var15);
               var13 = var29 >= 1.0 ? 0.0 : var13 * Math.sqrt(1.0 - var29 * var29 * Math.sqrt(var29));
            }

            double var30 = var11 < 0.0 ? -var11 : var11;
            if (var30 >= var13) {
               return false;
            } else {
               double var31 = var0[9];
               if (var31 > 0.0) {
                  double var32 = var11 - var0[11];
                  var32 = var32 < 0.0 ? -var32 * (1.0 - var0[26]) : var32 * (1.0 + var0[26]);
                  if (var9 > 1.0 - var31 + var32 * var31 / (var0[10] * var0[6])) {
                     return false;
                  }
               }

               return true;
            }
         } else {
            return false;
         }
      } catch (RuntimeException var27) {
         throw var27;
      }
   }

   private static void m(double[] var0, double var1, double var3, float[] var5) {

      assert var0 != null
         && var5 != null
         && var0.length == 27
         && var5.length == 3
         && var1 >= 0.0
         && var1 <= 128.0
         && var3 >= 0.0
         && var3 <= 128.0
         && var0[6] > 0.0
         && var0[15] >= 0.0
         && var0[16] >= 0.0
         && var0[17] >= 0.0
         && var0[23] > var0[22] : "petalColor: bad sample";

      try {
         double var6 = var1 - var0[0];
         double var8 = var3 - var0[1];
         double var10 = var0[4] * var6 + var0[5] * var8;
         double var12 = var0[2] * var6 + var0[3] * var8 - var0[13] * var10 * var10;
         double var14 = var0[6] * (var12 >= 0.0 ? 1.0 + var0[14] : 1.0 - var0[14]);
         double var16 = var12 / var14;
         var16 = var16 < -1.0 ? -1.0 : (var16 > 1.0 ? 1.0 : var16);
         double var18 = var10 < 0.0 ? 0.0 : (var10 > 1.0 ? 1.0 : var10);
         double var20 = (var18 - var0[22]) / (var0[23] - var0[22]);
         var20 = var20 < 0.0 ? 0.0 : (var20 > 1.0 ? 1.0 : var20);
         double var22 = var20 * var20 * (3.0 - 2.0 * var20) + var0[21] * var16 * 0.5;
         var22 = var22 < 0.0 ? 0.0 : (var22 > 1.0 ? 1.0 : var22);
         int var24;
         int var25;
         double var26;
         if (var22 < 0.5) {
            var24 = (int)var0[15];
            var25 = (int)var0[16];
            var26 = var22 * 2.0;
         } else {
            var24 = (int)var0[16];
            var25 = (int)var0[17];
            var26 = var22 * 2.0 - 1.0;
         }

         double var28 = (double)(var24 >> 16 & (-719704229 ^ -719704156))
            + (double)((var25 >> 16 & (-1494902230 ^ -1494902059)) - (var24 >> 16 & (-744554083 ^ -744554142))) * var26;
         double var30 = (double)(var24 >> 8 & (-920958938 ^ -920958759))
            + (double)((var25 >> 8 & (356132531 ^ 356132428)) - (var24 >> 8 & (-483579738 ^ -483579815))) * var26;
         double var32 = (double)(var24 & (-524098431 ^ -524098434))
            + (double)((var25 & (-131856356 ^ -131856157)) - (var24 & (-855425100 ^ -855425205))) * var26;
         double var34 = var16 - var0[19];
         double var36 = var18 - var0[20];
         double var38 = var0[18] * Math.exp(-(var34 * var34 * 2.5 + var36 * var36 * 12.0));
         var28 += (255.0 - var28) * var38;
         var30 += (217.0 - var30) * var38;
         var32 += (234.0 - var32) * var38;
         double var40 = var0[24];
         if (var40 != 0.0) {
            double var42 = k(var0, var12, var18);
            double var44 = var12 / Math.max(var42, 0.02) * (var40 > 0.0 ? 1.0 : -1.0);
            double var46 = (var44 - 0.45) / 0.53;
            var46 = var46 < 0.0 ? 0.0 : (var46 > 1.0 ? 1.0 : var46);
            double var48 = (var18 - 0.15) / 0.25;
            var48 = var48 < 0.0 ? 0.0 : (var48 > 1.0 ? 1.0 : var48);
            double var50 = var46 * var46 * (3.0 - 2.0 * var46) * var48 * var48 * (3.0 - 2.0 * var48) * Math.abs(var40);
            var28 += (255.0 - var28) * var50;
            var30 += (205.0 - var30) * var50;
            var32 += (226.0 - var32) * var50;
         }

         double var59 = var0[25];
         if (var59 > 0.0) {
            var28 += (252.0 - var28) * var59;
            var30 += (222.0 - var30) * var59;
            var32 += (234.0 - var32) * var59;
         }

         var5[0] = (float)(var28 / 255.0);
         var5[1] = (float)(var30 / 255.0);
         var5[2] = (float)(var32 / 255.0);
      } catch (RuntimeException var52) {
         throw var52;
      }
   }

   private static void n(double[] var0, float[] var1, float[] var2, float[] var3, float[] var4, byte[] var5, int[] var6, float[] var7, double var8) {

      assert var0 != null
         && var1 != null
         && var2 != null
         && var3 != null
         && var4 != null
         && var5 != null
         && var6 != null
         && var7 != null
         && var0.length == 27
         && var1.length == (-182776615 ^ -182842151)
         && var2.length == (689225805 ^ 689209421)
         && var3.length == (1534483363 ^ 1534466979)
         && var4.length == (1876575702 ^ 1876559318)
         && var5.length == (1753210337 ^ 1753193953)
         && var6.length == (-2089010727 ^ -2088994343)
         && var7.length == 3
         && var2 != var3
         && var3 != var4
         && var2 != var4
         && var8 >= 0.0
         && var8 <= 1.0 : "drawPetal" + ": bad ar" + "gs";

      try {
         double var10 = var0[2] * var0[5] - var0[3] * var0[4];
         double var12 = var0[5] / var10;
         double var14 = -var0[4] / var10;
         double var16 = -var0[3] / var10;
         double var18 = var0[2] / var10;
         double var20 = var0[6] * (1.0 + Math.abs(var0[14])) + Math.abs(var0[13]) + 0.05;
         double var22 = 1.0E9;
         double var24 = 1.0E9;
         double var26 = -1.0E9;
         double var28 = -1.0E9;

         for (int var30 = 0; var30 < 4; var30++) {
            double var31 = (var30 & 1) == 0 ? -var20 : var20;
            double var33 = (var30 & 2) == 0 ? -0.02 : 1.02;
            double var35 = var0[0] + var31 * var12 + var33 * var16;
            double var37 = var0[1] + var31 * var14 + var33 * var18;
            var22 = Math.min(var22, var35);
            var24 = Math.min(var24, var37);
            var26 = Math.max(var26, var35);
            var28 = Math.max(var28, var37);
         }

         int var46 = Math.max(0, (int)Math.floor(var22) - 2);
         int var47 = Math.max(0, (int)Math.floor(var24) - 2);
         int var32 = Math.min(753873265 ^ 753873393, (int)Math.ceil(var26) + 3);
         int var48 = Math.min(645300819 ^ 645300947, (int)Math.ceil(var28) + 3);
         Arrays.fill(var2, 0.0F);
         o(var0, var2, var5, var6, var46, var47, var32, var48);
         if (var8 > 0.0) {
            int var34 = Math.max(0, var46 - 7);
            int var50 = Math.max(0, var47 - 7);
            int var36 = Math.min(758285886 ^ 758286014, var32 + 7);
            int var53 = Math.min(1754125686 ^ 1754125814, var48 + 7);
            y(var2, var3, var4, 3, var34, var50, var36, var53);
            y(var3, var3, var4, 3, var34, var50, var36, var53);

            for (int var38 = var50; var38 < var53; var38++) {
               for (int var39 = var34; var39 < var36; var39++) {
                  int var40 = var38 * (-648735265 ^ -648735393) + var39;
                  float var41 = var3[var40];
                  if (var41 > 0.002F) {
                     double var42 = var8 * (double)var41;
                     int var44 = var40 * 4;
                     var1[var44] *= (float)(1.0 - var42 * 0.42);
                     var1[var44 + 1] = var1[var44 + 1] * (float)(1.0 - var42 * 0.72);
                     var1[var44 + 2] = var1[var44 + 2] * (float)(1.0 - var42 * 0.58);
                  }
               }
            }
         }

         for (int var49 = var47; var49 < var48; var49++) {
            for (int var51 = var46; var51 < var32; var51++) {
               int var52 = var49 * (-266701274 ^ -266701146) + var51;
               float var54 = var2[var52];
               if (!(var54 <= 0.0F)) {
                  m(var0, (double)var51 + 0.5, (double)var49 + 0.5, var7);
                  int var55 = var52 * 4;
                  float var56 = 1.0F - var54;
                  var1[var55] = var7[0] * var54 + var1[var55] * var56;
                  var1[var55 + 1] = var7[1] * var54 + var1[var55 + 1] * var56;
                  var1[var55 + 2] = var7[2] * var54 + var1[var55 + 2] * var56;
                  var1[var55 + 3] = var54 + var1[var55 + 3] * var56;
               }
            }
         }
      } catch (RuntimeException var45) {
         throw var45;
      }
   }

   private static void o(double[] var0, float[] var1, byte[] var2, int[] var3, int var4, int var5, int var6, int var7) {

      assert var0 != null
         && var1 != null
         && var2 != null
         && var3 != null
         && var0.length == 27
         && var1.length == (-516702210 ^ -516685826)
         && var2.length == (-945189723 ^ -945173339)
         && var3.length == (2071275899 ^ 2071292283)
         && var4 >= 0
         && var5 >= 0
         && var6 <= (-604916663 ^ -604916535)
         && var7 <= (1334662534 ^ 1334662406)
         && var0[6] > 0.0
         && var0[7] > 0.0
         && var0[7] < 1.0
         && var0[10] > 0.0 : "coverage: ba" + "d p" + "etal";

      try {
         int var8 = Math.max(0, var4 - 1);
         int var9 = Math.max(0, var5 - 1);
         int var10 = Math.min(-1793635116 ^ -1793635244, var6 + 1);
         int var11 = Math.min(-1051428667 ^ -1051428795, var7 + 1);

         for (int var12 = var9; var12 < var11; var12++) {
            for (int var13 = var8; var13 < var10; var13++) {
               var2[var12 * (-1808329328 ^ -1808329456) + var13] = (byte)(l(var0, (double)var13 + 0.5, (double)var12 + 0.5) ? 1 : 0);
            }
         }

         for (int var24 = var5; var24 < var7; var24++) {
            for (int var25 = var4; var25 < var6; var25++) {
               byte var14 = var2[var24 * (427758841 ^ 427758713) + var25];
               boolean var15 = true;

               for (int var16 = Math.max(var9, var24 - 1); var15 && var16 <= Math.min(var11 - 1, var24 + 1); var16++) {
                  for (int var17 = Math.max(var8, var25 - 1); var17 <= Math.min(var10 - 1, var25 + 1); var17++) {
                     if (var2[var16 * (1677118550 ^ 1677118678) + var17] != var14) {
                        var15 = false;
                        break;
                     }
                  }
               }

               if (var15) {
                  var1[var24 * (669410584 ^ 669410712) + var25] = (float)var14;
                  if (var14 != 0) {
                     var3[var24 * (-1516701282 ^ -1516701410) + var25] = 65535;
                  }
               } else {
                  int var26 = 0;

                  for (int var27 = 0; var27 < 4; var27++) {
                     double var18 = (double)var24 + 0.5 + (((double)var27 + 0.5) * 0.25 - 0.5) * 1.45;

                     for (int var20 = 0; var20 < 4; var20++) {
                        double var21 = (double)var25 + 0.5 + (((double)var20 + 0.5) * 0.25 - 0.5) * 1.45;
                        if (l(var0, var21, var18)) {
                           var26 |= 1 << var27 * 4 + var20;
                        }
                     }
                  }

                  var1[var24 * (576065058 ^ 576065186) + var25] = (float)Integer.bitCount(var26) / 16.0F;
                  var3[var24 * (937873636 ^ 937873508) + var25] = var3[var24 * (937873636 ^ 937873508) + var25] | var26;
               }
            }
         }
      } catch (RuntimeException var23) {
         throw var23;
      }
   }

   private static void p(float[] var0, int[] var1) {

      assert var0 != null
         && var1 != null
         && var0.length == (-1372527415 ^ -1372461879)
         && var1.length == (-543040733 ^ -543057117)
         && (var1[0] & (-1536776687 ^ 1536796177)) == 0
         && (var1[127] & (1424397045 ^ -1424387339)) == 0
         && (var1[-410160936 ^ -410161064] & (-1039295076 ^ 1039310236)) == 0
         && (var1[-633031020 ^ -633039148] & (1674586861 ^ -1674630419)) == 0
         && (var1[306084609 ^ 306070654] & (1556326395 ^ -1556305925)) == 0
         && (var1[1424522125 ^ 1424507917] & (-693815561 ^ 693778167)) == 0
         && (var1[296936849 ^ 296933998] & (1986787993 ^ -1986725223)) == 0 : "se" + "al: bad sub-" + "sample masks";

      try {
         for (int var2 = 0; var2 < (402239188 ^ 402255572); var2++) {
            int var3 = var1[var2];
            if (var3 != 0) {
               int var4 = var2 * 4;
               float var5 = var0[var4 + 3];
               float var6 = (float)Integer.bitCount(var3) / 16.0F;
               if (var6 > var5 && var5 > 1.0E-6F) {
                  float var7 = var6 / var5;
                  var0[var4] *= var7;
                  var0[var4 + 1] = var0[var4 + 1] * var7;
                  var0[var4 + 2] = var0[var4 + 2] * var7;
                  var0[var4 + 3] = var6;
               }
            }
         }
      } catch (RuntimeException var8) {
         throw var8;
      }
   }

   private static void q(float[] var0, double var1, double var3, double var5, int var7, double var8) {

      float var10 = (float)(var7 >> 16 & (1723930088 ^ 1723929879)) / 255.0F;
      float var11 = (float)(var7 >> 8 & (-1949084894 ^ -1949084707)) / 255.0F;
      float var12 = (float)(var7 & (1409010964 ^ 1409011179)) / 255.0F;
      int var13 = Math.max(0, (int)(var1 - var5 - 2.0));
      int var14 = Math.min(1367472092 ^ 1367471964, (int)(var1 + var5 + 3.0));
      int var15 = Math.max(0, (int)(var3 - var5 - 2.0));
      int var16 = Math.min(1372780158 ^ 1372780286, (int)(var3 + var5 + 3.0));

      for (int var17 = var15; var17 < var16; var17++) {
         for (int var18 = var13; var18 < var14; var18++) {
            double var19 = (double)var18 + 0.5 - var1;
            double var21 = (double)var17 + 0.5 - var3;
            double var23 = (var5 - Math.sqrt(var19 * var19 + var21 * var21)) / 1.45 + 0.5;
            var23 = (var23 < 0.0 ? 0.0 : (var23 > 1.0 ? 1.0 : var23)) * var8;
            if (var23 > 0.0) {
               int var25 = (var17 * (-1980851644 ^ -1980851516) + var18) * 4;
               float var26 = (float)var23;
               float var27 = 1.0F - var26;
               var0[var25] = var10 * var26 + var0[var25] * var27;
               var0[var25 + 1] = var11 * var26 + var0[var25 + 1] * var27;
               var0[var25 + 2] = var12 * var26 + var0[var25 + 2] * var27;
               var0[var25 + 3] = var26 + var0[var25 + 3] * var27;
            }
         }
      }
   }

   private static void r(float[] var0, double var1, double var3, double var5, double var7, int var9) {

      float var10 = (float)(var9 >> 16 & (512552971 ^ 512553204)) / 255.0F;
      float var11 = (float)(var9 >> 8 & (253463723 ^ 253463636)) / 255.0F;
      float var12 = (float)(var9 & (384395103 ^ 384395168)) / 255.0F;
      int var13 = Math.max(0, (int)(var1 - var7 - 2.0));
      int var14 = Math.min(-1192019484 ^ -1192019612, (int)(var1 + var7 + 3.0));
      int var15 = Math.max(0, (int)(var3 - var7 - 2.0));
      int var16 = Math.min(-998811014 ^ -998810886, (int)(var3 + var7 + 3.0));

      for (int var17 = var15; var17 < var16; var17++) {
         for (int var18 = var13; var18 < var14; var18++) {
            double var19 = (double)var18 + 0.5 - var1;
            double var21 = ((double)var17 + 0.5 - var3) / var5;
            double var23 = (var7 - Math.sqrt(var19 * var19 + var21 * var21)) / 1.45 + 0.5;
            var23 = var23 < 0.0 ? 0.0 : (var23 > 1.0 ? 1.0 : var23);
            if (var23 > 0.0) {
               int var25 = (var17 * (-1623888881 ^ -1623888753) + var18) * 4;
               float var26 = (float)var23;
               float var27 = 1.0F - var26;
               var0[var25] = var10 * var26 + var0[var25] * var27;
               var0[var25 + 1] = var11 * var26 + var0[var25 + 1] * var27;
               var0[var25 + 2] = var12 * var26 + var0[var25 + 2] * var27;
               var0[var25 + 3] = var26 + var0[var25 + 3] * var27;
            }
         }
      }
   }

   private static void s(
      float[] var0,
      double var1,
      double var3,
      double var5,
      double var7,
      double var9,
      double var11,
      double var13,
      double var15,
      double var17,
      double var19,
      int var21,
      double var22
   ) {

      float var24 = (float)(var21 >> 16 & (1661212411 ^ 1661212164)) / 255.0F;
      float var25 = (float)(var21 >> 8 & (-1039192459 ^ -1039192438)) / 255.0F;
      float var26 = (float)(var21 & (-613440381 ^ -613440388)) / 255.0F;
      int var27 = (int)(var15 * (1.0 + var19) / Math.min(1.0, Math.abs(var11)) + 3.0);
      int var28 = Math.max(0, (int)var1 - var27);
      int var29 = Math.min(-1838506394 ^ -1838506266, (int)var1 + var27);
      int var30 = Math.max(0, (int)var3 - var27);
      int var31 = Math.min(-369755686 ^ -369755814, (int)var3 + var27);

      for (int var32 = var30; var32 < var31; var32++) {
         for (int var33 = var28; var33 < var29; var33++) {
            double var34 = (double)var33 + 0.5 - var1;
            double var36 = (double)var32 + 0.5 - var3;
            double var38 = var5 * var34 + var7 * var36;
            double var40 = var9 * var34 + var11 * var36;
            double var42 = Math.sqrt(var38 * var38 + var40 * var40);
            if (!(var42 > var15 * (1.0 + var19))) {
               double var44 = Math.atan2(var38, -var40) - var17;
               double var46 = 1.0 + var19 * Math.cos(5.0 * var44);
               double var48 = (var42 - var13) / (var15 * var46 - var13);
               var48 = var48 < 0.0 ? 0.0 : (var48 > 1.0 ? 1.0 : var48);
               var48 = var22 * (1.0 - var48 * var48 * (3.0 - 2.0 * var48));
               if (var48 > 0.0) {
                  int var50 = (var32 * (-1799208300 ^ -1799208428) + var33) * 4;
                  float var51 = (float)var48;
                  float var52 = 1.0F - var51;
                  var0[var50] = var24 * var51 + var0[var50] * var52;
                  var0[var50 + 1] = var25 * var51 + var0[var50 + 1] * var52;
                  var0[var50 + 2] = var26 * var51 + var0[var50 + 2] * var52;
                  var0[var50 + 3] = var51 + var0[var50 + 3] * var52;
               }
            }
         }
      }
   }

   private static void t(float[] var0, int var1, double var2, double var4, double var6, double var8, double var10, double var12) {

      int var14 = var1 == 6 ? 9 : 8;
      double[] var15 = new double[var14];
      double[] var16 = new double[var14];
      double[] var17 = new double[var14];
      int[] var18 = new int[var14];
      double var19 = 0.0;
      int var21 = 0;

      while (var21 < var14) {
         double var22 = Math.toRadians(var10 + 36.0 + (double)var21 * 360.0 / (double)var14 + 14.0 * z(var1, var21, 21));
         if (var21 > 0 && z(var1, var21, 24) > 0.4) {
            var22 = var19 + Math.toRadians(11.0 + 3.0 * z(var1, var21, 25));
         }

         var19 = var22;
         double var24 = var12 * (0.26 + 0.12 * z(var1, var21, 22));
         double var26 = var8 != 0.0 ? var24 * 0.62 : var24;
         double var28 = var8 != 0.0 ? var24 * 0.78 : 0.0;
         double var30 = Math.sin(var22) * var26;
         double var32 = Math.cos(var22) * var26;
         var15[var21] = var2 + var30;
         var16[var21] = var4 - (var32 * var6 + var28 * var8);
         var17[var21] = -var32 * var8 + var28 * var6;

         int var34;
         for (var34 = var21 - 1; var34 >= 0 && var17[var18[var34]] > var17[var21]; var34--) {
            var18[var34 + 1] = var18[var34];
         }

         var18[var34 + 1] = var21++;
      }

      for (int var35 = 0; var35 < var14; var35++) {
         double var37 = var2 + (var15[var35] - var2) * 0.18;
         double var39 = var4 + (var16[var35] - var4) * 0.18;
         u(var0, var37, var39, var15[var35], var16[var35], 0.75, 401045646 ^ 387750754, 0.55);
      }

      for (int var36 = 0; var36 < var14; var36++) {
         int var38 = var18[var36];
         v(var0, var15[var38], var16[var38], 3.0 + 0.2 * z(var1, var38, 23));
      }
   }

   private static void u(float[] var0, double var1, double var3, double var5, double var7, double var9, int var11, double var12) {

      float var14 = (float)(var11 >> 16 & (1439974562 ^ 1439974493)) / 255.0F;
      float var15 = (float)(var11 >> 8 & (-1892146515 ^ -1892146606)) / 255.0F;
      float var16 = (float)(var11 & (35822924 ^ 35823027)) / 255.0F;
      int var17 = Math.max(0, (int)(Math.min(var1, var5) - var9 - 2.0));
      int var18 = Math.min(-751016202 ^ -751016330, (int)(Math.max(var1, var5) + var9 + 3.0));
      int var19 = Math.max(0, (int)(Math.min(var3, var7) - var9 - 2.0));
      int var20 = Math.min(-1448876028 ^ -1448875900, (int)(Math.max(var3, var7) + var9 + 3.0));
      double var21 = var5 - var1;
      double var23 = var7 - var3;
      double var25 = var21 * var21 + var23 * var23;

      for (int var27 = var19; var27 < var20; var27++) {
         for (int var28 = var17; var28 < var18; var28++) {
            double var29 = (double)var28 + 0.5 - var1;
            double var31 = (double)var27 + 0.5 - var3;
            double var33 = var25 > 0.0 ? (var29 * var21 + var31 * var23) / var25 : 0.0;
            var33 = var33 < 0.0 ? 0.0 : (var33 > 1.0 ? 1.0 : var33);
            double var35 = var29 - var21 * var33;
            double var37 = var31 - var23 * var33;
            double var39 = Math.sqrt(var35 * var35 + var37 * var37);
            double var41 = (var9 - var39) / 1.45 + 0.5;
            var41 = (var41 < 0.0 ? 0.0 : (var41 > 1.0 ? 1.0 : var41)) * var12;
            if (var41 > 0.0) {
               int var43 = (var27 * (1577569578 ^ 1577569706) + var28) * 4;
               float var44 = (float)var41;
               float var45 = 1.0F - var44;
               var0[var43] = var14 * var44 + var0[var43] * var45;
               var0[var43 + 1] = var15 * var44 + var0[var43 + 1] * var45;
               var0[var43 + 2] = var16 * var44 + var0[var43 + 2] * var45;
               var0[var43 + 3] = var44 + var0[var43 + 3] * var45;
            }
         }
      }
   }

   private static void v(float[] var0, double var1, double var3, double var5) {

      int var7 = Math.max(0, (int)(var1 - var5 - 2.0));
      int var8 = Math.min(-557077135 ^ -557077007, (int)(var1 + var5 + 3.0));
      int var9 = Math.max(0, (int)(var3 - var5 - 2.0));
      int var10 = Math.min(204729490 ^ 204729362, (int)(var3 + var5 + 3.0));

      for (int var11 = var9; var11 < var10; var11++) {
         for (int var12 = var7; var12 < var8; var12++) {
            double var13 = (double)var12 + 0.5 - var1;
            double var15 = (double)var11 + 0.5 - var3;
            double var17 = Math.sqrt(var13 * var13 + var15 * var15);
            double var19 = (var5 - var17) / 1.45 + 0.5;
            var19 = var19 < 0.0 ? 0.0 : (var19 > 1.0 ? 1.0 : var19);
            if (!(var19 <= 0.0)) {
               double var21 = 0.55 * var17 / var5 + 0.45 * ((var13 * 0.55 + var15 * 0.8) / var5 * 0.5 + 0.5);
               var21 = var21 < 0.0 ? 0.0 : (var21 > 1.0 ? 1.0 : var21);
               var21 *= var21;
               float var23 = (float)((255.0 - 22.0 * var21) / 255.0);
               float var24 = (float)((210.0 - 48.0 * var21) / 255.0);
               float var25 = (float)((74.0 - 36.0 * var21) / 255.0);
               int var26 = (var11 * (308802719 ^ 308802591) + var12) * 4;
               float var27 = (float)var19;
               float var28 = 1.0F - var27;
               var0[var26] = var23 * var27 + var0[var26] * var28;
               var0[var26 + 1] = var24 * var27 + var0[var26 + 1] * var28;
               var0[var26 + 2] = var25 * var27 + var0[var26 + 2] * var28;
               var0[var26 + 3] = var27 + var0[var26 + 3] * var28;
            }
         }
      }
   }

   private static void w(int var0, float[] var1, float[] var2, int[] var3, int[] var4) {

      assert var0 >= 0
         && var0 < 8
         && var1 != null
         && var2 != null
         && var3 != null
         && var4 != null
         && var1 != var2
         && var3 != var4
         && var1.length == (700156937 ^ 700091401)
         && var2.length == (1911197557 ^ 1911263093)
         && var3.length == (1788948507 ^ 1788964891)
         && var4.length == (-1252645368 ^ -1252907512)
         && (var0 & 3) * (-762539125 ^ -762539253) + (878939142 ^ 878939270) <= (44474157 ^ 44473645)
         && (var0 >> 2) * (-487442732 ^ -487442860) + (-1562735844 ^ -1562735716) <= (2134142925 ^ 2134142669)
         && (1110273175 ^ 1110273303) + (var0 & 3) * 16 + 16 <= (1448412597 ^ 1448413109)
         && (1979281545 ^ 1979281801) + (var0 >> 2) * 64 + 64 <= (2092411742 ^ 2092411230) : "emit: " + "bad " + "spri" + "te";

      try {
         for (int var5 = 0; var5 < 4; var5++) {
            int var6 = (2024971897 ^ 2024972025) >> var5;
            int var7 = 1 << var5;
            int var8;
            int var9;
            if (var5 == 0) {
               var8 = (var0 & 3) * (-1338517876 ^ -1338518004);
               var9 = (var0 >> 2) * (-2061584084 ^ -2061583956);
            } else if (var5 == 1) {
               var8 = (var0 & 3) * 64;
               var9 = (1235298375 ^ 1235298631) + (var0 >> 2) * 64;
            } else if (var5 == 2) {
               var8 = (140609932 ^ 140609676) + (var0 & 3) * 32;
               var9 = (484057393 ^ 484057137) + (var0 >> 2) * 32;
            } else {
               var8 = (-529643196 ^ -529643324) + (var0 & 3) * 16;
               var9 = (2046472139 ^ 2046471883) + (var0 >> 2) * 16;
            }

            float var10 = 1.0F / (float)(var7 * var7);

            for (int var11 = 0; var11 < var6; var11++) {
               for (int var12 = 0; var12 < var6; var12++) {
                  float var13 = 0.0F;
                  float var14 = 0.0F;
                  float var15 = 0.0F;
                  float var16 = 0.0F;

                  for (int var17 = 0; var17 < var7; var17++) {
                     int var18 = (var11 * var7 + var17) * (-1184120964 ^ -1184120836) + var12 * var7;

                     for (int var19 = 0; var19 < var7; var19++) {
                        int var20 = (var18 + var19) * 4;
                        var13 += var1[var20];
                        var14 += var1[var20 + 1];
                        var15 += var1[var20 + 2];
                        var16 += var1[var20 + 3];
                     }
                  }

                  int var29 = (var11 * var6 + var12) * 4;
                  var16 *= var10;
                  int var31 = var11 * var6 + var12;
                  if (var16 > 1.0E-5F) {
                     float var32 = var10 / var16;
                     var2[var29] = Math.min(1.0F, var13 * var32);
                     var2[var29 + 1] = Math.min(1.0F, var14 * var32);
                     var2[var29 + 2] = Math.min(1.0F, var15 * var32);
                     var3[var31] = var31;
                  } else {
                     var16 = 0.0F;
                     var3[var31] = -1;
                  }

                  var2[var29 + 3] = var16;
               }
            }

            x(var3, var6);

            for (int var22 = 0; var22 < var6; var22++) {
               for (int var23 = 0; var23 < var6; var23++) {
                  int var24 = var22 * var6 + var23;
                  int var25 = var3[var24];
                  int var26 = Math.round(var2[var24 * 4 + 3] * 255.0F);
                  int var28 = 0;
                  if (var25 >= 0) {
                     int var30 = var25 * 4;
                     var28 = Math.round(var2[var30] * 255.0F) << 16 | Math.round(var2[var30 + 1] * 255.0F) << 8 | Math.round(var2[var30 + 2] * 255.0F);
                  }

                  var4[(var9 + var22) * (1552554253 ^ 1552554765) + var8 + var23] = Math.max(0, Math.min(48888967 ^ 48888952, var26)) << 24 | var28;
               }
            }
         }
      } catch (RuntimeException var21) {
         throw var21;
      }
   }

   private static void x(int[] var0, int var1) {

      assert var0 != null
         && var0.length == (-2051030791 ^ -2051047175)
         && var1 >= 16
         && var1 <= (1300984740 ^ 1300984612)
         && Integer.bitCount(var1) == 1
         && var1 * var1 <= var0.length
         && var0[0] >= -1
         && var0[0] < var1 * var1
         && var0[var1 - 1] >= -1
         && var0[var1 - 1] < var1 * var1
         && var0[var1 * var1 - var1] >= -1
         && var0[var1 * var1 - var1] < var1 * var1
         && var0[var1 * var1 - 1] >= -1
         && var0[var1 * var1 - 1] < var1 * var1 : "bleed" + ":" + " bad" + " seeds";

      try {
         for (int var2 = 0; var2 < 2; var2++) {
            int var3 = var2 == 0 ? 1 : -1;
            int var4 = var2 == 0 ? 0 : var1 - 1;

            for (int var5 = 0; var5 < var1; var5++) {
               int var6 = var4 + var3 * var5;

               for (int var7 = 0; var7 < var1; var7++) {
                  int var8 = var4 + var3 * var7;
                  int var9 = var6 * var1 + var8;
                  int var10 = var0[var9];
                  int var11 = -214893342 ^ -1932590307;
                  if (var10 >= 0) {
                     int var12 = var10 % var1 - var8;
                     int var13 = var10 / var1 - var6;
                     var11 = var12 * var12 + var13 * var13;
                  }

                  if (var11 != 0) {
                     for (int var20 = 0; var20 < 4; var20++) {
                        int var14;
                        int var21;
                        if (var20 == 0) {
                           var21 = var8 - var3;
                           var14 = var6;
                        } else if (var20 == 1) {
                           var21 = var8 - var3;
                           var14 = var6 - var3;
                        } else if (var20 == 2) {
                           var21 = var8;
                           var14 = var6 - var3;
                        } else {
                           var21 = var8 + var3;
                           var14 = var6 - var3;
                        }

                        if (var21 >= 0 && var14 >= 0 && var21 < var1 && var14 < var1) {
                           int var15 = var0[var14 * var1 + var21];
                           if (var15 >= 0) {
                              int var16 = var15 % var1 - var8;
                              int var17 = var15 / var1 - var6;
                              int var18 = var16 * var16 + var17 * var17;
                              if (var18 < var11) {
                                 var11 = var18;
                                 var10 = var15;
                              }
                           }
                        }
                     }

                     var0[var9] = var10;
                  }
               }
            }
         }
      } catch (RuntimeException var19) {
         throw var19;
      }
   }

   private static void y(float[] var0, float[] var1, float[] var2, int var3, int var4, int var5, int var6, int var7) {

      assert var0 != null
         && var1 != null
         && var2 != null
         && var0.length == (118742563 ^ 118726179)
         && var1.length == (-1788179069 ^ -1788162685)
         && var2.length == (286540907 ^ 286524523)
         && var2 != var0
         && var2 != var1
         && var3 >= 1
         && var3 <= 8
         && var4 >= 0
         && var5 >= 0
         && var6 <= (2046464831 ^ 2046464959)
         && var7 <= (879260691 ^ 879260819) : "blur: bad rectangle";

      try {
         float var8 = 1.0F / (float)(2 * var3 + 1);

         for (int var9 = var5; var9 < var7; var9++) {
            int var10 = var9 * (-632038005 ^ -632038133);
            float var11 = 0.0F;

            for (int var12 = var4; var12 <= var4 + var3 && var12 < var6; var12++) {
               var11 += var0[var10 + var12];
            }

            for (int var20 = var4; var20 < var6; var20++) {
               var2[var10 + var20] = var11 * var8;
               int var13 = var20 - var3;
               int var14 = var20 + var3 + 1;
               if (var13 >= var4) {
                  var11 -= var0[var10 + var13];
               }

               if (var14 < var6) {
                  var11 += var0[var10 + var14];
               }
            }
         }

         for (int var16 = var4; var16 < var6; var16++) {
            float var17 = 0.0F;

            for (int var18 = var5; var18 <= var5 + var3 && var18 < var7; var18++) {
               var17 += var2[var18 * (133468136 ^ 133468008) + var16];
            }

            for (int var19 = var5; var19 < var7; var19++) {
               var1[var19 * (-1573749429 ^ -1573749301) + var16] = var17 * var8;
               int var21 = var19 - var3;
               int var22 = var19 + var3 + 1;
               if (var21 >= var5) {
                  var17 -= var2[var21 * (1270587166 ^ 1270587294) + var16];
               }

               if (var22 < var7) {
                  var17 += var2[var22 * (279319160 ^ 279319288) + var16];
               }
            }
         }
      } catch (RuntimeException var15) {
         throw var15;
      }
   }

   private static double z(int var0, int var1, int var2) {

      int var3 = var0 * (189057494 ^ 747643643) ^ var1 * (-803262634 ^ -968275737) ^ var2 * (1194752631 ^ 654244912);
      var3 ^= var3 >>> 15;
      var3 *= 1233510211 ^ 1704911662;
      var3 ^= var3 >>> 12;
      var3 *= 1506728722 ^ 1890907691;
      var3 ^= var3 >>> 15;
      return (double)(var3 & (-1331375991 ^ -1336201354)) / 8388607.0 - 1.0;
   }
}
