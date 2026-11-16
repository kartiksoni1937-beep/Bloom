package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

public final class FacetArrayCache {
   public static final int W = 1024;
   public static final int H = 1024;
   public static final int LEVELS = 5;
   public static final int C_WHITE = 0;
   public static final int C_LINE = 1;
   public static final int C_SOFT = 2;
   public static final int C_DOT = 3;
   public static final int C_GLOW = 4;
   public static final int C_STAR = 5;
   public static final int C_SHARD = 6;
   public static final int C_SPARK = 7;
   public static final int C_ORB = 8;
   public static final int C_GLYPH = 9;
   public static final int GLYPHS = 8;
   public static final int C_NEON = 17;
   public static final int C_RIPPLE = 18;
   public static final int C_ARC = 19;
   public static final int C_BAND = 20;
   public static final int C_CRYSTAL = 21;
   public static final int C_PUFF = 22;
   public static final int C_VIGNETTE = 23;
   public static final int C_SCORCH = 24;
   public static final int C_SHELL = 25;
   public static final int C_SPIRIT = 26;
   public static final int CELLS = 27;
   public static final int[] CX = new int[]{
      0, 64, 128, 192, 256, 384, 512, 640, 768, 0, 64, 128, 192, 256, 320, 384, 448, 0, 512, 0, 896, 576, 640, 768, 896, 768, 384
   };
   public static final int[] CY = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 128, 128, 128, 128, 128, 128, 128, 128, 256, 256, 768, 0, 832, 128, 128, 128, 768, 768};
   public static final int[] CS = new int[]{
      64, 64, 64, 64, 128, 128, 128, 128, 128, 64, 64, 64, 64, 64, 64, 64, 64, 512, 512, 256, 64, 128, 128, 128, 128, 256, 128
   };
   public static final int[] CH = new int[]{
      64, 64, 64, 64, 128, 128, 128, 128, 128, 64, 64, 64, 64, 64, 64, 64, 64, 512, 512, 128, 64, 128, 128, 128, 128, 256, 256
   };
   public static final float ARC_CX = 128.0F;
   public static final float ARC_CY = 240.0F;
   public static final float ARC_R_OUT = 222.0F;
   public static final float[] U0 = new float[27];
   public static final float[] V0 = new float[27];
   public static final float[] U1 = new float[27];
   public static final float[] V1 = new float[27];
   public static final float RING_R = 0.9F;
   public static final float SHELL_R = 0.86F;
   private static final String[] s = new String[]{
      ".......|..###." + ".|.#...#.|.#...#.|.#...#.|." + ".###..|.......",
      "..###..|.#...#.|..###..|.#...#.|.#...#.|..###" + "..|...." + "...",
      "..###..|.#...#.|.....#.|....#..|...#...|...." + "...|...#...",
      "..####.|.#.....|..###..|.....#.|" + ".####..|.......|..." + ".." + "..",
      ".......|.......|.##...#|#..#..#|#...##.|.......|.......",
      ".#...#.|.#...#.|.#####.|...#...|...#...|..#" + "##..|....." + "..",
      "...#...|..#.#..|.#...#.|..#.#.." + "|.." + ".#...|.......|.......",
      ".......|...#...|.......|.#...#.|.......|..." + "....|.." + "....."
   };
   private static int u = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   private FacetArrayCache() {
   }

   public static int[] a() {

      int[] var0 = new int[1048576];
      e(var0);
      f(var0, 1, true);
      f(var0, 2, false);
      g(var0, 3, 0);
      g(var0, 4, 1);
      g(var0, 8, 2);
      h(var0);
      i(var0);
      j(var0);

      for (int var1 = 0; var1 < 8; var1++) {
         k(var0, 9 + var1, s[var1]);
      }

      l(var0, 17, false);
      l(var0, 18, true);
      c(var0);
      b(var0);
      m(var0);
      n(var0);
      o(var0);
      p(var0);
      q(var0);
      r(var0);
      return var0;
   }

   private static void b(int[] var0) {

      byte var1 = 20;
      int var2 = CX[var1];
      int var3 = CY[var1];
      int var4 = CS[var1];

      for (int var5 = 0; var5 < var4; var5++) {
         double var6 = ((double)var5 + 0.5) / (double)var4;
         double var8 = (var6 - 0.015) / 0.02;
         double var10 = (0.985 - var6) / 0.02;
         var8 = var8 < 0.0 ? 0.0 : (var8 > 1.0 ? 1.0 : var8);
         var10 = var10 < 0.0 ? 0.0 : (var10 > 1.0 ? 1.0 : var10);
         double var12 = Math.min(var6, 1.0 - var6);
         double var14 = (var12 - 0.07) / 0.04;
         var14 = var14 < 0.0 ? 0.0 : (var14 > 1.0 ? 1.0 : var14);
         double var16 = 1.0 - 0.22 * var14 * var14 * (3.0 - 2.0 * var14);
         double var18 = var8 * var10 * var16;
         int var20 = (int)((var18 < 0.0 ? 0.0 : (var18 > 1.0 ? 1.0 : var18)) * 255.0 + 0.5) << 24 | -680653090 ^ -678301407;

         for (int var21 = 0; var21 < var4; var21++) {
            var0[(var3 + var5) * (-1955452158 ^ -1955451134) + var2 + var21] = var20;
         }
      }
   }

   private static void c(int[] var0) {

      byte var1 = 19;
      int var2 = CX[var1];
      int var3 = CY[var1];
      int var4 = CS[var1];
      int var5 = CH[var1];
      double var6 = Math.toRadians(25.0);
      double var8 = Math.toRadians(8.0);
      double[] var10 = new double[]{150.0, 186.0, 222.0};
      double[] var11 = new double[]{4.0, 4.5, 5.5};

      for (int var12 = 0; var12 < var5; var12++) {
         for (int var13 = 0; var13 < var4; var13++) {
            double var14 = (double)var13 + 0.5 - 128.0;
            double var16 = 240.0 - ((double)var12 + 0.5);
            double var18 = Math.sqrt(var14 * var14 + var16 * var16);
            double var20 = Math.atan2(var14, var16);
            double var22 = 1.0E9;

            for (int var24 = 0; var24 < 3; var24++) {
               double var25;
               if (var20 >= -var6 && var20 <= var6) {
                  double var37 = var24 == 2 && var20 >= var8 ? 10.0 : var11[var24];
                  var25 = Math.abs(var18 - var10[var24]) - var37;
               } else {
                  double var27 = var20 > 0.0 ? var6 : -var6;
                  double var29 = var10[var24] * Math.sin(var27);
                  double var31 = var10[var24] * Math.cos(var27);
                  double var33 = var24 == 2 && var27 > 0.0 ? 10.0 : var11[var24];
                  var25 = Math.sqrt((var14 - var29) * (var14 - var29) + (var16 - var31) * (var16 - var31)) - var33;
               }

               if (var25 < var22) {
                  var22 = var25;
               }
            }

            double var35 = 0.5 - var22 / 1.2;
            var35 = var35 < 0.0 ? 0.0 : (var35 > 1.0 ? 1.0 : var35);
            double var26 = var22 > 0.0 ? 0.35 * Math.exp(-var22 / 9.0) : 0.0;
            double var28 = var35 + var26 * (1.0 - var35);
            var0[(var3 + var12) * (-468053048 ^ -468052024) + var2 + var13] = (int)((var28 < 0.0 ? 0.0 : (var28 > 1.0 ? 1.0 : var28)) * 255.0 + 0.5) << 24
               | 92290649 ^ 92258726;
         }
      }
   }

   public static int[][] d(int[] var0) {

      int[][] var1 = new int[5][];
      var1[0] = var0;
      int var2 = -524922881 ^ -524923905;
      int var3 = 2141875131 ^ 2141876155;

      for (int var4 = 1; var4 < 5; var4++) {
         int var5 = var2 >> 1;
         int var6 = var3 >> 1;
         int[] var7 = var1[var4 - 1];
         int[] var8 = new int[var5 * var6];

         for (int var9 = 0; var9 < var6; var9++) {
            int var10 = 2 * var9 * var2;
            int var11 = var10 + var2;

            for (int var12 = 0; var12 < var5; var12++) {
               int var13 = (var7[var10 + 2 * var12] >>> 24)
                  + (var7[var10 + 2 * var12 + 1] >>> 24)
                  + (var7[var11 + 2 * var12] >>> 24)
                  + (var7[var11 + 2 * var12 + 1] >>> 24);
               var8[var9 * var5 + var12] = var13 + 2 >> 2 << 24 | -903395980 ^ -891766133;
            }
         }

         var1[var4] = var8;
         var2 = var5;
         var3 = var6;
      }

      return var1;
   }

   private static void e(int[] var0) {
      int var1 = 0;
      int var2 = 0;
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;
      byte var6 = 0;

      while (true) {
         switch (var6) {
            case 0:
            default:
               if (u != 0) {
                  new Object().hashCode();
                  var6 = 6;
                  break;
               }
            case 6:
               var1 = CX[0];
               var2 = CY[0];
               var3 = CS[0];
               var4 = 0;
               var6 = 8;
               break;
            case 4:
               return;
            case 5:
               if (var4 >= var0.length) {
                  return;
               }

               if (var0[var4] == 0) {
                  var0[var4] = 16777215;
                  var6 = 1;
                  break;
               }
            case 1:
               var4++;
               var6 = 5;
               break;
            case 7:
               if (var5 < var3) {
                  var0[(var2 + var4) * (310781599 ^ 310780575) + var1 + var5] = -1;
                  var5++;
                  var6 = 7;
                  break;
               }
            case 3:
               var4++;
               var6 = 8;
               break;
            case 8:
               if (var4 < var3) {
                  var5 = 0;
                  var6 = 7;
                  break;
               }
            case 2:
               var4 = 0;
               var6 = 5;
         }
      }
   }

   private static void f(int[] var0, int var1, boolean var2) {

      int var3 = CX[var1];
      int var4 = CY[var1];
      int var5 = CS[var1];
      double var6 = (double)var5 * 0.5;
      double var8 = 1.25 / var6;

      for (int var10 = 0; var10 < var5; var10++) {
         double var11 = Math.abs((double)var10 + 0.5 - var6) / var6;
         double var13;
         if (var2) {
            double var15 = (0.22 - var11) / var8 + 0.5;
            var15 = var15 < 0.0 ? 0.0 : (var15 > 1.0 ? 1.0 : var15);
            double var17 = 1.0 - var11;
            var17 = var17 <= 0.0 ? 0.0 : 0.42 * Math.pow(var17, 2.4);
            var13 = var15 + var17 * (1.0 - var15);
         } else {
            double var20 = 1.0 - var11;
            var13 = var20 <= 0.0 ? 0.0 : Math.pow(var20, 1.8);
         }

         for (int var21 = 0; var21 < var5; var21++) {
            var0[(var4 + var10) * (788690250 ^ 788689226) + var3 + var21] = (int)((var13 < 0.0 ? 0.0 : (var13 > 1.0 ? 1.0 : var13)) * 255.0 + 0.5) << 24
               | -1734175563 ^ -1738708150;
         }
      }
   }

   private static void g(int[] var0, int var1, int var2) {

      int var3 = CX[var1];
      int var4 = CY[var1];
      int var5 = CS[var1];
      double var6 = (double)var5 * 0.5;

      for (int var8 = 0; var8 < var5; var8++) {
         for (int var9 = 0; var9 < var5; var9++) {
            double var10 = ((double)var9 + 0.5 - var6) / var6;
            double var12 = ((double)var8 + 0.5 - var6) / var6;
            double var14 = Math.sqrt(var10 * var10 + var12 * var12);
            double var16;
            if (var2 == 0) {
               double var18 = (0.55 - var14) / 0.12 + 0.5;
               var18 = var18 < 0.0 ? 0.0 : (var18 > 1.0 ? 1.0 : var18);
               double var20 = 1.0 - var14;
               var20 = var20 <= 0.0 ? 0.0 : 0.25 * var20 * var20;
               var16 = var18 + var20 * (1.0 - var18);
            } else if (var2 == 1) {
               double var23 = 1.0 - var14;
               var16 = var23 <= 0.0 ? 0.0 : 0.85 * Math.pow(var23, 2.2) + 0.15 * Math.exp(-var14 * var14 / 0.02);
            } else {
               double var24 = (0.9 - var14) / 0.35;
               var24 = var24 < 0.0 ? 0.0 : (var24 > 1.0 ? 1.0 : var24);
               var16 = 0.9 * var24 * var24 * (3.0 - 2.0 * var24);
            }

            var0[(var4 + var8) * (1295728615 ^ 1295727591) + var3 + var9] = (int)((var16 < 0.0 ? 0.0 : (var16 > 1.0 ? 1.0 : var16)) * 255.0 + 0.5) << 24
               | -62204262 ^ -55236251;
         }
      }
   }

   private static void h(int[] var0) {

      byte var1 = 5;
      int var2 = CX[var1];
      int var3 = CY[var1];
      int var4 = CS[var1];
      double var5 = (double)var4 * 0.5;
      double[] var7 = new double[10];
      double[] var8 = new double[10];

      for (int var9 = 0; var9 < 10; var9++) {
         double var10 = (var9 & 1) == 0 ? 0.8 : 0.38;
         double var12 = (-Math.PI / 2) + (double)var9 * Math.PI / 5.0;
         var7[var9] = var10 * Math.cos(var12);
         var8[var9] = var10 * Math.sin(var12);
      }

      double var38 = 1.2 / var5;

      for (int var11 = 0; var11 < var4; var11++) {
         for (int var39 = 0; var39 < var4; var39++) {
            double var13 = ((double)var39 + 0.5 - var5) / var5;
            double var15 = ((double)var11 + 0.5 - var5) / var5;
            double var17 = 1.0E9;
            boolean var19 = false;
            int var20 = 0;

            for (int var21 = 9; var20 < 10; var21 = var20++) {
               double var22 = var7[var20] - var7[var21];
               double var24 = var8[var20] - var8[var21];
               double var26 = var13 - var7[var21];
               double var28 = var15 - var8[var21];
               double var30 = (var26 * var22 + var28 * var24) / (var22 * var22 + var24 * var24);
               var30 = var30 < 0.0 ? 0.0 : (var30 > 1.0 ? 1.0 : var30);
               double var32 = var26 - var22 * var30;
               double var34 = var28 - var24 * var30;
               double var36 = var32 * var32 + var34 * var34;
               if (var36 < var17) {
                  var17 = var36;
               }

               if (var8[var20] > var15 != var8[var21] > var15
                  && var13 < (var7[var21] - var7[var20]) * (var15 - var8[var20]) / (var8[var21] - var8[var20]) + var7[var20]) {
                  var19 = !var19;
               }
            }

            double var40 = Math.sqrt(var17) * (var19 ? 1.0 : -1.0);
            double var41 = var40 / var38 + 0.5;
            var41 = var41 < 0.0 ? 0.0 : (var41 > 1.0 ? 1.0 : var41);
            double var43 = Math.sqrt(var13 * var13 + var15 * var15);
            double var44 = 1.0 - var43;
            var44 = var44 <= 0.0 ? 0.0 : 0.3 * var44 * var44;
            double var46 = var41 + var44 * (1.0 - var41);
            var0[(var3 + var11) * (896943770 ^ 896942746) + var2 + var39] = (int)((var46 < 0.0 ? 0.0 : (var46 > 1.0 ? 1.0 : var46)) * 255.0 + 0.5) << 24
               | -2134828597 ^ -2143361484;
         }
      }
   }

   private static void i(int[] var0) {

      byte var1 = 6;
      int var2 = CX[var1];
      int var3 = CY[var1];
      int var4 = CS[var1];
      double[] var5 = new double[]{0.5, 0.7, 0.5, 0.3};
      double[] var6 = new double[]{0.04, 0.36, 0.96, 0.36};
      double var7 = 1.2 / (double)var4;

      for (int var9 = 0; var9 < var4; var9++) {
         for (int var10 = 0; var10 < var4; var10++) {
            double var11 = ((double)var10 + 0.5) / (double)var4;
            double var13 = ((double)var9 + 0.5) / (double)var4;
            double var15 = 1.0E9;
            boolean var17 = false;
            int var18 = 0;

            for (int var19 = 3; var18 < 4; var19 = var18++) {
               double var20 = var5[var18] - var5[var19];
               double var22 = var6[var18] - var6[var19];
               double var24 = var11 - var5[var19];
               double var26 = var13 - var6[var19];
               double var28 = (var24 * var20 + var26 * var22) / (var20 * var20 + var22 * var22);
               var28 = var28 < 0.0 ? 0.0 : (var28 > 1.0 ? 1.0 : var28);
               double var30 = var24 - var20 * var28;
               double var32 = var26 - var22 * var28;
               double var34 = var30 * var30 + var32 * var32;
               if (var34 < var15) {
                  var15 = var34;
               }

               if (var6[var18] > var13 != var6[var19] > var13
                  && var11 < (var5[var19] - var5[var18]) * (var13 - var6[var18]) / (var6[var19] - var6[var18]) + var5[var18]) {
                  var17 = !var17;
               }
            }

            double var36 = Math.sqrt(var15) * (var17 ? 1.0 : -1.0);
            double var37 = var36 / var7 + 0.5;
            var37 = var37 < 0.0 ? 0.0 : (var37 > 1.0 ? 1.0 : var37);
            double var39 = var11 < 0.5 ? 1.0 : 0.72;
            double var40 = var37 * var39;
            var0[(var3 + var9) * (-351888236 ^ -351889260) + var2 + var10] = (int)((var40 < 0.0 ? 0.0 : (var40 > 1.0 ? 1.0 : var40)) * 255.0 + 0.5) << 24
               | -974734303 ^ -988199970;
         }
      }
   }

   private static void j(int[] var0) {

      byte var1 = 7;
      int var2 = CX[var1];
      int var3 = CY[var1];
      int var4 = CS[var1];
      double var5 = (double)var4 * 0.5;
      double var7 = 1.0 / var5;

      for (int var9 = 0; var9 < var4; var9++) {
         for (int var10 = 0; var10 < var4; var10++) {
            double var11 = Math.abs(((double)var10 + 0.5 - var5) / var5);
            double var13 = Math.abs(((double)var9 + 0.5 - var5) / var5);
            double var15 = var11 < 0.92 ? 0.07 * (1.0 - var11 / 0.92) : 0.0;
            double var17 = var13 < 0.92 ? 0.07 * (1.0 - var13 / 0.92) : 0.0;
            double var19 = (var15 - var13) / var7 + 0.5;
            double var21 = (var17 - var11) / var7 + 0.5;
            var19 = var19 < 0.0 ? 0.0 : (var19 > 1.0 ? 1.0 : var19);
            var21 = var21 < 0.0 ? 0.0 : (var21 > 1.0 ? 1.0 : var21);
            double var23 = Math.sqrt(var11 * var11 + var13 * var13);
            double var25 = Math.exp(-var23 * var23 / 0.012);
            double var27 = 1.0 - var23;
            var27 = var27 <= 0.0 ? 0.0 : 0.28 * var27 * var27 * var27;
            double var29 = Math.max(Math.max(var19, var21), var25);
            double var31 = var29 + var27 * (1.0 - var29);
            var0[(var3 + var9) * (1666842636 ^ 1666843660) + var2 + var10] = (int)((var31 < 0.0 ? 0.0 : (var31 > 1.0 ? 1.0 : var31)) * 255.0 + 0.5) << 24
               | 373135148 ^ 381839571;
         }
      }
   }

   private static void k(int[] var0, int var1, String var2) {

      int var3 = CX[var1];
      int var4 = CY[var1];
      int var5 = CS[var1];
      double var6 = (double)var5 / 9.0;
      boolean[] var8 = new boolean[49];
      int var9 = 0;

      for (int var10 = 0; var9 < var2.length() && var10 < 49; var9++) {
         char var11 = var2.charAt(var9);
         if (var11 != '|') {
            var8[var10++] = var11 == '#';
         }
      }

      for (int var28 = 0; var28 < var5; var28++) {
         for (int var29 = 0; var29 < var5; var29++) {
            double var30 = ((double)var29 + 0.5) / var6 - 1.0;
            double var13 = ((double)var28 + 0.5) / var6 - 1.0;
            double var15 = 1.0E9;

            for (int var17 = 0; var17 < 49; var17++) {
               if (var8[var17]) {
                  double var18 = (double)(var17 % 7);
                  double var20 = (double)(var17 / 7);
                  double var22 = var30 < var18 ? var18 - var30 : (var30 > var18 + 1.0 ? var30 - var18 - 1.0 : 0.0);
                  double var24 = var13 < var20 ? var20 - var13 : (var13 > var20 + 1.0 ? var13 - var20 - 1.0 : 0.0);
                  double var26 = var22 * var22 + var24 * var24;
                  if (var26 < var15) {
                     var15 = var26;
                  }
               }
            }

            double var31 = Math.sqrt(var15) * var6;
            double var19 = 1.0 - var31;
            var19 = var19 < 0.0 ? 0.0 : (var19 > 1.0 ? 1.0 : var19);
            double var21 = var31 / (2.0 * var6);
            var21 = var21 >= 1.0 ? 0.0 : 0.35 * (1.0 - var21) * (1.0 - var21);
            double var23 = var19 + var21 * (1.0 - var19);
            var0[(var4 + var28) * (1612801030 ^ 1612800006) + var3 + var29] = (int)((var23 < 0.0 ? 0.0 : (var23 > 1.0 ? 1.0 : var23)) * 255.0 + 0.5) << 24
               | -1287932017 ^ -1278982032;
         }
      }
   }

   private static void l(int[] var0, int var1, boolean var2) {

      int var3 = CX[var1];
      int var4 = CY[var1];
      int var5 = CS[var1];
      double var6 = (double)var5 * 0.5;
      double var8 = 1.2 / var6;

      for (int var10 = 0; var10 < var5; var10++) {
         for (int var11 = 0; var11 < var5; var11++) {
            double var12 = ((double)var11 + 0.5 - var6) / var6;
            double var14 = ((double)var10 + 0.5 - var6) / var6;
            double var16 = Math.sqrt(var12 * var12 + var14 * var14);
            double var18;
            if (!var2) {
               double var34 = 0.02;
               double var38 = 0.9F;
               double var40 = Math.abs(var16 - var38);
               double var26 = (var34 - var40) / var8 + 0.5;
               var26 = var26 < 0.0 ? 0.0 : (var26 > 1.0 ? 1.0 : var26);
               double var28 = var16 > var38 ? 0.6 * Math.exp(-Math.max(0.0, var16 - var38 - var34) / 0.045) : 0.0;
               double var30 = var16 < var38 ? 0.5 * Math.exp(-Math.max(0.0, var38 - var34 - var16) / 0.12) : 0.0;
               double var32 = var28 > var30 ? var28 : var30;
               var18 = var26 + var32 * (1.0 - var26);
            } else {
               double var20 = 0.0;

               for (int var22 = 0; var22 < 7; var22++) {
                  double var23 = 0.6 + 0.05 * (double)var22;
                  double var25 = (0.009 - Math.abs(var16 - var23)) / var8 + 0.5;
                  var25 = var25 < 0.0 ? 0.0 : (var25 > 1.0 ? 1.0 : var25);
                  var25 *= 1.0 - 0.05 * (double)var22;
                  if (var25 > var20) {
                     var20 = var25;
                  }
               }

               double var37 = (var16 - 0.75) / 0.17;
               double var24 = 0.45 * Math.exp(-var37 * var37);
               var18 = var20 + var24 * (1.0 - var20);
            }

            double var35 = (1.0 - var16) / 0.04;
            var35 = var35 < 0.0 ? 0.0 : (var35 > 1.0 ? 1.0 : var35);
            double var39 = var18 * var35;
            var0[(var4 + var10) * (-305226683 ^ -305227707) + var3 + var11] = (int)((var39 < 0.0 ? 0.0 : (var39 > 1.0 ? 1.0 : var39)) * 255.0 + 0.5) << 24
               | -1528849666 ^ -1541380863;
         }
      }
   }

   private static void m(int[] var0) {

      assert var0 != null
         && var0.length == (1149532691 ^ 1150581267)
         && CX.length == 27
         && CY.length == 27
         && CS.length == 27
         && CH.length == 27
         && U0.length == 27
         && V1.length == 27
         && CX[21] >= 0
         && CY[21] >= 0
         && CX[21] + CS[21] <= (-1797066537 ^ -1797065513)
         && CY[21] + CH[21] <= (-447284041 ^ -447285065)
         && (CX[21] & 15) == 0
         && (CY[21] & 15) == 0
         && CS[21] == (1570472848 ^ 1570472720)
         && CH[21] == (706749016 ^ 706749144)
         && U0[21] < U1[21]
         && V0[21] < V1[21]
         && var0[CY[21] * (430637624 ^ 430638648) + CX[21]] == (-273313315 ^ -280334814)
         && var0[(CY[21] + CH[21] - 1) * (-1952887300 ^ -1952888324) + CX[21] + CS[21] - 1] == (590724898 ^ 600457437);

      try {
         int var1 = CX[21];
         int var2 = CY[21];
         int var3 = CS[21];
         double[] var4 = new double[]{0.52, 0.71, 0.66, 0.47, 0.32, 0.29};
         double[] var5 = new double[]{0.03, 0.29, 0.75, 0.97, 0.71, 0.25};
         double var6 = 0.54;
         double var8 = 0.47;

         for (int var10 = 0; var10 < var3; var10++) {
            for (int var11 = 0; var11 < var3; var11++) {
               double var12 = ((double)var11 + 0.5) / (double)var3;
               double var14 = ((double)var10 + 0.5) / (double)var3;
               double var16 = 1.0E9;
               boolean var18 = false;
               int var19 = 0;

               for (int var20 = 5; var19 < 6; var20 = var19++) {
                  double var21 = var4[var19] - var4[var20];
                  double var23 = var5[var19] - var5[var20];
                  double var25 = var12 - var4[var20];
                  double var27 = var14 - var5[var20];
                  double var29 = (var25 * var21 + var27 * var23) / (var21 * var21 + var23 * var23);
                  var29 = var29 < 0.0 ? 0.0 : (var29 > 1.0 ? 1.0 : var29);
                  double var31 = var25 - var21 * var29;
                  double var33 = var27 - var23 * var29;
                  double var35 = var31 * var31 + var33 * var33;
                  if (var35 < var16) {
                     var16 = var35;
                  }

                  if (var5[var19] > var14 != var5[var20] > var14
                     && var12 < (var4[var20] - var4[var19]) * (var14 - var5[var19]) / (var5[var20] - var5[var19]) + var4[var19]) {
                     var18 = !var18;
                  }
               }

               double var65 = Math.sqrt(var16) * (double)var3;
               double var66;
               if (var18) {
                  double var71 = (var6 - var4[0]) * (var14 - var5[0]) - (var8 - var5[0]) * (var12 - var4[0]);
                  double var73 = (var4[3] - var6) * (var14 - var8) - (var5[3] - var8) * (var12 - var6);
                  boolean var74 = var14 < var8 ? var71 < 0.0 : var73 < 0.0;
                  double var28 = (var4[1] - var4[0]) * (var14 - var5[0]) - (var5[1] - var5[0]) * (var12 - var4[0]);
                  double var30 = (var6 - var4[1]) * (var14 - var5[1]) - (var8 - var5[1]) * (var12 - var4[1]);
                  double var32 = (var4[0] - var6) * (var14 - var8) - (var5[0] - var8) * (var12 - var6);
                  boolean var34 = var28 > 0.0 == var30 > 0.0 && var30 > 0.0 == var32 > 0.0;
                  double var76 = var34 ? 0.78 : (var74 ? 0.3 : 0.5);
                  double var37 = 1.0E9;

                  for (int var39 = 0; var39 < 2; var39++) {
                     double var40 = var39 == 0 ? var4[0] : var6;
                     double var42 = var39 == 0 ? var5[0] : var8;
                     double var44 = var39 == 0 ? var6 : var4[3];
                     double var46 = var39 == 0 ? var8 : var5[3];
                     double var48 = var44 - var40;
                     double var50 = var46 - var42;
                     double var52 = var12 - var40;
                     double var54 = var14 - var42;
                     double var56 = (var52 * var48 + var54 * var50) / (var48 * var48 + var50 * var50);
                     var56 = var56 < 0.0 ? 0.0 : (var56 > 1.0 ? 1.0 : var56);
                     double var58 = var52 - var48 * var56;
                     double var60 = var54 - var50 * var56;
                     double var62 = Math.sqrt(var58 * var58 + var60 * var60) * (double)var3;
                     if (var62 < var37) {
                        var37 = var62;
                     }
                  }

                  double var77 = (1.5 - var37) / 1.2;
                  var77 = var77 < 0.0 ? 0.0 : (var77 > 1.0 ? 1.0 : var77);
                  double var41 = (2.3 - var65) / 1.2;
                  var41 = var41 < 0.0 ? 0.0 : (var41 > 1.0 ? 1.0 : var41);
                  double var43 = var12 - 0.56;
                  double var45 = var14 - 0.21;
                  double var47 = Math.sqrt(var43 * var43 + var45 * var45) / 0.07;
                  double var49 = var47 < 1.0 ? 0.35 * (1.0 - var47 * var47) : 0.0;
                  var66 = var76 + var49;
                  var66 += (1.0 - var66) * (var41 > var77 ? var41 : var77);
                  double var51 = var65 / 1.2 + 0.5;
                  var66 *= var51 > 1.0 ? 1.0 : var51;
               } else {
                  double var69 = 0.5 - var65 / 1.2;
                  var69 = var69 < 0.0 ? 0.0 : var69;
                  var66 = var69 + 0.18 * Math.exp(-var65 / 2.5) * (1.0 - var69);
               }

               int var72 = (int)((var66 < 0.0 ? 0.0 : (var66 > 1.0 ? 1.0 : var66)) * 255.0 + 0.5);
               var0[(var2 + var10) * (311048822 ^ 311049846) + var1 + var11] = var72 << 24 | 216838817 ^ 202591582;
            }
         }
      } catch (RuntimeException var64) {
         throw var64;
      }
   }

   private static void n(int[] var0) {

      assert var0 != null
         && var0.length == (1286641379 ^ 1285592803)
         && CX.length == 27
         && CY.length == 27
         && CS.length == 27
         && CH.length == 27
         && U0.length == 27
         && V1.length == 27
         && CX[22] >= 0
         && CY[22] >= 0
         && CX[22] + CS[22] <= (578387319 ^ 578386295)
         && CY[22] + CH[22] <= (-1246761276 ^ -1246762300)
         && (CX[22] & 15) == 0
         && (CY[22] & 15) == 0
         && CS[22] == (-1760150313 ^ -1760150441)
         && CH[22] == (1787008821 ^ 1787008949)
         && U0[22] < U1[22]
         && V0[22] < V1[22]
         && var0[CY[22] * (-1526553747 ^ -1526552723) + CX[22]] == (1148207235 ^ 1150271356)
         && var0[(CY[22] + CH[22] - 1) * (-799389865 ^ -799390889) + CX[22] + CS[22] - 1] == (-639778088 ^ -652067545);

      try {
         int var1 = CX[22];
         int var2 = CY[22];
         int var3 = CS[22];
         double[][] var4 = new double[8][];
         long var5 = 388817L;

         for (int var7 = 0; var7 < 8; var7++) {
            int var8 = (4 << (var7 & 3)) + 1;
            double[] var9 = new double[var8 * var8];

            for (int var10 = 0; var10 < var9.length; var10++) {
               var5 = var5 * 6364136223846793005L + 1442695040888963407L;
               var9[var10] = (double)(var5 >>> 33 & 16777215L) / 1.6777216E7;
            }

            var4[var7] = var9;
         }

         double var55 = (double)var3 * 0.5;

         for (int var56 = 0; var56 < var3; var56++) {
            for (int var57 = 0; var57 < var3; var57++) {
               double var11 = ((double)var57 + 0.5) / (double)var3;
               double var13 = ((double)var56 + 0.5) / (double)var3;
               double var15 = 0.0;
               double var17 = 0.0;
               double var19 = 0.5;
               double var21 = 0.0;

               for (int var23 = 0; var23 < 4; var23++) {
                  int var24 = 4 << var23;
                  double var25 = var11 * (double)var24;
                  double var27 = var13 * (double)var24;
                  int var29 = (int)var25;
                  int var30 = (int)var27;
                  if (var29 >= var24) {
                     var29 = var24 - 1;
                  }

                  if (var30 >= var24) {
                     var30 = var24 - 1;
                  }

                  double var31 = var25 - (double)var29;
                  double var33 = var27 - (double)var30;
                  var31 = var31 * var31 * (3.0 - 2.0 * var31);
                  var33 = var33 * var33 * (3.0 - 2.0 * var33);
                  int var35 = var24 + 1;
                  double[] var36 = var4[var23];
                  double[] var37 = var4[var23 + 4];
                  double var38 = var36[var30 * var35 + var29];
                  double var40 = var36[var30 * var35 + var29 + 1];
                  double var42 = var36[(var30 + 1) * var35 + var29];
                  double var44 = var36[(var30 + 1) * var35 + var29 + 1];
                  double var46 = var37[var30 * var35 + var29];
                  double var48 = var37[var30 * var35 + var29 + 1];
                  double var50 = var37[(var30 + 1) * var35 + var29];
                  double var52 = var37[(var30 + 1) * var35 + var29 + 1];
                  var15 += var19 * (var38 + (var40 - var38) * var31 + (var42 + (var44 - var42) * var31 - (var38 + (var40 - var38) * var31)) * var33);
                  var17 += var19 * (var46 + (var48 - var46) * var31 + (var50 + (var52 - var50) * var31 - (var46 + (var48 - var46) * var31)) * var33);
                  var21 += var19;
                  var19 *= 0.5;
               }

               var15 /= var21;
               var17 /= var21;
               double var60 = ((double)var57 + 0.5 - var55) / var55;
               double var61 = ((double)var56 + 0.5 - var55) / var55;
               double var62 = Math.sqrt(var60 * var60 + var61 * var61);
               double var63 = var62 * (1.0 + 0.3 * (var17 - 0.5));
               double var65 = (var63 - 0.2) / 0.72;
               var65 = var65 < 0.0 ? 0.0 : (var65 > 1.0 ? 1.0 : var65);
               double var68 = 1.0 - var65 * var65 * (3.0 - 2.0 * var65);
               double var69 = Math.pow(var68, 1.3) * (0.5 + 0.5 * var15);
               double var71 = (0.97 - var62) / 0.05;
               var71 = var71 < 0.0 ? 0.0 : (var71 > 1.0 ? 1.0 : var71);
               var69 *= var71;
               int var39 = (int)((var69 < 0.0 ? 0.0 : (var69 > 1.0 ? 1.0 : var69)) * 255.0 + 0.5);
               var0[(var2 + var56) * (138712030 ^ 138713054) + var1 + var57] = var39 << 24 | -311827759 ^ -308929234;
            }
         }
      } catch (RuntimeException var54) {
         throw var54;
      }
   }

   private static void o(int[] var0) {

      assert var0 != null
         && var0.length == (-220582262 ^ -221630838)
         && CX.length == 27
         && CY.length == 27
         && CS.length == 27
         && CH.length == 27
         && U0.length == 27
         && V1.length == 27
         && CX[23] >= 0
         && CY[23] >= 0
         && CX[23] + CS[23] <= (1267553260 ^ 1267554284)
         && CY[23] + CH[23] <= (-1756875422 ^ -1756876446)
         && (CX[23] & 15) == 0
         && (CY[23] & 15) == 0
         && CS[23] == (-634187142 ^ -634187014)
         && CH[23] == (275514175 ^ 275514303)
         && U0[23] == ((float)CX[23] + 17.0F) / 1024.0F
         && V0[23] == ((float)CY[23] + 17.0F) / 1024.0F
         && U1[23] == ((float)(CX[23] + CS[23]) - 17.0F) / 1024.0F
         && V1[23] == ((float)(CY[23] + CH[23]) - 17.0F) / 1024.0F
         && var0[CY[23] * (1411502375 ^ 1411503399) + CX[23]] == (48666257 ^ 35219822);

      try {
         int var1 = CX[23];
         int var2 = CY[23];
         int var3 = CS[23];
         byte var4 = 16;
         int var5 = var3 - 2 * var4;
         double var6 = (double)var5 * 0.5;

         for (int var8 = 0; var8 < var3; var8++) {
            for (int var9 = 0; var9 < var3; var9++) {
               if (var9 >= var4 && var8 >= var4 && var9 < var3 - var4 && var8 < var3 - var4) {
                  double var10 = ((double)(var9 - var4) + 0.5 - var6) / var6;
                  double var12 = ((double)(var8 - var4) + 0.5 - var6) / var6;
                  double var14 = Math.sqrt(var10 * var10 + var12 * var12);
                  double var16 = Math.sqrt(Math.sqrt(var10 * var10 * var10 * var10 + var12 * var12 * var12 * var12));
                  double var18 = 0.5 * var14 + 0.5 * var16;
                  double var20 = (var18 - 0.42) / 0.76;
                  var20 = var20 < 0.0 ? 0.0 : (var20 > 1.0 ? 1.0 : var20);
                  double var22 = Math.pow(var20 * var20 * (3.0 - 2.0 * var20), 1.7);
                  int var24 = (int)((var22 < 0.0 ? 0.0 : (var22 > 1.0 ? 1.0 : var22)) * 255.0 + 0.5);
                  var0[(var2 + var8) * (-1603038100 ^ -1603039124) + var1 + var9] = var24 << 24 | -246861339 ^ -239677926;
               } else {
                  var0[(var2 + var8) * (-1511868894 ^ -1511869918) + var1 + var9] = 16777215;
               }
            }
         }
      } catch (RuntimeException var25) {
         throw var25;
      }
   }

   private static void p(int[] var0) {

      assert var0 != null
         && var0.length == (1853860860 ^ 1852812284)
         && CX.length == 27
         && CY.length == 27
         && CS.length == 27
         && CH.length == 27
         && U0.length == 27
         && V1.length == 27
         && CX[24] >= 0
         && CY[24] >= 0
         && CX[24] + CS[24] <= (-2043772198 ^ -2043771174)
         && CY[24] + CH[24] <= (367089652 ^ 367088628)
         && (CX[24] & 15) == 0
         && (CY[24] & 15) == 0
         && CS[24] == (1718640547 ^ 1718640419)
         && CH[24] == (495098346 ^ 495098218)
         && U0[24] < U1[24]
         && V0[24] < V1[24]
         && var0[CY[24] * (-821211550 ^ -821212574) + CX[24]] == (-1202670124 ^ -1196471765)
         && var0[(CY[24] + CH[24] - 1) * (393510377 ^ 393509353) + CX[24] + CS[24] - 1] == (2998621 ^ 13778594);

      try {
         int var1 = CX[24];
         int var2 = CY[24];
         int var3 = CS[24];
         double[][] var4 = new double[8][];
         long var5 = 45237L;

         for (int var7 = 0; var7 < 8; var7++) {
            int var8 = (4 << (var7 & 3)) + 1;
            double[] var9 = new double[var8 * var8];

            for (int var10 = 0; var10 < var9.length; var10++) {
               var5 = var5 * 6364136223846793005L + 1442695040888963407L;
               var9[var10] = (double)(var5 >>> 33 & 16777215L) / 1.6777216E7;
            }

            var4[var7] = var9;
         }

         double var55 = (double)var3 * 0.5;

         for (int var56 = 0; var56 < var3; var56++) {
            for (int var57 = 0; var57 < var3; var57++) {
               double var11 = ((double)var57 + 0.5) / (double)var3;
               double var13 = ((double)var56 + 0.5) / (double)var3;
               double var15 = 0.0;
               double var17 = 0.0;
               double var19 = 0.5;
               double var21 = 0.0;

               for (int var23 = 0; var23 < 4; var23++) {
                  int var24 = 4 << var23;
                  double var25 = var11 * (double)var24;
                  double var27 = var13 * (double)var24;
                  int var29 = (int)var25;
                  int var30 = (int)var27;
                  if (var29 >= var24) {
                     var29 = var24 - 1;
                  }

                  if (var30 >= var24) {
                     var30 = var24 - 1;
                  }

                  double var31 = var25 - (double)var29;
                  double var33 = var27 - (double)var30;
                  var31 = var31 * var31 * (3.0 - 2.0 * var31);
                  var33 = var33 * var33 * (3.0 - 2.0 * var33);
                  int var35 = var24 + 1;
                  double[] var36 = var4[var23];
                  double[] var37 = var4[var23 + 4];
                  double var38 = var36[var30 * var35 + var29];
                  double var40 = var36[var30 * var35 + var29 + 1];
                  double var42 = var36[(var30 + 1) * var35 + var29];
                  double var44 = var36[(var30 + 1) * var35 + var29 + 1];
                  double var46 = var37[var30 * var35 + var29];
                  double var48 = var37[var30 * var35 + var29 + 1];
                  double var50 = var37[(var30 + 1) * var35 + var29];
                  double var52 = var37[(var30 + 1) * var35 + var29 + 1];
                  var15 += var19 * (var38 + (var40 - var38) * var31 + (var42 + (var44 - var42) * var31 - (var38 + (var40 - var38) * var31)) * var33);
                  var17 += var19 * (var46 + (var48 - var46) * var31 + (var50 + (var52 - var50) * var31 - (var46 + (var48 - var46) * var31)) * var33);
                  var21 += var19;
                  var19 *= 0.5;
               }

               var15 /= var21;
               var17 /= var21;
               double var60 = ((double)var57 + 0.5 - var55) / var55;
               double var61 = ((double)var56 + 0.5 - var55) / var55;
               double var62 = Math.sqrt(var60 * var60 + var61 * var61);
               double var63 = Math.atan2(var61, var60);
               double var65 = var62 * (1.0 + 0.35 * (var15 - 0.5));
               double var67 = (var65 - 0.3) / 0.6;
               var67 = var67 < 0.0 ? 0.0 : (var67 > 1.0 ? 1.0 : var67);
               double var69 = (1.0 - var67 * var67 * (3.0 - 2.0 * var67)) * (0.55 + 0.45 * var17);
               double var72 = 0.0;

               for (int var39 = 0; var39 < 11; var39++) {
                  double var75 = (Math.PI * 2) * (double)var39 / 11.0 + 0.4 * Math.sin(3.7 * (double)var39);
                  double var76 = var63 - var75;
                  var76 -= (Math.PI * 2) * Math.floor((var76 + Math.PI) / (Math.PI * 2));
                  double var78 = 0.55 + 0.4 * (0.618 * (double)var39 - Math.floor(0.618 * (double)var39));
                  if (var62 > 0.25 && var62 < var78) {
                     double var79 = 0.045 / Math.max(var62, 0.05);
                     double var80 = Math.abs(var76) / var79;
                     double var81 = var80 < 1.0 ? (1.0 - var80 * var80) * (1.0 - (var62 - 0.25) / (var78 - 0.25)) : 0.0;
                     if (var81 > var72) {
                        var72 = var81;
                     }
                  }
               }

               var69 += (1.0 - var69) * 0.55 * var72;
               double var73 = (0.97 - var62) / 0.05;
               var73 = var73 < 0.0 ? 0.0 : (var73 > 1.0 ? 1.0 : var73);
               var69 *= var73;
               int var41 = (int)((var69 < 0.0 ? 0.0 : (var69 > 1.0 ? 1.0 : var69)) * 255.0 + 0.5);
               var0[(var2 + var56) * (667100758 ^ 667099734) + var1 + var57] = var41 << 24 | -614554138 ^ -610182631;
            }
         }
      } catch (RuntimeException var54) {
         throw var54;
      }
   }

   private static void q(int[] var0) {

      assert var0 != null
         && var0.length == (-825350446 ^ -824301870)
         && CX.length == 27
         && CY.length == 27
         && CS.length == 27
         && CH.length == 27
         && U0.length == 27
         && V1.length == 27
         && CX[25] >= 0
         && CY[25] >= 0
         && CX[25] + CS[25] <= (1249390458 ^ 1249389434)
         && CY[25] + CH[25] <= (867566916 ^ 867565892)
         && (CX[25] & 15) == 0
         && (CY[25] & 15) == 0
         && CS[25] == (-303600131 ^ -303600387)
         && CH[25] == (-1910576968 ^ -1910576712)
         && U0[25] < U1[25]
         && V0[25] < V1[25]
         && var0[CY[25] * (1862864734 ^ 1862863710) + CX[25]] == (-47119488 ^ -36766593)
         && var0[(CY[25] + CH[25] - 1) * (-1642367595 ^ -1642368619) + CX[25] + CS[25] - 1] == (-1522875868 ^ -1513800229);

      try {
         int var1 = CX[25];
         int var2 = CY[25];
         int var3 = CS[25];
         double var4 = (double)var3 * 0.5;
         double var6 = 1.2 / var4;
         double var8 = 0.86F;

         for (int var10 = 0; var10 < var3; var10++) {
            for (int var11 = 0; var11 < var3; var11++) {
               double var12 = ((double)var11 + 0.5 - var4) / var4;
               double var14 = ((double)var10 + 0.5 - var4) / var4;
               double var16 = Math.sqrt(var12 * var12 + var14 * var14);
               double var18 = Math.abs(var16 - var8);
               double var20 = (0.012 - var18) / var6 + 0.5;
               var20 = var20 < 0.0 ? 0.0 : (var20 > 1.0 ? 1.0 : var20);
               double var22 = var16 < var8 ? 0.08 + 0.62 * Math.pow(var16 / var8, 6.0) : 0.55 * Math.exp(-(var16 - var8) / 0.045);
               double var24 = var20 + var22 * (1.0 - var20);
               double var26 = (0.99 - var16) / 0.04;
               var26 = var26 < 0.0 ? 0.0 : (var26 > 1.0 ? 1.0 : var26);
               var24 *= var26;
               int var28 = (int)((var24 < 0.0 ? 0.0 : (var24 > 1.0 ? 1.0 : var24)) * 255.0 + 0.5);
               var0[(var2 + var10) * (1969528876 ^ 1969529900) + var1 + var11] = var28 << 24 | -2050665267 ^ -2059752654;
            }
         }
      } catch (RuntimeException var29) {
         throw var29;
      }
   }

   private static void r(int[] var0) {

      assert var0 != null
         && var0.length == (-1676292196 ^ -1677340772)
         && CX.length == 27
         && CY.length == 27
         && CS.length == 27
         && CH.length == 27
         && U0.length == 27
         && V1.length == 27
         && CX[26] >= 0
         && CY[26] >= 0
         && CX[26] + CS[26] <= (-1415948008 ^ -1415946984)
         && CY[26] + CH[26] <= (1045191519 ^ 1045192543)
         && (CX[26] & 15) == 0
         && (CY[26] & 15) == 0
         && CS[26] == (484958775 ^ 484958903)
         && CH[26] == (-1808331116 ^ -1808330860)
         && U0[26] < U1[26]
         && V0[26] < V1[26]
         && var0[CY[26] * (1215873627 ^ 1215874651) + CX[26]] == (1888042641 ^ 1886830958)
         && var0[(CY[26] + CH[26] - 1) * (893739049 ^ 893740073) + CX[26] + CS[26] - 1] == (-590199494 ^ -600982843);

      try {
         int var1 = CX[26];
         int var2 = CY[26];
         int var3 = CS[26];
         int var4 = CH[26];

         for (int var5 = 0; var5 < var4; var5++) {
            for (int var6 = 0; var6 < var3; var6++) {
               double var7 = (double)var6 + 0.5;
               double var9 = (double)var5 + 0.5;
               double var11 = var7 - 64.0;
               double var13 = var9 - 46.0;
               double var15 = Math.sqrt(var11 * var11 + var13 * var13) - 21.0;
               double var17 = (var9 - 82.0) / 68.0;
               var17 = var17 < 0.0 ? 0.0 : (var17 > 1.0 ? 1.0 : var17);
               double var19 = 82.0 + 68.0 * var17;
               double var21 = 25.0 - 10.0 * var17;
               double var23 = Math.sqrt((var7 - 64.0) * (var7 - 64.0) + (var9 - var19) * (var9 - var19)) - var21;
               double var25 = (var9 - 150.0) / 88.0;
               var25 = var25 < 0.0 ? 0.0 : (var25 > 1.0 ? 1.0 : var25);
               double var27 = 150.0 + 88.0 * var25;
               double var29 = 15.0 - 13.0 * var25;
               double var31 = 6.0 * Math.sin((var9 - 150.0) / 26.0) * var25;
               double var33 = Math.sqrt((var7 - 64.0 - var31) * (var7 - 64.0 - var31) + (var9 - var27) * (var9 - var27)) - var29;
               double var35 = 1.0E9;

               for (int var37 = 0; var37 < 2; var37++) {
                  double var38 = var37 == 0 ? 44.0 : 84.0;
                  double var40 = 86.0;
                  double var42 = var37 == 0 ? 16.0 : 112.0;
                  double var44 = 58.0;
                  double var46 = var42 - var38;
                  double var48 = var44 - var40;
                  double var50 = var7 - var38;
                  double var52 = var9 - var40;
                  double var54 = (var50 * var46 + var52 * var48) / (var46 * var46 + var48 * var48);
                  var54 = var54 < 0.0 ? 0.0 : (var54 > 1.0 ? 1.0 : var54);
                  double var56 = var50 - var46 * var54;
                  double var58 = var52 - var48 * var54;
                  double var60 = Math.sqrt(var56 * var56 + var58 * var58) - (8.0 - 2.5 * var54);
                  if (var60 < var35) {
                     var35 = var60;
                  }
               }

               double var39 = 10.0;
               double var41 = Math.max(var39 - Math.abs(var15 - var23), 0.0);
               double var65 = Math.min(var15, var23) - var41 * var41 * 0.25 / var39;
               var41 = Math.max(var39 - Math.abs(var65 - var35), 0.0);
               var65 = Math.min(var65, var35) - var41 * var41 * 0.25 / var39;
               var41 = Math.max(var39 - Math.abs(var65 - var33), 0.0);
               var65 = Math.min(var65, var33) - var41 * var41 * 0.25 / var39;
               double var43 = (7.0 - var65) / 12.0;
               var43 = var43 < 0.0 ? 0.0 : (var43 > 1.0 ? 1.0 : var43);
               var43 = var43 * var43 * (3.0 - 2.0 * var43);
               double var45 = (-2.0 - var65) / 14.0;
               var45 = var45 < 0.0 ? 0.0 : (var45 > 1.0 ? 1.0 : var45);
               var45 = var45 * var45 * (3.0 - 2.0 * var45);
               double var47 = var43 * (0.62 + 0.38 * var45);
               if (var9 > 150.0) {
                  double var49 = 1.0 - (var9 - 150.0) / 95.0;
                  var49 = var49 < 0.0 ? 0.0 : var49;
                  var47 *= Math.pow(var49, 1.4);
               }

               double var77 = var65 > 0.0 ? 0.3 * Math.exp(-var65 / 9.0) : 0.3;
               if (var9 > 150.0) {
                  double var51 = 1.0 - (var9 - 150.0) / 95.0;
                  var77 *= var51 < 0.0 ? 0.0 : var51 * var51;
               }

               var47 += var77 * (1.0 - var47);
               double var78 = Math.min(Math.min(var7, (double)var3 - var7), Math.min(var9, (double)var4 - var9));
               double var53 = (var78 - 1.0) / 3.0;
               var53 = var53 < 0.0 ? 0.0 : (var53 > 1.0 ? 1.0 : var53);
               var47 *= var53;
               int var55 = (int)((var47 < 0.0 ? 0.0 : (var47 > 1.0 ? 1.0 : var47)) * 255.0 + 0.5);
               var0[(var2 + var5) * (-2023738543 ^ -2023737519) + var1 + var6] = var55 << 24 | 1621593225 ^ 1616409462;
            }
         }
      } catch (RuntimeException var62) {
         throw var62;
      }
   }

   static {
      for (int var0 = 0; var0 < 27; var0++) {
         float var1 = (float)CX[var0];
         float var2 = (float)CY[var0];
         U0[var0] = var1 / 1024.0F;
         V0[var0] = var2 / 1024.0F;
         U1[var0] = (var1 + (float)CS[var0]) / 1024.0F;
         V1[var0] = (var2 + (float)CH[var0]) / 1024.0F;
      }

      U0[0] = U1[0] = ((float)CX[0] + 32.0F) / 1024.0F;
      V0[0] = V1[0] = ((float)CY[0] + 32.0F) / 1024.0F;
      U0[1] = U1[1] = ((float)CX[1] + 32.0F) / 1024.0F;
      U0[2] = U1[2] = ((float)CX[2] + 32.0F) / 1024.0F;
      U0[20] = U1[20] = ((float)CX[20] + 32.0F) / 1024.0F;
      U0[23] = ((float)CX[23] + 17.0F) / 1024.0F;
      V0[23] = ((float)CY[23] + 17.0F) / 1024.0F;
      U1[23] = ((float)(CX[23] + CS[23]) - 17.0F) / 1024.0F;
      V1[23] = ((float)(CY[23] + CH[23]) - 17.0F) / 1024.0F;
   }
}
