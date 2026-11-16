package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.PacketContainer;
import net.minecraft.network.packet.Packet;

public class ViewDelegate extends PacketContainer<NodeQueue> {
   private final Packet<?> a;
   private static int b = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   public ViewDelegate(Packet<?> var1) {
      BufferEncoder.e();
      this.a = var1;
      if (InitAdapter.e() == 0) {
         BufferEncoder.b(new int[1]);
      }
   }

   @Override
   public Class<NodeQueue> a() {

      return NodeQueue.class;
   }

   public void a(NodeQueue var1) {

      var1.a(this);
   }
}
