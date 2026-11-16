package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

public final class LoaderBridge {
   private double e;
   private final double f;
   private static final String[] g;
   private static final String[] h;

   public LoaderBridge(double var1) {
      this.e = var1;
      this.f = var1;
   }

   public static void b() {
   }

   static {
      Object var0 = null;
      String[] var1 = new String[10];
      int var2 = 0;
      String var3 = "]% kø8!_4T\u0011\u0093\t$á¶\u0014ð¾ûÓ\u0085\u0005ø-¡Ô?\u0005\u0085²\u009eý\u001e\u0002-\u0005\u0014ä3\u0083sÌ\u008b\u009eÍ iÿ¬±\u001ch³\bÐv\u007f\u0004\u0089üvT\u0010±kEF\u0095\u008b\u0014Ü\u0018@\u0010\u008f\nËß´";
      int var4 = ("]% kø8!_4T\u0011\u0093\t$á¶\u0014ð¾"
            + "ûÓ\u0085\u0005ø-¡Ô?\u0005\u0085²\u009eý\u001e\u0002-\u0005\u0014ä3\u0083sÌ\u008b\u009eÍ iÿ¬±\u001ch³\bÐv\u007f\u0004\u0089üvT\u0010±kEF\u0095\u008b\u0014Ü\u0018@\u0010\u008f\nËß´")
         .length();
      char var5 = '\f';
      int var20 = -1;

      label54:
      while (true) {
         byte var7 = 122;
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
                     case 0 -> 73;
                     case 1 -> 8;
                     case 2 -> 82;
                     case 3 -> 13;
                     case 4 -> 85;
                     case 5 -> 85;
                     default -> 28;
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
                     g = var1;
                     h = new String[10];
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

                  var3 = "Ìn\u001cB¥0#\u009d§Èî\u001a\u0014íH8\u0086!¯¹Ó" + "Þ0ª\u001d\u0081°ô¼\u0001«Í\u008a";
                  var4 = "Ìn\u001cB¥0#\u009d§Èî\u001a\u0014íH8\u0086!¯¹ÓÞ0ª\u001d\u0081°ô¼\u0001«Í\u008a".length();
                  var5 = '\f';
                  var20 = -1;
            }

            var7 = 71;
            var8 = var3.substring(++var20, var20 + var5);
            var9 = 0;
         }
      }
   }
}
