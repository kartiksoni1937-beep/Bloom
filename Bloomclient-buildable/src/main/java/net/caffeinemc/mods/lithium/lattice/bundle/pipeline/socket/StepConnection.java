package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket;

import java.util.List;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.InitNotifier;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.ParserEngine;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.BlockCalculator;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.CheckerBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.ItemDescriptor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.BufferNormalizer;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.CalculateMapper;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.FrameClockCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.GridResolver;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.InitExecutor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.SlotInspector;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.ViewLocator;
import net.minecraft.util.Hand;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.util.hit.HitResult;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;

public final class StepConnection extends BuilderFactory implements InitNotifier {
   private static final int v = 20;
   private static final int w = 6;
   private final ItemDescriptor x;
   private final CheckerBridge y;
   private final BlockCalculator z;
   private final BlockCalculator aa;
   private final BlockCalculator ab;
   private final BlockCalculator ac;
   private final CheckerBridge ad;
   private final CheckerBridge ae;
   private final BlockCalculator af;
   private final CheckerBridge ag;
   private int ah;
   private int ai;
   private BlockPos aj;
   private int ak;
   private int al;
   private boolean am;
   private int an;
   private int ao;
   private boolean ap;
   private int aq;
   private int ar;
   private final Runnable as;
   private int at;
   private long au;
   private BlockPos av;
   private long aw;
   private int ax;
   private boolean ay;
   private long az;
   private static final long ba = 100000000L;
   private static final long bb = 50000000L;
   private static int bc = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   public StepConnection() {
      super("", "", ParserEngine.V2);
      this.setName(
         new char[]{'ᤎ', '\u19ae', '᧱', '\u19db', '᧽', 'ᦒ', 'ᩲ', 'ᩔ', 'ᨼ', 'ᩘ', '\u1af2', '\u1adf', '᪲', '\u1a9c', '᭧', 'ᬒ', 'ᬜ', 'ᬑ', 'ᯬ', 'ᯜ', 'ᮢ'},
         -699524767,
         new char[0],
         -502394984
      );
      ItemDescriptor var10001 = new ItemDescriptor("", 3, false);
      var10001.n(new char[]{'㱅', '㰉', '㰧', '㰆', '㳶', '㳌', '㳢', '㲪', '㵥', '㵦'}, 1898003464);
      this.x = var10001;
      CheckerBridge var1 = new CheckerBridge("", true);
      var1.n(new char[]{'࿂', 'ྱ', '࿒', 'ྼ', 'ྈ', 'ၺ', 'ၔ', 'ိ', 'ၘ', 'ლ', 'კ', 'Ⴑ', '႑'}, -986443904);
      this.y = var1;
      BlockCalculator var2 = new BlockCalculator("", 0.0, 20.0, 0.0, 1.0);
      var2.n(new char[]{'\ue9ea', '\ue9f7', '\ue994', '\uea76', '\uea55', '\uea30', '\uea54', '\ueaf7', '\uead7', '\ueabd', '\uea91', '\ueb76'}, 721873338);
      this.z = var2;
      BlockCalculator var3 = new BlockCalculator("", 0.0, 20.0, 0.0, 1.0);
      var3.n(new char[]{'弱', '徼', '心', '徵', '徎', '恥', '怍', '怨', '怎', '惦', '惈', '悱'}, -209756301);
      this.aa = var3;
      BlockCalculator var4 = new BlockCalculator("", 0.0, 100.0, 100.0, 1.0);
      var4.n(new char[]{'댗', '덈', '돩', '독', '뎠', '뎇', '됡', '둃', '둗', '됿', '됓', '듿', '듞'}, 578663239);
      this.ab = var4;
      BlockCalculator var5 = new BlockCalculator("", 0.0, 100.0, 100.0, 1.0);
      var5.n(new char[]{'\u0ff6', '\u0ffd', 'ྀ', 'ၴ', 'ၑ', 'ဤ', '၎', 'ხ', 'Ⴤ', 'Ⴊ', 'ႄ', 'ᅪ', 'ᅍ'}, -766373964);
      this.ac = var5;
      CheckerBridge var6 = new CheckerBridge("", false);
      var6.n(
         new char[]{
            '\udf2d',
            '\udfa3',
            '\udfc0',
            '\udfa2',
            '\udf89',
            '\ue062',
            '\ue008',
            '\ue014',
            '\ue00f',
            '\ue0e8',
            '\ue0d1',
            '\ue0af',
            '\ue083',
            '\ue175',
            '\ue149',
            '\ue150',
            '\ue130'
         },
         -1761484946
      );
      this.ad = var6;
      CheckerBridge var7 = new CheckerBridge("", false);
      var7.n(new char[]{'䧔', '䦟', '䦱', '䦄', '䩫', '䨍', '䨼', '䨞', '䫤', '䫊', '䪠'}, -1198241390);
      this.ae = var7;
      BlockCalculator var8 = new BlockCalculator("", 0.0, 100.0, 20.0, 1.0);
      var8.n(new char[]{'ō', 'Ē', 'ĺ', 'Ĉ', 'ǭ', 'Ǒ', 'ƴ', 'ƚ', 'ɰ', 'Ȕ', 'Ȑ', 'Ț', '˰', '˞', 'ʬ', 'ʋ'}, 997327133);
      this.af = var8;
      CheckerBridge var9 = new CheckerBridge("", true);
      var9.n(new char[]{'颶', '餪', '饔', '餫', '餕', '駣', '駷', '馞', '馟', '馝', '驸', '驑'}, 415930597);
      this.ag = var9;
      this.ah = 0;
      this.ai = 0;
      this.aj = null;
      this.ak = 0;
      this.al = -1073741824;
      this.am = false;
      this.an = -1;
      this.ao = -1;
      this.ap = false;
      this.aq = Integer.MIN_VALUE;
      this.ar = 0;
      this.as = this::b;
      this.at = -1;
      this.av = null;
      this.ax = -1;
      this.a(this.x, this.y, this.z, this.aa, this.ab, this.ac, this.ad, this.ae, this.af, this.ag);
   }

   @Override
   public void c() {

      this.b.a(InitNotifier.class, this);
      FrameClockCache.add(this.as);
      this.at = -1;
      this.av = null;
      this.ax = -1;
      this.ah = 0;
      this.ai = 0;
      this.i_r84();
      this.am = false;
      this.an = -1;
      this.ao = -1;
      this.ap = false;
      this.aq = 868001808 ^ -1279481840;
      super.c();
   }

   @Override
   public void d() {

      this.b.b(InitNotifier.class, this);
      FrameClockCache.b(this.as);
      if (this.ag.f() && (this.am || this.ap) && a.player != null && !this.e(a.player.age)) {
         this.g_r83();
      }

      this.am = false;
      this.ap = false;
      this.an = -1;
      this.ao = -1;
      this.i_r84();
      super.d();
   }

   @Override
   public void a() {

      if (a.player == null || a.world == null) {
         this.am = false;
         this.ap = false;
         this.an = -1;
         this.ao = -1;
         this.i_r84();
      } else if (a.currentScreen == null) {
         int var1 = a.player.age;
         if (!SlotInspector.a(this.x.g())) {
            if (this.am) {
               this.am = false;
               this.ah = 0;
               this.ai = 0;
               this.i_r84();
               this.ap = this.ag.f() && this.an != -1 && this.ao != -1;
               if (!this.ap) {
                  this.an = -1;
                  this.ao = -1;
               }
            }

            if (this.ap && !this.e(var1)) {
               this.g_r83();
            }
         } else {
            if (!this.am) {
               this.am = true;
               if (!this.ap) {
                  this.an = InitExecutor.a(a.player.getInventory());
                  this.ao = -1;
               }

               this.ap = false;
            }

            if (this.ah > 0) {
               this.ah--;
            }

            if (this.ai > 0) {
               this.ai--;
            }

            HitResult var2;
            BlockHitResult var3;
            Entity var4;
            label172: {
               var2 = a.player.method_76762(1.0F, a.player);
               var3 = null;
               var4 = null;
               if (var2 instanceof BlockHitResult var5 && var2.getType() == HitResult.Type.BLOCK) {
                  var3 = var5;
                  break label172;
               }

               if (var2 instanceof EntityHitResult var6 && var6.getEntity() instanceof EndCrystalEntity && var6.getEntity().isAlive()) {
                  var4 = var6.getEntity();
               }
            }

            if (var4 != null && this.ai == 0 && CalculateMapper.a(1, 100) <= this.ac.g()) {
               if (this.ad.f()) {
                  BufferNormalizer.d(0);
               }

               GridResolver.a(var4, true);
               this.aq = var1;
               this.ai = this.aa.g();
               this.at = var4.getId();
               this.au = System.nanoTime();
               this.av = null;
               var2 = a.player.method_76762(1.0F, a.player);
               var3 = null;
               if (var2 instanceof BlockHitResult var9 && var2.getType() == HitResult.Type.BLOCK) {
                  var3 = var9;
               }
            }

            BlockPos var10 = this.aj;
            if (var10 != null && (!j(var10) || !a.player.canInteractWithBlockAt(var10, 1.0))) {
               var10 = null;
               this.aj = null;
            }

            BlockPos var11 = null;
            if (var3 != null) {
               var11 = var3.getBlockPos();
            }

            if (var10 != null) {
               boolean var7 = false;
               if (var11 != null) {
                  var7 = k(var11, var10);
               } else if (var4 != null) {
                  var7 = k(var4.getBlockPos(), var10);
               }

               this.ak = var7 ? 0 : this.ak + 1;
            }

            int var12 = CalculateMapper.a(1, 100);
            if (var11 != null && j(var11)) {
               if (var10 == null || var11.equals(var10) || this.y.f() || this.ak >= 6) {
                  this.aj = var11;
                  this.ak = 0;
                  if (this.ah == 0 && var12 <= this.ab.g() && this.m(var11)) {
                     int var8 = f(Items.END_CRYSTAL);
                     if (var8 >= 0 && this.d(var8, var1)) {
                        if (this.ad.f()) {
                           BufferNormalizer.d(1);
                        }

                        GridResolver.a(var3, true);
                        this.aq = var1;
                        this.ar = 0;
                        this.av = var11;
                        this.aw = System.nanoTime();
                        if (this.ae.f() && var12 <= this.af.g()) {
                           a.particleManager
                              .addParticle(
                                 new BlockStateParticleEffect(ParticleTypes.BLOCK, a.world.getBlockState(var11)),
                                 (double)var11.getX() + 0.5,
                                 (double)var11.getY() + 0.5,
                                 (double)var11.getZ() + 0.5,
                                 0.0,
                                 0.0,
                                 0.0
                              );
                        }

                        this.ah = this.z.g();
                     }
                  }
               }
            } else if (var11 != null
               && this.ah == 0
               && var12 <= this.ab.g()
               && this.ar < 3
               && var1 - this.al > 20
               && (var10 == null || this.ak >= 6)
               && !l(var11)) {
               this.c(var3, var1);
            }

            this.h(var2, var1);
         }
      }
   }

   private void b() {

      if (FrameClockCache.n) {
         if (this.am
            && a.player != null
            && a.world != null
            && a.interactionManager != null
            && a.currentScreen == null
            && SlotInspector.a(this.x.g())
            && !FrameClockCache.k(a.player)) {
            long var1 = System.nanoTime();
            int var3 = a.player.age;
            HitResult var4 = a.player.method_76762(1.0F, a.player);
            if (this.ai == 0 && var4 instanceof EntityHitResult var5 && var5.getEntity() instanceof EndCrystalEntity && var5.getEntity().isAlive()) {
               Entity var6 = var5.getEntity();
               int var7 = var6.getId();
               if (var7 != this.ax) {
                  this.ax = var7;
                  this.ay = CalculateMapper.a(1, 100) <= this.ac.g();
               }

               if (this.ay && (var7 != this.at || var1 - this.au >= 100000000L)) {
                  if (this.ad.f()) {
                     BufferNormalizer.d(0);
                  }

                  GridResolver.a(var6, true);
                  this.aq = var3;
                  this.ai = this.aa.g();
                  this.at = var7;
                  this.au = var1;
                  this.av = null;
                  var4 = a.player.method_76762(1.0F, a.player);
               }
            }

            if (this.ah == 0 && var4 instanceof BlockHitResult var8 && var4.getType() == HitResult.Type.BLOCK) {
               BlockPos var9 = var8.getBlockPos();
               BlockPos var10 = this.aj;
               if (j(var9) && (var10 != null || this.y.f()) && (var10 == null || var9.equals(var10) || this.y.f())) {
                  if (a.player.getMainHandStack().isOf(Items.END_CRYSTAL) && this.m(var9)) {
                     if (var9.equals(this.av) && var1 - this.aw < 100000000L) {
                        return;
                     }

                     if (var1 - this.az < 50000000L) {
                        return;
                     }

                     if (CalculateMapper.a(1, 100) > this.ab.g()) {
                        this.az = var1;
                        return;
                     }

                     if (this.ad.f()) {
                        BufferNormalizer.d(1);
                     }

                     GridResolver.a(var8, true);
                     this.aq = var3;
                     this.ah = this.z.g();
                     this.ar = 0;
                     this.aj = var9;
                     this.av = var9;
                     this.aw = var1;
                     return;
                  }

                  return;
               }

               return;
            }
         }
      }
   }

   private boolean c(BlockHitResult var1, int var2) {

      int var3 = f(Items.OBSIDIAN);
      if (var3 < 0) {
         return false;
      } else {
         ItemStack var4 = a.player.getInventory().getStack(var3);
         ItemPlacementContext var5 = new ItemPlacementContext(a.player, Hand.MAIN_HAND, var4, var1);
         BlockPos var6 = var5.getBlockPos();
         if (!var5.canPlace()
            || !a.world.getWorldBorder().contains(var6)
            || !a.world.isAir(var6.up())
            || !a.world.canPlace(Blocks.OBSIDIAN.getDefaultState(), var6, ShapeContext.ofPlacement(a.player))
            || l(var6)) {
            return false;
         } else if (!this.d(var3, var2)) {
            return false;
         } else {
            if (this.ad.f()) {
               BufferNormalizer.d(1);
            }

            GridResolver.a(var1, true);
            this.aq = var2;
            this.ah = this.z.g();
            this.al = var2;
            this.ak = 0;
            if (j(var6)) {
               this.aj = var6;
               this.ar++;
            } else {
               this.ar = 3;
            }

            return true;
         }
      }
   }

   private boolean d(int var1, int var2) {

      PlayerInventory var3 = a.player.getInventory();
      if (InitExecutor.a(var3) == var1) {
         return true;
      } else if (this.e(var2)) {
         return false;
      } else {
         InitExecutor.a(var3, var1);
         this.ao = var1;
         return true;
      }
   }

   private boolean e(int var1) {

      return this.aq == var1 || InitExecutor.o == var1 || InitExecutor.p == var1 || a.player.handSwinging && a.player.handSwingTicks < 0;
   }

   private static int f(Item var0) {

      PlayerInventory var1 = a.player.getInventory();
      int var2 = InitExecutor.a(var1);
      if (var1.getStack(var2).isOf(var0)) {
         return var2;
      } else {
         for (int var3 = 0; var3 < 9; var3++) {
            if (var1.getStack(var3).isOf(var0)) {
               return var3;
            }
         }

         return -1;
      }
   }

   private void g_r83() {

      if (a.player != null && this.an != -1 && this.ao != -1 && InitExecutor.a(a.player.getInventory()) == this.ao) {
         ViewLocator.a(this.an);
      }

      this.ap = false;
      this.an = -1;
      this.ao = -1;
   }

   private void h(HitResult var1, int var2) {
      int var3 = 0;
      byte var4 = 0;

      while (true) {
         switch (var4) {
            case 0:
            default:
               if (bc != 0) {
                  System.nanoTime();
                  var4 = 2;
                  break;
               }
            case 2:
               if (!this.ae.f() || this.aq == var2 || var1 == null || var1.getType() != HitResult.Type.MISS) {
                  return;
               }

               var3 = CalculateMapper.a(1, 100);
               if (this.ai != 0 || var3 > this.ac.g()) {
                  return;
               }

               if (a.interactionManager.hasLimitedAttackSpeed()) {
                  a.attackCooldown = 10;
                  var4 = 3;
                  break;
               }
            case 3:
               if (this.ad.f()) {
                  BufferNormalizer.d(0);
                  var4 = 4;
                  break;
               }
            case 4:
               a.player.clearActiveItem();
               a.player.swingHand(Hand.MAIN_HAND);
               this.aq = var2;
               this.ai = this.aa.g();
               var4 = 1;
               break;
            case 1:
               return;
         }
      }
   }

   private void i_r84() {

      this.aj = null;
      this.ak = 0;
      this.al = 947887862 ^ -125853962;
      this.ar = 0;
   }

   private static boolean j(BlockPos var0) {

      BlockState var1 = a.world.getBlockState(var0);
      return var1.isOf(Blocks.OBSIDIAN) || var1.isOf(Blocks.BEDROCK);
   }

   private static boolean k(BlockPos var0, BlockPos var1) {

      return Math.abs(var0.getX() - var1.getX()) <= 2
         && Math.abs(var0.getY() - var1.getY()) <= 2
         && Math.abs(var0.getZ() - var1.getZ()) <= 2;
   }

   private static boolean l(BlockPos var0) {

      BlockPos.Mutable var1 = new BlockPos.Mutable();
      int var2 = var0.getX();
      int var3 = var0.getY();
      int var4 = var0.getZ();

      for (int var5 = -1; var5 <= 1; var5++) {
         for (int var6 = -1; var6 <= 1; var6++) {
            for (int var7 = -1; var7 <= 1; var7++) {
               BlockState var8 = a.world.getBlockState(var1.set(var2 + var5, var3 + var6, var4 + var7));
               if (var8.isOf(Blocks.OBSIDIAN) || var8.isOf(Blocks.BEDROCK)) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   private boolean m(BlockPos var1) {

      BlockPos var2 = var1.up();
      if (!a.world.isAir(var2)) {
         return false;
      } else {
         double var3 = (double)var2.getX();
         double var5 = (double)var2.getY();
         double var7 = (double)var2.getZ();
         return a.world.getOtherEntities(null, new Box(var3, var5, var7, var3 + 1.0, var5 + 2.0, var7 + 1.0)).isEmpty();
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
