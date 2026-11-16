package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.InitNotifier;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.ParserEngine;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.BlockCalculator;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.CheckerBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.ItemDescriptor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.BufferNormalizer;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.SlotInspector;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.BindingBridge;
import net.minecraft.util.Hand;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.client.gui.screen.ingame.HandledScreen;

public final class PoolCoordResolver extends BuilderFactory implements InitNotifier {
   public static PoolCoordResolver I;
   public static volatile boolean ARM;
   private final BlockCalculator i;
   private final BlockCalculator j;
   private final CheckerBridge k;
   private final CheckerBridge l;
   private final BlockCalculator m;
   private final CheckerBridge n;
   private final CheckerBridge o;
   private final CheckerBridge p;
   private final CheckerBridge q;
   private final CheckerBridge r;
   private final CheckerBridge s;
   private final CheckerBridge t;
   private final CheckerBridge u;

   public PoolCoordResolver() {
      super("", "", ParserEngine.PC);
      this.setName(
         new char[]{'칔', '츱', '칌', '츴', '츛', '컼', '컟', '캫', '캺', '콸', '콂', '콵', '켢', '쾡'},
         -1409757696,
         new char[]{
            '\ue26d',
            '\ue26a',
            '\ue20a',
            '\ue2f6',
            '\ue2d2',
            '\ue2e0',
            '\ue2a8',
            '\ue296',
            '\ue37c',
            '\ue348',
            '\ue33e',
            '\ue30c',
            '\ue3fc',
            '\ue3ca',
            '\ue3f7',
            '\ue39f',
            '\ue466',
            '\ue414',
            '\ue426',
            '\ue41c',
            '\ue4f5',
            '\ue4d5',
            '\ue4bd',
            '\ue4ce',
            '\ue574',
            '\ue543',
            '\ue53e',
            '\ue518',
            '\ue5a9',
            '\ue5cb',
            '\ue5b5',
            '\ue589',
            '\ue676',
            '\ue657',
            '\ue62b',
            '\ue603',
            '\ue6e8',
            '\ue6d2',
            '\ue693',
            '\ue6fe',
            '\ue692',
            '\ue772',
            '\ue71b',
            '\ue73b',
            '\ue759',
            '\ue7ee',
            '\ue7d6',
            '\ue7a4',
            '\ue79c',
            '\ue871',
            '\ue857',
            '\ue872',
            '\ue810',
            '\ue8e4',
            '\ue8db',
            '\ue8af',
            '\ue88e',
            '\ue967',
            '\ue906',
            '\ue929',
            '\ue901',
            '\ue9e9',
            '\ue9d5',
            '\ue9a1',
            '\ue980',
            '\uea24',
            '\uea57',
            '\uea2b',
            '\uea0c',
            '\ueae9',
            '\ueaf1',
            '\uead9'
         },
         -511581659
      );
      BlockCalculator var10001 = new BlockCalculator("", 50.0, 100.0, 85.0, 1.0);
      var10001.n(new char[]{'\ue5cd', '\ue583', '\ue5a4', '\ue58a', '\ue678', '\ue64e', '\ue62d', '\ue647', '\ue6cb', '\ue6cc', '\ue6aa'}, 1778443662);
      this.i = var10001;
      var10001 = new BlockCalculator("", 50.0, 100.0, 95.0, 1.0);
      var10001.n(new char[]{'媤', '嬨', '孍', '嬥', '嬑', '寥', '寄', '寠', '宒', '実', '履'}, -1068672281);
      this.j = var10001;
      CheckerBridge var2 = new CheckerBridge("", true);
      var2.n(new char[]{'배', '벯', '볅', '볎', '벫', '범', '뵮', '뵞', '뵺', '봪', '뷨', '뷅', '붿', '붛', '빠'}, -1761690526);
      this.k = var2;
      CheckerBridge var3 = new CheckerBridge("", true);
      var3.n(new char[]{'ꩡ', 'ꩯ', 'ꨒ', 'ꨖ', 'ꫪ', 'ꪝ', 'ꪓ', 'ꪕ', 'ꭶ', 'ꭀ', 'ꭸ', 'ꬾ', '꯸', 'ꮕ', 'ꮕ', 'ꮚ', '걠'}, 183151138);
      this.l = var3;
      var10001 = new BlockCalculator("", 0.0, 100.0, 0.0, 1.0);
      var10001.n(new char[]{'꿰', '꿲', '꾒', '끩', '끊', '끸', '뀴', '냾', '냔', '낺', '낐', '녷'}, -852381763);
      this.m = var10001;
      CheckerBridge var5 = new CheckerBridge("", false);
      var5.n(new char[]{'ゥ', 'ㄧ', 'ㅆ', 'ㅧ', 'ㄪ', '㇠', '㇂', 'ㆷ', '㇂', '㉂', '㉌', '㉖', '㈽', '㈖'}, -1292095254);
      this.n = var5;
      CheckerBridge var6 = new CheckerBridge("", false);
      var6.n(new char[]{'ꖟ', 'ꗉ', 'ꙮ', 'Ꙍ', '꘨', 'ꘆ', 'ꚢ', '꛴', 'ꚳ', 'ꚺ'}, -1262377528);
      this.o = var6;
      CheckerBridge var7 = new CheckerBridge("", false);
      var7.n(
         new char[]{
            '\uf695',
            '\uf6cf',
            '\uf76f',
            '\uf76d',
            '\uf755',
            '\uf77d',
            '\uf735',
            '\uf7f5',
            '\uf79a',
            '\uf78a',
            '\uf79b',
            '\uf865',
            '\uf853',
            '\uf830',
            '\uf81a'
         },
         -701958462
      );
      this.p = var7;
      CheckerBridge var8 = new CheckerBridge("", false);
      var8.n(new char[]{'劅', '勍', '卮', '卍', '占', '化', '匊', '司', '发', '厨'}, 1140019908);
      this.q = var8;
      CheckerBridge var9 = new CheckerBridge("", false);
      var9.n(new char[]{'⣗', '⢛', '⢸', '⢟', '⤲', '⥴', '⤾', '⤛', '⧧', '⧙', '⦥', '⦎', '⩹'}, -1847711594);
      this.r = var9;
      CheckerBridge var10 = new CheckerBridge("", false);
      var10.n(new char[]{'宙', '寇', '屼', '展', '尧', '尜', '岤', '峡', '岻', '岑', '嵡', '嵬', '嵍'}, -893887542);
      this.s = var10;
      CheckerBridge var11 = new CheckerBridge("", true);
      var11.n(new char[]{'칌', '츐', '츪', '츕', '컵', '컝', '컹', '캰', '콶', '콘', '켱'}, 1906167327);
      this.t = var11;
      CheckerBridge var12 = new CheckerBridge("", false);
      var12.n(new char[]{'ⷮ', 'ⷢ', 'ⶇ', '\u2e63', '⹊', '⸣', '⹇', '⻕', '⻌', '⺩', '⺖', '⽮', '⽀', '⼴', '⼶', '⼑', '⿳'}, -646632019);
      this.u = var12;
      this.a(new InitAdapter[]{this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u});
      I = this;
   }

   @Override
   public void c() {

      this.b.a(InitNotifier.class, this);
      super.c();
   }

   @Override
   public void d() {

      ARM = false;
      this.b.b(InitNotifier.class, this);
      super.d();
   }

   public static void b() {

      PoolCoordResolver var0 = I;
      if (var0 != null && var0.f() && a.world != null) {
         var0.f_r73();
      }
   }

   @Override
   public void a() {

      ARM = a.player != null
         && this.n.f()
         && SlotInspector.a(0)
         && (a.currentScreen == null || this.p.f() && !(a.currentScreen instanceof HandledScreen))
         && (this.q.f() || a.player.getMainHandStack().isIn(ItemTags.SWORDS) || a.player.getMainHandStack().getItem() instanceof AxeItem);
      if (this.p.f() && a.currentScreen != null && a.world != null) {
         this.f_r73();
      }
   }

   private void f_r73() {

      try {
         this.g_r74();
      } catch (Throwable var2) {
      }
   }

   private void g_r74() {

      if (a.player != null && a.world != null && a.interactionManager != null) {
         if (!(a.player.getHealth() <= 0.0F)) {
            if (!(a.currentScreen instanceof HandledScreen)) {
               if (!this.n.f() || SlotInspector.a(0)) {
                  if (this.o.f() || !a.player.isBlocking() && !a.player.isUsingItem()) {
                     ItemStack var1 = a.player.getMainHandStack();
                     if (this.q.f() || var1.isIn(ItemTags.SWORDS) || var1.getItem() instanceof AxeItem) {
                        Entity var2 = a.targetedEntity;
                        if (var2 instanceof LivingEntity var3) {
                           if (!(var3.getHealth() <= 0.0F) && var3.isAlive()) {
                              boolean var4 = var2 instanceof PlayerEntity || this.r.f() || this.s.f() && var2 instanceof ZombieEntity;
                              if (var4) {
                                 if (var2 instanceof PlayerEntity var5) {
                                    BindingBridge var6 = ConfigBridge.c != null ? ConfigBridge.c.e() : null;
                                    if (var6 != null && !var6.d() && var6.a(var5)) {
                                       return;
                                    }
                                 }

                                 if (!(a.player.getAttackCooldownProgress(0.5F) < this.h_r75())) {
                                    if (a.player.isOnGround()) {
                                       if (this.k.f() && !a.player.isSprinting()) {
                                          return;
                                       }
                                    } else if (this.l.f() && a.player.getVelocity().y > -0.1) {
                                       return;
                                    }

                                    int var7 = this.m.g();
                                    if (var7 > 0 && ThreadLocalRandom.current().nextInt(100) < var7) {
                                       if (this.t.f()) {
                                          a.player.swingHand(Hand.MAIN_HAND);
                                       }

                                       a.player.resetTicksSinceLastAttack();
                                       if (this.u.f()) {
                                          BufferNormalizer.d(0);
                                       }
                                    } else {
                                       a.interactionManager.attackEntity(a.player, var2);
                                       if (this.t.f()) {
                                          a.player.swingHand(Hand.MAIN_HAND);
                                       }

                                       if (this.u.f()) {
                                          BufferNormalizer.d(0);
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
         }
      }
   }

   private float h_r75() {

      int var1 = this.i.g();
      int var2 = this.j.g();
      double var3 = var2 > var1 ? (double)var1 + Math.random() * (double)(var2 - var1) : (double)var1;
      return (float)(var3 / 100.0);
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
