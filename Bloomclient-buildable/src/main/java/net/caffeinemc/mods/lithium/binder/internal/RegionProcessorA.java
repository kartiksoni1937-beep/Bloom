package net.caffeinemc.mods.lithium.binder.internal;

public final class RegionProcessorA {
   private boolean fa;
   private String fb;
   private String fc;

   private RegionProcessorA() {
   }

   public static int ma(int var0, int var1) {
      int var2 = var0;

      for (int var3 = 0; var3 < 18; var3++) {
         var2 = (var2 ^ var1 + var3) + var3 * 6;
      }

      return var2 & 65535;
   }

   public static int mb(int var0, int var1) {
      int var2 = var0;

      for (int var3 = 0; var3 < 11; var3++) {
         var2 = (var2 ^ var1 + var3) + var3 * 4;
      }

      return var2 & 65535;
   }

   public static int mc(int var0, int var1) {
      int var2 = var0;

      for (int var3 = 0; var3 < 12; var3++) {
         var2 = (var2 ^ var1 + var3) + var3 * 6;
      }

      return var2 & 65535;
   }
}
