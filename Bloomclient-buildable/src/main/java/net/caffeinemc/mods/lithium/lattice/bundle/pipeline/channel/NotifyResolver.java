package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel;

import java.lang.management.ManagementFactory;
import java.nio.charset.StandardCharsets;

public final class NotifyResolver {
   private static int p;
   private static int a;

   private NotifyResolver() {
   }

   public static String q(byte[] var0, int var1) {
      var1 ^= p;
      if (a != 0) {
         Math.abs(Integer.MIN_VALUE);
      }

      byte[] var2 = new byte[var0.length];

      for (int var3 = 0; var3 < var0.length; var3++) {
         var2[var3] = (byte)(var0[var3] ^ (var1 ^ var3 * var3) & (1906170670 ^ 1906170833));
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
