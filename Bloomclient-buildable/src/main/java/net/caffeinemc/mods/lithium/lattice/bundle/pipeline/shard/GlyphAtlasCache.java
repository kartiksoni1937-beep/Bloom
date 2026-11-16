package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import java.awt.Font;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.PathIterator;
import java.awt.geom.Rectangle2D;
import java.io.ByteArrayInputStream;
import java.util.Arrays;

public final class GlyphAtlasCache {
   public static final int EM = 48;
   public static final int SPREAD = 16;
   public static final int MARGIN = 22;
   public static final int QM = 12;
   public static final int AW = 1024;
   public static final int LEVELS = 5;
   public static final int CP = 10240;
   public static final float UNIT = 0.16666667F;
   public static final float BASE = 7.0F;
   public static final short[] IDX = new short[10240];
   public static float[] ADV;
   public static float[] QX0;
   public static float[] QY0;
   public static float[] QX1;
   public static float[] QY1;
   public static float[] U0;
   public static float[] V0;
   public static float[] U1;
   public static float[] V1;
   public static final float[] SPACE = new float[10240];
   public static int AH;
   public static int[][] LV;
   private static final int[] g = new int[]{
      8211,
      8212,
      8216,
      8217,
      8218,
      8220,
      8221,
      8222,
      8224,
      8225,
      8226,
      8230,
      8240,
      8242,
      8249,
      8250,
      8364,
      8482,
      8592,
      8593,
      8594,
      8595,
      8596,
      8597,
      8598,
      8599,
      8600,
      8601,
      8722,
      8734,
      8776,
      8800,
      8804,
      8805,
      9650,
      9651,
      9679,
      10003,
      338,
      339,
      352,
      353,
      376,
      381,
      382,
      402,
      305
   };

   private GlyphAtlasCache() {
   }

   private static int[] a() {

      assert g != null
         && g.length > 10
         && IDX != null
         && IDX.length == (-714701518 ^ -714691278)
         && SPACE != null
         && SPACE.length == (2131025668 ^ 2131031812)
         && g[0] > 126
         && g[0] < (1254005908 ^ 1254012052)
         && g[g.length - 1] > 126
         && g[g.length - 1] < (-1744519037 ^ -1744508797)
         && (Object)IDX != (Object)SPACE
         && g[1] > 126
         && g[2] > 126
         && g[3] > 126
         && g[4] > 126
         && g[5] > 126
         && g[6] > 126
         && g[7] > 126
         && g[8] > 126
         && g[9] > 126
         && g[10] > 126
         && IDX[32] >= -2
         && IDX[65] >= -2
         && IDX[97] >= -2
         && SPACE[32] >= 0.0F
         && SPACE[65] >= 0.0F
         && g[1] < (-1543409670 ^ -1543419910)
         && g[2] < (166431493 ^ 166437637)
         && g[3] < (1697624281 ^ 1697618137)
         && g[4] < (-1027012197 ^ -1027006053)
         && g[5] < (-767501960 ^ -767495816) : "wanted: bad tab" + "l" + "es";

      int[] var0 = new int[(-537349326 ^ -537349236) + g.length];
      int var1 = 0;

      try {
         int var2 = 32;

         while (var2 <= 126) {
            var0[var1++] = var2++;
         }

         for (int var7 = -350585412 ^ -350585571; var7 <= (-262352917 ^ -262353132); var7++) {
            if (var7 != (-482467777 ^ -482467688)) {
               var0[var1++] = var7;
            }
         }

         for (int var5 : g) {
            var0[var1++] = var5;
         }
      } catch (RuntimeException var6) {
         throw var6;
      }

      return Arrays.copyOf(var0, var1);
   }

   public static void b(byte[] var0) throws Exception {

      assert g != null
         && g.length > 10
         && IDX != null
         && IDX.length == (-1817171084 ^ -1817181324)
         && SPACE != null
         && SPACE.length == (-695010146 ^ -695020386)
         && g[0] > 126
         && g[0] < (-73864302 ^ -73874542)
         && g[g.length - 1] > 126
         && g[g.length - 1] < (-1944765042 ^ -1944775282)
         && (Object)IDX != (Object)SPACE
         && g[1] > 126
         && g[2] > 126
         && g[3] > 126
         && g[4] > 126
         && g[5] > 126
         && g[6] > 126
         && g[7] > 126
         && g[8] > 126
         && g[9] > 126
         && g[10] > 126
         && IDX[32] >= -2
         && IDX[65] >= -2
         && IDX[97] >= -2
         && SPACE[32] >= 0.0F
         && SPACE[65] >= 0.0F
         && g[1] < (-1644298313 ^ -1644308553)
         && g[2] < (2079236242 ^ 2079230098)
         && g[3] < (-1337568202 ^ -1337557962)
         && g[4] < (408409150 ^ 408419390)
         && g[5] < (434467837 ^ 434461693) : "ba" + "ke: b" + "ad tables";

      try {
         Font var1 = Font.createFont(0, new ByteArrayInputStream(var0)).deriveFont(48.0F);
         FontRenderContext var2 = new FontRenderContext(null, true, true);
         int[] var3 = a();
         int var4 = var3.length;
         int[] var5 = new int[var4];
         float[] var6 = new float[var4];
         int[] var7 = new int[var4 * 4];
         float[][] var8 = new float[var4][];
         int[] var9 = new int[var4];
         boolean[] var10 = new boolean[var4];
         int var11 = 0;

         for (int var12 = 0; var12 < var4; var12++) {
            int var13 = var3[var12];
            if (var1.canDisplay(var13)) {
               GlyphVector var14 = var1.createGlyphVector(var2, Character.toChars(var13));
               float var15 = var14.getGlyphMetrics(0).getAdvance();
               Shape var16 = var14.getGlyphOutline(0);
               Rectangle2D var17 = var16.getBounds2D();
               if (!var17.isEmpty() && var17.getWidth() > 0.01 && var17.getHeight() > 0.01) {
                  PathIterator var18 = var16.getPathIterator(null, 0.02);
                  var10[var11] = var18.getWindingRule() == 0;
                  var8[var11] = c(var18);
                  var9[var11] = var8[var11].length / 4;
                  var5[var11] = var13;
                  var6[var11] = var15;
                  var7[var11 * 4] = (int)Math.floor(var17.getMinX());
                  var7[var11 * 4 + 1] = (int)Math.floor(var17.getMinY());
                  var7[var11 * 4 + 2] = (int)Math.ceil(var17.getMaxX());
                  var7[var11 * 4 + 3] = (int)Math.ceil(var17.getMaxY());
                  var11++;
               } else {
                  IDX[var13] = -2;
                  SPACE[var13] = var15 * 0.16666667F;
               }
            }
         }

         int[] var36 = new int[var11];
         int var37 = 0;

         while (var37 < var11) {
            var36[var37] = var37++;
         }

         for (int var38 = 1; var38 < var11; var38++) {
            int var40 = var36[var38];
            int var42 = var7[var40 * 4 + 3] - var7[var40 * 4 + 1];

            int var44;
            for (var44 = var38 - 1; var44 >= 0 && var7[var36[var44] * 4 + 3] - var7[var36[var44] * 4 + 1] < var42; var44--) {
               var36[var44 + 1] = var36[var44];
            }

            var36[var44 + 1] = var40;
         }

         int[] var39 = new int[var11];
         int[] var41 = new int[var11];
         int var43 = 0;
         int var45 = 0;
         int var46 = 0;

         for (int var47 = 0; var47 < var11; var47++) {
            int var19 = var36[var47];
            int var20 = var7[var19 * 4 + 2] - var7[var19 * 4] + 44;
            int var21 = var7[var19 * 4 + 3] - var7[var19 * 4 + 1] + 44;
            if (var43 + var20 > (-711568162 ^ -711569186)) {
               var45 += var46;
               var43 = 0;
               var46 = 0;
            }

            var39[var19] = var43;
            var41[var19] = var45;
            var43 += var20;
            var46 = Math.max(var46, var21);
         }

         int var48 = (var45 + var46 + 31) / 32 * 32;
         float[] var49 = new float[(818008181 ^ 818009205) * var48];
         float[] var50 = new float[(-818761032 ^ -818760008) * var48];

         for (int var51 = 0; var51 < var11; var51++) {
            d(
               var8[var51],
               var9[var51],
               var10[var51],
               var7[var51 * 4],
               var7[var51 * 4 + 1],
               var7[var51 * 4 + 2],
               var7[var51 * 4 + 3],
               var39[var51],
               var41[var51],
               var49,
               var50,
               var48
            );
         }

         float[] var52 = new float[var11];
         float[] var22 = new float[var11];
         float[] var23 = new float[var11];
         float[] var24 = new float[var11];
         float[] var25 = new float[var11];
         float[] var26 = new float[var11];
         float[] var27 = new float[var11];
         float[] var28 = new float[var11];
         float[] var29 = new float[var11];

         for (int var30 = 0; var30 < var11; var30++) {
            int var31 = var7[var30 * 4];
            int var32 = var7[var30 * 4 + 1];
            int var33 = var7[var30 * 4 + 2];
            int var34 = var7[var30 * 4 + 3];
            var29[var30] = var6[var30] * 0.16666667F;
            var52[var30] = (float)(var31 - 12) * 0.16666667F;
            var23[var30] = (float)(var33 + 12) * 0.16666667F;
            var22[var30] = 7.0F + (float)(var32 - 12) * 0.16666667F;
            var24[var30] = 7.0F + (float)(var34 + 12) * 0.16666667F;
            var25[var30] = (float)(var39[var30] + 22 - 12) / 1024.0F;
            var27[var30] = (float)(var39[var30] + 22 + (var33 - var31) + 12) / 1024.0F;
            var26[var30] = (float)(var41[var30] + 22 - 12) / (float)var48;
            var28[var30] = (float)(var41[var30] + 22 + (var34 - var32) + 12) / (float)var48;
            IDX[var5[var30]] = (short)var30;
         }

         ADV = var29;
         QX0 = var52;
         QY0 = var22;
         QX1 = var23;
         QY1 = var24;
         U0 = var25;
         V0 = var26;
         U1 = var27;
         V1 = var28;
         AH = var48;
         LV = e(var49, var50, var48);
      } catch (RuntimeException var35) {
         throw var35;
      }
   }

   private static float[] c(PathIterator var0) {

      assert g != null
         && g.length > 10
         && IDX != null
         && IDX.length == (-1968523662 ^ -1968529806)
         && SPACE != null
         && SPACE.length == (-35437864 ^ -35427624)
         && g[0] > 126
         && g[0] < (-1735872280 ^ -1735878424)
         && g[g.length - 1] > 126
         && g[g.length - 1] < (1801151869 ^ 1801145725)
         && (Object)IDX != (Object)SPACE
         && g[1] > 126
         && g[2] > 126
         && g[3] > 126
         && g[4] > 126
         && g[5] > 126
         && g[6] > 126
         && g[7] > 126
         && g[8] > 126
         && g[9] > 126
         && g[10] > 126
         && IDX[32] >= -2
         && IDX[65] >= -2
         && IDX[97] >= -2
         && SPACE[32] >= 0.0F
         && SPACE[65] >= 0.0F
         && g[1] < (-2042655394 ^ -2042649250)
         && g[2] < (327186932 ^ 327176692)
         && g[3] < (-439941877 ^ -439931637)
         && g[4] < (-293665507 ^ -293655267)
         && g[5] < (688756931 ^ 688763075) : "flatten: bad tables";

      float[] var1 = new float[256];
      int var2 = 0;

      try {
         float[] var3 = new float[6];
         float var4 = 0.0F;
         float var5 = 0.0F;
         float var6 = 0.0F;
         float var7 = 0.0F;
         boolean var8 = false;

         while (!var0.isDone()) {
            int var9 = var0.currentSegment(var3);
            boolean var12 = false;
            float var10;
            float var11;
            if (var9 == 0) {
               if (var8 && (var6 != var4 || var7 != var5)) {
                  if (var2 + 4 > var1.length) {
                     var1 = Arrays.copyOf(var1, var1.length * 2);
                  }

                  var1[var2++] = var6;
                  var1[var2++] = var7;
                  var1[var2++] = var4;
                  var1[var2++] = var5;
               }

               var4 = var3[0];
               var5 = var3[1];
               var10 = var4;
               var11 = var5;
               var8 = true;
            } else if (var9 == 4) {
               var10 = var4;
               var11 = var5;
               var12 = var6 != var4 || var7 != var5;
               var8 = false;
            } else {
               var10 = var3[0];
               var11 = var3[1];
               var12 = true;
            }

            if (var12) {
               if (var2 + 4 > var1.length) {
                  var1 = Arrays.copyOf(var1, var1.length * 2);
               }

               var1[var2++] = var6;
               var1[var2++] = var7;
               var1[var2++] = var10;
               var1[var2++] = var11;
            }

            var6 = var10;
            var7 = var11;
            var0.next();
         }

         if (var8 && (var6 != var4 || var7 != var5)) {
            if (var2 + 4 > var1.length) {
               var1 = Arrays.copyOf(var1, var1.length * 2);
            }

            var1[var2++] = var6;
            var1[var2++] = var7;
            var1[var2++] = var4;
            var1[var2++] = var5;
         }
      } catch (RuntimeException var13) {
         throw var13;
      }

      return Arrays.copyOf(var1, var2);
   }

   private static void d(
      float[] var0, int var1, boolean var2, int var3, int var4, int var5, int var6, int var7, int var8, float[] var9, float[] var10, int var11
   ) {

      assert var0 != null
         && var9 != null
         && var10 != null
         && var1 >= 0
         && var0.length >= var1 * 4
         && var5 > var3
         && var6 > var4
         && var7 >= 0
         && var8 >= 0
         && var7 + (var5 - var3) + 44 <= (1533756854 ^ 1533755830)
         && var8 + (var6 - var4) + 44 <= var11
         && var9.length == (-2097541612 ^ -2097542636) * var11
         && var10.length == (2066575053 ^ 2066574029) * var11
         && var9 != var10
         && var11 > 0
         && (var11 & 31) == 0
         && var1 < (1366694349 ^ 1365645773) : "s" + "d" + "fCe" + "ll: bad cell";

      try {
         int var12 = var5 - var3 + 44;
         int var13 = var6 - var4 + 44;
         float var14 = (float)(var3 - 22);
         float var15 = (float)(var4 - 22);
         float var16 = 256.0F;
         float[] var17 = new float[var12 * var13];
         Arrays.fill(var17, var16);

         for (int var18 = 0; var18 < var1; var18++) {
            float var19 = var0[var18 * 4];
            float var20 = var0[var18 * 4 + 1];
            float var21 = var0[var18 * 4 + 2];
            float var22 = var0[var18 * 4 + 3];
            float var23 = var21 - var19;
            float var24 = var22 - var20;
            float var25 = var23 * var23 + var24 * var24;
            float var26 = var25 > 1.0E-12F ? 1.0F / var25 : 0.0F;
            int var27 = (int)Math.floor((double)(Math.min(var19, var21) - 16.0F - var14 - 0.5F));
            int var28 = (int)Math.ceil((double)(Math.max(var19, var21) + 16.0F - var14 - 0.5F));
            int var29 = (int)Math.floor((double)(Math.min(var20, var22) - 16.0F - var15 - 0.5F));
            int var30 = (int)Math.ceil((double)(Math.max(var20, var22) + 16.0F - var15 - 0.5F));
            var27 = var27 < 0 ? 0 : var27;
            var29 = var29 < 0 ? 0 : var29;
            var28 = var28 > var12 - 1 ? var12 - 1 : var28;
            var30 = var30 > var13 - 1 ? var13 - 1 : var30;

            for (int var31 = var29; var31 <= var30; var31++) {
               float var32 = var15 + (float)var31 + 0.5F;
               float var33 = var32 - var20;
               int var34 = var31 * var12;

               for (int var35 = var27; var35 <= var28; var35++) {
                  float var36 = var14 + (float)var35 + 0.5F - var19;
                  float var37 = (var36 * var23 + var33 * var24) * var26;
                  var37 = var37 < 0.0F ? 0.0F : (var37 > 1.0F ? 1.0F : var37);
                  float var38 = var36 - var37 * var23;
                  float var39 = var33 - var37 * var24;
                  float var40 = var38 * var38 + var39 * var39;
                  if (var40 < var17[var34 + var35]) {
                     var17[var34 + var35] = var40;
                  }
               }
            }
         }

         float[] var42 = new float[Math.max(4, var1)];
         int[] var43 = new int[Math.max(4, var1)];

         for (int var44 = 0; var44 < var13; var44++) {
            float var45 = var15 + (float)var44 + 0.5F;
            int var46 = 0;

            for (int var47 = 0; var47 < var1; var47++) {
               float var49 = var0[var47 * 4 + 1];
               float var51 = var0[var47 * 4 + 3];
               if (var49 <= var45 && var45 < var51 || var51 <= var45 && var45 < var49) {
                  float var53 = var0[var47 * 4];
                  float var56 = var0[var47 * 4 + 2];
                  float var59 = var53 + (var45 - var49) * (var56 - var53) / (var51 - var49);
                  int var62 = var51 > var49 ? 1 : -1;

                  int var65;
                  for (var65 = var46 - 1; var65 >= 0 && var42[var65] > var59; var65--) {
                     var42[var65 + 1] = var42[var65];
                     var43[var65 + 1] = var43[var65];
                  }

                  var42[var65 + 1] = var59;
                  var43[var65 + 1] = var62;
                  var46++;
               }
            }

            int var48 = 0;
            int var50 = 0;
            int var52 = var44 * var12;
            int var54 = (var8 + var44) * (1406761732 ^ 1406762756) + var7;

            for (int var57 = 0; var57 < var12; var57++) {
               float var60 = var14 + (float)var57 + 0.5F;

               while (var50 < var46 && var42[var50] <= var60) {
                  var48 += var43[var50++];
               }

               boolean var63 = var2 ? (var48 & 1) != 0 : var48 != 0;
               float var66 = (float)Math.sqrt((double)var17[var52 + var57]);
               var66 = var63 ? var66 : -var66;
               float var68 = var66 / 32.0F + 0.5F;
               var9[var54 + var57] = var68 < 0.0F ? 0.0F : (var68 > 1.0F ? 1.0F : var68);
               float var69 = var66 + 0.5F;
               var10[var54 + var57] = var69 < 0.0F ? 0.0F : (var69 > 1.0F ? 1.0F : var69);
            }
         }
      } catch (RuntimeException var41) {
         throw var41;
      }
   }

   private static int[][] e(float[] var0, float[] var1, int var2) {

      assert var0 != null
         && var1 != null
         && var0.length == (-1014109809 ^ -1014108785) * var2
         && var1.length == (1807601550 ^ 1807600526) * var2
         && var2 > 0
         && (var2 & 31) == 0
         && var0 != var1
         && IDX.length == (1539947803 ^ 1539937563)
         && SPACE.length == (-1127855092 ^ -1127848948)
         && g.length > 10
         && var2 >= 32
         && var0[0] >= 0.0F
         && var1[0] >= 0.0F
         && var0[var0.length - 1] >= 0.0F
         && var1[var1.length - 1] >= 0.0F
         && g[1] > 126
         && g[2] > 126
         && g[3] > 126
         && g[4] > 126
         && g[5] > 126
         && g[6] > 126
         && g[7] > 126
         && g[8] > 126
         && IDX[32] >= -2
         && IDX[65] >= -2
         && SPACE[32] >= 0.0F
         && SPACE[65] >= 0.0F : "l" + "evels: bad" + " atlas";

      int[][] var3 = new int[5][];

      try {
         float[] var4 = var0;
         float[] var5 = var1;
         int var6 = -2146554115 ^ -2146555139;
         int var7 = var2;

         for (int var8 = 0; var8 < 5; var8++) {
            if (var8 > 0) {
               int var9 = var6 >> 1;
               int var10 = var7 >> 1;
               float[] var11 = new float[var9 * var10];
               float[] var12 = new float[var9 * var10];

               for (int var13 = 0; var13 < var10; var13++) {
                  int var14 = var13 * 2 * var6;
                  int var15 = var14 + var6;
                  int var16 = var13 * var9;

                  for (int var17 = 0; var17 < var9; var17++) {
                     int var18 = var14 + var17 * 2;
                     int var19 = var15 + var17 * 2;
                     var11[var16 + var17] = 0.25F * (var4[var18] + var4[var18 + 1] + var4[var19] + var4[var19 + 1]);
                     var12[var16 + var17] = 0.25F * (var5[var18] + var5[var18 + 1] + var5[var19] + var5[var19 + 1]);
                  }
               }

               var4 = var11;
               var5 = var12;
               var6 = var9;
               var7 = var10;
            }

            int[] var21 = new int[var6 * var7];
            int var22 = 0;

            for (int var23 = var6 * var7; var22 < var23; var22++) {
               int var24 = (int)(var4[var22] * 65535.0F + 0.5F);
               var24 = var24 < 0 ? 0 : (var24 > (1175206299 ^ 1175242340) ? -1813737838 ^ -1813745299 : var24);
               int var26 = (int)(var5[var22] * 255.0F + 0.5F);
               var26 = var26 < 0 ? 0 : (var26 > (1441116256 ^ 1441116319) ? -319816160 ^ -319815969 : var26);
               var21[var22] = var26 << 24 | var24 >>> 8 << 16 | (var24 & (-701621363 ^ -701621390)) << 8;
            }

            var3[var8] = var21;
         }

         return var3;
      } catch (RuntimeException var20) {
         throw var20;
      }
   }

   public static int f(
      String var0,
      char[] var1,
      int var2,
      float var3,
      float var4,
      int var5,
      int var6,
      float var7,
      float var8,
      float[] var9,
      float[] var10,
      boolean var11,
      float[] var12,
      float[] var13,
      float[] var14,
      float[] var15,
      float[] var16,
      int[] var17,
      int var18,
      float[] var19,
      float[] var20
   ) {

      assert (var0 != null || var1 != null)
         && var9 != null
         && var9.length >= (-619746938 ^ -619757178)
         && var10 != null
         && var10.length >= 19
         && var12 != null
         && var13 != null
         && var14 != null
         && var15 != null
         && var16 != null
         && var17 != null
         && var19 != null
         && var19.length >= 4
         && var12.length == var13.length
         && var12.length == var14.length
         && var12.length == var15.length
         && var12.length == var16.length
         && var12.length == var17.length
         && var18 >= 0
         && var18 <= var12.length
         && IDX.length == (1150876626 ^ 1150866386)
         && ADV != null
         && QX0 != null
         && U0 != null
         && V1 != null
         && !Float.isNaN(var3)
         && !Float.isNaN(var4)
         && !Float.isNaN(var7)
         && !Float.isNaN(var8)
         && (var20 == null || var20.length >= 4) : "emit: bad call";

      try {
         int var22 = var0 != null ? var0.length() : var1.length;
         boolean var23 = false;
         if (var0 == null && var22 > 1) {
            char var24 = (char)(var1[1] ^ var2 + 31);
            if (var24 >= (-1969068290 ^ -1969055233) && var24 <= (-516161453 ^ -516096243)) {
               var24 = (char)(var24 - (-1810200827 ^ -1810204187));
            }

            var23 = var24 == '.';
         }

         float var83 = 0.0F;
         float var25 = 0.0F;
         int var26 = 0;

         for (int var27 = 0; var27 < var22; var27++) {
            if (!var23 || var27 != 1) {
               char var28 = var0 != null ? var0.charAt(var27) : (char)(var1[var27] ^ var2 + var27 * 31);
               if (var0 == null && var28 >= (-487444186 ^ -487403993) && var28 <= (1411338808 ^ 1411362150)) {
                  var28 = (char)(var28 - (-1768423804 ^ -1768488860));
               }

               if (var28 >= (914707436 ^ 914717676)) {
                  return -1;
               }

               short var29 = IDX[var28];
               if (var29 == -1) {
                  return -1;
               }

               float var30 = var9[var28];
               if (var30 != var30) {
                  return -2 - var28;
               }

               var83 += var30;
               if (var29 >= 0) {
                  var25 += ADV[var29];
                  var26++;
               } else {
                  var25 += SPACE[var28];
               }
            }
         }

         if (var26 == 0) {
            return var18;
         } else if (var18 + 8 * var26 > var12.length) {
            return -1;
         } else {
            float var84 = var25 > 1.0E-4F ? var83 / var25 : 1.0F;
            float var85 = var10[0];
            float var86 = var10[1];
            float var87 = var10[2];
            float var31 = var10[3];
            float var32 = var10[4];
            float var33 = var10[5];
            boolean var34 = var20 != null;
            float var35 = 0.0F;
            float var36 = 0.0F;
            float var37 = 0.0F;
            float var38 = 0.0F;
            if (var34) {
               if (var86 != 0.0F || var87 != 0.0F || var85 == 0.0F || var31 == 0.0F) {
                  return -3;
               }

               float var39 = (var20[0] - var32) / var85;
               float var40 = (var20[2] - var32) / var85;
               float var41 = (var20[1] - var33) / var31;
               float var42 = (var20[3] - var33) / var31;
               var35 = Math.min(var39, var40);
               var36 = Math.max(var39, var40);
               var37 = Math.min(var41, var42);
               var38 = Math.max(var41, var42);
            }

            float var88 = var10[6];
            float var89 = var10[7];
            float var90 = var10[8];
            float var91 = var10[9];
            float var43 = var10[10];
            float var44 = var10[11];
            float var45 = var10[12];
            float var46 = var10[13];
            float var47 = var10[14];
            float var48 = var10[15];
            float var49 = var10[16];
            float var50 = var10[17];
            float var51 = var10[18];
            float var52 = var19[0];
            float var53 = var19[1];
            float var54 = var19[2];
            float var55 = var19[3];
            float var56 = 0.0F;
            int var57 = 0;
            int var58 = var18;
            int var59 = var18 + 4 * var26;

            for (int var60 = 0; var60 < var22; var60++) {
               if (!var23 || var60 != 1) {
                  char var61 = var0 != null ? var0.charAt(var60) : (char)(var1[var60] ^ var2 + var60 * 31);
                  if (var0 == null && var61 >= (-1150264489 ^ -1150245802) && var61 <= (1095467083 ^ 1095466773)) {
                     var61 = (char)(var61 - (275982334 ^ 276027678));
                  }

                  short var62 = IDX[var61];
                  if (var62 < 0) {
                     var56 += SPACE[var61];
                  } else {
                     float var63 = var3 + var56 * var84;
                     var56 += ADV[var62];
                     float var64 = var63 + QX0[var62];
                     float var65 = var63 + QX1[var62];
                     float var66 = var4 + QY0[var62];
                     float var67 = var4 + QY1[var62];
                     float var68 = U0[var62];
                     float var69 = U1[var62];
                     float var70 = V0[var62];
                     float var71 = V1[var62];
                     if (var34) {
                        float var72 = var64 > var35 ? var64 : var35;
                        float var73 = var65 < var36 ? var65 : var36;
                        float var74 = var66 > var37 ? var66 : var37;
                        float var75 = var67 < var38 ? var67 : var38;
                        if (!(var72 < var73) || !(var74 < var75)) {
                           continue;
                        }

                        float var76 = (var69 - var68) / (var65 - var64);
                        float var77 = (var71 - var70) / (var67 - var66);
                        float var78 = var68 + (var72 - var64) * var76;
                        float var79 = var68 + (var73 - var64) * var76;
                        float var80 = var70 + (var74 - var66) * var77;
                        float var81 = var70 + (var75 - var66) * var77;
                        var64 = var72;
                        var65 = var73;
                        var66 = var74;
                        var67 = var75;
                        var68 = var78;
                        var69 = var79;
                        var70 = var80;
                        var71 = var81;
                     }

                     var57++;

                     for (int var95 = 0; var95 < 4; var95++) {
                        float var96 = var95 < 2 ? var64 : var65;
                        float var97 = var95 != 0 && var95 != 3 ? var67 : var66;
                        float var98 = var85 * var96 + var87 * var97 + var32;
                        float var99 = var86 * var96 + var31 * var97 + var33;
                        float var100;
                        float var101;
                        float var102;
                        if (var11) {
                           float var103 = var45 + var98 * var46 + var99 * var47;
                           var103 = var103 > 0.04F ? var103 : 0.04F;
                           var100 = var50 + (var88 + var98 * var89 + var99 * var90) / var103 * var48;
                           var101 = var51 - (var91 + var98 * var43 + var99 * var44) / var103 * var49;
                           var102 = var103;
                        } else {
                           var100 = var98;
                           var101 = var99;
                           var102 = 1.0F;
                        }

                        float var105 = var95 < 2 ? var68 : var69;
                        float var106 = var95 != 0 && var95 != 3 ? var71 : var70;
                        var12[var59] = var100;
                        var13[var59] = var101;
                        var14[var59] = var102;
                        var15[var59] = var105;
                        var16[var59] = var106;
                        var17[var59++] = var5;
                        var12[var58] = var100 + var7;
                        var13[var58] = var101 + var8;
                        var14[var58] = var102;
                        var15[var58] = var105 + 2.0F;
                        var16[var58] = var106;
                        var17[var58++] = var6;
                        var52 = var100 < var52 ? var100 : var52;
                        var53 = var101 < var53 ? var101 : var53;
                        var54 = var100 + var7 > var54 ? var100 + var7 : var54;
                        var55 = var101 + var8 > var55 ? var101 + var8 : var55;
                     }
                  }
               }
            }

            var19[0] = var52;
            var19[1] = var53;
            var19[2] = var54;
            var19[3] = var55;
            if (var57 < var26) {
               int var92 = var18 + 4 * var26;
               int var93 = var18 + 4 * var57;
               int var94 = 4 * var57;
               System.arraycopy(var12, var92, var12, var93, var94);
               System.arraycopy(var13, var92, var13, var93, var94);
               System.arraycopy(var14, var92, var14, var93, var94);
               System.arraycopy(var15, var92, var15, var93, var94);
               System.arraycopy(var16, var92, var16, var93, var94);
               System.arraycopy(var17, var92, var17, var93, var94);
            }

            return var18 + 8 * var57;
         }
      } catch (RuntimeException var82) {
         throw var82;
      }
   }

   static {
      Arrays.fill(IDX, (short)-1);
   }
}
