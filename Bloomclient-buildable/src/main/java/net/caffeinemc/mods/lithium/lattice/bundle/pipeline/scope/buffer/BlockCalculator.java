package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer;

public class BlockCalculator extends InitAdapter {
   public final double a;
   private final double b;
   private final double c;
   private double i;
   private static int j;
   private static int k = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   public BlockCalculator(String var1, double var2, double var4, double var6, double var8) {
      super(var1);
      this.a = var2;
      this.b = var4;
      this.i = var6;
      this.c = var8;
   }

   public Double f() {

      return this.i;
   }

   public int g() {

      return (int)this.i;
   }

   public float h() {

      return (float)this.i;
   }

   public double p() {

      return this.i;
   }

   @Override
   public Object c() {

      return this.f();
   }

   @Override
   public void a(Object var1) {

      int var2 = n();
      Object var3 = var1;
      if (var2 == 0) {
         if (!(var1 instanceof Number)) {
            return;
         }

         var3 = var1;
      }

      double var4 = ((Number)var3).doubleValue();
      var4 = (double)Math.round(var4 / this.c) * this.c;
      this.i = Math.max(this.a, Math.min(this.b, var4));
   }

   public double i() {

      return this.a;
   }

   public double j() {

      return this.b;
   }

   public double k() {

      return this.c;
   }

   public void l() {

      this.a(this.i + this.c);
   }

   public void m() {

      this.a(this.i - this.c);
   }

   public static void a(int var0) {

      j = var0;
   }

   public static int n() {
      return j;
   }

   static {
      if (n() != 0) {
         a(29);
      }
   }
}
