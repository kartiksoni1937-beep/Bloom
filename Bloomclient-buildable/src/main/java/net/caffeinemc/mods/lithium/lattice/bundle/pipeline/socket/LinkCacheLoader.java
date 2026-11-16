package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket;

import java.util.List;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.BufferEncoder;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.CalculateRange;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.InitNotifier;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.ParserEngine;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.CheckerBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.ItemDescriptor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.TimingEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.BufferNormalizer;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.FrameClockCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.GridResolver;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.NodeKeeper;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.SlotInspector;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.TaskJoiner;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.item.Items;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;

public class LinkCacheLoader extends BuilderFactory implements InitNotifier, CalculateRange {
   private final ItemDescriptor f;
   private final CheckerBridge g;
   private final CheckerBridge h;
   private final CheckerBridge i;
   private final CheckerBridge j;
   private final TimingEntry s;
   private final TimingEntry t;
   private final CheckerBridge u;
   private static final long v = 60000000L;
   private long w;
   private long x;
   private boolean y;
   private final Runnable z;
   public static volatile boolean NB;
   private static int aa = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   public LinkCacheLoader() {
      super("", "", ParserEngine.V2);
      this.setName(new char[]{'沙', '泙', '浣', '流', '活', '洰', '淠', '淈', '涣', '涛', '湯', '湁', '渀', '渽', '溸'}, -1012241192, new char[0], -39689550);
      ItemDescriptor var10001 = new ItemDescriptor("", -1, false);
      var10001.n(
         new char[]{'\uea8e', '\ueac0', '\ueb6e', '\ueb58', '\ueb22', '\ueb1c', '\uebe8', '\uebdc', '\ueba2', '\uebc6', '\uec4e', '\uec41', '\uec3a'},
         -260707633
      );
      this.f = var10001;
      CheckerBridge var1 = new CheckerBridge("", true);
      var1.n(new char[]{'\uf88c', '\uf8c0', '率', '聾', '廊', '更', '囹', '炙', '瑩', '曆', '並', '煮', '諸', '猪', '\ufae8', '𢡊', '𣏕'}, -1805715249);
      this.g = var1;
      CheckerBridge var2 = new CheckerBridge("", true);
      var2.n(new char[]{'´', 'Ĵ', 'ŗ', 'Ÿ', 'ĥ', 'Ǜ', 'Ƿ'}, -1884094213);
      this.h = var2;
      CheckerBridge var3 = new CheckerBridge("", true);
      var3.n(new char[]{'ꆷ', 'ꈶ', 'ꉘ', 'ꉶ', 'ꈶ', 'ꋻ', 'ꋆ', 'ꊼ', 'ꊅ', 'ꌰ', 'ꍨ', 'ꌢ', 'ꌄ', 'ꏸ', 'ꏈ', 'ꎢ'}, -1608932871);
      this.i = var3;
      CheckerBridge var4 = new CheckerBridge("", true);
      var4.n(new char[]{'꜓', 'Ꝓ', 'ꟴ', 'Ꞛ', 'ꞛ', 'ꞗ', 'ꡢ', 'ꡘ', '꠶', 'ꠑ'}, -1674401955);
      this.j = var4;
      TimingEntry var5 = new TimingEntry("", 50.0, 500.0, 50.0, 1.0, 50.0, 0.0);
      var5.n(new char[]{'鬧', '鮸', '鯙', '鮵', '鮐', '鱷', '鰑', '鰔', '鰊', '鳢', '鳌', '鲵'}, 707238775);
      this.s = var5;
      TimingEntry var6 = new TimingEntry("", 50.0, 500.0, 50.0, 1.0, 50.0, 0.0);
      var6.n(new char[]{'仛', '亖', '亥', '亓', '佴', '佟', '佳', '伶', '俴', '俜', '侮', '侗'}, -988524903);
      this.t = var6;
      CheckerBridge var7 = new CheckerBridge("", true);
      var7.n(new char[]{'귖', '궁', '궯', '궞', '깸', '긋', '긇', '긆', '껬', '껂'}, -15487600);
      this.u = var7;
      this.z = this::b;
      this.a(new InitAdapter[]{this.f, this.g, this.h, this.i, this.j, this.s, this.t, this.u});
   }

   @Override
   public void c() {

      this.b.a(InitNotifier.class, this);
      this.b.a(CalculateRange.class, this);
      NB = this.j.f();
      long var1 = System.nanoTime();
      this.w = var1;
      this.x = var1;
      this.y = false;
      FrameClockCache.a(this.z);
      super.c();
   }

   @Override
   public void d() {

      this.b.b(InitNotifier.class, this);
      this.b.b(CalculateRange.class, this);
      FrameClockCache.b(this.z);
      this.y = false;
      NB = false;
      super.d();
   }

   @Override
   public void a() {
      byte var1 = 0;

      while (true) {
         switch (var1) {
            case 0:
            default:
               if (aa != 0) {
                  new Object().hashCode();
                  var1 = 1;
                  break;
               }
            case 1:
               NB = this.j.f();
               this.y = false;
               if (a.player != null && a.world != null && a.currentScreen == null && this.e_r63()) {
                  this.y = true;
                  this.c(a.crosshairTarget);
                  var1 = 2;
                  break;
               }

               return;
            case 2:
               return;
         }
      }
   }

   private void b() {

      if (this.y) {
         long var1 = System.nanoTime();
         if (var1 - this.w >= 0L || var1 - this.x >= 0L) {
            if (a.player != null && a.world != null && a.interactionManager != null && a.currentScreen == null && this.e_r63()) {
               this.c(a.player.method_76762(1.0F, a.player));
            }
         }
      }
   }

   private void c(HitResult var1) {

      if (FrameClockCache.n) {
         if (!FrameClockCache.k(a.player)) {
            long var2 = System.nanoTime();
            if (var2 - this.x >= 0L && var1 instanceof EntityHitResult var4) {
               Entity var5 = var4.getEntity();
               if (var5 instanceof EndCrystalEntity) {
                  if (this.g.f()) {
                     BufferNormalizer.d(0);
                  }

                  GridResolver.a(var5, true);
                  if (this.u.f() && !var5.isRemoved()) {
                     CoreCacheKeeper.d(var5);
                  }

                  this.x = d(this.x, var2) + this.t.ns();
               }
            }

            if (var2 - this.w >= 0L
               && var1 instanceof BlockHitResult var6
               && var1.getType() == HitResult.Type.BLOCK
               && a.player.getMainHandStack().isOf(Items.END_CRYSTAL)) {
               BlockPos var7 = var6.getBlockPos();
               if ((TaskJoiner.a(var7, Blocks.OBSIDIAN) || TaskJoiner.a(var7, Blocks.BEDROCK)) && NodeKeeper.a(var7)) {
                  if (this.g.f()) {
                     BufferNormalizer.d(1);
                  }

                  GridResolver.a(var6, true);
                  this.w = d(this.w, var2) + this.s.ns();
               }
            }
         }
      }
   }

   private static long d(long var0, long var2) {

      return var2 - var0 <= 60000000L ? var0 : var2;
   }

   @Override
   public void a(BufferEncoder var1) {

      if (this.i.f()
         && a.player != null
         && a.currentScreen == null
         && a.player.getMainHandStack().isOf(Items.END_CRYSTAL)
         && a.crosshairTarget instanceof BlockHitResult var2
         && var2.getType() == HitResult.Type.BLOCK
         && TaskJoiner.b(var2.getBlockPos())
         && this.e_r63()) {
         var1.b();
      }
   }

   private boolean e_r63() {

      return (this.f.g() == -1 || SlotInspector.a(this.f.g())) && (!this.h.f() || SlotInspector.a(1));
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
