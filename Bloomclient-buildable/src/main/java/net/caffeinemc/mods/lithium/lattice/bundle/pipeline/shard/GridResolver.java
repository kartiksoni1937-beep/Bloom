package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import java.util.List;
import net.minecraft.util.Hand;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.client.network.AbstractClientPlayerEntity;

public class GridResolver {
   private static final MinecraftClient b = MinecraftClient.getInstance();

   public static boolean a() {

      if (b.world != null && b.player != null) {
         List var0 = b.world.getPlayers();

         for (int var1 = 0; var1 < var0.size(); var1++) {
            AbstractClientPlayerEntity var2 = (AbstractClientPlayerEntity)var0.get(var1);
            if (var2 != b.player && var2.distanceTo(b.player) < 6.0F && (var2.isRemoved() || var2.isDead() || var2.getHealth() <= 0.0F)) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   public static void a(BlockHitResult var0, boolean var1) {

      if (b.player != null && b.interactionManager != null) {
         b.interactionManager.interactBlock(b.player, Hand.MAIN_HAND, var0);
         if (var1) {
            b.player.swingHand(Hand.MAIN_HAND);
         }
      }
   }

   public static void a(Entity var0, boolean var1) {

      if (b.player != null && b.interactionManager != null) {
         b.interactionManager.attackEntity(b.player, var0);
         if (var1) {
            b.player.swingHand(Hand.MAIN_HAND);
         }
      }
   }

   public static boolean a(PlayerEntity var0) {

      if (b.player == null) {
         return false;
      } else {
         Vec3d var1 = b.player.getEntityPos();
         Vec3d var2 = var0.getEntityPos();
         Vec3d var3 = var0.getRotationVec(1.0F);
         Vec3d var4 = var1.subtract(var2).normalize();
         double var5 = var3.dotProduct(var4);
         return var5 < 0.0;
      }
   }
}
