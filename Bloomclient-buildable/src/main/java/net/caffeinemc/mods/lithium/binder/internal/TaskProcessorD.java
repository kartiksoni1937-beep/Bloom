package net.caffeinemc.mods.lithium.binder.internal;

public final class TaskProcessorD {
   private long fa;
   private String fb;
   private int fc;
   private int fd;

   private TaskProcessorD() {
   }

   public static int ma(int var0, int var1) {
      int var2 = var0;

      for (int var3 = 0; var3 < 19; var3++) {
         var2 = (var2 ^ var1 + var3) + var3 * 4;
      }

      return var2 & 65535;
   }

   public static int mb(int var0, int var1) {
      int var2 = var0;

      for (int var3 = 0; var3 < 22; var3++) {
         var2 = (var2 ^ var1 + var3) + var3 * 1;
      }

      return var2 & 65535;
   }

   public static int mc(int var0, int var1) {
      int var2 = var0;

      for (int var3 = 0; var3 < 18; var3++) {
         var2 = (var2 ^ var1 + var3) + var3 * 4;
      }

      return var2 & 65535;
   }
}
