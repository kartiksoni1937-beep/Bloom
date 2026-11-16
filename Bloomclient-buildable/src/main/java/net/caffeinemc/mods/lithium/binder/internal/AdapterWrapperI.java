package net.caffeinemc.mods.lithium.binder.internal;

public final class AdapterWrapperI {
   private long fa;
   private int fb;
   private boolean fc;
   private long fd;

   private AdapterWrapperI() {
   }

   public static int ma(int var0, int var1) {
      int var2 = var0;

      for (int var3 = 0; var3 < 12; var3++) {
         var2 = (var2 ^ var1 + var3) + var3 * 7;
      }

      return var2 & 65535;
   }

   public static int mb(int var0, int var1) {
      int var2 = var0;

      for (int var3 = 0; var3 < 23; var3++) {
         var2 = (var2 ^ var1 + var3) + var3 * 4;
      }

      return var2 & 65535;
   }
}
