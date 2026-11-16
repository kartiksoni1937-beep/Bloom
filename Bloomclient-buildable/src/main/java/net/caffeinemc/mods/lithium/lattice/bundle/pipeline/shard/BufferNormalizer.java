package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import net.caffeinemc.mods.lithium.lattice.bundle.overlay.element.PacketBinder;
import net.caffeinemc.mods.lithium.lattice.bundle.overlay.element.SortableComposer;
import net.minecraft.client.input.MouseInput;
import net.minecraft.client.MinecraftClient;

public class BufferNormalizer {
   private static final MinecraftClient h = MinecraftClient.getInstance();
   public static HashMap<Integer, Boolean> b = new HashMap<>();
   public static ExecutorService c = Executors.newCachedThreadPool();
   private static int i = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   public static SortableComposer a() {

      return (SortableComposer)((PacketBinder)h).Z7();
   }

   public static boolean a(int var0) {

      int var1 = InitExecutor.c();
      Boolean var2 = b.get(var0);
      Boolean var4 = var2;
      if (var1 == 0) {
         if (var2 == null) {
            return false;
         }

         var4 = var2;
      }

      return var4;
   }

   public static void b(int var0) {

      b.put(var0, true);
      a().iOMB(h.getWindow().getHandle(), new MouseInput(var0, 0), 1);
   }

   public static void c(int var0) {

      a().iOMB(h.getWindow().getHandle(), new MouseInput(var0, 0), 0);
   }

   public static void a(int var0, int var1) {

      if (h.isOnThread()) {
         try {
            b(var0);
         } catch (Throwable var3) {
         }
      } else {
         h.execute(() -> {

            b(var0);
         });
      }

      c.submit(() -> {

         b(var0, var1);
      });
   }

   public static void d(int var0) {
      byte var1 = 0;

      label16:
      while (true) {
         switch (var1) {
            case 0:
            default:
               if (i != 0) {
                  new Object().hashCode();
                  var1 = 1;
                  break;
               }
            case 1:
               if (a(var0)) {
                  return;
               }
            case 2:
               break label16;
         }
      }

      a(var0, 35);
   }

   private static void b(int var0, int var1) {

      try {
         Thread.sleep((long)var1);
      } catch (InterruptedException var3) {
         return;
      }

      h.execute(() -> {

         c(var0);
      });
   }
}
