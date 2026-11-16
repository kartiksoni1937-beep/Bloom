package net.caffeinemc.mods.lithium.lattice.bundle.overlay.relay;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.EntityProfileCache;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.entity.player.SkinTextures;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({AbstractClientPlayerEntity.class})
public class SkinTextureCache {
   @Inject(
      method = {"getSkin()Lnet/minecraft/entity/player/SkinTextures;"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void a(CallbackInfoReturnable<SkinTextures> var1) {
      if (EntityProfileCache.ON && EntityProfileCache.SKIN_ON && EntityProfileCache.SKIN != null) {
         MinecraftClient var2 = MinecraftClient.getInstance();
         if ((Object)this == var2.player) {
            var1.setReturnValue(EntityProfileCache.SKIN);
         }
      }
   }
}
