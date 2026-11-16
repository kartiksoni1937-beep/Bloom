package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Point2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.image.BufferedImage;

public final class GlyphArrayCache {
   public static final int CELL = 64;
   public static final int MOON = 0;
   public static final int CLOUD = 1;
   public static final int MONITOR = 2;
   public static final int WATCH = 3;
   public static final int PLANE = 4;
   public static final int FLASK = 5;
   public static final int KEYBOARD = 6;
   public static final int PREV = 7;
   public static final int PAUSE = 8;
   public static final int PLAY = 9;
   public static final int NEXT = 10;
   public static final int CHEVRON = 11;
   public static final int EYE = 12;
   public static final int NOTE = 13;
   public static final int CROSS = 14;
   public static final int LIST = 15;
   public static final int DOT = 16;
   public static final int WIFI = 17;
   public static final int HOURGLASS = 18;
   public static final int SPARK = 19;
   public static final int PIP = 20;
   public static final int GEAR = 21;
   public static final int FOLDER = 22;
   public static final int EYE_OFF = 23;
   public static final int PALETTE = 24;
   public static final int CUBE = 25;
   public static final int DOWNLOAD = 26;
   public static final int UPLOAD = 27;
   public static final int TRASH = 28;
   public static final int COPY = 29;
   public static final int PASTE = 30;
   public static final int REFRESH = 31;
   public static final int PENCIL = 32;
   public static final int CHECK = 33;
   public static final int BACK = 34;
   public static final int SAVE = 35;
   public static final int BLOOM = 36;
   public static final int CELLS = 37;

   private GlyphArrayCache() {
   }

   public static int[] a() {

      int var0 = 1006994684 ^ 1006996924;
      int var1 = 768923775 ^ 768923903;
      BufferedImage var2 = new BufferedImage(var0, var1, 2);
      Graphics2D var3 = var2.createGraphics();
      var3.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      var3.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
      var3.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

      for (int var4 = 0; var4 < 37; var4++) {
         AffineTransform var5 = new AffineTransform();
         var5.translate((double)(var4 * 64), 0.0);
         var5.scale(64.0, 64.0);
         if (var4 == 0) {
            h(var3, var5);
         } else if (var4 == 20) {
            i(var3, var5);
         } else if (var4 == 36) {
            j(var3, var5);
         } else {
            Area var6 = f(var4);
            if (var6 != null) {
               var3.setColor(Color.WHITE);
               var3.fill(var6.createTransformedArea(var5));
            }
         }
      }

      var3.dispose();
      int[] var16 = var2.getRGB(0, 0, var0, var1, null, 0, var0);
      int var17 = Math.max(1, Math.round(3.84F));
      int[] var18 = new int[var0 * 64];

      for (int var7 = 0; var7 < var0 * 64; var7++) {
         var18[var7] = var16[var7] >>> 24;
      }

      int[] var19 = new int[var0 * 64];

      for (int var8 = 0; var8 < 3; var8++) {
         for (int var9 = 0; var9 < 64; var9++) {
            for (int var10 = 0; var10 < var0; var10++) {
               int var11 = var10 / 64 * 64;
               int var12 = var11 + 64 - 1;
               int var13 = 0;

               for (int var14 = -var17; var14 <= var17; var14++) {
                  int var15 = var10 + var14;
                  var13 += var15 >= var11 && var15 <= var12 ? var18[var9 * var0 + var15] : 0;
               }

               var19[var9 * var0 + var10] = var13 / (2 * var17 + 1);
            }
         }

         for (int var21 = 0; var21 < 64; var21++) {
            for (int var23 = 0; var23 < var0; var23++) {
               int var25 = 0;

               for (int var26 = -var17; var26 <= var17; var26++) {
                  int var27 = var21 + var26;
                  var25 += var27 >= 0 && var27 < 64 ? var19[var27 * var0 + var23] : 0;
               }

               var18[var21 * var0 + var23] = var25 / (2 * var17 + 1);
            }
         }
      }

      for (int var20 = 0; var20 < 64; var20++) {
         for (int var22 = 0; var22 < var0; var22++) {
            int var24 = Math.min(1919155577 ^ 1919155590, var18[var20 * var0 + var22] * 3 / 2);
            var16[(var20 + 64) * var0 + var22] = var24 << 24 | -828748448 ^ -832195937;
         }
      }

      return var16;
   }

   private static Area b(double var0, double var2, double var4) {

      return new Area(new Double(var0 - var4, var2 - var4, var4 * 2.0, var4 * 2.0));
   }

   private static Area c(double var0, double var2, double var4, double var6, double var8) {

      return new Area(new java.awt.geom.RoundRectangle2D.Double(var0, var2, var4 - var0, var6 - var2, var8 * 2.0, var8 * 2.0));
   }

   private static Area d(Shape var0, double var1) {

      return new Area(new BasicStroke((float)var1, 1, 1).createStrokedShape(var0));
   }

   private static Area e(double[] var0, double var1) {

      java.awt.geom.Path2D.Double var3 = new java.awt.geom.Path2D.Double();
      double var4 = 0.0;
      double var6 = 0.0;
      int var8 = var0.length / 2;

      for (int var9 = 0; var9 < var8; var9++) {
         var4 += var0[var9 * 2];
         var6 += var0[var9 * 2 + 1];
      }

      var4 /= (double)var8;
      var6 /= (double)var8;

      for (int var24 = 0; var24 < var8; var24++) {
         double var10 = var0[var24 * 2];
         double var12 = var0[var24 * 2 + 1];
         double var14 = var4 - var10;
         double var16 = var6 - var12;
         double var18 = Math.sqrt(var14 * var14 + var16 * var16);
         double var20 = var18 > 1.0E-6 ? var1 * 1.6 / var18 : 0.0;
         if (var24 == 0) {
            var3.moveTo(var10 + var14 * var20, var12 + var16 * var20);
         } else {
            var3.lineTo(var10 + var14 * var20, var12 + var16 * var20);
         }
      }

      var3.closePath();
      Area var25 = new Area(var3);
      var25.add(new Area(new BasicStroke((float)(var1 * 2.0), 1, 1).createStrokedShape(var3)));
      return var25;
   }

   static Area f(int var0) {

      switch (var0) {
         case 1:
            Area var37 = b(0.36, 0.56, 0.165);
            var37.add(b(0.56, 0.45, 0.215));
            var37.add(b(0.74, 0.585, 0.14));
            var37.add(c(0.2, 0.56, 0.88, 0.725, 0.08));
            return var37;
         case 2:
            Area var36 = c(0.12, 0.16, 0.88, 0.74, 0.08);
            var36.add(c(0.35, 0.7, 0.65, 0.86, 0.03));
            return var36;
         case 3:
            Area var35 = b(0.5, 0.575, 0.315);
            var35.add(c(0.4, 0.08, 0.6, 0.17, 0.035));
            var35.add(c(0.465, 0.15, 0.535, 0.28, 0.0));
            Area var49 = c(0.74, 0.2, 0.86, 0.29, 0.03);
            var49.transform(AffineTransform.getRotateInstance(Math.toRadians(45.0), 0.8, 0.245));
            var35.add(var49);
            var35.subtract(d(new java.awt.geom.Line2D.Double(0.5, 0.575, 0.5, 0.4), 0.075));
            var35.subtract(b(0.5, 0.575, 0.055));
            return var35;
         case 4:
            Area var34 = e(new double[]{0.88, 0.12, 0.1, 0.47, 0.45, 0.55, 0.53, 0.9}, 0.045);
            var34.subtract(d(new java.awt.geom.Line2D.Double(0.45, 0.55, 0.64, 0.36), 0.06));
            return var34;
         case 5:
            Area var33 = d(new Double(0.24, 0.36, 0.52, 0.52), 0.085);
            var33.add(d(new java.awt.geom.Line2D.Double(0.42, 0.18, 0.42, 0.38), 0.085));
            var33.add(d(new java.awt.geom.Line2D.Double(0.58, 0.18, 0.58, 0.38), 0.085));
            var33.add(d(new java.awt.geom.Line2D.Double(0.35, 0.15, 0.65, 0.15), 0.085));
            Area var48 = b(0.5, 0.62, 0.2);
            var48.intersect(new Area(new java.awt.geom.Rectangle2D.Double(0.0, 0.6, 1.0, 1.0)));
            var33.add(var48);
            return var33;
         case 6:
            Area var32 = c(0.06, 0.22, 0.94, 0.78, 0.1);

            for (int var47 = 0; var47 < 2; var47++) {
               for (int var56 = 0; var56 < 5; var56++) {
                  double var58 = 0.17 + (double)var56 * 0.145;
                  double var59 = 0.33 + (double)var47 * 0.15;
                  var32.subtract(c(var58, var59, var58 + 0.085, var59 + 0.085, 0.015));
               }
            }

            var32.subtract(c(0.3, 0.635, 0.7, 0.705, 0.02));
            return var32;
         case 7:
            Area var31 = c(0.21, 0.12, 0.32, 0.88, 0.04);
            var31.add(e(new double[]{0.31, 0.5, 0.79, 0.14, 0.79, 0.86}, 0.05));
            return var31;
         case 8:
            Area var30 = c(0.18, 0.08, 0.41, 0.92, 0.115);
            var30.add(c(0.59, 0.08, 0.82, 0.92, 0.115));
            return var30;
         case 9:
            return e(new double[]{0.24, 0.1, 0.24, 0.9, 0.88, 0.5}, 0.07);
         case 10:
            Area var29 = c(0.68, 0.12, 0.79, 0.88, 0.04);
            var29.add(e(new double[]{0.69, 0.5, 0.21, 0.14, 0.21, 0.86}, 0.05));
            return var29;
         case 11:
            java.awt.geom.Path2D.Double var28 = new java.awt.geom.Path2D.Double();
            var28.moveTo(0.36, 0.2);
            var28.lineTo(0.66, 0.5);
            var28.lineTo(0.36, 0.8);
            return d(var28, 0.1);
         case 12:
            java.awt.geom.Path2D.Double var27 = new java.awt.geom.Path2D.Double();
            var27.moveTo(0.04, 0.5);
            var27.quadTo(0.5, 0.02, 0.96, 0.5);
            var27.quadTo(0.5, 0.98, 0.04, 0.5);
            var27.closePath();
            Area var46 = new Area(var27);
            var46.subtract(b(0.5, 0.5, 0.19));
            var46.add(b(0.5, 0.5, 0.11));
            return var46;
         case 13:
            Area var26 = new Area(new Double(-0.15, -0.105, 0.3, 0.21));
            var26.transform(AffineTransform.getRotateInstance(Math.toRadians(-22.0)));
            var26.transform(AffineTransform.getTranslateInstance(0.39, 0.74));
            var26.add(c(0.475, 0.16, 0.545, 0.74, 0.0));
            java.awt.geom.Path2D.Double var55 = new java.awt.geom.Path2D.Double();
            var55.moveTo(0.5, 0.14);
            var55.curveTo(0.6, 0.22, 0.8, 0.26, 0.76, 0.46);
            var55.curveTo(0.72, 0.36, 0.62, 0.34, 0.52, 0.33);
            var55.closePath();
            var26.add(new Area(var55));
            return var26;
         case 14:
            Area var25 = d(new java.awt.geom.Line2D.Double(0.28, 0.28, 0.72, 0.72), 0.085);
            var25.add(d(new java.awt.geom.Line2D.Double(0.72, 0.28, 0.28, 0.72), 0.085));
            return var25;
         case 15:
            Area var24 = new Area();

            for (int var45 = 0; var45 < 3; var45++) {
               double var54 = 0.28 + (double)var45 * 0.22;
               var24.add(b(0.2, var54, 0.06));
               var24.add(d(new java.awt.geom.Line2D.Double(0.36, var54, 0.84, var54), 0.09));
            }

            return var24;
         case 16:
            return b(0.5, 0.5, 0.46);
         case 17:
            Area var23 = b(0.5, 0.78, 0.075);

            for (int var44 = 0; var44 < 3; var44++) {
               double var53 = 0.22 + (double)var44 * 0.19;
               var23.add(d(new java.awt.geom.Arc2D.Double(0.5 - var53, 0.78 - var53, var53 * 2.0, var53 * 2.0, 45.0, 90.0, 0), 0.085));
            }

            return var23;
         case 18:
            Area var22 = e(new double[]{0.26, 0.14, 0.74, 0.14, 0.5, 0.5}, 0.03);
            var22.add(e(new double[]{0.5, 0.5, 0.74, 0.86, 0.26, 0.86}, 0.03));
            var22.add(c(0.22, 0.1, 0.78, 0.17, 0.03));
            var22.add(c(0.22, 0.83, 0.78, 0.9, 0.03));
            return var22;
         case 19:
            return g(0.5, 0.5, 0.46);
         case 20:
         default:
            return null;
         case 21:
            Area var21 = b(0.5, 0.5, 0.29);

            for (int var43 = 0; var43 < 8; var43++) {
               Area var52 = c(-0.075, -0.44, 0.075, -0.22, 0.03);
               var52.transform(AffineTransform.getRotateInstance((double)var43 * Math.PI / 4.0));
               var52.transform(AffineTransform.getTranslateInstance(0.5, 0.5));
               var21.add(var52);
            }

            var21.subtract(b(0.5, 0.5, 0.125));
            return var21;
         case 22:
            Area var20 = c(0.08, 0.2, 0.46, 0.4, 0.05);
            var20.add(c(0.08, 0.28, 0.92, 0.82, 0.07));
            var20.subtract(d(new java.awt.geom.Line2D.Double(0.0, 0.415, 1.0, 0.415), 0.05));
            return var20;
         case 23:
            Area var19 = f(12);
            java.awt.geom.Line2D.Double var42 = new java.awt.geom.Line2D.Double(0.16, 0.14, 0.84, 0.86);
            var19.subtract(d(var42, 0.21));
            var19.add(d(var42, 0.085));
            return var19;
         case 24:
            Area var18 = new Area(new Double(0.08, 0.13, 0.84, 0.74));
            var18.subtract(b(0.8, 0.75, 0.15));
            var18.subtract(b(0.63, 0.62, 0.075));
            var18.subtract(b(0.32, 0.36, 0.08));
            var18.subtract(b(0.55, 0.28, 0.08));
            var18.subtract(b(0.26, 0.6, 0.08));
            return var18;
         case 25:
            java.awt.geom.Path2D.Double var17 = new java.awt.geom.Path2D.Double();
            var17.moveTo(0.5, 0.1);
            var17.lineTo(0.85, 0.3);
            var17.lineTo(0.85, 0.7);
            var17.lineTo(0.5, 0.9);
            var17.lineTo(0.15, 0.7);
            var17.lineTo(0.15, 0.3);
            var17.closePath();
            Area var41 = d(var17, 0.085);
            java.awt.geom.Path2D.Double var51 = new java.awt.geom.Path2D.Double();
            var51.moveTo(0.5, 0.1);
            var51.lineTo(0.85, 0.3);
            var51.lineTo(0.5, 0.5);
            var51.lineTo(0.15, 0.3);
            var51.closePath();
            var41.add(new Area(var51));
            var41.add(d(new java.awt.geom.Line2D.Double(0.5, 0.5, 0.5, 0.9), 0.085));
            return var41;
         case 26:
         case 27:
            boolean var16 = var0 == 27;
            Area var40 = d(new java.awt.geom.Line2D.Double(0.5, var16 ? 0.66 : 0.12, 0.5, var16 ? 0.14 : 0.62), 0.095);
            java.awt.geom.Path2D.Double var50 = new java.awt.geom.Path2D.Double();
            double var57 = var16 ? 0.14 : 0.64;
            double var6 = var16 ? 0.2 : -0.2;
            var50.moveTo(0.29, var57 + var6);
            var50.lineTo(0.5, var57);
            var50.lineTo(0.71, var57 + var6);
            var40.add(d(var50, 0.095));
            java.awt.geom.Path2D.Double var8 = new java.awt.geom.Path2D.Double();
            var8.moveTo(0.14, 0.6);
            var8.lineTo(0.14, 0.86);
            var8.lineTo(0.86, 0.86);
            var8.lineTo(0.86, 0.6);
            var40.add(d(var8, 0.095));
            return var40;
         case 28:
            Area var15 = d(new java.awt.geom.Line2D.Double(0.16, 0.25, 0.84, 0.25), 0.085);
            java.awt.geom.Path2D.Double var39 = new java.awt.geom.Path2D.Double();
            var39.moveTo(0.37, 0.25);
            var39.lineTo(0.4, 0.12);
            var39.lineTo(0.6, 0.12);
            var39.lineTo(0.63, 0.25);
            var15.add(d(var39, 0.075));
            java.awt.geom.Path2D.Double var3 = new java.awt.geom.Path2D.Double();
            var3.moveTo(0.25, 0.36);
            var3.lineTo(0.3, 0.88);
            var3.lineTo(0.7, 0.88);
            var3.lineTo(0.75, 0.36);
            var15.add(d(var3, 0.085));
            var15.add(d(new java.awt.geom.Line2D.Double(0.43, 0.46, 0.44, 0.76), 0.07));
            var15.add(d(new java.awt.geom.Line2D.Double(0.57, 0.46, 0.56, 0.76), 0.07));
            return var15;
         case 29:
            Area var14 = d(new java.awt.geom.RoundRectangle2D.Double(0.36, 0.12, 0.5, 0.54, 0.16, 0.16), 0.085);
            var14.subtract(c(0.08, 0.28, 0.72, 0.92, 0.1));
            var14.add(d(new java.awt.geom.RoundRectangle2D.Double(0.14, 0.34, 0.5, 0.54, 0.16, 0.16), 0.085));
            return var14;
         case 30:
            Area var13 = d(new java.awt.geom.RoundRectangle2D.Double(0.19, 0.18, 0.62, 0.72, 0.16, 0.16), 0.085);
            var13.subtract(c(0.31, 0.06, 0.69, 0.3, 0.06));
            var13.add(c(0.36, 0.1, 0.64, 0.27, 0.05));
            var13.add(d(new java.awt.geom.Line2D.Double(0.35, 0.5, 0.65, 0.5), 0.075));
            var13.add(d(new java.awt.geom.Line2D.Double(0.35, 0.67, 0.56, 0.67), 0.075));
            return var13;
         case 31:
            Area var12 = d(new java.awt.geom.Arc2D.Double(0.19, 0.19, 0.62, 0.62, 70.0, 290.0, 0), 0.095);
            double var38 = 0.5 + 0.31 * Math.cos(Math.toRadians(70.0));
            double var4 = 0.5 - 0.31 * Math.sin(Math.toRadians(70.0));
            var12.add(e(new double[]{var38 - 0.03, var4 - 0.15, var38 + 0.17, var4 + 0.01, var38 - 0.03, var4 + 0.15}, 0.025));
            return var12;
         case 32:
            Area var11 = c(0.4, 0.04, 0.6, 0.66, 0.035);
            var11.subtract(new Area(new java.awt.geom.Rectangle2D.Double(0.3, 0.2, 0.4, 0.045)));
            java.awt.geom.Path2D.Double var2 = new java.awt.geom.Path2D.Double();
            var2.moveTo(0.4, 0.7);
            var2.lineTo(0.6, 0.7);
            var2.lineTo(0.5, 0.92);
            var2.closePath();
            var11.add(new Area(var2));
            var11.transform(AffineTransform.getRotateInstance(Math.toRadians(45.0), 0.5, 0.5));
            return var11;
         case 33:
            java.awt.geom.Path2D.Double var10 = new java.awt.geom.Path2D.Double();
            var10.moveTo(0.2, 0.53);
            var10.lineTo(0.41, 0.73);
            var10.lineTo(0.8, 0.29);
            return d(var10, 0.115);
         case 34:
            java.awt.geom.Path2D.Double var9 = new java.awt.geom.Path2D.Double();
            var9.moveTo(0.62, 0.2);
            var9.lineTo(0.34, 0.5);
            var9.lineTo(0.62, 0.8);
            return d(var9, 0.1);
         case 35:
            Area var1 = e(new double[]{0.12, 0.12, 0.7, 0.12, 0.88, 0.3, 0.88, 0.88, 0.12, 0.88}, 0.035);
            var1.subtract(c(0.29, 0.12, 0.62, 0.34, 0.03));
            var1.add(c(0.5, 0.17, 0.57, 0.29, 0.015));
            var1.subtract(c(0.25, 0.52, 0.75, 0.88, 0.04));
            var1.add(c(0.25, 0.85, 0.75, 0.88, 0.0));
            return var1;
      }
   }

   private static Area g(double var0, double var2, double var4) {

      java.awt.geom.Path2D.Double var6 = new java.awt.geom.Path2D.Double();
      double var7 = var4 * 0.18;
      var6.moveTo(var0, var2 - var4);
      var6.quadTo(var0 + var7, var2 - var7, var0 + var4, var2);
      var6.quadTo(var0 + var7, var2 + var7, var0, var2 + var4);
      var6.quadTo(var0 - var7, var2 + var7, var0 - var4, var2);
      var6.quadTo(var0 - var7, var2 - var7, var0, var2 - var4);
      var6.closePath();
      return new Area(var6);
   }

   private static void h(Graphics2D var0, AffineTransform var1) {

      for (int var2 = 10; var2 >= 1; var2--) {
         double var3 = 0.06 + (double)var2 * 0.04;
         var0.setColor(new Color(-756030642 ^ -756030504, 1587586110 ^ 1587586216, 179330294 ^ 179330057, (int)(3.0 + (double)(10 - var2) * 1.4)));
         var0.fill(b(0.48, 0.52, var3).createTransformedArea(var1));
      }

      Area var5 = b(0.46, 0.56, 0.22);
      var5.subtract(b(0.545, 0.465, 0.205));
      var0.setColor(new Color(-672703568 ^ -672703640, 2041083981 ^ 2041084052, 1389315340 ^ 1389315552));
      var0.fill(var5.createTransformedArea(var1));

      for (int var6 = 6; var6 >= 1; var6--) {
         var0.setColor(new Color(106, 96, 1983940308 ^ 1983940139, 12 + (6 - var6) * 8));
         var0.fill(b(0.63, 0.39, 0.04 + (double)var6 * 0.025).createTransformedArea(var1));
      }

      var0.setColor(new Color(126, 120, 653995454 ^ 653995342));
      var0.fill(g(0.63, 0.39, 0.09).createTransformedArea(var1));
   }

   private static void i(Graphics2D var0, AffineTransform var1) {

      Area var2 = c(0.04, 0.04, 0.96, 0.96, 0.31);
      Area var3 = var2.createTransformedArea(var1);
      var0.setColor(new Color(-1202889285 ^ -1202889363, 80850326 ^ 80850240, -522322317 ^ -522322267));
      var0.fill(var3);
      Shape var4 = var0.getClip();
      var0.clip(var3);

      for (int var5 = 8; var5 >= 1; var5--) {
         double var6 = 0.08 + (double)var5 * 0.05;
         var0.setColor(new Color(-2072950909 ^ -2072950916, -1516116537 ^ -1516116680, 1725936819 ^ 1725936716, 18 + (8 - var5) * 9));
         var0.fill(b(0.36, 0.3, var6).createTransformedArea(var1));
      }

      var0.setClip(var4);
   }

   private static void j(Graphics2D var0, AffineTransform var1) {

      double var2 = 0.5;
      double var4 = 0.5;
      Color var6 = new Color(1669307498 ^ 1669307570, 69, 122);
      float var7 = (float)var1.getScaleX();
      BasicStroke var8 = new BasicStroke(0.034F * var7, 1, 1);
      BasicStroke var9 = new BasicStroke(0.014F * var7, 1, 1);
      java.awt.geom.Path2D.Double var10 = new java.awt.geom.Path2D.Double();
      var10.moveTo(0.0, -0.02);
      var10.curveTo(-0.05, -0.07, -0.135, -0.19, -0.2, -0.29);
      var10.curveTo(-0.24, -0.4, -0.125, -0.47, -0.058, -0.452);
      var10.lineTo(0.0, -0.37);
      var10.lineTo(0.058, -0.452);
      var10.curveTo(0.125, -0.47, 0.24, -0.4, 0.2, -0.29);
      var10.curveTo(0.135, -0.19, 0.05, -0.07, 0.0, -0.02);
      var10.closePath();
      java.awt.geom.Path2D.Double var11 = new java.awt.geom.Path2D.Double();
      var11.moveTo(-0.01, -0.12);
      var11.curveTo(-0.05, -0.22, -0.09, -0.3, -0.085, -0.4);
      java.awt.geom.Path2D.Double var12 = new java.awt.geom.Path2D.Double();
      var12.moveTo(0.01, -0.12);
      var12.curveTo(0.05, -0.22, 0.09, -0.3, 0.085, -0.4);
      var0.setColor(new Color(1220580873 ^ 1220581095, 124, 333854508 ^ 333854602));
      var0.fill(var1.createTransformedShape(new Double(var2 - 0.15, var4 - 0.15, 0.3, 0.3)));

      for (int var13 = 0; var13 < 5; var13++) {
         AffineTransform var14 = new AffineTransform(var1);
         var14.translate(var2, var4);
         var14.rotate((double)var13 * Math.PI * 2.0 / 5.0);
         Shape var15 = var14.createTransformedShape(var10);
         Point2D var16 = var14.transform(new java.awt.geom.Point2D.Double(0.0, -0.08), null);
         Point2D var17 = var14.transform(new java.awt.geom.Point2D.Double(0.0, -0.44), null);
         var0.setPaint(
            new GradientPaint(
               var16,
               new Color(-1050822686 ^ -1050822900, 124, 1777789118 ^ 1777788952),
               var17,
               new Color(-1288528656 ^ -1288528884, 1544173199 ^ 1544173145, -586567105 ^ -586566949)
            )
         );
         var0.fill(var15);
         Shape var18 = var0.getClip();
         var0.clip(var15);
         Point2D var19 = var14.transform(new java.awt.geom.Point2D.Double(0.0, -0.3), null);
         float var20 = (float)(0.17 * var1.getScaleX());
         var0.setPaint(
            new RadialGradientPaint(
               var19,
               var20,
               new float[]{0.0F, 1.0F},
               new Color[]{
                  new Color(1967698326 ^ 1967698281, -1726392521 ^ -1726392357, 1937152272 ^ 1937152483, 120),
                  new Color(1725628033 ^ 1725628030, -1413453206 ^ -1413453178, 826446593 ^ 826446834, 0)
               }
            )
         );
         var0.fill(var15);
         var0.setStroke(var9);
         var0.setColor(new Color(-957258191 ^ -957258034, -2036535403 ^ -2036535433, 717357960 ^ 717357924, -212141416 ^ -212141554));
         var0.draw(var14.createTransformedShape(var11));
         var0.draw(var14.createTransformedShape(var12));
         Point2D var21 = var14.transform(new java.awt.geom.Point2D.Double(0.095, -0.36), null);
         float var22 = (float)(0.05 * var1.getScaleX());
         var0.setPaint(
            new RadialGradientPaint(
               var21,
               var22,
               new float[]{0.0F, 0.55F, 1.0F},
               new Color[]{
                  new Color(-1781456273 ^ -1781456240, -1191313308 ^ -1191313253, 1683378157 ^ 1683377938, 656846441 ^ 656846526),
                  new Color(2114218735 ^ 2114218512, 1465011485 ^ 1465011682, -1482017787 ^ -1482017542, 90),
                  new Color(-1415814234 ^ -1415814311, -1180053902 ^ -1180053875, -1679722111 ^ -1679722114, 0)
               }
            )
         );
         var0.fill(var14.createTransformedShape(new Double(0.05, -0.42, 0.09, 0.12)));
         var0.setClip(var18);
         var0.setStroke(var8);
         var0.setColor(var6);
         var0.draw(var15);
      }

      double var23 = 0.088;
      Shape var24 = var1.createTransformedShape(new Double(var2 - var23, var4 - var23, var23 * 2.0, var23 * 2.0));
      Point2D var25 = var1.transform(new java.awt.geom.Point2D.Double(var2 - 0.03, var4 - 0.035), null);
      var0.setPaint(
         new RadialGradientPaint(
            var25,
            (float)(var23 * 1.5 * var1.getScaleX()),
            new float[]{0.0F, 0.5F, 1.0F},
            new Color[]{
               new Color(2021208731 ^ 2021208678, -1119153193 ^ -1119153359, -2075255727 ^ -2075255617),
               new Color(2122665690 ^ 2122665518, -2116030235 ^ -2116030394, -1790844728 ^ -1790844920),
               new Color(-425364769 ^ -425364933, 116, 156)
            }
         )
      );
      var0.fill(var24);
      var0.setStroke(new BasicStroke(0.026F * var7, 1, 1));
      var0.setColor(var6);
      var0.draw(var24);
      var0.setColor(new Color(736080428 ^ 736080595, -1248071217 ^ -1248071376, -785071811 ^ -785071678, 368428487 ^ 368428315));
      var0.fill(var1.createTransformedShape(new Double(var2 - 0.052, var4 - 0.06, 0.04, 0.03)));
   }
}
