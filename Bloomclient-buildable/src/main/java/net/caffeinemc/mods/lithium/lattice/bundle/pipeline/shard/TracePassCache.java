package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;

public final class TracePassCache {
   public static final int RING_NEON = 0;
   public static final int RING_RIPPLE = 1;
   private static final float o = 0.18F;
   private static final float p = 0.22F;
   private static final int q = 3;
   private static final int r = 4;
   private static final int s = 6;
   private static final int t = 7;
   private static final int u = 9;
   private static final int v = 17;
   private static final int w = 18;
   private static final int x = 20;
   private static final float y = 0.9F;
   private static final float z = (float) Math.PI;
   private static final float aa = (float) (Math.PI * 2);
   private static final float ab = (float) (Math.PI / 2);
   private static final float ac = 0.045F;
   private static final float ad = 0.82F;
   private static final int ae = 13;
   private static final int af = 13;
   private static final int ag = 128;
   private static final int ah = 127;
   private static final int ai = 72;
   private static final double[] aj = new double[1792];
   private static final double[] ak = new double[1792];
   private static final double[] al = new double[1792];
   private static final double[] am = new double[1792];
   private static final double[] an = new double[1792];
   private static final double[] ao = new double[1792];
   private static final int[] ap = new int[1792];
   private static final int[] aq = new int[14];
   private static final int[] ar = new int[14];
   private static final int[] as = new int[14];
   private static final int[] at = new int[14];
   private static final int[] au = new int[14];
   private static final boolean[] av = new boolean[14];
   private static final boolean[] aw = new boolean[14];
   private static final double[] ax = new double[14];
   private static final double[] ay = new double[14];
   private static final double[] az = new double[14];
   private static final double[] ba = new double[14];
   private static final float[] bb = new float[14];
   private static final float[] bc = new float[14];
   private static final float[] bd = new float[14];
   private static final float[] be = new float[14];
   private static final float[] bf = new float[14];
   private static final double[] bg = new double[12];
   private static final int[] bh = new int[12];
   private static float bi;
   private static float bj;
   private static float bk;
   private static float bl = -1.0F;
   private static float bm;
   private static float bn;
   private static float bo;
   private static float bp;
   private static boolean bq;
   private static boolean br;
   private static int bs;
   private static int bt = -1;
   private static double bu;
   private static final int bv = 96;
   private static final int bw = 32;
   private static final double[] bx = new double[128];
   private static final double[] by = new double[128];
   private static final double[] bz = new double[128];
   private static final float[] ca = new float[128];
   private static final float[] cb = new float[128];
   private static final int[] cc = new int[128];
   private static final boolean[] cd = new boolean[128];
   private static int ce;
   private static int cf;
   private static int cg;
   private static int ch;
   private static final int ci = 12;
   private static final int cj = 12;
   private static final double[] ck = new double[24];
   private static final double[] cl = new double[24];
   private static final double[] cm = new double[24];
   private static final float[] cn = new float[24];
   private static final float[] co = new float[24];
   private static final float[] cp = new float[24];
   private static final float[] cq = new float[24];
   private static final float[] cr = new float[24];
   private static final float[] cs = new float[24];
   private static final int[] ct = new int[24];
   private static final int[] cu = new int[24];
   private static final boolean[] cv = new boolean[24];
   private static int cw;
   private static int cx;
   private static final int cy = 32;
   private static final float[] cz = new float[33];
   private static final float[] da = new float[33];
   private static final int[] db = new int[33];
   private static final int dc = 96;
   private static final int dd = 96;
   private static final int de = 0;
   private static final int df = 1;
   private static final int dg = 2;
   private static final int dh = 3;
   private static final double[] di = new double[192];
   private static final double[] dj = new double[192];
   private static final double[] dk = new double[192];
   private static final float[] dl = new float[192];
   private static final float[] dm = new float[192];
   private static final float[] dn = new float[192];
   private static final float[] _kwren_do= new float[192];
   private static final float[] dp = new float[192];
   private static final float[] dq = new float[192];
   private static final float[] dr = new float[192];
   private static final float[] ds = new float[192];
   private static final float[] dt = new float[192];
   private static final float[] du = new float[192];
   private static final int[] dv = new int[192];
   private static final boolean[] dw = new boolean[192];
   private static int dx;
   private static int dy;
   private static int dz;
   private static int ea;
   private static int ec = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   private TracePassCache() {
   }

   public static void a(double var0, double var2, double var4, float var6, int var7, float var8, float var9, int var10, float var11) {
      byte var12 = 0;

      while (true) {
         switch (var12) {
            case 0:
            default:
               if (ec != 0) {
                  System.nanoTime();
                  var12 = 1;
                  break;
               }
            case 1:
               if (c(var0, var2, var4, var6, var7, var8, var9, var10, var11, 0, 12)) {
                  cw = 12;
                  var12 = 2;
                  break;
               }

               return;
            case 2:
               return;
         }
      }
   }

   public static void b(double var0, double var2, double var4, float var6, int var7, float var8, float var9, int var10, float var11) {

      if (RegionPassCache.PV && c(var0, var2, var4, var6, var7, var8, var9, var10, var11, 12, 24)) {
         cx = 12;
      }
   }

   private static boolean c(double var0, double var2, double var4, float var6, int var7, float var8, float var9, int var10, float var11, int var12, int var13) {

      if (var9 > 0.0F && var6 > 0.0F && var8 > 0.0F && !Double.isNaN(var0 + var2 + var4) && !Float.isNaN(var11)) {
         int var14 = var12;
         float var15 = -1.0E9F;

         for (int var16 = var12; var16 < var13; var16++) {
            if (!cv[var16]) {
               var14 = var16;
               break;
            }

            float var17 = cn[var16] / co[var16];
            if (var17 > var15) {
               var15 = var17;
               var14 = var16;
            }
         }

         ck[var14] = var0;
         cl[var14] = var2 + 0.015;
         cm[var14] = var4;
         cn[var14] = -Math.max(-250.0F, Math.min(5000.0F, var11)) * 0.001F;
         co[var14] = Math.max(0.05F, var8 * 0.001F);
         cp[var14] = Math.min(var9, 16.0F);
         cq[var14] = Math.min(var6, 8.0F);
         ct[var14] = var7 == 1 ? 1 : 0;
         cu[var14] = var10;
         cr[var14] = ThreadLocalRandom.current().nextFloat() * (float) (Math.PI * 2);
         float var18 = 0.3F * RegionPassCache.cb;
         cs[var14] = 1.0F - (var18 < 0.12F ? 0.12F : (var18 > 0.9F ? 0.9F : var18));
         cv[var14] = true;
         return true;
      } else {
         return false;
      }
   }

   public static void hit(LivingEntity var0) {

      if (var0 != null && RegionPassCache.bd) {
         MinecraftClient var1 = MinecraftClient.getInstance();
         ClientPlayerEntity var2 = var1.player;
         if (var2 != null && var0 != var2 && RegionPassCache.l(var0, true)) {
            float var3 = RegionPassCache.td;
            float var4 = var0.getHeight();
            double var5 = var0.lastRenderX + (var0.getX() - var0.lastRenderX) * (double)var3;
            double var7 = var0.lastRenderY + (var0.getY() - var0.lastRenderY) * (double)var3 + 0.62 * (double)var4;
            double var9 = var0.lastRenderZ + (var0.getZ() - var0.lastRenderZ) * (double)var3;
            if (!Double.isNaN(var5 + var7 + var9)) {
               double var11 = var5 - (var2.lastRenderX + (var2.getX() - var2.lastRenderX) * (double)var3);
               double var13 = var7 - (var2.lastRenderY + (var2.getY() - var2.lastRenderY) * (double)var3 + (double)var2.getStandingEyeHeight());
               double var15 = var9 - (var2.lastRenderZ + (var2.getZ() - var2.lastRenderZ) * (double)var3);
               double var17 = Math.sqrt(var11 * var11 + var13 * var13 + var15 * var15);
               if (!(var17 >= 1.0E-4)) {
                  var11 = (double)RegionPassCache.fX;
                  var13 = (double)RegionPassCache.fY;
                  var15 = (double)RegionPassCache.fZ;
               } else {
                  var11 /= var17;
                  var13 /= var17;
                  var15 /= var17;
               }

               e(var5, var7, var9, var11, var13, var15, Math.max(0.6F, Math.min(1.5F, var4 / 1.8F)), 0, 96);
            }
         }
      }
   }

   public static void d(double var0, double var2, double var4, float var6, float var7, float var8, float var9) {

      if (RegionPassCache.PV && RegionPassCache.bd && !Double.isNaN(var0 + var2 + var4)) {
         double var10 = (double)var6;
         double var12 = (double)var7;
         double var14 = (double)var8;
         double var16 = Math.sqrt(var10 * var10 + var12 * var12 + var14 * var14);
         if (!(var16 >= 1.0E-4)) {
            var10 = (double)RegionPassCache.fX;
            var12 = (double)RegionPassCache.fY;
            var14 = (double)RegionPassCache.fZ;
         } else {
            var10 /= var16;
            var12 /= var16;
            var14 /= var16;
         }

         e(var0, var2, var4, var10, var12, var14, var9 > 0.0F ? Math.max(0.6F, Math.min(1.5F, var9 / 1.8F)) : 1.0F, 96, -457622015 ^ -457621823);
      }
   }

   private static void e(double var0, double var2, double var4, double var6, double var8, double var10, float var12, int var13, int var14) {

      assert (var13 == 0 && var14 == 96 || var13 == 96 && var14 == (-1720990834 ^ -1720990898))
         && di.length == (1944764936 ^ 1944765128)
         && dj.length == (935204807 ^ 935204615)
         && dk.length == (-567135859 ^ -567135923)
         && dl.length == (-170831260 ^ -170831196)
         && dm.length == (339500176 ^ 339500112)
         && dn.length == (1739971488 ^ 1739971424)
         && _kwren_do.length == (1256951201 ^ 1256951137)
         && dp.length == (1865019402 ^ 1865019594)
         && dq.length == (-594591823 ^ -594591887)
         && dr.length == (2010066257 ^ 2010066321)
         && ds.length == (-1897037799 ^ -1897037607)
         && dt.length == (77612062 ^ 77612254)
         && du.length == (-1145281056 ^ -1145281248)
         && dv.length == (-1115864598 ^ -1115864790)
         && dw.length == (-2070983172 ^ -2070983364)
         && var12 > 0.0F
         && !Double.isNaN(var0 + var2 + var4 + var6 + var8 + var10) : "burst: bad state";

      try {
         boolean var15 = var13 != 0;
         int var16 = var14 - var13;
         int var17 = var15 ? dz : dx;
         if (var17 < 0 || var17 >= var16) {
            var17 = 0;
         }

         var0 -= var6 * 0.25;
         var2 -= var8 * 0.25;
         var4 -= var10 * 0.25;
         int var18 = RegionPassCache.be;
         int var19 = Math.max(1, Math.min(32, RegionPassCache.bf));
         float var20 = RegionPassCache.rX;
         float var21 = RegionPassCache.rY;
         float var22 = RegionPassCache.rZ;
         float var23 = RegionPassCache.uX;
         float var24 = RegionPassCache.uY;
         float var25 = RegionPassCache.uZ;
         float var26 = RegionPassCache.fX;
         float var27 = RegionPassCache.fY;
         float var28 = RegionPassCache.fZ;
         ThreadLocalRandom var29 = ThreadLocalRandom.current();
         if (var18 != 1) {
            for (int var30 = 0; var30 < var19; var30++) {
               int var31 = var13 + var17;
               var17 = var17 + 1 < var16 ? var17 + 1 : 0;
               double var32 = var29.nextDouble() * 2.0 - 1.0;
               double var34 = var29.nextDouble() * Math.PI * 2.0;
               double var36 = Math.sqrt(1.0 - var32 * var32);
               double var38 = 0.55 * var36 * Math.cos(var34) + 0.45 * var6;
               double var40 = 0.55 * var32 + 0.45 * var8 + 0.2;
               double var42 = 0.55 * var36 * Math.sin(var34) + 0.45 * var10;
               double var44 = (var38 * (double)var26 + var40 * (double)var27 + var42 * (double)var28) * 0.6;
               var38 -= (double)var26 * var44;
               var40 -= (double)var27 * var44;
               var42 -= (double)var28 * var44;
               double var46 = Math.sqrt(var38 * var38 + var40 * var40 + var42 * var42);
               if (var46 < 1.0E-4) {
                  var38 = var6;
                  var40 = var8;
                  var42 = var10;
                  var46 = 1.0;
               }

               var38 /= var46;
               var40 /= var46;
               var42 /= var46;
               float var48 = 1.4F + 1.4F * var29.nextFloat();
               di[var31] = var0 + var38 * 0.12 * (double)var12;
               dj[var31] = var2 + var40 * 0.12 * (double)var12;
               dk[var31] = var4 + var42 * 0.12 * (double)var12;
               dl[var31] = (float)(var38 * (double)var48);
               dm[var31] = (float)(var40 * (double)var48);
               dn[var31] = (float)(var42 * (double)var48);
               _kwren_do[var31] = 3.2F;
               dp[var31] = -1.4F;
               dq[var31] = 0.0F;
               dr[var31] = 0.55F + 0.35F * var29.nextFloat();
               ds[var31] = (0.14F + 0.07F * var29.nextFloat()) * var12;
               dt[var31] = (float)Math.atan2(
                     var38 * (double)var23 + var40 * (double)var24 + var42 * (double)var25,
                     var38 * (double)var20 + var40 * (double)var21 + var42 * (double)var22
                  )
                  - (float) (Math.PI / 2);
               du[var31] = 0.0F;
               dv[var31] = 0;
               dw[var31] = true;
            }
         }

         if (var18 != 0) {
            int var56 = Math.round(1.3F * (float)var19);

            for (int var57 = 0; var57 < var56; var57++) {
               int var59 = var13 + var17;
               var17 = var17 + 1 < var16 ? var17 + 1 : 0;
               double var33 = var29.nextDouble() * 2.0 - 1.0;
               double var35 = var29.nextDouble() * Math.PI * 2.0;
               double var37 = Math.sqrt(1.0 - var33 * var33);
               double var39 = 0.75 * var37 * Math.cos(var35) + 0.25 * var6;
               double var41 = 0.75 * var33 + 0.25 * var8;
               double var43 = 0.75 * var37 * Math.sin(var35) + 0.25 * var10;
               double var45 = (var39 * (double)var26 + var41 * (double)var27 + var43 * (double)var28) * 0.6;
               var39 -= (double)var26 * var45;
               var41 -= (double)var27 * var45;
               var43 -= (double)var28 * var45;
               double var47 = Math.sqrt(var39 * var39 + var41 * var41 + var43 * var43);
               if (var47 < 1.0E-4) {
                  var39 = var6;
                  var41 = var8;
                  var43 = var10;
                  var47 = 1.0;
               }

               var39 /= var47;
               var41 /= var47;
               var43 /= var47;
               float var49 = 2.5F + 2.5F * var29.nextFloat();
               float var50 = 0.35F + 0.25F * var29.nextFloat();
               di[var59] = var0 + var39 * 0.08 * (double)var12;
               dj[var59] = var2 + var41 * 0.08 * (double)var12;
               dk[var59] = var4 + var43 * 0.08 * (double)var12;
               dl[var59] = (float)(var39 * (double)var49);
               dm[var59] = (float)(var41 * (double)var49);
               dn[var59] = (float)(var43 * (double)var49);
               _kwren_do[var59] = 4.5F;
               dp[var59] = -0.8F;
               dq[var59] = 0.0F;
               dr[var59] = var50;
               ds[var59] = 0.05F + 0.05F * var29.nextFloat();
               dt[var59] = var29.nextFloat() * (float) (Math.PI * 2);
               du[var59] = (var29.nextFloat() * 2.0F - 1.0F) * 4.0F;
               dv[var59] = 1;
               dw[var59] = true;
               if ((var57 & 1) == 0) {
                  int var51 = var13 + var17;
                  var17 = var17 + 1 < var16 ? var17 + 1 : 0;
                  di[var51] = di[var59];
                  dj[var51] = dj[var59];
                  dk[var51] = dk[var59];
                  dl[var51] = dl[var59] * 1.2F;
                  dm[var51] = dm[var59] * 1.2F;
                  dn[var51] = dn[var59] * 1.2F;
                  _kwren_do[var51] = 4.5F;
                  dp[var51] = -0.8F;
                  dq[var51] = 0.0F;
                  dr[var51] = var50;
                  ds[var51] = 0.025F;
                  dt[var51] = 0.0F;
                  du[var51] = 0.0F;
                  dv[var51] = 2;
                  dw[var51] = true;
               }
            }

            int var58 = var13 + var17;
            var17 = var17 + 1 < var16 ? var17 + 1 : 0;
            di[var58] = var0;
            dj[var58] = var2;
            dk[var58] = var4;
            dl[var58] = 0.0F;
            dm[var58] = 0.0F;
            dn[var58] = 0.0F;
            _kwren_do[var58] = 1.0F;
            dp[var58] = 0.0F;
            dq[var58] = 0.0F;
            dr[var58] = 0.45F;
            ds[var58] = 0.8F * var12;
            dt[var58] = 0.0F;
            du[var58] = 0.0F;
            dv[var58] = 3;
            dw[var58] = true;
         }

         if (var15) {
            dz = var17;
            ea = 96;
         } else {
            dx = var17;
            dy = 96;
         }
      } catch (RuntimeException var52) {
         throw var52;
      }
   }

   public static void f() {

      float var0 = RegionPassCache.dt * 5.5555553F;
      float var1 = RegionPassCache.dt * 4.5454545F;
      boolean var2 = RegionPassCache.aw;
      int var3 = RegionPassCache.ax;
      bi = var2 ? Math.min(1.0F, bi + var0) : Math.max(0.0F, bi - var1);
      bj = var2 && var3 != 1 ? Math.min(1.0F, bj + var0) : Math.max(0.0F, bj - var1);
      bk = var2 && var3 != 0 ? Math.min(1.0F, bk + var0) : Math.max(0.0F, bk - var1);
      bq = var2 && var3 != 0;
      if (bi > 0.0F) {
         j();
      } else if (br) {
         for (int var4 = 0; var4 < 13; var4++) {
            as[var4] = 0;
            av[var4] = false;
            aq[var4] = -1;
         }

         br = false;
      }

      if (cf > 0) {
         cf = l(0, 96);
      }

      if (cw > 0) {
         cw = m(0, 12);
      }

      if (dy > 0) {
         dy = n(0, 96);
      }
   }

   public static void g() {
      int var0 = 0;
      byte var1 = 0;

      label30:
      while (true) {
         switch (var1) {
            case 0:
            default:
               if (ec != 0) {
                  Thread.currentThread().getName().length();
                  var1 = 1;
                  break;
               }
            case 1:
               var0 = 0;
               var1 = 2;
               break;
            case 2:
               if (var0 <= 13) {
                  as[var0] = 0;
                  ar[var0] = 0;
                  at[var0] = 0;
                  av[var0] = false;
                  aw[var0] = false;
                  aq[var0] = -1;
                  ba[var0] = 0.0;
                  var0++;
                  var1 = 2;
                  break;
               }
            case 3:
               var0 = 0;
               var1 = 4;
               break;
            case 4:
               if (var0 < (-2006870220 ^ -2006870092)) {
                  cd[var0] = false;
                  var0++;
                  var1 = 4;
                  break;
               }
            case 5:
               var0 = 0;
               var1 = 6;
               break;
            case 6:
               if (var0 < 24) {
                  cv[var0] = false;
                  var0++;
                  var1 = 6;
                  break;
               }
            case 7:
               var0 = 0;
               var1 = 8;
               break;
            case 8:
               if (var0 < (898129582 ^ 898129518)) {
                  dw[var0] = false;
                  var0++;
                  var1 = 8;
                  break;
               }
            case 9:
               break label30;
         }
      }

      cf = 0;
      cw = 0;
      dy = 0;
      ch = 0;
      cx = 0;
      ea = 0;
      br = false;
      bi = 0.0F;
      bj = 0.0F;
      bk = 0.0F;
      bl = -1.0F;
   }

   public static void h() {
      byte var0 = 0;

      while (true) {
         switch (var0) {
            case 0:
            default:
               if (ec != 0) {
                  Math.abs(Integer.MIN_VALUE);
                  var0 = 1;
                  break;
               }
            case 1:
               if (!RegionPassCache.PV) {
                  return;
               }
            case 2:
               bu = bu + (double)RegionPassCache.dt;
               if ((RegionPassCache.bt & 4) != 0 && bi > 0.0F && bl > 0.0F) {
                  k(13, null);
                  var0 = 5;
                  break;
               }
            case 3:
               if (!av[13]) {
                  if (as[13] > 0) {
                     var0 = 4;
                  } else {
                     var0 = 5;
                  }
                  break;
               }
            case 4:
               as[13] = 0;
               av[13] = false;
               aq[13] = -1;
               var0 = 5;
               break;
            case 5:
               if (ch > 0) {
                  ch = l(96, -34555011 ^ -34554883);
                  var0 = 6;
                  break;
               }
            case 6:
               if (cx > 0) {
                  cx = m(12, 24);
                  var0 = 7;
                  break;
               }
            case 7:
               if (ea > 0) {
                  ea = n(96, 422744617 ^ 422744809);
                  var0 = 8;
                  break;
               }

               return;
            case 8:
               return;
         }
      }
   }

   public static void i() {
      int var0 = 0;
      byte var1 = 0;

      label26:
      while (true) {
         switch (var1) {
            case 0:
            default:
               if (ec != 0) {
                  Math.abs(Integer.MIN_VALUE);
                  var1 = 2;
                  break;
               }
            case 2:
               as[13] = 0;
               ar[13] = 0;
               at[13] = 0;
               av[13] = false;
               aw[13] = false;
               aq[13] = -1;
               ba[13] = 0.0;
               be[13] = 0.0F;
               var0 = 96;
               var1 = 5;
               break;
            case 1:
               if (var0 < 24) {
                  cv[var0] = false;
                  var0++;
                  var1 = 1;
                  break;
               }
            case 3:
               var0 = 96;
               var1 = 7;
               break;
            case 5:
               if (var0 < (215847034 ^ 215847162)) {
                  cd[var0] = false;
                  var0++;
                  var1 = 5;
                  break;
               }
            case 4:
               var0 = 12;
               var1 = 1;
               break;
            case 6:
               break label26;
            case 7:
               if (var0 >= (-1075497960 ^ -1075497768)) {
                  break label26;
               }

               dw[var0] = false;
               var0++;
               var1 = 7;
         }
      }

      ch = 0;
      cx = 0;
      ea = 0;
      cg = 0;
      dz = 0;
   }

   private static void j() {

      assert aq.length == 14
         && ar.length == 14
         && as.length == 14
         && at.length == 14
         && au.length == 14
         && av.length == 14
         && aw.length == 14
         && ax.length == 14
         && ay.length == 14
         && az.length == 14
         && ba.length == 14
         && bb.length == 14
         && bc.length == 14
         && bd.length == 14
         && be.length == 14
         && bf.length == 14
         && bg.length == 12
         && bh.length == 12
         && !RegionPassCache.PV : "trai" + "ls: bad state";

      MinecraftClient var0 = MinecraftClient.getInstance();
      ClientPlayerEntity var1 = var0.player;
      if (var1 != null && var0.world != null) {
         Entity var2 = null;
         AbstractClientPlayerEntity var3 = null;

         try {
            float var4 = RegionPassCache.dt;
            bp = 1.0F - (float)Math.exp((double)(-var4 * 10.0F));
            float var5 = Math.max(0.3F, Math.min(3.0F, RegionPassCache.ba));
            float var6 = Math.max(0.2F, Math.min(1.0F, RegionPassCache.bb));
            float var7 = Math.max(0.0F, Math.min(1.0F, RegionPassCache.bc));
            if (bl < 0.0F) {
               bl = var5;
               bm = var6;
               bn = var7;
               bo = RegionPassCache.ad ? 1.0F : 0.0F;
            } else {
               bl = bl + (var5 - bl) * bp;
               bm = bm + (var6 - bm) * bp;
               bn = bn + (var7 - bn) * bp;
               bo = bo + ((RegionPassCache.ad ? 1.0F : 0.0F) - bo) * (1.0F - (float)Math.exp((double)(-var4 * 12.0F)));
            }

            bs = RegionPassCache.col(RegionPassCache.az) & (194895203 ^ 190980764);
            var2 = var0.getCameraEntity();
            bt = var2 == null ? -1 : var2.getId();

            for (int var8 = 0; var8 < 13; var8++) {
               aw[var8] = false;
            }

            if (RegionPassCache.l(var1, true)) {
               k(0, var1);
               aw[0] = true;
            }

            if (RegionPassCache.ay == 1) {
               List var34 = var0.world.getPlayers();
               var3 = null;
               double var9 = RegionPassCache.z;
               double var11 = RegionPassCache.aa;
               double var13 = RegionPassCache.ab;
               int var15 = 0;
               int var16 = 0;

               for (int var17 = var34.size(); var16 < var17; var16++) {
                  var3 = (AbstractClientPlayerEntity)var34.get(var16);
                  if (var3 != null && var3 != var1) {
                     double var18 = var3.getX() - var9;
                     double var20 = var3.getY() - var11;
                     double var22 = var3.getZ() - var13;
                     double var24 = var18 * var18 + var20 * var20 + var22 * var22;
                     if (!(var24 > 2704.0) && !var3.isRemoved() && !var3.isSpectator() && !var3.isSleeping() && !var3.isInvisibleTo(var1)) {
                        int var26 = var3.getId();
                        boolean var27 = false;

                        for (int var28 = 1; var28 < 13; var28++) {
                           if (aq[var28] == var26) {
                              var27 = true;
                              break;
                           }
                        }

                        if (!(var24 > (var27 ? 2704.0 : 2304.0)) && (var15 < 12 || var24 < bg[var15 - 1])) {
                           int var41;
                           for (var41 = var15 < 12 ? var15++ : 11; var41 > 0 && bg[var41 - 1] > var24; var41--) {
                              bg[var41] = bg[var41 - 1];
                              bh[var41] = bh[var41 - 1];
                           }

                           bg[var41] = var24;
                           bh[var41] = var16;
                        }
                     }
                  }
               }

               for (int var37 = 0; var37 < var15; var37++) {
                  var3 = (AbstractClientPlayerEntity)var34.get(bh[var37]);
                  int var38 = var3.getId();
                  int var39 = -1;

                  for (int var19 = 1; var19 < 13; var19++) {
                     if (aq[var19] == var38) {
                        var39 = var19;
                        break;
                     }
                  }

                  if (var39 < 0) {
                     for (int var40 = 1; var40 < 13; var40++) {
                        if (aq[var40] == -1) {
                           var39 = var40;
                           break;
                        }
                     }
                  }

                  if (var39 >= 0) {
                     k(var39, var3);
                     aw[var39] = true;
                  }
               }
            }

            boolean var35 = false;

            for (int var36 = 0; var36 < 13; var36++) {
               if (!aw[var36] && (av[var36] || as[var36] > 0)) {
                  k(var36, null);
               }

               var35 |= av[var36] || as[var36] > 0;
            }

            br = var35;
         } catch (RuntimeException var29) {
            throw var29;
         }
      }
   }

   private static void k(int var0, PlayerEntity var1) {

      assert var0 >= 0
         && var0 <= 13
         && (var0 != 13 || RegionPassCache.PV)
         && aj.length == (16874718 ^ 16874462)
         && ak.length == (-412409945 ^ -412411737)
         && al.length == (-234925854 ^ -234924062)
         && am.length == (-1040170647 ^ -1040169367)
         && an.length == (1463705809 ^ 1463707601)
         && ao.length == (1666776966 ^ 1666775174)
         && ap.length == (-1829305461 ^ -1829305205)
         && aq.length == 14
         && ar.length == 14
         && as.length == 14
         && at.length == 14
         && au.length == 14
         && av.length == 14
         && ax.length == 14
         && ay.length == 14
         && az.length == 14
         && ba.length == 14
         && bb.length == 14
         && bc.length == 14
         && bd.length == 14
         && be.length == 14
         && bf.length == 14
         && cd.length == (642543990 ^ 642544118)
         && RegionPassCache.QT.length == (-1418826255 ^ -1418723855) : "slo" + "t: ba" + "d sta" + "te";

      try {
         boolean var2 = var0 == 13;
         double var3 = var2 ? bu : RegionPassCache.now;
         float var5 = RegionPassCache.dt;
         int var6 = var0 * (982179057 ^ 982178929);
         int var7 = -1;
         double var8 = 0.0;
         double var10 = 0.0;
         double var12 = 0.0;
         float var14 = 0.0F;
         boolean var15 = false;
         boolean var16 = false;
         boolean var17 = false;
         boolean var18 = var2 || var1 != null;
         float var19 = 0.0F;
         double var20 = 0.0;
         double var22 = 0.0;
         double var24 = 0.0;
         double var26 = 0.0;
         if (var18) {
            int var28;
            if (var2) {
               var8 = RegionPassCache.pvX;
               var10 = RegionPassCache.pvY;
               var12 = RegionPassCache.pvZ;
               var19 = RegionPassCache.bv * 0.05F;
               var14 = RegionPassCache.pvH;
               var7 = -2;
               var28 = RegionPassCache.bu;
            } else {
               float var29 = RegionPassCache.td;
               double var30 = var1.getX();
               double var32 = var1.getY();
               double var34 = var1.getZ();
               var8 = var1.lastRenderX + (var30 - var1.lastRenderX) * (double)var29;
               var10 = var1.lastRenderY + (var32 - var1.lastRenderY) * (double)var29;
               var12 = var1.lastRenderZ + (var34 - var1.lastRenderZ) * (double)var29;
               double var36 = var30 - var1.lastRenderX;
               double var38 = var32 - var1.lastRenderY;
               double var40 = var34 - var1.lastRenderZ;
               var19 = (float)Math.sqrt(var36 * var36 + var38 * var38 + var40 * var40);
               var14 = var1.getHeight();
               var7 = var1.getId();
               var28 = var1.age;
            }

            var17 = var28 != au[var0];
            au[var0] = var28;
            var15 = !av[var0] || aq[var0] != var7;
            if (!var15) {
               double var81 = var8 - ax[var0];
               double var31 = var10 - ay[var0];
               double var33 = var12 - az[var0];
               double var35 = Math.sqrt(var81 * var81 + var31 * var31 + var33 * var33);
               if ((!(var35 > 1.0) || !(var35 > 3.0 * (double)Math.max(bf[var0], var19) + 0.75))
                  && (!var17 || !(var19 > 1.6F) || !(var19 > 2.5F * bf[var0] + 0.5F))) {
                  if (var5 > 0.0F && bd[var0] <= 0.0F) {
                     float var37 = (float)(var35 / (double)var5);
                     bc[var0] = bc[var0] + (Math.min(var37, 120.0F) - bc[var0]) * (1.0F - (float)Math.exp((double)(-var5 * 4.0F)));
                     var20 = var81;
                     var22 = var31;
                     var24 = var33;
                     var26 = Math.sqrt(var81 * var81 + var33 * var33);
                  }
               } else {
                  var16 = true;
               }
            }

            if (var17) {
               bf[var0] = var19;
            }
         }

         int var80 = as[var0];
         int var82 = ar[var0];
         int var83 = at[var0];
         if (av[var0] && (!var18 || var16 || aq[var0] != var7)) {
            int var84 = var6 + (var82 - 1 & 127);
            if (var80 > 0 && ap[var84] == var83) {
               double var86 = ax[var0] - aj[var84];
               double var92 = ay[var0] - ak[var84];
               double var97 = az[var0] - al[var84];
               double var104 = Math.sqrt(var86 * var86 + var92 * var92 + var97 * var97);
               if (var104 > 0.02) {
                  ba[var0] = ba[var0] + var104;
                  int var109 = var6 + var82;
                  aj[var109] = ax[var0];
                  ak[var109] = ay[var0];
                  al[var109] = az[var0];
                  am[var109] = var3;
                  an[var109] = ba[var0];
                  ap[var109] = var83;
                  var82 = var82 + 1 & 127;
                  if (var80 < (1653910239 ^ 1653910111)) {
                     var80++;
                  }
               }

               double var110 = ba[var0];

               for (int var42 = 0; var42 < var80; var42++) {
                  int var43 = var6 + (var82 - 1 - var42 & 127);
                  if (ap[var43] != var83) {
                     break;
                  }

                  ao[var43] = var110;
               }
            }

            at[var0] = ++var83;
         }

         boolean var85 = false;
         if (!var18) {
            av[var0] = false;
         } else {
            av[var0] = true;
            aq[var0] = var7;
            ax[var0] = var8;
            ay[var0] = var10;
            az[var0] = var12;
            if (var15) {
               bb[var0] = var14;
               bc[var0] = 0.0F;
               bd[var0] = 0.0F;
               be[var0] = 0.0F;
               bf[var0] = var19;
            } else {
               bb[var0] = bb[var0] + (var14 - bb[var0]) * bp;
            }

            if (var16) {
               bd[var0] = 0.2F;
               be[var0] = 0.0F;
            } else if (bd[var0] > 0.0F) {
               bd[var0] = bd[var0] - var5;
            }

            if (bd[var0] <= 0.0F) {
               var85 = true;
               int var87 = var6 + (var82 - 1 & 127);
               boolean var89 = var80 > 0 && ap[var87] == var83;
               double var93 = 0.0;
               if (var89) {
                  double var98 = var8 - aj[var87];
                  double var105 = var10 - ak[var87];
                  double var111 = var12 - al[var87];
                  var93 = Math.sqrt(var98 * var98 + var105 * var105 + var111 * var111);
               }

               float var99 = Math.max(0.15F, bc[var0] * bl / (var0 != 0 && !var2 ? 60.0F : 110.0F));
               if (!var89 || var93 >= (double)var99) {
                  if (var80 == 0) {
                     ba[var0] = 0.0;
                  } else if (var89) {
                     ba[var0] = ba[var0] + var93;
                  }

                  int var101 = var6 + var82;
                  aj[var101] = var8;
                  ak[var101] = var10;
                  al[var101] = var12;
                  am[var101] = var3;
                  an[var101] = ba[var0];
                  ap[var101] = var83;
                  var82 = var82 + 1 & 127;
                  if (var80 < (1448600642 ^ 1448600770)) {
                     var80++;
                  }
               }

               if (bq && var26 > 1.0E-6) {
                  float var102 = be[var0] + (float)var26;
                  if (var102 >= 0.45F) {
                     ThreadLocalRandom var106 = ThreadLocalRandom.current();
                     double var39 = -var24 / var26;
                     double var41 = var20 / var26;

                     for (int var114 = 0; var114 < 8 && var102 >= 0.45F; var114++) {
                        var102 -= 0.45F;
                        int var44;
                        if (var2) {
                           var44 = 96 + cg;
                           cg = cg + 1 < 32 ? cg + 1 : 0;
                        } else {
                           var44 = ce;
                           ce = (var44 + 1) % 96;
                        }

                        double var45 = (double)((var106.nextFloat() * 2.0F - 1.0F) * 0.18F);
                        double var47 = (double)var102 / var26;
                        bx[var44] = var8 - var20 * var47 + var39 * var45;
                        by[var44] = var10 - var22 * var47 + 0.05 + 0.3 * (double)var106.nextFloat();
                        bz[var44] = var12 - var24 * var47 + var41 * var45;
                        ca[var44] = 0.0F;
                        cc[var44] = var106.nextFloat() < 0.7F ? 9 + var106.nextInt(8) : 3;
                        cb[var44] = (var106.nextFloat() * 2.0F - 1.0F) * (float) (Math.PI / 18);
                        cd[var44] = true;
                     }

                     if (var102 >= 0.45F) {
                        var102 = 0.0F;
                     }

                     if (var2) {
                        ch = 32;
                     } else {
                        cf = 96;
                     }
                  }

                  be[var0] = var102;
               } else if (!bq) {
                  be[var0] = 0.0F;
               }
            }
         }

         float var88;
         for (var88 = bl; var80 > 0; var80--) {
            int var90 = var6 + (var82 - var80 & 127);
            if (var3 - am[var90] < (double)var88) {
               break;
            }

            if (var80 > 1) {
               int var94 = var6 + (var82 - var80 + 1 & 127);
               if (ap[var94] == ap[var90] && var3 - am[var94] < (double)var88) {
                  break;
               }
            }
         }

         as[var0] = var80;
         ar[var0] = var82;
         if (var80 == 0) {
            if (!var18) {
               aq[var0] = -1;
            }
         } else {
            float var91 = bj < bi ? bj : bi;
            float var95 = bn * var91 * var91 * (3.0F - 2.0F * var91);
            if (!(var95 <= 0.002F)) {
               int var96 = bs;
               float var100 = bm * bb[var0];
               float var103 = 1.0F / var88;
               float var107 = !var2 && aq[var0] == bt ? bo : 0.0F;
               int var108 = var0 != 0 && !var2 ? 72 : -932728521 ^ -932728393;
               double var112 = RegionPassCache.z;
               double var113 = RegionPassCache.aa;
               double var115 = RegionPassCache.ab;
               float[] var46 = RegionPassCache.QT;
               int var116 = var6 + (var82 - 1 & 127);
               double var48 = ba[var0];
               float var50 = 0.0F;
               float var51 = 0.0F;
               float var52 = 0.0F;
               float var53 = 0.0F;
               int var54 = 0;
               int var55 = -1;
               boolean var56 = false;
               if (var85 && ap[var116] == var83) {
                  double var57 = var8 - aj[var116];
                  double var59 = var10 - ak[var116];
                  double var61 = var12 - al[var116];
                  var48 += Math.sqrt(var57 * var57 + var59 * var59 + var61 * var61);
                  var50 = (float)(var8 - var112);
                  var51 = (float)(var10 + 0.01 - var113);
                  var52 = (float)(var10 + (double)var100 - var113);
                  var53 = (float)(var12 - var115);
                  var54 = var96;
                  var55 = var83;
                  var56 = true;
               }

               int var117 = Math.min(var80, var108);

               for (int var58 = 0; var58 < var117; var58++) {
                  int var118 = var6 + (var82 - 1 - var58 & 127);
                  int var60 = ap[var118];
                  float var119 = (float)((var60 == var83 ? var48 : ao[var118]) - an[var118]);
                  float var62 = ((float)(var3 - am[var118]) * var103 - 0.55F) * 2.2222223F;
                  var62 = var62 < 0.0F ? 0.0F : (var62 > 1.0F ? 1.0F : var62);
                  float var63 = var95 * (1.0F - var62 * var62 * (3.0F - 2.0F * var62));
                  float var64 = var119 * 2.857143F;
                  var64 = var64 < 0.0F ? 0.0F : (var64 > 1.0F ? 1.0F : var64);
                  float var65 = var64 * var64 * (3.0F - 2.0F * var64);
                  if (var107 > 0.0F) {
                     float var66 = (var119 - 0.5F) * 1.25F;
                     var66 = var66 < 0.0F ? 0.0F : (var66 > 1.0F ? 1.0F : var66);
                     var65 += (var66 * var66 * (3.0F - 2.0F * var66) - var65) * var107;
                  }

                  var63 *= var65;
                  float var124 = (float)(var108 - 1 - var58) * 0.16666667F;
                  if (var124 < 1.0F) {
                     var63 *= var124;
                  }

                  double var67 = ak[var118];
                  float var69 = (float)(aj[var118] - var112);
                  float var70 = (float)(var67 + 0.01 - var113);
                  float var71 = (float)(var67 + (double)var100 - var113);
                  float var72 = (float)(al[var118] - var115);
                  float var73 = var70 > 0.0F ? var70 : (var71 < 0.0F ? var71 : 0.0F);
                  float var74 = (float)Math.sqrt((double)(var69 * var69 + var72 * var72 + var73 * var73)) - 0.5F;
                  if (var74 < 1.0F) {
                     var74 = var74 < 0.0F ? 0.0F : var74;
                     var63 *= var74 * var74 * (3.0F - 2.0F * var74);
                  }

                  int var75 = (int)(var63 * 255.0F + 0.5F) << 24 | var96;
                  if (var56 && var55 == var60 && (var54 | var75) >>> 24 != 0) {
                     int var76 = RegionPassCache.nQT;
                     if (var76 >= (596399864 ^ 596395768)) {
                        break;
                     }

                     int var77 = var76 * 25;
                     var46[var77] = var50;
                     var46[var77 + 1] = var51;
                     var46[var77 + 2] = var53;
                     var46[var77 + 3] = var69;
                     var46[var77 + 4] = var70;
                     var46[var77 + 5] = var72;
                     var46[var77 + 6] = var69;
                     var46[var77 + 7] = var71;
                     var46[var77 + 8] = var72;
                     var46[var77 + 9] = var50;
                     var46[var77 + 10] = var52;
                     var46[var77 + 11] = var53;
                     var46[var77 + 12] = 0.5F;
                     var46[var77 + 13] = 0.0F;
                     var46[var77 + 14] = 0.5F;
                     var46[var77 + 15] = 0.0F;
                     var46[var77 + 16] = 0.5F;
                     var46[var77 + 17] = 1.0F;
                     var46[var77 + 18] = 0.5F;
                     var46[var77 + 19] = 1.0F;
                     var46[var77 + 20] = 20.0F;
                     var46[var77 + 21] = Float.intBitsToFloat(var54);
                     var46[var77 + 22] = Float.intBitsToFloat(var75);
                     var46[var77 + 23] = Float.intBitsToFloat(var75);
                     var46[var77 + 24] = Float.intBitsToFloat(var54);
                     RegionPassCache.nQT = var76 + 1;
                  }

                  var50 = var69;
                  var51 = var70;
                  var52 = var71;
                  var53 = var72;
                  var54 = var75;
                  var55 = var60;
                  var56 = true;
               }
            }
         }
      } catch (RuntimeException var78) {
         throw var78;
      }
   }

   private static int l(int var0, int var1) {

      assert (var0 == 0 && var1 == 96 && !RegionPassCache.PV || var0 == 96 && var1 == (-1875710637 ^ -1875710509) && RegionPassCache.PV)
         && bx.length == (-949079014 ^ -949078886)
         && by.length == (-1308949522 ^ -1308949650)
         && bz.length == (1166880704 ^ 1166880576)
         && ca.length == (-976363217 ^ -976363089)
         && cb.length == (1425325247 ^ 1425325119)
         && cc.length == (-289606521 ^ -289606649)
         && cd.length == (-640103732 ^ -640103860)
         && bi >= 0.0F
         && bi <= 1.0F
         && bk >= 0.0F
         && bk <= 1.0F
         && RegionPassCache.dt >= 0.0F
         && RegionPassCache.SA.length == (588861698 ^ 588894466) : "glyphs: bad state";

      try {
         float var2 = RegionPassCache.dt;
         int var3 = bs;
         int var4 = var3 >> 16 & (1736429754 ^ 1736429637);
         int var5 = var3 >> 8 & (-1279630639 ^ -1279630802);
         int var6 = var3 & (756622466 ^ 756622461);
         int var7 = var4 + (int)((float)((-2132265814 ^ -2132265899) - var4) * 0.45F + 0.5F) << 16
            | var5 + (int)((float)((2131484354 ^ 2131484221) - var5) * 0.45F + 0.5F) << 8
            | var6 + (int)((float)((-34167705 ^ -34167656) - var6) * 0.45F + 0.5F);
         float var8 = bk < bi ? bk : bi;
         float var9 = var8 * var8 * (3.0F - 2.0F * var8);
         double var10 = RegionPassCache.z;
         double var12 = RegionPassCache.aa;
         double var14 = RegionPassCache.ab;
         float[] var16 = RegionPassCache.SA;
         int var17 = 0;

         for (int var18 = var0; var18 < var1; var18++) {
            if (cd[var18]) {
               float var19 = ca[var18] + var2;
               ca[var18] = var19;
               if (var19 >= 1.4F) {
                  cd[var18] = false;
               } else {
                  var17++;
                  if (!(var9 <= 0.002F)) {
                     float var20 = (var19 * 0.71428573F - 0.5F) * 2.0F;
                     var20 = var20 < 0.0F ? 0.0F : (var20 > 1.0F ? 1.0F : var20);
                     boolean var21 = cc[var18] == 3;
                     float var22 = Math.min(1.0F, var19 * 8.333333F) * (1.0F - var20 * var20 * (3.0F - 2.0F * var20)) * (var21 ? 0.9F : 0.85F) * var9;
                     int var23 = RegionPassCache.nSA;
                     if (var23 < (-1988337829 ^ -1988341925)) {
                        int var24 = var23 * 8;
                        float var25 = var21 ? 0.03F : 0.11F;
                        var16[var24] = (float)(bx[var18] - var10);
                        var16[var24 + 1] = (float)(by[var18] + 0.12 * (double)var19 - var12);
                        var16[var24 + 2] = (float)(bz[var18] - var14);
                        var16[var24 + 3] = var25;
                        var16[var24 + 4] = var25;
                        var16[var24 + 5] = cb[var18];
                        var16[var24 + 6] = (float)cc[var18];
                        var16[var24 + 7] = Float.intBitsToFloat((int)(var22 * 255.0F + 0.5F) << 24 | var7);
                        RegionPassCache.nSA = var23 + 1;
                     }
                  }
               }
            }
         }

         return var17;
      } catch (RuntimeException var26) {
         throw var26;
      }
   }

   private static int m(int var0, int var1) {

      assert (var0 == 0 && var1 == 12 && !RegionPassCache.PV || var0 == 12 && var1 == 24 && RegionPassCache.PV)
         && ck.length == 24
         && cl.length == 24
         && cm.length == 24
         && cn.length == 24
         && co.length == 24
         && cp.length == 24
         && cq.length == 24
         && cr.length == 24
         && ct.length == 24
         && cu.length == 24
         && cv.length == 24
         && cz.length == 33
         && da.length == 33
         && db.length == 33
         && RegionPassCache.QA.length == (-1295264221 ^ -1295366621) : "rings: bad state";

      try {
         float var2 = RegionPassCache.dt;
         double var3 = RegionPassCache.z;
         double var5 = RegionPassCache.aa;
         double var7 = RegionPassCache.ab;
         float[] var9 = RegionPassCache.QA;
         int var10 = 696703510 ^ -1450780138;
         int var11 = 328796769 ^ 325514654;
         int var12 = 0;

         for (int var13 = var0; var13 < var1; var13++) {
            if (cv[var13]) {
               float var14 = cn[var13] + var2;
               cn[var13] = var14;
               var12++;
               if (!(var14 < 0.0F)) {
                  float var15 = var14 / co[var13];
                  if (var15 >= 1.0F) {
                     cv[var13] = false;
                     var12--;
                  } else {
                     double var16 = ck[var13] - var3;
                     double var18 = cl[var13] - var5;
                     double var20 = cm[var13] - var7;
                     double var22 = var16 * var16 + var18 * var18 + var20 * var20;
                     if (!(var22 >= 4096.0)) {
                        float var24 = ((float)Math.sqrt(var22) - 56.0F) * 0.125F;
                        var24 = var24 < 0.0F ? 0.0F : (var24 > 1.0F ? 1.0F : var24);
                        float var25 = 1.0F - var15;
                        float var26 = cp[var13] * cq[var13] * (1.0F - var25 * var25 * var25);
                        float var27 = var25 < 0.7F ? var25 * 1.4285715F : 1.0F;
                        float var28 = var27
                           * var27
                           * (3.0F - 2.0F * var27)
                           * Math.min(1.0F, var15 * 16.666666F)
                           * (1.0F - var24 * var24 * (3.0F - 2.0F * var24));
                        if (!(var26 < 0.004F) && !(var28 < 0.004F)) {
                           if (cu[var13] != var10) {
                              var10 = cu[var13];
                              var11 = RegionPassCache.col(var10) & (-2010654614 ^ -1999100011);
                           }

                           int var29 = var11 >> 16 & (-1478235529 ^ -1478235512);
                           int var30 = var11 >> 8 & (-1430741697 ^ -1430741568);
                           int var31 = var11 & (-1442806544 ^ -1442806769);
                           float var32 = var26 / 0.9F;
                           float var33 = (float)var16;
                           float var34 = (float)var18;
                           float var35 = (float)var20;
                           if (ct[var13] == 1) {
                              int var53 = RegionPassCache.nQA;
                              if (var53 < (-1271535802 ^ -1271531706)) {
                                 int var54 = (int)(var28 * 255.0F + 0.5F) << 24
                                    | var29 + (int)((float)((1540939464 ^ 1540939319) - var29) * 0.2F + 0.5F) << 16
                                    | var30 + (int)((float)((-1973477394 ^ -1973477615) - var30) * 0.2F + 0.5F) << 8
                                    | var31 + (int)((float)((676740542 ^ 676740417) - var31) * 0.2F + 0.5F);
                                 float var55 = Float.intBitsToFloat(var54);
                                 int var56 = var53 * 25;
                                 var9[var56] = var33 - var32;
                                 var9[var56 + 1] = var34;
                                 var9[var56 + 2] = var35 - var32;
                                 var9[var56 + 3] = var33 + var32;
                                 var9[var56 + 4] = var34;
                                 var9[var56 + 5] = var35 - var32;
                                 var9[var56 + 6] = var33 + var32;
                                 var9[var56 + 7] = var34;
                                 var9[var56 + 8] = var35 + var32;
                                 var9[var56 + 9] = var33 - var32;
                                 var9[var56 + 10] = var34;
                                 var9[var56 + 11] = var35 + var32;
                                 var9[var56 + 12] = 0.0F;
                                 var9[var56 + 13] = 0.0F;
                                 var9[var56 + 14] = 1.0F;
                                 var9[var56 + 15] = 0.0F;
                                 var9[var56 + 16] = 1.0F;
                                 var9[var56 + 17] = 1.0F;
                                 var9[var56 + 18] = 0.0F;
                                 var9[var56 + 19] = 1.0F;
                                 var9[var56 + 20] = 18.0F;
                                 var9[var56 + 21] = var55;
                                 var9[var56 + 22] = var55;
                                 var9[var56 + 23] = var55;
                                 var9[var56 + 24] = var55;
                                 RegionPassCache.nQA = var53 + 1;
                              }
                           } else {
                              int var36 = var29 + (int)((float)((1828681862 ^ 1828681849) - var29) * 0.35F + 0.5F) << 16
                                 | var30 + (int)((float)((1491689550 ^ 1491689649) - var30) * 0.35F + 0.5F) << 8
                                 | var31 + (int)((float)((-1153589485 ^ -1153589268) - var31) * 0.35F + 0.5F);
                              float var37 = cs[var13] * var32;
                              float var38 = Math.max(var32, Math.abs(var37));
                              if (!(var33 * RegionPassCache.fX + var34 * RegionPassCache.fY + var35 * RegionPassCache.fZ < -(var38 + 0.01F))) {
                                 float var39 = cr[var13] + (float) (Math.PI * 8.0 / 5.0) * var15;
                                 float var40 = (float)Math.cos((double)var39);
                                 float var41 = (float)Math.sin((double)var39);

                                 for (int var42 = 0; var42 <= 32; var42++) {
                                    float var43 = 0.25F
                                       + 0.75F * (float)Math.pow((double)Math.max(0.0F, 0.5F + 0.5F * (cz[var42] * var40 + da[var42] * var41)), 1.6);
                                    db[var42] = (int)(var28 * var43 * 255.0F + 0.5F) << 24 | var36;
                                 }

                                 for (int var57 = 0; var57 < 32; var57++) {
                                    int var58 = RegionPassCache.nQA;
                                    if (var58 >= (-2055162775 ^ -2055166871)) {
                                       break;
                                    }

                                    float var44 = cz[var57];
                                    float var45 = da[var57];
                                    float var46 = cz[var57 + 1];
                                    float var47 = da[var57 + 1];
                                    float var48 = Float.intBitsToFloat(db[var57]);
                                    float var49 = Float.intBitsToFloat(db[var57 + 1]);
                                    int var50 = var58 * 25;
                                    var9[var50] = var33 + var44 * var37;
                                    var9[var50 + 1] = var34;
                                    var9[var50 + 2] = var35 + var45 * var37;
                                    var9[var50 + 3] = var33 + var46 * var37;
                                    var9[var50 + 4] = var34;
                                    var9[var50 + 5] = var35 + var47 * var37;
                                    var9[var50 + 6] = var33 + var46 * var32;
                                    var9[var50 + 7] = var34;
                                    var9[var50 + 8] = var35 + var47 * var32;
                                    var9[var50 + 9] = var33 + var44 * var32;
                                    var9[var50 + 10] = var34;
                                    var9[var50 + 11] = var35 + var45 * var32;
                                    var9[var50 + 12] = 0.5F + 0.275F * var44;
                                    var9[var50 + 13] = 0.5F + 0.275F * var45;
                                    var9[var50 + 14] = 0.5F + 0.275F * var46;
                                    var9[var50 + 15] = 0.5F + 0.275F * var47;
                                    var9[var50 + 16] = 0.5F + 0.5F * var46;
                                    var9[var50 + 17] = 0.5F + 0.5F * var47;
                                    var9[var50 + 18] = 0.5F + 0.5F * var44;
                                    var9[var50 + 19] = 0.5F + 0.5F * var45;
                                    var9[var50 + 20] = 17.0F;
                                    var9[var50 + 21] = var48;
                                    var9[var50 + 22] = var49;
                                    var9[var50 + 23] = var49;
                                    var9[var50 + 24] = var48;
                                    RegionPassCache.nQA = var58 + 1;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }

         return var12;
      } catch (RuntimeException var51) {
         throw var51;
      }
   }

   private static int n(int var0, int var1) {

      assert (var0 == 0 && var1 == 96 && !RegionPassCache.PV || var0 == 96 && var1 == (-409273553 ^ -409273361) && RegionPassCache.PV)
         && di.length == (1811074419 ^ 1811074483)
         && dj.length == (1479294048 ^ 1479294112)
         && dk.length == (1054559212 ^ 1054559020)
         && dl.length == (-2015577889 ^ -2015578081)
         && dm.length == (492558639 ^ 492558831)
         && dn.length == (-316179379 ^ -316179315)
         && _kwren_do.length == (2127085493 ^ 2127085429)
         && dp.length == (-2121300803 ^ -2121300867)
         && dq.length == (2117822015 ^ 2117822207)
         && dr.length == (-1338652212 ^ -1338652404)
         && ds.length == (-781778359 ^ -781778295)
         && dt.length == (179799103 ^ 179799295)
         && du.length == (176431702 ^ 176431766)
         && dv.length == (-621613488 ^ -621613424)
         && dw.length == (-533996137 ^ -533996201)
         && RegionPassCache.ST.length == (1180019164 ^ 1180010972)
         && RegionPassCache.SA.length == (1726932216 ^ 1726899448) : "hits: bad s" + "t" + "ate";

      try {
         float var2 = RegionPassCache.dt;
         int var3 = RegionPassCache.col(RegionPassCache.bg) & (1326445559 ^ 1341131784);
         int var4 = var3 >> 16 & (1963042539 ^ 1963042324);
         int var5 = var3 >> 8 & (-308664471 ^ -308664426);
         int var6 = var3 & (-285408684 ^ -285408597);
         int var7 = Math.max(var4, Math.max(var5, var6));
         int var8 = Math.min(var4, Math.min(var5, var6));
         int var9 = var3;
         if (var7 > 0 && (float)(var7 - var8) > 0.15F * (float)var7) {
            float var10 = (float)(var7 - var8);
            float var11 = var7 == var4
               ? (float)(var5 - var6) / var10
               : (var7 == var5 ? 2.0F + (float)(var6 - var4) / var10 : 4.0F + (float)(var4 - var5) / var10);
            var11 = var11 / 6.0F - 0.045F;
            var11 -= (float)Math.floor((double)var11);
            var9 = MathHelper.hsvToRgb(var11, var10 / (float)var7 * 0.82F, (float)var7 / 255.0F) & (-773362825 ^ -786918264);
         }

         int var57 = var9 >> 16 & (502418424 ^ 502418183);
         int var60 = var9 >> 8 & (2128858052 ^ 2128857915);
         int var12 = var9 & (-1542388335 ^ -1542388370);
         int var13 = var4 + var57 + 1 >> 1 << 16 | var5 + var60 + 1 >> 1 << 8 | var6 + var12 + 1 >> 1;
         int var14 = var4 + (int)((float)((-1674360872 ^ -1674361049) - var4) * 0.8F + 0.5F) << 16
            | var5 + (int)((float)((-319310242 ^ -319310175) - var5) * 0.8F + 0.5F) << 8
            | var6 + (int)((float)((-1110225383 ^ -1110225178) - var6) * 0.8F + 0.5F);
         int var15 = var4 + (int)((float)((-1790213995 ^ -1790214038) - var4) * 0.85F + 0.5F) << 16
            | var5 + (int)((float)((1117798869 ^ 1117798698) - var5) * 0.85F + 0.5F) << 8
            | var6 + (int)((float)((157671471 ^ 157671632) - var6) * 0.85F + 0.5F);
         float var16 = RegionPassCache.rX;
         float var17 = RegionPassCache.rY;
         float var18 = RegionPassCache.rZ;
         float var19 = RegionPassCache.uX;
         float var20 = RegionPassCache.uY;
         float var21 = RegionPassCache.uZ;
         float var22 = 1.0F - (float)Math.exp((double)(-var2 * 60.0F));
         double var23 = RegionPassCache.z;
         double var25 = RegionPassCache.aa;
         double var27 = RegionPassCache.ab;
         float[] var29 = RegionPassCache.SA;
         float[] var30 = RegionPassCache.ST;
         int var31 = 0;

         for (int var32 = var0; var32 < var1; var32++) {
            if (dw[var32]) {
               float var33 = dq[var32] + var2;
               dq[var32] = var33;
               float var34 = var33 / dr[var32];
               if (var34 >= 1.0F) {
                  dw[var32] = false;
               } else {
                  var31++;
                  float var35 = _kwren_do[var32];
                  float var36 = dp[var32];
                  float var37 = (float)Math.exp((double)(-var35 * var33));
                  float var38 = (1.0F - var37) / var35;
                  float var39 = var36 / var35;
                  float var40 = (float)(di[var32] - var23 + (double)(dl[var32] * var38));
                  float var41 = (float)(dj[var32] - var25 + (double)(var39 * var33) + (double)((dm[var32] - var39) * var38));
                  float var42 = (float)(dk[var32] - var27 + (double)(dn[var32] * var38));
                  int var43 = dv[var32];
                  if (var43 == 0) {
                     float var44 = dl[var32] * var37;
                     float var45 = var39 + (dm[var32] - var39) * var37;
                     float var46 = dn[var32] * var37;
                     float var47 = var44 * var16 + var45 * var17 + var46 * var18;
                     float var48 = var44 * var19 + var45 * var20 + var46 * var21;
                     float var49 = var47 * var47 + var48 * var48;
                     if (var49 > 1.0E-6F) {
                        float var50 = Math.min(1.0F, 4.0F * var49 / (var44 * var44 + var45 * var45 + var46 * var46 + 1.0E-6F));
                        float var51 = (float)Math.atan2((double)var48, (double)var47) - (float) (Math.PI / 2) - dt[var32];
                        var51 -= (float) (Math.PI * 2) * (float)Math.floor((double)((var51 + (float) Math.PI) / (float) (Math.PI * 2)));
                        dt[var32] = dt[var32] + var51 * var50 * var22;
                     }

                     float var70 = (var34 - 0.6F) * 2.5F;
                     var70 = var70 < 0.0F ? 0.0F : (var70 > 1.0F ? 1.0F : var70);
                     float var74 = Math.min(1.0F, var33 * 25.0F) * (1.0F - var70 * var70 * (3.0F - 2.0F * var70));
                     float var52 = ds[var32] * (1.0F - 0.45F * var34 * var34);
                     int var53 = RegionPassCache.nST;
                     if (var53 < (-1166616948 ^ -1166617972)) {
                        int var54 = var53 * 8;
                        var30[var54] = var40;
                        var30[var54 + 1] = var41;
                        var30[var54 + 2] = var42;
                        var30[var54 + 3] = var52;
                        var30[var54 + 4] = var52;
                        var30[var54 + 5] = dt[var32];
                        var30[var54 + 6] = 6.0F;
                        var30[var54 + 7] = Float.intBitsToFloat((int)(0.95F * var74 * 255.0F + 0.5F) << 24 | var9);
                        RegionPassCache.nST = var53 + 1;
                     }

                     int var75 = RegionPassCache.nSA;
                     if (var75 < (943448999 ^ 943453095)) {
                        int var55 = var75 * 8;
                        var29[var55] = var40;
                        var29[var55 + 1] = var41;
                        var29[var55 + 2] = var42;
                        var29[var55 + 3] = 2.5F * var52;
                        var29[var55 + 4] = 2.5F * var52;
                        var29[var55 + 5] = 0.0F;
                        var29[var55 + 6] = 4.0F;
                        var29[var55 + 7] = Float.intBitsToFloat((int)(0.45F * var74 * 255.0F + 0.5F) << 24 | var13);
                        RegionPassCache.nSA = var75 + 1;
                     }
                  } else {
                     float var61;
                     float var62;
                     float var63;
                     byte var64;
                     int var65;
                     if (var43 == 3) {
                        float var66 = 1.0F - var34;
                        var63 = 0.28F * Math.min(1.0F, var33 * 20.0F) * var66 * var66;
                        var61 = ds[var32] * (0.85F + 0.3F * var34);
                        var62 = 0.0F;
                        var64 = 4;
                        var65 = var15;
                     } else {
                        float var67 = (var34 - 0.4F) * 1.6666666F;
                        var67 = var67 < 0.0F ? 0.0F : (var67 > 1.0F ? 1.0F : var67);
                        var63 = Math.min(1.0F, var33 * 33.333332F) * (1.0F - var67 * var67 * (3.0F - 2.0F * var67));
                        if (var43 == 1) {
                           var61 = ds[var32] * (1.0F - 0.5F * var34);
                           var62 = dt[var32] + du[var32] * var33;
                           var64 = 7;
                           var65 = var14;
                        } else {
                           var61 = ds[var32] * (1.0F - 0.3F * var34);
                           var62 = 0.0F;
                           var64 = 3;
                           var65 = 1595699614 ^ 1608748641;
                        }
                     }

                     int var69 = RegionPassCache.nSA;
                     if (var69 < (-1160498796 ^ -1160502892)) {
                        int var72 = var69 * 8;
                        var29[var72] = var40;
                        var29[var72 + 1] = var41;
                        var29[var72 + 2] = var42;
                        var29[var72 + 3] = var61;
                        var29[var72 + 4] = var61;
                        var29[var72 + 5] = var62;
                        var29[var72 + 6] = (float)var64;
                        var29[var72 + 7] = Float.intBitsToFloat((int)(var63 * 255.0F + 0.5F) << 24 | var65);
                        RegionPassCache.nSA = var69 + 1;
                     }
                  }
               }
            }
         }

         return var31;
      } catch (RuntimeException var56) {
         throw var56;
      }
   }

   static {
      for (int var0 = 0; var0 <= 13; var0++) {
         aq[var0] = -1;
      }

      for (int var3 = 0; var3 <= 32; var3++) {
         double var1 = (Math.PI * 2) * (double)(var3 % 32) / 32.0;
         cz[var3] = (float)Math.cos(var1);
         da[var3] = (float)Math.sin(var1);
      }
   }
}
