package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.text.Text;
import net.minecraft.text.Style;
import net.minecraft.util.Identifier;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.client.font.TextRenderer;import net.minecraft.text.StyleSpriteSource;
public final class NoticeQueue {
   public static final int INFO = 0;
   public static final int OK = 1;
   public static final int ERR = 2;
   public static volatile boolean m = true;
   public static volatile int n = 0;
   private static final int o = 5;
   private static final long p = 260000000L;
   private static final long q = 200000000L;
   private static final float r = 16.0F;
   private static final float s = 0.625F;
   private static final int t = 8;
   private static final int u = 5;
   private static final int v = 7;
   private static final int w = 11;
   private static final int x = 9;
   private static final int y = 34;
   private static final int z = 27;
   private static final int aa = 150;
   private static final int ab = 226;
   private static final int ac = 6;
   private static final List<NoticeQueue.Toast> ad = new ArrayList<>();
   private static volatile long ae = 0L;
   private static long af = 0L;
   private static final int[] ag = new int[8];
   private static final String[] ah = new String[]{"..."};
   private static final Style[] ai = new Style[6];

   private NoticeQueue() {
   }

   public static void a(String var0, String var1) {

      b(var0, var1, 0, 3200L);
   }

   public static void ok(String var0, String var1) {

      b(var0, var1, 1, 3200L);
   }

   public static void err(String var0, String var1) {

      b(var0, var1, 2, 5000L);
   }

   public static void b(String var0, String var1, int var2, long var3) {

      if (var0 != null && !var0.isEmpty()) {
         synchronized (ad) {
            for (NoticeQueue.Toast var7 : ad) {
               if (var7.c == var2 && var7.a.equals(var0) && var7.b.equals(var1 == null ? "" : var1)) {
                  ad.remove(var7);
                  break;
               }
            }

            ad.add(new NoticeQueue.Toast(var0, var1, var2, var3));

            while (ad.size() > 12) {
               ad.remove(0);
            }
         }

         c(var2);
      }
   }

   private static void c(int var0) {

      if (m) {
         try {
            MinecraftClient var1 = MinecraftClient.getInstance();
            if (var1 == null || var1.getSoundManager() == null) {
               return;
            }

            float var2 = Math.min(1.0F, (var0 != 2 && var0 != 1 ? 0.625F : 0.25F) * SyncController.vol());
            if (var2 <= 0.0F) {
               return;
            }

            if (var0 == 2) {
               var1.getSoundManager().play(PositionedSoundInstance.master((SoundEvent)SoundEvents.BLOCK_NOTE_BLOCK_BASS.value(), 0.85F, var2));
            } else if (var0 == 1) {
               var1.getSoundManager().play(PositionedSoundInstance.master((SoundEvent)SoundEvents.BLOCK_NOTE_BLOCK_PLING.value(), 1.45F, var2));
            } else {
               var1.getSoundManager().play(PositionedSoundInstance.master((SoundEvent)SoundEvents.BLOCK_NOTE_BLOCK_HAT.value(), 1.6F, var2));
            }
         } catch (Throwable var3) {
         }
      }
   }

   public static void d(DrawContext var0, int var1) {

      ae = System.currentTimeMillis();
      f(var0, var1, 0, false);
   }

   public static void e(DrawContext var0, int var1) {

      if (System.currentTimeMillis() - ae >= 150L) {
         f(var0, var1, Math.max(0, n), true);
      }
   }

   private static void f(DrawContext var0, int var1, int var2, boolean var3) {

      MinecraftClient var4 = MinecraftClient.getInstance();
      if (var4 != null && var4.textRenderer != null) {
         long var5 = System.nanoTime();
         float var7 = af == 0L ? 0.016F : Math.min(0.1F, (float)(var5 - af) / 1.0E9F);
         af = var5;
         boolean var8 = SyncController.x;
         ArrayList var9;
         synchronized (ad) {
            Iterator var11 = ad.iterator();

            while (var11.hasNext()) {
               NoticeQueue.Toast var12 = (NoticeQueue.Toast)var11.next();
               if (var12.f == 0L && var5 - var12.d > var12.e * 1000000L) {
                  var12.f = var5;
               }

               if (var12.f != 0L && (var8 || var5 - var12.f > 200000000L)) {
                  var11.remove();
               }
            }

            if (ad.isEmpty()) {
               return;
            }

            var9 = new ArrayList<>(ad);
         }

         if (var3) {
            var0.createNewRootLayer();
         }

         int var37 = 2;

         try {
            var37 = Math.round((float)var4.getWindow().getScaleFactor());
         } catch (Throwable var34) {
         }

         int var38 = var37 < 1 ? 0 : (var37 > 6 ? 5 : var37 - 1);
         int var39 = Math.max(1, var37);
         int[] var13 = ThemeCache.e();
         int[] var14 = ThemeCache.f();
         int[] var15 = new int[]{255, 255, 255};
         ag[0] = ThemeCache.m(0, 0, 0, 55);
         ag[1] = ThemeCache.mix(var14, var13, 0.18, 1783204765 ^ 1783204706);
         ag[2] = ThemeCache.mix(var14, var13, 0.04, 1925376330 ^ 1925376437);
         ag[3] = ThemeCache.mix(var15, var13, 0.1, -291443497 ^ -291443672);
         ag[4] = ThemeCache.mix(var14, var15, 0.58, 452664129 ^ 452664254);
         ag[5] = k(0, var13);
         ag[6] = k(1, var13);
         ag[7] = k(2, var13);
         int var16 = 0;
         float var17 = (float)(8 + var2);

         for (int var18 = var9.size() - 1; var18 >= 0 && var16 < 5; var18--) {
            NoticeQueue.Toast var19 = (NoticeQueue.Toast)var9.get(var18);
            if (!Float.isNaN(var19.y) && !var8) {
               var19.y = var19.y + (var17 - var19.y) * (1.0F - (float)Math.exp((double)(-16.0F * var7)));
               if (Math.abs(var17 - var19.y) * (float)var39 < 0.5F) {
                  var19.y = var17;
               }
            } else {
               var19.y = var17;
            }

            float var20;
            float var21;
            if (var8) {
               var20 = 1.0F;
               var21 = 0.0F;
            } else if (var19.f != 0L) {
               float var22 = Math.min(1.0F, (float)(var5 - var19.f) / 2.0E8F);
               var20 = 1.0F - var22 * var22;
               var21 = var22 * var22 * 234.0F;
            } else {
               long var40 = var5 - var19.d;
               if (var40 < 260000000L) {
                  float var24 = (float)var40 / 2.6E8F;
                  var20 = Math.min(1.0F, var24 * 1.6F);
                  var21 = (1.0F - g(var24)) * 234.0F;
               } else {
                  var20 = 1.0F;
                  var21 = 0.0F;
               }
            }

            if (!(var20 <= 0.02F)) {
               if (var19.g != var38) {
                  h(var4, var19, var38);
               }

               int var41 = var19.w;
               float var23 = (float)Math.round(((float)(var1 - var41 - 8) + var21) * (float)var39) / (float)var39;
               float var42 = (float)Math.round(var19.y * (float)var39) / (float)var39;
               int var25 = (int)Math.floor((double)var23);
               int var26 = (int)Math.floor((double)var42);
               float var27 = var23 - (float)var25;
               float var28 = var42 - (float)var26;
               boolean var29 = var27 > 0.0F || var28 > 0.0F;
               if (var29) {
                  var0.getMatrices().pushMatrix();
                  var0.getMatrices().translate(var27, var28);
               }

               try {
                  i(var0, var4, var19, var25, var26, var41, var20);
               } finally {
                  if (var29) {
                     var0.getMatrices().popMatrix();
                  }
               }

               var17 += 39.0F;
               var16++;
            }
         }
      }
   }

   private static float g(float var0) {

      float var1 = 1.70158F;
      float var2 = 2.70158F;
      float var3 = var0 - 1.0F;
      return 1.0F + 2.70158F * var3 * var3 * var3 + 1.70158F * var3 * var3;
   }

   private static void h(MinecraftClient var0, NoticeQueue.Toast var1, int var2) {

      Style var3 = ai[var2];
      var1.h = Text.literal(var1.a).setStyle(var3);
      int var4 = Math.max(
         var0.textRenderer.getWidth(var1.h), var1.b.isEmpty() ? 0 : var0.textRenderer.getWidth(Text.literal(var1.b).setStyle(var3))
      );
      var1.w = Math.max(-871478489 ^ -871478351, Math.min(1348795386 ^ 1348795160, 27 + var4 + 7));
      if (!var1.b.isEmpty()) {
         var1.i = Text.literal(j(var0, var1.b, var1.w - 27 - 7, var3)).setStyle(var3);
      }

      var1.g = var2;
   }

   private static void i(DrawContext var0, MinecraftClient var1, NoticeQueue.Toast var2, int var3, int var4, int var5, float var6) {

      int var7 = var2.c == 1 ? ag[6] : (var2.c == 2 ? ag[7] : ag[5]);
      RasterCache.b(var0, var3 + 1, var4 + 2, var5, 34, 6, l(ag[0], var6));
      RasterCache.b(var0, var3, var4, var5, 34, 6, l(ag[1], var6));
      RasterCache.b(var0, var3 + 1, var4 + 1, var5 - 2, 32, 5, l(ag[2], var6));
      RasterCache.j(var0, var2.c, var3 + 7, var4 + 11, 11, l(var7, var6));
      int var8 = l(ag[3], var6);
      int var9 = l(ag[4], var6);
      int var10 = var3 + 27;
      if (var2.b.isEmpty()) {
         var0.drawText(var1.textRenderer, var2.h, var10, var4 + 13, var8, true);
      } else {
         var0.drawText(var1.textRenderer, var2.h, var10, var4 + 7, var8, true);
         var0.drawText(var1.textRenderer, var2.i, var10, var4 + 7 + 11, var9, false);
      }
   }

   private static String j(MinecraftClient var0, String var1, int var2, Style var3) {

      if (var2 > 8 && var0.textRenderer.getWidth(Text.literal(var1).setStyle(var3)) > var2) {
         Object var4 = ah[0];
         StringBuilder var5 = new StringBuilder();

         for (int var6 = 0; var6 < var1.length(); var6++) {
            String var7 = var5.toString() + var1.charAt(var6) + var4;
            if (var0.textRenderer.getWidth(Text.literal(var7).setStyle(var3)) > var2) {
               break;
            }

            var5.append(var1.charAt(var6));
         }

         return var5.toString() + var4;
      } else {
         return var1;
      }
   }

   private static int k(int var0, int[] var1) {

      if (var0 == 1) {
         return ThemeCache.m(74, 955127902 ^ 955127956, -324119913 ^ -324120045, -204523755 ^ -204523542);
      } else {
         return var0 == 2
            ? ThemeCache.m(-1278727966 ^ -1278728188, 88, 94, -411837587 ^ -411837550)
            : ThemeCache.m(var1[0], var1[1], var1[2], -373077373 ^ -373077380);
      }
   }

   private static int l(int var0, float var1) {

      int var2 = (int)((float)(var0 >>> 24 & (2102644249 ^ 2102644454)) * Math.max(0.0F, Math.min(1.0F, var1)));
      return var2 << 24 | var0 & (662923342 ^ 662476721);
   }

   static {
      for (int var0 = 0; var0 < 6; var0++) {
         ai[var0] = Style.EMPTY.withFont(new StyleSpriteSource.Font(Identifier.of("lithium", "gui_" + (var0 + 1))));
      }
   }

   private static final class Toast {
      final String a;
      final String b;
      final int c;
      final long d;
      final long e;
      float y = Float.NaN;
      long f = 0L;
      int g = -1;
      int w;
      Text h;
      Text i;
      private static int j = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

      Toast(String var1, String var2, int var3, long var4) {
         this.a = var1;
         this.b = var2 == null ? "" : var2;
         this.c = var3;
         this.d = System.nanoTime();
         this.e = var4;
      }
   }
}
