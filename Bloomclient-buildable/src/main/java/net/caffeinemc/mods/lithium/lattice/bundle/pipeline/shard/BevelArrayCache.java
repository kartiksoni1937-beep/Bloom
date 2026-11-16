package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import java.util.Arrays;

public final class BevelArrayCache {
   public static final int S_NONE = 0;
   public static final int S_BUTTERFLY = 1;
   public static final int S_KARAMBIT = 2;
   public static final int S_KUNAI = 3;
   public static final int S_BAYONET = 4;
   public static final int S_TALON = 5;
   public static final int S_KATANA = 6;
   public static final int NSKIN = 7;
   public static final int F_STEEL = 0;
   public static final int F_FADE = 1;
   public static final int F_DOPPLER = 2;
   public static final int F_TIGER = 3;
   public static final int F_CRIMSON = 4;
   public static final int F_ULTRA = 5;
   public static final int F_THEME = 6;
   public static final int NFIN = 7;
   static final byte M_BLADE = 0;
   static final byte M_HANDLE = 1;
   static final byte M_GRIP = 2;
   static final byte M_WRAP = 3;
   static final byte M_DARK = 4;
   static final byte M_BRASS = 5;
   static final byte M_WHITE = 6;
   static final byte M_HWIN = 7;
   static final byte M_ITO = 8;
   static final byte M_RUBBER = 9;
   static final int NMAT = 10;
   static final boolean[] FINMAT = new boolean[]{true, true, false, false, false, false, false, true, false, false};
   public static final int C_AX = 0;
   public static final int C_AY = 1;
   public static final int C_AZ = 2;
   public static final int C_AP = 3;
   public static final int C_AW = 4;
   public static final int C_AR = 5;
   public static final int C_WP = 6;
   public static final int C_WY = 7;
   public static final int C_WR = 8;
   public static final int C_SPIN = 9;
   public static final int C_TH = 10;
   public static final int C_PH = 11;
   public static final int C_SL = 12;
   public static final int C_FR = 13;
   public static final int C_SZ = 14;
   public static final int C_GD = 15;
   public static final int C_GH = 16;
   public static final int C_KX = 17;
   public static final int C_KY = 18;
   public static final int C_KZ = 19;
   public static final int C_PV = 20;
   public static final int NCH = 21;
   static final float SZ_GAP = 1.1F;
   static final float SZ_HOLD = 2.0F;
   static final float[][] UP = new float[7][];
   static final float[][] UN = new float[7][];
   static final float[][] UG = new float[7][];
   static final float[][] UT = new float[7][];
   static final float[][] UO = new float[7][];
   static final byte[][] UA = new byte[7][];
   static final byte[][] UM = new byte[7][];
   static final int[] NU = new int[7];
   static final int[][] CI = new int[7][];
   static final int[] NC = new int[7];
   static final int[][] HWQ = new int[7][];
   static final float[][] SPP = new float[7][];
   static final byte[][] SPA = new byte[7][];
   static final int[] SPN = new int[7];
   public static volatile boolean READY;
   public static float[] OP;
   public static float[] OT;
   public static int[] OC;
   public static int OV;
   public static float[] SP;
   public static float[] ST;
   public static int[] SC;
   public static int SV;
   public static int[] WQ = new int[0];
   public static int WN;
   public static float[] GP;
   public static float[] GT;
   public static int[] GC;
   public static int GV;
   public static final float[] AP = new float[72];
   public static final float[] AT = new float[48];
   public static final int[] AC = new int[24];
   static final int ARM_MAXS = 800;
   public static final float[] AGP = new float[9600];
   public static final float[] AGT = new float[6400];
   public static final int[] AGC = new int[3200];
   public static int AGV;
   public static final float[] E = new float[12];
   public static final float[] EN = new float[9];
   public static final float[] CAM = new float[]{1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F};
   public static final float[] HM = new float[12];
   public static final float[] KM = new float[12];
   static final float[] PM = new float[36];
   public static final float[] HQ = new float[4];
   private static final float[] bv = new float[12];
   private static final float[] bw = new float[12];
   static final float[] ARM0 = new float[12];
   public static final float FX = -1.0F;
   public static final float FY = 9.8F;
   public static final float FZ = 0.0F;
   static final float HAND_X = -0.176F;
   static final float HAND_Y = 0.147F;
   static final float HAND_Z = -0.08F;
   static final float ARM_P = 0.75F;
   static final float ARM_W = -1.01F;
   static final float ARM_R = 115.34F;
   static final float[] K_YAW = new float[]{0.0F, -132.4F, -5.09F, -132.4F, -132.4F, -6.7F, -112.7F};
   static final float[] K_PIT = new float[]{0.0F, -45.3F, -18.05F, -45.3F, -45.3F, -31.98F, -54.5F};
   static final float[] K_ROL = new float[]{0.0F, 99.3F, -5.66F, 99.3F, 99.3F, -6.35F, 120.7F};
   static final float[] K_SC = new float[]{1.0F, 0.03F, 0.03F, 0.03F, 0.028F, 0.028F, 0.019F};
   static final float[] GRIP = new float[]{
      0.0F, 0.0F, 0.0F, -8.3F, 0.0F, 0.0F, -4.5F, -0.2F, 0.0F, -5.8F, 0.0F, 0.0F, -8.3F, 0.0F, 0.0F, -5.0F, -0.17F, 0.0F, -9.6F, 0.0F, 0.0F
   };
   static final float[] PIVOT = new float[]{
      0.0F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -9.45F, -0.35F, 0.0F, -9.15F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -10.95F, -1.02F, 0.0F, -6.0F, 0.0F, 0.0F
   };
   static final float[] GD_BIG = new float[]{0.0F, 0.0F, 1.7F, 0.0F, 0.0F, 1.0F, 0.0F};
   static final float[] GH_BIG = new float[]{0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F};
   static final float[] SL_SMALL = new float[]{0.0F, 3.0F, 0.0F, 3.0F, 2.0F, 0.0F, 0.0F};
   static final int NFID = 4;
   static final int FID0 = 14;
   static final int NVAR = 3;
   static final int VAR0 = 18;
   static final int VAN0 = 30;
   static final int NVAN = 13;
   static final int NANIM = 43;
   static final int V_FLIP = 30;
   static final int V_EDGE = 31;
   static final int V_HEFT = 32;
   static final int V_ROLL = 33;
   static final int V_TWIRL = 34;
   static final int V_LOOK = 35;
   static final int V_BRACE = 36;
   static final int V_SIGHT = 37;
   static final int V_FACE = 38;
   static final int V_BASH = 39;
   static final int V_SKY = 40;
   static final int V_MILL = 41;
   static final int V_COMBO = 42;
   public static final int IS_ITEM = 0;
   public static final int IS_SWORD = 7;
   public static final int IS_AXE = 8;
   public static final int IS_MACE = 9;
   public static final int IS_SPEAR = 10;
   public static final int IS_BIG = 11;
   public static final int NSET = 12;
   static final int[] INS = new int[]{
      0, 30, 35, 2, 18, 19, 4, 20, 21, 6, 22, 23, 8, 24, 25, 10, 26, 27, 12, 28, 29, 40, 41, 42, 0, 32, 30, 0, 32, 33, 0, 34, 37, 36, 38, 39
   };
   static final float[][][] ANIM = new float[43][][];
   static final float[] NOKEYS = new float[0];
   public static final float[] DUR = new float[43];
   static final float[][] CUES = new float[43][];
   static final float[][][] ANIM_V;
   static final float[][][] ANIM_A;
   static final float ACC_CAP = 4.0F;
   public static final int ST_NATURAL = 0;
   public static final int ST_FORWARD = 1;
   public static final int ST_LOW = 2;
   public static final int ST_REVERSE = 3;
   public static final int ST_TILTED = 4;
   public static final int NSTYLE = 5;
   static final float[] HOLD;
   private static final int bx = 12;
   static final float[] MICRO;
   public static final int MI_GAME = 0;
   public static final int MI_PREVIEW = 1;
   static final float T_CANCEL = 0.34F;
   static final float T_START = 0.42F;
   static final float T_END = 0.5F;
   static final float T_STYLE = 0.55F;
   static final float T_DRAW = 0.3F;
   static final float T_FIDGET = 0.3F;
   static final float B_RATE = 360.0F;
   static final float B_SPIN = 200.0F;
   static final float B_SPIN_MIN = 0.15F;
   static final float B_MAX = 0.9F;
   static final float B_COAST = 1.1F;
   public static boolean FIDGETS;
   static final float FID_WAIT0 = 8.0F;
   static final float FID_WAIT1 = 16.0F;
   private static final int[] by;
   private static final int[] bz;
   private static final int[] ca;
   private static final int[] cb;
   private static final float[] cc;
   private static final float[] cd;
   private static final float[] ce;
   private static final long[] cf;
   private static final float[] cg;
   private static final float[] ch;
   private static final float[] ci;
   private static final float[] cj;
   private static final float[] ck;
   private static final float[] cl;
   private static final int[] cm;
   private static final int[] cn;
   private static final int[] co;
   private static final float[] cp;
   private static final float[] cq;
   private static final float[] cr;
   private static final float[] cs;
   private static final float[] ct;
   private static final float[] cu;
   private static final float[] cv;
   private static final float[] cw;
   private static final float[] cx;
   private static final float[] cy;
   private static final float[] cz;
   public static final int[] CUE_HIT;
   public static float[] CUE_TAB;
   private static final int[] da;
   private static int db;
   private static final float[] dc;
   public static final int SND_CLACK = 0;
   public static final int SND_TICK = 1;
   public static final int SND_WHOOSH = 2;
   public static final int SND_SWISH = 3;
   public static final int SND_SHING = 4;
   public static final int SND_SNIP = 5;
   public static final int SND_RATTLE = 6;
   public static final int NSND = 7;
   public static float SW_X;
   public static float SW_Y;
   public static float SW_Z;
   public static float SW_YAW;
   public static float SW_PIT;
   public static float SW_ROLL;
   private static float dd;
   private static float de;
   private static float df;
   private static float dg;
   private static float dh;
   private static float di;
   private static float dj;
   private static float dk;
   private static float dl;
   private static float dm;
   private static float dn;
   private static float _kwren_do;
   static final float LAG_W = 11.0F;
   static final float LAG_GAIN = 0.16F;
   static final float LAG_MAX = 4.5F;
   static final float LAG_CAP = 80.0F;
   static final float BOB_W = 6.0F;
   static final float DROP_W = 9.0F;
   static final float ROLL_W = 7.0F;
   static final float BOB_X = 0.0045F;
   static final float BOB_Y = 0.003F;
   static final float BOB_R = 0.6F;
   static final float ROLL_K = 0.45F;
   static final float SIDE_X = 0.0022F;
   static final float SIDE_MAX = 6.0F;
   static final float SW_DT = 0.06F;
   static final float SW_DEBT = 0.25F;
   static final float SW_CATCH = 1.0F;
   private static float dp;
   public static float SL_V;
   public static final float SL_X = -0.25F;
   public static final float SL_Y = 0.27F;
   public static final float SL_Z = 0.72F;
   public static final float SL_YAW = 24.0F;
   public static final float SL_PIT = 0.0F;
   public static final float SL_ROL = 10.0F;
   public static final float SL_PUSH = -0.03F;
   static final float SL_RISE = 0.27F;
   static final float SL_M0 = 1.0F;
   public static float ARM_WS;
   public static float ARM_LS;
   static final float[] RECT;
   static final float[] K_AMB;
   static final float[] K_DIF;
   static final float[] K_ENV;
   static final float[] K_SPC;
   static final float[] K_ANI;
   static final float[] K_FRS;
   static final float[] K_COAT;
   static final float[] K_F0;
   static final float[] F_ENV;
   static final float[] F_SPC;
   static final float[] F_ANI;
   static final float[] F_COAT;
   static final float[] F_F0;
   private static final float[] dq;
   private static final float[] dr;
   private static final float[] ds;
   private static final float[] dt;
   private static final float[] du;
   private static final float[] dv;
   private static final float[] dw;
   private static final float[] dx;
   private static final boolean[] dy;
   static final float[] LV;
   private static final float[] dz;
   private static final float[] ea;
   private static final float[] eb;
   private static float[] ec;
   private static float[] ed;
   private static float[] ee;
   private static int[] ef;
   private static int[] eg;
   private static boolean[] eh;
   private static int ei;
   static final float GLOW_R = 0.024F;
   static final float GLOW_SP = 0.006F;
   static final float GLOW_PUSH = 0.022F;
   static final float GLOW_A = 0.44F;
   static final float ARM_GR = 0.04F;
   static final float ARM_GSP = 0.01F;
   static final float ARM_GPUSH = 0.03F;
   static final float ARM_GA = 0.46F;
   static final float DOT_U0 = 0.25146484F;
   static final float DOT_U1 = 0.31103516F;
   static final float DOT_V0 = 0.87646484F;
   static final float DOT_V1 = 0.93603516F;
   static final float[] ARM_BOX;
   public static final float ARM_EXT = 12.0F;
   static final int[] BOX_Q;
   static final float[] BOX_N;
   static final int[] BOX_E;
   private static final float[] ej;
   private static final boolean[] ek;
   private static float[] el;
   private static float[] em;
   private static float[] en;
   private static float[] eo;
   private static float[] ep;
   private static byte[] eq;
   private static byte[] er;
   private static int es;
   private static boolean et;
   private static boolean eu;
   private static boolean ev;
   private static byte ew;
   private static byte ex;
   private static final float[] ey;
   private static final float[] ez;
   private static final float[] fa;
   private static final float[] fb;
   private static int fc;
   private static float fd;
   static final int NM_CREASE = 0;
   static final int NM_SMOOTH = 1;
   static final int NM_PREV = 2;
   static final int NM_NEXT = 3;
   private static final int fe = 64;
   private static final int ff = 20;
   private static final float[] fg;
   private static final float[] fh;
   private static final float[] fi;
   private static final float[] fj;
   private static final float[] fk;
   private static final float[] fl;
   private static final float[] fm;
   private static final float[] fn;
   private static final float[] fo;
   private static final byte[] fp;
   private static int fq;
   private static int fr;
   private static final float[] fs;
   private static final float[] ft;
   private static final float[] fu;
   private static final float[] fv;
   private static final byte[] fw;
   private static int fx;
   private static int fz = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   private BevelArrayCache() {
   }

   static void a(float[] var0) {

      var0[0] = 1.0F;
      var0[1] = 0.0F;
      var0[2] = 0.0F;
      var0[3] = 0.0F;
      var0[4] = 0.0F;
      var0[5] = 1.0F;
      var0[6] = 0.0F;
      var0[7] = 0.0F;
      var0[8] = 0.0F;
      var0[9] = 0.0F;
      var0[10] = 1.0F;
      var0[11] = 0.0F;
   }

   static void mul(float[] var0, int var1, float[] var2, int var3, float[] var4, int var5) {

      for (int var6 = 0; var6 < 3; var6++) {
         float var7 = var0[var1 + var6 * 4];
         float var8 = var0[var1 + var6 * 4 + 1];
         float var9 = var0[var1 + var6 * 4 + 2];
         float var10 = var0[var1 + var6 * 4 + 3];
         var4[var5 + var6 * 4] = var7 * var2[var3] + var8 * var2[var3 + 4] + var9 * var2[var3 + 8];
         var4[var5 + var6 * 4 + 1] = var7 * var2[var3 + 1] + var8 * var2[var3 + 5] + var9 * var2[var3 + 9];
         var4[var5 + var6 * 4 + 2] = var7 * var2[var3 + 2] + var8 * var2[var3 + 6] + var9 * var2[var3 + 10];
         var4[var5 + var6 * 4 + 3] = var7 * var2[var3 + 3] + var8 * var2[var3 + 7] + var9 * var2[var3 + 11] + var10;
      }
   }

   static void tr(float[] var0, float var1, float var2, float var3) {

      var0[3] += var0[0] * var1 + var0[1] * var2 + var0[2] * var3;
      var0[7] += var0[4] * var1 + var0[5] * var2 + var0[6] * var3;
      var0[11] += var0[8] * var1 + var0[9] * var2 + var0[10] * var3;
   }

   static void rot(float[] var0, int var1, float var2) {

      assert var0 != null
         && var0.length >= 12
         && var1 >= 0
         && var1 <= 2
         && !Float.isNaN(var2)
         && bv.length == 12
         && bw.length == 12
         && HM.length == 12
         && KM.length == 12
         && PM.length == 36
         && HQ.length == 4
         && ARM0.length == 12
         && E.length == 12
         && EN.length == 9
         && CAM.length == 9 : "rot";

      if (var2 != 0.0F) {
         try {
            double var3 = Math.toRadians((double)var2);
            float var5 = (float)Math.cos(var3);
            float var6 = (float)Math.sin(var3);

            for (int var7 = 0; var7 < 3; var7++) {
               int var8 = var7 * 4;
               float var9 = var0[var8];
               float var10 = var0[var8 + 1];
               float var11 = var0[var8 + 2];
               if (var1 == 0) {
                  var0[var8 + 1] = var10 * var5 + var11 * var6;
                  var0[var8 + 2] = -var10 * var6 + var11 * var5;
               } else if (var1 == 1) {
                  var0[var8] = var9 * var5 - var11 * var6;
                  var0[var8 + 2] = var9 * var6 + var11 * var5;
               } else {
                  var0[var8] = var9 * var5 + var10 * var6;
                  var0[var8 + 1] = -var9 * var6 + var10 * var5;
               }
            }
         } catch (RuntimeException var12) {
            throw var12;
         }
      }
   }

   static void b(float[] var0, int var1, float var2, int var3, float var4, int var5, float var6) {

      assert var0 != null
         && var0.length >= 12
         && var1 >= 0
         && var1 <= 2
         && var3 >= 0
         && var3 <= 2
         && var5 >= 0
         && var5 <= 2
         && !Float.isNaN(var2)
         && !Float.isNaN(var4)
         && !Float.isNaN(var6)
         && bv.length == 12
         && bw.length == 12
         && HM.length == 12
         && KM.length == 12
         && PM.length == 36
         && HQ.length == 4
         && ARM0.length == 12 : "rot3";

      try {
         float var7 = 1.0F;
         float var8 = 0.0F;
         float var9 = 1.0F;
         float var10 = 0.0F;
         float var11 = 1.0F;
         float var12 = 0.0F;
         boolean var13 = var2 != 0.0F;
         boolean var14 = var4 != 0.0F;
         boolean var15 = var6 != 0.0F;
         if (var13) {
            double var16 = Math.toRadians((double)var2);
            var7 = (float)Math.cos(var16);
            var8 = (float)Math.sin(var16);
         }

         if (var14) {
            double var28 = Math.toRadians((double)var4);
            var9 = (float)Math.cos(var28);
            var10 = (float)Math.sin(var28);
         }

         if (var15) {
            double var29 = Math.toRadians((double)var6);
            var11 = (float)Math.cos(var29);
            var12 = (float)Math.sin(var29);
         }

         for (int var30 = 0; var30 < 3; var30++) {
            int var17 = var30 * 4;
            float var18 = var0[var17];
            float var19 = var0[var17 + 1];
            float var20 = var0[var17 + 2];

            for (int var21 = 0; var21 < 3; var21++) {
               boolean var22 = var21 == 0 ? var13 : (var21 == 1 ? var14 : var15);
               if (var22) {
                  int var23 = var21 == 0 ? var1 : (var21 == 1 ? var3 : var5);
                  float var24 = var21 == 0 ? var7 : (var21 == 1 ? var9 : var11);
                  float var25 = var21 == 0 ? var8 : (var21 == 1 ? var10 : var12);
                  if (var23 == 0) {
                     float var26 = var19 * var24 + var20 * var25;
                     var20 = -var19 * var25 + var20 * var24;
                     var19 = var26;
                  } else if (var23 == 1) {
                     float var31 = var18 * var24 - var20 * var25;
                     var20 = var18 * var25 + var20 * var24;
                     var18 = var31;
                  } else {
                     float var32 = var18 * var24 + var19 * var25;
                     var19 = -var18 * var25 + var19 * var24;
                     var18 = var32;
                  }
               }
            }

            var0[var17] = var18;
            var0[var17 + 1] = var19;
            var0[var17 + 2] = var20;
         }
      } catch (RuntimeException var27) {
         throw var27;
      }
   }

   public static void c(int var0, float[] var1) {

      float[] var2 = bv;
      var2[0] = 1.0F;
      var2[1] = 0.0F;
      var2[2] = 0.0F;
      var2[3] = 0.0F;
      var2[4] = 0.0F;
      var2[5] = 1.0F;
      var2[6] = 0.0F;
      var2[7] = 0.0F;
      var2[8] = 0.0F;
      var2[9] = 0.0F;
      var2[10] = 1.0F;
      var2[11] = 0.0F;
      float var3 = -0.176F + var1[0];
      float var4 = 0.147F + var1[1];
      float var5 = -0.08F + var1[2];
      var2[3] += var2[0] * var3 + var2[1] * var4 + var2[2] * var5;
      var2[7] += var2[4] * var3 + var2[5] * var4 + var2[6] * var5;
      var2[11] += var2[8] * var3 + var2[9] * var4 + var2[10] * var5;
      b(var2, 1, var1[4], 0, var1[3], 2, var1[5]);
      b(var2, 1, -1.01F, 0, 0.75F, 2, 115.34F);
      float[] var6 = ARM0;

      for (int var7 = 0; var7 < 3; var7++) {
         int var8 = var7 * 4;
         HM[var8] = var2[var8] * var6[0] + var2[var8 + 1] * var6[4] + var2[var8 + 2] * var6[8];
         HM[var8 + 1] = var2[var8] * var6[1] + var2[var8 + 1] * var6[5] + var2[var8 + 2] * var6[9];
         HM[var8 + 2] = var2[var8] * var6[2] + var2[var8 + 1] * var6[6] + var2[var8 + 2] * var6[10];
         HM[var8 + 3] = var2[var8 + 3];
      }

      rot(HM, 1, var1[13]);
      d(HM, HQ);
      float[] var31 = bw;
      float var32 = ARM_WS - 0.6F;
      float var9 = -var1[15];
      float var10 = var1[16] * ARM_WS * 2.0F;
      if (var32 > 0.0F) {
         var9 += GD_BIG[var0] * var32;
         var10 += GH_BIG[var0] * var32;
      }

      var9 *= 0.0625F;
      var10 *= 0.0625F;

      for (int var11 = 0; var11 < 3; var11++) {
         int var12 = var11 * 4;
         float var13 = HM[var12];
         float var14 = HM[var12 + 1];
         float var15 = HM[var12 + 2];
         var31[var12] = -var15;
         var31[var12 + 1] = -var14;
         var31[var12 + 2] = -var13;
         var31[var12 + 3] = HM[var12 + 3] + var14 * var9 + var15 * var10 + var1[17 + var11];
      }

      int var35 = var0 * 3;
      b(var31, 1, K_YAW[var0], 2, K_PIT[var0], 0, K_ROL[var0]);
      b(var31, 2, var1[6], 1, var1[7], 0, var1[8]);
      float var36 = K_SC[var0];
      var31[0] *= var36;
      var31[1] *= var36;
      var31[2] *= var36;
      var31[4] *= var36;
      var31[5] *= var36;
      var31[6] *= var36;
      var31[8] *= var36;
      var31[9] *= var36;
      var31[10] *= var36;
      float var37 = var1[14] * (2.0F * ARM_WS + 1.1F) / (16.0F * K_SC[var0]);
      float var38 = var1[12];
      if (ARM_WS < 0.55F) {
         var38 += SL_SMALL[var0] * (0.55F - ARM_WS) * 4.0F;
      }

      float var39 = var38 - GRIP[var35];
      float var16 = -GRIP[var35 + 1];
      float var17 = var37 - GRIP[var35 + 2];
      var31[3] += var31[0] * var39 + var31[1] * var16 + var31[2] * var17;
      var31[7] += var31[4] * var39 + var31[5] * var16 + var31[6] * var17;
      var31[11] += var31[8] * var39 + var31[9] * var16 + var31[10] * var17;
      float var18 = var1[9];
      if (var18 != 0.0F) {
         float var19 = PIVOT[var35] + var1[20];
         tr(var31, var19, PIVOT[var35 + 1], PIVOT[var35 + 2]);
         rot(var31, 2, var18);
         tr(var31, -var19, -PIVOT[var35 + 1], -PIVOT[var35 + 2]);
      }

      System.arraycopy(var31, 0, KM, 0, 12);
      var2[0] = 1.0F;
      var2[1] = 0.0F;
      var2[2] = 0.0F;
      var2[3] = 0.0F;
      var2[4] = 0.0F;
      var2[5] = 1.0F;
      var2[6] = 0.0F;
      var2[7] = 0.0F;
      var2[8] = 0.0F;
      var2[9] = 0.0F;
      var2[10] = 1.0F;
      var2[11] = 0.0F;
      System.arraycopy(bv, 0, PM, 0, 12);
      System.arraycopy(bv, 0, PM, 12, 12);
      System.arraycopy(bv, 0, PM, 24, 12);
      if (var0 == 1) {
         double var40 = Math.toRadians((double)var1[10]);
         double var21 = Math.toRadians((double)var1[11]);
         float var23 = (float)Math.cos(var40);
         float var24 = (float)Math.sin(var40);
         float var25 = (float)Math.cos(var21);
         float var26 = (float)Math.sin(var21);
         float var27 = 0.0F;
         float var28 = 0.6F;
         PM[12] = var23;
         PM[13] = -var24;
         PM[14] = 0.0F;
         PM[15] = var27 - (var23 * var27 - var24 * var28);
         PM[16] = var24;
         PM[17] = var23;
         PM[18] = 0.0F;
         PM[19] = var28 - (var24 * var27 + var23 * var28);
         PM[20] = 0.0F;
         PM[21] = 0.0F;
         PM[22] = 1.0F;
         PM[23] = 0.0F;
         float var29 = var27 + var24 * 1.2F;
         float var30 = var28 - var23 * 1.2F;
         PM[24] = var25;
         PM[25] = -var26;
         PM[26] = 0.0F;
         PM[27] = var29 - (var25 * 0.0F - var26 * -0.6F);
         PM[28] = var26;
         PM[29] = var25;
         PM[30] = 0.0F;
         PM[31] = var30 - (var26 * 0.0F + var25 * -0.6F);
         PM[32] = 0.0F;
         PM[33] = 0.0F;
         PM[34] = 1.0F;
         PM[35] = 0.0F;
      }
   }

   static void d(float[] var0, float[] var1) {

      float var2 = var0[0];
      float var3 = var0[5];
      float var4 = var0[10];
      float var5 = var2 + var3 + var4;
      if (var5 > 0.0F) {
         float var6 = (float)Math.sqrt((double)(var5 + 1.0F)) * 2.0F;
         var1[3] = 0.25F * var6;
         var1[0] = (var0[9] - var0[6]) / var6;
         var1[1] = (var0[2] - var0[8]) / var6;
         var1[2] = (var0[4] - var0[1]) / var6;
      } else if (var2 > var3 && var2 > var4) {
         float var9 = (float)Math.sqrt((double)(1.0F + var2 - var3 - var4)) * 2.0F;
         var1[3] = (var0[9] - var0[6]) / var9;
         var1[0] = 0.25F * var9;
         var1[1] = (var0[1] + var0[4]) / var9;
         var1[2] = (var0[2] + var0[8]) / var9;
      } else if (var3 > var4) {
         float var7 = (float)Math.sqrt((double)(1.0F + var3 - var2 - var4)) * 2.0F;
         var1[3] = (var0[2] - var0[8]) / var7;
         var1[0] = (var0[1] + var0[4]) / var7;
         var1[1] = 0.25F * var7;
         var1[2] = (var0[6] + var0[9]) / var7;
      } else {
         float var8 = (float)Math.sqrt((double)(1.0F + var4 - var2 - var3)) * 2.0F;
         var1[3] = (var0[4] - var0[1]) / var8;
         var1[0] = (var0[2] + var0[8]) / var8;
         var1[1] = (var0[6] + var0[9]) / var8;
         var1[2] = 0.25F * var8;
      }
   }

   private static void e() {

      float[] var0 = new float[0];
      byte var1 = 18;
      ANIM[var1] = new float[][]{
         {
               0.0F,
               0.0F,
               0.12F,
               0.008F,
               0.5F,
               -0.165F,
               1.1F,
               -0.17F,
               1.5F,
               -0.185F,
               1.92F,
               -0.17F,
               2.3F,
               -0.2F,
               2.8F,
               -0.198F,
               3.3F,
               -0.165F,
               3.6F,
               0.006F,
               3.85F,
               0.0F
         },
         {
               0.0F,
               0.0F,
               0.12F,
               -0.012F,
               0.5F,
               0.105F,
               1.0F,
               0.1F,
               1.08F,
               0.086F,
               1.2F,
               0.13F,
               1.45F,
               0.115F,
               1.74F,
               0.132F,
               1.9F,
               0.098F,
               2.1F,
               0.112F,
               2.3F,
               0.13F,
               2.8F,
               0.128F,
               3.3F,
               0.11F,
               3.6F,
               -0.006F,
               3.85F,
               0.0F
         },
         {0.0F, 0.0F, 0.5F, 0.07F, 2.0F, 0.07F, 2.3F, 0.09F, 2.8F, 0.088F, 3.3F, 0.065F, 3.6F, -0.003F, 3.85F, 0.0F},
         {0.0F, 0.0F, 0.12F, -2.0F, 0.5F, 9.0F, 1.08F, 6.0F, 1.2F, 13.0F, 1.45F, 9.0F, 1.74F, 10.0F, 1.9F, 7.0F, 2.15F, 9.0F, 3.3F, 9.5F, 3.85F, 0.0F},
         {0.0F, 0.0F, 0.5F, 0.4F, 2.8F, 0.4F, 3.1F, 4.0F, 3.85F, 0.0F},
         {0.0F, 0.0F, 0.12F, 1.0F, 0.5F, -8.0F, 2.8F, -8.5F, 3.3F, -7.0F, 3.85F, 0.0F},
         {
               0.0F,
               0.0F,
               0.12F,
               3.0F,
               0.4F,
               -16.0F,
               0.58F,
               -22.0F,
               0.78F,
               -13.0F,
               0.95F,
               -15.0F,
               1.06F,
               -28.0F,
               1.18F,
               -8.0F,
               1.42F,
               -18.0F,
               1.8F,
               -18.0F,
               1.9F,
               -12.0F,
               2.26F,
               -16.0F,
               2.44F,
               -22.0F,
               2.62F,
               -14.0F,
               2.8F,
               -17.0F,
               3.3F,
               -16.0F,
               3.85F,
               0.0F
         },
         {0.0F, 0.0F, 0.5F, -6.8F, 2.8F, -6.8F, 3.1F, -24.0F, 3.35F, -20.0F, 3.85F, 0.0F},
         {0.0F, 0.0F, 0.5F, -8.0F, 2.26F, -8.0F, 2.46F, -2.0F, 2.62F, -13.0F, 2.8F, -9.0F, 3.1F, -38.0F, 3.35F, -33.0F, 3.85F, 0.0F},
         {0.0F, 0.0F, 1.1F, 0.0F, 1.25F, 40.0F, 1.74F, 335.0F, 1.84F, 364.0F, 1.92F, 357.0F, 2.0F, 360.0F, 3.85F, 360.0F},
         {0.0F, 0.0F, 0.4F, 0.0F, 0.6F, 184.0F, 0.68F, 177.0F, 0.76F, 180.0F, 2.26F, 180.0F, 2.46F, 364.0F, 2.53F, 358.0F, 2.6F, 360.0F, 3.85F, 360.0F},
         {
               0.0F,
               0.0F,
               0.4F,
               0.0F,
               0.6F,
               180.0F,
               0.78F,
               364.0F,
               0.85F,
               358.0F,
               0.92F,
               360.0F,
               2.26F,
               360.0F,
               2.46F,
               540.0F,
               2.62F,
               723.0F,
               2.7F,
               719.0F,
               2.78F,
               720.0F,
               3.85F,
               720.0F
         },
         {0.0F, 0.0F, 1.08F, 0.0F, 1.24F, 4.5F, 1.8F, 4.5F, 1.96F, -0.3F, 2.06F, 0.0F, 3.85F, 0.0F},
         {0.0F, 0.0F, 0.12F, -3.0F, 0.5F, 4.0F, 1.2F, 6.0F, 2.0F, 2.0F, 3.1F, 5.0F, 3.85F, 0.0F},
         var0,
         var0,
         var0,
         {0.0F, 0.0F, 1.1F, 0.0F, 1.47F, -0.03F, 1.84F, 0.0F, 3.85F, 0.0F},
         {0.0F, 0.0F, 1.1F, 0.0F, 1.47F, 0.3F, 1.72F, 0.12F, 1.84F, 0.0F, 3.85F, 0.0F},
         {0.0F, 0.0F, 1.1F, 0.0F, 1.47F, 0.02F, 1.84F, 0.0F, 3.85F, 0.0F},
         {0.0F, 0.0F, 0.95F, 0.0F, 1.06F, -4.4F, 2.06F, -4.4F, 2.2F, 0.0F, 3.85F, 0.0F}
      };
      CUES[var1] = new float[]{
         0.6F,
         1.0F,
         1.7F,
         0.45F,
         0.78F,
         0.0F,
         1.85F,
         0.55F,
         1.17F,
         2.0F,
         1.6F,
         0.35F,
         1.84F,
         0.0F,
         1.7F,
         0.6F,
         2.46F,
         1.0F,
         1.75F,
         0.45F,
         2.62F,
         0.0F,
         1.9F,
         0.55F,
         3.1F,
         4.0F,
         1.4F,
         0.4F
      };
      ANIM[var1 + 1] = new float[][]{
         {
               0.0F,
               0.0F,
               0.12F,
               0.008F,
               0.45F,
               -0.2F,
               1.25F,
               -0.2F,
               1.6F,
               -0.212F,
               1.95F,
               -0.193F,
               2.3F,
               -0.206F,
               2.6F,
               -0.2F,
               3.6F,
               -0.19F,
               3.85F,
               0.006F,
               4.05F,
               0.0F
         },
         {
               0.0F,
               0.0F,
               0.12F,
               -0.012F,
               0.45F,
               0.165F,
               1.25F,
               0.178F,
               1.6F,
               0.19F,
               1.95F,
               0.174F,
               2.3F,
               0.186F,
               2.6F,
               0.168F,
               3.6F,
               0.15F,
               3.85F,
               -0.006F,
               4.05F,
               0.0F
         },
         {0.0F, 0.0F, 0.45F, 0.09F, 3.6F, 0.08F, 3.85F, -0.004F, 4.05F, 0.0F},
         {0.0F, 0.0F, 0.12F, -2.0F, 0.45F, 10.5F, 3.6F, 10.0F, 4.05F, 0.0F},
         {0.0F, 0.0F, 0.45F, 0.4F, 3.6F, 0.4F, 4.05F, 0.0F},
         {0.0F, 0.0F, 0.12F, 1.0F, 0.45F, -9.0F, 3.6F, -8.5F, 4.05F, 0.0F},
         {
               0.0F,
               0.0F,
               0.12F,
               3.0F,
               0.3F,
               -16.0F,
               0.48F,
               -22.0F,
               0.68F,
               -13.0F,
               0.8F,
               -15.0F,
               1.1F,
               14.9F,
               2.65F,
               14.9F,
               2.9F,
               -15.0F,
               3.06F,
               -16.0F,
               3.24F,
               -22.0F,
               3.42F,
               -14.0F,
               3.6F,
               -17.0F,
               4.05F,
               0.0F
         },
         {0.0F, 0.0F, 0.45F, -6.8F, 0.8F, -6.8F, 1.1F, -37.1F, 2.65F, -37.1F, 2.9F, -6.8F, 4.05F, 0.0F},
         {0.0F, 0.0F, 0.45F, -8.0F, 0.8F, -8.0F, 1.1F, 120.9F, 2.65F, 120.9F, 2.9F, -8.0F, 3.06F, -8.0F, 3.26F, -2.0F, 3.42F, -13.0F, 3.6F, -9.0F, 4.05F, 0.0F},
         {0.0F, 0.0F, 1.25F, 0.0F, 1.32F, 8.0F, 1.5F, -140.0F, 2.25F, -1010.0F, 2.42F, -1086.0F, 2.5F, -1077.0F, 2.58F, -1080.0F, 4.05F, -1080.0F},
         {0.0F, 0.0F, 0.3F, 0.0F, 0.5F, 184.0F, 0.58F, 177.0F, 0.66F, 180.0F, 3.06F, 180.0F, 3.26F, 364.0F, 3.33F, 358.0F, 3.4F, 360.0F, 4.05F, 360.0F},
         {
               0.0F,
               0.0F,
               0.3F,
               0.0F,
               0.5F,
               180.0F,
               0.68F,
               364.0F,
               0.75F,
               358.0F,
               0.82F,
               360.0F,
               1.25F,
               360.0F,
               1.55F,
               322.0F,
               1.85F,
               366.0F,
               2.15F,
               326.0F,
               2.42F,
               360.0F,
               3.06F,
               360.0F,
               3.26F,
               540.0F,
               3.42F,
               723.0F,
               3.5F,
               719.0F,
               3.58F,
               720.0F,
               4.05F,
               720.0F
         },
         {0.0F, 0.0F, 0.8F, 0.0F, 0.98F, 4.6F, 1.1F, 4.6F, 1.25F, -1.8F, 2.58F, -1.8F, 2.72F, 4.6F, 2.85F, 4.6F, 3.0F, 0.0F, 4.05F, 0.0F},
         {0.0F, 0.0F, 0.12F, -3.0F, 0.45F, 4.0F, 1.25F, 2.0F, 1.6F, 5.0F, 1.95F, -1.0F, 2.3F, 4.0F, 2.6F, 1.0F, 3.6F, 3.0F, 4.05F, 0.0F},
         {0.0F, 0.0F, 0.88F, 0.0F, 1.1F, 1.0F, 2.7F, 1.0F, 2.88F, 0.0F, 4.05F, 0.0F},
         var0,
         var0,
         var0,
         var0,
         var0,
         {0.0F, 0.0F, 1.0F, 0.0F, 1.12F, -4.5F, 2.6F, -4.5F, 2.7F, 0.0F, 4.05F, 0.0F}
      };
      CUES[var1 + 1] = new float[]{
         0.5F,
         1.0F,
         1.7F,
         0.45F,
         0.68F,
         0.0F,
         1.85F,
         0.55F,
         1.25F,
         6.0F,
         1.6F,
         0.3F,
         1.5F,
         3.0F,
         1.35F,
         0.5F,
         1.85F,
         3.0F,
         1.45F,
         0.55F,
         2.2F,
         3.0F,
         1.55F,
         0.55F,
         2.42F,
         0.0F,
         1.7F,
         0.6F,
         3.26F,
         1.0F,
         1.75F,
         0.45F,
         3.42F,
         0.0F,
         1.9F,
         0.55F
      };
   }

   private static void f() {

      float[] var0 = new float[0];
      byte var1 = 20;
      ANIM[var1] = new float[][]{
         {
               0.0F,
               0.0F,
               0.12F,
               0.008F,
               0.5F,
               -0.2F,
               0.75F,
               -0.23F,
               1.1F,
               -0.255F,
               1.86F,
               -0.255F,
               2.38F,
               -0.23F,
               2.68F,
               -0.205F,
               3.23F,
               -0.19F,
               3.48F,
               0.005F,
               3.68F,
               0.0F
         },
         {
               0.0F,
               0.0F,
               0.12F,
               -0.012F,
               0.5F,
               0.13F,
               0.75F,
               0.19F,
               1.1F,
               0.115F,
               1.5F,
               0.105F,
               1.86F,
               0.112F,
               2.38F,
               0.2F,
               2.68F,
               0.14F,
               3.23F,
               0.13F,
               3.48F,
               -0.005F,
               3.68F,
               0.0F
         },
         {0.0F, 0.0F, 0.5F, 0.09F, 0.75F, 0.09F, 1.1F, 0.03F, 1.86F, 0.03F, 2.38F, 0.09F, 3.23F, 0.085F, 3.48F, -0.004F, 3.68F, 0.0F},
         {0.0F, 0.0F, 0.12F, -2.0F, 0.5F, 10.0F, 0.75F, 11.5F, 2.38F, 11.5F, 2.68F, 10.5F, 3.23F, 10.0F, 3.68F, 0.0F},
         {0.0F, 0.0F, 0.5F, -4.6F, 0.75F, -5.3F, 2.38F, -5.3F, 2.68F, -4.6F, 3.68F, 0.0F},
         {0.0F, 0.0F, 0.12F, 1.0F, 0.5F, -8.8F, 0.75F, -9.7F, 2.38F, -9.7F, 2.68F, -8.8F, 3.68F, 0.0F},
         {0.0F, 0.0F, 0.12F, 3.0F, 0.5F, -1.0F, 0.75F, -2.6F, 2.38F, -2.6F, 2.68F, -1.0F, 3.08F, -4.0F, 3.68F, 0.0F},
         {0.0F, 0.0F, 0.45F, -20.0F, 0.72F, 5.6F, 1.3F, 5.6F, 1.5F, -12.0F, 1.72F, 10.0F, 1.86F, 5.6F, 2.38F, 5.6F, 2.63F, -12.0F, 3.03F, -6.0F, 3.68F, 0.0F},
         {0.0F, 0.0F, 0.5F, -3.9F, 0.75F, 2.9F, 1.3F, 2.9F, 1.5F, -38.0F, 1.72F, 32.0F, 1.88F, 2.9F, 2.38F, 2.9F, 2.68F, -3.9F, 3.68F, 0.0F},
         {
               0.0F,
               0.0F,
               0.82F,
               0.0F,
               0.88F,
               6.0F,
               1.1F,
               -146.0F,
               1.17F,
               -137.0F,
               1.24F,
               -140.0F,
               1.86F,
               -140.0F,
               1.92F,
               -134.0F,
               2.22F,
               -366.0F,
               2.29F,
               -357.0F,
               2.36F,
               -360.0F,
               3.68F,
               -360.0F
         },
         var0,
         var0,
         {0.0F, 0.0F, 0.3F, 0.0F, 0.55F, 4.5F, 2.38F, 4.5F, 2.63F, 0.0F, 3.68F, 0.0F},
         {0.0F, 0.0F, 0.12F, -3.0F, 0.5F, 4.0F, 1.25F, 2.0F, 1.86F, 3.0F, 2.68F, 5.0F, 3.28F, -2.0F, 3.68F, 0.0F},
         {0.0F, 0.0F, 0.4F, 0.0F, 0.65F, 1.0F, 2.43F, 1.0F, 2.68F, 0.0F, 3.68F, 0.0F}
      };
      CUES[var1] = new float[]{
         0.55F,
         1.0F,
         1.5F,
         0.45F,
         1.1F,
         3.0F,
         1.3F,
         0.55F,
         1.17F,
         1.0F,
         1.4F,
         0.5F,
         1.5F,
         4.0F,
         1.3F,
         0.45F,
         1.72F,
         4.0F,
         1.4F,
         0.45F,
         2.22F,
         3.0F,
         1.4F,
         0.55F,
         2.29F,
         1.0F,
         1.35F,
         0.55F,
         2.63F,
         1.0F,
         1.5F,
         0.4F
      };
      ANIM[var1 + 1] = new float[][]{
         {
               0.0F,
               0.0F,
               0.12F,
               0.008F,
               0.6F,
               -0.07F,
               1.05F,
               -0.075F,
               1.45F,
               -0.09F,
               1.8F,
               -0.085F,
               2.3F,
               -0.08F,
               2.7F,
               -0.236F,
               3.3F,
               -0.232F,
               3.7F,
               -0.2F,
               3.95F,
               0.005F,
               4.15F,
               0.0F
         },
         {
               0.0F,
               0.0F,
               0.12F,
               -0.012F,
               0.6F,
               0.15F,
               1.05F,
               0.165F,
               1.45F,
               0.17F,
               1.8F,
               0.165F,
               2.3F,
               0.155F,
               2.7F,
               0.2F,
               3.3F,
               0.2F,
               3.7F,
               0.14F,
               3.95F,
               -0.005F,
               4.15F,
               0.0F
         },
         {0.0F, 0.0F, 0.6F, 0.12F, 2.3F, 0.12F, 2.7F, 0.1F, 3.3F, 0.1F, 3.7F, 0.08F, 3.95F, -0.004F, 4.15F, 0.0F},
         {0.0F, 0.0F, 0.12F, -2.0F, 0.6F, 14.0F, 1.05F, 16.0F, 1.45F, 15.0F, 1.8F, 13.0F, 2.3F, 14.0F, 2.7F, 11.5F, 3.3F, 11.5F, 3.7F, 10.0F, 4.15F, 0.0F},
         {0.0F, 0.0F, 0.6F, 4.0F, 1.05F, 8.0F, 1.45F, 6.0F, 1.8F, 4.0F, 2.3F, 8.0F, 2.7F, -5.3F, 3.3F, -5.3F, 4.15F, 0.0F},
         {0.0F, 0.0F, 0.12F, 1.0F, 0.6F, -8.0F, 1.05F, -10.0F, 1.45F, -12.0F, 1.8F, -10.0F, 2.3F, -11.0F, 2.7F, -9.7F, 3.3F, -9.7F, 4.15F, 0.0F},
         {0.0F, 0.0F, 0.12F, 3.0F, 0.6F, 1.0F, 1.05F, 6.0F, 1.45F, 10.0F, 1.8F, 6.0F, 2.3F, 1.0F, 2.65F, -2.6F, 3.3F, -2.6F, 3.7F, -4.0F, 4.15F, 0.0F},
         {0.0F, 0.0F, 0.6F, -4.0F, 1.05F, -6.0F, 1.45F, -2.0F, 1.8F, -6.0F, 2.3F, -4.0F, 2.65F, 5.6F, 3.3F, 5.6F, 3.7F, -6.0F, 4.15F, 0.0F},
         {0.0F, 0.0F, 0.6F, -4.0F, 1.05F, -8.0F, 1.45F, -4.0F, 1.8F, -8.0F, 2.3F, -6.0F, 2.65F, 2.9F, 3.3F, 2.9F, 3.7F, -3.0F, 4.15F, 0.0F},
         {0.0F, 0.0F, 2.75F, 0.0F, 2.8F, 8.0F, 3.18F, -366.0F, 3.26F, -357.0F, 3.34F, -360.0F, 4.15F, -360.0F},
         var0,
         var0,
         {0.0F, 0.0F, 2.28F, 0.0F, 2.52F, 4.5F, 3.32F, 4.5F, 3.56F, 0.0F, 4.15F, 0.0F},
         {0.0F, 0.0F, 0.6F, -8.0F, 1.05F, -90.0F, 1.45F, -158.0F, 1.8F, -164.0F, 2.3F, -18.0F, 2.7F, 1.0F, 3.3F, 1.0F, 4.15F, 0.0F},
         {0.0F, 0.0F, 2.34F, 0.0F, 2.6F, 1.0F, 3.38F, 1.0F, 3.62F, 0.0F, 4.15F, 0.0F}
      };
      CUES[var1 + 1] = new float[]{
         1.05F,
         4.0F,
         1.25F,
         0.4F,
         1.45F,
         4.0F,
         1.35F,
         0.45F,
         2.52F,
         1.0F,
         1.5F,
         0.45F,
         2.9F,
         3.0F,
         1.4F,
         0.55F,
         3.26F,
         1.0F,
         1.35F,
         0.55F,
         3.56F,
         1.0F,
         1.5F,
         0.4F
      };
   }

   private static void g() {

      float[] var0 = new float[0];
      byte var1 = 22;
      ANIM[var1] = new float[][]{
         {0.0F, 0.0F, 0.12F, 0.008F, 0.5F, -0.19F, 1.28F, -0.205F, 1.65F, -0.19F, 2.25F, -0.18F, 2.9F, -0.17F, 3.25F, 0.005F, 3.5F, 0.0F},
         {
               0.0F,
               0.0F,
               0.12F,
               -0.012F,
               0.5F,
               0.12F,
               0.75F,
               0.115F,
               0.86F,
               0.104F,
               0.98F,
               0.148F,
               1.3F,
               0.13F,
               1.58F,
               0.14F,
               1.74F,
               0.1F,
               1.94F,
               0.115F,
               2.9F,
               0.11F,
               3.25F,
               -0.005F,
               3.5F,
               0.0F
         },
         {0.0F, 0.0F, 0.5F, 0.08F, 2.25F, 0.09F, 2.9F, 0.07F, 3.25F, -0.004F, 3.5F, 0.0F},
         {0.0F, 0.0F, 0.12F, -2.0F, 0.5F, 9.0F, 0.86F, 6.0F, 0.98F, 13.0F, 1.3F, 9.0F, 1.58F, 10.0F, 1.74F, 7.0F, 1.98F, 9.0F, 2.9F, 9.0F, 3.5F, 0.0F},
         {0.0F, 0.0F, 0.5F, 0.4F, 1.92F, 0.4F, 2.25F, 14.0F, 2.6F, 13.0F, 2.9F, 0.4F, 3.5F, 0.0F},
         {0.0F, 0.0F, 0.12F, 1.0F, 0.5F, -8.0F, 2.9F, -7.5F, 3.5F, 0.0F},
         {
               0.0F,
               0.0F,
               0.12F,
               3.0F,
               0.5F,
               -18.0F,
               0.75F,
               -18.0F,
               0.86F,
               -30.0F,
               0.97F,
               -6.0F,
               1.2F,
               -18.0F,
               1.62F,
               -18.0F,
               1.72F,
               -12.0F,
               1.92F,
               -18.0F,
               2.25F,
               -14.0F,
               2.6F,
               -15.0F,
               2.9F,
               -18.0F,
               3.5F,
               0.0F
         },
         {0.0F, 0.0F, 0.5F, -6.8F, 1.92F, -6.8F, 2.25F, 30.0F, 2.6F, 28.0F, 2.9F, -6.8F, 3.5F, 0.0F},
         {0.0F, 0.0F, 0.5F, -6.0F, 1.9F, -6.0F, 2.25F, -20.0F, 2.6F, -16.0F, 2.9F, -6.0F, 3.5F, 0.0F},
         {0.0F, 0.0F, 0.97F, 0.0F, 1.12F, 30.0F, 1.58F, 335.0F, 1.67F, 364.0F, 1.75F, 358.0F, 1.82F, 360.0F, 3.5F, 360.0F},
         var0,
         var0,
         {0.0F, 0.0F, 0.9F, 0.0F, 1.06F, 4.0F, 1.64F, 4.0F, 1.78F, -0.3F, 1.88F, 0.0F, 2.0F, 0.0F, 2.22F, 2.4F, 2.62F, 2.2F, 2.85F, 0.0F, 3.5F, 0.0F},
         {0.0F, 0.0F, 0.12F, -3.0F, 0.5F, 4.0F, 1.0F, 6.0F, 1.8F, 2.0F, 2.25F, -4.0F, 2.9F, 3.0F, 3.5F, 0.0F},
         var0,
         var0,
         var0,
         {0.0F, 0.0F, 0.93F, 0.0F, 1.3F, -0.02F, 1.67F, 0.0F, 3.5F, 0.0F},
         {0.0F, 0.0F, 0.93F, 0.0F, 1.3F, 0.3F, 1.55F, 0.11F, 1.67F, 0.0F, 3.5F, 0.0F},
         {0.0F, 0.0F, 0.93F, 0.0F, 1.3F, 0.02F, 1.67F, 0.0F, 3.5F, 0.0F},
         {0.0F, 0.0F, 0.78F, 0.0F, 0.9F, 8.1F, 1.84F, 8.1F, 1.98F, 0.0F, 3.5F, 0.0F}
      };
      CUES[var1] = new float[]{0.97F, 2.0F, 1.7F, 0.35F, 1.67F, 0.0F, 1.8F, 0.55F, 2.25F, 4.0F, 1.5F, 0.45F, 3.25F, 1.0F, 1.6F, 0.3F};
      ANIM[var1 + 1] = new float[][]{
         {
               0.0F,
               0.0F,
               0.12F,
               0.008F,
               0.45F,
               -0.16F,
               0.62F,
               -0.165F,
               0.86F,
               -0.17F,
               0.98F,
               -0.17F,
               1.45F,
               -0.18F,
               1.9F,
               -0.17F,
               2.1F,
               -0.165F,
               2.36F,
               -0.16F,
               2.5F,
               -0.16F,
               3.1F,
               0.005F,
               3.4F,
               0.0F
         },
         {
               0.0F,
               0.0F,
               0.12F,
               -0.012F,
               0.45F,
               0.1F,
               0.62F,
               0.095F,
               0.86F,
               0.2F,
               0.98F,
               0.19F,
               1.45F,
               0.2F,
               1.9F,
               0.19F,
               2.1F,
               0.2F,
               2.36F,
               0.1F,
               2.5F,
               0.105F,
               3.1F,
               -0.005F,
               3.4F,
               0.0F
         },
         {0.0F, 0.0F, 0.45F, 0.06F, 0.62F, 0.06F, 0.86F, 0.03F, 1.9F, 0.03F, 2.36F, 0.06F, 2.5F, 0.06F, 3.1F, -0.003F, 3.4F, 0.0F},
         {
               0.0F,
               0.0F,
               0.12F,
               -2.0F,
               0.45F,
               9.0F,
               0.62F,
               8.0F,
               0.86F,
               22.0F,
               0.98F,
               20.0F,
               1.45F,
               22.0F,
               1.9F,
               20.0F,
               2.1F,
               21.0F,
               2.36F,
               9.0F,
               2.5F,
               9.0F,
               3.4F,
               0.0F
         },
         {0.0F, 0.0F, 0.45F, 0.4F, 0.86F, -2.6F, 1.9F, -2.6F, 2.36F, 0.4F, 3.4F, 0.0F},
         {0.0F, 0.0F, 0.12F, 1.0F, 0.45F, -8.0F, 0.62F, -8.0F, 0.86F, -18.0F, 0.98F, -17.5F, 1.9F, -17.5F, 2.36F, -8.0F, 2.5F, -8.0F, 3.4F, 0.0F},
         {
               0.0F,
               0.0F,
               0.12F,
               3.0F,
               0.45F,
               -2.0F,
               0.62F,
               12.0F,
               0.86F,
               -105.0F,
               0.98F,
               -96.0F,
               1.45F,
               -98.0F,
               1.9F,
               -98.0F,
               2.1F,
               -88.0F,
               2.36F,
               8.0F,
               2.5F,
               -2.0F,
               3.1F,
               1.0F,
               3.4F,
               0.0F
         },
         {0.0F, 0.0F, 0.45F, -2.0F, 0.62F, 2.0F, 0.86F, -26.0F, 0.98F, -24.0F, 1.45F, -20.0F, 1.9F, -24.0F, 2.1F, -22.0F, 2.36F, 2.0F, 2.5F, -1.0F, 3.4F, 0.0F},
         {0.0F, 0.0F, 0.45F, -4.0F, 0.62F, -6.0F, 0.86F, 46.0F, 0.98F, 42.0F, 1.45F, 58.0F, 1.9F, 42.0F, 2.1F, 40.0F, 2.36F, -6.0F, 2.5F, -3.0F, 3.4F, 0.0F},
         var0,
         var0,
         var0,
         {0.0F, 0.0F, 0.62F, 0.0F, 0.86F, -4.4F, 0.98F, -4.0F, 1.9F, -4.0F, 2.1F, -3.6F, 2.36F, 0.4F, 2.5F, 0.0F, 3.4F, 0.0F},
         {0.0F, 0.0F, 0.12F, -3.0F, 0.45F, 4.0F, 0.98F, 2.0F, 1.45F, 24.0F, 1.9F, 4.0F, 2.36F, 2.0F, 3.4F, 0.0F},
         var0,
         {0.0F, 0.0F, 0.62F, 0.0F, 0.86F, 0.5F, 2.1F, 0.5F, 2.36F, 0.0F, 3.4F, 0.0F},
         {0.0F, 0.0F, 0.62F, 0.0F, 0.86F, -0.45F, 2.1F, -0.45F, 2.36F, 0.0F, 3.4F, 0.0F}
      };
      CUES[var1 + 1] = new float[]{
         0.62F, 1.0F, 1.6F, 0.35F, 0.86F, 0.0F, 1.75F, 0.55F, 1.45F, 4.0F, 1.5F, 0.45F, 2.36F, 0.0F, 1.8F, 0.55F, 3.1F, 1.0F, 1.55F, 0.3F
      };
   }

   private static void h() {

      float[] var0 = new float[0];
      byte var1 = 24;
      ANIM[var1] = new float[][]{
         {0.0F, 0.0F, 0.12F, 0.008F, 0.45F, -0.17F, 1.2F, -0.175F, 1.9F, -0.18F, 2.4F, -0.175F, 3.0F, -0.17F, 3.35F, 0.005F, 3.6F, 0.0F},
         {
               0.0F,
               0.0F,
               0.12F,
               -0.012F,
               0.45F,
               0.1F,
               0.56F,
               0.09F,
               0.66F,
               0.125F,
               0.92F,
               0.11F,
               1.14F,
               0.12F,
               1.28F,
               0.092F,
               1.46F,
               0.104F,
               1.64F,
               0.086F,
               1.76F,
               0.13F,
               2.08F,
               0.115F,
               2.36F,
               0.122F,
               2.48F,
               0.09F,
               2.66F,
               0.104F,
               3.0F,
               0.1F,
               3.35F,
               -0.005F,
               3.6F,
               0.0F
         },
         {0.0F, 0.0F, 0.45F, 0.07F, 3.0F, 0.07F, 3.35F, -0.004F, 3.6F, 0.0F},
         {
               0.0F,
               0.0F,
               0.12F,
               -2.0F,
               0.45F,
               8.0F,
               0.56F,
               5.0F,
               0.66F,
               11.0F,
               1.24F,
               6.0F,
               1.42F,
               8.0F,
               1.64F,
               5.0F,
               1.76F,
               12.0F,
               2.44F,
               6.0F,
               2.62F,
               8.0F,
               3.0F,
               8.0F,
               3.6F,
               0.0F
         },
         {0.0F, 0.0F, 0.45F, 0.4F, 2.62F, 0.4F, 2.9F, 5.0F, 3.6F, 0.0F},
         {0.0F, 0.0F, 0.12F, 1.0F, 0.45F, -7.0F, 3.0F, -7.0F, 3.6F, 0.0F},
         {
               0.0F,
               0.0F,
               0.12F,
               3.0F,
               0.45F,
               -15.0F,
               0.56F,
               -26.0F,
               0.66F,
               -6.0F,
               0.9F,
               -15.0F,
               1.12F,
               -15.0F,
               1.24F,
               -9.0F,
               1.42F,
               -15.0F,
               1.64F,
               -28.0F,
               1.76F,
               -5.0F,
               2.05F,
               -15.0F,
               2.32F,
               -15.0F,
               2.44F,
               -9.0F,
               2.62F,
               -15.0F,
               3.0F,
               -15.0F,
               3.6F,
               0.0F
         },
         {0.0F, 0.0F, 0.45F, -6.8F, 2.62F, -6.8F, 2.9F, -20.0F, 3.15F, -16.0F, 3.6F, 0.0F},
         {
               0.0F,
               0.0F,
               0.45F,
               -6.0F,
               1.7F,
               -6.0F,
               1.86F,
               30.0F,
               2.24F,
               160.0F,
               2.38F,
               182.0F,
               2.46F,
               178.0F,
               2.66F,
               180.0F,
               2.95F,
               352.0F,
               3.05F,
               362.0F,
               3.15F,
               358.0F,
               3.6F,
               360.0F
         },
         {
               0.0F,
               0.0F,
               0.64F,
               0.0F,
               0.8F,
               40.0F,
               1.08F,
               332.0F,
               1.16F,
               364.0F,
               1.23F,
               358.0F,
               1.3F,
               360.0F,
               1.74F,
               360.0F,
               1.9F,
               400.0F,
               2.28F,
               692.0F,
               2.38F,
               724.0F,
               2.45F,
               717.0F,
               2.52F,
               720.0F,
               3.6F,
               720.0F
         },
         var0,
         var0,
         {
               0.0F,
               0.0F,
               0.6F,
               0.0F,
               0.74F,
               4.5F,
               1.12F,
               4.5F,
               1.24F,
               -0.3F,
               1.34F,
               0.0F,
               1.7F,
               0.0F,
               1.84F,
               4.5F,
               2.34F,
               4.5F,
               2.46F,
               -0.3F,
               2.56F,
               0.0F,
               3.6F,
               0.0F
         },
         {0.0F, 0.0F, 0.12F, -3.0F, 0.45F, 4.0F, 1.2F, 5.0F, 1.76F, 7.0F, 2.5F, 4.0F, 3.0F, 5.0F, 3.6F, 0.0F},
         var0,
         var0,
         var0,
         {0.0F, 0.0F, 0.64F, 0.0F, 0.92F, -0.05F, 1.16F, 0.0F, 1.72F, 0.0F, 2.08F, -0.05F, 2.38F, 0.0F, 3.6F, 0.0F},
         {0.0F, 0.0F, 0.64F, 0.0F, 0.92F, 0.24F, 1.08F, 0.09F, 1.16F, 0.0F, 1.72F, 0.0F, 2.08F, 0.29F, 2.3F, 0.1F, 2.38F, 0.0F, 3.6F, 0.0F},
         {0.0F, 0.0F, 0.64F, 0.0F, 0.92F, 0.03F, 1.16F, 0.0F, 1.72F, 0.0F, 2.08F, 0.03F, 2.38F, 0.0F, 3.6F, 0.0F},
         {0.0F, 0.0F, 0.48F, 0.0F, 0.58F, 1.5F, 2.55F, 1.5F, 2.7F, 0.0F, 3.6F, 0.0F}
      };
      CUES[var1] = new float[]{
         0.66F, 2.0F, 1.7F, 0.3F, 1.16F, 0.0F, 1.7F, 0.55F, 1.76F, 2.0F, 1.6F, 0.35F, 2.38F, 0.0F, 1.65F, 0.6F, 2.95F, 4.0F, 1.35F, 0.45F
      };
      ANIM[var1 + 1] = new float[][]{
         {0.0F, 0.0F, 0.12F, 0.008F, 0.45F, -0.21F, 1.0F, -0.255F, 2.35F, -0.252F, 2.7F, -0.212F, 3.4F, -0.205F, 3.65F, 0.005F, 3.85F, 0.0F},
         {
               0.0F,
               0.0F,
               0.12F,
               -0.012F,
               0.45F,
               0.137F,
               1.0F,
               0.225F,
               1.45F,
               0.235F,
               1.9F,
               0.225F,
               2.35F,
               0.228F,
               2.7F,
               0.137F,
               3.4F,
               0.13F,
               3.65F,
               -0.005F,
               3.85F,
               0.0F
         },
         {0.0F, 0.0F, 0.45F, 0.1F, 3.4F, 0.09F, 3.65F, -0.004F, 3.85F, 0.0F},
         {0.0F, 0.0F, 0.12F, -2.0F, 0.45F, 11.0F, 3.4F, 11.0F, 3.85F, 0.0F},
         {0.0F, 0.0F, 0.45F, 0.4F, 2.7F, 0.4F, 3.05F, 7.0F, 3.4F, 4.0F, 3.85F, 0.0F},
         {0.0F, 0.0F, 0.12F, 1.0F, 0.45F, -9.2F, 3.4F, -9.0F, 3.85F, 0.0F},
         {0.0F, 0.0F, 0.12F, 3.0F, 0.45F, -21.0F, 0.62F, -21.0F, 0.92F, 14.9F, 2.35F, 14.9F, 2.62F, -21.0F, 3.05F, -14.0F, 3.4F, -18.0F, 3.85F, 0.0F},
         {0.0F, 0.0F, 0.45F, -6.8F, 0.62F, -6.8F, 0.92F, -37.1F, 2.35F, -37.1F, 2.62F, -6.8F, 3.05F, -26.0F, 3.4F, -10.0F, 3.85F, 0.0F},
         {0.0F, 0.0F, 0.45F, -10.0F, 0.62F, -10.0F, 0.92F, 120.9F, 2.35F, 120.9F, 2.62F, -10.0F, 3.05F, -40.0F, 3.4F, -14.0F, 3.85F, 0.0F},
         {0.0F, 0.0F, 1.08F, 0.0F, 1.14F, -8.0F, 1.32F, 130.0F, 1.98F, 700.0F, 2.12F, 725.0F, 2.2F, 717.0F, 2.28F, 720.0F, 3.85F, 720.0F},
         var0,
         var0,
         {0.0F, 0.0F, 0.5F, 0.0F, 0.68F, 4.5F, 0.86F, 4.5F, 1.04F, -5.3F, 2.26F, -5.3F, 2.44F, 4.5F, 2.56F, 4.5F, 2.72F, 0.0F, 3.85F, 0.0F},
         {0.0F, 0.0F, 0.12F, -3.0F, 0.45F, 4.0F, 1.08F, 1.0F, 1.45F, 4.0F, 1.9F, -1.0F, 2.3F, 2.0F, 3.05F, 6.0F, 3.85F, 0.0F},
         {0.0F, 0.0F, 0.7F, 0.0F, 0.9F, 1.0F, 2.42F, 1.0F, 2.6F, 0.0F, 3.85F, 0.0F}
      };
      CUES[var1 + 1] = new float[]{
         0.68F,
         1.0F,
         1.5F,
         0.4F,
         1.32F,
         3.0F,
         1.3F,
         0.5F,
         1.7F,
         3.0F,
         1.45F,
         0.55F,
         2.12F,
         1.0F,
         1.4F,
         0.55F,
         2.72F,
         1.0F,
         1.55F,
         0.4F,
         3.05F,
         4.0F,
         1.3F,
         0.45F
      };
   }

   private static void i() {

      float[] var0 = new float[0];
      byte var1 = 26;
      ANIM[var1] = new float[][]{
         {0.0F, 0.0F, 0.12F, 0.008F, 0.5F, -0.21F, 0.78F, -0.24F, 1.95F, -0.242F, 2.3F, -0.21F, 3.0F, -0.2F, 3.35F, 0.005F, 3.6F, 0.0F},
         {0.0F, 0.0F, 0.12F, -0.012F, 0.5F, 0.14F, 0.78F, 0.185F, 1.4F, 0.192F, 1.95F, 0.186F, 2.3F, 0.14F, 3.0F, 0.135F, 3.35F, -0.005F, 3.6F, 0.0F},
         {0.0F, 0.0F, 0.5F, 0.1F, 3.0F, 0.09F, 3.35F, -0.004F, 3.6F, 0.0F},
         {0.0F, 0.0F, 0.12F, -2.0F, 0.5F, 10.5F, 0.78F, 11.5F, 1.95F, 11.5F, 2.3F, 10.5F, 3.0F, 11.0F, 3.6F, 0.0F},
         {0.0F, 0.0F, 0.5F, -4.6F, 0.78F, -5.3F, 1.95F, -5.3F, 2.3F, -4.6F, 2.65F, -1.0F, 3.6F, 0.0F},
         {0.0F, 0.0F, 0.12F, 1.0F, 0.5F, -8.8F, 0.78F, -9.7F, 1.95F, -9.7F, 2.3F, -8.8F, 3.6F, 0.0F},
         {0.0F, 0.0F, 0.12F, 3.0F, 0.5F, -1.0F, 0.78F, -2.6F, 1.95F, -2.6F, 2.3F, -1.0F, 2.65F, -8.0F, 3.0F, -3.0F, 3.6F, 0.0F},
         {0.0F, 0.0F, 0.45F, -20.0F, 0.75F, 5.6F, 1.95F, 5.6F, 2.25F, -20.0F, 2.65F, -32.0F, 2.85F, -26.0F, 3.6F, 0.0F},
         {0.0F, 0.0F, 0.5F, -3.9F, 0.78F, 2.9F, 1.95F, 2.9F, 2.3F, -3.9F, 2.65F, -42.0F, 2.85F, -36.0F, 3.6F, 0.0F},
         {0.0F, 0.0F, 0.8F, 0.0F, 0.86F, 10.0F, 1.05F, -110.0F, 1.52F, -560.0F, 1.82F, -724.0F, 1.9F, -717.0F, 1.98F, -720.0F, 3.6F, -720.0F},
         var0,
         var0,
         {0.0F, 0.0F, 0.35F, 0.0F, 0.6F, 4.2F, 1.98F, 4.2F, 2.22F, 0.0F, 3.6F, 0.0F},
         {0.0F, 0.0F, 0.12F, -3.0F, 0.5F, 4.0F, 1.4F, 3.0F, 2.3F, 5.0F, 2.65F, -3.0F, 3.6F, 0.0F},
         {0.0F, 0.0F, 0.45F, 0.0F, 0.7F, 1.0F, 2.0F, 1.0F, 2.25F, 0.0F, 3.6F, 0.0F}
      };
      CUES[var1] = new float[]{
         0.6F,
         1.0F,
         1.5F,
         0.45F,
         1.05F,
         3.0F,
         1.25F,
         0.55F,
         1.52F,
         3.0F,
         1.45F,
         0.6F,
         1.82F,
         1.0F,
         1.35F,
         0.55F,
         2.22F,
         1.0F,
         1.5F,
         0.4F,
         2.65F,
         4.0F,
         1.3F,
         0.45F
      };
      ANIM[var1 + 1] = new float[][]{
         {
               0.0F,
               0.0F,
               0.12F,
               0.008F,
               0.5F,
               -0.21F,
               0.78F,
               -0.24F,
               1.14F,
               -0.25F,
               1.5F,
               -0.25F,
               1.8F,
               -0.24F,
               2.53F,
               -0.24F,
               2.83F,
               -0.21F,
               3.28F,
               -0.2F,
               3.53F,
               0.005F,
               3.73F,
               0.0F
         },
         {
               0.0F,
               0.0F,
               0.12F,
               -0.012F,
               0.5F,
               0.14F,
               0.78F,
               0.185F,
               1.14F,
               0.15F,
               1.5F,
               0.145F,
               1.8F,
               0.18F,
               2.18F,
               0.195F,
               2.53F,
               0.185F,
               2.83F,
               0.14F,
               3.28F,
               0.135F,
               3.53F,
               -0.005F,
               3.73F,
               0.0F
         },
         {0.0F, 0.0F, 0.5F, 0.1F, 0.85F, 0.1F, 1.14F, 0.06F, 1.5F, 0.06F, 1.8F, 0.1F, 3.28F, 0.09F, 3.53F, -0.004F, 3.73F, 0.0F},
         {0.0F, 0.0F, 0.12F, -2.0F, 0.5F, 10.5F, 0.78F, 11.5F, 2.53F, 11.5F, 2.83F, 10.5F, 3.73F, 0.0F},
         {0.0F, 0.0F, 0.5F, -4.6F, 0.78F, -5.3F, 2.53F, -5.3F, 2.83F, -4.6F, 3.73F, 0.0F},
         {0.0F, 0.0F, 0.12F, 1.0F, 0.5F, -8.8F, 0.78F, -9.7F, 2.53F, -9.7F, 2.83F, -8.8F, 3.73F, 0.0F},
         {0.0F, 0.0F, 0.12F, 3.0F, 0.5F, -1.0F, 0.78F, -2.6F, 2.53F, -2.6F, 2.83F, -1.0F, 3.23F, -4.0F, 3.73F, 0.0F},
         {0.0F, 0.0F, 0.45F, -20.0F, 0.75F, 5.6F, 1.22F, 5.6F, 1.36F, -14.0F, 1.5F, 5.6F, 2.53F, 5.6F, 2.83F, -6.0F, 3.73F, 0.0F},
         {0.0F, 0.0F, 0.5F, -3.9F, 0.78F, 2.9F, 1.22F, 2.9F, 1.36F, -30.0F, 1.5F, 2.9F, 2.53F, 2.9F, 2.83F, -3.9F, 3.73F, 0.0F},
         {
               0.0F,
               0.0F,
               0.84F,
               0.0F,
               0.93F,
               4.0F,
               1.12F,
               -104.0F,
               1.2F,
               -98.0F,
               1.27F,
               -100.0F,
               1.46F,
               -100.0F,
               1.54F,
               -105.0F,
               1.74F,
               2.0F,
               1.82F,
               -1.0F,
               1.88F,
               0.0F,
               1.96F,
               0.0F,
               2.05F,
               5.0F,
               2.48F,
               -365.0F,
               2.56F,
               -358.0F,
               2.63F,
               -360.0F,
               3.73F,
               -360.0F
         },
         var0,
         var0,
         {0.0F, 0.0F, 0.35F, 0.0F, 0.6F, 4.2F, 2.54F, 4.2F, 2.78F, 0.0F, 3.73F, 0.0F},
         {0.0F, 0.0F, 0.12F, -3.0F, 0.5F, 4.0F, 1.14F, 6.0F, 1.5F, 2.0F, 2.18F, 6.0F, 2.83F, 5.0F, 3.73F, 0.0F},
         {0.0F, 0.0F, 0.45F, 0.0F, 0.7F, 1.0F, 2.58F, 1.0F, 2.82F, 0.0F, 3.73F, 0.0F}
      };
      CUES[var1 + 1] = new float[]{
         0.6F,
         1.0F,
         1.5F,
         0.45F,
         1.0F,
         2.0F,
         1.6F,
         0.35F,
         1.12F,
         1.0F,
         1.45F,
         0.55F,
         1.36F,
         4.0F,
         1.35F,
         0.45F,
         1.74F,
         1.0F,
         1.5F,
         0.5F,
         2.23F,
         2.0F,
         1.7F,
         0.4F,
         2.48F,
         1.0F,
         1.4F,
         0.55F,
         2.78F,
         1.0F,
         1.5F,
         0.4F
      };
   }

   private static void j() {

      float[] var0 = new float[0];
      byte var1 = 28;
      ANIM[var1] = new float[][]{
         {0.0F, 0.0F, 0.15F, 0.008F, 0.6F, -0.12F, 1.6F, -0.13F, 2.0F, -0.19F, 2.6F, -0.195F, 3.05F, -0.14F, 3.45F, 0.005F, 3.7F, 0.0F},
         {0.0F, 0.0F, 0.15F, -0.012F, 0.6F, 0.1F, 1.6F, 0.105F, 2.0F, 0.15F, 2.6F, 0.155F, 3.05F, 0.1F, 3.45F, -0.005F, 3.7F, 0.0F},
         {0.0F, 0.0F, 0.6F, 0.04F, 2.0F, 0.05F, 2.6F, 0.05F, 3.05F, 0.04F, 3.45F, -0.003F, 3.7F, 0.0F},
         {0.0F, 0.0F, 0.15F, -2.0F, 0.6F, 6.0F, 1.6F, 6.5F, 2.0F, 8.0F, 2.6F, 8.0F, 3.05F, 6.0F, 3.7F, 0.0F},
         {0.0F, 0.0F, 0.6F, -2.0F, 1.6F, -2.0F, 2.0F, -9.0F, 2.6F, 3.0F, 3.05F, -2.0F, 3.7F, 0.0F},
         {0.0F, 0.0F, 0.15F, 1.0F, 0.6F, -5.0F, 1.6F, -5.0F, 2.0F, -2.0F, 2.6F, -2.0F, 3.05F, -3.0F, 3.7F, 0.0F},
         {0.0F, 0.0F, 0.15F, 3.0F, 0.6F, -10.0F, 1.6F, -10.0F, 2.0F, -30.0F, 2.6F, -29.0F, 3.05F, -10.0F, 3.7F, 0.0F},
         {0.0F, 0.0F, 0.6F, 0.0F, 1.6F, 0.0F, 2.0F, -10.0F, 2.6F, -8.0F, 3.05F, 0.0F, 3.7F, 0.0F},
         {
               0.0F,
               0.0F,
               0.6F,
               0.0F,
               0.75F,
               -8.0F,
               1.05F,
               90.0F,
               1.35F,
               270.0F,
               1.58F,
               364.0F,
               1.67F,
               357.0F,
               1.76F,
               360.0F,
               2.0F,
               345.0F,
               2.6F,
               342.0F,
               3.05F,
               360.0F,
               3.7F,
               360.0F
         },
         var0,
         var0,
         var0,
         var0,
         {0.0F, 0.0F, 0.15F, -4.0F, 0.6F, 5.0F, 1.6F, 5.0F, 2.0F, 8.0F, 2.6F, 7.0F, 3.05F, 4.0F, 3.45F, -2.0F, 3.7F, 0.0F}
      };
      CUES[var1] = new float[]{
         0.15F,
         6.0F,
         1.2F,
         0.25F,
         1.05F,
         4.0F,
         0.95F,
         0.45F,
         1.35F,
         4.0F,
         1.05F,
         0.45F,
         1.67F,
         1.0F,
         1.0F,
         0.35F,
         2.05F,
         4.0F,
         0.9F,
         0.5F,
         3.05F,
         1.0F,
         1.0F,
         0.3F
      };
      ANIM[var1 + 1] = new float[][]{
         {
               0.0F,
               0.0F,
               0.15F,
               0.008F,
               0.7F,
               -0.11F,
               1.2F,
               -0.1F,
               2.0F,
               -0.08F,
               2.12F,
               -0.075F,
               2.26F,
               -0.06F,
               2.45F,
               -0.07F,
               3.1F,
               -0.05F,
               3.5F,
               0.005F,
               3.75F,
               0.0F
         },
         {
               0.0F,
               0.0F,
               0.15F,
               -0.012F,
               0.7F,
               0.12F,
               1.2F,
               0.115F,
               2.0F,
               0.08F,
               2.12F,
               0.085F,
               2.26F,
               0.065F,
               2.45F,
               0.072F,
               3.1F,
               0.03F,
               3.5F,
               -0.004F,
               3.75F,
               0.0F
         },
         {0.0F, 0.0F, 0.7F, 0.04F, 2.0F, 0.03F, 2.45F, 0.02F, 3.1F, 0.01F, 3.75F, 0.0F},
         {0.0F, 0.0F, 0.15F, -2.0F, 0.7F, 8.0F, 2.0F, 6.0F, 2.26F, 2.0F, 2.45F, 4.0F, 3.1F, 3.0F, 3.75F, 0.0F},
         {0.0F, 0.0F, 0.7F, -4.0F, 2.0F, -2.0F, 2.26F, 3.0F, 2.45F, 1.0F, 3.1F, 1.0F, 3.75F, 0.0F},
         {0.0F, 0.0F, 0.15F, 1.0F, 0.7F, -12.0F, 2.0F, -4.0F, 2.12F, -2.0F, 2.26F, 10.0F, 2.34F, 13.0F, 2.45F, 11.0F, 3.1F, 5.0F, 3.75F, 0.0F},
         {0.0F, 0.0F, 0.15F, 3.0F, 0.7F, 42.0F, 1.2F, 40.0F, 2.0F, 6.0F, 2.12F, 8.0F, 2.26F, -26.0F, 2.34F, -30.0F, 2.45F, -27.0F, 3.1F, -12.0F, 3.75F, 0.0F},
         {0.0F, 0.0F, 0.7F, -6.0F, 2.0F, -2.0F, 2.45F, 0.0F, 3.75F, 0.0F},
         {0.0F, 0.0F, 0.7F, 62.0F, 1.2F, 64.0F, 2.0F, 20.0F, 2.26F, 4.0F, 3.1F, 2.0F, 3.75F, 0.0F},
         var0,
         var0,
         var0,
         var0,
         {0.0F, 0.0F, 0.15F, -4.0F, 0.7F, 6.0F, 2.0F, 3.0F, 2.26F, -6.0F, 2.45F, -4.0F, 3.1F, 0.0F, 3.75F, 0.0F}
      };
      CUES[var1 + 1] = new float[]{
         0.15F, 6.0F, 1.2F, 0.25F, 0.7F, 4.0F, 0.9F, 0.45F, 2.0F, 4.0F, 1.0F, 0.4F, 2.2F, 2.0F, 1.2F, 0.45F, 2.34F, 1.0F, 0.95F, 0.4F
      };
   }

   private static void k() {

      float[] var0 = new float[0];
      byte var1 = 30;
      ANIM[var1] = new float[][]{
         {0.0F, 0.0F, 0.3F, -0.06F, 0.55F, -0.13F, 0.82F, -0.25F, 1.12F, -0.2F, 1.6F, -0.24F, 2.2F, -0.22F, 2.6F, 0.005F, 2.9F, 0.0F},
         {0.0F, 0.0F, 0.3F, -0.035F, 0.46F, 0.06F, 0.8F, 0.3F, 1.1F, 0.04F, 1.2F, -0.005F, 1.42F, 0.04F, 1.65F, 0.08F, 2.2F, 0.075F, 2.6F, -0.004F, 2.9F, 0.0F},
         {0.0F, 0.0F, 0.8F, 0.05F, 1.15F, 0.02F, 1.65F, 0.08F, 2.2F, 0.075F, 2.6F, 0.0F, 2.9F, 0.0F},
         {0.0F, 0.0F, 0.3F, -8.0F, 0.46F, 6.0F, 1.1F, 4.0F, 1.24F, 10.0F, 1.65F, -6.0F, 2.2F, -4.0F, 2.9F, 0.0F},
         {0.0F, 0.0F, 1.4F, 0.0F, 1.85F, 28.0F, 2.25F, 24.0F, 2.65F, 0.0F, 2.9F, 0.0F},
         {0.0F, 0.0F, 0.3F, 4.0F, 0.5F, -3.0F, 1.65F, -8.0F, 2.2F, -6.0F, 2.9F, 0.0F},
         var0,
         var0,
         var0,
         var0,
         {0.0F, 0.0F, 0.42F, 0.0F, 0.5F, -20.0F, 0.98F, -338.0F, 1.1F, -365.0F, 1.19F, -357.0F, 1.27F, -360.0F, 2.9F, -360.0F}
      };
      CUES[var1] = new float[]{0.46F, 2.0F, 1.5F, 0.35F, 1.1F, 0.0F, 1.4F, 0.5F, 1.85F, 4.0F, 1.2F, 0.4F};
      ANIM[var1 + 1] = new float[][]{
         {0.0F, 0.0F, 0.15F, 0.01F, 0.6F, -0.3F, 1.4F, -0.31F, 2.2F, -0.3F, 2.75F, -0.25F, 3.15F, 0.005F, 3.4F, 0.0F},
         {0.0F, 0.0F, 0.15F, -0.015F, 0.6F, 0.14F, 1.4F, 0.15F, 2.2F, 0.145F, 2.75F, 0.1F, 3.15F, -0.004F, 3.4F, 0.0F},
         {0.0F, 0.0F, 0.6F, 0.06F, 1.4F, 0.07F, 2.2F, 0.065F, 2.75F, 0.04F, 3.15F, 0.0F, 3.4F, 0.0F},
         {0.0F, 0.0F, 0.15F, -3.0F, 0.6F, -14.0F, 1.0F, -18.0F, 1.4F, -16.0F, 2.2F, -10.0F, 2.75F, -4.0F, 3.4F, 0.0F},
         {0.0F, 0.0F, 0.6F, 6.0F, 1.0F, -4.0F, 1.4F, 3.0F, 2.2F, 0.0F, 3.4F, 0.0F},
         {0.0F, 0.0F, 0.15F, 2.0F, 0.6F, -6.0F, 1.4F, -4.0F, 2.2F, -5.0F, 2.75F, -2.0F, 3.4F, 0.0F},
         var0,
         var0,
         var0,
         {0.0F, 0.0F, 0.6F, 0.0F, 1.0F, -8.0F, 1.45F, 84.0F, 1.55F, 92.0F, 1.65F, 90.0F, 2.05F, 90.0F, 2.45F, -4.0F, 2.6F, 2.0F, 2.72F, 0.0F, 3.4F, 0.0F}
      };
      CUES[var1 + 1] = new float[]{0.15F, 3.0F, 0.9F, 0.25F, 0.6F, 1.0F, 1.2F, 0.3F, 1.5F, 4.0F, 1.15F, 0.45F, 2.45F, 4.0F, 1.0F, 0.35F};
      ANIM[var1 + 2] = new float[][]{
         {
               0.0F,
               0.0F,
               0.35F,
               -0.02F,
               0.62F,
               -0.05F,
               0.85F,
               -0.04F,
               1.08F,
               -0.06F,
               1.3F,
               -0.06F,
               1.7F,
               -0.25F,
               2.3F,
               -0.26F,
               2.85F,
               -0.15F,
               3.15F,
               0.005F,
               3.35F,
               0.0F
         },
         {
               0.0F,
               0.0F,
               0.35F,
               -0.06F,
               0.5F,
               -0.065F,
               0.62F,
               -0.02F,
               0.76F,
               -0.055F,
               0.9F,
               -0.045F,
               1.02F,
               -0.025F,
               1.14F,
               -0.05F,
               1.3F,
               -0.04F,
               1.7F,
               0.09F,
               2.3F,
               0.095F,
               2.85F,
               0.05F,
               3.15F,
               -0.004F,
               3.35F,
               0.0F
         },
         {0.0F, 0.0F, 0.62F, 0.02F, 1.3F, 0.01F, 1.7F, 0.08F, 2.3F, 0.08F, 2.85F, 0.04F, 3.35F, 0.0F},
         {
               0.0F,
               0.0F,
               0.35F,
               -12.0F,
               0.5F,
               -13.0F,
               0.62F,
               4.0F,
               0.76F,
               -9.0F,
               0.9F,
               -6.0F,
               1.02F,
               2.0F,
               1.14F,
               -6.0F,
               1.3F,
               -4.0F,
               1.7F,
               6.0F,
               2.3F,
               4.0F,
               2.85F,
               -2.0F,
               3.35F,
               0.0F
         },
         {0.0F, 0.0F, 1.3F, 0.0F, 1.7F, -10.0F, 2.3F, 8.0F, 2.85F, 4.0F, 3.35F, 0.0F},
         {0.0F, 0.0F, 0.35F, 6.0F, 0.62F, -4.0F, 1.02F, -3.0F, 1.3F, 2.0F, 1.7F, -6.0F, 2.3F, -5.0F, 3.35F, 0.0F},
         var0,
         var0,
         var0,
         {0.0F, 0.0F, 1.55F, 0.0F, 1.6F, -6.0F, 2.0F, 184.0F, 2.1F, 177.0F, 2.2F, 180.0F, 2.4F, 180.0F, 2.8F, 364.0F, 2.9F, 358.0F, 3.0F, 360.0F, 3.35F, 360.0F}
      };
      CUES[var1 + 2] = new float[]{
         0.62F, 1.0F, 0.9F, 0.45F, 1.02F, 1.0F, 0.95F, 0.4F, 1.8F, 3.0F, 1.0F, 0.4F, 2.1F, 0.0F, 0.9F, 0.35F, 2.8F, 3.0F, 1.1F, 0.35F
      };
   }

   private static void l() {

      float[] var0 = new float[0];
      byte var1 = 33;
      ANIM[var1] = new float[][]{
         {0.0F, 0.0F, 0.15F, 0.01F, 0.65F, -0.24F, 2.3F, -0.25F, 2.85F, -0.15F, 3.15F, 0.005F, 3.35F, 0.0F},
         {0.0F, 0.0F, 0.15F, -0.015F, 0.65F, 0.12F, 1.4F, 0.13F, 2.3F, 0.12F, 2.85F, 0.06F, 3.15F, -0.004F, 3.35F, 0.0F},
         {0.0F, 0.0F, 0.65F, 0.08F, 2.3F, 0.08F, 2.85F, 0.04F, 3.35F, 0.0F},
         {0.0F, 0.0F, 0.15F, 2.0F, 0.65F, 10.0F, 1.4F, 12.0F, 2.3F, 9.0F, 2.85F, 3.0F, 3.35F, 0.0F},
         {0.0F, 0.0F, 0.65F, -6.0F, 1.4F, 4.0F, 2.3F, -3.0F, 2.85F, -1.0F, 3.35F, 0.0F},
         {0.0F, 0.0F, 0.15F, 2.0F, 0.65F, -10.0F, 1.4F, -7.0F, 2.3F, -9.0F, 2.85F, -3.0F, 3.35F, 0.0F},
         var0,
         var0,
         var0,
         {0.0F, 0.0F, 0.7F, 0.0F, 0.78F, -8.0F, 1.15F, 90.0F, 1.6F, 260.0F, 2.05F, 366.0F, 2.16F, 357.0F, 2.26F, 360.0F, 3.35F, 360.0F}
      };
      CUES[var1] = new float[]{0.65F, 1.0F, 1.1F, 0.3F, 1.15F, 3.0F, 0.9F, 0.4F, 1.6F, 3.0F, 1.0F, 0.45F, 2.05F, 4.0F, 1.0F, 0.4F};
      ANIM[var1 + 1] = new float[][]{
         {0.0F, 0.0F, 0.25F, 0.02F, 0.55F, -0.06F, 0.95F, -0.16F, 1.25F, -0.12F, 1.55F, -0.12F, 1.7F, -0.14F, 1.95F, -0.12F, 2.55F, 0.005F, 2.8F, 0.0F},
         {0.0F, 0.0F, 0.25F, -0.03F, 0.55F, 0.05F, 0.95F, 0.11F, 1.25F, 0.09F, 1.55F, 0.07F, 1.95F, 0.06F, 2.55F, -0.004F, 2.8F, 0.0F},
         {0.0F, 0.0F, 0.25F, -0.01F, 0.95F, 0.04F, 1.25F, 0.05F, 1.55F, 0.05F, 1.68F, -0.07F, 1.82F, -0.04F, 2.0F, 0.02F, 2.55F, 0.0F, 2.8F, 0.0F},
         {0.0F, 0.0F, 0.25F, 3.0F, 0.55F, 6.0F, 0.95F, 8.0F, 1.25F, 4.0F, 1.55F, 5.0F, 1.68F, 1.0F, 1.95F, 2.0F, 2.8F, 0.0F},
         var0,
         {0.0F, 0.0F, 0.25F, 6.0F, 0.55F, -16.0F, 0.95F, 14.0F, 1.25F, -2.0F, 1.55F, 0.0F, 2.8F, 0.0F},
         var0,
         var0,
         var0,
         {0.0F, 0.0F, 0.3F, 0.0F, 0.36F, 10.0F, 0.62F, -260.0F, 1.0F, -700.0F, 1.12F, -726.0F, 1.2F, -717.0F, 1.28F, -720.0F, 2.8F, -720.0F}
      };
      CUES[var1 + 1] = new float[]{
         0.36F, 2.0F, 1.2F, 0.4F, 0.75F, 2.0F, 1.4F, 0.45F, 1.12F, 1.0F, 1.0F, 0.45F, 1.68F, 2.0F, 1.0F, 0.4F, 1.82F, 1.0F, 0.9F, 0.3F
      };
      ANIM[var1 + 2] = new float[][]{
         {0.0F, 0.0F, 0.15F, 0.01F, 0.6F, -0.32F, 1.1F, -0.33F, 1.6F, -0.31F, 2.3F, -0.32F, 2.8F, -0.14F, 3.1F, 0.005F, 3.3F, 0.0F},
         {0.0F, 0.0F, 0.15F, -0.015F, 0.6F, 0.15F, 1.1F, 0.16F, 1.6F, 0.15F, 2.3F, 0.155F, 2.8F, 0.07F, 3.1F, -0.004F, 3.3F, 0.0F},
         {0.0F, 0.0F, 0.6F, 0.1F, 1.6F, 0.11F, 2.3F, 0.1F, 2.8F, 0.04F, 3.3F, 0.0F},
         {0.0F, 0.0F, 0.15F, -3.0F, 0.6F, 8.0F, 1.1F, 4.0F, 1.6F, 10.0F, 2.3F, 6.0F, 2.8F, 2.0F, 3.3F, 0.0F},
         {0.0F, 0.0F, 0.6F, -8.0F, 1.1F, 10.0F, 1.6F, -6.0F, 2.3F, 2.0F, 2.8F, 0.0F, 3.3F, 0.0F},
         {0.0F, 0.0F, 0.15F, 2.0F, 0.6F, 14.0F, 1.1F, -12.0F, 1.45F, -8.0F, 2.3F, -6.0F, 2.8F, -2.0F, 3.3F, 0.0F},
         var0,
         var0,
         var0,
         {
               0.0F,
               0.0F,
               1.55F,
               0.0F,
               1.62F,
               -6.0F,
               1.95F,
               184.0F,
               2.05F,
               178.0F,
               2.15F,
               180.0F,
               2.3F,
               180.0F,
               2.6F,
               362.0F,
               2.7F,
               359.0F,
               2.8F,
               360.0F,
               3.3F,
               360.0F
         }
      };
      CUES[var1 + 2] = new float[]{0.6F, 1.0F, 1.2F, 0.3F, 1.1F, 1.0F, 1.1F, 0.3F, 1.95F, 3.0F, 1.1F, 0.4F, 2.6F, 3.0F, 1.0F, 0.35F};
      ANIM[var1 + 3] = new float[][]{
         {0.0F, 0.0F, 0.2F, 0.012F, 0.75F, -0.085F, 1.75F, -0.085F, 2.2F, -0.05F, 2.7F, 0.003F, 3.0F, 0.0F},
         {0.0F, 0.0F, 0.2F, -0.015F, 0.75F, 0.072F, 1.0F, 0.066F, 1.75F, 0.072F, 2.2F, 0.042F, 2.7F, -0.003F, 3.0F, 0.0F},
         {
               0.0F,
               0.0F,
               0.75F,
               -0.018F,
               0.95F,
               -0.018F,
               1.02F,
               0.03F,
               1.14F,
               -0.018F,
               1.3F,
               -0.018F,
               1.37F,
               0.03F,
               1.49F,
               -0.018F,
               1.75F,
               -0.018F,
               2.2F,
               -0.01F,
               3.0F,
               0.0F
         },
         {0.0F, 0.0F, 0.2F, -2.0F, 0.75F, 2.0F, 1.75F, 2.0F, 2.2F, 8.0F, 2.7F, -1.0F, 3.0F, 0.0F},
         {0.0F, 0.0F, 0.75F, -13.0F, 1.75F, -13.0F, 2.2F, -4.0F, 3.0F, 0.0F},
         {0.0F, 0.0F, 0.2F, 2.0F, 0.75F, -4.0F, 1.75F, -4.0F, 2.2F, -1.5F, 3.0F, 0.0F}
      };
      CUES[var1 + 3] = new float[]{0.75F, 3.0F, 0.8F, 0.3F, 1.02F, 0.0F, 0.8F, 0.5F, 1.37F, 0.0F, 0.85F, 0.5F, 2.2F, 1.0F, 0.9F, 0.3F};
      ANIM[var1 + 4] = new float[][]{
         {0.0F, 0.0F, 0.2F, 0.01F, 0.8F, -0.2F, 1.6F, -0.22F, 2.1F, -0.21F, 2.6F, -0.08F, 3.0F, 0.005F, 3.2F, 0.0F},
         {0.0F, 0.0F, 0.2F, -0.02F, 0.8F, 0.06F, 1.6F, 0.065F, 2.1F, 0.06F, 2.6F, 0.02F, 3.0F, -0.004F, 3.2F, 0.0F},
         {0.0F, 0.0F, 0.8F, -0.1F, 1.6F, -0.105F, 2.1F, -0.1F, 2.6F, -0.03F, 3.2F, 0.0F},
         {0.0F, 0.0F, 0.2F, 4.0F, 0.8F, -20.0F, 1.2F, -17.0F, 1.6F, -19.0F, 2.1F, -16.0F, 2.6F, -4.0F, 3.2F, 0.0F},
         {0.0F, 0.0F, 0.8F, 14.0F, 1.2F, 11.0F, 1.6F, 13.0F, 2.1F, 10.0F, 2.6F, 3.0F, 3.2F, 0.0F},
         {0.0F, 0.0F, 0.2F, -3.0F, 0.8F, 18.0F, 1.6F, 16.0F, 2.1F, 17.0F, 2.6F, 4.0F, 3.2F, 0.0F}
      };
      CUES[var1 + 4] = new float[]{0.8F, 3.0F, 1.0F, 0.35F, 1.2F, 1.0F, 1.1F, 0.3F, 2.6F, 3.0F, 0.9F, 0.3F};
      ANIM[var1 + 5] = new float[][]{
         {0.0F, 0.0F, 0.25F, 0.01F, 0.9F, -0.07F, 1.4F, -0.075F, 1.9F, -0.07F, 2.4F, -0.04F, 2.8F, 0.003F, 3.1F, 0.0F},
         {0.0F, 0.0F, 0.25F, -0.012F, 0.9F, 0.085F, 1.4F, 0.09F, 1.9F, 0.085F, 2.4F, 0.05F, 2.8F, -0.003F, 3.1F, 0.0F},
         {0.0F, 0.0F, 0.9F, -0.02F, 1.9F, -0.02F, 2.4F, -0.01F, 3.1F, 0.0F},
         {0.0F, 0.0F, 0.25F, -2.0F, 0.9F, 7.0F, 1.4F, 8.0F, 1.9F, 6.0F, 2.4F, 3.0F, 3.1F, 0.0F},
         {0.0F, 0.0F, 0.25F, 3.0F, 0.9F, -22.0F, 1.4F, -24.0F, 1.9F, -20.0F, 2.4F, 6.0F, 2.8F, 1.0F, 3.1F, 0.0F},
         {0.0F, 0.0F, 0.25F, -1.0F, 0.9F, 5.0F, 1.4F, 6.0F, 1.9F, 4.0F, 2.4F, -4.0F, 3.1F, 0.0F}
      };
      CUES[var1 + 5] = new float[]{0.9F, 1.0F, 0.85F, 0.35F, 1.9F, 3.0F, 0.8F, 0.3F, 2.4F, 1.0F, 0.8F, 0.3F};
      ANIM[var1 + 6] = new float[][]{
         {0.0F, 0.0F, 0.3F, 0.01F, 0.5F, -0.025F, 0.58F, -0.025F, 1.0F, -0.02F, 1.1F, -0.015F, 1.29F, -0.03F, 1.37F, -0.03F, 1.95F, -0.01F, 2.65F, 0.0F},
         {0.0F, 0.0F, 0.3F, -0.02F, 0.5F, 0.03F, 0.58F, 0.026F, 1.0F, 0.03F, 1.1F, 0.022F, 1.29F, 0.034F, 1.37F, 0.03F, 1.95F, 0.01F, 2.65F, 0.0F},
         {0.0F, 0.0F, 0.3F, 0.02F, 0.5F, -0.08F, 0.58F, -0.072F, 1.0F, -0.05F, 1.1F, -0.04F, 1.29F, -0.076F, 1.37F, -0.068F, 1.95F, -0.02F, 2.65F, 0.0F},
         {0.0F, 0.0F, 0.3F, 3.0F, 0.5F, -5.0F, 0.58F, -3.5F, 1.0F, -2.0F, 1.1F, 0.0F, 1.29F, -4.0F, 1.37F, -2.5F, 1.95F, -1.0F, 2.65F, 0.0F},
         {0.0F, 0.0F, 0.3F, 5.0F, 0.5F, -3.5F, 1.0F, -2.5F, 1.1F, 2.0F, 1.29F, -4.0F, 1.95F, -1.0F, 2.65F, 0.0F}
      };
      CUES[var1 + 6] = new float[]{0.3F, 2.0F, 0.7F, 0.35F, 0.5F, 0.0F, 0.7F, 0.55F, 1.1F, 2.0F, 0.75F, 0.3F, 1.29F, 0.0F, 0.75F, 0.5F};
   }

   private static void m() {

      float[] var0 = new float[0];
      byte var1 = 40;
      ANIM[var1] = new float[][]{
         {
               0.0F,
               0.0F,
               0.3F,
               -0.03F,
               0.42F,
               -0.02F,
               0.95F,
               -0.3F,
               1.45F,
               -0.2F,
               1.55F,
               -0.21F,
               1.9F,
               -0.22F,
               2.45F,
               -0.2F,
               2.85F,
               -0.05F,
               3.15F,
               0.004F,
               3.4F,
               0.0F
         },
         {
               0.0F,
               0.0F,
               0.3F,
               -0.07F,
               0.42F,
               -0.05F,
               0.7F,
               0.3F,
               0.95F,
               0.42F,
               1.2F,
               0.3F,
               1.45F,
               0.05F,
               1.55F,
               0.02F,
               1.7F,
               0.06F,
               1.9F,
               0.12F,
               2.45F,
               0.11F,
               2.85F,
               0.03F,
               3.15F,
               -0.004F,
               3.4F,
               0.0F
         },
         {0.0F, 0.0F, 0.95F, 0.04F, 1.45F, 0.03F, 1.9F, 0.06F, 2.45F, 0.05F, 2.85F, 0.02F, 3.4F, 0.0F},
         {0.0F, 0.0F, 0.3F, -10.0F, 0.42F, -6.0F, 0.95F, 4.0F, 1.45F, -4.0F, 1.55F, 2.0F, 1.9F, -8.0F, 2.45F, -6.0F, 2.85F, -2.0F, 3.4F, 0.0F},
         {
               0.0F,
               0.0F,
               0.42F,
               0.0F,
               0.62F,
               70.0F,
               0.8F,
               82.0F,
               1.2F,
               80.0F,
               1.38F,
               40.0F,
               1.5F,
               4.0F,
               1.6F,
               0.0F,
               1.9F,
               16.0F,
               2.45F,
               20.0F,
               2.85F,
               6.0F,
               3.4F,
               0.0F
         },
         {0.0F, 0.0F, 0.3F, 5.0F, 0.95F, -6.0F, 1.45F, -4.0F, 1.9F, -8.0F, 2.45F, -6.0F, 2.85F, -2.0F, 3.4F, 0.0F},
         var0,
         var0,
         var0,
         {0.0F, 0.0F, 1.85F, 0.0F, 1.92F, -10.0F, 2.12F, 190.0F, 2.2F, 182.0F, 2.28F, 178.0F, 2.48F, 360.0F, 2.56F, 366.0F, 2.64F, 360.0F, 3.4F, 360.0F},
         {
               0.0F,
               0.0F,
               0.42F,
               0.0F,
               0.5F,
               -40.0F,
               0.65F,
               -250.0F,
               0.8F,
               -470.0F,
               0.95F,
               -680.0F,
               1.1F,
               -870.0F,
               1.25F,
               -1000.0F,
               1.38F,
               -1070.0F,
               1.45F,
               -1088.0F,
               1.53F,
               -1076.0F,
               1.62F,
               -1080.0F,
               3.4F,
               -1080.0F
         }
      };
      CUES[var1] = new float[]{
         0.3F,
         6.0F,
         1.1F,
         0.25F,
         0.45F,
         2.0F,
         1.4F,
         0.45F,
         0.8F,
         3.0F,
         1.3F,
         0.35F,
         1.1F,
         3.0F,
         1.2F,
         0.35F,
         1.45F,
         0.0F,
         1.2F,
         0.55F,
         2.12F,
         4.0F,
         1.15F,
         0.45F,
         2.48F,
         4.0F,
         1.3F,
         0.35F
      };
      ANIM[var1 + 1] = new float[][]{
         {
               0.0F,
               0.0F,
               0.15F,
               0.02F,
               0.4F,
               -0.32F,
               1.0F,
               -0.36F,
               1.6F,
               -0.3F,
               2.1F,
               -0.33F,
               2.45F,
               -0.31F,
               3.0F,
               -0.29F,
               3.35F,
               -0.1F,
               3.65F,
               0.005F,
               3.85F,
               0.0F
         },
         {0.0F, 0.0F, 0.15F, -0.04F, 0.4F, 0.1F, 1.0F, 0.16F, 1.6F, 0.11F, 2.1F, 0.15F, 2.45F, 0.22F, 3.0F, 0.2F, 3.35F, 0.05F, 3.65F, -0.004F, 3.85F, 0.0F},
         {0.0F, 0.0F, 0.4F, 0.06F, 1.6F, 0.05F, 2.45F, 0.07F, 3.0F, 0.06F, 3.35F, 0.02F, 3.85F, 0.0F},
         {0.0F, 0.0F, 0.15F, -6.0F, 0.4F, -10.0F, 1.0F, -6.0F, 1.6F, -10.0F, 2.1F, -6.0F, 2.45F, -18.0F, 3.0F, -16.0F, 3.35F, -6.0F, 3.85F, 0.0F},
         {
               0.0F,
               0.0F,
               0.3F,
               30.0F,
               0.5F,
               78.0F,
               1.0F,
               84.0F,
               1.6F,
               78.0F,
               1.9F,
               82.0F,
               2.05F,
               50.0F,
               2.2F,
               14.0F,
               2.45F,
               10.0F,
               3.0F,
               8.0F,
               3.35F,
               2.0F,
               3.85F,
               0.0F
         },
         {0.0F, 0.0F, 0.4F, -8.0F, 1.0F, 7.0F, 1.6F, -7.0F, 2.1F, 4.0F, 2.45F, -14.0F, 3.0F, -12.0F, 3.35F, -4.0F, 3.85F, 0.0F},
         var0,
         var0,
         var0,
         var0,
         {
               0.0F,
               0.0F,
               0.42F,
               0.0F,
               0.5F,
               -25.0F,
               0.75F,
               -180.0F,
               1.0F,
               -400.0F,
               1.25F,
               -660.0F,
               1.5F,
               -950.0F,
               1.75F,
               -1250.0F,
               1.95F,
               -1430.0F,
               2.03F,
               -1454.0F,
               2.12F,
               -1436.0F,
               2.2F,
               -1440.0F,
               3.85F,
               -1440.0F
         }
      };
      CUES[var1 + 1] = new float[]{
         0.15F,
         1.0F,
         1.0F,
         0.3F,
         0.5F,
         2.0F,
         1.0F,
         0.35F,
         0.95F,
         3.0F,
         1.1F,
         0.35F,
         1.35F,
         3.0F,
         1.25F,
         0.4F,
         1.7F,
         3.0F,
         1.4F,
         0.45F,
         2.03F,
         0.0F,
         1.0F,
         0.5F,
         2.45F,
         4.0F,
         1.25F,
         0.5F
      };
      ANIM[var1 + 2] = new float[][]{
         {
               0.0F,
               0.0F,
               0.25F,
               0.03F,
               0.48F,
               -0.3F,
               0.7F,
               -0.55F,
               0.85F,
               -0.57F,
               1.0F,
               -0.55F,
               1.4F,
               -0.56F,
               1.55F,
               -0.5F,
               1.95F,
               -0.25F,
               2.35F,
               -0.02F,
               2.45F,
               0.0F,
               2.62F,
               0.07F,
               2.8F,
               -0.2F,
               2.95F,
               -0.3F,
               3.15F,
               -0.28F,
               3.6F,
               -0.05F,
               3.85F,
               0.004F,
               4.05F,
               0.0F
         },
         {
               0.0F,
               0.0F,
               0.25F,
               -0.05F,
               0.48F,
               0.22F,
               0.7F,
               0.06F,
               0.85F,
               0.02F,
               1.0F,
               0.05F,
               1.4F,
               0.06F,
               1.55F,
               0.02F,
               1.95F,
               0.3F,
               2.35F,
               0.02F,
               2.45F,
               -0.03F,
               2.62F,
               0.05F,
               2.8F,
               0.08F,
               2.95F,
               0.02F,
               3.15F,
               0.03F,
               3.6F,
               0.01F,
               3.85F,
               -0.004F,
               4.05F,
               0.0F
         },
         {0.0F, 0.0F, 0.48F, 0.05F, 0.7F, 0.03F, 1.4F, 0.03F, 1.95F, 0.06F, 2.35F, 0.01F, 2.8F, 0.05F, 3.15F, 0.04F, 3.6F, 0.01F, 4.05F, 0.0F},
         {
               0.0F,
               0.0F,
               0.25F,
               -8.0F,
               0.7F,
               4.0F,
               0.85F,
               -2.0F,
               1.4F,
               0.0F,
               1.55F,
               -6.0F,
               2.35F,
               6.0F,
               2.45F,
               0.0F,
               2.62F,
               -16.0F,
               2.8F,
               14.0F,
               2.95F,
               18.0F,
               3.15F,
               10.0F,
               3.6F,
               2.0F,
               4.05F,
               0.0F
         },
         {
               0.0F,
               0.0F,
               0.28F,
               0.0F,
               0.42F,
               60.0F,
               0.58F,
               78.0F,
               0.68F,
               40.0F,
               0.8F,
               20.0F,
               1.0F,
               60.0F,
               1.2F,
               80.0F,
               1.4F,
               70.0F,
               1.55F,
               40.0F,
               1.7F,
               76.0F,
               2.1F,
               80.0F,
               2.3F,
               30.0F,
               2.4F,
               4.0F,
               2.45F,
               0.0F,
               2.62F,
               -12.0F,
               2.8F,
               52.0F,
               2.95F,
               58.0F,
               3.15F,
               46.0F,
               3.6F,
               8.0F,
               4.05F,
               0.0F
         },
         {0.0F, 0.0F, 0.7F, 10.0F, 1.4F, 8.0F, 1.55F, 4.0F, 2.35F, -4.0F, 2.62F, 8.0F, 2.8F, -18.0F, 2.95F, -24.0F, 3.15F, -18.0F, 3.6F, -4.0F, 4.05F, 0.0F},
         var0,
         var0,
         var0,
         {0.0F, 0.0F, 1.6F, 0.0F, 1.68F, -8.0F, 1.9F, 186.0F, 1.98F, 178.0F, 2.05F, 182.0F, 2.22F, 360.0F, 4.05F, 360.0F},
         {
               0.0F,
               0.0F,
               0.28F,
               0.0F,
               0.34F,
               -30.0F,
               0.5F,
               -200.0F,
               0.62F,
               -330.0F,
               0.68F,
               -368.0F,
               0.76F,
               -356.0F,
               0.82F,
               -360.0F,
               1.0F,
               -360.0F,
               1.06F,
               -380.0F,
               1.2F,
               -560.0F,
               1.33F,
               -715.0F,
               1.4F,
               -724.0F,
               1.48F,
               -720.0F,
               1.55F,
               -720.0F,
               1.62F,
               -750.0F,
               1.8F,
               -920.0F,
               2.0F,
               -1040.0F,
               2.3F,
               -1084.0F,
               2.4F,
               -1078.0F,
               2.48F,
               -1080.0F,
               4.05F,
               -1080.0F
         }
      };
      CUES[var1 + 2] = new float[]{
         0.28F,
         2.0F,
         1.3F,
         0.4F,
         0.68F,
         0.0F,
         1.1F,
         0.5F,
         1.06F,
         3.0F,
         1.2F,
         0.35F,
         1.4F,
         1.0F,
         1.0F,
         0.35F,
         1.62F,
         2.0F,
         1.35F,
         0.4F,
         1.9F,
         4.0F,
         1.2F,
         0.35F,
         2.33F,
         0.0F,
         1.2F,
         0.5F,
         2.8F,
         2.0F,
         1.6F,
         0.5F,
         2.95F,
         4.0F,
         1.1F,
         0.35F
      };
   }

   private static void n() {

      for (int var0 = 0; var0 < 43; var0++) {
         float[][] var1 = ANIM[var0];
         ANIM_V[var0] = new float[var1.length][];
         ANIM_A[var0] = new float[var1.length][];

         for (int var2 = 0; var2 < var1.length; var2++) {
            float[] var3 = var1[var2];
            int var4 = var3.length >> 1;
            float[] var5 = new float[var4];
            float[] var6 = new float[var4];

            for (int var7 = 1; var7 < var4 - 1; var7++) {
               float var8 = var3[var7 * 2] - var3[var7 * 2 - 2];
               float var9 = var3[var7 * 2 + 2] - var3[var7 * 2];
               float var10 = (var3[var7 * 2 + 1] - var3[var7 * 2 - 1]) / var8;
               float var11 = (var3[var7 * 2 + 3] - var3[var7 * 2 + 1]) / var9;
               if (var10 * var11 > 0.0F) {
                  float var12 = 2.0F * var9 + var8;
                  float var13 = var9 + 2.0F * var8;
                  var5[var7] = (var12 + var13) / (var12 / var10 + var13 / var11);
               }
            }

            for (int var17 = 1; var17 < var4 - 1; var17++) {
               float var18 = var3[var17 * 2] - var3[var17 * 2 - 2];
               float var19 = var3[var17 * 2 + 2] - var3[var17 * 2];
               float var20 = var3[var17 * 2 - 1];
               float var21 = var3[var17 * 2 + 1];
               float var22 = var3[var17 * 2 + 3];
               if (var20 != var21 && var21 != var22) {
                  float var23 = (6.0F * (var20 - var21) + var18 * (2.0F * var5[var17 - 1] + 4.0F * var5[var17])) / (var18 * var18);
                  float var14 = (6.0F * (var22 - var21) - var19 * (4.0F * var5[var17] + 2.0F * var5[var17 + 1])) / (var19 * var19);
                  float var15 = (var23 * var19 + var14 * var18) / (var18 + var19);
                  float var16 = 4.0F * Math.min(Math.abs(var21 - var20) / (var18 * var18), Math.abs(var22 - var21) / (var19 * var19));
                  var6[var17] = var15 > var16 ? var16 : (var15 < -var16 ? -var16 : var15);
               }
            }

            ANIM_V[var0][var2] = var5;
            ANIM_A[var0][var2] = var6;
         }
      }
   }

   static void o(int var0, float var1, float[] var2, float[] var3, float[] var4) {

      assert var0 >= 0
         && var0 < ANIM.length
         && ANIM[var0] != null
         && ANIM_V[var0] != null
         && ANIM_A[var0] != null
         && ANIM_V[var0].length >= ANIM[var0].length
         && ANIM_A[var0].length >= ANIM[var0].length
         && var2 != null
         && var3 != null
         && var4 != null
         && var2.length >= 21
         && var3.length >= 21
         && var4.length >= 21
         && NOKEYS.length == 0
         && cx.length == 21
         && cy.length == 21
         && cz.length == 21
         && !Float.isNaN(var1) : "anim3";

      try {
         float[][] var5 = ANIM[var0];
         float[][] var6 = ANIM_V[var0];
         float[][] var7 = ANIM_A[var0];

         for (int var8 = 0; var8 < 21; var8++) {
            float[] var9 = var8 < var5.length ? var5[var8] : NOKEYS;
            int var10 = var9.length >> 1;
            var3[var8] = 0.0F;
            var4[var8] = 0.0F;
            if (var10 == 0) {
               var2[var8] = 0.0F;
            } else if (!(var1 <= var9[0]) && var10 != 1) {
               if (var1 >= var9[(var10 - 1) * 2]) {
                  var2[var8] = var9[(var10 - 1) * 2 + 1];
               } else {
                  int var11 = 0;

                  while (var11 < var10 - 2 && var1 >= var9[(var11 + 1) * 2]) {
                     var11++;
                  }

                  float var12 = var9[var11 * 2 + 2] - var9[var11 * 2];
                  float var13 = (var1 - var9[var11 * 2]) / var12;
                  float var14 = var13 * var13;
                  float var15 = var14 * var13;
                  float var16 = var15 * var13;
                  float var17 = var16 * var13;
                  float var18 = var9[var11 * 2 + 1];
                  float var19 = var9[var11 * 2 + 3] - var18;
                  float[] var20 = var6[var8];
                  float[] var21 = var7[var8];
                  float var22 = var20[var11] * var12;
                  float var23 = var20[var11 + 1] * var12;
                  float var24 = var21[var11] * var12 * var12;
                  float var25 = var21[var11 + 1] * var12 * var12;
                  var2[var8] = var18
                     + var19 * (10.0F * var15 - 15.0F * var16 + 6.0F * var17)
                     + var22 * (var13 - 6.0F * var15 + 8.0F * var16 - 3.0F * var17)
                     + var24 * (0.5F * var14 - 1.5F * var15 + 1.5F * var16 - 0.5F * var17)
                     + var25 * (0.5F * var15 - var16 + 0.5F * var17)
                     + var23 * (-4.0F * var15 + 7.0F * var16 - 3.0F * var17);
                  float var26 = var19 * (30.0F * var14 - 60.0F * var15 + 30.0F * var16)
                     + var22 * (1.0F - 18.0F * var14 + 32.0F * var15 - 15.0F * var16)
                     + var24 * (var13 - 4.5F * var14 + 6.0F * var15 - 2.5F * var16)
                     + var25 * (1.5F * var14 - 4.0F * var15 + 2.5F * var16)
                     + var23 * (-12.0F * var14 + 28.0F * var15 - 15.0F * var16);
                  float var27 = var19 * (60.0F * var13 - 180.0F * var14 + 120.0F * var15)
                     + var22 * (-36.0F * var13 + 96.0F * var14 - 60.0F * var15)
                     + var24 * (1.0F - 9.0F * var13 + 18.0F * var14 - 10.0F * var15)
                     + var25 * (3.0F * var13 - 12.0F * var14 + 10.0F * var15)
                     + var23 * (-24.0F * var13 + 84.0F * var14 - 60.0F * var15);
                  var3[var8] = var26 / var12;
                  var4[var8] = var27 / (var12 * var12);
               }
            } else {
               var2[var8] = var9[1];
            }
         }
      } catch (RuntimeException var28) {
         throw var28;
      }
   }

   public static int p(int var0) {

      return by[var0];
   }

   public static boolean q(int var0) {

      return cj[var0] > 0.0F;
   }

   public static int r(int var0) {

      return ca[var0];
   }

   public static void s(int var0) {

      by[var0] = -1;
      ca[var0] = -1;
      dc[var0] = -1.0F;
      cj[var0] = 0.0F;
      cf[var0] = 0L;
      cm[var0] = -1;
      cq[var0] = 8.0F;
      cn[var0] = 0;
      co[var0] = -1;
   }

   static float t(int var0) {

      int var1 = var0 * (1183962685 ^ -660164732);
      var1 ^= var1 >>> 16;
      var1 *= 1921178874 ^ -144107887;
      var1 ^= var1 >>> 13;
      var1 *= -317240408 ^ 799401373;
      var1 ^= var1 >>> 16;
      return (float)(var1 >>> 8) * 5.9604645E-8F;
   }

   public static int u(int var0, boolean var1, long var2) {

      int var4 = var0 >= 0 && var0 < 12 ? var0 : 0;
      int var5 = da[var4] - 1;
      int var6;
      if (!var1) {
         var6 = var5 < 0 ? 0 : (var5 + 1) % 3;
      } else {
         float var7 = t(++db * 31 + (int)(var2 >>> 12));
         var6 = var5 < 0 ? (int)(var7 * 3.0F) : (var5 + 1 + (int)(var7 * 2.0F)) % 3;
      }

      da[var4] = var6 + 1;
      return INS[var4 * 3 + var6];
   }

   private static float v(int var0) {

      int var1 = ++cn[var0];
      return 8.0F + 8.0F * t(var1 * 2 + var0);
   }

   private static void w(int var0, long var1, float var3) {

      long var4 = cf[var0];
      if (var4 != var1) {
         float var6 = var4 == 0L ? 0.0F : (float)(var1 - var4) * 1.0E-9F;
         var6 = var6 < 0.0F ? 0.0F : (var6 > 0.1F ? 0.1F : var6);
         cf[var0] = var1;
         if (by[var0] >= 0) {
            cc[var0] = cc[var0] + var6 * ce[var0];
         }

         if (cj[var0] > 0.0F) {
            float var7 = ck[var0] + var6;
            if (var7 >= cj[var0]) {
               cj[var0] = 0.0F;
            }

            ck[var0] = var7;
         }

         if (cm[var0] >= 0) {
            cp[var0] = cp[var0] + var6;
         } else if (by[var0] < 0 && cj[var0] <= 0.0F) {
            cq[var0] = cq[var0] - var6;
         }
      }
   }

   private static void x(int var0, float var1, float[] var2, float[] var3, float[] var4) {

      assert var0 >= 0
         && var0 < 2
         && var2 != null
         && var3 != null
         && var4 != null
         && var2.length >= 21
         && var3.length >= 21
         && var4.length >= 21
         && by.length == 2
         && ca[var0] >= 0
         && ca[var0] < 7
         && cb[var0] >= 0
         && cb[var0] < 5
         && HOLD.length == (962254536 ^ 962253847)
         && cx.length == 21
         && cy.length == 21
         && cz.length == 21
         && cl.length == 42
         && cg.length == 42
         && ch.length == 42
         && ci.length == 42
         && var1 >= 0.0F : "base";

      try {
         int var5 = by[var0];
         int var6 = (ca[var0] * 5 + (var5 >= 0 ? 0 : cb[var0])) * 21;
         if (var5 >= 0) {
            o(bz[var0], cc[var0], cx, cy, cz);
            float var7 = ce[var0];
            float var8 = var7 * var7;

            for (int var9 = 0; var9 < 21; var9++) {
               var2[var9] = HOLD[var6 + var9] + cx[var9];
               var3[var9] = cy[var9] * var7;
               var4[var9] = cz[var9] * var8;
            }
         } else if (cm[var0] >= 0) {
            o(14 + cm[var0], cp[var0], cx, cy, cz);

            for (int var22 = 0; var22 < 21; var22++) {
               var2[var22] = HOLD[var6 + var22] + cx[var22];
               var3[var22] = cy[var22];
               var4[var22] = cz[var22];
            }
         } else {
            for (int var23 = 0; var23 < 21; var23++) {
               var2[var23] = HOLD[var6 + var23];
               var3[var23] = 0.0F;
               var4[var23] = 0.0F;
            }
         }

         if (cj[var0] > 0.0F) {
            float var24 = ck[var0];
            float var25 = var24 * var24;
            float var26 = var25 * var24;
            int var10 = var0 * 21;

            for (int var11 = 0; var11 < 21; var11++) {
               float var12 = cl[var10 + var11];
               if (!(var24 >= var12)) {
                  float var13 = var12 * var12;
                  float var14 = var13 * var12;
                  float var15 = cg[var10 + var11];
                  float var16 = ch[var10 + var11];
                  float var17 = ci[var10 + var11];
                  float var18 = -(var17 * var13 + 6.0F * var16 * var12 + 12.0F * var15) / (2.0F * var14 * var13);
                  float var19 = (3.0F * var17 * var13 + 16.0F * var16 * var12 + 30.0F * var15) / (2.0F * var13 * var13);
                  float var20 = -(3.0F * var17 * var13 + 12.0F * var16 * var12 + 20.0F * var15) / (2.0F * var14);
                  var2[var11] += var15 + var16 * var24 + 0.5F * var17 * var25 + var20 * var26 + var19 * var25 * var25 + var18 * var26 * var25;
                  var3[var11] += var16 + var17 * var24 + 3.0F * var20 * var25 + 4.0F * var19 * var26 + 5.0F * var18 * var25 * var25;
                  var4[var11] += var17 + 6.0F * var20 * var24 + 12.0F * var19 * var25 + 20.0F * var18 * var26;
               }
            }
         }
      } catch (RuntimeException var21) {
         throw var21;
      }
   }

   private static void y(int var0, float var1) {

      int var2 = var0 * 21;
      float var3 = 0.0F;
      float var4 = 0.0F;

      for (int var5 = 0; var5 < 21; var5++) {
         float var6 = cr[var5] - cu[var5];
         float var7 = cs[var5] - cv[var5];
         float var8 = ct[var5] - cw[var5];
         float var9 = var1;
         if ((var5 < 3 || var5 > 11) && var5 != 13) {
            if (var5 == 12) {
               float var28 = 0.5F + 0.25F * Math.abs(var6);

               for (int var31 = 0; var31 < 10 && var9 * 0.85F >= 0.15F && z(var6, var7, var8, var9) > var28; var31++) {
                  var9 *= 0.85F;
               }
            }
         } else {
            var6 -= 360.0F * (float)Math.round(var6 / 360.0F);
            float var10 = 1.875F * Math.abs(var6) / 360.0F;
            var9 = var10 > var1 ? var10 : var1;
            float var11 = Math.abs(var7);
            float var12 = 0.9F;
            boolean var13 = var6 * var7 > 0.0F;
            if (var11 > 200.0F) {
               float var14 = var13 ? var6 - Math.copySign(360.0F, var7) : var6;
               float var15 = 2.0F * Math.abs(var14) / var11;
               if (var15 < 0.15F) {
                  float var16 = var14 - Math.copySign(360.0F, var7);
                  float var17 = 2.0F * Math.abs(var16) / var11;
                  if (var17 <= 0.9F) {
                     var14 = var16;
                     var15 = var17;
                  }
               }

               if (var15 <= 1.1F || var13 && Math.abs(var14) <= 300.0F) {
                  var6 = var14;
                  var9 = var15 < 0.15F ? 0.15F : var15;
                  var13 = false;
                  var12 = 1.1F;
               }
            }

            var9 = var9 > var12 ? var12 : var9;
            float var33 = var13 ? Math.max(15.0F, 0.25F * Math.abs(var6)) : 0.5F + 0.02F * Math.abs(var6);

            for (int var34 = 0; var34 < 10 && var9 * 0.85F >= 0.15F && z(var6, var7, var8, var9) > var33; var34++) {
               var9 *= 0.85F;
            }
         }

         cg[var2 + var5] = var6;
         ch[var2 + var5] = var7;
         ci[var2 + var5] = var8;
         cl[var2 + var5] = var9;
         float var29 = Math.abs(var6) + Math.abs(var7) * 0.01F + Math.abs(var8) * 1.0E-4F;
         if (var29 > 1.0E-5F && var9 > var4) {
            var4 = var9;
         }

         var3 = Math.max(var3, var29);
      }

      float var18 = 0.0F;

      for (int var19 = 3; var19 <= 13; var19++) {
         if ((var19 <= 8 || var19 == 13) && Math.abs(cg[var2 + var19]) > 1.0F && Math.abs(ch[var2 + var19]) <= 200.0F && cl[var2 + var19] > var18) {
            var18 = cl[var2 + var19];
         }
      }

      for (int var20 = 3; var20 <= 13; var20++) {
         float var22 = cg[var2 + var20];
         if ((var20 <= 8 || var20 == 13)
            && Math.abs(var22) > 1.0F
            && Math.abs(ch[var2 + var20]) <= 200.0F
            && cl[var2 + var20] < var18
            && z(var22, ch[var2 + var20], ci[var2 + var20], var18) <= 0.5F + 0.02F * Math.abs(var22)) {
            cl[var2 + var20] = var18;
         }
      }

      float var21 = 2.0F * var4;
      float var23 = var4;

      for (int var24 = 14; var24 < 21; var24++) {
         if (var24 != 15 && var24 != 16) {
            if (var21 > cl[var2 + var24]) {
               cl[var2 + var24] = var21;
            }

            if (var24 != 20) {
               float var26 = cg[var2 + var24];
               float var30 = (var24 == 14 ? 0.25F : 0.02F) + 0.25F * Math.abs(var26);

               for (int var32 = 0;
                  var32 < 16 && cl[var2 + var24] * 0.85F >= 0.15F && z(var26, ch[var2 + var24], ci[var2 + var24], cl[var2 + var24]) > var30;
                  var32++
               ) {
                  cl[var2 + var24] = cl[var2 + var24] * 0.85F;
               }
            }

            float var27 = Math.abs(cg[var2 + var24]) + Math.abs(ch[var2 + var24]) * 0.01F + Math.abs(ci[var2 + var24]) * 1.0E-4F;
            if (var27 > 1.0E-5F && cl[var2 + var24] > var23) {
               var23 = cl[var2 + var24];
            }
         }
      }

      ck[var0] = 0.0F;
      cj[var0] = var3 > 1.0E-5F ? var23 : 0.0F;
   }

   private static float z(float var0, float var1, float var2, float var3) {

      if (var0 == 0.0F) {
         return 0.0F;
      } else {
         float var4 = var3 * var3;
         float var5 = var4 * var3;
         float var6 = -(var2 * var4 + 6.0F * var1 * var3 + 12.0F * var0) / (2.0F * var5 * var4);
         float var7 = (3.0F * var2 * var4 + 16.0F * var1 * var3 + 30.0F * var0) / (2.0F * var4 * var4);
         float var8 = -(3.0F * var2 * var4 + 12.0F * var1 * var3 + 20.0F * var0) / (2.0F * var5);
         float var9 = var0 > 0.0F ? 1.0F : -1.0F;
         float var10 = var0 * var9;
         float var11 = 0.0F;

         for (int var12 = 1; var12 < 16; var12++) {
            float var13 = var3 * (float)var12 * 0.0625F;
            float var14 = var13 * var13;
            float var15 = var14 * var13;
            float var16 = (var0 + var1 * var13 + 0.5F * var2 * var14 + var8 * var15 + var7 * var14 * var14 + var6 * var15 * var14) * var9;
            float var17 = var16 < 0.0F ? -var16 : var16 - var10;
            var11 = var17 > var11 ? var17 : var11;
         }

         return var11;
      }
   }

   private static void aa(int var0, float var1) {

      x(var0, var1, cr, cs, ct);
      cm[var0] = -1;
      cq[var0] = v(var0);
      x(var0, var1, cu, cv, cw);
      y(var0, 0.3F);
   }

   public static void ab(int var0, int var1, int var2, int var3, long var4, float var6, boolean var7) {

      w(var0, var4, var6);
      if (var7 && ca[var0] == var2) {
         x(var0, var6, cr, cs, ct);
      } else {
         var7 = false;
      }

      int var8 = var1 < 14 && (var1 & 1) != 0 ? 1 : 0;
      by[var0] = var8;
      bz[var0] = var1;
      ca[var0] = var2;
      cb[var0] = var3;
      cc[var0] = 0.0F;
      ce[var0] = var6 < 0.1F ? 0.1F : var6;
      cd[var0] = -1.0F;
      dc[var0] = -1.0F;
      cj[var0] = 0.0F;
      cm[var0] = -1;
      cq[var0] = v(var0);
      if (var7) {
         x(var0, var6, cu, cv, cw);
         y(var0, var8 == 0 ? 0.42F : 0.3F);
      }
   }

   public static boolean ac(int var0) {

      return by[var0] == 0 && dc[var0] >= 0.0F;
   }

   static float ad(int var0, float var1) {

      float[][] var2 = ANIM[var0];
      float[] var3 = var2.length > 18 ? var2[18] : NOKEYS;
      int var4 = var3.length >> 1;

      for (int var5 = 0; var5 + 1 < var4; var5++) {
         if (var1 >= var3[var5 * 2] && var1 < var3[var5 * 2 + 2]) {
            if (var3[var5 * 2 + 1] == 0.0F && var3[var5 * 2 + 3] == 0.0F) {
               return -1.0F;
            }

            for (int var6 = var5 + 1; var6 < var4; var6++) {
               if (var3[var6 * 2 + 1] == 0.0F) {
                  return var3[var6 * 2];
               }
            }

            return -1.0F;
         }
      }

      return -1.0F;
   }

   public static void ae(int var0, long var1, float var3) {

      w(var0, var1, var3);
      if (by[var0] >= 0) {
         if (by[var0] == 0) {
            float var4 = dc[var0] >= 0.0F ? dc[var0] : ad(bz[var0], cc[var0]);
            if (var4 > 0.0F) {
               dc[var0] = var4;
               return;
            }
         }

         af(var0, var3);
      }
   }

   private static void af(int var0, float var1) {

      dc[var0] = -1.0F;
      x(var0, var1, cr, cs, ct);
      by[var0] = -1;
      cj[var0] = 0.0F;
      x(var0, var1, cu, cv, cw);
      y(var0, 0.34F);
   }

   public static void ag(int var0, long var1, float var3) {

      w(var0, var1, var3);
      if (cm[var0] >= 0) {
         aa(var0, var3);
      }

      if (cq[var0] < 8.0F) {
         cq[var0] = 8.0F;
      }
   }

   public static int ah(int var0, long var1, int var3, int var4, float var5, float[] var6) {

      w(var0, var1, var5);
      if (var3 != ca[var0]) {
         ca[var0] = var3;
         cb[var0] = var4;
         by[var0] = -1;
         cj[var0] = 0.0F;
         cm[var0] = -1;
         cq[var0] = v(var0);
      } else if (var4 != cb[var0]) {
         x(var0, var5, cr, cs, ct);
         cb[var0] = var4;
         cj[var0] = 0.0F;
         if (cm[var0] >= 0) {
            cq[var0] = v(var0);
         }

         cm[var0] = -1;
         x(var0, var5, cu, cv, cw);
         y(var0, 0.55F);
      }

      int var7 = 0;
      int var8 = by[var0];
      if (var8 >= 0) {
         int var9 = bz[var0];
         float[] var10 = CUES[var9];
         CUE_TAB = var10;
         float var11 = cd[var0];
         float var12 = cc[var0];

         for (byte var13 = 0; var13 < var10.length && var7 < CUE_HIT.length; var13 += 4) {
            if (var10[var13] > var11 && var10[var13] <= var12) {
               CUE_HIT[var7++] = var13;
            }
         }

         cd[var0] = var12;
         if (var12 >= DUR[var9]) {
            x(var0, var5, cr, cs, ct);
            by[var0] = -1;
            cj[var0] = 0.0F;
            x(var0, var5, cu, cv, cw);
            y(var0, 0.5F);
         } else if (var8 == 0 && dc[var0] >= 0.0F && var12 >= dc[var0]) {
            af(var0, var5);
         }
      }

      int var14 = cm[var0];
      if (var14 < 0 || FIDGETS && var3 != 0) {
         if (var14 >= 0 && cp[var0] >= DUR[14 + var14]) {
            cm[var0] = -1;
            cq[var0] = v(var0);
         } else if (var14 < 0 && FIDGETS && var3 != 0 && by[var0] < 0 && cj[var0] <= 0.0F && cq[var0] <= 0.0F) {
            int var15 = (co[var0] + 1 + (int)(t(cn[var0] * 2 + 1 + var0 * (-1289185341 ^ -1289189076)) * 3.0F)) % 4;
            co[var0] = var15;
            cm[var0] = var15;
            cp[var0] = 0.0F;
         }
      } else {
         aa(var0, var5);
      }

      x(var0, var5, var6, cs, ct);
      if (var3 != 0) {
         double var16 = (double)var1 * 1.0E-9;
         float[] var17 = MICRO;

         for (byte var18 = 0; var18 < var17.length; var18 += 4) {
            var6[(int)var17[var18]] = var6[(int)var17[var18]]
               + var17[var18 + 1] * (float)Math.sin(var16 * (Math.PI * 2) / (double)var17[var18 + 2] + (double)var17[var18 + 3]);
         }
      }

      return var7;
   }

   public static void ai(float var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7) {

      if (!(var0 < 0.0F) && !(var7 <= 0.0F)) {
         float var8 = var0 > 0.0F ? var1 / var0 : dh;
         float var9 = var0 > 0.0F ? var2 / var0 : di;
         float var10 = dp < 1.0F * var0 ? dp : 1.0F * var0;
         float var11 = var0 + var10;
         dp -= var10;
         if (var11 > 0.06F) {
            dp = Math.min(dp + var11 - 0.06F, 0.25F);
            var11 = 0.06F;
         }

         float var12 = 11.0F;
         float var13 = (float)Math.exp((double)(-var12 * var11));
         de = de - (var8 - dh);
         dh = var8;
         float var14 = dd + 2.0F * var8 / var12;
         float var15 = de + var12 * var14;
         var14 = (var14 + var15 * var11) * var13;
         de = (de - var12 * var15 * var11) * var13;
         dd = var14 - 2.0F * var8 / var12;
         dg = dg - (var9 - di);
         di = var9;
         var14 = df + 2.0F * var9 / var12;
         var15 = dg + var12 * var14;
         var14 = (var14 + var15 * var11) * var13;
         dg = (dg - var12 * var15 * var11) * var13;
         df = var14 - 2.0F * var9 / var12;
         if (Math.abs(dd) > 80.0F) {
            de = de * (80.0F / Math.abs(dd));
            dd = Math.copySign(80.0F, dd);
         }

         if (Math.abs(df) > 80.0F) {
            dg = dg * (80.0F / Math.abs(df));
            df = Math.copySign(80.0F, df);
         }

         float var17 = dj - var4;
         float var18 = (float)Math.exp((double)(-6.0F * var11));
         var15 = dk + 6.0F * var17;
         dj = var4 + (var17 + var15 * var11) * var18;
         dk = (dk - 6.0F * var15 * var11) * var18;
         dm += var6;
         float var19 = (float)Math.exp((double)(-9.0F * var11));
         var15 = dm + 9.0F * dl;
         dl = (dl + var15 * var11) * var19;
         dm = (dm - 9.0F * var15 * var11) * var19;
         float var20 = (var5 > 6.0F ? 6.0F : (var5 < -6.0F ? -6.0F : var5)) * 0.45F;
         var17 = dn - var20;
         float var21 = (float)Math.exp((double)(-7.0F * var11));
         var15 = _kwren_do + 7.0F * var17;
         dn = var20 + (var17 + var15 * var11) * var21;
         _kwren_do = (_kwren_do - 7.0F * var15 * var11) * var21;
         float var22 = 4.5F * (float)Math.tanh((double)(0.16F * dd / 4.5F));
         float var23 = 4.5F * (float)Math.tanh((double)(0.16F * df / 4.5F));
         float var24 = dj < 0.0F ? 0.0F : dj;
         float var25 = (float)Math.sin((double)(var3 - 0.6F));
         float var26 = (float)Math.cos((double)(2.0F * var3 - 1.0F));
         SW_YAW = -var22 * var7;
         SW_PIT = -var23 * var7 * 0.8F + dl * 30.0F * var7;
         SW_ROLL = (dn + var24 * 0.6F * var25) * var7;
         SW_X = (var24 * 0.0045F * var25 - dn * 0.004888889F) * var7;
         SW_Y = (var24 * 0.003F * var26 + dl) * var7;
         SW_Z = 0.0F;
      } else {
         di = 0.0F;
         dh = 0.0F;
         dg = 0.0F;
         df = 0.0F;
         de = 0.0F;
         dd = 0.0F;
         _kwren_do = 0.0F;
         dn = 0.0F;
         dm = 0.0F;
         dl = 0.0F;
         dk = 0.0F;
         dj = 0.0F;
         SW_ROLL = 0.0F;
         SW_PIT = 0.0F;
         SW_YAW = 0.0F;
         SW_Z = 0.0F;
         SW_Y = 0.0F;
         SW_X = 0.0F;
         dp = 0.0F;
      }
   }

   public static void aj(float var0) {

      float var1;
      if (var0 <= 0.0F || var0 >= 1.0F) {
         var1 = 0.0F;
      } else if (var0 < 0.27F) {
         float var2 = var0 / 0.27F;
         float var3 = var2 * var2;
         var1 = 1.0F * (var2 - 2.0F * var3 + var3 * var2) + 3.0F * var3 - 2.0F * var3 * var2;
      } else {
         float var4 = (var0 - 0.27F) / 0.73F;
         var1 = 1.0F - var4 * var4 * (3.0F - 2.0F * var4);
      }

      SL_V = var1;
   }

   private static void ak() {

      assert bv.length == 12
         && bw.length == 12
         && E.length == 12
         && EN.length == 9
         && KM.length == 12
         && PM.length == 36
         && ea.length == 36
         && eb.length == 27
         && dz.length == 9
         && CAM.length == 9
         && RECT.length == 40
         && dq.length == 10
         && dr.length == 10
         && dy.length == 10
         && FINMAT.length == 10 : "partMats";

      try {
         float[] var0 = bv;
         mul(E, 0, KM, 0, var0, 0);
         float var1 = (float)Math.sqrt((double)(KM[0] * KM[0] + KM[4] * KM[4] + KM[8] * KM[8]));
         float var2 = var1 > 1.0E-6F ? 1.0F / var1 : 1.0F;

         for (int var3 = 0; var3 < 3; var3++) {
            mul(var0, 0, PM, var3 * 12, ea, var3 * 12);

            for (int var4 = 0; var4 < 3; var4++) {
               for (int var5 = 0; var5 < 3; var5++) {
                  float var6 = 0.0F;

                  for (int var7 = 0; var7 < 3; var7++) {
                     float var8 = 0.0F;

                     for (int var9 = 0; var9 < 3; var9++) {
                        var8 += EN[var4 * 3 + var9] * KM[var9 * 4 + var7];
                     }

                     var6 += var8 * var2 * PM[var3 * 12 + var7 * 4 + var5];
                  }

                  eb[var3 * 9 + var4 * 3 + var5] = var6;
               }
            }
         }
      } catch (RuntimeException var10) {
         throw var10;
      }
   }

   public static void al() {

      for (int var0 = 0; var0 < 3; var0++) {
         float var1 = LV[var0 * 3];
         float var2 = LV[var0 * 3 + 1];
         float var3 = LV[var0 * 3 + 2];
         dz[var0 * 3] = CAM[0] * var1 + CAM[1] * var2 + CAM[2] * var3;
         dz[var0 * 3 + 1] = CAM[3] * var1 + CAM[4] * var2 + CAM[5] * var3;
         dz[var0 * 3 + 2] = CAM[6] * var1 + CAM[7] * var2 + CAM[8] * var3;
      }
   }

   public static void am(int var0, int var1, int var2) {

      assert var0 > 0
         && var0 < 7
         && var1 >= 0
         && UP[var0] != null
         && UN[var0] != null
         && UG[var0] != null
         && UT[var0] != null
         && UO[var0] != null
         && UA[var0] != null
         && UM[var0] != null
         && CI[var0] != null
         && HWQ[var0] != null
         && NU[var0] >= 0
         && ef.length >= NU[var0]
         && eg.length >= NU[var0]
         && eh.length >= NU[var0]
         && (long)ec.length >= (long)NU[var0] * 3L
         && (long)ed.length >= (long)NU[var0] * 2L
         && (long)ee.length >= (long)NU[var0] * 2L
         && CI[var0].length >= NC[var0]
         && OP != null
         && OT != null
         && OC != null
         && RECT.length == 40
         && ea.length == 36
         && eb.length == 27
         && dz.length == 9
         && CAM.length == 9 : "shade";

      try {
         ak();
         int var3 = (var1 & 1) * (934333648 ^ 934334160);
         int var4 = (var1 >> 1) * (72648585 ^ 72648521);
         float var5 = 9.765625E-4F;
         float var6 = 9.765625E-4F;
         boolean var7 = var0 == 6 && (var1 == 0 || var1 == 6);
         RECT[0] = ((float)(var7 ? -1161974821 ^ -1161975333 : var3) + 2.5F) * var5;
         RECT[1] = ((float)(var7 ? 821540973 ^ 821541421 : var4) + 2.5F) * var6;
         RECT[2] = 507.0F * var5;
         RECT[3] = 123.0F * var6;
         RECT[4] = ((float)var3 + 2.5F) * var5;
         RECT[5] = ((float)(var4 + (-1511732416 ^ -1511732288)) + 2.5F) * var6;
         RECT[6] = 507.0F * var5;
         RECT[7] = 27.0F * var6;
         RECT[28] = ((float)var3 + 2.5F) * var5;
         RECT[29] = ((float)(var4 + (-342192408 ^ -342192568)) + 2.5F) * var6;
         RECT[30] = 507.0F * var5;
         RECT[31] = 27.0F * var6;

         for (int var8 = 0; var8 < 10; var8++) {
            boolean var9 = FINMAT[var8];
            dq[var8] = K_AMB[var8];
            dr[var8] = K_DIF[var8];
            ds[var8] = var9 ? K_ENV[var8] * F_ENV[var1] : K_ENV[var8];
            dt[var8] = var9 ? K_SPC[var8] * F_SPC[var1] : K_SPC[var8];
            du[var8] = var9 ? K_ANI[var8] * F_ANI[var1] : K_ANI[var8];
            dv[var8] = K_FRS[var8];
            dw[var8] = var9 ? K_COAT[var8] * F_COAT[var1] : K_COAT[var8];
            dx[var8] = var9 ? F_F0[var1] : K_F0[var8];
            dy[var8] = du[var8] >= 0.5F;
         }

         if (var7) {
            du[0] = 0.0F;
            dy[0] = false;
         }

         float var111 = (float)(var2 >> 16 & (550912775 ^ 550913016)) / 255.0F;
         float var112 = (float)(var2 >> 8 & (117506099 ^ 117506252)) / 255.0F;
         float var10 = (float)(var2 & (278896071 ^ 278895928)) / 255.0F;
         float var11 = (PM[12] + 1.0F) * 45.454544F;
         var11 = var11 < 0.0F ? 0.0F : (var11 > 1.0F ? 1.0F : var11);
         float var12 = 0.3F + 0.7F * var11 * var11 * (3.0F - 2.0F * var11);
         float[] var13 = UP[var0];
         float[] var14 = UN[var0];
         float[] var15 = UG[var0];
         float[] var16 = UT[var0];
         float[] var17 = UO[var0];
         byte[] var18 = UA[var0];
         byte[] var19 = UM[var0];
         int var20 = NU[var0];
         float[] var21 = ec;
         float[] var22 = ed;
         float[] var23 = ee;
         int[] var24 = ef;
         int[] var25 = eg;
         boolean[] var26 = eh;
         float var27 = dz[0];
         float var28 = dz[1];
         float var29 = dz[2];
         float var30 = dz[3];
         float var31 = dz[4];
         float var32 = dz[5];
         float var33 = dz[6];
         float var34 = dz[7];
         float var35 = dz[8];
         float var36 = CAM[0];
         float var37 = CAM[1];
         float var38 = CAM[2];
         float var39 = CAM[3];
         float var40 = CAM[4];
         float var41 = CAM[5];
         float var42 = CAM[6];
         float var43 = CAM[7];
         float var44 = CAM[8];
         float var45 = 128.0F * var5;
         float var46 = 896.0F * var6;
         float var47 = 240.0F * var5;
         float var48 = 240.0F * var6;
         float var49 = 320.0F * var5;
         float var50 = 832.0F * var6;
         float var51 = 120.0F * var5;
         float var52 = 120.0F * var6;

         for (int var53 = 0; var53 < var20; var53++) {
            byte var54 = var18[var53];
            int var55 = var54 * 12;
            int var56 = var54 * 9;
            int var57 = var53 * 3;
            int var58 = var53 * 2;
            float var59 = var13[var57];
            float var60 = var13[var57 + 1];
            float var61 = var13[var57 + 2];
            float var62 = ea[var55] * var59 + ea[var55 + 1] * var60 + ea[var55 + 2] * var61 + ea[var55 + 3];
            float var63 = ea[var55 + 4] * var59 + ea[var55 + 5] * var60 + ea[var55 + 6] * var61 + ea[var55 + 7];
            float var64 = ea[var55 + 8] * var59 + ea[var55 + 9] * var60 + ea[var55 + 10] * var61 + ea[var55 + 11];
            var21[var57] = var62;
            var21[var57 + 1] = var63;
            var21[var57 + 2] = var64;
            float var65 = var14[var57];
            float var66 = var14[var57 + 1];
            float var67 = var14[var57 + 2];
            float var68 = eb[var56] * var65 + eb[var56 + 1] * var66 + eb[var56 + 2] * var67;
            float var69 = eb[var56 + 3] * var65 + eb[var56 + 4] * var66 + eb[var56 + 5] * var67;
            float var70 = eb[var56 + 6] * var65 + eb[var56 + 7] * var66 + eb[var56 + 8] * var67;
            float var71 = var68 * var68 + var69 * var69 + var70 * var70;
            if (var71 > 1.0E-12F) {
               var71 = 1.0F / (float)Math.sqrt((double)var71);
               var68 *= var71;
               var69 *= var71;
               var70 *= var71;
            }

            float var72 = (float)Math.sqrt((double)(var62 * var62 + var63 * var63 + var64 * var64));
            var72 = var72 > 1.0E-6F ? 1.0F / var72 : 0.0F;
            float var73 = -var62 * var72;
            float var74 = -var63 * var72;
            float var75 = -var64 * var72;
            float var76 = var68 * var73 + var69 * var74 + var70 * var75;
            boolean var77 = var76 >= 0.0F;
            if (!var77) {
               var68 = -var68;
               var69 = -var69;
               var70 = -var70;
               var76 = -var76;
            }

            byte var78 = var19[var53];
            float var79 = var54 == 1 ? var17[var53] * var12 : var17[var53];
            float var80 = var68 * var27 + var69 * var28 + var70 * var29;
            float var81 = var68 * var30 + var69 * var31 + var70 * var32;
            float var82 = (var80 > 0.0F ? var80 : 0.0F) * 0.8F + (var81 > 0.0F ? var81 : 0.0F) * 0.35F;
            float var83 = 2.0F * var76 * var68 - var73;
            float var84 = 2.0F * var76 * var69 - var74;
            float var85 = 2.0F * var76 * var70 - var75;
            float var86 = var84 > 0.0F ? 0.34F + 0.46F * var84 : 0.34F + 0.16F * var84;
            float var87 = (var84 - 0.1F) * 6.0F;
            var86 += 0.22F / (1.0F + var87 * var87);
            float var88 = var83 * var27 + var84 * var28 + var85 * var29;
            float var89 = 0.0F;
            if (var88 > 0.0F) {
               float var90 = var88 * var88;
               float var91 = var90 * var90;
               float var92 = var91 * var91;
               float var93 = var92 * var92;
               var89 = var93 * var93 + var92 * 0.2F;
            }

            float var125 = du[var78];
            if (var125 > 0.0F) {
               float var126 = var15[var57];
               float var128 = var15[var57 + 1];
               float var131 = var15[var57 + 2];
               float var94 = eb[var56] * var126 + eb[var56 + 1] * var128 + eb[var56 + 2] * var131;
               float var95 = eb[var56 + 3] * var126 + eb[var56 + 4] * var128 + eb[var56 + 5] * var131;
               float var96 = eb[var56 + 6] * var126 + eb[var56 + 7] * var128 + eb[var56 + 8] * var131;
               float var97 = (var83 - var27) * var94 + (var84 - var28) * var95 + (var85 - var29) * var96;
               float var98 = 2.0F - 2.0F * var88 - var97 * var97;
               float var99 = 1.0F + 110.0F * var97 * var97 + 4.0F * (var98 > 0.0F ? var98 : 0.0F);
               var89 += (1.0F / (var99 * var99) - var89) * var125;
            }

            float var127 = var83 * var30 + var84 * var31 + var85 * var32;
            if (var127 > 0.0F) {
               float var129 = var127 * var127;
               float var132 = var129 * var129;
               float var135 = var132 * var132;
               var89 += var135 * var135 * 0.35F;
            }

            float var130 = var83 * var33 + var84 * var34 + var85 * var35;
            if (var130 > 0.0F) {
               float var133 = var130 * var130;
               float var136 = var133 * var133;
               var89 += var136 * var136 * 0.25F + var133 * 0.06F;
            }

            float var134 = 1.0F - var76;
            float var137 = var134 * var134;
            float var138 = var79 * (dq[var78] + dr[var78] * var82)
               + ds[var78] * var86 * (0.35F + 0.65F * var79)
               + dt[var78] * var89 * var79
               + dv[var78] * var137 * var134;
            if (var138 > 1.0F) {
               var138 = 1.0F;
            }

            int var139;
            int var140;
            int var141;
            if (FINMAT[var78]) {
               var139 = (int)(var138 * var111 * 255.0F);
               var140 = (int)(var138 * var112 * 255.0F);
               var141 = (int)(var138 * var10 * 255.0F);
            } else {
               var139 = var140 = var141 = (int)(var138 * 255.0F);
            }

            var24[var53] = 1137541069 ^ -1127383091 | var139 << 16 | var140 << 8 | var141;
            int var142 = var78 * 4;
            var22[var58] = RECT[var142] + var16[var58] * RECT[var142 + 2];
            var22[var58 + 1] = RECT[var142 + 1] + var16[var58 + 1] * RECT[var142 + 3];
            var26[var53] = var77;
            float var100 = dw[var78];
            if (var100 > 0.0F) {
               float var101 = var36 * var83 + var39 * var84 + var42 * var85;
               float var102 = var37 * var83 + var40 * var84 + var43 * var85;
               float var103 = var38 * var83 + var41 * var84 + var44 * var85;
               float var104 = var101 * var101 + var102 * var102 + (var103 + 1.0F) * (var103 + 1.0F);
               var104 = var104 > 1.0E-8F ? 0.5F / (float)Math.sqrt((double)var104) : 0.0F;
               float var105 = var101 * var104;
               float var106 = var102 * var104;
               if (dy[var78]) {
                  var23[var58] = var49 + var105 * var51;
                  var23[var58 + 1] = var50 - var106 * var52;
               } else {
                  var23[var58] = var45 + var105 * var47;
                  var23[var58 + 1] = var46 - var106 * var48;
               }

               float var107 = dx[var78];
               float var108 = var100 * (var107 + (1.0F - var107) * var137 * var137 * var134) * var79;
               int var109 = (int)(var108 * 255.0F);
               var109 = var109 > (-379343422 ^ -379343555) ? 2053579346 ^ 2053579437 : var109;
               var25[var53] = 391711865 ^ -396817287 | var109 << 16 | var109 << 8 | var109;
            } else {
               var25[var53] = 0;
            }
         }

         int[] var114 = CI[var0];
         int var115 = NC[var0];
         float[] var116 = OP;
         float[] var117 = OT;
         int[] var118 = OC;

         for (int var119 = 0; var119 < var115; var119++) {
            int var121 = var114[var119];
            var116[var119 * 3] = var21[var121 * 3];
            var116[var119 * 3 + 1] = var21[var121 * 3 + 1];
            var116[var119 * 3 + 2] = var21[var121 * 3 + 2];
            var117[var119 * 2] = var22[var121 * 2];
            var117[var119 * 2 + 1] = var22[var121 * 2 + 1];
            var118[var119] = var24[var121];
         }

         OV = var115;
         ei = var0;
         int[] var120 = HWQ[var0];
         WQ = var120;
         WN = var120.length;
      } catch (RuntimeException var110) {
         throw var110;
      }
   }

   public static void an() {

      assert ei > 0
         && ei < 7
         && CI[ei] != null
         && OV >= 0
         && (OV & 3) == 0
         && CI[ei].length >= OV
         && SP != null
         && ST != null
         && SC != null
         && (long)SP.length >= (long)OV * 3L
         && (long)ST.length >= (long)OV * 2L
         && SC.length >= OV
         && eg.length >= NU[ei]
         && eh.length >= NU[ei]
         && (long)ec.length >= (long)NU[ei] * 3L
         && (long)ee.length >= (long)NU[ei] * 2L
         && RECT.length == 40
         && ea.length == 36
         && eb.length == 27 : "sh" + "a" + "d" + "eSpec";

      try {
         int[] var0 = CI[ei];
         int var1 = OV;
         int var2 = 0;
         float[] var3 = ec;
         float[] var4 = ee;
         float[] var5 = SP;
         float[] var6 = ST;
         int[] var7 = eg;
         int[] var8 = SC;
         boolean[] var9 = eh;

         for (byte var10 = 0; var10 < var1; var10 += 4) {
            int var11 = var0[var10];
            int var12 = var0[var10 + 1];
            int var13 = var0[var10 + 2];
            int var14 = var0[var10 + 3];
            if (var7[var11] != 0 && (var9[var11] || var9[var12] || var9[var13] || var9[var14])) {
               for (int var15 = 0; var15 < 4; var15++) {
                  int var16 = var0[var10 + var15];
                  var5[var2 * 3] = var3[var16 * 3];
                  var5[var2 * 3 + 1] = var3[var16 * 3 + 1];
                  var5[var2 * 3 + 2] = var3[var16 * 3 + 2];
                  var6[var2 * 2] = var4[var16 * 2];
                  var6[var2 * 2 + 1] = var4[var16 * 2 + 1];
                  var8[var2] = var7[var16];
                  var2++;
               }
            }
         }

         SV = var2;
      } catch (RuntimeException var17) {
         throw var17;
      }
   }

   public static void ao(int var0, int var1, float var2) {

      float[] var3 = SPP[var0];
      byte[] var4 = SPA[var0];
      int var5 = SPN[var0];
      float[] var6 = GP;
      float[] var7 = GT;
      int[] var8 = GC;
      float var9 = var2 < 0.05F ? 0.05F : var2;
      float var10 = 0.024F * (var9 > 1.0F ? 0.75F + 0.25F * var9 : 1.0F);
      int var11 = (int)(0.44F * (var9 > 1.0F ? 1.0F : var9) * 255.0F);
      int var12 = var11 << 24 | var1 & (895428227 ^ 899733884);
      float var13 = CAM[0] * var10;
      float var14 = CAM[3] * var10;
      float var15 = CAM[6] * var10;
      float var16 = CAM[1] * var10;
      float var17 = CAM[4] * var10;
      float var18 = CAM[7] * var10;
      float var19 = 0.25146484F;
      float var20 = 0.31103516F;
      float var21 = 0.87646484F;
      float var22 = 0.93603516F;
      byte var23 = 0;

      for (int var24 = 0; var24 < var5; var24++) {
         int var25 = var4[var24] * 12;
         float var26 = var3[var24 * 3];
         float var27 = var3[var24 * 3 + 1];
         float var28 = var3[var24 * 3 + 2];
         float var29 = ea[var25] * var26 + ea[var25 + 1] * var27 + ea[var25 + 2] * var28 + ea[var25 + 3];
         float var30 = ea[var25 + 4] * var26 + ea[var25 + 5] * var27 + ea[var25 + 6] * var28 + ea[var25 + 7];
         float var31 = ea[var25 + 8] * var26 + ea[var25 + 9] * var27 + ea[var25 + 10] * var28 + ea[var25 + 11];
         float var32 = (float)Math.sqrt((double)(var29 * var29 + var30 * var30 + var31 * var31));
         float var33 = var32 > 1.0E-4F ? 1.0F + 0.022F / var32 : 1.0F;
         var29 *= var33;
         var30 *= var33;
         var31 *= var33;
         int var34 = var23 * 3;
         int var35 = var23 * 2;
         var6[var34] = var29 - var13 - var16;
         var6[var34 + 1] = var30 - var14 - var17;
         var6[var34 + 2] = var31 - var15 - var18;
         var6[var34 + 3] = var29 + var13 - var16;
         var6[var34 + 4] = var30 + var14 - var17;
         var6[var34 + 5] = var31 + var15 - var18;
         var6[var34 + 6] = var29 + var13 + var16;
         var6[var34 + 7] = var30 + var14 + var17;
         var6[var34 + 8] = var31 + var15 + var18;
         var6[var34 + 9] = var29 - var13 + var16;
         var6[var34 + 10] = var30 - var14 + var17;
         var6[var34 + 11] = var31 - var15 + var18;
         var7[var35] = var19;
         var7[var35 + 1] = var22;
         var7[var35 + 2] = var20;
         var7[var35 + 3] = var22;
         var7[var35 + 4] = var20;
         var7[var35 + 5] = var21;
         var7[var35 + 6] = var19;
         var7[var35 + 7] = var21;
         var8[var23] = var12;
         var8[var23 + 1] = var12;
         var8[var23 + 2] = var12;
         var8[var23 + 3] = var12;
         var23 += 4;
      }

      GV = var23;
   }

   public static void ap(float[] var0, float[] var1, int var2, int var3) {

      assert var0 != null
         && var0.length >= 12
         && var1 != null
         && var1.length >= 9
         && AP.length == 72
         && AT.length == 48
         && AC.length == 24
         && AGP.length == (912606286 ^ 912613838)
         && AGT.length == (941998445 ^ 942004333)
         && AGC.length == (-2050364220 ^ -2050367420)
         && dz.length == 9
         && RECT.length == 40
         && ARM_BOX.length >= 6
         && BOX_N.length >= 18
         && BOX_Q.length >= 24
         && ARM_WS > 0.0F
         && ARM_LS > 0.0F : "shadeArm";

      try {
         float var4 = ARM_WS;
         float var5 = ARM_LS;
         float var6 = (-1.0F + (ARM_BOX[0] - -1.0F) * var4) / 16.0F;
         float var7 = (9.8F + (ARM_BOX[1] - 9.8F) * var5 - 12.0F) / 16.0F;
         float var8 = (0.0F + (ARM_BOX[2] - 0.0F) * var4) / 16.0F;
         float var9 = (-1.0F + (ARM_BOX[3] - -1.0F) * var4) / 16.0F;
         float var10 = (9.8F + (ARM_BOX[4] - 9.8F) * var5) / 16.0F;
         float var11 = (0.0F + (ARM_BOX[5] - 0.0F) * var4) / 16.0F;
         float var12 = (float)(var2 >> 16 & (2058593878 ^ 2058593961)) / 255.0F;
         float var13 = (float)(var2 >> 8 & (1605065527 ^ 1605065672)) / 255.0F;
         float var14 = (float)(var2 & (596871306 ^ 596871285)) / 255.0F;
         float var15 = dz[0];
         float var16 = dz[1];
         float var17 = dz[2];
         float var18 = RECT[24] + RECT[26] * 0.5F;
         float var19 = RECT[25] + RECT[27] * 0.5F;

         for (int var20 = 0; var20 < 6; var20++) {
            float var21 = BOX_N[var20 * 3];
            float var22 = BOX_N[var20 * 3 + 1];
            float var23 = BOX_N[var20 * 3 + 2];
            float var24 = var1[0] * var21 + var1[1] * var22 + var1[2] * var23;
            float var25 = var1[3] * var21 + var1[4] * var22 + var1[5] * var23;
            float var26 = var1[6] * var21 + var1[7] * var22 + var1[8] * var23;
            float var27 = var24 * var15 + var25 * var16 + var26 * var17;
            float var28 = 0.7F + 0.3F * (var27 > 0.0F ? var27 : 0.0F) + 0.08F * var25;
            if (var28 > 1.0F) {
               var28 = 1.0F;
            }

            int var29 = -617366999 ^ 607369769 | (int)(var12 * var28 * 255.0F) << 16 | (int)(var13 * var28 * 255.0F) << 8 | (int)(var14 * var28 * 255.0F);

            for (int var30 = 0; var30 < 4; var30++) {
               int var31 = BOX_Q[var20 * 4 + var30];
               float var32 = (var31 & 1) != 0 ? var9 : var6;
               float var33 = (var31 & 2) != 0 ? var10 : var7;
               float var34 = (var31 & 4) != 0 ? var11 : var8;
               int var35 = var20 * 4 + var30;
               AP[var35 * 3] = var0[0] * var32 + var0[1] * var33 + var0[2] * var34 + var0[3];
               AP[var35 * 3 + 1] = var0[4] * var32 + var0[5] * var33 + var0[6] * var34 + var0[7];
               AP[var35 * 3 + 2] = var0[8] * var32 + var0[9] * var33 + var0[10] * var34 + var0[11];
               AC[var35] = var29;
               AT[var35 * 2] = var18;
               AT[var35 * 2 + 1] = var19;
            }

            int var74 = var20 * 12;
            float var76 = AP[var74] + AP[var74 + 3] + AP[var74 + 6] + AP[var74 + 9];
            float var78 = AP[var74 + 1] + AP[var74 + 4] + AP[var74 + 7] + AP[var74 + 10];
            float var80 = AP[var74 + 2] + AP[var74 + 5] + AP[var74 + 8] + AP[var74 + 11];
            ek[var20] = var24 * var76 + var25 * var78 + var26 * var80 < 0.0F;
         }

         AGV = 0;
         if (var3 != 0) {
            for (int var60 = 0; var60 < 8; var60++) {
               float var62 = (var60 & 1) != 0 ? var9 : var6;
               float var64 = (var60 & 2) != 0 ? var10 : var7;
               float var66 = (var60 & 4) != 0 ? var11 : var8;
               ej[var60 * 3] = var0[0] * var62 + var0[1] * var64 + var0[2] * var66 + var0[3];
               ej[var60 * 3 + 1] = var0[4] * var62 + var0[5] * var64 + var0[6] * var66 + var0[7];
               ej[var60 * 3 + 2] = var0[8] * var62 + var0[9] * var64 + var0[10] * var66 + var0[11];
            }

            int var61 = 1865115147 ^ 439051787 | var3 & (1133427183 ^ 1131496976);
            float var63 = 0.04F * (0.5F + 0.5F * var4);
            float var65 = 0.01F * (0.5F + 0.5F * var4);
            float var67 = CAM[0] * var63;
            float var68 = CAM[3] * var63;
            float var69 = CAM[6] * var63;
            float var70 = CAM[1] * var63;
            float var71 = CAM[4] * var63;
            float var72 = CAM[7] * var63;
            float var73 = 0.25146484F;
            float var75 = 0.31103516F;
            float var77 = 0.87646484F;
            float var79 = 0.93603516F;
            byte var81 = 0;
            int var82 = -1706420908 ^ -1706420620;
            int var83 = 0;

            for (int var36 = 0; var36 < 13; var36++) {
               int var84;
               int var85;
               if (var36 < 12) {
                  if (ek[BOX_E[var36 * 4 + 2]] == ek[BOX_E[var36 * 4 + 3]]) {
                     continue;
                  }

                  var84 = BOX_E[var36 * 4];
                  var85 = BOX_E[var36 * 4 + 1];
                  var83 |= 1 << var84 | 1 << var85;
                  var84 *= 3;
                  var85 *= 3;
               } else {
                  var85 = 0;
                  var84 = 0;
               }

               float var40 = ej[var84];
               float var41 = ej[var84 + 1];
               float var42 = ej[var84 + 2];
               float var43 = ej[var85] - var40;
               float var44 = ej[var85 + 1] - var41;
               float var45 = ej[var85 + 2] - var42;
               byte var46 = 1;
               int var39;
               if (var36 < 12) {
                  var39 = (int)Math.ceil(Math.sqrt((double)(var43 * var43 + var44 * var44 + var45 * var45)) / (double)var65);
                  if (var39 < 2) {
                     continue;
                  }

                  if (var39 - 1 > var82) {
                     var39 = var82 + 1;
                     if (var39 < 2) {
                        break;
                     }
                  }

                  var82 -= var39 - 1;
               } else {
                  var46 = 0;
                  var39 = 8;
               }

               for (int var47 = var46; var47 < var39; var47++) {
                  float var48;
                  float var49;
                  float var50;
                  if (var36 < 12) {
                     float var51 = (float)var47 / (float)var39;
                     var48 = var40 + var43 * var51;
                     var49 = var41 + var44 * var51;
                     var50 = var42 + var45 * var51;
                  } else {
                     if ((var83 & 1 << var47) == 0 || var82 <= 0) {
                        continue;
                     }

                     var82--;
                     var48 = ej[var47 * 3];
                     var49 = ej[var47 * 3 + 1];
                     var50 = ej[var47 * 3 + 2];
                  }

                  float var89 = -(CAM[2] * var48 + CAM[5] * var49 + CAM[8] * var50);
                  if (!(var89 < 0.04F)) {
                     float var52 = CAM[0] * var48 + CAM[3] * var49 + CAM[6] * var50;
                     float var53 = CAM[1] * var48 + CAM[4] * var49 + CAM[7] * var50;
                     float var54 = 2.0F * var63;
                     if (!(var52 > 2.8F * var89 + var54)
                        && !(-var52 > 2.8F * var89 + var54)
                        && !(var53 > 2.2F * var89 + var54)
                        && !(-var53 > 2.2F * var89 + var54)) {
                        float var55 = (float)Math.sqrt((double)(var48 * var48 + var49 * var49 + var50 * var50));
                        float var56 = var55 > 1.0E-4F ? 1.0F + 0.03F / var55 : 1.0F;
                        var48 *= var56;
                        var49 *= var56;
                        var50 *= var56;
                        int var57 = var81 * 3;
                        int var58 = var81 * 2;
                        AGP[var57] = var48 - var67 - var70;
                        AGP[var57 + 1] = var49 - var68 - var71;
                        AGP[var57 + 2] = var50 - var69 - var72;
                        AGP[var57 + 3] = var48 + var67 - var70;
                        AGP[var57 + 4] = var49 + var68 - var71;
                        AGP[var57 + 5] = var50 + var69 - var72;
                        AGP[var57 + 6] = var48 + var67 + var70;
                        AGP[var57 + 7] = var49 + var68 + var71;
                        AGP[var57 + 8] = var50 + var69 + var72;
                        AGP[var57 + 9] = var48 - var67 + var70;
                        AGP[var57 + 10] = var49 - var68 + var71;
                        AGP[var57 + 11] = var50 - var69 + var72;
                        AGT[var58] = var73;
                        AGT[var58 + 1] = var79;
                        AGT[var58 + 2] = var75;
                        AGT[var58 + 3] = var79;
                        AGT[var58 + 4] = var75;
                        AGT[var58 + 5] = var77;
                        AGT[var58 + 6] = var73;
                        AGT[var58 + 7] = var77;
                        AGC[var81] = var61;
                        AGC[var81 + 1] = var61;
                        AGC[var81 + 2] = var61;
                        AGC[var81 + 3] = var61;
                        var81 += 4;
                     }
                  }
               }
            }

            AGV = var81;
         }
      } catch (RuntimeException var59) {
         throw var59;
      }
   }

   private static void aq(float var0, float var1, float var2) {

      if (fc < ez.length) {
         ez[fc] = var0;
         fa[fc] = var1;
         fb[fc] = var2;
         fc++;
      }
   }

   private static void ar(float var0, float var1, float var2) {
      int var3 = 0;
      byte var4 = 0;

      label17:
      while (true) {
         switch (var4) {
            case 0:
            default:
               if (fz != 0) {
                  Math.abs(Integer.MIN_VALUE);
                  var4 = 1;
                  break;
               }
            case 1:
               if (es + 1 > eq.length) {
                  var3 = eq.length * 2;
                  el = Arrays.copyOf(el, var3 * 3);
                  eq = Arrays.copyOf(eq, var3);
                  var4 = 2;
                  break;
               }
            case 2:
               break label17;
         }
      }

      el[es * 3] = var0;
      el[es * 3 + 1] = var1;
      el[es * 3 + 2] = var2;
      eq[es] = ew;
      es++;
   }

   private static void as(boolean var0) {

      int var1 = fc;
      fc = 0;
      if (var1 == 1) {
         ar(ez[0], fa[0], fb[0]);
      }

      if (var1 >= 2) {
         int var2 = var0 ? var1 : var1 - 1;
         float var3 = 0.0F;

         for (int var4 = 0; var4 < var2; var4++) {
            int var5 = (var4 + 1) % var1;
            float var6 = ez[var5] - ez[var4];
            float var7 = fa[var5] - fa[var4];
            float var8 = fb[var5] - fb[var4];
            var3 += (float)Math.sqrt((double)(var6 * var6 + var7 * var7 + var8 * var8));
         }

         int var14 = Math.max(1, Math.round(var3 / fd));
         float var15 = var3 / (float)var14;
         int var16 = 0;
         float var17 = 0.0F;
         float var18 = (float)Math.sqrt((double)(at(ez[1] - ez[0]) + at(fa[1] - fa[0]) + at(fb[1] - fb[0])));
         int var9 = 0;

         for (int var10 = var0 ? var14 : var14 + 1; var9 < var10; var9++) {
            float var11 = Math.min(var3, (float)var9 * var15);

            while (var16 < var2 - 1 && var11 > var17 + var18) {
               var17 += var18;
               int var12 = (++var16 + 1) % var1;
               var18 = (float)Math.sqrt((double)(at(ez[var12] - ez[var16]) + at(fa[var12] - fa[var16]) + at(fb[var12] - fb[var16])));
            }

            int var19 = (var16 + 1) % var1;
            float var13 = var18 > 1.0E-6F ? (var11 - var17) / var18 : 0.0F;
            var13 = var13 < 0.0F ? 0.0F : (var13 > 1.0F ? 1.0F : var13);
            ar(ez[var16] + (ez[var19] - ez[var16]) * var13, fa[var16] + (fa[var19] - fa[var16]) * var13, fb[var16] + (fb[var19] - fb[var16]) * var13);
         }
      }
   }

   private static float at(float var0) {

      return var0 * var0;
   }

   private static void au(float var0, float var1, float var2, float var3) {

      for (int var4 = 0; var4 <= 12; var4++) {
         double var5 = (Math.PI / 2) + Math.PI * (double)var4 / 12.0;
         aq(var0 + var3 + (float)Math.cos(var5) * var3, var2 + (float)Math.sin(var5) * var3, 0.0F);
      }

      for (int var7 = 0; var7 <= 12; var7++) {
         double var8 = (-Math.PI / 2) + Math.PI * (double)var7 / 12.0;
         aq(var1 - var3 + (float)Math.cos(var8) * var3, var2 + (float)Math.sin(var8) * var3, 0.0F);
      }

      as(true);
   }

   private static void av(float var0, float var1, float var2, float var3) {

      aq(var0, var2, 0.0F);
      aq(var1, var2, 0.0F);
      aq(var1, var3, 0.0F);
      aq(var0, var3, 0.0F);
      as(true);
   }

   private static void aw(boolean var0) {

      et = var0;
      el = new float[6144];
      em = new float[6144];
      en = new float[6144];
      eo = new float[4096];
      ep = new float[2048];
      eq = new byte[2048];
      er = new byte[2048];
      es = 0;
   }

   private static void ax(
      int var0,
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12
   ) {

      int var13 = var0 * 12;
      ey[var13] = var1;
      ey[var13 + 1] = var2;
      ey[var13 + 2] = var3;
      ey[var13 + 3] = var4;
      ey[var13 + 4] = var5;
      ey[var13 + 5] = var6;
      ey[var13 + 6] = var7;
      ey[var13 + 7] = var8;
      ey[var13 + 8] = var9;
      ey[var13 + 9] = var10;
      ey[var13 + 10] = var11;
      ey[var13 + 11] = var12;
   }

   private static void ay() {

      float var0 = ey[12] - ey[0];
      float var1 = ey[13] - ey[1];
      float var2 = ey[14] - ey[2];
      float var3 = ey[24] - ey[0];
      float var4 = ey[25] - ey[1];
      float var5 = ey[26] - ey[2];
      float var6 = ey[36] - ey[0];
      float var7 = ey[37] - ey[1];
      float var8 = ey[38] - ey[2];
      float var9 = var1 * var5 - var2 * var4 + var4 * var8 - var5 * var7;
      float var10 = var2 * var3 - var0 * var5 + var5 * var6 - var3 * var8;
      float var11 = var0 * var4 - var1 * var3 + var3 * var7 - var4 * var6;
      if (!(var9 * var9 + var10 * var10 + var11 * var11 < 1.0E-14F)) {
         float var12 = ey[3] + ey[15] + ey[27] + ey[39];
         float var13 = ey[4] + ey[16] + ey[28] + ey[40];
         float var14 = ey[5] + ey[17] + ey[29] + ey[41];
         float var15 = var9 * var12 + var10 * var13 + var11 * var14;
         if (es + 4 > eq.length) {
            int var16 = eq.length * 2;
            el = Arrays.copyOf(el, var16 * 3);
            em = Arrays.copyOf(em, var16 * 3);
            en = Arrays.copyOf(en, var16 * 3);
            eo = Arrays.copyOf(eo, var16 * 2);
            ep = Arrays.copyOf(ep, var16);
            eq = Arrays.copyOf(eq, var16);
            er = Arrays.copyOf(er, var16);
         }

         for (int var19 = 0; var19 < 4; var19++) {
            int var17 = (var15 >= 0.0F ? var19 : 4 - var19 & 3) * 12;
            int var18 = es * 3;
            el[var18] = ey[var17];
            el[var18 + 1] = ey[var17 + 1];
            el[var18 + 2] = ey[var17 + 2];
            em[var18] = ey[var17 + 3];
            em[var18 + 1] = ey[var17 + 4];
            em[var18 + 2] = ey[var17 + 5];
            en[var18] = ey[var17 + 8];
            en[var18 + 1] = ey[var17 + 9];
            en[var18 + 2] = ey[var17 + 10];
            eo[es * 2] = ey[var17 + 6];
            eo[es * 2 + 1] = ey[var17 + 7];
            ep[es] = ey[var17 + 11];
            eq[es] = ew;
            er[es] = ex;
            es++;
         }
      }
   }

   private static void az(int var0) {

      if (et) {
         SPP[var0] = Arrays.copyOf(el, es * 3);
         SPA[var0] = Arrays.copyOf(eq, es);
         SPN[var0] = es;
      } else {
         int var1 = es;
         int var2 = Integer.highestOneBit(Math.max(64, var1 * 2)) << 1;
         int[] var3 = new int[var2];
         int[] var4 = new int[var1];
         int[] var5 = new int[var1];
         Arrays.fill(var3, -1);
         int var6 = 0;

         for (int var7 = 0; var7 < var1; var7++) {
            int var8 = 17;

            for (int var9 = 0; var9 < 3; var9++) {
               var8 = var8 * 31 + Float.floatToIntBits(el[var7 * 3 + var9]);
               var8 = var8 * 31 + Float.floatToIntBits(em[var7 * 3 + var9]);
            }

            var8 = var8 * 31 + Float.floatToIntBits(eo[var7 * 2]);
            var8 = var8 * 31 + Float.floatToIntBits(eo[var7 * 2 + 1]);
            var8 ^= var8 >>> 16;
            int var23 = var8 & var2 - 1;

            int var10;
            for (var10 = -1; var3[var23] >= 0; var23 = var23 + 1 & var2 - 1) {
               int var11 = var4[var3[var23]];
               boolean var12 = eq[var11] == eq[var7]
                  && er[var11] == er[var7]
                  && ep[var11] == ep[var7]
                  && eo[var11 * 2] == eo[var7 * 2]
                  && eo[var11 * 2 + 1] == eo[var7 * 2 + 1];

               for (int var13 = 0; var13 < 3 && var12; var13++) {
                  var12 = el[var11 * 3 + var13] == el[var7 * 3 + var13]
                     && em[var11 * 3 + var13] == em[var7 * 3 + var13]
                     && en[var11 * 3 + var13] == en[var7 * 3 + var13];
               }

               if (var12) {
                  var10 = var3[var23];
                  break;
               }
            }

            if (var10 < 0) {
               var10 = var6;
               var3[var23] = var6;
               var4[var6] = var7;
               var6++;
            }

            var5[var7] = var10;
         }

         float[] var17 = new float[var6 * 3];
         float[] var22 = new float[var6 * 3];
         float[] var24 = new float[var6 * 3];
         float[] var25 = new float[var6 * 2];
         float[] var26 = new float[var6];
         byte[] var27 = new byte[var6];
         byte[] var28 = new byte[var6];

         for (int var14 = 0; var14 < var6; var14++) {
            int var15 = var4[var14];

            for (int var16 = 0; var16 < 3; var16++) {
               var17[var14 * 3 + var16] = el[var15 * 3 + var16];
               var22[var14 * 3 + var16] = em[var15 * 3 + var16];
               var24[var14 * 3 + var16] = en[var15 * 3 + var16];
            }

            var25[var14 * 2] = eo[var15 * 2];
            var25[var14 * 2 + 1] = eo[var15 * 2 + 1];
            var26[var14] = ep[var15];
            var27[var14] = eq[var15];
            var28[var14] = er[var15];
         }

         UP[var0] = var17;
         UN[var0] = var22;
         UG[var0] = var24;
         UT[var0] = var25;
         UO[var0] = var26;
         UA[var0] = var27;
         UM[var0] = var28;
         NU[var0] = var6;
         CI[var0] = var5;
         NC[var0] = var1;
         int var29 = 0;

         for (byte var31 = 0; var31 + 3 < var1; var31 += 4) {
            if (er[var31] == 7) {
               var29++;
            }
         }

         int[] var32 = new int[var29];
         var29 = 0;

         for (byte var33 = 0; var33 + 3 < var1; var33 += 4) {
            if (er[var33] == 7) {
               var32[var29++] = var33;
            }
         }

         HWQ[var0] = var32;
      }
   }

   private static void ba(float var0, float var1) {

      fg[fq] = var0;
      fh[fq] = var1;
      fq++;
      fr = 0;
   }

   private static void bb(float var0, float var1, float var2, int var3, float var4) {

      int var5 = (fq - 1) * 20 + fr;
      fl[var5] = var0;
      fm[var5] = var1;
      fn[var5] = var2;
      fp[var5] = (byte)var3;
      fo[var5] = var4;
      fr++;
   }

   private static void bc() {

      float var0 = 0.0F;
      fk[0] = 0.0F;

      for (int var1 = 1; var1 < fq; var1++) {
         float var2 = fg[var1] - fg[var1 - 1];
         float var3 = fh[var1] - fh[var1 - 1];
         var0 += (float)Math.sqrt((double)(var2 * var2 + var3 * var3));
         fk[var1] = var0;
      }

      for (int var7 = 0; var7 < fq; var7++) {
         int var8 = var7 > 0 ? var7 - 1 : 0;
         int var9 = var7 < fq - 1 ? var7 + 1 : fq - 1;
         float var4 = fg[var9] - fg[var8];
         float var5 = fh[var9] - fh[var8];
         float var6 = (float)Math.sqrt((double)(var4 * var4 + var5 * var5));
         fi[var7] = var4 / var6;
         fj[var7] = var5 / var6;
         fk[var7] = var0 > 0.0F ? fk[var7] / var0 : 0.0F;
      }
   }

   private static void bd(boolean var0, boolean var1, float var2, float var3) {

      bc();
      if (et) {
         bf();
      } else {
         int var4 = fr;
         int var5 = 0;
         float var6 = -1.0F;

         for (int var7 = 0; var7 < fq; var7++) {
            float var8 = 1.0E9F;
            float var9 = -1.0E9F;

            for (int var10 = 0; var10 < var4; var10++) {
               var8 = Math.min(var8, fl[var7 * 20 + var10]);
               var9 = Math.max(var9, fl[var7 * 20 + var10]);
            }

            if (var9 - var8 > var6) {
               var6 = var9 - var8;
               var5 = var7;
            }
         }

         float var37 = 0.0F;

         for (int var38 = 0; var38 < var4; var38++) {
            int var41 = var5 * 20 + var38;
            int var44 = var5 * 20 + (var38 + 1) % var4;
            var37 += fl[var41] * fm[var44] - fl[var44] * fm[var41];
         }

         if (var37 < 0.0F) {
            for (int var39 = 0; var39 < fq; var39++) {
               int var42 = var39 * 20;
               int var45 = 0;

               for (int var11 = var4 - 1; var45 < var11; var11--) {
                  float var12 = fl[var42 + var45];
                  fl[var42 + var45] = fl[var42 + var11];
                  fl[var42 + var11] = var12;
                  var12 = fm[var42 + var45];
                  fm[var42 + var45] = fm[var42 + var11];
                  fm[var42 + var11] = var12;
                  var12 = fn[var42 + var45];
                  fn[var42 + var45] = fn[var42 + var11];
                  fn[var42 + var11] = var12;
                  var12 = fo[var42 + var45];
                  fo[var42 + var45] = fo[var42 + var11];
                  fo[var42 + var11] = var12;
                  byte var13 = fp[var42 + var45];
                  fp[var42 + var45] = fp[var42 + var11];
                  fp[var42 + var11] = var13;
                  var45++;
               }

               for (int var46 = 0; var46 < var4; var46++) {
                  byte var50 = fp[var42 + var46];
                  fp[var42 + var46] = var50 == 2 ? 3 : (var50 == 3 ? 2 : var50);
               }
            }
         }

         float[] var40 = new float[fq * 20 * 3];
         boolean[] var43 = new boolean[fq * 20];

         for (int var47 = 0; var47 < fq; var47++) {
            int var51 = var47 > 0 ? var47 - 1 : 0;
            int var57 = var47 < fq - 1 ? var47 + 1 : fq - 1;
            float var61 = -fj[var47];
            float var14 = fi[var47];

            for (int var15 = 0; var15 < var4; var15++) {
               int var16 = (var15 + 1) % var4;
               int var17 = var47 * 20 + var15;
               int var18 = var47 * 20 + var16;
               float var19 = fl[var18] - fl[var17];
               float var20 = fm[var18] - fm[var17];
               float var21 = var61 * var19;
               float var22 = var14 * var19;
               float var24 = var21 * var21 + var22 * var22 + var20 * var20;
               float var25 = (fl[var51 * 20 + var15] + fl[var51 * 20 + var16]) * 0.5F;
               float var26 = (fl[var57 * 20 + var15] + fl[var57 * 20 + var16]) * 0.5F;
               float var27 = fg[var57] - fj[var57] * var26 - (fg[var51] - fj[var51] * var25);
               float var28 = fh[var57] + fi[var57] * var26 - (fh[var51] + fi[var51] * var25);
               float var29 = (fm[var57 * 20 + var15] + fm[var57 * 20 + var16] - fm[var51 * 20 + var15] - fm[var51 * 20 + var16]) * 0.5F;
               float var30 = var28 * var20 - var29 * var22;
               float var31 = var29 * var21 - var27 * var20;
               float var32 = var27 * var22 - var28 * var21;
               float var33 = var61 * var20;
               float var34 = var14 * var20;
               float var35 = -var19;
               if (var30 * var30 + var31 * var31 + var32 * var32 < 1.0E-12F) {
                  var30 = var33;
                  var31 = var34;
                  var32 = var35;
               }

               if (var30 * var33 + var31 * var34 + var32 * var35 < 0.0F) {
                  var30 = -var30;
                  var31 = -var31;
                  var32 = -var32;
               }

               float var36 = (float)Math.sqrt((double)(var30 * var30 + var31 * var31 + var32 * var32));
               var43[var17] = var24 > 1.0E-10F && var36 > 1.0E-9F;
               if (var36 > 1.0E-9F) {
                  var40[var17 * 3] = var30 / var36;
                  var40[var17 * 3 + 1] = var31 / var36;
                  var40[var17 * 3 + 2] = var32 / var36;
               }
            }
         }

         for (int var48 = 0; var48 < var4; var48++) {
            for (int var52 = 0; var52 < fq; var52++) {
               if (!var43[var52 * 20 + var48]) {
                  for (int var58 = 1; var58 < fq; var58++) {
                     int var62 = var52 - var58 >= 0 && var43[(var52 - var58) * 20 + var48]
                        ? var52 - var58
                        : (var52 + var58 < fq && var43[(var52 + var58) * 20 + var48] ? var52 + var58 : -1);
                     if (var62 >= 0) {
                        System.arraycopy(var40, (var62 * 20 + var48) * 3, var40, (var52 * 20 + var48) * 3, 3);
                        break;
                     }
                  }
               }
            }
         }

         float[] var49 = new float[fq * 20 * 3];
         float[] var53 = new float[fq * 20 * 3];

         for (int var59 = 0; var59 < fq; var59++) {
            for (int var63 = 0; var63 < var4; var63++) {
               int var65 = var59 * 20;
               int var67 = (var63 + var4 - 1) % var4;
               byte var70 = fp[var65 + var63];
               int var72 = var67;
               int var74 = var63;
               if (var70 == 2) {
                  for (int var77 = 0; var77 < var4 && !var43[var65 + var72]; var77++) {
                     var72 = (var72 + var4 - 1) % var4;
                  }

                  var74 = var72;
               } else if (var70 == 3) {
                  for (int var76 = 0; var76 < var4 && !var43[var65 + var74]; var76++) {
                     var74 = (var74 + 1) % var4;
                  }

                  var72 = var74;
               }

               float var78 = var40[(var65 + var72) * 3];
               float var79 = var40[(var65 + var72) * 3 + 1];
               float var80 = var40[(var65 + var72) * 3 + 2];
               float var23 = var40[(var65 + var74) * 3];
               float var81 = var40[(var65 + var74) * 3 + 1];
               float var82 = var40[(var65 + var74) * 3 + 2];
               if (var70 == 1) {
                  float var83 = var78 + var23;
                  float var85 = var79 + var81;
                  float var86 = var80 + var82;
                  float var87 = (float)Math.sqrt((double)(var83 * var83 + var85 * var85 + var86 * var86));
                  if (var87 > 1.0E-6F) {
                     var78 = var23 = var83 / var87;
                     var79 = var81 = var85 / var87;
                     var80 = var82 = var86 / var87;
                  }
               }

               int var84 = (var65 + var63) * 3;
               var49[var84] = var78;
               var49[var84 + 1] = var79;
               var49[var84 + 2] = var80;
               var53[var84] = var23;
               var53[var84 + 1] = var81;
               var53[var84 + 2] = var82;
            }
         }

         for (int var60 = 0; var60 < fq - 1; var60++) {
            for (int var64 = 0; var64 < var4; var64++) {
               int var66 = (var64 + 1) % var4;

               for (int var68 = 0; var68 < 4; var68++) {
                  int var69 = var68 != 0 && var68 != 3 ? var60 + 1 : var60;
                  int var71 = var68 != 0 && var68 != 1 ? var66 : var64;
                  int var73 = var69 * 20 + var71;
                  float[] var75 = var71 == var64 ? var53 : var49;
                  ax(
                     var68,
                     fg[var69] - fj[var69] * fl[var73],
                     fh[var69] + fi[var69] * fl[var73],
                     fm[var73],
                     var75[var73 * 3],
                     var75[var73 * 3 + 1],
                     var75[var73 * 3 + 2],
                     var2 + fk[var69] * var3,
                     fn[var73],
                     fi[var69],
                     fj[var69],
                     0.0F,
                     fo[var73]
                  );
               }

               ay();
            }
         }

         if (var0) {
            be(0, -1.0F, var2);
         }

         if (var1) {
            be(fq - 1, 1.0F, var2 + var3);
         }
      }
   }

   private static void be(int var0, float var1, float var2) {

      int var3 = fr;
      int var4 = var0 * 20;
      float var5 = fi[var0] * var1;
      float var6 = fj[var0] * var1;

      for (byte var7 = 1; var7 + 1 < var3; var7 += 2) {
         int var8 = var7 + 2 < var3 ? var7 + 2 : var7 + 1;

         for (int var9 = 0; var9 < 4; var9++) {
            int var10 = var9 == 0 ? 0 : (var9 == 1 ? var7 : (var9 == 2 ? var7 + 1 : var8));
            ax(
               var9,
               fg[var0] - fj[var0] * fl[var4 + var10],
               fh[var0] + fi[var0] * fl[var4 + var10],
               fm[var4 + var10],
               var5,
               var6,
               0.0F,
               var2,
               fn[var4 + var10],
               -fj[var0],
               fi[var0],
               0.0F,
               1.0F
            );
         }

         ay();
      }
   }

   private static void bf() {

      int var0 = fq;
      int var1 = fr;
      float[] var2 = new float[var0];
      float[] var3 = new float[var0];

      for (int var4 = 0; var4 < var0; var4++) {
         float var5 = 1.0E9F;
         float var6 = -1.0E9F;

         for (int var7 = 0; var7 < var1; var7++) {
            var5 = Math.min(var5, fl[var4 * 20 + var7]);
            var6 = Math.max(var6, fl[var4 * 20 + var7]);
         }

         var3[var4] = var5;
         var2[var4] = var6;
      }

      if (eu) {
         aq(fg[0] - fj[0] * var3[0], fh[0] + fi[0] * var3[0], 0.0F);
      }

      for (int var8 = 0; var8 < var0; var8++) {
         aq(fg[var8] - fj[var8] * var2[var8], fh[var8] + fi[var8] * var2[var8], 0.0F);
      }

      boolean var9 = var2[var0 - 1] - var3[var0 - 1] < 0.001F;
      if (!var9 && !ev) {
         as(false);
      }

      for (int var10 = var9 ? var0 - 2 : var0 - 1; var10 >= 0; var10--) {
         aq(fg[var10] - fj[var10] * var3[var10], fh[var10] + fi[var10] * var3[var10], 0.0F);
      }

      as(false);
   }

   private static void bg(
      float var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11
   ) {

      float var12 = Math.max(1.0E-4F, var0 - var1);
      float var13 = Math.min(0.045F, Math.min(var5 * 0.45F, var12 * 0.12F));
      float var14 = 1.0F / var12;
      float var15 = var1 + var12 * var3;
      boolean var16 = var3 <= 0.0F;
      float var17 = var0 - var13 - var4;
      var6 = Math.min(var6, (var15 - var1) * 0.45F);
      var7 = Math.min(var7, var2 * 0.6F);
      if (var10 <= 0.0F && var8 == 0.0F && var9 == 0.0F) {
         var8 = var9 = Math.max(var15, Math.min(var17, (var17 + var15) * 0.5F));
      }

      var8 = Math.min(var8, var17);
      var9 = Math.max(Math.min(var9, var8), var15);
      float var18 = (var8 + var9) * 0.5F;
      float var19 = var11 * (var10 > 0.0F ? 0.72F : 1.0F);
      bb(var0, var5 - var13, 0.0F, 2, var11);
      bb(var0 - var13, var5, var13 * var14, 3, var11);
      bb(var17, var2, (var0 - var17) * var14, 0, var11);
      bb(var8, var2, (var0 - var8) * var14, 0, var11);
      bb(var18, var2 - var10, (var0 - var18) * var14, 1, var19);
      bb(var9, var2, (var0 - var9) * var14, 0, var11);
      if (var16) {
         float var20 = Math.min(0.045F, var2 * 0.45F);
         bb(var1 + var20, var2, 1.0F - var20 * var14, 2, var11);
         bb(var1, var2 - var20, 1.0F, 3, var11);
         bb(var1, 0.0F, 1.0F, 1, var11);
         bb(var1, -var2 + var20, 1.0F, 2, var11);
         bb(var1 + var20, -var2, 1.0F - var20 * var14, 3, var11);
      } else {
         bb(var15, var2, (var0 - var15) * var14, 0, var11);
         bb(var1 + var6, var7, 1.0F - var6 * var14, 0, var11);
         bb(var1, 0.0F, 1.0F, 0, var11);
         bb(var1 + var6, -var7, 1.0F - var6 * var14, 0, var11);
         bb(var15, -var2, (var0 - var15) * var14, 0, var11);
      }

      bb(var9, -var2, (var0 - var9) * var14, 0, var11);
      bb(var18, -var2 + var10, (var0 - var18) * var14, 1, var19);
      bb(var8, -var2, (var0 - var8) * var14, 0, var11);
      bb(var17, -var2, (var0 - var17) * var14, 0, var11);
      bb(var0 - var13, -var5, var13 * var14, 2, var11);
      bb(var0, -var5 + var13, 0.0F, 3, var11);
   }

   private static void bh(float var0, float var1, float var2, float var3, float var4, float var5) {

      var4 = Math.min(var4, Math.min(var3 * 0.95F, (var0 - var1) * 0.45F));
      float var6 = 2.0F * (var3 - var4);
      float var7 = var0 - var1 - 2.0F * var4;
      float var8 = var4 * 1.4142F;
      float var9 = 2.0F * var6 + 2.0F * var7 + 4.0F * var8;
      float var10 = 0.0F;
      bb(var0, var2 - var3 + var4, var10, 3, var5);
      var10 += var6 / var9;
      bb(var0, var2 + var3 - var4, var10, 2, var5);
      var10 += var8 / var9;
      bb(var0 - var4, var2 + var3, var10, 3, var5);
      var10 += var7 / var9;
      bb(var1 + var4, var2 + var3, var10, 2, var5);
      var10 += var8 / var9;
      bb(var1, var2 + var3 - var4, var10, 3, var5);
      var10 += var6 / var9;
      bb(var1, var2 - var3 + var4, var10, 2, var5);
      var10 += var8 / var9;
      bb(var1 + var4, var2 - var3, var10, 3, var5);
      var10 += var7 / var9;
      bb(var0 - var4, var2 - var3, var10, 2, var5);
      bb(var0, var2 - var3 + var4, 1.0F, 3, var5);
   }

   private static void bi(float var0, float var1, float var2, int var3, float var4) {

      for (int var5 = 0; var5 <= var3; var5++) {
         double var6 = (Math.PI * 2) * (double)var5 / (double)var3;
         bb(var0 + var1 * (float)Math.cos(var6), var2 * (float)Math.sin(var6), (float)var5 / (float)var3, 1, var4);
      }
   }

   private static void bj(float var0, float var1, float var2, int var3, float var4) {

      fs[fx] = var0;
      ft[fx] = var1;
      fu[fx] = var2;
      fw[fx] = (byte)var3;
      fv[fx] = var4;
      fx++;
   }

   private static void bk(
      float var0,
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      float var13,
      int var14,
      boolean var15,
      boolean var16
   ) {

      int var17 = fx;
      fx = 0;
      if (et) {
         if (var16) {
            int var52 = 0;

            for (int var53 = 1; var53 < var17; var53++) {
               var52 = fs[var53] > fs[var52] ? var53 : var52;
            }

            for (int var54 = 0; var54 < 48; var54++) {
               double var55 = (Math.PI * 2) * (double)var54 / 48.0;
               float var57 = (float)Math.cos(var55) * fs[var52];
               float var59 = (float)Math.sin(var55) * fs[var52];
               aq(
                  var0 + var3 * ft[var52] + var6 * var57 * var12 + var9 * var59 * var13,
                  var1 + var4 * ft[var52] + var7 * var57 * var12 + var10 * var59 * var13,
                  var2 + var5 * ft[var52] + var8 * var57 * var12 + var11 * var59 * var13
               );
            }

            as(true);
         }
      } else {
         int var18 = var15 ? var17 : var17 - 1;
         float[] var19 = new float[var17];
         float[] var20 = new float[var17];
         boolean[] var21 = new boolean[var17];

         for (int var22 = 0; var22 < var18; var22++) {
            int var23 = (var22 + 1) % var17;
            float var24 = fs[var23] - fs[var22];
            float var25 = ft[var23] - ft[var22];
            float var26 = (float)Math.sqrt((double)(var24 * var24 + var25 * var25));
            var21[var22] = var26 > 1.0E-6F;
            if (var21[var22]) {
               var19[var22] = var25 / var26;
               var20[var22] = -var24 / var26;
            }
         }

         float[] var56 = new float[var17];
         float[] var58 = new float[var17];
         float[] var60 = new float[var17];
         float[] var61 = new float[var17];

         for (int var62 = 0; var62 < var17; var62++) {
            int var27 = var15 ? (var62 + var17 - 1) % var17 : var62 - 1;
            int var28 = !var15 && var62 >= var17 - 1 ? -1 : var62;
            if (var27 < 0) {
               var27 = var28;
            }

            if (var28 < 0) {
               var28 = var27;
            }

            byte var29 = fw[var62];
            int var30 = var27;
            int var31 = var28;
            if (var29 == 2) {
               for (int var32 = 0; var32 < var17 && !var21[var30] && var15; var32++) {
                  var30 = (var30 + var17 - 1) % var17;
               }

               var31 = var30;
            } else if (var29 == 3) {
               for (int var71 = 0; var71 < var17 && !var21[var31] && var15; var71++) {
                  var31 = (var31 + 1) % var17;
               }

               var30 = var31;
            }

            float var72 = var19[var30];
            float var33 = var20[var30];
            float var34 = var19[var31];
            float var35 = var20[var31];
            if (var29 == 1) {
               float var36 = var72 + var34;
               float var37 = var33 + var35;
               float var38 = (float)Math.sqrt((double)(var36 * var36 + var37 * var37));
               if (var38 > 1.0E-6F) {
                  var72 = var34 = var36 / var38;
                  var33 = var35 = var37 / var38;
               }
            }

            var56[var62] = var72;
            var58[var62] = var33;
            var60[var62] = var34;
            var61[var62] = var35;
         }

         float[] var63 = new float[var14 + 1];
         float[] var64 = new float[var14 + 1];

         for (int var65 = 0; var65 <= var14; var65++) {
            double var67 = (Math.PI * 2) * (double)(var65 % var14) / (double)var14;
            var63[var65] = (float)Math.cos(var67);
            var64[var65] = (float)Math.sin(var67);
         }

         for (int var66 = 0; var66 < var14; var66++) {
            for (int var68 = 0; var68 < var18; var68++) {
               int var69 = (var68 + 1) % var17;

               for (int var70 = 0; var70 < 4; var70++) {
                  int var73 = var70 != 0 && var70 != 3 ? var66 + 1 : var66;
                  int var74 = var70 != 0 && var70 != 1 ? var69 : var68;
                  float var75 = var63[var73];
                  float var76 = var64[var73];
                  float var77 = var6 * var75 * var12 + var9 * var76 * var13;
                  float var78 = var7 * var75 * var12 + var10 * var76 * var13;
                  float var79 = var8 * var75 * var12 + var11 * var76 * var13;
                  float var39 = var6 * var75 / var12 + var9 * var76 / var13;
                  float var40 = var7 * var75 / var12 + var10 * var76 / var13;
                  float var41 = var8 * var75 / var12 + var11 * var76 / var13;
                  float var42 = (float)Math.sqrt((double)(var39 * var39 + var40 * var40 + var41 * var41));
                  var39 /= var42;
                  var40 /= var42;
                  var41 /= var42;
                  float var43 = var74 == var68 ? var60[var74] : var56[var74];
                  float var44 = var74 == var68 ? var61[var74] : var58[var74];
                  float var45 = var39 * var43 + var3 * var44;
                  float var46 = var40 * var43 + var4 * var44;
                  float var47 = var41 * var43 + var5 * var44;
                  float var48 = -var6 * var76 * var12 + var9 * var75 * var13;
                  float var49 = -var7 * var76 * var12 + var10 * var75 * var13;
                  float var50 = -var8 * var76 * var12 + var11 * var75 * var13;
                  float var51 = (float)Math.sqrt((double)(var48 * var48 + var49 * var49 + var50 * var50));
                  ax(
                     var70,
                     var0 + var3 * ft[var74] + var77 * fs[var74],
                     var1 + var4 * ft[var74] + var78 * fs[var74],
                     var2 + var5 * ft[var74] + var79 * fs[var74],
                     var45,
                     var46,
                     var47,
                     0.2F * (1.0F - Math.abs(2.0F * (float)var73 / (float)var14 - 1.0F)),
                     fu[var74],
                     var48 / var51,
                     var49 / var51,
                     var50 / var51,
                     fv[var74]
                  );
               }

               ay();
            }
         }
      }
   }

   private static void bl(float var0, float var1, float var2, float var3, float var4, float var5, int var6) {

      fx = 0;
      bj(var3, -var4 + var5, 0.0F, 3, 1.0F);
      bj(var3, var4 - var5, 0.2F, 2, 1.0F);
      bj(var3 - var5, var4, 0.25F, 3, 1.0F);
      bj(var2 + var5, var4, 0.45F, 2, 0.95F);
      bj(var2, var4 - var5, 0.5F, 3, 0.85F);
      bj(var2, -var4 + var5, 0.7F, 2, 0.85F);
      bj(var2 + var5, -var4, 0.75F, 3, 0.95F);
      bj(var3 - var5, -var4, 0.95F, 2, 1.0F);
      bj(var3, -var4 + var5, 1.0F, 3, 1.0F);
      bk(var0, var1, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, var6, true, true);
   }

   private static void bm(float var0, float var1, float var2, float var3, int var4) {

      for (byte var5 = -1; var5 <= 1; var5 += 2) {
         fx = 0;
         bj(var3, var2 - 0.03F, 0.0F, 0, 0.7F);
         bj(var3 * 0.9F, var2 + 0.03F, 0.5F, 0, 1.0F);
         bj(0.0F, var2 + 0.055F, 1.0F, 3, 1.0F);
         bk(var0, var1, 0.0F, 0.0F, 0.0F, (float)var5, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, var4, false, false);
      }
   }

   private static float bn(float var0) {

      var0 = var0 < 0.0F ? 0.0F : (var0 > 1.0F ? 1.0F : var0);
      return var0 * var0 * (3.0F - 2.0F * var0);
   }

   private static void bo() {

      ew = 1;
      ex = 0;
      fq = 0;
      float[] var0 = new float[]{
         -0.62F,
         -0.52F,
         -0.3F,
         0.0F,
         0.45F,
         0.95F,
         1.15F,
         1.32F,
         1.45F,
         1.6F,
         1.78F,
         2.7F,
         3.8F,
         4.9F,
         5.7F,
         6.3F,
         6.9F,
         7.45F,
         7.95F,
         8.4F,
         8.8F,
         9.12F,
         9.38F,
         9.54F,
         9.64F
      };
      int var1 = var0.length;

      for (int var2 = 0; var2 < var1; var2++) {
         if (!et || var2 % 2 != 1 || var2 >= var1 - 1) {
            float var3 = var0[var2];
            float var6 = 0.16F;
            float var4;
            float var5;
            if (var3 < 0.45F) {
               float var7 = Math.min(1.0F, (var3 + 0.62F) / 0.5F);
               var4 = 0.62F + 0.33F * (float)Math.sqrt((double)var7);
               var5 = -var4;
            } else {
               var4 = 0.9F;
               if (var3 > 5.9F) {
                  var4 = 0.9F - 0.66F * (float)Math.pow((double)((var3 - 5.9F) / 3.74F), 1.35);
               }

               var5 = -0.88F;
               if (var3 > 0.95F && var3 < 1.45F) {
                  var5 += 0.08F * (float)Math.sin((double)((var3 - 0.95F) / 0.5F) * Math.PI);
               }

               if (var3 > 5.2F) {
                  var5 = -0.88F + 1.12F * (float)Math.pow((double)((var3 - 5.2F) / 4.44F), 2.1);
               }

               if (var3 > 5.6F) {
                  var6 = 0.16F * (1.0F - 0.8F * (float)Math.pow((double)((var3 - 5.6F) / 4.04F), 1.4));
               }
            }

            float var26 = var3 < 1.45F ? 0.0F : 0.48F * bn((var3 - 1.45F) / 0.33F);
            float var8 = 0.0F;
            float var9 = var6;
            if (var3 > 6.3F) {
               float var10 = (var3 - 6.3F) / 3.34F;
               var8 = (var4 - var5) * 0.3F * var10;
               var9 = var6 * (1.0F - 0.75F * var10);
            }

            if (var2 == var1 - 1) {
               var5 = 0.24F;
               var4 = 0.24F;
               var9 = 0.012F;
               var6 = 0.012F;
               var8 = 0.0F;
            }

            ba(var3, 0.0F);
            bg(var4, var5, var6, var26, var8, var9, 0.06F, 0.028F, 0.0F, 0.0F, 0.0F, var3 < 0.5F ? 0.7F : 1.0F);
         }
      }

      eu = false;
      bd(true, false, 0.0F, 1.0F);
      eu = true;

      for (int var21 = 0; var21 < 2; var21++) {
         ew = (byte)(var21 == 0 ? 0 : 2);
         float var22 = var21 == 0 ? 0.6F : -0.6F;
         float var23 = var21 == 0 ? 1.0F : -1.0F;
         float var24 = 0.575F;
         float var25 = 0.42F;
         if (et) {
            au(-12.25F, 0.42F, var22, var24);
         } else {
            ex = 1;
            fq = 0;
            float[] var27 = new float[]{-12.25F, -12.2F, -12.06F, -11.85F, -11.6F, -11.45F};

            for (float var11 : var27) {
               float var12 = Math.min(1.0F, (var11 + 12.25F) / 0.6F);
               float var13 = var24 * (float)Math.sqrt((double)(1.0F - (1.0F - var12) * (1.0F - var12)));
               var13 = Math.max(var13, 0.12F);
               ba(var11, var22);
               bh(var13, -var13, 0.0F, var25, 0.09F, 1.0F);
            }

            bd(true, true, 0.0F, 0.08F);
            ex = 7;
            fq = 0;
            float[] var29 = new float[]{-11.45F, -0.155F, 0.06F, 0.22F, 0.33F, 0.4F, 0.42F};

            for (float var35 : var29) {
               float var37 = var35 > -0.155F ? (var35 + 0.155F) / 0.575F : 0.0F;
               float var14 = var24 * (float)Math.sqrt((double)Math.max(0.0F, 1.0F - var37 * var37));
               float var15 = 0.11F;
               float var16 = Math.min(0.1F, var14 * 0.4F);
               float var17 = Math.min(0.07F, var14 * 0.3F);
               float var18 = 0.5F - var14 / (2.0F * var24);
               float var19 = 0.5F + var14 / (2.0F * var24);
               float var20 = 0.5F + (var14 - var16) / (2.0F * var24);
               ba(var35, var22);
               bb(var23 * var14, -var25 + var17, var19, 3, 1.0F);
               bb(var23 * var14, var25 - var17, var19, 2, 1.0F);
               bb(var23 * (var14 - var17), var25, var19, 3, 1.0F);
               bb(-var23 * var14, var25, var18, 0, 1.0F);
               bb(-var23 * var14, var25 - var15, var18, 0, 0.8F);
               bb(var23 * (var14 - var16), var25 - var15, var20, 0, 0.45F);
               bb(var23 * (var14 - var16), -var25 + var15, var20, 0, 0.45F);
               bb(-var23 * var14, -var25 + var15, var18, 0, 0.8F);
               bb(-var23 * var14, -var25, var18, 0, 1.0F);
               bb(var23 * (var14 - var17), -var25, var19, 2, 1.0F);
            }

            bd(false, false, 0.06314128F, 0.9368587F);
            ex = 4;
            bm(0.0F, var22, var25 + 0.01F, 0.27F, 9);
            bm(-11.78F, var22, var25, 0.16F, 7);
         }
      }
   }

   private static void bp() {

      ew = 0;
      ex = 0;
      fq = 0;
      float var0 = 8.4F;
      float var1 = 0.1F;
      float var2 = 0.0F;
      int var3 = et ? 12 : 17;
      if (!et) {
         ba(-0.35F, 0.0F);
         bg(0.92F, -1.18F, 0.19F, 0.0F, 0.0F, 0.19F, 0.055F, 0.026F, 0.0F, 0.0F, 0.0F, 0.6F);
      }

      for (int var4 = 0; var4 <= var3; var4++) {
         float var5 = (float)var4 / (float)var3;
         float var6 = 0.92F * (1.0F - (float)Math.pow((double)var5, 1.7));
         float var7 = -1.18F * (1.0F - (float)Math.pow((double)var5, 1.12));
         float var8 = 0.19F * (1.0F - 0.82F * (float)Math.pow((double)var5, 1.5));
         float var9 = 0.0F;
         float var10 = var8;
         if (var5 > 0.6F) {
            float var11 = (var5 - 0.6F) / 0.4F;
            var9 = (var6 - var7) * 0.32F * var11;
            var10 = var8 * (1.0F - 0.7F * var11);
         }

         if (var4 == var3) {
            var7 = 0.0F;
            var6 = 0.0F;
            var10 = 0.012F;
            var8 = 0.012F;
            var9 = 0.0F;
         }

         ba(var1, var2);
         bg(var6, var7, var8, var4 == 0 ? 0.0F : 0.56F, var9, var10, 0.055F, 0.026F, 0.0F, 0.0F, 0.0F, var4 == 0 ? 0.8F : 1.0F);
         double var30 = -Math.toRadians(98.0) * Math.pow((double)var5 + 0.5 / (double)var3, 1.25);
         var1 += (float)Math.cos(var30) * var0 / (float)var3;
         var2 += (float)Math.sin(var30) * var0 / (float)var3;
      }

      eu = false;
      bd(false, false, 0.0F, 1.0F);
      eu = true;
      ex = 1;
      fq = 0;
      float[] var14 = new float[]{0.0F, 0.025F, 0.06F, 0.1F, 0.14F, 0.2F, 0.3F, 0.45F, 0.6F, 0.75F, 0.9F, 1.0F};

      for (int var15 = 0; var15 < var14.length; var15++) {
         float var17 = var14[var15];
         float var19 = 0.4F - 8.9F * var17;
         float var21 = -0.55F * var17 * var17;
         float var23 = 0.86F - 0.03F * (float)Math.sin((double)var17 * Math.PI * 3.0);
         float var26 = -0.99F + 0.12F * (float)Math.sin((double)var17 * Math.PI * 2.0);
         float var31 = (var17 - 0.115F) / 0.06F;
         var26 -= 0.42F * (float)Math.exp((double)(-var31 * var31));
         float var12 = 1.0F - bn((var17 - 0.07F) / 0.05F);
         var23 += 0.12F * var12;
         var26 -= 0.28F * var12;
         float var13 = 0.13F + 0.13F * var12;
         if (var15 == 0) {
            var23 -= 0.06F;
            var26 += 0.06F;
            var13 -= 0.05F;
         }

         ba(var19, var21);
         bh(var23, var26, 0.0F, var13, 0.06F, 1.0F);
      }

      eu = false;
      bd(!et, false, 0.0F, 1.0F);
      eu = true;
      if (!et) {
         ex = 2;
         fq = 0;

         for (int var16 = 0; var16 <= 8; var16++) {
            float var18 = (float)var16 / 8.0F;
            float var20 = -0.9F - 7.0F * var18;
            float var22 = (0.35F - var20) / 8.85F;
            float var25 = -0.55F * var22 * var22;
            float var29 = 0.84F - 0.03F * (float)Math.sin((double)var22 * Math.PI * 3.0);
            float var32 = -0.97F + 0.12F * (float)Math.sin((double)var22 * Math.PI * 2.0);
            float var33 = Math.min(1.0F, Math.min(var18, 1.0F - var18) * 9.0F);
            ba(var20, var25);
            bh(var29, var32, 0.0F, 0.3F + 0.22F * (float)Math.sqrt((double)var33), 0.17F, 1.0F);
         }

         bd(true, true, 0.0F, 1.0F);
         ex = 4;
         bm(-3.0F, -0.15F, 0.52F, 0.17F, 7);
         bm(-6.0F, -0.42F, 0.52F, 0.17F, 7);
      }

      ex = 1;
      bl(-9.45F, -0.35F, 0.9F, 1.55F, 0.22F, 0.08F, 17);
   }

   private static void bq() {

      ew = 0;
      ex = 0;
      fq = 0;
      int var0 = et ? 10 : 15;

      for (int var1 = 0; var1 <= var0; var1++) {
         float var2 = (float)var1 / (float)var0;
         var2 *= 1.15F - 0.15F * var2;
         float var3 = 9.4F * var2;
         float var4 = var3 < 3.2F
            ? 0.55F + 0.72F * (float)Math.sin((Math.PI / 2) * (double)var3 / 3.2F)
            : 1.27F * (1.0F - (float)Math.pow((double)((var3 - 3.2F) / 6.2F), 1.2));
         float var5 = 0.3F * (1.0F - 0.85F * var2);
         if (var1 == var0) {
            var4 = 0.0F;
            var5 = 0.012F;
         }

         float var6 = Math.min(0.07F, var4 * 0.3F);
         float var7 = Math.min(0.035F, var5 * 0.5F);
         float var8 = var4 > 1.0E-4F ? 1.0F / var4 : 0.0F;
         ba(var3, 0.0F);
         bb(var4, 0.0F, 1.0F, 0, 1.0F);
         bb(var4 - var6, var7, 1.0F - var6 * var8, 0, 1.0F);
         bb(0.0F, var5, 0.0F, 0, 1.0F);
         bb(-var4 + var6, var7, 1.0F - var6 * var8, 0, 1.0F);
         bb(-var4, 0.0F, 1.0F, 0, 1.0F);
         bb(-var4 + var6, -var7, 1.0F - var6 * var8, 0, 1.0F);
         bb(0.0F, -var5, 0.0F, 0, 1.0F);
         bb(var4 - var6, -var7, 1.0F - var6 * var8, 0, 1.0F);
      }

      eu = false;
      bd(false, false, 0.0F, 1.0F);
      eu = true;
      if (et) {
         av(-8.05F, 0.25F, -0.62F, 0.62F);
      } else {
         ex = 3;
         fq = 0;

         for (int var9 = 0; var9 <= 5; var9++) {
            float var13 = (float)var9 / 5.0F;
            float var16 = 0.47F + 0.04F * (float)Math.sin((double)var13 * Math.PI);
            ba(-7.5F + 7.25F * var13, 0.0F);
            bi(0.0F, var16 + 0.02F, var16, 12, 1.0F);
         }

         bd(false, false, 0.0F, 1.0F);
         ex = 1;

         for (int var10 = 0; var10 < 2; var10++) {
            fx = 0;
            bj(0.5F, -0.32F, 0.0F, 0, 0.8F);
            bj(0.62F, -0.24F, 0.3F, 1, 1.0F);
            bj(0.62F, 0.18F, 0.6F, 1, 1.0F);
            bj(0.5F, 0.28F, 0.8F, 1, 1.0F);
            bj(0.0F, 0.3F, 1.0F, 2, 1.0F);
            float var14 = var10 == 0 ? 1.0F : -1.0F;
            bk(var10 == 0 ? -0.05F : -7.75F, 0.0F, 0.0F, var14, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.9F, 10, false, false);
         }
      }

      ex = 1;
      fx = 0;

      for (int var11 = 0; var11 < 8; var11++) {
         double var15 = (Math.PI * 2) * (double)var11 / 8.0;
         bj(0.98F + 0.26F * (float)Math.cos(var15), 0.26F * (float)Math.sin(var15), (float)var11 / 8.0F, 1, var11 == 4 ? 0.85F : 1.0F);
      }

      bk(-9.15F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 16, true, true);
   }

   private static void br() {

      ew = 0;
      ex = 0;
      fq = 0;
      float[] var0 = new float[]{0.0F, 0.6F, 0.9F, 1.25F, 2.9F, 4.6F, 6.2F, 6.9F, 7.4F, 8.0F, 8.7F, 9.4F, 10.05F, 10.6F, 11.05F, 11.38F, 11.6F};
      int var1 = var0.length;

      for (int var2 = 0; var2 < var1; var2++) {
         if (!et || var2 % 2 != 1 || var2 >= var1 - 1) {
            float var3 = var0[var2];
            float var4 = 1.15F;
            float var5 = -1.2F;
            if (var3 > 7.6F) {
               var4 = 1.15F - 0.9F * (float)Math.pow((double)((var3 - 7.6F) / 4.0F), 1.25);
            }

            if (var3 > 6.6F) {
               var5 = -1.2F + 1.45F * (float)Math.pow((double)((var3 - 6.6F) / 5.0F), 2.0);
            }

            float var6 = 0.22F * (1.0F - 0.75F * (float)Math.pow((double)(var3 / 11.6F), 2.0));
            float var7 = var3 < 0.85F ? 0.0F : 0.42F * bn((var3 - 0.85F) / 0.4F);
            float var8 = 0.0F;
            float var9 = var6;
            if (var3 > 7.9F) {
               float var10 = (var3 - 7.9F) / 3.7F;
               var8 = (var4 - var5) * 0.3F * var10;
               var9 = var6 * (1.0F - 0.7F * var10);
            }

            float var29 = Math.min(bn((var3 - 0.9F) / 0.6F), bn((7.3F - var3) / 0.8F));
            float var11 = 0.07F * var29;
            float var12 = var4 - 0.2F;
            float var13 = var4 - 0.2F - 0.42F * var29;
            if (var2 == var1 - 1) {
               var5 = 0.25F;
               var4 = 0.25F;
               var9 = 0.012F;
               var6 = 0.012F;
               var8 = 0.0F;
            }

            ba(var3, 0.0F);
            bg(var4, var5, var6, var7, var8, var9, 0.065F, 0.03F, var12, var13, var11, var3 < 0.3F ? 0.75F : 1.0F);
         }
      }

      eu = false;
      bd(false, false, 0.0F, 1.0F);
      eu = true;
      ex = 1;
      fq = 0;
      float[] var14 = new float[]{-1.95F, -1.88F, -1.7F, 1.4F, 1.58F, 1.65F};

      for (int var15 = 0; var15 < var14.length; var15++) {
         float var18 = var15 != 0 && var15 != var14.length - 1 ? (var15 != 1 && var15 != var14.length - 2 ? 1.0F : 0.94F) : 0.78F;
         ba(-0.19F, var14[var15]);
         bh(0.31F * var18, -0.31F * var18, 0.0F, 0.42F * var18, 0.1F, 1.0F);
      }

      bd(true, true, 0.0F, 0.1F);
      fx = 0;

      for (int var16 = 0; var16 < 6; var16++) {
         double var19 = (Math.PI * 2) * (double)var16 / 6.0;
         bj(0.44F + 0.13F * (float)Math.cos(var19), 0.13F * (float)Math.sin(var19), (float)var16 / 6.0F, 1, 1.0F);
      }

      bk(-0.19F, 2.02F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 11, true, true);
      ex = 9;
      fq = 0;
      byte var17 = 8;
      ba(-10.5F, 0.0F);
      bi(-0.01F, 1.0F, 0.88F, 8, 0.9F);

      for (int var20 = 0; var20 < var17 * 2 + 1; var20++) {
         float var22 = ((float)var20 + 0.5F) / (float)(var17 * 2 + 1);
         float var24 = -10.3F + 9.7F * var22;
         float var26 = 0.07F * (float)Math.sin((double)var22 * Math.PI);
         boolean var27 = (var20 & 1) == 1;
         float var28 = var27 ? 0.95F : 1.0F;
         ba(var24, 0.0F);
         bi(-0.01F, (1.0F + var26) * var28, (0.88F + var26) * var28, 8, var27 ? 0.62F : 1.0F);
      }

      ba(-0.45F, 0.0F);
      bi(-0.01F, 1.0F, 0.88F, 8, 0.8F);
      ev = false;
      eu = false;
      bd(false, false, 0.0F, 1.0F);
      ev = true;
      eu = true;
      ex = 1;
      fq = 0;
      float[] var21 = new float[]{-11.45F, -11.4F, -11.28F, -10.4F};

      for (int var23 = 0; var23 < var21.length; var23++) {
         float var25 = var23 == 0 ? 0.8F : (var23 == 1 ? 0.95F : 1.0F);
         ba(var21[var23], 0.0F);
         bh(1.06F * var25, -1.08F * var25, 0.0F, 0.92F * var25, 0.26F, 1.0F);
      }

      ev = false;
      bd(true, false, 0.0F, 0.1F);
      ev = true;
      if (!et) {
         ex = 4;
         bm(-10.95F, 0.0F, 0.9F, 0.2F, 8);
      }
   }

   private static void bs() {

      ew = 0;
      ex = 0;
      fq = 0;
      float var0 = 10.2F;
      float var1 = 0.0F;
      float var2 = 0.0F;
      int var3 = et ? 10 : 17;

      for (int var4 = 0; var4 <= var3; var4++) {
         float var5 = (float)var4 / (float)var3;
         float var6 = 1.0F * (1.0F - (float)Math.pow((double)var5, 2.4));
         float var7 = -1.3F * (1.0F - (float)Math.pow((double)var5, 1.6));
         float var8 = 0.2F * (1.0F - 0.8F * (float)Math.pow((double)var5, 1.6));
         float var9 = 0.0F;
         float var10 = var8;
         if (var5 > 0.5F) {
            float var11 = (var5 - 0.5F) / 0.5F;
            var9 = (var6 - var7) * 0.34F * var11;
            var10 = var8 * (1.0F - 0.72F * var11);
         }

         if (var4 == var3) {
            var7 = 0.0F;
            var6 = 0.0F;
            var10 = 0.012F;
            var8 = 0.012F;
            var9 = 0.0F;
         }

         ba(var1, var2);
         bg(var6, var7, var8, 0.58F, var9, var10, 0.06F, 0.028F, 0.0F, 0.0F, 0.0F, var4 == 0 ? 0.75F : 1.0F);
         double var22 = -Math.toRadians(34.0) * Math.pow((double)var5, 1.6);
         var1 += (float)Math.cos(var22) * var0 / (float)var3;
         var2 += (float)Math.sin(var22) * var0 / (float)var3;
      }

      eu = false;
      bd(false, false, 0.0F, 1.0F);
      eu = true;
      ex = 1;
      fq = 0;
      float[] var13 = new float[]{-0.75F, -0.6F, 0.1F, 0.25F};

      for (int var14 = 0; var14 < var13.length; var14++) {
         float var16 = var14 != 0 && var14 != 3 ? 1.0F : 0.9F;
         ba(var13[var14], 0.0F);
         bh(1.02F, -1.95F + (1.0F - var16) * 2.0F, 0.0F, 0.5F * var16, 0.15F, 1.0F);
      }

      ev = false;
      bd(true, true, 0.0F, 0.1F);
      ev = true;

      for (int var15 = 0; var15 < 2 && (!et || var15 != 1); var15++) {
         ex = (byte)(var15 == 0 ? 1 : 2);
         fq = 0;

         for (int var17 = 0; var17 <= 8; var17++) {
            float var18 = (float)var17 / 8.0F;
            float var19 = -0.7F - 9.25F * var18;
            float var20 = -0.6F * var18 * var18;
            float var21 = 0.88F;
            float var23 = -0.95F + 0.1F * (float)Math.sin((double)var18 * Math.PI * 3.0);
            ba(var19, var20);
            if (var15 == 0) {
               bh(var21 + 0.02F, var23 - 0.02F, 0.0F, 0.14F, 0.05F, 1.0F);
            } else {
               float var12 = Math.min(1.0F, Math.min(var18, 1.0F - var18) * 9.0F);
               bh(var21, var23, 0.0F, 0.34F + 0.26F * (float)Math.sqrt((double)var12), 0.19F, 1.0F);
            }
         }

         eu = false;
         bd(var15 == 1, var15 == 1, 0.0F, 1.0F);
         eu = true;
      }

      if (!et) {
         ex = 4;
         bm(-3.4F, -0.05F, 0.6F, 0.17F, 7);
         bm(-7.0F, -0.3F, 0.6F, 0.17F, 7);
      }

      ex = 1;
      bl(-10.95F, -1.02F, 0.62F, 1.14F, 0.23F, 0.08F, 15);
   }

   private static void bt() {

      ew = 0;
      ex = 0;
      fq = 0;
      float var0 = 31.0F;
      float var1 = 0.0F;
      float var2 = 0.0F;
      int var3 = et ? 12 : 26;

      for (int var4 = 0; var4 <= var3; var4++) {
         float var5 = (float)var4 / (float)var3;
         float var6 = 0.55F - 0.12F * var5;
         float var7 = -1.0F + 0.25F * var5;
         float var8 = 0.3F - 0.13F * var5;
         float var9 = (var5 - 0.9F) / 0.1F;
         float var10 = var6 - (var6 - var7) * 0.31F;
         if (var9 > 0.0F) {
            var7 += (var6 - 0.05F - var7) * (float)Math.pow((double)var9, 1.6);
            var10 = var6 - (var6 - var7) * 0.31F * (1.0F - var9);
            var8 *= 1.0F - 0.85F * var9;
         }

         if (var4 == var3) {
            var7 = var6;
            var10 = var6;
            var8 = 0.012F;
         }

         float var11 = Math.max(1.0E-4F, var6 - var7);
         float var12 = 1.0F / var11;
         float var13 = var8 * 0.5F;
         float var14 = Math.min(0.07F, var11 * 0.08F);
         float var15 = (var10 + var7) * 0.5F;
         ba(var1, var2);
         bb(var6, 0.0F, 0.0F, 0, 1.0F);
         bb(var6 - var14, var13, var14 * var12, 0, 1.0F);
         bb(var10, var8, (var6 - var10) * var12, 0, 1.0F);
         bb(var15, var8 * 0.6F, (var6 - var15) * var12, 1, 1.0F);
         bb(var7, 0.0F, 1.0F, 0, 1.0F);
         bb(var15, -var8 * 0.6F, (var6 - var15) * var12, 1, 1.0F);
         bb(var10, -var8, (var6 - var10) * var12, 0, 1.0F);
         bb(var6 - var14, -var13, var14 * var12, 0, 1.0F);
         double var16 = Math.toRadians(8.0) * (double)var5;
         var1 += (float)Math.cos(var16) * var0 / (float)var3;
         var2 += (float)Math.sin(var16) * var0 / (float)var3;
      }

      eu = false;
      bd(false, false, 0.0F, 1.0F);
      eu = true;
      if (et) {
         av(-0.15F, 2.1F, -1.12F, 0.68F);
         fx = 0;
         bj(1.0F, 0.0F, 0.0F, 0, 1.0F);
         bk(-0.45F, -0.22F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 3.3F, 2.8F, 24, false, true);
         fq = 0;
         ba(-13.35F, -0.15F);
         bi(0.0F, 1.12F, 0.78F, 10, 1.0F);
         ba(-0.75F, -0.15F);
         bi(0.0F, 1.12F, 0.78F, 10, 1.0F);
         eu = false;
         bd(false, false, 0.0F, 1.0F);
         eu = true;
      } else {
         ex = 5;
         fq = 0;
         ba(-0.15F, 0.0F);
         bh(0.68F, -1.12F, 0.0F, 0.42F, 0.1F, 0.85F);
         ba(1.9F, 0.0F);
         bh(0.66F, -1.08F, 0.0F, 0.38F, 0.1F, 1.0F);
         ba(2.1F, 0.0F);
         bh(0.62F, -1.04F, 0.0F, 0.34F, 0.08F, 1.0F);
         bd(false, true, 0.0F, 1.0F);
         ex = 4;
         fx = 0;
         bj(0.0F, -0.3F, 0.0F, 3, 0.9F);
         bj(0.9F, -0.3F, 0.4F, 2, 1.0F);
         bj(1.0F, -0.17F, 0.5F, 3, 1.0F);
         bj(1.0F, 0.17F, 0.6F, 2, 1.0F);
         bj(0.9F, 0.3F, 0.7F, 3, 1.0F);
         bj(0.0F, 0.3F, 1.0F, 2, 0.9F);
         bk(-0.45F, -0.22F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 3.3F, 2.8F, 18, false, true);
         fq = 0;
         ba(-1.65F, -0.15F);
         bi(0.0F, 1.1F, 0.76F, 10, 0.8F);
         ba(-0.78F, -0.15F);
         bi(0.0F, 1.12F, 0.78F, 10, 1.0F);
         ba(-0.75F, -0.15F);
         bi(0.0F, 1.0F, 0.68F, 10, 1.0F);
         eu = false;
         bd(false, true, 0.0F, 0.1F);
         eu = true;
         ex = 8;
         fq = 0;

         for (int var18 = 0; var18 <= 5; var18++) {
            float var20 = (float)var18 / 5.0F;
            float var22 = 1.0F - 0.05F * (float)Math.sin((double)var20 * Math.PI) + 0.03F * var20;
            ba(-12.45F + 10.85F * var20, -0.15F);
            bi(0.0F, 1.06F * var22, 0.75F * var22, 12, 1.0F);
         }

         ev = false;
         eu = false;
         bd(false, false, 0.0F, 1.0F);
         ev = true;
         eu = true;
         ex = 4;
         fq = 0;
         float[] var19 = new float[]{-13.35F, -13.3F, -13.15F, -12.4F};

         for (int var21 = 0; var21 < var19.length; var21++) {
            float var23 = var21 == 0 ? 0.75F : (var21 == 1 ? 0.93F : 1.0F);
            ba(var19[var21], -0.15F);
            bi(0.0F, 1.1F * var23, 0.78F * var23, 10, 1.0F);
         }

         ev = false;
         bd(true, false, 0.0F, 0.1F);
         ev = true;
      }
   }

   public static synchronized void bu() {

      if (!READY) {
         int var0 = 0;
         int var1 = 0;
         int var2 = 0;

         for (int var3 = 1; var3 < 7; var3++) {
            fd = 0.006F / K_SC[var3];

            for (int var4 = 0; var4 < 2; var4++) {
               aw(var4 == 1);
               switch (var3) {
                  case 1:
                     bo();
                     break;
                  case 2:
                     bp();
                     break;
                  case 3:
                     bq();
                     break;
                  case 4:
                     br();
                     break;
                  case 5:
                     bs();
                     break;
                  default:
                     bt();
               }

               az(var3);
            }

            var0 = Math.max(var0, NC[var3]);
            var1 = Math.max(var1, NU[var3]);
            var2 = Math.max(var2, SPN[var3]);
         }

         UP[0] = UN[0] = UG[0] = UT[0] = UO[0] = SPP[0] = new float[0];
         UA[0] = UM[0] = SPA[0] = new byte[0];
         CI[0] = HWQ[0] = new int[0];
         OP = new float[var0 * 3];
         OT = new float[var0 * 2];
         OC = new int[var0];
         SP = new float[var0 * 3];
         ST = new float[var0 * 2];
         SC = new int[var0];
         ec = new float[var1 * 3];
         ed = new float[var1 * 2];
         ee = new float[var1 * 2];
         ef = new int[var1];
         eg = new int[var1];
         eh = new boolean[var1];
         GP = new float[var2 * 4 * 3];
         GT = new float[var2 * 4 * 2];
         GC = new int[var2 * 4];
         ep = null;
         eo = null;
         en = null;
         em = null;
         el = null;
         er = null;
         eq = null;
         READY = true;
      }
   }

   static {
      float[] var0 = ARM0;
      a(var0);
      tr(var0, 0.08000004F, -0.08000004F, 5.9604645E-8F);
      rot(var0, 1, 45.0F);
      tr(var0, -1.0F, 3.6F, 3.5F);
      rot(var0, 2, 120.0F);
      rot(var0, 0, 200.0F);
      rot(var0, 1, -135.0F);
      tr(var0, 5.6F, 0.0F, 0.0F);
      tr(var0, -0.3125F, 0.125F, 0.0F);
      rot(var0, 2, (float)Math.toDegrees(0.1F));
      tr(var0, -0.0625F, 0.6125F, 0.0F);
      var0 = new float[0];
      ANIM[0] = new float[][]{
         {0.0F, 0.0F, 0.12F, 0.012F, 0.55F, -0.205F, 0.75F, -0.195F, 2.5F, -0.19F, 3.05F, 0.008F, 3.4F, 0.0F},
         {0.0F, 0.0F, 0.12F, -0.015F, 0.55F, 0.105F, 0.7F, 0.098F, 2.5F, 0.095F, 3.05F, -0.008F, 3.4F, 0.0F},
         {0.0F, 0.0F, 0.55F, 0.125F, 2.5F, 0.115F, 3.1F, 0.0F},
         {0.0F, 0.0F, 0.15F, -3.0F, 0.55F, 7.0F, 1.3F, 4.0F, 1.95F, -24.0F, 2.5F, -16.0F, 3.05F, 2.0F, 3.4F, 0.0F},
         {0.0F, 0.0F, 0.15F, 6.0F, 0.6F, -26.0F, 1.55F, 150.0F, 2.1F, 168.0F, 2.65F, 55.0F, 3.1F, -4.0F, 3.4F, 0.0F},
         {0.0F, 0.0F, 0.55F, -9.0F, 1.5F, -14.0F, 2.5F, -6.0F, 3.4F, 0.0F}
      };
      ANIM[1] = new float[0][];
      ANIM[2] = new float[][]{
         {
               0.0F,
               0.0F,
               0.14F,
               0.008F,
               0.55F,
               -0.212F,
               1.6F,
               -0.216F,
               1.72F,
               -0.215F,
               2.05F,
               -0.221F,
               2.45F,
               -0.212F,
               3.0F,
               -0.218F,
               3.6F,
               -0.19F,
               4.05F,
               0.006F,
               4.3F,
               0.0F
         },
         {
               0.0F,
               0.0F,
               0.14F,
               -0.012F,
               0.55F,
               0.137F,
               1.6F,
               0.141F,
               1.72F,
               0.138F,
               2.05F,
               0.158F,
               2.45F,
               0.142F,
               3.0F,
               0.14F,
               3.6F,
               0.12F,
               4.05F,
               -0.006F,
               4.3F,
               0.0F
         },
         {0.0F, 0.0F, 0.14F, -0.005F, 0.55F, 0.1F, 3.6F, 0.09F, 4.05F, -0.004F, 4.3F, 0.0F},
         {0.0F, 0.0F, 0.14F, -2.0F, 0.55F, 11.0F, 2.5F, 12.0F, 3.6F, 10.0F, 4.3F, 0.0F},
         {0.0F, 0.0F, 0.55F, 0.4F, 2.5F, 0.4F, 2.95F, 8.0F, 3.4F, 6.0F, 3.9F, 1.0F, 4.3F, 0.0F},
         {0.0F, 0.0F, 0.14F, 1.0F, 0.55F, -9.2F, 2.5F, -10.0F, 3.6F, -8.0F, 4.3F, 0.0F},
         {
               0.0F,
               0.0F,
               0.14F,
               3.0F,
               0.55F,
               -21.0F,
               0.75F,
               -21.0F,
               0.82F,
               -25.0F,
               1.0F,
               -18.0F,
               1.32F,
               -24.0F,
               1.52F,
               -18.0F,
               1.7F,
               -21.0F,
               1.8F,
               -25.0F,
               2.2F,
               -13.0F,
               2.32F,
               -18.0F,
               2.45F,
               -21.0F,
               3.0F,
               -26.0F,
               3.6F,
               -19.0F,
               4.3F,
               0.0F
         },
         {0.0F, 0.0F, 0.55F, -6.8F, 2.5F, -6.8F, 3.0F, -1.0F, 3.6F, -5.0F, 4.3F, 0.0F},
         {
               0.0F,
               0.0F,
               0.55F,
               -10.0F,
               0.75F,
               -3.0F,
               1.0F,
               -15.0F,
               1.25F,
               -4.0F,
               1.5F,
               -13.0F,
               1.7F,
               -10.0F,
               2.55F,
               -10.0F,
               2.95F,
               175.0F,
               3.05F,
               167.0F,
               3.15F,
               170.0F,
               3.45F,
               170.0F,
               3.85F,
               352.0F,
               3.97F,
               347.0F,
               4.1F,
               350.0F,
               4.3F,
               360.0F
         },
         {0.0F, 0.0F, 1.72F, 0.0F, 1.8F, 8.0F, 2.25F, -366.0F, 2.35F, -357.0F, 2.45F, -360.0F, 4.3F, -360.0F},
         {0.0F, 0.0F, 0.6F, 0.0F, 0.82F, 184.0F, 0.9F, 177.0F, 0.98F, 180.0F, 1.1F, 180.0F, 1.32F, 364.0F, 1.4F, 358.0F, 1.48F, 360.0F, 4.3F, 360.0F},
         {
               0.0F,
               0.0F,
               0.6F,
               0.0F,
               0.82F,
               180.0F,
               1.0F,
               364.0F,
               1.07F,
               358.0F,
               1.14F,
               360.0F,
               1.32F,
               540.0F,
               1.52F,
               723.0F,
               1.6F,
               719.0F,
               1.68F,
               720.0F,
               4.3F,
               720.0F
         },
         {0.0F, 0.0F, 1.72F, 0.0F, 1.8F, -0.5F, 2.02F, 6.5F, 2.25F, 0.4F, 2.32F, -0.3F, 2.45F, 0.0F, 4.3F, 0.0F},
         {0.0F, 0.0F, 0.14F, -3.0F, 0.55F, 5.0F, 2.5F, 4.0F, 3.4F, 3.0F, 3.95F, -2.0F, 4.3F, 0.0F}
      };
      ANIM[3] = new float[][]{
         {0.0F, 0.03F, 0.6F, -0.004F, 1.0F, 0.0F},
         {0.0F, -0.17F, 0.5F, 0.012F, 0.75F, -0.004F, 1.0F, 0.0F},
         {0.0F, 0.03F, 1.0F, 0.0F},
         {0.0F, -24.0F, 0.5F, 4.0F, 0.75F, -1.5F, 1.0F, 0.0F},
         var0,
         {0.0F, 14.0F, 1.0F, 0.0F},
         {0.0F, 16.0F, 0.55F, -6.0F, 1.0F, 0.0F},
         var0,
         {0.0F, -20.0F, 0.55F, 4.0F, 1.0F, 0.0F},
         var0,
         {0.0F, 180.0F, 0.2F, 180.0F, 0.44F, 364.0F, 0.52F, 358.0F, 0.62F, 360.0F, 1.0F, 360.0F},
         {0.0F, 360.0F, 0.2F, 360.0F, 0.44F, 540.0F, 0.66F, 724.0F, 0.74F, 719.0F, 0.84F, 720.0F, 1.0F, 720.0F},
         var0,
         {0.0F, -10.0F, 0.7F, 2.0F, 1.0F, 0.0F}
      };
      ANIM[4] = new float[][]{
         {0.0F, 0.0F, 0.12F, 0.008F, 0.5F, -0.212F, 0.72F, -0.246F, 1.88F, -0.249F, 2.1F, -0.212F, 2.9F, -0.206F, 3.6F, 0.005F, 3.9F, 0.0F},
         {0.0F, 0.0F, 0.12F, -0.012F, 0.5F, 0.142F, 0.72F, 0.202F, 1.3F, 0.21F, 1.88F, 0.204F, 2.1F, 0.142F, 2.9F, 0.138F, 3.6F, -0.005F, 3.9F, 0.0F},
         {0.0F, 0.0F, 0.5F, 0.1F, 2.9F, 0.09F, 3.6F, -0.004F, 3.9F, 0.0F},
         {0.0F, 0.0F, 0.12F, -2.0F, 0.5F, 10.5F, 0.7F, 11.5F, 1.9F, 11.5F, 2.1F, 10.5F, 2.9F, 11.0F, 3.9F, 0.0F},
         {0.0F, 0.0F, 0.5F, -4.6F, 0.7F, -5.3F, 1.9F, -5.3F, 2.1F, -4.6F, 2.6F, 0.0F, 3.2F, -2.0F, 3.9F, 0.0F},
         {0.0F, 0.0F, 0.12F, 1.0F, 0.5F, -8.8F, 0.7F, -9.7F, 1.9F, -9.7F, 2.1F, -8.8F, 2.9F, -8.5F, 3.9F, 0.0F},
         {0.0F, 0.0F, 0.12F, 3.0F, 0.5F, -1.0F, 0.7F, -2.6F, 1.9F, -2.6F, 2.1F, -1.0F, 2.6F, -6.0F, 3.0F, -3.0F, 3.6F, -1.0F, 3.9F, 0.0F},
         {0.0F, 0.0F, 0.45F, -24.0F, 0.68F, 5.6F, 1.9F, 5.6F, 2.12F, -28.6F, 2.9F, -27.0F, 3.6F, -4.0F, 3.9F, 0.0F},
         {0.0F, 0.0F, 0.5F, -3.9F, 0.7F, 2.9F, 1.9F, 2.9F, 2.1F, -3.9F, 2.6F, -46.0F, 2.75F, -49.0F, 2.95F, -43.0F, 3.5F, -4.0F, 3.9F, 0.0F},
         {0.0F, 0.0F, 0.62F, 0.0F, 0.72F, 10.0F, 0.95F, -110.0F, 1.4F, -560.0F, 1.7F, -724.0F, 1.8F, -717.0F, 1.92F, -720.0F, 3.9F, -720.0F},
         var0,
         var0,
         {0.0F, 0.0F, 0.3F, 0.0F, 0.55F, 4.5F, 1.75F, 4.5F, 1.98F, 0.0F, 3.9F, 0.0F},
         {0.0F, 0.0F, 0.12F, -3.0F, 0.5F, 4.0F, 1.9F, 3.0F, 2.6F, 5.0F, 3.5F, -2.0F, 3.9F, 0.0F},
         {0.0F, 0.0F, 0.4F, 0.0F, 0.64F, 1.0F, 1.88F, 1.0F, 2.12F, 0.0F, 3.9F, 0.0F}
      };
      ANIM[5] = new float[][]{
         {0.0F, 0.03F, 0.9F, 0.0F},
         {0.0F, -0.15F, 0.55F, 0.012F, 0.75F, -0.003F, 0.9F, 0.0F},
         var0,
         {0.0F, -20.0F, 0.55F, 3.0F, 0.9F, 0.0F},
         var0,
         {0.0F, 10.0F, 0.9F, 0.0F},
         {0.0F, 0.4F, 0.6F, 0.4F, 0.84F, 0.0F, 0.9F, 0.0F},
         {0.0F, 5.5F, 0.6F, 5.5F, 0.84F, 0.0F, 0.9F, 0.0F},
         {0.0F, 3.2F, 0.6F, 3.2F, 0.84F, 0.0F, 0.9F, 0.0F},
         {0.0F, 0.0F, 0.08F, 15.0F, 0.55F, -366.0F, 0.68F, -358.0F, 0.8F, -360.0F, 0.9F, -360.0F},
         var0,
         var0,
         {0.0F, 4.5F, 0.5F, 4.5F, 0.72F, 0.0F, 0.9F, 0.0F},
         {0.0F, -8.0F, 0.9F, 0.0F},
         {0.0F, 1.0F, 0.6F, 1.0F, 0.84F, 0.0F, 0.9F, 0.0F}
      };
      ANIM[6] = new float[][]{
         {0.0F, 0.0F, 0.12F, 0.008F, 0.45F, -0.212F, 0.62F, -0.235F, 1.78F, -0.238F, 1.95F, -0.212F, 2.8F, -0.205F, 3.5F, 0.005F, 3.8F, 0.0F},
         {0.0F, 0.0F, 0.12F, -0.012F, 0.45F, 0.137F, 0.62F, 0.19F, 1.2F, 0.198F, 1.78F, 0.192F, 1.95F, 0.137F, 2.8F, 0.13F, 3.5F, -0.005F, 3.8F, 0.0F},
         {0.0F, 0.0F, 0.45F, 0.1F, 2.8F, 0.09F, 3.5F, -0.004F, 3.8F, 0.0F},
         {0.0F, 0.0F, 0.12F, -2.0F, 0.45F, 11.0F, 2.8F, 12.0F, 3.8F, 0.0F},
         {0.0F, 0.0F, 0.45F, 0.4F, 1.95F, 0.4F, 2.4F, 6.0F, 2.9F, 3.0F, 3.8F, 0.0F},
         {0.0F, 0.0F, 0.12F, 1.0F, 0.45F, -9.2F, 2.8F, -9.0F, 3.8F, 0.0F},
         {0.0F, 0.0F, 0.12F, 3.0F, 0.4F, -21.0F, 0.62F, 14.9F, 1.78F, 14.9F, 1.98F, -21.0F, 2.3F, -25.0F, 2.7F, -19.0F, 3.4F, -10.0F, 3.8F, 0.0F},
         {0.0F, 0.0F, 0.4F, -6.8F, 0.62F, -37.1F, 1.78F, -37.1F, 1.98F, -6.8F, 2.8F, -6.0F, 3.4F, -2.0F, 3.8F, 0.0F},
         {
               0.0F,
               0.0F,
               0.2F,
               -6.0F,
               0.62F,
               120.9F,
               1.78F,
               120.9F,
               2.22F,
               176.0F,
               2.32F,
               168.0F,
               2.45F,
               170.0F,
               2.6F,
               170.0F,
               3.0F,
               352.0F,
               3.1F,
               348.0F,
               3.25F,
               350.0F,
               3.8F,
               360.0F
         },
         {0.0F, 0.0F, 0.55F, 0.0F, 0.65F, -12.0F, 0.9F, 120.0F, 1.35F, 610.0F, 1.62F, 724.0F, 1.72F, 717.0F, 1.82F, 720.0F, 3.8F, 720.0F},
         var0,
         var0,
         {0.0F, 0.0F, 0.28F, 0.0F, 0.52F, 3.4F, 1.65F, 3.4F, 1.9F, 0.0F, 3.8F, 0.0F},
         {0.0F, 0.0F, 0.12F, -3.0F, 0.45F, 5.0F, 1.8F, 3.0F, 2.8F, 4.0F, 3.5F, -2.0F, 3.8F, 0.0F},
         {0.0F, 0.0F, 0.38F, 0.0F, 0.62F, 1.0F, 1.76F, 1.0F, 1.98F, 0.0F, 3.8F, 0.0F}
      };
      ANIM[7] = new float[][]{
         {0.0F, 0.03F, 0.85F, 0.0F},
         {0.0F, -0.15F, 0.55F, 0.01F, 0.85F, 0.0F},
         var0,
         {0.0F, -20.0F, 0.55F, 3.0F, 0.85F, 0.0F},
         var0,
         {0.0F, 10.0F, 0.85F, 0.0F},
         {0.0F, -0.1F, 0.6F, -0.1F, 0.85F, 0.0F},
         {0.0F, -51.9F, 0.6F, -51.9F, 0.85F, 0.0F},
         {0.0F, -48.5F, 0.6F, -48.5F, 0.85F, 0.0F},
         {0.0F, 0.0F, 0.06F, -20.0F, 0.55F, 365.0F, 0.68F, 358.0F, 0.85F, 360.0F},
         var0,
         var0,
         {0.0F, 3.4F, 0.45F, 3.4F, 0.66F, 0.0F, 0.85F, 0.0F},
         {0.0F, -8.0F, 0.85F, 0.0F},
         {0.0F, -1.0F, 0.6F, -1.0F, 0.82F, 0.0F, 0.85F, 0.0F}
      };
      ANIM[8] = new float[][]{
         {0.0F, 0.0F, 0.14F, 0.008F, 0.5F, -0.212F, 2.9F, -0.205F, 3.55F, 0.005F, 3.8F, 0.0F},
         {0.0F, 0.0F, 0.14F, -0.012F, 0.5F, 0.137F, 1.25F, 0.135F, 1.6F, 0.155F, 2.0F, 0.138F, 2.9F, 0.13F, 3.55F, -0.005F, 3.8F, 0.0F},
         {0.0F, 0.0F, 0.5F, 0.1F, 2.9F, 0.09F, 3.55F, -0.004F, 3.8F, 0.0F},
         {0.0F, 0.0F, 0.14F, -2.0F, 0.5F, 11.0F, 2.9F, 12.0F, 3.8F, 0.0F},
         {0.0F, 0.0F, 0.5F, 0.4F, 1.5F, 8.0F, 2.3F, -6.0F, 2.9F, 0.0F, 3.8F, 0.0F},
         {0.0F, 0.0F, 0.14F, 1.0F, 0.5F, -9.2F, 2.9F, -9.0F, 3.8F, 0.0F},
         {0.0F, 0.0F, 0.14F, 3.0F, 0.5F, -21.0F, 1.25F, -18.0F, 1.45F, -32.0F, 1.85F, -16.0F, 2.35F, -24.0F, 2.75F, -19.0F, 3.6F, -4.0F, 3.8F, 0.0F},
         {0.0F, 0.0F, 0.5F, -6.8F, 1.3F, -2.0F, 1.9F, -10.0F, 2.9F, -6.0F, 3.8F, 0.0F},
         {
               0.0F,
               0.0F,
               0.5F,
               -10.0F,
               1.25F,
               -60.0F,
               1.62F,
               122.0F,
               1.72F,
               112.0F,
               1.85F,
               116.0F,
               2.35F,
               297.0F,
               2.45F,
               304.0F,
               2.58F,
               300.0F,
               2.75F,
               302.0F,
               3.5F,
               358.0F,
               3.8F,
               360.0F
         },
         var0,
         var0,
         var0,
         var0,
         {0.0F, 0.0F, 0.14F, -4.0F, 0.5F, 5.0F, 2.9F, 4.0F, 3.5F, -2.0F, 3.8F, 0.0F}
      };
      ANIM[9] = new float[][]{
         {0.0F, 0.03F, 0.8F, 0.0F},
         {0.0F, -0.15F, 0.55F, 0.012F, 0.8F, 0.0F},
         var0,
         {0.0F, -22.0F, 0.55F, 3.0F, 0.8F, 0.0F},
         var0,
         {0.0F, 12.0F, 0.8F, 0.0F},
         var0,
         {0.0F, 20.0F, 0.6F, -3.0F, 0.8F, 0.0F},
         {0.0F, -60.0F, 0.5F, 6.0F, 0.8F, 0.0F}
      };
      ANIM[10] = new float[][]{
         {0.0F, 0.0F, 0.14F, 0.008F, 0.5F, -0.212F, 1.0F, -0.221F, 1.75F, -0.216F, 2.1F, -0.221F, 3.0F, -0.206F, 3.6F, 0.005F, 3.9F, 0.0F},
         {0.0F, 0.0F, 0.14F, -0.012F, 0.5F, 0.142F, 1.0F, 0.162F, 1.75F, 0.147F, 2.1F, 0.152F, 3.0F, 0.138F, 3.6F, -0.005F, 3.9F, 0.0F},
         {0.0F, 0.0F, 0.5F, 0.1F, 3.0F, 0.09F, 3.6F, -0.004F, 3.9F, 0.0F},
         {0.0F, 0.0F, 0.14F, -2.0F, 0.5F, 10.5F, 3.0F, 11.0F, 3.9F, 0.0F},
         {0.0F, 0.0F, 0.5F, -4.6F, 1.0F, -1.0F, 1.45F, -8.0F, 2.0F, -6.0F, 3.0F, -5.0F, 3.9F, 0.0F},
         {0.0F, 0.0F, 0.14F, 1.0F, 0.5F, -8.8F, 3.0F, -8.5F, 3.9F, 0.0F},
         {0.0F, 0.0F, 0.14F, 3.0F, 0.5F, -1.0F, 1.0F, -30.0F, 1.45F, -26.0F, 1.75F, -10.0F, 2.1F, -8.0F, 3.0F, -3.0F, 3.9F, 0.0F},
         {0.0F, 0.0F, 0.5F, -28.6F, 1.75F, -28.6F, 2.1F, -70.0F, 2.3F, -65.0F, 2.7F, -26.0F, 2.85F, -30.0F, 3.0F, -28.6F, 3.7F, -4.0F, 3.9F, 0.0F},
         {0.0F, 0.0F, 0.5F, -3.9F, 0.55F, -3.9F, 1.0F, 25.0F, 1.45F, -45.0F, 1.75F, -3.9F, 3.9F, 0.0F},
         var0,
         var0,
         var0,
         var0,
         {0.0F, 0.0F, 0.14F, -4.0F, 0.5F, 5.0F, 3.0F, 4.0F, 3.5F, -2.0F, 3.9F, 0.0F}
      };
      ANIM[11] = new float[][]{
         {0.0F, 0.03F, 0.85F, 0.0F},
         {0.0F, -0.15F, 0.6F, 0.01F, 0.85F, 0.0F},
         var0,
         {0.0F, -22.0F, 0.6F, 3.0F, 0.85F, 0.0F},
         var0,
         {0.0F, 12.0F, 0.85F, 0.0F},
         var0,
         {0.0F, -45.0F, 0.6F, 5.0F, 0.85F, 0.0F},
         {0.0F, -40.0F, 0.55F, 6.0F, 0.85F, 0.0F}
      };
      ANIM[12] = new float[][]{
         {0.0F, 0.0F, 0.15F, 0.008F, 0.65F, -0.169F, 2.6F, -0.172F, 3.2F, -0.187F, 3.7F, -0.17F, 4.2F, 0.005F, 4.5F, 0.0F},
         {0.0F, 0.0F, 0.15F, -0.012F, 0.65F, 0.123F, 2.6F, 0.126F, 3.2F, 0.151F, 3.7F, 0.13F, 4.2F, -0.005F, 4.5F, 0.0F},
         {0.0F, 0.0F, 0.65F, 0.06F, 3.7F, 0.055F, 4.2F, -0.003F, 4.5F, 0.0F},
         {0.0F, 0.0F, 0.15F, -2.0F, 0.65F, 7.8F, 2.6F, 8.5F, 3.2F, 8.8F, 3.7F, 8.0F, 4.5F, 0.0F},
         {0.0F, 0.0F, 0.65F, -4.0F, 1.7F, 2.0F, 2.7F, -6.0F, 3.2F, -4.7F, 3.6F, -1.0F, 4.5F, 0.0F},
         {0.0F, 0.0F, 0.15F, 1.0F, 0.65F, -6.6F, 2.6F, -7.0F, 3.2F, -7.5F, 3.7F, -6.5F, 4.5F, 0.0F},
         {0.0F, 0.0F, 0.15F, 3.0F, 0.65F, -17.9F, 1.7F, -15.0F, 2.6F, -18.0F, 3.2F, -9.4F, 3.7F, -12.0F, 4.25F, 1.0F, 4.5F, 0.0F},
         {0.0F, 0.0F, 0.65F, 0.0F, 2.6F, 1.0F, 3.2F, 5.5F, 3.7F, 3.0F, 4.5F, 0.0F},
         {
               0.0F,
               0.0F,
               0.65F,
               -16.9F,
               0.75F,
               -16.9F,
               1.6F,
               75.0F,
               2.4F,
               159.0F,
               2.55F,
               165.0F,
               2.75F,
               163.0F,
               3.05F,
               163.0F,
               3.6F,
               255.0F,
               4.1F,
               352.0F,
               4.25F,
               362.0F,
               4.4F,
               359.0F,
               4.5F,
               360.0F
         },
         var0,
         var0,
         var0,
         var0,
         {0.0F, 0.0F, 0.15F, -4.0F, 0.65F, 5.0F, 3.2F, 6.0F, 3.7F, 4.0F, 4.25F, -2.0F, 4.5F, 0.0F}
      };
      ANIM[13] = new float[][]{
         {0.0F, 0.05F, 1.0F, 0.0F},
         {0.0F, -0.2F, 0.7F, 0.012F, 1.0F, 0.0F},
         {0.0F, 0.04F, 1.0F, 0.0F},
         {0.0F, -26.0F, 0.7F, 3.0F, 1.0F, 0.0F},
         var0,
         {0.0F, 18.0F, 0.7F, -2.0F, 1.0F, 0.0F},
         {0.0F, 20.0F, 0.7F, -4.0F, 1.0F, 0.0F},
         var0,
         {0.0F, -35.0F, 0.7F, 5.0F, 1.0F, 0.0F}
      };
      ANIM[14] = new float[][]{
         var0,
         {0.0F, 0.0F, 0.4F, 0.008F, 1.0F, 0.006F, 1.4F, 0.0F},
         var0,
         var0,
         {0.0F, 0.0F, 0.45F, 3.0F, 1.4F, 0.0F},
         var0,
         {0.0F, 0.0F, 0.35F, -4.0F, 0.9F, -5.0F, 1.4F, 0.0F},
         var0,
         {0.0F, 0.0F, 0.35F, 28.0F, 0.9F, 32.0F, 1.4F, 0.0F}
      };
      ANIM[15] = new float[][]{
         var0,
         {0.0F, 0.0F, 0.2F, -0.006F, 0.5F, 0.004F, 1.0F, 0.0F},
         var0,
         var0,
         var0,
         var0,
         {0.0F, 0.0F, 0.2F, -5.0F, 0.5F, 2.0F, 1.0F, 0.0F},
         var0,
         var0,
         var0,
         var0,
         var0,
         {0.0F, 0.0F, 0.2F, -0.6F, 0.45F, 0.25F, 0.7F, 0.0F, 1.0F, 0.0F},
         {0.0F, 0.0F, 0.25F, -6.0F, 0.6F, 3.0F, 1.0F, 0.0F}
      };
      ANIM[16] = new float[][]{
         {0.0F, 0.0F, 0.45F, -0.006F, 1.3F, 0.0F},
         {0.0F, 0.0F, 0.45F, 0.014F, 0.9F, 0.012F, 1.3F, 0.0F},
         var0,
         var0,
         var0,
         {0.0F, 0.0F, 0.45F, -5.0F, 0.9F, -4.0F, 1.3F, 0.0F},
         {0.0F, 0.0F, 0.45F, 6.0F, 0.9F, 5.0F, 1.3F, 0.0F}
      };
      ANIM[17] = new float[][]{
         var0,
         var0,
         {0.0F, 0.0F, 0.45F, 0.006F, 1.4F, 0.0F},
         var0,
         var0,
         var0,
         var0,
         {0.0F, 0.0F, 0.4F, -10.0F, 0.95F, -12.0F, 1.4F, 0.0F},
         {0.0F, 0.0F, 0.4F, -18.0F, 0.95F, -22.0F, 1.4F, 0.0F}
      };
      e();
      f();
      g();
      h();
      i();
      j();
      k();
      l();
      m();

      for (int var1 = 0; var1 < 43; var1++) {
         float var2 = 0.0F;
         float[][] var3 = ANIM[var1];

         for (int var4 = 0; var4 < 21; var4++) {
            float[] var5 = var4 < var3.length ? var3[var4] : NOKEYS;
            if (var5.length >= 2 && var5[var5.length - 2] > var2) {
               var2 = var5[var5.length - 2];
            }
         }

         DUR[var1] = var2;
      }

      ANIM_V = new float[43][][];
      ANIM_A = new float[43][][];
      n();
      HOLD = new float[735];
      var0 = new float[]{
         0.0021F,
         0.0298F,
         0.0026F,
         0.0F,
         0.0F,
         0.0F,
         0.0F,
         0.0F,
         0.0F,
         0.0F,
         0.0F,
         -0.7F,
         -0.0496F,
         0.0594F,
         -0.0675F,
         3.2F,
         4.4F,
         -2.6F,
         14.1F,
         -44.6F,
         -7.2F,
         0.0F,
         0.0F,
         -0.55F,
         0.0331F,
         -0.0623F,
         0.0029F,
         9.5F,
         -4.2F,
         -7.9F,
         -29.3F,
         -20.8F,
         15.6F,
         0.0F,
         0.0F,
         -0.45F,
         -0.014F,
         0.166F,
         -0.04F,
         20.0F,
         -2.6F,
         -17.5F,
         -98.0F,
         -24.0F,
         42.3F,
         -2.4F,
         0.5F,
         -1.0F,
         -0.103F,
         0.065F,
         0.0021F,
         23.6F,
         -17.5F,
         -21.2F,
         -47.5F,
         -14.1F,
         35.5F,
         0.0F,
         0.0F,
         -0.35F,
         0.0F,
         0.081F,
         0.0F,
         0.5F,
         5.0F,
         -0.4F,
         0.0F,
         0.0F,
         0.0F,
         0.5F,
         0.0F,
         0.1F,
         -0.057F,
         0.09F,
         -0.04F,
         3.2F,
         4.4F,
         -2.6F,
         4.9F,
         6.0F,
         16.7F,
         1.0F,
         0.0F,
         0.2F,
         0.031F,
         0.0F,
         0.0F,
         8.6F,
         -3.6F,
         -7.2F,
         7.3F,
         7.9F,
         -7.7F,
         1.0F,
         0.0F,
         0.4F,
         0.0F,
         0.031F,
         0.0F,
         0.5F,
         5.0F,
         11.6F,
         -154.2F,
         5.1F,
         200.0F,
         -1.0F,
         0.0F,
         0.2F,
         -0.094F,
         0.072F,
         0.0F,
         23.6F,
         -17.5F,
         -21.2F,
         11.5F,
         -22.4F,
         -30.1F,
         0.0F,
         0.0F,
         0.0F,
         0.0013F,
         0.0186F,
         0.0016F,
         0.0F,
         0.0F,
         0.0F,
         0.0F,
         0.0F,
         0.0F,
         0.0F,
         0.0F,
         -0.55F,
         -0.052F,
         0.041F,
         -0.07F,
         3.2F,
         4.4F,
         -2.6F,
         14.1F,
         -44.6F,
         -7.2F,
         0.0F,
         0.0F,
         -0.3F,
         0.031F,
         -0.073F,
         0.0F,
         9.5F,
         -4.2F,
         -7.9F,
         -29.3F,
         -20.8F,
         15.6F,
         0.0F,
         0.0F,
         -0.3F,
         -0.014F,
         0.166F,
         -0.04F,
         20.0F,
         -2.6F,
         -17.5F,
         -98.0F,
         -24.0F,
         42.3F,
         -4.0F,
         0.5F,
         -1.0F,
         -0.104F,
         0.062F,
         0.0F,
         23.6F,
         -17.5F,
         -21.2F,
         -47.5F,
         -14.1F,
         35.5F,
         0.0F,
         0.0F,
         -0.3F,
         0.0019F,
         0.0261F,
         0.0023F,
         0.0F,
         0.0F,
         0.0F,
         0.0F,
         0.0F,
         0.0F,
         0.0F,
         0.0F,
         -0.65F,
         -0.0501F,
         0.0557F,
         -0.068F,
         3.2F,
         4.4F,
         -2.6F,
         14.1F,
         -44.6F,
         -7.2F,
         0.0F,
         0.0F,
         -0.5F,
         0.031F,
         -0.073F,
         0.0F,
         9.5F,
         -4.2F,
         -7.9F,
         -29.3F,
         -20.8F,
         15.6F,
         0.0F,
         0.0F,
         -0.3F,
         -0.014F,
         0.166F,
         -0.04F,
         20.0F,
         -2.6F,
         -17.5F,
         -98.0F,
         -24.0F,
         42.3F,
         -3.6F,
         0.5F,
         -1.0F,
         -0.104F,
         0.062F,
         0.0F,
         23.6F,
         -17.5F,
         -21.2F,
         -47.5F,
         -14.1F,
         35.5F,
         0.0F,
         0.0F,
         -0.3F,
         0.0F,
         0.106F,
         0.0F,
         0.5F,
         5.0F,
         -0.4F,
         0.0F,
         0.0F,
         0.0F,
         1.75F,
         0.0F,
         0.2F,
         -0.057F,
         0.09F,
         -0.04F,
         3.2F,
         4.4F,
         -2.6F,
         8.9F,
         6.0F,
         16.7F,
         1.0F,
         0.0F,
         0.0F,
         0.031F,
         0.0F,
         0.0F,
         8.6F,
         -3.6F,
         -7.2F,
         11.3F,
         7.9F,
         -7.7F,
         1.0F,
         0.0F,
         0.0F,
         0.0F,
         0.031F,
         0.0F,
         0.5F,
         5.0F,
         11.6F,
         -130.2F,
         5.1F,
         170.5F,
         0.0F,
         0.0F,
         0.2F,
         -0.094F,
         0.072F,
         0.0F,
         23.6F,
         -17.5F,
         -21.2F,
         15.5F,
         -22.4F,
         -30.1F,
         1.0F,
         0.0F,
         0.0F,
         -0.01F,
         -0.011F,
         0.02F,
         3.2F,
         4.4F,
         -2.6F,
         0.0F,
         0.0F,
         0.0F,
         0.0F,
         0.0F,
         -0.3F,
         -0.038F,
         0.011F,
         -0.04F,
         3.2F,
         4.4F,
         -2.6F,
         27.8F,
         -36.2F,
         -5.1F,
         0.0F,
         0.0F,
         -0.3F,
         0.031F,
         -0.072F,
         0.02F,
         9.5F,
         -4.2F,
         -7.9F,
         -22.3F,
         -11.0F,
         7.3F,
         0.0F,
         0.0F,
         -0.3F,
         -0.022F,
         0.182F,
         -0.02F,
         20.0F,
         -2.6F,
         -17.5F,
         -71.3F,
         -28.6F,
         21.5F,
         -6.6F,
         0.2F,
         -1.0F,
         -0.111F,
         0.059F,
         0.02F,
         23.6F,
         -17.5F,
         -21.2F,
         -38.5F,
         -7.2F,
         23.5F,
         0.0F,
         0.0F,
         -0.3F
      };

      for (int var11 = 1; var11 < 7; var11++) {
         for (int var14 = 0; var14 < 5; var14++) {
            int var16 = ((var11 - 1) * 5 + var14) * 12;
            int var18 = (var11 * 5 + var14) * 21;

            for (int var20 = 0; var20 <= 8; var20++) {
               HOLD[var18 + var20] = var0[var16 + var20];
            }

            HOLD[var18 + 12] = var0[var16 + 9];
            HOLD[var18 + 15] = var0[var16 + 10];
            HOLD[var18 + 16] = var0[var16 + 11];
         }
      }

      MICRO = new float[]{
         1.0F,
         0.0034F,
         4.7F,
         0.0F,
         1.0F,
         0.0011F,
         2.35F,
         1.3F,
         0.0F,
         0.0021F,
         7.3F,
         0.4F,
         2.0F,
         0.0016F,
         5.9F,
         2.2F,
         3.0F,
         0.55F,
         4.7F,
         0.6F,
         4.0F,
         0.75F,
         9.7F,
         1.1F,
         5.0F,
         0.6F,
         6.7F,
         2.9F,
         6.0F,
         0.85F,
         5.3F,
         0.2F,
         8.0F,
         1.1F,
         8.3F,
         1.7F,
         7.0F,
         0.45F,
         3.9F,
         2.4F
      };
      FIDGETS = true;
      by = new int[]{-1, -1};
      bz = new int[2];
      ca = new int[2];
      cb = new int[2];
      cc = new float[2];
      cd = new float[2];
      ce = new float[]{1.0F, 1.0F};
      cf = new long[2];
      cg = new float[42];
      ch = new float[42];
      ci = new float[42];
      cj = new float[2];
      ck = new float[2];
      cl = new float[42];
      cm = new int[]{-1, -1};
      cn = new int[2];
      co = new int[]{-1, -1};
      cp = new float[2];
      cq = new float[]{8.0F, 8.0F};
      cr = new float[21];
      cs = new float[21];
      ct = new float[21];
      cu = new float[21];
      cv = new float[21];
      cw = new float[21];
      cx = new float[21];
      cy = new float[21];
      cz = new float[21];
      CUE_HIT = new int[8];
      CUE_TAB = new float[0];
      da = new int[12];
      dc = new float[]{-1.0F, -1.0F};
      var0 = new float[0];
      CUES[0] = new float[]{0.6F, 3.0F, 0.85F, 0.3F};
      CUES[1] = var0;
      CUES[2] = new float[]{
         0.14F,
         6.0F,
         1.5F,
         0.25F,
         0.82F,
         1.0F,
         1.7F,
         0.5F,
         1.0F,
         0.0F,
         1.9F,
         0.55F,
         1.32F,
         1.0F,
         1.8F,
         0.5F,
         1.52F,
         0.0F,
         1.75F,
         0.6F,
         1.8F,
         2.0F,
         1.7F,
         0.3F,
         2.25F,
         1.0F,
         1.6F,
         0.45F,
         2.55F,
         4.0F,
         1.35F,
         0.4F,
         3.45F,
         4.0F,
         1.45F,
         0.35F
      };
      CUES[3] = new float[]{0.0F, 5.0F, 1.25F, 0.5F, 0.44F, 1.0F, 1.7F, 0.5F, 0.66F, 0.0F, 1.8F, 0.6F};
      CUES[4] = new float[]{0.55F, 1.0F, 1.5F, 0.45F, 0.95F, 3.0F, 1.25F, 0.55F, 1.4F, 3.0F, 1.45F, 0.6F, 1.7F, 1.0F, 1.35F, 0.55F, 2.1F, 4.0F, 1.3F, 0.45F};
      CUES[5] = new float[]{0.0F, 3.0F, 1.3F, 0.5F, 0.55F, 1.0F, 1.45F, 0.55F};
      CUES[6] = new float[]{
         0.52F,
         1.0F,
         1.6F,
         0.45F,
         0.9F,
         3.0F,
         1.3F,
         0.55F,
         1.35F,
         3.0F,
         1.5F,
         0.6F,
         1.62F,
         1.0F,
         1.45F,
         0.55F,
         1.95F,
         4.0F,
         1.45F,
         0.45F,
         2.6F,
         4.0F,
         1.55F,
         0.4F
      };
      CUES[7] = new float[]{0.0F, 3.0F, 1.35F, 0.5F, 0.55F, 1.0F, 1.5F, 0.55F};
      CUES[8] = new float[]{0.5F, 4.0F, 1.2F, 0.3F, 1.25F, 4.0F, 1.35F, 0.5F, 1.85F, 4.0F, 1.45F, 0.5F, 2.45F, 1.0F, 1.3F, 0.35F};
      CUES[9] = new float[]{0.0F, 4.0F, 1.1F, 0.55F, 0.55F, 1.0F, 1.25F, 0.45F};
      CUES[10] = new float[]{0.55F, 4.0F, 1.3F, 0.45F, 1.45F, 4.0F, 1.4F, 0.45F, 1.75F, 3.0F, 1.5F, 0.5F, 2.85F, 1.0F, 1.35F, 0.5F};
      CUES[11] = new float[]{0.0F, 4.0F, 1.15F, 0.55F, 0.6F, 1.0F, 1.3F, 0.45F};
      CUES[12] = new float[]{0.15F, 6.0F, 1.2F, 0.3F, 0.75F, 4.0F, 0.95F, 0.5F, 3.05F, 4.0F, 1.05F, 0.5F, 4.25F, 1.0F, 1.0F, 0.35F};
      CUES[13] = new float[]{0.0F, 4.0F, 0.9F, 0.6F, 0.7F, 1.0F, 1.05F, 0.5F};

      for (int var12 = 14; var12 < 18; var12++) {
         CUES[var12] = var0;
      }

      ARM_WS = 0.6F;
      ARM_LS = 1.0F;
      RECT = new float[40];
      K_AMB = new float[]{0.13F, 0.14F, 0.3F, 0.32F, 0.15F, 0.15F, 0.55F, 0.14F, 0.3F, 0.3F};
      K_DIF = new float[]{0.2F, 0.24F, 0.62F, 0.6F, 0.26F, 0.26F, 0.4F, 0.24F, 0.6F, 0.62F};
      K_ENV = new float[]{0.32F, 0.28F, 0.08F, 0.05F, 0.28F, 0.36F, 0.1F, 0.28F, 0.06F, 0.06F};
      K_SPC = new float[]{0.8F, 0.62F, 0.22F, 0.1F, 0.55F, 0.9F, 0.05F, 0.62F, 0.18F, 0.14F};
      K_ANI = new float[]{1.0F, 0.7F, 0.0F, 0.0F, 0.3F, 0.6F, 0.0F, 0.7F, 0.0F, 0.0F};
      K_FRS = new float[]{0.18F, 0.14F, 0.04F, 0.02F, 0.1F, 0.12F, 0.0F, 0.14F, 0.03F, 0.03F};
      K_COAT = new float[]{1.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.5F, 0.0F, 0.0F};
      K_F0 = new float[]{0.7F, 0.7F, 0.0F, 0.0F, 0.6F, 0.6F, 0.0F, 0.7F, 0.0F, 0.0F};
      F_ENV = new float[]{1.0F, 0.85F, 0.7F, 0.85F, 0.8F, 0.75F, 1.0F};
      F_SPC = new float[]{1.0F, 1.1F, 1.25F, 1.1F, 0.9F, 0.8F, 1.0F};
      F_ANI = new float[]{1.0F, 0.0F, 0.0F, 0.0F, 0.3F, 0.45F, 1.0F};
      F_COAT = new float[]{0.68F, 0.85F, 0.95F, 0.85F, 0.6F, 0.5F, 0.62F};
      F_F0 = new float[]{0.7F, 0.2F, 0.22F, 0.22F, 0.3F, 0.35F, 0.55F};
      dq = new float[10];
      dr = new float[10];
      ds = new float[10];
      dt = new float[10];
      du = new float[10];
      dv = new float[10];
      dw = new float[10];
      dx = new float[10];
      dy = new boolean[10];
      LV = new float[]{-0.42F, 0.74F, 0.52F, 0.62F, 0.18F, 0.76F, 0.12F, 0.3F, 1.0F};
      dz = new float[9];
      ea = new float[36];
      eb = new float[27];
      ec = new float[0];
      ed = new float[0];
      ee = new float[0];
      ef = new int[0];
      eg = new int[0];
      eh = new boolean[0];

      for (int var9 = 0; var9 < 3; var9++) {
         float var13 = LV[var9 * 3];
         float var15 = LV[var9 * 3 + 1];
         float var17 = LV[var9 * 3 + 2];
         float var19 = (float)Math.sqrt((double)(var13 * var13 + var15 * var15 + var17 * var17));
         LV[var9 * 3] = var13 / var19;
         LV[var9 * 3 + 1] = var15 / var19;
         LV[var9 * 3 + 2] = var17 / var19;
      }

      for (int var10 = 0; var10 < 10; var10++) {
         if (!FINMAT[var10]) {
            BevelTextureCache.a(var10, RECT, var10 * 4);
         }
      }

      ARM_BOX = new float[]{-3.0F, -2.0F, -2.0F, 1.0F, 10.0F, 2.0F};
      BOX_Q = new int[]{0, 4, 6, 2, 1, 3, 7, 5, 0, 1, 5, 4, 2, 6, 7, 3, 0, 2, 3, 1, 4, 5, 7, 6};
      BOX_N = new float[]{-1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F};
      BOX_E = new int[]{
         0, 1, 2, 4, 4, 5, 2, 5, 2, 3, 3, 4, 6, 7, 3, 5, 0, 2, 0, 4, 1, 3, 1, 4, 4, 6, 0, 5, 5, 7, 1, 5, 0, 4, 0, 2, 1, 5, 1, 2, 2, 6, 0, 3, 3, 7, 1, 3
      };
      ej = new float[24];
      ek = new boolean[6];
      eu = true;
      ev = true;
      ey = new float[48];
      ez = new float[512];
      fa = new float[512];
      fb = new float[512];
      fd = 0.2F;
      fg = new float[64];
      fh = new float[64];
      fi = new float[64];
      fj = new float[64];
      fk = new float[64];
      fl = new float[1280];
      fm = new float[1280];
      fn = new float[1280];
      fo = new float[1280];
      fp = new byte[1280];
      fs = new float[24];
      ft = new float[24];
      fu = new float[24];
      fv = new float[24];
      fw = new byte[24];
   }
}
