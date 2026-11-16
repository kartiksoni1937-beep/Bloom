package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Snippet;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.platform.DestFactor;
import com.mojang.blaze3d.platform.SourceFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Random;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.LerpZoneBuffer;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderContext;
import net.fabricmc.fabric.api.client.rendering.v1.world.WorldRenderEvents;
import net.fabricmc.fabric.api.event.Event;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.client.render.OutputTarget;
import net.minecraft.client.render.RenderSetup;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.block.BlockState;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.world.chunk.WorldChunk;
import net.minecraft.util.Identifier;
import net.minecraft.client.MinecraftClient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.math.MathHelper;
import net.minecraft.fluid.FluidState;
import net.minecraft.world.RaycastContext;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.block.enums.CameraSubmersionType;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.client.network.ClientPlayerEntity;
import org.joml.Vector3fc;
import net.minecraft.world.Heightmap;import net.minecraft.util.hit.HitResult;import net.minecraft.util.math.BlockPos;import net.minecraft.client.util.math.MatrixStack;
public final class FieldVolumeCache {
   private static boolean bi = false;
   private static boolean bj = false;
   private static boolean bk = false;
   private static boolean bl = false;
   private static int bm = 0;
   private static RenderLayer bn;
   private static RenderLayer bo;
   private static RenderLayer bp;
   private static RenderLayer bq;
   private static RenderLayer br;
   private static RenderLayer bs;
   private static RenderLayer bt;
   private static RenderLayer bu;
   private static float bv = 0.0F;
   private static int bw = 0;
   private static float bx = 0.0F;
   private static float by = 150.0F;
   private static final Identifier bz = Identifier.of("lithium", "lq" + "_grade_phase");
   private static final float[] ca = new float[9];
   private static final float[] cb = new float[]{0.74F, 0.78F, 0.84F};
   private static final float[] cc = new float[]{0.16470589F, 0.18039216F, 0.22745098F};
   private static RenderPipeline cd;
   private static RenderPipeline ce;
   private static OutputTarget cf;
   private static final Identifier cg = Identifier.of("lithium", "lq" + "_s" + "oft_dot");
   public static final Identifier PETAL_TEX = Identifier.of("lithium", "lq_petal");
   private static final int ch = 1024;
   public static final Identifier BRANCH_TEX = Identifier.of("lithium", "lq_b" + "ran" + "ch");
   public static final Identifier AURA_TEX = Identifier.of("lithium", "lq_aura");
   private static final Identifier ci = Identifier.of("lithium", "lq_snow");
   private static final Identifier cj = Identifier.of("lithium", "lq_sun");
   private static volatile NativeImage ck;
   private static volatile NativeImage cl;
   private static volatile NativeImage cm;
   private static volatile NativeImage cn;
   private static volatile NativeImage co;
   private static volatile boolean cp = false;
   private static volatile boolean cq = false;
   private static volatile boolean cr = false;
   private static volatile boolean cs = false;
   private static volatile boolean ct = false;
   private static volatile boolean cu = false;
   private static volatile boolean cv = false;
   private static boolean cw = false;
   private static boolean cx = false;
   private static boolean cy = false;
   private static boolean cz = false;
   private static boolean da = false;
   private static boolean db = false;
   private static boolean dc = true;
   private static final float[] dd = new float[32];
   private static final float[] de = new float[32];
   private static final float[] df = new float[32];
   private static final float[] dg = new float[32];
   private static final float[] dh = new float[]{0.0F, 0.25F, 0.375F, 0.4375F};
   private static final float[] di = new float[]{0.25F, 0.375F, 0.4375F, 0.46875F};
   private static final float[] dj = new float[]{0.75F, 0.75F, 0.75F, 0.75F};
   private static final float[] dk = new float[]{1.0F, 0.875F, 0.8125F, 0.78125F};
   private static volatile boolean dl = false;
   private static final float[] dm = new float[]{0.5F, 0.75F, 0.875F, 0.9375F};
   private static final float[] dn = new float[]{0.75F, 0.875F, 0.9375F, 0.96875F};
   private static final float[] _kwren_do= new float[]{0.75F, 0.75F, 0.75F, 0.75F};
   private static final float[] dp = new float[]{1.0F, 0.875F, 0.8125F, 0.78125F};
   private static final float[] dq = new float[]{0.875F, 0.875F, 0.9375F};
   private static final float[] dr = new float[]{1.0F, 0.9375F, 0.96875F};
   private static final float[] ds = new float[]{0.5F, 0.625F, 0.625F};
   private static final float[] dt = new float[]{0.625F, 0.6875F, 0.65625F};
   private static final float[] du = new float[64];
   private static final float[] dv = new float[64];
   private static final float[] dw = new float[64];
   private static final float[] dx = new float[64];
   public static boolean dy = false;
   public static boolean dz = false;
   public static float ea = 1.0F;
   private static boolean eb = false;
   private static float ec = 1.0F;
   private static final Random ed = new Random();
   private static final float[] ee = new float[9];
   private static final float ef = (float) (Math.PI * 2);
   private static int eg = 0;
   private static final int eh = 4200;
   private static final double ei = 22.0;
   private static final double ej = 14.0;
   private static final double ek = 22.0;
   private static final double el = 4.5;
   private static final double em = 3.5;
   private static final double en = 11.0;
   private static final double eo = 7.0;
   private static final double[] ep = new double[4200];
   private static final double[] eq = new double[4200];
   private static final double[] er = new double[4200];
   private static final float[] es = new float[4200];
   private static final float[] et = new float[4200];
   private static final float[] eu = new float[4200];
   private static final float[] ev = new float[4200];
   private static final float[] ew = new float[4200];
   private static final float[] fa = new float[4200];
   private static final float[] fb = new float[4200];
   private static final float[] fc = new float[4200];
   private static final float[] fd = new float[4200];
   private static final float[] fe = new float[4200];
   private static final int[] ff = new int[4200];
   private static boolean fg = false;
   private static float fh = 0.0F;
   private static int fi = 0;
   private static int fj = 0;
   private static float fk = 1.0F;
   private static float fl = 0.0F;
   private static float fm = 0.0F;
   private static final int fn = 5000;
   private static final int fo = 10000;
   private static final double fp = 44.0;
   private static final double fq = 22.0;
   private static final double fr = 44.0;
   private static final double[] fs = new double[10000];
   private static final double[] ft = new double[10000];
   private static final double[] fu = new double[10000];
   private static final float[] fv = new float[10000];
   private static final float[] fw = new float[10000];
   private static final float[] fx = new float[10000];
   private static boolean fy = false;
   private static float fz = 0.0F;
   private static final int ga = 520;
   private static final double[] gb = new double[520];
   private static final double[] gc = new double[520];
   private static final double[] gd = new double[520];
   private static final float[] ge = new float[520];
   private static final float[] gf = new float[520];
   private static final float[] gg = new float[520];
   private static final float[] gh = new float[520];
   private static final float[] gi = new float[520];
   private static final float[] gj = new float[520];
   private static final float[] gk = new float[520];
   private static final float[] gl = new float[520];
   private static final float[] gm = new float[520];
   private static boolean gn = false;
   private static float go = 0.0F;
   private static int gp = 0;
   private static int gq = 0;
   private static final int gr = 380;
   private static final int gs = 475;
   private static final double gt = 14.0;
   private static final double gu = 8.0;
   private static final double gv = 14.0;
   private static final double[] gw = new double[475];
   private static final double[] ha = new double[475];
   private static final double[] hb = new double[475];
   private static final float[] hc = new float[475];
   private static final float[] hd = new float[475];
   private static final float[] he = new float[475];
   private static final float[] hf = new float[475];
   private static final float[] hg = new float[475];
   private static final float[] hh = new float[475];
   private static final float[] hi = new float[475];
   private static boolean hj = false;
   private static float hk = 0.0F;
   private static final int hl = 320;
   private static final double[] hm = new double[320];
   private static final double[] hn = new double[320];
   private static final double[] ho = new double[320];
   private static final float[] hp = new float[320];
   private static final float[] hq = new float[320];
   private static final float[] hr = new float[320];
   private static final float[] hs = new float[320];
   private static final float[] ht = new float[320];
   private static final float[] hu = new float[320];
   private static final float[] hv = new float[320];
   private static final float[] hw = new float[320];
   private static final float[] hx = new float[320];
   private static final float[] hy = new float[320];
   private static final float[] hz = new float[320];
   private static boolean ia = false;
   private static float ib = 0.0F;
   private static final int ic = 2800;
   private static final double id = 20.0;
   private static final double ie = 11.0;
   private static final double _kwren_if= 20.0;
   private static final double[] ig = new double[2800];
   private static final double[] ih = new double[2800];
   private static final double[] ii = new double[2800];
   private static final float[] ij = new float[2800];
   private static final float[] ik = new float[2800];
   private static final float[] il = new float[2800];
   private static final float[] im = new float[2800];
   private static final float[] in = new float[2800];
   private static final float[] io = new float[2800];
   private static final float[] ip = new float[2800];
   private static final float[] iq = new float[2800];
   private static final float[] ir = new float[2800];
   private static final float[] is = new float[2800];
   private static boolean it = false;
   private static float iu = 0.0F;
   private static int iv = 0;
   private static int iw = 0;
   private static final int ix = 40;
   private static final double iy = 26.0;
   private static final double iz = 9.0;
   private static final double ja = 26.0;
   private static final double[] jb = new double[40];
   private static final double[] jc = new double[40];
   private static final double[] jd = new double[40];
   private static final float[] je = new float[40];
   private static final float[] jf = new float[40];
   private static final float[] jg = new float[40];
   private static final float[] jh = new float[40];
   private static boolean ji = false;
   private static final int jj = 1100;
   private static final double jk = 18.0;
   private static final double jl = 12.0;
   private static final double jm = 18.0;
   private static final double[] jn = new double[1100];
   private static final double[] jo = new double[1100];
   private static final double[] jp = new double[1100];
   private static final float[] jq = new float[1100];
   private static final float[] jr = new float[1100];
   private static final float[] js = new float[1100];
   private static final float[] jt = new float[1100];
   private static final float[] ju = new float[1100];
   private static boolean jv = false;
   private static float jw = 0.0F;
   private static float jx = 0.0F;
   private static final float jy = 0.8F;
   private static final float jz = 0.6F;
   private static final float ka = 0.3F;
   private static float kb = 1.0F;
   private static final int kc = 4600;
   private static final float kd = 0.1F;
   private static final float ke = 0.45F;
   private static final float kf = 0.06F;
   private static final float kg = 0.038F;
   private static final float kh = 0.125F;
   private static final float ki = 0.06F;
   private static final float kj = 0.09F;
   private static final float kk = 0.078F;
   private static final float kl = 0.3F;
   private static float km = 0.0F;
   private static final float kn = (float) Math.PI;
   private static final double ko = 20.0;
   private static final double kp = 14.0;
   private static final double kq = 20.0;
   private static final double[] kr = new double[4600];
   private static final double[] ks = new double[4600];
   private static final double[] kt = new double[4600];
   private static final float[] ku = new float[4600];
   private static final float[] kv = new float[4600];
   private static final float[] kw = new float[4600];
   private static final float[] kx = new float[4600];
   private static final float[] ky = new float[4600];
   private static final float[] kz = new float[4600];
   private static final float[] la = new float[4600];
   private static final float[] lb = new float[4600];
   private static final float[] lc = new float[4600];
   private static final float[] ld = new float[4600];
   private static final float[] le = new float[4600];
   private static final float[] lf = new float[4600];
   private static final float[] lg = new float[4600];
   private static final float[] lh = new float[4600];
   private static final float[] li = new float[4600];
   private static final float[] lj = new float[4600];
   private static final float[] lk = new float[4600];
   private static final float[] ll = new float[4600];
   private static final float[] lm = new float[4600];
   private static final int[] ln = new int[4600];
   private static boolean lo = false;
   private static float lp = 0.0F;
   private static final int lq = 6000;
   private static final int lr = 450;
   private static final byte ls = 0;
   private static final byte lt = 1;
   private static final byte lu = 2;
   private static final byte lv = 3;
   private static final double[] lw = new double[6000];
   private static final double[] lx = new double[6000];
   private static final double[] ly = new double[6000];
   private static final float[] lz = new float[6000];
   private static final float[] ma = new float[6000];
   private static final float[] mb = new float[6000];
   private static final float[] mc = new float[6000];
   private static final float[] md = new float[6000];
   private static final float[] me = new float[6000];
   private static final float[] mf = new float[6000];
   private static final float[] mg = new float[6000];
   private static final float[] mh = new float[6000];
   private static final float[] mi = new float[6000];
   private static final float[] mj = new float[6000];
   private static final float[] mk = new float[6000];
   private static final float[] ml = new float[6000];
   private static final float[] mm = new float[6000];
   private static final float[] mn = new float[6000];
   private static final float[] mo = new float[6000];
   private static final float[] mp = new float[6000];
   private static final int[] mq = new int[6000];
   private static final int[] mr = new int[6000];
   private static final int[] ms = new int[6000];
   private static final byte[] mt = new byte[6000];
   private static int mu = 0;
   private static int mv = 0;
   private static int mw = 0;
   private static boolean na = false;
   private static float nb = 0.0F;
   private static float nc = 0.0F;
   private static float nd = 0.0F;
   private static float ne = 0.0F;
   private static float nf = 0.0F;
   private static float ng = 0.0F;
   private static final int[] nh = new int[16384];
   private static final float ni = 0.014F;
   private static final float nj = 0.0042F;
   private static final float nk = 0.02F;
   private static final int nl = 36;
   private static final int nm = 384;
   private static final float[] nn = new float[4992];
   private static final float[] no = new float[384];
   private static final int[] np = new int[384];
   private static final int[] nq = new int[384];
   private static int nr = 0;
   private static final int ns = 12;
   private static final double[] nt = new double[12];
   private static final double[] nu = new double[12];
   private static final double[] nv = new double[12];
   private static final float[] nw = new float[12];
   private static final float[] nx = new float[12];
   private static final float[] ny = new float[12];
   private static final float[] nz = new float[12];
   private static final float[] oa = new float[12];
   private static int ob = 0;
   private static boolean oc = false;
   private static double od;
   private static double oe;
   private static double of;
   private static double og;
   private static boolean oh = true;
   private static float oi = 0.0F;
   private static float oj = 0.0F;
   private static float ok = 0.0F;
   private static float ol = 800.0F;
   private static float om = -1.0F;
   private static float on = 0.0F;
   private static float oo = 0.0F;
   private static float op = 0.0F;
   private static long oq = 0L;
   private static boolean or = false;
   private static float os = 0.0F;
   private static float ot = 1.0F;
   private static boolean ou = false;
   private static float ov = 0.0F;
   private static float ow = 0.0F;
   private static float ox = 0.0F;
   private static float oy = 0.0F;
   private static float oz = 1.0F;
   private static float pa = 1.0F;
   private static float pb = 0.0F;
   private static float pc = 0.0F;
   private static float pd = 0.0F;
   private static float pe = 0.0F;
   private static float pf = 0.0F;
   private static float pg = 0.0F;
   private static boolean ph = false;
   private static double pi;
   private static double pj;
   private static double pk;
   private static float pl;
   private static float pm;
   private static float pn;
   private static long po = 0L;
   private static final int pp = 24;
   private static final int pq = 49;
   private static final float pr = -1.0E9F;
   private static final int[] ps = new int[2401];
   private static final float[] pt = new float[2401];
   private static final byte[] pu = new byte[2401];
   private static final float[] pv = new float[2401];
   private static final float[] pw = new float[2401];
   private static final float[] qa = new float[153664];
   private static final byte[] qb = new byte[153664];
   private static final IdentityHashMap<BlockState, Float> qc = new IdentityHashMap<>();
   private static final BlockPos.Mutable qd = new BlockPos.Mutable();
   private static final int[] qe = new int[2401];
   private static final int[] qf = new int[2401];
   private static final float[] qg = new float[2401];
   private static final float[] qh = new float[2401];
   private static int qi = 0;
   private static int qj;
   private static int qk;
   private static long ql = 0L;
   private static boolean qm = false;
   private static boolean qn = false;
   private static int qo = 3;
   private static int qq = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   private FieldVolumeCache() {
   }

   public static void a() {

      if (!bi) {
         bi = true;

         try {
            ShellArrayCache.a();
         } catch (Throwable var4) {
         }

         try {
            WorldRenderEvents.END_MAIN.register(FieldVolumeCache::d);
         } catch (Throwable var3) {
         }

         try {
            WorldRenderEvents.END_MAIN.addPhaseOrdering(bz, Event.DEFAULT_PHASE);
            WorldRenderEvents.END_MAIN.register(bz, FieldVolumeCache::e);
         } catch (Throwable var2) {
         }

         try {
            Thread var0 = new Thread(() -> {

               int[] var0x = null;

               try {
                  var0x = PaletteArrayCache.a();
               } catch (Throwable var11) {
                  cu = true;
               }

               int[] var1x = null;

               try {
                  var1x = LevelArrayCache.a();
               } catch (Throwable var10) {
                  cv = true;
               }

               if (var0x == null && var1x == null) {
                  cp = true;
               } else {
                  int[] var2x = new int[524288];
                  if (var0x != null) {
                     System.arraycopy(var0x, 0, var2x, 0, 1814764014 ^ 1815026158);
                  }

                  if (var1x != null) {
                     System.arraycopy(var1x, 0, var2x, -1795104007 ^ -1794841863, 468470323 ^ 468208179);
                  }

                  try {
                     ck = i(var2x, -330733895 ^ -330734407, 883328430 ^ 883327406);
                  } catch (Throwable var9) {
                     cp = true;
                  }
               }

               try {
                  cn = i(BatchArrayCache.a(var0x), -1983458773 ^ -1983457749, -2086344822 ^ -2086342774);
               } catch (Throwable var8) {
                  cs = true;
               }

               try {
                  cl = i(SurfaceArrayCache.a(), 1526185694 ^ 1526185182, -1244853964 ^ -1244853836);
               } catch (Throwable var7) {
                  cq = true;
               }

               try {
                  int[] var12 = SampleArrayCache.a();

                  try {
                     StrataArrayCache.l(var12);
                     dl = true;
                  } catch (Throwable var5) {
                     dl = false;
                  }

                  cm = i(var12, -258792506 ^ -258793018, 1649171590 ^ 1649172102);
               } catch (Throwable var6) {
                  cr = true;
               }

               try {
                  co = i(AreaArrayCache.a(), -1197773441 ^ -1197772929, 1031033817 ^ 1031033561);
               } catch (Throwable var4x) {
                  ct = true;
               }
            }, "Wo" + "rker-Lithium-B" + "a" + "ke");
            var0.setDaemon(true);
            var0.setPriority(1);
            var0.start();
         } catch (Throwable var1) {
            cp = true;
            cq = true;
            cr = true;
            cs = true;
            ct = true;
         }
      }
   }

   public static boolean b() {

      if (db) {
         return true;
      } else if (ct) {
         return false;
      } else {
         NativeImage var0 = co;
         if (var0 == null) {
            return false;
         } else {
            co = null;

            try {
               if (j(MinecraftClient.getInstance(), AURA_TEX, "li" + "t" + "hium" + "-aura", var0)) {
                  db = true;
               } else {
                  ct = true;
               }
            } catch (Throwable var2) {
               ct = true;
            }

            return db;
         }
      }
   }

   public static float c() {

      LerpZoneBuffer var0 = LerpZoneBuffer.I;
      if (!bl && var0 != null && LerpZoneBuffer.LIC) {
         float var1 = var0.cv * var0.da;
         float[] var2 = var0.pw;
         float var3 = var1 * var2[7] * 0.85F;
         if (eb) {
            var3 += var1 * (var2[2] + var2[5]) * 2.0F;
         }

         if (ShellArrayCache.am) {
            var3 += var1 * var2[9] * 2.0F;
         }

         if (ShellArrayCache.ay) {
            var3 += var1 * var2[11] * 2.0F;
         }

         if (ShellArrayCache.an) {
            var3 += var1 * (var2[1] + var2[7]) * 2.0F;
         }

         return var3 >= 1.0F ? 0.0F : 1.0F - var3;
      } else {
         return 1.0F;
      }
   }

   private static void d(WorldRenderContext var0) {

      boolean var1 = !dz || dy;
      dy = false;
      bx = 0.0F;
      if (bl) {
         eb = false;
      } else {
         boolean var2 = false;

         try {
            LerpZoneBuffer var3 = LerpZoneBuffer.I;
            if (var3 == null || ConfigBridge.c == null) {
               return;
            }

            MinecraftClient var4 = MinecraftClient.getInstance();
            if (var4.world == null || var4.player == null) {
               return;
            }

            int var5 = System.identityHashCode(var4.world);
            if (var5 != eg) {
               eg = var5;
               n();
            }

            if (!LerpZoneBuffer.ae) {
               ph = false;
               po = System.nanoTime();
               if (na) {
                  o();
               }

               nb = 0.0F;
               nc = 0.0F;
               nd = 0.0F;
               return;
            }

            var3.a();
            if (!LerpZoneBuffer.LIC) {
               return;
            }

            long var6 = System.nanoTime();
            float[] var8 = var3.pw;
            float var9 = var8[0];
            float var10 = var8[1];
            float var11 = var8[7];
            float var12 = var8[8];
            float var13 = var3.cw;
            boolean var14 = var1 && var6 - var3.et < 250000000L;
            float var15 = var14 ? var3.cv * var3.da : 0.0F;
            float var16 = var14 ? var15 * var10 * ea : 0.0F;
            float var17 = var8[5];
            float var18 = var8[2] + var17;
            float var19 = var18 > 1.0E-4F ? var17 / var18 : 0.0F;
            float var20 = var14 ? var15 * var18 * ea : 0.0F;
            float var21 = var14 ? var15 * var11 * ea : 0.0F;
            float var22 = Math.min(1.0F, 1.45F * var3.cv * var3.da) * var8[11];
            if (!(var13 <= 0.002F) || !(var16 <= 0.002F) || !(var20 <= 0.002F) || !(var21 <= 0.002F) || !(var22 <= 0.002F)) {
               float var23 = po == 0L ? 0.0F : (float)(var6 - po) / 1.0E9F;
               po = var6;
               if (var23 < 0.0F) {
                  var23 = 0.0F;
               }

               if (var23 > 0.1F) {
                  var23 = 0.1F;
               }

               if (!bj) {
                  h(var4);
               }

               if (!bk) {
                  return;
               }

               if (dc) {
                  l(var4);
               }

               try {
                  float var24 = (float)var4.getWindow().getFramebufferHeight();
                  int var25 = (Integer)var4.options.getFov().getValue();
                  ol = var24 / (2.0F * (float)Math.tan(Math.toRadians((double)var25) * 0.5));
                  float var26 = (float)var4.getWindow().getFramebufferWidth();
                  double var27 = Math.tan(Math.toRadians(Math.min(170.0, (double)var25 * 1.5)) * 0.5);
                  double var29 = var27 * (double)var26 / (double)var24;
                  float var31 = (float)(1.0 / Math.sqrt(1.0 + var27 * var27 + var29 * var29)) - 0.05F;
                  or = var31 > 0.02F && var26 >= 1.0F && var24 >= 1.0F;
                  os = var31 * var31;
                  ot = (float)Math.sqrt(1.0 - (double)(var31 * var31));
                  if (var4.player.hurtTime > 0
                     || var4.player.nauseaIntensity > 0.0F
                     || var4.player.lastNauseaIntensity > 0.0F
                     || var4.player.hasStatusEffect(StatusEffects.NAUSEA)) {
                     or = false;
                  }
               } catch (Throwable var93) {
                  ol = 800.0F;
                  or = false;
               }

               Camera var99 = var4.gameRenderer.getCamera();
               Vec3d var100 = var99.getCameraPos();
               Vector3fc var101 = var99.getHorizontalPlane();
               Vector3fc var102 = var99.getVerticalPlane();
               Vector3fc var28 = var99.getDiagonalPlane();
               float[] var103 = ee;
               var103[0] = -var28.x();
               var103[1] = -var28.y();
               var103[2] = -var28.z();
               var103[3] = var102.x();
               var103[4] = var102.y();
               var103[5] = var102.z();
               var103[6] = var101.x();
               var103[7] = var101.y();
               var103[8] = var101.z();
               float var30 = 1.0F;
               boolean var104 = false;

               try {
                  CameraSubmersionType var32 = var99.getSubmersionType();
                  var104 = var32 == CameraSubmersionType.WATER;
                  if (var32 != CameraSubmersionType.LAVA && var32 != CameraSubmersionType.POWDER_SNOW) {
                     if (var99.getFocusedEntity() instanceof LivingEntity var33
                        && (var33.hasStatusEffect(StatusEffects.BLINDNESS) || var33.hasStatusEffect(StatusEffects.DARKNESS))) {
                        var30 = 0.0F;
                     }
                  } else {
                     var30 = 0.0F;
                  }
               } catch (Throwable var92) {
               }

               ec = ec + (var30 - ec) * (1.0F - (float)Math.exp((double)(-var23 * 6.0F)));
               float var105 = ec;
               bv = bv + ((var104 ? 0.0F : 1.0F) - bv) * (1.0F - (float)Math.exp((double)(-var23 * 5.0F)));
               q(var100, var23);
               float var106 = cu ? 0.0F : var8[2];
               float var107 = cv ? 0.0F : var8[5];
               float var35 = var106 + var107;
               float var36 = var35 > 1.0E-4F ? var107 / var35 : 0.0F;
               boolean var37 = cw && (var13 > 0.002F && var35 > 0.001F || na);
               float var38 = var8[10];
               float var39 = var8[11];
               boolean var40 = var13 > 0.002F
                  && (
                     var9 > 0.001F
                        || var10 > 0.001F
                        || var11 > 0.001F
                        || var12 > 0.001F
                        || var38 > 0.001F
                        || var39 > 0.001F
                        || var8[3] + var8[4] + var8[9] + var8[12] > 0.001F
                  );
               r(var4, var100, var6, var40, var37);
               p(var99, var104);
               VertexConsumerProvider var41 = var0.consumers();
               MatrixStack.Entry var42 = var0.matrices().peek();
               ou = (var42.getPositionMatrix().properties() & 4) != 0;
               double var43 = var3.dd;
               float var45 = 0.35F + 0.65F * var3.da;
               ov = var3.di;
               ow = var3.db;
               ox = var3.dh;
               oy = var3.dc;
               oz = var3.ev;
               pa = var3.ew;
               float var46 = var9 + var38 + var39;
               float var47 = var13 * (var9 + 0.8F * var38 + var39) * var45 * var105;
               if (var46 > 1.0E-4F) {
                  fk = var9 / var46;
                  fl = var38 / var46;
                  fm = var39 / var46;
               }

               float var48 = var10 + 0.6F * var12;
               float var49 = var13 * var48 * var45 * var105;
               float var50 = var48 > 1.0E-4F ? 0.6F * var12 / var48 : 0.0F;
               kb = var10 + var12 > 1.0E-4F ? (var10 + 0.3F * var12) / (var10 + var12) : 1.0F;
               float var51 = var13 * var35 * var45 * var105;
               float var52 = var13 * var8[6] * var45 * var105;
               float var53 = var13 * var11 * var45 * var105;
               float var54 = var12 + 0.8F * var10;
               float var55 = var13 * var54 * var45 * var105;
               jx = var54 > 1.0E-4F ? 0.8F * var10 / var54 : 0.0F;
               km = var51 < 0.05F ? var36 : km + (var36 - km) * (1.0F - (float)Math.exp((double)(-var23 * 0.8F)));
               boolean var56 = var13 > 0.002F && var3.v();
               var16 *= var105;
               var20 *= var105;
               var21 *= var105;
               float var57 = Math.max(150.0F, (float)var4.options.getClampedViewDistance() * 16.0F * 1.5F);
               float var58 = var4.gameRenderer.getFarPlaneDistance();
               if (var58 > 10.0F && var57 > var58 / 2.4F) {
                  var57 = var58 / 2.4F;
               }

               float var59 = var3.er * (float) (Math.PI / 180.0);
               om = -MathHelper.sin((double)var59);
               on = MathHelper.cos((double)var59);
               float var60 = om * var57;
               float var61 = on * var57;
               float var62 = !(var16 > 0.002F) && !(var20 > 0.002F) && !(var21 > 0.002F) ? 0.0F : var3.eu;
               boolean var63 = cw && qn && var56 && var35 > 0.01F;
               nb = nb + ((var63 ? 1.0F : 0.0F) - nb) * (1.0F - (float)Math.exp((double)(-var23 * 2.5F)));
               float var64 = 1.0F - (float)Math.exp((double)(-var23 * 3.0F));
               float var65 = 1.0F - (float)Math.exp((double)(-var23 * 0.6F));
               nc = nc + ((var106 > 0.02F ? 1.0F : 0.0F) - nc) * (var106 > 0.02F ? var64 : var65);
               nd = nd + ((var107 > 0.02F ? 1.0F : 0.0F) - nd) * (var107 > 0.02F ? var64 : var65);
               boolean var66 = cw && qn && (var63 || na && nb > 0.01F);
               if (!var66 && na) {
                  o();
               }

               boolean var67 = cw && var51 > 0.002F;
               if (var67 || var66) {
                  w(var4, var100, var23);
               }

               float var68 = var22 * bv * var105;
               bx = var68 > 1.0F ? 1.0F : var68;
               by = var57;
               boolean var69 = false;
               if (var20 > 0.002F && cx) {
                  y(var4, var100, var60, var61, var6, var23);
                  VertexConsumer var70 = var41.getBuffer(bs);
                  SurfaceArrayCache.j(var70, var42, var60, var61, 0.0F, var57, var20 * Math.max(var62, 0.35F), oy, var43, var103, oo, var19);
                  var69 = true;
                  var2 = true;
               }

               boolean var108 = false;
               boolean var71 = var20 > 0.002F && !cx;
               boolean var72 = var16 > 0.002F || var71 || var21 > 0.002F;
               if (var72) {
                  VertexConsumer var73 = var41.getBuffer(bp);
                  if (var16 > 0.002F) {
                     av(var73, var42, var60, var61, var16 * Math.max(var62, 0.35F), var43, var57, var103);
                  }

                  if (var21 > 0.002F) {
                     ay(var73, var42, var60, var61, var21 * var62, var43, var57, var103);
                  }

                  if (var71) {
                     aw(var73, var42, var60, var61, var20 * Math.max(var62, 0.35F), var43, var57, var103, var19);
                  }

                  var108 = true;
               }

               boolean var109 = false;
               boolean var74 = false;
               if (var53 > 0.002F && cy) {
                  VertexConsumer var75 = var41.getBuffer(br);
                  am(var75, var42, var100, var23, var43, var53, var103, true);
                  var74 = true;
               }

               if (var53 > 0.002F) {
                  VertexConsumer var110 = var41.getBuffer(bn);
                  if (!cy) {
                     am(var110, var42, var100, var23, var43, var53, var103, false);
                  }

                  ak(var110, var42, var100, var23, var43, var53, var103);
                  var109 = true;
               }

               if (var55 > 0.002F) {
                  VertexConsumer var111 = var41.getBuffer(cy ? br : bn);
                  ao(var111, var42, var100, var23, var43, var55, var103, cy);
                  if (cy) {
                     var74 = true;
                  } else {
                     var109 = true;
                  }
               }

               if (var47 > 0.002F) {
                  VertexConsumer var112 = var41.getBuffer(cy ? br : bn);
                  ab(var112, var42, var100, var23, var43, var47, var103, cy);
                  if (cy && dl && fl + fm > 0.01F) {
                     ac(var112, var42, var100, var23, var43, var47, var103);
                  } else {
                     fz = 0.0F;
                  }

                  if (cy) {
                     var74 = true;
                  } else {
                     var109 = true;
                  }
               }

               boolean var113 = false;
               if (var67 || var66) {
                  VertexConsumer var76 = var41.getBuffer(bq);
                  nr = 0;
                  if (var66) {
                     nf = var106 > 0.02F ? nf + var23 : 0.0F;
                     ng = var107 > 0.02F ? ng + var23 : 0.0F;
                     if (var63) {
                        at(var100, var23, var106, var107);
                     }

                     float var77 = var13 * var45 * var35 * nb * var105;
                     au(var76, var42, var100, var23, var43, var8, var77 * nc, var77 * nd, var103);
                  }

                  if (var67) {
                     aq(var76, var42, var100, var23, var43, var51, var103, var63, km, var14 ? oy : 0.0F);
                  }

                  z(var76, var42);
                  var113 = true;
               }

               boolean var114 = false;
               float var115 = var8[3];
               float var78 = var8[4];
               float var79 = var8[9];
               float var80 = var8[12];
               float var81 = var13 * (var115 + 0.8F * var78 + 0.7F * var79 + 0.3F * var80) * var45 * var105;
               if (var49 > 0.002F || var81 > 0.002F || var52 > 0.002F) {
                  VertexConsumer var82 = var41.getBuffer(bo);
                  if (var49 > 0.002F) {
                     ae(var82, var42, var100, var23, var43, var49, var103, var50);
                  }

                  if (var81 > 0.002F) {
                     float var83 = var115 + var78 + var79 + var80;
                     float var84 = var83 > 1.0E-4F ? var78 / var83 : 0.0F;
                     float var85 = var83 > 1.0E-4F ? var79 / var83 : 0.0F;
                     float var86 = var83 > 1.0E-4F ? var80 / var83 : 0.0F;
                     ag(var82, var42, var100, var23, var43, var81, var84, var85, var86, var103);
                  }

                  if (var52 > 0.002F) {
                     ai(var82, var42, var4.world, var100, var23, var43, var52, var103);
                  }

                  var114 = true;
               }

               if (var81 <= 0.002F) {
                  hj = false;
               }

               if (var41 instanceof VertexConsumerProvider.Immediate var116) {
                  if (var69) {
                     var116.draw(bs);
                  }

                  if (var108) {
                     var116.draw(bp);
                  }

                  if (var109) {
                     var116.draw(bn);
                  }

                  if (var74) {
                     var116.draw(br);
                  }

                  if (var113) {
                     var116.draw(bq);
                  }

                  if (var114) {
                     var116.draw(bo);
                     return;
                  }
               }

               return;
            }

            ph = false;
            po = var6;
            if (na) {
               o();
            }

            nb = 0.0F;
            nc = 0.0F;
            nd = 0.0F;
         } catch (Throwable var94) {
            nr = 0;
            if (++bm > 30) {
               bl = true;
            }

            return;
         } finally {
            eb = var2;
         }
      }
   }

   private static void e(WorldRenderContext var0) {

      float var1 = bx;
      if (!(var1 <= 0.003F) && !bl && bt != null && bu != null) {
         try {
            f(var0, var1);
         } catch (Throwable var3) {
            if (++bw > 5) {
               bt = null;
               bu = null;
            }
         }
      }
   }

   private static void f(WorldRenderContext var0, float var1) {

      Camera var2 = MinecraftClient.getInstance().gameRenderer.getCamera();
      Vector3fc var3 = var2.getHorizontalPlane();
      Vector3fc var4 = var2.getVerticalPlane();
      Vector3fc var5 = var2.getDiagonalPlane();
      float[] var6 = ca;
      var6[0] = -var5.x();
      var6[1] = -var5.y();
      var6[2] = -var5.z();
      var6[3] = var4.x();
      var6[4] = var4.y();
      var6[5] = var4.z();
      var6[6] = var3.x();
      var6[7] = var3.y();
      var6[8] = var3.z();
      MatrixStack.Entry var7 = var0.matrices().peek();
      boolean var8 = (var7.getPositionMatrix().properties() & 4) != 0;
      g(var0.consumers(), var7, var6, by, var1, var8);
   }

   private static void g(VertexConsumerProvider var0, MatrixStack.Entry var1, float[] var2, float var3, float var4, boolean var5) {

      float[] var6 = cb;
      float[] var7 = cc;
      int var8 = (int)((1.0F - var4 * (1.0F - var6[0])) * 255.0F + 0.5F);
      int var9 = (int)((1.0F - var4 * (1.0F - var6[1])) * 255.0F + 0.5F);
      int var10 = (int)((1.0F - var4 * (1.0F - var6[2])) * 255.0F + 0.5F);
      int var11 = (int)(var4 * var7[0] * 255.0F + 0.5F);
      int var12 = (int)(var4 * var7[1] * 255.0F + 0.5F);
      int var13 = (int)(var4 * var7[2] * 255.0F + 0.5F);
      float var14 = var2[6] * var3;
      float var15 = var2[7] * var3;
      float var16 = var2[8] * var3;
      float var17 = 32.0F * var3;
      float var18 = var2[0] * var17;
      float var19 = var2[1] * var17;
      float var20 = var2[2] * var17;
      float var21 = var2[3] * var17;
      float var22 = var2[4] * var17;
      float var23 = var2[5] * var17;

      for (int var24 = 0; var24 < 2; var24++) {
         VertexConsumer var25 = var0.getBuffer(var24 == 0 ? bt : bu);
         int var26 = var24 == 0 ? 603401642 ^ -587780694 | var8 << 16 | var9 << 8 | var10 : -132704378 ^ 118953862 | var11 << 16 | var12 << 8 | var13;

         for (int var27 = 0; var27 < 4; var27++) {
            float var28 = var27 != 0 && var27 != 1 ? 1.0F : -1.0F;
            float var29 = var27 != 0 && var27 != 3 ? 1.0F : -1.0F;
            float var30 = var14 + var28 * var18 + var29 * var21;
            float var31 = var15 + var28 * var19 + var29 * var22;
            float var32 = var16 + var28 * var20 + var29 * var23;
            if (var5) {
               var25.vertex(var30, var31, var32).texture(0.5F, 0.5F).color(var26);
            } else {
               var25.vertex(var1, var30, var31, var32).texture(0.5F, 0.5F).color(var26);
            }
         }

         if (var0 instanceof VertexConsumerProvider.Immediate var33) {
            var33.draw(var24 == 0 ? bt : bu);
         }
      }
   }

   private static void h(MinecraftClient var0) {

      if (!bj) {
         bj = true;

         try {
            byte var1 = 64;
            NativeImage var2 = new NativeImage(NativeImage.Format.RGBA, var1, var1, false);

            for (int var3 = 0; var3 < var1; var3++) {
               for (int var4 = 0; var4 < var1; var4++) {
                  double var5 = ((double)var4 + 0.5) / ((double)var1 * 0.5) - 1.0;
                  double var7 = ((double)var3 + 0.5) / ((double)var1 * 0.5) - 1.0;
                  double var9 = Math.sqrt(var5 * var5 + var7 * var7);
                  double var11 = var9 >= 1.0 ? 0.0 : Math.pow(1.0 - var9, 1.6);
                  int var13 = (int)Math.round(Math.min(1.0, var11 * 1.2) * 255.0);
                  var2.setColorArgb(var4, var3, var13 << 24 | -2135816372 ^ -2142373709);
               }
            }

            var0.getTextureManager().registerTexture(cg, new NativeImageBackedTexture(() -> {

               return "lithium-soft-dot";
            }, var2));

            for (int var16 = 0; var16 < 4; var16++) {
               int var18 = (1806280804 ^ 1806280932) >> var16;

               for (int var20 = 0; var20 < 8; var20++) {
                  int var6;
                  int var21;
                  if (var16 == 0) {
                     var6 = (var20 & 3) * (-1244671688 ^ -1244671560);
                     var21 = (var20 >> 2) * (3065545 ^ 3065417);
                  } else if (var16 == 1) {
                     var6 = (var20 & 3) * 64;
                     var21 = (-1857028652 ^ -1857028908) + (var20 >> 2) * 64;
                  } else if (var16 == 2) {
                     var6 = (-1103003689 ^ -1103003945) + (var20 & 3) * 32;
                     var21 = (545235439 ^ 545235183) + (var20 >> 2) * 32;
                  } else {
                     var6 = (-1634482245 ^ -1634482629) + (var20 & 3) * 16;
                     var21 = (55150484 ^ 55150228) + (var20 >> 2) * 16;
                  }

                  int var8 = var16 * 8 + var20;
                  dd[var8] = (float)var6 / 512.0F;
                  df[var8] = (float)(var6 + var18) / 512.0F;
                  de[var8] = (float)var21 / 512.0F;
                  dg[var8] = (float)(var21 + var18) / 512.0F;

                  for (int var22 = 0; var22 < 2; var22++) {
                     int var10 = var16 * 16 + var22 * 8 + var20;
                     du[var10] = dd[var8];
                     dw[var10] = df[var8];
                     dv[var10] = (float)(var21 + var22 * (169757600 ^ 169757088)) / 1024.0F;
                     dx[var10] = (float)(var21 + var18 + var22 * (-1357680612 ^ -1357680100)) / 1024.0F;
                  }
               }
            }

            cf = new OutputTarget("lithium_" + "atmosphere", () -> {

               MinecraftClient var0x = MinecraftClient.getInstance();
               Framebuffer var1x = var0x.worldRenderer == null ? null : var0x.worldRenderer.getTranslucentFramebuffer();
               return var1x != null ? var1x : var0x.getFramebuffer();
            });
            RenderPipeline var17 = RenderPipeline.builder(new Snippet[]{RenderPipelines.POSITION_TEX_COLOR_SNIPPET})
               .withLocation(Identifier.of("lithium", "pip" + "eline/lq" + "_soft"))
               .withBlend(BlendFunction.TRANSLUCENT)
               .withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST)
               .withDepthWrite(false)
               .withCull(false)
               .build();
            RenderPipeline var19 = RenderPipeline.builder(new Snippet[]{RenderPipelines.POSITION_TEX_COLOR_SNIPPET})
               .withLocation(Identifier.of("lithium", "pipeline/lq_add"))
               .withBlend(BlendFunction.LIGHTNING)
               .withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST)
               .withDepthWrite(false)
               .withCull(false)
               .build();
            bn = RenderLayer.of("li" + "thium_lq_soft", RenderSetup.builder(var17).texture("Sampler0", cg, () -> {

               return RenderSystem.getSamplerCache().get(FilterMode.LINEAR);
            }).outputTarget(cf).expectedBufferSize(1236272268 ^ 1236403340).build());
            bo = RenderLayer.of("lithium" + "_" + "l" + "q_add", RenderSetup.builder(var19).texture("Sampler0", cg, () -> {

               return RenderSystem.getSamplerCache().get(FilterMode.LINEAR);
            }).outputTarget(cf).expectedBufferSize(-1912651517 ^ -1912717053).build());
            bp = RenderLayer.of("lithium_l" + "q_skyadd", RenderSetup.builder(var19).texture("Sampler0", cg, () -> {

               return RenderSystem.getSamplerCache().get(FilterMode.LINEAR);
            }).outputTarget(OutputTarget.MAIN_TARGET).expectedBufferSize(-2054093431 ^ -2054089335).build());
            cd = RenderPipeline.builder(new Snippet[]{RenderPipelines.POSITION_TEX_COLOR_SNIPPET})
               .withLocation(Identifier.of("lithium", "pipeline/l" + "q" + "_petal"))
               .withBlend(BlendFunction.TRANSLUCENT)
               .withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST)
               .withDepthWrite(false)
               .withCull(false)
               .build();
            ce = var19;

            try {
               bt = RenderLayer.of(
                  "lithium_lq_grade_mul",
                  RenderSetup.builder(
                        RenderPipeline.builder(new Snippet[]{RenderPipelines.POSITION_TEX_COLOR_SNIPPET})
                           .withLocation(Identifier.of("lithium", "pipeline/lq_grade_mul"))
                           .withBlend(new BlendFunction(SourceFactor.DST_COLOR, DestFactor.ZERO))
                           .withDepthTestFunction(DepthTestFunction.GREATER_DEPTH_TEST)
                           .withDepthWrite(false)
                           .withCull(false)
                           .build()
                     )
                     .texture("Sampler0", cg)
                     .outputTarget(OutputTarget.MAIN_TARGET)
                     .expectedBufferSize(2058577524 ^ 2058577780)
                     .build()
               );
               bu = RenderLayer.of(
                  "lithium_lq_grade_" + "add",
                  RenderSetup.builder(
                        RenderPipeline.builder(new Snippet[]{RenderPipelines.POSITION_TEX_COLOR_SNIPPET})
                           .withLocation(Identifier.of("lithium", "pipeline/lq_grade_add"))
                           .withBlend(BlendFunction.LIGHTNING)
                           .withDepthTestFunction(DepthTestFunction.GREATER_DEPTH_TEST)
                           .withDepthWrite(false)
                           .withCull(false)
                           .build()
                     )
                     .texture("Sampler0", cg)
                     .outputTarget(OutputTarget.MAIN_TARGET)
                     .expectedBufferSize(455974658 ^ 455974402)
                     .build()
               );
            } catch (Throwable var14) {
               bt = null;
               bu = null;
            }

            bk = true;
         } catch (Throwable var15) {
            bk = false;
         }
      }
   }

   private static NativeImage i(int[] var0, int var1, int var2) {

      NativeImage var3 = new NativeImage(NativeImage.Format.RGBA, var1, var2, false);

      try {
         for (int var4 = 0; var4 < var2; var4++) {
            int var5 = var4 * var1;

            for (int var6 = 0; var6 < var1; var6++) {
               var3.setColorArgb(var6, var4, var0[var5 + var6]);
            }
         }

         return var3;
      } catch (Throwable var7) {
         var3.close();
         throw var7;
      }
   }

   private static boolean j(MinecraftClient var0, Identifier var1, String var2, NativeImage var3) {

      try {
         var0.getTextureManager().registerTexture(var1, new LayerTextureCache(var2, var3));
         return true;
      } catch (Throwable var5) {
         var3.close();
         return false;
      }
   }

   private static void k(MinecraftClient var0) {

      if (!cz && !cp) {
         NativeImage var1 = ck;
         if (var1 != null) {
            ck = null;
            if (j(var0, PETAL_TEX, "l" + "ithium-pe" + "t" + "al", var1)) {
               cz = true;
            } else {
               cp = true;
            }
         }
      }
   }

   private static void l(MinecraftClient var0) {

      k(var0);
      if (cz && !cw && !cp) {
         try {
            bq = RenderLayer.of("lit" + "hium_lq_pe" + "t" + "al", RenderSetup.builder(cd).texture("Sampler0", PETAL_TEX, () -> {

               return RenderSystem.getSamplerCache().get(FilterMode.LINEAR);
            }).outputTarget(cf).expectedBufferSize(195790883 ^ 196839459).build());
            cw = true;
         } catch (Throwable var5) {
            cp = true;
         }
      }

      if (!cy && !cr) {
         NativeImage var1 = cm;
         if (var1 != null) {
            cm = null;

            try {
               if (!j(var0, ci, "lithium-snow", var1)) {
                  throw new IllegalStateException();
               }

               br = RenderLayer.of("lithium" + "_lq_" + "s" + "now", RenderSetup.builder(cd).texture("Sampler0", ci, () -> {

                  return RenderSystem.getSamplerCache().get(FilterMode.LINEAR);
               }).outputTarget(cf).expectedBufferSize(-932114831 ^ -931590543).build());
               cy = true;
            } catch (Throwable var4) {
               cr = true;
            }
         }
      }

      if (!cx && !cq) {
         NativeImage var6 = cl;
         if (var6 != null) {
            cl = null;

            try {
               if (!j(var0, cj, "lithi" + "um-" + "sun", var6)) {
                  throw new IllegalStateException();
               }

               bs = RenderLayer.of("lit" + "hium_lq_sun", RenderSetup.builder(ce).texture("Sampler0", cj, () -> {

                  return RenderSystem.getSamplerCache().get(FilterMode.LINEAR);
               }).outputTarget(OutputTarget.MAIN_TARGET).expectedBufferSize(-1124963324 ^ -1124979708).build());
               cx = true;
            } catch (Throwable var3) {
               cq = true;
            }
         }
      }

      dc = !cw && !cp || !cy && !cr || !cx && !cq;
   }

   public static int m() {

      try {
         MinecraftClient var0 = MinecraftClient.getInstance();
         k(var0);
         if (!da && !cs && cn != null) {
            boolean var1 = j(var0, BRANCH_TEX, "lithium-b" + "ra" + "n" + "ch", cn);
            cn = null;
            if (var1) {
               da = true;
               SceneLayerCache.b();
            } else {
               cs = true;
            }
         }
      } catch (Throwable var2) {
      }

      return (cz ? 1 : 0) | (da ? 2 : 0);
   }

   private static void n() {

      o();
      nb = 0.0F;
      nc = 0.0F;
      nd = 0.0F;
      qm = false;
      qn = false;
      qi = 0;
      ph = false;
      lo = false;
      fg = false;
      fy = false;
      gn = false;
      hj = false;
      ia = false;
      it = false;
      ji = false;
      jv = false;
      ob = 0;
      oc = false;
      oh = true;
      oi = 0.0F;
      oj = 0.0F;
      qc.clear();
   }

   private static void o() {

      Arrays.fill(mt, (byte)0);
      Arrays.fill(nh, 0);
      mu = 0;
      mv = 0;
      mw = 0;
      na = false;
      nf = 0.0F;
      ng = 0.0F;
      ne = 0.0F;
   }

   private static void p(Camera var0, boolean var1) {

      pg = 0.0F;
      if (!var1) {
         try {
            float var2 = MinecraftClient.getInstance().getRenderTickCounter().getTickProgress(false);
            int var3 = (Integer)var0.getEnvironmentAttributeInterpolator().get(EnvironmentAttributes.FOG_COLOR_VISUAL, var2);
            float var4 = (Float)var0.getEnvironmentAttributeInterpolator().get(EnvironmentAttributes.FOG_START_DISTANCE_VISUAL, var2);
            float var5 = (Float)var0.getEnvironmentAttributeInterpolator().get(EnvironmentAttributes.FOG_END_DISTANCE_VISUAL, var2);
            if (var5 > var4 + 0.5F && var5 < 100000.0F) {
               pb = (float)(var3 >> 16 & (846203149 ^ 846203378));
               pc = (float)(var3 >> 8 & (-1381804183 ^ -1381804138));
               pd = (float)(var3 & (1907073320 ^ 1907073495));
               pe = var4;
               pf = 1.0F / (var5 - var4);
               pg = 1.0F;
            }
         } catch (Throwable var6) {
            pg = 0.0F;
         }
      }
   }

   private static void q(Vec3d var0, float var1) {

      if (!ph) {
         pi = var0.x;
         pj = var0.y;
         pk = var0.z;
         pn = 0.0F;
         pm = 0.0F;
         pl = 0.0F;
         ph = true;
      } else {
         double var2 = var0.x - pi;
         double var4 = var0.y - pj;
         double var6 = var0.z - pk;
         pi = var0.x;
         pj = var0.y;
         pk = var0.z;
         if (!(var1 <= 0.0F) && !(var2 * var2 + var4 * var4 + var6 * var6 > 64.0)) {
            float var8 = 1.0F - (float)Math.exp((double)(-var1 * 10.0F));
            pl = pl + ((float)(var2 / (double)var1) - pl) * var8;
            pm = pm + ((float)(var4 / (double)var1) - pm) * var8;
            pn = pn + ((float)(var6 / (double)var1) - pn) * var8;
         }
      }
   }

   private static void r(MinecraftClient var0, Vec3d var1, long var2, boolean var4, boolean var5) {

      if (var4 || var5) {
         ClientWorld var6 = var0.world;
         int var7 = MathHelper.floor(var1.x);
         int var8 = MathHelper.floor(var1.z);
         if (qm && (!var5 || qn)) {
            boolean var9 = var1.y - (double)var6.getTopY(Heightmap.Type.MOTION_BLOCKING, var7, var8) > 45.0;
            long var10 = var9 ? 1500000000L : 400000000L;
            int var12 = var9 ? 8 : 2;
            if (var2 - ql < var10 && Math.abs(var7 - qj) <= var12 && Math.abs(var8 - qk) <= var12) {
               return;
            }
         }

         int var47 = var6.getBottomY();
         BlockPos.Mutable var48 = qd;
         IdentityHashMap var11 = qc;
         int var49 = -1309637335 ^ 837846313;
         int var13 = -797203719 ^ 1350279929;
         boolean var14 = false;
         WorldChunk var15 = null;

         for (int var16 = -24; var16 <= 24; var16++) {
            int var17 = (var16 + 24) * 49;

            for (int var18 = -24; var18 <= 24; var18++) {
               int var19 = var17 + var18 + 24;
               int var20 = var7 + var18;
               int var21 = var8 + var16;
               if (var20 >> 4 != var49 || var21 >> 4 != var13) {
                  var49 = var20 >> 4;
                  var13 = var21 >> 4;
                  var14 = var49 >= (845903550 ^ -846719626)
                     && var13 >= (-2054155003 ^ 2054387405)
                     && var49 < (-2011474220 ^ -2012755220)
                     && var13 < (-1785622627 ^ -1785916507)
                     && var6.isChunkLoaded(var49, var13);
                  var15 = null;
                  if (var14) {
                     var15 = var6.getChunk(var49, var13);
                  }
               }

               int var22 = var14
                  ? var15.sampleHeightmap(Heightmap.Type.MOTION_BLOCKING, var20 & 15, var21 & 15) + 1
                  : var6.getTopY(Heightmap.Type.MOTION_BLOCKING, var20, var21);
               ps[var19] = var22;
               if (var5) {
                  pv[var19] = 0.0F;
                  pw[var19] = 0.0F;

                  try {
                     int var23 = var14
                        ? var15.sampleHeightmap(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, var20 & 15, var21 & 15) + 1
                        : var6.getTopY(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, var20, var21);
                     if (var23 <= var47) {
                        pt[var19] = -1.0E9F;
                        pu[var19] = 3;
                     } else {
                        var48.set(var20, var23 - 1, var21);
                        BlockState var24 = var14 ? var15.getBlockState(var48) : var6.getBlockState(var48);
                        boolean var25 = !var24.hasModelOffset() && !var24.hasBlockEntity();
                        Float var26 = var25 ? (Float)var11.get(var24) : null;
                        VoxelShape var27 = null;
                        float var28;
                        if (var26 != null) {
                           var28 = var26;
                        } else {
                           var27 = var24.getOutlineShape(var6, var48);
                           if (!var27.isEmpty() && var27 != VoxelShapes.fullCube()) {
                              float var29 = (float)Math.min(1.0, var27.getMax(Direction.Axis.Y));
                              var28 = -var29 - 1.0F;
                              if (var27.getMin(Direction.Axis.X) <= 1.0E-4
                                 && var27.getMax(Direction.Axis.X) >= 0.9999
                                 && var27.getMin(Direction.Axis.Z) <= 1.0E-4
                                 && var27.getMax(Direction.Axis.Z) >= 0.9999) {
                                 if (var29 >= 0.999F && Block.isFaceFullSquare(var27, Direction.UP)) {
                                    var28 = 1.0F;
                                 } else {
                                    double var30 = 0.0;
                                    boolean var32 = true;

                                    for (Box var34 : var27.getBoundingBoxes()) {
                                       if (var34.maxY < (double)var29 - 0.01) {
                                          var32 = false;
                                          break;
                                       }

                                       var30 += (var34.maxX - var34.minX) * (var34.maxZ - var34.minZ);
                                    }

                                    if (var32 && var30 >= 0.98) {
                                       var28 = var29;
                                    }
                                 }
                              }
                           } else {
                              var28 = 1.0F;
                           }

                           if (var25) {
                              var11.put(var24, var28);
                           }
                        }

                        float var50 = var28 >= 0.0F ? var28 : -var28 - 1.0F;
                        FluidState var51 = var24.getFluidState();
                        float var31 = -1.0F;
                        boolean var52 = false;
                        if (!var51.isEmpty()) {
                           var31 = var51.getHeight(var6, var48);
                           var52 = var51.isIn(FluidTags.LAVA);
                           if (var31 >= var50 || var24.getCollisionShape(var6, var48).isEmpty()) {
                              pt[var19] = (float)(var23 - 1) + var31;
                              if (var52) {
                                 pu[var19] = 2;
                              } else {
                                 pu[var19] = 1;
                                 if (!var51.isStill()) {
                                    Vec3d var54 = var51.getVelocity(var6, var48);
                                    pv[var19] = (float)var54.x;
                                    pw[var19] = (float)var54.z;
                                 }
                              }
                              continue;
                           }
                        }

                        if (var28 >= 0.0F) {
                           pt[var19] = (float)(var23 - 1) + var28;
                           pu[var19] = 0;
                        } else {
                           if (var27 == null) {
                              var27 = var24.getOutlineShape(var6, var48);
                           }

                           t(var6, var19, var20, var23 - 1, var21, var47, var24, var27, var50, var31, var52);
                        }

                        int var53 = var23;

                        for (int var55 = 0; var55 < 4; var55++) {
                           var48.set(var20, var53, var21);
                           BlockState var35 = var14 ? var15.getBlockState(var48) : var6.getBlockState(var48);
                           if (var35.isAir()
                              || var35.isOf(Blocks.COBWEB)
                              || var35.isIn(BlockTags.LEAVES)
                              || var35.isIn(BlockTags.RAILS)
                              || !var35.getFluidState().isEmpty()) {
                              break;
                           }

                           boolean var36 = !var35.hasModelOffset() && !var35.hasBlockEntity();
                           Float var37 = var36 ? (Float)var11.get(var35) : null;
                           float var38;
                           if (var37 != null) {
                              var38 = var37;
                           } else {
                              VoxelShape var39 = var35.getOutlineShape(var6, var48);
                              var38 = -2.0F;
                              if (!var39.isEmpty()
                                 && var39.getMin(Direction.Axis.X) <= 1.0E-4
                                 && var39.getMax(Direction.Axis.X) >= 0.9999
                                 && var39.getMin(Direction.Axis.Z) <= 1.0E-4
                                 && var39.getMax(Direction.Axis.Z) >= 0.9999) {
                                 float var40 = (float)Math.min(1.0, var39.getMax(Direction.Axis.Y));
                                 double var41 = 0.0;
                                 boolean var43 = true;

                                 for (Box var45 : var39.getBoundingBoxes()) {
                                    if (var45.maxY < (double)var40 - 0.01) {
                                       var43 = false;
                                       break;
                                    }

                                    var41 += (var45.maxX - var45.minX) * (var45.maxZ - var45.minZ);
                                 }

                                 if (var43 && var41 >= 0.98) {
                                    var38 = var40;
                                 }
                              }

                              if (var36) {
                                 var11.put(var35, var38);
                              }
                           }

                           if (var38 < 0.0F) {
                              break;
                           }

                           pt[var19] = (float)var53 + var38;
                           pu[var19] = 0;
                           if (var38 < 0.999F) {
                              break;
                           }

                           var53++;
                        }
                     }
                  } catch (Throwable var46) {
                     pt[var19] = (float)var22;
                     pu[var19] = 0;
                  }
               }
            }
         }

         qj = var7;
         qk = var8;
         ql = var2;
         qm = true;
         qn = var5;
         if (var5) {
            s(var7, var8);
         } else {
            qi = 0;
         }
      }
   }

   private static void s(int var0, int var1) {

      assert ps.length == (854730635 ^ 854732522)
         && pt.length == (-1169264904 ^ -1169266791)
         && pu.length == (-897960569 ^ -897958682)
         && qe.length == (-897895949 ^ -897894254)
         && qf.length == (-579328712 ^ -579326887)
         && qg.length == (2111212517 ^ 2111210116)
         && qh.length == (-1127257935 ^ -1127259696)
         && qa.length == (-1425145763 ^ -1425254371)
         && qb.length == (1730630032 ^ 1730480592)
         && qi >= 0
         && qi <= (36822543 ^ 36820846)
         && var0 > (-89226136 ^ 2058257520)
         && var1 > (494613317 ^ -1652870307) : "canopy";

      try {
         int var2 = 0;
         int[] var3 = ps;
         float[] var4 = pt;
         byte[] var5 = pu;

         for (int var6 = -24; var6 <= 24; var6++) {
            for (int var7 = -24; var7 <= 24; var7++) {
               int var8 = (var6 + 24) * 49 + var7 + 24;
               float var9 = (float)var3[var8];
               float var10 = var4[var8];
               if (var5[var8] == 0 && var9 - var10 > 2.0F) {
                  qe[var2] = var0 + var7;
                  qf[var2] = var1 + var6;
                  qg[var2] = var9;
                  qh[var2] = Math.max(var10 + 1.5F, var9 - 3.0F);
                  var2++;
               }
            }
         }

         qi = var2;
      } catch (RuntimeException var11) {
         throw var11;
      }
   }

   private static void t(
      ClientWorld var0, int var1, int var2, int var3, int var4, int var5, BlockState var6, VoxelShape var7, float var8, float var9, boolean var10
   ) {

      assert var0 != null
         && var6 != null
         && var7 != null
         && var1 >= 0
         && var1 < (-657458560 ^ -657460255)
         && var5 <= var3
         && qa.length == (-411772837 ^ -411664357)
         && qb.length == (-1719277036 ^ -1719160236)
         && pt.length == (1246157279 ^ 1246154942)
         && pu.length == (2004518146 ^ 2004520035)
         && ps.length == (-286828518 ^ -286830213)
         && !Float.isNaN(var8)
         && !Float.isNaN(var9)
         && qd != null
         && qe.length == (1969853952 ^ 1969856353)
         && qf.length == (1244480474 ^ 1244482235) : "partialColumn";

      List var11 = var7.getBoundingBoxes();
      BlockPos.Mutable var14 = qd;
      BlockState var15 = var6;

      try {
         int var19 = var1 << 6;
         int var20 = 0;
         int var21 = var11.size();

         for (int var22 = 0; var22 < 64; var22++) {
            double var23 = ((double)(var22 >> 3) + 0.5) / 8.0;
            double var25 = ((double)(var22 & 7) + 0.5) / 8.0;
            double var27 = -1.0;

            for (int var29 = 0; var29 < var21; var29++) {
               Box var13 = (Box)var11.get(var29);
               if (var23 >= var13.minX - 0.02 && var23 <= var13.maxX + 0.02 && var25 >= var13.minZ - 0.02 && var25 <= var13.maxZ + 0.02
                  )
                {
                  double var30 = var13.maxY > 1.0 ? 1.0 : var13.maxY;
                  if (var30 > var27) {
                     var27 = var30;
                  }
               }
            }

            if (var27 >= 0.0 && var27 >= (double)var9) {
               qa[var19 + var22] = (float)((double)var3 + var27);
               qb[var19 + var22] = 0;
            } else if (var9 >= 0.0F) {
               qa[var19 + var22] = (float)var3 + var9;
               qb[var19 + var22] = (byte)(var10 ? 2 : 1);
            } else {
               qa[var19 + var22] = -1.0E9F;
               qb[var19 + var22] = 3;
               var20++;
            }
         }

         for (int var40 = 1; var40 <= 64 && var20 > 0 && var3 - var40 >= var5; var40++) {
            int var41 = var3 - var40;
            var14.set(var2, var41, var4);
            BlockState var16 = var0.getBlockState(var14);
            FluidState var17 = var16.getFluidState();
            if (var16 != var15 || !var17.isEmpty()) {
               var15 = var16;
               VoxelShape var18 = var16.getOutlineShape(var0, var14);
               if (!var18.isEmpty() || !var17.isEmpty()) {
                  float var24 = var17.isEmpty() ? -1.0F : var17.getHeight(var0, var14);
                  boolean var42 = !var17.isEmpty() && var17.isIn(FluidTags.LAVA);
                  boolean var26 = var18 == VoxelShapes.fullCube();
                  List var12;
                  if (!var18.isEmpty() && !var26) {
                     var12 = var18.getBoundingBoxes();
                  } else {
                     var12 = null;
                  }

                  int var43 = var12 == null ? 0 : var12.size();

                  for (int var28 = 0; var28 < 64; var28++) {
                     if (qb[var19 + var28] == 3) {
                        double var44 = var26 ? 1.0 : -1.0;
                        if (var43 > 0) {
                           double var31 = ((double)(var28 >> 3) + 0.5) / 8.0;
                           double var33 = ((double)(var28 & 7) + 0.5) / 8.0;

                           for (int var35 = 0; var35 < var43; var35++) {
                              Box var39 = (Box)var12.get(var35);
                              if (var31 >= var39.minX - 0.02
                                 && var31 <= var39.maxX + 0.02
                                 && var33 >= var39.minZ - 0.02
                                 && var33 <= var39.maxZ + 0.02) {
                                 double var36 = var39.maxY > 1.0 ? 1.0 : var39.maxY;
                                 if (var36 > var44) {
                                    var44 = var36;
                                 }
                              }
                           }
                        }

                        if (var24 >= 0.0F && (double)var24 > var44) {
                           qa[var19 + var28] = (float)var41 + var24;
                           qb[var19 + var28] = (byte)(var42 ? 2 : 1);
                           var20--;
                        } else if (var44 >= 0.0) {
                           qa[var19 + var28] = (float)((double)var41 + var44);
                           qb[var19 + var28] = 0;
                           var20--;
                        }
                     }
                  }
               }
            }
         }

         pt[var1] = (float)var3 + var8;
         pu[var1] = 4;
      } catch (RuntimeException var38) {
         throw var38;
      }
   }

   private static float u(double var0, double var2) {

      qo = 3;
      if (qm && qn) {
         int var4 = MathHelper.floor(var0);
         int var5 = MathHelper.floor(var2);
         int var6 = var4 - qj + 24;
         int var7 = var5 - qk + 24;
         if (var6 >= 0 && var7 >= 0 && var6 < 49 && var7 < 49) {
            int var8 = var7 * 49 + var6;
            byte var9 = pu[var8];
            if (var9 == 4) {
               int var10 = var8 << 6 | ((int)((var0 - (double)var4) * 8.0) & 7) << 3 | (int)((var2 - (double)var5) * 8.0) & 7;
               qo = qb[var10];
               return qa[var10];
            } else {
               qo = var9;
               return pt[var8];
            }
         } else {
            return -1.0E9F;
         }
      } else {
         return -1.0E9F;
      }
   }

   private static int v(double var0, double var2) {

      if (!qm) {
         return -1632180469 ^ 515303179;
      } else {
         int var4 = MathHelper.floor(var0) - qj + 24;
         int var5 = MathHelper.floor(var2) - qk + 24;
         return var4 >= 0 && var5 >= 0 && var4 < 49 && var5 < 49 ? ps[var5 * 49 + var4] : 986541970 ^ -1160941678;
      }
   }

   private static void w(MinecraftClient var0, Vec3d var1, float var2) {

      int var3 = 0;

      try {
         float var4 = var0.getRenderTickCounter().getTickProgress(true);
         ClientPlayerEntity var5 = var0.player;
         if (!var5.isSpectator()) {
            float var6 = (float)((var5.getY() - var5.lastY) * 20.0);
            if (var6 < -60.0F || var6 > 60.0F) {
               var6 = 0.0F;
            }

            boolean var7 = var5.isOnGround();
            if (!var7) {
               if (var6 < oi) {
                  oi = var6;
               }
            } else if (!oh) {
               if (oi < -6.0F && !var5.isTouchingWater()) {
                  oj = 0.14F;
                  ok = Math.min(1.5F, -oi / 9.0F);
               }

               oi = 0.0F;
            }

            oh = var7;
            if (oj > 0.0F) {
               oj -= var2;
            }

            var3 = x(var5, var4, var3, oj > 0.0F ? ok : 0.0F);
         }

         List var23 = var0.world
            .getEntitiesByClass(
               LivingEntity.class,
               new Box(
                  var1.x - 24.0,
                  var1.y - 16.0,
                  var1.z - 24.0,
                  var1.x + 24.0,
                  var1.y + 16.0,
                  var1.z + 24.0
               ),
               Entity::isAlive
            );

         for (int var24 = 0; var24 < var23.size() && var3 < 12; var24++) {
            LivingEntity var8 = (LivingEntity)var23.get(var24);
            if (var8 != var5 && !var8.isSpectator()) {
               double var9 = var8.getX() - var8.lastX;
               double var11 = var8.getZ() - var8.lastZ;
               double var13 = (var9 * var9 + var11 * var11) * 400.0;
               if (!(var13 <= 0.64) && !(var13 > 1600.0)) {
                  var3 = x(var8, var4, var3, 0.0F);
               }
            }
         }
      } catch (Throwable var20) {
      }

      ob = var3;
      boolean var21 = false;
      double var22 = 0.0;
      double var25 = 0.0;
      double var26 = 0.0;
      double var27 = 0.0;

      for (int var28 = 0; var28 < var3; var28++) {
         if (!(oa[var28] <= 0.0F)) {
            double var14 = (double)ny[var28] + 0.91;
            double var16 = nt[var28];
            double var18 = nv[var28];
            if (!var21 || var16 - var14 < var22) {
               var22 = var16 - var14;
            }

            if (!var21 || var16 + var14 > var25) {
               var25 = var16 + var14;
            }

            if (!var21 || var18 - var14 < var26) {
               var26 = var18 - var14;
            }

            if (!var21 || var18 + var14 > var27) {
               var27 = var18 + var14;
            }

            var21 = true;
         }
      }

      oc = var21;
      od = var22;
      oe = var25;
      of = var26;
      og = var27;
   }

   private static int x(Entity var0, float var1, int var2, float var3) {

      Vec3d var4 = var0.getLerpedPos(var1);
      float var5 = (float)((var0.getX() - var0.lastX) * 20.0);
      float var6 = (float)((var0.getZ() - var0.lastZ) * 20.0);
      float var7 = MathHelper.sqrt(var5 * var5 + var6 * var6);
      if (var7 > 40.0F) {
         var5 = 0.0F;
         var6 = 0.0F;
         var7 = 0.0F;
      }

      float var8 = (var7 - 0.8F) / 4.8F;
      var8 = var8 < 0.0F ? 0.0F : (var8 > 1.4F ? 1.4F : var8);
      float var9 = var0.getWidth() * 0.5F + 0.45F + Math.min(var7, 8.0F) * 0.07F;
      if (var3 > var8) {
         var8 = var3;
      }

      if (var3 > 0.0F) {
         var9 += 0.9F * var3;
      }

      nt[var2] = var4.x;
      nu[var2] = var4.y;
      nv[var2] = var4.z;
      nw[var2] = var5;
      nx[var2] = var6;
      ny[var2] = var9;
      nz[var2] = var0.getHeight();
      oa[var2] = var8;
      return var2 + 1;
   }

   private static void y(MinecraftClient var0, Vec3d var1, float var2, float var3, long var4, float var6) {

      if (var4 - oq > 60000000L) {
         oq = var4;

         try {
            float var7 = MathHelper.sqrt(var2 * var2 + var3 * var3);
            Vec3d var8 = var1.add((double)(var2 / var7) * 192.0, (double)(var3 / var7) * 192.0, 0.0);
            BlockHitResult var9 = var0.world.raycast(new RaycastContext(var1, var8, RaycastContext.ShapeType.VISUAL, RaycastContext.FluidHandling.NONE, var0.player));
            op = var9 != null && var9.getType() != HitResult.Type.MISS ? 0.0F : 1.0F;
         } catch (Throwable var10) {
            op = 0.0F;
         }
      }

      oo = oo + (op - oo) * (1.0F - (float)Math.exp((double)(-var6 * 7.0F)));
   }

   private static void z(VertexConsumer var0, MatrixStack.Entry var1) {

      assert var0 != null
         && (ou || var1 != null)
         && nr >= 0
         && nr <= (963585145 ^ 963585529)
         && nq.length >= (-1693222576 ^ -1693222704)
         && no.length >= (1782242006 ^ 1782242134)
         && np.length >= (35336574 ^ 35336446)
         && nn.length >= (-243786986 ^ -243791722)
         && ps.length == (15374831 ^ 15372430)
         && pt.length == (-669945253 ^ -669942982)
         && pu.length == (-1176713185 ^ -1176714882)
         && qe.length == (18466959 ^ 18465262)
         && qf.length == (1403485475 ^ 1403483202) : "flus" + "hN" + "ear";

      int var2 = nr;
      nr = 0;
      if (var2 > 0) {
         try {
            int[] var3 = nq;
            float[] var4 = no;
            int var5 = 0;

            while (var5 < var2) {
               var3[var5] = var5++;
            }

            for (int var30 = 1; var30 < var2; var30++) {
               int var6 = var3[var30];
               float var7 = var4[var6];

               int var8;
               for (var8 = var30 - 1; var8 >= 0 && var4[var3[var8]] < var7; var8--) {
                  var3[var8 + 1] = var3[var8];
               }

               var3[var8 + 1] = var6;
            }

            float[] var31 = nn;
            int[] var32 = np;
            boolean var33 = ou;

            for (int var34 = 0; var34 < var2; var34++) {
               int var9 = var3[var34];
               int var10 = var9 * 13;
               float var11 = var31[var10];
               float var12 = var31[var10 + 1];
               float var13 = var31[var10 + 2];
               float var14 = var31[var10 + 3];
               float var15 = var31[var10 + 4];
               float var16 = var31[var10 + 5];
               float var17 = var31[var10 + 6];
               float var18 = var31[var10 + 7];
               float var19 = var31[var10 + 8];
               float var20 = var31[var10 + 9];
               float var21 = var31[var10 + 10];
               float var22 = var31[var10 + 11];
               float var23 = var31[var10 + 12];
               int var24 = var32[var9];
               int var25 = var24 >>> 24;
               int var26 = var24 >>> 16 & (-331912373 ^ -331912268);
               int var27 = var24 >>> 8 & (55051671 ^ 55051624);
               int var28 = var24 & (542743721 ^ 542743638);
               if (var33) {
                  var0.vertex(var11 - var14 - var17, var12 - var15 - var18, var13 - var16 - var19)
                     .texture(var20, var23)
                     .color(var25, var26, var27, var28);
                  var0.vertex(var11 - var14 + var17, var12 - var15 + var18, var13 - var16 + var19)
                     .texture(var20, var21)
                     .color(var25, var26, var27, var28);
                  var0.vertex(var11 + var14 + var17, var12 + var15 + var18, var13 + var16 + var19)
                     .texture(var22, var21)
                     .color(var25, var26, var27, var28);
                  var0.vertex(var11 + var14 - var17, var12 + var15 - var18, var13 + var16 - var19)
                     .texture(var22, var23)
                     .color(var25, var26, var27, var28);
               } else {
                  var0.vertex(var1, var11 - var14 - var17, var12 - var15 - var18, var13 - var16 - var19)
                     .texture(var20, var23)
                     .color(var25, var26, var27, var28);
                  var0.vertex(var1, var11 - var14 + var17, var12 - var15 + var18, var13 - var16 + var19)
                     .texture(var20, var21)
                     .color(var25, var26, var27, var28);
                  var0.vertex(var1, var11 + var14 + var17, var12 + var15 + var18, var13 + var16 + var19)
                     .texture(var22, var21)
                     .color(var25, var26, var27, var28);
                  var0.vertex(var1, var11 + var14 - var17, var12 + var15 - var18, var13 + var16 - var19)
                     .texture(var22, var23)
                     .color(var25, var26, var27, var28);
               }
            }
         } catch (RuntimeException var29) {
            throw var29;
         }
      }
   }

   private static void aa(int var0, double var1, double var3, double var5) {

      int var7 = var0 & 3;
      double var8 = var7 < 2 ? 4.5 : (var7 == 2 ? 11.0 : 22.0);
      double var10 = var7 < 2 ? 3.5 : (var7 == 2 ? 7.0 : 14.0);
      ep[var0] = var1 + (ed.nextDouble() * 2.0 - 1.0) * var8;
      eq[var0] = var3 + (ed.nextDouble() * 2.0 - 1.0) * var10;
      er[var0] = var5 + (ed.nextDouble() * 2.0 - 1.0) * var8;
      boolean var12 = ed.nextFloat() < 0.4F;
      ff[var0] = var12 ? ed.nextInt(7) : 7;
      float var13 = ed.nextFloat();
      if (var12) {
         es[var0] = 0.5F + ed.nextFloat() * 0.5F;
         et[var0] = 0.022F + 0.018F * var13;
      } else {
         es[var0] = 0.8F + ed.nextFloat() * 0.7F;
         et[var0] = 0.014F + 0.02F * var13 * var13;
      }

      eu[var0] = ed.nextFloat() * (float) (Math.PI * 2);
      ev[var0] = 0.7F + ed.nextFloat() * 1.4F;
      ew[var0] = ed.nextFloat();
      fa[var0] = (ed.nextFloat() * 2.0F - 1.0F) * 1.2F;
   }

   private static void ab(VertexConsumer var0, MatrixStack.Entry var1, Vec3d var2, float var3, double var4, float var6, float[] var7, boolean var8) {

      double var9 = var2.x;
      double var11 = var2.y;
      double var13 = var2.z;
      if (!fg) {
         for (int var15 = 0; var15 < (960672086 ^ 960667966); var15++) {
            aa(var15, var9, var11, var13);
         }

         fg = true;
         fj = 2;
      }

      float var189 = fk;
      float var16 = fl;
      float var17 = fm;
      float var18 = 4200.0F * Math.max(0.05F, ov) * (0.6F * var189 + 1.6F * var16 + 1.6F * var17);
      fh = fh + (var18 - fh) * (1.0F - (float)Math.exp((double)(-var3 * 1.5F)));
      int var19 = Math.min(-2056443068 ^ -2056438996, (int)Math.ceil((double)fh));
      float var20 = fh;
      float var21 = var189 + 0.8F * var16 + 0.85F * var17;
      float var22 = var189 + 0.6F * var16 + 1.25F * var17;
      float var23 = (var189 + 0.25F * var17) * (float) (Math.PI * 2);
      float var24 = 0.009F * var189 + 0.085F * var16 + 0.012F * var17;
      float var25 = var189 + 1.45F * var16 + var17;
      float var26 = 0.52F * var189 + 0.88F * (var16 + var17);
      float var27 = 0.3F * var189 + 0.12F * (var16 + var17);
      boolean var28 = dl;
      float var29 = (var16 + var17) * (float) (Math.PI * 2);
      float var30 = 0.7F * var16 + 4.0F * var17;
      float var31 = 0.015F * (var16 + var17);
      float var32 = 228.0F * var189 + 250.0F * var16 + 236.0F * var17;
      float var33 = 234.0F * var189 + 238.0F * var16 + 244.0F * var17;
      float var34 = 244.0F * var189 + 222.0F * var16 + 255.0F * var17;
      float var35 = 0.9F * var16 + 0.8F * var17;
      float var36 = var17;
      float var37 = 0.2F * var29;
      float var38 = 0.45F * var189 + 0.4F * var16;
      boolean var39 = var17 < 0.5F;
      double var40 = 4.5 - 1.3 * (double)var189;
      double var42 = 3.5 - 0.9 * (double)var189;
      float var44 = ow;
      float var45 = ox;
      float var46 = 0.6F + 0.35F * MathHelper.sin(var4 * 0.031);
      float var47 = MathHelper.cos((double)var46);
      float var48 = MathHelper.sin((double)var46);
      float var49 = var189 * (2.0F + 16.0F * var44) + (6.0F * var16 + 2.0F * var17) * var44;
      float var50 = 0.4F * var189 + 0.5F * (var16 + var17);
      float var51 = 0.33F * var49 + 0.4F;
      double var52 = (double)var49 * 0.8 * var4;
      double var54 = (double)var47 * var52;
      double var56 = (double)var48 * var52;
      float var58 = (float)(var4 * 0.11 % 6283.185307179586);
      float var59 = (float)(var4 * 0.07 % 6283.185307179586 + 1.3);
      float var60 = (float)(var4 * 0.09 % 6283.185307179586 + 2.1);
      double var61 = 0.072 * (double)var49 * var4;
      double var63 = 0.288 * (double)var49 * var4;
      double var65 = 0.1 * var4;
      double var67 = 0.2 * var4;
      int var69 = fi & 7;
      byte var70 = 8;
      fi++;
      if (fj > 0) {
         fj--;
         var69 = 0;
         var70 = 1;
      }

      for (int var71 = var69; var71 < var19; var71 += var70) {
         double var72 = ep[var71];
         double var74 = eq[var71];
         double var76 = er[var71];
         float var78 = (float)(var72 * (double)var47 + var76 * (double)var48);
         float var79 = (float)(var76 * (double)var47 - var72 * (double)var48);
         float var80 = var45
            + var50 * MathHelper.sin((double)(0.09F * var78) - var61 + (double)(1.4F * MathHelper.sin((double)(0.05F * var79) + var65)));
         var80 = var80 < 0.0F ? 0.0F : (var80 > 1.0F ? 1.0F : var80);
         float var81 = var49 * (0.55F + 0.45F * var80);
         float var82 = (float)(var72 - var54);
         float var83 = (float)var74;
         float var84 = (float)(var76 - var56);
         float var85 = MathHelper.sin((double)(0.21F * var84 + var58))
            + MathHelper.cos((double)(0.21F * var83 + var59))
            + 0.55F * (MathHelper.sin((double)(0.8F * var84 + var60)) + MathHelper.cos((double)(0.8F * var83 + var58)));
         float var86 = MathHelper.sin((double)(0.21F * var82 + var60))
            + MathHelper.cos((double)(0.21F * var84 + var58))
            + 0.55F * (MathHelper.sin((double)(0.8F * var82 + var59)) + MathHelper.cos((double)(0.8F * var84 + var60)));
         float var87 = MathHelper.sin((double)(0.21F * var83 + var59))
            + MathHelper.cos((double)(0.21F * var82 + var60))
            + 0.55F * (MathHelper.sin((double)(0.8F * var83 + var58)) + MathHelper.cos((double)(0.8F * var82 + var59)));
         fb[var71] = var47 * var81 + var51 * 0.5F * var85;
         fc[var71] = var51 * 0.3F * var86;
         fd[var71] = var48 * var81 + var51 * 0.5F * var87;
         float var88 = var38 > 0.0F
            ? 0.5F
               + 0.5F * MathHelper.sin((double)(0.32F * var78) - var63 + (double)(1.2F * MathHelper.sin((double)(0.13F * var79) + var67)))
            : 1.0F;
         fe[var71] = 1.0F - var38 * (1.0F - var88);
      }

      boolean var190 = qm && var189 > 0.05F;
      float var191 = 1.0F - (float)Math.exp((double)(-var3 * 6.0F));
      float var73 = var3 > 0.001F ? 1.0F / var3 : 1000.0F;
      float var192 = oz + (pa - oz) * (var16 + var17);
      float var75 = 0.25F + 0.75F * (var192 < 0.0F ? 0.0F : (var192 > 1.0F ? 1.0F : var192));
      float var193 = 0.6F + 0.4F * (var192 < 0.0F ? 0.0F : (var192 > 1.0F ? 1.0F : var192));
      float var77 = var7[0];
      float var194 = var7[1];
      float var195 = var7[2];
      float var197 = var7[3];
      float var198 = var7[4];
      float var199 = var7[5];
      float var200 = var7[6];
      float var201 = var7[7];
      float var202 = var7[8];
      float var203 = pl;
      float var204 = pm;
      float var205 = pn;
      float var89 = ol;
      float var90 = om;
      float var91 = on;
      float var92 = pg;
      float var93 = pe;
      float var94 = pf;
      float var95 = pb;
      float var96 = pc;
      float var97 = pd;
      boolean var98 = qm;
      int var99 = qj;
      int var100 = qk;
      int[] var101 = ps;
      boolean var102 = or;
      boolean var103 = ou;
      float var104 = ot;
      float var105 = os;
      float var106 = 22.0F * (0.55F + 0.15F * (var16 + var17));
      float var107 = 22.0F * (0.45F - 0.15F * (var16 + var17));
      float var108 = 8.400001F;
      float var109 = 5.6F;

      for (int var110 = 0; var110 < var19; var110++) {
         float var111 = eu[var110];
         float var112 = ev[var110];
         int var113 = var8 ? ff[var110] : 7;
         float var114 = 1.0F;
         float var115 = 1.0F;
         if (var113 != 7 && var111 >= var23) {
            float var116 = (var111 - var23) * 2.5F;
            if (var116 < 1.0F) {
               var115 = 1.0F - var116;
            } else {
               var113 = 7;
               var114 = 0.42F;
               var115 = var116 < 2.0F ? var116 - 1.0F : 1.0F;
            }
         }

         int var206 = var110 & 3;
         boolean var117 = var190 && var110 % 6 == 0;
         if (var117) {
            var113 = 7;
         }

         double var118 = ep[var110];
         double var120 = eq[var110];
         double var122 = er[var110];
         float var124 = fb[var110];
         float var125 = -es[var110] * var21 + fc[var110];
         float var126 = fd[var110];
         double var127 = var118 + (double)(var124 * var3);
         double var129 = var120 + (double)(var125 * var3);
         double var131 = var122 + (double)(var126 * var3);
         double var133 = var206 < 2 ? var40 : (var206 == 2 ? 11.0 : 22.0);
         double var135 = var206 < 2 ? var42 : (var206 == 2 ? 7.0 : 14.0);
         if (var117) {
            var117 = false;
            int var137 = MathHelper.floor(var127) - var99 + 24;
            int var138 = MathHelper.floor(var131) - var100 + 24;
            if (var137 >= 0 && var138 >= 0 && var137 < 49 && var138 < 49) {
               float var139 = var111 * 0.15915494F;
               double var140 = (double)(
                  (float)var101[var138 * 49 + var137]
                     + 0.03F
                     + 0.55F * var139 * var139
                     + 0.1F * (1.0F + MathHelper.sin(var4 * (double)var112 * 3.0 + (double)var111 * 3.0))
               );
               if (var140 - var11 > -var135 * 0.8 && var140 - var11 < var135 * 0.8) {
                  var117 = true;
                  var129 = var120 + (var140 - var120) * (double)var191;
                  var125 = (float)(var129 - var120) * var73;
                  var125 = var125 > 6.0F ? 6.0F : (var125 < -6.0F ? -6.0F : var125);
                  var124 *= 0.85F;
                  var126 *= 0.85F;
                  var127 = var118 + (double)(var124 * var3);
                  var131 = var122 + (double)(var126 * var3);
               }
            }
         }

         double var210 = var127 - var9;
         double var211 = var129 - var11;
         double var141 = var131 - var13;
         if (var210 < -var133 || var210 >= var133) {
            var210 -= Math.floor((var210 + var133) / (2.0 * var133)) * 2.0 * var133;
            var127 = var9 + var210;
         }

         if (var141 < -var133 || var141 >= var133) {
            var141 -= Math.floor((var141 + var133) / (2.0 * var133)) * 2.0 * var133;
            var131 = var13 + var141;
         }

         if (var211 < -var135 || var211 >= var135) {
            var211 -= Math.floor((var211 + var135) / (2.0 * var135)) * 2.0 * var135;
            var129 = var11 + var211;
         }

         ep[var110] = var127;
         eq[var110] = var129;
         er[var110] = var131;
         float var143 = (float)var210;
         float var144 = (float)var211;
         float var145 = (float)var141;
         float var146 = var143 * var143 + var144 * var144 + var145 * var145;
         if (!(var146 < 0.04F)) {
            float var147 = MathHelper.sqrt(var146);
            float var148 = var143 * var200 + var144 * var201 + var145 * var202;
            if (!(var148 < -0.3F * var147)) {
               if (var102) {
                  float var149 = 0.5F + var148 * var104;
                  if (var149 < 0.0F || (var146 - var148 * var148) * var105 > var149 * var149) {
                     continue;
                  }
               }

               float var212 = 1.0F;
               if (var98) {
                  int var150 = MathHelper.floor(var127) - var99 + 24;
                  int var151 = MathHelper.floor(var131) - var100 + 24;
                  if (var150 >= 0 && var151 >= 0 && var150 < 49 && var151 < 49) {
                     float var152 = (float)var101[var151 * 49 + var150];
                     if (var129 < (double)var152) {
                        continue;
                     }

                     if (!var117) {
                        float var153 = (float)(var129 - (double)var152) * 8.333333F;
                        var212 = var153 > 1.0F ? 1.0F : var153;
                     }
                  }
               }

               float var213 = (var147 - 0.2F) * 2.0F;
               var213 = var213 < 0.0F ? 0.0F : (var213 > 1.0F ? 1.0F : var213);
               float var219 = var144 < 0.0F ? -var144 : var144;
               float var215;
               float var217;
               if (var206 == 3) {
                  var215 = (var147 - var106) / var107;
                  var217 = (var219 - var108) / var109;
               } else {
                  float var154 = var143 < 0.0F ? -var143 : var143;
                  float var155 = var145 < 0.0F ? -var145 : var145;
                  var154 = var154 > var155 ? var154 : var155;
                  var215 = (var154 - (float)var133 * 0.7F) / ((float)var133 * 0.3F);
                  var217 = var117 ? 0.0F : (var219 - (float)var135 * 0.6F) / ((float)var135 * 0.4F);
               }

               var215 = var215 < 0.0F ? 0.0F : (var215 > 1.0F ? 1.0F : var215);
               var217 = var217 < 0.0F ? 0.0F : (var217 > 1.0F ? 1.0F : var217);
               float var221 = (var20 - (float)var110) / 64.0F;
               var221 = var221 < 0.0F ? 0.0F : (var221 > 1.0F ? 1.0F : var221);
               float var223 = (0.85F + 0.85F * var189)
                  * var6
                  * var213
                  * var213
                  * (3.0F - 2.0F * var213)
                  * (1.0F - var215 * var215 * (3.0F - 2.0F * var215))
                  * (1.0F - var217 * var217 * (3.0F - 2.0F * var217))
                  * var221
                  * var115
                  * var212
                  * fe[var110];
               if (var117) {
                  var223 *= 0.6F;
               }

               if (!(var223 < 0.012F)) {
                  float var156 = var113 == 7 ? 0.25F : 0.45F;
                  float var157 = MathHelper.sin(var4 * (double)var112 * 2.0 + (double)var111) * var156;
                  float var158 = MathHelper.cos(var4 * (double)var112 * 1.7 + (double)var111 * 1.7) * var156;
                  var124 += var157;
                  var126 += var158;
                  ep[var110] = var127 + (double)(var157 * var3);
                  er[var110] = var131 + (double)(var158 * var3);
                  float var159 = et[var110] * var22 * var114 * (1.0F + var147 * var31);
                  float var160 = 0.0F;
                  if (var39 && var113 == 7 && var147 < 1.4F) {
                     float var161 = var159 + 0.006F * (1.4F - var147) / var147;
                     float var162 = var159 / var161;
                     var223 *= var162 * var162 * 1.6F;
                     var160 = 1.0F - var162;
                     var159 = var161;
                  }

                  float var224 = var159 * 2.0F * var89 / var147;
                  if (var113 != 7 && var224 < 16.0F) {
                     var113 = 7;
                     var159 *= 0.9F;
                     var224 *= 0.9F;
                  }

                  float var163;
                  float var164;
                  float var165;
                  float var166;
                  float var167;
                  float var168;
                  float var169;
                  float var170;
                  float var171;
                  float var225;
                  if (var113 != 7) {
                     double var226 = (double)var111 + var4 * (double)fa[var110];
                     float var233 = MathHelper.cos(var226);
                     float var237 = MathHelper.sin(var226);
                     float var240 = 0.7F + 0.3F * Math.abs(MathHelper.cos(var4 * (double)var112 * 0.7 + (double)var111 * 1.3));
                     float var251 = var159 * var240;
                     var165 = (var77 * var233 + var197 * var237) * var251;
                     var166 = (var194 * var233 + var198 * var237) * var251;
                     var167 = (var195 * var233 + var199 * var237) * var251;
                     var225 = (-var77 * var237 + var197 * var233) * var159;
                     var163 = (-var194 * var237 + var198 * var233) * var159;
                     var164 = (-var195 * var237 + var199 * var233) * var159;
                     float var253 = var224 * MathHelper.sqrt(var240);
                     int var255 = (var253 >= 64.0F ? 0 : (var253 >= 32.0F ? 8 : (var253 >= 16.0F ? 16 : 24))) + var113;
                     var168 = dd[var255];
                     var169 = de[var255];
                     var170 = df[var255];
                     var171 = dg[var255];
                  } else {
                     boolean var172 = var28 && var111 < var29;
                     if (var172) {
                        float var173 = var30 * var147 / var89;
                        var159 = var159 < var173 ? var173 : var159;
                     } else {
                        float var229 = 0.75F * var147 / var89;
                        if (var159 < var229) {
                           var223 *= var159 / var229;
                           var159 = var229;
                        }
                     }

                     var225 = var197 * var159;
                     var163 = var198 * var159;
                     var164 = var199 * var159;
                     var165 = var77 * var159;
                     var166 = var194 * var159;
                     var167 = var195 * var159;
                     float var230 = var124 - var203;
                     float var174 = var125 - var204;
                     float var175 = var126 - var205;
                     float var176 = var230 * var230 + var174 * var174 + var175 * var175;
                     if (var24 > 0.0F && var176 > 1.0E-4F) {
                        float var177 = MathHelper.sqrt(var176);
                        float var178 = var230 / var177;
                        float var179 = var174 / var177;
                        float var180 = var175 / var177;
                        float var181 = var179 * var145 - var180 * var144;
                        float var182 = var180 * var143 - var178 * var145;
                        float var183 = var178 * var144 - var179 * var143;
                        float var184 = MathHelper.sqrt(var181 * var181 + var182 * var182 + var183 * var183);
                        if (var184 > 0.001F) {
                           float var185 = var159 / var184;
                           float var186 = var177 * (var117 ? 0.03F : var24) * 0.5F;
                           float var187 = 0.7F * var147 / var89;
                           var223 *= (float)Math.sqrt(Math.sqrt((double)(var159 / (var159 + var186))));
                           float var188 = var159 + var186;
                           if (var159 < var187) {
                              var223 *= var159 / var187;
                              var185 = var187 / var184;
                           }

                           var225 = var178 * var188;
                           var163 = var179 * var188;
                           var164 = var180 * var188;
                           var165 = var181 * var185;
                           var166 = var182 * var185;
                           var167 = var183 * var185;
                        }
                     }

                     if (var8) {
                        int var249 = (var224 >= 64.0F ? 0 : (var224 >= 32.0F ? 8 : (var224 >= 16.0F ? 16 : 24))) + 7;
                        if (!var28 || !var172 && !var117 && !(var189 > 0.5F)) {
                           var168 = dd[var249];
                           var169 = de[var249];
                           var170 = df[var249];
                           var171 = dg[var249];
                        } else {
                           var249 >>= 3;
                           var168 = dh[var249];
                           var169 = dj[var249];
                           var170 = di[var249];
                           var171 = dk[var249];
                        }
                     } else {
                        var168 = 0.0F;
                        var169 = 0.0F;
                        var170 = 1.0F;
                        var171 = 1.0F;
                     }
                  }

                  float var227 = (var26 + var27 * ew[var110]) * (var8 ? var193 : var75) * var25;
                  var227 = var227 > 1.0F ? 1.0F : var227;
                  if (var35 > 0.0F) {
                     float var231 = (var143 * var90 + var144 * var91) / var147;
                     if (var231 > 0.0F) {
                        float var234 = var231 * var231;
                        var234 *= var234;
                        float var238 = var234 * var234;
                        var227 *= 1.0F + var35 * (0.35F * var234 + 0.9F * var238 * var238);
                        var223 *= 1.0F + var35 * 0.6F * var238;
                        if (var36 > 0.0F && var113 == 7 && var111 < var37) {
                           float var241 = MathHelper.sin(var4 * (double)var112 * 5.0 + (double)var111 * 7.0);
                           var241 *= var241;
                           var241 *= var241;
                           var241 *= var241;
                           var241 *= var241;
                           var227 *= 1.0F + 1.5F * var36 * var241 * var241;
                        }
                     }
                  }

                  if (var117) {
                     var227 *= 1.08F;
                  }

                  if (var160 > 0.0F) {
                     var227 += (1.05F - var227) * var160;
                  }

                  float var232 = var32 * var227;
                  float var236 = var33 * var227;
                  float var239 = var34 * var227;
                  if (var92 > 0.0F) {
                     float var246 = (var147 - var93) * var94;
                     var246 = var246 < 0.0F ? 0.0F : (var246 > 1.0F ? 1.0F : var246);
                     var232 += (var95 - var232) * var246;
                     var236 += (var96 - var236) * var246;
                     var239 += (var97 - var239) * var246;
                  }

                  int var248 = (int)(var232 > 255.0F ? 255.0F : var232);
                  int var252 = (int)(var236 > 255.0F ? 255.0F : var236);
                  int var254 = (int)(var239 > 255.0F ? 255.0F : var239);
                  int var256 = (int)((var223 > 1.0F ? 1.0F : var223) * 255.0F);
                  if (var103) {
                     var0.vertex(var143 - var165 - var225, var144 - var166 - var163, var145 - var167 - var164)
                        .texture(var168, var171)
                        .color(var248, var252, var254, var256);
                     var0.vertex(var143 - var165 + var225, var144 - var166 + var163, var145 - var167 + var164)
                        .texture(var168, var169)
                        .color(var248, var252, var254, var256);
                     var0.vertex(var143 + var165 + var225, var144 + var166 + var163, var145 + var167 + var164)
                        .texture(var170, var169)
                        .color(var248, var252, var254, var256);
                     var0.vertex(var143 + var165 - var225, var144 + var166 - var163, var145 + var167 - var164)
                        .texture(var170, var171)
                        .color(var248, var252, var254, var256);
                  } else {
                     var0.vertex(var1, var143 - var165 - var225, var144 - var166 - var163, var145 - var167 - var164)
                        .texture(var168, var171)
                        .color(var248, var252, var254, var256);
                     var0.vertex(var1, var143 - var165 + var225, var144 - var166 + var163, var145 - var167 + var164)
                        .texture(var168, var169)
                        .color(var248, var252, var254, var256);
                     var0.vertex(var1, var143 + var165 + var225, var144 + var166 + var163, var145 + var167 + var164)
                        .texture(var170, var169)
                        .color(var248, var252, var254, var256);
                     var0.vertex(var1, var143 + var165 - var225, var144 + var166 - var163, var145 + var167 - var164)
                        .texture(var170, var171)
                        .color(var248, var252, var254, var256);
                  }
               }
            }
         }
      }
   }

   private static void ac(VertexConsumer var0, MatrixStack.Entry var1, Vec3d var2, float var3, double var4, float var6, float[] var7) {

      assert var0 != null
         && var2 != null
         && var7 != null
         && var7.length == 9
         && var3 >= 0.0F
         && var3 <= 0.11F
         && !Double.isNaN(var4)
         && var6 >= 0.0F
         && var6 <= 2.0F
         && (740324827 ^ 740315851) == fs.length
         && (1971099111 ^ 1971106551) == ft.length
         && (1813632459 ^ 1813639899) == fu.length
         && (-18211443 ^ -18204003) == fv.length
         && (1647228456 ^ 1647219000) == fw.length
         && (-1185553688 ^ -1185561096) == fx.length
         && dh.length == 4
         && dj.length == 4
         && di.length == 4
         && dk.length == 4
         && ps.length == (-88919914 ^ -88917513) : "farSnow: bad frame";

      try {
         double var8 = var2.x;
         double var10 = var2.y;
         double var12 = var2.z;
         if (!fy) {
            for (int var14 = 0; var14 < (1869333066 ^ 1869342042); var14++) {
               fs[var14] = var8 + (ed.nextDouble() * 2.0 - 1.0) * 44.0;
               ft[var14] = var10 + (ed.nextDouble() * 2.0 - 1.0) * 22.0;
               fu[var14] = var12 + (ed.nextDouble() * 2.0 - 1.0) * 44.0;
               fv[var14] = 0.8F + ed.nextFloat() * 0.7F;
               fw[var14] = 0.035F + ed.nextFloat() * 0.03F;
               fx[var14] = 0.86F + ed.nextFloat() * 0.14F;
            }

            fy = true;
         }

         float var121 = fl;
         float var15 = fm;
         float var16 = var121 + var15;
         float var17 = 5000.0F * Math.max(0.05F, ov) * (1.8F * var121 + 3.2F * var15) / var16;
         var17 = var17 > 10000.0F ? 10000.0F : var17;
         fz = fz + (var17 - fz) * (1.0F - (float)Math.exp((double)(-var3 * 1.5F)));
         int var18 = Math.min(181868005 ^ 181875445, (int)Math.ceil((double)fz));
         float var19 = fz;
         float var20 = (0.8F * var121 + 0.85F * var15) / var16;
         float var21 = ow * (0.55F + 0.45F * ox) * (6.0F * var121 + 2.0F * var15) / var16;
         float var22 = 0.6F + 0.35F * MathHelper.sin(var4 * 0.031);
         float var23 = MathHelper.cos((double)var22) * var21;
         float var24 = MathHelper.sin((double)var22) * var21;
         float var25 = 0.085F * var121 / var16;
         float var26 = (0.7F * var121 + 4.0F * var15) / var16;
         float var27 = pa < 0.0F ? 0.0F : (pa > 1.0F ? 1.0F : pa);
         float var28 = (0.6F + 0.4F * var27) * (1.45F * var121 + var15) / var16;
         float var29 = (250.0F * var121 + 236.0F * var15) / var16;
         float var30 = (238.0F * var121 + 244.0F * var15) / var16;
         float var31 = (222.0F * var121 + 255.0F * var15) / var16;
         float var32 = var7[0];
         float var33 = var7[1];
         float var34 = var7[2];
         float var35 = var7[3];
         float var36 = var7[4];
         float var37 = var7[5];
         float var38 = var7[6];
         float var39 = var7[7];
         float var40 = var7[8];
         float var41 = pl;
         float var42 = pm;
         float var43 = pn;
         float var44 = ol;
         boolean var45 = qm;
         boolean var46 = or;
         boolean var47 = ou;
         int var48 = qj;
         int var49 = qk;
         int[] var50 = ps;
         float var51 = ot;
         float var52 = os;
         double var53 = 88.0;
         double var55 = 44.0;
         double var57 = 88.0;
         float var59 = 12.1F;
         float var60 = 9.9F;
         float var61 = (0.85F * var121 + 1.1F * var15) * var6;
         float var62 = om;
         float var63 = on;
         float var64 = (0.9F * var121 + 0.8F * var15) / var16;
         float var65 = pg;
         float var66 = pe;
         float var67 = pf;
         float var68 = pb;
         float var69 = pc;
         float var70 = pd;

         for (int var71 = 0; var71 < var18; var71++) {
            float var72 = -fv[var71] * var20;
            double var73 = fs[var71] + (double)(var23 * var3);
            double var75 = ft[var71] + (double)(var72 * var3);
            double var77 = fu[var71] + (double)(var24 * var3);
            double var79 = var73 - var8;
            double var81 = var75 - var10;
            double var83 = var77 - var12;
            if (var79 < -44.0 || var79 >= 44.0) {
               var79 -= Math.floor((var79 + 44.0) / var53) * var53;
               var73 = var8 + var79;
            }

            if (var83 < -44.0 || var83 >= 44.0) {
               var83 -= Math.floor((var83 + 44.0) / var57) * var57;
               var77 = var12 + var83;
            }

            if (var81 < -22.0 || var81 >= 22.0) {
               var81 -= Math.floor((var81 + 22.0) / var55) * var55;
               var75 = var10 + var81;
            }

            fs[var71] = var73;
            ft[var71] = var75;
            fu[var71] = var77;
            float var85 = (float)var79;
            float var86 = (float)var81;
            float var87 = (float)var83;
            float var88 = var85 * var85 + var86 * var86 + var87 * var87;
            if (!(var88 < 256.0F)) {
               float var89 = MathHelper.sqrt(var88);
               float var90 = var85 * var38 + var86 * var39 + var87 * var40;
               if (!(var90 < 0.1F * var89)) {
                  if (var46) {
                     float var91 = 0.5F + var90 * var51;
                     if ((var88 - var90 * var90) * var52 > var91 * var91) {
                        continue;
                     }
                  }

                  if (var45) {
                     int var123 = MathHelper.floor(var73) - var48 + 24;
                     int var92 = MathHelper.floor(var77) - var49 + 24;
                     if (var123 >= 0 && var92 >= 0 && var123 < 49 && var92 < 49 && var75 < (double)var50[var92 * 49 + var123]) {
                        continue;
                     }
                  }

                  float var124 = (var89 - 16.0F) / 6.0F;
                  var124 = var124 > 1.0F ? 1.0F : var124;
                  float var126 = (var89 - 34.0F) / 10.0F;
                  var126 = var126 < 0.0F ? 0.0F : (var126 > 1.0F ? 1.0F : var126);
                  float var93 = var86 < 0.0F ? -var86 : var86;
                  float var94 = (var93 - var59) / var60;
                  var94 = var94 < 0.0F ? 0.0F : (var94 > 1.0F ? 1.0F : var94);
                  float var95 = (var19 - (float)var71) / 64.0F;
                  var95 = var95 < 0.0F ? 0.0F : (var95 > 1.0F ? 1.0F : var95);
                  float var96 = var61
                     * var124
                     * var124
                     * (3.0F - 2.0F * var124)
                     * (1.0F - var126 * var126 * (3.0F - 2.0F * var126))
                     * (1.0F - var94 * var94 * (3.0F - 2.0F * var94))
                     * var95;
                  if (!(var96 < 0.012F)) {
                     float var97 = fw[var71];
                     float var98 = var26 * var89 / var44;
                     var97 = var97 < var98 ? var98 : var97;
                     float var99 = var35 * var97;
                     float var100 = var36 * var97;
                     float var101 = var37 * var97;
                     float var102 = var32 * var97;
                     float var103 = var33 * var97;
                     float var104 = var34 * var97;
                     if (var25 > 0.0F) {
                        float var105 = var23 - var41;
                        float var106 = var72 - var42;
                        float var107 = var24 - var43;
                        float var108 = var105 * var105 + var106 * var106 + var107 * var107;
                        if (var108 > 1.0E-4F) {
                           float var109 = MathHelper.sqrt(var108);
                           float var110 = var105 / var109;
                           float var111 = var106 / var109;
                           float var112 = var107 / var109;
                           float var113 = var111 * var87 - var112 * var86;
                           float var114 = var112 * var85 - var110 * var87;
                           float var115 = var110 * var86 - var111 * var85;
                           float var116 = MathHelper.sqrt(var113 * var113 + var114 * var114 + var115 * var115);
                           if (var116 > 0.001F) {
                              float var117 = var109 * var25 * 0.5F;
                              float var118 = var97 + var117;
                              float var119 = var97 / var116;
                              var96 *= (float)Math.sqrt(Math.sqrt((double)(var97 / var118)));
                              var99 = var110 * var118;
                              var100 = var111 * var118;
                              var101 = var112 * var118;
                              var102 = var113 * var119;
                              var103 = var114 * var119;
                              var104 = var115 * var119;
                           }
                        }
                     }

                     float var131 = var97 * 2.0F * var44 / var89;
                     int var132 = var131 >= 32.0F ? 1 : (var131 >= 16.0F ? 2 : 3);
                     float var133 = dh[var132];
                     float var134 = dj[var132];
                     float var135 = di[var132];
                     float var136 = dk[var132];
                     float var137 = fx[var71] * var28;
                     var137 = var137 > 1.0F ? 1.0F : var137;
                     float var139 = (var85 * var62 + var86 * var63) / var89;
                     if (var139 > 0.0F) {
                        float var140 = var139 * var139;
                        var140 *= var140;
                        float var143 = var140 * var140;
                        var137 *= 1.0F + var64 * (0.35F * var140 + 0.9F * var143 * var143);
                        var96 *= 1.0F + var64 * 0.6F * var143;
                     }

                     float var142 = var29 * var137;
                     float var144 = var30 * var137;
                     float var145 = var31 * var137;
                     if (var65 > 0.0F) {
                        float var146 = (var89 - var66) * var67;
                        var146 = var146 < 0.0F ? 0.0F : (var146 > 1.0F ? 1.0F : var146);
                        var142 += (var68 - var142) * var146;
                        var144 += (var69 - var144) * var146;
                        var145 += (var70 - var145) * var146;
                     }

                     int var148 = (int)(var142 > 255.0F ? 255.0F : var142);
                     int var149 = (int)(var144 > 255.0F ? 255.0F : var144);
                     int var150 = (int)(var145 > 255.0F ? 255.0F : var145);
                     int var151 = (int)((var96 > 1.0F ? 1.0F : var96) * 255.0F);
                     if (var47) {
                        var0.vertex(var85 - var102 - var99, var86 - var103 - var100, var87 - var104 - var101)
                           .texture(var133, var136)
                           .color(var148, var149, var150, var151);
                        var0.vertex(var85 - var102 + var99, var86 - var103 + var100, var87 - var104 + var101)
                           .texture(var133, var134)
                           .color(var148, var149, var150, var151);
                        var0.vertex(var85 + var102 + var99, var86 + var103 + var100, var87 + var104 + var101)
                           .texture(var135, var134)
                           .color(var148, var149, var150, var151);
                        var0.vertex(var85 + var102 - var99, var86 + var103 - var100, var87 + var104 - var101)
                           .texture(var135, var136)
                           .color(var148, var149, var150, var151);
                     } else {
                        var0.vertex(var1, var85 - var102 - var99, var86 - var103 - var100, var87 - var104 - var101)
                           .texture(var133, var136)
                           .color(var148, var149, var150, var151);
                        var0.vertex(var1, var85 - var102 + var99, var86 - var103 + var100, var87 - var104 + var101)
                           .texture(var133, var134)
                           .color(var148, var149, var150, var151);
                        var0.vertex(var1, var85 + var102 + var99, var86 + var103 + var100, var87 + var104 + var101)
                           .texture(var135, var134)
                           .color(var148, var149, var150, var151);
                        var0.vertex(var1, var85 + var102 - var99, var86 + var103 - var100, var87 + var104 - var101)
                           .texture(var135, var136)
                           .color(var148, var149, var150, var151);
                     }
                  }
               }
            }
         }
      } catch (RuntimeException var120) {
         throw var120;
      }
   }

   private static void ad(int var0, double var1, double var3, double var5, boolean var7) {

      double var8 = ed.nextDouble() * Math.PI * 2.0;
      double var10 = 3.0 + 22.0 * Math.sqrt(ed.nextDouble());
      gb[var0] = var1 + Math.cos(var8) * var10;
      gd[var0] = var5 + Math.sin(var8) * var10;
      double var12 = var3 - 8.0 + ed.nextDouble() * 16.0;
      int var14 = v(gb[var0], gd[var0]);
      if (var14 != (-1737445168 ^ 410038480) && var12 < (double)var14 && (double)var14 < var3 + 16.0) {
         var12 = (double)var14 + ed.nextDouble() * 2.0;
      }

      gc[var0] = var12;
      gf[var0] = 3.5F + ed.nextFloat() * 4.0F;
      ge[var0] = var7 ? ed.nextFloat() * gf[var0] : 0.0F;
      gg[var0] = 0.008F + ed.nextFloat() * ed.nextFloat() * 0.016F;
      gh[var0] = ed.nextFloat() * (float) (Math.PI * 2);
      gi[var0] = (1.2F + ed.nextFloat() * 1.8F) * (float)Math.exp((double)(-ge[var0] / 1.6F));
      gj[var0] = 0.6F + ed.nextFloat() * 0.9F;
   }

   private static void ae(VertexConsumer var0, MatrixStack.Entry var1, Vec3d var2, float var3, double var4, float var6, float[] var7, float var8) {

      double var9 = var2.x;
      double var11 = var2.y;
      double var13 = var2.z;
      if (!gn) {
         for (int var15 = 0; var15 < (-1462826638 ^ -1462826118); var15++) {
            ad(var15, var9, var11, var13, true);
         }

         gn = true;
         gq = 2;
      }

      float var129 = 520.0F * Math.max(0.05F, ov) * kb;
      go = go + (var129 - go) * (1.0F - (float)Math.exp((double)(-var3 * 1.5F)));
      int var16 = Math.min(-795331373 ^ -795330853, (int)Math.ceil((double)go));
      float var17 = go;
      float var18 = ow * 4.0F;
      float var19 = 0.6F + 0.35F * MathHelper.sin(var4 * 0.031);
      float var20 = MathHelper.cos((double)var19) * var18;
      float var21 = MathHelper.sin((double)var19) * var18;
      float var22 = oy;
      float var23 = 0.75F + 0.25F * var22;
      float var24 = 0.16F + 0.3F * var22;
      float var25 = (float)Math.exp((double)(-var3 / 1.6F));
      float var26 = var7[0];
      float var27 = var7[1];
      float var28 = var7[2];
      float var29 = var7[3];
      float var30 = var7[4];
      float var31 = var7[5];
      float var32 = var7[6];
      float var33 = var7[7];
      float var34 = var7[8];
      float var35 = pl;
      float var36 = pm;
      float var37 = pn;
      float var38 = ol;
      float var39 = pg;
      float var40 = pe;
      float var41 = pf;
      boolean var42 = qm;
      int var43 = qj;
      int var44 = qk;
      int[] var45 = ps;
      boolean var46 = or;
      float var47 = ot;
      float var48 = os;
      float var49 = (float)(var4 * 0.7 % 6283.185307179586);
      float var50 = (float)(var4 * 0.53 % 6283.185307179586 + 1.3);
      float var51 = (float)(var4 * 0.61 % 6283.185307179586 + 2.1);
      double var52 = (double)var20 * var4 * 0.6;
      double var54 = (double)var21 * var4 * 0.6;
      int var56 = gp & 7;
      byte var57 = 8;
      gp++;
      if (gq > 0) {
         gq--;
         var56 = 0;
         var57 = 1;
      }

      for (int var58 = var56; var58 < var16; var58 += var57) {
         float var59 = (float)(gb[var58] - var52);
         float var60 = (float)gc[var58];
         float var61 = (float)(gd[var58] - var54);
         gk[var58] = 0.45F
            * (
               MathHelper.sin((double)(1.3F * var61 + var49))
                  + MathHelper.cos((double)(1.3F * var60 + var50))
                  + 0.5F * (MathHelper.sin((double)(3.1F * var61 + var51)) + MathHelper.cos((double)(3.1F * var60 + var49)))
            );
         gl[var58] = 0.35F
            * (
               MathHelper.sin((double)(1.3F * var59 + var51))
                  + MathHelper.cos((double)(1.3F * var61 + var49))
                  + 0.5F * (MathHelper.sin((double)(3.1F * var59 + var50)) + MathHelper.cos((double)(3.1F * var61 + var51)))
            );
         gm[var58] = 0.45F
            * (
               MathHelper.sin((double)(1.3F * var60 + var50))
                  + MathHelper.cos((double)(1.3F * var59 + var51))
                  + 0.5F * (MathHelper.sin((double)(3.1F * var60 + var49)) + MathHelper.cos((double)(3.1F * var59 + var50)))
            );
      }

      for (int var130 = 0; var130 < var16; var130++) {
         float var131 = ge[var130] + var3;
         double var132 = gb[var130];
         double var62 = gc[var130];
         double var64 = gd[var130];
         double var66 = (var132 - var9) * (var132 - var9) + (var64 - var13) * (var64 - var13);
         double var68 = var62 - var11;
         if (var131 >= gf[var130] || var66 > 784.0 || var68 > 18.0 || var68 < -18.0) {
            ad(var130, var9, var11, var13, false);
            var131 = 0.0F;
            var132 = gb[var130];
            var62 = gc[var130];
            var64 = gd[var130];
         }

         ge[var130] = var131;
         float var70 = gf[var130];
         float var71 = var131 / var70;
         float var72 = gh[var130];
         float var73 = gi[var130] * var25;
         gi[var130] = var73;
         float var74 = var20 * 0.8F + gk[var130];
         float var75 = var21 * 0.8F + gm[var130];
         float var76 = var73 - 0.25F + gl[var130];
         var132 += (double)(var74 * var3);
         var62 += (double)(var76 * var3);
         var64 += (double)(var75 * var3);
         gb[var130] = var132;
         gc[var130] = var62;
         gd[var130] = var64;
         float var77 = (float)(var132 - var9);
         float var78 = (float)(var62 - var11);
         float var79 = (float)(var64 - var13);
         float var80 = var77 * var77 + var78 * var78 + var79 * var79;
         float var81 = MathHelper.sqrt(var80);
         float var82 = var77 * var32 + var78 * var33 + var79 * var34;
         if (!(var81 < 0.3F) && !(var82 < -0.3F * var81)) {
            if (var46) {
               float var83 = 0.7F + var82 * var47;
               if (var83 < 0.0F || (var80 - var82 * var82) * var48 > var83 * var83) {
                  continue;
               }
            }

            float var136 = var71 / 0.06F;
            var136 = var136 > 1.0F ? 1.0F : var136;
            float var84 = var81 - 0.35F;
            var84 = var84 < 0.0F ? 0.0F : (var84 > 1.0F ? 1.0F : var84);
            float var85 = (var81 - 18.0F) / 8.0F;
            var85 = var85 < 0.0F ? 0.0F : (var85 > 1.0F ? 1.0F : var85);
            float var86 = var78 < 0.0F ? -var78 : var78;
            float var87 = (var86 - 12.0F) / 5.5F;
            var87 = var87 < 0.0F ? 0.0F : (var87 > 1.0F ? 1.0F : var87);
            float var88 = (var17 - (float)var130) / 24.0F;
            var88 = var88 < 0.0F ? 0.0F : (var88 > 1.0F ? 1.0F : var88);
            float var89 = MathHelper.sin(var4 * 2.3 * (double)gj[var130] + (double)var72);
            var89 = var89 > 0.96F ? (var89 - 0.96F) * 25.0F : 0.0F;
            float var90 = 0.7F
               + 0.3F * MathHelper.sin(var4 * 23.0 + (double)var72 * 3.0) * MathHelper.sin(var4 * 17.3 + (double)var72 * 5.0)
               + 0.8F * var89;
            float var91 = 1.0F - var71;
            float var92 = var91 * var91 * (1.5F - 0.5F * var91);
            float var93 = var6
               * var136
               * var90
               * var88
               * var92
               * 2.0F
               * var84
               * var84
               * (3.0F - 2.0F * var84)
               * (1.0F - var85 * var85 * (3.0F - 2.0F * var85))
               * (1.0F - var87 * var87 * (3.0F - 2.0F * var87));
            if (var42) {
               int var94 = MathHelper.floor(var132) - var43 + 24;
               int var95 = MathHelper.floor(var64) - var44 + 24;
               if (var94 >= 0 && var95 >= 0 && var94 < 49 && var95 < 49) {
                  float var96 = (float)(var62 - ((double)var45[var95 * 49 + var94] - 0.1)) / 0.9F;
                  var96 = var96 < 0.0F ? 0.0F : (var96 > 1.0F ? 1.0F : var96);
                  var93 *= var96 * var96 * (3.0F - 2.0F * var96);
               }
            }

            if (var39 > 0.0F) {
               float var143 = (var81 - var40) * var41;
               var93 *= var143 < 0.0F ? 1.0F : (var143 > 1.0F ? 0.0F : 1.0F - var143);
            }

            if (!(var93 < 0.01F)) {
               int var144;
               int var145;
               int var147;
               if (var91 > 0.6F) {
                  float var97 = (var91 - 0.6F) / 0.4F;
                  var144 = -1751862972 ^ -1751862853;
                  var145 = (int)(120.0F + 70.0F * var97);
                  var147 = (int)(30.0F + 40.0F * var97);
               } else if (var91 > 0.25F) {
                  float var148 = (var91 - 0.25F) / 0.35F;
                  var144 = -1466923995 ^ -1466923814;
                  var145 = (int)(62.0F + 58.0F * var148);
                  var147 = (int)(12.0F + 18.0F * var148);
               } else {
                  float var149 = var91 / 0.25F;
                  var144 = (int)(170.0F + 85.0F * var149);
                  var145 = (int)(28.0F + 34.0F * var149);
                  var147 = (int)(8.0F + 4.0F * var149);
               }

               if (var8 > 0.0F) {
                  int var150 = var91 > 0.5F ? -2180376 ^ -2180585 : (int)(255.0F - 150.0F * (0.5F - var91));
                  int var98 = (int)(12.0F + 52.0F * var91);
                  int var99 = (int)(10.0F + 34.0F * var91);
                  var144 = (int)((float)var144 + (float)(var150 - var144) * var8);
                  var145 = (int)((float)var145 + (float)(var98 - var145) * var8);
                  var147 = (int)((float)var147 + (float)(var99 - var147) * var8);
               }

               float var151 = gg[var130];
               float var152 = 0.1F + var151 * 6.0F;
               float var153 = var81 * 0.12F;
               if (var152 > var153) {
                  var152 = var153;
               }

               int var100 = (int)((var93 > 1.0F ? 1.0F : var93) * var24 * 255.0F);
               float var101 = var26 * var152;
               float var102 = var27 * var152;
               float var103 = var28 * var152;
               float var104 = var29 * var152;
               float var105 = var30 * var152;
               float var106 = var31 * var152;
               if (ou) {
                  var0.vertex(var77 - var101 - var104, var78 - var102 - var105, var79 - var103 - var106)
                     .texture(0.0F, 1.0F)
                     .color(var144, var145, var147, var100);
                  var0.vertex(var77 - var101 + var104, var78 - var102 + var105, var79 - var103 + var106)
                     .texture(0.0F, 0.0F)
                     .color(var144, var145, var147, var100);
                  var0.vertex(var77 + var101 + var104, var78 + var102 + var105, var79 + var103 + var106)
                     .texture(1.0F, 0.0F)
                     .color(var144, var145, var147, var100);
                  var0.vertex(var77 + var101 - var104, var78 + var102 - var105, var79 + var103 - var106)
                     .texture(1.0F, 1.0F)
                     .color(var144, var145, var147, var100);
               } else {
                  var0.vertex(var1, var77 - var101 - var104, var78 - var102 - var105, var79 - var103 - var106)
                     .texture(0.0F, 1.0F)
                     .color(var144, var145, var147, var100);
                  var0.vertex(var1, var77 - var101 + var104, var78 - var102 + var105, var79 - var103 + var106)
                     .texture(0.0F, 0.0F)
                     .color(var144, var145, var147, var100);
                  var0.vertex(var1, var77 + var101 + var104, var78 + var102 + var105, var79 + var103 + var106)
                     .texture(1.0F, 0.0F)
                     .color(var144, var145, var147, var100);
                  var0.vertex(var1, var77 + var101 - var104, var78 + var102 - var105, var79 + var103 - var106)
                     .texture(1.0F, 1.0F)
                     .color(var144, var145, var147, var100);
               }

               float var107 = var151;
               float var108 = 0.95F * var81 / var38;
               float var109 = 1.0F;
               if (var151 < var108) {
                  var109 = var151 / var108;
                  var107 = var108;
               }

               float var110 = var29 * var107;
               float var111 = var30 * var107;
               float var112 = var31 * var107;
               float var113 = var26 * var107;
               float var114 = var27 * var107;
               float var115 = var28 * var107;
               float var116 = var74 - var35;
               float var117 = var76 - var36;
               float var118 = var75 - var37;
               float var119 = var116 * var116 + var117 * var117 + var118 * var118;
               if (var119 > 1.0E-4F) {
                  float var120 = MathHelper.sqrt(var119);
                  float var121 = var116 / var120;
                  float var122 = var117 / var120;
                  float var123 = var118 / var120;
                  float var124 = var122 * var79 - var123 * var78;
                  float var125 = var123 * var77 - var121 * var79;
                  float var126 = var121 * var78 - var122 * var77;
                  float var127 = MathHelper.sqrt(var124 * var124 + var125 * var125 + var126 * var126);
                  if (var127 > 0.001F) {
                     float var128 = var107 + var120 * 0.0165F;
                     var109 *= (float)Math.sqrt((double)(var107 / var128));
                     var110 = var121 * var128;
                     var111 = var122 * var128;
                     var112 = var123 * var128;
                     var113 = var124 * var107 / var127;
                     var114 = var125 * var107 / var127;
                     var115 = var126 * var107 / var127;
                  }
               }

               float var154 = var93 * var23 * (var109 * 2.2F > 1.0F ? 1.0F : var109 * 2.2F) * 1.6F;
               int var155 = (int)((var154 > 1.0F ? 1.0F : var154) * 255.0F);
               int var156 = var145 + 70 > (-1901979162 ^ -1901979367) ? 637739032 ^ 637739239 : var145 + 70;
               int var157 = var147 + 40 > (1281511540 ^ 1281511563) ? -1020340821 ^ -1020340908 : var147 + 40;
               if (ou) {
                  var0.vertex(var77 - var113 - var110, var78 - var114 - var111, var79 - var115 - var112)
                     .texture(0.0F, 1.0F)
                     .color(-388494362 ^ -388494567, var156, var157, var155);
                  var0.vertex(var77 - var113 + var110, var78 - var114 + var111, var79 - var115 + var112)
                     .texture(0.0F, 0.0F)
                     .color(1490417715 ^ 1490417868, var156, var157, var155);
                  var0.vertex(var77 + var113 + var110, var78 + var114 + var111, var79 + var115 + var112)
                     .texture(1.0F, 0.0F)
                     .color(-1451630964 ^ -1451630989, var156, var157, var155);
                  var0.vertex(var77 + var113 - var110, var78 + var114 - var111, var79 + var115 - var112)
                     .texture(1.0F, 1.0F)
                     .color(1288994429 ^ 1288994434, var156, var157, var155);
               } else {
                  var0.vertex(var1, var77 - var113 - var110, var78 - var114 - var111, var79 - var115 - var112)
                     .texture(0.0F, 1.0F)
                     .color(1389969988 ^ 1389970107, var156, var157, var155);
                  var0.vertex(var1, var77 - var113 + var110, var78 - var114 + var111, var79 - var115 + var112)
                     .texture(0.0F, 0.0F)
                     .color(-1861842842 ^ -1861842791, var156, var157, var155);
                  var0.vertex(var1, var77 + var113 + var110, var78 + var114 + var111, var79 + var115 + var112)
                     .texture(1.0F, 0.0F)
                     .color(-1126004367 ^ -1126004338, var156, var157, var155);
                  var0.vertex(var1, var77 + var113 - var110, var78 + var114 - var111, var79 + var115 - var112)
                     .texture(1.0F, 1.0F)
                     .color(-1027179510 ^ -1027179275, var156, var157, var155);
               }
            }
         }
      }
   }

   private static void af(int var0, double var1, double var3, double var5) {

      gw[var0] = var1 + (ed.nextDouble() * 2.0 - 1.0) * 14.0;
      ha[var0] = var3 + (ed.nextDouble() * 2.0 - 1.0) * 8.0;
      hb[var0] = var5 + (ed.nextDouble() * 2.0 - 1.0) * 14.0;
      float var7 = ed.nextFloat() * (float) (Math.PI * 2);
      float var8 = 0.05F + ed.nextFloat() * 0.18F;
      hc[var0] = MathHelper.cos((double)var7) * var8;
      he[var0] = MathHelper.sin((double)var7) * var8;
      hd[var0] = (ed.nextFloat() * 2.0F - 1.0F) * 0.06F;
      hf[var0] = ed.nextFloat() * (float) (Math.PI * 2);
      hg[var0] = 0.6F + ed.nextFloat() * 2.4F;
      hh[var0] = 0.012F + ed.nextFloat() * ed.nextFloat() * 0.024F;
      hi[var0] = ed.nextFloat();
   }

   private static void ag(
      VertexConsumer var0, MatrixStack.Entry var1, Vec3d var2, float var3, double var4, float var6, float var7, float var8, float var9, float[] var10
   ) {

      double var11 = var2.x;
      double var13 = var2.y;
      double var15 = var2.z;
      if (!hj) {
         for (int var17 = 0; var17 < (-974424332 ^ -974424273); var17++) {
            af(var17, var11, var13, var15);
         }

         hj = true;
      }

      float var119 = 380.0F * (0.3F + 0.7F * ov) * (1.0F + 0.25F * var7);
      hk = hk + (var119 - hk) * (1.0F - (float)Math.exp((double)(-var3 * 1.5F)));
      int var18 = Math.min(-567320480 ^ -567320133, (int)Math.ceil((double)hk));
      float var19 = hk;
      float var20 = ow * 0.6F;
      float var21 = 0.6F + 0.35F * MathHelper.sin(var4 * 0.031);
      float var22 = MathHelper.cos((double)var21) * var20;
      float var23 = MathHelper.sin((double)var21) * var20;
      float var24 = var10[0];
      float var25 = var10[1];
      float var26 = var10[2];
      float var27 = var10[3];
      float var28 = var10[4];
      float var29 = var10[5];
      float var30 = var10[6];
      float var31 = var10[7];
      float var32 = var10[8];
      boolean var33 = or;
      float var34 = ot;
      float var35 = os;
      double var36 = 28.0;
      double var38 = 16.0;
      double var40 = 28.0;
      float var42 = 10.08F;
      float var43 = 3.92F;
      float var44 = 5.2F;
      float var45 = 2.8F;
      float var46 = (0.1F + 0.1F * oy) * (1.0F - 0.85F * var7);
      float var47 = 3.0F + 2.0F * oy;
      float var48 = 1.0F - var7 - var8 - var9;
      var48 = var48 < 0.0F ? 0.0F : var48;
      float var49 = var8 + var9;
      float var50 = ol;
      float var51 = pg;
      float var52 = pe;
      float var53 = pf;
      boolean var54 = qm;
      int var55 = qj;
      int var56 = qk;
      int[] var57 = ps;

      for (int var58 = 0; var58 < var18; var58++) {
         float var59 = hf[var58];
         float var60 = hc[var58] + var22 + 0.05F * MathHelper.sin(var4 * 0.7 + (double)var59);
         float var61 = hd[var58] * (1.0F - var7)
            - var7 * (0.04F + 0.0254648F * var59)
            + var8 * (0.05F + 0.1F * hi[var58])
            + 0.04F * MathHelper.sin(var4 * 0.5 + (double)var59 * 1.7);
         float var62 = he[var58] + var23 + 0.05F * MathHelper.cos(var4 * 0.6 + (double)var59 * 1.3);
         double var63 = gw[var58] + (double)(var60 * var3);
         double var65 = ha[var58] + (double)(var61 * var3);
         double var67 = hb[var58] + (double)(var62 * var3);
         double var69 = var63 - var11;
         double var71 = var65 - var13;
         double var73 = var67 - var15;
         if (var69 < -14.0 || var69 >= 14.0) {
            var69 -= Math.floor((var69 + 14.0) / var36) * var36;
            var63 = var11 + var69;
         }

         if (var71 < -8.0 || var71 >= 8.0) {
            var71 -= Math.floor((var71 + 8.0) / var38) * var38;
            var65 = var13 + var71;
         }

         if (var73 < -14.0 || var73 >= 14.0) {
            var73 -= Math.floor((var73 + 14.0) / var40) * var40;
            var67 = var15 + var73;
         }

         gw[var58] = var63;
         ha[var58] = var65;
         hb[var58] = var67;
         float var75 = (float)var69;
         float var76 = (float)var71;
         float var77 = (float)var73;
         float var78 = var75 * var75 + var76 * var76 + var77 * var77;
         float var79 = MathHelper.sqrt(var78);
         float var80 = var75 * var30 + var76 * var31 + var77 * var32;
         if (!(var79 < 0.4F) && !(var80 < -0.2F * var79)) {
            if (var33) {
               float var81 = 0.45F + var80 * var34;
               if (var81 < 0.0F || (var78 - var80 * var80) * var35 > var81 * var81) {
                  continue;
               }
            }

            if (var54) {
               int var121 = MathHelper.floor(var63) - var55 + 24;
               int var82 = MathHelper.floor(var67) - var56 + 24;
               if (var121 >= 0 && var82 >= 0 && var121 < 49 && var82 < 49 && var65 < (double)var57[var82 * 49 + var121]) {
                  continue;
               }
            }

            float var122 = (var79 - 0.6F) / 1.6F;
            var122 = var122 < 0.0F ? 0.0F : (var122 > 1.0F ? 1.0F : var122);
            float var124 = (MathHelper.sqrt(var75 * var75 + var77 * var77) - var42) / var43;
            var124 = var124 < 0.0F ? 0.0F : (var124 > 1.0F ? 1.0F : var124);
            float var83 = ((var76 < 0.0F ? -var76 : var76) - var44) / var45;
            var83 = var83 < 0.0F ? 0.0F : (var83 > 1.0F ? 1.0F : var83);
            float var84 = (var19 - (float)var58) / 24.0F;
            var84 = var84 < 0.0F ? 0.0F : (var84 > 1.0F ? 1.0F : var84);
            float var85 = MathHelper.sin(var4 * (double)hg[var58] + (double)var59);
            float var86 = var85 * var85;
            var86 *= var86;
            float var87 = var86 * var86;
            float var88 = var87 * var87;
            var88 *= var88;
            float var89 = 0.5F + 0.5F * var85;
            float var90 = var48 * (0.12F + 0.12F * var89 + 0.9F * var87) + var7 * (0.04F + 2.2F * var88) + var49 * (0.3F + 0.3F * var89 + 0.9F * var87);
            float var91 = var6
               * var90
               * var84
               * var122
               * var122
               * (3.0F - 2.0F * var122)
               * (1.0F - var124 * var124 * (3.0F - 2.0F * var124))
               * (1.0F - var83 * var83 * (3.0F - 2.0F * var83));
            if (var51 > 0.0F) {
               float var92 = (var79 - var52) * var53;
               var91 *= var92 < 0.0F ? 1.0F : (var92 > 1.0F ? 0.0F : 1.0F - var92);
            }

            if (!(var91 < 0.01F)) {
               if (var91 > 1.0F) {
                  var91 = 1.0F;
               }

               float var130 = hi[var58];
               int var93;
               int var94;
               int var95;
               if (var130 < 0.35F) {
                  var93 = 213372535 ^ 213372637;
                  var94 = -737267060 ^ -737267189;
                  var95 = -1245815208 ^ -1245815129;
               } else if (var130 < 0.65F) {
                  var93 = 125;
                  var94 = -760703707 ^ -760703616;
                  var95 = 1656546509 ^ 1656546354;
               } else if (var130 < 0.82F) {
                  var93 = 1078282642 ^ 1078282605;
                  var94 = 603771864 ^ 603771726;
                  var95 = -394811363 ^ -394811140;
               } else {
                  var93 = -371824473 ^ -371824564;
                  var94 = 1661446522 ^ 1661446548;
                  var95 = -1885940856 ^ -1885940873;
               }

               int var96;
               int var97;
               int var98;
               if (var130 < 0.45F) {
                  var96 = 670065596 ^ 670065456;
                  var97 = -622427940 ^ -622428125;
                  var98 = 1903519815 ^ 1903519887;
               } else if (var130 < 0.8F) {
                  var96 = -2085695089 ^ -2085695207;
                  var97 = 252828033 ^ 252828007;
                  var98 = -1128467076 ^ -1128467069;
               } else {
                  var96 = -145176087 ^ -145176318;
                  var97 = -1178073977 ^ -1178073989;
                  var98 = 326982940 ^ 326983139;
               }

               int var99;
               int var100;
               int var101;
               if (var130 < 0.38F) {
                  var99 = -875419104 ^ -875418913;
                  var100 = 72;
                  var101 = -1740602417 ^ -1740602511;
               } else if (var130 < 0.66F) {
                  var99 = 70;
                  var100 = 1920644815 ^ 1920644651;
                  var101 = 647705670 ^ 647705785;
               } else if (var130 < 0.86F) {
                  var99 = -1298335502 ^ -1298335650;
                  var100 = 96;
                  var101 = -685842623 ^ -685842498;
               } else {
                  var99 = 1657713867 ^ 1657713716;
                  var100 = 777728567 ^ 777728761;
                  var101 = -272578868 ^ -272579014;
               }

               int var102;
               int var103;
               int var104;
               if (var130 < 0.55F) {
                  var102 = 24;
                  var103 = 553804400 ^ 553804528;
                  var104 = 1504405104 ^ 1504405135;
               } else if (var130 < 0.85F) {
                  var102 = 64;
                  var103 = -1690456891 ^ -1690457071;
                  var104 = 1297250485 ^ 1297250378;
               } else {
                  var102 = 92607883 ^ 92607797;
                  var103 = 1137718833 ^ 1137719001;
                  var104 = -130854515 ^ -130854542;
               }

               int var105 = (int)((float)var93 * var48 + (float)var96 * var7 + (float)var99 * var8 + (float)var102 * var9);
               int var106 = (int)((float)var94 * var48 + (float)var97 * var7 + (float)var100 * var8 + (float)var103 * var9);
               int var107 = (int)((float)var95 * var48 + (float)var98 * var7 + (float)var101 * var8 + (float)var104 * var9);
               float var108 = hh[var58] * (1.0F + 0.6F * var87);
               float var109 = var108 * var47;
               int var110 = (int)(var91 * var46 * 255.0F);
               if (var110 > 0) {
                  float var111 = var24 * var109;
                  float var112 = var25 * var109;
                  float var113 = var26 * var109;
                  float var114 = var27 * var109;
                  float var115 = var28 * var109;
                  float var116 = var29 * var109;
                  if (ou) {
                     var0.vertex(var75 - var111 - var114, var76 - var112 - var115, var77 - var113 - var116)
                        .texture(0.0F, 1.0F)
                        .color(var105, var106, var107, var110);
                     var0.vertex(var75 - var111 + var114, var76 - var112 + var115, var77 - var113 + var116)
                        .texture(0.0F, 0.0F)
                        .color(var105, var106, var107, var110);
                     var0.vertex(var75 + var111 + var114, var76 + var112 + var115, var77 + var113 + var116)
                        .texture(1.0F, 0.0F)
                        .color(var105, var106, var107, var110);
                     var0.vertex(var75 + var111 - var114, var76 + var112 - var115, var77 + var113 - var116)
                        .texture(1.0F, 1.0F)
                        .color(var105, var106, var107, var110);
                  } else {
                     var0.vertex(var1, var75 - var111 - var114, var76 - var112 - var115, var77 - var113 - var116)
                        .texture(0.0F, 1.0F)
                        .color(var105, var106, var107, var110);
                     var0.vertex(var1, var75 - var111 + var114, var76 - var112 + var115, var77 - var113 + var116)
                        .texture(0.0F, 0.0F)
                        .color(var105, var106, var107, var110);
                     var0.vertex(var1, var75 + var111 + var114, var76 + var112 + var115, var77 + var113 + var116)
                        .texture(1.0F, 0.0F)
                        .color(var105, var106, var107, var110);
                     var0.vertex(var1, var75 + var111 - var114, var76 + var112 - var115, var77 + var113 - var116)
                        .texture(1.0F, 1.0F)
                        .color(var105, var106, var107, var110);
                  }
               }

               float var131 = 0.5F * var79 / var50;
               if (var108 < var131) {
                  var91 *= var108 / var131;
                  var108 = var131;
               }

               int var132 = (int)(var91 * 255.0F);
               float var133 = var24 * var108;
               float var134 = var25 * var108;
               float var135 = var26 * var108;
               float var136 = var27 * var108;
               float var117 = var28 * var108;
               float var118 = var29 * var108;
               if (ou) {
                  var0.vertex(var75 - var133 - var136, var76 - var134 - var117, var77 - var135 - var118)
                     .texture(0.0F, 1.0F)
                     .color(var105, var106, var107, var132);
                  var0.vertex(var75 - var133 + var136, var76 - var134 + var117, var77 - var135 + var118)
                     .texture(0.0F, 0.0F)
                     .color(var105, var106, var107, var132);
                  var0.vertex(var75 + var133 + var136, var76 + var134 + var117, var77 + var135 + var118)
                     .texture(1.0F, 0.0F)
                     .color(var105, var106, var107, var132);
                  var0.vertex(var75 + var133 - var136, var76 + var134 - var117, var77 + var135 - var118)
                     .texture(1.0F, 1.0F)
                     .color(var105, var106, var107, var132);
               } else {
                  var0.vertex(var1, var75 - var133 - var136, var76 - var134 - var117, var77 - var135 - var118)
                     .texture(0.0F, 1.0F)
                     .color(var105, var106, var107, var132);
                  var0.vertex(var1, var75 - var133 + var136, var76 - var134 + var117, var77 - var135 + var118)
                     .texture(0.0F, 0.0F)
                     .color(var105, var106, var107, var132);
                  var0.vertex(var1, var75 + var133 + var136, var76 + var134 + var117, var77 + var135 + var118)
                     .texture(1.0F, 0.0F)
                     .color(var105, var106, var107, var132);
                  var0.vertex(var1, var75 + var133 - var136, var76 + var134 - var117, var77 + var135 - var118)
                     .texture(1.0F, 1.0F)
                     .color(var105, var106, var107, var132);
               }
            }
         }
      }
   }

   private static void ah(int var0, ClientWorld var1, double var2, double var4, double var6, boolean var8) {

      double var9 = ed.nextDouble() * Math.PI * 2.0;
      double var11 = 2.5 + 17.5 * Math.sqrt(ed.nextDouble());
      double var13 = var2 + Math.cos(var9) * var11;
      double var15 = var6 + Math.sin(var9) * var11;
      double var17 = var4 - 1.6;
      if (var1 != null) {
         int var19 = var1.getTopY(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MathHelper.floor(var13), MathHelper.floor(var15));
         if (var19 > var1.getBottomY() && (double)var19 - var4 < 20.0 && var4 - (double)var19 < 20.0) {
            var17 = (double)var19;
         }
      }

      hm[var0] = var13;
      double var21 = ed.nextDouble();
      hn[var0] = var17 + 0.2 + 1.6 * var21 * var21;
      ho[var0] = var15;
      hp[var0] = ed.nextFloat() * (float) (Math.PI * 2);
      hq[var0] = 0.22F + ed.nextFloat() * 0.3F;
      hr[var0] = 0.35F + ed.nextFloat() * 0.45F;
      hs[var0] = 0.25F + ed.nextFloat() * 0.35F;
      ht[var0] = 0.5F + ed.nextFloat() * 1.3F;
      hu[var0] = 4.0F + ed.nextFloat() * 3.5F;
      hv[var0] = ed.nextFloat() * hu[var0];
      hw[var0] = 14.0F + ed.nextFloat() * 18.0F;
      hx[var0] = var8 ? ed.nextFloat() * hw[var0] : 0.0F;
      hy[var0] = 0.009F + ed.nextFloat() * 0.006F;
      hz[var0] = ed.nextFloat();
   }

   private static void ai(VertexConsumer var0, MatrixStack.Entry var1, ClientWorld var2, Vec3d var3, float var4, double var5, float var7, float[] var8) {

      double var9 = var3.x;
      double var11 = var3.y;
      double var13 = var3.z;
      if (!ia) {
         for (int var15 = 0; var15 < (-1454899300 ^ -1454899492); var15++) {
            ah(var15, var2, var9, var11, var13, true);
         }

         ia = true;
      }

      float var104 = 320.0F * (0.25F + 0.75F * ov);
      ib = ib + (var104 - ib) * (1.0F - (float)Math.exp((double)(-var4 * 1.5F)));
      int var16 = Math.min(635151721 ^ 635151401, (int)Math.ceil((double)ib));
      float var17 = ib;
      float var18 = ow * 0.35F;
      float var19 = 0.6F + 0.35F * MathHelper.sin(var5 * 0.031);
      float var20 = MathHelper.cos((double)var19) * var18;
      float var21 = MathHelper.sin((double)var19) * var18;
      float var22 = pa;
      float var23 = 0.6F + 0.4F * (1.0F - (var22 < 0.0F ? 0.0F : (var22 > 1.0F ? 1.0F : var22)));
      float var24 = oy;
      float var25 = (0.16F + 0.3F * var24) * var23;
      float var26 = (0.75F + 0.25F * var24) * var23;
      float var27 = 5.0F + 3.0F * var24;
      float var28 = var8[0];
      float var29 = var8[1];
      float var30 = var8[2];
      float var31 = var8[3];
      float var32 = var8[4];
      float var33 = var8[5];
      float var34 = var8[6];
      float var35 = var8[7];
      float var36 = var8[8];
      boolean var37 = or;
      float var38 = ot;
      float var39 = os;
      float var40 = ol;
      float var41 = pg;
      float var42 = pe;
      float var43 = pf;

      for (int var44 = 0; var44 < var16; var44++) {
         float var45 = hx[var44] + var4;
         double var46 = hm[var44] + (double)(var20 * var4);
         double var48 = hn[var44];
         double var50 = ho[var44] + (double)(var21 * var4);
         double var52 = var46 - var9;
         double var54 = var50 - var13;
         if (var45 >= hw[var44] || var52 * var52 + var54 * var54 > 676.0 || var48 - var11 > 22.0 || var11 - var48 > 22.0) {
            ah(var44, var2, var9, var11, var13, false);
            var45 = 0.0F;
            var46 = hm[var44];
            var48 = hn[var44];
            var50 = ho[var44];
         }

         hx[var44] = var45;
         hm[var44] = var46;
         ho[var44] = var50;
         float var56 = hp[var44];
         float var57 = ht[var44];
         float var58 = hq[var44];
         float var59 = hr[var44];
         float var60 = hs[var44];
         double var61 = var46
            + (double)(var57 * MathHelper.sin(var5 * (double)var58 + (double)var56))
            + (double)(0.35F * var57 * MathHelper.sin(var5 * (double)var59 * 2.3 + (double)var56 * 1.7));
         double var63 = var50
            + (double)(var57 * MathHelper.cos(var5 * (double)var60 + (double)var56 * 1.3))
            + (double)(0.35F * var57 * MathHelper.cos(var5 * (double)var59 * 1.9 + (double)var56));
         double var65 = var48
            + (double)(0.45F * MathHelper.sin(var5 * (double)var59 + (double)var56 * 2.1))
            + (double)(0.18F * MathHelper.sin(var5 * 1.7 + (double)var56));
         float var67 = (float)(var61 - var9);
         float var68 = (float)(var65 - var11);
         float var69 = (float)(var63 - var13);
         float var70 = var67 * var67 + var68 * var68 + var69 * var69;
         float var71 = MathHelper.sqrt(var70);
         float var72 = var67 * var34 + var68 * var35 + var69 * var36;
         if (!(var71 < 0.35F) && !(var72 < -0.3F * var71)) {
            if (var37) {
               float var73 = 0.7F + var72 * var38;
               if (var73 < 0.0F || (var70 - var72 * var72) * var39 > var73 * var73) {
                  continue;
               }
            }

            float var106 = hu[var44];
            float var74 = (float)((var5 + (double)hv[var44]) % (double)var106);
            float var75 = var74 < 0.1F ? var74 * 10.0F : (var74 < 0.25F ? 1.0F : (var74 < 0.6F ? 1.0F - (var74 - 0.25F) / 0.35F : 0.0F));
            var75 = var75 * var75 * (3.0F - 2.0F * var75);
            float var76 = 0.015F + 0.985F * var75;
            float var77 = var45 / hw[var44];
            float var78 = var77 / 0.1F;
            var78 = var78 > 1.0F ? 1.0F : var78;
            float var79 = (1.0F - var77) / 0.1F;
            var79 = var79 < 0.0F ? 0.0F : (var79 > 1.0F ? 1.0F : var79);
            float var80 = (var71 - 0.4F) / 1.4F;
            var80 = var80 < 0.0F ? 0.0F : (var80 > 1.0F ? 1.0F : var80);
            float var81 = (var71 - 17.0F) / 6.0F;
            var81 = var81 < 0.0F ? 0.0F : (var81 > 1.0F ? 1.0F : var81);
            float var82 = (var17 - (float)var44) / 16.0F;
            var82 = var82 < 0.0F ? 0.0F : (var82 > 1.0F ? 1.0F : var82);
            float var83 = var7
               * var76
               * var82
               * var78
               * var78
               * (3.0F - 2.0F * var78)
               * var79
               * var79
               * (3.0F - 2.0F * var79)
               * var80
               * var80
               * (3.0F - 2.0F * var80)
               * (1.0F - var81 * var81 * (3.0F - 2.0F * var81));
            if (var41 > 0.0F) {
               float var84 = (var71 - var42) * var43;
               var83 *= var84 < 0.0F ? 1.0F : (var84 > 1.0F ? 0.0F : 1.0F - var84);
            }

            if (!(var83 < 0.01F)) {
               if (var83 > 1.0F) {
                  var83 = 1.0F;
               }

               boolean var113 = hz[var44] >= 0.95F;
               int var85 = var113 ? 482295737 ^ 482295622 : 950593719 ^ 950593651;
               int var86 = var113 ? 470786054 ^ 470786248 : 842917287 ^ 842917208;
               int var87 = var113 ? 90 : 96;
               float var88 = hy[var44] * (0.8F + 0.35F * var75);
               float var89 = 0.05F + hy[var44] * var27 * (0.8F + 0.35F * var75);
               float var90 = 0.8F * var71 / var40;
               float var91 = 1.0F;
               if (var88 < var90) {
                  var91 = var88 / var90;
                  var88 = var90;
               }

               var68 += 0.22F * var75;
               float var92 = var71 * 0.22F;
               if (var89 > var92) {
                  var89 = var92;
               }

               int var93 = (int)(var83 * var25 * 255.0F);
               if (var93 > 0) {
                  float var94 = var28 * var89;
                  float var95 = var29 * var89;
                  float var96 = var30 * var89;
                  float var97 = var31 * var89;
                  float var98 = var32 * var89;
                  float var99 = var33 * var89;
                  if (ou) {
                     var0.vertex(var67 - var94 - var97, var68 - var95 - var98, var69 - var96 - var99)
                        .texture(0.0F, 1.0F)
                        .color(var85, var86, var87, var93);
                     var0.vertex(var67 - var94 + var97, var68 - var95 + var98, var69 - var96 + var99)
                        .texture(0.0F, 0.0F)
                        .color(var85, var86, var87, var93);
                     var0.vertex(var67 + var94 + var97, var68 + var95 + var98, var69 + var96 + var99)
                        .texture(1.0F, 0.0F)
                        .color(var85, var86, var87, var93);
                     var0.vertex(var67 + var94 - var97, var68 + var95 - var98, var69 + var96 - var99)
                        .texture(1.0F, 1.0F)
                        .color(var85, var86, var87, var93);
                  } else {
                     var0.vertex(var1, var67 - var94 - var97, var68 - var95 - var98, var69 - var96 - var99)
                        .texture(0.0F, 1.0F)
                        .color(var85, var86, var87, var93);
                     var0.vertex(var1, var67 - var94 + var97, var68 - var95 + var98, var69 - var96 + var99)
                        .texture(0.0F, 0.0F)
                        .color(var85, var86, var87, var93);
                     var0.vertex(var1, var67 + var94 + var97, var68 + var95 + var98, var69 + var96 + var99)
                        .texture(1.0F, 0.0F)
                        .color(var85, var86, var87, var93);
                     var0.vertex(var1, var67 + var94 - var97, var68 + var95 - var98, var69 + var96 - var99)
                        .texture(1.0F, 1.0F)
                        .color(var85, var86, var87, var93);
                  }
               }

               float var114 = var83 * var26 * (var91 * 1.6F > 1.0F ? 1.0F : var91 * 1.6F);
               int var115 = (int)((var114 > 1.0F ? 1.0F : var114) * 255.0F);
               int var116 = Math.min(-2094042070 ^ -2094041899, var85 + 40);
               int var117 = Math.min(2130573961 ^ 2130573942, var87 + 90);
               float var118 = var28 * var88;
               float var119 = var29 * var88;
               float var100 = var30 * var88;
               float var101 = var31 * var88;
               float var102 = var32 * var88;
               float var103 = var33 * var88;
               if (ou) {
                  var0.vertex(var67 - var118 - var101, var68 - var119 - var102, var69 - var100 - var103)
                     .texture(0.0F, 1.0F)
                     .color(var116, -1266068930 ^ -1266068799, var117, var115);
                  var0.vertex(var67 - var118 + var101, var68 - var119 + var102, var69 - var100 + var103)
                     .texture(0.0F, 0.0F)
                     .color(var116, 1358331390 ^ 1358331137, var117, var115);
                  var0.vertex(var67 + var118 + var101, var68 + var119 + var102, var69 + var100 + var103)
                     .texture(1.0F, 0.0F)
                     .color(var116, 1597685818 ^ 1597685957, var117, var115);
                  var0.vertex(var67 + var118 - var101, var68 + var119 - var102, var69 + var100 - var103)
                     .texture(1.0F, 1.0F)
                     .color(var116, 1475601334 ^ 1475601225, var117, var115);
               } else {
                  var0.vertex(var1, var67 - var118 - var101, var68 - var119 - var102, var69 - var100 - var103)
                     .texture(0.0F, 1.0F)
                     .color(var116, -1989300463 ^ -1989300242, var117, var115);
                  var0.vertex(var1, var67 - var118 + var101, var68 - var119 + var102, var69 - var100 + var103)
                     .texture(0.0F, 0.0F)
                     .color(var116, -1962955294 ^ -1962955491, var117, var115);
                  var0.vertex(var1, var67 + var118 + var101, var68 + var119 + var102, var69 + var100 + var103)
                     .texture(1.0F, 0.0F)
                     .color(var116, 1389346233 ^ 1389346118, var117, var115);
                  var0.vertex(var1, var67 + var118 - var101, var68 + var119 - var102, var69 + var100 - var103)
                     .texture(1.0F, 1.0F)
                     .color(var116, -661331662 ^ -661331507, var117, var115);
               }
            }
         }
      }
   }

   private static void aj(int var0, double var1, double var3, double var5) {

      ig[var0] = var1 + (ed.nextDouble() * 2.0 - 1.0) * 20.0;
      ih[var0] = var3 + (ed.nextDouble() * 2.0 - 1.0) * 11.0;
      ii[var0] = var5 + (ed.nextDouble() * 2.0 - 1.0) * 20.0;
      ij[var0] = 0.65F + ed.nextFloat() * 0.7F;
      ik[var0] = 0.012F + ed.nextFloat() * 0.022F;
      il[var0] = 0.78F + ed.nextFloat() * 0.22F;
      float var7 = ed.nextFloat() * (float) (Math.PI * 2);
      im[var0] = var7;
      float var8 = -0.32F * (float)Math.log((double)(1.0F - 0.92F * var7 / (float) (Math.PI * 2))) + 0.04F;
      in[var0] = var8;
      io[var0] = (float) Math.PI / (0.35F + 0.9F * (float)Math.sqrt((double)var8));
      ip[var0] = 0.45F + 0.55F * var8 / (var8 + 0.6F);
   }

   private static void ak(VertexConsumer var0, MatrixStack.Entry var1, Vec3d var2, float var3, double var4, float var6, float[] var7) {

      double var8 = var2.x;
      double var10 = var2.y;
      double var12 = var2.z;
      if (!it) {
         for (int var14 = 0; var14 < (-1663865528 ^ -1663866952); var14++) {
            aj(var14, var8, var10, var12);
         }

         it = true;
         iw = 2;
      }

      float var138 = 2800.0F * Math.max(0.05F, ov) * 0.75F;
      iu = iu + (var138 - iu) * (1.0F - (float)Math.exp((double)(-var3 * 1.5F)));
      int var15 = Math.min(-1544578449 ^ -1544580961, (int)Math.ceil((double)iu));
      float var16 = iu;
      float var17 = ox;
      float var18 = (0.3F + 0.7F * ow) * (6.0F + 10.0F * var17);
      float var19 = 0.6F + 0.35F * MathHelper.sin(var4 * 0.031);
      float var20 = MathHelper.cos((double)var19);
      float var21 = MathHelper.sin((double)var19);
      float var22 = oz;
      float var23 = 0.28F + 0.72F * (var22 < 0.0F ? 0.0F : (var22 > 1.0F ? 1.0F : var22));
      float var24 = var7[0];
      float var25 = var7[1];
      float var26 = var7[2];
      float var27 = var7[3];
      float var28 = var7[4];
      float var29 = var7[5];
      float var30 = var7[6];
      float var31 = var7[7];
      float var32 = var7[8];
      float var33 = pl;
      float var34 = pm;
      float var35 = pn;
      float var36 = ol;
      float var37 = om;
      float var38 = on;
      float var39 = pg;
      float var40 = pe;
      float var41 = pf;
      float var42 = pb;
      float var43 = pc;
      float var44 = pd;
      boolean var45 = qm;
      int var46 = qj;
      int var47 = qk;
      int[] var48 = ps;
      boolean var49 = or;
      boolean var50 = ou;
      float var51 = ot;
      float var52 = os;
      double var53 = 40.0;
      double var55 = 22.0;
      double var57 = 40.0;
      float var59 = 11.0F;
      float var60 = 9.0F;
      float var61 = 6.6000004F;
      float var62 = 4.4F;
      float var63 = 0.22F * var18;
      double var64 = (double)(var20 * var18) * 0.8 * var4;
      double var66 = (double)(var21 * var18) * 0.8 * var4;
      double var68 = 0.064 * (double)var18 * var4;
      double var70 = 0.1 * var4;
      float var72 = (float)(var4 * 0.13 % 6283.185307179586);
      float var73 = (float)(var4 * 0.09 % 6283.185307179586 + 1.3);
      float var74 = (float)(var4 * 0.11 % 6283.185307179586 + 2.1);
      int var75 = iv & 7;
      byte var76 = 8;
      iv++;
      if (iw > 0) {
         iw--;
         var75 = 0;
         var76 = 1;
      }

      for (int var77 = var75; var77 < var15; var77 += var76) {
         boolean var78 = var45 && var77 % 10 < 7;
         double var79 = ig[var77];
         double var81 = ih[var77];
         double var83 = ii[var77];
         float var85 = (float)(var79 * (double)var20 + var83 * (double)var21);
         float var86 = (float)(var83 * (double)var20 - var79 * (double)var21);
         float var87 = var17
            + 0.4F * MathHelper.sin((double)(0.08F * var85) - var68 + (double)(1.4F * MathHelper.sin((double)(0.05F * var86) + var70)));
         var87 = var87 < 0.0F ? 0.0F : (var87 > 1.0F ? 1.0F : var87);
         float var88 = (float)(var79 - var64);
         float var89 = (float)var81;
         float var90 = (float)(var83 - var66);
         float var91 = MathHelper.sin((double)(0.25F * var90 + var72))
            + MathHelper.cos((double)(0.25F * var89 + var73))
            + 0.5F * (MathHelper.sin((double)(0.8F * var90 + var74)) + MathHelper.cos((double)(0.8F * var89 + var72)));
         float var92 = MathHelper.sin((double)(0.25F * var88 + var74))
            + MathHelper.cos((double)(0.25F * var90 + var72))
            + 0.5F * (MathHelper.sin((double)(0.8F * var88 + var73)) + MathHelper.cos((double)(0.8F * var90 + var74)));
         float var93 = MathHelper.sin((double)(0.25F * var89 + var73))
            + MathHelper.cos((double)(0.25F * var88 + var74))
            + 0.5F * (MathHelper.sin((double)(0.8F * var89 + var72)) + MathHelper.cos((double)(0.8F * var88 + var73)));
         float var94 = var18 * (0.55F + 0.45F * var87) * ij[var77] * (var78 ? ip[var77] : 1.0F);
         float var95 = var78 ? 0.35F * var63 : 0.5F * var63;
         iq[var77] = var20 * var94 + var95 * var91;
         ir[var77] = 0.3F * var63 * var92;
         is[var77] = var21 * var94 + var95 * var93;
      }

      double var139 = var10 - 1.62;

      for (int var140 = 0; var140 < var15; var140++) {
         float var80 = im[var140];
         boolean var141 = var45 && var140 % 10 < 7;
         double var82 = ig[var140];
         double var84 = ih[var140];
         double var142 = ii[var140];
         float var144 = iq[var140];
         float var145 = is[var140];
         double var147 = var82 + (double)(var144 * var3);
         double var148 = var142 + (double)(var145 * var3);
         float var146;
         double var149;
         if (var141) {
            float var97 = MathHelper.sin((var4 + (double)var80 * 3.0) * (double)io[var140]);
            var97 = var97 < 0.0F ? -var97 : var97;
            int var98 = MathHelper.floor(var147) - var46 + 24;
            int var99 = MathHelper.floor(var148) - var47 + 24;
            double var100 = var98 >= 0 && var99 >= 0 && var98 < 49 && var99 < 49 ? (double)var48[var99 * 49 + var98] : var139;
            var149 = var100 + 0.02 + (double)(in[var140] * var97);
            var146 = (float)(var149 - var84) / (var3 > 0.001F ? var3 : 0.001F);
            if (var146 > 6.0F || var146 < -6.0F) {
               var146 = 0.0F;
            }
         } else {
            var146 = (MathHelper.sin(var4 * 1.3 + (double)var80 * 2.0) * 0.5F - 0.15F) * (0.4F + var17) + ir[var140];
            var149 = var84 + (double)(var146 * var3);
         }

         double var151 = var147 - var8;
         double var152 = var149 - var10;
         double var101 = var148 - var12;
         if (var151 < -20.0 || var151 >= 20.0) {
            var151 -= Math.floor((var151 + 20.0) / var53) * var53;
            var147 = var8 + var151;
         }

         if (var101 < -20.0 || var101 >= 20.0) {
            var101 -= Math.floor((var101 + 20.0) / var57) * var57;
            var148 = var12 + var101;
         }

         boolean var103 = var152 < -11.0 || var152 >= 11.0;
         if (var103 && !var141) {
            var152 -= Math.floor((var152 + 11.0) / var55) * var55;
            var149 = var10 + var152;
         }

         ig[var140] = var147;
         ih[var140] = var149;
         ii[var140] = var148;
         if (!var103 || !var141) {
            float var104 = (float)var151;
            float var105 = (float)var152;
            float var106 = (float)var101;
            float var107 = var104 * var104 + var105 * var105 + var106 * var106;
            if (!(var107 < 0.09F)) {
               float var108 = MathHelper.sqrt(var107);
               float var109 = var104 * var30 + var105 * var31 + var106 * var32;
               if (!(var109 < -0.3F * var108)) {
                  if (var49) {
                     float var110 = 0.6F + var109 * var51;
                     if (var110 < 0.0F || (var107 - var109 * var109) * var52 > var110 * var110) {
                        continue;
                     }
                  }

                  if (var45 && !var141) {
                     int var153 = MathHelper.floor(var147) - var46 + 24;
                     int var111 = MathHelper.floor(var148) - var47 + 24;
                     if (var153 >= 0 && var111 >= 0 && var153 < 49 && var111 < 49 && var149 < (double)var48[var111 * 49 + var153]) {
                        continue;
                     }
                  }

                  float var154 = (var108 - 0.4F) / 1.2F;
                  var154 = var154 < 0.0F ? 0.0F : (var154 > 1.0F ? 1.0F : var154);
                  float var156 = (var108 - var59) / var60;
                  var156 = var156 < 0.0F ? 0.0F : (var156 > 1.0F ? 1.0F : var156);
                  float var112 = var105 < 0.0F ? -var105 : var105;
                  float var113 = var141 ? 0.0F : (var112 - var61) / var62;
                  var113 = var113 < 0.0F ? 0.0F : (var113 > 1.0F ? 1.0F : var113);
                  float var114 = (var16 - (float)var140) / 64.0F;
                  var114 = var114 < 0.0F ? 0.0F : (var114 > 1.0F ? 1.0F : var114);
                  float var115 = (var141 ? 0.85F : 0.3F)
                     * var6
                     * var154
                     * var154
                     * (3.0F - 2.0F * var154)
                     * (1.0F - var156 * var156 * (3.0F - 2.0F * var156))
                     * (1.0F - var113 * var113 * (3.0F - 2.0F * var113))
                     * var114;
                  if (!(var115 < 0.012F)) {
                     float var116 = ik[var140] * (var141 ? 1.0F : 0.6F);
                     float var117 = 0.6F * var108 / var36;
                     if (var116 < var117) {
                        var115 *= var116 / var117;
                        var116 = var117;
                     }

                     float var118 = var27 * var116;
                     float var119 = var28 * var116;
                     float var120 = var29 * var116;
                     float var121 = var24 * var116;
                     float var122 = var25 * var116;
                     float var123 = var26 * var116;
                     float var124 = var144 - var33;
                     float var125 = var146 - var34;
                     float var126 = var145 - var35;
                     float var127 = var124 * var124 + var125 * var125 + var126 * var126;
                     if (var127 > 1.0F) {
                        float var128 = MathHelper.sqrt(var127);
                        float var129 = var124 / var128;
                        float var130 = var125 / var128;
                        float var131 = var126 / var128;
                        float var132 = var130 * var106 - var131 * var105;
                        float var133 = var131 * var104 - var129 * var106;
                        float var134 = var129 * var105 - var130 * var104;
                        float var135 = MathHelper.sqrt(var132 * var132 + var133 * var133 + var134 * var134);
                        if (var135 > 0.001F) {
                           float var136 = var116 + var128 * 0.01F;
                           float var137 = var116 * 0.75F / var135;
                           var115 *= (float)Math.sqrt(Math.sqrt((double)(var116 / var136)));
                           var118 = var129 * var136;
                           var119 = var130 * var136;
                           var120 = var131 * var136;
                           var121 = var132 * var137;
                           var122 = var133 * var137;
                           var123 = var134 * var137;
                        }
                     }

                     float var160 = il[var140] * var23;
                     float var161 = (var104 * var37 + var105 * var38) / var108;
                     if (var161 > 0.0F) {
                        float var162 = var161 * var161;
                        var162 *= var162;
                        var160 *= 1.0F + 0.5F * var162 * var162;
                     }

                     float var164 = 188.0F * var160;
                     float var165 = 142.0F * var160;
                     float var166 = 88.0F * var160;
                     if (var39 > 0.0F) {
                        float var167 = (var108 - var40) * var41;
                        var167 = var167 < 0.0F ? 0.0F : (var167 > 1.0F ? 1.0F : var167);
                        var164 += (var42 - var164) * var167;
                        var165 += (var43 - var165) * var167;
                        var166 += (var44 - var166) * var167;
                     }

                     int var169 = (int)(var164 > 255.0F ? 255.0F : var164);
                     int var170 = (int)(var165 > 255.0F ? 255.0F : var165);
                     int var171 = (int)(var166 > 255.0F ? 255.0F : var166);
                     int var172 = (int)((var115 > 1.0F ? 1.0F : var115) * 255.0F);
                     if (var50) {
                        var0.vertex(var104 - var121 - var118, var105 - var122 - var119, var106 - var123 - var120)
                           .texture(0.0F, 1.0F)
                           .color(var169, var170, var171, var172);
                        var0.vertex(var104 - var121 + var118, var105 - var122 + var119, var106 - var123 + var120)
                           .texture(0.0F, 0.0F)
                           .color(var169, var170, var171, var172);
                        var0.vertex(var104 + var121 + var118, var105 + var122 + var119, var106 + var123 + var120)
                           .texture(1.0F, 0.0F)
                           .color(var169, var170, var171, var172);
                        var0.vertex(var104 + var121 - var118, var105 + var122 - var119, var106 + var123 - var120)
                           .texture(1.0F, 1.0F)
                           .color(var169, var170, var171, var172);
                     } else {
                        var0.vertex(var1, var104 - var121 - var118, var105 - var122 - var119, var106 - var123 - var120)
                           .texture(0.0F, 1.0F)
                           .color(var169, var170, var171, var172);
                        var0.vertex(var1, var104 - var121 + var118, var105 - var122 + var119, var106 - var123 + var120)
                           .texture(0.0F, 0.0F)
                           .color(var169, var170, var171, var172);
                        var0.vertex(var1, var104 + var121 + var118, var105 + var122 + var119, var106 + var123 + var120)
                           .texture(1.0F, 0.0F)
                           .color(var169, var170, var171, var172);
                        var0.vertex(var1, var104 + var121 - var118, var105 + var122 - var119, var106 + var123 - var120)
                           .texture(1.0F, 1.0F)
                           .color(var169, var170, var171, var172);
                     }
                  }
               }
            }
         }
      }
   }

   private static void al(int var0, double var1, double var3, double var5) {

      jb[var0] = var1 + (ed.nextDouble() * 2.0 - 1.0) * 26.0;
      jc[var0] = var3 + (ed.nextDouble() * 2.0 - 1.0) * 9.0;
      jd[var0] = var5 + (ed.nextDouble() * 2.0 - 1.0) * 26.0;
      je[var0] = 2.5F + ed.nextFloat() * 4.5F;
      jf[var0] = 0.55F + ed.nextFloat() * 0.35F;
      jg[var0] = ed.nextFloat() * (float) (Math.PI * 2);
      jh[var0] = 0.8F + ed.nextFloat() * 0.2F;
   }

   private static void am(VertexConsumer var0, MatrixStack.Entry var1, Vec3d var2, float var3, double var4, float var6, float[] var7, boolean var8) {

      double var9 = var2.x;
      double var11 = var2.y;
      double var13 = var2.z;
      if (!ji) {
         for (int var15 = 0; var15 < 40; var15++) {
            al(var15, var9, var11, var13);
         }

         ji = true;
      }

      float var99 = ox;
      float var16 = (0.3F + 0.7F * ow) * (6.0F + 10.0F * var99);
      float var17 = 0.6F + 0.35F * MathHelper.sin(var4 * 0.031);
      float var18 = MathHelper.cos((double)var17);
      float var19 = MathHelper.sin((double)var17);
      float var20 = oz;
      float var21 = 0.3F + 0.7F * (var20 < 0.0F ? 0.0F : (var20 > 1.0F ? 1.0F : var20));
      float var22 = var7[0];
      float var23 = var7[1];
      float var24 = var7[2];
      float var25 = var7[3];
      float var26 = var7[4];
      float var27 = var7[5];
      float var28 = var7[6];
      float var29 = var7[7];
      float var30 = var7[8];
      double var31 = 52.0;
      double var33 = 52.0;
      float var35 = 0.6F + 0.4F * var99;
      float var36 = ol;
      float var37 = om;
      float var38 = on;
      float var39 = pg;
      float var40 = pe;
      float var41 = pf;
      float var42 = pb;
      float var43 = pc;
      float var44 = pd;
      boolean var45 = qm;
      int var46 = qj;
      int var47 = qk;
      int[] var48 = ps;
      float var49 = 1.0F - (float)Math.exp((double)(-var3 * 1.5F));

      for (int var50 = 0; var50 < 40; var50++) {
         float var51 = jg[var50];
         float var52 = var16 * jf[var50];
         double var53 = jb[var50] + (double)(var18 * var52 * var3);
         double var55 = jd[var50] + (double)(var19 * var52 * var3);
         double var57 = var53 - var9;
         double var59 = var55 - var13;
         if (var57 < -26.0 || var57 >= 26.0) {
            var57 -= Math.floor((var57 + 26.0) / var31) * var31;
            var53 = var9 + var57;
         }

         if (var59 < -26.0 || var59 >= 26.0) {
            var59 -= Math.floor((var59 + 26.0) / var33) * var33;
            var55 = var13 + var59;
         }

         jb[var50] = var53;
         jd[var50] = var55;
         double var61 = var11 - 1.62;
         if (var45) {
            int var63 = MathHelper.floor(var53) - var46 + 24;
            int var64 = MathHelper.floor(var55) - var47 + 24;
            if (var63 >= 0 && var64 >= 0 && var63 < 49 && var64 < 49) {
               var61 = (double)var48[var64 * 49 + var63];
            }
         }

         float var100 = var51 * 0.15915494F;
         double var101 = var61 + 0.5 + 3.5 * (double)var100 * (double)var100 + 0.4 * (double)MathHelper.sin(var4 * 0.3 + (double)var51);
         double var66 = jc[var50] + (var101 - jc[var50]) * (double)var49;
         jc[var50] = var66;
         float var68 = (float)var57;
         float var69 = (float)(var66 - var11);
         float var70 = (float)var59;
         float var71 = MathHelper.sqrt(var68 * var68 + var69 * var69 + var70 * var70);
         if (!(var71 < 0.5F) && !(var68 * var28 + var69 * var29 + var70 * var30 < -0.5F * var71)) {
            float var72 = je[var50] * (1.0F + 0.2F * MathHelper.sin(var4 * 0.25 + (double)var51));
            float var73 = (var71 - 1.0F - 0.5F * var72) * 0.25F;
            var73 = var73 < 0.0F ? 0.0F : (var73 > 1.0F ? 1.0F : var73);
            float var74 = (MathHelper.sqrt(var68 * var68 + var70 * var70) - 15.6F) / 10.400001F;
            var74 = var74 < 0.0F ? 0.0F : (var74 > 1.0F ? 1.0F : var74);
            float var75 = 0.16F * var6 * var35 * var73 * var73 * (3.0F - 2.0F * var73) * (1.0F - var74 * var74 * (3.0F - 2.0F * var74));
            if (!(var75 < 0.006F)) {
               float var76 = jh[var50] * var21;
               float var77 = (var68 * var37 + var69 * var38) / var71;
               if (var77 > 0.0F) {
                  float var78 = var77 * var77;
                  var76 *= 1.0F + 0.35F * var78 * var78;
               }

               float var104 = 214.0F * var76;
               float var79 = 172.0F * var76;
               float var80 = 114.0F * var76;
               if (var39 > 0.0F) {
                  float var81 = (var71 - var40) * var41;
                  var81 = var81 < 0.0F ? 0.0F : (var81 > 1.0F ? 1.0F : var81);
                  var104 += (var42 - var104) * var81;
                  var79 += (var43 - var79) * var81;
                  var80 += (var44 - var80) * var81;
               }

               int var106 = (int)(var104 > 255.0F ? 255.0F : var104);
               int var82 = (int)(var79 > 255.0F ? 255.0F : var79);
               int var83 = (int)(var80 > 255.0F ? 255.0F : var80);
               int var84 = (int)((var75 > 1.0F ? 1.0F : var75) * 255.0F);
               float var85 = 0.0F;
               float var86 = 0.0F;
               float var87 = 1.0F;
               float var88 = 1.0F;
               if (var8) {
                  float var89 = var72 * 2.0F * var36 / var71;
                  int var90 = var89 >= 48.0F ? 0 : (var89 >= 24.0F ? 1 : 2);
                  var85 = dq[var90];
                  var86 = ds[var90];
                  var87 = dr[var90];
                  var88 = dt[var90];
               }

               double var107 = (double)var51 + var4 * ((var50 & 1) == 0 ? 0.05 : -0.05);
               float var91 = MathHelper.cos(var107);
               float var92 = MathHelper.sin(var107);
               float var93 = (var22 * var91 + var25 * var92) * var72;
               float var94 = (var23 * var91 + var26 * var92) * var72;
               float var95 = (var24 * var91 + var27 * var92) * var72;
               float var96 = (-var22 * var92 + var25 * var91) * var72;
               float var97 = (-var23 * var92 + var26 * var91) * var72;
               float var98 = (-var24 * var92 + var27 * var91) * var72;
               if (ou) {
                  var0.vertex(var68 - var93 - var96, var69 - var94 - var97, var70 - var95 - var98)
                     .texture(var85, var88)
                     .color(var106, var82, var83, var84);
                  var0.vertex(var68 - var93 + var96, var69 - var94 + var97, var70 - var95 + var98)
                     .texture(var85, var86)
                     .color(var106, var82, var83, var84);
                  var0.vertex(var68 + var93 + var96, var69 + var94 + var97, var70 + var95 + var98)
                     .texture(var87, var86)
                     .color(var106, var82, var83, var84);
                  var0.vertex(var68 + var93 - var96, var69 + var94 - var97, var70 + var95 - var98)
                     .texture(var87, var88)
                     .color(var106, var82, var83, var84);
               } else {
                  var0.vertex(var1, var68 - var93 - var96, var69 - var94 - var97, var70 - var95 - var98)
                     .texture(var85, var88)
                     .color(var106, var82, var83, var84);
                  var0.vertex(var1, var68 - var93 + var96, var69 - var94 + var97, var70 - var95 + var98)
                     .texture(var85, var86)
                     .color(var106, var82, var83, var84);
                  var0.vertex(var1, var68 + var93 + var96, var69 + var94 + var97, var70 + var95 + var98)
                     .texture(var87, var86)
                     .color(var106, var82, var83, var84);
                  var0.vertex(var1, var68 + var93 - var96, var69 + var94 - var97, var70 + var95 - var98)
                     .texture(var87, var88)
                     .color(var106, var82, var83, var84);
               }
            }
         }
      }
   }

   private static void an(int var0, double var1, double var3, double var5) {

      jn[var0] = var1 + (ed.nextDouble() * 2.0 - 1.0) * 18.0;
      jo[var0] = var3 + (ed.nextDouble() * 2.0 - 1.0) * 12.0;
      jp[var0] = var5 + (ed.nextDouble() * 2.0 - 1.0) * 18.0;
      jq[var0] = 0.3F + ed.nextFloat() * 0.5F;
      jr[var0] = 0.01F + ed.nextFloat() * ed.nextFloat() * 0.03F;
      js[var0] = ed.nextFloat() * (float) (Math.PI * 2);
      jt[var0] = 1.5F + ed.nextFloat() * 3.0F;
      ju[var0] = 0.7F + ed.nextFloat() * 0.3F;
   }

   private static void ao(VertexConsumer var0, MatrixStack.Entry var1, Vec3d var2, float var3, double var4, float var6, float[] var7, boolean var8) {

      double var9 = var2.x;
      double var11 = var2.y;
      double var13 = var2.z;
      if (!jv) {
         for (int var15 = 0; var15 < (-2127164104 ^ -2127165068); var15++) {
            an(var15, var9, var11, var13);
         }

         jv = true;
      }

      float var122 = jx;
      float var16 = 1100.0F * Math.max(0.05F, ov) * (1.0F - 0.9F * var122);
      jw = jw + (var16 - jw) * (1.0F - (float)Math.exp((double)(-var3 * 1.5F)));
      int var17 = Math.min(1911098000 ^ 1911099100, (int)Math.ceil((double)jw));
      float var18 = jw;
      float var19 = ow * 1.6F;
      float var20 = 0.6F + 0.35F * MathHelper.sin(var4 * 0.031);
      float var21 = MathHelper.cos((double)var20) * var19;
      float var22 = MathHelper.sin((double)var20) * var19;
      float var23 = pa;
      float var24 = 0.45F + 0.55F * (var23 < 0.0F ? 0.0F : (var23 > 1.0F ? 1.0F : var23));
      float var25 = 158.0F + -66.0F * var122;
      float var26 = 132.0F + -46.0F * var122;
      float var27 = 128.0F + -48.0F * var122;
      float var28 = var7[0];
      float var29 = var7[1];
      float var30 = var7[2];
      float var31 = var7[3];
      float var32 = var7[4];
      float var33 = var7[5];
      float var34 = var7[6];
      float var35 = var7[7];
      float var36 = var7[8];
      float var37 = ol;
      float var38 = pg;
      float var39 = pe;
      float var40 = pf;
      float var41 = pb;
      float var42 = pc;
      float var43 = pd;
      boolean var44 = qm;
      int var45 = qj;
      int var46 = qk;
      int[] var47 = ps;
      boolean var48 = or;
      boolean var49 = ou;
      float var50 = ot;
      float var51 = os;
      double var52 = 36.0;
      double var54 = 24.0;
      double var56 = 36.0;
      float var58 = 9.900001F;
      float var59 = 8.099999F;
      float var60 = 7.2000003F;
      float var61 = 4.8F;

      for (int var62 = 0; var62 < var17; var62++) {
         float var63 = js[var62];
         float var64 = jt[var62];
         float var65 = var21 + MathHelper.sin(var4 * (double)var64 * 0.5 + (double)var63) * 0.35F;
         float var66 = MathHelper.sin(var4 * (double)var64 + (double)var63);
         float var67 = -jq[var62] * (0.75F + 0.5F * (var66 < 0.0F ? -var66 : var66));
         float var68 = var22 + MathHelper.cos(var4 * (double)var64 * 0.41 + (double)var63 * 1.7) * 0.35F;
         double var69 = jn[var62] + (double)(var65 * var3);
         double var71 = jo[var62] + (double)(var67 * var3);
         double var73 = jp[var62] + (double)(var68 * var3);
         double var75 = var69 - var9;
         double var77 = var71 - var11;
         double var79 = var73 - var13;
         if (var75 < -18.0 || var75 >= 18.0) {
            var75 -= Math.floor((var75 + 18.0) / var52) * var52;
            var69 = var9 + var75;
         }

         if (var79 < -18.0 || var79 >= 18.0) {
            var79 -= Math.floor((var79 + 18.0) / var56) * var56;
            var73 = var13 + var79;
         }

         if (var77 < -12.0 || var77 >= 12.0) {
            var77 -= Math.floor((var77 + 12.0) / var54) * var54;
            var71 = var11 + var77;
         }

         jn[var62] = var69;
         jo[var62] = var71;
         jp[var62] = var73;
         float var81 = (float)var75;
         float var82 = (float)var77;
         float var83 = (float)var79;
         float var84 = var81 * var81 + var82 * var82 + var83 * var83;
         if (!(var84 < 0.09F)) {
            float var85 = MathHelper.sqrt(var84);
            float var86 = var81 * var34 + var82 * var35 + var83 * var36;
            if (!(var86 < -0.3F * var85)) {
               if (var48) {
                  float var87 = 0.12F + var86 * var50;
                  if (var87 < 0.0F || (var84 - var86 * var86) * var51 > var87 * var87) {
                     continue;
                  }
               }

               float var123 = 1.0F;
               if (var44) {
                  int var88 = MathHelper.floor(var69) - var45 + 24;
                  int var89 = MathHelper.floor(var73) - var46 + 24;
                  if (var88 >= 0 && var89 >= 0 && var88 < 49 && var89 < 49) {
                     float var90 = (float)var47[var89 * 49 + var88];
                     if (var71 < (double)var90) {
                        continue;
                     }

                     float var91 = (float)(var71 - (double)var90) * 10.0F;
                     var123 = var91 > 1.0F ? 1.0F : var91;
                  }
               }

               float var124 = var85 - 0.3F;
               var124 = var124 < 0.0F ? 0.0F : (var124 > 1.0F ? 1.0F : var124);
               float var126 = (var85 - var58) / var59;
               var126 = var126 < 0.0F ? 0.0F : (var126 > 1.0F ? 1.0F : var126);
               float var128 = var82 < 0.0F ? -var82 : var82;
               float var129 = (var128 - var60) / var61;
               var129 = var129 < 0.0F ? 0.0F : (var129 > 1.0F ? 1.0F : var129);
               float var92 = (var18 - (float)var62) / 64.0F;
               var92 = var92 < 0.0F ? 0.0F : (var92 > 1.0F ? 1.0F : var92);
               float var93 = 0.9F
                  * var6
                  * var124
                  * var124
                  * (3.0F - 2.0F * var124)
                  * (1.0F - var126 * var126 * (3.0F - 2.0F * var126))
                  * (1.0F - var129 * var129 * (3.0F - 2.0F * var129))
                  * var92
                  * var123;
               if (!(var93 < 0.012F)) {
                  float var94 = jr[var62];
                  float var95 = 0.6F * var85 / var37;
                  if (var94 < var95) {
                     var93 *= var94 / var95;
                     var94 = var95;
                  }

                  double var96 = (double)var63 + var4 * (double)var64 * 0.7;
                  float var98 = MathHelper.cos(var96);
                  float var99 = MathHelper.sin(var96);
                  float var100 = MathHelper.cos(var4 * (double)var64 + (double)var63 * 1.3);
                  float var101 = 0.25F + 0.75F * (var100 < 0.0F ? -var100 : var100);
                  float var102 = (var28 * var98 + var31 * var99) * var94 * var101;
                  float var103 = (var29 * var98 + var32 * var99) * var94 * var101;
                  float var104 = (var30 * var98 + var33 * var99) * var94 * var101;
                  float var105 = (-var28 * var99 + var31 * var98) * var94;
                  float var106 = (-var29 * var99 + var32 * var98) * var94;
                  float var107 = (-var30 * var99 + var33 * var98) * var94;
                  float var108 = ju[var62] * var24 * (0.82F + 0.18F * var100);
                  float var109 = var25 * var108;
                  float var110 = var26 * var108;
                  float var111 = var27 * var108;
                  if (var38 > 0.0F) {
                     float var112 = (var85 - var39) * var40;
                     var112 = var112 < 0.0F ? 0.0F : (var112 > 1.0F ? 1.0F : var112);
                     var109 += (var41 - var109) * var112;
                     var110 += (var42 - var110) * var112;
                     var111 += (var43 - var111) * var112;
                  }

                  int var133 = (int)(var109 > 255.0F ? 255.0F : var109);
                  int var113 = (int)(var110 > 255.0F ? 255.0F : var110);
                  int var114 = (int)(var111 > 255.0F ? 255.0F : var111);
                  int var115 = (int)((var93 > 1.0F ? 1.0F : var93) * 255.0F);
                  float var116 = 0.0F;
                  float var117 = 0.0F;
                  float var118 = 1.0F;
                  float var119 = 1.0F;
                  if (var8) {
                     float var120 = var94 * 2.0F * var37 / var85;
                     int var121 = var120 >= 64.0F ? 0 : (var120 >= 32.0F ? 1 : (var120 >= 16.0F ? 2 : 3));
                     var116 = dm[var121];
                     var117 = _kwren_do[var121];
                     var118 = dn[var121];
                     var119 = dp[var121];
                  }

                  if (var49) {
                     var0.vertex(var81 - var102 - var105, var82 - var103 - var106, var83 - var104 - var107)
                        .texture(var116, var119)
                        .color(var133, var113, var114, var115);
                     var0.vertex(var81 - var102 + var105, var82 - var103 + var106, var83 - var104 + var107)
                        .texture(var116, var117)
                        .color(var133, var113, var114, var115);
                     var0.vertex(var81 + var102 + var105, var82 + var103 + var106, var83 + var104 + var107)
                        .texture(var118, var117)
                        .color(var133, var113, var114, var115);
                     var0.vertex(var81 + var102 - var105, var82 + var103 - var106, var83 + var104 - var107)
                        .texture(var118, var119)
                        .color(var133, var113, var114, var115);
                  } else {
                     var0.vertex(var1, var81 - var102 - var105, var82 - var103 - var106, var83 - var104 - var107)
                        .texture(var116, var119)
                        .color(var133, var113, var114, var115);
                     var0.vertex(var1, var81 - var102 + var105, var82 - var103 + var106, var83 - var104 + var107)
                        .texture(var116, var117)
                        .color(var133, var113, var114, var115);
                     var0.vertex(var1, var81 + var102 + var105, var82 + var103 + var106, var83 + var104 + var107)
                        .texture(var118, var117)
                        .color(var133, var113, var114, var115);
                     var0.vertex(var1, var81 + var102 - var105, var82 + var103 - var106, var83 + var104 - var107)
                        .texture(var118, var119)
                        .color(var133, var113, var114, var115);
                  }
               }
            }
         }
      }
   }

   private static void ap(int var0, double var1, double var3, double var5, boolean var7, boolean var8) {

      kr[var0] = var1 + (ed.nextDouble() * 2.0 - 1.0) * 20.0;
      kt[var0] = var5 + (ed.nextDouble() * 2.0 - 1.0) * 20.0;
      ks[var0] = var7 ? var3 + (ed.nextDouble() * 2.0 - 1.0) * 14.0 : var3 + 14.0 * (0.97 + 0.03 * ed.nextDouble());
      lf[var0] = 0.0F;
      lg[var0] = 0.0F;
      lh[var0] = 0.0F;
      li[var0] = 1.0F;
      lj[var0] = Float.NaN;
      lk[var0] = 0.0F;
      ll[var0] = 1.0F;
      lm[var0] = 0.0F;
      if (!var7 && qi > 0 && ed.nextFloat() < 0.45F) {
         int var9 = ed.nextInt(qi);
         double var10 = (double)qe[var9] + ed.nextDouble();
         double var12 = (double)qf[var9] + ed.nextDouble();
         double var14 = (double)qh[var9] + (double)(qg[var9] - qh[var9]) * ed.nextDouble();
         if (var10 - var1 > -20.0 && var10 - var1 < 20.0 && var12 - var5 > -20.0 && var12 - var5 < 20.0 && var14 - var3 < 12.6 && var14 - var3 > -12.6) {
            kr[var0] = var10;
            kt[var0] = var12;
            ks[var0] = var14;
            ll[var0] = 0.001F;
         }
      }

      if (var8) {
         float var17 = ed.nextFloat();
         int var18 = var17 < 0.34F ? 0 : (var17 < 0.56F ? 1 : (var17 < 0.82F ? 2 : 3));
         ln[var0] = 8 + var18 * 2;
         kv[var0] = (var18 == 2 ? 0.078F : 0.09F) * (0.8F + 0.45F * ed.nextFloat());
         ku[var0] = 1.25F + ed.nextFloat() * 1.0F;
         kw[var0] = ed.nextFloat() * (float) (Math.PI * 2);
         kx[var0] = 2.5F + ed.nextFloat() * 2.5F;
         ky[var0] = 0.5F + ed.nextFloat() * 1.0F;
         kz[var0] = 0.45F + ed.nextFloat() * 0.65F;
         la[var0] = ed.nextFloat() * (float) (Math.PI * 2);
         lb[var0] = (ed.nextFloat() * 2.0F - 1.0F) * 0.9F;
         lc[var0] = (ed.nextFloat() * 2.0F - 1.0F) * 2.2F;
         if (ed.nextFloat() < 0.55F) {
            ld[var0] = (4.0F + ed.nextFloat() * 6.0F) * (ed.nextBoolean() ? 1.0F : -1.0F);
         } else {
            ld[var0] = 0.0F;
            lk[var0] = ed.nextFloat() < 0.4F ? (float) Math.PI : 0.0F;
         }

         le[var0] = 0.86F + ed.nextFloat() * 0.14F;
         lm[var0] = ed.nextFloat();
      } else {
         boolean var16 = ed.nextFloat() < 0.1F;
         ln[var0] = var16 ? 4 + ed.nextInt(4) : ed.nextInt(4);
         kv[var0] = var16 ? 0.125F + ed.nextFloat() * 0.06F : 0.06F + ed.nextFloat() * 0.038F;
         ku[var0] = 0.8F + ed.nextFloat() * 0.9F;
         kw[var0] = ed.nextFloat() * (float) (Math.PI * 2);
         kx[var0] = 5.0F + ed.nextFloat() * 5.0F;
         ky[var0] = 0.5F + ed.nextFloat() * 0.7F;
         kz[var0] = 0.3F + ed.nextFloat() * 0.6F;
         la[var0] = ed.nextFloat() * (float) (Math.PI * 2);
         lb[var0] = (ed.nextFloat() * 2.0F - 1.0F) * 0.6F;
         lc[var0] = (ed.nextFloat() * 2.0F - 1.0F) * 1.1F;
         if (var16) {
            ld[var0] = 2.0F + ed.nextFloat() * 2.0F;
         } else if (ed.nextFloat() < 0.45F) {
            ld[var0] = (8.0F + ed.nextFloat() * 10.0F) * (ed.nextBoolean() ? 1.0F : -1.0F);
         } else {
            ld[var0] = 0.0F;
         }

         le[var0] = 0.92F + ed.nextFloat() * 0.08F;
      }
   }

   private static void aq(
      VertexConsumer var0, MatrixStack.Entry var1, Vec3d var2, float var3, double var4, float var6, float[] var7, boolean var8, float var9, float var10
   ) {

      double var11 = var2.x;
      double var13 = var2.y;
      double var15 = var2.z;
      if (!lo) {
         for (int var17 = 0; var17 < (-398645987 ^ -398641947); var17++) {
            boolean var18 = (float)(var17 * (2019639109 ^ -430553348) >>> 8) * 5.9604645E-8F < var9;
            ap(var17, var11, var13, var15, true, var18);
            if (var18 && (float)(var17 * (1174708971 ^ -1007720320) + (-121587697 ^ -1832296856) >>> 8) * 5.9604645E-8F >= 0.3F) {
               ll[var17] = 0.0F;
            }
         }

         lo = true;
      }

      float var182 = 4600.0F * (0.12F + 0.88F * ov);
      lp = lp + (var182 - lp) * (1.0F - (float)Math.exp((double)(-var3 * 1.5F)));
      int var183 = Math.min(463970333 ^ 463974885, (int)Math.ceil((double)lp));
      float var19 = lp;
      float var20 = ow;
      float var21 = ox;
      float var22 = 0.6F + 0.35F * MathHelper.sin(var4 * 0.027);
      float var23 = var20 * (0.9F + 2.8F * var21);
      float var24 = MathHelper.cos((double)var22) * var23;
      float var25 = MathHelper.sin((double)var22) * var23;
      float var26 = oz;
      float var27 = 0.35F + 0.65F * (var26 < 0.0F ? 0.0F : (var26 > 1.0F ? 1.0F : var26));
      float var28 = 0.62F + 0.38F * (var26 < 0.0F ? 0.0F : (var26 > 1.0F ? 1.0F : var26));
      float var29 = om;
      float var30 = on;
      float var31 = var10 > 0.0F ? 0.34F : 0.12F;
      int[] var32 = ps;
      float var33 = ol;
      float var34 = (float)Math.exp((double)(-var3 * 2.2F));
      float var35 = var3 * 8.0F;
      float var36 = var7[0];
      float var37 = var7[1];
      float var38 = var7[2];
      float var39 = var7[3];
      float var40 = var7[4];
      float var41 = var7[5];
      float var42 = var7[6];
      float var43 = var7[7];
      float var44 = var7[8];
      boolean var45 = qm && qn;
      int var46 = qj;
      int var47 = qk;
      float[] var48 = pt;
      float[] var49 = qa;
      byte[] var50 = pu;
      byte[] var51 = qb;
      int[] var52 = nh;
      int var53 = ob;
      boolean var54 = oc;
      double var55 = od;
      double var57 = oe;
      double var59 = of;
      double var61 = og;
      boolean var63 = or;
      boolean var64 = ou;
      float var65 = ot;
      float var66 = os;
      float[] var67 = nn;
      float[] var68 = no;
      int[] var69 = np;
      double var70 = 40.0;
      double var72 = 28.0;
      double var74 = 40.0;
      float var76 = 8.400001F;
      float var77 = 5.6F;

      for (int var78 = 0; var78 < var183; var78++) {
         boolean var79 = (float)(var78 * (-521950635 ^ 2127877100) >>> 8) * 5.9604645E-8F < var9;
         boolean var80 = var79 && (float)(var78 * (-993727909 ^ 1093607472) + (-931731272 ^ -1568731425) >>> 8) * 5.9604645E-8F >= 0.3F;
         float var81 = ll[var78];
         if (var80) {
            if (var81 <= 0.0F) {
               continue;
            }

            var81 -= var3 * 4.0F;
            if (var81 < 0.0F) {
               var81 = 0.0F;
            }
         } else if (var79 != ln[var78] >= 8) {
            var81 -= var3 * 4.0F;
            if (var81 <= 0.0F) {
               ap(var78, var11, var13, var15, true, var79);
               var81 = 0.0F;
            }
         } else if (var81 < 1.0F) {
            if (var81 <= 0.0F) {
               ap(var78, var11, var13, var15, true, var79);
            }

            var81 += var3 * 2.0F;
            if (var81 > 1.0F) {
               var81 = 1.0F;
            }
         }

         ll[var78] = var81;
         int var82 = ln[var78];
         boolean var83 = var82 >= 8;
         float var84 = kw[var78];
         float var85 = kx[var78];
         double var86 = var4 * (double)var85 + (double)var84;
         float var88 = MathHelper.sin(var86);
         float var89 = MathHelper.cos(var86);
         double var90 = (double)la[var78] + var4 * (double)lb[var78];
         float var92 = MathHelper.sin(var90);
         float var93 = MathHelper.cos(var90);
         float var94 = ky[var78] * var89;
         double var95 = kr[var78];
         double var97 = ks[var78];
         double var99 = kt[var78];
         float var101 = lf[var78] * var34;
         float var102 = lg[var78] * var34;
         float var103 = lh[var78] * var34;
         int var104 = var54 && var95 >= var55 && var95 <= var57 && var99 >= var59 && var99 <= var61 ? var53 : 0;

         for (int var105 = 0; var105 < var104; var105++) {
            float var106 = oa[var105];
            if (!(var106 <= 0.0F)) {
               float var107 = ny[var105] + 0.9F;
               float var108 = (float)(var95 - nt[var105]);
               float var109 = (float)(var99 - nv[var105]);
               if (!(var108 > var107) && !(var108 < -var107) && !(var109 > var107) && !(var109 < -var107)) {
                  float var110 = (float)(var97 - nu[var105]);
                  if (!(var110 < -0.3F) && !(var110 > nz[var105] + 0.4F)) {
                     float var111 = var108 * var108 + var109 * var109;
                     if (!(var111 >= var107 * var107)) {
                        float var112 = MathHelper.sqrt(var111) + 0.001F;
                        float var113 = (1.0F - var112 / var107) * var106 * var3;
                        var101 += (nw[var105] * 1.4F + var108 / var112 * 3.5F) * var113;
                        var103 += (nx[var105] * 1.4F + var109 / var112 * 3.5F) * var113;
                        var102 += 1.8F * var113;
                     }
                  }
               }
            }
         }

         if (var101 * var101 + var102 * var102 + var103 * var103 < 1.0E-4F) {
            var101 = 0.0F;
            var102 = 0.0F;
            var103 = 0.0F;
         }

         lf[var78] = var101;
         lg[var78] = var102;
         lh[var78] = var103;
         float var184 = var94 * var93;
         float var185 = -var94 * var92;
         float var186 = 0.5F + var89 * var89;
         if (var83 && ld[var78] != 0.0F) {
            float var187 = ky[var78] * (0.5F + 0.2F * var89) * (ld[var78] > 0.0F ? 1.0F : -1.0F);
            var184 = var187 * var92;
            var185 = var187 * var93;
            var186 = 1.15F;
         }

         float var188 = var24 + var184 + var101;
         float var189 = var25 + var185 + var103;
         float var190 = -ku[var78] * var186 + var102;
         double var191 = var95 + (double)(var188 * var3);
         double var192 = var97 + (double)(var190 * var3);
         double var115 = var99 + (double)(var189 * var3);
         float var117 = -1.0E9F;
         byte var118 = 3;
         int var119 = -1;
         if (var45) {
            int var120 = MathHelper.floor(var191);
            int var121 = MathHelper.floor(var115);
            int var122 = var120 - var46 + 24;
            int var123 = var121 - var47 + 24;
            if (var122 >= 0 && var123 >= 0 && var122 < 49 && var123 < 49) {
               int var124 = var123 * 49 + var122;
               var119 = var124;
               var118 = var50[var124];
               if (var118 == 4) {
                  int var125 = var124 << 6 | ((int)((var191 - (double)var120) * 8.0) & 7) << 3 | (int)((var115 - (double)var121) * 8.0) & 7;
                  var117 = var49[var125];
                  var118 = var51[var125];
               } else {
                  var117 = var48[var124];
               }
            }

            if ((double)var117 > var192 + 0.05F) {
               int var202 = MathHelper.floor(var95);
               int var204 = MathHelper.floor(var99);
               int var126 = var202 - var46 + 24;
               int var127 = var204 - var47 + 24;
               float var128 = -1.0E9F;
               byte var129 = 3;
               if (var126 >= 0 && var127 >= 0 && var126 < 49 && var127 < 49) {
                  int var130 = var127 * 49 + var126;
                  var129 = var50[var130];
                  if (var129 == 4) {
                     int var131 = var130 << 6 | ((int)((var95 - (double)var202) * 8.0) & 7) << 3 | (int)((var99 - (double)var204) * 8.0) & 7;
                     var128 = var49[var131];
                     var129 = var51[var131];
                  } else {
                     var128 = var48[var130];
                  }
               }

               if ((double)var128 <= var97 + 0.02F) {
                  var191 = var95;
                  var115 = var99;
                  var117 = var128;
                  var118 = var129;
                  lf[var78] = 0.0F;
                  lh[var78] = 0.0F;
               }
            }
         }

         float var193 = var117;
         if (var118 == 0) {
            int var194 = (MathHelper.floor(var191 * 2.0) & 127) << 7 | MathHelper.floor(var115 * 2.0) & 127;
            int var196 = var52[var194];
            var193 = var117 + 0.014F + (float)(var196 > 36 ? 36 : var196) * 0.0042F;
         } else if (var118 == 1) {
            var193 = var117 + 0.02F;
         }

         float var195 = 1.0F;
         if (var8 && var118 <= 1) {
            float var197 = (float)(var192 - (double)var193);
            float var200 = var83 ? 0.45F : 0.35F;
            if (var197 < var200) {
               var195 = var197 <= 0.0F ? 0.0F : var197 / var200;
            }
         }

         float var198 = li[var78];
         var198 = var195 > var198 + var35 ? var198 + var35 : (var195 < var198 - var35 ? var198 - var35 : var195);
         li[var78] = var198;
         boolean var201 = var8 && var118 <= 2 && var192 <= (double)(var193 + 0.006F) && var97 > (double)(var117 - 0.4F);
         if (var201 && var118 <= 1) {
            if (var198 > 0.02F) {
               var192 = (double)(var193 + 0.006F);
               var201 = false;
            } else {
               var192 = (double)var193;
            }
         }

         int var203 = var82 == 7 && var198 < 1.0F ? 4 + var78 % 3 : var82;
         float var205 = 0.0F;
         float var206 = 0.0F;
         float var207 = 0.0F;
         if (var82 < 4 || var82 >= 8) {
            var206 = kz[var78] * var88 * var198;
            float var208 = ld[var78];
            if (var208 != 0.0F) {
               double var210 = var4 * (double)var208 + (double)var84 + (double)lk[var78];
               float var215 = (float)(var210 - (float) (Math.PI * 2) * Math.floor(var210 / (float) (Math.PI * 2) + 0.5));
               float var132 = lj[var78];
               if (var198 < 1.0F) {
                  if (var132 != var132) {
                     var132 = var215;
                     lj[var78] = var215;
                  }

                  if (var83 && (var132 > (float) (Math.PI / 2) || var132 < (float) (-Math.PI / 2))) {
                     var205 = var132 > 0.0F ? (float) Math.PI : (float) -Math.PI;
                  }

                  var207 = var205 + (var132 - var205) * var198;
               } else {
                  if (var132 == var132) {
                     lk[var78] = lk[var78] + (var132 - var215);
                     lj[var78] = Float.NaN;
                     var215 = var132;
                  }

                  var207 = var215;
               }
            } else {
               var205 = lk[var78];
               var207 = var205 + 0.3F * MathHelper.sin(var4 * (double)var85 * 1.7 + (double)var84 * 2.0) * var198;
            }
         }

         boolean var209 = false;
         float var211 = 1.0F;
         if (var118 <= 2) {
            if (var8) {
               if (var118 == 2) {
                  float var212 = (float)(var192 - (double)var117) / 0.4F;
                  if (var212 <= 0.0F) {
                     var209 = true;
                  } else if (var212 < 1.0F) {
                     var211 = var212 * var212 * (3.0F - 2.0F * var212);
                  }
               } else {
                  var209 = var192 < (double)(var117 - 0.4F);
               }
            } else {
               float var213 = (float)(var192 - (double)var117) / 1.2F;
               if (var213 < 0.0F) {
                  var209 = true;
               } else if (var213 < 1.0F) {
                  var211 = var213 * var213 * (3.0F - 2.0F * var213);
               }
            }
         }

         double var214 = var191 - var11;
         double var216 = var192 - var13;
         double var134 = var115 - var15;
         if (!var201) {
            if (var214 < -20.0 || var214 >= 20.0) {
               var214 -= Math.floor((var214 + 20.0) / var70) * var70;
               var191 = var11 + var214;
            }

            if (var134 < -20.0 || var134 >= 20.0) {
               var134 -= Math.floor((var134 + 20.0) / var74) * var74;
               var115 = var15 + var134;
            }

            if (var216 < -14.0 || var216 >= 14.0) {
               var216 -= Math.floor((var216 + 14.0) / var72) * var72;
               var192 = var13 + var216;
               li[var78] = 1.0F;
               lj[var78] = Float.NaN;
            }
         }

         kr[var78] = var191;
         ks[var78] = var192;
         kt[var78] = var115;
         float var136 = (float)var214;
         float var137 = (float)var216;
         float var138 = (float)var134;
         float var139 = var136 * var136 + var138 * var138;
         float var140 = var139 + var137 * var137;
         float var141 = MathHelper.sqrt(var140);
         float var142 = (var141 - 0.25F) / 1.2F;
         var142 = var142 < 0.0F ? 0.0F : (var142 > 1.0F ? 1.0F : var142);
         float var143 = var137 < 0.0F ? -var137 : var137;
         float var144 = (var143 - var76) / var77;
         var144 = var144 < 0.0F ? 0.0F : (var144 > 1.0F ? 1.0F : var144);
         float var145 = (var19 - (float)var78) / 64.0F;
         var145 = var145 < 0.0F ? 0.0F : (var145 > 1.0F ? 1.0F : var145);
         float var146 = var142 * var142 * (3.0F - 2.0F * var142) * (1.0F - var144 * var144 * (3.0F - 2.0F * var144)) * var145;
         float var147 = var136 * var42 + var137 * var43 + var138 * var44;
         boolean var148 = !var209 && !(var140 < 0.06F) && !(var139 >= 400.0F) && !(var147 < -0.3F * var141);
         if (var148 && var63) {
            float var149 = 0.55F + var147 * var65;
            var148 = !(var149 < 0.0F) && !((var140 - var147 * var147) * var66 > var149 * var149);
         }

         float var220 = 0.0F;
         if (var148) {
            float var150 = (MathHelper.sqrt(var139) - 13.0F) / 7.0F;
            var150 = var150 < 0.0F ? 0.0F : (var150 > 1.0F ? 1.0F : var150);
            var220 = var6 * var211 * var146 * var81 * (1.0F - var150 * var150 * (3.0F - 2.0F * var150));
            var148 = !(var220 < 0.012F);
         }

         float var222 = 0.0F;
         float var151 = 0.0F;
         float var152 = 0.0F;
         float var153 = 0.0F;
         float var154 = 0.0F;
         float var155 = 0.0F;
         float var156 = 0.0F;
         if (var148 || var201) {
            double var157 = (double)var84 + var4 * (double)lc[var78];
            float var159 = MathHelper.cos(var157);
            float var160 = MathHelper.sin(var157);
            if (var82 >= 4 && var82 < 8) {
               float var227 = 0.62F + 0.38F * Math.abs(MathHelper.cos(var4 * (double)ld[var78] + (double)var84));
               var227 = 1.0F + (var227 - 1.0F) * var198;
               float var230 = (var36 * var159 + var39 * var160) * var227;
               float var232 = (var37 * var159 + var40 * var160) * var227;
               float var234 = (var38 * var159 + var41 * var160) * var227;
               float var236 = -var36 * var160 + var39 * var159;
               float var166 = -var37 * var160 + var40 * var159;
               float var239 = -var38 * var160 + var41 * var159;
               if (var198 < 1.0F) {
                  float var242 = -var36 * var160 + var38 * var159;
                  float var246 = -var38 * var160 - var36 * var159;
                  float var249 = 1.0F - var198;
                  var222 = -var246 * var249 + var230 * var198;
                  var151 = var232 * var198;
                  var152 = var242 * var249 + var234 * var198;
                  var153 = var242 * var249 + var236 * var198;
                  var154 = var166 * var198;
                  var155 = var246 * var249 + var239 * var198;
               } else {
                  var222 = var230;
                  var151 = var232;
                  var152 = var234;
                  var153 = var236;
                  var154 = var166;
                  var155 = var239;
               }

               var156 = 1.0F;
            } else {
               float var161 = MathHelper.cos((double)var206);
               float var162 = MathHelper.sin((double)var206);
               float var163 = MathHelper.cos((double)var207);
               float var164 = MathHelper.sin((double)var207);
               float var165 = var161 * var93;
               float var167 = -var161 * var92;
               float var168 = var164 * var162 * var93 + var163 * var92;
               float var169 = -var164 * var161;
               float var170 = -var164 * var162 * var92 + var163 * var93;
               var153 = var165 * var159 + var168 * var160;
               var154 = var162 * var159 + var169 * var160;
               var155 = var167 * var159 + var170 * var160;
               var222 = -var165 * var160 + var168 * var159;
               var151 = -var162 * var160 + var169 * var159;
               var152 = -var167 * var160 + var170 * var159;
               var156 = var163 * var161;
               if (var156 < 0.0F) {
                  var156 = -var156;
               }
            }
         }

         if (var148) {
            if (var220 > 1.0F) {
               var220 = 1.0F;
            }

            float var223 = kv[var78] * (1.0F + var141 * 0.01F);
            float var158 = var222 * var223;
            float var225 = var151 * var223;
            float var226 = var152 * var223;
            float var229 = var153 * var223;
            float var231 = var154 * var223;
            float var233 = var155 * var223;
            float var235 = 1.0F - var198;
            float var237 = (var136 * var29 + var137 * var30) / (var141 + 1.0E-4F);
            float var238 = 1.0F;
            if (var119 >= 0) {
               float var240 = (float)var32[var119];
               float var243 = var48[var119];
               if (var240 - var243 > 2.0F && var192 < (double)var240 - 0.3) {
                  float var247 = (float)((double)var240 - 0.3 - var192) * 0.8333333F;
                  var238 = 1.0F - 0.3F * (var247 > 1.0F ? 1.0F : var247);
               }
            }

            float var241 = 1.0F;
            if (var82 < 4 || var83) {
               float var244 = (var151 * var155 - var152 * var154) * var29 + (var152 * var153 - var222 * var155) * var30;
               var241 = 0.84F + var31 * var244 * var244;
            }

            int var171 = var203;
            int var245;
            int var248;
            int var250;
            if (var83) {
               float var172 = lm[var78];
               float var173 = 1.0F - 0.26F * var172;
               float var174 = 1.0F - 0.36F * var172;
               float var175 = var28 * le[var78] * 0.8F;
               float var176 = var28 * le[var78] * (0.84F + 0.08F * var156);
               if (var237 > 0.55F) {
                  float var177 = (var237 - 0.55F) / 0.45F;
                  var177 = var177 * var177 * var10;
                  var176 += var177 * 0.3F;
                  var173 += var177 * 0.06F;
               }

               float var265 = (var176 * var241 * var198 + var175 * var235) * var238;
               float var178 = var173 * var198 + (1.0F - 0.26F * var172) * var235;
               var265 = var265 > 1.0F ? 1.0F : var265;
               var178 = var178 > 1.0F ? 1.0F : var178;
               var245 = (int)(255.0F * var265);
               var248 = (int)(255.0F * var265 * var178);
               var250 = (int)(255.0F * var265 * var174);
               float var179 = var151 * var155 - var152 * var154;
               float var180 = var152 * var153 - var222 * var155;
               float var181 = var222 * var154 - var151 * var153;
               var171 = var82 + (var179 * var136 + var180 * var137 + var181 * var138 > 0.0F ? 1 : 0);
            } else {
               float var251 = var27 * le[var78] * (0.92F + 0.08F * var156);
               float var254 = (float)((var13 - var192) / 12.0);
               var254 = var254 < 0.0F ? 0.0F : (var254 > 1.0F ? 1.0F : var254) * 0.5F;
               if (var237 > 0.6F) {
                  float var257 = (var237 - 0.6F) / 0.4F;
                  var257 = var257 * var257 * var10 * var198;
                  var251 += var257 * 0.3F;
                  var254 += var257 * 0.6F;
               }

               var251 *= var238 * (var241 * var198 + var235);
               if (var251 > 1.0F) {
                  var251 = 1.0F;
               }

               if (var254 > 1.0F) {
                  var254 = 1.0F;
               }

               var245 = (int)(255.0F * var251);
               var248 = (int)(((255.0F - 12.0F * var254) * var198 + 249.0F * var235) * var251);
               var250 = (int)(((255.0F - 22.0F * var254) * var198 + 245.0F * var235) * var251);
            }

            int var253 = (int)(var220 * 255.0F);
            float var256 = var223 * 2.0F * var33 / var141;
            if (var235 > 0.0F) {
               float var259 = (var137 < 0.0F ? -var137 : var137) / var141;
               var259 = var259 < 0.15F ? 0.3873F : MathHelper.sqrt(var259);
               var256 *= var198 + var235 * var259;
            }

            int var261 = (var256 >= 64.0F ? 0 : (var256 >= 32.0F ? 16 : (var256 >= 16.0F ? 32 : 48))) + var171;
            float var262 = du[var261];
            float var263 = dv[var261];
            float var267 = dw[var261];
            float var269 = dx[var261];
            if (var141 < 4.0F && nr < (-105930772 ^ -105931156)) {
               int var270 = nr * 13;
               var67[var270] = var136;
               var67[var270 + 1] = var137;
               var67[var270 + 2] = var138;
               var67[var270 + 3] = var158;
               var67[var270 + 4] = var225;
               var67[var270 + 5] = var226;
               var67[var270 + 6] = var229;
               var67[var270 + 7] = var231;
               var67[var270 + 8] = var233;
               var67[var270 + 9] = var262;
               var67[var270 + 10] = var263;
               var67[var270 + 11] = var267;
               var67[var270 + 12] = var269;
               var68[nr] = var141;
               var69[nr] = var245 << 24 | var248 << 16 | var250 << 8 | var253;
               nr++;
            } else if (var64) {
               var0.vertex(var136 - var158 - var229, var137 - var225 - var231, var138 - var226 - var233)
                  .texture(var262, var269)
                  .color(var245, var248, var250, var253);
               var0.vertex(var136 - var158 + var229, var137 - var225 + var231, var138 - var226 + var233)
                  .texture(var262, var263)
                  .color(var245, var248, var250, var253);
               var0.vertex(var136 + var158 + var229, var137 + var225 + var231, var138 + var226 + var233)
                  .texture(var267, var263)
                  .color(var245, var248, var250, var253);
               var0.vertex(var136 + var158 - var229, var137 + var225 - var231, var138 + var226 - var233)
                  .texture(var267, var269)
                  .color(var245, var248, var250, var253);
            } else {
               var0.vertex(var1, var136 - var158 - var229, var137 - var225 - var231, var138 - var226 - var233)
                  .texture(var262, var269)
                  .color(var245, var248, var250, var253);
               var0.vertex(var1, var136 - var158 + var229, var137 - var225 + var231, var138 - var226 + var233)
                  .texture(var262, var263)
                  .color(var245, var248, var250, var253);
               var0.vertex(var1, var136 + var158 + var229, var137 + var225 + var231, var138 + var226 + var233)
                  .texture(var267, var263)
                  .color(var245, var248, var250, var253);
               var0.vertex(var1, var136 + var158 - var229, var137 + var225 - var231, var138 + var226 - var233)
                  .texture(var267, var269)
                  .color(var245, var248, var250, var253);
            }
         }

         if (var201) {
            if (var118 <= 1 && var81 > 0.0F) {
               boolean var224 = var83 && (var205 > (float) (Math.PI / 2) || var205 < (float) (-Math.PI / 2));
               ar(
                  var191,
                  (double)var117,
                  var115,
                  var203,
                  kv[var78],
                  le[var78],
                  lm[var78],
                  (float)Math.atan2((double)(-var155), (double)var153),
                  var224,
                  var118,
                  var146 * var81
               );
            }

            ap(var78, var11, var13, var15, false, var79);
            if (var80) {
               ll[var78] = 0.0F;
            }
         }
      }
   }

   private static void ar(
      double var0, double var2, double var4, int var6, float var7, float var8, float var9, float var10, boolean var11, int var12, float var13
   ) {

      int var14 = mu;
      mu = var14 + 1 >= (-1755602942 ^ -1755596942) ? 0 : var14 + 1;
      if (mt[var14] == 1) {
         int var15 = mr[var14];
         if (var15 >= 0 && nh[var15] > 0) {
            nh[var15]--;
         }
      }

      lw[var14] = var0;
      ly[var14] = var4;
      mq[var14] = var6 == 7 ? 4 : var6;
      mf[var14] = var7;
      mp[var14] = var8;
      mo[var14] = var9;
      mc[var14] = var10;
      mj[var14] = 0.0F;
      mk[var14] = 0.0F;
      ml[var14] = var6 >= 8 ? 0.22F + ed.nextFloat() * 0.85F : 0.3F + ed.nextFloat() * 0.95F;
      mm[var14] = ed.nextFloat();
      mn[var14] = var13 < 0.0F ? 0.0F : (var13 > 1.0F ? 1.0F : var13);
      mr[var14] = -1;
      na = true;
      as(var14, var2, var12);
      if (var11) {
         mi[var14] = (float) Math.PI;
      }
   }

   private static void as(int var0, double var1, int var3) {

      lz[var0] = 0.0F;
      ma[var0] = 0.0F;
      mb[var0] = 0.0F;
      mh[var0] = 0.0F;
      mi[var0] = 0.0F;
      float var4 = 1.0F;
      if (qm && qn) {
         int var5 = MathHelper.floor(lw[var0]) - qj + 24;
         int var6 = MathHelper.floor(ly[var0]) - qk + 24;
         if (var5 >= 0 && var6 >= 0 && var5 < 49 && var6 < 49) {
            int var7 = var6 * 49 + var5;
            float var8 = (float)ps[var7];
            if (var8 - pt[var7] > 2.0F && var1 < (double)var8 - 0.3) {
               float var9 = (float)((double)var8 - 0.3 - var1) * 0.8333333F;
               var4 = 1.0F - 0.3F * (var9 > 1.0F ? 1.0F : var9);
            }
         }
      }

      mg[var0] = mp[var0] * var4;
      if (var3 == 1) {
         mt[var0] = 3;
         mr[var0] = -1;
         ms[var0] = 0;
         md[var0] = 0.0F;
         me[var0] = 0.0F;
         lx[var0] = var1 + 0.02F;
      } else {
         int var10 = (MathHelper.floor(lw[var0] * 2.0) & 127) << 7 | MathHelper.floor(ly[var0] * 2.0) & 127;
         int var11 = nh[var10]++;
         if (var11 > 36) {
            var11 = 36;
         }

         mr[var0] = var10;
         ms[var0] = var11;
         float var12 = mq[var0] >= 8 ? (var11 > 2 ? 0.16F : 0.05F) : (var11 > 2 ? 0.28F : 0.07F);
         md[var0] = (ed.nextFloat() * 2.0F - 1.0F) * var12;
         me[var0] = (ed.nextFloat() * 2.0F - 1.0F) * var12;
         lx[var0] = var1 + 0.014F + (double)((float)var11 * 0.0042F);
         mt[var0] = 1;
      }
   }

   private static void at(Vec3d var0, float var1, float var2, float var3) {

      if (qm && qn) {
         float var4 = 0.3F + 0.7F * ov;
         float var5 = nf / 30.0F;
         float var6 = ng / 24.0F;
         var5 = var5 > 1.0F ? 1.0F : var5;
         var6 = var6 > 1.0F ? 1.0F : var6;
         float var7 = var2 + var3;
         float var8 = var7 > 1.0E-4F ? var3 / var7 : 0.0F;
         int var9 = (int)(3000.0F * var4 * var5 * (1.0F - var8)) - mv;
         int var10 = (int)(3720.0F * var4 * var6 * var8) - mw;
         if (var9 <= 0 && var10 <= 0) {
            ne = 0.0F;
         } else {
            ne += var1 * 800.0F;
            int var11 = (int)ne;
            if (var11 > 48) {
               var11 = 48;
            }

            ne -= (float)var11;
            float var12 = MathHelper.sqrt(pl * pl + pn * pn);
            float var13 = (float)Math.atan2((double)pn, (double)pl);
            int var14 = 0;

            while (var14 < var11) {
               float var15 = var12 > 2.0F && ed.nextFloat() < 0.7F ? var13 + (ed.nextFloat() * 2.0F - 1.0F) * 1.3F : ed.nextFloat() * (float) (Math.PI * 2);
               double var16 = 12.0 + 8.0 * Math.sqrt(ed.nextDouble());
               double var18 = var0.x + (double)MathHelper.cos((double)var15) * var16;
               double var20 = var0.z + (double)MathHelper.sin((double)var15) * var16;
               boolean var22 = var10 > 0 && (var9 <= 0 || ed.nextFloat() * (float)(var9 + var10) < (float)var10);
               if (var22) {
                  float var39 = u(var18, var20);
                  int var40 = v(var18, var20);
                  if ((var40 == (1573145225 ^ -574338423) || !((float)var40 > var39 + 1.5F)) && ed.nextFloat() > 0.45F) {
                     var14++;
                  } else {
                     int var41 = 1 + ed.nextInt(4);

                     for (int var42 = 0; var42 < var41 && var14 < var11; var14++) {
                        double var43 = var18 + (ed.nextDouble() * 2.0 - 1.0) * 0.8;
                        double var29 = var20 + (ed.nextDouble() * 2.0 - 1.0) * 0.8;
                        float var31 = u(var43, var29);
                        int var44 = qo;
                        if (var44 < 2 && !((double)var31 > var0.y + 12.0) && !((double)var31 < var0.y - 24.0)) {
                           float var45 = ed.nextFloat();
                           int var46 = var45 < 0.34F ? 0 : (var45 < 0.56F ? 1 : (var45 < 0.82F ? 2 : 3));
                           float var47 = (var46 == 2 ? 0.078F : 0.09F) * (0.8F + 0.45F * ed.nextFloat());
                           ar(
                              var43,
                              (double)var31,
                              var29,
                              8 + var46 * 2,
                              var47,
                              0.78F + ed.nextFloat() * 0.18F,
                              ed.nextFloat(),
                              ed.nextFloat() * (float) (Math.PI * 2),
                              ed.nextFloat() < 0.42F,
                              var44,
                              0.0F
                           );
                           var10--;
                        }

                        var42++;
                     }
                  }
               } else {
                  float var23 = u(var18, var20);
                  int var24 = v(var18, var20);
                  boolean var25 = var24 != (-253744426 ^ 1893739222) && (float)var24 > var23 + 2.0F;
                  if (!var25 && ed.nextFloat() > 0.55F) {
                     var14++;
                  } else {
                     int var26 = var25 ? 2 + ed.nextInt(5) : 1 + ed.nextInt(2);

                     for (int var27 = 0; var27 < var26 && var14 < var11; var14++) {
                        double var28 = var18 + (ed.nextDouble() * 2.0 - 1.0) * 0.7;
                        double var30 = var20 + (ed.nextDouble() * 2.0 - 1.0) * 0.7;
                        float var32 = u(var28, var30);
                        int var33 = qo;
                        if (var33 < 2 && !((double)var32 > var0.y + 12.0) && !((double)var32 < var0.y - 24.0)) {
                           boolean var34 = ed.nextFloat() < 0.1F;
                           int var35 = var34 ? 4 + ed.nextInt(3) : ed.nextInt(4);
                           float var36 = var34 ? 0.125F + ed.nextFloat() * 0.06F : 0.06F + ed.nextFloat() * 0.038F;
                           ar(
                              var28,
                              (double)var32,
                              var30,
                              var35,
                              var36,
                              0.84F + ed.nextFloat() * 0.14F,
                              0.0F,
                              ed.nextFloat() * (float) (Math.PI * 2),
                              false,
                              var33,
                              0.0F
                           );
                           var9--;
                        }

                        var27++;
                     }
                  }
               }
            }
         }
      }
   }

   private static void au(
      VertexConsumer param0, MatrixStack.Entry param1, Vec3d param2, float param3, double param4, float[] param6, float param7, float param8, float[] param9
   ) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IllegalStateException: No common supertype for ternary expression
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.FunctionExprent.getExprType(FunctionExprent.java:224)
      //   at org.jetbrains.java.decompiler.modules.decompiler.exps.FunctionExprent.checkExprTypeBounds(FunctionExprent.java:375)
      //   at org.jetbrains.java.decompiler.modules.decompiler.vars.VarTypeProcessor.checkTypeExpr(VarTypeProcessor.java:140)
      //   at org.jetbrains.java.decompiler.modules.decompiler.vars.VarTypeProcessor.checkTypeExprent(VarTypeProcessor.java:121)
      //   at org.jetbrains.java.decompiler.modules.decompiler.vars.VarTypeProcessor.lambda$processVarTypes$2(VarTypeProcessor.java:114)
      //   at org.jetbrains.java.decompiler.modules.decompiler.flow.DirectGraph.iterateExprents(DirectGraph.java:107)
      //   at org.jetbrains.java.decompiler.modules.decompiler.vars.VarTypeProcessor.processVarTypes(VarTypeProcessor.java:114)
      //   at org.jetbrains.java.decompiler.modules.decompiler.vars.VarTypeProcessor.calculateVarTypes(VarTypeProcessor.java:44)
      //   at org.jetbrains.java.decompiler.modules.decompiler.vars.VarVersionsProcessor.setVarVersions(VarVersionsProcessor.java:68)
      //   at org.jetbrains.java.decompiler.modules.decompiler.vars.VarProcessor.setVarVersions(VarProcessor.java:47)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:227)
      //
      // Bytecode:
      // 0000: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.qq I
      // 0003: ifeq 0010
      // 0006: ldc_w -2147483648
      // 0009: invokestatic java/lang/Math.abs (I)I
      // 000c: pop
      // 000d: goto 0010
      // 0010: aload 2
      // 0011: getfield net/minecraft/n.x D
      // 0014: dstore 10
      // 0016: aload 2
      // 0017: getfield net/minecraft/n.y D
      // 001a: dstore 12
      // 001c: aload 2
      // 001d: getfield net/minecraft/n.z D
      // 0020: dstore 14
      // 0022: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.oz F
      // 0025: fstore 16
      // 0027: ldc_w 0.35
      // 002a: ldc_w 0.65
      // 002d: fload 16
      // 002f: fconst_0
      // 0030: fcmpg
      // 0031: ifge 0038
      // 0034: fconst_0
      // 0035: goto 0045
      // 0038: fload 16
      // 003a: fconst_1
      // 003b: fcmpl
      // 003c: ifle 0043
      // 003f: fconst_1
      // 0040: goto 0045
      // 0043: fload 16
      // 0045: fmul
      // 0046: fadd
      // 0047: fstore 17
      // 0049: ldc_w 0.62
      // 004c: ldc_w 0.38
      // 004f: fload 16
      // 0051: fconst_0
      // 0052: fcmpg
      // 0053: ifge 005a
      // 0056: fconst_0
      // 0057: goto 0067
      // 005a: fload 16
      // 005c: fconst_1
      // 005d: fcmpl
      // 005e: ifle 0065
      // 0061: fconst_1
      // 0062: goto 0067
      // 0065: fload 16
      // 0067: fmul
      // 0068: fadd
      // 0069: fstore 18
      // 006b: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.ow F
      // 006e: fstore 19
      // 0070: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.ox F
      // 0073: fstore 20
      // 0075: ldc_w 0.6
      // 0078: ldc_w 0.35
      // 007b: dload 4
      // 007d: ldc2_w 0.027
      // 0080: dmul
      // 0081: invokestatic net/minecraft/MathHelper.sin (D)F
      // 0084: fmul
      // 0085: fadd
      // 0086: fstore 21
      // 0088: fload 21
      // 008a: f2d
      // 008b: invokestatic net/minecraft/MathHelper.cos (D)F
      // 008e: fstore 22
      // 0090: fload 21
      // 0092: f2d
      // 0093: invokestatic net/minecraft/MathHelper.sin (D)F
      // 0096: fstore 23
      // 0098: fload 19
      // 009a: ldc_w 0.9
      // 009d: ldc_w 2.8
      // 00a0: fload 20
      // 00a2: fmul
      // 00a3: fadd
      // 00a4: fmul
      // 00a5: fstore 24
      // 00a7: fload 22
      // 00a9: fload 24
      // 00ab: fmul
      // 00ac: fstore 25
      // 00ae: fload 23
      // 00b0: fload 24
      // 00b2: fmul
      // 00b3: fstore 26
      // 00b5: fload 19
      // 00b7: ldc_w 0.35
      // 00ba: ldc_w 0.65
      // 00bd: fload 20
      // 00bf: fmul
      // 00c0: fadd
      // 00c1: fmul
      // 00c2: fstore 27
      // 00c4: fload 3
      // 00c5: fneg
      // 00c6: ldc_w 2.4
      // 00c9: fmul
      // 00ca: f2d
      // 00cb: invokestatic java/lang/Math.exp (D)D
      // 00ce: d2f
      // 00cf: fstore 28
      // 00d1: fload 3
      // 00d2: fneg
      // 00d3: fconst_2
      // 00d4: fmul
      // 00d5: f2d
      // 00d6: invokestatic java/lang/Math.exp (D)D
      // 00d9: d2f
      // 00da: fstore 29
      // 00dc: fload 3
      // 00dd: fneg
      // 00de: ldc_w 3.0
      // 00e1: fmul
      // 00e2: f2d
      // 00e3: invokestatic java/lang/Math.exp (D)D
      // 00e6: d2f
      // 00e7: fstore 30
      // 00e9: fconst_1
      // 00ea: fload 3
      // 00eb: fneg
      // 00ec: ldc_w 7.0
      // 00ef: fmul
      // 00f0: f2d
      // 00f1: invokestatic java/lang/Math.exp (D)D
      // 00f4: d2f
      // 00f5: fsub
      // 00f6: fstore 31
      // 00f8: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.nc F
      // 00fb: ldc_w 0.004
      // 00fe: fcmpg
      // 00ff: ifge 0111
      // 0102: aload 6
      // 0104: bipush 2
      // 0105: faload
      // 0106: ldc_w 0.02
      // 0109: fcmpg
      // 010a: ifgt 0111
      // 010d: bipush 1
      // 010e: goto 0112
      // 0111: bipush 0
      // 0112: istore 32
      // 0114: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.nd F
      // 0117: ldc_w 0.004
      // 011a: fcmpg
      // 011b: ifge 012d
      // 011e: aload 6
      // 0120: bipush 5
      // 0121: faload
      // 0122: ldc_w 0.02
      // 0125: fcmpg
      // 0126: ifgt 012d
      // 0129: bipush 1
      // 012a: goto 012e
      // 012d: bipush 0
      // 012e: istore 33
      // 0130: bipush 0
      // 0131: istore 34
      // 0133: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.ol F
      // 0136: fstore 35
      // 0138: aload 9
      // 013a: bipush 6
      // 013c: faload
      // 013d: fstore 36
      // 013f: aload 9
      // 0141: bipush 7
      // 0143: faload
      // 0144: fstore 37
      // 0146: aload 9
      // 0148: bipush 8
      // 014a: faload
      // 014b: fstore 38
      // 014d: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.qm Z
      // 0150: ifeq 015d
      // 0153: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.qn Z
      // 0156: ifeq 015d
      // 0159: bipush 1
      // 015a: goto 015e
      // 015d: bipush 0
      // 015e: istore 39
      // 0160: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.qj I
      // 0163: istore 40
      // 0165: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.qk I
      // 0168: istore 41
      // 016a: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.pt [F
      // 016d: astore 42
      // 016f: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.qa [F
      // 0172: astore 43
      // 0174: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.pv [F
      // 0177: astore 44
      // 0179: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.pw [F
      // 017c: astore 45
      // 017e: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.pu [B
      // 0181: astore 46
      // 0183: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.qb [B
      // 0186: astore 47
      // 0188: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.nh [I
      // 018b: astore 48
      // 018d: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.ob I
      // 0190: istore 49
      // 0192: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.oc Z
      // 0195: istore 50
      // 0197: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.od D
      // 019a: dstore 51
      // 019c: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.oe D
      // 019f: dstore 53
      // 01a1: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.of D
      // 01a4: dstore 55
      // 01a6: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.og D
      // 01a9: dstore 57
      // 01ab: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.or Z
      // 01ae: istore 59
      // 01b0: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.ou Z
      // 01b3: istore 60
      // 01b5: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.ot F
      // 01b8: fstore 61
      // 01ba: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.os F
      // 01bd: fstore 62
      // 01bf: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mu I
      // 01c2: istore 63
      // 01c4: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.nn [F
      // 01c7: astore 64
      // 01c9: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.no [F
      // 01cc: astore 65
      // 01ce: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.np [I
      // 01d1: astore 66
      // 01d3: dload 10
      // 01d5: ldc2_w 512.0
      // 01d8: ddiv
      // 01d9: invokestatic java/lang/Math.floor (D)D
      // 01dc: ldc2_w 512.0
      // 01df: dmul
      // 01e0: dstore 67
      // 01e2: dload 14
      // 01e4: ldc2_w 512.0
      // 01e7: ddiv
      // 01e8: invokestatic java/lang/Math.floor (D)D
      // 01eb: ldc2_w 512.0
      // 01ee: dmul
      // 01ef: dstore 69
      // 01f1: bipush 0
      // 01f2: istore 71
      // 01f4: bipush 0
      // 01f5: istore 72
      // 01f7: iload 72
      // 01f9: ldc_w 1801354544
      // 01fc: ldc_w 1801349696
      // 01ff: ixor
      // 0200: if_icmpge 17cc
      // 0203: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mt [B
      // 0206: iload 72
      // 0208: baload
      // 0209: istore 73
      // 020b: iload 73
      // 020d: ifne 0213
      // 0210: goto 17c6
      // 0213: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.lw [D
      // 0216: iload 72
      // 0218: daload
      // 0219: dstore 74
      // 021b: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.lx [D
      // 021e: iload 72
      // 0220: daload
      // 0221: dstore 76
      // 0223: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.ly [D
      // 0226: iload 72
      // 0228: daload
      // 0229: dstore 78
      // 022b: dload 74
      // 022d: dload 10
      // 022f: dsub
      // 0230: dstore 80
      // 0232: dload 78
      // 0234: dload 14
      // 0236: dsub
      // 0237: dstore 82
      // 0239: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mq [I
      // 023c: iload 72
      // 023e: iaload
      // 023f: bipush 8
      // 0241: if_icmplt 0248
      // 0244: bipush 1
      // 0245: goto 0249
      // 0248: bipush 0
      // 0249: istore 84
      // 024b: dload 80
      // 024d: dload 80
      // 024f: dmul
      // 0250: dload 82
      // 0252: dload 82
      // 0254: dmul
      // 0255: dadd
      // 0256: ldc2_w 676.0
      // 0259: dcmpl
      // 025a: ifgt 027b
      // 025d: dload 76
      // 025f: dload 12
      // 0261: ldc2_w 40.0
      // 0264: dsub
      // 0265: dcmpg
      // 0266: iflt 027b
      // 0269: iload 84
      // 026b: ifeq 0276
      // 026e: iload 33
      // 0270: ifeq 02a9
      // 0273: goto 027b
      // 0276: iload 32
      // 0278: ifeq 02a9
      // 027b: iload 73
      // 027d: bipush 1
      // 027e: if_icmpne 029f
      // 0281: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mr [I
      // 0284: iload 72
      // 0286: iaload
      // 0287: istore 85
      // 0289: iload 85
      // 028b: iflt 029f
      // 028e: aload 48
      // 0290: iload 85
      // 0292: iaload
      // 0293: ifle 029f
      // 0296: aload 48
      // 0298: iload 85
      // 029a: dup2
      // 029b: iaload
      // 029c: bipush 1
      // 029d: isub
      // 029e: iastore
      // 029f: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mt [B
      // 02a2: iload 72
      // 02a4: bipush 0
      // 02a5: bastore
      // 02a6: goto 17c6
      // 02a9: bipush -1
      // 02aa: istore 85
      // 02ac: ldc_w -1.0E9
      // 02af: fstore 86
      // 02b1: bipush 3
      // 02b2: istore 87
      // 02b4: iload 39
      // 02b6: ifeq 0349
      // 02b9: dload 74
      // 02bb: invokestatic net/minecraft/MathHelper.floor (D)I
      // 02be: istore 88
      // 02c0: dload 78
      // 02c2: invokestatic net/minecraft/MathHelper.floor (D)I
      // 02c5: istore 89
      // 02c7: iload 88
      // 02c9: iload 40
      // 02cb: isub
      // 02cc: bipush 24
      // 02ce: iadd
      // 02cf: istore 90
      // 02d1: iload 89
      // 02d3: iload 41
      // 02d5: isub
      // 02d6: bipush 24
      // 02d8: iadd
      // 02d9: istore 91
      // 02db: iload 90
      // 02dd: iflt 0349
      // 02e0: iload 91
      // 02e2: iflt 0349
      // 02e5: iload 90
      // 02e7: bipush 49
      // 02e9: if_icmpge 0349
      // 02ec: iload 91
      // 02ee: bipush 49
      // 02f0: if_icmpge 0349
      // 02f3: iload 91
      // 02f5: bipush 49
      // 02f7: imul
      // 02f8: iload 90
      // 02fa: iadd
      // 02fb: istore 85
      // 02fd: aload 46
      // 02ff: iload 85
      // 0301: baload
      // 0302: istore 87
      // 0304: iload 87
      // 0306: bipush 4
      // 0307: if_icmpne 0342
      // 030a: iload 85
      // 030c: bipush 6
      // 030e: ishl
      // 030f: dload 74
      // 0311: iload 88
      // 0313: i2d
      // 0314: dsub
      // 0315: ldc2_w 8.0
      // 0318: dmul
      // 0319: d2i
      // 031a: bipush 7
      // 031c: iand
      // 031d: bipush 3
      // 031e: ishl
      // 031f: ior
      // 0320: dload 78
      // 0322: iload 89
      // 0324: i2d
      // 0325: dsub
      // 0326: ldc2_w 8.0
      // 0329: dmul
      // 032a: d2i
      // 032b: bipush 7
      // 032d: iand
      // 032e: ior
      // 032f: istore 92
      // 0331: aload 43
      // 0333: iload 92
      // 0335: faload
      // 0336: fstore 86
      // 0338: aload 47
      // 033a: iload 92
      // 033c: baload
      // 033d: istore 87
      // 033f: goto 0349
      // 0342: aload 42
      // 0344: iload 85
      // 0346: faload
      // 0347: fstore 86
      // 0349: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mm [F
      // 034c: iload 72
      // 034e: faload
      // 034f: fstore 88
      // 0351: fconst_1
      // 0352: fstore 89
      // 0354: iload 73
      // 0356: bipush 2
      // 0357: if_icmpne 086e
      // 035a: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.lz [F
      // 035d: iload 72
      // 035f: faload
      // 0360: fstore 90
      // 0362: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.ma [F
      // 0365: iload 72
      // 0367: faload
      // 0368: fstore 91
      // 036a: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mb [F
      // 036d: iload 72
      // 036f: faload
      // 0370: fstore 92
      // 0372: iload 84
      // 0374: ifeq 037c
      // 0377: fload 29
      // 0379: goto 037e
      // 037c: fload 28
      // 037e: fstore 93
      // 0380: iload 84
      // 0382: ifeq 038b
      // 0385: ldc_w 0.8
      // 0388: goto 038e
      // 038b: ldc_w 1.1
      // 038e: fstore 94
      // 0390: fload 91
      // 0392: iload 84
      // 0394: ifeq 039d
      // 0397: ldc_w 5.2
      // 039a: goto 03a0
      // 039d: ldc_w 4.2
      // 03a0: fload 3
      // 03a1: fmul
      // 03a2: fsub
      // 03a3: fload 30
      // 03a5: fmul
      // 03a6: fstore 91
      // 03a8: fload 25
      // 03aa: fload 90
      // 03ac: fload 25
      // 03ae: fsub
      // 03af: fload 93
      // 03b1: fmul
      // 03b2: fadd
      // 03b3: dload 4
      // 03b5: ldc2_w 5.3
      // 03b8: dmul
      // 03b9: fload 88
      // 03bb: ldc_w 31.0
      // 03be: fmul
      // 03bf: f2d
      // 03c0: dadd
      // 03c1: invokestatic net/minecraft/MathHelper.sin (D)F
      // 03c4: fload 94
      // 03c6: fmul
      // 03c7: fload 3
      // 03c8: fmul
      // 03c9: fadd
      // 03ca: fstore 90
      // 03cc: fload 26
      // 03ce: fload 92
      // 03d0: fload 26
      // 03d2: fsub
      // 03d3: fload 93
      // 03d5: fmul
      // 03d6: fadd
      // 03d7: dload 4
      // 03d9: ldc2_w 4.7
      // 03dc: dmul
      // 03dd: fload 88
      // 03df: ldc_w 17.0
      // 03e2: fmul
      // 03e3: f2d
      // 03e4: dadd
      // 03e5: invokestatic net/minecraft/MathHelper.cos (D)F
      // 03e8: fload 94
      // 03ea: fmul
      // 03eb: fload 3
      // 03ec: fmul
      // 03ed: fadd
      // 03ee: fstore 92
      // 03f0: iload 50
      // 03f2: ifeq 041a
      // 03f5: dload 74
      // 03f7: dload 51
      // 03f9: dcmpl
      // 03fa: iflt 041a
      // 03fd: dload 74
      // 03ff: dload 53
      // 0401: dcmpg
      // 0402: ifgt 041a
      // 0405: dload 78
      // 0407: dload 55
      // 0409: dcmpl
      // 040a: iflt 041a
      // 040d: dload 78
      // 040f: dload 57
      // 0411: dcmpg
      // 0412: ifgt 041a
      // 0415: iload 49
      // 0417: goto 041b
      // 041a: bipush 0
      // 041b: istore 95
      // 041d: bipush 0
      // 041e: istore 96
      // 0420: iload 96
      // 0422: iload 95
      // 0424: if_icmpge 0521
      // 0427: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.oa [F
      // 042a: iload 96
      // 042c: faload
      // 042d: fstore 97
      // 042f: fload 97
      // 0431: fconst_0
      // 0432: fcmpg
      // 0433: ifgt 0439
      // 0436: goto 051b
      // 0439: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.ny [F
      // 043c: iload 96
      // 043e: faload
      // 043f: ldc_w 0.5
      // 0442: fadd
      // 0443: fstore 98
      // 0445: dload 74
      // 0447: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.nt [D
      // 044a: iload 96
      // 044c: daload
      // 044d: dsub
      // 044e: d2f
      // 044f: fstore 99
      // 0451: dload 78
      // 0453: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.nv [D
      // 0456: iload 96
      // 0458: daload
      // 0459: dsub
      // 045a: d2f
      // 045b: fstore 100
      // 045d: fload 99
      // 045f: fload 98
      // 0461: fcmpl
      // 0462: ifgt 051b
      // 0465: fload 99
      // 0467: fload 98
      // 0469: fneg
      // 046a: fcmpg
      // 046b: iflt 051b
      // 046e: fload 100
      // 0470: fload 98
      // 0472: fcmpl
      // 0473: ifgt 051b
      // 0476: fload 100
      // 0478: fload 98
      // 047a: fneg
      // 047b: fcmpg
      // 047c: ifge 0482
      // 047f: goto 051b
      // 0482: dload 76
      // 0484: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.nu [D
      // 0487: iload 96
      // 0489: daload
      // 048a: dsub
      // 048b: d2f
      // 048c: fstore 101
      // 048e: fload 101
      // 0490: ldc_w -0.5
      // 0493: fcmpg
      // 0494: iflt 051b
      // 0497: fload 101
      // 0499: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.nz [F
      // 049c: iload 96
      // 049e: faload
      // 049f: fcmpl
      // 04a0: ifle 04a6
      // 04a3: goto 051b
      // 04a6: fload 99
      // 04a8: fload 99
      // 04aa: fmul
      // 04ab: fload 100
      // 04ad: fload 100
      // 04af: fmul
      // 04b0: fadd
      // 04b1: fstore 102
      // 04b3: fload 102
      // 04b5: fload 98
      // 04b7: fload 98
      // 04b9: fmul
      // 04ba: fcmpl
      // 04bb: iflt 04c1
      // 04be: goto 051b
      // 04c1: fload 102
      // 04c3: invokestatic net/minecraft/MathHelper.sqrt (F)F
      // 04c6: ldc_w 0.001
      // 04c9: fadd
      // 04ca: fstore 103
      // 04cc: fconst_1
      // 04cd: fload 103
      // 04cf: fload 98
      // 04d1: fdiv
      // 04d2: fsub
      // 04d3: fload 97
      // 04d5: fmul
      // 04d6: fload 3
      // 04d7: fmul
      // 04d8: fstore 104
      // 04da: fload 90
      // 04dc: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.nw [F
      // 04df: iload 96
      // 04e1: faload
      // 04e2: ldc_w 1.6
      // 04e5: fmul
      // 04e6: fload 99
      // 04e8: fload 103
      // 04ea: fdiv
      // 04eb: ldc_w 4.5
      // 04ee: fmul
      // 04ef: fadd
      // 04f0: fload 104
      // 04f2: fmul
      // 04f3: fadd
      // 04f4: fstore 90
      // 04f6: fload 92
      // 04f8: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.nx [F
      // 04fb: iload 96
      // 04fd: faload
      // 04fe: ldc_w 1.6
      // 0501: fmul
      // 0502: fload 100
      // 0504: fload 103
      // 0506: fdiv
      // 0507: ldc_w 4.5
      // 050a: fmul
      // 050b: fadd
      // 050c: fload 104
      // 050e: fmul
      // 050f: fadd
      // 0510: fstore 92
      // 0512: fload 91
      // 0514: fconst_2
      // 0515: fload 104
      // 0517: fmul
      // 0518: fadd
      // 0519: fstore 91
      // 051b: iinc 96 1
      // 051e: goto 0420
      // 0521: dload 74
      // 0523: fload 90
      // 0525: fload 3
      // 0526: fmul
      // 0527: f2d
      // 0528: dadd
      // 0529: dstore 96
      // 052b: dload 76
      // 052d: fload 91
      // 052f: fload 3
      // 0530: fmul
      // 0531: f2d
      // 0532: dadd
      // 0533: dstore 98
      // 0535: dload 78
      // 0537: fload 92
      // 0539: fload 3
      // 053a: fmul
      // 053b: f2d
      // 053c: dadd
      // 053d: dstore 100
      // 053f: ldc_w -1.0E9
      // 0542: fstore 102
      // 0544: bipush 3
      // 0545: istore 103
      // 0547: iload 39
      // 0549: ifeq 05dc
      // 054c: dload 96
      // 054e: invokestatic net/minecraft/MathHelper.floor (D)I
      // 0551: istore 104
      // 0553: dload 100
      // 0555: invokestatic net/minecraft/MathHelper.floor (D)I
      // 0558: istore 105
      // 055a: iload 104
      // 055c: iload 40
      // 055e: isub
      // 055f: bipush 24
      // 0561: iadd
      // 0562: istore 106
      // 0564: iload 105
      // 0566: iload 41
      // 0568: isub
      // 0569: bipush 24
      // 056b: iadd
      // 056c: istore 107
      // 056e: iload 106
      // 0570: iflt 05dc
      // 0573: iload 107
      // 0575: iflt 05dc
      // 0578: iload 106
      // 057a: bipush 49
      // 057c: if_icmpge 05dc
      // 057f: iload 107
      // 0581: bipush 49
      // 0583: if_icmpge 05dc
      // 0586: iload 107
      // 0588: bipush 49
      // 058a: imul
      // 058b: iload 106
      // 058d: iadd
      // 058e: istore 108
      // 0590: aload 46
      // 0592: iload 108
      // 0594: baload
      // 0595: istore 103
      // 0597: iload 103
      // 0599: bipush 4
      // 059a: if_icmpne 05d5
      // 059d: iload 108
      // 059f: bipush 6
      // 05a1: ishl
      // 05a2: dload 96
      // 05a4: iload 104
      // 05a6: i2d
      // 05a7: dsub
      // 05a8: ldc2_w 8.0
      // 05ab: dmul
      // 05ac: d2i
      // 05ad: bipush 7
      // 05af: iand
      // 05b0: bipush 3
      // 05b1: ishl
      // 05b2: ior
      // 05b3: dload 100
      // 05b5: iload 105
      // 05b7: i2d
      // 05b8: dsub
      // 05b9: ldc2_w 8.0
      // 05bc: dmul
      // 05bd: d2i
      // 05be: bipush 7
      // 05c0: iand
      // 05c1: ior
      // 05c2: istore 109
      // 05c4: aload 43
      // 05c6: iload 109
      // 05c8: faload
      // 05c9: fstore 102
      // 05cb: aload 47
      // 05cd: iload 109
      // 05cf: baload
      // 05d0: istore 103
      // 05d2: goto 05dc
      // 05d5: aload 42
      // 05d7: iload 108
      // 05d9: faload
      // 05da: fstore 102
      // 05dc: fload 102
      // 05de: fload 86
      // 05e0: ldc_w 0.05
      // 05e3: fadd
      // 05e4: fcmpl
      // 05e5: ifle 0615
      // 05e8: fload 102
      // 05ea: f2d
      // 05eb: dload 98
      // 05ed: ldc2_w 0.05000000074505806
      // 05f0: dadd
      // 05f1: dcmpl
      // 05f2: ifle 0615
      // 05f5: dload 74
      // 05f7: dstore 96
      // 05f9: dload 78
      // 05fb: dstore 100
      // 05fd: fload 90
      // 05ff: ldc_w -0.3
      // 0602: fmul
      // 0603: fstore 90
      // 0605: fload 92
      // 0607: ldc_w -0.3
      // 060a: fmul
      // 060b: fstore 92
      // 060d: fload 86
      // 060f: fstore 102
      // 0611: iload 87
      // 0613: istore 103
      // 0615: fload 102
      // 0617: fstore 104
      // 0619: iload 103
      // 061b: ifne 0662
      // 061e: dload 96
      // 0620: ldc2_w 2.0
      // 0623: dmul
      // 0624: invokestatic net/minecraft/MathHelper.floor (D)I
      // 0627: bipush 127
      // 0629: iand
      // 062a: bipush 7
      // 062c: ishl
      // 062d: dload 100
      // 062f: ldc2_w 2.0
      // 0632: dmul
      // 0633: invokestatic net/minecraft/MathHelper.floor (D)I
      // 0636: bipush 127
      // 0638: iand
      // 0639: ior
      // 063a: istore 105
      // 063c: aload 48
      // 063e: iload 105
      // 0640: iaload
      // 0641: istore 106
      // 0643: fload 102
      // 0645: ldc_w 0.014
      // 0648: fadd
      // 0649: iload 106
      // 064b: bipush 36
      // 064d: if_icmple 0655
      // 0650: bipush 36
      // 0652: goto 0657
      // 0655: iload 106
      // 0657: i2f
      // 0658: ldc_w 0.0042
      // 065b: fmul
      // 065c: fadd
      // 065d: fstore 104
      // 065f: goto 0670
      // 0662: iload 103
      // 0664: bipush 1
      // 0665: if_icmpne 0670
      // 0668: fload 102
      // 066a: ldc_w 0.02
      // 066d: fadd
      // 066e: fstore 104
      // 0670: iload 84
      // 0672: ifeq 067b
      // 0675: ldc_w 0.5
      // 0678: goto 067e
      // 067b: ldc_w 0.4
      // 067e: fstore 107
      // 0680: dload 98
      // 0682: fload 104
      // 0684: f2d
      // 0685: dsub
      // 0686: fload 107
      // 0688: f2d
      // 0689: dcmpg
      // 068a: ifge 0745
      // 068d: fload 91
      // 068f: fconst_0
      // 0690: fcmpg
      // 0691: ifge 0745
      // 0694: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mh [F
      // 0697: iload 72
      // 0699: faload
      // 069a: fstore 105
      // 069c: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mi [F
      // 069f: iload 72
      // 06a1: faload
      // 06a2: fstore 106
      // 06a4: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mj [F
      // 06a7: iload 72
      // 06a9: fconst_0
      // 06aa: fastore
      // 06ab: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mk [F
      // 06ae: iload 72
      // 06b0: fconst_0
      // 06b1: fastore
      // 06b2: iload 84
      // 06b4: ifeq 06da
      // 06b7: fload 105
      // 06b9: ldc_w 0.31830987
      // 06bc: fmul
      // 06bd: invokestatic java/lang/Math.round (F)I
      // 06c0: i2f
      // 06c1: ldc_w 3.1415927
      // 06c4: fmul
      // 06c5: fstore 108
      // 06c7: fload 106
      // 06c9: ldc_w 0.31830987
      // 06cc: fmul
      // 06cd: invokestatic java/lang/Math.round (F)I
      // 06d0: i2f
      // 06d1: ldc_w 3.1415927
      // 06d4: fmul
      // 06d5: fstore 109
      // 06d7: goto 06f8
      // 06da: fload 105
      // 06dc: ldc_w 0.15915494
      // 06df: fmul
      // 06e0: invokestatic java/lang/Math.round (F)I
      // 06e3: i2f
      // 06e4: ldc 6.2831855
      // 06e6: fmul
      // 06e7: fstore 108
      // 06e9: fload 106
      // 06eb: ldc_w 0.15915494
      // 06ee: fmul
      // 06ef: invokestatic java/lang/Math.round (F)I
      // 06f2: i2f
      // 06f3: ldc 6.2831855
      // 06f5: fmul
      // 06f6: fstore 109
      // 06f8: dload 98
      // 06fa: fload 104
      // 06fc: f2d
      // 06fd: dsub
      // 06fe: dload 76
      // 0700: fload 104
      // 0702: f2d
      // 0703: dsub
      // 0704: ldc2_w 0.001
      // 0707: invokestatic java/lang/Math.max (DD)D
      // 070a: ddiv
      // 070b: d2f
      // 070c: fstore 110
      // 070e: fload 110
      // 0710: fconst_0
      // 0711: fcmpg
      // 0712: ifge 0719
      // 0715: fconst_0
      // 0716: goto 0726
      // 0719: fload 110
      // 071b: fconst_1
      // 071c: fcmpl
      // 071d: ifle 0724
      // 0720: fconst_1
      // 0721: goto 0726
      // 0724: fload 110
      // 0726: fstore 110
      // 0728: fload 108
      // 072a: fload 105
      // 072c: fload 108
      // 072e: fsub
      // 072f: fload 110
      // 0731: fmul
      // 0732: fadd
      // 0733: fstore 105
      // 0735: fload 109
      // 0737: fload 106
      // 0739: fload 109
      // 073b: fsub
      // 073c: fload 110
      // 073e: fmul
      // 073f: fadd
      // 0740: fstore 106
      // 0742: goto 0767
      // 0745: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mh [F
      // 0748: iload 72
      // 074a: faload
      // 074b: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mj [F
      // 074e: iload 72
      // 0750: faload
      // 0751: fload 3
      // 0752: fmul
      // 0753: fadd
      // 0754: fstore 105
      // 0756: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mi [F
      // 0759: iload 72
      // 075b: faload
      // 075c: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mk [F
      // 075f: iload 72
      // 0761: faload
      // 0762: fload 3
      // 0763: fmul
      // 0764: fadd
      // 0765: fstore 106
      // 0767: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mh [F
      // 076a: iload 72
      // 076c: fload 105
      // 076e: fastore
      // 076f: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mi [F
      // 0772: iload 72
      // 0774: fload 106
      // 0776: fastore
      // 0777: iload 103
      // 0779: bipush 2
      // 077a: if_icmpgt 082f
      // 077d: dload 98
      // 077f: fload 104
      // 0781: f2d
      // 0782: dcmpg
      // 0783: ifgt 082f
      // 0786: fload 91
      // 0788: fconst_0
      // 0789: fcmpg
      // 078a: ifgt 082f
      // 078d: iload 103
      // 078f: bipush 2
      // 0790: if_icmpne 079d
      // 0793: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mt [B
      // 0796: iload 72
      // 0798: bipush 0
      // 0799: bastore
      // 079a: goto 17c6
      // 079d: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.lw [D
      // 07a0: iload 72
      // 07a2: dload 96
      // 07a4: dastore
      // 07a5: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.ly [D
      // 07a8: iload 72
      // 07aa: dload 100
      // 07ac: dastore
      // 07ad: fload 105
      // 07af: ldc_w 0.31830987
      // 07b2: fmul
      // 07b3: invokestatic java/lang/Math.round (F)I
      // 07b6: istore 108
      // 07b8: fload 106
      // 07ba: ldc_w 0.31830987
      // 07bd: fmul
      // 07be: invokestatic java/lang/Math.round (F)I
      // 07c1: istore 109
      // 07c3: iload 72
      // 07c5: fload 102
      // 07c7: f2d
      // 07c8: iload 103
      // 07ca: invokestatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.as (IDI)V
      // 07cd: iload 84
      // 07cf: ifeq 07fc
      // 07d2: iload 108
      // 07d4: bipush 1
      // 07d5: iand
      // 07d6: ifeq 07e5
      // 07d9: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mc [F
      // 07dc: iload 72
      // 07de: dup2
      // 07df: faload
      // 07e0: ldc_w 3.1415927
      // 07e3: fadd
      // 07e4: fastore
      // 07e5: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mi [F
      // 07e8: iload 72
      // 07ea: iload 108
      // 07ec: iload 109
      // 07ee: iadd
      // 07ef: bipush 1
      // 07f0: iand
      // 07f1: ifeq 07fa
      // 07f4: ldc_w 3.1415927
      // 07f7: goto 07fb
      // 07fa: fconst_0
      // 07fb: fastore
      // 07fc: dload 96
      // 07fe: dstore 74
      // 0800: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.lx [D
      // 0803: iload 72
      // 0805: daload
      // 0806: dstore 76
      // 0808: dload 100
      // 080a: dstore 78
      // 080c: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mt [B
      // 080f: iload 72
      // 0811: baload
      // 0812: istore 73
      // 0814: dload 76
      // 0816: fload 102
      // 0818: f2d
      // 0819: dsub
      // 081a: d2f
      // 081b: ldc_w 0.003
      // 081e: fsub
      // 081f: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mf [F
      // 0822: iload 72
      // 0824: faload
      // 0825: ldc_w 1.42
      // 0828: fmul
      // 0829: fdiv
      // 082a: fstore 89
      // 082c: goto 086b
      // 082f: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.lw [D
      // 0832: iload 72
      // 0834: dload 96
      // 0836: dastore
      // 0837: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.lx [D
      // 083a: iload 72
      // 083c: dload 98
      // 083e: dastore
      // 083f: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.ly [D
      // 0842: iload 72
      // 0844: dload 100
      // 0846: dastore
      // 0847: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.lz [F
      // 084a: iload 72
      // 084c: fload 90
      // 084e: fastore
      // 084f: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.ma [F
      // 0852: iload 72
      // 0854: fload 91
      // 0856: fastore
      // 0857: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mb [F
      // 085a: iload 72
      // 085c: fload 92
      // 085e: fastore
      // 085f: dload 96
      // 0861: dstore 74
      // 0863: dload 98
      // 0865: dstore 76
      // 0867: dload 100
      // 0869: dstore 78
      // 086b: goto 10b4
      // 086e: iload 85
      // 0870: iflt 08fe
      // 0873: fload 86
      // 0875: f2d
      // 0876: dload 76
      // 0878: ldc2_w 0.05999999865889549
      // 087b: dadd
      // 087c: dcmpl
      // 087d: ifle 08ae
      // 0880: iload 73
      // 0882: bipush 1
      // 0883: if_icmpne 08a4
      // 0886: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mr [I
      // 0889: iload 72
      // 088b: iaload
      // 088c: istore 90
      // 088e: iload 90
      // 0890: iflt 08a4
      // 0893: aload 48
      // 0895: iload 90
      // 0897: iaload
      // 0898: ifle 08a4
      // 089b: aload 48
      // 089d: iload 90
      // 089f: dup2
      // 08a0: iaload
      // 08a1: bipush 1
      // 08a2: isub
      // 08a3: iastore
      // 08a4: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mt [B
      // 08a7: iload 72
      // 08a9: bipush 0
      // 08aa: bastore
      // 08ab: goto 17c6
      // 08ae: fload 86
      // 08b0: f2d
      // 08b1: dload 76
      // 08b3: ldc2_w 0.44999998807907104
      // 08b6: dsub
      // 08b7: dcmpg
      // 08b8: ifge 08fe
      // 08bb: iload 73
      // 08bd: bipush 1
      // 08be: if_icmpne 08df
      // 08c1: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mr [I
      // 08c4: iload 72
      // 08c6: iaload
      // 08c7: istore 90
      // 08c9: iload 90
      // 08cb: iflt 08df
      // 08ce: aload 48
      // 08d0: iload 90
      // 08d2: iaload
      // 08d3: ifle 08df
      // 08d6: aload 48
      // 08d8: iload 90
      // 08da: dup2
      // 08db: iaload
      // 08dc: bipush 1
      // 08dd: isub
      // 08de: iastore
      // 08df: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mt [B
      // 08e2: iload 72
      // 08e4: bipush 2
      // 08e5: bastore
      // 08e6: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.lz [F
      // 08e9: iload 72
      // 08eb: fconst_0
      // 08ec: fastore
      // 08ed: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.ma [F
      // 08f0: iload 72
      // 08f2: fconst_0
      // 08f3: fastore
      // 08f4: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mb [F
      // 08f7: iload 72
      // 08f9: fconst_0
      // 08fa: fastore
      // 08fb: bipush 2
      // 08fc: istore 73
      // 08fe: iload 73
      // 0900: bipush 1
      // 0901: if_icmpne 0c8e
      // 0904: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mr [I
      // 0907: iload 72
      // 0909: iaload
      // 090a: istore 90
      // 090c: iload 90
      // 090e: iflt 0919
      // 0911: aload 48
      // 0913: iload 90
      // 0915: iaload
      // 0916: goto 091a
      // 0919: bipush 1
      // 091a: istore 91
      // 091c: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.ms [I
      // 091f: iload 72
      // 0921: iaload
      // 0922: istore 92
      // 0924: iload 92
      // 0926: iload 91
      // 0928: bipush 1
      // 0929: isub
      // 092a: if_icmple 0933
      // 092d: iload 91
      // 092f: bipush 1
      // 0930: isub
      // 0931: istore 92
      // 0933: iload 92
      // 0935: ifge 093b
      // 0938: bipush 0
      // 0939: istore 92
      // 093b: iload 85
      // 093d: iflt 0976
      // 0940: dload 76
      // 0942: fload 86
      // 0944: ldc_w 0.014
      // 0947: fadd
      // 0948: iload 92
      // 094a: i2f
      // 094b: ldc_w 0.0042
      // 094e: fmul
      // 094f: fadd
      // 0950: f2d
      // 0951: dload 76
      // 0953: dsub
      // 0954: fload 31
      // 0956: f2d
      // 0957: dmul
      // 0958: dadd
      // 0959: dstore 76
      // 095b: dload 76
      // 095d: fload 86
      // 095f: f2d
      // 0960: dsub
      // 0961: d2f
      // 0962: ldc_w 0.003
      // 0965: fsub
      // 0966: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mf [F
      // 0969: iload 72
      // 096b: faload
      // 096c: ldc_w 1.42
      // 096f: fmul
      // 0970: fdiv
      // 0971: fstore 89
      // 0973: goto 097b
      // 0976: ldc_w 0.03
      // 0979: fstore 89
      // 097b: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.ml [F
      // 097e: iload 72
      // 0980: faload
      // 0981: fstore 93
      // 0983: fload 27
      // 0985: ldc_w 0.02
      // 0988: fcmpl
      // 0989: ifle 0c73
      // 098c: iload 85
      // 098e: iflt 0c73
      // 0991: fload 93
      // 0993: fload 27
      // 0995: fcmpg
      // 0996: ifge 0c73
      // 0999: dload 74
      // 099b: dload 67
      // 099d: dsub
      // 099e: d2f
      // 099f: fstore 94
      // 09a1: dload 78
      // 09a3: dload 69
      // 09a5: dsub
      // 09a6: d2f
      // 09a7: fstore 95
      // 09a9: fload 27
      // 09ab: ldc_w 0.55
      // 09ae: ldc_w 0.45
      // 09b1: fload 94
      // 09b3: ldc_w 0.23
      // 09b6: fmul
      // 09b7: f2d
      // 09b8: dload 4
      // 09ba: ldc2_w 1.7
      // 09bd: dmul
      // 09be: dadd
      // 09bf: ldc_w 1.3
      // 09c2: fload 95
      // 09c4: ldc_w 0.19
      // 09c7: fmul
      // 09c8: f2d
      // 09c9: dload 4
      // 09cb: ldc2_w 0.8
      // 09ce: dmul
      // 09cf: dsub
      // 09d0: invokestatic net/minecraft/MathHelper.sin (D)F
      // 09d3: fmul
      // 09d4: f2d
      // 09d5: dadd
      // 09d6: invokestatic net/minecraft/MathHelper.sin (D)F
      // 09d9: fmul
      // 09da: fadd
      // 09db: fmul
      // 09dc: fstore 96
      // 09de: fload 96
      // 09e0: fload 93
      // 09e2: fsub
      // 09e3: fstore 97
      // 09e5: fload 97
      // 09e7: fconst_0
      // 09e8: fcmpl
      // 09e9: ifle 0c73
      // 09ec: fload 97
      // 09ee: iload 84
      // 09f0: ifeq 09f9
      // 09f3: ldc_w 3.1
      // 09f6: goto 09fc
      // 09f9: ldc_w 2.6
      // 09fc: fmul
      // 09fd: fstore 98
      // 09ff: dload 74
      // 0a01: fload 22
      // 0a03: fload 98
      // 0a05: fmul
      // 0a06: fload 3
      // 0a07: fmul
      // 0a08: f2d
      // 0a09: dadd
      // 0a0a: dstore 99
      // 0a0c: dload 78
      // 0a0e: fload 23
      // 0a10: fload 98
      // 0a12: fmul
      // 0a13: fload 3
      // 0a14: fmul
      // 0a15: f2d
      // 0a16: dadd
      // 0a17: dstore 101
      // 0a19: ldc_w -1.0E9
      // 0a1c: fstore 103
      // 0a1e: bipush 3
      // 0a1f: istore 104
      // 0a21: dload 99
      // 0a23: invokestatic net/minecraft/MathHelper.floor (D)I
      // 0a26: istore 105
      // 0a28: dload 101
      // 0a2a: invokestatic net/minecraft/MathHelper.floor (D)I
      // 0a2d: istore 106
      // 0a2f: iload 105
      // 0a31: iload 40
      // 0a33: isub
      // 0a34: bipush 24
      // 0a36: iadd
      // 0a37: istore 107
      // 0a39: iload 106
      // 0a3b: iload 41
      // 0a3d: isub
      // 0a3e: bipush 24
      // 0a40: iadd
      // 0a41: istore 108
      // 0a43: iload 107
      // 0a45: iflt 0ab1
      // 0a48: iload 108
      // 0a4a: iflt 0ab1
      // 0a4d: iload 107
      // 0a4f: bipush 49
      // 0a51: if_icmpge 0ab1
      // 0a54: iload 108
      // 0a56: bipush 49
      // 0a58: if_icmpge 0ab1
      // 0a5b: iload 108
      // 0a5d: bipush 49
      // 0a5f: imul
      // 0a60: iload 107
      // 0a62: iadd
      // 0a63: istore 109
      // 0a65: aload 46
      // 0a67: iload 109
      // 0a69: baload
      // 0a6a: istore 104
      // 0a6c: iload 104
      // 0a6e: bipush 4
      // 0a6f: if_icmpne 0aaa
      // 0a72: iload 109
      // 0a74: bipush 6
      // 0a76: ishl
      // 0a77: dload 99
      // 0a79: iload 105
      // 0a7b: i2d
      // 0a7c: dsub
      // 0a7d: ldc2_w 8.0
      // 0a80: dmul
      // 0a81: d2i
      // 0a82: bipush 7
      // 0a84: iand
      // 0a85: bipush 3
      // 0a86: ishl
      // 0a87: ior
      // 0a88: dload 101
      // 0a8a: iload 106
      // 0a8c: i2d
      // 0a8d: dsub
      // 0a8e: ldc2_w 8.0
      // 0a91: dmul
      // 0a92: d2i
      // 0a93: bipush 7
      // 0a95: iand
      // 0a96: ior
      // 0a97: istore 110
      // 0a99: aload 43
      // 0a9b: iload 110
      // 0a9d: faload
      // 0a9e: fstore 103
      // 0aa0: aload 47
      // 0aa2: iload 110
      // 0aa4: baload
      // 0aa5: istore 104
      // 0aa7: goto 0ab1
      // 0aaa: aload 42
      // 0aac: iload 109
      // 0aae: faload
      // 0aaf: fstore 103
      // 0ab1: iload 104
      // 0ab3: bipush 2
      // 0ab4: if_icmpge 0c73
      // 0ab7: fload 103
      // 0ab9: f2d
      // 0aba: dload 76
      // 0abc: ldc2_w 0.05000000074505806
      // 0abf: dadd
      // 0ac0: dcmpl
      // 0ac1: ifle 0ac7
      // 0ac4: goto 0c73
      // 0ac7: fload 103
      // 0ac9: fload 86
      // 0acb: ldc_w 0.3
      // 0ace: fsub
      // 0acf: fcmpg
      // 0ad0: iflt 0ad9
      // 0ad3: iload 104
      // 0ad5: bipush 1
      // 0ad6: if_icmpne 0b23
      // 0ad9: iload 90
      // 0adb: iflt 0aef
      // 0ade: aload 48
      // 0ae0: iload 90
      // 0ae2: iaload
      // 0ae3: ifle 0aef
      // 0ae6: aload 48
      // 0ae8: iload 90
      // 0aea: dup2
      // 0aeb: iaload
      // 0aec: bipush 1
      // 0aed: isub
      // 0aee: iastore
      // 0aef: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mt [B
      // 0af2: iload 72
      // 0af4: bipush 2
      // 0af5: bastore
      // 0af6: bipush 2
      // 0af7: istore 73
      // 0af9: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.lz [F
      // 0afc: iload 72
      // 0afe: fload 22
      // 0b00: fload 98
      // 0b02: fmul
      // 0b03: fastore
      // 0b04: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mb [F
      // 0b07: iload 72
      // 0b09: fload 23
      // 0b0b: fload 98
      // 0b0d: fmul
      // 0b0e: fastore
      // 0b0f: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.ma [F
      // 0b12: iload 72
      // 0b14: ldc_w 0.2
      // 0b17: fastore
      // 0b18: dload 99
      // 0b1a: dstore 74
      // 0b1c: dload 101
      // 0b1e: dstore 78
      // 0b20: goto 0c73
      // 0b23: dload 99
      // 0b25: ldc2_w 2.0
      // 0b28: dmul
      // 0b29: invokestatic net/minecraft/MathHelper.floor (D)I
      // 0b2c: bipush 127
      // 0b2e: iand
      // 0b2f: bipush 7
      // 0b31: ishl
      // 0b32: dload 101
      // 0b34: ldc2_w 2.0
      // 0b37: dmul
      // 0b38: invokestatic net/minecraft/MathHelper.floor (D)I
      // 0b3b: bipush 127
      // 0b3d: iand
      // 0b3e: ior
      // 0b3f: istore 109
      // 0b41: iload 109
      // 0b43: iload 90
      // 0b45: if_icmpeq 0b86
      // 0b48: iload 90
      // 0b4a: iflt 0b5e
      // 0b4d: aload 48
      // 0b4f: iload 90
      // 0b51: iaload
      // 0b52: ifle 0b5e
      // 0b55: aload 48
      // 0b57: iload 90
      // 0b59: dup2
      // 0b5a: iaload
      // 0b5b: bipush 1
      // 0b5c: isub
      // 0b5d: iastore
      // 0b5e: aload 48
      // 0b60: iload 109
      // 0b62: dup2
      // 0b63: iaload
      // 0b64: dup_x2
      // 0b65: bipush 1
      // 0b66: iadd
      // 0b67: iastore
      // 0b68: istore 110
      // 0b6a: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.ms [I
      // 0b6d: iload 72
      // 0b6f: iload 110
      // 0b71: bipush 36
      // 0b73: if_icmple 0b7b
      // 0b76: bipush 36
      // 0b78: goto 0b7d
      // 0b7b: iload 110
      // 0b7d: iastore
      // 0b7e: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mr [I
      // 0b81: iload 72
      // 0b83: iload 109
      // 0b85: iastore
      // 0b86: dload 99
      // 0b88: dstore 74
      // 0b8a: dload 101
      // 0b8c: dstore 78
      // 0b8e: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mc [F
      // 0b91: iload 72
      // 0b93: dup2
      // 0b94: faload
      // 0b95: fload 88
      // 0b97: ldc_w 0.5
      // 0b9a: fsub
      // 0b9b: fload 98
      // 0b9d: fmul
      // 0b9e: fload 3
      // 0b9f: fmul
      // 0ba0: iload 84
      // 0ba2: ifeq 0bab
      // 0ba5: ldc_w 4.5
      // 0ba8: goto 0bae
      // 0bab: ldc_w 3.0
      // 0bae: fmul
      // 0baf: fadd
      // 0bb0: fastore
      // 0bb1: fload 97
      // 0bb3: iload 84
      // 0bb5: ifeq 0bbe
      // 0bb8: ldc_w 0.22
      // 0bbb: goto 0bc1
      // 0bbe: ldc_w 0.3
      // 0bc1: fcmpl
      // 0bc2: ifle 0c73
      // 0bc5: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.ed Ljava/util/Random;
      // 0bc8: invokevirtual java/util/Random.nextFloat ()F
      // 0bcb: fload 97
      // 0bcd: iload 84
      // 0bcf: ifeq 0bd8
      // 0bd2: ldc_w 1.3
      // 0bd5: goto 0bdb
      // 0bd8: ldc_w 0.8
      // 0bdb: fmul
      // 0bdc: fload 3
      // 0bdd: fmul
      // 0bde: fcmpg
      // 0bdf: ifge 0c73
      // 0be2: aload 48
      // 0be4: iload 109
      // 0be6: iaload
      // 0be7: ifle 0bf3
      // 0bea: aload 48
      // 0bec: iload 109
      // 0bee: dup2
      // 0bef: iaload
      // 0bf0: bipush 1
      // 0bf1: isub
      // 0bf2: iastore
      // 0bf3: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mt [B
      // 0bf6: iload 72
      // 0bf8: bipush 2
      // 0bf9: bastore
      // 0bfa: bipush 2
      // 0bfb: istore 73
      // 0bfd: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.lz [F
      // 0c00: iload 72
      // 0c02: fload 22
      // 0c04: fload 98
      // 0c06: fmul
      // 0c07: ldc_w 1.5
      // 0c0a: fmul
      // 0c0b: fastore
      // 0c0c: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mb [F
      // 0c0f: iload 72
      // 0c11: fload 23
      // 0c13: fload 98
      // 0c15: fmul
      // 0c16: ldc_w 1.5
      // 0c19: fmul
      // 0c1a: fastore
      // 0c1b: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.ma [F
      // 0c1e: iload 72
      // 0c20: iload 84
      // 0c22: ifeq 0c32
      // 0c25: ldc_w 0.6
      // 0c28: fload 97
      // 0c2a: ldc_w 1.2
      // 0c2d: fmul
      // 0c2e: fadd
      // 0c2f: goto 0c3c
      // 0c32: ldc_w 0.8
      // 0c35: fload 97
      // 0c37: ldc_w 1.5
      // 0c3a: fmul
      // 0c3b: fadd
      // 0c3c: fastore
      // 0c3d: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mj [F
      // 0c40: iload 72
      // 0c42: fload 88
      // 0c44: ldc_w 0.5
      // 0c47: fsub
      // 0c48: iload 84
      // 0c4a: ifeq 0c53
      // 0c4d: ldc_w 21.0
      // 0c50: goto 0c56
      // 0c53: ldc_w 16.0
      // 0c56: fmul
      // 0c57: fastore
      // 0c58: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mk [F
      // 0c5b: iload 72
      // 0c5d: ldc_w 0.5
      // 0c60: fload 88
      // 0c62: fsub
      // 0c63: iload 84
      // 0c65: ifeq 0c6e
      // 0c68: ldc_w 16.0
      // 0c6b: goto 0c71
      // 0c6e: ldc_w 10.0
      // 0c71: fmul
      // 0c72: fastore
      // 0c73: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.lw [D
      // 0c76: iload 72
      // 0c78: dload 74
      // 0c7a: dastore
      // 0c7b: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.lx [D
      // 0c7e: iload 72
      // 0c80: dload 76
      // 0c82: dastore
      // 0c83: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.ly [D
      // 0c86: iload 72
      // 0c88: dload 78
      // 0c8a: dastore
      // 0c8b: goto 0e0d
      // 0c8e: iload 73
      // 0c90: bipush 3
      // 0c91: if_icmpne 0e0d
      // 0c94: iload 85
      // 0c96: iflt 0de0
      // 0c99: dload 76
      // 0c9b: fload 86
      // 0c9d: ldc_w 0.02
      // 0ca0: fadd
      // 0ca1: f2d
      // 0ca2: dload 76
      // 0ca4: dsub
      // 0ca5: fload 31
      // 0ca7: f2d
      // 0ca8: dmul
      // 0ca9: dadd
      // 0caa: dstore 76
      // 0cac: aload 44
      // 0cae: iload 85
      // 0cb0: faload
      // 0cb1: ldc_w 0.7
      // 0cb4: fmul
      // 0cb5: fload 25
      // 0cb7: ldc_w 0.12
      // 0cba: fmul
      // 0cbb: fadd
      // 0cbc: fstore 90
      // 0cbe: aload 45
      // 0cc0: iload 85
      // 0cc2: faload
      // 0cc3: ldc_w 0.7
      // 0cc6: fmul
      // 0cc7: fload 26
      // 0cc9: ldc_w 0.12
      // 0ccc: fmul
      // 0ccd: fadd
      // 0cce: fstore 91
      // 0cd0: fload 90
      // 0cd2: fload 90
      // 0cd4: fmul
      // 0cd5: fload 91
      // 0cd7: fload 91
      // 0cd9: fmul
      // 0cda: fadd
      // 0cdb: ldc_w 1.0E-4
      // 0cde: fcmpl
      // 0cdf: ifle 0de0
      // 0ce2: dload 74
      // 0ce4: fload 90
      // 0ce6: fload 3
      // 0ce7: fmul
      // 0ce8: f2d
      // 0ce9: dadd
      // 0cea: dstore 92
      // 0cec: dload 78
      // 0cee: fload 91
      // 0cf0: fload 3
      // 0cf1: fmul
      // 0cf2: f2d
      // 0cf3: dadd
      // 0cf4: dstore 94
      // 0cf6: ldc_w -1.0E9
      // 0cf9: fstore 96
      // 0cfb: bipush 3
      // 0cfc: istore 97
      // 0cfe: dload 92
      // 0d00: invokestatic net/minecraft/MathHelper.floor (D)I
      // 0d03: istore 98
      // 0d05: dload 94
      // 0d07: invokestatic net/minecraft/MathHelper.floor (D)I
      // 0d0a: istore 99
      // 0d0c: iload 98
      // 0d0e: iload 40
      // 0d10: isub
      // 0d11: bipush 24
      // 0d13: iadd
      // 0d14: istore 100
      // 0d16: iload 99
      // 0d18: iload 41
      // 0d1a: isub
      // 0d1b: bipush 24
      // 0d1d: iadd
      // 0d1e: istore 101
      // 0d20: iload 100
      // 0d22: iflt 0d8e
      // 0d25: iload 101
      // 0d27: iflt 0d8e
      // 0d2a: iload 100
      // 0d2c: bipush 49
      // 0d2e: if_icmpge 0d8e
      // 0d31: iload 101
      // 0d33: bipush 49
      // 0d35: if_icmpge 0d8e
      // 0d38: iload 101
      // 0d3a: bipush 49
      // 0d3c: imul
      // 0d3d: iload 100
      // 0d3f: iadd
      // 0d40: istore 102
      // 0d42: aload 46
      // 0d44: iload 102
      // 0d46: baload
      // 0d47: istore 97
      // 0d49: iload 97
      // 0d4b: bipush 4
      // 0d4c: if_icmpne 0d87
      // 0d4f: iload 102
      // 0d51: bipush 6
      // 0d53: ishl
      // 0d54: dload 92
      // 0d56: iload 98
      // 0d58: i2d
      // 0d59: dsub
      // 0d5a: ldc2_w 8.0
      // 0d5d: dmul
      // 0d5e: d2i
      // 0d5f: bipush 7
      // 0d61: iand
      // 0d62: bipush 3
      // 0d63: ishl
      // 0d64: ior
      // 0d65: dload 94
      // 0d67: iload 99
      // 0d69: i2d
      // 0d6a: dsub
      // 0d6b: ldc2_w 8.0
      // 0d6e: dmul
      // 0d6f: d2i
      // 0d70: bipush 7
      // 0d72: iand
      // 0d73: ior
      // 0d74: istore 103
      // 0d76: aload 43
      // 0d78: iload 103
      // 0d7a: faload
      // 0d7b: fstore 96
      // 0d7d: aload 47
      // 0d7f: iload 103
      // 0d81: baload
      // 0d82: istore 97
      // 0d84: goto 0d8e
      // 0d87: aload 42
      // 0d89: iload 102
      // 0d8b: faload
      // 0d8c: fstore 96
      // 0d8e: iload 97
      // 0d90: bipush 1
      // 0d91: if_icmpne 0de0
      // 0d94: fload 96
      // 0d96: fload 86
      // 0d98: ldc_w 0.3
      // 0d9b: fsub
      // 0d9c: fcmpg
      // 0d9d: ifge 0dcc
      // 0da0: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mt [B
      // 0da3: iload 72
      // 0da5: bipush 2
      // 0da6: bastore
      // 0da7: bipush 2
      // 0da8: istore 73
      // 0daa: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.lz [F
      // 0dad: iload 72
      // 0daf: fload 90
      // 0db1: fastore
      // 0db2: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.ma [F
      // 0db5: iload 72
      // 0db7: fconst_0
      // 0db8: fastore
      // 0db9: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mb [F
      // 0dbc: iload 72
      // 0dbe: fload 91
      // 0dc0: fastore
      // 0dc1: dload 92
      // 0dc3: dstore 74
      // 0dc5: dload 94
      // 0dc7: dstore 78
      // 0dc9: goto 0de0
      // 0dcc: fload 96
      // 0dce: fload 86
      // 0dd0: ldc_w 0.3
      // 0dd3: fadd
      // 0dd4: fcmpg
      // 0dd5: ifge 0de0
      // 0dd8: dload 92
      // 0dda: dstore 74
      // 0ddc: dload 94
      // 0dde: dstore 78
      // 0de0: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mc [F
      // 0de3: iload 72
      // 0de5: dup2
      // 0de6: faload
      // 0de7: fload 88
      // 0de9: ldc_w 0.5
      // 0dec: fsub
      // 0ded: ldc_w 0.25
      // 0df0: fmul
      // 0df1: fload 3
      // 0df2: fmul
      // 0df3: fadd
      // 0df4: fastore
      // 0df5: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.lw [D
      // 0df8: iload 72
      // 0dfa: dload 74
      // 0dfc: dastore
      // 0dfd: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.lx [D
      // 0e00: iload 72
      // 0e02: dload 76
      // 0e04: dastore
      // 0e05: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.ly [D
      // 0e08: iload 72
      // 0e0a: dload 78
      // 0e0c: dastore
      // 0e0d: iload 73
      // 0e0f: bipush 2
      // 0e10: if_icmpeq 10b4
      // 0e13: iload 50
      // 0e15: ifeq 10b4
      // 0e18: dload 74
      // 0e1a: dload 51
      // 0e1c: dcmpl
      // 0e1d: iflt 10b4
      // 0e20: dload 74
      // 0e22: dload 53
      // 0e24: dcmpg
      // 0e25: ifgt 10b4
      // 0e28: dload 78
      // 0e2a: dload 55
      // 0e2c: dcmpl
      // 0e2d: iflt 10b4
      // 0e30: dload 78
      // 0e32: dload 57
      // 0e34: dcmpg
      // 0e35: ifgt 10b4
      // 0e38: bipush 0
      // 0e39: istore 90
      // 0e3b: iload 90
      // 0e3d: iload 49
      // 0e3f: if_icmpge 10b4
      // 0e42: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.oa [F
      // 0e45: iload 90
      // 0e47: faload
      // 0e48: fstore 91
      // 0e4a: fload 91
      // 0e4c: fconst_0
      // 0e4d: fcmpg
      // 0e4e: ifgt 0e54
      // 0e51: goto 10ae
      // 0e54: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.ny [F
      // 0e57: iload 90
      // 0e59: faload
      // 0e5a: fstore 92
      // 0e5c: dload 74
      // 0e5e: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.nt [D
      // 0e61: iload 90
      // 0e63: daload
      // 0e64: dsub
      // 0e65: d2f
      // 0e66: fstore 93
      // 0e68: dload 78
      // 0e6a: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.nv [D
      // 0e6d: iload 90
      // 0e6f: daload
      // 0e70: dsub
      // 0e71: d2f
      // 0e72: fstore 94
      // 0e74: fload 93
      // 0e76: fload 92
      // 0e78: fcmpl
      // 0e79: ifgt 10ae
      // 0e7c: fload 93
      // 0e7e: fload 92
      // 0e80: fneg
      // 0e81: fcmpg
      // 0e82: iflt 10ae
      // 0e85: fload 94
      // 0e87: fload 92
      // 0e89: fcmpl
      // 0e8a: ifgt 10ae
      // 0e8d: fload 94
      // 0e8f: fload 92
      // 0e91: fneg
      // 0e92: fcmpg
      // 0e93: ifge 0e99
      // 0e96: goto 10ae
      // 0e99: dload 76
      // 0e9b: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.nu [D
      // 0e9e: iload 90
      // 0ea0: daload
      // 0ea1: dsub
      // 0ea2: d2f
      // 0ea3: fstore 95
      // 0ea5: fload 95
      // 0ea7: iload 73
      // 0ea9: bipush 3
      // 0eaa: if_icmpne 0eb3
      // 0ead: ldc_w 2.2
      // 0eb0: goto 0eb6
      // 0eb3: ldc_w 0.6
      // 0eb6: fcmpl
      // 0eb7: ifgt 10ae
      // 0eba: fload 95
      // 0ebc: ldc_w -1.1
      // 0ebf: fcmpg
      // 0ec0: ifge 0ec6
      // 0ec3: goto 10ae
      // 0ec6: fload 93
      // 0ec8: fload 93
      // 0eca: fmul
      // 0ecb: fload 94
      // 0ecd: fload 94
      // 0ecf: fmul
      // 0ed0: fadd
      // 0ed1: fstore 96
      // 0ed3: fload 96
      // 0ed5: fload 92
      // 0ed7: fload 92
      // 0ed9: fmul
      // 0eda: fcmpl
      // 0edb: iflt 0ee1
      // 0ede: goto 10ae
      // 0ee1: fload 96
      // 0ee3: invokestatic net/minecraft/MathHelper.sqrt (F)F
      // 0ee6: ldc_w 0.001
      // 0ee9: fadd
      // 0eea: fstore 97
      // 0eec: fconst_1
      // 0eed: fload 97
      // 0eef: fload 92
      // 0ef1: fdiv
      // 0ef2: fsub
      // 0ef3: fload 91
      // 0ef5: fmul
      // 0ef6: fstore 98
      // 0ef8: fload 95
      // 0efa: ldc_w -0.35
      // 0efd: fcmpg
      // 0efe: ifge 0f12
      // 0f01: fload 98
      // 0f03: fconst_1
      // 0f04: fload 95
      // 0f06: ldc_w 0.35
      // 0f09: fadd
      // 0f0a: ldc_w 0.75
      // 0f0d: fdiv
      // 0f0e: fadd
      // 0f0f: fmul
      // 0f10: fstore 98
      // 0f12: fload 98
      // 0f14: ldc_w 0.07
      // 0f17: fload 88
      // 0f19: ldc_w 0.25
      // 0f1c: fmul
      // 0f1d: fadd
      // 0f1e: fcmpg
      // 0f1f: ifgt 0f25
      // 0f22: goto 10ae
      // 0f25: iload 73
      // 0f27: bipush 1
      // 0f28: if_icmpne 0f8d
      // 0f2b: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mr [I
      // 0f2e: iload 72
      // 0f30: iaload
      // 0f31: istore 99
      // 0f33: iload 99
      // 0f35: iflt 0f49
      // 0f38: aload 48
      // 0f3a: iload 99
      // 0f3c: iaload
      // 0f3d: ifle 0f49
      // 0f40: aload 48
      // 0f42: iload 99
      // 0f44: dup2
      // 0f45: iaload
      // 0f46: bipush 1
      // 0f47: isub
      // 0f48: iastore
      // 0f49: iload 99
      // 0f4b: iflt 0f8d
      // 0f4e: iload 85
      // 0f50: iflt 0f8d
      // 0f53: aload 48
      // 0f55: iload 99
      // 0f57: iaload
      // 0f58: istore 100
      // 0f5a: fload 86
      // 0f5c: ldc_w 0.014
      // 0f5f: fadd
      // 0f60: iload 100
      // 0f62: bipush 36
      // 0f64: if_icmple 0f6c
      // 0f67: bipush 36
      // 0f69: goto 0f6e
      // 0f6c: iload 100
      // 0f6e: i2f
      // 0f6f: ldc_w 0.0042
      // 0f72: fmul
      // 0f73: fadd
      // 0f74: fstore 101
      // 0f76: dload 76
      // 0f78: fload 101
      // 0f7a: f2d
      // 0f7b: dcmpg
      // 0f7c: ifge 0f8d
      // 0f7f: fload 101
      // 0f81: f2d
      // 0f82: dstore 76
      // 0f84: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.lx [D
      // 0f87: iload 72
      // 0f89: fload 101
      // 0f8b: f2d
      // 0f8c: dastore
      // 0f8d: fload 93
      // 0f8f: fload 97
      // 0f91: fdiv
      // 0f92: fstore 99
      // 0f94: fload 94
      // 0f96: fload 97
      // 0f98: fdiv
      // 0f99: fstore 100
      // 0f9b: ldc_w 0.6
      // 0f9e: ldc_w 1.6
      // 0fa1: fload 98
      // 0fa3: fmul
      // 0fa4: fadd
      // 0fa5: ldc_w 0.6
      // 0fa8: ldc_w 0.8
      // 0fab: fload 88
      // 0fad: fmul
      // 0fae: fadd
      // 0faf: fmul
      // 0fb0: iload 84
      // 0fb2: ifeq 0fbb
      // 0fb5: ldc_w 1.15
      // 0fb8: goto 0fbc
      // 0fbb: fconst_1
      // 0fbc: fmul
      // 0fbd: fstore 101
      // 0fbf: iload 84
      // 0fc1: ifeq 0fd1
      // 0fc4: ldc_w 0.25
      // 0fc7: ldc_w 0.35
      // 0fca: fload 88
      // 0fcc: fmul
      // 0fcd: fadd
      // 0fce: goto 0fdb
      // 0fd1: ldc_w 0.15
      // 0fd4: ldc_w 0.3
      // 0fd7: fload 88
      // 0fd9: fmul
      // 0fda: fadd
      // 0fdb: fstore 102
      // 0fdd: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.lz [F
      // 0fe0: iload 72
      // 0fe2: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.nw [F
      // 0fe5: iload 90
      // 0fe7: faload
      // 0fe8: fload 102
      // 0fea: fmul
      // 0feb: fload 99
      // 0fed: fload 101
      // 0fef: fmul
      // 0ff0: fadd
      // 0ff1: fastore
      // 0ff2: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mb [F
      // 0ff5: iload 72
      // 0ff7: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.nx [F
      // 0ffa: iload 90
      // 0ffc: faload
      // 0ffd: fload 102
      // 0fff: fmul
      // 1000: fload 100
      // 1002: fload 101
      // 1004: fmul
      // 1005: fadd
      // 1006: fastore
      // 1007: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.ma [F
      // 100a: iload 72
      // 100c: iload 73
      // 100e: bipush 3
      // 100f: if_icmpne 101f
      // 1012: ldc_w 0.3
      // 1015: ldc_w 0.6
      // 1018: fload 98
      // 101a: fmul
      // 101b: fadd
      // 101c: goto 1049
      // 101f: iload 84
      // 1021: ifeq 1038
      // 1024: ldc_w 0.7
      // 1027: ldc_w 1.8
      // 102a: fload 98
      // 102c: fmul
      // 102d: ldc_w 0.5
      // 1030: fload 88
      // 1032: fadd
      // 1033: fmul
      // 1034: fadd
      // 1035: goto 1049
      // 1038: ldc_w 0.9
      // 103b: ldc_w 2.3
      // 103e: fload 98
      // 1040: fmul
      // 1041: ldc_w 0.5
      // 1044: fload 88
      // 1046: fadd
      // 1047: fmul
      // 1048: fadd
      // 1049: fastore
      // 104a: fload 88
      // 104c: ldc_w 7.31
      // 104f: fmul
      // 1050: fstore 103
      // 1052: fload 103
      // 1054: fload 103
      // 1056: f2i
      // 1057: i2f
      // 1058: fsub
      // 1059: fstore 103
      // 105b: iload 84
      // 105d: ifeq 1066
      // 1060: ldc_w 1.3
      // 1063: goto 1067
      // 1066: fconst_1
      // 1067: fstore 104
      // 1069: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mj [F
      // 106c: iload 72
      // 106e: fload 103
      // 1070: ldc_w 0.5
      // 1073: fsub
      // 1074: fconst_2
      // 1075: fmul
      // 1076: ldc_w 6.0
      // 1079: ldc_w 8.0
      // 107c: fload 98
      // 107e: fmul
      // 107f: fadd
      // 1080: fmul
      // 1081: fload 104
      // 1083: fmul
      // 1084: fastore
      // 1085: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mk [F
      // 1088: iload 72
      // 108a: fload 88
      // 108c: ldc_w 0.5
      // 108f: fsub
      // 1090: fconst_2
      // 1091: fmul
      // 1092: ldc_w 4.0
      // 1095: ldc_w 6.0
      // 1098: fload 98
      // 109a: fmul
      // 109b: fadd
      // 109c: fmul
      // 109d: fload 104
      // 109f: fmul
      // 10a0: fastore
      // 10a1: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mt [B
      // 10a4: iload 72
      // 10a6: bipush 2
      // 10a7: bastore
      // 10a8: bipush 2
      // 10a9: istore 73
      // 10ab: goto 10b4
      // 10ae: iinc 90 1
      // 10b1: goto 0e3b
      // 10b4: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mn [F
      // 10b7: iload 72
      // 10b9: faload
      // 10ba: fstore 90
      // 10bc: fload 90
      // 10be: fconst_1
      // 10bf: fcmpg
      // 10c0: ifge 10df
      // 10c3: fload 90
      // 10c5: fload 3
      // 10c6: ldc_w 0.7
      // 10c9: fmul
      // 10ca: fadd
      // 10cb: fstore 90
      // 10cd: fload 90
      // 10cf: fconst_1
      // 10d0: fcmpl
      // 10d1: ifle 10d7
      // 10d4: fconst_1
      // 10d5: fstore 90
      // 10d7: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mn [F
      // 10da: iload 72
      // 10dc: fload 90
      // 10de: fastore
      // 10df: dload 74
      // 10e1: dload 10
      // 10e3: dsub
      // 10e4: d2f
      // 10e5: fstore 91
      // 10e7: dload 76
      // 10e9: dload 12
      // 10eb: dsub
      // 10ec: d2f
      // 10ed: fstore 92
      // 10ef: dload 78
      // 10f1: dload 14
      // 10f3: dsub
      // 10f4: d2f
      // 10f5: fstore 93
      // 10f7: fload 91
      // 10f9: fload 91
      // 10fb: fmul
      // 10fc: fload 93
      // 10fe: fload 93
      // 1100: fmul
      // 1101: fadd
      // 1102: fstore 94
      // 1104: fload 94
      // 1106: ldc_w 400.0
      // 1109: fcmpl
      // 110a: iflt 1110
      // 110d: goto 17c6
      // 1110: iload 84
      // 1112: ifeq 111b
      // 1115: iinc 71 1
      // 1118: goto 111e
      // 111b: iinc 34 1
      // 111e: fload 94
      // 1120: fload 92
      // 1122: fload 92
      // 1124: fmul
      // 1125: fadd
      // 1126: fstore 95
      // 1128: fload 95
      // 112a: ldc_w 0.02
      // 112d: fcmpg
      // 112e: ifge 1134
      // 1131: goto 17c6
      // 1134: fload 95
      // 1136: invokestatic net/minecraft/MathHelper.sqrt (F)F
      // 1139: fstore 96
      // 113b: fload 91
      // 113d: fload 36
      // 113f: fmul
      // 1140: fload 92
      // 1142: fload 37
      // 1144: fmul
      // 1145: fadd
      // 1146: fload 93
      // 1148: fload 38
      // 114a: fmul
      // 114b: fadd
      // 114c: fstore 97
      // 114e: fload 97
      // 1150: ldc_w -0.3
      // 1153: fload 96
      // 1155: fmul
      // 1156: fcmpg
      // 1157: ifge 115d
      // 115a: goto 17c6
      // 115d: iload 59
      // 115f: ifeq 118b
      // 1162: ldc_w 0.6
      // 1165: fload 97
      // 1167: fload 61
      // 1169: fmul
      // 116a: fadd
      // 116b: fstore 98
      // 116d: fload 98
      // 116f: fconst_0
      // 1170: fcmpg
      // 1171: iflt 17c6
      // 1174: fload 95
      // 1176: fload 97
      // 1178: fload 97
      // 117a: fmul
      // 117b: fsub
      // 117c: fload 62
      // 117e: fmul
      // 117f: fload 98
      // 1181: fload 98
      // 1183: fmul
      // 1184: fcmpl
      // 1185: ifle 118b
      // 1188: goto 17c6
      // 118b: fload 94
      // 118d: invokestatic net/minecraft/MathHelper.sqrt (F)F
      // 1190: ldc_w 13.0
      // 1193: fsub
      // 1194: ldc_w 7.0
      // 1197: fdiv
      // 1198: fstore 98
      // 119a: fload 98
      // 119c: fconst_0
      // 119d: fcmpg
      // 119e: ifge 11a5
      // 11a1: fconst_0
      // 11a2: goto 11b2
      // 11a5: fload 98
      // 11a7: fconst_1
      // 11a8: fcmpl
      // 11a9: ifle 11b0
      // 11ac: fconst_1
      // 11ad: goto 11b2
      // 11b0: fload 98
      // 11b2: fstore 98
      // 11b4: iload 72
      // 11b6: iload 63
      // 11b8: isub
      // 11b9: istore 99
      // 11bb: iload 99
      // 11bd: ifge 11c6
      // 11c0: wide iinc 99 6000
      // 11c6: iload 99
      // 11c8: ldc_w 1567392728
      // 11cb: ldc_w 1567392282
      // 11ce: ixor
      // 11cf: if_icmplt 11d6
      // 11d2: fconst_1
      // 11d3: goto 11dd
      // 11d6: iload 99
      // 11d8: i2f
      // 11d9: ldc_w 450.0
      // 11dc: fdiv
      // 11dd: fstore 100
      // 11df: iload 84
      // 11e1: ifeq 11e9
      // 11e4: fload 8
      // 11e6: goto 11eb
      // 11e9: fload 7
      // 11eb: fconst_1
      // 11ec: fload 98
      // 11ee: fload 98
      // 11f0: fmul
      // 11f1: ldc_w 3.0
      // 11f4: fconst_2
      // 11f5: fload 98
      // 11f7: fmul
      // 11f8: fsub
      // 11f9: fmul
      // 11fa: fsub
      // 11fb: fmul
      // 11fc: fload 100
      // 11fe: fmul
      // 11ff: fload 90
      // 1201: fmul
      // 1202: fstore 101
      // 1204: iload 73
      // 1206: bipush 2
      // 1207: if_icmpne 1243
      // 120a: fload 96
      // 120c: ldc_w 0.25
      // 120f: fsub
      // 1210: ldc_w 1.2
      // 1213: fdiv
      // 1214: fstore 102
      // 1216: fload 102
      // 1218: fconst_0
      // 1219: fcmpg
      // 121a: ifge 1221
      // 121d: fconst_0
      // 121e: goto 122e
      // 1221: fload 102
      // 1223: fconst_1
      // 1224: fcmpl
      // 1225: ifle 122c
      // 1228: fconst_1
      // 1229: goto 122e
      // 122c: fload 102
      // 122e: fstore 102
      // 1230: fload 101
      // 1232: fload 102
      // 1234: fload 102
      // 1236: fmul
      // 1237: ldc_w 3.0
      // 123a: fconst_2
      // 123b: fload 102
      // 123d: fmul
      // 123e: fsub
      // 123f: fmul
      // 1240: fmul
      // 1241: fstore 101
      // 1243: fload 101
      // 1245: ldc_w 0.012
      // 1248: fcmpg
      // 1249: ifge 124f
      // 124c: goto 17c6
      // 124f: fload 101
      // 1251: fconst_1
      // 1252: fcmpl
      // 1253: ifle 1259
      // 1256: fconst_1
      // 1257: fstore 101
      // 1259: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mf [F
      // 125c: iload 72
      // 125e: faload
      // 125f: fconst_1
      // 1260: fload 96
      // 1262: ldc_w 0.01
      // 1265: fmul
      // 1266: fadd
      // 1267: fmul
      // 1268: fstore 102
      // 126a: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mc [F
      // 126d: iload 72
      // 126f: faload
      // 1270: fstore 103
      // 1272: fload 103
      // 1274: f2d
      // 1275: invokestatic net/minecraft/MathHelper.sin (D)F
      // 1278: fstore 104
      // 127a: fload 103
      // 127c: f2d
      // 127d: invokestatic net/minecraft/MathHelper.cos (D)F
      // 1280: fstore 105
      // 1282: fload 17
      // 1284: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mg [F
      // 1287: iload 72
      // 1289: faload
      // 128a: fmul
      // 128b: fstore 113
      // 128d: iload 73
      // 128f: bipush 2
      // 1290: if_icmpne 1317
      // 1293: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mh [F
      // 1296: iload 72
      // 1298: faload
      // 1299: fstore 114
      // 129b: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mi [F
      // 129e: iload 72
      // 12a0: faload
      // 12a1: fstore 115
      // 12a3: fload 114
      // 12a5: f2d
      // 12a6: invokestatic net/minecraft/MathHelper.cos (D)F
      // 12a9: fstore 116
      // 12ab: fload 114
      // 12ad: f2d
      // 12ae: invokestatic net/minecraft/MathHelper.sin (D)F
      // 12b1: fstore 117
      // 12b3: fload 115
      // 12b5: f2d
      // 12b6: invokestatic net/minecraft/MathHelper.cos (D)F
      // 12b9: fstore 118
      // 12bb: fload 115
      // 12bd: f2d
      // 12be: invokestatic net/minecraft/MathHelper.sin (D)F
      // 12c1: fstore 119
      // 12c3: fload 116
      // 12c5: fload 105
      // 12c7: fmul
      // 12c8: fload 102
      // 12ca: fmul
      // 12cb: fstore 109
      // 12cd: fload 117
      // 12cf: fload 102
      // 12d1: fmul
      // 12d2: fstore 110
      // 12d4: fload 116
      // 12d6: fneg
      // 12d7: fload 104
      // 12d9: fmul
      // 12da: fload 102
      // 12dc: fmul
      // 12dd: fstore 111
      // 12df: fload 119
      // 12e1: fload 117
      // 12e3: fmul
      // 12e4: fload 105
      // 12e6: fmul
      // 12e7: fload 118
      // 12e9: fload 104
      // 12eb: fmul
      // 12ec: fadd
      // 12ed: fload 102
      // 12ef: fmul
      // 12f0: fstore 106
      // 12f2: fload 119
      // 12f4: fneg
      // 12f5: fload 116
      // 12f7: fmul
      // 12f8: fload 102
      // 12fa: fmul
      // 12fb: fstore 107
      // 12fd: fload 119
      // 12ff: fneg
      // 1300: fload 117
      // 1302: fmul
      // 1303: fload 104
      // 1305: fmul
      // 1306: fload 118
      // 1308: fload 105
      // 130a: fmul
      // 130b: fadd
      // 130c: fload 102
      // 130e: fmul
      // 130f: fstore 108
      // 1311: fconst_1
      // 1312: fstore 112
      // 1314: goto 1417
      // 1317: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.md [F
      // 131a: iload 72
      // 131c: faload
      // 131d: fstore 114
      // 131f: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.me [F
      // 1322: iload 72
      // 1324: faload
      // 1325: fstore 115
      // 1327: fload 89
      // 1329: fconst_0
      // 132a: fcmpg
      // 132b: ifge 1331
      // 132e: fconst_0
      // 132f: fstore 89
      // 1331: fload 114
      // 1333: fload 89
      // 1335: fcmpl
      // 1336: ifle 1340
      // 1339: fload 89
      // 133b: fstore 114
      // 133d: goto 134e
      // 1340: fload 114
      // 1342: fload 89
      // 1344: fneg
      // 1345: fcmpg
      // 1346: ifge 134e
      // 1349: fload 89
      // 134b: fneg
      // 134c: fstore 114
      // 134e: fload 115
      // 1350: fload 89
      // 1352: fcmpl
      // 1353: ifle 135d
      // 1356: fload 89
      // 1358: fstore 115
      // 135a: goto 136b
      // 135d: fload 115
      // 135f: fload 89
      // 1361: fneg
      // 1362: fcmpg
      // 1363: ifge 136b
      // 1366: fload 89
      // 1368: fneg
      // 1369: fstore 115
      // 136b: fload 105
      // 136d: fload 102
      // 136f: fmul
      // 1370: fstore 109
      // 1372: fload 104
      // 1374: fneg
      // 1375: fload 102
      // 1377: fmul
      // 1378: fstore 111
      // 137a: fload 114
      // 137c: fload 109
      // 137e: fmul
      // 137f: fload 115
      // 1381: fload 111
      // 1383: fmul
      // 1384: fadd
      // 1385: fneg
      // 1386: fstore 110
      // 1388: iload 84
      // 138a: ifeq 13ad
      // 138d: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mi [F
      // 1390: iload 72
      // 1392: faload
      // 1393: ldc_w 1.5707964
      // 1396: fcmpl
      // 1397: ifgt 13a7
      // 139a: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mi [F
      // 139d: iload 72
      // 139f: faload
      // 13a0: ldc_w -1.5707964
      // 13a3: fcmpg
      // 13a4: ifge 13ad
      // 13a7: fload 102
      // 13a9: fneg
      // 13aa: goto 13af
      // 13ad: fload 102
      // 13af: fstore 116
      // 13b1: fload 104
      // 13b3: fload 116
      // 13b5: fmul
      // 13b6: fstore 106
      // 13b8: fload 105
      // 13ba: fload 116
      // 13bc: fmul
      // 13bd: fstore 108
      // 13bf: fload 114
      // 13c1: fload 106
      // 13c3: fmul
      // 13c4: fload 115
      // 13c6: fload 108
      // 13c8: fmul
      // 13c9: fadd
      // 13ca: fneg
      // 13cb: fstore 107
      // 13cd: iload 73
      // 13cf: bipush 3
      // 13d0: if_icmpne 13ed
      // 13d3: fload 92
      // 13d5: dload 4
      // 13d7: ldc2_w 1.3
      // 13da: dmul
      // 13db: fload 88
      // 13dd: ldc_w 20.0
      // 13e0: fmul
      // 13e1: f2d
      // 13e2: dadd
      // 13e3: invokestatic net/minecraft/MathHelper.sin (D)F
      // 13e6: ldc_w 0.008
      // 13e9: fmul
      // 13ea: fadd
      // 13eb: fstore 92
      // 13ed: fload 92
      // 13ef: fconst_0
      // 13f0: fcmpg
      // 13f1: ifge 13fa
      // 13f4: fload 92
      // 13f6: fneg
      // 13f7: goto 13fc
      // 13fa: fload 92
      // 13fc: fload 96
      // 13fe: fdiv
      // 13ff: fstore 112
      // 1401: fload 112
      // 1403: ldc_w 0.15
      // 1406: fcmpg
      // 1407: ifge 1410
      // 140a: ldc_w 0.3873
      // 140d: goto 1415
      // 1410: fload 112
      // 1412: invokestatic net/minecraft/MathHelper.sqrt (F)F
      // 1415: fstore 112
      // 1417: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mq [I
      // 141a: iload 72
      // 141c: iaload
      // 141d: istore 117
      // 141f: iload 84
      // 1421: ifeq 14ba
      // 1424: fload 18
      // 1426: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mg [F
      // 1429: iload 72
      // 142b: faload
      // 142c: fmul
      // 142d: ldc_w 0.8
      // 1430: fmul
      // 1431: fstore 118
      // 1433: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mo [F
      // 1436: iload 72
      // 1438: faload
      // 1439: fstore 119
      // 143b: fload 118
      // 143d: fconst_1
      // 143e: fcmpl
      // 143f: ifle 1446
      // 1442: fconst_1
      // 1443: goto 1448
      // 1446: fload 118
      // 1448: fstore 118
      // 144a: ldc_w 255.0
      // 144d: fload 118
      // 144f: fmul
      // 1450: f2i
      // 1451: istore 114
      // 1453: ldc_w 255.0
      // 1456: fload 118
      // 1458: fmul
      // 1459: fconst_1
      // 145a: ldc_w 0.26
      // 145d: fload 119
      // 145f: fmul
      // 1460: fsub
      // 1461: fmul
      // 1462: f2i
      // 1463: istore 115
      // 1465: ldc_w 255.0
      // 1468: fload 118
      // 146a: fmul
      // 146b: fconst_1
      // 146c: ldc_w 0.36
      // 146f: fload 119
      // 1471: fmul
      // 1472: fsub
      // 1473: fmul
      // 1474: f2i
      // 1475: istore 116
      // 1477: fload 107
      // 1479: fload 111
      // 147b: fmul
      // 147c: fload 108
      // 147e: fload 110
      // 1480: fmul
      // 1481: fsub
      // 1482: fstore 120
      // 1484: fload 108
      // 1486: fload 109
      // 1488: fmul
      // 1489: fload 106
      // 148b: fload 111
      // 148d: fmul
      // 148e: fsub
      // 148f: fstore 121
      // 1491: fload 106
      // 1493: fload 110
      // 1495: fmul
      // 1496: fload 107
      // 1498: fload 109
      // 149a: fmul
      // 149b: fsub
      // 149c: fstore 122
      // 149e: fload 120
      // 14a0: fload 91
      // 14a2: fmul
      // 14a3: fload 121
      // 14a5: fload 92
      // 14a7: fmul
      // 14a8: fadd
      // 14a9: fload 122
      // 14ab: fload 93
      // 14ad: fmul
      // 14ae: fadd
      // 14af: fconst_0
      // 14b0: fcmpl
      // 14b1: ifle 14b7
      // 14b4: iinc 117 1
      // 14b7: goto 14df
      // 14ba: fload 113
      // 14bc: fconst_1
      // 14bd: fcmpl
      // 14be: ifle 14c4
      // 14c1: fconst_1
      // 14c2: fstore 113
      // 14c4: ldc_w 255.0
      // 14c7: fload 113
      // 14c9: fmul
      // 14ca: f2i
      // 14cb: istore 114
      // 14cd: ldc_w 249.0
      // 14d0: fload 113
      // 14d2: fmul
      // 14d3: f2i
      // 14d4: istore 115
      // 14d6: ldc_w 245.0
      // 14d9: fload 113
      // 14db: fmul
      // 14dc: f2i
      // 14dd: istore 116
      // 14df: fload 101
      // 14e1: ldc_w 255.0
      // 14e4: fmul
      // 14e5: f2i
      // 14e6: istore 118
      // 14e8: fload 102
      // 14ea: fconst_2
      // 14eb: fmul
      // 14ec: fload 35
      // 14ee: fmul
      // 14ef: fload 96
      // 14f1: fdiv
      // 14f2: fload 112
      // 14f4: fmul
      // 14f5: fstore 119
      // 14f7: fload 119
      // 14f9: ldc_w 64.0
      // 14fc: fcmpl
      // 14fd: iflt 1504
      // 1500: bipush 0
      // 1501: goto 1522
      // 1504: fload 119
      // 1506: ldc_w 32.0
      // 1509: fcmpl
      // 150a: iflt 1512
      // 150d: bipush 16
      // 150f: goto 1522
      // 1512: fload 119
      // 1514: ldc_w 16.0
      // 1517: fcmpl
      // 1518: iflt 1520
      // 151b: bipush 32
      // 151d: goto 1522
      // 1520: bipush 48
      // 1522: iload 117
      // 1524: iadd
      // 1525: istore 120
      // 1527: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.du [F
      // 152a: iload 120
      // 152c: faload
      // 152d: fstore 121
      // 152f: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.dv [F
      // 1532: iload 120
      // 1534: faload
      // 1535: fstore 122
      // 1537: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.dw [F
      // 153a: iload 120
      // 153c: faload
      // 153d: fstore 123
      // 153f: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.dx [F
      // 1542: iload 120
      // 1544: faload
      // 1545: fstore 124
      // 1547: iload 73
      // 1549: bipush 2
      // 154a: if_icmpne 1612
      // 154d: fload 96
      // 154f: ldc_w 4.0
      // 1552: fcmpg
      // 1553: ifge 1612
      // 1556: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.nr I
      // 1559: ldc_w 2028670793
      // 155c: ldc_w 2028670665
      // 155f: ixor
      // 1560: if_icmpge 1612
      // 1563: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.nr I
      // 1566: bipush 13
      // 1568: imul
      // 1569: istore 125
      // 156b: aload 64
      // 156d: iload 125
      // 156f: fload 91
      // 1571: fastore
      // 1572: aload 64
      // 1574: iload 125
      // 1576: bipush 1
      // 1577: iadd
      // 1578: fload 92
      // 157a: fastore
      // 157b: aload 64
      // 157d: iload 125
      // 157f: bipush 2
      // 1580: iadd
      // 1581: fload 93
      // 1583: fastore
      // 1584: aload 64
      // 1586: iload 125
      // 1588: bipush 3
      // 1589: iadd
      // 158a: fload 106
      // 158c: fastore
      // 158d: aload 64
      // 158f: iload 125
      // 1591: bipush 4
      // 1592: iadd
      // 1593: fload 107
      // 1595: fastore
      // 1596: aload 64
      // 1598: iload 125
      // 159a: bipush 5
      // 159b: iadd
      // 159c: fload 108
      // 159e: fastore
      // 159f: aload 64
      // 15a1: iload 125
      // 15a3: bipush 6
      // 15a5: iadd
      // 15a6: fload 109
      // 15a8: fastore
      // 15a9: aload 64
      // 15ab: iload 125
      // 15ad: bipush 7
      // 15af: iadd
      // 15b0: fload 110
      // 15b2: fastore
      // 15b3: aload 64
      // 15b5: iload 125
      // 15b7: bipush 8
      // 15b9: iadd
      // 15ba: fload 111
      // 15bc: fastore
      // 15bd: aload 64
      // 15bf: iload 125
      // 15c1: bipush 9
      // 15c3: iadd
      // 15c4: fload 121
      // 15c6: fastore
      // 15c7: aload 64
      // 15c9: iload 125
      // 15cb: bipush 10
      // 15cd: iadd
      // 15ce: fload 122
      // 15d0: fastore
      // 15d1: aload 64
      // 15d3: iload 125
      // 15d5: bipush 11
      // 15d7: iadd
      // 15d8: fload 123
      // 15da: fastore
      // 15db: aload 64
      // 15dd: iload 125
      // 15df: bipush 12
      // 15e1: iadd
      // 15e2: fload 124
      // 15e4: fastore
      // 15e5: aload 65
      // 15e7: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.nr I
      // 15ea: fload 96
      // 15ec: fastore
      // 15ed: aload 66
      // 15ef: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.nr I
      // 15f2: iload 114
      // 15f4: bipush 24
      // 15f6: ishl
      // 15f7: iload 115
      // 15f9: bipush 16
      // 15fb: ishl
      // 15fc: ior
      // 15fd: iload 116
      // 15ff: bipush 8
      // 1601: ishl
      // 1602: ior
      // 1603: iload 118
      // 1605: ior
      // 1606: iastore
      // 1607: getstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.nr I
      // 160a: bipush 1
      // 160b: iadd
      // 160c: putstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.nr I
      // 160f: goto 17c6
      // 1612: iload 60
      // 1614: ifeq 16ee
      // 1617: aload 0
      // 1618: fload 91
      // 161a: fload 106
      // 161c: fsub
      // 161d: fload 109
      // 161f: fsub
      // 1620: fload 92
      // 1622: fload 107
      // 1624: fsub
      // 1625: fload 110
      // 1627: fsub
      // 1628: fload 93
      // 162a: fload 108
      // 162c: fsub
      // 162d: fload 111
      // 162f: fsub
      // 1630: invokeinterface net/minecraft/n.vertex (FFF)Lnet/minecraft/n; 4
      // 1635: fload 121
      // 1637: fload 124
      // 1639: invokeinterface net/minecraft/n.texture (FF)Lnet/minecraft/n; 3
      // 163e: iload 114
      // 1640: iload 115
      // 1642: iload 116
      // 1644: iload 118
      // 1646: invokeinterface net/minecraft/n.color (IIII)Lnet/minecraft/n; 5
      // 164b: pop
      // 164c: aload 0
      // 164d: fload 91
      // 164f: fload 106
      // 1651: fsub
      // 1652: fload 109
      // 1654: fadd
      // 1655: fload 92
      // 1657: fload 107
      // 1659: fsub
      // 165a: fload 110
      // 165c: fadd
      // 165d: fload 93
      // 165f: fload 108
      // 1661: fsub
      // 1662: fload 111
      // 1664: fadd
      // 1665: invokeinterface net/minecraft/n.vertex (FFF)Lnet/minecraft/n; 4
      // 166a: fload 121
      // 166c: fload 122
      // 166e: invokeinterface net/minecraft/n.texture (FF)Lnet/minecraft/n; 3
      // 1673: iload 114
      // 1675: iload 115
      // 1677: iload 116
      // 1679: iload 118
      // 167b: invokeinterface net/minecraft/n.color (IIII)Lnet/minecraft/n; 5
      // 1680: pop
      // 1681: aload 0
      // 1682: fload 91
      // 1684: fload 106
      // 1686: fadd
      // 1687: fload 109
      // 1689: fadd
      // 168a: fload 92
      // 168c: fload 107
      // 168e: fadd
      // 168f: fload 110
      // 1691: fadd
      // 1692: fload 93
      // 1694: fload 108
      // 1696: fadd
      // 1697: fload 111
      // 1699: fadd
      // 169a: invokeinterface net/minecraft/n.vertex (FFF)Lnet/minecraft/n; 4
      // 169f: fload 123
      // 16a1: fload 122
      // 16a3: invokeinterface net/minecraft/n.texture (FF)Lnet/minecraft/n; 3
      // 16a8: iload 114
      // 16aa: iload 115
      // 16ac: iload 116
      // 16ae: iload 118
      // 16b0: invokeinterface net/minecraft/n.color (IIII)Lnet/minecraft/n; 5
      // 16b5: pop
      // 16b6: aload 0
      // 16b7: fload 91
      // 16b9: fload 106
      // 16bb: fadd
      // 16bc: fload 109
      // 16be: fsub
      // 16bf: fload 92
      // 16c1: fload 107
      // 16c3: fadd
      // 16c4: fload 110
      // 16c6: fsub
      // 16c7: fload 93
      // 16c9: fload 108
      // 16cb: fadd
      // 16cc: fload 111
      // 16ce: fsub
      // 16cf: invokeinterface net/minecraft/n.vertex (FFF)Lnet/minecraft/n; 4
      // 16d4: fload 123
      // 16d6: fload 124
      // 16d8: invokeinterface net/minecraft/n.texture (FF)Lnet/minecraft/n; 3
      // 16dd: iload 114
      // 16df: iload 115
      // 16e1: iload 116
      // 16e3: iload 118
      // 16e5: invokeinterface net/minecraft/n.color (IIII)Lnet/minecraft/n; 5
      // 16ea: pop
      // 16eb: goto 17c6
      // 16ee: aload 0
      // 16ef: aload 1
      // 16f0: fload 91
      // 16f2: fload 106
      // 16f4: fsub
      // 16f5: fload 109
      // 16f7: fsub
      // 16f8: fload 92
      // 16fa: fload 107
      // 16fc: fsub
      // 16fd: fload 110
      // 16ff: fsub
      // 1700: fload 93
      // 1702: fload 108
      // 1704: fsub
      // 1705: fload 111
      // 1707: fsub
      // 1708: invokeinterface net/minecraft/n.vertex (Lnet/minecraft/n$MatrixStack.Entry;FFF)Lnet/minecraft/n; 5
      // 170d: fload 121
      // 170f: fload 124
      // 1711: invokeinterface net/minecraft/n.texture (FF)Lnet/minecraft/n; 3
      // 1716: iload 114
      // 1718: iload 115
      // 171a: iload 116
      // 171c: iload 118
      // 171e: invokeinterface net/minecraft/n.color (IIII)Lnet/minecraft/n; 5
      // 1723: pop
      // 1724: aload 0
      // 1725: aload 1
      // 1726: fload 91
      // 1728: fload 106
      // 172a: fsub
      // 172b: fload 109
      // 172d: fadd
      // 172e: fload 92
      // 1730: fload 107
      // 1732: fsub
      // 1733: fload 110
      // 1735: fadd
      // 1736: fload 93
      // 1738: fload 108
      // 173a: fsub
      // 173b: fload 111
      // 173d: fadd
      // 173e: invokeinterface net/minecraft/n.vertex (Lnet/minecraft/n$MatrixStack.Entry;FFF)Lnet/minecraft/n; 5
      // 1743: fload 121
      // 1745: fload 122
      // 1747: invokeinterface net/minecraft/n.texture (FF)Lnet/minecraft/n; 3
      // 174c: iload 114
      // 174e: iload 115
      // 1750: iload 116
      // 1752: iload 118
      // 1754: invokeinterface net/minecraft/n.color (IIII)Lnet/minecraft/n; 5
      // 1759: pop
      // 175a: aload 0
      // 175b: aload 1
      // 175c: fload 91
      // 175e: fload 106
      // 1760: fadd
      // 1761: fload 109
      // 1763: fadd
      // 1764: fload 92
      // 1766: fload 107
      // 1768: fadd
      // 1769: fload 110
      // 176b: fadd
      // 176c: fload 93
      // 176e: fload 108
      // 1770: fadd
      // 1771: fload 111
      // 1773: fadd
      // 1774: invokeinterface net/minecraft/n.vertex (Lnet/minecraft/n$MatrixStack.Entry;FFF)Lnet/minecraft/n; 5
      // 1779: fload 123
      // 177b: fload 122
      // 177d: invokeinterface net/minecraft/n.texture (FF)Lnet/minecraft/n; 3
      // 1782: iload 114
      // 1784: iload 115
      // 1786: iload 116
      // 1788: iload 118
      // 178a: invokeinterface net/minecraft/n.color (IIII)Lnet/minecraft/n; 5
      // 178f: pop
      // 1790: aload 0
      // 1791: aload 1
      // 1792: fload 91
      // 1794: fload 106
      // 1796: fadd
      // 1797: fload 109
      // 1799: fsub
      // 179a: fload 92
      // 179c: fload 107
      // 179e: fadd
      // 179f: fload 110
      // 17a1: fsub
      // 17a2: fload 93
      // 17a4: fload 108
      // 17a6: fadd
      // 17a7: fload 111
      // 17a9: fsub
      // 17aa: invokeinterface net/minecraft/n.vertex (Lnet/minecraft/n$MatrixStack.Entry;FFF)Lnet/minecraft/n; 5
      // 17af: fload 123
      // 17b1: fload 124
      // 17b3: invokeinterface net/minecraft/n.texture (FF)Lnet/minecraft/n; 3
      // 17b8: iload 114
      // 17ba: iload 115
      // 17bc: iload 116
      // 17be: iload 118
      // 17c0: invokeinterface net/minecraft/n.color (IIII)Lnet/minecraft/n; 5
      // 17c5: pop
      // 17c6: iinc 72 1
      // 17c9: goto 01f7
      // 17cc: iload 34
      // 17ce: putstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mv I
      // 17d1: iload 71
      // 17d3: putstatic net/caffeinemc/mods/lithium/lattice/bundle/pipeline/shard/FieldVolumeCache.mw I
      // 17d6: return
   }

   private static void av(VertexConsumer var0, MatrixStack.Entry var1, float var2, float var3, float var4, double var5, float var7, float[] var8) {

      float var9 = (0.3F + 0.9F * oy) * var4;
      float var10 = 0.9F + 0.1F * MathHelper.sin(var5 * 0.8);
      ax(var0, var1, var2, var3, 0.0F, var7 * 0.55F, -1065353190 ^ -1065352987, 80, 30, var9 * 0.22F, var8);
      ax(var0, var1, var2, var3, 0.0F, var7 * 0.26F, 548673964 ^ 548673875, 110, 40, var9 * 0.42F * var10, var8);
      if (!ShellArrayCache.an) {
         ax(var0, var1, var2, var3, 0.0F, var7 * 0.11F, -634787458 ^ -634787455, -1086065360 ^ -1086065254, 70, var9 * 0.7F * var10, var8);
         ax(var0, var1, var2, var3, 0.0F, var7 * 0.045F, 127186224 ^ 127186383, -454896134 ^ -454896364, 632693214 ^ 632693018, var9 * var10, var8);
      }
   }

   private static void aw(VertexConsumer var0, MatrixStack.Entry var1, float var2, float var3, float var4, double var5, float var7, float[] var8, float var9) {

      float var10 = (0.3F + 0.9F * oy) * var4;
      float var11 = 0.92F + 0.08F * MathHelper.sin(var5 * 0.5);
      ax(var0, var1, var2, var3, 0.0F, var7 * 0.55F, -1703949190 ^ -1703949179, (int)(120.0F + 30.0F * var9), (int)(150.0F - 90.0F * var9), var10 * 0.2F, var8);
      ax(
         var0,
         var1,
         var2,
         var3,
         0.0F,
         var7 * 0.26F,
         1252086809 ^ 1252087014,
         (int)(150.0F + 25.0F * var9),
         (int)(165.0F - 85.0F * var9),
         var10 * 0.4F * var11,
         var8
      );
      ax(
         var0,
         var1,
         var2,
         var3,
         0.0F,
         var7 * 0.12F,
         1470218238 ^ 1470217985,
         (int)(195.0F + 10.0F * var9),
         (int)(190.0F - 70.0F * var9),
         var10 * 0.68F * var11,
         var8
      );
      ax(var0, var1, var2, var3, 0.0F, var7 * 0.05F, 823622609 ^ 823622446, (int)(240.0F + 4.0F * var9), (int)(224.0F - 19.0F * var9), var10 * var11, var8);
   }

   private static void ax(
      VertexConsumer var0, MatrixStack.Entry var1, float var2, float var3, float var4, float var5, int var6, int var7, int var8, float var9, float[] var10
   ) {

      int var11 = (int)((var9 > 1.0F ? 1.0F : (var9 < 0.0F ? 0.0F : var9)) * 255.0F);
      if (var11 > 0) {
         float var12 = var10[0] * var5;
         float var13 = var10[1] * var5;
         float var14 = var10[2] * var5;
         float var15 = var10[3] * var5;
         float var16 = var10[4] * var5;
         float var17 = var10[5] * var5;
         var0.vertex(var1, var2 - var12 - var15, var3 - var13 - var16, var4 - var14 - var17)
            .texture(0.0F, 1.0F)
            .color(var6, var7, var8, var11);
         var0.vertex(var1, var2 - var12 + var15, var3 - var13 + var16, var4 - var14 + var17)
            .texture(0.0F, 0.0F)
            .color(var6, var7, var8, var11);
         var0.vertex(var1, var2 + var12 + var15, var3 + var13 + var16, var4 + var14 + var17)
            .texture(1.0F, 0.0F)
            .color(var6, var7, var8, var11);
         var0.vertex(var1, var2 + var12 - var15, var3 + var13 - var16, var4 + var14 - var17)
            .texture(1.0F, 1.0F)
            .color(var6, var7, var8, var11);
      }
   }

   private static void ay(VertexConsumer var0, MatrixStack.Entry var1, float var2, float var3, float var4, double var5, float var7, float[] var8) {

      if (!(on < -0.05F)) {
         float var9 = (0.45F + 0.55F * oy) * var4 * (0.85F + 0.15F * MathHelper.sin(var5 * 0.35));
         ax(var0, var1, var2, var3, 0.0F, var7 * 0.6F, 2009189467 ^ 2009189540, 184943203 ^ 184943277, -180234228 ^ -180234112, var9 * 0.16F, var8);
         ax(var0, var1, var2, var3, 0.0F, var7 * 0.22F, -1898473765 ^ -1898473948, 1767962747 ^ 1767962779, -1852951282 ^ -1852951106, var9 * 0.3F, var8);
         if (!ShellArrayCache.an) {
            ax(var0, var1, var2, var3, 0.0F, var7 * 0.075F, -964095216 ^ -964094993, 991009522 ^ 991009282, 1296885022 ^ 1296885192, var9 * 0.5F, var8);
         }
      }
   }
}
