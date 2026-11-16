package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer;

import java.util.LinkedHashSet;
import java.util.Set;

public class BlockSetE extends TextEntry {
   public static final BlockSetE.Opt[] OPTIONS = new BlockSetE.Opt[]{
      new BlockSetE.Opt("Obsidian", "obsidian"),
      new BlockSetE.Opt("R" + "espawn" + " A" + "nchor", "respawn_anchor"),
      new BlockSetE.Opt("Glowstone", "glowst" + "o" + "ne")
   };

   public BlockSetE(String var1, String var2, int var3) {
      super(var1, var2, var3);
   }

   public Set<String> ids() {

      LinkedHashSet var1 = new LinkedHashSet();
      String var2 = this.f();
      if (var2 == null) {
         return var1;
      } else {
         for (String var6 : var2.split(",")) {
            String var7 = var6.trim().toLowerCase();
            if (var7.startsWith("minecraf" + "t:")) {
               var7 = var7.substring(10);
            }

            if (!var7.isEmpty()) {
               var1.add(var7);
            }
         }

         return var1;
      }
   }

   public void a(String var1) {

      Set var2 = this.ids();
      if (!var2.remove(var1)) {
         var2.add(var1);
      }

      this.b(String.join(",", var2));
   }

   public int b() {

      return this.ids().size();
   }

   public static final class Opt {
      public final String a;
      public final String id;
      private static int b = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

      public Opt(String var1, String var2) {
         this.a = var1;
         this.id = var2;
      }
   }
}
