package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Snippet;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.platform.DestFactor;
import com.mojang.blaze3d.platform.SourceFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import java.util.List;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.SlotEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.CoreZoneProcessor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.NodeZoneRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderContext;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.render.OutputTarget;
import net.minecraft.client.render.RenderSetup;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.math.Vec3d;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.util.Identifier;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import org.joml.Vector3fc;
import net.minecraft.client.util.math.MatrixStack;
public final class RegionPassCache {
   public static final int LN = 11;
   public static final int SP = 8;
   public static final int QD = 25;
   public static final int CAP_QS = 2048;
   public static final int CAP_QT = 4096;
   public static final int CAP_QA = 4096;
   public static final int CAP_ST = 1024;
   public static final int CAP_SA = 4096;
   public static final int CAP_LT = 512;
   public static final int CAP_LA = 8192;
   public static final int CAP_SB = 512;
   public static final int CAP_LB = 512;
   public static final float[] QS = new float[51200];
   public static final float[] QT = new float[102400];
   public static final float[] QA = new float[102400];
   public static final float[] ST = new float[8192];
   public static final float[] SA = new float[32768];
   public static final float[] LT = new float[5632];
   public static final float[] LA = new float[90112];
   public static final float[] SB = new float[4096];
   public static final float[] LB = new float[5632];
   public static int nQS;
   public static int nQT;
   public static int nQA;
   public static int nST;
   public static int nSA;
   public static int nLT;
   public static int nLA;
   public static int nSB;
   public static int nLB;
   public static double z;
   public static double aa;
   public static double ab;
   public static float rX;
   public static float rY;
   public static float rZ;
   public static float uX;
   public static float uY;
   public static float uZ;
   public static float fX;
   public static float fY;
   public static float fZ;
   public static float td;
   public static float dt;
   public static double now;
   public static float ac = 800.0F;
   public static boolean ad;
   public static float ae;
   public static int af;
   public static int ag;
   public static volatile boolean ON;
   public static boolean ah;
   public static boolean ai;
   public static int aj;
   public static int ak;
   public static int al;
   public static float am;
   public static float an;
   public static float ao;
   public static float ap;
   public static LivingEntity aq;
   public static boolean ar;
   public static int as;
   public static int at;
   public static float au;
   public static float av;
   public static boolean aw;
   public static int ax;
   public static int ay;
   public static int az;
   public static float ba;
   public static float bb;
   public static float bc;
   public static boolean bd;
   public static int be;
   public static int bf;
   public static int bg;
   public static boolean bh;
   public static boolean bi;
   public static boolean bj;
   public static boolean bk;
   public static boolean bl;
   public static boolean bm;
   public static float bn;
   public static int bo;
   public static final int PAL_THEME = -3;
   public static final int PAL_THEME2 = -4;
   public static final int PAL_RGB = -1;
   public static final Identifier ATLAS = Identifier.of("lithium", "fx_atlas");
   public static boolean PV;
   public static double pvX;
   public static double pvY;
   public static double pvZ;
   public static float pvH = 1.8F;
   public static float bp;
   public static float bq;
   public static float br;
   public static boolean bs;
   public static int bt;
   public static int bu;
   public static float bv;
   public static final int PV_ESP = 1;
   public static final int PV_HAT = 2;
   public static final int PV_TRAIL = 4;
   public static final int PV_HIT = 8;
   public static final int PV_WP = 16;
   public static final int PV_RING = 32;
   public static int bw;
   public static int bx = 1;
   public static int by = -3;
   public static float bz = 950.0F;
   public static float ca = 1.2F;
   public static float cb = 1.5F;
   public static boolean cc;
   public static boolean cd;
   public static boolean rsRgb;
   private static double ce;
   private static double cf;
   private static double cg;
   private static float ch;
   private static float ci;
   private static float cj;
   private static float ck;
   private static float cl;
   private static float cm;
   private static float cn;
   private static float co;
   private static float cp;
   private static float cq;
   private static float cr;
   private static float cs;
   private static boolean ct;
   private static int cu;
   private static boolean cv;
   private static final float cw = 1.25F;
   private static final float cx = 0.22F;
   private static final float cy = 1.5F;
   private static final int[] cz = new int[]{
      8218825, 11905504, 16777215, 16777215, 15122522, 15763548, 15745871, 15745871, 16415930, 13163242, 16742943, 16751196
   };
   private static final int da = 31;
   private static final long db = 250000000L;
   private static final long dc = 280000000L;
   private static boolean dd;
   private static volatile boolean de;
   private static volatile NativeImage[] df;
   static RenderLayer dg;
   static RenderLayer dh;
   static RenderLayer di;
   static RenderLayer dj;
   static RenderLayer dk;
   static RenderLayer dl;
   static OutputTarget dm;
   private static int dn;
   private static int _kwren_do;
   private static int dp;
   private static int dq;
   private static int dr;
   private static long ds;
   private static boolean du;
   private static float dv;
   private static final float dw = 0.18F;
   private static final float dx = 0.22F;
   private static final long dy = 250000000L;
   private static int dz;
   private static long ea;
   private static long eb;
   private static boolean ec;
   private static boolean ed;
   private static int ee;
   private static int ef;
   private static int eg;
   private static int eh;

   private RegionPassCache() {
   }

   public static boolean a(double var0, double var2, double var4, float[] var6, float var7, float var8) {

      if (PV || de || cv || var6 == null || var6.length < 9 || ConfigBridge.c == null || !ConfigBridge.c.a()) {
         return false;
      } else if (dg == null && !f()) {
         return false;
      } else {
         ce = z;
         cf = aa;
         cg = ab;
         ch = rX;
         ci = rY;
         cj = rZ;
         ck = uX;
         cl = uY;
         cm = uZ;
         cn = fX;
         co = fY;
         cp = fZ;
         cq = td;
         cr = dt;
         cs = ac;
         ct = ad;
         z = var0;
         aa = var2;
         ab = var4;
         rX = var6[0];
         rY = var6[1];
         rZ = var6[2];
         uX = var6[3];
         uY = var6[4];
         uZ = var6[5];
         fX = var6[6];
         fY = var6[7];
         fZ = var6[8];
         td = 1.0F;
         dt = var8 < 0.0F ? 0.0F : (var8 > 0.1F ? 0.1F : var8);
         ac = var7 > 1.0F ? var7 : 1.0F;
         ad = false;
         nLA = 0;
         nLT = 0;
         nSA = 0;
         nST = 0;
         nQA = 0;
         nQT = 0;
         nQS = 0;
         nLB = 0;
         nSB = 0;
         PV = true;
         return true;
      }
   }

   public static void b(VertexConsumerProvider var0, MatrixStack.Entry var1, float var2) {

      if (PV && var0 != null && var1 != null) {
         try {
            d(var0, var1, false, var2 < 0.0F ? 0.0F : (var2 > 1.0F ? 1.0F : var2));
         } catch (Throwable var4) {
            if (++cu > 30) {
               cv = true;
            }
         }

         nLA = 0;
         nLT = 0;
         nSA = 0;
         nST = 0;
         nQA = 0;
         nQT = 0;
         nQS = 0;
         nLB = 0;
         nSB = 0;
      }
   }

   public static void c() {

      if (PV) {
         PV = false;
         z = ce;
         aa = cf;
         ab = cg;
         rX = ch;
         rY = ci;
         rZ = cj;
         uX = ck;
         uY = cl;
         uZ = cm;
         fX = cn;
         fY = co;
         fZ = cp;
         td = cq;
         dt = cr;
         ac = cs;
         ad = ct;
         nLA = 0;
         nLT = 0;
         nSA = 0;
         nST = 0;
         nQA = 0;
         nQT = 0;
         nQS = 0;
         nLB = 0;
         nSB = 0;
      }
   }

   private static void d(VertexConsumerProvider var0, MatrixStack.Entry var1, boolean var2, float var3) {

      VertexConsumerProvider.Immediate var4 = null;
      Object var5 = null;
      if (var0 instanceof VertexConsumerProvider.Immediate) {
         var4 = (VertexConsumerProvider.Immediate)var0;
      }

      boolean var6 = false;
      boolean var7 = false;
      boolean var8 = false;
      boolean var9 = false;
      int var10 = nQS < (-1832517438 ^ -1832515390) ? nQS : -1680489729 ^ -1680487681;
      if (var10 > 0) {
         var5 = var0.getBuffer(di);
         o((VertexConsumer)var5, var1, var2, QS, var10, var3);
         var6 = true;
      }

      int var11 = nQT < (2084357597 ^ 2084361693) ? nQT : -165494630 ^ -165490534;
      int var12 = nST < (148126338 ^ 148127362) ? nST : -1507489154 ^ -1507488130;
      int var13 = nLT < (983442244 ^ 983441732) ? nLT : 1436506511 ^ 1436507023;
      if (var11 > 0 || var12 > 0 || var13 > 0) {
         var5 = var0.getBuffer(dh);
         if (var11 > 0) {
            o((VertexConsumer)var5, var1, var2, QT, var11, var3);
         }

         if (var12 > 0) {
            p((VertexConsumer)var5, var1, var2, ST, var12, var3);
         }

         if (var13 > 0) {
            q((VertexConsumer)var5, var1, var2, LT, var13, var3);
         }

         var7 = true;
      }

      int var14 = nQA < (-1799906802 ^ -1799910898) ? nQA : 1118174587 ^ 1118170491;
      int var15 = nSA < (1045036752 ^ 1045032656) ? nSA : 1613846043 ^ 1613841947;
      int var16 = nLA < (294134940 ^ 294126748) ? nLA : -1971061877 ^ -1971070069;
      if (var14 > 0 || var15 > 0 || var16 > 0) {
         var5 = var0.getBuffer(dg);
         if (var14 > 0) {
            o((VertexConsumer)var5, var1, var2, QA, var14, var3);
         }

         if (var15 > 0) {
            p((VertexConsumer)var5, var1, var2, SA, var15, var3);
         }

         if (var16 > 0) {
            q((VertexConsumer)var5, var1, var2, LA, var16, var3);
         }

         var8 = true;
      }

      int var17 = nSB < (1144009681 ^ 1144009169) ? nSB : -1371544450 ^ -1371543938;
      int var18 = nLB < (442438718 ^ 442439230) ? nLB : 1994376080 ^ 1994375568;
      if (var17 > 0 || var18 > 0) {
         var5 = var0.getBuffer(dl);
         if (var17 > 0) {
            p((VertexConsumer)var5, var1, var2, SB, var17, var3);
         }

         if (var18 > 0) {
            q((VertexConsumer)var5, var1, var2, LB, var18, var3);
         }

         var9 = true;
      }

      if (var4 != null) {
         if (var6) {
            var4.draw(di);
         }

         if (var7) {
            var4.draw(dh);
         }

         if (var8) {
            var4.draw(dg);
         }

         if (var9) {
            var4.draw(dl);
         }
      }
   }

   public static void e() {

      if (!dd) {
         dd = true;

         try {
            WorldRenderEvents.END_MAIN.register(RegionPassCache::n);
         } catch (Throwable var3) {
            de = true;
            return;
         }

         try {
            PosePassCache.install();
         } catch (Throwable var2) {
         }

         try {
            Thread var0 = new Thread(() -> {

               try {
                  int[][] var0x = FacetArrayCache.d(FacetArrayCache.a());
                  df = MipmapTextureCache.toImages(var0x, 1734818877 ^ 1734817853, -1689847244 ^ -1689846220);
               } catch (Throwable var1x) {
                  de = true;
               }
            }, "Worker-Lithium-Fx");
            var0.setDaemon(true);
            var0.setPriority(1);
            var0.start();
         } catch (Throwable var1) {
            de = true;
         }
      }
   }

   public static boolean f() {

      if (dg != null) {
         return true;
      } else if (!de && df != null) {
         g();
         return dg != null;
      } else {
         return false;
      }
   }

   private static void g() {

      MinecraftClient var0 = MinecraftClient.getInstance();
      NativeImage[] var1 = df;
      Object var2 = null;
      df = null;
      if (var1 != null) {
         try {
            var2 = new MipmapTextureCache("lithium-" + "fx", var1, false);
         } catch (Throwable var9) {
            de = true;

            for (int var4 = 0; var4 < var1.length; var4++) {
               try {
                  if (var1[var4] != null) {
                     var1[var4].close();
                  }
               } catch (Throwable var6) {
               }
            }

            return;
         }

         try {
            var0.getTextureManager().registerTexture(ATLAS, (AbstractTexture)var2);
         } catch (Throwable var8) {
            de = true;
            return;
         }

         try {
            h();
         } catch (Throwable var7) {
            dg = null;
            de = true;
         }
      }
   }

   private static void h() {

      dm = new OutputTarget("lithium_fx", () -> {

         MinecraftClient var0x = MinecraftClient.getInstance();
         Framebuffer var1x = var0x.worldRenderer == null ? null : var0x.worldRenderer.getTranslucentFramebuffer();
         return var1x != null ? var1x : var0x.getFramebuffer();
      });
      RenderPipeline var0 = RenderPipeline.builder(new Snippet[]{RenderPipelines.POSITION_TEX_COLOR_SNIPPET})
         .withLocation(Identifier.of("lithium", "pipeline/fx_so" + "lid"))
         .withBlend(BlendFunction.TRANSLUCENT)
         .withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST)
         .withDepthWrite(true)
         .withCull(false)
         .build();
      RenderPipeline var1 = RenderPipeline.builder(new Snippet[]{RenderPipelines.POSITION_TEX_COLOR_SNIPPET})
         .withLocation(Identifier.of("lithium", "pipeline/fx_tra" + "ns"))
         .withBlend(BlendFunction.TRANSLUCENT)
         .withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build();
      RenderPipeline var2 = RenderPipeline.builder(new Snippet[]{RenderPipelines.POSITION_TEX_COLOR_SNIPPET})
         .withLocation(Identifier.of("lithium", "pipeline/" + "fx_add"))
         .withBlend(BlendFunction.LIGHTNING)
         .withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build();
      RenderPipeline var3 = RenderPipeline.builder(new Snippet[]{RenderPipelines.POSITION_TEX_COLOR_SNIPPET})
         .withLocation(Identifier.of("lithium", "pipelin" + "e/fx" + "_tint_mul"))
         .withBlend(new BlendFunction(SourceFactor.DST_COLOR, DestFactor.ZERO))
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build();
      RenderPipeline var4 = RenderPipeline.builder(new Snippet[]{RenderPipelines.POSITION_TEX_COLOR_SNIPPET})
         .withLocation(Identifier.of("lithium", "pipeline/fx_tint_add"))
         .withBlend(BlendFunction.LIGHTNING)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build();
      RenderPipeline var5 = RenderPipeline.builder(new Snippet[]{RenderPipelines.POSITION_TEX_COLOR_SNIPPET})
         .withLocation(Identifier.of("lithium", "pipeline/fx_bloom"))
         .withBlend(BlendFunction.LIGHTNING)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build();
      di = RenderLayer.of("l" + "ith" + "ium_fx_s" + "olid", RenderSetup.builder(var0).texture("Sampler0", ATLAS, () -> {

         return RenderSystem.getSamplerCache().get(FilterMode.LINEAR, true);
      }).outputTarget(dm).expectedBufferSize(1351874361 ^ 1351841593).build());
      dh = RenderLayer.of("lithi" + "um_fx_trans", RenderSetup.builder(var1).texture("Sampler0", ATLAS, () -> {

         return RenderSystem.getSamplerCache().get(FilterMode.LINEAR, true);
      }).outputTarget(dm).expectedBufferSize(-1416166276 ^ -1416297348).build());
      dj = RenderLayer.of("lith" + "ium_fx_t" + "int_mul", RenderSetup.builder(var3).texture("Sampler0", ATLAS, () -> {

         return RenderSystem.getSamplerCache().get(FilterMode.LINEAR, true);
      }).outputTarget(OutputTarget.MAIN_TARGET).expectedBufferSize(1697700351 ^ 1697700095).build());
      dk = RenderLayer.of("lithiu" + "m_f" + "x" + "_tint_add", RenderSetup.builder(var4).texture("Sampler0", ATLAS, () -> {

         return RenderSystem.getSamplerCache().get(FilterMode.LINEAR, true);
      }).outputTarget(OutputTarget.MAIN_TARGET).expectedBufferSize(-682166706 ^ -682166450).build());
      dl = RenderLayer.of("lit" + "hi" + "um_fx_bloom", RenderSetup.builder(var5).texture("Sampler0", ATLAS, () -> {

         return RenderSystem.getSamplerCache().get(FilterMode.LINEAR, true);
      }).outputTarget(dm).expectedBufferSize(572380679 ^ 572347911).build());
      dg = RenderLayer.of("lit" + "hium" + "_fx_" + "add", RenderSetup.builder(var2).texture("Sampler0", ATLAS, () -> {

         return RenderSystem.getSamplerCache().get(FilterMode.LINEAR, true);
      }).outputTarget(dm).expectedBufferSize(1282574380 ^ 1282836524).build());
   }

   public static int col(int var0) {

      if (var0 >= 0) {
         return var0 & (-1175363958 ^ -1190223499);
      } else if (var0 == -4) {
         return ag;
      } else if (var0 != -1) {
         return af;
      } else {
         double var1 = now * 0.25;
         float var3 = (float)(var1 - Math.floor(var1)) * 6.0F;
         int var4 = (int)var3;
         float var5 = var3 - (float)var4;
         if (var4 > 5 || var4 < 0) {
            var4 = 0;
            var5 = 0.0F;
         }

         int var6 = -1976932400 ^ -1976932561;
         byte var7 = 38;
         int var8 = (int)(255.0F * (1.0F - 0.85F * var5) + 0.5F);
         int var9 = (int)(255.0F * (1.0F - 0.85F * (1.0F - var5)) + 0.5F);
         switch (var4) {
            case 0:
               return var6 << 16 | var9 << 8 | var7;
            case 1:
               return var8 << 16 | var6 << 8 | var7;
            case 2:
               return var7 << 16 | var6 << 8 | var9;
            case 3:
               return var7 << 16 | var8 << 8 | var6;
            case 4:
               return var9 << 16 | var7 << 8 | var6;
            default:
               return var6 << 16 | var7 << 8 | var8;
         }
      }
   }

   public static int i() {

      long var0 = System.nanoTime();
      if (!ec || var0 - ea >= 250000000L) {
         j(var0);
      }

      if (ed) {
         float var2 = (float)(var0 - eb) / 2.8E8F;
         if (!(var2 >= 1.0F) && !(var2 < 0.0F)) {
            float var3 = 1.0F - (1.0F - var2) * (1.0F - var2);
            af = k(eg, ee, var3);
            ag = k(eh, ef, var3);
         } else {
            af = ee;
            ag = ef;
            ed = false;
         }
      }

      return af;
   }

   private static void j(long var0) {

      CoreZoneProcessor var2 = CoreZoneProcessor.I;
      List var3 = null;
      InitAdapter var4 = null;
      Object var5 = null;
      ea = var0;
      int var6 = 0;
      int var7 = cz[0];
      int var8 = cz[1];

      try {
         if (var2 != null) {
            var3 = var2.k();
         }

         if (var3 != null && var3.size() > 31) {
            var4 = (InitAdapter)var3.get(31);
         }

         if (var4 instanceof SlotEntry var11) {
            int var9 = var11.g().indexOf(var11.f());
            var6 = var9 > 0 && var9 < cz.length / 2 ? var9 : 0;
         }

         if (var6 == 0) {
            int[] var12 = ThemeCache.e();
            var7 = (var12[0] & (1768804016 ^ 1768803919)) << 16 | (var12[1] & (-1674552903 ^ -1674553018)) << 8 | var12[2] & (1329321656 ^ 1329321543);
            var8 = k(var7, -183974443 ^ -168347094, 0.45F);
         } else {
            var7 = cz[var6 * 2];
            var8 = cz[var6 * 2 + 1];
         }
      } catch (Throwable var10) {
      }

      if (!ec) {
         ec = true;
         ee = var7;
         ef = var8;
         af = var7;
         ag = var8;
         ed = false;
      } else if (var7 != ee || var8 != ef) {
         eg = af;
         eh = ag;
         ee = var7;
         ef = var8;
         eb = var0;
         ed = true;
      }
   }

   private static int k(int var0, int var1, float var2) {

      int var3 = (int)(
         (float)(var0 >> 16 & (1596259059 ^ 1596258828))
            + (float)((var1 >> 16 & (-467752240 ^ -467752401)) - (var0 >> 16 & (917829531 ^ 917829476))) * var2
            + 0.5F
      );
      int var4 = (int)(
         (float)(var0 >> 8 & (959992651 ^ 959992756))
            + (float)((var1 >> 8 & (-2000529871 ^ -2000529714)) - (var0 >> 8 & (472906642 ^ 472906605))) * var2
            + 0.5F
      );
      int var5 = (int)((float)(var0 & (1786082096 ^ 1786082255)) + (float)((var1 & (-68610831 ^ -68611058)) - (var0 & (1272578339 ^ 1272578524))) * var2 + 0.5F);
      return var3 << 16 | var4 << 8 | var5;
   }

   public static boolean l(Entity var0, boolean var1) {

      MinecraftClient var2 = MinecraftClient.getInstance();
      if (var0 == null || var2.player == null || var0.isRemoved() || var0.isSpectator() || var0.isInvisibleTo(var2.player)) {
         return false;
      } else {
         return var0 instanceof LivingEntity && ((LivingEntity)var0).isSleeping()
            ? false
            : var1 || var0 != var2.getCameraEntity() || !var2.options.getPerspective().isFirstPerson();
      }
   }

   private static void m() {

      aq = null;
      nLA = 0;
      nLT = 0;
      nSA = 0;
      nST = 0;
      nQA = 0;
      nQT = 0;
      nQS = 0;
      nLB = 0;
      nSB = 0;

      try {
         DriftPassCache.d();
      } catch (Throwable var4) {
      }

      try {
         TracePassCache.g();
      } catch (Throwable var3) {
      }

      try {
         HaloPassCache.p();
      } catch (Throwable var2) {
      }

      try {
         EchoPassCache.b();
      } catch (Throwable var1) {
      }
   }

   private static void n(WorldRenderContext var0) {

      if (ConfigBridge.c != null) {
         if (!ON && !(ae > 0.0F)) {
            du = false;
         } else {
            MinecraftClient var1 = MinecraftClient.getInstance();
            Camera var2 = null;
            Vec3d var3 = null;
            Vector3fc var4 = null;
            Vector3fc var5 = null;
            Vector3fc var6 = null;
            VertexConsumerProvider var7 = null;
            VertexConsumerProvider.Immediate var8 = null;
            MatrixStack.Entry var9 = null;
            VertexConsumer var10 = null;
            NodeZoneRenderer var11 = null;
            if (!de && ConfigBridge.c.a() && var1.world != null && var1.player != null) {
               float var13 = 0.0F;
               int var14 = 0;

               boolean var12;
               try {
                  long var15 = System.nanoTime();
                  int var17 = System.identityHashCode(var1.world);
                  if (var17 != dz) {
                     dz = var17;
                     m();
                     du = false;
                  }

                  float var18 = du ? (float)(var15 - ds) / 1.0E9F : 0.0F;
                  boolean var19 = du && var15 - ds > 250000000L;
                  ds = var15;
                  du = true;
                  var18 = var18 < 0.0F ? 0.0F : (var18 > 0.1F ? 0.1F : var18);
                  float var20 = var1.isPaused() ? 0.0F : var18;
                  dt = var20;
                  now += (double)var20;
                  boolean var21 = ON;
                  float var22 = dv;
                  if (var19) {
                     var22 = var21 ? 1.0F : 0.0F;
                  } else if (var21) {
                     var22 += var18 / 0.18F;
                     var22 = var22 > 1.0F ? 1.0F : var22;
                  } else {
                     var22 -= var18 / 0.22F;
                     var22 = var22 < 0.0F ? 0.0F : var22;
                  }

                  if (!var21 && !(var22 > 0.0F)) {
                     dv = 0.0F;
                     ae = 0.0F;
                     m();
                     du = false;
                     return;
                  }

                  dv = var22;
                  ae = var22 * var22 * (3.0F - 2.0F * var22);
                  if (dg == null && !f()) {
                     return;
                  }

                  var2 = var1.gameRenderer.getCamera();
                  var3 = var2.getCameraPos();
                  z = var3.x;
                  aa = var3.y;
                  ab = var3.z;
                  var4 = var2.getHorizontalPlane();
                  var5 = var2.getVerticalPlane();
                  var6 = var2.getDiagonalPlane();
                  rX = -var6.x();
                  rY = -var6.y();
                  rZ = -var6.z();
                  uX = var5.x();
                  uY = var5.y();
                  uZ = var5.z();
                  fX = var4.x();
                  fY = var4.y();
                  fZ = var4.z();
                  td = var1.getRenderTickCounter().getTickProgress(true);
                  ad = var1.options.getPerspective().isFirstPerson() && var1.getCameraEntity() == var1.player;
                  float var23 = (float)var1.getWindow().getFramebufferHeight();
                  int var24 = (Integer)var1.options.getFov().getValue();
                  float var25 = var23 / (2.0F * (float)Math.tan(Math.toRadians(var24 < 1 ? 1.0 : (double)var24) * 0.5));
                  ac = var25 > 1.0F ? var25 : 1.0F;
                  if (!ec || var15 - ea >= 250000000L) {
                     j(var15);
                  }

                  if (ed) {
                     float var26 = (float)(var15 - eb) / 2.8E8F;
                     if (!(var26 >= 1.0F) && !(var26 < 0.0F)) {
                        float var27 = 1.0F - (1.0F - var26) * (1.0F - var26);
                        af = k(eg, ee, var27);
                        ag = k(eh, ef, var27);
                     } else {
                        af = ee;
                        ag = ef;
                        ed = false;
                     }
                  }

                  nLA = 0;
                  nLT = 0;
                  nSA = 0;
                  nST = 0;
                  nQA = 0;
                  nQT = 0;
                  nQS = 0;
                  nLB = 0;
                  nSB = 0;
                  var7 = var0.consumers();
                  var9 = var0.matrices().peek();
                  var12 = (var9.getPositionMatrix().properties() & 4) != 0;
               } catch (Throwable var44) {
                  if (++dn > 30) {
                     de = true;
                  }

                  return;
               }

               if (_kwren_do < 30) {
                  try {
                     DriftPassCache.a();
                  } catch (Throwable var41) {
                     _kwren_do++;
                  }
               }

               if (dp < 30) {
                  try {
                     TracePassCache.f();
                  } catch (Throwable var40) {
                     dp++;
                  }
               }

               if (dq < 30) {
                  try {
                     HaloPassCache.a();
                  } catch (Throwable var39) {
                     dq++;
                  }
               }

               if (dr < 30) {
                  try {
                     EchoPassCache.a();
                  } catch (Throwable var43) {
                     dr++;
                     if (dr == 1 || dr == 30) {
                        var43.printStackTrace();
                     }

                     if (dr == 30) {
                        NoticeQueue.err("Death Effects stopped", "They kept failing to draw; the lo" + "g has " + "the error");
                     }
                  }
               }

               if (NodeZoneRenderer.TINT_HOT) {
                  var11 = NodeZoneRenderer.INSTANCE;
                  if (var11 != null) {
                     try {
                        var13 = var11.dg() * ae;
                        var14 = var11.di();
                     } catch (Throwable var38) {
                        var13 = 0.0F;
                     }
                  }
               }

               try {
                  if (var7 instanceof VertexConsumerProvider.Immediate) {
                     var8 = (VertexConsumerProvider.Immediate)var7;
                  }

                  boolean var55 = false;
                  int var16 = var14 >> 16 & (633183542 ^ 633183689);
                  int var56 = var14 >> 8 & (-2114361208 ^ -2114361225);
                  int var58 = var14 & (47080785 ^ 47080878);
                  int var59 = var16 > var56 ? (var16 > var58 ? var16 : var58) : (var56 > var58 ? var56 : var58);
                  if (var13 >= 0.003F && var59 > 0) {
                     float var60 = var13 > 1.0F ? 1.0F : var13;
                     float var61 = 1.0F / (float)var59;
                     int var65 = (int)((1.0F - var60 * (1.0F - (float)var16 * var61)) * 255.0F + 0.5F);
                     int var66 = (int)((1.0F - var60 * (1.0F - (float)var56 * var61)) * 255.0F + 0.5F);
                     int var67 = (int)((1.0F - var60 * (1.0F - (float)var58 * var61)) * 255.0F + 0.5F);
                     int var68 = -1166614445 ^ 1165418579 | var65 << 16 | var66 << 8 | var67;
                     int var69 = (int)(0.1F * var60 * 255.0F + 0.5F) << 24 | var14 & (-1190491825 ^ -1175095632);
                     float var70 = 0.2F * fX;
                     float var28 = 0.2F * fY;
                     float var29 = 0.2F * fZ;
                     float var30 = 2.0F * rX;
                     float var31 = 2.0F * rY;
                     float var32 = 2.0F * rZ;
                     float var33 = 2.0F * uX;
                     float var34 = 2.0F * uY;
                     float var35 = 2.0F * uZ;
                     float var36 = FacetArrayCache.U0[0];
                     float var37 = FacetArrayCache.V0[0];
                     var10 = var7.getBuffer(dj);
                     (var12
                           ? var10.vertex(var70 - var30 - var33, var28 - var31 - var34, var29 - var32 - var35)
                           : var10.vertex((MatrixStack.Entry)var9, var70 - var30 - var33, var28 - var31 - var34, var29 - var32 - var35))
                        .texture(var36, var37)
                        .color(var68);
                     (var12
                           ? var10.vertex(var70 - var30 + var33, var28 - var31 + var34, var29 - var32 + var35)
                           : var10.vertex((MatrixStack.Entry)var9, var70 - var30 + var33, var28 - var31 + var34, var29 - var32 + var35))
                        .texture(var36, var37)
                        .color(var68);
                     (var12
                           ? var10.vertex(var70 + var30 + var33, var28 + var31 + var34, var29 + var32 + var35)
                           : var10.vertex((MatrixStack.Entry)var9, var70 + var30 + var33, var28 + var31 + var34, var29 + var32 + var35))
                        .texture(var36, var37)
                        .color(var68);
                     (var12
                           ? var10.vertex(var70 + var30 - var33, var28 + var31 - var34, var29 + var32 - var35)
                           : var10.vertex((MatrixStack.Entry)var9, var70 + var30 - var33, var28 + var31 - var34, var29 + var32 - var35))
                        .texture(var36, var37)
                        .color(var68);
                     if (var69 >>> 24 != 0) {
                        var10 = var7.getBuffer(dk);
                        (var12
                              ? var10.vertex(var70 - var30 - var33, var28 - var31 - var34, var29 - var32 - var35)
                              : var10.vertex((MatrixStack.Entry)var9, var70 - var30 - var33, var28 - var31 - var34, var29 - var32 - var35))
                           .texture(var36, var37)
                           .color(var69);
                        (var12
                              ? var10.vertex(var70 - var30 + var33, var28 - var31 + var34, var29 - var32 + var35)
                              : var10.vertex((MatrixStack.Entry)var9, var70 - var30 + var33, var28 - var31 + var34, var29 - var32 + var35))
                           .texture(var36, var37)
                           .color(var69);
                        (var12
                              ? var10.vertex(var70 + var30 + var33, var28 + var31 + var34, var29 + var32 + var35)
                              : var10.vertex((MatrixStack.Entry)var9, var70 + var30 + var33, var28 + var31 + var34, var29 + var32 + var35))
                           .texture(var36, var37)
                           .color(var69);
                        (var12
                              ? var10.vertex(var70 + var30 - var33, var28 + var31 - var34, var29 + var32 - var35)
                              : var10.vertex((MatrixStack.Entry)var9, var70 + var30 - var33, var28 + var31 - var34, var29 + var32 - var35))
                           .texture(var36, var37)
                           .color(var69);
                     }

                     var55 = true;
                  }

                  if (var55 && var8 != null) {
                     var8.draw(dj);
                     var8.draw(dk);
                  }

                  d(var7, (MatrixStack.Entry)var9, var12, ae);
               } catch (Throwable var42) {
                  if (++dn > 30) {
                     de = true;
                  }
               }
            } else {
               dv = 0.0F;
               if (ae > 0.0F) {
                  ae = 0.0F;
                  m();
               }

               du = false;
            }
         }
      }
   }

   private static void o(VertexConsumer var0, MatrixStack.Entry var1, boolean var2, float[] var3, int var4, float var5) {

      assert var0 != null
         && var3 != null
         && var4 > 0
         && (long)var4 * 25L <= (long)var3.length
         && var3.length % 25 == 0
         && (var2 || var1 != null)
         && var5 >= 0.0F
         && var5 <= 1.0F
         && FacetArrayCache.U0.length == 27
         && FacetArrayCache.V0.length == 27
         && FacetArrayCache.U1.length == 27
         && FacetArrayCache.V1.length == 27
         && FacetArrayCache.U0[0] == FacetArrayCache.U1[0]
         && FacetArrayCache.V0[0] == FacetArrayCache.V1[0]
         && FacetArrayCache.U0[17] < FacetArrayCache.U1[17]
         && FacetArrayCache.V0[17] < FacetArrayCache.V1[17]
         && FacetArrayCache.U0[20] == FacetArrayCache.U1[20]
         && FacetArrayCache.V0[20] < FacetArrayCache.V1[20]
         && (var3 == QS || var3 == QT || var3 == QA)
         && (201838888 ^ 201791784) == QS.length
         && (1880498031 ^ 1880592239) == QT.length
         && (-1625523049 ^ -1625428841) == QA.length : "e" + "mitQuads: bad batch";

      try {
         float[] var6 = FacetArrayCache.U0;
         float[] var7 = FacetArrayCache.V0;
         float[] var8 = FacetArrayCache.U1;
         float[] var9 = FacetArrayCache.V1;
         float var10 = fX;
         float var11 = fY;
         float var12 = fZ;

         for (int var13 = 0; var13 < var4; var13++) {
            int var14 = var13 * 25;
            int var15 = (int)var3[var14 + 20];
            if (var15 < 0 || var15 >= 27) {
               var15 = 0;
            }

            int var16 = Float.floatToRawIntBits(var3[var14 + 21]);
            int var17 = Float.floatToRawIntBits(var3[var14 + 22]);
            int var18 = Float.floatToRawIntBits(var3[var14 + 23]);
            int var19 = Float.floatToRawIntBits(var3[var14 + 24]);
            int var20 = (int)((float)(var16 >>> 24) * var5 + 0.5F);
            int var21 = (int)((float)(var17 >>> 24) * var5 + 0.5F);
            int var22 = (int)((float)(var18 >>> 24) * var5 + 0.5F);
            int var23 = (int)((float)(var19 >>> 24) * var5 + 0.5F);
            if ((var20 | var21 | var22 | var23) != 0) {
               float var24 = var3[var14];
               float var25 = var3[var14 + 1];
               float var26 = var3[var14 + 2];
               float var27 = var3[var14 + 3];
               float var28 = var3[var14 + 4];
               float var29 = var3[var14 + 5];
               float var30 = var3[var14 + 6];
               float var31 = var3[var14 + 7];
               float var32 = var3[var14 + 8];
               float var33 = var3[var14 + 9];
               float var34 = var3[var14 + 10];
               float var35 = var3[var14 + 11];
               if (!(var24 * var10 + var25 * var11 + var26 * var12 < 0.0F)
                  || !(var27 * var10 + var28 * var11 + var29 * var12 < 0.0F)
                  || !(var30 * var10 + var31 * var11 + var32 * var12 < 0.0F)
                  || !(var33 * var10 + var34 * var11 + var35 * var12 < 0.0F)) {
                  float var36 = var6[var15];
                  float var37 = var7[var15];
                  float var38 = var8[var15] - var36;
                  float var39 = var9[var15] - var37;
                  float var40 = var36 + var38 * var3[var14 + 12];
                  float var41 = var37 + var39 * var3[var14 + 13];
                  float var42 = var36 + var38 * var3[var14 + 14];
                  float var43 = var37 + var39 * var3[var14 + 15];
                  float var44 = var36 + var38 * var3[var14 + 16];
                  float var45 = var37 + var39 * var3[var14 + 17];
                  float var46 = var36 + var38 * var3[var14 + 18];
                  float var47 = var37 + var39 * var3[var14 + 19];
                  int var48 = var20 << 24 | var16 & (1568364770 ^ 1568974621);
                  int var49 = var21 << 24 | var17 & (597903930 ^ 593278405);
                  int var50 = var22 << 24 | var18 & (-1098874619 ^ -1098940678);
                  int var51 = var23 << 24 | var19 & (-1420215348 ^ -1415134157);
                  (var2 ? var0.vertex(var24, var25, var26) : var0.vertex(var1, var24, var25, var26)).texture(var40, var41).color(var48);
                  (var2 ? var0.vertex(var27, var28, var29) : var0.vertex(var1, var27, var28, var29)).texture(var42, var43).color(var49);
                  (var2 ? var0.vertex(var30, var31, var32) : var0.vertex(var1, var30, var31, var32)).texture(var44, var45).color(var50);
                  (var2 ? var0.vertex(var33, var34, var35) : var0.vertex(var1, var33, var34, var35)).texture(var46, var47).color(var51);
               }
            }
         }
      } catch (RuntimeException var52) {
         throw var52;
      }
   }

   private static void p(VertexConsumer var0, MatrixStack.Entry var1, boolean var2, float[] var3, int var4, float var5) {

      assert var0 != null
         && var3 != null
         && var4 > 0
         && (long)var4 * 8L <= (long)var3.length
         && var3.length % 8 == 0
         && (var2 || var1 != null)
         && var5 >= 0.0F
         && var5 <= 1.0F
         && ac >= 1.0F
         && FacetArrayCache.U0.length == 27
         && FacetArrayCache.V0.length == 27
         && FacetArrayCache.U1.length == 27
         && FacetArrayCache.V1.length == 27
         && FacetArrayCache.U0[4] < FacetArrayCache.U1[4]
         && FacetArrayCache.V0[4] < FacetArrayCache.V1[4]
         && FacetArrayCache.U0[19] < FacetArrayCache.U1[19]
         && FacetArrayCache.V0[19] < FacetArrayCache.V1[19]
         && FacetArrayCache.U0[3] < FacetArrayCache.U1[3]
         && FacetArrayCache.V0[3] < FacetArrayCache.V1[3]
         && (var3 == ST || var3 == SA || var3 == SB)
         && (-821241832 ^ -821233640) == ST.length
         && (-1766292434 ^ -1766325202) == SA.length
         && (-1068128199 ^ -1068124103) == SB.length : "emitSprites: bad batch";

      try {
         float[] var6 = FacetArrayCache.U0;
         float[] var7 = FacetArrayCache.V0;
         float[] var8 = FacetArrayCache.U1;
         float[] var9 = FacetArrayCache.V1;
         float var10 = rX;
         float var11 = rY;
         float var12 = rZ;
         float var13 = uX;
         float var14 = uY;
         float var15 = uZ;
         float var16 = fX;
         float var17 = fY;
         float var18 = fZ;
         float var19 = 0.75F / ac;

         for (int var20 = 0; var20 < var4; var20++) {
            int var21 = var20 * 8;
            int var22 = Float.floatToRawIntBits(var3[var21 + 7]);
            if (var22 >>> 24 != 0) {
               float var23 = var3[var21];
               float var24 = var3[var21 + 1];
               float var25 = var3[var21 + 2];
               float var26 = var3[var21 + 3];
               float var27 = var3[var21 + 4];
               float var28 = var3[var21 + 5];
               float var29 = var26 < var27 ? var26 : var27;
               if (var29 > 0.0F) {
                  float var30 = var26 > var27 ? var26 : var27;
                  if (!(var23 * var16 + var24 * var17 + var25 * var18 < -1.42F * var30)) {
                     float var31 = var19 * (float)Math.sqrt((double)(var23 * var23 + var24 * var24 + var25 * var25));
                     float var32 = var5;
                     if (var29 < var31) {
                        float var33 = var31 / var29;
                        var26 *= var33;
                        var27 *= var33;
                        var32 = var5 * (var29 / var31);
                     }

                     int var49 = (int)((float)(var22 >>> 24) * var32 + 0.5F);
                     if (var49 > 0) {
                        var22 = var49 << 24 | var22 & (-307807955 ^ -312949038);
                        int var34 = (int)var3[var21 + 6];
                        if (var34 < 0 || var34 >= 27) {
                           var34 = 0;
                        }

                        float var35 = 1.0F;
                        float var36 = 0.0F;
                        if (var28 != 0.0F) {
                           var35 = (float)Math.cos((double)var28);
                           var36 = (float)Math.sin((double)var28);
                        }

                        float var37 = (var10 * var35 + var13 * var36) * var26;
                        float var38 = (var11 * var35 + var14 * var36) * var26;
                        float var39 = (var12 * var35 + var15 * var36) * var26;
                        float var40 = (var13 * var35 - var10 * var36) * var27;
                        float var41 = (var14 * var35 - var11 * var36) * var27;
                        float var42 = (var15 * var35 - var12 * var36) * var27;
                        float var43 = var6[var34];
                        float var44 = var7[var34];
                        float var45 = var8[var34];
                        float var46 = var9[var34];
                        (var2
                              ? var0.vertex(var23 - var37 - var40, var24 - var38 - var41, var25 - var39 - var42)
                              : var0.vertex(var1, var23 - var37 - var40, var24 - var38 - var41, var25 - var39 - var42))
                           .texture(var43, var46)
                           .color(var22);
                        (var2
                              ? var0.vertex(var23 - var37 + var40, var24 - var38 + var41, var25 - var39 + var42)
                              : var0.vertex(var1, var23 - var37 + var40, var24 - var38 + var41, var25 - var39 + var42))
                           .texture(var43, var44)
                           .color(var22);
                        (var2
                              ? var0.vertex(var23 + var37 + var40, var24 + var38 + var41, var25 + var39 + var42)
                              : var0.vertex(var1, var23 + var37 + var40, var24 + var38 + var41, var25 + var39 + var42))
                           .texture(var45, var44)
                           .color(var22);
                        (var2
                              ? var0.vertex(var23 + var37 - var40, var24 + var38 - var41, var25 + var39 - var42)
                              : var0.vertex(var1, var23 + var37 - var40, var24 + var38 - var41, var25 + var39 - var42))
                           .texture(var45, var46)
                           .color(var22);
                     }
                  }
               }
            }
         }
      } catch (RuntimeException var47) {
         throw var47;
      }
   }

   private static void q(VertexConsumer var0, MatrixStack.Entry var1, boolean var2, float[] var3, int var4, float var5) {

      assert var0 != null
         && var3 != null
         && var4 > 0
         && (long)var4 * 11L <= (long)var3.length
         && var3.length % 11 == 0
         && (var2 || var1 != null)
         && var5 >= 0.0F
         && var5 <= 1.0F
         && ac >= 1.0F
         && FacetArrayCache.U0.length == 27
         && FacetArrayCache.V0.length == 27
         && FacetArrayCache.U1.length == 27
         && FacetArrayCache.V1.length == 27
         && FacetArrayCache.U0[1] == FacetArrayCache.U1[1]
         && FacetArrayCache.V0[1] < FacetArrayCache.V1[1]
         && FacetArrayCache.U0[2] == FacetArrayCache.U1[2]
         && FacetArrayCache.V0[2] < FacetArrayCache.V1[2]
         && (var3 == LT || var3 == LA || var3 == LB)
         && (-749813260 ^ -749807628) == LT.length
         && (-1814987515 ^ -1815077627) == LA.length
         && (787097202 ^ 787099762) == LB.length : "emitLines: bad batch";

      try {
         float[] var6 = FacetArrayCache.U0;
         float[] var7 = FacetArrayCache.V0;
         float[] var8 = FacetArrayCache.V1;
         float var9 = fX;
         float var10 = fY;
         float var11 = fZ;
         float var12 = 5.681818F / ac;

         for (int var13 = 0; var13 < var4; var13++) {
            int var14 = var13 * 11;
            int var15 = Float.floatToRawIntBits(var3[var14 + 8]);
            int var16 = Float.floatToRawIntBits(var3[var14 + 9]);
            if ((var15 | var16) >>> 24 != 0) {
               float var17 = var3[var14];
               float var18 = var3[var14 + 1];
               float var19 = var3[var14 + 2];
               float var20 = var3[var14 + 3];
               float var21 = var3[var14 + 4];
               float var22 = var3[var14 + 5];
               float var23 = var3[var14 + 6];
               float var24 = var3[var14 + 7];
               float var25 = (var23 > var24 ? var23 : var24) + 0.01F;
               if (!(var17 * var9 + var18 * var10 + var19 * var11 < -var25) || !(var20 * var9 + var21 * var10 + var22 * var11 < -var25)) {
                  float var26 = var20 - var17;
                  float var27 = var21 - var18;
                  float var28 = var22 - var19;
                  float var29 = var27 * var19 - var28 * var18;
                  float var30 = var28 * var17 - var26 * var19;
                  float var31 = var26 * var18 - var27 * var17;
                  float var32 = var27 * var22 - var28 * var21;
                  float var33 = var28 * var20 - var26 * var22;
                  float var34 = var26 * var21 - var27 * var20;
                  float var35 = (float)Math.sqrt((double)(var29 * var29 + var30 * var30 + var31 * var31));
                  float var36 = (float)Math.sqrt((double)(var32 * var32 + var33 * var33 + var34 * var34));
                  if (var35 > 1.0E-9F && var36 > 1.0E-9F) {
                     float var37 = (float)Math.sqrt((double)(var17 * var17 + var18 * var18 + var19 * var19));
                     float var38 = (float)Math.sqrt((double)(var20 * var20 + var21 * var21 + var22 * var22));
                     float var39 = var12 * var37;
                     float var40 = var12 * var38;
                     float var41 = var23 > var39 ? var23 : var39;
                     float var42 = var24 > var40 ? var24 : var40;
                     float var43 = var41 > 0.0F && var23 > 0.0F ? var23 / var41 : 0.0F;
                     float var44 = var42 > 0.0F && var24 > 0.0F ? var24 / var42 : 0.0F;
                     int var45 = (int)((float)(var15 >>> 24) * var43 * var5 + 0.5F);
                     int var46 = (int)((float)(var16 >>> 24) * var44 * var5 + 0.5F);
                     if ((var45 | var46) != 0) {
                        int var47 = var45 << 24 | var15 & (131338404 ^ 120319835);
                        int var48 = var46 << 24 | var16 & (-395879289 ^ -392649864);
                        float var49 = var41 * 0.5F / var35;
                        float var50 = var42 * 0.5F / var36;
                        var29 *= var49;
                        var30 *= var49;
                        var31 *= var49;
                        var32 *= var50;
                        var33 *= var50;
                        var34 *= var50;
                        int var51 = (int)var3[var14 + 10];
                        if (var51 < 0 || var51 >= 27) {
                           var51 = 1;
                        }

                        float var52 = var6[var51];
                        float var53 = var7[var51];
                        float var54 = var8[var51];
                        (var2
                              ? var0.vertex(var17 - var29, var18 - var30, var19 - var31)
                              : var0.vertex(var1, var17 - var29, var18 - var30, var19 - var31))
                           .texture(var52, var53)
                           .color(var47);
                        (var2
                              ? var0.vertex(var17 + var29, var18 + var30, var19 + var31)
                              : var0.vertex(var1, var17 + var29, var18 + var30, var19 + var31))
                           .texture(var52, var54)
                           .color(var47);
                        (var2
                              ? var0.vertex(var20 + var32, var21 + var33, var22 + var34)
                              : var0.vertex(var1, var20 + var32, var21 + var33, var22 + var34))
                           .texture(var52, var54)
                           .color(var48);
                        (var2
                              ? var0.vertex(var20 - var32, var21 - var33, var22 - var34)
                              : var0.vertex(var1, var20 - var32, var21 - var33, var22 - var34))
                           .texture(var52, var53)
                           .color(var48);
                     }
                  }
               }
            }
         }
      } catch (RuntimeException var55) {
         throw var55;
      }
   }
}
