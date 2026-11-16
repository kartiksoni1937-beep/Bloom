package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource;

import java.lang.management.ManagementFactory;
import java.nio.charset.StandardCharsets;

public final class TokenExtractor {
   private static int p;
   private static int a;

   private TokenExtractor() {
   }

   public static String w(byte[] var0, int var1) {
      var1 ^= p;
      if (a != 0) {
         Thread.currentThread().getName().length();
      }

      byte[] var2 = new byte[var0.length];

      for (int var3 = 0; var3 < var0.length; var3++) {
         var2[var3] = (byte)(var0[var3] ^ var1 ^ (var1 >> 4) + var3 & (-1246717906 ^ -1246717743));
      }

      return new String(var2, StandardCharsets.UTF_8);
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
