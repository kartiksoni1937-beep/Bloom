package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import net.minecraft.client.sound.MovingSoundInstance;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundCategory;

public final class EchoLoopCache extends MovingSoundInstance {
   public volatile float want = 0.0F;
   public volatile float pitchWant = 1.0F;
   public volatile float orbit = 0.0F;
   private int a = 0;
   private float b = 0.0F;

   public EchoLoopCache(SoundEvent var1, float var2) {
      super(var1, SoundCategory.AMBIENT, SoundInstance.createRandom());
      this.repeat = true;
      this.repeatDelay = 0;
      this.attenuationType = SoundInstance.AttenuationType.NONE;
      this.relative = true;
      this.volume = 0.0F;
      this.pitch = var2;
      this.pitchWant = var2;
      this.x = 0.0;
      this.y = 0.0;
      this.z = 0.0;
   }

   public void tick() {

      if (!this.isDone()) {
         float var1 = this.want;
         this.volume = this.volume + (var1 - this.volume) * 0.12F;
         this.pitch = this.pitch + (this.pitchWant - this.pitch) * 0.15F;
         float var2 = this.orbit;
         if (var2 > 0.0F) {
            this.b = (this.b + 0.0035F + 0.004F * this.volume) % (float) (Math.PI * 2);
            this.x = Math.cos((double)this.b) * (double)var2;
            this.y = 6.0;
            this.z = Math.sin((double)this.b) * (double)var2;
         }

         if (var1 <= 0.001F && this.volume < 0.004F) {
            if (++this.a > 10) {
               this.setDone();
            }
         } else {
            this.a = 0;
         }
      }
   }

   public boolean shouldAlwaysPlay() {

      return true;
   }

   public void end() {

      this.setDone();
   }
}
