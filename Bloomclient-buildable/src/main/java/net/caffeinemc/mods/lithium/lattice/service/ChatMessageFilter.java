package net.caffeinemc.mods.lithium.lattice.service;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;

public class ChatMessageFilter {
   private static final int c = 410;
   private static final String d;

   public static int a(int var0) {
      return (var0 ^ -747087254 ^ -747086864) + 13;
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
      return var1 != null ? var3 != 0 : var3 != (-1641870801 ^ -1641870411);
   }

   public static String a() {
      return d;
   }

   static {
      label33: {
         char[] var0 = ("\u00194\u001ft\"8Z)=\u0019e)4" + "E.9\f \u0019l\u0007j").toCharArray();
         int var1 = var0.length;
         int var2 = 0;
         byte var3 = 46;
         char[] var4 = var0;
         int var5 = var1;
         byte var6;
         char[] var7;
         int var8;
         if (var1 <= 1) {
            var7 = var0;
            var6 = 46;
            var8 = var2;
         } else {
            var3 = 46;
            var5 = var1;
            if (var1 <= var2) {
               String var11 = new String(var0).intern();
               byte var12 = -1;
               d = var11;
               break label33;
            }

            var7 = var0;
            var6 = 46;
            var8 = var2;
         }

         while (true) {
            var7[var8] = (char)(var7[var8] ^ var6 ^ switch (var2 % 7) {
               case 0 -> 116;
               case 1 -> 114;
               case 2 -> 80;
               case 3 -> 46;
               case 4 -> 65;
               case 5 -> 115;
               default -> 7;
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
