package net.caffeinemc.mods.lithium.lattice.bundle.overlay.relay;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.NodeZoneRenderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.world.dimension.DimensionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({DimensionType.class})
public class RenderLighting {
   @Inject(
      method = {"ambientLight()F"},
      at = {@At("RETURN")},
      cancellable = true,
      require = 0
   )
   private void a(CallbackInfoReturnable<Float> var1) {
      if (NodeZoneRenderer.FB_HOT) {
         try {
            if (!MinecraftClient.getInstance().isOnThread()) {
               return;
            }

            if (NodeZoneRenderer.FB_LIVE != 0L) {
               float var6 = NodeZoneRenderer.FB_AMB;
               if (var6 <= 0.0F) {
                  return;
               }

               Float var3 = (Float)var1.getReturnValue();
               float var4 = var3 != null ? var3 : 0.0F;
               var1.setReturnValue(var4 + (1.0F - var4) * Math.min(1.0F, var6));
               return;
            }

            if (ConfigBridge.c != null && ConfigBridge.c.a()) {
               NodeZoneRenderer var2 = NodeZoneRenderer.INSTANCE;
               if (var2 != null && NodeZoneRenderer.ON && var2.j_r34()) {
                  var1.setReturnValue(1.0F);
                  return;
               }

               return;
            }

            return;
         } catch (Throwable var5) {
         }
      }
   }
}
