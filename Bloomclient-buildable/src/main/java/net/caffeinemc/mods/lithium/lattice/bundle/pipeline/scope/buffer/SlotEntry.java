package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer;

import java.util.Arrays;
import java.util.List;

public class SlotEntry extends InitAdapter {
   private String a;
   private final List<String> b;
   private static int c = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   public SlotEntry(String var1, String var2, String... var3) {
      super(var1);
      this.b = Arrays.asList(var3);
      this.a = var2;
   }

   public String f() {

      return this.a;
   }

   @Override
   public Object c() {

      return this.f();
   }

   @Override
   public void a(Object var1) {
      byte var2 = 0;

      while (true) {
         switch (var2) {
            case 0:
            default:
               if (c != 0) {
                  System.nanoTime();
                  var2 = 1;
                  break;
               }
            case 1:
               if (var1 instanceof String) {
                  this.a = (String)var1;
                  var2 = 2;
                  break;
               }

               return;
            case 2:
               return;
         }
      }
   }

   public List<String> g() {

      return this.b;
   }

   public void h() {
      int var1 = 0;
      int var2 = 0;
      int var3 = 0;
      byte var4 = 0;

      while (true) {
         switch (var4) {
            case 0:
            default:
               if (c != 0) {
                  Thread.currentThread().getName().length();
                  var4 = 1;
                  break;
               }
            case 1:
               var1 = BlockCalculator.n();
               var2 = this.b.indexOf(this.a);
               var2 = (var2 + 1) % this.b.size();
               this.a = this.b.get(var2);
               if (InitAdapter.e() == 0) {
                  var3 = var1 + 1;
                  BlockCalculator.a(var3);
                  var4 = 2;
                  break;
               }

               return;
            case 2:
               return;
         }
      }
   }

   public boolean b(String var1) {

      return this.a.equals(var1);
   }
}
