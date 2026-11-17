package net.caffeinemc.mods.lithium.lattice.bundle.overlay.element;

import net.minecraft.client.network.PendingUpdateManager;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={ClientWorld.class})
public interface PendingUpdateAccessor {
    @Accessor(value="pendingUpdateManager")
    public PendingUpdateManager getPendingUpdateManager();
}
