package net.caffeinemc.mods.lithium.lattice.bundle.overlay.relay;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.NodeZoneRenderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({LivingEntity.class})
public class SwingAnimator {
   @Inject(
      method = {"getHandSwingDuration()I"},
      at = {@At("HEAD")},
      cancellable = true,
      require = 0
   )
   private void a(CallbackInfoReturnable<Integer> var1) {
      try {
         MinecraftClient var2 = MinecraftClient.getInstance();
         if (var2.player == null || var2.player != (Object)this) {
            return;
         }

         if (ConfigBridge.c == null || !NodeZoneRenderer.ON) {
            return;
         }

         NodeZoneRenderer var3 = NodeZoneRenderer.INSTANCE;
         if (var3 == null || !var3.g_r31() || !ConfigBridge.c.a()) {
            return;
         }

         int var4 = var3.h_r32();
         if (var4 == 6) {
            return;
         }

         var1.setReturnValue(var4);
      } catch (Throwable var5) {
      }
   }

   @Inject(
      method = {"handleStatus(B)V"},
      at = {@At("HEAD")},
      require = 0
   )
   private void b(byte var1, CallbackInfo var2) {
      if (var1 == 3 && ConfigBridge.c != null && NodeZoneRenderer.DEATH_ON) {
         try {
            LivingEntity var3 = (LivingEntity)(Object)this;
            if (var3.getEntityWorld().isClient() && ConfigBridge.c.a()) {
               NodeZoneRenderer.ed(var3);
            }
         } catch (Throwable var4) {
         }
      }
   }
}
