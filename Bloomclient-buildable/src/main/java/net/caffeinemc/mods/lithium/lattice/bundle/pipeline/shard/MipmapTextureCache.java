package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.AddressMode;
import com.mojang.blaze3d.textures.FilterMode;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.textures.TextureFormat;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.AbstractTexture;

public final class MipmapTextureCache extends AbstractTexture {

   public MipmapTextureCache(String var1, NativeImage[] var2, boolean var3) {
      int var4 = var2[0].getWidth();
      int var5 = var2[0].getHeight();
      AddressMode var6 = var3 ? AddressMode.REPEAT : AddressMode.CLAMP_TO_EDGE;
      GpuDevice var7 = RenderSystem.getDevice();
      GpuTexture var8 = var7.createTexture(() -> {

         return var1;
      }, 5, TextureFormat.RGBA8, var4, var5, 1, var2.length);
      CommandEncoder var9 = var7.createCommandEncoder();

      for (int var10 = 0; var10 < var2.length; var10++) {
         var9.writeToTexture(var8, var2[var10], var10, 0, 0, 0, var4 >> var10, var5 >> var10, 0, 0);
      }

      this.glTexture = var8;
      this.glTextureView = var7.createTextureView(var8);
      this.sampler = RenderSystem.getSamplerCache().get(var6, var6, FilterMode.LINEAR, FilterMode.LINEAR, true);

      for (int var11 = 0; var11 < var2.length; var11++) {
         var2[var11].close();
      }
   }

   public static NativeImage[] toImages(int[][] var0, int var1, int var2) {

      NativeImage[] var3 = new NativeImage[var0.length];

      assert var0 != null && var1 > 0 && var2 > 0 && var0.length >= 1 && var0[0].length == var1 * var2;

      try {
         for (int var5 = 0; var5 < var0.length; var5++) {
            int var6 = Math.max(1, var1 >> var5);
            int var7 = Math.max(1, var2 >> var5);
            NativeImage var4 = new NativeImage(var6, var7, false);
            int[] var8 = var0[var5];

            for (int var9 = 0; var9 < var7; var9++) {
               for (int var10 = 0; var10 < var6; var10++) {
                  var4.setColorArgb(var10, var9, var8[var9 * var6 + var10]);
               }
            }

            var3[var5] = var4;
         }

         return var3;
      } catch (RuntimeException var11) {
         throw var11;
      }
   }
}
