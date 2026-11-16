package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer;

import java.util.concurrent.ThreadLocalRandom;

public final class SpanEntry extends TimingEntry {
   private double f;
   private static int g = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   public SpanEntry(String var1, double var2, double var4, double var6, double var8, double var10, double var12, double var14) {
      super(var1, var2, var4, Math.min(var6, var8), var10, var12, var14);
      this.f = Math.max(this.p(), Math.min(var4, Math.max(var6, var8)));
   }

   public double lo() {

      return this.p();
   }

   public double hi() {

      return this.f;
   }

   public double a_r95() {

      double var1 = this.p();
      double var3 = this.f;
      return var3 > var1 ? var1 + ThreadLocalRandom.current().nextDouble() * (var3 - var1) : var1;
   }

   public long b() {

      return (long)(this.a_r95() * 1000000.0);
   }

   public void c(double var1) {
      byte var3 = 0;

      while (true) {
         switch (var3) {
            case 0:
            default:
               if (g != 0) {
                  Thread.currentThread().getName().length();
                  var3 = 1;
                  break;
               }
            case 1:
               super.a(Double.valueOf(var1));
               if (this.f < this.p()) {
                  this.f = this.p();
                  var3 = 2;
                  break;
               }

               return;
            case 2:
               return;
         }
      }
   }

   public void d(double var1) {

      double var3 = this.k();
      double var5 = var3 > 0.0 ? (double)Math.round(var1 / var3) * var3 : var1;
      var5 = Math.max(this.i(), Math.min(this.j(), var5));
      this.f = var5;
      if (this.p() > var5) {
         super.a(Double.valueOf(var5));
      }
   }

   public void e(double var1, double var3) {

      double var5 = Math.min(var1, var3);
      double var7 = Math.max(var1, var3);
      super.a(Double.valueOf(var5));
      this.d(var7);
      if (this.f < this.p()) {
         this.f = this.p();
      }
   }

   @Override
   public void a(Object var1) {

      if (var1 instanceof double[] var2) {
         if (var2.length >= 2) {
            this.e(var2[0], var2[1]);
         }
      } else {
         super.a(var1);
         if (this.f < this.p()) {
            this.f = this.p();
         }
      }
   }

   @Override
   public void fromOld(double var1) {

      super.fromOld(var1);
      this.f = this.p();
   }

   @Override
   public String save() {

      return num(this.p()) + "-" + num(this.f) + "ms";
   }

   @Override
   public void load(boolean var1, String var2) {

      if (var1) {
         this.fromOld(Double.parseDouble(var2));
      } else {
         String var3 = strip(var2);
         int var4 = var3.indexOf(45, 1);
         if (var4 > 0) {
            this.e(Double.parseDouble(var3.substring(0, var4).trim()), Double.parseDouble(var3.substring(var4 + 1).trim()));
         } else {
            double var5 = Double.parseDouble(var3);
            this.e(var5, var5);
         }
      }
   }

   public String a_r5() {

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

   @Override
   public long ns() {

      return super.ns();
   }
}
