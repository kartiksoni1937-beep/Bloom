package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket;

import java.util.HashSet;
import java.util.Set;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.BufferEncoder;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.CalculateRange;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.InitNotifier;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.ParserEngine;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.BlockCalculator;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.CheckerBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.TimingEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.BufferNormalizer;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.CalculateMapper;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.FrameClockCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.GridResolver;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.InitExecutor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.SlotInspector;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.ViewLocator;
import net.minecraft.util.Hand;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ShieldItem;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.block.BlockState;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.block.RespawnAnchorBlock;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.util.hit.HitResult;
public class ProcessorModule extends BuilderFactory implements InitNotifier, CalculateRange {
   private final CheckerBridge aa;
   private final CheckerBridge ab;
   private final CheckerBridge ac;
   private final TimingEntry ad;
   private final BlockCalculator ae;
   private final BlockCalculator af;
   private final TimingEntry ag;
   private final BlockCalculator ah;
   private final TimingEntry ai;
   private final BlockCalculator aj;
   private final BlockCalculator ak;
   private final CheckerBridge al;
   private final CheckerBridge am;
   private final CheckerBridge an;
   private final BlockCalculator ao;
   private final BlockCalculator ap;
   private boolean aq;
   private long ar;
   private int as;
   private boolean at;
   private long au;
   private int av;
   private boolean aw;
   private long ax;
   private int ay;
   private long az;
   private int ba;
   private int bb;
   private boolean bc;
   private boolean bd;
   private final Set<BlockPos> be;
   private final Runnable bf;
   private boolean bg;
   private long bh;
   private int bi;
   private int bj;
   private int bk;
   private int bl;
   private boolean bm;
   private int bn;
   private boolean bo;
   private int bp;

   public ProcessorModule() {
      super("", "", ParserEngine.V2);
      this.setName(new char[]{'팉', '퍉', '폨', '폆', '펬', '펌', '푰', '퐁', '퐍', '퐾', '퐝', '퓯', '퓓', '퓻', '풬', '픫'}, -1338518712, new char[0], -2102178957);
      CheckerBridge var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'雃', '隝', '隺', '隘', '靼', '靊', '靮', '霸', '響', '韎'}, -844327276);
      this.aa = var10001;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'ꕙ', 'ꔇ', 'ꔼ', 'ꔈ', 'ꗶ', 'ꖅ', 'ꖫ', 'ꖍ', '꘢', 'Ꙫ', '꘩', '\ua633', 'ꘒ'}, 415212810);
      this.ab = var10001;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'뜧', '랭', '럎', '램', '랃', '랔', '렾', '롮', '렵', '렖', '룯', '룕', '뢹', '뢃', '륿', '륚', '뤺'}, 1583265636);
      this.ac = var10001;
      TimingEntry var3 = new TimingEntry("", 0.0, 1050.0, 50.0, 1.0, 50.0, 50.0);
      var3.n(new char[]{'娑', '婏', '嫷', '嫶', '嫊', '媾', '媔', '嬻', '孾', '嬼', '嬔', '寶', '寏'}, -1893311934);
      this.ad = var3;
      BlockCalculator var4 = new BlockCalculator("", 0.0, 100.0, 100.0, 1.0);
      var4.n(new char[]{'㟁', '㞟', '㞧', '㞆', '㡺', '㡎', '㠤', '㡋', '㣉', '㣁', '㢩', '㢉', '㥥', '㥀'}, 1436235666);
      this.ae = var4;
      BlockCalculator var5 = new BlockCalculator("", 0.0, 100.0, 100.0, 1.0);
      var5.n(new char[]{'県', '睕', '矶', '矘', '瞻', '瞒', '砶', '硶', '砼', '砒', '磼', '磒', '碵'}, -974227620);
      this.af = var5;
      TimingEntry var6 = new TimingEntry("", 0.0, 1050.0, 50.0, 1.0, 50.0, 50.0);
      var6.n(new char[]{'蝍', '蜇', '蜤', '蜈', '蟱', '蟖', '螰', '螌', '衬', '衄', '衠', '蠛', '蠛', '裱', '裝', '袢'}, -1721202934);
      this.ag = var6;
      BlockCalculator var7 = new BlockCalculator("", 0.0, 100.0, 100.0, 1.0);
      var7.n(new char[]{'ﶫ', '︥', '﹆', '︦', '\ufe1f', 'ﻴ', 'ﻒ', 'ﺪ', 'ﺊ', 'ｦ', '＂', '＂', '（', '＞', '\ufff0', '\uffde', 'ﾹ'}, -1833894420);
      this.ah = var7;
      TimingEntry var8 = new TimingEntry("", 0.0, 1050.0, 50.0, 1.0, 50.0, 50.0);
      var8.n(new char[]{'虉', '蘅', '蘲', '蘙', '蛤', '蛈', '蚢', '蚀', '蜤', '蝧', '蜧', '蜍', '蟡', '蟦'}, -666139124);
      this.ai = var8;
      BlockCalculator var9 = new BlockCalculator("", 0.0, 100.0, 100.0, 1.0);
      var9.n(new char[]{'䏘', '䎒', '䎣', '䎊', '䑵', '䑗', '䐳', '䐓', '䒵', '䓷', '䒻', '䒓', '䕿', '䕓', '䔪'}, 2006401949);
      this.aj = var9;
      BlockCalculator var10 = new BlockCalculator("", 1.0, 9.0, 1.0, 1.0);
      var10.n(new char[]{'팿', '펷', '폀', '펧', '펚', '푺', '푐', '퐶', '푒', '퓂', '퓜', '풠', '풚'}, -1164455046);
      this.ak = var10;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'鎢', '鐢', '鑅', '鐦', '鐐', '钨', '铨', '钱', '钋'}, -731933715);
      this.al = var10001;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'ↆ', '⇆', '≩', '≊', '∼', '≄', '⋀', '⋊', '⊠', '⊒', '⊘', '⍻'}, 1555767753);
      this.am = var10001;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'냪', '냹', '낗', '녻', '념', '넼', '넟', '놱', '뇷', '놣', '놁', '뉺', '뉟', '눿', '눅', '닧', '닍'}, -252661576);
      this.an = var10001;
      BlockCalculator var14 = new BlockCalculator("", 1.0, 4.0, 1.0, 1.0);
      var14.n(new char[]{'搆', '摝', '擳', '擟', '撴', '擏', '敉', '敁', '攣', '攜', '斪', '旤', '斡', '斉'}, 1705010260);
      this.ao = var14;
      BlockCalculator var15 = new BlockCalculator("", 1.0, 4.0, 4.0, 1.0);
      var15.n(new char[]{'㎜', '㏃', '㑭', '㑅', '㐮', '㑉', '㓏', '㓋', '㒩', '㒒', '㔤', '㕮', '㔣', '㔙'}, -40160306);
      this.ap = var15;
      this.be = new HashSet<>();
      this.bf = this::b;
      this.bi = Integer.MIN_VALUE;
      this.bj = Integer.MIN_VALUE;
      this.bk = Integer.MIN_VALUE;
      this.bl = Integer.MIN_VALUE;
      this.bp = -1073741824;
      this.a(
         new InitAdapter[]{
            this.aa, this.ab, this.ac, this.af, this.ad, this.ae, this.ag, this.ah, this.ai, this.aj, this.ak, this.al, this.am, this.an, this.ao, this.ap
         }
      );
   }

   @Override
   public void c() {

      this.b.a(InitNotifier.class, this);
      this.b.a(CalculateRange.class, this);
      this.aq = false;
      this.at = false;
      this.aw = false;
      this.az = System.nanoTime() - 1000000000L;
      this.ba = this.bn - (-193259579 ^ -193260499);
      this.bc = false;
      this.bg = false;
      this.bi = -90403299 ^ 2057080349;
      this.bj = 1247983245 ^ -899500403;
      this.bk = -1590975530 ^ 556508118;
      this.bl = -1409950390 ^ 737533258;
      this.bp = -708470318 ^ 365271506;
      this.bo = false;
      FrameClockCache.add(this.bf);
      super.c();
   }

   @Override
   public void d() {

      FrameClockCache.b(this.bf);
      this.bg = false;
      this.b.b(InitNotifier.class, this);
      this.b.b(CalculateRange.class, this);
      super.d();
   }

   @Override
   public void a() {

      this.bn++;
      this.bo = true;
      this.e_r116();
      this.bo = false;
   }

   private void b() {

      this.bo = false;
      if (this.bg && System.nanoTime() - this.bh >= 0L) {
         ClientPlayerEntity var1 = a.player;
         if (var1 != null && var1.age != this.bi) {
            this.e_r116();
         }
      }
   }

   private void e_r116() {

      this.bd = this.bc;
      this.bc = false;
      this.bg = false;
      if (FrameClockCache.n) {
         if (a.player != null
            && a.world != null
            && a.interactionManager != null
            && a.currentScreen == null
            && SlotInspector.a(1)
            && (
               !a.player.getMainHandStack().getItem().getComponents().contains(DataComponentTypes.FOOD)
                     && !(a.player.getMainHandStack().getItem() instanceof ShieldItem)
                     && !(a.player.getOffHandStack().getItem() instanceof ShieldItem)
                     && !a.player.getOffHandStack().getItem().getComponents().contains(DataComponentTypes.FOOD)
                  || this.aa.f()
            )
            && (this.aa.f() || !a.player.isUsingItem())
            && (!this.ab.f() || !GridResolver.a())
            && a.crosshairTarget instanceof BlockHitResult var1) {
            BlockPos var5 = var1.getBlockPos();
            BlockState var3 = a.world.getBlockState(var5);
            if (var3.isOf(Blocks.FIRE) || var3.isOf(Blocks.SOUL_FIRE)) {
               BlockPos var4 = var5.down();
               var3 = a.world.getBlockState(var4);
               if (var3.isOf(Blocks.RESPAWN_ANCHOR)) {
                  var5 = var4;
                  var1 = new BlockHitResult(var1.getPos(), var1.getSide(), var4, var1.isInsideBlock());
               }
            }

            if (var3.isOf(Blocks.RESPAWN_ANCHOR) && (!this.al.f() || this.be.contains(var5))) {
               int var6 = (Integer)var3.get(RespawnAnchorBlock.CHARGES);
               a.options.useKey.setPressed(false);
               if (a.player.age == this.bj) {
                  this.s(a.player);
               } else if (var6 == 0) {
                  this.f(var1, var5);
               } else if (var6 > 0) {
                  this.g(var1, var5);
               }
            }
         }
      }
   }

   private void f(BlockHitResult var1, BlockPos var2) {

      ClientPlayerEntity var3 = a.player;
      boolean var4 = this.q(var3);
      if (!var3.getMainHandStack().isOf(Items.GLOWSTONE)) {
         if (!this.aq) {
            this.aq = true;
            this.ar = this.h(this.ad);
            this.as = this.bb;
         }

         if (!this.k(this.ar, this.as)) {
            this.r(this.ar);
            return;
         }

         if (!var4) {
            this.s(var3);
            return;
         }

         if (!FrameClockCache.i(var3)) {
            if (this.n(Items.GLOWSTONE) >= 0) {
               this.p(var3);
            }

            this.s(var3);
            return;
         }

         int var5 = CalculateMapper.a(1, 100);
         if (var5 > this.ae.g()) {
            this.t(var3);
            return;
         }

         this.aq = false;
         if (!ViewLocator.a(Items.GLOWSTONE)) {
            return;
         }

         this.i(this.ar);
         if (this.ag.p() > 50.0) {
            return;
         }

         this.at = true;
         this.au = this.j_r117();
         this.av = this.ba;
      }

      if (!this.at) {
         this.at = true;
         this.au = this.h(this.ag);
         this.av = this.bb;
      }

      if (!this.k(this.au, this.av)) {
         this.r(this.au);
      } else if (!var4) {
         this.s(var3);
      } else if (this.o(var3)) {
         this.s(var3);
      } else {
         int var9 = CalculateMapper.a(1, 100);
         if (var9 <= this.ah.g()) {
            this.at = false;
            int var6 = 1;
            if (this.an.f()) {
               int var7 = Math.max(1, Math.min(this.ao.g(), 4));
               int var8 = Math.max(var7, Math.min(this.ap.g(), 4));
               var6 = CalculateMapper.a(var7, var8);
            }

            // Validate the target before charging: it must still be an uncharged anchor
            // with solid support, otherwise the packet is physically impossible.
            if (!a.world.getBlockState(var2).isOf(Blocks.RESPAWN_ANCHOR)
               || (Integer)a.world.getBlockState(var2).get(RespawnAnchorBlock.CHARGES) != 0
               || a.world.getBlockState(var2.down()).isAir()) {
               this.t(var3);
               return;
            }

            for (int var10 = 0; var10 < var6; var10++) {
               if (this.ac.f()) {
                  BufferNormalizer.d(1);
               }

               a.interactionManager.interactBlock(a.player, Hand.MAIN_HAND, var1);
               a.player.swingHand(Hand.MAIN_HAND);
            }

            this.i(this.au);
         } else {
            this.t(var3);
         }
      }
   }

   private void g(BlockHitResult var1, BlockPos var2) {

      ClientPlayerEntity var3 = a.player;
      int var4 = this.ak.g() - 1;
      if (InitExecutor.a(var3.getInventory()) != var4) {
         if (!this.aq) {
            this.aq = true;
            this.ar = this.h(this.ad);
            this.as = this.bb;
         }

         if (!this.k(this.ar, this.as)) {
            this.r(this.ar);
            return;
         }

         if (!FrameClockCache.i(var3)) {
            this.p(var3);
            this.s(var3);
            return;
         }

         int var5 = CalculateMapper.a(1, 100);
         if (var5 > this.ae.g()) {
            this.t(var3);
            return;
         }

         this.aq = false;
         InitExecutor.a(var3.getInventory(), var4);
         this.i(this.ar);
         if (this.ai.p() > 50.0) {
            return;
         }

         this.aw = true;
         this.ax = this.j_r117();
         this.ay = this.ba;
      }

      if (!this.aw) {
         this.aw = true;
         this.ax = this.h(this.ai);
         this.ay = this.bb;
      }

      if (!this.k(this.ax, this.ay)) {
         this.r(this.ax);
      } else {
         boolean var7 = !this.am.f();
         if (var7 && var3.age == this.bk) {
            this.s(var3);
         } else if (var7 && this.o(var3)) {
            this.s(var3);
         } else {
            int var6 = CalculateMapper.a(1, 100);
            if (var6 <= this.aj.g()) {
               this.aw = false;
               if (var7) {
                  // Only detonate an anchor that still exists and actually has charges.
                  if (!a.world.getBlockState(var2).isOf(Blocks.RESPAWN_ANCHOR)
                     || (Integer)a.world.getBlockState(var2).get(RespawnAnchorBlock.CHARGES) <= 0) {
                     this.t(var3);
                     return;
                  }

                  if (this.ac.f()) {
                     BufferNormalizer.d(1);
                  }

                  a.interactionManager.interactBlock(a.player, Hand.MAIN_HAND, var1);
                  a.player.swingHand(Hand.MAIN_HAND);
                  this.be.remove(var2);
                  this.bk = var3.age;
                  this.i(this.ax);
               }
            } else {
               this.t(var3);
            }
         }
      }
   }

   private long h(TimingEntry var1) {

      long var2 = System.nanoTime() - 50000000L;
      if (this.az - var2 > 0L) {
         var2 = this.az;
      }

      int var4 = this.l_r118() - 1;
      if (this.ba - var4 > 0) {
         var4 = this.ba;
      }

      this.bb = var4 + m(var1.p());
      return var2 + var1.ns();
   }

   private void i(long var1) {

      long var3 = System.nanoTime();
      long var5 = var3 - var1;
      long var7 = var5 >= 0L && (!this.bd || var5 > 50000000L) ? var3 : var1;
      if (var7 - this.az > 0L) {
         this.az = var7;
      }

      int var9 = this.l_r118();
      if (var9 - this.ba > 0) {
         this.ba = var9;
      }

      this.u();
   }

   private long j_r117() {

      long var1 = System.nanoTime();
      return this.az - var1 < 0L ? this.az : var1;
   }

   private boolean k(long var1, int var3) {

      return this.bo && this.bn - var3 >= 0 || System.nanoTime() - var1 >= 0L;
   }

   private int l_r118() {

      return this.bo ? this.bn : this.bn + 1;
   }

   private static int m(double var0) {

      return (int)Math.ceil(var0 / 50.0);
   }

   private int n(Item var1) {

      for (int var2 = 0; var2 < 9; var2++) {
         if (a.player.getInventory().getStack(var2).isOf(var1)) {
            return var2;
         }
      }

      return -1;
   }

   private boolean o(ClientPlayerEntity var1) {

      return FrameClockCache.k(var1) && var1.age != this.bp + 1;
   }

   private void p(ClientPlayerEntity var1) {

      FrameClockCache.j(var1);
      this.bp = var1.age;
   }

   private boolean q(ClientPlayerEntity var1) {

      if (var1.age != this.bl) {
         this.bl = var1.age;
         this.bm = CalculateMapper.a(1, 100) <= this.af.g();
      }

      return this.bm;
   }

   private void r(long var1) {

      this.bg = true;
      this.bh = var1;
      this.bc = true;
   }

   private void s(ClientPlayerEntity var1) {

      this.bi = var1.age;
      this.bg = true;
      this.bh = System.nanoTime();
   }

   private void t(ClientPlayerEntity var1) {

      this.bj = var1.age;
      this.s(var1);
   }

   private void u() {

      this.bg = true;
      this.bh = System.nanoTime();
      this.bc = true;
   }

   @Override
   public void a(BufferEncoder var1) {

      if (a.player != null && a.world != null) {
         if (a.crosshairTarget instanceof BlockHitResult var2 && var2.getType() == HitResult.Type.BLOCK) {
            if (a.player.getMainHandStack().isOf(Items.RESPAWN_ANCHOR)) {
               Direction var5 = var2.getSide();
               BlockPos var4 = var2.getBlockPos();
               if (!a.world.getBlockState(var4).isAir()) {
                  this.be.add(var4.offset(var5));
               } else {
                  this.be.add(var4);
               }
            }

            BlockPos var6 = var2.getBlockPos();
            if (a.world.getBlockState(var6).isOf(Blocks.RESPAWN_ANCHOR)) {
               int var7 = (Integer)a.world.getBlockState(var6).get(RespawnAnchorBlock.CHARGES);
               if (var7 > 0) {
                  this.be.remove(var6);
               }
            }
         }

         if (this.v()) {
            var1.b();
         }
      }
   }

   private boolean v() {

      if (a.crosshairTarget instanceof BlockHitResult var1 && var1.getType() == HitResult.Type.BLOCK) {
         BlockPos var3 = var1.getBlockPos();
         if (a.world.getBlockState(var3).isOf(Blocks.FIRE) || a.world.getBlockState(var3).isOf(Blocks.SOUL_FIRE)) {
            var3 = var3.down();
         }

         if (!a.world.getBlockState(var3).isOf(Blocks.RESPAWN_ANCHOR)) {
            return false;
         }

         if (a.player.getMainHandStack().isOf(Items.RESPAWN_ANCHOR)) {
            return false;
         }

         if (this.al.f() && !this.be.contains(var3)) {
            return false;
         }

         if ((Integer)a.world.getBlockState(var3).get(RespawnAnchorBlock.CHARGES) > 0 && this.am.f()) {
            return false;
         }

         return this.w();
      }

      return false;
   }

   private boolean w() {

      if (a.currentScreen == null && SlotInspector.a(1)) {
         boolean var1 = a.player.getMainHandStack().getItem().getComponents().contains(DataComponentTypes.FOOD)
            || a.player.getMainHandStack().getItem() instanceof ShieldItem
            || a.player.getOffHandStack().getItem() instanceof ShieldItem
            || a.player.getOffHandStack().getItem().getComponents().contains(DataComponentTypes.FOOD);
         if (var1 && !this.aa.f()) {
            return false;
         } else {
            return !this.aa.f() && a.player.isUsingItem() ? false : !this.ab.f() || !GridResolver.a();
         }
      } else {
         return false;
      }
   }
}
