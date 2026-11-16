package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource;

import java.util.List;
import net.caffeinemc.mods.lithium.lattice.bundle.overlay.element.BindingAccessor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.InitNotifier;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.ParserEngine;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.BlockCalculator;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.CheckerBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.ItemDescriptor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.InitExecutor;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.item.Items;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;

public final class PoolZoneAllocator extends BuilderFactory implements InitNotifier {
   private final BlockCalculator c;
   private final CheckerBridge d;
   private final BlockCalculator e;
   private final CheckerBridge f;
   private final CheckerBridge g;
   private final CheckerBridge h;
   private int i;
   private boolean j;
   private float u;
   private boolean v;

   public PoolZoneAllocator() {
      super("", "", ParserEngine.CT);
      this.setName(new char[]{'矒', '瞗', '瞷', '瞁', '硳', '硇', '硴', '砧', '磽', '磅', '碵', '碂'}, 1705605018, new char[0], 307196311);
      BlockCalculator var10001 = new BlockCalculator("", 0.0, 20.0, 0.0, 1.0);
      var10001.n(new char[]{'탉', '킂', '킮', '킆', '텨', '텑'}, 621531277);
      this.c = var10001;
      CheckerBridge var1 = new CheckerBridge("", true);
      var1.n(new char[]{'´', 'ĵ', 'ŕ', 'ĭ', 'Ě', 'Ƕ', 'Ǆ'}, -1515519748);
      this.d = var1;
      var10001 = new BlockCalculator("", 1.0, 9.0, 1.0, 1.0);
      var10001.n(new char[]{'̹', '\u03a2', 'τ', 'ξ', 'Ό', 'ѥ', 'Ї', 'Е', 'Љ', 'ӫ', 'ӗ'}, -1478884499);
      this.e = var10001;
      CheckerBridge var3 = new CheckerBridge("", false);
      var3.n(new char[]{'⃯', '⃣', 'ₙ', 'ⅿ', 'ⅅ', 'Ⅹ', '℻', '⇰', '⇏', '↱', 'ↇ', '≫'}, 1353130158);
      this.f = var3;
      CheckerBridge var4 = new CheckerBridge("", false);
      var4.n(new char[]{'ു', 'ഃ', 'ഢ', 'ഇ', 'ෳ', 'ඉ', 'ඇ', 'ඉ', 'ศ', 'ฅ', 'ด', 'ฌ', '\u0ef2'}, 504368398);
      this.g = var4;
      CheckerBridge var5 = new CheckerBridge("", false);
      var5.n(new char[]{'ಽ', 'വ', '൏', 'ഭ', 'ഗ', 'භ', '\u0dff', 'ර', 'ං', '\u0e76', '\u0e5c', 'ล', 'ฟ', '\u0efd', '໗'}, 739314940);
      this.h = var5;
      this.j = false;
      this.u = -1.0F;
      this.v = false;
      this.a(new InitAdapter[]{this.c, this.d, this.e, this.f, this.g, this.h});
   }

   @Override
   public void c() {

      this.b.a(InitNotifier.class, this);
      this.i = 0;
      this.j = false;
      this.u = -1.0F;
      this.v = false;
      super.c();
   }

   @Override
   public void d() {

      this.b.b(InitNotifier.class, this);
      super.d();
   }

   @Override
   public void a() {

      if (a.player != null) {
         float var1 = a.player.getHealth();
         if (this.u > 0.0F && this.u <= 2.0F && var1 > this.u + 5.0F) {
            this.j = true;
         }

         this.u = var1;
         if (!this.g.f() || this.j) {
            if (this.h.f() && a.currentScreen == null) {
               boolean var2 = this.d.f()
                  ? a.player.getInventory().getStack(this.e.g() - 1).getItem() != Items.TOTEM_OF_UNDYING
                  : !a.player.getOffHandStack().isOf(Items.TOTEM_OF_UNDYING);
               if (var2 && this.a_r35()) {
                  a.setScreen(new InventoryScreen(a.player));
                  this.v = true;
                  return;
               }
            }

            if (a.currentScreen instanceof InventoryScreen var6) {
               if (!((PlayerScreenHandler)var6.getScreenHandler()).getCursorStack().isEmpty()) {
                  return;
               }

               Slot var7 = this.b(var6);
               if (this.f.f()) {
                  InitExecutor.a(a.player.getInventory(), this.e.g() - 1);
               }

               if (var7 != null) {
                  if (var7.inventory != a.player.getInventory() || var7.getIndex() > 35) {
                     return;
                  }

                  int var4 = var7.id;
                  int var5 = this.e.g() - 1;
                  if (var7.getStack().getItem() == Items.TOTEM_OF_UNDYING) {
                     if (this.d.f() && a.player.getInventory().getStack(var5).getItem() != Items.TOTEM_OF_UNDYING) {
                        if (this.i > 0) {
                           this.i--;
                           return;
                        }

                        a.interactionManager.clickSlot(((PlayerScreenHandler)var6.getScreenHandler()).syncId, var4, var5, SlotActionType.SWAP, a.player);
                        this.i = this.c.g();
                        this.j = false;
                        if (this.v) {
                           a.player.closeHandledScreen();
                           this.v = false;
                        }
                     } else if (!a.player.getOffHandStack().isOf(Items.TOTEM_OF_UNDYING)) {
                        if (this.i > 0) {
                           this.i--;
                           return;
                        }

                        a.interactionManager.clickSlot(((PlayerScreenHandler)var6.getScreenHandler()).syncId, var4, 40, SlotActionType.SWAP, a.player);
                        this.i = this.c.g();
                        this.j = false;
                        if (this.v) {
                           a.player.closeHandledScreen();
                           this.v = false;
                        }
                     }
                  }
               }
            } else {
               this.i = this.c.g();
            }
         }
      }
   }

   private boolean a_r35() {

      if (a.player == null) {
         return false;
      } else {
         for (int var1 = 0; var1 < 36; var1++) {
            if (a.player.getInventory().getStack(var1).isOf(Items.TOTEM_OF_UNDYING)) {
               return true;
            }
         }

         return false;
      }
   }

   private Slot b(InventoryScreen var1) {

      try {
         return ((BindingAccessor)var1).Z8();
      } catch (Exception var3) {
         return null;
      }
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
