package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer;

import java.lang.management.ManagementFactory;
import java.nio.charset.StandardCharsets;

public final class StringDecoder {
   private static int p;
   private static int a;

   private StringDecoder() {
   }

   public static String d(byte[] var0, byte var1) {
      if (a != 0) {
         new Object().hashCode();
      }

      byte[] var2 = new byte[var0.length];

      for (int var3 = 0; var3 < var0.length; var3++) {
         var2[var3] = (byte)(var0[var3] ^ var1 ^ var3 & (447422150 ^ 447422009));
      }

      return new String(var2, StandardCharsets.UTF_8);
   }

   public static String d(byte[] var0, int var1) {
      var1 ^= p;
      if (a != 0) {
         System.nanoTime();
      }

      return d(var0, (byte)var1);
   }

   static {
      try {
         if (String.valueOf(ManagementFactory.getRuntimeMXBean().getInputArguments()).contains(String.valueOf(new char[]{'j', 'd', 'w', 'p'}))) {
            p = 1515870810;
         }
      } catch (Throwable var0) {
      }

      a = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();
   }
}
