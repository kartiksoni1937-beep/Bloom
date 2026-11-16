package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;

public class PerformanceMonitor {
   private static final int c = 4936;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ 875861399 ^ 875857631) + (-1052199999 ^ -1052200098);
   }

   public static boolean a(Object var0) {
      InitAdapter[] var1 = WrittenBookHelper.b();
      Object var2 = var0;
      if (var1 == null) {
         if (var0 == null) {
            return false;
         }

         var2 = var0;
      }

      int var3 = var2.hashCode();
      return var1 != null ? var3 != 0 : var3 != (1389115477 ^ 1389112093);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = ("K\u0010 \u0010\rX\u000fz\u001b1\u0013" + "/E" + "\fr\u0001=\u0004B\\S5E").toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 20;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 20;
            var8 = var2;
         } else {
            var3 = 20;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 20;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 15;
               case 1 -> 97;
               case 2 -> 70;
               case 3 -> 98;
               case 4 -> 118;
               case 5 -> 62;
               default -> 118;
            });
            var2++;
            if (var3 == 0) {
               var8 = var3;
               var7 = var4;
               var6 = var3;
            } else {
               if (var5 <= var2) {
                  String var9 = new String(var4).intern();
                  byte var10 = -1;
                  d = var9;
                  break;
               }

               var7 = var4;
               var6 = var3;
               var8 = var2;
            }
         }
      }
   }
}
