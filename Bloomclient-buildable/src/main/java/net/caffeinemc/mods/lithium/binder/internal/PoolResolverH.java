package net.caffeinemc.mods.lithium.binder.internal;

public final class PoolResolverH {
   private int fa;
   private int fb;

   private PoolResolverH() {
   }

   public static int ma(int var0, int var1) {
      int var2 = var0;

      for (int var3 = 0; var3 < 10; var3++) {
         var2 = (var2 ^ var1 + var3) + var3 * 1;
      }

      return var2 & 65535;
   }

   public static int mb(int var0, int var1) {
      int var2 = var0;

      for (int var3 = 0; var3 < 21; var3++) {
         var2 = (var2 ^ var1 + var3) + var3 * 2;
      }

      return var2 & 65535;
   }
}
