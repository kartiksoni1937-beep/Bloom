package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.ParserEngine;

public final class CalculateInterface extends BuilderFactory {
   public static volatile boolean ON;

   public CalculateInterface() {
      super("", "", ParserEngine.Z3);
      this.setName(
         new char[]{'㺗', '㻖', '㽸', '㽴', '㼺', '㼁', '㿽', '㿑', '㾴'},
         -106545447,
         new char[]{
            '鬰',
            '鮯',
            '鯅',
            '鯒',
            '鮱',
            '鮋',
            '鱹',
            '鱈',
            '鱺',
            '鰍',
            '鳰',
            '鳒',
            '鳶',
            '鲖',
            '鵦',
            '鵊',
            '鴡',
            '鴅',
            '鷱',
            '鷃',
            '鷮',
            '鶏',
            '鹣',
            '鹞',
            '鸤',
            '鸊',
            '黭',
            '麇',
            '麧',
            '麋',
            '齭',
            '齎',
            '鼣',
            '鼕',
            '鿩',
            '鿰',
            '鿐'
         },
         -854615198
      );
   }

   @Override
   public void c() {

      ON = true;
      super.c();
   }

   @Override
   public void d() {

      ON = false;
      super.d();
   }
}
