package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import java.util.List;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.BindingBridge;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.EntityPose;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.entity.Entity;
public final class HaloPassCache {
   private static final int s = 0;
   private static final int t = 1;
   private static final int u = 2;
   private static final int v = 3;
   private static final int w = 4;
   private static final int x = 19;
   private static final int y = 20;
   private static final float z = (float) (Math.PI * 2);
   private static final float aa = (float) Math.PI;
   private static final float ab = (float) (Math.PI / 2);
   private static final float ac = 14.0F;
   private static final float[] ad = new float[6];
   private static final float[] ae = new float[6];
   private static final float[] af = new float[]{0.95F, 1.1F, 1.25F, 1.18F, 1.0F, 0.8F};
   private static final float[] ag = new float[]{0.9F, 1.15F, 1.2F, 1.05F, 0.95F, 0.75F};
   public static final int WF = 59;
   public static final byte[] WF_R = new byte[59];
   public static final float[] WF_X = new float[59];
   public static final float[] WF_Y = new float[59];
   public static final float[] WF_L = new float[59];
   public static final float[] WF_W = new float[59];
   public static final float[] WF_DX = new float[59];
   public static final float[] WF_DY = new float[59];
   public static final float[] WF_A = new float[59];
   public static final float[] WB = new float[10];
   private static final float[] ah = new float[]{0.0F, 0.0F, 0.03F, 0.03F, 0.05F, 0.065F, 0.07F};
   private static final float[] ai = new float[14];
   private static final float[] aj = new float[21];
   private static final int[] ak = new int[]{0, 1, 5, 6, 1, 2, 4, 5, 2, 3, 3, 4};
   private static final int[] al = new int[]{0, 1, 1, 0, 1, 2, 2, 1, 2, 3, 3, 2};
   private static final float[] am = new float[12];
   private static final float[] an = new float[]{1.5F, 1.78F};
   private static final float[] ao = new float[]{0.1F, -0.12F};
   private static final double[] ap = new double[2];
   private static final double[] aq = new double[2];
   private static final double[] ar = new double[2];
   private static final double[] as = new double[2];
   private static final int at = 48;
   private static final float[] au = new float[49];
   private static final float[] av = new float[49];
   private static final float[] aw = new float[48];
   private static final float[] ax = new float[48];
   private static final float[] ay = new float[8];
   private static final float[] az = new float[12];
   private static final int ba = 150;
   private static final float[] bb = new float[150];
   private static final float[] bc = new float[150];
   private static final float[] bd = new float[150];
   private static final float[] be = new float[150];
   private static final float[] bf = new float[150];
   private static final float[] bg = new float[150];
   private static final float[] bh = new float[150];
   private static final float[] bi = new float[150];
   private static final int bj = 40;
   private static final float bk = 3.4F;
   private static final float bl = 7.85F;
   private static final float bm = 3.6F;
   private static final int bn = 12;
   private static final int bo = 7;
   private static final int bp = 4;
   private static final float[] bq = new float[24];
   private static final double[] br = new double[72];
   private static final float[] bs = new float[72];
   private static final float bt = 0.18F;
   private static final float bu = 0.22F;
   private static final int bv = 5;
   private static final int bw = 5;
   private static final LivingEntity[] bx;
   private static final boolean[] by;
   private static final boolean[] bz;
   private static final boolean[] ca;
   private static final float[] cb;
   private static final float[] cc;
   private static final float[] cd;
   private static final double[] ce;
   private static final double[] cf;
   private static final double[] cg;
   private static final float[] ch;
   private static final float[] ci;
   private static final float[] cj;
   private static final float[] ck;
   private static final float[] cl;
   private static final float[] cm;
   private static final float[] cn;
   private static final int co = 21;
   private static final int cp = 16;
   private static final int cq = 21;
   private static final PlayerEntity[] cr;
   private static final boolean[] cs;
   private static final float[] ct;
   private static final float[] cu;
   private static final float[] cv;
   private static final float[] cw;
   private static final float[] cx;
   private static final float[] cy;
   private static final float[] cz;
   private static final double[] da;
   private static final double[] db;
   private static final double[] dc;
   private static final PlayerEntity[] dd;
   private static final double[] de;
   private static boolean df;
   private static boolean dg;
   private static boolean dh;
   private static boolean di;
   private static boolean dj;
   private static boolean dk;
   private static final float[] dl;
   private static float dm;
   private static float dn;
   private static float _kwren_do;
   private static float dp;
   private static float dq;
   private static float dr;
   private static double ds;
   private static float dt;
   private static float du;
   private static float dv;
   private static final int dw = 7;
   private static final float[] dx;
   private static float dy;
   private static float dz;
   private static float ea;
   private static float eb;
   private static float ec;
   private static float ed;
   private static int ee;
   private static int ef;
   private static int eg;
   private static int eh;
   private static int ei;
   private static int ej;
   private static int ek;
   private static int el;
   private static int em;
   private static int en;
   private static int eo;
   private static double ep;
   private static int eq;
   private static int es = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   private HaloPassCache() {
   }

   public static void a() {

      MinecraftClient var0 = MinecraftClient.getInstance();
      if (var0.player != null && var0.world != null) {
         float var1 = RegionPassCache.dt;
         float var2 = 1.0F - (float)Math.exp((double)(-var1 * 10.0F));
         float var3 = 1.0F - (float)Math.exp((double)(-var1 * 14.0F));
         if (!df) {
            df = true;
            dm = RegionPassCache.am;
            dn = RegionPassCache.an;
            _kwren_do = RegionPassCache.ao;
            dp = RegionPassCache.ap;
            dq = RegionPassCache.au;
            dr = RegionPassCache.av;
         } else {
            dm = dm + (RegionPassCache.am - dm) * var2;
            dn = dn + (RegionPassCache.an - dn) * var2;
            _kwren_do = _kwren_do + (RegionPassCache.ao - _kwren_do) * var2;
            dp = dp + (RegionPassCache.ap - dp) * var2;
            dq = dq + (RegionPassCache.au - dq) * var2;
            dr = dr + (RegionPassCache.av - dr) * var2;
         }

         ds = ds + (double)(var1 * dn);
         float var4 = var1 / 0.18F;
         float var5 = var1 / 0.22F;
         boolean var6 = RegionPassCache.ah;
         dt = var6 ? Math.min(1.0F, dt + var4) : Math.max(0.0F, dt - var5);
         du = var6 && RegionPassCache.ai ? Math.min(1.0F, du + var4) : Math.max(0.0F, du - var5);
         int var7 = RegionPassCache.aj;
         if (var7 < 0 || var7 >= 7) {
            var7 = 0;
         }

         for (int var8 = 0; var8 < 7; var8++) {
            dx[var8] = var8 == var7 ? Math.min(1.0F, dx[var8] + var4) : Math.max(0.0F, dx[var8] - var5);
         }

         dv = RegionPassCache.ar ? Math.min(1.0F, dv + var4) : Math.max(0.0F, dv - var5);
         if (dt > 0.0F) {
            dg = true;
            int var16 = RegionPassCache.col(RegionPassCache.al);
            if (!di) {
               di = true;
               dy = (float)(var16 >> 16 & (-1492085643 ^ -1492085622));
               dz = (float)(var16 >> 8 & (344689983 ^ 344690112));
               ea = (float)(var16 & (1222014594 ^ 1222014589));
            } else {
               dy = dy + ((float)(var16 >> 16 & (-670141891 ^ -670141758)) - dy) * var3;
               dz = dz + ((float)(var16 >> 8 & (138157871 ^ 138158032)) - dz) * var3;
               ea = ea + ((float)(var16 & (356651667 ^ 356651628)) - ea) * var3;
            }

            int var9 = (int)(dy + 0.5F) << 16 | (int)(dz + 0.5F) << 8 | (int)(ea + 0.5F);
            if (var9 != ee || !dk) {
               b(var9);
            }

            int var10 = RegionPassCache.ak;
            LivingEntity var11 = null;
            if (var6 && var10 != 1) {
               var11 = RegionPassCache.aq;
            }

            if (var11 == var0.player) {
               var11 = null;
            }

            int var12 = -1;
            if (var11 != null) {
               for (int var13 = 1; var13 < 5; var13++) {
                  if (bx[var13] == var11) {
                     var12 = var13;
                  }
               }

               if (var12 < 0) {
                  float var23 = 3.0F;

                  for (int var14 = 1; var14 < 5; var14++) {
                     float var15 = bx[var14] == null && cb[var14] <= 0.0F ? -1.0F : cb[var14];
                     if (var15 < var23) {
                        var23 = var15;
                        var12 = var14;
                     }
                  }

                  d(var12, var11);
               }
            }

            for (int var24 = 1; var24 < 5; var24++) {
               by[var24] = var24 == var12;
            }

            boolean var25 = var6 && var10 != 0;
            by[0] = var25;
            if (var25 && bx[0] != var0.player) {
               d(0, var0.player);
            }

            for (int var27 = 0; var27 < 5; var27++) {
               if (bx[var27] != null || cb[var27] > 0.0F) {
                  f(var27, var0);
               }
            }
         } else if (dg) {
            dg = false;
            di = false;
            dk = false;

            for (int var17 = 0; var17 < 5; var17++) {
               bx[var17] = null;
               by[var17] = false;
               cb[var17] = 0.0F;
               ca[var17] = false;
            }
         }

         if (dv > 0.0F) {
            dh = true;
            int var18 = RegionPassCache.col(RegionPassCache.at);
            if (!dj) {
               dj = true;
               eb = (float)(var18 >> 16 & (1128692939 ^ 1128692788));
               ec = (float)(var18 >> 8 & (1317953190 ^ 1317953113));
               ed = (float)(var18 & (-1436692165 ^ -1436692028));
            } else {
               eb = eb + ((float)(var18 >> 16 & (419857844 ^ 419857739)) - eb) * var3;
               ec = ec + ((float)(var18 >> 8 & (-1744166887 ^ -1744166682)) - ec) * var3;
               ed = ed + ((float)(var18 & (337552045 ^ 337551954)) - ed) * var3;
            }

            int var20 = (int)(eb + 0.5F) << 16 | (int)(ec + 0.5F) << 8 | (int)(ed + 0.5F);
            if (var20 != eo) {
               c(var20);
            }

            cs[0] = true;
            if (cr[0] != var0.player) {
               m(0, var0.player);
            }

            int var21 = RegionPassCache.as;
            double var22 = RegionPassCache.now;
            if (var21 != eq || var22 >= ep || var22 < ep - 1.0) {
               eq = var21;
               ep = var22 + 0.25;
               n(var0, var21);
            }

            for (int var26 = 0; var26 < 21; var26++) {
               if (cr[var26] != null || ct[var26] > 0.0F) {
                  o(var26, var0);
               }
            }
         } else if (dh) {
            dh = false;
            dj = false;
            eq = -1;

            for (int var19 = 0; var19 < 21; var19++) {
               cr[var19] = null;
               cs[var19] = false;
               ct[var19] = 0.0F;
            }
         }
      }
   }

   private static void b(int var0) {

      dk = true;
      ee = var0;
      float var1 = (float)(var0 >> 16 & (-209635190 ^ -209635211));
      float var2 = (float)(var0 >> 8 & (1638161980 ^ 1638162115));
      float var3 = (float)(var0 & (-182272138 ^ -182272119));

      for (int var4 = 0; var4 < 4; var4++) {
         float var5 = dl[var4];
         int var6 = (int)(var1 + (255.0F - var1) * var5 + 0.5F) << 16
            | (int)(var2 + (255.0F - var2) * var5 + 0.5F) << 8
            | (int)(var3 + (255.0F - var3) * var5 + 0.5F);
         if (var4 == 0) {
            ef = var6;
         } else if (var4 == 1) {
            eg = var6;
         } else if (var4 == 2) {
            eh = var6;
         } else {
            ei = var6;
         }
      }

      int var10 = Math.max((int)var1, Math.max((int)var2, (int)var3));
      int var11 = Math.min((int)var1, Math.min((int)var2, (int)var3));
      float var12 = 0.5F * (1.0F - (var10 > 0 ? (float)(var10 - var11) / (float)var10 : 0.0F));
      float var7 = var1 + (160.0F - var1) * var12;
      float var8 = var2 + (120.0F - var2) * var12;
      float var9 = var3 + (255.0F - var3) * var12;
      ej = (int)(var7 + 0.5F) << 16 | (int)(var8 + 0.5F) << 8 | (int)(var9 + 0.5F);
      ek = (int)(var7 + (255.0F - var7) * 0.7F + 0.5F) << 16 | (int)(var8 + (255.0F - var8) * 0.7F + 0.5F) << 8 | (int)(var9 + (255.0F - var9) * 0.7F + 0.5F);
   }

   private static void c(int var0) {

      eo = var0;
      el = var0;
      int var1 = var0 >> 16 & (-1240923557 ^ -1240923484);
      int var2 = var0 >> 8 & (-1123693648 ^ -1123693745);
      int var3 = var0 & (-289260651 ^ -289260694);
      int var4 = Math.max(var1, Math.max(var2, var3));
      int var5 = Math.min(var1, Math.min(var2, var3));
      float var6 = var4 != 0 ? (float)(var4 - var5) / (float)var4 : 0.0F;
      float var7 = 0.0F;
      if (var6 != 0.0F) {
         float var8 = (float)(var4 - var5);
         float var9 = (float)(var4 - var1) / var8;
         float var10 = (float)(var4 - var2) / var8;
         float var11 = (float)(var4 - var3) / var8;
         var7 = var1 == var4 ? var11 - var10 : (var2 == var4 ? 2.0F + var9 - var11 : 4.0F + var10 - var9);
         var7 /= 6.0F;
         if (var7 < 0.0F) {
            var7++;
         }
      }

      float var24 = var6 > 0.02F ? 1.0F : 0.0F;

      for (int var25 = 0; var25 < 2; var25++) {
         float var26 = var25 == 0 ? var7 + 0.0066F : var7 - 0.035F;
         float var27 = var25 == 0 ? Math.min(1.0F, 1.25F * var6) : Math.min(1.0F, 1.35F * var6 + 0.1F * var24);
         float var12 = var25 == 0 ? 1.0F : 0.86F;
         float var13;
         float var14;
         float var15;
         if (var27 <= 0.0F) {
            var15 = var12;
            var14 = var12;
            var13 = var12;
         } else {
            float var16 = (var26 - (float)Math.floor((double)var26)) * 6.0F;
            float var17 = (float)Math.floor((double)var16);
            float var18 = var16 - var17;
            float var19 = var12 * (1.0F - var27);
            float var20 = var12 * (1.0F - var27 * var18);
            float var21 = var12 * (1.0F - var27 * (1.0F - var18));
            int var22 = (int)var17;
            if (var22 == 0) {
               var13 = var12;
               var14 = var21;
               var15 = var19;
            } else if (var22 == 1) {
               var13 = var20;
               var14 = var12;
               var15 = var19;
            } else if (var22 == 2) {
               var13 = var19;
               var14 = var12;
               var15 = var21;
            } else if (var22 == 3) {
               var13 = var19;
               var14 = var20;
               var15 = var12;
            } else if (var22 == 4) {
               var13 = var21;
               var14 = var19;
               var15 = var12;
            } else {
               var13 = var12;
               var14 = var19;
               var15 = var20;
            }
         }

         int var28 = (int)(var13 * 255.0F + 0.5F) << 16 | (int)(var14 * 255.0F + 0.5F) << 8 | (int)(var15 * 255.0F + 0.5F);
         if (var25 == 0) {
            em = var28;
         } else {
            en = var28;
         }
      }
   }

   private static void d(int var0, LivingEntity var1) {

      float var2 = RegionPassCache.td;
      bx[var0] = var1;
      cb[var0] = 0.0F;
      bz[var0] = false;
      ca[var0] = false;
      ce[var0] = MathHelper.lerp((double)var2, var1.lastRenderX, var1.getX());
      cf[var0] = MathHelper.lerp((double)var2, var1.lastRenderY, var1.getY());
      cg[var0] = MathHelper.lerp((double)var2, var1.lastRenderZ, var1.getZ());
      cd[var0] = Math.max(0.1F, var1.getHeight());
      cc[var0] = var1.getPose() != EntityPose.STANDING && var1.getPose() != EntityPose.CROUCHING ? 0.0F : 1.0F;
      ci[var0] = e(var1, var2);
      cj[var0] = var1.getPose() == EntityPose.CROUCHING ? cd[var0] * 1.2F : cd[var0];
      ck[var0] = Math.max(0.1F, var1.getWidth());
      cl[var0] = var1.isInSneakingPose() ? 1.0F : 0.0F;
      cm[var0] = cl[var0];
      cn[var0] = 0.0F;
   }

   private static float e(LivingEntity var0, float var1) {

      if (var0.getVehicle() instanceof LivingEntity var3) {
         float var4 = MathHelper.lerpAngleDegrees(var1, var3.lastBodyYaw, var3.bodyYaw);
         float var5 = MathHelper.lerpAngleDegrees(var1, var0.lastHeadYaw, var0.headYaw);
         float var6 = MathHelper.clamp(MathHelper.wrapDegrees(var5 - var4), -85.0F, 85.0F);
         float var7 = var5 - var6;
         if (Math.abs(var6) > 50.0F) {
            var7 += var6 * 0.2F;
         }

         return var7;
      } else {
         return MathHelper.lerpAngleDegrees(var1, var0.lastBodyYaw, var0.bodyYaw);
      }
   }

   private static void f(int var0, MinecraftClient var1) {

      assert var0 >= 0
         && var0 <= 5
         && bx.length == 6
         && by.length == 6
         && bz.length == 6
         && ca.length == 6
         && cb.length == 6
         && cc.length == 6
         && cd.length == 6
         && ce.length == 6
         && cf.length == 6
         && cg.length == 6
         && ch.length == 36
         && (var0 != 5 || RegionPassCache.PV)
         && an.length == 2
         && ao.length == 2
         && ap.length == 2
         && aq.length == 2
         && ar.length == 2
         && as.length == 2
         && dx.length == 7
         && RegionPassCache.SA.length == (-1324183852 ^ -1324216620)
         && ci.length == 6
         && cj.length == 6
         && ck.length == 6
         && cl.length == 6
         && cm.length == 6
         && cn.length == 6 : "espSlot: bad state";

      LivingEntity var2 = bx[var0];

      try {
         float var3 = RegionPassCache.dt;
         boolean var4 = false;
         boolean var5 = false;
         boolean var6 = false;
         boolean var7 = false;
         float var8 = cd[var0];
         if (var0 == 5) {
            var5 = true;
            var4 = true;
            var6 = true;
            bz[var0] = false;
            ce[var0] = RegionPassCache.pvX;
            cf[var0] = RegionPassCache.pvY;
            cg[var0] = RegionPassCache.pvZ;
            var8 = RegionPassCache.pvH;
            cd[var0] = var8;
            ci[var0] = RegionPassCache.bp;
            cj[var0] = var8;
            ck[var0] = 0.6F;
            cl[var0] = 0.0F;
            var7 = var1.player != null && !var1.player.getEquippedStack(EquipmentSlot.CHEST).isEmpty();
         } else if (var2 != null) {
            if (var2.isRemoved()) {
               bx[var0] = null;
            } else {
               var6 = true;
               float var9 = RegionPassCache.td;
               ce[var0] = MathHelper.lerp((double)var9, var2.lastRenderX, var2.getX());
               cf[var0] = MathHelper.lerp((double)var9, var2.lastRenderY, var2.getY());
               cg[var0] = MathHelper.lerp((double)var9, var2.lastRenderZ, var2.getZ());
               var8 = var2.getHeight();
               bz[var0] = var2.deathTime > 0 || var2.isDead();
               var4 = RegionPassCache.l(var2, false) && !var2.isSleeping();
               var5 = var2.getPose() == EntityPose.STANDING || var2.getPose() == EntityPose.CROUCHING;
               ci[var0] = e(var2, var9);
               if (var5) {
                  cl[var0] = var2.isInSneakingPose() ? 1.0F : 0.0F;
                  cj[var0] = Math.max(0.1F, var8) * (var2.getPose() == EntityPose.CROUCHING ? 1.2F : 1.0F);
                  ck[var0] = Math.max(0.1F, var2.getWidth());
               }

               var7 = !var2.getEquippedStack(EquipmentSlot.CHEST).isEmpty();
               if (!var4 && var2 == var1.getCameraEntity() && var1.options.getPerspective().isFirstPerson()) {
                  cb[var0] = 0.0F;
               }
            }
         }

         boolean var95 = by[var0] && var4 && !bz[var0];
         float var10 = cb[var0];
         var10 = var95 ? Math.min(1.0F, var10 + var3 / 0.18F) : Math.max(0.0F, var10 - var3 / (bz[var0] ? 0.4F : 0.3F));
         cb[var0] = var10;
         float var11 = cc[var0];
         if (var6) {
            var11 = var5 ? Math.min(1.0F, var11 + var3 / 0.15F) : Math.max(0.0F, var11 - var3 / 0.15F);
            cc[var0] = var11;
            float var12 = 1.0F - (float)Math.exp((double)(-var3 * 10.0F));
            if (var8 > 0.1F) {
               cd[var0] = cd[var0] + (var8 - cd[var0]) * var12;
            }

            float var13 = cm[var0];
            float var14 = var7 ? 0.075F : 0.02F;
            float var15 = cn[var0];
            cm[var0] = cl[var0] > 0.5F ? Math.min(1.0F, var13 + var3 / 0.2F) : Math.max(0.0F, var13 - var3 / 0.2F);
            cn[var0] = var15 > 0.0F ? var15 + (var14 - var15) * var12 : var14;
         }

         if (var10 <= 0.0F) {
            if (!by[var0]) {
               bx[var0] = null;
            }

            ca[var0] = false;
         } else {
            double var97 = ce[var0] - RegionPassCache.z;
            double var98 = cf[var0] - RegionPassCache.aa;
            double var16 = cg[var0] - RegionPassCache.ab;
            float var18 = cd[var0];
            double var19 = var98 + 0.5 * (double)var18;
            double var21 = Math.sqrt(var97 * var97 + var19 * var19 + var16 * var16);
            float var23 = (float)((64.0 - var21) / 8.0);
            var23 = var23 <= 0.0F ? 0.0F : (var23 >= 1.0F ? 1.0F : var23 * var23 * (3.0F - 2.0F * var23));
            float var24 = dt;
            float var25 = var10 * var10 * (3.0F - 2.0F * var10) * var24 * var24 * (3.0F - 2.0F * var24) * var23;
            if (var25 <= 0.002F) {
               ca[var0] = false;
            } else {
               float var26 = 1.0F - var10;
               float var27 = 0.85F + 0.15F * (1.0F - var26 * var26 * var26);
               float var28 = dm * Math.max(0.6F, Math.min(2.0F, var18 / 1.8F)) * var27;
               float var29 = dx[0];
               if (var29 > 0.0F) {
                  float var30 = 0.95F * var25 * var29 * var29 * (3.0F - 2.0F * var29);
                  float[] var31 = RegionPassCache.SA;
                  int var32 = RegionPassCache.nSA;
                  float var33 = RegionPassCache.rX;
                  float var34 = RegionPassCache.rY;
                  float var35 = RegionPassCache.rZ;
                  float var36 = RegionPassCache.uX;
                  float var37 = RegionPassCache.uY;
                  float var38 = RegionPassCache.uZ;
                  double var39 = ds;
                  double var41 = (Math.PI / 6) + (Math.PI / 18) * var39;
                  double var43 = Math.cos(var41);
                  double var45 = Math.sin(var41);
                  float var47 = 0.42F * var28;
                  float var48 = 0.21F * var28;
                  float var49 = 14.0F * var3;
                  boolean var50 = !ca[var0];
                  ca[var0] = true;
                  int var51 = ef;

                  for (int var52 = 0; var52 < 2; var52++) {
                     double var53 = ar[var52];
                     double var55 = as[var52];
                     double var57 = -var45 * var53;
                     double var59 = var55;
                     double var61 = var43 * var53;
                     double var63 = (double)(an[var52] * var28);
                     double var65 = var19 + (double)(ao[var52] * var28);

                     for (int var67 = 0; var67 < 3; var67++) {
                        double var68 = aq[var52] + (Math.PI * 2.0 / 3.0) * (double)var67 + ap[var52] * var39;
                        double var70 = Math.cos(var68);
                        double var72 = Math.sin(var68);
                        double var74 = var63 * (var70 * var43 + var72 * var57);
                        double var76 = var63 * var72 * var59;
                        double var78 = var63 * (var70 * var45 + var72 * var61);
                        double var80 = var97 + var74;
                        double var82 = var65 + var76;
                        double var84 = var16 + var78;
                        float var86 = (float)(var74 * (double)var33 + var76 * (double)var34 + var78 * (double)var35);
                        float var87 = (float)(var74 * (double)var36 + var76 * (double)var37 + var78 * (double)var38);
                        float var88 = (float)Math.atan2((double)var87, (double)var86) - (float) (Math.PI / 2);
                        int var89 = var0 * 6 + var52 * 3 + var67;
                        float var90;
                        if (var50) {
                           var90 = var88;
                        } else {
                           float var91 = var88 - ch[var89];
                           var91 -= (float) (Math.PI * 2) * (float)Math.floor((double)((var91 + (float) Math.PI) / (float) (Math.PI * 2)));
                           var91 = var91 > var49 ? var49 : (var91 < -var49 ? -var49 : var91);
                           var90 = ch[var89] + var91;
                           var90 -= (float) (Math.PI * 2) * (float)Math.floor((double)((var90 + (float) Math.PI) / (float) (Math.PI * 2)));
                        }

                        ch[var89] = var90;
                        float var123 = (float)((Math.sqrt(var80 * var80 + var82 * var82 + var84 * var84) - 0.6) / 1.0);
                        var123 = var123 <= 0.0F ? 0.0F : (var123 >= 1.0F ? 1.0F : var123 * var123 * (3.0F - 2.0F * var123));
                        float var92 = var30 * var123;
                        if (var92 > 0.002F && var32 < (-516027472 ^ -516023376)) {
                           int var93 = var32++ * 8;
                           var31[var93] = (float)var80;
                           var31[var93 + 1] = (float)var82;
                           var31[var93 + 2] = (float)var84;
                           var31[var93 + 3] = var47;
                           var31[var93 + 4] = var48;
                           var31[var93 + 5] = var90;
                           var31[var93 + 6] = 19.0F;
                           var31[var93 + 7] = Float.intBitsToFloat((int)(Math.min(1.0F, var92) * 255.0F + 0.5F) << 24 | var51);
                        }
                     }
                  }

                  RegionPassCache.nSA = var32;
               } else {
                  ca[var0] = false;
               }

               float var100 = (float)((var21 - 0.9) / 1.1);
               var100 = var100 <= 0.0F ? 0.0F : (var100 >= 1.0F ? 1.0F : var100 * var100 * (3.0F - 2.0F * var100));
               float var102 = var25 * var100;
               if (var102 > 0.002F) {
                  float var103 = dx[3];
                  float var105 = dx[4];
                  float var107 = dx[5];
                  float var109 = dx[6];
                  float var111 = ck[var0];
                  float var113 = dm * var27;
                  if (var103 > 0.0F) {
                     i(var97, var98, var16, var18, var111, var113, var102 * var103 * var103 * (3.0F - 2.0F * var103));
                  }

                  if (var105 > 0.0F) {
                     j(var97, var98, var16, var18, var111, var113, var102 * var105 * var105 * (3.0F - 2.0F * var105));
                  }

                  if (var107 > 0.0F) {
                     k(var97, var98, var16, var18, var111, var113, var102 * var107 * var107 * (3.0F - 2.0F * var107));
                  }

                  if (var109 > 0.0F) {
                     l(var0, var97, var98, var16, var18, var111, var113, var102 * var109 * var109 * (3.0F - 2.0F * var109));
                  }
               }

               float var104 = var25 * var11 * var11 * (3.0F - 2.0F * var11) * var100;
               if (!(var104 <= 0.002F)) {
                  float var106 = dx[1];
                  float var108 = dx[2];
                  float var110 = du;
                  if (var106 > 0.0F) {
                     g(var97, var98 + 0.55 * (double)var18, var16, var28, var104 * var106 * var106 * (3.0F - 2.0F * var106));
                  }

                  if (var108 > 0.0F) {
                     h(var0, var97, var98, var16, dm * var27, var104 * var108 * var108 * (3.0F - 2.0F * var108));
                  }

                  if (var110 > 0.0F && RegionPassCache.nSA < (-255945966 ^ -255950062)) {
                     float var112 = 0.8F * dp * var104 * var110 * var110 * (3.0F - 2.0F * var110);
                     if (var112 > 0.002F) {
                        double var114 = var97;
                        double var115 = var98 + 0.6 * (double)var18;
                        double var116 = var16;
                        double var117 = Math.sqrt(var97 * var97 + var115 * var115 + var16 * var16);
                        if (var117 > 1.0E-4) {
                           double var118 = Math.min(0.45, 0.4 * var117) / var117;
                           var114 = var97 - var97 * var118;
                           var115 -= var115 * var118;
                           var116 = var16 - var16 * var118;
                        }

                        float[] var119 = RegionPassCache.SA;
                        int var46 = RegionPassCache.nSA++ * 8;
                        var119[var46] = (float)var114;
                        var119[var46 + 1] = (float)var115;
                        var119[var46 + 2] = (float)var116;
                        var119[var46 + 3] = 0.8F * var28;
                        var119[var46 + 4] = 1.05F * var28;
                        var119[var46 + 5] = 0.0F;
                        var119[var46 + 6] = 4.0F;
                        var119[var46 + 7] = Float.intBitsToFloat((int)(Math.min(1.0F, var112) * 255.0F + 0.5F) << 24 | ef);
                     }
                  }
               }
            }
         }
      } catch (RuntimeException var94) {
         throw var94;
      }
   }

   private static void g(double var0, double var2, double var4, float var6, float var7) {

      assert !Double.isNaN(var0)
         && !Double.isNaN(var2)
         && !Double.isNaN(var4)
         && var6 >= 0.0F
         && var7 >= 0.0F
         && var7 <= 2.0F
         && ad.length == 6
         && ae.length == 6
         && af.length == 6
         && ag.length == 6
         && RegionPassCache.QT.length == (1619740145 ^ 1619711473)
         && RegionPassCache.LA.length == (-1425267574 ^ -1425193846)
         && RegionPassCache.SA.length == (-612861254 ^ -612828486) : "s" + "tar: bad st" + "a" + "te";

      try {
         double var8 = Math.sqrt(var0 * var0 + var2 * var2 + var4 * var4);
         if (var8 > 1.0E-4) {
            double var10 = Math.min(0.35 * (double)var6, 0.4 * var8) / var8;
            var0 -= var0 * var10;
            var2 -= var2 * var10;
            var4 -= var4 * var10;
         }

         float var69 = RegionPassCache.rX;
         float var11 = RegionPassCache.rY;
         float var12 = RegionPassCache.rZ;
         float var13 = RegionPassCache.uX;
         float var14 = RegionPassCache.uY;
         float var15 = RegionPassCache.uZ;
         float var16 = (float)var0;
         float var17 = (float)var2;
         float var18 = (float)var4;
         double var19 = ds;
         float var21 = 1.0F + 0.04F * (float)Math.sin((float) (Math.PI * 2) * var19 / 1.6);
         float var22 = Math.max(0.0F, _kwren_do);
         float var23 = Math.min(1.0F, 1.5F * var22) * var7;
         float var24 = 0.15F * var22 * var7;
         int var25 = (int)(Math.min(1.0F, var23) * 255.0F + 0.5F) << 24 | eh;
         int var26 = (int)(Math.min(1.0F, var24) * 255.0F + 0.5F) << 24 | ee;
         int var27 = (int)(Math.min(1.0F, 0.85F * var7) * 255.0F + 0.5F) << 24 | ef;
         int var28 = (int)(Math.min(1.0F, 0.55F * var7) * 255.0F + 0.5F) << 24 | ef;
         boolean var29 = var25 >>> 24 != 0 || var26 >>> 24 != 0;
         float var30 = Float.intBitsToFloat(var25);
         float var31 = Float.intBitsToFloat(var26);
         float var32 = Float.intBitsToFloat(var27);
         float var33 = Float.intBitsToFloat(var28);
         float var34 = 0.1F * var6;
         float var35 = 0.075F * var6;
         float var36 = 0.07F * var6;
         float var37 = 0.05F * var6;
         float var38 = 1.35F * var6 * var21;
         float[] var39 = RegionPassCache.QT;
         float[] var40 = RegionPassCache.LA;
         int var41 = RegionPassCache.nQT;
         int var42 = RegionPassCache.nLA;

         for (int var43 = 0; var43 < 2; var43++) {
            float var44 = var43 == 0 ? 1.0F : -1.0F;

            for (int var45 = 0; var45 < 6; var45++) {
               float var46 = (var43 == 0 ? af[var45] : ag[var45])
                  * var38
                  * (1.0F + 0.05F * (float)Math.sin((float) (Math.PI * 2) * (0.9 * var19 + 0.37 * (double)var45 + 0.21 * (double)var43)));
               float var47 = var44 * ad[var45];
               float var48 = ae[var45];
               float var49 = -var48;
               float var51 = var34 * var47 - var49 * var35;
               float var52 = var34 * var48 - var47 * var35;
               float var53 = var34 * var47 + var49 * var35;
               float var54 = var34 * var48 + var47 * var35;
               float var55 = var46 * var47;
               float var56 = var46 * var48;
               float var57 = var16 + var69 * var51 + var13 * var52;
               float var58 = var17 + var11 * var51 + var14 * var52;
               float var59 = var18 + var12 * var51 + var15 * var52;
               float var60 = var16 + var69 * var53 + var13 * var54;
               float var61 = var17 + var11 * var53 + var14 * var54;
               float var62 = var18 + var12 * var53 + var15 * var54;
               float var63 = var16 + var69 * var55 + var13 * var56;
               float var64 = var17 + var11 * var55 + var14 * var56;
               float var65 = var18 + var12 * var55 + var15 * var56;
               if (var29 && var41 < (2121808518 ^ 2121804422)) {
                  int var66 = var41++ * 25;
                  var39[var66] = var57;
                  var39[var66 + 1] = var58;
                  var39[var66 + 2] = var59;
                  var39[var66 + 3] = var60;
                  var39[var66 + 4] = var61;
                  var39[var66 + 5] = var62;
                  var39[var66 + 6] = var63;
                  var39[var66 + 7] = var64;
                  var39[var66 + 8] = var65;
                  var39[var66 + 9] = var63;
                  var39[var66 + 10] = var64;
                  var39[var66 + 11] = var65;

                  for (int var67 = 12; var67 < 20; var67++) {
                     var39[var66 + var67] = 0.5F;
                  }

                  var39[var66 + 20] = 0.0F;
                  var39[var66 + 21] = var30;
                  var39[var66 + 22] = var30;
                  var39[var66 + 23] = var31;
                  var39[var66 + 24] = var31;
               }

               for (int var73 = 0; var73 < 2; var73++) {
                  if (var42 < (-636057494 ^ -636049302)) {
                     int var74 = var42++ * 11;
                     var40[var74] = var73 == 0 ? var57 : var60;
                     var40[var74 + 1] = var73 == 0 ? var58 : var61;
                     var40[var74 + 2] = var73 == 0 ? var59 : var62;
                     var40[var74 + 3] = var63;
                     var40[var74 + 4] = var64;
                     var40[var74 + 5] = var65;
                     var40[var74 + 6] = var36;
                     var40[var74 + 7] = var37;
                     var40[var74 + 8] = var32;
                     var40[var74 + 9] = var33;
                     var40[var74 + 10] = 1.0F;
                  }
               }
            }
         }

         RegionPassCache.nQT = var41;
         RegionPassCache.nLA = var42;
         float var70 = 0.75F * dp * var7;
         if (var70 > 0.002F && RegionPassCache.nSA < (-491004271 ^ -491008367)) {
            float[] var71 = RegionPassCache.SA;
            int var72 = RegionPassCache.nSA++ * 8;
            var71[var72] = var16;
            var71[var72 + 1] = var17;
            var71[var72 + 2] = var18;
            var71[var72 + 3] = 0.75F * var6;
            var71[var72 + 4] = 0.75F * var6;
            var71[var72 + 5] = 0.0F;
            var71[var72 + 6] = 4.0F;
            var71[var72 + 7] = Float.intBitsToFloat((int)(Math.min(1.0F, var70) * 255.0F + 0.5F) << 24 | ei);
         }
      } catch (RuntimeException var68) {
         throw var68;
      }
   }

   private static void h(int var0, double var1, double var3, double var5, float var7, float var8) {

      assert var0 >= 0
         && var0 <= 5
         && !Double.isNaN(var1)
         && !Double.isNaN(var3)
         && !Double.isNaN(var5)
         && var7 >= 0.0F
         && var8 >= 0.0F
         && var8 <= 2.0F
         && WF_R.length == 59
         && WF_X.length == 59
         && WF_Y.length == 59
         && WF_L.length == 59
         && WF_W.length == 59
         && WF_DX.length == 59
         && WF_DY.length == 59
         && WB.length == 10
         && ai.length == 14
         && aj.length == 21
         && am.length == 12
         && ak.length == 12
         && al.length == 12
         && ay.length == 8
         && az.length == 12
         && ci.length == 6
         && cj.length == 6
         && ck.length == 6
         && cl.length == 6
         && cm.length == 6
         && cn.length == 6
         && RegionPassCache.QT.length == (1401412991 ^ 1401310591)
         && RegionPassCache.LA.length == (-261898824 ^ -261956168)
         && RegionPassCache.SA.length == (836362217 ^ 836329449) : "wings: bad state";

      try {
         float var9 = cj[var0];
         float var10 = ck[var0];
         float var11 = cl[var0];
         float var12 = cm[var0];
         var12 = var12 * var12 * (3.0F - 2.0F * var12);
         float var13 = (var10 / var9 - 0.45F) * 2.5F;
         var13 = var13 <= 0.0F ? 0.0F : (var13 >= 1.0F ? 1.0F : var13);
         float var14 = var7 * Math.max(0.6F, Math.min(2.0F, var9 / 1.8F));
         double var15 = Math.toRadians((double)ci[var0]);
         double var17 = 0.5 * (double)var11 + 1.2 * (double)var13;
         float var19 = (float)Math.sin(var15);
         float var20 = (float)Math.cos(var15);
         float var21 = (float)Math.sin(var17);
         float var22 = (float)Math.cos(var17);
         float var23 = -var19 * var21;
         float var24 = var22;
         float var25 = var20 * var21;
         float var26 = var19 * var22;
         float var27 = var21;
         float var28 = -var20 * var22;
         float var29 = -var20;
         float var30 = -var19;
         float var31 = var9 * (0.7333F - 0.1367F * var11 + 0.2F * var13);
         float var32 = var10 * (0.195F + 0.047F * var11) * (1.0F - var13);
         float var33 = cn[var0] * var9 / 1.8F;
         float var34 = (float)var1 + var19 * var32 + var26 * var33;
         float var35 = (float)var3 + var31 + var21 * var33;
         float var36 = (float)var5 - var20 * var32 + var28 * var33;
         double var37 = 4.71238911151886 * ds;
         float var39 = 1.0F - 0.6F * var12;
         float var40 = 0.38F + 0.8F * var12 - 0.16F * var39 * (float)Math.sin(var37);
         float var41 = 0.2F - 0.55F * var12 + 0.08F * var39 * (float)Math.sin(var37 - 0.3);
         float var42 = 0.13F + 0.06F * var39 * (float)Math.cos(var37);
         float var43 = 1.0F - 0.2F * var12;
         float var44 = 1.0F + 0.12F * (float)Math.sin(var37 + 1.1);
         float var45 = (float)Math.cos((double)var40);
         float var46 = (float)Math.sin((double)var40);
         float var47 = (float)Math.cos((double)var41);
         float var48 = (float)Math.sin((double)var41);
         float var49 = (0.22F + 0.78F * Math.max(0.0F, _kwren_do)) * var44 * var8;
         boolean var50 = var49 > 0.004F;
         float[] var51 = am;
         var51[0] = Float.intBitsToFloat((int)(Math.min(1.0F, var49) * 255.0F + 0.5F) << 24 | ee);
         var51[1] = Float.intBitsToFloat((int)(Math.min(1.0F, 0.9F * var49) * 255.0F + 0.5F) << 24 | ee);
         var51[2] = Float.intBitsToFloat((int)(Math.min(1.0F, 0.7F * var49) * 255.0F + 0.5F) << 24 | eg);
         var51[3] = Float.intBitsToFloat((int)(Math.min(1.0F, 0.5F * var49) * 255.0F + 0.5F) << 24 | eg);
         var51[4] = Float.intBitsToFloat((int)(Math.min(1.0F, 1.1F * var49) * 255.0F + 0.5F) << 24 | eg);
         var51[5] = Float.intBitsToFloat((int)(Math.min(1.0F, var49) * 255.0F + 0.5F) << 24 | eg);
         var51[6] = Float.intBitsToFloat((int)(Math.min(1.0F, 0.85F * var49) * 255.0F + 0.5F) << 24 | eh);
         var51[7] = Float.intBitsToFloat((int)(Math.min(1.0F, 0.7F * var49) * 255.0F + 0.5F) << 24 | eh);
         var51[8] = Float.intBitsToFloat((int)(Math.min(1.0F, 1.2F * var49) * 255.0F + 0.5F) << 24 | eh);
         var51[9] = Float.intBitsToFloat((int)(Math.min(1.0F, 1.1F * var49) * 255.0F + 0.5F) << 24 | eh);
         var51[10] = Float.intBitsToFloat((int)(Math.min(1.0F, 0.95F * var49) * 255.0F + 0.5F) << 24 | ei);
         var51[11] = Float.intBitsToFloat((int)(Math.min(1.0F, 0.8F * var49) * 255.0F + 0.5F) << 24 | ei);
         float var52 = 0.1F * var39 * (float)Math.sin(var37 + 0.4);
         float var53 = (float)Math.sqrt((double)(var34 * var34 + var35 * var35 + var36 * var36));
         float var54 = var53 > 1.0E-4F ? 1.0F / var53 : 0.0F;
         float var55 = 0.02F * var14;
         float var56 = 0.015F * var14;
         float var57 = 0.26F * dp * var8;
         float[] var58 = RegionPassCache.QT;
         float[] var59 = RegionPassCache.LA;
         float[] var60 = ai;
         float[] var61 = aj;
         int var62 = RegionPassCache.nQT;
         int var63 = RegionPassCache.nLA;

         for (int var64 = 0; var64 < 2; var64++) {
            float var65 = var64 == 0 ? 1.0F : -1.0F;
            float var66 = var65 * var29;
            float var67 = var65 * var30;
            float var68 = var66 * var45 + var26 * var46;
            float var69 = var27 * var46;
            float var70 = var67 * var45 + var28 * var46;
            float var71 = var26 * var45 - var66 * var46;
            float var72 = var27 * var45;
            float var73 = var28 * var45 - var67 * var46;
            float var74 = (var68 * var47 + var23 * var48) * var14;
            float var75 = (var69 * var47 + var24 * var48) * var14;
            float var76 = (var70 * var47 + var25 * var48) * var14;
            float var77 = (var23 * var47 - var68 * var48) * var14;
            float var78 = (var24 * var47 - var69 * var48) * var14;
            float var79 = (var25 * var47 - var70 * var48) * var14;
            float var80 = (0.55F + 0.45F * Math.abs((var71 * var34 + var72 * var35 + var73 * var36) * var54)) * var8;
            var71 *= var14;
            var72 *= var14;
            var73 *= var14;
            float var81 = Float.intBitsToFloat((int)(Math.min(1.0F, 0.45F * var80) * 255.0F + 0.5F) << 24 | eg);
            float var82 = Float.intBitsToFloat((int)(Math.min(1.0F, 0.7F * var80) * 255.0F + 0.5F) << 24 | ei);
            float var83 = Float.intBitsToFloat((int)(Math.min(1.0F, 0.32F * var80) * 255.0F + 0.5F) << 24 | eh);
            float var84 = Float.intBitsToFloat((int)(Math.min(1.0F, 0.5F * var80) * 255.0F + 0.5F) << 24 | eh);
            float var85 = Float.intBitsToFloat((int)(Math.min(1.0F, 0.85F * var80) * 255.0F + 0.5F) << 24 | ei);

            for (int var86 = 0; var86 < 59; var86++) {
               byte var87 = WF_R[var86];
               boolean var88 = var87 <= 1;
               float var89 = WF_X[var86];
               float var90 = WF_Y[var86];
               float var91 = WF_L[var86];
               float var92 = WF_W[var86];
               float var93 = WF_DX[var86];
               float var94 = WF_DY[var86];
               if (var87 == 1 && var52 != 0.0F) {
                  float var95 = WF_A[var86] + var52 * (float)(var86 - 9) / 9.0F;
                  var93 = (float)Math.cos((double)var95);
                  var94 = (float)Math.sin((double)var95);
               }

               float var133 = -var94;
               float var97 = var88 ? var92 * 0.62F : var92 * 0.9F;
               float var99 = var88 ? 0.45F : 0.5F;
               float var100 = var88 ? 0.93F : 0.88F;
               var60[0] = var89 + var133 * var97 * 0.3F;
               var60[1] = var90 + var93 * var97 * 0.3F;
               var60[2] = var89 + var93 * var91 * var99 + var133 * var97;
               var60[3] = var90 + var94 * var91 * var99 + var93 * var97;
               var60[4] = var89 + var93 * var91 * var100 + var133 * var97 * 0.55F;
               var60[5] = var90 + var94 * var91 * var100 + var93 * var97 * 0.55F;
               var60[6] = var89 + var93 * var91;
               var60[7] = var90 + var94 * var91;
               var60[8] = var89 + var93 * var91 * var100 - var133 * var92 * 0.55F;
               var60[9] = var90 + var94 * var91 * var100 - var93 * var92 * 0.55F;
               var60[10] = var89 + var93 * var91 * var99 - var133 * var92;
               var60[11] = var90 + var94 * var91 * var99 - var93 * var92;
               var60[12] = var89 - var133 * var92 * 0.3F;
               var60[13] = var90 - var93 * var92 * 0.3F;
               float var101 = ah[var87];

               for (int var102 = 0; var102 < 7; var102++) {
                  float var103 = var60[var102 * 2] * var43;
                  float var104 = var60[var102 * 2 + 1];
                  float var105 = var101 + var42 * var103 * var103 - 0.04F * var104;
                  var61[var102 * 3] = var34 + var74 * var103 + var77 * var104 + var71 * var105;
                  var61[var102 * 3 + 1] = var35 + var75 * var103 + var78 * var104 + var72 * var105;
                  var61[var102 * 3 + 2] = var36 + var76 * var103 + var79 * var104 + var73 * var105;
               }

               if (var50) {
                  int var134 = var87 <= 1 ? 0 : (var87 <= 3 ? 4 : 8);

                  for (int var136 = 0; var136 < 3 && var62 < (-1581601594 ^ -1581597498); var136++) {
                     int var138 = var62++ * 25;

                     for (int var140 = 0; var140 < 4; var140++) {
                        int var106 = ak[var136 * 4 + var140] * 3;
                        var58[var138 + var140 * 3] = var61[var106];
                        var58[var138 + var140 * 3 + 1] = var61[var106 + 1];
                        var58[var138 + var140 * 3 + 2] = var61[var106 + 2];
                        var58[var138 + 21 + var140] = var51[var134 + al[var136 * 4 + var140]];
                     }

                     for (int var141 = 12; var141 < 20; var141++) {
                        var58[var138 + var141] = 0.5F;
                     }

                     var58[var138 + 20] = 0.0F;
                  }
               }

               float var135 = var88 ? var55 : var56;
               float var137 = var88 ? var81 : var83;
               float var139 = var88 ? var82 : var84;
               if (var63 < (874763864 ^ 874772056)) {
                  int var142 = var63++ * 11;
                  float var144 = var89 * var43;
                  float var107 = var101 + 0.004F + var42 * var144 * var144 - 0.04F * var90;
                  float var108 = (var89 + var93 * var91 * 0.9F) * var43;
                  float var109 = var90 + var94 * var91 * 0.9F;
                  float var110 = var101 + 0.004F + var42 * var108 * var108 - 0.04F * var109;
                  var59[var142] = var34 + var74 * var144 + var77 * var90 + var71 * var107;
                  var59[var142 + 1] = var35 + var75 * var144 + var78 * var90 + var72 * var107;
                  var59[var142 + 2] = var36 + var76 * var144 + var79 * var90 + var73 * var107;
                  var59[var142 + 3] = var34 + var74 * var108 + var77 * var109 + var71 * var110;
                  var59[var142 + 4] = var35 + var75 * var108 + var78 * var109 + var72 * var110;
                  var59[var142 + 5] = var36 + var76 * var108 + var79 * var109 + var73 * var110;
                  var59[var142 + 6] = var135 * 1.1F;
                  var59[var142 + 7] = var135 * 0.5F;
                  var59[var142 + 8] = var139;
                  var59[var142 + 9] = var139;
                  var59[var142 + 10] = 1.0F;
               }

               for (int var143 = var88 ? 1 : 2; var143 < (var88 ? 5 : 4); var143++) {
                  if (var63 < (1443774119 ^ 1443765927)) {
                     int var145 = var63++ * 11;
                     int var146 = var143 * 3;
                     int var147 = (var143 + 1) * 3;
                     var59[var145] = var61[var146];
                     var59[var145 + 1] = var61[var146 + 1];
                     var59[var145 + 2] = var61[var146 + 2];
                     var59[var145 + 3] = var61[var147];
                     var59[var145 + 4] = var61[var147 + 1];
                     var59[var145 + 5] = var61[var147 + 2];
                     var59[var145 + 6] = var135;
                     var59[var145 + 7] = var135;
                     var59[var145 + 8] = var137;
                     var59[var145 + 9] = var137;
                     var59[var145 + 10] = 1.0F;
                  }
               }
            }

            for (int var120 = 0; var120 < 4; var120++) {
               if (var63 < (348255522 ^ 348247330)) {
                  float var122 = WB[var120 * 2] * var43;
                  float var124 = WB[var120 * 2 + 1];
                  float var126 = WB[var120 * 2 + 2] * var43;
                  float var128 = WB[var120 * 2 + 3];
                  float var130 = 0.02F + var42 * var122 * var122 - 0.04F * var124;
                  float var131 = 0.02F + var42 * var126 * var126 - 0.04F * var128;
                  int var132 = var63++ * 11;
                  var59[var132] = var34 + var74 * var122 + var77 * var124 + var71 * var130;
                  var59[var132 + 1] = var35 + var75 * var122 + var78 * var124 + var72 * var130;
                  var59[var132 + 2] = var36 + var76 * var122 + var79 * var124 + var73 * var130;
                  var59[var132 + 3] = var34 + var74 * var126 + var77 * var128 + var71 * var131;
                  var59[var132 + 4] = var35 + var75 * var126 + var78 * var128 + var72 * var131;
                  var59[var132 + 5] = var36 + var76 * var126 + var79 * var128 + var73 * var131;
                  var59[var132 + 6] = (0.05F - 0.008F * (float)var120) * var14;
                  var59[var132 + 7] = (0.042F - 0.008F * (float)var120) * var14;
                  var59[var132 + 8] = var85;
                  var59[var132 + 9] = var85;
                  var59[var132 + 10] = 1.0F;
               }
            }

            if (var57 > 0.002F && RegionPassCache.nSA < (830964349 ^ 830968445)) {
               float var121 = 0.42F * var43;
               float var123 = -0.12F;
               float var125 = var42 * var121 * var121 - 0.04F * var123;
               float[] var127 = RegionPassCache.SA;
               int var129 = RegionPassCache.nSA++ * 8;
               var127[var129] = var34 + var74 * var121 + var77 * var123 + var71 * var125;
               var127[var129 + 1] = var35 + var75 * var121 + var78 * var123 + var72 * var125;
               var127[var129 + 2] = var36 + var76 * var121 + var79 * var123 + var73 * var125;
               var127[var129 + 3] = 0.62F * var14;
               var127[var129 + 4] = 0.62F * var14;
               var127[var129 + 5] = 0.0F;
               var127[var129 + 6] = 4.0F;
               var127[var129 + 7] = Float.intBitsToFloat((int)(Math.min(1.0F, var57) * 255.0F + 0.5F) << 24 | ee);
            }
         }

         RegionPassCache.nQT = var62;
         RegionPassCache.nLA = var63;
         float var114 = 0.3F * dp * var8;
         if (var114 > 0.002F && RegionPassCache.nSA < (677197818 ^ 677193722)) {
            float[] var115 = RegionPassCache.SA;
            int var116 = RegionPassCache.nSA++ * 8;
            var115[var116] = var34;
            var115[var116 + 1] = var35;
            var115[var116 + 2] = var36;
            var115[var116 + 3] = 0.34F * var14;
            var115[var116 + 4] = 0.34F * var14;
            var115[var116 + 5] = 0.0F;
            var115[var116 + 6] = 4.0F;
            var115[var116 + 7] = Float.intBitsToFloat((int)(Math.min(1.0F, var114) * 255.0F + 0.5F) << 24 | ei);
         }
      } catch (RuntimeException var111) {
         throw var111;
      }
   }

   private static void i(double var0, double var2, double var4, float var6, float var7, float var8, float var9) {

      assert !Double.isNaN(var0)
         && !Double.isNaN(var2)
         && !Double.isNaN(var4)
         && var6 > 0.0F
         && var7 > 0.0F
         && var8 >= 0.0F
         && var9 >= 0.0F
         && var9 <= 2.0F
         && bb.length == (-1440316650 ^ -1440316544)
         && bc.length == (-356681982 ^ -356681836)
         && bd.length == (-334032630 ^ -334032484)
         && be.length == (1206852749 ^ 1206852635)
         && bf.length == (-882112668 ^ -882112526)
         && bg.length == (-394948866 ^ -394949016)
         && bh.length == (-257827313 ^ -257827175)
         && bi.length == (-628679222 ^ -628679332)
         && RegionPassCache.SA.length == (-1956071591 ^ -1956104359) : "sparkles: b" + "ad " + "st" + "ate";

      try {
         float var10 = (0.08F + 0.7F * var7) * var8;
         double var11 = ds;
         float var13 = _kwren_do <= 0.0F ? 0.0F : (_kwren_do >= 1.0F ? 1.0F : _kwren_do);
         float var14 = 60.0F + 90.0F * var13;
         float var15 = 0.7F * dp;
         float var16 = (float)var2 - 0.04F * var6;
         float var17 = 1.12F * var6;
         int var18 = ei;
         int var19 = ef;
         float[] var20 = RegionPassCache.SA;
         int var21 = RegionPassCache.nSA;

         for (int var22 = 0; var22 < (1736520106 ^ 1736519996); var22++) {
            float var23 = var14 - (float)var22;
            if (var23 <= 0.0F) {
               break;
            }

            double var24 = (double)bd[var22] + (double)be[var22] * var11;
            var24 -= Math.floor(var24);
            float var26 = (float)var24;
            float var27 = var26 * 8.333333F;
            float var28 = (1.0F - var26) * 4.5454545F;
            var27 = var27 >= 1.0F ? 1.0F : var27 * var27 * (3.0F - 2.0F * var27);
            var28 = var28 >= 1.0F ? 1.0F : var28 * var28 * (3.0F - 2.0F * var28);
            float var29 = 0.5F + 0.5F * (float)Math.sin((double)bg[var22] * var11 + (double)bh[var22]);
            var29 *= var29;
            float var30 = var9 * (var23 >= 1.0F ? 1.0F : var23) * var27 * var28 * (0.45F + 0.55F * var29);
            if (!(var30 <= 0.004F)) {
               double var31 = (double)bb[var22] + (double)bf[var22] * var11 + 1.3 * var24;
               float var33 = var10 * bc[var22];
               float var34 = var8 * bi[var22];
               float var35 = (float)(var0 + (double)var33 * Math.cos(var31));
               float var36 = var16 + var17 * var26 * (1.6F - 0.6F * var26);
               float var37 = (float)(var4 + (double)var33 * Math.sin(var31));
               if (var21 < (1882845886 ^ 1882841790)) {
                  int var38 = var21++ * 8;
                  var20[var38] = var35;
                  var20[var38 + 1] = var36;
                  var20[var38 + 2] = var37;
                  var20[var38 + 3] = var20[var38 + 4] = 0.04F * var34 * (0.8F + 0.35F * var29);
                  var20[var38 + 5] = 0.0F;
                  var20[var38 + 6] = 3.0F;
                  var20[var38 + 7] = Float.intBitsToFloat((int)(Math.min(1.0F, var30) * 255.0F + 0.5F) << 24 | var18);
               }

               float var45 = var15 * var30;
               if (var45 > 0.004F && var21 < (1012548894 ^ 1012552990)) {
                  int var39 = var21++ * 8;
                  var20[var39] = var35;
                  var20[var39 + 1] = var36;
                  var20[var39 + 2] = var37;
                  var20[var39 + 3] = var20[var39 + 4] = 0.13F * var34;
                  var20[var39 + 5] = 0.0F;
                  var20[var39 + 6] = 4.0F;
                  var20[var39 + 7] = Float.intBitsToFloat((int)(Math.min(1.0F, var45) * 255.0F + 0.5F) << 24 | var19);
               }
            }
         }

         RegionPassCache.nSA = var21;
      } catch (RuntimeException var40) {
         throw var40;
      }
   }

   private static void j(double var0, double var2, double var4, float var6, float var7, float var8, float var9) {

      assert !Double.isNaN(var0)
         && !Double.isNaN(var2)
         && !Double.isNaN(var4)
         && var6 > 0.0F
         && var7 > 0.0F
         && var8 >= 0.0F
         && var9 >= 0.0F
         && var9 <= 2.0F
         && au.length == 49
         && av.length == 49
         && RegionPassCache.QA.length == (-1266780829 ^ -1266686621)
         && RegionPassCache.LA.length == (1730031016 ^ 1730104744) : "ring: bad state";

      try {
         float var10 = (0.12F + 0.65F * var7) * var8;
         double var11 = (float) (Math.PI * 2) * ds / 2.2;
         float var13 = 0.5F - 0.5F * (float)Math.cos(var11);
         float var14 = (float)Math.sin(var11);
         float var15 = 0.04F * var6;
         float var16 = 0.985F * var6;
         float var17 = (float)var2 + var15 + (var16 - var15) * var13;
         float var18 = -0.34F * (var6 / 1.8F) * var14;
         float var19 = var17 + 0.55F * var18;
         float var20 = var17 + var18;
         float var21 = 0.13F * var8;
         float var22 = (float)var0;
         float var23 = (float)var4;
         float var24 = _kwren_do <= 0.0F ? 0.0F : (_kwren_do >= 1.0F ? 1.0F : _kwren_do);
         float var25 = Math.min(1.0F, 3.0F * var24) * var9;
         float var26 = 0.45F * dp * var9;
         boolean var27 = var25 > 0.004F && (var18 > 0.004F || var18 < -0.004F);
         boolean var28 = var26 > 0.004F;
         float var29 = Float.intBitsToFloat((int)(Math.min(1.0F, var25) * 255.0F + 0.5F) << 24 | ei);
         float var30 = Float.intBitsToFloat((int)(Math.min(1.0F, 0.95F * var25) * 255.0F + 0.5F) << 24 | eh);
         float var31 = Float.intBitsToFloat((int)(Math.min(1.0F, 0.95F * var9) * 255.0F + 0.5F) << 24 | ei);
         float var32 = Float.intBitsToFloat((int)(Math.min(1.0F, var26) * 255.0F + 0.5F) << 24 | ee);
         float var33 = Float.intBitsToFloat(eh);
         float var34 = 0.1F * var8;
         float[] var35 = RegionPassCache.QA;
         float[] var36 = RegionPassCache.LA;
         int var37 = RegionPassCache.nQA;
         int var38 = RegionPassCache.nLA;
         float var39 = var22 + var10 * au[0];
         float var40 = var23 + var10 * av[0];

         for (int var41 = 0; var41 < 48; var41++) {
            float var42 = var22 + var10 * au[var41 + 1];
            float var43 = var23 + var10 * av[var41 + 1];

            for (int var44 = var27 ? 0 : 2; var44 < (var28 ? 3 : 2); var44++) {
               if (var37 < (1884339796 ^ 1884335700)) {
                  int var45 = var37++ * 25;
                  float var46 = var44 == 0 ? var17 : (var44 == 1 ? var19 : var17 - var21);
                  float var47 = var44 == 0 ? var19 : (var44 == 1 ? var20 : var17 + var21);
                  var35[var45] = var39;
                  var35[var45 + 1] = var46;
                  var35[var45 + 2] = var40;
                  var35[var45 + 3] = var42;
                  var35[var45 + 4] = var46;
                  var35[var45 + 5] = var43;
                  var35[var45 + 6] = var42;
                  var35[var45 + 7] = var47;
                  var35[var45 + 8] = var43;
                  var35[var45 + 9] = var39;
                  var35[var45 + 10] = var47;
                  var35[var45 + 11] = var40;
                  float var48 = var44 == 2 ? 0.0F : 0.5F;
                  float var49 = var44 == 0 ? 0.5F : 1.0F;
                  var35[var45 + 12] = 0.5F;
                  var35[var45 + 13] = var48;
                  var35[var45 + 14] = 0.5F;
                  var35[var45 + 15] = var48;
                  var35[var45 + 16] = 0.5F;
                  var35[var45 + 17] = var49;
                  var35[var45 + 18] = 0.5F;
                  var35[var45 + 19] = var49;
                  var35[var45 + 20] = var44 == 2 ? 2.0F : 0.0F;
                  float var50 = var44 == 0 ? var29 : (var44 == 1 ? var30 : var32);
                  float var51 = var44 == 0 ? var30 : (var44 == 1 ? var33 : var50);
                  var35[var45 + 21] = var50;
                  var35[var45 + 22] = var50;
                  var35[var45 + 23] = var51;
                  var35[var45 + 24] = var51;
               }
            }

            if (var38 < (772999004 ^ 773007196)) {
               int var53 = var38++ * 11;
               var36[var53] = var39;
               var36[var53 + 1] = var17;
               var36[var53 + 2] = var40;
               var36[var53 + 3] = var42;
               var36[var53 + 4] = var17;
               var36[var53 + 5] = var43;
               var36[var53 + 6] = var34;
               var36[var53 + 7] = var34;
               var36[var53 + 8] = var31;
               var36[var53 + 9] = var31;
               var36[var53 + 10] = 1.0F;
            }

            var39 = var42;
            var40 = var43;
         }

         RegionPassCache.nQA = var37;
         RegionPassCache.nLA = var38;
      } catch (RuntimeException var52) {
         throw var52;
      }
   }

   private static void k(double var0, double var2, double var4, float var6, float var7, float var8, float var9) {

      assert !Double.isNaN(var0)
         && !Double.isNaN(var2)
         && !Double.isNaN(var4)
         && var6 > 0.0F
         && var7 > 0.0F
         && var8 >= 0.0F
         && var9 >= 0.0F
         && var9 <= 2.0F
         && RegionPassCache.QA.length == (935757918 ^ 935794782)
         && RegionPassCache.SA.length == (227051931 ^ 227019163) : "sweep: bad state";

      try {
         float var10 = (0.16F + 0.37F * var7) * var8;
         float var11 = 0.18F * var8;
         float var12 = 0.15F * var8;
         double var13 = ds;
         double var15 = -7.85F * var13;
         float var17 = (float)var0;
         float var18 = (float)var4;
         float var19 = (float)var2 + 0.04F * var6;
         float var20 = (float)var2 + 1.05F * var6;
         float var21 = _kwren_do <= 0.0F ? 0.0F : (_kwren_do >= 1.0F ? 1.0F : _kwren_do);
         float var22 = Math.min(1.0F, 0.6F + 2.0F * var21) * var9;
         float var23 = 0.3F * dp * var9;
         int var24 = ei;
         int var25 = ee;
         float[] var26 = RegionPassCache.QA;
         int var27 = RegionPassCache.nQA;
         float var28 = 0.0F;
         float var29 = 0.0F;
         float var30 = 0.0F;
         float var31 = 0.0F;
         float var32 = 0.0F;

         for (int var33 = 0; var33 <= 40; var33++) {
            float var34 = (float)var33 * 0.025F;
            float var35 = 1.0F - var34;
            double var36 = var15 + (double)(var34 * 3.4F);
            double var38 = (var13 - (double)(var34 * 0.43312103F)) / 3.6F;
            float var40 = (float)(var38 - Math.floor(var38));
            float var41;
            if (var40 < 0.2778F) {
               var41 = 0.0F;
            } else if (var40 < 0.5F) {
               float var42 = (var40 - 0.2778F) * 4.5F;
               var41 = var42 * var42 * (3.0F - 2.0F * var42);
            } else if (var40 < 0.7778F) {
               var41 = 1.0F;
            } else {
               float var68 = (var40 - 0.7778F) * 4.5F;
               var41 = 1.0F - var68 * var68 * (3.0F - 2.0F * var68);
            }

            float var69 = var19 + (var20 - var19) * var41;
            float var43 = var11 * var35;
            float var44 = 1.0F - var34 * var34 * var34;
            float var45 = (float)Math.cos(var36);
            float var46 = (float)Math.sin(var36);
            if (var33 > 0) {
               for (int var47 = 0; var47 < (var23 > 0.004F ? 4 : 2); var47++) {
                  if (var27 < (-1505938630 ^ -1505942726)) {
                     int var48 = var27++ * 25;
                     float var49;
                     float var50;
                     float var51;
                     float var52;
                     float var53;
                     float var54;
                     float var55;
                     float var56;
                     if (var47 != 0 && var47 != 2) {
                        float var70 = var47 == 1 ? 0.5F * var31 : var12;
                        float var58 = var47 == 1 ? 0.5F * var43 : var12;
                        var50 = var47 == 1 ? var10 + var31 : var10;
                        var49 = var47 == 1 ? var10 + var31 : var10;
                        var51 = var52 = var47 == 1 ? var10 + var43 : var10;
                        var53 = var30 - var70;
                        var54 = var30 + var70;
                        var55 = var69 - var58;
                        var56 = var69 + var58;
                     } else {
                        float var57 = var47 == 0 ? 1.0F : 2.0F;
                        var49 = var10 - var57 * var31;
                        var50 = var10 + var57 * var31;
                        var51 = var10 - var57 * var43;
                        var52 = var10 + var57 * var43;
                        var54 = var30;
                        var53 = var30;
                        var56 = var69;
                        var55 = var69;
                     }

                     var26[var48] = var17 + var49 * var28;
                     var26[var48 + 1] = var53;
                     var26[var48 + 2] = var18 + var49 * var29;
                     var26[var48 + 3] = var17 + var50 * var28;
                     var26[var48 + 4] = var54;
                     var26[var48 + 5] = var18 + var50 * var29;
                     var26[var48 + 6] = var17 + var52 * var45;
                     var26[var48 + 7] = var56;
                     var26[var48 + 8] = var18 + var52 * var46;
                     var26[var48 + 9] = var17 + var51 * var45;
                     var26[var48 + 10] = var55;
                     var26[var48 + 11] = var18 + var51 * var46;
                     var26[var48 + 12] = 0.5F;
                     var26[var48 + 13] = 0.0F;
                     var26[var48 + 14] = 0.5F;
                     var26[var48 + 15] = 1.0F;
                     var26[var48 + 16] = 0.5F;
                     var26[var48 + 17] = 1.0F;
                     var26[var48 + 18] = 0.5F;
                     var26[var48 + 19] = 0.0F;
                     var26[var48 + 20] = var47 < 2 ? 20.0F : 2.0F;
                     float var71 = var47 < 2 ? var22 : var23;
                     int var72 = var47 < 2 ? var24 : var25;
                     float var59 = Float.intBitsToFloat((int)(Math.min(1.0F, var71 * var32) * 255.0F + 0.5F) << 24 | var72);
                     float var60 = Float.intBitsToFloat((int)(Math.min(1.0F, var71 * var44) * 255.0F + 0.5F) << 24 | var72);
                     var26[var48 + 21] = var59;
                     var26[var48 + 22] = var59;
                     var26[var48 + 23] = var60;
                     var26[var48 + 24] = var60;
                  }
               }
            }

            var28 = var45;
            var29 = var46;
            var30 = var69;
            var31 = var43;
            var32 = var44;
         }

         RegionPassCache.nQA = var27;
         float var62 = 0.5F * dp * var9;
         if (var62 > 0.004F && RegionPassCache.nSA < (-1729079353 ^ -1729083449)) {
            float[] var63 = RegionPassCache.SA;
            int var64 = RegionPassCache.nSA++ * 8;
            double var65 = var13 / 3.6F - Math.floor(var13 / 3.6F);
            float var66 = var65 < 0.2778
               ? 0.0F
               : (var65 < 0.5 ? (float)((var65 - 0.2778) * 4.5) : (var65 < 0.7778 ? 1.0F : 1.0F - (float)((var65 - 0.7778) * 4.5)));
            var66 = var66 * var66 * (3.0F - 2.0F * var66);
            var63[var64] = var17 + (var10 + var11 * 0.5F) * (float)Math.cos(var15);
            var63[var64 + 1] = var19 + (var20 - var19) * var66;
            var63[var64 + 2] = var18 + (var10 + var11 * 0.5F) * (float)Math.sin(var15);
            var63[var64 + 3] = 0.17F * var8;
            var63[var64 + 4] = 0.17F * var8;
            var63[var64 + 5] = 0.0F;
            var63[var64 + 6] = 4.0F;
            var63[var64 + 7] = Float.intBitsToFloat((int)(Math.min(1.0F, var62) * 255.0F + 0.5F) << 24 | eg);
         }
      } catch (RuntimeException var61) {
         throw var61;
      }
   }

   private static void l(int var0, double var1, double var3, double var5, float var7, float var8, float var9, float var10) {

      assert var0 >= 0
         && var0 <= 5
         && !Double.isNaN(var1)
         && !Double.isNaN(var3)
         && !Double.isNaN(var5)
         && var7 > 0.0F
         && var8 > 0.0F
         && var9 >= 0.0F
         && var10 >= 0.0F
         && var10 <= 2.0F
         && bq.length == 24
         && ci.length == 6
         && RegionPassCache.LA.length == (392621644 ^ 392662604)
         && RegionPassCache.SA.length == (1478844916 ^ 1478877684)
         && br.length == 72
         && bs.length == 72 : "bolts: bad state";

      try {
         double var11 = Math.toRadians((double)ci[var0]);
         float var13 = -((float)Math.sin(var11));
         float var14 = (float)Math.cos(var11);
         float var15 = var14;
         float var16 = -var13;
         float var17 = (0.02F + 0.84F * var8) * var9;
         float var18 = (0.02F + 0.3F * var8) * var9;
         float var19 = 0.55F * var17;
         if (var9 > 0.01F) {
            float var20 = (float)var1;
            float var21 = (float)var3;
            float var22 = (float)var5;
            float var23 = var7 / 1.8F;
            double var24 = Math.atan2(-(var1 * (double)var13 + var5 * (double)var14), -(var1 * (double)var14 + var5 * (double)var16));
            double var26 = ds;
            float var28 = _kwren_do <= 0.0F ? 0.0F : (_kwren_do >= 1.0F ? 1.0F : _kwren_do);
            float var29 = dp;
            int var30 = 5 + (int)(8.0F * var28 + 0.5F);
            var30 = var30 > 12 ? 12 : var30;
            float var31 = 0.05F * var9;
            float var32 = 0.11F * var9;
            float var33 = 0.06F * var7;
            float var34 = 0.84F * var7;
            int var35 = ek;
            int var36 = ej;
            float[] var37 = RegionPassCache.LA;
            float[] var38 = bq;
            int var39 = RegionPassCache.nLA;

            for (int var40 = 0; var40 < var30; var40++) {
               double var41 = var26 / (0.19 + 0.05 * (double)(var40 % 3)) + 0.379 * (double)var40;
               double var43 = Math.floor(var41);
               float var45 = (float)(var41 - var43);
               float var46 = var45 < 0.08F
                  ? var45 * 12.5F
                  : (var45 < 0.7F ? 1.0F - 0.3F * (var45 - 0.08F) * 1.6129032F : 0.7F * (1.0F - (var45 - 0.7F) * 3.3333333F));
               if (!(var46 * var10 <= 0.004F)) {
                  double var47 = var26 * 30.0 + 7.31 * (double)var40;
                  double var49 = Math.floor(var47);
                  int var51 = (int)((long)var49) * (1614494376 ^ 1277167301) + var40 * (2008757232 ^ 1589714633);
                  int var52 = var51 + (-1552930308 ^ -1888807535);
                  var51 ^= var51 >>> 15;
                  var51 *= 890744350 ^ -1325636491;
                  var51 ^= var51 >>> 13;
                  var52 ^= var52 >>> 15;
                  var52 *= -1514820976 ^ 543056123;
                  var52 ^= var52 >>> 13;
                  float var53 = (float)(var47 - var49);
                  float var54 = (float)(var51 >>> 8) * 5.9604645E-8F;
                  float var55 = (float)(var52 >>> 8) * 5.9604645E-8F;
                  var46 *= var10 * (0.82F + 0.36F * (var54 + (var55 - var54) * var53));
                  int var56 = (int)((long)var43) * (661296468 ^ -1185026835) + var40 * (1644579674 ^ 19771121);
                  var56 ^= var56 >>> 16;
                  var56 *= 965985511 ^ 1182331338;
                  var56 ^= var56 >>> 15;
                  var56 *= 804198094 ^ -1417433019;
                  var56 ^= var56 >>> 16;
                  var56 |= 1;
                  var56 ^= var56 << 13;
                  var56 ^= var56 >>> 17;
                  var56 ^= var56 << 5;
                  int var57 = var0 * 12 + var40;
                  if (br[var57] != var43) {
                     br[var57] = var43;
                     bs[var57] = (float)var24;
                  }

                  double var58 = (var56 & 3) != 0
                     ? (double)bs[var57] + 2.8 * (double)((float)(var56 >>> 8) * 5.9604645E-8F - 0.5F)
                     : (double)((float) (Math.PI * 2) * (float)(var56 >>> 8) * 5.9604645E-8F);
                  var56 ^= var56 << 13;
                  var56 ^= var56 >>> 17;
                  var56 ^= var56 << 5;
                  float var60 = (float)(var56 >>> 8) * 5.9604645E-8F;
                  var56 ^= var56 << 13;
                  var56 ^= var56 >>> 17;
                  var56 ^= var56 << 5;
                  float var61 = var60 < 0.75F
                     ? (0.45F + 0.33F * (float)(var56 >>> 8) * 5.9604645E-8F) * var7
                     : (0.12F + 0.33F * (float)(var56 >>> 8) * 5.9604645E-8F) * var7;
                  var56 ^= var56 << 13;
                  var56 ^= var56 >>> 17;
                  var56 ^= var56 << 5;
                  float var62 = (float) (Math.PI * 2) * (float)(var56 >>> 8) * 5.9604645E-8F;
                  float var63 = 0.3F * var9;

                  for (int var64 = 0; var64 <= 7; var64++) {
                     if (var64 > 0) {
                        int var116 = var56 ^ var56 << 13;
                        int var117 = var116 ^ var116 >>> 17;
                        int var118 = var117 ^ var117 << 5;
                        var62 += ((float)(var118 >>> 8) * 5.9604645E-8F - 0.5F) * 1.2F;
                        int var119 = var118 ^ var118 << 13;
                        int var120 = var119 ^ var119 >>> 17;
                        int var121 = var120 ^ var120 << 5;
                        float var65 = (0.03F + 0.07F * (float)(var121 >>> 8) * 5.9604645E-8F) * var9;
                        int var122 = var121 ^ var121 << 13;
                        int var123 = var122 ^ var122 >>> 17;
                        var56 = var123 ^ var123 << 5;
                        float var66 = ((var64 & 1) == 0 ? 1.0F : -1.0F) * (0.03F + 0.1F * (float)(var56 >>> 8) * 5.9604645E-8F) * var9;
                        float var67 = (float)Math.cos((double)var62);
                        float var68 = (float)Math.sin((double)var62);
                        var58 += (double)((var65 * var67 - var66 * var68) / var63);
                        var61 += (var65 * var68 + var66 * var67) * var23;
                        if (var61 < var33 || var61 > var34) {
                           var61 = var61 < var33 ? var33 : var34;
                           var62 = -var62;
                        }
                     }

                     int var124 = var56 ^ var56 << 13;
                     int var125 = var124 ^ var124 >>> 17;
                     var56 = var125 ^ var125 << 5;
                     float var135 = (0.012F + 0.05F * (float)(var56 >>> 8) * 5.9604645E-8F) * var9;
                     float var137 = (float)Math.cos(var58);
                     float var139 = (float)Math.sin(var58);
                     float var141 = (var61 - 0.36F * var7) / (0.1F * var7);
                     var141 = var141 <= 0.0F ? 0.0F : (var141 >= 1.0F ? 1.0F : var141 * var141 * (3.0F - 2.0F * var141));
                     float var69 = var137 / (var19 + (var17 - var19) * var141);
                     float var70 = var139 / var18;
                     var69 *= var69;
                     var70 *= var70;
                     var63 = 1.0F / (float)Math.sqrt(Math.sqrt((double)(var69 * var69 + var70 * var70))) + var135;
                     float var71 = var63 * var137;
                     float var72 = var63 * var139;
                     var38[var64 * 3] = var20 + var71 * var15 + var72 * var13;
                     var38[var64 * 3 + 1] = var21 + var61;
                     var38[var64 * 3 + 2] = var22 + var71 * var16 + var72 * var14;
                  }

                  float var134 = Float.intBitsToFloat((int)(Math.min(1.0F, 0.95F * var46) * 255.0F + 0.5F) << 24 | var35);
                  int var136 = (int)(Math.min(1.0F, 0.6F * var29 * var46) * 255.0F + 0.5F);
                  int var138 = var136 != 0 ? 2 : 1;
                  float var140 = Float.intBitsToFloat(var136 << 24 | var36);

                  for (int var143 = 0; var143 < 7; var143++) {
                     for (int var146 = 0; var146 < var138; var146++) {
                        if (var39 < (-128211328 ^ -128219520)) {
                           int var149 = var39++ * 11;
                           var37[var149] = var38[var143 * 3];
                           var37[var149 + 1] = var38[var143 * 3 + 1];
                           var37[var149 + 2] = var38[var143 * 3 + 2];
                           var37[var149 + 3] = var38[var143 * 3 + 3];
                           var37[var149 + 4] = var38[var143 * 3 + 4];
                           var37[var149 + 5] = var38[var143 * 3 + 5];
                           var37[var149 + 6] = var146 == 0 ? var31 : var32;
                           var37[var149 + 7] = var146 == 0 ? var31 : var32;
                           var37[var149 + 8] = var146 == 0 ? var134 : var140;
                           var37[var149 + 9] = var146 == 0 ? var134 : var140;
                           var37[var149 + 10] = var146 == 0 ? 1.0F : 2.0F;
                        }
                     }
                  }

                  var56 ^= var56 << 13;
                  var56 ^= var56 >>> 17;
                  var56 ^= var56 << 5;
                  int var144 = 2 + (int)((float)(var56 >>> 8) * 5.9604645E-8F * 4.0F);
                  float var147 = var38[var144 * 3];
                  float var150 = var38[var144 * 3 + 1];
                  float var151 = var38[var144 * 3 + 2];
                  float var152 = var147 - var20;
                  float var73 = var151 - var22;
                  float var74 = (float)Math.sqrt((double)(var152 * var152 + var73 * var73));
                  var74 = var74 > 1.0E-4F ? 1.0F / var74 : 0.0F;
                  var152 *= var74;
                  var73 *= var74;
                  float var75 = (var40 % 3 == 0 ? 0.12F : 0.06F) * var9;
                  float var76 = (var40 % 3 == 0 ? 0.1F : 0.05F) * var23;

                  for (int var77 = 0; var77 < 4; var77++) {
                     int var129 = var56 ^ var56 << 13;
                     int var130 = var129 ^ var129 >>> 17;
                     int var131 = var130 ^ var130 << 5;
                     float var78 = (float)(var131 >>> 8) * 5.9604645E-8F;
                     int var132 = var131 ^ var131 << 13;
                     int var133 = var132 ^ var132 >>> 17;
                     var56 = var133 ^ var133 << 5;
                     float var79 = (float)(var56 >>> 8) * 5.9604645E-8F - 0.5F;
                     float var80 = var75 * (0.6F + 0.8F * var78);
                     float var81 = var147 + var152 * var80 - var73 * var79 * 1.6F * var80;
                     float var82 = var150 - var76 * (0.2F + 1.2F * var78) + var79 * 0.05F * var23;
                     float var83 = var151 + var73 * var80 + var152 * var79 * 1.6F * var80;
                     float var84 = 1.0F - (float)var77 * 0.25F;
                     float var85 = Float.intBitsToFloat((int)(Math.min(1.0F, 0.8F * var84 * var46) * 255.0F + 0.5F) << 24 | var35);
                     float var86 = Float.intBitsToFloat((int)(Math.min(1.0F, 0.45F * var84 * var29 * var46) * 255.0F + 0.5F) << 24 | var36);

                     for (int var87 = 0; var87 < var138; var87++) {
                        if (var39 < (1722411622 ^ 1722403430)) {
                           int var88 = var39++ * 11;
                           var37[var88] = var147;
                           var37[var88 + 1] = var150;
                           var37[var88 + 2] = var151;
                           var37[var88 + 3] = var81;
                           var37[var88 + 4] = var82;
                           var37[var88 + 5] = var83;
                           var37[var88 + 6] = var87 == 0 ? 0.8F * var31 : 0.8F * var32;
                           var37[var88 + 7] = var87 == 0 ? 0.6F * var31 : 0.7F * var32;
                           var37[var88 + 8] = var87 == 0 ? var85 : var86;
                           var37[var88 + 9] = var87 == 0 ? var85 : var86;
                           var37[var88 + 10] = var87 == 0 ? 1.0F : 2.0F;
                        }
                     }

                     var147 = var81;
                     var150 = var82;
                     var151 = var83;
                  }

                  float var156 = 0.45F * var29 * var46;
                  if (var156 > 0.004F && RegionPassCache.nSA < (-1929442358 ^ -1929438262)) {
                     float[] var157 = RegionPassCache.SA;
                     int var158 = RegionPassCache.nSA++ * 8;
                     var157[var158] = var38[0];
                     var157[var158 + 1] = var38[1];
                     var157[var158 + 2] = var38[2];
                     var157[var158 + 3] = 0.07F * var9;
                     var157[var158 + 4] = 0.07F * var9;
                     var157[var158 + 5] = 0.0F;
                     var157[var158 + 6] = 4.0F;
                     var157[var158 + 7] = Float.intBitsToFloat((int)(Math.min(1.0F, var156) * 255.0F + 0.5F) << 24 | var36);
                  }
               }
            }

            RegionPassCache.nLA = var39;
         }
      } catch (RuntimeException var89) {
         throw var89;
      }
   }

   private static void m(int var0, PlayerEntity var1) {

      float var2 = RegionPassCache.td;
      cr[var0] = var1;
      ct[var0] = 0.0F;
      da[var0] = MathHelper.lerp((double)var2, var1.lastRenderX, var1.getX());
      db[var0] = MathHelper.lerp((double)var2, var1.lastRenderY, var1.getY());
      dc[var0] = MathHelper.lerp((double)var2, var1.lastRenderZ, var1.getZ());
      cx[var0] = MathHelper.lerpAngleDegrees(var2, var1.lastHeadYaw, var1.headYaw);
      cy[var0] = var1.getPitch(var2);
      cz[var0] = var1.getScale();
      cv[var0] = Math.max(0.1F, var1.getHeight());
      cw[var0] = var1.getEquippedStack(EquipmentSlot.HEAD).isEmpty() ? 0.49F : 0.52F;
      cu[var0] = var1.getPose() != EntityPose.STANDING && var1.getPose() != EntityPose.CROUCHING ? 0.0F : 1.0F;
   }

   private static void n(MinecraftClient var0, int var1) {

      for (int var2 = 1; var2 < 21; var2++) {
         cs[var2] = false;
      }

      if (var1 == 1 || var1 == 2) {
         BindingBridge var18 = null;
         if (var1 == 1) {
            if (ConfigBridge.c != null) {
               var18 = ConfigBridge.c.e();
            }

            if (var18 == null || var18.d()) {
               return;
            }
         }

         List var3 = var0.world.getPlayers();
         double var4 = RegionPassCache.z;
         double var6 = RegionPassCache.aa;
         double var8 = RegionPassCache.ab;
         int var10 = 0;
         int var11 = 0;

         for (int var12 = var3.size(); var11 < var12; var11++) {
            AbstractClientPlayerEntity var13 = (AbstractClientPlayerEntity)var3.get(var11);
            if (var13 != null && var13 != var0.player && !var13.isRemoved() && !var13.isSpectator()) {
               boolean var14 = false;

               for (int var15 = 1; var15 < 21; var15++) {
                  if (cr[var15] == var13) {
                     var14 = true;
                     break;
                  }
               }

               double var26 = var13.squaredDistanceTo(var4, var6, var8);
               if (!(var26 > (var14 ? 2500.0 : 2304.0)) && (var18 == null || var18.c(var13.getGameProfile().name()))) {
                  if (var14) {
                     var26 *= 0.8;
                  }

                  if (var10 < 16 || var26 < de[var10 - 1]) {
                     int var17;
                     for (var17 = var10 < 16 ? var10++ : 15; var17 > 0 && de[var17 - 1] > var26; var17--) {
                        de[var17] = de[var17 - 1];
                        dd[var17] = dd[var17 - 1];
                     }

                     de[var17] = var26;
                     dd[var17] = var13;
                  }
               }
            }
         }

         for (int var19 = 0; var19 < var10; var19++) {
            for (int var22 = 1; var22 < 21; var22++) {
               if (cr[var22] == dd[var19]) {
                  cs[var22] = true;
                  dd[var19] = null;
                  break;
               }
            }
         }

         for (int var20 = 0; var20 < var10; var20++) {
            if (dd[var20] != null) {
               int var23 = -1;
               float var24 = 3.0F;

               for (int var25 = 1; var25 < 21; var25++) {
                  if (!cs[var25]) {
                     float var27 = cr[var25] == null && ct[var25] <= 0.0F ? -1.0F : ct[var25];
                     if (var27 < var24) {
                        var24 = var27;
                        var23 = var25;
                     }
                  }
               }

               if (var23 >= 0) {
                  m(var23, dd[var20]);
                  cs[var23] = true;
               }
            }
         }

         for (int var21 = 0; var21 < 16; var21++) {
            dd[var21] = null;
         }
      }
   }

   private static void o(int var0, MinecraftClient var1) {

      assert var0 >= 0
         && var0 <= 21
         && cr.length == 22
         && cs.length == 22
         && ct.length == 22
         && cu.length == 22
         && cv.length == 22
         && cw.length == 22
         && cx.length == 22
         && cy.length == 22
         && cz.length == 22
         && da.length == 22
         && db.length == 22
         && dc.length == 22
         && (var0 != 21 || RegionPassCache.PV)
         && au.length == 49
         && av.length == 49
         && aw.length == 48
         && ax.length == 48
         && RegionPassCache.QS.length == (1684532322 ^ 1684481122)
         && RegionPassCache.LA.length == (1221444981 ^ 1221371253)
         && RegionPassCache.SA.length == (1166703923 ^ 1166736691) : "hat: bad st" + "a" + "te";

      PlayerEntity var2 = cr[var0];

      try {
         float var3 = RegionPassCache.dt;
         boolean var4 = false;
         float var5 = cu[var0];
         if (var0 == 21) {
            var4 = true;
            da[var0] = RegionPassCache.pvX;
            db[var0] = RegionPassCache.pvY;
            dc[var0] = RegionPassCache.pvZ;
            cx[var0] = RegionPassCache.bq;
            cy[var0] = RegionPassCache.br;
            cz[var0] = 1.0F;
            cv[var0] = RegionPassCache.pvH;
            float var6 = RegionPassCache.bs ? 0.52F : 0.49F;
            float var7 = cw[var0];
            cw[var0] = var7 > 0.0F ? var7 + (var6 - var7) * (1.0F - (float)Math.exp((double)(-var3 * 10.0F))) : var6;
            var5 = Math.min(1.0F, var5 + var3 / 0.15F);
            cu[var0] = var5;
         } else if (var2 != null) {
            if (var2.isRemoved()) {
               cr[var0] = null;
            } else {
               float var133 = RegionPassCache.td;
               float var135 = 1.0F - (float)Math.exp((double)(-var3 * 10.0F));
               da[var0] = MathHelper.lerp((double)var133, var2.lastRenderX, var2.getX());
               db[var0] = MathHelper.lerp((double)var133, var2.lastRenderY, var2.getY());
               dc[var0] = MathHelper.lerp((double)var133, var2.lastRenderZ, var2.getZ());
               cx[var0] = MathHelper.lerpAngleDegrees(var133, var2.lastHeadYaw, var2.headYaw);
               cy[var0] = var2.getPitch(var133);
               cz[var0] = var2.getScale();
               float var8 = var2.getHeight();
               if (var8 > 0.1F) {
                  cv[var0] = var8;
               }

               cw[var0] = cw[var0] + ((var2.getEquippedStack(EquipmentSlot.HEAD).isEmpty() ? 0.49F : 0.52F) - cw[var0]) * var135;
               var4 = RegionPassCache.l(var2, false) && !var2.isSleeping();
               boolean var9 = var2.getPose() == EntityPose.STANDING || var2.getPose() == EntityPose.CROUCHING;
               var5 = var9 ? Math.min(1.0F, var5 + var3 / 0.15F) : Math.max(0.0F, var5 - var3 / 0.15F);
               cu[var0] = var5;
               if (!var4 && var2 == var1.getCameraEntity() && var1.options.getPerspective().isFirstPerson()) {
                  ct[var0] = 0.0F;
               }
            }
         }

         boolean var134 = cs[var0] && var4;
         float var136 = ct[var0];
         var136 = var134 ? Math.min(1.0F, var136 + var3 / 0.15F) : Math.max(0.0F, var136 - var3 / 0.15F);
         ct[var0] = var136;
         if (var136 <= 0.0F) {
            if (!cs[var0]) {
               cr[var0] = null;
            }
         } else {
            float var138 = cz[var0];
            double var139 = Math.toRadians((double)cx[var0]);
            double var11 = Math.toRadians((double)cy[var0]);
            double var13 = Math.sin(var139);
            double var15 = Math.cos(var139);
            double var17 = Math.sin(var11);
            double var19 = Math.cos(var11);
            double var21 = -var13 * var17;
            double var23 = var19;
            double var25 = var15 * var17;
            double var27 = var15;
            double var29 = var13;
            double var31 = var19 * var13;
            double var33 = var25 * var15 - var21 * var13;
            double var35 = -var19 * var15;
            double var37 = (double)(cw[var0] * var138);
            double var39 = da[var0] - RegionPassCache.z + var21 * var37;
            double var41 = db[var0] - RegionPassCache.aa + 0.78 * (double)cv[var0] + var19 * var37;
            double var43 = dc[var0] - RegionPassCache.ab + var25 * var37;
            double var45 = Math.sqrt(var39 * var39 + var41 * var41 + var43 * var43);
            float var47 = (float)((48.0 - var45) / 8.0);
            var47 = var47 <= 0.0F ? 0.0F : (var47 >= 1.0F ? 1.0F : var47 * var47 * (3.0F - 2.0F * var47));
            float var48 = (float)((var45 - 0.45) / 0.65);
            var48 = var48 <= 0.0F ? 0.0F : (var48 >= 1.0F ? 1.0F : var48 * var48 * (3.0F - 2.0F * var48));
            float var49 = dv;
            float var50 = var136 * var136 * (3.0F - 2.0F * var136) * var5 * var5 * (3.0F - 2.0F * var5) * var49 * var49 * (3.0F - 2.0F * var49) * var47 * var48;
            if (!(var50 <= 0.003F)) {
               double var51 = 0.55 * (double)dq * (double)var138;
               double var53 = (double)(dr * var138);
               float var55 = (float)(var39 + var21 * var53);
               float var56 = (float)(var41 + var19 * var53);
               float var57 = (float)(var43 + var25 * var53);
               double var58 = 0.0;
               double var60 = 0.0;
               double var62 = 0.0;
               if (var45 > 1.0E-4) {
                  var58 = -var39 / var45 * 0.766 - (double)RegionPassCache.rX * 0.643;
                  var60 = -var41 / var45 * 0.766 - (double)RegionPassCache.rY * 0.643;
                  var62 = -var43 / var45 * 0.766 - (double)RegionPassCache.rZ * 0.643;
               }

               double var64 = var58 * var15 + var62 * var13;
               double var66 = var58 * var31 + var60 * var33 + var62 * var35;
               double var68 = Math.sqrt(var64 * var64 + var66 * var66);
               if (var68 < 1.0E-4) {
                  var64 = 1.0;
                  var66 = 0.0;
               } else {
                  var64 /= var68;
                  var66 /= var68;
               }

               int var70 = em;
               int var71 = en;
               float var72 = (float)(var70 >> 16 & (-1075436797 ^ -1075436548));
               float var73 = (float)(var70 >> 8 & (1970607200 ^ 1970607263));
               float var74 = (float)(var70 & (-978586250 ^ -978586231));
               float var75 = (float)(var71 >> 16 & (1550681543 ^ 1550681400));
               float var76 = (float)(var71 >> 8 & (-1628348764 ^ -1628348837));
               float var77 = (float)(var71 & (-1772280389 ^ -1772280508));
               boolean var78 = var50 * RegionPassCache.ae >= 0.99F;
               int var79 = var78 ? 1150828199 ^ -1147650393 : (int)(Math.min(1.0F, var50) * 255.0F + 0.5F) << 24;
               float var80 = Float.intBitsToFloat((int)(Math.min(1.0F, 0.8F * var50) * 255.0F + 0.5F) << 24 | var71);
               float var81 = 0.05F * var138;
               float[] var82 = RegionPassCache.QS;
               float[] var83 = RegionPassCache.LA;
               int var84 = RegionPassCache.nQS;
               int var85 = 1413621128 ^ 1413623176;
               int var86 = RegionPassCache.nLA;
               float var87 = var75 * 0.65F;
               float var88 = var76 * 0.65F;
               float var89 = var77 * 0.65F;
               float var90 = var75 * 0.45F;
               float var91 = var76 * 0.45F;
               float var92 = var77 * 0.45F;
               double var93 = 1.0 / Math.sqrt(var53 * var53 + var51 * var51);

               for (int var95 = var78 ? 1 : 0; var95 < 2; var95++) {
                  float var96 = (float)(var39 + var51 * var27 * (double)au[0] + var51 * var31 * (double)av[0]);
                  float var97 = (float)(var41 + var51 * var33 * (double)av[0]);
                  float var98 = (float)(var43 + var51 * var29 * (double)au[0] + var51 * var35 * (double)av[0]);
                  float var99 = (float)(0.72 + 0.28 * ((double)au[0] * var64 + (double)av[0] * var66));

                  for (int var100 = 0; var100 < 48; var100++) {
                     double var101 = (double)au[var100 + 1];
                     double var103 = (double)av[var100 + 1];
                     float var105 = (float)(var39 + var51 * (var27 * var101 + var31 * var103));
                     float var106 = (float)(var41 + var51 * var33 * var103);
                     float var107 = (float)(var43 + var51 * (var29 * var101 + var35 * var103));
                     float var108 = (float)(0.72 + 0.28 * (var101 * var64 + var103 * var66));
                     double var109 = var27 * (double)aw[var100] + var31 * (double)ax[var100];
                     double var111 = var33 * (double)ax[var100];
                     double var113 = var29 * (double)aw[var100] + var35 * (double)ax[var100];
                     double var115 = var39 + 0.5 * (var51 * var109 + var53 * var21);
                     double var117 = var41 + 0.5 * (var51 * var111 + var53 * var23);
                     double var119 = var43 + 0.5 * (var51 * var113 + var53 * var25);
                     double var121 = Math.max(1.0E-4, Math.sqrt(var115 * var115 + var117 * var117 + var119 * var119));
                     double var123 = -(
                           (var53 * var109 + var51 * var21) * var115 + (var53 * var111 + var51 * var23) * var117 + (var53 * var113 + var51 * var25) * var119
                        )
                        * var93
                        / var121;
                     if (var84 < var85 && (var78 || var123 < 0.0 == (var95 == 0))) {
                        float var125 = (float)(var123 / 0.24 + 0.5);
                        var125 = var125 <= 0.0F ? 0.0F : (var125 >= 1.0F ? 1.0F : var125 * var125 * (3.0F - 2.0F * var125));
                        float var126 = (float)(0.94 + 0.06 * (0.72 + 0.28 * ((double)aw[var100] * var64 + (double)ax[var100] * var66)));
                        float var127 = Float.intBitsToFloat(
                           var79
                              | (int)(var90 + (var72 * var126 - var90) * var125 + 0.5F) << 16
                              | (int)(var91 + (var73 * var126 - var91) * var125 + 0.5F) << 8
                              | (int)(var92 + (var74 * var126 - var92) * var125 + 0.5F)
                        );
                        float var128 = Float.intBitsToFloat(
                           var79
                              | (int)(var87 + (var75 * var99 - var87) * var125 + 0.5F) << 16
                              | (int)(var88 + (var76 * var99 - var88) * var125 + 0.5F) << 8
                              | (int)(var89 + (var77 * var99 - var89) * var125 + 0.5F)
                        );
                        float var129 = Float.intBitsToFloat(
                           var79
                              | (int)(var87 + (var75 * var108 - var87) * var125 + 0.5F) << 16
                              | (int)(var88 + (var76 * var108 - var88) * var125 + 0.5F) << 8
                              | (int)(var89 + (var77 * var108 - var89) * var125 + 0.5F)
                        );
                        int var130 = var84++ * 25;
                        var82[var130] = var55;
                        var82[var130 + 1] = var56;
                        var82[var130 + 2] = var57;
                        var82[var130 + 3] = var55;
                        var82[var130 + 4] = var56;
                        var82[var130 + 5] = var57;
                        var82[var130 + 6] = var105;
                        var82[var130 + 7] = var106;
                        var82[var130 + 8] = var107;
                        var82[var130 + 9] = var96;
                        var82[var130 + 10] = var97;
                        var82[var130 + 11] = var98;

                        for (byte var131 = 12; var131 < 20; var131 += 1) {
                           var82[var130 + var131] = 0.5F;
                        }

                        var82[var130 + 20] = 0.0F;
                        var82[var130 + 21] = var127;
                        var82[var130 + 22] = var127;
                        var82[var130 + 23] = var129;
                        var82[var130 + 24] = var128;
                     }

                     if (var95 == 1 && var86 < (-979018659 ^ -979010467)) {
                        int var148 = var86++ * 11;
                        var83[var148] = var96;
                        var83[var148 + 1] = var97;
                        var83[var148 + 2] = var98;
                        var83[var148 + 3] = var105;
                        var83[var148 + 4] = var106;
                        var83[var148 + 5] = var107;
                        var83[var148 + 6] = var81;
                        var83[var148 + 7] = var81;
                        var83[var148 + 8] = var80;
                        var83[var148 + 9] = var80;
                        var83[var148 + 10] = 1.0F;
                     }

                     var96 = var105;
                     var97 = var106;
                     var98 = var107;
                     var99 = var108;
                  }
               }

               RegionPassCache.nQS = var84;
               RegionPassCache.nLA = var86;
               float var144 = 0.25F * var50;
               if (var144 > 0.002F && RegionPassCache.nSA < (2088288337 ^ 2088292433)) {
                  float[] var145 = RegionPassCache.SA;
                  int var146 = RegionPassCache.nSA++ * 8;
                  var145[var146] = (float)(var39 + var21 * 0.1);
                  var145[var146 + 1] = (float)(var41 + var23 * 0.1);
                  var145[var146 + 2] = (float)(var43 + var25 * 0.1);
                  var145[var146 + 3] = (float)(0.95 * (double)dq * (double)var138);
                  var145[var146 + 4] = (float)(0.95 * (double)dq * (double)var138);
                  var145[var146 + 5] = 0.0F;
                  var145[var146 + 6] = 4.0F;
                  var145[var146 + 7] = Float.intBitsToFloat((int)(Math.min(1.0F, var144) * 255.0F + 0.5F) << 24 | el);
               }
            }
         }
      } catch (RuntimeException var132) {
         throw var132;
      }
   }

   public static void p() {
      int var0 = 0;
      byte var1 = 0;

      label30:
      while (true) {
         switch (var1) {
            case 0:
            default:
               if (es != 0) {
                  Thread.currentThread().getName().length();
                  var1 = 9;
                  break;
               }
            case 9:
               var0 = 0;
               var1 = 7;
               break;
            case 1:
               if (var0 >= 7) {
                  break label30;
               }

               dx[var0] = 0.0F;
               var0++;
               var1 = 1;
               break;
            case 2:
               if (var0 <= 21) {
                  cr[var0] = null;
                  cs[var0] = false;
                  ct[var0] = 0.0F;
                  cu[var0] = 0.0F;
                  var0++;
                  var1 = 2;
                  break;
               }
            case 5:
               var0 = 0;
               var1 = 8;
               break;
            case 4:
               break label30;
            case 7:
               if (var0 <= 5) {
                  bx[var0] = null;
                  by[var0] = false;
                  bz[var0] = false;
                  ca[var0] = false;
                  cb[var0] = 0.0F;
                  cc[var0] = 0.0F;
                  cl[var0] = 0.0F;
                  cm[var0] = 0.0F;
                  cn[var0] = 0.0F;
                  var0++;
                  var1 = 7;
                  break;
               }
            case 6:
               var0 = 0;
               var1 = 2;
               break;
            case 8:
               if (var0 < 16) {
                  dd[var0] = null;
                  var0++;
                  var1 = 8;
                  break;
               }
            case 3:
               var0 = 0;
               var1 = 1;
         }
      }

      dv = 0.0F;
      du = 0.0F;
      dt = 0.0F;
      dk = false;
      dj = false;
      di = false;
      dh = false;
      dg = false;
      df = false;
      eo = -1;
      eq = -1;
      ep = 0.0;
   }

   public static void q() {

      if (RegionPassCache.PV) {
         MinecraftClient var0 = MinecraftClient.getInstance();
         int var1 = RegionPassCache.bt;
         boolean var2 = (var1 & 1) != 0 && RegionPassCache.ah;
         boolean var3 = (var1 & 2) != 0;
         if (!(dt > 0.0F)) {
            cb[5] = 0.0F;
            cc[5] = 1.0F;
            ca[5] = false;
         }

         by[5] = var2;
         if (var2 || cb[5] > 0.0F) {
            f(5, var0);
         }

         if (!(dv > 0.0F)) {
            ct[21] = 0.0F;
            cu[21] = 1.0F;
            var3 = false;
         }

         cs[21] = var3;
         if (var3 || ct[21] > 0.0F) {
            o(21, var0);
         }
      }
   }

   public static void r() {

      bx[5] = null;
      by[5] = false;
      bz[5] = false;
      ca[5] = false;
      cb[5] = 0.0F;
      cc[5] = 1.0F;
      cd[5] = RegionPassCache.pvH;
      ci[5] = RegionPassCache.bp;
      cj[5] = RegionPassCache.pvH;
      ck[5] = 0.6F;
      cl[5] = 0.0F;
      cm[5] = 0.0F;
      cn[5] = 0.0F;
      cr[21] = null;
      cs[21] = false;
      ct[21] = 0.0F;
      cu[21] = 1.0F;
      cw[21] = 0.0F;
   }

   static {
      float[] var0 = new float[]{128.0F, 150.0F, 172.0F, 196.0F, 222.0F, 250.0F};

      for (int var1 = 0; var1 < 6; var1++) {
         ad[var1] = (float)Math.cos(Math.toRadians((double)var0[var1]));
         ae[var1] = (float)Math.sin(Math.toRadians((double)var0[var1]));
      }

      float var22 = 0.7F;
      float[] var2 = new float[]{0.03F, 0.0F, 0.2F, 0.16F, 0.44F, 0.29F, 0.68F, 0.31F, 0.94F, 0.25F};

      for (int var3 = 0; var3 < 10; var3++) {
         WB[var3] = var2[var3] * var22;
      }

      float[][] var23 = new float[][]{
         {0.0F, 9.0F, 0.04F, 0.5F, -97.0F, -81.0F, -0.012F},
         {1.0F, 10.0F, 0.52F, 0.98F, -79.0F, -7.0F, -0.01F},
         {2.0F, 12.0F, 0.05F, 0.67F, -95.0F, -69.0F, -0.035F},
         {3.0F, 6.0F, 0.66F, 0.96F, -62.0F, -12.0F, -0.02F},
         {4.0F, 10.0F, 0.04F, 0.66F, -92.0F, -70.0F, -0.02F},
         {5.0F, 9.0F, 0.02F, 0.54F, -86.0F, -72.0F, 0.005F},
         {6.0F, 3.0F, 0.5F, 0.54F, 8.0F, -4.0F, 0.01F}
      };
      int var4 = 0;

      for (float[] var8 : var23) {
         int var9 = (int)var8[0];
         int var10 = (int)var8[1];

         for (int var11 = 0; var11 < var10; var11++) {
            float var12 = var10 > 1 ? (float)var11 / (float)(var10 - 1) : 0.0F;
            float var13 = var8[2] + (var8[3] - var8[2]) * var12;
            float var14 = var13 * 4.0F;
            int var15 = Math.min(3, (int)var14);
            float var16 = var14 - (float)var15;
            float var17 = var2[var15 * 2] + (var2[var15 * 2 + 2] - var2[var15 * 2]) * var16;
            float var18 = var2[var15 * 2 + 1] + (var2[var15 * 2 + 3] - var2[var15 * 2 + 1]) * var16;
            float var19 = var9 == 1 ? var8[4] + (var8[5] - var8[4]) * (float)Math.pow((double)var12, 1.15) : var8[4] + (var8[5] - var8[4]) * var12;
            float var20;
            float var21;
            switch (var9) {
               case 0:
                  var20 = 0.5F + 0.08F * (float)Math.sin(Math.PI * (double)(var11 + 1) / (double)(var10 + 1)) + 0.02F * var12;
                  var21 = 0.072F;
                  break;
               case 1:
                  var20 = 0.6F + 0.26F * (float)Math.sin((Math.PI / 2) * (double)Math.min(1.0F, var12 * 1.15F)) - (var11 == var10 - 1 ? 0.06F : 0.0F);
                  var21 = 0.074F - 0.018F * var12;
                  break;
               case 2:
                  var20 = 0.27F + 0.03F * var12;
                  var21 = 0.066F;
                  break;
               case 3:
                  var20 = 0.24F - 0.04F * var12;
                  var21 = 0.058F;
                  break;
               case 4:
                  var20 = 0.155F;
                  var21 = 0.056F;
                  break;
               case 5:
                  var20 = 0.095F;
                  var21 = 0.048F;
                  break;
               default:
                  var20 = 0.15F - 0.025F * (float)var11;
                  var21 = 0.04F;
            }

            WF_R[var4] = (byte)var9;
            WF_X[var4] = var17 * var22;
            WF_Y[var4] = (var18 + var8[6]) * var22;
            WF_L[var4] = var20 * var22;
            WF_W[var4] = var21 * var22;
            WF_A[var4] = (float)Math.toRadians((double)var19);
            WF_DX[var4] = (float)Math.cos((double)WF_A[var4]);
            WF_DY[var4] = (float)Math.sin((double)WF_A[var4]);
            var4++;
         }
      }

      ap[0] = Math.toRadians(55.0);
      ap[1] = Math.toRadians(-40.0);
      aq[0] = 0.0;
      aq[1] = Math.toRadians(60.0);
      ar[0] = Math.cos(Math.toRadians(15.0));
      as[0] = Math.sin(Math.toRadians(15.0));
      ar[1] = Math.cos(Math.toRadians(-22.0));
      as[1] = Math.sin(Math.toRadians(-22.0));

      for (int var24 = 0; var24 < 48; var24++) {
         double var26 = (Math.PI * 2) * (double)var24 / 48.0;
         double var30 = (Math.PI * 2) * ((double)var24 + 0.5) / 48.0;
         au[var24] = (float)Math.cos(var26);
         av[var24] = (float)Math.sin(var26);
         aw[var24] = (float)Math.cos(var30);
         ax[var24] = (float)Math.sin(var30);
      }

      au[48] = au[0];
      av[48] = av[0];
      int var25 = 625341585;

      for (int var27 = 0; var27 < 150; var27++) {
         float[] var29 = new float[8];

         for (int var31 = 0; var31 < 8; var31++) {
            var25 = var25 * 1664525 + 1013904223;
            var29[var31] = (float)(var25 >>> 8) * 5.9604645E-8F;
         }

         bb[var27] = (float) (Math.PI * 2) * var29[0];
         bc[var27] = 0.6F + 0.55F * var29[1];
         bd[var27] = var29[2];
         be[var27] = 0.16F + 0.2F * var29[3];
         bf[var27] = (var29[4] < 0.8F ? 1.0F : -0.6F) * (0.55F + 0.75F * var29[5]);
         bg[var27] = 2.5F + 6.5F * var29[6];
         bh[var27] = (float) (Math.PI * 2) * var29[7];
         bi[var27] = 0.7F + 0.6F * var29[var27 * 5 & 7] * var29[var27 * 3 + 1 & 7];
      }

      for (int var28 = 0; var28 < br.length; var28++) {
         br[var28] = -1.0;
      }

      bx = new LivingEntity[6];
      by = new boolean[6];
      bz = new boolean[6];
      ca = new boolean[6];
      cb = new float[6];
      cc = new float[6];
      cd = new float[6];
      ce = new double[6];
      cf = new double[6];
      cg = new double[6];
      ch = new float[36];
      ci = new float[6];
      cj = new float[6];
      ck = new float[6];
      cl = new float[6];
      cm = new float[6];
      cn = new float[6];
      cr = new PlayerEntity[22];
      cs = new boolean[22];
      ct = new float[22];
      cu = new float[22];
      cv = new float[22];
      cw = new float[22];
      cx = new float[22];
      cy = new float[22];
      cz = new float[22];
      da = new double[22];
      db = new double[22];
      dc = new double[22];
      dd = new PlayerEntity[16];
      de = new double[16];
      dl = new float[]{0.3F, 0.35F, 0.5F, 0.6F};
      dx = new float[7];
      eo = -1;
      eq = -1;
   }
}
