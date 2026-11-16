package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.CoreSerializer;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.InitNotifier;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.LinkerFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.UtilExtension;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.element.LoaderDelegate;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.element.PaneGlassCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.ParserEngine;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.BlockCalculator;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.CheckerBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.ItemDescriptor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.SlotEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.CoreOptimizer;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.EchoPassCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.FacetArrayCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.HaloPassCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.LayerTextureCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.NoticeQueue;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.RegionPassCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.StyleKeyCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.TracePassCache;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.particle.TrailParticleEffect;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.world.attribute.EnvironmentAttribute;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.Vec3d;
import net.minecraft.text.Text;
import net.minecraft.text.Style;
import net.minecraft.network.packet.s2c.play.EntityStatusS2CPacket;
import net.minecraft.util.Identifier;
import net.minecraft.resource.Resource;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.RaycastContext;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.client.option.AttackIndicator;
import net.minecraft.block.enums.CameraSubmersionType;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.gui.PlayerSkinDrawer;
import net.minecraft.entity.player.PlayerSkinType;
import net.minecraft.network.packet.s2c.play.EntityDamageS2CPacket;
import net.minecraft.entity.player.SkinTextures;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fStack;
import org.joml.Matrix3x2fc;
import org.joml.Matrix4f;
import net.minecraft.client.font.TextRenderer;import net.minecraft.text.StyleSpriteSource;import net.minecraft.util.hit.HitResult;
public final class NodeZoneRenderer extends BuilderFactory implements InitNotifier, UtilExtension, CoreSerializer {
   private static final String ei = "Ｃｒｏｓｓ";
   private static final String ej = "Ｄｏｔ";
   private static final String ek = "Ｅｖｅｒｙｏｎｅ";
   private static final String el = "Ｓｏｌｉｄ";
   private static final String em = "Ｂｌｕｅ";
   private static final String en = "Ｃｙａｎ";
   private static final String eo = "Ｇｒｅｅｎ";
   private static final String ep = "Ｒｅｄ";
   private static final String eq = "Ｏｒａｎｇｅ";
   private static final String er = "Ｐｉｎｋ";
   private static final String es = "Ｐｕｒｐｌｅ";
   private static final String et = "Ｓｋｙ";
   private static final String eu = "Ｗｈｉｔｅ";
   private static final String ev = "Ｙｅｌｌｏｗ";
   private static final String ew = "Ｖｉｏｌｅｔ";
   private static final String ex = "Ｍａｇｅｎｔａ";
   private static final String ey = "Ｎｉｇｈｔ";
   private static final String ez = "ＲＧＢ";
   private static final String fa = "Ｖａｎｉｌｌａ";
   private static final String fc = "Ｍａｔｃｈ";
   private static final String fd = "Ｔｈｅｍｅ";
   private static final String[] fe = new String[]{"Ｔｈｅｍｅ", "Ｔｈｅｍｅ ２", "Ｗｈｉｔｅ", "Ｃｙａｎ", "Ｐｉｎｋ", "Ｒｅｄ", "Ｇｏｌｄ", "Ｙｅｌｌｏｗ", "Ｏｒａｎｇｅ", "Ｖｉｏｌｅｔ", "ＲＧＢ"};
   private static final String[] ff = new String[]{"Ｏｒｂｉｔ", "Ｓｔａｒ", "Ｗｉｎｇｓ", "Ｓｐａｒｋｌｅｓ", "Ｒｉｎｇ", "Ｓｗｅｅｐ", "Ｌｉｇｈｔｎｉｎｇ"};
   private static final String[] fg = new String[]{"Ｔａｒｇｅｔ", "Ｓｅｌｆ", "Ｂｏｔｈ"};
   private static final String[] fh = new String[]{"Ｓｅｌｆ", "Ｆｒｉｅｎｄｓ", "Ｅｖｅｒｙｏｎｅ"};
   private static final String[] fi = new String[]{"Ｒｉｂｂｏｎ", "Ｇｌｙｐｈｓ", "Ｂｏｔｈ"};
   private static final String[] fj = new String[]{"Ｓｅｌｆ", "Ｅｖｅｒｙｏｎｅ"};
   private static final String[] fk = new String[]{"Ｓｈａｒｄｓ", "Ｓｐａｒｋｓ", "Ｂｏｔｈ"};
   private static final String[] fl = new String[]{"Ｓｏｕｌ", "Ｓｈｏｃｋｗ" + "ａ" + "ｖｅ", "Ｓｈａｔｔｅｒ", "Ｌｉｇｈ" + "ｔｎ" + "ｉｎｇ", "Ｓｕｐｅｒｎｏｖａ", "Ｖｏｉｄ", "Ｒａｎｄｏｍ"};
   private static final String[] fm = new String[]{"Ｋｉｌｌｓ", "Ｔａｒｇｅｔ", "Ｐｌａｙｅｒｓ", "Ｅｖｅｒｙｏｎｅ"};
   private final CheckerBridge fn;
   private final SlotEntry fo;
   private final CheckerBridge fp;
   private final CheckerBridge fq;
   private final SlotEntry fr;
   private final BlockCalculator fs;
   private final BlockCalculator ft;
   private final BlockCalculator fu;
   private final BlockCalculator fv;
   private final CheckerBridge fw;
   private final CheckerBridge fx;
   private final CheckerBridge fy;
   private final BlockCalculator fz;
   private final BlockCalculator ga;
   private final BlockCalculator gb;
   private final BlockCalculator gc;
   private final CheckerBridge gd;
   private final CheckerBridge ge;
   private final CheckerBridge gf;
   private final BlockCalculator gg;
   private final CheckerBridge gh;
   private final SlotEntry gi;
   private final SlotEntry gj;
   private final CheckerBridge gk;
   private final CheckerBridge gl;
   private final CheckerBridge gm;
   private final CheckerBridge gn;
   private final CheckerBridge go;
   private final CheckerBridge gp;
   private final CheckerBridge gq;
   private final BlockCalculator gr;
   private final BlockCalculator gs;
   private final SlotEntry gt;
   private final BlockCalculator gu;
   private final BlockCalculator gv;
   private final BlockCalculator gw;
   private final CheckerBridge gx;
   private final CheckerBridge gy;
   private final CheckerBridge gz;
   private final CheckerBridge ha;
   private final SlotEntry hb;
   private final SlotEntry hc;
   private final CheckerBridge hd;
   private final CheckerBridge he;
   private final SlotEntry hf;
   private final BlockCalculator hg;
   private final CheckerBridge hh;
   private final CheckerBridge hi;
   private final CheckerBridge hj;
   private final BlockCalculator hk;
   private final BlockCalculator hl;
   private final BlockCalculator hm;
   private final BlockCalculator hn;
   private final SlotEntry ho;
   private final CheckerBridge hp;
   private final SlotEntry hq;
   private final BlockCalculator hr;
   private final BlockCalculator hs;
   private final BlockCalculator ht;
   private final CheckerBridge hu;
   private final SlotEntry hv;
   private final BlockCalculator hw;
   private final SlotEntry hx;
   private final BlockCalculator hy;
   private final CheckerBridge hz;
   private final CheckerBridge ia;
   private final CheckerBridge ib;
   private final SlotEntry ic;
   private final CheckerBridge id;
   private final SlotEntry ie;
   private final SlotEntry _kwren_if;
   private final BlockCalculator ig;
   private final BlockCalculator ih;
   private final BlockCalculator ii;
   private final BlockCalculator ij;
   private final CheckerBridge ik;
   private final SlotEntry il;
   private final CheckerBridge im;
   private final SlotEntry in;
   private final BlockCalculator io;
   private final BlockCalculator ip;
   private final SlotEntry iq;
   private final CheckerBridge ir;
   private final SlotEntry is;
   private final SlotEntry it;
   private final BlockCalculator iu;
   private final BlockCalculator iv;
   private final BlockCalculator iw;
   private final SlotEntry ix;
   private final CheckerBridge iy;
   private final SlotEntry iz;
   private final BlockCalculator ja;
   private final SlotEntry jb;
   private final CheckerBridge jc;
   private final CheckerBridge jd;
   private final CheckerBridge je;
   private final CheckerBridge jf;
   private final CheckerBridge jg;
   private final CheckerBridge jh;
   private final BlockCalculator ji;
   private final SlotEntry jj;
   private final BlockCalculator jk;
   private final BlockCalculator jl;
   private final CheckerBridge jm;
   private final SlotEntry jn;
   private final SlotEntry jo;
   private final SlotEntry jp;
   private final BlockCalculator jq;
   private final BlockCalculator js;
   private final CheckerBridge jt;
   private final CheckerBridge ju;
   private final CheckerBridge jv;
   private final CheckerBridge jw;
   private final BlockCalculator jx;
   private static final int[] jy = new int[]{5943551, 16777215, 16730955, 4644954, 3596512, 16740039, 10120959, 16767050};
   private static final int[] jz = new int[]{5943551, 16777215, 10120959, 16740039, 16730955, 16751162, 4644954, 3596512, -3};
   private static final int[] ka = new int[]{9203455, 3832831, 3596512, 4644954, 16730955, 16751162, 16740039, 16777215, -1};
   private static final int[] kb = new int[]{10120959, 3832831, 3596512, 4644954, 16730955, 16751162, 16740039, -3};
   private static final int[] kc = new int[]{-1, -2, 461338, 10120959, 3832831, 3596512, 4644954, 16730955, 16751162, 16740039, -3};
   private static final int[] kd = new int[]{-3, -4, 16777215, 6087152, 15757528, 15745871, 15122522, 16769370, 16742943, 10120959, -1};
   private static final int[] ke = new int[]{12607743, 10120959, 3832831, 3596512, 4644954, 16751162, 16740039, 16777215};
   private static final int kf = 0;
   private static final int kg = 1;
   private static final int kh = 2;
   private static final int ki = 3;
   private static final int kj = 4;
   private static final int kk = 5;
   private static final int kl = 6;
   private static final int km = 7;
   private static final int kn = 8;
   private static final int ko = 9;
   private static final int kp = 10;
   private static final int kq = 11;
   private static final int kr = 12;
   private static final int ks = 13;
   private static final int kt = 14;
   private static final String[] ku = new String[]{
      "s",
      "m",
      "ms",
      "×",
      " / ",
      "88.8m " + " " + "88" + "8ms",
      "-",
      ".",
      "Player",
      "2.4s",
      "3.4m",
      "42ms",
      "Di" + "stance: ",
      "  ·  ",
      "lithium-t" + "gt" + "-head"
   };
   private static final int kv = 128;
   private static final int[] kw = new int[128];
   private static final long[] kx = new long[128];
   private static final String[] ky = new String[128];
   private static final int kz = 1;
   private static final int la = 2;
   private static final int lb = 3;
   private static final int lc = 4;
   private static final int ld = 5;
   private static final int le = 6;
   private static final int lf = 7;
   private static final int lg = 8;
   private static final int lh = 9;
   private static final int li = 128;
   private static final String[] lj = new String[128];
   private static final int[] lk = new int[128];
   private static final Text[] ll = new Text[128];
   private static final int[] lm = new int[128];
   public static volatile NodeZoneRenderer INSTANCE;
   public static volatile boolean ON;
   public static volatile boolean LINGER;
   public static volatile long HIT_MS;
   public static final float[] HAND = new float[8];
   public static volatile boolean HAND_ON;
   public static volatile boolean SKY_HOT;
   public static volatile boolean FOG_HOT;
   public static volatile boolean TINT_HOT;
   public static volatile boolean FB_HOT;
   public static volatile float FB_AMB;
   public static volatile float FB_NV;
   public static volatile float FB_TA;
   public static volatile float FB_TN;
   public static volatile long FB_LIVE;
   public static volatile boolean POPS_ON;
   public static final ConcurrentLinkedQueue<EntityStatusS2CPacket> POP_Q = new ConcurrentLinkedQueue<>();
   public static volatile boolean DEATH_ON;
   public static volatile int SELF_ID = -1;
   public static final ConcurrentLinkedQueue<EntityStatusS2CPacket> DEATH_Q = new ConcurrentLinkedQueue<>();
   public static final ConcurrentLinkedQueue<EntityDamageS2CPacket> DMG_Q = new ConcurrentLinkedQueue<>();
   public boolean ln;
   public int lo;
   public int csRgb;
   public int lp;
   public float lq;
   public float lr;
   public float ls;
   private boolean lt;
   private boolean lu;
   private boolean lv;
   private boolean lw;
   private boolean lx;
   private boolean ly;
   private int lz;
   private int ma;
   private int mb;
   private int mc;
   private double md;
   private double me;
   private float mf;
   private boolean mg;
   private boolean mh;
   private boolean mi;
   private boolean mj;
   private boolean mk;
   private boolean ml;
   private int mm;
   private int mn;
   private float mo;
   private double mp;
   private double mq;
   private double mr;
   private boolean ms;
   private boolean mt;
   private boolean mu;
   private boolean mv;
   private boolean mw;
   private boolean mx;
   private boolean my;
   private boolean mz;
   private int na;
   private int nb;
   private double nc;
   private double nd;
   private boolean ne;
   private boolean nf;
   private boolean ng;
   private boolean nh;
   private int ni;
   private int nj;
   private float nk;
   private float nl;
   private float nm;
   private float nn;
   private float no;
   private static final float np = 0.18F;
   private static final float nq = 0.22F;
   private static final float nr = 0.2F;
   private static final long ns = 250000000L;
   private boolean nt;
   private float nu;
   private long nv;
   private long nw;
   private float nx;
   private float ny;
   private float nz;
   private float oa;
   private float ob;
   private float oc;
   private float od;
   private float oe;
   private float of;
   private float og;
   private float oh;
   private float oi;
   private float oj;
   private float ok;
   private float ol;
   private float om;
   private float on;
   private float oo;
   private float op;
   private float oq;
   private float or;
   private float os;
   private float ot;
   private float ou;
   private float ov;
   private float ow;
   private float ox;
   private float oy;
   private float oz;
   private float pa;
   private float pb;
   private long pc;
   private long pd;
   private double pe;
   private double pf;
   private static final int pg = 37;
   private static final int ph = 12;
   private static final long pi = 130L;
   private static final double pj = 0.06;
   private static final double pk = 0.15;
   private static final double pl = 0.03;
   private static final double pm = 4096.0;
   private static final double pn = 4.0;
   private static final int po = 6;
   private static final float[] pp = new float[37];
   private static final float[] pq = new float[37];
   private final ArrayList<double[]> pr;
   private final HashMap<UUID, double[]> ps;
   private final HashSet<UUID> pt;
   private int pu;
   private final Matrix4f pv;
   private final float[] pw;
   private double px;
   private double py;
   private double pz;
   private float qa;
   private float qb;
   private float qc;
   private boolean qd;
   private long qe;
   private final Matrix3x2f qf;
   private final float[] qg;
   private final float[] qh;
   private final boolean[] qi;
   private final float[] qj;
   private final float[] qk;
   private final float[] ql;
   private float qm;
   private float qn;
   private static final double qo = 0.03;
   private static final double qp = 0.99;
   private static final int qq = 300;
   private static final int qr = 160;
   private final HashMap<Integer, NodeZoneRenderer.Trk> qs;
   private final ArrayList<NodeZoneRenderer.Trk> qt;
   private final HashSet<Integer> qu;
   private final double[] qv;
   private int qw;
   private int qz;
   private boolean ra;
   private float rb;
   private float rc;
   private double rd;
   private double re;
   private double rf;
   private long rg;
   private ItemStack rh;
   private ItemStack ri;
   private final double[] rj;
   private int rk;
   private int rl;
   private double rm;
   private double rn;
   private double ro;
   private LivingEntity rp;
   private long rq;
   private long rr;
   private int rs;
   private static final int rt = 16;
   private static final int ru = 32;
   private static final int rv = 32;
   private static final int rw = 64;
   private static final int rx = 4;
   private static final long ry = 5000L;
   private static final long rz = 3000L;
   private static final long sa = -2305843009213693952L;
   private static final double sb = 4096.0;
   private final int[] sc;
   private final long[] sd;
   private final int[] se;
   private final int[] sf;
   private final long[] sg;
   private final EntityStatusS2CPacket[] sh;
   private int si;
   private boolean sj;
   private int sk;
   private static final int sl = 30;
   private int sm;
   private LivingEntity sn;
   private final ItemStack[] so;
   private final int[] sp;
   private LivingEntity sq;
   private String sr;
   private long ss;
   private int st;
   private int su;
   private long sv;
   private long sw;
   private long sx;
   private long sy;
   private LivingEntity sz;
   private float ta;
   private float tb;
   private float tc;
   private long te;
   private long tf;
   private final float[] tg;
   private final float[] ti;
   private final long[] tj;
   private final String[] tk;
   private int tl;
   private int tm;
   private LivingEntity tn;
   private float to;
   private final HashMap<Integer, Integer> tp;
   private int tq;
   private int tr;
   private boolean ts;
   private boolean tt;
   private boolean tu;
   private String tv;
   private String tw;
   private int tx;
   private int ty;
   private int tz;
   private int ua;
   private LivingEntity ub;
   private long uc;
   private int ud;
   private int ue;
   private int uf;
   private int ug;
   private float uh;
   private float ui;
   private float uj;
   private float uk;
   private float ul;
   private float um;
   private String un;
   private String uo;
   private String up;
   private int uq;
   private int ur;
   private LivingEntity us;
   private float ut;
   private long uu;
   private String uv;
   private String uw;
   private int ux;
   private int uy;
   private float uz;
   private float va;
   private float vb;
   private Text vc;
   private String vd;
   private int ve;
   private float vf;
   private String vg;
   private String vh;
   private float vi;
   private float vj;
   private LivingEntity vk;
   private String vl;
   private long vm;
   private static final int vn = 6;
   private static final Identifier[] vo;
   private final Identifier[] vq;
   private final int[] vr;
   private final int[] vs;
   private final boolean[] vt;
   private final long[] vu;
   private final long[] vv;
   private final int[] vw;
   private final int[] vx;
   private final int[] vy;
   private final float[] vz;
   private float wa;
   private float wb;
   private float wc;
   private final float[] wd;
   private final float[] we;
   private boolean wf;
   private boolean wg;
   private long wh;
   private NodeZoneRenderer.Vis[] wi;
   private NodeZoneRenderer.Vis[] wj;
   private InitAdapter[] wk;
   private Object[] wl;
   private long wm;
   private float wn;
   private float wo;
   private float wp;
   private ItemStack wq;
   private ItemStack wr;
   public static final int Z2 = 2;
   public static final int Z6 = 6;
   private static final int ws = 5;
   private static final int wt = 24;
   private static final int wu = 12;
   private static final byte[] wv;
   private static final int[] ww;
   private final int[] wx;
   private final float[] wy;
   private static final int wz = 1975348;
   private static final int xa = 658450;
   private static final int xb = 4871272;
   private static final int xc = 3818068;
   private static final int xd = 3028292;
   private static final float[] xe;
   private static final int[] xf;
   private static final int[] xg;
   private static final int[] xh;
   private static final Style[] xi;
   private static final LivingEntity[] xj;
   private static int xk;
   private static final long xl = 1500L;
   private static final double xm = 576.0;
   private static final float xn = 0.75F;
   private final LivingEntity[] xo;
   private final float[] xp;
   private final boolean[] xq;
   private boolean xr;
   private boolean xs;
   private static final int xt = 8;
   private static final int[] xu;
   private static final int[] xv;
   private static final int[] xw;
   private static final long[] xx;
   private static int xy;
   private static final long xz = 2500L;
   private static final double ya = 2.5600000000000005;
   private static int yc = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   public NodeZoneRenderer() {
      super("", "", ParserEngine.Z3);
      this.setName(
         new char[]{'ᚬ', 'ᚷ', 'ᚑ', 'ᚤ', 'ᕃ', 'ᕴ', 'ᔘ', 'ᔠ'},
         -1106712166,
         new char[]{
            '娀',
            '娗',
            '娲',
            '嫔',
            '嫐',
            '嫳',
            'ꗽ',
            '媿',
            '奉',
            '奵',
            '夊',
            '夫',
            '姟',
            '姷',
            '妜',
            '妦',
            'ꜳ',
            '塳',
            '堟',
            '場',
            'ꞯ',
            '壸',
            '墄',
            '墿',
            '坞',
            '坫',
            '圅',
            'ꡈ',
            '埂',
            '埠',
            '垃',
            '垡',
            '噀',
            '噶',
            '嘒'
         },
         -2127583965
      );
      CheckerBridge var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'㲏', '㳅', '㲸', '㭆', '㭻', '㬔', '㬮', '㯄', '㯭', '㮑'}, -1288125524);
      this.fn = var10001;
      this.fo = new SlotEntry("Ｓ．ｈａｐｅ", "Ｃｉｒｃｌｅ", "Ｃｉｒｃｌｅ", "Ｃｒｏｓｓ", "Ｄｏｔ");
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'盏', '甒', '甜', '畸'}, 272140797);
      this.fp = var10001;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'䣒', '䜙', '䝣', '䜘', '䜤', '뢳', '䞀', '䞘', '䞾', '䙈', '䙽'}, 1574746104);
      this.fq = var10001;
      this.fr = new SlotEntry("Ｒ．ｉｎｇ Ｓｃｏｐｅ", "Ｅｖｅｒｙｏｎｅ", "Ｅｖｅｒｙｏｎｅ", "Ｓｅｌｆ");
      BlockCalculator var6 = new BlockCalculator("", 0.5, 3.0, 1.0, 0.1);
      var6.n(new char[]{'ᨸ', '᩠', 'ᨆ', 'ᨠ', '\ue5a6', '᪖', '᪔', '᪦', '᥇', 'ᥥ'}, 1551099146);
      this.fs = var6;
      BlockCalculator var7 = new BlockCalculator("", 0.5, 3.0, 1.2, 0.1);
      var7.n(new char[]{'檏', '檕', '檵', '楝', '阙', '楫', '椾', '槌', '槰'}, 96966077);
      this.ft = var7;
      BlockCalculator var8 = new BlockCalculator("", 0.5, 4.0, 1.5, 0.1);
      var8.n(new char[]{'拋', '慑', '慹', '愑', '鹕', '憣', '懺', '憖', '憥', '恘'}, -141386247);
      this.fu = var8;
      BlockCalculator var9 = new BlockCalculator("", 1.0, 4.0, 1.0, 1.0);
      var9.n(new char[]{'럅', '뙟', '뙻', '똓', '䥓', '뚱', '뛾', '뚅', '뚡', '땚'}, 155863287);
      this.fv = var9;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'떺', '뗮', '떈', '떢', '䬤', '됑', '둥', '둃'}, 623725192);
      this.fw = var10001;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'鷠', '鶠', '挭', '鰀', '鰊', '鰤', '鳍'}, -1434164529);
      this.fx = var10001;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'ऌ', 'ख़', 'ष', 'ে', '৳', 'খ', 'দ', '\uf731', '࠘', 'ࡺ', 'ࡊ'}, 859239992);
      this.fy = var10001;
      BlockCalculator var13 = new BlockCalculator("", 0.0, 100.0, 58.5, 0.5);
      var13.n(new char[]{'褥', '褙', '襯', '癊', '覱'}, -981699059);
      this.fz = var13;
      BlockCalculator var14 = new BlockCalculator("", 0.0, 100.0, 55.5, 0.5);
      var14.n(new char[]{'\ueb47', '\uebbb', '\ueb89', 'ᓬ', '\uebd2'}, -957737873);
      this.ga = var14;
      BlockCalculator var15 = new BlockCalculator("", 1.0, 15.0, 5.0, 0.5);
      var15.n(new char[]{'軕', '赅', '赽', '贏', '费', '跅', '跤', '趄'}, 47608305);
      this.gb = var15;
      BlockCalculator var16 = new BlockCalculator("", 0.4, 1.5, 0.7, 0.05);
      var16.n(new char[]{'\ue464', '\ue45e', '\ue4ae', 'ᮉ', '\ue4fb', '\ue4ae', '\ue35c', '\ue360'}, -1034347700);
      this.gc = var16;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'輑', '載', '輯', '輨', '炾', '辜', '辎', '辶', '蹕', '蹫'}, -1901629406);
      this.gd = var10001;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'鶉', '鶑', '鶷', '鱀', '挖', '鱽', '鰱', '鳒', '鳾', '鲅', '鲸'}, -1315544390);
      this.ge = var10001;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'ꆾ', 'ꆢ', 'ꆜ', 'ꆣ', 'ꁇ', 'ꁯ'}, 1077698189);
      this.gf = var10001;
      BlockCalculator var20 = new BlockCalculator("", 1.0, 20.0, 10.0, 1.0);
      var20.n(new char[]{'鶸', '鷽', '鶀', '鶦', '鱀', '挆', '鱱', '鰭', '鳎', '鳧'}, 946954891);
      this.gg = var20;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'捁', '掟', '揻', '掖'}, 594844786);
      this.gh = var10001;
      this.gi = new SlotEntry("Ｓ．ｋｙ Ｍ" + "ｏｄｅ", "Ｔｉｎｔ", "Ｔｉｎｔ", "Ｓｏｌｉｄ");
      this.gj = new SlotEntry("Ｓ．ｋｙ " + "Ｃｏ" + "ｌ" + "ｏｒ", "Ｐｕｒｐｌｅ", "Ｐｕｒｐｌｅ", "Ｂｌｕｅ", "Ｃｙａｎ", "Ｇｒｅｅｎ", "Ｒｅｄ", "Ｏｒａｎｇｅ", "Ｐｉｎｋ", "Ｔｈｅｍｅ");
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'\ue4a9', '\ue4b7', '\ue493', '\ue4ae', 'ᰶ', '\ue307', '\ue373', '\ue351'}, -1190257766);
      this.gk = var10001;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'曈', '攃', '敹', '攇', '攦', '旋', '旺', '斎', '斡', '摍', '摰'}, 799709678);
      this.gl = var10001;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'呷', '周', '哀', '哥', '咑', '咮'}, 445033287);
      this.gm = var10001;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'⒌', 'ⓙ', '⒤', '⍔', '⍾', '⌖', '⌱', '⏅', '⏿', '⎝', '⎷'}, -2125145160);
      this.gn = var10001;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'狢', '狣', '煍', '煥', '焎', '焠', '燆', '燠', '軦', '燈', '灅', '灱', '瀉', '瀤', '烒'}, -1119908402);
      this.go = var10001;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'︢', '︮', 'ﹰ', '︋', '︳', 'ﻈ', '\ufeff', 'ﺕ', 'ﺮ', 'ﵖ', 'ȗ', 'ﵾ', '﵀', 'ﶰ'}, 1804730625);
      this.gp = var10001;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'쑲', '쑯', '쓅', '쓞', '쓬', '쒑', '㯜', '쌩', '쌝', '썻'}, 523909954);
      this.gq = var10001;
      BlockCalculator var29 = new BlockCalculator("", 0.0, 100.0, 50.0, 0.5);
      var29.n(new char[]{'悸', '惢', '悇', '悷', '彈', 'ꀃ', '彺'}, -1534222456);
      this.gr = var29;
      BlockCalculator var30 = new BlockCalculator("", 0.0, 100.0, 72.0, 0.5);
      var30.n(new char[]{'鬇', '鬓', '鬴', '鯆', '鯿', '擲', '鯈'}, -1591385033);
      this.gs = var30;
      this.gt = new SlotEntry("Ｃ．ｏｌｏｒ", "Ｓｋｙ", "Ｓｋｙ", "Ｗｈｉｔｅ", "Ｒｅｄ", "Ｇｒｅｅｎ", "Ｃｙａｎ", "Ｐｉｎｋ", "Ｐｕｒｐｌｅ", "Ｙｅｌｌｏｗ");
      BlockCalculator var31 = new BlockCalculator("", 0.5, 2.0, 1.0, 0.05);
      var31.n(new char[]{'畬', '男', '症', '痹'}, -107771297);
      this.gu = var31;
      BlockCalculator var32 = new BlockCalculator("", 0.5, 3.0, 1.0, 0.1);
      var32.n(new char[]{'酔', '鄷', '釗', '釾', '醗', '醵', '遟', '遪', '逋'}, -1504678304);
      this.gv = var32;
      BlockCalculator var33 = new BlockCalculator("", 0.0, 6.0, 1.6, 0.2);
      var33.n(new char[]{'軛', '赚', '赪'}, 1295479292);
      this.gw = var33;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'䆄', '䆟', '䆽', '䁄', '䁮', '䀈', '䀠'}, 473153195);
      this.gx = var10001;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'꾢', '꿠', '꾜', '僇', '긫', '깤', '긖', '긨', '껇', '껳'}, 900878474);
      this.gy = var10001;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'튪', '틼', '튎', '튼', '텟', '텭', '\u2e78', '텔', '퇙', '퇹', '톛', '톡'}, 1088957854);
      this.gz = var10001;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'ⲷ', 'Ⳬ', 'ⲟ', 'ⲱ', '⭂', '⭧', '⬎'}, 346739603);
      this.ha = var10001;
      this.hb = new SlotEntry("Ｒｉ" + "ｎ" + "ｇ " + "Ｃｏｌｏｒ", "Ｔｈｅｍｅ", "Ｓｋｙ", "Ｗｈｉｔｅ", "Ｐｕｒｐｌｅ", "Ｐｉｎｋ", "Ｒｅｄ", "Ｏｒａｎｇｅ", "Ｇｒｅｅｎ", "Ｃｙａｎ", "Ｔｈｅｍｅ");
      this.hc = new SlotEntry("Ｒｉｎｇ Ｓｔｙｌｅ", "Ｎｅｏｎ", "Ｒｉｎｇ", "Ｇｌｏｗ", "Ｄｏｕｂｌｅ", "Ｎｅｏｎ", "Ｒｉｐｐｌｅ");
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'笡', '筪', '笖', '笤', '篇', '篷', '蓢', '篒', '穃', '穞', '穲', '稘'}, -281181176);
      this.hd = var10001;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'荅', '菅', '菵', '莁', '莹', '艂'}, 1646623862);
      this.he = var10001;
      this.hf = new SlotEntry("Ａｃｃｅｎｔ", "Ｖｉｏｌｅｔ", "Ｖｉｏｌｅｔ", "Ｂｌｕｅ", "Ｃｙａｎ", "Ｇｒｅｅｎ", "Ｒｅｄ", "Ｏｒａｎｇｅ", "Ｐｉｎｋ", "Ｗｈｉｔｅ", "ＲＧＢ");
      BlockCalculator var40 = new BlockCalculator("", 20.0, 100.0, 94.0, 1.0);
      var40.n(new char[]{'鹠', '鹆', '憠', '麰', '黮', '麜', '麿', '鵒', '鵮', '鴀'}, 809394498);
      this.hg = var40;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'汦', '氼', '泜', '泥', '鏱', '泙', '歁', '歨', '欂'}, 1598198613);
      this.hh = var10001;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'뺸', '뻤', '뺞', '뺬', '뵅', '䈇', '뵶', '봪', '뷔', '뷰'}, -392937076);
      this.hi = var10001;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'⭯', '⬫', '⯄', '⯩', '⮀', '⮣', '픥', '⨊', '⨖', '⨯', '⫃', '⫥', '⫭', '⪍'}, -989866933);
      this.hj = var10001;
      BlockCalculator var44 = new BlockCalculator("", 0.4, 1.6, 1.0, 0.05);
      var44.n(new char[]{'\u2d7d', 'ⴧ', '\u2dd7', 'ⷼ', '티', 'ⷜ', 'ⱍ', 'ⱬ', 'Ⰰ', 'Ⱞ'}, 620352084);
      this.hk = var44;
      BlockCalculator var45 = new BlockCalculator("", -1.0, 1.0, 0.0, 0.05);
      var45.n(new char[]{'塚', '兀', '免', '\ufadb', '֕', '\ufaec'}, 1797850425);
      this.hl = var45;
      BlockCalculator var46 = new BlockCalculator("", -1.0, 1.0, 0.0, 0.05);
      var46.n(new char[]{'푍', '퓗', '퓧', '풌', '⯀', '퓆'}, 1819683684);
      this.hm = var46;
      BlockCalculator var47 = new BlockCalculator("", -1.0, 1.0, 0.0, 0.05);
      var47.n(new char[]{'ീ', 'ො', '\u0de2', 'උ', '\uf2c5', 'ా'}, 1945825897);
      this.hn = var47;
      this.ho = new SlotEntry("Ｏｆｆｈａｎｄ", "Ｎｏｒｍａｌ", "Ｎｏｒｍａｌ", "Ｌｏｗｅｒｅｄ", "Ｈｉｄｄｅｎ");
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'큥', '퀯', '탆', '탬', '\u2fe8', '탔', '콑', '콤', '켝'}, -942723252);
      this.hp = var10001;
      this.hq = new SlotEntry(
         "Ｔｏｐ" + " " + "Ｃ" + "ｏｌｏｒ", "Ｖａｎｉｌｌａ", "Ｖａｎｉｌｌａ", "Ｍａｔｃｈ", "Ｎｉｇｈｔ", "Ｐｕｒｐｌｅ", "Ｂｌｕｅ", "Ｃｙａｎ", "Ｇｒｅｅｎ", "Ｒｅｄ", "Ｏｒａｎｇｅ", "Ｐｉｎｋ", "Ｔｈｅｍｅ"
      );
      BlockCalculator var49 = new BlockCalculator("", 1.0, 30.0, 6.0, 0.5);
      var49.n(new char[]{'䗨', '䖳', '䑊', '䑤', '䐂', '뭆', '䒱', '䓭', '䒎', '䒧'}, 1213709003);
      this.hr = var49;
      BlockCalculator var50 = new BlockCalculator("", 0.0, 100.0, 100.0, 1.0);
      var50.n(new char[]{'\uedb1', '\uedf5', '\ued92', '\ued9a', '\uedb0', '\uec5a', '\uec68', '\uec13'}, 1006834306);
      this.hs = var50;
      BlockCalculator var51 = new BlockCalculator("", 0.0, 100.0, 0.0, 1.0);
      var51.n(new char[]{'鞟', '鞟', '鞫', '陛', '陻'}, -1760532308);
      this.ht = var51;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'휸', '흢', '휄', '휽', '⢨', '힄', '힊', '\ud7aa', '홑', '홧', '협'}, 622077964);
      this.hu = var10001;
      this.hv = new SlotEntry("Ｍｏｄｅ", "Ｆｕｌｌ", "Ｆｕｌｌ", "Ｎｉｇｈｔ Ｖｉ" + "ｓ" + "ｉ" + "ｏｎ");
      BlockCalculator var53 = new BlockCalculator("", 10.0, 100.0, 100.0, 5.0);
      var53.n(new char[]{'崫', '嵺', '崎', '崡', '巍', '巰', '嶍', '嶧', '屒', '屳'}, 776446473);
      this.hw = var53;
      this.hx = new SlotEntry("Ｐｅ" + "ａｒ" + "ｌ Ｃｏｌｏｒ", "Ｍａｇｅｎｔａ", "Ｍａｇｅｎｔａ", "Ｐｕｒｐｌｅ", "Ｂｌｕｅ", "Ｃｙａｎ", "Ｇｒｅｅｎ", "Ｏｒａｎｇｅ", "Ｐｉｎｋ", "Ｗｈｉｔｅ");
      BlockCalculator var54 = new BlockCalculator("", 0.5, 3.0, 1.0, 0.1);
      var54.n(new char[]{'鲟', '鲛', '鲿', '魕', '搏', '魹', '鬤', '鯈', '鯿', '鮂'}, 1596613555);
      this.hy = var54;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'곑', 'ꭆ', 'ꭣ', '呭', 'ꭜ', 'ꯙ', '\uabef', 'ꮟ', 'ꮡ', 'ꩂ', 'ꩱ'}, 1416319984);
      this.hz = var10001;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'⨵', '⩡', '⨋', '⨠', '⫕', '햋', '⫸', '⪬', '⥌'}, -1563175664);
      this.ia = var10001;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'冢', '凬', '冂', '冯', '偃', '偧', '倏', '꽇', '傲', '僬', '傉', '傦', '佐'}, -750145906);
      this.ib = var10001;
      this.ic = new SlotEntry("Ｓｔｙｌｅ", "Ｃａｒｄ", "Ｃａｒｄ", "Ｃｌａｓｓｉｃ");
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'糄', '笁', '筯', '笟', '笫', '篎', '篾', '蓩', '篍', '稴', '稖'}, 579961840);
      this.id = var10001;
      this.ie = new SlotEntry("ＥＳＰ Ｍｏｄｅ", ff[0], ff);
      this._kwren_if = new SlotEntry("ＥＳＰ Ｏｎ", fg[0], fg);
      BlockCalculator var59 = new BlockCalculator("", 0.5, 2.0, 1.0, 0.05);
      var59.n(new char[]{'\udcf2', '\udcc5', '\udb25', '␔', '\udb60', '\udb3b', '\udbcb', '\udbf5'}, -673111081);
      this.ig = var59;
      BlockCalculator var60 = new BlockCalculator("", 0.2, 3.0, 1.0, 0.1);
      var60.n(new char[]{'⋆', 'ℱ', 'ℑ', '\ude60', 'Ⅼ', '℮', '⇘', '⇹', '↟'}, -748298781);
      this.ih = var60;
      BlockCalculator var61 = new BlockCalculator("", 0.0, 100.0, 30.0, 1.0);
      var61.n(new char[]{'返', '蹘', '蹼', '踃'}, -295800590);
      this.ii = var61;
      BlockCalculator var62 = new BlockCalculator("", 0.0, 100.0, 60.0, 1.0);
      var62.n(new char[]{'\ue2d4', '\ue15e', '\ue17e', '\ue107'}, 1519590899);
      this.ij = var62;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'旫', '斧', '摃', '摿', '魥', '摃', '擏', '擭', '撖'}, 365468361);
      this.ik = var10001;
      this.il = new SlotEntry("ＥＳＰ " + "Ｃ" + "ｏｌ" + "ｏｒ", fe[0], fe);
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'\uedf7', '\uedfd', '\uec5a', '\uec78', '\uec1e', '\uec2e', 'Ꭾ', '\uec85', '\uec8d', '\uecbf'}, 279778004);
      this.im = var10001;
      this.in = new SlotEntry("Ｈａｔ Ｏｎ", fh[0], fh);
      BlockCalculator var65 = new BlockCalculator("", 0.6, 1.6, 1.0, 0.05);
      var65.n(new char[]{'뽇', '뿏', '뿹', '䃬', '뿘', '빃', '빳', '븍'}, 1491419247);
      this.io = var65;
      BlockCalculator var66 = new BlockCalculator("", 0.1, 0.5, 0.22, 0.01);
      var66.n(new char[]{'쨥', '쩭', '쨟', '㕊', '쪡', '쫭', '쪎', '쪡', '쥍', '쥰'}, -1251134195);
      this.ip = var66;
      this.iq = new SlotEntry("Ｈａｔ Ｃ" + "ｏｌｏｒ", fe[0], fe);
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'딈', '땕', '딨', '뗘', '뗱', '떛', '떥'}, 1626491452);
      this.ir = var10001;
      this.is = new SlotEntry("Ｔ" + "ｒａｉｌ Ｓｔｙｌｅ", fi[0], fi);
      this.it = new SlotEntry("Ｔｒａｉｌ Ｏｎ", fj[0], fj);
      BlockCalculator var68 = new BlockCalculator("", 0.3, 3.0, 1.2, 0.1);
      var68.n(new char[]{'鋝', '酚', '酦', '鄏', '鄩', '溤', '醏', '醇', '醯', '遇', '運', '遶'}, 490302953);
      this.iu = var68;
      BlockCalculator var69 = new BlockCalculator("", 20.0, 100.0, 82.0, 1.0);
      var69.n(new char[]{'◼', '▵', '⑇', '⑬', '␈', '\udb43', '⒪', 'ⓤ', '⒉', '⒘', 'Ⓐ', '⍉'}, -1344152888);
      this.iv = var69;
      BlockCalculator var70 = new BlockCalculator("", 10.0, 100.0, 40.0, 1.0);
      var70.n(
         new char[]{'\uee02', '\uee07', '\uee35', '\ueeda', '\ueefe', 'ᇱ', '\ueedf', '\ued5f', '\ued6f', '\ued0e', '\ued25', '\ueddf', '\uedf3'}, 297603382
      );
      this.iw = var70;
      this.ix = new SlotEntry("Ｔ" + "ｒａｉｌ Ｃｏ" + "ｌ" + "ｏｒ", fe[0], fe);
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'\uf01d', '\uf05a', '\uf03a', '\uf0c6', 'ྑ', '\uf0f5', '\uf0a9', '\uef48', '\uef68', '\uef0f', '\uef3f', '\uefd9'}, -1913254091);
      this.iy = var10001;
      this.iz = new SlotEntry("Ｈｉｔ Ｓｔｙｌｅ", fk[0], fk);
      BlockCalculator var72 = new BlockCalculator("", 4.0, 24.0, 12.0, 1.0);
      var72.n(new char[]{'值', '偺', '倆', '꽑', '傱', '僢', '傁', '傸', '佂', '使'}, 198487828);
      this.ja = var72;
      this.jb = new SlotEntry("Ｈｉｔ Ｃ" + "ｏ" + "ｌ" + "ｏｒ", fe[0], fe);
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'慒', '憊', '懬', '憐', '憭', '恄', '鼿', '怎', '怜', '怮', '惏', '想', '悚', '悴', '归', '彥'}, 1461821029);
      this.jc = var10001;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'Ꝇ', 'ꟑ', '\ua7e1', 'ꞇ', 'Ʝ'}, 415586405);
      this.jd = var10001;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'갫', '걠', '간', '갫', '곝', '곡', '겉', '겡', '吥', '\uab17', '\uab17', 'ꬣ', 'ꯓ', '꯳'}, -818064627);
      this.je = var10001;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'\uf880', '\uf896', '\uf8b1', '\uf755'}, -759167068);
      this.jf = var10001;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'㷡', '㶮', '㱍', '㱚', '㱪', '㰎'}, 964149954);
      this.jg = var10001;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'ᘁ', 'ᘈ', 'ᘲ', 'ᘼ', 'ᛋ', 'ᛴ', 'ᚈ', '\ue9db', 'ᔶ', 'ᕰ', 'ᔖ', 'ᔲ', 'ᗅ'}, -420746974);
      this.jh = var10001;
      BlockCalculator var79 = new BlockCalculator("", 10.0, 200.0, 100.0, 5.0);
      var79.n(new char[]{'\ueb5c', '\uebd2', '\uebf8', '\ueb86', '\uebbd', '\uea47', '\uea6b'}, 1567233144);
      this.ji = var79;
      this.jj = new SlotEntry("Ｐａ" + "ｒｔｉｃｌｅ Ｃｏｌｏｒ", fe[0], fe);
      BlockCalculator var80 = new BlockCalculator("", 0.0, 100.0, 0.0, 1.0);
      var80.n(new char[]{'矘', '癒', '登'}, 1499236606);
      this.jk = var80;
      BlockCalculator var81 = new BlockCalculator("", 0.0, 100.0, 0.0, 1.0);
      var81.n(new char[]{'창', '챦', '찚', '찫', '쳂', '㎅', '쳰', '첪', '쭌', '쭵'}, 316289802);
      this.jl = var81;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'땼', '땹', '뗓', '뗴', '떀', '떻', '䬲', '됔', '됖', '됩', '듋', '듮', '뒘', '뒸'}, 1302481496);
      this.jm = var10001;
      this.jn = new SlotEntry("Ｄｅａｔｈ Ｓｔｙｌｅ", fl[1], fl);
      this.jo = new SlotEntry("Ｄｅａｔｈ Ｏｎ", fm[1], fm);
      this.jp = new SlotEntry("Ｄｅａｔｈ " + "Ｃ" + "ｏｌｏｒ", fe[0], fe);
      BlockCalculator var83 = new BlockCalculator("", 0.5, 2.0, 1.0, 0.05);
      var83.n(new char[]{'ϧ', 'Χ', 'ɀ', 'ɴ', 'ɷ', 'ﵾ', 'Ɏ', '˕', 'ˡ', 'ʟ'}, 1261894851);
      this.jq = var83;
      BlockCalculator var84 = new BlockCalculator("", 0.0, 200.0, 100.0, 5.0);
      var84.n(new char[]{'떨', '뗮', '떈', '떻', '둁', '둴'}, -1805694324);
      this.js = var84;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'ᇖ', 'ၔ', 'ၸ', 'သ', '\uef5a', 'Ⴛ', 'ჷ', '႓', 'Ⴏ'}, -509677826);
      this.jt = var10001;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'㭄', '㯇', '㯡', '㮀', '쓋', '㨹', '㩦', '㨝', '㨩', '㫂'}, 969196655);
      this.ju = var10001;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'勺', '免', '𥳐', '\ufaf5', '\u05f8', '𣏕', '讀', '若', '龜', '碌'}, 49087836);
      this.jv = var10001;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'藇', '葖', '葾', '萗', '筐', '蒫', '蓫', '蒌', '蒸', '荃'}, -1320322316);
      this.jw = var10001;
      BlockCalculator var89 = new BlockCalculator("", 1.0, 8.0, 4.0, 1.0);
      var89.n(new char[]{'\ue931', '\ue97a', '\ue902', 'ᙙ', '\ue9bd', '\ue9f1', '\ue990', '\ue9b0', '\ue857', '\ue867', '\ue801'}, -709618148);
      this.jx = var89;
      this.ln = true;
      this.csRgb = 5943551;
      this.lq = 1.0F;
      this.lr = 1.0F;
      this.ls = 1.6F;
      this.lu = true;
      this.lz = 5943551;
      this.mb = 1;
      this.mc = 5943551;
      this.md = 1.2;
      this.me = 950.0;
      this.mf = 1.5F;
      this.mh = true;
      this.mi = true;
      this.mm = 9203455;
      this.mn = 240;
      this.mo = 0.7F;
      this.mp = 0.68;
      this.mq = 0.12;
      this.mr = 5000.0;
      this.mt = true;
      this.mu = true;
      this.mv = true;
      this.na = 12607743;
      this.nb = 2;
      this.nc = 0.5;
      this.nd = 0.72;
      this.ni = 10120959;
      this.nj = -1;
      this.nk = 1.0F;
      this.nm = 6000.0F;
      this.pr = new ArrayList<>();
      this.ps = new HashMap<>();
      this.pt = new HashSet<>();
      this.pv = new Matrix4f();
      this.pw = new float[16];
      this.qa = 1.0F;
      this.qb = 1.0F;
      this.qf = new Matrix3x2f();
      this.qg = new float[37];
      this.qh = new float[37];
      this.qi = new boolean[37];
      this.qj = new float[37];
      this.qk = new float[37];
      this.ql = new float[37];
      this.qs = new HashMap<>();
      this.qt = new ArrayList<>();
      this.qu = new HashSet<>();
      this.qv = new double[486];
      this.rj = new double[906];
      this.rr = -1L;
      this.sc = new int[16];
      this.sd = new long[16];
      this.se = new int[32];
      this.sf = new int[32];
      this.sg = new long[32];
      this.sh = new EntityStatusS2CPacket[32];
      this.si = 1;
      this.so = new ItemStack[6];
      this.sp = new int[2];
      this.su = -1;
      this.sv = -10000L;
      this.sy = -1L;
      this.tg = new float[8];
      this.ti = new float[8];
      this.tj = new long[8];
      this.tk = new String[8];
      this.tm = 625341585;
      this.tp = new HashMap<>();
      this.ts = true;
      this.tt = true;
      this.tu = true;
      this.tx = 2;
      this.ty = 0;
      this.tz = 95;
      this.ua = 0;
      this.uf = Integer.MIN_VALUE;
      this.um = 1.0F;
      this.ux = -1;
      this.uy = -1;
      this.uz = 134.0F;
      this.ve = -1;
      this.vq = new Identifier[6];
      this.vr = new int[6];
      this.vs = new int[6];
      this.vt = new boolean[6];
      this.vu = new long[6];
      this.vv = new long[6];
      this.vw = new int[64];
      this.vx = new int[128];
      this.vy = new int[128];
      this.vz = new float[128];
      this.wd = new float[3];
      this.we = new float[3];
      this.wg = true;
      this.wx = new int[384];
      this.wy = new float[4];
      this.xo = new LivingEntity[16];
      this.xp = new float[16];
      this.xq = new boolean[16];
      InitAdapter[] var1 = new InitAdapter[]{
         this.fn,
         this.fo,
         this.fp,
         this.fq,
         this.fr,
         this.fs,
         this.ft,
         this.fu,
         this.fv,
         this.fw,
         this.fx,
         this.fy,
         this.fz,
         this.ga,
         this.gb,
         this.gc,
         this.gd,
         this.ge,
         this.gf,
         this.gg,
         this.gh,
         this.gi,
         this.gj,
         this.gk,
         this.gl,
         this.gm,
         this.gn,
         this.go,
         this.gp,
         this.gq,
         this.gr,
         this.gs,
         this.gt,
         this.gu,
         this.gv,
         this.gw,
         this.gx,
         this.gy,
         this.gz,
         this.ha,
         this.hb,
         this.hc,
         this.hd,
         this.he,
         this.hf,
         this.hg,
         this.hh,
         this.hi,
         this.hj,
         this.hk,
         this.hl,
         this.hm,
         this.hn,
         this.ho,
         this.hp,
         this.hq,
         this.hr,
         this.hs,
         this.ht,
         this.hu,
         this.hv,
         this.hw,
         this.hx,
         this.hy,
         this.hz,
         this.ia,
         this.ib,
         this.ic,
         this.id,
         this.ie,
         this._kwren_if,
         this.ig,
         this.ih,
         this.ii,
         this.ij,
         this.ik,
         this.il,
         this.im,
         this.in,
         this.io,
         this.ip,
         this.iq,
         this.ir,
         this.is,
         this.it,
         this.iu,
         this.iv,
         this.iw,
         this.ix,
         this.iy,
         this.iz,
         this.ja,
         this.jb,
         this.jc,
         this.jd,
         this.je,
         this.jf,
         this.jg,
         this.jh,
         this.ji,
         this.jj,
         this.jk,
         this.jl,
         this.jm,
         this.jn,
         this.jo,
         this.jp,
         this.jq,
         this.js,
         this.jt,
         this.ju,
         this.jv,
         this.jw,
         this.jx
      };
      this.a(var1);
      Arrays.fill(this.sd, -2305843009213693952L);
      Arrays.fill(this.sg, -2305843009213693952L);
      this.wk = var1;
      this.wl = new Object[var1.length];

      for (int var2 = 0; var2 < var1.length; var2++) {
         this.wl[var2] = var1[var2].c();
      }

      INSTANCE = this;

      try {
         RegionPassCache.e();
      } catch (Throwable var3) {
      }
   }

   @Override
   public void c() {

      ON = true;
      this.b.a(InitNotifier.class, this);
      if (!this.nt) {
         this.b.a(UtilExtension.class, this);
         this.nt = true;
      }

      this.b.a(CoreSerializer.class, this);
      if (this.nu <= 0.0F) {
         this.f_r30();
      }

      try {
         this.m_r106();
      } catch (Throwable var2) {
      }

      super.c();
   }

   @Override
   public void d() {

      ON = false;

      try {
         RegionPassCache.ON = false;
      } catch (Throwable var2) {
      }

      this.b.b(InitNotifier.class, this);
      this.b.b(CoreSerializer.class, this);
      if (this.nu <= 0.0F) {
         this.b();
      } else {
         LINGER = true;
      }

      HAND_ON = false;
      POPS_ON = false;
      POP_Q.clear();
      DEATH_ON = false;
      DEATH_Q.clear();
      DMG_Q.clear();
      FB_TA = 0.0F;
      FB_TN = 0.0F;
      super.d();
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

   private void b() {

      this.b.b(UtilExtension.class, this);
      this.nt = false;
      this.nv = 0L;
      this.nu = 0.0F;
      LINGER = false;
      this.qd = false;
      this.ub = null;
      this.f_r30();
   }

   private void f_r30() {

      this.pr.clear();
      this.ps.clear();
      this.qs.clear();
      this.qt.clear();
      this.sn = null;
      this.sy = -1L;
      this.rp = null;
      this.rr = -1L;
      this.sz = null;
      this.tn = null;
      this.sq = null;
      this.sr = null;
      this.ub = null;
      this.us = null;
      this.vk = null;
      this.uf = -45286936 ^ 2102196712;
      this.su = -1;
      Arrays.fill(this.tj, 0L);
      this.tp.clear();
      this.qw = 0;
      Arrays.fill(this.sd, -2305843009213693952L);
      Arrays.fill(this.sg, -2305843009213693952L);
      Arrays.fill(this.sh, null);
   }

   public static long ms() {

      return System.nanoTime() / 1000000L;
   }

   public boolean g_r31() {

      return this.gf.f();
   }

   public int h_r32() {

      return this.gg.g();
   }

   public boolean i_r33() {

      return this.nf;
   }

   public boolean j_r34() {

      return this.gl.f();
   }

   private static int k(SlotEntry var0) {

      int var1 = var0.g().indexOf(var0.f());
      return var1 < 0 ? 0 : var1;
   }

   private static int l(SlotEntry var0, int[] var1, int var2) {

      int var3 = var0.g().indexOf(var0.f());
      return var3 >= 0 && var3 < var1.length ? var1[var3] : var2;
   }

   private void m_r106() {

      boolean var1 = ON;
      this.ln = this.fn.f();
      this.lo = k(this.fo);
      this.csRgb = l(this.gt, jy, -1666118479 ^ -1662272434);
      this.lq = this.gu.h();
      this.lr = this.gv.h();
      this.ls = this.gw.h();
      byte var2 = 0;
      if (this.fp.f()) {
         var2 |= 1;
      }

      if (this.gx.f()) {
         var2 |= 2;
      }

      if (this.gy.f()) {
         var2 |= 4;
      }

      if (this.gz.f()) {
         var2 |= 8;
      }

      if (this.ha.f()) {
         var2 |= 16;
      }

      this.lp = var2;
      this.lt = this.fq.f();
      this.lu = k(this.fr) == 0;
      this.mc = l(this.hb, jz, 1643189733 ^ 1638638874);
      this.lz = n(this.mc);
      this.lv = this.fw.f();
      this.ma = k(this.hc);
      this.md = this.ft.p();
      this.mf = this.fu.h();
      this.mb = Math.max(1, this.fv.g());
      this.me = 950.0 / Math.max(0.1, this.fs.p());
      this.lw = this.fx.f();
      this.lx = this.hd.f();
      this.ly = this.he.f();
      this.mg = this.fy.f();
      this.mp = this.fz.p() / 100.0;
      this.mq = this.ga.p() / 100.0;
      this.mr = this.gb.p() * 1000.0;
      this.mo = this.gc.h();
      this.mh = this.gd.f();
      this.mi = this.ge.f();
      this.mm = l(this.hf, ka, -1100242393 ^ -1092105000);
      this.mn = MathHelper.clamp((int)Math.round(this.hg.p() * 2.55), 0, 325312200 ^ 325312055);
      this.mj = this.hh.f();
      this.mk = this.hi.f();
      this.ml = this.hj.f();
      this.ts = this.q();
      this.r(CoreZoneProcessor.I);
      POPS_ON = var1 && this.mg && this.mk;
      float var3 = this.hk.h();
      float var4 = this.hl.h();
      float var5 = this.hm.h();
      float var6 = this.hn.h();
      boolean var7 = this.hp.f();
      int var8 = k(this.ho);
      boolean var9 = Math.abs(var3 - 1.0F) > 0.001F || Math.abs(var4) > 0.001F || Math.abs(var5) > 0.001F || Math.abs(var6) > 0.001F || var7 || var8 != 0;
      boolean var10 = var1 && this.gf.f() && var9;
      float[] var11 = HAND;
      var11[1] = var3;
      var11[2] = var4;
      var11[3] = var5;
      var11[4] = var6;
      var11[5] = var7 ? 1.0F : 0.0F;
      var11[6] = (float)var8;
      var11[0] = var10 ? 1.0F : 0.0F;
      HAND_ON = var10;
      this.ne = this.gh.f();
      this.nf = k(this.gi) == 1;
      this.ng = this.gk.f();
      this.ni = n(l(this.gj, kb, 127166741 ^ 118360042));
      this.nj = n(l(this.hq, kc, -1));
      this.nk = (float)(this.hs.p() / 100.0);
      this.nl = (float)(this.ht.p() / 100.0);
      this.nm = (float)Math.max(100.0, this.hr.p() * 1000.0);
      this.nh = this.hu.f();
      this.nn = (float)(this.jk.p() / 100.0);
      this.no = (float)(this.jl.p() / 100.0);
      if (var1 && this.ne && this.nk > 0.002F) {
         SKY_HOT = true;
         if (this.nn > 0.0F) {
            FOG_HOT = true;
         }

         if (this.no > 0.0F) {
            TINT_HOT = true;
         }
      }

      boolean var12 = var1 && this.gl.f();
      float var13 = (float)(this.hw.p() / 100.0);
      boolean var14 = k(this.hv) == 1;
      FB_TA = var12 && !var14 ? var13 : 0.0F;
      FB_TN = var12 && var14 ? var13 : 0.0F;
      if (var12) {
         FB_HOT = true;
      }

      this.ms = this.gm.f();
      this.mt = this.gn.f();
      this.mu = this.go.f();
      this.mv = this.gp.f();
      this.mw = this.gq.f();
      this.na = l(this.hx, ke, 1694193621 ^ 1681602346);
      this.nb = Math.max(1, Math.round(2.0F * this.hy.h()));
      this.mx = this.hz.f();
      this.my = this.ia.f();
      this.mz = this.ib.f();
      this.nc = this.gr.p() / 100.0;
      this.nd = this.gs.p() / 100.0;
      boolean var15 = var1 && this.id.f();
      boolean var16 = var1 && this.im.f();
      boolean var17 = var1 && this.ir.f();
      boolean var18 = var1 && this.iy.f();
      boolean var19 = var1 && this.jc.f();
      RegionPassCache.ah = var15;
      RegionPassCache.aj = k(this.ie);
      RegionPassCache.ak = k(this._kwren_if);
      RegionPassCache.am = this.ig.h();
      RegionPassCache.an = this.ih.h();
      RegionPassCache.ao = (float)(this.ii.p() / 100.0);
      RegionPassCache.ap = (float)(this.ij.p() / 100.0);
      RegionPassCache.ai = this.ik.f();
      RegionPassCache.al = l(this.il, kd, -3);
      RegionPassCache.aq = var15 ? this.rp : null;
      RegionPassCache.ar = var16;
      RegionPassCache.as = k(this.in);
      RegionPassCache.au = this.io.h();
      RegionPassCache.av = this.ip.h();
      RegionPassCache.at = l(this.iq, kd, -3);
      RegionPassCache.aw = var17;
      RegionPassCache.ax = k(this.is);
      RegionPassCache.ay = k(this.it);
      RegionPassCache.ba = this.iu.h();
      RegionPassCache.bb = (float)(this.iv.p() / 100.0);
      RegionPassCache.bc = (float)(this.iw.p() / 100.0);
      RegionPassCache.az = l(this.ix, kd, -3);
      RegionPassCache.bd = var18;
      RegionPassCache.be = k(this.iz);
      RegionPassCache.bf = this.ja.g();
      RegionPassCache.bg = l(this.jb, kd, -3);
      RegionPassCache.bh = var19;
      RegionPassCache.bi = this.jd.f();
      RegionPassCache.bj = this.je.f();
      RegionPassCache.bk = this.jf.f();
      RegionPassCache.bl = this.jg.f();
      RegionPassCache.bm = this.jh.f();
      RegionPassCache.bn = (float)(this.ji.p() / 100.0);
      RegionPassCache.bo = l(this.jj, kd, -3);
      RegionPassCache.bw = this.ma;
      RegionPassCache.bx = this.mb;
      RegionPassCache.by = this.mc;
      RegionPassCache.bz = (float)this.me;
      RegionPassCache.ca = (float)this.md;
      RegionPassCache.cb = this.mf;
      RegionPassCache.cc = this.lw;
      RegionPassCache.cd = this.lx;
      RegionPassCache.rsRgb = this.lv;
      boolean var20 = var1 && this.jm.f() && this.sm < 30;
      int var21 = k(this.jn);
      int var22 = l(this.jp, kd, -3);
      int var23 = Math.max(1, Math.min(8, this.jx.g()));
      float var24 = this.jq.h();
      float var25 = (float)(this.js.p() / 100.0);
      boolean var26 = this.jt.f();
      boolean var27 = this.ju.f();
      boolean var28 = this.jv.f();
      boolean var29 = this.jw.f();
      this.si = k(this.jo);
      this.sj = var29;

      try {
         EchoPassCache.on = var20;
         EchoPassCache.ae = var21;
         EchoPassCache.pal = var22;
         EchoPassCache.af = var24;
         EchoPassCache.ag = var25;
         EchoPassCache.aa = var26;
         EchoPassCache.ab = var27;
         EchoPassCache.ac = var28;
         EchoPassCache.ad = var29;
         EchoPassCache.max = var23;
         DEATH_ON = var20;
      } catch (Throwable var31) {
         this.sm++;
         DEATH_ON = false;
         var20 = false;
      }

      RegionPassCache.ON = var1 && (var15 || var16 || var17 || var18 || var19 || this.lt && this.ma >= 3 || this.ne && this.no > 0.0F || var20);
   }

   private static int n(int var0) {

      return var0 == -3 ? RegionPassCache.i() : var0;
   }

   private static int o(int var0) {

      if (var0 >= 0) {
         return var0;
      } else if (var0 == -1) {
         return dq((float)(ms() % 4000L) / 4000.0F, 0.85F, 1.0F);
      } else {
         int var1 = RegionPassCache.i();
         return var0 == -4 ? RegionPassCache.ag : var1;
      }
   }

   private int p() {

      return this.mm == -1 ? dq((float)(ms() % 3000L) / 3000.0F, 0.75F, 1.0F) : this.mm;
   }

   private boolean q() {

      String var1 = this.ic.f();
      if (var1 != this.tv) {
         this.tv = var1;
         this.tt = k(this.ic) == 0;
      }

      return this.tt;
   }

   private void r(CoreZoneProcessor var1) {

      if (var1 == null) {
         this.tx = 2;
         this.ty = 0;
         this.tz = 95;
         this.tu = true;
      } else {
         this.tu = var1.o.f();
         this.tx = Math.max(1, Math.min(3, (int)Math.round(var1.bt.p())));
         String var2 = var1.ci.f();
         if (var2 != this.tw) {
            this.tw = var2;
            int var3 = var1.ci.g().indexOf(var2);
            this.ua = var3 < 0 ? 0 : var3;
         }

         this.ty = this.ua;
         this.tz = (int)Math.round(var1.cj.p());
      }
   }

   private int s() {

      return this.mw ? dq((float)(ms() % 2600L) / 2600.0F, 0.85F, 1.0F) : this.na;
   }

   public void t(float[] var1) {

      if (var1 != null && var1.length >= 8) {
         var1[0] = Float.intBitsToFloat(this.s() & (-200442266 ^ -185433703));
         var1[1] = (float)this.nb;
         var1[2] = this.oo;
         var1[3] = this.op;
         var1[4] = this.oq;
         var1[5] = this.os;
         var1[6] = this.my ? 1.0F : 0.0F;
         var1[7] = 0.0F;
      }
   }

   public NodeZoneRenderer.Vis[] u() {

      NodeZoneRenderer.Vis[] var1 = this.wi;
      if (var1 == null) {
         this.wj = new NodeZoneRenderer.Vis[]{
            new NodeZoneRenderer.Vis(this.fy, new InitAdapter[]{this.ic, this.gb, this.gd, this.ge, this.hh, this.hi, this.hj}),
            new NodeZoneRenderer.Vis(this.fy, new InitAdapter[]{this.ic, this.gc, this.gb, this.hf, this.hg, this.gd, this.ge, this.hh, this.hi, this.hj})
         };
         var1 = new NodeZoneRenderer.Vis[]{
            new NodeZoneRenderer.Vis(this.fn, new InitAdapter[]{this.fo, this.gt, this.fp, this.gu, this.gv, this.gw, this.gx, this.gy, this.gz, this.ha}),
            new NodeZoneRenderer.Vis(
               this.fq, new InitAdapter[]{this.fr, this.hb, this.fw, this.hc, this.fs, this.ft, this.fu, this.fv, this.fx, this.hd, this.he}
            ),
            this.wj[1],
            new NodeZoneRenderer.Vis(this.gf, new InitAdapter[]{this.gg, this.hk, this.hl, this.hm, this.hn, this.ho, this.hp}),
            new NodeZoneRenderer.Vis(this.gh, new InitAdapter[]{this.gi, this.gj, this.hq, this.gk, this.hr, this.hs, this.ht, this.hu, this.jk, this.jl}),
            new NodeZoneRenderer.Vis(this.gl, new InitAdapter[]{this.hv, this.hw}),
            new NodeZoneRenderer.Vis(this.gm, new InitAdapter[]{this.gn, this.go, this.ib, this.gp, this.hx, this.gq, this.hy, this.hz, this.ia}),
            new NodeZoneRenderer.Vis(this.id, new InitAdapter[]{this.ie, this._kwren_if, this.il, this.ig, this.ih, this.ii, this.ij, this.ik}),
            new NodeZoneRenderer.Vis(this.im, new InitAdapter[]{this.in, this.iq, this.io, this.ip}),
            new NodeZoneRenderer.Vis(this.ir, new InitAdapter[]{this.is, this.it, this.ix, this.iu, this.iv, this.iw}),
            new NodeZoneRenderer.Vis(this.iy, new InitAdapter[]{this.iz, this.jb, this.ja}),
            new NodeZoneRenderer.Vis(this.jc, new InitAdapter[]{this.jj, this.ji, this.jd, this.je, this.jf, this.jg, this.jh}),
            new NodeZoneRenderer.Vis(this.jm, new InitAdapter[]{this.jn, this.jo, this.jp, this.jq, this.js, this.jt, this.ju, this.jv, this.jw, this.jx})
         };
         this.wi = var1;
      }

      var1[2] = this.wj[this.q() ? 0 : 1];
      return var1;
   }

   public int v(InitAdapter var1) {

      SlotEntry var2 = var1 == this.il
         ? this.il
         : (
            var1 == this.iq
               ? this.iq
               : (var1 == this.ix ? this.ix : (var1 == this.jb ? this.jb : (var1 == this.jj ? this.jj : (var1 == this.jp ? this.jp : null))))
         );

      try {
         if (var1 == this.gt) {
            return l(this.gt, jy, -1);
         }

         if (var1 == this.hb) {
            return n(l(this.hb, jz, -1));
         }

         if (var1 == this.hf) {
            int var5 = l(this.hf, ka, 765457317 ^ 756260186);
            return var5 == -1 ? dq((float)(ms() % 3000L) / 3000.0F, 0.75F, 1.0F) : var5;
         }

         if (var1 == this.gj) {
            return n(l(this.gj, kb, -1));
         }

         if (var1 == this.hq) {
            int var3 = l(this.hq, kc, -1);
            return n(var3 == -2 ? l(this.gj, kb, -1) : var3);
         }

         if (var1 == this.hx) {
            return l(this.hx, ke, -1);
         }

         if (var2 != null) {
            return o(l(var2, kd, -3));
         }
      } catch (Throwable var4) {
      }

      return -1;
   }

   public boolean w(int var1) {

      return var1 == 2 || var1 == 6;
   }

   public double x(int var1) {

      return var1 == 6 ? this.gr.f() : this.fz.f() / 100.0;
   }

   public double y(int var1) {

      return var1 == 6 ? this.gs.f() : this.ga.f() / 100.0;
   }

   public void z(int var1, double var2, double var4) {

      double var6 = dz(var2) * 100.0;
      double var8 = dz(var4) * 100.0;
      if (var1 == 6) {
         this.gr.a(var6);
         this.gs.a(var8);
      } else {
         this.fz.a(var6);
         this.ga.a(var8);
      }
   }

   public int[] aa(int var1) {

      ClientPlayerEntity var2 = a.player;

      try {
         if (var1 == 6) {
            byte var8 = 9;
            int var11 = 26 + lm[cw(ku[9], 1.0F)] + 5;
            int var12 = 5 + Math.max(16, var8) + 3 + 3 + 5;
            return new int[]{var11 / 2 + 2, var12 / 2 + 2};
         } else if (this.q()) {
            float var7 = this.vi;
            if (!(var7 > 0.0F)) {
               double var9 = (double)a.getWindow().getScaleFactor();
               var7 = (float)((double)this.tx / (var9 > 0.0 ? var9 : 1.0));
            }

            float var10 = this.vj > 0.0F ? this.vj : 134.0F;
            return new int[]{(int)Math.ceil((double)(var10 * var7 * 0.5F)) + 2, (int)Math.ceil((double)(21.0F * var7)) + 2};
         } else {
            float var3 = this.mo;
            String var4 = var2 != null ? var2.getName().getString() : ku[8];
            int[] var5 = this.cz(var4, this.ct(var2), this.mk ? 1.0F : 0.0F, 2, this.mh ? 1.0F : 0.0F);
            return new int[]{Math.round((float)var5[0] * var3) / 2 + 2, Math.round((float)var5[1] * var3) / 2 + 2};
         }
      } catch (Throwable var6) {
         return new int[]{62, 27};
      }
   }

   public void ab(int var1) {

      NodeZoneRenderer.Vis[] var2 = this.u();
      if (var1 >= 0 && var1 < var2.length) {
         InitAdapter[] var3 = var1 == 2 && this.wj != null ? this.wj[1].c : var2[var1].c;

         for (InitAdapter var7 : var3) {
            this.ac(var7);
         }

         if (var1 == 2) {
            this.ac(this.fz);
            this.ac(this.ga);
         } else if (var1 == 6) {
            this.ac(this.gr);
            this.ac(this.gs);
         }

         try {
            this.m_r106();
         } catch (Throwable var8) {
         }
      }
   }

   private void ac(InitAdapter var1) {

      InitAdapter[] var2 = this.wk;
      Object[] var3 = this.wl;
      if (var2 != null && var3 != null) {
         for (int var4 = 0; var4 < var2.length; var4++) {
            if (var2[var4] == var1) {
               if (var3[var4] != null) {
                  var1.a(var3[var4]);
               }

               return;
            }
         }
      }
   }

   public boolean ad(int var1) {

      return var1 >= 0 && var1 <= 12;
   }

   public void ae(int var1, DrawContext var2, int var3, int var4, int var5, int var6) {

      long var7 = System.nanoTime();
      float var9 = this.wm == 0L ? 0.0F : (float)(var7 - this.wm) / 1.0E9F;
      this.wm = var7;
      var9 = var9 < 0.0F ? 0.0F : (var9 > 0.1F ? 0.1F : var9);
      boolean var10 = false;
      Matrix3x2fStack var11 = var2.getMatrices();

      try {
         float var12 = var11.m00;
         float var13 = var11.m11;
         float var14 = var11.m20;
         float var15 = var11.m21;
         if (var11.m01 == 0.0F && var11.m10 == 0.0F && var12 > 0.0F && var13 > 0.0F) {
            float var16 = var12 * (float)var3 + var14;
            float var17 = var13 * (float)var4 + var15;
            float var18 = var12 * (float)(var3 + var5) + var14;
            float var19 = var13 * (float)(var4 + var6) + var15;
            int var20 = (int)Math.floor((double)(var16 + 0.001F));
            int var21 = (int)Math.floor((double)(var17 + 0.001F));
            int var22 = (int)Math.ceil((double)(var18 - 0.001F));
            int var23 = (int)Math.ceil((double)(var19 - 0.001F));
            if ((float)var20 < var16 - var12 - 0.001F) {
               var20++;
            }

            if ((float)var21 < var17 - var13 - 0.001F) {
               var21++;
            }

            if ((float)var22 > var18 + var12 + 0.001F) {
               var22--;
            }

            if ((float)var23 > var19 + var13 + 0.001F) {
               var23--;
            }

            var11.pushMatrix();

            try {
               var11.identity();
               var2.enableScissor(var20, var21, Math.max(var20, var22), Math.max(var21, var23));
               var10 = true;
            } finally {
               var11.popMatrix();
            }
         } else {
            var2.enableScissor(var3, var4, var3 + var5, var4 + var6);
            var10 = true;
         }

         if (var1 == 0) {
            this.ag(var2, var3, var4, var5, var6, var9);
         } else if (var1 == 1) {
            this.ai(var2, var3, var4, var5, var6);
         } else if (var1 == 3) {
            this.al(var2, var3, var4, var5, var6);
         } else if (var1 == 4) {
            this.am(var2, var3, var4, var5, var6);
         } else if (var1 == 5) {
            this.an(var2, var3, var4, var5, var6);
         } else if (var1 == 6) {
            this.ao(var2, var3, var4, var5, var6, var9);
         } else if (var1 == 2) {
            this.az(var2, var3, var4, var5, var6);
         } else if (var1 == 7) {
            this.bc(var2, var3, var4, var5, var6);
         } else if (var1 == 8) {
            this.bf(var2, var3, var4, var5, var6);
         } else if (var1 == 9) {
            this.bg(var2, var3, var4, var5, var6);
         } else if (var1 == 10) {
            this.bh(var2, var3, var4, var5, var6);
         } else if (var1 == 11) {
            this.bi(var2, var3, var4, var5, var6);
         } else if (var1 == 12) {
            this.bj(var2, var3, var4, var5, var6);
         }
      } catch (Throwable var33) {
      } finally {
         if (var10) {
            var2.disableScissor();
         }
      }
   }

   private static void af(DrawContext var0, int var1, int var2, int var3, int var4, int var5, int var6) {

      for (int var7 = 0; var7 < 10; var7++) {
         int var8 = var2 + var4 * var7 / 10;
         int var9 = var2 + var4 * (var7 + 1) / 10;
         if (var9 > var8) {
            var0.fill(var1, var8, var1 + var3, var9, 719420777 ^ -706642583 | dn(var5, var6, ((float)var7 + 0.5F) / 10.0F));
         }
      }
   }

   private void ag(DrawContext var1, int var2, int var3, int var4, int var5, float var6) {

      af(var1, var2, var3, var4, var5, 803262823 ^ 801958199, 576089189 ^ 576224895);
      long var7 = ms();
      long var9 = var7 % 3600L;
      float var11 = this.gu.h();
      float var12 = this.gv.h();
      int var13 = this.fp.f() ? dq((float)(var7 % 3000L) / 3000.0F, 0.85F, 1.0F) : l(this.gt, jy, -1927642560 ^ -1925172545);
      float var14 = 1.0F - (float)Math.exp(-14.0 * (double)var6);
      boolean var15 = var9 >= 1900L && var9 < 3100L;
      float var16 = this.gz.f() && var15 ? 1.0F : 0.0F;
      this.wo = this.wo + (var16 - this.wo) * var14;
      float var17 = this.ha.f() && var15 ? 3.0F * var11 : 0.0F;
      this.wn = this.wn + (var17 - this.wn) * var14;
      float var18 = 1.0F;
      if (a.options != null && a.options.getAttackIndicator().getValue() == AttackIndicator.CROSSHAIR && var9 >= 700L && var9 < 1500L) {
         var18 = (float)(var9 - 700L) / 800.0F;
      }

      this.wp = var18 < 1.0F ? 1.0F : Math.max(0.0F, this.wp - var6 / 0.18F);
      long var19 = this.gy.f() ? var9 - 700L : -1L;
      Matrix3x2fStack var21 = var1.getMatrices();
      float var22 = (float)Math.sqrt((double)(var21.m00 * var21.m00 + var21.m01 * var21.m01));
      double var23 = a.getWindow() != null ? (double)a.getWindow().getScaleFactor() : 1.0;
      float var25 = var22 * (float)(var23 <= 0.0 ? 1.0 : var23);
      if (!(var25 < 0.05F)) {
         var21.pushMatrix();

         try {
            var21.translate((float)var2 + (float)var4 * 0.5F, (float)var3 + (float)var5 * 0.5F);
            var21.scale(1.0F / var25, 1.0F / var25);
            ah(var1, k(this.fo), this.gx.f(), var11, var12, this.gw.h(), var13, this.wo, this.wn, var18, this.wp, var19);
         } finally {
            var21.popMatrix();
         }
      }
   }

   private static void ah(
      DrawContext var0, int var1, boolean var2, float var3, float var4, float var5, int var6, float var7, float var8, float var9, float var10, long var11
   ) {

      float var13 = (float)(var6 >> 16 & (-1795429592 ^ -1795429417));
      float var14 = (float)(var6 >> 8 & (-320951587 ^ -320951774));
      float var15 = (float)(var6 & (961387633 ^ 961387662));
      if (var7 > 0.001F) {
         var13 += (255.0F - var13) * var7;
         var14 += (59.0F - var14) * var7;
         var15 += (59.0F - var15) * var7;
      }

      float var16 = var10 * var10 * (3.0F - 2.0F * var10);
      boolean var17 = var16 > 0.001F;
      boolean var18 = var11 >= 0L && var11 < 260L;
      float var19 = var18 ? (float)var11 / 260.0F : 1.0F;
      float var20 = 1.0F - var19;
      float var21 = var18 ? var20 * var20 : 0.0F;
      float var22 = 1.0F - var20 * var20 * var20;
      float var23 = 3.0F * var3 + var8 + 1.5F * var3 * var22;
      float var24 = var23 + 4.2F * var3;
      float var25 = 0.55F * var3 + 0.35F;
      float var26 = Math.min(1.0F, 1.9F * var21);
      float var27 = 0.0F;
      float var28 = 0.0F;
      float var29 = 1.0F;
      float var30 = 0.0F;
      float var31 = 0.0F;
      float var32 = 0.0F;
      float var33 = 0.0F;
      float var34 = 0.0F;
      float var35;
      float var36;
      if (var1 == 1) {
         var31 = Math.max(0.0F, var5 * var3 + var8);
         var32 = var31 + 3.9F * var3;
         var33 = 0.9F * var4 * var3;
         var34 = 2.0F * var3;
         var36 = Math.max(var32 + 1.5F, Math.max(var34 + 0.5F, var33 + 1.5F));
         var35 = var32 + 1.5F * var3 + 2.5F * var3;
      } else if (var1 == 2) {
         var30 = 1.8F * var3 * (float)Math.sqrt((double)var4);
         var29 = 2.4F * var3;
         var36 = var30 + Math.max(1.5F, var29);
         var35 = var30 + 2.0F * var3 + 2.5F * var3;
      } else {
         var27 = Math.max(1.0F, 5.5F * var3 + var8);
         var28 = 0.9F * var4 * var3;
         var29 = 3.0F * var3;
         var30 = 1.4F * var3 * (0.6F + 0.4F * var4);
         var36 = var27 + Math.max(var28 + 1.5F, var29);
         var35 = var27 + var28 + 2.5F * var3;
      }

      float var37 = 0.8F * var3;
      float var38 = var36;
      if (var18) {
         var38 = Math.max(var36, var24 + 0.5F);
      }

      if (var17) {
         var38 = Math.max(var38, var35 + var37 + 0.5F);
      }

      int var39 = (int)Math.ceil((double)(var38 + 2.0F));
      float var40;
      if (var1 == 1) {
         float var41 = var32 + 1.6F;
         float var42 = Math.max(var33, var34) + 1.6F;
         var40 = (float)Math.sqrt((double)(var41 * var41 + var42 * var42));
      } else {
         var40 = var36 + 1.0F;
      }

      if (var18 && var24 + 1.0F > var40) {
         var40 = var24 + 1.0F;
      }

      if (var17 && var35 + var37 + 1.0F > var40) {
         var40 = var35 + var37 + 1.0F;
      }

      float var88 = var40 * var40;
      float var89 = var33 + 0.5F;
      float var43 = var33 + 1.5F;
      float var44 = var31 - 0.5F;
      float var45 = var31 - 1.5F;
      float var46 = var32 + 0.5F;
      float var47 = var32 + 1.5F;
      float var48 = var32 + 1.3F;
      float var49 = var34 + 0.5F;
      float var50 = var30 + 0.5F;
      float var51 = var30 + 1.5F;
      float var52 = var28 + 0.5F;
      float var53 = var28 + 1.5F;
      float var54 = var29 > 1.0E-4F ? 1.0F / var29 : 0.0F;
      float var55 = var37 + 0.5F;
      float var56 = var37 + 1.0F;
      float var57 = (float) (Math.PI * 2) * var35;
      float var58 = var23 - 0.5F;
      float var59 = var24 + 0.5F;
      float var60 = var25 + 0.5F;

      for (int var61 = -var39; var61 <= var39; var61++) {
         float var62 = (float)var61;
         float var63 = var62 * var62;
         float var64 = var88 - var63;
         if (!(var64 <= 0.0F)) {
            int var65 = (int)Math.sqrt((double)var64) + 1;
            if (var65 > var39) {
               var65 = var39;
            }

            int var66 = -var65;
            int var67 = 0;
            float var68 = Math.abs(var62);

            for (int var69 = -var65; var69 <= var65; var69++) {
               float var70 = (float)var69;
               float var71 = Math.abs(var70);
               float var72 = (float)Math.sqrt((double)(var70 * var70 + var63));
               float var74 = 0.0F;
               float var75 = 0.0F;
               float var73;
               if (var1 == 1) {
                  float var76 = Math.min(1.0F, Math.max(0.0F, var89 - var68))
                     * Math.min(1.0F, Math.max(0.0F, var71 - var44))
                     * Math.min(1.0F, Math.max(0.0F, var46 - var71));
                  float var77 = Math.min(1.0F, Math.max(0.0F, var89 - var71))
                     * Math.min(1.0F, Math.max(0.0F, var68 - var44))
                     * Math.min(1.0F, Math.max(0.0F, var46 - var68));
                  var73 = Math.max(var76, var77);
                  if (var2) {
                     float var78 = Math.min(1.0F, Math.max(0.0F, var43 - var68))
                        * Math.min(1.0F, Math.max(0.0F, var71 - var45))
                        * Math.min(1.0F, Math.max(0.0F, var47 - var71));
                     float var79 = Math.min(1.0F, Math.max(0.0F, var43 - var71))
                        * Math.min(1.0F, Math.max(0.0F, var68 - var45))
                        * Math.min(1.0F, Math.max(0.0F, var47 - var68));
                     var75 = Math.max(var78, var79) * 0.85F;
                  } else {
                     float var93 = Math.min(1.0F, Math.max(0.0F, var49 - var68))
                        * Math.min(1.0F, Math.max(0.0F, var71 - var44))
                        * Math.min(1.0F, Math.max(0.0F, var48 - var71));
                     float var95 = Math.min(1.0F, Math.max(0.0F, var49 - var71))
                        * Math.min(1.0F, Math.max(0.0F, var68 - var44))
                        * Math.min(1.0F, Math.max(0.0F, var48 - var68));
                     var74 = Math.max(var93, var95) * 0.28F;
                  }
               } else if (var1 == 2) {
                  var73 = Math.min(1.0F, Math.max(0.0F, var50 - var72));
                  if (var2) {
                     var75 = Math.min(1.0F, Math.max(0.0F, var51 - var72)) * 0.85F;
                  } else {
                     var74 = Math.min(1.0F, Math.max(0.0F, 1.0F - (var72 - var30) * var54)) * 0.3F;
                  }
               } else {
                  float var90 = Math.abs(var72 - var27);
                  var73 = Math.max(Math.min(1.0F, Math.max(0.0F, var52 - var90)), Math.min(1.0F, Math.max(0.0F, var50 - var72)));
                  if (var2) {
                     var75 = Math.max(Math.min(1.0F, Math.max(0.0F, var53 - var90)), Math.min(1.0F, Math.max(0.0F, var51 - var72))) * 0.85F;
                  } else {
                     var74 = Math.min(1.0F, Math.max(0.0F, 1.0F - var90 * var54)) * 0.3F;
                  }
               }

               float var91 = 0.0F;
               float var92 = 0.0F;
               float var94 = 0.0F;
               float var96 = 0.0F;
               if (var74 > 0.0F) {
                  var92 = var13 * var74;
                  var94 = var14 * var74;
                  var96 = var15 * var74;
                  var91 = var74;
               }

               if (var75 > 0.0F) {
                  float var80 = 1.0F - var75;
                  var92 *= var80;
                  var94 *= var80;
                  var96 *= var80;
                  var91 = var75 + var91 * var80;
               }

               if (var73 > 0.0F) {
                  float var97 = 1.0F - var73;
                  var92 = var13 * var73 + var92 * var97;
                  var94 = var14 * var73 + var94 * var97;
                  var96 = var15 * var73 + var96 * var97;
                  var91 = var73 + var91 * var97;
               }

               if (var17) {
                  float var98 = Math.abs(var72 - var35);
                  if (var98 < var56) {
                     float var81 = Math.min(1.0F, Math.max(0.0F, var55 - var98));
                     if (var81 > 0.0F) {
                        double var82 = Math.atan2((double)var70, (double)(-var62));
                        if (var82 < 0.0) {
                           var82 += Math.PI * 2;
                        }

                        float var84 = (float)(var82 / (Math.PI * 2));
                        float var85 = Math.min(1.0F, Math.max(0.0F, (var9 - var84) * var57 + 0.5F));
                        float var86 = var81 * (0.25F + 0.65F * var85) * var16;
                        float var87 = 1.0F - var86;
                        var92 = 255.0F * var86 + var92 * var87;
                        var94 = 255.0F * var86 + var94 * var87;
                        var96 = 255.0F * var86 + var96 * var87;
                        var91 = var86 + var91 * var87;
                     }
                  }
               }

               if (var18) {
                  float var99 = Math.min(Math.abs(var70 - var62), Math.abs(var70 + var62)) * 0.70710677F;
                  float var101 = Math.min(1.0F, Math.max(0.0F, var60 - var99))
                     * Math.min(1.0F, Math.max(0.0F, var72 - var58))
                     * Math.min(1.0F, Math.max(0.0F, var59 - var72))
                     * var26;
                  if (var101 > 0.0F) {
                     float var103 = 1.0F - var101;
                     var92 = 255.0F * var101 + var92 * var103;
                     var94 = 255.0F * var101 + var94 * var103;
                     var96 = 255.0F * var101 + var96 * var103;
                     var91 = var101 + var91 * var103;
                  }
               }

               int var100 = 0;
               if (var91 > 0.004F) {
                  int var102 = Math.round(var91 * 63.75F) << 2;
                  if (var102 > (-1544885493 ^ -1544885260)) {
                     var102 = -898428026 ^ -898428039;
                  }

                  if (var102 > 0) {
                     float var104 = 1.0F / var91;
                     int var83 = Math.min(1665292919 ^ 1665292936, Math.round(var92 * var104));
                     int var105 = Math.min(153351780 ^ 153351835, Math.round(var94 * var104));
                     int var106 = Math.min(483164818 ^ 483164781, Math.round(var96 * var104));
                     var100 = var102 << 24 | var83 << 16 | var105 << 8 | var106;
                  }
               }

               if (var100 != var67) {
                  if (var67 != 0) {
                     var0.fill(var66, var61, var69, var61 + 1, var67);
                  }

                  var66 = var69;
                  var67 = var100;
               }
            }

            if (var67 != 0) {
               var0.fill(var66, var61, var65 + 1, var61 + 1, var67);
            }
         }
      }
   }

   private void ai(DrawContext var1, int var2, int var3, int var4, int var5) {

      af(var1, var2, var3, var4, var5, -632188303 ^ -632310203, -169997770 ^ -170654172);
      double var6 = (double)System.nanoTime() / 1000000.0;
      long var8 = (long)var6;
      int var10 = k(this.hc);
      int var11 = Math.max(1, this.fv.g());
      double var12 = 950.0 / Math.max(0.1, this.fs.f());
      double var14 = this.ft.f();
      float var16 = this.fu.h() * 0.5F;
      int var17 = Math.max(1, Math.round(var16));
      int var18 = (this.fw.f() ? dq((float)(var8 % 2400L) / 2400.0F, 0.85F, 1.0F) : n(l(this.hb, jz, -1023901660 ^ -1029558053))) & (271544954 ^ 282103173);
      int var19 = Math.min(-1807959189 ^ -1807959148, (var18 >> 16 & (1376767886 ^ 1376767857)) + 40) << 16
         | Math.min(-541186743 ^ -541186634, (var18 >> 8 & (-1824026563 ^ -1824026430)) + 40) << 8
         | Math.min(1767398378 ^ 1767398165, (var18 & (2007527788 ^ 2007527827)) + 40);
      float var20 = (float)var2 + (float)var4 * 0.5F;
      float var21 = (float)var3 + (float)var5 * 0.56F;
      boolean var22 = var10 >= 3 && RegionPassCache.f();
      if (var10 >= 3 && !var22) {
         var10 = 0;
      }

      float var23 = var22 ? 0.42F : 0.34F;
      float var24 = Math.min(((float)var4 * 0.5F - 8.0F) / 3.2F, ((float)var5 * 0.44F - 2.0F) / (3.2F * var23));
      long var25 = (long)(var12 + (double)((long)(var11 - 1) * 130L) + 700.0);
      double var27 = var6 % (double)var25;
      dt(var1, Math.round(var20 - 7.0F), Math.round(var21 - 2.0F), 14, 4, 2, 2106919905 ^ 227871713);
      if (var22) {
         this.aj(var1, var20, var21, var24, (float)var14, (float)var12, var11, var18, var10 == 4, var27);
         var11 = 0;
      }

      for (int var29 = 0; var29 < var11; var29++) {
         double var30 = (var27 - (double)var29 * 130.0) / var12;
         if (var30 >= 0.0 && var30 < 1.0) {
            double var32 = 1.0 - var30;
            double var34 = 1.0 - var32 * var32 * var32;
            double var36 = 0.15 + var34 * var14;
            double var38 = var30 < 0.3 ? 1.0 : (1.0 - var30) / 0.7;
            var38 = var38 < 0.0 ? 0.0 : (var38 > 1.0 ? 1.0 : var38);
            var38 = var38 * var38 * (3.0 - 2.0 * var38);
            int var40 = (int)(var38 * 210.0);
            if (var40 > 4) {
               float var41 = (float)((double)var16 * (1.0 - 0.3 * var34));
               if (var41 < 1.0F) {
                  var41 = 1.0F;
               }

               float var42 = (float)(var36 * (double)var24);
               int var43 = this.ak(var20, var21, var42, var42 * var23);
               if (var10 == 1) {
                  this.bx(var1, var43, (int)((float)var40 * 0.16F) << 24 | var18, (float)(var17 * 3), 0);
                  this.bx(var1, var43, (int)((float)var40 * 0.32F) << 24 | var18, (float)(var17 * 2), 0);
                  this.bx(var1, var43, var40 << 24 | var19, var41, 0);
               } else {
                  this.bx(var1, var43, var40 << 24 | var18, var41, (int)((float)var40 * (0.26F - 0.1F * (float)var34)) << 24 | var18);
               }
            }
         }

         if (var10 == 2) {
            double var55 = (var27 - (double)var29 * 130.0 - 90.0) / var12;
            if (var55 >= 0.0 && var55 < 1.0) {
               double var56 = 1.0 - var55;
               double var58 = 1.0 - var56 * var56 * var56;
               double var62 = (0.15 + var58 * var14) * 0.62;
               double var64 = var55 < 0.3 ? 1.0 : (1.0 - var55) / 0.7;
               var64 = var64 < 0.0 ? 0.0 : (var64 > 1.0 ? 1.0 : var64);
               var64 = var64 * var64 * (3.0 - 2.0 * var64);
               int var69 = (int)(var64 * 157.0);
               if (var69 > 4) {
                  float var71 = (float)(var62 * (double)var24);
                  int var44 = this.ak(var20, var21, var71, var71 * var23);
                  this.bx(var1, var44, var69 << 24 | var18, (float)var17, (int)((float)var69 * 0.24F) << 24 | var18);
               }
            }
         }
      }

      if (this.he.f()) {
         double var54 = var27 / var12;
         if (var54 >= 0.0 && var54 < 1.0) {
            double var31 = 1.0 - var54;
            float var33 = (float)(1.0 - var31 * var31);
            float var57 = (float)((0.15 + var14) * (double)var24);
            Matrix3x2fStack var35 = var1.getMatrices();
            Matrix3x2f var59 = this.qf.set(var35);
            float var37 = var59.m00;
            float var63 = var59.m01;
            float var39 = var59.m10;
            float var67 = var59.m11;
            float var68 = var59.m20;
            float var70 = var59.m21;
            var35.pushMatrix();

            try {
               for (int var72 = 0; var72 < 12; var72++) {
                  float var73 = (float)(var72 * (-1254804301 ^ -1254806948) % 13) / 13.0F;
                  float var45 = 0.6F + 0.4F * var73;
                  if (!(var54 > (double)var45)) {
                     float var46 = (float) (Math.PI * 2) * (float)var72 / 12.0F + (var73 - 0.5F) * 0.55F;
                     float var47 = var57 * (0.66F + 0.58F * var73) * var33;
                     float var48 = var20 + MathHelper.cos((double)var46) * var47;
                     float var49 = var21 + MathHelper.sin((double)var46) * var47 * var23 - (1.0F - var33) * 3.0F;
                     int var50 = (int)(220.0F * (1.0F - (float)var54 / var45));
                     if (var50 > 8) {
                        var35.set(var37, var63, var39, var67, var37 * var48 + var39 * var49 + var68, var63 * var48 + var67 * var49 + var70);
                        var1.fill(-1, -1, 1, 1, var50 << 24 | var19);
                     }
                  }
               }
            } finally {
               var35.popMatrix();
            }
         }
      }
   }

   private void aj(DrawContext var1, float var2, float var3, float var4, float var5, float var6, int var7, int var8, boolean var9, double var10) {

      int var12 = var9 ? 18 : 17;
      float var13 = var9 ? 0.2F : 0.35F;
      int var14 = var8 >> 16 & (1811448826 ^ 1811448581);
      int var15 = var8 >> 8 & (1659468936 ^ 1659468919);
      int var16 = var8 & (-1552455340 ^ -1552455253);
      int var17 = var14 + (int)((float)((460596991 ^ 460596736) - var14) * var13 + 0.5F) << 16
         | var15 + (int)((float)((-359469725 ^ -359469668) - var15) * var13 + 0.5F) << 8
         | var16 + (int)((float)((-474042425 ^ -474042568) - var16) * var13 + 0.5F);
      Matrix3x2fStack var18 = var1.getMatrices();

      for (int var19 = 0; var19 < var7; var19++) {
         float var20 = (float)((var10 - (double)var19 * 130.0) / (double)var6);
         if (var20 > 0.0F && !(var20 >= 1.0F)) {
            float var21 = 1.0F - var20;
            float var22 = var5 * (1.0F - var21 * var21 * var21);
            float var23 = var21 < 0.7F ? var21 / 0.7F : 1.0F;
            float var24 = var23 * var23 * (3.0F - 2.0F * var23) * Math.min(1.0F, var20 / 0.06F);
            int var25 = (int)(var24 * 255.0F + 0.5F);
            if (var25 > 3 && !(var22 <= 0.004F)) {
               float var26 = var22 / 0.9F * var4;
               var18.pushMatrix();

               try {
                  var18.translate(var2, var3);
                  var18.scale(var26 / 64.0F, var26 * 0.42F / 64.0F);
                  var1.drawTexture(
                     RenderPipelines.GUI_TEXTURED,
                     RegionPassCache.ATLAS,
                     -64,
                     -64,
                     (float)FacetArrayCache.CX[var12],
                     (float)FacetArrayCache.CY[var12],
                     -663721706 ^ -663721578,
                     -1346209967 ^ -1346209839,
                     FacetArrayCache.CS[var12],
                     FacetArrayCache.CH[var12],
                     1963761098 ^ 1963760074,
                     -1528033084 ^ -1528032060,
                     var25 << 24 | var17
                  );
               } finally {
                  var18.popMatrix();
               }
            }
         }
      }
   }

   private int ak(float var1, float var2, float var3, float var4) {

      float[] var5 = this.qg;
      float[] var6 = this.qh;
      boolean[] var7 = this.qi;

      for (int var8 = 0; var8 < 37; var8++) {
         var5[var8] = var1 + pp[var8] * var3;
         var6[var8] = var2 + pq[var8] * var4;
         var7[var8] = true;
      }

      return 37;
   }

   private void al(DrawContext var1, int var2, int var3, int var4, int var5) {

      af(var1, var2, var3, var4, var5, -550415252 ^ -552246232, -713853006 ^ -714906706);
      ItemStack var6 = a.player != null ? a.player.getMainHandStack() : null;
      ItemStack var7 = a.player != null ? a.player.getOffHandStack() : null;
      if (this.wq == null) {
         this.wq = new ItemStack(Items.DIAMOND_SWORD);
         this.wr = new ItemStack(Items.TOTEM_OF_UNDYING);
      }

      if (var6 == null || var6.isEmpty()) {
         var6 = this.wq;
      }

      if (var7 == null || var7.isEmpty()) {
         var7 = this.wr;
      }

      long var8 = ms();
      int var10 = Math.max(1, this.gg.g()) * 50;
      long var11 = var8 % ((long)var10 + 900L);
      float var13 = var11 < (long)var10 ? MathHelper.sin((double)(MathHelper.sqrt((float)var11 / (float)var10) * (float) Math.PI)) : 0.0F;
      float var14 = this.hp.f() ? MathHelper.sin((double)((float)var8 * 0.0021F)) * 1.6F : 0.0F;
      float var15 = this.hk.h();
      float var16 = (float)var2 + (float)var4 * 0.64F + this.hl.h() * 22.0F;
      float var17 = (float)var3 + (float)var5 * 0.58F - this.hm.h() * 12.0F + var14;
      Matrix3x2fStack var18 = var1.getMatrices();
      var18.pushMatrix();

      try {
         var18.translate(var16, var17);
         var18.rotate(-1.15F * var13);
         var18.scale(1.6F * var15, 1.6F * var15);
         var1.drawItem(var6, -8, -8);
      } finally {
         var18.popMatrix();
      }

      int var19 = k(this.ho);
      if (var19 != 2) {
         var18.pushMatrix();

         try {
            var18.translate((float)var2 + (float)var4 * 0.3F, (float)var3 + (float)var5 * 0.58F + (var19 == 1 ? 9.0F : 0.0F) + var14 * 0.5F);
            var18.scale(1.3F, 1.3F);
            var1.drawItem(var7, -8, -8);
         } finally {
            var18.popMatrix();
         }
      }
   }

   private void am(DrawContext var1, int var2, int var3, int var4, int var5) {

      long var6 = ms();
      int var10 = n(l(this.hq, kc, -1));
      int var8;
      int var9;
      if (this.gk.f()) {
         float var11 = (float)Math.max(100.0, this.hr.f() * 1000.0);
         float var12 = (float)(var6 % (long)var11) / var11;
         var8 = dq(var12, 0.65F, 1.0F);
         var9 = var10 == -1 ? -1 : (var10 == -2 ? dq(var12 + 0.18F, 0.65F, 1.0F) : var10);
      } else {
         var8 = n(l(this.gj, kb, 522319324 ^ 532388643));
         var9 = var10 == -2 ? var8 : var10;
      }

      float var26 = (float)(this.hs.f() / 100.0);
      boolean var27 = k(this.gi) == 1;
      int var13 = -1577624256 ^ -1583823169;
      int var14 = -27564036 ^ -18631933;
      int var15;
      if (var9 == -1) {
         var15 = var13;
      } else if (var27) {
         var15 = dn(var13, var9, var26);
      } else {
         int var16 = (var13 >> 16 & (1881560133 ^ 1881560250)) * (var9 >> 16 & (-861833751 ^ -861833962)) / (-318211496 ^ -318211417) << 16
            | (var13 >> 8 & (-1472192052 ^ -1472192205)) * (var9 >> 8 & (1283795431 ^ 1283795224)) / (-1995213414 ^ -1995213467) << 8
            | (var13 & (-813810233 ^ -813810376)) * (var9 & (-309556168 ^ -309556025)) / (1769272585 ^ 1769272822);
         var15 = dn(var13, var16, var26);
      }

      int var29 = dn(var14, var8, var27 ? var26 : 0.75F * var26);
      float var17 = var26 * (float)(this.jl.p() / 100.0);
      float var18 = var26 * (float)(this.jk.p() / 100.0);
      var15 = _kwren_do(var15, var8, var17);
      int var19 = var5 - var5 / 4;
      af(var1, var2, var3, var4, var19, var15, _kwren_do(var29, var8, var17));
      float var20 = (float)(this.ht.f() / 100.0);
      if (var20 > 0.01F) {
         for (int var21 = 0; var21 < 28; var21++) {
            int var22 = var2 + 3 + (var21 * 37 + 11) % Math.max(1, var4 - 6);
            int var23 = var3 + 2 + (var21 * 53 + 7) % Math.max(1, var19 * 2 / 3);
            float var24 = 0.55F + 0.45F * MathHelper.sin((double)((float)var6 * 0.004F + (float)var21 * 1.7F));
            int var25 = (int)(255.0F * var20 * var24);
            if (var25 > 10) {
               var1.fill(
                  var22, var23, var22 + 1, var23 + 1, (var25 > (-1217806033 ^ -1217805872) ? -2046492434 ^ -2046492655 : var25) << 24 | 620917341 ^ 637373858
               );
            }
         }
      }

      int var30 = _kwren_do(this.hu.f() ? dn(-465407179 ^ -458192947, var8, 0.8F * var26) : -799540757 ^ -794489581, var8, var17);
      int var31 = var3 + var19 / 3;
      dt(var1, var2 + var4 / 6, var31, var4 / 4, 5, 2, 796974486 ^ -8331882 | var30);
      dt(var1, var2 + var4 / 6 + 6, var31 - 3, var4 / 7, 5, 2, -282905198 ^ 1059272082 | var30);
      dt(var1, var2 + var4 * 3 / 5, var31 + 6, var4 / 5, 4, 2, 1089741542 ^ -118218010 | var30);
      int var32 = -1148836077 ^ 1149642515 | _kwren_do(dn(dn(2049580294 ^ 2050373400, var29, 0.12F), var29, 0.75F * var18), var8, var17);
      var1.fill(var2, var3 + var19, var2 + var4, var3 + var5, var32);

      for (byte var33 = 0; var33 < var4; var33 += 2) {
         float var34 = 3.0F
            + 2.5F * MathHelper.sin((double)((float)var33 * 0.09F))
            + 1.5F * MathHelper.sin((double)((float)var33 * 0.23F + 1.3F));
         var1.fill(var2 + var33, var3 + var19 - Math.round(var34), var2 + Math.min(var4, var33 + 2), var3 + var19, var32);
      }
   }

   private void an(DrawContext var1, int var2, int var3, int var4, int var5) {

      assert var1 != null && var4 > 0 && var5 > 0 && wv.length == 120 && ww.length == 12 && this.wx.length == (901069857 ^ 901070241) : "fb:" + " bad contract";

      try {
         long var6 = ms();
         float var8 = (float)(this.hw.p() / 100.0);
         boolean var9 = k(this.hv) == 1;
         float var10 = 0.5F;
         if (a.options != null) {
            var10 = (float)((Double)a.options.getGamma().getValue()).doubleValue();
         }

         var10 = var10 < 0.0F ? 0.0F : (var10 > 1.0F ? 1.0F : var10);
         double var11 = (double)var6;
         float var13 = 1.0F + 0.035F * (float)Math.sin(var11 * 0.011) + 0.02F * (float)Math.sin(var11 * 0.029 + 1.7);
         int[] var14 = this.wx;

         for (int var15 = 0; var15 < 2; var15++) {
            for (int var16 = 0; var16 < 16; var16++) {
               float var17 = (float)var16 / 15.0F;
               float var18 = var17 / (4.0F - 3.0F * var17) * 1.5F * var13;
               float var20 = var18 * ((var18 * 0.6F + 0.4F) * 0.6F + 0.4F);
               float var21 = var18 * (var18 * var18 * 0.6F + 0.4F);
               float var19 = var18 > 1.0F ? 1.0F : var18;
               var20 = var20 > 1.0F ? 1.0F : var20;
               var21 = var21 > 1.0F ? 1.0F : var21;
               if (var15 == 1 && !var9) {
                  var19 += (1.0F - var19) * var8;
                  var20 += (1.0F - var20) * var8;
                  var21 += (1.0F - var21) * var8;
               }

               var19 = var19 * 0.96F + 0.03F;
               var20 = var20 * 0.96F + 0.03F;
               var21 = var21 * 0.96F + 0.03F;
               if (var15 == 1 && var9) {
                  float var22 = Math.max(var19, Math.max(var20, var21));
                  if (var22 > 1.0E-4F && var22 < 1.0F) {
                     float var23 = 1.0F / var22;
                     var19 += (var19 * var23 - var19) * var8;
                     var20 += (var20 * var23 - var20) * var8;
                     var21 += (var21 * var23 - var21) * var8;
                  }
               }

               float var56 = 1.0F - var19;
               float var58 = 1.0F - var20;
               float var24 = 1.0F - var21;
               var19 += (1.0F - var56 * var56 * var56 * var56 - var19) * var10;
               var20 += (1.0F - var58 * var58 * var58 * var58 - var20) * var10;
               var21 += (1.0F - var24 * var24 * var24 * var24 - var21) * var10;
               var19 = var19 > 1.0F ? 1.0F : var19;
               var20 = var20 > 1.0F ? 1.0F : var20;
               var21 = var21 > 1.0F ? 1.0F : var21;
               int var25 = (var15 * 16 + var16) * 12;

               for (int var26 = 0; var26 < 12; var26++) {
                  int var27 = ww[var26];
                  var14[var25 + var26] = -242099117 ^ 244440147
                     | (int)((float)(var27 >> 16 & (136450508 ^ 136450355)) * var19 + 0.5F) << 16
                     | (int)((float)(var27 >> 8 & (-1234946988 ^ -1234946901)) * var20 + 0.5F) << 8
                     | (int)((float)(var27 & (-1620999919 ^ -1620999698)) * var21 + 0.5F);
               }
            }
         }

         int var38 = var2 + Math.round((float)var4 * (0.5F + 0.28F * (float)Math.sin(var11 * 9.817477042468104E-4)));
         float var39 = (float)var5 / 5.0F;
         int var40 = Math.min(24, (int)Math.ceil((double)((float)var4 / var39)));
         int var41 = Math.max(1, Math.round(var39 * 0.22F));
         int var45 = Math.max(1, Math.round(var39 * 0.2F));
         int var50 = -1607542612 ^ 1596905644 | dn(-2136022736 ^ -2142154121, 965306042 ^ 964068144, 0.5F + 0.5F * (float)Math.sin(var11 * 0.02));

         for (int var55 = 0; var55 < 5; var55++) {
            int var57 = var3 + Math.round((float)var55 * var39);
            int var59 = var55 == 4 ? var3 + var5 : var3 + Math.round((float)(var55 + 1) * var39);

            for (int var60 = 0; var60 < var40; var60++) {
               int var61 = var2 + Math.round((float)var60 * var39);
               int var62 = Math.min(var2 + var4, var2 + Math.round((float)(var60 + 1) * var39));
               if (var62 > var61) {
                  byte var63 = wv[var55 * 24 + var60];
                  int var28 = 14 - Math.abs(var55 - 2) - Math.abs(var60 - 2);
                  int var29 = (var28 < 0 ? 0 : var28) * 12;
                  int var30 = var29 + (72318310 ^ 72318374);
                  if (var62 <= var38) {
                     var1.fill(var61, var57, var62, var59, var14[var29 + var63]);
                  } else if (var61 >= var38) {
                     var1.fill(var61, var57, var62, var59, var14[var30 + var63]);
                  } else {
                     var1.fill(var61, var57, var38, var59, var14[var29 + var63]);
                     var1.fill(var38, var57, var62, var59, var14[var30 + var63]);
                  }

                  if (var63 == 3 || var63 == 5) {
                     int var65 = var63 == 3 ? 8 : 9;
                     int var67 = var61 + Math.round(var39 * 0.2F);
                     int var68 = var57 + Math.round(var39 * 0.25F);
                     int var34 = var61 + Math.round(var39 * 0.58F);
                     int var35 = var57 + Math.round(var39 * 0.6F);
                     var1.fill(var67, var68, var67 + var41, var68 + var41, var14[(var67 >= var38 ? var30 : var29) + var65]);
                     var1.fill(var34, var35, var34 + var41, var35 + var41, var14[(var34 >= var38 ? var30 : var29) + var65]);
                  } else if (var63 == 4) {
                     int var31 = var61 + Math.round(var39 * 0.5F) - (var41 + 1) / 2;
                     int var32 = var57 + Math.round(var39 * 0.38F);
                     var1.fill(var31, var32, var31 + var41, var59 - Math.round(var39 * 0.08F), var14[(var31 >= var38 ? var30 : var29) + 11]);
                     var1.fill(var31 - 1, var32 - var41 - 1, var31 + var41 + 1, var32, var50);
                  } else if (var63 == 6) {
                     int var64 = var61 + var45;
                     int var66 = var62 - 2 * var45;
                     int var33 = var61 + 2 * var45;
                     var1.fill(var64, var57 + var45, var64 + var45, var57 + 2 * var45, var14[(var64 >= var38 ? var30 : var29) + 10]);
                     var1.fill(var66, var57 + var45, var66 + var45, var57 + 2 * var45, var14[(var66 >= var38 ? var30 : var29) + 10]);
                     var1.fill(var33, var57 + 2 * var45 + 1, var62 - 2 * var45, var59 - var45, var14[(var33 >= var38 ? var30 : var29) + 10]);
                  }
               }
            }
         }

         var1.fill(var38, var3, var38 + 1, var3 + var5, 1481473730 ^ -1867349699);
         dt(var1, var38 - 2, var3 + var5 / 2 - 5, 5, 10, 2, 15022005 ^ -434452406);
      } catch (RuntimeException var36) {
         throw var36;
      }
   }

   private void ao(DrawContext var1, int var2, int var3, int var4, int var5, float var6) {

      assert var1 != null
         && var4 > 0
         && var5 > 0
         && this.wy.length == 4
         && this.qg.length == 37
         && this.qh.length == 37
         && this.qi.length == 37
         && var6 >= 0.0F
         && var6 <= 0.1F : "pearl" + ": ba" + "d contract";

      try {
         af(var1, var2, var3, var4, var5, 336780715 ^ 336394655, -1628431842 ^ -1627777524);
         long var7 = ms();
         float[] var9 = this.wy;
         float var10 = var6 / 0.2F;
         var9[0] = this.gn.f() ? Math.min(1.0F, var9[0] + var10) : Math.max(0.0F, var9[0] - var10);
         var9[1] = this.go.f() ? Math.min(1.0F, var9[1] + var10) : Math.max(0.0F, var9[1] - var10);
         var9[2] = this.ib.f() ? Math.min(1.0F, var9[2] + var10) : Math.max(0.0F, var9[2] - var10);
         var9[3] = this.hz.f() ? Math.min(1.0F, var9[3] + var10) : Math.max(0.0F, var9[3] - var10);
         float var11 = var9[0] * var9[0] * (3.0F - 2.0F * var9[0]);
         float var12 = var9[1] * var9[1] * (3.0F - 2.0F * var9[1]);
         float var13 = var9[2] * var9[2] * (3.0F - 2.0F * var9[2]);
         float var14 = var9[3] * var9[3] * (3.0F - 2.0F * var9[3]);
         int var15 = this.gq.f() ? dq((float)(var7 % 2600L) / 2600.0F, 0.85F, 1.0F) : l(this.hx, ke, -138759076 ^ -142945117);
         var15 &= 872797250 ^ 888810429;
         int var16 = var15 >> 16 & (252954786 ^ 252954717);
         int var17 = var15 >> 8 & (453505667 ^ 453505660);
         int var18 = var15 & (-1583086529 ^ -1583086400);
         int var19 = Math.max(1, Math.round(this.hy.h()));
         float var20 = (float)var3 + (float)var5 * 0.84F;
         var1.fill(var2, Math.round(var20), var2 + var4, Math.round(var20) + 1, -1713898996 ^ -1456994829);
         float var21 = (float)var4 * 0.62F / 3.4F;
         float var22 = (float)var2 + (float)var4 * 0.16F;
         int var23 = Math.max(2, Math.round(0.5F * var21));
         int var24 = Math.max(4, Math.round(1.8F * var21));
         int var25 = Math.round(var22) - var23 / 2;
         int var26 = Math.round(var20) - var24;
         dt(var1, var25, var26, var23, var24, Math.min(2, var23 / 2), 1029147895 ^ -1032991069);
         dt(var1, var25 - 1, var26 - 1, var23 + 2, Math.max(3, var24 / 4) + 1, 1, 1403257650 ^ -1393666214);
         float var27 = var22 + 0.3F * var21;
         float var28 = var20 - 1.52F * var21;
         float var29 = var22 + 3.4F * var21;
         float var30 = 1.15F * var21;
         float var31 = (float)(var7 % 3000L) / 1000.0F;
         float var32 = var31 - 0.9F;
         float var33 = 1.1F;
         float[] var34 = this.qg;
         float[] var35 = this.qh;
         boolean[] var36 = this.qi;
         float var37 = var31 / 0.18F;
         float var38 = var32 / 0.22F;
         var37 = var37 > 1.0F ? 1.0F : var37;
         var38 = var38 < 0.0F ? 0.0F : (var38 > 1.0F ? 1.0F : var38);
         int var39 = (int)(144.0F * var37 * var37 * (3.0F - 2.0F * var37) * (1.0F - var38 * var38 * (3.0F - 2.0F * var38)) * var14);
         if (var39 > 1) {
            int var40 = dn(var15, -1193181985 ^ -1205959904, 0.4F);
            int var41 = 0;

            for (byte var42 = 0; var42 < 24 && var41 + 3 <= 37; var42 += 2) {
               for (int var43 = 0; var43 < 3; var43++) {
                  float var44 = (float)(var42 + (var43 == 0 ? 0 : 1)) / 24.0F;
                  float var45 = 1.0F - var44;
                  var34[var41] = var27 + (var29 - var27) * var44;
                  var35[var41] = var28 * var45 + var20 * var44 - 4.0F * var30 * var44 * var45;
                  var36[var41] = var43 < 2;
                  var41++;
               }
            }

            this.bx(var1, var41, var39 << 24 | var40, (float)var19, 0);
            int var63 = this.ak(var29, var20, 0.45F * var21, 0.45F * var21 * 0.34F);
            this.bx(var1, var63, var39 << 24 | var40, (float)var19, var39 >> 2 << 24 | var40);
         }

         float var61 = 0.0F;
         float var62 = -1.0F;
         if (var32 >= 0.0F) {
            var62 = var32 < var33 ? var32 / var33 : 1.0F;
            float var64 = Math.min(1.0F, var32 / 0.18F);
            float var66 = (var32 - var33) / 0.25F;
            var66 = var66 < 0.0F ? 0.0F : (var66 > 1.0F ? 1.0F : var66);
            var61 = var64 * var64 * (3.0F - 2.0F * var64) * (1.0F - var66 * var66 * (3.0F - 2.0F * var66));
         }

         if (var62 >= 0.0F && var61 > 0.004F) {
            float var65 = var11 * var61;
            float var68 = 1.0F - var62;
            if (var65 > 0.004F && var68 > 0.001F) {
               for (int var69 = 0; var69 < 6; var69++) {
                  for (int var71 = 0; var71 <= 4; var71++) {
                     float var46 = var62 + var68 * (float)(var69 * 4 + var71) / 24.0F;
                     float var47 = 1.0F - var46;
                     var34[var71] = var27 + (var29 - var27) * var46;
                     var35[var71] = var28 * var47 + var20 * var46 - 4.0F * var30 * var46 * var47;
                     var36[var71] = true;
                  }

                  float var72 = ((float)var69 + 0.5F) / 6.0F;
                  float var74 = 0.55F + 0.45F * var72;
                  int var76 = (int)((80.0F + var72 * 144.0F) * var65) << 24
                     | (int)((float)var16 * var74) << 16
                     | (int)((float)var17 * var74) << 8
                     | (int)((float)var18 * var74);
                  this.bx(var1, 5, var76, (float)var19, 0);
               }
            }

            float var70 = var12 * var61;
            int var73 = (int)(240.0F * var70);
            int var75 = (int)(144.0F * var70);
            if (var73 > 1) {
               float var77 = 0.55F + 0.06F * (float)Math.sin((double)var7 / 130.0);
               float var48 = 0.12F + 0.43F * (1.0F - var62);
               int var49 = this.ak(var29, var20, var77 * var21, var77 * var21 * 0.34F);
               this.bx(var1, var49, var73 << 24 | var15, (float)var19, (int)(46.0F * var70) << 24 | var15);
               var49 = this.ak(var29, var20, var48 * var21, var48 * var21 * 0.34F);
               this.bx(var1, var49, var75 << 24 | var15, (float)var19, (int)(28.0F * var70) << 24 | var15);
            }

            if (var62 < 1.0F) {
               float var78 = 1.0F - var62;
               int var80 = Math.round(var27 + (var29 - var27) * var62);
               int var83 = Math.round(var28 * var78 + var20 * var62 - 4.0F * var30 * var62 * var78);
               int var50 = (int)(240.0F * var61);
               dt(var1, var80 - 2, var83 - 2, 4, 4, 1, var50 << 24 | 512393324 ^ 513145348);
               var1.fill(var80 - 1, var83 - 1, var80, var83, var50 << 24 | 513963472 ^ 505055028);
            }

            float var79 = var13 * var61;
            if (var79 > 0.03F) {
               float var81 = (1.0F - var62) * var33;
               float var84 = MathHelper.clamp(1.0F - var81, 0.0F, 1.0F);
               float var85 = var1.getMatrices().m00;
               int var51 = cw(dr(2, (long)Math.round(var81 * 10.0F)), var85 > 0.0F ? var85 : 1.0F);
               int var52 = lm[var51];
               int var53 = Math.round(var29) - var52 / 2;
               int var54 = Math.round(var20 - 0.55F * var21) - 8;
               int var55 = (int)(255.0F * var79);
               int var56 = (int)(144.0F * var79);
               if (var56 >= 2) {
                  dt(var1, var53 - 3, var54 - 2, var52 + 6, 12, 3, var56 << 24);
               }

               if (var55 >= 8) {
                  var1.drawText(a.textRenderer, ll[var51], var53, var54, var55 << 24 | dn(var15, -368936781 ^ -352483508, var84), true);
               }
            }
         }
      } catch (RuntimeException var57) {
         throw var57;
      }
   }

   private static float ap(int var0) {

      int var1 = var0 * (1757259802 ^ -158674517);
      var1 ^= var1 >>> 15;
      var1 *= -1337677529 ^ 900686668;
      var1 ^= var1 >>> 13;
      return (float)(var1 & (205930334 ^ 213500065)) / 1.6777216E7F;
   }

   private static void aq(DrawContext var0, float var1, float var2, float var3, float var4, float var5, int var6) {

      if (var6 >>> 24 >= 2 && var3 > 0.0F && var4 > 0.0F) {
         Matrix3x2fStack var7 = var0.getMatrices();
         var7.pushMatrix();

         try {
            var7.translate(var1, var2);
            if (var5 != 0.0F) {
               var7.rotate(var5);
            }

            var7.scale(var3, var4);
            var0.fill(-1, -1, 1, 1, var6);
         } finally {
            var7.popMatrix();
         }
      }
   }

   private static void ar(DrawContext var0, float var1, float var2, float var3, float var4, float var5, int var6) {

      float var7 = var3 - var1;
      float var8 = var4 - var2;
      float var9 = (float)Math.sqrt((double)(var7 * var7 + var8 * var8));
      if (!(var9 < 0.05F)) {
         aq(var0, (var1 + var3) * 0.5F, (var2 + var4) * 0.5F, var9 * 0.5F, var5 * 0.5F, (float)Math.atan2((double)var8, (double)var7), var6);
      }
   }

   private static void as(DrawContext var0, float var1, float var2, float var3, float var4, int var5, float var6) {

      int var7 = (int)(Math.max(0.0F, Math.min(1.0F, var6)) * 255.0F);
      if (var7 >= 3 && var3 > 0.2F) {
         if (StyleKeyCache.v()) {
            float var14 = 2.0F * var3 / 1.3F;
            Matrix3x2fStack var15 = var0.getMatrices();
            var15.pushMatrix();

            try {
               var15.translate(var1, var2);
               if (var4 != 1.0F) {
                  var15.scale(1.0F, var4);
               }

               StyleKeyCache.ac(var0, 16, -var14 * 0.5F, -var14 * 0.5F, var14, var7 << 24 | var5);
            } finally {
               var15.popMatrix();
            }
         } else {
            int var8 = (int)((float)var7 * 0.12F);

            for (int var9 = 0; var9 < 3 && var8 >= 2; var9++) {
               float var10 = var3 * (1.0F - 0.27F * (float)var9);
               float var11 = (float)var9 * (float) (Math.PI / 8);
               aq(var0, var1, var2, var10 * 0.93F, var10 * 0.93F * var4, var11, var8 << 24 | var5);
               aq(var0, var1, var2, var10 * 0.93F, var10 * 0.93F * var4, var11 + (float) (Math.PI / 4), var8 << 24 | var5);
            }
         }
      }
   }

   private static void at(DrawContext var0, float var1, float var2, float var3, int var4, float var5) {

      as(var0, var1, var2, var3 * 1.15F, 1.0F, var4, Math.min(1.0F, var5 * 1.5F));
      int var6 = (int)(var5 * 235.0F);
      if (var6 >= 2) {
         float var7 = Math.min(var3 * 0.32F, 3.5F);
         aq(var0, var1, var2, var7 * 0.9F, var7 * 0.9F, 0.0F, var6 << 24 | dn(var4, -317787654 ^ -302969339, 0.45F));
         aq(var0, var1, var2, var7 * 0.9F, var7 * 0.9F, (float) (Math.PI / 4), var6 << 24 | dn(var4, 2083929819 ^ 2093596964, 0.45F));
      }
   }

   private static void au(DrawContext var0, float var1, float var2, float var3, int var4, float var5) {

      as(var0, var1, var2, var3, 1.0F, var4, var5 * 0.55F);
   }

   private static void av(DrawContext var0, float var1, float var2, float var3, int var4, float var5) {

      as(var0, var1, var2, var3, 0.2F, var4, var5 * 0.8F);
   }

   private static void aw(DrawContext var0, float var1, float var2, float var3, float var4, float var5, boolean var6, float var7, int var8, float var9, int var10) {

      int var11 = (int)(Math.max(0.0F, Math.min(1.0F, var4)) * 255.0F);
      if (var11 >= 3) {
         int var12 = var10 >= 0 ? var10 : dn(-690443084 ^ -695011108, var8, var9);
         int var13 = var10 >= 0 ? var10 : dn(1046611171 ^ 1045972663, var8, var9);
         int var14 = var10 >= 0 ? var10 : dn(1500261351 ^ 1497505443, var8, var9);
         int var15 = var11 << 24;
         Matrix3x2fStack var16 = var0.getMatrices();
         var16.pushMatrix();

         try {
            var16.translate(var1, var2);
            if (var5 != 0.0F) {
               var16.rotate(var5);
            }

            var16.scale(var3 / 16.0F, var3 / 16.0F);
            if (var6) {
               float var17 = MathHelper.sin((double)var7) * 0.55F;

               for (int var18 = 0; var18 < 2; var18++) {
                  float var19 = var18 == 0 ? var17 : -var17;
                  var16.pushMatrix();

                  try {
                     var16.translate(0.0F, -12.0F);
                     var16.rotate(var19);
                     var0.fill(-2, 0, 2, 12, var15 | (var18 == 0 ? var14 : var13));
                  } finally {
                     var16.popMatrix();
                  }
               }

               var0.fill(-2, -24, 2, -12, var15 | var13);
               var0.fill(-4, -32, 4, -24, var15 | var12);
               var16.pushMatrix();

               try {
                  var16.translate(0.0F, -22.0F);
                  var16.rotate(-var17);
                  var0.fill(-1, 0, 2, 10, var15 | var14);
               } finally {
                  var16.popMatrix();
               }
            } else {
               var0.fill(-4, -12, 0, 0, var15 | var14);
               var0.fill(0, -12, 4, 0, var15 | dn(var14, 0, 0.18F));
               var0.fill(-4, -24, 4, -12, var15 | var13);
               var0.fill(-8, -24, -4, -12, var15 | var14);
               var0.fill(4, -24, 8, -12, var15 | var14);
               var0.fill(-4, -32, 4, -24, var15 | var12);
            }
         } finally {
            var16.popMatrix();
         }
      }
   }

   private static void ax(DrawContext var0, int var1, int var2, float var3) {

      var0.fill(var1, Math.round(var3), var1 + var2, Math.round(var3) + 1, 670271037 ^ 386693570);
   }

   private static int ay(SlotEntry var0) {

      return o(l(var0, kd, -3)) & (-1997237372 ^ -2012517253);
   }

   private void az(DrawContext var1, int var2, int var3, int var4, int var5) {

      af(var1, var2, var3, var4, var5, -1628234625 ^ -1629933767, 784785476 ^ 785839192);
      int var6 = var2 + var4 / 2;
      int var7 = var3 + var5 / 2;
      var1.fill(var6 - var4 / 2 + 14, var7, var6 - var4 / 2 + 19, var7 + 1, 461113088 ^ 1065613567);
      this.db(2, var1, var6, var7);
   }

   private void ba(DrawContext var1, float var2, float var3, float var4, float var5, float var6, int var7, float var8, float var9) {

      float var10 = 0.1F * var4;
      float var11 = var3 - 0.4F * var4;
      float var12 = 1.45F * var5;

      try {
         PaneGlassCache var13 = PaneGlassCache.take(var1.scissorStack.peekLast(), false);
         Matrix3x2fStack var56 = var1.getMatrices();
         float var57 = 0.4F + 0.6F * var8;
         int[] var58 = xg;
         float[] var59 = new float[]{0.0F, 0.2F, 0.4F};
         float[] var60 = new float[]{0.35F, 0.45F, 0.6F};
         float[] var61 = new float[]{190.0F, 215.0F, 230.0F};
         float[] var62 = new float[]{155.0F, 185.0F, 205.0F};

         for (int var63 = 0; var63 < 3; var63++) {
            for (int var22 = 0; var22 < 4; var22++) {
               float var23 = var22 == 0 ? 0.0F : (var22 == 1 ? 0.45F : (var22 == 2 ? 0.9F : 1.0F));
               int var24 = (int)((var61[var63] + (var62[var63] - var61[var63]) * var23) * var57);
               var58[var63 * 4 + var22] = Math.min(-1446742767 ^ -1446742546, var24) << 24
                  | dn(var7, 564478513 ^ 559594958, var59[var63] + (var60[var63] - var59[var63]) * var23);
            }
         }

         int var64 = Math.min(-894101069 ^ -894101172, (int)((120.0F + 90.0F * var9) * var57)) << 24 | dn(var7, -2016024751 ^ -2027284306, 0.7F);
         int var65 = Math.min(-1934700922 ^ -1934700935, (int)(170.0F + 70.0F * var9)) << 24 | dn(var7, 1284435139 ^ 1282478908, 0.6F);
         float var66 = 0.1F * MathHelper.sin((double)(var6 * 2.6F));
         float var67 = 0.08F * MathHelper.sin((double)(var6 * 2.6F + 0.4F));
         float var25 = MathHelper.cos((double)var66);
         float var26 = MathHelper.sin((double)var66);
         float[] var27 = xe;
         int[] var28 = xf;

         for (byte var29 = -1; var29 <= 1; var29 += 2) {
            float var30 = var2 + (float)var29 * var10;
            float var31 = (float)var29 * var12 * 0.92F;

            for (int var32 = 0; var32 < 59; var32++) {
               byte var33 = HaloPassCache.WF_R[var32];
               boolean var34 = var33 <= 1;
               float var35 = HaloPassCache.WF_X[var32];
               float var36 = HaloPassCache.WF_Y[var32];
               float var37 = HaloPassCache.WF_L[var32];
               float var38 = HaloPassCache.WF_W[var32] * 1.35F;
               float var39 = HaloPassCache.WF_DX[var32];
               float var40 = HaloPassCache.WF_DY[var32];
               if (var33 == 1) {
                  float var41 = HaloPassCache.WF_A[var32] + var67 * (float)(var32 - 9) / 9.0F;
                  var39 = MathHelper.cos((double)var41);
                  var40 = MathHelper.sin((double)var41);
               }

               float var73 = -var40;
               float var43 = var34 ? var38 * 0.62F : var38 * 0.9F;
               float var44 = var34 ? 0.45F : 0.5F;
               float var45 = var34 ? 0.93F : 0.88F;
               var27[0] = var35 + var73 * var43 * 0.3F;
               var27[1] = var36 + var39 * var43 * 0.3F;
               var27[2] = var35 + var39 * var37 * var44 + var73 * var43;
               var27[3] = var36 + var40 * var37 * var44 + var39 * var43;
               var27[4] = var35 + var39 * var37 * var45 + var73 * var43 * 0.55F;
               var27[5] = var36 + var40 * var37 * var45 + var39 * var43 * 0.55F;
               var27[6] = var35 + var39 * var37;
               var27[7] = var36 + var40 * var37;
               var27[8] = var35 + var39 * var37 * var45 - var73 * var38 * 0.55F;
               var27[9] = var36 + var40 * var37 * var45 - var39 * var38 * 0.55F;
               var27[10] = var35 + var39 * var37 * var44 - var73 * var38;
               var27[11] = var36 + var40 * var37 * var44 - var39 * var38;
               var27[12] = var35 - var73 * var38 * 0.3F;
               var27[13] = var36 - var39 * var38 * 0.3F;
               int var46 = var33 <= 1 ? 0 : (var33 <= 3 ? 4 : 8);

               for (int var47 = 0; var47 < 7; var47++) {
                  float var48 = var27[var47 * 2];
                  float var49 = var27[var47 * 2 + 1];
                  var27[var47 * 2] = var30 + (var48 * var25 - var49 * var26) * var31;
                  var27[var47 * 2 + 1] = var11 - (var48 * var26 + var49 * var25) * var12;
                  var28[var47] = var58[var46 + xh[var47]];
               }

               var13.convex(var56, var27, var28, 7);
               if (var34) {
                  float var74 = var35 + var39 * var37 * 0.9F;
                  float var50 = var36 + var40 * var37 * 0.9F;
                  float var51 = var30 + (var35 * var25 - var36 * var26) * var31;
                  float var52 = var11 - (var35 * var26 + var36 * var25) * var12;
                  float var53 = var30 + (var74 * var25 - var50 * var26) * var31;
                  float var54 = var11 - (var74 * var26 + var50 * var25) * var12;
                  this.bb(var13, var56, var51, var52, var53, var54, 0.32F, 0.12F, var64);
               }
            }

            for (int var68 = 0; var68 < 4; var68++) {
               float var69 = HaloPassCache.WB[var68 * 2];
               float var70 = HaloPassCache.WB[var68 * 2 + 1];
               float var71 = HaloPassCache.WB[var68 * 2 + 2];
               float var72 = HaloPassCache.WB[var68 * 2 + 3];
               this.bb(
                  var13,
                  var56,
                  var30 + (var69 * var25 - var70 * var26) * var31,
                  var11 - (var69 * var26 + var70 * var25) * var12,
                  var30 + (var71 * var25 - var72 * var26) * var31,
                  var11 - (var71 * var26 + var72 * var25) * var12,
                  0.85F - 0.12F * (float)var68,
                  0.73F - 0.12F * (float)var68,
                  var65
               );
            }
         }

         var13.addTo(var1.state);
      } catch (Throwable var55) {
         float var14 = MathHelper.sin((double)(var6 * 2.6F)) * 0.2F;

         for (byte var15 = -1; var15 <= 1; var15 += 2) {
            for (int var16 = 0; var16 < 6; var16++) {
               float var17 = (0.5F + 0.36F * (float)var16 + var14 * (1.0F - (float)var16 * 0.14F)) * (float)var15;
               float var18 = var5 * (1.25F - 0.1F * (float)var16);
               float var19 = var2 + (float)var15 * 0.12F * var4;
               float var20 = var19 + MathHelper.sin((double)var17) * var18;
               float var21 = var11 - MathHelper.cos((double)var17) * var18;
               aq(
                  var1,
                  (var19 + var20) * 0.5F,
                  (var11 + var21) * 0.5F,
                  var18 * 0.5F,
                  1.6F + 0.35F * (float)var16,
                  (float)Math.atan2((double)(var21 - var11), (double)(var20 - var19)),
                  (int)(40.0F + 150.0F * var8) << 24 | var7
               );
            }
         }
      }
   }

   private void bb(PaneGlassCache var1, Matrix3x2fc var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9) {

      float var10 = var5 - var3;
      float var11 = var6 - var4;
      float var12 = (float)Math.sqrt((double)(var10 * var10 + var11 * var11));
      if (!(var12 < 0.05F)) {
         float var13 = -var11 / var12;
         float var14 = var10 / var12;
         float[] var15 = xe;
         int[] var16 = xf;
         var15[0] = var3 + var13 * var7;
         var15[1] = var4 + var14 * var7;
         var15[2] = var5 + var13 * var8;
         var15[3] = var6 + var14 * var8;
         var15[4] = var5 - var13 * var8;
         var15[5] = var6 - var14 * var8;
         var15[6] = var3 - var13 * var7;
         var15[7] = var4 - var14 * var7;
         var16[0] = var9;
         var16[1] = var9;
         var16[2] = var9;
         var16[3] = var9;
         var1.convex(var2, var15, var16, 4);
      }
   }

   private void bc(DrawContext var1, int var2, int var3, int var4, int var5) {

      assert var1 != null && var4 > 0 && var5 > 0 && this.qg.length == 37 : "esp: bad contract";

      try {
         af(var1, var2, var3, var4, var5, -1472899225 ^ -1473547437, -1029444425 ^ -1029054299);
         float var6 = (float)var3 + (float)var5 * 0.88F;
         float var7 = (float)var5 * 0.33F;
         float var8 = (float)var2 + (float)var4 * 0.5F;
         float var9 = var6 - var7;
         ax(var1, var2, var4, var6);
         int var10 = k(this.ie);
         int var11 = ay(this.il);
         float var12 = this.ig.h();
         float var13 = (float)(ms() % 3600000L) / 1000.0F * this.ih.h();
         float var14 = (float)(this.ii.p() / 100.0);
         float var15 = (float)(this.ij.p() / 100.0);
         float var16 = 0.82F * var7 * var12;
         au(var1, var8, var9, var16 * 1.25F, var11, 0.35F + 0.45F * var15);
         av(var1, var8, var6, var16 * 1.1F, var11, 0.5F + 0.3F * var15);
         aq(var1, var8, var6, var7 * 0.42F, 1.2F, 0.0F, -905962538 ^ -1711268906);
         float[] var17 = this.qg;
         float[] var18 = this.qh;
         boolean[] var19 = this.qi;
         if (var10 == 2) {
            this.ba(var1, var8, var9, var7, var16, var13, var11, var14, var15);
         }

         if (var10 == 4 || var10 == 5) {
            this.be(var1, var8, var6, var7, var16, var13, var10, var11, var14, var15, false);
         }

         if (var10 == 0) {
            this.bd(var1, var8, var9, var7, var16, var13, var11, var15, false);
         }

         if (this.ik.f()) {
            aw(var1, var8, var6 + 1.0F, var7 * 1.08F, 0.22F + 0.3F * var15, 0.0F, false, 0.0F, 0, 0.0F, var11);
         }

         this.bl(var1, var8, var6, var7, 1.0F, 0.0F, false, 0.0F, 0, 0.0F, -1);
         if (var10 == 0) {
            this.bd(var1, var8, var9, var7, var16, var13, var11, var15, true);
         } else if (var10 == 1) {
            float var20 = 0.88F + 0.12F * MathHelper.sin((double)(var13 * 3.0F));

            for (int var21 = 0; var21 < 12; var21++) {
               int var22 = var21 < 6 ? -1 : 1;
               int var23 = var21 % 6;
               float var24 = (var22 < 0 ? (float) Math.PI : 0.0F)
                  + (float)var22 * (((float)var23 - 2.5F) * 0.33F + 0.06F * MathHelper.sin((double)(var13 * 1.4F + (float)var23)));
               float var25 = var16 * (0.95F + 0.5F * ap(var23 + 3)) * var20;
               float var26 = var8 + MathHelper.cos((double)var24) * var25;
               float var27 = var9 - 0.1F * var7 + MathHelper.sin((double)var24) * var25 * 0.85F;
               ar(var1, var8, var9 - 0.1F * var7, var26, var27, 3.2F, (int)(30.0F + 70.0F * var15) << 24 | var11);
               ar(var1, var8, var9 - 0.1F * var7, var26, var27, 1.0F, 614553977 ^ -1029613191 | dn(var11, 1441089105 ^ 1427814830, 0.3F));
            }

            at(var1, var8, var9 - 0.1F * var7, 0.22F * var7, var11, 0.5F + 0.4F * var15);
         } else if (var10 == 3) {
            for (int var29 = 0; var29 < 14; var29++) {
               float var31 = (var13 * 0.45F + ap(var29)) % 1.0F;
               float var33 = ap(var29 + 40) * (float) (Math.PI * 2);
               float var35 = var8 + MathHelper.cos((double)var33) * var16 * (0.55F + 0.45F * ap(var29 + 7));
               float var37 = var6 - var31 * 2.2F * var7;
               float var39 = MathHelper.sin((double)(var31 * (float) Math.PI))
                  * (0.6F + 0.4F * MathHelper.sin((double)(var13 * 9.0F + (float)var29)));
               float var41 = (1.3F + 1.6F * ap(var29 + 11)) * var12;
               int var44 = (int)(Math.max(0.0F, var39) * 230.0F);
               aq(var1, var35, var37, var41 * 1.9F, 0.45F, 0.0F, var44 << 24 | dn(var11, -1303523395 ^ -1296945086, 0.3F));
               aq(var1, var35, var37, 0.45F, var41 * 1.9F, 0.0F, var44 << 24 | dn(var11, -1663136052 ^ -1675529933, 0.3F));
               aq(var1, var35, var37, var41 * 0.9F, var41 * 0.9F, (float) (Math.PI / 4), (int)((float)var44 * 0.25F * (0.4F + var15)) << 24 | var11);
            }
         } else if (var10 == 4 || var10 == 5) {
            this.be(var1, var8, var6, var7, var16, var13, var10, var11, var14, var15, true);
         } else if (var10 == 6) {
            int var30 = (int)(var13 * 9.0F);

            for (int var32 = 0; var32 < 4; var32++) {
               int var34 = var30 * 31 + var32 * 7;
               float var36 = var8 + (ap(var34) - 0.5F) * 0.9F * var7;
               float var38 = var6 - (1.6F + 0.4F * ap(var34 + 1)) * var7;
               byte var40 = 7;

               for (int var42 = 0; var42 < var40; var42++) {
                  float var45 = (float)var42 / ((float)var40 - 1.0F);
                  var17[var42] = var36 + (ap(var34 + 10 + var42) - 0.5F) * var16 * 0.8F * (var42 == 0 ? 0.0F : 1.0F) + var45 * (ap(var34 + 3) - 0.5F) * var7;
                  var18[var42] = var38 + var45 * 1.5F * var7;
                  var19[var42] = true;
               }

               float var43 = 0.55F + 0.45F * ap(var34 + 5);
               this.bx(var1, var40, (int)((50.0F + 90.0F * var15) * var43) << 24 | dn(var11, 1256112555 ^ 1249818964, 0.25F), 2.2F, 0);
               this.bx(var1, var40, (int)(240.0F * var43) << 24 | dn(var11, -1988840858 ^ -1987359335, 0.7F), 0.6F, 0);
            }
         }
      } catch (RuntimeException var28) {
         throw var28;
      }
   }

   private void bd(DrawContext var1, float var2, float var3, float var4, float var5, float var6, int var7, float var8, boolean var9) {

      try {
         for (int var10 = 0; var10 < 3; var10++) {
            float var11 = var3 + (float)(var10 - 1) * 0.55F * var4;
            float var12 = var5 * (1.0F - 0.12F * (float)var10);
            float var13 = (float)(var10 - 1) * 0.12F;

            for (int var14 = 0; var14 < 3; var14++) {
               float var15 = var6 * (1.5F + 0.35F * (float)var10) + (float)var14 * (float) (Math.PI * 2.0 / 3.0) + (float)var10;
               float var16 = MathHelper.sin((double)var15);
               float var17 = MathHelper.cos((double)var15);
               if (var16 > 0.0F == var9) {
                  float var18 = var2 + var17 * var12;
                  float var19 = var11 + var16 * var12 * 0.26F + var17 * var12 * var13;
                  float var20 = var9 ? 1.0F : 0.55F;

                  for (int var21 = 1; var21 <= 3; var21++) {
                     float var22 = var15 - 0.16F * (float)var21;
                     float var23 = var2 + MathHelper.cos((double)var22) * var12;
                     float var24 = var11 + MathHelper.sin((double)var22) * var12 * 0.26F + MathHelper.cos((double)var22) * var12 * var13;
                     aq(
                        var1,
                        var23,
                        var24,
                        1.3F - 0.25F * (float)var21,
                        1.3F - 0.25F * (float)var21,
                        (float) (Math.PI / 4),
                        (int)((float)((1698676281 ^ 1698676399) - 40 * var21) * var20) << 24 | var7
                     );
                  }

                  at(var1, var18, var19, 0.13F * var4 * (0.8F + 0.4F * var8), var7, var20);
               }
            }
         }
      } catch (RuntimeException var25) {
         throw var25;
      }
   }

   private void be(DrawContext var1, float var2, float var3, float var4, float var5, float var6, int var7, int var8, float var9, float var10, boolean var11) {

      float[] var12 = this.qg;
      float[] var13 = this.qh;
      boolean[] var14 = this.qi;

      try {
         float var15 = var7 == 4 ? 0.5F + 0.5F * MathHelper.sin((double)(var6 * 1.7F)) : var6 * 0.42F % 1.0F;
         float var16 = var3 - (0.08F + 1.92F * var15) * var4;
         float var17 = var5;
         float var18 = 0.27F;
         float var19 = var7 == 4 ? 0.0F : var6 * 2.4F;
         float var20 = var7 == 4 ? (float) (Math.PI * 2) : 2.4F;
         int var21 = 0;

         for (int var22 = 0; var22 <= 18 && var21 < 37; var22++) {
            float var23 = var19 + var20 * (float)var22 / 18.0F;
            float var24 = MathHelper.sin((double)var23);
            boolean var25 = var24 >= 0.0F;
            var12[var21] = var2 + MathHelper.cos((double)var23) * var17;
            var13[var21] = var16 + var24 * var17 * var18;
            var14[var21] = var25 == var11;
            var21++;
         }

         float var27 = var7 == 5 ? MathHelper.sin((double)(var15 * (float) Math.PI)) : 1.0F;
         this.bx(var1, var21, (int)((40.0F + 90.0F * var10) * var27) << 24 | var8, 3.0F, 0);
         this.bx(var1, var21, (int)(235.0F * var27) << 24 | dn(var8, 921033951 ^ 907682592, 0.35F), 0.8F, 0);
         if (var9 > 0.01F) {
            for (int var28 = 0; var28 < var21; var28++) {
               var13[var28] += 2.6F;
            }

            this.bx(var1, var21, (int)(110.0F * var9 * var27) << 24 | var8, 2.2F, 0);
         }
      } catch (RuntimeException var26) {
         throw var26;
      }
   }

   private void bf(DrawContext var1, int var2, int var3, int var4, int var5) {

      assert var1 != null && var4 > 0 && var5 > 0 && this.qg.length == 37 : "h" + "at: bad contr" + "act";

      try {
         af(var1, var2, var3, var4, var5, 1155575560 ^ 1157532476, 1815099905 ^ 1815754259);
         float var6 = (float)var3 + (float)var5 * 0.92F;
         float var7 = (float)var5 * 0.25F;
         ax(var1, var2, var4, var6);
         int var8 = ay(this.iq);
         int var9 = k(this.in);
         float var10 = (float)(ms() % 3600000L) / 1000.0F;
         float var11 = 0.62F * var7 * this.io.h();
         float var12 = this.ip.h() * var7 * 1.5F + 2.0F;

         for (int var13 = 0; var13 < 2; var13++) {
            float var14 = (float)var2 + (float)var4 * (var13 == 0 ? 0.42F : 0.64F);
            float var15 = var13 == 0 ? 1.0F : 0.72F;
            aq(var1, var14, var6, var7 * 0.42F, 1.1F, 0.0F, -1116737704 ^ -177213608);
            if (var13 == 0 || var9 != 0) {
               av(var1, var14, var6, var7 * 0.7F, var8, 0.45F * var15);
            }

            this.bl(var1, var14, var6, var7, var15, 0.0F, false, 0.0F, 0, 0.0F, -1);
            if (var13 != 1 || var9 != 0) {
               float var16 = var6 - 2.0F * var7 - 0.08F * var7 + MathHelper.sin((double)(var10 * 2.0F + (float)var13)) * 0.3F;
               float var17 = var16 - var12;
               int var18 = dn(var8, -1865391064 ^ -1875928105, 0.3F);

               for (int var19 = 0; var19 < 8; var19++) {
                  float var20 = (float)var19 / 8.0F;
                  float var21 = (float)(var19 + 1) / 8.0F;
                  float var22 = (var20 + var21) * 0.5F;
                  aq(
                     var1,
                     var14,
                     var17 + var12 * var22,
                     var11 * var22,
                     var12 / 16.0F + 0.15F,
                     0.0F,
                     (int)(var15 * (120.0F + 60.0F * (1.0F - var22))) << 24 | dn(var18, var8, var22)
                  );
               }

               ar(var1, var14 - var11, var16, var14, var17, 0.7F, (int)(var15 * 220.0F) << 24 | var18);
               ar(var1, var14 + var11, var16, var14, var17, 0.7F, (int)(var15 * 220.0F) << 24 | var18);
               int var24 = this.ak(var14, var16, var11, var11 * 0.24F);
               this.bx(var1, var24, (int)(var15 * 230.0F) << 24 | var8, 0.7F, (int)(var15 * 60.0F) << 24 | var8);
               float var25 = var10 * 2.2F + (float)var13 * 1.7F;
               at(
                  var1,
                  var14 + MathHelper.cos((double)var25) * var11,
                  var16 + MathHelper.sin((double)var25) * var11 * 0.24F,
                  2.2F,
                  var18,
                  MathHelper.sin((double)var25) > 0.0F ? var15 : var15 * 0.35F
               );
            }
         }
      } catch (RuntimeException var23) {
         throw var23;
      }
   }

   private void bg(DrawContext var1, int var2, int var3, int var4, int var5) {

      assert var1 != null && var4 > 0 && var5 > 0 : "tra" + "ils: bad con" + "tra" + "ct";

      try {
         af(var1, var2, var3, var4, var5, -975706961 ^ -976633701, 1128316050 ^ 1128968320);
         float var6 = (float)var3 + (float)var5 * 0.88F;
         float var7 = (float)var5 * 0.3F;
         float var8 = (float)var2 + (float)var4 * 0.7F;
         ax(var1, var2, var4, var6);
         int var9 = k(this.is);
         int var10 = ay(this.ix);
         float var11 = (float)(ms() % 3600000L) / 1000.0F;
         float var12 = this.iu.h();
         float var13 = (float)(this.iv.p() / 100.0);
         float var14 = (float)(this.iw.p() / 100.0);
         float var15 = 4.3F * var7;

         for (int var16 = 0; var16 < 10; var16++) {
            float var17 = var8 - (var11 * var15 + (float)var16 * 0.9F * var7) % ((float)var4 + 0.9F * var7) + (float)var4 * 0.3F;
            if (var17 > (float)(var2 + 2) && var17 < (float)(var2 + var4 - 6)) {
               var1.fill(Math.round(var17), Math.round(var6) + 2, Math.round(var17) + 4, Math.round(var6) + 3, -1298797425 ^ -1368779920);
            }
         }

         float var31 = MathHelper.abs(MathHelper.sin((double)(var11 * 8.6F))) * 1.2F;
         float var32 = var6 - 2.0F * var7 * var13 - var31;
         float var18 = Math.min(var12 * var15, var8 - (float)var2 - 4.0F);
         if (var9 == 0 || var9 == 2) {
            byte var19 = 16;

            for (int var20 = 0; var20 < var19; var20++) {
               float var21 = (float)var20 / (float)var19;
               float var22 = (float)(var20 + 1) / (float)var19;
               float var23 = var8 - var21 * var18;
               float var24 = var8 - var22 * var18;
               float var25 = var32 + MathHelper.sin((double)(var11 * 8.6F - var21 * 6.0F)) * 1.1F * var21;
               float var26 = var32 + MathHelper.sin((double)(var11 * 8.6F - var22 * 6.0F)) * 1.1F * var22;
               float var27 = (1.0F - var21) * (1.0F - var21);
               ar(var1, var23, var25 + 0.16F * var7, var24, var26 + 0.16F * var7, 0.32F * var7, (int)(var14 * 150.0F * var27) << 24 | var10);
               ar(var1, var23, var25, var24, var26, 1.1F, (int)(Math.min(1.0F, var14 * 1.6F) * 235.0F * var27) << 24 | dn(var10, 127730416 ^ 123927823, 0.3F));
            }
         }

         if (var9 == 1 || var9 == 2) {
            float var33 = 0.14F;
            int var34 = (int)Math.floor((double)(var11 / var33));
            int var35 = Math.min(20, (int)(var12 / var33) + 1);

            for (int var36 = 0; var36 < var35; var36++) {
               int var37 = var34 - var36;
               float var38 = var11 - (float)var37 * var33;
               if (!(var38 < 0.0F) && !(var38 > var12)) {
                  float var39 = var38 / var12;
                  float var40 = var8 - 0.25F * var7 - var38 * var15;
                  float var41 = var32 + (ap(var37) - 0.5F) * 0.5F * var7 - var38 * 5.0F;
                  if (!(var40 < (float)(var2 + 2))) {
                     int var28 = (int)(var14 * 255.0F * (1.0F - var39) * Math.min(1.0F, var38 / 0.08F));
                     float var29 = 1.8F + 1.2F * ap(var37 + 9);
                     aq(var1, var40, var41, var29, var29, (float) (Math.PI / 4) + var38 * 2.0F, var28 << 24 | var10);
                     aq(var1, var40, var41, var29 * 0.4F, var29 * 0.4F, (float) (Math.PI / 4), var28 << 24 | dn(var10, 1249549373 ^ 1250255810, 0.6F));
                  }
               }
            }
         }

         aq(var1, var8, var6, var7 * 0.36F, 1.1F, 0.0F, -634721216 ^ -1842680768);
         this.bl(var1, var8, var6 - var31, var7, 1.0F, 0.0F, true, var11 * 8.6F, 0, 0.0F, -1);
      } catch (RuntimeException var30) {
         throw var30;
      }
   }

   private void bh(DrawContext var1, int var2, int var3, int var4, int var5) {

      assert var1 != null && var4 > 0 && var5 > 0 : "hits: " + "bad contract";

      try {
         af(var1, var2, var3, var4, var5, -632368038 ^ -632229778, -287130903 ^ -286738693);
         float var6 = (float)var3 + (float)var5 * 0.88F;
         float var7 = (float)var5 * 0.33F;
         float var8 = (float)var2 + (float)var4 * 0.56F;
         ax(var1, var2, var4, var6);
         int var9 = k(this.iz);
         int var10 = ay(this.jb);
         int var11 = Math.max(1, Math.min(24, this.ja.g()));
         float var12 = (float)(ms() % 3600000L) / 1000.0F;
         float var13 = 1.4F;
         int var14 = (int)(var12 / var13);
         float var15 = var12 - (float)var14 * var13;
         float var16 = var15 < 0.3F ? 1.0F - var15 / 0.3F : 0.0F;
         float var17 = var15 < 0.25F ? MathHelper.sin((double)(var15 / 0.25F * (float) Math.PI)) * 2.5F : 0.0F;
         aq(var1, var8 + var17, var6, var7 * 0.42F, 1.2F, 0.0F, 1213105614 ^ 407799246);
         this.bl(var1, var8 + var17, var6, var7, 1.0F, 0.0F, false, 0.0F, 836722244 ^ 826238078, 0.45F * var16, -1);
         if (var15 < 0.16F) {
            float var18 = var15 / 0.16F;
            float var19 = var8 - 0.9F * var7;
            float var20 = var6 - 1.3F * var7;

            for (int var21 = 0; var21 < 4; var21++) {
               float var22 = -1.2F + (var18 * 2.0F - 0.6F) + (float)var21 * 0.12F;
               float var23 = var22 + 0.12F;
               ar(
                  var1,
                  var19 + MathHelper.cos((double)var22) * 0.8F * var7,
                  var20 + MathHelper.sin((double)var22) * 0.8F * var7,
                  var19 + MathHelper.cos((double)var23) * 0.8F * var7,
                  var20 + MathHelper.sin((double)var23) * 0.8F * var7,
                  1.0F,
                  (int)(200.0F * (1.0F - var18) * (float)(var21 + 1) / 4.0F) << 24 | -1059588174 ^ -1071118259
               );
            }
         }

         float var32 = var8 - 0.3F * var7;
         float var33 = var6 - 1.25F * var7;
         float var34 = 0.95F;
         if (var15 < 0.18F) {
            at(var1, var32, var33, (0.18F + var15) * var7 * 0.8F, var10, 1.0F - var15 / 0.18F);
         }

         if (var15 < var34) {
            float var35 = var15 / var34;
            float var36 = 1.0F - var35 * var35;

            for (int var37 = 0; var37 < var11; var37++) {
               int var24 = var14 * 97 + var37 * 13;
               float var25 = (float) -Math.PI * (0.08F + 0.84F * ap(var24)) - (ap(var24 + 1) - 0.5F) * 0.5F;
               float var26 = (1.1F + 1.3F * ap(var24 + 2)) * var7;
               if (var9 != 1) {
                  float var27 = var32 + MathHelper.cos((double)var25) * var26 * var15;
                  float var28 = var33 + MathHelper.sin((double)var25) * var26 * var15 + 2.4F * var7 * var15 * var15;
                  if (var28 < var6 - 1.0F) {
                     aq(
                        var1,
                        var27,
                        var28,
                        2.6F,
                        1.0F,
                        var15 * (6.0F + 6.0F * ap(var24 + 3)) + var25,
                        (int)(230.0F * var36) << 24 | dn(var10, -1107137462 ^ -1090677835, 0.25F * ap(var24 + 4))
                     );
                  }
               }

               if (var9 != 0) {
                  float var38 = var25 + (var9 == 2 ? 0.3F : 0.0F);
                  float var39 = 1.0F - (1.0F - var35) * (1.0F - var35);
                  float var29 = var39 * var26 * 0.75F;
                  float var30 = Math.max(0.0F, var29 - (4.0F + 4.0F * ap(var24 + 5)) * (1.0F - var35));
                  ar(
                     var1,
                     var32 + MathHelper.cos((double)var38) * var30,
                     var33 + MathHelper.sin((double)var38) * var30,
                     var32 + MathHelper.cos((double)var38) * var29,
                     var33 + MathHelper.sin((double)var38) * var29,
                     0.8F,
                     (int)(240.0F * var36) << 24 | dn(var10, 451778813 ^ 437413634, 0.45F)
                  );
               }
            }
         }
      } catch (RuntimeException var31) {
         throw var31;
      }
   }

   private void bi(DrawContext var1, int var2, int var3, int var4, int var5) {

      assert var1 != null && var4 > 0 && var5 > 0 : "p" + "a" + "rticles" + ": bad contract";

      try {
         af(var1, var2, var3, var4, var5, 357208984 ^ 357741483, -1331401959 ^ -1331469802);
         float var6 = (float)var3 + (float)var5 * 0.9F;
         float var7 = (float)var5 * 0.26F;
         float var8 = (float)var2 + (float)var4 * 0.5F;
         ax(var1, var2, var4, var6);
         int var9 = ay(this.jj);
         float var10 = (float)(ms() % 3600000L) / 1000.0F;
         float var11 = (float)(this.ji.p() / 100.0);
         if (this.jh.f()) {
            int var12 = Math.max(1, Math.round(3.0F * var11));

            for (int var13 = 0; var13 < var12; var13++) {
               float var14 = (float)(var2 + 12) + ap(var13 + (188961108 ^ 188960888)) * (float)(var4 - 60);
               float var15 = (float)(var3 + 8) + ap(var13 + (-1853683584 ^ -1853683274)) * (float)var5 * 0.55F;
               float var16 = 22.0F + 26.0F * ap(var13 + (143483194 ^ 143483002));
               float var17 = 8.0F + 12.0F * ap(var13 + (-1993020697 ^ -1993020499));
               int var18 = (int)(60.0F + 40.0F * MathHelper.sin((double)(var10 * 1.3F + (float)var13)));
               ar(var1, var14, var15, var14 + var16, var15, 0.6F, var18 << 24 | var9);
               ar(var1, var14 + var16, var15, var14 + var16, var15 + var17, 0.6F, var18 << 24 | var9);
               aq(var1, var14, var15, 1.1F, 1.1F, 0.0F, var18 + 60 << 24 | var9);
               aq(var1, var14 + var16, var15 + var17, 1.1F, 1.1F, 0.0F, var18 + 60 << 24 | var9);
               float var19 = (var10 * 0.6F + ap(var13 + (-1696862723 ^ -1696863063))) % 1.0F;
               float var20 = var19 * (var16 + var17);
               float var21 = var20 < var16 ? var14 + var20 : var14 + var16;
               float var22 = var20 < var16 ? var15 : var15 + (var20 - var16);
               at(var1, var21, var22, 2.0F, var9, 0.9F);
            }
         }

         if (this.jf.f()) {
            int var26 = Math.round(22.0F * var11);

            for (int var30 = 0; var30 < var26; var30++) {
               float var34 = (float)var2 + (ap(var30) * (float)var4 + var10 * (3.0F + 5.0F * ap(var30 + 50))) % (float)var4;
               float var38 = (float)(var3 + 3) + ap(var30 + 100) * (float)(var5 - 8) + MathHelper.sin((double)(var10 * 0.8F + (float)var30)) * 2.0F;
               var1.fill(
                  Math.round(var34),
                  Math.round(var38),
                  Math.round(var34) + 1,
                  Math.round(var38) + 1,
                  (int)(70.0F + 80.0F * ap(var30 + (554938014 ^ 554937864))) << 24 | dn(var9, -1152256116 ^ -1146222477, 0.5F)
               );
            }
         }

         if (this.jd.f()) {
            int var27 = Math.max(1, Math.round(5.0F * var11));

            for (int var31 = 0; var31 < var27; var31++) {
               float var35 = (float)(var2 + 10) + ap(var31 + (-1151667746 ^ -1151667946)) * (float)(var4 - 20);
               float var39 = (float)(var3 + 10)
                  + ap(var31 + (1497050796 ^ 1497050750)) * (float)var5 * 0.6F
                  + MathHelper.sin((double)(var10 * 0.9F + (float)var31 * 1.7F)) * 3.0F;
               float var42 = 3.0F + 2.5F * ap(var31 + (-996873933 ^ -996873745));
               float var45 = var10 * (0.5F + 0.6F * ap(var31 + (1179176020 ^ 1179176114))) + (float)var31;
               int var48 = (int)(150.0F + 70.0F * ap(var31 + (-885764575 ^ -885764399)));

               for (int var51 = 0; var51 < 4; var51++) {
                  float var53 = var45 + (float)var51 * (float) (Math.PI / 2);
                  float var55 = var53 + (float) (Math.PI / 2);
                  ar(
                     var1,
                     var35 + MathHelper.cos((double)var53) * var42 * 1.41F,
                     var39 + MathHelper.sin((double)var53) * var42 * 1.41F,
                     var35 + MathHelper.cos((double)var55) * var42 * 1.41F,
                     var39 + MathHelper.sin((double)var55) * var42 * 1.41F,
                     0.6F,
                     var48 << 24 | var9
                  );
               }

               aq(var1, var35, var39, var42, var42, var45 + (float) (Math.PI / 4), -1281017636 ^ -1348126500 | var9);
            }
         }

         if (this.je.f()) {
            int var28 = Math.max(1, Math.round(7.0F * var11));

            for (int var32 = 0; var32 < var28; var32++) {
               float var36 = (float)(var2 + 8) + ap(var32 + (-1175606927 ^ -1175607071)) * (float)(var4 - 16);
               float var40 = (float)(var3 + 6)
                  + ap(var32 + (-730833419 ^ -730833809)) * (float)var5 * 0.7F
                  - (var10 * 3.0F + ap(var32 + (1256696565 ^ 1256696657)) * (float)var5) % ((float)var5 * 0.15F);
               float var43 = 0.5F
                  + 0.5F * MathHelper.sin((double)(var10 * (2.0F + 2.0F * ap(var32 + (1019976843 ^ 1019976997))) + (float)var32 * 2.1F));
               float var46 = (2.0F + 2.4F * ap(var32 + (-961398856 ^ -961399296))) * (0.6F + 0.4F * var43);
               int var49 = (int)(90.0F + 160.0F * var43);
               aq(var1, var36, var40, var46, 0.45F, 0.0F, var49 << 24 | dn(var9, -1411559828 ^ -1423789677, 0.4F));
               aq(var1, var36, var40, 0.45F, var46, 0.0F, var49 << 24 | dn(var9, -1640806916 ^ -1630750205, 0.4F));
            }
         }

         if (this.jg.f()) {
            float var29 = 2.6F / Math.max(0.3F, var11);
            int var33 = (int)(var10 / var29);
            float var37 = (var10 - (float)var33 * var29) / Math.min(var29, 1.3F);
            if (var37 < 1.0F) {
               float var41 = (float)var2 + (float)var4 * (0.1F + 0.5F * ap(var33 + (-1404798438 ^ -1404797970)));
               float var44 = (float)(var3 + 4);
               float var47 = var41 + (float)var4 * 0.45F;
               float var50 = (float)var3 + (float)var5 * 0.55F;
               float var52 = var41 + (var47 - var41) * var37;
               float var54 = var44 + (var50 - var44) * var37;
               float var56 = MathHelper.sin((double)(var37 * (float) Math.PI));

               for (int var57 = 0; var57 < 4; var57++) {
                  float var23 = Math.max(0.0F, var37 - 0.06F * (float)var57);
                  float var24 = Math.max(0.0F, var37 - 0.06F * (float)(var57 + 1));
                  ar(
                     var1,
                     var41 + (var47 - var41) * var23,
                     var44 + (var50 - var44) * var23,
                     var41 + (var47 - var41) * var24,
                     var44 + (var50 - var44) * var24,
                     1.4F - 0.25F * (float)var57,
                     (int)(var56 * (float)((992927754 ^ 992927938) - 45 * var57)) << 24 | var9
                  );
               }

               at(var1, var52, var54, 3.0F, var9, var56);
            }
         }

         aq(var1, var8, var6, var7 * 0.42F, 1.1F, 0.0F, 1122796174 ^ 49054350);
         this.bl(var1, var8, var6, var7, 0.9F, 0.0F, false, 0.0F, 0, 0.0F, -1);
      } catch (RuntimeException var25) {
         throw var25;
      }
   }

   private void bj(DrawContext var1, int var2, int var3, int var4, int var5) {

      assert var1 != null && var4 > 0 && var5 > 0 && this.qg.length == 37 : "death: bad contract";

      try {
         af(var1, var2, var3, var4, var5, -1264185670 ^ -1262998898, -2054393625 ^ -2054783755);
         float var6 = (float)var3 + (float)var5 * 0.88F;
         float var7 = (float)var5 * 0.32F;
         float var8 = (float)var2 + (float)var4 * 0.5F;
         ax(var1, var2, var4, var6);
         int var9 = ay(this.jp);
         float var10 = this.jq.h();
         float var11 = (float)(this.js.p() / 100.0);
         boolean var12 = this.jt.f();
         boolean var13 = this.jv.f();
         float var14 = (float)(ms() % 3600000L) / 1000.0F;
         float var15 = 3.3F;
         int var16 = (int)(var14 / var15);
         int var17 = k(this.jn);
         if (var17 >= 6) {
            var17 = var16 % 6;
         }

         float var18 = var14 - (float)var16 * var15;
         float var19 = 0.6F;
         float var20 = 1.9F;
         float var21 = var19 + var20;
         float var22 = var18 - var19;
         float var23 = 0.0F;
         float var24 = 1.0F;
         float var25 = 0.0F;
         float var26 = 1.0F;
         if (var22 >= 0.0F && var18 < var21) {
            float var27 = Math.min(1.0F, var22 / 0.45F);
            var23 = (float) (-Math.PI / 2) * var27 * var27;
            var25 = 0.75F;
            var24 = var12 ? Math.max(0.0F, 1.0F - var22 / 0.12F) : (var22 < 1.0F ? 1.0F : Math.max(0.0F, 1.0F - (var22 - 1.0F) / 0.25F));
            if (var17 == 2) {
               var24 = Math.max(0.0F, 1.0F - var22 / 0.08F);
            }
         } else if (var18 >= var21) {
            var26 = Math.min(1.0F, (var18 - var21) / 0.45F);
            var24 = var26;
         }

         float var28 = var6 - var7;
         if (var22 >= 0.0F && var22 < var20) {
            float var29 = var22 / var20;
            au(var1, var8, var28, var7 * 1.6F * var10, var9, 0.6F * (var29 < 0.2F ? var29 / 0.2F : 1.0F - (var29 - 0.2F) / 0.8F));
            this.bk(var1, var17, var22, var20, var8, var6, var8, var28, var7, var10, var11, var9, var16, var3);
         }

         aq(var1, var8, var6, var7 * 0.42F * Math.max(0.2F, var24), 1.2F, 0.0F, (int)(80.0F * var24) << 24);
         if (var26 < 1.0F) {
            at(var1, var8, var6 - var7 * var26, var7 * 0.7F, var9, 0.6F * (1.0F - var26));
         }

         this.bl(var1, var8, var6, var7 * (0.6F + 0.4F * var26), var24, var23, false, 0.0F, -1581385756 ^ -1587165228, var25, -1);
         if (var13 && var22 >= 0.0F && var22 < 0.5F) {
            float var33 = 1.0F - var22 / 0.5F;
            int var30 = (int)(var33 * var33 * 80.0F);
            var1.fill(var2, var3, var2 + var4, var3 + var5, var30 << 24 | var9);
            int var31 = (int)(var33 * var33 * 120.0F);
            var1.fill(var2, var3, var2 + 6, var3 + var5, var31 << 24 | var9);
            var1.fill(var2 + var4 - 6, var3, var2 + var4, var3 + var5, var31 << 24 | var9);
         }
      } catch (RuntimeException var32) {
         throw var32;
      }
   }

   private void bk(
      DrawContext var1,
      int var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      int var12,
      int var13,
      int var14
   ) {

      float[] var15 = this.qg;
      float[] var16 = this.qh;
      boolean[] var17 = this.qi;
      float var18 = var3 / var4;
      float var19 = var18 < 0.7F ? 1.0F : 1.0F - (var18 - 0.7F) / 0.3F;
      int var20 = Math.max(0, Math.min(28, Math.round(14.0F * var11)));

      try {
         if (var2 == 0) {
            float var21 = (1.0F - (1.0F - var18) * (1.0F - var18)) * 0.75F * var9;
            aw(var1, var5, var6 - var21, var9 * 0.95F * var10, 0.42F * var19, 0.0F, false, 0.0F, 0, 0.0F, dn(var12, 1351516824 ^ 1349614951, 0.35F));

            for (int var22 = 0; var22 < Math.max(3, var20 / 2); var22++) {
               float var23 = var3 * 3.0F + (float)var22 * 1.3F;
               float var24 = (var18 + ap(var22 + var13 * 7) * 0.4F) % 1.0F;
               at(
                  var1,
                  var5 + MathHelper.cos((double)var23) * 0.55F * var9 * var10,
                  var6 - 0.3F * var9 - var24 * 2.2F * var9,
                  1.8F,
                  var12,
                  var19 * (1.0F - var24)
               );
            }
         } else if (var2 == 1) {
            for (int var33 = 0; var33 < 3; var33++) {
               float var39 = (var3 - (float)var33 * 0.18F) / 1.2F;
               if (!(var39 <= 0.0F) && !(var39 >= 1.0F)) {
                  float var46 = (1.0F - (1.0F - var39) * (1.0F - var39) * (1.0F - var39)) * 2.4F * var9 * var10;
                  int var53 = this.ak(var5, var6, var46, var46 * 0.3F);
                  int var25 = (int)((1.0F - var39) * 230.0F);
                  this.bx(var1, var53, var25 << 24 | var12, 1.2F + (1.0F - var39) * 1.2F, var25 / 4 << 24 | var12);
               }
            }

            if (var3 < 0.35F) {
               float var34 = 1.0F - var3 / 0.35F;
               aq(var1, var5, var6 - var9, 0.22F * var9 * var10, var9 * 1.2F, 0.0F, (int)(var34 * 150.0F) << 24 | dn(var12, 427767715 ^ 427870300, 0.5F));
            }
         } else if (var2 == 2) {
            int var35 = Math.max(6, var20 + 6);

            for (int var40 = 0; var40 < var35; var40++) {
               int var47 = var13 * (1972884177 ^ 1972884050) + var40 * 17;
               float var54 = (ap(var47) - 0.5F) * 0.9F * var9;
               float var61 = -ap(var47 + 1) * 2.0F * var9;
               float var26 = (ap(var47 + 2) - 0.5F) * 2.6F * var9 * var10;
               float var27 = -(0.6F + 1.2F * ap(var47 + 3)) * var9 * var10;
               float var28 = var5 + var54 + var26 * var3;
               float var29 = var6 + var61 + var27 * var3 + 3.2F * var9 * var3 * var3;
               var29 = Math.min(var29, var6 - 1.5F);
               float var30 = (1.6F + 2.2F * ap(var47 + 4)) * (var9 / 22.0F);
               int var31 = ap(var47 + 5) < 0.5F ? dn(1700375663 ^ 1701047867, var12, 0.35F) : dn(var12, 371941355 ^ 383033364, 0.2F);
               aq(var1, var28, var29, var30, var30, var3 * (5.0F + 4.0F * ap(var47 + 6)), (int)(240.0F * var19) << 24 | var31);
            }
         } else if (var2 == 3) {
            int var36 = (int)(var3 * 16.0F);
            float var41 = var7 + (ap(var13 * 7 + 1) - 0.5F) * 0.6F * var9;
            float var48 = (float)(var14 + 1);
            byte var55 = 9;

            for (int var62 = 0; var62 < var55; var62++) {
               float var67 = (float)var62 / ((float)var55 - 1.0F);
               var15[var62] = var41
                  + (var7 - var41) * var67
                  + (var62 != 0 && var62 != var55 - 1 ? (ap(var36 * 13 + var62) - 0.5F) * 0.7F * var9 * var10 : 0.0F);
               var16[var62] = var48 + (var6 - 1.4F * var9 - var48) * var67;
               var17[var62] = true;
            }

            float var63 = var3 < 0.5F ? 1.0F : Math.max(0.0F, 1.0F - (var3 - 0.5F) / 0.5F);
            float var68 = var63 * (0.7F + 0.3F * ap(var36 + 77));
            this.bx(var1, var55, (int)(110.0F * var68) << 24 | dn(var12, -1801914714 ^ -1808232871, 0.3F), 3.0F * var10, 0);
            this.bx(var1, var55, (int)(250.0F * var68) << 24 | dn(var12, -567130860 ^ -556942613, 0.75F), 0.9F, 0);
            if (var3 < 0.25F) {
               at(var1, var7, var6 - 1.4F * var9, 0.9F * var9 * var10, var12, 1.0F - var3 / 0.25F);
            }

            for (int var70 = 0; var70 < Math.max(3, var20 / 3); var70++) {
               float var71 = (float) -Math.PI * ap(var13 * 11 + var70);
               float var73 = (0.3F + var3 * 1.6F) * var9 * var10;
               ar(
                  var1,
                  var7,
                  var6 - 1.4F * var9,
                  var7 + MathHelper.cos((double)var71) * var73,
                  var6 - 1.4F * var9 + MathHelper.sin((double)var71) * var73,
                  0.7F,
                  (int)(200.0F * var63) << 24 | dn(var12, -217054909 ^ -202375492, 0.5F)
               );
            }
         } else if (var2 == 4) {
            float var37 = 1.0F - (1.0F - var18) * (1.0F - var18);
            at(var1, var7, var8, (0.3F + 1.1F * var37) * var9 * var10, var12, var19);

            for (int var42 = 0; var42 < 12; var42++) {
               float var49 = (float)var42 * (float) (Math.PI / 6) + var3 * 0.6F;
               float var56 = 0.25F * var9;
               float var64 = var56 + var37 * (1.4F + 0.6F * ap(var42 + var13)) * var9 * var10;
               ar(
                  var1,
                  var7 + MathHelper.cos((double)var49) * var56,
                  var8 + MathHelper.sin((double)var49) * var56,
                  var7 + MathHelper.cos((double)var49) * var64,
                  var8 + MathHelper.sin((double)var49) * var64,
                  1.2F,
                  (int)(200.0F * var19) << 24 | dn(var12, -752697868 ^ -740474357, 0.4F)
               );
            }

            for (int var43 = 0; var43 < var20; var43++) {
               float var50 = ap(var13 * 29 + var43) * (float) (Math.PI * 2);
               float var57 = var37 * (0.6F + 1.6F * ap(var13 * 29 + var43 + 50)) * var9 * var10;
               aq(
                  var1,
                  var7 + MathHelper.cos((double)var50) * var57,
                  var8 + MathHelper.sin((double)var50) * var57,
                  1.0F,
                  1.0F,
                  (float) (Math.PI / 4),
                  (int)(220.0F * var19) << 24 | dn(var12, 604196101 ^ 620540666, 0.3F)
               );
            }
         } else {
            float var38 = Math.min(1.0F, var3 / 0.35F) * 1.2F * var9 * var10 * (var18 > 0.75F ? 1.0F - (var18 - 0.75F) / 0.25F : 1.0F);
            if (var38 > 0.5F) {
               float var44 = var38 * 0.3F;
               int var51 = Math.max(2, Math.min(24, Math.round(2.0F * var44)));

               for (int var58 = 0; var58 < var51; var58++) {
                  float var65 = -var44 + ((float)var58 + 0.5F) * (2.0F * var44 / (float)var51);
                  float var69 = 1.0F - var65 * var65 / (var44 * var44);
                  if (var69 > 0.0F) {
                     aq(var1, var5, var6 + var65, var38 * (float)Math.sqrt((double)var69), var44 / (float)var51 + 0.1F, 0.0F, 98056997 ^ -841140179);
                  }
               }

               int var59 = this.ak(var5, var6, var38, var38 * 0.3F);
               this.bx(var1, var59, 2144821630 ^ -1344839298 | dn(var12, -555704345 ^ -563436776, 0.4F), 1.2F, 1374417025 ^ 300675201 | var12);
            }

            for (int var45 = 0; var45 < Math.max(4, var20); var45++) {
               float var52 = (var3 * 0.9F + ap(var13 * 3 + var45)) % 1.0F;
               float var60 = ap(var45 + 60) * (float) (Math.PI * 2) + var52 * 4.0F;
               float var66 = (1.0F - var52) * 1.6F * var9 * var10;
               aq(
                  var1,
                  var5 + MathHelper.cos((double)var60) * var66,
                  var6 - 0.2F * var9 - (1.0F - var52) * 1.2F * var9 * ap(var45 + 90),
                  1.0F,
                  1.0F,
                  (float) (Math.PI / 4),
                  (int)(220.0F * var52 * var19) << 24 | dn(var12, 1524553223 ^ 1515514616, 0.4F)
               );
            }
         }
      } catch (RuntimeException var32) {
         throw var32;
      }
   }

   private void bl(DrawContext var1, float var2, float var3, float var4, float var5, float var6, boolean var7, float var8, int var9, float var10, int var11) {

      ClientPlayerEntity var12 = a.player;
      SkinTextures var13 = null;
      Identifier var14 = null;
      boolean var15 = false;
      if (var11 < 0 && var12 != null) {
         try {
            var13 = var12.getSkin();
            var14 = var13.body().texturePath();
            var15 = var13.model() == PlayerSkinType.SLIM;
         } catch (Throwable var29) {
            var14 = null;
         }
      }

      if (var14 == null) {
         aw(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11);
      } else {
         int var16 = (int)(Math.max(0.0F, Math.min(1.0F, var5)) * 255.0F);
         if (var16 >= 3) {
            int var17 = var16 << 24 | dn(-876906478 ^ -884701203, var9, var10);
            int var18 = var16 << 24 | dn(dn(644803726 ^ 647041905, var9, var10), 0, 0.38F);
            Matrix3x2fStack var19 = var1.getMatrices();
            var19.pushMatrix();

            try {
               float var20 = var4 / 16.0F;
               if (var6 == 0.0F) {
                  float var21 = Math.abs(var19.m00) * (float)a.getWindow().getScaleFactor();
                  if (var21 > 0.01F) {
                     float var22 = Math.max(1.0F, (float)Math.round(var20 * var21));
                     var20 = var22 / var21;
                     var2 = (float)Math.round(var2 * var21) / var21;
                     var3 = (float)Math.round(var3 * var21) / var21;
                  }
               }

               var19.translate(var2, var3);
               if (var6 != 0.0F) {
                  var19.rotate(var6);
               }

               var19.scale(var20, var20);
               int var31 = var15 ? 3 : 4;
               if (var7) {
                  float var32 = MathHelper.sin((double)var8) * 0.55F;
                  bm(var1, var14, 0.0F, -22.0F, var32, -2, 0, 4, 12, 32, 52, 48, 52, var18);
                  bm(var1, var14, 0.0F, -12.0F, -var32, -2, 0, 4, 12, 16, 52, 0, 52, var18);
                  bm(var1, var14, 0.0F, -12.0F, var32, -2, 0, 4, 12, 0, 20, 0, 36, var17);
                  bm(var1, var14, 0.0F, 0.0F, 0.0F, -2, -24, 4, 12, 16, 20, 16, 36, var17);
                  bm(var1, var14, 0.0F, 0.0F, 0.0F, -4, -32, 8, 8, 0, 8, 32, 8, var17);
                  bm(var1, var14, 0.0F, -22.0F, -var32, -2, 0, 4, 12, 40, 20, 40, 36, var17);
               } else {
                  bm(var1, var14, 0.0F, 0.0F, 0.0F, -4, -12, 4, 12, 4, 20, 4, 36, var17);
                  bm(var1, var14, 0.0F, 0.0F, 0.0F, 0, -12, 4, 12, 20, 52, 4, 52, var17);
                  bm(var1, var14, 0.0F, 0.0F, 0.0F, -4, -24, 8, 12, 20, 20, 20, 36, var17);
                  bm(var1, var14, 0.0F, 0.0F, 0.0F, -4 - var31, -24, var31, 12, 44, 20, 44, 36, var17);
                  bm(var1, var14, 0.0F, 0.0F, 0.0F, 4, -24, var31, 12, 36, 52, 52, 52, var17);
                  bm(var1, var14, 0.0F, 0.0F, 0.0F, -4, -32, 8, 8, 8, 8, 40, 8, var17);
               }
            } catch (Throwable var27) {
            } finally {
               var19.popMatrix();
            }
         }
      }
   }

   private static void bm(
      DrawContext var0,
      Identifier var1,
      float var2,
      float var3,
      float var4,
      int var5,
      int var6,
      int var7,
      int var8,
      int var9,
      int var10,
      int var11,
      int var12,
      int var13
   ) {

      Matrix3x2fStack var14 = var0.getMatrices();
      var14.pushMatrix();

      try {
         if (var2 != 0.0F || var3 != 0.0F) {
            var14.translate(var2, var3);
         }

         if (var4 != 0.0F) {
            var14.rotate(var4);
         }

         var0.drawTexture(RenderPipelines.GUI_TEXTURED, var1, var5, var6, (float)var9, (float)var10, var7, var8, var7, var8, 64, 64, var13);
         var0.drawTexture(RenderPipelines.GUI_TEXTURED, var1, var5, var6, (float)var11, (float)var12, var7, var8, var7, var8, 64, 64, var13);
      } finally {
         var14.popMatrix();
      }
   }

   @Override
   public void a(LinkerFactory var1) {

      try {
         if (a.crosshairTarget instanceof EntityHitResult var2) {
            this.bo(var2.getEntity(), false);
         }
      } catch (Throwable var4) {
      }
   }

   public void bn(Entity var1) {

      this.bo(var1, true);
   }

   private void bo(Entity var1, boolean var2) {

      LivingEntity var3 = null;
      if (var1 instanceof LivingEntity) {
         var3 = (LivingEntity)var1;
      }

      try {
         if (a.player == null || var3 == null || var3 == a.player) {
            return;
         }

         long var4 = ms();
         if (this.fn.f() && this.gy.f()) {
            HIT_MS = var4;
         }

         if (this.id.f()) {
            if (this.rp != var3) {
               this.rr = -1L;
            }

            this.rp = var3;
            this.rq = var4;
            this.rs = System.identityHashCode(a.world);
            if (RegionPassCache.ah) {
               RegionPassCache.aq = var3;
            }
         }

         if (var2 && RegionPassCache.bd) {
            TracePassCache.hit(var3);
         }

         if (var2 && DEATH_ON) {
            this.ec(var3.getId(), var4);
         }

         if (!this.fy.f()) {
            return;
         }

         if (this.sn != var3) {
            this.sx = var4;
            this.sy = -1L;
         }

         this.sn = var3;
         this.sw = var4;
      } catch (Throwable var6) {
      }
   }

   @Override
   public void a() {

      if (a.player != null && a.world != null) {
         if (this.pu != this.ud) {
            this.pu = this.ud;

            try {
               this.bp(System.nanoTime(), 1.0);
            } catch (Throwable var11) {
            }
         }

         this.ud++;

         try {
            this.m_r106();
         } catch (Throwable var10) {
         }

         long var1 = ms();

         try {
            ArrayList var3 = this.pr;

            for (int var4 = var3.size() - 1; var4 >= 0; var4--) {
               double[] var5 = (double[])var3.get(var4);
               if ((double)var1 - var5[3] > var5[5] + 100.0) {
                  var3.remove(var4);
               }
            }
         } catch (Throwable var15) {
         }

         try {
            if (!this.lt && !this.ps.isEmpty()) {
               this.ps.clear();
            }
         } catch (Throwable var9) {
         }

         try {
            if (this.ms || this.oc > 0.0F) {
               this.ca();
            } else if (!this.qs.isEmpty()) {
               this.qs.clear();
               this.qt.clear();
            }
         } catch (Throwable var14) {
         }

         try {
            if (this.sn != null) {
               if ((this.sn.isRemoved() || !this.sn.isAlive()) && this.sy < 0L) {
                  this.sy = var1;
               }

               boolean var16 = var1 > this.sw + (long)this.mr + 300L;
               boolean var18 = this.sy >= 0L && var1 > this.sy + 450L;
               if (var16 || var18) {
                  this.sn = null;
                  this.sy = -1L;
               }
            }
         } catch (Throwable var13) {
         }

         try {
            if (this.rp != null) {
               if ((this.rp.isRemoved() || !this.rp.isAlive()) && this.rr < 0L) {
                  this.rr = var1;
               }

               boolean var17 = var1 > this.rq + (long)this.mr + 300L;
               boolean var19 = this.rr >= 0L && var1 > this.rr + 450L;
               if (var17 || var19 || !this.id.f() || this.rs != System.identityHashCode(a.world)) {
                  this.rp = null;
                  this.rr = -1L;
               }
            }

            RegionPassCache.aq = RegionPassCache.ah ? this.rp : null;
         } catch (Throwable var12) {
         }

         try {
            this.ea(var1);
         } catch (Throwable var8) {
         }

         try {
            this.br(var1);
         } catch (Throwable var7) {
         }

         try {
            this.bs();
         } catch (Throwable var6) {
         }
      }
   }

   private void bp(long var1, double var3) {

      if (!this.lt) {
         if (!this.ps.isEmpty()) {
            this.ps.clear();
         }
      } else {
         boolean var5 = this.lu;
         this.pt.clear();
         double var6 = (double)var1 / 1000000.0;
         double var8 = Math.max(50.0, (double)a.world.getTickManager().getMillisPerTick());
         double var10 = var6 - (var3 + (double)a.getRenderTickCounter().getTickProgress(true)) * var8;

         for (PlayerEntity var13 : a.world.getPlayers()) {
            if (var13 != null) {
               boolean var14 = var13 == a.player;
               if ((var14 || var5) && (var14 || !(var13.squaredDistanceTo(a.player) > 4096.0))) {
                  UUID var15 = var13.getUuid();
                  this.pt.add(var15);
                  double var16 = var13.getY();
                  boolean var18 = var13.isOnGround();
                  double[] var19 = this.ps.get(var15);
                  if (var19 == null) {
                     this.ps.put(var15, new double[]{var16, 0.0, var18 ? 1.0 : 0.0, 0.0, var16});
                  } else {
                     double var20 = var16 - var19[0];
                     if (var19[3] > 0.0) {
                        var19[3]--;
                     }

                     if (!var18 && var16 > var19[4]) {
                        var19[4] = var16;
                     }

                     if (Math.abs(var20) < 4.0 && var19[3] <= 0.0) {
                        boolean var22 = !var18 && var19[2] > 0.5 && (var20 > 0.06 || var14 && a.player.getVelocity().y > 0.08);
                        boolean var23 = var19[1] < -0.15 && (var18 || var20 > -0.03);
                        if (var22) {
                           this.bq(var13.lastRenderX, var19[0], var13.lastRenderZ, 1.0, var10, var6);
                           var19[3] = 6.0;
                        } else if (var23 && this.lw) {
                           double var24 = var19[4] - var16;
                           double var26 = this.lx ? Math.max(0.75, Math.min(2.2, 0.75 + 0.11 * var24)) : 1.0;
                           this.bq(var13.getX(), var16, var13.getZ(), var26, var10 + var8, var6);
                           var19[3] = 6.0;
                        }
                     }

                     var19[0] = var16;
                     var19[1] = var20;
                     var19[2] = var18 ? 1.0 : 0.0;
                     if (var18) {
                        var19[4] = var16;
                     }
                  }
               }
            }
         }

         Iterator var28 = this.ps.keySet().iterator();

         while (var28.hasNext()) {
            if (!this.pt.contains(var28.next())) {
               var28.remove();
            }
         }
      }
   }

   private void bq(double var1, double var3, double var5, double var7, double var9, double var11) {

      long var13 = (long)var11;
      int var15 = this.mb;
      double var16 = this.me;
      double var18 = this.md;
      if (this.ma >= 3) {
         int var20 = this.ma == 4 ? 1 : 0;
         int var21 = this.lv ? -1 : this.mc;
         float var22 = (float)(var9 - var11);

         for (int var23 = 0; var23 < var15; var23++) {
            TracePassCache.a(var1, var3, var5, (float)var7, var20, (float)var16, (float)var18, var21, var22 + (float)((long)var23 * 130L));
         }
      } else {
         for (int var40 = 0; var40 < var15; var40++) {
            if (this.pr.size() >= 12) {
               this.pr.remove(0);
            }

            this.pr.add(new double[]{var1, var3, var5, var9 + (double)((long)var40 * 130L), var7, var16, var18});
         }
      }

      if (this.ly && a.world != null) {
         int var41 = (this.lv ? dq((float)(var13 % 2400L) / 2400.0F, 0.85F, 1.0F) : this.lz) & (821916289 ^ 805473662);
         double var42 = this.me / 50.0;
         double var43 = 0.15 + this.md * var7;
         double var25 = var3 + 0.06;
         ThreadLocalRandom var27 = ThreadLocalRandom.current();

         for (int var28 = 0; var28 < 12; var28++) {
            double var29 = (Math.PI * 2) * (double)var28 / 12.0 + (var27.nextDouble() - 0.5) * 0.55;
            double var31 = Math.cos(var29);
            double var33 = Math.sin(var29);
            double var35 = var43 * (0.66 + var27.nextDouble() * 0.58);
            double var37 = 0.16 * var27.nextDouble() - 0.07;
            int var39 = (int)Math.max(3L, Math.min(46L, Math.round(var42 * (0.6 + var27.nextDouble() * 0.85))));
            a.world
               .addParticleClient(
                  new TrailParticleEffect(new Vec3d(var1 + var31 * var35, var25 + var37, var5 + var33 * var35), var41, var39),
                  var1 + var31 * 0.22,
                  var25 + 0.02,
                  var5 + var33 * 0.22,
                  0.0,
                  0.0,
                  0.0
               );
         }
      }
   }

   private void br(long var1) {

      LivingEntity var3 = this.sn;
      if (var3 == null) {
         this.tn = null;
      } else {
         float var4 = var3.getHealth() + var3.getAbsorptionAmount();
         if (var3 != this.tn) {
            this.tn = var3;
            this.to = var4;
            Arrays.fill(this.tj, 0L);
         } else {
            float var5 = this.to - var4;
            if (this.ml && var5 > 0.05F) {
               int var6 = this.tl;
               this.tl = var6 + 1 & 7;
               this.tg[var6] = var5;
               this.tk[var6] = dr(7, (long)Math.round(Math.max(0.0F, var5) * 10.0F));
               this.tj[var6] = var1;
               this.tm = this.tm * (-328923721 ^ -1381807142) + (-1009540391 ^ -1009544480);
               this.ti[var6] = (float)(this.tm >>> 16 & (-119993864 ^ -119994105)) / 255.0F * 16.0F - 8.0F;
            }

            this.to = var4;
         }
      }
   }

   private void bs() {

      int var1 = System.identityHashCode(a.world);
      if (var1 != this.tq) {
         this.tq = var1;
         this.tp.clear();
         POP_Q.clear();
      } else if (!POPS_ON) {
         if (!POP_Q.isEmpty()) {
            POP_Q.clear();
         }
      } else {
         for (int var2 = 0; var2 < 64; var2++) {
            EntityStatusS2CPacket var3 = POP_Q.poll();
            if (var3 == null) {
               break;
            }

            Entity var4 = var3.getEntity(a.world);
            if (var4 instanceof PlayerEntity) {
               this.tp.merge(var4.getId(), 1, Integer::sum);
            }
         }

         if (++this.tr >= 20) {
            this.tr = 0;
            Iterator var5 = this.tp.keySet().iterator();

            while (var5.hasNext()) {
               Entity var6 = a.world.getEntityById((Integer)var5.next());
               if (var6 == null || !var6.isAlive()) {
                  var5.remove();
               }
            }

            if (POP_Q.size() > (865069976 ^ 865069464)) {
               POP_Q.clear();
            }
         }
      }
   }

   @Override
   public void a(DrawContext var1) {

      this.ub = null;
      boolean var2 = super.f;
      long var3 = System.nanoTime();
      long var5 = this.nv;
      float var7 = var5 == 0L ? 0.0F : Math.min(0.1F, Math.max(0.0F, (float)(var3 - var5) / 1.0E9F));
      boolean var8 = var5 != 0L && var3 - var5 > 250000000L;
      this.nv = var3;
      this.nw = var3;
      float var9 = this.nu;
      var9 = var8 ? (var2 ? 1.0F : 0.0F) : (var2 ? Math.min(1.0F, var9 + var7 / 0.18F) : Math.max(0.0F, var9 - var7 / 0.22F));
      this.nu = var9;
      if (!var2 && var9 <= 0.0F) {
         this.b();
      } else {
         LINGER = var9 > 0.0F;
         this.bt(var7, var8 || var5 == 0L);
         if (a.player != null && a.world != null) {
            this.qe = var3 / 1000000L;
            if (this.pu != this.ud) {
               this.pu = this.ud;

               try {
                  this.bp(var3, 0.0);
               } catch (Throwable var15) {
               }
            }

            boolean var10 = !this.pr.isEmpty();
            boolean var11 = this.ms || this.oc > 0.0F;
            boolean var12 = (this.mg || this.nx > 0.0F) && this.sn != null;
            if (!var10 && !var11 && !var12) {
               this.qd = false;
            } else {
               try {
                  this.bu();
               } catch (Throwable var14) {
                  this.qd = false;
               }

               if (var10) {
                  this.ci(var1);
               }

               if (var11) {
                  this.cc(var1);
               }

               if (var12) {
                  if (this.oa > 0.0F && this.sn == this.tn) {
                     this.cj(var1);
                  }

                  this.cq(var1);
               }

               var1.createNewRootLayer();
            }
         }
      }
   }

   private void bt(float var1, boolean var2) {

      float var3 = var1 / 0.18F;
      float var4 = var1 / 0.22F;
      float var5 = var1 / 0.2F;
      boolean var6 = this.mg;
      float var7 = this.nx;
      this.nx = var2 ? (var6 ? 1.0F : 0.0F) : (var6 ? Math.min(1.0F, var7 + var3) : Math.max(0.0F, var7 - var4));
      var6 = this.mh;
      var7 = this.ny;
      this.ny = var2 ? (var6 ? 1.0F : 0.0F) : (var6 ? Math.min(1.0F, var7 + var3) : Math.max(0.0F, var7 - var4));
      var6 = this.mk;
      var7 = this.nz;
      this.nz = var2 ? (var6 ? 1.0F : 0.0F) : (var6 ? Math.min(1.0F, var7 + var3) : Math.max(0.0F, var7 - var4));
      var6 = this.ml;
      var7 = this.oa;
      this.oa = var2 ? (var6 ? 1.0F : 0.0F) : (var6 ? Math.min(1.0F, var7 + var3) : Math.max(0.0F, var7 - var4));
      var6 = this.ts;
      var7 = this.ob;
      this.ob = var2 ? (var6 ? 1.0F : 0.0F) : (var6 ? Math.min(1.0F, var7 + var5) : Math.max(0.0F, var7 - var5));
      var6 = this.ms;
      var7 = this.oc;
      this.oc = var2 ? (var6 ? 1.0F : 0.0F) : (var6 ? Math.min(1.0F, var7 + var3) : Math.max(0.0F, var7 - var4));
      var6 = this.mt;
      var7 = this.od;
      this.od = var2 ? (var6 ? 1.0F : 0.0F) : (var6 ? Math.min(1.0F, var7 + var3) : Math.max(0.0F, var7 - var4));
      var6 = this.mu;
      var7 = this.oe;
      this.oe = var2 ? (var6 ? 1.0F : 0.0F) : (var6 ? Math.min(1.0F, var7 + var3) : Math.max(0.0F, var7 - var4));
      var6 = this.mz;
      var7 = this.of;
      this.of = var2 ? (var6 ? 1.0F : 0.0F) : (var6 ? Math.min(1.0F, var7 + var3) : Math.max(0.0F, var7 - var4));
      var6 = this.mv;
      var7 = this.og;
      this.og = var2 ? (var6 ? 1.0F : 0.0F) : (var6 ? Math.min(1.0F, var7 + var3) : Math.max(0.0F, var7 - var4));
      var6 = this.mx;
      var7 = this.oh;
      this.oh = var2 ? (var6 ? 1.0F : 0.0F) : (var6 ? Math.min(1.0F, var7 + var3) : Math.max(0.0F, var7 - var4));
      float var8 = this.nu;
      this.oi = var8 * var8 * (3.0F - 2.0F * var8);
      float var9 = Math.min(var8, this.nx);
      this.oj = var9 * var9 * (3.0F - 2.0F * var9);
      float var10 = Math.min(var9, this.ny);
      this.ok = var10 * var10 * (3.0F - 2.0F * var10);
      var10 = Math.min(var9, this.nz);
      this.ol = var10 * var10 * (3.0F - 2.0F * var10);
      var10 = Math.min(var9, this.oa);
      this.om = var10 * var10 * (3.0F - 2.0F * var10);
      var10 = this.ny;
      this.ot = var10 * var10 * (3.0F - 2.0F * var10);
      var10 = this.nz;
      this.ou = var10 * var10 * (3.0F - 2.0F * var10);
      var10 = this.ob;
      this.on = var10 * var10 * (3.0F - 2.0F * var10);
      var9 = Math.min(var8, this.oc);
      var10 = Math.min(var9, this.od);
      this.oo = var10 * var10 * (3.0F - 2.0F * var10);
      var10 = Math.min(var9, this.oe);
      this.op = var10 * var10 * (3.0F - 2.0F * var10);
      var10 = Math.min(var9, this.of);
      this.oq = var10 * var10 * (3.0F - 2.0F * var10);
      var10 = Math.min(var9, this.og);
      this.or = var10 * var10 * (3.0F - 2.0F * var10);
      var10 = Math.min(var9, this.oh);
      this.os = var10 * var10 * (3.0F - 2.0F * var10);
   }

   private void bu() {

      this.qd = false;
      if (a.gameRenderer != null && a.getWindow() != null) {
         CoreOptimizer.vp(this.pv).get(this.pw);
         Vec3d var1 = a.gameRenderer.getCamera().getCameraPos();
         this.px = var1.x;
         this.py = var1.y;
         this.pz = var1.z;
         float var2 = (float)Math.max(1, a.getWindow().getScaleFactor());
         this.qa = (float)a.getWindow().getFramebufferWidth() / var2;
         this.qb = (float)a.getWindow().getFramebufferHeight() / var2;
         this.qc = a.getRenderTickCounter().getTickProgress(true);
         this.qd = true;
      }
   }

   private boolean bv(double var1, double var3, double var5) {

      float[] var7 = this.pw;
      float var8 = (float)(var1 - this.px);
      float var9 = (float)(var3 - this.py);
      float var10 = (float)(var5 - this.pz);
      float var11 = var7[3] * var8 + var7[7] * var9 + var7[11] * var10 + var7[15];
      if (var11 <= 1.0E-4F) {
         return false;
      } else {
         float var12 = 1.0F / var11;
         float var13 = (var7[2] * var8 + var7[6] * var9 + var7[10] * var10 + var7[14]) * var12;
         if (!(var13 < -1.0F) && !(var13 > 1.0F)) {
            this.qm = ((var7[0] * var8 + var7[4] * var9 + var7[8] * var10 + var7[12]) * var12 * 0.5F + 0.5F) * this.qa;
            this.qn = (1.0F - ((var7[1] * var8 + var7[5] * var9 + var7[9] * var10 + var7[13]) * var12 * 0.5F + 0.5F)) * this.qb;
            return true;
         } else {
            return false;
         }
      }
   }

   private int bw(double var1, double var3, double var5, double var7) {

      assert this.pw.length == 16
         && this.qg.length == 37
         && this.qh.length == 37
         && this.qi.length == 37
         && pp.length == 37
         && pq.length == 37
         && !Double.isNaN(var1)
         && !Double.isNaN(var3)
         && !Double.isNaN(var5)
         && var7 >= 0.0
         && this.qa >= 0.0F
         && this.qb >= 0.0F
         && !Double.isNaN(this.px) : "projRing";

      try {
         float[] var9 = this.pw;
         float var10 = var9[0];
         float var11 = var9[1];
         float var12 = var9[2];
         float var13 = var9[3];
         float var14 = var9[4];
         float var15 = var9[5];
         float var16 = var9[6];
         float var17 = var9[7];
         float var18 = var9[8];
         float var19 = var9[9];
         float var20 = var9[10];
         float var21 = var9[11];
         float var22 = var9[12];
         float var23 = var9[13];
         float var24 = var9[14];
         float var25 = var9[15];
         float var26 = this.qa;
         float var27 = this.qb;
         float var28 = (float)(var1 - this.px);
         float var29 = (float)(var3 - this.py);
         float var30 = (float)(var5 - this.pz);
         float var31 = (float)var7;
         float[] var32 = this.qg;
         float[] var33 = this.qh;
         float[] var34 = pp;
         float[] var35 = pq;
         boolean[] var36 = this.qi;

         for (int var37 = 0; var37 < 37; var37++) {
            float var38 = var28 + var34[var37] * var31;
            float var40 = var30 + var35[var37] * var31;
            float var41 = var13 * var38 + var17 * var29 + var21 * var40 + var25;
            boolean var42 = false;
            if (var41 > 1.0E-4F) {
               float var43 = 1.0F / var41;
               float var44 = (var12 * var38 + var16 * var29 + var20 * var40 + var24) * var43;
               if (var44 >= -1.0F && var44 <= 1.0F) {
                  float var45 = ((var10 * var38 + var14 * var29 + var18 * var40 + var22) * var43 * 0.5F + 0.5F) * var26;
                  float var46 = (1.0F - ((var11 * var38 + var15 * var29 + var19 * var40 + var23) * var43 * 0.5F + 0.5F)) * var27;
                  var32[var37] = var45;
                  var33[var37] = var46;
                  var42 = true;
               }
            }

            var36[var37] = var42;
         }

         return 37;
      } catch (RuntimeException var47) {
         throw var47;
      }
   }

   private void bx(DrawContext var1, int var2, int var3, float var4, int var5) {

      float[] var6 = this.qg;
      float[] var7 = this.qh;
      float[] var8 = this.qj;
      float[] var9 = this.qk;
      float[] var10 = this.ql;
      boolean[] var11 = this.qi;
      Matrix3x2fStack var12 = var1.getMatrices();
      Matrix3x2f var13 = this.qf.set(var12);
      float var14 = var13.m00;
      float var15 = var13.m01;
      float var16 = var13.m10;
      float var17 = var13.m11;
      float var18 = var13.m20;
      float var19 = var13.m21;
      boolean var20 = var5 >>> 24 > 2;
      float var21 = var4 + 1.0F;
      var10[0] = 0.0F;

      for (int var22 = 1; var22 < var2; var22++) {
         int var23 = var22 - 1;
         float var24 = 0.0F;
         if (var11[var22] && var11[var23]) {
            float var25 = var6[var22] - var6[var23];
            float var26 = var7[var22] - var7[var23];
            var24 = (float)Math.sqrt((double)(var25 * var25 + var26 * var26));
            if (var24 >= 0.1F && var24 < 8000.0F) {
               float var27 = 1.0F / var24;
               var8[var22] = var25 * var27;
               var9[var22] = var26 * var27;
            } else {
               var24 = 0.0F;
            }
         }

         var10[var22] = var24;
      }

      boolean var44 = var2 > 3 && var11[0] && var11[var2 - 1] && Math.abs(var6[var2 - 1] - var6[0]) + Math.abs(var7[var2 - 1] - var7[0]) < 0.01F;
      var1.createNewRootLayer();
      var12.pushMatrix();

      try {
         for (int var45 = 1; var45 < var2; var45++) {
            float var46 = var10[var45];
            if (var46 > 0.0F) {
               float var47 = var8[var45];
               float var48 = var9[var45];
               int var49 = var45 > 1 ? var45 - 1 : (var44 ? var2 - 1 : 0);
               int var28 = var45 < var2 - 1 ? var45 + 1 : (var44 ? 1 : 0);
               float var29 = 0.0F;
               float var30 = 0.0F;
               if (var10[var49] > 0.0F) {
                  float var31 = var8[var49] * var47 + var9[var49] * var48;
                  float var32 = var8[var49] * var48 - var9[var49] * var47;
                  var29 = Math.min(1.5F, (var32 < 0.0F ? -var32 : var32) / Math.max(0.25F, 1.0F + var31));
               }

               if (var10[var28] > 0.0F) {
                  float var50 = var47 * var8[var28] + var48 * var9[var28];
                  float var52 = var47 * var9[var28] - var48 * var8[var28];
                  var30 = Math.min(1.5F, (var52 < 0.0F ? -var52 : var52) / Math.max(0.25F, 1.0F + var50));
               }

               float var51 = var14 * var47 + var16 * var48;
               float var53 = var15 * var47 + var17 * var48;
               float var33 = var16 * var47 - var14 * var48;
               float var34 = var17 * var47 - var15 * var48;
               float var35 = var6[var45 - 1];
               float var36 = var7[var45 - 1];
               float var37 = var14 * var35 + var16 * var36 + var18;
               float var38 = var15 * var35 + var17 * var36 + var19;
               if (var20) {
                  float var39 = var29 * var21;
                  float var40 = var46 + var39 + var30 * var21;
                  var12.set(var51 * var40, var53 * var40, var33 * var21, var34 * var21, var37 - var51 * var39, var38 - var53 * var39);
                  var1.fill(0, -1, 1, 1, var5);
               }

               float var54 = var29 * var4;
               float var55 = var46 + var54 + var30 * var4;
               var12.set(var51 * var55, var53 * var55, var33 * var4, var34 * var4, var37 - var51 * var54, var38 - var53 * var54);
               var1.fill(0, -1, 1, 1, var3);
            }
         }
      } finally {
         var12.popMatrix();
      }

      var1.createNewRootLayer();
   }

   private void by(
      DrawContext var1, double[] var2, int var3, boolean var4, double var5, double var7, double var9, int var11, int var12, boolean var13, float var14
   ) {

      if (var3 >= 2) {
         float var15 = 80.0F * var14;
         float var16 = 144.0F * var14;
         float[] var17 = this.pw;
         float var18 = var17[0];
         float var19 = var17[1];
         float var20 = var17[2];
         float var21 = var17[3];
         float var22 = var17[4];
         float var23 = var17[5];
         float var24 = var17[6];
         float var25 = var17[7];
         float var26 = var17[8];
         float var27 = var17[9];
         float var28 = var17[10];
         float var29 = var17[11];
         float var30 = var17[12];
         float var31 = var17[13];
         float var32 = var17[14];
         float var33 = var17[15];
         float var34 = this.qa;
         float var35 = this.qb;
         double var36 = this.px;
         double var38 = this.py;
         double var40 = this.pz;
         int var42 = var11 >> 16 & (-1815562750 ^ -1815562499);
         int var43 = var11 >> 8 & (348763873 ^ 348763678);
         int var44 = var11 & (-185494926 ^ -185494899);
         float var45 = var3 > 2 ? (float)(var3 - 2) : 1.0F;
         Matrix3x2fStack var46 = var1.getMatrices();
         Matrix3x2f var47 = this.qf.set(var46);
         float var48 = var47.m00;
         float var49 = var47.m01;
         float var50 = var47.m10;
         float var51 = var47.m11;
         float var52 = var47.m20;
         float var53 = var47.m21;
         var1.createNewRootLayer();
         var46.pushMatrix();

         try {
            float var54 = 0.0F;
            float var55 = 0.0F;
            boolean var56 = false;

            for (int var57 = 0; var57 < var3; var57++) {
               double var58;
               double var60;
               double var62;
               if (var57 == 0 && var4) {
                  var58 = var5;
                  var60 = var7;
                  var62 = var9;
               } else {
                  int var64 = var57 * 3;
                  var58 = var2[var64];
                  var60 = var2[var64 + 1];
                  var62 = var2[var64 + 2];
               }

               float var81 = (float)(var58 - var36);
               float var65 = (float)(var60 - var38);
               float var66 = (float)(var62 - var40);
               float var67 = var21 * var81 + var25 * var65 + var29 * var66 + var33;
               boolean var68 = false;
               float var69 = 0.0F;
               float var70 = 0.0F;
               if (var67 > 1.0E-4F) {
                  float var71 = 1.0F / var67;
                  float var72 = (var20 * var81 + var24 * var65 + var28 * var66 + var32) * var71;
                  if (var72 >= -1.0F && var72 <= 1.0F) {
                     var69 = ((var18 * var81 + var22 * var65 + var26 * var66 + var30) * var71 * 0.5F + 0.5F) * var34;
                     var70 = (1.0F - ((var19 * var81 + var23 * var65 + var27 * var66 + var31) * var71 * 0.5F + 0.5F)) * var35;
                     var68 = true;
                  }
               }

               if (var68 && var56 && (!var13 || (var57 & 1) == 1)) {
                  float var82 = var69 - var54;
                  float var83 = var70 - var55;
                  float var73 = (float)Math.sqrt((double)(var82 * var82 + var83 * var83));
                  if (var73 >= 0.1F && var73 < 8000.0F) {
                     int var74;
                     if (var13) {
                        var74 = var11;
                     } else {
                        float var75 = (float)(var57 - 1) / var45;
                        if (var75 > 1.0F) {
                           var75 = 1.0F;
                        }

                        float var76 = 0.55F + 0.45F * var75;
                        var74 = (int)(var15 + var75 * var16) << 24
                           | (int)((float)var42 * var76) << 16
                           | (int)((float)var43 * var76) << 8
                           | (int)((float)var44 * var76);
                     }

                     float var84 = 1.0F / var73;
                     float var85 = var82 * var84;
                     float var77 = var83 * var84;
                     var46.set(
                        var48 * var85 + var50 * var77,
                        var49 * var85 + var51 * var77,
                        var50 * var85 - var48 * var77,
                        var51 * var85 - var49 * var77,
                        var48 * var54 + var50 * var55 + var52,
                        var49 * var54 + var51 * var55 + var53
                     );
                     var1.fill(0, -var12, (int)Math.ceil((double)var73), var12, var74);
                  }
               }

               var54 = var69;
               var55 = var70;
               var56 = var68;
            }
         } finally {
            var46.popMatrix();
         }

         var1.createNewRootLayer();
      }
   }

   private void bz(DrawContext var1, double var2, double var4, double var6, String var8, int var9, int var10) {

      if (var9 >>> 24 >= 8 || var10 >>> 24 >= 2) {
         if (this.bv(var2, var4, var6)) {
            int var11 = cw(var8, 1.0F);
            int var12 = lm[var11];
            int var13 = Math.round(this.qm) - var12 / 2;
            int var14 = Math.round(this.qn) - 4;
            if (var10 >>> 24 >= 2) {
               dt(var1, var13 - 3, var14 - 2, var12 + 6, 12, 3, var10);
            }

            if (var9 >>> 24 >= 8) {
               var1.drawText(a.textRenderer, ll[var11], var13, var14, var9, true);
            }
         }
      }
   }

   private void ca() {

      this.qu.clear();

      try {
         for (Entity var2 : a.world.getEntities()) {
            if (var2 instanceof EnderPearlEntity) {
               EnderPearlEntity var3 = (EnderPearlEntity)var2;
               int var4 = var2.getId();
               this.qu.add(var4);
               if (this.cb(var2)) {
                  boolean var5 = var3.getOwner() == a.player;
                  NodeZoneRenderer.Trk var6 = this.qs.get(var4);
                  if (var6 == null) {
                     var6 = new NodeZoneRenderer.Trk();
                     var6.b = this.rl;
                     this.qs.put(var4, var6);
                  }

                  System.arraycopy(this.rj, 0, var6.pts, 0, this.rk * 3);
                  var6.n = this.rk;
                  var6.a = true;
                  var6.lx = this.rm;
                  var6.ly = this.rn;
                  var6.lz = this.ro;
                  var6.c = this.rl;
                  var6.d = var5;
                  var6.ent = var2;
               }
            }
         }
      } catch (Throwable var7) {
      }

      Iterator var8 = this.qs.keySet().iterator();

      while (var8.hasNext()) {
         if (!this.qu.contains(var8.next())) {
            var8.remove();
         }
      }

      this.qt.clear();
      this.qt.addAll(this.qs.values());
   }

   private boolean cb(Entity var1) {

      Vec3d var2 = var1.getEntityPos();
      Vec3d var3 = var1.getVelocity();
      BlockHitResult var4 = null;
      Vec3d var5 = null;

      try {
         double var6 = var2.x;
         double var8 = var2.y;
         double var10 = var2.z;
         double var12 = var3.x;
         double var14 = var3.y;
         double var16 = var3.z;
         double[] var18 = this.rj;
         var18[0] = var6;
         var18[1] = var8;
         var18[2] = var10;
         int var19 = 1;
         double var20 = (double)a.world.getBottomY() - 64.0;

         for (int var22 = 1; var22 <= (-534781628 ^ -534781848); var22++) {
            double var33 = var14 - 0.03;
            var12 *= 0.99;
            var14 = var33 * 0.99;
            var16 *= 0.99;
            double var23 = var6 + var12;
            double var25 = var8 + var14;
            double var27 = var10 + var16;
            var4 = a.world
               .raycast(
                  new RaycastContext(new Vec3d(var6, var8, var10), new Vec3d(var23, var25, var27), RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, var1)
               );
            int var29 = var19 * 3;
            if (var4.getType() == HitResult.Type.BLOCK) {
               var5 = var4.getPos();
               var18[var29] = var5.x;
               var18[var29 + 1] = var5.y;
               var18[var29 + 2] = var5.z;
               this.rk = var19 + 1;
               this.rm = var5.x;
               this.rn = var5.y;
               this.ro = var5.z;
               this.rl = var22;
               return true;
            }

            var6 = var23;
            var8 = var25;
            var10 = var27;
            var18[var29] = var23;
            var18[var29 + 1] = var25;
            var18[var29 + 2] = var27;
            var19++;
            if (var25 < var20) {
               return false;
            }
         }

         return false;
      } catch (Throwable var30) {
         return false;
      }
   }

   private void cc(DrawContext var1) {

      NodeZoneRenderer.Trk var2 = null;
      Vec3d var3 = null;

      try {
         long var4 = this.qe;
         int var6 = this.s();
         float var7 = (float)(var6 >> 16 & (-484572253 ^ -484572324));
         float var8 = (float)(var6 >> 8 & (1198388704 ^ 1198388511));
         float var9 = (float)(var6 & (-428071543 ^ -428071562));
         float var10 = this.my ? 1.0F : 0.0F;
         long var11 = this.nw;
         if (this.pd != 0L && var11 - this.pd <= 250000000L) {
            float var13 = 1.0F - (float)Math.exp(-14.0 * Math.min(0.1, (double)(var11 - this.pd) / 1.0E9));
            this.oy = this.oy + (var7 - this.oy) * var13;
            this.oz = this.oz + (var8 - this.oz) * var13;
            this.pa = this.pa + (var9 - this.pa) * var13;
            this.pb = this.pb + (var10 - this.pb) * var13;
         } else {
            this.oy = var7;
            this.oz = var8;
            this.pa = var9;
            this.pb = var10;
         }

         this.pd = var11;
         int var43 = (int)(this.oy + 0.5F) << 16 | (int)(this.oz + 0.5F) << 8 | (int)(this.pa + 0.5F);
         float var14 = this.pb;
         int var15 = var14 <= 0.002F ? var43 : dn(var43, 360991120 ^ 360383195, var14);
         int var16 = this.nb;
         float var17 = this.os;
         if (this.qd && var17 > 0.004F) {
            try {
               this.cd(var1, var43, var16, var4, var17);
            } catch (Throwable var40) {
            }
         }

         ArrayList var18 = this.qt;
         int var19 = var18.size();
         if (var19 == 0) {
            return;
         }

         float var20 = this.qc;
         float var21 = this.oo;
         float var22 = this.oq;
         float var23 = this.op;
         int var24 = (int)(240.0F * var23);
         int var25 = (int)(46.0F * var23);
         int var26 = (int)(144.0F * var23);
         int var27 = (int)(28.0F * var23);
         int var28 = (int)(255.0F * var22) << 24;
         int var29 = (int)(144.0F * var22) << 24;

         for (int var30 = 0; var30 < var19; var30++) {
            NodeZoneRenderer.Trk var31 = (NodeZoneRenderer.Trk)var18.get(var30);
            int var32 = var31.d ? var43 : var15;
            if (this.qd) {
               if (var21 > 0.004F && var31.n > 1) {
                  boolean var33 = var31.ent != null;
                  double var34 = 0.0;
                  double var36 = 0.0;
                  double var38 = 0.0;
                  if (var33) {
                     var3 = var31.ent.getLerpedPos(var20);
                     var34 = var3.x;
                     var36 = var3.y;
                     var38 = var3.z;
                  }

                  this.by(var1, var31.pts, var31.n, var33, var34, var36, var38, var32, var16, false, var21);
               }

               if (var31.a) {
                  if (var24 > 1) {
                     float var45 = var31.b > 0 ? MathHelper.clamp(((float)var31.c - var20) / (float)var31.b, 0.0F, 1.0F) : 0.0F;
                     double var47 = 0.55 + 0.06 * Math.sin((double)var4 / 130.0);
                     double var49 = 0.12 + 0.43 * (double)var45;
                     int var50 = this.bw(var31.lx, var31.ly + 0.02, var31.lz, var47);
                     this.bx(var1, var50, var24 << 24 | var32, (float)var16, var25 << 24 | var32);
                     var50 = this.bw(var31.lx, var31.ly + 0.02, var31.lz, var49);
                     this.bx(var1, var50, var26 << 24 | var32, (float)var16, var27 << 24 | var32);
                  }

                  if (var22 > 0.004F) {
                     float var46 = Math.max(0.0F, ((float)var31.c - var20) / 20.0F);
                     float var48 = MathHelper.clamp(1.0F - var46, 0.0F, 1.0F);
                     this.bz(
                        var1,
                        var31.lx,
                        var31.ly + 0.55,
                        var31.lz,
                        dr(2, (long)Math.round(var46 * 10.0F)),
                        var28 | dn(var32, -961834603 ^ -967545238, var48),
                        var29
                     );
                  }
               }
            }

            if (var2 == null || var31.c < var2.c) {
               var2 = var31;
            }
         }

         float var44 = this.or;
         if (var44 > 0.004F && var2 != null) {
            this.cf(var1, var2, var43, var44);
         }
      } catch (Throwable var41) {
      }
   }

   private void cd(DrawContext var1, int var2, int var3, long var4, float var6) {

      ClientPlayerEntity var7 = a.player;
      ItemStack var8 = var7.getMainHandStack();
      if (!var8.isOf(Items.ENDER_PEARL)) {
         var8 = var7.getOffHandStack();
         if (!var8.isOf(Items.ENDER_PEARL)) {
            this.qw = 0;
            return;
         }
      }

      this.ce(var7, var4);
      int var9 = this.qw;
      if (var9 >= 2) {
         int var10 = var7.getItemCooldownManager().isCoolingDown(var8) ? 72 : 370908477 ^ 370908589;
         int var11 = (int)((float)var10 * var6);
         if (var11 >= 1) {
            int var12 = dn(var2, -1463451728 ^ -1472561073, 0.4F);
            this.by(var1, this.qv, var9, false, 0.0, 0.0, 0.0, var11 << 24 | var12, var3, true, 1.0F);
            if (this.ra) {
               int var13 = (var9 - 1) * 3;
               double var14 = this.qv[var13];
               double var16 = this.qv[var13 + 1];
               double var18 = this.qv[var13 + 2];
               int var20 = this.bw(var14, var16 + 0.02, var18, 0.45);
               this.bx(var1, var20, var11 << 24 | var12, (float)var3, var11 >> 2 << 24 | var12);
               this.bz(
                  var1,
                  var14,
                  var16 + 0.55,
                  var18,
                  dr(2, Math.round((double)this.qz * 0.5)),
                  (int)((float)Math.min(-1680449307 ^ -1680449510, var10 + 96) * var6) << 24 | 833729264 ^ 827215119,
                  var11 << 24
               );
            }
         }
      }
   }

   private void ce(PlayerEntity var1, long var2) {

      Vec3d var4 = var1.getLerpedPos(this.qc);
      double var5 = var4.x;
      double var7 = var4.y + (var1.getEyeY() - var1.getY()) - 0.1;
      double var9 = var4.z;
      float var11 = var1.getYaw();
      float var12 = var1.getPitch();
      if (this.qw <= 0
         || var2 - this.rg >= 50L
         || !(Math.abs(var11 - this.rb) <= 0.05F)
         || !(Math.abs(var12 - this.rc) <= 0.05F)
         || !(Math.abs(var5 - this.rd) <= 0.01)
         || !(Math.abs(var7 - this.re) <= 0.01)
         || !(Math.abs(var9 - this.rf) <= 0.01)) {
         this.rb = var11;
         this.rc = var12;
         this.rd = var5;
         this.re = var7;
         this.rf = var9;
         this.rg = var2;
         float var13 = var11 * (float) (Math.PI / 180.0);
         float var14 = var12 * (float) (Math.PI / 180.0);
         double var15 = (double)(-MathHelper.sin((double)var13) * MathHelper.cos((double)var14));
         double var17 = (double)(-MathHelper.sin((double)var14));
         double var19 = (double)(MathHelper.cos((double)var13) * MathHelper.cos((double)var14));
         double var21 = Math.sqrt(var15 * var15 + var17 * var17 + var19 * var19);
         if (var21 < 1.0E-6) {
            this.qw = 0;
         } else {
            double var23 = var15 / var21 * 1.5;
            double var25 = var17 / var21 * 1.5;
            double var27 = var19 / var21 * 1.5;
            var23 += var1.getX() - var1.lastX;
            var25 += var1.isOnGround() ? 0.0 : var1.getY() - var1.lastY;
            var27 += var1.getZ() - var1.lastZ;
            double[] var29 = this.qv;
            var29[0] = var5;
            var29[1] = var7;
            var29[2] = var9;
            int var30 = 1;
            boolean var31 = false;
            int var32 = -105736619 ^ -105736459;
            double var33 = var5;
            double var35 = var7;
            double var37 = var9;
            double var39 = (double)a.world.getBottomY() - 64.0;

            for (int var41 = 1; var41 <= (-1448081641 ^ -1448081481); var41++) {
               double var53 = var25 - 0.03;
               var23 *= 0.99;
               var25 = var53 * 0.99;
               var27 *= 0.99;
               double var42 = var33 + var23;
               double var44 = var35 + var25;
               double var46 = var37 + var27;
               BlockHitResult var48 = a.world
                  .raycast(
                     new RaycastContext(new Vec3d(var33, var35, var37), new Vec3d(var42, var44, var46), RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, var1)
                  );
               int var49 = var30 * 3;
               if (var48.getType() == HitResult.Type.BLOCK) {
                  Vec3d var50 = var48.getPos();
                  var29[var49] = var50.x;
                  var29[var49 + 1] = var50.y;
                  var29[var49 + 2] = var50.z;
                  var30++;
                  var31 = true;
                  var32 = var41;
                  break;
               }

               var33 = var42;
               var35 = var44;
               var37 = var46;
               var29[var49] = var42;
               var29[var49 + 1] = var44;
               var29[var49 + 2] = var46;
               var30++;
               if (var44 < var39) {
                  break;
               }
            }

            this.qw = var30;
            this.ra = var31;
            this.qz = var32;
         }
      }
   }

   private void cf(DrawContext var1, NodeZoneRenderer.Trk var2, int var3, float var4) {

      int var5 = a.getWindow().getScaledWidth();
      int var6 = a.getWindow().getScaledHeight();
      float var7 = Math.max(0.0F, (float)var2.c - this.qc);
      double var8 = var2.b > 0 ? (double)MathHelper.clamp(var7 / (float)var2.b, 0.0F, 1.0F) : 0.0;
      int var10 = (int)(this.nc * (double)var5);
      int var11 = (int)(this.nd * (double)var6);
      this.ch(var1, var10, var11, (double)var4, dr(2, (long)Math.round(var7 * 0.5F)), (float)var8, var3, true);
   }

   private void cg(DrawContext var1, int var2, int var3) {

      this.ch(var1, var2, var3, 1.0, ku[9], 0.6F, this.s(), true);
   }

   private void ch(DrawContext var1, int var2, int var3, double var4, String var6, float var7, int var8, boolean var9) {

      Matrix3x2fStack var10 = var1.getMatrices();
      int var11 = (int)(dz(var4) * 255.0 + 0.5);
      float var12 = var4 >= 1.0 ? 1.0F : (var4 <= 0.0 ? 0.0F : (float)var4);
      byte var13 = 9;
      byte var14 = 5;
      byte var15 = 16;
      int var16 = cw(var6, 1.0F);
      Text var17 = ll[var16];
      int var18 = lm[var16];
      int var19 = var14 + var15 + 5 + var18 + var14;
      byte var20 = 3;
      int var21 = var14 + Math.max(var15, var13) + 3 + var20 + var14;
      if (var9) {
         var2 -= var19 / 2;
         var3 -= var21 / 2;
      }

      int var22 = var11 << 24 | var8 & (1042340904 ^ 1054811095);
      dt(var1, var2 + 2, var3 + 3, var19, var21, 4, dx(-2143840237 ^ -533227501, var4));
      dt(var1, var2, var3, var19, var21, 4, var22);
      dt(var1, var2 + 2, var3 + 2, var19 - 4, var21 - 4, 3, dx(403060574 ^ -401982646, var4));
      if (this.rh == null) {
         this.rh = new ItemStack(Items.ENDER_PEARL);
      }

      if (var12 >= 0.999F) {
         var1.drawItem(this.rh, var2 + var14, var3 + var14);
      } else if (var12 > 0.03F) {
         var10.pushMatrix();

         try {
            var10.translate((float)(var2 + var14) + 8.0F * (1.0F - var12), (float)(var3 + var14) + 8.0F * (1.0F - var12));
            var10.scale(var12, var12);
            var1.drawItem(this.rh, 0, 0);
         } finally {
            var10.popMatrix();
         }
      }

      int var23 = var2 + var14 + var15 + 5;
      int var24 = var3 + var14 + (Math.max(var15, var13) - var13) / 2;
      if (var11 >= 8) {
         var1.drawText(a.textRenderer, var17, var23 + 1, var24 + 1, dx(-1454177037 ^ 424871155, var4), false);
         var1.drawText(a.textRenderer, var17, var23, var24, dx(-1, var4), false);
      }

      int var25 = var2 + var14;
      int var26 = var19 - var14 * 2;
      int var27 = var3 + var21 - var14 - var20;
      var1.fill(var25, var27, var25 + var26, var27 + var20, dx(-1129322812 ^ 1136131814, var4));
      var1.fill(var25, var27, var25 + (int)((float)var26 * var7), var27 + var20, var22);
   }

   private void ci(DrawContext var1) {

      if (!this.pr.isEmpty() && this.qd) {
         try {
            long var2 = this.qe;
            double var4 = (double)this.nw / 1000000.0;
            float var6 = this.mf * 0.5F;
            int var7 = Math.max(1, Math.round(var6));
            int var8 = this.ma;
            float var9 = this.oi;
            int var10 = (this.lv ? dq((float)(var2 % 2400L) / 2400.0F, 0.85F, 1.0F) : this.lz) & (1763531842 ^ 1776460733);
            float var11 = (float)(var10 >> 16 & (-174530545 ^ -174530320));
            float var12 = (float)(var10 >> 8 & (960520391 ^ 960520248));
            float var13 = (float)(var10 & (-1584886069 ^ -1584886220));
            long var14 = this.nw;
            if (this.pc != 0L && var14 - this.pc <= 250000000L) {
               float var16 = 1.0F - (float)Math.exp(-14.0 * Math.min(0.1, (double)(var14 - this.pc) / 1.0E9));
               this.ov = this.ov + (var11 - this.ov) * var16;
               this.ow = this.ow + (var12 - this.ow) * var16;
               this.ox = this.ox + (var13 - this.ox) * var16;
            } else {
               this.ov = var11;
               this.ow = var12;
               this.ox = var13;
            }

            this.pc = var14;
            int var43 = (int)(this.ov + 0.5F) << 16 | (int)(this.ow + 0.5F) << 8 | (int)(this.ox + 0.5F);
            int var17 = Math.min(-1404687037 ^ -1404686916, (var43 >> 16 & (1305124040 ^ 1305123895)) + 40) << 16
               | Math.min(1358576598 ^ 1358576425, (var43 >> 8 & (405257224 ^ 405257463)) + 40) << 8
               | Math.min(657712564 ^ 657712459, (var43 & (-1975939532 ^ -1975939381)) + 40);
            ArrayList var18 = this.pr;
            int var19 = 0;

            for (int var20 = var18.size(); var19 < var20; var19++) {
               double[] var21 = (double[])var18.get(var19);
               double var22 = var21[4];
               double var24 = var21[5];
               double var26 = var21[6];
               double var28 = (var4 - var21[3]) / var24;
               if (var28 >= 0.0 && var28 < 1.0) {
                  double var30 = 1.0 - var28;
                  double var32 = 1.0 - var30 * var30 * var30;
                  double var34 = 0.15 + var32 * var26 * var22;
                  double var36 = var28 < 0.3 ? 1.0 : (1.0 - var28) / 0.7;
                  var36 = var36 < 0.0 ? 0.0 : (var36 > 1.0 ? 1.0 : var36);
                  var36 = var36 * var36 * (3.0 - 2.0 * var36);
                  int var38 = (int)(var36 * 210.0 * (double)var9);
                  if (var38 > 4) {
                     float var39 = (float)((double)var6 * (1.0 - 0.3 * var32));
                     if (var39 < 1.0F) {
                        var39 = 1.0F;
                     }

                     int var40 = this.bw(var21[0], var21[1], var21[2], var34);
                     if (var8 == 1) {
                        this.bx(var1, var40, (int)((float)var38 * 0.16F) << 24 | var43, (float)(var7 * 3), 0);
                        this.bx(var1, var40, (int)((float)var38 * 0.32F) << 24 | var43, (float)(var7 * 2), 0);
                        this.bx(var1, var40, var38 << 24 | var17, var39, 0);
                     } else {
                        this.bx(var1, var40, var38 << 24 | var43, var39, (int)((float)var38 * (0.26F - 0.1F * (float)var32)) << 24 | var43);
                     }
                  }
               }

               if (var8 == 2) {
                  double var44 = (var4 - var21[3] - 90.0) / var24;
                  if (var44 >= 0.0 && var44 < 1.0) {
                     double var45 = 1.0 - var44;
                     double var46 = 1.0 - var45 * var45 * var45;
                     double var49 = (0.15 + var46 * var26 * var22) * 0.62;
                     double var50 = var44 < 0.3 ? 1.0 : (1.0 - var44) / 0.7;
                     var50 = var50 < 0.0 ? 0.0 : (var50 > 1.0 ? 1.0 : var50);
                     var50 = var50 * var50 * (3.0 - 2.0 * var50);
                     int var53 = (int)(var50 * 157.0 * (double)var9);
                     if (var53 > 4) {
                        int var41 = this.bw(var21[0], var21[1], var21[2], var49);
                        this.bx(var1, var41, var53 << 24 | var43, (float)var7, (int)((float)var53 * 0.24F) << 24 | var43);
                     }
                  }
               }
            }
         } catch (Throwable var42) {
         }
      }
   }

   private void cj(DrawContext var1) {

      LivingEntity var2 = this.sn;
      float var3 = this.om;
      if (var3 > 0.004F && var2 != null && var2 == this.tn && this.qd) {
         Object var4 = null;

         try {
            long var5 = this.qe;
            boolean var7 = false;

            for (int var8 = 0; var8 < 8; var8++) {
               long var9 = var5 - this.tj[var8];
               if (this.tj[var8] != 0L && var9 >= 0L && var9 < 900L) {
                  var7 = true;
                  break;
               }
            }

            if (!var7) {
               return;
            }

            var4 = var2.getLerpedPos(this.qc);
            if (!this.bv(((Vec3d)var4).x, ((Vec3d)var4).y + (double)var2.getHeight() + 0.45, ((Vec3d)var4).z)) {
               return;
            }

            float var34 = this.qm;
            float var35 = this.qn;
            Matrix3x2fStack var10 = var1.getMatrices();

            for (int var11 = 0; var11 < 8; var11++) {
               long var12 = var5 - this.tj[var11];
               if (this.tj[var11] != 0L && var12 >= 0L && var12 < 900L) {
                  float var14 = (float)var12 / 900.0F;
                  float var15 = 1.0F - var14;
                  float var16 = 18.0F * (1.0F - var15 * var15 * var15);
                  float var17 = var14 < 0.6F ? 1.0F : var15 / 0.4F;
                  var17 = var17 * var17 * (3.0F - 2.0F * var17);
                  float var18 = var12 < 160L ? (float)var12 / 160.0F : 1.0F;
                  float var19 = 1.0F - var18;
                  float var20 = 1.42F - 0.42F * (1.0F - var19 * var19 * var19);
                  float var21 = this.ti[var11] * (0.3F + 0.7F * var14);
                  int var22 = (int)(var17 * var3 * 255.0F);
                  if (var22 >= 8) {
                     String var23 = this.tk[var11];
                     if (var23 != null) {
                        float var24 = this.tg[var11];
                        int var25 = var24 >= 6.0F ? 1642620117 ^ 1628909470 : (var24 >= 3.0F ? -130925274 ^ -120744410 : -506252823 ^ -517156465);
                        int var26 = cw(var23, var20);
                        int var27 = lm[var26];
                        var10.pushMatrix();

                        try {
                           var10.translate(var34 + var21, var35 - var16);
                           var10.scale(var20, var20);
                           var1.drawText(a.textRenderer, ll[var26], -var27 / 2, -4, var22 << 24 | var25, true);
                        } finally {
                           var10.popMatrix();
                        }
                     }
                  }
               }
            }
         } catch (Throwable var32) {
         }
      }
   }

   public static void ck(DrawContext var0) {

      if (ON || LINGER) {
         NodeZoneRenderer var1 = INSTANCE;
         if (var1 != null) {
            LivingEntity var2 = var1.ub;
            if (var2 != null) {
               long var3 = System.nanoTime();
               if (var3 - var1.uc > 250000000L) {
                  var1.ub = null;
               } else if (a.player != null && !a.options.hudHidden && !(a.currentScreen instanceof LoaderDelegate)) {
                  boolean var5 = false;

                  try {
                     var5 = a.debugHudEntryList.isF3Enabled();
                  } catch (Throwable var28) {
                  }

                  if (!var5) {
                     int var6 = var1.tx;
                     double var7 = (double)a.getWindow().getScaleFactor();
                     if (var7 <= 0.0) {
                        var7 = 1.0;
                     }

                     float var9 = (float)((double)var6 / var7);
                     StyleKeyCache.e(var6);
                     StyleKeyCache.a(var1.ty, var1.tz);
                     String var10 = var1.un;
                     int var11 = var1.ur;
                     if (var10 != var1.uv && (var10 == null || !var10.equals(var1.uv)) || var11 != var1.ux || StyleKeyCache.ba != var1.uy) {
                        var1.cl(var10, var11);
                     }

                     float var12 = var1.uu == 0L ? 0.0F : Math.min(0.1F, Math.max(0.0F, (float)(var3 - var1.uu) / 1.0E9F));
                     var1.uu = var3;
                     float var13 = var1.uz;
                     if (var2 == var1.us && var1.ut > 0.0F) {
                        var1.ut = var1.ut + (var13 - var1.ut) * (1.0F - (float)Math.exp(-13.0 * (double)var12));
                        if (Math.abs(var13 - var1.ut) < 0.05F) {
                           var1.ut = var13;
                        }
                     } else {
                        var1.us = var2;
                        var1.ut = var13;
                     }

                     float var14 = var1.ut;
                     float var15 = (float)((int)((float)a.getWindow().getScaledWidth() / var9));
                     float var16 = (float)((int)((float)a.getWindow().getScaledHeight() / var9));
                     float var17 = 19.5F * var1.um;
                     float var18 = (float)(var1.mp * (double)var15) - var14 * 0.5F;
                     float var19 = (float)(var1.mq * (double)var16) - 21.0F;
                     var18 = Math.max(2.0F, Math.min(var18, var15 - var14 - 2.0F));
                     var19 = Math.max(2.0F + var17, Math.min(var19, var16 - 42.0F - 2.0F));
                     var18 = (float)Math.round(var18 * (float)var6) / (float)var6;
                     var19 = (float)Math.round(var19 * (float)var6) / (float)var6;
                     float var20 = var1.ui;
                     Matrix3x2fStack var21 = var0.getMatrices();
                     var0.createNewRootLayer();
                     var21.pushMatrix();

                     try {
                        var21.scale(var9, var9);
                        if (var20 < 0.999F) {
                           float var22 = 0.94F + 0.06F * var20;
                           float var23 = var18 + var14 * 0.5F;
                           float var24 = var19 + 21.0F;
                           var21.translate(var23, var24);
                           var21.scale(var22, var22);
                           var21.translate(-var23, -var24);
                        }

                        var21.translate(var18, var19);
                        var1.cm(var0, var14, var1.uh, var1.ul, var2, var1.uo, var1.up, var1.uq, var11, var1.ta, var1.tb, var1.uj, false);
                        if (var1.uk > 0.004F) {
                           var1.cn(var0, var14, var1.uk, var1.so, var6);
                        }
                     } finally {
                        var21.popMatrix();
                     }
                  }
               }
            }
         }
      }
   }

   private void cl(String var1, int var2) {

      this.uv = var1;
      this.ux = var2;
      this.uy = StyleKeyCache.ba;
      String var3 = var1 != null ? var1 : ku[8];
      float var4 = StyleKeyCache.f(8, var3);
      float var5 = 0.0F;
      String var6 = null;
      if (var2 > 0) {
         var6 = dr(5, (long)var2);
         var5 = 13.5F + StyleKeyCache.f(1, var6);
      }

      float var7 = Math.min(200.0F, Math.max(134.0F, 45.0F + var4 + var5 + 8.0F));
      String var8 = StyleKeyCache.o(var3, 8, var7 - 53.0F - var5);
      this.vc = StyleKeyCache.txt(8, var8);
      this.va = var8 == var3 ? var4 : StyleKeyCache.f(8, var8);
      this.uw = var6;
      this.vb = var5;
      this.uz = var7;
   }

   private void cm(
      DrawContext var1,
      float var2,
      float var3,
      float var4,
      LivingEntity var5,
      String var6,
      String var7,
      int var8,
      int var9,
      float var10,
      float var11,
      float var12,
      boolean var13
   ) {

      Object var14 = null;
      SkinTextures var15 = null;
      Identifier var16 = null;
      Object var17 = null;
      Matrix3x2fStack var18 = var1.getMatrices();
      int var19 = (int)((var3 < 0.0F ? 0.0F : (var3 > 1.0F ? 1.0F : var3)) * 255.0F + 0.5F);
      boolean var20 = !this.tu;
      int var21 = StyleKeyCache.PANEL;
      if (!var20) {
         StyleKeyCache.r(var1, 0.0F, 0.0F, var2, 42.0F, 7.0F, ((var21 >>> 24) * var19 + 127) / (290150581 ^ 290150474) << 24 | var21 & (-14694055 ^ -2083162));
      }

      if (var5 instanceof AbstractClientPlayerEntity var36) {
         var15 = var36.getSkin();
         if (var15 != null) {
            var16 = var15.body().texturePath();
         }
      }

      int var22 = -1;
      if (var16 != null) {
         int var23 = StyleKeyCache.MAG;

         for (int var24 = 0; var24 < 6; var24++) {
            if (this.vt[var24] && this.vr[var24] == var23 && var16.equals(this.vq[var24])) {
               var22 = var24;
               break;
            }
         }

         if (var22 >= 0) {
            this.vu[var22] = System.nanoTime();
         } else {
            var22 = this.co(var16, var23, System.nanoTime());
         }
      }

      if (var22 >= 0) {
         StyleKeyCache.u(var1, vo[var22], 2.0F, 2.0F, 38.0F, 38.0F, this.vs[var22], this.vs[var22], var19 << 24 | 1651754707 ^ 1653356844);
      } else if (var15 != null) {
         if (var19 > 0) {
            int var45 = StyleKeyCache.MAG;
            var18.pushMatrix();

            try {
               var18.scale(1.0F / (float)var45, 1.0F / (float)var45);
               PlayerSkinDrawer.draw(var1, var15, 2 * var45, 2 * var45, 38 * var45, var19 << 24 | -2141928004 ^ -2136262077);
            } finally {
               var18.popMatrix();
            }
         }
      } else {
         String var46 = this.uv;
         if (var46 != null && var46 != this.vg && !var46.equals(this.vg)) {
            this.vg = var46;
            this.vh = var46.isEmpty() ? var46 : var46.substring(0, var46.offsetByCodePoints(0, 1)).toUpperCase(Locale.ROOT);
         }

         StyleKeyCache.r(var1, 2.0F, 2.0F, 38.0F, 38.0F, 6.0F, (64 * var19 + 127) / (-253985560 ^ -253985769) << 24 | StyleKeyCache.A & (701006896 ^ 691502031));
         var21 = 467865632 ^ -468261417;
         StyleKeyCache.m(
            var1, 8, this.vh, 21.0F, 24.1F, 1, ((var21 >>> 24) * var19 + 127) / (-1617955223 ^ -1617955178) << 24 | var21 & (170143634 ^ 182177901), var20
         );
      }

      if (var12 > 0.01F) {
         int var47 = (int)(Math.min(0.55F, var12) * (float)var19 + 0.5F);
         if (var47 > 0) {
            StyleKeyCache.r(var1, 2.0F, 2.0F, 38.0F, 38.0F, 6.0F, var47 << 24 | -1577217900 ^ -1593663324);
         }
      }

      var21 = 1856808545 ^ -1856416874;
      StyleKeyCache.i(var1, this.vc, 45.0F, 13.5F, ((var21 >>> 24) * var19 + 127) / (1893418668 ^ 1893418579) << 24 | var21 & (498775369 ^ 491080374), var20);
      if (var9 > 0 && this.uw != null && var4 > 0.004F) {
         float var48 = 45.0F + this.va + 4.0F;
         float var50 = 1.0F;
         long var25 = this.qe - this.sv;
         if (!var13 && var25 >= 0L && var25 < 340L) {
            float var27 = (float)var25 / 340.0F;
            float var28 = 1.0F - var27;
            var50 = 1.0F + 0.5F * var28 * var28 * (float)Math.cos((double)(var27 * 9.0F));
            if (var50 < 0.65F) {
               var50 = 0.65F;
            }
         }

         float var53 = var4 >= 1.0F ? 1.0F : var4;
         if (var53 > 0.03F) {
            var17 = this.ri;
            if (var17 == null) {
               var17 = this.cv();
            }

            var18.pushMatrix();

            try {
               var18.translate(var48 + 4.0F, 10.4F);
               var18.scale(0.5F * var50 * var53, 0.5F * var50 * var53);
               var1.drawItem((ItemStack)var17, -8, -8);
            } finally {
               var18.popMatrix();
            }
         }

         int var54 = (int)((var4 > 1.0F ? 1.0F : var4) * 255.0F + 0.5F);
         var21 = StyleKeyCache.A;
         StyleKeyCache.l(
            var1, 1, this.uw, var48 + 9.5F, 13.5F, ((var21 >>> 24) * var54 + 127) / (-503892855 ^ -503892874) << 24 | var21 & (-1003538404 ^ -992950301), var20
         );
      }

      if (var6 != null) {
         var21 = -1757866031 ^ 1756862786;
         StyleKeyCache.l(
            var1, 4, var6, 45.0F, 23.0F, ((var21 >>> 24) * var19 + 127) / (-2045985310 ^ -2045985507) << 24 | var21 & (-1951425632 ^ -1957665697), var20
         );
         if (var7 != null) {
            if (var6 != this.vd || StyleKeyCache.ba != this.ve) {
               this.vd = var6;
               this.ve = StyleKeyCache.ba;
               this.vf = StyleKeyCache.f(4, var6);
            }

            StyleKeyCache.l(var1, 4, var7, 45.0F + this.vf, 23.0F, var19 << 24 | var8 & (-851156991 ^ -843341826), var20);
         }
      }

      if (this.mi) {
         var21 = 698423089 ^ 643754190;
         StyleKeyCache.s(var1, 45.0F, 28.5F, 81.0F, 5.0F, ((var21 >>> 24) * var19 + 127) / (-1015129699 ^ -1015129758) << 24 | var21 & (840882300 ^ 853616515));
         float var49 = var10 < 0.0F ? 0.0F : (var10 > 1.0F ? 1.0F : var10);
         float var51 = var11 < 0.0F ? 0.0F : (var11 > 1.0F ? 1.0F : var11);
         float var52 = Math.max(5.0F, 81.0F * var49);
         float var26 = Math.max(5.0F, 81.0F * var51);
         if (var26 > var52 + 0.25F) {
            var21 = 632602148 ^ 2085306843;
            StyleKeyCache.s(
               var1, 45.0F, 28.5F, var26, 5.0F, ((var21 >>> 24) * var19 + 127) / (-1127643368 ^ -1127643161) << 24 | var21 & (-748948717 ^ -744223508)
            );
         }

         var21 = -1319512856 ^ 1315335065;
         StyleKeyCache.s(var1, 45.0F, 28.5F, var52, 5.0F, ((var21 >>> 24) * var19 + 127) / (-816863069 ^ -816863140) << 24 | var21 & (476082902 ^ 480218409));
      }
   }

   private void cn(DrawContext var1, float var2, float var3, ItemStack[] var4, int var5) {

      ItemStack var6 = null;
      ItemStack var7 = var4[4];
      ItemStack var8 = var4[5];
      boolean var9 = var7 == null || var7.isEmpty();
      boolean var10 = var8 == null || var8.isEmpty();
      int var11 = 0;

      for (int var12 = 0; var12 < 4; var12++) {
         var6 = var4[var12];
         if (var6 != null && !var6.isEmpty()) {
            var11++;
         }
      }

      boolean var42 = !var9 || !var10;
      if (var11 != 0 || var42) {
         int var13 = (int)((var3 < 0.0F ? 0.0F : (var3 > 1.0F ? 1.0F : var3)) * 255.0F + 0.5F);
         int var14 = StyleKeyCache.PANEL;
         int var15 = ((var14 >>> 24) * var13 + 127) / (1184631515 ^ 1184631332) << 24 | var14 & (869202518 ^ 858850729);
         float var16 = -19.5F;
         float var17 = var2 - 30.0F;
         boolean var18 = this.tu;
         if (var11 > 0 && var18) {
            StyleKeyCache.s(var1, 0.0F, var16, 5.0F + 11.0F * (float)var11 + 3.0F, 16.0F, var15);
         }

         if (var42) {
            if (var18) {
               StyleKeyCache.s(var1, var17, var16, 30.0F, 16.0F, var15);
            }

            var14 = -1793298351 ^ 1788018370;
            int var19 = ((var14 >>> 24) * var13 + 127) / (-1378599998 ^ -1378600131) << 24 | var14 & (960621823 ^ 968758016);
            if (var9) {
               StyleKeyCache.ab(var1, 14, var17 + 5.5F, var16 + 3.0F, 8.0F, var19);
            }

            if (var10) {
               StyleKeyCache.ab(var1, 14, var17 + 16.5F, var16 + 3.0F, 8.0F, var19);
            }
         }

         float var44 = var3 >= 1.0F ? 1.0F : (var3 <= 0.0F ? 0.0F : var3);
         float var20 = 5.0F * (1.0F - var44);
         float var21 = 0.625F * var44;
         Matrix3x2fStack var22 = var1.getMatrices();
         var22.pushMatrix();

         try {
            int var23 = 0;

            for (int var24 = 0; var24 < 6 && var44 > 0.03F; var24++) {
               var6 = var4[var24];
               if (var6 != null && !var6.isEmpty()) {
                  float var25 = var24 < 4 ? 5.0F + 11.0F * (float)(var23++) : var17 + 5.0F + 11.0F * (float)(var24 - 4);
                  var22.pushMatrix();

                  try {
                     var22.translate(var25 + var20, var16 + 2.5F + var20);
                     var22.scale(var21, var21);
                     var1.drawItem((ItemStack)var6, 0, 0);
                  } finally {
                     var22.popMatrix();
                  }
               }
            }

            var22.scale(1.0F / (float)var5, 1.0F / (float)var5);
            var23 = 0;

            for (int var46 = 0; var46 < 6; var46++) {
               var6 = var4[var46];
               if (var6 != null && !var6.isEmpty()) {
                  float var47 = (var46 < 4 ? 5.0F + 11.0F * (float)(var23++) : var17 + 5.0F + 11.0F * (float)(var46 - 4)) + 0.5F;
                  if (var6.isDamageable()) {
                     int var26 = var6.getItemBarStep();
                     if (var26 > 0) {
                        int var27 = var13 << 24 | var6.getItemBarColor() & (-1635216151 ^ -1636340970);
                        int var28 = Math.round(var47 * (float)var5);
                        int var29 = Math.round((var16 + 12.0F) * (float)var5);
                        int var30 = Math.max(var28 + 1, Math.round((var47 + 9.0F * (float)Math.min(13, var26) / 13.0F) * (float)var5));
                        int var31 = Math.max(var29 + 1, Math.round((var16 + 13.3F) * (float)var5));
                        if (var31 - var29 >= 3 && var30 - var28 >= 3) {
                           var1.fill(var28 + 1, var29, var30 - 1, var31, var27);
                           var1.fill(var28, var29 + 1, var28 + 1, var31 - 1, var27);
                           var1.fill(var30 - 1, var29 + 1, var30, var31 - 1, var27);
                        } else {
                           var1.fill(var28, var29, var30, var31, var27);
                        }
                     }
                  }
               }
            }
         } finally {
            var22.popMatrix();
         }
      }
   }

   private int co(Identifier var1, int var2, long var3) {

      int var5 = -1;

      for (int var6 = 0; var6 < 6; var6++) {
         if (this.vr[var6] == var2 && var1.equals(this.vq[var6])) {
            if (var3 - this.vv[var6] < 3000000000L) {
               return -1;
            }

            var5 = var6;
            break;
         }
      }

      if (var5 < 0) {
         long var9 = Long.MAX_VALUE;

         for (int var8 = 0; var8 < 6; var8++) {
            if (this.vq[var8] == null) {
               var5 = var8;
               break;
            }

            if (var3 - this.vu[var8] > 200000000L && this.vu[var8] < var9) {
               var9 = this.vu[var8];
               var5 = var8;
            }
         }
      }

      if (var5 < 0) {
         return -1;
      } else {
         this.vq[var5] = var1;
         this.vr[var5] = var2;
         this.vu[var5] = var3;
         this.vv[var5] = var3;
         this.vt[var5] = false;
         boolean var10 = this.cp(var5, var1, var2);
         this.vt[var5] = var10;
         return var10 ? var5 : -1;
      }
   }

   private boolean cp(int var1, Identifier var2, int var3) {

      Object var4 = null;
      Object var5 = null;
      NativeImage var6 = null;
      NativeImage var7 = null;
      NativeImage var8 = null;
      Resource var9 = null;
      InputStream var10 = null;
      int[] var11 = this.vw;
      int[] var12 = this.vx;
      int[] var13 = this.vy;
      float[] var14 = this.vz;
      boolean var15 = false;

      try {
         if (a.getTextureManager().getTexture(var2) instanceof NativeImageBackedTexture var61) {
            var6 = var61.getImage();
         }

         if (var6 == null) {
            var9 = (Resource)a.getResourceManager().getResource(var2).orElse(null);
            if (var9 != null) {
               var10 = var9.getInputStream();
               var7 = NativeImage.read(var10);
               var6 = var7;
            }
         }

         int var16 = var6 == null ? 1 : Math.max(1, var6.getWidth() / 64);
         if (var6 != null && var6.getWidth() >= 48 * var16 && var6.getHeight() >= 16 * var16) {
            for (int var17 = 0; var17 < 8; var17++) {
               for (int var18 = 0; var18 < 8; var18++) {
                  int var19 = var6.getColorArgb((8 + var18) * var16, (8 + var17) * var16);
                  int var20 = var6.getColorArgb((40 + var18) * var16, (8 + var17) * var16);
                  int var21 = var20 >>> 24;
                  int var22 = var19 >> 16 & (361693086 ^ 361693025);
                  int var23 = var19 >> 8 & (-1679488128 ^ -1679488129);
                  int var24 = var19 & (2033342498 ^ 2033342685);
                  if (var21 > 0) {
                     var22 = (var22 * ((-1088719328 ^ -1088719137) - var21) + (var20 >> 16 & (1720519020 ^ 1720519059)) * var21 + 127)
                        / (1529626142 ^ 1529626337);
                     var23 = (var23 * ((-1133116050 ^ -1133116015) - var21) + (var20 >> 8 & (-1011826722 ^ -1011826911)) * var21 + 127)
                        / (970793489 ^ 970793710);
                     var24 = (var24 * ((173087217 ^ 173086990) - var21) + (var20 & (-1250508481 ^ -1250508352)) * var21 + 127) / (-1319879137 ^ -1319878944);
                  }

                  var11[var17 * 8 + var18] = var22 << 16 | var23 << 8 | var24;
               }
            }

            int var63 = Math.max(8, Math.min(var12.length, Math.round(38.0F * (float)var3)));
            int var64 = Math.round(6.0F * (float)var3);

            for (int var65 = 0; var65 < var63; var65++) {
               float var67 = (float)var65 * 8.0F / (float)var63;
               float var69 = (float)(var65 + 1) * 8.0F / (float)var63;
               int var71 = Math.min(7, (int)var67);
               int var73 = Math.min(7, (int)(var69 - 1.0E-4F));
               var12[var65] = var71;
               var13[var65] = var73;
               var14[var65] = var73 == var71 ? 1.0F : ((float)(var71 + 1) - var67) / (var69 - var67);
            }

            var8 = new NativeImage(NativeImage.Format.RGBA, var63, var63, false);

            for (int var66 = 0; var66 < var63; var66++) {
               int var68 = var12[var66] * 8;
               int var70 = var13[var66] * 8;
               float var72 = var14[var66];
               float var74 = var66 < var64
                  ? (float)var64 - ((float)var66 + 0.5F)
                  : (var66 >= var63 - var64 ? (float)var66 + 0.5F - (float)(var63 - var64) : 0.0F);

               for (int var75 = 0; var75 < var63; var75++) {
                  int var25 = var12[var75];
                  int var26 = var13[var75];
                  float var27 = var14[var75];
                  int var28 = var11[var68 + var25];
                  int var29 = var11[var68 + var26];
                  int var30 = var11[var70 + var25];
                  int var31 = var11[var70 + var26];
                  float var32 = var27 * var72;
                  float var33 = (1.0F - var27) * var72;
                  float var34 = var27 * (1.0F - var72);
                  float var35 = (1.0F - var27) * (1.0F - var72);
                  int var36 = (int)(
                     (float)(var28 >> 16 & (1725912902 ^ 1725913017)) * var32
                        + (float)(var29 >> 16 & (1994271021 ^ 1994271186)) * var33
                        + (float)(var30 >> 16 & (1789906065 ^ 1789906030)) * var34
                        + (float)(var31 >> 16 & (-106014471 ^ -106014714)) * var35
                        + 0.5F
                  );
                  int var37 = (int)(
                     (float)(var28 >> 8 & (-1067569564 ^ -1067569509)) * var32
                        + (float)(var29 >> 8 & (1235765319 ^ 1235765432)) * var33
                        + (float)(var30 >> 8 & (-666339543 ^ -666339370)) * var34
                        + (float)(var31 >> 8 & (1686401364 ^ 1686401451)) * var35
                        + 0.5F
                  );
                  int var38 = (int)(
                     (float)(var28 & (980427626 ^ 980427669)) * var32
                        + (float)(var29 & (-1388894709 ^ -1388894476)) * var33
                        + (float)(var30 & (-203612282 ^ -203612295)) * var34
                        + (float)(var31 & (1808774761 ^ 1808774806)) * var35
                        + 0.5F
                  );
                  float var39 = var75 < var64
                     ? (float)var64 - ((float)var75 + 0.5F)
                     : (var75 >= var63 - var64 ? (float)var75 + 0.5F - (float)(var63 - var64) : 0.0F);
                  int var40 = -1459527986 ^ -1459528143;
                  if (var39 > 0.0F && var74 > 0.0F) {
                     float var41 = (float)var64 + 0.5F - (float)Math.sqrt((double)(var39 * var39 + var74 * var74));
                     var40 = var41 >= 1.0F ? 940219260 ^ 940219267 : (var41 <= 0.0F ? 0 : (int)(var41 * 255.0F + 0.5F));
                  }

                  var8.setColorArgb(
                     var75,
                     var66,
                     var40 << 24
                        | Math.min(395897734 ^ 395897721, var36) << 16
                        | Math.min(-459097860 ^ -459098109, var37) << 8
                        | Math.min(-24766972 ^ -24766725, var38)
                  );
               }
            }

            a.getTextureManager().registerTexture(vo[var1], new LayerTextureCache(ku[14], var8));
            var8 = null;
            this.vs[var1] = var63;
            var15 = true;
         }
      } catch (Throwable var58) {
         var15 = false;
      } finally {
         if (var8 != null) {
            try {
               var8.close();
            } catch (Throwable var57) {
            }
         }

         if (var7 != null) {
            try {
               var7.close();
            } catch (Throwable var56) {
            }
         }

         if (var10 != null) {
            try {
               var10.close();
            } catch (Throwable var55) {
            }
         }
      }

      return var15;
   }

   private void cq(DrawContext var1) {

      if (this.sn != null && (this.mg || this.nx > 0.0F)) {
         LivingEntity var2 = this.sn;

         try {
            long var3 = this.qe;
            double var5 = dz((double)(var3 - this.sx) / 180.0);
            var5 = var5 * var5 * (3.0 - 2.0 * var5);
            double var7;
            if (this.sy >= 0L) {
               var7 = dz(1.0 - (double)(var3 - this.sy) / 400.0);
            } else {
               var7 = dz(((double)this.sw + this.mr - (double)var3) / 300.0);
            }

            var7 = var7 * var7 * (3.0 - 2.0 * var7);
            double var9 = var5 * var7;
            float var11 = var2.getHealth() + var2.getAbsorptionAmount();
            float var12 = Math.max(1.0F, var2.getMaxHealth());
            this.cs(var2, MathHelper.clamp(var11 / var12, 0.0F, 1.0F), var3);
            if (var9 * (double)this.oj > 0.004) {
               float var13 = this.on;
               if (var13 > 0.002F) {
                  this.cr(var2, var9 * (double)var13, var5, var3);
               }

               if (var13 < 0.998F) {
                  this.da(var1, var2, var9 * (double)(1.0F - var13), var11, var12, var3);
               }
            }
         } catch (Throwable var14) {
         }
      }
   }

   private void cr(LivingEntity var1, double var2, double var4, long var6) {

      boolean var8 = var1 instanceof PlayerEntity;
      int var9 = 0;
      if (var8 && (this.mk || this.nz > 0.0F)) {
         int var10 = var1.getId();
         if (var10 != this.uf || this.ud != this.ue) {
            this.uf = var10;
            this.ue = this.ud;
            Integer var11 = this.tp.get(var10);
            this.ug = var11 != null ? var11 : 0;
         }

         var9 = this.ug;
         if (var10 == this.st && var9 > this.su) {
            this.sv = var6;
         }

         this.st = var10;
         this.su = var9;
      }

      String var16 = null;
      String var17 = null;
      int var12 = 0;
      if (this.mj) {
         var16 = dr(8, (long)Math.round(Math.max(0.0F, a.player.distanceTo(var1)) * 10.0F));
         if (var8) {
            ClientPlayNetworkHandler var13 = a.getNetworkHandler();
            PlayerListEntry var14 = var13 != null ? var13.getPlayerListEntry(var1.getUuid()) : null;
            if (var14 != null) {
               int var15 = var14.getLatency();
               var17 = dr(9, (long)var15);
               var12 = var15 < 80 ? 83095018 ^ 77991312 : (var15 < (1289221552 ^ 1289221414) ? -2088748820 ^ -2088765274 : 93731434 ^ 90791984);
            }
         }
      }

      float var18 = 0.0F;
      if (var1.maxHurtTime > 0 && var1.hurtTime > 0) {
         var18 = MathHelper.clamp(((float)var1.hurtTime - this.qc) / (float)var1.maxHurtTime, 0.0F, 1.0F);
      }

      this.un = this.cu(var1, var6);
      this.ct(var1);
      this.uo = var16;
      this.up = var17;
      this.uq = var12;
      this.ur = var9;
      this.uj = var18;
      this.uh = (float)(var2 * (double)this.oj);
      this.uk = (float)(var2 * (double)this.ok);
      this.ul = (float)(var2 * (double)this.ol);
      this.um = this.ot;
      this.ui = (float)var4;
      this.uc = System.nanoTime();
      this.ub = var1;
   }

   private void cs(LivingEntity var1, float var2, long var3) {

      long var5 = System.nanoTime();
      float var7 = this.tf == 0L ? 0.0F : Math.min(0.1F, Math.max(0.0F, (float)(var5 - this.tf) / 1.0E9F));
      this.tf = var5;
      if (var1 != this.sz) {
         this.sz = var1;
         this.ta = var2;
         this.tb = var2;
         this.tc = var2;
         this.te = 0L;
      } else {
         if (var2 < this.tc - 0.001F) {
            this.te = var3 + 380L;
         }

         this.tc = var2;
         this.ta = this.ta + (var2 - this.ta) * (1.0F - (float)Math.exp(-16.0 * (double)var7));
         if (var2 >= this.tb) {
            this.tb = var2;
         } else if (var3 >= this.te) {
            this.tb = this.tb + (this.ta - this.tb) * (1.0F - (float)Math.exp(-5.5 * (double)var7));
         }
      }
   }

   private ItemStack[] ct(LivingEntity var1) {

      ItemStack[] var2 = this.so;
      if (var1 != null) {
         var2[0] = var1.getEquippedStack(EquipmentSlot.HEAD);
         var2[1] = var1.getEquippedStack(EquipmentSlot.CHEST);
         var2[2] = var1.getEquippedStack(EquipmentSlot.LEGS);
         var2[3] = var1.getEquippedStack(EquipmentSlot.FEET);
         var2[4] = var1.getMainHandStack();
         var2[5] = var1.getOffHandStack();
         return var2;
      } else {
         for (int var3 = 0; var3 < 6; var3++) {
            var2[var3] = ItemStack.EMPTY;
         }

         return var2;
      }
   }

   private String cu(LivingEntity var1, long var2) {

      if (var1 != this.sq || this.sr == null || var2 - this.ss > 500L) {
         this.sq = var1;
         this.ss = var2;
         this.sr = var1.getName().getString();
      }

      return this.sr;
   }

   private ItemStack cv() {
      byte var1 = 0;

      while (true) {
         switch (var1) {
            case 0:
            default:
               if (yc != 0) {
                  Thread.currentThread().getName().length();
                  var1 = 1;
                  break;
               }
            case 1:
               if (this.ri == null) {
                  this.ri = new ItemStack(Items.TOTEM_OF_UNDYING);
                  var1 = 2;
                  break;
               }

               return this.ri;
            case 2:
               return this.ri;
         }
      }
   }

   private static int cw(String var0, float var1) {

      double var2 = 2.0;

      try {
         var2 = (double)a.getWindow().getScaleFactor();
      } catch (Throwable var9) {
      }

      int var4 = (int)Math.round(var2 * (double)var1 * 10.0);
      if (var4 < 10) {
         var4 = 10;
      } else if (var4 > 45) {
         var4 = 45;
      }

      int var5 = var0.hashCode() * 31 + var4 & 127;
      String var6 = lj[var5];
      if (lk[var5] != var4 || var6 == null || var6 != var0 && !var6.equals(var0)) {
         Text var7 = cx(var0, var4);
         int var8 = a.textRenderer.getWidth(var7);
         ll[var5] = var7;
         lm[var5] = var8;
         lj[var5] = var0;
         lk[var5] = var4;
      }

      return var5;
   }

   private static Text cx(String var0, int var1) {

      return Text.literal(var0).setStyle(xi[var1 - 10]);
   }

   private int cy(int var1) {

      return 14 + lm[cw(dr(5, var1 >= 10 ? (long)var1 : 8L), this.mo)];
   }

   private int[] cz(String var1, ItemStack[] var2, float var3, int var4, float var5) {

      boolean var6 = this.mi;
      boolean var7 = this.mj;
      int var8 = 0;
      if (var5 > 0.0F) {
         for (ItemStack var12 : var2) {
            if (var12 != null && !var12.isEmpty()) {
               var8++;
            }
         }
      }

      byte var24 = 6;
      byte var25 = 22;
      byte var26 = 16;
      byte var27 = 2;
      byte var13 = 9;
      float var14 = (float)lm[cw(var1, this.mo)] + (var3 > 0.0F ? (float)this.cy(var4) * var3 : 0.0F);
      int var15 = var7 ? lm[cw(ku[5], this.mo)] : 0;
      int var16 = var8 * (var26 + var27);
      float var17 = Math.max(Math.max(var14, (float)var15), 48.0F);
      float var18 = var17 + Math.max(0.0F, (float)var16 - var17) * var5;
      int var19 = var7 ? var13 + 1 : 0;
      int var20 = Math.max(var25, var13 + 2 + var19);
      int var21 = Math.max(var25, var13 + 1 + var19 + 2 + var26);
      float var22 = (float)var20 + (float)(var21 - var20) * var5;
      int[] var23 = this.sp;
      var23[0] = Math.round((float)(var24 + var25 + 7) + var18 + (float)var24);
      var23[1] = Math.round((float)var24 + var22 + (float)(var6 ? 12 : 0) + (float)var24);
      return var23;
   }

   private void da(DrawContext var1, LivingEntity var2, double var3, float var5, float var6, long var7) {

      float var9 = this.mo;
      double var10 = var3 * (double)this.oj;
      this.pe = var3 * (double)this.ok;
      this.pf = var3 * (double)this.ol;
      String var12 = this.cu(var2, var7);
      ItemStack[] var13 = this.ct(var2);
      boolean var14 = var2 instanceof PlayerEntity;
      boolean var15 = this.mh || this.ny > 0.0F;
      boolean var16 = var14 && (this.mk || this.nz > 0.0F);
      int var17 = 0;
      if (var16) {
         Integer var18 = this.tp.get(var2.getId());
         var17 = var18 != null ? var18 : 0;
         int var19 = var2.getId();
         if (var19 == this.st && var17 > this.su) {
            this.sv = var7;
         }

         this.st = var19;
         this.su = var17;
      }

      String var30 = null;
      String var31 = null;
      int var20 = 0;
      if (this.mj) {
         var30 = dr(3, (long)Math.round(Math.max(0.0F, a.player.distanceTo(var2)) * 10.0F));
         if (var14) {
            ClientPlayNetworkHandler var21 = a.getNetworkHandler();
            PlayerListEntry var22 = var21 != null ? var21.getPlayerListEntry(var2.getUuid()) : null;
            if (var22 != null) {
               int var23 = var22.getLatency();
               var31 = dr(4, (long)var23);
               var20 = var23 < 80 ? 1269317987 ^ 1274913049 : (var23 < (-2115067825 ^ -2115067687) ? -2069863515 ^ -2074106897 : -148103185 ^ -137149003);
            }
         }
      }

      int[] var32 = this.cz(var12, var13, var16 ? this.ou : 0.0F, var17, var15 ? this.ot : 0.0F);
      int var33 = Math.round((float)var32[0] * var9);
      int var34 = Math.round((float)var32[1] * var9);
      int var24 = a.getWindow().getScaledWidth();
      int var25 = a.getWindow().getScaledHeight();
      int var26 = (int)(this.mp * (double)var24) - var33 / 2;
      int var27 = (int)(this.mq * (double)var25) - var34 / 2;
      var26 = Math.max(2, Math.min(var26, var24 - var33 - 2));
      var27 = Math.max(2, Math.min(var27, var25 - var34 - 2));
      float var28 = 0.0F;
      if (var2.maxHurtTime > 0 && var2.hurtTime > 0) {
         var28 = MathHelper.clamp(((float)var2.hurtTime - this.qc) / (float)var2.maxHurtTime, 0.0F, 1.0F);
      }

      float var29 = (float)Math.sin((double)var7 * 0.09) * var28 * 1.5F;
      this.de(
         var1,
         var26,
         var27,
         var9,
         var10,
         var12,
         var5,
         var6,
         var13,
         var2,
         var32[0],
         var32[1],
         false,
         this.ta,
         this.tb,
         var30,
         var31,
         var20,
         var16,
         var17,
         var28,
         var29
      );
   }

   public void db(int var1, DrawContext var2, int var3, int var4) {

      if (var1 == 6) {
         this.cg(var2, var3, var4);
      } else if (this.q()) {
         this.dd(var2, var3, var4);
      } else {
         this.dc(var2, var3, var4);
      }
   }

   private void dc(DrawContext var1, int var2, int var3) {

      ClientPlayerEntity var4 = a.player;

      try {
         float var5 = this.mo;
         String var6 = var4 != null ? var4.getName().getString() : ku[8];
         float var7 = var4 != null ? var4.getHealth() + var4.getAbsorptionAmount() : 15.0F;
         float var8 = var4 != null ? Math.max(1.0F, var4.getMaxHealth()) : 20.0F;
         ItemStack[] var9 = this.ct(var4);
         boolean var10 = this.mk;
         int[] var11 = this.cz(var6, var9, var10 ? 1.0F : 0.0F, 2, this.mh ? 1.0F : 0.0F);
         int var12 = Math.round((float)var11[0] * var5);
         int var13 = Math.round((float)var11[1] * var5);
         float var14 = MathHelper.clamp(var7 / var8, 0.0F, 1.0F);
         this.de(
            var1,
            var2 - var12 / 2,
            var3 - var13 / 2,
            var5,
            1.0,
            var6,
            var7,
            var8,
            var9,
            var4,
            var11[0],
            var11[1],
            true,
            var14,
            Math.min(1.0F, var14 + 0.18F),
            ku[10],
            ku[11],
            304277928 ^ 309791186,
            var10,
            2,
            0.0F,
            0.0F
         );
      } catch (Throwable var15) {
      }
   }

   private void dd(DrawContext var1, int var2, int var3) {

      ClientPlayerEntity var4 = a.player;
      CoreZoneProcessor var5 = CoreZoneProcessor.I;
      Object var6 = null;
      Matrix3x2fStack var7 = var1.getMatrices();

      try {
         this.r(var5);
         int var8 = this.tx;
         StyleKeyCache.e(var8);
         StyleKeyCache.a(this.ty, this.tz);
         double var9 = (double)a.getWindow().getScaleFactor();
         if (var9 <= 0.0) {
            var9 = 1.0;
         }

         float var11 = var7.m00();
         if (!(var11 > 0.0F)) {
            var11 = 1.0F;
         }

         float var12 = (float)((double)var8 / ((double)var11 * var9));
         long var13 = ms();
         if (var4 != this.vk || this.vl == null || var13 - this.vm > 500L) {
            this.vk = var4;
            this.vm = var13;
            this.vl = var4 != null ? var4.getName().getString() : ku[8];
         }

         String var15 = this.vl;
         int var16 = this.mk ? 2 : 0;
         if (var15 != this.uv && (var15 == null || !var15.equals(this.uv)) || var16 != this.ux || StyleKeyCache.ba != this.uy) {
            this.cl(var15, var16);
         }

         float var17 = this.uz;
         this.vi = var12;
         this.vj = var17;
         float var18 = var4 != null ? var4.getHealth() + var4.getAbsorptionAmount() : 15.0F;
         float var19 = var4 != null ? Math.max(1.0F, var4.getMaxHealth()) : 20.0F;
         float var20 = MathHelper.clamp(var18 / var19, 0.0F, 1.0F);
         var6 = this.ct(var4);
         String var21 = this.mj ? dr(8, 34L) : null;
         String var22 = this.mj ? dr(9, 42L) : null;
         var7.pushMatrix();

         try {
            var7.translate((float)var2, (float)var3);
            var7.scale(var12, var12);
            var7.translate((float)Math.round(-var17 * 0.5F * (float)var8) / (float)var8, -21.0F);
            this.cm(var1, var17, 1.0F, 1.0F, var4, var21, var22, 326738298 ^ 321667328, var16, var20, Math.min(1.0F, var20 + 0.18F), 0.0F, true);
            if (this.mh) {
               this.cn(var1, var17, 1.0F, (ItemStack[])var6, var8);
            }
         } finally {
            var7.popMatrix();
         }
      } catch (Throwable var27) {
      }
   }

   private void de(
      DrawContext var1,
      int var2,
      int var3,
      float var4,
      double var5,
      String var7,
      float var8,
      float var9,
      ItemStack[] var10,
      LivingEntity var11,
      int var12,
      int var13,
      boolean var14,
      float var15,
      float var16,
      String var17,
      String var18,
      int var19,
      boolean var20,
      int var21,
      float var22,
      float var23
   ) {

      boolean var24 = var14 ? this.mh : this.mh || this.ny > 0.0F;
      boolean var25 = this.mi;
      boolean var26 = this.mj;
      double var27 = var14 ? var5 : this.pe;
      double var29 = var14 ? var5 : this.pf;
      AbstractClientPlayerEntity var31 = null;
      ItemStack var32 = null;
      Text var33 = null;
      Text var34 = null;
      Text var35 = null;
      if (var11 instanceof AbstractClientPlayerEntity) {
         var31 = (AbstractClientPlayerEntity)var11;
      }

      int var36 = Math.round((float)var12 * var4);
      int var37 = Math.round((float)var13 * var4);
      int var38 = this.p() & (222104176 ^ 230880655);
      int var39 = (int)(dz(var5) * 255.0 + 0.5);
      boolean var40 = var39 >= 8;
      int var41 = var39 << 24;
      int var42 = Math.min(60586165 ^ 60586058, 96 * this.mn / (778709177 ^ 778709065)) * var39 / (838620805 ^ 838620794) << 24;
      int var43 = var41 | var38;
      int var44 = this.mn * var39 / (521672132 ^ 521671995) << 24 | 318307307 ^ 318044159;
      int var45 = var41 | 789638661 ^ 791401802;
      int var46 = (795542165 ^ 795542053) * var39 / (1436117583 ^ 1436117680) << 24;
      int var47 = var41 | 810910233 ^ 816214502;
      int var48 = var41 | 668715852 ^ 661618564;
      int var49 = var41 | var19 & (-428243893 ^ -427394124);
      int var50 = var41 | 736605652 ^ 738176502;
      int var51 = (-1741535814 ^ -1741535991) * var39 / (-1418559597 ^ -1418559636) << 24 | -257998298 ^ -262102587;
      int var52 = (-1324468440 ^ -1324468248) * var39 / (831939169 ^ 831939230) << 24;
      int var53 = var41 | 768719519 ^ 758007136;
      Matrix3x2fStack var54 = var1.getMatrices();
      if (var14) {
         byte var55 = 2;
         int var56 = Math.max(var55 + 1, Math.round(4.0F * var4));
         dt(var1, var2 + 2, var3 + 3, var36, var37, var56, var42);
         dv(var1, var2, var3, var36, var37, var56, var55, var43);
         dt(var1, var2 + var55, var3 + var55, var36 - var55 * 2, var37 - var55 * 2, var56 - var55, var44);
      } else {
         double var122 = (double)a.getWindow().getScaleFactor();
         if (var122 <= 0.0) {
            var122 = 1.0;
         }

         var54.pushMatrix();

         try {
            var54.scale((float)(1.0 / var122), (float)(1.0 / var122));
            int var57 = (int)Math.round((double)var2 * var122);
            int var58 = (int)Math.round((double)var3 * var122);
            int var59 = (int)Math.round((double)var36 * var122);
            int var60 = (int)Math.round((double)var37 * var122);
            int var61 = Math.max(2, (int)Math.round(2.0 * var122));
            int var62 = Math.max(var61 + 2, (int)Math.round(4.0 * var122 * (double)var4));
            dt(var1, var57 + var61, var58 + var61 + 1, var59, var60, var62, var42);
            dv(var1, var57, var58, var59, var60, var62, var61, var43);
            dt(var1, var57 + var61, var58 + var61, var59 - var61 * 2, var60 - var61 * 2, var62 - var61, var44);
         } finally {
            var54.popMatrix();
         }
      }

      var54.pushMatrix();

      try {
         var54.translate((float)var2 + var23, (float)var3);
         var54.scale(var4, var4);
         byte var123 = 6;
         byte var124 = 22;
         byte var125 = 16;
         byte var126 = 2;
         byte var127 = 9;
         boolean var128 = false;
         if (var31 != null && var39 > 0) {
            try {
               PlayerSkinDrawer.draw(var1, var31.getSkin(), var123, var123, var124, var41 | -1125185331 ^ -1139738830);
               var128 = true;
            } catch (Throwable var115) {
            }
         }

         if (!var128) {
            var1.fill(var123, var123, var123 + var124, var123 + var124, var45);
         }

         if (var22 > 0.01F) {
            int var129 = Math.min(-344631795 ^ -344631566, (int)(150.0F * var22 * (float)var5));
            if (var129 > 0) {
               var1.fill(var123, var123, var123 + var124, var123 + var124, var129 << 24 | -1921233591 ^ -1920762503);
            }
         }

         int var130 = var123 + var124 + 7;
         int var131 = cw(var7, var4);
         var33 = ll[var131];
         int var63 = lm[var131];
         if (var40) {
            var1.drawText(a.textRenderer, (Text)var33, var130 + 1, var123 + 1, var46, false);
            var1.drawText(a.textRenderer, (Text)var33, var130, var123, var47, false);
         }

         float var64 = var14 ? 1.0F : this.ou;
         if (var20 && var21 > 0 && var29 > 0.004 && var64 > 0.02F) {
            int var65 = (int)(dz(var29) * 255.0 + 0.5);
            float var66 = var29 >= (double)var64 ? var64 : (float)var29;
            int var67 = var130 + var63 + 3;
            float var68 = 1.0F;
            long var69 = this.qe - this.sv;
            if (!var14 && var69 >= 0L && var69 < 340L) {
               float var71 = (float)var69 / 340.0F;
               float var72 = 1.0F - var71;
               var68 = 1.0F + 0.5F * var72 * var72 * (float)Math.cos((double)(var71 * 9.0F));
               if (var68 < 0.65F) {
                  var68 = 0.65F;
               }
            }

            var54.pushMatrix();

            try {
               if (var64 < 0.999F) {
                  float var144 = (float)(var130 + var63);
                  float var148 = (float)var123 + 4.0F;
                  var54.translate(var144, var148);
                  var54.scale(var64, var64);
                  var54.translate(-var144, -var148);
               }

               if (var66 > 0.03F) {
                  float var145 = 0.625F * var68 * var66 / var64;
                  var54.pushMatrix();

                  try {
                     var54.translate((float)var67 + 5.0F, (float)(var123 - 1) + 5.0F);
                     var54.scale(var145, var145);
                     var1.drawItem(this.cv(), -8, -8);
                  } finally {
                     var54.popMatrix();
                  }
               }

               if (var65 >= 8) {
                  var34 = ll[cw(dr(5, (long)var21), var4)];
                  var1.drawText(
                     a.textRenderer, (Text)var34, var67 + 12, var123 + 1, (1694287520 ^ 1694287376) * var65 / (2051580249 ^ 2051580326) << 24, false
                  );
                  var1.drawText(a.textRenderer, (Text)var34, var67 + 11, var123, var65 << 24 | 637629526 ^ 654224412, false);
               }
            } finally {
               var54.popMatrix();
            }
         }

         int var132 = var26 ? var127 + 1 : 0;
         if (var26 && var17 != null && var40) {
            int var133 = var123 + var127 + 1;
            int var136 = cw(var17, var4);
            var1.drawText(a.textRenderer, ll[var136], var130, var133, var48, true);
            if (var18 != null) {
               int var138 = var130 + lm[var136] + 8;
               var1.drawText(a.textRenderer, ll[cw(var18, var4)], var138, var133, var49, true);
            }
         }

         if (var24 && var27 > 0.004) {
            float var134 = var14 ? 1.0F : this.ot;
            float var137 = var27 >= (double)var134 ? var134 : (float)var27;
            float var139 = 8.0F * (var134 - var137);
            float var141 = (float)(var125 + var126) * var134;
            float var70 = (float)var130;
            int var146 = var123 + var127 + 1 + var132 + 2;

            for (int var149 = 0; var149 < var10.length && var137 > 0.03F; var149++) {
               var32 = var10[var149];
               if (var32 != null && !var32.isEmpty()) {
                  if (var137 >= 0.999F) {
                     int var73 = Math.round(var70);
                     var1.drawItem((ItemStack)var32, var73, var146);
                     var1.drawStackOverlay(a.textRenderer, (ItemStack)var32, var73, var146);
                  } else {
                     var54.pushMatrix();

                     try {
                        var54.translate(var70 + var139, (float)var146 + var139);
                        var54.scale(var137, var137);
                        var1.drawItem((ItemStack)var32, 0, 0);
                        var1.drawStackOverlay(a.textRenderer, (ItemStack)var32, 0, 0);
                     } finally {
                        var54.popMatrix();
                     }
                  }

                  var70 += var141;
               }
            }
         }

         if (var25) {
            byte var135 = 8;
            int var140 = var12 - var123 * 2;
            int var142 = var13 - var123 - var135;
            float var143 = MathHelper.clamp(var15, 0.0F, 1.0F);
            float var147 = MathHelper.clamp(var16, 0.0F, 1.0F);
            int var150 = (int)((float)var140 * var143);
            int var151 = (int)((float)var140 * var147);
            int var74 = 729955521 ^ -729662271 | dq(var143 * 0.33F, 0.85F, 1.0F);
            var1.fill(var123, var142, var123 + var140, var142 + var135, var50);
            if (var151 > var150) {
               var1.fill(var123 + var150, var142, var123 + var151, var142 + var135, var51);
            }

            var1.fill(var123, var142, var123 + var150, var142 + var135, var74 & (1695758054 ^ 1710016793) | var41);
            var1.fill(var123, var142, var123 + var150, var142 + 1, dy(var74, 55) & (1005634188 ^ 990854515) | var41);
            int var75 = Math.round(var8);
            int var76 = Math.round(var9);
            if (var40) {
               int var77 = cw(
                  dr(6, (long)(var75 < 0 ? 0 : var75 & (1673276343 ^ 1672729672)) << 20 | (long)(var76 < 0 ? 0 : var76 & (-651978215 ^ -651401754))), var4
               );
               var35 = ll[var77];
               int var78 = lm[var77];
               int var79 = var123 + (var140 - var78) / 2;
               int var80 = var142 + (var135 - var127) / 2 + 1;
               var1.drawText(a.textRenderer, (Text)var35, var79 + 1, var80 + 1, var52, false);
               var1.drawText(a.textRenderer, (Text)var35, var79, var80, var53, false);
            }
         }
      } finally {
         var54.popMatrix();
      }
   }

   private void df() {

      long var1 = System.nanoTime();
      if (this.wh == 0L || var1 - this.wh >= 1000000L) {
         float var3 = this.wh == 0L ? 0.0F : Math.min(0.1F, (float)(var1 - this.wh) / 1.0E9F);
         this.wh = var1;
         if (ConfigBridge.c != null && ConfigBridge.c.a()) {
            boolean var4 = ON && this.ne;
            float var5 = 1.0F - (float)Math.exp(-6.0 * (double)var3);
            float var6 = var4 ? this.nk : 0.0F;
            this.wa = this.wa + (var6 - this.wa) * var5;
            if (Math.abs(var6 - this.wa) < 0.001F) {
               this.wa = var6;
            }

            int var7;
            int var8;
            if (this.ng) {
               float var9 = (float)(ms() % (long)this.nm) / this.nm;
               var7 = dq(var9, 0.65F, 1.0F);
               var8 = this.nj == -1 ? -1 : (this.nj == -2 ? dq(var9 + 0.18F, 0.65F, 1.0F) : this.nj);
            } else {
               var7 = this.ni;
               var8 = this.nj == -2 ? this.ni : this.nj;
            }

            this.wg = var8 == -1;
            if (var8 == -1) {
               var8 = var7;
            }

            float var17 = (float)(var7 >> 16 & (12188941 ^ 12189170)) / 255.0F;
            float var10 = (float)(var7 >> 8 & (-296183204 ^ -296183133)) / 255.0F;
            float var11 = (float)(var7 & (-1007689400 ^ -1007689289)) / 255.0F;
            float var12 = (float)(var8 >> 16 & (645542189 ^ 645542354)) / 255.0F;
            float var13 = (float)(var8 >> 8 & (-113837068 ^ -113837301)) / 255.0F;
            float var14 = (float)(var8 & (-896485453 ^ -896485556)) / 255.0F;
            float[] var15 = this.wd;
            float[] var16 = this.we;
            if (this.wf && !(this.wa <= 0.002F)) {
               var15[0] += (var17 - var15[0]) * var5;
               var15[1] += (var10 - var15[1]) * var5;
               var15[2] += (var11 - var15[2]) * var5;
               var16[0] += (var12 - var16[0]) * var5;
               var16[1] += (var13 - var16[1]) * var5;
               var16[2] += (var14 - var16[2]) * var5;
               this.wb = this.wb + (this.nn - this.wb) * var5;
               this.wc = this.wc + (this.no - this.wc) * var5;
               if (Math.abs(this.nn - this.wb) < 0.001F) {
                  this.wb = this.nn;
               }

               if (Math.abs(this.no - this.wc) < 0.001F) {
                  this.wc = this.no;
               }
            } else {
               var15[0] = var17;
               var15[1] = var10;
               var15[2] = var11;
               var16[0] = var12;
               var16[1] = var13;
               var16[2] = var14;
               this.wb = this.nn;
               this.wc = this.no;
               this.wf = true;
            }

            SKY_HOT = var4 && var6 > 0.002F || this.wa > 0.002F;
            FOG_HOT = SKY_HOT && (var4 && this.nn > 0.0F || this.wa * this.wb > 0.001F);
            TINT_HOT = SKY_HOT && (var4 && this.no > 0.0F || this.wa * this.wc > 0.001F);
         } else {
            this.wa = 0.0F;
            SKY_HOT = false;
            FOG_HOT = false;
            TINT_HOT = false;
         }
      }
   }

   public float dg() {

      this.df();
      return this.wa * this.wc;
   }

   public float dh() {

      this.df();
      return this.wa;
   }

   public int di() {

      float[] var1 = this.wd;
      return dp(var1[0] * 255.0F) << 16 | dp(var1[1] * 255.0F) << 8 | dp(var1[2] * 255.0F);
   }

   public static Object dj(EnvironmentAttribute<?> var0, Object var1, Object var2) {

      boolean var3 = var0 == EnvironmentAttributes.SKY_COLOR_VISUAL;
      boolean var4 = !var3 && var0 == EnvironmentAttributes.STAR_BRIGHTNESS_VISUAL;
      boolean var5 = !var3 && !var4 && var0 == EnvironmentAttributes.CLOUD_COLOR_VISUAL;
      boolean var6 = !var3 && !var4 && !var5 && var0 == EnvironmentAttributes.FOG_START_DISTANCE_VISUAL;
      boolean var7 = !var3 && !var4 && !var5 && !var6 && var0 == EnvironmentAttributes.FOG_END_DISTANCE_VISUAL;
      if (!var3 && !var4 && !var5 && !var6 && !var7) {
         return null;
      } else {
         NodeZoneRenderer var8 = INSTANCE;
         CameraSubmersionType var9 = null;
         if (var8 != null && var1 != null && a.isOnThread()) {
            var8.df();
            float var10 = var8.wa;
            if (var10 <= 0.002F) {
               return null;
            } else if (var6 || var7) {
               float var19 = var10 * var8.wb;
               if (!(var19 <= 0.001F) && var1 instanceof Float) {
                  if (a.gameRenderer != null) {
                     var9 = a.gameRenderer.getCamera().getSubmersionType();
                  }

                  if (var9 != CameraSubmersionType.WATER && var9 != CameraSubmersionType.LAVA && var9 != CameraSubmersionType.POWDER_SNOW) {
                     float var22 = (Float)var1;
                     float var24 = var6
                        ? var22 * (1.0F - Math.min(1.0F, var19))
                        : (var22 > 32.0F ? var22 * (float)Math.pow((double)(32.0F / var22), (double)Math.min(1.0F, var19)) : var22);
                     if (var2 instanceof Float var26) {
                        var24 += (var26 - var24) * Math.min(1.0F, LerpZoneBuffer.t());
                     }

                     return var24;
                  } else {
                     return null;
                  }
               } else {
                  return null;
               }
            } else if (var3) {
               if (!var8.wg && var1 instanceof Integer) {
                  int var18 = (Integer)var1;
                  float var21 = var8.we[0];
                  float var23 = var8.we[1];
                  float var25 = var8.we[2];
                  if (!var8.nf) {
                     var21 *= (float)(var18 >> 16 & (-1773115090 ^ -1773114927)) / 255.0F;
                     var23 *= (float)(var18 >> 8 & (1987264929 ^ 1987264862)) / 255.0F;
                     var25 *= (float)(var18 & (2117438412 ^ 2117438259)) / 255.0F;
                  }

                  int var15 = dl(var18, var21, var23, var25, var10);
                  if (var2 instanceof Integer var16) {
                     var15 = dm(var15, var16, Math.min(1.0F, LerpZoneBuffer.t() * 1.45F));
                  }

                  return var15;
               } else {
                  return null;
               }
            } else if (var4) {
               if (!(var8.nl <= 0.0F) && var1 instanceof Float) {
                  float var17 = Math.max((Float)var1, var8.nl * var10);
                  if (var2 instanceof Float var20) {
                     var17 += (var20 - var17) * Math.min(1.0F, LerpZoneBuffer.t());
                  }

                  return var17;
               } else {
                  return null;
               }
            } else if (var8.nh && var1 instanceof Integer) {
               int var11 = (Integer)var1;
               float var12 = dk(var11);
               int var13 = dl(var11, var8.wd[0] * var12, var8.wd[1] * var12, var8.wd[2] * var12, 0.8F * var10);
               if (var2 instanceof Integer var14) {
                  var13 = dm(var13, var14, Math.min(1.0F, LerpZoneBuffer.t() * 1.45F));
               }

               return var13;
            } else {
               return null;
            }
         } else {
            return null;
         }
      }
   }

   private static float dk(int var0) {

      return (float)Math.max(var0 >> 16 & (540838871 ^ 540838696), Math.max(var0 >> 8 & (-326947878 ^ -326948059), var0 & (781575672 ^ 781575431))) / 255.0F;
   }

   private static int dl(int var0, float var1, float var2, float var3, float var4) {

      int var5 = var0 >>> 24;
      int var6 = var0 >> 16 & (500952518 ^ 500952377);
      int var7 = var0 >> 8 & (-593266533 ^ -593266588);
      int var8 = var0 & (1413058386 ^ 1413058477);
      int var9 = dp((float)var6 + (var1 * 255.0F - (float)var6) * var4);
      int var10 = dp((float)var7 + (var2 * 255.0F - (float)var7) * var4);
      int var11 = dp((float)var8 + (var3 * 255.0F - (float)var8) * var4);
      return var5 << 24 | var9 << 16 | var10 << 8 | var11;
   }

   private static int dm(int var0, int var1, float var2) {

      int var3 = var0 >>> 24;
      int var4 = var0 >> 16 & (-180442337 ^ -180442144);
      int var5 = var0 >> 8 & (-837031639 ^ -837031466);
      int var6 = var0 & (140408135 ^ 140408248);
      int var7 = var1 >>> 24;
      int var8 = var1 >> 16 & (2086375336 ^ 2086375255);
      int var9 = var1 >> 8 & (159739189 ^ 159739338);
      int var10 = var1 & (1827332917 ^ 1827333066);
      return dp((float)var3 + (float)(var7 - var3) * var2) << 24
         | dp((float)var4 + (float)(var8 - var4) * var2) << 16
         | dp((float)var5 + (float)(var9 - var5) * var2) << 8
         | dp((float)var6 + (float)(var10 - var6) * var2);
   }

   private static int dn(int var0, int var1, float var2) {

      return dm(var0 & (-703022520 ^ -689486409), var1 & (1524123967 ^ 1512552128), var2) & (207338268 ^ 212092131);
   }

   private static int _kwren_do(int var0, int var1, float var2) {

      int var3 = var1 >> 16 & (-1809299781 ^ -1809299900);
      int var4 = var1 >> 8 & (1662209943 ^ 1662209896);
      int var5 = var1 & (-930720067 ^ -930720190);
      int var6 = Math.max(var3, Math.max(var4, var5));
      if (var2 > 0.003F && var6 > 0) {
         float var7 = Math.min(1.0F, var2);
         float var8 = 1.0F / (float)var6;
         int var9 = dp((float)(var0 >> 16 & (-1542326919 ^ -1542326906)) * (1.0F - var7 * (1.0F - (float)var3 * var8)) + (float)var3 * 0.1F * var7);
         int var10 = dp((float)(var0 >> 8 & (-821367573 ^ -821367788)) * (1.0F - var7 * (1.0F - (float)var4 * var8)) + (float)var4 * 0.1F * var7);
         int var11 = dp((float)(var0 & (-340648497 ^ -340648656)) * (1.0F - var7 * (1.0F - (float)var5 * var8)) + (float)var5 * 0.1F * var7);
         return var9 << 16 | var10 << 8 | var11;
      } else {
         return var0 & (1689245123 ^ 1682975292);
      }
   }

   private static int dp(float var0) {

      int var1 = Math.round(var0);
      return var1 < 0 ? 0 : (var1 > (1068640561 ^ 1068640718) ? 1123853623 ^ 1123853768 : var1);
   }

   private static int dq(float var0, float var1, float var2) {

      int var3 = 0;
      int var4 = 0;
      int var5 = 0;
      if (var1 == 0.0F) {
         var3 = var4 = var5 = (int)(var2 * 255.0F + 0.5F);
      } else {
         float var6 = (var0 - (float)Math.floor((double)var0)) * 6.0F;
         float var7 = var6 - (float)Math.floor((double)var6);
         float var8 = var2 * (1.0F - var1);
         float var9 = var2 * (1.0F - var1 * var7);
         float var10 = var2 * (1.0F - var1 * (1.0F - var7));
         switch ((int)var6) {
            case 0:
               var3 = (int)(var2 * 255.0F + 0.5F);
               var4 = (int)(var10 * 255.0F + 0.5F);
               var5 = (int)(var8 * 255.0F + 0.5F);
               break;
            case 1:
               var3 = (int)(var9 * 255.0F + 0.5F);
               var4 = (int)(var2 * 255.0F + 0.5F);
               var5 = (int)(var8 * 255.0F + 0.5F);
               break;
            case 2:
               var3 = (int)(var8 * 255.0F + 0.5F);
               var4 = (int)(var2 * 255.0F + 0.5F);
               var5 = (int)(var10 * 255.0F + 0.5F);
               break;
            case 3:
               var3 = (int)(var8 * 255.0F + 0.5F);
               var4 = (int)(var9 * 255.0F + 0.5F);
               var5 = (int)(var2 * 255.0F + 0.5F);
               break;
            case 4:
               var3 = (int)(var10 * 255.0F + 0.5F);
               var4 = (int)(var8 * 255.0F + 0.5F);
               var5 = (int)(var2 * 255.0F + 0.5F);
               break;
            case 5:
               var3 = (int)(var2 * 255.0F + 0.5F);
               var4 = (int)(var8 * 255.0F + 0.5F);
               var5 = (int)(var9 * 255.0F + 0.5F);
         }
      }

      return var3 << 16 | var4 << 8 | var5;
   }

   private static String dr(int var0, long var1) {

      int var3 = (int)(var1 * 31L + (long)var0 & 127L);
      if (kw[var3] == var0 && kx[var3] == var1 && ky[var3] != null) {
         return ky[var3];
      } else {
         String var4 = ds(var0, var1);
         kw[var3] = var0;
         kx[var3] = var1;
         ky[var3] = var4;
         return var4;
      }
   }

   private static String ds(int var0, long var1) {

      if (var0 == 4) {
         return var1 + ku[2];
      } else if (var0 == 5) {
         return ku[3] + var1;
      } else if (var0 == 6) {
         return (var1 >>> 20) + ku[4] + (var1 & 1048575L);
      } else if (var0 == 9) {
         return ku[13] + var1 + ku[2];
      } else {
         long var3 = var1 / 10L;
         long var5 = var1 % 10L;
         if (var0 == 8) {
            return ku[12] + var3 + ku[7] + var5;
         } else if (var0 == 2) {
            return var3 + ku[7] + var5 + ku[0];
         } else if (var0 == 3) {
            return var3 + ku[7] + var5 + ku[1];
         } else {
            return var0 == 7 ? ku[6] + var3 + ku[7] + var5 : var3 + ku[7] + var5;
         }
      }
   }

   private static void dt(DrawContext var0, int var1, int var2, int var3, int var4, int var5, int var6) {

      if (var5 >= 1 && var3 >= 2 * var5 && var4 >= 2 * var5) {
         int var7 = var6 >>> 24 & (369573534 ^ 369573473);
         int var8 = var6 & (-1404609888 ^ -1397185185);
         var0.fill(var1 + var5, var2, var1 + var3 - var5, var2 + var4, var6);
         var0.fill(var1, var2 + var5, var1 + var5, var2 + var4 - var5, var6);
         var0.fill(var1 + var3 - var5, var2 + var5, var1 + var3, var2 + var4 - var5, var6);
         du(var0, var1, var2, (float)(var1 + var5), (float)(var2 + var5), var5, var7, var8);
         du(var0, var1 + var3 - var5, var2, (float)(var1 + var3 - var5), (float)(var2 + var5), var5, var7, var8);
         du(var0, var1, var2 + var4 - var5, (float)(var1 + var5), (float)(var2 + var4 - var5), var5, var7, var8);
         du(var0, var1 + var3 - var5, var2 + var4 - var5, (float)(var1 + var3 - var5), (float)(var2 + var4 - var5), var5, var7, var8);
      } else {
         var0.fill(var1, var2, var1 + var3, var2 + var4, var6);
      }
   }

   private static void du(DrawContext var0, int var1, int var2, float var3, float var4, int var5, int var6, int var7) {

      assert var0 != null
         && var5 >= 1
         && var5 <= (-1070894675 ^ -1070898771)
         && var6 >= 0
         && var6 <= (738213026 ^ 738212957)
         && (var7 & (1328408223 ^ -1339169121)) == 0
         && !Float.isNaN(var3)
         && !Float.isNaN(var4)
         && var1 > (2004460265 ^ -143019287)
         && var2 > (-218279811 ^ 1929199741)
         && var1 < (827945195 ^ 1319542548)
         && var2 < (2038220702 ^ 109258849)
         && pp.length == 37
         && pq.length == 37 : "corner";

      try {
         int var8 = var1 + var5;
         int var9 = var2 + var5;

         for (int var10 = var2; var10 < var9; var10++) {
            float var11 = (float)var10 + 0.5F - var4;
            float var12 = var11 * var11;
            int var13 = var1;
            int var14 = 0;

            for (int var15 = var1; var15 < var8; var15++) {
               float var16 = (float)var15 + 0.5F - var3;
               float var17 = (float)var5 + 0.5F - (float)Math.sqrt((double)(var16 * var16 + var12));
               int var18 = 0;
               if (var17 > 0.02F) {
                  int var19 = (int)((var17 > 1.0F ? 1.0F : var17) * (float)var6);
                  if (var19 > 1) {
                     var18 = var19 << 24 | var7;
                  }
               }

               if (var18 != var14) {
                  if (var14 != 0) {
                     var0.fill(var13, var10, var15, var10 + 1, var14);
                  }

                  var13 = var15;
                  var14 = var18;
               }
            }

            if (var14 != 0) {
               var0.fill(var13, var10, var8, var10 + 1, var14);
            }
         }
      } catch (RuntimeException var20) {
         throw var20;
      }
   }

   private static void dv(DrawContext var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {

      if (var6 >= 1 && var5 > var6 && var3 >= 2 * var5 && var4 >= 2 * var5) {
         int var8 = var7 >>> 24 & (2089990106 ^ 2089989925);
         int var9 = var7 & (-380474849 ^ -374499872);
         var0.fill(var1 + var5, var2, var1 + var3 - var5, var2 + var6, var7);
         var0.fill(var1 + var5, var2 + var4 - var6, var1 + var3 - var5, var2 + var4, var7);
         var0.fill(var1, var2 + var5, var1 + var6, var2 + var4 - var5, var7);
         var0.fill(var1 + var3 - var6, var2 + var5, var1 + var3, var2 + var4 - var5, var7);
         int var10 = var5 - var6;
         dw(var0, var1, var2, (float)(var1 + var5), (float)(var2 + var5), var5, var10, var8, var9);
         dw(var0, var1 + var3 - var5, var2, (float)(var1 + var3 - var5), (float)(var2 + var5), var5, var10, var8, var9);
         dw(var0, var1, var2 + var4 - var5, (float)(var1 + var5), (float)(var2 + var4 - var5), var5, var10, var8, var9);
         dw(var0, var1 + var3 - var5, var2 + var4 - var5, (float)(var1 + var3 - var5), (float)(var2 + var4 - var5), var5, var10, var8, var9);
      } else {
         dt(var0, var1, var2, var3, var4, var5, var7);
      }
   }

   private static void dw(DrawContext var0, int var1, int var2, float var3, float var4, int var5, int var6, int var7, int var8) {

      assert var0 != null
         && var5 >= 1
         && var5 <= (1130382671 ^ 1130386767)
         && var6 >= 0
         && var6 < var5
         && var7 >= 0
         && var7 <= (-350482714 ^ -350482919)
         && (var8 & (666784195 ^ -658615869)) == 0
         && !Float.isNaN(var3)
         && !Float.isNaN(var4)
         && var1 > (-925715781 ^ 1221763771)
         && var2 > (-2073722565 ^ 73765179)
         && var1 < (-90501292 ^ -2056986453)
         && var2 < (536052768 ^ 1611426783)
         && pp.length == 37
         && pq.length == 37 : "rin" + "gCorner";

      try {
         int var9 = var1 + var5;
         int var10 = var2 + var5;

         for (int var11 = var2; var11 < var10; var11++) {
            float var12 = (float)var11 + 0.5F - var4;
            float var13 = var12 * var12;
            int var14 = var1;
            int var15 = 0;

            for (int var16 = var1; var16 < var9; var16++) {
               float var17 = (float)var16 + 0.5F - var3;
               float var18 = (float)Math.sqrt((double)(var17 * var17 + var13));
               float var19 = (float)var5 - var18 + 0.5F;
               var19 = var19 < 0.0F ? 0.0F : (var19 > 1.0F ? 1.0F : var19);
               float var20 = (float)var6 - var18 + 0.5F;
               var20 = var20 < 0.0F ? 0.0F : (var20 > 1.0F ? 1.0F : var20);
               float var21 = var19 - var20;
               int var22 = 0;
               if (var21 > 0.02F) {
                  int var23 = (int)(var21 * (float)var7);
                  if (var23 > 1) {
                     var22 = var23 << 24 | var8;
                  }
               }

               if (var22 != var15) {
                  if (var15 != 0) {
                     var0.fill(var14, var11, var16, var11 + 1, var15);
                  }

                  var14 = var16;
                  var15 = var22;
               }
            }

            if (var15 != 0) {
               var0.fill(var14, var11, var9, var11 + 1, var15);
            }
         }
      } catch (RuntimeException var24) {
         throw var24;
      }
   }

   private static int dx(int var0, double var1) {

      int var3 = var0 >>> 24 & (-491043954 ^ -491043983);
      int var4 = (int)Math.round((double)var3 * dz(var1));
      return var4 << 24 | var0 & (-1054896053 ^ -1042255948);
   }

   private static int dy(int var0, int var1) {

      int var2 = Math.min(-930614499 ^ -930614302, (var0 >> 16 & (1475334987 ^ 1475335092)) + var1);
      int var3 = Math.min(1323878829 ^ 1323878738, (var0 >> 8 & (42584865 ^ 42585054)) + var1);
      int var4 = Math.min(994275639 ^ 994275784, (var0 & (1188445334 ^ 1188445289)) + var1);
      return var0 & (-1395966429 ^ 1405828643) | var2 << 16 | var3 << 8 | var4;
   }

   private static double dz(double var0) {

      return var0 < 0.0 ? 0.0 : (var0 > 1.0 ? 1.0 : var0);
   }

   private void ea(long var1) {

      EntityStatusS2CPacket[] var6 = this.sh;
      int var7 = a.player.getId();
      SELF_ID = var7;
      int var8 = System.identityHashCode(a.world);
      if (var8 != this.sk) {
         this.sk = var8;
         DEATH_Q.clear();
         DMG_Q.clear();
         Arrays.fill(this.sd, -2305843009213693952L);
         Arrays.fill(this.sg, -2305843009213693952L);
         this.eh();
      }

      if (this.sm >= 30 && !this.xs) {
         this.xs = true;
         NoticeQueue.err("Death Effects st" + "op" + "ped", "They kept failing" + "; the log has the er" + "r" + "or");
      }

      if (!DEATH_ON) {
         if (!DEATH_Q.isEmpty()) {
            DEATH_Q.clear();
         }

         if (!DMG_Q.isEmpty()) {
            DMG_Q.clear();
         }

         if (xk != 0) {
            this.eh();
         }
      } else {
         int var9 = 0;

         while (var9 < 32) {
            EntityStatusS2CPacket var3 = DEATH_Q.poll();
            if (var3 == null) {
               break;
            }

            var6[var9++] = var3;
         }

         if (var9 == 32) {
            DEATH_Q.clear();
         }

         int var10 = 0;

         while (var10 < 64) {
            EntityDamageS2CPacket var4 = DMG_Q.poll();
            if (var4 == null) {
               break;
            }

            var10++;
            int var11 = var4.entityId();
            if (var11 != var7) {
               this.ec(var11, var1);
            }
         }

         if (var10 == 64) {
            DMG_Q.clear();
         }

         for (int var17 = 0; var17 < var9; var17++) {
            EntityStatusS2CPacket var15 = var6[var17];
            var6[var17] = null;
            Entity var5 = var15.getEntity(a.world);
            if (var5 instanceof LivingEntity) {
               this.eb((LivingEntity)var5, var1);
            }
         }

         this.eg(var1);
         if (this.sj && a.player.isDead() && a.player.deathTime <= 4) {
            this.eb(a.player, var1);
         }

         if (this.rp != null && this.rp.isDead() && this.rp.deathTime <= 4) {
            this.eb(this.rp, var1);
         }

         if (this.sn != null && this.sn != this.rp && this.sn.isDead() && this.sn.deathTime <= 4) {
            this.eb(this.sn, var1);
         }

         int[] var18 = this.sc;
         long[] var12 = this.sd;

         for (int var13 = 0; var13 < 16; var13++) {
            if (var1 - var12[var13] <= 5000L) {
               Entity var16 = a.world.getEntityById(var18[var13]);
               if (var16 instanceof LivingEntity
                  && var16 != this.rp
                  && var16 != this.sn
                  && ((LivingEntity)var16).isDead()
                  && ((LivingEntity)var16).deathTime <= 4) {
                  this.eb((LivingEntity)var16, var1);
               }
            }
         }
      }

      if (this.sm < 30) {
         try {
            EchoPassCache.h();
         } catch (Throwable var14) {
            this.sm++;
         }
      }
   }

   private void eb(LivingEntity var1, long var2) {

      if (!(var1 instanceof ArmorStandEntity) && (!var1.isSpectator() || this.xr)) {
         boolean var4 = var1 == a.player;
         if (var4 || !(var1.squaredDistanceTo(a.player) > 4096.0)) {
            int var5 = var1.getId();
            int var6 = System.identityHashCode(var1);
            int[] var7 = this.se;
            int[] var8 = this.sf;
            long[] var9 = this.sg;
            int var10 = 0;

            for (int var11 = 0; var11 < 32; var11++) {
               if (var7[var11] == var5 && var8[var11] == var6 && var2 - var9[var11] < 3000L) {
                  var9[var11] = var2;
                  return;
               }

               if (var9[var11] < var9[var10]) {
                  var10 = var11;
               }
            }

            boolean var17 = false;
            if (var4) {
               if (!this.sj) {
                  return;
               }
            } else {
               int[] var12 = this.sc;
               long[] var13 = this.sd;

               for (int var14 = 0; var14 < 16; var14++) {
                  if (var12[var14] == var5 && var2 - var13[var14] <= 5000L) {
                     var17 = true;
                     break;
                  }
               }

               int var18 = this.si;
               boolean var15;
               if (var18 == 3) {
                  var15 = true;
               } else if (var18 == 2) {
                  var15 = var1 instanceof PlayerEntity;
               } else if (var18 != 1) {
                  var15 = var17;
               } else {
                  var15 = var17 || var1 == this.rp || var1 == this.sn;
               }

               if (!var15) {
                  return;
               }
            }

            var7[var10] = var5;
            var8[var10] = var6;
            var9[var10] = var2;

            try {
               if (RegionPassCache.ON && RegionPassCache.ae > 0.0F && RegionPassCache.f()) {
                  EchoPassCache.g(var1, var17);
               }
            } catch (Throwable var16) {
               this.sm++;
            }
         }
      }
   }

   private void ec(int var1, long var2) {

      int[] var4 = this.sc;
      long[] var5 = this.sd;
      int var6 = 0;

      for (int var7 = 0; var7 < 16; var7++) {
         if (var4[var7] == var1) {
            var5[var7] = var2;
            return;
         }

         if (var5[var7] < var5[var6]) {
            var6 = var7;
         }
      }

      var4[var6] = var1;
      var5[var6] = var2;
   }

   public static void ed(LivingEntity var0) {

      if (xk < xj.length) {
         xj[xk++] = var0;
      }
   }

   public static void ee(int var0, int var1, int var2) {

      int var3 = xy;
      xu[var3] = var0;
      xv[var3] = var1;
      xw[var3] = var2;
      xx[var3] = ms();
      xy = (var3 + 1) % 8;
   }

   public static boolean ef(double var0, double var2, double var4) {

      long var6 = ms();

      for (int var8 = 0; var8 < 8; var8++) {
         long var9 = xx[var8];
         if (var9 != 0L && var6 - var9 >= 0L && var6 - var9 <= 2500L) {
            double var11 = var0 - ((double)xu[var8] + 0.5);
            double var13 = var2 - ((double)xv[var8] + 0.5);
            double var15 = var4 - ((double)xw[var8] + 0.5);
            if (var11 * var11 + var13 * var13 + var15 * var15 <= 2.5600000000000005) {
               return true;
            }
         }
      }

      return false;
   }

   private void eg(long var1) {

      int var5 = xk;
      xk = 0;

      for (int var6 = 0; var6 < var5; var6++) {
         LivingEntity var3 = xj[var6];
         xj[var6] = null;
         if (var3 != null && var3.getEntityWorld() == a.world) {
            this.eb(var3, var1);
         }
      }

      int[] var15 = this.sc;
      long[] var7 = this.sd;

      for (int var8 = 0; var8 < 16; var8++) {
         if (var1 - var7[var8] > 5000L) {
            this.xo[var8] = null;
         } else {
            LivingEntity var14 = this.xo[var8];
            if (var14 == null || var14.getId() != var15[var8]) {
               Entity var4 = a.world.getEntityById(var15[var8]);
               var14 = var4 instanceof LivingEntity && var4 != a.player ? (LivingEntity)var4 : null;
               this.xo[var8] = var14;
               this.xp[var8] = -1.0F;
               this.xq[var8] = false;
               if (var14 == null) {
                  continue;
               }
            }

            if (!var14.isRemoved() && !var14.isSpectator()) {
               float var9 = var14.getMaxHealth();
               float var10 = var9 > 0.0F ? var14.getHealth() / var9 : 1.0F;
               if (this.xp[var8] >= 0.0F && var10 != this.xp[var8]) {
                  this.xq[var8] = true;
               }

               this.xp[var8] = var10;
            } else {
               this.xo[var8] = null;
               if (var14 instanceof PlayerEntity
                  && var1 - var7[var8] <= 1500L
                  && !(this.xp[var8] < 0.0F)
                  && (!this.xq[var8] || !(this.xp[var8] > 0.75F))
                  && !(var14.squaredDistanceTo(a.player) > 576.0)) {
                  this.xr = true;

                  try {
                     this.eb(var14, var1);
                  } finally {
                     this.xr = false;
                  }
               }
            }
         }
      }
   }

   private void eh() {

      for (int var1 = 0; var1 < xk; var1++) {
         xj[var1] = null;
      }

      xk = 0;
      Arrays.fill(this.xo, null);
   }

   static {
      for (int var0 = 0; var0 < 37; var0++) {
         double var1 = (Math.PI * 2) * (double)var0 / 36.0;
         pp[var0] = (float)Math.cos(var1);
         pq[var0] = (float)Math.sin(var1);
      }

      vo = new Identifier[6];

      for (int var3 = 0; var3 < 6; var3++) {
         vo[var3] = Identifier.of("lithium", "tgt_h" + "ead_" + var3);
      }

      wv = new byte[]{
         1,
         1,
         2,
         1,
         1,
         1,
         1,
         1,
         1,
         3,
         1,
         1,
         1,
         2,
         2,
         1,
         1,
         5,
         1,
         1,
         1,
         1,
         2,
         1,
         1,
         0,
         0,
         0,
         0,
         1,
         0,
         0,
         0,
         0,
         0,
         0,
         1,
         1,
         0,
         0,
         0,
         0,
         0,
         0,
         0,
         1,
         0,
         0,
         0,
         0,
         4,
         0,
         0,
         0,
         0,
         0,
         0,
         0,
         0,
         0,
         0,
         0,
         0,
         6,
         0,
         0,
         0,
         0,
         0,
         0,
         0,
         0,
         0,
         0,
         0,
         0,
         0,
         0,
         0,
         0,
         0,
         1,
         1,
         0,
         0,
         0,
         0,
         7,
         0,
         0,
         0,
         0,
         0,
         0,
         1,
         0,
         1,
         1,
         2,
         1,
         1,
         1,
         3,
         1,
         1,
         1,
         1,
         1,
         5,
         1,
         2,
         1,
         1,
         1,
         3,
         1,
         1,
         1,
         1,
         1
      };
      ww = new int[]{3882822, 8355711, 8806467, 8355711, 3882822, 8355711, 6143818, 5220413, 6155509, 1842206, 924172, 7031339};
      xe = new float[14];
      xf = new int[7];
      xg = new int[12];
      xh = new int[]{0, 1, 2, 3, 2, 1, 0};
      xi = new Style[36];

      for (int var4 = 0; var4 < 36; var4++) {
         xi[var4] = Style.EMPTY.withFont(new StyleSpriteSource.Font(Identifier.of("lithium", "gui_o" + (10 + var4))));
      }

      xj = new LivingEntity[32];
      xu = new int[8];
      xv = new int[8];
      xw = new int[8];
      xx = new long[8];
   }

   private static final class Trk {
      final double[] pts = new double[906];
      int n;
      boolean a;
      double lx;
      double ly;
      double lz;
      int b;
      int c;
      boolean d;
      Entity ent;
      private static int e = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();
   }

   public static final class Vis {
      public final String a;
      public final CheckerBridge b;
      public final InitAdapter[] c;
      private static int d = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

      Vis(CheckerBridge var1, InitAdapter[] var2) {
         this.a = null;
         this.b = var1;
         this.c = var2;
      }

      Vis(String var1, CheckerBridge var2, InitAdapter[] var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }
   }
}
