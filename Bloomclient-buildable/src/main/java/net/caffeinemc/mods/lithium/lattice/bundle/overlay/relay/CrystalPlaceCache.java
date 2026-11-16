/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Blocks
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.item.EndCrystalItem
 *  net.minecraft.item.ItemUsageContext
 *  net.minecraft.item.Items
 *  net.minecraft.util.ActionResult
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.util.hit.HitResult
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Box
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.caffeinemc.mods.lithium.lattice.bundle.overlay.relay;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.CalculateInterface;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.LinkCacheLoader;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.EndCrystalItem;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={EndCrystalItem.class})
public class CrystalPlaceCache {
    @Inject(method={"useOnBlock(Lnet/minecraft/item/ItemUsageContext;)Lnet/minecraft/util/ActionResult;"}, at={@At(value="HEAD")}, require=0)
    private void a(ItemUsageContext var1, CallbackInfoReturnable<ActionResult> var2) {
        try {
            double var12;
            double var10;
            if (!var1.getWorld().isClient()) {
                return;
            }
            if (ConfigBridge.c == null || !CalculateInterface.ON && !LinkCacheLoader.NB) {
                return;
            }
            if (!ConfigBridge.c.a() || ConfigBridge.c.c() == null) {
                return;
            }
            CalculateInterface var3 = ConfigBridge.c.c().a(CalculateInterface.class);
            if (!(var3 != null && var3.f() || LinkCacheLoader.NB)) {
                return;
            }
            MinecraftClient var4 = MinecraftClient.getInstance();
            if (var4.player == null || var4.world == null) {
                return;
            }
            if (!var4.player.getMainHandStack().isOf(Items.END_CRYSTAL)) {
                return;
            }
            HitResult hitResult = var4.crosshairTarget;
            if (!(hitResult instanceof BlockHitResult)) {
                return;
            }
            BlockHitResult var5 = (BlockHitResult)hitResult;
            BlockPos var15 = var5.getBlockPos();
            if (!var4.world.getBlockState(var15).isOf(Blocks.OBSIDIAN) && !var4.world.getBlockState(var15).isOf(Blocks.BEDROCK)) {
                return;
            }
            BlockPos var7 = var15.up();
            if (!var4.world.isAir(var7)) {
                return;
            }
            double var8 = var7.getX();
            if (!var4.world.getOtherEntities(null, new Box(var8, var10 = (double)var7.getY(), var12 = (double)var7.getZ(), var8 + 1.0, var10 + 2.0, var12 + 1.0)).isEmpty()) {
                return;
            }
            var1.getStack().increment(1);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }
}
