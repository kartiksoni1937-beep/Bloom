package com.blamejared.clumps.platform;

import com.blamejared.clumps.ClumpsCommon;
import java.util.ServiceLoader;

public class Services {
   public static final IEventHelper EVENT = load(IEventHelper.class);
   public static final IPlatformHelper PLATFORM = load(IPlatformHelper.class);

   public static <T> T load(Class<T> var0) {
      Object var1 = ServiceLoader.load(var0).findFirst().orElseThrow(() -> new NullPointerException("Failed to load service for " + var0.getName()));
      ClumpsCommon.LOG.debug("Loaded {} for service {}", var1, var0);
      return (T)var1;
   }
}
