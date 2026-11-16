package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;

public class ListenerRegistrar {
   private static final int c = 4750;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ -839632289 ^ -839636783) + (-916091337 ^ -916091218);
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
      return var1 != null ? var3 != 0 : var3 != (-2012847552 ^ -2012843826);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = ("]`@ L\u000bRc[V3@\u0016CchA" + "t_T\u0019!").toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 111;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 111;
            var8 = var2;
         } else {
            var3 = 111;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 111;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 126;
               case 1 -> 102;
               case 2 -> 92;
               case 3 -> 59;
               case 4 -> 70;
               case 5 -> 10;
               default -> 88;
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
