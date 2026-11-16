/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.entity.SignText
 *  net.minecraft.text.OrderedText
 *  net.minecraft.text.Text
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package net.caffeinemc.mods.lithium.lattice.bundle.overlay.relay;

import java.util.function.Function;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.ProfileTextCache;
import net.minecraft.block.entity.SignText;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={SignText.class})
public abstract class SignTextCache {
    @Shadow
    private OrderedText[] orderedMessages;
    @Unique
    private int b;

    @Inject(method={"getOrderedMessages(ZL;Ljava/util/function/Function;)[Lnet/minecraft/text/OrderedText;"}, at={@At(value="HEAD")})
    private void a(boolean var1, Function<Text, OrderedText> var2, CallbackInfoReturnable<OrderedText[]> var3) {
        int var4 = ProfileTextCache.GEN;
        if (this.b != var4) {
            this.b = var4;
            this.orderedMessages = null;
        }
    }
}
