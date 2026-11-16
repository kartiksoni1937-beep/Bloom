package com.blamejared.clumps.platform;

import com.blamejared.clumps.api.events.ClumpsEvents;
import com.blamejared.clumps.api.events.IEventHandler;
import com.blamejared.clumps.api.events.IRepairEvent;
import com.blamejared.clumps.api.events.IValueEvent;
import com.blamejared.clumps.api.events.RepairEvent;
import com.blamejared.clumps.api.events.ValueEvent;
import com.mojang.datafixers.util.Either;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
public class FabricEventHandler implements IEventHelper {
   @Override
   public Either<IValueEvent, Integer> fireValueEvent(PlayerEntity var1, int var2) {
      ValueEvent var3 = new ValueEvent(var1, var2);
      if (FabricLoader.getInstance().isModLoaded("fabric")) {
         ((IEventHandler)ClumpsEvents.VALUE_EVENT.invoker()).handle(var3);
      }

      return Either.right(var3.getValue());
   }

   @Override
   public Either<IRepairEvent, Integer> fireRepairEvent(PlayerEntity var1, int var2) {
      RepairEvent var3 = new RepairEvent(var1, var2);
      if (FabricLoader.getInstance().isModLoaded("fabric")) {
         ((IEventHandler)ClumpsEvents.REPAIR_EVENT.invoker()).handle(var3);
      }

      return Either.right(var3.getValue());
   }
}
