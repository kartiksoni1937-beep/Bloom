package com.blamejared.clumps.mixin;

import com.blamejared.clumps.ClumpsCommon;
import com.blamejared.clumps.api.events.IRepairEvent;
import com.blamejared.clumps.api.events.IValueEvent;
import com.blamejared.clumps.helper.IClumpedOrb;
import com.blamejared.clumps.platform.Services;
import com.mojang.datafixers.util.Either;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.TypeFilter;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(
   value = {ExperienceOrbEntity.class},
   priority = 1001
)
public abstract class MixinExperienceOrb extends Entity implements IClumpedOrb {
   @Shadow
   private int pickingCount;
   @Shadow
   private int orbAge;
   @Unique
   public Map<Integer, Integer> clumps$clumpedMap;
   @Unique
   public Optional<EnchantmentEffectContext> clumps$currentEntry;

   @Shadow
   protected abstract int repairPlayerGears(ServerPlayerEntity var1, int var2);

   @Shadow
   private static boolean isMergeable(ExperienceOrbEntity var0, int var1, int var2) {
      return false;
   }

   @Shadow
   public abstract int getValue();

   @Shadow
   protected abstract void setValue(int var1);

   public MixinExperienceOrb(EntityType<?> var1, World var2) {
      super(var1, var2);
   }

   @Inject(
      method = {"isMergeable(Lnet/minecraft/entity/ExperienceOrbEntity;)Z"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void canMerge(ExperienceOrbEntity var1, CallbackInfoReturnable<Boolean> var2) {
      var2.setReturnValue(var1.isAlive() && !this.isPartOf(var1));
   }

   @Inject(
      method = {"isMergeable(Lnet/minecraft/entity/ExperienceOrbEntity;II)Z"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private static void canMerge(ExperienceOrbEntity var0, int var1, int var2, CallbackInfoReturnable<Boolean> var3) {
      var3.setReturnValue(var0.isAlive());
   }

   @Inject(
      method = {"onPlayerCollision(Lnet/minecraft/entity/player/PlayerEntity;)V"},
      at = {@At("HEAD")},
      cancellable = true
   )
   public void playerTouch(PlayerEntity var1, CallbackInfo var2) {
      if (var1 instanceof ServerPlayerEntity var3) {
         if (ClumpsCommon.pickupXPEvent.test(var3, (ExperienceOrbEntity)(Object)this)) {
            return;
         }

         var3.experiencePickUpDelay = 0;
         var3.sendPickup(this, 1);
         if (this.getValue() != 0 || this.clumps$resolve()) {
            AtomicInteger var4 = new AtomicInteger();
            this.clumps$getClumpedMap().forEach((var3xx, var4xx) -> {
               Either<IValueEvent, Integer> var5 = Services.EVENT.fireValueEvent(var3, var3xx);
               int var6 = (Integer)var5.map(IValueEvent::getValue, UnaryOperator.identity());

               for (int var7 = 0; var7 < var4xx; var7++) {
                  int var8 = (Integer)Services.EVENT.fireRepairEvent(var3, var6).map(IRepairEvent::getValue, UnaryOperator.identity());
                  if (var8 == var6) {
                     var8 = this.repairPlayerGears(var3, var6);
                  }

                  if (var8 > 0) {
                     var4.addAndGet(var8);
                  }
               }
            });
            if (var4.get() > 0) {
               var3.addExperience(var4.get());
            }
         }

         this.discard();
         var2.cancel();
      }
   }

   @ModifyVariable(
      index = 3,
      method = {"repairPlayerGears(Lnet/minecraft/server/network/ServerPlayerEntity;I)I"},
      at = @At(
         value = "INVOKE_ASSIGN",
         target = "Lnet/minecraft/enchantment/EnchantmentHelper;chooseEquipmentWith(Lnet/minecraft/component/ComponentType;Lnet/minecraft/entity/LivingEntity;Ljava/util/function/Predicate;)Ljava/util/Optional;"
      )
   )
   public Optional<EnchantmentEffectContext> clumps$captureCurrentEntry(Optional<EnchantmentEffectContext> var1) {
      this.clumps$currentEntry = var1;
      return var1;
   }

   @Inject(
      method = {"repairPlayerGears(Lnet/minecraft/server/network/ServerPlayerEntity;I)I"},
      cancellable = true,
      at = {@At(
         value = "INVOKE_ASSIGN",
         target = "Lnet/minecraft/enchantment/EnchantmentHelper;chooseEquipmentWith(Lnet/minecraft/component/ComponentType;Lnet/minecraft/entity/LivingEntity;Ljava/util/function/Predicate;)Ljava/util/Optional;"
      )}
   )
   public void clumps$repairPlayerItems(ServerPlayerEntity var1, int var2, CallbackInfoReturnable<Integer> var3) {
      var3.setReturnValue(this.clumps$currentEntry.<Integer>map(var3x -> {
         ItemStack var4 = var3x.stack();
         int var5 = EnchantmentHelper.getRepairWithExperience(var1.getEntityWorld(), var4, (int)(var2 * Services.PLATFORM.getRepairRatio(var4)));
         int var6 = Math.min(var5, var4.getDamage());
         var4.setDamage(var4.getDamage() - var6);
         if (var6 > 0) {
            int var7 = var2 - var6 * var2 / var5;
            if (var7 > 0) {
               return this.repairPlayerGears(var1, var7);
            }
         }

         return 0;
      }).orElse(var2));
   }

   @Inject(
      method = {"merge(Lnet/minecraft/entity/ExperienceOrbEntity;)V"},
      at = {@At(
         value = "INVOKE",
         target = "Lnet/minecraft/entity/ExperienceOrbEntity;discard()V",
         shift = Shift.BEFORE
      )},
      cancellable = true
   )
   public void merge(ExperienceOrbEntity var1, CallbackInfo var2) {
      Map<Integer, Integer> var3 = ((IClumpedOrb)var1).clumps$getClumpedMap();
      this.pickingCount = this.clumps$getClumpedMap().values().stream().reduce(Integer::sum).orElse(1);
      this.orbAge = Math.min(this.orbAge, ((ExperienceOrbAccess)var1).clumps$getAge());
      this.clumps$setClumpedMap(
         Stream.of(this.clumps$getClumpedMap(), var3)
            .flatMap(var0 -> var0.entrySet().stream())
            .collect(Collectors.toMap(Entry::getKey, Entry::getValue, Integer::sum))
      );
      var1.discard();
      var2.cancel();
   }

   @Inject(
      method = {"wasMergedIntoExistingOrb(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/Vec3d;I)Z"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private static void tryMergeToExisting(ServerWorld var0, Vec3d var1, int var2, CallbackInfoReturnable<Boolean> var3) {
      Box var4 = Box.of(var1, 1.0, 1.0, 1.0);
      int var5 = var0.getRandom().nextInt(40);
      List var6 = var0.getEntitiesByType(TypeFilter.instanceOf(ExperienceOrbEntity.class), var4, var2xx -> isMergeable(var2xx, var5, var2));
      if (!var6.isEmpty()) {
         ExperienceOrbEntity var7 = (ExperienceOrbEntity)var6.getFirst();
         Map<Integer, Integer> var8 = ((IClumpedOrb)var7).clumps$getClumpedMap();
         ((IClumpedOrb)var7)
            .clumps$setClumpedMap(
               Stream.of(var8, Collections.singletonMap(var2, 1))
                  .flatMap(var0x -> var0x.entrySet().stream())
                  .collect(Collectors.toMap(Entry::getKey, Entry::getValue, Integer::sum))
            );
         ((ExperienceOrbAccess)var7).clumps$setCount(var8.values().stream().reduce(Integer::sum).orElse(1));
         ((ExperienceOrbAccess)var7).clumps$setAge(0);
         var3.setReturnValue(true);
      } else {
         var3.setReturnValue(false);
      }
   }

   @Inject(
      method = {"writeCustomData(Lnet/minecraft/storage/WriteView;)V"},
      at = {@At("TAIL")}
   )
   public void addAdditionalSaveData(WriteView var1, CallbackInfo var2) {
      if (this.clumps$clumpedMap != null) {
         NbtCompound var3 = new NbtCompound();
         this.clumps$getClumpedMap().forEach((var1x, var2x) -> var3.putInt(String.valueOf(var1x), var2x));
         var1.put("clumpedMap", NbtCompound.CODEC, var3);
      }
   }

   @Inject(
      method = {"readCustomData(Lnet/minecraft/storage/ReadView;)V"},
      at = {@At("TAIL")}
   )
   public void readAdditionalSaveData(ReadView var1, CallbackInfo var2) {
      HashMap var3 = new HashMap();
      var1.read("clumpedMap", NbtCompound.CODEC).ifPresentOrElse(var1x -> {
         for (String var3x : var1x.getKeys()) {
            var1x.getInt(var3x).ifPresent(var2x -> var3.put(Integer.parseInt(var3x), var2x));
         }
      }, () -> var3.put(this.getValue(), this.pickingCount));
      this.clumps$setClumpedMap(var3);
   }

   public Map<Integer, Integer> clumps$getClumpedMap() {
      if (this.clumps$clumpedMap == null) {
         this.clumps$clumpedMap = new HashMap<>();
         this.clumps$clumpedMap.put(this.getValue(), 1);
      }

      return this.clumps$clumpedMap;
   }

   public void clumps$setClumpedMap(Map<Integer, Integer> var1) {
      this.clumps$clumpedMap = var1;
      this.clumps$resolve();
   }

   public boolean clumps$resolve() {
      this.setValue(this.clumps$getClumpedMap().entrySet().stream().map(var0 -> var0.getKey() * var0.getValue()).reduce(Integer::sum).orElse(1));
      return this.getValue() > 0;
   }
}
