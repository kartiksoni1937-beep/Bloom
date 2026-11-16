/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.ClientConnection
 *  net.minecraft.network.listener.PacketListener
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket
 *  net.minecraft.network.packet.s2c.play.EntityDamageS2CPacket
 *  net.minecraft.network.packet.s2c.play.EntityStatusS2CPacket
 *  net.minecraft.network.packet.s2c.play.WorldTimeUpdateS2CPacket
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package net.caffeinemc.mods.lithium.lattice.bundle.overlay.relay;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.module.EventAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.ViewDelegate;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.CoreZoneProcessor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.NodeZoneRenderer;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.listener.PacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket;
import net.minecraft.network.packet.s2c.play.EntityDamageS2CPacket;
import net.minecraft.network.packet.s2c.play.EntityStatusS2CPacket;
import net.minecraft.network.packet.s2c.play.WorldTimeUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={ClientConnection.class})
public class EventComposer {
    @Inject(method={"handlePacket(Lnet/minecraft/network/packet/Packet;Lnet/minecraft/network/listener/PacketListener;)V"}, at={@At(value="HEAD")}, cancellable=true)
    private static <T extends PacketListener> void a(Packet<T> var0, PacketListener var1, CallbackInfo var2) {
        if (ConfigBridge.c != null) {
            if (var0 instanceof WorldTimeUpdateS2CPacket) {
                WorldTimeUpdateS2CPacket var10 = (WorldTimeUpdateS2CPacket)var0;
                if (ConfigBridge.c.a()) {
                    try {
                        CoreZoneProcessor.n(var10.time());
                    }
                    catch (Throwable throwable) {}
                }
            } else if (var0 instanceof EntityStatusS2CPacket) {
                EntityStatusS2CPacket var9 = (EntityStatusS2CPacket)var0;
                try {
                    byte var11 = var9.getStatus();
                    if (var11 == 35) {
                        if (NodeZoneRenderer.POPS_ON && ConfigBridge.c.a() && NodeZoneRenderer.POP_Q.size() < 64) {
                            NodeZoneRenderer.POP_Q.offer(var9);
                        }
                    } else if (var11 == 3 && NodeZoneRenderer.DEATH_ON && ConfigBridge.c.a() && NodeZoneRenderer.DEATH_Q.size() < 64) {
                        NodeZoneRenderer.DEATH_Q.offer(var9);
                    }
                }
                catch (Throwable var11) {}
            } else if (var0 instanceof EntityDamageS2CPacket) {
                EntityDamageS2CPacket var3 = (EntityDamageS2CPacket)var0;
                try {
                    if (NodeZoneRenderer.DEATH_ON) {
                        int var4 = NodeZoneRenderer.SELF_ID;
                        if (var4 != -1 && (var3.sourceCauseId() == var4 || var3.sourceDirectId() == var4) && ConfigBridge.c.a()) {
                            if (NodeZoneRenderer.DMG_Q.size() < 64) {
                                NodeZoneRenderer.DMG_Q.offer(var3);
                            }
                        } else if (var3.sourceCauseId() < 0 && var3.sourcePosition().isPresent()) {
                            Vec3d var5 = (Vec3d)var3.sourcePosition().get();
                            if (NodeZoneRenderer.ef(var5.x, var5.y, var5.z) && ConfigBridge.c.a() && NodeZoneRenderer.DMG_Q.size() < 64) {
                                NodeZoneRenderer.DMG_Q.offer(var3);
                            }
                        }
                    }
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
        }
    }

    @Inject(method={"send(Lnet/minecraft/network/packet/Packet;)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void b(Packet<?> var1, CallbackInfo var2) {
        if (NodeZoneRenderer.DEATH_ON && var1 instanceof PlayerInteractBlockC2SPacket) {
            try {
                BlockPos var3 = ((PlayerInteractBlockC2SPacket)var1).getBlockHitResult().getBlockPos();
                NodeZoneRenderer.ee(var3.getX(), var3.getY(), var3.getZ());
            }
            catch (Throwable var3) {
                // empty catch block
            }
        }
        if (ConfigBridge.c != null && EventAdapter.m && ConfigBridge.c.a()) {
            ViewDelegate var5 = new ViewDelegate(var1);
            EventAdapter.a(var5);
            if (var5.c()) {
                var2.cancel();
            }
        }
    }
}
