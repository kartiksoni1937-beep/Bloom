package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

public final class StrataArrayCache {
   public static final int DW = 256;
   public static final int CH = 1024;
   public static final int DH = 5120;
   public static final int CELL_COOL = 0;
   public static final int CELL_WARM = 1;
   public static final int CELL_FROST = 2;
   public static final int CELL_FCOOL = 3;
   public static final int CELL_FWARM = 4;
   public static final int MW = 1024;
   public static final int MH = 1024;
   private static final int q = 256;
   private static final int r = 512;
   public static final int VIG_V = 768;
   private static final double s = 40.0;
   public static final int NA = 48;
   private static final float t = 18.0F;
   public static final int STRIDE = 6;
   private static final float[] u = new float[]{
      -90.0F, -40.0F, -12.0F, -5.0F, -2.0F, 0.0F, 1.0F, 2.0F, 3.5F, 5.0F, 7.0F, 9.5F, 12.5F, 16.0F, 20.0F, 25.0F, 31.0F, 38.0F, 47.0F, 58.0F, 72.0F, 90.0F
   };
   private static final float[] v = new float[]{-2.0F, -0.5F, 1.0F, 3.0F, 5.5F, 8.5F, 12.0F, 16.0F, 21.0F, 27.0F, 34.0F, 42.0F, 51.0F, 60.0F};
   private static final float[] w = new float[]{1.0F, 3.0F, 5.5F, 8.5F, 12.0F, 16.0F, 21.0F, 27.0F, 34.0F, 42.0F, 51.0F, 62.0F, 75.0F};
   private static final int x = 22;
   private static final int y = 14;
   private static final int z = 13;
   public static final float[] VB = new float[24192];
   private static final float[] aa = new float[22];
   private static final float[] ab = new float[22];
   private static final float[] ac = new float[22];
   private static final float[] ad = new float[14];
   private static final float[] ae = new float[14];
   private static final float[] af = new float[14];
   private static final float[] ag = new float[13];
   private static final float[] ah = new float[13];
   private static final float[] ai = new float[13];
   private static final float[] aj = new float[13];
   private static final float[] ak = new float[49];
   private static final float[] al = new float[49];
   private static final float[] am = new float[1078];
   private static final float[] an = new float[49];
   private static final float[] ao = new float[88];
   private static final float[] ap = new float[]{
      -90.0F,
      40.0F,
      36.0F,
      28.0F,
      -5.0F,
      70.0F,
      60.0F,
      44.0F,
      -2.0F,
      104.0F,
      89.0F,
      64.0F,
      -0.8F,
      160.0F,
      134.0F,
      93.0F,
      0.0F,
      222.0F,
      186.0F,
      122.0F,
      0.62F,
      212.0F,
      178.0F,
      118.0F,
      1.86F,
      182.5F,
      154.3F,
      108.9F,
      3.09F,
      154.9F,
      130.8F,
      97.5F,
      4.33F,
      134.5F,
      115.2F,
      91.5F,
      5.56F,
      116.4F,
      101.7F,
      86.6F,
      6.78F,
      102.7F,
      91.9F,
      84.5F,
      8.0F,
      92.7F,
      86.5F,
      83.5F,
      9.2F,
      88.6F,
      82.2F,
      83.3F,
      10.4F,
      85.1F,
      80.7F,
      83.3F,
      11.6F,
      82.3F,
      78.6F,
      83.2F,
      12.8F,
      78.4F,
      77.4F,
      84.2F,
      14.0F,
      77.0F,
      76.0F,
      85.0F,
      16.3F,
      72.0F,
      72.0F,
      84.0F,
      17.4F,
      70.0F,
      70.0F,
      85.0F,
      18.5F,
      67.0F,
      69.0F,
      85.0F,
      20.7F,
      62.0F,
      68.0F,
      86.0F,
      23.9F,
      60.0F,
      66.0F,
      86.0F,
      27.0F,
      56.0F,
      62.0F,
      84.0F,
      31.6F,
      49.0F,
      59.0F,
      80.0F,
      36.0F,
      46.0F,
      56.0F,
      76.0F,
      55.0F,
      40.0F,
      49.0F,
      70.0F,
      90.0F,
      34.0F,
      42.0F,
      64.0F
   };
   private static final float[] aq = new float[]{
      -90.0F,
      40.0F,
      36.0F,
      28.0F,
      -5.0F,
      72.0F,
      62.0F,
      44.0F,
      -2.0F,
      110.0F,
      92.0F,
      64.0F,
      -0.8F,
      178.0F,
      146.0F,
      99.0F,
      0.0F,
      244.0F,
      202.0F,
      131.0F,
      0.62F,
      236.0F,
      195.0F,
      128.0F,
      1.86F,
      208.0F,
      174.0F,
      119.8F,
      3.09F,
      185.9F,
      154.9F,
      109.0F,
      4.33F,
      164.8F,
      140.9F,
      102.1F,
      5.56F,
      146.9F,
      126.9F,
      96.2F,
      6.78F,
      134.8F,
      116.9F,
      94.1F,
      8.0F,
      117.5F,
      105.3F,
      89.3F,
      9.2F,
      109.4F,
      96.4F,
      86.2F,
      10.4F,
      100.4F,
      90.3F,
      81.3F,
      11.6F,
      95.1F,
      85.4F,
      79.3F,
      12.8F,
      89.2F,
      82.3F,
      79.2F,
      14.0F,
      87.0F,
      81.0F,
      79.0F,
      16.3F,
      81.0F,
      77.0F,
      77.0F,
      17.4F,
      78.0F,
      75.0F,
      76.0F,
      18.5F,
      75.0F,
      73.0F,
      76.0F,
      20.7F,
      72.0F,
      70.0F,
      75.0F,
      22.9F,
      67.0F,
      66.0F,
      73.0F,
      24.9F,
      63.0F,
      63.0F,
      71.0F,
      26.9F,
      60.0F,
      60.0F,
      70.0F,
      30.7F,
      54.0F,
      55.0F,
      69.0F,
      36.0F,
      50.0F,
      51.0F,
      67.0F,
      55.0F,
      44.0F,
      46.0F,
      63.0F,
      90.0F,
      40.0F,
      42.0F,
      60.0F
   };
   private static final float[] ar = new float[]{
      -90.0F,
      120.0F,
      135.0F,
      160.0F,
      -3.0F,
      170.0F,
      182.0F,
      200.0F,
      -1.0F,
      196.0F,
      206.0F,
      222.0F,
      0.0F,
      208.0F,
      218.0F,
      238.0F,
      0.62F,
      206.0F,
      217.0F,
      238.0F,
      1.86F,
      202.0F,
      214.0F,
      237.0F,
      3.09F,
      196.0F,
      210.0F,
      236.0F,
      4.33F,
      190.0F,
      205.0F,
      234.0F,
      6.78F,
      180.0F,
      198.0F,
      231.0F,
      9.2F,
      170.0F,
      191.0F,
      228.0F,
      11.6F,
      160.0F,
      184.0F,
      225.0F,
      14.0F,
      152.0F,
      178.0F,
      222.0F,
      18.5F,
      140.0F,
      169.0F,
      218.0F,
      22.9F,
      128.0F,
      160.0F,
      214.0F,
      27.0F,
      118.0F,
      152.0F,
      211.0F,
      31.6F,
      108.0F,
      145.0F,
      208.0F,
      35.1F,
      100.0F,
      139.0F,
      205.0F,
      45.0F,
      84.0F,
      127.0F,
      200.0F,
      60.0F,
      66.0F,
      113.0F,
      194.0F,
      90.0F,
      46.0F,
      96.0F,
      186.0F
   };
   private static final float[] as = new float[]{
      -90.0F,
      24.0F,
      26.0F,
      40.0F,
      -5.0F,
      34.0F,
      36.0F,
      56.0F,
      -2.0F,
      40.0F,
      42.0F,
      64.0F,
      -0.8F,
      44.0F,
      46.0F,
      72.0F,
      0.0F,
      50.0F,
      52.0F,
      80.0F,
      0.62F,
      54.0F,
      54.0F,
      82.0F,
      1.86F,
      60.0F,
      56.0F,
      86.0F,
      3.09F,
      66.0F,
      60.0F,
      90.0F,
      4.33F,
      72.0F,
      64.0F,
      94.0F,
      5.56F,
      76.0F,
      66.0F,
      96.0F,
      6.78F,
      76.0F,
      66.0F,
      98.0F,
      8.0F,
      72.0F,
      64.0F,
      98.0F,
      10.4F,
      64.0F,
      60.0F,
      96.0F,
      12.8F,
      56.0F,
      56.0F,
      92.0F,
      16.3F,
      48.0F,
      50.0F,
      88.0F,
      20.7F,
      40.0F,
      44.0F,
      84.0F,
      27.0F,
      34.0F,
      40.0F,
      80.0F,
      36.0F,
      30.0F,
      36.0F,
      76.0F,
      55.0F,
      26.0F,
      32.0F,
      72.0F,
      90.0F,
      22.0F,
      28.0F,
      66.0F
   };
   private static final float[] at = new float[]{
      -90.0F,
      24.0F,
      26.0F,
      40.0F,
      -5.0F,
      48.0F,
      40.0F,
      48.0F,
      -2.0F,
      90.0F,
      64.0F,
      58.0F,
      -0.8F,
      150.0F,
      96.0F,
      70.0F,
      0.0F,
      230.0F,
      140.0F,
      78.0F,
      0.62F,
      240.0F,
      150.0F,
      84.0F,
      1.86F,
      236.0F,
      148.0F,
      86.0F,
      3.09F,
      220.0F,
      136.0F,
      88.0F,
      4.33F,
      198.0F,
      124.0F,
      92.0F,
      5.56F,
      176.0F,
      112.0F,
      96.0F,
      6.78F,
      156.0F,
      102.0F,
      100.0F,
      8.0F,
      138.0F,
      94.0F,
      102.0F,
      10.4F,
      112.0F,
      82.0F,
      104.0F,
      12.8F,
      92.0F,
      74.0F,
      104.0F,
      16.3F,
      72.0F,
      64.0F,
      100.0F,
      20.7F,
      56.0F,
      56.0F,
      94.0F,
      27.0F,
      44.0F,
      48.0F,
      88.0F,
      36.0F,
      36.0F,
      40.0F,
      80.0F,
      55.0F,
      28.0F,
      34.0F,
      72.0F,
      90.0F,
      22.0F,
      28.0F,
      66.0F
   };
   private static final float[] au = new float[]{
      270.0F,
      0.0F,
      2.6F,
      8.0F,
      8.0F,
      18.0F,
      0.55F,
      3.0F,
      271.0F,
      5.3F,
      2.2F,
      8.0F,
      8.0F,
      17.0F,
      0.42F,
      11.0F,
      269.0F,
      -5.3F,
      2.4F,
      8.0F,
      8.0F,
      17.0F,
      0.5F,
      13.0F,
      272.2F,
      10.9F,
      2.8F,
      9.0F,
      8.0F,
      16.0F,
      0.48F,
      67.0F,
      267.8F,
      -10.9F,
      2.5F,
      9.0F,
      8.0F,
      16.0F,
      0.38F,
      19.0F,
      273.7F,
      18.7F,
      3.0F,
      9.0F,
      8.0F,
      15.0F,
      0.4F,
      23.0F,
      266.3F,
      -18.7F,
      3.2F,
      9.0F,
      8.0F,
      15.0F,
      0.45F,
      29.0F,
      276.0F,
      30.0F,
      3.4F,
      10.0F,
      8.0F,
      14.0F,
      0.3F,
      37.0F,
      264.0F,
      -30.0F,
      3.0F,
      10.0F,
      8.0F,
      14.0F,
      0.32F,
      43.0F,
      90.0F,
      0.0F,
      2.6F,
      9.0F,
      8.0F,
      14.0F,
      0.2F,
      53.0F,
      88.6F,
      -4.2F,
      2.4F,
      9.0F,
      8.0F,
      13.0F,
      0.16F,
      61.0F,
      91.4F,
      4.2F,
      2.4F,
      9.0F,
      8.0F,
      13.0F,
      0.17F,
      71.0F,
      87.0F,
      -9.0F,
      2.6F,
      9.0F,
      8.0F,
      12.0F,
      0.14F,
      79.0F,
      93.0F,
      9.0F,
      2.6F,
      9.0F,
      8.0F,
      12.0F,
      0.14F,
      83.0F
   };
   private static final int av = 8;
   private static final float[] aw = new float[4096];
   private static int ay = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   private StrataArrayCache() {
   }

   public static float a(float var0) {

      if (var0 >= 30.0F) {
         return (90.0F - var0) / 60.0F * 256.0F;
      } else if (var0 >= 8.0F) {
         return 256.0F + (30.0F - var0) / 22.0F * 320.0F;
      } else {
         return var0 >= -4.0F ? 576.0F + (8.0F - var0) / 12.0F * 320.0F : 896.0F + (-4.0F - var0) / 86.0F * 128.0F;
      }
   }

   public static float b(float var0) {
      byte var1 = 0;

      while (true) {
         switch (var1) {
            case 0:
            default:
               if (ay != 0) {
                  Thread.currentThread().getName().length();
                  var1 = 3;
                  break;
               }
            case 3:
               if (var0 <= 256.0F) {
                  return 90.0F - var0 / 256.0F * 60.0F;
               }
            case 2:
               if (var0 <= 576.0F) {
                  return 30.0F - (var0 - 256.0F) / 320.0F * 22.0F;
               }
            case 1:
               if (var0 <= 896.0F) {
                  return 8.0F - (var0 - 576.0F) / 320.0F * 12.0F;
               }

               return -4.0F - (var0 - 896.0F) / 128.0F * 86.0F;
            case 4:
               return -4.0F - (var0 - 896.0F) / 128.0F * 86.0F;
         }
      }
   }

   public static int[] c() {

      int[] var0 = new int[1310720];
      float[] var1 = new float[3];

      for (int var2 = 0; var2 < 5; var2++) {
         float[] var3 = var2 == 0 ? ap : (var2 == 1 ? aq : (var2 == 2 ? ar : (var2 == 3 ? as : at)));

         for (int var4 = 0; var4 < (-1052879476 ^ -1052880500); var4++) {
            d(var3, b((float)var4 + 0.5F), var1);
            f(
               var0,
               (var2 * (-1355584456 ^ -1355585480) + var4) * (-545716943 ^ -545717199),
               var1[0],
               var1[1],
               var1[2],
               -439625313 ^ -1991948950 ^ (var2 * (-1922916690 ^ -1922917714) + var4) * (953600192 ^ -1495158407)
            );
         }
      }

      return var0;
   }

   private static void d(float[] var0, float var1, float[] var2) {

      int var3 = var0.length / 4;
      if (var1 <= var0[0]) {
         var2[0] = var0[1];
         var2[1] = var0[2];
         var2[2] = var0[3];
      } else if (var1 >= var0[(var3 - 1) * 4]) {
         int var23 = (var3 - 1) * 4;
         var2[0] = var0[var23 + 1];
         var2[1] = var0[var23 + 2];
         var2[2] = var0[var23 + 3];
      } else {
         int var4 = 0;

         while (var4 < var3 - 2 && var1 > var0[(var4 + 1) * 4]) {
            var4++;
         }

         float var5 = var0[var4 * 4];
         float var6 = var0[(var4 + 1) * 4];
         float var7 = var6 - var5;
         float var8 = (var1 - var5) / var7;
         float var9 = (1.0F + 2.0F * var8) * (1.0F - var8) * (1.0F - var8);
         float var10 = var8 * (1.0F - var8) * (1.0F - var8);
         float var11 = var8 * var8 * (3.0F - 2.0F * var8);
         float var12 = var8 * var8 * (var8 - 1.0F);

         for (int var13 = 0; var13 < 3; var13++) {
            float var14 = var0[var4 * 4 + 1 + var13];
            float var15 = var0[(var4 + 1) * 4 + 1 + var13];
            float var16 = (var15 - var14) / var7;
            float var17 = e(var0, var4, var13, var3);
            float var18 = e(var0, var4 + 1, var13, var3);
            if (var16 == 0.0F) {
               var17 = 0.0F;
               var18 = 0.0F;
            } else {
               float var19 = var17 / var16;
               float var20 = var18 / var16;
               float var21 = var19 * var19 + var20 * var20;
               if (var21 > 9.0F) {
                  float var22 = 3.0F / (float)Math.sqrt((double)var21);
                  var17 = var22 * var19 * var16;
                  var18 = var22 * var20 * var16;
               }
            }

            var2[var13] = var9 * var14 + var10 * var7 * var17 + var11 * var15 + var12 * var7 * var18;
         }
      }
   }

   private static float e(float[] var0, int var1, int var2, int var3) {

      if (var1 == 0) {
         return (var0[5 + var2] - var0[1 + var2]) / (var0[4] - var0[0]);
      } else if (var1 == var3 - 1) {
         int var7 = var1 * 4;
         return (var0[var7 + 1 + var2] - var0[var7 - 3 + var2]) / (var0[var7] - var0[var7 - 4]);
      } else {
         int var4 = var1 * 4;
         float var5 = (var0[var4 + 1 + var2] - var0[var4 - 3 + var2]) / (var0[var4] - var0[var4 - 4]);
         float var6 = (var0[var4 + 5 + var2] - var0[var4 + 1 + var2]) / (var0[var4 + 4] - var0[var4]);
         return var5 * var6 <= 0.0F ? 0.0F : (var5 + var6) * 0.5F;
      }
   }

   private static void f(int[] var0, int var1, float var2, float var3, float var4, int var5) {

      assert var0 != null
         && var1 >= 0
         && var1 + (922646856 ^ 922646600) <= var0.length
         && var2 >= 0.0F
         && var2 <= 255.0F
         && var3 >= 0.0F
         && var3 <= 255.0F
         && var4 >= 0.0F
         && var4 <= 255.0F
         && var0.length == (-2070751986 ^ -2071538418)
         && var1 % (-164200870 ^ -164200614) == 0
         && !Float.isNaN(var2)
         && !Float.isNaN(var3)
         && !Float.isNaN(var4)
         && var5 != (-714772458 ^ -1432711191)
         && aw.length == (51045143 ^ 51049239) : "di" + "therRow" + ":" + " bad args";

      try {
         int var6 = var5 | 1;

         for (int var7 = 0; var7 < (1371793435 ^ 1371793691); var7++) {
            int var18 = var6 ^ var6 << 13;
            int var19 = var18 ^ var18 >>> 17;
            int var20 = var19 ^ var19 << 5;
            float var8 = (float)(var20 & (1150171610 ^ 1150207525)) * 1.5258789E-5F;
            float var9 = (float)(var20 >>> 16) * 1.5258789E-5F;
            int var21 = var20 ^ var20 << 13;
            int var22 = var21 ^ var21 >>> 17;
            int var23 = var22 ^ var22 << 5;
            float var10 = (float)(var23 & (-1144732443 ^ -1144767718)) * 1.5258789E-5F;
            float var11 = (float)(var23 >>> 16) * 1.5258789E-5F;
            int var24 = var23 ^ var23 << 13;
            int var25 = var24 ^ var24 >>> 17;
            var6 = var25 ^ var25 << 5;
            float var12 = (float)(var6 & (-1343970367 ^ -1343988674)) * 1.5258789E-5F;
            float var13 = (float)(var6 >>> 16) * 1.5258789E-5F;
            int var14 = (int)Math.floor((double)(var2 + var8 + var9 - 0.5F));
            int var15 = (int)Math.floor((double)(var3 + var10 + var11 - 0.5F));
            int var16 = (int)Math.floor((double)(var4 + var12 + var13 - 0.5F));
            var14 = var14 < 0 ? 0 : (var14 > (922461085 ^ 922461026) ? -1069446819 ^ -1069446750 : var14);
            var15 = var15 < 0 ? 0 : (var15 > (1185780708 ^ 1185780507) ? -2037855334 ^ -2037855387 : var15);
            var16 = var16 < 0 ? 0 : (var16 > (-124162148 ^ -124162205) ? 1974719042 ^ 1974719165 : var16);
            var0[var1 + var7] = -210056525 ^ 209373875 | var14 << 16 | var15 << 8 | var16;
         }
      } catch (RuntimeException var17) {
         throw var17;
      }
   }

   public static int[] g() {

      int[] var0 = new int[1048576];
      float[] var1 = new float[1024];
      float[] var2 = new float[1024];
      float[] var3 = new float[1024];

      for (int var4 = 0; var4 < (1901701241 ^ 1901701497); var4++) {
         float var5 = 60.0F - ((float)var4 + 0.5F) / 256.0F * 62.0F;
         h(var1, 0.0, 0.015625, (double)var5 * 0.045 + 7.0, 3);
         h(var2, 0.0, 0.125, (double)var5 * 0.022 + 31.0, 3);
         h(var3, 0.0, 0.03125, (double)var5 * 0.09 + 17.0, 2);
         i(var0, var4 * (-656738756 ^ -656739780), var5, var1, var2, var3);
      }

      for (int var10 = 0; var10 < (-378791920 ^ -378791408); var10++) {
         float var12 = (float)var10 + 0.5F;
         int var6 = 0;

         while (var6 < 11 && var12 < aj[var6 + 1]) {
            var6++;
         }

         float var7 = (var12 - aj[var6 + 1]) / (aj[var6] - aj[var6 + 1]);
         var7 = var7 < 0.0F ? 0.0F : (var7 > 1.0F ? 1.0F : var7);
         float var8 = w[var6 + 1] + (w[var6] - w[var6 + 1]) * var7;
         float var9 = (w[var6 + 1] - w[var6]) / (aj[var6] - aj[var6 + 1]);
         j(var0, ((-236629487 ^ -236629231) + var10) * (1227092240 ^ 1227093264), var8, var9);
      }

      for (int var11 = 0; var11 < (87351388 ^ 87351644); var11++) {
         k(var0, ((1655444486 ^ 1655445254) + var11) * (-1640538118 ^ -1640539142), var11);
      }

      return var0;
   }

   private static void h(float[] var0, double var1, double var3, double var5, int var7) {

      assert var0 != null
         && var0.length == (-982673136 ^ -982672112)
         && var7 >= 1
         && var7 <= 4
         && var3 > 0.0
         && var3 < 1.0
         && var1 >= 0.0
         && var1 < 64.0
         && var5 >= 0.0
         && var5 < 64.0
         && aw.length == (-1509687006 ^ -1509682910)
         && aw[0] >= 0.0F
         && aw[0] <= 1.0F
         && aw[1680563278 ^ 1680561073] >= 0.0F
         && aw[-1560464657 ^ -1560462064] <= 1.0F
         && !Double.isNaN(var5)
         && !Double.isNaN(var3) : "fbmRow: bad args";

      try {
         float[] var8 = aw;

         for (int var9 = 0; var9 < (-901615959 ^ -901616983); var9++) {
            double var10 = var1 + (double)var9 * var3;
            double var12 = var5;
            double var14 = 0.0;
            double var16 = 0.5;
            double var18 = 0.0;

            for (int var20 = 0; var20 < var7; var20++) {
               int var21 = (int)Math.floor(var10);
               int var22 = (int)Math.floor(var12);
               double var23 = var10 - (double)var21;
               double var25 = var12 - (double)var22;
               var23 = var23 * var23 * (3.0 - 2.0 * var23);
               var25 = var25 * var25 * (3.0 - 2.0 * var25);
               int var27 = (var22 & 63) << 6;
               int var28 = (var22 + 1 & 63) << 6;
               int var29 = var21 & 63;
               int var30 = var21 + 1 & 63;
               double var31 = (double)var8[var27 | var29] + (double)(var8[var27 | var30] - var8[var27 | var29]) * var23;
               double var33 = (double)var8[var28 | var29] + (double)(var8[var28 | var30] - var8[var28 | var29]) * var23;
               var14 += var16 * (var31 + (var33 - var31) * var25);
               var18 += var16;
               var10 *= 2.0;
               var12 *= 2.0;
               var16 *= 0.5;
            }

            var0[var9] = (float)(var14 / var18);
         }
      } catch (RuntimeException var35) {
         throw var35;
      }
   }

   private static void i(int[] var0, int var1, float var2, float[] var3, float[] var4, float[] var5) {

      assert var0 != null
         && var1 >= 0
         && var1 + (1575898564 ^ 1575897540) <= var0.length
         && var3 != null
         && var4 != null
         && var5 != null
         && var3.length == (-507073062 ^ -507074086)
         && var4.length == (-1467110570 ^ -1467109546)
         && var5.length == (1066472068 ^ 1066473092)
         && var2 >= -2.5F
         && var2 <= 60.5F
         && au.length % 8 == 0
         && !Float.isNaN(var2)
         && aw.length == (1098978930 ^ 1098974834) : "wispRo" + "w: " + "bad a" + "rgs";

      try {
         float[] var6 = au;
         int var7 = var6.length / 8;
         float var8 = var2 < -1.5F ? 0.0F : (var2 > 1.5F ? 1.0F : (var2 + 1.5F) / 3.0F);
         var8 = var8 * var8 * (3.0F - 2.0F * var8);
         float var9 = (var2 + 1.5F) / 4.0F;
         float var10 = (var2 - 5.0F) / 10.0F;
         var9 = var9 < 0.0F ? 0.0F : (var9 > 1.0F ? 1.0F : var9);
         var10 = var10 < 0.0F ? 0.0F : (var10 > 1.0F ? 1.0F : var10);
         float var11 = 0.25F * var9 * var9 * (3.0F - 2.0F * var9) * (1.0F - var10 * var10 * (3.0F - 2.0F * var10));

         for (int var12 = 0; var12 < (790470387 ^ 790469363); var12++) {
            float var13 = ((float)var12 + 0.5F) * 0.3515625F;
            float var14 = 1.0F;

            for (int var15 = 0; var15 < var7; var15++) {
               int var16 = var15 * 8;
               float var17 = var6[var16 + 3];
               float var18 = var2 - var17;
               float var19 = var18 < 0.0F ? var6[var16 + 4] : var6[var16 + 5];
               float var20 = (float)Math.exp((double)(-var18 * var18 / (var19 * var19)));
               if (!(var20 < 0.01F)) {
                  float var21 = var2 < 0.0F ? 0.0F : var2 / 30.0F;
                  int var22 = (int)(var6[var16] * 2.8444445F) & (-1171783997 ^ -1171784388);
                  float var23 = var6[var16] + var6[var16 + 1] * var21 * (float)Math.sqrt((double)var21) + (var5[var22] - 0.5F) * 5.0F * var21;
                  float var24 = var6[var16 + 2]
                     * (0.75F + 0.55F * var21)
                     * (0.7F + 0.6F * var5[var22 + 97 * var15 + (-941981079 ^ -941980998) & (708494424 ^ 708495271)]);
                  float var25 = var13 - var23;
                  var25 -= 360.0F * (float)Math.floor((double)((var25 + 180.0F) / 360.0F));
                  float var26 = var25 / var24;
                  if (!(var26 > 3.2F) && !(var26 < -3.2F)) {
                     float var27 = 0.8F + 0.4F * var3[var12];
                     float var28 = var26 * var26 / (var27 * var27);
                     float var29 = (float)Math.exp((double)(-1.4F * var28));
                     float var30 = 0.8F + 0.4F * var4[var12];
                     float var31 = var6[var16 + 6] * var20 * var29 * var30 * var8;
                     var14 *= 1.0F - (var31 > 0.98F ? 0.98F : var31);
                  }
               }
            }

            var14 *= 1.0F - var11 * (0.3F + 1.0F * var3[var12]);
            float var37 = 1.0F - var14;
            int var38 = (int)(var37 * 255.0F + 0.5F);
            var38 = var38 < 0 ? 0 : (var38 > (874282442 ^ 874282293) ? 1801725938 ^ 1801725709 : var38);
            var0[var1 + var12] = var38 << 24 | 1274299857 ^ 1259059758;
         }
      } catch (RuntimeException var32) {
         throw var32;
      }
   }

   private static void j(int[] var0, int var1, float var2, float var3) {

      assert var0 != null
         && var1 >= 0
         && var1 + (1396657329 ^ 1396656305) <= var0.length
         && var3 > 0.0F
         && var3 < 2.0F
         && var2 >= 0.5F
         && var2 <= 75.5F
         && !Float.isNaN(var2)
         && aw.length == (-605898023 ^ -605902119)
         && aw[0] >= 0.0F
         && aw[0] <= 1.0F : "ci" + "rrusRow: ba" + "d args";

      try {
         float[] var4 = aw;
         double var5 = Math.toRadians((double)var2);
         double var7 = Math.sin(var5);
         double var9 = (-40.0 * var7 + Math.sqrt(1600.0 * var7 * var7 + 80.0 + 1.0)) * Math.cos(var5);
         double var11 = Math.toRadians(var3 > 0.065F ? (double)var3 : 0.065F) * 0.5;
         double var13 = var5 + var11;
         double var15 = var5 - var11;
         double var17 = (-40.0 * Math.sin(var13) + Math.sqrt(1600.0 * Math.sin(var13) * Math.sin(var13) + 80.0 + 1.0)) * Math.cos(var13);
         double var19 = (-40.0 * Math.sin(var15) + Math.sqrt(1600.0 * Math.sin(var15) * Math.sin(var15) + 80.0 + 1.0)) * Math.cos(var15);
         double var21 = Math.abs(var19 - var17) * 4.2;
         double var23 = var9 * 0.006135923151542565 * 4.2;
         int var25 = (int)Math.ceil(var23 / 0.2);
         var25 = var25 < 1 ? 1 : (var25 > 8 ? 8 : var25);
         double var26 = var23 / (double)var25;
         double var28 = var21 > var26 ? var21 : var26;
         float var30 = (var2 - 0.5F) / 3.0F;
         var30 = var30 < 0.0F ? 0.0F : (var30 > 1.0F ? 1.0F : var30);
         var30 = var30 * var30 * (3.0F - 2.0F * var30);
         float var31 = (70.0F - var2) / 14.0F;
         var31 = var31 < 0.0F ? 0.0F : (var31 > 1.0F ? 1.0F : var31);
         double var32 = 0.4226;
         double var34 = -0.9063;

         for (int var36 = 0; var36 < (413678147 ^ 413679171); var36++) {
            double var37 = 0.0;

            for (int var39 = 0; var39 < var25; var39++) {
               double var40 = ((double)var36 + ((double)var39 + 0.5) / (double)var25) * 0.006135923151542565;
               double var42 = var9 * Math.sin(var40);
               double var44 = -var9 * Math.cos(var40);
               double var46 = (var42 * var32 + var44 * var34) * 2.0 + 20.0;
               double var48 = (-var42 * var34 + var44 * var32) * 4.2 + 20.0;
               double var50 = 0.0;
               double var52 = 0.5;
               double var54 = var46;
               double var56 = var48;
               double var58 = var28;

               for (int var60 = 0; var60 < 4; var60++) {
                  double var61 = (0.5 - var58) / 0.25;
                  var61 = var61 < 0.0 ? 0.0 : (var61 > 1.0 ? 1.0 : var61);
                  double var63 = 0.5;
                  if (var61 > 0.0) {
                     int var65 = (int)Math.floor(var54);
                     int var66 = (int)Math.floor(var56);
                     double var67 = var54 - (double)var65;
                     double var69 = var56 - (double)var66;
                     var67 = var67 * var67 * (3.0 - 2.0 * var67);
                     var69 = var69 * var69 * (3.0 - 2.0 * var69);
                     int var71 = (var66 & 63) << 6;
                     int var72 = (var66 + 1 & 63) << 6;
                     int var73 = var65 & 63;
                     int var74 = var65 + 1 & 63;
                     double var75 = (double)var4[var71 | var73] + (double)(var4[var71 | var74] - var4[var71 | var73]) * var67;
                     double var77 = (double)var4[var72 | var73] + (double)(var4[var72 | var74] - var4[var72 | var73]) * var67;
                     var63 = 0.5 + var61 * (var75 + (var77 - var75) * var69 - 0.5);
                  }

                  var50 += var52 * var63;
                  var54 = var54 * 2.0 + 3.1;
                  var56 = var56 * 2.0 + 1.7;
                  var52 *= 0.5;
                  var58 *= 2.0;
               }

               double var89 = var50 / 0.9375;
               int var62 = (int)Math.floor(var46 * 0.22);
               int var91 = (int)Math.floor(var48 * 0.11);
               double var64 = var46 * 0.22 - (double)var62;
               double var93 = var48 * 0.11 - (double)var91;
               var64 = var64 * var64 * (3.0 - 2.0 * var64);
               var93 = var93 * var93 * (3.0 - 2.0 * var93);
               int var68 = (var91 & 63) << 6;
               int var97 = (var91 + 1 & 63) << 6;
               int var70 = var62 & 63;
               int var98 = var62 + 1 & 63;
               double var99 = (double)var4[var68 | var70] + (double)(var4[var68 | var98] - var4[var68 | var70]) * var64;
               double var100 = (double)var4[var97 | var70] + (double)(var4[var97 | var98] - var4[var97 | var70]) * var64;
               double var76 = var99 + (var100 - var99) * var93;
               double var78 = (var89 - 0.42) / 0.22;
               var78 = var78 < 0.0 ? 0.0 : (var78 > 1.0 ? 1.0 : var78);
               var78 = var78 * var78 * (3.0 - 2.0 * var78);
               double var80 = (var76 - 0.2) / 0.6;
               var80 = var80 < 0.0 ? 0.0 : (var80 > 1.0 ? 1.0 : var80);
               var37 += var78 * (0.35 + 0.65 * var80);
            }

            double var87 = var37 / (double)var25 * (double)var30 * (double)var31;
            int var41 = (int)(var87 * 255.0 + 0.5);
            var41 = var41 < 0 ? 0 : (var41 > (2061987857 ^ 2061988078) ? 1619718775 ^ 1619718792 : var41);
            var0[var1 + var36] = var41 << 24 | 494988267 ^ 494867476;
         }
      } catch (RuntimeException var82) {
         throw var82;
      }
   }

   private static void k(int[] var0, int var1, int var2) {

      assert var0 != null
         && var1 >= 0
         && var1 + (-1427963269 ^ -1427962245) <= var0.length
         && var2 >= 0
         && var2 < (1334434227 ^ 1334433971)
         && var0.length == (-59415643 ^ -60464219)
         && var1 % (-1775050552 ^ -1775049528) == 0
         && aw.length == (-1494905146 ^ -1494901050) : "vignetteRow:" + " bad args";

      try {
         double var3 = ((double)var2 + 0.5) / 128.0 - 1.0;

         for (int var5 = 0; var5 < (1493777477 ^ 1493777733); var5++) {
            double var6 = ((double)var5 + 0.5) / 128.0 - 1.0;
            double var8 = Math.sqrt(var6 * var6 + 0.42 * var3 * var3);
            double var10 = (var8 - 0.4) / 1.0;
            var10 = var10 < 0.0 ? 0.0 : (var10 > 1.0 ? 1.0 : var10);
            var10 *= Math.sqrt(var10);
            int var12 = (int)(var10 * 255.0 + 0.5);
            var0[var1 + var5] = var12 << 24 | -1835608506 ^ -1838601799;
         }

         for (int var16 = -1878959835 ^ -1878960091; var16 < (-514516432 ^ -514516944); var16++) {
            var0[var1 + var16] = -1;
         }

         double var17 = var3 < 0.0 ? 0.3 + 0.7 * Math.pow(-var3, 1.2) : 0.3 + 0.4 * var3;

         for (int var7 = -2014819458 ^ -2014819970; var7 < (-322317922 ^ -322317666); var7++) {
            double var19 = ((double)(var7 - (-2026873456 ^ -2026872944)) + 0.5) / 128.0 - 1.0;
            double var22 = Math.sqrt(var19 * var19 + 0.42 * var3 * var3);
            double var23 = (var22 - 0.4) / 1.0;
            var23 = var23 < 0.0 ? 0.0 : (var23 > 1.0 ? 1.0 : var23);
            var23 = var23 * Math.sqrt(var23) * var17;
            int var14 = (int)(var23 * 255.0 + 0.5);
            var0[var1 + var7] = var14 << 24 | -1825186647 ^ -1815469226;
         }

         for (int var18 = 2124819428 ^ 2124818660; var18 < (-1515759282 ^ -1515758258); var18++) {
            var0[var1 + var18] = 16777215;
         }
      } catch (RuntimeException var15) {
         throw var15;
      }
   }

   public static void l(int[] var0) {

      assert var0 != null
         && var0.length == (-715989222 ^ -715727078)
         && var0.length % (1530585674 ^ 1530585162) == 0
         && aw.length == (345653840 ^ 345657936)
         && aw[0] >= 0.0F
         && aw[0] <= 1.0F
         && aw[1607654357 ^ 1607652394] >= 0.0F
         && aw[-1290632531 ^ -1290629806] <= 1.0F : "dotSprite: bad a" + "tl" + "as";

      try {
         int[] var1 = new int[]{0, 128, 192, 224};

         for (int var2 = 0; var2 < 4; var2++) {
            int var3 = (671861347 ^ 671861475) >> var2;
            int var4 = var1[var2];
            double var5 = (double)var3 * 0.5;
            double var7 = var5 * 0.703125;

            for (int var9 = 0; var9 < var3; var9++) {
               for (int var10 = 0; var10 < var3; var10++) {
                  double var11 = 0.0;

                  for (int var13 = 0; var13 < 16; var13++) {
                     double var14 = (double)var10 + ((double)(var13 & 3) + 0.5) * 0.25 - var5;
                     double var16 = (double)var9 + ((double)(var13 >> 2) + 0.5) * 0.25 - var5;
                     double var18 = Math.sqrt(var14 * var14 + var16 * var16) / var7;
                     if (var18 < 1.0) {
                        double var20 = (var18 - 0.25) / 0.75;
                        var20 = var20 < 0.0 ? 0.0 : var20;
                        var11 += 1.0 - var20 * var20 * (3.0 - 2.0 * var20);
                     }
                  }

                  int var23 = (int)(var11 / 16.0 * 255.0 + 0.5);
                  var0[((-32719271 ^ -32718887) + var9) * (-1259778837 ^ -1259778325) + var4 + var10] = (
                           var23 > (1936944645 ^ 1936944890) ? -1121854795 ^ -1121854902 : var23
                        )
                        << 24
                     | 953745349 ^ 942080058;
               }
            }
         }
      } catch (RuntimeException var22) {
         throw var22;
      }
   }

   public static int m(int var0, float var1, float var2, int var3, float var4, float var5, float var6, float var7, float var8) {

      assert var0 >= 0
         && var0 <= 4
         && var1 > 0.0F
         && var1 < 100000.0F
         && var2 >= 0.0F
         && var2 <= 1.0F
         && var3 >= 0
         && var3 <= (1284361825 ^ 1284361886)
         && var4 >= -1.001F
         && var4 <= 1.001F
         && !Float.isNaN(var5)
         && !Float.isNaN(var6)
         && !Float.isNaN(var7)
         && var8 >= -1.5F
         && var8 <= 1.0F
         && an.length == 49
         && ao.length == 88
         && ak.length == 49
         && aa.length == 22
         && ab.length == 22
         && ac.length == 22 : "dome: ba" + "d fr" + "a" + "me";

      try {
         float[] var9 = an;
         if (var0 != 1 && var0 != 4) {
            for (int var14 = 0; var14 <= 48; var14++) {
               var9[var14] = var2;
            }
         } else {
            float var10 = var4 > 0.0F ? Math.min(1.0F, var4 * 1.6F) : Math.max(-1.0F, var4 * 1.6F);

            for (int var11 = 0; var11 <= 48; var11++) {
               float var12 = 0.5F + 0.5F * ak[var11] * var10;
               var12 *= var12 * var12;
               var9[var11] = var2 * var12 * var12;
            }
         }

         float[] var15 = ao;

         for (int var16 = 0; var16 < 22; var16++) {
            var15[var16 * 4] = (float)var3;
            var15[var16 * 4 + 1] = (float)var3;
            var15[var16 * 4 + 2] = (float)var3;
            var15[var16 * 4 + 3] = 255.0F;
         }

         return p(aa, ab, ac, 22, (float)var0 * 1024.0F / 5120.0F, var1, 0.0F, 0.375F, var5, var6, var7, var8);
      } catch (RuntimeException var13) {
         throw var13;
      }
   }

   public static int n(float var0, double var1, float var3, float var4, float var5, float var6, float var7) {

      assert var0 > 0.0F
         && var0 < 100000.0F
         && !Double.isNaN(var1)
         && !Double.isInfinite(var1)
         && var3 >= 0.0F
         && var3 <= 2.0F
         && !Float.isNaN(var4)
         && !Float.isNaN(var5)
         && !Float.isNaN(var6)
         && var7 >= -1.5F
         && var7 <= 1.0F
         && an.length == 49
         && ao.length == 88
         && v.length == 14
         && ad.length == 14
         && ae.length == 14
         && af.length == 14 : "wisps" + ":" + " bad frame";

      try {
         float[] var8 = ao;

         for (int var9 = 0; var9 < 14; var9++) {
            float var10 = v[var9];
            float var11 = var10 < 2.0F ? 1.0F : (var10 > 20.0F ? 0.0F : (20.0F - var10) / 18.0F);
            var8[var9 * 4] = 222.0F + 33.0F * var11;
            var8[var9 * 4 + 1] = 222.0F + 14.0F * var11;
            var8[var9 * 4 + 2] = 236.0F - 30.0F * var11;
            var8[var9 * 4 + 3] = 255.0F;
         }

         float[] var13 = an;

         for (int var14 = 0; var14 <= 48; var14++) {
            float var15 = (float)(Math.sin(var1 * 0.11 + (double)var14 * 0.61) * Math.sin(var1 * 0.047 + (double)var14 * 0.23 + 1.3));
            var13[var14] = var3 * 0.15F * (0.8F + 0.2F * var15);
         }

         return p(ad, ae, af, 14, 0.0F, var0, 0.0F, 0.020833334F, var4, var5, var6, var7);
      } catch (RuntimeException var12) {
         throw var12;
      }
   }

   public static int o(float var0, double var1, float var3, float var4, float var5, float var6, float var7, float var8) {

      assert var0 > 0.0F
         && var0 < 100000.0F
         && !Double.isNaN(var1)
         && !Double.isInfinite(var1)
         && var3 >= 0.0F
         && var3 <= 2.0F
         && var4 >= 0.0F
         && var4 <= 1.0F
         && !Float.isNaN(var5)
         && !Float.isNaN(var6)
         && !Float.isNaN(var7)
         && var8 >= -1.5F
         && var8 <= 1.0F
         && an.length == 49
         && ao.length == 88
         && w.length == 13
         && ag.length == 13
         && ah.length == 13
         && ai.length == 13 : "c" + "irrus: bad frame";

      try {
         float[] var9 = ao;

         for (int var10 = 0; var10 < 13; var10++) {
            var9[var10 * 4] = 250.0F * var4;
            var9[var10 * 4 + 1] = 252.0F * var4;
            var9[var10 * 4 + 2] = 255.0F * var4;
            var9[var10 * 4 + 3] = 255.0F;
         }

         float[] var13 = an;

         for (int var11 = 0; var11 <= 48; var11++) {
            var13[var11] = var3 * 0.055F;
         }

         float var14 = (float)(var1 * 1.8E-4 % 1.0);
         return p(ag, ah, ai, 13, 0.0F, var0, var14, 0.020833334F, var5, var6, var7, var8);
      } catch (RuntimeException var12) {
         throw var12;
      }
   }

   private static int p(
      float[] var0, float[] var1, float[] var2, int var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11
   ) {

      assert var0 != null
         && var1 != null
         && var2 != null
         && var0.length == var3
         && var1.length == var3
         && var2.length == var3
         && var3 >= 2
         && var3 <= 22
         && var5 > 0.0F
         && var5 < 100000.0F
         && !Float.isNaN(var6)
         && var7 > 0.0F
         && var7 < 1.0F
         && Math.abs(var8 * var8 + var9 * var9 + var10 * var10 - 1.0F) < 0.05F
         && var11 >= -1.5F
         && var11 <= 1.0F
         && VB.length == (-369397298 ^ -369414322)
         && am.length == (1457891773 ^ 1457892747)
         && an.length == 49
         && ao.length == 88
         && ak.length == 49
         && al.length == 49 : "st" + "ri" + "p: bad fr" + "ame";

      try {
         float[] var12 = am;
         float[] var13 = ak;
         float[] var14 = al;
         float[] var15 = an;
         float[] var16 = ao;
         float[] var17 = VB;
         byte var18 = 49;

         for (int var19 = 0; var19 < var3; var19++) {
            float var20 = var0[var19];
            float var21 = var1[var19] * var9;

            for (int var22 = 0; var22 <= 48; var22++) {
               var12[var19 * var18 + var22] = var20 * (var13[var22] * var8 - var14[var22] * var10) + var21;
            }
         }

         byte var55 = 0;
         float var56 = var11 - 0.12F;

         for (int var57 = 0; var57 < var3 - 1; var57++) {
            float var58 = var0[var57] * var5;
            float var23 = var1[var57] * var5;
            float var24 = var0[var57 + 1] * var5;
            float var25 = var1[var57 + 1] * var5;
            float var26 = var4 + var2[var57];
            float var27 = var4 + var2[var57 + 1];
            int var28 = var57 * 4;
            float var29 = var16[var28];
            float var30 = var16[var28 + 1];
            float var31 = var16[var28 + 2];
            float var32 = var16[var28 + 3];
            float var33 = var16[var28 + 4];
            float var34 = var16[var28 + 5];
            float var35 = var16[var28 + 6];
            float var36 = var16[var28 + 7];
            int var37 = (int)var29 << 16 | (int)var30 << 8 | (int)var31;
            int var38 = (int)var33 << 16 | (int)var34 << 8 | (int)var35;

            for (int var39 = 0; var39 < 48; var39++) {
               int var40 = var57 * var18 + var39;
               if (!(var12[var40] < var56) || !(var12[var40 + 1] < var56) || !(var12[var40 + var18] < var56) || !(var12[var40 + var18 + 1] < var56)) {
                  float var41 = var15[var39];
                  float var42 = var15[var39 + 1];
                  int var43 = (int)(var32 * var41 + 0.5F);
                  int var44 = (int)(var32 * var42 + 0.5F);
                  int var45 = (int)(var36 * var41 + 0.5F);
                  int var46 = (int)(var36 * var42 + 0.5F);
                  if ((var43 | var44 | var45 | var46) != 0) {
                     var43 = var43 > (-120636079 ^ -120635986) ? 670004727 ^ 670004488 : var43;
                     var44 = var44 > (2002730892 ^ 2002730867) ? -1516454815 ^ -1516454754 : var44;
                     var45 = var45 > (-360069150 ^ -360069347) ? 858391098 ^ 858391237 : var45;
                     var46 = var46 > (1720823820 ^ 1720824051) ? 688245348 ^ 688245403 : var46;
                     float var47 = var6 + (float)var39 * var7;
                     float var48 = var47 + var7;
                     float var49 = var13[var39];
                     float var50 = var14[var39];
                     float var51 = var13[var39 + 1];
                     float var52 = var14[var39 + 1];
                     int var53 = var55 * 6;
                     var17[var53] = var58 * var49;
                     var17[var53 + 1] = var23;
                     var17[var53 + 2] = -var58 * var50;
                     var17[var53 + 3] = var47;
                     var17[var53 + 4] = var26;
                     var17[var53 + 5] = Float.intBitsToFloat(var43 << 24 | var37);
                     var17[var53 + 6] = var24 * var49;
                     var17[var53 + 7] = var25;
                     var17[var53 + 8] = -var24 * var50;
                     var17[var53 + 9] = var47;
                     var17[var53 + 10] = var27;
                     var17[var53 + 11] = Float.intBitsToFloat(var45 << 24 | var38);
                     var17[var53 + 12] = var24 * var51;
                     var17[var53 + 13] = var25;
                     var17[var53 + 14] = -var24 * var52;
                     var17[var53 + 15] = var48;
                     var17[var53 + 16] = var27;
                     var17[var53 + 17] = Float.intBitsToFloat(var46 << 24 | var38);
                     var17[var53 + 18] = var58 * var51;
                     var17[var53 + 19] = var23;
                     var17[var53 + 20] = -var58 * var52;
                     var17[var53 + 21] = var48;
                     var17[var53 + 22] = var26;
                     var17[var53 + 23] = Float.intBitsToFloat(var44 << 24 | var37);
                     var55 += 4;
                  }
               }
            }
         }

         return var55;
      } catch (RuntimeException var54) {
         throw var54;
      }
   }

   static {
      for (int var0 = 0; var0 < aw.length; var0++) {
         int var1 = var0 * -1640531527 + 625341585;
         var1 ^= var1 >>> 16;
         var1 *= -2048144789;
         var1 ^= var1 >>> 13;
         var1 *= -1028477387;
         var1 ^= var1 >>> 16;
         aw[var0] = (float)(var1 & 65535) / 65535.0F;
      }

      for (int var9 = 0; var9 <= 48; var9++) {
         double var18 = (double)var9 * 0.1308996938995747;
         ak[var9] = (float)Math.sin(var18);
         al[var9] = (float)Math.cos(var18);
      }

      for (int var10 = 0; var10 < 22; var10++) {
         double var19 = Math.toRadians((double)u[var10]);
         aa[var10] = (float)Math.cos(var19);
         ab[var10] = (float)Math.sin(var19);
         ac[var10] = Math.max(0.5F, Math.min(1023.5F, a(u[var10]))) / 5120.0F;
      }

      aa[0] = 0.0F;
      aa[21] = 0.0F;

      for (int var11 = 0; var11 < 14; var11++) {
         double var20 = Math.toRadians((double)v[var11]);
         ad[var11] = (float)Math.cos(var20);
         ae[var11] = (float)Math.sin(var20);
         af[var11] = (0.5F + (60.0F - v[var11]) / 62.0F * 255.0F) / 1024.0F;
      }

      double var12 = Math.log(Math.tan(Math.toRadians((double)w[12]) * 0.5)) - Math.log(Math.tan(Math.toRadians((double)w[0]) * 0.5));
      double var2 = (double)(w[12] - w[0]);
      aj[12] = 0.5F;

      for (int var4 = 11; var4 >= 0; var4--) {
         double var5 = (Math.log(Math.tan(Math.toRadians((double)w[var4 + 1]) * 0.5)) - Math.log(Math.tan(Math.toRadians((double)w[var4]) * 0.5))) / var12;
         double var7 = (double)(w[var4 + 1] - w[var4]) / var2;
         aj[var4] = aj[var4 + 1] + (float)((0.5 * var5 + 0.5 * var7) * 511.0);
      }

      for (int var21 = 0; var21 < 13; var21++) {
         double var22 = Math.toRadians((double)w[var21]);
         ag[var21] = (float)Math.cos(var22);
         ah[var21] = (float)Math.sin(var22);
         ai[var21] = (256.0F + aj[var21]) / 1024.0F;
      }
   }
}
