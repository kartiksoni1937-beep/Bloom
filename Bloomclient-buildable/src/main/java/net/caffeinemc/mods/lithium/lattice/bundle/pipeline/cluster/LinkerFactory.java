package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.PacketContainer;

public class LinkerFactory extends PacketContainer<CoreSerializer> {
   private static int a = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   @Override
   public Class<CoreSerializer> a() {

      return CoreSerializer.class;
   }

   public void a(CoreSerializer var1) {

      var1.a(this);
   }
}
