package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource;

import java.util.ArrayList;
import java.util.List;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.CoreSerializer;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.InitNotifier;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.LinkerFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.UtilExtension;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.ParserEngine;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.BlockCalculator;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.CheckerBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.ItemDescriptor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.PlacementEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.BufferNormalizer;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.FrameClockCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.InitExecutor;
import net.minecraft.util.Hand;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Items;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.client.font.TextRenderer;import net.minecraft.entity.Entity;
public final class StepZoneIterator extends BuilderFactory implements InitNotifier, UtilExtension, CoreSerializer {
   private final BlockCalculator aa;
   private final BlockCalculator ab;
   private final BlockCalculator ac;
   private final BlockCalculator ad;
   private final BlockCalculator ae;
   private final CheckerBridge af;
   private final CheckerBridge ag;
   private final CheckerBridge ah;
   private final CheckerBridge ai;
   private final CheckerBridge aj;
   private final CheckerBridge ak;
   private final CheckerBridge al;
   private final CheckerBridge am;
   private final PlacementEntry an;
   private static final String[] ao = new String[]{
      "Waiting for playe" + "r...", "Found play" + "er: ", "Stop gliding to smash", "Wai" + "ting for crit opportunity..."
   };
   private static final double ap = 1.5;
   private static final int aq = 4;
   private static final int ar = 10;
   private static final int as = 4;
   private int at;
   private int au;
   private int av;
   private boolean aw;
   private final List<String> ax;
   private long ay;
   private int az;
   private PlayerEntity ba;
   private int bb;
   private int bc;
   private double bd;
   private boolean be;
   private Object bf;

   public StepZoneIterator() {
      super("", "", ParserEngine.CT);
      this.setName(
         new char[]{'筮', '笻', '笙', '篣', '箋', '箇', '箈', '籫', '籂'},
         -1082361041,
         new char[]{
            '췍',
            '췛',
            '춺',
            '춅',
            '칡',
            '칂',
            '층',
            '칅',
            '컲',
            '컆',
            '캰',
            '캕',
            '콩',
            '콼',
            '콟',
            '켱',
            '콜',
            '쿶',
            '쿕',
            '쾴',
            '쾝',
            '큹',
            '큂',
            '퀠',
            '퀙',
            '킳',
            '탁',
            '킥',
            '킑',
            '텻',
            '텋'
         },
         744344972
      );
      BlockCalculator var10001 = new BlockCalculator("", 1.0, 6.0, 4.5, 0.1);
      var10001.n(new char[]{'䚅', '䚓', '䝴', '䝗', '䜻', '䝒', '䟕', '䟙', '䞼', '䞚', '䡬', '䡂', '䠨', '䠏'}, 2040874711);
      this.aa = var10001;
      var10001 = new BlockCalculator("", 1.0, 10.0, 3.0, 0.1);
      var10001.n(new char[]{'䑸', '䐽', '䐝', '䒲', '䓹', '䒵', '䒆', '䕩', '䕅', '䔸'}, 781796405);
      this.ab = var10001;
      var10001 = new BlockCalculator("", 0.1, 2.0, 0.3, 0.1);
      var10001.n(new char[]{'㏦', '㎣', '㎇', '㐨', '㑡', '㐧', '㐉', '㓨', '㒃', '㒑', '㒑', '㕥', '㕺', '㕚'}, 652096427);
      this.ac = var10001;
      var10001 = new BlockCalculator("", 10.0, 20.0, 10.0, 1.0);
      var10001.n(new char[]{'㩁', '㩫', '㩊', '㨼', '㨟', '㫰', '㪚', '㪝', '㪝', '㭻', '㭗', '㬬'}, 2065709568);
      this.ad = var10001;
      var10001 = new BlockCalculator("", 1.0, 5.0, 2.0, 1.0);
      var10001.n(
         new char[]{'\uf579', '\uf528', '\uf51c', '\uf5f9', '\uf5d4', '\uf5be', '\uf5d5', '\uf650', '\uf656', '\uf63e', '\uf610', '\uf6e9'}, -1361316549
      );
      this.ae = var10001;
      CheckerBridge var5 = new CheckerBridge("", true);
      var5.n(new char[]{'꽳', '꼥', '꼮', '꼋', '꿴', '꿎', '꾾', '꿚', '끜', '끔', '뀮', '뀂', '냧', '냕'}, -831410399);
      this.af = var5;
      CheckerBridge var6 = new CheckerBridge("", true);
      var6.n(new char[]{'剠', '刵', '别', '刑', '劽', '勯', '劬', '劓', '卭', '卛', '匿', '卖', '受', '叕', '厰', '厙'}, 774525473);
      this.ag = var6;
      CheckerBridge var7 = new CheckerBridge("", true);
      var7.n(new char[]{'熃', '熳', '熗', '牾', '牗', '牻', '爩', '狰', '狕', '犢', '犚', '獴', '獀', '猺', '猝', '珿'}, 815296960);
      this.ah = var7;
      CheckerBridge var8 = new CheckerBridge("", true);
      var8.n(new char[]{'鮣', '鮗', '鱻', '鱞', '鰷', '鱛', '鳖', '鳐', '鲶', '鲒', '鴶', '鵚', '鴲', '鵓', '鷁', '鷘', '鶷', '鶇', '鹺'}, -941122592);
      this.ai = var8;
      CheckerBridge var9 = new CheckerBridge("", true);
      var9.n(
         new char[]{
            '\udea0',
            '\udf60',
            '\udf41',
            '\udf35',
            '\udf4b',
            '\udfdd',
            '\udfc1',
            '\udfad',
            '\udf89',
            '\ue026',
            '\ue063',
            '\ue025',
            '\ue00f',
            '\ue0ee',
            '\ue0c8',
            '\ue0ae',
            '\ue0b8'
         },
         1460788975
      );
      this.aj = var9;
      CheckerBridge var10 = new CheckerBridge("", true);
      var10.n(new char[]{'\ude90', '\ude84', '\udf71', '\udf6a', '\udf57', '\udf2f', '\udf19', '\udfbb', '\udff9', '\udfab', '\udf91', '\ue063'}, 492035778);
      this.ak = var10;
      CheckerBridge var11 = new CheckerBridge("", false);
      var11.n(new char[]{'筵', '符', '笆', '篾', '箐', '箍', '箜', '籨', '籍', '簨', '簂'}, 1766357812);
      this.al = var11;
      CheckerBridge var12 = new CheckerBridge("", true);
      var12.n(
         new char[]{
            '\uedd0',
            '\uedca',
            '\uedae',
            '\ued97',
            '\ueddf',
            '\uee4d',
            '\uee49',
            '\uee3d',
            '\uee0f',
            '\ueeef',
            '\ueeca',
            '\ueef8',
            '\ueeb3',
            '\uef7f',
            '\uef46',
            '\uef24',
            '\uef1f',
            '\ueff3',
            '\uefc8'
         },
         2093346179
      );
      this.am = var12;
      PlacementEntry var13 = new PlacementEntry("", 0.0, 1.0, 0.0, 1.0);
      var13.n(new char[]{'᳐', '\u1c8c', 'Შ', '\u1c8c', 'Ლ', 'ᵰ', 'ᵉ', 'ᵼ', 'ᴺ', 'ᷳ', 'ᷔ'}, 956177539);
      this.an = var13;
      this.at = -1;
      this.au = 0;
      this.av = 0;
      this.aw = false;
      this.ax = new ArrayList<>();
      this.ay = 0L;
      this.az = 0;
      this.ba = null;
      this.bb = 0;
      this.bc = -1;
      this.bd = 0.0;
      this.be = false;
      this.bf = null;
      this.a(this.aa, this.ab, this.ac, this.ad, this.ae, this.af, this.ag, this.ah, this.ai, this.aj, this.ak, this.al, this.am, this.an);
   }

   @Override
   public void c() {

      this.b.a(InitNotifier.class, this);
      this.b.a(UtilExtension.class, this);
      this.b.a(CoreSerializer.class, this);
      this.r();
      InitExecutor.t = true;
      super.c();
   }

   @Override
   public void d() {

      this.b.b(InitNotifier.class, this);
      this.b.b(UtilExtension.class, this);
      this.b.b(CoreSerializer.class, this);
      InitExecutor.t = false;
      if (a.player != null && this.bf == a.player && !this.c(a.player.age) && FrameClockCache.i(a.player)) {
         this.q();
      }

      if (InitExecutor.m == 1) {
         InitExecutor.m = 0;
         InitExecutor.n = null;
      }

      this.r();
      super.d();
   }

   @Override
   public void a() {

      if (a.player != null && a.world != null && a.interactionManager != null) {
         if (this.bf != a.player) {
            this.r();
            this.bf = a.player;
            if (InitExecutor.n != null && InitExecutor.n != a.player) {
               InitExecutor.m = 0;
               InitExecutor.n = null;
            }
         }

         int var1 = a.player.age;
         if (!a.player.isAlive()) {
            this.r();
            this.bf = a.player;
            if (InitExecutor.m == 1) {
               InitExecutor.m = 0;
               InitExecutor.n = null;
            }
         } else {
            if (a.player.isOnGround() || a.player.isTouchingWater()) {
               this.be = false;
               this.bd = 0.0;
               if (this.ba != null) {
                  this.ba = null;
                  this.n(1);
               }

               if (InitExecutor.m == 1) {
                  InitExecutor.m = 0;
                  InitExecutor.n = null;
               }
            } else if (a.player.isGliding()) {
               this.be = true;
               if (InitExecutor.m == 1 && this.ba == null) {
                  InitExecutor.m = 0;
                  InitExecutor.n = null;
               }
            }

            if (a.player.fallDistance < this.bd) {
               this.bd = 0.0;
            }

            if (this.au > 0) {
               this.au--;
            }

            if (this.av > 0) {
               this.av--;
            }

            int var2 = this.o();
            boolean var3 = var2 != -1 && (!this.af.f() || this.be || a.player.getEquippedStack(EquipmentSlot.CHEST).contains(DataComponentTypes.GLIDER));
            if (var3) {
               InitExecutor.q = var1;
            }

            if (a.currentScreen == null) {
               if (this.az > 0 && this.ba == null) {
                  if (this.az > 1) {
                     this.az--;
                  } else if (!this.c(var1)) {
                     if (FrameClockCache.i(a.player)) {
                        this.az = 0;
                        if (this.q()) {
                           return;
                        }
                     } else {
                        FrameClockCache.j(a.player);
                     }
                  }
               }

               if (this.ba != null) {
                  this.a(var1, var2);
               } else {
                  int var4 = var3 && this.au <= 0 ? this.b() : 0;
                  this.e(var4 != 0);
                  if (var4 != 2) {
                     if (var4 == 1 && this.d_r41()) {
                        this.f(a.player.isGliding() ? ao[2] : ao[3]);
                     }
                  } else {
                     PlayerEntity var5 = this.g_r42();
                     if (var5 == null) {
                        if (this.d_r41()) {
                           this.f(ao[0]);
                        }
                     } else {
                        if (this.d_r41()) {
                           this.f(ao[1] + var5.getName().getString());
                        }

                        int var6 = InitExecutor.n == a.player ? InitExecutor.m : 0;
                        if (var6 != 2 && var6 != 3) {
                           boolean var7 = InitExecutor.d(var5, a.player, 0) >= 2;
                           int var8 = var7 ? this.p() : -1;
                           if (!var7 || !InitExecutor.u) {
                              if (!this.c(var1)) {
                                 PlayerInventory var9 = a.player.getInventory();
                                 int var10 = InitExecutor.a(var9);
                                 if (this.al.f() && var8 != -1) {
                                    if (var8 != var10 && !FrameClockCache.i(a.player)) {
                                       FrameClockCache.j(a.player);
                                    } else {
                                       this.m(var10);
                                       InitExecutor.a(var9, var8);
                                       this.bc = var8;
                                       this.f("Breaking shield with axe...");
                                       this.k(var5);
                                       this.ba = var5;
                                       this.bb = Math.max(1, this.ae.g());
                                       this.az = 0;
                                    }
                                 } else if (var2 != -1) {
                                    boolean var11 = a.player.getMainHandStack().isOf(Items.MACE);
                                    if (!var11 && !FrameClockCache.i(a.player)) {
                                       FrameClockCache.j(a.player);
                                    } else {
                                       if (!var11) {
                                          this.m(var10);
                                          InitExecutor.a(var9, var2);
                                          this.bc = var2;
                                       }

                                       this.f("Macing " + var5.getName().getString() + "!");
                                       this.k(var5);
                                       this.au = Math.max(this.ad.g(), 10);
                                       if (!var7) {
                                          this.bd = a.player.fallDistance;
                                          InitExecutor.i(var5, a.player);
                                       }

                                       this.n(4);
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      } else {
         if (a.player == null) {
            if (this.bf != null) {
               this.r();
            }

            if (InitExecutor.n != null) {
               InitExecutor.m = 0;
               InitExecutor.n = null;
            }
         }
      }
   }

   private void a(int var1, int var2) {

      this.bb--;
      if (this.bb <= 0) {
         if (this.bb >= -4 && var2 != -1) {
            if (!this.c(var1) && this.b() == 2 && this.g_r42() == this.ba) {
               PlayerInventory var3 = a.player.getInventory();
               if (InitExecutor.a(var3) != var2 && !FrameClockCache.i(a.player)) {
                  FrameClockCache.j(a.player);
               } else {
                  if (InitExecutor.a(var3) != var2) {
                     InitExecutor.a(var3, var2);
                     this.bc = var2;
                  }

                  this.f("Applying high" + " impact s" + "tate!");
                  this.k(this.ba);
                  this.ba = null;
                  this.au = Math.max(this.ad.g(), 10) + 10;
                  this.bd = a.player.fallDistance;
                  this.n(4);
               }
            }
         } else {
            this.ba = null;
            this.f("Failed to switch t" + "o mace after axe!");
            this.n(1);
         }
      }
   }

   private int b() {

      if (!a.player.isOnGround() && !a.player.isTouchingWater() && !a.player.hasVehicle() && !a.player.isUsingItem()) {
         double var1 = a.player.fallDistance - this.bd;
         if (!(var1 <= 1.5) && !(var1 < this.ab.p())) {
            if (this.aj.f() && -a.player.getVelocity().y < this.ac.p()) {
               return 0;
            } else {
               return !a.player.isGliding() && (!this.ak.f() || this.l_r44()) ? 2 : 1;
            }
         } else {
            return 0;
         }
      } else {
         return 0;
      }
   }

   private boolean c(int var1) {

      return InitExecutor.o == var1 || InitExecutor.p == var1 || a.player.handSwinging && a.player.handSwingTicks < 0;
   }

   private boolean d_r41() {

      return this.am.f() && System.currentTimeMillis() - this.ay > 100L;
   }

   private void e(boolean var1) {

      if (this.am.f()) {
         if (var1 && !this.aw) {
            this.ax.clear();
            this.f("Mace" + " mode activat" + "ed - sea" + "rching for targets...");
            this.av = 0;
         }

         if (!var1 && this.aw) {
            this.av = 60;
         }

         if (!var1 && this.av == 0 && !this.ax.isEmpty()) {
            this.ax.clear();
         }

         this.aw = var1;
      }
   }

   private void f(String var1) {

      if (this.am.f()) {
         long var2 = System.currentTimeMillis();
         if (var2 - this.ay > 100L) {
            if (!this.ax.contains(var1)) {
               this.ax.add(var1);
               if (this.ax.size() > 5) {
                  this.ax.remove(0);
               }
            }

            this.ay = var2;
         }
      }
   }

   @Override
   public void a(DrawContext var1) {

      if (!this.ax.isEmpty() && this.am.f() && a.player != null && a.world != null) {
         byte var2 = 10;
         byte var3 = 10;
         int var4 = 0;

         for (String var6 : this.ax) {
            int var7 = a.textRenderer.getWidth(var6);
            if (var7 > var4) {
               var4 = var7;
            }
         }

         int var8 = this.ax.size() * 12 + 8;
         var1.fill(var3 - 4, var2 - 4, var3 + var4 + 8, var2 + var8, 1769392802 ^ -378090846);
         var1.drawStrokedRectangle(var3 - 4, var2 - 4, var4 + 12, var8 + 4, 679280948 ^ -679608780);

         for (int var9 = 0; var9 < this.ax.size(); var9++) {
            String var10 = this.ax.get(var9);
            var1.drawText(a.textRenderer, var10, var3, var2 + var9 * 12, -777835437 ^ -782445652, true);
         }
      }
   }

   @Override
   public void a(LinkerFactory var1) {

      if (a.player != null && InitExecutor.p == a.player.age) {
         var1.b();
      }
   }

   private PlayerEntity g_r42() {

      if (a.crosshairTarget instanceof EntityHitResult var1
         && var1.getEntity() instanceof PlayerEntity var2
         && this.j(var2)
         && this.i(var2) <= this.h_r43()
         && (!this.ai.f() || a.player.canSee(var2))) {
         return var2;
      }

      return null;
   }

   private double h_r43() {

      return Math.min(this.aa.p(), a.player.getEntityInteractionRange());
   }

   private double i(PlayerEntity var1) {

      Vec3d var2 = a.player.getEyePos();
      Box var3 = var1.getBoundingBox();
      double var4 = MathHelper.clamp(var2.x, var3.minX, var3.maxX);
      double var6 = MathHelper.clamp(var2.y, var3.minY, var3.maxY);
      double var8 = MathHelper.clamp(var2.z, var3.minZ, var3.maxZ);
      return var2.distanceTo(new Vec3d(var4, var6, var8));
   }

   private boolean j(PlayerEntity var1) {

      if (var1 != null && var1 != a.player) {
         return !var1.isDead() && !var1.isRemoved() ? !var1.isCreative() && !var1.isSpectator() : false;
      } else {
         return false;
      }
   }

   private void k(PlayerEntity var1) {

      if (this.ah.f()) {
         BufferNormalizer.a(0, 100);
      }

      a.interactionManager.attackEntity(a.player, var1);
      a.player.swingHand(Hand.MAIN_HAND);
      InitExecutor.p = a.player.age;
      InitExecutor.m = 1;
      InitExecutor.n = a.player;
   }

   private boolean l_r44() {

      boolean var1 = !a.player.isOnGround() && a.player.getVelocity().y < 0.0;
      boolean var2 = !a.player.isTouchingWater() && !a.player.isInLava();
      boolean var3 = !a.player.isClimbing();
      boolean var4 = !a.player.hasVehicle();
      return var1 && var2 && var3 && var4;
   }

   private void m(int var1) {

      if (!this.ag.f()) {
         this.at = -1;
      } else if (this.at == -1 || var1 != this.bc) {
         this.at = var1;
      }
   }

   private void n(int var1) {

      this.az = this.at != -1 && this.ag.f() ? var1 : 0;
   }

   private int o() {

      PlayerInventory var1 = a.player.getInventory();

      for (int var2 = 0; var2 < 9; var2++) {
         if (var1.getStack(var2).isOf(Items.MACE)) {
            return var2;
         }
      }

      return -1;
   }

   private int p() {

      PlayerInventory var1 = a.player.getInventory();

      for (int var2 = 0; var2 < 9; var2++) {
         if (var1.getStack(var2).getItem() instanceof AxeItem) {
            return var2;
         }
      }

      return -1;
   }

   private boolean q() {

      boolean var1 = false;
      if (this.at != -1 && a.player != null) {
         PlayerInventory var2 = a.player.getInventory();
         var1 = InitExecutor.a(var2) == this.bc && this.at != this.bc && (InitExecutor.n != a.player || InitExecutor.m != 2);
         if (var1) {
            InitExecutor.a(var2, this.at);
         }
      }

      this.at = -1;
      this.bc = -1;
      this.az = 0;
      return var1;
   }

   private void r() {

      this.at = -1;
      this.au = 0;
      this.av = 0;
      this.az = 0;
      this.aw = false;
      this.ax.clear();
      this.ba = null;
      this.bb = 0;
      this.bc = -1;
      this.bd = 0.0;
      this.be = false;
      this.bf = null;
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
