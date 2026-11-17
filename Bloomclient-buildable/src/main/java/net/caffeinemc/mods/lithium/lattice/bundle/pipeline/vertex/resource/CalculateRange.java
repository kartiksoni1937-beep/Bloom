package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource;

import java.util.List;
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
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.NodeKeeper;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.SlotInspector;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.TaskJoiner;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.ViewLocator;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.SortableData;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Box;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.util.hit.HitResult;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.client.network.AbstractClientPlayerEntity;

public final class CalculateRange extends BuilderFactory implements InitNotifier, net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.CalculateRange {
   private final ItemDescriptor v;
   private final TimingEntry w;
   private final TimingEntry y;
   private final BlockCalculator z;
   private final BlockCalculator aa;
   private final CheckerBridge ab;
   private final CheckerBridge ac;
   private final CheckerBridge ad;
   private final CheckerBridge ae;
   private final CheckerBridge af;
   private final BlockCalculator ag;
   private final CheckerBridge ah;
   private static final int ai = 20;
   private static final int aj = 408758308;
   private static final int ak = 8;
   private static final long al = 50000000L;
   private static final long am = 50000000L;
   private static final long an = 60000000L;
   private long ao;
   private long ap;
   private int aq;
   private BlockPos ar;
   private long as;
   private boolean at;
   private final Runnable au;
   public boolean x;
   private int av;
   private BlockPos aw;
   private int ax;
   private Entity ay;
   private int az;
   private long ba;
   private int bb;
   private int bc;
   private int bd;
   private BlockPos pendingCrystalPos;
   private int pendingCrystalAge = Integer.MIN_VALUE;
   private static int be = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   public CalculateRange() {
      super("", "", ParserEngine.CT);
      this.setName(new char[]{'軨', '軦', '躒', '轲', '轊', '轤', '輠', '述', '还', '辳', '辫', '辟', '遱'}, 1201376937, new char[0], 1761688743);
      ItemDescriptor var10001 = new ItemDescriptor("", 1, false);
      var10001.n(new char[]{'暎', '曀', '杮', '杘', '朢', '朜', '柨', '柜', '枢', '柆', '桎', '桁', '栺'}, 1337288399);
      this.v = var10001;
      TimingEntry var1 = new TimingEntry("", 0.0, 1050.0, 50.0, 1.0, 50.0, 50.0);
      var1.n(new char[]{'屔', '對', '尮', '尀', '峣', '峺', '岞', '岙', '岙', '嵷', '嵛', '崠'}, -2147394556);
      this.w = var1;
      TimingEntry var2 = new TimingEntry("", 0.0, 1050.0, 50.0, 1.0, 50.0, 50.0);
      var2.n(new char[]{'痾', '痵', '疈', '發', '癙', '瘼', '癖', '监', '监', '皿', '皓', '睨'}, -1797491268);
      this.y = var2;
      BlockCalculator var3 = new BlockCalculator("", 0.0, 100.0, 100.0, 1.0);
      var3.n(new char[]{'ⱌ', 'Ⱅ', 'ⰶ', 'Ⱈ', '⳻', 'Ⳓ', '\u2cf6', 'Ⲷ', '\u2d7c', 'ⵒ', 'ⴼ', 'ⴒ', 'ⷵ'}, 65023004);
      this.z = var3;
      BlockCalculator var4 = new BlockCalculator("", 0.0, 100.0, 100.0, 1.0);
      var4.n(new char[]{'硽', '硰', '砏', '磹', '磚', '碱', '磙', '祛', '祟', '礷', '礛', '秷', '秖'}, -752191425);
      this.aa = var4;
      CheckerBridge var5 = new CheckerBridge("", false);
      var5.n(
         new char[]{'\udf2d', '\udfb3', '\udfc8', '\udfb4', '\udf8a', '\ue039', '\ue077', '\ue039', '\ue056', '\ue0de', '\ue0dd', '\ue0bf', '\ue09e'},
         -219816066
      );
      this.ab = var5;
      CheckerBridge var6 = new CheckerBridge("", false);
      var6.n(new char[]{'霷', '鞾', '韎', '鞥', '鞈', '頬', '须', '頿', '頇', '飫', '飏'}, -1392994447);
      this.ac = var6;
      CheckerBridge var7 = new CheckerBridge("", false);
      var7.n(new char[]{'꣦', '꣪', 'ꢏ', 'ꥫ', 'ꥂ', '꤫', '\ua97f', '꤭', 'ꧩ', '꧕', 'ꦶ', 'ꦏ', 'ꩵ', '꩙', 'ꨣ', 'ꨟ', '\uaafa', '\uaada'}, -1539987291);
      this.ad = var7;
      CheckerBridge var8 = new CheckerBridge("", false);
      var8.n(new char[]{'햸', '혵', '홛', '혴', '혙', '훰', '훓', '훵', '횠', '흺', '흑', '휺'}, -1793731076);
      this.ae = var8;
      CheckerBridge var9 = new CheckerBridge("", false);
      var9.n(new char[]{'踲', '躼', '軟', '躤', '躆', '輮', '轺', '輩', '輊', '迡', '过', '辭', '辔', '遵'}, 1365675635);
      this.af = var9;
      BlockCalculator var10 = new BlockCalculator("", 0.0, 100.0, 20.0, 1.0);
      var10.n(new char[]{'뎦', '됻', '둕', '됡', '됆', '듸', '듓', '뒣', '뒋', '딭', '땯', '딣', '딋', '뗧', '뗋', '떢'}, -1326795786);
      this.ag = var10;
      CheckerBridge var11 = new CheckerBridge("", true);
      var11.n(new char[]{'⣵', '⣡', '⢀', '⥩', '⤌', '⤜', '⤃', '⧽', '⧀', '⧧', '⦮', '⩬', '⩐'}, -551868240);
      this.ah = var11;
      this.aq = -1073741824;
      this.au = this::b;
      this.av = 0;
      this.aw = null;
      this.ax = -1073741824;
      this.bb = 4;
      this.bc = -1;
      this.bd = -1;
      this.a(new InitAdapter[]{this.v, this.w, this.y, this.z, this.aa, this.ab, this.ac, this.ad, this.ae, this.af, this.ag, this.ah});
   }

   @Override
   public void c() {

      this.b.a(InitNotifier.class, this);
      this.b.a(net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.CalculateRange.class, this);
      long var1 = System.nanoTime();
      this.ao = var1;
      this.ap = var1;
      this.ar = null;
      this.at = false;
      this.x = false;
      this.av = 0;
      this.aw = null;
      this.ax = -621347507 ^ 452394317;
      this.ay = null;
      this.bb = 4;
      this.bc = -1;
      FrameClockCache.add(this.au);
      super.c();
   }

   @Override
   public void d() {

      this.b.b(InitNotifier.class, this);
      this.b.b(net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.CalculateRange.class, this);
      FrameClockCache.b(this.au);
      if (this.bc != -1 && a.player != null && !FrameClockCache.i(a.player)) {
         this.bc = -1;
      }

      this.q();
      this.m_r99();
      this.x = false;
      this.av = 0;
      this.aw = null;
      this.ay = null;
      this.pendingCrystalPos = null;
      super.d();
   }

   @Override
   public void a() {

      this.attackPendingCrystal();
      if (this.bc != -1) {
         if (a.player == null) {
            this.bc = -1;
         } else if (FrameClockCache.i(a.player)) {
            this.q();
         } else if (InitExecutor.a(a.player.getInventory()) == this.bd) {
            this.i_r8();
         }
      }

      if (a.player != null && a.world != null && a.currentScreen == null && (!this.ab.f() || !GridResolver.a()) && !a.player.isUsingItem()) {
         if (this.v.g() != -1 && !SlotInspector.a(this.v.g())) {
            if (this.x && this.ah.f() && this.aw != null && this.av < 20 && !this.j_r9()) {
               return;
            }

            long var1 = System.nanoTime();
            this.ao = var1;
            this.ap = var1;
            this.x = false;
            this.av = 0;
            this.aw = null;
         } else if (!this.ae.f() || !this.r()) {
            this.x = true;
            this.av = 0;
            if (a.player.getMainHandStack().getItem() == Items.END_CRYSTAL) {
               this.c(a.crosshairTarget, true);
            }
         }
      }
   }

   private void b() {

      if (this.x) {
         long var1 = System.nanoTime();
         if (var1 - this.ao >= 0L || var1 - this.ap >= 0L) {
            if (a.player != null
               && a.world != null
               && a.interactionManager != null
               && a.currentScreen == null
               && !a.player.isUsingItem()
               && a.player.getMainHandStack().getItem() == Items.END_CRYSTAL) {
               int var3 = this.v.g();
               if (var3 == -1 || SlotInspector.a(var3)) {
                  if ((!this.ab.f() || !GridResolver.a()) && (!this.ae.f() || !this.r())) {
                     this.c(a.player.method_76762(1.0F, a.player), false);
                  }
               }
            }
         }
      }
   }

   private void c(HitResult var1, boolean var2) {

      if (FrameClockCache.n) {
         long var3 = System.nanoTime();
         boolean var5 = this.h_r7();
         if (!var5
            && var3 - this.ao >= 0L
            && var1 instanceof BlockHitResult var6
            && var1.getType() == HitResult.Type.BLOCK
            && TaskJoiner.b(var6.getBlockPos())
            && NodeKeeper.a(var6.getBlockPos())
            && (this.at || var3 - this.as >= 50000000L || !var6.getBlockPos().equals(this.ar))) {
            int var7 = CalculateMapper.a(1, 100);
            if (var7 > this.z.g()) {
               this.ao = e(this.ao, var3) + 50000000L;
            } else {
               if (this.ad.f()) {
                  BufferNormalizer.d(1);
               }

               if (!this.canPlaceCrystal(var6.getBlockPos())) {
                  this.ao = e(this.ao, var3) + 50000000L;
                  return;
               }
               GridResolver.a(var6, true);
               this.pendingCrystalPos = var6.getBlockPos().up();
               this.pendingCrystalAge = a.player.age;
               if (this.ac.f() && (double)var7 <= this.ag.f() && NodeKeeper.a(var6.getBlockPos()) && var6.getSide() == Direction.UP) {
                  a.particleManager
                     .addParticle(
                        new BlockStateParticleEffect(ParticleTypes.BLOCK, a.world.getBlockState(var6.getBlockPos())),
                        (double)var6.getBlockPos().getX() + 0.5,
                        (double)var6.getBlockPos().getY() + 0.5,
                        (double)var6.getBlockPos().getZ() + 0.5,
                        0.0,
                        0.0,
                        0.0
                     );
               }

               this.ao = e(this.ao, var3) + this.w.ns();
               this.aw = var6.getBlockPos();
               this.ax = a.player.age;
               this.ar = var6.getBlockPos();
               this.as = var3;
               this.at = false;
            }
         }

         if (var1 instanceof EntityHitResult var11) {
            Entity var12 = var11.getEntity();
            this.d(var12);
            // Never combine a placement and an entity attack in the same tick, and never
            // attack an entity the client world does not actually know about.
            if (var12 instanceof EndCrystalEntity && a.player.age == this.pendingCrystalAge) {
               return;
            }
            if (!this.isKnownEntity(var12)) {
               return;
            }
            if (var5 || var3 - this.ap < 0L) {
               return;
            }

            if (var12 == this.ay && var3 - this.ba < 50000000L) {
               return;
            }

            boolean var8 = var12 instanceof EndCrystalEntity || var12 instanceof SlimeEntity;
            if (!this.ac.f() && !var8) {
               return;
            }

            if (CalculateMapper.a(1, 100) > this.aa.g()) {
               this.ap = e(this.ap, var3) + 50000000L;
               return;
            }

            int var9 = InitExecutor.a(a.player.getInventory());
            if (var8 && this.af.f() && this.p() && this.g_r6()) {
               if (!FrameClockCache.i(a.player)) {
                  if (var2) {
                     this.i_r8();
                  }

                  return;
               }

               ViewLocator.a();
            }

            if (this.ad.f()) {
               BufferNormalizer.d(0);
            }

            GridResolver.a(var12, true);
            this.ap = e(this.ap, var3) + this.y.ns();
            if (var12 instanceof EndCrystalEntity) {
               this.ay = var12;
               this.az = a.player.age;
               this.ba = var3;
            }

            if (this.af.f()) {
               int var10 = InitExecutor.a(a.player.getInventory());
               if (var10 != var9) {
                  this.bc = var9;
                  this.bd = var10;
               }
            }
         }
      }
   }

   private boolean canPlaceCrystal(BlockPos var1) {

      return a.world != null
         && !a.world.getBlockState(var1).isAir()
         && !a.world.getBlockState(var1.down()).isAir()
         && a.world.getBlockState(var1.up()).isAir();
   }

   private boolean isKnownEntity(Entity var1) {

      return var1 != null
         && a.world != null
         && !var1.isRemoved()
         && var1.isAlive()
         && a.world.getEntityById(var1.getId()) == var1;
   }

   private void attackPendingCrystal() {

      if (this.pendingCrystalPos == null) {
         return;
      }

      if (a.player == null || a.world == null || a.interactionManager == null) {
         this.pendingCrystalPos = null;
         return;
      }

      // The crystal must exist in the client world before an attack may be sent.
      if (a.player.age <= this.pendingCrystalAge) {
         return;
      }

      BlockPos var1 = this.pendingCrystalPos;
      this.pendingCrystalPos = null;
      if (a.player.age - this.pendingCrystalAge > 10) {
         return;
      }

      for (Entity var4 : a.world.getOtherEntities(null, new Box(var1))) {
         if (var4 instanceof EndCrystalEntity && this.isKnownEntity(var4) && var4.getBlockPos().equals(var1)) {
            GridResolver.a(var4, true);
            this.ay = var4;
            this.az = a.player.age;
            this.ba = System.nanoTime();
            return;
         }
      }
   }

   private void d(Entity var1) {

      BlockPos var2 = this.ar;
      if (var2 != null && var1 instanceof EndCrystalEntity) {
         BlockPos var3 = var1.getBlockPos();
         if (var3.getX() == var2.getX() && var3.getY() == var2.getY() + 1 && var3.getZ() == var2.getZ()) {
            this.at = true;
         }
      }
   }

   private static long e(long var0, long var2) {

      return var2 - var0 <= 60000000L ? var0 : var2;
   }

   private boolean g_r6() {

      for (int var1 = 0; var1 < 9; var1++) {
         if (InitExecutor.a(a.player.getInventory().getStack(var1).getItem())) {
            return true;
         }
      }

      return false;
   }

   private boolean h_r7() {

      return FrameClockCache.k(a.player) && a.player.age != this.aq + 1;
   }

   private void i_r8() {

      FrameClockCache.j(a.player);
      this.aq = a.player.age;
   }

   @Override
   public void a(BufferEncoder var1) {

      if (a.player != null
         && a.player.getMainHandStack().getItem() == Items.END_CRYSTAL
         && a.crosshairTarget instanceof BlockHitResult var2
         && a.crosshairTarget.getType() == HitResult.Type.BLOCK
         && TaskJoiner.b(var2.getBlockPos())) {
         var1.b();
      }
   }

   private boolean j_r9() {

      this.av++;
      if (this.av == 1) {
         this.o();
      }

      Entity var1 = this.k_r10();
      if (var1 != null) {
         return this.l(var1);
      } else {
         int var2 = a.player.age - this.ax;
         return (var2 < 0 || var2 > Math.max(this.bb, 8)) && !this.n(this.aw);
      }
   }

   private Entity k_r10() {

      BlockPos var1 = this.aw;
      if (var1 == null) {
         return null;
      } else if (!(a.player.method_76762(1.0F, a.player) instanceof EntityHitResult var3)) {
         return null;
      } else {
         Entity var4 = var3.getEntity();
         if (var4 instanceof EndCrystalEntity && var4.isAlive() && (var4 != this.ay || a.player.age - this.az > this.bb)) {
            return var4.getBlockPos().equals(var1.up()) ? var4 : null;
         } else {
            return null;
         }
      }
   }

   private boolean l(Entity var1) {
      int var2 = 0;
      int var3 = 0;
      byte var4 = 0;

      while (true) {
         label63:
         while (true) {
            label61:
            while (true) {
               switch (var4) {
                  case 0:
                  default:
                     if (be != 0) {
                        Thread.currentThread().getName().length();
                        var4 = 3;
                        continue;
                     }
                  case 3:
                     if (this.h_r7()) {
                        return false;
                     }
                  case 4:
                     var2 = InitExecutor.a(a.player.getInventory());
                     if (this.af.f() && this.p() && !InitExecutor.a(a.player.getMainHandStack().getItem())) {
                        var3 = a.player.age;
                        if (InitExecutor.o != var3 && InitExecutor.p != var3) {
                           if (!a.player.handSwinging) {
                              break label61;
                           }

                           if (a.player.handSwingTicks >= 0) {
                              var4 = 8;
                              continue;
                           }
                        }
                        break;
                     }
                  case 7:
                     if (this.ad.f()) {
                        BufferNormalizer.d(0);
                        var4 = 5;
                        continue;
                     }
                  case 5:
                     GridResolver.a(var1, true);
                     this.d(var1);
                     this.ay = var1;
                     this.az = a.player.age;
                     this.ba = System.nanoTime();
                     if (this.af.f()) {
                        var3 = InitExecutor.a(a.player.getInventory());
                        if (var3 != var2) {
                           this.bc = var2;
                           this.bd = var3;
                           var4 = 1;
                           continue;
                        }
                     }

                     return true;
                  case 1:
                     return true;
                  case 2:
                     break label63;
                  case 6:
                     break;
                  case 8:
                     break label61;
                  case 9:
                     return false;
               }

               if (FrameClockCache.i(a.player) || !this.g_r6()) {
                  return false;
               }

               this.i_r8();
               var4 = 9;
            }

            if (FrameClockCache.i(a.player)) {
               break;
            }

            var4 = 6;
         }

         ViewLocator.a();
         var4 = 7;
      }
   }

   private void m_r99() {

      if (this.x
         && this.ah.f()
         && this.aw != null
         && a.player != null
         && a.world != null
         && a.currentScreen == null
         && !a.player.isUsingItem()
         && (!this.ab.f() || !GridResolver.a())) {
         if (!this.af.f() || !this.p() || InitExecutor.a(a.player.getMainHandStack().getItem())) {
            Entity var1 = this.k_r10();
            if (var1 != null) {
               GridResolver.a(var1, true);
            }
         }
      }
   }

   private boolean n(BlockPos var1) {

      if (var1 != null && a.world != null) {
         BlockPos var2 = var1.up();

         for (Entity var4 : a.world.getOtherEntities(null, new Box(var2))) {
            if (var4 instanceof EndCrystalEntity && var4.isAlive() && var4.getBlockPos().equals(var2)) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   private void o() {

      int var1 = 4;
      ClientPlayNetworkHandler var2 = a.getNetworkHandler();
      if (var2 != null) {
         PlayerListEntry var3 = var2.getPlayerListEntry(a.player.getUuid());
         if (var3 != null) {
            var1 = Math.min(12, Math.max(0, var3.getLatency()) / 50 + 4);
         }
      }

      this.bb = var1;
   }

   private boolean p() {

      StatusEffectInstance var1 = a.player.getStatusEffect(StatusEffects.WEAKNESS);
      StatusEffectInstance var2 = a.player.getStatusEffect(StatusEffects.STRENGTH);
      return var1 != null && (var2 == null || var2.getAmplifier() <= var1.getAmplifier());
   }

   private void q() {

      if (this.bc != -1 && a.player != null && InitExecutor.a(a.player.getInventory()) == this.bd) {
         ViewLocator.a(this.bc);
      }

      this.bc = -1;
   }

   private boolean r() {

      if (a.player.getAttacking() instanceof PlayerEntity) {
         return false;
      } else {
         List var1 = a.world.getPlayers();

         for (int var2 = 0; var2 < var1.size(); var2++) {
            AbstractClientPlayerEntity var3 = (AbstractClientPlayerEntity)var1.get(var2);
            if (var3 != a.player
               && var3.squaredDistanceTo(a.player) < (double)(143830732 ^ 282035944 ^ SortableData.d[1])
               && var3.getLastAttacker() == null
               && !var3.isOnGround()
               && var3.hurtTime >= 2) {
               return true;
            }
         }

         return false;
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
