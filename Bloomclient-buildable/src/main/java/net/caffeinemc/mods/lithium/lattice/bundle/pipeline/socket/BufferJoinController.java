package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket;

import java.util.List;
import net.caffeinemc.mods.lithium.lattice.bundle.overlay.element.UtilDelegate;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.CoreSerializer;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.InitNotifier;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.LinkerFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.ParserEngine;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.BlockCalculator;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.CheckerBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.ItemDescriptor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.InitExecutor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.TridentItem;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.item.MaceItem;
import net.minecraft.util.hit.HitResult;
public final class BufferJoinController extends BuilderFactory implements CoreSerializer, InitNotifier {
   private final CheckerBridge q;
   private final CheckerBridge r;
   private final BlockCalculator s;
   private final CheckerBridge t;
   private final CheckerBridge u;
   private boolean v;
   private int w;
   private int x;
   private static int y = -1;
   private static int z = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   public BufferJoinController() {
      super("", "", ParserEngine.CT);
      this.setName(new char[]{'㴉', '㵉', '㷳', '㷑', '㶫', '㷃', '㹖', '㹎', '㸴', '㸺', '㸓', '㺽', '㻴', '㺲', '㺎'}, 986922312, new char[0], 543023645);
      CheckerBridge var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'ꎨ', 'ꐷ', 'ꑝ', 'ꐦ', 'ꐃ', 'ꓼ', '꓆', '꒶', 'ꓒ', 'ꕂ', 'ꕇ', 'ꔠ', 'ꔜ', 'ꗩ'}, 257074170);
      this.q = var10001;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'\u2d9b', 'ⷉ', '\u2e71', '⹌', '⸰', '⸀', '⻪', '⺁', '⺂', '⺾', '⺝', '⽶'}, 1763192264);
      this.r = var10001;
      BlockCalculator var2 = new BlockCalculator("", 0.0, 5.0, 1.0, 1.0);
      var2.n(
         new char[]{'\ued31', '\uedaf', '\uedd7', '\uedd6', '\uedaa', '\ued9e', '\uee74', '\uee1b', '\uee1e', '\uee1c', '\ueef4', '\ueed6', '\ueeaf'},
         152694114
      );
      this.s = var2;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'䒋', '䓙', '䕿', '䕙', '䔱', '䔝', '䗦', '䖑', '䖃', '䖘', '䙯', '䙝'}, -1135524648);
      this.t = var10001;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'쑬', '쑬', '쐏', '쓬', '쓦', '쒞', '쒉', '쒓', '앯', '앟', '씴'}, 1364640803);
      this.u = var10001;
      this.w = -1;
      this.a(new InitAdapter[]{this.q, this.r, this.s, this.t, this.u});
   }

   @Override
   public void c() {

      this.b.a(CoreSerializer.class, this);
      this.b.a(InitNotifier.class, this);
      this.h_r51();
      super.c();
   }

   @Override
   public void d() {
      byte var1 = 0;

      label23:
      while (true) {
         switch (var1) {
            case 0:
            default:
               if (z != 0) {
                  Math.abs(Integer.MIN_VALUE);
                  var1 = 1;
                  break;
               }
            case 1:
               this.b.b(CoreSerializer.class, this);
               this.b.b(InitNotifier.class, this);
               if (this.v && this.w != -1 && a.player != null) {
                  InitExecutor.a(a.player.getInventory(), this.w);
                  var1 = 2;
                  break;
               }
            case 2:
               break label23;
         }
      }

      g_r111();
      super.d();
   }

   @Override
   public void a(LinkerFactory var1) {

      if (a.player != null && a.crosshairTarget != null && a.crosshairTarget.getType() == HitResult.Type.ENTITY) {
         Entity var2 = ((EntityHitResult)a.crosshairTarget).getEntity();
         if (var2 instanceof EndCrystalEntity) {
            return;
         }

         if (var2 != null) {
            if (this.u.f() && !a.player.getMainHandStack().isOf(Items.TOTEM_OF_UNDYING)) {
               return;
            }

            ItemStack var3 = a.player.getMainHandStack();
            Item var4 = var3.getItem();
            if (!this.i(var4)) {
               if (this.t.f()) {
                  this.f_r49();
                  return;
               }

               if (this.v) {
                  this.x = 0;
               } else {
                  int var5 = this.j(a.player.getInventory());
                  if (var5 == -1) {
                     return;
                  }

                  if (this.r.f() && this.w == -1) {
                     this.w = InitExecutor.a(a.player.getInventory());
                  }

                  InitExecutor.a(a.player.getInventory(), var5);
                  if (this.r.f()) {
                     this.v = true;
                     this.x = 0;
                  }
               }
            }
         }
      }
   }

   private void f_r49() {

      if (y == -1) {
         int var1 = this.j(a.player.getInventory());
         int var2 = InitExecutor.a(a.player.getInventory());
         if (var1 != -1 && var1 != var2) {
            y = var2;
            InitExecutor.a(a.player.getInventory(), var1);
         }
      }
   }

   public static void g_r111() {
      int var0 = 0;
      byte var1 = 0;

      while (true) {
         switch (var1) {
            case 0:
            default:
               if (z != 0) {
                  new Object().hashCode();
                  var1 = 1;
                  break;
               }
            case 1:
               var0 = y;
               if (var0 == -1) {
                  return;
               }
            case 2:
               y = -1;
               if (a.player != null) {
                  if (a.interactionManager == null) {
                     var1 = 3;
                  } else {
                     var1 = 4;
                  }
                  break;
               }
            case 3:
               return;
            case 4:
               InitExecutor.a(a.player.getInventory(), var0);
               ((UtilDelegate)a.interactionManager).iSSS();
               return;
         }
      }
   }

   @Override
   public void a() {

      if (y != -1) {
         g_r111();
      }

      if (a.player != null && this.v && this.w != -1) {
         if (this.x < this.s.g()) {
            this.x++;
         } else {
            InitExecutor.a(a.player.getInventory(), this.w);
            this.h_r51();
         }
      }
   }

   private void h_r51() {

      this.v = false;
      this.w = -1;
      this.x = 0;
   }

   private boolean i(Item var1) {

      return InitExecutor.a(var1) || var1 instanceof TridentItem || var1 instanceof MaceItem || InitExecutor.b(var1);
   }

   private int j(PlayerInventory var1) {

      int var2 = -1;

      for (int var3 = 0; var3 < 9; var3++) {
         Item var4 = var1.getStack(var3).getItem();
         if (InitExecutor.a(var4)) {
            return var3;
         }

         if (var2 == -1 && InitExecutor.b(var4)) {
            var2 = var3;
         }
      }

      return this.q.f() ? -1 : var2;
   }

   @Override
   public void e() {

      super.e();
   }

   @Override
   public boolean f() {

      return super.f;
   }

   public String g_r50() {

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
