package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.client.MinecraftClient;
import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.RaycastContext;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.client.render.Camera;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.hit.HitResult;
public final class EchoPassCache {
   public static final int SOUL = 0;
   public static final int SHOCKWAVE = 1;
   public static final int SHATTER = 2;
   public static final int LIGHTNING = 3;
   public static final int SUPERNOVA = 4;
   public static final int VOID = 5;
   public static final int RANDOM = 6;
   public static boolean on;
   public static boolean aa = true;
   public static boolean ab = true;
   public static boolean ac;
   public static boolean ad;
   public static int ae = 1;
   public static int pal = -3;
   public static int max = 4;
   public static float af = 1.0F;
   public static float ag = 1.0F;
   public static int HIDE_N;
   private static final int ah = 8;
   private static final int ai = 160;
   private static final int aj = 9;
   private static final int ak = 8;
   private static final int al = 1440;
   private static final int am = 0;
   private static final int an = 1;
   private static final int ao = 2;
   private static final int ap = 3;
   private static final int aq = 4;
   private static final int ar = 6;
   private static final int as = 7;
   private static final int at = 8;
   private static final int au = 9;
   private static final int av = 17;
   private static final int aw = 18;
   private static final int ax = 21;
   private static final int ay = 22;
   private static final int az = 23;
   private static final int ba = 24;
   private static final int bb = 25;
   private static final int bc = 26;
   private static final float bd = 0.9F;
   private static final float be = 0.86F;
   private static final float bf = 1.25F;
   private static final float bg = 0.22F;
   private static final float bh = (float) Math.PI;
   private static final float bi = (float) (Math.PI * 2);
   private static final float bj = (float) (Math.PI / 2);
   private static final float bk = (float) (Math.PI / 180.0);
   private static final float bl = 6.931472F;
   private static final float[] bm = new float[]{2.8F, 1.6F, 2.1F, 1.8F, 2.3F, 1.6F};
   private static final float[] bn = new float[]{0.14F, 0.05F, 0.06F, 0.09F, 0.15F, 0.2F};
   private static final float bo = 0.16F;
   private static final float bp = 0.14F;
   private static final float bq = 0.55F;
   private static final float br = 0.3F;
   private static final int bs = 0;
   private static final int bt = 1;
   private static final int bu = 2;
   private static final int bv = 3;
   private static final int bw = 4;
   private static final int bx = 5;
   private static final int by = 6;
   private static final float bz = 0.3208F;
   private static final float ca = 0.9165F;
   private static final float cb = -0.2395F;
   private static final int cc = 0;
   private static final int cd = 1;
   private static final int ce = 2;
   private static final int cf = 3;
   private static final int cg = 4;
   private static final int ch = 0;
   private static final int ci = 1;
   private static final boolean[] cj = new boolean[9];
   private static final boolean[] ck = new boolean[9];
   private static final boolean[] cl = new boolean[9];
   private static final boolean[] cm = new boolean[9];
   private static final int[] cn = new int[9];
   private static final int[] co = new int[9];
   private static final int[] cp = new int[9];
   private static final int[] cq = new int[9];
   private static final float[] cr = new float[9];
   private static final double[] cs = new double[9];
   private static final double[] ct = new double[9];
   private static final double[] cu = new double[9];
   private static final double[] cv = new double[9];
   private static final double[] cw = new double[9];
   private static final float[] cx = new float[9];
   private static final float[] cy = new float[9];
   private static final float[] cz = new float[9];
   private static final float[] da = new float[9];
   private static final float[] db = new float[9];
   private static final float[] dc = new float[9];
   private static final float[] dd = new float[9];
   private static final float[] de = new float[9];
   private static final float[] df = new float[9];
   private static final float[] dg = new float[9];
   private static final float[] dh = new float[9];
   private static final float[] di = new float[9];
   private static final long[] dj = new long[9];
   private static final LivingEntity[] dk = new LivingEntity[9];
   private static int dl;
   private static int dm = -1;
   private static final float[] dn = new float[324];
   private static final float[] _kwren_do= new float[7695];
   private static final float[] dp = new float[27];
   private static final float[] dq = new float[27];
   private static final float[] dr = new float[648];
   private static final float[] ds = new float[576];
   private static final float[] dt = new float[324];
   private static final float[] du = new float[432];
   private static final float[] dv = new float[54];
   private static final float[] dw = new float[1512];
   private static final float[] dx = new float[792];
   private static final float[] dy = new float[6];
   private static final float[] dz = new float[24];
   private static final int[] ea = new int[1440];
   private static final float[] eb = new float[1440];
   private static final float[] ec = new float[1440];
   private static final float[] ed = new float[1440];
   private static final float[] ee = new float[1440];
   private static final float[] ef = new float[1440];
   private static final float[] eg = new float[1440];
   private static final float[] eh = new float[1440];
   private static final float[] ei = new float[1440];
   private static final float[] ej = new float[1440];
   private static final float[] ek = new float[1440];
   private static final float[] el = new float[1440];
   private static final float[] em = new float[1440];
   private static final float[] en = new float[1440];
   private static final float[] eo = new float[1440];
   private static final float[] ep = new float[1440];
   private static final float[] eq = new float[1440];
   private static final float[] er = new float[1440];
   private static final float[] es = new float[1440];
   private static final float[] et = new float[1440];
   private static final float[] eu = new float[1440];
   private static final float[] ev = new float[1440];
   private static final float[] ew = new float[1440];
   private static final float[] ex = new float[1440];
   private static final float[] ey = new float[1440];
   private static final float[] ez = new float[1440];
   private static final float[] fa = new float[1440];
   private static final float[] fb = new float[1440];
   private static final float[] fc = new float[1440];
   private static final int fd = 2048;
   private static final int fe = 256;
   private static final int ff = 96;
   private static final float[] fg = new float[6144];
   private static final float[] fh = new float[2304];
   private static final float[] fi = new float[1536];
   private static int fj;
   private static int fk;
   private static int fl;
   private static final float[] fm = new float[768];
   private static final float[] fn = new float[15];
   private static final float[] fo = new float[192];
   private static final int[] fp = new int[64];
   private static final int[] fq = new int[33];
   private static final float[] fr = new float[33];
   private static final float[] fs = new float[33];
   private static int ft = 16777215;
   private static int fu = 16777215;
   private static int fv = 16777215;
   private static int fw = 10132128;
   private static final int[] fx = new int[21];
   private static final int[] fy = new int[21];
   private static final int fz = 8;
   private static final int[] ga = new int[8];
   private static final double[] gb = new double[8];
   private static final double[] gc = new double[8];
   private static final boolean[] gd = new boolean[8];
   private static float ge;
   private static boolean gf;
   private static float gg = 1.0F;
   private static final float gh = 4.0F;
   private static float gi = 1.0F;
   private static float gj = 1.0F;
   private static final Random gk = new Random();
   private static final Random gl = new Random();
   private static final Random gm = new Random();
   private static final Random gn = new Random();
   private static final Random go = new Random();
   private static final float[] gp = new float[]{
      -0.25F,
      1.4F,
      -0.25F,
      0.25F,
      1.875F,
      0.25F,
      -0.25F,
      0.7F,
      -0.125F,
      0.25F,
      1.4F,
      0.125F,
      -0.5F,
      0.7F,
      -0.125F,
      -0.25F,
      1.4F,
      0.125F,
      0.25F,
      0.7F,
      -0.125F,
      0.5F,
      1.4F,
      0.125F,
      -0.25F,
      0.0F,
      -0.125F,
      0.0F,
      0.7F,
      0.125F,
      0.0F,
      0.0F,
      -0.125F,
      0.25F,
      0.7F,
      0.125F
   };
   private static final int[] gq = new int[]{0, 1, 3, 2, 4, 6, 7, 5, 0, 4, 5, 1, 2, 3, 7, 6, 0, 2, 6, 4, 1, 5, 7, 3};
   private static final float[] gr = new float[]{0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F};
   private static final int[] gs = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 0, 2, 1, 3, 4, 6, 5, 7, 0, 4, 1, 5, 2, 6, 3, 7};
   private static final float[] gt = new float[]{0.0F, 0.1F, 0.32F, 0.62F, 1.0F};
   private static final float[] gu = new float[]{0.3F, 0.35F, 0.25F, 0.1F, 0.0F};
   private static final float[] gv = new float[]{0.34F, 0.48F, 0.36F, 0.16F, 0.0F};
   private static final float[] gw = new float[]{0.8F, 1.0F, 0.72F, 0.32F, 0.0F};
   private static final float[] gx = new float[]{0.95F, 1.0F, 0.85F, 0.4F, 0.0F};
   private static final float[] gy = new float[]{0.0F, 0.06F, 0.14F};
   private static final float[] gz = new float[]{3.4F, 2.5F, 4.4F};
   private static final float[] ha = new float[]{0.7F, 0.6F, 0.95F};
   private static final float[] hb = new float[14];
   private static final float[] hc = new float[14];
   private static final float[] hd = new float[14];
   private static final int[] he = new int[]{8, 14, 21};
   private static final int[] hf = new int[]{0, 0, 2};
   private static final int[] hg = new int[]{4, 2, 2};
   public static int hh;
   public static float hi;
   public static float hj;
   private static final double hk = 3.2;
   private static int hl;
   private static int hn = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   private EchoPassCache() {
   }

   public static void a() {

      if (dl != 0 || gf || HIDE_N != 0) {
         MinecraftClient var0 = null;
         LivingEntity var1 = null;

         assert cj.length == 9
            && cn.length == 9
            && cr.length == 9
            && cs.length == 9
            && ct.length == 9
            && cu.length == 9
            && cv.length == 9
            && cx.length == 9
            && cz.length == 9
            && de.length == 9
            && df.length == 9
            && dg.length == 9
            && dh.length == 9
            && cp.length == 9
            && bm.length == 6
            && bn.length == 6
            && gd.length == 8
            && gc.length == 8
            && fx.length == 21
            && fy.length == 21
            && fg.length == (-1877320115 ^ -1877326259)
            && fh.length == (-477998615 ^ -477996823)
            && fi.length == (886805567 ^ 886805055)
            && RegionPassCache.SB.length == (-1121951877 ^ -1121955973)
            && RegionPassCache.LB.length == (702450001 ^ 702455633);

         try {
            float var2 = RegionPassCache.dt;
            double var3 = RegionPassCache.now;
            int var5 = 0;

            for (int var6 = 0; var6 < 8; var6++) {
               if (gd[var6]) {
                  if (var3 >= gc[var6]) {
                     gd[var6] = false;
                  } else {
                     var5++;
                  }
               }
            }

            HIDE_N = var5;
            if (dl != 0 || gf) {
               c();
               int var53 = ft;
               fj = 0;
               fk = 0;
               fl = 0;
               float var7 = 1.0F - (float)Math.exp((double)(-12.0F * var2));
               double var8 = RegionPassCache.z;
               double var10 = RegionPassCache.aa;
               double var12 = RegionPassCache.ab;
               int var14 = 0;

               for (int var15 = 0; var15 < 8; var15++) {
                  if (cj[var15]) {
                     if (cr[var15] < 0.0F) {
                        j(var15);
                        if (!cj[var15]) {
                           continue;
                        }
                     } else {
                        cr[var15] = cr[var15] + var2;
                     }

                     int var16 = cn[var15];
                     float var17 = cr[var15];
                     float var18 = bm[var16];
                     if (var17 >= var18) {
                        cj[var15] = false;
                     } else {
                        var14++;
                        de[var15] = de[var15] + (df[var15] - de[var15]) * var7;
                        double var19 = cs[var15] - var8;
                        double var21 = ct[var15] + 0.55 * (double)cx[var15] - var10;
                        double var23 = cu[var15] - var12;
                        float var25 = (float)Math.sqrt(var19 * var19 + var21 * var21 + var23 * var23);
                        float var26 = (var25 - 56.0F) * 0.125F;
                        var26 = var26 < 0.0F ? 0.0F : (var26 > 1.0F ? 1.0F : var26);
                        float var27 = 1.0F - var26 * var26 * (3.0F - 2.0F * var26);
                        var26 = (var17 - (var18 - 0.3F)) / 0.3F;
                        var26 = var26 < 0.0F ? 0.0F : (var26 > 1.0F ? 1.0F : var26);
                        var27 *= 1.0F - var26 * var26 * (3.0F - 2.0F * var26);
                        var26 = (var25 - 1.2F) / 1.8F;
                        var26 = var26 < 0.0F ? 0.0F : (var26 > 1.0F ? 1.0F : var26);
                        dh[var15] = var26 * var26 * (3.0F - 2.0F * var26);
                        dg[var15] = var27;
                        if (!(var27 < 0.002F)) {
                           if (var16 == 0) {
                              q(var15);
                           } else if (var16 == 1) {
                              r(var15);
                           } else if (var16 == 2) {
                              s(var15);
                           } else if (var16 == 3) {
                              t(var15);
                           } else if (var16 == 4) {
                              u(var15);
                           } else {
                              v(var15);
                           }

                           if (cp[var15] > 0) {
                              w(var15);
                              if (var16 == 2) {
                                 x(var15);
                              }
                           }
                        }
                     }
                  }
               }

               dl = var14;
               if (fk > 0) {
                  y();
               }

               if (fl > 0) {
                  z();
               }

               if (gf) {
                  ge += var2;
                  float var54 = ge;
                  float var55 = 0.55F * Math.min(1.0F, var54 / 0.04F) * (float)Math.exp((double)(-var54 / 0.18F));
                  if (var54 > 0.04F && var55 < 0.004F) {
                     gf = false;
                     gi = 1.0F;
                     gj = 1.0F;
                  } else {
                     var0 = MinecraftClient.getInstance();
                     float var56 = (float)var0.getWindow().getFramebufferWidth();
                     float var57 = (float)var0.getWindow().getFramebufferHeight();
                     if (var0.player != null && var0.getCameraEntity() == var0.player) {
                        float var58 = var0.player
                           .getFovMultiplier(var0.options.getPerspective().isFirstPerson(), ((Double)var0.options.getFovEffectScale().getValue()).floatValue());
                        if (var58 > gg) {
                           gg = var58 > 1.5F ? 1.5F : var58;
                        }
                     }

                     int var59 = RegionPassCache.nSB;
                     if (var56 >= 1.0F && var57 >= 1.0F && var59 < (-904944598 ^ -904944086) && var55 > 0.002F) {
                        float var20 = var57 / (2.0F * RegionPassCache.ac);
                        if (gg > 1.0F) {
                           var20 = (float)Math.tan(Math.atan((double)var20) * (double)gg);
                        }

                        float var60 = var20 * var56 / var57;
                        float var22 = 4.32F;
                        float var61 = 1.0F;
                        float var24 = 1.0F;
                        if (var0.getCameraEntity() instanceof LivingEntity) {
                           var1 = (LivingEntity)var0.getCameraEntity();
                           float var64 = RegionPassCache.td;
                           float var71 = 0.0F;
                           float var74 = 0.0F;
                           float var28 = 0.0F;
                           float var29 = (float)var1.hurtTime - var64;
                           if (var1.isDead()) {
                              var71 = (40.0F - 8000.0F / (Math.min((float)var1.deathTime + var64, 20.0F) + 200.0F)) * (float) (Math.PI / 180.0);
                           }

                           if (var29 >= 0.0F && var1.maxHurtTime > 0) {
                              var29 /= (float)var1.maxHurtTime;
                              var74 = -((float)Math.sin((double)(var29 * var29 * var29 * var29 * (float) Math.PI)))
                                 * 14.0F
                                 * (float) (Math.PI / 180.0)
                                 * ((Double)var0.options.getDamageTiltStrength().getValue()).floatValue();
                              var28 = var1.getDamageTiltYaw() * (float) (Math.PI / 180.0);
                           }

                           if (var71 != 0.0F || var74 != 0.0F) {
                              float var30 = (float)Math.cos((double)var71);
                              float var31 = (float)Math.sin((double)var71);
                              float var32 = (float)Math.cos((double)var28);
                              float var33 = (float)Math.sin((double)var28);
                              float var34 = (float)Math.cos((double)var74);
                              float var35 = (float)Math.sin((double)var74);
                              float var36 = var60;
                              float var37 = var20;

                              for (int var38 = 0; var38 < 4; var38++) {
                                 float var39 = (var38 & 1) == 0 ? var60 : -var60;
                                 float var40 = var38 < 2 ? var20 : -var20;
                                 float var41 = var39 * var30 + var40 * var31;
                                 float var42 = var40 * var30 - var39 * var31;
                                 float var43 = var41 * var32 - var33;
                                 float var44 = -var41 * var33 - var32;
                                 float var45 = var43 * var34 + var42 * var35;
                                 float var46 = var42 * var34 - var43 * var35;
                                 float var47 = -(var45 * var33 + var44 * var32);
                                 if (var47 < 0.05F) {
                                    var36 = 3.0F * var60;
                                    var37 = 3.0F * var20;
                                    break;
                                 }

                                 float var48 = Math.abs((var45 * var32 - var44 * var33) / var47);
                                 float var49 = Math.abs(var46 / var47);
                                 var36 = var48 > var36 ? var48 : var36;
                                 var37 = var49 > var37 ? var49 : var37;
                              }

                              var61 = var36 / var60;
                              var24 = var37 / var20;
                              var61 = var61 > 3.0F ? 3.0F : var61;
                              var24 = var24 > 3.0F ? 3.0F : var24;
                           }
                        }

                        gi = gi <= var61 + 5.0E-4F ? var61 : gi + (var61 - gi) * var7;
                        gj = gj <= var24 + 5.0E-4F ? var24 : gj + (var24 - gj) * var7;
                        float[] var65 = RegionPassCache.SB;
                        int var72 = var59 * 8;
                        var65[var72] = 4.0F * RegionPassCache.fX;
                        var65[var72 + 1] = 4.0F * RegionPassCache.fY;
                        var65[var72 + 2] = 4.0F * RegionPassCache.fZ;
                        var65[var72 + 3] = var22 * var60 * gi;
                        var65[var72 + 4] = var22 * var20 * gj;
                        var65[var72 + 5] = 0.0F;
                        var65[var72 + 6] = 23.0F;
                        var65[var72 + 7] = Float.intBitsToFloat(Math.min(-181243286 ^ -181243243, (int)(var55 * 255.0F + 0.5F)) << 24 | var53);
                        RegionPassCache.nSB = var59 + 1;
                     }
                  }
               }
            }
         } catch (RuntimeException var50) {
            throw var50;
         }
      }
   }

   public static void b() {
      int var0 = 0;
      byte var1 = 0;

      label22:
      while (true) {
         switch (var1) {
            case 0:
            default:
               if (hn != 0) {
                  System.nanoTime();
                  var1 = 1;
                  break;
               }
            case 1:
               var0 = 0;
               var1 = 2;
               break;
            case 2:
               if (var0 < 8) {
                  cj[var0] = false;
                  dk[var0] = null;
                  cp[var0] = 0;
                  var0++;
                  var1 = 2;
                  break;
               }
            case 3:
               var0 = 0;
               var1 = 4;
               break;
            case 4:
               if (var0 < 8) {
                  gd[var0] = false;
                  var0++;
                  var1 = 4;
                  break;
               }
            case 5:
               break label22;
         }
      }

      HIDE_N = 0;
      dl = 0;
      gf = false;
      ge = 0.0F;
      gg = 1.0F;
      gi = 1.0F;
      gj = 1.0F;
      fj = 0;
      fk = 0;
      fl = 0;
   }

   private static void c() {

      assert fx.length == 21
         && fy.length == 21
         && fg.length == (-1449221213 ^ -1449215069)
         && fh.length == (-374964586 ^ -374966378)
         && fi.length == (-469291467 ^ -469293003)
         && fr.length == 33
         && fs.length == 33
         && bm.length == 6
         && bn.length == 6
         && cj.length == 9
         && cn.length == 9
         && cr.length == 9
         && RegionPassCache.SB.length == (-1932225697 ^ -1932229793);

      try {
         int var0 = pal;
         int var1 = RegionPassCache.col(var0) & (496577345 ^ 493278398);
         int var2;
         if (var0 == -3) {
            var2 = RegionPassCache.ag & (-1545993199 ^ -1557791762);
         } else if (var0 == -4) {
            var2 = RegionPassCache.af & (-1605101788 ^ -1599346469);
         } else {
            int var3 = var1 >> 16 & (-1306011641 ^ -1306011400);
            int var4 = var1 >> 8 & (1122187658 ^ 1122187637);
            int var5 = var1 & (462582539 ^ 462582772);
            int var6 = var3 > var4 ? (var3 > var5 ? var3 : var5) : (var4 > var5 ? var4 : var5);
            int var7 = var3 < var4 ? (var3 < var5 ? var3 : var5) : (var4 < var5 ? var4 : var5);
            if (var6 != 0 && !((float)(var6 - var7) < 0.15F * (float)var6)) {
               float var8 = (float)(var6 - var7);
               float var9 = var6 == var3
                  ? (float)(var4 - var5) / var8
                  : (var6 == var4 ? 2.0F + (float)(var5 - var3) / var8 : 4.0F + (float)(var3 - var4) / var8);
               var9 = var9 / 6.0F + 0.083F;
               var9 -= (float)Math.floor((double)var9);
               var2 = MathHelper.hsvToRgb(var9, var8 / (float)var6 * 0.85F, (float)var6 / 255.0F) & (-1196501275 ^ -1202640614);
            } else {
               var2 = var1;
            }
         }

         ft = var1;
         fu = var2;
         int var12 = var1 >> 16 & (-1056284609 ^ -1056284480);
         int var13 = var1 >> 8 & (2103774528 ^ 2103774655);
         int var14 = var1 & (-235168352 ^ -235168417);
         int var15 = var2 >> 16 & (1810086680 ^ 1810086887);
         int var16 = var2 >> 8 & (-729178524 ^ -729178469);
         int var17 = var2 & (-1350181440 ^ -1350181569);

         for (int var20 = 0; var20 <= 20; var20++) {
            float var10 = (float)var20 * 0.05F;
            fx[var20] = (int)((float)var12 + (float)((-191960987 ^ -191960934) - var12) * var10 + 0.5F) << 16
               | (int)((float)var13 + (float)((1801963986 ^ 1801963821) - var13) * var10 + 0.5F) << 8
               | (int)((float)var14 + (float)((659836256 ^ 659836319) - var14) * var10 + 0.5F);
            fy[var20] = (int)((float)var15 + (float)((-1613054187 ^ -1613053974) - var15) * var10 + 0.5F) << 16
               | (int)((float)var16 + (float)((-218535316 ^ -218535277) - var16) * var10 + 0.5F) << 8
               | (int)((float)var17 + (float)((811679210 ^ 811678997) - var17) * var10 + 0.5F);
         }

         fv = (int)((float)var12 + (float)(var15 - var12) * 0.25F + 0.5F) << 16
            | (int)((float)var13 + (float)(var16 - var13) * 0.25F + 0.5F) << 8
            | (int)((float)var14 + (float)(var17 - var14) * 0.25F + 0.5F);
         fw = (int)((float)var12 + (float)((-254224238 ^ -254224376) - var12) * 0.7F + 0.5F) << 16
            | (int)((float)var13 + (float)((-1415404426 ^ -1415404308) - var13) * 0.7F + 0.5F) << 8
            | (int)((float)var14 + (float)((739678067 ^ 739678163) - var14) * 0.7F + 0.5F);
      } catch (RuntimeException var11) {
         throw var11;
      }
   }

   public static void d(double var0, double var2, float var4) {

      int var5 = ae;
      if (var5 < 0 || var5 > 5) {
         var5 = ThreadLocalRandom.current().nextInt(6);
         if (var5 == hl) {
            var5 = (var5 + 1 + ThreadLocalRandom.current().nextInt(5)) % 6;
         }

         hl = var5;
      }

      byte var6 = 8;
      cj[var6] = true;
      cn[var6] = var5;
      ck[var6] = true;
      cr[var6] = -1.0F;
      cs[var6] = var0;
      ct[var6] = 0.0;
      cu[var6] = var2;
      cv[var6] = 0.015;
      cm[var6] = true;
      cw[var6] = 3.2;
      cx[var6] = 1.8F;
      cy[var6] = 0.6F;
      cz[var6] = af > 0.0F ? Math.min(af, 4.0F) : 1.0F;
      co[var6] = -1;
      dk[var6] = null;
      da[var6] = var4 * (float) (Math.PI / 180.0);
      dd[var6] = 1.0F;
      cl[var6] = true;
      de[var6] = 1.0F;
      df[var6] = 1.0F;
      cp[var6] = 0;
      dj[var6] = ThreadLocalRandom.current().nextLong();
      hh = var5;
      hi = bm[var5];
      hj = aa ? bn[var5] : -1.0F;
   }

   public static void e() {

      cj[8] = false;
      dk[8] = null;
      cp[8] = 0;
   }

   public static void f() {

      byte var0 = 8;
      if (RegionPassCache.PV && cj[var0]) {
         c();
         fj = 0;
         fk = 0;
         fl = 0;
         if (cr[var0] < 0.0F) {
            j(var0);
            if (!cj[var0]) {
               return;
            }
         } else {
            cr[var0] = cr[var0] + RegionPassCache.dt;
         }

         int var1 = cn[var0];
         float var2 = cr[var0];
         float var3 = bm[var1];
         if (var2 >= var3) {
            cj[var0] = false;
         } else {
            de[var0] = 1.0F;
            double var4 = cs[var0] - RegionPassCache.z;
            double var6 = ct[var0] + 0.55 * (double)cx[var0] - RegionPassCache.aa;
            double var8 = cu[var0] - RegionPassCache.ab;
            float var10 = (float)Math.sqrt(var4 * var4 + var6 * var6 + var8 * var8);
            float var11 = (var10 - 56.0F) * 0.125F;
            var11 = var11 < 0.0F ? 0.0F : (var11 > 1.0F ? 1.0F : var11);
            float var12 = 1.0F - var11 * var11 * (3.0F - 2.0F * var11);
            var11 = (var2 - (var3 - 0.3F)) / 0.3F;
            var11 = var11 < 0.0F ? 0.0F : (var11 > 1.0F ? 1.0F : var11);
            var12 *= 1.0F - var11 * var11 * (3.0F - 2.0F * var11);
            var11 = (var10 - 1.2F) / 1.8F;
            var11 = var11 < 0.0F ? 0.0F : (var11 > 1.0F ? 1.0F : var11);
            dh[var0] = var11 * var11 * (3.0F - 2.0F * var11);
            dg[var0] = var12;
            if (!(var12 < 0.002F)) {
               if (var1 == 0) {
                  q(var0);
               } else if (var1 == 1) {
                  r(var0);
               } else if (var1 == 2) {
                  s(var0);
               } else if (var1 == 3) {
                  t(var0);
               } else if (var1 == 4) {
                  u(var0);
               } else {
                  v(var0);
               }

               if (cp[var0] > 0) {
                  w(var0);
                  if (var1 == 2) {
                     x(var0);
                  }
               }

               if (fk > 0) {
                  y();
               }

               if (fl > 0) {
                  z();
               }
            }
         }
      }
   }

   public static void g(LivingEntity var0, boolean var1) {

      MinecraftClient var2 = MinecraftClient.getInstance();
      ClientWorld var3 = null;
      Object var4 = null;
      Object var5 = null;
      Vec3d var6 = null;
      BlockHitResult var7 = null;
      if (var0 != null && on) {
         var3 = var2.world;
         if (var3 != null) {
            try {
               int var8 = max < 1 ? 1 : (max > 8 ? 8 : max);
               int var9 = 0;
               int var10 = -1;
               int var11 = -1;
               float var12 = -1.0F;

               for (int var13 = 0; var13 < 8; var13++) {
                  if (!cj[var13]) {
                     if (var10 < 0) {
                        var10 = var13;
                     }
                  } else {
                     var9++;
                     float var14 = cr[var13] < 0.0F ? 0.0F : cr[var13] / bm[cn[var13]];
                     if (var14 > var12) {
                        var12 = var14;
                        var11 = var13;
                     }
                  }
               }

               int var44 = var9 < var8 && var10 >= 0 ? var10 : var11;
               if (var44 < 0) {
                  return;
               }

               int var45 = ae;
               if (var45 < 0 || var45 > 5) {
                  var45 = ThreadLocalRandom.current().nextInt(6);
                  if (var45 == dm) {
                     var45 = ThreadLocalRandom.current().nextInt(6);
                  }

                  dm = var45;
               }

               double var15 = var0.getX();
               double var17 = var0.getY();
               double var19 = var0.getZ();
               float var21 = var0.getHeight();
               float var22 = var0.getWidth();
               float var23 = af > 0.0F ? Math.min(af, 4.0F) : 1.0F;
               float var24 = var21 / 1.8F;
               var24 = var24 < 0.6F ? 0.6F : (var24 > 1.8F ? 1.8F : var24);
               float var25 = var23 * var24;
               var4 = new Vec3d(var15, var17 + 0.1, var19);
               var5 = new Vec3d(var15, var17 - 6.0, var19);
               var7 = var3.raycast(new RaycastContext((Vec3d)var4, (Vec3d)var5, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, var0));
               double var26 = var17 + 0.015;
               boolean var28 = false;
               if (var7 != null && var7.getType() == HitResult.Type.BLOCK) {
                  var6 = var7.getPos();
                  var26 = var6.y + 0.015;
                  var28 = true;
               }

               var4 = new Vec3d(var15, var17 + (double)var21, var19);
               var5 = new Vec3d(var15, var17 + Math.max((double)var21 + 0.5, 14.0 * (double)var25), var19);
               var7 = var3.raycast(new RaycastContext((Vec3d)var4, (Vec3d)var5, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, var0));
               double var29 = Double.POSITIVE_INFINITY;
               if (var7 != null && var7.getType() == HitResult.Type.BLOCK) {
                  var6 = var7.getPos();
                  var29 = var6.y - 0.05;
               }

               cj[var44] = true;
               cn[var44] = var45;
               ck[var44] = var1;
               cr[var44] = -1.0F;
               cs[var44] = var15;
               ct[var44] = var17;
               cu[var44] = var19;
               cv[var44] = var26;
               cm[var44] = var28;
               cw[var44] = var29;
               cx[var44] = var21;
               cy[var44] = var22;
               cz[var44] = var25;
               co[var44] = var0.getId();
               dk[var44] = var0;
               da[var44] = var0.bodyYaw * (float) (Math.PI / 180.0);
               dd[var44] = 0.0F;
               cl[var44] = var0 instanceof PlayerEntity;
               de[var44] = 1.0F;
               df[var44] = 1.0F;
               cp[var44] = 0;
               dj[var44] = ThreadLocalRandom.current().nextLong();
               int var31 = 0;

               for (int var32 = 0; var32 < 8; var32++) {
                  if (cj[var32]) {
                     var31++;
                  }
               }

               dl = var31;
               if (var1 && ac) {
                  gf = true;
                  ge = 0.0F;
                  gg = 1.0F;
               }

               if (var1 && ab) {
                  double var47 = var17 + 0.55 * (double)var21;
                  if (var45 == 0) {
                     var3.playSoundClient(var15, var47, var19, SoundEvents.BLOCK_BEACON_DEACTIVATE, SoundCategory.PLAYERS, 0.55F, 1.35F, false);
                     var3.playSoundClient(var15, var47, var19, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.PLAYERS, 0.9F, 0.8F, false);
                  } else if (var45 == 1) {
                     var3.playSoundClient(var15, var47, var19, SoundEvents.ITEM_MACE_SMASH_GROUND_HEAVY, SoundCategory.PLAYERS, 0.5F, 1.15F, false);
                     var3.playSoundClient(var15, var47, var19, SoundEvents.ENTITY_FIREWORK_ROCKET_BLAST, SoundCategory.PLAYERS, 0.6F, 0.7F, false);
                  } else if (var45 == 2) {
                     var3.playSoundClient(var15, var47, var19, SoundEvents.BLOCK_AMETHYST_CLUSTER_BREAK, SoundCategory.PLAYERS, 1.0F, 0.75F, false);
                     var3.playSoundClient(var15, var47, var19, SoundEvents.BLOCK_GLASS_BREAK, SoundCategory.PLAYERS, 0.5F, 1.25F, false);
                  } else if (var45 == 3) {
                     var3.playSoundClient(var15, var47, var19, SoundEvents.ENTITY_LIGHTNING_BOLT_IMPACT, SoundCategory.PLAYERS, 0.45F, 1.25F, false);
                     var3.playSoundClient(var15, var47, var19, SoundEvents.ENTITY_FIREWORK_ROCKET_TWINKLE, SoundCategory.PLAYERS, 0.35F, 1.6F, false);
                  } else if (var45 == 4) {
                     var3.playSoundClient(var15, var47, var19, SoundEvents.ENTITY_FIREWORK_ROCKET_LARGE_BLAST, SoundCategory.PLAYERS, 0.6F, 0.75F, false);
                     var3.playSoundClient(var15, var47, var19, SoundEvents.BLOCK_BEACON_ACTIVATE, SoundCategory.PLAYERS, 0.5F, 1.8F, false);
                  } else {
                     var3.playSoundClient(var15, var47, var19, SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT, SoundCategory.PLAYERS, 0.6F, 0.55F, false);
                     var3.playSoundClient(var15, var47, var19, SoundEvents.BLOCK_CONDUIT_DEACTIVATE, SoundCategory.PLAYERS, 0.6F, 1.2F, false);
                  }
               }
            } catch (Throwable var34) {
            }
         }
      }
   }

   public static void h() {

      if (dl != 0) {
         MinecraftClient var0 = MinecraftClient.getInstance();
         ClientWorld var1 = var0.world;
         Camera var2 = null;
         Object var3 = null;
         Object var4 = null;
         Object var5 = null;
         BlockHitResult var6 = null;
         if (var1 != null && var0.gameRenderer != null) {
            try {
               var2 = var0.gameRenderer.getCamera();
               var3 = var0.getCameraEntity();
               if (var2 == null || var3 == null) {
                  return;
               }

               var4 = var2.getCameraPos();

               for (int var7 = 0; var7 < 8; var7++) {
                  if (cj[var7]) {
                     var5 = new Vec3d(cs[var7], ct[var7] + 0.55 * (double)cx[var7], cu[var7]);
                     var6 = var1.raycast(new RaycastContext((Vec3d)var4, (Vec3d)var5, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, (Entity)var3));
                     df[var7] = var6 != null && var6.getType() != HitResult.Type.MISS ? 0.0F : 1.0F;
                  }
               }
            } catch (Throwable var8) {
            }
         }
      }
   }

   public static boolean i(int var0) {

      if (HIDE_N == 0) {
         return false;
      } else {
         assert gd.length == 8
            && ga.length == 8
            && gb.length == 8
            && gc.length == 8
            && cj.length == 9
            && co.length == 9
            && bm.length == 6
            && bn.length == 6
            && fx.length == 21
            && fy.length == 21
            && fg.length == (2076016520 ^ 2076010376)
            && fh.length == (1824445295 ^ 1824447087)
            && fi.length == (760472012 ^ 760473548)
            && cn.length == 9
            && cr.length == 9
            && cs.length == 9
            && ct.length == 9
            && cu.length == 9
            && cx.length == 9
            && cz.length == 9
            && de.length == 9
            && dg.length == 9
            && dh.length == 9
            && cp.length == 9
            && fr.length == 33
            && fs.length == 33
            && fm.length == (-513335346 ^ -513336114)
            && fo.length == (725126961 ^ 725127153);

         try {
            double var1 = RegionPassCache.now;

            for (int var3 = 0; var3 < 8; var3++) {
               if (gd[var3] && ga[var3] == var0 && var1 >= gb[var3] && var1 < gc[var3]) {
                  return true;
               }
            }

            return false;
         } catch (RuntimeException var4) {
            throw var4;
         }
      }
   }

   private static void j(int var0) {

      LivingEntity var1 = dk[var0];

      assert var0 >= 0
         && var0 < 9
         && cj[var0]
         && cr[var0] < 0.0F
         && dn.length == (714680191 ^ 714679867)
         && gp.length == 36
         && eb.length == (881563245 ^ 881562573)
         && ec.length == (1991008988 ^ 1991010172)
         && eq.length == (-1734179609 ^ -1734180537)
         && ex.length == (-1081019657 ^ -1081018537)
         && er.length == (-1742537673 ^ -1742538345)
         && es.length == (-1262832761 ^ -1262832089)
         && et.length == (1242650602 ^ 1242649162)
         && eu.length == (44192901 ^ 44192037)
         && ev.length == (542539447 ^ 542538519)
         && ew.length == (1163704870 ^ 1163706246)
         && fb.length == (-2059277396 ^ -2059276788)
         && fc.length == (-653479150 ^ -653478222)
         && eg.length == (-1070418942 ^ -1070419550)
         && eh.length == (-1740550741 ^ -1740552181)
         && gd.length == 8
         && ga.length == 8
         && gb.length == 8
         && bm.length == 6
         && bn.length == 6;

      try {
         cj[var0] = false;
         dk[var0] = null;
         float var2 = RegionPassCache.td;
         if (var1 != null) {
            cs[var0] = var1.lastRenderX + (var1.getX() - var1.lastRenderX) * (double)var2;
            ct[var0] = var1.lastRenderY + (var1.getY() - var1.lastRenderY) * (double)var2;
            cu[var0] = var1.lastRenderZ + (var1.getZ() - var1.lastRenderZ) * (double)var2;
            da[var0] = MathHelper.lerpAngleDegrees(var2, var1.lastBodyYaw, var1.bodyYaw) * (float) (Math.PI / 180.0);
            dd[var0] = var1.deathTime > 0 ? (float)var1.deathTime + var2 : var2;
         }

         float var3 = da[var0];
         db[var0] = -((float)Math.cos((double)var3));
         dc[var0] = -((float)Math.sin((double)var3));
         cr[var0] = 0.0F;
         de[var0] = df[var0];
         int var4 = var0 * 36;
         if (cl[var0]) {
            float var5 = cy[var0] / 0.6F;
            float var6 = cx[var0] / 1.8F;

            for (int var7 = 0; var7 < 36; var7++) {
               int var8 = var7 % 6;
               dn[var4 + var7] = gp[var7] * (var8 != 1 && var8 != 4 ? var5 : var6);
            }

            cq[var0] = 6;
         } else {
            float var49 = cy[var0] * 0.5F;
            float var51 = cx[var0];
            dn[var4] = -var49;
            dn[var4 + 1] = 0.0F;
            dn[var4 + 2] = -var49;
            dn[var4 + 3] = var49;
            dn[var4 + 4] = 0.5F * var51;
            dn[var4 + 5] = var49;
            dn[var4 + 6] = -var49;
            dn[var4 + 7] = 0.5F * var51;
            dn[var4 + 8] = -var49;
            dn[var4 + 9] = var49;
            dn[var4 + 10] = var51;
            dn[var4 + 11] = var49;
            cq[var0] = 2;
         }

         gk.setSeed(dj[var0]);
         cp[var0] = 0;
         int var50 = cn[var0];
         if (var50 == 0) {
            k(var0);
         } else if (var50 == 1) {
            l(var0);
         } else if (var50 == 2) {
            m(var0);
         } else if (var50 == 3) {
            n(var0);
         } else if (var50 == 4) {
            o(var0);
         } else {
            p(var0);
         }

         float var52 = bm[var50] - 0.02F;
         int var53 = var0 * (-1101389806 ^ -1101389646);
         int var54 = var53 + cp[var0];

         for (int var9 = var53; var9 < var54; var9++) {
            if (eb[var9] + ec[var9] > var52) {
               ec[var9] = Math.max(0.05F, var52 - eb[var9]);
            }

            eq[var9] = Float.POSITIVE_INFINITY;
            ex[var9] = Float.POSITIVE_INFINITY;
            float var10 = fb[var9];
            double var11 = (double)eg[var9];
            double var13 = (double)eh[var9];
            if (var10 == var10 && var13 < 0.0 && var11 > 0.0) {
               double var15 = var13 / var11;
               double var17 = (double)ek[var9];
               double var19 = (double)el[var9];
               double var21 = (double)em[var9];
               double var23 = (double)en[var9];
               double var25 = (double)eo[var9];
               double var27 = (double)ep[var9];
               double var29 = (double)ec[var9];
               double var31 = 0.0;

               for (int var33 = 0; var33 < 2; var33++) {
                  double var34 = Math.exp(-var11 * var29);
                  if (var19 + var15 * var29 + (var25 - var15) * (1.0 - var34) / var11 > (double)var10) {
                     break;
                  }

                  double var36 = var25 > 0.0 ? Math.log((var25 - var15) / -var15) / var11 : 0.0;
                  double var38 = var29;
                  var36 = var36 < 0.0 ? 0.0 : (var36 > var29 ? var29 : var36);

                  for (int var40 = 0; var40 < 20; var40++) {
                     double var41 = 0.5 * (var36 + var38);
                     double var43 = Math.exp(-var11 * var41);
                     if (var19 + var15 * var41 + (var25 - var15) * (1.0 - var43) / var11 > (double)var10) {
                        var36 = var41;
                     } else {
                        var38 = var41;
                     }
                  }

                  double var59 = Math.exp(-var11 * var38);
                  double var42 = (1.0 - var59) / var11;
                  if (var33 == 0) {
                     eq[var9] = (float)var38;
                     float var44 = (float)(var17 + var23 * var42);
                     float var45 = (float)(var21 + var27 * var42);
                     double var46 = var15 + (var25 - var15) * var59;
                     er[var9] = var44;
                     es[var9] = var10;
                     et[var9] = var45;
                     eu[var9] = (float)(var23 * var59 * 0.55);
                     ev[var9] = (float)(-var46 * (double)fc[var9]);
                     ew[var9] = (float)(var27 * var59 * 0.55);
                     var17 = (double)var44;
                     var19 = (double)var10 + 1.0E-4;
                     var21 = (double)var45;
                     var23 = (double)eu[var9];
                     var25 = (double)ev[var9];
                     var27 = (double)ew[var9];
                     var31 = var38;
                     var29 = (double)ec[var9] - var38;
                     if (!(var29 > 1.0E-4)) {
                        break;
                     }
                  } else {
                     ex[var9] = (float)(var31 + var38);
                  }
               }
            }
         }

         if (aa && var0 != 8) {
            int var55 = 0;
            double var56 = Double.MAX_VALUE;

            for (int var12 = 0; var12 < 8; var12++) {
               if (!gd[var12]) {
                  var55 = var12;
                  break;
               }

               if (gc[var12] < var56) {
                  var56 = gc[var12];
                  var55 = var12;
               }
            }

            double var57 = RegionPassCache.now;
            ga[var55] = co[var0];
            gb[var55] = var57 + (double)bn[var50];
            gc[var55] = var57 + (double)bn[var50] + 3.0;
            if (!gd[var55]) {
               gd[var55] = true;
               HIDE_N++;
            }
         }

         cj[var0] = true;
      } catch (RuntimeException var48) {
         throw var48;
      }
   }

   private static void k(int var0) {

      assert var0 >= 0
         && var0 < 9
         && cn[var0] == 0
         && dr.length == (1931128994 ^ 1931129386)
         && ds.length == (824922144 ^ 824922720)
         && ea.length == (-140755495 ^ -140756871)
         && eb.length == (1127754203 ^ 1127754875)
         && ec.length == (-1802118611 ^ -1802117235)
         && ed.length == (68251975 ^ 68252903)
         && ee.length == (1537870872 ^ 1537870264)
         && ef.length == (-1665651039 ^ -1665651967)
         && eg.length == (-144413950 ^ -144413022)
         && eh.length == (-2049628794 ^ -2049630170)
         && ei.length == (1339923532 ^ 1339922924)
         && ej.length == (387431199 ^ 387432127)
         && ek.length == (220747148 ^ 220745772)
         && el.length == (-153598940 ^ -153599612)
         && em.length == (409844579 ^ 409845443)
         && en.length == (-1373315726 ^ -1373316910)
         && eo.length == (-578320389 ^ -578321829)
         && ep.length == (928479208 ^ 928477768)
         && fb.length == (-327603026 ^ -327603954)
         && fc.length == (829199011 ^ 829200131);

      try {
         Random var1 = gk;
         float var2 = cz[var0];
         float var3 = ag < 0.0F ? 0.0F : (ag > 2.0F ? 2.0F : ag);
         int var4 = var0 * 72;

         for (int var5 = 0; var5 < 12; var4 += 6) {
            dr[var4] = 0.05F + 0.4F * var1.nextFloat();
            dr[var4 + 1] = (0.6F + 0.5F * var1.nextFloat()) * var2;
            dr[var4 + 2] = (2.2F + var1.nextFloat()) * ((var5 & 1) == 0 ? 1.0F : -1.0F);
            dr[var4 + 3] = (1.6F + var1.nextFloat()) * var2;
            dr[var4 + 4] = var1.nextFloat() * (float) (Math.PI * 2);
            dr[var4 + 5] = 1.6F + 0.6F * var1.nextFloat();
            var5++;
         }

         var4 = var0 * 64;

         for (int var15 = 0; var15 < 16; var4 += 4) {
            ds[var4] = 0.12F + 0.09F * (float)var15 + 0.05F * var1.nextFloat();
            ds[var4 + 1] = (7.0F + 3.0F * var1.nextFloat()) * var2;
            float var6 = (0.05F + 0.13F * var1.nextFloat()) * var2;
            float var7 = var1.nextFloat() * (float) (Math.PI * 2);
            ds[var4 + 2] = (float)Math.cos((double)var7) * var6;
            ds[var4 + 3] = (float)Math.sin((double)var7) * var6;
            var15++;
         }

         float var16 = (float)(cv[var0] - ct[var0]);
         int var17 = var0 * (-1387778011 ^ -1387777915);
         int var18 = cp[var0];
         int var8 = (int)(22.0F * var3 + 0.5F);

         for (int var9 = 0; var9 < var8 && var18 < (-2066796646 ^ -2066796742); var18++) {
            int var10 = var17 + var18;
            float var11 = var1.nextFloat() * (float) (Math.PI * 2);
            float var12 = (float)Math.sqrt((double)var1.nextFloat()) * 0.9F * var2;
            ea[var10] = 3;
            eb[var10] = 0.1F + 0.8F * var1.nextFloat();
            ec[var10] = 1.2F + var1.nextFloat();
            ed[var10] = (0.025F + 0.015F * var1.nextFloat()) * var2;
            ee[var10] = 0.0F;
            ef[var10] = 0.0F;
            eg[var10] = 0.2F;
            eh[var10] = 0.001F;
            ei[var10] = var1.nextFloat();
            ej[var10] = 1.0F;
            ek[var10] = (float)Math.cos((double)var11) * var12;
            el[var10] = var16 + (0.1F + 1.5F * var1.nextFloat()) * var2;
            em[var10] = (float)Math.sin((double)var11) * var12;
            en[var10] = 0.0F;
            eo[var10] = (0.4F + 0.7F * var1.nextFloat()) * var2;
            ep[var10] = 0.0F;
            fb[var10] = Float.NaN;
            fc[var10] = 0.0F;
            var9++;
         }

         cp[var0] = var18;
      } catch (RuntimeException var13) {
         throw var13;
      }
   }

   private static void l(int var0) {

      assert var0 >= 0
         && var0 < 9
         && cn[var0] == 1
         && ea.length == (223111219 ^ 223112595)
         && eb.length == (342588325 ^ 342588933)
         && ec.length == (-1511874635 ^ -1511876075)
         && ed.length == (1770677035 ^ 1770677899)
         && ee.length == (1606369920 ^ 1606371104)
         && ef.length == (-955214246 ^ -955214854)
         && eg.length == (953545059 ^ 953545923)
         && eh.length == (-353273263 ^ -353271823)
         && ei.length == (-564436925 ^ -564435485)
         && ej.length == (670636699 ^ 670637883)
         && ek.length == (1160559525 ^ 1160560133)
         && el.length == (318719670 ^ 318718742)
         && em.length == (1129339481 ^ 1129340921)
         && en.length == (736299256 ^ 736300376)
         && eo.length == (-1687147932 ^ -1687146556)
         && ep.length == (-2018294382 ^ -2018295758)
         && fb.length == (-44199196 ^ -44198076)
         && fc.length == (19940349 ^ 19940957)
         && di.length == 9
         && cm.length == 9;

      try {
         Random var1 = gk;
         float var2 = cz[var0];
         float var3 = cx[var0];
         float var4 = ag < 0.0F ? 0.0F : (ag > 2.0F ? 2.0F : ag);
         di[var0] = var1.nextFloat() * (float) (Math.PI * 2);
         float var5 = cm[var0] ? (float)(cv[var0] - ct[var0]) : Float.NaN;
         int var6 = var0 * (-737030925 ^ -737031085);
         int var7 = cp[var0];
         int var8 = (int)(20.0F * var4 + 0.5F);

         for (int var9 = 0; var9 < var8 && var7 < (1185914454 ^ 1185914614); var7++) {
            int var10 = var6 + var7;
            float var11 = var1.nextFloat() * (float) (Math.PI * 2);
            float var12 = (float)Math.cos((double)var11);
            float var13 = (float)Math.sin((double)var11);
            float var14 = (3.5F + 3.0F * var1.nextFloat()) * var2;
            ea[var10] = 0;
            eb[var10] = 0.02F;
            ec[var10] = 1.0F + 0.5F * var1.nextFloat();
            ed[var10] = (0.12F + 0.08F * var1.nextFloat()) * var2;
            ee[var10] = var1.nextFloat() * 6.0F;
            ef[var10] = (6.0F + 8.0F * var1.nextFloat()) * (var1.nextBoolean() ? 1.0F : -1.0F);
            eg[var10] = 1.2F;
            eh[var10] = -16.0F;
            ei[var10] = var1.nextFloat();
            ej[var10] = 1.0F;
            ek[var10] = var12 * 0.2F;
            el[var10] = (0.2F + var1.nextFloat()) * var3 / 1.8F;
            em[var10] = var13 * 0.2F;
            en[var10] = var12 * var14;
            eo[var10] = (2.5F + 3.0F * var1.nextFloat()) * var2;
            ep[var10] = var13 * var14;
            fb[var10] = var5;
            fc[var10] = 0.35F;
            var9++;
         }

         var8 = (int)(24.0F * var4 + 0.5F);

         for (int var17 = 0; var17 < var8 && var7 < (1276389409 ^ 1276389505); var7++) {
            int var18 = var6 + var7;
            float var19 = var1.nextFloat() * (float) (Math.PI * 2);
            float var20 = -0.1F + var1.nextFloat();
            float var21 = (float)Math.sqrt((double)(1.0F - var20 * var20));
            float var22 = (7.0F + 5.0F * var1.nextFloat()) * var2;
            ea[var18] = 2;
            eb[var18] = 0.0F;
            ec[var18] = 0.35F + 0.35F * var1.nextFloat();
            ed[var18] = (0.07F + 0.04F * var1.nextFloat()) * var2;
            ee[var18] = var1.nextFloat() * 6.0F;
            ef[var18] = var1.nextFloat() * 8.0F - 4.0F;
            eg[var18] = 3.5F;
            eh[var18] = -9.0F;
            ei[var18] = var1.nextFloat();
            ej[var18] = 1.0F;
            ek[var18] = 0.0F;
            el[var18] = 0.55F * var3;
            em[var18] = 0.0F;
            en[var18] = (float)Math.cos((double)var19) * var21 * var22;
            eo[var18] = var20 * var22;
            ep[var18] = (float)Math.sin((double)var19) * var21 * var22;
            fb[var18] = var5;
            fc[var18] = 0.3F;
            var17++;
         }

         cp[var0] = var7;
      } catch (RuntimeException var15) {
         throw var15;
      }
   }

   private static void m(int var0) {

      assert var0 >= 0
         && var0 < 9
         && cn[var0] == 2
         && dn.length == (322269459 ^ 322269271)
         && dw.length == (827142260 ^ 827143580)
         && dy.length == 6
         && ea.length == (900362763 ^ 900364203)
         && eb.length == (-77581768 ^ -77580392)
         && ec.length == (1941103286 ^ 1941104406)
         && ed.length == (-1762408901 ^ -1762409573)
         && ee.length == (-667345093 ^ -667346277)
         && ef.length == (-177592170 ^ -177590986)
         && eg.length == (1904142739 ^ 1904143411)
         && eh.length == (1404472240 ^ 1404472848)
         && ei.length == (-1828852721 ^ -1828853329)
         && ej.length == (-371868616 ^ -371869288)
         && ek.length == (-564898060 ^ -564898988)
         && el.length == (1335548112 ^ 1335549296)
         && em.length == (-911757831 ^ -911759271)
         && en.length == (-747784950 ^ -747786070)
         && eo.length == (-1691800818 ^ -1691799890)
         && ep.length == (764424892 ^ 764426012)
         && ey.length == (1388011540 ^ 1388012980)
         && ez.length == (-1096214800 ^ -1096215728)
         && fa.length == (379927147 ^ 379928523);

      try {
         Random var1 = gk;
         float var2 = cz[var0];
         float var3 = cx[var0];
         float var4 = ag < 0.0F ? 0.0F : (ag > 2.0F ? 2.0F : ag);
         float var5 = (float)Math.sqrt((double)Math.max(0.0F, (dd[var0] + 3.1999998F - 1.0F) / 20.0F * 1.6F));
         float var6 = (float) (Math.PI / 2) * (var5 > 1.0F ? 1.0F : var5);
         float var7 = (float)Math.cos((double)var6);
         float var8 = (float)Math.sin((double)var6);
         float var9 = db[var0];
         float var10 = dc[var0];
         float var11 = -var10;
         float var12 = var9;
         float var13 = cm[var0] ? (float)(cv[var0] - ct[var0]) + 0.03F : Float.NaN;
         int var14 = var0 * 36;
         int var15 = cq[var0];
         float var16 = 0.0F;

         for (int var17 = 0; var17 < var15; var17++) {
            int var18 = var14 + var17 * 6;
            float var19 = dn[var18 + 3] - dn[var18];
            float var20 = dn[var18 + 4] - dn[var18 + 1];
            float var21 = dn[var18 + 5] - dn[var18 + 2];
            dy[var17] = 2.0F * (var20 * var21 + var19 * var21 + var19 * var20);
            var16 += dy[var17];
         }

         int var65 = (int)(40.0F * var4 + 0.5F);
         int var66 = (int)(36.0F * var4 + 0.5F);
         int var67 = var65 + var66 + 14;
         int var68 = var0 * (2044622965 ^ 2044623061);
         int var69 = cp[var0];
         int var22 = var0 * (269509696 ^ 269509864);

         for (int var23 = 0; var23 < var67; var23++) {
            int var24 = var23 < var65 ? 0 : (var23 < var65 + var66 ? 1 : 2);
            if (var24 >= 2 || var69 < (-43591006 ^ -43591166)) {
               int var25 = 0;
               if (var24 == 0) {
                  for (float var26 = var1.nextFloat() * var16; var25 < var15 - 1 && var26 > dy[var25]; var25++) {
                     var26 -= dy[var25];
                  }
               } else {
                  var25 = var1.nextInt(var15);
               }

               int var73 = var14 + var25 * 6;
               float var27 = dn[var73];
               float var28 = dn[var73 + 1];
               float var29 = dn[var73 + 2];
               float var30 = dn[var73 + 3];
               float var31 = dn[var73 + 4];
               float var32 = dn[var73 + 5];
               float var33 = var30 - var27;
               float var34 = var31 - var28;
               float var35 = var32 - var29;
               float var36 = var34 * var35;
               float var37 = var33 * var35;
               float var38 = var33 * var34;
               float var39 = var1.nextFloat() * 2.0F * (var36 + var37 + var38);
               float var40 = var27 + var1.nextFloat() * var33;
               float var41 = var28 + var1.nextFloat() * var34;
               float var42 = var29 + var1.nextFloat() * var35;
               float var43 = 0.0F;
               float var44 = 0.0F;
               float var45 = 0.0F;
               if (var39 < 2.0F * var36) {
                  boolean var46 = var39 < var36;
                  var40 = var46 ? var30 : var27;
                  var43 = var46 ? 1.0F : -1.0F;
               } else if (var39 < 2.0F * (var36 + var37)) {
                  boolean var78 = var39 - 2.0F * var36 < var37;
                  var41 = var78 ? var31 : var28;
                  var44 = var78 ? 1.0F : -1.0F;
               } else {
                  boolean var79 = var39 - 2.0F * (var36 + var37) < var38;
                  var42 = var79 ? var32 : var29;
                  var45 = var79 ? 1.0F : -1.0F;
               }

               if (var24 == 2) {
                  int var80 = var22 + (var23 - var65 - var66) * 12;
                  dw[var80] = var40;
                  dw[var80 + 1] = var41;
                  dw[var80 + 2] = var42;

                  for (byte var47 = 3; var47 < 12; var47 += 3) {
                     dw[var80 + var47] = dw[var80 + var47 - 3] + (var1.nextFloat() * 0.18F - 0.09F) * var2;
                     dw[var80 + var47 + 1] = dw[var80 + var47 - 2] + (var1.nextFloat() * 0.24F - 0.12F) * var2;
                     dw[var80 + var47 + 2] = dw[var80 + var47 - 1] + (var1.nextFloat() * 0.18F - 0.09F) * var2;
                  }
               } else {
                  float var81 = var40 * var7 - var41 * var8;
                  float var82 = var40 * var8 + var41 * var7;
                  float var48 = var81 * var9 + var42 * var11;
                  float var49 = var81 * var10 + var42 * var12;
                  float var50 = var43 * var7 - var44 * var8;
                  float var51 = var43 * var8 + var44 * var7;
                  float var52 = var50 * var9 + var45 * var11;
                  float var53 = var50 * var10 + var45 * var12;
                  float var54 = (float)Math.sqrt((double)(var48 * var48 + var49 * var49));
                  var54 = var54 < 0.05F ? 0.05F : var54;
                  float var55 = var48 / var54;
                  float var56 = var49 / var54;
                  int var57 = var68 + var69;
                  var69++;
                  ek[var57] = var48;
                  el[var57] = var82;
                  em[var57] = var49;
                  ej[var57] = 1.0F;
                  if (var24 == 0) {
                     float var58 = (1.2F + 2.0F * var1.nextFloat()) * var2;
                     float var59 = cl[var0] ? (var25 <= 1 ? 1.2F : 1.0F) : 1.1F;
                     ea[var57] = 1;
                     eb[var57] = 0.16F;
                     ec[var57] = 1.3F + 0.6F * var1.nextFloat();
                     ed[var57] = (0.24F + 0.2F * var1.nextFloat()) * var2 * var59;
                     ee[var57] = var1.nextFloat() * 13.0F;
                     ef[var57] = 5.0F + 8.0F * var1.nextFloat();
                     eg[var57] = 0.8F;
                     eh[var57] = -12.0F;
                     ei[var57] = var1.nextFloat();
                     en[var57] = var52 * var58 + var55 * 1.5F * var2 + (var1.nextFloat() - 0.5F) * var2;
                     eo[var57] = var51 * var58 * 0.6F + (1.0F + 1.8F * var1.nextFloat()) * var2;
                     ep[var57] = var53 * var58 + var56 * 1.5F * var2 + (var1.nextFloat() - 0.5F) * var2;
                     fb[var57] = var13;
                     fc[var57] = 0.3F;
                     float var60 = var1.nextFloat() * 2.0F - 1.0F;
                     float var61 = var1.nextFloat() * 2.0F - 1.0F;
                     float var62 = var1.nextFloat() * 2.0F - 1.0F;
                     float var63 = (float)Math.sqrt((double)(var60 * var60 + var61 * var61 + var62 * var62));
                     if (var63 < 0.001F) {
                        var60 = 0.0F;
                        var61 = 1.0F;
                        var62 = 0.0F;
                        var63 = 1.0F;
                     }

                     ey[var57] = var60 / var63;
                     ez[var57] = var61 / var63;
                     fa[var57] = var62 / var63;
                  } else {
                     boolean var84 = (var23 - var65) % 3 == 0;
                     float var85 = (0.4F + var1.nextFloat()) * var2;
                     ea[var57] = var84 ? 2 : 3;
                     eb[var57] = 0.16F;
                     ec[var57] = 1.0F + 0.8F * var1.nextFloat();
                     ed[var57] = var84 ? (0.08F + 0.04F * var1.nextFloat()) * var2 : (0.022F + 0.013F * var1.nextFloat()) * var2;
                     ee[var57] = var1.nextFloat() * 6.0F;
                     ef[var57] = var1.nextFloat() * 6.0F - 3.0F;
                     eg[var57] = 1.5F;
                     eh[var57] = -2.5F;
                     ei[var57] = var1.nextFloat() * 0.5F;
                     en[var57] = var55 * var85;
                     eo[var57] = (0.3F + 0.9F * var1.nextFloat()) * var2;
                     ep[var57] = var56 * var85;
                     fb[var57] = Float.NaN;
                     fc[var57] = 0.0F;
                  }
               }
            }
         }

         int var70 = (int)(5.0F * var4 + 0.5F);

         for (int var71 = 0; var71 < var70 && var69 < (612905005 ^ 612905101); var69++) {
            int var72 = var68 + var69;
            float var74 = (var1.nextFloat() * 0.6F - 0.3F) * var2;
            float var75 = (0.5F + 0.9F * var1.nextFloat()) * var3 / 1.8F;
            float var76 = (var1.nextFloat() * 0.6F - 0.3F) * var2;
            float var77 = var74 * var7 - var75 * var8;
            ea[var72] = 4;
            eb[var72] = 0.12F;
            ec[var72] = 0.9F + 0.3F * var1.nextFloat();
            ed[var72] = (0.4F + 0.15F * var1.nextFloat()) * var2;
            ee[var72] = var1.nextFloat() * 6.0F;
            ef[var72] = var1.nextFloat() * 0.8F - 0.4F;
            eg[var72] = 0.8F;
            eh[var72] = 1.0E-4F;
            ei[var72] = 0.0F;
            ej[var72] = 0.5F;
            ek[var72] = var77 * var9 + var76 * var11;
            el[var72] = var74 * var8 + var75 * var7;
            em[var72] = var77 * var10 + var76 * var12;
            en[var72] = var1.nextFloat() * 0.4F - 0.2F;
            eo[var72] = 0.15F + 0.2F * var1.nextFloat();
            ep[var72] = var1.nextFloat() * 0.4F - 0.2F;
            fb[var72] = Float.NaN;
            fc[var72] = 0.0F;
            var71++;
         }

         cp[var0] = var69;
      } catch (RuntimeException var64) {
         throw var64;
      }
   }

   private static void n(int var0) {

      assert var0 >= 0
         && var0 < 9
         && cn[var0] == 3
         && _kwren_do.length == (1066772833 ^ 1066776430)
         && dp.length == 27
         && dq.length == 27
         && he.length == 3
         && ea.length == (2004329075 ^ 2004330451)
         && eb.length == (-469544642 ^ -469543778)
         && ec.length == (-481567278 ^ -481568654)
         && ed.length == (1804652898 ^ 1804653762)
         && ee.length == (-494994875 ^ -494993435)
         && ef.length == (1254307545 ^ 1254306681)
         && eg.length == (-1219553352 ^ -1219554792)
         && eh.length == (-2026437304 ^ -2026438424)
         && ei.length == (551144683 ^ 551143755)
         && ej.length == (-1178761194 ^ -1178759754)
         && ek.length == (-325459805 ^ -325458685)
         && el.length == (1329045253 ^ 1329044133)
         && em.length == (-185093649 ^ -185093041)
         && en.length == (1311735163 ^ 1311733979)
         && eo.length == (-1978400194 ^ -1978398818)
         && ep.length == (-297851263 ^ -297852127)
         && fb.length == (1744061789 ^ 1744060669)
         && fc.length == (-742850560 ^ -742849120);

      try {
         Random var1 = gk;
         float var2 = cz[var0];
         float var3 = cx[var0];
         float var4 = ag < 0.0F ? 0.0F : (ag > 2.0F ? 2.0F : ag);
         float var5 = (float)(cv[var0] - ct[var0]);
         float var6 = (var1.nextBoolean() ? 1.0F : -1.0F) * 2.2F * var2;
         float var7 = RegionPassCache.rX * var6 + (var1.nextFloat() * 1.6F - 0.8F);
         float var8 = RegionPassCache.rZ * var6 + (var1.nextFloat() * 1.6F - 0.8F);
         float var9 = (float)Math.max(3.0, Math.min(14.0 * (double)var2, cw[var0] - ct[var0]));
         long var10 = var1.nextLong();
         int var12 = var0 * (-955056600 ^ -955056769);

         for (int var13 = 0; var13 < 3; var13++) {
            int var14 = var12 + var13 * (-1738851901 ^ -1738852130);
            gm.setSeed(var10 + 7L);
            gn.setSeed(var10 + 99L + (long)var13);

            for (int var15 = 0; var15 < 9; var15++) {
               float[] var16;
               Random var17;
               int var18;
               byte var19;
               double var20;
               double var22;
               double var24;
               double var26;
               double var28;
               double var30;
               double var32;
               if (var15 == 0) {
                  var16 = _kwren_do;
                  var18 = var14;
                  var19 = 33;
                  var20 = 0.3;
                  gl.setSeed(var10);
                  var17 = gl;
                  var22 = (double)var7;
                  var24 = (double)var9;
                  var26 = (double)var8;
                  var28 = 0.0;
                  var30 = 0.98 * (double)var3;
                  var32 = 0.0;
               } else if (var15 < 4) {
                  int var34 = var15 - 1;
                  int var35 = var14 + he[var34] * 3;
                  double var36 = gm.nextDouble() * Math.PI * 2.0;
                  double var38 = (2.5 + 2.0 * gm.nextDouble()) * (double)var2;
                  var22 = (double)_kwren_do[var35];
                  var24 = (double)_kwren_do[var35 + 1];
                  var26 = (double)_kwren_do[var35 + 2];
                  var28 = var22 + Math.cos(var36) * var38 * 0.75;
                  var30 = var24 - var38 * 0.65;
                  var32 = var26 + Math.sin(var36) * var38 * 0.75;
                  dp[var0 * 3 + var34] = (float)(0.55 + 0.25 * gm.nextDouble());
                  var16 = _kwren_do;
                  var18 = var14 + (33 + 9 * var34) * 3;
                  var19 = 9;
                  var20 = 0.35;
                  gl.setSeed(var10 + 31L * (long)var34 + (long)var13);
                  var17 = gl;
               } else {
                  double var101 = (Math.PI * 2) * (double)(var15 - 4) / 5.0 + gn.nextDouble();
                  double var106 = (1.0 + 0.8 * gn.nextDouble()) * (double)var2;
                  var16 = dq;
                  var18 = 0;
                  var19 = 9;
                  var20 = 0.25;
                  var17 = gn;
                  var22 = 0.0;
                  var24 = (double)var5 + 0.05;
                  var26 = 0.0;
                  var28 = Math.cos(var101) * var106;
                  var30 = var24;
                  var32 = Math.sin(var101) * var106;
               }

               int var102 = var19 - 1;
               var16[var18] = (float)var22;
               var16[var18 + 1] = (float)var24;
               var16[var18 + 2] = (float)var26;
               var16[var18 + var102 * 3] = (float)var28;
               var16[var18 + var102 * 3 + 1] = (float)var30;
               var16[var18 + var102 * 3 + 2] = (float)var32;

               for (int var103 = var102; var103 > 1; var103 >>= 1) {
                  for (int var107 = 0; var107 + var103 <= var102; var107 += var103) {
                     int var37 = var18 + var107 * 3;
                     int var109 = var18 + (var107 + var103) * 3;
                     int var39 = var18 + (var107 + var103 / 2) * 3;
                     double var40 = (double)var16[var37];
                     double var42 = (double)var16[var37 + 1];
                     double var44 = (double)var16[var37 + 2];
                     double var46 = (double)var16[var109];
                     double var48 = (double)var16[var109 + 1];
                     double var50 = (double)var16[var109 + 2];
                     double var52 = var46 - var40;
                     double var54 = var48 - var42;
                     double var56 = var50 - var44;
                     double var58 = Math.sqrt(var52 * var52 + var54 * var54 + var56 * var56);
                     double var60 = -var56;
                     double var62 = var52;
                     double var64 = Math.sqrt(var60 * var60 + var52 * var52);
                     if (var64 < 1.0E-6) {
                        var60 = 1.0;
                        var62 = 0.0;
                        var64 = 1.0;
                     }

                     var60 /= var64;
                     var62 /= var64;
                     double var66 = var54 * var62;
                     double var68 = var56 * var60 - var52 * var62;
                     double var70 = -var54 * var60;
                     double var72 = Math.sqrt(var66 * var66 + var68 * var68 + var70 * var70);
                     if (var72 > 1.0E-9) {
                        var66 /= var72;
                        var68 /= var72;
                        var70 /= var72;
                     }

                     double var74 = var17.nextDouble() * Math.PI * 2.0;
                     double var76 = (var17.nextDouble() * 2.0 - 1.0) * var20 * var58;
                     double var78 = Math.cos(var74);
                     double var80 = Math.sin(var74);
                     var16[var39] = (float)((var40 + var46) * 0.5 + (var60 * var78 + var66 * var80) * var76);
                     var16[var39 + 1] = (float)((var42 + var48) * 0.5 + var68 * var80 * var76);
                     var16[var39 + 2] = (float)((var44 + var50) * 0.5 + (var62 * var78 + var70 * var80) * var76);
                  }
               }

               if (var15 == 0) {
                  go.setSeed(var10 ^ (long)var13 * -7046029254386353131L);

                  for (int var105 = 1; var105 < 32; var105++) {
                     if ((var105 & 3) != 0) {
                        _kwren_do[var14 + var105 * 3] = _kwren_do[var14 + var105 * 3] + (go.nextFloat() - 0.5F) * 0.22F * var2;
                        _kwren_do[var14 + var105 * 3 + 2] = _kwren_do[var14 + var105 * 3 + 2] + (go.nextFloat() - 0.5F) * 0.22F * var2;
                     }
                  }
               } else if (var15 >= 4) {
                  int var104 = var14 + (60 + 7 * (var15 - 4)) * 3;

                  for (int var108 = 0; var108 < 7; var108++) {
                     _kwren_do[var104 + var108 * 3] = dq[var108 * 3];
                     _kwren_do[var104 + var108 * 3 + 1] = var5 + 0.05F;
                     _kwren_do[var104 + var108 * 3 + 2] = dq[var108 * 3 + 2];
                  }
               }
            }
         }

         float var83 = cm[var0] ? var5 + 0.02F : Float.NaN;
         int var84 = var0 * (-1215311446 ^ -1215311606);
         int var85 = cp[var0];
         int var86 = (int)(14.0F * var4 + 0.5F);
         int var87 = var86 + (int)(12.0F * var4 + 0.5F);

         for (int var90 = 0; var90 < var87 && var85 < (330086058 ^ 330085898); var85++) {
            int var93 = var84 + var85;
            boolean var96 = var90 < var86;
            float var21 = var1.nextFloat() * (float) (Math.PI * 2);
            float var99 = var96 ? -0.2F + var1.nextFloat() : 0.3F + 0.6F * var1.nextFloat();
            float var23 = (float)Math.sqrt((double)(1.0F - var99 * var99));
            float var100 = (5.0F + 5.0F * var1.nextFloat()) * var2;
            ea[var93] = 6;
            eb[var93] = 0.08F;
            ec[var93] = 0.45F + 0.45F * var1.nextFloat();
            ed[var93] = (0.07F + 0.03F * var1.nextFloat()) * var2;
            ee[var93] = 0.0F;
            ef[var93] = 0.0F;
            eg[var93] = 1.0F;
            eh[var93] = -18.0F;
            ei[var93] = var1.nextFloat();
            ej[var93] = 1.0F;
            ek[var93] = 0.0F;
            el[var93] = var96 ? var3 : var5 + 0.05F;
            em[var93] = 0.0F;
            en[var93] = (float)Math.cos((double)var21) * var23 * var100;
            eo[var93] = var99 * var100;
            ep[var93] = (float)Math.sin((double)var21) * var23 * var100;
            fb[var93] = var83;
            fc[var93] = 0.3F;
            var90++;
         }

         var87 = (int)(5.0F * var4 + 0.5F);

         for (int var91 = 0; var91 < var87 && var85 < (1723159887 ^ 1723160047); var85++) {
            int var94 = var84 + var85;
            ea[var94] = 4;
            eb[var94] = 0.25F + 0.08F * (float)var91;
            ec[var94] = 1.2F + 0.3F * var1.nextFloat();
            ed[var94] = (0.4F + 0.15F * var1.nextFloat()) * var2;
            ee[var94] = var1.nextFloat() * 6.0F;
            ef[var94] = var1.nextFloat() - 0.5F;
            eg[var94] = 0.3F;
            eh[var94] = 1.0E-4F;
            ei[var94] = 0.0F;
            ej[var94] = 1.0F;
            ek[var94] = (var1.nextFloat() - 0.5F) * var2;
            el[var94] = var5 + 0.3F;
            em[var94] = (var1.nextFloat() - 0.5F) * var2;
            en[var94] = var1.nextFloat() * 0.2F - 0.1F;
            eo[var94] = 0.4F + 0.3F * var1.nextFloat();
            ep[var94] = var1.nextFloat() * 0.2F - 0.1F;
            fb[var94] = Float.NaN;
            fc[var94] = 0.0F;
            var91++;
         }

         var87 = (int)(10.0F * var4 + 0.5F);

         for (int var92 = 0; var92 < var87 && var85 < (-2068918971 ^ -2068918811); var85++) {
            int var95 = var84 + var85;
            float var97 = var1.nextFloat() * (float) (Math.PI * 2);
            float var98 = (float)Math.sqrt((double)var1.nextFloat()) * 0.85F * var2;
            ea[var95] = 3;
            eb[var95] = 0.1F;
            ec[var95] = 1.0F + 0.5F * var1.nextFloat();
            ed[var95] = (0.03F + 0.02F * var1.nextFloat()) * var2;
            ee[var95] = 0.0F;
            ef[var95] = 0.0F;
            eg[var95] = 1.0F;
            eh[var95] = 1.0E-4F;
            ei[var95] = var1.nextFloat() * 0.5F;
            ej[var95] = 1.0F;
            ek[var95] = (float)Math.cos((double)var97) * var98;
            el[var95] = var5 + 0.03F;
            em[var95] = (float)Math.sin((double)var97) * var98;
            en[var95] = 0.0F;
            eo[var95] = 0.02F;
            ep[var95] = 0.0F;
            fb[var95] = Float.NaN;
            fc[var95] = 0.0F;
            var92++;
         }

         cp[var0] = var85;
      } catch (RuntimeException var82) {
         throw var82;
      }
   }

   private static void o(int var0) {

      assert var0 >= 0
         && var0 < 9
         && cn[var0] == 4
         && dt.length == (-1601342795 ^ -1601342479)
         && du.length == (764920072 ^ 764919992)
         && dv.length == 54
         && ea.length == (-1076573432 ^ -1076572504)
         && eb.length == (-545847071 ^ -545845951)
         && ec.length == (-270609153 ^ -270610081)
         && ed.length == (-1480937251 ^ -1480936067)
         && ee.length == (884038464 ^ 884039392)
         && ef.length == (158639633 ^ 158639025)
         && eg.length == (934924401 ^ 934925777)
         && eh.length == (1636782734 ^ 1636783918)
         && ei.length == (1595108134 ^ 1595108998)
         && ej.length == (181688888 ^ 181690264)
         && ek.length == (-917896998 ^ -917895814)
         && el.length == (1458682652 ^ 1458683580)
         && em.length == (-859588501 ^ -859587125)
         && en.length == (1911380376 ^ 1911381048)
         && eo.length == (1382653129 ^ 1382652265)
         && ep.length == (760225316 ^ 760224644)
         && fb.length == (689685827 ^ 689684707)
         && fc.length == (1222257087 ^ 1222257695);

      try {
         Random var1 = gk;
         float var2 = cz[var0];
         float var3 = cx[var0];
         float var4 = ag < 0.0F ? 0.0F : (ag > 2.0F ? 2.0F : ag);
         int var5 = var0 * 36;

         for (int var6 = 0; var6 < 18; var5 += 2) {
            dt[var5] = (float) (Math.PI * 2) * (float)var6 / 18.0F + (var1.nextFloat() * 0.24F - 0.12F);
            dt[var5 + 1] = (1.6F + 2.2F * var1.nextFloat()) * var2;
            var6++;
         }

         var5 = var0 * 48;

         for (int var22 = 0; var22 < 16; var5 += 3) {
            float var7 = var1.nextFloat() * 2.0F - 1.0F;
            float var8 = var1.nextFloat() * (float) (Math.PI * 2);
            float var9 = (float)Math.sqrt((double)(1.0F - var7 * var7));
            du[var5] = var9 * (float)Math.cos((double)var8);
            du[var5 + 1] = var7;
            du[var5 + 2] = var9 * (float)Math.sin((double)var8);
            var22++;
         }

         float var23 = var1.nextFloat() * (float) (Math.PI * 2);
         float var24 = (float)Math.cos((float) (Math.PI / 10));
         float var25 = (float)Math.sin((float) (Math.PI / 10));
         var5 = var0 * 6;
         dv[var5] = (float)Math.cos((double)var23);
         dv[var5 + 1] = 0.0F;
         dv[var5 + 2] = (float)Math.sin((double)var23);
         dv[var5 + 3] = -((float)Math.sin((double)var23)) * var24;
         dv[var5 + 4] = var25;
         dv[var5 + 5] = (float)Math.cos((double)var23) * var24;
         int var26 = var0 * (-957560245 ^ -957560085);
         int var10 = cp[var0];
         int var11 = (int)(28.0F * var4 + 0.5F);

         for (int var12 = 0; var12 < var11 && var10 < (1722131525 ^ 1722131685); var10++) {
            int var13 = var26 + var10;
            boolean var14 = (var12 & 1) == 0;
            float var15 = -0.7F + 1.7F * var1.nextFloat();
            float var16 = var1.nextFloat() * (float) (Math.PI * 2);
            float var17 = (float)Math.sqrt((double)Math.max(0.0F, 1.0F - var15 * var15));
            float var18 = (4.0F + 4.0F * var1.nextFloat()) * var2;
            ea[var13] = var14 ? 2 : 3;
            eb[var13] = 0.14F;
            ec[var13] = 1.2F + 0.8F * var1.nextFloat();
            ed[var13] = var14 ? (0.08F + 0.04F * var1.nextFloat()) * var2 : (0.035F + 0.02F * var1.nextFloat()) * var2;
            ee[var13] = var1.nextFloat() * 6.0F;
            ef[var13] = var1.nextFloat() * 6.0F - 3.0F;
            eg[var13] = 2.5F;
            eh[var13] = -1.0E-4F;
            ei[var13] = var1.nextFloat();
            ej[var13] = 1.0F;
            ek[var13] = 0.0F;
            el[var13] = 0.55F * var3;
            em[var13] = 0.0F;
            en[var13] = var17 * (float)Math.cos((double)var16) * var18;
            eo[var13] = var15 * var18;
            ep[var13] = var17 * (float)Math.sin((double)var16) * var18;
            fb[var13] = Float.NaN;
            fc[var13] = 0.0F;
            var12++;
         }

         var11 = (int)(10.0F * var4 + 0.5F);

         for (int var28 = 0; var28 < var11 && var10 < (1935242412 ^ 1935242252); var10++) {
            int var29 = var26 + var10;
            float var30 = -0.5F + 1.2F * var1.nextFloat();
            float var31 = var1.nextFloat() * (float) (Math.PI * 2);
            float var32 = (float)Math.sqrt((double)(1.0F - var30 * var30));
            float var33 = (0.6F + 0.8F * var1.nextFloat()) * var2;
            ea[var29] = 5;
            eb[var29] = 0.16F;
            ec[var29] = 1.6F + 0.4F * var1.nextFloat();
            ed[var29] = (0.5F + 0.3F * var1.nextFloat()) * var2;
            ee[var29] = var1.nextFloat() * 6.0F;
            ef[var29] = var1.nextFloat() * 0.8F - 0.4F;
            eg[var29] = 1.2F;
            eh[var29] = -1.0E-4F;
            ei[var29] = (var28 & 1) == 0 ? 0.2F : 0.8F;
            ej[var29] = 1.0F;
            ek[var29] = 0.0F;
            el[var29] = 0.55F * var3;
            em[var29] = 0.0F;
            en[var29] = var32 * (float)Math.cos((double)var31) * var33;
            eo[var29] = var30 * var33;
            ep[var29] = var32 * (float)Math.sin((double)var31) * var33;
            fb[var29] = Float.NaN;
            fc[var29] = 0.0F;
            var28++;
         }

         cp[var0] = var10;
      } catch (RuntimeException var19) {
         throw var19;
      }
   }

   private static void p(int var0) {

      assert var0 >= 0
         && var0 < 9
         && cn[var0] == 5
         && dx.length == (1934996984 ^ 1934997216)
         && dv.length == 54
         && ea.length == (1087108237 ^ 1087107373)
         && eb.length == (893031603 ^ 893030675)
         && ec.length == (42856047 ^ 42855375)
         && ed.length == (-1482966106 ^ -1482965498)
         && ee.length == (-669036410 ^ -669035226)
         && ef.length == (-1066655606 ^ -1066654422)
         && eg.length == (-1213325275 ^ -1213323899)
         && eh.length == (-1936181018 ^ -1936179898)
         && ei.length == (-710288877 ^ -710287437)
         && ej.length == (56440614 ^ 56439430)
         && ek.length == (-1061037636 ^ -1061037028)
         && el.length == (78650451 ^ 78649843)
         && em.length == (786301859 ^ 786302467)
         && en.length == (-1415540495 ^ -1415539375)
         && eo.length == (-1650171717 ^ -1650170597)
         && ep.length == (-1306472426 ^ -1306470986)
         && fb.length == (-1290101356 ^ -1290102732)
         && fc.length == (-1259041284 ^ -1259042724)
         && cm.length == 9;

      try {
         Random var1 = gk;
         float var2 = cz[var0];
         float var3 = cx[var0];
         float var4 = ag < 0.0F ? 0.0F : (ag > 2.0F ? 2.0F : ag);
         int var5 = var0 * 88;

         for (int var6 = 0; var6 < 22; var5 += 4) {
            dx[var5] = (1.2F + 1.2F * var1.nextFloat()) * var2;
            dx[var5 + 1] = var1.nextFloat() * (float) (Math.PI * 2);
            dx[var5 + 2] = (var1.nextFloat() * 1.2F - 0.6F) * var2;
            dx[var5 + 3] = 0.2F * var1.nextFloat();
            var6++;
         }

         float var21 = var1.nextFloat() * (float) (Math.PI * 2);
         float var7 = (float)Math.cos(0.38397244F);
         float var8 = (float)Math.sin(0.38397244F);
         var5 = var0 * 6;
         dv[var5] = (float)Math.cos((double)var21);
         dv[var5 + 1] = 0.0F;
         dv[var5 + 2] = (float)Math.sin((double)var21);
         dv[var5 + 3] = -((float)Math.sin((double)var21)) * var7;
         dv[var5 + 4] = var8;
         dv[var5 + 5] = (float)Math.cos((double)var21) * var7;
         float var9 = cm[var0] ? (float)(cv[var0] - ct[var0]) + 0.02F : Float.NaN;
         int var10 = var0 * (-611854014 ^ -611853854);
         int var11 = cp[var0];
         int var12 = (int)(24.0F * var4 + 0.5F);

         for (int var13 = 0; var13 < var12 && var11 < (-1482934051 ^ -1482934147); var11++) {
            int var14 = var10 + var11;
            float var15 = -0.4F + 1.3F * var1.nextFloat();
            float var16 = var1.nextFloat() * (float) (Math.PI * 2);
            float var17 = (float)Math.sqrt((double)(1.0F - var15 * var15));
            float var18 = (5.0F + 4.0F * var1.nextFloat()) * var2;
            ea[var14] = 6;
            eb[var14] = 0.55F;
            ec[var14] = 0.5F + 0.4F * var1.nextFloat();
            ed[var14] = (0.07F + 0.03F * var1.nextFloat()) * var2;
            ee[var14] = 0.0F;
            ef[var14] = 0.0F;
            eg[var14] = 2.8F;
            eh[var14] = -4.0F;
            ei[var14] = var1.nextFloat();
            ej[var14] = 1.0F;
            ek[var14] = 0.0F;
            el[var14] = 0.55F * var3;
            em[var14] = 0.0F;
            en[var14] = var17 * (float)Math.cos((double)var16) * var18;
            eo[var14] = var15 * var18;
            ep[var14] = var17 * (float)Math.sin((double)var16) * var18;
            fb[var14] = var9;
            fc[var14] = 0.3F;
            var13++;
         }

         cp[var0] = var11;
      } catch (RuntimeException var19) {
         throw var19;
      }
   }

   private static void q(int var0) {

      assert var0 >= 0
         && var0 < 9
         && cn[var0] == 0
         && dr.length == (1569936566 ^ 1569936958)
         && ds.length == (960422002 ^ 960422450)
         && fx.length == 21
         && fy.length == 21
         && fg.length == (-391444170 ^ -391442122)
         && fh.length == (-2002768717 ^ -2002770509)
         && fi.length == (-1473025776 ^ -1473024240)
         && fr.length == 33
         && RegionPassCache.SA.length == (-1503195286 ^ -1503162518)
         && RegionPassCache.ST.length == (-373879555 ^ -373871363)
         && RegionPassCache.SB.length == (408551602 ^ 408555698)
         && RegionPassCache.LA.length == (-1341706760 ^ -1341764104)
         && bm[0] > 2.6F;

      try {
         float[] var1 = RegionPassCache.SA;
         float[] var2 = RegionPassCache.ST;
         float[] var3 = RegionPassCache.SB;
         float[] var4 = RegionPassCache.LA;
         float var5 = cr[var0];
         float var6 = cz[var0];
         float var7 = cx[var0];
         float var8 = dg[var0];
         float var9 = dh[var0];
         float var10 = var8 * de[var0];
         float var11 = (float)(cs[var0] - RegionPassCache.z);
         float var12 = (float)(ct[var0] - RegionPassCache.aa);
         float var13 = (float)(cu[var0] - RegionPassCache.ab);
         float var14 = (float)(cv[var0] - RegionPassCache.aa);
         float var15 = var12 + 0.55F * var7;
         float var16 = RegionPassCache.rX;
         float var17 = RegionPassCache.rZ;
         int var18 = ft;
         int var19 = fu;
         int var20 = fx[17];
         int var21 = fx[9];
         float var27 = (float)Math.sqrt((double)(var11 * var11 + var15 * var15 + var13 * var13));
         float var28 = var27 > 0.3F ? 1.0F - 0.3F / var27 : 0.0F;
         float var29 = var11 * var28;
         float var30 = var15 * var28;
         float var31 = var13 * var28;
         float var24 = var5 / 0.08F;
         var24 = var24 > 1.0F ? 1.0F : var24;
         float var25 = var24 * var24 * (3.0F - 2.0F * var24);
         var24 = (var5 - 0.16F) / 0.44F;
         var24 = var24 < 0.0F ? 0.0F : (var24 > 1.0F ? 1.0F : var24);
         float var26 = 0.95F * var25 * (1.0F - var24 * var24 * (3.0F - 2.0F * var24)) * var9 * var10;
         int var22 = RegionPassCache.nSB;
         if (var22 < (2008013885 ^ 2008014397) && var26 > 0.002F) {
            int var23 = var22 * 8;
            var3[var23] = var29;
            var3[var23 + 1] = var30;
            var3[var23 + 2] = var31;
            var3[var23 + 3] = 1.05F * var6;
            var3[var23 + 4] = 1.4F * var6;
            var3[var23 + 5] = 0.0F;
            var3[var23 + 6] = 4.0F;
            var3[var23 + 7] = Float.intBitsToFloat(Math.min(373407930 ^ 373407813, (int)(var26 * 255.0F + 0.5F)) << 24 | var20);
            RegionPassCache.nSB = var22 + 1;
         }

         var24 = var5 / 0.05F;
         var24 = var24 > 1.0F ? 1.0F : var24;
         var25 = var24 * var24 * (3.0F - 2.0F * var24);
         var24 = (var5 - 0.1F) / 0.25F;
         var24 = var24 < 0.0F ? 0.0F : (var24 > 1.0F ? 1.0F : var24);
         var26 = var25 * (1.0F - var24 * var24 * (3.0F - 2.0F * var24)) * var9 * var10;
         var22 = RegionPassCache.nSB;
         if (var22 < (250136181 ^ 250135669) && var26 > 0.002F) {
            int var61 = var22 * 8;
            var3[var61] = var29;
            var3[var61 + 1] = var30;
            var3[var61 + 2] = var31;
            var3[var61 + 3] = 0.26F * var6;
            var3[var61 + 4] = 0.26F * var6;
            var3[var61 + 5] = 0.0F;
            var3[var61 + 6] = 3.0F;
            var3[var61 + 7] = Float.intBitsToFloat(Math.min(1301633720 ^ 1301633607, (int)(var26 * 255.0F + 0.5F)) << 24 | -1308258136 ^ -1292210345);
            RegionPassCache.nSB = var22 + 1;
         }

         double var32 = cv[var0];
         float var34 = (float)(Math.max(var32 + 3.0, Math.min(var32 + 12.0 * (double)var6, cw[var0])) - var32);
         var24 = (var5 - 0.05F) / 0.5F;
         float var35 = var24 <= 0.0F ? 0.0F : (var24 >= 1.0F ? 1.0F : 1.0F - (float)Math.exp((double)(-6.931472F * var24)));
         var24 = (var5 - 0.05F) / 0.35F;
         var24 = var24 < 0.0F ? 0.0F : (var24 > 1.0F ? 1.0F : var24);
         var25 = 1.0F - var24;
         float var36 = 1.15F * var6 * (1.0F - var25 * var25 * var25);
         var24 = (var5 - 1.9F) / 0.7F;
         var24 = var24 < 0.0F ? 0.0F : (var24 > 1.0F ? 1.0F : var24);
         var36 *= 1.0F - var24 * var24 * (3.0F - 2.0F * var24);
         float var37 = 0.92F + 0.08F * (float)Math.sin((double)((float) (Math.PI * 6) * var5));
         float var38 = Math.min(12.0F * var6 * var35, var34);
         if (fl < 96 && var36 > 0.004F && var38 > 0.05F) {
            int var62 = fl * 16;
            fi[var62] = 2.0F;
            fi[var62 + 1] = var11;
            fi[var62 + 2] = var14 + 0.02F;
            fi[var62 + 3] = var13;
            fi[var62 + 4] = var14 + var38;
            fi[var62 + 10] = var36;
            fi[var62 + 12] = var37 * var9 * var8;
            fi[var62 + 13] = (float)var18;
            fl++;
         }

         var26 = 0.8F * var37 * var9 * var10;
         var22 = RegionPassCache.nSB;
         if (var22 < (-1908616310 ^ -1908616822) && var26 > 0.002F && var36 > 0.001F) {
            int var63 = var22 * 8;
            var3[var63] = var11;
            var3[var63 + 1] = var14 + 0.15F * var6;
            var3[var63 + 2] = var13;
            var3[var63 + 3] = 1.2F * var36;
            var3[var63 + 4] = 0.45F * var36;
            var3[var63 + 5] = 0.0F;
            var3[var63 + 6] = 4.0F;
            var3[var63 + 7] = Float.intBitsToFloat(Math.min(-1429835155 ^ -1429835118, (int)(var26 * 255.0F + 0.5F)) << 24 | fx[10]);
            RegionPassCache.nSB = var22 + 1;
         }

         var24 = (var5 - 1.9F) / 0.5F;
         var24 = var24 < 0.0F ? 0.0F : (var24 > 1.0F ? 1.0F : var24);
         float var39 = (1.0F - var24 * var24 * (3.0F - 2.0F * var24)) * var8;
         if (var39 > 0.002F) {
            int var40 = var0 * 64;

            for (int var41 = 0; var41 < 16; var40 += 4) {
               float var42 = var5 - ds[var40];
               if (!(var42 <= 0.0F)) {
                  float var43 = 0.3F * var6 + ds[var40 + 1] * var42;
                  float var44 = var43 - 0.9F * var6;
                  if (!(var44 > var38)) {
                     var24 = (var43 - 0.6F * var34) / (0.4F * var34);
                     var24 = var24 < 0.0F ? 0.0F : (var24 > 1.0F ? 1.0F : var24);
                     var26 = Math.min(1.0F, var42 / 0.08F) * (1.0F - var24 * var24 * (3.0F - 2.0F * var24)) * var39;
                     float var45 = var44 > 0.0F ? var44 : 0.0F;
                     float var46 = var43 < var38 ? var43 : var38;
                     var22 = RegionPassCache.nLA;
                     if (var46 > var45 + 0.001F && var22 < (-1452298956 ^ -1452307148) && var26 > 0.002F) {
                        int var64 = var22 * 11;
                        float var47 = var11 + ds[var40 + 2];
                        float var48 = var13 + ds[var40 + 3];
                        var4[var64] = var47;
                        var4[var64 + 1] = var14 + var45;
                        var4[var64 + 2] = var48;
                        var4[var64 + 3] = var47;
                        var4[var64 + 4] = var14 + var46;
                        var4[var64 + 5] = var48;
                        var4[var64 + 6] = 0.02F * var6;
                        var4[var64 + 7] = 0.07F * var6;
                        var4[var64 + 8] = Float.intBitsToFloat(var21);
                        var4[var64 + 9] = Float.intBitsToFloat(Math.min(-580854002 ^ -580853775, (int)(0.9F * var26 * 255.0F + 0.5F)) << 24 | var20);
                        var4[var64 + 10] = 1.0F;
                        RegionPassCache.nLA = var22 + 1;
                     }
                  }
               }

               var41++;
            }
         }

         float var132 = (var5 - 0.1F) / 2.3F;
         if (var132 > 0.0F && var132 < 1.0F) {
            var24 = var132 / 0.11F;
            var24 = var24 > 1.0F ? 1.0F : var24;
            float var133 = var24 * var24 * (3.0F - 2.0F * var24);
            var24 = (var132 - 0.55F) / 0.45F;
            var24 = var24 < 0.0F ? 0.0F : var24;
            var133 *= 1.0F - var24 * var24 * (3.0F - 2.0F * var24);

            for (int var136 = 3; var136 >= 0; var136--) {
               float var139 = var132 - 0.035F * (float)var136;
               var139 = var139 < 0.0F ? 0.0F : var139;
               float var144 = var15 - 0.1F * var6 + 4.0F * var6 * (float)Math.pow((double)var139, 1.7);
               float var147 = 0.1F * var6 * (float)Math.sin((double)((float) (Math.PI * 7.0 / 5.0) * (var5 - 0.08F * (float)var136) + 0.3F));
               float var150 = var11 + var16 * var147;
               float var153 = var13 + var17 * var147;
               float var156 = 1.0F + 0.2F * var139;
               float var49 = 1.0F + 0.18F * Math.min(1.0F, 1.7F * (float)Math.pow(var139 > 0.001F ? (double)var139 : 0.001F, 0.7));
               float var50 = 0.5F * var6 * var156;
               float var51 = var6 * var156 * var49;
               if (var136 == 0) {
                  var26 = 0.55F * var133 * var9 * var8;
                  var22 = RegionPassCache.nST;
                  if (var22 < (384710968 ^ 384711992) && var26 > 0.002F) {
                     int var65 = var22 * 8;
                     var2[var65] = var150;
                     var2[var65 + 1] = var144;
                     var2[var65 + 2] = var153;
                     var2[var65 + 3] = var50;
                     var2[var65 + 4] = var51;
                     var2[var65 + 5] = 0.0F;
                     var2[var65 + 6] = 26.0F;
                     var2[var65 + 7] = Float.intBitsToFloat(Math.min(-1303364199 ^ -1303364250, (int)(var26 * 255.0F + 0.5F)) << 24 | var18);
                     RegionPassCache.nST = var22 + 1;
                  }

                  var26 = 0.45F * var133 * var9 * var10;
                  var22 = RegionPassCache.nSB;
                  if (var22 < (687472640 ^ 687473152) && var26 > 0.002F) {
                     int var66 = var22 * 8;
                     var3[var66] = var150;
                     var3[var66 + 1] = var144 + 0.25F * var6;
                     var3[var66 + 2] = var153;
                     var3[var66 + 3] = 1.3F * var6;
                     var3[var66 + 4] = 1.5F * var6;
                     var3[var66 + 5] = 0.0F;
                     var3[var66 + 6] = 4.0F;
                     var3[var66 + 7] = Float.intBitsToFloat(Math.min(1253147104 ^ 1253146911, (int)(var26 * 255.0F + 0.5F)) << 24 | var18);
                     RegionPassCache.nSB = var22 + 1;
                  }

                  if (fl < 96) {
                     int var67 = fl * 16;
                     fi[var67] = 0.0F;
                     fi[var67 + 1] = var150;
                     fi[var67 + 2] = var144 + 0.8F * var51;
                     fi[var67 + 3] = var153;
                     fi[var67 + 10] = 0.34F * var6 * var156;
                     fi[var67 + 11] = 0.55F;
                     fi[var67 + 12] = 0.95F * var133 * var9 * var8;
                     fi[var67 + 13] = (float)fx[11];
                     fi[var67 + 14] = 0.0F;
                     fi[var67 + 15] = 0.0F;
                     fl++;
                  }
               }

               var26 = 0.85F * var133 * (var136 == 0 ? 1.0F : (var136 == 1 ? 0.28F : (var136 == 2 ? 0.16F : 0.08F))) * var9 * var8;
               var22 = RegionPassCache.nSA;
               if (var22 < (-1080284050 ^ -1080279954) && var26 > 0.002F) {
                  int var68 = var22 * 8;
                  var1[var68] = var150;
                  var1[var68 + 1] = var144;
                  var1[var68 + 2] = var153;
                  var1[var68 + 3] = var50;
                  var1[var68 + 4] = var51;
                  var1[var68 + 5] = 0.0F;
                  var1[var68 + 6] = 26.0F;
                  var1[var68 + 7] = Float.intBitsToFloat(Math.min(-956321426 ^ -956321391, (int)(var26 * 255.0F + 0.5F)) << 24 | fx[6]);
                  RegionPassCache.nSA = var22 + 1;
               }
            }
         }

         int var135 = var0 * 72;

         for (int var137 = 0; var137 < 12; var135 += 6) {
            float var141 = var5 - dr[var135];
            float var145 = dr[var135 + 5];
            if (!(var141 <= 0.0F) && !(var141 >= var145)) {
               var24 = (var141 - 0.6F * var145) / (0.4F * var145);
               var24 = var24 < 0.0F ? 0.0F : (var24 > 1.0F ? 1.0F : var24);
               var26 = Math.min(1.0F, var141 / 0.15F) * (1.0F - var24 * var24 * (3.0F - 2.0F * var24)) * var8;
               if (!(var26 < 0.002F) && fj + 9 <= (267840603 ^ 267838555) && fk < (-1707036314 ^ -1707036570)) {
                  int var148 = (var137 & 1) == 0 ? var18 : var19;
                  int var151 = fj;
                  int var154 = var151 * 3;

                  for (int var157 = 0; var157 <= 8; var157++) {
                     float var160 = var141 - 0.05F * (float)var157;
                     var160 = var160 < 0.0F ? 0.0F : var160;
                     var24 = var160 / 1.4F;
                     var24 = var24 > 1.0F ? 1.0F : var24;
                     float var163 = dr[var135 + 1] * (1.0F - 0.55F * var24 * var24 * (3.0F - 2.0F * var24));
                     float var165 = dr[var135 + 4] + dr[var135 + 2] * var160;
                     fg[var154] = var11 + var163 * (float)Math.cos((double)var165);
                     fg[var154 + 1] = var14 + 0.15F * var6 + dr[var135 + 3] * (float)Math.pow((double)var160, 1.25);
                     fg[var154 + 2] = var13 + var163 * (float)Math.sin((double)var165);
                     var154 += 3;
                  }

                  fj = var151 + 9;
                  int var69 = fk * 9;
                  fh[var69] = (float)var151;
                  fh[var69 + 1] = 9.0F;
                  fh[var69 + 2] = 0.15F * var6;
                  fh[var69 + 3] = 0.0F;
                  fh[var69 + 4] = 0.9F * var26;
                  fh[var69 + 5] = 0.0F;
                  fh[var69 + 6] = (float)var148;
                  fh[var69 + 7] = 2.0F;
                  fh[var69 + 8] = 1.0F;
                  fk++;
                  float var158 = fg[var151 * 3];
                  float var162 = fg[var151 * 3 + 1];
                  float var164 = fg[var151 * 3 + 2];
                  var22 = RegionPassCache.nSA;
                  if (var22 + 1 < (481625092 ^ 481629188)) {
                     var69 = var22 * 8;
                     var1[var69] = var158;
                     var1[var69 + 1] = var162;
                     var1[var69 + 2] = var164;
                     var1[var69 + 3] = 0.3F * var6;
                     var1[var69 + 4] = 0.3F * var6;
                     var1[var69 + 5] = 0.0F;
                     var1[var69 + 6] = 4.0F;
                     var1[var69 + 7] = Float.intBitsToFloat(Math.min(205382235 ^ 205382308, (int)(0.55F * var26 * 255.0F + 0.5F)) << 24 | var148);
                     var1[var69 + 8] = var158;
                     var1[var69 + 9] = var162;
                     var1[var69 + 10] = var164;
                     var1[var69 + 11] = 0.055F * var6;
                     var1[var69 + 12] = 0.055F * var6;
                     var1[var69 + 13] = 0.0F;
                     var1[var69 + 14] = 3.0F;
                     var1[var69 + 15] = Float.intBitsToFloat(
                        Math.min(-1037934087 ^ -1037934330, (int)(var26 * 255.0F + 0.5F)) << 24 | ((var137 & 1) == 0 ? fx[14] : fy[14])
                     );
                     RegionPassCache.nSA = var22 + 2;
                  }
               }
            }

            var137++;
         }

         var24 = (var5 - 0.1F) / 0.2F;
         var24 = var24 < 0.0F ? 0.0F : (var24 > 1.0F ? 1.0F : var24);
         var25 = var24 * var24 * (3.0F - 2.0F * var24);
         var24 = (var5 - 1.2F) / 0.8F;
         var24 = var24 < 0.0F ? 0.0F : (var24 > 1.0F ? 1.0F : var24);
         float var138 = 0.95F * var25 * (1.0F - var24 * var24 * (3.0F - 2.0F * var24)) * var8;
         if (var138 > 0.002F) {
            var24 = var5 / 1.5F;
            var24 = var24 > 1.0F ? 1.0F : var24;
            float var142 = var14 + 0.14F * var6 + 0.35F * var6 * var24 * var24 * (3.0F - 2.0F * var24);
            float var146 = 1.15F * var6;
            float var149 = 0.25F * var5;
            int var152 = Math.min(-1239505554 ^ -1239505519, (int)(var138 * 255.0F + 0.5F)) << 24 | var21;

            for (int var155 = 0; var155 < 8; var155++) {
               var22 = RegionPassCache.nSA;
               if (var22 >= (-535543857 ^ -535547953)) {
                  break;
               }

               float var159 = (float) (Math.PI / 4) * (float)var155 + var149;
               int var71 = var22 * 8;
               var1[var71] = var11 + var146 * (float)Math.cos((double)var159);
               var1[var71 + 1] = var142;
               var1[var71 + 2] = var13 + var146 * (float)Math.sin((double)var159);
               var1[var71 + 3] = 0.15F * var6;
               var1[var71 + 4] = 0.15F * var6;
               var1[var71 + 5] = 0.0F;
               var1[var71 + 6] = (float)(9 + var155);
               var1[var71 + 7] = Float.intBitsToFloat(var152);
               RegionPassCache.nSA = var22 + 1;
            }
         }

         var24 = var5 / 0.12F;
         var24 = var24 > 1.0F ? 1.0F : var24;
         var25 = var24 * var24 * (3.0F - 2.0F * var24);
         var24 = (var5 - 1.4F) / 1.2F;
         var24 = var24 < 0.0F ? 0.0F : (var24 > 1.0F ? 1.0F : var24);
         var26 = 0.45F * var25 * (1.0F - var24 * var24 * (3.0F - 2.0F * var24)) * var8;
         if (fl < 96 && var26 > 0.002F) {
            int var72 = fl * 16;
            fi[var72] = 3.0F;
            fi[var72 + 1] = var11;
            fi[var72 + 2] = var14 + 0.015F;
            fi[var72 + 3] = var13;
            fi[var72 + 10] = 2.2F * var6;
            fi[var72 + 11] = 4.0F;
            fi[var72 + 12] = var26;
            fi[var72 + 13] = (float)var18;
            fi[var72 + 15] = 1.0F;
            fl++;
         }

         var24 = var5 / 0.06F;
         var24 = var24 > 1.0F ? 1.0F : var24;
         var25 = var24 * var24 * (3.0F - 2.0F * var24);
         var24 = (var5 - 0.9F) / 0.8F;
         var24 = var24 < 0.0F ? 0.0F : (var24 > 1.0F ? 1.0F : var24);
         var26 = 0.95F * var25 * (1.0F - var24 * var24 * (3.0F - 2.0F * var24)) * var8;
         var24 = var5 / 0.9F;
         var24 = var24 > 1.0F ? 1.0F : var24;
         var25 = 1.0F - var24;
         if (fl < 96 && var26 > 0.002F) {
            int var73 = fl * 16;
            fi[var73] = 0.0F;
            fi[var73 + 1] = var11;
            fi[var73 + 2] = var14 + 0.016F;
            fi[var73 + 3] = var13;
            fi[var73 + 10] = 1.35F * var6 * (1.0F - var25 * var25 * var25);
            fi[var73 + 11] = 0.55F;
            fi[var73 + 12] = var26;
            fi[var73 + 13] = (float)fx[7];
            fi[var73 + 14] = 0.6F * var5 + 1.0F;
            fi[var73 + 15] = 0.6F;
            fl++;
         }

         float var143 = (var5 - 0.35F) / 1.2F;
         if (var143 > 0.0F && var143 < 1.0F && fl < 96) {
            var25 = 1.0F - var143;
            int var74 = fl * 16;
            fi[var74] = 3.0F;
            fi[var74 + 1] = var11;
            fi[var74 + 2] = var14 + 0.017F;
            fi[var74 + 3] = var13;
            fi[var74 + 10] = 2.1F * var6 * (1.0F - var25 * var25 * var25) / 0.9F;
            fi[var74 + 11] = 18.0F;
            fi[var74 + 12] = 0.6F * var25 * (float)Math.sqrt((double)var25) * Math.min(1.0F, var143 / 0.06F) * var8;
            fi[var74 + 13] = (float)fy[4];
            fi[var74 + 15] = 1.0F;
            fl++;
         }
      } catch (RuntimeException var52) {
         throw var52;
      }
   }

   private static void r(int var0) {

      assert var0 >= 0
         && var0 < 9
         && cn[var0] == 1
         && gy.length == 3
         && gz.length == 3
         && ha.length == 3
         && hb.length == 14
         && hc.length == 14
         && hd.length == 14
         && fx.length == 21
         && fy.length == 21
         && fi.length == (771692825 ^ 771694361)
         && RegionPassCache.SA.length == (-199492424 ^ -199525192)
         && RegionPassCache.ST.length == (-1451497020 ^ -1451505212)
         && RegionPassCache.SB.length == (-429441501 ^ -429445597)
         && RegionPassCache.LB.length == (-221152893 ^ -221155453)
         && bm[1] > 1.5F;

      try {
         float[] var1 = RegionPassCache.SA;
         float[] var2 = RegionPassCache.ST;
         float[] var3 = RegionPassCache.SB;
         float[] var4 = RegionPassCache.LB;
         float var5 = cr[var0];
         float var6 = cz[var0];
         float var7 = cx[var0];
         float var8 = dg[var0];
         float var9 = dh[var0];
         float var10 = var8 * de[var0];
         float var11 = (float)(cs[var0] - RegionPassCache.z);
         float var12 = (float)(ct[var0] - RegionPassCache.aa);
         float var13 = (float)(cu[var0] - RegionPassCache.ab);
         float var14 = (float)(cv[var0] - RegionPassCache.aa);
         float var15 = var12 + 0.55F * var7;
         float var16 = RegionPassCache.rX;
         float var17 = RegionPassCache.rY;
         float var18 = RegionPassCache.rZ;
         int var19 = ft;
         int var20 = fx[17];
         float var26 = (float)Math.sqrt((double)(var11 * var11 + var15 * var15 + var13 * var13));
         float var27 = var26 > 0.4F ? 1.0F - 0.4F / var26 : 0.0F;
         float var28 = var11 * var27;
         float var29 = var15 * var27;
         float var30 = var13 * var27;
         float var23 = var5 / 0.03F;
         var23 = var23 > 1.0F ? 1.0F : var23;
         float var25 = (float)Math.exp((double)(-Math.max(0.0F, var5 - 0.05F) / 0.1F)) * var23 * var23 * (3.0F - 2.0F * var23) * var9 * var10;
         var23 = var5 / 0.09F;
         var23 = var23 > 1.0F ? 1.0F : var23;
         float var24 = 1.0F - var23;
         float var31 = 1.9F * var6 * (1.0F - var24 * var24 * var24);
         int var21 = RegionPassCache.nSB;
         if (var21 + 1 < (1036580677 ^ 1036580165)) {
            int var22 = var21 * 8;
            var3[var22] = var28;
            var3[var22 + 1] = var29;
            var3[var22 + 2] = var30;
            var3[var22 + 3] = var31;
            var3[var22 + 4] = var31;
            var3[var22 + 5] = 0.0F;
            var3[var22 + 6] = 4.0F;
            var3[var22 + 7] = Float.intBitsToFloat(Math.min(1561520942 ^ 1561521105, (int)(var25 * 255.0F + 0.5F)) << 24 | var20);
            var25 = (float)Math.exp((double)(-var5 / 0.07F)) * var9 * var10;
            var3[var22 + 8] = var28;
            var3[var22 + 9] = var29;
            var3[var22 + 10] = var30;
            var3[var22 + 11] = 0.42F * var6;
            var3[var22 + 12] = 0.42F * var6;
            var3[var22 + 13] = 0.0F;
            var3[var22 + 14] = 3.0F;
            var3[var22 + 15] = Float.intBitsToFloat(Math.min(-254173337 ^ -254173288, (int)(var25 * 255.0F + 0.5F)) << 24 | 1476963065 ^ 1492604166);
            RegionPassCache.nSB = var21 + 2;
         }

         var23 = var5 / 0.12F;
         float var32 = 3.4F * var6 * (var23 >= 1.0F ? 1.0F : 1.0F - (float)Math.exp((double)(-6.931472F * var23)));
         var25 = 0.9F * (float)Math.exp((double)(-var5 / 0.14F)) * var9 * var10;
         var21 = RegionPassCache.nLB;
         if (var21 + 1 < (-1329032451 ^ -1329032963) && var25 > 0.002F && var32 > 0.001F) {
            int var33 = fx[14];
            float var34 = Float.intBitsToFloat(Math.min(-1911429835 ^ -1911429686, (int)(var25 * 255.0F + 0.5F)) << 24 | var33);
            float var35 = Float.intBitsToFloat(var33);
            int var46 = var21 * 11;
            var4[var46] = var28 - var16 * var32;
            var4[var46 + 1] = var29 - var17 * var32;
            var4[var46 + 2] = var30 - var18 * var32;
            var4[var46 + 3] = var28;
            var4[var46 + 4] = var29;
            var4[var46 + 5] = var30;
            var4[var46 + 6] = 0.0F;
            var4[var46 + 7] = 0.15F * var6;
            var4[var46 + 8] = var35;
            var4[var46 + 9] = var34;
            var4[var46 + 10] = 2.0F;
            var4[var46 + 11] = var28;
            var4[var46 + 12] = var29;
            var4[var46 + 13] = var30;
            var4[var46 + 14] = var28 + var16 * var32;
            var4[var46 + 15] = var29 + var17 * var32;
            var4[var46 + 16] = var30 + var18 * var32;
            var4[var46 + 17] = 0.15F * var6;
            var4[var46 + 18] = 0.0F;
            var4[var46 + 19] = var34;
            var4[var46 + 20] = var35;
            var4[var46 + 21] = 2.0F;
            RegionPassCache.nLB = var21 + 2;
         }

         for (int var93 = 0; var93 < 3; var93++) {
            float var95 = (var5 - gy[var93]) / ha[var93];
            if (!(var95 <= 0.0F) && !(var95 >= 1.0F) && fl < 96) {
               var24 = 1.0F - var95;
               int var47 = fl * 16;
               fi[var47] = 0.0F;
               fi[var47 + 1] = var11;
               fi[var47 + 2] = var14 + 0.015F + 0.001F * (float)var93;
               fi[var47 + 3] = var13;
               fi[var47 + 10] = gz[var93] * var6 * (1.0F - var24 * var24 * var24 * var24);
               fi[var47 + 11] = 0.55F;
               fi[var47 + 12] = (float)Math.pow((double)var24, 1.2) * Math.min(1.0F, var95 / 0.05F) * var8;
               fi[var47 + 13] = var93 == 0 ? (float)fx[10] : (float)(var93 == 1 ? var19 : fy[4]);
               fi[var47 + 14] = di[var0] + (float) (Math.PI * 8.0 / 5.0) * var95 + (float)var93;
               fi[var47 + 15] = 0.55F;
               fl++;
            }
         }

         float var94 = (var5 - 0.03F) / 0.8F;
         if (var94 > 0.0F && var94 < 1.0F && fl < 96) {
            var24 = 1.0F - var94;
            int var48 = fl * 16;
            fi[var48] = 3.0F;
            fi[var48 + 1] = var11;
            fi[var48 + 2] = var14 + 0.018F;
            fi[var48 + 3] = var13;
            fi[var48 + 10] = 3.0F * var6 * (1.0F - var24 * var24 * var24 * var24) / 0.9F;
            fi[var48 + 11] = 18.0F;
            fi[var48 + 12] = 0.7F * var24 * (float)Math.sqrt((double)var24) * var8;
            fi[var48 + 13] = (float)var19;
            fi[var48 + 15] = 1.0F;
            fl++;
         }

         var23 = var5 / 0.06F;
         var23 = var23 > 1.0F ? 1.0F : var23;
         var24 = var23 * var23 * (3.0F - 2.0F * var23);
         var23 = (var5 - 0.9F) / 0.6F;
         var23 = var23 < 0.0F ? 0.0F : (var23 > 1.0F ? 1.0F : var23);
         var25 = 0.4F * var24 * (1.0F - var23 * var23 * (3.0F - 2.0F * var23)) * var8;
         if (fl < 96 && var25 > 0.002F) {
            int var49 = fl * 16;
            fi[var49] = 3.0F;
            fi[var49 + 1] = var11;
            fi[var49 + 2] = var14 + 0.012F;
            fi[var49 + 3] = var13;
            fi[var49 + 10] = 1.3F * var6;
            fi[var49 + 11] = 24.0F;
            fi[var49 + 12] = var25;
            fi[var49 + 13] = 723208.0F;
            fi[var49 + 15] = 0.0F;
            fl++;
         }

         if (var5 < 0.4F) {
            float var96 = var5 / 0.35F;
            var24 = var96 < 1.0F ? 1.0F - var96 : 0.0F;
            float var98 = 2.4F * var6 * (1.0F - var24 * var24 * var24) / 0.86F;
            var23 = (var5 - 0.05F) / 0.35F;
            var23 = var23 < 0.0F ? 0.0F : (var23 > 1.0F ? 1.0F : var23);
            float var36 = (1.0F - var23 * var23 * (3.0F - 2.0F * var23)) * var9 * var8;
            var21 = RegionPassCache.nST;
            var25 = 0.25F * var36;
            if (var21 < (-950633711 ^ -950632687) && var25 > 0.002F) {
               int var50 = var21 * 8;
               var2[var50] = var11;
               var2[var50 + 1] = var15;
               var2[var50 + 2] = var13;
               var2[var50 + 3] = var98;
               var2[var50 + 4] = var98;
               var2[var50 + 5] = 0.0F;
               var2[var50 + 6] = 25.0F;
               var2[var50 + 7] = Float.intBitsToFloat(Math.min(432765943 ^ 432765704, (int)(var25 * 255.0F + 0.5F)) << 24 | var19);
               RegionPassCache.nST = var21 + 1;
            }

            var21 = RegionPassCache.nSA;
            var25 = 0.85F * var36;
            if (var21 < (1165594706 ^ 1165590610) && var25 > 0.002F) {
               int var51 = var21 * 8;
               var1[var51] = var11;
               var1[var51 + 1] = var15;
               var1[var51 + 2] = var13;
               var1[var51 + 3] = var98;
               var1[var51 + 4] = var98;
               var1[var51 + 5] = 0.0F;
               var1[var51 + 6] = 25.0F;
               var1[var51 + 7] = Float.intBitsToFloat(Math.min(-898726103 ^ -898725930, (int)(var25 * 255.0F + 0.5F)) << 24 | fx[8]);
               RegionPassCache.nSA = var21 + 1;
            }
         }

         var23 = (var5 - 0.12F) / 0.38F;
         var23 = var23 < 0.0F ? 0.0F : (var23 > 1.0F ? 1.0F : var23);
         float var97 = 1.0F - var23 * var23 * (3.0F - 2.0F * var23);
         if (var97 > 0.0F && fl < 96) {
            double var99 = cv[var0];
            float var37 = (float)(Math.max(var99 + 3.0, Math.min(var99 + 9.0 * (double)var6, cw[var0])) - var99);
            var23 = var5 / 0.16F;
            float var38 = Math.min(9.0F * var6 * (var23 >= 1.0F ? 1.0F : 1.0F - (float)Math.exp((double)(-6.931472F * var23))), var37);
            if (var38 > 0.05F) {
               int var52 = fl * 16;
               fi[var52] = 2.0F;
               fi[var52 + 1] = var11;
               fi[var52 + 2] = var14 + 0.02F;
               fi[var52 + 3] = var13;
               fi[var52 + 4] = var14 + var38;
               fi[var52 + 10] = 0.55F * var6 * var97;
               fi[var52 + 12] = var9 * var8;
               fi[var52 + 13] = (float)var19;
               fl++;
            }
         }

         var23 = (var5 - 0.2F) / 0.9F;
         var23 = var23 < 0.0F ? 0.0F : (var23 > 1.0F ? 1.0F : var23);
         var25 = 0.26F * (1.0F - var23 * var23 * (3.0F - 2.0F * var23)) * Math.min(1.0F, var5 / 0.06F) * var8;
         if (var25 > 0.002F) {
            var23 = var5 / 0.7F;
            var23 = var23 > 1.0F ? 1.0F : var23;
            var24 = 1.0F - var23;
            float var100 = 3.06F * var6 * (1.0F - var24 * var24 * var24 * var24);
            var23 = var5 > 1.0F ? 1.0F : var5;
            var24 = 1.0F - var23;
            float var101 = (0.35F + 0.45F * (1.0F - var24 * var24 * var24)) * var6;
            var23 = var5 / 0.6F;
            var23 = var23 > 1.0F ? 1.0F : var23;
            float var102 = var14 + 0.15F * var6 + 0.3F * var6 * var23 * var23 * (3.0F - 2.0F * var23);
            int var103 = Math.min(1192928517 ^ 1192928762, (int)(var25 * 255.0F + 0.5F)) << 24 | fw;

            for (int var39 = 0; var39 < 14; var39++) {
               var21 = RegionPassCache.nST;
               if (var21 >= (-1723771864 ^ -1723772888)) {
                  break;
               }

               float var40 = var100 * hd[var39];
               int var53 = var21 * 8;
               var2[var53] = var11 + hb[var39] * var40;
               var2[var53 + 1] = var102;
               var2[var53 + 2] = var13 + hc[var39] * var40;
               var2[var53 + 3] = var101;
               var2[var53 + 4] = var101;
               var2[var53 + 5] = 1.7F * (float)var39 + 0.4F * var5;
               var2[var53 + 6] = 22.0F;
               var2[var53 + 7] = Float.intBitsToFloat(var103);
               RegionPassCache.nST = var21 + 1;
            }
         }

         var23 = var5 / 0.03F;
         var23 = var23 > 1.0F ? 1.0F : var23;
         var25 = 0.55F * (float)Math.exp((double)(-var5 / 0.35F)) * var23 * var23 * (3.0F - 2.0F * var23) * var8;
         if (fl < 96 && var25 > 0.002F) {
            var23 = var5 / 0.3F;
            var23 = var23 > 1.0F ? 1.0F : var23;
            var24 = 1.0F - var23;
            int var54 = fl * 16;
            fi[var54] = 3.0F;
            fi[var54 + 1] = var11;
            fi[var54 + 2] = var14 + 0.014F;
            fi[var54 + 3] = var13;
            fi[var54 + 10] = 2.0F * var6 * (0.6F + 0.4F * (1.0F - var24 * var24 * var24));
            fi[var54 + 11] = 4.0F;
            fi[var54 + 12] = var25;
            fi[var54 + 13] = (float)var19;
            fi[var54 + 15] = 1.0F;
            fl++;
         }
      } catch (RuntimeException var41) {
         throw var41;
      }
   }

   private static void s(int var0) {

      assert var0 >= 0
         && var0 < 9
         && cn[var0] == 2
         && dn.length == (-149375751 ^ -149375555)
         && dw.length == (-1642145376 ^ -1642144696)
         && dz.length == 24
         && gq.length == 24
         && gr.length == 18
         && gs.length == 24
         && fx.length == 21
         && fi.length == (1262733008 ^ 1262731472)
         && RegionPassCache.QT.length == (1008740974 ^ 1008843374)
         && RegionPassCache.LA.length == (1030830049 ^ 1030772705)
         && RegionPassCache.SB.length == (1955137773 ^ 1955141869);

      try {
         float[] var1 = RegionPassCache.QT;
         float[] var2 = RegionPassCache.LA;
         float[] var3 = RegionPassCache.SB;
         float var4 = cr[var0];
         float var5 = cz[var0];
         float var6 = cx[var0];
         float var7 = dg[var0];
         float var8 = dh[var0];
         float var9 = var7 * de[var0];
         float var10 = (float)(cs[var0] - RegionPassCache.z);
         float var11 = (float)(ct[var0] - RegionPassCache.aa);
         float var12 = (float)(cu[var0] - RegionPassCache.ab);
         float var13 = (float)(cv[var0] - RegionPassCache.aa);
         float var14 = db[var0];
         float var15 = dc[var0];
         float var16 = -var15;
         float var17 = var14;
         int var18 = ft;
         int var19 = fx[17];
         float var24 = (float)Math.sqrt((double)Math.max(0.0F, (dd[var0] + 20.0F * var4 - 1.0F) / 20.0F * 1.6F));
         float var25 = (float) (Math.PI / 2) * (var24 > 1.0F ? 1.0F : var24);
         float var26 = (float)Math.cos((double)var25);
         float var27 = (float)Math.sin((double)var25);
         float var22 = var4 / 0.05F;
         var22 = var22 > 1.0F ? 1.0F : var22;
         float var28 = var22 * var22 * (3.0F - 2.0F * var22);
         var22 = (var4 - 0.16F) / 0.06F;
         var22 = var22 < 0.0F ? 0.0F : (var22 > 1.0F ? 1.0F : var22);
         var28 *= (1.0F - var22 * var22 * (3.0F - 2.0F * var22)) * var7;
         if (var28 > 0.002F) {
            int var29 = fx[12];
            int var30 = fx[15];
            int var31 = var29 >> 16 & (-1917090023 ^ -1917089818);
            int var32 = var29 >> 8 & (-840803781 ^ -840803644);
            int var33 = var29 & (-1760972528 ^ -1760972305);
            var22 = (var4 - 0.02F) / 0.14F;
            var22 = var22 < 0.0F ? 0.0F : (var22 > 1.0F ? 1.0F : var22);
            float var34 = 0.35F + 0.65F * var22 * var22 * (3.0F - 2.0F * var22);
            float var35 = Float.intBitsToFloat(Math.min(-1578053286 ^ -1578053211, (int)(0.95F * var28 * 255.0F + 0.5F)) << 24 | var30);
            int var36 = var0 * 36;
            int var37 = cq[var0];

            for (int var38 = 0; var38 < var37; var36 += 6) {
               for (int var39 = 0; var39 < 8; var39++) {
                  float var40 = (var39 & 1) == 0 ? dn[var36] : dn[var36 + 3];
                  float var41 = (var39 & 2) == 0 ? dn[var36 + 1] : dn[var36 + 4];
                  float var42 = (var39 & 4) == 0 ? dn[var36 + 2] : dn[var36 + 5];
                  float var43 = var40 * var26 - var41 * var27;
                  dz[var39 * 3] = var10 + var43 * var14 + var42 * var16;
                  dz[var39 * 3 + 1] = var11 + var40 * var27 + var41 * var26;
                  dz[var39 * 3 + 2] = var12 + var43 * var15 + var42 * var17;
               }

               for (int var94 = 0; var94 < 6; var94++) {
                  int var20 = RegionPassCache.nQT;
                  if (var20 >= (-1097379739 ^ -1097383835)) {
                     break;
                  }

                  float var98 = gr[var94 * 3];
                  float var102 = gr[var94 * 3 + 1];
                  float var106 = gr[var94 * 3 + 2];
                  float var109 = var98 * var26 - var102 * var27;
                  float var44 = var109 * var14 + var106 * var16;
                  float var45 = var98 * var27 + var102 * var26;
                  float var46 = var109 * var15 + var106 * var17;
                  float var47 = 0.55F + 0.45F * Math.abs(var44 * 0.3208F + var45 * 0.9165F + var46 * -0.2395F);
                  float var48 = 0.8F + 0.25F * var47;
                  int var49 = Math.min(-1444342950 ^ -1444342875, (int)((float)var31 * var48 + 0.5F)) << 16
                     | Math.min(199444147 ^ 199444044, (int)((float)var32 * var48 + 0.5F)) << 8
                     | Math.min(116146379 ^ 116146228, (int)((float)var33 * var48 + 0.5F));
                  float var50 = Float.intBitsToFloat(
                     Math.min(-1962948244 ^ -1962948205, (int)((0.24F + 0.2F * var47) * var28 * var34 * 255.0F + 0.5F)) << 24 | var49
                  );
                  int var21 = var20 * 25;

                  for (int var51 = 0; var51 < 4; var51++) {
                     int var52 = gq[var94 * 4 + var51] * 3;
                     var1[var21 + var51 * 3] = dz[var52];
                     var1[var21 + var51 * 3 + 1] = dz[var52 + 1];
                     var1[var21 + var51 * 3 + 2] = dz[var52 + 2];
                  }

                  var1[var21 + 12] = 0.0F;
                  var1[var21 + 13] = 1.0F;
                  var1[var21 + 14] = 0.0F;
                  var1[var21 + 15] = 0.0F;
                  var1[var21 + 16] = 1.0F;
                  var1[var21 + 17] = 0.0F;
                  var1[var21 + 18] = 1.0F;
                  var1[var21 + 19] = 1.0F;
                  var1[var21 + 20] = 0.0F;
                  var1[var21 + 21] = var50;
                  var1[var21 + 22] = var50;
                  var1[var21 + 23] = var50;
                  var1[var21 + 24] = var50;
                  RegionPassCache.nQT = var20 + 1;
               }

               for (int var95 = 0; var95 < 12; var95++) {
                  int var54 = RegionPassCache.nLA;
                  if (var54 >= (1525999379 ^ 1525991187)) {
                     break;
                  }

                  int var99 = gs[var95 * 2] * 3;
                  int var103 = gs[var95 * 2 + 1] * 3;
                  int var58 = var54 * 11;
                  var2[var58] = dz[var99];
                  var2[var58 + 1] = dz[var99 + 1];
                  var2[var58 + 2] = dz[var99 + 2];
                  var2[var58 + 3] = dz[var103];
                  var2[var58 + 4] = dz[var103 + 1];
                  var2[var58 + 5] = dz[var103 + 2];
                  var2[var58 + 6] = 0.04F * var5;
                  var2[var58 + 7] = 0.04F * var5;
                  var2[var58 + 8] = var35;
                  var2[var58 + 9] = var35;
                  var2[var58 + 10] = 1.0F;
                  RegionPassCache.nLA = var54 + 1;
               }

               var38++;
            }

            var22 = (var4 - 0.05F) / 0.11F;
            var22 = var22 < 0.0F ? 0.0F : (var22 > 1.0F ? 1.0F : var22);
            float var93 = var22 * var22 * (3.0F - 2.0F * var22) * var28;
            if (var93 > 0.002F) {
               float var96 = Float.intBitsToFloat(Math.min(-593303666 ^ -593303695, (int)(var93 * 255.0F + 0.5F)) << 24 | 1438272166 ^ 1430631769);
               float var100 = Float.intBitsToFloat(Math.min(322353831 ^ 322353752, (int)(0.7F * var93 * 255.0F + 0.5F)) << 24 | 562069553 ^ 562003918);
               int var104 = var0 * (-11142213 ^ -11142381);

               for (int var107 = 0; var107 < 42; var107++) {
                  int var55 = RegionPassCache.nLA;
                  if (var55 >= (123381536 ^ 123373344)) {
                     break;
                  }

                  int var110 = var104 + var107 / 3 * 12 + var107 % 3 * 3;
                  float var112 = dw[var110];
                  float var114 = dw[var110 + 1];
                  float var116 = dw[var110 + 2];
                  float var118 = dw[var110 + 3];
                  float var119 = dw[var110 + 4];
                  float var121 = dw[var110 + 5];
                  float var123 = var112 * var26 - var114 * var27;
                  float var125 = var118 * var26 - var119 * var27;
                  int var59 = var55 * 11;
                  var2[var59] = var10 + var123 * var14 + var116 * var16;
                  var2[var59 + 1] = var11 + var112 * var27 + var114 * var26;
                  var2[var59 + 2] = var12 + var123 * var15 + var116 * var17;
                  var2[var59 + 3] = var10 + var125 * var14 + var121 * var16;
                  var2[var59 + 4] = var11 + var118 * var27 + var119 * var26;
                  var2[var59 + 5] = var12 + var125 * var15 + var121 * var17;
                  var2[var59 + 6] = 0.05F * var5;
                  var2[var59 + 7] = 0.035F * var5;
                  var2[var59 + 8] = var96;
                  var2[var59 + 9] = var100;
                  var2[var59 + 10] = 1.0F;
                  RegionPassCache.nLA = var55 + 1;
               }
            }

            float var97 = -0.55F * var6 * var27;
            float var101 = 0.55F * var6 * var26;
            float var105 = var10 + var97 * var14;
            float var108 = var11 + var101;
            float var111 = var12 + var97 * var15;
            float var113 = (float)Math.sqrt((double)(var105 * var105 + var108 * var108 + var111 * var111));
            float var115 = var113 > 0.35F ? 1.0F - 0.35F / var113 : 0.0F;
            float var117 = -var27 * var14;
            float var120 = -var27 * var15;
            float var122 = var117 * RegionPassCache.rX + var26 * RegionPassCache.rY + var120 * RegionPassCache.rZ;
            float var124 = var117 * RegionPassCache.uX + var26 * RegionPassCache.uY + var120 * RegionPassCache.uZ;
            float var126 = var122 * var122 + var124 * var124 > 1.0E-6F ? (float)Math.atan2((double)(-var122), (double)var124) : 0.0F;
            var22 = var4 / 0.16F;
            var22 = var22 > 1.0F ? 1.0F : var22;
            float var23 = (0.25F + 0.55F * var22 * var22 * (3.0F - 2.0F * var22)) * var28 * var8 * de[var0];
            int var56 = RegionPassCache.nSB;
            if (var56 < (361844990 ^ 361845502) && var23 > 0.002F) {
               int var60 = var56 * 8;
               var3[var60] = var105 * var115;
               var3[var60 + 1] = var108 * var115;
               var3[var60 + 2] = var111 * var115;
               var3[var60 + 3] = 1.1F * var5;
               var3[var60 + 4] = 1.45F * var5;
               var3[var60 + 5] = var126;
               var3[var60 + 6] = 4.0F;
               var3[var60 + 7] = Float.intBitsToFloat(Math.min(-1904379587 ^ -1904379454, (int)(var23 * 255.0F + 0.5F)) << 24 | var18);
               RegionPassCache.nSB = var56 + 1;
            }
         }

         if (var4 >= 0.16F) {
            var22 = (var4 - 0.16F) / 0.02F;
            var22 = var22 > 1.0F ? 1.0F : var22;
            float var82 = (float)Math.exp((double)(-(var4 - 0.16F) / 0.12F)) * var22 * var22 * (3.0F - 2.0F * var22) * var8 * var9;
            float var84 = (float)Math.sqrt((double)Math.max(0.0F, (dd[var0] + 3.1999998F - 1.0F) / 20.0F * 1.6F));
            float var86 = (float) (Math.PI / 2) * (var84 > 1.0F ? 1.0F : var84);
            float var87 = -0.55F * var6 * (float)Math.sin((double)var86);
            float var88 = var10 + var87 * var14;
            float var89 = var11 + 0.55F * var6 * (float)Math.cos((double)var86);
            float var90 = var12 + var87 * var15;
            float var91 = (float)Math.sqrt((double)(var88 * var88 + var89 * var89 + var90 * var90));
            float var92 = var91 > 0.4F ? 1.0F - 0.4F / var91 : 0.0F;
            int var57 = RegionPassCache.nSB;
            if (var57 + 1 < (122702211 ^ 122702723) && var82 > 0.002F) {
               int var61 = var57 * 8;
               var3[var61] = var88 * var92;
               var3[var61 + 1] = var89 * var92;
               var3[var61 + 2] = var90 * var92;
               var3[var61 + 3] = 1.7F * var5;
               var3[var61 + 4] = 1.7F * var5;
               var3[var61 + 5] = 0.0F;
               var3[var61 + 6] = 4.0F;
               var3[var61 + 7] = Float.intBitsToFloat(Math.min(172626059 ^ 172626036, (int)(0.95F * var82 * 255.0F + 0.5F)) << 24 | var19);
               var3[var61 + 8] = var88 * var92;
               var3[var61 + 9] = var89 * var92;
               var3[var61 + 10] = var90 * var92;
               var3[var61 + 11] = 0.3F * var5;
               var3[var61 + 12] = 0.3F * var5;
               var3[var61 + 13] = 0.0F;
               var3[var61 + 14] = 3.0F;
               var3[var61 + 15] = Float.intBitsToFloat(Math.min(-1836431417 ^ -1836431560, (int)(var82 * 255.0F + 0.5F)) << 24 | 249578047 ^ 236961216);
               RegionPassCache.nSB = var57 + 2;
            }
         }

         float var83 = (var4 - 0.16F) / 0.7F;
         if (var83 > 0.0F && var83 < 1.0F && fl < 96) {
            float var85 = 1.0F - var83;
            int var62 = fl * 16;
            fi[var62] = 0.0F;
            fi[var62 + 1] = var10;
            fi[var62 + 2] = var13 + 0.015F;
            fi[var62 + 3] = var12;
            fi[var62 + 10] = 2.4F * var5 * (1.0F - var85 * var85 * var85 * var85);
            fi[var62 + 11] = 0.6F;
            fi[var62 + 12] = (float)Math.pow((double)var85, 1.2) * Math.min(1.0F, var83 / 0.05F) * var7;
            fi[var62 + 13] = (float)fx[10];
            fi[var62 + 14] = 1.0F + 3.0F * var83;
            fi[var62 + 15] = 0.5F;
            fl++;
         }

         var22 = (var4 - 0.16F) / 0.05F;
         var22 = var22 < 0.0F ? 0.0F : (var22 > 1.0F ? 1.0F : var22);
         float var79 = var22 * var22 * (3.0F - 2.0F * var22);
         var22 = (var4 - 0.16F - 0.2F) / 0.8400001F;
         var22 = var22 < 0.0F ? 0.0F : (var22 > 1.0F ? 1.0F : var22);
         var79 *= 0.35F * (1.0F - var22 * var22 * (3.0F - 2.0F * var22)) * var7;
         if (fl < 96 && var79 > 0.002F) {
            int var63 = fl * 16;
            fi[var63] = 3.0F;
            fi[var63 + 1] = var10;
            fi[var63 + 2] = var13 + 0.014F;
            fi[var63 + 3] = var12;
            fi[var63 + 10] = 1.6F * var5;
            fi[var63 + 11] = 4.0F;
            fi[var63 + 12] = var79;
            fi[var63 + 13] = (float)fx[10];
            fi[var63 + 15] = 1.0F;
            fl++;
         }
      } catch (RuntimeException var53) {
         throw var53;
      }
   }

   private static void t(int var0) {

      assert var0 >= 0
         && var0 < 9
         && cn[var0] == 3
         && _kwren_do.length == (-1277422247 ^ -1277424810)
         && dp.length == 27
         && dn.length == (895259836 ^ 895260152)
         && hf.length == 3
         && hg.length == 3
         && fg.length == (-526926747 ^ -526932891)
         && fh.length == (-981971599 ^ -981973903)
         && fi.length == (-1754011320 ^ -1754009784)
         && fx.length == 21
         && fy.length == 21
         && RegionPassCache.SB.length == (1194538006 ^ 1194533910)
         && bm[3] > 1.7F;

      try {
         float[] var1 = RegionPassCache.SB;
         float var2 = cr[var0];
         float var3 = cz[var0];
         float var4 = cx[var0];
         float var5 = dg[var0];
         float var6 = dh[var0];
         float var7 = var5 * de[var0];
         float var8 = (float)(cs[var0] - RegionPassCache.z);
         float var9 = (float)(ct[var0] - RegionPassCache.aa);
         float var10 = (float)(cu[var0] - RegionPassCache.ab);
         float var11 = (float)(cv[var0] - RegionPassCache.aa);
         int var12 = ft;
         int var13 = fu;
         int var14 = fx[17];
         int var19 = var0 * (-1920836798 ^ -1920837611) + (var2 < 0.2F ? 0 : (var2 < 0.33F ? 1 : 2)) * (-1589062246 ^ -1589062521);
         float var20 = 0.0F;
         if (var2 >= 0.08F) {
            float var17 = (var2 - 0.33F) / 0.29F;
            var17 = var17 < 0.0F ? 0.0F : (var17 > 1.0F ? 1.0F : var17);
            var20 = Math.max((float)Math.exp((double)(-(var2 - 0.08F) / 0.05F)), 0.35F * (1.0F - var17 * var17 * (3.0F - 2.0F * var17)));
            if (var2 >= 0.2F) {
               var20 = Math.max(var20, (float)Math.exp((double)(-(var2 - 0.2F) / 0.05F)));
            }

            if (var2 >= 0.33F) {
               var20 = Math.max(var20, (float)Math.exp((double)(-(var2 - 0.33F) / 0.05F)));
            }
         }

         int var21 = var2 < 0.08F ? 1 + (int)(var2 / 0.08F * 32.0F) : 33;
         if ((var2 < 0.08F ? var21 >= 2 : var20 > 0.004F) && fj + 95 <= (829065821 ^ 829063773) && fk + 20 <= (-254887081 ^ -254887337)) {
            int var22 = fj;

            for (int var23 = 0; var23 < 95; var23++) {
               int var24 = var19 + var23 * 3;
               int var25 = (var22 + var23) * 3;
               fg[var25] = var8 + _kwren_do[var24];
               fg[var25 + 1] = var9 + _kwren_do[var24 + 1];
               fg[var25 + 2] = var10 + _kwren_do[var24 + 2];
            }

            fj = var22 + 95;

            for (int var76 = 0; var76 < 20; var76++) {
               float var32 = 1.0F;
               float var26;
               float var27;
               float var28;
               float var29;
               float var30;
               float var31;
               float var78;
               float var80;
               if (var2 < 0.08F) {
                  if (var76 > 1) {
                     break;
                  }

                  var78 = (float)var22;
                  var80 = (float)var21;
                  var26 = var76 == 0 ? 0.3F * var3 : 0.05F * var3;
                  var27 = var26;
                  var28 = (var76 == 0 ? 0.3F : 0.6F) * var5;
                  var29 = var28;
                  var30 = var76 == 0 ? (float)var12 : (float)var14;
                  var31 = var76 == 0 ? 2.0F : 1.0F;
               } else if (var76 < 4) {
                  var78 = (float)var22;
                  var80 = 33.0F;
                  var26 = var3 * (var76 == 0 ? 0.4F : (var76 == 1 ? 1.1F : (var76 == 2 ? 0.4F : 0.12F)));
                  var27 = var26;
                  var28 = var5 * (var76 == 0 ? 0.3F * var20 : (var76 == 1 ? 0.35F * var20 : (var76 == 2 ? 0.7F * var20 : Math.min(1.0F, 1.2F * var20))));
                  var29 = var28;
                  var30 = var76 != 0 && var76 != 1 ? (float)(var76 == 2 ? fx[6] : var14) : (float)var12;
                  var31 = var76 == 3 ? 1.0F : 2.0F;
                  var32 = var76 == 0 ? 0.0F : 1.0F;
               } else if (var76 < 10) {
                  int var33 = var76 - 4 >> 1;
                  boolean var34 = (var76 & 1) != 0;
                  float var35 = dp[var0 * 3 + var33] * var20 * var5;
                  var78 = (float)(var22 + 33 + 9 * var33);
                  var80 = 9.0F;
                  var26 = var34 ? 0.075F * var3 : 0.5F * var3;
                  var27 = var34 ? 0.012F : 0.05F * var3;
                  var28 = var34 ? var35 : 0.5F * var35;
                  var29 = var34 ? 0.35F * var35 : 0.0F;
                  var30 = var34 ? (float)var14 : (float)var12;
                  var31 = var34 ? 1.0F : 2.0F;
               } else {
                  int var91 = var76 - 10 >> 1;
                  boolean var93 = (var76 & 1) != 0;
                  var78 = (float)(var22 + 60 + 7 * var91);
                  var80 = 7.0F;
                  var26 = var93 ? 0.045F * var3 : 0.22F * var3;
                  var27 = var93 ? 0.02F * var3 : 0.1F * var3;
                  var28 = (var93 ? 0.95F : 0.45F) * var20 * var5;
                  var29 = var93 ? 0.1F * var20 * var5 : 0.0F;
                  var30 = var93 ? (float)var14 : (float)var13;
                  var31 = var93 ? 1.0F : 2.0F;
               }

               int var16 = fk * 9;
               fh[var16] = var78;
               fh[var16 + 1] = var80;
               fh[var16 + 2] = var26;
               fh[var16 + 3] = var27;
               fh[var16 + 4] = var28;
               fh[var16 + 5] = var29;
               fh[var16 + 6] = var30;
               fh[var16 + 7] = var31;
               fh[var16 + 8] = var32;
               fk++;
            }
         }

         float var75 = var2 - 0.08F;
         if (var75 >= 0.0F) {
            float var77 = var9 + 0.9F * var4;
            float var79 = (float)Math.sqrt((double)(var8 * var8 + var77 * var77 + var10 * var10));
            float var81 = var79 > 0.4F ? 1.0F - 0.4F / var79 : 0.0F;
            int var15 = RegionPassCache.nSB;
            if (var15 + 1 < (1255217355 ^ 1255217867)) {
               int var60 = var15 * 8;
               float var18 = 0.9F * var20 * var6 * var7;
               var1[var60] = var8 * var81;
               var1[var60 + 1] = var77 * var81;
               var1[var60 + 2] = var10 * var81;
               var1[var60 + 3] = 2.3F * var3;
               var1[var60 + 4] = 2.3F * var3;
               var1[var60 + 5] = 0.0F;
               var1[var60 + 6] = 4.0F;
               var1[var60 + 7] = Float.intBitsToFloat(Math.min(1931808971 ^ 1931808820, (int)(var18 * 255.0F + 0.5F)) << 24 | var14);
               var18 = 0.1F * var20 * var20 * var7;
               var1[var60 + 8] = var8 + 0.5F * _kwren_do[var19];
               var1[var60 + 9] = var9 + 0.5F * (_kwren_do[var19 + 1] + _kwren_do[var19 + 97]);
               var1[var60 + 10] = var10 + 0.5F * _kwren_do[var19 + 2];
               var1[var60 + 11] = 9.0F * var3;
               var1[var60 + 12] = 9.0F * var3;
               var1[var60 + 13] = 0.0F;
               var1[var60 + 14] = 4.0F;
               var1[var60 + 15] = Float.intBitsToFloat(Math.min(-328197962 ^ -328198071, (int)(var18 * 255.0F + 0.5F)) << 24 | var12);
               RegionPassCache.nSB = var15 + 2;
            }

            if (fl + 4 <= 96) {
               int var61 = fl * 16;
               fi[var61] = 3.0F;
               fi[var61 + 1] = var8;
               fi[var61 + 2] = var11 + 0.013F;
               fi[var61 + 3] = var10;
               fi[var61 + 10] = 5.0F * var3;
               fi[var61 + 11] = 4.0F;
               fi[var61 + 12] = 0.35F * var20 * var5;
               fi[var61 + 13] = (float)var12;
               fi[var61 + 15] = 1.0F;
               var61 += 16;
               fi[var61] = 3.0F;
               fi[var61 + 1] = var8;
               fi[var61 + 2] = var11 + 0.016F;
               fi[var61 + 3] = var10;
               fi[var61 + 10] = 2.5F * var3;
               fi[var61 + 11] = 4.0F;
               fi[var61 + 12] = 0.6F * (float)Math.exp((double)(-var75 / 0.4F)) * var5;
               fi[var61 + 13] = (float)var12;
               fi[var61 + 15] = 1.0F;
               var61 += 16;
               float var67 = var75 / 0.12F;
               var67 = var67 > 1.0F ? 1.0F : var67;
               float var74 = var67 * var67 * (3.0F - 2.0F * var67);
               var67 = (var75 - 1.0F) / 0.6F;
               var67 = var67 < 0.0F ? 0.0F : (var67 > 1.0F ? 1.0F : var67);
               fi[var61] = 3.0F;
               fi[var61 + 1] = var8;
               fi[var61 + 2] = var11 + 0.012F;
               fi[var61 + 3] = var10;
               fi[var61 + 10] = 1.3F * var3;
               fi[var61 + 11] = 24.0F;
               fi[var61 + 12] = 0.8F * var74 * (1.0F - var67 * var67 * (3.0F - 2.0F * var67)) * var5;
               fi[var61 + 13] = 722950.0F;
               fi[var61 + 15] = 0.0F;
               fl += 3;
               float var82 = var75 / 0.5F;
               if (var82 < 1.0F) {
                  float var84 = 1.0F - var82;
                  var61 = fl * 16;
                  fi[var61] = 0.0F;
                  fi[var61 + 1] = var8;
                  fi[var61 + 2] = var11 + 0.017F;
                  fi[var61 + 3] = var10;
                  fi[var61 + 10] = 3.0F * var3 * (1.0F - var84 * var84 * var84 * var84);
                  fi[var61 + 11] = 0.55F;
                  fi[var61 + 12] = (float)Math.pow((double)var84, 1.2) * Math.min(1.0F, var82 / 0.05F) * var5;
                  fi[var61 + 13] = (float)fx[10];
                  fi[var61 + 14] = 2.0F;
                  fi[var61 + 15] = 0.4F;
                  fl++;
               }
            }

            float var71 = (var2 - 0.4F) / 0.2F;
            var71 = var71 < 0.0F ? 0.0F : (var71 > 1.0F ? 1.0F : var71);
            float var83 = (1.0F - var71 * var71 * (3.0F - 2.0F * var71)) * var5;
            int var85 = cq[var0];
            if (var83 > 0.002F && var85 > 0) {
               float var86 = db[var0];
               float var87 = dc[var0];
               float var88 = -var87;
               float var89 = var86;
               boolean var90 = -(var8 * var88 + var10 * var86) > 0.0F;
               int var92 = (int)(var2 / 0.045F);
               int var94 = var0 * 36;
               int var95 = (int)dj[var0];

               for (int var36 = 0; var36 < 5 && fj + 5 <= (-1198628875 ^ -1198630923) && fk + 2 <= (-1011826172 ^ -1011825916); var36++) {
                  int var37 = var92 * (563354734 ^ -1079810593) + var36 * (1517340794 ^ -543489519) ^ var95;
                  int var38 = fj;
                  int var39 = var38 * 3;

                  for (int var40 = 0; var40 < 2; var40++) {
                     int var96 = var37 ^ var37 << 13;
                     int var97 = var96 ^ var96 >>> 17;
                     int var98 = var97 ^ var97 << 5;
                     int var41 = var94 + (var98 >>> 8) % var85 * 6;
                     int var99 = var98 ^ var98 << 13;
                     int var100 = var99 ^ var99 >>> 17;
                     int var101 = var100 ^ var100 << 5;
                     float var42 = (float)(var101 >>> 8) * 5.9604645E-8F;
                     int var102 = var101 ^ var101 << 13;
                     int var103 = var102 ^ var102 >>> 17;
                     var37 = var103 ^ var103 << 5;
                     float var43 = (float)(var37 >>> 8) * 5.9604645E-8F;
                     float var44 = (dn[var41] + (dn[var41 + 3] - dn[var41]) * var42) * 1.1F;
                     float var45 = dn[var41 + 1] + (dn[var41 + 4] - dn[var41 + 1]) * var43;
                     float var46 = var90 ? dn[var41 + 5] + 0.05F : dn[var41 + 2] - 0.05F;
                     int var47 = var39 + var40 * 12;
                     fg[var47] = var8 + var44 * var86 + var46 * var88;
                     fg[var47 + 1] = var9 + var45;
                     fg[var47 + 2] = var10 + var44 * var87 + var46 * var89;
                  }

                  for (int var109 = 0; var109 < 3; var109++) {
                     int var110 = var39 + hf[var109] * 3;
                     int var111 = var39 + (hf[var109] + hg[var109]) * 3;
                     int var112 = var39 + (hf[var109] + hg[var109] / 2) * 3;
                     float var113 = fg[var111] - fg[var110];
                     float var114 = fg[var111 + 1] - fg[var110 + 1];
                     float var115 = fg[var111 + 2] - fg[var110 + 2];
                     float var116 = (float)Math.sqrt((double)(var113 * var113 + var114 * var114 + var115 * var115));
                     float var48 = -var115;
                     float var49 = var113;
                     float var50 = (float)Math.sqrt((double)(var48 * var48 + var113 * var113));
                     if (var50 < 1.0E-5F) {
                        var48 = 1.0F;
                        var49 = 0.0F;
                        var50 = 1.0F;
                     }

                     var48 /= var50;
                     var49 /= var50;
                     float var51 = var114 * var49;
                     float var52 = var115 * var48 - var113 * var49;
                     float var53 = -var114 * var48;
                     float var54 = (float)Math.sqrt((double)(var51 * var51 + var52 * var52 + var53 * var53));
                     if (var54 > 1.0E-9F) {
                        var51 /= var54;
                        var52 /= var54;
                        var53 /= var54;
                     }

                     int var104 = var37 ^ var37 << 13;
                     int var105 = var104 ^ var104 >>> 17;
                     int var106 = var105 ^ var105 << 5;
                     float var55 = (float)(var106 >>> 8) * 5.9604645E-8F * (float) (Math.PI * 2);
                     int var107 = var106 ^ var106 << 13;
                     int var108 = var107 ^ var107 >>> 17;
                     var37 = var108 ^ var108 << 5;
                     float var56 = ((float)(var37 >>> 8) * 1.1920929E-7F - 1.0F) * 0.35F * var116;
                     float var57 = (float)Math.cos((double)var55);
                     float var58 = (float)Math.sin((double)var55);
                     fg[var112] = 0.5F * (fg[var110] + fg[var111]) + (var48 * var57 + var51 * var58) * var56;
                     fg[var112 + 1] = 0.5F * (fg[var110 + 1] + fg[var111 + 1]) + var52 * var58 * var56;
                     fg[var112 + 2] = 0.5F * (fg[var110 + 2] + fg[var111 + 2]) + (var49 * var57 + var53 * var58) * var56;
                  }

                  fj = var38 + 5;
                  int var65 = fk * 9;
                  fh[var65] = (float)var38;
                  fh[var65 + 1] = 5.0F;
                  fh[var65 + 2] = 0.14F * var3;
                  fh[var65 + 3] = 0.14F * var3;
                  fh[var65 + 4] = 0.35F * var83;
                  fh[var65 + 5] = 0.35F * var83;
                  fh[var65 + 6] = (float)var13;
                  fh[var65 + 7] = 2.0F;
                  fh[var65 + 8] = 1.0F;
                  fh[var65 + 9] = (float)var38;
                  fh[var65 + 10] = 5.0F;
                  fh[var65 + 11] = 0.035F * var3;
                  fh[var65 + 12] = 0.035F * var3;
                  fh[var65 + 13] = 0.9F * var83;
                  fh[var65 + 14] = 0.9F * var83;
                  fh[var65 + 15] = (float)fy[12];
                  fh[var65 + 16] = 1.0F;
                  fh[var65 + 17] = 1.0F;
                  fk += 2;
               }
            }
         }
      } catch (RuntimeException var59) {
         throw var59;
      }
   }

   private static void u(int var0) {

      assert var0 >= 0
         && var0 < 9
         && cn[var0] == 4
         && dt.length == (1227406570 ^ 1227406766)
         && du.length == (685786568 ^ 685786232)
         && dv.length == 54
         && fx.length == 21
         && fy.length == 21
         && fi.length == (-1545609707 ^ -1545611243)
         && RegionPassCache.SA.length == (-206870287 ^ -206837519)
         && RegionPassCache.SB.length == (1000335578 ^ 1000339674)
         && RegionPassCache.LB.length == (-1966683745 ^ -1966678113)
         && bm[4] > 2.2F;

      try {
         float[] var1 = RegionPassCache.SA;
         float[] var2 = RegionPassCache.SB;
         float[] var3 = RegionPassCache.LB;
         float var4 = cr[var0];
         float var5 = cz[var0];
         float var6 = cx[var0];
         float var7 = dg[var0];
         float var8 = dh[var0];
         float var9 = var7 * de[var0];
         float var10 = (float)(cs[var0] - RegionPassCache.z);
         float var11 = (float)(ct[var0] - RegionPassCache.aa);
         float var12 = (float)(cu[var0] - RegionPassCache.ab);
         float var13 = (float)(cv[var0] - RegionPassCache.aa);
         float var14 = var11 + 0.55F * var6;
         float var15 = RegionPassCache.rX;
         float var16 = RegionPassCache.rY;
         float var17 = RegionPassCache.rZ;
         float var18 = RegionPassCache.uX;
         float var19 = RegionPassCache.uY;
         float var20 = RegionPassCache.uZ;
         int var21 = ft;
         int var22 = fu;
         int var23 = fx[17];
         float var29 = (float)Math.sqrt((double)(var10 * var10 + var14 * var14 + var12 * var12));
         float var30 = var29 > 0.45F ? 1.0F - 0.45F / var29 : 0.0F;
         float var31 = var10 * var30;
         float var32 = var14 * var30;
         float var33 = var12 * var30;
         if (var4 < 0.16F) {
            float var34 = var4 / 0.14F;
            var34 = var34 > 1.0F ? 1.0F : var34;
            float var35 = 2.6F * var5 * (1.0F - var34 * var34 * var34);
            float var36 = 0.9F * var5 * (0.4F + 0.6F * var34);
            float var26 = var4 / 0.04F;
            var26 = var26 > 1.0F ? 1.0F : var26;
            float var27 = var26 * var26 * (3.0F - 2.0F * var26);
            var26 = (var4 - 0.14F) / 0.02F;
            var26 = var26 < 0.0F ? 0.0F : (var26 > 1.0F ? 1.0F : var26);
            var27 *= (1.0F - var26 * var26 * (3.0F - 2.0F * var26)) * var8 * var9;
            float var28 = 0.95F * var27;
            if (var28 > 0.002F) {
               float var37 = Float.intBitsToFloat(Math.min(1699663938 ^ 1699664061, (int)(var28 * 255.0F + 0.5F)) << 24 | fx[12]);
               float var38 = Float.intBitsToFloat(fx[10]);
               int var39 = var0 * 48;

               for (int var40 = 0; var40 < 16; var39 += 3) {
                  int var24 = RegionPassCache.nLB;
                  if (var24 >= (1434612096 ^ 1434612608)) {
                     break;
                  }

                  float var41 = du[var39];
                  float var42 = du[var39 + 1];
                  float var43 = du[var39 + 2];
                  float var44 = var10 + var41 * var35;
                  float var45 = var14 + var42 * var35;
                  float var46 = var12 + var43 * var35;
                  int var25 = var24 * 11;
                  var3[var25] = var44 + var41 * var36;
                  var3[var25 + 1] = var45 + var42 * var36;
                  var3[var25 + 2] = var46 + var43 * var36;
                  var3[var25 + 3] = var44;
                  var3[var25 + 4] = var45;
                  var3[var25 + 5] = var46;
                  var3[var25 + 6] = 0.0F;
                  var3[var25 + 7] = 0.08F * var5;
                  var3[var25 + 8] = var38;
                  var3[var25 + 9] = var37;
                  var3[var25 + 10] = 2.0F;
                  RegionPassCache.nLB = var24 + 1;
                  var40++;
               }
            }

            int var53 = RegionPassCache.nSB;
            if (var53 + 1 < (343542207 ^ 343542719) && var27 > 0.002F) {
               float var102 = (0.8F - 0.5F * var34) * var5;
               int var60 = var53 * 8;
               var2[var60] = var31;
               var2[var60 + 1] = var32;
               var2[var60 + 2] = var33;
               var2[var60 + 3] = var102;
               var2[var60 + 4] = var102;
               var2[var60 + 5] = 0.0F;
               var2[var60 + 6] = 4.0F;
               var2[var60 + 7] = Float.intBitsToFloat(Math.min(-1757461111 ^ -1757461130, (int)((0.45F + 0.55F * var34) * var27 * 255.0F + 0.5F)) << 24 | var23);
               var2[var60 + 8] = var31;
               var2[var60 + 9] = var32;
               var2[var60 + 10] = var33;
               var2[var60 + 11] = 0.12F * var5;
               var2[var60 + 12] = 0.12F * var5;
               var2[var60 + 13] = 0.0F;
               var2[var60 + 14] = 3.0F;
               var2[var60 + 15] = Float.intBitsToFloat(
                  Math.min(-1274186896 ^ -1274186865, (int)(var34 * var27 * 255.0F + 0.5F)) << 24 | 2007721710 ^ 2002032913
               );
               RegionPassCache.nSB = var53 + 2;
            }
         }

         float var99 = var4 - 0.14F;
         if (!(var99 < 0.0F)) {
            float var72 = var99 / 0.12F;
            var72 = var72 > 1.0F ? 1.0F : var72;
            float var87 = 1.0F - var72;
            float var100 = 2.7F * var5 * (1.0F - var87 * var87 * var87);
            int var54 = RegionPassCache.nSB;
            if (var54 + 1 < (359351588 ^ 359352100)) {
               int var61 = var54 * 8;
               float var92 = (float)Math.exp((double)(-var99 / 0.22F)) * var8 * var9;
               var2[var61] = var31;
               var2[var61 + 1] = var32;
               var2[var61 + 2] = var33;
               var2[var61 + 3] = var100;
               var2[var61 + 4] = var100;
               var2[var61 + 5] = 0.0F;
               var2[var61 + 6] = 4.0F;
               var2[var61 + 7] = Float.intBitsToFloat(Math.min(-670387331 ^ -670387326, (int)(var92 * 255.0F + 0.5F)) << 24 | var23);
               var92 = (float)Math.exp((double)(-var99 / 0.1F)) * var8 * var9;
               var2[var61 + 8] = var31;
               var2[var61 + 9] = var32;
               var2[var61 + 10] = var33;
               var2[var61 + 11] = 0.5F * var5;
               var2[var61 + 12] = 0.5F * var5;
               var2[var61 + 13] = 0.0F;
               var2[var61 + 14] = 3.0F;
               var2[var61 + 15] = Float.intBitsToFloat(Math.min(-121625800 ^ -121625657, (int)(var92 * 255.0F + 0.5F)) << 24 | 2122496163 ^ 2122139484);
               RegionPassCache.nSB = var54 + 2;
            }

            var72 = var99 / 0.05F;
            var72 = var72 > 1.0F ? 1.0F : var72;
            var87 = var72 * var72 * (3.0F - 2.0F * var72);
            var72 = (var99 - 0.25F) / 0.85F;
            var72 = var72 < 0.0F ? 0.0F : (var72 > 1.0F ? 1.0F : var72);
            float var101 = 0.75F * var87 * (1.0F - var72 * var72 * (3.0F - 2.0F * var72)) * var8 * var9;
            if (var101 > 0.002F) {
               var72 = var99 / 0.25F;
               float var103 = var72 >= 1.0F ? 1.0F : 1.0F - (float)Math.exp((double)(-6.931472F * var72));
               float var106 = 0.25F * var5;
               int var110 = var0 * 36;
               int var115 = Math.min(-1839978020 ^ -1839978205, (int)(var101 * 255.0F + 0.5F)) << 24;

               for (int var118 = 0; var118 < 18; var110 += 2) {
                  var54 = RegionPassCache.nLB;
                  if (var54 >= (1015762453 ^ 1015761941)) {
                     break;
                  }

                  float var121 = dt[var110] + 0.25F * var99;
                  float var124 = (float)Math.cos((double)var121);
                  float var127 = (float)Math.sin((double)var121);
                  float var129 = var15 * var124 + var18 * var127;
                  float var131 = var16 * var124 + var19 * var127;
                  float var47 = var17 * var124 + var20 * var127;
                  float var48 = var106 + dt[var110 + 1] * var103;
                  int var49 = var118 % 3 == 0 ? var23 : (var118 % 3 == 1 ? var21 : var22);
                  int var62 = var54 * 11;
                  var3[var62] = var31 + var129 * var106;
                  var3[var62 + 1] = var32 + var131 * var106;
                  var3[var62 + 2] = var33 + var47 * var106;
                  var3[var62 + 3] = var31 + var129 * var48;
                  var3[var62 + 4] = var32 + var131 * var48;
                  var3[var62 + 5] = var33 + var47 * var48;
                  var3[var62 + 6] = 0.28F * var5;
                  var3[var62 + 7] = 0.0F;
                  var3[var62 + 8] = Float.intBitsToFloat(var115 | var49);
                  var3[var62 + 9] = Float.intBitsToFloat(var49);
                  var3[var62 + 10] = 2.0F;
                  RegionPassCache.nLB = var54 + 1;
                  var118++;
               }
            }

            float var94 = 0.85F * (float)Math.exp((double)(-var99 / 0.3F)) * var8 * var9;
            var54 = RegionPassCache.nLB;
            if (var54 + 3 < (-1159253227 ^ -1159253739) && var94 > 0.002F) {
               var72 = var99 / 0.2F;
               float var104 = var72 >= 1.0F ? 1.0F : 1.0F - (float)Math.exp((double)(-6.931472F * var72));
               float var107 = 5.0F * var5 * var104;
               float var111 = 1.6F * var5 * var104;
               int var116 = fx[12];
               float var119 = Float.intBitsToFloat(var116);
               float var122 = Float.intBitsToFloat(Math.min(-237158751 ^ -237158818, (int)(var94 * 255.0F + 0.5F)) << 24 | var116);
               float var125 = Float.intBitsToFloat(Math.min(-1539451460 ^ -1539451581, (int)(0.7F * var94 * 255.0F + 0.5F)) << 24 | var116);

               for (int var128 = 0; var128 < 4; var128++) {
                  boolean var130 = var128 < 2;
                  float var132 = var130 ? var15 : var18;
                  float var133 = var130 ? var16 : var19;
                  float var134 = var130 ? var17 : var20;
                  float var135 = var130 ? var107 : var111;
                  float var50 = var130 ? 0.16F * var5 : 0.08F * var5;
                  float var51 = (var128 & 1) == 0 ? -1.0F : 1.0F;
                  int var63 = (var54 + var128) * 11;
                  var3[var63] = var31 + var51 * var132 * var135;
                  var3[var63 + 1] = var32 + var51 * var133 * var135;
                  var3[var63 + 2] = var33 + var51 * var134 * var135;
                  var3[var63 + 3] = var31;
                  var3[var63 + 4] = var32;
                  var3[var63 + 5] = var33;
                  var3[var63 + 6] = 0.0F;
                  var3[var63 + 7] = var50;
                  var3[var63 + 8] = var119;
                  var3[var63 + 9] = var130 ? var122 : var125;
                  var3[var63 + 10] = 2.0F;
               }

               RegionPassCache.nLB = var54 + 4;
            }

            float var105 = var99 / 0.9F;
            var54 = RegionPassCache.nSB;
            if (var105 < 1.0F && var54 < (764751055 ^ 764751567)) {
               var87 = 1.0F - var105;
               float var108 = 3.2F * var5 * (1.0F - var87 * var87 * var87) / 0.86F;
               var72 = (var105 - 0.3F) / 0.7F;
               var72 = var72 < 0.0F ? 0.0F : (var72 > 1.0F ? 1.0F : var72);
               var94 = 0.9F * (1.0F - var72 * var72 * (3.0F - 2.0F * var72)) * var8 * var9;
               int var112 = fy[6];
               int var117 = var112 >> 16 & (-23273687 ^ -23273514);
               int var120 = var112 >> 8 & (118703746 ^ 118703741);
               int var123 = var112 & (-1407354566 ^ -1407354427);
               int var126 = (int)((float)var117 + (float)((var21 >> 16 & (152704408 ^ 152704359)) - var117) * var105 + 0.5F) << 16
                  | (int)((float)var120 + (float)((var21 >> 8 & (-1741733770 ^ -1741733751)) - var120) * var105 + 0.5F) << 8
                  | (int)((float)var123 + (float)((var21 & (-1451285487 ^ -1451285266)) - var123) * var105 + 0.5F);
               if (var94 > 0.002F) {
                  int var64 = var54 * 8;
                  var2[var64] = var10;
                  var2[var64 + 1] = var14;
                  var2[var64 + 2] = var12;
                  var2[var64 + 3] = var108;
                  var2[var64 + 4] = var108;
                  var2[var64 + 5] = 0.0F;
                  var2[var64 + 6] = 25.0F;
                  var2[var64 + 7] = Float.intBitsToFloat(Math.min(-86493503 ^ -86493634, (int)(var94 * 255.0F + 0.5F)) << 24 | var126);
                  RegionPassCache.nSB = var54 + 1;
               }
            }

            float var109 = var99 / 0.8F;
            if (var109 < 1.0F && fl < 96) {
               var87 = 1.0F - var109;
               int var113 = var0 * 6;
               int var65 = fl * 16;
               fi[var65] = 1.0F;
               fi[var65 + 1] = var10;
               fi[var65 + 2] = var14;
               fi[var65 + 3] = var12;
               fi[var65 + 4] = dv[var113];
               fi[var65 + 5] = dv[var113 + 1];
               fi[var65 + 6] = dv[var113 + 2];
               fi[var65 + 7] = dv[var113 + 3];
               fi[var65 + 8] = dv[var113 + 4];
               fi[var65 + 9] = dv[var113 + 5];
               fi[var65 + 10] = 3.8F * var5 * (1.0F - var87 * var87 * var87);
               fi[var65 + 11] = 0.6F;
               fi[var65 + 12] = 0.9F * (float)Math.pow((double)var87, 1.2) * Math.min(1.0F, var109 / 0.05F) * var7;
               fi[var65 + 13] = (float)fx[8];
               fi[var65 + 14] = 0.0F;
               fi[var65 + 15] = 0.0F;
               fl++;
            }

            var72 = (var99 - 0.15F) / 0.2F;
            var72 = var72 < 0.0F ? 0.0F : (var72 > 1.0F ? 1.0F : var72);
            var87 = var72 * var72 * (3.0F - 2.0F * var72);
            var72 = (var4 - 1.2F) / 0.9F;
            var72 = var72 < 0.0F ? 0.0F : (var72 > 1.0F ? 1.0F : var72);
            float var114 = 0.55F
               * (0.6F + 0.4F * (float)Math.cos((double)(13.823008F * var99)))
               * var87
               * (1.0F - var72 * var72 * (3.0F - 2.0F * var72))
               * var7;
            if (var114 > 0.002F) {
               var54 = RegionPassCache.nSB;
               var94 = var114 * var8 * de[var0];
               if (var54 < (359365291 ^ 359364779) && var94 > 0.002F) {
                  int var66 = var54 * 8;
                  var2[var66] = var10;
                  var2[var66 + 1] = var14;
                  var2[var66 + 2] = var12;
                  var2[var66 + 3] = 0.32F * var5;
                  var2[var66 + 4] = 0.32F * var5;
                  var2[var66 + 5] = 0.0F;
                  var2[var66 + 6] = 4.0F;
                  var2[var66 + 7] = Float.intBitsToFloat(Math.min(-1002730876 ^ -1002730885, (int)(var94 * 255.0F + 0.5F)) << 24 | fx[6]);
                  RegionPassCache.nSB = var54 + 1;
               }

               var54 = RegionPassCache.nSA;
               if (var54 < (-2024480165 ^ -2024476069)) {
                  int var67 = var54 * 8;
                  var1[var67] = var10;
                  var1[var67 + 1] = var14;
                  var1[var67 + 2] = var12;
                  var1[var67 + 3] = 0.08F * var5;
                  var1[var67 + 4] = 0.08F * var5;
                  var1[var67 + 5] = 0.0F;
                  var1[var67 + 6] = 3.0F;
                  var1[var67 + 7] = Float.intBitsToFloat(Math.min(-645507174 ^ -645507227, (int)(var114 * 255.0F + 0.5F)) << 24 | 1844739642 ^ 1829470661);
                  RegionPassCache.nSA = var54 + 1;
               }
            }

            var94 = 0.45F * (float)Math.exp((double)(-var99 / 0.5F)) * var7;
            if (fl < 96 && var94 > 0.002F) {
               int var68 = fl * 16;
               fi[var68] = 3.0F;
               fi[var68 + 1] = var10;
               fi[var68 + 2] = var13 + 0.014F;
               fi[var68 + 3] = var12;
               fi[var68 + 10] = 2.6F * var5;
               fi[var68 + 11] = 4.0F;
               fi[var68 + 12] = var94;
               fi[var68 + 13] = (float)var21;
               fi[var68 + 15] = 1.0F;
               fl++;
            }
         }
      } catch (RuntimeException var52) {
         throw var52;
      }
   }

   private static void v(int var0) {

      assert var0 >= 0
         && var0 < 9
         && cn[var0] == 5
         && dx.length == (-1424494883 ^ -1424495163)
         && dv.length == 54
         && fx.length == 21
         && fy.length == 21
         && fg.length == (1027387327 ^ 1027389375)
         && fh.length == (-577899218 ^ -577897426)
         && fi.length == (1153781183 ^ 1153780671)
         && RegionPassCache.SA.length == (-508260232 ^ -508293000)
         && RegionPassCache.ST.length == (1783911828 ^ 1783920020)
         && RegionPassCache.SB.length == (219834391 ^ 219838487)
         && RegionPassCache.LB.length == (843657032 ^ 843659592)
         && bm[5] > 1.5F;

      try {
         float[] var1 = RegionPassCache.SA;
         float[] var2 = RegionPassCache.ST;
         float[] var3 = RegionPassCache.SB;
         float[] var4 = RegionPassCache.LB;
         float var5 = cr[var0];
         float var6 = cz[var0];
         float var7 = cx[var0];
         float var8 = dg[var0];
         float var9 = dh[var0];
         float var10 = var8 * de[var0];
         float var11 = (float)(cs[var0] - RegionPassCache.z);
         float var12 = (float)(ct[var0] - RegionPassCache.aa);
         float var13 = (float)(cu[var0] - RegionPassCache.ab);
         float var14 = (float)(cv[var0] - RegionPassCache.aa);
         float var15 = var12 + 0.55F * var7;
         int var16 = ft;
         int var17 = fu;
         int var18 = fx[17];
         int var19 = var0 * 6;
         float var20 = dv[var19];
         float var21 = dv[var19 + 1];
         float var22 = dv[var19 + 2];
         float var23 = dv[var19 + 3];
         float var24 = dv[var19 + 4];
         float var25 = dv[var19 + 5];
         float var31 = (float)Math.sqrt((double)(var11 * var11 + var15 * var15 + var13 * var13));
         float var32 = var31 > 0.5F ? 1.0F - 0.5F / var31 : 0.0F;
         float var33 = var11 * var32;
         float var34 = var15 * var32;
         float var35 = var13 * var32;
         float var36 = var5 / 0.55F;
         var36 = var36 > 1.0F ? 1.0F : var36;
         float var37 = var36 * var36 * var36;
         if (var5 < 0.58F) {
            float var28 = var5 / 0.3F;
            var28 = var28 > 1.0F ? 1.0F : var28;
            float var38 = (0.25F + 0.55F * var28 * var28 * (3.0F - 2.0F * var28)) * (1.0F - 0.9F * var37) * var6;
            var28 = var5 / 0.15F;
            var28 = var28 > 1.0F ? 1.0F : var28;
            float var39 = var28 * var28 * (3.0F - 2.0F * var28);
            var28 = (var5 - 0.55F + 0.02F) / 0.05F;
            var28 = var28 < 0.0F ? 0.0F : (var28 > 1.0F ? 1.0F : var28);
            var39 *= (1.0F - var28 * var28 * (3.0F - 2.0F * var28)) * var8;
            float var40 = var39 * var9;
            int var26 = RegionPassCache.nST;
            if (var26 < (-135811306 ^ -135812330) && var40 > 0.002F) {
               int var27 = var26 * 8;
               var2[var27] = var33;
               var2[var27 + 1] = var34;
               var2[var27 + 2] = var35;
               var2[var27 + 3] = var38 / 0.72F;
               var2[var27 + 4] = var38 / 0.72F;
               var2[var27 + 5] = 0.0F;
               var2[var27 + 6] = 8.0F;
               var2[var27 + 7] = Float.intBitsToFloat(Math.min(-1154942513 ^ -1154942672, (int)(0.95F * var40 * 255.0F + 0.5F)) << 24);
               RegionPassCache.nST = var26 + 1;
            }

            var26 = RegionPassCache.nSA;
            if (var26 < (-1963518271 ^ -1963522367) && var40 > 0.002F) {
               int var70 = var26 * 8;
               var1[var70] = var33;
               var1[var70 + 1] = var34;
               var1[var70 + 2] = var35;
               var1[var70 + 3] = var38 / 0.9F;
               var1[var70 + 4] = var38 / 0.9F;
               var1[var70 + 5] = 0.0F;
               var1[var70 + 6] = 17.0F;
               var1[var70 + 7] = Float.intBitsToFloat(Math.min(-1173200312 ^ -1173200201, (int)(var40 * 255.0F + 0.5F)) << 24 | fx[7]);
               RegionPassCache.nSA = var26 + 1;
            }

            float var30 = 0.3F * var39 * var9 * de[var0];
            var26 = RegionPassCache.nSB;
            if (var26 < (-408290749 ^ -408291261) && var30 > 0.002F) {
               int var71 = var26 * 8;
               var3[var71] = var33;
               var3[var71 + 1] = var34;
               var3[var71 + 2] = var35;
               var3[var71 + 3] = 1.8F * var38 / 0.86F;
               var3[var71 + 4] = 1.8F * var38 / 0.86F;
               var3[var71 + 5] = 0.0F;
               var3[var71 + 6] = 25.0F;
               var3[var71 + 7] = Float.intBitsToFloat(Math.min(614212755 ^ 614212716, (int)(var30 * 255.0F + 0.5F)) << 24 | var17);
               RegionPassCache.nSB = var26 + 1;
            }

            float var41 = (1.5F - 1.3F * var37) * var6;
            if (fl + 2 <= 96 && var39 > 0.002F) {
               int var72 = fl * 16;
               fi[var72] = 1.0F;
               fi[var72 + 1] = var11;
               fi[var72 + 2] = var15;
               fi[var72 + 3] = var13;
               fi[var72 + 4] = var20;
               fi[var72 + 5] = var21;
               fi[var72 + 6] = var22;
               fi[var72 + 7] = var23;
               fi[var72 + 8] = var24;
               fi[var72 + 9] = var25;
               fi[var72 + 10] = var41;
               fi[var72 + 11] = 0.55F;
               fi[var72 + 12] = 0.85F * var39;
               fi[var72 + 13] = (float)var16;
               fi[var72 + 14] = 0.0F;
               fi[var72 + 15] = 0.0F;
               float var42 = 4.0F * var5 * var5 + 2.0F * var5;
               float var43 = (float)Math.cos((double)var42);
               float var44 = (float)Math.sin((double)var42);
               float var45 = var41 * 1.25F / 0.9F;
               var72 += 16;
               fi[var72] = 4.0F;
               fi[var72 + 1] = var11;
               fi[var72 + 2] = var15;
               fi[var72 + 3] = var13;
               fi[var72 + 4] = (var20 * var43 + var23 * var44) * var45;
               fi[var72 + 5] = (var21 * var43 + var24 * var44) * var45;
               fi[var72 + 6] = (var22 * var43 + var25 * var44) * var45;
               fi[var72 + 7] = (var23 * var43 - var20 * var44) * var45;
               fi[var72 + 8] = (var24 * var43 - var21 * var44) * var45;
               fi[var72 + 9] = (var25 * var43 - var22 * var44) * var45;
               fi[var72 + 11] = 18.0F;
               fi[var72 + 12] = 0.6F * var39;
               fi[var72 + 13] = (float)var17;
               fi[var72 + 15] = 1.0F;
               fl += 2;
            }

            var28 = (var5 - 0.55F + 0.05F) / 0.05F;
            var28 = var28 < 0.0F ? 0.0F : (var28 > 1.0F ? 1.0F : var28);
            float var118 = (1.0F - var28 * var28 * (3.0F - 2.0F * var28)) * var8;
            int var121 = var0 * 88;

            for (int var123 = 0; var123 < 22 && var118 > 0.002F; var121 += 4) {
               float var125 = var5 - dx[var121 + 3];
               if (!(var125 <= 0.0F) && fj + 6 <= (-769086271 ^ -769088319) && fk < (-1540988592 ^ -1540988848)) {
                  var28 = var125 / 0.1F;
                  var28 = var28 > 1.0F ? 1.0F : var28;
                  float var46 = var28 * var28 * (3.0F - 2.0F * var28) * var118;
                  if (!(var46 < 0.002F)) {
                     int var47 = (var123 & 1) == 0 ? var16 : var17;
                     int var48 = fj;
                     int var49 = var48 * 3;
                     float var50 = 0.55F - dx[var121 + 3];

                     for (int var51 = 0; var51 <= 5; var51++) {
                        float var52 = var125 - 0.03F * (float)var51;
                        var52 = var52 < 0.0F ? 0.0F : var52;
                        float var53 = var52 / var50;
                        var53 = var53 > 1.0F ? 1.0F : var53;
                        float var54 = dx[var121] * (float)Math.pow((double)(1.0F - var53), 1.6) + 0.05F * var6;
                        float var55 = dx[var121 + 1] + 1.32F / (var54 / var6 + 0.25F) + 6.0F * var53;
                        float var56 = (float)Math.cos((double)var55);
                        float var57 = (float)Math.sin((double)var55);
                        fg[var49] = var11 + (var20 * var56 + var23 * var57) * var54;
                        fg[var49 + 1] = var15 + dx[var121 + 2] * (1.0F - var53) + (var21 * var56 + var24 * var57) * var54;
                        fg[var49 + 2] = var13 + (var22 * var56 + var25 * var57) * var54;
                        var49 += 3;
                     }

                     fj = var48 + 6;
                     int var74 = fk * 9;
                     fh[var74] = (float)var48;
                     fh[var74 + 1] = 6.0F;
                     fh[var74 + 2] = 0.09F * var6;
                     fh[var74 + 3] = 0.0F;
                     fh[var74 + 4] = 0.85F * var46;
                     fh[var74 + 5] = 0.0F;
                     fh[var74 + 6] = (float)var47;
                     fh[var74 + 7] = 2.0F;
                     fh[var74 + 8] = 1.0F;
                     fk++;
                     var26 = RegionPassCache.nSA;
                     if (var26 + 1 < (-383517765 ^ -383521861)) {
                        float var132 = fg[var48 * 3];
                        float var135 = fg[var48 * 3 + 1];
                        float var138 = fg[var48 * 3 + 2];
                        var74 = var26 * 8;
                        var1[var74] = var132;
                        var1[var74 + 1] = var135;
                        var1[var74 + 2] = var138;
                        var1[var74 + 3] = 0.045F * var6;
                        var1[var74 + 4] = 0.045F * var6;
                        var1[var74 + 5] = 0.0F;
                        var1[var74 + 6] = 3.0F;
                        var1[var74 + 7] = Float.intBitsToFloat(
                           Math.min(-839545991 ^ -839545978, (int)(var46 * 255.0F + 0.5F)) << 24 | ((var123 & 1) == 0 ? fx[12] : fy[12])
                        );
                        var1[var74 + 8] = var132;
                        var1[var74 + 9] = var135;
                        var1[var74 + 10] = var138;
                        var1[var74 + 11] = 0.18F * var6;
                        var1[var74 + 12] = 0.18F * var6;
                        var1[var74 + 13] = 0.0F;
                        var1[var74 + 14] = 4.0F;
                        var1[var74 + 15] = Float.intBitsToFloat(Math.min(-1827921593 ^ -1827921480, (int)(0.45F * var46 * 255.0F + 0.5F)) << 24 | var47);
                        RegionPassCache.nSA = var26 + 2;
                     }
                  }
               }

               var123++;
            }
         }

         float var112 = var5 - 0.55F;
         if (!(var112 < 0.0F)) {
            float var91 = var112 / 0.08F;
            var91 = var91 > 1.0F ? 1.0F : var91;
            float var29 = 1.0F - var91;
            float var114 = 2.3F * var6 * (1.0F - var29 * var29 * var29);
            int var65 = RegionPassCache.nSB;
            if (var65 + 1 < (680588998 ^ 680588486)) {
               int var76 = var65 * 8;
               float var108 = (float)Math.exp((double)(-var112 / 0.18F)) * var9 * var10;
               var3[var76] = var33;
               var3[var76 + 1] = var34;
               var3[var76 + 2] = var35;
               var3[var76 + 3] = var114;
               var3[var76 + 4] = var114;
               var3[var76 + 5] = 0.0F;
               var3[var76 + 6] = 4.0F;
               var3[var76 + 7] = Float.intBitsToFloat(Math.min(674915449 ^ 674915462, (int)(var108 * 255.0F + 0.5F)) << 24 | var18);
               var108 = (float)Math.exp((double)(-var112 / 0.08F)) * var9 * var10;
               var3[var76 + 8] = var33;
               var3[var76 + 9] = var34;
               var3[var76 + 10] = var35;
               var3[var76 + 11] = 0.35F * var6;
               var3[var76 + 12] = 0.35F * var6;
               var3[var76 + 13] = 0.0F;
               var3[var76 + 14] = 3.0F;
               var3[var76 + 15] = Float.intBitsToFloat(Math.min(-440103497 ^ -440103608, (int)(var108 * 255.0F + 0.5F)) << 24 | -226148257 ^ -226836576);
               RegionPassCache.nSB = var65 + 2;
            }

            float var115 = var112 / 0.5F;
            if (var115 < 1.0F) {
               var29 = 1.0F - var115;
               float var116 = 2.6F * var6 * (1.0F - var29 * var29 * var29 * var29) / 0.86F;
               var91 = (var115 - 0.2F) / 0.8F;
               var91 = var91 < 0.0F ? 0.0F : (var91 > 1.0F ? 1.0F : var91);
               float var119 = (1.0F - var91 * var91 * (3.0F - 2.0F * var91)) * var9 * var8;
               var65 = RegionPassCache.nSA;
               if (var65 < (1922124801 ^ 1922128897) && var119 > 0.002F) {
                  int var77 = var65 * 8;
                  var1[var77] = var11;
                  var1[var77 + 1] = var15;
                  var1[var77 + 2] = var13;
                  var1[var77 + 3] = var116;
                  var1[var77 + 4] = var116;
                  var1[var77 + 5] = 0.0F;
                  var1[var77 + 6] = 25.0F;
                  var1[var77 + 7] = Float.intBitsToFloat(Math.min(-397619563 ^ -397619606, (int)(0.9F * var119 * 255.0F + 0.5F)) << 24 | fx[6]);
                  RegionPassCache.nSA = var65 + 1;
               }

               var65 = RegionPassCache.nST;
               if (var65 < (-1911992983 ^ -1911994007) && var119 > 0.01F) {
                  int var78 = var65 * 8;
                  var2[var78] = var11;
                  var2[var78 + 1] = var15;
                  var2[var78 + 2] = var13;
                  var2[var78 + 3] = var116;
                  var2[var78 + 4] = var116;
                  var2[var78 + 5] = 0.0F;
                  var2[var78 + 6] = 25.0F;
                  var2[var78 + 7] = Float.intBitsToFloat(Math.min(-1060572265 ^ -1060572312, (int)(0.2F * var119 * 255.0F + 0.5F)) << 24 | var16);
                  RegionPassCache.nST = var65 + 1;
               }
            }

            float var117 = var112 / 0.8F;
            if (var117 < 1.0F && fl < 96) {
               var29 = 1.0F - var117;
               int var79 = fl * 16;
               fi[var79] = 0.0F;
               fi[var79 + 1] = var11;
               fi[var79 + 2] = var14 + 0.015F;
               fi[var79 + 3] = var13;
               fi[var79 + 10] = 3.6F * var6 * (1.0F - var29 * var29 * var29 * var29);
               fi[var79 + 11] = 0.55F;
               fi[var79 + 12] = (float)Math.pow((double)var29, 1.2) * Math.min(1.0F, var117 / 0.05F) * var8;
               fi[var79 + 13] = (float)fx[8];
               fi[var79 + 14] = 1.0F + 3.0F * var117;
               fi[var79 + 15] = 0.5F;
               fl++;
            }

            var91 = var112 / 0.04F;
            var91 = var91 > 1.0F ? 1.0F : var91;
            var29 = var91 * var91 * (3.0F - 2.0F * var91);
            var91 = (var112 - 0.15F) / 0.45F;
            var91 = var91 < 0.0F ? 0.0F : (var91 > 1.0F ? 1.0F : var91);
            float var120 = 0.7F * var29 * (1.0F - var91 * var91 * (3.0F - 2.0F * var91)) * var9 * var10;
            if (var120 > 0.002F) {
               var91 = var112 / 0.2F;
               float var122 = var91 >= 1.0F ? 1.0F : 1.0F - (float)Math.exp((double)(-6.931472F * var91));
               float var124 = 0.2F * var6;
               float var126 = RegionPassCache.rX;
               float var127 = RegionPassCache.rY;
               float var128 = RegionPassCache.rZ;
               float var129 = RegionPassCache.uX;
               float var130 = RegionPassCache.uY;
               float var131 = RegionPassCache.uZ;
               int var133 = Math.min(-863550754 ^ -863550943, (int)(var120 * 255.0F + 0.5F)) << 24;
               float var136 = Float.intBitsToFloat(var16);

               for (int var139 = 0; var139 < 12; var139++) {
                  var65 = RegionPassCache.nLB;
                  if (var65 >= (1303897249 ^ 1303897761)) {
                     break;
                  }

                  float var140 = (float) (Math.PI / 6) * (float)var139 + 0.3F;
                  float var141 = (float)Math.cos((double)var140);
                  float var142 = (float)Math.sin((double)var140);
                  float var143 = var126 * var141 + var129 * var142;
                  float var58 = var127 * var141 + var130 * var142;
                  float var59 = var128 * var141 + var131 * var142;
                  float var60 = var124 + (1.6F + 0.3F * (float)(var139 * 7 % 5)) * var6 * var122;
                  int var80 = var65 * 11;
                  var4[var80] = var33 + var143 * var124;
                  var4[var80 + 1] = var34 + var58 * var124;
                  var4[var80 + 2] = var35 + var59 * var124;
                  var4[var80 + 3] = var33 + var143 * var60;
                  var4[var80 + 4] = var34 + var58 * var60;
                  var4[var80 + 5] = var35 + var59 * var60;
                  var4[var80 + 6] = 0.18F * var6;
                  var4[var80 + 7] = 0.0F;
                  var4[var80 + 8] = Float.intBitsToFloat(var133 | ((var139 & 1) == 0 ? var18 : var16));
                  var4[var80 + 9] = var136;
                  var4[var80 + 10] = 2.0F;
                  RegionPassCache.nLB = var65 + 1;
               }
            }

            var91 = (var112 - 0.1F) / 0.15F;
            var91 = var91 < 0.0F ? 0.0F : (var91 > 1.0F ? 1.0F : var91);
            var29 = var91 * var91 * (3.0F - 2.0F * var91);
            var91 = (var112 - 0.7F) / 0.6F;
            var91 = var91 < 0.0F ? 0.0F : (var91 > 1.0F ? 1.0F : var91);
            float var110 = var29 * (1.0F - var91 * var91 * (3.0F - 2.0F * var91)) * var8;
            var65 = RegionPassCache.nSA;
            if (var65 < (-1819539150 ^ -1819535054) && var110 > 0.002F) {
               int var81 = var65 * 8;
               var1[var81] = var11;
               var1[var81 + 1] = var15;
               var1[var81 + 2] = var13;
               var1[var81 + 3] = 0.2F * var6;
               var1[var81 + 4] = 0.2F * var6;
               var1[var81 + 5] = (float) (Math.PI / 4) + var112;
               var1[var81 + 6] = 7.0F;
               var1[var81 + 7] = Float.intBitsToFloat(Math.min(-1885857220 ^ -1885857085, (int)(var110 * 255.0F + 0.5F)) << 24 | -873047746 ^ -888559935);
               RegionPassCache.nSA = var65 + 1;
            }
         }
      } catch (RuntimeException var61) {
         throw var61;
      }
   }

   private static void w(int var0) {

      assert var0 >= 0
         && var0 < 9
         && cp[var0] >= 0
         && cp[var0] <= (-1049389204 ^ -1049389108)
         && ea.length == (144796612 ^ 144797284)
         && eb.length == (-1012056419 ^ -1012057283)
         && ec.length == (1399993823 ^ 1399992447)
         && eq.length == (1562256519 ^ 1562255655)
         && ex.length == (-2028848648 ^ -2028848040)
         && ek.length == (-1735648465 ^ -1735647601)
         && er.length == (1976283420 ^ 1976284348)
         && eu.length == (607517021 ^ 607517949)
         && ed.length == (-1648407864 ^ -1648406680)
         && ee.length == (-675846765 ^ -675848141)
         && ef.length == (-608505344 ^ -608503904)
         && ei.length == (-714653699 ^ -714655139)
         && ej.length == (924332845 ^ 924333709)
         && RegionPassCache.SA.length == (-362037191 ^ -362069959)
         && RegionPassCache.ST.length == (1642383456 ^ 1642391648)
         && RegionPassCache.LA.length == (-1679204851 ^ -1679278579)
         && fx.length == 21
         && fy.length == 21;

      try {
         float[] var1 = RegionPassCache.SA;
         float[] var2 = RegionPassCache.ST;
         float[] var3 = RegionPassCache.LA;
         float var4 = cr[var0];
         float var5 = dg[var0];
         float var6 = (float)(cs[var0] - RegionPassCache.z);
         float var7 = (float)(ct[var0] - RegionPassCache.aa);
         float var8 = (float)(cu[var0] - RegionPassCache.ab);
         int var9 = ft;
         int var10 = fu;
         int var11 = fx[17];
         int var12 = cn[var0] == 3 ? -338785945 ^ -337337527 : fx[16];
         int var13 = var0 * (598888443 ^ 598888283);
         int var14 = var13 + cp[var0];

         for (int var17 = var13; var17 < var14; var17++) {
            int var18 = ea[var17];
            float var19 = var4 - eb[var17];
            float var20 = ec[var17];
            if (var18 != 1 && !(var19 < 0.0F) && !(var19 >= var20)) {
               float var21 = var19 / var20;
               float var22 = eg[var17];
               float var23 = eh[var17] / var22;
               boolean var31 = var19 >= eq[var17];
               boolean var32 = false;
               float var24;
               float var25;
               float var26;
               float var27;
               float var28;
               float var29;
               float var30;
               if (!var31) {
                  var24 = ek[var17];
                  var25 = el[var17];
                  var26 = em[var17];
                  var27 = en[var17];
                  var28 = eo[var17];
                  var29 = ep[var17];
                  var30 = var19;
               } else {
                  var24 = er[var17];
                  var25 = es[var17];
                  var26 = et[var17];
                  var27 = eu[var17];
                  var28 = ev[var17];
                  var29 = ew[var17];
                  var30 = var19 - eq[var17];
                  if (var19 >= ex[var17]) {
                     var30 = ex[var17] - eq[var17];
                     var32 = true;
                  }
               }

               float var33 = (float)Math.exp((double)(-var22 * var30));
               float var34 = (1.0F - var33) / var22;
               float var35 = var24 + var27 * var34;
               float var36 = var25 + var23 * var30 + (var28 - var23) * var34;
               float var37 = var26 + var29 * var34;
               if (var31 && var36 < var25) {
                  var36 = var25;
               }

               if (var32) {
                  var27 = 0.0F;
                  var28 = 0.0F;
                  var29 = 0.0F;
               } else {
                  var27 *= var33;
                  var28 = var23 + (var28 - var23) * var33;
                  var29 *= var33;
               }

               var35 += var6;
               var36 += var7;
               var37 += var8;
               float var38 = (float)Math.sqrt((double)(var27 * var27 + var28 * var28 + var29 * var29));
               float var39 = ei[var17];
               boolean var40 = var39 > 0.5F;
               int var41 = var40 ? var10 : var9;
               if (var18 == 0) {
                  float var42 = (var21 - 0.62F) / 0.38F;
                  var42 = var42 < 0.0F ? 0.0F : (var42 > 1.0F ? 1.0F : var42);
                  float var43 = Math.min(1.0F, var19 * 25.0F) * (1.0F - var42 * var42 * (3.0F - 2.0F * var42)) * var5;
                  float var44 = ed[var17] * (1.0F - 0.35F * var21 * var21);
                  float var45 = ee[var17] + ef[var17] * (1.0F - (float)Math.exp((double)(-1.5F * var19))) / 1.5F;
                  if (!(var43 < 0.002F)) {
                     int var15 = RegionPassCache.nST;
                     if (var15 < (801495491 ^ 801496515)) {
                        int var16 = var15 * 8;
                        var2[var16] = var35;
                        var2[var16 + 1] = var36;
                        var2[var16 + 2] = var37;
                        var2[var16 + 3] = 0.8F * var44;
                        var2[var16 + 4] = var44;
                        var2[var16 + 5] = var45;
                        var2[var16 + 6] = 6.0F;
                        var2[var16 + 7] = Float.intBitsToFloat(Math.min(-668131775 ^ -668131650, (int)(0.95F * var43 * 255.0F + 0.5F)) << 24 | fv);
                        RegionPassCache.nST = var15 + 1;
                     }

                     var15 = RegionPassCache.nSA;
                     if (var15 < (-1268157497 ^ -1268161593)) {
                        int var56 = var15 * 8;
                        var1[var56] = var35;
                        var1[var56 + 1] = var36;
                        var1[var56 + 2] = var37;
                        var1[var56 + 3] = 2.4F * var44;
                        var1[var56 + 4] = 2.4F * var44;
                        var1[var56 + 5] = 0.0F;
                        var1[var56 + 6] = 4.0F;
                        var1[var56 + 7] = Float.intBitsToFloat(Math.min(923814064 ^ 923813967, (int)(0.42F * var43 * 255.0F + 0.5F)) << 24 | var9);
                        RegionPassCache.nSA = var15 + 1;
                     }

                     var15 = RegionPassCache.nLA;
                     if (var38 > 2.5F && var15 < (-283003167 ^ -283011359)) {
                        float var46 = Math.min(0.45F, var38 * 0.03F) / var38;
                        int var57 = var15 * 11;
                        var3[var57] = var35;
                        var3[var57 + 1] = var36;
                        var3[var57 + 2] = var37;
                        var3[var57 + 3] = var35 - var27 * var46;
                        var3[var57 + 4] = var36 - var28 * var46;
                        var3[var57 + 5] = var37 - var29 * var46;
                        var3[var57 + 6] = 0.9F * var44;
                        var3[var57 + 7] = 0.0F;
                        var3[var57 + 8] = Float.intBitsToFloat(Math.min(133697662 ^ 133697665, (int)(0.45F * var43 * 255.0F + 0.5F)) << 24 | fx[8]);
                        var3[var57 + 9] = Float.intBitsToFloat(var9);
                        var3[var57 + 10] = 2.0F;
                        RegionPassCache.nLA = var15 + 1;
                     }
                  }
               } else if (var18 == 2 || var18 == 6) {
                  float var75 = (var21 - 0.45F) / 0.55F;
                  var75 = var75 < 0.0F ? 0.0F : (var75 > 1.0F ? 1.0F : var75);
                  float var81 = Math.min(1.0F, var19 * 33.0F) * (1.0F - var75 * var75 * (3.0F - 2.0F * var75)) * var5;
                  float var84 = ed[var17] * (1.0F - 0.5F * var21);
                  if (!(var81 < 0.002F)) {
                     int var54 = RegionPassCache.nLA;
                     if (var38 > 0.8F && var54 < (518028096 ^ 518019904)) {
                        float var88 = Math.min(0.6F, var38 * 0.035F) / var38;
                        int var60 = var54 * 11;
                        var3[var60] = var35;
                        var3[var60 + 1] = var36;
                        var3[var60 + 2] = var37;
                        var3[var60 + 3] = var35 - var27 * var88;
                        var3[var60 + 4] = var36 - var28 * var88;
                        var3[var60 + 5] = var37 - var29 * var88;
                        var3[var60 + 6] = 0.55F * var84;
                        var3[var60 + 7] = 0.1F * var84;
                        var3[var60 + 8] = Float.intBitsToFloat(Math.min(-420435293 ^ -420435364, (int)(0.9F * var81 * 255.0F + 0.5F)) << 24 | var11);
                        var3[var60 + 9] = Float.intBitsToFloat(var41);
                        var3[var60 + 10] = 1.0F;
                        RegionPassCache.nLA = var54 + 1;
                     }

                     var54 = RegionPassCache.nSA;
                     if (var54 < (1215042606 ^ 1215038510)) {
                        boolean var89 = var18 == 2;
                        int var61 = var54 * 8;
                        var1[var61] = var35;
                        var1[var61 + 1] = var36;
                        var1[var61 + 2] = var37;
                        var1[var61 + 3] = var89 ? var84 : 0.35F * var84;
                        var1[var61 + 4] = var89 ? var84 : 0.35F * var84;
                        var1[var61 + 5] = var89 ? ee[var17] + ef[var17] * var19 : 0.0F;
                        var1[var61 + 6] = var89 ? 7.0F : 3.0F;
                        var1[var61 + 7] = Float.intBitsToFloat(
                           Math.min(-1421831290 ^ -1421831303, (int)(var81 * 255.0F + 0.5F)) << 24
                              | (var89 ? (var40 ? fy[15] : fx[15]) : -1624054944 ^ -1613947745)
                        );
                        RegionPassCache.nSA = var54 + 1;
                     }
                  }
               } else if (var18 == 3) {
                  float var69 = (var21 - 0.55F) / 0.45F;
                  var69 = var69 < 0.0F ? 0.0F : (var69 > 1.0F ? 1.0F : var69);
                  float var77 = Math.min(1.0F, var19 * 12.0F)
                     * (1.0F - var69 * var69 * (3.0F - 2.0F * var69))
                     * (0.55F + 0.45F * (float)Math.sin((double)(17.0F * var19 + 40.0F * var39)))
                     * var5;
                  float var82 = ed[var17];
                  float var85 = var39 * 10.0F;
                  var85 -= (float)((int)var85);
                  if (!(var77 < 0.002F)) {
                     int var52 = RegionPassCache.nSA;
                     if (var52 + 1 < (46922032 ^ 46917936)) {
                        int var58 = var52 * 8;
                        var1[var58] = var35;
                        var1[var58 + 1] = var36;
                        var1[var58 + 2] = var37;
                        var1[var58 + 3] = var82;
                        var1[var58 + 4] = var82;
                        var1[var58 + 5] = 0.0F;
                        var1[var58 + 6] = 3.0F;
                        var1[var58 + 7] = Float.intBitsToFloat(
                           Math.min(1896291401 ^ 1896291510, (int)(var77 * 255.0F + 0.5F)) << 24 | (var40 ? fy[13] : fx[13])
                        );
                        if (var85 < 0.3F) {
                           var1[var58 + 8] = var35;
                           var1[var58 + 9] = var36;
                           var1[var58 + 10] = var37;
                           var1[var58 + 11] = 4.0F * var82;
                           var1[var58 + 12] = 4.0F * var82;
                           var1[var58 + 13] = 0.0F;
                           var1[var58 + 14] = 4.0F;
                           var1[var58 + 15] = Float.intBitsToFloat(Math.min(-187541203 ^ -187541038, (int)(0.35F * var77 * 255.0F + 0.5F)) << 24 | var41);
                           RegionPassCache.nSA = var52 + 2;
                        } else {
                           RegionPassCache.nSA = var52 + 1;
                        }
                     }
                  }
               } else {
                  float var71 = var21 / 0.12F;
                  var71 = var71 > 1.0F ? 1.0F : var71;
                  float var78 = var71 * var71 * (3.0F - 2.0F * var71);
                  var71 = (var21 - 0.45F) / 0.55F;
                  var71 = var71 < 0.0F ? 0.0F : (var71 > 1.0F ? 1.0F : var71);
                  var78 *= (1.0F - var71 * var71 * (3.0F - 2.0F * var71)) * var5;
                  float var83 = 1.0F - var21;
                  float var87 = ed[var17] * (1.0F + 1.1F * (1.0F - var83 * var83 * var83));
                  float var90 = ee[var17] + ef[var17] * var19;
                  boolean var47 = var18 == 4;
                  var78 *= var47 ? 0.34F * ej[var17] : 0.3F;
                  if (!(var78 < 0.002F)) {
                     float[] var48 = var47 ? var2 : var1;
                     int var53 = var47 ? RegionPassCache.nST : RegionPassCache.nSA;
                     if (var53 < (var47 ? 489557863 ^ 489556839 : -657500689 ^ -657504785)) {
                        int var59 = var53 * 8;
                        var48[var59] = var35;
                        var48[var59 + 1] = var36;
                        var48[var59 + 2] = var37;
                        var48[var59 + 3] = var87;
                        var48[var59 + 4] = var87;
                        var48[var59 + 5] = var90;
                        var48[var59 + 6] = 22.0F;
                        var48[var59 + 7] = Float.intBitsToFloat(Math.min(-751680682 ^ -751680599, (int)(var78 * 255.0F + 0.5F)) << 24 | (var47 ? var12 : var41));
                        if (var47) {
                           RegionPassCache.nST = var53 + 1;
                        } else {
                           RegionPassCache.nSA = var53 + 1;
                        }
                     }
                  }
               }
            }
         }
      } catch (RuntimeException var49) {
         throw var49;
      }
   }

   private static void x(int var0) {

      assert var0 >= 0
         && var0 < 9
         && cn[var0] == 2
         && cp[var0] <= (1847597137 ^ 1847597297)
         && ea.length == (186917748 ^ 186918612)
         && ey.length == (-1493131217 ^ -1493129841)
         && ez.length == (-632551494 ^ -632552934)
         && fa.length == (886422604 ^ 886421996)
         && eq.length == (1034544864 ^ 1034543936)
         && ex.length == (1301872066 ^ 1301870690)
         && ek.length == (-254862173 ^ -254863101)
         && er.length == (-1854367588 ^ -1854366404)
         && eu.length == (-1986809752 ^ -1986808376)
         && ee.length == (1290077012 ^ 1290077940)
         && ef.length == (1015032364 ^ 1015033740)
         && ed.length == (-1071914991 ^ -1071913551)
         && RegionPassCache.QT.length == (-442849745 ^ -442812881)
         && RegionPassCache.SA.length == (-844810218 ^ -844777450)
         && fx.length == 21;

      try {
         float[] var1 = RegionPassCache.QT;
         float[] var2 = RegionPassCache.SA;
         float var3 = cr[var0];
         float var4 = dg[var0];
         float var5 = (float)(cs[var0] - RegionPassCache.z);
         float var6 = (float)(ct[var0] - RegionPassCache.aa);
         float var7 = (float)(cu[var0] - RegionPassCache.ab);
         int var8 = ft;
         int var9 = fx[11];
         int var10 = var9 >> 16 & (-1596874381 ^ -1596874356);
         int var11 = var9 >> 8 & (2048523866 ^ 2048523941);
         int var12 = var9 & (-1931478018 ^ -1931478271);
         int var13 = var0 * (1088824474 ^ 1088824378);
         int var14 = var13 + cp[var0];

         for (int var17 = var13; var17 < var14; var17++) {
            float var18 = var3 - eb[var17];
            float var19 = ec[var17];
            if (ea[var17] == 1 && !(var18 < 0.0F) && !(var18 >= var19)) {
               float var20 = var18 / var19;
               float var21 = eg[var17];
               float var22 = eh[var17] / var21;
               boolean var30 = var18 >= eq[var17];
               float var23;
               float var24;
               float var25;
               float var26;
               float var27;
               float var28;
               float var29;
               if (!var30) {
                  var23 = ek[var17];
                  var24 = el[var17];
                  var25 = em[var17];
                  var26 = en[var17];
                  var27 = eo[var17];
                  var28 = ep[var17];
                  var29 = var18;
               } else {
                  var23 = er[var17];
                  var24 = es[var17];
                  var25 = et[var17];
                  var26 = eu[var17];
                  var27 = ev[var17];
                  var28 = ew[var17];
                  var29 = var18 >= ex[var17] ? ex[var17] - eq[var17] : var18 - eq[var17];
               }

               float var31 = (float)Math.exp((double)(-var21 * var29));
               float var32 = (1.0F - var31) / var21;
               float var33 = var5 + var23 + var26 * var32;
               float var34 = var24 + var22 * var29 + (var27 - var22) * var32;
               float var35 = var7 + var25 + var28 * var32;
               if (var30 && var34 < var24) {
                  var34 = var24;
               }

               var34 += var6;
               float var36 = (var20 - 0.68F) / 0.32F;
               var36 = var36 < 0.0F ? 0.0F : (var36 > 1.0F ? 1.0F : var36);
               float var37 = Math.min(1.0F, var18 * 30.0F) * (1.0F - var36 * var36 * (3.0F - 2.0F * var36)) * var4;
               if (!(var37 < 0.002F)) {
                  var36 = (var20 - 0.6F) / 0.4F;
                  var36 = var36 < 0.0F ? 0.0F : (var36 > 1.0F ? 1.0F : var36);
                  float var38 = ed[var17] * (1.0F - 0.25F * var36 * var36 * (3.0F - 2.0F * var36));
                  float var39 = 0.5F * var38;
                  float var40 = var18 < ex[var17] ? var18 : ex[var17];
                  float var41 = ee[var17] + ef[var17] * (1.0F - (float)Math.exp((double)(-1.1F * var40))) / 1.1F;
                  float var42 = (float)Math.cos((double)var41);
                  float var43 = (float)Math.sin((double)var41);
                  float var44 = 1.0F - var42;
                  float var45 = ey[var17];
                  float var46 = ez[var17];
                  float var47 = fa[var17];
                  float var48 = var42 + var45 * var45 * var44;
                  float var49 = var47 * var43 + var46 * var45 * var44;
                  float var50 = -var46 * var43 + var47 * var45 * var44;
                  float var51 = -var47 * var43 + var45 * var46 * var44;
                  float var52 = var42 + var46 * var46 * var44;
                  float var53 = var45 * var43 + var47 * var46 * var44;
                  float var54 = var49 * var53 - var50 * var52;
                  float var55 = var50 * var51 - var48 * var53;
                  float var56 = var48 * var52 - var49 * var51;
                  float var57 = (float)Math.sqrt((double)(var33 * var33 + var34 * var34 + var35 * var35));
                  var57 = var57 > 1.0E-4F ? 1.0F / var57 : 0.0F;
                  float var58 = -var33 * var57;
                  float var59 = -var34 * var57;
                  float var60 = -var35 * var57;
                  float var61 = Math.abs(var54 * 0.3208F + var55 * 0.9165F + var56 * -0.2395F);
                  float var62 = 0.3208F + var58;
                  float var63 = 0.9165F + var59;
                  float var64 = -0.2395F + var60;
                  float var65 = (float)Math.sqrt((double)(var62 * var62 + var63 * var63 + var64 * var64));
                  float var66 = var65 > 1.0E-6F ? Math.abs(var54 * var62 + var55 * var63 + var56 * var64) / var65 : 0.0F;
                  float var67 = Math.abs(var54 * var58 + var55 * var59 + var56 * var60);
                  float var68 = 0.78F + 0.3F * (0.62F + 0.38F * var61);
                  var36 = (var67 - 0.06F) / 0.19F;
                  var36 = var36 < 0.0F ? 0.0F : (var36 > 1.0F ? 1.0F : var36);
                  float var69 = 0.95F * var37 * var36 * var36 * (3.0F - 2.0F * var36);
                  int var15 = RegionPassCache.nQT;
                  if (var15 < (-875093425 ^ -875089329) && var69 > 0.002F) {
                     int var70 = Math.min(824430987 ^ 824430964, (int)((float)var10 * var68 + 0.5F)) << 16
                        | Math.min(-1386769660 ^ -1386769413, (int)((float)var11 * var68 + 0.5F)) << 8
                        | Math.min(-858846467 ^ -858846718, (int)((float)var12 * var68 + 0.5F));
                     float var71 = Float.intBitsToFloat(Math.min(1467721574 ^ 1467721625, (int)(var69 * 255.0F + 0.5F)) << 24 | var70);
                     float var72 = var48 * var39;
                     float var73 = var49 * var39;
                     float var74 = var50 * var39;
                     float var75 = var51 * var39;
                     float var76 = var52 * var39;
                     float var77 = var53 * var39;
                     int var16 = var15 * 25;
                     var1[var16] = var33 - var72 - var75;
                     var1[var16 + 1] = var34 - var73 - var76;
                     var1[var16 + 2] = var35 - var74 - var77;
                     var1[var16 + 3] = var33 - var72 + var75;
                     var1[var16 + 4] = var34 - var73 + var76;
                     var1[var16 + 5] = var35 - var74 + var77;
                     var1[var16 + 6] = var33 + var72 + var75;
                     var1[var16 + 7] = var34 + var73 + var76;
                     var1[var16 + 8] = var35 + var74 + var77;
                     var1[var16 + 9] = var33 + var72 - var75;
                     var1[var16 + 10] = var34 + var73 - var76;
                     var1[var16 + 11] = var35 + var74 - var77;
                     var1[var16 + 12] = 0.0F;
                     var1[var16 + 13] = 1.0F;
                     var1[var16 + 14] = 0.0F;
                     var1[var16 + 15] = 0.0F;
                     var1[var16 + 16] = 1.0F;
                     var1[var16 + 17] = 0.0F;
                     var1[var16 + 18] = 1.0F;
                     var1[var16 + 19] = 1.0F;
                     var1[var16 + 20] = 21.0F;
                     var1[var16 + 21] = var71;
                     var1[var16 + 22] = var71;
                     var1[var16 + 23] = var71;
                     var1[var16 + 24] = var71;
                     RegionPassCache.nQT = var15 + 1;
                  }

                  float var88 = var66 * var66;
                  float var89 = var88 * var88;
                  float var90 = var89 * var89;
                  float var91 = var90 * var90 * var90 * var89;
                  var15 = RegionPassCache.nSA;
                  if (var15 + 1 < (-1140240853 ^ -1140236757)) {
                     int var80 = var15 * 8;
                     var2[var80] = var33;
                     var2[var80 + 1] = var34;
                     var2[var80 + 2] = var35;
                     var2[var80 + 3] = 1.35F * var38;
                     var2[var80 + 4] = 1.35F * var38;
                     var2[var80 + 5] = 0.0F;
                     var2[var80 + 6] = 4.0F;
                     var2[var80 + 7] = Float.intBitsToFloat(Math.min(274220629 ^ 274220714, (int)(0.3F * var37 * 255.0F + 0.5F)) << 24 | var8);
                     if (var91 > 0.08F) {
                        float var92 = 0.55F * var38 * var91 + 0.02F;
                        var2[var80 + 8] = var33;
                        var2[var80 + 9] = var34;
                        var2[var80 + 10] = var35;
                        var2[var80 + 11] = var92;
                        var2[var80 + 12] = var92;
                        var2[var80 + 13] = 0.4F;
                        var2[var80 + 14] = 7.0F;
                        var2[var80 + 15] = Float.intBitsToFloat(
                           Math.min(-731612947 ^ -731613166, (int)(Math.min(1.0F, 1.3F * var91) * var37 * 255.0F + 0.5F)) << 24 | 1673096980 ^ 1665569003
                        );
                        RegionPassCache.nSA = var15 + 2;
                     } else {
                        RegionPassCache.nSA = var15 + 1;
                     }
                  }
               }
            }
         }
      } catch (RuntimeException var78) {
         throw var78;
      }
   }

   private static void y() {

      assert fk > 0
         && fk <= (732342910 ^ 732343166)
         && fj >= 0
         && fj <= (1879079249 ^ 1879077201)
         && fg.length == (429119533 ^ 429113389)
         && fh.length == (186693124 ^ 186695428)
         && fm.length == (-2053422337 ^ -2053422593)
         && fn.length == 15
         && fo.length == (2079766735 ^ 2079766543)
         && fp.length == 64
         && RegionPassCache.ac >= 1.0F
         && RegionPassCache.QT.length == (1086625663 ^ 1086654335)
         && RegionPassCache.QA.length == (426491818 ^ 426389418);

      try {
         float[] var0 = RegionPassCache.QT;
         float[] var1 = RegionPassCache.QA;
         float var2 = 5.681818F / RegionPassCache.ac;

         for (int var3 = 0; var3 < fk; var3++) {
            int var4 = var3 * 9;
            int var5 = (int)fh[var4];
            int var6 = (int)fh[var4 + 1];
            float var7 = fh[var4 + 2];
            float var8 = fh[var4 + 3];
            float var9 = fh[var4 + 4];
            float var10 = fh[var4 + 5];
            if (var6 >= 2 && var6 <= 64 && var5 >= 0 && var5 + var6 <= fj && (!(var9 <= 0.002F) || !(var10 <= 0.002F))) {
               int var11 = (int)fh[var4 + 6];
               int var12 = (int)fh[var4 + 7];
               boolean var13 = fh[var4 + 8] != 0.0F;
               float[] var14 = var13 ? var1 : var0;
               float var15 = 1.0F / (float)(var6 - 1);
               System.arraycopy(fg, var5 * 3, fo, 0, var6 * 3);

               for (int var16 = 0; var16 < 4; var16++) {
                  for (int var17 = 1; var17 < var6 - 1; var17++) {
                     int var18 = var17 * 3;
                     float var19 = fo[var18];
                     float var20 = fo[var18 + 1];
                     float var21 = fo[var18 + 2];
                     float var22 = (float)Math.sqrt((double)(var19 * var19 + var20 * var20 + var21 * var21));
                     float var23 = var22 > 1.0E-6F ? 1.0F / var22 : 0.0F;
                     float var24 = Math.max(var7 + (var8 - var7) * (float)var17 * var15, var2 * var22);
                     float var25 = var19 - fo[var18 - 3];
                     float var26 = var20 - fo[var18 - 2];
                     float var27 = var21 - fo[var18 - 1];
                     float var28 = fo[var18 + 3] - var19;
                     float var29 = fo[var18 + 4] - var20;
                     float var30 = fo[var18 + 5] - var21;
                     float var31 = (var25 * var19 + var26 * var20 + var27 * var21) * var23 * var23;
                     float var32 = (var28 * var19 + var29 * var20 + var30 * var21) * var23 * var23;
                     var25 -= var31 * var19;
                     var26 -= var31 * var20;
                     var27 -= var31 * var21;
                     var28 -= var32 * var19;
                     var29 -= var32 * var20;
                     var30 -= var32 * var21;
                     float var33 = var25 * var25 + var26 * var26 + var27 * var27;
                     float var34 = var28 * var28 + var29 * var29 + var30 * var30;
                     float var35 = var33 * var34;
                     float var36 = var35 > 1.0E-20F ? (var25 * var28 + var26 * var29 + var27 * var30) / (float)Math.sqrt((double)var35) : 1.0F;
                     float var37 = (float)Math.sqrt((double)Math.max(0.0F, 0.5F * (1.0F - var36)));
                     float var38 = (float)Math.sqrt((double)Math.max(0.0F, 0.5F * (1.0F + var36)));
                     float var39 = var24 * var37;
                     float var40 = (float)Math.sqrt((double)Math.min(var33, var34)) * var38;
                     if (var39 > var40) {
                        float var41 = var39 < 2.0F * var40 ? 0.25F * (var39 - var40) / var40 : 0.25F;
                        fo[var18] = var19 + var41 * (fo[var18 - 3] + fo[var18 + 3] - 2.0F * var19);
                        fo[var18 + 1] = var20 + var41 * (fo[var18 - 2] + fo[var18 + 4] - 2.0F * var20);
                        fo[var18 + 2] = var21 + var41 * (fo[var18 - 1] + fo[var18 + 5] - 2.0F * var21);
                     }
                  }
               }

               for (int var100 = 0; var100 < var6; var100++) {
                  int var102 = var100 * 3;
                  float var104 = fo[var102];
                  float var106 = fo[var102 + 1];
                  float var108 = fo[var102 + 2];
                  float var110 = 0.0F;
                  float var112 = 0.0F;
                  float var114 = 0.0F;
                  float var116 = 0.0F;
                  float var119 = 0.0F;
                  float var122 = 0.0F;
                  boolean var133 = false;
                  boolean var136 = false;
                  if (var100 > 0) {
                     float var139 = var104 - fo[var102 - 3];
                     float var143 = var106 - fo[var102 - 2];
                     float var147 = var108 - fo[var102 - 1];
                     var110 = var143 * var108 - var147 * var106;
                     var112 = var147 * var104 - var139 * var108;
                     var114 = var139 * var106 - var143 * var104;
                     float var125 = (float)Math.sqrt((double)(var110 * var110 + var112 * var112 + var114 * var114));
                     if (var125 > 1.0E-9F) {
                        var110 /= var125;
                        var112 /= var125;
                        var114 /= var125;
                        var133 = true;
                     }
                  }

                  if (var100 < var6 - 1) {
                     float var140 = fo[var102 + 3] - var104;
                     float var144 = fo[var102 + 4] - var106;
                     float var148 = fo[var102 + 5] - var108;
                     var116 = var144 * var108 - var148 * var106;
                     var119 = var148 * var104 - var140 * var108;
                     var122 = var140 * var106 - var144 * var104;
                     float var126 = (float)Math.sqrt((double)(var116 * var116 + var119 * var119 + var122 * var122));
                     if (var126 > 1.0E-9F) {
                        var116 /= var126;
                        var119 /= var126;
                        var122 /= var126;
                        var136 = true;
                     }
                  }

                  float var141 = (float)var100 * var15;
                  float var145 = var7 + (var8 - var7) * var141;
                  float var149 = var9 + (var10 - var9) * var141;
                  float var152 = (float)Math.sqrt((double)(var104 * var104 + var106 * var106 + var108 * var108));
                  float var153 = Math.max(var145, var2 * var152);
                  var149 = !(var145 > 0.0F) || !(var153 > 0.0F) || !var133 && !var136 ? 0.0F : var149 * var145 / var153;
                  int var154 = (int)(var149 * 255.0F + 0.5F);
                  var154 = var154 > (-1709070734 ^ -1709070707) ? -115515202 ^ -115515327 : (var154 < 0 ? 0 : var154);
                  fp[var100] = var154;
                  float var156 = 0.5F * var153;
                  float var157 = (var133 ? var110 : var116) * var156;
                  float var159 = (var133 ? var112 : var119) * var156;
                  float var161 = (var133 ? var114 : var122) * var156;
                  float var163 = -var157;
                  float var164 = -var159;
                  float var42 = -var161;
                  float var43 = var157;
                  float var44 = var159;
                  float var45 = var161;
                  float var46 = -var157;
                  float var47 = -var159;
                  float var48 = -var161;
                  float var49 = var157;
                  float var50 = var159;
                  float var51 = var161;
                  if (var133 && var136) {
                     float var52 = var110 + var116;
                     float var53 = var112 + var119;
                     float var54 = var114 + var122;
                     float var55 = (float)Math.sqrt((double)(var52 * var52 + var53 * var53 + var54 * var54));
                     float var56 = 0.5F * var55;
                     float var57 = var152 > 1.0E-6F ? 1.0F / var152 : 0.0F;
                     float var58 = fo[var102] - fo[var102 - 3];
                     float var59 = fo[var102 + 1] - fo[var102 - 2];
                     float var60 = fo[var102 + 2] - fo[var102 - 1];
                     float var61 = (var58 * var104 + var59 * var106 + var60 * var108) * var57;
                     float var62 = var58 * var58 + var59 * var59 + var60 * var60 - var61 * var61;
                     var58 = fo[var102 + 3] - var104;
                     var59 = fo[var102 + 4] - var106;
                     var60 = fo[var102 + 5] - var108;
                     var61 = (var58 * var104 + var59 * var106 + var60 * var108) * var57;
                     float var63 = var58 * var58 + var59 * var59 + var60 * var60 - var61 * var61;
                     float var64 = 1.0F - var56 * var56;
                     float var65 = var64 > 1.0E-6F ? 0.5F * (float)Math.sqrt((double)(Math.max(0.0F, Math.min(var62, var63)) / var64)) : 1.0E9F;
                     if (var56 >= 0.70710677F) {
                        float var170 = Math.min(var156 / var56, var65) / var55;
                        var157 = var52 * var170;
                        var159 = var53 * var170;
                        var161 = var54 * var170;
                        var163 = -var157;
                        var164 = -var159;
                        var42 = -var161;
                        var46 = -var157;
                        var47 = -var159;
                        var48 = -var161;
                        var43 = var157;
                        var44 = var159;
                        var45 = var161;
                        var49 = var157;
                        var50 = var159;
                        var51 = var161;
                     } else {
                        float var66 = fo[var102 + 3] - var104;
                        float var67 = fo[var102 + 4] - var106;
                        float var68 = fo[var102 + 5] - var108;
                        float var69 = var66 * var110 + var67 * var112 + var68 * var114 > 0.0F ? -1.0F : 1.0F;
                        float var70 = 0.0F;
                        float var71 = 0.0F;
                        float var72 = 0.0F;
                        if (var55 > 0.001F) {
                           float var73 = -var69 * Math.min(var156 * Math.min(1.0F / var56, 2.0F), var65) / var55;
                           var70 = var52 * var73;
                           var71 = var53 * var73;
                           var72 = var54 * var73;
                        }

                        float var171 = var69 * var110 * var156;
                        float var74 = var69 * var112 * var156;
                        float var75 = var69 * var114 * var156;
                        float var76 = var69 * var116 * var156;
                        float var77 = var69 * var119 * var156;
                        float var78 = var69 * var122 * var156;
                        if (var69 > 0.0F) {
                           var43 = var171;
                           var44 = var74;
                           var45 = var75;
                           var49 = var76;
                           var50 = var77;
                           var51 = var78;
                           var163 = var70;
                           var164 = var71;
                           var42 = var72;
                           var46 = var70;
                           var47 = var71;
                           var48 = var72;
                        } else {
                           var163 = var171;
                           var164 = var74;
                           var42 = var75;
                           var46 = var76;
                           var47 = var77;
                           var48 = var78;
                           var43 = var70;
                           var44 = var71;
                           var45 = var72;
                           var49 = var70;
                           var50 = var71;
                           var51 = var72;
                        }

                        if (var154 > 0) {
                           float var79;
                           float var80;
                           float var81;
                           if (var55 > 0.05F) {
                              var79 = var69 * var52 / var55;
                              var80 = var69 * var53 / var55;
                              var81 = var69 * var54 / var55;
                           } else {
                              var79 = var106 * var114 - var108 * var112;
                              var80 = var108 * var110 - var104 * var114;
                              var81 = var104 * var112 - var106 * var110;
                              float var127 = (float)Math.sqrt((double)(var79 * var79 + var80 * var80 + var81 * var81));
                              var127 = var127 > 1.0E-9F ? 1.0F / var127 : 0.0F;
                              var79 *= var127;
                              var80 *= var127;
                              var81 *= var127;
                           }

                           fn[0] = var69 * var110;
                           fn[1] = var69 * var112;
                           fn[2] = var69 * var114;
                           fn[6] = var79;
                           fn[7] = var80;
                           fn[8] = var81;
                           fn[12] = var69 * var116;
                           fn[13] = var69 * var119;
                           fn[14] = var69 * var122;

                           for (byte var82 = 3; var82 < 12; var82 += 6) {
                              float var83 = fn[var82 - 3] + fn[var82 + 3];
                              float var84 = fn[var82 - 2] + fn[var82 + 4];
                              float var85 = fn[var82 - 1] + fn[var82 + 5];
                              float var129 = (float)Math.sqrt((double)(var83 * var83 + var84 * var84 + var85 * var85));
                              var129 = var129 > 1.0E-9F ? 1.0F / var129 : 0.0F;
                              fn[var82] = var83 * var129;
                              fn[var82 + 1] = var84 * var129;
                              fn[var82 + 2] = var85 * var129;
                           }

                           float var175 = var156 * var57 * RegionPassCache.ac;
                           int var176 = var175 >= 12.0F ? 4 : (var175 >= 5.0F ? 2 : 1);
                           int var177 = 12 / var176;
                           float var178 = Float.intBitsToFloat(var154 << 24 | var11);
                           float var86 = var69 > 0.0F ? 1.0F : 0.0F;

                           for (int var87 = 0; var87 < var176 + 2; var87++) {
                              int var88 = var13 ? RegionPassCache.nQA : RegionPassCache.nQT;
                              if (var88 >= (var13 ? 1820661815 ^ 1820657719 : -1633918551 ^ -1633914455)) {
                                 break;
                              }

                              float var95 = var86;
                              float var96 = var86;
                              float var89;
                              float var90;
                              float var91;
                              float var92;
                              float var93;
                              float var94;
                              if (var87 < var176) {
                                 int var97 = var87 * var177;
                                 int var98 = var97 + var177;
                                 var89 = fn[var97] * var156;
                                 var90 = fn[var97 + 1] * var156;
                                 var91 = fn[var97 + 2] * var156;
                                 var92 = fn[var98] * var156;
                                 var93 = fn[var98 + 1] * var156;
                                 var94 = fn[var98 + 2] * var156;
                              } else if (var87 == var176) {
                                 var89 = var70;
                                 var90 = var71;
                                 var91 = var72;
                                 var95 = 1.0F - var86;
                                 var92 = var171;
                                 var93 = var74;
                                 var94 = var75;
                              } else {
                                 var89 = var76;
                                 var90 = var77;
                                 var91 = var78;
                                 var92 = var70;
                                 var93 = var71;
                                 var94 = var72;
                                 var96 = 1.0F - var86;
                              }

                              int var179 = var88 * 25;
                              var14[var179] = var104;
                              var14[var179 + 1] = var106;
                              var14[var179 + 2] = var108;
                              var14[var179 + 3] = var104;
                              var14[var179 + 4] = var106;
                              var14[var179 + 5] = var108;
                              var14[var179 + 6] = var104 + var89;
                              var14[var179 + 7] = var106 + var90;
                              var14[var179 + 8] = var108 + var91;
                              var14[var179 + 9] = var104 + var92;
                              var14[var179 + 10] = var106 + var93;
                              var14[var179 + 11] = var108 + var94;
                              var14[var179 + 12] = 0.5F;
                              var14[var179 + 13] = 0.5F;
                              var14[var179 + 14] = 0.5F;
                              var14[var179 + 15] = 0.5F;
                              var14[var179 + 16] = 0.5F;
                              var14[var179 + 17] = var95;
                              var14[var179 + 18] = 0.5F;
                              var14[var179 + 19] = var96;
                              var14[var179 + 20] = (float)var12;
                              var14[var179 + 21] = var178;
                              var14[var179 + 22] = var178;
                              var14[var179 + 23] = var178;
                              var14[var179 + 24] = var178;
                              if (var13) {
                                 RegionPassCache.nQA = var88 + 1;
                              } else {
                                 RegionPassCache.nQT = var88 + 1;
                              }
                           }
                        }
                     }
                  }

                  int var165 = var100 * 12;
                  fm[var165] = var163;
                  fm[var165 + 1] = var164;
                  fm[var165 + 2] = var42;
                  fm[var165 + 3] = var43;
                  fm[var165 + 4] = var44;
                  fm[var165 + 5] = var45;
                  fm[var165 + 6] = var46;
                  fm[var165 + 7] = var47;
                  fm[var165 + 8] = var48;
                  fm[var165 + 9] = var49;
                  fm[var165 + 10] = var50;
                  fm[var165 + 11] = var51;
               }

               for (int var101 = 0; var101 + 1 < var6; var101++) {
                  int var103 = fp[var101];
                  int var105 = fp[var101 + 1];
                  if ((var103 | var105) != 0) {
                     int var107 = var13 ? RegionPassCache.nQA : RegionPassCache.nQT;
                     if (var107 >= (var13 ? 633313290 ^ 633309194 : -1667928539 ^ -1667924443)) {
                        break;
                     }

                     int var109 = var101 * 3;
                     int var111 = var109 + 3;
                     int var113 = var107 * 25;
                     int var115 = var101 * 12;
                     int var117 = var115 + 12;
                     float var120 = fo[var109];
                     float var123 = fo[var109 + 1];
                     float var131 = fo[var109 + 2];
                     float var134 = fo[var111];
                     float var137 = fo[var111 + 1];
                     float var142 = fo[var111 + 2];
                     var14[var113] = var120 + fm[var115 + 6];
                     var14[var113 + 1] = var123 + fm[var115 + 7];
                     var14[var113 + 2] = var131 + fm[var115 + 8];
                     var14[var113 + 3] = var120 + fm[var115 + 9];
                     var14[var113 + 4] = var123 + fm[var115 + 10];
                     var14[var113 + 5] = var131 + fm[var115 + 11];
                     var14[var113 + 6] = var134 + fm[var117 + 3];
                     var14[var113 + 7] = var137 + fm[var117 + 4];
                     var14[var113 + 8] = var142 + fm[var117 + 5];
                     var14[var113 + 9] = var134 + fm[var117];
                     var14[var113 + 10] = var137 + fm[var117 + 1];
                     var14[var113 + 11] = var142 + fm[var117 + 2];
                     var14[var113 + 12] = 0.5F;
                     var14[var113 + 13] = 0.0F;
                     var14[var113 + 14] = 0.5F;
                     var14[var113 + 15] = 1.0F;
                     var14[var113 + 16] = 0.5F;
                     var14[var113 + 17] = 1.0F;
                     var14[var113 + 18] = 0.5F;
                     var14[var113 + 19] = 0.0F;
                     var14[var113 + 20] = (float)var12;
                     float var146 = Float.intBitsToFloat(var103 << 24 | var11);
                     float var151 = Float.intBitsToFloat(var105 << 24 | var11);
                     var14[var113 + 21] = var146;
                     var14[var113 + 22] = var146;
                     var14[var113 + 23] = var151;
                     var14[var113 + 24] = var151;
                     if (var13) {
                        RegionPassCache.nQA = var107 + 1;
                     } else {
                        RegionPassCache.nQT = var107 + 1;
                     }
                  }
               }
            }
         }
      } catch (RuntimeException var99) {
         throw var99;
      }
   }

   private static void z() {

      assert fl > 0
         && fl <= 96
         && fi.length == (-1542398375 ^ -1542399911)
         && fr.length == 33
         && fs.length == 33
         && fq.length == 33
         && gt.length == 5
         && gu.length == 5
         && gv.length == 5
         && gw.length == 5
         && gx.length == 5
         && RegionPassCache.QT.length == (1390499100 ^ 1390462236)
         && RegionPassCache.QA.length == (-169933744 ^ -169962416)
         && RegionPassCache.LT.length == (-652947777 ^ -652945217)
         && RegionPassCache.LA.length == (970435025 ^ 970377681);

      try {
         float[] var0 = RegionPassCache.QT;
         float[] var1 = RegionPassCache.QA;
         float[] var2 = RegionPassCache.LT;
         float[] var3 = RegionPassCache.LA;

         for (int var6 = 0; var6 < fl; var6++) {
            int var7 = var6 * 16;
            int var8 = (int)fi[var7];
            int var9 = (int)fi[var7 + 13];
            float var10 = fi[var7 + 1];
            float var11 = fi[var7 + 2];
            float var12 = fi[var7 + 3];
            float var13 = fi[var7 + 12];
            if (var8 == 2) {
               float var47 = fi[var7 + 4];
               float var48 = fi[var7 + 10];
               if (!(var48 < 0.004F) && !(var13 < 0.004F) && !(var47 <= var11)) {
                  int var49 = var9 >> 16 & (-290358507 ^ -290358294);
                  int var50 = var9 >> 8 & (334047387 ^ 334047332);
                  int var51 = var9 & (-2007259392 ^ -2007259137);
                  int var52 = (int)((float)var49 + (float)((1016903477 ^ 1016903626) - var49) * 0.25F + 0.5F) << 16
                     | (int)((float)var50 + (float)((-485335444 ^ -485335405) - var50) * 0.25F + 0.5F) << 8
                     | (int)((float)var51 + (float)((-1132114157 ^ -1132113940) - var51) * 0.25F + 0.5F);
                  int var54 = (int)((float)var49 + (float)((1204130268 ^ 1204130083) - var49) * 0.75F + 0.5F) << 16
                     | (int)((float)var50 + (float)((-2010294849 ^ -2010294976) - var50) * 0.75F + 0.5F) << 8
                     | (int)((float)var51 + (float)((-261875245 ^ -261875412) - var51) * 0.75F + 0.5F);

                  for (int var56 = 0; var56 < 4; var56++) {
                     float var58 = var11 + (var47 - var11) * gt[var56];
                     float var59 = var11 + (var47 - var11) * gt[var56 + 1];

                     for (int var60 = 0; var60 < 4; var60++) {
                        float[] var61 = var60 == 0 ? gu : (var60 == 1 ? gv : (var60 == 2 ? gw : gx));
                        float var62 = var61[var56] * var13;
                        float var63 = var61[var56 + 1] * var13;
                        boolean var64 = var60 == 0;
                        int var44 = var64 ? RegionPassCache.nLT : RegionPassCache.nLA;
                        if (var44 < (var64 ? -2093234722 ^ -2093234210 : 1220781402 ^ 1220773210) && (!(var62 < 0.002F) || !(var63 < 0.002F))) {
                           float var66 = var48 * (var60 == 0 ? 0.7F : (var60 == 1 ? 2.2F : (var60 == 2 ? 0.75F : 0.2F)));
                           int var68 = var60 == 2 ? var52 : (var60 == 3 ? var54 : var9);
                           float[] var71 = var64 ? var2 : var3;
                           int var46 = var44 * 11;
                           var71[var46] = var10;
                           var71[var46 + 1] = var58;
                           var71[var46 + 2] = var12;
                           var71[var46 + 3] = var10;
                           var71[var46 + 4] = var59;
                           var71[var46 + 5] = var12;
                           var71[var46 + 6] = var66;
                           var71[var46 + 7] = var66;
                           var71[var46 + 8] = Float.intBitsToFloat(Math.min(2121486380 ^ 2121486547, (int)(var62 * 255.0F + 0.5F)) << 24 | var68);
                           var71[var46 + 9] = Float.intBitsToFloat(Math.min(949154903 ^ 949154984, (int)(var63 * 255.0F + 0.5F)) << 24 | var68);
                           var71[var46 + 10] = var60 == 3 ? 1.0F : 2.0F;
                           if (var64) {
                              RegionPassCache.nLT = var44 + 1;
                           } else {
                              RegionPassCache.nLA = var44 + 1;
                           }
                        }
                     }
                  }
               }
            } else {
               float var14 = 1.0F;
               float var15 = 0.0F;
               float var16 = 0.0F;
               float var17 = 0.0F;
               float var18 = 0.0F;
               float var19 = 1.0F;
               if (var8 == 1 || var8 == 4) {
                  var14 = fi[var7 + 4];
                  var15 = fi[var7 + 5];
                  var16 = fi[var7 + 6];
                  var17 = fi[var7 + 7];
                  var18 = fi[var7 + 8];
                  var19 = fi[var7 + 9];
               }

               if (var8 != 3 && var8 != 4) {
                  float var53 = fi[var7 + 10];
                  float var55 = fi[var7 + 11];
                  float var57 = fi[var7 + 14];
                  float var23 = fi[var7 + 15];
                  if (!(var53 < 0.004F) && !(var13 < 0.004F)) {
                     float var24 = var53 / 0.9F;
                     float var25 = var55 * var24;
                     float var26 = 0.5F * var55;
                     float var27 = (float)Math.cos((double)var57);
                     float var28 = (float)Math.sin((double)var57);

                     for (int var29 = 0; var29 <= 32; var29++) {
                        float var30 = 1.0F;
                        if (var23 > 0.0F) {
                           float var31 = 0.5F + 0.5F * (fr[var29] * var27 + fs[var29] * var28);
                           var30 = 1.0F - var23 + var23 * (float)Math.pow(var31 > 0.0F ? (double)var31 : 0.0, 1.6);
                        }

                        int var69 = (int)(var13 * var30 * 255.0F + 0.5F);
                        fq[var29] = (var69 > (1050763431 ^ 1050763352) ? 1441340038 ^ 1441340025 : var69) << 24 | var9;
                     }

                     for (int var65 = 0; var65 < 32; var65++) {
                        int var43 = RegionPassCache.nQA;
                        if (var43 >= (769427218 ^ 769431314)) {
                           break;
                        }

                        float var67 = fr[var65];
                        float var70 = fs[var65];
                        float var32 = fr[var65 + 1];
                        float var33 = fs[var65 + 1];
                        float var34 = var14 * var67 + var17 * var70;
                        float var35 = var15 * var67 + var18 * var70;
                        float var36 = var16 * var67 + var19 * var70;
                        float var37 = var14 * var32 + var17 * var33;
                        float var38 = var15 * var32 + var18 * var33;
                        float var39 = var16 * var32 + var19 * var33;
                        int var45 = var43 * 25;
                        var1[var45] = var10 + var34 * var25;
                        var1[var45 + 1] = var11 + var35 * var25;
                        var1[var45 + 2] = var12 + var36 * var25;
                        var1[var45 + 3] = var10 + var37 * var25;
                        var1[var45 + 4] = var11 + var38 * var25;
                        var1[var45 + 5] = var12 + var39 * var25;
                        var1[var45 + 6] = var10 + var37 * var24;
                        var1[var45 + 7] = var11 + var38 * var24;
                        var1[var45 + 8] = var12 + var39 * var24;
                        var1[var45 + 9] = var10 + var34 * var24;
                        var1[var45 + 10] = var11 + var35 * var24;
                        var1[var45 + 11] = var12 + var36 * var24;
                        var1[var45 + 12] = 0.5F + var26 * var67;
                        var1[var45 + 13] = 0.5F + var26 * var70;
                        var1[var45 + 14] = 0.5F + var26 * var32;
                        var1[var45 + 15] = 0.5F + var26 * var33;
                        var1[var45 + 16] = 0.5F + 0.5F * var32;
                        var1[var45 + 17] = 0.5F + 0.5F * var33;
                        var1[var45 + 18] = 0.5F + 0.5F * var67;
                        var1[var45 + 19] = 0.5F + 0.5F * var70;
                        var1[var45 + 20] = 17.0F;
                        float var40 = Float.intBitsToFloat(fq[var65]);
                        float var41 = Float.intBitsToFloat(fq[var65 + 1]);
                        var1[var45 + 21] = var40;
                        var1[var45 + 22] = var41;
                        var1[var45 + 23] = var41;
                        var1[var45 + 24] = var40;
                        RegionPassCache.nQA = var43 + 1;
                     }
                  }
               } else if (!(var13 < 0.002F)) {
                  if (var8 == 3) {
                     var14 = fi[var7 + 10];
                     var19 = fi[var7 + 10];
                  }

                  boolean var20 = fi[var7 + 15] != 0.0F;
                  float[] var21 = var20 ? var1 : var0;
                  int var4 = var20 ? RegionPassCache.nQA : RegionPassCache.nQT;
                  if (var4 < (var20 ? -847255430 ^ -847251334 : -490572119 ^ -490576215)) {
                     float var22 = Float.intBitsToFloat(Math.min(419586337 ^ 419586526, (int)(var13 * 255.0F + 0.5F)) << 24 | var9);
                     int var5 = var4 * 25;
                     var21[var5] = var10 - var14 - var17;
                     var21[var5 + 1] = var11 - var15 - var18;
                     var21[var5 + 2] = var12 - var16 - var19;
                     var21[var5 + 3] = var10 + var14 - var17;
                     var21[var5 + 4] = var11 + var15 - var18;
                     var21[var5 + 5] = var12 + var16 - var19;
                     var21[var5 + 6] = var10 + var14 + var17;
                     var21[var5 + 7] = var11 + var15 + var18;
                     var21[var5 + 8] = var12 + var16 + var19;
                     var21[var5 + 9] = var10 - var14 + var17;
                     var21[var5 + 10] = var11 - var15 + var18;
                     var21[var5 + 11] = var12 - var16 + var19;
                     var21[var5 + 12] = 0.0F;
                     var21[var5 + 13] = 0.0F;
                     var21[var5 + 14] = 1.0F;
                     var21[var5 + 15] = 0.0F;
                     var21[var5 + 16] = 1.0F;
                     var21[var5 + 17] = 1.0F;
                     var21[var5 + 18] = 0.0F;
                     var21[var5 + 19] = 1.0F;
                     var21[var5 + 20] = fi[var7 + 11];
                     var21[var5 + 21] = var22;
                     var21[var5 + 22] = var22;
                     var21[var5 + 23] = var22;
                     var21[var5 + 24] = var22;
                     if (var20) {
                        RegionPassCache.nQA = var4 + 1;
                     } else {
                        RegionPassCache.nQT = var4 + 1;
                     }
                  }
               }
            }
         }
      } catch (RuntimeException var42) {
         throw var42;
      }
   }

   static {
      for (int var0 = 0; var0 <= 32; var0++) {
         double var1 = (Math.PI * 2) * (double)(var0 & 31) / 32.0;
         fr[var0] = (float)Math.cos(var1);
         fs[var0] = (float)Math.sin(var1);
      }

      for (int var3 = 0; var3 < 14; var3++) {
         double var4 = (Math.PI * 2) * (double)var3 / 14.0 + 0.21 * Math.sin((double)var3 * 7.3);
         hb[var3] = (float)Math.cos(var4);
         hc[var3] = (float)Math.sin(var4);
         hd[var3] = (float)(0.92 + 0.08 * Math.sin((double)var3 * 3.1));
      }

      hh = 1;
      hi = 1.6F;
      hj = -1.0F;
      hl = -1;
   }
}
