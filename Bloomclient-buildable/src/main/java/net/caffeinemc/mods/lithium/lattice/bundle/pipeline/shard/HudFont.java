package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.texture.TextureSetup;
import net.minecraft.client.gui.render.state.SimpleGuiElementRenderState;
import net.minecraft.util.Identifier;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.resource.Resource;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.gui.ScreenRect;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fStack;

public final class HudFont {
   private static final Identifier ak = Identifier.of("lithium", "f" + "ont/hu" + "d.ttf");
   private static final Identifier al = Identifier.of("lithium", "fon" + "t/gui.ttf");
   private static final int am = 256;
   private static final int an = 1;
   private static final int ao = 40;
   private static final long ap = 200000000L;
   private static final HashMap<Integer, long[]> aq = new HashMap<>();
   private static float ar = 1.0F;
   private static final int as = 95;
   private static final char[] at = a();
   private static final short[] au = b();
   private static Font av;
   private static boolean aw;
   private static boolean ax;
   private static final Map<Integer, HudFont.Atlas> ay = new LinkedHashMap<Integer, HudFont.Atlas>(16, 0.75F, true) {
      private static int a = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

      @Override
      protected boolean removeEldestEntry(Entry<Integer, HudFont.Atlas> var1) {

         if (this.size() <= 40) {
            return false;
         } else {
            try {
               MinecraftClient.getInstance().getTextureManager().destroyTexture(((HudFont.Atlas)var1.getValue()).id);
            } catch (Throwable var3) {
            }

            return true;
         }
      }
   };
   private static final float[] az = new float[3];
   private static final int ba = 256;
   private static final float[] bb = new float[2048];
   private static final float[] bc = new float[2048];
   private static final int[] bd = new int[256];
   private static final int[] be = new int[256];
   private static int bf;
   private static int bg;
   private static int bh;
   private static long bi;
   private static HudFont.Atlas bj;
   private static ScreenRect bk;
   private static final Matrix3x2f bl = new Matrix3x2f();
   private static int bm = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   private static char[] a() {

      StringBuilder var0 = new StringBuilder();

      for (int var1 = -1582572172 ^ -1582572075; var1 <= (2134313539 ^ 2134313660); var1 = (char)(var1 + 1)) {
         var0.append((char)var1);
      }

      for (int var2 = 502157187 ^ 502165395; var2 <= (55081086 ^ 55072857); var2 = (char)(var2 + 1)) {
         var0.append((char)var2);
      }

      for (int var3 = -1256706285 ^ -1256714461; var3 <= (231207746 ^ 231199608); var3 = (char)(var3 + 1)) {
         var0.append((char)var3);
      }

      var0.append((char)(-852115412 ^ -852107136)).append((char)(1488281931 ^ 1488273513)).append((char)(-1522072800 ^ -1522065102));

      for (int var4 = 1371872124 ^ 1371880172; var4 <= (108439647 ^ 108431820); var4 = (char)(var4 + 1)) {
         var0.append((char)var4);
      }

      return var0.toString().toCharArray();
   }

   private static short[] b() {

      int var0 = 0;

      for (char var4 : at) {
         var0 = Math.max(var0, var4);
      }

      short[] var5 = new short[var0 + 1];
      Arrays.fill(var5, (short)-1);

      for (int var6 = 0; var6 < at.length; var6++) {
         var5[at[var6]] = (short)(95 + var6);
      }

      return var5;
   }

   private HudFont() {
   }

   private static Font c(Identifier var0) {

      try {
         Font var2;
         try (InputStream var1 = ((Resource)MinecraftClient.getInstance().getResourceManager().getResource(var0).orElseThrow()).getInputStream()) {
            var2 = Font.createFont(0, var1);
         }

         return var2;
      } catch (Throwable var6) {
         return null;
      }
   }

   private static Font d() {
      byte var0 = 0;

      while (true) {
         switch (var0) {
            case 0:
            default:
               if (bm != 0) {
                  Thread.currentThread().getName().length();
                  var0 = 4;
                  break;
               }
            case 4:
               if (aw) {
                  return av;
               }
            case 3:
               aw = true;
               av = c(ak);
               if (av == null) {
                  av = c(al);
                  var0 = 1;
                  break;
               }
            case 1:
               if (av == null) {
                  ax = true;
                  var0 = 2;
                  break;
               }

               return av;
            case 2:
               return av;
         }
      }
   }

   private static int e(char var0) {
      byte var1 = 0;

      while (true) {
         switch (var1) {
            case 0:
            default:
               if (bm != 0) {
                  Math.abs(Integer.MIN_VALUE);
                  var1 = 1;
                  break;
               }
            case 1:
               if (var0 >= ' ' && var0 <= '~') {
                  return var0 - 32;
               }
            case 2:
               if (var0 < au.length && au[var0] >= 0) {
                  return au[var0];
               }

               return 31;
            case 3:
               return 31;
         }
      }
   }

   private static char f(int var0) {

      return var0 < 95 ? (char)(var0 + 32) : at[var0 - 95];
   }

   private static HudFont.Atlas g(int var0) {

      if (var0 < 1) {
         var0 = 1;
      }

      ar = 1.0F;
      HudFont.Atlas var1 = ay.get(var0);
      if (var1 != null) {
         return var1;
      } else {
         HudFont.Atlas var2 = h(var0);
         if (var2 != null) {
            long var3 = System.nanoTime();
            long[] var5 = aq.get(var0);
            if (var5 == null || var3 - var5[1] > 100000000L) {
               if (aq.size() > 64) {
                  aq.entrySet().removeIf(var2x -> {

                     return var3 - var2x.getValue()[1] > 1000000000L;
                  });
               }

               var5 = new long[]{var3, var3};
               aq.put(var0, var5);
            }

            var5[1] = var3;
            if (var3 - var5[0] < 200000000L) {
               ar = (float)var0 / (float)var2.em;
               return var2;
            }

            aq.remove(var0);
         }

         var1 = i(var0);
         var1.em = var0;
         ay.put(var0, var1);
         return var1;
      }
   }

   private static HudFont.Atlas h(int var0) {

      HudFont.Atlas var1 = null;
      int var2 = -2104265122 ^ -43218527;

      for (HudFont.Atlas var4 : ay.values()) {
         if (var4.ok && var4.em > 0) {
            int var5 = Math.abs(var4.em - var0);
            if (var5 < var2 && var5 * 4 <= var0) {
               var2 = var5;
               var1 = var4;
            }
         }
      }

      return var1;
   }

   private static HudFont.Atlas i(int var0) {

      Identifier var1 = Identifier.of("lithium", "hu" + "d" + "_" + "font_" + var0);
      int var2 = Math.round((float)var0 * 0.875F);
      int var3 = 95 + at.length;
      HudFont.Glyph[] var4 = new HudFont.Glyph[var3];
      int[] var5 = new int[var3];
      NativeImageBackedTexture var6 = null;

      try {
         Font var7 = d();
         if (var7 == null) {
            return new HudFont.Atlas(var1, 1, 1, var2, var4, var5, false);
         } else {
            Font var8 = var7.deriveFont(0, (float)var0);
            FontRenderContext var9 = new FontRenderContext(null, true, false);
            Rectangle[] var10 = new Rectangle[var3];
            int var11 = 0;
            int var12 = 0;
            int var13 = 0;

            for (int var14 = 0; var14 < var3; var14++) {
               GlyphVector var15 = var8.createGlyphVector(var9, String.valueOf(f(var14)));
               var5[var14] = Math.round(var15.getGlyphMetrics(0).getAdvanceX());
               Rectangle var16 = var15.getPixelBounds(var9, 0.0F, 0.0F);
               if (var16.width > 0 && var16.height > 0) {
                  int var17 = var16.width + 2;
                  int var18 = var16.height + 2;
                  if (var11 + var17 > (1883125477 ^ 1883125733) && var11 > 0) {
                     var11 = 0;
                     var12 += var13;
                     var13 = 0;
                  }

                  HudFont.Glyph var19 = new HudFont.Glyph();
                  var19.u = var11;
                  var19.v = var12;
                  var19.w = var17;
                  var19.h = var18;
                  var19.ox = var16.x - 1;
                  var19.oy = var2 + var16.y - 1;
                  var19.adv = var5[var14];
                  var4[var14] = var19;
                  var10[var14] = var16;
                  var11 += var17;
                  var13 = Math.max(var13, var18);
               }
            }

            int var28 = 530832824 ^ 530832568;
            int var29 = Math.max(1, var12 + var13);
            BufferedImage var30 = new BufferedImage(var28, var29, 2);
            Graphics2D var31 = var30.createGraphics();

            try {
               var31.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
               var31.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
               var31.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
               var31.setFont(var8);
               var31.setColor(Color.WHITE);

               for (int var32 = 0; var32 < var3; var32++) {
                  HudFont.Glyph var34 = var4[var32];
                  if (var34 != null) {
                     Rectangle var20 = var10[var32];
                     var31.drawString(String.valueOf(f(var32)), var34.u + 1 - var20.x, var34.v + 1 - var20.y);
                  }
               }
            } finally {
               var31.dispose();
            }

            NativeImage var33 = new NativeImage(NativeImage.Format.RGBA, var28, var29, false);

            for (int var35 = 0; var35 < var29; var35++) {
               for (int var36 = 0; var36 < var28; var36++) {
                  int var21 = var30.getRGB(var36, var35) >>> 24;
                  var21 = (int)Math.round(255.0 * Math.pow((double)var21 / 255.0, 1.15));
                  var33.setColorArgb(var36, var35, var21 << 24 | -368211294 ^ -353208995);
               }
            }

            var6 = new NativeImageBackedTexture(() -> {

               return "lithium-" + "hu" + "d" + "-font";
            }, var33);
            MinecraftClient.getInstance().getTextureManager().registerTexture(var1, var6);
            return new HudFont.Atlas(var1, var28, var29, var2, var4, var5, true);
         }
      } catch (Throwable var27) {
         if (var6 != null) {
            try {
               var6.close();
            } catch (Throwable var25) {
            }
         }

         return new HudFont.Atlas(var1, 1, 1, var2, new HudFont.Glyph[var3], var5, false);
      }
   }

   public static boolean j() {

      try {
         return !ax && d() != null;
      } catch (Throwable var1) {
         return false;
      }
   }

   public static int k(int var0) {

      return Math.round((float)var0 * 0.875F);
   }

   public static int l(char var0, int var1) {

      try {
         if (!ax) {
            HudFont.Atlas var2 = g(var1);
            if (var2.ok) {
               return Math.round((float)var2.adv[e(var0)] * ar);
            }
         }
      } catch (Throwable var3) {
         ax = true;
      }

      return af(String.valueOf(var0), var1);
   }

   public static int m(String var0, int var1) {

      if (var0 != null && !var0.isEmpty()) {
         try {
            if (!ax) {
               HudFont.Atlas var2 = g(var1);
               if (var2.ok) {
                  int var3 = 0;

                  for (int var4 = 0; var4 < var0.length(); var4++) {
                     var3 += var2.adv[e(var0.charAt(var4))];
                  }

                  return ar == 1.0F ? var3 : Math.round((float)var3 * ar);
               }
            }
         } catch (Throwable var5) {
            ax = true;
         }

         return af(var0, var1);
      } else {
         return 0;
      }
   }

   public static int n(DrawContext var0, String var1, int var2, int var3, int var4, int var5, boolean var6) {

      if (var1 != null && !var1.isEmpty()) {
         try {
            if (!ax) {
               HudFont.Atlas var7 = g(var4);
               float var8 = ar;
               if (var7.ok) {
                  x();

                  int var15;
                  try {
                     if (var6) {
                        byte var9 = 1;
                        u(var0, var7, var8, var1, var2 + var9, var3 + var9, t(var5), true);
                     }

                     var15 = u(var0, var7, var8, var1, var2, var3, var5, false);
                  } finally {
                     z(var0);
                  }

                  return var15;
               }
            }
         } catch (Throwable var14) {
            ax = true;
         }

         return ag(var0, var1, var2, var3, var4, var5, var6);
      } else {
         return 0;
      }
   }

   public static int o(DrawContext var0, char var1, int var2, int var3, int var4, int var5, boolean var6) {

      try {
         if (!ax) {
            HudFont.Atlas var7 = g(var4);
            float var8 = ar;
            if (var7.ok) {
               int var9 = e(var1);
               x();

               int var10;
               try {
                  if (var8 == 1.0F) {
                     if (var6) {
                        byte var16 = 1;
                        w(var0, var7, var9, var2 + var16, var3 + var16, t(var5), true);
                     }

                     w(var0, var7, var9, var2, var3, var5, false);
                     return var7.adv[var9];
                  }

                  if (var6) {
                     v(var0, var7, var9, var8, var2 + 1, var3 + 1, 0.0F, t(var5), true);
                  }

                  v(var0, var7, var9, var8, var2, var3, 0.0F, var5, false);
                  var10 = Math.round((float)var7.adv[var9] * var8);
               } finally {
                  z(var0);
               }

               return var10;
            }
         }
      } catch (Throwable var15) {
         ax = true;
      }

      return ag(var0, String.valueOf(var1), var2, var3, var4, var5, var6);
   }

   public static float p(DrawContext var0) {

      Matrix3x2fStack var1 = var0.getMatrices();
      double var2 = Math.max(1.0, (double)MinecraftClient.getInstance().getWindow().getScaleFactor());
      return (float)(Math.sqrt((double)(var1.m00 * var1.m00 + var1.m01 * var1.m01)) * var2);
   }

   public static int q(DrawContext var0, float var1) {

      return Math.max(6, Math.round(var1 * p(var0)));
   }

   public static float r(DrawContext var0, String var1, float var2, float var3, float var4, int var5, boolean var6) {

      if (var1 != null && !var1.isEmpty()) {
         float var7 = p(var0);
         int var8 = Math.max(6, Math.round(var4 * var7));
         Matrix3x2fStack var9 = var0.getMatrices();
         double var10 = Math.max(1.0, (double)MinecraftClient.getInstance().getWindow().getScaleFactor());
         int var12 = (int)Math.round((double)(var9.m00 * var2 + var9.m10 * var3 + var9.m20) * var10);
         int var13 = (int)Math.round((double)(var9.m01 * var2 + var9.m11 * var3 + var9.m21) * var10);
         var9.pushMatrix();

         float var15;
         try {
            var9.identity();
            var9.scale((float)(1.0 / var10), (float)(1.0 / var10));
            int var14 = n(var0, var1, var12, var13, var8, var5, var6);
            var15 = var7 > 0.0F ? (float)var14 / var7 : 0.0F;
         } finally {
            var9.popMatrix();
         }

         return var15;
      } else {
         return 0.0F;
      }
   }

   public static int[] s(DrawContext var0, float var1, float var2, float var3) {

      float var4 = p(var0);
      Matrix3x2fStack var5 = var0.getMatrices();
      double var6 = Math.max(1.0, (double)MinecraftClient.getInstance().getWindow().getScaleFactor());
      int var8 = (int)Math.round((double)(var5.m00 * var1 + var5.m10 * var2 + var5.m20) * var6);
      int var9 = (int)Math.round((double)(var5.m01 * var1 + var5.m11 * var2 + var5.m21) * var6);
      int var10 = Math.max(6, Math.round(var3 * var4));
      var5.pushMatrix();
      var5.identity();
      var5.scale((float)(1.0 / var6), (float)(1.0 / var6));
      x();
      return new int[]{var8, var9, var10};
   }

   private static int t(int var0) {

      int var1 = (int)((float)(var0 >>> 24 & (2061484036 ^ 2061484283)) * 0.45F);
      return var1 << 24;
   }

   private static int u(DrawContext var0, HudFont.Atlas var1, float var2, String var3, int var4, int var5, int var6, boolean var7) {

      if (var2 != 1.0F) {
         float var11 = 0.0F;

         for (int var12 = 0; var12 < var3.length(); var12++) {
            int var13 = e(var3.charAt(var12));
            v(var0, var1, var13, var2, var4, var5, var11, var6, var7);
            var11 += (float)var1.adv[var13] * var2;
         }

         return Math.round(var11);
      } else {
         int var8 = 0;

         for (int var9 = 0; var9 < var3.length(); var9++) {
            int var10 = e(var3.charAt(var9));
            w(var0, var1, var10, var4 + var8, var5, var6, var7);
            var8 += var1.adv[var10];
         }

         return var8;
      }
   }

   private static void v(DrawContext var0, HudFont.Atlas var1, int var2, float var3, int var4, int var5, float var6, int var7, boolean var8) {

      HudFont.Glyph var9 = var1.glyphs[var2];
      if (var9 != null) {
         int var10 = var4 + Math.round(var6 + (float)var9.ox * var3);
         int var11 = var5 + Math.round((float)var9.oy * var3);
         int var12 = Math.max(1, Math.round((float)var9.w * var3));
         int var13 = Math.max(1, Math.round((float)var9.h * var3));
         ac(var0, var1, var8, var10, var11, var12, var13, var9, var7);
      }
   }

   private static void w(DrawContext var0, HudFont.Atlas var1, int var2, int var3, int var4, int var5, boolean var6) {

      HudFont.Glyph var7 = var1.glyphs[var2];
      if (var7 != null) {
         ac(var0, var1, var6, var3 + var7.ox, var4 + var7.oy, var7.w, var7.h, var7, var5);
      }
   }

   public static void x() {

      if (bh > 0 && bh < 64) {
         bh++;
      } else {
         long var0 = System.nanoTime();
         if (bh > 0) {
            bh = 0;
            bg = 0;
            bf = 0;
            bj = null;
         }

         bh = 1;
         bi = var0;
      }
   }

   public static void y() {

      if (bh > 0) {
         bh = 0;
         bg = 0;
         bf = 0;
         bj = null;
      }
   }

   public static void z(DrawContext var0) {

      if (bh > 0 && --bh == 0) {
         ad(var0);
      }
   }

   public static void aa(DrawContext var0) {

      try {
         z(var0);
      } finally {
         var0.getMatrices().popMatrix();
      }
   }

   private static boolean ab(Matrix3x2f var0, Matrix3x2fStack var1) {

      return var0.m00 == var1.m00 && var0.m01 == var1.m01 && var0.m10 == var1.m10 && var0.m11 == var1.m11 && var0.m20 == var1.m20 && var0.m21 == var1.m21;
   }

   private static void ac(DrawContext var0, HudFont.Atlas var1, boolean var2, int var3, int var4, int var5, int var6, HudFont.Glyph var7, int var8) {

      if (bh == 0) {
         var0.drawTexture(RenderPipelines.GUI_TEXTURED, var1.id, var3, var4, (float)var7.u, (float)var7.v, var5, var6, var7.w, var7.h, var1.a, var1.b, var8);
      } else {
         Matrix3x2fStack var9 = var0.getMatrices();
         ScreenRect var10 = var0.scissorStack.peekLast();
         if ((bf | bg) != 0 && (var1 != bj || var10 != bk || !ab(bl, var9) || bf >= (-1660816409 ^ -1660816665) || bg >= (215865770 ^ 215865514))) {
            ad(var0);
         }

         if ((bf | bg) == 0) {
            bj = var1;
            bk = var10;
            bl.set(var9.m00, var9.m01, var9.m10, var9.m11, var9.m20, var9.m21);
         }

         float[] var11 = var2 ? bb : bc;
         int var12 = (var2 ? bf : bg) * 8;
         var11[var12] = (float)var3;
         var11[var12 + 1] = (float)var4;
         var11[var12 + 2] = (float)(var3 + var5);
         var11[var12 + 3] = (float)(var4 + var6);
         var11[var12 + 4] = (float)var7.u / (float)var1.a;
         var11[var12 + 5] = (float)var7.v / (float)var1.b;
         var11[var12 + 6] = (float)(var7.u + var7.w) / (float)var1.a;
         var11[var12 + 7] = (float)(var7.v + var7.h) / (float)var1.b;
         if (var2) {
            bd[bf++] = var8;
         } else {
            be[bg++] = var8;
         }
      }
   }

   private static void ad(DrawContext var0) {

      int var1 = bf + bg;
      if (var1 != 0) {
         try {
            AbstractTexture var2 = MinecraftClient.getInstance().getTextureManager().getTexture(bj.id);
            float[] var3 = new float[var1 * 8];
            int[] var4 = new int[var1];
            System.arraycopy(bb, 0, var3, 0, bf * 8);
            System.arraycopy(bc, 0, var3, bf * 8, bg * 8);
            System.arraycopy(bd, 0, var4, 0, bf);
            System.arraycopy(be, 0, var4, bf, bg);
            float var5 = Float.MAX_VALUE;
            float var6 = Float.MAX_VALUE;
            float var7 = -Float.MAX_VALUE;
            float var8 = -Float.MAX_VALUE;
            int var9 = 0;

            for (int var10 = 0; var9 < var1; var10 += 8) {
               var5 = Math.min(var5, var3[var10]);
               var6 = Math.min(var6, var3[var10 + 1]);
               var7 = Math.max(var7, var3[var10 + 2]);
               var8 = Math.max(var8, var3[var10 + 3]);
               var9++;
            }

            Matrix3x2f var14 = new Matrix3x2f(bl);
            ScreenRect var15 = new ScreenRect((int)var5, (int)var6, (int)(var7 - var5), (int)(var8 - var6)).transformEachVertex(var14);
            if (bk != null) {
               var15 = bk.intersection(var15);
            }

            if (var15 != null) {
               var0.state
                  .addSimpleElement(new HudFont.Run(TextureSetup.of(var2.getGlTextureView(), var2.getSampler()), var14, bk, var15, var3, var4, var1));
            }
         } finally {
            bg = 0;
            bf = 0;
            bj = null;
         }
      }
   }

   public static void ae(DrawContext var0, Identifier var1, float[] var2, int[] var3, int var4) {

      if (var4 > 0) {
         AbstractTexture var5 = MinecraftClient.getInstance().getTextureManager().getTexture(var1);
         Matrix3x2fStack var6 = var0.getMatrices();
         Matrix3x2f var7 = new Matrix3x2f(var6.m00, var6.m01, var6.m10, var6.m11, var6.m20, var6.m21);
         float var8 = Float.MAX_VALUE;
         float var9 = Float.MAX_VALUE;
         float var10 = -Float.MAX_VALUE;
         float var11 = -Float.MAX_VALUE;
         int var12 = 0;

         for (int var13 = 0; var12 < var4; var13 += 8) {
            var8 = Math.min(var8, var2[var13]);
            var9 = Math.min(var9, var2[var13 + 1]);
            var10 = Math.max(var10, var2[var13 + 2]);
            var11 = Math.max(var11, var2[var13 + 3]);
            var12++;
         }

         ScreenRect var14 = var0.scissorStack.peekLast();
         ScreenRect var15 = new ScreenRect(
               (int)Math.floor((double)var8),
               (int)Math.floor((double)var9),
               Math.max(1, (int)Math.ceil((double)var10 - Math.floor((double)var8))),
               Math.max(1, (int)Math.ceil((double)var11 - Math.floor((double)var9)))
            )
            .transformEachVertex(var7);
         if (var14 != null) {
            var15 = var14.intersection(var15);
         }

         if (var15 != null) {
            var0.state
               .addSimpleElement(new HudFont.Run(TextureSetup.of(var5.getGlTextureView(), var5.getSampler()), var7, var14, var15, var2, var3, var4));
         }
      }
   }

   private static int af(String var0, int var1) {

      try {
         TextRenderer var2 = MinecraftClient.getInstance().textRenderer;
         return Math.round((float)(var2.getWidth(var0) * var1) / 8.0F);
      } catch (Throwable var3) {
         return 0;
      }
   }

   private static int ag(DrawContext var0, String var1, int var2, int var3, int var4, int var5, boolean var6) {

      try {
         TextRenderer var7 = MinecraftClient.getInstance().textRenderer;
         Matrix3x2fStack var8 = var0.getMatrices();
         var8.pushMatrix();

         try {
            var8.translate((float)var2, (float)var3);
            float var9 = (float)var4 / 8.0F;
            var8.scale(var9, var9);
            var0.drawText(var7, var1, 0, 0, var5, var6);
         } finally {
            var8.popMatrix();
         }

         return Math.round((float)var7.getWidth(var1) * ah(var4));
      } catch (Throwable var14) {
         return 0;
      }
   }

   private static float ah(int var0) {

      return (float)var0 / 8.0F;
   }

   private static final class Atlas {
      final Identifier id;
      final int a;
      final int b;
      final int c;
      final HudFont.Glyph[] glyphs;
      final int[] adv;
      final boolean ok;
      int em;
      private static int d = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

      Atlas(Identifier var1, int var2, int var3, int var4, HudFont.Glyph[] var5, int[] var6, boolean var7) {
         this.id = var1;
         this.a = var2;
         this.b = var3;
         this.c = var4;
         this.glyphs = var5;
         this.adv = var6;
         this.ok = var7;
      }
   }

   private static final class Glyph {
      int u;
      int v;
      int w;
      int h;
      int ox;
      int oy;
      int adv;
      private static int a = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();
   }

   private static final class Run implements SimpleGuiElementRenderState {
      private final TextureSetup a;
      private final Matrix3x2f b;
      private final ScreenRect d;
      private final ScreenRect e;
      private final float[] f;
      private final int[] g;
      private final int h;
      private static int i = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

      Run(TextureSetup var1, Matrix3x2f var2, ScreenRect var3, ScreenRect var4, float[] var5, int[] var6, int var7) {
         this.a = var1;
         this.b = var2;
         this.d = var3;
         this.e = var4;
         this.f = var5;
         this.g = var6;
         this.h = var7;
      }

      public void setupVertices(VertexConsumer var1) {
         int var2 = 0;
         int var3 = 0;
         int var4 = 0;
         int var5 = 0;

         while (true) {
            switch (var5) {
               case 0:
               default:
                  if (i != 0) {
                     Thread.currentThread().getName().length();
                     var5 = 1;
                     break;
                  }
               case 1:
                  var2 = 0;
                  var3 = 0;
                  var5 = 2;
                  break;
               case 2:
                  if (var2 < this.h) {
                     var4 = this.g[var2];
                     var1.vertex(this.b, this.f[var3], this.f[var3 + 1]).texture(this.f[var3 + 4], this.f[var3 + 5]).color(var4);
                     var1.vertex(this.b, this.f[var3], this.f[var3 + 3]).texture(this.f[var3 + 4], this.f[var3 + 7]).color(var4);
                     var1.vertex(this.b, this.f[var3 + 2], this.f[var3 + 3]).texture(this.f[var3 + 6], this.f[var3 + 7]).color(var4);
                     var1.vertex(this.b, this.f[var3 + 2], this.f[var3 + 1]).texture(this.f[var3 + 6], this.f[var3 + 5]).color(var4);
                     var2++;
                     var3 += 8;
                     var5 = 2;
                     break;
                  }

                  return;
               case 3:
                  return;
            }
         }
      }

      public RenderPipeline pipeline() {

         return RenderPipelines.GUI_TEXTURED;
      }

      public TextureSetup textureSetup() {

         return this.a;
      }

      public ScreenRect scissorArea() {

         return this.d;
      }

      public ScreenRect bounds() {

         return this.e;
      }
   }
}
