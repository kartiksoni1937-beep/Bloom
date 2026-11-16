package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer;

public class MaskEntry extends TextEntry {
   public static final int SLOTS = 36;
   private final String f;
   private String g = null;
   private long h = 0L;

   public MaskEntry(String var1, String var2) {
      super(var1, "", 128);
      this.f = var2;
   }

   public long a_r92() {

      String var1 = this.f();
      if (var1 != this.g) {
         long var2 = 0L;
         int var4 = 0;
         boolean var5 = false;

         for (int var6 = 0; var6 <= var1.length(); var6++) {
            char var7 = var6 < var1.length() ? var1.charAt(var6) : 44;
            if (var7 >= '0' && var7 <= '9') {
               var4 = var4 * 10 + (var7 - '0');
               var5 = true;
               if (var4 > (-1863183116 ^ -1863182573)) {
                  var4 = 265334379 ^ 265334156;
               }
            } else if (var7 == ',') {
               if (var5 && var4 < 36) {
                  var2 |= 1L << var4;
               }

               var4 = 0;
               var5 = false;
            }
         }

         this.g = var1;
         this.h = var2;
      }

      return this.h;
   }

   public int b() {

      return Long.bitCount(this.a_r92());
   }

   public void c(int var1) {

      if (var1 >= 0 && var1 < 36) {
         long var2 = this.a_r92() ^ 1L << var1;
         StringBuilder var4 = new StringBuilder();

         for (int var5 = 0; var5 < 36; var5++) {
            if ((var2 & 1L << var5) != 0L) {
               if (var4.length() > 0) {
                  var4.append(',');
               }

               var4.append(var5);
            }
         }

         this.b(var4.toString());
      }
   }

   public void d_r93() {

      this.b("");
   }

   public String e_r94() {

      return this.f;
   }
}
