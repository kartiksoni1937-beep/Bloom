package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.PacketContainer;
import net.minecraft.client.gui.DrawContext;

public class RenderKernel extends PacketContainer<UtilExtension> {
   private final DrawContext a;

   public RenderKernel(DrawContext var1) {
      this.a = var1;
   }

   public DrawContext e() {

      return this.a;
   }

   @Override
   public Class<UtilExtension> a() {

      return UtilExtension.class;
   }

   public void a(UtilExtension var1) {

      var1.a(this.a);
   }
}
