package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderPipeline.Snippet;
import com.mojang.blaze3d.platform.DepthTestFunction;
import java.util.LinkedHashMap;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.render.OutputTarget;
import net.minecraft.client.render.RenderSetup;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.BufferAllocator;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Vector4f;

public final class PlateBatchCache {
   public static float[] SX = new float[256];
   public static float[] SY = new float[256];
   public static float[] SW = new float[256];
   public static float[] SH = new float[256];
   public static float[] SR = new float[256];
   public static int[] SC = new int[256];
   public static float ox;
   public static float oy;
   public static float oz;
   public static float exx;
   public static float exy;
   public static float exz;
   public static float eyx;
   public static float eyy;
   public static float eyz;
   public static float fbW = 1.0F;
   public static float fbH = 1.0F;
   private static final float f = 0.0F;
   private static final Matrix4f g = new Matrix4f();
   private static final Vector4f h = new Vector4f();
   private static final int i = 6;
   private static final float[][] j = new float[7][];
   private static final float[][] k = new float[7][];
   private static final int l = 28;
   private static final float[] m = new float[28];
   private static final float[] n = new float[28];
   private static final float[] o = new float[28];
   private static final float[] p = new float[28];
   private static final float[] q = new float[28];
   private static final float[] r = new float[28];
   private static final float[] s = new float[28];
   private static final float[] t = new float[28];
   private static final float[] u = new float[28];
   private static final float[] v = new float[28];
   private static final String[] w = new String[]{
      "lithium", "pipeline/tag_plates", "lithium_t" + "ag_plates", "pipeli" + "ne/" + "tag_items", "lithium_" + "t" + "ag_items", "Sampler0"
   };
   public static RenderLayer PLATES;
   public static RenderLayer ITEMS;
   public static VertexConsumerProvider.Immediate IMM;
   public static PlateTextCache TEXT;
   private static BufferAllocator x;
   private static boolean y;
   private static int aa = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   private PlateBatchCache() {
   }

   public static void a(int var0) {
      int var1 = 0;
      byte var2 = 0;

      label16:
      while (true) {
         switch (var2) {
            case 0:
            default:
               if (aa != 0) {
                  new Object().hashCode();
                  var2 = 1;
                  break;
               }
            case 1:
               if (var0 <= SX.length) {
                  return;
               }
            case 2:
               break label16;
         }
      }

      var1 = Math.max(var0, SX.length * 2);
      SX = new float[var1];
      SY = new float[var1];
      SW = new float[var1];
      SH = new float[var1];
      SR = new float[var1];
      SC = new int[var1];
   }

   public static boolean b(Matrix4fc var0, Matrix4fc var1) {

      Matrix4f var2 = g;
      Vector4f var3 = h;
      var2.set(var0).mul(var1).invert();
      float var4 = fbW;
      float var5 = fbH;
      if (var4 >= 1.0F && var5 >= 1.0F) {
         var2.transform(var3.set(-1.0F, 1.0F, 0.0F, 1.0F));
         float var6 = 1.0F / var3.w;
         float var7 = var3.x * var6;
         float var8 = var3.y * var6;
         float var9 = var3.z * var6;
         var2.transform(var3.set(1.0F, 1.0F, 0.0F, 1.0F));
         var6 = 1.0F / var3.w;
         float var10 = var3.x * var6;
         float var11 = var3.y * var6;
         float var12 = var3.z * var6;
         var2.transform(var3.set(-1.0F, -1.0F, 0.0F, 1.0F));
         var6 = 1.0F / var3.w;
         float var13 = var3.x * var6;
         float var14 = var3.y * var6;
         float var15 = var3.z * var6;
         float var16 = var7 + var8 + var9 + var10 + var11 + var12 + var13 + var14 + var15;
         if (var16 - var16 != 0.0F) {
            return false;
         } else {
            ox = var7;
            oy = var8;
            oz = var9;
            exx = (var10 - var7) / var4;
            exy = (var11 - var8) / var4;
            exz = (var12 - var9) / var4;
            eyx = (var13 - var7) / var5;
            eyy = (var14 - var8) / var5;
            eyz = (var15 - var9) / var5;
            return true;
         }
      } else {
         return false;
      }
   }

   public static boolean c() {

      if (IMM != null && TEXT != null) {
         return true;
      } else if (y) {
         return false;
      } else {
         try {
            d();
         } catch (Throwable var1) {
            y = true;
            IMM = null;
            TEXT = null;
            return false;
         }

         return IMM != null && TEXT != null;
      }
   }

   private static void d() {

      RenderPipeline var0 = RenderPipeline.builder(new Snippet[]{RenderPipelines.POSITION_COLOR_SNIPPET})
         .withLocation(Identifier.of(w[0], w[1]))
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build();
      RenderLayer var1 = RenderLayer.of(
         w[2], RenderSetup.builder(var0).outputTarget(OutputTarget.MAIN_TARGET).expectedBufferSize(2022696074 ^ 2022630538).build()
      );
      RenderPipeline var2 = RenderPipeline.builder(new Snippet[]{RenderPipelines.POSITION_TEX_COLOR_SNIPPET})
         .withLocation(Identifier.of(w[0], w[3]))
         .withBlend(BlendFunction.TRANSLUCENT_PREMULTIPLIED_ALPHA)
         .withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST)
         .withDepthWrite(false)
         .withCull(false)
         .build();
      RenderLayer var3 = RenderLayer.of(
         w[4],
         RenderSetup.builder(var2)
            .texture(w[5], PlateIconCache.ID)
            .outputTarget(OutputTarget.MAIN_TARGET)
            .expectedBufferSize(734931186 ^ 734935282)
            .build()
      );
      BufferAllocator var4 = new BufferAllocator(-1580221220 ^ -1580286756);
      PlateTextCache var5 = new PlateTextCache(new BufferAllocator(-1919170843 ^ -1919187227), new LinkedHashMap<>());
      PLATES = var1;
      ITEMS = var3;
      x = var4;
      IMM = VertexConsumerProvider.immediate(var4);
      TEXT = var5;
   }

   public static void end() {

      VertexConsumerProvider.Immediate var0 = IMM;
      PlateTextCache var1 = TEXT;
      if (var0 != null && var1 != null) {
         try {
            var0.draw();
            var1.draw();
            var1.trim();
         } catch (Throwable var3) {
         }
      }
   }

   public static void e(VertexConsumer var0, int var1) {

      assert var1 >= 0
         && var1 <= SX.length
         && SY.length == SX.length
         && SW.length == SX.length
         && SH.length == SX.length
         && SR.length == SX.length
         && SC.length == SX.length
         && m.length == 28
         && n.length == 28
         && o.length == 28
         && p.length == 28
         && q.length == 28
         && v.length == 28
         && j.length == 7
         && k.length == 7
         && j[1] != null
         && k[6] != null
         && var0 != null
         && exx == exx
         && eyy == eyy
         && ox == ox
         && oy == oy
         && oz == oz : "plates";

      float var2 = 1.0F;
      float var3 = 0.5F;
      float var4 = ox;
      float var5 = oy;
      float var6 = oz;
      float var7 = exx;
      float var8 = exy;
      float var9 = exz;
      float var10 = eyx;
      float var11 = eyy;
      float var12 = eyz;
      float[] var13 = m;
      float[] var14 = n;
      float[] var15 = o;
      float[] var16 = p;
      float[] var17 = q;
      float[] var18 = r;
      float[] var19 = s;
      float[] var20 = t;
      float[] var21 = u;
      float[] var22 = v;
      float[] var23 = SX;
      float[] var24 = SY;
      float[] var25 = SW;
      float[] var26 = SH;
      float[] var27 = SR;
      int[] var28 = SC;

      try {
         for (int var29 = 0; var29 < var1; var29++) {
            int var30 = var28[var29];
            float var31 = var23[var29];
            float var32 = var24[var29];
            float var33 = var25[var29];
            float var34 = var26[var29];
            if (var30 >>> 24 != 0 && var33 > 0.0F && var34 > 0.0F) {
               float var35 = var27[var29];
               float var36 = Math.min(var33, var34) * 0.5F;
               var35 = var35 < 0.0F ? 0.0F : (var35 > var36 ? var36 : var35);
               float var37 = var3 < var36 ? var3 : var36;
               int var38 = (int)(var35 / var2 * 0.4F + 0.5F);
               var38 = var38 < 1 ? 1 : (var38 > 6 ? 6 : var38);
               boolean var39 = var35 >= var37;
               float var40 = var39 ? var35 - var37 : 0.0F;
               float var41 = var35 + var3;
               float[] var42 = j[var38];
               float[] var43 = k[var38];
               int var44 = 0;

               for (int var45 = 0; var45 < 4; var45++) {
                  boolean var46 = var45 == 0 || var45 == 3;
                  boolean var47 = var45 < 2;
                  float var48 = var46 ? var31 + var35 : var31 + var33 - var35;
                  float var49 = var47 ? var32 + var35 : var32 + var34 - var35;
                  float var50 = var39 ? var48 : (var46 ? var31 + var37 : var31 + var33 - var37);
                  float var51 = var39 ? var49 : (var47 ? var32 + var37 : var32 + var34 - var37);

                  for (int var52 = 0; var52 <= var38; var52++) {
                     float var53;
                     float var54;
                     if (var45 == 0) {
                        var53 = -var42[var52];
                        var54 = -var43[var52];
                     } else if (var45 == 1) {
                        var53 = var43[var52];
                        var54 = -var42[var52];
                     } else if (var45 == 2) {
                        var53 = var42[var52];
                        var54 = var43[var52];
                     } else {
                        var53 = -var43[var52];
                        var54 = var42[var52];
                     }

                     var13[var44] = var50 + var53 * var40;
                     var14[var44] = var51 + var54 * var40;
                     var15[var44] = var48 + var53 * var41;
                     var16[var44] = var49 + var54 * var41;
                     var44++;
                  }
               }

               int var58 = 0;

               for (int var61 = var44 - 1; var58 < var61; var61--) {
                  float var65 = var13[var58];
                  var13[var58] = var13[var61];
                  var13[var61] = var65;
                  var65 = var14[var58];
                  var14[var58] = var14[var61];
                  var14[var61] = var65;
                  var65 = var15[var58];
                  var15[var58] = var15[var61];
                  var15[var61] = var65;
                  var65 = var16[var58];
                  var16[var58] = var16[var61];
                  var16[var61] = var65;
                  var58++;
               }

               for (int var59 = 0; var59 < var44; var59++) {
                  float var62 = var13[var59];
                  float var69 = var14[var59];
                  var17[var59] = var4 + var62 * var7 + var69 * var10;
                  var18[var59] = var5 + var62 * var8 + var69 * var11;
                  var19[var59] = var6 + var62 * var9 + var69 * var12;
                  var62 = var15[var59];
                  var69 = var16[var59];
                  var20[var59] = var4 + var62 * var7 + var69 * var10;
                  var21[var59] = var5 + var62 * var8 + var69 * var11;
                  var22[var59] = var6 + var62 * var9 + var69 * var12;
               }

               var58 = var30 & (779220494 ^ 781060593);
               float var64 = var31 + var33 * 0.5F;
               float var71 = var32 + var34 * 0.5F;
               float var72 = var4 + var64 * var7 + var71 * var10;
               float var73 = var5 + var64 * var8 + var71 * var11;
               float var74 = var6 + var64 * var9 + var71 * var12;

               for (byte var75 = 0; var75 < var44; var75 += 2) {
                  int var77 = var75 + 1;
                  int var79 = var75 + 2 == var44 ? 0 : var75 + 2;
                  var0.vertex(var72, var73, var74).color(var30);
                  var0.vertex(var17[var75], var18[var75], var19[var75]).color(var30);
                  var0.vertex(var17[var77], var18[var77], var19[var77]).color(var30);
                  var0.vertex(var17[var79], var18[var79], var19[var79]).color(var30);
               }

               for (int var76 = 0; var76 < var44; var76++) {
                  int var78 = var76 + 1 == var44 ? 0 : var76 + 1;
                  var0.vertex(var17[var76], var18[var76], var19[var76]).color(var30);
                  var0.vertex(var20[var76], var21[var76], var22[var76]).color(var58);
                  var0.vertex(var20[var78], var21[var78], var22[var78]).color(var58);
                  var0.vertex(var17[var78], var18[var78], var19[var78]).color(var30);
               }
            }
         }
      } catch (RuntimeException var55) {
         throw var55;
      }
   }

   static {
      for (int var0 = 1; var0 <= 6; var0++) {
         j[var0] = new float[var0 + 1];
         k[var0] = new float[var0 + 1];

         for (int var1 = 0; var1 <= var0; var1++) {
            double var2 = (Math.PI / 2) * (double)var1 / (double)var0;
            j[var0][var1] = (float)Math.cos(var2);
            k[var0][var1] = (float)Math.sin(var2);
         }

         j[var0][var0] = 0.0F;
         k[var0][var0] = 1.0F;
      }
   }
}
