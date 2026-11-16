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
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.SlotEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.TimingEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.FrameClockCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.InitExecutor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.SlotInspector;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.BindingBridge;
import net.minecraft.util.Hand;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.MaceItem;
import net.minecraft.entity.Entity;import net.minecraft.util.hit.HitResult;
public final class SortCacheUnit extends BuilderFactory implements InitNotifier, CoreSerializer {
   private final SlotEntry q;
   private final BlockCalculator r;
   private final CheckerBridge s;
   private final CheckerBridge t;
   private final CheckerBridge u;
   private final TimingEntry v;
   private final TimingEntry w;
   private final TimingEntry x;
   private final CheckerBridge y;
   private final CheckerBridge z;
   private final BlockCalculator aa;
   private final CheckerBridge ab;
   private final CheckerBridge ac;
   private final CheckerBridge ad;
   private final CheckerBridge ae;
   private static final int af = -1;
   private static final double ag = 1.5;
   private static final int ah = 3;
   private static final double ai = 6.0;
   private long aj;
   private int ak;
   private int al;
   private int am;
   private int an;
   private long ao;
   private final Runnable ap;
   private LivingEntity aq;
   private int ar;
   private double as;
   private boolean at;
   private BuilderFactory au;
   private Object av;
   private static int aw = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   public SortCacheUnit() {
      super("", "", ParserEngine.CT);
      this.setName(
         new char[]{'Қ', 'Ә', 'մ', '\u0557', 'Զ', 'Ւ', 'ׅ', '֝', '֍', 'ց', 'ٹ'},
         -593951529,
         new char[]{
            '或',
            '扏',
            '拲',
            '拶',
            '拙',
            '抺',
            '抙',
            '捩',
            '挚',
            '挻',
            '挗',
            '揣',
            '掖',
            '採',
            '掜',
            '摲',
            '摆',
            '摱',
            '搃',
            '擸',
            '擏',
            '撽',
            '撟',
            '攫',
            '敞',
            '攦',
            '效',
            '旳',
            '旎',
            '斠',
            '旄',
            '普',
            '晃',
            '昢',
            '昅',
            '晟',
            '書',
            '曒',
            '暮',
            '曛',
            '板',
            '杘',
            '朻',
            '期',
            '架',
            '柝',
            '枽',
            '枇'
         },
         -2145951166
      );
      this.q = new SlotEntry("M.ode", "B.oth", "B.oth", "D.ensity", "B.reach");
      BlockCalculator var10001 = new BlockCalculator("", 0.0, 30.0, 8.0, 0.5);
      var10001.n(new char[]{'ﶚ', '\ufdd9', '﹤', '﹐', '︵', '︐', 'ﻺ', 'ﺑ', 'ﺒ', 'ﺊ', '｢', 'ｂ', '［'}, -1803813416);
      this.r = var10001;
      CheckerBridge var1 = new CheckerBridge("", true);
      var1.n(new char[]{'뿣', '뿯', '뾕', '뾋', '쁱', '쀝', '쀏', '쀌', '샳', '샍', '삻', '삟'}, -1189822558);
      this.s = var1;
      CheckerBridge var2 = new CheckerBridge("", true);
      var2.n(new char[]{'櫋', '檙', '檢', '檀', '歺', '欓', '欁', '欝', '毱', '毂'}, 1953983128);
      this.t = var2;
      CheckerBridge var3 = new CheckerBridge("", true);
      var3.n(new char[]{'⪴', '⬨', '⭒', '⬭', '⬗', '⯡', '⯉', '⯠', '⮝', '⮟', 'Ȿ', 'ⱗ'}, 2076781287);
      this.u = var3;
      TimingEntry var4 = new TimingEntry("", 0.0, 1050.0, 50.0, 1.0, 50.0, 50.0);
      var4.n(
         new char[]{
            '\uf13e',
            '\uf1a2',
            '\uf1dc',
            '\uf1a3',
            '\uf19d',
            '\uf26b',
            '\uf24f',
            '\uf266',
            '\uf227',
            '\uf2e5',
            '\uf2c0',
            '\uf2a9',
            '\uf2c1',
            '\uf344',
            '\uf37a',
            '\uf352',
            '\uf33c',
            '\uf305'
         },
         538964333
      );
      this.v = var4;
      TimingEntry var5 = new TimingEntry("", 0.0, 1000.0, 0.0, 1.0, 1.0, 0.0);
      var5.n(new char[]{'\ud8ff', '\ud8f4', '\ud89c', '\ud974', '\ud956', '\ud92f', '\ud955', '\ud9d9', '\ud9da', '\ud9bc'}, 1092933819);
      this.w = var5;
      TimingEntry var6 = new TimingEntry("", 0.0, 1000.0, 0.0, 1.0, 1.0, 0.0);
      var6.n(new char[]{'튭', '팦', '퍂', '팪', '팄', '폽', '펃', '펏', '펀', '푸'}, 348902121);
      this.x = var6;
      CheckerBridge var7 = new CheckerBridge("", true);
      var7.n(new char[]{'\ue06c', '\ue067', '\ue01d', '\ue0eb', '\ue0ca', '\ue0e5', '\ue0a7', '\ue16b', '\ue143', '\ue133', '\ue107', '\ue11a'}, -1800609750);
      this.y = var7;
      CheckerBridge var8 = new CheckerBridge("", false);
      var8.n(new char[]{'羐', '翐', '聳', '聐', '耢', '聚', '胟', '胙', '肻', '肚', '腼', '腚', '脴'}, -1382580257);
      this.z = var8;
      var10001 = new BlockCalculator("", 0.0, 20.0, 0.0, 0.5);
      var10001.n(new char[]{'딵', '떹', '뗟', '떻', '뗔', '뙕', '뙓', '똽', '똜'}, -317672072);
      this.aa = var10001;
      CheckerBridge var10 = new CheckerBridge("", false);
      var10.n(new char[]{'⃣', '⃥', '₄', '℩', 'Ⅴ', '™', '℀', '⇱', 'ↄ', 'ↀ', '\u218e', '≨', '≃', '≔'}, 1303322796);
      this.ab = var10;
      CheckerBridge var11 = new CheckerBridge("", false);
      var11.n(new char[]{'郰', '郾', '邃', '酢', '鄍', '鄉', '鄅', '釾', '釀', '醼', '醎', '鉣', '鉖'}, -102657871);
      this.ac = var11;
      CheckerBridge var12 = new CheckerBridge("", false);
      var12.n(new char[]{'\u175b', '\u1717', '᜴', '\u171b', 'ា', '\u17fc', 'ហ', 'ព', '\u187f', 'ᡂ'}, -1892935910);
      this.ad = var12;
      CheckerBridge var13 = new CheckerBridge("", false);
      var13.n(new char[]{'握', '揻', '掛', '摡', '摙', '摱', '搹', '擡', '撎', '撞', '撏', '敹', '敏', '攬', '攆'}, 248079286);
      this.ae = var13;
      this.aj = 0L;
      this.ak = 0;
      this.al = -1;
      this.am = -1;
      this.an = -1;
      this.ao = 0L;
      this.ap = this::h_r81;
      this.aq = null;
      this.ar = 0;
      this.as = 0.0;
      this.at = false;
      this.au = null;
      this.av = null;
      this.a(this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.aa, this.ab, this.ac, this.ad, this.ae);
   }

   @Override
   public void c() {

      this.b.a(InitNotifier.class, this, -1);
      this.b.a(CoreSerializer.class, this, -1);
      this.p();
      FrameClockCache.add(this.ap);
      super.c();
   }

   @Override
   public void d() {
      byte var1 = 0;

      label36:
      while (true) {
         switch (var1) {
            case 0:
            default:
               if (aw != 0) {
                  Math.abs(Integer.MIN_VALUE);
                  var1 = 1;
                  continue;
               }
            case 1:
               this.b.b(InitNotifier.class, this);
               this.b.b(CoreSerializer.class, this);
               FrameClockCache.b(this.ap);
               this.n(false);
               InitExecutor.v = false;
               if (a.player != null && this.av == a.player && !this.j(a.player.age) && FrameClockCache.i(a.player)) {
                  if (InitExecutor.n != a.player) {
                     break;
                  }

                  if (InitExecutor.m != 2) {
                     var1 = 2;
                     continue;
                  }
               }
            case 4:
               if (InitExecutor.m != 3) {
                  break label36;
               }

               InitExecutor.m = 0;
               InitExecutor.n = null;
               var1 = 3;
               continue;
            case 2:
               break;
            case 3:
               break label36;
         }

         this.i_r82();
         var1 = 4;
      }

      this.p();
      super.d();
   }

   @Override
   public void a() {

      InitExecutor.v = this.t.f() && this.s.f();
      if (a.player == null) {
         this.n(false);
         if (this.av != null) {
            this.p();
         }

         if (InitExecutor.n != null) {
            InitExecutor.m = 0;
            InitExecutor.n = null;
         }
      } else {
         if (this.av != a.player) {
            this.p();
            this.av = a.player;
            if (InitExecutor.n != null && InitExecutor.n != a.player) {
               InitExecutor.m = 0;
               InitExecutor.n = null;
            }
         }

         boolean var1 = a.currentScreen == null || this.ae.f() && !(a.currentScreen instanceof HandledScreen);
         ItemStack var2 = a.player.getMainHandStack();
         boolean var3 = this.ad.f()
            || var2.isIn(ItemTags.SWORDS)
            || var2.getItem() instanceof AxeItem
            || var2.getItem() instanceof MaceItem;
         this.n(this.ab.f() && var1 && var3 && (SlotInspector.a(0) || a.options.attackKey.isPressed()));
         if (a.world != null && a.interactionManager != null) {
            int var4 = a.player.age;
            if (a.player.isOnGround() || a.player.isTouchingWater()) {
               this.as = 0.0;
               if (InitExecutor.m == 3) {
                  InitExecutor.m = 0;
                  InitExecutor.n = null;
               }
            } else if (a.player.isGliding() && this.aq == null && InitExecutor.m == 3) {
               InitExecutor.m = 0;
               InitExecutor.n = null;
            }

            if (a.player.fallDistance < this.as) {
               this.as = 0.0;
            }

            if (!a.player.isAlive()) {
               this.aq = null;
               if (InitExecutor.m == 3) {
                  InitExecutor.m = 0;
                  InitExecutor.n = null;
               }
            } else if (!var1) {
               if (this.aq != null) {
                  this.aq = null;
                  this.f_r80();
               }
            } else if (this.aq != null) {
               this.b_r126(var4);
            } else if (this.an != 0 || !FrameClockCache.h(this.ao) || !this.g(var4) || !this.i_r82()) {
               if (var3) {
                  this.a_r79(var4);
               }
            }
         }
      }
   }

   private boolean a_r79(int var1) {

      if (this.ab.f() && !this.at) {
         return false;
      } else if (!a.player.isUsingItem() && !a.player.isSpectator()) {
         double var2 = a.player.fallDistance - this.as;
         boolean var4 = a.player.isOnGround();
         if (!this.z.f() || !var4 && a.player.getVelocity().y < 0.0 && var2 > this.aa.p()) {
            if (this.y.f() && a.player.getAttackCooldownProgress(0.5F) < 1.0F) {
               return false;
            } else if (System.currentTimeMillis() - this.aj < (long)this.ak) {
               return false;
            } else {
               int var5 = InitExecutor.n == a.player ? InitExecutor.m : 0;
               if (var5 == 1 || var5 == 2) {
                  return false;
               } else if (this.j(var1)) {
                  return false;
               } else {
                  if (InitExecutor.b(a, 6.0) instanceof LivingEntity var7 && this.k(var7)) {
                     boolean var8 = !var4 && !a.player.isTouchingWater() && !a.player.isGliding();
                     boolean var9 = var8 && var2 > 1.5;
                     PlayerInventory var10 = a.player.getInventory();
                     boolean var11 = InitExecutor.a(var7);
                     int var12 = var11 ? InitExecutor.d(var7, a.player, 0) : 0;
                     boolean var13 = var12 >= 2;
                     int var14 = var13 ? m(var10) : -1;
                     boolean var15 = var14 != -1 && this.t.f() && this.s.f();
                     if (var11 && InitExecutor.s == var1 && var7 instanceof PlayerEntity) {
                        return false;
                     }

                     if (var15 || !var9 || var5 != 0 || !InitExecutor.t || InitExecutor.q != var1 && InitExecutor.q != var1 - 1) {
                        int var16 = InitExecutor.a(var10);
                        int var17;
                        if (this.s.f()) {
                           var17 = this.l(var10);
                        } else {
                           var17 = a.player.getMainHandStack().getItem() instanceof MaceItem ? var16 : -1;
                        }

                        if (var17 == -1) {
                           return false;
                        }

                        if ((var15 ? var14 : var17) != var16 && !FrameClockCache.i(a.player)) {
                           FrameClockCache.j(a.player);
                           return false;
                        }

                        if (var15) {
                           this.c(var10, var16, var14);
                           this.d(var7, var8);
                           if (var12 == 3) {
                              InitExecutor.e(var7, a.player);
                           }

                           this.aq = var7;
                           this.ar = 3;
                           this.an = -1;
                           return true;
                        }

                        this.c(var10, var16, var17);
                        this.d(var7, var8);
                        if (!var13) {
                           InitExecutor.i(var7, a.player);
                        }

                        if (var9 && !var13) {
                           this.as = a.player.fallDistance;
                        }

                        this.f_r80();
                        return true;
                     }

                     return false;
                  }

                  return false;
               }
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private boolean b_r126(int var1) {

      LivingEntity var2 = this.aq;
      if (--this.ar >= 0 && var2.isAlive() && !var2.isRemoved() && (InitExecutor.n != a.player || InitExecutor.m == 0 || InitExecutor.m == 3)) {
         if (!this.j(var1) && !a.player.isUsingItem()) {
            PlayerInventory var3 = a.player.getInventory();
            double var4 = a.player.fallDistance - this.as;
            int var6 = this.l(var3);
            if (var6 == -1) {
               this.aq = null;
               this.f_r80();
               return false;
            } else if (InitExecutor.b(a, 6.0) != var2) {
               return false;
            } else if (var6 != InitExecutor.a(var3) && !FrameClockCache.i(a.player)) {
               FrameClockCache.j(a.player);
               return false;
            } else {
               this.c(var3, InitExecutor.a(var3), var6);
               boolean var7 = !a.player.isOnGround() && !a.player.isTouchingWater() && !a.player.isGliding();
               boolean var8 = var7 && var4 > 1.5;
               this.d(var2, var7);
               if (var8) {
                  this.as = a.player.fallDistance;
               }

               this.aq = null;
               this.f_r80();
               return true;
            }
         } else {
            return false;
         }
      } else {
         this.aq = null;
         this.f_r80();
         return false;
      }
   }

   @Override
   public void a(LinkerFactory var1) {

      if (a.player != null) {
         if (InitExecutor.p == a.player.age) {
            var1.b();
         } else {
            if (this.at
               && a.crosshairTarget != null
               && a.crosshairTarget.getType() == HitResult.Type.BLOCK
               && !a.player.getMainHandStack().contains(DataComponentTypes.PIERCING_WEAPON)) {
               var1.b();
            }
         }
      }
   }

   private void c(PlayerInventory var1, int var2, int var3) {
      byte var4 = 0;

      while (true) {
         switch (var4) {
            case 0:
            default:
               if (aw != 0) {
                  new Object().hashCode();
                  var4 = 1;
                  break;
               }
            case 1:
               if (var3 == var2) {
                  return;
               }
            case 2:
               if (!this.u.f()) {
                  this.al = -1;
                  var4 = 5;
                  break;
               }
            case 3:
               if (this.al != -1) {
                  if (var2 != this.am) {
                     var4 = 4;
                  } else {
                     var4 = 5;
                  }
                  break;
               }
            case 4:
               this.al = var2;
               var4 = 5;
               break;
            case 5:
               InitExecutor.a(var1, var3);
               this.am = var3;
               return;
         }
      }
   }

   private void d(LivingEntity var1, boolean var2) {

      a.interactionManager.attackEntity(a.player, var1);
      a.player.swingHand(Hand.MAIN_HAND);
      InitExecutor.p = a.player.age;
      this.aj = System.currentTimeMillis();
      int var3 = this.w.g();
      int var4 = this.x.g();
      this.ak = var4 > var3 ? var3 + (int)(Math.random() * (double)(var4 - var3 + 1)) : var3;
      if (var2 && (InitExecutor.n != a.player || InitExecutor.m == 0 || InitExecutor.m == 3)) {
         InitExecutor.m = 3;
         InitExecutor.n = a.player;
      }
   }

   private void f_r80() {

      if (this.u.f() && this.al != -1) {
         this.an = 0;
         this.ao = FrameClockCache.g(this.v.p());
      } else {
         this.an = -1;
      }
   }

   private boolean g(int var1) {

      if (!this.j(var1) && (InitExecutor.n != a.player || InitExecutor.m != 2)) {
         if (!FrameClockCache.i(a.player)) {
            FrameClockCache.j(a.player);
            return false;
         } else {
            return true;
         }
      } else {
         return false;
      }
   }

   private void h_r81() {

      if (this.an == 0 && System.nanoTime() - this.ao >= 0L) {
         if (a.player != null && a.world != null && a.interactionManager != null && this.av == a.player && this.aq == null && a.player.isAlive()) {
            if (a.currentScreen == null || this.ae.f() && !(a.currentScreen instanceof HandledScreen)) {
               int var1 = a.player.age;
               if ((!InitExecutor.u || a.player.isOnGround() || a.player.isTouchingWater())
                  && InitExecutor.s != var1
                  && InitExecutor.s != var1 - 1
                  && this.g(var1)) {
                  this.i_r82();
               }
            }
         }
      }
   }

   private boolean i_r82() {

      boolean var1 = false;
      PlayerInventory var2 = a.player.getInventory();
      if (this.al != -1 && this.al != this.am && InitExecutor.a(var2) == this.am) {
         InitExecutor.a(var2, this.al);
         var1 = true;
      }

      this.al = -1;
      this.am = -1;
      this.an = -1;
      return var1;
   }

   private boolean j(int var1) {

      return InitExecutor.o == var1 || InitExecutor.p == var1 || a.player.handSwinging && a.player.handSwingTicks < 0;
   }

   private boolean k(LivingEntity var1) {

      if (var1 == a.player || !var1.isAlive() || var1.isRemoved() || var1 instanceof ArmorStandEntity) {
         return false;
      } else if (!(var1 instanceof PlayerEntity var2)) {
         return this.ac.f();
      } else if (!var2.isCreative() && !var2.isSpectator()) {
         BindingBridge var3 = null;
         if (ConfigBridge.c != null) {
            var3 = ConfigBridge.c.e();
         }

         return var3 == null || var3.d() || !var3.a(var2);
      } else {
         return false;
      }
   }

   private int l(PlayerInventory var1) {
      int var2 = 0;
      byte var3 = 0;

      while (true) {
         switch (var3) {
            case 0:
            default:
               if (aw != 0) {
                  Math.abs(Integer.MIN_VALUE);
                  var3 = 2;
                  break;
               }
            case 2:
               var2 = this.q.g().indexOf(this.q.f());
               if (var2 == 1) {
                  return InitExecutor.g(var1, Enchantments.DENSITY, null);
               }
            case 1:
               if (var2 == 2) {
                  return InitExecutor.g(var1, Enchantments.BREACH, null);
               }

               if (a.player.fallDistance < this.r.p()) {
                  var3 = 3;
                  break;
               }
            case 4:
               return InitExecutor.g(var1, Enchantments.DENSITY, Enchantments.BREACH);
            case 3:
               return InitExecutor.g(var1, Enchantments.BREACH, null);
         }
      }
   }

   private static int m(PlayerInventory var0) {

      for (int var1 = 0; var1 < 9; var1++) {
         if (var0.getStack(var1).getItem() instanceof AxeItem) {
            return var1;
         }
      }

      return -1;
   }

   private void n(boolean var1) {

      this.at = var1;
      PoolCoordResolver var2 = PoolCoordResolver.I;
      if (var2 == null || !var2.f) {
         PoolCoordResolver.ARM = var1;
      }

      BuilderFactory var3 = this.o();
      if (var3 == null || !var3.f) {
         PoolCoordProvider.ARM = var1;
      }
   }

   private BuilderFactory o() {
      byte var1 = 0;

      while (true) {
         switch (var1) {
            case 0:
            default:
               if (aw != 0) {
                  Math.abs(Integer.MIN_VALUE);
                  var1 = 1;
                  break;
               }
            case 1:
               if (this.au == null && ConfigBridge.c != null && ConfigBridge.c.c() != null) {
                  this.au = ConfigBridge.c.c().a(PoolCoordProvider.class);
                  var1 = 2;
                  break;
               }

               return this.au;
            case 2:
               return this.au;
         }
      }
   }

   private void p() {

      this.al = -1;
      this.am = -1;
      this.an = -1;
      this.ao = 0L;
      this.aq = null;
      this.ar = 0;
      this.as = 0.0;
      this.aj = 0L;
      this.ak = 0;
      this.av = null;
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
