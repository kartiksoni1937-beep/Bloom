package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.InitNotifier;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.ParserEngine;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.BlockCalculator;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.CheckerBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.ItemDescriptor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.MaskEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.TimingEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.CalculateMapper;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.FrameClockCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.SlotInspector;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.ViewLocator;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.entity.Entity;
public final class BlockCacheController extends BuilderFactory implements InitNotifier {
   private static final long h = 68719476224L;
   private final BlockCalculator i;
   private final BlockCalculator j;
   private final CheckerBridge q;
   private final TimingEntry r;
   private final ItemDescriptor s;
   private final CheckerBridge t;
   private final CheckerBridge u;
   private final CheckerBridge v;
   private final MaskEntry w;
   private final MaskEntry x;
   private final int[] y;
   private long z;
   private boolean aa;
   private final Runnable ab;

   public BlockCacheController() {
      super("", "", ParserEngine.Z4);
      this.setName(new char[]{'ⳗ', 'Ⲕ', 'Ⲷ', 'ⲗ', 'ⵣ', 'ⴖ', 'ⴌ', 'ⴑ', 'ⷶ', 'ⷆ', 'ⶴ', 'ⶂ'}, 1360211099, new char[0], 163606290);
      BlockCalculator var10001 = new BlockCalculator("", 0.0, 36.0, 6.0, 1.0);
      var10001.n(new char[]{'쥵', '쥹', '줟', '짻', '즔', '즇', '증', '쩥', '쩕', '쨢', '쨝'}, 1184418104);
      this.i = var10001;
      var10001 = new BlockCalculator("", 0.0, 576.0, 64.0, 1.0);
      var10001.n(new char[]{'㱇', '㰇', '㰡', '㰉', '㲦', '㳵', '㲡', '㲂', '㵰', '㵍', '㴳'}, -1043448822);
      this.j = var10001;
      CheckerBridge var2 = new CheckerBridge("", false);
      var2.n(new char[]{'匧', '厼', '叞', '厤', '厊', '呣', '名', '吊', '吂', '哸', '哚', '咼'}, -1066183821);
      this.q = var2;
      TimingEntry var3 = new TimingEntry("", 0.0, 550.0, 50.0, 1.0, 50.0, 50.0);
      var3.n(new char[]{'듆', '뒏', '뒲', '뒰', '뒎', '딽', '땵', '딵', '딎', '뗼', '뗊', '떡', '떗', '뙹'}, 28750978);
      this.r = var3;
      ItemDescriptor var4 = new ItemDescriptor("", 88, false);
      var4.n(new char[]{'嬠', '宮', '导', '寊', '宴', '宊', '屺', '屎', '尼', '屘', '峜', '峓', '岬'}, -616539295);
      this.s = var4;
      CheckerBridge var5 = new CheckerBridge("", true);
      var5.n(new char[]{'ो', 'ख', 'श', 'घ', 'ৱ', '\u09db', 'া', '\u09d2', 'ੁ', 'ੑ', '\u0a3b', 'ਚ', '૨', '\u0ade', 'થ'}, 790169881);
      this.t = var5;
      CheckerBridge var6 = new CheckerBridge("", true);
      var6.n(new char[]{'ܙ', 'ݒ', 'ߩ', 'ߕ', 'ީ', 'ߘ', 'ࡃ', '࡙', 'ࠡ', 'ࠑ', 'ࣾ', 'ࣁ'}, -1570306211);
      this.u = var6;
      CheckerBridge var7 = new CheckerBridge("", false);
      var7.n(new char[]{'켗', '콛', '쿸', '쿟', '쿲', '쾳', '큥', '큛', '큮', '퀹', '탣', '탟', '킯', '킄', '텻'}, 1787350870);
      this.v = var7;
      MaskEntry var8 = new MaskEntry("", "Main inv");
      var8.n(new char[]{'㒨', '㔥', '㕘', '㔦', '㔘', '㖧', '㗵', '㖩', '㖋', '㙷', '㙑'}, 1463760108);
      this.w = var8;
      MaskEntry var9 = new MaskEntry("", "None");
      var9.n(new char[]{'鄕', '酓', '釹', '釞', '醪', '釙', '鉋', '鉛', '鈹', '鈁', '鋧'}, -1624927906);
      this.x = var9;
      this.y = new int[36];
      this.ab = this::b;
      this.a(new InitAdapter[]{this.i, this.j, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x});
   }

   @Override
   public void c() {

      this.b.a(InitNotifier.class, this);
      this.z = System.nanoTime();
      this.aa = false;
      FrameClockCache.add(this.ab);
      super.c();
   }

   @Override
   public void d() {

      this.b.b(InitNotifier.class, this);
      FrameClockCache.b(this.ab);
      this.aa = false;
      super.d();
   }

   @Override
   public void a() {

      if (a.player != null && a.world != null && a.interactionManager != null) {
         if (!(a.currentScreen instanceof InventoryScreen var1) || !SlotInspector.a(this.s.g())) {
            this.aa = false;
            return;
         }

         if (System.nanoTime() - this.z < 0L) {
            this.aa = true;
         } else {
            this.c(var1);
         }
      } else {
         this.aa = false;
      }
   }

   private void b() {

      if (this.aa && System.nanoTime() - this.z >= 0L) {
         if (a.player != null && a.world != null && a.interactionManager != null && a.currentScreen instanceof InventoryScreen var1 && SlotInspector.a(this.s.g())) {
            this.c(var1);
         } else {
            this.aa = false;
         }
      }
   }

   private void c(InventoryScreen var1) {

      boolean var2 = this.aa;
      int var3 = this.d_r48();
      if (var3 == -1) {
         this.aa = false;
      } else {
         int var4 = var3 < 9 ? 36 + var3 : var3;
         a.interactionManager.clickSlot(((PlayerScreenHandler)var1.getScreenHandler()).syncId, var4, 1, SlotActionType.THROW, a.player);
         long var5 = this.r.ns();
         long var7 = System.nanoTime();
         long var9 = this.z + var5;
         this.z = var2 && var9 - var7 > 0L ? var9 : var7 + var5;
         this.aa = true;
      }
   }

   private int d_r48() {

      long var1 = this.w.a_r92();
      long var3 = (var1 == 0L ? 68719476224L : var1) & ~this.x.a_r92();
      if (var3 == 0L) {
         return -1;
      } else {
         boolean var5 = this.u.f() && !this.v.f();
         int var6;
         if (this.q.f()) {
            var6 = var5 ? this.e(var3) : -1;
            if (var6 == -1) {
               var6 = this.f(var3);
            }

            if (var6 == -1) {
               var6 = this.g(var3);
            }
         } else {
            var6 = this.f(var3);
            if (var6 == -1) {
               var6 = this.g(var3);
            }

            if (var6 == -1 && var5) {
               var6 = this.e(var3);
            }
         }

         return var6;
      }
   }

   private int e(long var1) {

      if (ViewLocator.b(Items.TOTEM_OF_UNDYING) <= this.i.g()) {
         return -1;
      } else {
         PlayerInventory var3 = a.player.getInventory();
         int var4 = 0;

         for (int var5 = 0; var5 < 36; var5++) {
            if ((var1 & 1L << var5) != 0L && var3.getStack(var5).isOf(Items.TOTEM_OF_UNDYING)) {
               this.y[var4++] = var5;
            }
         }

         if (var4 == 0) {
            return -1;
         } else {
            return this.t.f() ? this.y[CalculateMapper.a(0, var4 - 1)] : this.y[0];
         }
      }
   }

   private int f(long var1) {

      int var3 = ViewLocator.b(Items.ENDER_PEARL);
      int var4 = this.j.g();
      if (var3 <= var4) {
         return -1;
      } else {
         PlayerInventory var5 = a.player.getInventory();
         int var6 = 0;

         for (int var7 = 0; var7 < 36; var7++) {
            if ((var1 & 1L << var7) != 0L && var5.getStack(var7).isOf(Items.ENDER_PEARL)) {
               this.y[var6++] = var7;
            }
         }

         if (var6 == 0) {
            return -1;
         } else if (this.t.f()) {
            int var12 = this.y[CalculateMapper.a(0, var6 - 1)];
            return var3 - var5.getStack(var12).getCount() >= var4 ? var12 : -1;
         } else {
            int var11 = -1;
            int var8 = -1623201375 ^ -524282274;

            for (int var9 = 0; var9 < var6; var9++) {
               int var10 = var5.getStack(this.y[var9]).getCount();
               if (var10 < var8) {
                  var8 = var10;
                  var11 = this.y[var9];
               }
            }

            return var3 - var8 >= var4 ? var11 : -1;
         }
      }
   }

   private int g(long var1) {

      if (!this.v.f()) {
         return -1;
      } else {
         PlayerInventory var3 = a.player.getInventory();
         int var4 = 0;

         for (int var5 = 0; var5 < 36; var5++) {
            if ((var1 & 1L << var5) != 0L) {
               ItemStack var6 = var3.getStack(var5);
               if (!var6.isEmpty() && !var6.isOf(Items.TOTEM_OF_UNDYING) && !var6.isOf(Items.ENDER_PEARL)) {
                  this.y[var4++] = var5;
               }
            }
         }

         if (var4 == 0) {
            return -1;
         } else {
            return this.t.f() ? this.y[CalculateMapper.a(0, var4 - 1)] : this.y[0];
         }
      }
   }
}
