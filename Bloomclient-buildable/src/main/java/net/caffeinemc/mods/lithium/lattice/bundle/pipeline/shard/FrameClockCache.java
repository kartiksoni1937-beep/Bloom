package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.minecraft.client.network.ClientPlayerEntity;

public final class FrameClockCache {
   public static int l = Integer.MIN_VALUE;
   public static int m = Integer.MIN_VALUE;
   public static volatile boolean any;
   public static volatile boolean n;
   // Tick of the last block interaction. An attack is not allowed in the same tick,
   // otherwise one tick can contain both a block placement and an entity attack.
   public static volatile int interactBlockAge = Integer.MIN_VALUE;
   private static volatile Runnable[] o = new Runnable[0];
   private static volatile Runnable[] p = new Runnable[0];

   private FrameClockCache() {
   }

   public static synchronized void add(Runnable var0) {

      o = c(o, var0);
      any = o.length + p.length > 0;
   }

   public static synchronized void a(Runnable var0) {

      p = c(p, var0);
      any = o.length + p.length > 0;
   }

   public static synchronized void b(Runnable var0) {

      o = d(o, var0);
      p = d(p, var0);
      any = o.length + p.length > 0;
   }

   private static Runnable[] c(Runnable[] var0, Runnable var1) {

      if (var1 == null) {
         return var0;
      } else {
         for (int var2 = 0; var2 < var0.length; var2++) {
            if (var0[var2] == var1) {
               return var0;
            }
         }

         Runnable[] var3 = new Runnable[var0.length + 1];
         System.arraycopy(var0, 0, var3, 0, var0.length);
         var3[var0.length] = var1;
         return var3;
      }
   }

   private static Runnable[] d(Runnable[] var0, Runnable var1) {

      int var2 = -1;

      for (int var3 = 0; var3 < var0.length; var3++) {
         if (var0[var3] == var1) {
            var2 = var3;
            break;
         }
      }

      if (var2 < 0) {
         return var0;
      } else {
         Runnable[] var4 = new Runnable[var0.length - 1];
         System.arraycopy(var0, 0, var4, 0, var2);
         System.arraycopy(var0, var2 + 1, var4, var2, var0.length - var2 - 1);
         return var4;
      }
   }

   public static void e() {

      Runnable[] var0 = o;
      Runnable[] var1 = p;
      if (var0.length + var1.length != 0 && ConfigBridge.c != null && ConfigBridge.c.a()) {
         f(var0);
         f(var1);
      }
   }

   private static void f(Runnable[] var0) {

      for (int var1 = 0; var1 < var0.length; var1++) {
         try {
            var0[var1].run();
         } catch (Throwable var3) {
         }
      }
   }

   public static long g(double var0) {

      return System.nanoTime() + (long)(var0 * 1000000.0);
   }

   public static boolean h(long var0) {

      return System.nanoTime() - var0 >= 0L;
   }

   public static boolean i(ClientPlayerEntity var0) {

      return var0 != null && var0.age != l;
   }

   public static void markInteractBlock(ClientPlayerEntity var0) {
      if (var0 != null) {
         interactBlockAge = var0.age;
      }
   }

   public static boolean canRequestAttack(ClientPlayerEntity var0) {
      return var0 == null || interactBlockAge != var0.age;
   }

   public static void j(ClientPlayerEntity var0) {

      if (var0 != null) {
         m = var0.age;
      }
   }

   public static boolean k(ClientPlayerEntity var0) {

      return var0 != null && var0.age == m + 1;
   }
}
