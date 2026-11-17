package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource;

import java.util.HashSet;
import java.util.Set;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.BufferEncoder;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.InitNotifier;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.ParserEngine;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.BlockCalculator;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.CheckerBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.ItemDescriptor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.TimingEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.BufferNormalizer;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.CalculateMapper;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.FrameClockCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.GridResolver;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.AnchorSequence;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.InitExecutor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.SlotInspector;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.TaskJoiner;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.ViewLocator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ShieldItem;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.block.RespawnAnchorBlock;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.util.hit.HitResult;
public final class BufferState extends BuilderFactory implements InitNotifier, net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.CalculateRange {
   private final ItemDescriptor aa;
   private final CheckerBridge ab;
   private final CheckerBridge ac;
   private final CheckerBridge ad;
   private final TimingEntry ae;
   private final BlockCalculator af;
   private final BlockCalculator ag;
   private final TimingEntry ah;
   private final BlockCalculator ai;
   private final TimingEntry aj;
   private final BlockCalculator ak;
   private final BlockCalculator al;
   private final CheckerBridge am;
   private final CheckerBridge an;
   private final CheckerBridge ao;
   private final BlockCalculator ap;
   private final BlockCalculator aq;
   private long ar;
   private int as;
   private long at;
   private int au;
   private int av;
   private long aw;
   private int ax;
   private final Set<BlockPos> ay;
   private final Runnable az;
   private boolean ba;
   private long bb;
   private int bc;
   private int bd;
   private int be;
   private int bf;
   private boolean bg;
   private int bh;

   public BufferState() {
      super("", "", ParserEngine.CT);
      this.setName(
         new char[]{'\uddfa', '\uddf4', '\udd97', '\ude7b', '\ude5f', '\ude39', '\ude07', '\udeb4', '\udefe', '\udeb3', '\ude92', '\udf62', '\udf40'},
         1847778747,
         new char[0],
         406535707
      );
      ItemDescriptor var10001 = new ItemDescriptor("", 1, false);
      var10001.n(new char[]{'ⱃ', 'Ⰿ', 'Ⱓ', 'Ⱛ', 'Ⱇ', 'Ⳬ', 'ⳝ', 'ⲯ', 'ⲟ', 'ⴹ', '\u2d73', 'ⴲ', 'ⴏ'}, -921555966);
      this.aa = var10001;
      CheckerBridge var1 = new CheckerBridge("", true);
      var1.n(new char[]{'☦', '⚾', '⛇', '⚧', '⚁', '❩', '✋', '✟', '✚', '⟭'}, -1139399055);
      this.ab = var1;
      CheckerBridge var2 = new CheckerBridge("", false);
      var2.n(new char[]{'ഢ', '\u0dbe', 'ෛ', 'ඡ', 'ඝ', 'ฬ', 'ไ', 'ฤ', '้', 'ໃ', '໎', 'ສ', 'ຉ'}, -1388901007);
      this.ac = var2;
      CheckerBridge var3 = new CheckerBridge("", false);
      var3.n(new char[]{'༶', 'ྺ', '\u0fdf', 'ྻ', 'ྒ', 'ၻ', 'ဏ', 'ဝ', 'င', 'ს', 'პ', 'Ⴆ', 'ႈ', 'ᅼ', 'ᅎ', 'ᄩ', 'ᄋ'}, 575213429);
      this.ad = var3;
      TimingEntry var4 = new TimingEntry("", 0.0, 1000.0, 0.0, 1.0);
      var4.n(new char[]{'\u0c29', 'ಷ', '\u0ccf', 'ಾ', 'ಂ', '൶', '൜', '൳', 'ശ', '෴', 'ො', 'ථ', '\u0d97'}, 2134838394);
      this.ae = var4;
      BlockCalculator var5 = new BlockCalculator("", 0.0, 100.0, 100.0, 1.0);
      var5.n(new char[]{'׆', '֚', '֤', '֛', '٥', 'ٓ', 'ا', 'َ', 'ێ', 'ۄ', 'ڪ', 'ڄ', 'ݪ', 'ݍ'}, 1477969301);
      this.af = var5;
      BlockCalculator var6 = new BlockCalculator("", 0.0, 100.0, 100.0, 1.0);
      var6.n(new char[]{'杩', '杶', '望', '柷', '柖', '枱', '染', '桑', '桙', '栱', '栁', '棭', '棈'}, 1627547449);
      this.ag = var6;
      TimingEntry var7 = new TimingEntry("", 0.0, 1000.0, 0.0, 1.0);
      var7.n(new char[]{'ꑤ', 'ꑬ', 'ꐍ', 'ꓯ', 'ꓨ', '\ua4cd', '꒩', '꒓', 'ꕵ', 'ꕟ', 'ꕹ', 'ꔼ', 'ꗲ', 'ꗚ', 'ꖴ', 'ꖍ'}, 1939579939);
      this.ah = var7;
      BlockCalculator var8 = new BlockCalculator("", 0.0, 100.0, 100.0, 1.0);
      var8.n(
         new char[]{'\u09e5', '৯', 'ঌ', 'ঐ', '੩', '\u0a4e', 'ਨ', 'ਔ', '\u0af4', '\u0adc', '\u0af8', '\u0ab4', '\u0b7e', '\u0b54', '\u0b3a', 'ଐ', '௷'},
         2081098146
      );
      this.ai = var8;
      TimingEntry var9 = new TimingEntry("", 0.0, 1000.0, 0.0, 1.0);
      var9.n(new char[]{'罋', '缃', '缴', '缛', '翦', '翆', '羬', '羂', '耦', '聡', '耡', '耏', '胣', '胘'}, 542867214);
      this.aj = var9;
      BlockCalculator var10 = new BlockCalculator("", 0.0, 100.0, 100.0, 1.0);
      var10.n(new char[]{'エ', 'ㄢ', 'ㅓ', 'ㄺ', 'ㄅ', '\u31e7', '㇃', 'ㆣ', '㇅', '㉇', '㉋', '㈣', '㈏', '㋣', '㋺'}, -124571411);
      this.ak = var10;
      BlockCalculator var11 = new BlockCalculator("", 1.0, 9.0, 1.0, 1.0);
      var11.n(new char[]{'쾡', '퀭', '큚', '퀱', '퀌', '퀐', '탺', '탘', '탼', '킨', '텶', '텖', '턬'}, -1955541020);
      this.al = var11;
      CheckerBridge var12 = new CheckerBridge("", false);
      var12.n(new char[]{'넥', '놧', '뇆', '놫', '놟', '눥', '뉫', '눴', '눌'}, -409685654);
      this.am = var12;
      CheckerBridge var13 = new CheckerBridge("", false);
      var13.n(new char[]{'汐', '氐', '氳', '氐', '波', '沚', '沚', '沐', '浶', '浄', '洲', '洑'}, -1894945761);
      this.an = var13;
      CheckerBridge var14 = new CheckerBridge("", false);
      var14.n(new char[]{'ꁁ', 'ꀜ', 'ꀰ', 'ꀞ', 'ꃫ', 'ꃁ', 'ꂠ', 'ꃌ', 'ꅌ', 'ꅆ', 'ꄦ', 'ꄟ', 'ꇴ', 'ꇒ', 'ꆪ', 'ꆊ', 'ꉦ'}, -1654480877);
      this.ao = var14;
      BlockCalculator var15 = new BlockCalculator("", 1.0, 4.0, 1.0, 1.0);
      var15.n(new char[]{'칗', '츊', '츢', '츌', '컥', '캀', '컸', '캲', '캒', '콫', '켛', '켗', '켐', '쿶'}, 1776406021);
      this.ap = var15;
      BlockCalculator var16 = new BlockCalculator("", 1.0, 4.0, 4.0, 1.0);
      var16.n(new char[]{'쏀', '쎟', '쎱', '쎁', '쑪', '쐍', '쐋', '쐇', '쓥', '쓞', '쓨', '쒪', '앧', '앝'}, 1548469138);
      this.aq = var16;
      this.av = 0;
      this.ay = new HashSet<>();
      this.az = this::b;
      this.bc = Integer.MIN_VALUE;
      this.bd = Integer.MIN_VALUE;
      this.be = Integer.MIN_VALUE;
      this.bh = -1073741824;
      this.a(
         new InitAdapter[]{
            this.aa,
            this.ab,
            this.ac,
            this.ad,
            this.ag,
            this.ae,
            this.af,
            this.ah,
            this.ai,
            this.aj,
            this.ak,
            this.al,
            this.am,
            this.an,
            this.ao,
            this.ap,
            this.aq
         }
      );
   }

   @Override
   public void c() {

      this.b.a(InitNotifier.class, this);
      this.b.a(net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.CalculateRange.class, this);
      this.h_r97();
      this.av = 0;
      this.ba = false;
      this.bc = 1846662195 ^ -300821453;
      this.bd = -1414616701 ^ 732866947;
      this.be = -1101690813 ^ 1045792835;
      this.bh = -1277803171 ^ 1943422301;
      this.bg = false;
      FrameClockCache.add(this.az);
      super.c();
   }

   @Override
   public void d() {

      FrameClockCache.b(this.az);
      this.ba = false;
      this.b.b(InitNotifier.class, this);
      this.b.b(net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.CalculateRange.class, this);
      super.d();
   }

   @Override
   public void a() {

      this.bf++;
      this.bg = true;
      this.e_r96();
      this.bg = false;
   }

   private void b() {

      this.bg = false;
      if (this.ba && System.nanoTime() - this.bb >= 0L) {
         ClientPlayerEntity var1 = a.player;
         if (var1 != null && var1.age != this.bc) {
            this.e_r96();
         }
      }
   }

   private void e_r96() {

      this.ba = false;
      if (FrameClockCache.n) {
         if (a.player != null
            && a.world != null
            && a.interactionManager != null
            && a.currentScreen == null
            && (
               !a.player.getMainHandStack().getItem().getComponents().contains(DataComponentTypes.FOOD)
                     && !(a.player.getMainHandStack().getItem() instanceof ShieldItem)
                     && !(a.player.getOffHandStack().getItem() instanceof ShieldItem)
                     && !a.player.getOffHandStack().getItem().getComponents().contains(DataComponentTypes.FOOD)
                  || !SlotInspector.a(1)
                  || this.ab.f()
            )
            && (!this.ac.f() || !GridResolver.a())
            && !a.player.isUsingItem()) {
            boolean var1 = true;
            if (this.aa.g() != -1) {
               var1 = SlotInspector.a(this.aa.g());
            }

            if (!var1) {
               this.h_r97();
            } else if (a.crosshairTarget instanceof BlockHitResult var2 && var2.getType() == HitResult.Type.BLOCK) {
               BlockPos var4 = var2.getBlockPos();
               if (TaskJoiner.a(var4, Blocks.RESPAWN_ANCHOR)) {
                  if (this.am.f() && !this.ay.contains(var4)) {
                     return;
                  }

                  this.f(var2, var4);
               } else if (a.player.getMainHandStack().isOf(Items.RESPAWN_ANCHOR)
                  && this.k(Items.GLOWSTONE) >= 0
                  && this.g(this.aw, this.ax)) {
                  // 1-tick anchor: place, charge and detonate in one client tick.
                  BlockPos var5 = a.world.getBlockState(var4).isReplaceable() ? var4 : var4.offset(var2.getSide());
                  if (AnchorSequence.placeChargeDetonate(var5)) {
                     this.aw = FrameClockCache.g(this.aj.p());
                     this.ax = this.i_r98() + j(this.aj.p());
                     this.be = a.player.age;
                     this.q();
                  }
               }
            }
         }
      }
   }

   private void f(BlockHitResult var1, BlockPos var2) {

      ClientPlayerEntity var3 = a.player;
      // 1-tick anchor: charge and detonate the anchor with sequenced raw packets.
      if (this.u(var2) && this.g(this.at, this.au) && AnchorSequence.chargeDetonate(var2)) {
         this.at = FrameClockCache.g(this.ah.p());
         this.au = this.i_r98() + j(this.ah.p());
         this.be = var3.age;
         this.q();
         return;
      }

      if (var3.age == this.bd) {
         this.o(var3);
      } else {
         if (this.u(var2)) {
            if (!this.g(this.ar, this.as)) {
               this.n(this.ar);
               return;
            }

            boolean var4 = var3.getMainHandStack().isOf(Items.GLOWSTONE);
            if (var4 && !this.g(this.at, this.au)) {
               this.n(this.at);
               return;
            }

            if (!var4 && !FrameClockCache.i(var3)) {
               if (this.k(Items.GLOWSTONE) >= 0) {
                  this.m(var3);
               }

               this.o(var3);
               return;
            }

            if (var4 && this.l(var3)) {
               this.o(var3);
               return;
            }

            if (CalculateMapper.a(1, 100) > this.ag.g()) {
               this.p(var3);
               return;
            }

            if (!var4) {
               if (CalculateMapper.a(1, 100) > this.af.g()) {
                  this.p(var3);
                  return;
               }

               if (ViewLocator.a(Items.GLOWSTONE)) {
                  this.ar = FrameClockCache.g(this.ae.p());
                  this.as = this.i_r98() + j(this.ae.p());
                  this.q();
               }

               return;
            }

            if (CalculateMapper.a(1, 100) > this.ai.g()) {
               this.p(var3);
               return;
            }

            if (this.ao.f() && this.av <= 0) {
               int var5 = Math.max(1, Math.min(this.ap.g(), 4));
               int var6 = Math.max(var5, Math.min(this.aq.g(), 4));
               this.av = CalculateMapper.a(var5, var6);
            }

            int var8 = this.ao.f() ? this.av : 1;

            // Re-check the anchor immediately before the charge packet: no ghost charging.
            if (!this.u(var2) || a.world.getBlockState(var2.down()).isAir()) {
               this.p(var3);
               return;
            }

            for (int var9 = 0; var9 < var8; var9++) {
               if (this.ad.f()) {
                  BufferNormalizer.d(1);
               }

               GridResolver.a(var1, true);
            }

            this.av = 0;
            this.at = FrameClockCache.g(this.ah.p());
            this.au = this.i_r98() + j(this.ah.p());
            this.q();
         } else if (this.t(var2)) {
            if (!this.g(this.aw, this.ax)) {
               this.n(this.aw);
               return;
            }

            int var7 = this.al.g() - 1;
            if (InitExecutor.a(var3.getInventory()) != var7) {
               if (!this.g(this.ar, this.as)) {
                  this.n(this.ar);
                  return;
               }

               if (!FrameClockCache.i(var3)) {
                  this.m(var3);
                  this.o(var3);
                  return;
               }

               if (CalculateMapper.a(1, 100) > this.af.g()) {
                  this.p(var3);
                  return;
               }

               ViewLocator.a(var7);
               this.ar = FrameClockCache.g(this.ae.p());
               this.as = this.i_r98() + j(this.ae.p());
               this.q();
               return;
            }

            if (this.an.f()) {
               return;
            }

            if (var3.age == this.be) {
               this.o(var3);
               return;
            }

            if (this.l(var3)) {
               this.o(var3);
               return;
            }

            if (CalculateMapper.a(1, 100) > this.ak.g()) {
               this.p(var3);
               return;
            }

            if (this.ad.f()) {
               BufferNormalizer.d(1);
            }

            GridResolver.a(var1, true);
            this.ay.remove(var2);
            this.aw = FrameClockCache.g(this.aj.p());
            this.ax = this.i_r98() + j(this.aj.p());
            this.be = var3.age;
            this.q();
         }
      }
   }

   private boolean g(long var1, int var3) {

      return this.bg && this.bf - var3 >= 0 || System.nanoTime() - var1 >= 0L;
   }

   private void h_r97() {

      long var1 = System.nanoTime();
      this.ar = var1;
      this.at = var1;
      this.aw = var1;
      this.as = this.bf;
      this.au = this.bf;
      this.ax = this.bf;
   }

   private int i_r98() {

      return this.bg ? this.bf : this.bf + 1;
   }

   private static int j(double var0) {

      return (int)Math.ceil(var0 / 50.0);
   }

   private int k(Item var1) {

      for (int var2 = 0; var2 < 9; var2++) {
         if (a.player.getInventory().getStack(var2).isOf(var1)) {
            return var2;
         }
      }

      return -1;
   }

   private boolean l(ClientPlayerEntity var1) {

      return FrameClockCache.k(var1) && var1.age != this.bh + 1;
   }

   private void m(ClientPlayerEntity var1) {

      FrameClockCache.j(var1);
      this.bh = var1.age;
   }

   private void n(long var1) {

      this.ba = true;
      this.bb = var1;
   }

   private void o(ClientPlayerEntity var1) {

      this.bc = var1.age;
      this.ba = true;
      this.bb = System.nanoTime();
   }

   private void p(ClientPlayerEntity var1) {

      this.bd = var1.age;
      this.o(var1);
   }

   private void q() {

      this.ba = true;
      this.bb = System.nanoTime();
   }

   @Override
   public void a(BufferEncoder var1) {

      if (a.player != null && a.world != null) {
         if (a.crosshairTarget instanceof BlockHitResult var2 && var2.getType() == HitResult.Type.BLOCK) {
            if (a.player.getMainHandStack().getItem() == Items.RESPAWN_ANCHOR) {
               Direction var5 = var2.getSide();
               BlockPos var4 = var2.getBlockPos();
               if (!a.world.getBlockState(var4).isReplaceable()) {
                  this.ay.add(var4.offset(var5));
               } else {
                  this.ay.add(var4);
               }
            }

            BlockPos var6 = var2.getBlockPos();
            if (this.t(var6)) {
               this.ay.remove(var6);
            }
         }

         if (this.r()) {
            var1.b();
         }
      }
   }

   private boolean r() {

      if (a.crosshairTarget instanceof BlockHitResult var1 && var1.getType() == HitResult.Type.BLOCK) {
         BlockPos var3 = var1.getBlockPos();
         if (!TaskJoiner.a(var3, Blocks.RESPAWN_ANCHOR)) {
            return false;
         }

         if (a.player.getMainHandStack().isOf(Items.RESPAWN_ANCHOR)) {
            return false;
         }

         if (this.am.f() && !this.ay.contains(var3)) {
            return false;
         }

         if (this.t(var3) && this.an.f()) {
            return false;
         }

         return this.s();
      }

      return false;
   }

   private boolean s() {

      if (a.currentScreen == null && !a.player.isUsingItem()) {
         boolean var1 = a.player.getMainHandStack().getItem().getComponents().contains(DataComponentTypes.FOOD)
            || a.player.getMainHandStack().getItem() instanceof ShieldItem
            || a.player.getOffHandStack().getItem() instanceof ShieldItem
            || a.player.getOffHandStack().getItem().getComponents().contains(DataComponentTypes.FOOD);
         if (var1 && SlotInspector.a(1) && !this.ab.f()) {
            return false;
         } else {
            return this.ac.f() && GridResolver.a() ? false : this.aa.g() == -1 || SlotInspector.a(this.aa.g());
         }
      } else {
         return false;
      }
   }

   private boolean t(BlockPos var1) {

      return TaskJoiner.a(var1, Blocks.RESPAWN_ANCHOR) && (Integer)a.world.getBlockState(var1).get(RespawnAnchorBlock.CHARGES) != 0;
   }

   private boolean u(BlockPos var1) {

      return TaskJoiner.a(var1, Blocks.RESPAWN_ANCHOR) && (Integer)a.world.getBlockState(var1).get(RespawnAnchorBlock.CHARGES) == 0;
   }
}
