package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource;

import net.minecraft.client.gui.Click;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.entity.Entity;
public final class SlotZoneView extends InventoryScreen {

   public SlotZoneView(PlayerEntity var1) {
      super(var1);
   }

   protected void onMouseClick(Slot var1, int var2, int var3, SlotActionType var4) {
   }

   public boolean mouseClicked(Click var1, boolean var2) {

      return false;
   }
}
