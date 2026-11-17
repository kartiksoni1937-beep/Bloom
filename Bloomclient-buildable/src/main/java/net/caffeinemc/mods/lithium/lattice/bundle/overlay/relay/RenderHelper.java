/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.textures.GpuTexture
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.gl.RenderPipelines
 *  net.minecraft.client.gui.DrawContext
 *  net.minecraft.client.gui.hud.InGameHud
 *  net.minecraft.client.gui.hud.debug.DebugHudEntries
 *  net.minecraft.client.option.AttackIndicator
 *  net.minecraft.client.render.RenderTickCounter
 *  net.minecraft.client.texture.AbstractTexture
 *  net.minecraft.client.texture.NativeImage
 *  net.minecraft.client.texture.NativeImageBackedTexture
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.screen.NamedScreenHandlerFactory
 *  net.minecraft.util.Identifier
 *  net.minecraft.util.hit.BlockHitResult
 *  net.minecraft.util.hit.EntityHitResult
 *  net.minecraft.util.hit.HitResult
 *  net.minecraft.util.hit.HitResult$Type
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.GameMode
 *  net.minecraft.world.World
 *  org.joml.Matrix3x2fStack
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.caffeinemc.mods.lithium.lattice.bundle.overlay.relay;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTexture;
import java.util.Arrays;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.NodeZoneRenderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.gui.hud.debug.DebugHudEntries;
import net.minecraft.client.option.AttackIndicator;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameMode;
import net.minecraft.world.World;
import org.joml.Matrix3x2fStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={InGameHud.class})
public class RenderHelper {
    @Unique
    private static long k;
    @Unique
    private static float l;
    @Unique
    private static float m;
    @Unique
    private static float n;
    @Unique
    private static NativeImageBackedTexture o;
    @Unique
    private static Identifier p;
    @Unique
    private static boolean q;
    @Unique
    private static int r;
    @Unique
    private static int[] s;
    @Unique
    private static int[] t;
    @Unique
    private static final float u = 0.18f;
    @Unique
    private static final float v = 0.22f;
    @Unique
    private static final long w = 250000000L;
    @Unique
    private static final float x = 0.09f;
    @Unique
    private static float y;
    @Unique
    private static long z;
    @Unique
    private static boolean aa;
    @Unique
    private static float ab;
    @Unique
    private static int ac;
    @Unique
    private static boolean ad;
    @Unique
    private static float ae;
    @Unique
    private static float af;
    @Unique
    private static float ag;
    @Unique
    private static float ah;
    @Unique
    private static float ai;

    @Inject(method={"renderCrosshair(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/client/render/RenderTickCounter;)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void a(DrawContext var1, RenderTickCounter var2, CallbackInfo var3) {
        aa = false;
        if (y == 0.0f) {
            if (ConfigBridge.c == null || !NodeZoneRenderer.ON) {
                return;
            }
            NodeZoneRenderer var4 = NodeZoneRenderer.INSTANCE;
            if (var4 == null || !var4.ln) {
                return;
            }
        }
        if (RenderHelper.b(var1, var2)) {
            var3.cancel();
        }
    }

    @Unique
    private static boolean b(DrawContext var0, RenderTickCounter var1) {
        NodeZoneRenderer var2 = null;
        MinecraftClient var3 = null;
        try {
            boolean var4;
            var2 = NodeZoneRenderer.INSTANCE;
            boolean bl = var4 = NodeZoneRenderer.ON && var2 != null && var2.ln;
            if (!var4 && y == 0.0f) {
                return false;
            }
            if (var2 == null || ConfigBridge.c == null || !ConfigBridge.c.a()) {
                y = 0.0f;
                z = 0L;
                return false;
            }
            long var5 = System.nanoTime();
            long var7 = z;
            float var9 = y;
            if (var7 != 0L) {
                if (var5 - var7 > 250000000L) {
                    var9 = var4 ? 1.0f : 0.0f;
                } else {
                    float var10 = (float)(var5 - var7) / 1.0E9f;
                    if (var10 < 0.0f) {
                        var10 = 0.0f;
                    } else if (var10 > 0.1f) {
                        var10 = 0.1f;
                    }
                    var9 = var4 ? Math.min(1.0f, var9 + var10 / 0.18f) : Math.max(0.0f, var9 - var10 / 0.22f);
                }
            }
            y = var9;
            long l = z = !var4 && var9 <= 0.0f ? 0L : var5;
            if (var9 <= 0.0f) {
                return false;
            }
            var3 = MinecraftClient.getInstance();
            if (var3.player == null || !var3.options.getPerspective().isFirstPerson()) {
                return false;
            }
            if (var3.interactionManager != null && var3.interactionManager.getCurrentGameMode() == GameMode.SPECTATOR && !RenderHelper.e(var3)) {
                return false;
            }
            if (var3.debugHudEntryList != null && var3.debugHudEntryList.isEntryVisible(DebugHudEntries.THREE_DIMENSIONAL_CROSSHAIR)) {
                return false;
            }
            float var14 = var9 * var9 * (3.0f - 2.0f * var9);
            if (var4 && var14 >= 0.6f) {
                RenderHelper.d(var0, var1, var2, var3, var14);
                return true;
            }
            ab = var14;
            aa = true;
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return false;
    }

    @Inject(method={"renderCrosshair(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/client/render/RenderTickCounter;)V"}, at={@At(value="TAIL")})
    private void c(DrawContext var1, RenderTickCounter var2, CallbackInfo var3) {
        if (aa) {
            NodeZoneRenderer var4 = null;
            try {
                aa = false;
                var4 = NodeZoneRenderer.INSTANCE;
                if (var4 != null) {
                    RenderHelper.d(var1, var2, var4, MinecraftClient.getInstance(), ab);
                }
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Unique
    private static void d(DrawContext var0, RenderTickCounter var1, NodeZoneRenderer var2, MinecraftClient var3, float var4) {
        double var5 = var3.getWindow().getScaleFactor();
        if (var5 <= 0.0) {
            var5 = 1.0;
        }
        int var7 = (int)Math.round((double)var3.getWindow().getScaledWidth() * var5 / 2.0);
        int var8 = (int)Math.round((double)var3.getWindow().getScaledHeight() * var5 / 2.0);
        Matrix3x2fStack var9 = var0.getMatrices();
        var9.pushMatrix();
        try {
            var9.scale((float)(1.0 / var5), (float)(1.0 / var5));
            RenderHelper.f(var0, var1, var2, var3, var7, var8, var4);
        }
        finally {
            var9.popMatrix();
        }
    }

    @Unique
    private static boolean e(MinecraftClient var0) {
        HitResult var1 = var0.crosshairTarget;
        if (var1 == null) {
            return false;
        }
        if (var1.getType() == HitResult.Type.ENTITY && var1 instanceof EntityHitResult) {
            EntityHitResult var4 = (EntityHitResult)var1;
            return var4.getEntity() instanceof NamedScreenHandlerFactory;
        }
        if (var1.getType() == HitResult.Type.BLOCK && var1 instanceof BlockHitResult) {
            BlockHitResult var2 = (BlockHitResult)var1;
            if (var0.world != null) {
                BlockPos var3 = var2.getBlockPos();
                return var0.world.getBlockState(var3).createScreenHandlerFactory((World)var0.world, var3) != null;
            }
        }
        return false;
    }

    @Unique
    private static void f(DrawContext var0, RenderTickCounter var1, NodeZoneRenderer var2, MinecraftClient var3, int var4, int var5, float var6) {
        float var66;
        float var61;
        float var62;
        float var124;
        LivingEntity var35;
        Entity entity;
        boolean var122;
        float var123;
        float var29;
        boolean var20;
        long var7 = System.nanoTime();
        long var9 = k;
        boolean var11 = var9 == 0L || var7 - var9 > 250000000L;
        float var12 = var9 == 0L ? 0.0f : (float)(var7 - var9) / 1.0E9f;
        k = var7;
        if (var12 < 0.0f) {
            var12 = 0.0f;
        }
        if (var12 > 0.1f) {
            var12 = 0.1f;
        }
        float var13 = 1.0f - (float)Math.exp(-14.0 * (double)var12);
        long var14 = var7 / 1000000L;
        int var16 = var2.lp;
        float var17 = var2.lq;
        float var18 = var2.lr;
        int var19 = var2.lo;
        boolean bl = var20 = (var16 & 2) != 0;
        if (var11) {
            ac = var19;
            ad = var20;
            ae = 1.0f;
        } else if (var19 != ac || var20 != ad) {
            float var21 = ae - var12 / 0.09f;
            if (var21 <= 0.0f) {
                var21 = 0.0f;
                ac = var19;
                ad = var20;
            }
            ae = var21;
        } else if (ae < 1.0f) {
            ae = Math.min(1.0f, ae + var12 / 0.09f);
        }
        int var117 = ac;
        boolean var22 = ad;
        float var23 = ae;
        float var24 = var6 * var23 * var23 * (3.0f - 2.0f * var23);
        int var25 = var2.csRgb & 0xFFFFFF;
        float var26 = var25 >> 16 & 0xFF;
        float var27 = var25 >> 8 & 0xFF;
        float var28 = var25 & 0xFF;
        float f = var29 = (var16 & 1) != 0 ? 1.0f : 0.0f;
        if (var11) {
            af = var26;
            ag = var27;
            ah = var28;
            ai = var29;
        } else {
            float var30 = af + (var26 - af) * var13;
            float var31 = ag + (var27 - ag) * var13;
            float var32 = ah + (var28 - ah) * var13;
            float var33 = ai + (var29 - ai) * var13;
            af = Math.abs(var26 - var30) < 0.5f ? var26 : var30;
            ag = Math.abs(var27 - var31) < 0.5f ? var27 : var31;
            ah = Math.abs(var28 - var32) < 0.5f ? var28 : var32;
            ai = Math.abs(var29 - var33) < 0.002f ? var29 : var33;
        }
        float var118 = af;
        float var119 = ag;
        float var120 = ah;
        float var121 = ai;
        if (var121 > 0.0f) {
            int var34 = RenderHelper.i((float)(var14 % 3000L) / 3000.0f, 0.85f, 1.0f);
            var118 += ((float)(var34 >> 16 & 0xFF) - var118) * var121;
            var119 += ((float)(var34 >> 8 & 0xFF) - var119) * var121;
            var120 += ((float)(var34 & 0xFF) - var120) * var121;
        }
        if (Math.abs((var123 = (var122 = (var16 & 8) != 0 && (entity = var3.targetedEntity) instanceof LivingEntity && (var35 = (LivingEntity)entity).isAlive()) ? 1.0f : 0.0f) - (m += (var123 - m) * var13)) < 0.002f) {
            m = var123;
        }
        if ((var124 = m) > 0.001f) {
            var118 += (255.0f - var118) * var124;
            var119 += (59.0f - var119) * var124;
            var120 += (59.0f - var120) * var124;
        }
        float var37 = 0.0f;
        if ((var16 & 0x10) != 0) {
            Vec3d var38 = var3.player.getVelocity();
            double var39 = Math.sqrt(var38.x * var38.x + var38.z * var38.z);
            var37 = (float)((Math.min(1.0, var39 / 0.3) * 3.0 + (var3.player.isOnGround() ? 0.0 : 2.0) - (var3.player.isSneaking() ? 0.6 : 0.0)) * (double)var17);
        }
        if (Math.abs(var37 - (l += (var37 - l) * var13)) < 0.004f) {
            l = var37;
        }
        float var125 = l;
        float var126 = 1.0f;
        if (var3.options.getAttackIndicator().getValue() == AttackIndicator.CROSSHAIR) {
            var126 = var3.player.getAttackCooldownProgress(var1.getTickProgress(true));
        }
        n = var126 < 1.0f ? 1.0f : Math.max(0.0f, n - var12 / 0.18f);
        float var40 = n * n * (3.0f - 2.0f * n);
        boolean var41 = var40 > 0.001f;
        long var42 = var14 - NodeZoneRenderer.HIT_MS;
        boolean var44 = (var16 & 4) != 0 && var42 >= 0L && var42 < 260L;
        float var45 = var44 ? (float)var42 / 260.0f : 1.0f;
        float var46 = 1.0f - var45;
        float var47 = var44 ? var46 * var46 : 0.0f;
        float var48 = 1.0f - var46 * var46 * var46;
        float var49 = 3.0f * var17 + var125 + 1.5f * var17 * var48;
        float var50 = var49 + 4.2f * var17;
        float var51 = 0.55f * var17 + 0.35f;
        float var52 = Math.min(1.0f, 1.9f * var47);
        float var53 = 0.0f;
        float var54 = 0.0f;
        float var55 = 1.0f;
        float var56 = 0.0f;
        float var57 = 0.0f;
        float var58 = 0.0f;
        float var59 = 0.0f;
        float var60 = 0.0f;
        if (var117 == 1) {
            var57 = Math.max(0.0f, var2.ls * var17 + var125);
            var58 = var57 + 3.9f * var17;
            var59 = 0.9f * var18 * var17;
            var60 = 2.0f * var17;
            var62 = Math.max(var58 + 1.5f, Math.max(var60 + 0.5f, var59 + 1.5f));
            var61 = var58 + 1.5f * var17 + 2.5f * var17;
        } else if (var117 == 2) {
            var56 = 1.8f * var17 * (float)Math.sqrt(var18);
            var55 = 2.4f * var17;
            var62 = var56 + Math.max(1.5f, var55);
            var61 = var56 + 2.0f * var17 + 2.5f * var17;
        } else {
            var53 = Math.max(1.0f, 5.5f * var17 + var125);
            var54 = 0.9f * var18 * var17;
            var55 = 3.0f * var17;
            var56 = 1.4f * var17 * (0.6f + 0.4f * var18);
            var62 = var53 + Math.max(var54 + 1.5f, var55);
            var61 = var53 + var54 + 2.5f * var17;
        }
        float var63 = 0.8f * var17;
        float var64 = var62;
        if (var44) {
            var64 = Math.max(var62, var50 + 0.5f);
        }
        if (var41) {
            var64 = Math.max(var64, var61 + var63 + 0.5f);
        }
        int var65 = (int)Math.ceil(var64 + 2.0f);
        if (var117 == 1) {
            float var67 = var58 + 1.6f;
            float var68 = Math.max(var59, var60) + 1.6f;
            var66 = (float)Math.sqrt(var67 * var67 + var68 * var68);
        } else {
            var66 = var62 + 1.0f;
        }
        if (var44 && var50 + 1.0f > var66) {
            var66 = var50 + 1.0f;
        }
        if (var41 && var61 + var63 + 1.0f > var66) {
            var66 = var61 + var63 + 1.0f;
        }
        float var127 = var66 * var66;
        float var128 = var59 + 0.5f;
        float var69 = var59 + 1.5f;
        float var70 = var57 - 0.5f;
        float var71 = var57 - 1.5f;
        float var72 = var58 + 0.5f;
        float var73 = var58 + 1.5f;
        float var74 = var58 + 1.3f;
        float var75 = var60 + 0.5f;
        float var76 = var56 + 0.5f;
        float var77 = var56 + 1.5f;
        float var78 = var54 + 0.5f;
        float var79 = var54 + 1.5f;
        float var80 = var55 > 1.0E-4f ? 1.0f / var55 : 0.0f;
        float var81 = var63 + 0.5f;
        float var82 = var63 + 1.0f;
        float var83 = (float)Math.PI * 2 * var61;
        float var84 = var49 - 0.5f;
        float var85 = var50 + 0.5f;
        float var86 = var51 + 0.5f;
        NativeImage var87 = null;
        if (!q && var65 <= 63 && (var87 = RenderHelper.g()) != null) {
            int[] var88 = t;
            var88[0] = var117 | (var22 ? 4 : 0) | (var41 ? 8 : 0) | (var44 ? 16 : 0);
            var88[1] = Float.floatToRawIntBits(var17);
            var88[2] = Float.floatToRawIntBits(var18);
            var88[3] = Float.floatToRawIntBits(var57);
            var88[4] = Float.floatToRawIntBits(var125);
            var88[5] = Float.floatToRawIntBits(var118);
            var88[6] = Float.floatToRawIntBits(var119);
            var88[7] = Float.floatToRawIntBits(var120);
            var88[8] = var41 ? Float.floatToRawIntBits(var126) : 0;
            var88[9] = var41 ? Float.floatToRawIntBits(var40) : 0;
            var88[10] = var44 ? Float.floatToRawIntBits(var52) : 0;
            int n = var88[11] = var44 ? Float.floatToRawIntBits(var48) : 0;
            if (r >= 0 && Arrays.equals(var88, s)) {
                RenderHelper.h(var0, var4, var5, var65, var24);
                return;
            }
            int var89 = r;
            if (var89 >= 0) {
                var87.fillRect(64 - var89, 64 - var89, 2 * var89 + 1, 2 * var89 + 1, 0);
            }
        }
        if (var87 != null || !(var24 < 0.002f)) {
            float var129 = var87 != null ? 1.0f : var24;
            for (int var130 = -var65; var130 <= var65; ++var130) {
                float var90 = var130;
                float var91 = var90 * var90;
                float var92 = var127 - var91;
                if (var92 <= 0.0f) continue;
                int var93 = (int)Math.sqrt(var92) + 1;
                if (var93 > var65) {
                    var93 = var65;
                }
                int var94 = -var93;
                int var95 = 0;
                float var96 = Math.abs(var90);
                for (int var97 = -var93; var97 <= var93; ++var97) {
                    float var143;
                    float var145;
                    float var109;
                    float var142;
                    float var101;
                    float var98 = var97;
                    float var99 = Math.abs(var98);
                    float var100 = (float)Math.sqrt(var98 * var98 + var91);
                    float var102 = 0.0f;
                    float var103 = 0.0f;
                    if (var117 == 1) {
                        float var104 = RenderHelper.j(var128 - var96) * RenderHelper.j(var99 - var70) * RenderHelper.j(var72 - var99);
                        float var105 = RenderHelper.j(var128 - var99) * RenderHelper.j(var96 - var70) * RenderHelper.j(var72 - var96);
                        var101 = Math.max(var104, var105);
                        if (var22) {
                            float var106 = RenderHelper.j(var69 - var96) * RenderHelper.j(var99 - var71) * RenderHelper.j(var73 - var99);
                            float var107 = RenderHelper.j(var69 - var99) * RenderHelper.j(var96 - var71) * RenderHelper.j(var73 - var96);
                            var103 = Math.max(var106, var107) * 0.85f;
                        } else {
                            float var137 = RenderHelper.j(var75 - var96) * RenderHelper.j(var99 - var70) * RenderHelper.j(var74 - var99);
                            float var139 = RenderHelper.j(var75 - var99) * RenderHelper.j(var96 - var70) * RenderHelper.j(var74 - var96);
                            var102 = Math.max(var137, var139) * 0.28f;
                        }
                    } else if (var117 == 2) {
                        var101 = RenderHelper.j(var76 - var100);
                        if (var22) {
                            var103 = RenderHelper.j(var77 - var100) * 0.85f;
                        } else {
                            var102 = RenderHelper.j(1.0f - (var100 - var56) * var80) * 0.3f;
                        }
                    } else {
                        float var134 = Math.abs(var100 - var53);
                        var101 = Math.max(RenderHelper.j(var78 - var134), RenderHelper.j(var76 - var100));
                        if (var22) {
                            var103 = Math.max(RenderHelper.j(var79 - var134), RenderHelper.j(var77 - var100)) * 0.85f;
                        } else {
                            var102 = RenderHelper.j(1.0f - var134 * var80) * 0.3f;
                        }
                    }
                    float var135 = 0.0f;
                    float var136 = 0.0f;
                    float var138 = 0.0f;
                    float var140 = 0.0f;
                    if (var102 > 0.0f) {
                        var136 = var118 * var102;
                        var138 = var119 * var102;
                        var140 = var120 * var102;
                        var135 = var102;
                    }
                    if (var103 > 0.0f) {
                        float var108 = 1.0f - var103;
                        var136 *= var108;
                        var138 *= var108;
                        var140 *= var108;
                        var135 = var103 + var135 * var108;
                    }
                    if (var101 > 0.0f) {
                        float var141 = 1.0f - var101;
                        var136 = var118 * var101 + var136 * var141;
                        var138 = var119 * var101 + var138 * var141;
                        var140 = var120 * var101 + var140 * var141;
                        var135 = var101 + var135 * var141;
                    }
                    if (var41 && (var142 = Math.abs(var100 - var61)) < var82 && (var109 = RenderHelper.j(var81 - var142)) > 0.0f) {
                        double var110 = Math.atan2(var98, -var90);
                        if (var110 < 0.0) {
                            var110 += Math.PI * 2;
                        }
                        float var112 = (float)(var110 / (Math.PI * 2));
                        float var113 = RenderHelper.j((var126 - var112) * var83 + 0.5f);
                        float var114 = var109 * (0.25f + 0.65f * var113) * var40;
                        float var115 = 1.0f - var114;
                        var136 = 255.0f * var114 + var136 * var115;
                        var138 = 255.0f * var114 + var138 * var115;
                        var140 = 255.0f * var114 + var140 * var115;
                        var135 = var114 + var135 * var115;
                    }
                    if (var44 && (var145 = RenderHelper.j(var86 - (var143 = Math.min(Math.abs(var98 - var90), Math.abs(var98 + var90)) * 0.70710677f)) * RenderHelper.j(var100 - var84) * RenderHelper.j(var85 - var100) * var52) > 0.0f) {
                        float var147 = 1.0f - var145;
                        var136 = 255.0f * var145 + var136 * var147;
                        var138 = 255.0f * var145 + var138 * var147;
                        var140 = 255.0f * var145 + var140 * var147;
                        var135 = var145 + var135 * var147;
                    }
                    int var144 = 0;
                    float var146 = var135 * var129;
                    if (var146 > 0.004f) {
                        int var148 = Math.round(var146 * 63.75f) << 2;
                        if (var148 > 255) {
                            var148 = 255;
                        }
                        if (var148 > 0) {
                            float var111 = 1.0f / var135;
                            int var149 = Math.min(255, Math.round(var136 * var111));
                            int var150 = Math.min(255, Math.round(var138 * var111));
                            int var151 = Math.min(255, Math.round(var140 * var111));
                            var144 = var148 << 24 | var149 << 16 | var150 << 8 | var151;
                        }
                    }
                    if (var87 != null) {
                        if (var144 == 0) continue;
                        var87.setColorArgb(64 + var97, 64 + var130, var144);
                        continue;
                    }
                    if (var144 == var95) continue;
                    if (var95 != 0) {
                        var0.fill(var4 + var94, var5 + var130, var4 + var97, var5 + var130 + 1, var95);
                    }
                    var94 = var97;
                    var95 = var144;
                }
                if (var95 == 0) continue;
                var0.fill(var4 + var94, var5 + var130, var4 + var93 + 1, var5 + var130 + 1, var95);
            }
            if (var87 != null) {
                int var131 = Math.max(var65, r);
                int var132 = 64 - var131;
                int var133 = 2 * var131 + 1;
                try {
                    RenderSystem.getDevice().createCommandEncoder().writeToTexture(o.getGlTexture(), var87, 0, 0, var132, var132, var133, var133, var132, var132);
                }
                catch (RuntimeException var116) {
                    q = true;
                    throw var116;
                }
                r = var65;
                System.arraycopy(t, 0, s, 0, s.length);
                RenderHelper.h(var0, var4, var5, var65, var24);
            }
        }
    }

    @Unique
    private static NativeImage g() {
        NativeImageBackedTexture var0 = o;
        if (var0 != null) {
            GpuTexture var7 = var0.getGlTexture();
            NativeImage var8 = var0.getImage();
            if (var7 != null && !var7.isClosed() && var8 != null) {
                return var8;
            }
            q = true;
            return null;
        }
        NativeImageBackedTexture var1 = null;
        Identifier var2 = null;
        try {
            var1 = new NativeImageBackedTexture("lithium-crosshair", 128, 128, false);
            var1.getImage().fillRect(0, 0, 128, 128, 0);
            var1.upload();
            var2 = Identifier.of((String)"lithium", (String)"crosshair_bake");
            MinecraftClient.getInstance().getTextureManager().registerTexture(var2, (AbstractTexture)var1);
            p = var2;
            t = new int[12];
            s = new int[12];
            r = -1;
            o = var1;
            return var1.getImage();
        }
        catch (Throwable var6) {
            q = true;
            if (var1 != null && var2 == null) {
                try {
                    var1.close();
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
            return null;
        }
    }

    @Unique
    private static void h(DrawContext var0, int var1, int var2, int var3, float var4) {
        int var5;
        int n = var5 = var4 >= 1.0f ? 255 : (int)(var4 * 255.0f + 0.5f);
        if (var5 > 0) {
            int var6 = 2 * var3 + 1;
            var0.drawTexture(RenderPipelines.GUI_TEXTURED, p, var1 - var3, var2 - var3, (float)(64 - var3), (float)(64 - var3), var6, var6, 128, 128, var5 << 24 | 0xFFFFFF);
        }
    }

    @Unique
    private static int i(float var0, float var1, float var2) {
        int var3 = 0;
        int var4 = 0;
        int var5 = 0;
        if (var1 == 0.0f) {
            var4 = var5 = (int)(var2 * 255.0f + 0.5f);
            var3 = var5;
        } else {
            float var6 = (var0 - (float)Math.floor(var0)) * 6.0f;
            float var7 = var6 - (float)Math.floor(var6);
            float var8 = var2 * (1.0f - var1);
            float var9 = var2 * (1.0f - var1 * var7);
            float var10 = var2 * (1.0f - var1 * (1.0f - var7));
            switch ((int)var6) {
                case 0: {
                    var3 = (int)(var2 * 255.0f + 0.5f);
                    var4 = (int)(var10 * 255.0f + 0.5f);
                    var5 = (int)(var8 * 255.0f + 0.5f);
                    break;
                }
                case 1: {
                    var3 = (int)(var9 * 255.0f + 0.5f);
                    var4 = (int)(var2 * 255.0f + 0.5f);
                    var5 = (int)(var8 * 255.0f + 0.5f);
                    break;
                }
                case 2: {
                    var3 = (int)(var8 * 255.0f + 0.5f);
                    var4 = (int)(var2 * 255.0f + 0.5f);
                    var5 = (int)(var10 * 255.0f + 0.5f);
                    break;
                }
                case 3: {
                    var3 = (int)(var8 * 255.0f + 0.5f);
                    var4 = (int)(var9 * 255.0f + 0.5f);
                    var5 = (int)(var2 * 255.0f + 0.5f);
                    break;
                }
                case 4: {
                    var3 = (int)(var10 * 255.0f + 0.5f);
                    var4 = (int)(var8 * 255.0f + 0.5f);
                    var5 = (int)(var2 * 255.0f + 0.5f);
                    break;
                }
                case 5: {
                    var3 = (int)(var2 * 255.0f + 0.5f);
                    var4 = (int)(var8 * 255.0f + 0.5f);
                    var5 = (int)(var9 * 255.0f + 0.5f);
                }
            }
        }
        return var3 << 16 | var4 << 8 | var5;
    }

    @Unique
    private static float j(float var0) {
        return var0 < 0.0f ? 0.0f : (var0 > 1.0f ? 1.0f : var0);
    }
}
