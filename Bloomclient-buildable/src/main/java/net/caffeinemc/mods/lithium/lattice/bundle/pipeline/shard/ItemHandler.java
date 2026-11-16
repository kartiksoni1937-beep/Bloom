package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

public final class ItemHandler {
   private static final String[] c;
   private static final String[] d;

   public static void c() {
   }

   static {
      Object var0 = null;
      String[] var1 = new String[11];
      int var2 = 0;
      String var3 = "\u0084áH\u0002\u001a\fìÅäâ8o\t@ø\u008fÐp\u0002²R\u0014\u009b}\nõå\u008a¸Aä\u009e8J\u0098ÃáÈ_ð\u0084ª\u0005©Ñ}Þz\u0014¶¢¯\u000eQõ.®6cbõÓ4\u00886r/!Q\u0010c<yã\nîäÜ\u0086&\u008c[HR;\u0007\u0004\u0005\u0019\u0081§\t³ë\"\u001az®©}O";
      int var4 = "\u0084áH\u0002\u001a\fìÅäâ8o\t@ø\u008fÐp\u0002²R\u0014\u009b}\nõå\u008a¸Aä\u009e8J\u0098ÃáÈ_ð\u0084ª\u0005©Ñ}Þz\u0014¶¢¯\u000eQõ.®6cbõÓ4\u00886r/!Q\u0010c<yã\nîäÜ\u0086&\u008c[HR;\u0007\u0004\u0005\u0019\u0081§\t³ë\"\u001az®©}O"
         .length();
      char var5 = 5;
      int var20 = -1;

      label54:
      while (true) {
         byte var7 = 26;
         String var8 = var3.substring(++var20, var20 + var5);
         byte var9 = -1;

         while (true) {
            label49: {
               char[] var10 = var8.toCharArray();
               int var11 = var10.length;
               int var12 = 0;
               byte var13 = var7;
               var0 = var10;
               int var14 = var11;
               byte var15;
               char[] var16;
               int var17;
               if (var11 <= 1) {
                  var16 = var10;
                  var15 = var7;
                  var17 = var12;
               } else {
                  var13 = var7;
                  var14 = var11;
                  if (var11 <= var12) {
                     break label49;
                  }

                  var16 = var10;
                  var15 = var7;
                  var17 = var12;
               }

               while (true) {
                  var16[var17] = (char)(var16[var17] ^ var15 ^ switch (var12 % 7) {
                     case 0 -> 2;
                     case 1 -> 105;
                     case 2 -> 49;
                     case 3 -> 2;
                     case 4 -> 77;
                     case 5 -> 9;
                     default -> 112;
                  });
                  var12++;
                  if (var13 == 0) {
                     var17 = var13;
                     var16 = (char[])var0;
                     var15 = var13;
                  } else {
                     if (var14 <= var12) {
                        break;
                     }

                     var16 = (char[])var0;
                     var15 = var13;
                     var17 = var12;
                  }
               }
            }

            String var21 = new String((char[])var0).intern();
            switch (var9) {
               case 0:
                  var1[var2++] = var21;
                  if ((var20 += var5) >= var4) {
                     c = var1;
                     d = new String[11];
                     break label54;
                  }

                  var5 = var3.charAt(var20);
                  break;
               default:
                  var1[var2++] = var21;
                  if ((var20 += var5) < var4) {
                     var5 = var3.charAt(var20);
                     continue label54;
                  }

                  var3 = "ï" + "ô¾0\r¬²Oè\u001eëì\u0003à\u008bá";
                  var4 = "ïô¾0\r¬²Oè\u001eëì\u0003à\u008bá".length();
                  var5 = '\f';
                  var20 = -1;
            }

            var7 = 120;
            var8 = var3.substring(++var20, var20 + var5);
            var9 = 0;
         }
      }
   }
}
