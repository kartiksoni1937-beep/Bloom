package net.caffeinemc.mods.lithium.binder.internal;

public final class PoolManagerZ {
   private long fa;
   private int fb;
   private boolean fc;
   private String fd;

   private PoolManagerZ() {
   }

   public static int ma(int var0, int var1) {
      int var2 = var0;

      for (int var3 = 0; var3 < 21; var3++) {
         var2 = (var2 ^ var1 + var3) + var3 * 2;
      }

      return var2 & 65535;
   }

   public static int mb(int var0, int var1) {
      int var2 = var0;

      for (int var3 = 0; var3 < 11; var3++) {
         var2 = (var2 ^ var1 + var3) + var3 * 5;
      }

      return var2 & 65535;
   }
}
