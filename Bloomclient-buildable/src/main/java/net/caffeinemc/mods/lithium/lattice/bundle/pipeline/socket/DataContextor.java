package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket;

import java.util.List;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.ParserEngine;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.BlockCalculator;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.CheckerBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.ItemDescriptor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.SlotEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.RegionPassCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.SortableData;

public final class DataContextor extends BuilderFactory {
   private static final int f = 413325311;
   private final SlotEntry g;
   private final BlockCalculator h;
   private final BlockCalculator i;
   private final BlockCalculator j;
   private final BlockCalculator q;
   private final CheckerBridge r;
   public static volatile boolean ON;
   public static long GMS = -1L;
   public static boolean G_PO;
   public static int G_COL;
   private static DataContextor s;
   private static float t;
   private static float u;
   private static float v;
   private static long w = -1L;
   private static boolean x;
   private static float y;
   private static float z;
   private static float aa;
   private static long ab;
   private static final long ac = 250L;
   private static final float ad = 12.0F;
   private static final float ae = 250.0F;
   private static long af = -1L;
   private static int ag;
   private static final long ah = 50L;

   public DataContextor() {
      super("", "", ParserEngine.Z3);
      this.setName(
         new char[]{'覩', '訣', '詀', '訤', '訝'},
         -281179666,
         new char[]{
            '㏍',
            '㎅',
            '㎺',
            '㎙',
            '㑤',
            '㑞',
            '㑦',
            '㐂',
            '㓨',
            '㓌',
            '㒵',
            '㓁',
            '㕥',
            '㕹',
            '㕘',
            '㔸',
            '㔟',
            '㗯',
            '㖚',
            '㖭',
            '㖗',
            '㘷',
            '㙗',
            '㘹',
            '㘘',
            '㚳',
            '㛗',
            '㚿',
            '㚄',
            '㝦',
            '㝚',
            '㜤',
            '㜉',
            '㟸'
         },
         1231893388
      );
      this.g = new SlotEntry("C.olor M" + "o" + "de", "Theme", "White", "Red", "Green", "Blue", "Cyan", "Purple", "Gold", "Rainbow", "Custom", "Theme");
      BlockCalculator var10001 = new BlockCalculator("", 0.0, 255.0, 255.0, 5.0);
      var10001.n(new char[]{'ｾ', 'ｲ', '．', '￩', 'ￍ', 'ﾷ', 'ﾚ', '6', 'g', '1', '\u0017'}, 685178685);
      this.h = var10001;
      var10001 = new BlockCalculator("", 0.0, 255.0, 255.0, 5.0);
      var10001.n(new char[]{'亨', '伤', '作', '伻', '伓', '俩', '俈', '俤', '侤', '偰', '偄', '倥', '倱'}, 774328043);
      this.i = var10001;
      var10001 = new BlockCalculator("", 0.0, 255.0, 255.0, 5.0);
      var10001.n(new char[]{'ꪠ', 'ꬬ', 'ꭔ', 'ꬳ', 'ꬫ', 'ꬑ', '꯰', 'ꮜ', 'ꮙ', 'ꮖ', '걬', '걝'}, 1798220515);
      this.j = var10001;
      var10001 = new BlockCalculator("", 1.0, 10.0, 3.0, 1.0);
      var10001.n(new char[]{'列', '削', '勢', '勋', '劯', '劂', '劐', '卩', '匝', '匏', '匋', '叿', '叜', '厼'}, 762204741);
      this.q = var10001;
      CheckerBridge var4 = new CheckerBridge("", false);
      var4.n(new char[]{'얷', '온', '왉', '옥', '옚', '웧', '웓', '욳', '웿', '욱', '읳', '읐', '윢'}, -177879577);
      this.r = var4;
      this.a(new InitAdapter[]{this.g, this.h, this.i, this.j, this.q, this.r});
      s = this;
   }

   @Override
   public void c() {

      super.c();
      af = -1L;
      ON = true;
   }

   @Override
   public void d() {

      ON = false;
      super.d();
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

   public static void a(long var0) {

      DataContextor var2 = s;
      if (var2 != null) {
         if (af < 0L || var0 - af >= 50L || var0 < af || a.currentScreen != null) {
            af = var0;
            G_PO = var2.r.f();
            ag = var2.g.g().indexOf(var2.g.f());
         }

         int var3 = ag;
         int var4 = var2.d(var3, var0) & (-1973596360 ^ -1969049401);
         float var5 = (float)(var4 >> 16 & (362798825 ^ 362798614));
         float var6 = (float)(var4 >> 8 & (228492769 ^ 228492574));
         float var7 = (float)(var4 & (-1709959403 ^ -1709959190));
         boolean var8 = var3 == 7;
         long var9 = var0 - w;
         if (w < 0L || var9 < 0L || var9 > 250L) {
            t = var5;
            u = var6;
            v = var7;
            ab = var0 - 250L;
         } else if (var8) {
            if (!x) {
               y = t;
               z = u;
               aa = v;
               ab = var0;
            }

            float var11 = Math.min(1.0F, (float)(var0 - ab) / 250.0F);
            var11 = var11 * var11 * (3.0F - 2.0F * var11);
            t = y + (var5 - y) * var11;
            u = z + (var6 - z) * var11;
            v = aa + (var7 - aa) * var11;
         } else {
            float var13 = 1.0F - (float)Math.exp((double)(-12.0F * (float)var9 * 0.001F));
            t = t + (var5 - t) * var13;
            u = u + (var6 - u) * var13;
            v = v + (var7 - v) * var13;
            if (Math.abs(var5 - t) < 0.5F && Math.abs(var6 - u) < 0.5F && Math.abs(var7 - v) < 0.5F) {
               t = var5;
               u = var6;
               v = var7;
            }
         }

         x = var8;
         w = var0;
         G_COL = Math.round(t) << 16 | Math.round(u) << 8 | Math.round(v);
         GMS = var0;
      }
   }

   public boolean b() {

      return this.r.f();
   }

   public int c(long var1) {

      return this.d(this.g.g().indexOf(this.g.f()), var1);
   }

   private int d(int var1, long var2) {

      switch (var1) {
         case 1:
            return 377387274 ^ 377581134;
         case 2:
            return 1856832460 ^ 1856890298;
         case 3:
            return 664365424 ^ 665849999;
         case 4:
            return -1370574282 ^ -1370597431;
         case 5:
            return -1072915978 ^ -1062823671;
         case 6:
            return -877955375 ^ -883645999;
         case 7:
            float var10 = Math.max(1.0F, this.q.h());
            long var11 = (long)(10000.0F / var10);
            if (var11 <= 0L) {
               var11 = 1L;
            }

            float var7 = (float)(var2 % var11) / (float)var11;
            return e(var7, 0.9F, 1.0F);
         case 8:
            int var9 = Math.min(-535208035 ^ -535208094, Math.max(0, this.h.g()));
            int var5 = Math.min(-572477882 ^ -572477767, Math.max(0, this.i.g()));
            int var6 = Math.min(-214796496 ^ -214796337, Math.max(0, this.j.g()));
            return var9 << 16 | var5 << 8 | var6;
         case 9:
            int var4;
            try {
               var4 = RegionPassCache.i() & (1870475691 ^ 1870843476);
            } catch (Throwable var8) {
               var4 = 0;
            }

            return var4 != 0 ? var4 : -15954176 ^ -823041;
         default:
            return (195935536 ^ 319777487 ^ SortableData.d[1]) & (-1342398054 ^ -1358733723);
      }
   }

   private static int e(float var0, float var1, float var2) {

      int var3 = 0;
      int var4 = 0;
      int var5 = 0;
      if (var1 == 0.0F) {
         var3 = var4 = var5 = (int)(var2 * 255.0F + 0.5F);
      } else {
         float var6 = (var0 - (float)Math.floor((double)var0)) * 6.0F;
         float var7 = var6 - (float)Math.floor((double)var6);
         float var8 = var2 * (1.0F - var1);
         float var9 = var2 * (1.0F - var1 * var7);
         float var10 = var2 * (1.0F - var1 * (1.0F - var7));
         switch ((int)var6) {
            case 0:
               var3 = (int)(var2 * 255.0F + 0.5F);
               var4 = (int)(var10 * 255.0F + 0.5F);
               var5 = (int)(var8 * 255.0F + 0.5F);
               break;
            case 1:
               var3 = (int)(var9 * 255.0F + 0.5F);
               var4 = (int)(var2 * 255.0F + 0.5F);
               var5 = (int)(var8 * 255.0F + 0.5F);
               break;
            case 2:
               var3 = (int)(var8 * 255.0F + 0.5F);
               var4 = (int)(var2 * 255.0F + 0.5F);
               var5 = (int)(var10 * 255.0F + 0.5F);
               break;
            case 3:
               var3 = (int)(var8 * 255.0F + 0.5F);
               var4 = (int)(var9 * 255.0F + 0.5F);
               var5 = (int)(var2 * 255.0F + 0.5F);
               break;
            case 4:
               var3 = (int)(var10 * 255.0F + 0.5F);
               var4 = (int)(var8 * 255.0F + 0.5F);
               var5 = (int)(var2 * 255.0F + 0.5F);
               break;
            case 5:
               var3 = (int)(var2 * 255.0F + 0.5F);
               var4 = (int)(var8 * 255.0F + 0.5F);
               var5 = (int)(var9 * 255.0F + 0.5F);
         }
      }

      return var3 << 16 | var4 << 8 | var5;
   }
}
