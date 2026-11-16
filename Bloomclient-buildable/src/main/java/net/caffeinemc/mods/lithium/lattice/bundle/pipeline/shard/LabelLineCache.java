package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import java.util.Arrays;
import net.minecraft.text.Style;
import net.minecraft.text.CharacterVisitor;
import net.minecraft.text.OrderedText;

public final class LabelLineCache implements OrderedText {
   private char[] a = new char[48];
   private Style[] b = new Style[48];
   private int c;
   private static int d = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   public void clear() {

      this.c = 0;
   }

   public void add(String var1, int var2, int var3, Style var4) {
      int var5 = 0;
      int var6 = 0;
      int var7 = 0;
      byte var8 = 0;

      label20:
      while (true) {
         switch (var8) {
            case 0:
            default:
               if (d != 0) {
                  System.nanoTime();
                  var8 = 2;
                  break;
               }
            case 2:
               var5 = var3 - var2;
               if (var5 <= 0) {
                  return;
               }
            case 3:
               var6 = this.c + var5;
               if (var6 > this.a.length) {
                  var7 = Math.max(var6, this.a.length * 2);
                  this.a = Arrays.copyOf(this.a, var7);
                  this.b = Arrays.copyOf(this.b, var7);
                  var8 = 1;
                  break;
               }
            case 1:
               break label20;
         }
      }

      var1.getChars(var2, var3, this.a, this.c);
      Arrays.fill(this.b, this.c, var6, var4);
      this.c = var6;
   }

   public boolean accept(CharacterVisitor var1) {

      char[] var2 = this.a;
      Style[] var3 = this.b;
      int var4 = this.c;

      assert var1 != null
         && var2 != null
         && var3 != null
         && var2.length == var3.length
         && var4 >= 0
         && var4 <= var2.length
         && (var4 == 0 || var3[0] != null)
         && (var4 == 0 || var3[var4 - 1] != null)
         && var2.length >= 1
         && var3.length >= 1
         && this.a == var2
         && this.b == var3
         && this.c == var4
         && var4 < (449734117 ^ 450782693)
         && var2 != (Object)var3 : "accept: bad line";

      try {
         for (int var5 = 0; var5 < var4; var5++) {
            char var6 = var2[var5];
            if (Character.isHighSurrogate(var6) && var5 + 1 < var4 && Character.isLowSurrogate(var2[var5 + 1])) {
               int var7 = Character.toCodePoint(var6, var2[var5 + 1]);
               if (!var1.accept(var5, var3[var5], var7)) {
                  return false;
               }

               var5++;
            } else if (!var1.accept(var5, var3[var5], var6)) {
               return false;
            }
         }

         return true;
      } catch (RuntimeException var8) {
         throw var8;
      }
   }
}
