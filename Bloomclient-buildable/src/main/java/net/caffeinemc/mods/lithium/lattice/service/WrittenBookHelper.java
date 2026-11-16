package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;

public class WrittenBookHelper {
   private static final int d = 7137;
   private static InitAdapter[] e;
   private static final String f;

   public static int a(int var0) {
      return (var0 ^ -1270896920 ^ -1270891255) + (-698961792 ^ -698961818);
   }

   public static boolean a(Object var0) {
      InitAdapter[] var1 = b();
      Object var2 = var0;
      if (var1 == null) {
         if (var0 == null) {
            return false;
         }

         var2 = var0;
      }

      int var3 = var2.hashCode();
      return var1 != null ? var3 != 0 : var3 != (-1624097997 ^ -1624104750);
   }

   public static String a() {
      return f;
   }

   public static void b(InitAdapter[] var0) {
      e = var0;
   }

   public static InitAdapter[] b() {
      return e;
   }

   static {
      if (b() != null) {
         b(new InitAdapter[5]);
      }

      label36: {
         char[] var0 = "Gc- >-\tR~+?\u0002-\u000b`t6t<yI ".toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 63;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 63;
            var8 = var2;
         } else {
            var3 = 63;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               f = var11;
               break label36;
            }

            var7 = var0;
            var6 = 63;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 47;
               case 1 -> 46;
               case 2 -> 123;
               case 3 -> 107;
               case 4 -> 117;
               case 5 -> 119;
               default -> 88;
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
                  f = var9;
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
