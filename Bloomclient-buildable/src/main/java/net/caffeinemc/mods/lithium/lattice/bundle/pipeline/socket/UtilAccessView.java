package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.InitNotifier;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.ParserEngine;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.ItemDescriptor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.SlotInspector;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.item.Items;

public final class UtilAccessView extends BuilderFactory implements InitNotifier {
   private final ItemDescriptor aa;
   private boolean ba;
   private static int c = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   public UtilAccessView() {
      super("", "", ParserEngine.CT);
      this.setName(
         new char[]{'ꇂ', 'ꆛ', 'ꆻ', 'ꆇ', 'ꉷ', 'ꉜ', 'ꉰ', 'ꈠ', 'ꋨ', 'ꋋ', 'ꊤ', 'ꊊ', 'ꍤ', 'ꍍ'},
         1324786070,
         new char[]{
            '腹',
            '腧',
            '脍',
            '至',
            '膆',
            '膑',
            '膋',
            '艷',
            '艇',
            '般',
            '艀',
            '舴',
            '苻',
            '苄',
            '苼',
            '芙',
            '荿',
            '荕',
            '茷',
            '茀',
            '莺',
            '莕',
            '莠',
            '莛',
            '葷',
            '葟',
            '葰',
            '萟',
            '蓼',
            '蓈',
            '蒿',
            '蒘',
            '蔪',
            '蕀',
            '蔼',
            '蕇',
            '藲',
            '藊',
            '藤',
            '薎',
            '虭',
            '虗',
            '蘥',
            '虿',
            '蘟',
            '蚽',
            '蛔',
            '蚴',
            '蚎',
            '蝻',
            '蝙',
            '蜥',
            '蝖',
            '蟡',
            '蟛',
            '螧',
            '螗',
            '衼',
            '蠐',
            '蠦',
            '蠀',
            '裹',
            '裃',
            '裫',
            '袓',
            '襦',
            '襝',
            '褵',
            '襆',
            '觪',
            '观',
            '覥',
            '覊',
            '詠',
            '詎',
            '詛'
         },
         -1097367254
      );
      ItemDescriptor var10001 = new ItemDescriptor("", -1, false);
      var10001.n(new char[]{'髉', '骒', '骴', '骎', '魼', '魕', '魷', '鬽', '鯰', '鯍'}, -875390307);
      this.aa = var10001;
      this.a(new InitAdapter[]{this.aa});
   }

   @Override
   public void c() {

      this.b.a(InitNotifier.class, this);
      int var1 = this.aa.g();
      this.ba = var1 != -1 && SlotInspector.a(var1);
      super.c();
   }

   @Override
   public void d() {

      this.b.b(InitNotifier.class, this);
      super.d();
   }

   @Override
   public void a() {

      int var1 = this.aa.g();
      boolean var2 = var1 != -1 && SlotInspector.a(var1);
      boolean var3 = var2 && !this.ba;
      this.ba = var2;
      if (var3 && a.player != null && a.interactionManager != null) {
         if (a.currentScreen == null) {
            if (!a.player.getOffHandStack().isOf(Items.TOTEM_OF_UNDYING)) {
               int var4 = -1;

               for (int var5 = 0; var5 < 9; var5++) {
                  if (a.player.getInventory().getStack(var5).isOf(Items.TOTEM_OF_UNDYING)) {
                     var4 = var5;
                     break;
                  }
               }

               if (var4 != -1) {
                  try {
                     PlayerScreenHandler var7 = a.player.playerScreenHandler;
                     a.interactionManager.clickSlot(var7.syncId, 36 + var4, 40, SlotActionType.SWAP, a.player);
                  } catch (Throwable var6) {
                  }
               }
            }
         }
      }
   }
}
