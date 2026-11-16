package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer;

public class ItemDescriptor extends InitAdapter {
   public int d;
   private final boolean a;
   private boolean b = false;
   private static int c = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   public ItemDescriptor(String var1, int var2, boolean var3) {
      super(var1);
      this.d = var2;
      this.a = var3;
   }

   public Integer f() {

      return this.d;
   }

   @Override
   public Object c() {

      return this.f();
   }

   @Override
   public void a(Object var1) {

      if (var1 instanceof Number) {
         this.d = ((Number)var1).intValue();
      }
   }

   public int g() {

      return this.d;
   }

   public void a(int var1) {

      this.d = var1;
   }

   public boolean i() {

      return this.a;
   }

   public void a(boolean var1) {

      this.b = var1;
   }
}
