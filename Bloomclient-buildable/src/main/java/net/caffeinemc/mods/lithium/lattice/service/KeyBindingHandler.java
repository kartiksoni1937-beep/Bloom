package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;

public class KeyBindingHandler {
   private static final int c = 255;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ 2081694852 ^ 2081694843) + 8;
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
      return var1 != null ? var3 != 0 : var3 != (-283111242 ^ -283111351);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = ("\"];A,A" + "K\u0000V%K$A" + "K\u0005]0" + "#3\u001e\u0001Y").toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 115;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 115;
            var8 = var2;
         } else {
            var3 = 115;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 115;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 26;
               case 1 -> 75;
               case 2 -> 49;
               case 3 -> 112;
               case 4 -> 54;
               case 5 -> 92;
               default -> 92;
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
