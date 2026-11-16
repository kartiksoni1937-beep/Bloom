package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import java.util.Random;

public final class SectorArrayCache {
   public static final int W = 512;
   public static final int H = 256;
   public static final float MOON_R = 118.0F;
   public static final float SUN_R = 120.0F;

   private SectorArrayCache() {
   }

   public static int[] a() {

      int[] var0 = new int[131072];
      Random var1 = new Random(25482170381L);
      byte var2 = 9;
      byte var3 = 33;
      float[] var4 = new float[var2 * var2];
      float[] var5 = new float[var3 * var3];

      for (int var6 = 0; var6 < var4.length; var6++) {
         var4[var6] = var1.nextFloat();
      }

      for (int var55 = 0; var55 < var5.length; var55++) {
         var5[var55] = var1.nextFloat();
      }

      byte var56 = 28;
      float[] var7 = new float[var56];
      float[] var8 = new float[var56];
      float[] var9 = new float[var56];

      for (int var10 = 0; var10 < var56; var10++) {
         float var11 = var1.nextFloat() * (float) (Math.PI * 2);
         float var12 = (float)Math.sqrt((double)var1.nextFloat()) * 0.86F;
         var7[var10] = (float)Math.cos((double)var11) * var12;
         var8[var10] = (float)Math.sin((double)var11) * var12;
         var9[var10] = var10 < 3 ? 0.1F + var1.nextFloat() * 0.06F : 0.025F + var1.nextFloat() * 0.05F;
      }

      for (int var57 = 0; var57 < (225059750 ^ 225059494); var57++) {
         for (int var59 = 0; var59 < (-439700013 ^ -439700269); var59++) {
            float var61 = ((float)var59 + 0.5F - 128.0F) / 118.0F;
            float var13 = ((float)var57 + 0.5F - 128.0F) / 118.0F;
            float var14 = var61 * var61 + var13 * var13;
            float var15 = (float)Math.sqrt((double)var14);
            float var16 = (1.0F - var15) * 118.0F + 0.5F;
            if (!(var16 <= 0.0F)) {
               var16 = var16 > 1.0F ? 1.0F : var16;
               float var17 = (float)Math.sqrt((double)Math.max(0.0F, 1.0F - var14));
               float var18 = (var61 * 0.5F + 0.5F) * ((float)var2 - 1.001F);
               float var19 = (var13 * 0.5F + 0.5F) * ((float)var2 - 1.001F);
               int var20 = (int)var18;
               int var21 = (int)var19;
               var20 = var20 < 0 ? 0 : (var20 > var2 - 2 ? var2 - 2 : var20);
               var21 = var21 < 0 ? 0 : (var21 > var2 - 2 ? var2 - 2 : var21);
               float var22 = var18 - (float)var20;
               float var23 = var19 - (float)var21;
               var22 = var22 * var22 * (3.0F - 2.0F * var22);
               var23 = var23 * var23 * (3.0F - 2.0F * var23);
               float var24 = var4[var21 * var2 + var20];
               float var25 = var4[var21 * var2 + var20 + 1];
               float var26 = var4[(var21 + 1) * var2 + var20];
               float var27 = var4[(var21 + 1) * var2 + var20 + 1];
               float var28 = var24 + (var25 - var24) * var22 + (var26 + (var27 - var26) * var22 - (var24 + (var25 - var24) * var22)) * var23;
               float var29 = (var61 * 0.5F + 0.5F) * ((float)var3 - 1.001F);
               float var30 = (var13 * 0.5F + 0.5F) * ((float)var3 - 1.001F);
               int var31 = (int)var29;
               int var32 = (int)var30;
               var31 = var31 < 0 ? 0 : (var31 > var3 - 2 ? var3 - 2 : var31);
               var32 = var32 < 0 ? 0 : (var32 > var3 - 2 ? var3 - 2 : var32);
               float var33 = var29 - (float)var31;
               float var34 = var30 - (float)var32;
               var33 = var33 * var33 * (3.0F - 2.0F * var33);
               var34 = var34 * var34 * (3.0F - 2.0F * var34);
               float var35 = var5[var32 * var3 + var31];
               float var36 = var5[var32 * var3 + var31 + 1];
               float var37 = var5[(var32 + 1) * var3 + var31];
               float var38 = var5[(var32 + 1) * var3 + var31 + 1];
               float var39 = var35 + (var36 - var35) * var33 + (var37 + (var38 - var37) * var33 - (var35 + (var36 - var35) * var33)) * var34;
               float var40 = 0.72F * var28 + 0.28F * var39;
               float var41 = (var40 - 0.5F) / 0.18F;
               var41 = var41 < 0.0F ? 0.0F : (var41 > 1.0F ? 1.0F : var41);
               float var42 = var41 * var41 * (3.0F - 2.0F * var41);
               float var43 = 0.0F;

               for (int var44 = 0; var44 < var56; var44++) {
                  float var45 = var61 - var7[var44];
                  float var46 = var13 - var8[var44];
                  float var47 = (float)Math.sqrt((double)(var45 * var45 + var46 * var46));
                  float var48 = var47 / var9[var44];
                  if (var48 < 1.3F) {
                     float var49 = var48 - 1.0F;
                     float var50 = var47 > 1.0E-5F ? (var45 * 0.55F + var46 * 0.83F) / var47 : 0.0F;
                     var43 += 0.16F * (0.35F + 0.65F * (var50 > 0.0F ? var50 : 0.0F)) * (float)Math.exp((double)(-var49 * var49 / 0.012F));
                     if (var48 < 1.0F) {
                        var43 -= 0.12F * (1.0F - var48 * var48) * (0.6F - 0.4F * var50);
                     }
                  }
               }

               float var103 = 0.84F - 0.2F * var42 + 0.08F * (var39 - 0.5F) + 0.4F * var43;
               float var104 = 0.62F + 0.38F * (float)Math.pow((double)var17, 0.5);
               float var105 = 0.72F - 0.34F * (var61 * 0.55F + var13 * 0.83F);
               float var106 = var103 * var104 * var105;
               var106 = var106 < 0.0F ? 0.0F : (var106 > 1.1F ? 1.1F : var106);
               float var108 = 0.24F + 0.66F * var106;
               float var109 = 0.05F + 0.3F * var106 * var106;
               float var110 = 0.03F + 0.12F * var106 * var106;
               int var51 = (int)(var16 * 255.0F + 0.5F);
               int var52 = (int)(Math.min(1.0F, var108) * var16 * 255.0F + 0.5F);
               int var53 = (int)(Math.min(1.0F, var109) * var16 * 255.0F + 0.5F);
               int var54 = (int)(Math.min(1.0F, var110) * var16 * 255.0F + 0.5F);
               var0[var57 * (811154738 ^ 811155250) + var59] = var51 << 24 | var52 << 16 | var53 << 8 | var54;
            }
         }
      }

      float var58 = 8.0F;
      float var60 = 113.6F;
      float var62 = 248.0F;

      for (int var63 = 0; var63 < (-613986964 ^ -613987220); var63++) {
         float var64 = (float)var63 + 0.5F;
         float var65 = (var64 - var58) / 240.0F;
         var65 = var65 < 0.0F ? 0.0F : (var65 > 1.0F ? 1.0F : var65);
         float var68;
         float var69;
         float var70;
         if (var65 < 0.45F) {
            float var71 = var65 / 0.45F;
            var68 = 1.0F;
            var69 = 0.93F - 0.34F * var71;
            var70 = 0.43F - 0.16F * var71;
         } else {
            float var72 = (var65 - 0.45F) / 0.55F;
            var68 = 1.0F;
            var69 = 0.59F - 0.41F * var72;
            var70 = 0.27F + 0.32F * var72;
         }

         float var73 = 1.0F;
         if (var64 > var60) {
            float var75 = (var64 - var60) / (var62 - var60);
            float var78 = 21.0F;
            float var81 = 1.5F + 9.5F * var75;
            float var84 = (var64 - var60) % var78;
            float var86 = var78 - var81 - var84 + 0.5F;
            float var90 = var84 + 0.5F;
            var86 = var86 < 0.0F ? 0.0F : (var86 > 1.0F ? 1.0F : var86);
            var90 = var90 < 0.0F ? 0.0F : (var90 > 1.0F ? 1.0F : var90);
            var73 = Math.min(var86, var90);
         }

         if (!(var73 <= 0.0F)) {
            for (int var76 = 0; var76 < (-1178765743 ^ -1178765487); var76++) {
               float var79 = (float)var76 + 0.5F - 128.0F;
               float var82 = var64 - 128.0F;
               float var85 = (float)Math.sqrt((double)(var79 * var79 + var82 * var82));
               float var88 = 120.0F - var85 + 0.5F;
               if (!(var88 <= 0.0F)) {
                  var88 = var88 > 1.0F ? 1.0F : var88;
                  float var92 = 1.0F + 0.1F * (1.0F - var85 / 120.0F);
                  float var93 = var88 * var73;
                  int var94 = (int)(var93 * 255.0F + 0.5F);
                  int var95 = (int)(Math.min(1.0F, var68 * var92) * var93 * 255.0F + 0.5F);
                  int var96 = (int)(Math.min(1.0F, var69 * var92) * var93 * 255.0F + 0.5F);
                  int var97 = (int)(Math.min(1.0F, var70 * var92) * var93 * 255.0F + 0.5F);
                  var0[var63 * (-1871176995 ^ -1871177507) + (-775736383 ^ -775736639) + var76] = var94 << 24 | var95 << 16 | var96 << 8 | var97;
               }
            }
         }
      }

      return var0;
   }
}
