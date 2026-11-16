package com.blamejared.clumps.api.events;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

public class ClumpsEvents {
   public static final Event<IEventHandler<ValueEvent, Void>> VALUE_EVENT = EventFactory.createArrayBacked(IEventHandler.class, var0 -> var1 -> {
         for (IEventHandler var5 : var0) {
            var5.handle(var1);
         }

         return null;
      });
   public static final Event<IEventHandler<RepairEvent, Void>> REPAIR_EVENT = EventFactory.createArrayBacked(IEventHandler.class, var0 -> var1 -> {
         for (IEventHandler var5 : var0) {
            var5.handle(var1);
         }

         return null;
      });
}
