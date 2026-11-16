package net.caffeinemc.mods.lithium.lattice.bundle.overlay.relay;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.ViewContextHandler;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.entity.PlayerLikeEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({PlayerEntityRenderer.class})
public abstract class EntityLabelCache {
   @Inject(
      method = {"hasLabel(Lnet/minecraft/entity/PlayerLikeEntity;D)Z"},
      at = {@At("RETURN")},
      cancellable = true
   )
   private void a(PlayerLikeEntity var1, double var2, CallbackInfoReturnable<Boolean> var4) {
      if (ConfigBridge.c != null
         && ViewContextHandler.HIDE_VANILLA
         && var4.getReturnValueZ()
         && var1 instanceof PlayerEntity
         && var1 != MinecraftClient.getInstance().player) {
         long var5 = System.nanoTime() - ViewContextHandler.LIVE_NS;
         if (var5 >= 0L && var5 < 250000000L) {
            var4.setReturnValue(false);
         }
      }
   }

   @Inject(
      method = {"updateRenderState(Lnet/minecraft/entity/PlayerLikeEntity;Lnet/minecraft/client/render/entity/state/PlayerEntityRenderState;F)V"},
      at = {@At("TAIL")}
   )
   private void b(PlayerLikeEntity var1, PlayerEntityRenderState var2, float var3, CallbackInfo var4) {
      if (ConfigBridge.c != null
         && ViewContextHandler.HIDE_VANILLA
         && var2.playerName != null
         && var1 instanceof PlayerEntity
         && var1 != MinecraftClient.getInstance().player) {
         long var5 = System.nanoTime() - ViewContextHandler.LIVE_NS;
         if (var5 >= 0L && var5 < 250000000L) {
            var2.playerName = null;
         }
      }
   }
}
