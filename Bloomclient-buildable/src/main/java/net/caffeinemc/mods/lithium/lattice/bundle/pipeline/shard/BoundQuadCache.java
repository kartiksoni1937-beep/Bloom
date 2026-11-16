package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Snippet;
import com.mojang.blaze3d.platform.DepthTestFunction;
import java.util.Arrays;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.render.OutputTarget;
import net.minecraft.client.render.RenderSetup;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.BufferAllocator;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Vector4f;

public final class BoundQuadCache {
   public static final BoundQuadCache ME = new BoundQuadCache();
   public static final int F_SELF = 1;
   public static final int F_FRIEND = 2;
   public static final int F_ONSCR = 4;
   public static final int F_ITEM = 8;
   public static final int F_BONES = 16;
   public static final int F_GHOST = 32;
   public static final int F_MOB = 64;
   public static final int F_NOHP = 128;
   public static final int JN = 11;
   private static final int[] w = new int[]{1, 2, 1, 7, 2, 3, 7, 8};
   private static final int[] x = new int[]{0, 3, 6, 8, 4, 5, 9, 10};
   public static float y = 2.0F;
   public static float fbW = 1.0F;
   public static float fbH = 1.0F;
   public static boolean z;
   public static float wCrn;
   public static float aHp;
   public static float aTr;
   public static float aa;
   public static int ab;
   public static int frTr;
   public static float ox;
   public static float oy;
   public static float oz;
   public static float exx;
   public static float exy;
   public static float exz;
   public static float eyx;
   public static float eyy;
   public static float eyz;
   private static final float ac = 0.0F;
   private static final Matrix4f ad = new Matrix4f();
   private static final Vector4f ae = new Vector4f();
   private static RenderLayer af;
   private static BufferAllocator ag;
   private static VertexConsumerProvider.Immediate ah;
   private static boolean ai;
   public static final int OCAP = 1024;
   public static final int OMAX = 512;
   public static final int OSH = 22;
   public static final int[] OID = new int[1024];
   public static final int[] OCOL = new int[1024];
   public static final int[] OGEN = new int[1024];
   public static final int[] OHIT = new int[1024];
   public static int OCUR;
   public static int OWID;
   public static boolean OL;
   public static boolean OLM;
   public static boolean OLX;
   public static int rn;
   public static int aj;
   public static float[] rx0;
   public static float[] ry0;
   public static float[] rx1;
   public static float[] ry1;
   public static float[] rd;
   public static float[] ra;
   public static float[] rhp;
   public static float[] rba;
   public static float[] rtx;
   public static float[] rty;
   public static float[] rbw;
   public static float[] rtw;
   public static int[] rc;
   public static int[] rf;
   public static int[] ak;
   public static int[] rla;
   public static float[] rj;
   public static final int CF_FRIEND = 1;
   public static final int CF_HP = 2;
   public static final int CF_SELF = 4;
   public static final int CF_GHOST = 8;
   public static final int KD_PL = 0;
   public static final int KD_HO = 1;
   public static final int KD_PA = 2;
   public static final int KD_CR = 3;
   public static final int[] KCOL = new int[]{0, 16729413, 11058384, 15749352};
   public static final int[] TCOL = new int[]{0, 16777215, 16726843, 16742943, 16765514, 16739029, 10120959};
   public static final int NONE = Integer.MIN_VALUE;
   public static int cn;
   public static int al;
   public static int[] ck;
   public static int[] cfl;
   public static int[] am;
   public static float[] csh;
   public static float[] ctw;
   public static float[] an;
   public static int[] ao;
   public static int[] ap;
   public static int[] cri;
   public static int[] coi;
   public static int[] cid;
   public static int[] aq;
   public static int ar;
   public static int pFr;
   public static int pTgt;
   public static boolean pHp;
   public static boolean as;
   public static boolean at;
   public static float pCx;
   public static float pCy;
   public static float au;
   public static int AIM_ID = Integer.MIN_VALUE;
   private static final int av = 0;
   private static final int aw = 1;
   private static final int ax = 2;
   private static final int ay = 3;
   private static final int az = 4;
   private static final int ba = 5;
   private static final int bb = 1;
   private static final int bc = 2;
   private static final int bd = 4;
   private static final int be = 8;
   private static final int bf = 15;
   private int bg;
   private int[] bh = new int[256];
   private int[] bi = new int[256];
   private float[] bj = new float[1536];
   private int[] bk = new int[1024];
   private final float[] bl = new float[16];
   private final float[] bm = new float[16];
   private final float[] bn = new float[16];
   private final float[] bo = new float[16];
   private final int[] bp = new int[16];
   private final int[] bq = new int[16];
   private final int[] br = new int[16];
   private final int[] bs = new int[16];
   private final int[] bt = new int[16];
   private int[] bu = new int[64];
   private float[] bv = new float[4096];
   private float[] bw = new float[4096];
   private int[] bx = new int[4096];
   private int by;
   public static final long AIM_DWELL_NS = 120000000L;
   public static final long AIM_KEEP_NS = 400000000L;
   public static int bz = Integer.MIN_VALUE;
   public static int ca = Integer.MIN_VALUE;
   public static long cb;
   public static long cc;
   private static final int cd = 16756768;
   private static final int ce = 16724016;
   private int cf = 15493800;
   private static int ch = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   private BoundQuadCache() {
   }

   public static void cap(int var0) {

      if (var0 > aj || rx0 == null) {
         int var1 = Math.max(var0, Math.max(64, aj * 2));
         rx0 = b(rx0, var1);
         ry0 = b(ry0, var1);
         rx1 = b(rx1, var1);
         ry1 = b(ry1, var1);
         rd = b(rd, var1);
         ra = b(ra, var1);
         rhp = b(rhp, var1);
         rba = b(rba, var1);
         rtx = b(rtx, var1);
         rty = b(rty, var1);
         rbw = b(rbw, var1);
         rtw = b(rtw, var1);
         rc = c(rc, var1);
         rf = c(rf, var1);
         ak = c(ak, var1);
         rla = c(rla, var1);
         rj = b(rj, var1 * 2 * 11);
         aj = var1;
      }
   }

   public static void a(int var0) {
      int var1 = 0;
      byte var2 = 0;

      label18:
      while (true) {
         switch (var2) {
            case 0:
            default:
               if (ch != 0) {
                  new Object().hashCode();
                  var2 = 1;
                  break;
               }
            case 1:
               if (var0 <= al && ck != null) {
                  return;
               }
            case 2:
               break label18;
         }
      }

      var1 = Math.max(var0, Math.max(64, al * 2));
      ck = c(ck, var1);
      cfl = c(cfl, var1);
      am = c(am, var1);
      csh = b(csh, var1);
      ctw = b(ctw, var1);
      an = b(an, var1);
      ao = c(ao, var1);
      ap = c(ap, var1);
      cri = c(cri, var1);
      coi = c(coi, var1);
      cid = c(cid, var1);
      aq = c(aq, var1);
      al = var1;
   }

   private static float[] b(float[] var0, int var1) {

      return var0 == null ? new float[var1] : Arrays.copyOf(var0, var1);
   }

   private static int[] c(int[] var0, int var1) {

      return var0 == null ? new int[var1] : Arrays.copyOf(var0, var1);
   }

   public int d() {

      return this.by;
   }

   public static boolean e(Matrix4fc var0, Matrix4fc var1) {

      Matrix4f var2 = ad;
      Vector4f var3 = ae;
      var2.set(var0).mul(var1).invert();
      float var4 = fbW;
      float var5 = fbH;
      if (var4 >= 1.0F && var5 >= 1.0F) {
         var2.transform(var3.set(-1.0F, 1.0F, 0.0F, 1.0F));
         float var6 = 1.0F / var3.w;
         float var7 = var3.x * var6;
         float var8 = var3.y * var6;
         float var9 = var3.z * var6;
         var2.transform(var3.set(1.0F, 1.0F, 0.0F, 1.0F));
         var6 = 1.0F / var3.w;
         float var10 = var3.x * var6;
         float var11 = var3.y * var6;
         float var12 = var3.z * var6;
         var2.transform(var3.set(-1.0F, -1.0F, 0.0F, 1.0F));
         var6 = 1.0F / var3.w;
         float var13 = var3.x * var6;
         float var14 = var3.y * var6;
         float var15 = var3.z * var6;
         float var16 = var7 + var8 + var9 + var10 + var11 + var12 + var13 + var14 + var15;
         if (var16 - var16 != 0.0F) {
            return false;
         } else {
            ox = var7;
            oy = var8;
            oz = var9;
            exx = (var10 - var7) / var4;
            exy = (var11 - var8) / var4;
            exz = (var12 - var9) / var4;
            eyx = (var13 - var7) / var5;
            eyy = (var14 - var8) / var5;
            eyz = (var15 - var9) / var5;
            return true;
         }
      } else {
         return false;
      }
   }

   public static boolean f() {

      VertexConsumerProvider.Immediate var0 = ah;
      RenderLayer var1 = af;
      if (var1 == null || var0 == null) {
         if (ai) {
            return false;
         }

         try {
            o();
         } catch (Throwable var3) {
            ai = true;
            af = null;
            return false;
         }

         var0 = ah;
         var1 = af;
         if (var1 == null || var0 == null) {
            return false;
         }
      }

      if (ME.by <= 0) {
         return true;
      } else {
         ME.u(var0.getBuffer(var1));
         var0.draw(var1);
         return true;
      }
   }

   public static VertexConsumerProvider.Immediate g() {
      return ah;
   }

   public static int h(int var0) {

      int var1 = OCUR;
      if (var1 == 0) {
         return -1;
      } else {
         int[] var2 = OGEN;
         int[] var3 = OID;
         int var4 = var0 * (-1234136438 ^ 675801915) >>> 22;

         for (int var5 = 0; var5 < (-1470017361 ^ -1470016337); var5++) {
            if (var2[var4] != var1) {
               return -1;
            }

            if (var3[var4] == var0) {
               return var4;
            }

            var4 = var4 + 1 & (996116992 ^ 996116991);
         }

         return -1;
      }
   }

   public static void i(int[] var0, int var1, int[] var2) {

      assert var0 != null
         && var2 != null
         && var1 >= 0
         && var1 <= var0.length
         && var1 <= var2.length
         && OID.length == (773880480 ^ 773881504)
         && OGEN.length == (-1516932249 ^ -1516931225)
         && OHIT.length == (-633088567 ^ -633089591)
         && OCOL.length == (1628441332 ^ 1628442356)
         && OCUR >= 0 : "olHits: bad args";

      int var3 = OCUR;
      boolean var4 = OL && var3 != 0;
      int[] var5 = OGEN;
      int[] var6 = OID;
      int[] var7 = OHIT;

      try {
         for (int var8 = 0; var8 < var1; var8++) {
            int var9 = 0;
            if (var4) {
               int var10 = var0[var8];
               int var11 = var10 * (197503859 ^ -1779248446) >>> 22;

               for (int var12 = 0; var12 < (788288352 ^ 788289376) && var5[var11] == var3; var12++) {
                  if (var6[var11] == var10) {
                     var9 = var7[var11] == var3 ? 2 : 1;
                     break;
                  }

                  var11 = var11 + 1 & (535195699 ^ 535196620);
               }
            }

            var2[var8] = var9;
         }
      } catch (RuntimeException var13) {
         throw var13;
      }
   }

   public static void j(int[] var0, int[] var1, int var2, boolean var3, int var4, boolean var5, boolean var6) {

      assert var0 != null
         && var1 != null
         && var2 >= 0
         && var2 <= var0.length
         && var2 <= var1.length
         && OID.length == (-1749989057 ^ -1749988033)
         && OGEN.length == (1232460322 ^ 1232461346)
         && OHIT.length == (-569396151 ^ -569397175)
         && OCOL.length == (452846234 ^ 452847258)
         && OCUR >= 0 : "olPublish: " + "bad args";

      int var7 = OCUR + 1;
      if (var7 <= 0) {
         Arrays.fill(OGEN, 0);
         Arrays.fill(OHIT, 0);
         var7 = 1;
      }

      int var8 = var3 ? Math.min(var2, -1976674488 ^ -1976675000) : 0;
      int[] var9 = OGEN;
      int[] var10 = OID;
      int[] var11 = OCOL;

      try {
         for (int var12 = 0; var12 < var8; var12++) {
            int var13 = var0[var12];
            int var14 = var13 * (-1875045180 ^ 235564405) >>> 22;

            while (var9[var14] == var7) {
               var14 = var14 + 1 & (1291245374 ^ 1291244737);
            }

            var10[var14] = var13;
            var11[var14] = var1[var12] & (-102277718 ^ -115826091);
            var9[var14] = var7;
         }
      } catch (RuntimeException var15) {
         throw var15;
      }

      OCUR = var7;
      OWID = var4;
      OLM = var3 && var5;
      OLX = var3 && var6;
      OL = var3;
   }

   public static int k(int var0, long var1, long var3, int var5, int var6, long var7) {

      long var9 = var3 - var1;
      return var0 != (-1101541694 ^ 1045941954) && var0 == var5 && var9 >= 0L && var9 < var7 ? var0 : var6;
   }

   public static int l(int var0, long var1) {
      byte var3 = 0;

      while (true) {
         label41:
         while (true) {
            switch (var3) {
               case 0:
               default:
                  if (ch != 0) {
                     Thread.currentThread().getName().length();
                     var3 = 4;
                     continue;
                  }
               case 4:
                  if (var0 != bz) {
                     bz = var0;
                     cb = var1;
                     var3 = 2;
                     continue;
                  }
               case 2:
                  if (var0 != (-2133286736 ^ 14196912)) {
                     if (var0 == ca) {
                        break;
                     }

                     if (var1 - cb >= 120000000L) {
                        var3 = 5;
                        continue;
                     }
                  }
               case 1:
                  if (ca == (1577383563 ^ -570100085)) {
                     return ca;
                  }

                  if (var1 - cc < 400000000L) {
                     if (var1 - cc >= 0L) {
                        return ca;
                     }

                     var3 = 3;
                     continue;
                  }
               case 3:
                  break label41;
               case 5:
                  break;
               case 6:
                  return ca;
            }

            ca = var0;
            cc = var1;
            var3 = 6;
         }

         ca = -1275140555 ^ 872343093;
         var3 = 6;
      }
   }

   public static void m() {

      AIM_ID = -863224600 ^ 1284259048;
      bz = -579202047 ^ 1568281601;
      ca = 199741040 ^ -1947742608;
   }

   public static void n(int[] var0, int[] var1) {

      assert cn >= 0
         && cn <= al
         && ck != null
         && ck.length >= cn
         && cfl.length >= cn
         && csh.length >= cn
         && am.length >= cn
         && ctw.length >= cn
         && an.length >= cn
         && ao.length >= cn
         && ap.length >= cn
         && cri.length >= cn
         && coi.length >= cn
         && cid.length >= cn
         && aq.length >= cn
         && var0 != null
         && KCOL.length == 4
         && rn >= 0
         && rn <= aj
         && rc.length >= rn
         && rtw.length >= rn
         && au >= 0.0F : "paint: bad" + " j" + "obs";

      int var2 = cn;
      int var3 = ar & (1511406838 ^ 1525269257);
      int var4 = pFr & (1251400701 ^ 1248404482);
      int var5 = pTgt & (-457072228 ^ -465674653);
      boolean var6 = pHp;
      boolean var7 = as;
      boolean var8 = at;
      float var9 = pCx;
      float var10 = pCy;
      float var11 = au;
      int var12 = 984779876 ^ -1162703772;
      float var13 = Float.MAX_VALUE;
      int[] var14 = KCOL;

      try {
         for (int var15 = 0; var15 < var2; var15++) {
            int var16 = cfl[var15];
            float var17 = ctw[var15];
            var17 = var17 < 0.0F ? 0.0F : (var17 > 1.0F ? 1.0F : var17);
            int var18;
            if ((var16 & 8) != 0) {
               var18 = ao[var15] & (-423177544 ^ -432460473);
            } else {
               int var19 = ck[var15];
               if ((var16 & 1) != 0) {
                  var18 = var4;
               } else if (var6 && (var16 & 2) != 0) {
                  float var20 = csh[var15];
                  var20 = var20 < 0.0F ? 0.0F : (var20 > 1.0F ? 1.0F : var20);
                  int var21;
                  int var22;
                  float var23;
                  if (var20 >= 0.5F) {
                     var21 = -1688440564 ^ -1683766996;
                     var22 = var3;
                     var23 = (var20 - 0.5F) * 2.0F;
                  } else {
                     var21 = -1222114858 ^ -1210633754;
                     var22 = -983135326 ^ -979813502;
                     var23 = var20 * 2.0F;
                  }

                  int var24 = var21 >> 16 & (1870283108 ^ 1870283163);
                  int var25 = var21 >> 8 & (1877182070 ^ 1877182089);
                  int var26 = var21 & (1978122322 ^ 1978122413);
                  var18 = (int)((float)var24 + (float)((var22 >> 16 & (2020451894 ^ 2020452041)) - var24) * var23 + 0.5F) << 16
                     | (int)((float)var25 + (float)((var22 >> 8 & (1559600612 ^ 1559600411)) - var25) * var23 + 0.5F) << 8
                     | (int)((float)var26 + (float)((var22 & (78907218 ^ 78907309)) - var26) * var23 + 0.5F);
               } else if (var7 && am[var15] >= 0) {
                  var18 = am[var15] & (-126146433 ^ -125511808);
               } else {
                  var18 = var19 > 0 && var19 < var14.length ? var14[var19] : var3;
               }

               if (var17 > 0.0F) {
                  int var31 = var18 >> 16 & (-1344367623 ^ -1344367866);
                  int var34 = var18 >> 8 & (825794944 ^ 825794943);
                  int var37 = var18 & (-456423143 ^ -456422938);
                  var18 = (int)((float)var31 + (float)((var5 >> 16 & (-893506662 ^ -893506715)) - var31) * var17 + 0.5F) << 16
                     | (int)((float)var34 + (float)((var5 >> 8 & (-381224023 ^ -381224106)) - var34) * var17 + 0.5F) << 8
                     | (int)((float)var37 + (float)((var5 & (-576440802 ^ -576440607)) - var37) * var17 + 0.5F);
               }

               int var32 = aq[var15];
               if (var1 != null && var32 >= 0 && var32 < var1.length) {
                  var1[var32] = var18;
               }
            }

            ao[var15] = var18;
            float var29 = an[var15] * (1.0F - var17);
            int var33 = var18;
            if (var29 > 0.0F) {
               float var35 = 1.0F - 0.4F * (var29 > 1.0F ? 1.0F : var29);
               var33 = (int)((float)(var18 >> 16 & (-375808947 ^ -375808846)) * var35 + 0.5F) << 16
                  | (int)((float)(var18 >> 8 & (306018818 ^ 306019069)) * var35 + 0.5F) << 8
                  | (int)((float)(var18 & (866066507 ^ 866066612)) * var35 + 0.5F);
            }

            ap[var15] = var33;
            int var36 = coi[var15];
            if (var36 >= 0 && var36 < var0.length) {
               var0[var36] = var33;
            }

            int var38 = cri[var15];
            if (var38 >= 0 && var38 < rn) {
               rc[var38] = var18;
               rtw[var38] = var17;
               if (var8
                  && (var16 & 12) == 0
                  && var9 >= rx0[var38] - var11
                  && var9 <= rx1[var38] + var11
                  && var10 >= ry0[var38] - var11
                  && var10 <= ry1[var38] + var11
                  && rd[var38] < var13) {
                  var13 = rd[var38];
                  var12 = cid[var15];
               }
            }
         }
      } catch (RuntimeException var27) {
         throw var27;
      }

      AIM_ID = var12;
   }

   private static void o() {

      RenderPipeline var0 = RenderPipeline.builder(new Snippet[]{RenderPipelines.POSITION_COLOR_SNIPPET})
         .withLocation(Identifier.of("lithium", "p" + "ipeline/esp_marks"))
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build();
      RenderLayer var1 = RenderLayer.of(
         "l" + "ithium_esp" + "_marks", RenderSetup.builder(var0).outputTarget(OutputTarget.MAIN_TARGET).expectedBufferSize(498564818 ^ 498499282).build()
      );
      BufferAllocator var2 = new BufferAllocator(369757526 ^ 369823062);
      ag = var2;
      ah = VertexConsumerProvider.immediate(var2);
      af = var1;
   }

   public void p() {

      assert rn >= 0
         && rn <= aj
         && rx0 != null
         && rx0.length >= aj
         && ry0.length >= aj
         && rx1.length >= aj
         && ry1.length >= aj
         && rd.length >= aj
         && ra.length >= aj
         && rhp.length >= aj
         && rba.length >= aj
         && rtx.length >= aj
         && rty.length >= aj
         && rbw.length >= aj
         && rtw.length >= aj
         && rc.length >= aj
         && rf.length >= aj
         && ak.length >= aj
         && rla.length >= aj
         && rj.length >= aj * 2 * 11
         && y >= 1.0F
         && fbW > 0.0F
         && fbH > 0.0F
         && ab >= 0
         && ab <= (-495734107 ^ -495734182)
         && this.bh.length == this.bi.length
         && this.bj.length == this.bh.length * 6
         && this.bk.length == this.bh.length * 4 : "build: bad" + " " + "rec" + "ords";

      this.by = 0;
      this.bg = 0;
      int var1 = rn;
      if (var1 > 0) {
         int[] var2 = ThemeCache.j();
         this.cf = var2[0] << 16 | var2[1] << 8 | var2[2];
         if (this.bu.length < var1) {
            this.bu = new int[Math.max(var1, this.bu.length * 2)];
         }

         int[] var3 = this.bu;
         float[] var4 = rd;

         try {
            int var5 = 0;

            while (var5 < var1) {
               float var6 = var4[var5];

               int var7;
               for (var7 = var5 - 1; var7 >= 0 && var4[var3[var7]] < var6; var7--) {
                  var3[var7 + 1] = var3[var7];
               }

               var3[var7 + 1] = var5++;
            }
         } catch (RuntimeException var8) {
            throw var8;
         }

         this.r(var1);
         this.s();
      }
   }

   private void q(int var1) {
      int var2 = 0;
      int var3 = 0;
      byte var4 = 0;

      label16:
      while (true) {
         switch (var4) {
            case 0:
            default:
               if (ch != 0) {
                  System.nanoTime();
                  var4 = 1;
                  break;
               }
            case 1:
               var2 = this.bg + var1;
               if (var2 <= this.bh.length) {
                  return;
               }
            case 2:
               break label16;
         }
      }

      var3 = Math.max(var2, this.bh.length * 2);
      this.bh = Arrays.copyOf(this.bh, var3);
      this.bi = Arrays.copyOf(this.bi, var3);
      this.bj = Arrays.copyOf(this.bj, var3 * 6);
      this.bk = Arrays.copyOf(this.bk, var3 * 4);
   }

   private void r(int var1) {

      assert var1 > 0
         && var1 <= rn
         && this.bu.length >= var1
         && y >= 1.0F
         && fbW > 0.0F
         && fbH > 0.0F
         && ab >= 0
         && ab <= (1009006854 ^ 1009007097)
         && rbw.length >= var1
         && rtw.length >= var1
         && wCrn >= 0.0F
         && wCrn <= 1.0F
         && aHp >= 0.0F
         && aHp <= 1.0F
         && aTr >= 0.0F
         && aTr <= 1.0F
         && aa >= 0.0F
         && aa <= 1.0F
         && w.length == 8
         && x.length == 8
         && this.bh.length == this.bi.length
         && this.bj.length == this.bh.length * 6
         && this.bk.length == this.bh.length * 4
         && rj.length >= var1 * 2 * 11 : "shapes: bad frame";

      float var2 = y;
      boolean var3 = z;
      float var4 = var3 ? var2 : Math.max(1.0F, 0.75F * var2);
      float var5 = fbW * 0.5F;
      float var6 = fbH * 0.5F;
      int[] var7 = this.bu;
      this.q(var1 * 24 + 8);
      int[] var8 = this.bh;
      int[] var9 = this.bi;
      int[] var10 = this.bk;
      float[] var11 = this.bj;
      int var12 = this.bg;

      try {
         for (int var13 = 0; var13 < var1; var13++) {
            int var14 = var7[var13];
            int var15 = rf[var14];
            if ((var15 & 1) == 0) {
               boolean var16 = (var15 & 8) != 0;
               float var17 = ra[var14] * (var16 ? aa : aTr);
               float var18 = var16 ? 0.0F : rtw[var14];
               var18 = var18 > 0.0F ? Math.min(1.0F, var18) : 0.0F;
               int var19 = (int)((136.0F + 119.0F * var18) * var17 + 0.5F);
               if (var19 > 0) {
                  int var20 = rc[var14] & (-1496575695 ^ -1506545970);
                  int var21 = var16 ? 327879771 ^ 326425435 : ((var15 & 2) != 0 ? frTr : ((var15 & 64) != 0 ? var20 : -601284608 ^ -589897729));
                  if (var18 > 0.0F) {
                     int var22 = var21 >> 16 & (1837179587 ^ 1837179452);
                     int var23 = var21 >> 8 & (-398401943 ^ -398401898);
                     int var24 = var21 & (1753967448 ^ 1753967527);
                     var21 = (int)((float)var22 + (float)((var20 >> 16 & (-1675952566 ^ -1675952459)) - var22) * var18 + 0.5F) << 16
                        | (int)((float)var23 + (float)((var20 >> 8 & (2091502867 ^ 2091503084)) - var23) * var18 + 0.5F) << 8
                        | (int)((float)var24 + (float)((var20 & (-665894576 ^ -665894481)) - var24) * var18 + 0.5F);
                  }

                  int var63 = var12 * 6;
                  var8[var12] = 5;
                  var11[var63] = var5;
                  var11[var63 + 1] = var6;
                  var11[var63 + 2] = rtx[var14];
                  var11[var63 + 3] = rty[var14];
                  var11[var63 + 4] = var4 * 0.5F * (1.0F + 0.5F * var18);
                  var10[var12 * 4] = var19 << 24 | var21;
                  var12++;
               }
            }
         }

         for (int var53 = 0; var53 < var1; var53++) {
            int var54 = var7[var53];
            int var55 = rf[var54];
            if ((var55 & 4) != 0) {
               float var56 = rx0[var54];
               float var57 = ry0[var54];
               float var59 = rx1[var54];
               float var60 = ry1[var54];
               float var61 = ra[var54];
               int var62 = rc[var54];
               boolean var64 = (var55 & 8) != 0;
               float var65 = var61 * rbw[var54];
               float var66 = Math.min(var59 - var56, var60 - var57);
               if (var65 > 0.0F) {
                  float var25 = (float)ab * var65;
                  if (var25 >= 0.5F) {
                     int var26 = (int)Math.min(255.0F, var25 * (!var3 && !var64 ? 0.7F : 1.0F) + 0.5F);
                     int var27 = (int)Math.min(255.0F, var25 * (!var3 && !var64 ? 1.3F : 1.0F) + 0.5F);
                     int var28 = var12 * 6;
                     int var29 = var12 * 4;
                     var8[var12] = 0;
                     var9[var12] = 15;
                     var11[var28] = var56;
                     var11[var28 + 1] = var57;
                     var11[var28 + 2] = var59;
                     var11[var28 + 3] = var60;
                     var10[var29] = var26 << 24 | var62;
                     var10[var29 + 1] = var27 << 24 | var62;
                     var10[var29 + 2] = var27 << 24 | var62;
                     var10[var29 + 3] = var26 << 24 | var62;
                     var12++;
                  }

                  float var68 = var64 ? 1.0F : wCrn;
                  float var71 = var64 ? Math.max(Math.max(2.0F * var2, var4 * 1.5F), var66 / 3.0F) : Math.max(4.0F * var2, var66 / 3.0F);
                  var71 = Math.min(var71, Math.max(var4 * 1.5F, var66 * 0.5F));

                  for (int var75 = 0; var75 < 2; var75++) {
                     boolean var78 = var75 == 1;
                     float var30 = var65 * (var78 ? var68 : 1.0F - var68);
                     if (var30 > 0.0F) {
                        if (!var64) {
                           if (var3) {
                              int var31 = (int)(136.0F * var30 + 0.5F);
                              if (var31 > 0) {
                                 int var32 = var12 * 6;
                                 var8[var12] = var78 ? 3 : 1;
                                 var9[var12] = 1;
                                 var11[var32] = var56 - var2;
                                 var11[var32 + 1] = var57 - var2;
                                 var11[var32 + 2] = var59 + var2;
                                 var11[var32 + 3] = var60 + var2;
                                 var11[var32 + 4] = var2 + 0.5F;
                                 var11[var32 + 5] = var71 + var2;
                                 var10[var12 * 4] = var31 << 24;
                                 var12++;
                              }
                           } else {
                              int var83 = (int)((var78 ? 200.0F : 205.0F) * var30 + 0.5F);
                              if (var83 > 0) {
                                 int var87 = var12 * 6;
                                 var8[var12] = var78 ? 4 : 2;
                                 var9[var12] = 0;
                                 var11[var87] = var56 + 0.5F;
                                 var11[var87 + 1] = var57 + 0.5F;
                                 var11[var87 + 2] = var59 - 0.5F;
                                 var11[var87 + 3] = var60 - 0.5F;
                                 var11[var87 + 4] = var4 + 1.0F;
                                 var11[var87 + 5] = var71 - 0.5F;
                                 var10[var12 * 4] = var83 << 24;
                                 var12++;
                              }
                           }
                        }

                        int var84 = (int)((!var3 && !var64 ? (var78 ? 235.0F : 225.0F) : 255.0F) * var30 + 0.5F);
                        if (var84 > 0) {
                           int var88 = var12 * 6;
                           var8[var12] = var78 ? 3 : 1;
                           var9[var12] = 3;
                           var11[var88] = var56;
                           var11[var88 + 1] = var57;
                           var11[var88 + 2] = var59;
                           var11[var88 + 3] = var60;
                           var11[var88 + 4] = var4;
                           var11[var88 + 5] = var71;
                           var10[var12 * 4] = var84 << 24 | var62;
                           var12++;
                        }
                     }
                  }
               }

               float var67 = rba[var54];
               if ((var55 & 16) != 0 && var67 > 0.0F) {
                  int var69 = (int)(255.0F * var67 + 0.5F);
                  if (var69 >= 3) {
                     float var73 = Math.max(1.25F, 1.75F * var2) * 0.5F;
                     int var76 = var69 << 24 | var62;
                     int var79 = var54 * 2 * 11;

                     for (int var81 = 0; var81 < 8; var81++) {
                        int var85 = var79 + w[var81] * 2;
                        int var89 = var79 + x[var81] * 2;
                        float var33 = rj[var85];
                        float var34 = rj[var85 + 1];
                        float var35 = rj[var89];
                        float var36 = rj[var89 + 1];
                        if (var33 == var33 && var34 == var34 && var35 == var35 && var36 == var36) {
                           int var37 = var12 * 6;
                           var8[var12] = 5;
                           var11[var37] = var33;
                           var11[var37 + 1] = var34;
                           var11[var37 + 2] = var35;
                           var11[var37 + 3] = var36;
                           var11[var37 + 4] = var73;
                           var10[var12 * 4] = var76;
                           var12++;
                        }
                     }
                  }
               }

               float var70 = !var64 && (var55 & (-279624097 ^ -279623969)) == 0 ? var61 * aHp : 0.0F;
               int var74 = var70 > 0.0F ? (int)(255.0F * var70 + 0.5F) : 0;
               if (var74 > 0) {
                  float var77 = rhp[var54];
                  float var80 = (var60 - var57) * var77;
                  int var82;
                  int var86;
                  float var90;
                  if (var77 >= 0.5F) {
                     var82 = 1223540126 ^ 1209167778;
                     var86 = this.cf;
                     var90 = (var77 - 0.5F) * 2.0F;
                  } else {
                     var82 = -1692054027 ^ -1680185377;
                     var86 = 928379290 ^ 933897126;
                     var90 = var77 * 2.0F;
                  }

                  int var91 = (int)(
                     (float)(var82 >> 16 & (-908839276 ^ -908839317))
                        + (float)((var86 >> 16 & (1203627759 ^ 1203627536)) - (var82 >> 16 & (79961201 ^ 79961230))) * var90
                        + 0.5F
                  );
                  int var92 = (int)(
                     (float)(var82 >> 8 & (77423263 ^ 77423200))
                        + (float)((var86 >> 8 & (1058253150 ^ 1058253217)) - (var82 >> 8 & (1719919156 ^ 1719919307))) * var90
                        + 0.5F
                  );
                  int var93 = (int)(
                     (float)(var82 & (-1937740864 ^ -1937740993))
                        + (float)((var86 & (1943359869 ^ 1943359874)) - (var82 & (769466279 ^ 769466200))) * var90
                        + 0.5F
                  );
                  int var94 = var74 << 24 | var91 << 16 | var92 << 8 | var93;
                  int var95 = var74 << 24
                     | Math.min(1850515671 ^ 1850515496, var91 + 60) << 16
                     | Math.min(1664105280 ^ 1664105407, var92 + 60) << 8
                     | Math.min(-1903513363 ^ -1903513582, var93 + 60);
                  float var38 = var60 - var80;
                  boolean var39 = var80 > 0.05F;

                  for (int var40 = 0; var40 < 6; var40++) {
                     float var41;
                     float var42;
                     float var43;
                     float var44;
                     int var45;
                     int var46;
                     int var47;
                     if (!var3) {
                        if (var40 >= 2) {
                           break;
                        }

                        float var48 = Math.max(2.0F, 1.5F * var2);
                        var41 = var56 - 2.0F * var2 - var48;
                        var43 = var56 - 2.0F * var2;
                        var42 = var40 == 0 ? var57 : var38;
                        var44 = var60;
                        var45 = 15;
                        var46 = var40 == 0 ? var74 * (-1890511817 ^ -1890511685) / (748829367 ^ 748829256) << 24 : var95;
                        var47 = var40 == 0 ? var46 : var94;
                        if (var40 == 1 && !var39) {
                           continue;
                        }
                     } else {
                        float var96 = var56 - 4.0F * var2;
                        float var49 = var56 - 2.0F * var2;
                        float var50 = var56 - 6.0F * var2;
                        float var51 = var39 ? var38 : var60 + var2;
                        var46 = var74 << 24;
                        var47 = var46;
                        if (var40 == 0) {
                           var41 = var50;
                           var43 = var96;
                           var42 = var57 - var2;
                           var44 = Math.min(var51 - var2, var60 - var2);
                           var45 = var39 ? 7 : 15;
                        } else if (var40 == 1) {
                           var41 = var50;
                           var43 = var96;
                           var42 = var51 - var2;
                           var44 = var60 - var2;
                           var45 = 9;
                        } else if (var40 == 2) {
                           var41 = var96;
                           var43 = var49;
                           var42 = var51 - var2;
                           var44 = var60 - var2;
                           var45 = 6;
                        } else if (var40 == 3) {
                           var41 = var96;
                           var43 = var49;
                           var42 = var39 ? var60 - var2 : var60 + var2;
                           var44 = var60;
                           var45 = 13;
                        } else {
                           if (!var39) {
                              break;
                           }

                           var41 = var96;
                           var43 = var49;
                           var42 = var38;
                           var44 = var40 == 4 ? var60 : var38 + Math.min(var2, var80);
                           var45 = 15;
                           var46 = var40 == 4 ? var94 : var95;
                           var47 = var46;
                        }
                     }

                     if (var44 - var42 > 0.001F) {
                        int var97 = var12 * 6;
                        int var98 = var12 * 4;
                        var8[var12] = 0;
                        var9[var12] = var45;
                        var11[var97] = var41;
                        var11[var97 + 1] = var42;
                        var11[var97 + 2] = var43;
                        var11[var97 + 3] = var44;
                        var10[var98] = var46;
                        var10[var98 + 1] = var47;
                        var10[var98 + 2] = var47;
                        var10[var98 + 3] = var46;
                        var12++;
                     }
                  }
               }
            }
         }
      } catch (RuntimeException var52) {
         throw var52;
      }

      this.bg = var12;
   }

   private void s() {

      assert this.bg >= 0
         && this.bg <= this.bh.length
         && this.bh.length == this.bi.length
         && this.bj.length == this.bh.length * 6
         && this.bk.length == this.bh.length * 4
         && this.bl.length == 16
         && this.bm.length == 16
         && this.bn.length == 16
         && this.bo.length == 16
         && this.bp.length == 16
         && this.bq.length == 16
         && this.br.length == 16
         && this.bs.length == 16
         && this.bt.length == 16
         && this.bv.length == this.bw.length
         && this.bv.length == this.bx.length
         && this.by >= 0 : "tess:" + " bad prims";

      int var1 = this.bg;
      if (this.bv.length < var1 * 24) {
         this.t(var1 * 24);
      }

      float[] var2 = this.bv;
      float[] var3 = this.bw;
      int[] var4 = this.bx;
      int var5 = 0;
      int[] var6 = this.bh;
      int[] var7 = this.bi;
      int[] var8 = this.bk;
      float[] var9 = this.bj;
      float[] var10 = this.bl;
      float[] var11 = this.bm;
      float[] var12 = this.bn;
      float[] var13 = this.bo;
      int[] var14 = this.bp;
      int[] var15 = this.bq;
      int[] var16 = this.br;
      int[] var17 = this.bs;
      int[] var18 = this.bt;

      try {
         for (int var19 = 0; var19 < var1; var19++) {
            if (var5 + (1032461199 ^ 1032461135) > var2.length) {
               this.t(var5 + (2009453726 ^ 2009453662));
               var2 = this.bv;
               var3 = this.bw;
               var4 = this.bx;
            }

            int var20 = var6[var19];
            int var21 = var19 * 6;
            float var22 = var9[var21];
            float var23 = var9[var21 + 1];
            float var24 = var9[var21 + 2];
            float var25 = var9[var21 + 3];
            float var26 = var9[var21 + 4];
            int var27 = var8[var19 * 4];
            if (var20 == 5) {
               float var85 = var24 - var22;
               float var86 = var25 - var23;
               float var87 = (float)Math.sqrt((double)(var85 * var85 + var86 * var86));
               if (var87 >= 0.25F) {
                  float var88 = var85 / var87;
                  float var89 = var86 / var87;
                  if (var26 < 0.5F) {
                     int var93 = (int)((float)(var27 >>> 24) * var26 * 2.0F + 0.5F);
                     var26 = 0.5F;
                     var27 = var93 << 24 | var27 & (2095084193 ^ 2082442590);
                  }

                  int var94 = var27 & (1082878050 ^ 1081382813);
                  float var98 = var87 * 0.5F + var26;
                  float var103 = (var22 + var24) * 0.5F;
                  float var107 = (var23 + var25) * 0.5F;
                  float var110 = var88 * var98;
                  float var112 = var89 * var98;
                  float var114 = -var89 * (var26 - 0.5F);
                  float var116 = var88 * (var26 - 0.5F);
                  float var118 = -var89 * (var26 + 0.5F);
                  float var120 = var88 * (var26 + 0.5F);
                  float var122 = var103 - var110;
                  float var125 = var107 - var112;
                  float var126 = var103 + var110;
                  float var129 = var107 + var112;
                  var2[var5] = var122 - var114;
                  var3[var5] = var125 - var116;
                  var4[var5++] = var27;
                  var2[var5] = var122 + var114;
                  var3[var5] = var125 + var116;
                  var4[var5++] = var27;
                  var2[var5] = var126 + var114;
                  var3[var5] = var129 + var116;
                  var4[var5++] = var27;
                  var2[var5] = var126 - var114;
                  var3[var5] = var129 - var116;
                  var4[var5++] = var27;
                  var2[var5] = var122 - var118;
                  var3[var5] = var125 - var120;
                  var4[var5++] = var94;
                  var2[var5] = var122 - var114;
                  var3[var5] = var125 - var116;
                  var4[var5++] = var27;
                  var2[var5] = var126 - var114;
                  var3[var5] = var129 - var116;
                  var4[var5++] = var27;
                  var2[var5] = var126 - var118;
                  var3[var5] = var129 - var120;
                  var4[var5++] = var94;
                  var2[var5] = var122 + var114;
                  var3[var5] = var125 + var116;
                  var4[var5++] = var27;
                  var2[var5] = var122 + var118;
                  var3[var5] = var125 + var120;
                  var4[var5++] = var94;
                  var2[var5] = var126 + var118;
                  var3[var5] = var129 + var120;
                  var4[var5++] = var94;
                  var2[var5] = var126 + var114;
                  var3[var5] = var129 + var116;
                  var4[var5++] = var27;
               }
            } else {
               int var28 = 0;
               int var29 = var7[var19];
               int var30 = (var29 & 1) != 0 ? 1 : 0;
               int var31 = (var29 & 2) != 0 ? 1 : 0;
               int var32 = var27 & (-987419868 ^ -975514405);
               if (var20 == 0) {
                  var10[0] = var22;
                  var11[0] = var23;
                  var12[0] = var24;
                  var13[0] = var25;
                  var14[0] = var27;
                  var15[0] = var8[var19 * 4 + 1];
                  var16[0] = var8[var19 * 4 + 2];
                  var17[0] = var8[var19 * 4 + 3];
                  var18[0] = var29;
                  var28 = 1;
               } else if (var20 == 1) {
                  float var33 = (float)var31 * 0.5F;

                  for (int var34 = 0; var34 < 4; var34++) {
                     boolean var35 = var34 >= 2;
                     boolean var36 = (var34 & 1) != 0;
                     var10[var28] = var35 ? (var36 ? var24 - var26 : var22) : var22;
                     var12[var28] = var35 ? (var36 ? var24 : var22 + var26) : var24;
                     var11[var28] = var35 ? var23 + var26 - var33 : (var36 ? var25 - var26 : var23);
                     var13[var28] = var35 ? var25 - var26 + var33 : (var36 ? var25 : var23 + var26);
                     var18[var28] = var35 ? var30 * (var36 ? 4 : 1) | var31 * (var36 ? 1 : 4) : var30 * ((var36 ? 8 : 2) | 1 | 4) | var31 * (var36 ? 2 : 8);
                     var14[var28] = var27;
                     var15[var28] = var27;
                     var16[var28] = var27;
                     var17[var28] = var27;
                     var28++;
                  }
               } else if (var20 == 3) {
                  float var90 = Math.max(var26, var9[var21 + 5]);
                  float var95 = (float)var31 * 0.5F;

                  for (int var99 = 0; var99 < 4; var99++) {
                     boolean var104 = (var99 & 1) != 0;
                     boolean var37 = (var99 & 2) != 0;
                     var10[var28] = var104 ? var24 - var90 : var22;
                     var12[var28] = var104 ? var24 : var22 + var90;
                     var11[var28] = var37 ? var25 - var26 : var23;
                     var13[var28] = var37 ? var25 : var23 + var26;
                     var18[var28] = var30 * ((var37 ? 8 : 2) | 1 | 4) | var31 * (var37 ? 2 : 8);
                     var28++;
                     if (var90 - var26 + var95 > 0.001F) {
                        var10[var28] = var104 ? var24 - var26 : var22;
                        var12[var28] = var104 ? var24 : var22 + var26;
                        var11[var28] = var37 ? var25 - var90 : var23 + var26 - var95;
                        var13[var28] = var37 ? var25 - var26 + var95 : var23 + var90;
                        var18[var28] = var30 * ((var104 ? 4 : 1) | (var37 ? 2 : 8)) | var31 * (var104 ? 1 : 4);
                        var28++;
                     }
                  }

                  for (int var100 = 0; var100 < var28; var100++) {
                     var14[var100] = var27;
                     var15[var100] = var27;
                     var16[var100] = var27;
                     var17[var100] = var27;
                  }
               } else {
                  boolean var91 = var20 == 4;
                  float var96 = var91 ? Math.max(0.0F, var9[var21 + 5]) : 0.0F;

                  for (int var101 = 0; var101 < 4; var101++) {
                     boolean var105 = (var101 & 1) != 0;
                     boolean var108 = (var101 & 2) != 0;
                     var10[var28] = var105 ? var24 : var22 - var26;
                     var12[var28] = var105 ? var24 + var26 : var22;
                     var11[var28] = var108 ? var25 : var23 - var26;
                     var13[var28] = var108 ? var25 + var26 : var23;
                     var14[var28] = var105 && var108 ? var27 : var32;
                     var15[var28] = var105 && !var108 ? var27 : var32;
                     var16[var28] = !var105 && !var108 ? var27 : var32;
                     var17[var28] = !var105 && var108 ? var27 : var32;
                     var18[var28] = 0;
                     var28++;

                     for (int var38 = 0; var38 < 2; var38++) {
                        boolean var39 = var38 == 0;
                        if (var91 ? var96 > 0.001F : var101 < 2) {
                           float var40;
                           float var41;
                           float var42;
                           float var43;
                           if (var39) {
                              boolean var44 = var91 ? var108 : var101 == 1;
                              var40 = var91 ? (var105 ? var24 - var96 : var22) : var22;
                              var41 = var91 ? (var105 ? var24 : var22 + var96) : var24;
                              var42 = var44 ? var25 : var23 - var26;
                              var43 = var44 ? var25 + var26 : var23;
                              var14[var28] = var44 ? var27 : var32;
                              var17[var28] = var14[var28];
                              var15[var28] = var44 ? var32 : var27;
                              var16[var28] = var15[var28];
                           } else {
                              boolean var123 = var91 ? var105 : var101 == 1;
                              var40 = var123 ? var24 : var22 - var26;
                              var41 = var123 ? var24 + var26 : var22;
                              var42 = var91 ? (var108 ? var25 - var96 : var23) : var23;
                              var43 = var91 ? (var108 ? var25 : var23 + var96) : var25;
                              var14[var28] = var123 ? var27 : var32;
                              var15[var28] = var14[var28];
                              var17[var28] = var123 ? var32 : var27;
                              var16[var28] = var17[var28];
                           }

                           if (var41 - var40 > 0.001F && var43 - var42 > 0.001F) {
                              var10[var28] = var40;
                              var12[var28] = var41;
                              var11[var28] = var42;
                              var13[var28] = var43;
                              var18[var28] = 0;
                              var28++;
                           }
                        }
                     }
                  }
               }

               for (int var92 = 0; var92 < var28; var92++) {
                  float var97 = var10[var92];
                  float var102 = var11[var92];
                  float var106 = var12[var92];
                  float var109 = var13[var92];
                  if (var106 - var97 > 1.0E-4F && var109 - var102 > 1.0E-4F) {
                     int var111 = var18[var92];
                     int var113 = var14[var92];
                     int var115 = var15[var92];
                     int var117 = var16[var92];
                     int var119 = var17[var92];
                     float var121 = var106 - var97;
                     float var124 = var109 - var102;
                     float var45 = 1.0F;
                     if ((var111 & 5) == 5 && var121 < 1.0F) {
                        float var46 = (var97 + var106) * 0.5F;
                        var97 = var46 - 0.5F;
                        var106 = var46 + 0.5F;
                        var45 *= var121;
                     }

                     if ((var111 & 10) == 10 && var124 < 1.0F) {
                        float var127 = (var102 + var109) * 0.5F;
                        var102 = var127 - 0.5F;
                        var109 = var127 + 0.5F;
                        var45 *= var124;
                     }

                     if (var45 < 1.0F) {
                        var113 = (int)((float)(var113 >>> 24) * var45 + 0.5F) << 24 | var113 & (2058472931 ^ 2051944988);
                        var115 = (int)((float)(var115 >>> 24) * var45 + 0.5F) << 24 | var115 & (801601385 ^ 792234134);
                        var117 = (int)((float)(var117 >>> 24) * var45 + 0.5F) << 24 | var117 & (-890557870 ^ -904604243);
                        var119 = (int)((float)(var119 >>> 24) * var45 + 0.5F) << 24 | var119 & (-1434114162 ^ -1434789775);
                     }

                     if ((var113 | var115 | var117 | var119) >>> 24 != 0) {
                        float var128 = (var111 & 1) != 0 ? 0.5F : 0.0F;
                        float var47 = (var111 & 2) != 0 ? 0.5F : 0.0F;
                        float var48 = (var111 & 4) != 0 ? 0.5F : 0.0F;
                        float var49 = (var111 & 8) != 0 ? 0.5F : 0.0F;
                        float var50 = var97 + var128;
                        float var51 = var102 + var47;
                        float var52 = var106 - var48;
                        float var53 = var109 - var49;
                        float var54 = var97 - var128;
                        float var55 = var102 - var47;
                        float var56 = var106 + var48;
                        float var57 = var109 + var49;
                        var2[var5] = var50;
                        var3[var5] = var51;
                        var4[var5++] = var113;
                        var2[var5] = var50;
                        var3[var5] = var53;
                        var4[var5++] = var115;
                        var2[var5] = var52;
                        var3[var5] = var53;
                        var4[var5++] = var117;
                        var2[var5] = var52;
                        var3[var5] = var51;
                        var4[var5++] = var119;
                        if (var47 > 0.0F) {
                           var2[var5] = var54;
                           var3[var5] = var55;
                           var4[var5++] = var113 & (-1569300179 ^ -1568039214);
                           var2[var5] = var50;
                           var3[var5] = var51;
                           var4[var5++] = var113;
                           var2[var5] = var52;
                           var3[var5] = var51;
                           var4[var5++] = var119;
                           var2[var5] = var56;
                           var3[var5] = var55;
                           var4[var5++] = var119 & (-444463109 ^ -444729340);
                        }

                        if (var49 > 0.0F) {
                           var2[var5] = var50;
                           var3[var5] = var53;
                           var4[var5++] = var115;
                           var2[var5] = var54;
                           var3[var5] = var57;
                           var4[var5++] = var115 & (889962985 ^ 905199126);
                           var2[var5] = var56;
                           var3[var5] = var57;
                           var4[var5++] = var117 & (-669918705 ^ -655481360);
                           var2[var5] = var52;
                           var3[var5] = var53;
                           var4[var5++] = var117;
                        }

                        if (var128 > 0.0F) {
                           var2[var5] = var54;
                           var3[var5] = var55;
                           var4[var5++] = var113 & (220137351 ^ 232847480);
                           var2[var5] = var54;
                           var3[var5] = var57;
                           var4[var5++] = var115 & (-260442996 ^ -259650701);
                           var2[var5] = var50;
                           var3[var5] = var53;
                           var4[var5++] = var115;
                           var2[var5] = var50;
                           var3[var5] = var51;
                           var4[var5++] = var113;
                        }

                        if (var48 > 0.0F) {
                           var2[var5] = var52;
                           var3[var5] = var51;
                           var4[var5++] = var119;
                           var2[var5] = var52;
                           var3[var5] = var53;
                           var4[var5++] = var117;
                           var2[var5] = var56;
                           var3[var5] = var57;
                           var4[var5++] = var117 & (-2012153810 ^ -1997600815);
                           var2[var5] = var56;
                           var3[var5] = var55;
                           var4[var5++] = var119 & (1190416640 ^ 1175170815);
                        }
                     }
                  }
               }
            }
         }
      } catch (RuntimeException var58) {
         throw var58;
      }

      this.by = var5;
   }

   private void t(int var1) {

      int var2 = Math.max(var1, this.bv.length * 2);
      this.bv = Arrays.copyOf(this.bv, var2);
      this.bw = Arrays.copyOf(this.bw, var2);
      this.bx = Arrays.copyOf(this.bx, var2);
   }

   private void u(VertexConsumer var1) {

      float[] var2 = this.bv;
      float[] var3 = this.bw;
      int[] var4 = this.bx;

      assert var1 != null
         && var2 != null
         && var3 != null
         && var4 != null
         && var2 != var3
         && var2.length == var3.length
         && var2.length == var4.length
         && this.by >= 0
         && this.by <= var2.length
         && (this.by & 3) == 0
         && this.bh != null
         && this.bi != null
         && this.bj != null
         && this.bk != null
         && this.bu != null
         && this.bh.length == this.bi.length
         && this.bj.length == this.bh.length * 6
         && this.bk.length == this.bh.length * 4
         && this.bl.length == 16
         && this.bm.length == 16
         && this.bn.length == 16
         && this.bo.length == 16
         && this.bt.length == 16
         && rn >= 0
         && rn <= aj
         && y >= 1.0F
         && exx == exx
         && eyy == eyy
         && ox == ox
         && oy == oy
         && oz == oz : "emi" + "t: bad el" + "ement";

      int var5 = this.by;
      float var6 = ox;
      float var7 = oy;
      float var8 = oz;
      float var9 = exx;
      float var10 = exy;
      float var11 = exz;
      float var12 = eyx;
      float var13 = eyy;
      float var14 = eyz;

      try {
         for (int var15 = 0; var15 < var5; var15++) {
            float var16 = var2[var15];
            float var17 = var3[var15];
            var1.vertex(var6 + var16 * var9 + var17 * var12, var7 + var16 * var10 + var17 * var13, var8 + var16 * var11 + var17 * var14)
               .color(var4[var15]);
         }
      } catch (RuntimeException var18) {
         throw var18;
      }
   }

   public static float vx(int var0) {

      return var0 < ME.by ? ME.bv[var0] : Float.NaN;
   }

   public static float vy(int var0) {

      return var0 < ME.by ? ME.bw[var0] : Float.NaN;
   }

   public static void v(VertexConsumer var0) {

      ME.u(var0);
   }

   static {
      cap(64);
      a(64);
   }
}
