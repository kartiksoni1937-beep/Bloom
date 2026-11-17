package net.caffeinemc.mods.lithium.lattice.bundle.overlay.relay;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.LerpZoneBuffer;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.NodeZoneRenderer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.fog.FogRenderer;
import net.minecraft.client.world.ClientWorld;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({FogRenderer.class})
public class RenderShader {
   @Inject(
      method = {"getFogColor(Lnet/minecraft/client/render/Camera;FLnet/minecraft/client/world/ClientWorld;IF)Lorg/joml/Vector4f;"},
      at = {@At("RETURN")},
      cancellable = true,
      require = 0
   )
   private void a(Camera var1, float var2, ClientWorld var3, int var4, float var5, CallbackInfoReturnable<Vector4f> var6) {
      if (NodeZoneRenderer.SKY_HOT) {
         try {
            NodeZoneRenderer var7 = NodeZoneRenderer.INSTANCE;
            if (var7 == null) {
               return;
            }

            float var8 = var7.dh();
            if (var8 <= 0.002F) {
               return;
            }

            Vector4f var9 = (Vector4f)var6.getReturnValue();
            if (var9 == null) {
               return;
            }

            int var10 = var7.di();
            float var11 = (var10 >> 16 & 0xFF) / 255.0F;
            float var12 = (var10 >> 8 & 0xFF) / 255.0F;
            float var13 = (var10 & 0xFF) / 255.0F;
            float var14;
            float var15;
            float var16;
            if (var7.i_r33()) {
               var14 = var11;
               var15 = var12;
               var16 = var13;
            } else {
               var14 = var9.x * var11;
               var15 = var9.y * var12;
               var16 = var9.z * var13;
            }

            float var17 = var9.x + (var14 - var9.x) * var8;
            float var18 = var9.y + (var15 - var9.y) * var8;
            float var19 = var9.z + (var16 - var9.z) * var8;
            float var20 = Math.min(1.0F, LerpZoneBuffer.t() * 1.45F);
            var6.setReturnValue(new Vector4f(var17 + (var9.x - var17) * var20, var18 + (var9.y - var18) * var20, var19 + (var9.z - var19) * var20, var9.w));
         } catch (Throwable var21) {
         }
      }
   }
}
