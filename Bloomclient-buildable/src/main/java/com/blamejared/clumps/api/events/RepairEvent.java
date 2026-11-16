package com.blamejared.clumps.api.events;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
public class RepairEvent implements IValueEvent {
   private final PlayerEntity player;
   private int value;

   public RepairEvent(PlayerEntity var1, int var2) {
      this.player = var1;
      this.value = var2;
   }

   @Override
   public void setValue(int var1) {
      this.value = var1;
   }

   @Override
   public int getValue() {
      return this.value;
   }

   @Override
   public PlayerEntity getPlayer() {
      return this.player;
   }
}
