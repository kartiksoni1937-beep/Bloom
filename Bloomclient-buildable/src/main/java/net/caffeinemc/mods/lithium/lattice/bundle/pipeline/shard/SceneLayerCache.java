package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import java.util.Random;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.util.Identifier;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.math.MathHelper;
import org.joml.Matrix3x2fStack;

public final class SceneLayerCache {
   public static final Identifier ART = Identifier.of("lithium", "lq" + "_br" + "anch");
   private static final float m = (float) Math.PI;
   private static final float n = (float) (Math.PI * 2);
   private static final float o = 0.3F;
   private static final float p = 0.746F;
   private static final float q = 0.62F;
   private static final int r = 1024;
   private static final int s = 2048;
   private static final Random u = new Random();
   private static boolean v = false;
   private static int w = -1;
   private static int x = -1;
   private static float y = 1.0F;
   private static float z;
   private static long aa = 0L;
   private static float ab = 0.0F;
   private static float ac = 16.0F;
   private static final float[] ad = new float[3];
   private static final float[] ae = new float[3];
   private static final float[] af = new float[3];
   private static final float[] ag = new float[3];
   private static final float[] ah = new float[3];
   private static float ai = 3.0F;
   private static final float[] aj = new float[17];
   private static float ak = 0.0F;
   private static float al = 0.0F;
   private static final int am = 220;
   private static int an = 0;
   private static boolean ao = false;
   private static final int[] ap = new int[220];
   private static final int[] aq = new int[220];
   private static final float[] ar = new float[220];
   private static final float[] as = new float[220];
   private static final int at = 420;
   private static final float[] au = new float[]{0.5F, 1.0F, 1.8F};
   private static int av = 0;
   private static final int[] aw = new int[420];
   private static final int[] ax = new int[420];
   private static final int[] ay = new int[420];
   private static final float[] az = new float[420];
   private static final float[] ba = new float[420];
   private static final float[] bb = new float[420];
   private static final float[] bc = new float[420];
   private static final float[] bd = new float[420];
   private static final float[] be = new float[420];
   private static final float[] bf = new float[420];
   private static final float[] bg = new float[420];
   private static final float[] bh = new float[420];
   private static final float[] bi = new float[420];
   private static final float[] bj = new float[420];
   private static final float[] bk = new float[420];
   private static final float[] bl = new float[420];
   private static final float[] bm = new float[420];

   private static float a() {

      int var0 = SyncController.l;
      return au[var0 <= 0 ? 0 : (var0 >= 2 ? 2 : 1)];
   }

   private SceneLayerCache() {
   }

   public static void b() {

      v = true;
      ao = false;
   }

   public static void c(DrawContext var0, int var1, int var2, float var3, int var4, int var5, long var6) {

      if (v && var1 > 0 && var2 > 0) {
         float var8 = aa == 0L ? 0.0F : (float)(var6 - aa) / 1.0E9F;
         aa = var6;
         if (var8 < 0.0F) {
            var8 = 0.0F;
         }

         if (var8 > 0.1F) {
            var8 = var8 > 0.5F ? 0.016F : 0.1F;
         }

         ab += var8;
         if (var1 != w || var2 != x) {
            f(var1, var2);
         }

         if (!ao) {
            g(var1, var2);
         }

         j(var8, var1);
         k(var8, var1, var2);
         l(var0, var1, var2, var3);
      }
   }

   public static boolean d() {
      return v;
   }

   public static boolean e(DrawContext var0, float var1, float var2, float var3, float var4, float var5, int var6, int var7) {

      if (v && !(var3 <= 0.0F)) {
         int var8 = (var6 & 3) * 5;
         float var9 = var3 * var5;
         int var10;
         int var11;
         int var12;
         if (var9 >= 64.0F) {
            var10 = -1006708357 ^ -1006708229;
            var11 = (var8 & 7) << 7;
            var12 = (2075374442 ^ 2075375466) + (var8 >> 3 << 7);
         } else if (var9 >= 32.0F) {
            var10 = 64;
            var11 = (var8 & 15) << 6;
            var12 = (373113060 ^ 373114468) + (var8 >> 4 << 6);
         } else if (var9 >= 16.0F) {
            var10 = 32;
            var11 = (var8 & 31) << 5;
            var12 = (593855393 ^ 593855713) + (var8 >> 5 << 5);
         } else {
            var10 = 16;
            var11 = var8 << 4;
            var12 = -1956106713 ^ -1956107865;
         }

         Matrix3x2fStack var13 = var0.getMatrices();
         var13.pushMatrix();

         try {
            var13.translate(var1, var2);
            var13.rotate(var4);
            var13.scale(var3 / 32.0F, var3 / 32.0F);
            var0.drawTexture(
               RenderPipelines.GUI_TEXTURED, ART, -16, -16, (float)var11, (float)var12, 32, 32, var10, var10, 2070282275 ^ 2070283299, 1841706015 ^ 1841708063, var7
            );
         } finally {
            var13.popMatrix();
         }

         return true;
      } else {
         return false;
      }
   }

   private static void f(int var0, int var1) {

      w = var0;
      x = var1;
      y = (float)var1 / 540.0F;
      z = (float)var0 * 0.47F / 1024.0F;
      av = 0;
      ao = false;
   }

   private static void g(int var0, int var1) {

      float[] var2 = BatchArrayCache.am;
      if (var2 != null) {
         int var3 = Math.min(295025881 ^ 295025669, var2.length / 11);

         for (int var4 = 0; var4 < var3; var4++) {
            int var5 = var4 * 11;
            ar[var4] = var2[var5 + 3];
            float var6 = var2[var5 + 5];
            as[var4] = var6;
            int var7 = var6 < 0.33F ? 0 : (var6 < 0.75F ? 1 : (var6 < 1.13F ? 2 : 3));
            ap[var4] = ((int)var2[var5 + 7] & 3) * 5 + var7;
            int var8 = Math.min(-299801523 ^ -299801422, Math.max(0, (int)(var2[var5 + 8] * 255.0F + 0.5F)));
            int var9 = Math.min(-1346426744 ^ -1346426761, Math.max(0, (int)(var2[var5 + 9] * 255.0F + 0.5F)));
            int var10 = Math.min(-466979090 ^ -466979311, Math.max(0, (int)(var2[var5 + 10] * 255.0F + 0.5F)));
            aq[var4] = var8 << 16 | var9 << 8 | var10;
         }

         an = var3;
         ao = true;
         av = 0;
         float var11 = a();
         int var12 = Math.round(90.0F * var11);
         int var13 = Math.round(5.0F * var11);

         for (int var14 = 0; var14 < var12 && av < (279381226 ^ 279381326); var14++) {
            h(u.nextFloat() * (float)var0, u.nextFloat() * (float)var1, u.nextFloat(), 0.0F, 0.0F, -1, 0.0F);
         }

         for (int var15 = 0; var15 < var13 && av < (2094168399 ^ 2094168299); var15++) {
            i(u.nextFloat() * (float)var0, u.nextFloat() * (float)var1);
         }
      }
   }

   private static void h(float var0, float var1, float var2, float var3, float var4, int var5, float var6) {

      if (av < (-205355454 ^ -205355034)) {
         int var7 = av++;
         float var8 = var2 >= 0.0F ? 1.0F - 0.746F * var2 : 1.0F - var2 * 1.6F;
         aw[var7] = 0;
         ax[var7] = var5 < 0 ? u.nextInt(6) : var5;
         ay[var7] = 16777215;
         az[var7] = var0;
         ba[var7] = var1;
         bb[var7] = var3;
         bc[var7] = var4;
         bd[var7] = var2;
         be[var7] = u.nextFloat() * (float) (Math.PI * 2);
         bf[var7] = (u.nextFloat() * 2.0F - 1.0F) * 1.3F;
         bg[var7] = u.nextFloat() * (float) (Math.PI * 2);
         bh[var7] = (0.9F + u.nextFloat() * 2.6F) * (u.nextBoolean() ? 1.0F : -1.0F);
         bi[var7] = var6 > 0.0F ? var6 : (11.5F + u.nextFloat() * 4.5F) * y * var8 * 1.23F * 0.62F;
         bj[var7] = var2 < 0.0F ? 0.5F + u.nextFloat() * 0.2F : 0.86F + u.nextFloat() * 0.14F;
         bk[var7] = 0.0F;
         bl[var7] = 0.82F + u.nextFloat() * 0.36F;
         bm[var7] = u.nextFloat() * (float) (Math.PI * 2);
      }
   }

   private static void i(float var0, float var1) {

      if (av < (-1766062864 ^ -1766062764)) {
         float var2 = 0.08F + u.nextFloat() * 0.7F;
         float var3 = 1.0F - 0.746F * var2;
         int var4 = av++;
         aw[var4] = 1;
         if (an > 0) {
            int var5 = u.nextInt(an);
            ax[var4] = ap[var5] / 5;
            ay[var4] = aq[var5];
            bi[var4] = 128.0F * ar[var5] * z / 50.0F * (var3 / 0.7762F);
            bg[var4] = as[var5];
         } else {
            ax[var4] = u.nextInt(4);
            ay[var4] = 16777215;
            bi[var4] = 15.0F * y * var3;
            bg[var4] = u.nextFloat() * 1.1F;
         }

         az[var4] = var0;
         ba[var4] = var1;
         bb[var4] = ac * var3;
         bc[var4] = 10.0F * y * var3;
         bd[var4] = var2;
         be[var4] = u.nextFloat() * (float) (Math.PI * 2);
         bf[var4] = (u.nextFloat() * 2.0F - 1.0F) * 1.6F;
         bh[var4] = (2.2F + u.nextFloat() * 2.4F) * (u.nextBoolean() ? 1.0F : -1.0F);
         bj[var4] = 1.0F;
         bk[var4] = 0.0F;
         bl[var4] = 0.85F + u.nextFloat() * 0.3F;
         bm[var4] = u.nextFloat() * (float) (Math.PI * 2);
      }
   }

   private static void j(float var0, int var1) {

      ac = (14.0F + 6.0F * (float)Math.sin((double)(ab * 0.047F)) + 3.0F * (float)Math.sin((double)(ab * 0.13F + 1.0F))) * y;
      float var2 = 240.0F * y;
      if (ab >= ai) {
         int var3 = 0;

         for (int var4 = 1; var4 < 3; var4++) {
            if (ad[var4] <= 0.0F || ae[var4] < ae[var3]) {
               var3 = var4;
            }
         }

         for (int var15 = 0; var15 < 3; var15++) {
            if (ad[var15] <= 0.0F) {
               var3 = var15;
               break;
            }
         }

         ad[var3] = (40.0F + u.nextFloat() * 80.0F) * y;
         ae[var3] = ab;
         af[var3] = 0.8F + u.nextFloat();
         ag[var3] = 0.6F + u.nextFloat() * 2.2F;
         ah[var3] = 1.8F + u.nextFloat() * 2.5F;
         ai = ab + 5.0F + u.nextFloat() * 9.0F;
      }

      for (int var13 = 0; var13 < 17; var13++) {
         float var16 = (float)(var1 * var13) / 16.0F;
         float var5 = 0.0F;

         for (int var6 = 0; var6 < 3; var6++) {
            float var7 = ad[var6];
            if (!(var7 <= 0.0F)) {
               float var8 = ab - ae[var6] - (var16 + 60.0F * y) / var2;
               float var9 = af[var6];
               float var10 = ag[var6];
               float var11 = ah[var6];
               if (!(var8 <= 0.0F)) {
                  float var17;
                  if (var8 < var9) {
                     var17 = var8 / var9;
                     var17 = var17 * var17 * (3.0F - 2.0F * var17);
                  } else if (var8 < var9 + var10) {
                     var17 = 1.0F;
                  } else if (var8 < var9 + var10 + var11) {
                     var17 = 1.0F - (var8 - var9 - var10) / var11;
                     var17 = var17 * var17 * (3.0F - 2.0F * var17);
                  } else {
                     var17 = 0.0F;
                  }

                  var5 += var7 * var17;
               }
            }
         }

         aj[var13] = var5;
      }

      for (int var14 = 0; var14 < 3; var14++) {
         if (ad[var14] > 0.0F && ab - ae[var14] - ((float)var1 + 120.0F * y) / var2 > af[var14] + ag[var14] + ah[var14]) {
            ad[var14] = 0.0F;
         }
      }
   }

   private static void k(float var0, int var1, int var2) {

      assert var0 >= 0.0F
         && var0 <= 0.1F
         && var1 > 0
         && var2 > 0
         && y > 0.0F
         && aj.length == 17
         && av >= 0
         && av <= (-374230590 ^ -374230938)
         && aw.length == (1862462273 ^ 1862462181)
         && ax.length == (1551036104 ^ 1551036268)
         && ay.length == (190678988 ^ 190678632)
         && az.length == (356985544 ^ 356985708)
         && ba.length == (1689089192 ^ 1689089292)
         && bb.length == (1141459106 ^ 1141459206)
         && bc.length == (298133967 ^ 298133611)
         && bd.length == (-1721446977 ^ -1721447397)
         && be.length == (-1400503716 ^ -1400503304)
         && bg.length == (-1947958576 ^ -1947958412)
         && bi.length == (25981475 ^ 25981831)
         && bj.length == (761759375 ^ 761759531) : "air";

      try {
         float var3 = 110.0F * y;
         float var4 = 0.0F;

         for (int var5 = 0; var5 < 17; var5++) {
            var4 += aj[var5];
         }

         var4 /= 17.0F * var3;
         float var40 = a();
         ak += (3.6F + 18.0F * var4 * var4) * var0 * var40;
         al += (0.5F + 2.6F * var4 * var4) * var0 * var40;

         while (al >= 1.0F) {
            al--;
            if (u.nextFloat() < 0.62F) {
               i(-24.0F * y, u.nextFloat() * (float)var2 * 0.7F);
            } else {
               i((u.nextFloat() * 1.1F - 0.2F) * (float)var1, -24.0F * y);
            }
         }

         int var6 = 0;

         for (int var7 = 0; var7 < av; var7++) {
            if (bd[var7] < 0.0F) {
               var6++;
            }
         }

         while (ak >= 1.0F) {
            ak--;
            float var8 = u.nextFloat();
            float var41;
            if (var8 < 0.06F && var6 < 4) {
               var41 = -0.1F - u.nextFloat() * 0.3F;
               var6++;
            } else {
               var41 = 0.04F + u.nextFloat() * 0.96F;
            }

            float var9;
            float var10;
            if (u.nextFloat() < 0.62F) {
               var9 = -24.0F * y;
               var10 = u.nextFloat() * (float)var2 * 0.7F;
            } else {
               var9 = (u.nextFloat() * 1.1F - 0.2F) * (float)var1;
               var10 = -24.0F * y;
            }

            float var11 = var41 >= 0.0F ? 1.0F - 0.746F * var41 : 1.0F - var41 * 1.6F;
            h(var9, var10, var41, ac * var11, 18.0F * var11 * y, -1, 0.0F);
         }

         for (int var42 = 0; var42 < av; var42++) {
            float var43 = bd[var42];
            float var44 = var43 >= 0.0F ? 1.0F - 0.746F * var43 : 1.0F - var43 * 1.6F;
            float var45 = az[var42];
            float var47 = ba[var42];
            float var12 = bb[var42];
            float var13 = bc[var42];
            int var14 = aw[var42];
            float var15 = var45 / (float)var1 * 16.0F;
            int var16 = var15 < 0.0F ? 0 : (var15 > 15.0F ? 15 : (int)var15);
            float var17 = var15 - (float)var16;
            var17 = var17 < 0.0F ? 0.0F : (var17 > 1.0F ? 1.0F : var17);
            float var18 = aj[var16] + (aj[var16 + 1] - aj[var16]) * var17;
            float var19 = var18 / var3;
            float var20 = (7.0F + 0.35F * var18 / y) * y;
            float var21 = var45 / y;
            float var22 = var47 / y;
            float var23 = MathHelper.cos((double)(var21 * 0.011F + var22 * 0.017F - ab * 0.9F + var43 * 3.0F)) * 0.5F;
            float var24 = MathHelper.cos((double)(-var21 * 0.019F + var22 * 0.008F - ab * 1.3F + 1.7F)) * 0.35F;
            float var25 = MathHelper.cos((double)(var21 * 0.006F - var22 * 0.024F + ab * 0.7F + 4.1F)) * 0.4F;
            float var26 = var20 * (0.84F * var23 + 0.39F * var24 - 0.97F * var25);
            float var27 = var20 * (-0.54F * var23 + 0.92F * var24 - 0.24F * var25);
            float var28 = (ac + var18 + var26) * var44;
            float var29 = var27 * var44;
            float var30 = bg[var42];
            float var33;
            float var34;
            if (var14 == 0) {
               float var35 = var30 + 0.9F * MathHelper.sin((double)(ab * 1.7F + bm[var42]));
               float var36 = MathHelper.cos((double)var35);
               float var37 = var36 < 0.0F ? -var36 : var36;
               float var31 = 2.3F * (0.4F + 0.6F * var37);
               float var32 = 44.0F * y * var44 * bl[var42];
               var33 = (var28 - var12) * var31 + 0.55F * MathHelper.sin((double)(2.0F * var35)) * (var13 > 0.0F ? var13 : 0.0F);
               var34 = (var29 - var13) * var31 + var32 * var31;
            } else {
               float var52 = 1.35F;
               float var53 = 100.0F * y * var44 * bl[var42];
               var33 = (var28 * 0.8F - var12) * var52;
               var34 = (var29 * 0.6F - var13) * var52 + var53 * var52;
            }

            var12 += var33 * var0;
            var13 += var34 * var0;
            var45 += var12 * var0;
            var47 += var13 * var0;
            bb[var42] = var12;
            bc[var42] = var13;
            az[var42] = var45;
            ba[var42] = var47;
            bg[var42] = var30 + bh[var42] * (1.0F + 1.5F * var19) * var0;
            be[var42] = be[var42] + (bf[var42] + 0.4F * var19 * (var14 == 0 ? 1.0F : 0.4F)) * var0;
            bk[var42] = bk[var42] + var0;
            if (var47 > (float)var2 + 50.0F * y || var45 > (float)var1 + 70.0F * y || var45 < -90.0F * y || var47 < -120.0F * y) {
               int var54 = --av;
               if (var42 != var54) {
                  aw[var42] = aw[var54];
                  ax[var42] = ax[var54];
                  ay[var42] = ay[var54];
                  az[var42] = az[var54];
                  ba[var42] = ba[var54];
                  bb[var42] = bb[var54];
                  bc[var42] = bc[var54];
                  bd[var42] = bd[var54];
                  be[var42] = be[var54];
                  bf[var42] = bf[var54];
                  bg[var42] = bg[var54];
                  bh[var42] = bh[var54];
                  bi[var42] = bi[var54];
                  bj[var42] = bj[var54];
                  bk[var42] = bk[var54];
                  bl[var42] = bl[var54];
                  bm[var42] = bm[var54];
                  var42--;
               }
            }
         }
      } catch (RuntimeException var38) {
         throw var38;
      }
   }

   private static void l(DrawContext var0, int var1, int var2, float var3) {

      assert var0 != null
         && var1 > 0
         && var2 > 0
         && var3 > 0.0F
         && av >= 0
         && av <= (-165039205 ^ -165039553)
         && aw.length == (-1143897329 ^ -1143897429)
         && ax.length == (259602515 ^ 259602935)
         && ay.length == (1185756550 ^ 1185756194)
         && az.length == (-503863207 ^ -503862787)
         && ba.length == (843425240 ^ 843424892)
         && bd.length == (-1554617349 ^ -1554617761)
         && be.length == (1208807501 ^ 1208807913)
         && bg.length == (1770102135 ^ 1770101971)
         && bi.length == (-489646550 ^ -489646194)
         && bj.length == (1456841035 ^ 1456840943)
         && bk.length == (374616916 ^ 374616816)
         && bm.length == (-2070381922 ^ -2070381766) : "draw";

      Matrix3x2fStack var4 = var0.getMatrices();

      try {
         float var5 = (float)var1 + 1.0F;
         float var6 = (float)var2 + 1.0F;

         for (int var7 = 0; var7 < 2; var7++) {
            for (int var8 = 0; var8 < av; var8++) {
               float var9 = bd[var8];
               if (var7 == 0 ? !(var9 <= 0.55F) : !(var9 > 0.55F)) {
                  float var10 = bi[var8];
                  float var11 = bj[var8];
                  float var12 = bk[var8] < 0.35F ? bk[var8] / 0.35F : 1.0F;
                  var11 *= var12;
                  int var13 = (int)(var11 * 255.0F);
                  if (var13 >= 3) {
                     float var14 = az[var8];
                     float var15 = ba[var8];
                     if (!(var14 + var10 < 0.0F) && !(var14 - var10 > var5) && !(var15 + var10 < 0.0F) && !(var15 - var10 > var6)) {
                        int var18 = -1;
                        int var16;
                        float var34;
                        if (aw[var8] == 0) {
                           float var19 = bg[var8] + 0.9F * MathHelper.sin((double)(ab * 1.7F + bm[var8]));
                           float var20 = MathHelper.cos((double)var19);
                           var34 = var20 < 0.0F ? -var20 : var20;
                           var34 = var34 < 0.08F ? 0.08F : var34;
                           int var21 = var20 < 0.0F ? 1 : 0;
                           var16 = 20 + ax[var8] * 2 + var21;
                           if (var9 < 0.0F) {
                              var18 = ax[var8] * 2 + var21;
                           }
                        } else {
                           float var35 = bg[var8] % (float) (Math.PI * 2);
                           var35 = var35 < 0.0F ? var35 + (float) (Math.PI * 2) : var35;
                           float var38 = var35 > (float) Math.PI ? (float) (Math.PI * 2) - var35 : var35;
                           var16 = ax[var8] * 5 + (var38 < 0.33F ? 0 : (var38 < 0.75F ? 1 : (var38 < 1.13F ? 2 : (var38 < 1.9F ? 3 : 4))));
                           var34 = 1.0F;
                        }

                        float var37 = var10 * var3;
                        int var22;
                        int var39;
                        int var40;
                        if (var18 >= 0) {
                           var39 = 64;
                           var40 = var18 << 6;
                           var22 = 1132971728 ^ 1132970304;
                        } else if (var37 >= 64.0F) {
                           var39 = -1966088226 ^ -1966088354;
                           var40 = (var16 & 7) << 7;
                           var22 = (207821062 ^ 207822086) + (var16 >> 3 << 7);
                        } else if (var37 >= 32.0F) {
                           var39 = 64;
                           var40 = (var16 & 15) << 6;
                           var22 = (2137302467 ^ 2137301827) + (var16 >> 4 << 6);
                        } else if (var37 >= 16.0F) {
                           var39 = 32;
                           var40 = (var16 & 31) << 5;
                           var22 = (408617950 ^ 408618142) + (var16 >> 5 << 5);
                        } else {
                           var39 = 16;
                           var40 = var16 << 4;
                           var22 = -967080384 ^ -967081536;
                        }

                        int var23 = ay[var8];
                        if (var9 > 0.5F) {
                           float var24 = (var9 - 0.5F) * 0.5F;
                           int var25 = (int)((float)(var23 >> 16 & (981562971 ^ 981563044)) * (1.0F - var24 * 0.35F));
                           int var26 = (int)((float)(var23 >> 8 & (2001130250 ^ 2001130485)) * (1.0F - var24 * 0.39F));
                           int var27 = (int)((float)(var23 & (1755347477 ^ 1755347690)) * (1.0F - var24 * 0.24F));
                           var23 = var25 << 16 | var26 << 8 | var27;
                        }

                        var4.pushMatrix();

                        try {
                           var4.translate(var14, var15);
                           var4.rotate(be[var8]);
                           var4.scale(var10 * var34 / 32.0F, var10 / 32.0F);
                           var0.drawTexture(
                              RenderPipelines.GUI_TEXTURED,
                              ART,
                              -16,
                              -16,
                              (float)var40,
                              (float)var22,
                              32,
                              32,
                              var39,
                              var39,
                              1387660317 ^ 1387659293,
                              -287877469 ^ -287875421,
                              var13 << 24 | var23
                           );
                        } finally {
                           var4.popMatrix();
                        }
                     }
                  }
               }
            }
         }
      } catch (RuntimeException var32) {
         throw var32;
      }
   }
}
