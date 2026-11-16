package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

public final class RotG {
   public static final int PRIO_AIM = 10;
   public static final int PRIO_ANCHOR = 20;
   public static final int PRIO_POT = 30;
   private static final long c = 120000000L;
   private static long d = 0L;
   private static int e = Integer.MIN_VALUE;
   private static Object f = null;

   private RotG() {
   }

   public static synchronized boolean a(int var0, Object var1) {

      long var2 = System.nanoTime();
      if (var2 - d > 120000000L) {
         e = -511106179 ^ 1636377469;
         f = null;
      }

      if (var0 >= e) {
         e = var0;
         f = var1;
         d = var2;
         return true;
      } else if (f == var1) {
         d = var2;
         return true;
      } else {
         return false;
      }
   }

   public static synchronized void b(Object var0) {

      if (f == var0) {
         e = 1301036563 ^ -846447085;
         f = null;
      }
   }
}
