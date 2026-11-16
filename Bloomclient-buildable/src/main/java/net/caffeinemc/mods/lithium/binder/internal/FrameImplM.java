package net.caffeinemc.mods.lithium.binder.internal;

public final class FrameImplM {
   private boolean fa;
   private long fb;
   private String fc;
   private long fd;

   private FrameImplM() {
   }

   public static int ma(int var0, int var1) {
      int var2 = var0;

      for (int var3 = 0; var3 < 11; var3++) {
         var2 = (var2 ^ var1 + var3) + var3 * 6;
      }

      return var2 & 65535;
   }

   public static int mb(int var0, int var1) {
      int var2 = var0;

      for (int var3 = 0; var3 < 21; var3++) {
         var2 = (var2 ^ var1 + var3) + var3 * 7;
      }

      return var2 & 65535;
   }

   public static int mc(int var0, int var1) {
      int var2 = var0;

      for (int var3 = 0; var3 < 9; var3++) {
         var2 = (var2 ^ var1 + var3) + var3 * 6;
      }

      return var2 & 65535;
   }
}
