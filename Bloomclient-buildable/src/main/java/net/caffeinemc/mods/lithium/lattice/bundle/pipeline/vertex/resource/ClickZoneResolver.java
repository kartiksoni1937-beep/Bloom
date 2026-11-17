package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.InitExecutor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.LockD;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.SlotInspector;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.TaskJoiner;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.ViewLocator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ShieldItem;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.block.RespawnAnchorBlock;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.component.DataComponentTypes;

public final class ClickZoneResolver extends BuilderFactory implements InitNotifier, net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.CalculateRange {
   private static final int ak = 0;
   private static final int al = 1;
   private static final int am = 2;
   private static final int an = 3;
   private static final int ao = 8;
   private static final int ap = 40;
   private static final int aq = 10;
   private static ClickZoneResolver ar;
   private static boolean as = false;
   private static boolean at = false;
   private final ItemDescriptor au;
   private final CheckerBridge av;
   private final CheckerBridge aw;
   private final CheckerBridge ax;
   private final BlockCalculator ay;
   private final TimingEntry az;
   private final BlockCalculator ba;
   private final TimingEntry bb;
   private final BlockCalculator bc;
   private final TimingEntry bd;
   private final BlockCalculator be;
   private final BlockCalculator bf;
   private final CheckerBridge bg;
   private final CheckerBridge bh;
   private final CheckerBridge bi;
   private final BlockCalculator bj;
   private final BlockCalculator bk;
   private int bl;
   private long bm;
   private int bn;
   private int bo;
   private BlockPos bp;
   private BlockPos bq;
   private int br;
   private int bs;
   private int bt;
   private int bu;
   private int bv;
   private final Runnable bw;
   private boolean bx;
   private boolean by;
   private int bz;
   private boolean ca;
   private int cb;
   private boolean cc;
   private int cd;
   private boolean pendingCharge;
   private BlockPos pendingChargePos;
   private int pendingChargeAge = Integer.MIN_VALUE;
   private final Set<BlockPos> ce;
   private static int cf = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   public ClickZoneResolver() {
      super("", "", ParserEngine.CT);
      this.setName(
         new char[]{'듆', '뒊', '뒯', '뒋', '땢', '땋', '딟', '딟', '딓', '뗿', '뗓', '떵', '떋'},
         1206498437,
         new char[]{
            '\ue263',
            '\ue27c',
            '\ue203',
            '\ue2f5',
            '\ue2dc',
            '\ue2bd',
            '\ue2cd',
            '\ue363',
            '\ue345',
            '\ue32f',
            '\ue349',
            '\ue3e3',
            '\ue3c2',
            '\ue3bf',
            '\ue3c5',
            '\ue470',
            '\ue44c',
            '\ue462',
            '\ue411',
            '\ue4ec',
            '\ue4fe',
            '\ue4dd',
            '\ue4b8',
            '\ue4d0',
            '\ue53b',
            '\ue559',
            '\ue531',
            '\ue519',
            '\ue5e5',
            '\ue5d1',
            '\ue5b0',
            '\ue5d4',
            '\ue672',
            '\ue65c',
            '\ue635',
            '\ue650',
            '\ue6ea',
            '\ue6d6',
            '\ue6bd',
            '\ue680',
            '\ue764',
            '\ue74e',
            '\ue72c',
            '\ue748',
            '\ue7e6',
            '\ue7c8',
            '\ue7e5',
            '\ue785',
            '\ue86d',
            '\ue841',
            '\ue829',
            '\ue80f',
            '\ue80d'
         },
         -929635789
      );
      ItemDescriptor var10001 = new ItemDescriptor("", 1, false);
      var10001.n(new char[]{'햨', '혦', '홄', '혲', '혌', '훲', '훂', '횶', '횄', '휠', '흔', '흛', '휤'}, -1673865751);
      this.au = var10001;
      CheckerBridge var1 = new CheckerBridge("", true);
      var1.n(new char[]{'\ufae5', '\ufaff', '滛', 'ﭦ', '\ufb42', 'ﬨ', 'בֿ', 'ﯞ', 'ﯙ', 'ﮬ'}, -488113486);
      this.av = var1;
      CheckerBridge var2 = new CheckerBridge("", false);
      var2.n(new char[]{'ᏺ', 'Ꮶ', '᎓', 'ᑩ', 'ᑕ', 'ᑤ', 'ᐌ', 'ᓬ', 'ᒁ', 'ᒋ', 'ᒶ', 'ᒒ', 'ᕱ'}, -2132012119);
      this.aw = var2;
      CheckerBridge var3 = new CheckerBridge("", false);
      var3.n(new char[]{'᠊', 'ᡆ', 'ᣫ', 'ᣏ', 'ᢦ', 'ᢏ', 'ᤣ', 'ᥱ', 'ᤨ', 'ᤍ', 'ᤊ', '᧲', '\u19dc', 'ᦨ', 'ᦒ', '᩵', 'ᩗ'}, -923789239);
      this.ax = var3;
      BlockCalculator var4 = new BlockCalculator("", 0.0, 100.0, 100.0, 1.0);
      var4.n(new char[]{'莺', '萧', '葄', '萦', '萅', '蓠', '蒄', '蒀', '蒊', '蕠', '蕎', '蕜', '蔻'}, -1342667798);
      this.ay = var4;
      TimingEntry var5 = new TimingEntry("", 0.0, 1000.0, 0.0, 1.0);
      var5.n(new char[]{'奺', '奦', '夐', '姯', '姑', '妧', '妋', '娢', '婥', '娥', '娳', '娟', '嫤'}, -659334871);
      this.az = var5;
      BlockCalculator var6 = new BlockCalculator("", 0.0, 100.0, 100.0, 1.0);
      var6.n(
         new char[]{'\udc6f', '\udc75', '\udc0d', '\udcf0', '\udccc', '\udcb4', '\udc9e', '\udd35', '\udd77', '\udd3b', '\udd13', '\uddff', '\uddd3', '\uddaa'},
         105176124
      );
      this.ba = var6;
      TimingEntry var7 = new TimingEntry("", 0.0, 1000.0, 0.0, 1.0);
      var7.n(new char[]{'遤', '遬', '逍', '郯', '部', '郍', '邩', '邓', '酵', '酟', '酹', '鄼', '釲', '釚', '醴', '醍'}, 1794347043);
      this.bb = var7;
      BlockCalculator var8 = new BlockCalculator("", 0.0, 100.0, 100.0, 1.0);
      var8.n(
         new char[]{
            '\uf72d',
            '\uf7a7',
            '\uf7c4',
            '\uf7a8',
            '\uf791',
            '\uf876',
            '\uf850',
            '\uf82c',
            '\uf80c',
            '\uf8e4',
            '\uf880',
            '\uf8fc',
            '\uf8b6',
            '\uf89c',
            '沈',
            '菱',
            '錄'
         },
         -1221724310
      );
      this.bc = var8;
      TimingEntry var9 = new TimingEntry("", 0.0, 1000.0, 0.0, 1.0);
      var9.n(new char[]{'㪛', '㫓', '㭤', '㭋', '㬶', '㬖', '㯼', '㯒', '㯶', '㮱', '㱱', '㱟', '㰳', '㰈'}, -267044130);
      this.bd = var9;
      BlockCalculator var10 = new BlockCalculator("", 0.0, 100.0, 100.0, 1.0);
      var10.n(new char[]{'ꕂ', 'ꔈ', 'ꔽ', 'ꔔ', 'ꗯ', 'ꗍ', 'ꖥ', 'ꖅ', 'ꗟ', 'ꙝ', 'ꙕ', '\ua63d', 'ꘕ', '\ua6f9', 'ꛜ'}, 31696135);
      this.be = var10;
      BlockCalculator var11 = new BlockCalculator("", 1.0, 9.0, 1.0, 1.0);
      var11.n(
         new char[]{'\udebd', '\udf39', '\udf4e', '\udf25', '\udf18', '\udffc', '\udfd6', '\udfb4', '\udfd0', '\ue05c', '\ue042', '\ue022', '\ue018'},
         -1293754632
      );
      this.bf = var11;
      CheckerBridge var12 = new CheckerBridge("", false);
      var12.n(new char[]{'沆', '泆', '浩', '浊', '洼', '浄', '淌', '淕', '涯'}, 1280273609);
      this.bg = var12;
      CheckerBridge var13 = new CheckerBridge("", false);
      var13.n(new char[]{'挤', '掤', '揇', '掤', '掞', '搦', '摦', '搬', '搂', '擰', '擆', '撥'}, 468542315);
      this.bh = var13;
      CheckerBridge var14 = new CheckerBridge("", false);
      var14.n(new char[]{'卒', '匱', '卟', '匳', '匘', '叴', '受', '叹', '县', '呻', '呙', '吢', '吇', '哧', '哝', '咿', '咕'}, -322415872);
      this.bi = var14;
      BlockCalculator var15 = new BlockCalculator("", 1.0, 4.0, 1.0, 1.0);
      var15.n(new char[]{'붴', '븫', '빅', '븭', '븆', '뺡', '뻧', '뻓', '뺱', '뺊', '뼼', '뽶', '뼳', '뼗'}, -963985946);
      this.bj = var15;
      BlockCalculator var16 = new BlockCalculator("", 1.0, 4.0, 4.0, 1.0);
      var16.n(
         new char[]{'\ue0f2', '\ue091', '\ue0bf', '\ue093', '\ue178', '\ue11b', '\ue11d', '\ue115', '\ue1f7', '\ue1c0', '\ue1f6', '\ue1b8', '\ue275', '\ue24b'},
         -741941088
      );
      this.bk = var16;
      this.bl = 0;
      this.bo = 0;
      this.bp = null;
      this.bq = null;
      this.br = 0;
      this.bs = Integer.MIN_VALUE;
      this.bt = Integer.MIN_VALUE;
      this.bu = Integer.MIN_VALUE;
      this.bv = Integer.MIN_VALUE;
      this.bw = this::g_r12;
      this.cb = -1073741824;
      this.cc = false;
      this.cd = 0;
      this.ce = new HashSet<>();
      this.a(
         new InitAdapter[]{
            this.au,
            this.av,
            this.aw,
            this.ax,
            this.ay,
            this.az,
            this.ba,
            this.bb,
            this.bc,
            this.bd,
            this.be,
            this.bf,
            this.bg,
            this.bh,
            this.bi,
            this.bj,
            this.bk
         }
      );
      ar = this;
   }

   @Override
   public void c() {

      this.b.a(InitNotifier.class, this);
      this.b.a(net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.CalculateRange.class, this);
      this.aj();
      this.bq = null;
      this.br = 0;
      this.cd = 0;
      this.clearPendingCharge();
      int var1 = this.au.g();
      this.cc = var1 != -1 && SlotInspector.a(var1);
      at = this.cc;
      as = false;
      this.bs = 1903513718 ^ -243969930;
      this.bt = 422670634 ^ -1724813014;
      this.bu = 977722598 ^ -1169761050;
      this.bv = -720135573 ^ 1427348075;
      this.cb = 143657105 ^ -930084719;
      this.ca = false;
      LockD.h = true;
      FrameClockCache.add(this.bw);
      super.c();
   }

   @Override
   public void d() {

      FrameClockCache.b(this.bw);
      LockD.h = false;
      this.b.b(InitNotifier.class, this);
      this.b.b(net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.CalculateRange.class, this);
      this.aj();
      this.bq = null;
      this.br = 0;
      this.cd = 0;
      this.clearPendingCharge();
      as = false;
      super.d();
   }

   public static void b() {

      ClickZoneResolver var0 = ar;
      if (var0 != null && a.player != null) {
         int var1 = var0.au.d;
         boolean var2 = var1 != -1 && SlotInspector.a(var1);
         if (var2 && !at && var0.f() && a.currentScreen == null) {
            as = true;
         }

         at = var2;
      }
   }

   @Override
   public void a(BufferEncoder var1) {

      if (a.player != null && a.world != null) {
         boolean var2 = a.player.age == this.bs;
         if (this.bl == 0
            && !var2
            && a.player.getMainHandStack().isOf(Items.RESPAWN_ANCHOR)
            && a.crosshairTarget instanceof BlockHitResult var3
            && var3.getType() == HitResult.Type.BLOCK) {
            this.ce.add(this.aa(var3));
            this.ae();
         }

         if (this.bl != 0 || var2) {
            var1.b();
         }
      }
   }

   @Override
   public void a() {

      this.bz++;
      this.ca = true;
      this.f_r11();
      this.ca = false;
   }

   private void f_r11() {
      boolean var1 = false;
      byte var2 = 0;

      label69:
      while (true) {
         switch (var2) {
            case 0:
            default:
               if (cf != 0) {
                  Thread.currentThread().getName().length();
                  var2 = 1;
                  break;
               }
            case 1:
               var1 = this.i_r14();
               if (a.player != null && a.world != null && a.interactionManager != null) {
                  if (a.currentScreen != null) {
                     var2 = 2;
                  } else {
                     var2 = 3;
                  }
                  break;
               }
            case 2:
               break label69;
            case 3:
               if (var1) {
                  this.cd = 10;
                  var2 = 5;
                  break;
               }
            case 4:
               if (this.cd > 0) {
                  this.cd--;
                  var2 = 5;
                  break;
               }
            case 5:
               this.j_r15();
               if (this.af() && SlotInspector.a(1) && !this.av.f()) {
                  this.aj();
                  return;
               }
            case 6:
               if (this.aw.f() && GridResolver.a()) {
                  this.aj();
                  this.cd = 0;
                  return;
               }
            case 7:
               if (a.player.isUsingItem()) {
                  return;
               }
            case 8:
               if (this.bl == 0) {
                  if (this.cd > 0) {
                     if (this.bq != null) {
                        var2 = 9;
                     } else {
                        var2 = 10;
                     }
                     break;
                  }

                  return;
               }
            case 12:
               if (this.p(this.bm, this.bn) && ++this.bo > 40) {
                  this.aj();
                  return;
               }
            case 13:
               if (a.player.age != this.bv) {
                  this.h_r13();
                  var2 = 14;
                  break;
               }
            case 14:
               return;
            case 9:
               return;
            case 10:
               this.cd = 0;
               if (!this.y()) {
                  return;
               }
            case 11:
               this.bl = 1;
               this.bo = 0;
               var2 = 13;
         }
      }

      this.aj();
      this.bq = null;
      this.cd = 0;
   }

   private void g_r12() {

      this.ca = false;
      if (this.bl != 0 && System.nanoTime() - this.bm >= 0L) {
         ClientPlayerEntity var1 = a.player;
         if (var1 != null && var1.age != this.bu) {
            if (a.world == null
               || a.interactionManager == null
               || a.currentScreen != null
               || var1.isUsingItem()
               || this.af() && SlotInspector.a(1) && !this.av.f()
               || this.aw.f() && GridResolver.a()) {
               this.bu = var1.age;
               this.bx = false;
            } else {
               this.h_r13();
            }
         }
      }
   }

   private void h_r13() {

      this.by = this.bx;
      this.bx = false;
      if (FrameClockCache.n) {
         for (int var1 = 0; var1 < 8 && this.bl != 0 && this.p(this.bm, this.bn); var1++) {
            int var2 = this.bl;
            switch (this.bl) {
               case 1:
                  this.k_r16();
                  break;
               case 2:
                  this.l_r17();
                  break;
               case 3:
                  this.m_r100();
                  break;
               default:
                  this.aj();
            }

            if (this.bl == var2) {
               break;
            }
         }

         if (this.bl != 0 && !this.p(this.bm, this.bn)) {
            this.bx = true;
         }
      }
   }

   private boolean i_r14() {

      int var1 = this.au.d;
      boolean var2 = var1 != -1 && SlotInspector.a(var1);
      boolean var3 = as || var2 && !this.cc;
      as = false;
      this.cc = var2;
      return var3;
   }

   private void j_r15() {

      if (this.bq != null) {
         if (!this.ag(this.bq)) {
            this.bq = null;
            this.br = 0;
         } else {
            if (++this.br > 40) {
               this.bq = null;
               this.br = 0;
            }
         }
      }
   }

   private void k_r16() {

      if (this.ag(this.bp)) {
         this.bl = 2;
      } else {
         BlockHitResult var1 = this.z();
         if (var1 != null) {
            this.bp = this.aa(var1);
            // Strict placement state: the target must be empty and supported below.
            if (this.bp == null
               || !a.world.getBlockState(this.bp).isReplaceable()
               || a.world.getBlockState(this.bp.down()).isAir()) {
               this.aj();
               return;
            }
            if (a.player.getMainHandStack().isOf(Items.RESPAWN_ANCHOR) || this.n(Items.RESPAWN_ANCHOR)) {
               if (this.u(a.player)) {
                  this.bu = a.player.age;
               } else if (CalculateMapper.a(1, 100) > this.ay.g()) {
                  this.w();
               } else {
                  this.x(var1);
                  this.ce.add(this.bp);
                  this.ae();
                  // The glowstone packet may not share this tick with the anchor packet.
                  this.pendingCharge = true;
                  this.pendingChargePos = this.bp;
                  this.pendingChargeAge = a.player.age;
                  this.bl = 2;
               }
            }
         }
      }
   }

   private void l_r17() {

      if (this.pendingCharge) {
         if (a.player == null || a.player.age <= this.pendingChargeAge) {
            return;
         }
         // Never charge from ghost data: the anchor must still be there, uncharged, with
         // a solid block underneath.
         if (this.pendingChargePos == null
            || !TaskJoiner.a(this.pendingChargePos, Blocks.RESPAWN_ANCHOR)
            || (Integer)a.world.getBlockState(this.pendingChargePos).get(RespawnAnchorBlock.CHARGES) != 0
            || a.world.getBlockState(this.pendingChargePos.down()).isAir()) {
            this.clearPendingCharge();
            this.aj();
            return;
         }
      }

      if (this.ag(this.bp)) {
         if (this.ah(this.bp)) {
            this.bl = 3;
         } else if (!this.ad(this.bp)) {
            this.aj();
         } else if (a.player.getMainHandStack().isOf(Items.GLOWSTONE) || this.n(Items.GLOWSTONE)) {
            if (this.u(a.player)) {
               this.bu = a.player.age;
            } else if (CalculateMapper.a(1, 100) > this.bc.g()) {
               this.w();
            } else {
               int var1 = 1;
               if (this.bi.f()) {
                  int var2 = Math.max(1, Math.min(this.bj.g(), 4));
                  int var3 = Math.max(var2, Math.min(this.bk.g(), 4));
                  var1 = CalculateMapper.a(var2, var3);
               }

               BlockPos var6 = this.pendingCharge && this.pendingChargePos != null ? this.pendingChargePos : this.bp;
               BlockHitResult var4 = this.ac(var6);

               for (int var5 = 0; var5 < var1; var5++) {
                  this.x(var4);
               }

               this.clearPendingCharge();
               this.bm = this.o() + this.bb.ns();
               this.bn = this.q() + r(this.bb.p());
               this.bl = 3;
            }
         }
      }
   }

   private void m_r100() {

      if (this.bh.f() || !this.ag(this.bp)) {
         this.ai(null);
      } else if (this.ah(this.bp)) {
         if (!this.ad(this.bp)) {
            this.aj();
         } else {
            BlockHitResult var1 = this.ab(this.bp);
            if (var1 != null) {
               int var2 = Math.max(0, Math.min(this.bf.g() - 1, 8));
               if (InitExecutor.a(a.player.getInventory()) != var2) {
                  if (!this.t(true)) {
                     return;
                  }

                  if (CalculateMapper.a(1, 100) > this.ba.g()) {
                     this.w();
                     return;
                  }

                  ViewLocator.a(var2);
                  this.bt = a.player.age;
                  this.bm = this.o() + this.az.ns();
                  this.bn = this.q() + r(this.az.p());
                  if (this.az.p() > 0.0) {
                     return;
                  }
               }

               if (this.u(a.player)) {
                  this.bu = a.player.age;
               } else if (CalculateMapper.a(1, 100) > this.be.g()) {
                  this.w();
               } else {
                  BlockPos var3 = this.bp;
                  this.x(var1);
                  this.bm = this.o() + this.bd.ns();
                  this.bn = this.q() + r(this.bd.p());
                  this.ai(var3);
               }
            }
         }
      }
   }

   private boolean n(Item var1) {

      if (!this.t(this.s(var1) >= 0)) {
         return false;
      } else if (CalculateMapper.a(1, 100) > this.ba.g()) {
         this.w();
         return false;
      } else if (!ViewLocator.a(var1)) {
         this.aj();
         return false;
      } else {
         this.bt = a.player.age;
         this.bm = this.o() + this.az.ns();
         this.bn = this.q() + r(this.az.p());
         return this.az.p() <= 0.0;
      }
   }

   private long o() {

      long var1 = System.nanoTime();
      long var3 = var1 - this.bm;
      return var3 >= 0L && (!this.by || var3 > 50000000L) ? var1 : this.bm;
   }

   private boolean p(long var1, int var3) {

      return this.ca && this.bz - var3 >= 0 || System.nanoTime() - var1 >= 0L;
   }

   private int q() {

      return this.ca ? this.bz : this.bz + 1;
   }

   private static int r(double var0) {

      return (int)Math.ceil(var0 / 50.0);
   }

   private int s(Item var1) {

      for (int var2 = 0; var2 < 9; var2++) {
         if (a.player.getInventory().getStack(var2).isOf(var1)) {
            return var2;
         }
      }

      return -1;
   }

   private boolean t(boolean var1) {

      ClientPlayerEntity var2 = a.player;
      if (var2.age != this.bs && var2.age != this.bt && FrameClockCache.i(var2)) {
         return true;
      } else {
         if (var1 && !FrameClockCache.i(var2)) {
            this.v(var2);
         }

         this.bu = var2.age;
         return false;
      }
   }

   private boolean u(ClientPlayerEntity var1) {

      return FrameClockCache.k(var1) && var1.age != this.cb + 1;
   }

   private void v(ClientPlayerEntity var1) {

      FrameClockCache.j(var1);
      this.cb = var1.age;
   }

   private void w() {

      this.bv = a.player.age;
      this.bu = this.bv;
   }

   private void x(BlockHitResult var1) {

      if (this.ax.f()) {
         BufferNormalizer.d(1);
      }

      this.bs = a.player.age;
      GridResolver.a(var1, true);
   }

   private boolean y() {

      if (a.crosshairTarget instanceof BlockHitResult var1 && var1.getType() == HitResult.Type.BLOCK) {
         BlockPos var4 = var1.getBlockPos();
         if (TaskJoiner.a(var4, Blocks.RESPAWN_ANCHOR)) {
            if (this.bg.f() && !this.ce.contains(var4)) {
               return false;
            }

            if (!this.ad(var4)) {
               return false;
            }

            this.bp = var4;
            return true;
         }

         BlockHitResult var3 = this.z();
         if (var3 == null) {
            return false;
         }

         this.bp = this.aa(var3);
         return true;
      }

      return false;
   }

   private BlockHitResult z() {

      if (a.crosshairTarget instanceof BlockHitResult var1 && var1.getType() == HitResult.Type.BLOCK) {
         BlockPos var3 = this.aa(var1);
         if (a.world.getBlockState(var3).isReplaceable() && this.ad(var3)) {
            return var1;
         }

         return null;
      }

      return null;
   }

   private BlockPos aa(BlockHitResult var1) {

      BlockPos var2 = var1.getBlockPos();
      return a.world.getBlockState(var2).isReplaceable() ? var2 : var2.offset(var1.getSide());
   }

   private BlockHitResult ab(BlockPos var1) {

      HitResult var2 = a.player.raycast(a.player.getBlockInteractionRange(), 1.0F, false);
      if (var2 instanceof BlockHitResult var3 && var2.getType() == HitResult.Type.BLOCK && var3.getBlockPos().equals(var1)) {
         return var3;
      }

      return null;
   }

   private BlockHitResult ac(BlockPos var1) {

      BlockHitResult var2 = this.ab(var1);
      return var2 != null ? var2 : new BlockHitResult(Vec3d.ofCenter(var1), Direction.UP, var1, false);
   }

   private boolean ad(BlockPos var1) {

      return var1 != null && a.player.canInteractWithBlockAt(var1, 0.0);
   }

   private void ae() {

      if (this.ce.size() > 64) {
         Iterator var1 = this.ce.iterator();

         while (var1.hasNext()) {
            if (!this.ag((BlockPos)var1.next())) {
               var1.remove();
            }
         }

         if (this.ce.size() > 64) {
            this.ce.clear();
         }
      }
   }

   private boolean af() {

      return a.player.getMainHandStack().getItem().getComponents().contains(DataComponentTypes.FOOD)
         || a.player.getMainHandStack().getItem() instanceof ShieldItem
         || a.player.getOffHandStack().getItem() instanceof ShieldItem
         || a.player.getOffHandStack().getItem().getComponents().contains(DataComponentTypes.FOOD);
   }

   private boolean ag(BlockPos var1) {

      return var1 != null && TaskJoiner.a(var1, Blocks.RESPAWN_ANCHOR);
   }

   private boolean ah(BlockPos var1) {

      return this.ag(var1) && (Integer)a.world.getBlockState(var1).get(RespawnAnchorBlock.CHARGES) != 0;
   }

   private void ai(BlockPos var1) {
      byte var2 = 0;

      label17:
      while (true) {
         switch (var2) {
            case 0:
            default:
               if (cf != 0) {
                  System.nanoTime();
                  var2 = 1;
                  break;
               }
            case 1:
               if (var1 != null) {
                  this.bq = var1;
                  this.br = 0;
                  this.ce.remove(var1);
                  var2 = 2;
                  break;
               }
            case 2:
               break label17;
         }
      }

      this.clearPendingCharge();
      this.bl = 0;
      this.bo = 0;
      this.bp = null;
   }

   private void clearPendingCharge() {
      this.pendingCharge = false;
      this.pendingChargePos = null;
   }

   private void aj() {

      this.clearPendingCharge();
      this.bl = 0;
      this.bo = 0;
      this.bm = System.nanoTime();
      this.bn = this.bz;
      this.bx = false;
      this.bp = null;
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
