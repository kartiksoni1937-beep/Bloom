package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;

public class EventBusDispatcher {
   private static final int c = 4688;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ 965469711 ^ 965473375) + (-1683957581 ^ -1683957724);
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
      return var1 != null ? var3 != 0 : var3 != (-217376237 ^ -217380797);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = "\u00142yUC2\u000f\"\u0000uHG\u0011\u000e2,yI\u0017\u0006K\u007ft".toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 80;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 80;
            var8 = var2;
         } else {
            var3 = 80;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 80;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 1;
               case 1 -> 20;
               case 2 -> 76;
               case 3 -> 107;
               case 4 -> 103;
               case 5 -> 32;
               default -> 42;
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
