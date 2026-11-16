package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.buffers.Std140Builder;
import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.textures.TextureFormat;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import com.mojang.blaze3d.systems.ProjectionType;
import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.client.item.ItemModelManager;
import net.minecraft.client.render.ProjectionMatrix2;
import net.minecraft.client.render.item.KeyedItemRenderState;
import net.minecraft.client.render.command.OrderedRenderCommandQueueImpl;
import net.minecraft.client.render.command.RenderDispatcher;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.DiffuseLighting;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.fog.FogRenderer;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.client.util.BufferAllocator;
import org.joml.Matrix4fStack;
import org.lwjgl.system.MemoryStack;

public final class PlateIconCache extends AbstractTexture {
   private static final String[] f = new String[]{
      "lithium", "tag_i" + "cons", "lithium" + " tag icons", "lithium tag icons depth", "lithium" + " t" + "ag items", "lithiu" + "m ta" + "g " + "fog"
   };
   public static final Identifier ID = Identifier.of(f[0], f[1]);
   public static final int COLS = 8;
   public static final int ROWS = 7;
   public static final int CELLS = 56;
   private static final long g = 33000000L;
   private static final int h = 64;
   private static final int i = 15728880;
   private static PlateIconCache j;
   private static boolean k;
   private static GpuTexture l;
   private static GpuTextureView m;
   private static int n;
   private static int o;
   private static int p;
   private static int q;
   private static int r;
   private static int s;
   public static final float[] U0 = new float[56];
   public static final float[] U1 = new float[56];
   public static final float[] V0 = new float[56];
   public static final float[] V1 = new float[56];
   private static final Object[][] t = new Object[56][];
   private static final int[] u = new int[56];
   private static final int[] v = new int[56];
   private static final int[] w = new int[56];
   private static final int[] x = new int[56];
   private static final long[] y = new long[56];
   private static int z;
   private static final KeyedItemRenderState[] aa = new KeyedItemRenderState[64];
   private static int ab;
   private static final int[] ac = new int[64];
   private static final KeyedItemRenderState[] ad = new KeyedItemRenderState[64];
   private static int ae;
   private static OrderedRenderCommandQueueImpl af;
   private static RenderDispatcher ag;
   private static BufferAllocator ah;
   private static VertexConsumerProvider.Immediate ai;
   private static ProjectionMatrix2 aj;
   private static GpuBuffer ak;
   private static GpuBufferSlice al;
   private static final MatrixStack am = new MatrixStack();
   private static int an;
   private static boolean ao;
   private static final int ap = 20;
   private static int aq = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   private PlateIconCache() {
      this.sampler = RenderSystem.getSamplerCache().getRepeated(FilterMode.NEAREST);
   }

   public static boolean begin(int var0) {

      z++;
      ab = 0;
      ae = 0;
      if (k) {
         return false;
      } else if (j != null && var0 == n) {
         return true;
      } else {
         try {
            a(var0);
            return true;
         } catch (Throwable var2) {
            k = true;
            return false;
         }
      }
   }

   public static void off() {

      k = true;
   }

   private static void a(int var0) {

      GpuDevice var1 = RenderSystem.getDevice();
      int var2 = 16 * var0;
      int var4 = var2 + 2 * var0;
      int var5 = 8 * var4;
      int var6 = 7 * var4;
      GpuTexture var7 = var1.createTexture(f[2], 12, TextureFormat.RGBA8, var5, var6, 1, 1);
      GpuTexture var8 = var1.createTexture(f[3], 8, TextureFormat.DEPTH32, var5, var6, 1, 1);
      GpuTextureView var9 = var1.createTextureView(var7);
      GpuTextureView var10 = var1.createTextureView(var8);
      var1.createCommandEncoder().clearColorAndDepthTextures(var7, 0, var8, 1.0);
      PlateIconCache var11 = j;
      if (var11 == null) {
         var11 = new PlateIconCache();
         var11.glTexture = var7;
         var11.glTextureView = var9;
         j = var11;
         MinecraftClient.getInstance().getTextureManager().registerTexture(ID, var11);
         MinecraftClient var12 = MinecraftClient.getInstance();
         af = new OrderedRenderCommandQueueImpl();
         ah = new BufferAllocator(1535284135 ^ 1535349671);
         LinkedHashMap var13 = new LinkedHashMap();
         var13.put(TexturedRenderLayers.getEntitySolid(), new BufferAllocator(-894534885 ^ -894502117));
         var13.put(TexturedRenderLayers.getEntityCutout(), new BufferAllocator(1503723679 ^ 1503756447));
         var13.put(TexturedRenderLayers.getItemTranslucentCull(), new BufferAllocator(695559371 ^ 695592139));
         var13.put(RenderLayers.armorEntityGlint(), new BufferAllocator(120278214 ^ 120261830));
         var13.put(RenderLayers.glint(), new BufferAllocator(1694341956 ^ 1694358340));
         var13.put(RenderLayers.glintTranslucent(), new BufferAllocator(-1793003272 ^ -1793019656));
         var13.put(RenderLayers.entityGlint(), new BufferAllocator(1869230517 ^ 1869246901));
         ai = VertexConsumerProvider.immediate(var13, ah);
         ag = new RenderDispatcher(
            af, var12.getBlockRenderManager(), ai, var12.getAtlasManager(), var12.getBufferBuilders().getOutlineVertexConsumers(), var12.getBufferBuilders().getEffectVertexConsumers(), var12.textRenderer
         );
         aj = new ProjectionMatrix2(f[4], -1000.0F, 1000.0F, true);
         ak = c();
      } else {
         var11.b();
         var11.glTexture = var7;
         var11.glTextureView = var9;
      }

      l = var8;
      m = var10;
      n = var0;
      o = var2;
      p = var0;
      q = var4;
      r = var5;
      s = var6;
      d();
   }

   private void b() {
      byte var1 = 0;

      while (true) {
         switch (var1) {
            case 0:
            default:
               if (aq != 0) {
                  new Object().hashCode();
                  var1 = 1;
                  break;
               }
            case 1:
               if (this.glTextureView != null) {
                  this.glTextureView.close();
                  this.glTextureView = null;
                  var1 = 3;
                  break;
               }
            case 3:
               if (this.glTexture != null) {
                  this.glTexture.close();
                  this.glTexture = null;
                  var1 = 4;
                  break;
               }
            case 4:
               if (m != null) {
                  m.close();
                  m = null;
                  var1 = 2;
                  break;
               }
            case 2:
               if (l != null) {
                  l.close();
                  l = null;
                  var1 = 5;
                  break;
               }

               return;
            case 5:
               return;
         }
      }
   }

   private static GpuBuffer c() {

      int var0 = FogRenderer.FOG_UBO_SIZE;
      MemoryStack var1 = MemoryStack.stackPush();

      GpuBuffer var5;
      try {
         float var2 = Float.MAX_VALUE;
         ByteBuffer var3 = Std140Builder.onStack(var1, var0)
            .putVec4(0.0F, 0.0F, 0.0F, 0.0F)
            .putFloat(var2)
            .putFloat(var2)
            .putFloat(var2)
            .putFloat(var2)
            .putFloat(var2)
            .putFloat(var2)
            .get();
         GpuBuffer var4 = RenderSystem.getDevice().createBuffer(null, 808133014 ^ 808132886, var3);
         al = var4.slice(0L, (long)var0);
         var5 = var4;
      } catch (Throwable var7) {
         if (var1 != null) {
            try {
               var1.close();
            } catch (Throwable var6) {
               var7.addSuppressed(var6);
            }
         }

         throw var7;
      }

      if (var1 != null) {
         var1.close();
      }

      return var5;
   }

   private static void d() {

      assert U0.length == 56
         && U1.length == 56
         && V0.length == 56
         && V1.length == 56
         && r > 0
         && s > 0
         && u.length == 56
         && y.length == 56
         && w.length == 56
         && x.length == 56
         && o > 0
         && t.length == 56
         && v.length == 56
         && q == o + 2 * p : "layout";

      try {
         for (int var0 = 0; var0 < 56; var0++) {
            int var1 = var0 % 8 * q + p;
            int var2 = var0 / 8 * q + p;
            U0[var0] = (float)var1 / (float)r;
            U1[var0] = (float)(var1 + o) / (float)r;
            V0[var0] = (float)(s - var2) / (float)s;
            V1[var0] = (float)(s - var2 - o) / (float)s;
            u[var0] = -1;
            y[var0] = 0L;
            w[var0] = 0;
            x[var0] = 0;
         }
      } catch (RuntimeException var3) {
         throw var3;
      }
   }

   public static void cells(ItemStack[] var0, int[] var1, int var2) {

      MinecraftClient var3 = MinecraftClient.getInstance();
      ClientWorld var4 = var3.world;
      ClientPlayerEntity var5 = var3.player;
      ItemModelManager var6 = var3.getItemModelManager();
      long var7 = System.nanoTime();
      int var9 = z;

      assert var0 != null
         && var1 != null
         && var0.length == 5
         && var2 >= 0
         && var2 + 5 <= var1.length
         && aa.length == 64
         && ac.length == 64
         && ad.length == 64
         && t.length == 56
         && u.length == 56
         && v.length == 56
         && w.length == 56
         && x.length == 56
         && y.length == 56
         && ab >= 0
         && ae >= 0
         && var6 != null : "cells";

      try {
         for (int var10 = 0; var10 < 5; var10++) {
            var1[var2 + var10] = -1;
            ItemStack var11 = var0[var10];
            if (var11 != null && !var11.isEmpty() && ab < 64 && j != null) {
               KeyedItemRenderState var12 = aa[ab];
               if (var12 == null) {
                  var12 = new KeyedItemRenderState();
                  aa[ab] = var12;
               }

               List var13 = (List)var12.getModelKey();
               var13.clear();
               var6.clearAndUpdate(var12, var11, ItemDisplayContext.GUI, var4, var5, 0);
               if (!var12.isEmpty()) {
                  ab++;
                  int var14 = var13.size();
                  int var15 = var13.hashCode();
                  int var16 = -1;

                  for (int var17 = 0; var17 < 56 && var16 < 0; var17++) {
                     if (v[var17] == var15 && u[var17] == var14) {
                        Object[] var18 = t[var17];
                        boolean var19 = true;

                        for (int var20 = 0; var20 < var14 && var19; var20++) {
                           Object var21 = var18[var20];
                           Object var22 = var13.get(var20);
                           var19 = var21 == var22 || var21 != null && var21.equals(var22);
                        }

                        if (var19) {
                           var16 = var17;
                        }
                     }
                  }

                  if (var16 < 0) {
                     int var24 = -31662572 ^ -2115821077;

                     for (int var26 = 0; var26 < 56; var26++) {
                        if (w[var26] != var9) {
                           int var28 = u[var26] < 0 ? 2085599106 ^ -61884542 : w[var26];
                           if (var28 < var24) {
                              var24 = var28;
                              var16 = var26;
                           }
                        }
                     }

                     if (var16 < 0) {
                        continue;
                     }

                     Object[] var27 = t[var16];
                     if (var27 == null || var27.length < var14) {
                        var27 = new Object[Math.max(4, var14)];
                        t[var16] = var27;
                     }

                     for (int var29 = 0; var29 < var27.length; var29++) {
                        var27[var29] = var29 < var14 ? var13.get(var29) : null;
                     }

                     u[var16] = var14;
                     v[var16] = var15;
                     y[var16] = 0L;
                  }

                  w[var16] = var9;
                  boolean var25 = y[var16] == 0L || var12.isAnimated() && var7 - y[var16] >= 33000000L;
                  if (var25 && x[var16] != var9 && ae < 64) {
                     x[var16] = var9;
                     ac[ae] = var16;
                     ad[ae] = var12;
                     ae++;
                  }

                  var1[var2 + var10] = var16;
               }
            }
         }
      } catch (RuntimeException var23) {
         throw var23;
      }
   }

   public static void render() {

      if (ae != 0 && j != null) {
         GpuTextureView var0 = RenderSystem.outputColorTextureOverride;
         GpuTextureView var1 = RenderSystem.outputDepthTextureOverride;
         GpuBufferSlice var2 = RenderSystem.getProjectionMatrixBuffer();
         ProjectionType var3 = RenderSystem.getProjectionType();
         GpuBufferSlice var4 = RenderSystem.getShaderLights();
         GpuBufferSlice var5 = RenderSystem.getShaderFog();
         Matrix4fStack var6 = RenderSystem.getModelViewStack();
         var6.pushMatrix();

         try {
            var6.identity();
            RenderSystem.outputColorTextureOverride = j.glTextureView;
            RenderSystem.outputDepthTextureOverride = m;
            RenderSystem.setProjectionMatrix(aj.set((float)r, (float)s), ProjectionType.ORTHOGRAPHIC);
            RenderSystem.setShaderFog(al);
            e();
            an = 0;
         } catch (Throwable var14) {
            try {
               ag.render();
               ai.draw();
            } catch (Throwable var13) {
            }

            for (int var8 = 0; var8 < ae; var8++) {
               y[ac[var8]] = 0L;
            }

            if (++an >= 20) {
               k = true;
            }
         } finally {
            if (ao) {
               RenderSystem.disableScissorForRenderTypeDraws();
               ao = false;
            }

            RenderSystem.outputColorTextureOverride = var0;
            RenderSystem.outputDepthTextureOverride = var1;
            if (var2 != null && var3 != null) {
               RenderSystem.setProjectionMatrix(var2, var3);
            }

            if (var4 != null) {
               RenderSystem.setShaderLights(var4);
            }

            if (var5 != null) {
               RenderSystem.setShaderFog(var5);
            }

            var6.popMatrix();
            Arrays.fill(ad, 0, 64, null);
            ae = 0;
         }
      }
   }

   private static void e() {

      MinecraftClient var0 = MinecraftClient.getInstance();
      DiffuseLighting var1 = var0.gameRenderer.getDiffuseLighting();
      GpuTexture var2 = j.glTexture;
      MatrixStack var3 = am;
      int var4 = ae;
      long var5 = System.nanoTime();
      CommandEncoder var7 = RenderSystem.getDevice().createCommandEncoder();

      assert var4 > 0
         && var4 <= 64
         && ac.length == 64
         && ad.length == 64
         && var2 != null
         && l != null
         && var1 != null
         && o > 0
         && q > 0
         && r > 0
         && s > 0
         && y.length == 56
         && af != null
         && ag != null
         && ai != null
         && var7 != null : "batch";

      try {
         for (int var8 = 0; var8 < var4; var8++) {
            int var9 = ac[var8];
            int var10 = var9 % 8 * q;
            int var11 = var9 / 8 * q;
            var7.clearColorAndDepthTextures(var2, 0, l, 1.0, var10, s - var11 - q, q, q);
         }

         for (int var17 = 0; var17 < 2; var17++) {
            boolean var20 = var17 == 1;
            if (var20) {
               var1.setShaderLights(DiffuseLighting.Type.ITEMS_3D);
            } else {
               var1.setShaderLights(DiffuseLighting.Type.ITEMS_FLAT);
            }

            int var22 = 0;

            for (int var24 = 0; var24 < var4; var24++) {
               KeyedItemRenderState var12 = ad[var24];
               if (var12 != null && !var12.isOversizedInGui() && var12.isSideLit() == var20) {
                  int var13 = ac[var24];
                  int var14 = var13 % 8 * q + p;
                  int var15 = var13 / 8 * q + p;
                  var3.push();
                  var3.translate((float)var14 + (float)o / 2.0F, (float)var15 + (float)o / 2.0F, 0.0F);
                  var3.scale((float)o, (float)(-o), (float)o);
                  var12.render(var3, af, 1519909451 ^ 1516763835, OverlayTexture.DEFAULT_UV, 0);
                  var3.pop();
                  var22++;
               }
            }

            if (var22 > 0) {
               ag.render();
               ai.draw();
            }
         }

         for (int var18 = 0; var18 < var4; var18++) {
            KeyedItemRenderState var21 = ad[var18];
            if (var21 != null && var21.isOversizedInGui()) {
               int var23 = ac[var18];
               int var25 = var23 % 8 * q + p;
               int var26 = var23 / 8 * q + p;
               if (var21.isSideLit()) {
                  var1.setShaderLights(DiffuseLighting.Type.ITEMS_3D);
               } else {
                  var1.setShaderLights(DiffuseLighting.Type.ITEMS_FLAT);
               }

               RenderSystem.enableScissorForRenderTypeDraws(var25, s - var26 - o, o, o);
               ao = true;
               var3.push();
               var3.translate((float)var25 + (float)o / 2.0F, (float)var26 + (float)o / 2.0F, 0.0F);
               var3.scale((float)o, (float)(-o), (float)o);
               var21.render(var3, af, -2098186186 ^ -2113914682, OverlayTexture.DEFAULT_UV, 0);
               var3.pop();
               ag.render();
               ai.draw();
               RenderSystem.disableScissorForRenderTypeDraws();
               ao = false;
            }
         }

         for (int var19 = 0; var19 < var4; var19++) {
            y[ac[var19]] = var5;
         }
      } catch (RuntimeException var16) {
         throw var16;
      }
   }
}
