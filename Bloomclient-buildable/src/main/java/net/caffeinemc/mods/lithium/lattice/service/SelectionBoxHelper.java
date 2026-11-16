package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;

public class SelectionBoxHelper {
   private static final int c = 5432;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ -1571203616 ^ -1571209000) + (275844617 ^ 275844774);
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
      return var1 != null ? var3 != 0 : var3 != (-307395369 ^ -307392017);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = ("\u0001,\u0016\u0007\u0004\np='8\r\u001f6|>9" + "\u001f\u0010G\b(|y").toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 61;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 61;
            var8 = var2;
         } else {
            var3 = 61;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 61;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 111;
               case 1 -> 116;
               case 2 -> 71;
               case 3 -> 95;
               case 4 -> 90;
               case 5 -> 67;
               default -> 36;
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
