package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.MathHelper;

public class LinkerProvider {
   private static int a = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   public static Vec3d a(Entity var0) {

      return var0.getEntityPos().add(0.0, (double)var0.getStandingEyeHeight(), 0.0);
   }

   public static Vec3d b(Entity var0) {

      float var1 = var0.getYaw();
      float var2 = var0.getPitch();
      float var3 = (float)Math.toRadians((double)(-var1 - 180.0F));
      float var4 = (float)Math.toRadians((double)(-var2));
      float var5 = MathHelper.cos((double)var3);
      float var6 = MathHelper.sin((double)var3);
      float var7 = MathHelper.cos((double)var4);
      float var8 = MathHelper.sin((double)var4);
      return new Vec3d((double)(var6 * var7), (double)var8, (double)(var5 * var7));
   }
}
