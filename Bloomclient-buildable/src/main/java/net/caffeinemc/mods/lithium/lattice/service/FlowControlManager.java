package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;

public class FlowControlManager {
   private static final int c = 3727;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ -1473367091 ^ -1473364670) + 120;
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
      return var1 != null ? var3 != 0 : var3 != (-1180719462 ^ -1180719083);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = ("2P,]K\nE\u0000N,F" + "E\u0004E\u0015[" + "&X(\u0013\u001aZ\f").toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 37;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 37;
            var8 = var2;
         } else {
            var3 = 37;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 37;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 81;
               case 1 -> 25;
               case 2 -> 102;
               case 3 -> 15;
               case 4 -> 45;
               case 5 -> 64;
               default -> 14;
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
