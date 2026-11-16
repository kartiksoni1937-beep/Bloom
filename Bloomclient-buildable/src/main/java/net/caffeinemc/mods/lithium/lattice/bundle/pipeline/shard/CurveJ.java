package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import net.minecraft.util.math.MathHelper;

public final class CurveJ {

   private CurveJ() {
   }

   public static double a(double var0, double var2, double var4, double var6) {

      if (!(var4 <= 0.0) && !(var6 <= 0.0)) {
         double var8 = 1.0 - Math.pow(2.0, -var6 / var4);
         return var0 + (var2 - var0) * (var8 < 0.0 ? 0.0 : (var8 > 1.0 ? 1.0 : var8));
      } else {
         return var4 <= 0.0 ? var2 : var0;
      }
   }

   public static float b(float var0, float var1, float var2, float var3) {

      if (!(var2 <= 0.0F) && !(var3 <= 0.0F)) {
         float var4 = (float)(1.0 - Math.pow(2.0, (double)(-var3 / var2)));
         return var0 + MathHelper.wrapDegrees(var1 - var0) * (var4 < 0.0F ? 0.0F : (var4 > 1.0F ? 1.0F : var4));
      } else {
         return var2 <= 0.0F ? var1 : var0;
      }
   }

   public static double c(double var0) {

      return var0 < 0.0 ? 0.0 : (var0 > 1.0 ? 1.0 : var0);
   }
}
