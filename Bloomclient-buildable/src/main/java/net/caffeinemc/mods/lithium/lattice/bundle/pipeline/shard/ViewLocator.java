package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.client.MinecraftClient;

public class ViewLocator {
   private static final MinecraftClient b = MinecraftClient.getInstance();
   private static String d;
   private static int e = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   public static boolean a(Item var0) {

      if (b.player == null) {
         return false;
      } else {
         for (int var1 = 0; var1 < 9; var1++) {
            if (b.player.getInventory().getStack(var1).isOf(var0)) {
               InitExecutor.a(b.player.getInventory(), var1);
               return true;
            }
         }

         return false;
      }
   }

   public static void a(int var0) {

      if (b.player != null) {
         InitExecutor.a(b.player.getInventory(), var0);
      }
   }

   public static boolean a() {

      if (b.player == null) {
         return false;
      } else {
         for (int var0 = 0; var0 < 9; var0++) {
            if (InitExecutor.a(b.player.getInventory().getStack(var0).getItem())) {
               InitExecutor.a(b.player.getInventory(), var0);
               return true;
            }
         }

         return false;
      }
   }

   public static boolean b() {
      int var0 = 0;
      byte var1 = 0;

      while (true) {
         switch (var1) {
            case 0:
            default:
               if (e != 0) {
                  System.nanoTime();
                  var1 = 1;
                  break;
               }
            case 1:
               if (b.player == null) {
                  return false;
               }
            case 2:
               var0 = 0;
               var1 = 3;
               break;
            case 3:
               if (var0 >= 9) {
                  return false;
               }

               if (InitExecutor.b(b.player.getInventory().getStack(var0).getItem())) {
                  InitExecutor.a(b.player.getInventory(), var0);
                  return true;
               }
            case 4:
               var0++;
               var1 = 3;
               break;
            case 5:
               return false;
         }
      }
   }

   public static int b(Item var0) {

      if (b.player == null) {
         return 0;
      } else {
         int var1 = 0;

         for (int var2 = 0; var2 < b.player.getInventory().size(); var2++) {
            ItemStack var3 = b.player.getInventory().getStack(var2);
            if (var3.isOf(var0)) {
               var1 += var3.getCount();
            }
         }

         return var1;
      }
   }

   public static void b(String var0) {

      d = var0;
   }

   static {
      b("yO0WEb");
   }
}
