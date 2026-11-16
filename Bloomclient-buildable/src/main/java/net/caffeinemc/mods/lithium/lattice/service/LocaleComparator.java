package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;

public class LocaleComparator {
   private static final int c = 6083;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ -388327074 ^ -388329827) + (1177276010 ^ 1177276078);
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
      return var1 != null ? var3 != 0 : var3 != (-1046400543 ^ -1046403550);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = ("\u0016>\u0016\u0011$\u0015N" + "5<\u0005\u0011:\u0011y5#U\u0006" + "y" + "^=").toCharArray();
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
               case 0 -> 83;
               case 1 -> 88;
               case 2 -> 124;
               case 3 -> 121;
               case 4 -> 65;
               case 5 -> 121;
               default -> 4;
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
