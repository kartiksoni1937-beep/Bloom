package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;

public class BehaviorTreeRunner {
   private static final int c = 2704;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ 1301018436 ^ 1301020116) + 87;
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
      return var1 != null ? var3 != 0 : var3 != (2021474198 ^ 2021471494);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = ("0\u0013\\#C&\u0017\u0000\"F'" + "P\u001d\r\u001c\u0018Q0\u00159" + "I" + "\\F").toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 9;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 9;
            var8 = var2;
         } else {
            var3 = 9;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 9;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 123;
               case 1 -> 127;
               case 2 -> 61;
               case 3 -> 75;
               case 4 -> 60;
               case 5 -> 70;
               default -> 113;
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
