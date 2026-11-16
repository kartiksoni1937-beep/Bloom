package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket;

import net.caffeinemc.mods.lithium.lattice.bundle.overlay.element.PacketBinder;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.InitNotifier;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.ParserEngine;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.BlockSetE;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.SpanEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.BufferNormalizer;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.FrameClockCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.DataCZ;
import net.minecraft.item.BlockItem;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;

public final class RenderCacheView extends BuilderFactory implements InitNotifier {
   private static final long h = 100000000L;
   private static final int i = 3;
   private final SpanEntry j;
   private final BlockSetE l;
   private boolean n;
   private long o;
   private BlockItem p;
   private String q;
   private boolean r;
   private DataCZ s;
   private final Runnable t;
   private static int u = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   public RenderCacheView() {
      super("", "", ParserEngine.Z4);
      this.setName(
         new char[]{'끦', '뀑', '뀿', '뀎', '냨', '낛', '낊', '낕', '녹', '녔', '넳'},
         992915488,
         new char[]{
            '䎽',
            '䐢',
            '䑇',
            '䐫',
            '䐊',
            '䓭',
            '䒇',
            '䒤',
            '䒉',
            '䕫',
            '䕀',
            '䔩',
            '䔒',
            '䖠',
            '䗹',
            '䗟',
            '䖮',
            '䖈',
            '䙾',
            '䙈',
            '䙹',
            '䙐',
            '䛸',
            '䛆',
            '䚡',
            '䚝',
            '䝼',
            '䝜',
            '䜰',
            '䜜',
            '䟣',
            '䟗',
            '䟭',
            '䞃',
            '䡥',
            '䡆',
            '䠰',
            '䡈',
            '䣤',
            '䣃',
            '䢷',
            '䢐',
            '䥢',
            '䥋',
            '䤯',
            '䥀',
            '䤝',
            '䧲',
            '䧒',
            '䦿',
            '䦐',
            '䩩',
            '䨐'
         },
         -1227471891
      );
      SpanEntry var10001 = new SpanEntry("", 0.0, 200.0, 50.0, 50.0, 1.0, 50.0, 50.0);
      var10001.n(new char[]{'\uf609', '\uf642', '\uf6ee', '\uf6c6', '\uf6a8', '\uf691'}, -1845037491);
      this.j = var10001;
      BlockSetE var1 = new BlockSetE("", "", 256);
      var1.n(new char[]{'馉', '駄', '驥', '驇', '騤', '騍', '髶'}, 53713355);
      this.l = var1;
      this.t = this::f_r120;
      this.a(new InitAdapter[]{this.j, this.l});
   }

   private boolean a(BlockItem var1) {

      String var2 = this.l.f();
      if (var2 != null && !var2.trim().isEmpty()) {
         Identifier var3 = null;

         try {
            var3 = Registries.BLOCK.getId(var1.getBlock());
            String var4 = var3.getPath();
            String var5 = var3.toString();

            for (String var9 : var2.toLowerCase().split(",")) {
               String var10 = var9.trim();
               if (!var10.isEmpty() && (var10.equals(var4) || var10.equals(var5))) {
                  return true;
               }
            }
         } catch (Throwable var11) {
         }

         return false;
      } else {
         return true;
      }
   }

   private boolean c(BlockItem var1) {

      String var2 = this.l.f();
      if (var1 != this.p || var2 != this.q) {
         this.r = this.a(var1);
         this.p = var1;
         this.q = var2;
      }

      return this.r;
   }

   private boolean d_r77() {

      if (a.player != null
         && a.world != null
         && a.interactionManager != null
         && a.currentScreen == null
         && a.options.useKey.isPressed()
         && !a.player.isUsingItem()) {
         if (a.player.getMainHandStack().getItem() instanceof BlockItem var1 && this.c(var1)) {
            return true;
         }

         return false;
      } else {
         return false;
      }
   }

   private boolean e_r119() {

      DataCZ var1 = this.s;
      if (var1 == null) {
         if (ConfigBridge.c == null || ConfigBridge.c.c() == null || (var1 = ConfigBridge.c.c().a(DataCZ.class)) == null) {
            return false;
         }

         this.s = var1;
      }

      return var1.f && var1.p();
   }

   @Override
   public void c() {

      this.b.a(InitNotifier.class, this);
      this.n = false;
      FrameClockCache.a(this.t);
      super.c();
   }

   @Override
   public void d() {

      this.b.b(InitNotifier.class, this);
      FrameClockCache.b(this.t);
      this.n = false;
      super.d();
   }

   @Override
   public void a() {

      if (!this.d_r77() || this.e_r119()) {
         this.n = false;
      } else if (this.n) {
         ((PacketBinder)a).sIUC(4);
         if (System.nanoTime() - this.o >= 0L) {
            this.g(1.0F);
         }
      } else if (!BufferNormalizer.a(1)) {
         ((PacketBinder)a).sIUC(0);
         this.n = true;
         this.o = System.nanoTime() + this.j.b();
      }
   }

   private void f_r120() {
      byte var1 = 0;

      while (true) {
         switch (var1) {
            case 0:
            default:
               if (u != 0) {
                  new Object().hashCode();
                  var1 = 1;
                  break;
               }
            case 1:
               if (this.n && System.nanoTime() - this.o >= 0L) {
                  this.g(a.getRenderTickCounter().getTickProgress(true));
                  var1 = 2;
                  break;
               }

               return;
            case 2:
               return;
         }
      }
   }

   private void g(float var1) {

      if (this.e_r119()) {
         this.n = false;
      } else if (FrameClockCache.n) {
         long var2 = System.nanoTime();
         if (var2 - this.o > 100000000L) {
            this.o = var2;
         }

         if (FrameClockCache.k(a.player)) {
            this.o = var2;
         } else {
            int var4 = 0;

            while (var4 < 3 && var2 - this.o >= 0L) {
               if (!this.d_r77()) {
                  this.n = false;
                  return;
               }

               Boolean var5 = BufferNormalizer.b.get(1);
               if (!a.player.isRiding() && !a.interactionManager.isBreakingBlock() && (var5 == null || !var5)) {
                  a.gameRenderer.updateCrosshairTarget(var1);
                  HitResult var6 = a.crosshairTarget;
                  if (var6 != null && var6.getType() == HitResult.Type.BLOCK) {
                     ((PacketBinder)a).dIU();
                     this.o = this.o + this.j.b();
                     var4++;
                     continue;
                  }

                  this.o = var2 - 100000000L - 1L;
                  return;
               }

               this.o = var2 - 100000000L - 1L;
               return;
            }
         }
      }
   }
}
