package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.CoreSerializer;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.InitNotifier;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.LinkerFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.ParserEngine;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.CheckerBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.TimingEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.FrameClockCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.InitExecutor;
import net.minecraft.util.Hand;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;

public final class SortComparator extends BuilderFactory implements CoreSerializer, InitNotifier {
   private final CheckerBridge s;
   private final CheckerBridge t;
   private final CheckerBridge u;
   private final CheckerBridge v;
   private final CheckerBridge w;
   private final TimingEntry x;
   private boolean y;
   private int z;
   private long aa;
   private final Runnable ab;
   private int ac;
   private boolean ad;
   private boolean ae;
   private static int af = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   public SortComparator() {
      super("", "", ParserEngine.CT);
      this.setName(new char[]{'ᮂ', 'ᯀ', 'ᱬ', 'ᱏ', 'ᰮ', '\u1c4a', '᳚', '᳟', 'Ღ', 'Ზ'}, -966124593, new char[0], 1434715675);
      CheckerBridge var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'녷', '넑', '넷', '넓', '뇸', '놛', '놘', '놌', '뉪', '뉄', '눢'}, 624013600);
      this.s = var10001;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'韷', '韺', '鞁', '顷', '顐', '頳', '頇'}, -582314059);
      this.t = var10001;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'繅', '縇', '縦', '縋', '绿', '纅', '纗', '纔', '罭', '罓', '缤'}, -326337014);
      this.u = var10001;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'뤎', '륎', '뤑', '맲', '맄', '맼', '릺', '멢', '멜'}, -1475299007);
      this.v = var10001;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'袒', '裎', '袈', '襷', '襉', '褿', '褓', '覺', '觻', '覹', '覔', '詽'}, -80377663);
      this.w = var10001;
      TimingEntry var5 = new TimingEntry("", 0.0, 1050.0, 50.0, 1.0, 50.0, 50.0);
      var5.n(new char[]{'お', '〖', '〠', '〟', 'メ', 'プ', 'セ', 'ヒ', 'ㅕ', 'ㅕ', 'ㄣ', 'ㄏ', 'ㇴ'}, -2146750439);
      this.x = var5;
      this.z = -1;
      this.ab = this::b;
      this.ac = -1;
      this.a(new InitAdapter[]{this.s, this.t, this.u, this.v, this.w, this.x});
   }

   @Override
   public void c() {

      this.b.a(CoreSerializer.class, this);
      this.b.a(InitNotifier.class, this);
      this.j_r125();
      FrameClockCache.add(this.ab);
      super.c();
   }

   @Override
   public void d() {

      this.b.b(CoreSerializer.class, this);
      this.b.b(InitNotifier.class, this);
      FrameClockCache.b(this.ab);
      this.j_r125();
      super.d();
   }

   @Override
   public void a() {

      this.ad = false;
      this.ae = false;
      if (a.player != null && a.interactionManager != null) {
         if (this.y) {
            if (FrameClockCache.h(this.aa)) {
               this.ae = this.c_r78();
            }
         } else if (a.currentScreen == null && a.options.attackKey.isPressed()) {
            if (InitExecutor.p != a.player.age && InitExecutor.o != a.player.age) {
               Entity var1 = this.f_r122();
               if (var1 != null) {
                  int var2 = this.h_r124();
                  if (var2 != -1) {
                     if (!FrameClockCache.i(a.player)) {
                        FrameClockCache.j(a.player);
                     } else {
                        PlayerInventory var3 = a.player.getInventory();
                        this.z = InitExecutor.a(var3);
                        InitExecutor.a(var3, var2);
                        this.ac = var2;
                        a.interactionManager.attackEntity(a.player, var1);
                        a.player.swingHand(Hand.MAIN_HAND);
                        this.ad = true;
                        this.e_r121();
                     }
                  }
               }
            }
         }
      }
   }

   @Override
   public void a(LinkerFactory var1) {

      if (a.player != null) {
         if (this.ad) {
            var1.b();
         } else if (!var1.c() && InitExecutor.p != a.player.age && InitExecutor.o != a.player.age) {
            if (!this.y && !this.ae && a.currentScreen == null && this.f_r122() != null) {
               int var2 = this.h_r124();
               if (var2 != -1) {
                  if (!FrameClockCache.i(a.player)) {
                     FrameClockCache.j(a.player);
                  } else {
                     PlayerInventory var3 = a.player.getInventory();
                     this.z = InitExecutor.a(var3);
                     InitExecutor.a(var3, var2);
                     this.ac = var2;
                     this.e_r121();
                  }
               }
            }
         }
      }
   }

   private void b() {

      if (this.y && System.nanoTime() - this.aa >= 0L) {
         if (a.player != null && a.interactionManager != null) {
            int var1 = a.player.age;
            if ((!InitExecutor.u || a.player.isOnGround() || a.player.isTouchingWater()) && InitExecutor.s != var1 && InitExecutor.s != var1 - 1) {
               this.c_r78();
            }
         }
      }
   }

   private boolean c_r78() {

      int var1 = a.player.age;
      if (InitExecutor.p == var1 || InitExecutor.o == var1) {
         return false;
      } else if (!FrameClockCache.i(a.player)) {
         FrameClockCache.j(a.player);
         return false;
      } else {
         PlayerInventory var2 = a.player.getInventory();
         boolean var3 = this.z != -1 && InitExecutor.a(var2) == this.ac;
         if (var3) {
            InitExecutor.a(var2, this.z);
         }

         this.j_r125();
         return var3;
      }
   }

   private void e_r121() {
      byte var1 = 0;

      while (true) {
         switch (var1) {
            case 0:
            default:
               if (af != 0) {
                  Thread.currentThread().getName().length();
                  var1 = 2;
                  break;
               }
            case 2:
               if (this.w.f()) {
                  this.y = true;
                  this.aa = FrameClockCache.g(this.x.p());
                  var1 = 1;
                  break;
               }
            case 3:
               this.z = -1;
               this.ac = -1;
               var1 = 1;
               break;
            case 1:
               return;
         }
      }
   }

   private Entity f_r122() {

      if (a.crosshairTarget instanceof EntityHitResult var1) {
         Entity var3 = var1.getEntity();
         if (var3 instanceof LivingEntity && var3.isAlive()) {
            if (a.player.getAttackCooldownProgress(0.5F) < 1.0F) {
               return null;
            } else {
               return !a.player.getMainHandStack().isOf(Items.MACE) && this.g_r123() ? var3 : null;
            }
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   private boolean g_r123() {

      Item var1 = a.player.getMainHandStack().getItem();
      boolean var2 = this.u.f();
      boolean var3 = this.v.f();
      return var2 && var3 ? InitExecutor.a(var1) || InitExecutor.b(var1) : (!var2 || InitExecutor.a(var1)) && (!var3 || InitExecutor.b(var1));
   }

   private int h_r124() {

      boolean var1 = this.s.f();
      boolean var2 = this.t.f();
      boolean var3 = var1 == var2;
      PlayerInventory var4 = a.player.getInventory();

      for (int var5 = 0; var5 < 9; var5++) {
         ItemStack var6 = var4.getStack(var5);
         if (var6.isOf(Items.MACE) && (var3 || (var1 ? i(var6, Enchantments.WIND_BURST) : i(var6, Enchantments.BREACH)))) {
            return var5;
         }
      }

      return -1;
   }

   private static boolean i(ItemStack var0, RegistryKey<Enchantment> var1) {

      for (RegistryEntry var3 : var0.getEnchantments().getEnchantments()) {
         if (var3.matchesKey(var1)) {
            return true;
         }
      }

      return false;
   }

   private void j_r125() {

      this.y = false;
      this.z = -1;
      this.aa = 0L;
      this.ac = -1;
      this.ad = false;
   }
}
