package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket;

import java.util.List;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.CoreSerializer;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.InitNotifier;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.LinkerFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.ParserEngine;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.BlockCalculator;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.CheckerBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.ItemDescriptor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.BufferNormalizer;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.GridResolver;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.InitExecutor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.SlotInspector;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.BindingBridge;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ShieldItem;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.component.DataComponentTypes;

public final class PoolCoordProvider extends BuilderFactory implements InitNotifier, CoreSerializer {
   private final CheckerBridge aa;
   private final CheckerBridge ab;
   private final CheckerBridge ac;
   private final CheckerBridge ad;
   private final BlockCalculator ae;
   private final BlockCalculator af;
   private final BlockCalculator ag;
   private final BlockCalculator ah;
   private final CheckerBridge ai;
   private final CheckerBridge aj;
   private final CheckerBridge ak;
   private final CheckerBridge al;
   private final CheckerBridge am;
   private final CheckerBridge an;
   private final CheckerBridge ao;
   private final CheckerBridge ap;
   private final CheckerBridge aq;
   private final BlockCalculator ar;
   private final CheckerBridge as;
   private final CheckerBridge at;
   public static volatile boolean ARM;
   private long au;
   private int av;
   private int aw;
   private Entity ax;

   public PoolCoordProvider() {
      super("", "", ParserEngine.CT);
      this.setName(new char[]{'ಿ', 'ത', '൛', 'ഡ', 'ഀ', '\u0de1', 'ව', 'බ', 'ඡ', '\u0e6d', '๕'}, 58068203, new char[0], 195815381);
      CheckerBridge var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'龵', 'ꀯ', 'ꁏ', 'ꁍ', 'ꀵ', 'ꁝ', 'ꃕ', 'ꃕ', 'ꃺ', 'ꂪ', 'ꅻ', 'ꅅ', 'ꄳ', 'ꄐ', 'ꇺ'}, 451452898);
      this.aa = var10001;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'䄒', '䅊', '䇫', '䇋', '䆭', '䆅', '䇟', '䉋', '䉎', '䈹'}, -354926267);
      this.ab = var10001;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'೩', '೫', 'ಊ', 'ണ', '൮', 'ത', 'ആ', 'ഋ', '\u0dbe', '\u0dfe', 'ධ', 'ඒ', '\u0e79', '๒'}, 589761702);
      this.ac = var10001;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'꩘', 'ꨖ', '\uaa3b', 'ꨚ', 'ꪵ', '\uaafd', 'ꪧ', 'ꪗ', 'ꭼ', 'ꭃ'}, 130329113);
      this.ad = var10001;
      BlockCalculator var4 = new BlockCalculator("", 0.0, 1000.0, 540.0, 1.0);
      var4.n(new char[]{'ꗈ', 'ꖔ', 'ꖮ', 'ꖗ', 'ꙥ', 'Ꙓ', 'ꙵ', '\ua630', '꛶', 'ꛞ', 'ꚰ', 'ꚉ', 'ꜯ', 'ꝣ', 'Ꜥ', '꜂'}, -74472037);
      this.ae = var4;
      BlockCalculator var5 = new BlockCalculator("", 0.0, 1000.0, 550.0, 1.0);
      var5.n(
         new char[]{
            '\uef03',
            '\uef41',
            '\ueff9',
            '\uefc2',
            '\uefbe',
            '\uef8f',
            '\uf02a',
            '\uf06d',
            '\uf02d',
            '\uf00b',
            '\uf0e7',
            '\uf0dc',
            '\uf0e4',
            '\uf0ae',
            '\uf163',
            '\uf159'
         },
         -550768816
      );
      this.af = var5;
      BlockCalculator var6 = new BlockCalculator("", 0.0, 1000.0, 780.0, 1.0);
      var6.n(new char[]{'쒘', '쓖', '앯', '앓', '앵', '씰', '엶', '엞', '얰', '얉', '옯', '왣', '오', '옂'}, -1679702823);
      this.ag = var6;
      BlockCalculator var7 = new BlockCalculator("", 0.0, 1000.0, 800.0, 1.0);
      var7.n(new char[]{'▴', '☺', '♋', '☷', '♑', '⛔', '⛊', '⚢', '⚌', '❵', '✋', '✇', '✈', '⟰'}, -1415305739);
      this.ah = var7;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'猼', '现', '珕', '玹', '玘', '瑱', '琙', '琋', '琟', '瓿', '瓐', '璸', '璗'}, -1703578753);
      this.ai = var10001;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'쯆', '쮆', '쮩', '쮊', '챼', '찄', '찀', '찐', '쳨', '쳔', '첟', '첍', '첊', '쵳', '쵉', '촾'}, 516803465);
      this.aj = var10001;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'椄', '楄', '槧', '槄', '榾', '槆', '橆', '橖', '横', '樖', '檡', '櫡', '櫇', '檻'}, -1268487861);
      this.ak = var10001;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'䘶', '䚪', '䛔', '䚫', '䚏', '䝧', '䜿', '䝶', '䜼', '䜒', '䟿'}, 29902437);
      this.al = var10001;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'齥', '齿', '鼘', '鿦', '鿂', '龨', '鿌', 'ꁊ', 'ꁙ', 'ꀪ', 'ꀍ', 'ꃩ', 'ꃂ', 'ꂬ', 'ꂊ', 'ꅤ'}, -1979539662);
      this.am = var10001;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'紃', '統', '紒', '練', '緟', '綰', '線', '繊', '繑', '縺', '縃', '绹', '绕', '级', '纛', '罾', '罞'}, 2017099072);
      this.an = var10001;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'慓', '愱', '慊', '愯', '愝', '懢', '憚', '憛', '憁', '执', '扗', '戦', '戇'}, -1852284672);
      this.ao = var10001;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'㔀', '㕎', '㔓', '㗲', '㖝', '㖙', '㖕', '㙮', '㙐', '㘬', '㘞', '㛳', '㛆'}, -1688193727);
      this.ap = var10001;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'ﴂ', 'ﵘ', '\ufde6', '\ufdd1', 'ﷳ', 'ﶡ', 'ﹹ', '﹙', '︪', '︂', 'ﻩ'}, -1563427497);
      this.aq = var10001;
      BlockCalculator var17 = new BlockCalculator("", 100.0, 1000.0, 350.0, 1.0);
      var17.n(new char[]{'㡯', '㡵', '㠒', '㣰', '㣝', '㢻', '㢒', '㤵', '㥠', '㤺', '㤟', '㧴'}, 640563260);
      this.ar = var17;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'룕', '뢋', '뢥', '뢎', '륧', '뤁', '뤐', '뤳', '뤟', '매', '맙', '릩'}, 1272887430);
      this.as = var10001;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'腍', '脄', '脼', '脄', '臫', '膆', '膆', '膌', '艢', '艐', '舦', '舅'}, -1912569589);
      this.at = var10001;
      this.au = 0L;
      this.ax = null;
      this.a(
         this.aa,
         this.ab,
         this.ac,
         this.ad,
         this.ae,
         this.af,
         this.ag,
         this.ah,
         this.ai,
         this.am,
         this.as,
         this.aj,
         this.ak,
         this.al,
         this.an,
         this.ao,
         this.ap,
         this.aq,
         this.ar,
         this.at
      );
   }

   @Override
   public void c() {

      this.av = this.k(this.ae.g(), this.af.g());
      this.aw = this.k(this.ag.g(), this.ah.g());
      this.b.a(InitNotifier.class, this);
      this.b.a(CoreSerializer.class, this);
      super.c();
   }

   @Override
   public void d() {

      ARM = false;
      this.ax = null;
      this.b.b(InitNotifier.class, this);
      this.b.b(CoreSerializer.class, this);
      super.d();
   }

   @Override
   public void a() {

      ARM = a.player != null
         && this.ac.f()
         && (this.aa.f() || a.currentScreen == null)
         && SlotInspector.a(0)
         && (this.ad.f() || InitExecutor.a(a.player.getMainHandStack().getItem()) || InitExecutor.b(a.player.getMainHandStack().getItem()));
      Object var1 = null;

      try {
         if (this.ax != null && (!this.ax.isAlive() || this.ax.getEntityWorld() != a.world)) {
            this.ax = null;
         }

         if (a.player == null || a.world == null) {
            return;
         }

         if (!this.aa.f() && a.currentScreen != null) {
            return;
         }

         var1 = ConfigBridge.c != null ? ConfigBridge.c.e() : null;
         if (var1 != null
            && !((BindingBridge)var1).d()
            && a.crosshairTarget instanceof EntityHitResult var2
            && var2.getEntity() instanceof PlayerEntity var3
            && ((BindingBridge)var1).a(var3)) {
            return;
         }

         Item var7 = a.player.getMainHandStack().getItem();
         if (this.ac.f() && !SlotInspector.a(0)) {
            return;
         }

         Item var8 = a.player.getOffHandStack().getItem();
         if ((var8.getComponents().contains(DataComponentTypes.FOOD) || var8 instanceof ShieldItem) && SlotInspector.a(1) && !this.ab.f()) {
            return;
         }

         if (!this.am.f() && !a.player.isOnGround()) {
            if (a.player.getVelocity().y > 0.0) {
               return;
            }

            if (!(a.player.fallDistance > 0.0)) {
               return;
            }
         }

         if (this.at.f() && a.player.getAttackCooldownProgress(0.5F) < 1.0F) {
            return;
         }

         if (this.ad.f()) {
            this.f_r70();
         } else if (InitExecutor.a(var7)) {
            this.f_r70();
         } else if (InitExecutor.b(var7)) {
            this.g_r71();
         }
      } catch (Exception var5) {
      }
   }

   private void f_r70() {

      if (a.crosshairTarget instanceof EntityHitResult var1) {
         Entity var4 = var1.getEntity();
         if (this.as.f() && this.ax != null && var4 != this.ax) {
            return;
         }

         if (var4 instanceof PlayerEntity || this.ao.f() && var4 instanceof ZombieEntity || this.ap.f() && var4 != null) {
            if (var4 instanceof PlayerEntity var3 && this.ai.f() && var3.isBlocking() && !GridResolver.a(var3)) {
               return;
            }

            if (this.aj.f() && a.player.fallDistance <= 0.0) {
               return;
            }

            if (this.j(this.av)) {
               this.h(var4);
               this.av = this.k(this.ae.g(), this.af.g());
               this.au = System.currentTimeMillis();
            } else {
               this.i_r72();
            }
         }
      }
   }

   private void g_r71() {

      if (a.crosshairTarget instanceof EntityHitResult var1) {
         Entity var4 = var1.getEntity();
         if (this.as.f() && this.ax != null && var4 != this.ax) {
            return;
         }

         if (var4 instanceof PlayerEntity || this.ao.f() && var4 instanceof ZombieEntity || this.ap.f() && var4 != null) {
            if (var4 instanceof PlayerEntity var3 && this.ai.f() && var3.isBlocking() && !GridResolver.a(var3)) {
               return;
            }

            if (this.ak.f() && a.player.fallDistance <= 0.0) {
               return;
            }

            if (this.j(this.aw)) {
               this.h(var4);
               this.aw = this.k(this.ag.g(), this.ah.g());
               this.au = System.currentTimeMillis();
            } else {
               this.i_r72();
            }
         }
      }
   }

   private void h(Entity var1) {

      if (this.aq.f() && a.player.getOffHandStack().getItem() == Items.SHIELD && a.player.isBlocking()) {
         BufferNormalizer.c(1);
      }

      GridResolver.a(var1, this.al.f());
      this.ax = var1;
      if (this.an.f()) {
         BufferNormalizer.d(0);
      }
   }

   private void i_r72() {

      if (this.aq.f() && a.player.getOffHandStack().getItem() == Items.SHIELD) {
         int var1 = this.ar.g();
         BufferNormalizer.a(1, var1);
      }
   }

   private boolean j(int var1) {

      return System.currentTimeMillis() - this.au >= (long)var1;
   }

   private int k(int var1, int var2) {

      return var1 >= var2 ? var1 : var1 + (int)(Math.random() * (double)(var2 - var1 + 1));
   }

   @Override
   public void a(LinkerFactory var1) {

      if (!SlotInspector.a(0)) {
         var1.b();
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
