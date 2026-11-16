package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import java.util.LinkedHashMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.util.BufferAllocator;
import net.minecraft.client.render.VertexConsumerProvider;
public final class PlateTextCache extends VertexConsumerProvider.Immediate {
   private static final int a = 48;
   private final LinkedHashMap<RenderLayer, BufferAllocator> b;

   public PlateTextCache(BufferAllocator var1, LinkedHashMap<RenderLayer, BufferAllocator> var2) {
      super(var1, var2);
      this.b = var2;
   }

   public void learn() {

      RenderLayer var1 = this.currentLayer;
      if (var1 != null && this.b.size() < 48 && !this.b.containsKey(var1)) {
         this.b.put(var1, new BufferAllocator(-17587839 ^ -17571455));
      }
   }

   public void trim() {

      if (this.b.size() >= 48) {
         for (BufferAllocator var2 : this.b.values()) {
            var2.close();
         }

         this.b.clear();
      }
   }
}
