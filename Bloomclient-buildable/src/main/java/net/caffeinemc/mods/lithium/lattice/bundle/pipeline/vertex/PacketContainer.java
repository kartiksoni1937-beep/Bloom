package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex;

public abstract class PacketContainer<L extends SortableData> {
   private boolean c = false;
   private static String[] d;

   public abstract Class<L> a();

   public abstract void a(L var1);

   public void b() {

      this.c = true;
   }

   public boolean c() {

      return this.c;
   }

   public static void b(String[] var0) {

      d = var0;
   }

   public static String[] d() {
      return d;
   }

   static {
      if (d() != null) {
         b(new String[2]);
      }
   }
}
