package net.caffeinemc.mods.lithium.binder.internal;

public final class CodecViewN {
   private long fa;
   private long fb;

   private CodecViewN() {
   }

   public static int ma(int var0, int var1) {
      int var2 = var0;

      for (int var3 = 0; var3 < 12; var3++) {
         var2 = (var2 ^ var1 + var3) + var3 * 1;
      }

      return var2 & 65535;
   }

   public static int mb(int var0, int var1) {
      int var2 = var0;

      for (int var3 = 0; var3 < 8; var3++) {
         var2 = (var2 ^ var1 + var3) + var3 * 3;
      }

      return var2 & 65535;
   }
}
