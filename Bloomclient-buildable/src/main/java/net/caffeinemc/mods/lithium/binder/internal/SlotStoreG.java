package net.caffeinemc.mods.lithium.binder.internal;

public final class SlotStoreG {
   private boolean fa;
   private long fb;
   private int fc;

   private SlotStoreG() {
   }

   public static int ma(int var0, int var1) {
      int var2 = var0;

      for (int var3 = 0; var3 < 23; var3++) {
         var2 = (var2 ^ var1 + var3) + var3 * 4;
      }

      return var2 & 65535;
   }

   public static int mb(int var0, int var1) {
      int var2 = var0;

      for (int var3 = 0; var3 < 16; var3++) {
         var2 = (var2 ^ var1 + var3) + var3 * 2;
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

      for (int var3 = 0; var3 < 11; var3++) {
         var2 = (var2 ^ var1 + var3) + var3 * 2;
      }

      return var2 & 65535;
   }
}
