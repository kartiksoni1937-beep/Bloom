package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import java.util.Arrays;

public final class ProfileTextCache {
   public static volatile boolean ON = false;
   public static volatile String[] STR = new String[0];
   public static volatile char[][] LO = new char[0][];
   public static volatile char[][] UP = new char[0][];
   public static volatile int[][] FAIL = new int[0][];
   public static volatile int MIN_LEN = Integer.MAX_VALUE;
   public static volatile char[] FAKE = new char[0];
   public static volatile int GEN = 0;
   public static boolean EDIT = false;

   private ProfileTextCache() {
   }

   public static void set(boolean var0, String[] var1, String var2) {

      String[] var3 = new String[var1.length];
      int var4 = 0;

      for (String var8 : var1) {
         if (var8 != null && !var8.isEmpty()) {
            String var9 = var8.toLowerCase();
            boolean var10 = false;

            for (int var11 = 0; var11 < var4; var11++) {
               if (var3[var11].equals(var9)) {
                  var10 = true;
                  break;
               }
            }

            if (!var10) {
               var3[var4++] = var9;
            }
         }
      }

      var3 = Arrays.copyOf(var3, var4);
      char[] var14 = var2 == null ? new char[0] : var2.toCharArray();
      boolean var15 = var0 && var4 > 0 && var14.length > 0;
      if (var15 != ON || !Arrays.equals(var14, FAKE) || !Arrays.equals((Object[])var3, (Object[])STR)) {
         char[][] var16 = new char[var4][];
         char[][] var17 = new char[var4][];
         int[][] var18 = new int[var4][];
         int var19 = -605414884 ^ -1542068765;

         for (int var20 = 0; var20 < var4; var20++) {
            var16[var20] = var3[var20].toCharArray();
            char[] var12 = var3[var20].toUpperCase().toCharArray();
            var17[var20] = var12.length == var16[var20].length ? var12 : var16[var20];
            var18[var20] = a(var16[var20]);
            var19 = Math.min(var19, var16[var20].length);
         }

         STR = var3;
         LO = var16;
         UP = var17;
         FAIL = var18;
         MIN_LEN = var19;
         FAKE = var14;
         ON = var15;
         GEN++;
      }
   }

   private static int[] a(char[] var0) {

      int[] var1 = new int[var0.length];
      int var2 = 0;

      for (int var3 = 1; var3 < var0.length; var3++) {
         while (var2 > 0 && var0[var3] != var0[var2]) {
            var2 = var1[var2 - 1];
         }

         if (var0[var3] == var0[var2]) {
            var2++;
         }

         var1[var3] = var2;
      }

      return var1;
   }
}
