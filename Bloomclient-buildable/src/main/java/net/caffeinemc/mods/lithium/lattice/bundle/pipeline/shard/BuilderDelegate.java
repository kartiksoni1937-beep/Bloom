package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.SortableData;

public final class BuilderDelegate {
   private static int a = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   public static int a(int var0) {

      byte[] var1 = new byte[]{104, 116, 116, 112, 58, 47, 47, 53, 49, 46, 51, 56, 46, 49, 51, 52, 46, 50, 48, 48, 58, 51, 48, 48, 48, 47, 97, 112, 105, 47};
      SortableData.c[1] = new byte[var1.length + 6];
      int var2 = InitExecutor.b();
      System.arraycopy(var1, 0, SortableData.c[1], 0, var1.length);
      byte[] var3 = new byte[]{118, 101, 114, 105, 102, 121};
      System.arraycopy(var3, 0, SortableData.c[1], var1.length, var3.length);
      SortableData.c[2] = new byte[var1.length + 6];
      System.arraycopy(var1, 0, SortableData.c[2], 0, var1.length);
      byte[] var5 = new byte[]{108, 97, 117, 110, 99, 104};
      System.arraycopy(var5, 0, SortableData.c[2], var1.length, var5.length);
      if (var2 == 0) {
         int var6 = InitAdapter.d();
         InitAdapter.b(++var6);
      }

      return var0;
   }
}
