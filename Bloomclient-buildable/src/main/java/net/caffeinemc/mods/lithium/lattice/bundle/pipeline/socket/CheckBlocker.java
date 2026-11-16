package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.InitNotifier;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.ParserEngine;

public final class CheckBlocker extends BuilderFactory implements InitNotifier {
   private static int aa = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   public CheckBlocker() {
      super("", "", ParserEngine.Z4);
      this.setName(
         new char[]{'꾉', '꿗', '끨', '끅', '뀿', '뀛', '냠'},
         -1410027558,
         new char[]{
            '뽯',
            '뽭',
            '뼇',
            '뿱',
            '뿓',
            '뾟',
            '뾧',
            '뾒',
            '쁩',
            '쀛',
            '쀩',
            '쀉',
            '샪',
            '샞',
            '삸',
            '삁',
            '셽',
            '셝',
            '섵',
            '셑',
            '쇱',
            '쇛',
            '쇮',
            '소',
            '쉠',
            '쉇',
            '쉪',
            '숝',
            '싡',
            '싊',
            '슣',
            '슖'
         },
         2060238628
      );
   }

   @Override
   public void c() {

      this.b.a(InitNotifier.class, this);
      super.c();
   }

   @Override
   public void d() {

      this.b.b(InitNotifier.class, this);
      super.d();
   }

   @Override
   public void a() {
      byte var1 = 0;

      while (true) {
         switch (var1) {
            case 0:
            default:
               if (aa != 0) {
                  Math.abs(Integer.MIN_VALUE);
                  var1 = 1;
                  break;
               }
            case 1:
               if (a.player != null) {
                  if (a.currentScreen != null) {
                     var1 = 2;
                  } else {
                     var1 = 3;
                  }
                  break;
               }
            case 2:
               return;
            case 3:
               if (!a.options.sprintKey.isPressed()) {
                  a.options.sprintKey.setPressed(true);
                  var1 = 4;
                  break;
               }
            case 4:
               if (a.player.input.playerInput.forward()) {
                  a.player.setSprinting(true);
                  var1 = 5;
                  break;
               }
            case 5:
               return;
         }
      }
   }
}
