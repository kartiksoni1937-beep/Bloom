package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import java.util.Random;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.render.Camera;
import net.minecraft.block.enums.CameraSubmersionType;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.world.Heightmap;import net.minecraft.entity.Entity;
public final class DriftPassCache {
   private static final float s = 0.0F;
   private static final float t = 1.0F;
   private static final float u = 2.0F;
   private static final float v = 3.0F;
   private static final float w = 4.0F;
   private static final float x = 5.0F;
   private static final float y = (float) (Math.PI * 2);
   private static final float z = (float) (Math.PI / 180.0);
   private static final float aa = 0.5F;
   private static final float ab = 0.5F;
   private static final float ac = 0.18F;
   private static final float ad = 0.22F;
   private static final double ae = 961.0;
   private static final float af = 0.5F;
   private static final float ag = 0.7F;
   private static final float ah = 0.8F;
   private static final int[] ai = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 0, 2, 1, 3, 4, 6, 5, 7, 0, 4, 1, 5, 2, 6, 3, 7};
   private static final int[] aj = new int[]{0, 1, 3, 2, 4, 5, 7, 6, 0, 1, 5, 4, 2, 3, 7, 6, 0, 2, 6, 4, 1, 3, 7, 5};
   private static final float[] ak = new float[24];
   private static final Random al = new Random();
   private static float am;
   private static float an;
   private static float ao;
   private static float ap;
   private static float aq;
   private static float ar;
   private static float as = 1.0F;
   private static boolean at;
   private static boolean au;
   private static float av;
   private static float aw;
   private static float ax;
   private static float ay = 0.9F;
   private static final int az = 4;
   private static final int ba = 8;
   private static final int bb = 3;
   private static final int bc = 6;
   private static final int bd = 40;
   private static final int be = 80;
   private static final int bf = 2;
   private static final int bg = 3;
   private static final int bh = 6;
   private static final float bi = 1.6F;
   private static final float bj = 3.2F;
   private static final float bk = 0.3F;
   private static final float bl = 2.6F;
   private static final float bm = 0.6F;
   private static final float bn = 0.4F;
   private static final double bo = 3.2;
   private static final float bp = 3.2F;
   private static final float bq = 0.45F;
   private static final float br = 4.5F;
   private static float bs;
   private static float bt;
   private static float bu;
   private static float bv;
   private static float bw = 0.5F;
   private static float bx = 1.0F;
   private static boolean by;
   private static final int bz = 10;
   private static final int ca = 20;
   private static final int cb = 28;
   private static float cc;
   private static final boolean[] cd = new boolean[28];
   private static final double[] ce = new double[28];
   private static final double[] cf = new double[28];
   private static final double[] cg = new double[28];
   private static final float[] ch = new float[28];
   private static final float[] ci = new float[28];
   private static final float[] cj = new float[28];
   private static final float[] ck = new float[28];
   private static final float[] cl = new float[28];
   private static final float[] cm = new float[28];
   private static final float[] cn = new float[28];
   private static final float[] co = new float[28];
   private static final float[] cp = new float[28];
   private static final float[] cq = new float[28];
   private static final float[] cr = new float[28];
   private static final float[] cs = new float[28];
   private static final float[] ct = new float[28];
   private static final int cu = 6;
   private static final int cv = 12;
   private static final int cw = 18;
   private static float cx;
   private static final boolean[] cy = new boolean[18];
   private static final double[] cz = new double[18];
   private static final double[] da = new double[18];
   private static final double[] db = new double[18];
   private static final float[] dc = new float[18];
   private static final float[] dd = new float[18];
   private static final float[] de = new float[18];
   private static final float[] df = new float[18];
   private static final float[] dg = new float[18];
   private static final float[] dh = new float[18];
   private static final float[] di = new float[18];
   private static final float[] dj = new float[18];
   private static final float[] dk = new float[18];
   private static final float[] dl = new float[18];
   private static final int dm = 110;
   private static final int dn = 220;
   private static final int _kwren_do= 300;
   private static final double dp = 21.0;
   private static final double dq = 441.0;
   private static float dr;
   private static final boolean[] ds = new boolean[300];
   private static final double[] dt = new double[300];
   private static final double[] du = new double[300];
   private static final double[] dv = new double[300];
   private static final float[] dw = new float[300];
   private static final float[] dx = new float[300];
   private static final float[] dy = new float[300];
   private static final float[] dz = new float[300];
   private static final float[] ea = new float[300];
   private static final float[] eb = new float[300];
   private static final float[] ec = new float[300];
   private static final int ed = 3;
   private static final int ee = 5;
   private static float ef = 0.6F;
   private static float eg = 1.0F;
   private static final boolean[] eh = new boolean[5];
   private static final double[] ei = new double[5];
   private static final double[] ej = new double[5];
   private static final double[] ek = new double[5];
   private static final float[] el = new float[5];
   private static final float[] em = new float[5];
   private static final float[] en = new float[5];
   private static final float[] eo = new float[5];
   private static final float[] ep = new float[5];
   private static final float[] eq = new float[5];
   private static final int er = 8;
   private static final int es = 16;
   private static final int et = 22;
   private static final int eu = 14;
   private static final float ev = 14.0F;
   private static final double ew = 2116.0;
   private static float ex;
   private static final boolean[] ey = new boolean[22];
   private static final double[] ez = new double[308];
   private static final double[] fa = new double[308];
   private static final double[] fb = new double[308];
   private static final float[] fc = new float[308];
   private static final int[] fd = new int[22];
   private static final float[] fe = new float[22];
   private static final float[] ff = new float[22];
   private static final float[] fg = new float[22];
   private static final float[] fh = new float[22];
   private static final float[] fi = new float[22];

   private DriftPassCache() {
   }

   public static void a() {

      MinecraftClient var0 = MinecraftClient.getInstance();
      ClientWorld var1 = var0.world;
      if (var1 != null && var0.player != null) {
         float var2 = RegionPassCache.dt;
         float var3 = var2 / 0.18F;
         float var4 = var2 / 0.22F;
         boolean var5 = RegionPassCache.bh;
         float var6 = var5 ? am + var3 : am - var4;
         var6 = var6 < 0.0F ? 0.0F : (var6 > 1.0F ? 1.0F : var6);
         am = var6;
         if (var6 <= 0.0F && !var5) {
            if (at) {
               e();
            }
         } else {
            at = true;
            float var7 = var5 && RegionPassCache.bi ? an + var3 : an - var4;
            var7 = var7 < 0.0F ? 0.0F : (var7 > 1.0F ? 1.0F : var7);
            an = var7;
            float var8 = var5 && RegionPassCache.bj ? ao + var3 : ao - var4;
            var8 = var8 < 0.0F ? 0.0F : (var8 > 1.0F ? 1.0F : var8);
            ao = var8;
            float var9 = var5 && RegionPassCache.bk ? ap + var3 : ap - var4;
            var9 = var9 < 0.0F ? 0.0F : (var9 > 1.0F ? 1.0F : var9);
            ap = var9;
            float var10 = var5 && RegionPassCache.bl ? aq + var3 : aq - var4;
            var10 = var10 < 0.0F ? 0.0F : (var10 > 1.0F ? 1.0F : var10);
            aq = var10;
            float var11 = var5 && RegionPassCache.bm ? ar + var3 : ar - var4;
            var11 = var11 < 0.0F ? 0.0F : (var11 > 1.0F ? 1.0F : var11);
            ar = var11;
            Camera var12 = var0.gameRenderer.getCamera();
            float var13 = 1.0F;
            CameraSubmersionType var14 = var12.getSubmersionType();
            if (var14 != CameraSubmersionType.LAVA && var14 != CameraSubmersionType.POWDER_SNOW) {
               if (var12.getFocusedEntity() instanceof LivingEntity var16 && (var16.hasStatusEffect(StatusEffects.BLINDNESS) || var16.hasStatusEffect(StatusEffects.DARKNESS))) {
                  var13 = 0.0F;
               }
            } else {
               var13 = 0.0F;
            }

            float var32 = var2 / 0.5F;
            float var33 = as + (var13 > 0.5F ? var32 : -var32);
            var33 = var33 < 0.0F ? 0.0F : (var33 > 1.0F ? 1.0F : var33);
            as = var33;
            int var17 = (Integer)var0.options.getFov().getValue();
            float var18 = (float)var0.getWindow().getFramebufferWidth();
            float var19 = (float)var0.getWindow().getFramebufferHeight();
            boolean var20 = var18 >= 1.0F && var19 >= 1.0F;
            if (var20) {
               double var21 = Math.tan(Math.toRadians(Math.min(170.0, (double)var17 * 1.5)) * 0.5);
               double var23 = var21 * (double)var18 / (double)var19;
               float var25 = (float)(1.0 / Math.sqrt(1.0 + var21 * var21 + var23 * var23)) - 0.05F;
               var20 = var25 > 0.02F;
               aw = var25 * var25;
               av = (float)Math.sqrt(Math.max(0.0, 1.0 - (double)(var25 * var25)));
               ay = (float)Math.atan(Math.tan(Math.toRadians((double)var17) * 0.5) * (double)var18 / (double)var19);
            }

            if (var0.player.hurtTime > 0
               || var0.player.nauseaIntensity > 0.0F
               || var0.player.lastNauseaIntensity > 0.0F
               || var0.player.hasStatusEffect(StatusEffects.NAUSEA)) {
               var20 = false;
            }

            au = var20;
            float var35 = RegionPassCache.fX - RegionPassCache.fY * RegionPassCache.uX;
            float var22 = RegionPassCache.fZ - RegionPassCache.fY * RegionPassCache.uZ;
            if (var35 * var35 + var22 * var22 > 1.0E-6F) {
               ax = (float)Math.atan2((double)var22, (double)var35);
            }

            int var36 = RegionPassCache.col(RegionPassCache.bo) & (2055499063 ^ 2054918856);
            float var24 = var6 * var6 * (3.0F - 2.0F * var6) * var33 * var33 * (3.0F - 2.0F * var33);
            if (var11 > 0.0F) {
               q(var2, var24 * var11 * var11 * (3.0F - 2.0F * var11), var36, 0, 16, false);
            } else if (ex != 0.0F) {
               g(4, false);
            }

            if (var7 > 0.0F) {
               h(var2, var24 * var7 * var7 * (3.0F - 2.0F * var7), var36, 0, 20, false);
            } else if (cc != 0.0F) {
               g(0, false);
            }

            if (var8 > 0.0F) {
               k(var2, var24 * var8 * var8 * (3.0F - 2.0F * var8), var36, 0, 12, false);
            } else if (cx != 0.0F) {
               g(1, false);
            }

            if (var10 > 0.0F) {
               o(var2, var24 * var10 * var10 * (3.0F - 2.0F * var10), var36, var5 && RegionPassCache.bl, 0, 3, false);
            } else if (eh[0] || eh[1] || eh[2]) {
               g(3, false);
            }

            if (var9 > 0.0F) {
               m(var2, var24 * var9 * var9 * (3.0F - 2.0F * var9), var36, 0, 1184042856 ^ 1184042932, false);
            } else if (dr != 0.0F) {
               g(2, false);
            }
         }
      }
   }

   public static void b() {

      if (RegionPassCache.PV && (RegionPassCache.bt & 16) != 0) {
         float var0 = am;
         if (var0 <= 0.0F) {
            if (by) {
               f();
            }
         } else {
            by = true;
            float var1 = RegionPassCache.dt;
            int var2 = RegionPassCache.col(RegionPassCache.bo) & (-1471937415 ^ -1464075386);
            float var3 = var0 * var0 * (3.0F - 2.0F * var0);
            float var4 = ar;
            float var5 = an;
            float var6 = ao;
            float var7 = aq;
            float var8 = ap;
            if (var4 > 0.0F) {
               q(var1, var3 * var4 * var4 * (3.0F - 2.0F * var4), var2, 16, 22, true);
            } else if (bv != 0.0F) {
               g(4, true);
            }

            if (var5 > 0.0F) {
               h(var1, var3 * var5 * var5 * (3.0F - 2.0F * var5), var2, 20, 28, true);
            } else if (bs != 0.0F) {
               g(0, true);
            }

            if (var6 > 0.0F) {
               k(var1, var3 * var6 * var6 * (3.0F - 2.0F * var6), var2, 12, 18, true);
            } else if (bt != 0.0F) {
               g(1, true);
            }

            if (var7 > 0.0F) {
               o(var1, var3 * var7 * var7 * (3.0F - 2.0F * var7), var2, RegionPassCache.bh && RegionPassCache.bl, 3, 5, true);
            } else if (eh[3] || eh[4]) {
               g(3, true);
            }

            if (var8 > 0.0F) {
               m(var1, var3 * var8 * var8 * (3.0F - 2.0F * var8), var2, -2098014930 ^ -2098014734, -1606722123 ^ -1606722407, true);
            } else if (bu != 0.0F) {
               g(2, true);
            }
         }
      }
   }

   public static void c() {

      f();
   }

   public static void d() {

      e();
      f();
      am = 0.0F;
      ar = 0.0F;
      aq = 0.0F;
      ap = 0.0F;
      ao = 0.0F;
      an = 0.0F;
   }

   private static void e() {

      for (int var0 = 0; var0 < 5; var0++) {
         g(var0, false);
      }

      at = false;
   }

   private static void f() {

      for (int var0 = 0; var0 < 5; var0++) {
         g(var0, true);
      }

      by = false;
   }

   private static void g(int var0, boolean var1) {

      if (var0 == 0) {
         if (var1) {
            bs = 0.0F;
         } else {
            cc = 0.0F;
         }

         int var2 = var1 ? 20 : 0;

         for (int var3 = var1 ? 28 : 20; var2 < var3; var2++) {
            cd[var2] = false;
            ct[var2] = 0.0F;
         }
      } else if (var0 == 1) {
         if (var1) {
            bt = 0.0F;
         } else {
            cx = 0.0F;
         }

         int var4 = var1 ? 12 : 0;

         for (int var8 = var1 ? 18 : 12; var4 < var8; var4++) {
            cy[var4] = false;
            dl[var4] = 0.0F;
         }
      } else if (var0 == 2) {
         if (var1) {
            bu = 0.0F;
         } else {
            dr = 0.0F;
         }

         int var5 = var1 ? 767930503 ^ 767930459 : 0;

         for (int var9 = var1 ? 954733761 ^ 954734061 : -1062531210 ^ -1062531158; var5 < var9; var5++) {
            ds[var5] = false;
            ec[var5] = 0.0F;
         }
      } else if (var0 == 3) {
         int var6 = var1 ? 3 : 0;

         for (int var10 = var1 ? 5 : 3; var6 < var10; var6++) {
            eh[var6] = false;
         }

         if (var1) {
            bw = 0.3F + 0.5F * al.nextFloat();
         } else {
            ef = 0.4F + al.nextFloat();
         }
      } else {
         if (var1) {
            bv = 0.0F;
         } else {
            ex = 0.0F;
         }

         int var7 = var1 ? 16 : 0;

         for (int var11 = var1 ? 22 : 16; var7 < var11; var7++) {
            ey[var7] = false;
            fi[var7] = 0.0F;
         }
      }
   }

   private static void h(float var0, float var1, int var2, int var3, int var4, boolean var5) {

      assert var0 >= 0.0F
         && var0 <= 0.5F
         && var1 >= 0.0F
         && var1 <= 2.0F
         && var2 >= 0
         && var2 <= (1416271919 ^ 1419077584)
         && (var5 ? var3 == 20 && var4 == 28 : var3 == 0 && var4 == 20)
         && var3 >= 0
         && var3 < var4
         && var4 <= 28
         && cd.length == 28
         && ce.length == 28
         && cf.length == 28
         && cg.length == 28
         && ch.length == 28
         && ci.length == 28
         && cj.length == 28
         && ck.length == 28
         && cl.length == 28
         && cm.length == 28
         && cn.length == 28
         && co.length == 28
         && cp.length == 28
         && cq.length == 28
         && cr.length == 28
         && cs.length == 28
         && ct.length == 28
         && ai.length == 24
         && aj.length == 24
         && ak.length == 24
         && RegionPassCache.LA.length == (-653190056 ^ -653231016)
         && RegionPassCache.QT.length == (1871740818 ^ 1871835026)
         && RegionPassCache.SA.length == (1536852866 ^ 1536820098) : "cubes: ba" + "d s" + "t" + "ate";

      try {
         double var6 = RegionPassCache.z;
         double var8 = RegionPassCache.aa;
         double var10 = RegionPassCache.ab;
         float var12 = (float)(var5 ? 4 : 10) * RegionPassCache.bn;
         float var13 = var5 ? bs : cc;
         var13 += (var12 - var13) * (1.0F - (float)Math.exp((double)(-var0 * 1.5F)));
         if (Math.abs(var12 - var13) < 0.001F) {
            var13 = var12;
         }

         if (var5) {
            bs = var13;
         } else {
            cc = var13;
         }

         float var14 = var0 / 0.5F;
         int var15 = var2 >> 16 & (1690755894 ^ 1690756041);
         int var16 = var2 >> 8 & (858176409 ^ 858176358);
         int var17 = var2 & (1169755913 ^ 1169756150);
         int var18 = var15 + (int)((float)((400440942 ^ 400440977) - var15) * 0.4F + 0.5F) << 16
            | var16 + (int)((float)((319182015 ^ 319181888) - var16) * 0.4F + 0.5F) << 8
            | var17 + (int)((float)((-847748097 ^ -847748352) - var17) * 0.4F + 0.5F);
         float var19 = RegionPassCache.fX;
         float var20 = RegionPassCache.fY;
         float var21 = RegionPassCache.fZ;
         boolean var22 = au && !var5;
         float var23 = av;
         float var24 = aw;
         double var25 = RegionPassCache.now * 0.9;
         float[] var27 = ak;
         float[] var28 = RegionPassCache.LA;
         float[] var29 = RegionPassCache.QT;
         float[] var30 = RegionPassCache.SA;
         int var31 = RegionPassCache.nLA;
         int var32 = RegionPassCache.nQT;
         int var33 = RegionPassCache.nSA;

         for (int var34 = var3; var34 < var4; var34++) {
            boolean var35 = (float)(var34 - var3) < var13;
            float var36 = ct[var34] + (var35 ? var14 : -var14);
            var36 = var36 < 0.0F ? 0.0F : (var36 > 1.0F ? 1.0F : var36);
            ct[var34] = var36;
            if (!cd[var34]) {
               if (!var35) {
                  continue;
               }

               i(var34, var5);
            } else if (!var35 && var36 <= 0.0F) {
               cd[var34] = false;
               continue;
            }

            float var37 = cr[var34] + var0;
            double var38 = ce[var34] + (double)(ch[var34] * var0);
            double var40 = cf[var34] + (double)(ci[var34] * var0);
            double var42 = cg[var34] + (double)(cj[var34] * var0);
            double var44 = var38 - var6;
            double var46 = var40 - var8;
            double var48 = var42 - var10;
            if (var37 >= cs[var34] || var44 * var44 + var46 * var46 + var48 * var48 > 961.0) {
               if (!var35) {
                  cd[var34] = false;
                  continue;
               }

               i(var34, var5);
               var37 = 0.0F;
               var38 = ce[var34];
               var40 = cf[var34];
               var42 = cg[var34];
               var44 = var38 - var6;
               var46 = var40 - var8;
               var48 = var42 - var10;
            }

            ce[var34] = var38;
            cf[var34] = var40;
            cg[var34] = var42;
            float var50 = cn[var34] + co[var34] * var0;
            if (var50 > (float) (Math.PI * 2)) {
               var50 -= (float) (Math.PI * 2);
            } else if (var50 < 0.0F) {
               var50 += (float) (Math.PI * 2);
            }

            cn[var34] = var50;
            float var51 = cp[var34];
            float var52 = (float)var44;
            float var53 = (float)var46 + 0.08F * MathHelper.sin(var25 + (double)cq[var34]);
            float var54 = (float)var48;
            float var55 = var52 * var52 + var53 * var53 + var54 * var54;
            float var56 = var52 * var19 + var53 * var20 + var54 * var21;
            float var57 = 1.6F * var51;
            boolean var58 = var56 < -var57;
            if (!var58 && var22) {
               float var59 = var57 + var56 * var23;
               var58 = var59 < 0.0F || (var55 - var56 * var56) * var24 > var59 * var59;
            }

            if (var58) {
               cr[var34] = var37 + var0;
            } else {
               cr[var34] = var37;
               float var93 = MathHelper.sqrt(var55);
               float var60 = var37 / 1.2F;
               var60 = var60 > 1.0F ? 1.0F : var60;
               float var61 = (cs[var34] - var37) / 1.2F;
               var61 = var61 < 0.0F ? 0.0F : (var61 > 1.0F ? 1.0F : var61);
               float var62 = (var93 - 1.0F) / 1.5F;
               var62 = var62 < 0.0F ? 0.0F : (var62 > 1.0F ? 1.0F : var62);
               float var63 = (var93 - 22.0F) / 8.0F;
               var63 = var63 < 0.0F ? 0.0F : (var63 > 1.0F ? 1.0F : var63);
               float var64 = var1
                  * var36
                  * var60
                  * var60
                  * (3.0F - 2.0F * var60)
                  * var61
                  * var61
                  * (3.0F - 2.0F * var61)
                  * var62
                  * var62
                  * (3.0F - 2.0F * var62)
                  * (1.0F - var63 * var63 * (3.0F - 2.0F * var63));
               if (!(var64 < 0.004F)) {
                  float var65 = 0.5F * var51;
                  float var66 = ck[var34];
                  float var67 = cl[var34];
                  float var68 = cm[var34];
                  float var69 = MathHelper.cos((double)var50);
                  float var70 = MathHelper.sin((double)var50);
                  float var71 = 1.0F - var69;
                  float var72 = (var71 * var66 * var66 + var69) * var65;
                  float var73 = (var71 * var66 * var67 + var70 * var68) * var65;
                  float var74 = (var71 * var66 * var68 - var70 * var67) * var65;
                  float var75 = (var71 * var66 * var67 - var70 * var68) * var65;
                  float var76 = (var71 * var67 * var67 + var69) * var65;
                  float var77 = (var71 * var67 * var68 + var70 * var66) * var65;
                  float var78 = (var71 * var66 * var68 + var70 * var67) * var65;
                  float var79 = (var71 * var67 * var68 - var70 * var66) * var65;
                  float var80 = (var71 * var68 * var68 + var69) * var65;

                  for (int var81 = 0; var81 < 8; var81++) {
                     float var82 = (var81 & 1) != 0 ? 1.0F : -1.0F;
                     float var83 = (var81 & 2) != 0 ? 1.0F : -1.0F;
                     float var84 = (var81 & 4) != 0 ? 1.0F : -1.0F;
                     var27[var81 * 3] = var52 + var82 * var72 + var83 * var75 + var84 * var78;
                     var27[var81 * 3 + 1] = var53 + var82 * var73 + var83 * var76 + var84 * var79;
                     var27[var81 * 3 + 2] = var54 + var82 * var74 + var83 * var77 + var84 * var80;
                  }

                  int var98 = (int)(0.9F * var64 * 255.0F + 0.5F);
                  float var99 = Float.intBitsToFloat(var98 << 24 | var18);
                  float var100 = 0.125F * var51;

                  for (int var101 = 0; var101 < 12 && var31 < (-59676242 ^ -59684434); var101++) {
                     int var85 = var31++ * 11;
                     int var86 = ai[var101 * 2] * 3;
                     int var87 = ai[var101 * 2 + 1] * 3;
                     var28[var85] = var27[var86];
                     var28[var85 + 1] = var27[var86 + 1];
                     var28[var85 + 2] = var27[var86 + 2];
                     var28[var85 + 3] = var27[var87];
                     var28[var85 + 4] = var27[var87 + 1];
                     var28[var85 + 5] = var27[var87 + 2];
                     var28[var85 + 6] = var100;
                     var28[var85 + 7] = var100;
                     var28[var85 + 8] = var99;
                     var28[var85 + 9] = var99;
                     var28[var85 + 10] = 1.0F;
                  }

                  int var102 = (int)(0.16F * var64 * 255.0F + 0.5F);
                  if (var102 > 0) {
                     float var103 = Float.intBitsToFloat(var102 << 24 | var2);

                     for (int var105 = 0; var105 < 6 && var32 < (-119466565 ^ -119470661); var105++) {
                        int var106 = var32++ * 25;

                        for (int var88 = 0; var88 < 4; var88++) {
                           int var89 = aj[var105 * 4 + var88] * 3;
                           var29[var106 + var88 * 3] = var27[var89];
                           var29[var106 + var88 * 3 + 1] = var27[var89 + 1];
                           var29[var106 + var88 * 3 + 2] = var27[var89 + 2];
                           var29[var106 + 12 + var88 * 2] = 0.5F;
                           var29[var106 + 13 + var88 * 2] = 0.5F;
                        }

                        var29[var106 + 20] = 0.0F;
                        var29[var106 + 21] = var103;
                        var29[var106 + 22] = var103;
                        var29[var106 + 23] = var103;
                        var29[var106 + 24] = var103;
                     }
                  }

                  if (var33 < (-610501960 ^ -610506056)) {
                     int var104 = var33++ * 8;
                     var30[var104] = var52;
                     var30[var104 + 1] = var53;
                     var30[var104 + 2] = var54;
                     var30[var104 + 3] = 1.1F * var51;
                     var30[var104 + 4] = 1.1F * var51;
                     var30[var104 + 5] = 0.0F;
                     var30[var104 + 6] = 4.0F;
                     var30[var104 + 7] = Float.intBitsToFloat((int)(0.45F * var64 * 255.0F + 0.5F) << 24 | var2);
                  }
               }
            }
         }

         RegionPassCache.nLA = var31;
         RegionPassCache.nQT = var32;
         RegionPassCache.nSA = var33;
      } catch (RuntimeException var90) {
         throw var90;
      }
   }

   private static void i(int var0, boolean var1) {

      ClientWorld var2 = MinecraftClient.getInstance().world;
      if (var1) {
         j(ce, cf, cg, ch, ci, cj, var0, (0.08F + al.nextFloat() * 0.17F) * 0.4F);
      } else {
         double var3 = RegionPassCache.z;
         double var5 = RegionPassCache.aa;
         double var7 = RegionPassCache.ab;
         float var9 = al.nextFloat() < 0.5F ? ax + (al.nextFloat() * 2.0F - 1.0F) * (ay + 0.17F) : al.nextFloat() * (float) (Math.PI * 2);
         float var10 = 5.0F + al.nextFloat() * 17.0F;
         double var11 = var3 + (double)(MathHelper.cos((double)var9) * var10);
         double var13 = var7 + (double)(MathHelper.sin((double)var9) * var10);
         int var15 = var2.getTopY(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MathHelper.floor(var11), MathHelper.floor(var13));
         double var16 = var15 <= var2.getBottomY() ? var5 - 1.6 : (double)var15;
         var16 = var16 < var5 - 6.0 ? var5 - 6.0 : (var16 > var5 + 6.0 ? var5 + 6.0 : var16);
         ce[var0] = var11;
         cf[var0] = var16 + 0.8 + (double)(al.nextFloat() * 6.2F);
         cg[var0] = var13;
         float var18 = al.nextFloat() * (float) (Math.PI * 2);
         float var19 = 0.08F + al.nextFloat() * 0.17F;
         ch[var0] = MathHelper.cos((double)var18) * var19;
         cj[var0] = MathHelper.sin((double)var18) * var19;
         ci[var0] = (al.nextFloat() * 2.0F - 1.0F) * 0.05F;
      }

      float var20 = al.nextFloat() * 2.0F - 1.0F;
      float var4 = al.nextFloat() * (float) (Math.PI * 2);
      float var21 = MathHelper.sqrt(1.0F - var20 * var20);
      ck[var0] = var21 * MathHelper.cos((double)var4);
      cl[var0] = var20;
      cm[var0] = var21 * MathHelper.sin((double)var4);
      float var6 = (20.0F + al.nextFloat() * 35.0F) * (float) (Math.PI / 180.0);
      co[var0] = al.nextBoolean() ? var6 : -var6;
      cn[var0] = al.nextFloat() * (float) (Math.PI * 2);
      float var22 = 0.26F + al.nextFloat() * 0.2F;
      cp[var0] = var1 ? var22 * 0.6F : var22;
      cq[var0] = al.nextFloat() * (float) (Math.PI * 2);
      cs[var0] = 8.0F + al.nextFloat() * 6.0F;
      cr[var0] = 0.0F;
      cd[var0] = true;
   }

   private static void j(double[] var0, double[] var1, double[] var2, float[] var3, float[] var4, float[] var5, int var6, float var7) {

      float var8 = al.nextFloat() * (float) (Math.PI * 2);
      float var9 = MathHelper.cos((double)var8);
      float var10 = MathHelper.sin((double)var8);
      float var11 = MathHelper.sqrt(2.5600002F + al.nextFloat() * 7.6800003F);
      float var12 = 0.3F + al.nextFloat() * 2.3F;
      var0[var6] = RegionPassCache.pvX + (double)(var9 * var11);
      var1[var6] = (double)var12;
      var2[var6] = RegionPassCache.pvZ + (double)(var10 * var11);
      float var13 = al.nextBoolean() ? var7 : -var7;
      float var14 = (al.nextFloat() - 0.35F) * 0.4F * var7;
      var3[var6] = var14 * var9 - var13 * var10;
      var5[var6] = var14 * var10 + var13 * var9;
      float var15 = (al.nextFloat() * 2.0F - 1.0F) * 0.02F;
      var4[var6] = var12 < 1.0F && var15 < 0.0F ? -var15 : var15;
   }

   private static void k(float var0, float var1, int var2, int var3, int var4, boolean var5) {

      assert var0 >= 0.0F
         && var0 <= 0.5F
         && var1 >= 0.0F
         && var1 <= 2.0F
         && var2 >= 0
         && var2 <= (657272612 ^ 668127451)
         && (var5 ? var3 == 12 && var4 == 18 : var3 == 0 && var4 == 12)
         && var3 >= 0
         && var3 < var4
         && var4 <= 18
         && cy.length == 18
         && cz.length == 18
         && da.length == 18
         && db.length == 18
         && dc.length == 18
         && dd.length == 18
         && de.length == 18
         && df.length == 18
         && dg.length == 18
         && dh.length == 18
         && di.length == 18
         && dj.length == 18
         && dk.length == 18
         && dl.length == 18
         && RegionPassCache.ST.length == (-139371211 ^ -139363019)
         && RegionPassCache.SA.length == (2022973548 ^ 2023006316) : "stars: bad " + "st" + "a" + "te";

      try {
         double var6 = RegionPassCache.z;
         double var8 = RegionPassCache.aa;
         double var10 = RegionPassCache.ab;
         float var12 = (float)(var5 ? 3 : 6) * RegionPassCache.bn;
         float var13 = var5 ? bt : cx;
         var13 += (var12 - var13) * (1.0F - (float)Math.exp((double)(-var0 * 1.5F)));
         if (Math.abs(var12 - var13) < 0.001F) {
            var13 = var12;
         }

         if (var5) {
            bt = var13;
         } else {
            cx = var13;
         }

         float var14 = var0 / 0.5F;
         int var15 = var2 >> 16 & (99651098 ^ 99651301);
         int var16 = var2 >> 8 & (240511278 ^ 240511441);
         int var17 = var2 & (682768511 ^ 682768512);
         int var18 = var15 + (int)((float)((-1235720834 ^ -1235720831) - var15) * 0.45F + 0.5F) << 16
            | var16 + (int)((float)((-1599490269 ^ -1599490084) - var16) * 0.45F + 0.5F) << 8
            | var17 + (int)((float)((-215198066 ^ -215198095) - var17) * 0.45F + 0.5F);
         float var19 = RegionPassCache.fX;
         float var20 = RegionPassCache.fY;
         float var21 = RegionPassCache.fZ;
         boolean var22 = au && !var5;
         float var23 = av;
         float var24 = aw;
         double var25 = RegionPassCache.now * 0.9;
         double var27 = RegionPassCache.now * 2.2;
         float[] var29 = RegionPassCache.ST;
         float[] var30 = RegionPassCache.SA;
         int var31 = RegionPassCache.nST;
         int var32 = RegionPassCache.nSA;

         for (int var33 = var3; var33 < var4; var33++) {
            boolean var34 = (float)(var33 - var3) < var13;
            float var35 = dl[var33] + (var34 ? var14 : -var14);
            var35 = var35 < 0.0F ? 0.0F : (var35 > 1.0F ? 1.0F : var35);
            dl[var33] = var35;
            if (!cy[var33]) {
               if (!var34) {
                  continue;
               }

               l(var33, var5);
            } else if (!var34 && var35 <= 0.0F) {
               cy[var33] = false;
               continue;
            }

            float var36 = dj[var33] + var0;
            double var37 = cz[var33] + (double)(dc[var33] * var0);
            double var39 = da[var33] + (double)(dd[var33] * var0);
            double var41 = db[var33] + (double)(de[var33] * var0);
            double var43 = var37 - var6;
            double var45 = var39 - var8;
            double var47 = var41 - var10;
            if (var36 >= dk[var33] || var43 * var43 + var45 * var45 + var47 * var47 > 961.0) {
               if (!var34) {
                  cy[var33] = false;
                  continue;
               }

               l(var33, var5);
               var36 = 0.0F;
               var37 = cz[var33];
               var39 = da[var33];
               var41 = db[var33];
               var43 = var37 - var6;
               var45 = var39 - var8;
               var47 = var41 - var10;
            }

            cz[var33] = var37;
            da[var33] = var39;
            db[var33] = var41;
            float var49 = df[var33] + dg[var33] * var0;
            if (var49 > (float) (Math.PI * 2)) {
               var49 -= (float) (Math.PI * 2);
            } else if (var49 < 0.0F) {
               var49 += (float) (Math.PI * 2);
            }

            df[var33] = var49;
            float var50 = dh[var33];
            float var51 = di[var33];
            float var52 = (float)var43;
            float var53 = (float)var45 + 0.08F * MathHelper.sin(var25 + (double)var51);
            float var54 = (float)var47;
            float var55 = var52 * var52 + var53 * var53 + var54 * var54;
            float var56 = var52 * var19 + var53 * var20 + var54 * var21;
            float var57 = 3.2F * var50;
            boolean var58 = var56 < -var57;
            if (!var58 && var22) {
               float var59 = var57 + var56 * var23;
               var58 = var59 < 0.0F || (var55 - var56 * var56) * var24 > var59 * var59;
            }

            if (var58) {
               dj[var33] = var36 + var0;
            } else {
               dj[var33] = var36;
               float var70 = MathHelper.sqrt(var55);
               float var60 = var36 / 1.2F;
               var60 = var60 > 1.0F ? 1.0F : var60;
               float var61 = (dk[var33] - var36) / 1.2F;
               var61 = var61 < 0.0F ? 0.0F : (var61 > 1.0F ? 1.0F : var61);
               float var62 = (var70 - 1.0F) / 1.5F;
               var62 = var62 < 0.0F ? 0.0F : (var62 > 1.0F ? 1.0F : var62);
               float var63 = (var70 - 22.0F) / 8.0F;
               var63 = var63 < 0.0F ? 0.0F : (var63 > 1.0F ? 1.0F : var63);
               float var64 = 0.75F + 0.25F * MathHelper.sin(var27 + (double)(var51 * 1.7F));
               float var65 = var1
                  * var35
                  * var64
                  * var60
                  * var60
                  * (3.0F - 2.0F * var60)
                  * var61
                  * var61
                  * (3.0F - 2.0F * var61)
                  * var62
                  * var62
                  * (3.0F - 2.0F * var62)
                  * (1.0F - var63 * var63 * (3.0F - 2.0F * var63));
               if (!(var65 < 0.004F)) {
                  if (var31 < (-1928035361 ^ -1928034337)) {
                     int var66 = var31++ * 8;
                     var29[var66] = var52;
                     var29[var66 + 1] = var53;
                     var29[var66 + 2] = var54;
                     var29[var66 + 3] = var50;
                     var29[var66 + 4] = var50;
                     var29[var66 + 5] = var49;
                     var29[var66 + 6] = 5.0F;
                     var29[var66 + 7] = Float.intBitsToFloat((int)(0.9F * var65 * 255.0F + 0.5F) << 24 | var18);
                  }

                  if (var32 < (-304937458 ^ -304933362)) {
                     int var75 = var32++ * 8;
                     var30[var75] = var52;
                     var30[var75 + 1] = var53;
                     var30[var75 + 2] = var54;
                     var30[var75 + 3] = 2.2F * var50;
                     var30[var75 + 4] = 2.2F * var50;
                     var30[var75 + 5] = 0.0F;
                     var30[var75 + 6] = 4.0F;
                     var30[var75 + 7] = Float.intBitsToFloat((int)(0.25F * var65 * 255.0F + 0.5F) << 24 | var2);
                  }
               }
            }
         }

         RegionPassCache.nST = var31;
         RegionPassCache.nSA = var32;
      } catch (RuntimeException var67) {
         throw var67;
      }
   }

   private static void l(int var0, boolean var1) {

      ClientWorld var2 = MinecraftClient.getInstance().world;
      if (var1) {
         j(cz, da, db, dc, dd, de, var0, (0.08F + al.nextFloat() * 0.17F) * 0.4F);
      } else {
         double var3 = RegionPassCache.z;
         double var5 = RegionPassCache.aa;
         double var7 = RegionPassCache.ab;
         float var9 = al.nextFloat() < 0.5F ? ax + (al.nextFloat() * 2.0F - 1.0F) * (ay + 0.17F) : al.nextFloat() * (float) (Math.PI * 2);
         float var10 = 5.0F + al.nextFloat() * 17.0F;
         double var11 = var3 + (double)(MathHelper.cos((double)var9) * var10);
         double var13 = var7 + (double)(MathHelper.sin((double)var9) * var10);
         int var15 = var2.getTopY(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MathHelper.floor(var11), MathHelper.floor(var13));
         double var16 = var15 <= var2.getBottomY() ? var5 - 1.6 : (double)var15;
         var16 = var16 < var5 - 6.0 ? var5 - 6.0 : (var16 > var5 + 6.0 ? var5 + 6.0 : var16);
         cz[var0] = var11;
         da[var0] = var16 + 2.0 + (double)(al.nextFloat() * 8.0F);
         db[var0] = var13;
         float var18 = al.nextFloat() * (float) (Math.PI * 2);
         float var19 = 0.08F + al.nextFloat() * 0.17F;
         dc[var0] = MathHelper.cos((double)var18) * var19;
         de[var0] = MathHelper.sin((double)var18) * var19;
         dd[var0] = (al.nextFloat() * 2.0F - 1.0F) * 0.05F;
      }

      float var20 = (25.0F + al.nextFloat() * 35.0F) * (float) (Math.PI / 180.0);
      dg[var0] = al.nextBoolean() ? var20 : -var20;
      df[var0] = al.nextFloat() * (float) (Math.PI * 2);
      float var4 = 0.12F + al.nextFloat() * 0.08F;
      dh[var0] = var1 ? var4 * 0.6F : var4;
      di[var0] = al.nextFloat() * (float) (Math.PI * 2);
      dk[var0] = 8.0F + al.nextFloat() * 6.0F;
      dj[var0] = 0.0F;
      cy[var0] = true;
   }

   private static void m(float var0, float var1, int var2, int var3, int var4, boolean var5) {

      assert var0 >= 0.0F
         && var0 <= 0.5F
         && var1 >= 0.0F
         && var1 <= 2.0F
         && var2 >= 0
         && var2 <= (1920299421 ^ 1921683042)
         && (var5 ? var3 == (1136606237 ^ 1136606401) && var4 == (908881316 ^ 908881032) : var3 == 0 && var4 == (501453250 ^ 501453086))
         && var3 >= 0
         && var3 < var4
         && var4 <= (906105811 ^ 906105599)
         && ds.length == (-1011416376 ^ -1011416092)
         && dt.length == (-450103637 ^ -450103417)
         && du.length == (-1994723546 ^ -1994723830)
         && dv.length == (-2094708150 ^ -2094707866)
         && dw.length == (1703098970 ^ 1703099254)
         && dx.length == (1701379986 ^ 1701379774)
         && dy.length == (-1454979802 ^ -1454980086)
         && dz.length == (-1929559051 ^ -1929559335)
         && ea.length == (219848453 ^ 219848233)
         && eb.length == (-1293996853 ^ -1293996569)
         && ec.length == (-1748237882 ^ -1748238102)
         && RegionPassCache.SA.length == (856337611 ^ 856304843) : "dust: b" + "a" + "d st" + "ate";

      try {
         double var6 = RegionPassCache.z;
         double var8 = RegionPassCache.aa;
         double var10 = RegionPassCache.ab;
         float var12 = (float)(var5 ? 40 : 110) * RegionPassCache.bn;
         float var13 = var5 ? bu : dr;
         var13 += (var12 - var13) * (1.0F - (float)Math.exp((double)(-var0 * 1.5F)));
         if (Math.abs(var12 - var13) < 0.001F) {
            var13 = var12;
         }

         if (var5) {
            bu = var13;
         } else {
            dr = var13;
         }

         float var14 = var0 / 0.5F;
         int var15 = var2 >> 16 & (-1781292251 ^ -1781292070);
         int var16 = var2 >> 8 & (1145828866 ^ 1145829117);
         int var17 = var2 & (84118841 ^ 84118982);
         int var18 = var15 + (int)((float)((2124505029 ^ 2124504890) - var15) * 0.3F + 0.5F) << 16
            | var16 + (int)((float)((1405001972 ^ 1405001739) - var16) * 0.3F + 0.5F) << 8
            | var17 + (int)((float)((666359470 ^ 666359377) - var17) * 0.3F + 0.5F);
         float var19 = RegionPassCache.fX;
         float var20 = RegionPassCache.fY;
         float var21 = RegionPassCache.fZ;
         boolean var22 = au && !var5;
         float var23 = av;
         float var24 = aw;
         double var25 = RegionPassCache.now;
         double var27 = var25 * 3.1;
         double var29 = var6;
         double var31 = var8;
         double var33 = var10;
         double var35 = 21.0;
         double var37 = 441.0;
         double var39 = 1600.0;
         double var41 = 30.0;
         float var43 = 17.0F;
         float var44 = 4.0F;
         float var45 = -3.0F;
         float var46 = 9.0F;
         float var47 = 1.2F;
         float var48 = 0.12F;
         if (var5) {
            var29 = RegionPassCache.pvX;
            var31 = 0.0;
            var33 = RegionPassCache.pvZ;
            var35 = 3.2;
            var37 = 10.240000000000002;
            var39 = 27.040000000000003;
            var41 = 8.0;
            var43 = 2.4F;
            var44 = 0.8F;
            var45 = 0.0F;
            var46 = 3.2F;
            var47 = 0.4F;
            var48 = 0.072000004F;
         }

         float[] var49 = RegionPassCache.SA;
         int var50 = RegionPassCache.nSA;

         for (int var51 = var3; var51 < var4; var51++) {
            boolean var52 = (float)(var51 - var3) < var13;
            float var53 = ec[var51] + (var52 ? var14 : -var14);
            var53 = var53 < 0.0F ? 0.0F : (var53 > 1.0F ? 1.0F : var53);
            ec[var51] = var53;
            if (!ds[var51]) {
               if (!var52) {
                  continue;
               }

               n(var51, var5);
            } else if (!var52 && var53 <= 0.0F) {
               ds[var51] = false;
               continue;
            }

            float var54 = dy[var51];
            float var55 = dx[var51];
            float var56 = var48 * MathHelper.sin(var25 * (double)var55 + (double)var54);
            float var57 = var48 * MathHelper.cos(var25 * (double)var55 * 1.13 + (double)(var54 * 1.7F));
            float var58 = ea[var51] + var0;
            double var59 = dt[var51] + (double)(var56 * var0);
            double var61 = du[var51] + (double)(dw[var51] * var0);
            double var63 = dv[var51] + (double)(var57 * var0);
            double var65 = var59 - var29;
            double var67 = var61 - var31;
            double var69 = var63 - var33;
            double var71 = var65 * var65 + var69 * var69;
            if (!(var58 >= eb[var51]) && !(var71 > var39) && !(var67 > var41) && !(var67 < -var41)) {
               if (var71 > var37) {
                  double var73 = Math.sqrt(var71);
                  double var75 = (0.01 - var35) / var73;
                  var65 *= var75;
                  var69 *= var75;
                  var59 = var29 + var65;
                  var63 = var33 + var69;
                  var71 = var65 * var65 + var69 * var69;
               }

               if (var67 >= (double)var46) {
                  var67 = (double)var45;
                  var61 = var31 + var67;
               } else if (var67 < (double)var45) {
                  var67 = (double)var46 - 0.001;
                  var61 = var31 + var67;
               }
            } else {
               if (!var52) {
                  ds[var51] = false;
                  continue;
               }

               n(var51, var5);
               var58 = 0.0F;
               var59 = dt[var51];
               var61 = du[var51];
               var63 = dv[var51];
               var65 = var59 - var29;
               var67 = var61 - var31;
               var69 = var63 - var33;
               var71 = var65 * var65 + var69 * var69;
            }

            dt[var51] = var59;
            du[var51] = var61;
            dv[var51] = var63;
            float var101 = dz[var51];
            boolean var74 = (var51 & 3) == 0;
            float var102 = (float)(var59 - var6);
            float var76 = (float)(var61 - var8);
            float var77 = (float)(var63 - var10);
            float var78 = (float)var67;
            float var79 = var102 * var102 + var76 * var76 + var77 * var77;
            float var80 = var102 * var19 + var76 * var20 + var77 * var21;
            float var81 = var74 ? 4.3F * var101 : 1.5F * var101;
            boolean var82 = var80 < -var81;
            if (!var82 && var22) {
               float var83 = var81 + var80 * var23;
               var82 = var83 < 0.0F || (var79 - var80 * var80) * var24 > var83 * var83;
            }

            if (var82) {
               ea[var51] = var58 + 2.0F * var0;
            } else {
               ea[var51] = var58;
               float var103 = MathHelper.sqrt(var79);
               float var84 = var58 / 0.8F;
               var84 = var84 > 1.0F ? 1.0F : var84;
               float var85 = (eb[var51] - var58) / 0.8F;
               var85 = var85 < 0.0F ? 0.0F : (var85 > 1.0F ? 1.0F : var85);
               float var86 = (var103 - 1.0F) / 1.5F;
               var86 = var86 < 0.0F ? 0.0F : (var86 > 1.0F ? 1.0F : var86);
               float var87 = (var103 - 22.0F) / 8.0F;
               var87 = var87 < 0.0F ? 0.0F : (var87 > 1.0F ? 1.0F : var87);
               float var88 = (MathHelper.sqrt((float)var71) - var43) / var44;
               var88 = var88 < 0.0F ? 0.0F : (var88 > 1.0F ? 1.0F : var88);
               float var89 = (var78 - var45) / var47;
               var89 = var89 < 0.0F ? 0.0F : (var89 > 1.0F ? 1.0F : var89);
               float var90 = (var46 - var78) / var47;
               var90 = var90 < 0.0F ? 0.0F : (var90 > 1.0F ? 1.0F : var90);
               float var91 = 0.55F + 0.45F * (0.5F + 0.5F * MathHelper.sin(var27 + (double)var54));
               float var92 = var1
                  * var53
                  * var91
                  * var84
                  * var84
                  * (3.0F - 2.0F * var84)
                  * var85
                  * var85
                  * (3.0F - 2.0F * var85)
                  * var86
                  * var86
                  * (3.0F - 2.0F * var86)
                  * (1.0F - var87 * var87 * (3.0F - 2.0F * var87))
                  * (1.0F - var88 * var88 * (3.0F - 2.0F * var88))
                  * var89
                  * var89
                  * (3.0F - 2.0F * var89)
                  * var90
                  * var90
                  * (3.0F - 2.0F * var90);
               if (!(var92 < 0.004F)) {
                  if (var74 && var50 < (-721969522 ^ -721973618)) {
                     int var93 = var50++ * 8;
                     var49[var93] = var102;
                     var49[var93 + 1] = var76;
                     var49[var93 + 2] = var77;
                     var49[var93 + 3] = 3.0F * var101;
                     var49[var93 + 4] = 3.0F * var101;
                     var49[var93 + 5] = 0.0F;
                     var49[var93 + 6] = 4.0F;
                     var49[var93 + 7] = Float.intBitsToFloat((int)(0.3F * var92 * 255.0F + 0.5F) << 24 | var18);
                  }

                  if (var50 < (441389827 ^ 441385731)) {
                     int var111 = var50++ * 8;
                     var49[var111] = var102;
                     var49[var111 + 1] = var76;
                     var49[var111 + 2] = var77;
                     var49[var111 + 3] = var101;
                     var49[var111 + 4] = var101;
                     var49[var111 + 5] = 0.0F;
                     var49[var111 + 6] = 3.0F;
                     var49[var111 + 7] = Float.intBitsToFloat((int)(0.95F * var92 * 255.0F + 0.5F) << 24 | var18);
                  }
               }
            }
         }

         RegionPassCache.nSA = var50;
      } catch (RuntimeException var94) {
         throw var94;
      }
   }

   private static void n(int var0, boolean var1) {

      if (var1) {
         float var2 = al.nextFloat() * (float) (Math.PI * 2);
         float var3 = MathHelper.sqrt(0.25F + al.nextFloat() * 9.99F);
         dt[var0] = RegionPassCache.pvX + (double)(MathHelper.cos((double)var2) * var3);
         du[var0] = (double)(al.nextFloat() * 3.2F);
         dv[var0] = RegionPassCache.pvZ + (double)(MathHelper.sin((double)var2) * var3);
         dw[var0] = (0.05F + al.nextFloat() * 0.13F) * 0.6F;
      } else {
         double var10 = RegionPassCache.z;
         double var4 = RegionPassCache.aa;
         double var6 = RegionPassCache.ab;
         float var8 = al.nextFloat() < 0.7F ? ax + (al.nextFloat() * 2.0F - 1.0F) * (ay + 0.17F) : al.nextFloat() * (float) (Math.PI * 2);
         float var9 = MathHelper.sqrt(9.0F + al.nextFloat() * 391.0F);
         dt[var0] = var10 + (double)(MathHelper.cos((double)var8) * var9);
         du[var0] = var4 - 3.0 + (double)(al.nextFloat() * 12.0F);
         dv[var0] = var6 + (double)(MathHelper.sin((double)var8) * var9);
         dw[var0] = 0.05F + al.nextFloat() * 0.13F;
      }

      dx[var0] = 0.35F + al.nextFloat() * 0.55F;
      dy[var0] = al.nextFloat() * (float) (Math.PI * 2);
      float var11 = 0.056F + al.nextFloat() * 0.054F;
      dz[var0] = var1 ? var11 * 0.6F : var11;
      eb[var0] = 5.0F + al.nextFloat() * 4.0F;
      ea[var0] = 0.0F;
      ds[var0] = true;
   }

   private static void o(float var0, float var1, int var2, boolean var3, int var4, int var5, boolean var6) {

      assert var0 >= 0.0F
         && var0 <= 0.5F
         && var1 >= 0.0F
         && var1 <= 2.0F
         && var2 >= 0
         && var2 <= (1411120040 ^ 1424229463)
         && (var6 ? var4 == 3 && var5 == 5 : var4 == 0 && var5 == 3)
         && var4 >= 0
         && var4 < var5
         && var5 <= 5
         && eh.length == 5
         && ei.length == 5
         && ej.length == 5
         && ek.length == 5
         && el.length == 5
         && em.length == 5
         && en.length == 5
         && eo.length == 5
         && ep.length == 5
         && eq.length == 5
         && RegionPassCache.LA.length == (1669817636 ^ 1669727524)
         && RegionPassCache.SA.length == (292117895 ^ 292150663) : "c" + "omets:" + " bad" + " state";

      try {
         double var7 = RegionPassCache.z;
         double var9 = RegionPassCache.aa;
         double var11 = RegionPassCache.ab;
         float var13 = var6 ? bx : eg;
         var13 += (RegionPassCache.bn - var13) * (1.0F - (float)Math.exp((double)(-var0 * 1.5F)));
         if (var6) {
            bx = var13;
         } else {
            eg = var13;
         }

         if (var3) {
            float var14 = (var6 ? bw : ef) - var0;
            if (var14 <= 0.0F) {
               int var15 = -1;

               for (int var16 = var4; var16 < var5; var16++) {
                  if (!eh[var16]) {
                     var15 = var16;
                     break;
                  }
               }

               if (var15 >= 0) {
                  p(var15, var6);
                  var14 = (1.4F + al.nextFloat() * 1.8F) / (var13 < 0.1F ? 0.1F : var13);
               }
            }

            if (var6) {
               bw = var14;
            } else {
               ef = var14;
            }
         }

         int var59 = var2 >> 16 & (625716736 ^ 625716991);
         int var60 = var2 >> 8 & (-1073738902 ^ -1073738859);
         int var61 = var2 & (1882505900 ^ 1882505811);
         int var17 = var59 + (int)((float)((1660596842 ^ 1660596885) - var59) * 0.3F + 0.5F) << 16
            | var60 + (int)((float)((56029195 ^ 56029428) - var60) * 0.3F + 0.5F) << 8
            | var61 + (int)((float)((-1462303135 ^ -1462303074) - var61) * 0.3F + 0.5F);
         float var18 = RegionPassCache.fX;
         float var19 = RegionPassCache.fY;
         float var20 = RegionPassCache.fZ;
         boolean var21 = au && !var6;
         float var22 = av;
         float var23 = aw;
         float var24 = var6 ? 1.2F : 2.2F;
         float var25 = var6 ? 0.45F : 1.0F;
         float[] var26 = RegionPassCache.LA;
         float[] var27 = RegionPassCache.SA;
         int var28 = RegionPassCache.nLA;
         int var29 = RegionPassCache.nSA;

         for (int var30 = var4; var30 < var5; var30++) {
            if (eh[var30]) {
               float var31 = ep[var30] + var0;
               float var32 = eq[var30];
               if (var31 >= var32) {
                  eh[var30] = false;
               } else {
                  ep[var30] = var31;
                  float var33 = eo[var30] * var31;
                  float var34 = el[var30];
                  float var35 = em[var30];
                  float var36 = en[var30];
                  float var37 = (float)(ei[var30] + (double)(var34 * var33) - var7);
                  float var38 = (float)(ej[var30] + (double)(var35 * var33) - var9);
                  float var39 = (float)(ek[var30] + (double)(var36 * var33) - var11);
                  float var40 = var31 < 0.2F ? var24 * var31 / 0.2F : var24;
                  float var41 = var37 - var34 * var40;
                  float var42 = var38 - var35 * var40;
                  float var43 = var39 - var36 * var40;
                  float var44 = 0.5F * (var37 + var41);
                  float var45 = 0.5F * (var38 + var42);
                  float var46 = 0.5F * (var39 + var43);
                  float var47 = var44 * var44 + var45 * var45 + var46 * var46;
                  float var48 = var44 * var18 + var45 * var19 + var46 * var20;
                  float var49 = 0.5F * var40 + 0.5F;
                  if (!(var48 < -var49)) {
                     if (var21) {
                        float var50 = var49 + var48 * var22;
                        if (var50 < 0.0F || (var47 - var48 * var48) * var23 > var50 * var50) {
                           continue;
                        }
                     }

                     float var62 = MathHelper.sqrt(var37 * var37 + var38 * var38 + var39 * var39);
                     float var51 = var31 / 0.12F;
                     var51 = var51 > 1.0F ? 1.0F : var51;
                     float var52 = (var32 - var31) / 0.3F;
                     var52 = var52 < 0.0F ? 0.0F : (var52 > 1.0F ? 1.0F : var52);
                     float var53 = (var62 - 1.0F) / 1.5F;
                     var53 = var53 < 0.0F ? 0.0F : (var53 > 1.0F ? 1.0F : var53);
                     float var54 = (var62 - 22.0F) / 8.0F;
                     var54 = var54 < 0.0F ? 0.0F : (var54 > 1.0F ? 1.0F : var54);
                     float var55 = var1
                        * var51
                        * var51
                        * (3.0F - 2.0F * var51)
                        * var52
                        * var52
                        * (3.0F - 2.0F * var52)
                        * var53
                        * var53
                        * (3.0F - 2.0F * var53)
                        * (1.0F - var54 * var54 * (3.0F - 2.0F * var54));
                     if (!(var55 < 0.004F)) {
                        if (var28 < (1777690559 ^ 1777682367)) {
                           int var56 = var28++ * 11;
                           var26[var56] = var37;
                           var26[var56 + 1] = var38;
                           var26[var56 + 2] = var39;
                           var26[var56 + 3] = var41;
                           var26[var56 + 4] = var42;
                           var26[var56 + 5] = var43;
                           var26[var56 + 6] = 0.16F * var25;
                           var26[var56 + 7] = 0.0F;
                           var26[var56 + 8] = Float.intBitsToFloat((int)(0.85F * var55 * 255.0F + 0.5F) << 24 | var2);
                           var26[var56 + 9] = Float.intBitsToFloat(var2);
                           var26[var56 + 10] = 2.0F;
                        }

                        if (var29 < (1805155340 ^ 1805151244)) {
                           int var67 = var29++ * 8;
                           var27[var67] = var37;
                           var27[var67 + 1] = var38;
                           var27[var67 + 2] = var39;
                           var27[var67 + 3] = 0.35F * var25;
                           var27[var67 + 4] = 0.35F * var25;
                           var27[var67 + 5] = 0.0F;
                           var27[var67 + 6] = 4.0F;
                           var27[var67 + 7] = Float.intBitsToFloat((int)(0.9F * var55 * 255.0F + 0.5F) << 24 | var17);
                        }

                        if (var29 < (-1103055788 ^ -1103059884)) {
                           int var68 = var29++ * 8;
                           var27[var68] = var37;
                           var27[var68 + 1] = var38;
                           var27[var68 + 2] = var39;
                           var27[var68 + 3] = 0.07F * var25;
                           var27[var68 + 4] = 0.07F * var25;
                           var27[var68 + 5] = 0.0F;
                           var27[var68 + 6] = 3.0F;
                           var27[var68 + 7] = Float.intBitsToFloat((int)(var55 * 255.0F + 0.5F) << 24 | 929573310 ^ 932697665);
                        }
                     }
                  }
               }
            }
         }

         RegionPassCache.nLA = var28;
         RegionPassCache.nSA = var29;
      } catch (RuntimeException var57) {
         throw var57;
      }
   }

   private static void p(int var0, boolean var1) {

      if (var1) {
         float var2 = RegionPassCache.rX;
         float var3 = RegionPassCache.rZ;
         float var4 = al.nextBoolean() ? 1.0F : -1.0F;
         float var5 = 2.5F + al.nextFloat() * 0.7F;
         float var6 = MathHelper.sqrt(19.36F - var5 * var5);
         ei[var0] = RegionPassCache.pvX + (double)(var3 * var5) - (double)(var4 * var2 * var6);
         ej[var0] = (double)(2.4F + al.nextFloat() * 0.8F);
         ek[var0] = RegionPassCache.pvZ - (double)(var2 * var5) - (double)(var4 * var3 * var6);
         float var7 = -(0.08F + al.nextFloat() * 0.12F);
         float var8 = MathHelper.sqrt(1.0F + var7 * var7);
         el[var0] = var4 * var2 / var8;
         em[var0] = var7 / var8;
         en[var0] = var4 * var3 / var8;
         float var9 = 3.2F + al.nextFloat() * 0.6F;
         eo[var0] = var9;
         eq[var0] = 2.0F * var6 * var8 / var9;
      } else {
         double var15 = RegionPassCache.z;
         double var16 = RegionPassCache.aa;
         double var17 = RegionPassCache.ab;
         float var18 = ax + (al.nextFloat() * 2.0F - 1.0F) * 70.0F * (float) (Math.PI / 180.0);
         float var19 = 3.0F + al.nextFloat() * 11.0F;
         float var10 = 10.0F + al.nextFloat() * 18.0F;
         if (var10 < var19 + 1.0F) {
            var10 = var19 + 1.0F;
         }

         float var11 = MathHelper.sqrt(var10 * var10 - var19 * var19);
         ei[var0] = var15 + (double)(MathHelper.cos((double)var18) * var11);
         ej[var0] = var16 + (double)var19;
         ek[var0] = var17 + (double)(MathHelper.sin((double)var18) * var11);
         float var12 = al.nextFloat() * (float) (Math.PI * 2);
         float var13 = -(0.15F + al.nextFloat() * 0.4F);
         float var14 = MathHelper.sqrt(1.0F + var13 * var13);
         el[var0] = MathHelper.cos((double)var12) / var14;
         em[var0] = var13 / var14;
         en[var0] = MathHelper.sin((double)var12) / var14;
         eo[var0] = 7.0F + al.nextFloat() * 4.0F;
         eq[var0] = 0.9F + al.nextFloat() * 0.6F;
      }

      ep[var0] = 0.0F;
      eh[var0] = true;
   }

   private static void q(float var0, float var1, int var2, int var3, int var4, boolean var5) {

      assert var0 >= 0.0F
         && var0 <= 0.5F
         && var1 >= 0.0F
         && var1 <= 2.0F
         && var2 >= 0
         && var2 <= (-1106616288 ^ -1091199009)
         && (var5 ? var3 == 16 && var4 == 22 : var3 == 0 && var4 == 16)
         && var3 >= 0
         && var3 < var4
         && var4 <= 22
         && ey.length == 22
         && ez.length == (225941847 ^ 225941603)
         && fa.length == (1068082688 ^ 1068082996)
         && fb.length == (527923765 ^ 527923969)
         && fc.length == (941041474 ^ 941041270)
         && fd.length == 22
         && fe.length == 22
         && ff.length == 22
         && fg.length == 22
         && fh.length == 22
         && fi.length == 22
         && RegionPassCache.LA.length == (1171744163 ^ 1171654051)
         && RegionPassCache.SA.length == (86720160 ^ 86752928) : "line" + "s:" + " bad state";

      try {
         double var6 = RegionPassCache.z;
         double var8 = RegionPassCache.aa;
         double var10 = RegionPassCache.ab;
         float var12 = (float)(var5 ? 3 : 8) * RegionPassCache.bn;
         float var13 = var5 ? bv : ex;
         var13 += (var12 - var13) * (1.0F - (float)Math.exp((double)(-var0 * 1.5F)));
         if (Math.abs(var12 - var13) < 0.001F) {
            var13 = var12;
         }

         if (var5) {
            bv = var13;
         } else {
            ex = var13;
         }

         float var14 = var0 / 0.5F;
         int var15 = var2 >> 16 & (-1777785568 ^ -1777785377);
         int var16 = var2 >> 8 & (281559850 ^ 281560021);
         int var17 = var2 & (1231274085 ^ 1231274138);
         int var18 = var15 + (int)((float)((1246989898 ^ 1246990005) - var15) * 0.25F + 0.5F) << 16
            | var16 + (int)((float)((-1246802683 ^ -1246802438) - var16) * 0.25F + 0.5F) << 8
            | var17 + (int)((float)((-1950435072 ^ -1950434817) - var17) * 0.25F + 0.5F);
         float var19 = RegionPassCache.fX;
         float var20 = RegionPassCache.fY;
         float var21 = RegionPassCache.fZ;
         boolean var22 = au && !var5;
         float var23 = av;
         float var24 = aw;
         float var25 = var5 ? 4.5F : 14.0F;
         float var26 = var5 ? 0.04F : 0.06F;
         float var27 = var5 ? 0.11F : 0.18F;
         float[] var28 = RegionPassCache.LA;
         float[] var29 = RegionPassCache.SA;
         int var30 = RegionPassCache.nLA;
         int var31 = RegionPassCache.nSA;

         for (int var32 = var3; var32 < var4; var32++) {
            boolean var33 = (float)(var32 - var3) < var13;
            float var34 = fi[var32] + (var33 ? var14 : -var14);
            var34 = var34 < 0.0F ? 0.0F : (var34 > 1.0F ? 1.0F : var34);
            fi[var32] = var34;
            if (!ey[var32]) {
               if (!var33) {
                  continue;
               }

               r(var32, var5);
            } else if (!var33 && var34 <= 0.0F) {
               ey[var32] = false;
               continue;
            }

            float var35 = ff[var32] + var0;
            float var36 = fe[var32];
            float var37 = var36 / var25;
            float var38 = var37 + fg[var32];
            float var39 = var38 + 0.8F;
            double var40 = ez[var32 * 14] - var6;
            double var42 = fb[var32 * 14] - var10;
            if (var35 >= var39 + fh[var32] || var40 * var40 + var42 * var42 > 2116.0) {
               if (!var33) {
                  ey[var32] = false;
                  continue;
               }

               r(var32, var5);
               var35 = 0.0F;
               var36 = fe[var32];
               var37 = var36 / var25;
               var38 = var37 + fg[var32];
               var39 = var38 + 0.8F;
            }

            if (var35 >= var39) {
               ff[var32] = var35;
            } else {
               float var44 = 1.0F;
               if (var35 > var38) {
                  float var45 = 1.0F - (var35 - var38) / 0.8F;
                  var45 = var45 < 0.0F ? 0.0F : var45;
                  var44 = var45 * var45 * (3.0F - 2.0F * var45);
               }

               float var93 = var1 * var34 * var44 * 0.85F;
               float var46 = var35 * var25;
               if (var46 > var36) {
                  var46 = var36;
               }

               int var47 = var32 * 14;
               int var48 = fd[var32];
               boolean var49 = false;
               float var50 = 0.0F;
               float var51 = 0.0F;
               float var52 = 0.0F;
               float var53 = (float)(ez[var47] - var6);
               float var54 = (float)(fa[var47] - var8);
               float var55 = (float)(fb[var47] - var10);

               for (int var56 = 1; var56 < var48; var56++) {
                  float var57 = fc[var47 + var56 - 1];
                  if (var57 >= var46) {
                     break;
                  }

                  float var58 = fc[var47 + var56];
                  float var59 = (float)(ez[var47 + var56] - var6);
                  float var60 = (float)(fa[var47 + var56] - var8);
                  float var61 = (float)(fb[var47 + var56] - var10);
                  float var62 = var59;
                  float var63 = var60;
                  float var64 = var61;
                  if (var58 > var46) {
                     float var65 = (var46 - var57) / (var58 - var57);
                     var62 = var53 + (var59 - var53) * var65;
                     var63 = var54 + (var60 - var54) * var65;
                     var64 = var55 + (var61 - var55) * var65;
                  }

                  var50 = var62;
                  var51 = var63;
                  var52 = var64;
                  float var103 = var62 - var53;
                  float var66 = var63 - var54;
                  float var67 = var64 - var55;
                  float var68 = var53;
                  float var69 = var54;
                  float var70 = var55;
                  var53 = var59;
                  var54 = var60;
                  var55 = var61;
                  float var71 = var68 + var103 * 0.5F;
                  float var72 = var69 + var66 * 0.5F;
                  float var73 = var70 + var67 * 0.5F;
                  float var74 = 0.5F * (Math.abs(var103) + Math.abs(var66) + Math.abs(var67)) + 0.1F;
                  float var75 = var71 * var71 + var72 * var72 + var73 * var73;
                  float var76 = var71 * var19 + var72 * var20 + var73 * var21;
                  if (!(var76 < -var74)) {
                     if (var22) {
                        float var77 = var74 + var76 * var23;
                        if (var77 < 0.0F || (var75 - var76 * var76) * var24 > var77 * var77) {
                           continue;
                        }
                     }

                     var49 = true;
                     if (!(var93 < 0.004F)) {
                        float var104 = var103 * var103 + var66 * var66 + var67 * var67;
                        float var78 = var104 > 1.0E-6F ? -(var68 * var103 + var69 * var66 + var70 * var67) / var104 : 0.0F;
                        var78 = var78 < 0.0F ? 0.0F : (var78 > 1.0F ? 1.0F : var78);
                        float var79 = var68 + var103 * var78;
                        float var80 = var69 + var66 * var78;
                        float var81 = var70 + var67 * var78;
                        float var82 = (MathHelper.sqrt(var79 * var79 + var80 * var80 + var81 * var81) - 1.0F) / 1.5F;
                        var82 = var82 < 0.0F ? 0.0F : (var82 > 1.0F ? 1.0F : var82);
                        float var83 = var93 * var82 * var82 * (3.0F - 2.0F * var82);
                        float var84 = (MathHelper.sqrt(var68 * var68 + var69 * var69 + var70 * var70) - 22.0F) / 8.0F;
                        var84 = var84 < 0.0F ? 0.0F : (var84 > 1.0F ? 1.0F : var84);
                        float var85 = (MathHelper.sqrt(var62 * var62 + var63 * var63 + var64 * var64) - 22.0F) / 8.0F;
                        var85 = var85 < 0.0F ? 0.0F : (var85 > 1.0F ? 1.0F : var85);
                        float var86 = var83 * (1.0F - var84 * var84 * (3.0F - 2.0F * var84));
                        float var87 = var83 * (1.0F - var85 * var85 * (3.0F - 2.0F * var85));
                        if ((!(var86 < 0.004F) || !(var87 < 0.004F)) && var30 < (-884831976 ^ -884823784)) {
                           int var88 = var30++ * 11;
                           var28[var88] = var68;
                           var28[var88 + 1] = var69;
                           var28[var88 + 2] = var70;
                           var28[var88 + 3] = var62;
                           var28[var88 + 4] = var63;
                           var28[var88 + 5] = var64;
                           var28[var88 + 6] = var26;
                           var28[var88 + 7] = var26;
                           var28[var88 + 8] = Float.intBitsToFloat((int)(var86 * 255.0F + 0.5F) << 24 | var18);
                           var28[var88 + 9] = Float.intBitsToFloat((int)(var87 * 255.0F + 0.5F) << 24 | var18);
                           var28[var88 + 10] = 1.0F;
                        }
                     }
                  }
               }

               if (!var49) {
                  var35 += 2.0F * var0;
               }

               ff[var32] = var35;
               float var94 = var35 < var37 ? var35 / 0.1F : 1.0F - (var35 - var37) / 0.2F;
               var94 = var94 > 1.0F ? 1.0F : var94;
               if (var49 && var94 > 0.0F && var46 > 0.0F && var31 < (-2090518332 ^ -2090522428)) {
                  float var96 = MathHelper.sqrt(var50 * var50 + var51 * var51 + var52 * var52);
                  float var97 = (var96 - 1.0F) / 1.5F;
                  var97 = var97 < 0.0F ? 0.0F : (var97 > 1.0F ? 1.0F : var97);
                  float var99 = (var96 - 22.0F) / 8.0F;
                  var99 = var99 < 0.0F ? 0.0F : (var99 > 1.0F ? 1.0F : var99);
                  float var101 = 0.9F * var1 * var34 * var94 * var97 * var97 * (3.0F - 2.0F * var97) * (1.0F - var99 * var99 * (3.0F - 2.0F * var99));
                  if (var101 >= 0.004F) {
                     int var102 = var31++ * 8;
                     var29[var102] = var50;
                     var29[var102 + 1] = var51;
                     var29[var102 + 2] = var52;
                     var29[var102 + 3] = var27;
                     var29[var102 + 4] = var27;
                     var29[var102 + 5] = 0.0F;
                     var29[var102 + 6] = 4.0F;
                     var29[var102 + 7] = Float.intBitsToFloat((int)(var101 * 255.0F + 0.5F) << 24 | var18);
                  }
               }
            }
         }

         RegionPassCache.nLA = var30;
         RegionPassCache.nSA = var31;
      } catch (RuntimeException var89) {
         throw var89;
      }
   }

   private static void r(int var0, boolean var1) {

      ClientWorld var2 = MinecraftClient.getInstance().world;
      float var10 = 0.0F;
      double var3;
      double var5;
      double var7;
      int var9;
      if (var1) {
         float var11 = al.nextFloat() * (float) (Math.PI * 2);
         var10 = 1.8F + al.nextFloat() * 1.4F;
         var3 = RegionPassCache.pvX + (double)(MathHelper.cos((double)var11) * var10);
         var5 = 0.0;
         var7 = RegionPassCache.pvZ + (double)(MathHelper.sin((double)var11) * var10);
         var9 = 4;
      } else {
         double var26 = RegionPassCache.z;
         double var13 = RegionPassCache.aa;
         double var15 = RegionPassCache.ab;
         float var17 = al.nextFloat() < 0.8F ? ax + (al.nextFloat() * 2.0F - 1.0F) * (ay + 0.17F) : al.nextFloat() * (float) (Math.PI * 2);
         float var18 = 5.0F + al.nextFloat() * 19.0F;
         var3 = var26 + (double)(MathHelper.cos((double)var17) * var18);
         var7 = var15 + (double)(MathHelper.sin((double)var17) * var18);
         int var19 = var2.getTopY(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MathHelper.floor(var3), MathHelper.floor(var7));
         var5 = var19 <= var2.getBottomY() ? var13 - 1.6 : (double)var19 - 0.02;
         var9 = 4 + al.nextInt(4);
      }

      int var27 = var0 * 14;
      int var12 = 1;
      float var28 = 0.0F;
      ez[var27] = var3;
      fa[var27] = var5;
      fb[var27] = var7;
      fc[var27] = 0.0F;

      for (int var14 = 0; var14 < var9; var14++) {
         float var29 = var1 ? 0.3F + al.nextFloat() * 0.7F : 1.5F + al.nextFloat() * 3.5F;
         var5 += (double)var29;
         var28 += var29;
         ez[var27 + var12] = var3;
         fa[var27 + var12] = var5;
         fb[var27 + var12] = var7;
         fc[var27 + var12] = var28;
         var12++;
         if (var14 < var9 - 1) {
            float var16 = var1 ? 0.2F + al.nextFloat() * 0.4F : 0.6F + al.nextFloat() * 1.9F;
            var28 += var16;
            if (al.nextBoolean()) {
               var16 = -var16;
            }

            boolean var30 = al.nextBoolean();
            if (var1) {
               double var31 = var3 - RegionPassCache.pvX;
               double var20 = var7 - RegionPassCache.pvZ;
               double var22 = var30
                  ? Math.sqrt((var31 + (double)var16) * (var31 + (double)var16) + var20 * var20)
                  : Math.sqrt(var31 * var31 + (var20 + (double)var16) * (var20 + (double)var16));
               double var24 = var30
                  ? Math.sqrt((var31 - (double)var16) * (var31 - (double)var16) + var20 * var20)
                  : Math.sqrt(var31 * var31 + (var20 - (double)var16) * (var20 - (double)var16));
               if (Math.abs(var24 - (double)var10) < Math.abs(var22 - (double)var10)) {
                  var16 = -var16;
               }
            }

            if (var30) {
               var3 += (double)var16;
            } else {
               var7 += (double)var16;
            }

            ez[var27 + var12] = var3;
            fa[var27 + var12] = var5;
            fb[var27 + var12] = var7;
            fc[var27 + var12] = var28;
            var12++;
         }
      }

      fd[var0] = var12;
      fe[var0] = var28;
      fg[var0] = 1.0F + al.nextFloat() * 1.5F;
      fh[var0] = al.nextFloat() * 1.5F;
      ff[var0] = 0.0F;
      ey[var0] = true;
   }
}
