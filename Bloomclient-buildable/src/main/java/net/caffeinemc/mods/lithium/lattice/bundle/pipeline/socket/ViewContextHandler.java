package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket;

import com.mojang.blaze3d.systems.RenderSystem;
import it.unimi.dsi.fastutil.objects.Object2IntMap.Entry;
import java.util.Arrays;
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
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.LabelLineCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.PlateBatchCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.PlateIconCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.PlateTextCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.RegionPassCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.BindingBridge;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.math.Vec3d;
import net.minecraft.text.Style;
import net.minecraft.util.Identifier;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.text.OrderedText;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import org.joml.Matrix4f;
import org.joml.Vector4f;
import net.minecraft.client.render.VertexConsumerProvider;import net.minecraft.entity.Entity;import net.minecraft.text.StyleSpriteSource;
public class ViewContextHandler extends BuilderFactory {
   public static volatile boolean HIDE_VANILLA = false;
   public static volatile long LIVE_NS = 0L;
   public static volatile boolean RUN;
   private static ViewContextHandler u;
   private final CheckerBridge v;
   private final CheckerBridge w;
   private final CheckerBridge x;
   private final CheckerBridge y;
   private final CheckerBridge z;
   private final BlockCalculator aa;
   private final PlacementEntry ab;
   private final CheckerBridge ac;
   private final CheckerBridge ad;
   private final SlotEntry ae;
   private final CheckerBridge af;
   private final BlockCalculator ag;
   private final CheckerBridge ah;
   private final SlotEntry ai;
   private static final int[] aj = new int[]{0, 15922165, 6087152, 15757528, 15745871, 15122522, 16742943, 10120959};
   private static final int ak = 15903035;
   private static final int al = 15680580;
   private static final int am = 16770728;
   private static final int an = 10396590;
   private static final int ao = 789777;
   private static final int ap = 179;
   private static final int aq = 536870911;
   private static final int ar = 1929379840;
   private static final int as = 15728880;
   private static final String[] at = new String[]{"bs_bold", "t", "lb", "xlb", "s", "xs"};
   private static final int au = 4;
   private static final int av = 5;
   private static final Style[][] aw = new Style[at.length][3];
   private static final int[] ax = new int[]{0, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3};
   private static final int[] ay = new int[]{1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3};
   private static final float[] az = new float[]{7.0F, 7.5F, 8.5F, 10.0F, 7.0F, 7.5F, 8.5F, 10.0F, 7.0F, 7.5F, 8.5F, 10.0F};
   private static final float[] ba = new float[12];
   private static final String[] bb;
   private static final String[] bc;
   private static final String[] bd;
   private static final String[] be;
   private static final String[] bf;
   private static final String[] bg;
   private static final double bh = 4096.0;
   private static final int bi = 256;
   private static final int bj = 10;
   private static final double bk = 24.0;
   private static final int bl = 64;
   private static final float bm = 0.18F;
   private static final float bn = 0.22F;
   private static final long bo = 250000000L;
   private static final long bp = 50000000L;
   private static final int bq = 20;
   private static final int br = 512;
   private static final int bs = 320;
   private static final int bt = Integer.MIN_VALUE;
   private int[] bu;
   private int[] bv;
   private float[] bw;
   private float[] bx;
   private float[] by;
   private float[] bz;
   private int[] ca;
   private int[] cb;
   private float[] cc;
   private float[] cd;
   private int[] ce;
   private int[] cf;
   private int[] cg;
   private int[] ch;
   private int[] ci;
   private int[] cj;
   private int[] ck;
   private int[] cl;
   private int[] cm;
   private int[] cn;
   private int[] co;
   private int[] cp;
   private int[] cq;
   private int[] cr;
   private String[] cs;
   private String[] ct;
   private LabelLineCache[] cu;
   private LabelLineCache[] cv;
   private int[] cw;
   private int[] cx;
   private int cy;
   private final Vector4f cz;
   private final Matrix4f da;
   private final Matrix4f db;
   private final Matrix4f dc;
   private double dd;
   private double de;
   private double df;
   private int dg;
   private float dh;
   private float di;
   private float dj;
   private float dk;
   private float dl;
   private float dm;
   private float dn;
   private double _kwren_do;
   private int dp;
   private int dq;
   private int dr;
   private BindingBridge ds;
   private final PlayerEntity[] du;
   private final float[] dv;
   private final float[] dw;
   private final float[] dx;
   private final long[] dy;
   private boolean dz;
   private int ea;
   private final float[] eb;
   private final float[] ec;
   private final float[] ed;
   private final float[] ee;
   private final float[] ef;
   private final float[] eg;
   private final float[] eh;
   private final float[] ei;
   private final float[] ej;
   private final float[] ek;
   private final float[] el;
   private final float[] em;
   private final float[] en;
   private final float[] eo;
   private final float[] ep;
   private final float[] eq;
   private final int[] er;
   private final int[] es;
   private final int[] et;
   private final int[] eu;
   private final int[] ev;
   private final int[] ew;
   private final int[] ex;
   private final int[] ey;
   private final int[] ez;
   private final boolean[] fa;
   private final LabelLineCache[] fb;
   private int fc;
   private final boolean[] fd;
   private final int[] fe;
   private final float[] ff;
   private final OrderedText[] fg;
   private final OrderedText[] fh;
   private final float[] fi;
   private final float[] fj;
   private long fk;
   private boolean fl;
   private boolean fm;
   private boolean fn;
   private boolean fo;
   private boolean fp;
   private boolean fq;
   private boolean fs;
   private boolean ft;
   private boolean fu;
   private boolean fv;
   private double fw;
   private float fx;
   private int fy;
   private int fz;
   private float ga;
   private long gb;
   private boolean gc;
   private final ItemStack[] gd;
   private static final int ge = 256;
   private static final int gf = 4;
   private final ItemStack[] gg;
   private final int[] gi;
   private final int[] gj;
   private final int[] gk;
   private final OrderedText[] gl;
   private final OrderedText[] gm;
   private final float[] gn;
   private final float[] go;
   private int gp;
   private static int gr = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   public ViewContextHandler() {
      super("", "", ParserEngine.Z3);
      this.setName(
         new char[]{'憠', '戣', '才', '戦', '戏', '拝', '拉', '抠', '投'},
         -499359250,
         new char[]{
            '冭',
            '刣',
            '剀',
            '刮',
            '刋',
            '勧',
            '劈',
            '助',
            '劇',
            '卨',
            '十',
            '卣',
            '匒',
            '叭',
            '叁',
            '友',
            '去',
            '厎',
            '吼',
            '呚',
            '吸',
            '吖',
            '哮',
            '哒',
            '哶',
            '咅',
            '啸',
            '啒',
            '唫',
            '唔',
            '嗢',
            '嗜',
            '嗴',
            '嗍',
            '噤',
            '噎',
            '嘫',
            '嘅',
            '囼',
            '囏',
            '囪',
            '囅',
            '坠',
            '坊',
            '圱',
            '圕',
            '埡',
            '埱',
            '埝',
            '垸',
            '埐',
            '堻',
            '塛',
            '堫',
            '堕',
            '壸',
            '壄'
         },
         466047470
      );
      CheckerBridge var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'냂', '낇', '낭', '낆', '녪', '녑', '넬', '녃', '뇌', '뇔', '놭', '놽', '놛', '뉯'}, 2128195722);
      this.v = var10001;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'\uebde', '\ueb97', '\uebb1', '\ueb84', '\uec62', '\uec54', '\uec3a', '\uec10', '\uecf7'}, -1107891302);
      this.w = var10001;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'檁', '櫞', '武', '歀', '欪'}, -1444058415);
      this.x = var10001;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'㋊', '㊏', '㊥', '㊾', '㊒', '㍩', '㍔', '㍻', '㌸', '㏸', '㏊'}, 858534530);
      this.y = var10001;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'颕', '飒', '饲', '饝', '餱', '餔', '駾', '駑', '馽', '馀', '騳', '驴', '騣', '騙', '髪', '髀', '骩', '骟'}, -1574201123);
      this.z = var10001;
      BlockCalculator var5 = new BlockCalculator("", 0.0, 3.0, 0.3, 0.1);
      var5.n(new char[]{'⫇', '⪀', '⪨', '⪅', '⭬', '⭂', '⬽', '⭈', '⯆', '⯄', '⮪', '⮒', 'ⱦ', 'Ⰲ', 'Ⰹ', 'Ⰵ', 'Ⱎ', '⳺'}, -1495782769);
      this.aa = var5;
      PlacementEntry var6 = new PlacementEntry("", 0.0, 0.0, 1.0, 1.0);
      var6.n(new char[]{'믒', '믔', '믆', '뮲', '뮘'}, -1537164415);
      this.ab = var6;
      var10001 = new CheckerBridge("", true);
      var10001.n(
         new char[]{
            '\uec9f',
            '\uecd3',
            '\ued6e',
            '\ued56',
            '\ued35',
            '\ued0b',
            '\uedb8',
            '\ued91',
            '\uedf6',
            '\uedbd',
            '\uee71',
            '\uee5f',
            '\uee36',
            '\uee51',
            '\ueed9',
            '\ueedb',
            '\ueeab',
            '\uee80'
         },
         696577246
      );
      this.ac = var10001;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'ꍨ', 'ꍢ', 'ꌅ', 'ꏩ', 'ꏁ', 'ꎩ', 'ꎉ', 'ꑲ', 'ꑈ', 'ꐡ', 'ꐍ', 'ꓶ', 'ꓒ'}, 648913709);
      this.ad = var10001;
      this.ae = new SlotEntry("A.ccent Color", "Theme", "Theme", "White", "Cyan", "Pink", "Red", "Gold", "Orange", "Violet");
      var10001 = new CheckerBridge("", true);
      var10001.n(
         new char[]{
            '\ue829',
            '\ue8ae',
            '\ue8f6',
            '\ue8da',
            '\ue8b8',
            '\ue8dc',
            '\ue94d',
            '\ue95b',
            '\ue937',
            '\ue911',
            '\ue9fb',
            '\ue9da',
            '\ue9b4',
            '\ue9d4',
            '\uea47',
            '\uea53',
            '\uea36',
            '\uea03'
         },
         -1649940383
      );
      this.af = var10001;
      BlockCalculator var10 = new BlockCalculator("", 60.0, 150.0, 100.0, 5.0);
      var10.n(new char[]{'巐', '嶌', '嶨', '嶚', '嶚', '帾', '帕', '幹', '幒'}, 1499684227);
      this.ag = var10;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'毑', '殏', '殭', '殾', '殒', '汱', '汙', '氩', '汚', '泎', '泐', '沲', '沘', '洵', '浲', '洲', '洀'}, 48262018);
      this.ah = var10001;
      this.ai = new SlotEntry("H." + "ealth Co" + "lors", "Gradient", "Gradient", "Accent");
      this.bu = new int[512];
      this.bv = new int[512];
      this.bw = new float[512];
      this.bx = new float[512];
      this.by = new float[512];
      this.bz = new float[512];
      this.ca = new int[512];
      this.cb = new int[512];
      this.cc = new float[512];
      this.cd = new float[512];
      this.ce = new int[512];
      this.cf = new int[512];
      this.cg = new int[512];
      this.ch = new int[512];
      this.ci = new int[512];
      this.cj = new int[512];
      this.ck = new int[512];
      this.cl = new int[512];
      this.cm = new int[512];
      this.cn = new int[512];
      this.co = new int[512];
      this.cp = new int[512];
      this.cq = new int[512];
      this.cr = new int[512];
      this.cs = new String[512];
      this.ct = new String[512];
      this.cu = new LabelLineCache[512];
      this.cv = new LabelLineCache[512];
      this.cw = new int[512];
      this.cx = new int[512];
      this.cz = new Vector4f();
      this.da = new Matrix4f();
      this.db = new Matrix4f();
      this.dc = new Matrix4f();
      this.du = new PlayerEntity[256];
      this.dv = new float[256];
      this.dw = new float[256];
      this.dx = new float[256];
      this.dy = new long[256];
      this.eb = new float[256];
      this.ec = new float[256];
      this.ed = new float[256];
      this.ee = new float[256];
      this.ef = new float[256];
      this.eg = new float[256];
      this.eh = new float[256];
      this.ei = new float[256];
      this.ej = new float[256];
      this.ek = new float[256];
      this.el = new float[256];
      this.em = new float[256];
      this.en = new float[256];
      this.eo = new float[256];
      this.ep = new float[256];
      this.eq = new float[256];
      this.er = new int[256];
      this.es = new int[256];
      this.et = new int[256];
      this.eu = new int[256];
      this.ev = new int[256];
      this.ew = new int[256];
      this.ex = new int[256];
      this.ey = new int[256];
      this.ez = new int[256];
      this.fa = new boolean[256];
      this.fb = new LabelLineCache[256];
      this.fd = new boolean[50];
      this.fe = new int[50];
      this.ff = new float[50];
      this.fg = new OrderedText[50];
      this.fh = new OrderedText[50];
      this.fi = new float[50];
      this.fj = new float[50];
      this.gc = true;
      this.gd = new ItemStack[5];
      this.gg = new ItemStack[256];
      this.gi = new int[256];
      this.gj = new int[256];
      this.gk = new int[256];
      this.gl = new OrderedText[256];
      this.gm = new OrderedText[256];
      this.gn = new float[256];
      this.go = new float[256];
      this.a(new InitAdapter[]{this.v, this.w, this.x, this.y, this.z, this.aa, this.ab, this.ac, this.ad, this.ae, this.af, this.ag, this.ah, this.ai});
      Arrays.fill(this.bu, Integer.MIN_VALUE);
      Arrays.fill(this.bv, Integer.MIN_VALUE);
      u = this;
   }

   @Override
   public void c() {

      if (!RUN) {
         this.ga = 0.0F;
         this.gb = System.nanoTime();
         this.gc = true;
         RUN = true;
      }

      super.c();
   }

   @Override
   public void d() {

      HIDE_VANILLA = false;
      super.d();
   }

   public static void a(Matrix4f var0, Matrix4f var1) {

      ViewContextHandler var2 = u;
      if (var2 == null) {
         RUN = false;
      } else {
         var2.b(var0, var1);
      }
   }

   private void b(Matrix4f var1, Matrix4f var2) {

      boolean var3 = super.f;
      long var4 = System.nanoTime();
      long var6 = var4 - this.gb;
      boolean var8 = this.gb == 0L;
      boolean var9 = !var8 && (var6 < 0L || var6 > 250000000L);
      float var10 = !var8 && !var9 ? Math.min(0.1F, (float)var6 / 1.0E9F) : 0.0F;
      this.gb = var4;
      this.dn = var10;
      this._kwren_do += (double)var10;
      float var11 = var9 ? (var3 ? 1.0F : 0.0F) : (var3 ? Math.min(1.0F, this.ga + var10 / 0.18F) : Math.max(0.0F, this.ga - var10 / 0.22F));
      this.ga = var11;
      if (!var3 && var11 <= 0.0F) {
         this.f_r89();
      } else if (a.player != null && a.world != null && a.gameRenderer != null && a.getWindow() != null) {
         if (a.options == null || !a.options.hudHidden) {
            try {
               this.h(var1, var2, var9 || var8, var4);
            } catch (Throwable var13) {
            }
         }
      }
   }

   private void f_r89() {

      RUN = false;
      HIDE_VANILLA = false;
      this.gb = 0L;
      this.ga = 0.0F;
      Arrays.fill(this.bu, -1763786226 ^ 383697422);
      Arrays.fill(this.cu, null);
      Arrays.fill(this.cs, null);
      this.cy = 0;
      Arrays.fill(this.gg, null);
      Arrays.fill(this.gl, null);
      Arrays.fill(this.gm, null);
      Arrays.fill(this.gd, null);
      Arrays.fill(this.du, null);
      this.ds = null;
   }

   private void g(long var1, boolean var3) {

      if (var3 || a.currentScreen != null || var1 - this.fk >= 50000000L || var1 - this.fk < 0L) {
         this.fk = var1;
         this.fl = this.v.f();
         this.fm = this.w.f();
         this.fn = this.x.f();
         this.fo = this.y.f();
         this.fp = this.z.f();
         this.fw = this.aa.p();
         this.fq = this.ac.f();
         this.fs = this.ad.f();
         this.fy = Math.max(0, this.ae.g().indexOf(this.ae.f()));
         this.ft = this.af.f();
         this.fx = (float)(this.ag.p() / 100.0);
         this.fu = this.ah.f();
         this.fv = this.ai.g().indexOf(this.ai.f()) != 1;
      }
   }

   private void h(Matrix4f var1, Matrix4f var2, boolean var3, long var4) {

      if (PlateBatchCache.c()) {
         this.g(var4, var3 || this.gc);
         this.gc = false;
         HIDE_VANILLA = this.ft && super.f;
         float var6 = this.ga;
         this.dm = var6 * var6 * (3.0F - 2.0F * var6);
         int var7;
         if (this.fy > 0 && this.fy < aj.length) {
            var7 = aj[this.fy];
         } else {
            try {
               var7 = RegionPassCache.i() & (506062005 ^ 517348170);
            } catch (Throwable var25) {
               var7 = -447167599 ^ -441410786;
            }
         }

         this.fz = var7;
         Vec3d var8 = a.gameRenderer.getCamera().getCameraPos();
         this.dd = var8.x;
         this.de = var8.y;
         this.df = var8.z;
         int var9 = Math.max(1, a.getWindow().getScaleFactor());
         this.dg = var9;
         this.dj = (float)a.getWindow().getFramebufferWidth();
         this.dk = (float)a.getWindow().getFramebufferHeight();
         this.dh = this.dj / (float)var9;
         this.di = this.dk / (float)var9;
         this.da.set(var2);
         this.db.set(var1);
         this.dl = a.getRenderTickCounter().getTickProgress(true);
         this.gp++;
         this.dq = this.dq + 1 & (635258549 ^ 438483274);
         int var10 = System.identityHashCode(a.world);
         if (var10 != this.dr) {
            this.dr = var10;
            Arrays.fill(this.gg, null);
            Arrays.fill(this.gl, null);
            Arrays.fill(this.gm, null);
            Arrays.fill(this.bu, -1497919763 ^ 649563885);
            Arrays.fill(this.cs, null);
            this.cy = 0;
         }

         this.ds = this.fp && ConfigBridge.c != null ? ConfigBridge.c.e() : null;
         if (this.ds != null && this.ds.d()) {
            this.ds = null;
         }

         boolean var11 = false;
         if (this.fq) {
            try {
               var11 = PlateIconCache.begin(var9);
            } catch (Throwable var24) {
               var11 = false;
            }
         }

         this.dz = var11;
         int var12 = this.i_r90();
         long[] var13 = this.dy;
         this.ea = 0;
         this.fc = 0;

         assert var12 >= 0
            && var12 <= (1812953411 ^ 1812953155)
            && var13.length == (-2094964675 ^ -2094964419)
            && this.du.length == (-536042833 ^ -536042577)
            && this.dv.length == (-1120079943 ^ -1120080199)
            && this.dw.length == (-1194770440 ^ -1194770696)
            && this.dx.length == (-1797340434 ^ -1797340178)
            && this.bu.length == (1327003658 ^ 1327004170)
            && this.cu.length == (-1092285848 ^ -1092286360)
            && this.eb.length == (801663890 ^ 801663634)
            && this.fb.length == (188605197 ^ 188604941)
            && this.dg >= 1
            && this.gd.length == 5
            && aw.length == at.length
            && ax.length == 12
            && be.length == (2029801796 ^ 2029805285) : "frame";

         try {
            try {
               for (int var14 = var12 - 1; var14 >= 0; var14--) {
                  int var15 = (int)var13[var14];

                  try {
                     this.j(var15, var14);
                  } catch (Throwable var23) {
                  }
               }
            } catch (RuntimeException var26) {
               throw var26;
            }

            if (this.dz && this.fc > 0) {
               PlateIconCache.render();
            }

            PlateBatchCache.fbW = this.dj;
            PlateBatchCache.fbH = this.dk;
            if (this.ea > 0 && PlateBatchCache.b(this.db, RenderSystem.getModelViewMatrix())) {
               this.n(this.ea);
            }
         } finally {
            PlateBatchCache.end();
            Arrays.fill(this.du, 0, var12, null);
            Arrays.fill(this.fb, 0, this.ea, null);
            Arrays.fill(this.fg, null);
            Arrays.fill(this.fh, null);
            Arrays.fill(this.gd, null);
         }

         LIVE_NS = var4;
         if (++this.dp >= 60) {
            this.dp = 0;
            this.t();
         }
      }
   }

   private int i_r90() {

      List var1 = a.world.getPlayers();
      ClientPlayerEntity var2 = a.player;
      float var3 = this.dl;
      double var4 = this.fw;
      Vector4f var6 = this.cz;
      Matrix4f var7 = this.da;
      Matrix4f var8 = this.db;
      float var9 = this.dh;
      float var10 = this.di;
      float var11 = 160.0F;
      int var12 = 0;
      int var13 = var1.size();

      assert var1 != null
         && var2 != null
         && var6 != null
         && var7 != null
         && var8 != null
         && var9 > 0.0F
         && var10 > 0.0F
         && var13 >= 0
         && this.du.length == (-2088520677 ^ -2088520421)
         && this.dv.length == (-1386087458 ^ -1386087714)
         && this.dw.length == (-317751683 ^ -317751427)
         && this.dx.length == (1776729405 ^ 1776729149)
         && this.dy.length == (-437415077 ^ -437415333)
         && var4 >= 0.0
         && var4 <= 3.0
         && var3 >= 0.0F
         && var3 <= 1.5F : "collect";

      try {
         for (int var14 = 0; var14 < var13 && var12 < (-910611964 ^ -910611708); var14++) {
            PlayerEntity var15 = (PlayerEntity)var1.get(var14);
            if (var15 != null && var15 != var2) {
               double var16 = var15.squaredDistanceTo(var2);
               if (!(var16 > 4096.0)) {
                  double var18 = MathHelper.lerp((double)var3, var15.lastRenderX, var15.getX());
                  double var20 = MathHelper.lerp((double)var3, var15.lastRenderY, var15.getY()) + (double)var15.getHeight() + var4;
                  double var22 = MathHelper.lerp((double)var3, var15.lastRenderZ, var15.getZ());
                  var6.set((float)(var18 - this.dd), (float)(var20 - this.de), (float)(var22 - this.df), 1.0F);
                  var6.mul(var7);
                  var6.mul(var8);
                  float var24 = var6.w;
                  if (!(var24 <= 0.0F)) {
                     float var25 = (var6.x / var24 * 0.5F + 0.5F) * var9;
                     float var26 = (1.0F - (var6.y / var24 * 0.5F + 0.5F)) * var10;
                     if (!(var25 < -var11) && !(var25 > var9 + var11) && !(var26 < -8.0F) && !(var26 > var10 + var11)) {
                        this.du[var12] = var15;
                        this.dv[var12] = var25;
                        this.dw[var12] = var26;
                        float var27 = (float)Math.sqrt(var16);
                        this.dx[var12] = var27;
                        this.dy[var12] = (long)Float.floatToIntBits(var27) << 32 | (long)var12;
                        var12++;
                     }
                  }
               }
            }
         }
      } catch (RuntimeException var28) {
         throw var28;
      }

      Arrays.sort(this.dy, 0, var12);
      return var12;
   }

   private void j(int var1, int var2) {

      PlayerEntity var3 = this.du[var1];
      float var4 = this.dx[var1];
      int var5 = var3.getId();
      int[] var6 = this.bu;

      assert var3 != null
         && var6.length == (-76660839 ^ -76661351)
         && this.bw.length == (-1857849691 ^ -1857850203)
         && this.by.length == (1088558824 ^ 1088558312)
         && this.ca.length == (555768946 ^ 555769458)
         && this.cu.length == (733926750 ^ 733927262)
         && this.cs.length == (757333032 ^ 757333544)
         && this.ce.length == (-314414525 ^ -314415037)
         && this.cg.length == (-849019127 ^ -849019639)
         && this.ci.length == (-339776159 ^ -339775647)
         && this.co.length == (-1181130804 ^ -1181131316)
         && this.ck.length == (1845095347 ^ 1845094835)
         && this.cm.length == (1918555672 ^ 1918555160)
         && this.cc.length == (-1903101762 ^ -1903101250)
         && this.cw.length == (-1804240778 ^ -1804240266)
         && ba.length == 12
         && var1 >= 0
         && var1 < (1816112257 ^ 1816112513)
         && var2 >= 0
         && var2 < (1401422056 ^ 1401422312)
         && var4 >= 0.0F
         && this.dg >= 1
         && this.ea < (159458791 ^ 159458535) : "prep";

      int var7 = -1;

      try {
         int var8 = var5 * (-1978108101 ^ 338628234) >>> 23;

         for (int var9 = 0; var9 < (-147256046 ^ -147255534); var9++) {
            int var10 = var6[var8];
            if (var10 == var5) {
               var7 = var8;
               break;
            }

            if (var10 == (493381340 ^ -1654102308)) {
               if (this.cy < (1117246143 ^ 1117246463)) {
                  var6[var8] = var5;
                  this.bw[var8] = -1000.0F;
                  this.cy++;
                  var7 = var8;
               }
               break;
            }

            var8 = var8 + 1 & (-193563058 ^ -193562703);
         }
      } catch (RuntimeException var63) {
         throw var63;
      }

      if (var7 >= 0) {
         float var64 = (float)this._kwren_do;
         if (var64 - this.bw[var7] > 0.25F) {
            this.by[var7] = this.dn <= 0.0F ? 1.0F : 0.0F;
            this.ca[var7] = -1;
            this.cs[var7] = null;
            this.cw[var7] = -1;
         }

         this.bw[var7] = var64;
         float var65 = Math.min(1.0F, this.by[var7] + this.dn / 0.18F);
         this.by[var7] = var65;
         var65 = var65 * var65 * (3.0F - 2.0F * var65) * this.dm;
         if (!(var65 < 0.004F)) {
            int var67 = this.dg;
            float var11 = 1.0F;
            if (this.fu) {
               var11 = 1.0F - (var4 - 8.0F) * 0.007F;
               var11 = var11 > 1.0F ? 1.0F : (var11 < 0.72F ? 0.72F : var11);
            }

            float var12 = (float)Math.log((double)(8.5F * (float)var67 * this.fx * var11));
            int var13 = this.ca[var7];
            int var14 = 0;
            float var15 = Float.MAX_VALUE;

            try {
               for (int var16 = 0; var16 < 12; var16++) {
                  float var17 = Math.abs(ba[var16] - var12);
                  if (var17 < var15) {
                     var15 = var17;
                     var14 = var16;
                  }
               }
            } catch (RuntimeException var62) {
               throw var62;
            }

            if (var13 < 0 || Math.abs(ba[var13] - var12) > var15 + 0.05F) {
               var13 = var14;
            }

            this.ca[var7] = var13;
            int var69 = ay[var13];
            float var70 = az[var13];
            Style var18 = aw[ax[var13]][var69 - 1];
            String var19 = var3.getGameProfile().name();
            float var20 = var3.getHealth();
            float var21 = var3.getAbsorptionAmount();
            float var22 = var3.getMaxHealth();
            float var23 = var22 > 0.0F ? MathHelper.clamp(var20 / var22, 0.0F, 1.0F) : 0.0F;
            int var24 = this.fl ? Math.max(0, Math.min(-223334152 ^ -223330472, Math.round((var20 + var21) * 10.0F))) : -1;
            int var25 = this.fm ? Math.min(2014610515 ^ 2014610643, (int)var4) : -1;
            int var26 = -1;
            if (this.fn) {
               int var27 = this.dq - this.cq[var7];
               if (this.cs[var7] == null || var27 < 0 || var27 >= 20) {
                  ClientPlayNetworkHandler var28 = a.getNetworkHandler();
                  PlayerListEntry var29 = var28 != null ? var28.getPlayerListEntry(var3.getUuid()) : null;
                  this.cq[var7] = this.dq;
                  this.co[var7] = var29 != null ? Math.max(0, Math.min(-1769464433 ^ -1769464216, var29.getLatency())) : -1;
               }

               var26 = this.co[var7];
            }

            boolean var71 = false;
            if (this.ds != null) {
               int var72 = this.cw[var7];
               if (var72 >= 0 && (this.dq - (var72 >> 1) & (-1457602268 ^ -1763623205)) < 20) {
                  var71 = (var72 & 1) != 0;
               } else {
                  try {
                     var71 = this.ds.c(var19);
                  } catch (Exception var61) {
                  }

                  this.cw[var7] = this.dq << 1 | (var71 ? 1 : 0);
               }
            }

            int var73 = this.fz;
            int var74;
            if (this.fv && !(var23 >= 0.6F)) {
               int var30 = -1729133880 ^ -1744779636;
               int var31 = 310588564 ^ 309096656;
               float var32 = 0.0F;
               if (var23 >= 0.35F) {
                  var30 = 716188833 ^ 709002650;
                  var31 = var73;
                  var32 = (var23 - 0.35F) / 0.25F;
               } else if (var23 >= 0.15F) {
                  var31 = 847590844 ^ 846699655;
                  var32 = (var23 - 0.15F) / 0.2F;
               }

               var74 = (int)(
                        (float)(var30 >> 16 & (-1059197466 ^ -1059197671))
                           + (float)((var31 >> 16 & (332249634 ^ 332249821)) - (var30 >> 16 & (1106217673 ^ 1106217526))) * var32
                           + 0.5F
                     )
                     << 16
                  | (int)(
                        (float)(var30 >> 8 & (-673219138 ^ -673219263))
                           + (float)((var31 >> 8 & (-178110684 ^ -178110501)) - (var30 >> 8 & (-2124058412 ^ -2124058581))) * var32
                           + 0.5F
                     )
                     << 8
                  | (int)(
                     (float)(var30 & (-1007227483 ^ -1007227558))
                        + (float)((var31 & (-778777965 ^ -778778004)) - (var30 & (35038071 ^ 35038088))) * var32
                        + 0.5F
                  );
            } else {
               var74 = var73;
            }

            int var75 = var71 ? (this.fy == 1 ? -2118026610 ^ -2120377474 : var73) : -455684920 ^ -467061961;
            LabelLineCache var76 = this.cu[var7];
            if (var76 == null) {
               var76 = new LabelLineCache();
               this.cu[var7] = var76;
               this.cs[var7] = null;
            }

            int var77 = var13 | (var71 ? -2007565759 ^ -2007565503 : 0);
            int var33 = var74 ^ var75 * 31;
            if (this.cs[var7] != var19
               || this.ce[var7] != var24
               || this.cg[var7] != var25
               || this.ck[var7] != var77
               || this.cm[var7] != var33
               || this.ci[var7] != var26) {
               this.cs[var7] = var19;
               this.ce[var7] = var24;
               this.cg[var7] = var25;
               this.ck[var7] = var77;
               this.cm[var7] = var33;
               this.ci[var7] = var26;
               this.m(
                  var76,
                  var19,
                  var18.withColor(l(var75)),
                  var24,
                  var18.withColor(l(var74)),
                  var25,
                  var26,
                  aw[4][var69 - 1].withColor(l(-770963264 ^ -762139794))
               );
               this.cc[var7] = a.textRenderer.getTextHandler().getWidth(var76);
            }

            float var34 = this.cc[var7];
            float var35 = (float)var69;
            float var36 = (float)Math.round(this.dv[var1] * (float)var67);
            float var37 = (float)Math.round(this.dw[var1] * (float)var67);
            float var38 = var70 / 8.5F;
            boolean var39 = this.fo;
            int var40 = -Math.round((var39 ? 6.0F : 3.0F) * var38);
            float var41 = 4.5F * var38;
            int var42 = -Math.round(var34 * 0.5F);
            float var43 = (float)var42 - var41;
            float var44 = var34 + 2.0F * var41;
            float var45 = (float)var40 - 9.5F * var38;
            float var46 = var39 ? (float)var40 + 6.0F * var38 : (float)var40 + 3.0F * var38;
            boolean var47 = this.fq && var2 < 10 && (double)var4 <= 24.0 && var65 > 0.5F && this.fc < 10;
            int var48 = 0;
            int var49 = 0;
            int var50 = 0;
            int var51 = 0;
            int var52 = 0;
            ItemStack[] var53 = this.gd;
            if (var47) {
               var53[0] = var3.getEquippedStack(EquipmentSlot.HEAD);
               var53[1] = var3.getEquippedStack(EquipmentSlot.CHEST);
               var53[2] = var3.getEquippedStack(EquipmentSlot.LEGS);
               var53[3] = var3.getEquippedStack(EquipmentSlot.FEET);
               var53[4] = var3.getMainHandStack();
               var48 = (var53[0].isEmpty() ? 0 : 1)
                  + (var53[1].isEmpty() ? 0 : 1)
                  + (var53[2].isEmpty() ? 0 : 1)
                  + (var53[3].isEmpty() ? 0 : 1)
                  + (var53[4].isEmpty() ? 0 : 1);
               if (var48 == 0) {
                  var47 = false;
               } else {
                  int var54 = var69 >= 3 ? 2 : 1;
                  var49 = Math.round(16.0F * (float)var54 / (float)var69);
                  var50 = Math.max(1, Math.round(1.5F * var38));
                  int var55 = var48 * var49 + (var48 - 1) * var50;
                  var52 = -Math.round((float)var55 * 0.5F);
                  var51 = Math.round(var45 - 2.5F * var38) - Math.round(1.5F * var38) - var49;
               }
            }

            float var79 = var47 ? (float)var51 - (this.fs ? 12.0F * var38 : 0.0F) : var45;
            float var80 = var36 + Math.min(var43, var47 ? (float)var52 : var43) * var35;
            float var56 = var36 + Math.max(var43 + var44, var47 ? (float)(-var52) : var43 + var44) * var35;
            float var57 = var37 + var79 * var35;
            float var58 = var37 + var46 * var35;
            if (!(var56 < 0.0F) && !(var80 > this.dj) && !(var58 < 0.0F) && !(var57 > this.dk)) {
               int var59 = this.ea++;
               this.fb[var59] = var76;
               this.ed[var59] = var65;
               this.er[var59] = var69;
               this.ee[var59] = var38;
               this.eb[var59] = var36;
               this.ec[var59] = var37;
               this.es[var59] = var40;
               this.et[var59] = var42;
               this.ef[var59] = var43;
               this.eg[var59] = var44;
               this.eh[var59] = var41;
               this.ei[var59] = var45;
               this.ej[var59] = var46;
               this.fa[var59] = var39;
               this.ek[var59] = var34;
               this.el[var59] = var23;
               this.em[var59] = var22 > 0.0F ? var21 / var22 : 0.0F;
               this.eu[var59] = var74;
               this.ev[var59] = var49;
               this.ew[var59] = var50;
               this.ex[var59] = var51;
               this.ey[var59] = var52;
               this.en[var59] = var80;
               this.eo[var59] = var57;
               this.ep[var59] = var56;
               this.eq[var59] = var58;
               this.ez[var59] = -1;
               if (var47) {
                  int var60 = this.fc++;
                  this.ez[var59] = var60;
                  this.k(var60, var69, var65);
               }
            }
         }
      }
   }

   private void k(int var1, int var2, float var3) {

      ItemStack[] var4 = this.gd;
      int var5 = var1 * 5;
      boolean var6 = this.fs && (int)(255.0F * var3 + 0.5F) >= 8;
      TextRenderer var7 = a.textRenderer;
      Style var8 = aw[5][var2 - 1];

      assert var4.length == 5
         && var1 >= 0
         && var1 < 10
         && this.fd.length == 50
         && this.fe.length == 50
         && this.ff.length == 50
         && this.fg.length == 50
         && this.fj.length == 50
         && var2 >= 1
         && var2 <= 3
         && var7 != null
         && var8 != null
         && this.gg.length == (-2043156793 ^ -2043156537) : "gearRow";

      Arrays.fill(this.fd, var5, var5 + 5, false);
      Arrays.fill(this.fe, var5, var5 + 5, -1);
      Arrays.fill(this.ff, var5, var5 + 5, -1.0F);
      Arrays.fill(this.fg, var5, var5 + 5, null);
      Arrays.fill(this.fh, var5, var5 + 5, null);
      if (this.dz) {
         PlateIconCache.cells(var4, this.fe, var5);
      }

      try {
         for (int var9 = 0; var9 < 5; var9++) {
            ItemStack var10 = var4[var9];
            int var11 = var5 + var9;
            boolean var12 = var10 != null && !var10.isEmpty();
            this.fd[var11] = var12;
            this.ff[var11] = -1.0F;
            this.fg[var11] = null;
            this.fh[var11] = null;
            if (var12) {
               if (var10.isItemBarVisible()) {
                  float var13 = (float)var10.getItemBarStep() / 13.0F;
                  this.ff[var11] = var13 < 0.0F ? 0.0F : (var13 > 1.0F ? 1.0F : var13);
               }

               if (var6) {
                  int var15 = this.r(var10, var7, var8, var2);
                  if (var15 >= 0 && this.gl[var15] != null) {
                     this.fg[var11] = this.gl[var15];
                     this.fi[var11] = this.gn[var15];
                     this.fh[var11] = this.gm[var15];
                     this.fj[var11] = this.go[var15];
                  }
               }
            }
         }
      } catch (RuntimeException var14) {
         throw var14;
      }
   }

   private static int l(int var0) {

      int var1 = ((var0 >> 16 & (644233760 ^ 644233951)) * (535835371 ^ 535835159) + 127) / (155133857 ^ 155133790);
      int var2 = ((var0 >> 8 & (714951149 ^ 714950930)) * (41222047 ^ 41221987) + 127) / (1744464155 ^ 1744464356);
      int var3 = ((var0 & (400497687 ^ 400497896)) * (-1979396258 ^ -1979396190) + 127) / (1366152930 ^ 1366152733);
      return var1 << 16 | var2 << 8 | var3;
   }

   private void m(LabelLineCache var1, String var2, Style var3, int var4, Style var5, int var6, int var7, Style var8) {

      var1.clear();
      var1.add(var2, 0, var2.length(), var3);
      String var9 = bd[0];
      if (var4 >= 0) {
         var1.add(var9, 0, 2, var3);
         String var10 = be[var4];
         if (var10 == null) {
            var10 = var4 % 10 == 0 ? Integer.toString(var4 / 10) : var4 / 10 + bd[4] + var4 % 10;
            be[var4] = var10;
         }

         var1.add(var10, 0, var10.length(), var5);
      }

      if (var6 >= 0 || var7 >= 0) {
         var1.add(var9, 0, 2, var3);
         if (var6 >= 0) {
            String var11 = bf[var6];
            if (var11 == null) {
               var11 = var6 + bd[1];
               bf[var6] = var11;
            }

            var1.add(var11, 0, var11.length(), var8);
         }

         if (var7 >= 0) {
            if (var6 >= 0) {
               var1.add(var9, 0, 2, var8);
            }

            String var12 = bg[var7];
            if (var12 == null) {
               var12 = var7 + bd[2];
               bg[var7] = var12;
            }

            var1.add(var12, 0, var12.length(), var8);
         }
      }
   }

   private void n(int var1) {

      float[] var2 = this.en;
      float[] var3 = this.eo;
      float[] var4 = this.ep;
      float[] var5 = this.eq;
      int var6 = 0;

      assert var1 > 0
         && var1 <= (864778499 ^ 864778243)
         && var2.length == (-1240293689 ^ -1240293433)
         && var3.length == (1720846426 ^ 1720846682)
         && var4.length == (-1051082935 ^ -1051083191)
         && var5.length == (1777919799 ^ 1777919543)
         && this.fb.length == (1850358942 ^ 1850359198)
         && this.ez.length == (1101894749 ^ 1101895005)
         && this.ed.length == (448697562 ^ 448697818)
         && PlateBatchCache.exx == PlateBatchCache.exx
         && PlateBatchCache.ox == PlateBatchCache.ox : "drawAll";

      try {
         for (int var7 = 1; var7 <= var1; var7++) {
            boolean var8 = var7 == var1 || var7 - var6 >= 64;
            if (!var8) {
               float var9 = var2[var7];
               float var10 = var3[var7];
               float var11 = var4[var7];
               float var12 = var5[var7];

               for (int var13 = var6; var13 < var7 && !var8; var13++) {
                  if (var9 < var4[var13] && var11 > var2[var13] && var10 < var5[var13] && var12 > var3[var13]) {
                     var8 = true;
                  }
               }
            }

            if (var8) {
               try {
                  this.o(var6, var7, var6 == 0 || var7 == var1);
               } catch (Throwable var14) {
               }

               var6 = var7;
            }
         }
      } catch (RuntimeException var15) {
         throw var15;
      }
   }

   private void o(int var1, int var2, boolean var3) {

      if (PlateBatchCache.SX.length < (var2 - var1) * 16) {
         PlateBatchCache.a((var2 - var1) * 16);
      }

      float[] var4 = PlateBatchCache.SX;
      float[] var5 = PlateBatchCache.SY;
      float[] var6 = PlateBatchCache.SW;
      float[] var7 = PlateBatchCache.SH;
      float[] var8 = PlateBatchCache.SR;
      int[] var9 = PlateBatchCache.SC;
      int var10 = this.fz;
      float var11 = 1.0F;
      int var12 = 0;
      boolean var13 = false;

      assert var1 >= 0
         && var2 > var1
         && var2 <= this.ea
         && var4.length >= (var2 - var1) * 16
         && var9.length == var4.length
         && var5.length == var4.length
         && var6.length == var4.length
         && var7.length == var4.length
         && var8.length == var4.length
         && this.fd.length == 50
         && this.ff.length == 50
         && this.er.length == (644934127 ^ 644933871)
         && this.ez.length == (2111369701 ^ 2111369445)
         && this.fa.length == (1960889593 ^ 1960889849)
         && this.eu.length == (-2030483829 ^ -2030483573) : "chunk";

      try {
         for (int var14 = var1; var14 < var2; var14++) {
            float var15 = this.ed[var14];
            float var16 = this.ee[var14];
            float var17 = this.eb[var14];
            float var18 = this.ec[var14];
            float var19 = (float)this.er[var14];
            int var20 = this.eu[var14];
            float var21 = this.ef[var14];
            float var22 = this.ei[var14];
            var4[var12] = var17 + var21 * var19;
            var5[var12] = var18 + var22 * var19;
            var6[var12] = this.eg[var14] * var19;
            var7[var12] = (this.ej[var14] - var22) * var19;
            var8[var12] = 3.5F * var16 * var19;
            var9[var12++] = (int)(179.0F * var15 + 0.5F) << 24 | -1926118900 ^ -1925329123;
            if (this.fa[var14]) {
               float var23 = var17 + (var21 + this.eh[var14]) * var19;
               float var24 = var18 + ((float)this.es[var14] + 2.5F * var16) * var19;
               float var25 = this.ek[var14] * var19;
               float var26 = 1.5F * var16 * var19;
               float var27 = this.el[var14];
               if (var27 < 0.999F) {
                  var4[var12] = var23;
                  var5[var12] = var24;
                  var6[var12] = var25;
                  var7[var12] = var26;
                  var8[var12] = var26 * 0.5F;
                  var9[var12++] = (int)(31.0F * var15 + 0.5F) << 24 | -1957145793 ^ -1951945536;
               }

               var4[var12] = var23;
               var5[var12] = var24;
               var6[var12] = Math.max(var26, var25 * var27);
               var7[var12] = var26;
               var8[var12] = var26 * 0.5F;
               var9[var12++] = (int)(255.0F * var15 + 0.5F) << 24 | var20;
               float var28 = Math.min(var25 - var25 * var27, var25 * this.em[var14]);
               if (var28 > 0.5F * var19) {
                  float var29 = Math.min(var26 * 0.5F, var25 * var27);
                  var4[var12] = var23 + var25 * var27 - var29;
                  var5[var12] = var24;
                  var6[var12] = var28 + var29;
                  var7[var12] = var26;
                  var8[var12] = var26 * 0.5F;
                  var9[var12++] = (int)(230.0F * var15 + 0.5F) << 24 | -365191013 ^ -356235725;
               }
            }

            int var45 = this.ez[var14];
            if (var45 >= 0) {
               int var46 = this.ev[var14];
               int var47 = this.ew[var14];
               int var48 = this.ex[var14];
               int var49 = this.ey[var14];
               int var50 = var45 * 5;
               int var51 = 0;
               int var30 = (int)(115.0F * var15 + 0.5F) << 24;
               int var31 = (int)(255.0F * var15 + 0.5F) << 24;
               float var32 = Math.max(var16 * var19, var11);
               float var33 = var18 + ((float)(var48 + var46) + 0.5F * var16) * var19;

               for (int var34 = 0; var34 < 5; var34++) {
                  if (this.fd[var50 + var34]) {
                     float var35 = var17 + (float)(var49 + var51 * (var46 + var47)) * var19;
                     var51++;
                     if (this.fe[var50 + var34] >= 0) {
                        var13 = true;
                     }

                     float var36 = this.ff[var50 + var34];
                     if (!(var36 < 0.0F)) {
                        int var37 = -2030962150 ^ -2044805538;
                        int var38 = 1634902543 ^ 1637738059;
                        float var39 = 0.0F;
                        if (var36 >= 0.6F) {
                           var37 = var10;
                           var38 = var10;
                        } else if (var36 >= 0.35F) {
                           var37 = 281601484 ^ 272256247;
                           var38 = var10;
                           var39 = (var36 - 0.35F) / 0.25F;
                        } else if (var36 >= 0.15F) {
                           var38 = 262881382 ^ 257550685;
                           var39 = (var36 - 0.15F) / 0.2F;
                        }

                        int var40 = (int)(
                                 (float)(var37 >> 16 & (701797322 ^ 701797173))
                                    + (float)((var38 >> 16 & (-621150884 ^ -621150813)) - (var37 >> 16 & (-780029749 ^ -780029900))) * var39
                                    + 0.5F
                              )
                              << 16
                           | (int)(
                                 (float)(var37 >> 8 & (-746094616 ^ -746094825))
                                    + (float)((var38 >> 8 & (-1234799641 ^ -1234799848)) - (var37 >> 8 & (-1825362563 ^ -1825362558))) * var39
                                    + 0.5F
                              )
                              << 8
                           | (int)(
                              (float)(var37 & (1702996413 ^ 1702996290))
                                 + (float)((var38 & (503261173 ^ 503260938)) - (var37 & (-1033418128 ^ -1033418097))) * var39
                                 + 0.5F
                           );
                        var4[var12] = var35;
                        var5[var12] = var33;
                        var6[var12] = (float)var46 * var19;
                        var7[var12] = var32;
                        var8[var12] = var32 * 0.5F;
                        var9[var12++] = var30;
                        var4[var12] = var35;
                        var5[var12] = var33;
                        var6[var12] = Math.max(var32, (float)var46 * var19 * var36);
                        var7[var12] = var32;
                        var8[var12] = var32 * 0.5F;
                        var9[var12++] = var31 | var40;
                     }
                  }
               }
            }
         }
      } catch (RuntimeException var42) {
         throw var42;
      }

      VertexConsumerProvider.Immediate var44 = PlateBatchCache.IMM;
      PlateBatchCache.e(var44.getBuffer(PlateBatchCache.PLATES), var12);
      if (var13 && this.dz) {
         try {
            this.p(var1, var2, var44.getBuffer(PlateBatchCache.ITEMS));
            var44.draw();
         } catch (Throwable var41) {
            this.dz = false;
            PlateIconCache.off();
         }
      }

      var44.draw();
      this.q(var1, var2, var3);
   }

   private void p(int var1, int var2, VertexConsumer var3) {

      float var4 = PlateBatchCache.ox;
      float var5 = PlateBatchCache.oy;
      float var6 = PlateBatchCache.oz;
      float var7 = PlateBatchCache.exx;
      float var8 = PlateBatchCache.exy;
      float var9 = PlateBatchCache.exz;
      float var10 = PlateBatchCache.eyx;
      float var11 = PlateBatchCache.eyy;
      float var12 = PlateBatchCache.eyz;
      float[] var13 = PlateIconCache.U0;
      float[] var14 = PlateIconCache.U1;
      float[] var15 = PlateIconCache.V0;
      float[] var16 = PlateIconCache.V1;

      assert var3 != null
         && var1 >= 0
         && var2 > var1
         && var2 <= this.ea
         && var13.length == 56
         && var14.length == 56
         && var15.length == 56
         && var16.length == 56
         && this.fe.length == 50
         && this.fd.length == 50
         && var7 == var7
         && var11 == var11 : "icons";

      try {
         for (int var17 = var1; var17 < var2; var17++) {
            int var18 = this.ez[var17];
            if (var18 >= 0) {
               float var19 = this.eb[var17];
               float var20 = this.ec[var17];
               float var21 = (float)this.er[var17];
               int var22 = this.ev[var17];
               int var23 = this.ew[var17];
               int var24 = var18 * 5;
               float var25 = var20 + (float)this.ex[var17] * var21;
               float var26 = var25 + (float)var22 * var21;
               int var27 = 0;

               for (int var28 = 0; var28 < 5; var28++) {
                  if (this.fd[var24 + var28]) {
                     float var29 = var19 + (float)(this.ey[var17] + var27 * (var22 + var23)) * var21;
                     float var30 = var29 + (float)var22 * var21;
                     var27++;
                     int var31 = this.fe[var24 + var28];
                     if (var31 >= 0) {
                        float var32 = var13[var31];
                        float var33 = var14[var31];
                        float var34 = var15[var31];
                        float var35 = var16[var31];
                        var3.vertex(var4 + var29 * var7 + var25 * var10, var5 + var29 * var8 + var25 * var11, var6 + var29 * var9 + var25 * var12)
                           .texture(var32, var34)
                           .color(-1);
                        var3.vertex(var4 + var29 * var7 + var26 * var10, var5 + var29 * var8 + var26 * var11, var6 + var29 * var9 + var26 * var12)
                           .texture(var32, var35)
                           .color(-1);
                        var3.vertex(var4 + var30 * var7 + var26 * var10, var5 + var30 * var8 + var26 * var11, var6 + var30 * var9 + var26 * var12)
                           .texture(var33, var35)
                           .color(-1);
                        var3.vertex(var4 + var30 * var7 + var25 * var10, var5 + var30 * var8 + var25 * var11, var6 + var30 * var9 + var25 * var12)
                           .texture(var33, var34)
                           .color(-1);
                     }
                  }
               }
            }
         }
      } catch (RuntimeException var36) {
         throw var36;
      }
   }

   private void q(int var1, int var2, boolean var3) {

      TextRenderer var4 = a.textRenderer;
      PlateTextCache var5 = PlateBatchCache.TEXT;
      Matrix4f var6 = this.dc;
      float var7 = PlateBatchCache.ox;
      float var8 = PlateBatchCache.oy;
      float var9 = PlateBatchCache.oz;
      float var10 = PlateBatchCache.exx;
      float var11 = PlateBatchCache.exy;
      float var12 = PlateBatchCache.exz;
      float var13 = PlateBatchCache.eyx;
      float var14 = PlateBatchCache.eyy;
      float var15 = PlateBatchCache.eyz;
      boolean var16 = this.fs;

      assert var4 != null
         && var5 != null
         && var6 != null
         && var1 >= 0
         && var2 > var1
         && var2 <= this.ea
         && this.fb.length == (-1414757471 ^ -1414757727)
         && this.fg.length == 50
         && this.fh.length == 50
         && this.fi.length == 50
         && this.fd.length == 50
         && var10 == var10
         && var14 == var14
         && var7 == var7 : "text";

      try {
         for (int var17 = var1; var17 < var2; var17++) {
            float var18 = this.ed[var17];
            float var19 = this.eb[var17];
            float var20 = this.ec[var17];
            float var21 = (float)this.er[var17];
            int var22 = (int)(255.0F * var18 + 0.5F);
            if (var22 >= 8) {
               int var23 = var22 << 24 | 1216099637 ^ 1216596682;
               float var24 = var19 + (float)this.et[var17] * var21;
               float var25 = var20 + (float)(this.es[var17] - 7) * var21;
               var6.set(
                  var10 * var21,
                  var11 * var21,
                  var12 * var21,
                  0.0F,
                  var13 * var21,
                  var14 * var21,
                  var15 * var21,
                  0.0F,
                  0.0F,
                  0.0F,
                  0.0F,
                  0.0F,
                  var7 + var24 * var10 + var25 * var13,
                  var8 + var24 * var11 + var25 * var14,
                  var9 + var24 * var12 + var25 * var15,
                  1.0F
               );
               var4.draw(this.fb[var17], 0.0F, 0.0F, var23, false, var6, var5, TextRenderer.TextLayerType.SEE_THROUGH, 0, 482486103 ^ 473048999);
               int var26 = this.ez[var17];
               if (var26 >= 0 && var16) {
                  float var27 = this.ee[var17];
                  int var28 = this.ev[var17];
                  int var29 = this.ew[var17];
                  int var30 = this.ey[var17];
                  int var31 = this.ex[var17];
                  int var32 = var26 * 5;
                  int var33 = 0;

                  for (int var34 = 0; var34 < 5; var34++) {
                     if (this.fd[var32 + var34]) {
                        int var35 = var30 + var33 * (var28 + var29);
                        var33++;
                        OrderedText var36 = this.fg[var32 + var34];
                        if (var36 != null) {
                           float var37 = (float)var35 + (float)var28 * 0.5F;
                           int var38 = var31 - Math.round(1.5F * var27);
                           OrderedText var39 = this.fh[var32 + var34];
                           if (var39 != null) {
                              var24 = var19 + (float)Math.round(var37 - this.fj[var32 + var34] * 0.5F) * var21;
                              var25 = var20 + (float)(var38 - 7) * var21;
                              var6.set(
                                 var10 * var21,
                                 var11 * var21,
                                 var12 * var21,
                                 0.0F,
                                 var13 * var21,
                                 var14 * var21,
                                 var15 * var21,
                                 0.0F,
                                 0.0F,
                                 0.0F,
                                 0.0F,
                                 0.0F,
                                 var7 + var24 * var10 + var25 * var13,
                                 var8 + var24 * var11 + var25 * var14,
                                 var9 + var24 * var12 + var25 * var15,
                                 1.0F
                              );
                              var4.draw(var39, 0.0F, 0.0F, var23, false, var6, var5, TextRenderer.TextLayerType.SEE_THROUGH, 0, -1451810697 ^ -1450762105);
                              var38 -= Math.round(5.5F * var27);
                           }

                           var24 = var19 + (float)Math.round(var37 - this.fi[var32 + var34] * 0.5F) * var21;
                           var25 = var20 + (float)(var38 - 7) * var21;
                           var6.set(
                              var10 * var21,
                              var11 * var21,
                              var12 * var21,
                              0.0F,
                              var13 * var21,
                              var14 * var21,
                              var15 * var21,
                              0.0F,
                              0.0F,
                              0.0F,
                              0.0F,
                              0.0F,
                              var7 + var24 * var10 + var25 * var13,
                              var8 + var24 * var11 + var25 * var14,
                              var9 + var24 * var12 + var25 * var15,
                              1.0F
                           );
                           var4.draw(var36, 0.0F, 0.0F, var23, false, var6, var5, TextRenderer.TextLayerType.SEE_THROUGH, 0, 73378777 ^ 78621481);
                        }
                     }
                  }
               }
            }
         }
      } catch (RuntimeException var40) {
         throw var40;
      }

      if (var3) {
         var5.learn();
      }

      var5.draw();
   }

   private int r(ItemStack var1, TextRenderer var2, Style var3, int var4) {
      int var5 = 0;
      int var6 = 0;
      int var7 = 0;
      int var8 = 0;
      int var9 = 0;
      int var10 = 0;
      byte var11 = 0;

      label53:
      while (true) {
         label51:
         while (true) {
            label49:
            while (true) {
               label47:
               while (true) {
                  label45:
                  while (true) {
                     switch (var11) {
                        case 0:
                        default:
                           if (gr != 0) {
                              Math.abs(Integer.MIN_VALUE);
                              var11 = 7;
                              continue;
                           }
                           break label49;
                        case 1:
                           break label51;
                        case 3:
                           break;
                        case 4:
                           if (var9 < 4) {
                              var10 = var5 + var9 & (1046058944 ^ 1046058815);
                              if (this.gg[var10] == var1) {
                                 var6 = var10;
                                 var11 = 2;
                                 continue;
                              }
                              break;
                           }
                        case 2:
                           if (var6 < 0) {
                              var6 = var7;
                              this.s(var7, var1, var2, var3, var4);
                              var11 = 5;
                              continue;
                           }
                           break label45;
                        case 5:
                           break label53;
                        case 6:
                           break label45;
                        case 7:
                           break label49;
                        case 8:
                           break label47;
                     }

                     if (this.gj[var10] >= var8) {
                        break label51;
                     }

                     var8 = this.gj[var10];
                     var7 = var10;
                     var11 = 1;
                  }

                  if (this.gi[var6] != var1.getDamage()) {
                     break;
                  }

                  if (this.gk[var6] == var4) {
                     break label53;
                  }

                  var11 = 8;
               }

               this.s(var6, var1, var2, var3, var4);
               var11 = 5;
            }

            var5 = System.identityHashCode(var1) & (1231800208 ^ 1231800175);
            var6 = -1;
            var7 = var5;
            var8 = -123168246 ^ -2024315403;
            var9 = 0;
            var11 = 4;
         }

         var9++;
         var11 = 4;
      }

      this.gj[var6] = this.gp;
      return var6;
   }

   private void s(int var1, ItemStack var2, TextRenderer var3, Style var4, int var5) {

      this.gg[var1] = var2;
      this.gi[var1] = var2.getDamage();
      this.gk[var1] = var5;
      this.gl[var1] = null;
      this.gm[var1] = null;
      ItemEnchantmentsComponent var6 = var2.getEnchantments();
      if (var6 != null && !var6.isEmpty()) {
         int var7 = 120104659 ^ 2027378988;
         int var8 = -1672223845 ^ -475259804;
         int var9 = 0;
         int var10 = 0;
         int var11 = 0;
         int var12 = 0;

         for (Entry var14 : var6.getEnchantmentEntries()) {
            RegistryEntry var15 = (RegistryEntry)var14.getKey();
            String var16 = var15.getIdAsString();
            int var17 = var16.indexOf(58);
            String var18 = var17 >= 0 ? var16.substring(var17 + 1) : var16;
            int var19 = -1;

            for (int var20 = 0; var20 < bb.length; var20++) {
               if (bb[var20].equals(var18)) {
                  var19 = var20;
                  break;
               }
            }

            if (var19 >= 0) {
               int var25 = var14.getIntValue();
               int var21 = ((Enchantment)var15.value()).getMaxLevel();
               if (var19 < var7) {
                  var8 = var7;
                  var10 = var9;
                  var12 = var11;
                  var7 = var19;
                  var9 = var25;
                  var11 = var21;
               } else if (var19 < var8) {
                  var8 = var19;
                  var10 = var25;
                  var12 = var21;
               }
            }
         }

         if (var7 != (1058924836 ^ 1088558811)) {
            Style var22 = var4.withColor(l(216375220 ^ 203055179));
            String var23 = var11 <= 1 && var9 <= 1 ? bc[var7] : bc[var7] + bd[3] + var9;
            this.gl[var1] = OrderedText.styledForwardsVisitedString(var23, var22);
            this.gn[var1] = var3.getTextHandler().getWidth(this.gl[var1]);
            if (var8 != (-951355616 ^ -1196128033)) {
               String var24 = var12 <= 1 && var10 <= 1 ? bc[var8] : bc[var8] + bd[3] + var10;
               this.gm[var1] = OrderedText.styledForwardsVisitedString(var24, var22);
               this.go[var1] = var3.getTextHandler().getWidth(this.gm[var1]);
            }
         }
      }
   }

   private void t() {

      float var1 = (float)this._kwren_do;
      int[] var2 = this.bu;
      int[] var3 = this.bv;
      Arrays.fill(var3, 375862142 ^ -1771621506);
      Arrays.fill(this.cv, null);
      Arrays.fill(this.ct, null);
      int var4 = 0;

      assert var2.length == (290793482 ^ 290793994)
         && var3.length == (-1845447464 ^ -1845446952)
         && this.bw.length == (1387920184 ^ 1387919672)
         && this.bx.length == (823628880 ^ 823629392)
         && this.cu.length == (-1019996089 ^ -1019995577)
         && this.cv.length == (-1398915790 ^ -1398915278)
         && this.cs.length == (295320830 ^ 295321342)
         && this.cw.length == (-1172298051 ^ -1172298563)
         && this.ce.length == (-2015158160 ^ -2015157648)
         && this.cg.length == (1353134969 ^ 1353134457)
         && this.ci.length == (-808474265 ^ -808473753)
         && this.ck.length == (1880138446 ^ 1880137934) : "prune";

      try {
         for (int var5 = 0; var5 < (-689488703 ^ -689488191); var5++) {
            int var6 = var2[var5];
            if (var6 != (-1123681387 ^ 1023802261) && !(var1 - this.bw[var5] > 2.0F)) {
               int var7 = var6 * (1281228976 ^ -764839679) >>> 23;

               while (var3[var7] != (1669768132 ^ -477715516)) {
                  var7 = var7 + 1 & (-716275796 ^ -716276141);
               }

               var3[var7] = var6;
               this.bx[var7] = this.bw[var5];
               this.bz[var7] = this.by[var5];
               this.cb[var7] = this.ca[var5];
               this.cd[var7] = this.cc[var5];
               this.cf[var7] = this.ce[var5];
               this.ch[var7] = this.cg[var5];
               this.cj[var7] = this.ci[var5];
               this.cp[var7] = this.co[var5];
               this.cl[var7] = this.ck[var5];
               this.cn[var7] = this.cm[var5];
               this.cr[var7] = this.cq[var5];
               this.ct[var7] = this.cs[var5];
               this.cv[var7] = this.cu[var5];
               this.cx[var7] = -1;
               var4++;
            }
         }
      } catch (RuntimeException var9) {
         throw var9;
      }

      this.bu = var3;
      this.bv = var2;
      float[] var10 = this.bw;
      this.bw = this.bx;
      this.bx = var10;
      var10 = this.by;
      this.by = this.bz;
      this.bz = var10;
      var10 = this.cc;
      this.cc = this.cd;
      this.cd = var10;
      int[] var13 = this.ca;
      this.ca = this.cb;
      this.cb = var13;
      var13 = this.ce;
      this.ce = this.cf;
      this.cf = var13;
      var13 = this.cg;
      this.cg = this.ch;
      this.ch = var13;
      var13 = this.ck;
      this.ck = this.cl;
      this.cl = var13;
      var13 = this.cm;
      this.cm = this.cn;
      this.cn = var13;
      var13 = this.ci;
      this.ci = this.cj;
      this.cj = var13;
      var13 = this.co;
      this.co = this.cp;
      this.cp = var13;
      var13 = this.cq;
      this.cq = this.cr;
      this.cr = var13;
      var13 = this.cw;
      this.cw = this.cx;
      this.cx = var13;
      String[] var22 = this.cs;
      this.cs = this.ct;
      this.ct = var22;
      LabelLineCache[] var8 = this.cu;
      this.cu = this.cv;
      this.cv = var8;
      this.cy = var4;
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

   static {
      String var0 = "lithium";
      String var1 = "hud2_";

      for (int var2 = 0; var2 < at.length; var2++) {
         for (int var3 = 0; var3 < 3; var3++) {
            aw[var2][var3] = Style.EMPTY.withFont(new StyleSpriteSource.Font(Identifier.of(var0, var1 + at[var2] + "_" + (var3 + 1))));
         }
      }

      for (int var4 = 0; var4 < 12; var4++) {
         ba[var4] = (float)Math.log((double)(az[var4] * (float)ay[var4]));
      }

      bb = new String[]{
         "prot" + "ect" + "i" + "on",
         "sharpness",
         "effic" + "ie" + "ncy",
         "power",
         "density",
         "breach",
         "loyalty",
         "riptide",
         "impaling",
         "piercing",
         "multi" + "s" + "h" + "ot",
         "quick_ch" + "arge",
         "lunge",
         "lure",
         "blast_" + "protecti" + "on",
         "fire_pr" + "otection",
         "projectile_pr" + "otection",
         "smite",
         "ban" + "e_of_arthropods",
         "fortune",
         "silk_t" + "o" + "u" + "ch",
         "looting",
         "luck_of_the_sea",
         "punch",
         "flame",
         "infinity",
         "fir" + "e_aspect",
         "knoc" + "kback",
         "swee" + "p" + "ing_ed" + "ge",
         "channeling",
         "wi" + "nd_b" + "urst",
         "feathe" + "r_fa" + "lli" + "ng",
         "dep" + "t" + "h" + "_strider",
         "frost_walk" + "er",
         "soul_s" + "pe" + "ed",
         "swift_s" + "n" + "eak",
         "resp" + "iration",
         "aq" + "ua_affinity",
         "thorns",
         "un" + "breaki" + "ng",
         "mending"
      };
      bc = new String[]{
         "Prot",
         "Sharp",
         "Eff",
         "Power",
         "Dens",
         "Breach",
         "Loyal",
         "Rip",
         "Imp",
         "Pierce",
         "Multi",
         "QC",
         "Lunge",
         "Lure",
         "BP",
         "FP",
         "PP",
         "Smite",
         "Bane",
         "Fort",
         "Silk",
         "Loot",
         "Luck",
         "Punch",
         "Flame",
         "Inf",
         "Fire",
         "KB",
         "Sweep",
         "Chan",
         "Wind",
         "FF",
         "Depth",
         "Frost",
         "Soul",
         "Swift",
         "Resp",
         "Aqua",
         "Thr",
         "Unb",
         "Mend"
      };
      bd = new String[]{"  ", "m", "ms", " ", "."};
      be = new String[4001];
      bf = new String[129];
      bg = new String[1000];
   }
}
