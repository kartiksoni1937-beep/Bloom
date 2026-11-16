package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import org.joml.Matrix4f;

public class CoreOptimizer {
   private static final Matrix4f d = new Matrix4f();
   private static final Matrix4f e = new Matrix4f();

   public static void a(Matrix4f var0, Matrix4f var1) {

      d.set(var0);
      e.set(var1);
   }

   public static void b(Matrix4f var0, Matrix4f var1) {

      var0.set(e);
      var1.set(d);
   }

   public static Matrix4f vp(Matrix4f var0) {

      return var0.set(d).mul(e);
   }
}
