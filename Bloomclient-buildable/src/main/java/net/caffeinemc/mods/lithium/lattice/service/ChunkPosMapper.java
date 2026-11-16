package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;

public class ChunkPosMapper {
   private static final int c = 6672;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ -195481566 ^ -195483086) + (1841194459 ^ 1841194252);
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
      return var1 != null ? var3 != 0 : var3 != (265281217 ^ 265274577);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = ("6\u001e\u0007Iu7/\u0006;\u0013" + "Wn\u00022U\u0000" + "C\t.").toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 21;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 21;
            var8 = var2;
         } else {
            var3 = 21;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 21;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 96;
               case 1 -> 99;
               case 2 -> 103;
               case 3 -> 50;
               case 4 -> 11;
               case 5 -> 114;
               default -> 85;
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
