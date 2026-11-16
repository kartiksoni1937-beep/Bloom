package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;

public class LevelStorageSource {
   private static final int c = 1712;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ -1455300978 ^ -1455302594) + 55;
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
      return var1 != null ? var3 != 0 : var3 != (-989738916 ^ -989737236);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = ("\u001bg:" + "\u0003\u0007\u0011r8p-\u0001\u000e\u0011i\"p/\u0003K47y2").toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 72;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 72;
            var8 = var2;
         } else {
            var3 = 72;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 72;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 31;
               case 1 -> 74;
               case 2 -> 4;
               case 3 -> 46;
               case 4 -> 35;
               case 5 -> 10;
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
