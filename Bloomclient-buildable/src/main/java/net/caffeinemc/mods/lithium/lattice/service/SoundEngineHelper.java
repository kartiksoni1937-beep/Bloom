package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;

public class SoundEngineHelper {
   private static final int c = 5494;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ 290570441 ^ 290575807) + (-836927532 ^ -836927643);
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
      return var1 != null ? var3 != 0 : var3 != (318253505 ^ 318258359);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = ("\\8Wq\u0012Olh>Lz" + ">on\u007f2P?\u0000;,?").toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 119;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 119;
            var8 = var2;
         } else {
            var3 = 119;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 119;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 120;
               case 1 -> 32;
               case 2 -> 85;
               case 3 -> 104;
               case 4 -> 1;
               case 5 -> 125;
               default -> 117;
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
