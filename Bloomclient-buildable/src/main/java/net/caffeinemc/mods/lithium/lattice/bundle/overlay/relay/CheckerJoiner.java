package net.caffeinemc.mods.lithium.lattice.bundle.overlay.relay;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.EchoPassCache;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({EntityRenderer.class})
public class CheckerJoiner {
   @Unique
   private static int b;

   @Inject(
      method = {"shouldRender(Lnet/minecraft/entity/Entity;Lnet/minecraft/client/render/Frustum;DDD)Z"},
      at = {@At("HEAD")},
      cancellable = true,
      require = 0
   )
   private void a(Entity var1, Frustum var2, double var3, double var5, double var7, CallbackInfoReturnable<Boolean> var9) {
      if (ConfigBridge.c != null && b <= 30) {
         try {
            if (EchoPassCache.HIDE_N != 0 && EchoPassCache.aa && var1 instanceof LivingEntity) {
               if (((LivingEntity)var1).isDead() && !(var1 instanceof EnderDragonEntity)) {
                  if (ConfigBridge.c.a() && EchoPassCache.i(var1.getId())) {
                     var9.setReturnValue(false);
                  }

                  return;
               }

               return;
            }

            return;
         } catch (Throwable var11) {
            b++;
         }
      }
   }
}
