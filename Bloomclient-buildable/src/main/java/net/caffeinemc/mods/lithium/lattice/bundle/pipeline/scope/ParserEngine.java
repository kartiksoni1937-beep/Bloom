package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope;

public enum ParserEngine {
   CT("Combat"),
   Z3("Render"),
   V2("Enhanced Mod" + "ul" + "es"),
   Z4("Misc"),
   PC("Pot Cheats");

   public final char[] a;
   public final int aK;
   private static int[] d;

   private ParserEngine(String var3) {
      this.aK = var3.hashCode() * 31 + 17;
      this.a = a(var3, this.aK);
   }

   public String a() {

      char[] var1 = new char[this.a.length];

      for (int var2 = 0; var2 < var1.length; var2++) {
         var1[var2] = (char)(this.a[var2] ^ this.aK + var2 * 31);
      }

      return new String(var1);
   }

   @Override
   public String toString() {

      return this.a();
   }

   private static char[] a(String var0, int var1) {

      char[] var2 = var0.toCharArray();
      char[] var3 = new char[var2.length];

      for (int var4 = 0; var4 < var2.length; var4++) {
         var3[var4] = (char)(var2[var4] ^ var1 + var4 * 31);
      }

      return var3;
   }

   public static void b(int[] var0) {

      d = var0;
   }

   static {
      b(new int[1]);
   }
}
