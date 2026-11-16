package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;

public class ChunkStatusHelper {
   private static final int c = 6517;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ 1765573386 ^ 1765579391) + (-1568371000 ^ -1568371174);
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
      return var1 != null ? var3 != 0 : var3 != (372422915 ^ 372416630);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = ("\u001b-fm@\u001cj91" + "fpc*r( " + "a#" + "]~0h").toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 27;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 27;
            var8 = var2;
         } else {
            var3 = 27;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 27;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 67;
               case 1 -> 94;
               case 2 -> 8;
               case 3 -> 24;
               case 4 -> 48;
               case 5 -> 84;
               default -> 5;
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
