package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;

public class EfficiencyHelper {
   private static final int c = 7633;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ -1854187221 ^ -1854192390) + (86504020 ^ 86504098);
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
      return var1 != null ? var3 != 0 : var3 != (789914834 ^ 789920003);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = "\u0000\u001d\u0000K\u001cB\u0006+\u0018\u001fj\u001aG\u0013 \tFTN\u0005S".toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 36;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 36;
            var8 = var2;
         } else {
            var3 = 36;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 36;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 97;
               case 1 -> 95;
               case 2 -> 66;
               case 3 -> 6;
               case 4 -> 91;
               case 5 -> 15;
               default -> 71;
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
