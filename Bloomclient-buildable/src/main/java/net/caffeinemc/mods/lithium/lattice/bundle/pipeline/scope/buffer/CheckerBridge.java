package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer;

public class CheckerBridge extends InitAdapter {
   public boolean a;
   private static int b;
   private static int c = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   public CheckerBridge(String var1, boolean var2) {
      super(var1);
      this.a = var2;
   }

   public Boolean f() {

      return this.a;
   }

   @Override
   public Object c() {

      return this.f();
   }

   @Override
   public void a(Object var1) {

      if (var1 instanceof Boolean) {
         this.a = (Boolean)var1;
      }
   }

   public void g() {

      int var1 = BlockCalculator.n();
      boolean var2 = this.a;
      if (var1 == 0) {
         var2 = !this.a;
      }

      this.a = var2;
   }

   public static void a(int var0) {

      b = var0;
   }

   public static int h() {
      return b;
   }

   public static int i() {

      int var0 = h();
      return var0 == 0 ? 116 : 0;
   }

   static {
      if (i() == 0) {
         a(3);
      }
   }
}
