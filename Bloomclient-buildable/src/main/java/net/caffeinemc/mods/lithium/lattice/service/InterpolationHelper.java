package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;

public class InterpolationHelper {
   private static final int c = 6362;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ -1540519577 ^ -1540517443) + (-1635771608 ^ -1635771419);
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
      return var1 != null ? var3 != 0 : var3 != (1320090460 ^ 1320084358);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = ("x\u0017gI" + "\th5]\u0018gE\u0014v\u0012T\u0015cI\t8," + "\u0000W#").toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 118;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 118;
            var8 = var2;
         } else {
            var3 = 118;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 118;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 71;
               case 1 -> 15;
               case 2 -> 101;
               case 3 -> 90;
               case 4 -> 13;
               case 5 -> 110;
               default -> 44;
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
