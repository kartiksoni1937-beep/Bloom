package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import net.minecraft.client.gui.render.state.special.SpecialGuiElementRenderState;
import net.minecraft.client.gui.ScreenRect;

public final class PoseStateCache implements SpecialGuiElementRenderState {
   public int x1;
   public int y1;
   public int x2;
   public int y2;
   public float scale = 40.0F;
   public ScreenRect scissor;
   public ScreenRect bounds;
   private int a = Integer.MIN_VALUE;
   private int b;
   private int c;
   private int d;
   private ScreenRect e;
   public int visual = -1;
   public float camYaw;
   public float camPitch = 14.0F;
   public float focusY = 0.95F;

   public boolean prepare() {

      if (this.x1 != this.a
         || this.y1 != this.b
         || this.x2 != this.c
         || this.y2 != this.d
         || this.scissor != this.e && (this.scissor == null || !this.scissor.equals(this.e))) {
         this.a = this.x1;
         this.b = this.y1;
         this.c = this.x2;
         this.d = this.y2;
         this.e = this.scissor;
         this.bounds = SpecialGuiElementRenderState.createBounds(this.x1, this.y1, this.x2, this.y2, this.scissor);
      }

      return this.bounds != null && this.x2 > this.x1 && this.y2 > this.y1;
   }

   public int x1() {

      return this.x1;
   }

   public int x2() {

      return this.x2;
   }

   public int y1() {

      return this.y1;
   }

   public int y2() {

      return this.y2;
   }

   public float scale() {

      return this.scale;
   }

   public ScreenRect scissorArea() {

      return this.scissor;
   }

   public ScreenRect bounds() {

      return this.bounds;
   }
}
