package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex;

import java.util.HashSet;
import java.util.Set;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
public class BindingBridge {
   private final Set<String> b;
   private static int c = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   public BindingBridge() {
      String[] var1 = PacketContainer.d();
      this.b = new HashSet<>();
      if (var1 != null) {
         int var2 = InitAdapter.d();
         InitAdapter.b(++var2);
      }
   }

   public boolean c(String var1) {
      byte var2 = 0;

      while (true) {
         switch (var2) {
            case 0:
            default:
               if (c != 0) {
                  System.nanoTime();
                  var2 = 1;
                  break;
               }
            case 1:
               if (this.b.isEmpty()) {
                  return false;
               }

               return this.b.contains(var1.toLowerCase());
            case 2:
               return this.b.contains(var1.toLowerCase());
         }
      }
   }

   public boolean a(PlayerEntity var1) {
      byte var2 = 0;

      while (true) {
         switch (var2) {
            case 0:
            default:
               if (c != 0) {
                  Math.abs(Integer.MIN_VALUE);
                  var2 = 1;
                  break;
               }
            case 1:
               if (this.b.isEmpty()) {
                  return false;
               }

               return this.c(var1.getName().getString());
            case 2:
               return this.c(var1.getName().getString());
         }
      }
   }

   public boolean d() {

      return this.b.isEmpty();
   }
}
