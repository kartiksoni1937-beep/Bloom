package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer;

public class TextEntry extends InitAdapter {
   private String a;
   private final int b;
   private static int c = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   public TextEntry(String var1, String var2, int var3) {
      super(var1);
      this.b = var3;
      this.a = var2 == null ? "" : var2;
   }

   public String f() {

      return this.a;
   }

   public int g() {

      return this.b;
   }

   public void b(String var1) {

      if (var1 == null) {
         var1 = "";
      }

      if (var1.length() > this.b) {
         var1 = var1.substring(0, this.b);
      }

      this.a = var1;
   }

   @Override
   public Object c() {

      return this.a;
   }

   @Override
   public void a(Object var1) {

      if (var1 instanceof String) {
         this.b((String)var1);
      }
   }
}
