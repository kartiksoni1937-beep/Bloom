package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket;

import java.util.List;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.CoreSerializer;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.InitNotifier;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.LinkerFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.ParserEngine;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.BlockCalculator;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.CheckerBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.ItemDescriptor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.SlotEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.TimingEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.BufferNormalizer;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.FrameClockCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.InitExecutor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.SlotInspector;
import net.minecraft.component.type.PiercingWeaponComponent;
import net.minecraft.util.Hand;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.Entity;import net.minecraft.util.hit.HitResult;
public final class StepCacheWalker extends BuilderFactory implements CoreSerializer, InitNotifier {
   private static final String[] x = new String[]{"O.n Attack", "K.eybind"};
   private static final String[] y = new String[]{"S.word", "A.xe", "M.ace", "C.urrent", "S.teak", "W.ind Cha" + "r" + "ge", "P.earl", "G.ap"};
   private static final String[] z = new String[]{"T.icks", "M.s"};
   private static final int aa = 1;
   private static final int ab = 0;
   private static final int ac = 1;
   private static final int ad = 2;
   private static final int ae = 3;
   private static final int af = 4;
   private static final int ag = 5;
   private static final int ah = 6;
   private static final int ai = 7;
   private static final int aj = 1;
   private static final int ak = 0;
   private static final int al = 1;
   private static final int am = 2;
   private static final int an = 40;
   private final SlotEntry ao;
   private final ItemDescriptor ap;
   private final SlotEntry aq;
   private final CheckerBridge ar;
   private final SlotEntry as;
   private final BlockCalculator at;
   private final BlockCalculator au;
   private final TimingEntry av;
   private final TimingEntry aw;
   private final CheckerBridge ax;
   private final CheckerBridge ay;
   private final BlockCalculator az;
   private int ba;
   private int bb;
   private int bc;
   private int bd;
   private int be;
   private long bf;
   private boolean bg;
   private int bh;
   private int bi;
   private int bj;
   private boolean bk;
   private int bl;
   private final Runnable bm;

   public StepCacheWalker() {
      super("", "", ParserEngine.CT);
      this.setName(
         new char[]{'氁', '求', '泾', '泄', '沮', '沍', '洧', '浵', '洲', '洅', '淳'},
         12282957,
         new char[]{
            'ꗕ',
            'ꖋ',
            'ꖳ',
            'ꖂ',
            '꙲',
            'Ꙓ',
            'Ꙡ',
            'ꘫ',
            'ꘑ',
            'ꚽ',
            'ꛅ',
            'ꚴ',
            'ꚏ',
            'ꝫ',
            'ꜘ',
            'Ꜥ',
            '꜆',
            '\ua7f0',
            'ꟕ',
            'ꞡ',
            '\ua7d2',
            'ꡥ',
            'ꡟ',
            'ꡯ',
            'ꠂ',
            '꣸',
            'ꣂ',
            'ꢬ',
            'ꢏ',
            'ꤥ',
            '꤈',
            'ꤳ',
            'ꤎ',
            'ꧠ',
            '꧊',
            'ꧣ',
            'ꦀ',
            'ꩠ',
            'ꩃ',
            '꩔'
         },
         -474700410
      );
      this.ao = new SlotEntry("M.ode", x[0], x);
      ItemDescriptor var10001 = new ItemDescriptor("", -1, false);
      var10001.n(new char[]{'瓩', '瓩', '璅', '畱', '畍', '电', '甃', '痵', '病', '疟', '疕', '疘', '癥'}, -1651346264);
      this.ap = var10001;
      this.aq = new SlotEntry("S.tart" + " " + "I" + "tem", y[0], y);
      CheckerBridge var1 = new CheckerBridge("", true);
      var1.n(new char[]{'㫑', '㪌', '㪤', '㪑', '㪊', '㭷', '㭏', '㬹', '㭛', '㯖', '㯌', '㮶', '㮐', '㱳'}, -962446717);
      this.ar = var1;
      this.as = new SlotEntry("D." + "elay Unit", z[0], z);
      BlockCalculator var2 = new BlockCalculator("", 0.0, 20.0, 0.0, 1.0);
      var2.n(new char[]{'웘', '욝', '욧', '욟', '읷', '읊', '읮', '윩', '쟩', '쟇', '잫', '자'}, -1983723884);
      this.at = var2;
      BlockCalculator var3 = new BlockCalculator("", 0.0, 20.0, 0.0, 1.0);
      var3.n(new char[]{'ᒶ', 'ᔭ', 'ᕇ', 'ᔵ', 'ᔕ', 'ᔍ', 'ᗰ', 'ᖝ', 'ᖘ', 'ᖞ', 'ᙶ', 'ᙘ', 'ᘡ'}, 1022825700);
      this.au = var3;
      TimingEntry var4 = new TimingEntry("", 0.0, 1000.0, 0.0, 1.0, 1.0, 0.0);
      var4.n(new char[]{'㈕', '㉖', '㋢', '㋘', '㊲', '㊑', '㌳', '㍶', '㌴', '㌜', '㏮', '㏗', '㏭', '㎡', '㑸'}, -1698024871);
      this.av = var4;
      TimingEntry var5 = new TimingEntry("", 0.0, 1000.0, 50.0, 1.0, 1.0, 0.0);
      var5.n(new char[]{'詫', '詶', '訒', '諢', '諀', '誦', '誝', '謲', '譵', '謵', '謃', '误', '诔', '诬', '讦', '豹'}, -2130015687);
      this.aw = var5;
      CheckerBridge var6 = new CheckerBridge("", true);
      var6.n(new char[]{'뫑', '몏', '몷', '몶', '몊', '뭾', '뭔', '뭻', '문', '미', '믛', '뮼'}, -2108573054);
      this.ax = var6;
      CheckerBridge var7 = new CheckerBridge("", false);
      var7.n(new char[]{'㜁', '㝉', '㟡', '㟋', '㞫', '㞑', '㡧', '㠁', '㠃', '㠰', '㠑', '㣱', '㣘', '㢴', '㢍', '㥷'}, 1283471176);
      this.ay = var7;
      BlockCalculator var8 = new BlockCalculator("", 0.0, 5.0, 4.0, 1.0);
      var8.n(
         new char[]{
            '\uf1e0',
            '\uf1ec',
            '\uf18e',
            '\uf26f',
            '\uf273',
            '\uf25a',
            '\uf232',
            '\uf20b',
            '\uf2f5',
            '\uf29a',
            '\uf28a',
            '\uf294',
            '\uf376',
            '\uf355',
            '\uf33e'
         },
         1951396259
      );
      this.az = var8;
      this.bc = Integer.MIN_VALUE;
      this.bd = Integer.MIN_VALUE;
      this.bi = -1;
      this.bj = -1;
      this.bm = this::f_r86;
      this.a(new InitAdapter[]{this.ao, this.ap, this.aq, this.ar, this.as, this.at, this.au, this.av, this.aw, this.ax, this.ay, this.az});
   }

   @Override
   public void c() {

      this.b.a(CoreSerializer.class, this);
      this.b.a(InitNotifier.class, this);
      this.w();
      this.bl = 0;
      int var1 = this.ap.d;
      this.bk = var1 != -1 && SlotInspector.a(var1);
      FrameClockCache.add(this.bm);
      super.c();
   }

   @Override
   public void d() {

      this.b.b(CoreSerializer.class, this);
      this.b.b(InitNotifier.class, this);
      FrameClockCache.b(this.bm);
      this.w();
      this.bl = 0;
      super.d();
   }

   @Override
   public void a() {

      int var1 = ++this.bb;
      if (a.currentScreen != null) {
         this.bd = var1;
      }

      int var2 = this.ap.d;
      boolean var3 = var2 != -1 && SlotInspector.a(var2);
      boolean var4 = var3 && !this.bk;
      this.bk = var3;
      if (var4 && this.ba != 0 && a.currentScreen == null && v(this.ao) == 1) {
         this.bl = 1;
      }

      if (this.ba != 0 || var4 || this.bl != 0) {
         if (a.player != null && a.world != null && a.interactionManager != null) {
            if (this.ba == 2) {
               this.c(var1);
            } else if (this.ba == 1) {
               this.b_r127(var1);
            }

            if (this.ba == 0 && (var4 || this.bl > 0) && a.currentScreen == null && v(this.ao) == 1) {
               if (this.bc == var1 || k(a.player.age)) {
                  this.bl = 1;
               } else if (!FrameClockCache.i(a.player)) {
                  this.bl = 1;
                  FrameClockCache.j(a.player);
               } else {
                  this.bl = 0;
                  this.a_r85(var1);
               }
            }
         } else {
            this.w();
            this.bl = 0;
         }
      }
   }

   @Override
   public void a(LinkerFactory var1) {

      if (a.player != null && a.world != null && a.interactionManager != null && !var1.c() && !BufferNormalizer.a(0)) {
         ClientPlayerEntity var2 = a.player;
         PlayerInventory var3 = var2.getInventory();
         if (this.ba == 2 && InitExecutor.a(var3) != this.bj) {
            this.w();
         }

         int var4 = var2.age;
         ItemStack var5 = var2.getMainHandStack();
         if (var5.contains(DataComponentTypes.PIERCING_WEAPON)) {
            if (this.ay.f()
               && a.attackCooldown <= 0
               && a.currentScreen == null
               && a.crosshairTarget != null
               && !var2.isRiding()
               && !var2.isUsingItem()
               && var5.isItemEnabled(a.world.getEnabledFeatures())
               && !a.interactionManager.isFlyingLocked()
               && InitExecutor.p != var4
               && var2.isBelowMinimumAttackCharge(var5, 0)
               && this.o(var2, var5)) {
               j(var2, var5);
               var1.b();
            }
         } else if (this.ba == 0
            && this.bc != this.bb
            && this.bd < this.bb - 1
            && a.currentScreen == null
            && a.attackCooldown <= 0
            && v(this.ao) != 1
            && a.crosshairTarget != null
            && a.crosshairTarget.getType() != HitResult.Type.BLOCK
            && !k(var4)) {
            int var6 = v(this.aq);
            if (var6 == 3 || t(var5.getItem(), var6)) {
               int var7 = r(var3, this.ar.f());
               if (var7 != -1) {
                  ItemStack var8 = var3.getStack(var7);
                  if (this.n(var8)) {
                     int var9 = InitExecutor.a(var3);
                     if (var7 != var9) {
                        if (!FrameClockCache.i(var2)) {
                           FrameClockCache.j(var2);
                        } else {
                           boolean var10 = var2.isBelowMinimumAttackCharge(var8, 0);
                           InitExecutor.a(var3, var7);
                           this.bi = var9;
                           this.bj = var7;
                           this.bc = this.bb;
                           if (var10) {
                              j(var2, var8);
                              var1.b();
                           }

                           this.i(this.bb);
                        }
                     }
                  }
               }
            }
         }
      }
   }

   private boolean a_r85(int var1) {

      PlayerInventory var2 = a.player.getInventory();
      if (r(var2, this.ar.f()) == -1) {
         return false;
      } else {
         int var3 = InitExecutor.a(var2);
         int var4 = var3;
         int var5 = v(this.aq);
         if (var5 != 3 && !t(a.player.getMainHandStack().getItem(), var5)) {
            int var6 = u(var2, var5);
            if (var6 != -1) {
               var4 = var6;
            }
         }

         this.bi = var4;
         if (var4 != var3) {
            InitExecutor.a(var2, var4);
            this.bc = var1;
         }

         this.ba = 1;
         this.bh = 0;
         this.l(var1, this.at, this.av);
         this.b_r127(var1);
         return true;
      }
   }

   private boolean b_r127(int var1) {

      ClientPlayerEntity var2 = a.player;
      if (var2.isDead()) {
         this.w();
         return false;
      } else if (var1 != this.bc && this.m(var1)) {
         PlayerInventory var3 = var2.getInventory();
         if (InitExecutor.a(var3) != this.bi) {
            this.w();
            return false;
         } else {
            int var4 = r(var3, this.ar.f());
            if (var4 == -1) {
               this.w();
               return false;
            } else {
               ItemStack var5 = var3.getStack(var4);
               boolean var6 = !this.n(var5) || InitExecutor.p == var2.age || InitExecutor.a(var3) != var4 && k(var2.age);
               if (!var6 && InitExecutor.a(var3) != var4 && !FrameClockCache.i(var2)) {
                  var6 = true;
                  FrameClockCache.j(var2);
               }

               if (var6) {
                  if (++this.bh > 40) {
                     this.w();
                  }

                  return false;
               } else {
                  if (InitExecutor.a(var3) != var4) {
                     InitExecutor.a(var3, var4);
                     this.bc = var1;
                  }

                  j(var2, var5);
                  this.bj = var4;
                  this.i(var1);
                  return true;
               }
            }
         }
      } else {
         return false;
      }
   }

   private boolean c(int var1) {

      if (var1 == this.bc || !this.m(var1) || a.currentScreen != null || k(a.player.age)) {
         return false;
      } else if (!FrameClockCache.i(a.player)) {
         FrameClockCache.j(a.player);
         return false;
      } else {
         PlayerInventory var2 = a.player.getInventory();
         if (InitExecutor.a(var2) == this.bj) {
            InitExecutor.a(var2, this.bi);
            this.bc = var1;
         }

         this.w();
         return true;
      }
   }

   private void f_r86() {

      if (this.bg && System.nanoTime() - this.bf >= 0L) {
         if (a.player != null && a.world != null && a.interactionManager != null) {
            int var1 = a.player.age;
            if ((!InitExecutor.u || a.player.isOnGround() || a.player.isTouchingWater()) && InitExecutor.s != var1 && InitExecutor.s != var1 - 1) {
               if (this.ba == 1) {
                  this.g_r87();
               } else if (this.ba == 2) {
                  this.h_r88();
               }
            }
         }
      }
   }

   private boolean g_r87() {

      if (!FrameClockCache.n) {
         return false;
      } else {
         ClientPlayerEntity var1 = a.player;
         if (var1.isDead()) {
            this.w();
            return false;
         } else {
            PlayerInventory var2 = var1.getInventory();
            if (InitExecutor.a(var2) != this.bi) {
               this.w();
               return false;
            } else {
               int var3 = r(var2, this.ar.f());
               if (var3 == -1) {
                  this.w();
                  return false;
               } else {
                  ItemStack var4 = var2.getStack(var3);
                  boolean var5 = InitExecutor.a(var2) != var3;
                  if (this.n(var4)
                     && !var1.isBelowMinimumAttackCharge(var4, 0)
                     && InitExecutor.p != var1.age
                     && (!var5 || !k(var1.age) && FrameClockCache.i(var1))) {
                     if (var5) {
                        InitExecutor.a(var2, var3);
                        this.bc = this.bb + 1;
                     }

                     j(var1, var4);
                     this.bj = var3;
                     this.i(this.bb);
                     return true;
                  } else {
                     return false;
                  }
               }
            }
         }
      }
   }

   private boolean h_r88() {

      if (a.currentScreen == null && !k(a.player.age) && FrameClockCache.i(a.player)) {
         PlayerInventory var1 = a.player.getInventory();
         if (InitExecutor.a(var1) == this.bj) {
            InitExecutor.a(var1, this.bi);
            this.bc = this.bb + 1;
         }

         this.w();
         return true;
      } else {
         return false;
      }
   }

   private boolean i(int var1) {

      if (this.ax.f() && this.bi != -1 && this.bi != this.bj) {
         this.ba = 2;
         this.l(var1 + 1, this.au, this.aw);
         return true;
      } else {
         this.w();
         return false;
      }
   }

   private static void j(ClientPlayerEntity var0, ItemStack var1) {

      PiercingWeaponComponent var2 = (PiercingWeaponComponent)var1.get(DataComponentTypes.PIERCING_WEAPON);
      if (var2 != null) {
         a.interactionManager.attackWithPiercingWeapon(var2);
         var0.swingHand(Hand.MAIN_HAND);
         InitExecutor.p = var0.age;
      }
   }

   private static boolean k(int var0) {

      return InitExecutor.o == var0 || InitExecutor.p == var0 || a.player.handSwinging && a.player.handSwingTicks < 0;
   }

   private void l(int var1, BlockCalculator var2, BlockCalculator var3) {

      if (v(this.as) == 1) {
         this.be = var1;
         this.bf = System.nanoTime() + (long)(var3.p() * 1000000.0);
         this.bg = true;
      } else {
         this.be = var1 + var2.g();
         this.bg = false;
      }
   }

   private boolean m(int var1) {

      return var1 >= this.be && (!this.bg || System.nanoTime() - this.bf >= 0L);
   }

   private boolean n(ItemStack var1) {

      ClientPlayerEntity var2 = a.player;
      return a.currentScreen == null
            && !var2.isUsingItem()
            && !var2.isRiding()
            && !a.interactionManager.isFlyingLocked()
            && a.crosshairTarget != null
            && var1.isItemEnabled(a.world.getEnabledFeatures())
            && this.o(var2, var1)
         ? !this.ar.f() || q(var2)
         : false;
   }

   private boolean o(ClientPlayerEntity var1, ItemStack var2) {

      if (!var1.isBelowMinimumAttackCharge(var2, 0)) {
         return true;
      } else if (!this.ay.f()) {
         return false;
      } else {
         int var3 = Math.min(5, Math.max(0, this.az.g()));
         return var3 > 0 && p(var1, var1.getMainHandStack()) && !var1.isBelowMinimumAttackCharge(var2, var3);
      }
   }

   private static boolean p(ClientPlayerEntity var0, ItemStack var1) {

      EntityAttributeInstance var2 = var0.getAttributeInstance(EntityAttributes.ATTACK_SPEED);
      if (var2 == null) {
         return false;
      } else {
         AttributeModifiersComponent var3 = (AttributeModifiersComponent)var1.getOrDefault(DataComponentTypes.ATTRIBUTE_MODIFIERS, AttributeModifiersComponent.DEFAULT);
         List var4 = var3.modifiers();
         boolean var5 = false;

         for (int var6 = 0; var6 < var4.size(); var6++) {
            AttributeModifiersComponent.Entry var7 = (AttributeModifiersComponent.Entry)var4.get(var6);
            if (var7.attribute().matches(EntityAttributes.ATTACK_SPEED) && var7.slot().matches(EquipmentSlot.MAINHAND)) {
               EntityAttributeModifier var8 = var7.modifier();
               EntityAttributeModifier var9 = var2.getModifier(var8.id());
               if (var9 == null || var9.value() != var8.value() || var9.operation() != var8.operation()) {
                  return false;
               }

               if (var8.id().equals(Item.BASE_ATTACK_SPEED_MODIFIER_ID)) {
                  var5 = true;
               }
            }
         }

         return var5 || !var2.hasModifier(Item.BASE_ATTACK_SPEED_MODIFIER_ID);
      }
   }

   private static boolean q(ClientPlayerEntity var0) {

      return !var0.hasVehicle() && !var0.isGliding() && !var0.isTouchingWater() && (var0.getHungerManager().canSprint() || var0.getAbilities().allowFlying);
   }

   private static int r(PlayerInventory var0, boolean var1) {

      int var2 = -1;
      int var3 = var1 ? 0 : -1;

      for (int var4 = 0; var4 < 9; var4++) {
         ItemStack var5 = var0.getStack(var4);
         if (var5.contains(DataComponentTypes.PIERCING_WEAPON)) {
            int var6 = s(var5);
            if (var6 > var3) {
               var2 = var4;
               var3 = var6;
            }
         }
      }

      return var2;
   }

   private static int s(ItemStack var0) {

      ItemEnchantmentsComponent var1 = var0.getEnchantments();

      for (RegistryEntry var3 : var1.getEnchantments()) {
         if (var3.matchesKey(Enchantments.LUNGE)) {
            return var1.getLevel(var3);
         }
      }

      return 0;
   }

   private static boolean t(Item var0, int var1) {

      switch (var1) {
         case 0:
            return InitExecutor.a(var0);
         case 1:
            return InitExecutor.b(var0);
         case 2:
            return var0 == Items.MACE;
         case 3:
         default:
            return false;
         case 4:
            return var0 == Items.COOKED_BEEF;
         case 5:
            return var0 == Items.WIND_CHARGE;
         case 6:
            return var0 == Items.ENDER_PEARL;
         case 7:
            return var0 == Items.GOLDEN_APPLE || var0 == Items.ENCHANTED_GOLDEN_APPLE;
      }
   }

   private static int u(PlayerInventory var0, int var1) {

      for (int var2 = 0; var2 < 9; var2++) {
         if (t(var0.getStack(var2).getItem(), var1)) {
            return var2;
         }
      }

      return -1;
   }

   private static int v(SlotEntry var0) {

      int var1 = var0.g().indexOf(var0.f());
      return var1 < 0 ? 0 : var1;
   }

   private void w() {

      this.ba = 0;
      this.bi = -1;
      this.bj = -1;
      this.bh = 0;
      this.bg = false;
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
