package net.caffeinemc.mods.lithium.lattice.bundle.overlay.relay;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.LerpZoneBuffer;
import net.minecraft.client.render.WeatherRendering;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome.Precipitation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({WeatherRendering.class})
public class PrecipitationCache {
   @Inject(
      method = {"getPrecipitationAt"},
      at = {@At("HEAD")},
      cancellable = true,
      require = 0
   )
   private void a(World var1, BlockPos var2, CallbackInfoReturnable<Precipitation> var3) {
      int var4 = LerpZoneBuffer.PRECIP;
      if (var4 == 1) {
         var3.setReturnValue(Precipitation.RAIN);
      } else if (var4 == 2) {
         var3.setReturnValue(Precipitation.SNOW);
      }
   }
}
