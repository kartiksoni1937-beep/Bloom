package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class EncryptedString implements CharSequence {
   char[] key;
   char[] value;

   public EncryptedString(String var1) {
      int var2 = var1.length();
      char[] var3 = new char[Math.min(var2, 64)];
      ThreadLocalRandom var4 = ThreadLocalRandom.current();

      for (int var5 = 0; var5 < var3.length; var5++) {
         var3[var5] = (char)var4.nextInt(65535);
      }

      char[] var6 = var1.toCharArray();
      a(var6, var3, 0, var6.length);
      this.key = var3;
      this.value = var6;
   }

   public static EncryptedString of(String var0) {

      return new EncryptedString(var0);
   }

   public static EncryptedString of(String var0, String var1) {

      return new EncryptedString(var0.toCharArray(), var1.toCharArray());
   }

   private static void a(char[] var0, char[] var1, int var2, int var3) {

      for (int var4 = var2; var4 < var2 + var3; var4++) {
         var0[var4] ^= var1[var4 % var1.length];
      }
   }

   public EncryptedString(char[] var1, char[] var2) {
      this.key = var2;
      this.value = var1;
   }

   @Override
   public int length() {

      return this.value.length;
   }

   @Override
   public char charAt(int var1) {

      return (char)(this.value[var1] ^ this.key[var1 % this.key.length]);
   }

   @Override
   public String toString() {

      char[] var1 = Arrays.copyOf(this.value, this.value.length);
      a(var1, this.key, 0, var1.length);
      return new String(var1);
   }

   @Override
   public CharSequence subSequence(int var1, int var2) {

      int var3 = var2 - var1;
      char[] var4 = new char[var3];
      char[] var5 = new char[var3];
      System.arraycopy(this.value, var1, var4, 0, var3);

      for (int var6 = 0; var6 < var3; var6++) {
         var5[var6] = this.key[(var1 + var6) % this.key.length];
      }

      return new EncryptedString(var4, var5);
   }
}
