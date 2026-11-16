package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

public final class SliceArrayCache {
   public static final int W = 1024;
   public static final int H = 256;
   private static final int[] b = new int[]{36, 90, 200, 48, 24};

   private SliceArrayCache() {
   }

   public static int[] a() {

      int[] var0 = new int[262144];
      double[] var1 = new double[5];

      for (int var2 = 0; var2 < (1437108422 ^ 1437109446); var2++) {
         double var3 = ((double)var2 + 0.5) / 1024.0;

         for (int var5 = 0; var5 < 5; var5++) {
            int var6 = b[var5];
            double var7 = var3 * (double)var6;
            int var9 = (int)var7;
            double var10 = var7 - (double)var9;
            var10 = var10 * var10 * (3.0 - 2.0 * var10);
            int var12 = var9 % var6;
            int var13 = (var9 + 1) % var6;
            int var14 = var5 + 1;
            int var15 = var12 * (612212165 ^ -1169496972) + var14 * (-1951344883 ^ 240852326);
            var15 ^= var15 >>> 15;
            var15 *= 1871586132 ^ 1133846329;
            var15 ^= var15 >>> 12;
            var15 *= -455088400 ^ -844772407;
            var15 ^= var15 >>> 15;
            int var16 = var13 * (-291546222 ^ 1890066979) + var14 * (245942541 ^ -1958542490);
            var16 ^= var16 >>> 15;
            var16 *= 1967438568 ^ 1499432581;
            var16 ^= var16 >>> 12;
            var16 *= 55482847 ^ 708097254;
            var16 ^= var16 >>> 15;
            double var17 = (double)(var15 >>> 8) / 1.6777216E7;
            double var19 = (double)(var16 >>> 8) / 1.6777216E7;
            var1[var5] = var17 + (var19 - var17) * var10;
         }

         double var41 = (0.5 * var1[0] + 0.3 * var1[1] + 0.2 * var1[2] - 0.38) * 1.923076923076923;
         var41 = var41 <= 0.0 ? 0.0 : (var41 >= 1.0 ? 1.0 : var41);
         var41 = var41 * var41 * (3.0 - 2.0 * var41);
         double var44 = 0.4 + 0.55 * var1[3];
         double var45 = 0.55 + 0.45 * var1[4];

         for (int var11 = 0; var11 < (1961097470 ^ 1961097726); var11++) {
            double var47 = 1.0 - ((double)var11 + 0.5) / 256.0;
            double var48 = var47 * 28.57142857142857;
            var48 = var48 >= 1.0 ? 1.0 : var48;
            double var78 = var48 * var48 * (3.0 - 2.0 * var48);
            double var18 = var47 < 0.05 ? 1.0 : Math.exp(-(var47 - 0.05) / 0.2);
            double var20 = var47 < 0.05 ? 1.0 : Math.exp(-(var47 - 0.05) / 0.32);
            var48 = (var47 - var44 + 0.15) * 3.7037037037037033;
            var48 = var48 <= 0.0 ? 0.0 : (var48 >= 1.0 ? 1.0 : var48);
            double var22 = 1.0 - var48 * var48 * (3.0 - 2.0 * var48);
            double var24 = (var47 - 0.045) / 0.022;
            double var26 = Math.exp(-var24 * var24);
            var48 = (var47 - 0.45) * 4.0;
            var48 = var48 <= 0.0 ? 0.0 : (var48 >= 1.0 ? 1.0 : var48);
            double var28 = var48 * var48 * (3.0 - 2.0 * var48);
            double var30 = var78
               * (
                  0.46 * var18 * (0.45 + 0.55 * var41) * var45
                     + 0.26 * var20 * var41 * var22
                     + 0.42 * var26 * (0.7 + 0.3 * var41)
                     + 0.1 * var28 * var41 * (0.4 + 0.6 * var22)
               );
            var48 = (var47 - 0.82) * 5.555555555555555;
            var48 = var48 <= 0.0 ? 0.0 : (var48 >= 1.0 ? 1.0 : var48);
            var30 *= 1.0 - var48 * var48 * (3.0 - 2.0 * var48);
            double var32;
            double var34;
            double var36;
            if (var47 < 0.05) {
               var48 = var47 * 35.714285714285715;
               var48 = var48 >= 1.0 ? 1.0 : var48;
               var48 = var48 * var48 * (3.0 - 2.0 * var48);
               var32 = 0.7 - 0.32 * var48;
               var34 = 0.35 + 0.65 * var48;
               var36 = 0.62 - 0.17 * var48;
            } else if (var47 < 0.3) {
               var48 = (var47 - 0.05) * 4.0;
               var48 = var48 * var48 * (3.0 - 2.0 * var48);
               var32 = 0.38 + 0.02 * var48;
               var34 = 1.0 - 0.04 * var48;
               var36 = 0.45;
            } else if (var47 < 0.55) {
               var48 = (var47 - 0.3) * 4.0;
               var48 = var48 * var48 * (3.0 - 2.0 * var48);
               var32 = 0.4 + 0.25 * var48;
               var34 = 0.96 - 0.36 * var48;
               var36 = 0.45 + 0.05 * var48;
            } else if (var47 < 0.78) {
               var48 = (var47 - 0.55) * 4.3478260869565215;
               var48 = var48 * var48 * (3.0 - 2.0 * var48);
               var32 = 0.65 + 0.27 * var48;
               var34 = 0.6 - 0.34 * var48;
               var36 = 0.5 + 0.02 * var48;
            } else {
               var48 = (var47 - 0.78) * 4.545454545454546;
               var48 = var48 >= 1.0 ? 1.0 : var48;
               var48 = var48 * var48 * (3.0 - 2.0 * var48);
               var32 = 0.92 + 0.03 * var48;
               var34 = 0.26 - 0.04 * var48;
               var36 = 0.52 - 0.04 * var48;
            }

            double var38 = var30 * 2.4;
            int var40 = (int)((var38 >= 1.0 ? 1.0 : var38) * 255.0 + 0.5);
            var0[var11 * (287433922 ^ 287432898) + var2] = var40 << 24
               | (int)(var32 * 255.0 + 0.5) << 16
               | (int)(var34 * 255.0 + 0.5) << 8
               | (int)(var36 * 255.0 + 0.5);
         }
      }

      return var0;
   }
}
