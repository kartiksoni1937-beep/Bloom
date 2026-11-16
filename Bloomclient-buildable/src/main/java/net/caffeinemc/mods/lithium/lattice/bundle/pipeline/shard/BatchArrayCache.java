package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import java.util.Arrays;
import java.util.Random;

public final class BatchArrayCache {
   public static final int W = 1024;
   public static final int H = 2048;
   public static final int NSPR = 34;
   public static final int SPR_PETAL = 20;
   public static final int SPR_DROP = 32;
   public static final int SPR_DOT = 33;
   public static final int L0_Y = 1024;
   public static final int L1_Y = 1664;
   public static final int L2_Y = 1856;
   public static final int L3_Y = 1920;
   public static final int BL_Y = 1936;
   public static final float SPR_FLOWER_R = 50.0F;
   public static final float SPR_PETAL_L = 104.0F;
   public static volatile float[] am;
   public static final int AS = 11;
   public static final int A_COMP = 0;
   public static final int A_X = 1;
   public static final int A_Y = 2;
   public static final int A_R = 3;
   public static final int A_PHI = 4;
   public static final int A_TAU = 5;
   public static final int A_PALE = 6;
   public static final int A_SEED = 7;
   public static final int A_TR = 8;
   public static final int A_TG = 9;
   public static final int A_TB = 10;
   private static final int an = 1024;
   private static final int ao = 512;
   private static final int ap = 524288;
   private static final int aq = 16;
   private static final int ar = 64;
   private static final int as = 32;
   private static final int at = 1024;
   private static final int au = 0;
   private static final int av = 1;
   private static final int aw = 2;
   private static final int ax = 3;
   private static final int ay = 4;
   private static final int az = 5;
   private static final int ba = 6;
   private static final int bb = 7;
   private static final int bc = 8;
   private static final int bd = 9;
   private static final int be = 10;
   private static final int bf = 11;
   private static final int bg = 12;
   private static final int bh = 13;
   private static final int bi = 14;
   private static final int bj = 15;
   private static final int bk = 20000;
   private static final int bl = 0;
   private static final int bm = 1;
   private static final int bn = 2;
   private static final int bo = 3;
   private static final int bp = 4;
   private static final int bq = 5;
   private static final int br = 5000;
   private static final int bs = 0;
   private static final int bt = 1;
   private static final int bu = 2;
   private static final int bv = 3;
   private static final int bw = 4;
   private static final int bx = 5;
   private static final int by = 6;
   private static final int bz = 7;
   private static final int ca = 8;
   private static final int cb = 9;
   private static final int cc = 10;
   private static final int cd = 11;
   private static final int ce = 12;
   private static final int cf = 13;
   private static final int cg = 14;
   private static final int ch = 15;
   private static final int ci = 16;
   private static final int cj = 17;
   private static final int ck = 18;
   private static final int cl = 19;
   private static final int cm = 20;
   private static final int cn = 21;
   private static final int co = 22;
   private static final int cp = 23;
   private static final int cq = 3000;
   private static final int cr = 6;
   private static final int cs = 18;
   private static final int ct = 0;
   private static final int cu = 1;
   private static final int cv = 2;
   private static final int cw = 0;
   private static final int cx = 1;
   private static final int cy = 2;
   private static final int cz = 3;
   private static final int da = 0;
   private static final int db = 1;
   private static final int dc = 2;
   private static final int dd = 3;
   private static final int de = 4;
   private static final int df = 5;
   private static final int dg = 6;
   private static final int dh = 7;
   private static final int di = 8;
   private static final int dj = 9;
   private static final int dk = 10;
   private static final int dl = 11;
   private static final int dm = 12;
   private static final int dn = 13;
   private static final int _kwren_do= 14;
   private static final int dp = 15;
   private static final int dq = 16;
   private static final int dr = 17;
   private static final int ds = 18;
   private static final int dt = 19;
   private static final int du = 20;
   private static final int dv = 21;
   private static final int dw = 22;
   private static final int dx = 110;
   private static final int dy = 10;
   private static final int dz = 24;
   private static final int ea = 350;
   private static final int eb = 370;
   private static final int ec = 382;
   private static final int ed = 391;
   private static final int ee = 0;
   private static final int ef = 3;
   private static final int eg = 6;
   private static final int eh = 9;
   private static final int ei = 10;
   private static final int ej = 13;
   private static final int ek = 14;
   private static final int el = 15;
   private static final int em = 16;
   private static final int en = 17;
   private static final int eo = 160;
   private static final double ep = -0.3;
   private static final double eq = -0.78;
   private static final double er = 0.55;
   private static final double es;
   private static final double et;
   private static final double eu;
   private static final double ev = 1.1;
   private static final double ew = 0.07;
   private static final double ex = 16.5;
   private static final double[] ey = new double[]{30.0, 22.0, 16.0, 10.0, 8.0};
   private static final double[] ez = new double[]{0.66, 0.58, 0.44, 0.24, 0.0};
   private static final double[] fa = new double[]{0.03, 0.12, 0.6, 0.85, 0.9};
   private static final double[] fb = new double[]{80.0, 44.0, 22.0, 10.0, 0.0};
   private static final double[] fc = new double[]{200.0, 120.0, 60.0, 26.0, 0.0};
   private static final double[] fd = new double[]{0.0, 6.5, 3.4, 2.0, 1.45};
   private static int fe = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   private BatchArrayCache() {
   }

   public static int[] a(int[] var0) {

      int[] var1 = new int[2097152];
      float[] var2 = new float[2097152];
      int[] var3 = new int[524288];
      byte[] var4 = new byte[524288];
      byte[] var5 = new byte[524288];
      float[] var6 = al();
      double[] var7 = new double[300000];
      double[] var8 = new double[25000];
      double[] var9 = new double[69000];
      double[] var10 = new double[391];
      float[] var11 = new float[102400];
      double[][] var12 = new double[20][1024];
      int[] var13 = new int[4];
      int[] var14 = new int[3000];
      float[] var15 = new float[66000];
      double[] var16 = new double[3];
      int var17 = 0;

      for (int var18 = 0; var18 < 2; var18++) {
         if (var18 > 0) {
            Arrays.fill(var2, 0.0F);
            Arrays.fill(var13, 0);
         }

         if (var18 == 0) {
            b(var7, var8, var9, var13, var12);
         } else {
            c(var7, var8, var9, var13, var12);
         }

         q(var9, var13[2], var6);
         int var19 = p(var9, var13[2], var14);

         for (int var20 = 0; var20 < var19; var20++) {
            int var21 = var14[var20] * 23;
            if (var9[var21 + 11] == 0.0) {
               ac(var2, var9, var21);
               v(var2, var11, var9, var21, var10, var6);
            }
         }

         t(var2, var7, var13[0], var8, var6);

         for (int var23 = 0; var23 < var19; var23++) {
            int var24 = var14[var23] * 23;
            if (var9[var24 + 11] != 0.0) {
               ac(var2, var9, var24);
               if (var9[var24 + 21] == 0.0) {
                  v(var2, var11, var9, var24, var10, var6);
               } else {
                  int var22 = var17++ * 11;
                  var15[var22 + 0] = (float)var18;
                  var15[var22 + 1] = (float)var9[var24 + 0];
                  var15[var22 + 2] = (float)var9[var24 + 1];
                  var15[var22 + 3] = (float)var9[var24 + 2];
                  var15[var22 + 4] = (float)var9[var24 + 5];
                  var15[var22 + 5] = (float)var9[var24 + 4];
                  var15[var22 + 6] = (float)var9[var24 + 8];
                  var15[var22 + 7] = (float)((long)var9[var24 + 19] & 1023L);
                  s(var9[var24 + 22], var16);
                  var15[var22 + 8] = (float)var16[0];
                  var15[var22 + 9] = (float)var16[1];
                  var15[var22 + 10] = (float)var16[2];
               }
            }
         }

         ak(var2, var3, var4, var5, var1, var18 * (-1933600865 ^ -1933601377));
      }

      ad(var1, var2, var11, var10, var6);
      am = Arrays.copyOf(var15, var17 * 11);
      return var1;
   }

   private static void b(double[] var0, double[] var1, double[] var2, int[] var3, double[][] var4) {

      Random var5 = new Random(1369944225L);
      double[] var6 = var4[0];
      double[] var7 = var4[1];
      double[] var8 = var4[2];
      double[] var9 = new double[]{
         -80.0,
         374.0,
         28.0,
         20.0,
         352.0,
         26.0,
         110.0,
         326.0,
         23.0,
         200.0,
         300.0,
         20.0,
         285.0,
         280.0,
         17.0,
         370.0,
         262.0,
         14.5,
         460.0,
         240.0,
         12.0,
         545.0,
         224.0,
         10.0,
         630.0,
         210.0,
         8.0,
         712.0,
         192.0,
         6.2,
         785.0,
         178.0,
         4.6,
         840.0,
         170.0,
         3.2,
         878.0,
         166.0,
         2.2
      };
      int var10 = f(var9, var9.length / 3, 4.0, 4.0, 6.0, var5, var6, var7, var8, var4[18], var4[19]);
      h(var0, var1, var3, var6, var7, var8, var10, 0.0, 0.0, 0.0, 1.0, 0.0);
      double var11 = 16.5;
      double[] var13 = new double[]{935.0, 0.12, 0.3};
      int var14 = g(
         var0,
         var1,
         var3,
         var4,
         1,
         d(var6, var10, 105.0),
         10.0,
         new double[]{122.0, 262.0, 8.4, 114.0, 200.0, 6.4, 128.0, 142.0, 4.6, 120.0, 96.0, 3.2, 128.0, 58.0, 2.1},
         var5
      );
      k(var0, var1, var2, var3, var4, 1, var14, 14.0, 0.004, var11, var13, var5);
      n(var2, var3, var4[3][var14 - 1], var4[4][var14 - 1], e(var4[3], var4[4], var14), var11, var13, var5);
      var14 = g(
         var0,
         var1,
         var3,
         var4,
         1,
         d(var6, var10, 282.0),
         9.0,
         new double[]{312.0, 214.0, 7.6, 346.0, 160.0, 5.8, 374.0, 114.0, 4.2, 402.0, 72.0, 2.8, 420.0, 48.0, 1.9},
         var5
      );
      k(var0, var1, var2, var3, var4, 1, var14, 14.0, 0.004, var11, var13, var5);
      n(var2, var3, var4[3][var14 - 1], var4[4][var14 - 1], e(var4[3], var4[4], var14), var11, var13, var5);
      var14 = g(
         var0,
         var1,
         var3,
         var4,
         1,
         d(var6, var10, 228.0),
         9.2,
         new double[]{285.0, 330.0, 7.8, 350.0, 368.0, 6.2, 420.0, 392.0, 4.6, 490.0, 404.0, 3.2, 545.0, 410.0, 2.1},
         var5
      );
      k(var0, var1, var2, var3, var4, 1, var14, 14.0, -0.001, var11, var13, var5);
      n(var2, var3, var4[3][var14 - 1], var4[4][var14 - 1], e(var4[3], var4[4], var14), var11, var13, var5);
      var14 = g(
         var0, var1, var3, var4, 1, d(var6, var10, 520.0), 6.6, new double[]{542.0, 170.0, 5.6, 566.0, 124.0, 4.1, 586.0, 86.0, 2.8, 598.0, 56.0, 1.9}, var5
      );
      k(var0, var1, var2, var3, var4, 1, var14, 12.0, 0.004, var11, var13, var5);
      n(var2, var3, var4[3][var14 - 1], var4[4][var14 - 1], e(var4[3], var4[4], var14), var11, var13, var5);
      var14 = g(
         var0, var1, var3, var4, 1, d(var6, var10, 640.0), 5.4, new double[]{690.0, 244.0, 4.8, 740.0, 280.0, 3.6, 790.0, 300.0, 2.5, 830.0, 310.0, 1.7}, var5
      );
      k(var0, var1, var2, var3, var4, 1, var14, 12.0, 0.0, var11, var13, var5);
      n(var2, var3, var4[3][var14 - 1], var4[4][var14 - 1], e(var4[3], var4[4], var14), var11, var13, var5);
      k(var0, var1, var2, var3, var4, 0, var10, 150.0, 0.002, var11, var13, var5);
      n(var2, var3, var6[var10 - 1], var7[var10 - 1], e(var6, var7, var10), var11, var13, var5);
   }

   private static void c(double[] var0, double[] var1, double[] var2, int[] var3, double[][] var4) {

      Random var5 = new Random(739245797L);
      double[] var6 = var4[0];
      double[] var7 = var4[1];
      double[] var8 = var4[2];
      double[] var9 = new double[]{
         -72.0,
         116.0,
         27.0,
         10.0,
         114.0,
         25.0,
         92.0,
         122.0,
         22.5,
         172.0,
         138.0,
         20.0,
         250.0,
         162.0,
         17.0,
         328.0,
         192.0,
         14.5,
         400.0,
         228.0,
         12.0,
         464.0,
         266.0,
         9.8,
         518.0,
         306.0,
         7.8,
         562.0,
         346.0,
         5.8,
         596.0,
         386.0,
         4.2,
         620.0,
         422.0,
         3.0,
         636.0,
         448.0,
         2.0
      };
      int var10 = f(var9, var9.length / 3, 4.0, 4.0, 6.0, var5, var6, var7, var8, var4[18], var4[19]);
      h(var0, var1, var3, var6, var7, var8, var10, 0.0, 0.0, 0.0, 1.0, 0.0);
      double var11 = 16.5;
      double[] var13 = new double[]{960.0, 0.12, 0.3};
      int var14 = g(
         var0,
         var1,
         var3,
         var4,
         1,
         d(var6, var10, 205.0),
         9.0,
         new double[]{262.0, 116.0, 7.6, 322.0, 84.0, 6.0, 386.0, 62.0, 4.4, 448.0, 50.0, 3.0, 500.0, 44.0, 2.0},
         var5
      );
      k(var0, var1, var2, var3, var4, 1, var14, 14.0, 0.003, var11, var13, var5);
      n(var2, var3, var4[3][var14 - 1], var4[4][var14 - 1], e(var4[3], var4[4], var14), var11, var13, var5);
      var14 = g(
         var0,
         var1,
         var3,
         var4,
         1,
         d(var6, var10, 120.0),
         9.2,
         new double[]{156.0, 176.0, 8.0, 200.0, 236.0, 6.4, 236.0, 296.0, 4.9, 258.0, 352.0, 3.6, 270.0, 400.0, 2.5, 276.0, 436.0, 1.8},
         var5
      );
      k(var0, var1, var2, var3, var4, 1, var14, 14.0, -0.003, var11, var13, var5);
      n(var2, var3, var4[3][var14 - 1], var4[4][var14 - 1], e(var4[3], var4[4], var14), var11, var13, var5);
      var14 = g(
         var0,
         var1,
         var3,
         var4,
         1,
         d(var6, var10, 350.0),
         7.4,
         new double[]{366.0, 256.0, 6.2, 378.0, 312.0, 4.7, 384.0, 362.0, 3.4, 386.0, 404.0, 2.3, 384.0, 432.0, 1.6},
         var5
      );
      k(var0, var1, var2, var3, var4, 1, var14, 12.0, -0.003, var11, var13, var5);
      n(var2, var3, var4[3][var14 - 1], var4[4][var14 - 1], e(var4[3], var4[4], var14), var11, var13, var5);
      var14 = g(
         var0, var1, var3, var4, 1, d(var6, var10, 478.0), 6.2, new double[]{540.0, 262.0, 5.2, 606.0, 250.0, 3.9, 672.0, 250.0, 2.8, 732.0, 262.0, 1.9}, var5
      );
      k(var0, var1, var2, var3, var4, 1, var14, 12.0, 0.001, var11, var13, var5);
      n(var2, var3, var4[3][var14 - 1], var4[4][var14 - 1], e(var4[3], var4[4], var14), var11, var13, var5);
      k(var0, var1, var2, var3, var4, 0, var10, 140.0, 0.0, var11, var13, var5);
      n(var2, var3, var6[var10 - 1], var7[var10 - 1], e(var6, var7, var10), var11, var13, var5);
   }

   private static int d(double[] var0, int var1, double var2) {

      for (int var4 = 0; var4 < var1; var4++) {
         if (var0[var4] >= var2) {
            return var4;
         }
      }

      return var1 - 1;
   }

   private static double e(double[] var0, double[] var1, int var2) {

      int var3 = Math.max(0, var2 - 4);
      return Math.atan2(var1[var2 - 1] - var1[var3], var0[var2 - 1] - var0[var3]);
   }

   private static int f(
      double[] var0,
      int var1,
      double var2,
      double var4,
      double var6,
      Random var8,
      double[] var9,
      double[] var10,
      double[] var11,
      double[] var12,
      double[] var13
   ) {

      int var14 = 1;
      var9[0] = var0[0];
      var10[0] = var0[1];
      var11[0] = var0[2];
      double var15 = var0[0];
      double var17 = var0[1];
      double var19 = 0.0;

      for (int var21 = 0; var21 < var1 - 1; var21++) {
         int var22 = (var21 > 0 ? var21 - 1 : 0) * 3;
         int var23 = var21 * 3;
         int var24 = (var21 + 1) * 3;
         int var25 = (var21 + 2 < var1 ? var21 + 2 : var1 - 1) * 3;

         for (int var26 = 1; var26 <= 48; var26++) {
            double var27 = (double)var26 / 48.0;
            double var29 = var27 * var27;
            double var31 = var29 * var27;
            double var33 = -0.5 * var31 + var29 - 0.5 * var27;
            double var35 = 1.5 * var31 - 2.5 * var29 + 1.0;
            double var37 = -1.5 * var31 + 2.0 * var29 + 0.5 * var27;
            double var39 = 0.5 * var31 - 0.5 * var29;
            double var41 = var33 * var0[var22] + var35 * var0[var23] + var37 * var0[var24] + var39 * var0[var25];
            double var43 = var33 * var0[var22 + 1] + var35 * var0[var23 + 1] + var37 * var0[var24 + 1] + var39 * var0[var25 + 1];
            double var45 = var33 * var0[var22 + 2] + var35 * var0[var23 + 2] + var37 * var0[var24 + 2] + var39 * var0[var25 + 2];
            double var47 = var41 - var15;
            double var49 = var43 - var17;
            var19 += Math.sqrt(var47 * var47 + var49 * var49);
            var15 = var41;
            var17 = var43;
            if ((var19 >= var2 || var21 == var1 - 2 && var26 == 48) && var14 < (2135520322 ^ 2135519298)) {
               var9[var14] = var41;
               var10[var14] = var43;
               var11[var14] = Math.max(1.1, var45);
               var14++;
               var19 = 0.0;
            }
         }
      }

      if (var14 > 2) {
         double var56 = 0.024 + 0.01 * var8.nextDouble();
         double var57 = 0.058 + 0.02 * var8.nextDouble();
         double var58 = var8.nextDouble() * 6.2832;
         double var59 = var8.nextDouble() * 6.2832;
         double var60 = 0.0;
         double var61 = 0.0;
         double var62 = 30.0 + 40.0 * var8.nextDouble();
         double var63 = 0.0;
         double var64 = var8.nextBoolean() ? 1.0 : -1.0;
         double var65 = var6 * var64 * (0.5 + 0.5 * var8.nextDouble());

         for (int var66 = 0; var66 < var14; var66++) {
            int var42 = var66 > 0 ? var66 - 1 : 0;
            int var67 = var66 < var14 - 1 ? var66 + 1 : var14 - 1;
            double var44 = var9[var67] - var9[var42];
            double var46 = var10[var67] - var10[var42];
            double var48 = Math.sqrt(var44 * var44 + var46 * var46);
            if (var66 > 0) {
               double var50 = var9[var66] - var9[var66 - 1];
               double var52 = var10[var66] - var10[var66 - 1];
               var60 += Math.sqrt(var50 * var50 + var52 * var52);
            }

            while (var60 > var62) {
               var61 = var62;
               var63 = var65;
               var62 += 45.0 + 40.0 * var8.nextDouble();
               var64 = -var64;
               var65 = var6 * var64 * (0.5 + 0.5 * var8.nextDouble());
            }

            double var68 = var63 + (var65 - var63) * (var60 - var61) / (var62 - var61);
            double var69 = Math.min(1.0, var60 / 40.0);
            double var54 = var48 > 1.0E-9
               ? var69 * (var4 * (0.65 * Math.sin(var60 * var56 + var58) + 0.35 * Math.sin(var60 * var57 + var59)) + var68) / var48
               : 0.0;
            var12[var66] = var9[var66] - var46 * var54;
            var13[var66] = var10[var66] + var44 * var54;
         }

         System.arraycopy(var12, 0, var9, 0, var14);
         System.arraycopy(var13, 0, var10, 0, var14);
      }

      return var14;
   }

   private static int g(double[] var0, double[] var1, int[] var2, double[][] var3, int var4, int var5, double var6, double[] var8, Random var9) {

      double[] var10 = var3[(var4 - 1) * 3];
      double[] var11 = var3[(var4 - 1) * 3 + 1];
      double[] var12 = var3[(var4 - 1) * 3 + 2];
      double[] var13 = new double[var8.length + 3];
      var13[0] = var10[var5];
      var13[1] = var11[var5];
      var13[2] = var6;
      System.arraycopy(var8, 0, var13, 3, var8.length);
      double[] var14 = var3[var4 * 3];
      double[] var15 = var3[var4 * 3 + 1];
      double[] var16 = var3[var4 * 3 + 2];
      int var17 = f(var13, var13.length / 3, 3.5, 3.0, 5.0, var9, var14, var15, var16, var3[18], var3[19]);
      h(var0, var1, var2, var14, var15, var16, var17, var10[var5], var11[var5], Math.min(1.1 * var6, 7.0), 2.2 * var12[var5] + 6.0, 0.25);
      return var17;
   }

   private static int h(
      double[] var0,
      double[] var1,
      int[] var2,
      double[] var3,
      double[] var4,
      double[] var5,
      int var6,
      double var7,
      double var9,
      double var11,
      double var13,
      double var15
   ) {

      int var17 = var2[1];
      if (var17 >= (518186683 ^ 518190387)) {
         return -1;
      } else {
         var2[1]++;
         int var18 = var17 * 5;
         var1[var18 + 0] = var7;
         var1[var18 + 1] = var9;
         var1[var18 + 2] = var11;
         var1[var18 + 3] = var13;
         var1[var18 + 4] = var15;
         double var19 = 0.0;

         for (int var21 = 0; var21 + 1 < var6; var21++) {
            int var22 = var2[0];
            if (var22 >= (1841946640 ^ 1841933872)) {
               break;
            }

            double var23 = var3[var21 + 1] - var3[var21];
            double var25 = var4[var21 + 1] - var4[var21];
            double var27 = var23 * var23 + var25 * var25;
            if (!(var27 < 1.0E-6)) {
               double var29 = Math.sqrt(var27);
               int var31 = var22 * 15;
               var0[var31 + 0] = var3[var21];
               var0[var31 + 1] = var4[var21];
               var0[var31 + 2] = var23;
               var0[var31 + 3] = var25;
               var0[var31 + 4] = 1.0 / var27;
               var0[var31 + 5] = 1.0 / var29;
               var0[var31 + 6] = var5[var21];
               var0[var31 + 7] = var5[var21 + 1];
               var0[var31 + 8] = var19;
               var0[var31 + 9] = var29;
               var0[var31 + 10] = (double)var17;
               double var32 = Math.max(var5[var21], var5[var21 + 1]) + 8.0;
               var0[var31 + 11] = Math.min(var3[var21], var3[var21 + 1]) - var32;
               var0[var31 + 12] = Math.min(var4[var21], var4[var21 + 1]) - var32;
               var0[var31 + 13] = Math.max(var3[var21], var3[var21 + 1]) + var32;
               var0[var31 + 14] = Math.max(var4[var21], var4[var21 + 1]) + var32;
               var19 += var29;
               var2[0]++;
            }
         }

         return var17;
      }
   }

   private static int i(
      double var0, double var2, double var4, double var6, double var8, double var10, double var12, Random var14, double[] var15, double[] var16, double[] var17
   ) {

      int var18 = 1;
      var15[0] = var0;
      var16[0] = var2;
      var17[0] = var8;
      double var19 = 2.5;
      double var21 = 0.0;
      double var23 = Math.max(7.0, Math.min(32.0, var6 * 0.3));
      double var25 = var23 * (0.6 + 0.8 * var14.nextDouble());
      double var27 = var14.nextBoolean() ? 1.0 : -1.0;

      for (double var29 = 0.0; var21 < var6 - 1.0E-6 && var18 < (1365938814 ^ 1365939838); var18++) {
         double var31 = Math.min(var19, var6 - var21);
         var21 += var31;
         var29 = var29 * 0.9 + (var14.nextDouble() - 0.5) * 0.025;
         var4 += var29;
         double var33 = (-Math.PI / 2) - var4;
         var33 = Math.atan2(Math.sin(var33), Math.cos(var33));
         var4 += var12 * var31 * var33;
         if (var21 >= var25) {
            var4 += var27 * (0.1 + 0.24 * var14.nextDouble());
            var27 = var14.nextDouble() < 0.8 ? -var27 : var27;
            var25 += var23 * (0.6 + 0.8 * var14.nextDouble());
         }

         var0 += Math.cos(var4) * var31;
         var2 += Math.sin(var4) * var31;
         double var35 = var21 / var6;
         var15[var18] = var0;
         var16[var18] = var2;
         var17[var18] = var10 + (var8 - var10) * Math.pow(1.0 - var35, 1.1);
      }

      return var18;
   }

   private static int j(double[] var0, double[] var1, int var2, double var3, double var5) {
      int var7 = 0;
      byte var8 = 0;

      while (true) {
         label32: {
            switch (var8) {
               case 0:
               default:
                  if (fe != 0) {
                     System.nanoTime();
                     var8 = 1;
                     continue;
                  }
               case 1:
                  break label32;
               case 2:
                  if (var7 < var2) {
                     if (!(var0[var7] < var3) && !(var0[var7] > var5) && !(var1[var7] < var3)) {
                        if (var1[var7] > 512.0 - var3) {
                           var8 = 3;
                        } else {
                           var8 = 4;
                        }
                        continue;
                     }
                     break;
                  }
               case 5:
                  return var2;
               case 3:
                  break;
               case 4:
                  var7++;
                  var8 = 2;
                  continue;
            }

            return var7;
         }

         var7 = 1;
         var8 = 2;
      }
   }

   private static void k(
      double[] var0,
      double[] var1,
      double[] var2,
      int[] var3,
      double[][] var4,
      int var5,
      int var6,
      double var7,
      double var9,
      double var11,
      double[] var13,
      Random var14
   ) {

      double[] var15 = var4[var5 * 3];
      double[] var16 = var4[var5 * 3 + 1];
      double[] var17 = var4[var5 * 3 + 2];
      double var18 = 0.0;

      for (int var20 = 0; var20 + 1 < var6; var20++) {
         double var21 = var15[var20 + 1] - var15[var20];
         double var23 = var16[var20 + 1] - var16[var20];
         var18 += Math.sqrt(var21 * var21 + var23 * var23);
      }

      double var55 = ey[var5];
      double var22 = 0.0;
      double var24 = var7 + var55 * var14.nextDouble();
      double var26 = var14.nextBoolean() ? 1.0 : -1.0;

      for (int var28 = 0; var28 + 1 < var6; var28++) {
         double var29 = var15[var28 + 1] - var15[var28];
         double var31 = var16[var28 + 1] - var16[var28];
         double var33 = Math.sqrt(var29 * var29 + var31 * var31);
         if (!(var33 < 1.0E-9)) {
            for (; var24 < var22 + var33; var24 += var55 * (0.6 + 0.8 * var14.nextDouble())) {
               double var35 = (var24 - var22) / var33;
               double var37 = var15[var28] + var29 * var35;
               double var39 = var16[var28] + var31 * var35;
               double var41 = var17[var28] + (var17[var28 + 1] - var17[var28]) * var35;
               double var43 = Math.atan2(var31, var29);
               double var45 = var18 - var24;
               if (var14.nextDouble() < 0.7) {
                  var26 = -var26;
               }

               double var47 = var14.nextDouble();
               double var49 = fa[var5];
               if (var5 >= 2 && var18 > 1.0) {
                  double var51 = (var24 / var18 - 0.2) / 0.45;
                  var49 *= var51 < 0.12 ? 0.12 : (var51 > 1.0 ? 1.0 : var51);
               }

               if (var47 < ez[var5] && var45 > 10.0) {
                  double var56 = fb[var5] + (fc[var5] - fb[var5]) * var14.nextDouble();
                  var56 = Math.min(var56, 0.7 * var45 + 0.3 * var56);
                  double var53 = var43 + var26 * (0.38 + 0.55 * var14.nextDouble());
                  l(var0, var1, var2, var3, var4, var5 + 1, var37, var39, var41, var53, var56, var9, var11, var13, var14);
               } else if (var47 < ez[var5] + var49) {
                  m(var0, var1, var2, var3, var4, var5 + 1, var37, var39, var41, var43, var26, var11, var13, var14);
               }
            }

            var22 += var33;
         }
      }
   }

   private static void l(
      double[] var0,
      double[] var1,
      double[] var2,
      int[] var3,
      double[][] var4,
      int var5,
      double var6,
      double var8,
      double var10,
      double var12,
      double var14,
      double var16,
      double var18,
      double[] var20,
      Random var21
   ) {

      double[] var22 = var4[var5 * 3];
      double[] var23 = var4[var5 * 3 + 1];
      double[] var24 = var4[var5 * 3 + 2];
      double var25 = Math.max(1.2, Math.min(var10 * 0.7, fd[var5]));
      int var27 = i(var6, var8, var12, var14, var25, var5 >= 3 ? 0.85 : 1.05, var16 - 0.0012 * (double)(var5 - 1), var21, var22, var23, var24);
      var27 = j(var22, var23, var27, 12.0, var20[0] - 8.0);
      double var28 = 0.0;

      for (int var30 = 1; var30 < var27; var30++) {
         double var31 = var22[var30] - var22[var30 - 1];
         double var33 = var23[var30] - var23[var30 - 1];
         var28 += Math.sqrt(var31 * var31 + var33 * var33);
      }

      if (var27 >= 3 && !(var28 < var10 + 5.0)) {
         if (var5 < 2 && !(var25 < 3.0) && !(var28 < 60.0)
            || n(var2, var3, var22[var27 - 1], var23[var27 - 1], e(var22, var23, var27), var18, var20, var21) != 0
            || !(var28 < 45.0)) {
            h(var0, var1, var3, var22, var23, var24, var27, var6, var8, 1.2 * var25, 2.2 * var10 + 5.0, var5 >= 3 ? 1.0 : (var5 == 2 ? 0.7 : 0.35));
            k(var0, var1, var2, var3, var4, var5, var27, var10 + 3.0, var16, var18, var20, var21);
         }
      }
   }

   private static void m(
      double[] var0,
      double[] var1,
      double[] var2,
      int[] var3,
      double[][] var4,
      int var5,
      double var6,
      double var8,
      double var10,
      double var12,
      double var14,
      double var16,
      double[] var18,
      Random var19
   ) {

      double[] var20 = var4[var5 * 3];
      double[] var21 = var4[var5 * 3 + 1];
      double[] var22 = var4[var5 * 3 + 2];
      double var23 = var12 + var14 * (0.7 + 0.7 * var19.nextDouble());
      double var25 = var10 + 2.0 + 4.0 * var19.nextDouble();
      double var27 = Math.max(1.1, Math.min(2.6, 0.5 * var10));
      double var29 = Math.cos(var23);
      double var31 = Math.sin(var23);
      var20[0] = var6;
      var21[0] = var8;
      var22[0] = var27;
      var20[1] = var6 + var29 * var25 * 0.5;
      var21[1] = var8 + var31 * var25 * 0.5;
      var22[1] = var27 * 0.9 + 0.1;
      var20[2] = var6 + var29 * var25;
      var21[2] = var8 + var31 * var25;
      var22[2] = var27 * 0.75 + 0.3;
      if (!(var20[2] < 12.0) && !(var20[2] > var18[0] - 8.0) && !(var21[2] < 12.0) && !(var21[2] > 500.0)) {
         int var33 = 2 + (var19.nextDouble() < 0.75 ? 1 : 0) + (var19.nextDouble() < 0.45 ? 1 : 0) + (var19.nextDouble() < 0.15 ? 1 : 0);
         int var34 = var19.nextDouble() < var18[1] * 0.4 ? 1 : 0;
         int var35 = var3[2];
         o(var2, var3, var20[2], var21[2], var23, var33, var34, var16, var18, var19);
         if (var3[2] > var35) {
            h(var0, var1, var3, var20, var21, var22, 3, var6, var8, 1.3 * var27, 2.0 * var10 + 4.0, 0.6);
         }
      }
   }

   private static int n(double[] var0, int[] var1, double var2, double var4, double var6, double var8, double[] var10, Random var11) {

      int var12 = var1[2];
      if (var11.nextDouble() < 0.06) {
         o(var0, var1, var2, var4, var6, 0, 1 + (var11.nextDouble() < 0.4 ? 1 : 0), var8, var10, var11);
      } else {
         int var13 = 4 + (var11.nextDouble() < 0.75 ? 1 : 0) + (var11.nextDouble() < 0.5 ? 1 : 0) + (var11.nextDouble() < 0.3 ? 1 : 0);
         o(var0, var1, var2, var4, var6, var13, var11.nextDouble() < var10[1] ? 1 : 0, var8, var10, var11);
      }

      return var1[2] - var12;
   }

   private static void o(double[] var0, int[] var1, double var2, double var4, double var6, int var8, int var9, double var10, double[] var12, Random var13) {

      Object var14 = var1[3]++;

      for (int var15 = 0; var15 < var8 + var9; var15++) {
         boolean var16 = var15 >= var8;
         if (var1[2] >= (1294860731 ^ 1294862851)) {
            return;
         }

         int var17 = var1[2] * 23;

         for (int var18 = 0; var18 < 16; var18++) {
            double var19 = (var16 ? 1.4 : 2.3) + 0.12 * (double)var18;
            double var21 = var6 + (var13.nextDouble() - 0.5) * var19;
            double var28 = 0.0;
            double var30 = 0.0;
            double var23;
            double var25;
            byte var27;
            if (var16) {
               var27 = 2;
               var23 = var10 * (0.4 + 0.12 * var13.nextDouble());
               var25 = var23 * (0.7 + 0.9 * var13.nextDouble()) + 3.0;
            } else {
               var23 = var10 * (0.8 + 0.4 * var13.nextDouble()) * (var13.nextDouble() < 0.15 ? 0.74 : 1.0);
               double var32 = var13.nextDouble();
               if (var32 < 0.52) {
                  var27 = 0;
                  var28 = 0.04 + 0.3 * var13.nextDouble();
                  var30 = 0.12 + 0.14 * var13.nextDouble();
               } else if (var32 < 0.87) {
                  var27 = 0;
                  var28 = 0.5 + 0.35 * var13.nextDouble();
                  var30 = 0.2 + 0.16 * var13.nextDouble();
               } else {
                  var27 = 1;
                  var23 *= 0.78;
                  var28 = 1.0 + 0.25 * var13.nextDouble();
                  var30 = 0.8 + 0.25 * var13.nextDouble();
               }

               var25 = var23 * (0.25 + 0.5 * var13.nextDouble()) + 2.0;
            }

            double var69 = Math.cos(var21);
            double var34 = Math.sin(var21);
            double var36 = var2 + var69 * var25;
            double var38 = var4 + var34 * var25;
            double var40 = var16 ? var36 + var69 * var23 : var36;
            double var42 = var16 ? var38 + var34 * var23 : var38;
            double var44 = var16 ? var23 * 0.9 : var23;
            if (!(var40 - var44 * 1.08 < 12.0) && !(var40 + var44 * 1.08 > var12[0]) && !(var42 - var44 * 1.08 < 12.0) && !(var42 + var44 * 1.08 > 500.0)) {
               boolean var46 = true;

               for (int var47 = 0; var47 < var1[2] && var46; var47++) {
                  int var48 = var47 * 23;
                  boolean var49 = var0[var48 + 7] == 2.0;
                  double var50 = var0[var48 + 2] * (var49 ? 0.9 : 1.0);
                  double var52 = var49 ? var0[var48 + 0] + Math.cos(var0[var48 + 5]) * var0[var48 + 2] : var0[var48 + 0];
                  double var54 = var49 ? var0[var48 + 1] + Math.sin(var0[var48 + 5]) * var0[var48 + 2] : var0[var48 + 1];
                  double var56 = (var0[var48 + 20] == (double)var14 ? 0.4 : 0.5) * (var44 + var50);
                  double var58 = var40 - var52;
                  double var60 = var42 - var54;
                  if (var58 * var58 + var60 * var60 < var56 * var56) {
                     var46 = false;
                  }
               }

               if (var46) {
                  double var70 = var16 ? var21 : var21 + (var13.nextDouble() - 0.5) * 0.5;
                  double var51 = var13.nextDouble();
                  double var71;
                  if (var16) {
                     var71 = 0.12 * var51;
                  } else if (var51 < 0.35) {
                     var71 = 0.16 + 0.2 * var13.nextDouble();
                  } else if (var51 < 0.8) {
                     var71 = 0.38 + 0.3 * var13.nextDouble();
                  } else {
                     var71 = 0.7 + 0.2 * var13.nextDouble();
                  }

                  double var53;
                  if (var27 == 2) {
                     var53 = 0.5 * var13.nextDouble();
                  } else if (var27 == 1) {
                     var53 = 0.3 + 0.5 * var13.nextDouble();
                  } else {
                     var53 = (var28 < 0.4 ? 1.0 : 0.6) + 0.6 * var13.nextDouble() + 0.2 * var23 / var10;
                  }

                  var0[var17 + 0] = var36;
                  var0[var17 + 1] = var38;
                  var0[var17 + 2] = var23;
                  var0[var17 + 3] = var13.nextDouble() * (Math.PI * 2);
                  var0[var17 + 4] = var28;
                  var0[var17 + 5] = var70;
                  var0[var17 + 6] = var30;
                  var0[var17 + 7] = (double)var27;
                  var0[var17 + 8] = var71;
                  var0[var17 + 9] = var13.nextDouble() * 2.0 - 1.0;
                  var0[var17 + 10] = var53;
                  var0[var17 + 11] = !var16 && var13.nextDouble() < var12[2] ? 0.0 : 1.0;
                  var0[var17 + 21] = !var16 && var0[var17 + 11] != 0.0 && var13.nextDouble() < 0.07 ? 1.0 : 0.0;
                  double var55 = Math.sin(var28);
                  double var57 = var16 ? var36 : var36 - Math.cos(var70) * var55 * 0.3 * var23;
                  double var59 = var16 ? var38 : var38 - Math.sin(var70) * var55 * 0.3 * var23;
                  double var61 = var57 - var2;
                  double var63 = var59 - var4;
                  double var65 = Math.sqrt(var61 * var61 + var63 * var63);
                  double var67 = (var13.nextDouble() - 0.5) * 0.3;
                  var0[var17 + 12] = var2;
                  var0[var17 + 13] = var4;
                  var0[var17 + 14] = (var2 + var57) * 0.5 - var63 * var67;
                  var0[var17 + 15] = (var4 + var59) * 0.5 + var61 * var67;
                  var0[var17 + 16] = var57;
                  var0[var17 + 17] = var59;
                  var0[var17 + 18] = var16 ? 0.95 : 1.05 + 0.2 * var13.nextDouble();
                  var0[var17 + 22] = 1.0;
                  var0[var17 + 19] = (double)var13.nextInt(-1107510061 ^ -33768237);
                  var0[var17 + 20] = (double)var14;
                  var1[2]++;
                  break;
               }
            }
         }
      }
   }

   private static int p(double[] var0, int var1, int[] var2) {

      int var3 = 0;

      while (var3 < var1) {
         var2[var3] = var3++;
      }

      for (int var8 = 1; var8 < var1; var8++) {
         int var4 = var2[var8];
         double var5 = var0[var4 * 23 + 11] * 100.0 + var0[var4 * 23 + 10];

         int var7;
         for (var7 = var8 - 1; var7 >= 0 && var0[var2[var7] * 23 + 11] * 100.0 + var0[var2[var7] * 23 + 10] > var5; var7--) {
            var2[var7 + 1] = var2[var7];
         }

         var2[var7 + 1] = var4;
      }

      return var1;
   }

   private static void q(double[] var0, int var1, float[] var2) {

      double var3 = Math.sqrt(0.6984);
      double var5 = -0.3 / var3;
      double var7 = -0.78 / var3;

      for (int var9 = 0; var9 < var1; var9++) {
         int var10 = var9 * 23;
         double var11 = var0[var10 + 0];
         double var13 = var0[var10 + 1];
         double var15 = var0[var10 + 2];
         double var17 = 2.8 * var15;
         double var19 = var17 * var17;
         double var21 = 0.0;

         for (int var23 = 0; var23 < var1; var23++) {
            if (var23 != var9) {
               int var24 = var23 * 23;
               double var25 = var0[var24 + 0] - var11;
               double var27 = var0[var24 + 1] - var13;
               double var29 = var25 * var25 + var27 * var27;
               if (!(var29 >= var19) && !(var29 < 1.0E-6)) {
                  double var31 = (var25 * var5 + var27 * var7) / Math.sqrt(var29);
                  if (!(var31 <= -0.25)) {
                     double var33 = var0[var24 + 2] / var15;
                     var33 = var33 > 1.3 ? 1.3 : var33;
                     var21 += (1.0 - var29 / var19) * (var31 + 0.25) / 1.25 * var33 * (var0[var24 + 7] == 2.0 ? 0.4 : 1.0);
                  }
               }
            }
         }

         double var35 = (1.0 - 0.14 * var21) * r(var2, var11, var13);
         if (var0[var10 + 11] == 0.0) {
            var35 = var35 * 0.72 - 0.06;
         }

         var0[var10 + 22] = var35 < 0.18 ? 0.18 : (var35 > 1.0 ? 1.0 : var35);
      }
   }

   private static double r(float[] var0, double var1, double var3) {

      double var5 = var1 * 0.0075 + 17.0;
      double var7 = var3 * 0.0075 + 29.0;
      int var9 = (int)Math.floor(var5);
      int var10 = (int)Math.floor(var7);
      double var11 = var5 - (double)var9;
      double var13 = var7 - (double)var10;
      var11 = var11 * var11 * (3.0 - 2.0 * var11);
      var13 = var13 * var13 * (3.0 - 2.0 * var13);
      int var15 = (var10 & 63) << 6;
      int var16 = (var10 + 1 & 63) << 6;
      int var17 = var9 & 63;
      int var18 = var9 + 1 & 63;
      double var19 = (double)var0[var15 | var17] + (double)(var0[var15 | var18] - var0[var15 | var17]) * var11;
      double var21 = (double)var0[var16 | var17] + (double)(var0[var16 | var18] - var0[var16 | var17]) * var11;
      double var23 = var19 + (var21 - var19) * var13;
      var23 = (var23 - 0.3) / 0.5;
      var23 = var23 < 0.0 ? 0.0 : (var23 > 1.0 ? 1.0 : var23);
      return 0.8 + 0.2 * var23;
   }

   private static void s(double var0, double[] var2) {

      double var3 = 1.0 - var0;
      var2[0] = 1.0 - 0.22 * var3;
      var2[1] = 1.0 - 0.4 * var3;
      var2[2] = 1.0 - 0.2 * var3;
   }

   private static void t(float[] var0, double[] var1, int var2, double[] var3, float[] var4) {

      int var5 = -22912681 ^ -22910633;
      int[] var6 = new int[var5 + 1];

      for (int var7 = 0; var7 < 2; var7++) {
         int[] var8 = var7 == 0 ? null : new int[var6[var5]];
         int[] var9 = var7 == 0 ? null : Arrays.copyOf(var6, var5);

         for (int var10 = 0; var10 < var2; var10++) {
            int var11 = var10 * 15;
            double var12 = Math.max(var1[var11 + 6], var1[var11 + 7]) + var3[(int)var1[var11 + 10] * 5 + 2] + 2.5;
            double var14 = var1[var11 + 0];
            double var16 = var1[var11 + 1];
            double var18 = var14 + var1[var11 + 2];
            double var20 = var16 + var1[var11 + 3];
            int var22 = Math.max(0, (int)Math.floor((Math.min(var14, var18) - var12) / 16.0));
            int var23 = Math.min(63, (int)Math.floor((Math.max(var14, var18) + var12) / 16.0));
            int var24 = Math.max(0, (int)Math.floor((Math.min(var16, var20) - var12) / 16.0));
            int var25 = Math.min(31, (int)Math.floor((Math.max(var16, var20) + var12) / 16.0));

            for (int var26 = var24; var26 <= var25; var26++) {
               for (int var27 = var22; var27 <= var23; var27++) {
                  int var28 = var26 * 64 + var27;
                  if (var7 == 0) {
                     var6[var28 + 1]++;
                  } else {
                     var8[var9[var28]++] = var10;
                  }
               }
            }
         }

         if (var7 == 0) {
            for (int var29 = 0; var29 < var5; var29++) {
               var6[var29 + 1] = var6[var29 + 1] + var6[var29];
            }
         } else {
            u(var0, var1, var3, var4, var6, var8);
         }
      }
   }

   private static void u(float[] var0, double[] var1, double[] var2, float[] var3, int[] var4, int[] var5) {

      for (int var6 = 0; var6 < 32; var6++) {
         for (int var7 = 0; var7 < 64; var7++) {
            int var8 = var6 * 64 + var7;
            int var9 = var4[var8];
            int var10 = var4[var8 + 1];
            if (var9 != var10) {
               for (int var11 = var6 * 16; var11 < var6 * 16 + 16; var11++) {
                  double var12 = (double)var11 + 0.5;

                  for (int var14 = var7 * 16; var14 < var7 * 16 + 16; var14++) {
                     double var15 = (double)var14 + 0.5;
                     double var17 = 1.0E9;
                     double var19 = 0.0;
                     double var21 = 0.0;
                     double var23 = 0.0;
                     double var25 = 0.0;
                     double var27 = 1.0;
                     double var29 = 0.0;
                     int var31 = 0;
                     int var32 = -1;
                     double var33 = 1.0E9;
                     double var35 = 0.0;
                     double var37 = 0.0;
                     double var39 = 0.0;
                     double var41 = 0.0;
                     double var43 = 1.0;

                     for (int var45 = var9; var45 <= var10; var45++) {
                        int var46 = var45 < var10 ? var5[var45] : -1;
                        int var47 = var46 < 0 ? -1 : (int)var1[var46 * 15 + 10];
                        if (var47 != var32) {
                           if (var32 >= 0 && var33 < 1.0E8) {
                              int var48 = var32 * 5;
                              double var49 = var2[var48 + 2];
                              if (var49 > 0.0) {
                                 double var51 = var15 - var2[var48 + 0];
                                 double var53 = var12 - var2[var48 + 1];
                                 double var55 = 1.6 - Math.sqrt(var51 * var51 + var53 * var53) / var2[var48 + 3];
                                 var49 *= var55 < 0.0 ? 0.0 : (var55 > 1.0 ? 1.0 : var55);
                              }

                              double var139 = var2[var48 + 4];
                              if (var17 >= 1.0E8) {
                                 var17 = var33;
                                 var19 = var35;
                                 var21 = var37;
                                 var23 = var39;
                                 var25 = var41;
                                 var27 = var43;
                                 var29 = var139;
                                 var31 = var32;
                              } else {
                                 double var142 = 0.5 - var17 / 1.5;
                                 var142 = var142 < 0.0 ? 0.0 : (var142 > 1.0 ? 1.0 : var142);
                                 if (var49 >= 0.001) {
                                    double var146 = 0.5 + 0.5 * (var33 - var17) / var49;
                                    var146 = var146 < 0.0 ? 0.0 : (var146 > 1.0 ? 1.0 : var146);
                                    var17 = var33 + (var17 - var33) * var146 - var49 * var146 * (1.0 - var146);
                                    var142 = var142 > var146 ? var142 : var146;
                                 } else if (var33 < var17) {
                                    var17 = var33;
                                 }

                                 var19 = var35 + (var19 - var35) * var142;
                                 var21 = var37 + (var21 - var37) * var142;
                                 var23 = var39 + (var23 - var39) * var142;
                                 var25 = var41 + (var25 - var41) * var142;
                                 var27 = var43 + (var27 - var43) * var142;
                                 var29 = var139 + (var29 - var139) * var142;
                                 var31 = var142 >= 0.5 ? var31 : var32;
                              }
                           }

                           if (var46 < 0) {
                              break;
                           }

                           var32 = var47;
                           var33 = 1.0E9;
                        }

                        int var135 = var46 * 15;
                        if (!(var15 < var1[var135 + 11]) && !(var15 > var1[var135 + 13]) && !(var12 < var1[var135 + 12]) && !(var12 > var1[var135 + 14])) {
                           double var136 = var15 - var1[var135 + 0];
                           double var140 = var12 - var1[var135 + 1];
                           double var144 = var1[var135 + 2];
                           double var148 = var1[var135 + 3];
                           double var57 = (var136 * var144 + var140 * var148) * var1[var135 + 4];
                           var57 = var57 < 0.0 ? 0.0 : (var57 > 1.0 ? 1.0 : var57);
                           double var59 = var136 - var144 * var57;
                           double var61 = var140 - var148 * var57;
                           double var63 = var1[var135 + 6] + (var1[var135 + 7] - var1[var135 + 6]) * var57;
                           double var65 = var59 * var59 + var61 * var61;
                           double var67 = var63 + 8.0;
                           if (!(var65 > var67 * var67)) {
                              double var69 = Math.sqrt(var65) - var63;
                              if (var69 < var33) {
                                 var33 = var69;
                                 double var71 = var1[var135 + 5];
                                 double var73 = (var144 * var140 - var148 * var136) * var71;
                                 double var75 = var73 / var63;
                                 var75 = var75 < -1.0 ? -1.0 : (var75 > 1.0 ? 1.0 : var75);
                                 double var77 = Math.sqrt(1.0 - var75 * var75);
                                 var35 = var75 * (-var148 * -0.3 + var144 * -0.78) * var71 + var77 * 0.55;
                                 var37 = var75 * (-var148 * es + var144 * et) * var71 + var77 * eu;
                                 var39 = var1[var135 + 8] + var57 * var1[var135 + 9];
                                 var41 = var73;
                                 var43 = var63;
                              }
                           }
                        }
                     }

                     if (!(var17 >= 0.55)) {
                        double var131 = 0.5 - var17 / 1.1;
                        var131 = var131 > 1.0 ? 1.0 : var131;
                        double var133 = (var27 - 1.5) / 6.0;
                        var133 = var133 < 0.0 ? 0.0 : (var133 > 1.0 ? 1.0 : var133);
                        double var137 = var25 / var27;
                        var137 = var137 < -1.0 ? -1.0 : (var137 > 1.0 ? 1.0 : var137);
                        double var141 = Math.asin(var137);
                        double var145 = var141 * var27;
                        double var149 = var23 * 0.045 + var29 * 17.0 + (double)var31 * 5.3;
                        double var153 = var145 * 0.55 + 3.0;
                        int var156 = (int)Math.floor(var149);
                        int var60 = (int)Math.floor(var153);
                        double var161 = var149 - (double)var156;
                        double var167 = var153 - (double)var60;
                        var161 = var161 * var161 * (3.0 - 2.0 * var161);
                        var167 = var167 * var167 * (3.0 - 2.0 * var167);
                        int var173 = (var60 & 63) << 6;
                        int var66 = (var60 + 1 & 63) << 6;
                        int var178 = var156 & 63;
                        int var68 = var156 + 1 & 63;
                        double var183 = (double)var3[var173 | var178] + (double)(var3[var173 | var68] - var3[var173 | var178]) * var161;
                        double var186 = (double)var3[var66 | var178] + (double)(var3[var66 | var68] - var3[var66 | var178]) * var161;
                        double var189 = var183 + (var186 - var183) * var167;
                        var149 = var23 * 0.011 + 7.0 + var29 * 31.0 + (double)var31 * 2.9;
                        var153 = var145 * 0.07 + 11.0;
                        var156 = (int)Math.floor(var149);
                        var60 = (int)Math.floor(var153);
                        var161 = var149 - (double)var156;
                        var167 = var153 - (double)var60;
                        var161 = var161 * var161 * (3.0 - 2.0 * var161);
                        var167 = var167 * var167 * (3.0 - 2.0 * var167);
                        var173 = (var60 & 63) << 6;
                        var66 = (var60 + 1 & 63) << 6;
                        var178 = var156 & 63;
                        var68 = var156 + 1 & 63;
                        var183 = (double)var3[var173 | var178] + (double)(var3[var173 | var68] - var3[var173 | var178]) * var161;
                        var186 = (double)var3[var66 | var178] + (double)(var3[var66 | var68] - var3[var66 | var178]) * var161;
                        double var191 = var183 + (var186 - var183) * var167;
                        var149 = var23 * 0.02 + 23.0 + (double)var31 * 1.7;
                        var153 = var145 * 0.3 + 41.0;
                        var156 = (int)Math.floor(var149);
                        var60 = (int)Math.floor(var153);
                        var161 = var149 - (double)var156;
                        var167 = var153 - (double)var60;
                        var161 = var161 * var161 * (3.0 - 2.0 * var161);
                        var167 = var167 * var167 * (3.0 - 2.0 * var167);
                        var173 = (var60 & 63) << 6;
                        var66 = (var60 + 1 & 63) << 6;
                        var178 = var156 & 63;
                        var68 = var156 + 1 & 63;
                        var183 = (double)var3[var173 | var178] + (double)(var3[var173 | var68] - var3[var173 | var178]) * var161;
                        var186 = (double)var3[var66 | var178] + (double)(var3[var66 | var68] - var3[var66 | var178]) * var161;
                        double var192 = 1.0 - Math.abs(2.0 * (var183 + (var186 - var183) * var167) - 1.0);
                        var192 *= var192;
                        var192 *= var192;
                        var192 *= var192;
                        double var79 = 0.0;
                        double var81 = 0.0;
                        if (var27 > 1.7) {
                           double var83 = 4.2 + 6.0 * var133;
                           int var85 = (int)Math.floor(var23 / var83);

                           for (int var86 = var85 - 1; var86 <= var85 + 1; var86++) {
                              for (int var87 = 0; var87 < 2; var87++) {
                                 int var88 = var86 * (-616332230 ^ 1165294979) + (var31 * 2 + var87) * (-1155999094 ^ 1056116961) + (-704445314 ^ -1255611947);
                                 var88 ^= var88 >>> 15;
                                 var88 *= -362766866 ^ -964976253;
                                 var88 ^= var88 >>> 12;
                                 var88 *= 1779703190 ^ 1131294895;
                                 var88 ^= var88 >>> 15;
                                 int var89 = var88 * (941396394 ^ -1507071981) + (-734938066 ^ -1417953221);
                                 var89 ^= var89 >>> 16;
                                 var89 *= -437165050 ^ 1612361325;
                                 var89 ^= var89 >>> 13;
                                 if ((var89 & (-1365533689 ^ -1365533448)) >= 90) {
                                    double var90 = (double)(var88 & (-339460030 ^ -339459907)) / 255.0;
                                    double var92 = (double)(var88 >>> 8 & (-2081414180 ^ -2081414365)) / 255.0;
                                    double var94 = (double)(var88 >>> 16 & (-1038083892 ^ -1038084045)) / 255.0;
                                    double var96 = (double)(var88 >>> 24 & (2111121570 ^ 2111121501)) / 255.0;
                                    double var98 = ((double)var86 + var90) * var83;
                                    double var100 = (0.3 + 0.5 * var92) * (0.7 + 0.8 * var133);
                                    double var102 = (var94 - 0.5) * 2.9;
                                    double var104 = 0.08 + 0.55 * var96 * var96;
                                    double var106 = 1.0 - Math.abs(var23 - var98) / var100;
                                    double var108 = 1.0 - Math.abs(var141 - var102) / var104;
                                    if (var108 > 0.0) {
                                       var108 = var108 > 0.35 ? 1.0 : var108 / 0.35;
                                       if (var106 > 0.0) {
                                          var106 = var106 > 0.4 ? 1.0 : var106 / 0.4;
                                          double var110 = var106 * var108;
                                          var79 = var79 > var110 ? var79 : var110;
                                       }

                                       double var221 = var23 - var98 - var100;
                                       if (var221 > 0.0 && var221 < 1.1) {
                                          double var112 = (1.0 - var221 / 1.1) * var108;
                                          var81 = var81 > var112 ? var81 : var112;
                                       }
                                    }
                                 }
                              }
                           }
                        }

                        double var196 = (var29 - 0.2) / 0.8 + (1.0 - var133) * 0.45;
                        var196 = var196 < 0.0 ? 0.0 : (var196 > 1.0 ? 1.0 : var196);
                        double var198 = (var19 + 0.12) / 1.12;
                        var198 = var198 < 0.0 ? 0.0 : (var198 > 1.0 ? 1.0 : var198);
                        double var200 = var198 / 0.55;
                        var200 = var200 > 1.0 ? 1.0 : var200;
                        var200 = var200 * var200 * (3.0 - 2.0 * var200);
                        double var211 = (var198 - 0.45) / 0.55;
                        var211 = var211 < 0.0 ? 0.0 : var211;
                        var211 = var211 * var211 * (3.0 - 2.0 * var211);
                        double var91 = 0.04 + 0.022 * var196;
                        double var93 = 0.034 + 0.001999999999999995 * var196;
                        double var95 = 0.035 + -0.0010000000000000009 * var196;
                        double var97 = 0.165 + 0.04999999999999999 * var196;
                        double var99 = 0.142 + -0.016999999999999987 * var196;
                        double var101 = 0.138 + -0.02800000000000001 * var196;
                        double var103 = 0.42 + 0.0 * var196;
                        double var105 = 0.39 + -0.11499999999999999 * var196;
                        double var107 = 0.38 + -0.14500000000000002 * var196;
                        double var109 = var91 + (var97 - var91) * var200;
                        double var111 = var93 + (var99 - var93) * var200;
                        double var113 = var95 + (var101 - var95) * var200;
                        var109 += (var103 - var109) * var211;
                        var111 += (var105 - var111) * var211;
                        var113 += (var107 - var113) * var211;
                        double var115 = 1.0 + (var189 - 0.5) * (0.3 + 0.3 * var133) + (var191 - 0.5) * 0.4 * var133 - var192 * 0.38 * var133;
                        var109 *= var115;
                        var111 *= var115;
                        var113 *= var115;
                        double var117 = (var191 - 0.5) / 0.26;
                        var117 = var117 < 0.0 ? 0.0 : (var117 > 1.0 ? 1.0 : var117);
                        var117 *= var117 * 0.7 * var133;
                        double var119 = var109 * 0.3 + var111 * 0.55 + var113 * 0.15;
                        var109 += (var119 * 1.22 + 0.025 - var109) * var117;
                        var111 += (var119 * 1.2 + 0.025 - var111) * var117;
                        var113 += (var119 * 1.21 + 0.028 - var113) * var117;
                        if (var79 > 0.0) {
                           double var121 = 0.55 + 0.6 * var198;
                           double var123 = var79 * (0.42 + 0.3 * var196) * (0.7 + 0.5 * var189);
                           var109 += (0.54 * var121 - var109) * var123;
                           var111 += (0.43 * var121 - var111) * var123;
                           var113 += (0.35 * var121 - var113) * var123;
                        }

                        if (var81 > 0.0) {
                           double var234 = 1.0 - 0.22 * var81;
                           var109 *= var234;
                           var111 *= var234;
                           var113 *= var234;
                        }

                        if (var21 > 0.0) {
                           double var235 = var21 * var21;
                           double var239 = var235 * var235;
                           double var125 = var239 * var239;
                           double var127 = var125 * var125;
                           double var129 = var127 * var239 * (0.07 + 0.2 * var196) * (0.5 + 1.0 * var189) * (1.0 - 0.6 * var79) * (1.0 - var117);
                           var109 += var129 * 0.86;
                           var111 += var129 * 0.83;
                           var113 += var129 * 0.84;
                        }

                        if (var19 < 0.0) {
                           var109 += -var19 * 0.03;
                           var111 += -var19 * 0.013;
                           var113 += -var19 * 0.018;
                        }

                        double var236 = (var17 + 1.8) / 1.8;
                        var236 = var236 < 0.0 ? 0.0 : (var236 > 1.0 ? 1.0 : var236);
                        var236 = 1.0 - var236 * var236 * 0.4 * var133;
                        var109 *= var236;
                        var111 *= var236;
                        var113 *= var236;
                        var109 = var109 < 0.0 ? 0.0 : (var109 > 1.0 ? 1.0 : var109);
                        var111 = var111 < 0.0 ? 0.0 : (var111 > 1.0 ? 1.0 : var111);
                        var113 = var113 < 0.0 ? 0.0 : (var113 > 1.0 ? 1.0 : var113);
                        int var240 = var11 * (-1060462478 ^ -1060461454) + var14 << 2;
                        float var124 = (float)var131;
                        float var241 = 1.0F - var124;
                        var0[var240] = (float)(var109 * var131) + var0[var240] * var241;
                        var0[var240 + 1] = (float)(var111 * var131) + var0[var240 + 1] * var241;
                        var0[var240 + 2] = (float)(var113 * var131) + var0[var240 + 2] * var241;
                        var0[var240 + 3] = var124 + var0[var240 + 3] * var241;
                     }
                  }
               }
            }
         }
      }
   }

   private static void v(float[] var0, float[] var1, double[] var2, int var3, double[] var4, float[] var5) {

      int var6 = (int)var2[var3 + 7];
      if (var6 == 2) {
         ab(var0, var2, var3, var5);
      } else {
         double var7 = var2[var3 + 0];
         double var9 = var2[var3 + 1];
         double var11 = var2[var3 + 2];
         double var13 = var2[var3 + 4];
         double var15 = var2[var3 + 5];
         double var17 = var2[var3 + 6];
         double var19 = var2[var3 + 3];
         double var21 = var2[var3 + 8];
         double var23 = var2[var3 + 9];
         Random var25 = new Random((long)var2[var3 + 19]);
         w(var4, var21, var23, var25);
         double var26 = (26.0 - var11) / 10.0;
         var4[96917404 ^ 96917235] = var26 < 0.0 ? 0.0 : (var26 > 1.0 ? 1.0 : var26);
         boolean var28 = var13 > Math.PI / 2;
         double var29 = -Math.sin(var15);
         double var31 = Math.cos(var15);
         double var33 = Math.cos(var13);
         double var35 = Math.sin(var13);
         double var37 = Math.cos(var15) * var35;
         double var39 = Math.sin(var15) * var35;
         double var41 = var33;
         double var43 = 0.07 * var11;
         double var45 = 0.37 + 0.06 * var25.nextDouble();
         double var47 = 0.05 + 0.05 * var25.nextDouble();
         double[] var49 = new double[5];

         for (int var50 = 0; var50 < 5; var50++) {
            int var51 = var50 * 22;
            double var52 = var19 + (double)var50 * (Math.PI * 2.0 / 5.0) + (var25.nextDouble() - 0.5) * 0.16;
            double var54 = Math.cos(var52);
            double var56 = Math.sin(var52);
            double var58 = var29 * var54 + var31 * var56;
            double var60 = var54 * var33 + var29 * var58 * (1.0 - var33);
            double var62 = var56 * var33 + var31 * var58 * (1.0 - var33);
            double var64 = (var29 * var56 - var31 * var54) * var35;
            double var66 = -var29 * var56 + var31 * var54;
            double var68 = -var56 * var33 + var29 * var66 * (1.0 - var33);
            double var70 = var54 * var33 + var31 * var66 * (1.0 - var33);
            double var72 = (var29 * var54 + var31 * var56) * var35;
            double var74 = var17 + (var25.nextDouble() - 0.5) * 0.12;
            double var76 = Math.cos(var74);
            double var78 = Math.sin(var74);
            double var80 = var60 * var76 + var37 * var78;
            double var82 = var62 * var76 + var39 * var78;
            double var84 = var64 * var76 + var41 * var78;
            double var86 = var11 * (0.95 + 0.08 * var25.nextDouble()) - var43;
            double var88 = var68 * var82 - var80 * var70;
            if (Math.abs(var88) < 1.0E-4) {
               var88 = var88 < 0.0 ? -1.0E-4 : 1.0E-4;
            }

            var4[var51 + 0] = var60 * var43;
            var4[var51 + 1] = var62 * var43;
            var4[var51 + 2] = var82 / var88;
            var4[var51 + 3] = -var80 / var88;
            var4[var51 + 4] = -var70 / var88;
            var4[var51 + 5] = var68 / var88;
            double var90 = (var45 + (var25.nextDouble() - 0.5) * 0.03) * var86;
            double var92 = 0.085 * var86;
            double var94 = var86 - var92 - var90;
            double var96 = (var92 - var90) / var94;
            var4[var51 + 6] = var92;
            var4[var51 + 7] = var90;
            var4[var51 + 8] = var94;
            var4[var51 + 9] = var96;
            var4[var51 + 10] = Math.sqrt(1.0 - var96 * var96);
            double var98 = (var47 + (var25.nextDouble() - 0.5) * 0.02) * var86;
            var4[var51 + 12] = var98;
            var4[var51 + 11] = var86 + 0.3 * var98;
            var4[var51 + 13] = var86;
            double var100 = var82 * var72 - var84 * var70;
            double var102 = var84 * var68 - var80 * var72;
            double var104 = var80 * var70 - var82 * var68;
            boolean var106 = var104 < 0.0;
            if (var106) {
               var100 = -var100;
               var102 = -var102;
               var104 = -var104;
            }

            double var107 = var100 * -0.3 + var102 * -0.78 + var104 * 0.55;
            var4[var51 + 14] = (1.0 + 0.2 * (var107 - 0.55)) * (0.94 + 0.11 * var25.nextDouble());
            var4[var51 + 15] = var106 ? 1.0 : 0.0;
            var49[var50] = var64 * var43 + 0.5 * var86 * var84;
            var4[var51 + 16] = var64 > 0.3 ? 1.0 : 0.0;
            var4[var51 + 17] = (var25.nextDouble() - 0.5) * 0.2;
            var4[var51 + 18] = (var25.nextDouble() - 0.5) * 0.16;
            double var109 = Math.sqrt(var80 * var80 + var82 * var82);
            double var111 = Math.sqrt(var68 * var68 + var70 * var70);
            var4[var51 + 19] = var60 * var43 + var80 * 0.5 * var86;
            var4[var51 + 20] = var62 * var43 + var82 * 0.5 * var86;
            double var113 = 0.5 * var86 * var109;
            double var115 = (1.1 * var90 + 0.1 * var86) * var111;
            double var117 = var109 > 1.0E-9 && var111 > 1.0E-9 ? Math.abs(var68 * var80 + var70 * var82) / (var111 * var109) : 1.0;
            double var119 = Math.sqrt(var113 * var113 + var115 * var115 + 2.0 * var113 * var115 * var117) + 4.5;
            var4[var51 + 21] = var119 * var119;
         }

         int[] var121 = new int[]{0, 1, 2, 3, 4};

         for (int var122 = 1; var122 < 5; var122++) {
            int var124 = var121[var122];

            int var53;
            for (var53 = var122 - 1; var53 >= 0 && var49[var121[var53]] > var49[var124]; var53--) {
               var121[var53 + 1] = var121[var53];
            }

            var121[var53 + 1] = var124;
         }

         double var123 = var33 + var29 * var29 * (1.0 - var33);
         double var125 = var31 * var29 * (1.0 - var33);
         double var55 = var29 * var31 * (1.0 - var33);
         double var57 = var33 + var31 * var31 * (1.0 - var33);
         double var59 = var123 * var57 - var55 * var125;
         if (Math.abs(var59) < 0.05) {
            var59 = var59 < 0.0 ? -0.05 : 0.05;
         }

         var4[-318534132 ^ -318533762] = var57 / var59;
         var4[-1444007863 ^ -1444007622] = -var55 / var59;
         var4[-1342528882 ^ -1342528518] = -var125 / var59;
         var4[1326492582 ^ 1326492371] = var123 / var59;
         var4[1544864401 ^ 1544864743] = Math.cos(var19);
         var4[1742647210 ^ 1742647005] = Math.sin(var19);
         var4[888450860 ^ 888450644] = 0.52 * var11;
         var4[-1840081886 ^ -1840081573] = 0.84 - 0.3 * var21;
         var4[726187500 ^ 726187158] = 0.075 * var11;
         int var61 = (int)Math.round((double)(var6 == 1 ? 12 : 16 + var25.nextInt(5)) * (1.0 - 0.4 * var4[-1375386057 ^ -1375385768]));
         double var126 = var11 * (var6 == 1 ? 0.4 : 0.37);
         double var127 = 0.0;

         for (int var129 = 0; var129 < var61; var129++) {
            int var67 = 110 + var129 * 10;
            double var131 = var19 + 0.63 + (double)var129 * (Math.PI * 2) / (double)var61 + (var25.nextDouble() - 0.5) * 0.45;
            double var133 = Math.cos(var131);
            double var135 = Math.sin(var131);
            double var137 = var29 * var133 + var31 * var135;
            double var139 = var133 * var33 + var29 * var137 * (1.0 - var33);
            double var141 = var135 * var33 + var31 * var137 * (1.0 - var33);
            double var144 = var126 * (0.6 + 0.5 * var25.nextDouble());
            double var145 = 0.42 + 0.45 * var25.nextDouble();
            double var147 = (var139 * Math.cos(var145) + var37 * Math.sin(var145)) * var144;
            double var149 = (var141 * Math.cos(var145) + var39 * Math.sin(var145)) * var144;
            double var154 = var139 * var11 * 0.05;
            double var156 = var141 * var11 * 0.05;
            var4[var67] = var154;
            var4[var67 + 1] = var156;
            var4[var67 + 2] = var147 - var154;
            var4[var67 + 3] = var149 - var156;
            double var161 = (var147 - var154) * (var147 - var154) + (var149 - var156) * (var149 - var156);
            var4[var67 + 4] = var161 > 1.0E-9 ? 1.0 / var161 : 0.0;
            double var167 = Math.max(0.95 - 0.3 * var4[-798109039 ^ -798108674], Math.min(1.5, 0.034 * var11)) * (0.85 + 0.3 * var25.nextDouble());
            var4[var67 + 5] = var167;
            double var173 = var167 + 1.2;
            var4[var67 + 6] = Math.min(var154, var147) - var173;
            var4[var67 + 7] = Math.min(var156, var149) - var173;
            var4[var67 + 8] = Math.max(var154, var147) + var173;
            var4[var67 + 9] = Math.max(var156, var149) + var173;
            var127 = Math.max(var127, Math.sqrt(var147 * var147 + var149 * var149) + 3.0);
         }

         double var130 = var126 * (0.95 + 0.12 * var25.nextDouble());
         var4[-1829047823 ^ -1829048179] = var37 * var130 + (var25.nextDouble() - 0.5) * 0.06 * var11;
         var4[1173460561 ^ 1173460780] = var39 * var130 + (var25.nextDouble() - 0.5) * 0.06 * var11;
         var127 = Math.max(
            var127,
            Math.sqrt(var4[-535531548 ^ -535531880] * var4[1149369103 ^ 1149368947] + var4[609878136 ^ 609878277] * var4[2079904159 ^ 2079903970]) + 3.0
         );
         var4[-607525939 ^ -607526218] = Math.max(var127, 0.5980000000000001 * var11 + 2.0);
         double var132 = -var37 * 0.32 * var11;
         double var134 = -var39 * 0.32 * var11;
         double var136 = Math.sqrt(var132 * var132 + var134 * var134);
         double var138 = 0.08 * var11;
         double var140 = 0.2 * var11;
         boolean var142 = !var28 && var13 > 0.35 && var136 > var140 - var138 + 0.5;
         if (var142) {
            var4[1308050058 ^ 1308050420] = var132;
            var4[994000145 ^ 993999982] = var134;
            var4[-636322702 ^ -636322318] = var136;
            var4[1387337740 ^ 1387338125] = var138;
            var4[-420893175 ^ -420892789] = var140;
            var4[2122318523 ^ 2122318648] = -var132 / var136;
            var4[-2015227215 ^ -2015227083] = -var134 / var136;
            double var79 = (var138 - var140) / var136;
            var4[-2010746359 ^ -2010745972] = var79;
            var4[-1052625718 ^ -1052625588] = Math.sqrt(1.0 - var79 * var79);
         }

         double var143 = 1.12 * var11 + 3.0;
         int var81 = Math.max(0, (int)Math.floor(var7 - var143));
         int var146 = Math.min(1975764359 ^ 1975763335, (int)Math.ceil(var7 + var143) + 1);
         int var83 = Math.max(0, (int)Math.floor(var9 - var143));
         int var148 = Math.min(326083597 ^ 326084109, (int)Math.ceil(var9 + var143) + 1);
         int var85 = var146 - var81;
         int var150 = var148 - var83;
         if (var85 > 0 && var150 > 0 && var85 * var150 * 4 <= var1.length) {
            Arrays.fill(var1, 0, var85 * var150 * 4, 0.0F);
            if (!var28) {
               if (var142) {
                  z(var1, var85, var81, var83, var146, var148, var7, var9, var4);
               }

               for (int var87 = 0; var87 < 5; var87++) {
                  if (var4[var121[var87] * 22 + 16] == 0.0) {
                     x(var1, var85, var81, var83, var146, var148, var7, var9, var4, var121[var87] * 22, var5);
                  }
               }

               y(var1, var85, var81, var83, var146, var148, var7, var9, var4, var61, var5);

               for (int var151 = 0; var151 < 5; var151++) {
                  if (var4[var121[var151] * 22 + 16] != 0.0) {
                     x(var1, var85, var81, var83, var146, var148, var7, var9, var4, var121[var151] * 22, var5);
                  }
               }
            } else {
               for (int var152 = 0; var152 < 5; var152++) {
                  x(var1, var85, var81, var83, var146, var148, var7, var9, var4, var121[var152] * 22, var5);
               }

               aa(var1, var85, var81, var83, var146, var148, var7, var9, var4, var11, var15, var19);
            }

            double var153 = var2[var3 + 22];
            if (var153 >= 0.0) {
               double[] var89 = new double[3];
               s(var153, var89);
               float var157 = (float)var89[0];
               float var91 = (float)var89[1];
               float var162 = (float)var89[2];
               float var93 = (float)Math.max(0.0, (var153 - 0.5) / 0.5 * 0.4);
               byte var168 = 0;

               for (int var95 = var85 * var150 * 4; var168 < var95; var168 += 4) {
                  float var174 = var1[var168 + 3];
                  float var97 = var1[var168] * var157;
                  float var179 = var1[var168 + 1] * var91;
                  float var99 = var1[var168 + 2] * var162;
                  var1[var168] = var97 + (var174 - var97) * var93;
                  var1[var168 + 1] = var179 + (var174 - var179) * var93;
                  var1[var168 + 2] = var99 + (var174 - var99) * var93;
               }
            }

            int var155 = (int)Math.round(0.048 * var11);
            int var158 = (int)Math.round(0.0936 * var11);

            for (int var159 = Math.max(0, var83 + var158); var159 < Math.min(1742357964 ^ 1742358476, var148 + var158); var159++) {
               int var163 = var159 * (332195549 ^ 332194525) << 2;
               int var165 = var159 - var158 - var83;

               for (int var169 = Math.max(0, var81 + var155); var169 < Math.min(2067574638 ^ 2067573614, var146 + var155); var169++) {
                  int var171 = var163 + (var169 << 2);
                  if (!(var0[var171 + 3] <= 0.0F)) {
                     int var175 = var169 - var155 - var81;
                     float var177 = 0.0F;

                     for (int var180 = 0; var180 < 5; var180++) {
                        int var183 = var175 + (var180 == 1 ? -2 : (var180 == 2 ? 2 : 0));
                        int var184 = var165 + (var180 == 3 ? -2 : (var180 == 4 ? 2 : 0));
                        if (var183 >= 0 && var184 >= 0 && var183 < var85 && var184 < var150) {
                           var177 += var1[(var184 * var85 + var183 << 2) + 3];
                        }
                     }

                     if (!(var177 <= 0.0F)) {
                        float var181 = 1.0F - 0.055F * var177;
                        var0[var171] *= var181;
                        var0[var171 + 1] = var0[var171 + 1] * var181;
                        var0[var171 + 2] = var0[var171 + 2] * var181;
                     }
                  }
               }
            }

            for (int var160 = var83; var160 < var148; var160++) {
               int var164 = (var160 - var83) * var85 * 4 - var81 * 4;
               int var166 = var160 * (-304692604 ^ -304691580) << 2;

               for (int var170 = var81; var170 < var146; var170++) {
                  int var172 = var164 + (var170 << 2);
                  float var176 = var1[var172 + 3];
                  if (!(var176 <= 0.0F)) {
                     int var178 = var166 + (var170 << 2);
                     float var182 = 1.0F - var176;
                     var0[var178] = var1[var172] + var0[var178] * var182;
                     var0[var178 + 1] = var1[var172 + 1] + var0[var178 + 1] * var182;
                     var0[var178 + 2] = var1[var172 + 2] + var0[var178 + 2] * var182;
                     var0[var178 + 3] = var176 + var0[var178 + 3] * var182;
                  }
               }
            }
         }
      }
   }

   private static void w(double[] var0, double var1, double var3, Random var5) {

      double var6 = 0.6 * var1;
      double var8 = 0.35 * var1;
      double var10 = 0.012 * var3;
      double var12 = 0.022 * var3;
      double var14 = -0.02 * var3;
      int var16 = 91233338 ^ 91233636;
      var0[var16] = 0.93 + var10 + (0.06999999999999995 - var10) * var8;
      var0[var16 + 1] = 0.52 + var12 + (0.45499999999999996 - var12) * var8;
      var0[var16 + 2] = 0.665 + var14 + (0.31499999999999995 - var14) * var8;
      var16 = -1342849704 ^ -1342849991;
      var0[var16] = 0.985 + 0.015000000000000013 * var6;
      var0[var16 + 1] = 0.862 + var12 + (0.11299999999999999 - var12) * var6;
      var0[var16 + 2] = 0.905 + var14 + (0.07499999999999996 - var14) * var6;
      var16 = -608990920 ^ -608991140;
      var0[var16] = 0.998 + 0.0020000000000000018 * var6;
      var0[var16 + 1] = 0.955 + 0.5 * var12 + (0.020000000000000018 - 0.5 * var12) * var6;
      var0[var16 + 2] = 0.966 + 0.5 * var14 + (0.014000000000000012 - 0.5 * var14) * var6;
      var0[-804890926 ^ -804890699] = 0.1 + 0.07 * var5.nextDouble();
      var0[315073687 ^ 315074044] = 0.25 + 0.65 * var5.nextDouble();
      var0[1215063516 ^ 1215063216] = var5.nextDouble() * 40.0 + 8.0;
      var0[1002455227 ^ 1002455510] = var5.nextDouble() * 40.0 + 8.0;
   }

   private static void x(float[] var0, int var1, int var2, int var3, int var4, int var5, double var6, double var8, double[] var10, int var11, float[] var12) {

      double var13 = var6 + var10[var11 + 19];
      double var15 = var8 + var10[var11 + 20];
      double var17 = var10[var11 + 21];
      double var19 = Math.sqrt(var17);
      int var21 = Math.max(var2, (int)Math.floor(var13 - var19));
      int var22 = Math.min(var4, (int)Math.ceil(var13 + var19) + 1);
      int var23 = Math.max(var3, (int)Math.floor(var15 - var19));
      int var24 = Math.min(var5, (int)Math.ceil(var15 + var19) + 1);
      double var25 = var6 + var10[var11 + 0];
      double var27 = var8 + var10[var11 + 1];
      double var29 = var10[var11 + 2];
      double var31 = var10[var11 + 3];
      double var33 = var10[var11 + 4];
      double var35 = var10[var11 + 5];
      double var37 = var10[var11 + 13];
      double var39 = var10[var11 + 17];
      double var41 = var10[var11 + 18];
      double var43 = var10[var11 + 6];
      double var45 = var10[var11 + 7];
      double var47 = var10[var11 + 8];
      double var49 = var10[var11 + 9];
      double var51 = var10[var11 + 10];
      double var53 = var10[var11 + 11];
      double var55 = var10[var11 + 12];
      boolean var57 = var10[var11 + 15] != 0.0;
      double var58 = var10[var11 + 14];
      double var60 = var10[1241189172 ^ 1241188970];
      double var62 = var10[-1388163841 ^ -1388163680];
      double var64 = var10[-966077103 ^ -966077391];
      double var66 = var10[-2140133369 ^ -2140133018];
      double var68 = var10[1230266212 ^ 1230265862];
      double var70 = var10[338784949 ^ 338785238];
      double var72 = var10[-195322449 ^ -195322677];
      double var74 = var10[1748379830 ^ 1748380115];
      double var76 = var10[2008959683 ^ 2008959909];
      double var78 = var10[-926506858 ^ -926506511] * (var57 ? 0.55 : 1.0);
      double var80 = var10[-715094755 ^ -715094927];
      double var82 = var10[1980782332 ^ 1980782481];
      double var84 = 20.420352248333657 / Math.atan2(var45, 0.97 * var37);
      double var86 = 0.22 * var37;
      double var88 = Math.sqrt(var29 * var29 + var31 * var31);
      double var90 = var88 > 1.0E-9 ? (var29 * -0.3 + var31 * -0.78) / var88 : 0.0;
      double var92 = var41 * 97.0 + var39 * 61.0;
      double var94 = 0.011 * var37;

      for (int var96 = var23; var96 < var24; var96++) {
         double var97 = (double)var96 + 0.5;
         int var99 = (var96 - var3) * var1 - var2;

         for (int var100 = var21; var100 < var22; var100++) {
            double var101 = (double)var100 + 0.5;
            double var103 = var101 - var13;
            double var105 = var97 - var15;
            if (!(var103 * var103 + var105 * var105 > var17)) {
               double var107 = var101 - var25;
               double var109 = var97 - var27;
               double var111 = var33 * var107 + var35 * var109;
               double var113 = var39 * 2.0 * var111 / var37;
               double var115 = var29 * var107 + var31 * var109 - var39 * var111 * var111 / var37;
               double var117 = var115 < 0.0 ? 1.0 + var41 : 1.0 - var41;
               double var119 = (var115 < 0.0 ? -var115 : var115) * var117;
               double var121 = var111 - var43;
               double var123 = -var49 * var119 + var51 * var121;
               double var125;
               double var127;
               double var129;
               if (var123 < 0.0) {
                  double var131 = Math.sqrt(var119 * var119 + var121 * var121);
                  var125 = var131 - var43;
                  var127 = var131 > 1.0E-9 ? var119 / var131 : 0.0;
                  var129 = var131 > 1.0E-9 ? var121 / var131 : -1.0;
               } else if (var123 > var51 * var47) {
                  double var203 = var121 - var47;
                  double var133 = Math.sqrt(var119 * var119 + var203 * var203);
                  var125 = var133 - var45;
                  var127 = var133 > 1.0E-9 ? var119 / var133 : 0.0;
                  var129 = var133 > 1.0E-9 ? var203 / var133 : 1.0;
               } else {
                  var125 = var119 * var51 + var121 * var49 - var43;
                  var127 = var51;
                  var129 = var49;
               }

               double var204 = var111 - var53;
               double var205 = Math.sqrt(var119 * var119 + var204 * var204);
               double var135 = var55 - var205;
               if (var135 > var125 && var205 > 1.0E-9) {
                  var125 = var135;
                  var127 = -var119 / var205;
                  var129 = -var204 / var205;
               }

               double var137 = var111 / var37;
               var137 = var137 < 0.0 ? 0.0 : (var137 > 1.0 ? 1.0 : var137);
               var125 += var94 * var137 * (Math.sin(var111 * 0.31 + var119 * 0.37 + var92) + 0.5 * Math.sin(var119 * 0.83 - var111 * 0.23 + 2.1 * var92));
               var127 *= var115 < 0.0 ? -var117 : var117;
               double var139 = (var29 - var113 * var33) * var127 + var33 * var129;
               double var141 = (var31 - var113 * var35) * var127 + var35 * var129;
               double var143 = Math.sqrt(var139 * var139 + var141 * var141);
               double var145 = var125 / (var143 > 1.0E-6 ? var143 : 1.0E-6);
               int var147 = var99 + var100 << 2;
               if (var145 < 3.4 && var0[var147 + 3] > 0.0F) {
                  double var148 = var145 <= 0.0 ? 1.0 : 1.0 - var145 / 3.4;
                  var148 = var148 * var148 * 0.18;
                  var0[var147] *= (float)(1.0 - var148 * 0.42);
                  var0[var147 + 1] = var0[var147 + 1] * (float)(1.0 - var148 * 0.8);
                  var0[var147 + 2] = var0[var147 + 2] * (float)(1.0 - var148 * 0.62);
               }

               double var208 = 0.5 - var145 / 1.1;
               if (!(var208 <= 0.0)) {
                  var208 = var208 > 1.0 ? 1.0 : var208;
                  double var150 = (double)var100 * 0.09 + var80;
                  double var152 = (double)var96 * 0.09 + var82;
                  int var154 = (int)var150;
                  int var155 = (int)var152;
                  double var156 = var150 - (double)var154;
                  double var158 = var152 - (double)var155;
                  var156 = var156 * var156 * (3.0 - 2.0 * var156);
                  var158 = var158 * var158 * (3.0 - 2.0 * var158);
                  int var160 = (var155 & 63) << 6;
                  int var161 = (var155 + 1 & 63) << 6;
                  int var162 = var154 & 63;
                  int var163 = var154 + 1 & 63;
                  double var164 = (double)var12[var160 | var162] + (double)(var12[var160 | var163] - var12[var160 | var162]) * var156;
                  double var166 = (double)var12[var161 | var162] + (double)(var12[var161 | var163] - var12[var161 | var162]) * var156;
                  double var168 = var164 + (var166 - var164) * var158;
                  var150 = (double)var100 * 0.23 + var82 + 5.0;
                  var152 = (double)var96 * 0.23 + var80 + 9.0;
                  var154 = (int)var150;
                  var155 = (int)var152;
                  var156 = var150 - (double)var154;
                  var158 = var152 - (double)var155;
                  var156 = var156 * var156 * (3.0 - 2.0 * var156);
                  var158 = var158 * var158 * (3.0 - 2.0 * var158);
                  var160 = (var155 & 63) << 6;
                  var161 = (var155 + 1 & 63) << 6;
                  var162 = var154 & 63;
                  var163 = var154 + 1 & 63;
                  var164 = (double)var12[var160 | var162] + (double)(var12[var160 | var163] - var12[var160 | var162]) * var156;
                  var166 = (double)var12[var161 | var162] + (double)(var12[var161 | var163] - var12[var161 | var162]) * var156;
                  var168 = var168 * 0.6 + (var164 + (var166 - var164) * var158) * 0.4;
                  double var170 = var111 / var37;
                  var170 = var170 < 0.0 ? 0.0 : (var170 > 1.0 ? 1.0 : var170);
                  double var172 = var119 / var45;
                  var172 = var172 > 1.0 ? 1.0 : var172;
                  double var174 = (var170 + var172 * 0.1) / 0.36;
                  var174 = var174 > 1.0 ? 1.0 : var174;
                  var174 = var174 * var174 * (3.0 - 2.0 * var174);
                  double var176 = (var170 - 0.4) / 0.55;
                  var176 = var176 < 0.0 ? 0.0 : (var176 > 1.0 ? 1.0 : var176);
                  var176 = var176 * var176 * (3.0 - 2.0 * var176);
                  double var178 = var60 + (var66 - var60) * var174;
                  double var180 = var62 + (var68 - var62) * var174;
                  double var182 = var64 + (var70 - var64) * var174;
                  var178 += (var72 - var178) * var176;
                  var180 += (var74 - var180) * var176;
                  var182 += (var76 - var182) * var176;
                  double var184 = Math.atan2(var115, var111 + var86) * var84 + (var168 - 0.5) * 2.2;
                  double var186 = 0.5 + 0.5 * Math.cos(var184);
                  var186 *= var186;
                  var186 *= var186;
                  var186 *= var186;
                  double var188 = var186 * var78 * (1.0 - 0.7 * var170);
                  var178 *= 1.0 - var188 * 0.3;
                  var180 *= 1.0 - var188;
                  var182 *= 1.0 - var188 * 0.62;
                  if (var57) {
                     var178 += (0.975 - var178) * 0.2;
                     var180 += (0.905 - var180) * 0.2;
                     var182 += (0.935 - var182) * 0.2;
                  }

                  double var190 = 1.0 - 0.06 * (1.0 - var172 * var172) * (0.35 + 0.65 * var170) + 0.07 * var90 * (var115 < 0.0 ? -var172 : var172) * var172;
                  double var192 = var58 * (0.97 + 0.06 * var168) * var190 - 1.0;
                  if (var192 < 0.0) {
                     double var194 = -var192 * 2.3;
                     var194 = var194 > 0.55 ? 0.55 : var194;
                     var178 += (0.83 - var178) * var194;
                     var180 += (0.47 - var180) * var194;
                     var182 += (0.6 - var182) * var194;
                  } else {
                     double var255 = var192 * 1.5;
                     var255 = var255 > 0.45 ? 0.45 : var255;
                     var178 += (1.0 - var178) * var255;
                     var180 += (0.975 - var180) * var255;
                     var182 += (0.985 - var182) * var255;
                  }

                  double var257 = 1.0 + var145 / 1.7;
                  var257 = var257 < 0.0 ? 0.0 : (var257 > 1.0 ? 1.0 : var257);
                  var257 = var257 * var257 * 0.3;
                  var178 += (1.0 - var178) * var257;
                  var180 += (0.965 - var180) * var257;
                  var182 += (0.975 - var182) * var257;
                  float var196 = var0[var147 + 3];
                  if (var196 > 0.02F) {
                     double var197 = (double)var196 * 0.11;
                     var178 *= 1.0 - var197 * 0.35;
                     var180 *= 1.0 - var197;
                     var182 *= 1.0 - var197 * 0.7;
                  }

                  double var260 = 1.0 + (var168 - 0.5) * 0.045;
                  var178 *= var260;
                  var180 *= var260;
                  var182 *= var260;
                  var178 = var178 < 0.0 ? 0.0 : (var178 > 1.0 ? 1.0 : var178);
                  var180 = var180 < 0.0 ? 0.0 : (var180 > 1.0 ? 1.0 : var180);
                  var182 = var182 < 0.0 ? 0.0 : (var182 > 1.0 ? 1.0 : var182);
                  float var199 = (float)var208;
                  float var200 = 1.0F - var199;
                  var0[var147] = (float)(var178 * var208) + var0[var147] * var200;
                  var0[var147 + 1] = (float)(var180 * var208) + var0[var147 + 1] * var200;
                  var0[var147 + 2] = (float)(var182 * var208) + var0[var147 + 2] * var200;
                  var0[var147 + 3] = var199 + var0[var147 + 3] * var200;
               }
            }
         }
      }
   }

   private static void y(float[] var0, int var1, int var2, int var3, int var4, int var5, double var6, double var8, double[] var10, int var11, float[] var12) {

      double var13 = var10[-592969997 ^ -592969855];
      double var15 = var10[866145236 ^ 866144935];
      double var17 = var10[-234719351 ^ -234719491];
      double var19 = var10[1066505486 ^ 1066505339];
      double var21 = var10[-1033746975 ^ -1033747305];
      double var23 = var10[-89972842 ^ -89973023];
      double var25 = var10[794825999 ^ 794825847];
      double var27 = var10[-30065722 ^ -30065985];
      double var29 = var10[-213481485 ^ -213481847];
      double var31 = var10[-1938267479 ^ -1938267182];
      double var33 = var10[1874878186 ^ 1874878358];
      double var35 = var10[273547877 ^ 273548056];
      double var37 = var33 * var33 + var35 * var35;
      double var39 = var37 > 1.0E-9 ? 1.0 / var37 : 0.0;
      double var41 = var31 * var31;
      double var43 = var10[-1842246486 ^ -1842246202];
      double var45 = var10[990426919 ^ 990426698];
      double var47 = var10[96686573 ^ 96686214];
      double var49 = 0.92 + -0.18000000000000005 * var47;
      double var51 = 0.4 + -0.27 * var47;
      double var53 = 0.57 + -0.27999999999999997 * var47;
      double var55 = 0.8 + -0.24 * var47;
      double var57 = 0.76 + -0.66 * var47;
      double var59 = 0.42 + -0.19999999999999998 * var47;
      double var61 = 0.97 + -0.35 * var47;
      double var63 = 0.82 + -0.37999999999999995 * var47;
      double var65 = 0.33 + -0.09000000000000002 * var47;
      double var67 = var10[-314533075 ^ -314533310];
      var61 += (0.95 - var61) * 0.45 * var67;
      var63 += (0.8 - var63) * 0.45 * var67;
      var65 += (0.74 - var65) * 0.45 * var67;
      double var69 = 0.95 * (1.0 - 0.3 * var67);
      int var71 = Math.max(var2, (int)Math.floor(var6 - var31));
      int var72 = Math.min(var4, (int)Math.ceil(var6 + var31) + 1);
      int var73 = Math.max(var3, (int)Math.floor(var8 - var31));
      int var74 = Math.min(var5, (int)Math.ceil(var8 + var31) + 1);

      for (int var75 = var73; var75 < var74; var75++) {
         double var76 = (double)var75 + 0.5 - var8;
         int var78 = (var75 - var3) * var1 - var2;

         for (int var79 = var71; var79 < var72; var79++) {
            double var80 = (double)var79 + 0.5 - var6;
            if (!(var80 * var80 + var76 * var76 > var41)) {
               int var82 = var78 + var79 << 2;
               float var83 = var0[var82];
               float var84 = var0[var82 + 1];
               float var85 = var0[var82 + 2];
               float var86 = var0[var82 + 3];
               double var87 = var13 * var80 + var15 * var76;
               double var89 = var17 * var80 + var19 * var76;
               double var91 = Math.sqrt(var87 * var87 + var89 * var89);
               if (var91 < var25 * 1.3 && var86 > 0.0F) {
                  double var93 = var87 * var21 + var89 * var23;
                  double var95 = var89 * var21 - var87 * var23;
                  double var97 = var93 * var93;
                  double var99 = var95 * var95;
                  double var101 = var97 + var99;
                  double var103 = var101 > 1.0E-9 ? var93 * (var97 * var97 - 10.0 * var97 * var99 + 5.0 * var99 * var99) / (var101 * var101 * var91) : 1.0;
                  double var105 = var25 * (0.74 + 0.3 * var103);
                  double var107 = 1.0 - var91 / var105;
                  if (var107 > 0.0) {
                     double var109 = (double)var79 * 0.06 + var43;
                     double var111 = (double)var75 * 0.06 + var45;
                     int var113 = (int)var109;
                     int var114 = (int)var111;
                     double var115 = var109 - (double)var113;
                     double var117 = var111 - (double)var114;
                     var115 = var115 * var115 * (3.0 - 2.0 * var115);
                     var117 = var117 * var117 * (3.0 - 2.0 * var117);
                     int var119 = (var114 & 63) << 6;
                     int var120 = (var114 + 1 & 63) << 6;
                     int var121 = var113 & 63;
                     int var122 = var113 + 1 & 63;
                     double var123 = (double)var12[var119 | var121] + (double)(var12[var119 | var122] - var12[var119 | var121]) * var115;
                     double var125 = (double)var12[var120 | var121] + (double)(var12[var120 | var122] - var12[var120 | var121]) * var115;
                     double var127 = var123 + (var125 - var123) * var117;
                     var107 = var107 * var107 * (3.0 - 2.0 * var107) * var27 * (double)var86 * (0.85 + 0.3 * var127);
                     float var129 = (float)var107;
                     float var130 = 1.0F - var129;
                     var83 = (float)(var49 * var107) + var83 * var130;
                     var84 = (float)(var51 * var107) + var84 * var130;
                     var85 = (float)(var53 * var107) + var85 * var130;
                     var86 = var129 + var86 * var130;
                  }
               }

               if (var91 < var29 + 2.0) {
                  double var134 = (var29 - var91) * 0.8 + 0.5;
                  var134 = var134 < 0.0 ? 0.0 : (var134 > 1.0 ? 1.0 : var134);
                  var134 *= 0.92;
                  double var142 = 0.8 + 0.2 * (1.0 - var91 / (var29 + 2.0));
                  float var146 = (float)var134;
                  float var98 = 1.0F - var146;
                  var83 = (float)(var55 * var142 * var134) + var83 * var98;
                  var84 = (float)(var57 * var142 * var134) + var84 * var98;
                  var85 = (float)(var59 * var142 * var134) + var85 * var98;
                  var86 = var146 + var86 * var98;
               }

               for (int var137 = 0; var137 < var11; var137++) {
                  int var94 = 110 + var137 * 10;
                  if (!(var80 < var10[var94 + 6]) && !(var80 > var10[var94 + 8]) && !(var76 < var10[var94 + 7]) && !(var76 > var10[var94 + 9])) {
                     double var143 = var80 - var10[var94];
                     double var147 = var76 - var10[var94 + 1];
                     double var150 = var10[var94 + 2];
                     double var153 = var10[var94 + 3];
                     double var158 = (var143 * var150 + var147 * var153) * var10[var94 + 4];
                     var158 = var158 < 0.0 ? 0.0 : (var158 > 1.0 ? 1.0 : var158);
                     double var164 = var143 - var150 * var158;
                     double var169 = var147 - var153 * var158;
                     double var173 = Math.sqrt(var164 * var164 + var169 * var169);
                     double var176 = (0.42 - var173) / 0.9 + 0.5;
                     if (!(var176 <= 0.0)) {
                        var176 = (var176 > 1.0 ? 1.0 : var176) * (0.5 + 0.45 * var158);
                        double var181 = (1.0 - var158) * (0.25 + 0.5 * var47);
                        double var183 = 0.985 + (var49 - 0.985) * var181;
                        double var185 = 0.955 + (var51 - 0.955) * var181;
                        double var186 = 0.955 + (var53 - 0.955) * var181;
                        float var187 = (float)var176;
                        float var188 = 1.0F - var187;
                        var83 = (float)(var183 * var176) + var83 * var188;
                        var84 = (float)(var185 * var176) + var84 * var188;
                        var85 = (float)(var186 * var176) + var85 * var188;
                        var86 = var187 + var86 * var188;
                     }
                  }
               }

               if (var39 > 0.0) {
                  double var138 = (var80 * var33 + var76 * var35) * var39;
                  var138 = var138 < 0.0 ? 0.0 : (var138 > 1.0 ? 1.0 : var138);
                  double var144 = var80 - var33 * var138;
                  double var148 = var76 - var35 * var138;
                  double var151 = Math.sqrt(var144 * var144 + var148 * var148);
                  double var154 = (0.5 - var151) / 0.9 + 0.5;
                  double var160 = var80 - var33;
                  double var165 = var76 - var35;
                  double var170 = Math.sqrt(var160 * var160 + var165 * var165);
                  double var174 = (1.15 - var170) / 0.9 + 0.5;
                  var154 = var154 > var174 ? var154 : var174;
                  if (var154 > 0.0) {
                     var154 = (var154 > 1.0 ? 1.0 : var154) * 0.9;
                     float var178 = (float)var154;
                     float var112 = 1.0F - var178;
                     var83 = (float)(0.84 * var154) + var83 * var112;
                     var84 = (float)(0.9 * var154) + var84 * var112;
                     var85 = (float)(0.6 * var154) + var85 * var112;
                     var86 = var178 + var86 * var112;
                  }
               }

               for (int var140 = 0; var140 < var11; var140++) {
                  int var141 = 110 + var140 * 10;
                  if (!(var80 < var10[var141 + 6]) && !(var80 > var10[var141 + 8]) && !(var76 < var10[var141 + 7]) && !(var76 > var10[var141 + 9])) {
                     double var145 = var80 - var10[var141] - var10[var141 + 2];
                     double var149 = var76 - var10[var141 + 1] - var10[var141 + 3];
                     double var152 = var10[var141 + 5];
                     double var157 = Math.sqrt(var145 * var145 + var149 * var149);
                     double var161 = (var152 - var157) / 0.9 + 0.5;
                     if (!(var161 <= 0.0)) {
                        var161 = var161 > 1.0 ? 1.0 : var161;
                        double var166 = -(var145 * 0.6 + var149 * 0.8) / var152 * 0.5 + 0.5;
                        var166 = var166 < 0.0 ? 0.0 : (var166 > 1.0 ? 1.0 : var166);
                        double var171 = var157 / var152;
                        var171 = var171 > 1.0 ? 1.0 : var171;
                        double var175 = (0.72 + 0.4 * var166) * (1.0 - 0.3 * var171 * var171);
                        var161 *= var69;
                        float var179 = (float)var161;
                        float var180 = 1.0F - var179;
                        var83 = (float)(Math.min(1.0, var61 * var175) * var161) + var83 * var180;
                        var84 = (float)(Math.min(1.0, var63 * var175) * var161) + var84 * var180;
                        var85 = (float)(Math.min(1.0, var65 * var175) * var161) + var85 * var180;
                        var86 = var179 + var86 * var180;
                     }
                  }
               }

               var0[var82] = var83;
               var0[var82 + 1] = var84;
               var0[var82 + 2] = var85;
               var0[var82 + 3] = var86;
            }
         }
      }
   }

   private static void z(float[] var0, int var1, int var2, int var3, int var4, int var5, double var6, double var8, double[] var10) {

      double var11 = var6 + var10[413882521 ^ 413882855];
      double var13 = var8 + var10[1289336371 ^ 1289336652];
      double var15 = var10[-1228779925 ^ -1228779541];
      double var17 = var10[-1228040150 ^ -1228039765];
      double var19 = var10[113754078 ^ 113753692];
      double var21 = var10[1268522078 ^ 1268522461];
      double var23 = var10[-1316036703 ^ -1316037083];
      double var25 = var10[-1120545053 ^ -1120544922];
      double var27 = var10[325166273 ^ 325166407];
      double var29 = var19 + 2.0;
      int var31 = Math.max(var2, (int)Math.floor(Math.min(var11, var6) - var29));
      int var32 = Math.min(var4, (int)Math.ceil(Math.max(var11, var6) + var29) + 1);
      int var33 = Math.max(var3, (int)Math.floor(Math.min(var13, var8) - var29));
      int var34 = Math.min(var5, (int)Math.ceil(Math.max(var13, var8) + var29) + 1);
      double var35 = -var23 * -0.3 + var21 * -0.78;

      for (int var37 = var33; var37 < var34; var37++) {
         double var38 = (double)var37 + 0.5 - var13;
         int var40 = (var37 - var3) * var1 - var2;

         for (int var41 = var31; var41 < var32; var41++) {
            double var42 = (double)var41 + 0.5 - var11;
            double var44 = var42 * var21 + var38 * var23;
            double var46 = var42 * -var23 + var38 * var21;
            double var48 = var46 < 0.0 ? -var46 : var46;
            double var50 = -var25 * var48 + var27 * var44;
            double var52;
            if (var50 < 0.0) {
               var52 = Math.sqrt(var48 * var48 + var44 * var44) - var17;
            } else if (var50 > var27 * var15) {
               double var54 = var44 - var15;
               var52 = Math.sqrt(var48 * var48 + var54 * var54) - var19;
            } else {
               var52 = var48 * var27 + var44 * var25 - var17;
            }

            double var71 = 0.5 - var52 / 1.1;
            if (!(var71 <= 0.0)) {
               var71 = var71 > 1.0 ? 1.0 : var71;
               double var56 = var46 / (var19 + 0.5);
               var56 = var56 < -1.0 ? -1.0 : (var56 > 1.0 ? 1.0 : var56);
               double var58 = var56 * var35 + Math.sqrt(1.0 - var56 * var56) * 0.55;
               double var60 = (var58 + 0.3) / 1.15;
               var60 = var60 < 0.0 ? 0.0 : (var60 > 1.0 ? 1.0 : var60);
               double var62 = 0.33 + 0.33 * var60;
               double var64 = 0.15 + 0.19 * var60;
               double var66 = 0.12 + 0.12 * var60;
               int var68 = var40 + var41 << 2;
               float var69 = (float)var71;
               float var70 = 1.0F - var69;
               var0[var68] = (float)(var62 * var71) + var0[var68] * var70;
               var0[var68 + 1] = (float)(var64 * var71) + var0[var68 + 1] * var70;
               var0[var68 + 2] = (float)(var66 * var71) + var0[var68 + 2] * var70;
               var0[var68 + 3] = var69 + var0[var68 + 3] * var70;
            }
         }
      }
   }

   private static void aa(
      float[] var0, int var1, int var2, int var3, int var4, int var5, double var6, double var8, double[] var10, double var11, double var13, double var15
   ) {

      double var17 = var10[766511980 ^ 766511646];
      double var19 = var10[215870374 ^ 215870165];
      double var21 = var10[-381730800 ^ -381730460];
      double var23 = var10[-653451822 ^ -653452121];
      double var25 = 0.36 * var11;
      double var27 = 0.1 * var11;
      double var29 = 0.14 * var11;
      double var31 = -Math.cos(var13) * 0.5 * var11;
      double var33 = -Math.sin(var13) * 0.5 * var11;
      double var35 = var31 * var31 + var33 * var33;
      double var37 = Math.max(1.0, 0.045 * var11);
      double var39 = Math.max(var25, Math.sqrt(var35) + var37) + 3.0;
      int var41 = Math.max(var2, (int)Math.floor(var6 - var39));
      int var42 = Math.min(var4, (int)Math.ceil(var6 + var39) + 1);
      int var43 = Math.max(var3, (int)Math.floor(var8 - var39));
      int var44 = Math.min(var5, (int)Math.ceil(var8 + var39) + 1);

      for (int var45 = var43; var45 < var44; var45++) {
         double var46 = (double)var45 + 0.5 - var8;
         int var48 = (var45 - var3) * var1 - var2;

         for (int var49 = var41; var49 < var42; var49++) {
            double var50 = (double)var49 + 0.5 - var6;
            double var52 = var17 * var50 + var19 * var46;
            double var54 = var21 * var50 + var23 * var46;
            double var56 = Math.sqrt(var52 * var52 + var54 * var54);
            int var58 = var48 + var49 << 2;
            float var59 = var0[var58];
            float var60 = var0[var58 + 1];
            float var61 = var0[var58 + 2];
            float var62 = var0[var58 + 3];
            double var63 = -1.0E9;
            double var65 = 0.0;

            for (int var67 = 0; var67 < 5; var67++) {
               double var68 = var15 + 0.63 + (double)var67 * (Math.PI * 2.0 / 5.0);
               double var70 = Math.cos(var68);
               double var72 = Math.sin(var68);
               double var74 = var52 * var70 + var54 * var72;
               if (!(var74 < 0.0) && !(var74 > var25)) {
                  double var76 = -var52 * var72 + var54 * var70;
                  double var78 = var74 / var25;
                  double var80 = var27 * Math.sin(Math.PI * Math.pow(var78, 0.65)) * (1.0 - 0.15 * var78) + 0.3;
                  double var82 = var80 - (var76 < 0.0 ? -var76 : var76);
                  if (var82 > var63) {
                     var63 = var82;
                     var65 = var78;
                  }
               }
            }

            if (var63 > -1.0) {
               double var85 = var63 * 0.85 / 1.1 + 0.5;
               if (var85 > 0.0) {
                  var85 = var85 > 1.0 ? 1.0 : var85;
                  double var69 = 0.75 + 0.35 * (1.0 - var65) - 0.1 * (var54 > 0.0 ? 1.0 : 0.0);
                  float var71 = (float)var85;
                  float var94 = 1.0F - var71;
                  var59 = (float)(0.5 * var69 * var85) + var59 * var94;
                  var60 = (float)(0.27 * var69 * var85) + var60 * var94;
                  var61 = (float)(0.2 * var69 * var85) + var61 * var94;
                  var62 = var71 + var62 * var94;
               }
            }

            double var87 = (var29 - var56) * 0.85 / 1.1 + 0.5;
            if (var87 > 0.0) {
               var87 = var87 > 1.0 ? 1.0 : var87;
               double var89 = 0.8 + 0.3 * (1.0 - var56 / var29) - 0.12 * (var46 / var29);
               float var92 = (float)var87;
               float var95 = 1.0F - var92;
               var59 = (float)(0.46 * var89 * var87) + var59 * var95;
               var60 = (float)(0.22 * var89 * var87) + var60 * var95;
               var61 = (float)(0.17 * var89 * var87) + var61 * var95;
               var62 = var92 + var62 * var95;
            }

            if (var35 > 1.0E-6) {
               double var90 = (var50 * var31 + var46 * var33) / var35;
               var90 = var90 < 0.0 ? 0.0 : (var90 > 1.0 ? 1.0 : var90);
               double var93 = var50 - var31 * var90;
               double var73 = var46 - var33 * var90;
               double var75 = Math.sqrt(var93 * var93 + var73 * var73) - var37 * (1.0 - 0.25 * var90);
               double var77 = 0.5 - var75 / 1.1;
               if (var77 > 0.0 && var90 > 0.05) {
                  var77 = var77 > 1.0 ? 1.0 : var77;
                  double var79 = (var93 * -var33 + var73 * var31) / (Math.sqrt(var35) * var37);
                  double var81 = 0.8 - 0.25 * var79;
                  float var83 = (float)var77;
                  float var84 = 1.0F - var83;
                  var59 = (float)(0.46 * var81 * var77) + var59 * var84;
                  var60 = (float)(0.36 * var81 * var77) + var60 * var84;
                  var61 = (float)(0.22 * var81 * var77) + var61 * var84;
                  var62 = var83 + var62 * var84;
               }
            }

            var0[var58] = var59;
            var0[var58 + 1] = var60;
            var0[var58 + 2] = var61;
            var0[var58 + 3] = var62;
         }
      }
   }

   private static void ab(float[] var0, double[] var1, int var2, float[] var3) {

      double var4 = var1[var2 + 0];
      double var6 = var1[var2 + 1];
      double var8 = var1[var2 + 2];
      double var10 = var1[var2 + 5];
      double var12 = var1[var2 + 8];
      double var14 = 2.0 * var8;
      double var16 = Math.cos(var10);
      double var18 = Math.sin(var10);
      double var20 = 0.31 * var14;
      double var22 = 0.37 * var14;
      double var24 = 0.05 * var14;
      double var26 = 0.95 * var14 - var24;
      double var28 = var26 - var22;
      double var30 = (var20 - var24) / var28;
      double var32 = Math.sqrt(1.0 - var30 * var30);
      double var34 = 0.1 * var14;
      double var36 = -0.02 * var14;
      double var38 = 0.2 * var14;
      double var40 = 0.14 * var14;
      double var42 = var40 - var36;
      double var44 = (var34 - var38) / var42;
      double var46 = Math.sqrt(1.0 - var44 * var44);
      double var48 = -var18 * -0.3 + var16 * -0.78;
      double var50 = var1[var2 + 19] % 2.0 == 0.0 ? 1.0 : -1.0;
      double var52 = 0.955;
      double var54 = 0.68 + 0.12 * var12;
      double var56 = 0.77 + 0.07 * var12;
      double var58 = 0.93;
      double var60 = 0.52 + 0.14 * var12;
      double var62 = 0.66 + 0.08 * var12;
      double var64 = 0.86 + 0.05 * var12;
      double var66 = 0.36 + 0.14 * var12;
      double var68 = 0.53 + 0.08 * var12;
      double var70 = var4 + var16 * 0.45 * var14;
      double var72 = var6 + var18 * 0.45 * var14;
      double var74 = 0.62 * var14 + 3.0;
      int var76 = Math.max(0, (int)Math.floor(var70 - var74));
      int var77 = Math.min(-969739875 ^ -969738851, (int)Math.ceil(var70 + var74) + 1);
      int var78 = Math.max(0, (int)Math.floor(var72 - var74));
      int var79 = Math.min(1754440352 ^ 1754439840, (int)Math.ceil(var72 + var74) + 1);

      for (int var80 = var78; var80 < var79; var80++) {
         for (int var81 = var76; var81 < var77; var81++) {
            double var82 = (double)var81 + 0.5 - var4;
            double var84 = (double)var80 + 0.5 - var6;
            double var86 = var82 * var16 + var84 * var18;
            double var88 = -var82 * var18 + var84 * var16;
            double var90 = var88 < 0.0 ? -var88 : var88;
            float var92 = 0.0F;
            float var93 = 0.0F;
            float var94 = 0.0F;
            float var95 = 0.0F;
            double var96 = var86 - var22;
            double var98 = -var30 * var90 + var32 * var96;
            double var100;
            if (var98 < 0.0) {
               var100 = Math.sqrt(var90 * var90 + var96 * var96) - var20;
            } else if (var98 > var32 * var28) {
               double var102 = var96 - var28;
               var100 = Math.sqrt(var90 * var90 + var102 * var102) - var24;
            } else {
               var100 = var90 * var32 + var96 * var30 - var20;
            }

            double var134 = 0.5 - var100 / 1.1;
            if (var134 > 0.0) {
               var134 = var134 > 1.0 ? 1.0 : var134;
               double var104 = var86 / var14;
               var104 = var104 < 0.0 ? 0.0 : (var104 > 1.0 ? 1.0 : var104);
               double var106 = var20 * (1.0 - var104 * var104 * 0.9) + 0.5;
               double var108 = var88 / var106;
               var108 = var108 < -1.0 ? -1.0 : (var108 > 1.0 ? 1.0 : var108);
               double var110 = var108 * var48 + Math.sqrt(1.0 - var108 * var108) * 0.55;
               double var112 = (var104 - 0.1) * 2.2;
               var112 = var112 < 0.0 ? 0.0 : (var112 > 1.0 ? 1.0 : var112);
               double var114 = (var104 - 0.5) * 2.2;
               var114 = var114 < 0.0 ? 0.0 : (var114 > 1.0 ? 1.0 : var114);
               double var116 = var52 + (var58 - var52) * var112;
               double var118 = var54 + (var60 - var54) * var112;
               double var120 = var56 + (var62 - var56) * var112;
               var116 += (var64 - var116) * var114;
               var118 += (var66 - var118) * var114;
               var120 += (var68 - var120) * var114;
               double var122 = 0.86 + 0.3 * (var110 - 0.2);
               var116 *= var122;
               var118 *= var122;
               var120 *= var122;
               double var124 = (var110 - 0.72) / 0.25;
               var124 = var124 < 0.0 ? 0.0 : (var124 > 1.0 ? 1.0 : var124);
               var124 *= 0.45;
               var116 += (1.0 - var116) * var124;
               var118 += (0.88 - var118) * var124;
               var120 += (0.92 - var120) * var124;
               double var126 = var50 * (0.62 - 1.25 * var104) * var106;
               double var128 = var88 - var126;
               var128 = var128 < 0.0 ? -var128 : var128;
               double var130 = (0.9 - var128) / 0.9;
               if (var130 > 0.0 && var104 > 0.16 && var104 < 0.86) {
                  var130 *= 0.4;
                  var116 += (0.72 - var116) * var130;
                  var118 += (0.22 - var118) * var130;
                  var120 += (0.4 - var120) * var130;
               }

               double var132 = 1.0 + var100 / 1.6;
               var132 = var132 < 0.0 ? 0.0 : (var132 > 1.0 ? 1.0 : var132);
               var132 = var132 * var132 * 0.3;
               var116 += (0.78 - var116) * var132;
               var118 += (0.3 - var118) * var132;
               var120 += (0.47 - var120) * var132;
               var116 = var116 > 1.0 ? 1.0 : (var116 < 0.0 ? 0.0 : var116);
               var118 = var118 > 1.0 ? 1.0 : (var118 < 0.0 ? 0.0 : var118);
               var120 = var120 > 1.0 ? 1.0 : (var120 < 0.0 ? 0.0 : var120);
               var92 = (float)(var116 * var134);
               var93 = (float)(var118 * var134);
               var94 = (float)(var120 * var134);
               var95 = (float)var134;
            }

            double var137 = var86 - var36;
            double var138 = -var44 * var90 + var46 * var137;
            double var140;
            if (var138 < 0.0) {
               var140 = Math.sqrt(var90 * var90 + var137 * var137) - var34;
            } else if (var138 > var46 * var42) {
               double var142 = var137 - var42;
               var140 = Math.sqrt(var90 * var90 + var142 * var142) - var38;
            } else {
               var140 = var90 * var46 + var137 * var44 - var34;
            }

            double var143 = var40 + 0.06 * var14 - var90 * 0.5;
            double var145 = var86 - var143;
            var140 = var140 > var145 ? var140 : var145;
            double var147 = 0.5 - var140 / 1.1;
            if (var147 > 0.0) {
               var147 = var147 > 1.0 ? 1.0 : var147;
               double var154 = var88 / (var38 + 0.5);
               var154 = var154 < -1.0 ? -1.0 : (var154 > 1.0 ? 1.0 : var154);
               double var162 = var154 * var48 + Math.sqrt(1.0 - var154 * var154) * 0.55;
               double var168 = (var162 + 0.3) / 1.15;
               var168 = var168 < 0.0 ? 0.0 : (var168 > 1.0 ? 1.0 : var168);
               double var170 = 0.35 + 0.31 * var168;
               double var173 = 0.17 + 0.18 * var168;
               double var174 = 0.13 + 0.11 * var168;
               float var176 = (float)var147;
               float var129 = 1.0F - var176;
               var92 = (float)(var170 * var147) + var92 * var129;
               var93 = (float)(var173 * var147) + var93 * var129;
               var94 = (float)(var174 * var147) + var94 * var129;
               var95 = var176 + var95 * var129;
            }

            if (!(var95 <= 0.0F)) {
               int var156 = var80 * (1825551333 ^ 1825552357) + var81 << 2;
               float var117 = 1.0F - var95;
               var0[var156] = var92 + var0[var156] * var117;
               var0[var156 + 1] = var93 + var0[var156 + 1] * var117;
               var0[var156 + 2] = var94 + var0[var156 + 2] * var117;
               var0[var156 + 3] = var95 + var0[var156 + 3] * var117;
            }
         }
      }
   }

   private static void ac(float[] var0, double[] var1, int var2) {

      double var3 = var1[var2 + 12];
      double var5 = var1[var2 + 13];
      double var7 = var1[var2 + 14];
      double var9 = var1[var2 + 15];
      double var11 = var1[var2 + 16];
      double var13 = var1[var2 + 17];
      double var15 = var1[var2 + 18];
      double var17 = var15 * 0.78;
      byte var19 = 6;
      double[] var20 = new double[var19 + 1];
      double[] var21 = new double[var19 + 1];
      double var22 = 1.0E9;
      double var24 = 1.0E9;
      double var26 = -1.0E9;
      double var28 = -1.0E9;

      for (int var30 = 0; var30 <= var19; var30++) {
         double var31 = (double)var30 / (double)var19;
         double var33 = 1.0 - var31;
         var20[var30] = var33 * var33 * var3 + 2.0 * var33 * var31 * var7 + var31 * var31 * var11;
         var21[var30] = var33 * var33 * var5 + 2.0 * var33 * var31 * var9 + var31 * var31 * var13;
         var22 = Math.min(var22, var20[var30]);
         var24 = Math.min(var24, var21[var30]);
         var26 = Math.max(var26, var20[var30]);
         var28 = Math.max(var28, var21[var30]);
      }

      int var73 = Math.max(0, (int)Math.floor(var22 - var15 - 2.0));
      int var74 = Math.min(591041977 ^ 591040953, (int)Math.ceil(var26 + var15 + 2.0));
      int var32 = Math.max(0, (int)Math.floor(var24 - var15 - 2.0));
      int var75 = Math.min(-1131686169 ^ -1131686681, (int)Math.ceil(var28 + var15 + 2.0));

      for (int var34 = var32; var34 < var75; var34++) {
         double var35 = (double)var34 + 0.5;

         for (int var37 = var73; var37 < var74; var37++) {
            double var38 = (double)var37 + 0.5;
            double var40 = 1.0E9;
            double var42 = 0.0;
            double var44 = 0.0;

            for (int var46 = 0; var46 < var19; var46++) {
               double var47 = var20[var46 + 1] - var20[var46];
               double var49 = var21[var46 + 1] - var21[var46];
               double var51 = var47 * var47 + var49 * var49;
               if (!(var51 < 1.0E-9)) {
                  double var53 = var38 - var20[var46];
                  double var55 = var35 - var21[var46];
                  double var57 = (var53 * var47 + var55 * var49) / var51;
                  var57 = var57 < 0.0 ? 0.0 : (var57 > 1.0 ? 1.0 : var57);
                  double var59 = var53 - var47 * var57;
                  double var61 = var55 - var49 * var57;
                  double var63 = ((double)var46 + var57) / (double)var19;
                  double var65 = var15 + (var17 - var15) * var63;
                  double var67 = Math.sqrt(var59 * var59 + var61 * var61) - var65;
                  if (var67 < var40) {
                     var40 = var67;
                     double var69 = 1.0 / Math.sqrt(var51);
                     double var71 = (var47 * var55 - var49 * var53) * var69 / var65;
                     var71 = var71 < -1.0 ? -1.0 : (var71 > 1.0 ? 1.0 : var71);
                     var42 = var71 * (-var49 * -0.3 + var47 * -0.78) * var69 + Math.sqrt(1.0 - var71 * var71) * 0.55;
                     var44 = var63;
                  }
               }
            }

            double var76 = 0.5 - var40 / 1.1;
            if (!(var76 <= 0.0)) {
               var76 = var76 > 1.0 ? 1.0 : var76;
               double var48 = (var42 + 0.3) / 1.15;
               var48 = var48 < 0.0 ? 0.0 : (var48 > 1.0 ? 1.0 : var48);
               double var50 = 0.33 + 0.27 * var48 + 0.07 * var44;
               double var52 = 0.17 + 0.18 * var48 + 0.15 * var44;
               double var54 = 0.13 + 0.1 * var48 + 0.05 * var44;
               int var56 = var34 * (-2029802190 ^ -2029803214) + var37 << 2;
               float var80 = (float)var76;
               float var58 = 1.0F - var80;
               var0[var56] = (float)(var50 * var76) + var0[var56] * var58;
               var0[var56 + 1] = (float)(var52 * var76) + var0[var56 + 1] * var58;
               var0[var56 + 2] = (float)(var54 * var76) + var0[var56 + 2] * var58;
               var0[var56 + 3] = var80 + var0[var56 + 3] * var58;
            }
         }
      }
   }

   private static void ad(int[] var0, float[] var1, float[] var2, double[] var3, float[] var4) {

      int var5 = 1815518123 ^ 1815517995;
      float[] var6 = new float[65536];
      float[] var7 = new float[16384];
      float[] var8 = new float[4096];
      float[] var9 = new float[1024];
      float[] var10 = new float[16384];
      float[] var11 = new float[16384];
      double[] var12 = new double[23];
      int[] var13 = new int[16384];
      double[] var14 = new double[]{0.1, 0.3, 0.04, 0.46};
      double[] var15 = new double[]{0.3, -0.35, 0.6, -0.1};
      double[] var16 = new double[]{0.17, 0.22, 0.13, 0.19};
      double[] var17 = new double[]{0.12, 0.55, 0.95, 1.32, 2.6};

      for (int var18 = 0; var18 < 34; var18++) {
         for (int var19 = 0; var19 < (-775430630 ^ -775430502); var19++) {
            Arrays.fill(var1, var19 * (-1902167455 ^ -1902166431) << 2, var19 * (-1149097594 ^ -1149096570) + (-1902837519 ^ -1902837647) << 2, 0.0F);
         }

         if (var18 < 20) {
            int var21 = var18 / 5;
            int var20 = var18 % 5;
            Arrays.fill(var12, 0.0);
            var12[0] = 64.0;
            var12[1] = 64.0;
            var12[2] = 50.0;
            var12[3] = 0.37 + (double)var21 * 1.13;
            var12[4] = var17[var20];
            var12[5] = Math.PI / 2;
            var12[6] = var20 == 4 ? 0.24 : var16[var21];
            var12[7] = 0.0;
            var12[8] = var14[var21];
            var12[9] = var15[var21];
            var12[19] = (double)((1575096543 ^ 1575095856) + var21 * (1226781518 ^ 1226746455));
            var12[11] = 1.0;
            var12[22] = -1.0;
            v(var1, var2, var12, 0, var3, var4);
         } else if (var18 < 32) {
            ae(var1, var3, var4, var18 - 20 >> 1, (var18 - 20 & 1) != 0);
         } else if (var18 == 32) {
            af(var1);
         } else {
            ag(var1);
         }

         for (int var22 = 0; var22 < (35264227 ^ 35264099); var22++) {
            System.arraycopy(var1, var22 * (-966801893 ^ -966802917) << 2, var6, var22 * (467991243 ^ 467991115) << 2, 2097357397 ^ 2097356885);
         }

         ah(var6, 1576489385 ^ 1576489257, var7);
         ah(var7, 64, var8);
         ah(var8, 32, var9);
         aj(
            var6,
            -621420627 ^ -621420755,
            var0,
            (var18 & 7) * (-2129385338 ^ -2129385466),
            (-378216011 ^ -378214987) + (var18 >> 3) * (-1605100467 ^ -1605100339),
            var13
         );
         aj(var7, 64, var0, (var18 & 15) * 64, (-1392977791 ^ -1392976383) + (var18 >> 4) * 64, var13);
         aj(var8, 32, var0, (var18 & 31) * 32, (-1143307981 ^ -1143306637) + (var18 >> 5) * 32, var13);
         aj(var9, 16, var0, var18 * 16, -1956182279 ^ -1956183687, var13);
         int var23 = var18 >= 20 && var18 < 32 ? var18 - 20 : (var18 < 20 && var18 % 5 == 0 ? 12 + var18 / 5 : -1);
         if (var23 >= 0) {
            ai(var7, 64, var10, var11, 2.6);
            aj(var10, 64, var0, var23 * 64, 630236337 ^ 630235937, var13);
         }
      }
   }

   private static void ae(float[] var0, double[] var1, float[] var2, int var3, boolean var4) {

      double[] var5 = new double[]{0.4, 0.37, 0.43, 0.39, 0.41, 0.36};
      double[] var6 = new double[]{0.07, 0.05, 0.09, 0.06, 0.1, 0.045};
      double[] var7 = new double[]{0.0, 0.09, -0.07, 0.12, -0.11, 0.04};
      double[] var8 = new double[]{0.02, -0.06, 0.08, -0.03, 0.05, -0.08};
      double[] var9 = new double[]{0.12, 0.3, 0.05, 0.4, 0.2, 0.08};
      double[] var10 = new double[]{0.2, -0.3, 0.5, 0.0, -0.1, 0.35};
      Random var11 = new Random(31337L + (long)var3 * 7717L);
      w(var1, var9[var3], var10[var3], var11);
      double var12 = 104.0;
      double var14 = var5[var3] * var12;
      double var16 = 0.085 * var12;
      double var18 = var12 - var16 - var14;
      double var20 = (var16 - var14) / var18;
      byte var22 = 0;
      var1[var22 + 0] = 0.0;
      var1[var22 + 1] = var12 * 0.5;
      var1[var22 + 2] = 1.0;
      var1[var22 + 3] = 0.0;
      var1[var22 + 4] = 0.0;
      var1[var22 + 5] = -1.0;
      var1[var22 + 6] = var16;
      var1[var22 + 7] = var14;
      var1[var22 + 8] = var18;
      var1[var22 + 9] = var20;
      var1[var22 + 10] = Math.sqrt(1.0 - var20 * var20);
      double var23 = var6[var3] * var12;
      var1[var22 + 12] = var23;
      var1[var22 + 11] = var12 + 0.3 * var23;
      var1[var22 + 13] = var12;
      var1[var22 + 14] = var4 ? 0.97 : 1.02;
      var1[var22 + 15] = var4 ? 1.0 : 0.0;
      var1[var22 + 16] = 0.0;
      var1[var22 + 17] = var7[var3];
      var1[var22 + 18] = var8[var3];
      var1[var22 + 19] = 0.0;
      var1[var22 + 20] = 0.0;
      double var25 = 0.5 * var12;
      double var27 = 1.1 * var14 + 0.1 * var12;
      double var29 = Math.sqrt(var25 * var25 + var27 * var27) + 4.5;
      var1[var22 + 21] = var29 * var29;
      x(var0, 800858676 ^ 800859700, 0, 0, 2012541942 ^ 2012541814, -1857639974 ^ -1857640102, 64.0, 64.0, var1, var22, var2);
   }

   private static void af(float[] var0) {

      double var1 = 20.0;

      for (int var3 = 36; var3 < 92; var3++) {
         for (int var4 = 36; var4 < 92; var4++) {
            double var5 = ((double)var4 + 0.5 - 64.0) / var1;
            double var7 = ((double)var3 + 0.5 - 64.0) / var1;
            double var9 = Math.sqrt(var5 * var5 + var7 * var7);
            double var11 = (1.0 - var9) * var1 / 1.1 + 0.5;
            if (!(var11 <= 0.0)) {
               var11 = var11 > 1.0 ? 1.0 : var11;
               double var13 = 0.42 + 0.3 * var9 * var9;
               double var15 = var9 > 0.72 ? (var9 - 0.72) / 0.28 : 0.0;
               double var17 = 0.78 - 0.3 * var15;
               double var19 = 0.85 - 0.28 * var15;
               double var21 = 0.96 - 0.2 * var15;
               double var23 = var5 + 0.36;
               double var25 = var7 + 0.38;
               double var27 = 1.0 - Math.sqrt(var23 * var23 + var25 * var25) / 0.3;
               if (var27 > 0.0) {
                  var27 = var27 * var27 * (3.0 - 2.0 * var27);
                  var17 += (1.0 - var17) * var27;
                  var19 += (1.0 - var19) * var27;
                  var21 += (1.0 - var21) * var27;
                  var13 += (1.0 - var13) * var27;
               }

               double var29 = var13 * var11;
               int var31 = var3 * (424961624 ^ 424960600) + var4 << 2;
               var0[var31] = (float)(var17 * var29);
               var0[var31 + 1] = (float)(var19 * var29);
               var0[var31 + 2] = (float)(var21 * var29);
               var0[var31 + 3] = (float)var29;
            }
         }
      }
   }

   private static void ag(float[] var0) {

      for (int var1 = 0; var1 < (771458401 ^ 771458529); var1++) {
         for (int var2 = 0; var2 < (2143660657 ^ 2143660785); var2++) {
            double var3 = ((double)var2 + 0.5 - 64.0) / 52.0;
            double var5 = ((double)var1 + 0.5 - 64.0) / 52.0;
            double var7 = var3 * var3 + var5 * var5;
            if (!(var7 >= 1.0)) {
               double var9 = Math.exp(-var7 * 5.0) * (1.0 - var7);
               int var11 = var1 * (-1366562783 ^ -1366561759) + var2 << 2;
               var0[var11] = (float)var9;
               var0[var11 + 1] = (float)var9;
               var0[var11 + 2] = (float)var9;
               var0[var11 + 3] = (float)var9;
            }
         }
      }
   }

   private static void ah(float[] var0, int var1, float[] var2) {

      int var3 = var1 >> 1;

      for (int var4 = 0; var4 < var3; var4++) {
         for (int var5 = 0; var5 < var3; var5++) {
            int var6 = 2 * var4 * var1 + 2 * var5 << 2;
            int var7 = var6 + 4;
            int var8 = var6 + (var1 << 2);
            int var9 = var8 + 4;
            int var10 = var4 * var3 + var5 << 2;

            for (int var11 = 0; var11 < 4; var11++) {
               var2[var10 + var11] = 0.25F * (var0[var6 + var11] + var0[var7 + var11] + var0[var8 + var11] + var0[var9 + var11]);
            }
         }
      }
   }

   private static void ai(float[] var0, int var1, float[] var2, float[] var3, double var4) {

      int var6 = (int)Math.ceil(var4 * 3.0);
      float[] var7 = new float[2 * var6 + 1];
      float var8 = 0.0F;

      for (int var9 = -var6; var9 <= var6; var9++) {
         var7[var9 + var6] = (float)Math.exp((double)(-(var9 * var9)) / (2.0 * var4 * var4));
         var8 += var7[var9 + var6];
      }

      for (int var23 = 0; var23 < var7.length; var23++) {
         var7[var23] /= var8;
      }

      for (int var24 = 0; var24 < 2; var24++) {
         float[] var10 = var24 == 0 ? var0 : var3;
         float[] var11 = var24 == 0 ? var3 : var2;

         for (int var12 = 0; var12 < var1; var12++) {
            for (int var13 = 0; var13 < var1; var13++) {
               float var14 = 0.0F;
               float var15 = 0.0F;
               float var16 = 0.0F;
               float var17 = 0.0F;

               for (int var18 = -var6; var18 <= var6; var18++) {
                  int var19 = var24 == 0 ? var13 + var18 : var13;
                  int var20 = var24 == 0 ? var12 : var12 + var18;
                  if (var19 >= 0 && var20 >= 0 && var19 < var1 && var20 < var1) {
                     int var21 = var20 * var1 + var19 << 2;
                     float var22 = var7[var18 + var6];
                     var14 += var10[var21] * var22;
                     var15 += var10[var21 + 1] * var22;
                     var16 += var10[var21 + 2] * var22;
                     var17 += var10[var21 + 3] * var22;
                  }
               }

               int var25 = var12 * var1 + var13 << 2;
               var11[var25] = var14;
               var11[var25 + 1] = var15;
               var11[var25 + 2] = var16;
               var11[var25 + 3] = var17;
            }
         }
      }
   }

   private static void aj(float[] var0, int var1, int[] var2, int var3, int var4, int[] var5) {

      int var6 = var1 * var1;

      for (int var7 = 0; var7 < var6; var7++) {
         var5[var7] = var0[(var7 << 2) + 3] >= 0.0019607844F ? var7 : -1;
      }

      for (int var20 = 0; var20 < var1; var20++) {
         int var8 = var20 * var1;
         int var9 = -1;

         for (int var10 = 0; var10 < var1; var10++) {
            if (var5[var8 + var10] == var8 + var10) {
               var9 = var8 + var10;
            } else {
               var5[var8 + var10] = var9;
            }
         }

         int var27 = -1;

         for (int var11 = var1 - 1; var11 >= 0; var11--) {
            int var12 = var8 + var11;
            if (var0[(var12 << 2) + 3] >= 0.0019607844F) {
               var27 = var12;
            } else {
               int var13 = var5[var12];
               if (var27 >= 0 && (var13 < 0 || var27 - var12 < var12 - var13)) {
                  var5[var12] = var27;
               }
            }
         }
      }

      for (int var21 = 0; var21 < 2; var21++) {
         int var23 = var21 == 0 ? var1 : -var1;

         for (int var25 = 1; var25 < var1; var25++) {
            int var28 = var21 == 0 ? var25 : var1 - 1 - var25;
            int var30 = var28 * var1;

            for (int var32 = 0; var32 < var1; var32++) {
               int var34 = var30 + var32;
               int var14 = var5[var34 - var23];
               if (var14 >= 0) {
                  int var15 = var14 % var1 - var32;
                  int var16 = var14 / var1 - var28;
                  int var17 = var5[var34];
                  if (var17 >= 0) {
                     int var18 = var17 % var1 - var32;
                     int var19 = var17 / var1 - var28;
                     if (var18 * var18 + var19 * var19 <= var15 * var15 + var16 * var16) {
                        continue;
                     }
                  }

                  var5[var34] = var14;
               }
            }
         }
      }

      for (int var22 = 0; var22 < var1; var22++) {
         for (int var24 = 0; var24 < var1; var24++) {
            int var26 = var22 * var1 + var24;
            float var29 = var0[(var26 << 2) + 3];
            int var31 = (int)(var29 * 255.0F + 0.5F);
            int var33 = 0;
            int var35 = var5[var26];
            if (var35 >= 0) {
               int var36 = var35 << 2;
               float var37 = var0[var36 + 3];
               float var38 = var37 > 0.0F ? 1.0F / var37 : 0.0F;
               int var39 = (int)(var0[var36] * var38 * 255.0F + 0.5F);
               int var40 = (int)(var0[var36 + 1] * var38 * 255.0F + 0.5F);
               int var41 = (int)(var0[var36 + 2] * var38 * 255.0F + 0.5F);
               var33 = (var39 > (-509728202 ^ -509728055) ? 643323630 ^ 643323409 : var39) << 16
                  | (var40 > (1062012126 ^ 1062011937) ? -1443222069 ^ -1443222220 : var40) << 8
                  | (var41 > (-475024372 ^ -475024141) ? -1876954482 ^ -1876954511 : var41);
            }

            var2[(var4 + var22) * (-836360889 ^ -836361913) + var3 + var24] = (var31 > (-952875636 ^ -952875661) ? -1458695362 ^ -1458695231 : var31) << 24
               | var33;
         }
      }
   }

   private static void ak(float[] var0, int[] var1, byte[] var2, byte[] var3, int[] var4, int var5) {

      for (int var6 = 0; var6 < (1373468741 ^ 1372944453); var6++) {
         int var7 = var6 << 2;
         float var8 = var0[var7 + 3];
         if (var8 >= 0.0019607844F) {
            float var9 = 1.0F / var8;
            var0[var7] *= var9;
            var0[var7 + 1] = var0[var7 + 1] * var9;
            var0[var7 + 2] = var0[var7 + 2] * var9;
            var2[var6] = 1;
         } else {
            var0[var7] = 0.0F;
            var0[var7 + 1] = 0.0F;
            var0[var7 + 2] = 0.0F;
            var0[var7 + 3] = 0.0F;
            var2[var6] = 0;
         }
      }

      for (int var19 = 0; var19 < (-894666870 ^ -894667382); var19++) {
         int var24 = var19 * (-231646908 ^ -231645884);
         var3[var24] = (byte)(var2[var24] | var2[var24 + 1]);

         for (int var29 = 1; var29 < (-1096776463 ^ -1096775922); var29++) {
            var3[var24 + var29] = (byte)(var2[var24 + var29 - 1] | var2[var24 + var29] | var2[var24 + var29 + 1]);
         }

         var3[var24 + (-64748387 ^ -64749411) - 1] = (byte)(var2[var24 + (-749125349 ^ -749124325) - 2] | var2[var24 + (-966993940 ^ -966994964) - 1]);
      }

      for (int var20 = 0; var20 < (-2138345366 ^ -2138344854); var20++) {
         int var25 = var20 * (-998388283 ^ -998389307);

         for (int var30 = 0; var30 < (179734426 ^ 179733402); var30++) {
            int var34 = var25 + var30;
            if (var2[var34] == 0
               && (
                     var3[var34]
                        | (var20 > 0 ? var3[var34 - (-1392718816 ^ -1392719840)] : 0)
                        | (var20 < (1794997729 ^ 1794997278) ? var3[var34 + (1174405121 ^ 1174406145)] : 0)
                  )
                  != 0) {
               float var10 = 0.0F;
               float var11 = 0.0F;
               float var12 = 0.0F;
               float var13 = 0.0F;

               for (int var14 = var20 > 0 ? var20 - 1 : 0; var14 <= (var20 < (-1338591929 ^ -1338592072) ? var20 + 1 : var20); var14++) {
                  for (int var15 = var30 > 0 ? var30 - 1 : 0; var15 <= (var30 < (874518052 ^ 874517979) ? var30 + 1 : var30); var15++) {
                     int var16 = var14 * (-956228499 ^ -956229523) + var15 << 2;
                     float var17 = var0[var16 + 3];
                     if (var17 > 0.0F) {
                        var10 += var0[var16] * var17;
                        var11 += var0[var16 + 1] * var17;
                        var12 += var0[var16 + 2] * var17;
                        var13 += var17;
                     }
                  }
               }

               int var50 = var34 << 2;
               var0[var50] = var10 / var13;
               var0[var50 + 1] = var11 / var13;
               var0[var50 + 2] = var12 / var13;
               var2[var34] = 2;
            }
         }
      }

      for (int var21 = 0; var21 < (-1267058823 ^ -1267059335); var21++) {
         int var26 = var21 * (991409948 ^ 991408924);
         int var31 = -1;

         for (int var35 = 0; var35 < (1376639346 ^ 1376640370); var35++) {
            if (var2[var26 + var35] != 0) {
               var31 = var26 + var35;
            }

            var1[var26 + var35] = var31;
         }

         int var36 = -1;

         for (int var39 = 1925514979 ^ 1925514524; var39 >= 0; var39--) {
            int var42 = var26 + var39;
            if (var2[var42] != 0) {
               var36 = var42;
            }

            int var45 = var1[var42];
            if (var36 >= 0 && (var45 < 0 || var36 - var42 < var42 - var45)) {
               var1[var42] = var36;
            }
         }
      }

      for (int var22 = 0; var22 < 2; var22++) {
         int var27 = var22 == 0 ? -1745654414 ^ -1745655438 : -1987084918 ^ 1987084682;

         for (int var32 = 1; var32 < (-969021979 ^ -969021467); var32++) {
            int var37 = var22 == 0 ? var32 : (-1426949941 ^ -1426949836) - var32;
            int var40 = var37 * (-168387906 ^ -168386882);

            for (int var43 = 0; var43 < (753438274 ^ 753437250); var43++) {
               int var46 = var40 + var43;
               int var48 = var1[var46 - var27];
               if (var48 >= 0) {
                  int var51 = (var48 & (25329544 ^ 25328759)) - var43;
                  int var53 = (var48 >> 10) - var37;
                  int var54 = var1[var46];
                  if (var54 >= 0) {
                     int var55 = (var54 & (-1227878663 ^ -1227879162)) - var43;
                     int var18 = (var54 >> 10) - var37;
                     if (var55 * var55 + var18 * var18 <= var51 * var51 + var53 * var53) {
                        continue;
                     }
                  }

                  var1[var46] = var48;
               }
            }
         }
      }

      int var23 = var5 * (1418931574 ^ 1418930550);

      for (int var28 = 0; var28 < (-242159450 ^ -241635162); var28++) {
         int var33 = (int)(var0[(var28 << 2) + 3] * 255.0F + 0.5F);
         int var38 = var1[var28];
         int var41 = 0;
         if (var38 >= 0) {
            int var44 = var38 << 2;
            int var47 = (int)(var0[var44] * 255.0F + 0.5F);
            int var49 = (int)(var0[var44 + 1] * 255.0F + 0.5F);
            int var52 = (int)(var0[var44 + 2] * 255.0F + 0.5F);
            var41 = (var47 > (-1736344704 ^ -1736344705) ? 123510415 ^ 123510384 : var47) << 16
               | (var49 > (-2003502310 ^ -2003502107) ? 1484708321 ^ 1484708126 : var49) << 8
               | (var52 > (-148647297 ^ -148647296) ? 444446114 ^ 444446045 : var52);
         }

         var4[var23 + var28] = (var33 > (1078200889 ^ 1078201030) ? 1978649536 ^ 1978649407 : var33) << 24 | var41;
      }
   }

   private static float[] al() {

      float[] var0 = new float[4096];

      for (int var1 = 0; var1 < var0.length; var1++) {
         int var2 = var1 * (2018043086 ^ -427844233) + (341528708 ^ 1796287633);
         var2 ^= var2 >>> 16;
         var2 *= 550669017 ^ -1522974542;
         var2 ^= var2 >>> 13;
         var2 *= -581092321 ^ 535794218;
         var2 ^= var2 >>> 16;
         var0[var1] = (float)(var2 & (439514763 ^ 439519604)) / 65535.0F;
      }

      return var0;
   }

   static {
      double var0 = -0.3;
      double var2 = -0.78;
      double var4 = 1.55;
      double var6 = Math.sqrt(var0 * var0 + var2 * var2 + var4 * var4);
      es = var0 / var6;
      et = var2 / var6;
      eu = var4 / var6;
   }
}
