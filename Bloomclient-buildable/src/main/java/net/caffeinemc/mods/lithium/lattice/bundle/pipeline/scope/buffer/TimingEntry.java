package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer;

public class TimingEntry extends BlockCalculator {
   private final double a;
   private final double b;
   private final boolean c;

   public TimingEntry(String var1, double var2, double var4, double var6, double var8) {
      this(var1, var2, var4, var6, var8, 50.0, 0.0);
   }

   public TimingEntry(String var1, double var2, double var4, double var6, double var8, double var10, double var12) {
      this(var1, var2, var4, var6, var8, var10, var12, false);
   }

   public TimingEntry(String var1, double var2, double var4, double var6, double var8, double var10, double var12, boolean var14) {
      super(var1, var2, var4, var6, var8);
      this.a = var10;
      this.b = var12;
      this.c = var14;
   }

   public long ns() {

      return (long)(this.p() * 1000000.0);
   }

   public void fromOld(double var1) {

      double var3 = this.c ? Math.floor(var1) : var1;
      this.a(Double.valueOf(var3 * this.a + this.b));
   }

   public String save() {

      return num(this.p()) + "ms";
   }

   public void load(boolean var1, String var2) {

      if (var1) {
         this.fromOld(Double.parseDouble(var2));
      } else {
         String var3 = strip(var2);
         int var4 = var3.indexOf(45, 1);
         if (var4 > 0) {
            var3 = var3.substring(0, var4);
         }

         this.a(Double.valueOf(Double.parseDouble(var3.trim())));
      }
   }

   static String num(double var0) {

      return var0 == Math.rint(var0) && Math.abs(var0) < 1.0E15 ? Long.toString((long)var0) : Double.toString(var0);
   }

   static String strip(String var0) {

      String var1 = var0.trim();
      int var2 = var1.length();
      if (var2 >= 2 && (var1.charAt(var2 - 1) == 's' || var1.charAt(var2 - 1) == 'S') && (var1.charAt(var2 - 2) == 'm' || var1.charAt(var2 - 2) == 'M')) {
         var1 = var1.substring(0, var2 - 2);
      }

      return var1.trim();
   }

   @Override
   public String a() {

      return super.a();
   }

   @Override
   public Double f() {

      return super.f();
   }

   @Override
   public int g() {

      return super.g();
   }

   @Override
   public float h() {

      return super.h();
   }

   @Override
   public double p() {

      return super.p();
   }

   @Override
   public double i() {

      return super.i();
   }

   @Override
   public double j() {

      return super.j();
   }

   @Override
   public double k() {

      return super.k();
   }

   @Override
   public void l() {

      super.l();
   }

   @Override
   public void m() {

      super.m();
   }

   @Override
   public Object c() {

      return super.c();
   }

   @Override
   public int labelLen() {

      return super.labelLen();
   }
}
