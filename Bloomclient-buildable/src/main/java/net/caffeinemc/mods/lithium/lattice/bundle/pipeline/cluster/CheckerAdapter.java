package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.PacketContainer;

public class CheckerAdapter extends PacketContainer<InitNotifier> {
   private static int a = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   @Override
   public Class<InitNotifier> a() {

      return InitNotifier.class;
   }

   public void a(InitNotifier var1) {

      var1.a();
   }
}
