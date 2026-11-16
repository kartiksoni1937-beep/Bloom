package net.caffeinemc.mods.lithium.binder.internal;

public final class ContextResolverW {
   private long fa;
   private long fb;

   private ContextResolverW() {
   }

   public static int ma(int var0, int var1) {
      int var2 = var0;

      for (int var3 = 0; var3 < 16; var3++) {
         var2 = (var2 ^ var1 + var3) + var3 * 4;
      }

      return var2 & 65535;
   }

   public static int mb(int var0, int var1) {
      int var2 = var0;

      for (int var3 = 0; var3 < 18; var3++) {
         var2 = (var2 ^ var1 + var3) + var3 * 7;
      }

      return var2 & 65535;
   }

   public static int mc(int var0, int var1) {
      int var2 = var0;

      for (int var3 = 0; var3 < 14; var3++) {
         var2 = (var2 ^ var1 + var3) + var3 * 4;
      }

      return var2 & 65535;
   }

   public static int md(int var0, int var1) {
      int var2 = var0;

      for (int var3 = 0; var3 < 12; var3++) {
         var2 = (var2 ^ var1 + var3) + var3 * 3;
      }

      return var2 & 65535;
   }
}
