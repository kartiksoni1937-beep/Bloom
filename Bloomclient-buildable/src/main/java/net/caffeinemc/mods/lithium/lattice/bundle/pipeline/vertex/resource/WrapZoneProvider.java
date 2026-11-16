package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource;

import java.util.List;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.CoreSerializer;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.InitNotifier;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.LinkerFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.UtilExtension;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.ParserEngine;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.CheckerBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.ItemDescriptor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.SlotEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.TimingEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.FrameClockCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.GridResolver;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.InitExecutor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.SlotInspector;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.ViewLocator;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.component.DataComponentTypes;
import org.lwjgl.glfw.GLFW;
import net.minecraft.entity.Entity;
public final class WrapZoneProvider extends BuilderFactory implements InitNotifier, CoreSerializer, UtilExtension {
   private static final String[] h = new String[]{"A.lways", "O.n Key P" + "ress"};
   private static final int i = 1;
   private static final int j = 5;
   private final TimingEntry q;
   private final TimingEntry r;
   private final CheckerBridge t;
   private final CheckerBridge w;
   private final CheckerBridge x;
   private final SlotEntry y;
   private final ItemDescriptor z;
   private int aa;
   private Object ab;
   private int ac;
   private long ad;
   private long ae;
   private boolean af;
   private final Runnable ag;
   private boolean ah;
   private boolean ai;
   private boolean aj;
   private boolean ak;
   private int al;
   private int am;
   private int an;
   private int ao;
   private static int ap = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   public WrapZoneProvider() {
      super("", "", ParserEngine.CT);
      this.setName(new char[]{'ፙ', 'ጇ', 'ጠ', 'ጎ', 'Ꮳ', 'Ꮙ', 'Ꭰ', 'Ꭷ', 'ᑫ', 'ᑒ', 'ᐡ', 'ᐽ', 'ᐒ', 'ᓸ', 'ᓎ'}, 1230902026, new char[0], -309942119);
      this.aa = -1;
      this.af = false;
      this.ag = this::b;
      this.am = Integer.MIN_VALUE;
      this.an = -1;
      TimingEntry var10001 = new TimingEntry("", 0.0, 1000.0, 0.0, 1.0);
      var10001.n(new char[]{'\ue433', '\ue4b4', '\ue4d0', '\ue4ac', '\ue4b3', '\ue573', '\ue559', '\ue535', '\ue50a'}, 90039419);
      this.q = var10001;
      var10001 = new TimingEntry("", 0.0, 1000.0, 0.0, 1.0);
      var10001.n(new char[]{'\uf644', '\uf618', '\uf622', '\uf61d', '\uf6e7', '\uf6d1', '\uf6b9', '\uf6b4', '\uf76a', '\uf742', '\uf72c', '\uf715'}, 960230935);
      this.r = var10001;
      CheckerBridge var2 = new CheckerBridge("", true);
      var2.n(new char[]{'砺', '碦', '磐', '碯', '碑', '祧', '祋', '礀', '礀', '秣', '秴'}, -2132903831);
      this.t = var2;
      CheckerBridge var3 = new CheckerBridge("", false);
      var3.n(new char[]{'ﮃ', '﯁', 'ﱺ', 'ﱘ', 'ﰢ'}, -1013187632);
      this.w = var3;
      CheckerBridge var4 = new CheckerBridge("", false);
      var4.n(new char[]{'뮪', '밹', '뱓', '밤', '밁', '볺', '변', '벴', '벸', '뵠', '뵂', '봩', '봭', '뷳', '뷏'}, 2106637304);
      this.x = var4;
      this.y = new SlotEntry("A.ctiv" + "ati" + "on", h[0], h);
      ItemDescriptor var5 = new ItemDescriptor("", -1, false);
      var5.n(new char[]{'祩', '祩', '礅', '秱', '种', '禵', '禃', '穵', '穅', '稟', '稕', '稘', '童'}, 254769448);
      this.z = var5;
      this.a(this.q, this.r, this.t, this.w, this.x, this.y, this.z);
   }

   @Override
   public void c() {

      this.b.a(InitNotifier.class, this);
      this.b.a(CoreSerializer.class, this);
      this.b.a(UtilExtension.class, this);
      this.ac = 0;
      this.aa = -1;
      this.ab = null;
      this.ak = false;
      this.al = 0;
      this.aj = false;
      this.am = -1965392637 ^ 182091011;
      this.an = -1;
      int var1 = this.z.d;
      this.ai = var1 != -1 && SlotInspector.a(var1);
      this.ah = g(this.y) == 1;
      FrameClockCache.add(this.ag);
      super.c();
   }

   @Override
   public void d() {
      byte var1 = 0;

      label32:
      while (true) {
         switch (var1) {
            case 0:
            default:
               if (ap != 0) {
                  new Object().hashCode();
                  var1 = 1;
                  break;
               }
            case 1:
               this.b.b(InitNotifier.class, this);
               this.b.b(CoreSerializer.class, this);
               this.b.b(UtilExtension.class, this);
               FrameClockCache.b(this.ag);
               if (a.player != null
                  && this.aa != -1
                  && this.ab == a.player
                  && this.t.f()
                  && !f(a.player.age)
                  && FrameClockCache.i(a.player)) {
                  ViewLocator.a(this.aa);
                  var1 = 2;
                  break;
               }
            case 2:
               break label32;
         }
      }

      this.aa = -1;
      this.ab = null;
      this.ac = 0;
      this.ak = false;
      super.d();
   }

   @Override
   public void a() {

      boolean var1 = g(this.y) == 1;
      if (var1) {
         int var2 = this.z.d;
         boolean var3 = var2 != -1 && SlotInspector.a(var2);
         if (var3 && !this.ai && this.ah && a.currentScreen == null) {
            this.aj = true;
         }

         this.ai = var3;
         this.ah = true;
         if (this.aj) {
            this.aj = false;
            if (!this.ak) {
               this.ac = 0;
            }

            this.ak = true;
            this.al = 5;
         }

         if (!this.ak && this.aa == -1) {
            return;
         }
      } else {
         this.ah = false;
         this.ak = false;
         this.aj = false;
      }

      if (a.player != null && a.world != null) {
         if (this.aa != -1 && this.ab != a.player) {
            this.aa = -1;
            this.ab = null;
            this.ac = 0;
         }

         int var7 = a.player.age;
         if (InitExecutor.r != var7 && (InitExecutor.m != 2 || InitExecutor.n != a.player)) {
            PlayerEntity var8 = null;
            if (a.currentScreen == null
               && (!this.x.f() || a.player.getMainHandStack().getItem() instanceof AxeItem)
               && a.crosshairTarget instanceof EntityHitResult var4
               && !a.player.isUsingItem()
               && var4.getEntity() instanceof PlayerEntity var5) {
               var8 = var5;
            }

            boolean var9 = var8 != null && e(var8);
            if (!var1 || this.ak) {
               if (var9) {
                  this.c(var8, var7, var1);
                  return;
               }

               if (var1) {
                  if (--this.al > 0) {
                     return;
                  }

                  this.ak = false;
               }
            }

            if (this.aa != -1 && (var1 || var8 != null)) {
               if (!this.t.f()) {
                  this.aa = -1;
                  this.ab = null;
                  this.ac = 0;
               } else if (!f(var7) && a.currentScreen == null) {
                  if (!FrameClockCache.i(a.player)) {
                     FrameClockCache.j(a.player);
                  } else {
                     ViewLocator.a(this.aa);
                     this.aa = -1;
                     this.ab = null;
                     this.ac = 0;
                  }
               }
            }
         } else {
            this.ak = false;
         }
      } else {
         this.ak = false;
         this.aa = -1;
         this.ab = null;
         this.ac = 0;
      }
   }

   private void b() {

      if (this.ac != 0 && System.nanoTime() - this.ad >= 0L) {
         boolean var1 = g(this.y) == 1;
         if (var1 == this.ah && (!var1 || this.ak)) {
            if (a.player != null && a.world != null && a.interactionManager != null && this.aa != -1 && this.ab == a.player) {
               int var2 = a.player.age;
               if ((!InitExecutor.u || a.player.isOnGround() || a.player.isTouchingWater())
                  && InitExecutor.r != var2
                  && InitExecutor.r != var2 - 1
                  && (InitExecutor.m != 2 || InitExecutor.n != a.player)
                  && InitExecutor.p != var2 - 1
                  && !InitExecutor.v) {
                  PlayerEntity var3 = null;
                  if (a.currentScreen == null
                     && (!this.x.f() || a.player.getMainHandStack().getItem() instanceof AxeItem)
                     && a.crosshairTarget instanceof EntityHitResult var4
                     && !a.player.isUsingItem()
                     && var4.getEntity() instanceof PlayerEntity var5) {
                     var3 = var5;
                  }

                  if (var3 != null && e(var3)) {
                     this.c(var3, var2, var1);
                  }
               }
            }
         }
      }
   }

   private void c(PlayerEntity var1, int var2, boolean var3) {

      if (!this.d(var1, var2)) {
         boolean var4 = this.q.p() > 0.0 || this.r.p() > 0.0;
         boolean var5 = a.player.getMainHandStack().getItem() instanceof AxeItem;
         if (var4 || !InitExecutor.u || a.player.isOnGround() || a.player.isTouchingWater() || var1.isBlocking() || var5) {
            if (this.aa == -1) {
               this.aa = InitExecutor.a(a.player.getInventory());
               this.ab = a.player;
               this.ac = 0;
            }

            if (this.ac == 0) {
               this.ad = FrameClockCache.g(this.r.p());
               this.ae = this.q.ns();
               this.ac = 1;
            }

            if (System.nanoTime() - this.ad >= 0L) {
               if (!var5) {
                  if (f(var2)) {
                     return;
                  }

                  if (!FrameClockCache.i(a.player)) {
                     for (int var6 = 0; var6 < 9; var6++) {
                        if (InitExecutor.b(a.player.getInventory().getStack(var6).getItem())) {
                           FrameClockCache.j(a.player);
                           return;
                        }
                     }
                  }

                  if (!ViewLocator.b()) {
                     if (var3) {
                        this.ak = false;
                     }

                     return;
                  }

                  this.ac = 2;
                  this.ad = System.nanoTime() + this.ae;
                  if (this.ae > 0L) {
                     return;
                  }
               } else if (this.ac == 1) {
                  this.ac = 2;
                  this.ad = System.nanoTime() + this.ae;
                  if (this.ae > 0L) {
                     return;
                  }
               }

               if (var1.isBlocking() && InitExecutor.p != var2) {
                  boolean var7 = InitExecutor.d(var1, a.player, 0) == 3;
                  if (FrameClockCache.n) {
                     this.af = true;
                     GridResolver.a(var1, true);
                     if (this.w.f()) {
                        GridResolver.a(var1, true);
                     }

                     this.af = false;
                     if (var7) {
                        InitExecutor.e(var1, a.player);
                     }

                     this.an = var1.getId();
                     this.ao = var2;
                     this.am = var2;
                     InitExecutor.p = var2;
                     this.ac = 0;
                     if (var3) {
                        this.ak = false;
                     }
                  }
               }
            }
         }
      }
   }

   @Override
   public void a(LinkerFactory var1) {

      if (a.player != null) {
         if (this.am == a.player.age) {
            var1.b();
            return;
         }

         if (!var1.c()
            && a.player.getMainHandStack().getItem() instanceof AxeItem
            && a.crosshairTarget instanceof EntityHitResult var2
            && var2.getEntity() instanceof PlayerEntity var3
            && var3.isBlocking()) {
            this.an = var3.getId();
            this.ao = a.player.age;
            return;
         }
      }

      if (!this.ah || this.ak) {
         if ((a.player == null || !(a.player.getMainHandStack().getItem() instanceof AxeItem))
            && !this.af
            && a.getWindow() != null
            && a.crosshairTarget instanceof EntityHitResult var6
            && var6.getEntity() instanceof PlayerEntity var7
            && var7.isBlocking()) {
            long var11 = a.getWindow().getHandle();
            if (GLFW.glfwGetMouseButton(var11, 0) != 1) {
               var1.b();
            }
         }
      }
   }

   private boolean d(PlayerEntity var1, int var2) {

      int var3 = var2 - this.ao;
      return this.an == var1.getId() && var3 >= 0 && var3 <= InitExecutor.lag(a, true) + 3 ? true : InitExecutor.f(var1, a.player);
   }

   @Override
   public void a(DrawContext var1) {

      if (this.ah) {
         int var2 = this.z.d;
         if (var2 != -1) {
            boolean var3 = SlotInspector.a(var2);
            if (var3 && !this.ai && a.currentScreen == null) {
               this.aj = true;
            }

            this.ai = var3;
         }
      }
   }

   private static boolean e(PlayerEntity var0) {

      return var0.isUsingItem() && var0.getActiveItem().contains(DataComponentTypes.BLOCKS_ATTACKS);
   }

   private static boolean f(int var0) {

      return InitExecutor.o == var0 || InitExecutor.p == var0 || a.player.handSwinging && a.player.handSwingTicks < 0;
   }

   private static int g(SlotEntry var0) {

      int var1 = var0.g().indexOf(var0.f());
      return var1 < 0 ? 0 : var1;
   }

   @Override
   public void e() {

      super.e();
   }

   @Override
   public boolean f() {

      return super.f;
   }

   @Override
   public String g() {

      return super.g();
   }

   @Override
   public String h() {

      return super.h();
   }

   @Override
   public ParserEngine i() {

      return super.i();
   }

   @Override
   public int j() {

      return super.j();
   }

   @Override
   public List<InitAdapter> k() {

      return super.k();
   }

   @Override
   public ItemDescriptor l() {

      return super.l();
   }

   @Override
   public void a(boolean var1) {

      super.a(var1);
   }

   @Override
   public void a(int var1) {

      super.a(var1);
   }
}
