package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource;

import java.util.List;
import java.util.Random;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.UtilExtension;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.ParserEngine;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.BlockCalculator;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.CheckerBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.DialEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.ItemDescriptor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.SlotEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.EchoLoopCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.FieldVolumeCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.RibbonArrayCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.ShellArrayCache;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.world.MoonPhase;
import net.minecraft.world.attribute.EnvironmentAttribute;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.render.Camera;
import net.minecraft.block.enums.CameraSubmersionType;
import net.minecraft.entity.Entity;import net.minecraft.world.dimension.DimensionType;
public final class LerpZoneBuffer extends BuilderFactory implements UtilExtension {
   public static volatile LerpZoneBuffer I;
   public static volatile boolean ae = true;
   public static volatile boolean IDLE = false;
   public static volatile boolean LIC = false;
   private long af;
   private boolean ag;
   private boolean ah;
   private boolean ai;
   private boolean aj;
   private int ak;
   private double al;
   private double am;
   private double an;
   private double ao;
   private double ap;
   private static final long aq = 50000000L;
   public static final int BLIZ = 0;
   public static final int INF = 1;
   public static final int SAK = 2;
   public static final int GAL = 3;
   public static final int AUR = 4;
   public static final int AUT = 5;
   public static final int FIR = 6;
   public static final int SAND = 7;
   public static final int BLOOD = 8;
   public static final int SYN = 9;
   public static final int DUSK = 10;
   public static final int FROST = 11;
   public static final int NEON = 12;
   public static final int PN = 13;
   public static final int NONE = 13;
   private static final String[] ar = new String[]{
      "Ｂｌｉｚｚａｒｄ",
      "Ｉｎｆｅｒｎｏ",
      "Ｓａｋｕｒａ",
      "Ｇａｌａｘｙ",
      "Ａｕｒｏｒａ",
      "Ａｕｔｕｍｎ",
      "Ｆｉｒｅｆ" + "ｌ" + "ｉ" + "ｅｓ",
      "Ｓａ" + "ｎｄｓｔ" + "ｏｒｍ",
      "Ｂｌｏｏｄ Ｍ" + "ｏｏｎ",
      "Ｓｙｎｔｈｗ" + "ａ" + "ｖｅ",
      "Ｎｏｎｅ",
      "Ｄｕｓｋ",
      "Ｆｒｏｓｔ",
      "Ｎｅｏｎ"
   };
   private static final int[] as = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 13, 10, 11, 12};
   private static final String[] at = new String[]{"Ｓｅｒｖｅｒ", "Ｃｌｅａｒ", "Ｒａｉｎ", "Ｔｈｕｎｄｅｒ", "Ｓｎｏｗ"};
   private static final int au = 0;
   private static final int av = 1;
   private static final int aw = 2;
   private static final int ax = 3;
   private static final int ay = 4;
   public static volatile double TIME_DAY = -1.0;
   public static volatile long REAL_DAY = 6000L;
   public static volatile float RAIN_OVR = -1.0F;
   public static volatile float THUNDER_OVR = -1.0F;
   public static volatile float REAL_RAIN = 0.0F;
   public static volatile float REAL_THUNDER = 0.0F;
   public static volatile int PRECIP = 0;
   private static final Random az = new Random();
   private final SlotEntry ba;
   private final BlockCalculator bb;
   private final CheckerBridge bc;
   private final CheckerBridge bd;
   private final BlockCalculator be;
   private final CheckerBridge bf;
   private final CheckerBridge bg;
   private final BlockCalculator bh;
   private final BlockCalculator bi;
   private final BlockCalculator bj;
   private final CheckerBridge bk;
   private final DialEntry bl;
   private final SlotEntry bm;
   private final CheckerBridge bn;
   private final BlockCalculator bo;
   private final CheckerBridge bp;
   private final BlockCalculator bq;
   private static final int br = 0;
   private static final int bs = 3;
   private static final int bt = 6;
   private static final int bu = 10;
   private static final int bv = 13;
   private static final int bw = 16;
   private static final int bx = 17;
   private static final int by = 18;
   private static final int bz = 19;
   private static final int ca = 20;
   private static final int cb = 21;
   private static final int cc = 22;
   private static final int cd = 23;
   private static final int ce = 24;
   private static final int cf = 25;
   private static final int cg = 26;
   private static final int ch = 27;
   private static final int ci = 28;
   private static final int cj = 29;
   private static final int ck = 30;
   private static final int cl = 31;
   private static final float[][] cm = new float[][]{
      {
            204.0F,
            210.0F,
            218.0F,
            216.0F,
            222.0F,
            228.0F,
            255.0F,
            255.0F,
            255.0F,
            0.0F,
            216.0F,
            222.0F,
            228.0F,
            226.0F,
            232.0F,
            242.0F,
            0.0F,
            0.0F,
            0.0F,
            180.0F,
            180.0F,
            0.0F,
            0.0F,
            0.0F,
            0.8F,
            0.5F,
            0.0F,
            0.15F,
            0.04F,
            0.32F,
            1.0F
      },
      {
            58.0F,
            26.0F,
            18.0F,
            164.0F,
            80.0F,
            40.0F,
            230.0F,
            110.0F,
            40.0F,
            0.75F,
            64.0F,
            40.0F,
            34.0F,
            255.0F,
            176.0F,
            128.0F,
            6.0F,
            0.0F,
            0.0F,
            84.0F,
            264.0F,
            0.0F,
            0.35F,
            1.0F,
            0.62F,
            0.8F,
            0.08F,
            0.15F,
            0.0F,
            0.0F,
            1.0F
      },
      {
            60.0F,
            62.0F,
            126.0F,
            236.0F,
            150.0F,
            148.0F,
            255.0F,
            140.0F,
            138.0F,
            0.78F,
            244.0F,
            172.0F,
            184.0F,
            255.0F,
            212.0F,
            200.0F,
            0.0F,
            0.0F,
            0.0F,
            86.0F,
            266.0F,
            0.12F,
            0.3F,
            0.75F,
            1.0F,
            0.0F,
            0.0F,
            0.15F,
            0.0F,
            0.0F,
            1.0F
      },
      {
            6.0F,
            4.0F,
            16.0F,
            20.0F,
            19.0F,
            36.0F,
            20.0F,
            19.0F,
            36.0F,
            0.0F,
            20.0F,
            19.0F,
            36.0F,
            176.0F,
            184.0F,
            220.0F,
            12.0F,
            0.0F,
            0.0F,
            180.0F,
            180.0F,
            1.0F,
            1.0F,
            0.0F,
            0.5F,
            1.0F,
            0.0F,
            0.0F,
            0.0F,
            0.0F,
            1.0F
      },
      {
            5.0F,
            9.0F,
            22.0F,
            18.0F,
            34.0F,
            58.0F,
            18.0F,
            34.0F,
            58.0F,
            0.0F,
            18.0F,
            34.0F,
            58.0F,
            168.0F,
            205.0F,
            196.0F,
            0.0F,
            0.0F,
            0.0F,
            180.0F,
            300.0F,
            0.85F,
            1.0F,
            0.0F,
            0.42F,
            1.0F,
            0.0F,
            0.0F,
            0.0F,
            0.0F,
            1.0F
      },
      {
            82.0F,
            128.0F,
            196.0F,
            236.0F,
            200.0F,
            150.0F,
            255.0F,
            180.0F,
            90.0F,
            0.65F,
            240.0F,
            200.0F,
            170.0F,
            255.0F,
            220.0F,
            168.0F,
            0.0F,
            0.0F,
            0.0F,
            81.0F,
            261.0F,
            0.0F,
            0.3F,
            0.8F,
            1.0F,
            0.0F,
            0.0F,
            0.04F,
            0.0F,
            0.0F,
            1.0F
      },
      {
            22.0F,
            28.0F,
            66.0F,
            44.0F,
            46.0F,
            72.0F,
            240.0F,
            130.0F,
            80.0F,
            0.25F,
            52.0F,
            50.0F,
            80.0F,
            150.0F,
            160.0F,
            200.0F,
            0.0F,
            0.0F,
            0.0F,
            96.0F,
            276.0F,
            0.55F,
            1.0F,
            0.75F,
            0.4F,
            1.0F,
            0.05F,
            0.1F,
            0.0F,
            0.0F,
            1.0F
      },
      {
            196.0F,
            160.0F,
            114.0F,
            206.0F,
            166.0F,
            116.0F,
            255.0F,
            196.0F,
            130.0F,
            0.0F,
            206.0F,
            166.0F,
            116.0F,
            255.0F,
            214.0F,
            160.0F,
            -6.0F,
            0.0F,
            0.0F,
            180.0F,
            180.0F,
            0.0F,
            0.28F,
            0.0F,
            0.7F,
            0.6F,
            0.1F,
            0.0F,
            0.14F,
            0.5F,
            0.0F
      },
      {
            12.0F,
            5.0F,
            9.0F,
            42.0F,
            13.0F,
            18.0F,
            42.0F,
            13.0F,
            18.0F,
            0.0F,
            46.0F,
            16.0F,
            20.0F,
            228.0F,
            128.0F,
            112.0F,
            0.0F,
            0.0F,
            0.0F,
            180.0F,
            320.0F,
            0.75F,
            1.0F,
            0.25F,
            0.36F,
            1.0F,
            0.12F,
            0.0F,
            0.0F,
            0.0F,
            1.0F
      },
      {
            34.0F,
            10.0F,
            78.0F,
            70.0F,
            24.0F,
            96.0F,
            255.0F,
            90.0F,
            200.0F,
            0.45F,
            120.0F,
            50.0F,
            150.0F,
            220.0F,
            150.0F,
            255.0F,
            0.0F,
            0.0F,
            0.0F,
            86.0F,
            266.0F,
            0.7F,
            1.0F,
            0.25F,
            0.62F,
            1.0F,
            0.05F,
            0.12F,
            0.0F,
            0.0F,
            1.0F
      },
      {
            40.0F,
            46.0F,
            66.0F,
            88.0F,
            86.0F,
            92.0F,
            240.0F,
            170.0F,
            95.0F,
            0.3F,
            88.0F,
            86.0F,
            92.0F,
            205.0F,
            200.0F,
            215.0F,
            0.0F,
            0.0F,
            0.0F,
            96.0F,
            276.0F,
            0.0F,
            1.0F,
            0.0F,
            0.22F,
            1.0F,
            0.03F,
            0.0F,
            0.0F,
            0.0F,
            1.0F
      },
      {
            112.0F,
            138.0F,
            184.0F,
            222.0F,
            220.0F,
            212.0F,
            255.0F,
            250.0F,
            235.0F,
            0.0F,
            222.0F,
            220.0F,
            212.0F,
            246.0F,
            244.0F,
            240.0F,
            0.0F,
            0.0F,
            0.0F,
            60.0F,
            240.0F,
            0.0F,
            1.0F,
            0.0F,
            1.0F,
            1.0F,
            0.0F,
            0.0F,
            0.05F,
            0.12F,
            1.0F
      },
      {
            0.0F,
            3.0F,
            8.0F,
            2.0F,
            9.0F,
            20.0F,
            2.0F,
            9.0F,
            20.0F,
            0.0F,
            2.0F,
            9.0F,
            20.0F,
            246.0F,
            250.0F,
            255.0F,
            18.0F,
            0.0F,
            0.0F,
            180.0F,
            180.0F,
            0.0F,
            1.0F,
            0.0F,
            1.0F,
            1.0F,
            0.0F,
            0.0F,
            0.0F,
            0.0F,
            1.0F
      }
   };
   private static final float[] cn = new float[]{170.0F, 260.0F, 360.0F, 420.0F, 380.0F, 340.0F, 380.0F, 120.0F, 260.0F, 330.0F, 320.0F, 380.0F, 520.0F};
   private static final float[] co = new float[]{26.0F, 55.0F, 140.0F, 70.0F, 60.0F, 110.0F, 140.0F, 16.0F, 45.0F, 90.0F, 120.0F, 180.0F, 140.0F};
   private static final float[] cp = new float[]{150.0F, 300.0F, 340.0F, 400.0F, 320.0F, 330.0F, 330.0F, 160.0F, 300.0F, 320.0F, 300.0F, 320.0F, 360.0F};
   private static final float[] cq = new float[]{40.0F, 300.0F, 340.0F, 120.0F, 140.0F, 330.0F, 150.0F, 40.0F, 110.0F, 200.0F, 160.0F, 160.0F, 150.0F};
   private static final int[] cr = new int[]{6, 8, 9};
   private final float[] cs;
   private final float[] ct;
   private boolean cu;
   public float cv;
   public float cw;
   private float cx;
   private float cy;
   private boolean cz;
   public final float[] pw;
   public float da;
   public float db;
   public float dc;
   public double dd;
   private long de;
   private long df;
   private long dg;
   public float dh;
   public float di;
   public float dj;
   private float dk;
   private String dl;
   private int dm;
   private int dn;
   private double _kwren_do;
   private float dp;
   private float dq;
   private float dr;
   private boolean ds;
   private int dt;
   private String du;
   private int dv;
   private long dw;
   private long dx;
   private float dy;
   private float dz;
   private static final int ea = 0;
   private static final int eb = 1;
   private static final int ec = 2;
   private static final int ed = 3;
   private final EchoLoopCache[] ee;
   private final long[] ef;
   private final double[] eg;
   private int eh;
   private float ei;
   private long ej;
   private int ek;
   private double el;
   private static final float[] em;
   private static final int[] en;
   private static final int[] eo;
   private float ep;
   private float eq;
   public float er;
   private float es;
   public long et;
   public float eu;
   public float ev;
   public float ew;

   public LerpZoneBuffer() {
      super("", "", ParserEngine.Z3);
      this.setName(
         new char[]{'過', '邀', '郹', '邁', '邤', '轙', '轹', '輀', '輢', '返', '迠'},
         -437620881,
         new char[]{
            'ᚔ',
            'ᚚ',
            'ᚺ',
            'ᕟ',
            'ᕰ',
            'ᔄ',
            'ᔪ',
            'ᗊ',
            '\uea8d',
            'ᖍ',
            'ᖦ',
            'ᑈ',
            'ᑠ',
            'ᐍ',
            'ᐩ',
            'ᓒ',
            '\ueb85',
            'ᒗ',
            'ᒨ',
            '\u135b',
            'ጭ',
            '\uec60',
            'ጙ',
            'ጱ',
            'Ꮪ',
            '\uec9c',
            '\u139a',
            'Ꮄ',
            'ቝ',
            '\ued18',
            'ሇ',
            'ሷ',
            '\u12c7',
            'ዠ',
            'ኚ',
            '\u12b1',
            'ᅝ',
            'ᅵ',
            'ᄜ'
         },
         -1464997451
      );
      this.ag = true;
      this.ba = new SlotEntry("Ｐ．ｒｅｓｅｔ", ar[0], ar);
      BlockCalculator var10001 = new BlockCalculator("", 0.0, 100.0, 90.0, 1.0);
      var10001.n(new char[]{'砱', '砹', '砘', '砡', '磑', '磽', '碁', '碸', '睄', '睶'}, -881031400);
      this.bb = var10001;
      CheckerBridge var1 = new CheckerBridge("", true);
      var1.n(new char[]{'Ⳗ', '⬊', '⭨', '⬛', '푁', '⯁', '⯑', '⯺', '퓽', '⯚', '⩔', '⩽'}, -757738523);
      this.bc = var1;
      CheckerBridge var2 = new CheckerBridge("", true);
      var2.n(new char[]{'깱', '깮', '긾', '껌', '껩', '꺕', '꺸', '굖', '굼', '괋'}, 71389505);
      this.bd = var2;
      var10001 = new BlockCalculator("", 5.0, 100.0, 45.0, 1.0);
      var10001.n(new char[]{'嚕', '回', '嚪', '啀', '啾', '唅', '唿', '嗓'}, 584296881);
      this.be = var10001;
      CheckerBridge var4 = new CheckerBridge("", true);
      var4.n(new char[]{'䘤', '䘬', '䘓', '䘯', '䘪', '䛐', '䛹', '맼', '䛗', '䕛', '䕠', '䔝', '䔥'}, 1826339075);
      this.bf = var4;
      CheckerBridge var5 = new CheckerBridge("", true);
      var5.n(new char[]{'塀', '墆', '壪', '墋', '墠', '坖', '坰', '國', '圮', '城'}, -187717783);
      this.bg = var5;
      var10001 = new BlockCalculator("", 0.0, 100.0, 55.0, 1.0);
      var10001.n(new char[]{'挴', '挿', '挟', '挨', '鲮', '掙', '掄', '探', '扉', '扢', '戆', '戢', '拕', '拶'}, 1582996498);
      this.bh = var10001;
      var10001 = new BlockCalculator("", 0.0, 100.0, 50.0, 1.0);
      var10001.n(new char[]{'ꮴ', 'ꮬ', 'ꮈ', 'ꮮ', 'ꮻ'}, 956191875);
      this.bi = var10001;
      var10001 = new BlockCalculator("", 0.0, 100.0, 70.0, 1.0);
      var10001.n(new char[]{'⧔', '⠜', '⡽', '⠟', '⠸'}, -983378189);
      this.bj = var10001;
      CheckerBridge var9 = new CheckerBridge("", false);
      var9.n(
         new char[]{'\ue84e', '\ue897', '\ue8f1', '\ue89a', '\ue8b3', 'ᠵ', '\ue717', '\ue71b', '\ue733', '\ue7df', '\ue7f7', '\ue78a', '\ue7bc'}, -1770645638
      );
      this.bk = var9;
      DialEntry var10 = new DialEntry("", 6000.0);
      var10.n(new char[]{'腃', '膘', '臼', '膙', '膶'}, -1398505865);
      this.bl = var10;
      this.bm = new SlotEntry("Ｗ．ｅａｔｈｅｒ", at[0], at);
      CheckerBridge var11 = new CheckerBridge("", true);
      var11.n(new char[]{'護', '譻', '诙', '诱', '讛', '讴', '詞', '詻', '畮', '詞', '諃', '諾', '誄', '読'}, 1167815766);
      this.bn = var11;
      var10001 = new BlockCalculator("", 0.0, 100.0, 50.0, 1.0);
      var10001.n(new char[]{'취', '췴', '챖', '챭', '찙', '찲', '㎵', '첂', '천', '첾', '쭄', '쭽', '쬊'}, -1387646245);
      this.bo = var10001;
      CheckerBridge var13 = new CheckerBridge("", true);
      var13.n(
         new char[]{
            '\uf119', '\uf147', '\uf120', '\uf1c8', '\uf1e9', '\uf191', '\uf1ad', '\uf04d', '\uf065', 'ཡ', '\uf053', '\uf02b', '\uf0df', '\uf0ef', '\uf08f'
         },
         -1092350422
      );
      this.bp = var13;
      var10001 = new BlockCalculator("", 0.0, 100.0, 50.0, 1.0);
      var10001.n(new char[]{'汮', '汯', '泉', '泘', '泶', '沉', '沲', '歒', '歴', '欞'}, -346188990);
      this.bq = var10001;
      this.cs = new float[31];
      this.ct = new float[31];
      this.cu = false;
      this.cv = 0.0F;
      this.cw = 0.0F;
      this.cx = 0.0F;
      this.cy = 1.0F;
      this.cz = false;
      this.pw = new float[13];
      this.da = 0.0F;
      this.db = 0.0F;
      this.dc = 0.0F;
      this.dd = 0.0;
      this.de = 0L;
      this.df = 0L;
      this.dg = 0L;
      this.dh = 0.5F;
      this.di = 0.0F;
      this.dj = 0.0F;
      this.dk = 1.0F;
      this.dm = 0;
      this.dn = 0;
      this._kwren_do = -1.0;
      this.dp = 0.0F;
      this.dq = 0.0F;
      this.dr = 0.0F;
      this.ds = false;
      this.dt = 0;
      this.dv = 0;
      this.dw = 0L;
      this.dx = 0L;
      this.dy = 1.0F;
      this.dz = 1.0F;
      this.ee = new EchoLoopCache[4];
      this.ef = new long[4];
      this.eg = new double[20];
      this.eh = 0;
      this.ei = 0.0F;
      this.ej = 0L;
      this.ek = 0;
      this.el = 0.0;
      this.ep = 0.0F;
      this.eq = 0.0F;
      this.er = 180.0F;
      this.es = 0.0F;
      this.et = 0L;
      this.eu = 1.0F;
      this.ev = 1.0F;
      this.ew = 1.0F;
      this.a(
         this.ba,
         this.bb,
         this.bc,
         this.bd,
         this.be,
         this.bf,
         this.bg,
         this.bh,
         this.bi,
         this.bj,
         this.bk,
         this.bl,
         this.bm,
         this.bn,
         this.bo,
         this.bp,
         this.bq
      );
      I = this;
      FieldVolumeCache.a();
   }

   @Override
   public void c() {

      if (IDLE) {
         IDLE = false;
         this.cu = false;
         this.de = 0L;
         this._kwren_do = -1.0;
         this.ej = 0L;
         this.cy = this.y() ? 1.0F : 0.0F;
      }

      ae = true;
      this.ag = true;
      if (!this.cz) {
         try {
            this.b.a(UtilExtension.class, this);
            this.cz = true;
         } catch (Throwable var2) {
         }
      }

      super.c();
   }

   public void a() {

      long var1 = System.nanoTime() - this.de;
      long var3 = a.getRenderTime();
      if (!this.cu || var1 >= 100000000L || var1 >= 1000000L && (this.de <= this.df || var3 != this.dg)) {
         this.dg = var3;
         if (ConfigBridge.c != null && ConfigBridge.c.a()) {
            LIC = true;
            boolean var5 = super.f;
            long var6 = System.nanoTime();
            if (this.ag || !this.cu || a.currentScreen != null || var6 - this.af >= 50000000L || var6 - this.af < 0L) {
               this.ag = false;
               this.af = var6;
               this.ak = this.b(this.ba);
               this.al = this.bh.p();
               this.am = this.be.p();
               this.ah = this.bc.f();
               this.ai = this.bd.f();
               this.aj = this.bg.f();
               this.an = this.bb.p();
               this.ao = this.bi.p();
               this.ap = this.bj.p();
            }

            int var8 = this.ak;
            if (var8 != 13) {
               this.dn = var8;
            }

            int var9 = this.dn;
            boolean var10 = var5 && var8 != 13;
            boolean var11 = p();
            q(this.ct, var9, this.al);
            this.di = (float)(this.am / 100.0);
            float[] var12 = this.pw;
            if (!this.cu) {
               System.arraycopy(this.ct, 0, this.cs, 0, 31);

               for (int var13 = 0; var13 < 13; var13++) {
                  var12[var13] = var13 == var9 ? 1.0F : 0.0F;
               }

               this.da = (float)(this.an / 100.0);
               this.db = (float)(this.ao / 100.0);
               this.dc = (float)(this.ap / 100.0);
               this.cu = true;
            }

            long var31 = System.nanoTime();
            if (this.de == 0L) {
               this.de = var31;
            }

            float var15 = (float)(var31 - this.de) / 1.0E9F;
            this.de = var31;
            if (!(var15 <= 0.0F)) {
               if (var15 > 0.1F) {
                  var15 = 0.1F;
               }

               this.dd += (double)var15;
               float var16 = 1.0F - (float)Math.exp((double)(-var15 * 1.7F));
               float var17 = 1.0F - (float)Math.exp((double)(-var15 * 1.9F));
               float var18 = 1.0F - (float)Math.exp((double)(-var15 * 6.0F));
               float var19 = 1.0F - (float)Math.exp((double)(-var15 * 3.0F));
               float var20 = 1.0F - (float)Math.exp((double)(-var15 * 1.3F));
               float var21 = 1.0F - (float)Math.exp((double)(-var15 * 1.4F));
               this.cv = this.cv + ((var10 && var11 && this.ah ? 1.0F : 0.0F) - this.cv) * var16;
               this.cw = this.cw + ((var10 && var11 && this.ai ? 1.0F : 0.0F) - this.cw) * var16;
               this.cx = this.cx + ((var10 && var11 && this.aj ? 1.0F : 0.0F) - this.cx) * var17;
               this.cy = this.cy + ((this.y() ? 1.0F : 0.0F) - this.cy) * var18;
               ae = var5 && var11 || this.cv > 0.002F || this.cw > 0.002F;

               for (int var22 = 0; var22 < 13; var22++) {
                  var12[var22] += ((var22 == var9 ? 1.0F : 0.0F) - var12[var22]) * var20;
               }

               float var32 = 0.0F;

               for (int var23 = 0; var23 < cr.length; var23++) {
                  var32 += cm[cr[var23]][21] * var12[cr[var23]];
               }

               this.dj = var32;
               this.d(var15, var5 && var11);
               this.ep = this.ep + ((var5 && var11 ? 1.0F : 0.0F) - this.ep) * var16;
               this.g(var10 && var11);
               this.da = this.da + ((float)(this.an / 100.0) - this.da) * var19;
               this.db = this.db + ((float)(this.ao / 100.0) - this.db) * var19;
               this.dc = this.dc + ((float)(this.ap / 100.0) - this.dc) * var19;
               float[] var33 = this.cs;
               float[] var24 = this.ct;

               for (int var25 = 0; var25 < 31; var25++) {
                  float var26 = var24[var25] - var33[var25];
                  if (var25 == 19 || var25 == 20) {
                     var26 = MathHelper.wrapDegrees(var26);
                  }

                  var33[var25] += var26 * var21;
               }

               double var34 = this.dd;
               double var27 = 0.5 + 0.5 * (0.6 * Math.sin(var34 * 0.37) + 0.3 * Math.sin(var34 * 1.13 + 1.7) + 0.1 * Math.sin(var34 * 2.9 + 0.4));
               this.dh = (float)(var27 < 0.0 ? 0.0 : (var27 > 1.0 ? 1.0 : var27));

               try {
                  this.dk = a.world == null ? 1.0F : 1.0F - a.world.getRainGradient(1.0F);
               } catch (Throwable var30) {
                  this.dk = 1.0F;
               }

               IDLE = !var5
                  && this.cv < 1.0E-4F
                  && this.cw < 1.0E-4F
                  && this.cx < 1.0E-4F
                  && this.ep < 1.0E-4F
                  && this.dp < 1.0E-4F
                  && this.ei == 0.0F
                  && !this.ds
                  && TIME_DAY < 0.0;
            }
         } else {
            LIC = false;
         }
      }
   }

   private int b(SlotEntry var1) {

      String var2 = var1.f();
      if (var2 != this.dl) {
         this.dl = var2;
         int var3 = 0;

         for (int var4 = 0; var4 < ar.length; var4++) {
            if (ar[var4].equals(var2)) {
               var3 = as[var4];
               break;
            }
         }

         this.dm = var3;
      }

      return this.dm;
   }

   private int c(SlotEntry var1) {

      String var2 = var1.f();
      if (var2 != this.du) {
         this.du = var2;
         int var3 = 0;

         for (int var4 = 0; var4 < at.length; var4++) {
            if (at[var4].equals(var2)) {
               var3 = var4;
               break;
            }
         }

         this.dv = var3;
      }

      return this.dv;
   }

   private void d(float var1, boolean var2) {

      double var3 = (double)Math.floorMod(REAL_DAY, 24000L);
      boolean var5 = var2 && this.bk.f();
      if (this._kwren_do < 0.0 || !var5 && TIME_DAY < 0.0) {
         this._kwren_do = var3;
      }

      double var6 = var5 ? (double)this.bl.a_r91() : var3;
      double var8 = var6 - this._kwren_do;
      var8 -= Math.floor((var8 + 12000.0) / 24000.0) * 24000.0;
      this._kwren_do = this._kwren_do + var8 * (1.0 - Math.exp((double)(-var1) * 3.5));
      this._kwren_do = (this._kwren_do % 24000.0 + 24000.0) % 24000.0;
      TIME_DAY = !var5 && Math.abs(var8) < 4.0 ? -1.0 : this._kwren_do;
      this.dp = this.dp + ((var5 ? 1.0F : 0.0F) - this.dp) * (1.0F - (float)Math.exp((double)(-var1 * 3.0F)));
      int var10 = this.c(this.bm);
      boolean var11 = var2 && var10 != 0;
      float var12 = REAL_RAIN;
      float var13 = REAL_THUNDER;
      if (!this.ds) {
         this.dq = var12;
         this.dr = var13;
      }

      float var14 = var11 ? (var10 == 1 ? 0.0F : 1.0F) : var12;
      float var15 = var11 ? (var10 == 3 ? 1.0F : 0.0F) : var13;
      float var16 = 1.0F - (float)Math.exp((double)(-var1 * 0.9F));
      this.dq = this.dq + (var14 - this.dq) * var16;
      this.dr = this.dr + (var15 - this.dr) * var16;
      if (var11) {
         this.ds = true;
         if (var10 != 1) {
            this.dt = var10 == 4 ? 2 : 1;
         }
      } else if (this.ds && Math.abs(this.dq - var12) < 0.01F && Math.abs(this.dr - var13) < 0.01F) {
         this.ds = false;
         this.dt = 0;
      }

      RAIN_OVR = this.ds ? this.dq : -1.0F;
      THUNDER_OVR = this.ds ? this.dr : -1.0F;
      PRECIP = this.ds ? this.dt : 0;
      if (var11 && var10 == 3 && this.dr > 0.6F) {
         this.f_r24();
      } else {
         this.dw = 0L;
         this.dx = 0L;
      }
   }

   private void f_r24() {

      long var1 = System.nanoTime();
      double var3 = this.bq.p() / 100.0;
      if (var3 <= 0.005) {
         this.dw = 0L;
         this.dx = 0L;
      } else {
         double var5 = Math.pow(2.0, (0.5 - var3) * 4.0);
         if (this.dw == 0L) {
            this.dw = var1 + (long)((3.0 + az.nextDouble() * 6.0) * var5 * 1.0E9);
         } else {
            if (this.dx != 0L && var1 >= this.dx) {
               this.dx = 0L;
               if (a.player != null && a.world != null) {
                  try {
                     a.world
                        .playSoundClient(
                           a.player.getX(),
                           a.player.getY(),
                           a.player.getZ(),
                           SoundEvents.ENTITY_LIGHTNING_BOLT_THUNDER,
                           SoundCategory.WEATHER,
                           this.dy,
                           this.dz,
                           false
                        );
                  } catch (Throwable var10) {
                  }
               }
            }

            if (var1 >= this.dw && a.world != null) {
               this.dw = var1 + (long)((7.0 + az.nextDouble() * 16.0) * var5 * 1.0E9);

               try {
                  a.world.setLightningTicksLeft(2);
               } catch (Throwable var9) {
               }

               double var7 = az.nextDouble();
               this.dx = var1 + (long)((0.3 + var7 * 2.2) * 1.0E9);
               this.dy = (float)(1.0 - var7 * 0.55);
               this.dz = 0.8F + az.nextFloat() * 0.2F;
            }
         }
      }
   }

   private void g(boolean var1) {

      try {
         if (a.isPaused()) {
            return;
         }

         long var2 = System.nanoTime();
         boolean var4 = var1 && this.bn.f() && a.player != null && a.world != null && a.getSoundManager() != null;
         float var5 = (float)(this.bo.p() / 100.0);
         if (var2 - this.ej >= 50000000L) {
            float var6 = this.ej == 0L ? 0.05F : Math.min(0.25F, (float)(var2 - this.ej) / 1.0E9F);
            this.ej = var2;
            this.ei = this.ei + ((var4 ? 1.0F : 0.0F) - this.ei) * (1.0F - (float)Math.exp((double)(-var6 * 1.6F)));
            if (!var4 && this.ei < 0.002F) {
               this.ei = 0.0F;
            }

            if (a.getSoundManager() != null) {
               this.h(this.ei * var5, var2);
            }

            if (var4) {
               this.j(this.ei * var5);
            } else if (this.pw[12] > 0.0F) {
               this.eh = RibbonArrayCache.bd;
            }
         }

         if (var4) {
            this.m(this.ei * var5 * this.pw[9]);
         } else {
            this.el = 0.0;
         }
      } catch (Throwable var7) {
      }
   }

   private void h(float var1, long var2) {

      float[] var4 = this.pw;
      float var5 = 0.55F + 0.45F * this.dh * Math.max(0.35F, this.db);
      float var6 = var4[0] * 0.7F * var5;
      float var7 = var4[4] * 0.26F;
      float var8 = var4[7] * 0.8F * var5;
      float var9 = var4[5] * 0.2F;
      float var10 = var4[2] * 0.12F;
      float var11 = var4[10] * 0.18F * var5;
      float var12 = var4[11] * 0.3F * var5;
      float var13 = var6 + var7 + var8 + var9 + var10 + var11 + var12;
      float var14 = var13 > 1.0E-4F ? (var6 * 0.55F + var7 * 0.45F + var8 * 0.42F + var9 * 0.72F + var10 * 0.85F + var11 * 0.4F + var12 * 0.62F) / var13 : 0.6F;
      this.i(0, SoundEvents.ITEM_ELYTRA_FLYING, var1 * var13, var14, var2);
      float var15 = var4[3] * 0.15F;
      float var16 = var4[12] * 0.3F;
      float var17 = var15 + var16;
      this.i(1, SoundEvents.BLOCK_BEACON_AMBIENT, var1 * var17, var17 > 1.0E-4F ? (var15 * 0.5F + var16 * 0.74F) / var17 : 0.5F, var2);
      this.i(2, (SoundEvent)SoundEvents.AMBIENT_CRIMSON_FOREST_LOOP.value(), var1 * var4[8] * 0.35F, 0.8F, var2);
      this.i(3, (SoundEvent)SoundEvents.AMBIENT_BASALT_DELTAS_LOOP.value(), var1 * var4[1] * 0.4F, 0.85F, var2);
   }

   private void i(int var1, SoundEvent var2, float var3, float var4, long var5) {

      EchoLoopCache var7 = this.ee[var1];
      if (var7 != null && (var7.isDone() || var5 - this.ef[var1] > 1000000000L && !a.getSoundManager().isPlaying(var7))) {
         var7.end();
         var7 = null;
         this.ee[var1] = null;
      }

      if (var7 == null) {
         if (!(var3 < 0.01F) && var5 - this.ef[var1] >= 2000000000L) {
            this.ef[var1] = var5;
            var7 = new EchoLoopCache(var2, var4);
            var7.want = var3;
            if (var1 == 0) {
               var7.orbit = 4.0F;
            }

            this.ee[var1] = var7;
            a.getSoundManager().play(var7);
         }
      } else {
         var7.want = var3;
         var7.pitchWant = var4;
      }
   }

   private void j(float var1) {

      float[] var2 = this.pw;
      double var3 = this.dd;
      if (this.k(0, var3, var1 * var2[1], 0.35, 0.8)) {
         this.l(SoundEvents.BLOCK_FIRE_AMBIENT, var1 * var2[1] * 0.9F, 0.7F + az.nextFloat() * 0.6F, 2.0, 6.0);
      }

      if (this.k(1, var3, var1 * var2[1], 3.0, 5.0)) {
         this.l(SoundEvents.BLOCK_LAVA_POP, var1 * var2[1] * 0.5F, 0.8F + az.nextFloat() * 0.4F, 3.0, 8.0);
      }

      if (this.k(2, var3, var1 * var2[2], 6.0, 8.0)) {
         this.l(SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, var1 * var2[2] * 0.5F, em[az.nextInt(em.length)], 3.0, 7.0);
      }

      if (this.k(16, var3, var1 * var2[2], 1.5, 2.5)) {
         this.l(SoundEvents.BLOCK_CHERRY_LEAVES_STEP, var1 * var2[2] * 0.25F, 0.9F + az.nextFloat() * 0.3F, 2.0, 7.0);
      }

      if (this.k(3, var3, var1 * var2[3], 12.0, 14.0)) {
         this.l(SoundEvents.BLOCK_AMETHYST_BLOCK_RESONATE, var1 * var2[3] * 0.15F, 1.3F + az.nextFloat() * 0.5F, 4.0, 9.0);
      }

      if (this.k(4, var3, var1 * var2[4], 6.0, 6.0)) {
         this.l(SoundEvents.BLOCK_POWDER_SNOW_STEP, var1 * var2[4] * 0.25F, 0.6F + az.nextFloat() * 0.2F, 4.0, 12.0);
      }

      if (this.k(17, var3, var1 * var2[4], 45.0, 45.0)) {
         this.l(SoundEvents.ENTITY_FOX_SCREECH, var1 * var2[4] * 0.35F, 0.9F + az.nextFloat() * 0.2F, 10.0, 14.0);
      }

      if (this.k(5, var3, var1 * var2[5], 0.7, 1.6)) {
         this.l(SoundEvents.BLOCK_LEAF_LITTER_STEP, var1 * var2[5] * 0.45F, 0.8F + az.nextFloat() * 0.4F, 1.5, 5.0);
      }

      if (this.k(6, var3, var1 * var2[6], 1.0, 2.5)) {
         this.l(SoundEvents.BLOCK_FIREFLY_BUSH_IDLE, var1 * var2[6], 0.9F + az.nextFloat() * 0.2F, 3.0, 9.0);
      }

      if (this.k(18, var3, var1 * var2[6], 8.0, 14.0)) {
         this.l(SoundEvents.ENTITY_FROG_AMBIENT, var1 * var2[6] * 0.3F, 0.85F + az.nextFloat() * 0.2F, 6.0, 13.0);
      }

      if (this.k(7, var3, var1 * var2[7], 2.0, 3.0)) {
         this.l(SoundEvents.BLOCK_SAND_IDLE, var1 * var2[7] * 0.9F, 0.9F + az.nextFloat() * 0.2F, 2.0, 7.0);
      }

      if (this.k(8, var3, var1 * var2[7], 4.0, 5.0)) {
         this.l(SoundEvents.BLOCK_DRY_GRASS_AMBIENT, var1 * var2[7] * 0.8F, 0.9F + az.nextFloat() * 0.2F, 3.0, 8.0);
      }

      if (this.k(9, var3, var1 * var2[8], 6.0, 8.0)) {
         this.l(SoundEvents.BLOCK_EYEBLOSSOM_IDLE, var1 * var2[8] * 0.9F, 0.65F + az.nextFloat() * 0.2F, 3.0, 8.0);
      }

      if (this.k(10, var3, var1 * var2[8], 18.0, 22.0)) {
         this.l(SoundEvents.ENTITY_CREAKING_AMBIENT, var1 * var2[8] * 0.45F, 0.6F + az.nextFloat() * 0.2F, 8.0, 14.0);
      }

      if (this.k(11, var3, var1 * var2[8], 40.0, 50.0)) {
         this.l((SoundEvent)SoundEvents.AMBIENT_CAVE.value(), var1 * var2[8] * 0.35F, 0.8F + az.nextFloat() * 0.2F, 6.0, 12.0);
      }

      if (this.k(19, var3, var1 * var2[8], 35.0, 45.0)) {
         this.l(SoundEvents.ENTITY_FOX_SCREECH, var1 * var2[8] * 0.4F, 0.8F + az.nextFloat() * 0.2F, 10.0, 14.0);
      }

      if (this.k(12, var3, var1 * var2[10], 9.0, 10.0)) {
         this.l(SoundEvents.BLOCK_POWDER_SNOW_STEP, var1 * var2[10] * 0.3F, 0.7F + az.nextFloat() * 0.2F, 3.0, 9.0);
      }

      if (this.k(13, var3, var1 * var2[11], 4.0, 6.0)) {
         this.l(SoundEvents.BLOCK_POWDER_SNOW_STEP, var1 * var2[11] * 0.4F, 0.9F + az.nextFloat() * 0.3F, 3.0, 10.0);
      }

      if (this.k(14, var3, var1 * var2[11], 2.0, 5.0)) {
         this.l(SoundEvents.BLOCK_POINTED_DRIPSTONE_DRIP_WATER, var1 * var2[11] * 0.35F, 1.1F + az.nextFloat() * 0.4F, 2.0, 7.0);
      }

      if (this.k(15, var3, var1 * var2[12], 8.0, 12.0)) {
         this.l(SoundEvents.BLOCK_FIRE_AMBIENT, var1 * var2[12] * 0.22F, 1.6F + az.nextFloat() * 0.35F, 6.0, 14.0);
      }

      if (var2[12] > 0.0F) {
         int var5 = RibbonArrayCache.bd;
         if (var5 != this.eh) {
            this.eh = var5;
            if (var1 * var2[12] > 0.02F) {
               this.l(SoundEvents.BLOCK_FIRE_AMBIENT, var1 * var2[12] * 0.36F, 1.85F + az.nextFloat() * 0.15F, 8.0, 16.0);
            }
         }
      }
   }

   private boolean k(int var1, double var2, float var4, double var5, double var7) {

      if (var4 < 0.02F) {
         this.eg[var1] = 0.0;
         return false;
      } else if (this.eg[var1] == 0.0) {
         this.eg[var1] = var2 + 0.3 + az.nextDouble() * var5;
         return false;
      } else if (var2 < this.eg[var1]) {
         return false;
      } else {
         this.eg[var1] = var2 + var5 + az.nextDouble() * var7;
         return true;
      }
   }

   private void l(SoundEvent var1, float var2, float var3, double var4, double var6) {

      if (!(var2 < 0.02F) && a.player != null && a.world != null) {
         double var8 = az.nextDouble() * Math.PI * 2.0;
         double var10 = var4 + az.nextDouble() * (var6 - var4);
         a.world
            .playSoundClient(
               a.player.getX() + Math.cos(var8) * var10,
               a.player.getEyeY() - 0.8 + az.nextDouble() * 2.4,
               a.player.getZ() + Math.sin(var8) * var10,
               var1,
               SoundCategory.AMBIENT,
               Math.min(1.0F, var2),
               var3,
               false
            );
      }
   }

   private void m(float var1) {

      if (!(var1 < 0.02F) && a.player != null && a.world != null) {
         double var2 = this.dd;
         if (this.el == 0.0 || this.el < var2 - 1.0) {
            this.el = var2 + 0.25;
            this.ek = 0;
         } else if (!(var2 < this.el)) {
            this.el += 0.28;
            int var4 = this.ek;
            this.ek = var4 + 1 & 31;
            int var5 = var4 >> 3;
            int var6 = var4 & 7;
            int var7 = en[var5 * 4];
            int var8 = en[var5 * 4 + eo[var6]];
            double var9 = a.player.getX();
            double var11 = a.player.getEyeY();
            double var13 = a.player.getZ();
            a.world.playSoundClient(var9, var11, var13, (SoundEvent)SoundEvents.BLOCK_NOTE_BLOCK_PLING.value(), SoundCategory.AMBIENT, 0.28F * var1, n(var8), false);
            if (var6 == 0 || var6 == 4) {
               a.world.playSoundClient(var9, var11, var13, (SoundEvent)SoundEvents.BLOCK_NOTE_BLOCK_BASS.value(), SoundCategory.AMBIENT, 0.5F * var1, n(var7), false);
            }

            if (var6 == 7 && (var5 & 1) == 1) {
               a.world
                  .playSoundClient(
                     var9, var11, var13, (SoundEvent)SoundEvents.BLOCK_NOTE_BLOCK_CHIME.value(), SoundCategory.AMBIENT, 0.2F * var1, n(Math.min(24, var7 + 12)), false
                  );
            }
         }
      } else {
         this.el = 0.0;
      }
   }

   private static float n(int var0) {

      return (float)Math.pow(2.0, (double)(var0 - 12) / 12.0);
   }

   public boolean o() {

      return this.bp.f();
   }

   private static boolean p() {

      return a.world != null && a.world.getDimension().skybox() == DimensionType.Skybox.OVERWORLD;
   }

   private static void q(float[] var0, int var1, double var2) {

      float var4 = (float)Math.pow((double)((float)(var2 / 100.0)), 0.85);
      System.arraycopy(cm[var1], 0, var0, 0, 31);
      var0[17] = cn[var1] + (co[var1] - cn[var1]) * var4;
      var0[18] = cp[var1] + (cq[var1] - cp[var1]) * var4;
   }

   public static Object r(EnvironmentAttribute<?> var0, Object var1) {

      LerpZoneBuffer var2 = I;
      if (var2 != null && var1 != null && ConfigBridge.c != null) {
         MinecraftClient var3 = MinecraftClient.getInstance();
         if (!var3.isOnThread()) {
            return null;
         } else {
            long var4 = System.nanoTime() - var2.de;
            if (!var2.cu || var4 >= 100000000L || var4 >= 1000000L && (var2.de <= var2.df || var3.getRenderTime() != var2.dg)) {
               var2.a();
            }

            if (!LIC) {
               return null;
            } else if (var0 == EnvironmentAttributes.SKY_LIGHT_FACTOR_VISUAL && var1 instanceof Float) {
               float var22 = (Float)var1;
               var2.ev = var22;
               float[] var23 = var2.cs;
               float var24 = var2.cv * var2.da * var23[25];
               if (var24 <= 0.002F) {
                  var2.ew = var22;
                  return null;
               } else {
                  float var25 = var23[24] * (var22 + (1.0F - var22) * var23[22] * var23[30]);
                  float var10 = var22 + (var25 - var22) * Math.min(1.0F, var24);
                  var2.ew = var10;
                  return var10;
               }
            } else if (var0 == EnvironmentAttributes.STAR_ANGLE_VISUAL) {
               return null;
            } else {
               if (var0 == EnvironmentAttributes.STAR_BRIGHTNESS_VISUAL && var1 instanceof Float) {
                  var2.eq = (Float)var1;
               }

               if (var0 == EnvironmentAttributes.SKY_COLOR_VISUAL && var1 instanceof Integer) {
                  int var6 = (Integer)var1;
                  var2.eu = (float)Math.max(
                        var6 >> 16 & (-436284537 ^ -436284552), Math.max(var6 >> 8 & (-1778418284 ^ -1778418325), var6 & (-645648829 ^ -645648708))
                     )
                     / 255.0F;
               }

               float var21 = var2.cv * var2.da;
               if (var21 <= 0.002F) {
                  return null;
               } else {
                  float var7 = var21 * 1.45F;
                  if (var7 > 1.0F) {
                     var7 = 1.0F;
                  }

                  float[] var8 = var2.cs;
                  double var9 = var2.dd;
                  float var11 = 0.5F + 0.5F * (float)Math.sin(var9 * 0.6);
                  float var12 = var2.dh;
                  float var13 = var8[22];
                  if (var0 == EnvironmentAttributes.SKY_COLOR_VISUAL && var1 instanceof Integer) {
                     float var33 = (1.0F - var8[26] * (1.0F - var11)) * Math.max(var2.eu, var13);
                     return s((Integer)var1, var8[0] * var33, var8[1] * var33, var8[2] * var33, var7);
                  } else if (var0 == EnvironmentAttributes.FOG_COLOR_VISUAL && var1 instanceof Integer) {
                     int var32 = (Integer)var1;
                     float var39 = (1.0F - 0.5F * var8[26] * (1.0F - var11) + var8[28] * var12 * var2.db)
                        * Math.max(
                           (float)Math.max(
                                 var32 >> 16 & (895035560 ^ 895035479), Math.max(var32 >> 8 & (-513539748 ^ -513539677), var32 & (-1006320594 ^ -1006320431))
                              )
                              / 255.0F,
                           var13
                        );
                     return s(var32, var8[3] * var39, var8[4] * var39, var8[5] * var39, var7);
                  } else if (var0 == EnvironmentAttributes.SUNRISE_SUNSET_COLOR_VISUAL && var1 instanceof Integer) {
                     int var31 = (Integer)var1;
                     float var38 = (float)(Math.sin(var9 * 1.7) * Math.sin(var9 * 0.73));
                     float var43 = 1.0F - var8[27] * (0.5F - 0.5F * var38);
                     float var46 = var8[9] * var43 * Math.max(var2.eu, var13);
                     int var18 = var31 >>> 24;
                     int var19 = Math.round((float)var18 + (var46 * 255.0F - (float)var18) * var7);
                     var19 = var19 < 0 ? 0 : (var19 > (-769533502 ^ -769533635) ? 1176363438 ^ 1176363345 : var19);
                     int var20 = s(var31, var8[6], var8[7], var8[8], var7);
                     return var20 & (-54403547 ^ -63036966) | var19 << 24;
                  } else if (var0 == EnvironmentAttributes.CLOUD_COLOR_VISUAL && var1 instanceof Integer) {
                     int var30 = (Integer)var1;
                     float var37 = Math.max(
                        (float)Math.max(var30 >> 16 & (284213667 ^ 284213596), Math.max(var30 >> 8 & (11198102 ^ 11198057), var30 & (2021265111 ^ 2021264936)))
                           / 255.0F,
                        var13
                     );
                     int var42 = s(var30, var8[10] * var37, var8[11] * var37, var8[12] * var37, var7);
                     int var44 = Math.round((float)(var30 >>> 24) * (1.0F - var7 * (1.0F - var8[23])));
                     var44 = var44 < 0 ? 0 : (var44 > (460359392 ^ 460359199) ? -1424463178 ^ -1424463287 : var44);
                     return var42 & (2014220278 ^ 2029088777) | var44 << 24;
                  } else if (var0 == EnvironmentAttributes.SKY_LIGHT_COLOR_VISUAL && var1 instanceof Integer) {
                     return s((Integer)var1, var8[13], var8[14], var8[15], var7 * 0.85F);
                  } else if (var0 == EnvironmentAttributes.FOG_START_DISTANCE_VISUAL && var1 instanceof Float) {
                     return MathHelper.lerp(var21, (Float)var1, var8[16]);
                  } else if (var0 == EnvironmentAttributes.FOG_END_DISTANCE_VISUAL && var1 instanceof Float) {
                     float var29 = var8[17] * (1.0F - var8[29] * var12 * var2.db);
                     float var36 = (Float)var1;
                     return 1.0F / MathHelper.lerp(var21, 1.0F / Math.max(var36, 1.0F), 1.0F / Math.max(var29, 1.0F));
                  } else if (var0 == EnvironmentAttributes.SKY_FOG_END_DISTANCE_VISUAL && var1 instanceof Float) {
                     float var28 = (Float)var1;
                     return 1.0F / MathHelper.lerp(var21, 1.0F / Math.max(var28, 1.0F), 1.0F / Math.max(var8[18], 1.0F));
                  } else if (var0 == EnvironmentAttributes.CLOUD_FOG_END_DISTANCE_VISUAL && var1 instanceof Float) {
                     float var27 = (Float)var1;
                     return 1.0F / MathHelper.lerp(var21, 1.0F / Math.max(var27, 1.0F), 1.0F / Math.max(var8[17] * 2.0F, 1.0F));
                  } else if (var0 == EnvironmentAttributes.STAR_BRIGHTNESS_VISUAL && var1 instanceof Float) {
                     float[] var26 = var2.pw;
                     boolean var35 = ShellArrayCache.al;
                     float var41 = var35 ? var26[3] + var26[4] + var26[10] + var26[11] + var26[6] + var26[8] + var26[9] : 0.0F;
                     float var17 = MathHelper.lerp(var21, (Float)var1, var8[21] * var2.dk * (1.0F - Math.min(1.0F, var41)));
                     var2.eq = Math.max(var17, (var26[3] + var26[4] + 0.6F * var26[10] + (var35 ? var2.dj : 0.0F)) * var21);
                     return var17;
                  } else {
                     float var14 = var2.cv * (1.0F - var2.dp) * var8[30];
                     if (var0 == EnvironmentAttributes.SUN_ANGLE_VISUAL && var1 instanceof Float) {
                        float var34 = (Float)var1;
                        float var40 = var34 + MathHelper.wrapDegrees(var8[19] - var34) * var14;
                        var2.er = var40;
                        var2.et = System.nanoTime();
                        return var40;
                     } else if (var0 == EnvironmentAttributes.MOON_ANGLE_VISUAL && var1 instanceof Float) {
                        float var15 = (Float)var1;
                        float var16 = var15 + MathHelper.wrapDegrees(var8[20] - var15) * var14;
                        var2.es = var16;
                        return var16;
                     } else if (var0 == EnvironmentAttributes.MOON_PHASE_VISUAL && var1 instanceof MoonPhase) {
                        if (var2.cv * var2.pw[8] > 0.5F) {
                           return MoonPhase.FULL_MOON;
                        } else {
                           return var2.cv * var2.pw[4] > 0.5F ? MoonPhase.WAXING_CRESCENT : null;
                        }
                     } else {
                        return null;
                     }
                  }
               }
            }
         }
      } else {
         return null;
      }
   }

   private static int s(int var0, float var1, float var2, float var3, float var4) {

      int var5 = var0 >>> 24;
      int var6 = var0 >> 16 & (1584593919 ^ 1584593664);
      int var7 = var0 >> 8 & (-970923912 ^ -970923897);
      int var8 = var0 & (-611266549 ^ -611266316);
      int var9 = Math.round((float)var6 + (var1 * 255.0F - (float)var6) * var4);
      int var10 = Math.round((float)var7 + (var2 * 255.0F - (float)var7) * var4);
      int var11 = Math.round((float)var8 + (var3 * 255.0F - (float)var8) * var4);
      var9 = var9 < 0 ? 0 : (var9 > (-1202064820 ^ -1202064717) ? -929700942 ^ -929701043 : var9);
      var10 = var10 < 0 ? 0 : (var10 > (-1732261698 ^ -1732261823) ? -1073652879 ^ -1073652850 : var10);
      var11 = var11 < 0 ? 0 : (var11 > (-619989869 ^ -619989908) ? -956494503 ^ -956494426 : var11);
      return var5 << 24 | var9 << 16 | var10 << 8 | var11;
   }

   public static float t() {

      LerpZoneBuffer var0 = I;
      return var0 != null && !IDLE ? var0.cv * var0.da : 0.0F;
   }

   public float u() {

      return this.di;
   }

   public boolean v() {

      return this.bf.f();
   }

   public float w() {

      return this.es;
   }

   public float x() {

      float var1 = this.eq * 1.6F;
      return this.ep * (var1 > 1.0F ? 1.0F : var1) * this.dk;
   }

   private boolean y() {

      try {
         Camera var1 = a.gameRenderer.getCamera();
         CameraSubmersionType var2 = var1.getSubmersionType();
         if (var2 != CameraSubmersionType.LAVA && var2 != CameraSubmersionType.POWDER_SNOW) {
            if (var1.getFocusedEntity() instanceof LivingEntity var3 && (var3.hasStatusEffect(StatusEffects.BLINDNESS) || var3.hasStatusEffect(StatusEffects.DARKNESS))) {
               return false;
            }

            return true;
         } else {
            return false;
         }
      } catch (Throwable var5) {
         return true;
      }
   }

   @Override
   public void a(DrawContext var1) {

      try {
         if (IDLE) {
            return;
         }

         this.a();
         if (!LIC) {
            return;
         }

         this.df = System.nanoTime();
         float var2 = this.cx * this.da * this.cy;
         if (var2 <= 0.003F || a.world == null || !FieldVolumeCache.b()) {
            return;
         }

         int var3 = a.getWindow().getScaledWidth();
         int var4 = a.getWindow().getScaledHeight();
         if (var3 <= 0 || var4 <= 0) {
            return;
         }

         double var5 = this.dd;
         float[] var7 = this.pw;
         float var8 = var2 * Math.max(this.eu, Math.max(0.35F, this.cs[22]));
         float var9 = var8 * var7[0];
         if (var9 > 0.004F) {
            ab(var1, 0, var3, var4, -897653208 ^ -895087913, var9 * 0.14F);
            ab(var1, 1, var3, var4, 1756922355 ^ 1750234892, var9 * (0.1F + 0.22F * this.dh * this.db));
         }

         float var10 = var8 * var7[1];
         if (var10 > 0.004F) {
            float var11 = 0.84F + 0.16F * MathHelper.sin((double)((float)(var5 * 1.4)));
            ab(var1, 0, var3, var4, -659962978 ^ -668735084, var10 * (0.07F + 0.05F * this.dc) * var11);
            ac(var1, var3, var4, -191550729 ^ -194359073, var10 * (0.035F + 0.035F * this.dc) * var11, false);
            ac(var1, var3, var4, 38487473 ^ 39800244, var10 * 0.12F, true);
         }

         float var24 = var8 * var7[2];
         if (var24 > 0.004F) {
            ab(var1, 0, var3, var4, -1514180906 ^ -1522469790, var24 * 0.1F);
            ac(var1, var3, var4, -522265453 ^ -534703101, var24 * 0.04F, false);
         }

         float var12 = var8 * var7[3];
         if (var12 > 0.004F) {
            ab(var1, 0, var3, var4, 1977112409 ^ 1977374293, var12 * 0.22F);
            ab(var1, 0, var3, var4, 1062112026 ^ 1061077989, var12 * 0.04F * (0.85F + 0.15F * MathHelper.sin((double)((float)(var5 * 0.25)))));
         }

         float var13 = var8 * var7[4];
         if (var13 > 0.004F) {
            ab(var1, 0, var3, var4, -1599627554 ^ -1599240976, var13 * 0.16F);
            ab(var1, 1, var3, var4, -206252143 ^ -210028434, var13 * 0.06F);
            float var14 = aa(var5);
            int var15 = (int)(61.0F + 93.0F * var14) << 16 | (int)(255.0F - 148.0F * var14) << 8 | (int)(176.0F + 79.0F * var14);
            ac(
               var1,
               var3,
               var4,
               var15,
               var13
                  * 0.03F
                  * (0.75F + 0.25F * MathHelper.sin((double)((float)(var5 * 0.9))) * MathHelper.sin((double)((float)(var5 * 0.37)))),
               true
            );
         }

         float var25 = var8 * var7[5];
         if (var25 > 0.004F) {
            ab(var1, 0, var3, var4, -914711059 ^ -914018933, var25 * 0.08F);
            ac(var1, var3, var4, -442665459 ^ -446497757, var25 * 0.04F, false);
         }

         float var26 = var8 * var7[6];
         if (var26 > 0.004F) {
            ab(var1, 0, var3, var4, -905378794 ^ -905770436, var26 * 0.16F);
            ac(var1, var3, var4, 124221823 ^ 129992207, var26 * 0.02F * (0.8F + 0.2F * MathHelper.sin((double)((float)(var5 * 0.7)))), false);
            ac(var1, var3, var4, 795094703 ^ 794690805, var26 * 0.06F, true);
         }

         float var16 = var8 * var7[7];
         if (var16 > 0.004F) {
            float var17 = this.dh * this.db;
            ab(var1, 0, var3, var4, 950174046 ^ 941230864, var16 * (0.16F + 0.08F * var17));
            ab(var1, 1, var3, var4, -547133330 ^ -544887582, var16 * (0.06F + 0.18F * var17));
            ac(var1, var3, var4, -855326005 ^ -842247035, var16 * 0.08F, false);
         }

         float var27 = var8 * var7[8];
         if (var27 > 0.004F) {
            float var18 = (float)(var5 * 0.75 % 1.0);
            float var19 = var18 < 0.12F
               ? MathHelper.sin((double)(var18 / 0.12F * (float) Math.PI))
               : (var18 < 0.3F && var18 > 0.16F ? 0.7F * MathHelper.sin((double)((var18 - 0.16F) / 0.14F * (float) Math.PI)) : 0.0F);
            ab(var1, 0, var3, var4, -1125704162 ^ -1124262892, var27 * (0.18F + 0.04F * var19));
            ac(var1, var3, var4, -2051172919 ^ -2048420415, var27 * 0.06F, true);
         }

         float var28 = var8 * var7[9];
         if (var28 > 0.004F) {
            ab(var1, 0, var3, var4, 1144520354 ^ 1141370568, var28 * 0.14F);
            ac(var1, var3, var4, -1093949614 ^ -1103848456, var28 * 0.06F, false);
            ac(var1, var3, var4, -80455502 ^ -82820414, var28 * 0.08F, true);
         }

         float var29 = ShellArrayCache.av ? ShellArrayCache.aw : 0.0F;
         float var20 = var8 * var7[10];
         if (var20 > 0.004F) {
            z(var1, 2105705084 ^ 2105704572, var3, var4, 780285058 ^ 782380181, var20 * 0.55F * var29);
            ab(var1, 0, var3, var4, 931156887 ^ 933251968, var20 * 0.22F * (1.0F - var29));
         }

         float var21 = var8 * var7[11];
         if (var21 > 0.004F) {
            z(var1, 0, var3, var4, -1106292234 ^ -1104184882, var21 * 0.22F * var29);
            ab(var1, 0, var3, var4, 471363066 ^ 473449922, var21 * 0.14F * (1.0F - var29));
            ab(var1, 1, var3, var4, 439270044 ^ 450642531, var21 * (0.08F + 0.1F * this.dh * this.db));
         }

         float var22 = var8 * var7[12];
         if (var22 > 0.004F) {
            ab(var1, 0, var3, var4, -1737415987 ^ -1737416249, var22 * 0.22F);
         }
      } catch (Throwable var23) {
      }
   }

   private static void z(DrawContext var0, int var1, int var2, int var3, int var4, float var5) {

      int var6 = (int)(var5 * 255.0F + 0.5F);
      if (var6 >= 3) {
         var0.drawTexture(
            RenderPipelines.GUI_TEXTURED,
            ShellArrayCache.HAZE_MASK,
            0,
            0,
            (float)var1 + 0.5F,
            768.5F,
            var2,
            var3,
            467699764 ^ 467699915,
            813709680 ^ 813709711,
            -1434434638 ^ -1434433614,
            -1756762132 ^ -1756763156,
            (var6 > (1356701146 ^ 1356700965) ? -680969184 ^ -680968993 : var6) << 24 | var4
         );
      }
   }

   public static float aa(double var0) {

      return 0.35F * (0.5F + 0.5F * (float)Math.sin(var0 * 0.21));
   }

   private static void ab(DrawContext var0, int var1, int var2, int var3, int var4, float var5) {

      int var6 = (int)(var5 * 255.0F + 0.5F);
      if (var6 >= 3) {
         var0.drawTexture(
            RenderPipelines.GUI_TEXTURED,
            FieldVolumeCache.AURA_TEX,
            0,
            0,
            (float)var1 * 256.0F,
            0.0F,
            var2,
            var3,
            -1840736352 ^ -1840736608,
            529551274 ^ 529551018,
            -465681292 ^ -465680780,
            -1120885644 ^ -1120885388,
            (var6 > (1326092969 ^ 1326092886) ? 1843363142 ^ 1843363257 : var6) << 24 | var4
         );
      }
   }

   private static void ac(DrawContext var0, int var1, int var2, int var3, float var4, boolean var5) {

      int var6 = (int)(var4 * 255.0F + 0.5F);
      if (var6 >= 2) {
         var6 = var6 > (-1656527637 ^ -1656527852) ? 1492737321 ^ 1492737494 : var6;
         int var7 = var6 << 24 | var3;
         int var8 = var6 + 2 >> 2 << 24 | var3;
         int var10 = (int)((float)var2 * (var5 ? 0.34F : 0.42F));
         int var11 = var10 >> 1;
         if (var5) {
            var0.fillGradient(0, 0, var1, var11, var7, var8);
            var0.fillGradient(0, var11, var1, var10, var8, var3);
         } else {
            var0.fillGradient(0, var2 - var10, var1, var2 - var11, var3, var8);
            var0.fillGradient(0, var2 - var11, var1, var2, var8, var7);
         }
      }
   }

   public float ad() {

      return this.dh;
   }

   @Override
   public void d() {

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

   static {
      for (float[] var3 : cm) {
         for (int var4 = 0; var4 < 16; var4++) {
            if (var4 != 9) {
               var3[var4] /= 255.0F;
            }
         }
      }

      em = new float[]{0.84F, 0.94F, 1.12F, 1.26F, 1.41F, 1.68F, 1.89F};
      en = new int[]{3, 6, 10, 15, 11, 15, 18, 23, 6, 10, 13, 18, 1, 5, 8, 13};
      eo = new int[]{0, 1, 2, 3, 2, 1, 2, 1};
   }
}
