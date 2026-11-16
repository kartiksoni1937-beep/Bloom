package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.element;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.pipeline.RenderPipeline.Snippet;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexFormatElement;
import java.util.Arrays;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.NoticeQueue;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.texture.TextureSetup;
import net.minecraft.client.gui.render.state.SimpleGuiElementRenderState;
import net.minecraft.client.gui.render.state.GuiRenderState;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.gui.ScreenRect;
import org.joml.Matrix3x2fc;

public final class PaneGlassCache implements SimpleGuiElementRenderState {
   private static final float q = 0.04F;
   private static final int r = 24;
   private static final float s = 2.0F;
   private static final float[][] t = new float[25][];
   private static final float[][] u = new float[25][];
   private static final int v = 116;
   public static float PX;
   private static TextureSetup w;
   private static float x;
   private static float y;
   private static int z;
   private static RenderPipeline aa;
   private static RenderPipeline ab;
   private static final String[] ac;
   private static final String[] ad;
   private static boolean ae;
   private static final int af = 0;
   private static final int ag = 1;
   private static final float ah = -65536.0F;
   private static final float ai = 2.5F;
   private static final float aj = 1.0F;
   private static PaneGlassCache ak;
   private static PaneGlassCache[] al;
   private static int am;
   private static float[] an;
   private static float[] ao;
   private static int[] ap;
   private static boolean[] aq;
   private static float[] ar;
   private static float[] as;
   private static int[] at;
   private static boolean[] au;
   private static final float[] av;
   private static final float[] aw;
   private static final float[] ax;
   private static final float[] ay;
   private static final float[] az;
   private static final float[] ba;
   private static final float[] bb;
   private static final float[] bc;
   private static int bd;
   private float[] be = new float[64];
   private float[] bf = new float[64];
   private int[] bg = new int[64];
   private float[] bh = new float[64];
   private float[] bi = new float[64];
   private float[] bj = new float[64];
   private int[] bk = new int[64];
   private int[] bl = new int[64];
   private int bm;
   private boolean bn;
   private int bo;
   private int bp;
   private boolean bq;
   private float br;
   private float bs;
   private float bt;
   private float bu;
   private float bv;
   private final float[] bw = new float[12];
   private ScreenRect bx;
   private int by;
   private int bz;
   private int ca;
   private int cb;
   private boolean cc;
   private boolean cd;
   private TextureSetup ce;
   private float cf;
   private float cg;
   private ScreenRect ch;
   private boolean ci;
   private float cj;
   private float ck;
   private float cl;
   private float cm;
   public PaneGlassCache twin;
   private final float[] cn = new float[13];
   private boolean co;
   private float cp;
   private float cq;
   private float cr;
   private float cs;
   private float ct;
   private float cu;
   private float cv;
   private boolean cw;
   private float cx;
   private float cy;
   private float cz;
   private float da;
   private float db;
   private float dc;
   private float dd;
   private float de;
   private float df;
   private float dg;
   private float dh;
   private float di;
   private int dj;
   private boolean dk;
   private static final float[] dl;
   private static final float[] dm;
   private static final float[] dn;
   private static final float[] _kwren_do;
   private static final float[] dp;
   private static final int[] dq;
   private static final int[] dr;
   private static final boolean[] ds;
   private static final float[] dt;
   private static final float[] du;
   private static final float[] dv;
   private static final float[] dw;
   private static final float[] dx;
   private static final float[] dy;
   private static final float[] dz;
   private static final float[] ea;
   private static final float[] eb;
   private static final float[] ec;
   private static final int[] ed;
   private static final int[] ee;
   private static int ef = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   public static void frame(float var0) {

      PX = var0 > 1.0E-4F ? var0 : 0.5F;
      am = 0;
      ak = null;
      if (z == 0) {
         a();
      }
   }

   private static void a() {

      z = -1;
      VertexFormat var0 = null;
      RenderPipeline var1 = null;
      RenderPipeline var2 = null;
      GpuDevice var3 = null;

      try {
         var0 = VertexFormat.builder()
            .add(ac[5], VertexFormatElement.POSITION)
            .add(ac[6], VertexFormatElement.COLOR)
            .add(ac[7], VertexFormatElement.UV0)
            .add(ac[8], VertexFormatElement.UV1)
            .add(ac[9], VertexFormatElement.UV2)
            .build();
         var1 = RenderPipeline.builder(new Snippet[]{RenderPipelines.GUI_SNIPPET})
            .withLocation(Identifier.of(ac[0], ac[1]))
            .withVertexShader(Identifier.of(ac[0], ac[3]))
            .withFragmentShader(Identifier.of(ac[0], ac[3]))
            .withVertexFormat((VertexFormat)var0, VertexFormat.DrawMode.QUADS)
            .withCull(false)
            .build();
         var2 = RenderPipeline.builder(new Snippet[]{RenderPipelines.POSITION_TEX_COLOR_SNIPPET})
            .withLocation(Identifier.of(ac[0], ac[2]))
            .withVertexShader(Identifier.of(ac[0], ac[3]))
            .withFragmentShader(Identifier.of(ac[0], ac[4]))
            .withVertexFormat((VertexFormat)var0, VertexFormat.DrawMode.QUADS)
            .withCull(false)
            .build();
         var3 = RenderSystem.getDevice();
         if (var3.precompilePipeline((RenderPipeline)var1).isValid() && var3.precompilePipeline((RenderPipeline)var2).isValid()) {
            aa = (RenderPipeline)var1;
            ab = (RenderPipeline)var2;
            z = 1;
         } else {
            b(0, null);
         }
      } catch (Throwable var5) {
         z = -1;
         b(1, var5);
      }
   }

   private static void b(int var0, Throwable var1) {

      if (!ae) {
         ae = true;

         try {
            String var2 = var0 == 1 && var1 != null ? ad[4] + var1.getClass().getSimpleName() : ad[3];
            NoticeQueue.err(ad[0], ad[1] + var2 + ad[2]);
            if (var1 != null) {
               var1.printStackTrace();
            }
         } catch (Throwable var3) {
         }
      }
   }

   public static void frostTex(TextureSetup var0, float var1, float var2) {

      w = var0;
      x = var1;
      y = var2;
   }

   public static PaneGlassCache take(ScreenRect var0, boolean var1) {

      int var2 = am;
      if (var2 >= al.length) {
         al = Arrays.copyOf(al, var2 * 2);
      }

      PaneGlassCache var3 = al[var2];
      if (var3 == null) {
         var3 = new PaneGlassCache();
         al[var2] = var3;
      }

      am = var2 + 1;
      var3.cc = true;
      var3.cd = var1;
      var3.ce = w;
      var3.cf = x;
      var3.cg = y;
      var3.ch = var0;
      var3.ci = false;
      var3.twin = null;
      var3.bm = 0;
      var3.bn = z > 0;
      var3.bp = -1;
      return var3;
   }

   public static PaneGlassCache batch(ScreenRect var0, boolean var1) {

      PaneGlassCache var2 = take(null, var1);
      var2.bx = var0;
      return var2;
   }

   public void clip(ScreenRect var1) {
      byte var2 = 0;

      label16:
      while (true) {
         switch (var2) {
            case 0:
            default:
               if (ef != 0) {
                  Thread.currentThread().getName().length();
                  var2 = 1;
                  break;
               }
            case 1:
               if (var1 == null) {
                  this.ci = false;
                  return;
               }
            case 2:
               break label16;
         }
      }

      this.ci = true;
      this.cj = (float)var1.getLeft();
      this.ck = (float)var1.getTop();
      this.cl = (float)var1.getRight();
      this.cm = (float)var1.getBottom();
   }

   public void addTo(GuiRenderState var1) {

      assert var1 != null
         && this.be != null
         && this.bf != null
         && this.bg != null
         && this.be.length == this.bf.length
         && this.be.length == this.bg.length
         && this.bm >= 0
         && this.bm <= this.be.length
         && (this.bm & 3) == 0
         && this.cc
         && PX > 0.0F
         && al != null
         && am >= 0
         && am <= al.length
         && an.length == 116
         && ao.length == 116
         && ap.length == 116
         && aq.length == 116
         && ar.length == 116
         && as.length == 116
         && at.length == 116
         && au.length == 116
         && av.length == 116
         && aw.length == 116
         && ax.length == 116
         && ay.length == 116
         && az.length == 116
         && ba.length == 116
         && bb.length == 116
         && bc.length == 116
         && t.length == 25
         && u.length == 25
         && this.cn.length == 13 : "ad" + "dTo: b" + "a" + "d element";

      int var2 = this.bm;
      if (var2 != 0 && (!this.cd || this.ce != null)) {
         float[] var3 = this.be;
         float[] var4 = this.bf;
         float var5 = var3[0];
         float var6 = var3[0];
         float var7 = var4[0];
         float var8 = var4[0];

         try {
            for (int var9 = 1; var9 < var2; var9++) {
               float var10 = var3[var9];
               float var11 = var4[var9];
               var5 = var10 < var5 ? var10 : var5;
               var6 = var10 > var6 ? var10 : var6;
               var7 = var11 < var7 ? var11 : var7;
               var8 = var11 > var8 ? var11 : var8;
            }
         } catch (RuntimeException var14) {
            throw var14;
         }

         if (var5 == var5 && var7 == var7 && var6 == var6 && var8 == var8) {
            int var15 = (int)Math.floor((double)var5);
            int var16 = (int)Math.floor((double)var7);
            int var17 = Math.max(1, (int)Math.ceil((double)var6) - var15);
            int var12 = Math.max(1, (int)Math.ceil((double)var8) - var16);
            ScreenRect var13 = new ScreenRect(var15, var16, var17, var12);
            if (this.ch != null) {
               var13 = this.ch.intersection(var13);
               if (var13 == null) {
                  return;
               }
            }

            this.bx = var13;
            var1.addSimpleElement(this);
         }
      }
   }

   public void begin(int var1, boolean var2, float var3, int var4, int var5, int var6, int var7, Matrix3x2fc var8, boolean var9) {

      FrameKeeper.i(var1, this.cn);
      this.cc = false;
      this.cd = var9;
      this.ce = w;
      this.cf = x;
      this.cg = y;
      this.ch = null;
      this.ci = false;
      this.co = var2;
      this.cp = var3;
      this.bm = 0;
      this.bn = z > 0;
      this.bp = -1;
      this.cw = false;
      this.cx = var8.m00();
      this.cy = var8.m01();
      this.cz = var8.m10();
      this.da = var8.m11();
      this.db = var8.m20();
      this.dc = var8.m21();
      var4 = Math.floorDiv(var4, 32) * 32;
      var5 = Math.floorDiv(var5, 32) * 32;
      var6 = Math.max(var4 + 32, -Math.floorDiv(-var6, 32) * 32);
      var7 = Math.max(var5 + 32, -Math.floorDiv(-var7, 32) * 32);
      if (this.bx == null || var4 != this.by || var5 != this.bz || var6 != this.ca || var7 != this.cb) {
         this.bx = new ScreenRect(var4, var5, var6 - var4, var7 - var5);
         this.by = var4;
         this.bz = var5;
         this.ca = var6;
         this.cb = var7;
      }
   }

   public void pose(float var1, float var2, float var3, float var4, float var5, float var6) {

      PaneGlassCache var7 = this.twin;
      float var8 = var1 * var4 - var3 * var2;
      boolean var9 = var8 > 1.0E-9F;
      float var10 = var9 ? 1.0F / var8 : 0.0F;
      float var11 = var4 * var10;
      float var12 = -var2 * var10;
      float var13 = -var3 * var10;
      float var14 = var1 * var10;
      float var15 = -(var11 * var5 + var13 * var6);
      float var16 = -(var12 * var5 + var14 * var6);
      this.cw = var9;
      this.cq = var11;
      this.cr = var12;
      this.cs = var13;
      this.ct = var14;
      this.cu = var15;
      this.cv = var16;
      if (var7 != null) {
         var7.cw = var9;
         var7.cq = var11;
         var7.cr = var12;
         var7.cs = var13;
         var7.ct = var14;
         var7.cu = var15;
         var7.cv = var16;
      }
   }

   private boolean c(Matrix3x2fc var1) {

      if (var1 == null) {
         this.dd = 1.0F;
         this.de = 0.0F;
         this.df = 0.0F;
         this.dg = 1.0F;
         this.dh = 0.0F;
         this.di = 0.0F;
         return true;
      } else {
         float var2 = var1.m00();
         float var3 = var1.m01();
         float var4 = var1.m10();
         float var5 = var1.m11();
         float var6 = var1.m20();
         float var7 = var1.m21();
         if (this.cc) {
            this.dd = var2;
            this.de = var3;
            this.df = var4;
            this.dg = var5;
            this.dh = var6;
            this.di = var7;
            return true;
         } else if (this.cw && (var2 != this.cx || var3 != this.cy || var4 != this.cz || var5 != this.da || var6 != this.db || var7 != this.dc)) {
            this.dd = this.cq * var2 + this.cs * var3;
            this.de = this.cr * var2 + this.ct * var3;
            this.df = this.cq * var4 + this.cs * var5;
            this.dg = this.cr * var4 + this.ct * var5;
            this.dh = this.cq * var6 + this.cs * var7 + this.cu;
            this.di = this.cr * var6 + this.ct * var7 + this.cv;
            return true;
         } else {
            return false;
         }
      }
   }

   private void d(float[] var1, float[] var2, int var3) {

      assert var1 != null
         && var2 != null
         && var1 != var2
         && var3 >= 0
         && var3 <= var1.length
         && var3 <= var2.length
         && this.cn != null
         && this.cn.length == 13
         && PX > 0.0F
         && this.be != null
         && this.bf != null
         && this.bg != null
         && this.be.length == this.bf.length
         && this.be.length == this.bg.length
         && this.bm >= 0
         && this.bm <= this.be.length
         && an != null
         && ao != null
         && ap != null
         && aq != null
         && ar != null
         && as != null
         && at != null
         && au != null
         && av != null
         && aw != null
         && ax != null
         && ay != null
         && az != null
         && ba != null
         && bb != null
         && bc != null : "map: bad points";

      float var4 = this.dd;
      float var5 = this.de;
      float var6 = this.df;
      float var7 = this.dg;
      float var8 = this.dh;
      float var9 = this.di;

      try {
         if (!this.cc) {
            float[] var20 = this.cn;
            boolean var21 = this.co;
            float var22 = this.cp;

            for (int var13 = 0; var13 < var3; var13++) {
               float var14 = var1[var13];
               float var15 = var2[var13];
               float var16 = var4 * var14 + var6 * var15 + var8;
               float var17 = var5 * var14 + var7 * var15 + var9;
               var16 = (float)Math.round(var16 * 256.0F) * 0.00390625F;
               var17 = (float)Math.round(var17 * 256.0F) * 0.00390625F;
               if (var21) {
                  var16 = var22 - var16;
               }

               float var18 = var20[6] + var16 * var20[7] + var17 * var20[8];
               var18 = var18 > 0.04F ? var18 : 0.04F;
               var1[var13] = var20[11] + (var20[0] + var16 * var20[1] + var17 * var20[2]) / var18 * var20[9];
               var2[var13] = var20[12] - (var20[3] + var16 * var20[4] + var17 * var20[5]) / var18 * var20[10];
            }
         } else {
            for (int var10 = 0; var10 < var3; var10++) {
               float var11 = var1[var10];
               float var12 = var2[var10];
               var1[var10] = var4 * var11 + var6 * var12 + var8;
               var2[var10] = var5 * var11 + var7 * var12 + var9;
            }
         }
      } catch (RuntimeException var19) {
         throw var19;
      }
   }

   private int e(
      float[] var1,
      float[] var2,
      boolean[] var3,
      int[] var4,
      int var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      int var11,
      float var12,
      boolean var13,
      boolean var14,
      boolean var15,
      boolean var16,
      boolean var17,
      boolean var18
   ) {

      assert var1 != null
         && var2 != null
         && var3 != null
         && var1 != var2
         && var1.length >= 100
         && var2.length >= var1.length
         && var3.length >= var1.length
         && (var4 == null || var4.length >= var1.length)
         && var11 <= 24
         && var10 >= 0.0F
         && var8 >= 0.0F
         && var9 >= 0.0F
         && t.length == 25
         && u.length == 25
         && (var11 <= 0 || t[var11] != null && u[var11] != null && t[var11].length == var11 + 1 && u[var11].length == var11 + 1)
         && var6 == var6
         && var7 == var7
         && var8 == var8
         && var9 == var9
         && var10 == var10
         && var12 == var12
         && PX > 0.0F
         && this.cn != null
         && this.cn.length == 13
         && this.be != null
         && this.bf != null
         && this.bg != null
         && this.be.length == this.bf.length
         && this.be.length == this.bg.length
         && this.bm >= 0 : "outline: bad shape";

      if (var11 < 0) {
         float var19 = this.dd;
         float var20 = this.de;
         float var21 = this.df;
         float var22 = this.dg;
         float var23;
         float var24;
         float var25;
         float var26;
         if (this.cc) {
            var23 = var19;
            var24 = var20;
            var25 = var21;
            var26 = var22;
         } else {
            float[] var27 = this.cn;
            float var28 = var6 + var8 * 0.5F;
            float var29 = var7 + var9 * 0.5F;
            float var30 = var19 * var28 + var21 * var29 + this.dh;
            float var31 = var20 * var28 + var22 * var29 + this.di;
            float var32 = 1.0F;
            if (this.co) {
               var30 = this.cp - var30;
               var32 = -1.0F;
            }

            float var33 = var27[6] + var30 * var27[7] + var31 * var27[8];
            var33 = var33 > 0.04F ? var33 : 0.04F;
            float var34 = var27[0] + var30 * var27[1] + var31 * var27[2];
            float var35 = var27[3] + var30 * var27[4] + var31 * var27[5];
            float var36 = var33 * var33;
            float var37 = (var27[1] * var33 - var34 * var27[7]) / var36 * var27[9];
            float var38 = -(var27[4] * var33 - var35 * var27[7]) / var36 * var27[10];
            float var39 = (var27[2] * var33 - var34 * var27[8]) / var36 * var27[9];
            float var40 = -(var27[5] * var33 - var35 * var27[8]) / var36 * var27[10];
            var23 = var37 * var19 * var32 + var39 * var20;
            var24 = var38 * var19 * var32 + var40 * var20;
            var25 = var37 * var21 * var32 + var39 * var22;
            var26 = var38 * var21 * var32 + var40 * var22;
         }

         float var50 = Math.max(var23 * var23 + var24 * var24, var25 * var25 + var26 * var26);
         float var52 = var50 == var50 ? var12 * (float)Math.sqrt((double)var50) / PX : 0.0F;
         if (!(var52 >= 1.0F)) {
            var11 = 0;
         } else {
            int var54 = (int)Math.ceil((double)(var52 * (float) (Math.PI / 2) / 2.0F));
            var11 = var54 < 2 ? 2 : (var54 > 24 ? 24 : var54);
         }
      }

      this.dj = var11;
      boolean var42 = var17 && (var13 || var14);
      boolean var43 = var17 && (var14 || var16);
      boolean var44 = var17 && (var16 || var15);
      boolean var45 = var17 && (var15 || var13);
      boolean var46 = var13 && var11 > 0;
      boolean var47 = var14 && var11 > 0;
      boolean var48 = var15 && var11 > 0;
      boolean var49 = var16 && var11 > 0;
      float[] var51 = var11 > 0 ? t[var11] : null;
      float[] var53 = var11 > 0 ? u[var11] : null;
      int var55 = 0;

      try {
         if (var46) {
            for (int var56 = 0; var56 <= var11; var56++) {
               var1[var55] = var6 + var10 - var10 * var51[var56];
               var2[var55] = var7 + var10 - var10 * var53[var56];
               var3[var55] = var56 < var11 || var42;
               var55++;
            }
         } else {
            int var57 = var18 && var11 > 0 ? var11 + 1 : 1;

            for (int var65 = 0; var65 < var57; var65++) {
               var1[var55] = var6;
               var2[var55] = var7;
               var3[var55] = var65 < var57 - 1 || var42;
               var55++;
            }
         }

         if (var47) {
            for (int var58 = var11; var58 >= 0; var58--) {
               var1[var55] = var6 + var8 - var10 + var10 * var51[var58];
               var2[var55] = var7 + var10 - var10 * var53[var58];
               var3[var55] = var58 > 0 || var43;
               var55++;
            }
         } else {
            int var59 = var18 && var11 > 0 ? var11 + 1 : 1;

            for (int var66 = 0; var66 < var59; var66++) {
               var1[var55] = var6 + var8;
               var2[var55] = var7;
               var3[var55] = var66 < var59 - 1 || var43;
               var55++;
            }
         }

         if (var49) {
            for (int var60 = 0; var60 <= var11; var60++) {
               var1[var55] = var6 + var8 - var10 + var10 * var51[var60];
               var2[var55] = var7 + var9 - var10 + var10 * var53[var60];
               var3[var55] = var60 < var11 || var44;
               var55++;
            }
         } else {
            int var61 = var18 && var11 > 0 ? var11 + 1 : 1;

            for (int var67 = 0; var67 < var61; var67++) {
               var1[var55] = var6 + var8;
               var2[var55] = var7 + var9;
               var3[var55] = var67 < var61 - 1 || var44;
               var55++;
            }
         }

         if (var48) {
            for (int var62 = var11; var62 >= 0; var62--) {
               var1[var55] = var6 + var10 - var10 * var51[var62];
               var2[var55] = var7 + var9 - var10 + var10 * var53[var62];
               var3[var55] = var62 > 0 || var45;
               var55++;
            }
         } else {
            int var63 = var18 && var11 > 0 ? var11 + 1 : 1;

            for (int var68 = 0; var68 < var63; var68++) {
               var1[var55] = var6;
               var2[var55] = var7 + var9;
               var3[var55] = var68 < var63 - 1 || var45;
               var55++;
            }
         }

         if (var4 != null) {
            for (int var64 = 0; var64 < var55; var64++) {
               var4[var64] = var5;
            }
         }

         return var55;
      } catch (RuntimeException var41) {
         throw var41;
      }
   }

   public void rect(Matrix3x2fc var1, float var2, float var3, float var4, float var5, int var6, int var7) {

      if (var4 < var2) {
         float var8 = var2;
         var2 = var4;
         var4 = var8;
      }

      if (var5 < var3) {
         float var13 = var3;
         var3 = var5;
         var5 = var13;
      }

      if (var4 > var2 && var5 > var3 && (var6 | var7) >>> 24 != 0 && this.c(var1)) {
         if (this.bn) {
            ak = null;
            boolean var15 = this.cc;
            this.m(
               var2,
               var3,
               var4 - var2,
               var5 - var3,
               0.0F,
               0.0F,
               0.0F,
               0.0F,
               !var15,
               !var15,
               !var15,
               !var15,
               var6,
               var7,
               0,
               0.0F,
               -Float.MAX_VALUE,
               Float.MAX_VALUE,
               var15
            );
         } else {
            boolean var14 = !this.cc;
            float[] var9 = an;
            float[] var10 = ao;
            int[] var11 = ap;
            boolean[] var12 = aq;
            var9[0] = var2;
            var10[0] = var3;
            var11[0] = var6;
            var9[1] = var4;
            var10[1] = var3;
            var11[1] = var6;
            var9[2] = var4;
            var10[2] = var5;
            var11[2] = var7;
            var9[3] = var2;
            var10[3] = var5;
            var11[3] = var7;
            var12[0] = var14;
            var12[1] = var14;
            var12[2] = var14;
            var12[3] = var14;
            bd = 4;
            this.i(true);
         }
      }
   }

   public void tri(Matrix3x2fc var1, float var2, float var3, float var4, float var5, float var6, float var7, int var8) {

      if (var8 >>> 24 != 0 && this.c(var1)) {
         float[] var9 = an;
         float[] var10 = ao;
         int[] var11 = ap;
         boolean[] var12 = aq;
         var9[0] = var2;
         var10[0] = var3;
         var9[1] = var4;
         var10[1] = var5;
         var9[2] = var6;
         var10[2] = var7;
         var11[0] = var8;
         var11[1] = var8;
         var11[2] = var8;
         var12[0] = true;
         var12[1] = true;
         var12[2] = true;
         bd = 3;
         this.i(true);
      }
   }

   public void convex(Matrix3x2fc var1, float[] var2, int[] var3, int var4) {

      if (var4 >= 3 && var4 <= 16 && var2.length >= var4 * 2 && var3.length >= var4 && this.c(var1)) {
         float[] var5 = an;
         float[] var6 = ao;
         int[] var7 = ap;
         boolean[] var8 = aq;

         for (int var9 = 0; var9 < var4; var9++) {
            var5[var9] = var2[var9 * 2];
            var6[var9] = var2[var9 * 2 + 1];
            var7[var9] = var3[var9];
            var8[var9] = true;
         }

         bd = var4;
         this.i(true);
      }
   }

   public void round(
      Matrix3x2fc var1, float var2, float var3, float var4, float var5, float var6, int var7, boolean var8, boolean var9, boolean var10, boolean var11
   ) {

      if (var4 > 0.0F && var5 > 0.0F && var7 >>> 24 != 0 && this.c(var1)) {
         float var12 = var6 < 0.0F ? 0.0F : Math.min(var6, Math.min(var4, var5) * 0.5F);
         if (this.bn) {
            int var13 = this.bm;
            boolean var14 = this.m(
               var2,
               var3,
               var4,
               var5,
               var8 ? var12 : 0.0F,
               var9 ? var12 : 0.0F,
               var10 ? var12 : 0.0F,
               var11 ? var12 : 0.0F,
               var8 || var9,
               var9 || var11,
               var11 || var10,
               var10 || var8,
               var7,
               var7,
               0,
               0.0F,
               -Float.MAX_VALUE,
               Float.MAX_VALUE,
               false
            );
            if (var14 && var8 && var9 && var10 && var11 && !this.cd && !this.dk && this.bm > var13) {
               ak = this;
               this.bo = var13;
               this.bp = this.bm;
               this.bq = false;
               this.br = var2;
               this.bs = var3;
               this.bt = var4;
               this.bu = var5;
               this.bv = var12;
               float[] var15 = this.bw;
               var15[0] = this.dd;
               var15[1] = this.de;
               var15[2] = this.df;
               var15[3] = this.dg;
               var15[4] = this.dh;
               var15[5] = this.di;
            } else {
               ak = null;
            }
         } else {
            bd = this.e(an, ao, aq, ap, var7, var2, var3, var4, var5, var12, var12 > 0.0F ? -1 : 0, var12, var8, var9, var10, var11, true, false);
            this.i(true);
         }
      }
   }

   public boolean roundV(
      Matrix3x2fc var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      int var7,
      int var8,
      boolean var9,
      boolean var10,
      boolean var11,
      boolean var12
   ) {

      if (this.bn && var4 > 0.0F && var5 > 0.0F && (var7 | var8) >>> 24 != 0 && this.c(var1)) {
         float var13 = var6 < 0.0F ? 0.0F : Math.min(var6, Math.min(var4, var5) * 0.5F);
         ak = null;
         return this.m(
            var2,
            var3,
            var4,
            var5,
            var9 ? var13 : 0.0F,
            var10 ? var13 : 0.0F,
            var11 ? var13 : 0.0F,
            var12 ? var13 : 0.0F,
            var9 || var10,
            var10 || var12,
            var12 || var11,
            var11 || var9,
            var7,
            var8,
            0,
            0.0F,
            -Float.MAX_VALUE,
            Float.MAX_VALUE,
            false
         );
      } else {
         return false;
      }
   }

   public void cut(Matrix3x2fc var1, float var2, float var3, float var4, float var5, float var6, int var7, float var8, boolean var9) {

      if (var4 > 0.0F && var5 > 0.0F && var7 >>> 24 != 0 && this.c(var1)) {
         if (var9 ? var8 < var3 + var5 : var8 > var3) {
            float var10 = var6 < 0.0F ? 0.0F : Math.min(var6, Math.min(var4, var5) * 0.5F);
            if (this.bn) {
               ak = null;
               this.m(
                  var2,
                  var3,
                  var4,
                  var5,
                  var10,
                  var10,
                  var10,
                  var10,
                  true,
                  true,
                  true,
                  true,
                  var7,
                  var7,
                  0,
                  0.0F,
                  var9 ? var8 : -Float.MAX_VALUE,
                  var9 ? Float.MAX_VALUE : var8,
                  false
               );
            } else {
               int var11 = this.e(ar, as, au, null, 0, var2, var3, var4, var5, var10, var10 > 0.0F ? -1 : 0, var10, true, true, true, true, true, false);
               bd = f(var11, var8, var9, var7);
               this.i(true);
            }
         }
      }
   }

   private static int f(int var0, float var1, boolean var2, int var3) {

      assert var0 >= 0
         && var0 <= 116
         && ar != null
         && as != null
         && au != null
         && an != null
         && ao != null
         && aq != null
         && ap != null
         && ar != an
         && as != ao
         && au != aq
         && ar.length == 116
         && as.length == 116
         && au.length == 116
         && an.length == 116
         && ao.length == 116
         && aq.length == 116
         && ap.length == 116
         && var1 == var1
         && t.length == 25
         && u.length == 25
         && PX > 0.0F
         && av.length == 116
         && aw.length == 116 : "cutLine:" + " bad outli" + "ne";

      float[] var4 = ar;
      float[] var5 = as;
      float[] var6 = an;
      float[] var7 = ao;
      boolean[] var8 = au;
      boolean[] var9 = aq;
      int var10 = 0;

      try {
         for (int var11 = 0; var11 < var0; var11++) {
            int var12 = var11 + 1 < var0 ? var11 + 1 : 0;
            float var13 = var5[var11];
            float var14 = var5[var12];
            boolean var15 = var2 ? var13 >= var1 : var13 <= var1;
            boolean var16 = var2 ? var14 >= var1 : var14 <= var1;
            if (var15 && var16) {
               var6[var10] = var4[var12];
               var7[var10] = var14;
               var9[var10] = var8[var12];
               var10++;
            } else if (var15) {
               float var17 = (var1 - var13) / (var14 - var13);
               var6[var10] = var4[var11] + (var4[var12] - var4[var11]) * var17;
               var7[var10] = var1;
               var9[var10] = false;
               var10++;
            } else if (var16) {
               float var22 = (var1 - var13) / (var14 - var13);
               var6[var10] = var4[var11] + (var4[var12] - var4[var11]) * var22;
               var7[var10] = var1;
               var9[var10] = var8[var11];
               var10++;
               var6[var10] = var4[var12];
               var7[var10] = var14;
               var9[var10] = var8[var12];
               var10++;
            }
         }

         int[] var20 = ap;

         for (int var21 = 0; var21 < var10; var21++) {
            var20[var21] = var3;
         }

         return var10;
      } catch (RuntimeException var18) {
         throw var18;
      }
   }

   private void g() {

      assert bd >= 0
         && bd <= 116
         && an != null
         && ao != null
         && ap != null
         && aq != null
         && ar != null
         && as != null
         && at != null
         && au != null
         && an != ar
         && ao != as
         && ap != at
         && aq != au
         && an.length == 116
         && ao.length == 116
         && ap.length == 116
         && aq.length == 116
         && ar.length == 116
         && as.length == 116
         && at.length == 116
         && au.length == 116
         && this.ci
         && this.cj == this.cj
         && this.ck == this.ck
         && this.cl == this.cl
         && this.cm == this.cm
         && PX > 0.0F
         && t.length == 25 : "clipQ: bad polygon";

      int var1 = bd;
      float var2 = this.cj;
      float var3 = this.ck;
      float var4 = this.cl;
      float var5 = this.cm;

      try {
         boolean var6 = true;

         for (int var7 = 0; var7 < var1; var7++) {
            float var8 = an[var7];
            float var9 = ao[var7];
            if (var8 < var2 || var8 > var4 || var9 < var3 || var9 > var5) {
               var6 = false;
               break;
            }
         }

         if (!var6) {
            float[] var35 = an;
            float[] var36 = ao;
            float[] var37 = ar;
            float[] var10 = as;
            int[] var11 = ap;
            int[] var12 = at;
            boolean[] var13 = aq;
            boolean[] var14 = au;

            for (int var15 = 0; var15 < 4 && var1 > 0; var15++) {
               float var16 = var15 == 0 ? var2 : (var15 == 1 ? var3 : (var15 == 2 ? var4 : var5));
               boolean var17 = var15 == 0 || var15 == 2;
               boolean var18 = var15 < 2;
               int var19 = 0;

               for (int var20 = 0; var20 < var1 && var19 < 114; var20++) {
                  int var21 = var20 + 1 < var1 ? var20 + 1 : 0;
                  float var22 = var17 ? var35[var20] : var36[var20];
                  float var23 = var17 ? var35[var21] : var36[var21];
                  boolean var24 = var18 ? var22 >= var16 : var22 <= var16;
                  boolean var25 = var18 ? var23 >= var16 : var23 <= var16;
                  if (var24 && var25) {
                     var37[var19] = var35[var21];
                     var10[var19] = var36[var21];
                     var12[var19] = var11[var21];
                     var14[var19] = var13[var21];
                     var19++;
                  } else if (var24 || var25) {
                     float var26 = (var16 - var22) / (var23 - var22);
                     var26 = var26 < 0.0F ? 0.0F : (var26 > 1.0F ? 1.0F : var26);
                     int var27 = var11[var20];
                     int var28 = var11[var21];
                     int var29 = var27;
                     if (var27 != var28) {
                        int var30 = var27 >>> 24;
                        int var31 = var27 >> 16 & (902485066 ^ 902485173);
                        int var32 = var27 >> 8 & (-518798022 ^ -518797883);
                        int var33 = var27 & (-1076482887 ^ -1076483002);
                        var29 = Math.round((float)var30 + (float)((var28 >>> 24) - var30) * var26) << 24
                           | Math.round((float)var31 + (float)((var28 >> 16 & (713096622 ^ 713096529)) - var31) * var26) << 16
                           | Math.round((float)var32 + (float)((var28 >> 8 & (1845559235 ^ 1845559100)) - var32) * var26) << 8
                           | Math.round((float)var33 + (float)((var28 & (-30707866 ^ -30707815)) - var33) * var26);
                     }

                     var37[var19] = var17 ? var16 : var35[var20] + (var35[var21] - var35[var20]) * var26;
                     var10[var19] = var17 ? var36[var20] + (var36[var21] - var36[var20]) * var26 : var16;
                     var12[var19] = var29;
                     if (var24) {
                        var14[var19] = false;
                        var19++;
                     } else {
                        var14[var19] = var13[var20];
                        var19++;
                        var37[var19] = var35[var21];
                        var10[var19] = var36[var21];
                        var12[var19] = var11[var21];
                        var14[var19] = var13[var21];
                        var19++;
                     }
                  }
               }

               var1 = var19;
               float[] var39 = var35;
               float[] var40 = var36;
               int[] var41 = var11;
               boolean[] var42 = var13;
               var35 = var37;
               var36 = var10;
               var11 = var12;
               var13 = var14;
               var37 = var39;
               var10 = var40;
               var12 = var41;
               var14 = var42;
            }

            bd = var1;
         }
      } catch (RuntimeException var34) {
         throw var34;
      }
   }

   public void frost(
      Matrix3x2fc var1, float var2, float var3, float var4, float var5, float var6, int var7, boolean var8, boolean var9, boolean var10, boolean var11
   ) {

      PaneGlassCache var12 = this.twin;
      if (var12 != null) {
         var12.round(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11);
      }
   }

   public void shadow(Matrix3x2fc var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9) {

      if (var4 > 0.0F && var5 > 0.0F && var9 >>> 24 != 0 && var7 > 0.0F && this.c(var1)) {
         float var10 = var6 < 0.0F ? 0.0F : Math.min(var6, Math.min(var4, var5) * 0.5F);
         float var11 = var7 * 0.42F;
         float var12 = var8 * 0.42F;
         boolean[] var13 = aq;
         int var14 = this.e(
            az, ba, var13, null, 0, var2, var3, var4, var5, var10, -1, var10 + var7, var10 > 0.0F, var10 > 0.0F, var10 > 0.0F, var10 > 0.0F, true, true
         );
         int var15 = this.dj;
         if (var15 != 0) {
            this.e(
               av,
               aw,
               var13,
               null,
               0,
               var2 - var11,
               var3 - var11 + var12,
               var4 + 2.0F * var11,
               var5 + 2.0F * var11,
               var10 + var11,
               var15,
               0.0F,
               true,
               true,
               true,
               true,
               true,
               true
            );
            this.e(
               ax,
               ay,
               var13,
               null,
               0,
               var2 - var7,
               var3 - var7 + var8,
               var4 + 2.0F * var7,
               var5 + 2.0F * var7,
               var10 + var7,
               var15,
               0.0F,
               true,
               true,
               true,
               true,
               true,
               true
            );
            this.d(az, ba, var14);
            this.d(av, aw, var14);
            this.d(ax, ay, var14);
            this.h(var14, var9, Math.round((float)(var9 >>> 24) * 0.3F) << 24 | var9 & (-590634898 ^ -600547439), var9 & (46497963 ^ 37388116));
         }
      }
   }

   private void h(int var1, int var2, int var3, int var4) {

      assert var1 >= 0
         && var1 <= 116
         && az != null
         && ba != null
         && av != null
         && aw != null
         && ax != null
         && ay != null
         && az.length == 116
         && ba.length == 116
         && av.length == 116
         && aw.length == 116
         && ax.length == 116
         && ay.length == 116
         && this.be != null
         && this.bf != null
         && this.bg != null
         && this.be.length == this.bf.length
         && this.be.length == this.bg.length
         && this.bm >= 0
         && this.bm <= this.be.length
         && (this.bm & 3) == 0
         && az != av
         && av != ax
         && ba != aw
         && aw != ay
         && PX > 0.0F
         && t.length == 25 : "ring: bad" + " contours";

      ak = null;
      int var5 = this.bm;

      try {
         float var6 = 0.0F;
         int var7 = 0;

         for (int var8 = var1 - 1; var7 < var1; var8 = var7++) {
            var6 += ax[var8] * ay[var7] - ax[var7] * ay[var8];
         }

         if (var6 == var6 && var6 != 0.0F) {
            boolean var22 = var6 > 0.0F;
            if (this.bm + var1 * 8 > this.be.length) {
               this.p(this.bm + var1 * 8);
            }

            int var23 = this.bm;
            float[] var9 = this.be;
            float[] var10 = this.bf;
            int[] var11 = this.bg;

            for (int var12 = 0; var12 < 2; var12++) {
               float[] var13 = var12 == 0 ? az : av;
               float[] var14 = var12 == 0 ? ba : aw;
               float[] var15 = var12 == 0 ? av : ax;
               float[] var16 = var12 == 0 ? aw : ay;
               int var17 = var12 == 0 ? var2 : var3;
               int var18 = var12 == 0 ? var3 : var4;

               for (int var19 = 0; var19 < var1; var19++) {
                  int var20 = var19 + 1 < var1 ? var19 + 1 : 0;
                  if (!var22) {
                     var9[var23] = var15[var19];
                     var10[var23] = var16[var19];
                     var11[var23++] = var18;
                     var9[var23] = var15[var20];
                     var10[var23] = var16[var20];
                     var11[var23++] = var18;
                     var9[var23] = var13[var20];
                     var10[var23] = var14[var20];
                     var11[var23++] = var17;
                     var9[var23] = var13[var19];
                     var10[var23] = var14[var19];
                     var11[var23++] = var17;
                  } else {
                     var9[var23] = var15[var19];
                     var10[var23] = var16[var19];
                     var11[var23++] = var18;
                     var9[var23] = var13[var19];
                     var10[var23] = var14[var19];
                     var11[var23++] = var17;
                     var9[var23] = var13[var20];
                     var10[var23] = var14[var20];
                     var11[var23++] = var17;
                     var9[var23] = var15[var20];
                     var10[var23] = var16[var20];
                     var11[var23++] = var18;
                  }
               }
            }

            this.bm = var23;
            if (this.bn) {
               float[] var30 = this.bh;
               float[] var31 = this.bi;
               float[] var32 = this.bj;
               int[] var33 = this.bk;
               int[] var34 = this.bl;

               for (int var35 = var5; var35 < var23; var35++) {
                  var30[var35] = 1.0F;
                  var31[var35] = 0.0F;
                  var32[var35] = 0.0F;
                  var33[var35] = 0;
                  var34[var35] = 1;
               }
            }
         }
      } catch (RuntimeException var21) {
         throw var21;
      }
   }

   private void i(boolean var1) {

      assert bd >= 0
         && bd <= 116
         && an != null
         && ao != null
         && ap != null
         && aq != null
         && az != null
         && ba != null
         && ax != null
         && ay != null
         && bb != null
         && bc != null
         && an.length == 116
         && ao.length == 116
         && ap.length == 116
         && aq.length == 116
         && az.length == 116
         && ba.length == 116
         && ax.length == 116
         && ay.length == 116
         && bb.length == 116
         && bc.length == 116
         && this.be != null
         && this.bf != null
         && this.bg != null
         && this.be.length == this.bf.length
         && this.be.length == this.bg.length
         && this.bm >= 0
         && this.bm <= this.be.length
         && (this.bm & 3) == 0
         && PX > 0.0F
         && an != az
         && ao != ba : "poly: bad po" + "l" + "ygon";

      float[] var2 = an;
      float[] var3 = ao;
      int[] var4 = ap;
      boolean[] var5 = aq;
      int var6 = this.bm;
      ak = null;

      try {
         if (var1) {
            int var7 = bd;
            float var8 = this.dd;
            float var9 = this.de;
            float var10 = this.df;
            float var11 = this.dg;
            float var12 = this.dh;
            float var13 = this.di;
            if (this.cc) {
               for (int var49 = 0; var49 < var7; var49++) {
                  float var52 = var2[var49];
                  float var55 = var3[var49];
                  var2[var49] = var8 * var52 + var10 * var55 + var12;
                  var3[var49] = var9 * var52 + var11 * var55 + var13;
               }
            } else {
               float[] var14 = this.cn;
               boolean var15 = this.co;
               float var16 = this.cp;

               for (int var17 = 0; var17 < var7; var17++) {
                  float var18 = var2[var17];
                  float var19 = var3[var17];
                  float var20 = var8 * var18 + var10 * var19 + var12;
                  float var21 = var9 * var18 + var11 * var19 + var13;
                  var20 = (float)Math.round(var20 * 256.0F) * 0.00390625F;
                  var21 = (float)Math.round(var21 * 256.0F) * 0.00390625F;
                  if (var15) {
                     var20 = var16 - var20;
                  }

                  float var22 = var14[6] + var20 * var14[7] + var21 * var14[8];
                  var22 = var22 > 0.04F ? var22 : 0.04F;
                  var2[var17] = var14[11] + (var14[0] + var20 * var14[1] + var21 * var14[2]) / var22 * var14[9];
                  var3[var17] = var14[12] - (var14[3] + var20 * var14[4] + var21 * var14[5]) / var22 * var14[10];
               }
            }

            if (this.ci) {
               this.g();
            }
         }

         int var34 = bd;
         if (var34 >= 3) {
            int var35 = 0;

            for (int var36 = 0; var36 < var34; var36++) {
               if (var35 > 0) {
                  float var39 = var2[var36] - var2[var35 - 1];
                  float var42 = var3[var36] - var3[var35 - 1];
                  if (var39 * var39 + var42 * var42 < 1.0E-8F) {
                     var5[var35 - 1] = var5[var36];
                     continue;
                  }
               }

               var2[var35] = var2[var36];
               var3[var35] = var3[var36];
               var4[var35] = var4[var36];
               var5[var35] = var5[var36];
               var35++;
            }

            while (var35 >= 3) {
               float var37 = var2[0] - var2[var35 - 1];
               float var40 = var3[0] - var3[var35 - 1];
               if (!(var37 * var37 + var40 * var40 < 1.0E-8F)) {
                  break;
               }

               var35--;
            }

            if (var35 >= 3) {
               float var38 = 0.0F;
               float var41 = 0.0F;
               int var43 = 0;

               for (int var45 = var35 - 1; var43 < var35; var45 = var43++) {
                  var38 += var2[var45] * var3[var43] - var2[var43] * var3[var45];
                  float var47 = var2[var43] - var2[var45];
                  float var50 = var3[var43] - var3[var45];
                  var41 += (float)Math.sqrt((double)(var47 * var47 + var50 * var50));
               }

               if (var38 == var38 && var41 > 0.0F && !(Math.abs(var38) < 1.0E-7F)) {
                  boolean var44 = var38 > 0.0F;
                  float var46 = var44 ? -1.0F : 1.0F;
                  float var48 = PX * 0.5F;
                  boolean var51 = false;

                  for (int var53 = 0; var53 < var35; var53++) {
                     var51 |= var5[var53];
                  }

                  float var54 = Math.abs(var38) / var41;
                  boolean var56 = var51 && var54 < PX;
                  float var57 = var56 ? var54 / (var54 + PX) : 1.0F;

                  for (int var58 = 0; var58 < var35; var58++) {
                     int var60 = var58 + 1 < var35 ? var58 + 1 : 0;
                     float var64 = var2[var60] - var2[var58];
                     float var77 = var3[var60] - var3[var58];
                     float var81 = (float)Math.sqrt((double)(var64 * var64 + var77 * var77));
                     if (var81 > 1.0E-6F) {
                        bb[var58] = -var77 * var46 / var81;
                        bc[var58] = var64 * var46 / var81;
                     } else {
                        bb[var58] = 0.0F;
                        bc[var58] = 0.0F;
                     }
                  }

                  float var59 = 3.0F * var48;

                  for (int var61 = 0; var61 < var35; var61++) {
                     int var65 = var61 > 0 ? var61 - 1 : var35 - 1;
                     float var78 = var5[var65] ? var48 : 0.0F;
                     float var82 = var5[var61] ? var48 : 0.0F;
                     float var23 = 0.0F;
                     float var24 = 0.0F;
                     if (var78 > 0.0F || var82 > 0.0F) {
                        float var25 = bb[var65];
                        float var26 = bc[var65];
                        float var27 = bb[var61];
                        float var28 = bc[var61];
                        float var29 = var25 * var28 - var26 * var27;
                        if (!(var29 > 0.001F) && !(var29 < -0.001F)) {
                           float var30 = Math.max(var78, var82);
                           float var31 = var78 >= var82 ? var25 : var27;
                           float var32 = var78 >= var82 ? var26 : var28;
                           var23 = var31 * var30;
                           var24 = var32 * var30;
                        } else {
                           var23 = (var28 * var78 - var26 * var82) / var29;
                           var24 = (var25 * var82 - var27 * var78) / var29;
                        }

                        float var100 = var23 * var23 + var24 * var24;
                        if (var100 > var59 * var59) {
                           float var101 = var59 / (float)Math.sqrt((double)var100);
                           var23 *= var101;
                           var24 *= var101;
                        }
                     }

                     if (var56) {
                        az[var61] = var2[var61];
                        ba[var61] = var3[var61];
                        ax[var61] = var2[var61] + 2.0F * var23;
                        ay[var61] = var3[var61] + 2.0F * var24;
                     } else {
                        az[var61] = var2[var61] - var23;
                        ba[var61] = var3[var61] - var24;
                        ax[var61] = var2[var61] + var23;
                        ay[var61] = var3[var61] + var24;
                     }

                     int var88 = var4[var61];
                     if (var57 < 1.0F) {
                        var88 = Math.round((float)(var88 >>> 24) * var57) << 24 | var88 & (-1966218889 ^ -1976426872);
                     }

                     var4[var61] = var88;
                  }

                  int var62 = (var35 - 1) / 2 + (var51 ? var35 : 0);
                  if (this.bm + var62 * 4 > this.be.length) {
                     this.p(this.bm + var62 * 4);
                  }

                  int var66 = this.bm;
                  float[] var79 = this.be;
                  float[] var83 = this.bf;
                  int[] var84 = this.bg;

                  for (byte var85 = 1; var85 < var35 - 1; var85 += 2) {
                     int var89 = var85 + 2 < var35 ? var85 + 2 : var85 + 1;
                     int var92 = var44 ? var89 : var85;
                     int var95 = var44 ? var85 : var89;
                     var79[var66] = az[0];
                     var83[var66] = ba[0];
                     var84[var66++] = var4[0];
                     var79[var66] = az[var92];
                     var83[var66] = ba[var92];
                     var84[var66++] = var4[var92];
                     var79[var66] = az[var85 + 1];
                     var83[var66] = ba[var85 + 1];
                     var84[var66++] = var4[var85 + 1];
                     var79[var66] = az[var95];
                     var83[var66] = ba[var95];
                     var84[var66++] = var4[var95];
                  }

                  if (var51) {
                     for (int var86 = 0; var86 < var35; var86++) {
                        if (var5[var86]) {
                           int var90 = var86 + 1 < var35 ? var86 + 1 : 0;
                           int var93 = var4[var86];
                           int var96 = var4[var90];
                           if (!var44) {
                              var79[var66] = ax[var86];
                              var83[var66] = ay[var86];
                              var84[var66++] = var93 & (1963487056 ^ 1979158703);
                              var79[var66] = ax[var90];
                              var83[var66] = ay[var90];
                              var84[var66++] = var96 & (-2068738467 ^ -2075233886);
                              var79[var66] = az[var90];
                              var83[var66] = ba[var90];
                              var84[var66++] = var96;
                              var79[var66] = az[var86];
                              var83[var66] = ba[var86];
                              var84[var66++] = var93;
                           } else {
                              var79[var66] = ax[var86];
                              var83[var66] = ay[var86];
                              var84[var66++] = var93 & (1315985882 ^ 1318037029);
                              var79[var66] = az[var86];
                              var83[var66] = ba[var86];
                              var84[var66++] = var93;
                              var79[var66] = az[var90];
                              var83[var66] = ba[var90];
                              var84[var66++] = var96;
                              var79[var66] = ax[var90];
                              var83[var66] = ay[var90];
                              var84[var66++] = var96 & (-851500757 ^ -842998060);
                           }
                        }
                     }
                  }

                  this.bm = var66;
                  if (this.bn) {
                     float[] var87 = this.bh;
                     float[] var91 = this.bi;
                     float[] var94 = this.bj;
                     int[] var97 = this.bk;
                     int[] var98 = this.bl;

                     for (int var99 = var6; var99 < var66; var99++) {
                        var87[var99] = 1.0F;
                        var91[var99] = 0.0F;
                        var94[var99] = 0.0F;
                        var97[var99] = 0;
                        var98[var99] = 1;
                     }
                  }
               }
            }
         }
      } catch (RuntimeException var33) {
         throw var33;
      }
   }

   public void stroke(Matrix3x2fc var1, float var2, float var3, float var4, float var5, float var6, int var7) {

      if (var4 > 0.0F && var5 > 0.0F && var7 >>> 24 != 0 && this.c(var1)) {
         float var8 = var6 < 0.0F ? 0.0F : Math.min(var6, Math.min(var4, var5) * 0.5F);
         if (!this.bn) {
            ak = null;
            int var9 = this.e(ar, as, au, null, 0, var2, var3, var4, var5, var8, var8 > 0.0F ? -1 : 0, var8, true, true, true, true, true, false);
            this.d(ar, as, var9);
            var9 = this.j(var9);
            if (var9 >= 3) {
               this.h(var9, var7 & (-979834471 ^ -983099802), var7, var7 & (-126700616 ^ -124957625));
            }
         } else if (!this.k(var2, var3, var4, var5, var8, var7)) {
            ak = null;
            this.m(var2, var3, var4, var5, var8, var8, var8, var8, true, true, true, true, 0, 0, var7, 1.0F, -Float.MAX_VALUE, Float.MAX_VALUE, false);
         }
      }
   }

   private int j(int var1) {

      assert var1 >= 0
         && var1 <= 116
         && ar != null
         && as != null
         && az != null
         && ba != null
         && av != null
         && aw != null
         && ax != null
         && ay != null
         && bb != null
         && bc != null
         && ar.length == 116
         && as.length == 116
         && az.length == 116
         && ba.length == 116
         && av.length == 116
         && aw.length == 116
         && ax.length == 116
         && ay.length == 116
         && bb.length == 116
         && bc.length == 116
         && PX > 0.0F : "lineRing: b" + "a" + "d outline";

      int var2 = 0;

      try {
         for (int var3 = 0; var3 < var1; var3++) {
            float var4 = ar[var3];
            float var5 = as[var3];
            if (var4 != var4 || var5 != var5) {
               return 0;
            }

            if (var2 > 0) {
               float var6 = var4 - ar[var2 - 1];
               float var7 = var5 - as[var2 - 1];
               if (var6 * var6 + var7 * var7 < 1.0E-8F) {
                  continue;
               }
            }

            ar[var2] = var4;
            as[var2] = var5;
            var2++;
         }

         while (var2 >= 3) {
            float var19 = ar[0] - ar[var2 - 1];
            float var21 = as[0] - as[var2 - 1];
            if (!(var19 * var19 + var21 * var21 < 1.0E-8F)) {
               break;
            }

            var2--;
         }

         if (var2 < 3) {
            return 0;
         } else {
            float var20 = 0.0F;
            int var22 = 0;

            for (int var24 = var2 - 1; var22 < var2; var24 = var22++) {
               var20 += ar[var24] * as[var22] - ar[var22] * as[var24];
            }

            if (var20 == var20 && !(Math.abs(var20) < 1.0E-7F)) {
               float var23 = var20 > 0.0F ? -1.0F : 1.0F;

               for (int var25 = 0; var25 < var2; var25++) {
                  int var27 = var25 + 1 < var2 ? var25 + 1 : 0;
                  float var29 = ar[var27] - ar[var25];
                  float var8 = as[var27] - as[var25];
                  float var9 = (float)Math.sqrt((double)(var29 * var29 + var8 * var8));
                  bb[var25] = var9 > 1.0E-6F ? -var8 * var23 / var9 : 0.0F;
                  bc[var25] = var9 > 1.0E-6F ? var29 * var23 / var9 : 0.0F;
               }

               float var26 = PX;

               for (int var28 = 0; var28 < var2; var28++) {
                  int var30 = var28 > 0 ? var28 - 1 : var2 - 1;
                  float var31 = bb[var30];
                  float var32 = bc[var30];
                  float var10 = bb[var28];
                  float var11 = bc[var28];
                  float var12 = var31 * var11 - var32 * var10;
                  float var13;
                  float var14;
                  if (!(var12 > 0.001F) && !(var12 < -0.001F)) {
                     var13 = var31;
                     var14 = var32;
                  } else {
                     var13 = (var11 - var32) / var12;
                     var14 = (var31 - var10) / var12;
                  }

                  float var15 = var13 * var13 + var14 * var14;
                  if (var15 > 9.0F) {
                     float var16 = 3.0F / (float)Math.sqrt((double)var15);
                     var13 *= var16;
                     var14 *= var16;
                  }

                  var13 *= var26;
                  var14 *= var26;
                  float var35 = ar[var28];
                  float var17 = as[var28];
                  az[var28] = var35 - 0.5F * var13;
                  ba[var28] = var17 - 0.5F * var14;
                  av[var28] = var35 + 0.5F * var13;
                  aw[var28] = var17 + 0.5F * var14;
                  ax[var28] = var35 + 1.5F * var13;
                  ay[var28] = var17 + 1.5F * var14;
               }

               return var2;
            } else {
               return 0;
            }
         }
      } catch (RuntimeException var18) {
         throw var18;
      }
   }

   public static boolean fuseLast(Matrix3x2fc var0, float var1, float var2, float var3, float var4, float var5, int var6) {

      PaneGlassCache var7 = ak;
      if (var7 != null && var6 >>> 24 != 0 && var3 > 0.0F && var4 > 0.0F && var7.c(var0)) {
         float var8 = var5 < 0.0F ? 0.0F : Math.min(var5, Math.min(var3, var4) * 0.5F);
         return var7.k(var1, var2, var3, var4, var8, var6);
      } else {
         return false;
      }
   }

   private boolean k(float var1, float var2, float var3, float var4, float var5, int var6) {

      assert this.bk != null
         && this.bl != null
         && this.bk.length == this.bl.length
         && this.bp <= this.bk.length
         && this.be.length == this.bk.length
         && this.bh.length == this.bk.length
         && this.bi.length == this.bk.length
         && this.bj.length == this.bk.length
         && this.bg.length == this.bk.length
         && PX > 0.0F
         && al != null
         && am >= 0
         && this.bm >= 0
         && this.bw.length == 12
         && var1 == var1
         && var2 == var2
         && var3 == var3
         && var4 == var4
         && var5 == var5 : "fuse" + ": " + "bad" + " element";

      float[] var7 = this.bw;
      if (ak == this
         && this.bn
         && !this.cd
         && !this.bq
         && this.bp == this.bm
         && this.bo < this.bp
         && this.bo >= 0
         && var1 == this.br
         && var2 == this.bs
         && var3 == this.bt
         && var4 == this.bu
         && var5 == this.bv
         && var7[0] == this.dd
         && var7[1] == this.de
         && var7[2] == this.df
         && var7[3] == this.dg
         && var7[4] == this.dh
         && var7[5] == this.di) {
         int var8 = l(var6);
         int var9 = Math.round(16.0F) << 2;
         int[] var10 = this.bk;
         int[] var11 = this.bl;

         try {
            int var12 = this.bo;

            for (int var13 = this.bp; var12 < var13; var12++) {
               var10[var12] = var8;
               var11[var12] = var11[var12] & (-1423623252 ^ 1423588268) | var9 | 0;
            }
         } catch (RuntimeException var14) {
            throw var14;
         }

         this.bq = true;
         return true;
      } else {
         return false;
      }
   }

   private static int l(int var0) {

      return (var0 >> 16 & (-1303420997 ^ -1303421116)) << 24
         | (var0 >> 8 & (-2122008733 ^ -2122008676)) << 16
         | (var0 & (686476967 ^ 686476888)) << 8
         | var0 >>> 24;
   }

   private boolean m(
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      boolean var9,
      boolean var10,
      boolean var11,
      boolean var12,
      int var13,
      int var14,
      int var15,
      float var16,
      float var17,
      float var18,
      boolean var19
   ) {

      assert var1 == var1
         && var2 == var2
         && var3 == var3
         && var4 == var4
         && var5 >= 0.0F
         && var6 >= 0.0F
         && var7 >= 0.0F
         && var8 >= 0.0F
         && var16 >= 0.0F
         && var17 == var17
         && var18 == var18
         && PX > 0.0F
         && this.cn != null
         && this.cn.length == 13
         && this.be != null
         && this.be.length == this.bl.length
         && this.be.length == this.bh.length
         && this.be.length == this.bi.length
         && this.be.length == this.bj.length
         && this.be.length == this.bk.length
         && this.be.length == this.bg.length
         && this.bm >= 0
         && (this.bm & 3) == 0
         && this.bn
         && dl.length == 16
         && dm.length == 16
         && dn.length == 16
         && _kwren_do.length == 16
         && dp.length == 16
         && dq.length == 16
         && dr.length == 4
         && ds.length == 4
         && dt.length == 12
         && du.length == 12
         && ed.length == 12
         && (!var19 || this.cc) : "shape: bad sh" + "a" + "pe";

      this.dk = false;
      float var20 = this.dd;
      float var21 = this.de;
      float var22 = this.df;
      float var23 = this.dg;
      float var24 = this.dh;
      float var25 = this.di;
      boolean var26 = this.cc;
      boolean var27 = this.co;
      float var28 = this.cp;
      float[] var29 = this.cn;
      float[] var30 = dl;
      float[] var31 = dm;
      float[] var32 = dn;
      float[] var33 = _kwren_do;
      float[] var34 = dp;
      int[] var35 = dq;
      boolean var36 = false;

      try {
         float var37;
         float var38;
         if (var26) {
            var37 = (float)Math.sqrt((double)(var20 * var20 + var21 * var21)) / PX;
            var38 = (float)Math.sqrt((double)(var22 * var22 + var23 * var23)) / PX;
         } else {
            float var39 = var27 ? -1.0F : 1.0F;
            var37 = Float.MAX_VALUE;
            var38 = Float.MAX_VALUE;

            for (int var40 = 0; var40 < 4; var40++) {
               float var41 = (var40 & 1) == 0 ? var1 : var1 + var3;
               float var42 = (var40 & 2) == 0 ? var2 : var2 + var4;
               float var43 = var20 * var41 + var22 * var42 + var24;
               float var44 = var21 * var41 + var23 * var42 + var25;
               if (var27) {
                  var43 = var28 - var43;
               }

               float var45 = var29[6] + var43 * var29[7] + var44 * var29[8];
               var45 = var45 > 0.04F ? var45 : 0.04F;
               float var46 = var29[0] + var43 * var29[1] + var44 * var29[2];
               float var47 = var29[3] + var43 * var29[4] + var44 * var29[5];
               float var48 = var45 * var45;
               float var49 = (var29[1] * var45 - var46 * var29[7]) / var48 * var29[9];
               float var50 = -(var29[4] * var45 - var47 * var29[7]) / var48 * var29[10];
               float var51 = (var29[2] * var45 - var46 * var29[8]) / var48 * var29[9];
               float var52 = -(var29[5] * var45 - var47 * var29[8]) / var48 * var29[10];
               float var53 = var49 * var20 * var39 + var51 * var21;
               float var54 = var50 * var20 * var39 + var52 * var21;
               float var55 = var49 * var22 * var39 + var51 * var23;
               float var56 = var50 * var22 * var39 + var52 * var23;
               float var57 = (float)Math.sqrt((double)(var53 * var53 + var54 * var54));
               float var58 = (float)Math.sqrt((double)(var55 * var55 + var56 * var56));
               var37 = var57 < var37 ? var57 : var37;
               var38 = var58 < var38 ? var58 : var38;
            }

            var37 /= PX;
            var38 /= PX;
         }

         if (var37 > 1.0E-6F && var38 > 1.0E-6F && !(var37 > 1.0E7F) && !(var38 > 1.0E7F)) {
            float var75 = 1.0F;
            if ((var19 || var12 && var10) && var3 * var37 < 1.0F) {
               float var76 = 1.0F / var37;
               var75 *= var3 * var37;
               var1 -= (var76 - var3) * 0.5F;
               var3 = var76;
               this.dk = true;
            }

            if ((var19 || var9 && var11) && var4 * var38 < 1.0F && var17 < var2 && var18 > var2 + var4) {
               float var77 = 1.0F / var38;
               var75 *= var4 * var38;
               var2 -= (var77 - var4) * 0.5F;
               var4 = var77;
               this.dk = true;
            }

            if (var75 < 1.0F) {
               var13 = (int)((float)(var13 >>> 24) * var75 + 0.5F) << 24 | var13 & (-1691150974 ^ -1681069443);
               var14 = (int)((float)(var14 >>> 24) * var75 + 0.5F) << 24 | var14 & (-2092545527 ^ -2084981258);
               float var78 = Math.min(var3, var4) * 0.5F;
               var5 = Math.min(var5, var78);
               var6 = Math.min(var6, var78);
               var7 = Math.min(var7, var78);
               var8 = Math.min(var8, var78);
            }

            int var79 = var16 > 0.0F ? l(var15) : 0;
            if (var19) {
               var30[0] = var1;
               var31[0] = var2;
               var35[0] = var13;
               var30[1] = var1 + var3;
               var31[1] = var2;
               var35[1] = var13;
               var30[2] = var1 + var3;
               var31[2] = var2 + var4;
               var35[2] = var14;
               var30[3] = var1;
               var31[3] = var2 + var4;
               var35[3] = var14;

               for (int var80 = 0; var80 < 4; var80++) {
                  var33[var80] = -65536.0F;
                  var34[var80] = -65536.0F;
               }

               dr[0] = 1;
               ds[0] = true;
               ds[1] = false;
               ds[2] = false;
               ds[3] = false;
            } else {
               float var81 = 2.5F / var37;
               float var84 = 2.5F / var38;
               float var87 = var1 + var3 * 0.5F;
               float var90 = var2 + var4 * 0.5F;
               int var94 = Math.min(1230339355 ^ 1230324452, Math.round(var16 * 16.0F)) << 2;
               boolean var97 = var13 != var14;
               float var101 = var2 - (var9 ? var84 : 0.0F);
               float var105 = var2 + var4 + (var11 ? var84 : 0.0F);
               int var109 = var97 ? n(var13, var14, (var101 - var2) / var4) : var13;
               int var111 = var97 ? n(var13, var14, 0.5F) : var13;
               int var113 = var97 ? n(var13, var14, (var105 - var2) / var4) : var13;
               int var115 = 0;

               for (int var117 = 0; var117 < 4; var117++) {
                  boolean var119 = (var117 & 1) == 0;
                  boolean var121 = (var117 & 2) == 0;
                  float var123 = var119 ? var1 - (var12 ? var81 : 0.0F) : var87;
                  float var125 = var119 ? var87 : var1 + var3 + (var10 ? var81 : 0.0F);
                  float var127 = var121 ? var101 : var90;
                  float var59 = var121 ? var90 : var105;
                  boolean var60 = var127 < var17;
                  boolean var61 = var59 > var18;
                  var127 = var60 ? var17 : var127;
                  var59 = var61 ? var18 : var59;
                  boolean var62 = var125 > var123 && var59 > var127;
                  ds[var117] = var62;
                  if (var62) {
                     float var63 = var119 ? (var12 ? var1 - var123 : -65536.0F) : (var10 ? var123 - (var1 + var3) : -65536.0F);
                     float var64 = var119 ? (var12 ? var1 - var125 : -65536.0F) : (var10 ? var125 - (var1 + var3) : -65536.0F);
                     float var65 = var121 ? (var9 ? var2 - var127 : -65536.0F) : (var11 ? var127 - (var2 + var4) : -65536.0F);
                     float var66 = var121 ? (var9 ? var2 - var59 : -65536.0F) : (var11 ? var59 - (var2 + var4) : -65536.0F);
                     float var67 = var119 ? (var121 ? var5 : var7) : (var121 ? var6 : var8);
                     dr[var117] = Math.min(1533471880 ^ 1533449079, Math.round(var67 * 32.0F)) << 16 | var94 | 0;
                     int var68 = !var97 ? var13 : (var60 ? n(var13, var14, (var127 - var2) / var4) : (var121 ? var109 : var111));
                     int var69 = !var97 ? var13 : (var61 ? n(var13, var14, (var59 - var2) / var4) : (var121 ? var111 : var113));
                     int var70 = var117 * 4;
                     var30[var70] = var123;
                     var31[var70] = var127;
                     var33[var70] = var63;
                     var34[var70] = var65;
                     var35[var70] = var68;
                     var30[var70 + 1] = var125;
                     var31[var70 + 1] = var127;
                     var33[var70 + 1] = var64;
                     var34[var70 + 1] = var65;
                     var35[var70 + 1] = var68;
                     var30[var70 + 2] = var125;
                     var31[var70 + 2] = var59;
                     var33[var70 + 2] = var64;
                     var34[var70 + 2] = var66;
                     var35[var70 + 2] = var69;
                     var30[var70 + 3] = var123;
                     var31[var70 + 3] = var59;
                     var33[var70 + 3] = var63;
                     var34[var70 + 3] = var66;
                     var35[var70 + 3] = var69;
                     var115++;
                  }
               }

               if (var115 == 0) {
                  return false;
               }
            }

            for (int var82 = 0; var82 < 16; var82++) {
               if (ds[var82 >> 2]) {
                  float var85 = var30[var82];
                  float var88 = var31[var82];
                  float var91;
                  float var95;
                  float var98;
                  if (var26) {
                     var91 = var20 * var85 + var22 * var88 + var24;
                     var95 = var21 * var85 + var23 * var88 + var25;
                     var98 = 1.0F;
                  } else {
                     float var102 = var20 * var85 + var22 * var88 + var24;
                     float var106 = var21 * var85 + var23 * var88 + var25;
                     var102 = (float)Math.round(var102 * 256.0F) * 0.00390625F;
                     var106 = (float)Math.round(var106 * 256.0F) * 0.00390625F;
                     if (var27) {
                        var102 = var28 - var102;
                     }

                     float var99 = var29[6] + var102 * var29[7] + var106 * var29[8];
                     var98 = var99 > 0.04F ? var99 : 0.04F;
                     var91 = var29[11] + (var29[0] + var102 * var29[1] + var106 * var29[2]) / var98 * var29[9];
                     var95 = var29[12] - (var29[3] + var102 * var29[4] + var106 * var29[5]) / var98 * var29[10];
                  }

                  if (var91 != var91 || var95 != var95 || var91 < -1000000.0F || var91 > 1000000.0F || var95 < -1000000.0F || var95 > 1000000.0F) {
                     return false;
                  }

                  var30[var82] = var91;
                  var31[var82] = var95;
                  var32[var82] = var98;
               }
            }

            if (this.bm + 64 > this.be.length) {
               this.p(this.bm + 64);
            }

            float[] var83 = this.be;
            float[] var86 = this.bf;
            float[] var89 = this.bh;
            float[] var92 = this.bi;
            float[] var96 = this.bj;
            int[] var100 = this.bg;
            int[] var104 = this.bk;
            int[] var108 = this.bl;
            boolean var110 = this.ci;
            float var112 = this.cj;
            float var114 = this.ck;
            float var116 = this.cl;
            float var118 = this.cm;
            int var120 = this.bm;

            for (int var122 = 0; var122 < 4; var122++) {
               if (ds[var122]) {
                  int var124 = var122 * 4;
                  int var126 = dr[var122];
                  boolean var129 = true;
                  if (var110) {
                     for (int var131 = var124; var131 < var124 + 4; var131++) {
                        float var135 = var30[var131];
                        float var137 = var31[var131];
                        var129 &= var135 >= var112 && var135 <= var116 && var137 >= var114 && var137 <= var118;
                     }
                  }

                  if (var129) {
                     for (int var134 = var124; var134 < var124 + 4; var134++) {
                        var83[var120] = var30[var134];
                        var86[var120] = var31[var134];
                        var89[var120] = var32[var134];
                        var92[var120] = var33[var134];
                        var96[var120] = var34[var134];
                        var100[var120] = var35[var134];
                        var104[var120] = var79;
                        var108[var120] = var126;
                        var120++;
                     }
                  } else {
                     for (int var132 = 0; var132 < 4; var132++) {
                        dt[var132] = var30[var124 + var132];
                        du[var132] = var31[var124 + var132];
                        dv[var132] = var32[var124 + var132];
                        dw[var132] = var33[var124 + var132];
                        dx[var132] = var34[var124 + var132];
                        ed[var132] = var35[var124 + var132];
                     }

                     int var133 = this.o();

                     for (byte var136 = 1; var136 < var133 - 1; var136 += 2) {
                        for (int var138 = 0; var138 < 4; var138++) {
                           int var139 = var138 == 0 ? 0 : (var136 + var138 - 1 < var133 ? var136 + var138 - 1 : var133 - 1);
                           var83[var120] = dt[var139];
                           var86[var120] = du[var139];
                           var89[var120] = dv[var139];
                           var92[var120] = dw[var139];
                           var96[var120] = dx[var139];
                           var100[var120] = ed[var139];
                           var104[var120] = var79;
                           var108[var120] = var126;
                           var120++;
                        }
                     }
                  }
               }
            }

            var36 = var120 > this.bm;
            this.bm = var120;
            return var36;
         } else {
            return false;
         }
      } catch (RuntimeException var71) {
         throw var71;
      }
   }

   private static int n(int var0, int var1, float var2) {

      int var3 = Math.round((float)(var0 >>> 24) + (float)((var1 >>> 24) - (var0 >>> 24)) * var2);
      int var4 = Math.round(
         (float)(var0 >> 16 & (-1924410631 ^ -1924410874))
            + (float)((var1 >> 16 & (-1466257550 ^ -1466257523)) - (var0 >> 16 & (1314912710 ^ 1314912569))) * var2
      );
      int var5 = Math.round(
         (float)(var0 >> 8 & (741958586 ^ 741958469)) + (float)((var1 >> 8 & (1191766514 ^ 1191766285)) - (var0 >> 8 & (-2110464208 ^ -2110464049))) * var2
      );
      int var6 = Math.round(
         (float)(var0 & (1176217893 ^ 1176218074)) + (float)((var1 & (-994380254 ^ -994380067)) - (var0 & (-2134508400 ^ -2134508433))) * var2
      );
      var3 = var3 < 0 ? 0 : (var3 > (89309843 ^ 89309804) ? -625509015 ^ -625508970 : var3);
      var4 = var4 < 0 ? 0 : (var4 > (-27228821 ^ -27228780) ? -129999957 ^ -130000044 : var4);
      var5 = var5 < 0 ? 0 : (var5 > (665898991 ^ 665898768) ? 2000292349 ^ 2000292098 : var5);
      var6 = var6 < 0 ? 0 : (var6 > (-546355367 ^ -546355290) ? -1122089144 ^ -1122089033 : var6);
      return var3 << 24 | var4 << 16 | var5 << 8 | var6;
   }

   private int o() {

      assert dt.length == 12
         && du.length == 12
         && dv.length == 12
         && dw.length == 12
         && dx.length == 12
         && ed.length == 12
         && dy.length == 12
         && dz.length == 12
         && ea.length == 12
         && eb.length == 12
         && ec.length == 12
         && ee.length == 12
         && this.ci
         && this.cj == this.cj
         && this.ck == this.ck
         && this.cl == this.cl
         && this.cm == this.cm
         && PX > 0.0F
         && this.cc
         && dl.length == 16
         && dm.length == 16
         && ds.length == 4
         && this.be != null
         && this.bm >= 0 : "clip" + "S: bad quad";

      float var1 = this.cj;
      float var2 = this.ck;
      float var3 = this.cl;
      float var4 = this.cm;
      int var5 = 4;

      try {
         float[] var6 = dt;
         float[] var7 = du;
         float[] var8 = dv;
         float[] var9 = dw;
         float[] var10 = dx;
         float[] var11 = dy;
         float[] var12 = dz;
         float[] var13 = ea;
         float[] var14 = eb;
         float[] var15 = ec;
         int[] var16 = ed;
         int[] var17 = ee;

         for (int var18 = 0; var18 < 4 && var5 > 0; var18++) {
            float var19 = var18 == 0 ? var1 : (var18 == 1 ? var2 : (var18 == 2 ? var3 : var4));
            boolean var20 = var18 == 0 || var18 == 2;
            boolean var21 = var18 < 2;
            int var22 = 0;

            for (int var23 = 0; var23 < var5 && var22 < 10; var23++) {
               int var24 = var23 + 1 < var5 ? var23 + 1 : 0;
               float var25 = var20 ? var6[var23] : var7[var23];
               float var26 = var20 ? var6[var24] : var7[var24];
               boolean var27 = var21 ? var25 >= var19 : var25 <= var19;
               boolean var28 = var21 ? var26 >= var19 : var26 <= var19;
               if (var27 && var28) {
                  var11[var22] = var6[var24];
                  var12[var22] = var7[var24];
                  var13[var22] = var8[var24];
                  var14[var22] = var9[var24];
                  var15[var22] = var10[var24];
                  var17[var22] = var16[var24];
                  var22++;
               } else if (var27 || var28) {
                  float var29 = (var19 - var25) / (var26 - var25);
                  var29 = var29 < 0.0F ? 0.0F : (var29 > 1.0F ? 1.0F : var29);
                  var11[var22] = var20 ? var19 : var6[var23] + (var6[var24] - var6[var23]) * var29;
                  var12[var22] = var20 ? var7[var23] + (var7[var24] - var7[var23]) * var29 : var19;
                  var13[var22] = var8[var23] + (var8[var24] - var8[var23]) * var29;
                  var14[var22] = var9[var23] + (var9[var24] - var9[var23]) * var29;
                  var15[var22] = var10[var23] + (var10[var24] - var10[var23]) * var29;
                  var17[var22] = var16[var23] == var16[var24] ? var16[var23] : n(var16[var23], var16[var24], var29);
                  var22++;
                  if (var28) {
                     var11[var22] = var6[var24];
                     var12[var22] = var7[var24];
                     var13[var22] = var8[var24];
                     var14[var22] = var9[var24];
                     var15[var22] = var10[var24];
                     var17[var22] = var16[var24];
                     var22++;
                  }
               }
            }

            var5 = var22;
            float[] var31 = var6;
            float[] var32 = var7;
            float[] var33 = var8;
            float[] var34 = var9;
            float[] var35 = var10;
            int[] var36 = var16;
            var6 = var11;
            var7 = var12;
            var8 = var13;
            var9 = var14;
            var10 = var15;
            var16 = var17;
            var11 = var31;
            var12 = var32;
            var13 = var33;
            var14 = var34;
            var15 = var35;
            var17 = var36;
         }

         return var5;
      } catch (RuntimeException var30) {
         throw var30;
      }
   }

   private void p(int var1) {

      if (var1 > this.be.length) {
         int var2 = Math.max(var1, this.be.length * 2);
         this.be = Arrays.copyOf(this.be, var2);
         this.bf = Arrays.copyOf(this.bf, var2);
         this.bg = Arrays.copyOf(this.bg, var2);
         this.bh = Arrays.copyOf(this.bh, var2);
         this.bi = Arrays.copyOf(this.bi, var2);
         this.bj = Arrays.copyOf(this.bj, var2);
         this.bk = Arrays.copyOf(this.bk, var2);
         this.bl = Arrays.copyOf(this.bl, var2);
      }
   }

   public void setupVertices(VertexConsumer var1) {

      float[] var2 = this.be;
      float[] var3 = this.bf;
      int[] var4 = this.bg;

      assert var1 != null
         && var2 != null
         && var3 != null
         && var4 != null
         && var2 != var3
         && var2.length == var3.length
         && var2.length == var4.length
         && this.bm >= 0
         && this.bm <= var2.length
         && (this.bm & 3) == 0
         && (!this.cd || this.ce != null)
         && (this.cd || !this.cc || this.bx != null || this.bm == 0)
         && PX > 0.0F
         && an != null
         && ao != null
         && ap != null
         && aq != null
         && ar != null
         && as != null
         && at != null
         && au != null
         && av != null
         && aw != null
         && ax != null
         && ay != null
         && az != null
         && ba != null
         && bb != null
         && bc != null
         && this.cn != null
         && this.cn.length == 13
         && al != null
         && am >= 0 : "setupVertices: bad element";

      int var5 = this.bm;

      try {
         if (this.bn) {
            float[] var16 = this.bh;
            float[] var17 = this.bi;
            float[] var18 = this.bj;
            int[] var19 = this.bk;
            int[] var20 = this.bl;

            for (int var11 = 0; var11 < var5; var11++) {
               int var12 = var19[var11];
               int var13 = var20[var11];
               var1.vertex(var2[var11], var3[var11], var16[var11])
                  .color(var4[var11])
                  .texture(var17[var11], var18[var11])
                  .overlay(var12 >>> 16, var12 & (-1278646942 ^ -1278633315))
                  .light(var13 >>> 16, var13 & (-315954064 ^ -316009585));
            }
         } else if (this.cd) {
            float var15 = this.cf;
            float var7 = this.cg;

            for (int var8 = 0; var8 < var5; var8++) {
               float var9 = var2[var8];
               float var10 = var3[var8];
               var1.vertex(var9, var10, 0.0F).texture(var9 * var15, 1.0F - var10 * var7).color(var4[var8]);
            }
         } else {
            for (int var6 = 0; var6 < var5; var6++) {
               var1.vertex(var2[var6], var3[var6], 0.0F).color(var4[var6]);
            }
         }
      } catch (RuntimeException var14) {
         throw var14;
      }
   }

   public RenderPipeline pipeline() {

      if (this.bn) {
         return this.cd ? ab : aa;
      } else {
         return this.cd ? RenderPipelines.GUI_TEXTURED : RenderPipelines.GUI;
      }
   }

   public TextureSetup textureSetup() {

      TextureSetup var1 = this.ce;
      return this.cd && var1 != null ? var1 : TextureSetup.empty();
   }

   public ScreenRect scissorArea() {

      return this.ch;
   }

   public ScreenRect bounds() {

      return this.bx;
   }

   static {
      for (int var0 = 1; var0 <= 24; var0++) {
         t[var0] = new float[var0 + 1];
         u[var0] = new float[var0 + 1];

         for (int var1 = 0; var1 <= var0; var1++) {
            double var2 = (Math.PI / 2) * (double)var1 / (double)var0;
            t[var0][var1] = (float)Math.cos(var2);
            u[var0][var1] = (float)Math.sin(var2);
         }

         t[var0][var0] = 0.0F;
         u[var0][var0] = 1.0F;
      }

      PX = 0.5F;
      w = null;
      x = 0.0F;
      y = 0.0F;
      z = 0;
      aa = null;
      ab = null;
      ac = new String[]{
         "lithium",
         "pipeline/s" + "hape_aa",
         "pipeline/shape_aa" + "_frost",
         "co" + "re/shape_aa",
         "core/shape_aa_frost",
         "Position",
         "Color",
         "UV0",
         "UV1",
         "UV2"
      };
      ad = new String[]{
         "ClickGUI s" + "h" + "ap" + "es",
         "Smooth edges unavailable (",
         "), using the " + "fa" + "llback",
         "shader compi" + "le f" + "ail" + "ed",
         "setup fai" + "l" + "ed: "
      };
      ae = false;
      ak = null;
      al = new PaneGlassCache[64];
      am = 0;
      an = new float[116];
      ao = new float[116];
      ap = new int[116];
      aq = new boolean[116];
      ar = new float[116];
      as = new float[116];
      at = new int[116];
      au = new boolean[116];
      av = new float[116];
      aw = new float[116];
      ax = new float[116];
      ay = new float[116];
      az = new float[116];
      ba = new float[116];
      bb = new float[116];
      bc = new float[116];
      dl = new float[16];
      dm = new float[16];
      dn = new float[16];
      _kwren_do = new float[16];
      dp = new float[16];
      dq = new int[16];
      dr = new int[4];
      ds = new boolean[4];
      dt = new float[12];
      du = new float[12];
      dv = new float[12];
      dw = new float[12];
      dx = new float[12];
      dy = new float[12];
      dz = new float[12];
      ea = new float[12];
      eb = new float[12];
      ec = new float[12];
      ed = new int[12];
      ee = new int[12];
   }
}
