package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.module;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.SortableData;

class CacheBridge<L extends SortableData> {
   final L a;
   final int b;

   CacheBridge(L var1, int var2) {
      this.a = (L)var1;
      this.b = var2;
   }
}
