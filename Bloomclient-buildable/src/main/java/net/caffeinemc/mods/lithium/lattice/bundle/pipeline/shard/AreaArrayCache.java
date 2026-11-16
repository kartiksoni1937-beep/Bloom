package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

public final class AreaArrayCache {
   public static final int W = 512;
   public static final int H = 256;
   private static final int e = 256;

   private AreaArrayCache() {
   }

   public static int[] a() {

      int[] var0 = new int[131072];
      float[] var1 = d();

      assert var0.length == (-184093760 ^ -184224832)
         && var1.length == (-1347305753 ^ -1347309849)
         && var1[0] >= 0.0F
         && var1[0] <= 1.0F
         && var1[63] >= 0.0F
         && var1[63] <= 1.0F
         && var1[64] >= 0.0F
         && var1[64] <= 1.0F
         && var1[1868131380 ^ 1868131275] >= 0.0F
         && var1[250561507 ^ 250561564] <= 1.0F
         && var1[-1220548768 ^ -1220548448] >= 0.0F
         && var1[1307457913 ^ 1307457209] <= 1.0F
         && var1[-11153920 ^ -11156993] >= 0.0F
         && var1[234782878 ^ 234786657] <= 1.0F : "bake: bad nois" + "e ta" + "b" + "le";

      try {
         for (int var2 = 0; var2 < (-1635149530 ^ -1635149786); var2++) {
            double var3 = ((double)var2 + 0.5) / 128.0 - 1.0;

            for (int var5 = 0; var5 < (-1699998672 ^ -1699998416); var5++) {
               double var6 = ((double)var5 + 0.5) / 128.0 - 1.0;
               double var8 = Math.sqrt(var6 * var6 + var3 * var3);
               double var10 = (var8 - 0.78) / 0.52;
               var10 = var10 < 0.0 ? 0.0 : (var10 > 1.0 ? 1.0 : var10);
               var10 = var10 * var10 * (3.0 - 2.0 * var10);
               var10 *= var10;
               int var12 = (int)(var10 * 255.0 + 0.5);
               var0[var2 * (-1845369906 ^ -1845370418) + var5] = var12 << 24 | 835904704 ^ 825039679;
               double var13 = Math.atan2(var3, var6);
               double var15 = c(var1, var6 * 3.1 + 21.0, var3 * 3.1 + 13.0, 3);
               double var17 = (var15 - 0.4) / 0.26;
               var17 = var17 < 0.0 ? 0.0 : (var17 > 1.0 ? 1.0 : var17);
               var17 = var17 * var17 * (3.0 - 2.0 * var17);
               double var19 = (var13 + Math.PI) * 20.3718328;
               double var21 = b(var1, var19, var8 * 8.5, 3);
               var21 = 1.0 - Math.abs(2.0 * var21 - 1.0);
               var21 *= var21;
               var21 *= var21;
               double var23 = 0.62 + 0.3 * var15;
               double var25 = (var8 - var23) / (1.18 - var23);
               var25 = var25 < 0.0 ? 0.0 : (var25 > 1.0 ? 1.0 : var25);
               var25 = var25 * var25 * (3.0 - 2.0 * var25);
               double var27 = var25 * var17 * (0.06 + 1.5 * var21);
               double var29 = b(var1, var19 * 2.0 + 11.0, var8 * 17.0 + 5.0, 2);
               var29 = 1.0 - Math.abs(2.0 * var29 - 1.0);
               var29 *= var29;
               var29 *= var29;
               var27 += var29 * 0.8 * var25 * var17;
               var27 = var27 < 0.0 ? 0.0 : (var27 > 1.0 ? 1.0 : var27);
               int var31 = (int)(var27 * 255.0 + 0.5);
               var0[var2 * (-1459801734 ^ -1459801222) + (-67537285 ^ -67537029) + var5] = var31 << 24 | 752119938 ^ 741052285;
            }
         }

         return var0;
      } catch (RuntimeException var32) {
         throw var32;
      }
   }

   private static double b(float[] var0, double var1, double var3, int var5) {

      assert var0 != null
         && var0.length == (-1463251468 ^ -1463247372)
         && var5 >= 1
         && var5 <= 3
         && var1 >= 0.0
         && var1 <= 512.0
         && var3 >= 0.0
         && var3 <= 64.0
         && var0[0] >= 0.0F
         && var0[0] <= 1.0F
         && var0[63] >= 0.0F
         && var0[63] <= 1.0F
         && var0[64] >= 0.0F
         && var0[64] <= 1.0F
         && var0[1362410204 ^ 1362408732] >= 0.0F
         && var0[1789163439 ^ 1789163631] <= 1.0F
         && var0[367242837 ^ 367239594] >= 0.0F
         && var0[1375323457 ^ 1375324862] <= 1.0F : "wrapFbm: bad args";

      try {
         double var6 = 0.0;
         double var8 = 0.5;
         double var10 = 0.0;

         for (int var12 = 0; var12 < var5; var12++) {
            int var13 = (int)Math.floor(var1);
            int var14 = (int)Math.floor(var3);
            double var15 = var1 - (double)var13;
            double var17 = var3 - (double)var14;
            var15 = var15 * var15 * (3.0 - 2.0 * var15);
            var17 = var17 * var17 * (3.0 - 2.0 * var17);
            int var19 = (var14 & 63) << 6;
            int var20 = (var14 + 1 & 63) << 6;
            int var21 = var13 & 63;
            int var22 = var13 + 1 & 63;
            double var23 = (double)var0[var19 | var21] + (double)(var0[var19 | var22] - var0[var19 | var21]) * var15;
            double var25 = (double)var0[var20 | var21] + (double)(var0[var20 | var22] - var0[var20 | var21]) * var15;
            var6 += var8 * (var23 + (var25 - var23) * var17);
            var10 += var8;
            var1 *= 2.0;
            var3 *= 2.0;
            var8 *= 0.5;
         }

         return var6 / var10;
      } catch (RuntimeException var27) {
         throw var27;
      }
   }

   private static double c(float[] var0, double var1, double var3, int var5) {

      assert var0 != null
         && var0.length == (105244371 ^ 105248467)
         && var5 >= 1
         && var5 <= 3
         && var1 >= 0.0
         && var1 <= 64.0
         && var3 >= 0.0
         && var3 <= 64.0
         && var0[0] >= 0.0F
         && var0[0] <= 1.0F
         && var0[63] >= 0.0F
         && var0[63] <= 1.0F
         && var0[64] >= 0.0F
         && var0[64] <= 1.0F
         && var0[-1496792089 ^ -1496789977] >= 0.0F
         && var0[136817320 ^ 136815976] <= 1.0F
         && var0[1828588262 ^ 1828586777] >= 0.0F
         && var0[-76283489 ^ -76280224] <= 1.0F : "fbm:" + " bad args";

      try {
         double var6 = 0.0;
         double var8 = 0.5;
         double var10 = 0.0;

         for (int var12 = 0; var12 < var5; var12++) {
            int var13 = (int)Math.floor(var1);
            int var14 = (int)Math.floor(var3);
            double var15 = var1 - (double)var13;
            double var17 = var3 - (double)var14;
            var15 = var15 * var15 * (3.0 - 2.0 * var15);
            var17 = var17 * var17 * (3.0 - 2.0 * var17);
            int var19 = (var14 & 63) << 6;
            int var20 = (var14 + 1 & 63) << 6;
            int var21 = var13 & 63;
            int var22 = var13 + 1 & 63;
            double var23 = (double)var0[var19 | var21] + (double)(var0[var19 | var22] - var0[var19 | var21]) * var15;
            double var25 = (double)var0[var20 | var21] + (double)(var0[var20 | var22] - var0[var20 | var21]) * var15;
            var6 += var8 * (var23 + (var25 - var23) * var17);
            var10 += var8;
            var1 *= 2.03;
            var3 *= 2.03;
            var8 *= 0.5;
         }

         return var6 / var10;
      } catch (RuntimeException var27) {
         throw var27;
      }
   }

   private static float[] d() {

      float[] var0 = new float[4096];

      for (int var1 = 0; var1 < var0.length; var1++) {
         int var2 = var1 * (-142213545 ^ 1773307886) + (-699773575 ^ -1459605140);
         var2 ^= var2 >>> 16;
         var2 *= 317464715 ^ -1761088800;
         var2 ^= var2 >>> 13;
         var2 *= 80370986 ^ -965151969;
         var2 ^= var2 >>> 16;
         var0[var1] = (float)(var2 & (-1854147740 ^ -1854206821)) / 65535.0F;
      }

      return var0;
   }
}
