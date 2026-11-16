package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import java.util.Arrays;
import java.util.Random;

public final class SampleArrayCache {
   public static final int W = 512;
   public static final int H = 512;
   private static final int k = 128;
   private static final int l = 16384;
   private static final int m = 6;
   private static final int n = 24;
   private static final double o = 1.2;
   private static final double p = 3.2;
   private static final double q = 0.22;
   private static final int r = 64;

   private SampleArrayCache() {
   }

   public static int[] a() {

      int[] var0 = new int[262144];
      float[] var1 = new float[65536];
      float[] var2 = new float[65536];
      int[] var3 = new int[16384];
      double[] var4 = new double[144];

      for (int var5 = 0; var5 < 8; var5++) {
         Arrays.fill(var1, 0.0F);
         if (var5 < 7) {
            f(var1, var4, b(var5, var4));
         } else {
            g(var1);
         }

         j(var5, var1, var2, var3, var0);
      }

      float[] var8 = new float[4096];
      Random var6 = new Random(99537317L);

      for (int var7 = 0; var7 < var8.length; var7++) {
         var8[var7] = var6.nextFloat();
      }

      Arrays.fill(var1, 0.0F);
      h(var1, var8);
      j(8, var1, var2, var3, var0);
      Arrays.fill(var1, 0.0F);
      i(var1, var8);
      j(9, var1, var2, var3, var0);
      return var0;
   }

   private static int b(int var0, double[] var1) {

      int var2 = 0;
      if (var0 == 0) {
         var2 = e(var1, var2, 10.0, 2.0);
         var2 = c(var1, var2, 0.0, 10.0, 0.0, 46.5, 2.6);
         var2 = d(var1, var2, 19.5, 13.0, 60.0, 1.8);
         var2 = d(var1, var2, 29.5, 10.0, 60.0, 1.8);
         var2 = d(var1, var2, 39.0, 6.5, 60.0, 1.8);
      } else if (var0 == 1) {
         var2 = c(var1, var2, 0.0, 0.0, 0.0, 46.5, 2.7);
         var2 = d(var1, var2, 22.0, 16.0, 55.0, 1.85);
         var2 = d(var1, var2, 35.0, 10.0, 55.0, 1.85);
      } else if (var0 == 2) {
         var2 = c(var1, var2, 0.0, 0.0, 0.0, 40.5, 2.4);
         var2 = d(var1, var2, 12.0, 7.0, 50.0, 1.55);
         var2 = d(var1, var2, 19.5, 8.0, 50.0, 1.55);
         var2 = d(var1, var2, 27.0, 7.5, 50.0, 1.55);
         var2 = d(var1, var2, 34.0, 6.0, 50.0, 1.55);
         var2 = d(var1, var2, 40.5, 7.0, 34.0, 1.7);
      } else if (var0 == 3) {
         var2 = c(var1, var2, 0.0, 22.0, 22.0 / Math.sqrt(3.0) * 0.5, 11.0, 2.0);
         var2 = c(var1, var2, 0.0, 22.0, 0.0, 46.5, 2.6);
         var2 = d(var1, var2, 31.5, 11.0, 60.0, 1.8);
         var2 = d(var1, var2, 40.5, 6.5, 60.0, 1.8);
      } else if (var0 == 4) {
         var2 = e(var1, var2, 8.5, 1.8);
         var2 = e(var1, var2, 22.5, 2.0);
         var2 = c(var1, var2, 0.0, 8.5, 0.0, 46.5, 2.6);
         var2 = d(var1, var2, 31.5, 10.0, 60.0, 1.8);
         var2 = d(var1, var2, 40.5, 6.0, 60.0, 1.8);
      } else if (var0 == 5) {
         var2 = c(var1, var2, 0.0, 5.5, 2.75, 4.763139720814412, 1.7);
         var2 = c(var1, var2, 0.0, 5.5, 11.5, 19.918584287042087, 1.9);
         var2 = c(var1, var2, 11.5, 19.918584287042087, 0.0, 35.0, 1.9);
         var2 = c(var1, var2, 0.0, 5.5, 0.0, 46.5, 2.5);
         var2 = d(var1, var2, 39.0, 7.0, 55.0, 1.8);
      } else {
         var2 = e(var1, var2, 6.0, 1.7);
         var2 = c(var1, var2, 0.0, 6.0, 0.0, 47.0, 2.3);
         var2 = d(var1, var2, 19.0, 17.0, 60.0, 1.6);
         double var3 = 8.097337525384502;
         double var5 = 23.675;
         var2 = c(var1, var2, var3, var5, var3, var5 + 7.5, 1.45);
         var2 = d(var1, var2, 34.0, 10.0, 60.0, 1.6);
         var2 = d(var1, var2, 42.0, 5.0, 60.0, 1.6);
      }

      return var2;
   }

   private static int c(double[] var0, int var1, double var2, double var4, double var6, double var8, double var10) {

      int var12 = var1 * 6;
      double var13 = var6 - var2;
      double var15 = var8 - var4;
      double var17 = var13 * var13 + var15 * var15;
      var0[var12] = var2;
      var0[var12 + 1] = var4;
      var0[var12 + 2] = var13;
      var0[var12 + 3] = var15;
      var0[var12 + 4] = var17 > 1.0E-12 ? 1.0 / var17 : 0.0;
      var0[var12 + 5] = var10;
      return var1 + 1;
   }

   private static int d(double[] var0, int var1, double var2, double var4, double var6, double var8) {

      double var10 = Math.toRadians(var6);
      return c(var0, var1, 0.0, var2, Math.sin(var10) * var4, var2 + Math.cos(var10) * var4, var8);
   }

   private static int e(double[] var0, int var1, double var2, double var4) {

      return c(var0, var1, 0.0, var2, var2 * 0.8660254037844386, var2 * 0.5, var4);
   }

   private static void f(float[] var0, double[] var1, int var2) {

      double var3 = 0.0;

      for (int var5 = 0; var5 < var2; var5++) {
         int var6 = var5 * 6;
         double var7 = Math.sqrt(var1[var6] * var1[var6] + var1[var6 + 1] * var1[var6 + 1]);
         double var9 = var1[var6] + var1[var6 + 2];
         double var11 = var1[var6 + 1] + var1[var6 + 3];
         double var13 = Math.sqrt(var9 * var9 + var11 * var11);
         var3 = Math.max(var3, Math.max(var7, var13) + var1[var6 + 5]);
      }

      double var76 = var3 + 3.2 + 1.5;
      int var77 = Math.max(0, (int)Math.floor(64.0 - var76));
      int var8 = Math.min(1543080578 ^ 1543080450, (int)Math.ceil(64.0 + var76));
      double var78 = 0.8333333333333334;
      double var79 = 4.4;
      double var80 = 1.0;
      double var15 = 1.0;
      double var17 = 1.0;
      double var19 = 0.8156862745098039;
      double var21 = 0.8941176470588236;
      double var23 = 1.0;
      double var25 = 0.803921568627451;
      double var27 = 0.8705882352941177;
      double var29 = 0.9607843137254902;
      double var31 = 0.5882352941176471;
      double var33 = 0.6745098039215687;
      double var35 = 0.803921568627451;

      for (int var37 = var77; var37 < var8; var37++) {
         for (int var38 = var77; var38 < var8; var38++) {
            double var39 = (double)var38 + 0.5 - 64.0;
            double var41 = 64.0 - ((double)var37 + 0.5);
            double var43 = Math.sqrt(var39 * var39 + var41 * var41);
            if (!(var43 > var76)) {
               double var45 = var39 < 0.0 ? -var39 : var39;
               double var47 = var41;
               double var49 = 0.5 * var45 - 0.8660254037844386 * var41;
               if (var49 > 0.0) {
                  var45 -= var49;
                  var47 = var41 + 1.7320508075688772 * var49;
               }

               if (var45 < 0.0) {
                  var45 = -var45;
               }

               var49 = 0.8660254037844386 * var45 - 0.5 * var47;
               if (var49 > 0.0) {
                  var45 -= 1.7320508075688772 * var49;
                  var47 += var49;
               }

               double var51 = 1.0E9;
               int var53 = 0;

               for (byte var54 = 0; var53 < var2; var54 += 6) {
                  double var55 = var45 - var1[var54];
                  double var57 = var47 - var1[var54 + 1];
                  double var59 = (var55 * var1[var54 + 2] + var57 * var1[var54 + 3]) * var1[var54 + 4];
                  var59 = var59 < 0.0 ? 0.0 : (var59 > 1.0 ? 1.0 : var59);
                  var55 -= var1[var54 + 2] * var59;
                  var57 -= var1[var54 + 3] * var59;
                  double var61 = Math.sqrt(var55 * var55 + var57 * var57) - var1[var54 + 5];
                  if (var61 < var51) {
                     var51 = var61;
                  }

                  var53++;
               }

               if (!(var51 >= var79)) {
                  double var82 = 0.5 - var51 * var78;
                  double var83 = var82 < 0.0 ? 0.0 : (var82 > 1.0 ? 1.0 : var82);
                  double var86;
                  if (var51 <= 0.0) {
                     var86 = 0.22;
                  } else {
                     double var88 = 1.0 - var51 / 3.2;
                     var86 = var88 > 0.0 ? 0.22 * var88 * var88 : 0.0;
                  }

                  double var91 = -var51 / 1.15;
                  var91 = var91 < 0.0 ? 0.0 : (var91 > 1.0 ? 1.0 : var91);
                  double var84 = var83 * (0.7 + 0.3 * var91 * var91);
                  double var93 = var84 + var86 * (1.0 - var83);
                  if (!(var93 <= 0.0)) {
                     double var63 = (var43 / var3 - 0.3) / 0.7;
                     var63 = var63 < 0.0 ? 0.0 : (var63 > 1.0 ? 1.0 : var63);
                     var63 = var63 * var63 * (3.0 - 2.0 * var63);
                     double var65 = var80 + (var19 - var80) * var63;
                     double var67 = var15 + (var21 - var15) * var63;
                     double var69 = var17 + (var23 - var17) * var63;
                     double var71 = -var51 / 1.15;
                     var71 = var71 < 0.0 ? 0.0 : (var71 > 1.0 ? 1.0 : var71);
                     var65 = var25 + (var65 - var25) * var71;
                     var67 = var27 + (var67 - var27) * var71;
                     var69 = var29 + (var69 - var29) * var71;
                     double var73 = var86 * (1.0 - var83);
                     int var75 = (var37 * (1678924215 ^ 1678924087) + var38) * 4;
                     var0[var75] = (float)(var65 * var84 + var31 * var73);
                     var0[var75 + 1] = (float)(var67 * var84 + var33 * var73);
                     var0[var75 + 2] = (float)(var69 * var84 + var35 * var73);
                     var0[var75 + 3] = (float)var93;
                  }
               }
            }
         }
      }
   }

   private static void g(float[] var0) {

      double var1 = 45.0;
      double var3 = 0.5490196078431373;
      double var5 = 0.6431372549019608;
      double var7 = 0.7843137254901961;

      for (int var9 = 0; var9 < (-1432420089 ^ -1432419961); var9++) {
         for (int var10 = 0; var10 < (-65854564 ^ -65854692); var10++) {
            double var11 = (double)var10 + 0.5 - 64.0;
            double var13 = (double)var9 + 0.5 - 64.0;
            double var15 = Math.sqrt(var11 * var11 + var13 * var13) / var1;
            if (!(var15 >= 1.0)) {
               double var17 = (var15 - 0.3) / 0.7;
               var17 = var17 < 0.0 ? 0.0 : var17;
               double var19 = 1.0 - var17 * var17 * (3.0 - 2.0 * var17);
               double var21 = var15 < 0.85 ? var15 / 0.85 : 1.0;
               var21 = 0.4 + var21 * (2.0 - var21) * 0.25;
               int var23 = (var9 * (-1669043265 ^ -1669043393) + var10) * 4;
               var0[var23] = (float)((1.0 + (var3 - 1.0) * var21) * var19);
               var0[var23 + 1] = (float)((1.0 + (var5 - 1.0) * var21) * var19);
               var0[var23 + 2] = (float)((1.0 + (var7 - 1.0) * var21) * var19);
               var0[var23 + 3] = (float)var19;
            }
         }
      }
   }

   private static void h(float[] var0, float[] var1) {

      int var2 = 864636786 ^ 864635762;
      double[] var3 = new double[var2];

      for (int var4 = 0; var4 < var2; var4++) {
         double var5 = (double)var4 * ((Math.PI * 2) / (double)var2);
         double var7 = 0.0;
         double var9 = 0.0;

         for (int var11 = 0; var11 < 2; var11++) {
            double var12 = var11 == 0 ? 2.2 : 11.0;
            double var14 = Math.cos(var5) * var12 + (var11 == 0 ? 5.0 : 30.0);
            double var16 = Math.sin(var5) * var12 + (var11 == 0 ? 5.0 : 30.0);
            int var18 = (int)Math.floor(var14);
            int var19 = (int)Math.floor(var16);
            double var20 = var14 - (double)var18;
            double var22 = var16 - (double)var19;
            var20 = var20 * var20 * (3.0 - 2.0 * var20);
            var22 = var22 * var22 * (3.0 - 2.0 * var22);
            double var24 = (double)var1[(var19 & 63) * 64 + (var18 & 63)];
            double var26 = (double)var1[(var19 & 63) * 64 + (var18 + 1 & 63)];
            double var28 = (double)var1[(var19 + 1 & 63) * 64 + (var18 & 63)];
            double var30 = (double)var1[(var19 + 1 & 63) * 64 + (var18 + 1 & 63)];
            double var32 = var24 + (var26 - var24) * var20 + (var28 - var24) * var22 + (var24 - var26 - var28 + var30) * var20 * var22;
            if (var11 == 0) {
               var7 = var32;
            } else {
               var9 = var32;
            }
         }

         var3[var4] = 32.0 + 22.0 * (var7 - 0.5) + 11.0 * (var9 - 0.5) + 5.0 * Math.cos(2.0 * var5 + 0.7);
      }

      double[] var43 = new double[]{13.0, -9.0, 3.4, -11.0, 12.0, 2.6, 4.0, 18.0, 1.9};
      double var44 = (double)var2 / (Math.PI * 2);

      for (int var45 = 0; var45 < (1918936804 ^ 1918936676); var45++) {
         for (int var8 = 0; var8 < (1175142982 ^ 1175143110); var8++) {
            double var46 = 0.0;
            int var47 = 0;
            double var48 = 0.0;

            for (int var49 = 0; var49 < 16; var49++) {
               double var15 = (double)var8 + ((double)(var49 & 3) + 0.5) * 0.25 - 64.0;
               double var17 = (double)var45 + ((double)(var49 >> 2) + 0.5) * 0.25 - 64.0;
               double var53 = Math.sqrt(var15 * var15 + var17 * var17);
               if (!(var53 >= 60.0)) {
                  double var21 = Math.atan2(var17, var15);
                  int var23 = (int)((var21 < 0.0 ? var21 + (Math.PI * 2) : var21) * var44) & var2 - 1;
                  double var61 = var3[var23];
                  if (!(var53 >= var61)) {
                     double var63 = 1.0;

                     for (byte var65 = 0; var65 < 9; var65 += 3) {
                        double var29 = var15 - var43[var65];
                        double var31 = var17 - var43[var65 + 1];
                        double var33 = var29 * var29 + var31 * var31;
                        double var35 = var43[var65 + 2] * 1.6;
                        if (var33 < var35 * var35) {
                           double var37 = Math.atan2(var31, var29);
                           int var39 = (int)((var37 < 0.0 ? var37 + (Math.PI * 2) : var37) * var44 + (double)(var65 * 97)) & var2 - 1;
                           double var40 = var43[var65 + 2] * (0.55 + 0.9 * (var3[var39] - 22.0) / 22.0);
                           if (var33 < var40 * var40) {
                              var63 = 0.12;
                           }
                        }
                     }

                     var46 += var63;
                     var47++;
                     var48 += var53 / var61;
                  }
               }
            }

            if (var47 != 0) {
               double var50 = var46 / 16.0;
               double var51 = var48 / (double)var47;
               double var52 = 0.0;
               double var55 = 0.0;

               for (int var57 = 0; var57 < 2; var57++) {
                  double var60 = var57 == 0 ? (double)var8 * 0.09 : (double)var8 * 0.2 + 31.0;
                  double var25 = var57 == 0 ? (double)var45 * 0.45 : (double)var45 * 0.2 + 17.0;
                  int var27 = (int)Math.floor(var60);
                  int var66 = (int)Math.floor(var25);
                  double var67 = var60 - (double)var27;
                  double var69 = var25 - (double)var66;
                  var67 = var67 * var67 * (3.0 - 2.0 * var67);
                  var69 = var69 * var69 * (3.0 - 2.0 * var69);
                  double var71 = (double)var1[(var66 & 63) * 64 + (var27 & 63)];
                  double var72 = (double)var1[(var66 & 63) * 64 + (var27 + 1 & 63)];
                  double var73 = (double)var1[(var66 + 1 & 63) * 64 + (var27 & 63)];
                  double var74 = (double)var1[(var66 + 1 & 63) * 64 + (var27 + 1 & 63)];
                  double var41 = var71 + (var72 - var71) * var67 + (var73 - var71) * var69 + (var71 - var72 - var73 + var74) * var67 * var69;
                  if (var57 == 0) {
                     var52 = var41;
                  } else {
                     var55 = var41;
                  }
               }

               double var58 = (0.78 - 0.32 * var51 * var51 * var51 - 0.18 * (var52 - 0.5) + 0.06 * (var55 - 0.5)) * 1.15;
               var58 = var58 > 1.0 ? 1.0 : (var58 < 0.0 ? 0.0 : var58);
               double var62 = var50 * (0.72 + 0.28 * var51);
               int var64 = (var45 * (293386381 ^ 293386253) + var8) * 4;
               var0[var64] = (float)(var58 * var62);
               var0[var64 + 1] = (float)(var58 * 0.985 * var62);
               var0[var64 + 2] = (float)(var58 * 0.97 * var62);
               var0[var64 + 3] = (float)var62;
            }
         }
      }
   }

   private static void i(float[] var0, float[] var1) {

      for (int var2 = 0; var2 < (935994629 ^ 935994757); var2++) {
         for (int var3 = 0; var3 < (-291945330 ^ -291945458); var3++) {
            double var4 = ((double)var3 + 0.5 - 64.0) / 64.0;
            double var6 = ((double)var2 + 0.5 - 64.0) / 64.0;
            double var8 = Math.sqrt(var4 * var4 + var6 * var6);
            if (!(var8 >= 0.97)) {
               double var10 = 0.0;
               double var12 = 0.5;
               double var14 = 0.0625;

               for (int var16 = 0; var16 < 5; var16++) {
                  double var17 = (double)var3 * var14 + (double)var16 * 7.1;
                  double var19 = (double)var2 * var14 + (double)var16 * 3.3;
                  int var21 = (int)Math.floor(var17);
                  int var22 = (int)Math.floor(var19);
                  double var23 = var17 - (double)var21;
                  double var25 = var19 - (double)var22;
                  var23 = var23 * var23 * (3.0 - 2.0 * var23);
                  var25 = var25 * var25 * (3.0 - 2.0 * var25);
                  double var27 = (double)var1[(var22 & 63) * 64 + (var21 & 63)];
                  double var29 = (double)var1[(var22 & 63) * 64 + (var21 + 1 & 63)];
                  double var31 = (double)var1[(var22 + 1 & 63) * 64 + (var21 & 63)];
                  double var33 = (double)var1[(var22 + 1 & 63) * 64 + (var21 + 1 & 63)];
                  var10 += var12 * (var27 + (var29 - var27) * var23 + (var31 - var27) * var25 + (var27 - var29 - var31 + var33) * var23 * var25);
                  var12 *= 0.5;
                  var14 *= 2.0;
               }

               double var35 = var8 + (0.5 - var10) * 0.75;
               double var18 = (var35 - 0.25) / 0.7;
               var18 = var18 < 0.0 ? 0.0 : (var18 > 1.0 ? 1.0 : var18);
               double var20 = (0.97 - var8) / 0.22;
               var20 = var20 > 1.0 ? 1.0 : var20;
               double var38 = (1.0 - var18 * var18 * (3.0 - 2.0 * var18)) * (0.55 + 0.45 * var10) * var20 * var20 * (3.0 - 2.0 * var20);
               if (!(var38 <= 0.0)) {
                  var38 = var38 > 1.0 ? 1.0 : var38;
                  double var24 = 0.86 + 0.14 * (0.5 - 0.5 * var6);
                  int var26 = (var2 * (184796142 ^ 184796014) + var3) * 4;
                  var0[var26] = (float)(var24 * var38);
                  var0[var26 + 1] = (float)(var24 * var38);
                  var0[var26 + 2] = (float)(var24 * var38);
                  var0[var26 + 3] = (float)var38;
               }
            }
         }
      }
   }

   private static void j(int var0, float[] var1, float[] var2, int[] var3, int[] var4) {

      for (int var5 = 0; var5 < 4; var5++) {
         int var6 = (1685193188 ^ 1685193060) >> var5;
         int var7 = var6 * var6;
         int var8 = 7 - var5;
         int var9 = var6 - 1;
         int var10;
         int var11;
         if (var0 == 8) {
            var10 = var5 == 0
               ? -330416728 ^ -330416984
               : (var5 == 1 ? 801147816 ^ 801147432 : (var5 == 2 ? 1851409958 ^ 1851410406 : -1091617864 ^ -1091618216));
            var11 = 2002462382 ^ 2002462510;
         } else if (var0 == 9) {
            var10 = var5 == 3 ? -1988724765 ^ -1988725245 : 2056662152 ^ 2056662344;
            var11 = var5 <= 1 ? 1527248782 ^ 1527248526 : 1194494630 ^ 1194494950;
         } else if (var5 == 0) {
            var10 = (var0 & 3) * (1549957298 ^ 1549957170);
            var11 = (var0 >> 2) * (-1918991755 ^ -1918991627);
         } else if (var5 == 1) {
            var10 = (var0 & 3) * 64;
            var11 = (785816299 ^ 785816555) + (var0 >> 2) * 64;
         } else if (var5 == 2) {
            var10 = (1634009795 ^ 1634010051) + (var0 & 3) * 32;
            var11 = (-1905861027 ^ -1905860771) + (var0 >> 2) * 32;
         } else {
            var10 = (201916250 ^ 201916122) + (var0 & 3) * 16;
            var11 = (1530886797 ^ 1530887053) + (var0 >> 2) * 16;
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
                  int var61 = 314641984 ^ 1832841663;
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

         for (int var33 = 0; var33 < var6 && (var0 != 9 || var5 != 0); var33++) {
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
                  var54 = (var58 > (-2095080278 ^ -2095080363) ? 766341386 ^ 766341621 : var58) << 16
                     | (var60 > (-1558706943 ^ -1558706690) ? -531598332 ^ -531598085 : var60) << 8
                     | (var62 > (-1501514858 ^ -1501514903) ? -1369603608 ^ -1369603817 : var62);
               }

               var4[(var11 + var33) * (101747878 ^ 101748390) + var10 + var38] = (var51 > (-1065362987 ^ -1065363158) ? -203821560 ^ -203821321 : var51) << 24
                  | var54;
            }
         }
      }
   }
}
