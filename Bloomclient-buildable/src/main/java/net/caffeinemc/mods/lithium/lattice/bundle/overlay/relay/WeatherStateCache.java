package net.caffeinemc.mods.lithium.lattice.bundle.overlay.relay;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.LerpZoneBuffer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({World.class})
public class WeatherStateCache {
   @Inject(
      method = {"getTimeOfDay()J"},
      at = {@At("RETURN")},
      cancellable = true,
      require = 0
   )
   private void a(CallbackInfoReturnable<Long> var1) {
      if ((Object)this instanceof ClientWorld) {
         try {
            long var2 = (Long)var1.getReturnValue();
            LerpZoneBuffer.REAL_DAY = var2;
            double var4 = LerpZoneBuffer.TIME_DAY;
            if (var4 >= 0.0) {
               var1.setReturnValue(Math.floorDiv(var2, 24000L) * 24000L + (long)var4);
            }
         } catch (Throwable var6) {
         }
      }
   }

   @Inject(
      method = {"getRainGradient(F)F"},
      at = {@At("RETURN")},
      cancellable = true,
      require = 0
   )
   private void b(float var1, CallbackInfoReturnable<Float> var2) {
      if ((Object)this instanceof ClientWorld) {
         try {
            LerpZoneBuffer.REAL_RAIN = (Float)var2.getReturnValue();
            float var3 = LerpZoneBuffer.RAIN_OVR;
            if (var3 >= 0.0F) {
               var2.setReturnValue(var3);
            }
         } catch (Throwable var4) {
         }
      }
   }

   @Inject(
      method = {"getThunderGradient(F)F"},
      at = {@At("RETURN")},
      cancellable = true,
      require = 0
   )
   private void c(float var1, CallbackInfoReturnable<Float> var2) {
      if ((Object)this instanceof ClientWorld) {
         try {
            LerpZoneBuffer.REAL_THUNDER = (Float)var2.getReturnValue();
            float var3 = LerpZoneBuffer.THUNDER_OVR;
            if (var3 >= 0.0F) {
               var2.setReturnValue(var3);
            }
         } catch (Throwable var4) {
         }
      }
   }
}
