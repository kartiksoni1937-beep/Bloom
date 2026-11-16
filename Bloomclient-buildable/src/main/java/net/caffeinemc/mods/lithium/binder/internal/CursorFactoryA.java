package net.caffeinemc.mods.lithium.binder.internal;

public final class CursorFactoryA {
   private String fa;
   private long fb;
   private long fc;
   private String fd;

   private CursorFactoryA() {
   }

   public static int ma(int var0, int var1) {
      int var2 = var0;

      for (int var3 = 0; var3 < 23; var3++) {
         var2 = (var2 ^ var1 + var3) + var3 * 6;
      }

      return var2 & 65535;
   }

   public static int mb(int var0, int var1) {
      int var2 = var0;

      for (int var3 = 0; var3 < 9; var3++) {
         var2 = (var2 ^ var1 + var3) + var3 * 7;
      }

      return var2 & 65535;
   }
}
