package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.PacketContainer;

public class BufferEncoder extends PacketContainer<CalculateRange> {
   private static int[] a;
   private static int b = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   @Override
   public Class<CalculateRange> a() {

      return CalculateRange.class;
   }

   public void a(CalculateRange var1) {

      var1.a(this);
   }

   public static void b(int[] var0) {

      a = var0;
   }

   public static int[] e() {
      return a;
   }

   static {
      if (e() != null) {
         b(new int[5]);
      }
   }
}
