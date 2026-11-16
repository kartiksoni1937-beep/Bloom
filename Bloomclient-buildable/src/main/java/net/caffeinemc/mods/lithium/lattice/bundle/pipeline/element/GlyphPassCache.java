package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.element;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Snippet;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.AddressMode;
import com.mojang.blaze3d.textures.FilterMode;
import java.io.InputStream;
import java.util.Arrays;
import java.util.OptionalDouble;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.GlyphAtlasCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.MipmapTextureCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.NoticeQueue;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.texture.TextureSetup;
import net.minecraft.client.gui.render.state.SimpleGuiElementRenderState;
import net.minecraft.client.gl.GpuSampler;
import net.minecraft.text.Style;
import net.minecraft.util.Identifier;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.resource.Resource;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.text.OrderedText;
import net.minecraft.client.gui.ScreenRect;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fStack;

public final class GlyphPassCache implements SimpleGuiElementRenderState {
   private float[] g = new float[64];
   private float[] h = new float[64];
   private float[] i = new float[64];
   private float[] j = new float[64];
   private float[] k = new float[64];
   private int[] l = new int[64];
   private int m;
   private ScreenRect o;
   private ScreenRect p;
   private int q;
   private int r;
   private int s;
   private int t;
   private boolean w;
   private int[] aa = new int[32];
   private int[] ab = new int[32];
   private int ac;
   private float ad;
   private float ae;
   private float af;
   private float ag;
   private static final String[] ah = new String[]{
      "lithium", "font" + "/" + "gui.ttf", "p" + "ipeline/glyph3d", "core/glyph3d", "lithium-glyph3d", "lithium-glyph-bake"
   };
   private static final String[] ai = new String[]{
      "3D " + "GUI" + " text",
      "Sharp text unavaila" + "b" + "l" + "e (",
      "), using the st" + "a" + "ndard f" + "ont",
      "atlas bak" + "e failed",
      "shader / atlas upl" + "oad fa" + "il" + "ed",
      "drawing failed: "
   };
   private static boolean aj = false;
   private static volatile int ak = 0;
   private static byte[] al;
   private static NativeImage[] am;
   private static int an = 0;
   public static boolean broken = false;
   private static RenderPipeline ao;
   private static TextureSetup ap;
   private static MipmapTextureCache aq;
   private static GlyphPassCache[] ar = new GlyphPassCache[64];
   private static int as = 0;
   private static long at = Long.MIN_VALUE;
   private static final GlyphPassCache[] au = new GlyphPassCache[13];
   private static GlyphPassCache av = null;
   private static int aw = -1;
   private static final float[] ax = new float[10240];
   private static int ay = Integer.MIN_VALUE;
   private static final float[] az = new float[19];
   private static final float[] ba = new float[13];
   private static int bb = -1;
   private static final float[] bc = new float[4];
   private static final int bd = 16;
   private static final ScreenRect[] be = new ScreenRect[16];
   private static final float[] bf = new float[32];
   private static final float[] bg = new float[32];
   private static int bh = 0;
   private static final float[] bi = new float[4];
   private static int bj = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   public void setupVertices(VertexConsumer var1) {

      float[] var2 = this.g;
      float[] var3 = this.h;
      float[] var4 = this.i;
      float[] var5 = this.j;
      float[] var6 = this.k;
      int[] var7 = this.l;
      int[] var8 = this.aa;
      int[] var9 = this.ab;

      assert var1 != null
         && var2 != null
         && var3 != null
         && var4 != null
         && var5 != null
         && var6 != null
         && var7 != null
         && var2.length == var3.length
         && var2.length == var4.length
         && var2.length == var5.length
         && var2.length == var6.length
         && var2.length == var7.length
         && this.m >= 0
         && this.m <= var2.length
         && (this.m & 3) == 0
         && this.o != null
         && var2 != var3
         && var3 != var4
         && var4 != var5
         && var5 != var6
         && ar != null
         && ar.length > 0
         && as >= 0
         && var8 != null
         && var9 != null
         && var8.length == var9.length
         && this.ac >= 0
         && this.ac <= var8.length
         && au != null
         && au.length == 13
         && bf.length == 16
         && bg.length == 16 : "setupVertices: bad" + " element";

      try {
         if (!this.w) {
            int var18 = 0;

            for (int var19 = this.m; var18 < var19; var18++) {
               var1.vertex(var2[var18], var3[var18], var4[var18]).texture(var5[var18], var6[var18]).color(var7[var18]);
            }
         } else {
            for (int var10 = 0; var10 < 2; var10++) {
               int var11 = 0;

               for (int var12 = this.ac; var11 < var12; var11++) {
                  int var13 = var9[var11] * 4;
                  int var14 = var8[var11] + var10 * var13;
                  int var15 = var14;

                  for (int var16 = var14 + var13; var15 < var16; var15++) {
                     var1.vertex(var2[var15], var3[var15], var4[var15]).texture(var5[var15], var6[var15]).color(var7[var15]);
                  }
               }
            }
         }
      } catch (RuntimeException var17) {
         throw var17;
      }
   }

   public RenderPipeline pipeline() {

      return ao;
   }

   public TextureSetup textureSetup() {

      return ap;
   }

   public ScreenRect scissorArea() {

      return this.p;
   }

   public ScreenRect bounds() {

      return this.o;
   }

   private void a(int var1) {

      if (var1 > this.g.length) {
         int var2 = Math.max(var1, this.g.length * 2);
         if (this.w) {
            this.g = Arrays.copyOf(this.g, var2);
            this.h = Arrays.copyOf(this.h, var2);
            this.i = Arrays.copyOf(this.i, var2);
            this.j = Arrays.copyOf(this.j, var2);
            this.k = Arrays.copyOf(this.k, var2);
            this.l = Arrays.copyOf(this.l, var2);
         } else {
            this.g = new float[var2];
            this.h = new float[var2];
            this.i = new float[var2];
            this.j = new float[var2];
            this.k = new float[var2];
            this.l = new int[var2];
         }
      }
   }

   private static void b(int var0, Throwable var1) {

      if (!aj) {
         aj = true;

         try {
            String var2 = var0 == 2 && var1 != null ? ai[5] + var1.getClass().getSimpleName() : ai[3 + Math.min(var0, 2)];
            NoticeQueue.err(ai[0], ai[1] + var2 + ai[2]);
            if (var1 != null) {
               var1.printStackTrace();
            }
         } catch (Throwable var3) {
         }
      }
   }

   private GlyphPassCache() {
   }

   public static void kick() {

      if (ak == 0 && an == 0 && !broken) {
         ak = 1;
         MinecraftClient var0 = MinecraftClient.getInstance();

         try {
            InputStream var1 = ((Resource)var0.getResourceManager().getResource(Identifier.of(ah[0], ah[1])).orElseThrow()).getInputStream();

            try {
               al = var1.readAllBytes();
            } finally {
               var1.close();
            }

            Thread var2 = new Thread(GlyphPassCache::c, ah[5]);
            var2.setDaemon(true);
            var2.setPriority(1);
            var2.start();
         } catch (Throwable var6) {
            ak = -1;
         }
      }
   }

   private static void c() {

      Object var0 = null;

      try {
         GlyphAtlasCache.b(al);
         var0 = MipmapTextureCache.toImages(GlyphAtlasCache.LV, -292453025 ^ -292454049, GlyphAtlasCache.AH);
         GlyphAtlasCache.LV = null;
         am = (NativeImage[])var0;
         ak = 2;
      } catch (Throwable var2) {
         ak = -1;
      }

      al = null;
   }

   private static boolean d() {

      if (an != 0) {
         return an > 0;
      } else {
         int var0 = ak;
         if (var0 == 2) {
            e();
         } else if (var0 < 0) {
            an = -1;
            b(0, null);
         }

         return an > 0;
      }
   }

   private static void e() {

      NativeImage[] var0 = am;
      Object var1 = null;
      GpuDevice var2 = null;
      Object var3 = null;
      am = null;
      an = -1;

      try {
         aq = new MipmapTextureCache(ah[4], var0, false);
         var0 = null;
         var2 = RenderSystem.getDevice();
         var1 = aq.getSampler();

         try {
            int var4 = Math.min(8, var2.getMaxSupportedAnisotropy());
            if (var4 > 1) {
               var1 = var2.createSampler(
                  AddressMode.CLAMP_TO_EDGE, AddressMode.CLAMP_TO_EDGE, FilterMode.LINEAR, FilterMode.LINEAR, var4, OptionalDouble.empty()
               );
            }
         } catch (Throwable var7) {
            var1 = aq.getSampler();
         }

         ap = TextureSetup.of(aq.getGlTextureView(), (GpuSampler)var1);
         var3 = RenderPipeline.builder(new Snippet[]{RenderPipelines.POSITION_TEX_COLOR_SNIPPET})
            .withLocation(Identifier.of(ah[0], ah[2]))
            .withVertexShader(Identifier.of(ah[0], ah[3]))
            .withFragmentShader(Identifier.of(ah[0], ah[3]))
            .build();
         if (var2.precompilePipeline((RenderPipeline)var3).isValid()) {
            ao = (RenderPipeline)var3;
            an = 1;
         } else {
            b(1, null);
         }
      } catch (Throwable var8) {
         an = -1;
         b(1, var8);
      }

      if (var0 != null) {
         for (int var12 = 0; var12 < var0.length; var12++) {
            try {
               if (var0[var12] != null) {
                  var0[var12].close();
               }
            } catch (Throwable var6) {
            }
         }
      }
   }

   private static void f(long var0) {
      byte var2 = 0;

      while (true) {
         switch (var2) {
            case 0:
            default:
               if (bj != 0) {
                  System.nanoTime();
                  var2 = 1;
                  break;
               }
            case 1:
               if (var0 != at) {
                  at = var0;
                  as = 0;
                  bb = -1;
                  var2 = 2;
                  break;
               }

               return;
            case 2:
               return;
         }
      }
   }

   public static boolean boardBegin(int var0, long var1) {

      av = null;
      bh = 0;
      if (!broken && (an > 0 || d()) && var0 >= 0 && var0 < au.length) {
         f(var1);
         GlyphPassCache var3 = au[var0];
         if (var3 == null) {
            var3 = new GlyphPassCache();
            var3.w = true;
            au[var0] = var3;
         }

         var3.m = 0;
         var3.ac = 0;
         var3.ad = Float.MAX_VALUE;
         var3.ae = Float.MAX_VALUE;
         var3.af = -Float.MAX_VALUE;
         var3.ag = -Float.MAX_VALUE;
         av = var3;
         aw = var0;
         return true;
      } else {
         return false;
      }
   }

   public static boolean batching() {

      return av != null;
   }

   public static void boardEnd(DrawContext var0) {

      GlyphPassCache var1 = av;
      av = null;
      bh = 0;
      if (var1 != null && var1.m != 0) {
         Object var2 = null;

         try {
            float var3 = var1.ad;
            float var4 = var1.ae;
            float var5 = var1.af;
            float var6 = var1.ag;
            if (!(var3 <= var5) || !(var4 <= var6) || var3 < -1000000.0F || var4 < -1000000.0F || var5 > 1000000.0F || var6 > 1000000.0F) {
               return;
            }

            int var7 = (int)Math.floor((double)var3) - 1;
            int var8 = (int)Math.floor((double)var4) - 1;
            int var9 = (int)Math.ceil((double)var5) + 1;
            int var10 = (int)Math.ceil((double)var6) + 1;
            if (var1.o == null || var7 != var1.q || var8 != var1.r || var9 != var1.s || var10 != var1.t) {
               var2 = new ScreenRect(var7, var8, var9 - var7, var10 - var8);
               var1.o = (ScreenRect)var2;
               var1.q = var7;
               var1.r = var8;
               var1.s = var9;
               var1.t = var10;
            }

            var1.p = null;
            var0.state.addSimpleElement(var1);
         } catch (Throwable var11) {
            broken = true;
            b(2, var11);
         }
      }
   }

   public static void boardAbort() {

      av = null;
      bh = 0;
   }

   public static void clip(DrawContext var0, Matrix3x2f var1, float var2, float var3, float var4, float var5) {

      if (av != null) {
         ScreenRect var6 = var0.scissorStack.peekLast();
         Matrix3x2fStack var7 = var0.getMatrices();
         float var8 = var1.m00;
         float var9 = var1.m01;
         float var10 = var1.m10;
         float var11 = var1.m11;
         float var12 = var8 * var11 - var10 * var9;
         if (var6 != null && var12 > 1.0E-12F) {
            float var13 = 1.0F / var12;
            float var14 = var11 * var13;
            float var15 = -var9 * var13;
            float var16 = -var10 * var13;
            float var17 = var8 * var13;
            float var18 = -(var14 * var1.m20 + var16 * var1.m21);
            float var19 = -(var15 * var1.m20 + var17 * var1.m21);
            float var20 = var14 * var7.m00 + var16 * var7.m01;
            float var21 = var15 * var7.m00 + var17 * var7.m01;
            float var22 = var14 * var7.m10 + var16 * var7.m11;
            float var23 = var15 * var7.m10 + var17 * var7.m11;
            float var24 = var14 * var7.m20 + var16 * var7.m21 + var18;
            float var25 = var15 * var7.m20 + var17 * var7.m21 + var19;
            float var26 = var20 * var2 + var22 * var3 + var24;
            float var27 = var21 * var2 + var23 * var3 + var25;
            float var28 = var20 * var4 + var22 * var3 + var24;
            float var29 = var21 * var4 + var23 * var3 + var25;
            float var30 = var20 * var2 + var22 * var5 + var24;
            float var31 = var21 * var2 + var23 * var5 + var25;
            float var32 = var20 * var4 + var22 * var5 + var24;
            float var33 = var21 * var4 + var23 * var5 + var25;
            float var34 = Math.min(Math.min(var26, var28), Math.min(var30, var32));
            float var35 = Math.max(Math.max(var26, var28), Math.max(var30, var32));
            float var36 = Math.min(Math.min(var27, var29), Math.min(var31, var33));
            float var37 = Math.max(Math.max(var27, var29), Math.max(var31, var33));
            int var38 = bh % 16;
            be[var38] = var6;
            bf[var38 * 2] = var34;
            bf[var38 * 2 + 1] = var35;
            bg[var38 * 2] = var36;
            bg[var38 * 2 + 1] = var37;
            bh++;
         }
      }
   }

   public static boolean draw(
      DrawContext var0,
      String var1,
      char[] var2,
      int var3,
      int var4,
      int var5,
      int var6,
      int var7,
      boolean var8,
      Matrix3x2f var9,
      float var10,
      int var11,
      long var12,
      TextRenderer var14,
      Style var15,
      int var16
   ) {

      if (!broken && (an > 0 || d())) {
         if (var6 >>> 24 == 0) {
            return true;
         } else {
            ScreenRect var17 = var0.scissorStack.peekLast();
            ScreenRect var18 = var17;
            Object var19 = null;
            Matrix3x2fStack var20 = var0.getMatrices();
            GlyphPassCache var21 = null;

            try {
               if (var12 != at) {
                  at = var12;
                  as = 0;
                  bb = -1;
               }

               if (var16 != ay) {
                  Arrays.fill(ax, Float.NaN);
                  ay = var16;
               }

               float[] var22 = az;
               boolean var23 = var7 >= 0;
               float[] var24 = null;
               if (var23) {
                  if (var20.m00 == 1.0F && var20.m01 == 0.0F && var20.m10 == 0.0F && var20.m11 == 1.0F && var20.m20 == 0.0F && var20.m21 == 0.0F) {
                     return true;
                  }

                  if (var17 != null && var17.getTop() <= 0 && var17.getBottom() >= var11) {
                     if (var8) {
                        return true;
                     }

                     var18 = null;
                  } else if (var17 != null && av != null) {
                     int var25 = 0;
                     int var26 = Math.min(bh, 16);

                     while (true) {
                        if (var25 < var26) {
                           int var27 = (bh - 1 - var25) % 16;
                           if (be[var27] != var17) {
                              var25++;
                              continue;
                           }

                           var24 = bi;
                           var24[0] = bf[var27 * 2];
                           var24[2] = bf[var27 * 2 + 1];
                           var24[1] = bg[var27 * 2];
                           var24[3] = bg[var27 * 2 + 1];
                           var18 = null;
                        }

                        if (var24 != null && var8) {
                           return true;
                        }
                        break;
                     }
                  }

                  float var41 = var9.m00;
                  float var43 = var9.m01;
                  float var45 = var9.m10;
                  float var28 = var9.m11;
                  float var29 = var41 * var28 - var45 * var43;
                  if (!(var29 > 1.0E-12F) || !FrameKeeper.bw[var7]) {
                     return true;
                  }

                  float var30 = 1.0F / var29;
                  float var31 = var28 * var30;
                  float var32 = -var43 * var30;
                  float var33 = -var45 * var30;
                  float var34 = var41 * var30;
                  float var35 = -(var31 * var9.m20 + var33 * var9.m21);
                  float var36 = -(var32 * var9.m20 + var34 * var9.m21);
                  var22[0] = var31 * var20.m00 + var33 * var20.m01;
                  var22[1] = var32 * var20.m00 + var34 * var20.m01;
                  var22[2] = var31 * var20.m10 + var33 * var20.m11;
                  var22[3] = var32 * var20.m10 + var34 * var20.m11;
                  var22[4] = var31 * var20.m20 + var33 * var20.m21 + var35;
                  var22[5] = var32 * var20.m20 + var34 * var20.m21 + var36;
                  if (var24 != null) {
                     float var37 = 1.0E-4F * (Math.abs(var22[0]) + Math.abs(var22[3]));
                     var22[1] = Math.abs(var22[1]) <= var37 ? 0.0F : var22[1];
                     var22[2] = Math.abs(var22[2]) <= var37 ? 0.0F : var22[2];
                  }

                  if (bb != var7) {
                     FrameKeeper.i(var7, ba);
                     System.arraycopy(ba, 0, var22, 6, 13);
                     bb = var7;
                  }
               } else {
                  var22[0] = var20.m00;
                  var22[1] = var20.m01;
                  var22[2] = var20.m10;
                  var22[3] = var20.m11;
                  var22[4] = var20.m20;
                  var22[5] = var20.m21;
                  bb = -1;
               }

               boolean var42 = var23 && av != null && aw == var7 && var18 == null;
               if (var42) {
                  var21 = av;
               } else {
                  if (as >= ar.length) {
                     ar = Arrays.copyOf(ar, ar.length * 2);
                  }

                  var21 = ar[as];
                  if (var21 == null) {
                     var21 = new GlyphPassCache();
                     ar[as] = var21;
                  }

                  var21.m = 0;
               }

               int var44 = var1 != null ? var1.length() : var2.length;
               int var46 = var21.m;
               if (var46 + 8 * var44 + 8 > var21.g.length) {
                  var21.a(var46 + 8 * var44 + 8);
               }

               float var47 = var10 > 0.0F ? 1.0F / var10 : 0.5F;
               int var48 = (int)((float)(var6 >>> 24) * 0.62F);
               int var49 = var48 << 24 | -2052079304 ^ -2052536524;
               float[] var50 = bc;
               int var51 = -1;

               for (int var52 = 0; var52 < (-1532298215 ^ -1532298087); var52++) {
                  var50[0] = Float.MAX_VALUE;
                  var50[1] = Float.MAX_VALUE;
                  var50[2] = -Float.MAX_VALUE;
                  var50[3] = -Float.MAX_VALUE;
                  var51 = GlyphAtlasCache.f(
                     var1,
                     var2,
                     var3,
                     (float)var4,
                     (float)var5,
                     var6,
                     var49,
                     var47,
                     var47,
                     ax,
                     var22,
                     var23,
                     var21.g,
                     var21.h,
                     var21.i,
                     var21.j,
                     var21.k,
                     var21.l,
                     var46,
                     var50,
                     var24
                  );
                  if (var51 > -2 || var51 == -3) {
                     break;
                  }

                  int var55 = -2 - var51;
                  ax[var55] = var14.getTextHandler().getWidth(OrderedText.styled(var55, var15));
               }

               if (var51 == -3) {
                  return false;
               } else if (var51 < 0) {
                  return false;
               } else if (var51 == var46) {
                  return true;
               } else if (!(var50[0] <= var50[2])
                  || !(var50[1] <= var50[3])
                  || var50[0] < -1000000.0F
                  || var50[1] < -1000000.0F
                  || var50[2] > 1000000.0F
                  || var50[3] > 1000000.0F) {
                  return true;
               } else if (var42) {
                  int var54 = var21.ac;
                  if (var54 >= var21.aa.length) {
                     var21.aa = Arrays.copyOf(var21.aa, var54 * 2);
                     var21.ab = Arrays.copyOf(var21.ab, var54 * 2);
                  }

                  var21.aa[var54] = var46;
                  var21.ab[var54] = var51 - var46 >> 3;
                  var21.ac = var54 + 1;
                  var21.m = var51;
                  var21.ad = Math.min(var21.ad, var50[0]);
                  var21.ae = Math.min(var21.ae, var50[1]);
                  var21.af = Math.max(var21.af, var50[2]);
                  var21.ag = Math.max(var21.ag, var50[3]);
                  return true;
               } else {
                  int var53 = (int)Math.floor((double)var50[0]) - 1;
                  int var56 = (int)Math.floor((double)var50[1]) - 1;
                  int var57 = (int)Math.ceil((double)var50[2]) + 1;
                  int var58 = (int)Math.ceil((double)var50[3]) + 1;
                  if (var21.o != null && var53 == var21.q && var56 == var21.r && var57 == var21.s && var58 == var21.t) {
                     var19 = var21.o;
                  } else {
                     var19 = new ScreenRect(var53, var56, var57 - var53, var58 - var56);
                     var21.q = var53;
                     var21.r = var56;
                     var21.s = var57;
                     var21.t = var58;
                  }

                  var21.o = (ScreenRect)var19;
                  if (var18 != null) {
                     var19 = var18.intersection((ScreenRect)var19);
                     if (var19 == null) {
                        return true;
                     }

                     var21.q = 1271354308 ^ -876129340;
                  }

                  var21.m = var51;
                  var21.p = var18;
                  var21.o = (ScreenRect)var19;
                  as++;
                  var0.state.addSimpleElement(var21);
                  return true;
               }
            } catch (Throwable var38) {
               broken = true;
               b(2, var38);
               return false;
            }
         }
      } else {
         return false;
      }
   }
}
