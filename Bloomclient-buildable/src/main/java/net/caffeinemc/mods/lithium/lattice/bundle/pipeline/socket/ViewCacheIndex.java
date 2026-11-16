package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket;

import java.util.List;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.InitNotifier;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.ParserEngine;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.BlockCalculator;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.CheckerBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.ItemDescriptor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.SlotEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.BevelPassCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.ThemeCache;

public final class ViewCacheIndex extends BuilderFactory implements InitNotifier {
   private static final String[] c = new String[]{"N.one", "B.utterfly " + "Kni" + "fe", "K.a" + "rambit", "K.unai", "B.ayonet", "T.alon", "K.atana"};
   private static final String[] d = new String[]{"S.words", "S.w" + "ords & Axes", "W.eapons", "A" + ".ny" + " " + "Item"};
   private static final String[] e = new String[]{"S.teel", "F.ade", "D.oppler", "T.iger " + "T" + "ooth", "C.rimson", "U.ltra" + "vio" + "let", "T.heme"};
   private static final String[] f = new String[]{"W.hite", "T.heme", "B.lue", "P.urple", "R.ed"};
   private static final String[] g = new String[]{"N.ormal", "G.low", "H.idden"};
   private static final String[] h = new String[]{"B.lue", "T.heme", "P.urple", "R.ed", "W.hite"};
   private static final String[] i = new String[]{"N.atural", "F.orward", "L.ow", "R.everse", "T.ilted"};
   private static final String[] j = new String[]{"C.ycle", "R.andom"};
   private static final int[] k = new int[]{16777215, -1, 5219071, 11697151, 16730714};
   private static final int[] l = new int[]{3046399, -1, 9063423, 15214650, 14542578};
   private static final int[] m = new int[]{8845055, -1, 14528767, 16752800, 16777215};
   private final ItemDescriptor n;
   private final SlotEntry o;
   private final SlotEntry p;
   private final SlotEntry q;
   private final CheckerBridge r;
   private final CheckerBridge s;
   private final SlotEntry t;
   private final BlockCalculator u;
   private final SlotEntry v;
   private final SlotEntry w;
   private final BlockCalculator x;
   private final CheckerBridge y;
   private final BlockCalculator z;
   private final SlotEntry aa;
   private final BlockCalculator ab;
   private final CheckerBridge ac;
   private final BlockCalculator ad;
   private final CheckerBridge ae;
   private final SlotEntry af;

   public ViewCacheIndex() {
      super("", "", ParserEngine.Z3);
      this.setName(
         new char[]{'蕢', '蕤', '蔝', '藭', '藊', '藦', '薬', '虪', '虐', '蘲', '蘄', '蛣', '蛫'},
         1061913899,
         new char[]{
            '쾛',
            '쿟',
            '큾',
            '큜',
            '퀾',
            '퀈',
            '탯',
            '탟',
            '탪',
            '킐',
            '텧',
            '텒',
            '턴',
            '텅',
            '퇬',
            '퇆',
            '톮',
            '톅',
            '툠',
            '퉶',
            '퉊',
            '툸',
            '툑',
            '튻',
            '틖',
            '튰',
            '튓',
            '퍲',
            '팖',
            '팖',
            '팧',
            '펡',
            '펈',
            '폱',
            '펛',
            '푡',
            '푇',
            '퐫',
            '퐉',
            '풫',
            '퓙',
            '풢',
            '풁',
            '합',
            '핕',
            '합',
            '필',
            '헥',
            '헋',
            '햯',
            '행',
            '햌',
            '홶',
            '환',
            '혯',
            '홗',
            '횺',
            '훞',
            '횴',
            '횘',
            '흡',
            '휕',
            '휵',
            '휝',
            'ퟶ',
            '힑',
            'ힱ',
            'ퟏ',
            '\ud869',
            '\ud841',
            '\ud823',
            '\ud81c',
            '\ud8e3',
            '\ud8c7',
            '\ud8af',
            '\ud8c7',
            '\ud967',
            '\ud957',
            '\ud929'
         },
         282775506
      );
      ItemDescriptor var10001 = new ItemDescriptor("", -1, false);
      var10001.n(new char[]{'㻨', '㻦', '㺄', '㽲', '㽌', '㼲', '㼂', '㿶', '㿄', '㿠', '㾔', '㾛', '䁤'}, -669303127);
      this.n = var10001;
      this.o = new SlotEntry("S.kin", c[1], c);
      this.p = new SlotEntry("A" + ".ppl" + "ie" + "s To", d[0], d);
      this.q = new SlotEntry("F.inish", e[0], e);
      CheckerBridge var1 = new CheckerBridge("", true);
      var1.n(new char[]{'캀', '컍', '콰', '콀', '켷', '콿', '켿', '쿳', '쿕', '쾶', '쾛', '큭', '큑', '퀸', '퀘'}, -1133654332);
      this.r = var1;
      CheckerBridge var2 = new CheckerBridge("", true);
      var2.n(new char[]{'帋', '幏', '廴', '建', '廓', '廽', '庻', '彷', '录', '弮'}, -821469630);
      this.s = var2;
      this.t = new SlotEntry("G.low Col" + "or", f[0], f);
      BlockCalculator var3 = new BlockCalculator("", 0.1, 2.0, 1.0, 0.1);
      var3.n(new char[]{'ｂ', '＊', 'Ｏ', '－', '\ufff6', 'ﾀ', '￬', 'ﾪ', 'ﾏ', 'y', 'U', '=', '\r', 'ð'}, -1265762555);
      this.u = var3;
      this.v = new SlotEntry("A.rm", g[1], g);
      this.w = new SlotEntry("A." + "rm" + " Col" + "or", h[0], h);
      BlockCalculator var4 = new BlockCalculator("", 0.5, 2.0, 1.0, 0.1);
      var4.n(
         new char[]{'\ue672', '\ue674', '\ue617', '\ue6eb', '\ue6c7', '\ue6b3', '\ue696', '\ue760', '\ue713', '\ue701', '\ue701', '\ue7f5', '\ue7ca', '\ue7aa'},
         1145759291
      );
      this.x = var4;
      CheckerBridge var5 = new CheckerBridge("", true);
      var5.n(new char[]{'䮧', '䰽', '䱅', '䰰', '䰉'}, 1796033524);
      this.y = var5;
      BlockCalculator var6 = new BlockCalculator("", 0.0, 2.0, 1.0, 0.1);
      var6.n(new char[]{'ᆺ', 'ሦ', 'ቐ', 'ሧ', 'ሜ', 'ኤ', 'ዢ', 'ኯ', '\u128e', '፵', '፱', 'ፊ'}, -2107829783);
      this.z = var6;
      this.aa = new SlotEntry("H.old St" + "yle", i[0], i);
      BlockCalculator var7 = new BlockCalculator("", 0.3, 1.2, 0.6, 0.05);
      var7.n(new char[]{'\uf500', '\uf54e', '\uf50d', '\uf5f3', '\uf59d', '\uf58f', '\uf592', '\uf660', '\uf65c'}, -1305873087);
      this.ab = var7;
      CheckerBridge var8 = new CheckerBridge("", true);
      var8.n(new char[]{'줠', '즼', '짞', '즥', '즁', '쩪', '쩞'}, -1459697293);
      this.ac = var8;
      BlockCalculator var9 = new BlockCalculator("", 0.0, 1.0, 0.6, 0.05);
      var9.n(new char[]{'媒', '嫎', '媐', '孫', '孓', '嬸', '孛', '富', '寖', '宴', '宂', '屻', '屐'}, 468540097);
      this.ad = var9;
      CheckerBridge var10 = new CheckerBridge("", true);
      var10.n(new char[]{'獱', '獹', '猒', '珹', '珑', '珳', '玴', '瑸', '瑔', '琨', '琋', '瓹', '瓟'}, 957510456);
      this.ae = var10;
      this.af = new SlotEntry("I.nspect O" + "r" + "der", j[0], j);
      this.a(
         new InitAdapter[]{
            this.n,
            this.o,
            this.p,
            this.q,
            this.r,
            this.s,
            this.t,
            this.u,
            this.v,
            this.w,
            this.x,
            this.y,
            this.z,
            this.aa,
            this.ab,
            this.ac,
            this.ad,
            this.ae,
            this.af
         }
      );
   }

   @Override
   public void c() {

      this.b.a(InitNotifier.class, this);
      this.b();
      BevelPassCache.a();
      BevelPassCache.ON = true;
      super.c();
   }

   @Override
   public void d() {

      BevelPassCache.ON = false;
      this.b.b(InitNotifier.class, this);
      super.d();
   }

   @Override
   public void a() {

      this.b();
   }

   public void b() {

      BevelPassCache.KEY = this.n.g();
      BevelPassCache.SKIN = Math.max(0, this.o.g().indexOf(this.o.f()));
      BevelPassCache.APPLY = Math.max(0, this.p.g().indexOf(this.p.f()));
      BevelPassCache.FINISH = Math.max(0, this.q.g().indexOf(this.q.f()));
      BevelPassCache.DRAW_ANIM = this.r.f();
      BevelPassCache.GLOW = this.s.f();
      BevelPassCache.GLOW_STR = this.u.h();
      BevelPassCache.SPEED = this.x.h();
      BevelPassCache.SWAY = this.y.f();
      BevelPassCache.SWAY_AMT = this.z.h();
      BevelPassCache.HOLD_STYLE = Math.max(0, this.aa.g().indexOf(this.aa.f()));
      BevelPassCache.ARM_SIZE = this.ab.h();
      BevelPassCache.SOUNDS = this.ac.f();
      BevelPassCache.SND_VOL = this.ad.h();
      BevelPassCache.FIDGETS = this.ae.f();
      BevelPassCache.INS_RANDOM = this.af.g().indexOf(this.af.f()) == 1;
      int[] var1 = ThemeCache.j();
      int var2 = (var1[0] & (1496485529 ^ 1496485478)) << 16 | (var1[1] & (-1484496341 ^ -1484496172)) << 8 | var1[2] & (-1786752882 ^ -1786752911);
      BevelPassCache.THEME_RGB = var2;
      int var3 = Math.max(0, this.t.g().indexOf(this.t.f()));
      BevelPassCache.GLOW_RGB = k[var3] < 0 ? var2 : k[var3];
      BevelPassCache.ARM = Math.max(0, this.v.g().indexOf(this.v.f()));
      int var4 = Math.max(0, this.w.g().indexOf(this.w.f()));
      if (l[var4] < 0) {
         BevelPassCache.ARM_RGB = var2;
         int var5 = (var1[0] & (1217226777 ^ 1217226982)) + ((-812332353 ^ -812332480) - (var1[0] & (1653803319 ^ 1653803464))) / 2;
         int var6 = (var1[1] & (-579381700 ^ -579381565)) + ((2040953888 ^ 2040954079) - (var1[1] & (-465781143 ^ -465781098))) / 2;
         int var7 = (var1[2] & (1677511867 ^ 1677511748)) + ((-1594876834 ^ -1594876767) - (var1[2] & (2000488812 ^ 2000488851))) / 2;
         BevelPassCache.ARM_RIM = var5 << 16 | var6 << 8 | var7;
      } else {
         BevelPassCache.ARM_RGB = l[var4];
         BevelPassCache.ARM_RIM = m[var4];
      }
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
