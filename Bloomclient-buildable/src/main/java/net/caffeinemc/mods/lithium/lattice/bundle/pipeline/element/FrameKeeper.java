package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.element;

public final class FrameKeeper {
   public static final int S_POP = 5;
   public static final int S_SEARCH = 6;
   public static final int S_EJECT = 7;
   public static final int S_HDL = 8;
   public static final int S_MODAL = 9;
   public static final int S_NUM = 10;
   public static final int S_HDC = 11;
   public static final int S_HDR = 12;
   public static final int NS = 13;
   public static final int HEAD_MASK = 6400;
   public static volatile boolean ag;
   public static boolean ah;
   public static final float[] PROJ = new float[16];
   public static final float[] VIEW = new float[16];
   public static boolean ai;
   public static double aj;
   public static double ak = 1.62;
   public static double al;
   public static float yaw;
   public static float am;
   public static float an = 70.0F;
   public static final float[] PV = new float[26];
   public static final boolean[] PLANE = new boolean[13];
   public static final float[] PAD = new float[13];
   public static final boolean[] BACK_BLOCK = new boolean[13];
   public static final float[] ao = new float[13];
   public static final float NEAR_FADE = 0.3F;
   public static final float NEAR_HIT = 0.25F;
   public static final float ROW_D = 2.5F;
   public static float ap;
   public static float aq;
   public static float ar;
   public static float as;
   public static boolean at;
   public static float au;
   public static float av;
   private static float aw;
   private static float az;
   private static float ba;
   public static final float SAG3 = 0.12F;
   public static final float[] DYN;
   public static final boolean[] PHYS;
   public static final float[] PMUL;
   public static final float[] PDIST;
   private static final float[] bb;
   public static int bc;
   public static final float[] HIT;
   private static float bd;
   private static float be;
   private static float bf;
   private static float bg;
   private static float bh;
   private static float bi;
   private static float bj;
   private static float bk;
   private static float bl;
   private static float bm;
   private static float bn;
   private static float bo;
   private static float bp;
   private static float bq;
   private static float br;
   private static float bs;
   public static float px;
   public static float py;
   public static float pz;
   public static float ppb;
   public static boolean bt;
   public static final float[] m00;
   public static final float[] m01;
   public static final float[] m10;
   public static final float[] m11;
   public static final float[] tx;
   public static final float[] ty;
   public static final float[] ax;
   public static final float[] ay;
   public static final float[] sc;
   public static final float[] dep;
   public static final float[] bu;
   public static final float[] bv;
   public static final float[] lx0;
   public static final float[] ly0;
   public static final float[] lw;
   public static final float[] lh;
   public static final boolean[] vis;
   public static final boolean[] bw;
   private static final boolean[] bx;
   public static final float[] bx0;
   public static final float[] by0;
   public static final float[] bx1;
   public static final float[] by1;
   private static final float[] by;
   private static final float[] bz;
   private static final float[] ca;
   private static final float[] cb;
   private static final float[] cc;
   public static final boolean[] cd;
   private static final float[] ce;
   public static final int NB = 512;
   public static final int PK_MAX = 10;
   public static final float PK_ERR = 0.35F;
   public static final float CUT_TOL = 0.5F;
   public static int pk0;
   public static final float[] PKX;
   public static final float[] TB;
   public static final int[] TN;
   private static final boolean[] cf;
   public static boolean cg;
   public static final int PM_LSQ = 0;
   public static final int PM_TOP = 1;
   public static final int PM_BOT = 2;
   public static int ch;
   private static final byte[] ci;
   public static float b00;
   public static float b01;
   public static float b10;
   public static float b11;
   public static float btx;
   public static float bty;
   public static int bmx;
   public static int bmy;
   public static boolean cj;
   public static int ptrS;
   public static float ptrX;
   public static float ptrY;
   private static int ck;
   private static int cl;
   private static int cm;
   private static float cn;
   private static float co;
   private static float cp;
   private static float cq;
   private static boolean cr;
   public static final float REF_DIST = 2.0F;
   public static float cs;
   public static float ct;
   public static float cu;
   public static final float FAR = 48.0F;
   public static final float NEAR_D = 0.08F;
   public static final float SIZE_EXP = 0.6F;
   public static final float DET_IN = 0.05F;
   public static final float DET_OUT = 0.15F;
   public static final float SEAM = 0.5F;
   public static final float[] cv;
   public static final float[] cw;
   public static final boolean[] cx;

   private FrameKeeper() {
   }

   private static void a(int var0, float var1, float var2) {

      PV[var0 * 2] = var1;
      PV[var0 * 2 + 1] = var2;
   }

   private static void b(float var0, float var1) {

      float var2 = (float)Math.cos((double)ar);
      float var3 = (float)Math.sin((double)ar);
      if (av > 0.0F && au > 0.1F) {
         float var4 = 0.4F * ct * var1;
         float var5 = Math.max(au / av, var4 * var4 / (0.24F * au));
         float var6 = var0 / var5;
         float var7 = (float)Math.sin((double)var6);
         float var8 = (float)Math.cos((double)var6);
         aw = ap + var3 * var5 + var5 * (-var7 * var2 - var8 * var3);
         az = aq - var2 * var5 + var5 * (-var7 * var3 + var8 * var2);
         ba = (float) Math.PI - ar - var6;
      } else {
         aw = ap - var2 * var0;
         az = aq - var3 * var0;
         ba = (float) Math.PI - ar;
      }
   }

   public static void c(double var0, double var2, double var4, float var6, float var7, float var8) {

      float var9 = (float)Math.toRadians((double)var6);
      ap = (float)(var0 - Math.sin((double)var9) * (double)var8);
      aq = (float)(var4 + Math.cos((double)var9) * (double)var8);
      ar = var9;
      as = (float)var2 + var7;
      au = var8;
      at = true;
   }

   public static float d() {

      float var0 = (float)(aj - (double)ap);
      float var1 = (float)(ak - (double)as);
      float var2 = (float)(al - (double)aq);
      return var0 * var0 + var1 * var1 + var2 * var2;
   }

   public static void e(int var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7) {

      b(var6 * var5, var5);
      q(var0, var1, var2, var3, var4, var5, aw, var7, az, ba);
      if (av > 0.0F && vis[var0]) {
         int var8 = var0 * 3;
         float var9 = var1 + var3 * 0.5F;
         float var10 = var2 + var4 * 0.5F;
         float var11 = by[var8] + var9 * bz[var0 * 2] - (float)aj;
         float var12 = by[var8 + 1] - var10 * ca[var0] - (float)ak;
         float var13 = by[var8 + 2] + var9 * bz[var0 * 2 + 1] - (float)al;
         dep[var0] = (float)Math.sqrt((double)(var11 * var11 + var12 * var12 + var13 * var13));
      }
   }

   public static int f() {

      float var0 = (float)((double)ap - aj);
      float var1 = (float)((double)as - ak);
      float var2 = (float)((double)aq - al);
      return var0 * bh + var1 * bi + var2 * bj + bk >= 0.0F ? 1 : -1;
   }

   public static float g(int var0, float var1, float var2, float var3) {

      b(var1 * var2, var2);
      float var4 = aw;
      float var5 = az;
      DYN[var0 * 3] = var4;
      DYN[var0 * 3 + 1] = var3;
      DYN[var0 * 3 + 2] = var5;
      float var6 = (float)((double)var4 - aj);
      float var7 = (float)((double)var3 - ak);
      float var8 = (float)((double)var5 - al);
      return (float)Math.sqrt((double)(var6 * var6 + var7 * var7 + var8 * var8));
   }

   public static int h(int var0) {

      if (vis[var0] && bx1[var0] > 0.0F && bx0[var0] < br && by1[var0] > 0.0F && by0[var0] < bs) {
         return 0;
      } else {
         float var1 = (float)((double)DYN[var0 * 3] - aj);
         float var2 = (float)((double)DYN[var0 * 3 + 1] - ak);
         float var3 = (float)((double)DYN[var0 * 3 + 2] - al);
         float var4 = var1 * bh + var2 * bi + var3 * bj + bk;
         return var4 >= 0.0F ? 1 : -1;
      }
   }

   public static void i(int var0, float[] var1) {

      System.arraycopy(ce, var0 * 9, var1, 0, 9);
      var1[9] = 0.5F * br / (bp * bq);
      var1[10] = 0.5F * bs / bp;
      var1[11] = br * 0.5F;
      var1[12] = bs * 0.5F;
   }

   public static void j(int var0, float var1) {

      float var2 = (float)Math.sqrt((double)(bd * bd + be * be + bf * bf));
      float var3 = var2 > 1.0E-6F ? var1 / var2 : 0.0F;
      DYN[var0 * 3] = (float)(aj + (double)(bd * var3));
      DYN[var0 * 3 + 1] = (float)(ak + (double)(be * var3));
      DYN[var0 * 3 + 2] = (float)(al + (double)(bf * var3));
   }

   public static void k(int var0, int var1, int var2) {

      if (var0 >= 0 && var0 < 13 && PLANE[var0] && vis[var0]) {
         HIT[0] = by[var0 * 3] + ((float)var1 + 0.5F) * bz[var0 * 2];
         HIT[1] = by[var0 * 3 + 1] - ((float)var2 + 0.5F) * ca[var0];
         HIT[2] = by[var0 * 3 + 2] + ((float)var1 + 0.5F) * bz[var0 * 2 + 1];
         bc = var0;
      } else {
         bc = -1;
      }
   }

   public static void l(int var0, int var1, float var2) {

      float var3;
      float var4;
      float var5;
      if (var1 >= 0 && var1 < 13 && var1 == bc && PLANE[var1]) {
         var3 = HIT[0];
         var4 = HIT[1];
         var5 = HIT[2];
      } else if (var1 >= 0 && var1 < 13 && PLANE[var1]) {
         var3 = bb[var1 * 3];
         var4 = bb[var1 * 3 + 1];
         var5 = bb[var1 * 3 + 2];
      } else {
         if (var1 < 0 || var1 >= 13) {
            j(var0, 1.9F);
            return;
         }

         var3 = DYN[var1 * 3];
         var4 = DYN[var1 * 3 + 1];
         var5 = DYN[var1 * 3 + 2];
      }

      float var6 = (float)ak - 0.62F;
      float var7 = (float)ak + 0.48F;
      var4 = var4 < var6 ? var6 : (var4 > var7 ? var7 : var4);
      float var8 = (float)(aj - (double)var3);
      float var9 = (float)(ak - (double)var4);
      float var10 = (float)(al - (double)var5);
      float var11 = (float)Math.sqrt((double)(var8 * var8 + var9 * var9 + var10 * var10));
      if (var11 > 0.001F) {
         float var12 = Math.min(var2, var11 * 0.5F) / var11;
         var3 += var8 * var12;
         var4 += var9 * var12;
         var5 += var10 * var12;
      }

      DYN[var0 * 3] = var3;
      DYN[var0 * 3 + 1] = var4;
      DYN[var0 * 3 + 2] = var5;
   }

   public static void m(float var0, float var1, float var2) {

      br = var0 > 1.0F ? var0 : 1.0F;
      bs = var1 > 1.0F ? var1 : 1.0F;
      bt = ai && n();
      if (!bt) {
         bq = var2 > 0.0F ? var2 : br / bs;
         double var3 = Math.toRadians((double)yaw);
         double var5 = Math.toRadians((double)am);
         float var7 = (float)Math.sin(var3);
         float var8 = (float)Math.cos(var3);
         float var9 = (float)Math.sin(var5);
         float var10 = (float)Math.cos(var5);
         bd = -var7 * var10;
         be = -var9;
         bf = var8 * var10;
         bh = -var8;
         bi = 0.0F;
         bj = -var7;
         bl = -bj * be;
         bm = bj * bd - bh * bf;
         bn = bh * be;
         bk = 0.0F;
         bo = 0.0F;
         bg = 0.0F;
         bp = (float)Math.tan(Math.toRadians((double)Math.max(1.0F, Math.min(170.0F, an))) * 0.5);
      }

      ck++;
   }

   private static boolean n() {

      float[] var0 = PROJ;
      float[] var1 = VIEW;
      float var2 = 0.0F;
      float var3 = 0.0F;
      float var4 = 0.0F;
      float var5 = 0.0F;
      float var6 = 0.0F;
      float var7 = 0.0F;
      float var8 = 0.0F;
      float var9 = 0.0F;
      float var10 = 0.0F;
      float var11 = 0.0F;
      float var12 = 0.0F;
      float var13 = 0.0F;

      for (int var14 = 0; var14 < 4; var14++) {
         int var15 = var14 * 4;
         float var16 = var1[var15];
         float var17 = var1[var15 + 1];
         float var18 = var1[var15 + 2];
         float var19 = var1[var15 + 3];
         float var20 = var0[0] * var16 + var0[4] * var17 + var0[8] * var18 + var0[12] * var19;
         float var21 = var0[1] * var16 + var0[5] * var17 + var0[9] * var18 + var0[13] * var19;
         float var22 = var0[3] * var16 + var0[7] * var17 + var0[11] * var18 + var0[15] * var19;
         if (var14 == 0) {
            var2 = var20;
            var6 = var21;
            var10 = var22;
         } else if (var14 == 1) {
            var3 = var20;
            var7 = var21;
            var11 = var22;
         } else if (var14 == 2) {
            var4 = var20;
            var8 = var21;
            var12 = var22;
         } else {
            var5 = var20;
            var9 = var21;
            var13 = var22;
         }
      }

      float var23 = (float)Math.sqrt((double)(var2 * var2 + var3 * var3 + var4 * var4));
      float var24 = (float)Math.sqrt((double)(var6 * var6 + var7 * var7 + var8 * var8));
      float var25 = (float)Math.sqrt((double)(var10 * var10 + var11 * var11 + var12 * var12));
      if (var23 > 1.0E-6F && var24 > 1.0E-6F && var25 > 1.0E-6F && !(var23 > 1000000.0F) && !(var24 > 1000000.0F)) {
         bh = var2 / var23;
         bi = var3 / var23;
         bj = var4 / var23;
         bk = var5 / var23;
         bl = var6 / var24;
         bm = var7 / var24;
         bn = var8 / var24;
         bo = var9 / var24;
         bd = var10;
         be = var11;
         bf = var12;
         bg = var13;
         bp = 1.0F / var24;
         bq = var24 / var23;
         return true;
      } else {
         return false;
      }
   }

   public static float o(float var0) {

      if (!(var0 > 0.0F)) {
         return 0.0F;
      } else {
         float var1 = (float)Math.pow((double)var0, 0.6F);
         float var2 = var1 - 1.0F;
         float var3 = var2 < 0.0F ? -var2 : var2;
         if (var3 < 0.05F) {
            return 1.0F;
         } else if (var3 < 0.15F) {
            float var4 = (var3 - 0.05F) / 0.10000001F;
            return 1.0F + var2 * var4 * var4 * (3.0F - 2.0F * var4);
         } else {
            return var1;
         }
      }
   }

   public static void p(int var0, float var1, float var2, float var3, float var4, float var5) {

      vis[var0] = false;
      bw[var0] = true;
      ao[var0] = 1.0F;
      bx[var0] = true;
      cd[var0] = false;
      float var6 = (float)((double)DYN[var0 * 3] - aj);
      float var7 = (float)((double)DYN[var0 * 3 + 1] - ak);
      float var8 = (float)((double)DYN[var0 * 3 + 2] - al);
      float var9 = var6 * bd + var7 * be + var8 * bf + bg;
      if (var9 >= 0.05F && !(var9 > 48.0F)) {
         float var10 = var6 * bh + var7 * bi + var8 * bj + bk;
         float var11 = var6 * bl + var7 * bm + var8 * bn + bo;
         px = (var10 / (var9 * bp * bq) * 0.5F + 0.5F) * br;
         py = (0.5F - var11 / (var9 * bp) * 0.5F) * bs;
         pz = var9;
         ppb = bs * 0.5F / (var9 * bp);
         float var12 = (float)Math.sqrt((double)(var6 * var6 + var7 * var7 + var8 * var8));
         float var13 = var5 > 0.0F ? bs * 0.5F / (Math.max(var12, var9) * bp) * cs / var5 : 0.0F;
         boolean var14 = PHYS[var0];
         float var15 = 0.0F;
         if (var5 > 0.0F && var14) {
            var15 = var5 * var13 * PMUL[var0];
            float var16 = PDIST[var0];
            if (var16 > 0.0F && var12 > 0.05F) {
               float var17 = var16 / var12 - 1.0F;
               float var18 = var17 < 0.0F ? -var17 : var17;
               float var19 = var18 < 0.05F ? 0.0F : (var18 < 0.15F ? (var18 - 0.05F) / 0.10000001F : 1.0F);
               var15 = var15 / (1.0F + var17) * (1.0F + var17 * var19 * var19 * (3.0F - 2.0F * var19));
            }
         } else if (var5 > 0.0F) {
            var15 = var5 * o(var13);
         }

         float var20 = Math.min(var5 * (var14 ? 4.0F : 1.35F), Math.min(0.94F * br / Math.max(1.0F, var3), 0.9F * bs / Math.max(1.0F, var4)));
         if (var15 > var20) {
            var15 = var20;
         }

         if (var15 > 0.0F) {
            float var21 = var1 + var3 * PV[var0 * 2];
            float var22 = var2 + var4 * PV[var0 * 2 + 1];
            bu[var0] = var21;
            bv[var0] = var22;
            lx0[var0] = var1;
            ly0[var0] = var2;
            lw[var0] = var3;
            lh[var0] = var4;
            ax[var0] = px;
            ay[var0] = py;
            sc[var0] = var15;
            dep[var0] = var9;
            m00[var0] = var15;
            m01[var0] = 0.0F;
            m10[var0] = 0.0F;
            m11[var0] = var15;
            tx[var0] = px - var15 * var21;
            ty[var0] = py - var15 * var22;
            bx0[var0] = tx[var0] + var15 * var1;
            by0[var0] = ty[var0] + var15 * var2;
            bx1[var0] = bx0[var0] + var15 * var3;
            by1[var0] = by0[var0] + var15 * var4;
            vis[var0] = true;
         }
      }
   }

   public static void q(int var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9) {

      vis[var0] = false;
      bw[var0] = true;
      bx[var0] = false;
      cd[var0] = false;
      ao[var0] = 0.0F;
      if (var3 > 0.0F && var4 > 0.0F && var5 > 0.0F) {
         float var10 = var1 + var3 * PV[var0 * 2];
         float var11 = var2 + var4 * PV[var0 * 2 + 1];
         bu[var0] = var10;
         bv[var0] = var11;
         lx0[var0] = var1;
         ly0[var0] = var2;
         lw[var0] = var3;
         lh[var0] = var4;
         int var12 = var0 * 3;
         bb[var12] = var6;
         bb[var12 + 1] = var7;
         bb[var12 + 2] = var8;
         float var13 = (float)Math.cos((double)var9);
         float var14 = (float)Math.sin((double)var9);
         float var15 = var13 * var5;
         float var16 = -var14 * var5;
         by[var12] = var6 - var10 * var15;
         by[var12 + 1] = var7 + var11 * var5;
         by[var12 + 2] = var8 - var10 * var16;
         bz[var0 * 2] = var15;
         bz[var0 * 2 + 1] = var16;
         ca[var0] = var5;
         float var17 = 0.5F * br / (bp * bq);
         float var18 = 0.5F * bs / bp;
         float var19 = (float)((double)by[var12] - aj);
         float var20 = (float)((double)by[var12 + 1] - ak);
         float var21 = (float)((double)by[var12 + 2] - al);
         int var22 = var0 * 9;
         ce[var22] = var19 * bh + var20 * bi + var21 * bj + bk;
         ce[var22 + 1] = var15 * bh + var16 * bj;
         ce[var22 + 2] = -var5 * bi;
         ce[var22 + 3] = var19 * bl + var20 * bm + var21 * bn + bo;
         ce[var22 + 4] = var15 * bl + var16 * bn;
         ce[var22 + 5] = -var5 * bm;
         ce[var22 + 6] = var19 * bd + var20 * be + var21 * bf + bg;
         ce[var22 + 7] = var15 * bd + var16 * bf;
         ce[var22 + 8] = -var5 * be;
         float var23 = 0.0F;
         float var24 = Float.MAX_VALUE;

         for (int var25 = 0; var25 < 4; var25++) {
            float var26 = (var25 & 1) != 0 ? var1 + var3 : var1;
            float var27 = (var25 & 2) != 0 ? var2 + var4 : var2;
            float var28 = ce[var22 + 6] + var26 * ce[var22 + 7] + var27 * ce[var22 + 8];
            if (!(var28 >= 0.08F)) {
               return;
            }

            var23 += var28;
            var24 = var28 < var24 ? var28 : var24;
            cb[var25] = br * 0.5F + (ce[var22] + var26 * ce[var22 + 1] + var27 * ce[var22 + 2]) / var28 * var17;
            cc[var25] = bs * 0.5F - (ce[var22 + 3] + var26 * ce[var22 + 4] + var27 * ce[var22 + 5]) / var28 * var18;
         }

         float var40 = var23 * 0.25F;
         if (!(var40 > 48.0F)) {
            float var41 = 1.0F / var3;
            float var42 = 1.0F / var4;
            float var43 = (cb[1] - cb[0] + (cb[3] - cb[2])) * 0.5F * var41;
            float var29 = (cc[1] - cc[0] + (cc[3] - cc[2])) * 0.5F * var41;
            float var30 = (cb[2] - cb[0] + (cb[3] - cb[1])) * 0.5F * var42;
            float var31 = (cc[2] - cc[0] + (cc[3] - cc[1])) * 0.5F * var42;
            if (!((Math.abs(var43) + Math.abs(var29)) * var3 < 1.5F) && !((Math.abs(var30) + Math.abs(var31)) * var4 < 1.5F)) {
               float var32 = var43 * var31 - var30 * var29;
               if (Math.abs(var32) > 1.0E-9F) {
                  float var33 = (cb[0] + cb[1] + cb[2] + cb[3]) * 0.25F;
                  float var34 = (cc[0] + cc[1] + cc[2] + cc[3]) * 0.25F;
                  float var35 = var1 + var3 * 0.5F;
                  float var36 = var2 + var4 * 0.5F;
                  float var37 = var33 - var43 * var35 - var30 * var36;
                  float var38 = var34 - var29 * var35 - var31 * var36;
                  m00[var0] = var43;
                  m01[var0] = var29;
                  m10[var0] = var30;
                  m11[var0] = var31;
                  tx[var0] = var37;
                  ty[var0] = var38;
                  sc[var0] = (float)Math.sqrt((double)Math.abs(var32));
                  dep[var0] = var40;
                  bw[var0] = var32 > 0.0F;
                  ax[var0] = var37 + var43 * var10 + var30 * var11;
                  ay[var0] = var38 + var29 * var10 + var31 * var11;
                  bx0[var0] = Math.min(Math.min(cb[0], cb[1]), Math.min(cb[2], cb[3]));
                  bx1[var0] = Math.max(Math.max(cb[0], cb[1]), Math.max(cb[2], cb[3]));
                  by0[var0] = Math.min(Math.min(cc[0], cc[1]), Math.min(cc[2], cc[3]));
                  by1[var0] = Math.max(Math.max(cc[0], cc[1]), Math.max(cc[2], cc[3]));
                  cd[var0] = true;
                  vis[var0] = true;
                  float var39 = (var24 - 0.08F) / 0.3F;
                  ao[var0] = var39 >= 1.0F ? 1.0F : (var39 <= 0.0F ? 0.0F : var39 * var39 * (3.0F - 2.0F * var39));
                  r(var0, 0, Math.min(TN[var0], 900903668 ^ 900903156));
                  ck++;
               }
            }
         }
      }
   }

   private static void r(int var0, int var1, int var2) {

      assert var0 >= 0
         && var0 < 13
         && var1 >= 0
         && var1 <= var2
         && var2 <= (-656411112 ^ -656411624)
         && TB != null
         && TB.length == (882056185 ^ 881991673)
         && ci != null
         && ci.length == (-1752894523 ^ -1752897083)
         && cf != null
         && cf.length == (-615774926 ^ -615768270)
         && ce != null
         && ce.length == 117
         && TN != null
         && TN.length == 13
         && br > 0.0F
         && bs > 0.0F
         && bp > 0.0F
         && bq > 0.0F
         && PKX != null
         && PKX.length == 11
         && cb != null
         && cc != null
         && cb.length == 4
         && cc.length == 4
         && PV != null
         && PV.length == 26
         && PLANE != null
         && PLANE.length == 13
         && vis != null
         && vis.length == 13
         && bw != null
         && bw.length == 13
         && cd != null
         && cd.length == 13
         && by != null
         && by.length == 39 : "fitRange: bad strips";

      float var3 = 0.5F * br / (bp * bq);
      float var4 = 0.5F * bs / bp;
      int var5 = var0 * 9;
      float var6 = ce[var5];
      float var7 = ce[var5 + 1];
      float var8 = ce[var5 + 2];
      float var9 = ce[var5 + 3];
      float var10 = ce[var5 + 4];
      float var11 = ce[var5 + 5];
      float var12 = ce[var5 + 6];
      float var13 = ce[var5 + 7];
      float var14 = ce[var5 + 8];
      float var15 = br * 0.5F;
      float var16 = bs * 0.5F;

      try {
         for (int var17 = var1; var17 < var2; var17++) {
            int var18 = (var0 * (623795356 ^ 623795868) + var17) * 10;
            float var19 = TB[var18];
            float var20 = TB[var18 + 1];
            float var21 = TB[var18 + 2];
            float var22 = TB[var18 + 3];
            float var23 = var12 + var19 * var13 + var20 * var14;
            float var24 = var12 + var21 * var13 + var20 * var14;
            float var25 = var12 + var19 * var13 + var22 * var14;
            float var26 = var12 + var21 * var13 + var22 * var14;
            var23 = var23 > 0.08F ? var23 : 0.08F;
            var24 = var24 > 0.08F ? var24 : 0.08F;
            var25 = var25 > 0.08F ? var25 : 0.08F;
            var26 = var26 > 0.08F ? var26 : 0.08F;
            float var27 = var6 + var19 * var7 + var20 * var8;
            float var28 = var6 + var21 * var7 + var20 * var8;
            float var29 = var6 + var19 * var7 + var22 * var8;
            float var30 = var6 + var21 * var7 + var22 * var8;
            float var31 = var9 + var19 * var10 + var20 * var11;
            float var32 = var9 + var21 * var10 + var20 * var11;
            float var33 = var9 + var19 * var10 + var22 * var11;
            float var34 = var9 + var21 * var10 + var22 * var11;
            float var35 = var15 + var27 / var23 * var3;
            float var36 = var16 - var31 / var23 * var4;
            float var37 = var15 + var28 / var24 * var3;
            float var38 = var16 - var32 / var24 * var4;
            float var39 = var15 + var29 / var25 * var3;
            float var40 = var16 - var33 / var25 * var4;
            float var41 = var15 + var30 / var26 * var3;
            float var42 = var16 - var34 / var26 * var4;
            float var43 = var21 > var19 ? 1.0F / (var21 - var19) : 0.0F;
            float var44 = var22 > var20 ? 1.0F / (var22 - var20) : 0.0F;
            byte var45 = ci[var0 * (-2103712743 ^ -2103712231) + var17];
            if (var45 == 0) {
               float var46 = (var37 - var35 + (var41 - var39)) * 0.5F * var43;
               float var47 = (var38 - var36 + (var42 - var40)) * 0.5F * var43;
               float var48 = (var39 - var35 + (var41 - var37)) * 0.5F * var44;
               float var49 = (var40 - var36 + (var42 - var38)) * 0.5F * var44;
               float var50 = (var19 + var21) * 0.5F;
               float var51 = (var20 + var22) * 0.5F;
               TB[var18 + 4] = var46;
               TB[var18 + 5] = var47;
               TB[var18 + 6] = var48;
               TB[var18 + 7] = var49;
               TB[var18 + 8] = (var35 + var37 + var39 + var41) * 0.25F - var46 * var50 - var48 * var51;
               TB[var18 + 9] = (var36 + var38 + var40 + var42) * 0.25F - var47 * var50 - var49 * var51;
            } else {
               boolean var58 = (var39 - var35) * (var39 - var35) + (var40 - var36) * (var40 - var36)
                  >= (var41 - var37) * (var41 - var37) + (var42 - var38) * (var42 - var38);
               float var59 = (var58 ? var39 - var35 : var41 - var37) * var44;
               float var60 = (var58 ? var40 - var36 : var42 - var38) * var44;
               boolean var61 = var45 == 1;
               float var62 = (var61 ? var37 - var35 : var41 - var39) * var43;
               float var63 = (var61 ? var38 - var36 : var42 - var40) * var43;
               float var52 = var61 ? var20 : var22;
               TB[var18 + 4] = var62;
               TB[var18 + 5] = var63;
               TB[var18 + 6] = var59;
               TB[var18 + 7] = var60;
               TB[var18 + 8] = (var61 ? var35 : var39) - var62 * var19 - var59 * var52;
               TB[var18 + 9] = (var61 ? var36 : var40) - var63 * var19 - var60 * var52;
            }
         }
      } catch (RuntimeException var53) {
         throw var53;
      }
   }

   public static void s(int var0, int var1, int var2, int var3, int var4, int var5) {

      assert var0 >= 0
         && var0 < 13
         && var5 >= 1
         && var5 <= (2048188525 ^ 2048189037)
         && var3 > 0
         && var4 > 0
         && TB != null
         && TB.length == (-2121059098 ^ -2121125658)
         && ci != null
         && ci.length == (875174169 ^ 875168537)
         && cf != null
         && cf.length == (-858384834 ^ -858387394)
         && TN != null
         && TN.length == 13
         && ce != null
         && ce.length == 117
         && br > 0.0F
         && bs > 0.0F
         && bp > 0.0F
         && bq > 0.0F
         && PKX != null
         && PKX.length == 11
         && cb != null
         && cc != null
         && cb.length == 4
         && cc.length == 4
         && PV != null
         && PV.length == 26
         && PLANE != null
         && PLANE.length == 13
         && vis != null
         && vis.length == 13
         && bw != null
         && bw.length == 13
         && cd != null
         && cd.length == 13 : "plate" + "Bands: ba" + "d " + "plate";

      int var6 = TN[var0] < (-1122415078 ^ -1122415590) ? TN[var0] : -1682376039 ^ -1682375834;
      int var7 = var5 > (1716408170 ^ 1716407658) - var6 ? Math.max(1, (-1279010726 ^ -1279010214) - var6) : var5;

      try {
         for (int var8 = 0; var8 < var7; var8++) {
            int var9 = var2 + Math.round((float)(var4 * var8) / (float)var5);
            int var10 = var8 == var5 - 1 ? var2 + var4 : var2 + Math.round((float)(var4 * (var8 + 1)) / (float)var5);
            boolean var11 = var8 < (var5 + 1) / 2;
            int var12 = !var11 && var8 != 0 ? var9 - 1 : var9;
            int var13 = var11 && var8 < var5 - 1 ? var10 + 1 : var10;
            int var14 = var6 + var8;
            int var15 = (var0 * (-974077122 ^ -974077634) + var14) * 10;
            TB[var15] = (float)var1;
            TB[var15 + 1] = (float)var12;
            TB[var15 + 2] = (float)(var1 + var3);
            TB[var15 + 3] = (float)var13;
            cf[var0 * (-597757738 ^ -597757226) + var14] = true;
            ci[var0 * (-61041798 ^ -61042310) + var14] = (byte)(var5 == 1 ? 0 : (var11 ? 1 : 2));
         }
      } catch (RuntimeException var16) {
         throw var16;
      }

      TN[var0] = var6 + var7;
      r(var0, var6, var6 + var7);
      ck++;
   }

   public static void t(int var0, float var1, float var2, float var3, float var4) {

      int var5 = TN[var0];
      int var6 = var5 < (-2127866631 ^ -2127866119) ? var5 : 1422705567 ^ 1422705248;
      int var7 = (var0 * (1008999761 ^ 1009000273) + var6) * 10;
      TB[var7] = var1;
      TB[var7 + 1] = var2;
      TB[var7 + 2] = var3;
      TB[var7 + 3] = var4;
      cf[var0 * (872504183 ^ 872503671) + var6] = cg;
      ci[var0 * (1787224070 ^ 1787224582) + var6] = (byte)(ch != 1 && ch != 2 ? 0 : ch);
      r(var0, var6, var6 + 1);
      TN[var0] = var6 + 1;
      ck++;
      float var8 = TB[var7 + 4];
      float var9 = TB[var7 + 5];
      float var10 = TB[var7 + 6];
      float var11 = TB[var7 + 7];
      float var12 = TB[var7 + 8];
      float var13 = TB[var7 + 9];
      b00 = var8;
      b01 = var9;
      b10 = var10;
      b11 = var11;
      btx = var12;
      bty = var13;
      float var14 = var8 * var11 - var10 * var9;
      if (var0 == ptrS && Math.abs(var14) > 1.0E-9F) {
         float var15 = ptrX - var12;
         float var16 = ptrY - var13;
         bmx = (int)Math.floor((double)((var11 * var15 - var10 * var16) / var14));
         bmy = (int)Math.floor((double)((var8 * var16 - var9 * var15) / var14));
      } else {
         bmx = 1316755865 ^ -1904469607;
         bmy = 1418733760 ^ -1802491712;
      }

      float var23 = var12 + var8 * var1 + var10 * var2;
      float var24 = var12 + var8 * var3 + var10 * var2;
      float var17 = var12 + var8 * var1 + var10 * var4;
      float var18 = var12 + var8 * var3 + var10 * var4;
      float var19 = var13 + var9 * var1 + var11 * var2;
      float var20 = var13 + var9 * var3 + var11 * var2;
      float var21 = var13 + var9 * var1 + var11 * var4;
      float var22 = var13 + var9 * var3 + var11 * var4;
      cj = Math.max(Math.max(var23, var24), Math.max(var17, var18)) > -8.0F
         && Math.min(Math.min(var23, var24), Math.min(var17, var18)) < br + 8.0F
         && Math.max(Math.max(var19, var20), Math.max(var21, var22)) > -8.0F
         && Math.min(Math.min(var19, var20), Math.min(var21, var22)) < bs + 8.0F;
   }

   public static boolean fit(int var0, float var1, float var2, float var3, float var4) {

      if (var0 >= 0 && var0 < 13 && var3 > var1 && var4 > var2) {
         float var5 = 0.5F * br / (bp * bq);
         float var6 = 0.5F * bs / bp;
         float var7 = br * 0.5F;
         float var8 = bs * 0.5F;
         int var9 = var0 * 9;
         float var10 = ce[var9];
         float var11 = ce[var9 + 1];
         float var12 = ce[var9 + 2];
         float var13 = ce[var9 + 3];
         float var14 = ce[var9 + 4];
         float var15 = ce[var9 + 5];
         float var16 = ce[var9 + 6];
         float var17 = ce[var9 + 7];
         float var18 = ce[var9 + 8];
         float var19 = Math.max(0.08F, var16 + var1 * var17 + var2 * var18);
         float var20 = Math.max(0.08F, var16 + var3 * var17 + var2 * var18);
         float var21 = Math.max(0.08F, var16 + var1 * var17 + var4 * var18);
         float var22 = Math.max(0.08F, var16 + var3 * var17 + var4 * var18);
         float var23 = var7 + (var10 + var1 * var11 + var2 * var12) / var19 * var5;
         float var24 = var8 - (var13 + var1 * var14 + var2 * var15) / var19 * var6;
         float var25 = var7 + (var10 + var3 * var11 + var2 * var12) / var20 * var5;
         float var26 = var8 - (var13 + var3 * var14 + var2 * var15) / var20 * var6;
         float var27 = var7 + (var10 + var1 * var11 + var4 * var12) / var21 * var5;
         float var28 = var8 - (var13 + var1 * var14 + var4 * var15) / var21 * var6;
         float var29 = var7 + (var10 + var3 * var11 + var4 * var12) / var22 * var5;
         float var30 = var8 - (var13 + var3 * var14 + var4 * var15) / var22 * var6;
         float var31 = 1.0F / (var3 - var1);
         float var32 = 1.0F / (var4 - var2);
         float var33 = (var25 - var23 + (var29 - var27)) * 0.5F * var31;
         float var34 = (var26 - var24 + (var30 - var28)) * 0.5F * var31;
         float var35 = (var27 - var23 + (var29 - var25)) * 0.5F * var32;
         float var36 = (var28 - var24 + (var30 - var26)) * 0.5F * var32;
         float var37 = (var1 + var3) * 0.5F;
         float var38 = (var2 + var4) * 0.5F;
         b00 = var33;
         b01 = var34;
         b10 = var35;
         b11 = var36;
         btx = (var23 + var25 + var27 + var29) * 0.25F - var33 * var37 - var35 * var38;
         bty = (var24 + var26 + var28 + var30) * 0.25F - var34 * var37 - var36 * var38;
         return var33 * var36 - var35 * var34 > 1.0E-12F;
      } else {
         return false;
      }
   }

   public static int u(int var0, float var1, float var2, float var3, float var4) {

      float var5 = 0.5F * br / (bp * bq);
      float var6 = 0.5F * bs / bp;
      float var7 = br * 0.5F;
      int var8 = var0 * 9;
      float var9 = ce[var8];
      float var10 = ce[var8 + 1];
      float var11 = ce[var8 + 2];
      float var12 = ce[var8 + 3];
      float var13 = ce[var8 + 4];
      float var14 = ce[var8 + 5];
      float var15 = ce[var8 + 6];
      float var16 = ce[var8 + 7];
      float var17 = ce[var8 + 8];
      float var18 = (var1 + var3) * 0.5F;
      float var19 = (var2 + var4) * 0.5F;
      int var20 = 1;
      if (var3 > var1 && var4 > var2) {
         float var21 = Math.max(0.08F, var15 + var1 * var16 + var2 * var17);
         float var22 = Math.max(0.08F, var15 + var3 * var16 + var2 * var17);
         float var23 = Math.max(0.08F, var15 + var1 * var16 + var4 * var17);
         float var24 = Math.max(0.08F, var15 + var3 * var16 + var4 * var17);
         float var25 = Math.max(0.08F, var15 + var18 * var16 + var2 * var17);
         float var26 = Math.max(0.08F, var15 + var18 * var16 + var4 * var17);
         float var27 = (var9 + var1 * var10 + var2 * var11) / var21;
         float var28 = -(var12 + var1 * var13 + var2 * var14) / var21;
         float var29 = (var9 + var3 * var10 + var2 * var11) / var22;
         float var30 = -(var12 + var3 * var13 + var2 * var14) / var22;
         float var31 = (var9 + var1 * var10 + var4 * var11) / var23;
         float var32 = -(var12 + var1 * var13 + var4 * var14) / var23;
         float var33 = (var9 + var3 * var10 + var4 * var11) / var24;
         float var34 = -(var12 + var3 * var13 + var4 * var14) / var24;
         float var35 = (var9 + var18 * var10 + var2 * var11) / var25;
         float var36 = -(var12 + var18 * var13 + var2 * var14) / var25;
         float var37 = (var9 + var18 * var10 + var4 * var11) / var26;
         float var38 = -(var12 + var18 * var13 + var4 * var14) / var26;
         float var39 = (var35 - (var27 + var29) * 0.5F) * var5;
         float var40 = (var36 - (var28 + var30) * 0.5F) * var6;
         float var41 = (var37 - (var31 + var33) * 0.5F) * var5;
         float var42 = (var38 - (var32 + var34) * 0.5F) * var6;
         float var43 = (float)Math.sqrt((double)Math.max(var39 * var39 + var40 * var40, var41 * var41 + var42 * var42));
         float var44 = (var27 - var29 - var31 + var33) * var5;
         float var45 = (var28 - var30 - var32 + var34) * var6;
         float var46 = (float)Math.sqrt((double)(var44 * var44 + var45 * var45)) * 0.25F;

         while (var20 < 10 && (var43 > 0.35F * (float)var20 * (float)var20 || var46 > 0.35F * (float)var20)) {
            var20++;
         }
      }

      int var47 = TN[var0] < (-775020757 ^ -775021269) ? TN[var0] : -763433917 ^ -763433540;
      if (var20 > (-1654763318 ^ -1654762806) - var47) {
         var20 = Math.max(1, (1566679214 ^ 1566679726) - var47);
      }

      pk0 = var47;

      for (int var48 = 0; var48 < var20; var48++) {
         int var51 = (var0 * (2088595447 ^ 2088594935) + var47 + var48) * 10;
         TB[var51] = var48 == 0 ? var1 : var1 + (var3 - var1) * (float)var48 / (float)var20;
         TB[var51 + 1] = var2;
         TB[var51 + 2] = var48 == var20 - 1 ? var3 : var1 + (var3 - var1) * (float)(var48 + 1) / (float)var20;
         TB[var51 + 3] = var4;
         cf[var0 * (-1756435873 ^ -1756436385) + var47 + var48] = false;
         ci[var0 * (-1834594680 ^ -1834595192) + var47 + var48] = 0;
      }

      TN[var0] = var47 + var20;
      r(var0, var47, var47 + var20);
      ck++;

      for (int var49 = 0; var49 <= var20; var49++) {
         float var52 = var49 == var20 ? var3 : var1 + (var3 - var1) * (float)var49 / (float)var20;
         float var54 = Math.max(0.08F, var15 + var52 * var16 + var19 * var17);
         PKX[var49] = var7 + (var9 + var52 * var10 + var19 * var11) / var54 * var5;
      }

      bmx = 1561394219 ^ -1659831253;
      bmy = 1718219492 ^ -1503005980;
      if (var0 == ptrS) {
         float var50 = Float.MAX_VALUE;
         float var53 = 0.0F;
         float var55 = 0.0F;

         for (int var56 = 0; var56 < var20; var56++) {
            int var57 = (var0 * (458787526 ^ 458787014) + var47 + var56) * 10;
            float var58 = TB[var57 + 4];
            float var59 = TB[var57 + 5];
            float var60 = TB[var57 + 6];
            float var61 = TB[var57 + 7];
            float var62 = var58 * var61 - var60 * var59;
            if (Math.abs(var62) > 1.0E-9F) {
               float var63 = ptrX - TB[var57 + 8];
               float var64 = ptrY - TB[var57 + 9];
               float var65 = (var61 * var63 - var60 * var64) / var62;
               float var66 = (var58 * var64 - var59 * var63) / var62;
               float var67 = var65 < TB[var57] ? TB[var57] - var65 : (var65 >= TB[var57 + 2] ? var65 - TB[var57 + 2] : 0.0F);
               if (var67 < var50) {
                  var50 = var67;
                  var53 = var65;
                  var55 = var66;
               }
            }
         }

         if (var50 < Float.MAX_VALUE) {
            bmx = (int)Math.floor((double)var53);
            bmy = (int)Math.floor((double)var55);
         }
      }

      return var20;
   }

   public static int v(int var0, float var1, float var2, float var3, float var4) {

      assert vis != null
         && vis.length == 13
         && bw != null
         && bw.length == 13
         && cd != null
         && cd.length == 13
         && ao != null
         && ao.length == 13
         && dep != null
         && dep.length == 13
         && m00 != null
         && m00.length == 13
         && m01 != null
         && m01.length == 13
         && m10 != null
         && m10.length == 13
         && m11 != null
         && m11.length == 13
         && tx != null
         && tx.length == 13
         && ty != null
         && ty.length == 13
         && lx0 != null
         && lx0.length == 13
         && ly0 != null
         && ly0.length == 13
         && ce != null
         && ce.length == 117
         && cb.length == 4 : "pl" + "atePieces: bad boards";

      if (!cd[var0]) {
         return 1;
      } else {
         float var5 = 0.5F * br / (bp * bq);
         float var6 = 0.5F * bs / bp;
         int var7 = var0 * 9;

         try {
            for (int var8 = 0; var8 < 4; var8++) {
               float var9 = (var8 & 1) != 0 ? var3 : var1;
               float var10 = (var8 & 2) != 0 ? var4 : var2;
               float var11 = ce[var7 + 6] + var9 * ce[var7 + 7] + var10 * ce[var7 + 8];
               var11 = var11 > 0.08F ? var11 : 0.08F;
               cb[var8] = (ce[var7] + var9 * ce[var7 + 1] + var10 * ce[var7 + 2]) / var11 * var5;
               cc[var8] = -(ce[var7 + 3] + var9 * ce[var7 + 4] + var10 * ce[var7 + 5]) / var11 * var6;
            }
         } catch (RuntimeException var21) {
            throw var21;
         }

         float var22 = cb[0] - cb[1] - cb[2] + cb[3];
         float var23 = cc[0] - cc[1] - cc[2] + cc[3];
         if (var22 * var22 + var23 * var23 < 1.0F) {
            return 1;
         } else {
            float var24 = cb[2] - cb[0];
            float var26 = cc[2] - cc[0];
            float var12 = cb[3] - cb[1];
            float var13 = cc[3] - cc[1];
            float var14 = (float)Math.sqrt((double)(var24 * var24 + var26 * var26));
            float var15 = (float)Math.sqrt((double)(var12 * var12 + var13 * var13));
            float var16 = Math.min(var14, var15);
            float var17 = Math.max(var14, var15);
            if (!(var16 > 0.5F)) {
               return 24;
            } else {
               float var18 = var16 / var17;
               float var19 = Math.abs(var24 * var13 - var26 * var12) / (var14 * var15);
               int var20 = Math.max((int)Math.ceil((double)(2.0F * (1.0F - var18) / var18)), (int)Math.ceil((double)(var19 * var16 / 0.5F)));
               return var20 < 2 ? 2 : (var20 > 24 ? 24 : var20);
            }
         }
      }
   }

   private static boolean w(int var0, float var1, float var2) {

      if (cl == ck && cm == var0 && cn == var1 && co == var2) {
         return true;
      } else {
         assert var0 >= 0
            && var0 < 13
            && TB != null
            && TB.length == (-1346826764 ^ -1346893324)
            && ci != null
            && ci.length == (-714044425 ^ -714042889)
            && cf != null
            && cf.length == (50382106 ^ 50388762)
            && TN != null
            && TN.length == 13
            && TN[var0] >= 0
            && lx0 != null
            && ly0 != null
            && lw != null
            && lh != null
            && lx0.length == 13
            && ly0.length == 13
            && lw.length == 13
            && lh.length == 13
            && ce != null
            && ce.length == 117
            && br > 0.0F
            && bs > 0.0F
            && bp > 0.0F
            && bq > 0.0F
            && PKX != null
            && PKX.length == 11
            && cb != null
            && cc != null
            && cb.length == 4
            && cc.length == 4
            && PV != null
            && PV.length == 26
            && vis != null
            && vis.length == 13
            && bw != null
            && bw.length == 13 : "ba" + "ndHit: bad board";

         int var3 = Math.min(TN[var0], -739069937 ^ -739069425);
         float var4 = lx0[var0] + lw[var0];
         float var5 = ly0[var0] + lh[var0];
         boolean var6 = false;
         float var7 = 0.5F;
         float var8 = 0.0F;
         float var9 = 0.0F;
         boolean var10 = false;

         try {
            for (int var11 = var3 - 1; var11 >= 0; var11--) {
               boolean var12 = cf[var0 * (-488272688 ^ -488272176) + var11];
               if (!var6 || !var12) {
                  int var13 = (var0 * (2092652744 ^ 2092653256) + var11) * 10;
                  float var14 = TB[var13 + 4];
                  float var15 = TB[var13 + 5];
                  float var16 = TB[var13 + 6];
                  float var17 = TB[var13 + 7];
                  float var18 = var14 * var17 - var16 * var15;
                  if (var18 > 1.0E-9F) {
                     float var19 = var1 - TB[var13 + 8];
                     float var20 = var2 - TB[var13 + 9];
                     float var21 = (var17 * var19 - var16 * var20) / var18;
                     float var22 = (var14 * var20 - var15 * var19) / var18;
                     if (var21 >= lx0[var0] && var21 < var4 && var22 >= ly0[var0] && var22 < var5) {
                        if (var21 >= TB[var13] && var21 < TB[var13 + 2] && var22 >= TB[var13 + 1] && var22 < TB[var13 + 3]) {
                           cp = var21;
                           cq = var22;
                           cr = var12;
                           var6 = true;
                           if (!var12) {
                              break;
                           }
                        } else if (!var12) {
                           float var23 = var21 < TB[var13] ? TB[var13] - var21 : (var21 >= TB[var13 + 2] ? var21 - TB[var13 + 2] : 0.0F);
                           float var24 = var22 < TB[var13 + 1] ? TB[var13 + 1] - var22 : (var22 >= TB[var13 + 3] ? var22 - TB[var13 + 3] : 0.0F);
                           float var25 = var23 > var24 ? var23 : var24;
                           if (var25 < var7) {
                              var7 = var25;
                              var8 = var21;
                              var9 = var22;
                              var10 = true;
                           }
                        }
                     }
                  }
               }
            }
         } catch (RuntimeException var26) {
            throw var26;
         }

         if (var10 && (!var6 || cr)) {
            cp = var8;
            cq = var9;
            cr = false;
            var6 = true;
         }

         if (var6) {
            cl = ck;
            cm = var0;
            cn = var1;
            co = var2;
         }

         return var6;
      }
   }

   public static boolean x(int var0, float var1, float var2) {

      return var0 >= 0 && var0 < 13 && cd[var0] && w(var0, var1, var2) && cr;
   }

   public static void y(int var0, float var1) {

      float var2 = tx[var0] + m00[var0] * bu[var0] + m10[var0] * bv[var0];
      float var3 = ty[var0] + m01[var0] * bu[var0] + m11[var0] * bv[var0];
      m00[var0] = m00[var0] * var1;
      m01[var0] = m01[var0] * var1;
      m10[var0] = m10[var0] * var1;
      m11[var0] = m11[var0] * var1;
      sc[var0] = sc[var0] * var1;
      tx[var0] = var2 - (m00[var0] * bu[var0] + m10[var0] * bv[var0]);
      ty[var0] = var3 - (m01[var0] * bu[var0] + m11[var0] * bv[var0]);
      bx0[var0] = var2 + (bx0[var0] - var2) * var1;
      by0[var0] = var3 + (by0[var0] - var3) * var1;
      bx1[var0] = var2 + (bx1[var0] - var2) * var1;
      by1[var0] = var3 + (by1[var0] - var3) * var1;
   }

   public static void z(int var0, float var1) {

      if (bx[var0] && var1 > 0.0F) {
         tx[var0] = (float)Math.round(tx[var0] * var1) / var1;
         ty[var0] = (float)Math.round(ty[var0] * var1) / var1;
      }
   }

   public static int aa(int var0, float var1, float var2) {

      if (cd[var0] && w(var0, var1, var2)) {
         return (int)Math.floor((double)cp);
      } else {
         float var3 = m00[var0] * m11[var0] - m10[var0] * m01[var0];
         if (var3 == 0.0F) {
            return 390540764 ^ -683201060;
         } else {
            float var4 = var1 - tx[var0];
            float var5 = var2 - ty[var0];
            return (int)Math.floor((double)((m11[var0] * var4 - m10[var0] * var5) / var3));
         }
      }
   }

   public static int ab(int var0, float var1, float var2) {

      if (cd[var0] && w(var0, var1, var2)) {
         return (int)Math.floor((double)cq);
      } else {
         float var3 = m00[var0] * m11[var0] - m10[var0] * m01[var0];
         if (var3 == 0.0F) {
            return 1807812268 ^ -1413413204;
         } else {
            float var4 = var1 - tx[var0];
            float var5 = var2 - ty[var0];
            return (int)Math.floor((double)((m00[var0] * var5 - m01[var0] * var4) / var3));
         }
      }
   }

   public static int ac(float var0, float var1, int var2) {

      assert vis != null
         && vis.length == 13
         && bw != null
         && bw.length == 13
         && cd != null
         && cd.length == 13
         && ao != null
         && ao.length == 13
         && dep != null
         && dep.length == 13
         && m00 != null
         && m00.length == 13
         && m01 != null
         && m01.length == 13
         && m10 != null
         && m10.length == 13
         && m11 != null
         && m11.length == 13
         && tx != null
         && tx.length == 13
         && ty != null
         && ty.length == 13
         && lx0 != null
         && lx0.length == 13
         && ly0 != null
         && ly0.length == 13
         && ce != null
         && ce.length == 117
         && cb.length == 4 : "surfaceA" + "t:" + " bad boards";

      float var3 = Float.MAX_VALUE;
      int var4 = -1;
      float var5 = Float.MAX_VALUE;

      try {
         for (int var6 = 0; var6 < 13; var6++) {
            if (vis[var6] && !bw[var6] && BACK_BLOCK[var6] && !(ao[var6] < 0.25F) && !(dep[var6] >= var3)) {
               float var7 = m00[var6] * m11[var6] - m10[var6] * m01[var6];
               if (var7 != 0.0F) {
                  float var8 = var0 - tx[var6];
                  float var9 = var1 - ty[var6];
                  float var10 = (m11[var6] * var8 - m10[var6] * var9) / var7;
                  float var11 = (m00[var6] * var9 - m01[var6] * var8) / var7;
                  if (var10 >= lx0[var6] && var10 < lx0[var6] + lw[var6] && var11 >= ly0[var6] && var11 < ly0[var6] + lh[var6]) {
                     var3 = dep[var6];
                  }
               }
            }
         }

         for (int var15 = 0; var15 < 13; var15++) {
            if (vis[var15]
               && bw[var15]
               && (var2 & 1 << var15) != 0
               && !(dep[var15] >= var5)
               && !(ao[var15] < 0.25F)
               && (!(dep[var15] >= var3) || var15 == 9 || var15 == 10)) {
               if (cd[var15]) {
                  if (w(var15, var0, var1)) {
                     var5 = dep[var15];
                     var4 = var15;
                     continue;
                  }

                  if (!(PAD[var15] > 0.0F)) {
                     continue;
                  }
               }

               float var16 = m00[var15] * m11[var15] - m10[var15] * m01[var15];
               if (var16 != 0.0F) {
                  float var17 = var0 - tx[var15];
                  float var18 = var1 - ty[var15];
                  float var19 = (m11[var15] * var17 - m10[var15] * var18) / var16;
                  float var20 = (m00[var15] * var18 - m01[var15] * var17) / var16;
                  float var12 = PAD[var15];
                  if (var12 > 0.0F) {
                     float var13 = 10.0F / Math.max(0.001F, sc[var15]);
                     var12 = Math.min(24.0F, Math.max(var12, var13));
                  }

                  if (var19 >= lx0[var15] - var12
                     && var19 < lx0[var15] + lw[var15] + var12
                     && var20 >= ly0[var15] - var12
                     && var20 < ly0[var15] + lh[var15] + var12) {
                     var5 = dep[var15];
                     var4 = var15;
                  }
               }
            }
         }

         return var4;
      } catch (RuntimeException var14) {
         throw var14;
      }
   }

   public static void ad(float var0) {

      assert vis != null
         && vis.length == 13
         && bw != null
         && bw.length == 13
         && cd != null
         && cd.length == 13
         && ao != null
         && ao.length == 13
         && dep != null
         && dep.length == 13
         && m00 != null
         && m00.length == 13
         && m01 != null
         && m01.length == 13
         && m10 != null
         && m10.length == 13
         && m11 != null
         && m11.length == 13
         && tx != null
         && tx.length == 13
         && ty != null
         && ty.length == 13
         && lx0 != null
         && lx0.length == 13
         && ly0 != null
         && ly0.length == 13
         && ce != null
         && ce.length == 117
         && cb.length == 4 : "springAll: bad boards";

      try {
         for (int var1 = 0; var1 < 13; var1++) {
            boolean var2 = cx[var1];
            float var3 = var2 ? 19.0F : 24.0F;
            float var4 = var2 ? 1.0F : 0.0F;
            float var5 = cv[var1];
            float var6 = cw[var1];
            if (var5 != var4 || var6 != 0.0F) {
               float var7 = (float)Math.exp((double)(-var3 * var0));
               float var8 = var5 - var4;
               float var9 = var6 + var3 * var8;
               float var10 = var4 + (var8 + var9 * var0) * var7;
               float var11 = (var6 - var3 * var9 * var0) * var7;
               if (Math.abs(var10 - var4) < 0.0015F && Math.abs(var11) < 0.02F) {
                  var10 = var4;
                  var11 = 0.0F;
               }

               cv[var1] = var10 < 0.0F ? 0.0F : (var10 > 1.0F ? 1.0F : var10);
               cw[var1] = var11;
            }
         }
      } catch (RuntimeException var12) {
         throw var12;
      }
   }

   public static void ae(double var0, double var2, double var4, float var6, float var7, float var8) {

      aj = var0;
      ak = var2;
      al = var4;
      yaw = var6;
      am = var7;
      an = var8;
   }

   public static void af() {

      for (int var0 = 0; var0 < 13; var0++) {
         cv[var0] = 0.0F;
         cw[var0] = 0.0F;
         cx[var0] = false;
         vis[var0] = false;
         cd[var0] = false;
         TN[var0] = 0;
      }

      bc = -1;
      ptrS = -1;
      cg = false;
      ch = 0;
      at = false;
      ai = false;
      ck++;
   }

   static {
      for (int var0 = 0; var0 < 5; var0++) {
         a(var0, 0.5F, 0.0F);
         PLANE[var0] = true;
         BACK_BLOCK[var0] = true;
      }

      a(8, 0.5F, 1.0F);
      a(11, 0.5F, 1.0F);
      a(12, 0.5F, 1.0F);
      PLANE[8] = true;
      PLANE[11] = true;
      PLANE[12] = true;
      a(5, 0.5F, 0.5F);
      a(6, 0.5F, 0.0F);
      a(7, 0.5F, 0.0F);
      a(9, 0.5F, 0.5F);
      a(10, 0.5F, 0.5F);
      au = 2.5F;
      av = 0.0F;
      DYN = new float[39];
      PHYS = new boolean[13];
      PMUL = new float[13];
      PDIST = new float[13];
      bb = new float[39];
      bc = -1;
      HIT = new float[3];
      bf = 1.0F;
      bh = -1.0F;
      bm = 1.0F;
      bp = 0.7F;
      bq = 1.0F;
      br = 1.0F;
      bs = 1.0F;
      m00 = new float[13];
      m01 = new float[13];
      m10 = new float[13];
      m11 = new float[13];
      tx = new float[13];
      ty = new float[13];
      ax = new float[13];
      ay = new float[13];
      sc = new float[13];
      dep = new float[13];
      bu = new float[13];
      bv = new float[13];
      lx0 = new float[13];
      ly0 = new float[13];
      lw = new float[13];
      lh = new float[13];
      vis = new boolean[13];
      bw = new boolean[13];
      bx = new boolean[13];
      bx0 = new float[13];
      by0 = new float[13];
      bx1 = new float[13];
      by1 = new float[13];
      by = new float[39];
      bz = new float[26];
      ca = new float[13];
      cb = new float[4];
      cc = new float[4];
      cd = new boolean[13];
      ce = new float[117];
      PKX = new float[11];
      TB = new float[66560];
      TN = new int[13];
      cf = new boolean[6656];
      ci = new byte[6656];
      ptrS = -1;
      cl = -1;
      cm = -1;
      cs = 0.0052F;
      cv = new float[13];
      cw = new float[13];
      cx = new boolean[13];
   }
}
