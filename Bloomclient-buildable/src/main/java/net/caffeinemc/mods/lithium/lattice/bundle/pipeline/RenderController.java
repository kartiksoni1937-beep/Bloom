package net.caffeinemc.mods.lithium.lattice.bundle.pipeline;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.fabricmc.api.ClientModInitializer;

public class RenderController implements ClientModInitializer {
   private static int[] a;

   public void onInitializeClient() {

      new ConfigBridge().onInitializeClient();
   }

   public static void b(int[] var0) {

      a = var0;
   }

   public static int[] b() {
      return a;
   }

   static {
      if (b() == null) {
         b(new int[3]);
      }
   }
}
