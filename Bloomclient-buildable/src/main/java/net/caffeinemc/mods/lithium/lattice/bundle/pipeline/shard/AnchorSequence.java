package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import net.caffeinemc.mods.lithium.lattice.bundle.overlay.element.PendingUpdateAccessor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket;
import net.minecraft.network.packet.c2s.play.UpdateSelectedSlotC2SPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;

/**
 * Raw 1-tick anchor sequence: place anchor, charge it with glowstone and detonate it
 * in the same client tick using sequential interact-block packets. The slot changes
 * are sent in the same order so the server sees the anchor item and then the glowstone.
 */
public final class AnchorSequence {
   private static final MinecraftClient a = MinecraftClient.getInstance();

   private AnchorSequence() {
   }

   public static boolean placeChargeDetonate(BlockPos pos) {

      if (!canPlace(pos)) {
         return false;
      }

      int anchorSlot = findSlot(Items.RESPAWN_ANCHOR);
      int glowSlot = findSlot(Items.GLOWSTONE);
      if (anchorSlot < 0 || glowSlot < 0) {
         return false;
      }

      BlockHitResult hit = new BlockHitResult(Vec3d.ofCenter(pos), Direction.UP, pos, false);
      return select(anchorSlot)
         && send(hit)
         && select(glowSlot)
         && send(hit)
         && send(hit);
   }

   public static boolean chargeDetonate(BlockPos pos) {

      if (a.world == null || a.player == null || !TaskJoiner.a(pos, net.minecraft.block.Blocks.RESPAWN_ANCHOR)) {
         return false;
      }

      int glowSlot = findSlot(Items.GLOWSTONE);
      if (glowSlot < 0) {
         return false;
      }

      BlockHitResult hit = new BlockHitResult(Vec3d.ofCenter(pos), Direction.UP, pos, false);
      return select(glowSlot)
         && send(hit)
         && send(hit);
   }

   private static boolean canPlace(BlockPos pos) {

      return a.world != null
         && a.player != null
         && a.world.getBlockState(pos.down()).isSolid()
         && a.world.getBlockState(pos).isReplaceable()
         && a.world.getBlockState(pos.up()).isAir();
   }

   private static int findSlot(Item item) {

      if (a.player == null) {
         return -1;
      }

      for (int var1 = 0; var1 < 9; var1++) {
         if (a.player.getInventory().getStack(var1).isOf(item)) {
            return var1;
         }
      }

      return -1;
   }

   private static boolean select(int slot) {

      if (a.player == null || a.getNetworkHandler() == null) {
         return false;
      }

      if (InitExecutor.a(a.player.getInventory()) != slot) {
         InitExecutor.a(a.player.getInventory(), slot);
         a.getNetworkHandler().sendPacket(new UpdateSelectedSlotC2SPacket(slot));
      }

      return true;
   }

   private static boolean send(BlockHitResult hit) {

      if (a.player == null || a.world == null || a.getNetworkHandler() == null) {
         return false;
      }

      int seq = ((PendingUpdateAccessor)(Object)a.world).getPendingUpdateManager().incrementSequence().getSequence();
      a.getNetworkHandler().sendPacket(new PlayerInteractBlockC2SPacket(Hand.MAIN_HAND, hit, seq));
      a.player.swingHand(Hand.MAIN_HAND);
      return true;
   }
}
