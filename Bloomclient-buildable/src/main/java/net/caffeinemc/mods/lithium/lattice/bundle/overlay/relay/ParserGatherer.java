package net.caffeinemc.mods.lithium.lattice.bundle.overlay.relay;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.SyncDispatcher;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.LockD;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.NodeFilterCache;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.input.Input;
import net.minecraft.client.input.KeyboardInput;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.PlayerInput;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({ClientPlayerEntity.class})
public class ParserGatherer {
   @Inject(
      method = {"tickMovement()V"},
      at = {@At("HEAD")}
   )
   private void a(CallbackInfo var1) {
      if (ConfigBridge.c != null && LockD.g) {
         ClientPlayerEntity var2 = (ClientPlayerEntity)(Object)this;
         Input var3 = var2.input;
         if (var3 != null) {
            boolean var4 = false;

            try {
               SyncDispatcher var5;
               if (ConfigBridge.c.a() && (var5 = ConfigBridge.c.c()) != null) {
                  NodeFilterCache var6 = (NodeFilterCache)var5.a(NodeFilterCache.class);
                  var4 = var6 != null && var6.f();
               }
            } catch (Throwable var7) {
            }

            if (var4) {
               if (var3.getClass() != Input.class) {
                  var2.input = new Input();
               } else {
                  var3.playerInput = PlayerInput.DEFAULT;
               }
            } else if (var3.getClass() == Input.class) {
               var2.input = new KeyboardInput(MinecraftClient.getInstance().options);
            }
         }
      }
   }
}
