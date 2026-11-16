package net.caffeinemc.mods.lithium.lattice.bundle.overlay.relay;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import it.unimi.dsi.fastutil.ints.Int2IntFunction;
import java.util.Arrays;
import java.util.List;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.ProfileTextCache;
import net.minecraft.text.Style;
import net.minecraft.text.TextReorderingProcessor;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({TextReorderingProcessor.class})
public abstract class PlayerListCache {
   @Shadow
   @Final
   @Mutable
   private String string;
   @Shadow
   @Final
   @Mutable
   private List<Style> styles;

   @Inject(
      method = {"<init>(Ljava/lang/String;Ljava/util/List;Lit/unimi/dsi/fastutil/ints/Int2IntFunction;)V"},
      at = {@At("RETURN")}
   )
   private void a(String var1, List<Style> var2, Int2IntFunction var3, CallbackInfo var4) {
      if (ProfileTextCache.ON && !ProfileTextCache.EDIT) {
         String var5 = this.string;
         int var6 = var5.length();
         if (var6 >= ProfileTextCache.MIN_LEN) {
            String[] var7 = ProfileTextCache.STR;
            char[][] var8 = ProfileTextCache.LO;
            char[][] var9 = ProfileTextCache.UP;
            int var10 = Math.min(var7.length, Math.min(var8.length, var9.length));
            int[] var11 = null;
            int var12 = 0;

            for (int var13 = 0; var13 < var10; var13++) {
               String var14 = var7[var13];
               int var15 = var14.length();
               char var16 = var8[var13][0];
               char var17 = var9[var13][0];
               int var18 = 0;

               while (var18 <= var6 - var15) {
                  int var19 = var5.indexOf(var16, var18);
                  if (var17 != var16) {
                     int var20 = var5.indexOf(var17, var18);
                     if (var20 >= 0 && (var19 < 0 || var20 < var19)) {
                        var19 = var20;
                     }
                  }

                  if (var19 < 0 || var19 > var6 - var15) {
                     break;
                  }

                  if (var5.regionMatches(true, var19, var14, 0, var15)) {
                     char var39 = var19 > 0 ? var5.charAt(var19 - 1) : 32;
                     char var21 = var19 + var15 < var6 ? var5.charAt(var19 + var15) : 32;
                     boolean var22 = var39 == '_' || var39 >= '0' && var39 <= '9' || var39 >= 'a' && var39 <= 'z' || var39 >= 'A' && var39 <= 'Z';
                     boolean var23 = var21 == '_' || var21 >= '0' && var21 <= '9' || var21 >= 'a' && var21 <= 'z' || var21 >= 'A' && var21 <= 'Z';
                     if (!var22 && !var23) {
                        if (var11 == null) {
                           var11 = new int[8];
                        } else if (var12 + 2 > var11.length) {
                           var11 = Arrays.copyOf(var11, var11.length * 2);
                        }

                        var11[var12++] = var19;
                        var11[var12++] = var15;
                        var18 = var19 + var15;
                        continue;
                     }
                  }

                  var18 = var19 + 1;
               }
            }

            if (var12 != 0) {
               if (var10 > 1 && var12 > 2) {
                  for (byte var25 = 2; var25 < var12; var25 = (byte)(var25 + 2)) {
                     int var28 = var11[var25];
                     int var31 = var11[var25 + 1];

                     int var33;
                     for (var33 = var25 - 2; var33 >= 0 && var11[var33] > var28; var33 -= 2) {
                        var11[var33 + 2] = var11[var33];
                        var11[var33 + 3] = var11[var33 + 1];
                     }

                     var11[var33 + 2] = var28;
                     var11[var33 + 3] = var31;
                  }

                  byte var26 = 2;

                  for (byte var29 = 2; var29 < var12; var29 = (byte)(var29 + 2)) {
                     if (var11[var29] >= var11[var26 - 2] + var11[var26 - 1]) {
                        var11[var26] = var11[var29];
                        var11[var26 + 1] = var11[var29 + 1];
                        var26 = (byte)(var26 + 2);
                     }
                  }

                  var12 = var26;
               }

               List var27 = this.styles;
               if (var27.size() == var6) {
                  char[] var30 = ProfileTextCache.FAKE;
                  int var32 = var30.length;
                  StringBuilder var34 = new StringBuilder(var6 + (var32 + 4) * (var12 >> 1));
                  Builder var35 = ImmutableList.builderWithExpectedSize(var6 + (var32 + 4) * (var12 >> 1));
                  int var36 = 0;

                  for (byte var37 = 0; var37 < var12; var37 = (byte)(var37 + 2)) {
                     int var40 = var11[var37];
                     int var41 = var11[var37 + 1];
                     var34.append(var5, var36, var40);

                     for (int var42 = var36; var42 < var40; var42++) {
                        var35.add((Style)var27.get(var42));
                     }

                     for (int var43 = 0; var43 < var32; var43++) {
                        var34.append(var30[var43]);
                        var35.add((Style)var27.get(var40 + Math.min(var41 - 1, var43 * var41 / var32)));
                     }

                     var36 = var40 + var41;
                  }

                  var34.append(var5, var36, var6);

                  for (int var38 = var36; var38 < var6; var38++) {
                     var35.add((Style)var27.get(var38));
                  }

                  this.string = var34.toString();
                  this.styles = var35.build();
               }
            }
         }
      }
   }
}
