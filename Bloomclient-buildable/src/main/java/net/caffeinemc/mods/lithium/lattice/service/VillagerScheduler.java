package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;

public class VillagerScheduler {
   private static final int c = 2394;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ 1557841797 ^ 1557843679) + 77;
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
      return var1 != null ? var3 != 0 : var3 != (533191096 ^ 533188834);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = "Qo/t`\tZuU pd\nJkc18w_\u00117".toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 113;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 113;
            var8 = var2;
         } else {
            var3 = 113;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 113;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 118;
               case 1 -> 119;
               case 2 -> 50;
               case 3 -> 105;
               case 4 -> 112;
               case 5 -> 31;
               default -> 78;
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
