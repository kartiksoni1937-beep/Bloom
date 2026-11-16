package com.blamejared.clumps.platform;

import com.blamejared.clumps.api.events.IRepairEvent;
import com.blamejared.clumps.api.events.IValueEvent;
import com.mojang.datafixers.util.Either;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
public interface IEventHelper {
   Either<IValueEvent, Integer> fireValueEvent(PlayerEntity var1, int var2);

   Either<IRepairEvent, Integer> fireRepairEvent(PlayerEntity var1, int var2);
}
