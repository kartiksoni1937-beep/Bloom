package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.InitNotifier;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.ParserEngine;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.BlockCalculator;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.CheckerBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.LinkerProvider;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.NodeKeeper;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.ViewLocator;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Items;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.entity.Entity;
public final class LinkZoneAccessor extends BuilderFactory implements InitNotifier {
   private final CheckerBridge d;
   private final CheckerBridge e;
   private final CheckerBridge f;
   private final CheckerBridge g;
   private final CheckerBridge h;
   private final BlockCalculator i;
   private final CheckerBridge j;
   private final CheckerBridge z;
   private final BlockCalculator aa;
   private final CheckerBridge ab;
   private final CheckerBridge ac;
   private final CheckerBridge ad;
   private final BlockCalculator ae;
   private boolean af;
   private boolean ag;
   private CalculateRange ah;

   public LinkZoneAccessor() {
      super("", "", ParserEngine.CT);
      this.setName(
         new char[]{'ㅌ', '\u3102', 'ㄾ', 'ㄞ', '\u31e6', 'ㆈ', 'ㆃ', 'ㆉ', '㉰', '㉆', '㈯', '㈇', '㊡', '㋨', '㋞', '㊰', '㊙'}, 1152200973, new char[0], 525933659
      );
      CheckerBridge var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'㤳', '㥑', '㧪', '㧒', '㦬', '㧛', '㩕', '㩗', '㩸', '㨴', '㫤', '㫌', '㪧', '㪇', '㭳', '㭝'}, 508180832);
      this.d = var10001;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'㬳', '㮡', '㯆', '㮨', '㮏', '㱠', '㰊', '㰚', '㰀', '㳮', '㳃', '㲩', '㲀'}, 384514928);
      this.e = var10001;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'渜', '湜', '滿', '源', '溟', '溁', '潽'}, 797011539);
      this.f = var10001;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'꜎', 'Ꝏ', '꜑', 'Ꞿ', 'Ꟶ', 'ꞹ', 'Ꞛ', '꡶', 'ꡍ', '꠰'}, -581720255);
      this.g = var10001;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'⥟', '⤀', '⤿', '⤉', '⧯', '⧃', '⦪', '⦜', '⨧', '⩢', '⨤', '⨉', '⫢', '⫅', '⪤'}, 716646671);
      this.h = var10001;
      BlockCalculator var5 = new BlockCalculator("", 1.0, 20.0, 2.0, 1.0);
      var5.n(new char[]{'㈍', '㉊', '㋦', '㋃', '㊭', '㊔', '㊗'}, 673264197);
      this.i = var5;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'㚠', '㜠', '㝃', '㝬', '㜬', '㟸', '㟆', '㞽', '㞉', '㡢'}, 2138322671);
      this.j = var10001;
      var10001 = new CheckerBridge("", true);
      var10001.n(new char[]{'혒', '홞', '훧', '훋', '횮', '횇', '휫', '흺', '휥', '휉', '\ud7fe', 'ퟃ', 'ힷ', '힗'}, -1835018671);
      this.z = var10001;
      BlockCalculator var8 = new BlockCalculator("", 1.0, 10.0, 5.0, 0.1);
      var8.n(new char[]{'鳭', '鳦', '鲎', '鵵', '鵑', '鴥', '鴍', '鷡', '鷄'}, -1450795863);
      this.aa = var8;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'뿥', '뿺', '뾁', '쁷', '쁕', '쀹', '쀌', '샺', '삍', '삏', '삙', '셳', '셚', '센', '섆', '쇪', '쇖'}, -1758740555);
      this.ab = var10001;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'ट', 'ॕ', '৲', 'ড়', '\u09bb', 'জ', 'ਸ਼', 'ੴ', '\u0a3d', 'ਞ'}, -2128803492);
      this.ac = var10001;
      var10001 = new CheckerBridge("", false);
      var10001.n(new char[]{'⸊', '⹆', '⻯', '⻃', '⺦', '⺏', '⼣', '⽫', '⼵', '⼅', '⼒', '\u2fed'}, -506712503);
      this.ad = var10001;
      BlockCalculator var12 = new BlockCalculator("", 0.0, 4.0, 0.2, 0.1);
      var12.n(new char[]{'뎗', '돛', '둷', '둇', '됻', '됇', '등', '듛', '뒫', '뒞', '딬', '땪', '딨', '딆', '뗾', '뗂'}, 1500754902);
      this.ae = var12;
      this.a(new InitAdapter[]{this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.z, this.aa, this.ab, this.ac, this.ad, this.ae});
      this.af = false;
      this.ag = false;
   }

   @Override
   public void c() {

      this.b.a(InitNotifier.class, this);
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
         if (this.d.f()) {
            CalculateRange var1 = this.ah;
            if (var1 == null) {
               var1 = ConfigBridge.c.c().a(CalculateRange.class);
               this.ah = var1;
            }

            if (var1 != null && var1.f() && var1.x) {
               return;
            }
         }

         PlayerInventory var14 = a.player.getInventory();
         if (!this.e.f() || !a.player.isBlocking()) {
            if (a.player.getOffHandStack().getItem() != Items.TOTEM_OF_UNDYING && this.f.f() && !this.ag) {
               this.ag = true;
               ViewLocator.a(Items.TOTEM_OF_UNDYING);
            }

            if (a.player.getOffHandStack().getItem() == Items.TOTEM_OF_UNDYING) {
               this.ag = false;
            }

            double var2 = this.i.p();
            if ((double)a.player.getHealth() <= var2 && this.g.f() && !this.af) {
               this.af = true;
               ViewLocator.a(Items.TOTEM_OF_UNDYING);
            }

            if ((double)a.player.getHealth() > var2) {
               this.af = false;
            }

            if (this.h.f() && !(a.player.getHealth() > 19.0F) && (this.j.f() || !a.player.isOnGround())) {
               double var4 = (double)(a.player.getHealth() + a.player.getAbsorptionAmount());
               if (var4 > 12.0) {
                  return;
               }

               boolean var6 = !this.z.f();
               if (!var6) {
                  double var7 = this.aa.p();
                  double var9 = var7 * var7;
                  List var11 = a.world.getPlayers();

                  for (int var12 = 0; var12 < var11.size(); var12++) {
                     AbstractClientPlayerEntity var13 = (AbstractClientPlayerEntity)var11.get(var12);
                     if (var13 != a.player && a.player.squaredDistanceTo(var13) <= var9) {
                        var6 = true;
                        break;
                     }
                  }
               }

               if (var6) {
                  double var15 = this.ae.p();
                  int var16 = (int)Math.floor(var15);

                  for (int var10 = 1; var10 <= var16; var10++) {
                     if (!a.world.getBlockState(a.player.getBlockPos().add(0, -var10, 0)).isAir()) {
                        return;
                     }
                  }

                  BlockPos var17 = a.player.getBlockPos().down((int)var15);
                  if (a.world.getBlockState(var17).isAir()) {
                     List var18 = this.a_r25();

                     for (int var19 = 0; var19 < var18.size(); var19++) {
                        if (this.c(a.player, ((EndCrystalEntity)var18.get(var19)).getEntityPos()) >= var4) {
                           ViewLocator.a(Items.TOTEM_OF_UNDYING);
                           return;
                        }
                     }

                     if (this.ab.f() && this.b(var4)) {
                        ViewLocator.a(Items.TOTEM_OF_UNDYING);
                     }
                  }
               }
            }
         }
      }
   }

   private List<EndCrystalEntity> a_r25() {

      Vec3d var1 = a.player.getEntityPos();
      return a.world.getEntitiesByClass(EndCrystalEntity.class, new Box(var1.add(-6.0, -6.0, -6.0), var1.add(6.0, 6.0, 6.0)), Objects::nonNull);
   }

   private boolean b(double var1) {

      boolean var3 = this.ac.f();
      ArrayList var4 = new ArrayList();
      if (var3) {
         boolean var5 = this.ad.f();
         List var6 = a.world.getPlayers();

         for (int var7 = 0; var7 < var6.size(); var7++) {
            AbstractClientPlayerEntity var8 = (AbstractClientPlayerEntity)var6.get(var7);
            if (var8 != a.player && (!var5 || var8.isHolding(Items.END_CRYSTAL))) {
               Vec3d var9 = LinkerProvider.a(var8);
               BlockHitResult var10 = a.world
                  .raycast(
                     new RaycastContext(var9, var9.add(LinkerProvider.b(var8).multiply(4.5)), RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, var8)
                  );
               if (var10 != null) {
                  var4.add(var10.getBlockPos());
               }
            }
         }

         if (var4.isEmpty()) {
            return false;
         }
      }

      Vec3d var19 = a.player.getEntityPos();
      BlockPos var20 = a.player.getBlockPos();
      int var21 = var20.getX();
      int var22 = var20.getY();
      int var23 = var20.getZ();
      BlockPos.Mutable var24 = new BlockPos.Mutable();

      for (int var11 = var23 - 6; var11 <= var23 + 6; var11++) {
         for (int var12 = var22 - 8; var12 <= var22 + 2; var12++) {
            for (int var13 = var21 - 6; var13 <= var21 + 6; var13++) {
               Block var14 = a.world.getBlockState(var24.set(var13, var12, var11)).getBlock();
               if (var14 == Blocks.OBSIDIAN || var14 == Blocks.BEDROCK) {
                  double var15 = var19.distanceTo(Vec3d.ofBottomCenter(var24).add(0.0, 1.0, 0.0));
                  double var17 = var15 > 12.0 ? 0.0 : Math.max(0.0, (1.0 - var15 / 12.0) * 12.0);
                  if (var17 >= var1 && NodeKeeper.a(var24) && (!var3 || var4.contains(var24))) {
                     return true;
                  }
               }
            }
         }
      }

      return false;
   }

   private double c(PlayerEntity var1, Vec3d var2) {

      double var3 = var1.getEntityPos().distanceTo(var2);
      if (var3 > 12.0) {
         return 0.0;
      } else {
         double var5 = (1.0 - var3 / 12.0) * 12.0;
         return Math.max(0.0, var5);
      }
   }
}
