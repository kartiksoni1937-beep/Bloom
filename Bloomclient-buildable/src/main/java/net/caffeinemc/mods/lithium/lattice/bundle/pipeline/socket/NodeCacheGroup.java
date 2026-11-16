package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.ParserEngine;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.BlockCalculator;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.CheckerBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.ItemDescriptor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.PlacementEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.SlotEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.BoundQuadCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.RegionPassCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.BindingBridge;
import net.minecraft.util.Hand;
import net.minecraft.entity.Entity;
import net.minecraft.util.Arm;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.Language;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.EntityPose;
import net.minecraft.text.StringVisitable;
import net.minecraft.text.OrderedText;
import org.joml.Matrix4f;
import org.joml.Vector4f;
import net.minecraft.client.render.VertexConsumerProvider;
public class NodeCacheGroup extends BuilderFactory {
   private final CheckerBridge x;
   private final CheckerBridge y;
   private final CheckerBridge z;
   private final CheckerBridge aa;
   private final CheckerBridge ab;
   private final CheckerBridge ac;
   private final CheckerBridge ad;
   private final BlockCalculator ae;
   private final CheckerBridge af;
   private final CheckerBridge ag;
   private final CheckerBridge ah;
   private final SlotEntry ai;
   private final PlacementEntry aj;
   private final BlockCalculator ak;
   private final PlacementEntry al;
   private final CheckerBridge am;
   private final SlotEntry an;
   private final CheckerBridge ao;
   private final CheckerBridge ap;
   private final CheckerBridge aq;
   private final SlotEntry ar;
   private final Vector4f as;
   private static final int[] at = new int[]{0, 16777215, 6087152, 15757528, 15745871, 15122522, 16742943, 10120959};
   private static final int au = 58879;
   private static final int av = 8;
   private static final int aw = 9;
   private static final int[] ax = BoundQuadCache.TCOL;
   private static final long ay = 3000000000L;
   private static final float az = 0.12F;
   private static final float ba = 0.25F;
   private static final int bb = 0;
   private static final int bc = 1;
   private static final int bd = 2;
   private static final int be = 3;
   public static int HIT_ID = Integer.MIN_VALUE;
   public static long HIT_NS;
   public static volatile boolean RUN;
   private static NodeCacheGroup bf;
   private static final int bg = 0;
   private static final int bh = 1;
   private static final int bi = 2;
   private static final int bj = 3;
   private static final int bk = 4;
   private static final int bl = 5;
   private static final int bm = 6;
   private static final int bn = 7;
   private static final int bo = 8;
   private static final int bp = 9;
   private static final int bq = 10;
   private static final int br = 11;
   private static final float bs = (float) (Math.PI / 180.0);
   private static final float bt = (float) Math.PI;
   private static final float bu = 0.05F;
   private static final float bv = 0.18F;
   private static final float bw = 0.22F;
   private static final long bx = 250000000L;
   private static final float by = 0.2F;
   private static final float bz = 0.15F;
   private static final float ca = 0.1F;
   private static final int cb = 0;
   private static final int cc = 1;
   private static final int cd = 2;
   private static final int ce = 3;
   private static final int cf = 4;
   private static final int cg = 5;
   private static final int ch = 6;
   private static final int ci = 7;
   private static final int cj = 8;
   private static final int ck = 9;
   private static final int cl = 10;
   private static final int cm = 11;
   private static int cn = 12;
   private static final int co = 13;
   private static final int cp = 14;
   private float cq;
   private long cr;
   private boolean cs;
   private boolean ct;
   private final float[] cu;
   private final boolean[] cv;
   private float cw;
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
   private final float[] dh;
   private boolean di;
   private boolean dj;
   private boolean dk;
   private boolean dl;
   private boolean dm;
   private boolean dn;
   private int _kwren_do;
   private int dp;
   private int dq;
   private int dr;
   private int ds;
   private int du;
   private String dv;
   private final Matrix4f dw;
   private final Matrix4f dx;
   private final Matrix4f dy;
   private double dz;
   private double ea;
   private double eb;
   private double ec;
   private double ed;
   private double ee;
   private int ef;
   private float eg;
   private float eh;
   private float ei;
   private float ej;
   private float ek;
   private float el;
   private int em;
   private int en;
   private int eo;
   private int ep;
   private int eq;
   private int er;
   private int es;
   private String et;
   private float eu;
   private float ev;
   private boolean ew;
   private boolean ex;
   private long ey;
   private int ez;
   private float fa;
   private static final long fb = 50000000L;
   private float fc;
   private float fd;
   private float fe;
   private boolean ff;
   private BindingBridge fg;
   private static final String[] fh = new String[257];
   private static final OrderedText[] fi = new OrderedText[257];
   private static final int[] fj = new int[257];
   private TextRenderer fk;
   private double fl;
   private double fm;
   private float fn;
   private float fo;
   private int fp;
   private int fq;
   private int fs;
   private final float[] ft;
   private final float[] fu;
   private final float[] fv;
   private final float[] fw;
   private static final int fx = 512;
   private static final int fy = 384;
   private static final int fz = Integer.MIN_VALUE;
   private static final int ga = 1;
   private static final int gb = 2;
   private static final int gc = 4;
   private static final int gd = 8;
   private static final int ge = 4;
   private static final int gf = 20;
   private static final int gg = 1073741823;
   private int[] gi;
   private int[] gj;
   private float[] gk;
   private float[] gl;
   private float[] gm;
   private float[] gn;
   private float[] go;
   private float[] gp;
   private float[] gq;
   private float[] gr;
   private float[] gs;
   private float[] gt;
   private int[] gv;
   private int[] gx;
   private double[] gy;
   private double[] gz;
   private double[] ha;
   private double[] hb;
   private double[] hc;
   private double[] hd;
   private float[] he;
   private float[] hf;
   private float[] hg;
   private float[] hh;
   private float[] hi;
   private float[] hj;
   private int[] hk;
   private int[] hl;
   private float[] hm;
   private float[] hn;
   private int[] ho;
   private int[] hp;
   private int hq;
   private Entity[] hr;
   private int[] hs;
   private boolean[] ht;
   private int[] hu;
   private int[] hv;
   private int[] hw;
   private int hx;
   private PlayerEntity[] hy;
   private int[] hz;
   private int[] ia;
   private int ib;

   public NodeCacheGroup() {
      super("", "", ParserEngine.Z3);
      this.setName(
         new char[]{'쏜', '쎖', '쎄', '쎦'},
         1387053977,
         new char[]{
            '䀅',
            '䁘',
            '䃰',
            '䃚',
            '䂷',
            '䂗',
            '䅣',
            '䅃',
            '䅯',
            '䄋',
            '䇣',
            '䇘',
            '䆢',
            '䆞',
            '䉠',
            '䉍',
            '䈴',
            '䉆',
            '䋱',
            '䋌',
            '䊱',
            '䊍',
            '䍴',
            '䍇',
            '䍗',
            '䍾',
            '䌊',
            '䏽',
            '䏗',
            '䎶',
            '䎊'
         },
         -1499053993
      );
      CheckerBridge var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'\ue21b', '\ue244', '\ue2e5', '\ue2c9', '\ue2be', '\ue283', '\ue377', '\ue357'}, 1768546891);
      this.x = var10001;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'궃', '귇', '깼', '깂', '긫', '긖'}, -1755206198);
      this.y = var10001;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'崒', '嵋', '巶', '巂', '嶡', '嶄', '干', '幬'}, -933339834);
      this.z = var10001;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'㜱', '㞼', '㟞', '㞨', '㟏', '㡍', '㡂', '㠾', '㠅', '㣯', '㣛', '㢻'}, -328124557);
      this.aa = var10001;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'ओ', '॔', 'ৼ', '\u09d9', '\u09bb', 'ং', '\u0a7d', 'ਔ', '\u0a11', 'ਓ', 'ૣ'}, -1435563685);
      this.ab = var10001;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'ᖰ', 'ᘽ', 'ᙛ', 'ᘢ', 'ᘄ', 'ᛮ', 'ᛀ', 'ᚮ', 'ᚉ', 'ᜫ', 'ᝦ', 'ᜨ', 'ᜊ', '២', '៊'}, 459281908);
      this.ac = var10001;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'蜒', '蝗', '蟱', '蟐', '螾', '螙', '衽', '衔', '蠺', '蠅', '袰', '裩', '袼', '袄', '襩', '襅', '褮', '褚'}, 1204193114);
      this.ad = var10001;
      BlockCalculator var7 = new BlockCalculator("", 0.0, 1.0, 0.15, 0.05);
      var7.n(new char[]{'䍣', '䍮', '䌰', '䌆', '䎽', '䏺', '䎲', '䎖', '䑵'}, -280607967);
      this.ae = var7;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'ꏄ', 'ꎘ', 'ꎰ', 'ꎘ', 'ꑵ', 'ꐒ', 'ꑹ', 'ꐶ', '꒺', 'ꒇ'}, 1806934935);
      this.af = var10001;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'珚', '玚', '玦', '玆', '瑽', '瑙', '琡', '琋', '璭', '璃', '瓫', '璨', '畦', '畐'}, -2065140843);
      this.ag = var10001;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'ꆢ', 'ꈾ', 'ꉄ', 'ꈫ', 'ꈁ', 'ꋩ', 'ꋟ', 'ꊥ', 'ꊇ'}, -1606049295);
      this.ah = var10001;
      this.ai = new SlotEntry("C.olor", "Theme", "Theme", "White", "Cyan", "Pink", "Red", "Gold", "Orange", "Violet", "Health", "Team");
      PlacementEntry var11 = new PlacementEntry("", 0.0, 100.0, 0.0, 1.0);
      var11.n(new char[]{'䊮', '䌤', '䍺', '䌘', '䍇', '䏀', '䏌', '䎼'}, 198263531);
      this.aj = var11;
      BlockCalculator var12 = new BlockCalculator("", 16.0, 256.0, 128.0, 8.0);
      var12.n(new char[]{'븵', '뺨', '뻄', '뺪', '뺄', '뽧'}, 1709948519);
      this.ak = var12;
      PlacementEntry var13 = new PlacementEntry("", 0.0, 1.0, 0.0, 1.0);
      var13.n(new char[]{'涵', '游', '湚', '測', '湓', '滁', '滅', '溩', '溃', '潫'}, 1039822327);
      this.al = var13;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'뷀', '붍', '붫', '붒', '빴', '빾', '빐', '븾', '븙', '뺻', '뻼', '뺸', '뺜', '뽲'}, 1364376964);
      this.am = var10001;
      this.an = new SlotEntry("S.tyle", "Outline", "Outline", "Soft", "Sharp");
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'⣱', '⣶', '⢘', '⥥', '⥁', '⤽', '⤟', '⧷', '⦑', '⦝', '⦀', '⩬', '⩞'}, -260560711);
      this.ao = var10001;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'䵲', '䵯', '䴁', '䴌', '䷭', '䷔', '䶪', '䶞', '为', '乴', '丷', '丕', '以'}, -1187689182);
      this.ap = var10001;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'릣', '먫', '멊', '먧', '멂', '뫂', '뫒', '뫆', '몭', '몉', '뭽', '뭗', '묩'}, -780748314);
      this.aq = var10001;
      this.ar = new SlotEntry("T.arg" + "et Highli" + "g" + "ht", "White", "Off", "White", "Red", "Orange", "Gold", "Pink", "Violet");
      this.as = new Vector4f();
      this.cs = true;
      this.cu = new float[14];
      this.cv = new boolean[14];
      this.dh = new float[4];
      this.dq = Integer.MIN_VALUE;
      this.dr = Integer.MIN_VALUE;
      this.ds = Integer.MIN_VALUE;
      this.du = Integer.MIN_VALUE;
      this.dw = new Matrix4f();
      this.dx = new Matrix4f();
      this.dy = new Matrix4f();
      this.eq = -1;
      this.eu = 128.0F;
      this.ev = 15.36F;
      this.ex = true;
      this.ez = -1;
      this.fa = -1.0F;
      this.ft = new float[8];
      this.fu = new float[8];
      this.fv = new float[8];
      this.fw = new float[33];
      this.gi = new int[512];
      this.gj = new int[512];
      this.gk = new float[512];
      this.gl = new float[512];
      this.gm = new float[512];
      this.gn = new float[512];
      this.go = new float[512];
      this.gp = new float[512];
      this.gq = new float[512];
      this.gr = new float[512];
      this.gs = new float[512];
      this.gt = new float[512];
      this.gv = new int[512];
      this.gx = new int[512];
      this.gy = new double[512];
      this.gz = new double[512];
      this.ha = new double[512];
      this.hb = new double[512];
      this.hc = new double[512];
      this.hd = new double[512];
      this.he = new float[512];
      this.hf = new float[512];
      this.hg = new float[512];
      this.hh = new float[512];
      this.hi = new float[512];
      this.hj = new float[512];
      this.hk = new int[512];
      this.hl = new int[512];
      this.hm = new float[512];
      this.hn = new float[512];
      this.ho = new int[512];
      this.hp = new int[512];
      this.hr = new Entity[64];
      this.hs = new int[64];
      this.ht = new boolean[64];
      this.hu = new int[64];
      this.hv = new int[64];
      this.hw = new int[64];
      this.hy = new PlayerEntity[64];
      this.hz = new int[64];
      this.ia = new int[64];
      this.a(
         new InitAdapter[]{
            this.x,
            this.y,
            this.z,
            this.aa,
            this.ab,
            this.ac,
            this.ad,
            this.ae,
            this.af,
            this.ag,
            this.ah,
            this.ai,
            this.aj,
            this.ak,
            this.al,
            this.am,
            this.an,
            this.ao,
            this.ap,
            this.aq,
            this.ar
         }
      );
      Arrays.fill(this.gi, Integer.MIN_VALUE);
      Arrays.fill(this.gj, Integer.MIN_VALUE);
      bf = this;
   }

   @Override
   public void c() {

      if (this.aj.p() < 1.0) {
         this.ag.a(Boolean.TRUE);
         this.aj.a(Double.valueOf(1.0));
      }

      if (!RUN) {
         this.cq = 0.0F;
         this.cr = System.nanoTime();
         this.cs = true;
         RUN = true;
      }

      super.c();
   }

   @Override
   public void d() {

      BoundQuadCache.OL = false;
      super.d();
   }

   public static void a(Matrix4f var0, Matrix4f var1) {

      NodeCacheGroup var2 = bf;
      if (var2 == null) {
         RUN = false;
      } else {
         var2.b(var0, var1);
      }
   }

   private boolean b(Matrix4f var1, Matrix4f var2) {

      boolean var3 = super.f;
      long var4 = System.nanoTime();
      long var6 = var4 - this.cr;
      boolean var8 = this.cr == 0L;
      boolean var9 = !var8 && (var6 < 0L || var6 > 250000000L);
      float var10 = !var8 && !var9 ? Math.min(0.1F, (float)var6 / 1.0E9F) : 0.0F;
      this.cr = var4;
      this.fn = var10;
      this.fm += (double)var10;
      float var11 = var9 ? (var3 ? 1.0F : 0.0F) : (var3 ? Math.min(1.0F, this.cq + var10 / 0.18F) : Math.max(0.0F, this.cq - var10 / 0.22F));
      this.cq = var11;
      if (!var3 && var11 <= 0.0F) {
         this.f_r64();
         return false;
      } else if (a.player == null || a.world == null) {
         return false;
      } else if (a.gameRenderer != null && a.getWindow() != null) {
         try {
            this.g(var1, var2, var3, var9 || var8);
         } catch (Throwable var13) {
            BoundQuadCache.OL = false;
         }

         return true;
      } else {
         return false;
      }
   }

   private void f_r64() {

      RUN = false;
      BoundQuadCache.OL = false;
      this.cr = 0L;
      this.cq = 0.0F;
      Arrays.fill(this.gi, 2011701984 ^ -135781664);
      this.hq = 0;
      this.fg = null;
      this.ff = false;
      this.dq = 1072269075 ^ -1075214573;
      this.ds = 200101654 ^ -1947381994;
      BoundQuadCache.m();
   }

   private void g(Matrix4f var1, Matrix4f var2, boolean var3, boolean var4) {

      float var5 = this.fn;
      float var6 = this.cq;
      boolean[] var7 = this.cv;
      boolean var8 = var4 || this.cs;
      long var9 = this.cr;
      boolean var11 = var8 || a.currentScreen != null || var9 - this.ey >= 50000000L || var9 - this.ey < 0L;
      if (var11) {
         this.ey = var9;
         var7[0] = this.x.f();
         var7[1] = this.y.f();
         var7[2] = this.z.f();
         var7[3] = this.ag.f();
         var7[4] = this.aa.f();
         var7[5] = this.ab.f();
         var7[6] = this.ac.f();
         var7[7] = this.ah.f();
         var7[8] = this.af.f();
         var7[9] = this.ad.f();
         var7[11] = this.ao.f();
         var7[12] = this.ap.f();
         var7[13] = this.aq.f();
         String var12 = this.ar.f();
         if (var12 != this.dv) {
            this.dv = var12;
            int var13 = this.ar.g().indexOf(var12);
            this.dp = var13 > 0 && var13 < ax.length ? var13 : 0;
         }

         float var48 = (float)this.ak.p();
         this.eu = var48 < 8.0F ? 8.0F : var48;
         this.ev = Math.max(4.0F, this.eu * 0.12F);
         String var14 = this.an.f();
         boolean var15 = var14 == null || var14.isEmpty() || var14.charAt(0) != 'S';
         var7[10] = var15;
         this.ew = !var15 && var14.length() > 1 && var14.charAt(1) == 'h';
         this.ex = this.am.f();
      }

      this.ct = var8;
      this.cs = false;
      float[] var47 = this.cu;
      float var49 = var5 / 0.18F;
      float var50 = var5 / 0.22F;

      for (int var51 = 0; var51 < 14; var51++) {
         var47[var51] = var8 ? (var7[var51] ? 1.0F : 0.0F) : (var7[var51] ? Math.min(1.0F, var47[var51] + var49) : Math.max(0.0F, var47[var51] - var50));
      }

      float var52 = Math.min(var6, var47[0]);
      float var16 = Math.min(var6, var47[1]);
      float var17 = Math.min(var6, Math.max(var47[11], Math.max(var47[12], var47[13])));
      float var18 = Math.min(var6, var47[3]);
      this.cw = var18 * var18 * (3.0F - 2.0F * var18);
      var18 = var47[4];
      this.cx = var18 * var18 * (3.0F - 2.0F * var18);
      var18 = Math.min(var6, var47[5]);
      this.cy = var18 * var18 * (3.0F - 2.0F * var18);
      var18 = Math.min(var6, var47[6]);
      this.cz = var18 * var18 * (3.0F - 2.0F * var18);
      var18 = Math.min(var6, var47[7]);
      this.da = var18 * var18 * (3.0F - 2.0F * var18);
      var18 = Math.min(var6, var47[2]);
      this.db = var18 * var18 * (3.0F - 2.0F * var18);
      float[] var19 = this.dh;
      var18 = var47[0];
      var19[0] = var18 * var18 * (3.0F - 2.0F * var18);
      var18 = var47[11];
      var19[1] = var18 * var18 * (3.0F - 2.0F * var18);
      var18 = var47[12];
      var19[2] = var18 * var18 * (3.0F - 2.0F * var18);
      var18 = var47[13];
      var19[3] = var18 * var18 * (3.0F - 2.0F * var18);
      var18 = var47[8];
      this.dc = var18 * var18 * (3.0F - 2.0F * var18);
      var18 = var47[9];
      this.dd = var18 * var18 * (3.0F - 2.0F * var18);
      this.de = var16 * var16 * (3.0F - 2.0F * var16);
      var18 = Math.min(var16, var47[2]);
      this.df = var18 * var18 * (3.0F - 2.0F * var18);
      var18 = var47[10];
      this.dg = var18 * var18 * (3.0F - 2.0F * var18);
      this.di = var3 && this.cw >= 0.5F && this.dg >= 0.5F;
      this.fo = var8 ? 1.0F : 1.0F - (float)Math.exp((double)(-12.0F * var5));
      this.fq = this.fq + 1 & (2050967299 ^ 1170258172);
      int var20 = System.identityHashCode(a.world);
      if (var20 != this.fs) {
         this.fs = var20;
         Arrays.fill(this.gi, -716710877 ^ 1430772771);
         this.hq = 0;
         HIT_ID = 591819124 ^ -1555664524;
         this.ds = 373232172 ^ -1774251476;
         BoundQuadCache.m();
      }

      int var21 = this.dp;
      this._kwren_do = ax[var21];
      if (var21 > 0) {
         this.dn = true;
         this.dr = HIT_ID;
         int var22 = BoundQuadCache.l(BoundQuadCache.AIM_ID, var9);
         this.dq = BoundQuadCache.k(this.dr, HIT_NS, var9, this.ds, var22, 3000000000L);
      } else {
         if (this.dn) {
            BoundQuadCache.m();
         }

         this.dn = false;
         this.dr = -933034681 ^ 1214448967;
         this.dq = -563386860 ^ 1584096788;
      }

      this.du = 1430444686 ^ -717038962;
      Vec3d var66 = a.gameRenderer.getCamera().getCameraPos();
      this.dz = var66.x;
      this.ea = var66.y;
      this.eb = var66.z;
      this.ef = Math.max(1, a.getWindow().getScaleFactor());
      this.eg = (float)a.getWindow().getFramebufferWidth();
      this.eh = (float)a.getWindow().getFramebufferHeight();
      this.ei = this.eg / (float)this.ef;
      this.ej = this.eh / (float)this.ef;
      this.dw.set(var2);
      this.dx.set(var1);
      this.ek = a.getRenderTickCounter().getTickProgress(true);
      this.el = a.getRenderTickCounter().getTickProgress(false);
      float var23 = this.ek;
      this.ec = MathHelper.lerp((double)var23, a.player.lastRenderX, a.player.getX());
      this.ed = MathHelper.lerp((double)var23, a.player.lastRenderY, a.player.getY());
      this.ee = MathHelper.lerp((double)var23, a.player.lastRenderZ, a.player.getZ());
      if (var11) {
         this.em = (int)(this.ae.p() * 255.0);
         String var24 = this.ai.f();
         if (var24 != this.et) {
            this.et = var24;
            this.es = this.ai.g().indexOf(var24);
         }
      }

      int var67 = this.es;
      this.dl = var67 == 8;
      this.dm = var67 == 9;
      int var25;
      if (var67 > 0 && var67 < at.length) {
         var25 = at[var67];
      } else {
         try {
            var25 = RegionPassCache.i() & (418540509 ^ 403543074);
         } catch (Throwable var45) {
            var25 = -1169814880 ^ -1162218145;
         }
      }

      if (var25 != this.eq) {
         this.eq = var25;
         this.er = q(var25);
      }

      int var26 = this.er;
      float var27 = (float)(var26 >> 16 & (248451173 ^ 248451226));
      float var28 = (float)(var26 >> 8 & (-404512034 ^ -404512223));
      float var29 = (float)(var26 & (242361042 ^ 242360877));
      if (!var8 && this.ff) {
         float var30 = 1.0F - (float)Math.exp((double)(-14.0F * var5));
         this.fc = this.fc + (var27 - this.fc) * var30;
         this.fd = this.fd + (var28 - this.fd) * var30;
         this.fe = this.fe + (var29 - this.fe) * var30;
      } else {
         this.fc = var27;
         this.fd = var28;
         this.fe = var29;
         this.ff = true;
      }

      int var68 = Math.round(this.fc) << 16 | Math.round(this.fd) << 8 | Math.round(this.fe);
      this.en = var68;
      float var31 = this.dd;
      if (var68 != this.ez || var31 != this.fa) {
         this.ez = var68;
         this.fa = var31;
         this.eo = r(var68, -1116568896 ^ -1116575937, var31);
         this.ep = r(1949228948 ^ 1959862379, 1123538108 ^ 1123496259, var31);
      }

      this.fg = (var7[9] || var47[9] > 0.0F) && ConfigBridge.c != null ? ConfigBridge.c.e() : null;
      if (this.fg != null && this.fg.d()) {
         this.fg = null;
      }

      BoundQuadCache.rn = 0;
      cn = 0;
      this.ib = 0;
      this.dj = false;
      this.dk = false;
      this.hx = 0;
      if (var52 > 0.0F) {
         try {
            this.h_r65();
         } catch (Throwable var44) {
         }
      }

      if (var16 > 0.0F || var17 > 0.0F) {
         try {
            this.i_r66();
         } catch (Throwable var43) {
         }
      }

      boolean var32 = var52 > 0.0F || var17 > 0.0F;
      if (var32) {
         try {
            BoundQuadCache.i(this.hu, this.hx, this.hv);
         } catch (Throwable var42) {
            Arrays.fill(this.hv, 0);
         }

         try {
            this.l_r68();
         } catch (Throwable var41) {
         }

         try {
            this.j_r67();
         } catch (Throwable var40) {
         }

         try {
            this.l_r68();
         } catch (Throwable var39) {
         }

         if (this.hx != 0) {
            Arrays.fill(this.hr, null);
            this.hx = 0;
         }

         BoundQuadCache.ar = this.en;
         BoundQuadCache.pFr = this.eo;
         BoundQuadCache.pHp = this.dl;
         BoundQuadCache.as = this.dm;
         BoundQuadCache.pTgt = this._kwren_do;
         BoundQuadCache.at = this.dn;
         BoundQuadCache.pCx = this.eg * 0.5F;
         BoundQuadCache.pCy = this.eh * 0.5F;
         BoundQuadCache.au = 2.0F * (float)this.ef;

         try {
            BoundQuadCache.n(this.ia, this.ho);
         } catch (Throwable var38) {
            this.ib = 0;
            BoundQuadCache.AIM_ID = 1528529053 ^ -618954595;
         }

         try {
            this.m_r114();
         } catch (Throwable var37) {
         }
      } else {
         BoundQuadCache.AIM_ID = 532133815 ^ -1615349833;
      }

      this.ds = this.du;

      try {
         BoundQuadCache.j(this.hz, this.ia, this.ib, this.di && this.ib > 0, var20, this.dj, this.dk);
      } catch (Throwable var46) {
         BoundQuadCache.OL = false;
      }

      BoundQuadCache.y = (float)this.ef;
      BoundQuadCache.fbW = this.eg;
      BoundQuadCache.fbH = this.eh;
      BoundQuadCache.z = this.ew;
      BoundQuadCache.wCrn = this.cx;
      BoundQuadCache.aHp = this.cy;
      BoundQuadCache.aTr = this.db;
      BoundQuadCache.aa = this.df;
      BoundQuadCache.ab = Math.max(0, Math.min(1826399568 ^ 1826399663, this.em));
      BoundQuadCache.frTr = this.ep;
      BoundQuadCache var33 = BoundQuadCache.ME;
      var33.p();
      boolean var34 = this.cz > 0.0F && BoundQuadCache.rn > 0;
      if ((var33.d() > 0 || var34) && BoundQuadCache.e(this.dx, RenderSystem.getModelViewMatrix()) && BoundQuadCache.f() && var34) {
         try {
            this.o();
         } catch (Throwable var36) {
         }
      }

      if (++this.fp >= 60) {
         this.fp = 0;
         this.p();
      }
   }

   private void h_r65() {

      assert a.world != null
         && a.player != null
         && this.hr != null
         && this.hs != null
         && this.ht != null
         && this.hr.length == this.hs.length
         && this.hr.length == this.ht.length
         && this.hx >= 0
         && this.hr.length == this.hu.length
         && this.hr.length == this.hv.length
         && this.hr.length == this.hw.length
         && this.hx <= this.hr.length
         && this.eu >= 8.0F
         && this.ev > 0.0F
         && this.ef >= 1
         && this.eg >= 0.0F
         && this.eh >= 0.0F
         && this.fn >= 0.0F
         && this.fn <= 0.1F
         && this.hq >= 0
         && this.hq <= (1767520172 ^ 1767519788)
         && this.gi.length == (-2101191142 ^ -2101191654)
         && this.go.length == (2000361054 ^ 2000360542)
         && this.hi.length == (353934051 ^ 353933539);

      List var1 = a.world.getPlayers();
      double var2 = (double)this.eu * (double)this.eu;
      int var4 = var1.size();
      if (this.hr.length < this.hx + var4 + 1 + (-391395122 ^ -391394994)) {
         this.k(this.hx + var4 + 1 + (480053935 ^ 480054063));
      }

      Entity[] var5 = this.hr;
      int[] var6 = this.hs;
      int[] var7 = this.hu;
      int[] var8 = this.hw;
      boolean[] var9 = this.ht;
      int var10 = this.hx;

      try {
         for (int var11 = 0; var11 < var4; var11++) {
            PlayerEntity var12 = (PlayerEntity)var1.get(var11);
            if (var12 != null && var12 != a.player && !(var12.squaredDistanceTo(a.player) > var2)) {
               var5[var10] = var12;
               var6[var10] = -1;
               var9[var10] = false;
               var7[var10] = var12.getId();
               var8[var10] = 0;
               var10++;
            }
         }
      } catch (RuntimeException var13) {
         throw var13;
      }

      if (this.cu[8] > 0.0F && !a.options.getPerspective().isFirstPerson() && a.getCameraEntity() == a.player && !a.player.isSpectator()) {
         var5[var10] = a.player;
         var6[var10] = -1;
         var9[var10] = true;
         var7[var10] = a.player.getId();
         var8[var10] = 0;
         var10++;
      }

      this.hx = var10;
   }

   private void i_r66() {

      assert a.world != null
         && a.player != null
         && this.hr != null
         && this.hs != null
         && this.ht != null
         && this.hr.length == this.hs.length
         && this.hr.length == this.ht.length
         && this.hx >= 0
         && this.hr.length == this.hu.length
         && this.hr.length == this.hv.length
         && this.hr.length == this.hw.length
         && this.hx <= this.hr.length
         && this.eu >= 8.0F
         && this.cu.length == 14
         && this.cq >= 0.0F
         && this.cq <= 1.0F
         && this.gi.length == (1913223878 ^ 1913223366)
         && this.hq >= 0
         && this.hq <= (1794204544 ^ 1794204160);

      float var1 = this.cq;
      boolean var2 = Math.min(var1, this.cu[1]) > 0.0F;
      boolean var3 = Math.min(var1, this.cu[11]) > 0.0F;
      boolean var4 = Math.min(var1, this.cu[12]) > 0.0F;
      boolean var5 = Math.min(var1, this.cu[13]) > 0.0F;
      boolean var6 = var3 || var4 || var5;
      double var7 = (double)this.eu * (double)this.eu;
      int var9 = this.hx;
      Iterator var11 = a.world.getEntities().iterator();

      try {
         while (var11.hasNext()) {
            Entity var10 = (Entity)var11.next();
            if (var10 != null) {
               if (var10 instanceof ItemEntity) {
                  if (var2 && var10.squaredDistanceTo(a.player) <= var7) {
                     this.n((ItemEntity)var10);
                  }
               } else if (var6) {
                  byte var12;
                  if (var10 instanceof MobEntity) {
                     if (var10 instanceof Monster) {
                        if (!var3) {
                           continue;
                        }

                        var12 = 1;
                     } else {
                        if (!var4) {
                           continue;
                        }

                        var12 = 2;
                     }
                  } else {
                     if (!(var10 instanceof EndCrystalEntity) || !var5) {
                        continue;
                     }

                     var12 = 3;
                  }

                  if (!(var10.squaredDistanceTo(a.player) > var7)) {
                     if (var9 >= this.hr.length) {
                        this.hx = var9;
                        this.k(var9 + 64 + (-914993623 ^ -914993239));
                     }

                     this.hr[var9] = var10;
                     this.hs[var9] = -1;
                     this.ht[var9] = false;
                     this.hu[var9] = var10.getId();
                     this.hw[var9] = var12;
                     var9++;
                  }
               }
            }
         }
      } catch (RuntimeException var13) {
         this.hx = var9;
         throw var13;
      }

      this.hx = var9;
   }

   private void j_r67() {

      assert this.gi.length == (-863017460 ^ -863017972)
         && this.go.length == (1604831473 ^ 1604831985)
         && this.hi.length == (-1064226853 ^ -1064227365)
         && this.hk.length == (542354524 ^ 542355036)
         && this.gy.length == (-94656377 ^ -94655865)
         && this.ha.length == (175098116 ^ 175098628)
         && this.hc.length == (1522382799 ^ 1522382287)
         && this.he.length == (-907501186 ^ -907500674)
         && this.hg.length == (-387590044 ^ -387589532)
         && this.gk.length == (-2103457734 ^ -2103457222)
         && this.gv.length == (-975675496 ^ -975676008)
         && this.hq >= 0
         && this.hq <= (-50570834 ^ -50571218)
         && this.hx >= 0
         && this.hx <= this.hr.length
         && this.hr.length == this.hs.length
         && this.hr.length == this.ht.length
         && this.hr.length == this.hu.length
         && this.hr.length == this.hv.length
         && this.hr.length == this.hw.length;

      float var1 = (float)this.fm;
      int[] var2 = this.gi;
      int[] var3 = this.hk;
      float[] var4 = this.go;
      float[] var5 = this.hi;
      int var6 = this.hx;
      if (this.hr.length < var6 + (434819157 ^ 434819541)) {
         this.k(var6 + (-851813221 ^ -851813093));
      }

      Entity[] var7 = this.hr;
      int[] var8 = this.hs;
      int[] var9 = this.hu;
      int[] var10 = this.hv;
      int[] var11 = this.hw;
      boolean[] var12 = this.ht;

      try {
         for (int var13 = 0; var13 < (-1524119167 ^ -1524118655); var13++) {
            if (var2[var13] != (-1532067864 ^ 615415784) && (var3[var13] & 3) == 0) {
               float var14 = var1 - var4[var13];
               if (var14 > 0.0F && !(var14 >= 0.2F) && var5[var13] > 0.004F) {
                  var7[var6] = null;
                  var8[var6] = var13;
                  var12[var6] = false;
                  var9[var6] = Integer.MIN_VALUE;
                  var10[var6] = 0;
                  var11[var6] = var3[var13] >>> 4 & 3;
                  var6++;
               }
            }
         }
      } catch (RuntimeException var15) {
         throw var15;
      }

      this.hx = var6;
   }

   private void k(int var1) {

      int var2 = Math.max(var1, this.hr.length * 2);
      this.hr = Arrays.copyOf(this.hr, var2);
      this.hs = Arrays.copyOf(this.hs, var2);
      this.ht = Arrays.copyOf(this.ht, var2);
      this.hu = Arrays.copyOf(this.hu, var2);
      this.hv = Arrays.copyOf(this.hv, var2);
      this.hw = Arrays.copyOf(this.hw, var2);
   }

   private void l_r68() {

      assert this.hx >= 0
         && this.hx <= this.hr.length
         && this.ft.length == 8
         && this.fu.length == 8
         && this.fv.length == 8
         && this.ef >= 1
         && this.eg >= 0.0F
         && this.eh >= 0.0F
         && this.gi.length == (-1868488125 ^ -1868488637)
         && this.gk.length == (1358069484 ^ 1358068972)
         && this.gm.length == (-1470079806 ^ -1470079294)
         && this.go.length == (-501245158 ^ -501245670)
         && this.gq.length == (-1865318578 ^ -1865319090)
         && this.gv.length == (1580453481 ^ 1580452969)
         && this.gs.length == (1389570595 ^ 1389570083)
         && this.hq >= 0
         && this.hq <= (2114200438 ^ 2114200310)
         && this.em >= 0
         && this.em <= (-1269748499 ^ -1269748718)
         && this.fn >= 0.0F
         && this.fn <= 0.1F
         && this.fo >= 0.0F
         && this.fo <= 1.0F
         && this.cw >= 0.0F
         && this.cw <= 1.0F
         && this.db >= 0.0F
         && this.db <= 1.0F
         && this.dg >= 0.0F
         && this.dg <= 1.0F
         && this.ib >= 0
         && this.ib <= (-1004670543 ^ -1004670031)
         && this.hm.length == (-1677636892 ^ -1677637404)
         && this.ho.length == (-522920310 ^ -522920822)
         && this.hw.length == this.hr.length
         && this.dh.length == 4
         && BoundQuadCache.cn >= 0
         && BoundQuadCache.cn <= BoundQuadCache.al;

      int var1 = this.hx;
      if (BoundQuadCache.aj < BoundQuadCache.rn + var1) {
         BoundQuadCache.cap(BoundQuadCache.rn + var1);
      }

      if (BoundQuadCache.al < BoundQuadCache.cn + var1) {
         BoundQuadCache.a(BoundQuadCache.cn + var1);
      }

      if (this.hy.length < BoundQuadCache.aj) {
         this.hy = new PlayerEntity[BoundQuadCache.aj];
      }

      if (this.hz.length < this.ib + var1) {
         int var2 = Math.max(this.ib + var1, this.hz.length * 2);
         this.hz = Arrays.copyOf(this.hz, var2);
         this.ia = Arrays.copyOf(this.ia, var2);
      }

      float var109 = this.ek;
      float var3 = this.el;
      float var4 = this.eg;
      float var5 = this.eh;
      float var6 = (float)this.ef;
      float var7 = (float)this.fm;
      double var8 = this.dz;
      double var10 = this.ea;
      double var12 = this.eb;
      float[] var14 = this.ft;
      float[] var15 = this.fu;
      float[] var16 = this.fv;
      boolean var17 = this.di;
      float var18 = this.eu - this.ev * 0.5F;
      float var19 = this.dg;
      float var20 = this.fn / 0.15F;
      float var21 = this.fn / 0.1F;
      float var22 = this.fn / 0.12F;
      float var23 = this.fn / 0.25F;
      int var24 = this.dq;
      int var25 = this.dr;
      boolean var26 = this.dm;
      float[] var27 = this.dh;

      try {
         for (int var28 = 0; var28 < var1; var28++) {
            Entity var29 = this.hr[var28];
            this.hr[var28] = null;
            int var30 = this.hs[var28];
            boolean var31 = this.ht[var28];
            int var32 = this.hv[var28];
            int var33 = this.hw[var28] & 3;
            boolean var34 = var29 == null;
            if (!var34 || var30 >= 0) {
               try {
                  float var49 = 1.0F;
                  boolean var51 = false;
                  int var53 = -1;
                  int var54 = -1;
                  int var55 = 0;
                  boolean var56 = var33 == 0;
                  double var35;
                  double var37;
                  double var39;
                  double var41;
                  double var43;
                  int var45;
                  float var46;
                  float var47;
                  float var48;
                  float var50;
                  boolean var52;
                  if (!var34) {
                     float var57 = var56 ? var109 : (a.world.getTickManager().shouldSkipTick(var29) ? var3 : var109);
                     var35 = MathHelper.lerp((double)var57, var29.lastRenderX, var29.getX());
                     var37 = MathHelper.lerp((double)var57, var29.lastRenderY, var29.getY());
                     var39 = MathHelper.lerp((double)var57, var29.lastRenderZ, var29.getZ());
                     var41 = (double)var29.getWidth() / 2.0;
                     var43 = (double)var29.getHeight();
                     var52 = var33 != 3;
                     float var58 = 0.0F;
                     if (var52) {
                        var58 = (((LivingEntity)var29).getHealth() + ((LivingEntity)var29).getAbsorptionAmount()) / ((LivingEntity)var29).getMaxHealth();
                        if (!(var58 > 0.0F)) {
                           var58 = 0.0F;
                        } else if (var58 > 1.0F) {
                           var58 = 1.0F;
                        }
                     }

                     boolean var59 = false;
                     if (var56) {
                        EntityPose var60 = var29.getPose();
                        var59 = (var60 == EntityPose.STANDING || var60 == EntityPose.CROUCHING)
                           && ((LivingEntity)var29).deathTime <= 0
                           && !var29.isSpectator();
                     }

                     var45 = var29.getId();
                     boolean var117 = var45 == var24;
                     if (var45 == var25) {
                        this.du = var45;
                     }

                     int[] var61 = this.gi;
                     int var62 = var45 * (-257968355 ^ 1856556716) >>> 23;

                     for (int var63 = 0; var63 < (910509441 ^ 910509953); var63++) {
                        int var64 = var61[var62];
                        if (var64 == var45) {
                           var53 = var62;
                           break;
                        }

                        if (var64 == (348904416 ^ -1798579232)) {
                           if (this.hq < (417030285 ^ 417030413)) {
                              var61[var62] = var45;
                              this.go[var62] = -1000.0F;
                              this.hq++;
                              var53 = var62;
                           }
                           break;
                        }

                        var62 = var62 + 1 & (1784048643 ^ 1784049148);
                     }

                     if (var53 >= 0) {
                        if (var7 - this.go[var53] > 0.25F) {
                           this.gk[var53] = var58;
                           this.gm[var53] = this.ct ? 1.0F : 0.0F;
                           this.gq[var53] = var59 ? 1.0F : 0.0F;
                           this.gv[var53] = -1;
                           this.gs[var53] = 0.0F;
                           this.hm[var53] = 0.0F;
                        }

                        var46 = this.gk[var53] + (var58 - this.gk[var53]) * this.fo;
                        this.gk[var53] = var46;
                        var47 = Math.min(1.0F, this.gm[var53] + this.fn / 0.15F);
                        this.gm[var53] = var47;
                        float var110 = this.gq[var53] + (var59 ? this.fn : -this.fn) / 0.15F;
                        var48 = var110 < 0.0F ? 0.0F : (var110 > 1.0F ? 1.0F : var110);
                        this.gq[var53] = var48;
                        float var111 = this.hm[var53] + (var117 ? var22 : -var23);
                        var50 = var111 < 0.0F ? 0.0F : (var111 > 1.0F ? 1.0F : var111);
                        this.hm[var53] = var50;
                        this.go[var53] = var7;
                        this.gy[var53] = var35;
                        this.ha[var53] = var37;
                        this.hc[var53] = var39;
                        this.he[var53] = (float)var41;
                        this.hg[var53] = (float)var43;
                        this.hk[var53] = (var31 ? 1 : 0) | (var56 ? 0 : 4) | (var52 ? 0 : 8) | var33 << 4;
                        this.hi[var53] = 0.0F;
                        if (this.fg != null && var56) {
                           int var119 = this.gv[var53];
                           if (var119 >= 0 && (this.fq - (var119 >> 1) & (1250283611 ^ 1970941860)) < 20) {
                              var51 = (var119 & 1) != 0;
                           } else {
                              try {
                                 var51 = this.fg.c(((PlayerEntity)var29).getGameProfile().name());
                              } catch (Throwable var106) {
                              }

                              this.gv[var53] = this.fq << 1 | (var51 ? 1 : 0);
                           }
                        }
                     } else {
                        var46 = var58;
                        var47 = 1.0F;
                        var48 = var59 ? 1.0F : 0.0F;
                        var50 = var117 ? 1.0F : 0.0F;
                        if (this.fg != null && var56) {
                           try {
                              var51 = this.fg.c(((PlayerEntity)var29).getGameProfile().name());
                           } catch (Throwable var105) {
                           }
                        }
                     }

                     if (var26 && var29.getScoreboardTeam() != null) {
                        Integer var120 = var29.getScoreboardTeam().getColor().getColorValue();
                        if (var120 != null) {
                           var54 = var120 & (-173460720 ^ -178860817);
                        }
                     }
                  } else {
                     var53 = var30;
                     var35 = this.gy[var30];
                     var37 = this.ha[var30];
                     var39 = this.hc[var30];
                     var41 = (double)this.he[var30];
                     var43 = (double)this.hg[var30];
                     var45 = this.gi[var30];
                     var46 = this.gk[var30];
                     var47 = 1.0F;
                     var48 = 0.0F;
                     var51 = this.gv[var30] >= 0 && (this.gv[var30] & 1) != 0;
                     int var112 = this.hk[var30];
                     var33 = var112 >>> 4 & 3;
                     var56 = var33 == 0;
                     var52 = (var112 & 8) == 0;
                     var50 = this.hm[var30];
                     var55 = this.ho[var30];
                     float var114 = 1.0F - (var7 - this.go[var30]) / 0.2F;
                     var114 = var114 < 0.0F ? 0.0F : (var114 > 1.0F ? 1.0F : var114);
                     var49 = var114 * var114 * (3.0F - 2.0F * var114) * this.hi[var30];
                  }

                  double var113 = var35 - this.ec;
                  double var116 = var37 - this.ed;
                  double var118 = var39 - this.ee;
                  float var121 = (float)Math.sqrt(var113 * var113 + var116 * var116 + var118 * var118);
                  float var122 = 0.0F;
                  if (!var31 && this.ex) {
                     float var65 = (var121 - 12.0F) / Math.max(1.0F, this.eu - 12.0F);
                     var65 = var65 < 0.0F ? 0.0F : (var65 > 1.0F ? 1.0F : var65);
                     var122 = var65 * var65 * (3.0F - 2.0F * var65);
                  }

                  int var124 = BoundQuadCache.cn++;
                  BoundQuadCache.ck[var124] = var33;
                  BoundQuadCache.cfl[var124] = (var51 ? 1 : 0) | (var52 ? 2 : 0) | (var31 ? 4 : 0) | (var34 ? 8 : 0);
                  BoundQuadCache.csh[var124] = var46;
                  BoundQuadCache.am[var124] = var54;
                  BoundQuadCache.ctw[var124] = var50;
                  BoundQuadCache.an[var124] = var122;
                  BoundQuadCache.ao[var124] = var55;
                  BoundQuadCache.cid[var124] = var45;
                  BoundQuadCache.aq[var124] = var34 ? -1 : var53;
                  BoundQuadCache.cri[var124] = -1;
                  BoundQuadCache.coi[var124] = -1;
                  float var66 = var27[var33];
                  if (var17 && !var34 && var66 >= 0.5F && (var31 ? this.dc >= 0.5F : var121 <= var18)) {
                     if (this.ib < (-646203526 ^ -646204038)) {
                        BoundQuadCache.coi[var124] = this.ib;
                        this.hz[this.ib] = var45;
                        this.ia[this.ib] = 0;
                        this.ib++;
                        if (var33 == 3) {
                           this.dk = true;
                        } else if (!var56) {
                           this.dj = true;
                        }
                     } else {
                        var32 = 1;
                     }
                  }

                  float var67 = 0.0F;
                  int var68 = 0;

                  for (int var69 = 0; var69 < 8; var69++) {
                     double var70 = var35 + ((var69 & 1) == 0 ? -var41 : var41);
                     double var72 = var39 + ((var69 & 2) == 0 ? -var41 : var41);
                     double var74 = var37 + ((var69 & 4) == 0 ? 0.0 : var43);
                     this.as.set((float)(var70 - var8), (float)(var74 - var10), (float)(var72 - var12), 1.0F);
                     this.as.mul(this.dw);
                     this.as.mul(this.dx);
                     float var76 = this.as.w;
                     var14[var69] = this.as.x;
                     var15[var69] = this.as.y;
                     var16[var69] = var76;
                     var67 += var76;
                     if (var76 > 0.05F) {
                        var68++;
                     }
                  }

                  float var125 = var67 * 0.125F;
                  if (var125 > 0.05F) {
                     float var126 = Float.MAX_VALUE;
                     float var71 = Float.MAX_VALUE;
                     float var129 = -Float.MAX_VALUE;
                     float var73 = -Float.MAX_VALUE;

                     for (int var132 = 0; var132 < 8; var132++) {
                        float var75 = var16[var132];
                        boolean var137 = var75 > 0.05F;
                        if (var137) {
                           float var77 = var14[var132] / var75;
                           float var78 = var15[var132] / var75;
                           var126 = Math.min(var126, var77);
                           var129 = Math.max(var129, var77);
                           var71 = Math.min(var71, var78);
                           var73 = Math.max(var73, var78);
                        }

                        if (var68 != 8) {
                           for (byte var139 = 1; var139 < 8; var139 <<= 1) {
                              if ((var132 & var139) == 0) {
                                 int var141 = var132 | var139;
                                 float var79 = var16[var141];
                                 if (var137 != var79 > 0.05F) {
                                    float var80 = (0.05F - var75) / (var79 - var75);
                                    float var81 = (var14[var132] + (var14[var141] - var14[var132]) * var80) / 0.05F;
                                    float var82 = (var15[var132] + (var15[var141] - var15[var132]) * var80) / 0.05F;
                                    var126 = Math.min(var126, var81);
                                    var129 = Math.max(var129, var81);
                                    var71 = Math.min(var71, var82);
                                    var73 = Math.max(var73, var82);
                                 }
                              }
                           }
                        }
                     }

                     if (var126 <= var129 && var71 <= var73) {
                        float var133;
                        if (var34) {
                           var133 = this.gs[var30];
                        } else if (var53 >= 0) {
                           float var135 = this.gs[var53];
                           if (var32 != 0 && var68 == 8 && var129 > -1.0F && var126 < 1.0F && var73 > -1.0F && var71 < 1.0F) {
                              var135 = var32 == 2 ? Math.max(0.0F, var135 - var21) : Math.min(1.0F, var135 + var20);
                           } else if (var19 < 0.5F) {
                              var135 = Math.max(0.0F, var135 - var21);
                           }

                           this.gs[var53] = var135;
                           var133 = var135;
                        } else {
                           var133 = var32 == 1 ? 1.0F : 0.0F;
                        }

                        var133 = var133 * var133 * (3.0F - 2.0F * var133);
                        float var136 = this.cw * (1.0F - var19 * (1.0F - var133));
                        float var138 = 0.0F;
                        float var140 = 0.0F;
                        boolean var142 = false;
                        float var143 = (var126 + var129) * 0.5F;
                        float var144 = Math.max(Math.abs(var143), Math.abs(var73));
                        if (var144 > 3.0F || var126 < -3.0F || var129 > 3.0F) {
                           float var145 = var144 > 3.0F ? 3.0F / var144 : 1.0F;
                           var138 = (var143 * var145 * 0.5F + 0.5F) * var4;
                           var140 = (0.5F - var73 * var145 * 0.5F) * var5;
                           var142 = true;
                        }

                        var126 = Math.min(3.0F, Math.max(-3.0F, var126));
                        var129 = Math.min(3.0F, Math.max(-3.0F, var129));
                        var71 = Math.min(3.0F, Math.max(-3.0F, var71));
                        var73 = Math.min(3.0F, Math.max(-3.0F, var73));
                        float var146 = (var126 * 0.5F + 0.5F) * var4;
                        float var147 = (var129 * 0.5F + 0.5F) * var4;
                        float var83 = (0.5F - var73 * 0.5F) * var5;
                        float var84 = (0.5F - var71 * 0.5F) * var5;
                        float var85 = var84 - var83;
                        if (var147 - var146 < 2.0F * var6) {
                           float var86 = (var146 + var147) * 0.5F;
                           var146 = var86 - var6;
                           var147 = var86 + var6;
                        }

                        if (var84 - var83 < 4.0F * var6) {
                           float var148 = (var83 + var84) * 0.5F;
                           var83 = var148 - 2.0F * var6;
                           var84 = var148 + 2.0F * var6;
                        }

                        boolean var149 = var147 + 8.0F * var6 > 0.0F
                           && var146 - 8.0F * var6 < var4
                           && var84 + 12.0F * var6 > 0.0F
                           && var83 - 2.0F * var6 < var5;
                        float var87 = var31 ? 0.0F : this.db;
                        if (var149 || var87 > 0.0F) {
                           float var88 = (var125 - 0.05F) * 2.0F;
                           float var89 = var88 >= 1.0F ? 1.0F : var88 * var88 * (3.0F - 2.0F * var88);
                           double var90 = Math.abs(var8 - var35) - var41;
                           double var92 = Math.abs(var12 - var39) - var41;
                           double var94 = Math.max(var37 - var10, var10 - (var37 + var43));
                           var90 = var90 > 0.0 ? var90 : 0.0;
                           var94 = var94 > 0.0 ? var94 : 0.0;
                           var92 = var92 > 0.0 ? var92 : 0.0;
                           float var96 = (float)Math.sqrt(var90 * var90 + var94 * var94 + var92 * var92) * 4.0F;
                           if (var96 < 1.0F) {
                              var89 *= var96 * var96 * (3.0F - 2.0F * var96);
                           }

                           float var97 = 1.0F;
                           if (!var31) {
                              float var98 = (this.eu - var121) / this.ev;
                              var98 = var98 < 0.0F ? 0.0F : (var98 > 1.0F ? 1.0F : var98);
                              var97 = var98 * var98 * (3.0F - 2.0F * var98) * (1.0F - 0.4F * var122);
                           }

                           float var154 = var47 * var47 * (3.0F - 2.0F * var47) * (var31 ? this.dc : 1.0F) * var89 * var97 * var66;
                           float var99 = var34 ? var49 : var154;
                           if (!(var99 < 0.004F)) {
                              if (!var34 && var53 >= 0) {
                                 this.hi[var53] = var154;
                              }

                              int var100 = BoundQuadCache.rn;
                              if (var100 >= BoundQuadCache.aj) {
                                 break;
                              }

                              BoundQuadCache.rn = var100 + 1;
                              BoundQuadCache.cri[var124] = var100;
                              BoundQuadCache.rx0[var100] = var146;
                              BoundQuadCache.ry0[var100] = var83;
                              BoundQuadCache.rx1[var100] = var147;
                              BoundQuadCache.ry1[var100] = var84;
                              BoundQuadCache.rd[var100] = var125;
                              BoundQuadCache.ra[var100] = var99;
                              BoundQuadCache.rc[var100] = 0;
                              BoundQuadCache.rtw[var100] = 0.0F;
                              BoundQuadCache.rbw[var100] = var136;
                              BoundQuadCache.rhp[var100] = var46;
                              BoundQuadCache.rtx[var100] = var142 ? var138 : (var146 + var147) * 0.5F;
                              BoundQuadCache.rty[var100] = var142 ? var140 : var83;
                              BoundQuadCache.rba[var100] = 0.0F;
                              BoundQuadCache.ak[var100] = Math.min(-1396590421 ^ -1396590165, (int)var121);
                              BoundQuadCache.rla[var100] = !var31 && var149 ? (int)(255.0F * var99 * this.cz + 0.5F) : 0;
                              int var101 = (var31 ? 1 : 0)
                                 | (var51 ? 2 : 0)
                                 | (var149 ? 4 : 0)
                                 | (var34 ? 32 : 0)
                                 | (var56 ? 0 : 64)
                                 | (var52 ? 0 : -1946419158 ^ -1946419030);
                              float var102 = var99 * this.da;
                              this.hy[var100] = null;
                              if (!var34 && var56 && var149 && var102 > 0.0F && var85 > 8.0F * var6 && var48 > 0.0F) {
                                 float var103 = Math.min(1.0F, (var85 - 8.0F * var6) / (6.0F * var6));
                                 float var104 = var102 * var103 * var103 * (3.0F - 2.0F * var103) * var48;
                                 if (var104 * 255.0F >= 3.0F) {
                                    this.hy[var100] = (PlayerEntity)var29;
                                    BoundQuadCache.rba[var100] = var104;
                                    var101 |= 16;
                                 }
                              }

                              BoundQuadCache.rf[var100] = var101;
                           }
                        }
                     }
                  }
               } catch (Throwable var107) {
               }
            }
         }
      } catch (RuntimeException var108) {
         throw var108;
      }

      this.hx = 0;
   }

   private void m_r114() {

      assert BoundQuadCache.rn >= 0
         && BoundQuadCache.rn <= BoundQuadCache.aj
         && this.hy.length >= BoundQuadCache.rn
         && this.fw.length == 33
         && BoundQuadCache.rj.length >= BoundQuadCache.rn * 2 * 11
         && this.ef >= 1
         && this.eg >= 0.0F
         && this.eh >= 0.0F
         && this.ek >= 0.0F
         && this.ek <= 1.0F
         && this.dz == this.dz
         && this.ea == this.ea
         && this.eb == this.eb
         && BoundQuadCache.rf.length >= BoundQuadCache.rn
         && BoundQuadCache.rba.length >= BoundQuadCache.rn
         && this.eg == this.eg
         && this.eh == this.eh;

      int var1 = BoundQuadCache.rn;
      float var2 = this.ek;
      float var3 = this.eg;
      float var4 = this.eh;
      float[] var5 = this.fw;

      try {
         for (int var6 = 0; var6 < var1; var6++) {
            PlayerEntity var7 = this.hy[var6];
            if (var7 != null) {
               this.hy[var6] = null;
               if ((BoundQuadCache.rf[var6] & 16) != 0) {
                  try {
                     double var8 = MathHelper.lerp((double)var2, var7.lastRenderX, var7.getX());
                     double var10 = MathHelper.lerp((double)var2, var7.lastRenderY, var7.getY());
                     double var12 = MathHelper.lerp((double)var2, var7.lastRenderZ, var7.getZ());
                     boolean var14 = var7.getPose() == EntityPose.CROUCHING;
                     float var15 = var7.getScale();
                     float var16 = MathHelper.lerpAngleDegrees(var2, var7.lastBodyYaw, var7.bodyYaw) * (float) (Math.PI / 180.0);
                     float var17 = MathHelper.lerpAngleDegrees(var2, var7.lastHeadYaw, var7.headYaw) * (float) (Math.PI / 180.0);
                     float var18 = var7.getPitch(var2) * (float) (Math.PI / 180.0);
                     float var19 = var7.limbAnimator.getAnimationProgress(var2);
                     boolean var20 = var7.hasVehicle();
                     float var21 = var20 ? 0.0F : Math.min(1.0F, var7.limbAnimator.getAmplitude(var2));
                     float var22 = var7.getHandSwingProgress(var2);
                     boolean var23 = var7.getMainArm() == Arm.RIGHT;
                     boolean var24 = var7.preferredHand == Hand.MAIN_HAND == var23;
                     boolean var25 = !var7.getMainHandStack().isEmpty();
                     boolean var26 = !var7.getOffHandStack().isEmpty();
                     boolean var27 = var23 ? var25 : var26;
                     boolean var28 = var23 ? var26 : var25;
                     float var29 = var19 * 0.6662F;
                     float var30 = MathHelper.cos((double)var29) * 1.4F * var21;
                     float var31 = MathHelper.cos((double)(var29 + (float) Math.PI)) * 1.4F * var21;
                     float var32 = MathHelper.cos((double)(var29 + (float) Math.PI)) * var21;
                     float var33 = MathHelper.cos((double)var29) * var21;
                     if (var20) {
                        var32 -= (float) (Math.PI / 5);
                        var33 -= (float) (Math.PI / 5);
                        var30 = -1.4137167F;
                        var31 = -1.4137167F;
                     }

                     if (var27) {
                        var32 = var32 * 0.5F - (float) (Math.PI / 10);
                     }

                     if (var28) {
                        var33 = var33 * 0.5F - (float) (Math.PI / 10);
                     }

                     if (var22 > 0.0F) {
                        float var34 = 1.0F - var22;
                        var34 *= var34;
                        var34 *= var34;
                        var34 = 1.0F - var34;
                        float var35 = MathHelper.sin((double)(var34 * (float) Math.PI)) * 1.2F
                           + MathHelper.sin((double)(var22 * (float) Math.PI)) * -(var18 - 0.7F) * 0.75F;
                        if (var24) {
                           var32 -= var35;
                        } else {
                           var33 -= var35;
                        }
                     }

                     float var76 = MathHelper.sin((double)var16);
                     float var77 = MathHelper.cos((double)var16);
                     float var36 = -var76;
                     float var38 = -var77;
                     float var39 = -var76;
                     float var40 = (float)(var8 - this.dz);
                     float var41 = (float)(var10 - this.ea);
                     float var42 = (float)(var12 - this.eb);
                     float var43 = 1.406F;
                     float var44 = 0.0F;
                     if (var14) {
                        var43 -= 0.22F;
                        var44 = 0.15F;
                     }

                     float var45 = var40 + var36 * var44 * var15;
                     float var46 = var41 + var43 * var15;
                     float var47 = var42 + var77 * var44 * var15;
                     var5[3] = var45;
                     var5[4] = var46;
                     var5[5] = var47;
                     float var48 = 0.34F * var15;
                     float var49 = MathHelper.sin((double)var18);
                     var5[0] = var45 - MathHelper.sin((double)var17) * var49 * var48;
                     var5[1] = var46 + MathHelper.cos((double)var18) * var48;
                     var5[2] = var47 + MathHelper.cos((double)var17) * var49 * var48;
                     float var50 = 0.32F * var15;
                     float var51 = var45 - var38 * var50;
                     float var52 = var47 - var39 * var50;
                     float var53 = var45 + var38 * var50;
                     float var54 = var47 + var39 * var50;
                     var5[6] = var51;
                     var5[7] = var46;
                     var5[8] = var52;
                     var5[9] = var53;
                     var5[10] = var46;
                     var5[11] = var54;
                     float var55 = 0.7F * var15;
                     float var56 = -MathHelper.sin((double)var33) * var55;
                     float var57 = -MathHelper.sin((double)var32) * var55;
                     var5[12] = var51 + var36 * var56;
                     var5[13] = var46 - MathHelper.cos((double)var33) * var55;
                     var5[14] = var52 + var77 * var56;
                     var5[15] = var53 + var36 * var57;
                     var5[16] = var46 - MathHelper.cos((double)var32) * var55;
                     var5[17] = var54 + var77 * var57;
                     float var58 = var41 + 0.703F * var15;
                     float var59 = 0.117F * var15;
                     var5[18] = var40;
                     var5[19] = var58;
                     var5[20] = var42;
                     float var60 = var40 - var38 * var59;
                     float var61 = var42 - var39 * var59;
                     float var62 = var40 + var38 * var59;
                     float var63 = var42 + var39 * var59;
                     var5[21] = var60;
                     var5[22] = var58;
                     var5[23] = var61;
                     var5[24] = var62;
                     var5[25] = var58;
                     var5[26] = var63;
                     float var64 = 0.703F * var15;
                     float var65 = -MathHelper.sin((double)var31) * var64;
                     float var66 = -MathHelper.sin((double)var30) * var64;
                     var5[27] = var60 + var36 * var65;
                     var5[28] = var58 - MathHelper.cos((double)var31) * var64;
                     var5[29] = var61 + var77 * var65;
                     var5[30] = var62 + var36 * var66;
                     var5[31] = var58 - MathHelper.cos((double)var30) * var64;
                     var5[32] = var63 + var77 * var66;
                     float[] var67 = BoundQuadCache.rj;
                     int var68 = var6 * 2 * 11;

                     for (int var69 = 0; var69 < 11; var69++) {
                        this.as.set(var5[var69 * 3], var5[var69 * 3 + 1], var5[var69 * 3 + 2], 1.0F);
                        this.as.mul(this.dw);
                        this.as.mul(this.dx);
                        float var70 = this.as.w;
                        if (!(var70 > 0.05F)) {
                           var67[var68 + var69 * 2] = Float.NaN;
                           var67[var68 + var69 * 2 + 1] = Float.NaN;
                        } else {
                           var67[var68 + var69 * 2] = (this.as.x / var70 * 0.5F + 0.5F) * var3;
                           var67[var68 + var69 * 2 + 1] = (1.0F - (this.as.y / var70 * 0.5F + 0.5F)) * var4;
                        }
                     }
                  } catch (Throwable var71) {
                     BoundQuadCache.rf[var6] = BoundQuadCache.rf[var6] & -17;
                  }
               }
            }
         }
      } catch (RuntimeException var72) {
         throw var72;
      }
   }

   private void n(ItemEntity var1) {

      assert var1 != null
         && this.ft.length == 8
         && this.fu.length == 8
         && this.fv.length == 8
         && this.ef >= 1
         && this.eg >= 0.0F
         && this.eh >= 0.0F
         && this.gi.length == (943145100 ^ 943145612)
         && this.gm.length == (1544591714 ^ 1544592226)
         && this.go.length == (2045101679 ^ 2045101167)
         && this.hk.length == (-1030537513 ^ -1030538025)
         && this.hi.length == (99385271 ^ 99384759)
         && this.hq >= 0
         && this.hq <= (-642138754 ^ -642138882)
         && this.fn >= 0.0F
         && this.fn <= 0.1F
         && this.eu >= 8.0F
         && this.ev > 0.0F
         && this.de >= 0.0F
         && this.de <= 1.0F
         && this.df >= 0.0F
         && this.df <= 1.0F;

      try {
         float var2 = a.world.getTickManager().shouldSkipTick(var1) ? this.el : this.ek;
         double var3 = MathHelper.lerp((double)var2, var1.lastRenderX, var1.getX());
         double var5 = MathHelper.lerp((double)var2, var1.lastRenderY, var1.getY());
         double var7 = MathHelper.lerp((double)var2, var1.lastRenderZ, var1.getZ());
         double var9 = (double)var1.getHeight();
         double var11 = this.dz;
         double var13 = this.ea;
         double var15 = this.eb;
         float var17 = this.eg;
         float var18 = this.eh;
         float var19 = (float)this.ef;
         float var20 = 0.0F;
         float var21 = 0.0F;
         float var22 = 0.0F;
         float var23 = 0.0F;
         float var24 = 0.0F;

         for (int var25 = 0; var25 < 2; var25++) {
            double var26 = var25 == 0 ? var5 : var5 + var9;
            this.as.set((float)(var3 - var11), (float)(var26 - var13), (float)(var7 - var15), 1.0F);
            this.as.mul(this.dw);
            this.as.mul(this.dx);
            float var28 = this.as.w;
            if (!(var28 > 0.05F)) {
               return;
            }

            var24 = var28;
            float var29 = (this.as.x / var28 * 0.5F + 0.5F) * var17;
            float var30 = (1.0F - (this.as.y / var28 * 0.5F + 0.5F)) * var18;
            if (var25 == 0) {
               var20 = var29;
               var21 = var30;
            } else {
               var22 = var29;
               var23 = var30;
            }
         }

         float var49 = Math.max(4.0F * var19, Math.abs(var21 - var23)) * 0.5F;
         float var50 = (var20 + var22) * 0.5F;
         float var27 = (var21 + var23) * 0.5F;
         float var51 = var50 - var49;
         float var52 = var27 - var49;
         float var53 = var50 + var49;
         float var31 = var27 + var49;
         boolean var32 = var53 > 0.0F && var51 < var17 && var31 > 0.0F && var52 < var18;
         if (!var32 && !(this.df > 0.0F)) {
            return;
         }

         int var33 = var1.getId();
         int[] var34 = this.gi;
         int var35 = -1;
         int var36 = var33 * (-116082372 ^ 1730396301) >>> 23;

         for (int var37 = 0; var37 < (995783262 ^ 995782750); var37++) {
            int var38 = var34[var36];
            if (var38 == var33) {
               var35 = var36;
               break;
            }

            if (var38 == (707548188 ^ -1439935460)) {
               if (this.hq < (64489219 ^ 64489091)) {
                  var34[var36] = var33;
                  this.go[var36] = -1000.0F;
                  this.hq++;
                  var35 = var36;
               }
               break;
            }

            var36 = var36 + 1 & (-1847164576 ^ -1847164769);
         }

         float var54 = 1.0F;
         if (var35 >= 0) {
            float var55 = (float)this.fm;
            if (var55 - this.go[var35] > 0.25F) {
               this.gm[var35] = this.ct ? 1.0F : 0.0F;
            }

            var54 = Math.min(1.0F, this.gm[var35] + this.fn / 0.15F);
            this.gm[var35] = var54;
            this.go[var35] = var55;
            this.hk[var35] = 2;
            this.hi[var35] = 0.0F;
         }

         double var56 = var3 - this.ec;
         double var40 = var5 - this.ed;
         double var42 = var7 - this.ee;
         float var44 = (float)Math.sqrt(var56 * var56 + var40 * var40 + var42 * var42);
         float var45 = (this.eu - var44) / this.ev;
         var45 = var45 < 0.0F ? 0.0F : (var45 > 1.0F ? 1.0F : var45);
         float var46 = var54 * var54 * (3.0F - 2.0F * var54) * var45 * var45 * (3.0F - 2.0F * var45);
         if (var46 < 0.004F) {
            return;
         }

         int var47 = BoundQuadCache.rn;
         if (var47 >= BoundQuadCache.aj) {
            BoundQuadCache.cap(var47 + 1);
         }

         BoundQuadCache.rn = var47 + 1;
         BoundQuadCache.rx0[var47] = var51;
         BoundQuadCache.ry0[var47] = var52;
         BoundQuadCache.rx1[var47] = var53;
         BoundQuadCache.ry1[var47] = var31;
         BoundQuadCache.rd[var47] = var24;
         BoundQuadCache.ra[var47] = var46;
         BoundQuadCache.rc[var47] = 16766720;
         BoundQuadCache.rtw[var47] = 0.0F;
         BoundQuadCache.rbw[var47] = this.de;
         BoundQuadCache.rhp[var47] = 0.0F;
         BoundQuadCache.rba[var47] = 0.0F;
         BoundQuadCache.rtx[var47] = var50;
         BoundQuadCache.rty[var47] = var27;
         BoundQuadCache.ak[var47] = -1;
         BoundQuadCache.rla[var47] = 0;
         BoundQuadCache.rf[var47] = 8 | (var32 ? 4 : 0);
      } catch (Throwable var48) {
      }
   }

   private void o() {

      assert BoundQuadCache.rn >= 0
         && BoundQuadCache.rn <= BoundQuadCache.aj
         && BoundQuadCache.rla.length >= BoundQuadCache.rn
         && BoundQuadCache.ak.length >= BoundQuadCache.rn
         && fh.length == (-943972914 ^ -943973169)
         && fi.length == (-109401740 ^ -109401995)
         && fj.length == (-1880768069 ^ -1880768326)
         && this.ef >= 1
         && this.eg >= 0.0F
         && this.eh >= 0.0F
         && this.cz >= 0.0F
         && this.cz <= 1.0F
         && BoundQuadCache.exx == BoundQuadCache.exx
         && BoundQuadCache.eyy == BoundQuadCache.eyy
         && BoundQuadCache.ox == BoundQuadCache.ox
         && this.dy != null;

      TextRenderer var1 = a.textRenderer;
      VertexConsumerProvider.Immediate var2 = BoundQuadCache.g();
      if (var1 != null && var2 != null) {
         if (var1 != this.fk || this.fm - this.fl > 2.0 || this.fm < this.fl) {
            this.fk = var1;
            this.fl = this.fm;
            Arrays.fill(fj, -1);
         }

         float var3 = (float)this.ef;
         float var4 = BoundQuadCache.ox;
         float var5 = BoundQuadCache.oy;
         float var6 = BoundQuadCache.oz;
         float var7 = BoundQuadCache.exx;
         float var8 = BoundQuadCache.exy;
         float var9 = BoundQuadCache.exz;
         float var10 = BoundQuadCache.eyx;
         float var11 = BoundQuadCache.eyy;
         float var12 = BoundQuadCache.eyz;
         Matrix4f var13 = this.dy;
         int var14 = BoundQuadCache.rn;

         try {
            for (int var15 = 0; var15 < var14; var15++) {
               int var16 = BoundQuadCache.rla[var15];
               int var17 = BoundQuadCache.ak[var15];
               if (var16 >= 8 && var17 >= 0) {
                  if (var17 > (720814487 ^ 720814231)) {
                     var17 = -1130404148 ^ -1130403892;
                  }

                  OrderedText var18 = fi[var17];
                  if (var18 == null) {
                     String var19 = fh[var17];
                     if (var19 == null) {
                        var19 = var17 + "m";
                        fh[var17] = var19;
                     }

                     var18 = Language.getInstance().reorder(StringVisitable.plain(var19));
                     fi[var17] = var18;
                  }

                  int var24 = fj[var17];
                  if (var24 < 0) {
                     var24 = var1.getWidth(var18);
                     fj[var17] = var24;
                  }

                  float var20 = (BoundQuadCache.rx0[var15] + BoundQuadCache.rx1[var15]) * 0.5F;
                  float var21 = (float)Math.round(var20 - (float)var24 * var3 * 0.5F);
                  float var22 = (float)Math.round(BoundQuadCache.ry1[var15] + 2.0F * var3);
                  var13.set(
                     var7 * var3,
                     var8 * var3,
                     var9 * var3,
                     0.0F,
                     var10 * var3,
                     var11 * var3,
                     var12 * var3,
                     0.0F,
                     0.0F,
                     0.0F,
                     0.0F,
                     0.0F,
                     var4 + var21 * var7 + var22 * var10,
                     var5 + var21 * var8 + var22 * var11,
                     var6 + var21 * var9 + var22 * var12,
                     1.0F
                  );
                  var1.draw(
                     var18,
                     0.0F,
                     0.0F,
                     Math.min(270352432 ^ 270352591, var16) << 24 | 1719058639 ^ 1725725443,
                     true,
                     var13,
                     var2,
                     TextRenderer.TextLayerType.SEE_THROUGH,
                     0,
                     1372881395 ^ 1361346819
                  );
               }
            }
         } catch (RuntimeException var23) {
            throw var23;
         }

         var2.draw();
      }
   }

   private void p() {

      assert this.gi.length == (-273301693 ^ -273302205)
         && this.gj.length == (-163953816 ^ -163954328)
         && this.gk.length == (-693515118 ^ -693514606)
         && this.gl.length == (-991104681 ^ -991104169)
         && this.gm.length == (-616680072 ^ -616679560)
         && this.gn.length == (500120313 ^ 500119801)
         && this.go.length == (1733309910 ^ 1733310422)
         && this.gp.length == (-503621792 ^ -503622304)
         && this.gq.length == (-1133361757 ^ -1133361245)
         && this.gr.length == (-1989590186 ^ -1989590698)
         && this.gv.length == (6889803 ^ 6890315)
         && this.gx.length == (-554103018 ^ -554103530)
         && this.gy.length == (1013823587 ^ 1013824099)
         && this.gz.length == (-565025143 ^ -565025655)
         && this.hk.length == (1919359383 ^ 1919359895)
         && this.hl.length == (-1738008376 ^ -1738007864)
         && this.gs.length == (1847555321 ^ 1847555833)
         && this.gt.length == (2003525861 ^ 2003526373)
         && this.hm.length == (397744659 ^ 397744147)
         && this.hn.length == (624041298 ^ 624041810)
         && this.ho.length == (1588713843 ^ 1588714355)
         && this.hp.length == (-845986725 ^ -845986213)
         && this.hq >= 0
         && this.hq <= (10333705 ^ 10334089);

      float var1 = (float)this.fm;
      int[] var2 = this.gi;
      int[] var3 = this.gj;
      float[] var4 = this.gk;
      float[] var5 = this.gm;
      float[] var6 = this.go;
      float[] var7 = this.gq;
      float[] var8 = this.he;
      float[] var9 = this.hg;
      float[] var10 = this.hi;
      float[] var11 = this.gs;
      float[] var12 = this.hm;
      float[] var13 = this.gl;
      float[] var14 = this.gn;
      float[] var15 = this.gp;
      float[] var16 = this.gr;
      float[] var17 = this.hf;
      float[] var18 = this.hh;
      float[] var19 = this.hj;
      float[] var20 = this.gt;
      float[] var21 = this.hn;
      double[] var22 = this.gy;
      double[] var23 = this.ha;
      double[] var24 = this.hc;
      double[] var25 = this.gz;
      double[] var26 = this.hb;
      double[] var27 = this.hd;
      int[] var28 = this.gv;
      int[] var29 = this.gx;
      int[] var30 = this.hk;
      int[] var31 = this.hl;
      int[] var32 = this.ho;
      int[] var33 = this.hp;
      Arrays.fill(var3, -2073751154 ^ 73732494);
      int var34 = 0;

      try {
         for (int var35 = 0; var35 < (-119917300 ^ -119916788); var35++) {
            int var36 = var2[var35];
            if (var36 != (-1264298229 ^ 883185419) && !(var1 - var6[var35] > 2.0F)) {
               int var37 = var36 * (-518305138 ^ 2133603135) >>> 23;

               while (var3[var37] != (-905881846 ^ 1241601802)) {
                  var37 = var37 + 1 & (549127981 ^ 549127890);
               }

               var3[var37] = var36;
               var13[var37] = var4[var35];
               var14[var37] = var5[var35];
               var15[var37] = var6[var35];
               var16[var37] = var7[var35];
               var29[var37] = var28[var35];
               var25[var37] = var22[var35];
               var26[var37] = var23[var35];
               var27[var37] = var24[var35];
               var17[var37] = var8[var35];
               var18[var37] = var9[var35];
               var19[var37] = var10[var35];
               var20[var37] = var11[var35];
               var31[var37] = var30[var35];
               var21[var37] = var12[var35];
               var33[var37] = var32[var35];
               var34++;
            }
         }
      } catch (RuntimeException var38) {
         throw var38;
      }

      this.gi = var3;
      this.gj = var2;
      this.gk = var13;
      this.gl = var4;
      this.gm = var14;
      this.gn = var5;
      this.go = var15;
      this.gp = var6;
      this.gq = var16;
      this.gr = var7;
      this.gv = var29;
      this.gx = var28;
      this.gy = var25;
      this.gz = var22;
      this.ha = var26;
      this.hb = var23;
      this.hc = var27;
      this.hd = var24;
      this.he = var17;
      this.hf = var8;
      this.hg = var18;
      this.hh = var9;
      this.hi = var19;
      this.hj = var10;
      this.gs = var20;
      this.gt = var11;
      this.hk = var31;
      this.hl = var30;
      this.hm = var21;
      this.hn = var12;
      this.ho = var33;
      this.hp = var32;
      this.hq = var34;
   }

   private static int q(int var0) {

      float var1 = (float)(var0 >> 16 & (477316577 ^ 477316382)) / 255.0F;
      float var2 = (float)(var0 >> 8 & (2060842699 ^ 2060842548)) / 255.0F;
      float var3 = (float)(var0 & (-20696316 ^ -20696069)) / 255.0F;
      float var4 = Math.max(var1, Math.max(var2, var3));
      float var5 = Math.min(var1, Math.min(var2, var3));
      float var6 = var4 - var5;
      if (var4 <= 0.0F) {
         return 710943347 ^ 714791049;
      } else {
         float var7 = var6 / var4;
         float var8;
         if (var6 <= 0.0F) {
            var8 = 0.0F;
         } else if (var4 == var1) {
            var8 = (var2 - var3) / var6 / 6.0F;
         } else if (var4 == var2) {
            var8 = ((var3 - var1) / var6 + 2.0F) / 6.0F;
         } else {
            var8 = ((var1 - var2) / var6 + 4.0F) / 6.0F;
         }

         if (var8 < 0.0F) {
            var8++;
         }

         float var9 = var7 > 0.02F ? Math.min(1.0F, var7 * 1.15F + 0.03F) : var7;
         return MathHelper.hsvToRgb(var8, var9, Math.max(var4, 0.98F)) & (-834051027 ^ -826893358);
      }
   }

   private static int r(int var0, int var1, float var2) {

      int var3 = var0 >> 16 & (-1411759018 ^ -1411758935);
      int var4 = var0 >> 8 & (1175766669 ^ 1175766642);
      int var5 = var0 & (-1771309264 ^ -1771309105);
      int var6 = (int)((float)var3 + (float)((var1 >> 16 & (42586410 ^ 42586581)) - var3) * var2 + 0.5F);
      int var7 = (int)((float)var4 + (float)((var1 >> 8 & (271306525 ^ 271306722)) - var4) * var2 + 0.5F);
      int var8 = (int)((float)var5 + (float)((var1 & (753467442 ^ 753467597)) - var5) * var2 + 0.5F);
      return var6 << 16 | var7 << 8 | var8;
   }

   @Override
   public void e() {

      super.e();
   }

   @Override
   public boolean f() {

      return super.f;
   }

   @Override
   public String g() {

      return super.g();
   }

   @Override
   public String h() {

      return super.h();
   }

   @Override
   public ParserEngine i() {

      return super.i();
   }

   @Override
   public int j() {

      return super.j();
   }

   @Override
   public List<InitAdapter> k() {

      return super.k();
   }

   @Override
   public ItemDescriptor l() {

      return super.l();
   }

   @Override
   public void a(boolean var1) {

      super.a(var1);
   }

   @Override
   public void a(int var1) {

      super.a(var1);
   }
}
