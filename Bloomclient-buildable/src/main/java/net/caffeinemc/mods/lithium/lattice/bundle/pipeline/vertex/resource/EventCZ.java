package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource;

import java.util.List;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.InitNotifier;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.ParserEngine;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.BlockCalculator;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.CheckerBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.SlotEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.LockD;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.RotG;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.SortableData;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.client.render.RenderTickCounter;

public final class EventCZ extends BuilderFactory implements InitNotifier {
   private final BlockCalculator j;
   private final BlockCalculator k;
   private final BlockCalculator l;
   private final BlockCalculator m;
   private final CheckerBridge n;
   private final SlotEntry o;
   private static final double p = 0.5;
   private static final double q = 0.18;
   private static final int r = 408758872;
   private static final double s = 400.0;
   private static final double t = 0.7;
   private static final int u = 3;
   private static final double v = 2.0;
   private static final double w = 2.5;
   private static final double x = 4.0;
   private static final float y = 0.08F;
   private static final double z = 1.0 - Math.pow(2.0, -0.625000013969839);
   private static final String[] aa = new String[]{"None", "Sword", "Axe", "Both", "sword", "_axe", "axe"};
   private Entity ab;
   private Entity ac;
   private long ad;
   private long ae;
   private Vec3d af;
   private Vec3d ag;
   private Vec3d ah;
   private Item ai;
   private String aj;
   private boolean ak;

   public EventCZ() {
      super("", "", ParserEngine.PC);
      this.setName(
         new char[]{'Ḛ', 'Ṕ', 'Ự', 'ổ', 'ỷ', 'ặ', 'ὦ', '\u1f47', 'Ἲ', 'ἁ', 'ῥ'},
         -1699668389,
         new char[]{
            '쫋',
            '쫚',
            '쪻',
            '쪎',
            '쭵',
            '쭑',
            '쬷',
            '쭃',
            '쯻',
            '쯎',
            '쮵',
            '쮭',
            '쯞',
            '챼',
            '챕',
            '찶',
            '챚',
            '쳭',
            '쳗',
            '철',
            '첗',
            '쵧',
            '쵐',
            '촠',
            '쵒',
            '췥',
            '췑',
            '춽',
            '춉',
            '침',
            '치',
            '츸',
            '칊',
            '컺',
            '컅',
            '캨',
            '캉',
            '콱',
            '콌',
            '켯',
            '켛'
         },
         1482082954
      );
      BlockCalculator var10001 = new BlockCalculator("", 0.0, 1.0, 0.85, 0.01);
      var10001.n(new char[]{'抬', '捪', '捏', '挹', '挕', '揽', '揍', '掰'}, 174482175);
      this.j = var10001;
      var10001 = new BlockCalculator("", 0.0, 1.0, 0.5, 0.01);
      var10001.n(new char[]{'\uf0f9', '\uf0a4', '\uf087', '\uf168', '\uf152', '\uf12d', '\uf10d', '\uf1ed', '\uf1c5'}, -1473253206);
      this.k = var10001;
      var10001 = new BlockCalculator("", 1.0, 20.0, 6.0, 0.5);
      var10001.n(new char[]{'̐', '̀', 'Ϯ', 'ϸ', 'ϛ'}, -373685438);
      this.l = var10001;
      var10001 = new BlockCalculator("", 1.0, 360.0, 90.0, 1.0);
      var10001.n(new char[]{'웡', '욉', '욳'}, -1651259737);
      this.m = var10001;
      CheckerBridge var4 = new CheckerBridge("", true);
      var4.n(new char[]{'᎓', 'ᎅ', 'ᎎ', 'ᑫ', 'ᑔ', 'ᐮ', 'ᐞ', 'ᒺ', 'ᓺ', 'ᒴ', 'ᒞ', 'ᕵ', 'ᕞ'}, -939912255);
      this.n = var4;
      this.o = new SlotEntry("Weapon Only", "Both", "None", "Sword", "Axe", "Both");
      this.ac = null;
      this.ad = 0L;
      this.ae = 0L;
      this.af = null;
      this.ag = Vec3d.ZERO;
      this.ah = Vec3d.ZERO;
      this.a(new InitAdapter[]{this.j, this.k, this.l, this.m, this.n, this.o});
   }

   @Override
   public void c() {

      this.b.a(InitNotifier.class, this);
      LockD.d = this::f_r103;
      this.ad = System.nanoTime();
      this.ae = this.ad;
      this.ab = null;
      this.ac = null;
      this.b();
      super.c();
   }

   @Override
   public void d() {

      this.b.b(InitNotifier.class, this);
      LockD.d = null;
      this.ab = null;
      this.ac = null;
      this.b();
      RotG.b(this);
      super.d();
   }

   private void b() {

      this.af = null;
      this.ag = Vec3d.ZERO;
      this.ah = Vec3d.ZERO;
   }

   private boolean c_r23() {

      if (a.player == null) {
         return false;
      } else {
         String var1 = this.o.f();
         if (aa[0].equals(var1)) {
            return true;
         } else {
            ItemStack var2 = a.player.getMainHandStack();
            if (var2.isEmpty()) {
               return false;
            } else {
               Item var3 = var2.getItem();
               if (var3 == this.ai && var1 == this.aj) {
                  return this.ak;
               } else {
                  String var4 = Registries.ITEM.getId(var3).getPath();
                  boolean var5 = var4.contains(aa[4]);
                  boolean var6 = var4.contains(aa[5]) || var4.equals(aa[6]);
                  boolean var7 = aa[1].equals(var1) ? var5 : (aa[2].equals(var1) ? var6 : (aa[3].equals(var1) ? var5 || var6 : true));
                  this.ai = var3;
                  this.aj = var1;
                  this.ak = var7;
                  return var7;
               }
            }
         }
      }
   }

   private boolean d(Entity var1) {

      if (var1 == null || var1 == a.player) {
         return false;
      } else if (!(var1 instanceof LivingEntity)) {
         return false;
      } else if (!var1.isRemoved() && var1.isAlive()) {
         double var2 = this.l.p();
         return a.player.squaredDistanceTo(var1) <= var2 * var2;
      } else {
         return false;
      }
   }

   @Override
   public void a() {

      if (a.player != null && a.world != null && a.currentScreen == null) {
         if (this.c_r23() && (!this.n.f() || a.options.attackKey.isPressed())) {
            if (this.ab != null && !this.d(this.ab)) {
               this.ab = null;
               this.af = null;
            }

            if (this.ab == null) {
               this.ab = this.g_r104();
               this.b();
               this.ae = System.nanoTime();
            }

            if (this.ab != null) {
               this.ac = this.ab;
               Vec3d var1 = this.ab.getEntityPos();
               if (this.af == null) {
                  this.ag = this.ab.getVelocity();
               } else {
                  Vec3d var2 = var1.subtract(this.af);
                  if (var2.length() > 4.0) {
                     this.ag = Vec3d.ZERO;
                  } else {
                     double var3 = 0.5;
                     this.ag = this.ag.add(var2.subtract(this.ag).multiply(var3));
                  }
               }

               this.af = var1;
               Vec3d var5 = this.ag.multiply(1.4);
               if (var5.length() > 2.5) {
                  var5 = var5.normalize().multiply(2.5);
               }

               this.ah = new Vec3d(
                  this.ah.x + (var5.x - this.ah.x) * z,
                  this.ah.y + (var5.y - this.ah.y) * z,
                  this.ah.z + (var5.z - this.ah.z) * z
               );
            }
         } else {
            this.ab = null;
            this.b();
         }
      }
   }

   private Vec3d e(Entity var1, float var2, Vec3d var3) {

      Vec3d var4 = var1.getLerpedPos(var2);
      double var5 = (double)var1.getHeight();
      double var7 = var4.y;
      double var9 = var4.y + (var1.getEyePos().y - var1.getY());
      double var11 = var3.y - var9;
      double var13 = 0.5 + var11 / 2.0;
      var13 = var13 < 0.0 ? 0.0 : (var13 > 1.0 ? 1.0 : var13);
      var13 = var13 * var13 * (3.0 - 2.0 * var13);
      double var15 = var9 + (var7 + var5 * 0.2 - var9) * (var13 < 0.0 ? 0.0 : (var13 > 1.0 ? 1.0 : var13));
      Box var17 = var1.getBoundingBox().offset(var4.subtract(var1.getEntityPos()));
      double var18 = MathHelper.clamp(var3.x, var17.minX, var17.maxX);
      double var20 = MathHelper.clamp(var3.z, var17.minZ, var17.maxZ);
      double var22 = var18 - var3.x;
      double var24 = var20 - var3.z;
      if (var22 * var22 + var24 * var24 < 1.0E-6) {
         var18 = (var17.minX + var17.maxX) * 0.5;
         var20 = (var17.minZ + var17.maxZ) * 0.5;
      }

      return new Vec3d(var18, MathHelper.clamp(var15, var17.minY, var17.maxY), var20);
   }

   private void f_r103() {

      long var1 = System.nanoTime();
      float var3 = (float)(var1 - this.ad) / 1.0E9F;
      this.ad = var1;
      double var4 = (double)(1618328510 ^ 2015924710 ^ SortableData.d[1]) / 1000.0;
      if (a.player != null && a.world != null && a.currentScreen == null) {
         if (this.ab != null) {
            if (this.c_r23()) {
               if (!this.n.f() || a.options.attackKey.isPressed()) {
                  if (!(var3 <= 0.0F)) {
                     if (var3 > 0.25F) {
                        var3 = 0.25F;
                     }

                     RenderTickCounter var6 = a.getRenderTickCounter();
                     float var7 = var6 != null ? var6.getTickProgress(true) : 1.0F;
                     Vec3d var8 = a.player.getEyePos();
                     Vec3d var9 = this.e(this.ab, var7, var8).add(this.ah);
                     Vec3d var10 = var9.subtract(var8);
                     double var11 = Math.sqrt(var10.x * var10.x + var10.z * var10.z);
                     if (var11 < 1.0E-6) {
                        RotG.b(this);
                     } else {
                        float var13 = (float)(Math.toDegrees(Math.atan2(var10.z, var10.x)) - 90.0);
                        float var14 = (float)(-Math.toDegrees(Math.atan2(var10.y, var11)));
                        float var15 = a.player.getYaw();
                        float var16 = a.player.getPitch();
                        float var17 = MathHelper.wrapDegrees(var13 - var15);
                        float var18 = var14 - var16;
                        double var19 = Math.sqrt((double)var17 * (double)var17 + (double)var18 * (double)var18);
                        if (var19 <= var4) {
                           RotG.b(this);
                        } else {
                           double var21 = (var19 - var4) / var4;
                           var21 = var21 < 0.0 ? 0.0 : (var21 > 1.0 ? 1.0 : var21);
                           var21 = var21 * var21 * (3.0 - 2.0 * var21);
                           double var23 = (double)(var1 - this.ae) / 1.8E8;
                           var23 = var23 < 0.0 ? 0.0 : (var23 > 1.0 ? 1.0 : var23);
                           var23 = var23 * var23 * (3.0 - 2.0 * var23);
                           double var25 = MathHelper.clamp(this.j.p(), 0.0, 1.0);
                           double var27 = var19 / Math.max(1.0, this.m.p() / 2.0);
                           var27 = 1.0 - (var27 < 0.0 ? 0.0 : (var27 > 1.0 ? 1.0 : var27));
                           var27 = var27 < 0.0 ? 0.0 : (var27 > 1.0 ? 1.0 : var27);
                           var25 *= 0.35 + 0.65 * var27 * var27 * (3.0 - 2.0 * var27);
                           float var29 = 0.03F + (float)MathHelper.clamp(this.k.p(), 0.0, 1.0) * 0.3F;
                           double var30 = 1.0 - Math.pow(2.0, -((double)var3) / (double)var29);
                           double var32 = var30 * var25 * var23 * var21;
                           var32 = var32 < 0.0 ? 0.0 : (var32 > 1.0 ? 1.0 : var32);
                           if (var32 <= 1.0E-5) {
                              RotG.b(this);
                           } else {
                              if (RotG.a(10, this)) {
                                 float var34 = (float)((double)var17 * var32);
                                 float var35 = (float)((double)var18 * var32);
                                 double var36 = 400.0 * (double)var3;
                                 double var38 = Math.sqrt((double)var34 * (double)var34 + (double)var35 * (double)var35);
                                 if (var38 > var36 && var38 > 1.0E-9) {
                                    double var40 = var36 / var38;
                                    var34 = (float)((double)var34 * var40);
                                    var35 = (float)((double)var35 * var40);
                                 }

                                 float var50 = var15 + var34;
                                 float var41 = MathHelper.clamp(var16 + var35, -90.0F, 90.0F);
                                 a.player.setYaw(var50);
                                 a.player.setPitch(var41);
                                 a.player.lastYaw = var50;
                                 a.player.lastPitch = var41;
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

   private Entity g_r104() {

      double var1 = this.l.p();
      double var3 = var1 * var1;
      double var5 = this.m.p() / 2.0;
      Box var7 = a.player.getBoundingBox().expand(var1);
      List var8 = a.world.getPlayers();
      AbstractClientPlayerEntity var9 = null;
      double var10 = 0.0;

      for (int var12 = 0; var12 < var8.size(); var12++) {
         AbstractClientPlayerEntity var13 = (AbstractClientPlayerEntity)var8.get(var12);
         if (var13 != a.player
            && var13.getBoundingBox().intersects(var7)
            && !var13.isRemoved()
            && var13.isAlive()
            && !var13.isCreative()
            && !var13.isSpectator()
            && !(a.player.squaredDistanceTo(var13) > var3)
            && this.i(var13) <= var5
            && a.player.canSee(var13)) {
            double var14 = this.h(var13);
            if (var9 == null || Double.compare(var14, var10) < 0) {
               var9 = var13;
               var10 = var14;
            }
         }
      }

      return var9;
   }

   private double h(LivingEntity var1) {

      double var2 = this.i(var1) / Math.max(1.0, this.m.p() / 2.0);
      double var4 = Math.sqrt(a.player.squaredDistanceTo(var1)) / Math.max(1.0, this.l.p());
      double var6 = (double)(var1.getHealth() / Math.max(1.0F, var1.getMaxHealth()));
      double var8 = var2 * 0.6 + var4 * 0.3 + var6 * 0.1;
      if (var1 == this.ac) {
         var8 -= 0.15;
      }

      return var8;
   }

   private double i(Entity var1) {

      Vec3d var2 = a.player.getRotationVec(1.0F);
      Vec3d var3 = var1.getEyePos().subtract(a.player.getEyePos());
      double var4 = var3.length();
      if (var4 < 1.0E-6) {
         return 0.0;
      } else {
         double var6 = MathHelper.clamp(var2.dotProduct(var3.multiply(1.0 / var4)), -1.0, 1.0);
         return Math.toDegrees(Math.acos(var6));
      }
   }
}
