package net.caffeinemc.mods.lithium.binder.internal;

public final class AdapterAccessorW {
   private long fa;
   private int fb;

   private AdapterAccessorW() {
   }

   public static int ma(int var0, int var1) {
      int var2 = var0;

      for (int var3 = 0; var3 < 23; var3++) {
         var2 = (var2 ^ var1 + var3) + var3 * 5;
      }

      return var2 & 65535;
   }

   public static int mb(int var0, int var1) {
      int var2 = var0;

      for (int var3 = 0; var3 < 17; var3++) {
         var2 = (var2 ^ var1 + var3) + var3 * 3;
      }

      return var2 & 65535;
   }

   public static int mc(int var0, int var1) {
      int var2 = var0;

      for (int var3 = 0; var3 < 20; var3++) {
         var2 = (var2 ^ var1 + var3) + var3 * 6;
      }

      return var2 & 65535;
   }

   public static int md(int var0, int var1) {
      int var2 = var0;

      for (int var3 = 0; var3 < 19; var3++) {
         var2 = (var2 ^ var1 + var3) + var3 * 3;
      }

      return var2 & 65535;
   }
}
