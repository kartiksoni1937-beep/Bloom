package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import java.util.Arrays;

public final class BevelTextureCache {
   public static final int W = 1024;
   public static final int H = 1024;
   public static final int LEVELS = 6;
   public static final int DOT_X = 256;
   public static final int DOT_Y = 896;
   public static final int DOT_S = 64;
   public static final int ENV_X = 0;
   public static final int ENV_Y = 768;
   public static final int ENV_S = 256;
   public static final int ENV_R = 120;
   public static final int ENVB_X = 256;
   public static final int ENVB_Y = 768;
   public static final int ENVB_S = 128;
   public static final int ENVB_R = 60;
   public static final int SLOT_W = 512;
   public static final int SLOT_H = 192;
   public static final int ROW_HANDLE = 128;
   public static final int ROW_WIN = 160;
   public static final int KAT_X = 512;
   public static final int KAT_Y = 576;
   static final float HANDLE_L = 12.67F;
   static final float HANDLE_W = 1.15F;
   static final float[] WIN_X = new float[]{1.25F, 3.95F, 4.45F, 7.15F, 7.65F, 10.35F};
   static final float WIN_Y0 = 0.27F;
   static final float WIN_Y1 = 0.88F;
   static final float WIN_R = 0.2F;

   private BevelTextureCache() {
   }

   static void a(int var0, float[] var1, int var2) {

      int var3;
      int var4;
      int var5;
      int var6;
      switch (var0) {
         case 2:
            var3 = -1072493265 ^ -1072493393;
            var4 = -1334122774 ^ -1334123030;
            var5 = 1121578600 ^ 1121578856;
            var6 = -1594904180 ^ -1594904308;
            break;
         case 3:
            var3 = 1158210988 ^ 1158210604;
            var4 = 1824008346 ^ 1824008986;
            var5 = -7290745 ^ -7290489;
            var6 = -2023738888 ^ -2023739016;
            break;
         case 4:
            var3 = 1935757919 ^ 1935757791;
            var4 = -1576459548 ^ -1576459804;
            var5 = 2004917515 ^ 2004917643;
            var6 = -1407645969 ^ -1407646097;
            break;
         case 5:
            var3 = 2004409999 ^ 2004409615;
            var4 = 1326933975 ^ 1326933079;
            var5 = 64;
            var6 = 1849905652 ^ 1849905524;
            break;
         case 6:
         case 7:
         default:
            var3 = -1247464155 ^ -1247463707;
            var4 = 899257343 ^ 899256447;
            var5 = 64;
            var6 = 177075694 ^ 177075566;
            break;
         case 8:
            var3 = 796818178 ^ 796817794;
            var4 = 1858762211 ^ 1858762467;
            var5 = 67128485 ^ 67128741;
            var6 = -1251555993 ^ -1251555865;
            break;
         case 9:
            var3 = 762467813 ^ 762468197;
            var4 = 85102979 ^ 85103107;
            var5 = 1421042674 ^ 1421042418;
            var6 = 742267130 ^ 742267002;
      }

      var1[var2] = ((float)var3 + 2.5F) / 1024.0F;
      var1[var2 + 1] = ((float)var4 + 2.5F) / 1024.0F;
      var1[var2 + 2] = ((float)var5 - 5.0F) / 1024.0F;
      var1[var2 + 3] = ((float)var6 - 5.0F) / 1024.0F;
   }

   static float[] b(int var0, int var1, int var2, int var3, int var4) {

      int var5 = var0 / var2 + 2;
      int var6 = var1 / var3 + 2;
      float[] var7 = new float[var5 * var6];
      long var8 = (long)var4 * -7046029254386353131L + 7146057691288625177L;

      for (int var10 = 0; var10 < var7.length; var10++) {
         long var23 = var8 ^ var8 << 13;
         long var24 = var23 ^ var23 >>> 7;
         var8 = var24 ^ var24 << 17;
         var7[var10] = (float)(var8 >>> 40) / 1.6777216E7F;
      }

      float[] var25 = new float[var0 * var1];

      for (int var11 = 0; var11 < var1; var11++) {
         float var12 = (float)var11 / (float)var3;
         int var13 = (int)var12;
         float var14 = var12 - (float)var13;
         var14 = var14 * var14 * (3.0F - 2.0F * var14);

         for (int var15 = 0; var15 < var0; var15++) {
            float var16 = (float)var15 / (float)var2;
            int var17 = (int)var16;
            float var18 = var16 - (float)var17;
            var18 = var18 * var18 * (3.0F - 2.0F * var18);
            float var19 = var7[var13 * var5 + var17];
            float var20 = var7[var13 * var5 + var17 + 1];
            float var21 = var7[(var13 + 1) * var5 + var17];
            float var22 = var7[(var13 + 1) * var5 + var17 + 1];
            var25[var11 * var0 + var15] = (var19 + (var20 - var19) * var18) * (1.0F - var14) + (var21 + (var22 - var21) * var18) * var14;
         }
      }

      return var25;
   }

   static void acc(float[] var0, float var1, float[] var2, float var3) {

      for (int var4 = 0; var4 < var0.length; var4++) {
         var0[var4] = var0[var4] * var1 + var2[var4] * var3;
      }
   }

   private static int c(float var0, float var1, float var2) {

      int var3 = (int)(var0 * 255.0F + 0.5F);
      int var4 = (int)(var1 * 255.0F + 0.5F);
      int var5 = (int)(var2 * 255.0F + 0.5F);
      var3 = var3 < 0 ? 0 : (var3 > (1966315217 ^ 1966315054) ? 272677863 ^ 272677656 : var3);
      var4 = var4 < 0 ? 0 : (var4 > (-1625511153 ^ -1625510928) ? 1481003354 ^ 1481003429 : var4);
      var5 = var5 < 0 ? 0 : (var5 > (-689874237 ^ -689874372) ? 146228266 ^ 146228437 : var5);
      return -644170788 ^ 647674844 | var3 << 16 | var4 << 8 | var5;
   }

   private static void d(int[] var0, int var1, boolean var2) {

      int var3 = (var1 & 1) * (-1047916011 ^ -1047916523);
      int var4 = (var1 >> 1) * (-1219586604 ^ -1219586796);
      float[] var5 = b(1683539302 ^ 1683539814, 1505525406 ^ 1505525342, -505914463 ^ -505914623, 1, 11 + var1);
      float[] var6 = b(-1727283806 ^ -1727283294, 940815548 ^ 940815484, 40, 1, 12 + var1);
      float[] var7 = b(1659258118 ^ 1659258630, 760888644 ^ 760888708, -859292462 ^ -859291950, 3, 13 + var1);
      float[] var8 = b(734277986 ^ 734278498, -646236355 ^ -646236163, 64, 24, 14 + var1);
      float[] var9 = b(-402108952 ^ -402108440, 983579542 ^ 983579478, 2, 2, 15 + var1);
      float[] var10 = b(14882165 ^ 14882677, 381184429 ^ 381184365, 1, 1, 16 + var1);

      for (int var11 = 0; var11 < (881743256 ^ 881743160); var11++) {
         boolean var12 = var11 < (-720785114 ^ -720784986);
         float var13 = var12 ? ((float)var11 + 0.5F) / 128.0F : ((float)var11 - 127.5F) / 32.0F;

         for (int var14 = 0; var14 < (-1182184492 ^ -1182185004); var14++) {
            int var15 = var11 * (1829806367 ^ 1829806879) + var14;
            float var16;
            float var17;
            float var18;
            if (var12) {
               float var19 = 0.86F
                  + 0.1F * (var5[var15] - 0.5F)
                  + 0.07F * (var6[var15] - 0.5F)
                  + 0.04F * (var7[var15] - 0.5F)
                  + 0.03F * (var8[var15] - 0.5F)
                  + 0.02F * (var10[var15] - 0.5F);
               if (var2) {
                  var19 = 0.9F + 0.06F * (var5[var15] - 0.5F) + 0.04F * (var6[var15] - 0.5F);
               }

               if (var13 > 0.955F) {
                  float var20 = Math.min(1.0F, (var13 - 0.955F) / 0.02F);
                  var19 += (0.95F + 0.02F * (var8[var15] - 0.5F) - var19) * var20;
               } else if (var13 < 0.03F) {
                  var19 *= 0.9F;
               }

               var16 = var19 * 0.975F;
               var17 = var19 * 0.985F;
               var18 = var19;
            } else {
               float var21 = var2
                  ? 0.8F + 0.04F * (var9[var15] - 0.5F)
                  : 0.3F + 0.05F * (var9[var15] - 0.5F) + 0.03F * (var10[var15] - 0.5F) + 0.025F * (var8[var15] - 0.5F) + 0.015F * (var6[var15] - 0.5F);
               if (var13 < 0.07F || var13 > 0.93F) {
                  var21 *= 1.12F;
               }

               var16 = var21 * 0.94F;
               var17 = var21 * 0.97F;
               var18 = var21 * 1.05F;
            }

            var0[(var4 + var11) * (1783798291 ^ 1783799315) + var3 + var14] = c(var16, var17, var18);
         }
      }
   }

   private static void e(int[] var0, int var1) {

      int var2 = (var1 & 1) * (-801899448 ^ -801898936);
      int var3 = (var1 >> 1) * (1255381651 ^ 1255381587);
      float[] var4 = b(56069732 ^ 56069220, 303055874 ^ 303056066, 96, 48, 21);
      float[] var5 = b(2082302033 ^ 2082302545, -704763020 ^ -704762956, 24, 12, 22);
      float[] var6 = b(-1600818119 ^ -1600817607, -2016373171 ^ -2016373107, 48, 1, 23);

      for (int var7 = 0; var7 < (1104575626 ^ 1104575530); var7++) {
         boolean var8 = var7 < (1699606424 ^ 1699606296);
         float var9 = var8 ? ((float)var7 + 0.5F) / 128.0F : ((float)var7 - 127.5F) / 32.0F;

         for (int var10 = 0; var10 < (1196106149 ^ 1196106661); var10++) {
            int var11 = var7 * (1895906377 ^ 1895906889) + var10;
            float var12 = ((float)var10 + 0.5F) / 512.0F;
            float var13 = var8 ? var12 * 0.95F + (0.5F - var9) * 0.16F : 0.08F + 0.4F * var12 + (0.5F - var9) * 0.06F;
            var13 += 0.07F * (var4[var11] - 0.5F) + 0.025F * (var5[var11] - 0.5F);
            float var14;
            float var15;
            float var16;
            if (var13 < 0.2F) {
               float var17 = Math.max(0.0F, var13 / 0.2F);
               var14 = 0.12F + 0.26F * var17;
               var15 = 0.26F - 0.02F * var17;
               var16 = 0.86F + 0.06F * var17;
            } else if (var13 < 0.42F) {
               float var19 = (var13 - 0.2F) / 0.22F;
               var14 = 0.38F + 0.42F * var19;
               var15 = 0.24F - 0.04F * var19;
               var16 = 0.92F - 0.08F * var19;
            } else if (var13 < 0.62F) {
               float var20 = (var13 - 0.42F) / 0.2F;
               var14 = 0.8F + 0.2F * var20;
               var15 = 0.2F + 0.14F * var20;
               var16 = 0.84F - 0.24F * var20;
            } else if (var13 < 0.8F) {
               float var21 = (var13 - 0.62F) / 0.18F;
               var14 = 1.0F;
               var15 = 0.34F + 0.3F * var21;
               var16 = 0.6F - 0.26F * var21;
            } else {
               float var22 = Math.min(1.0F, (var13 - 0.8F) / 0.2F);
               var14 = 1.0F;
               var15 = 0.64F + 0.26F * var22;
               var16 = 0.34F - 0.1F * var22;
            }

            float var23 = 0.97F + 0.04F * (var6[var11] - 0.5F);
            var0[(var3 + var7) * (1839404183 ^ 1839403159) + var2 + var10] = c(var14 * var23, var15 * var23, var16 * var23);
         }
      }
   }

   private static void f(int[] var0, int var1) {

      int var2 = (var1 & 1) * (1079107762 ^ 1079108274);
      int var3 = (var1 >> 1) * (-1719716698 ^ -1719716762);
      int var4 = -349567211 ^ -349567947;
      int var5 = 203783893 ^ 203784181;
      float[] var6 = b(var4, var5, 88, 44, 31);
      float[] var7 = b(var4, var5, 30, 15, 32);
      acc(var6, 0.75F, var7, 0.25F);
      float[] var8 = b(762119614 ^ 762120126, 140842252 ^ 140842444, 120, 60, 33);
      float[] var9 = b(-1667353337 ^ -1667352825, -1598008573 ^ -1598008381, 120, 60, 34);
      float[] var10 = b(-1338687055 ^ -1338686543, 1426562339 ^ 1426562531, 28512993 ^ 28512833, 80, 35);
      float[] var11 = b(320819811 ^ 320819299, 1145217138 ^ 1145217202, 40, 20, 39);
      float[] var12 = b(-782256425 ^ -782256937, 1606792456 ^ 1606792648, 1, 1, 37);
      float[] var13 = b(429970720 ^ 429971232, 768450952 ^ 768450888, 4, 4, 38);
      float[] var14 = new float[245760];

      for (int var15 = 0; var15 < (-1260277708 ^ -1260277612); var15++) {
         for (int var16 = 0; var16 < (2029027510 ^ 2029028022); var16++) {
            int var17 = var15 * (442820210 ^ 442819698) + var16;
            float var18 = var15 < (607296467 ^ 607296339) ? (float)var16 : (float)var16 * 1.26F + 30.0F;
            float var19 = var15 < (722617901 ^ 722618029) ? (float)var15 * 0.76F : 100.0F + (float)(var15 - (1224274414 ^ 1224274286)) * 1.83F;
            float var20 = var18 + 64.0F + 90.0F * (var8[var17] - 0.5F) + 20.0F * (var11[var17] - 0.5F);
            float var21 = var19 + 64.0F + 70.0F * (var9[var17] - 0.5F);
            int var22 = (int)var20;
            int var23 = (int)var21;
            float var24 = var20 - (float)var22;
            float var25 = var21 - (float)var23;
            var22 = var22 < 0 ? 0 : (var22 > var4 - 2 ? var4 - 2 : var22);
            var23 = var23 < 0 ? 0 : (var23 > var5 - 2 ? var5 - 2 : var23);
            float var26 = var6[var23 * var4 + var22];
            float var27 = var6[var23 * var4 + var22 + 1];
            float var28 = var6[(var23 + 1) * var4 + var22];
            float var29 = var6[(var23 + 1) * var4 + var22 + 1];
            float var30 = (var26 + (var27 - var26) * var24) * (1.0F - var25) + (var28 + (var29 - var28) * var24) * var25;
            float var31 = (var30 - 0.4F) / 0.22F;
            var31 = var31 < 0.0F ? 0.0F : (var31 > 1.0F ? 1.0F : var31);
            var31 = var31 * var31 * (3.0F - 2.0F * var31);
            float var32 = (float)Math.sin((double)((var30 * 26.0F + var11[var17] * 2.0F) * 3.14159F));
            float var33 = var32 > 0.82F ? (var32 - 0.82F) / 0.18F * var31 : 0.0F;
            float var34 = var10[var17] * 1.5F - 0.25F;
            float var35;
            float var36;
            float var37;
            if (var34 < 0.5F) {
               float var38 = Math.max(0.0F, var34 / 0.5F);
               var35 = 0.22F + 0.42F * var38;
               var36 = 0.3F - 0.16F * var38;
               var37 = 1.0F - 0.12F * var38;
            } else {
               float var55 = Math.min(1.0F, (var34 - 0.5F) / 0.5F);
               var35 = 0.64F + 0.34F * var55;
               var36 = 0.14F + 0.04F * var55;
               var37 = 0.88F - 0.4F * var55;
            }

            float var56 = var31 * (0.92F + 0.1F * (var13[var17] - 0.5F));
            int var39 = var17 * 3;
            var14[var39] = 0.03F + var35 * var56 + 0.35F * var33;
            var14[var39 + 1] = 0.018F + var36 * var56 + 0.22F * var33;
            var14[var39 + 2] = 0.05F + var37 * var56 + 0.35F * var33;
         }
      }

      for (int var40 = 2; var40 < (-44618209 ^ -44618111); var40++) {
         for (int var42 = 2; var42 < (1901809598 ^ 1901809216); var42++) {
            float var44 = var12[var40 * (543046270 ^ 543045758) + var42];
            if (var44 > 0.9975F) {
               float var46 = (var44 - 0.9975F) / 0.0025F * 0.8F + 0.45F;

               for (int var47 = -2; var47 <= 2; var47++) {
                  float var48 = var47 == 0 ? var46 : var46 * (Math.abs(var47) == 1 ? 0.4F : 0.1F);
                  int var49 = (var40 * (-352569615 ^ -352570127) + var42 + var47) * 3;
                  int var51 = ((var40 + var47) * (2061379047 ^ 2061379559) + var42) * 3;
                  var14[var49] += var48;
                  var14[var49 + 1] = var14[var49 + 1] + var48 * 0.85F;
                  var14[var49 + 2] = var14[var49 + 2] + var48;
                  if (var47 != 0) {
                     var14[var51] += var48;
                     var14[var51 + 1] = var14[var51 + 1] + var48 * 0.85F;
                     var14[var51 + 2] = var14[var51 + 2] + var48;
                  }
               }
            }
         }
      }

      for (int var41 = 0; var41 < (862922968 ^ 862922872); var41++) {
         for (int var43 = 0; var43 < (931012499 ^ 931011987); var43++) {
            int var45 = (var41 * (150093167 ^ 150093679) + var43) * 3;
            var0[(var3 + var41) * (-583995718 ^ -583996742) + var2 + var43] = c(var14[var45], var14[var45 + 1], var14[var45 + 2]);
         }
      }
   }

   private static void g(int[] var0, int var1) {

      int var2 = (var1 & 1) * (-12717543 ^ -12718055);
      int var3 = (var1 >> 1) * (1650585739 ^ 1650585675);
      float[] var4 = b(2005138977 ^ 2005138465, -101560568 ^ -101560376, -387988889 ^ -387988761, 64, 41);
      float[] var5 = b(-617200968 ^ -617201480, -1960127851 ^ -1960127915, 40, 20, 42);
      float[] var6 = b(-288377820 ^ -288377308, -532635324 ^ -532635260, 12, 10, 43);
      float[] var7 = b(1456419785 ^ 1456419273, 1146930442 ^ 1146930634, 48, 1, 44);

      for (int var8 = 0; var8 < (986070593 ^ 986070753); var8++) {
         boolean var9 = var8 < (-1208157857 ^ -1208157729);
         float var10 = var9 ? (float)var8 : (float)(var8 - (1340318763 ^ 1340318891)) * 2.0F;

         for (int var11 = 0; var11 < (954845757 ^ 954845245); var11++) {
            int var12 = var8 * (2123989789 ^ 2123989277) + var11;
            float var13 = var9
               ? (float)var11 * 0.017F
                  + 0.75F * (float)Math.sin((double)(var10 * 0.034F + (float)var11 * 0.005F))
                  + 1.7F * (var4[var12] - 0.5F)
                  + 0.45F * (var5[var12] - 0.5F)
               : (float)var11 * 0.021F
                  + 0.25F * (float)Math.sin((double)(var10 * 0.05F + (float)var11 * 0.01F))
                  + 1.4F * (var4[var12] - 0.5F)
                  + 0.4F * (var5[var12] - 0.5F);
            float var14 = (float)Math.sin((double)(var13 * 6.2832F));
            float var15 = 0.42F + 0.5F * (var5[var12] - 0.5F) + 0.15F * (var6[var12] - 0.5F);
            float var16 = (var14 - var15) * 4.0F;
            var16 = var16 < 0.0F ? 0.0F : (var16 > 1.0F ? 1.0F : var16);
            var16 = var16 * var16 * (3.0F - 2.0F * var16);
            float var17 = 1.0F - 0.26F * var16;
            float var18 = 0.77F - 0.45F * var16;
            float var19 = 0.22F - 0.18F * var16;
            float var20 = 1.0F + 0.05F * (var7[var12] - 0.5F) + 0.04F * (var6[var12] - 0.5F);
            var0[(var3 + var8) * (693625066 ^ 693626090) + var2 + var11] = c(var17 * var20, var18 * var20, var19 * var20);
         }
      }
   }

   private static void h(int[] var0, int var1) {

      int var2 = (var1 & 1) * (-331008917 ^ -331008405);
      int var3 = (var1 >> 1) * (-2048651133 ^ -2048651197);
      float[] var4 = b(506656833 ^ 506657345, -1083503793 ^ -1083503729, 64, 32, 51);
      float[] var5 = b(-790105633 ^ -790105121, -1867085415 ^ -1867085479, 16, 10, 52);
      float[] var6 = b(1246870662 ^ 1246871174, 20669988 ^ 20670180, 48, 1, 53);
      float[] var7 = new float[16];
      long var8 = 20973L;

      for (int var10 = 0; var10 < var7.length; var10++) {
         var8 = var8 * 6364136223846793005L + 1442695040888963407L;
         var7[var10] = ((float)(var8 >>> 33) / 2.1474836E9F - 0.5F) * 0.22F;
      }

      for (int var44 = 0; var44 < (-111745178 ^ -111745082); var44++) {
         boolean var11 = var44 < (-1129729607 ^ -1129729735);
         float var12;
         float var13;
         float var14;
         if (var11) {
            var12 = ((float)var44 + 0.5F) / 128.0F * 1.9F;
            var13 = 6.1F;
            var14 = 0.75F;
         } else {
            var12 = ((float)var44 - 127.5F) / 32.0F * 1.15F;
            var13 = 3.4F;
            var14 = -2.6F;
         }

         for (int var15 = 0; var15 < (-1973014598 ^ -1973015110); var15++) {
            int var16 = var44 * (626871708 ^ 626872220) + var15;
            float var17 = var11 ? ((float)var15 + 0.5F) / 512.0F * 10.0F : ((float)var15 + 0.5F) / 512.0F * 12.67F;
            float var18 = var17 - var13;
            float var19 = var12 - var14;
            float var20 = (float)Math.sqrt((double)(var18 * var18 + var19 * var19));
            float var21 = (float)Math.atan2((double)var19, (double)var18);
            byte var22 = 13;
            float var23 = 6.2832F / (float)var22;
            float var24 = (var21 + 3.14159F) / var23;
            int var25 = (int)Math.floor((double)var24);
            float var26 = var24 - (float)var25;
            float var27 = var7[(var25 % var22 + var22) % var22];
            float var28 = var7[((var25 + 1) % var22 + var22) % var22];
            float var29 = var20 * Math.abs((float)Math.sin((double)((var26 + var27) * var23)));
            float var30 = var20 * Math.abs((float)Math.sin((double)((1.0F - var26 - var28) * var23)));
            float var31 = Math.min(var29, var30);
            float var32 = 0.2F * (float)Math.sin((double)(Math.max(0.0F, Math.min(1.0F, var26)) * 3.14159F));
            float var33 = var20 / (1.0F - var32 * 0.6F);
            float var34 = (float)Math.sqrt((double)(var33 / 0.3F));
            float var35 = var34 - (float)Math.floor((double)(var34 + 0.5F));
            float var36 = Math.abs(var35) * 2.0F * 0.3F * var34;
            float var37 = 0.036F + 0.012F * (var5[var16] - 0.5F);
            float var38 = 0.0F;
            if (var31 < var37 * 2.0F) {
               var38 = Math.max(var38, 1.0F - Math.max(0.0F, var31 - var37) / var37);
            }

            if (var36 < var37 * 2.0F && var20 > 0.12F) {
               var38 = Math.max(var38, 1.0F - Math.max(0.0F, var36 - var37) / var37);
            }

            var38 = var38 < 0.0F ? 0.0F : (var38 > 1.0F ? 1.0F : var38);
            float var39 = 0.82F + 0.36F * (var4[var16] - 0.5F) + 0.12F * (var5[var16] - 0.5F);
            float var40 = 0.64F * var39;
            float var41 = 0.04F * var39;
            float var42 = 0.055F * var39;
            float var43 = 1.0F + 0.05F * (var6[var16] - 0.5F);
            var40 = (var40 + (0.035F - var40) * var38) * var43;
            var41 = (var41 + (0.012F - var41) * var38) * var43;
            var42 = (var42 + (0.015F - var42) * var38) * var43;
            var0[(var3 + var44) * (1902175022 ^ 1902176046) + var2 + var15] = c(var40, var41, var42);
         }
      }
   }

   private static void i(int[] var0, int var1) {

      int var2 = (var1 & 1) * (-582454162 ^ -582453650);
      int var3 = (var1 >> 1) * (-1712476029 ^ -1712476093);
      float[] var4 = b(1971688128 ^ 1971687616, 1721450709 ^ 1721450517, 64, 32, 61);
      float[] var5 = b(1260121642 ^ 1260121130, 2136916132 ^ 2136916068, 6, 5, 62);
      float[] var6 = b(-1542687841 ^ -1542688353, 286142099 ^ 286142035, 120, 1, 63);
      float[] var7 = b(1615717719 ^ 1615718231, -587873410 ^ -587873346, 20, 12, 64);

      for (int var8 = 0; var8 < (1011018659 ^ 1011018499); var8++) {
         boolean var9 = var8 < (960051766 ^ 960051894);
         float var10 = var9 ? ((float)var8 + 0.5F) / 128.0F : ((float)var8 - 127.5F) / 32.0F;

         for (int var11 = 0; var11 < (1664080619 ^ 1664080107); var11++) {
            int var12 = var8 * (297237274 ^ 297236762) + var11;
            float var13 = ((float)var11 + 0.5F) / 512.0F;
            float var14 = 0.9F + 0.2F * (var4[var12] - 0.5F) + 0.04F * (var6[var12] - 0.5F);
            float var15 = 0.29F * var14;
            float var16 = 0.14F * var14;
            float var17 = 0.45F * var14;
            float var18 = var9
               ? Math.max((var10 - 0.84F) * 7.0F, (var13 - 0.9F) * 9.0F) + (var5[var12] - 0.5F) * 1.6F + (var7[var12] - 0.5F) * 0.8F
               : Math.max((var10 - 0.93F) * 8.0F, (0.07F - var10) * 8.0F) + (var5[var12] - 0.5F) * 0.8F - 0.25F;
            if (var9 && var10 < 0.03F) {
               var18 = Math.max(var18, 0.6F);
            }

            if (var18 > 0.0F) {
               float var19 = Math.min(1.0F, var18 * 1.5F);
               float var20 = 0.8F + 0.06F * (var6[var12] - 0.5F);
               var15 += (var20 * 0.97F - var15) * var19;
               var16 += (var20 * 0.98F - var16) * var19;
               var17 += (var20 - var17) * var19;
            }

            var0[(var3 + var8) * (130645925 ^ 130644901) + var2 + var11] = c(var15, var16, var17);
         }
      }
   }

   private static void j(int[] var0) {

      float[] var1 = b(-740562322 ^ -740562834, -1230735104 ^ -1230734976, 96, 3, 71);
      float[] var2 = b(1258683493 ^ 1258684005, 1914392418 ^ 1914392546, 24, 2, 72);
      float[] var3 = b(466704043 ^ 466703531, -1858069853 ^ -1858069981, 64, 32, 73);
      float[] var4 = b(-512642821 ^ -512642309, 1199026221 ^ 1199026349, 12, 8, 74);
      float[] var5 = b(1981001348 ^ 1981000836, -1797476629 ^ -1797476757, 2, 2, 75);
      float[] var6 = b(-2042660824 ^ -2042660312, -2139165369 ^ -2139165241, 3, 40, 76);

      for (int var7 = 0; var7 < (501652890 ^ 501652762); var7++) {
         float var8 = ((float)var7 + 0.5F) / 128.0F;

         for (int var9 = 0; var9 < (-694427187 ^ -694426675); var9++) {
            int var10 = var7 * (-424533014 ^ -424533526) + var9;
            float var11 = ((float)var9 + 0.5F) / 512.0F;
            float var12 = 0.69F
               + 0.045F * (float)Math.sin((double)(var11 * 6.2832F * 6.0F + 0.4F))
               + 0.025F * (float)Math.sin((double)(var11 * 6.2832F * 15.0F + 1.3F))
               + 0.04F * (var3[var10] - 0.5F);
            if (var11 > 0.86F) {
               var12 -= (var11 - 0.86F) * 1.6F;
            }

            float var13;
            if (var8 < 0.31F) {
               var13 = 0.36F + 0.05F * (var1[var10] - 0.5F) + 0.02F * (var5[var10] - 0.5F);
            } else {
               var13 = 0.5F + 0.09F * (var1[var10] - 0.5F) + 0.05F * (var2[var10] - 0.5F) + 0.02F * (var5[var10] - 0.5F);
            }

            float var14 = var8 - var12;
            if (var14 > 0.0F) {
               float var15 = Math.min(1.0F, var14 / 0.04F);
               float var16 = 0.95F + 0.03F * (var5[var10] - 0.5F) + 0.03F * (var4[var10] - 0.5F);
               var13 += (var16 - var13) * var15;
               if (var6[var10] > 0.66F && var14 < 0.14F) {
                  var13 -= (var6[var10] - 0.66F) * 0.6F * (1.0F - var14 / 0.14F);
               }
            }

            float var17 = 1.0F - Math.abs(var14) / 0.02F;
            if (var17 > 0.0F) {
               var13 += 0.14F * var17 * var17;
            }

            if (var8 > 0.965F) {
               var13 = Math.max(var13, 0.94F);
            }

            var0[((1870083438 ^ 1870083886) + var7) * (1433806333 ^ 1433805309) + (1008916526 ^ 1008917038) + var9] = c(var13 * 0.98F, var13 * 0.99F, var13);
         }
      }
   }

   private static void k(int[] var0) {

      float var1 = 40.41042F;
      float var2 = 27.826088F;

      for (int var3 = 0; var3 < 7; var3++) {
         int var4 = (var3 & 1) * (-2034437125 ^ -2034437637);
         int var5 = (var3 >> 1) * (-1702815470 ^ -1702815278);

         for (int var6 = 0; var6 < 32; var6++) {
            float var7 = ((float)var6 + 0.5F) / var2;

            for (int var8 = 0; var8 < (-2077665330 ^ -2077665842); var8++) {
               float var9 = ((float)var8 + 0.5F) / var1;
               float var10 = 9.0F;

               for (int var11 = 0; var11 < 3; var11++) {
                  float var12 = (WIN_X[var11 * 2] + WIN_X[var11 * 2 + 1]) * 0.5F;
                  float var13 = (WIN_X[var11 * 2 + 1] - WIN_X[var11 * 2]) * 0.5F - 0.2F;
                  float var14 = 0.575F;
                  float var15 = 0.105000004F;
                  float var16 = Math.abs(var9 - var12) - var13;
                  float var17 = Math.abs(var7 - var14) - var15;
                  float var18 = Math.max(var16, 0.0F);
                  float var19 = Math.max(var17, 0.0F);
                  float var20 = (float)Math.sqrt((double)(var18 * var18 + var19 * var19)) + Math.min(Math.max(var16, var17), 0.0F) - 0.2F;
                  var10 = Math.min(var10, var20);
               }

               int var21 = var0[(var5 + (1535136058 ^ 1535136186) + var6) * (-90070257 ^ -90069233) + var4 + var8];
               float var22 = 0.5F + var10 * var2;
               var22 = var22 < 0.0F ? 0.0F : (var22 > 1.0F ? 1.0F : var22);
               if (var10 > 0.0F && var10 < 0.07F) {
                  float var24 = 1.0F + 0.28F * (1.0F - var10 / 0.07F);
                  int var25 = Math.min(-833973391 ^ -833973362, (int)((float)(var21 >> 16 & (230631899 ^ 230631716)) * var24 + 10.0F));
                  int var26 = Math.min(820470028 ^ 820470259, (int)((float)(var21 >> 8 & (643587749 ^ 643587674)) * var24 + 10.0F));
                  int var27 = Math.min(-1437928790 ^ -1437928875, (int)((float)(var21 & (-1371200692 ^ -1371200589)) * var24 + 10.0F));
                  var21 = -1032450548 ^ 1031147020 | var25 << 16 | var26 << 8 | var27;
               }

               var0[(var5 + (1457796596 ^ 1457796436) + var6) * (-1316948309 ^ -1316949333) + var4 + var8] = (int)(var22 * 255.0F + 0.5F) << 24
                  | var21 & (363424852 ^ 357995435);
            }
         }
      }
   }

   private static void l(int[] var0, int var1, int var2, int var3, int var4, float var5) {

      float var6 = 0.035F + var5;

      for (int var7 = 0; var7 < var3; var7++) {
         for (int var8 = 0; var8 < var3; var8++) {
            float var9 = ((float)var8 + 0.5F - (float)var3 * 0.5F) / (float)var4;
            float var10 = ((float)var3 * 0.5F - ((float)var7 + 0.5F)) / (float)var4;
            float var11 = var9 * var9 + var10 * var10;
            if (var11 > 0.995F) {
               float var12 = (float)Math.sqrt((double)(var11 / 0.995F));
               var9 /= var12;
               var10 /= var12;
               var11 = 0.995F;
            }

            float var38 = (float)Math.sqrt((double)(1.0F - var11));
            float var13 = 2.0F * var38 * var9;
            float var14 = 2.0F * var38 * var10;
            float var15 = 2.0F * var38 * var38 - 1.0F;
            float var16 = (float)Math.atan2((double)var13, (double)var15);
            float var17 = (float)Math.asin((double)Math.max(-1.0F, Math.min(1.0F, var14)));
            float var18 = Math.max(0.0F, var14);
            float var19 = 0.06F + 0.06F * var18;
            float var20 = 0.065F + 0.065F * var18;
            float var21 = 0.075F + 0.07F * var18;
            if (var14 < -0.12F) {
               float var22 = Math.min(1.0F, (-var14 - 0.12F) * 2.0F);
               var19 += 0.05F * var22;
               var20 += 0.04F * var22;
               var21 += 0.025F * var22;
            }

            float var54 = Math.max(0.0F, Math.min(1.0F, 1.0F - (Math.abs(var17 - 0.42F) - 0.32F) / var6));
            float var23 = Math.max(0.0F, Math.min(1.0F, 1.0F - (Math.abs(var16 + 0.66F) - 0.34F) / var6));
            float var24 = Math.max(0.0F, Math.min(1.0F, 1.0F - (Math.abs(var16 + 0.07F) - 0.2F) / var6));
            float var25 = var54 * (var23 + 0.8F * var24);
            var19 += 0.9F * var25;
            var20 += 0.86F * var25;
            var21 += 0.79F * var25;
            float var26 = Math.max(0.0F, Math.min(1.0F, 1.0F - (Math.abs(var16 - 0.58F) - 0.08F) / var6));
            float var27 = Math.max(0.0F, Math.min(1.0F, 1.0F - (Math.abs(var17 - 0.15F) - 0.5F) / var6));
            float var28 = var26 * var27;
            var19 += 0.62F * var28;
            var20 += 0.68F * var28;
            var21 += 0.78F * var28;
            float var29 = var6 + 0.06F;
            float var30 = Math.max(0.0F, Math.min(1.0F, 1.0F - (Math.abs(var16 + 0.3F) - 0.8F) / var29));
            float var31 = Math.max(0.0F, Math.min(1.0F, 1.0F - (Math.abs(var17 + 0.52F) - 0.3F) / var29));
            float var32 = var30 * var31 * (0.55F + 0.45F * Math.max(0.0F, Math.min(1.0F, (var17 + 0.82F) / 0.6F)));
            var19 += 0.55F * var32;
            var20 += 0.54F * var32;
            var21 += 0.52F * var32;
            float var33 = Math.max(0.0F, Math.min(1.0F, (var17 - 1.05F) / var6 + 0.5F));
            var19 += 0.5F * var33;
            var20 += 0.5F * var33;
            var21 += 0.52F * var33;
            float var34 = 1.0F - Math.abs(var17 + 0.06F) / (0.022F + var5 * 0.5F);
            if (var34 > 0.0F) {
               float var35 = var34 * (var5 > 0.0F ? 0.2F : 0.36F);
               var19 += var35;
               var20 += var35;
               var21 += var35 * 1.04F;
            }

            float var55 = Math.max(0.0F, Math.min(1.0F, 1.0F - (Math.abs(Math.abs(var16) - 2.55F) - 0.22F) / var6));
            float var36 = Math.max(0.0F, Math.min(1.0F, 1.0F - (Math.abs(var17 - 0.28F) - 0.36F) / var6));
            float var37 = var55 * var36;
            var19 += 0.16F * var37;
            var20 += 0.24F * var37;
            var21 += 0.42F * var37;
            var0[(var2 + var7) * (-840937864 ^ -840938888) + var1 + var8] = c(var19, var20, var21);
         }
      }
   }

   private static void m(int[] var0) {

      float var1 = 32.0F;

      for (int var2 = 0; var2 < 64; var2++) {
         float var3 = ((float)var2 + 0.5F - var1) / var1;

         for (int var4 = 0; var4 < 64; var4++) {
            float var5 = ((float)var4 + 0.5F - var1) / var1;
            float var6 = (float)Math.sqrt((double)(var5 * var5 + var3 * var3));
            float var7 = 0.75F * (float)Math.exp((double)(-(var6 / 0.2F) * (var6 / 0.2F))) + 0.25F * (float)Math.exp((double)(-(var6 / 0.5F) * (var6 / 0.5F)));
            float var8 = var6 <= 0.7F ? 1.0F : (var6 >= 0.9F ? 0.0F : 1.0F - (var6 - 0.7F) / 0.2F);
            var8 = var8 * var8 * (3.0F - 2.0F * var8);
            int var9 = (int)(var7 * var8 * 255.0F + 0.5F);
            var9 = var9 > (2087690559 ^ 2087690688) ? 474993064 ^ 474992983 : var9;
            var0[((1226099933 ^ 1226100573) + var2) * (-464698435 ^ -464697411) + (1649919209 ^ 1649919465) + var4] = 2007974998 ^ -2001779626
               | var9 << 16
               | var9 << 8
               | var9;
         }
      }
   }

   private static void n(int[] var0) {

      float[] var1 = b(-584094684 ^ -584094428, 1195251213 ^ 1195251341, 24, 12, 81);
      float[] var2 = b(-651803601 ^ -651803345, -1330802798 ^ -1330802926, 2, 2, 82);
      float[] var3 = b(1046320258 ^ 1046320514, -1791886954 ^ -1791887082, -2045944823 ^ -2045944639, 2, 83);

      for (int var4 = 0; var4 < (1937909076 ^ 1937909204); var4++) {
         for (int var5 = 0; var5 < (-1793600887 ^ -1793600631); var5++) {
            int var6 = var4 * (-1825704808 ^ -1825704552) + var5;
            float var7 = (float)(var5 + var4) / 7.0F;
            float var8 = (float)(var5 - var4) / 7.0F + 64.0F;
            float var9 = var7 - (float)Math.floor((double)var7) - 0.5F;
            float var10 = var8 - (float)Math.floor((double)var8) - 0.5F;
            float var11 = 1.0F - (Math.abs(var9) + Math.abs(var10));
            float var12 = (var9 > 0.0F ? -1.0F : 1.0F) * 0.5F + (var10 > 0.0F ? -1.0F : 1.0F) * 0.3F;
            float var13 = 0.135F + 0.03F * (var1[var6] - 0.5F) + 0.02F * (var2[var6] - 0.5F) + 0.025F * (var3[var6] - 0.5F);
            var13 *= 0.8F + 0.28F * var11 + 0.1F * var12;
            var0[((-1732098133 ^ -1732098901) + var4) * (1583517814 ^ 1583518838) + (359925499 ^ 359925627) + var5] = c(var13 * 0.95F, var13, var13 * 1.08F);
         }
      }
   }

   private static void o(int[] var0) {

      float[] var1 = b(-1332576456 ^ -1332576712, 1907236243 ^ 1907236115, 16, 16, 91);
      float[] var2 = b(389193052 ^ 389192796, -604283084 ^ -604282956, 1, 2, 92);

      for (int var3 = 0; var3 < (1979925140 ^ 1979925012); var3++) {
         for (int var4 = 0; var4 < (921299646 ^ 921299902); var4++) {
            int var5 = var3 * (1598274724 ^ 1598274980) + var4;
            float var6 = ((float)var4 + (float)var3 * 0.42F) / 10.0F;
            float var7 = var6 - (float)Math.floor((double)var6);
            float var8 = (float)Math.sin((double)(var7 * 3.14159F));
            float var9 = (float)Math.sin((double)(((float)var4 * 0.9F - (float)var3 * 1.6F) / 3.2F * 3.14159F)) * 0.5F + 0.5F;
            float var10 = 0.05F + 0.17F * (float)Math.pow((double)var8, 0.6) + 0.035F * var9 * var8 + 0.02F * (var2[var5] - 0.5F) + 0.02F * (var1[var5] - 0.5F);
            var0[((-1033078712 ^ -1033077816) + var3) * (617774998 ^ 617773974) + (717122649 ^ 717123033) + var4] = c(var10 * 1.02F, var10, var10 * 0.98F);
         }
      }
   }

   private static void p(int[] var0) {

      float[] var1 = b(384278171 ^ 384278427, 1373248872 ^ 1373249000, 3, 3, 101);
      float[] var2 = b(-1583197939 ^ -1583198195, 44614006 ^ 44614134, 1, 1, 102);
      float[] var3 = b(-1361310349 ^ -1361310605, 867765769 ^ 867765897, 40, 4, 103);

      for (int var4 = 0; var4 < (621024505 ^ 621024377); var4++) {
         for (int var5 = 0; var5 < (2121346900 ^ 2121346644); var5++) {
            int var6 = var4 * (-1311869646 ^ -1311869902) + var5;
            float var7 = (float)var5 / 36.0F + (float)var4 / 64.0F;
            float var8 = (float)var5 / 36.0F - (float)var4 / 64.0F + 32.0F;
            float var9 = var7 - (float)Math.floor((double)var7) - 0.5F;
            float var10 = var8 - (float)Math.floor((double)var8) - 0.5F;
            float var11 = Math.max(Math.abs(var9), Math.abs(var10));
            float var12;
            float var13;
            float var14;
            if (Math.abs(var9) < 0.27F && Math.abs(var10) < 0.27F) {
               float var19 = Math.max(0.0F, (Math.max(Math.abs(var9), Math.abs(var10)) - 0.2F) / 0.07F);
               float var20 = 0.84F + 0.1F * (var1[var6] - 0.5F) + 0.06F * (var2[var6] - 0.5F);
               float var22 = var20 * (1.0F - 0.45F * var19 * var19);
               var12 = var22;
               var13 = var22 * 0.97F;
               var14 = var22 * 0.88F;
            } else {
               boolean var15 = ((int)Math.floor((double)var7) + (int)Math.floor((double)var8) & 1) == 0;
               float var16 = var15 ? Math.abs(var9) : Math.abs(var10);
               float var17 = 0.06F + 0.12F * (1.0F - Math.abs(var16 - 0.5F) * 2.0F) + 0.03F * (var3[var6] - 0.5F);
               float var18 = Math.min(1.0F, (var11 - 0.27F) / 0.08F);
               var17 *= 0.6F + 0.4F * Math.max(0.0F, var18);
               var12 = var17;
               var13 = var17;
               var14 = var17 * 1.1F;
            }

            var0[((930485574 ^ 930485830) + var4) * (1896255397 ^ 1896254373) + (-1812888093 ^ -1812887709) + var5] = c(var12, var13, var14);
         }
      }
   }

   private static void q(int[] var0) {

      float[] var1 = b(-1583338514 ^ -1583338770, 1213674117 ^ 1213673989, 2, 2, 111);
      float[] var2 = b(539062395 ^ 539062651, -235079162 ^ -235079034, 20, 20, 112);
      float[] var3 = b(-655108297 ^ -655108553, 100230617 ^ 100230489, 60, 1, 113);

      for (int var4 = 0; var4 < (1241376531 ^ 1241376659); var4++) {
         for (int var5 = 0; var5 < (-1414316006 ^ -1414315750); var5++) {
            int var6 = var4 * (-1121993517 ^ -1121993261) + var5;
            float var7 = 0.12F + 0.03F * (var1[var6] - 0.5F) + 0.015F * (var2[var6] - 0.5F);
            var0[((988728487 ^ 988729127) + var4) * (1249940236 ^ 1249941260) + (430275894 ^ 430276534) + var5] = c(var7, var7, var7 * 1.04F);
            if (var5 < (-2044202192 ^ -2044202064)) {
               float var8 = 0.24F + 0.04F * (var1[var6] - 0.5F) + 0.02F * (var2[var6] - 0.5F) + 0.02F * (var3[var6] - 0.5F);
               var0[((790030219 ^ 790029451) + var4) * (410230687 ^ 410229663) + (2010338868 ^ 2010338740) + var5] = c(var8 * 0.94F, var8 * 0.97F, var8 * 1.06F);
            }

            if (var5 < 64) {
               float var9 = var3[var6] - 0.5F;
               var0[((-1524726634 ^ -1524725994) + var4) * (-125505028 ^ -125504004) + (-931428239 ^ -931427343) + var5] = c(
                  0.86F + 0.08F * var9, 0.66F + 0.06F * var9, 0.32F + 0.04F * var9
               );
               var0[((1391125360 ^ 1391124720) + var4) * (1014444827 ^ 1014445851) + (73884013 ^ 73884333) + var5] = -1;
            }
         }
      }
   }

   public static int[] r() {

      int[] var0 = new int[1048576];
      Arrays.fill(var0, 1491350311 ^ -1478216921);
      d(var0, 0, false);
      e(var0, 1);
      f(var0, 2);
      g(var0, 3);
      h(var0, 4);
      i(var0, 5);
      d(var0, 6, true);
      j(var0);
      k(var0);
      l(var0, 0, 1285470927 ^ 1285470671, -994092708 ^ -994092964, 120, 0.0F);
      l(var0, 1269047094 ^ 1269046838, -1366897473 ^ -1366896705, 982592259 ^ 982592387, 60, 0.22F);
      m(var0);
      n(var0);
      o(var0);
      p(var0);
      q(var0);
      return var0;
   }

   public static int[][] s(int[] var0) {

      int[][] var1 = new int[6][];
      var1[0] = var0;
      int var2 = 1644291561 ^ 1644290537;
      int var3 = 453339251 ^ 453340275;

      for (int var4 = 1; var4 < 6; var4++) {
         int var5 = var2 >> 1;
         int var6 = var3 >> 1;
         int[] var7 = var1[var4 - 1];
         int[] var8 = new int[var5 * var6];

         for (int var9 = 0; var9 < var6; var9++) {
            for (int var10 = 0; var10 < var5; var10++) {
               int var11 = var7[var9 * 2 * var2 + var10 * 2];
               int var12 = var7[var9 * 2 * var2 + var10 * 2 + 1];
               int var13 = var7[(var9 * 2 + 1) * var2 + var10 * 2];
               int var14 = var7[(var9 * 2 + 1) * var2 + var10 * 2 + 1];
               int var15 = (var11 >>> 24) + (var12 >>> 24) + (var13 >>> 24) + (var14 >>> 24) + 2 >> 2;
               int var16 = (var11 >> 16 & (-657134751 ^ -657134690))
                     + (var12 >> 16 & (-981193613 ^ -981193588))
                     + (var13 >> 16 & (1445647742 ^ 1445647745))
                     + (var14 >> 16 & (1058797395 ^ 1058797484))
                     + 2
                  >> 2;
               int var17 = (var11 >> 8 & (-1741676133 ^ -1741676188))
                     + (var12 >> 8 & (-613295234 ^ -613295231))
                     + (var13 >> 8 & (-1841531391 ^ -1841531138))
                     + (var14 >> 8 & (1588175881 ^ 1588176118))
                     + 2
                  >> 2;
               int var18 = (var11 & (-781687816 ^ -781688057))
                     + (var12 & (-416709392 ^ -416709617))
                     + (var13 & (-1906571283 ^ -1906571502))
                     + (var14 & (-1648702937 ^ -1648702760))
                     + 2
                  >> 2;
               var8[var9 * var5 + var10] = var15 << 24 | var16 << 16 | var17 << 8 | var18;
            }
         }

         var1[var4] = var8;
         var2 = var5;
         var3 = var6;
      }

      return var1;
   }
}
