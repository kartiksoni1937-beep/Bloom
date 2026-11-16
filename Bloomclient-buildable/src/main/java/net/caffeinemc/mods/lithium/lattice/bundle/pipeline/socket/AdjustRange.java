package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.InitNotifier;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.ParserEngine;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.SyncDispatcher;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.BlockCalculator;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.CheckerBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.ItemDescriptor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.SlotEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.InitExecutor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.LockD;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.client.input.KeyboardInput;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.registry.tag.DamageTypeTags;
import org.lwjgl.glfw.GLFW;

public class AdjustRange extends BuilderFactory implements InitNotifier {
   private static final int o = 3;
   private static final int p = 10;
   private static final int q = 4;
   private static final double r = 0.05;
   private static final int s = 40;
   private static final double t = 0.01;
   private static final double u = 1.5;
   private static final double v = 1.0E9;
   private final BlockCalculator w;
   private final SlotEntry x;
   private final CheckerBridge y;
   private final CheckerBridge z;
   private final CheckerBridge aa;
   private final CheckerBridge ab;
   public static volatile boolean ON;
   public static boolean KB;
   public static boolean PEND;
   public static boolean HOLD;
   public static boolean SPR;
   public static AdjustRange I;
   private int ac;
   private int ad;
   private Object ae;
   private double af;
   private double ag;
   private double ah;

   public AdjustRange() {
      super("", "", ParserEngine.PC);
      this.setName(
         new char[]{'쵤', '쵪', '촖', '췶', '췎', '췠', '축', '춋', '칰', '칌', '칻', '츨', '컼', '컋', '캲', '캂'},
         170904869,
         new char[]{
            '猸',
            '玿',
            '珅',
            '玢',
            '玞',
            '瑾',
            '琌',
            '琤',
            '琄',
            '璩',
            '瓜',
            '璯',
            '璃',
            '甥',
            '畐',
            '甪',
            '甁',
            '痪',
            '疀',
            '痚',
            '疰',
            '疘',
            '癱',
            '療',
            '発',
            '瘒',
            '盶',
            '盘',
            '皵',
            '皞',
            '睶',
            '睒',
            '眱',
            '眚',
            '瞰',
            '矃',
            '瞯',
            '瞃',
            '硨',
            '硘',
            '硦',
            '硉',
            '磿',
            '磏',
            '碣',
            '碋',
            '礤',
            '祗',
            '礪',
            '礄',
            '禠',
            '秵',
            '秋',
            '禰',
            '禌',
            '稻',
            '穉',
            '稱',
            '稗',
            '童',
            '竂',
            '窰',
            '窚',
            '筠',
            '笒',
            '笸',
            '笄'
         },
         -549162126
      );
      BlockCalculator var10001 = new BlockCalculator("", 0.0, 100.0, 100.0, 1.0);
      var10001.n(new char[]{'맅', '릀', '릸', '릁', '멻', '먊', '먛', '먍', '뫴', '뫃', '몱', '뫄', '뭀', '뭊', '묠', '묎', '묜', '믻'}, 1250605455);
      this.w = var10001;
      this.x = new SlotEntry("M.ode", "S.mart", "S.mart", "A.lways");
      CheckerBridge var1 = new CheckerBridge("", true);
      var1.n(new char[]{'韼', '韾', '鞀', '顬', '類'}, 1522374577);
      this.y = var1;
      CheckerBridge var2 = new CheckerBridge("", true);
      var2.n(new char[]{'팮', '펳', '폎', '펴', '펐', '푼', '푛', '퐣', '퐟', '퓹', '퓑', '풠'}, -1158425730);
      this.z = var2;
      CheckerBridge var3 = new CheckerBridge("", true);
      var3.n(new char[]{'镢', '镨', '锝', '间', '闏', '閭', '閒', '险', '陰', '限', '阮'}, -247556825);
      this.aa = var3;
      CheckerBridge var4 = new CheckerBridge("", true);
      var4.n(new char[]{'誦', '謺', '譃', '謠', '謘', '课', '诛', '诮', '讧', '豹', '豆', '谺'}, -828863755);
      this.ab = var4;
      this.ac = -1;
      this.ad = 3;
      this.a(this.w, this.x, this.y, this.z, this.aa, this.ab);
      I = this;
   }

   @Override
   public void c() {

      ON = true;
      KB = false;
      this.b.a(InitNotifier.class, this);
      super.c();
   }

   @Override
   public void d() {

      ON = false;
      KB = false;
      this.b.b(InitNotifier.class, this);
      super.d();
      this.f_r45();
      if (HOLD) {
         try {
            m_r110();
         } catch (Throwable var2) {
            HOLD = false;
         }
      }
   }

   @Override
   public void a() {

      try {
         this.b();
      } catch (Throwable var2) {
         this.f_r45();
      }
   }

   private void b() {

      ClientPlayerEntity var1 = a.player;
      boolean var2 = KB;
      KB = false;
      if (var1 != null && a.world != null) {
         if (var2) {
            this.c(var1, false);
         } else if (this.ac >= 0) {
            this.ac++;
            if (this.ae != var1 || this.ac > this.ad) {
               this.f_r45();
            }
         } else if (var1.hurtTime > 0 && var1.hurtTime == var1.maxHurtTime) {
            this.c(var1, true);
         }

         PEND = this.ac >= 0;
      } else {
         this.f_r45();
      }
   }

   private void c(ClientPlayerEntity var1, boolean var2) {

      this.f_r45();
      if (var1.isAlive() && var1.maxHurtTime > 0 && var1.hurtTime > 0) {
         DamageSource var3 = var1.getRecentDamageSource();
         if (var3 != null) {
            boolean var4 = var3.getAttacker() instanceof PlayerEntity && !(var3.getSource() instanceof ProjectileEntity);
            if (var1.hurtTime >= var1.maxHurtTime - (var4 ? 2 : 4)) {
               boolean var5 = var3.isIn(DamageTypeTags.IS_EXPLOSION);
               if (!var2 || var5) {
                  if (this.d(var1, var3, var5)) {
                     if (ThreadLocalRandom.current().nextInt(100) < this.w.g()) {
                        Vec3d var6 = var3.getPosition();
                        Vec3d var7 = var1.getVelocity();
                        double var8 = var7.x;
                        double var10 = var7.z;
                        if ((var2 || var8 * var8 + var10 * var10 < 1.0E-4) && var6 != null) {
                           double var12 = var1.getX() - var6.x;
                           double var14 = var1.getZ() - var6.z;
                           if (var12 * var12 + var14 * var14 > 1.0E-6) {
                              var8 = var12;
                              var10 = var14;
                           }
                        }

                        double var16 = Math.sqrt(var8 * var8 + var10 * var10);
                        if (!(var16 < 1.0E-4)) {
                           this.af = var8 / var16;
                           this.ag = var10 / var16;
                           this.ac = 0;
                           this.ae = var1;
                           this.ad = var1.isOnGround() ? 3 : 10;
                        }
                     }
                  }
               }
            }
         }
      }
   }

   private boolean d(ClientPlayerEntity var1, DamageSource var2, boolean var3) {

      Entity var4 = var2.getAttacker();
      Entity var5 = var2.getSource();
      if (var4 == var1 || var5 == var1) {
         return false;
      } else if (var3) {
         return this.aa.f() && var4 != null;
      } else if (var4 == null) {
         return false;
      } else if (var5 instanceof ProjectileEntity) {
         return this.z.f();
      } else {
         return var4 instanceof PlayerEntity ? true : var4 instanceof LivingEntity && this.y.f();
      }
   }

   private void f_r45() {

      this.ac = -1;
      this.ae = null;
      PEND = false;
   }

   public static void g_r109() {

      AdjustRange var0 = I;
      if (var0 != null && var0.f()) {
         try {
            var0.h_r47();
         } catch (Throwable var3) {
            var0.f_r45();
         }
      } else {
         PEND = false;
      }
   }

   private void h_r47() {

      ClientPlayerEntity var1 = a.player;
      GameOptions var2 = a.options;
      if (this.ac >= 0 && var1 != null && var2 != null && var1 == this.ae) {
         if (a.currentScreen != null
            || LockD.g
            || !(var1.input instanceof KeyboardInput)
            || var2.jumpKey.isPressed()
            || HOLD
            || LockD.e != null
            || System.nanoTime() < LockD.b) {
            this.f_r45();
         } else if (var1.isTouchingWater()
            || var1.isInLava()
            || var1.isClimbing()
            || var1.isGliding()
            || var1.hasVehicle()
            || var1.getAbilities().flying
            || var1.isSpectator()
            || var1.isInsideWall()
            || var1.isBlocking()
            || var1.isUsingItem()
            || var1.hasStatusEffect(StatusEffects.LEVITATION)) {
            this.f_r45();
         } else if (!var1.isOnGround()) {
            Vec3d var4 = var1.getVelocity();
            if (var4.x * this.af + var4.z * this.ag < 0.05) {
               this.f_r45();
            }
         } else {
            int var3 = this.i(var1, var2);
            if (var3 > 0) {
               var2.jumpKey.setPressed(true);
               HOLD = true;
               if (this.k(var2) && !var2.sprintKey.isPressed() && !var1.isSprinting()) {
                  var2.sprintKey.setPressed(true);
                  SPR = true;
               }

               this.f_r45();
            } else if (var3 < 0) {
               this.f_r45();
            }
         }
      } else {
         this.f_r45();
      }
   }

   private int i(ClientPlayerEntity var1, GameOptions var2) {

      Vec3d var3 = var1.getVelocity();
      float var4 = var1.getYaw();
      double var5 = Math.sin(Math.toRadians((double)var4));
      double var7 = Math.cos(Math.toRadians((double)var4));
      double var9 = (var2.forwardKey.isPressed() ? 1.0 : 0.0) - (var2.backKey.isPressed() ? 1.0 : 0.0);
      double var11 = (var2.leftKey.isPressed() ? 1.0 : 0.0) - (var2.rightKey.isPressed() ? 1.0 : 0.0);
      double var13 = Math.sqrt(var9 * var9 + var11 * var11);
      double var15 = 0.0;
      double var17 = 0.0;
      boolean var19 = var1.shouldSlowDown();
      if (var13 > 0.0) {
         double var20 = var9 / var13;
         double var22 = var11 / var13;
         double var24 = 0.98;
         if (var19) {
            var24 *= var1.getAttributeValue(EntityAttributes.SNEAKING_SPEED);
         }

         double var26 = Math.abs(var20);
         double var28 = Math.abs(var22);
         double var30 = var26 > var28 ? var28 / var26 : (var28 > 0.0 ? var26 / var28 : 0.0);
         double var32 = Math.min(var24 * Math.sqrt(1.0 + var30 * var30), 1.0);
         var15 = (var22 * var7 - var20 * var5) * var32;
         var17 = (var20 * var7 + var22 * var5) * var32;
      }

      boolean var56 = var9 > 0.0
         && !var19
         && !var1.hasStatusEffect(StatusEffects.BLINDNESS)
         && (var1.getHungerManager().getFoodLevel() > 6 || var1.getAbilities().allowFlying);
      boolean var21 = var56 && (var1.isSprinting() || var2.sprintKey.isPressed() || this.k(var2));
      double var57 = var1.getAttributeValue(EntityAttributes.MOVEMENT_SPEED);
      if (var21 && !var1.isSprinting()) {
         var57 *= 1.3;
      } else if (!var21 && var1.isSprinting()) {
         var57 /= 1.3;
      }

      BlockPos var58 = var1.getVelocityAffectingPos();
      double var25 = (double)a.world.getBlockState(var58).getBlock().getSlipperiness();
      double var27 = var57 * (0.21600002 / (var25 * var25 * var25));
      double var29 = var21 ? 0.025999999 : 0.02;
      float var31 = a.world.getBlockState(var1.getBlockPos()).getBlock().getJumpVelocityMultiplier();
      float var59 = a.world.getBlockState(var58).getBlock().getJumpVelocityMultiplier();
      double var33 = var1.getAttributeValue(EntityAttributes.JUMP_STRENGTH) * (double)(var31 == 1.0F ? var59 : var31) + (double)var1.getJumpBoostVelocityModifier();
      double var35 = var21 ? -var5 * 0.2 : 0.0;
      double var37 = var21 ? var7 * 0.2 : 0.0;
      double var39 = var1.getAttributeValue(EntityAttributes.GRAVITY);
      boolean var41 = var1.hasStatusEffect(StatusEffects.SLOW_FALLING);
      double var42 = this.j(-1, var3.x, var3.y, var3.z, var15, var17, var27, var29, var25, var33, var35, var37, var39, var41);
      double var44 = this.ah;
      double var46 = this.j(0, var3.x, var3.y, var3.z, var15, var17, var27, var29, var25, var33, var35, var37, var39, var41);
      double var48 = this.ah;
      double var50 = 1.0E9;
      int var52 = Math.min(3, this.ad - this.ac);

      for (int var53 = 1; var53 <= var52; var53++) {
         double var54 = this.j(var53, var3.x, var3.y, var3.z, var15, var17, var27, var29, var25, var33, var35, var37, var39, var41);
         if (var54 < var50) {
            var50 = var54;
            var48 = Math.max(var48, this.ah);
         }
      }

      if (var46 >= 1.0E9 && var50 >= 1.0E9) {
         return -1;
      } else if (var48 >= 1.5 && var44 < 1.5 && this.l(var1)) {
         return -1;
      } else if (this.x.g().indexOf(this.x.f()) == 1) {
         return var46 <= var50 + 0.005 ? 1 : 0;
      } else if (var46 < var42 - 0.01 && var46 <= var50 + 0.005) {
         return 1;
      } else {
         return var50 < var42 - 0.01 ? 0 : -1;
      }
   }

   private double j(
      int var1,
      double var2,
      double var4,
      double var6,
      double var8,
      double var10,
      double var12,
      double var14,
      double var16,
      double var18,
      double var20,
      double var22,
      double var24,
      boolean var26
   ) {

      double var27 = 0.0;
      double var29 = 0.0;
      double var31 = 0.0;
      double var33 = 0.0;
      double var35 = 0.0;
      boolean var37 = true;

      for (int var38 = 0; var38 < 40; var38++) {
         if (var2 * var2 + var6 * var6 < 9.0E-6) {
            var2 = 0.0;
            var6 = 0.0;
         }

         if (Math.abs(var4) < 0.003) {
            var4 = 0.0;
         }

         if (var38 == var1) {
            if (!var37) {
               this.ah = var35;
               return 1.0E9;
            }

            var4 = Math.max(var18, var4);
            var2 += var20;
            var6 += var22;
         }

         double var39 = var37 ? var16 : 1.0;
         double var41 = var37 ? var12 : var14;
         var2 += var8 * var41;
         var6 += var10 * var41;
         double var43 = var29 + var4;
         if (var43 <= 0.0 && var4 <= 0.0) {
            var29 = 0.0;
            var4 = 0.0;
            var37 = true;
         } else {
            var29 = var43;
            var37 = false;
         }

         var27 += var2;
         var31 += var6;
         double var45 = var26 && var4 <= 0.0 ? Math.min(var24, 0.01) : var24;
         var4 = (var4 - var45) * 0.98;
         var2 *= var39 * 0.91;
         var6 *= var39 * 0.91;
         double var47 = var27 * this.af + var31 * this.ag;
         if (var47 > var33) {
            var33 = var47;
         }

         if (var29 > var35) {
            var35 = var29;
         }
      }

      this.ah = var35;
      return var33;
   }

   private boolean k(GameOptions var1) {

      return this.ab.f() && !(Boolean)var1.getSprintToggled().getValue();
   }

   private boolean l(ClientPlayerEntity var1) {

      boolean var2 = InitExecutor.t || InitExecutor.u;
      if (!var2) {
         SyncDispatcher var3 = ConfigBridge.c != null ? ConfigBridge.c.c() : null;
         if (var3 != null) {
            BuilderFactory var4 = var3.a(SortCacheUnit.class);
            var2 = var4 != null && var4.f();
         }
      }

      if (!var2) {
         return false;
      } else {
         PlayerInventory var5 = var1.getInventory();

         for (int var6 = 0; var6 < 9; var6++) {
            if (var5.getStack(var6).isOf(Items.MACE)) {
               return true;
            }
         }

         return false;
      }
   }

   public static void m_r110() {

      HOLD = false;
      boolean var0 = SPR;
      SPR = false;
      MinecraftClient var1 = a;
      if (var1 != null && var1.options != null && var1.currentScreen == null) {
         KeyBinding var2 = var1.options.jumpKey;
         var2.setPressed(n(var1, var2));
         if (var0) {
            KeyBinding var3 = var1.options.sprintKey;
            var3.setPressed(n(var1, var3));
         }
      }
   }

   private static boolean n(MinecraftClient var0, KeyBinding var1) {

      InputUtil.Key var2 = InputUtil.fromTranslationKey(var1.getBoundKeyTranslationKey());
      int var3 = var2.getCode();
      if (var3 >= 0 && var0.getWindow() != null) {
         if (var2.getCategory() == InputUtil.Type.MOUSE) {
            return GLFW.glfwGetMouseButton(var0.getWindow().getHandle(), var3) == 1;
         } else {
            return var2.getCategory() == InputUtil.Type.KEYSYM ? InputUtil.isKeyPressed(var0.getWindow(), var3) : false;
         }
      } else {
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

   public String g_r46() {

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
