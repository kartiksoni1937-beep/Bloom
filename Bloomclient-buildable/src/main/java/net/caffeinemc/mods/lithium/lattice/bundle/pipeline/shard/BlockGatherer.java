package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

public final class BlockGatherer {
   private static final String[] c;
   private static final String[] d;

   public static boolean c() {
      return false;
   }

   static {
      String[] var0 = new String[2];
      int var1 = 0;
      String var2 = "xÇ\u0082µÛ" + "+¤×:y\u0088\u000fP\féÏ" + "°´\u009d" + "\u000blÓwÿø\t";
      int var3 = "xÇ\u0082µÛ+¤×:y\u0088\u000fP\féÏ°´\u009d\u000blÓwÿø\t".length();
      char var4 = '\r';
      int var5 = -1;

      labelCLINIT: while (true) {
         char[] var6;
         label38: {
            char[] var7 = var2.substring(++var5, var5 + var4).toCharArray();
            int var8 = var7.length;
            int var9 = 0;
            byte var10 = 9;
            var6 = var7;
            int var11 = var8;
            byte var12;
            char[] var13;
            int var14;
            if (var8 <= 1) {
               var13 = var7;
               var12 = 9;
               var14 = var9;
            } else {
               var10 = 9;
               var11 = var8;
               if (var8 <= var9) {
                  break label38;
               }

               var13 = var7;
               var12 = 9;
               var14 = var9;
            }

            while (true) {
               var13[var14] = (char)(var13[var14] ^ var12 ^ switch (var9 % 7) {
                  case 0 -> 47;
                  case 1 -> 79;
                  case 2 -> 71;
                  case 3 -> 88;
                  case 4 -> 111;
                  case 5 -> 59;
                  default -> 124;
               });
               var9++;
               if (var10 == 0) {
                  var14 = var10;
                  var13 = var6;
                  var12 = var10;
               } else {
                  if (var11 <= var9) {
                     break;
                  }

                  var13 = var6;
                  var12 = var10;
                  var14 = var9;
               }
            }
         }

         String var16 = new String(var6).intern();
         byte var17 = -1;
         var0[var1++] = var16;
         if ((var5 += var4) >= var3) {
              c = var0;
              d = new String[2];
              break labelCLINIT;
         }

         var4 = var2.charAt(var5);
      }
   }
}
