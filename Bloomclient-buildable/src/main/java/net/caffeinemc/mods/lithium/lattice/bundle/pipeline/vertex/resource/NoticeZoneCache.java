package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.StyleKeyCache;
import net.minecraft.text.Text;
import net.minecraft.text.Style;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.OrderedText;
import org.joml.Matrix3x2fStack;

public final class NoticeZoneCache {
   private static final float f = 20.0F;
   private static final float g = 8.0F;
   private static final float h = 8.5F;
   private static final float i = 5.0F;
   private static final float j = 10.0F;
   private static final float k = 20.5F;
   private static final float l = 37.0F;
   private static final float m = 4.0F;
   private static final float n = 9.0F;
   private static final float o = 13.1F;
   private static final float p = 24.0F;
   private static final float q = 0.26F;
   private static final float r = 1.5F;
   private static final float s = 0.2F;
   private static final float t = 1.76F;
   private static final float u = 1.96F;
   private static final long v = 1500000000L;
   private static final long w = 250000000L;
   private static final int x = 6;
   private static final int y = 3;
   private static final String[] z = new String[]{"Enabled", "Disabled", "Aura"};
   private static final int aa = 0;
   private static final int ab = 1;
   private static final int ac = 2;
   private static final BuilderFactory[] ad = new BuilderFactory[6];
   private static final boolean[] ae = new boolean[6];
   private static final boolean[] af = new boolean[6];
   private static final boolean[] ag = new boolean[6];
   private static final boolean[] ah = new boolean[6];
   private static final long[] ai = new long[6];
   private static final int[] aj = new int[6];
   private static final int[] ak = new int[6];
   private static final int[] al = new int[6];
   private static final float[] am = new float[6];
   private static final float[] an = new float[6];
   private static final float[] ao = new float[6];
   private static final float[] ap = new float[6];
   private static final float[] aq = new float[6];
   private static final OrderedText[] ar = new OrderedText[6];
   private static int as = 0;
   static boolean at = false;
   private static long au = 0L;
   private static int av = 0;
   private static final Text[] aw = new Text[3];
   private static final float[] ax = new float[3];
   private static OrderedText ay;
   private static int az = Integer.MIN_VALUE;
   private static int ba = Integer.MIN_VALUE;
   private static int bb = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   private NoticeZoneCache() {
   }

   static void a(DrawContext var0, CoreZoneProcessor var1, int var2, int var3, boolean var4) {

      int[] var5 = var1.ew[8];
      float var6 = var1.fc[8];
      if ((var4 || at) && !(var6 < 0.02F)) {
         int var7 = 1;
         float var8 = var1.dn;
         if (!var4) {
            long var9 = System.nanoTime();
            long var11 = au == 0L ? 0L : var9 - au;
            au = var9;
            if (var1.fa[8]) {
               var7 = b(var9, var11 > 250000000L ? (float)var11 / 1.0E9F : var8);
               av = var7;
            } else {
               var7 = av;
            }

            if (var7 == 0) {
               var5[2] = 0;
               return;
            }
         }

         float var45 = (1.0F - var6) * 4.0F;
         if (az != StyleKeyCache.bb || ba != StyleKeyCache.ba) {
            c();
         }

         double var10 = var1.dc.p();
         double var12 = var1.dd.p();
         float var14 = (float)(var10 / 100.0 * (double)var2);
         int var15 = Math.max(2, Math.min(Math.max(2, var3 - 20 - 2), (int)(var12 / 100.0 * (double)var3)));
         float var16 = (float)StyleKeyCache.MAG;
         var5[2] = 0;
         float var17 = 1.0F - (float)Math.exp((double)(-var8 * 13.0F));
         float var18 = 1.0F - (float)Math.exp((double)(-var8 * 18.0F));
         float var19 = var12 >= 50.0 ? -1.0F : 1.0F;
         int var20 = StyleKeyCache.PANEL;
         int var21 = -42237759 ^ 49614418;
         int var22 = StyleKeyCache.A;
         Matrix3x2fStack var23 = var0.getMatrices();
         var0.createNewRootLayer();

         for (int var24 = var7 - 1; var24 >= 0; var24--) {
            Text var25;
            OrderedText var26;
            float var27;
            float var28;
            float var29;
            float var30;
            float var31;
            float var32;
            float var33;
            if (var4) {
               var25 = aw[0];
               var26 = ay;
               var27 = ax[0];
               var28 = 37.0F + var27 + 4.0F + ax[2] + 9.0F;
               var29 = 0.0F;
               var30 = 1.0F;
               var31 = 1.0F;
               var32 = 1.0F;
               var33 = 0.0F;
            } else {
               int var34 = 0;

               while (var34 < 6 && (ad[var34] == null || !af[var34] || ak[var34] != var24)) {
                  var34++;
               }

               if (var34 == 6) {
                  continue;
               }

               if (al[var34] != StyleKeyCache.ba) {
                  aq[var34] = StyleKeyCache.h(ar[var34]);
                  al[var34] = StyleKeyCache.ba;
               }

               int var35 = ae[var34] ? 0 : 1;
               var25 = aw[var35];
               var26 = ar[var34];
               var27 = ax[var35];
               float var36 = 37.0F + var27 + 4.0F + aq[var34] + 9.0F;
               float var46 = ao[var34];
               var28 = !(var46 < 0.0F) && !(Math.abs(var36 - var46) < 0.01F) ? var46 + (var36 - var46) * var17 : var36;
               ao[var34] = var28;
               float var37 = (float)var24 * 24.0F;
               float var47 = an[var34];
               var29 = Math.abs(var37 - var47) < 0.01F ? var37 : var47 + (var37 - var47) * var17;
               an[var34] = var29;
               float var38 = ae[var34] ? 1.0F : 0.0F;
               float var48 = ap[var34];
               var30 = Math.abs(var38 - var48) < 0.004F ? var38 : var48 + (var38 - var48) * var18;
               ap[var34] = var30;
               float var39 = am[var34];
               if (var39 < 0.26F) {
                  float var40 = var39 / 0.26F - 1.0F;
                  float var41 = 1.0F + 2.70158F * var40 * var40 * var40 + 1.70158F * var40 * var40;
                  var31 = var41 > 1.0F ? 1.0F : var41;
                  var32 = 0.9F + 0.1F * var41;
                  var33 = 6.0F * (1.0F - var41);
               } else if (var39 < 1.76F) {
                  var31 = 1.0F;
                  var32 = 1.0F;
                  var33 = 0.0F;
               } else {
                  float var58 = Math.min(1.0F, (var39 - 1.76F) / 0.2F);
                  var58 = var58 * var58 * (3.0F - 2.0F * var58);
                  var31 = 1.0F - var58;
                  var32 = 1.0F - 0.04F * var58;
                  var33 = 0.0F;
               }
            }

            var31 *= var6;
            var33 += var45;
            float var51 = (float)Math.round(Math.max(2.0F, Math.min((float)var2 - var28 - 2.0F, var14 - var28 * 0.5F)) * var16) / var16;
            if (var24 == 0) {
               int var52 = (int)Math.floor((double)var51);
               var5[0] = var52;
               var5[1] = var15;
               var5[2] = (int)Math.ceil((double)(var51 + var28)) - var52;
               var5[3] = 20;
            }

            int var53 = (int)(var31 * 255.0F + 0.5F);
            if (var53 >= 5) {
               int var54 = ((var20 >>> 24) * var53 + 127) / (36757834 ^ 36757941);
               int var55 = var53 << 24
                  | (int)(
                        (float)(var21 >> 16 & (-452190627 ^ -452190558))
                           + (float)((var22 >> 16 & (1349375792 ^ 1349375951)) - (var21 >> 16 & (1300492279 ^ 1300492040))) * var30
                           + 0.5F
                     )
                     << 16
                  | (int)(
                        (float)(var21 >> 8 & (-565889376 ^ -565889441))
                           + (float)((var22 >> 8 & (-809449996 ^ -809450229)) - (var21 >> 8 & (801534983 ^ 801535224))) * var30
                           + 0.5F
                     )
                     << 8
                  | (int)(
                     (float)(var21 & (1028123416 ^ 1028123623))
                        + (float)((var22 & (-261224588 ^ -261224565)) - (var21 & (-1976012160 ^ -1976012161))) * var30
                        + 0.5F
                  );
               int var56 = var53 << 24;
               var23.pushMatrix();

               try {
                  var23.translate(var51, (float)Math.round(((float)var15 + var19 * var29 + var33) * var16) / var16);
                  if (var32 != 1.0F) {
                     float var57 = var28 * 0.5F;
                     var23.translate(var57, 10.0F);
                     var23.scale(var32, var32);
                     var23.translate(-var57, -10.0F);
                  }

                  StyleKeyCache.r(var0, 0.0F, 0.0F, var28, 20.0F, 8.0F, var54 << 24 | var20 & (-1848582407 ^ -1859182330));
                  StyleKeyCache.ab(var0, 4, 8.5F, 5.0F, 10.0F, var55);
                  StyleKeyCache.ab(var0, 11, 20.5F, 5.0F, 10.0F, var56 | 1200793322 ^ 1207487642);
                  StyleKeyCache.i(var0, var25, 37.0F, 13.1F, var56 | 1039100780 ^ 1025154715, false);
                  StyleKeyCache.j(var0, var26, 37.0F + var27 + 4.0F, 13.1F, var55, false);
               } finally {
                  var23.popMatrix();
               }
            }
         }
      } else {
         var5[2] = 0;
      }
   }

   private static int b(long var0, float var2) {

      for (int var3 = 0; var3 < 6; var3++) {
         if (ad[var3] != null) {
            if (!af[var3]) {
               if (var0 - ai[var3] > 1500000000L) {
                  ad[var3] = null;
               }
            } else if (ag[var3]) {
               float var4 = am[var3] - var2;
               if (var4 <= 1.76F) {
                  var4 = 0.26F + (1.76F - var4);
                  ag[var3] = false;
                  if (var4 >= 1.96F) {
                     ad[var3] = null;
                  }
               }

               am[var3] = var4;
            } else {
               float var9 = am[var3] + var2;
               am[var3] = var9;
               if (var9 >= 1.96F) {
                  ad[var3] = null;
               }
            }
         }
      }

      int var8 = 0;

      for (int var10 = 0; var10 < 2; var10++) {
         var8 = 0;

         for (int var5 = 0; var5 < 6; var5++) {
            if (ad[var5] != null) {
               int var6 = 0;

               for (int var7 = 0; var7 < 6; var7++) {
                  if (ad[var7] != null && aj[var7] - aj[var5] > 0) {
                     var6++;
                  }
               }

               ak[var5] = var6;
               var8++;
            }
         }

         boolean var12 = false;

         for (int var13 = 0; var13 < 6; var13++) {
            if (ad[var13] != null && ak[var13] >= 3) {
               if (!af[var13]) {
                  ad[var13] = null;
                  var12 = true;
               } else if (!ah[var13] && am[var13] >= 0.26F) {
                  ah[var13] = true;
                  ag[var13] = false;
                  if (am[var13] < 1.76F) {
                     am[var13] = 1.76F;
                  }
               }
            }
         }

         if (!var12) {
            break;
         }
      }

      for (int var11 = 0; var11 < 6; var11++) {
         if (ad[var11] != null && !af[var11]) {
            af[var11] = true;
            am[var11] = 0.0F;
            an[var11] = (float)ak[var11] * 24.0F;
            ao[var11] = -1.0F;
         }
      }

      at = var8 > 0;
      return var8;
   }

   private static void c() {

      if (az != StyleKeyCache.bb) {
         aw[0] = StyleKeyCache.txt(8, z[0]);
         aw[1] = StyleKeyCache.txt(8, z[1]);
         aw[2] = StyleKeyCache.txt(8, z[2]);
         ay = aw[2].asOrderedText();
         az = StyleKeyCache.bb;
      }

      if (ba != StyleKeyCache.ba) {
         ax[0] = StyleKeyCache.f(8, z[0]);
         ax[1] = StyleKeyCache.f(8, z[1]);
         ax[2] = StyleKeyCache.f(8, z[2]);
         ba = StyleKeyCache.ba;
      }
   }

   public static void d(BuilderFactory var0, boolean var1) {

      if (var0 != null) {
         try {
            long var2 = System.nanoTime();
            int var4 = -1;
            int var5 = -1;

            for (int var6 = 0; var6 < 6; var6++) {
               if (ad[var6] == null) {
                  if (var4 < 0) {
                     var4 = var6;
                  }
               } else {
                  if (ad[var6] == var0 && !ah[var6]) {
                     int var7 = 0;

                     for (int var8 = 0; var8 < 6; var8++) {
                        if (ad[var8] != null && aj[var8] - aj[var6] > 0) {
                           var7++;
                        }
                     }

                     if (var7 < 3) {
                        ae[var6] = var1;
                        if (!af[var6]) {
                           ai[var6] = var2;
                           ap[var6] = var1 ? 1.0F : 0.0F;
                        } else if (ag[var6] || am[var6] >= 1.76F) {
                           ag[var6] = true;
                        } else if (am[var6] > 0.26F) {
                           am[var6] = 0.26F;
                        }

                        at = true;
                        return;
                     }

                     if (!af[var6]) {
                        ad[var6] = null;
                        if (var4 < 0) {
                           var4 = var6;
                        }
                        continue;
                     }

                     if (am[var6] >= 0.26F) {
                        ah[var6] = true;
                        ag[var6] = false;
                        if (am[var6] < 1.76F) {
                           am[var6] = 1.76F;
                        }
                     }
                  }

                  if (var5 < 0 || aj[var6] - aj[var5] < 0) {
                     var5 = var6;
                  }
               }
            }

            int var10 = var4 >= 0 ? var4 : var5;
            ad[var10] = var0;
            ae[var10] = var1;
            af[var10] = false;
            ag[var10] = false;
            ah[var10] = false;
            ai[var10] = var2;
            aj[var10] = ++as;
            am[var10] = 0.0F;
            an[var10] = 0.0F;
            ao[var10] = -1.0F;
            ap[var10] = var1 ? 1.0F : 0.0F;
            al[var10] = Integer.MIN_VALUE;
            at = true;
         } catch (Throwable var9) {
         }
      }
   }

   static {
      for (int var0 = 0; var0 < 6; var0++) {
         int var1 = var0;
         ar[var0] = var1x -> {

            BuilderFactory var2 = ad[var1];
            if (var2 == null) {
               return true;
            } else {
               char[] var3 = var2.c;
               int var4 = var2.cK;
               if (var3 == null) {
                  return true;
               } else {
                  Style var5 = StyleKeyCache.ST[8];
                  int var6 = var3.length;
                  boolean var7 = false;
                  if (var6 > 1) {
                     char var8 = (char)(var3[1] ^ var4 + 31);
                     var7 = var8 == '.' || var8 == (-1193882426 ^ -1193921592);
                  }

                  int var11 = 0;

                  for (int var9 = 0; var11 < var6; var11++) {
                     if (!var7 || var11 != 1) {
                        char var10 = (char)(var3[var11] ^ var4 + var11 * 31);
                        if (var10 >= (1559403264 ^ 1559389185) && var10 <= (-1012350511 ^ -1012384113)) {
                           var10 = (char)(var10 - (-1778360117 ^ -1778344405));
                        }

                        if (!var1x.accept(var9++, var5, var10)) {
                           return false;
                        }
                     }
                  }

                  return true;
               }
            }
         };
      }
   }
}
