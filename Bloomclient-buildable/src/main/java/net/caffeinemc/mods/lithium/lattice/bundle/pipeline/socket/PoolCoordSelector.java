package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket;

import java.util.List;
import net.caffeinemc.mods.lithium.lattice.bundle.overlay.element.BindingAccessor;
import net.caffeinemc.mods.lithium.lattice.bundle.overlay.element.GridAccessor;
import net.caffeinemc.mods.lithium.lattice.bundle.overlay.element.PacketBinder;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.CoreSerializer;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.InitNotifier;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.LinkerFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.UtilExtension;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.ParserEngine;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.BlockCalculator;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.CheckerBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.ItemDescriptor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.SlotEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.TimingEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.FrameClockCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.InitExecutor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.LockD;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.RotG;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.SlotInspector;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.StyleKeyCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.CoreZoneProcessor;
import net.minecraft.client.util.Window;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.potion.Potions;
import net.minecraft.util.hit.HitResult;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.component.DataComponentTypes;
import org.joml.Matrix3x2fStack;
import org.lwjgl.glfw.GLFW;
import net.minecraft.entity.Entity;
public final class PoolCoordSelector extends BuilderFactory implements InitNotifier, CoreSerializer, UtilExtension {
   private static final int az = 0;
   private static final int ba = 1;
   private static final int bb = 2;
   private static final int bc = 3;
   private static final float bd = 89.0F;
   private static final float be = 2.0F;
   private static final float bf = 0.5F;
   private static final double bg = 8.0E7;
   private static final long bh = 100000000L;
   private static final long bi = 2000000000L;
   private static final long bj = 200000000L;
   private static final int bk = 1;
   private static final int bl = 2;
   private static final int bm = 3;
   private static final String[] bn = new String[]{"Auto", "Hover", "Off"};
   private static final int bo = 0;
   private static final int bp = 1;
   private static final int bq = 2;
   private static final String[] br = new String[]{"Auto", "Key", "Both"};
   private static final int bs = 0;
   private static final int bt = 1;
   private static final String[] bu = new String[]{"Above Hotbar", "Left", "Right", "Top Left"};
   private static final int bv = 1;
   private static final int bw = 2;
   private static final int bx = 3;
   private static final String[] by = new String[]{"Health", "Strength", "Speed"};
   private static final String[] bz = new String[]{" / "};
   private static final String[] ca = new String[100];
   private static final int cb = 360;
   private static final int cc = 40;
   private static final float cd = 6.0F;
   private static final float ce = 9.0F;
   private static final float cf = 11.0F;
   private static final float cg = 5.0F;
   private static final float ch = 1.5F;
   private static final float ci = 57.0F;
   private static final int[] cj;
   private static final int ck = 452984831;
   private static final int cl = -420088329;
   private final BlockCalculator cm;
   private final TimingEntry cn;
   private final BlockCalculator co;
   private final CheckerBridge cp;
   private final TimingEntry cq;
   private final CheckerBridge cr;
   private final BlockCalculator cs;
   private final BlockCalculator ct;
   private final BlockCalculator cu;
   private final SlotEntry cv;
   private final TimingEntry cw;
   private final CheckerBridge cz;
   private final BlockCalculator da;
   private final SlotEntry db;
   private final ItemDescriptor dc;
   private final CheckerBridge dd;
   private final CheckerBridge de;
   private final SlotEntry df;
   private final Runnable dg;
   private final Runnable dh;
   private boolean di;
   private long dj;
   private volatile boolean dk;
   private boolean dl;
   private boolean dm;
   private int dn;
   private boolean _kwren_do;
   private ClientPlayerEntity dp;
   private float dq;
   private float dr;
   private long ds;
   private long dt;
   private long du;
   private int dv;
   private int dw;
   private int dx;
   private ClientPlayerEntity dy;
   private boolean dz;
   private int ea;
   private boolean eb;
   private boolean ec;
   private String ed;
   private String ee;
   private String ef;
   private int eg;
   private int eh;
   private int ei;
   private boolean ej;
   private boolean ek;
   private int el;
   private boolean em;
   private boolean en;
   private double eo;
   private long ep;
   private long eq;
   private final int[] er;
   private boolean es;
   private boolean et;
   private final ItemStack[] eu;
   private final int[] ev;
   private final int[] ew;
   private final int[] ex;
   private final int[] ey;
   private final int[] ez;
   private final ItemStack[] fa;
   private final String[] fb;
   private final int[] fc;
   private final StringBuilder fd;
   private boolean fe;
   private int ff;
   private float fg;
   private float fh;
   private boolean fi;
   private long fj;
   private boolean fk;
   private boolean fl;
   private long fm;
   private long fn;
   private static final long fo = 50000000L;
   private boolean fp;
   private boolean fq;
   private int fs;
   private int ft;
   private int fu;
   private int fv;
   private int fw;
   private int fx;
   private long fy;
   private double fz;
   private double ga;
   private final double[] gb;
   private final double[] gc;
   private static int gd = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   public PoolCoordSelector() {
      super("", "", ParserEngine.PC);
      this.setName(
         new char[]{'㷤', '㷪', '㶖', '㹶', '㹎', '㹠', '㸏', '㸑', '㻩'},
         -1548141147,
         new char[]{
            '헪',
            '헳',
            '햔',
            '황',
            '확',
            '혮',
            '혋',
            '횷',
            '훞',
            '횰',
            '횕',
            '흿',
            '흛',
            '휿',
            '휗',
            '\ud7af',
            'ퟏ',
            '힣',
            '히',
            '\ud82b',
            '\ud848',
            '\ud83c',
            '\ud80e',
            '\ud8e1',
            '\ud886',
            '\ud8b6',
            '\ud894',
            '\ud96f',
            '\ud943',
            '\ud932',
            '\ud908',
            '\ud95f',
            '\ud9ee',
            '\ud9d2',
            '\ud9a8',
            '\ud992',
            '\uda75',
            '\uda57',
            '\uda2b',
            '\uda57',
            '\udaf7',
            '\udac1',
            '\udaf4',
            '\uda8a',
            '\udb7d',
            '\udb44',
            '\udb22',
            '\udb4f',
            '\udbe8',
            '\udbc8',
            '\udba9',
            '\udb9f'
         },
         414635454
      );
      BlockCalculator var10001 = new BlockCalculator("", 1.0, 20.0, 15.0, 1.0);
      var10001.n(new char[]{'ᰈ', 'ᱱ', 'ᰛ', '\u1cfc', '᳐', 'Ჯ', 'Გ'}, -1156834240);
      this.cm = var10001;
      TimingEntry var1 = new TimingEntry("", 50.0, 5000.0, 500.0, 1.0, 1.0, 0.0);
      var1.n(new char[]{'錼', '鎹', '鏓', '鎹', '鎕', '鑪'}, 223122296);
      this.cn = var1;
      var10001 = new BlockCalculator("", 1.0, 10.0, 7.0, 1.0);
      var10001.n(new char[]{'ॗ', 'ऊ', 'ब', 'ख', 'ৠ', '\u09d4', '\u09d6', '\u09b1', 'ও', '਼', '੨', 'ਪ', 'ਜ', '૽', '\u0ad3'}, -1345451771);
      this.co = var10001;
      CheckerBridge var3 = new CheckerBridge("", true);
      var3.n(new char[]{'蔯', '薢', '藞', '薬', '薏', '蘨', '虷', '蘩', '蘑', '蛷'}, -1285454483);
      this.cp = var3;
      TimingEntry var4 = new TimingEntry("", 0.0, 1000.0, 500.0, 1.0);
      var4.n(new char[]{'篾', '篰', '箛', '籨', '籞', '簨', '籙', '糐', '糞', '粢'}, -1900184641);
      this.cq = var4;
      CheckerBridge var5 = new CheckerBridge("", true);
      var5.n(new char[]{'邴', '鄫', '酁', '鄰', '鄖', '釮', '釒', '釚', '釾', '醫', '鉵', '鉞', '鈭'}, -1047424794);
      this.cr = var5;
      var10001 = new BlockCalculator("", 0.0, 9.0, 7.0, 1.0);
      var10001.n(new char[]{'瑬', '瑭', '琇', '瓠', '瓌', '瓋', '璶', '瓝', '畏', '畗', '电', '甍'}, 1900311588);
      this.cs = var10001;
      var10001 = new BlockCalculator("", 0.0, 9.0, 8.0, 1.0);
      var10001.n(new char[]{'썚', '쌆', '쌳', '쌔', '쏠', '쏊', '쎤', '쎖', '쑩', '쐀', '쑬', '쐲', '쐒', '쓨'}, -1925922039);
      this.ct = var10001;
      var10001 = new BlockCalculator("", 0.0, 9.0, 9.0, 1.0);
      var10001.n(new char[]{'擸', '擤', '撙', '敭', '敂', '攢', '故', '旗', '族', '断', '斕'}, 1738040491);
      this.cu = var10001;
      this.cv = new SlotEntry("R.efill", bn[0], bn);
      TimingEntry var9 = new TimingEntry("", 0.0, 1000.0, 100.0, 1.0);
      var9.n(new char[]{'믁', '뮜', '뮴', '뮖', '뱦', '뱂', '밡', '뱌', '볏', '볏', '벥', '벉', '뵾'}, 1151450003);
      this.cw = var9;
      CheckerBridge var10 = new CheckerBridge("", true);
      var10.n(new char[]{'\udc2e', '\udca2', '\udcde', '\udcb8', '\udc9a', '\udd67', '\udd55', '\udd66', '\udd28', '\uddeb', '\uddd5', '\udda7'}, 60415085);
      this.cz = var10;
      var10001 = new BlockCalculator("", 1.0, 20.0, 8.0, 1.0);
      var10001.n(new char[]{'萝', '葓', '蓩', '蓉', '蒩', '蒖', '蕪', '蔗', '蔅', '蔅', '藱', '藖', '薶'}, -889027490);
      this.da = var10001;
      this.db = new SlotEntry("T.hrow", br[0], br);
      ItemDescriptor var12 = new ItemDescriptor("", -1, false);
      var12.n(
         new char[]{'\ue5ee', '\ue5e0', '\ue58e', '\ue678', '\ue642', '\ue63c', '\ue608', '\ue6fc', '\ue6c2', '\ue6e6', '\ue6ae', '\ue761', '\ue75a'},
         1194321327
      );
      this.dc = var12;
      CheckerBridge var13 = new CheckerBridge("", true);
      var13.n(new char[]{'帚', '幇', '建', '廂', '庢', '庌', '彧', '彗', '形', '弥', '忯', '忪', '応', '徱', '徙'}, 626548298);
      this.dd = var13;
      CheckerBridge var14 = new CheckerBridge("", true);
      var14.n(new char[]{'歂', '欞', '欧', '欁', '毺', '殌', '殃', '殿', '汍'}, 1808755473);
      this.de = var14;
      this.df = new SlotEntry("H.UD Posit" + "ion", bu[0], bu);
      this.dg = this::p;
      this.dh = this::f_r76;
      this.dn = 0;
      this.dr = 0.1F;
      this.dv = -1;
      this.dw = -1;
      this.dx = -1;
      this.eg = 0;
      this.eh = 0;
      this.ei = 0;
      this.ej = true;
      this.el = -1;
      this.eo = 8.0;
      this.er = new int[]{-1, -1, -1, -1};
      this.eu = new ItemStack[36];
      this.ev = new int[36];
      this.ew = new int[36];
      this.ex = new int[4];
      this.ey = new int[4];
      this.ez = new int[4];
      this.fa = new ItemStack[4];
      this.fb = new String[4];
      this.fc = new int[]{-1, -1, -1, -1};
      this.fd = new StringBuilder(12);
      this.fe = true;
      this.ff = Integer.MIN_VALUE;
      this.fs = -1;
      this.gb = new double[1];
      this.gc = new double[1];
      this.a(
         this.cm,
         this.cn,
         this.co,
         this.cp,
         this.cq,
         this.cr,
         this.cs,
         this.ct,
         this.cu,
         this.cv,
         this.cw,
         this.cz,
         this.da,
         this.db,
         this.dc,
         this.dd,
         this.de,
         this.df
      );
   }

   @Override
   public void c() {

      this.dk = true;
      this.ac();
      int var1 = this.el;
      this.es = this.ek && var1 >= 0 && SlotInspector.a(var1);
      this.et = false;
      this.fi = false;
      this.di = false;
      this.fn = System.nanoTime() - 100000000L;
      this.fe = true;
      if (!this.dl) {
         this.dl = true;
         this.b.a(InitNotifier.class, this);
      }

      this.b.a(CoreSerializer.class, this);
      if (!this.dm) {
         this.dm = true;
         this.b.a(UtilExtension.class, this);
      }

      FrameClockCache.add(this.dh);
      super.c();
   }

   @Override
   public void d() {
      byte var1 = 0;

      label23:
      while (true) {
         switch (var1) {
            case 0:
            default:
               if (gd != 0) {
                  Math.abs(Integer.MIN_VALUE);
                  var1 = 1;
                  break;
               }
            case 1:
               this.dk = false;
               this.b.b(CoreSerializer.class, this);
               if (this.dm) {
                  this.dm = false;
                  this.b.b(UtilExtension.class, this);
                  var1 = 4;
                  break;
               }
            case 4:
               this.at();
               this.fi = false;
               if (this.dn != 0) {
                  this.aa();
                  var1 = 2;
                  break;
               }
            case 2:
               this.eb = false;
               this.ec = false;
               if (this.dw < 0) {
                  this.ab();
                  var1 = 3;
                  break;
               }
            case 3:
               break label23;
         }
      }

      FrameClockCache.b(this.dh);
      this.di = false;
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

   @Override
   public void a(LinkerFactory var1) {

      HitResult var2 = a.crosshairTarget;
      if (var2 == null || var2.getType() != HitResult.Type.BLOCK) {
         LockD.f = System.nanoTime();
      }
   }

   @Override
   public void a() {

      try {
         this.b();
      } catch (Throwable var2) {
         this.aa();
         this.at();
      }
   }

   @Override
   public void a(DrawContext var1) {

      if (this.dk) {
         if (this.ek) {
            try {
               this.af();
            } catch (Throwable var5) {
            }
         }

         if (this.fp) {
            try {
               this.ar();
            } catch (Throwable var4) {
               this.at();
            }
         }

         if (this.em) {
            try {
               this.aw(var1);
            } catch (Throwable var3) {
            }
         }
      }
   }

   private void b() {

      long var1 = System.nanoTime();
      long var3 = this.fn + 50000000L;
      long var5 = var1 - var3 >= 0L && var1 - var3 <= 50000000L ? var3 : var1;
      this.fn = var5;
      ClientPlayerEntity var7 = a.player;
      boolean var8 = this.dk;
      boolean var9 = false;
      if (var8) {
         this.ac();
         var9 = this.ae();
         if (var7 != null) {
            this.ag(var7);
         }
      }

      boolean var10 = false;
      if (this.eb) {
         var10 = var8 && this.dn == 2 && var7 != null && this.l(var7, var1);
         this.eb = false;
         this.ec = false;
      }

      boolean var11 = var10;
      if (!var10 && this.dw >= 0) {
         var11 = this.o();
      }

      if (!var8) {
         if (this.dw < 0) {
            this.ab();
         }
      } else {
         if (var7 != null) {
            if (this.em) {
               this.ah();
            }

            this.ai(var7, var1, var5);
         }

         if (this.dn == 0) {
            this.i(var1, var9);
         } else {
            this.j(var1, var11, var10, var9);
         }
      }
   }

   private void f_r76() {

      if (this.di) {
         if (System.nanoTime() - this.dj < 0L) {
            return;
         }
      } else if (this.fi || this.eh == 2 || !(a.currentScreen instanceof InventoryScreen)) {
         return;
      }

      this.di = false;
      ClientPlayerEntity var1 = a.player;
      if (this.dk && var1 != null && a.world != null && a.interactionManager != null) {
         long var2 = System.nanoTime();
         if (a.currentScreen == null) {
            if (this.dn == 0 && this.ej) {
               this.ag(var1);
               this.i(var2, false);
            }
         } else if (this.eh != 2 && !this.fp && a.currentScreen instanceof InventoryScreen) {
            this.ag(var1);
            this.aj(var1, var2, this.g(var2));
         }
      }
   }

   private long g(long var1) {

      long var3 = this.fn + 50000000L;
      return var3 - var1 > 0L ? var3 : var1;
   }

   private void h(long var1) {

      if (!this.di || var1 - this.dj < 0L) {
         this.dj = var1;
      }

      this.di = true;
   }

   private void i(long var1, boolean var3) {

      if (!var3) {
         if (!this.ej) {
            return;
         }

         if (this.du != 0L && var1 - this.du < 0L) {
            this.h(this.du);
            return;
         }

         if (!this.w(var1)) {
            this.h(LockD.f + this.eq);
            return;
         }
      }

      ClientPlayerEntity var4 = a.player;
      if (var4 != null && a.world != null && a.interactionManager != null && a.currentScreen == null && this.v(var4)) {
         this.dz = var3;
         int var5 = this.q(var4);
         if (var5 >= 0 && RotG.a(30, this)) {
            double var6 = this.co.p();
            var6 = var6 < 1.0 ? 1.0 : (var6 > 10.0 ? 10.0 : var6);
            this.dr = (float)(0.045 + (10.0 - var6) * 0.0125);
            this.dp = var4;
            this.dv = var5;
            this.dq = var4.getPitch();
            this.ds = var1;
            this.dt = var1;
            this._kwren_do = false;
            this.ea = 0;
            this.eb = false;
            this.dn = 1;
            LockD.b = var1 + 200000000L;
            LockD.e = this.dg;
         } else {
            this.dz = false;
         }
      }
   }

   private void j(long var1, boolean var3, boolean var4, boolean var5) {

      ClientPlayerEntity var6 = a.player;
      if (var6 != null && a.world != null && a.interactionManager != null && var6 == this.dp && a.currentScreen == null && var6.isAlive()) {
         if (var1 - this.dt > 100000000L) {
            this.p();
            if (this.dn == 0) {
               return;
            }
         }

         int var7 = this.dn;
         if (var7 == 2) {
            if (!var4) {
               if (var5 && this.ea < 2) {
                  this.eb = true;
                  this.ec = true;
               } else {
                  if (this.cr.f()) {
                     this.dn = 3;
                     this.ds = var1;
                     this.dz = false;
                  } else {
                     this.aa();
                  }
               }
            }
         } else {
            if (var7 == 3 && var5) {
               this.dz = true;
               int var8 = this.v(var6) ? this.q(var6) : -1;
               if (var8 >= 0) {
                  this.dv = var8;
                  this.dn = 1;
                  this.ds = var1;
                  this._kwren_do = false;
                  this.ea = 0;
                  return;
               }

               this.dz = false;
            }

            if (var1 - this.ds > 2000000000L) {
               this.z(var1);
            } else if (var7 == 1) {
               if (var5) {
                  this.dz = true;
               }

               if (!var6.getInventory().getStack(this.dv).isOf(Items.SPLASH_POTION)) {
                  int var9 = this.q(var6);
                  if (var9 < 0) {
                     this.z(var1);
                     return;
                  }

                  this.dv = var9;
               }

               if (this._kwren_do && !var3) {
                  this.k(var6, var1);
               }
            }
         }
      } else {
         this.z(var1);
      }
   }

   private void k(ClientPlayerEntity var1, long var2) {

      int var4 = (this.dz || this.w(var2)) && this.v(var1) ? this.q(var1) : -1;
      if (var4 < 0) {
         this.y(var2);
      } else {
         PlayerInventory var5 = var1.getInventory();
         if (InitExecutor.a(var5) != var4) {
            boolean var6 = FrameClockCache.l == var1.age || var1.handSwinging && var1.handSwingTicks < 0;
            if (var6 || InitExecutor.o == var1.age || InitExecutor.p == var1.age) {
               if (var6) {
                  FrameClockCache.j(var1);
               }

               return;
            }
         }

         ItemStack var9 = var5.getStack(var4);
         int var7 = this.ew[var4] == 1 ? u(var9) : -1;
         int var8 = this.ex[1];
         this.ea = 0;
         this.m(var1, var4, var2);
         if (var7 >= 0 && var8 >= 2 && this.dd.f()) {
            this.eb = this.n(var1, var7);
            this.ec = false;
         }
      }
   }

   private boolean l(ClientPlayerEntity var1, long var2) {

      boolean var4 = this.ec;
      if (var1 == this.dp && this.ea < 2 && a.world != null && a.interactionManager != null && a.currentScreen == null && var1.isAlive() && this.v(var1)) {
         int var5;
         if (var4) {
            this.dz = true;
            var5 = this.q(var1);
         } else {
            var5 = this.r(1);
         }

         if (var5 < 0) {
            return false;
         } else {
            PlayerInventory var6 = var1.getInventory();
            if (InitExecutor.a(var6) != var5) {
               boolean var7 = FrameClockCache.l == var1.age || var1.handSwinging && var1.handSwingTicks < 0;
               if (var7 || InitExecutor.o == var1.age || InitExecutor.p == var1.age) {
                  if (var7) {
                     FrameClockCache.j(var1);
                  }

                  return false;
               }
            }

            this.m(var1, var5, var2);
            return true;
         }
      } else {
         return false;
      }
   }

   private void m(ClientPlayerEntity var1, int var2, long var3) {

      PlayerInventory var5 = var1.getInventory();
      int var6 = InitExecutor.a(var5);
      int var7 = this.dw >= 0 && var6 == this.dx && var1 == this.dy ? this.dw : var6;
      this.du = var3 + this.x();
      if (var7 != var2) {
         this.dw = var7;
         this.dx = var2;
         this.dy = var1;
      } else {
         this.dw = -1;
         this.dx = -1;
         this.dy = null;
      }

      InitExecutor.a(var5, var2);
      ActionResult var8 = a.interactionManager.interactItem(var1, Hand.MAIN_HAND);
      InitExecutor.o = var1.age;
      if (var8 instanceof ActionResult.Success var9 && var9.swingSource() == ActionResult.SwingSource.CLIENT) {
         var1.swingHand(Hand.MAIN_HAND);
      }

      ((PacketBinder)a).sIUC(4);
      this.ea++;
      this._kwren_do = false;
      this.dn = 2;
   }

   private boolean n(ClientPlayerEntity var1, int var2) {

      float var3 = (float)(4 << (var2 > 6 ? 6 : var2));
      float var4 = var1.getHealth();
      float var5 = var1.getMaxHealth();
      float var6 = var5 - var4 - var3;
      return var6 >= var3 * 0.5F && var4 + var3 + var1.getAbsorptionAmount() < var5;
   }

   private boolean o() {

      ClientPlayerEntity var1 = a.player;
      ClientPlayerEntity var2 = this.dy;
      if (var1 == null || var1 != var2 || InitExecutor.a(var1.getInventory()) != this.dx) {
         this.dw = -1;
         this.dx = -1;
         this.dy = null;
         return false;
      } else if (a.currentScreen instanceof HandledScreen) {
         return true;
      } else {
         boolean var3 = FrameClockCache.l == var1.age || var1.handSwinging && var1.handSwingTicks < 0;
         if (!var3 && InitExecutor.o != var1.age && InitExecutor.p != var1.age) {
            int var4 = this.dw;
            this.dw = -1;
            this.dx = -1;
            this.dy = null;
            InitExecutor.a(var1.getInventory(), var4);
            return true;
         } else {
            if (var3) {
               FrameClockCache.j(var1);
            }

            return true;
         }
      }
   }

   private void p() {

      long var1 = System.nanoTime();
      float var3 = (float)((double)(var1 - this.dt) * 1.0E-9);
      this.dt = var1;
      int var4 = this.dn;
      ClientPlayerEntity var5 = a.player;
      if (var4 == 0 || !this.dk || var5 == null || var5 != this.dp || a.currentScreen != null || !var5.isAlive()) {
         this.z(var1);
      } else if (!RotG.a(30, this)) {
         this.z(var1);
      } else {
         var3 = var3 < 0.0F ? 0.0F : (var3 > 0.05F ? 0.05F : var3);
         float var6 = var4 == 3 ? this.dq : 89.0F;
         float var7 = var5.getPitch();
         double var8 = (double)(var1 - this.ds) / 8.0E7;
         var8 = var8 < 0.0 ? 0.0 : (var8 > 1.0 ? 1.0 : var8);
         var8 = var8 * var8 * (3.0 - 2.0 * var8);
         float var10 = (float)((1.0 - Math.pow(2.0, (double)(-var3 / this.dr))) * var8);
         float var11 = var7 + (var6 - var7) * var10;
         var11 = var11 < -90.0F ? -90.0F : (var11 > 90.0F ? 90.0F : var11);
         float var12 = Math.abs(var6 - var11);
         if (var4 == 3 && var12 <= 0.5F) {
            var5.setPitch(var6);
            var5.lastPitch = var6;
            this.aa();
         } else {
            var5.setPitch(var11);
            var5.lastPitch = var11;
            LockD.b = var1 + 200000000L;
            if (var4 == 1 && var12 <= 2.0F) {
               this._kwren_do = true;
            }
         }
      }
   }

   private int q(ClientPlayerEntity var1) {

      boolean var2 = this.dz;
      float var3 = var1.getHealth();
      boolean var4 = var2 ? var3 < var1.getMaxHealth() : this.ej && (double)var3 <= this.cm.p();
      if (var4) {
         int var5 = this.r(1);
         if (var5 >= 0) {
            return var5;
         }
      }

      if (var2 || this.ej && this.cp.f()) {
         if (!var1.hasStatusEffect(StatusEffects.STRENGTH)) {
            int var9 = this.r(2);
            if (var9 >= 0) {
               return var9;
            }
         }

         if (!var1.hasStatusEffect(StatusEffects.SPEED)) {
            int var10 = this.r(3);
            if (var10 >= 0) {
               return var10;
            }
         }

         PlayerInventory var11 = var1.getInventory();
         int[] var6 = this.ew;

         for (int var7 = 0; var7 < 9; var7++) {
            if (var6[var7] != 1) {
               ItemStack var8 = var11.getStack(var7);
               if (var8.isOf(Items.SPLASH_POTION) && s(var1, var8) == 2) {
                  return var7;
               }
            }
         }

         return -1;
      } else {
         return -1;
      }
   }

   private int r(int var1) {

      int var2 = this.er[var1];
      int[] var3 = this.ew;
      if (var2 >= 0 && var3[var2] == var1) {
         return var2;
      } else {
         for (int var4 = 0; var4 < 9; var4++) {
            if (var3[var4] == var1) {
               return var4;
            }
         }

         return -1;
      }
   }

   private static int s(ClientPlayerEntity var0, ItemStack var1) {

      PotionContentsComponent var2 = (PotionContentsComponent)var1.get(DataComponentTypes.POTION_CONTENTS);
      if (var2 == null) {
         return 0;
      } else {
         StatusEffect var3 = (StatusEffect)StatusEffects.INSTANT_HEALTH.value();
         StatusEffect var4 = (StatusEffect)StatusEffects.REGENERATION.value();
         boolean var5 = false;
         boolean var6 = false;
         boolean var7 = false;

         for (StatusEffectInstance var9 : var2.getEffects()) {
            RegistryEntry var10 = var9.getEffectType();
            StatusEffect var11 = (StatusEffect)var10.value();
            if (var11.getCategory() != StatusEffectCategory.BENEFICIAL) {
               return 0;
            }

            var5 = true;
            if (var11 == var3 || var11 == var4) {
               var6 = true;
            } else if (!var0.hasStatusEffect(var10)) {
               var7 = true;
            }
         }

         if (!var5) {
            return 0;
         } else if (var6) {
            return 1;
         } else {
            return var7 ? 2 : 0;
         }
      }
   }

   private static int t(ItemStack var0) {

      if (!var0.isOf(Items.SPLASH_POTION)) {
         return 0;
      } else {
         PotionContentsComponent var1 = (PotionContentsComponent)var0.get(DataComponentTypes.POTION_CONTENTS);
         if (var1 == null) {
            return 0;
         } else {
            StatusEffect var2 = (StatusEffect)StatusEffects.INSTANT_HEALTH.value();
            StatusEffect var3 = (StatusEffect)StatusEffects.REGENERATION.value();
            StatusEffect var4 = (StatusEffect)StatusEffects.STRENGTH.value();
            StatusEffect var5 = (StatusEffect)StatusEffects.SPEED.value();
            byte var6 = 0;

            for (StatusEffectInstance var8 : var1.getEffects()) {
               StatusEffect var9 = (StatusEffect)var8.getEffectType().value();
               if (var9.getCategory() != StatusEffectCategory.BENEFICIAL) {
                  return 0;
               }

               if (var9 == var2 || var9 == var3) {
                  var6 |= 1;
               } else if (var9 == var4) {
                  var6 |= 2;
               } else if (var9 == var5) {
                  var6 |= 4;
               }
            }

            if ((var6 & 1) != 0) {
               return 1;
            } else if ((var6 & 2) != 0) {
               return 2;
            } else {
               return (var6 & 4) != 0 ? 3 : 0;
            }
         }
      }
   }

   private static int u(ItemStack var0) {

      PotionContentsComponent var1 = (PotionContentsComponent)var0.get(DataComponentTypes.POTION_CONTENTS);
      if (var1 == null) {
         return -1;
      } else {
         StatusEffect var2 = (StatusEffect)StatusEffects.INSTANT_HEALTH.value();
         int var3 = -1;

         for (StatusEffectInstance var5 : var1.getEffects()) {
            if (var5.getEffectType().value() == var2 && var5.getAmplifier() > var3) {
               var3 = var5.getAmplifier();
            }
         }

         return var3;
      }
   }

   private boolean v(ClientPlayerEntity var1) {

      return var1.isAlive() && !var1.isSpectator() && !var1.isUsingItem() && !var1.isSleeping() && !var1.isRiding() && !a.interactionManager.isBreakingBlock();
   }

   private boolean w(long var1) {

      long var3 = LockD.f;
      return var3 == 0L || var1 - var3 >= this.eq;
   }

   private long x() {

      return this.cn.ns();
   }

   private void y(long var1) {
      byte var3 = 0;

      while (true) {
         switch (var3) {
            case 0:
            default:
               if (gd != 0) {
                  Thread.currentThread().getName().length();
                  var3 = 1;
                  break;
               }
            case 1:
               this.du = var1 + this.x();
               this._kwren_do = false;
               this.dz = false;
               this.eb = false;
               if (this.cr.f()) {
                  this.dn = 3;
                  this.ds = var1;
                  var3 = 3;
                  break;
               }
            case 2:
               this.aa();
               var3 = 3;
               break;
            case 3:
               return;
         }
      }
   }

   private void z(long var1) {

      if (this.dn == 1) {
         this.du = var1 + this.x();
      }

      this.aa();
   }

   private void aa() {

      LockD.e = null;
      LockD.b = 0L;
      RotG.b(this);
      this.dn = 0;
      this._kwren_do = false;
      this.dp = null;
      this.dz = false;
      this.eb = false;
      this.ec = false;
      this.h(System.nanoTime());
   }

   private void ab() {
      byte var1 = 0;

      while (true) {
         switch (var1) {
            case 0:
            default:
               if (gd != 0) {
                  new Object().hashCode();
                  var1 = 1;
                  break;
               }
            case 1:
               if (this.dl) {
                  this.dl = false;
                  this.b.b(InitNotifier.class, this);
                  var1 = 2;
                  break;
               }

               return;
            case 2:
               return;
         }
      }
   }

   private void ac() {

      String var1 = this.db.f();
      if (var1 != this.ed) {
         this.ed = var1;
         this.eg = ad(var1, br);
      }

      var1 = this.cv.f();
      if (var1 != this.ee) {
         this.ee = var1;
         this.eh = ad(var1, bn);
      }

      var1 = this.df.f();
      if (var1 != this.ef) {
         this.ef = var1;
         this.ei = ad(var1, bu);
      }

      int var2 = this.eg;
      this.ej = var2 != 1;
      this.ek = var2 != 0;
      this.el = this.dc.g();
      this.em = this.de.f();
      this.en = this.cz.f();
      this.eo = this.da.p();
      this.ep = this.cw.ns();
      this.eq = this.cq.ns();
      int var3 = (int)Math.round(this.cs.p());
      int var4 = (int)Math.round(this.ct.p());
      int var5 = (int)Math.round(this.cu.p());
      int[] var6 = this.er;
      var6[1] = var3 >= 1 && var3 <= 9 ? var3 - 1 : -1;
      var6[2] = var4 >= 1 && var4 <= 9 && var4 != var3 ? var4 - 1 : -1;
      var6[3] = var5 >= 1 && var5 <= 9 && var5 != var3 && var5 != var4 ? var5 - 1 : -1;
   }

   private static int ad(String var0, String[] var1) {

      for (int var2 = 0; var2 < var1.length; var2++) {
         if (var1[var2].equals(var0)) {
            return var2;
         }
      }

      return 0;
   }

   private boolean ae() {

      boolean var1 = this.et;
      this.et = false;
      int var2 = this.el;
      if (this.ek && var2 >= 0) {
         boolean var3 = SlotInspector.a(var2);
         if (var3 && !this.es) {
            var1 = true;
         }

         this.es = var3;
         return var1 && a.currentScreen == null;
      } else {
         this.es = false;
         return false;
      }
   }

   private void af() {
      int var1 = 0;
      boolean var2 = false;
      byte var3 = 0;

      label26:
      while (true) {
         switch (var3) {
            case 0:
            default:
               if (gd != 0) {
                  Math.abs(Integer.MIN_VALUE);
                  var3 = 1;
                  break;
               }
            case 1:
               var1 = this.el;
               if (var1 < 0) {
                  return;
               }
            case 2:
               var2 = SlotInspector.a(var1);
               if (var2 && !this.es && a.currentScreen == null) {
                  this.et = true;
                  var3 = 3;
                  break;
               }
            case 3:
               break label26;
         }
      }

      this.es = var2;
   }

   private void ag(ClientPlayerEntity var1) {

      PlayerInventory var2 = var1.getInventory();
      ItemStack[] var3 = this.eu;
      int[] var4 = this.ev;
      int[] var5 = this.ew;
      int[] var6 = this.ex;
      int[] var7 = this.ey;
      int[] var8 = this.ez;

      for (int var9 = 1; var9 < 4; var9++) {
         var6[var9] = 0;
         var7[var9] = 0;
         var8[var9] = 0;
      }

      for (int var12 = 0; var12 < 36; var12++) {
         ItemStack var10 = var2.getStack(var12);
         if (var10 != var3[var12]) {
            var3[var12] = var10;
            var4[var12] = t(var10);
         }

         int var11 = var4[var12];
         if (var11 != 0 && var10.isEmpty()) {
            var11 = 0;
         }

         var5[var12] = var11;
         if (var11 != 0) {
            if (var12 < 9) {
               var6[var11] += var10.getCount();
               var8[var11] |= 1 << var12;
            } else {
               var7[var11] += var10.getCount();
            }
         }
      }
   }

   private void ah() {

      ItemStack[] var1 = this.fa;
      if (var1[1] == null) {
         var1[1] = PotionContentsComponent.createStack(Items.SPLASH_POTION, Potions.HEALING);
         var1[2] = PotionContentsComponent.createStack(Items.SPLASH_POTION, Potions.STRENGTH);
         var1[3] = PotionContentsComponent.createStack(Items.SPLASH_POTION, Potions.SWIFTNESS);
      }

      for (int var2 = 1; var2 < 4; var2++) {
         int var3 = this.ex[var2] > 99 ? 99 : this.ex[var2];
         int var4 = this.ey[var2] > 99 ? 99 : this.ey[var2];
         int var5 = var3 * 100 + var4;
         if (var5 != this.fc[var2]) {
            this.fc[var2] = var5;
            StringBuilder var6 = this.fd;
            var6.setLength(0);
            var6.append(ca[var3]).append(bz[0]).append(ca[var4]);
            this.fb[var2] = var6.toString();
            this.fe = true;
         }
      }
   }

   private void ai(ClientPlayerEntity var1, long var2, long var4) {

      int var6 = this.eh;
      if (var6 == 2 || a.interactionManager == null || !(a.currentScreen instanceof InventoryScreen)) {
         this.fi = false;
         if (this.fp) {
            this.at();
         }
      } else if (this.fp) {
         if (++this.fx > 40) {
            this.as();
         }
      } else {
         this.aj(var1, var2, var4);
      }
   }

   private void aj(ClientPlayerEntity var1, long var2, long var4) {

      if (!this.fi) {
         this.fi = true;
         this.fj = var4 + this.ep - 50000000L;
         this.fk = false;
      }

      if (var2 - this.fj < 0L) {
         this.h(this.fj);
      } else {
         this.fl = !this.fk;
         this.fk = true;
         this.fm = var4 - var2 <= 0L ? var4 : var2;
         if (var1.currentScreenHandler.getCursorStack().isEmpty() && !LockD.a) {
            InventoryScreen var6 = (InventoryScreen)a.currentScreen;
            int var7 = this.eh;
            if (var7 == 0) {
               this.am(var6);
            } else if (var7 == 1) {
               this.an(var6, var1);
            }
         }
      }
   }

   private void ak() {

      long var1 = this.ep;
      long var3 = System.nanoTime();
      long var5 = this.fj + var1;
      this.fj = this.fl && var5 - var3 > 0L ? var5 : this.fm + var1;
      this.fk = false;
      this.h(this.fj);
   }

   private void al() {

      this.fj = this.g(System.nanoTime()) + this.ep - 50000000L;
      this.fk = false;
      this.h(this.fj);
   }

   private void am(InventoryScreen var1) {

      int[] var2 = this.ew;

      for (int var3 = 1; var3 < 4; var3++) {
         int var4 = this.er[var3];
         if (var4 >= 0 && var2[var4] != var3) {
            for (int var5 = 9; var5 < 36; var5++) {
               if (var2[var5] == var3) {
                  this.ap(var1, var5, var4, var3);
                  return;
               }
            }
         }
      }
   }

   private void an(InventoryScreen var1, ClientPlayerEntity var2) {

      Slot var3 = ao(var1);
      if (var3 != null && var3.inventory == var2.getInventory()) {
         int var4 = var3.getIndex();
         if (var4 >= 9 && var4 <= 35) {
            int var5 = this.ew[var4];
            if (var5 != 0) {
               int var6 = this.er[var5];
               if (var6 >= 0 && this.ew[var6] != var5) {
                  this.aq(((PlayerScreenHandler)var1.getScreenHandler()).syncId, var3.id, var6);
                  this.ak();
               }
            }
         }
      }
   }

   private static Slot ao(HandledScreen<?> var0) {

      try {
         return ((BindingAccessor)var0).Z8();
      } catch (Throwable var2) {
         return null;
      }
   }

   private void ap(InventoryScreen var1, int var2, int var3, int var4) {
      int var5 = 0;
      byte var6 = 0;

      while (true) {
         switch (var6) {
            case 0:
            default:
               if (gd != 0) {
                  Math.abs(Integer.MIN_VALUE);
                  var6 = 1;
                  break;
               }
            case 1:
               var5 = ((PlayerScreenHandler)var1.getScreenHandler()).syncId;
               if (this.en) {
                  if (!this.au()) {
                     var6 = 2;
                  } else {
                     var6 = 3;
                  }
                  break;
               }
            case 2:
               this.aq(var5, var2, var3);
               this.ak();
               return;
            case 3:
               this.fs = var2;
               this.ft = var3;
               this.fu = var4;
               this.fv = var5;
               this.fw = 0;
               this.fx = 0;
               this.fy = System.nanoTime();
               this.fp = true;
               return;
         }
      }
   }

   private void aq(int var1, int var2, int var3) {

      a.interactionManager.clickSlot(var1, var2, var3, SlotActionType.SWAP, a.player);
   }

   private void ar() {

      if (a.player != null && a.currentScreen instanceof InventoryScreen var1) {
         ScreenHandler var16 = var1.getScreenHandler();
         if (var16.syncId == this.fv && this.fs >= 0 && this.fs < var16.slots.size()) {
            Slot var3 = (Slot)var16.slots.get(this.fs);
            double var4 = (double)(((GridAccessor)var1).getX() + var3.x + 8);
            double var6 = (double)(((GridAccessor)var1).getY() + var3.y + 8);
            long var8 = System.nanoTime();
            double var10 = (double)(var8 - this.fy) * 1.0E-9;
            this.fy = var8;
            var10 = var10 < 0.0 ? 0.0 : (var10 > 0.1 ? 0.1 : var10);
            double var12 = this.eo / 20.0;
            var12 = var12 < 0.05 ? 0.05 : (var12 > 1.0 ? 1.0 : var12);
            double var14 = var12 >= 1.0 ? 1.0 : 1.0 - Math.pow(1.0 - var12, var10 * 60.0);
            this.fz = this.fz + (var4 - this.fz) * var14;
            this.ga = this.ga + (var6 - this.ga) * var14;
            this.av(this.fz, this.ga);
            if (Math.hypot(var4 - this.fz, var6 - this.ga) < 1.0 || ++this.fw > (1530874088 ^ 1530874240)) {
               this.as();
            }
         } else {
            this.at();
         }
      } else {
         this.at();
      }
   }

   private void as() {

      int var1 = this.fs;
      int var2 = this.ft;
      int var3 = this.fu;
      int var4 = this.fv;
      this.at();
      this.al();
      ClientPlayerEntity var5 = a.player;
      if (var1 >= 0
         && var5 != null
         && a.interactionManager != null
         && a.currentScreen instanceof InventoryScreen
         && var5.currentScreenHandler.syncId == var4
         && var5.currentScreenHandler.getCursorStack().isEmpty()) {
         PlayerInventory var6 = var5.getInventory();
         ItemStack var7 = var6.getStack(var1);
         if (!var7.isEmpty() && t(var7) == var3) {
            ItemStack var8 = var6.getStack(var2);
            if (var8.isEmpty() || t(var8) != var3) {
               this.aq(var4, var1, var2);
            }
         }
      }
   }

   private void at() {

      this.fp = false;
      this.fs = -1;
      this.fw = 0;
      this.fx = 0;
      if (this.fq) {
         this.fq = false;
         LockD.a = false;
      }
   }

   private boolean au() {

      Window var1 = a.getWindow();
      if (var1 == null) {
         return false;
      } else {
         long var2 = var1.getHandle();
         int var4 = var1.getWidth();
         int var5 = var1.getHeight();
         int var6 = var1.getScaledWidth();
         int var7 = var1.getScaledHeight();
         if (var2 != 0L && var4 > 0 && var5 > 0 && var6 > 0 && var7 > 0) {
            GLFW.glfwGetCursorPos(var2, this.gb, this.gc);
            double var8 = this.gb[0] * (double)var6 / (double)var4;
            double var10 = this.gc[0] * (double)var7 / (double)var5;
            if (Double.isFinite(var8) && Double.isFinite(var10)) {
               this.fz = var8;
               this.ga = var10;
               return true;
            } else {
               return false;
            }
         } else {
            return false;
         }
      }
   }

   private void av(double var1, double var3) {

      Window var5 = a.getWindow();
      if (var5 != null) {
         long var6 = var5.getHandle();
         int var8 = var5.getWidth();
         int var9 = var5.getHeight();
         int var10 = var5.getScaledWidth();
         int var11 = var5.getScaledHeight();
         if (var6 != 0L && var8 > 0 && var9 > 0 && var10 > 0 && var11 > 0) {
            if (GLFW.glfwGetCurrentContext() == var6 && GLFW.glfwGetWindowAttrib(var6, 631409366 ^ 631278295) == 1) {
               double var12 = var1 * (double)var8 / (double)var10;
               double var14 = var3 * (double)var9 / (double)var11;
               if (Double.isFinite(var12) && Double.isFinite(var14)) {
                  this.fq = true;
                  LockD.a = true;
                  GLFW.glfwSetCursorPos(var6, var12, var14);
               }
            }
         }
      }
   }

   private void aw(DrawContext var1) {

      if (a.player != null && !a.options.hudHidden && this.fa[1] != null) {
         if (a.currentScreen == null || a.currentScreen instanceof ChatScreen) {
            if (!a.debugHudEntryList.isF3Enabled()) {
               Window var2 = a.getWindow();
               int var3 = StyleKeyCache.MAG;
               int var4 = var2.getScaleFactor();
               float var5 = (float)var3 / (float)(var4 <= 0 ? 1 : var4);
               float var6 = (float)var2.getScaledWidth() / var5;
               float var7 = (float)var2.getScaledHeight() / var5;
               if (this.fe || this.ff != StyleKeyCache.ba) {
                  this.ax();
               }

               float var8 = 19.0F + this.fg + 6.0F + this.fh + 7.0F + 57.0F + 6.0F;
               float var9 = 42.0F;
               int var10 = this.ei;
               float var11;
               float var12;
               if (var10 == 1) {
                  var11 = 4.0F;
                  var12 = (var7 - var9) * 0.5F;
               } else if (var10 == 2) {
                  var11 = var6 - var8 - 4.0F;
                  var12 = (var7 - var9) * 0.5F;
               } else if (var10 == 3) {
                  var11 = 4.0F;
                  var12 = 4.0F;
               } else {
                  var11 = (var6 - var8) * 0.5F;
                  var12 = ((float)var2.getScaledHeight() - 75.0F - CoreZoneProcessor.ACTION_LIFT) / var5 - var9;
               }

               var12 = var12 < 4.0F ? 4.0F : var12;
               var11 = (float)Math.round(var11 * (float)var3) / (float)var3;
               var12 = (float)Math.round(var12 * (float)var3) / (float)var3;
               var1.createNewRootLayer();
               Matrix3x2fStack var13 = var1.getMatrices();
               var13.pushMatrix();

               try {
                  var13.scale(var5, var5);
                  this.ay(var1, var13, var11, var12, var8, var9, var3);
               } finally {
                  var13.popMatrix();
               }
            }
         }
      }
   }

   private void ax() {

      float var1 = 0.0F;

      for (int var2 = 0; var2 < by.length; var2++) {
         var1 = Math.max(var1, StyleKeyCache.f(2, by[var2]));
      }

      float var5 = 0.0F;

      for (int var3 = 1; var3 < 4; var3++) {
         String var4 = this.fb[var3];
         if (var4 != null) {
            var5 = Math.max(var5, StyleKeyCache.f(2, var4));
         }
      }

      this.fg = var1;
      this.fh = var5;
      this.ff = StyleKeyCache.ba;
      this.fe = false;
   }

   private void ay(DrawContext var1, Matrix3x2fStack var2, float var3, float var4, float var5, float var6, int var7) {

      StyleKeyCache.r(var1, var3, var4, var5, var6, 6.0F, StyleKeyCache.PANEL);
      float var8 = (float)var7;
      float var9 = var3 + 6.0F + 9.0F + 4.0F;
      float var10 = var9 + this.fg + 6.0F;
      float var11 = var10 + this.fh + 7.0F;
      int var12 = Math.max(1, Math.round(5.0F * (float)var7));
      int var13 = Math.max(1, Math.round((float)var7 * 0.5F));

      for (int var14 = 1; var14 < 4; var14++) {
         float var15 = var4 + 5.0F + 11.0F * (float)(var14 - 1) + 5.5F;
         var2.pushMatrix();

         try {
            var2.translate((float)Math.round((var3 + 6.0F) * (float)var7) / var8, (float)Math.round((var15 - 4.5F) * (float)var7) / var8);
            var2.scale(0.5625F, 0.5625F);
            var1.drawItem(this.fa[var14], 0, 0);
         } finally {
            var2.popMatrix();
         }

         float var16 = var15 + 3.0F;
         int var17 = this.ex[var14] + this.ey[var14];
         StyleKeyCache.l(var1, 2, by[var14 - 1], var9, var16, 273237489 ^ -274820563, false);
         StyleKeyCache.l(var1, 2, this.fb[var14], var10, var16, var17 == 0 ? -1474009249 ^ 1473992559 : 1166740652 ^ -1166083749, false);
         int var18 = this.ez[var14];
         int var19 = this.er[var14];
         int var20 = cj[var14];
         int var21 = -814490022 ^ 1332993626 | var20 & (935235804 ^ 927035171);
         int var22 = Math.round((var15 - 2.5F) * (float)var7);
         var2.pushMatrix();

         try {
            var2.scale(1.0F / (float)var7, 1.0F / (float)var7);

            for (int var23 = 0; var23 < 9; var23++) {
               int var24 = Math.round((var11 + (float)var23 * 6.5F) * (float)var7);
               boolean var25 = (var18 >> var23 & 1) != 0;
               var1.fill(var24, var22, var24 + var12, var22 + var12, var25 ? (var23 == var19 ? var20 : var21) : 1073670732 ^ 620828083);
               if (var23 == var19) {
                  int var26 = var25 ? -947509230 ^ 561241573 : 318998523 ^ -318982197;
                  var1.fill(var24 - var13, var22 - var13, var24 + var12 + var13, var22, var26);
                  var1.fill(var24 - var13, var22 + var12, var24 + var12 + var13, var22 + var12 + var13, var26);
                  var1.fill(var24 - var13, var22, var24, var22 + var12, var26);
                  var1.fill(var24 + var12, var22, var24 + var12 + var13, var22 + var12, var26);
               }
            }
         } finally {
            var2.popMatrix();
         }
      }
   }

   static {
      for (int var0 = 0; var0 < ca.length; var0++) {
         ca[var0] = Integer.toString(var0);
      }

      cj = new int[]{0, -1031846, -670440, -10827526};
   }
}
