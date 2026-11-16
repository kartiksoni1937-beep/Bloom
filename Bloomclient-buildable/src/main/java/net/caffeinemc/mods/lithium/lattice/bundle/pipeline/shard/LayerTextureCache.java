package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;

public final class LayerTextureCache extends NativeImageBackedTexture {

   public LayerTextureCache(String var1, NativeImage var2) {
      super(() -> {

         return var1;
      }, var2);
      this.sampler = RenderSystem.getSamplerCache().get(FilterMode.LINEAR);
   }
}
