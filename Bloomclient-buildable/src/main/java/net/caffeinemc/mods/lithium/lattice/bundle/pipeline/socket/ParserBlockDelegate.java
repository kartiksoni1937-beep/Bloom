package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.InitNotifier;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.ParserEngine;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.BlockCalculator;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.CheckerBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.ItemDescriptor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.TimingEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.SlotInspector;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.ViewLocator;
import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.block.Blocks;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
public final class ParserBlockDelegate extends BuilderFactory implements InitNotifier {
   private final ItemDescriptor i;
   private final TimingEntry j;
   private final BlockCalculator s;
   private final TimingEntry t;
   private final TimingEntry u;
   private final CheckerBridge v;
   private final BlockCalculator w;
   private final BlockCalculator x;
   private int y;
   private boolean z;
   private int aa;
   private long ab;
   private static int ac = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   public ParserBlockDelegate() {
      super("", "", ParserEngine.V2);
      this.setName(new char[]{'紞', '絗', '緷', '緂', '綴', '継', '繱', '縓', '縓', '縟', '绳', '织', '纡', '纟'}, 1908899162, new char[0], -1592878033);
      ItemDescriptor var10001 = new ItemDescriptor("", 71, false);
      var10001.n(new char[]{'鋝', '銕', '銹', '銍', '鍱', '鍁', '錷', '錁', '鏱', '鎓', '鎙', '鎔', '鑩'}, 1032884892);
      this.i = var10001;
      TimingEntry var1 = new TimingEntry("", 0.0, 1050.0, 50.0, 1.0, 50.0, 50.0);
      var1.n(new char[]{'פ', '\u05f8', 'ւ', 'ٽ', 'ه', 'ر', 'ؙ', 'ڰ', '۫', 'ګ', 'ځ', 'ݭ', 'ݒ'}, 162465207);
      this.j = var1;
      BlockCalculator var2 = new BlockCalculator("", 1.0, 9.0, 1.0, 1.0);
      var2.n(new char[]{'\u2d69', '\u2d72', 'ⴔ', 'ⷮ', 'ⷜ', 'ⶵ', '\u2dd7', '⹅', '⹙', '⸻', '⸇'}, 216214845);
      this.s = var2;
      TimingEntry var3 = new TimingEntry("", 0.0, 2500.0, 0.0, 1.0);
      var3.n(
         new char[]{
            '\uf006',
            '\uf05d',
            '\uf0f3',
            '\uf0df',
            '\uf0b4',
            '\uf080',
            '\uf163',
            '\uf10d',
            '\uf108',
            '\uf10e',
            '\uf1e6',
            '\uf1c8',
            '\uf1b1',
            '\uf1c7',
            '\uf24b',
            '\uf24c',
            '\uf22a'
         },
         -258609068
      );
      this.t = var3;
      TimingEntry var4 = new TimingEntry("", 0.0, 5000.0, 0.0, 1.0);
      var4.n(new char[]{'ၑ', 'ဌ', 'ဠ', 'ဎ', 'ရ', 'ჱ', 'ა', 'ჼ', 'Ⴟ', 'ᅿ', 'ᅕ', 'ᄹ', 'ᄎ', 'ᆶ', 'ᇸ', 'ᆵ', 'ᆋ'}, 2071793667);
      this.u = var4;
      CheckerBridge var5 = new CheckerBridge("", false);
      var5.n(new char[]{'⇙', 'ↄ', '↨', 'ↆ', '≣', '≉', '∨', '≄', '⋄', '⋎', '⊮', '⊗', '⊌', '⍪', '⍒', '⌲', '⌞'}, -851828341);
      this.v = var5;
      BlockCalculator var6 = new BlockCalculator("", 1.0, 4.0, 1.0, 1.0);
      var6.n(new char[]{'︣', 'ﺾ', 'ﻎ', 'ﺠ', 'ﺉ', 'Ｌ', 'ｬ', 'Ｆ', '＆', '\uffff', 'ﾇ', 'ﾋ', 'ﾌ', 'j'}, -612565391);
      this.w = var6;
      BlockCalculator var7 = new BlockCalculator("", 1.0, 4.0, 4.0, 1.0);
      var7.n(new char[]{'伡', '侼', '俐', '侾', '例', '倮', '偪', '倠', '倄', '僽', '傉', '傅', '傆', '兾'}, 1196707699);
      this.x = var7;
      this.y = 0;
      this.z = false;
      this.aa = 0;
      this.ab = -1L;
      this.a(new InitAdapter[]{this.i, this.j, this.s, this.t, this.u, this.v, this.w, this.x});
   }

   @Override
   public void c() {

      this.b.a(InitNotifier.class, this);
      this.y = 0;
      this.z = false;
      this.e_r115();
      super.c();
   }

   @Override
   public void d() {

      this.z = false;
      this.e_r115();
      this.b.b(InitNotifier.class, this);
      super.d();
   }

   @Override
   public void a() {

      if (a.player != null && a.world != null && a.currentScreen == null) {
         if (this.b() && (this.z || this.c_r69())) {
            if (!(a.crosshairTarget instanceof BlockHitResult var1) || var1.getType() != HitResult.Type.BLOCK) {
               return;
            }

            if (this.y == 0 && a.world.getBlockState(var1.getBlockPos()).isOf(Blocks.RESPAWN_ANCHOR)) {
               this.z = false;
               this.e_r115();
            } else {
               double var6 = this.j.p();
               int var4 = (int)this.t.p();
               int var5 = (int)this.u.p();
               if (var5 > var4) {
                  if (this.aa == 0) {
                     this.aa = h(var4, var5);
                  }

                  var6 += (double)this.aa;
               }

               if (this.d(var6)) {
                  this.e_r115();
                  switch (this.y) {
                     case 0:
                        ViewLocator.a(Items.RESPAWN_ANCHOR);
                        break;
                     case 1:
                        this.f(var1);
                        break;
                     case 2:
                        ViewLocator.a(Items.GLOWSTONE);
                        break;
                     case 3:
                        this.a(var1);
                        break;
                     case 4:
                        ViewLocator.a(Items.RESPAWN_ANCHOR);
                        break;
                     case 5:
                        this.f(var1);
                        this.f(var1);
                        break;
                     case 6:
                        ViewLocator.a(Items.GLOWSTONE);
                        break;
                     case 7:
                        this.a(var1);
                        break;
                     case 8:
                        this.g(this.s.g() - 1);
                        break;
                     case 9:
                        this.f(var1);
                        break;
                     case 10:
                        this.z = false;
                        this.y = 0;
                        this.e_r115();
                        return;
                  }

                  this.y++;
               }
            }
         }
      }
   }

   private void a(BlockHitResult var1) {
      int var2 = 0;
      int var3 = 0;
      int var4 = 0;
      byte var5 = 0;

      while (true) {
         switch (var5) {
            case 0:
            default:
               if (ac != 0) {
                  Math.abs(Integer.MIN_VALUE);
                  var5 = 4;
                  break;
               }
            case 4:
               var2 = 1;
               if (this.v.f()) {
                  var3 = Math.max(1, Math.min(this.w.g(), 4));
                  var4 = Math.max(var3, Math.min(this.x.g(), 4));
                  var2 = h(var3, var4);
                  var5 = 1;
                  break;
               }
            case 1:
               var3 = 0;
               var5 = 2;
               break;
            case 2:
               if (var3 < var2) {
                  this.f(var1);
                  var3++;
                  var5 = 2;
                  break;
               }

               return;
            case 3:
               return;
         }
      }
   }

   private boolean b() {

      boolean var1 = false;
      boolean var2 = false;

      for (int var3 = 0; var3 < 9; var3++) {
         ItemStack var4 = a.player.getInventory().getStack(var3);
         if (var4.isOf(Items.RESPAWN_ANCHOR)) {
            var1 = true;
         }

         if (var4.isOf(Items.GLOWSTONE)) {
            var2 = true;
         }
      }

      return var1 && var2;
   }

   private boolean c_r69() {

      int var1 = this.i.g();
      if (var1 != -1 && SlotInspector.a(var1)) {
         this.z = true;
         return true;
      } else {
         this.e_r115();
         return false;
      }
   }

   private boolean d(double var1) {

      long var3 = System.currentTimeMillis();
      if (this.ab < 0L) {
         this.ab = var3;
      }

      return var3 - this.ab >= (long)var1;
   }

   private void e_r115() {

      this.ab = -1L;
      this.aa = 0;
   }

   private void f(BlockHitResult var1) {

      if (a.interactionManager != null) {
         a.interactionManager.interactBlock(a.player, Hand.MAIN_HAND, var1);
         a.player.swingHand(Hand.MAIN_HAND);
      }
   }

   private void g(int var1) {

      if (var1 >= 0 && var1 < 9) {
         ViewLocator.a(var1);
      }
   }

   private static int h(int var0, int var1) {

      return var0 >= var1 ? var0 : var0 + (int)(Math.random() * (double)(var1 - var0 + 1));
   }
}
