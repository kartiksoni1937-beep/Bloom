package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource;

import java.util.List;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.InitNotifier;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.ParserEngine;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.BlockCalculator;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.CheckerBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.ItemDescriptor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.PlacementEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.LockD;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.input.KeyboardInput;
import net.minecraft.client.input.Input;

public final class NodeFilterCache extends BuilderFactory implements InitNotifier {
   private final BlockCalculator q;
   private final BlockCalculator r;
   private final CheckerBridge s;
   private final PlacementEntry t;
   private final BlockCalculator u;
   private final CheckerBridge v;
   private double w;
   private double x;
   private double y;
   private double z;
   private double aa;
   private double ab;
   private double ac;
   private double ad;
   private double ae;
   private float af;
   private float ag;
   private Object ah;

   public NodeFilterCache() {
      super("", "", ParserEngine.Z4);
      this.setName(
         new char[]{'뻗', '뺞', '뺽', '뺋', '뽨', '뽏', '뼪', '뼇'},
         1444986513,
         new char[]{
            '溁',
            '滅',
            '潥',
            '潟',
            '漭',
            '潇',
            '濲',
            '濍',
            '澡',
            '濃',
            '灡',
            '灀',
            '瀭',
            '瀺',
            '瀌',
            '烼',
            '炜',
            '炽',
            '炈',
            '煼',
            '煝',
            '焻',
            '焏',
            '熹',
            '熔',
            '熵',
            '熇',
            '牽',
            '牜',
            '父',
            '牎',
            '狮',
            '狀',
            '犢',
            '犏',
            '獧',
            '獜',
            '獪',
            '猕',
            '珬',
            '珀',
            '玦'
         },
         -2014351668
      );
      BlockCalculator var10001 = new BlockCalculator("", 0.2, 10.0, 1.5, 0.1);
      var10001.n(new char[]{'㺞', '㻂', '㽻', '㽏', '㼬', '㼌'}, -25411891);
      this.q = var10001;
      var10001 = new BlockCalculator("", 0.2, 10.0, 1.2, 0.1);
      var10001.n(new char[]{'ᡔ', '᠏', 'ᠥ', 'ᠭ', '᠊', 'ᣴ', 'ᣟ', 'ᢺ', 'ᢖ', '᤹', 'ᥫ', 'ᤧ', 'ᤓ', '᧰', '᧐'}, -1835722750);
      this.r = var10001;
      CheckerBridge var2 = new CheckerBridge("", true);
      var2.n(new char[]{'앹', '앸', '씚', '어', '연', '얾', '얘', '왠'}, 1997653303);
      this.s = var2;
      PlacementEntry var3 = new PlacementEntry("", 0.0, 1.0, 0.0, 1.0);
      var3.n(new char[]{'넖', '녁', '뇼', '뇈', '놩', '놑', '뉯', '눉', '눘', '눋', '닧', '닜', '늡', '늑'}, 896119120);
      this.t = var3;
      var10001 = new BlockCalculator("", 0.0, 0.9, 0.55, 0.05);
      var10001.n(new char[]{'죻', '죩', '좋', '쥪', '쥋', '줷', '줊', '짨', '짎', '짘'}, -1135294296);
      this.u = var10001;
      CheckerBridge var5 = new CheckerBridge("", false);
      var5.n(
         new char[]{
            '\ueccb',
            '\uec87',
            '\ueca4',
            '\uec8b',
            '\ued69',
            '\ued52',
            '\ued64',
            '\ued2a',
            '\uedec',
            '\uedd5',
            '\ueda5',
            '\uedad',
            '\ued9f',
            '\uee7e',
            '\uee48'
         },
         -1703220086
      );
      this.v = var5;
      this.a(new InitAdapter[]{this.q, this.r, this.s, this.t, this.u, this.v});
   }

   @Override
   public void c() {

      super.c();
      LockD.g = true;
      this.b.a(InitNotifier.class, this);
      this.ah = null;
      if (a.player != null && a.world != null) {
         this.b();
         if (!this.v.f() && a.interactionManager != null && a.interactionManager.isBreakingBlock()) {
            a.interactionManager.cancelBlockBreaking();
         }
      }
   }

   @Override
   public void d() {

      LockD.g = false;
      super.d();
      this.b.b(InitNotifier.class, this);
      this.ah = null;
      if (a.player != null && a.player.input != null && a.player.input.getClass() == Input.class) {
         a.player.input = new KeyboardInput(a.options);
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

   private void b() {

      this.ah = a.player;
      this.w = this.z = a.player.getX();
      this.x = this.aa = a.player.getY() + (double)a.player.getStandingEyeHeight();
      this.y = this.ab = a.player.getZ();
      this.ac = this.ad = this.ae = 0.0;
      this.af = a.player.getYaw();
      this.ag = a.player.getPitch();
   }

   @Override
   public void a() {

      if (a.player != null && a.world != null) {
         if (this.ah != a.player) {
            this.b();
         }

         this.z = this.w;
         this.aa = this.x;
         this.ab = this.y;
         float var1 = this.af;
         double var2 = 0.0;
         double var4 = 0.0;
         double var6 = 0.0;

         try {
            if (a.currentScreen == null) {
               if (a.options.forwardKey.isPressed()) {
                  var2++;
               }

               if (a.options.backKey.isPressed()) {
                  var2--;
               }

               if (a.options.leftKey.isPressed()) {
                  var4++;
               }

               if (a.options.rightKey.isPressed()) {
                  var4--;
               }

               if (a.options.jumpKey.isPressed()) {
                  var6++;
               }

               if (a.options.sneakKey.isPressed()) {
                  var6--;
               }
            }
         } catch (Throwable var21) {
         }

         double var8 = this.q.p();
         double var10 = Math.sqrt(var2 * var2 + var4 * var4);
         double var12 = 0.0;
         double var14 = 0.0;
         if (var10 > 0.0) {
            var2 /= var10;
            var4 /= var10;
            double var16 = (double)MathHelper.sin((double)(var1 * (float) (Math.PI / 180.0)));
            double var18 = (double)MathHelper.cos((double)(var1 * (float) (Math.PI / 180.0)));
            var12 = (var4 * var18 - var2 * var16) * var8;
            var14 = (var2 * var18 + var4 * var16) * var8;
         }

         double var24 = var6 * this.r.p();
         double var25 = MathHelper.clamp(this.u.p(), 0.0, 0.9);
         this.ac = this.ac * var25 + var12 * (1.0 - var25);
         this.ad = this.ad * var25 + var24 * (1.0 - var25);
         this.ae = this.ae * var25 + var14 * (1.0 - var25);
         if (!this.s.f()) {
            Vec3d var20 = Entity.adjustMovementForCollisions(
               null,
               new Vec3d(this.ac, this.ad, this.ae),
               new Box(this.w - 0.1, this.x - 0.1, this.y - 0.1, this.w + 0.1, this.x + 0.1, this.y + 0.1),
               a.world,
               List.of()
            );
            this.ac = var20.x;
            this.ad = var20.y;
            this.ae = var20.z;
         }

         this.w = this.w + this.ac;
         this.x = this.x + this.ad;
         this.y = this.y + this.ae;
      } else {
         this.ah = null;
      }
   }

   public void c(double var1, double var3) {

      this.ag = MathHelper.clamp(this.ag + (float)var3 * 0.15F, -90.0F, 90.0F);
      this.af += (float)var1 * 0.15F;
   }

   public boolean d_r26() {

      return this.ah != null && this.ah == a.player;
   }

   public boolean e_r27() {

      return !this.v.f();
   }

   public float f_r28() {

      return this.af;
   }

   public float g_r29() {

      return this.ag;
   }

   public double h(float var1) {

      return this.z + (this.w - this.z) * (double)var1;
   }

   public double i(float var1) {

      return this.aa + (this.x - this.aa) * (double)var1;
   }

   public double j(float var1) {

      return this.ab + (this.y - this.ab) * (double)var1;
   }
}
