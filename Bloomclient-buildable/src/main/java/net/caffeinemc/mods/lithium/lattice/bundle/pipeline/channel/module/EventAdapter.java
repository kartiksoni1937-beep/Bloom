package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.module;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;
import java.util.Map.Entry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.CheckerAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.InitNotifier;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.NodeQueue;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.RenderKernel;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.UtilExtension;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.PacketContainer;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.SortableData;
import net.minecraft.client.gui.DrawContext;

public final class EventAdapter {
   private final HashMap<Class<? extends SortableData>, ArrayList<CacheBridge<? extends SortableData>>> k = new HashMap<>();
   private volatile HashMap<Class<? extends SortableData>, Object[]> l = new HashMap<>();
   public static volatile boolean m;
   private static InitAdapter[] n;

   public static <L extends SortableData, E extends PacketContainer<L>> void a(E var0) {

      EventAdapter var1 = ConfigBridge.c.b();
      if (var1 != null) {
         var1.c((E)var0);
      }
   }

   private <L extends SortableData, E extends PacketContainer<L>> void c(E var1) {

      if (var1 instanceof CheckerAdapter) {
         this.d();
      } else if (var1 instanceof RenderKernel) {
         this.e((RenderKernel)var1);
      } else {
         Class var2 = var1.a();
         InitAdapter[] var3 = b();
         Object[] var4 = this.l.get(var2);
         InitAdapter[] var5 = var3;
         Object[] var6 = var4;
         if (var3 == null) {
            if (var4 == null) {
               return;
            }

            var6 = var4;
         }

         for (Object var10 : var6) {
            CacheBridge var11 = (CacheBridge)var10;
            var1.a((L)var11.a);
            if (var5 != null) {
               break;
            }
         }
      }
   }

   private void d() {

      InitAdapter[] var1 = b();
      Object[] var2 = this.l.get(InitNotifier.class);
      if (var1 != null || var2 != null) {
         for (Object var6 : var2) {
            ((InitNotifier)((CacheBridge)var6).a).a();
            if (var1 != null) {
               break;
            }
         }
      }
   }

   private void e(RenderKernel var1) {

      InitAdapter[] var2 = b();
      Object[] var3 = this.l.get(UtilExtension.class);
      if (var2 != null || var3 != null) {
         if (var3.length != 0) {
            DrawContext var4 = var1.e();

            for (Object var8 : var3) {
               ((UtilExtension)((CacheBridge)var8).a).a(var4);
               if (var2 != null) {
                  break;
               }
            }
         }
      }
   }

   public <L extends SortableData> void a(Class<L> var1, L var2) {

      this.a(var1, var2, 0);
   }

   public synchronized <L extends SortableData> void a(Class<L> var1, L var2, int var3) {

      InitAdapter[] var4 = b();
      this.k.computeIfAbsent(var1, EventAdapter::i).add(new CacheBridge<>(var2, var3));
      this.k.get(var1).sort(Comparator.comparingInt(EventAdapter::h));
      this.f();
      if (var4 != null) {
         int var6 = InitAdapter.e();
         InitAdapter.b(++var6);
      }
   }

   public synchronized <L extends SortableData> void b(Class<L> var1, L var2) {

      label21: {
         InitAdapter[] var3 = b();
         ArrayList var4 = this.k.get(var1);
         ArrayList var6 = var4;
         if (var3 == null) {
            if (var4 == null) {
               break label21;
            }

            var6 = var4;
         }

         var6.removeIf(var1x -> {

            return g(var2, (CacheBridge)var1x);
         });
      }

      this.f();
      if (InitAdapter.e() == 0) {
         b(new InitAdapter[5]);
      }
   }

   private void f() {

      HashMap var1 = new HashMap();

      for (Entry var3 : this.k.entrySet()) {
         var1.put((Class)var3.getKey(), ((ArrayList)var3.getValue()).toArray());
      }

      this.l = var1;
      Object[] var4 = (Object[])var1.get(NodeQueue.class);
      m = var4 != null && var4.length > 0;
   }

   private static boolean g(SortableData var0, CacheBridge var1) {

      return Objects.equals(var1.a, var0);
   }

   private static int h(CacheBridge var0) {

      return var0.b;
   }

   private static ArrayList i(Class var0) {

      return new ArrayList<>();
   }

   public static void b(InitAdapter[] var0) {

      n = var0;
   }

   public static InitAdapter[] b() {
      return n;
   }

   static {
      if (b() != null) {
         b(new InitAdapter[1]);
      }
   }
}
