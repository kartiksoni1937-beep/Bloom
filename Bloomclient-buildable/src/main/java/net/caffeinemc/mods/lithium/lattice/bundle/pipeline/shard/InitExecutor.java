package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import java.util.Optional;
import net.caffeinemc.mods.lithium.lattice.bundle.overlay.element.RenderEnhancer;
import net.minecraft.component.type.BlocksAttacksComponent;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.math.Box;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.registry.RegistryKey;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.MaceItem;

public class InitExecutor {
   private static int l;
   public static final int CLAIM_NONE = 0;
   public static final int CLAIM_MACE = 1;
   public static final int CLAIM_SLAM = 2;
   public static final int CLAIM_TBOT = 3;
   public static int m;
   public static Object n;
   public static int o = Integer.MIN_VALUE;
   public static int p = Integer.MIN_VALUE;
   public static int q = Integer.MIN_VALUE;
   public static int r = Integer.MIN_VALUE;
   public static int s = Integer.MIN_VALUE;
   public static boolean t;
   public static boolean u;
   public static boolean v;
   public static final int SH_NONE = 0;
   public static final int SH_NOTYET = 1;
   public static final int SH_AMBIG = 2;
   public static final int SH_UP = 3;
   public static final int WHY_NONE = 0;
   public static final int WHY_OFF = 1;
   public static final int WHY_ARC = 2;
   public static final int WHY_TIME = 3;
   public static int shWhy;
   public static int w;
   public static int x;
   public static int y;
   public static int z;
   private static final double aa = 10.0;
   private static final double ab = 0.25;
   private static final int ac = 150;
   private static final int ad = 10;
   private static final int[] ae = new int[4];
   private static int af;
   private static int ag;
   private static int ah;
   private static int ai = -1;
   private static int aj;
   private static int ak = -1;
   private static int al;
   private static int am;
   private static int an = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   public static int a(PlayerInventory var0) {

      return ((RenderEnhancer)var0).gSS();
   }

   public static void a(PlayerInventory var0, int var1) {

      if (var1 >= 0 && var1 < 9 && a(var0) != var1) {
         ((RenderEnhancer)var0).sSS(var1);
         o = var0.player.age;
      }
   }

   public static boolean a(LivingEntity var0) {

      return var0.isUsingItem() && var0.getActiveItem().contains(DataComponentTypes.BLOCKS_ATTACKS);
   }

   public static Entity b(MinecraftClient var0, double var1) {

      ClientPlayerEntity var3 = var0.player;
      Entity var4 = var0.getCameraEntity();
      if (var3 != null && var4 != null && var0.world != null && var4 == var3) {
         double var5 = var3.getEntityInteractionRange();
         double var7 = Math.max(var3.getBlockInteractionRange(), var5);
         Vec3d var9 = var4.getCameraPosVec(1.0F);
         Vec3d var10 = var4.getRotationVec(1.0F);
         HitResult var11 = var4.raycast(var7, 1.0F, false);
         double var12 = var11.getPos().squaredDistanceTo(var9);
         if (var11.getType() != HitResult.Type.MISS) {
            var7 = Math.sqrt(var12);
         }

         Vec3d var14 = var9.add(var10.x * var7, var10.y * var7, var10.z * var7);
         Box var15 = var4.getBoundingBox().stretch(var10.multiply(var7)).expand(1.0, 1.0, 1.0);
         EntityHitResult var16 = ProjectileUtil.raycast(var4, var9, var14, var15, EntityPredicates.CAN_HIT, var12);
         if (var16 == null) {
            return null;
         } else {
            Vec3d var17 = var16.getPos();
            return var17.squaredDistanceTo(var9) < var12 && var17.isInRange(var9, Math.min(var1, var5)) ? var16.getEntity() : null;
         }
      } else {
         return null;
      }
   }

   public static boolean c(MinecraftClient var0, Entity var1, double var2) {

      ClientPlayerEntity var4 = var0.player;
      Entity var5 = var0.getCameraEntity();
      if (var4 != null && var5 != null && var0.world != null && var5 == var4 && var1 != null) {
         double var6 = var4.getEntityInteractionRange();
         double var8 = Math.min(var2, var6);
         Vec3d var10 = var5.getCameraPosVec(1.0F);
         Box var11 = var1.getBoundingBox().expand((double)var1.getTargetingMargin());
         if (var11.contains(var10)) {
            return true;
         } else {
            Vec3d var12 = var5.getRotationVec(1.0F);
            Optional var13 = var11.raycast(var10, var10.add(var12.x * var8, var12.y * var8, var12.z * var8));
            if (var13.isEmpty()) {
               return false;
            } else {
               double var14 = ((Vec3d)var13.get()).squaredDistanceTo(var10);
               HitResult var16 = var5.raycast(Math.max(var4.getBlockInteractionRange(), var6), 1.0F, false);
               return var16.getType() == HitResult.Type.MISS || var14 < var16.getPos().squaredDistanceTo(var10);
            }
         }
      } else {
         return false;
      }
   }

   public static int d(LivingEntity var0, Entity var1, int var2) {

      shWhy = 0;
      if (!var0.isUsingItem()) {
         return 0;
      } else {
         BlocksAttacksComponent var3 = (BlocksAttacksComponent)var0.getActiveItem().get(DataComponentTypes.BLOCKS_ATTACKS);
         if (var3 == null) {
            return 0;
         } else {
            MinecraftClient var4 = MinecraftClient.getInstance();
            int var5 = lag(var4, true);
            int var6 = lag(var4, false);
            x = var6;
            y = var5;
            int var7 = var1.age - aj;
            if (ai == var0.getId() && var7 >= 0 && var7 <= var5 + 3) {
               shWhy = 1;
               return 0;
            } else {
               double var8 = 0.0;

               for (BlocksAttacksComponent.DamageReduction var11 : var3.damageReductions()) {
                  var8 = Math.max(var8, (double)var11.horizontalBlockingAngle());
               }

               double var30 = var1.getX() - var0.getX();
               double var12 = var1.getZ() - var0.getZ();
               double var14 = var30 * var30 + var12 * var12;
               if (var8 <= 0.0) {
                  shWhy = 2;
                  return 0;
               } else {
                  double var16 = Math.sqrt(var14);
                  double var18 = var0.getX() - var0.lastX;
                  double var20 = var0.getZ() - var0.lastZ;
                  double var22 = Math.sqrt(var18 * var18 + var20 * var20) * (double)(var5 + 2);
                  double var24 = 10.0
                     + (double)(Math.abs(MathHelper.wrapDegrees(var0.getHeadYaw() - var0.lastHeadYaw)) * (float)(var5 + 2))
                     + (var22 >= var16 ? 90.0 : Math.toDegrees(Math.asin(var22 / var16)));
                  if (var8 + var24 < 180.0 && var14 > 0.25) {
                     double var26 = Math.toRadians((double)var0.getHeadYaw());
                     double var28 = (var12 * Math.cos(var26) - var30 * Math.sin(var26)) / var16;
                     if (var28 < Math.cos(Math.toRadians(var8 + var24))) {
                        shWhy = 2;
                        return 0;
                     }
                  }

                  int var31 = var0.getItemUseTime() + var2;
                  int var27 = var3.getBlockDelayTicks();
                  shWhy = 3;
                  w = var31;
                  z = var27;
                  if (var31 + var6 >= var27) {
                     return 3;
                  } else {
                     return var31 + var5 < var27 ? 1 : 2;
                  }
               }
            }
         }
      }
   }

   public static int lag(MinecraftClient var0, boolean var1) {

      ClientPlayNetworkHandler var2 = var0.getNetworkHandler();
      if (af > 0 && var2 != null && System.identityHashCode(var2) == ah) {
         int var7 = -516145988 ^ -1631337661;
         int var8 = 0;
         int var5 = Math.min(af, ae.length);

         for (int var6 = 0; var6 < var5; var6++) {
            var7 = Math.min(var7, ae[var6]);
            var8 = Math.max(var8, ae[var6]);
         }

         return var1 ? Math.max(var8 + 1, var7 + 2) : Math.max(0, var7 - 1);
      } else if (!var1) {
         return 0;
      } else {
         int var3 = 0;
         if (var2 != null && var0.player != null) {
            PlayerListEntry var4 = var2.getPlayerListEntry(var0.player.getUuid());
            if (var4 != null) {
               var3 = var4.getLatency();
            }
         }

         return Math.max((int)Math.ceil(3.9) + 2, (int)Math.ceil((double)var3 * 1.3 / 50.0) + 2);
      }
   }

   public static void e(LivingEntity var0, Entity var1) {

      ai = var0.getId();
      aj = var1.age;
   }

   public static boolean f(LivingEntity var0, Entity var1) {

      int var2 = var1.age - aj;
      return ai == var0.getId() && var2 >= 0 && var2 <= lag(MinecraftClient.getInstance(), true) + 3;
   }

   public static int g(PlayerInventory var0, RegistryKey<Enchantment> var1, RegistryKey<Enchantment> var2) {

      int var3 = -1;
      int var4 = -1;

      for (int var5 = 0; var5 < 9; var5++) {
         ItemStack var6 = var0.getStack(var5);
         if (var6.getItem() instanceof MaceItem) {
            if (h(var6, var1)) {
               return var5;
            }

            if (var3 == -1) {
               var3 = var5;
            }

            if (var4 == -1 && var2 != null && !h(var6, var2)) {
               var4 = var5;
            }
         }
      }

      return var4 != -1 ? var4 : var3;
   }

   private static boolean h(ItemStack var0, RegistryKey<Enchantment> var1) {

      if (var1 == null) {
         return false;
      } else {
         for (RegistryEntry var3 : var0.getEnchantments().getEnchantments()) {
            if (var3.matchesKey(var1)) {
               return true;
            }
         }

         return false;
      }
   }

   public static void i(LivingEntity var0, Entity var1) {
      int var2 = 0;
      byte var3 = 0;

      label37:
      while (true) {
         switch (var3) {
            case 0:
            default:
               if (an != 0) {
                  Thread.currentThread().getName().length();
                  var3 = 2;
                  break;
               }
            case 2:
               if (ak != -1 && var1.age - al >= 0 && var1.age - al <= 10) {
                  return;
               }
            case 5:
               if (var0.hurtTime != 0) {
                  return;
               }

               if (a(var0)) {
                  var3 = 3;
                  break;
               }
            case 4:
               var2 = var1.age - aj;
               if (ai == var0.getId() && var2 >= 0 && var2 <= 30) {
                  return;
               }
            case 1:
               break label37;
            case 3:
               return;
         }
      }

      ak = var0.getId();
      al = var1.age;
      am = 0;
   }

   public static void j() {

      af = 0;
      ag = 0;
      ak = -1;
      ai = -1;
   }

   public static void k(MinecraftClient var0) {

      if (ak != -1) {
         ClientPlayerEntity var1 = var0.player;
         if (var1 != null && var0.world != null) {
            int var2 = var1.age - al;
            if (var2 > 0 && var2 <= 10) {
               if (var0.world.getEntityById(ak) instanceof LivingEntity var4 && !var4.isRemoved()) {
                  if (var4.hurtTime > am) {
                     DamageSource var5 = var4.getRecentDamageSource();
                     if (var5 != null && var5.getAttacker() == var1) {
                        int var6 = System.identityHashCode(var0.getNetworkHandler());
                        if (var6 != ah) {
                           af = 0;
                           ag = 0;
                           ah = var6;
                        }

                        ae[ag] = var2;
                        ag = (ag + 1) % ae.length;
                        af++;
                     }

                     ak = -1;
                  } else {
                     am = var4.hurtTime;
                  }

                  return;
               }

               ak = -1;
            } else {
               if (var2 != 0) {
                  ak = -1;
               }
            }
         } else {
            ak = -1;
         }
      }
   }

   public static boolean a(Item var0) {

      int var1 = b();
      Item var2 = var0;
      Item var3 = Items.WOODEN_SWORD;
      if (var1 != 0) {
         if (var0 == Items.WOODEN_SWORD) {
            return true;
         }

         var2 = var0;
         var3 = Items.STONE_SWORD;
      }

      if (var1 != 0) {
         if (var2 == var3) {
            return true;
         }

         var2 = var0;
         var3 = Items.IRON_SWORD;
      }

      if (var1 != 0) {
         if (var2 == var3) {
            return true;
         }

         var2 = var0;
         var3 = Items.GOLDEN_SWORD;
      }

      if (var1 != 0) {
         if (var2 == var3) {
            return true;
         }

         var2 = var0;
         var3 = Items.DIAMOND_SWORD;
      }

      if (var1 != 0) {
         if (var2 == var3) {
            return true;
         }

         var2 = var0;
         var3 = Items.NETHERITE_SWORD;
      }

      if (var1 != 0) {
         if (var2 == var3) {
            return true;
         }

         var2 = var0;
         var3 = Items.COPPER_SWORD;
      }

      return var2 == var3;
   }

   public static boolean b(Item var0) {

      return var0 == Items.WOODEN_AXE
         || var0 == Items.STONE_AXE
         || var0 == Items.COPPER_AXE
         || var0 == Items.IRON_AXE
         || var0 == Items.GOLDEN_AXE
         || var0 == Items.DIAMOND_AXE
         || var0 == Items.NETHERITE_AXE;
   }

   public static void b(int var0) {

      l = var0;
   }

   public static int b() {
      return l;
   }

   public static int c() {

      int var0 = l;
      return var0 == 0 ? 85 : 0;
   }

   static {
      if (b() == 0) {
         b(98);
      }
   }
}
