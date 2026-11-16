package net.caffeinemc.mods.lithium.binder.internal;

public final class RegistryWrapperO {
   private long fa;
   private long fb;
   private long fc;
   private boolean fd;

   private RegistryWrapperO() {
   }

   public static int ma(int var0, int var1) {
      int var2 = var0;

      for (int var3 = 0; var3 < 17; var3++) {
         var2 = (var2 ^ var1 + var3) + var3 * 3;
      }

      return var2 & 65535;
   }

   public static int mb(int var0, int var1) {
      int var2 = var0;

      for (int var3 = 0; var3 < 18; var3++) {
         var2 = (var2 ^ var1 + var3) + var3 * 2;
      }

      return var2 & 65535;
   }
}
