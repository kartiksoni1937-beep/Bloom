package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import net.caffeinemc.mods.lithium.lattice.bundle.overlay.element.GridAccessor;
import net.caffeinemc.mods.lithium.lattice.bundle.overlay.element.PacketBinder;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.InitNotifier;
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
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import org.lwjgl.glfw.GLFW;
import net.minecraft.entity.Entity;
public final class ProcessZoneResolver extends BuilderFactory implements InitNotifier, UtilExtension {
   private final SlotEntry t;
   private final TimingEntry u;
   private final CheckerBridge v;
   private final BlockCalculator w;
   private final CheckerBridge x;
   private final CheckerBridge y;
   private final CheckerBridge z;
   private final TimingEntry aa;
   private final CheckerBridge ab;
   private final BlockCalculator ac;
   private final TimingEntry ad;
   private final TimingEntry ae;
   private static final int af = 40;
   private static final int ag = 360;
   private static final int ah = 40;
   private static final String[] ai = new String[]{"Random"};
   private static final long aj = 50000000L;
   private long ak;
   private boolean al;
   private long am;
   private long an;
   private boolean ao;
   private long ap;
   private boolean aq;
   private long ar;
   private final Runnable as;
   private boolean at;
   private long au;
   private boolean av;
   private int aw;
   private int ax;
   private int ay;
   private int az;
   private int ba;
   private double bb;
   private double bc;
   private boolean bd;
   private final int[] be;
   private static int bf = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   public ProcessZoneResolver() {
      super("", "", ParserEngine.CT);
      this.setName(
         new char[]{'鏰', '鏾', '鎚', '鑺', '鑂', '鑬', '鐢', '铤', '铟', '钭', '钉', '镲', '镊', '锶', '锚', '関', '闵', '閯', '閫', '閛', '陰'},
         -1408789583,
         new char[]{
            '籇',
            '簇',
            '簧',
            '簑',
            '糣',
            '糖',
            '糤',
            '粂',
            '索',
            '絕',
            '累',
            '紫',
            '紛',
            '緰',
            '綜',
            '綯',
            '綕',
            '縹',
            '繁',
            '縸',
            '縃',
            '继',
            '纔',
            '纼',
            '纔',
            '罷',
            '罘',
            '缮',
            '缀',
            '翩',
            '羀',
            '翫',
            '羞',
            '聡',
            '聍',
            '耩',
            '聆',
            '胼',
            '胋',
            '肶',
            '肐',
            '脡',
            '腈',
            '腐',
            '脪',
            '脟',
            '臽',
            '臉',
            '臶',
            '臙',
            '良',
            '艟',
            '舿',
            '舙',
            '英',
            '芓',
            '芫',
            '芞',
            '荥',
            '荝',
            '荮',
            '茄',
            '菢',
            '菝',
            '莯',
            '莇',
            '葼',
            '葈',
            '萴',
            '萜',
            '蒤',
            '蓊',
            '蒱',
            '蓁',
            '蕯',
            '蕯',
            '蕛',
            '蔳'
         },
         -1918731254
      );
      this.t = new SlotEntry("M.ode", "Instant", "Instant", "Random");
      TimingEntry var10001 = new TimingEntry("", 0.0, 1000.0, 0.0, 1.0);
      var10001.n(new char[]{'裌', '袉', '袣', '袉', '襥', '襚'}, -931493752);
      this.u = var10001;
      CheckerBridge var1 = new CheckerBridge("", true);
      var1.n(new char[]{'﹗', '︐', '︲', '︈', 'ﻹ', 'ﻛ', 'ﺫ'}, 169279007);
      this.v = var1;
      BlockCalculator var2 = new BlockCalculator("", 1.0, 9.0, 1.0, 1.0);
      var2.n(new char[]{'是', '暴', '曖', '暬', '暒', '杻', '朕', '朇', '期', '柽', '柅'}, -1938659717);
      this.w = var2;
      CheckerBridge var3 = new CheckerBridge("", false);
      var3.n(new char[]{'薁', '藱', '薋', '虩', '虓', '虻', '蘩', '蛮', '蛑', '蚣', '蚕', '蝽'}, -682654272);
      this.x = var3;
      CheckerBridge var4 = new CheckerBridge("", false);
      var4.n(new char[]{'\uf7d3', '\uf79a', '\uf7bc', '\uf780', '\uf872', '\uf855', '\uf86f', '\uf83a', '\uf8e2', '\uf8d8', '\uf8ae', '\uf887'}, -1672939627);
      this.y = var4;
      CheckerBridge var5 = new CheckerBridge("", false);
      var5.n(new char[]{'᭳', '\u1b7f', 'ᬅ', '\u1bfb', 'ᯁ', 'ᯭ', 'ᮣ', 'ᱻ', 'ᱏ', 'ᰧ'}, 1630673714);
      this.z = var5;
      var10001 = new TimingEntry("", 0.0, 1000.0, 0.0, 1.0);
      var10001.n(new char[]{'Ἠ', 'ᾴ', '῍', 'Ᾱ', 'ᾎ', '‶', '⁺', '․', '‖', '\u20fc', 'ₑ', 'ₖ', '₀', 'ⅼ'}, -1006952581);
      this.aa = var10001;
      CheckerBridge var7 = new CheckerBridge("", false);
      var7.n(new char[]{'쬞', '쭒', '쯮', '쯈', '쮪', '쮗', '챥', '찖', '찘', '찛', '쳥', '쳗'}, -976630947);
      this.ab = var7;
      BlockCalculator var8 = new BlockCalculator("", 1.0, 20.0, 8.0, 1.0);
      var8.n(
         new char[]{'\ue092', '\ue0de', '\ue17a', '\ue15c', '\ue13e', '\ue103', '\ue1f9', '\ue18a', '\ue19a', '\ue198', '\ue262', '\ue243', '\ue221'},
         -1556946735
      );
      this.ac = var8;
      var10001 = new TimingEntry("", 0.0, 500.0, 100.0, 1.0);
      var10001.n(new char[]{'桸', '桡', '栁', '棹', '棎', '梪', '梘', '椩', '楬', '椢', '椊', '槤', '槝', '槣', '榯', '橨', '橎'}, -2106562512);
      this.ad = var10001;
      var10001 = new TimingEntry("", 0.0, 500.0, 200.0, 1.0);
      var10001.n(new char[]{'糙', '粞', '粠', '粚', '絯', '絍', '紹', '絊', '緍', '緍', '綫', '綇', '繼', '縄', '縎', '縃', '绹'}, 228949137);
      this.ae = var10001;
      this.as = this::b;
      this.aw = -1;
      this.be = new int[27];
      this.a(new InitAdapter[]{this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.aa, this.ab, this.ac, this.ad, this.ae});
   }

   @Override
   public void c() {

      this.b.a(InitNotifier.class, this);
      this.ak = System.nanoTime() - 100000000L;
      this.al = false;
      this.ao = false;
      this.aq = false;
      this.at = false;
      this.p();
      FrameClockCache.add(this.as);
      super.c();
   }

   @Override
   public void d() {

      this.b.b(InitNotifier.class, this);
      this.b.b(UtilExtension.class, this);
      FrameClockCache.b(this.as);
      this.at = false;
      this.p();
      super.d();
   }

   @Override
   public void a() {

      long var1 = System.nanoTime();
      long var3 = this.ak + 50000000L;
      long var5 = var1 - var3 >= 0L && var1 - var3 <= 50000000L ? var3 : var1;
      this.ak = var5;
      if (a.player != null && a.world != null && a.interactionManager != null) {
         if (this.z.f() && a.currentScreen == null && this.n_r108()) {
            a.setScreen(new SlotZoneView(a.player));
            this.d(var5);
         }

         if (!(a.currentScreen instanceof InventoryScreen)) {
            this.al = false;
            this.ao = false;
            this.aq = false;
            this.at = false;
            this.p();
         } else if (this.av) {
            if (++this.ba > 40) {
               this.j_r37();
            }
         } else {
            this.g(var1, var5);
         }
      } else {
         this.p();
      }
   }

   private void b() {

      if (this.at) {
         if (System.nanoTime() - this.au < 0L || this.av) {
            return;
         }
      } else if (this.al || this.av || !(a.currentScreen instanceof InventoryScreen)) {
         return;
      }

      this.at = false;
      if (a.player != null && a.world != null && a.interactionManager != null && a.currentScreen instanceof InventoryScreen) {
         long var1 = System.nanoTime();
         this.g(var1, this.c(var1));
      }
   }

   private long c(long var1) {

      long var3 = this.ak + 50000000L;
      return var3 - var1 > 0L ? var3 : var1;
   }

   private void d(long var1) {

      this.al = true;
      this.am = var1 + this.u.ns() - 50000000L;
      this.an = this.aa.ns();
      this.ao = false;
   }

   private void e(long var1) {

      if (this.ao) {
         long var3 = this.ap - var1;
         this.an = var3 > 0L ? var3 : 0L;
         this.ao = false;
      }
   }

   private void f(long var1) {
      byte var3 = 0;

      label20:
      while (true) {
         switch (var3) {
            case 0:
            default:
               if (bf != 0) {
                  Thread.currentThread().getName().length();
                  var3 = 1;
                  break;
               }
            case 1:
               if (this.at) {
                  if (var1 - this.au >= 0L) {
                     break label20;
                  }

                  var3 = 2;
                  break;
               }
            case 2:
               this.au = var1;
               var3 = 3;
               break;
            case 3:
               break label20;
         }
      }

      this.at = true;
   }

   private void g(long var1, long var3) {

      if (!this.al) {
         this.d(var3);
      }

      PlayerInventory var5 = a.player.getInventory();
      boolean var6 = true;
      if (this.x.f()) {
         int var7 = this.w.g() - 1;
         if (FrameClockCache.i(a.player)) {
            InitExecutor.a(var5, var7);
         }

         var6 = InitExecutor.a(var5) == var7;
      }

      if (var1 - this.am < 0L) {
         this.f(this.am);
      } else {
         long var11 = var3 - var1 <= 0L ? var3 : var1;
         if (!a.player.getOffHandStack().isOf(Items.TOTEM_OF_UNDYING)) {
            int var9 = this.l(var5);
            if (var9 != -1) {
               this.e(var3);
               this.i(var9, 40, var11);
               return;
            }
         }

         if (this.v.f() && var6) {
            ItemStack var12 = a.player.getMainHandStack();
            if (var12.isEmpty() || this.y.f() && !var12.isOf(Items.TOTEM_OF_UNDYING)) {
               if (this.aq) {
                  if (var1 - this.ar < 0L) {
                     this.e(var3);
                     this.f(this.ar);
                     return;
                  }

                  this.aq = false;
               }

               int var10 = this.l(var5);
               if (var10 != -1) {
                  this.e(var3);
                  this.i(var10, InitExecutor.a(var5), var11);
                  return;
               }
            }
         }

         if (this.z.f() && this.o()) {
            if (!this.ao) {
               this.ao = true;
               this.ap = var3 + this.an;
            }

            if (var1 - this.ap < 0L) {
               this.f(this.ap);
               return;
            }

            this.ao = false;
            this.an = this.aa.ns();
            a.currentScreen.close();
         } else {
            this.e(var3);
         }
      }
   }

   @Override
   public void a(DrawContext var1) {

      if (this.av) {
         try {
            this.h_r36();
         } catch (Throwable var3) {
            this.p();
         }
      }
   }

   private void h_r36() {

      if (a.player != null && a.currentScreen instanceof HandledScreen var1) {
         ScreenHandler var10 = var1.getScreenHandler();
         if (this.aw < 0 || this.aw >= var10.slots.size()) {
            this.p();
         } else if (this.ax != 40 && !a.player.getOffHandStack().isOf(Items.TOTEM_OF_UNDYING)) {
            this.p();
         } else {
            Slot var3 = (Slot)var10.slots.get(this.aw);
            double var4 = (double)(((GridAccessor)var1).getX() + var3.x + 8);
            double var6 = (double)(((GridAccessor)var1).getY() + var3.y + 8);
            double var8 = Math.max(0.05, Math.min(1.0, (double)this.ac.g() / 20.0));
            this.bb = this.bb + (var4 - this.bb) * var8;
            this.bc = this.bc + (var6 - this.bc) * var8;
            this.q(this.bb, this.bc);
            if (Math.hypot(var4 - this.bb, var6 - this.bc) < 1.0 || ++this.az > (1298222956 ^ 1298222596)) {
               this.j_r37();
            }
         }
      } else {
         this.p();
      }
   }

   private void i(int var1, int var2, long var3) {

      if (a.currentScreen instanceof HandledScreen var5) {
         int var11 = var5.getScreenHandler().syncId;
         if (!this.ab.f()) {
            this.k(var11, var1, var2, var3);
         } else {
            double var7 = this.r();
            double var9 = this.s();
            if (!Double.isNaN(var7) && !Double.isNaN(var9)) {
               this.aw = var1;
               this.ax = var2;
               this.ay = var11;
               this.bb = var7;
               this.bc = var9;
               this.az = 0;
               this.ba = 0;
               this.av = true;
               if (!this.bd) {
                  this.b.a(UtilExtension.class, this);
                  this.bd = true;
               }
            } else {
               this.k(var11, var1, var2, var3);
            }
         }
      }
   }

   private void j_r37() {

      int var1 = this.aw;
      int var2 = this.ax;
      int var3 = this.ay;
      this.p();
      if (var1 >= 0 && a.player != null && a.interactionManager != null && a.currentScreen instanceof HandledScreen) {
         this.k(var3, var1, var2, this.c(System.nanoTime()) - 50000000L);
      }
   }

   private void k(int var1, int var2, int var3, long var4) {

      a.interactionManager.clickSlot(var1, var2, var3, SlotActionType.SWAP, a.player);
      if (var3 == 40) {
         long var6 = this.ad.ns();
         long var8 = Math.max(var6, this.ae.ns());
         long var10 = var8 > var6 ? var6 + ThreadLocalRandom.current().nextLong(var8 - var6 + 1L) : var6;
         this.ar = var4 + var10;
         this.aq = true;
         this.f(this.ar);
      }
   }

   private int l(PlayerInventory var1) {

      boolean var2 = this.t.b(ai[0]);
      int var3 = 0;

      for (int var4 = 9; var4 < 36; var4++) {
         if (var1.getStack(var4).isOf(Items.TOTEM_OF_UNDYING)) {
            if (!var2) {
               return var4;
            }

            this.be[var3++] = var4;
         }
      }

      return var3 == 0 ? -1 : this.be[ThreadLocalRandom.current().nextInt(var3)];
   }

   private boolean m_r107() {

      PlayerInventory var1 = a.player.getInventory();

      for (int var2 = 9; var2 < 36; var2++) {
         if (var1.getStack(var2).isOf(Items.TOTEM_OF_UNDYING)) {
            return true;
         }
      }

      return false;
   }

   private boolean n_r108() {

      PlayerInventory var1 = a.player.getInventory();
      boolean var2 = !a.player.getOffHandStack().isOf(Items.TOTEM_OF_UNDYING);
      if (!var2 && this.v.f()) {
         ItemStack var3 = var1.getStack(this.x.f() ? this.w.g() - 1 : InitExecutor.a(var1));
         var2 = var3.isEmpty() || this.y.f() && !var3.isOf(Items.TOTEM_OF_UNDYING);
      }

      return var2 && this.m_r107();
   }

   private boolean o() {

      return a.currentScreen instanceof SlotZoneView && !this.n_r108();
   }

   private void p() {
      byte var1 = 0;

      while (true) {
         switch (var1) {
            case 0:
            default:
               if (bf != 0) {
                  Math.abs(Integer.MIN_VALUE);
                  var1 = 1;
                  break;
               }
            case 1:
               this.av = false;
               this.aw = -1;
               this.az = 0;
               this.ba = 0;
               LockD.a = false;
               if (this.bd) {
                  this.b.b(UtilExtension.class, this);
                  this.bd = false;
                  var1 = 2;
                  break;
               }

               return;
            case 2:
               return;
         }
      }
   }

   private void q(double var1, double var3) {

      if (a != null && a.getWindow() != null) {
         long var5 = a.getWindow().getHandle();
         int var7 = a.getWindow().getWidth();
         int var8 = a.getWindow().getHeight();
         int var9 = a.getWindow().getScaledWidth();
         int var10 = a.getWindow().getScaledHeight();
         if (var5 != 0L && var7 > 0 && var8 > 0 && var9 > 0 && var10 > 0) {
            if (GLFW.glfwGetCurrentContext() == var5 && GLFW.glfwGetWindowAttrib(var5, -2144683193 ^ -2144814266) == 1) {
               double var11 = var1 * (double)var7 / (double)var9;
               double var13 = var3 * (double)var8 / (double)var10;
               if (Double.isFinite(var11) && Double.isFinite(var13)) {
                  LockD.a = true;
                  if (Math.abs(((PacketBinder)a).Z7().getX() - var11) >= 0.25 || Math.abs(((PacketBinder)a).Z7().getY() - var13) >= 0.25) {
                     GLFW.glfwSetCursorPos(var5, var11, var13);
                  }
               }
            }
         }
      }
   }

   private double r() {

      if (a != null && a.getWindow() != null) {
         int var1 = a.getWindow().getWidth();
         int var2 = a.getWindow().getScaledWidth();
         return var1 > 0 && var2 > 0 ? ((PacketBinder)a).Z7().getX() * (double)var2 / (double)var1 : Double.NaN;
      } else {
         return Double.NaN;
      }
   }

   private double s() {

      if (a != null && a.getWindow() != null) {
         int var1 = a.getWindow().getHeight();
         int var2 = a.getWindow().getScaledHeight();
         return var1 > 0 && var2 > 0 ? ((PacketBinder)a).Z7().getY() * (double)var2 / (double)var1 : Double.NaN;
      } else {
         return Double.NaN;
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
