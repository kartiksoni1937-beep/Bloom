package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import java.util.Random;

public final class ThemeCache {
   public static final int CUSTOM = 7;
   public static final ThemeCache.Theme[] ALL = new ThemeCache.Theme[]{
      new ThemeCache.Theme("Sakura", 255, 63, 164, 10, 10, 17),
      new ThemeCache.Theme("Poppy", 214, 69, 80, 18, 8, 10),
      new ThemeCache.Theme("C" + "ornflo" + "w" + "er", 56, 152, 236, 8, 13, 20),
      new ThemeCache.Theme("Jade V" + "ine", 46, 190, 130, 8, 16, 13),
      new ThemeCache.Theme("Marigold", 232, 160, 54, 18, 14, 8),
      new ThemeCache.Theme("Azalea", 236, 106, 168, 18, 9, 15),
      new ThemeCache.Theme("E" + "del" + "w" + "eiss", 168, 172, 184, 12, 12, 14),
      new ThemeCache.Theme("Custom", 125, 104, 201, 10, 10, 17)
   };
   public static int o = 0;
   public static final int[] p = new int[]{125, 104, 201};
   public static final int[] q = new int[]{10, 10, 17};
   private static final long r = 280000000L;
   private static int[] s = null;
   private static int[] t = null;
   private static long u = 0L;

   public static void a() {

      s = null;
      t = null;
   }

   public static void b() {

      int[] var0 = e();
      int[] var1 = f();
      s = new int[]{var0[0], var0[1], var0[2]};
      t = new int[]{var1[0], var1[1], var1[2]};
      u = System.nanoTime();
   }

   public static boolean c() {

      return s != null && System.nanoTime() - u < 280000000L;
   }

   private static float d() {

      if (s == null) {
         return 1.0F;
      } else {
         float var0 = (float)(System.nanoTime() - u) / 2.8E8F;
         if (var0 >= 1.0F) {
            return 1.0F;
         } else {
            if (var0 < 0.0F) {
               var0 = 0.0F;
            }

            return 1.0F - (1.0F - var0) * (1.0F - var0);
         }
      }
   }

   public static int[] e() {

      int[] var0 = j();
      float var1 = d();
      return s != null && !(var1 >= 1.0F) ? l(s, var0, (double)var1) : var0;
   }

   public static int[] f() {

      int[] var0 = bg();
      float var1 = d();
      return t != null && !(var1 >= 1.0F) ? l(t, var0, (double)var1) : var0;
   }

   private ThemeCache() {
   }

   private static int g(int var0) {

      return var0 >= 0 && var0 < ALL.length ? var0 : 0;
   }

   public static int[] h(int var0) {

      return var0 == 7 ? p : ALL[g(var0)].b;
   }

   public static int[] i(int var0) {

      return var0 == 7 ? q : ALL[g(var0)].bg;
   }

   public static int[] j() {

      int var0 = o;
      var0 = var0 >= 0 && var0 < ALL.length ? var0 : 0;
      return var0 == 7 ? p : ALL[var0].b;
   }

   public static int[] bg() {

      int var0 = o;
      var0 = var0 >= 0 && var0 < ALL.length ? var0 : 0;
      return var0 == 7 ? q : ALL[var0].bg;
   }

   public static String k() {

      return ALL[g(o)].a();
   }

   public static int mix(int[] var0, int[] var1, double var2, int var4) {

      if (var2 < 0.0) {
         var2 = 0.0;
      } else if (var2 > 1.0) {
         var2 = 1.0;
      }

      int var5 = (int)Math.round((double)var0[0] + (double)(var1[0] - var0[0]) * var2);
      int var6 = (int)Math.round((double)var0[1] + (double)(var1[1] - var0[1]) * var2);
      int var7 = (int)Math.round((double)var0[2] + (double)(var1[2] - var0[2]) * var2);
      var5 = var5 < 0 ? 0 : (var5 > (-2121709619 ^ -2121709774) ? -1756595601 ^ -1756595568 : var5);
      var6 = var6 < 0 ? 0 : (var6 > (1064003873 ^ 1064004062) ? -780842866 ^ -780842895 : var6);
      var7 = var7 < 0 ? 0 : (var7 > (772668844 ^ 772668755) ? 1312116854 ^ 1312116873 : var7);
      var4 = var4 < 0 ? 0 : (var4 > (-2089006288 ^ -2089006129) ? 810198050 ^ 810198237 : var4);
      return var4 << 24 | var5 << 16 | var6 << 8 | var7;
   }

   public static int[] l(int[] var0, int[] var1, double var2) {

      if (var2 < 0.0) {
         var2 = 0.0;
      } else if (var2 > 1.0) {
         var2 = 1.0;
      }

      return new int[]{
         (int)Math.round((double)var0[0] + (double)(var1[0] - var0[0]) * var2),
         (int)Math.round((double)var0[1] + (double)(var1[1] - var0[1]) * var2),
         (int)Math.round((double)var0[2] + (double)(var1[2] - var0[2]) * var2)
      };
   }

   public static int m(int var0, int var1, int var2, int var3) {

      var3 = var3 < 0 ? 0 : (var3 > (456284492 ^ 456284595) ? 41373529 ^ 41373606 : var3);
      var0 = var0 < 0 ? 0 : (var0 > (-1740535630 ^ -1740535731) ? 1327342262 ^ 1327342153 : var0);
      var1 = var1 < 0 ? 0 : (var1 > (-1482759494 ^ -1482759611) ? -1058118500 ^ -1058118557 : var1);
      var2 = var2 < 0 ? 0 : (var2 > (-66513496 ^ -66513577) ? 688689966 ^ 688690129 : var2);
      return var3 << 24 | var0 << 16 | var1 << 8 | var2;
   }

   public static int n(int var0) {

      return var0 < 0 ? 0 : (var0 > (818470138 ^ 818469893) ? -1418505171 ^ -1418505006 : var0);
   }

   public static final class Theme {
      public final char[] nmE;
      public final int nmK = new Random().nextInt();
      public final int[] b;
      public final int[] bg;
      private static int c = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

      Theme(String var1, int var2, int var3, int var4, int var5, int var6, int var7) {
         this.nmE = new char[var1.length()];

         for (int var8 = 0; var8 < this.nmE.length; var8++) {
            this.nmE[var8] = (char)(var1.charAt(var8) ^ this.nmK + var8 * 31);
         }

         this.b = new int[]{var2, var3, var4};
         this.bg = new int[]{var5, var6, var7};
      }

      public String a() {

         char[] var1 = new char[this.nmE.length];

         for (int var2 = 0; var2 < var1.length; var2++) {
            var1[var2] = (char)(this.nmE[var2] ^ this.nmK + var2 * 31);
         }

         return new String(var1);
      }
   }
}
