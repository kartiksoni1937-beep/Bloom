package com.blamejared.clumps;

import java.util.function.BiPredicate;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraft.entity.Entity;
public class ClumpsCommon {
   public static final Logger LOG = LogManager.getLogger("clumps");
   public static BiPredicate<PlayerEntity, ExperienceOrbEntity> pickupXPEvent = (var0, var1) -> false;
}
