package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.BufferEncoder;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.CoreSerializer;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.InitNotifier;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.LinkerFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.ParserEngine;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.BlockCalculator;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.CheckerBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.ItemDescriptor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.TimingEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.BufferNormalizer;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.FrameClockCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.GridResolver;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.InitExecutor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.NodeKeeper;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.SlotInspector;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.TaskJoiner;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.ViewLocator;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.SortableData;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.hit.HitResult;
import net.minecraft.block.BlockState;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.block.RespawnAnchorBlock;
import org.lwjgl.glfw.GLFW;

public final class DataCZ
   extends BuilderFactory
   implements InitNotifier,
   net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.CalculateRange,
   CoreSerializer {
   private final ItemDescriptor q;
   private final CheckerBridge r;
   private final TimingEntry s;
   private final BlockCalculator t;
   private final TimingEntry u;
   private final BlockCalculator v;
   private final CheckerBridge w;
   private final CheckerBridge x;
   private final CheckerBridge y;
   private final CheckerBridge z;
   private final CheckerBridge aa;
   private final BlockCalculator ab;
   private static final int ac = 408758278;
   private static final long ad = 50000000L;
   private static final long ae = 60000000L;
   private int af;
   private long ag;
   private long ah;
   private boolean ai;
   private long aj;
   private final Runnable ak;
   private boolean al;
   private boolean am;
   private boolean an;

   public DataCZ() {
      super("", "", ParserEngine.CT);
      this.setName(
         new char[]{'充', '儍', '儷', '儕', '凯', '冿', '凶', '冴', '冈', '刻', '剹', '别', '刁', '勤', '勂', '労', '劘'},
         1023824132,
         new char[]{
            '쯾',
            '쮫',
            '쮉',
            '챳',
            '챖',
            '찻',
            '찍',
            '쳱',
            '쳔',
            '첷',
            '척',
            '쵸',
            '쵊',
            '쵲',
            '촙',
            '췹',
            '췛',
            '췣',
            '춎',
            '칾',
            '칒',
            '츹',
            '츝',
            '컩',
            '컋',
            '캵',
            '컅',
            '콢',
            '콌',
            '켰',
            '콁',
            '쿹',
            '쿰',
            '쿋'
         },
         -1059206209
      );
      ItemDescriptor var10001 = new ItemDescriptor("", 1, false);
      var10001.n(new char[]{'뀣', '냢', '냔', '냖', '남', '난', '녨', '녞', '녺', '넲', '뇽', '뇎'}, -2139180958);
      this.q = var10001;
      CheckerBridge var1 = new CheckerBridge("", false);
      var1.n(new char[]{'ꩱ', '\uaa39', 'ꨕ', 'ꫬ', '\uaac5', 'ꫭ', 'ꪼ', 'ꭧ', 'ꭋ', 'ꬪ', 'ꬍ'}, -86988238);
      this.r = var1;
      TimingEntry var2 = new TimingEntry("", 0.0, 1000.0, 0.0, 1.0);
      var2.n(new char[]{'ࡄ', 'ࡁ', '࠼', 'ࠀ', 'ࣰ', 'ࣚ', 'ࣱ', 'ࢴ', '४', 'ू', 'ब', 'क'}, 1930430487);
      this.s = var2;
      BlockCalculator var3 = new BlockCalculator("", 0.0, 100.0, 100.0, 1.0);
      var3.n(new char[]{'ﺿ', 'ｼ', 'ｃ', '］', '＋', '\uffef', 'ﾆ', 'ﾆ', 'ﾌ', 'b', 'L', '"', '\u0005'}, 1327103724);
      this.t = var3;
      TimingEntry var4 = new TimingEntry("", 0.0, 1000.0, 0.0, 1.0);
      var4.n(new char[]{'罒', '罍', '缡', '缼', '缛', '羽', '翸', '羾', '羖', '聸', '聁'}, 1861648130);
      this.u = var4;
      BlockCalculator var5 = new BlockCalculator("", 0.0, 100.0, 100.0, 1.0);
      var5.n(new char[]{'\u171d', 'ᜀ', '\u17ea', '៉', 'ឬ', 'ៈ', 'ᡄ', 'ᡎ', 'ᠤ', '᠊', 'ᣠ', 'ᣇ'}, -1015933107);
      this.v = var5;
      CheckerBridge var6 = new CheckerBridge("", false);
      var6.n(
         new char[]{
            '\ue64a',
            '\ue653',
            '\ue629',
            '\ue611',
            '\ue6b9',
            '\ue6ef',
            '\ue6be',
            '\ue682',
            '\ue77d',
            '\ue714',
            '\ue707',
            '\ue71d',
            '\ue7e5',
            '\ue7d5',
            '\ue7a2'
         },
         1335944733
      );
      this.w = var6;
      CheckerBridge var7 = new CheckerBridge("", false);
      var7.n(
         new char[]{
            '\uf524',
            '\uf5fd',
            '\uf5c3',
            '\uf5bb',
            '\uf5cf',
            '\uf659',
            '\uf644',
            '\uf638',
            '\uf603',
            '\uf6aa',
            '\uf6ea',
            '\uf6ba',
            '\uf69e',
            '\uf775',
            '\uf751',
            '\uf725',
            '\uf70f'
         },
         806417779
      );
      this.x = var7;
      CheckerBridge var8 = new CheckerBridge("", false);
      var8.n(new char[]{'涸', '湶', '湐', '渻', '渜', '溶', '滦', '溽', '溞', '潧', '潝', '漱', '漛', '濧', '濂', '澢'}, 135163387);
      this.y = var8;
      CheckerBridge var9 = new CheckerBridge("", true);
      var9.n(new char[]{'腩', '脮', '脗', '臥', '臒', '臵', '膧', '艤', '艓', '舡'}, -407076550);
      this.z = var9;
      CheckerBridge var10 = new CheckerBridge("", true);
      var10.n(new char[]{'精', '凞', '\ufae3', '滋', '晴', '廙', 'ﭳ', 'ﭘ'}, 29424220);
      this.aa = var10;
      BlockCalculator var11 = new BlockCalculator("", 3.0, 6.0, 4.5, 0.1);
      var11.n(new char[]{'\ue665', '\ue637', '\ue61b', '\ue6f3', '\ue6d6'}, 1048634935);
      this.ab = var11;
      this.af = -1073741824;
      this.ai = false;
      this.ak = this::f_r20;
      this.al = false;
      this.am = false;
      this.an = false;
      this.a(new InitAdapter[]{this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.aa, this.ab});
   }

   @Override
   public void c() {

      this.b.a(InitNotifier.class, this);
      this.b.a(net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.CalculateRange.class, this);
      this.b.a(CoreSerializer.class, this);
      this.b();
      FrameClockCache.add(this.ak);
      super.c();
   }

   @Override
   public void d() {

      this.b.b(InitNotifier.class, this);
      this.b.b(net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.CalculateRange.class, this);
      this.b.b(CoreSerializer.class, this);
      FrameClockCache.b(this.ak);
      this.ai = false;
      super.d();
   }

   public void b() {

      this.ai = false;
      this.al = false;
      this.am = false;
      this.an = false;
   }

   @Override
   public void a() {

      if (a.player != null && a.world != null) {
         if (a.currentScreen == null) {
            int var1 = this.q.g();
            if (var1 != -1 && SlotInspector.a(var1)) {
               this.l(true);
            } else {
               this.b();
            }
         }
      }
   }

   private void f_r20() {

      if (this.ai && System.nanoTime() - this.aj >= 0L) {
         this.ai = false;
         if (a.player != null && a.world != null && a.interactionManager != null && a.currentScreen == null) {
            int var1 = this.q.g();
            if (var1 != -1 && SlotInspector.a(var1)) {
               this.l(false);
            }
         }
      }
   }

   private void g(long var1) {

      this.ai = true;
      this.aj = var1;
   }

   private static long h(long var0, long var2) {

      return var2 - var0 <= 60000000L ? var0 : var2;
   }

   private boolean i(Item var1) {

      for (int var2 = 0; var2 < 9; var2++) {
         if (a.player.getInventory().getStack(var2).isOf(var1)) {
            return true;
         }
      }

      return false;
   }

   private boolean j_r21() {

      return FrameClockCache.k(a.player) && a.player.age != this.af + 1;
   }

   private void k_r22() {

      FrameClockCache.j(a.player);
      this.af = a.player.age;
   }

   private void l(boolean var1) {

      this.ai = false;
      if (FrameClockCache.n) {
         int var2 = ThreadLocalRandom.current().nextInt(1, 101);
         BlockHitResult var3 = this.m_r102();
         if (var3 == null || var3.getType() != HitResult.Type.BLOCK || this.al || NodeKeeper.b(var3.getBlockPos()) || !this.r.f()) {
            ItemStack var4 = a.player.getMainHandStack();
            boolean var5 = InitExecutor.a(var4.getItem());
            if (this.aa.f()
               || var5
               || this.w.f() && var4.isOf(Items.TOTEM_OF_UNDYING)
               || this.x.f() && var4.isOf(Items.END_CRYSTAL)
               || this.al) {
               if (!this.am && this.z.f() && var3 != null && var3.getType() == HitResult.Type.BLOCK) {
                  Block var6 = a.world.getBlockState(var3.getBlockPos()).getBlock();
                  if (var6 == Blocks.OBSIDIAN || var6 == Blocks.BEDROCK) {
                     this.am = true;
                  }
               }

               if (!this.al) {
                  this.al = true;
                  long var17 = System.nanoTime();
                  this.ah = var17 + this.s.ns();
                  this.ag = var17 + this.u.ns();
               }

               long var18 = System.nanoTime();
               boolean var8 = false;
               if (!this.am && var3 != null) {
                  if (var3.getType() == HitResult.Type.MISS) {
                     return;
                  }

                  if (!TaskJoiner.a(var3.getBlockPos(), Blocks.OBSIDIAN)) {
                     if (TaskJoiner.a(var3.getBlockPos(), Blocks.RESPAWN_ANCHOR) && this.n(var3.getBlockPos())) {
                        return;
                     }

                     a.options.useKey.setPressed(false);
                     if (!a.player.getMainHandStack().isOf(Items.OBSIDIAN)) {
                        if (var18 - this.ah < 0L) {
                           this.g(this.ah);
                           return;
                        }

                        if (var2 <= this.t.g()) {
                           if (!FrameClockCache.i(a.player)) {
                              if (var1 && this.i(Items.OBSIDIAN)) {
                                 this.k_r22();
                                 this.g(var18);
                              }

                              return;
                           }

                           long var10 = h(this.ah, var18);
                           this.ah = var10 + this.s.ns();
                           long var12 = this.u.ns();
                           this.ag = (var12 > 0L ? var18 : var10) + var12;
                           ViewLocator.a(Items.OBSIDIAN);
                        } else {
                           this.ah = h(this.ah, var18) + 50000000L;
                           this.g(this.ah);
                        }
                     }

                     if (a.player.getMainHandStack().isOf(Items.OBSIDIAN)) {
                        if (var18 - this.ag < 0L) {
                           this.g(this.ag);
                           return;
                        }

                        if (this.j_r21()) {
                           this.g(var18);
                           return;
                        }

                        var2 = ThreadLocalRandom.current().nextInt(1, 101);
                        if (var2 <= this.v.g()) {
                           if (this.y.f() && !a.player.isUsingItem()) {
                              BufferNormalizer.d(1);
                              a.options.useKey.setPressed(false);
                           }

                           GridResolver.a(var3, true);
                           long var20 = h(this.ag, var18);
                           this.ag = var20 + this.u.ns();
                           this.ah = var20 + this.s.ns();
                           this.am = true;
                           var8 = true;
                        } else {
                           this.ag = h(this.ag, var18) + 50000000L;
                           this.g(this.ag);
                        }
                     }
                  }
               }

               if (this.am) {
                  if (!a.player.getMainHandStack().isOf(Items.END_CRYSTAL) && !this.an) {
                     if (var18 - this.ah < 0L) {
                        this.g(this.ah);
                        return;
                     }

                     var2 = ThreadLocalRandom.current().nextInt(1, 101);
                     if (var2 <= this.t.g()) {
                        if (var1 || FrameClockCache.i(a.player)) {
                           this.an = ViewLocator.a(Items.END_CRYSTAL);
                           this.ah = var18 + this.s.ns();
                        }
                     } else {
                        this.ah = var18 + 50000000L;
                        this.g(this.ah);
                     }
                  }

                  if (a.player.getMainHandStack().isOf(Items.END_CRYSTAL)) {
                     try {
                        if (ConfigBridge.c != null && ConfigBridge.c.c() != null) {
                           BuilderFactory var9 = ConfigBridge.c.c().a(CalculateRange.class);
                           if (var9 != null && !var9.f()) {
                              var9.e();
                           }
                        }
                     } catch (Exception var14) {
                     }
                  }
               }
            }
         }
      }
   }

   private BlockHitResult m_r102() {

      try {
         HitResult var1 = a.player
            .raycast(Math.min(this.ab.f(), (double)(-1979125913 ^ -1839872159 ^ SortableData.d[1])), a.getRenderTickCounter().getTickProgress(true), false);
         if (var1 instanceof BlockHitResult) {
            return (BlockHitResult)var1;
         }
      } catch (Throwable var3) {
      }

      return a.crosshairTarget instanceof BlockHitResult var4 ? var4 : null;
   }

   private boolean n(BlockPos var1) {

      if (a.world == null) {
         return false;
      } else {
         BlockState var2 = a.world.getBlockState(var1);
         return var2.getBlock() == Blocks.RESPAWN_ANCHOR ? (Integer)var2.get(RespawnAnchorBlock.CHARGES) != 0 : false;
      }
   }

   @Override
   public void a(BufferEncoder var1) {

      if (a.player != null) {
         ItemStack var2 = a.player.getMainHandStack();
         if ((var2.isOf(Items.END_CRYSTAL) || var2.isOf(Items.OBSIDIAN))
            && GLFW.glfwGetMouseButton(a.getWindow().getHandle(), 1) != 1) {
            var1.b();
         } else if (this.o(var2)) {
            var1.b();
         }
      }
   }

   private boolean o(ItemStack var1) {

      if (this.al && !this.am && var1.isOf(Items.OBSIDIAN) && this.u.ns() > 0L) {
         BlockHitResult var2 = this.m_r102();
         if (var2 != null && var2.getType() == HitResult.Type.BLOCK) {
            BlockPos var3 = var2.getBlockPos();
            return !TaskJoiner.a(var3, Blocks.OBSIDIAN) && (!TaskJoiner.a(var3, Blocks.RESPAWN_ANCHOR) || !this.n(var3));
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   public void a(LinkerFactory var1) {

      if (a.player != null
         && a.player.getMainHandStack().isOf(Items.END_CRYSTAL)
         && GLFW.glfwGetMouseButton(a.getWindow().getHandle(), 0) != 1) {
         var1.b();
      }
   }

   public boolean p() {

      if (this.al) {
         return true;
      } else {
         int var1 = this.q.g();
         return var1 != -1 && this.aa.f() && SlotInspector.a(var1);
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
