package net.caffeinemc.mods.lithium.lattice.bundle.overlay.relay;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.ProfileTextCache;
import net.minecraft.client.font.TextHandler;
import net.minecraft.text.CharacterVisitor;
import net.minecraft.text.StringVisitable;
import net.minecraft.text.Style;
import net.minecraft.text.TextVisitFactory;
import net.minecraft.util.Language;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin({TextHandler.class})
public abstract class ChatBufferCache implements CharacterVisitor {
   @Unique
   private int[] b;
   @Unique
   private long c;
   @Unique
   private int d;
   @Unique
   private boolean e;
   @Unique
   private boolean f;
   @Unique
   private char[][] g;
   @Unique
   private char[][] h;
   @Unique
   private int[][] i;

   @Inject(
      method = {"getWidth(Lnet/minecraft/text/StringVisitable;)F"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void a(StringVisitable var1, CallbackInfoReturnable<Float> var2) {
      if (ProfileTextCache.ON && !ProfileTextCache.EDIT && var1 != null) {
         char[][] var3 = ProfileTextCache.LO;
         char[][] var4 = ProfileTextCache.UP;
         int[][] var5 = ProfileTextCache.FAIL;
         int var6 = Math.min(var5.length, Math.min(var3.length, var4.length));
         if (var6 != 0) {
            int[] var7 = this.b;
            if (var7 == null || var7.length < var6) {
               var7 = new int[var6];
               this.b = var7;
            }

            for (int var8 = 0; var8 < var6; var8++) {
               var7[var8] = 0;
            }

            this.g = var3;
            this.h = var4;
            this.i = var5;
            this.c = 0L;
            this.d = 0;
            this.e = false;
            this.f = false;

            boolean var11;
            try {
               TextVisitFactory.visitFormatted(var1, Style.EMPTY, this);
               var11 = this.f || this.e;
            } catch (RuntimeException var10) {
               var11 = false;
            }

            this.g = null;
            this.h = null;
            this.i = null;
            if (var11) {
               var2.setReturnValue(((TextHandler)(Object)this).getWidth(Language.getInstance().reorder(var1)));
            }
         }
      }
   }

   public boolean accept(int var1, Style var2, int var3) {
      boolean var4 = var3 == 95 || var3 >= 48 && var3 <= 57 || var3 >= 97 && var3 <= 122 || var3 >= 65 && var3 <= 90;
      if (this.e) {
         if (!var4) {
            this.f = true;
            return false;
         }

         this.e = false;
      }

      char[][] var5 = this.g;
      char[][] var6 = this.h;
      int[][] var7 = this.i;
      int[] var8 = this.b;
      if (var5 != null && var7 != null && var6 != null && var8 != null) {
         int var9 = Math.min(var7.length, Math.min(var5.length, var6.length));
         long var10 = this.c;
         int var12 = this.d;

         for (int var13 = 0; var13 < var9; var13++) {
            char[] var14 = var5[var13];
            char[] var15 = var6[var13];
            int[] var16 = var7[var13];
            int var17 = var8[var13];

            while (var17 > 0 && var3 != var14[var17] && var3 != var15[var17]) {
               var17 = var16[var17 - 1];
            }

            if (var3 == var14[var17] || var3 == var15[var17]) {
               var17++;
            }

            if (var17 == var14.length) {
               int var18 = var14.length;
               boolean var19 = var12 >= var18 && (var10 >>> var18 - 1 & 1L) != 0L;
               if (!var19) {
                  this.e = true;
               }

               var17 = var16[var17 - 1];
            }

            var8[var13] = var17;
         }

         this.c = var10 << 1 | (var4 ? 1L : 0L);
         this.d = var12 + 1;
         return true;
      } else {
         return false;
      }
   }
}
