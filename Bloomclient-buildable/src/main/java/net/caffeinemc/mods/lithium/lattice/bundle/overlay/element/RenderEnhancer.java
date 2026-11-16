/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.PlayerInventory
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.collection.DefaultedList
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package net.caffeinemc.mods.lithium.lattice.bundle.overlay.element;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={PlayerInventory.class})
public interface RenderEnhancer {
    @Accessor(value="selectedSlot")
    public int gSS();

    @Accessor(value="selectedSlot")
    public void sSS(int var1);

    @Accessor(value="main")
    public DefaultedList<ItemStack> Z5();
}
