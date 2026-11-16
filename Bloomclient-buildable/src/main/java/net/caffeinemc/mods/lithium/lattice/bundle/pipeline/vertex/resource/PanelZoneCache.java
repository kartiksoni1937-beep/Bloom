package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource;

import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Consumer;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.SyncDispatcher;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.ItemDescriptor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.StyleKeyCache;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.text.Text;
import net.minecraft.text.Style;
import net.minecraft.util.Identifier;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.font.TextHandler;
import net.minecraft.text.OrderedText;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.client.network.ClientPlayerEntity;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fStack;
import net.minecraft.entity.Entity;
public final class PanelZoneCache {
   static boolean POT_LIVE = true;
   private static final String[] ad = new String[]{
      "PotionsLi" + "st",
      "KeyBinds",
      "Speed",
      "**:**",
      "Click" + " " + "GUI",
      "N" + "o binds" + " " + "set",
      " more",
      "%.2f bps",
      "lithium-hu" + "d" + "2" + "-speed",
      "lithium-hud2-keypill",
      "Right ",
      "Left ",
      "Grave " + "Accent",
      "Grave",
      "?"
   };
   private static final int ae = 0;
   private static final int af = 1;
   private static final int ag = 2;
   private static final int ah = 3;
   private static final int ai = 4;
   private static final int aj = 5;
   private static final int ak = 6;
   private static final int al = 7;
   private static final int am = 8;
   private static final int an = 9;
   private static final int ao = 10;
   private static final int ap = 11;
   private static final int aq = 12;
   private static final int ar = 13;
   private static final int as = 14;
   private static final Identifier at = Identifier.of("lithium", "hud2_speed_" + "g" + "r" + "aph");
   private static final Identifier au = Identifier.of("lithium", "hud2" + "_key_p" + "i" + "ll");
   private static final Matrix3x2f av = new Matrix3x2f();
   private static final float aw = 0.18F;
   private static final long ax = 250000000L;
   private static final int ay = 32;
   private static final Object[] az = new Object[32];
   private static final StatusEffectInstance[] ba = new StatusEffectInstance[32];
   private static final boolean[] bb = new boolean[32];
   private static final boolean[] bc = new boolean[32];
   private static final boolean[] bd = new boolean[32];
   private static final boolean[] be = new boolean[32];
   private static final float[] bf = new float[32];
   private static final float[] bg = new float[32];
   private static final float[] bh = new float[32];
   private static final float[] bi = new float[32];
   private static final int[] bj = new int[32];
   private static final int[] bk = new int[32];
   private static final int[] bl = new int[32];
   private static final int[] bm = new int[32];
   private static final int[] bn = new int[32];
   private static final int[] bo = new int[32];
   private static final String[] bp = new String[32];
   private static final Text[] bq = new Text[32];
   private static final Text[] br = new Text[32];
   private static final Identifier[] bs = new Identifier[32];
   private static int bt = 0;
   private static int bu = 0;
   private static int bv = -1;
   private static int bw = 0;
   private static long bx = 0L;
   private static long by = 0L;
   private static boolean bz = false;
   private static boolean ca = false;
   private static float cb = 0.0F;
   private static float cc = 0.0F;
   private static float cd = 0.0F;
   private static float ce = 0.0F;
   private static int cf = Integer.MIN_VALUE;
   private static Text cg;
   private static float ch = 0.0F;
   private static int ci = Integer.MIN_VALUE;
   private static int cj = Integer.MIN_VALUE;
   private static final Consumer<StatusEffectInstance> ck = PanelZoneCache::c;
   private static final int cl = 160;
   private static final int cm = 16;
   private static final BuilderFactory[] cn = new BuilderFactory[160];
   private static final boolean[] co = new boolean[160];
   private static final boolean[] cp = new boolean[160];
   private static final boolean[] cq = new boolean[160];
   private static final boolean[] cr = new boolean[160];
   private static final float[] cs = new float[160];
   private static final float[] ct = new float[160];
   private static final float[] cu = new float[160];
   private static final float[] cv = new float[160];
   private static final int[] cw = new int[160];
   private static final int[] cx = new int[160];
   private static final int[] cy = new int[160];
   private static final int[] cz = new int[160];
   private static final OrderedText[] da = new OrderedText[160];
   private static final Text[] db = new Text[160];
   private static final String[] dc = new String[160];
   private static int dd = 0;
   private static int de = 0;
   private static final BuilderFactory[] df = new BuilderFactory[160];
   private static final int[] dg = new int[160];
   private static int dh = -1;
   private static int di = Integer.MIN_VALUE;
   private static ConfigBridge dj;
   private static List<BuilderFactory> dk;
   private static ItemDescriptor dl;
   private static final IdentityHashMap<BuilderFactory, OrderedText> dm = new IdentityHashMap<>();
   private static final IdentityHashMap<BuilderFactory, String> dn = new IdentityHashMap<>();
   private static Style _kwren_do= StyleKeyCache.ST[3];
   private static float dp = 0.0F;
   private static float dq = 0.0F;
   private static long dr = 0L;
   private static Text ds;
   private static Text dt;
   private static Text du;
   private static float dv = 0.0F;
   private static float dw = 0.0F;
   private static float dx = 0.0F;
   private static int dy = Integer.MIN_VALUE;
   private static int dz = Integer.MIN_VALUE;
   private static int ea = -1;
   private static int eb = Integer.MIN_VALUE;
   private static int ec = Integer.MIN_VALUE;
   private static int ed = Integer.MIN_VALUE;
   private static int ee = Integer.MIN_VALUE;
   private static boolean ef = false;
   private static boolean eg = false;
   private static final String[] eh = new String[512];
   private static NativeImageBackedTexture ei;
   private static int ej = 0;
   private static int ek = 0;
   private static int el = 0;
   private static int em = 0;
   private static boolean en = false;
   private static final int eo = 60;
   private static final float[] ep = new float[60];
   private static int eq = 0;
   private static int er = 0;
   private static int es = 0;
   private static int et = 0;
   private static int eu = 0;
   private static float ev = 0.0F;
   private static float ew = 0.0F;
   private static long ex = 0L;
   private static long ey = 0L;
   private static int ez = Integer.MIN_VALUE;
   private static int fa = Integer.MIN_VALUE;
   private static Text fb;
   private static Text fc;
   private static int fd = Integer.MIN_VALUE;
   private static NativeImageBackedTexture fe;
   private static int ff = 0;
   private static int fg = 0;
   private static boolean fh = false;
   private static boolean fi = true;
   private static int[] fj = new int[0];
   private static int[] fk;
   private static NativeImage fl;
   private static int fn = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   private PanelZoneCache() {
   }

   static void a(DrawContext var0, CoreZoneProcessor var1, int var2, int var3, boolean var4) {

      long var5 = System.nanoTime();
      if (var5 - by > 250000000L) {
         cb = 0.0F;
      }

      by = var5;
      MinecraftClient var7 = MinecraftClient.getInstance();
      b(var7, var4, var5);
      Screen var8 = var7.currentScreen;
      boolean var9 = var1.fa[6] && bu > 0 && (var4 || var8 == null || !var8.showsStatusEffects());
      float var10 = var1.dn;
      boolean var11 = var9 && cb <= 0.0F;
      cb = var9 ? Math.min(1.0F, cb + var10 / 0.18F) : Math.max(0.0F, cb - var10 / 0.18F);
      float var12 = 1.0F - (float)Math.exp((double)(-var10 * 13.0F));
      float var13 = 0.0F;
      float var14 = 0.0F;
      float var15 = 0.0F;
      boolean var16 = false;

      for (int var17 = 0; var17 < bt; var17++) {
         int var18 = bo[var17];
         boolean var19 = bc[var18];
         float var20 = bf[var18];
         if (var11) {
            var20 = var19 ? 1.0F : 0.0F;
         } else if (var9) {
            float var21 = var19 ? 1.0F : 0.0F;
            var20 += (var21 - var20) * var12;
            if (Math.abs(var21 - var20) < 0.004F) {
               var20 = var21;
            }
         }

         bf[var18] = var20;
         if (!var19 && var20 <= 0.0F) {
            var16 = true;
         }

         if (var19) {
            var13 = Math.max(var13, bg[var18]);
            var14 = Math.max(var14, bi[var18]);
         }

         var15 += var20 * var20 * (3.0F - 2.0F * var20);
      }

      int[] var38 = var1.ew[6];
      if (var16 || cb <= 0.0F) {
         e(cb <= 0.0F);
      }

      float var39 = var1.fb[6];
      float var40 = cb < var39 ? cb : var39;
      float var41 = var40 * var40 * (3.0F - 2.0F * var40);
      if (var41 < 0.02F) {
         var38[2] = 0;
         CoreZoneProcessor.ij = var5;
      } else {
         if (ci != StyleKeyCache.bb || cj != StyleKeyCache.ba) {
            cg = StyleKeyCache.txt(5, ad[0]);
            ch = StyleKeyCache.f(5, ad[0]);
            ci = StyleKeyCache.bb;
            cj = StyleKeyCache.ba;
         }

         float var42 = Math.max(84.0F, Math.max(19.0F + var13 + 7.5F + var14 + 6.0F, 9.0F + ch + 12.0F + 8.0F + 9.0F));
         if (var11 || cc <= 0.0F) {
            cc = var42;
         } else if (var9) {
            cc = cc + (var42 - cc) * var12;
         }

         float var22 = 29.5F + 11.5F * Math.max(0.0F, var15 - 1.0F) + 7.5F;
         int var23 = (int)Math.ceil((double)(cc - 0.001F));
         int var24 = (int)Math.ceil((double)(var22 - 0.001F));
         double var25 = var1.cs.p();
         double var27 = var1.ct.p();
         int var29 = CoreZoneProcessor.ae(var25, var23, var2);
         int var30 = CoreZoneProcessor.af(var27, var24, var3);
         var38[0] = var29;
         var38[1] = var30;
         var38[2] = var23;
         var38[3] = var24;
         int var31 = StyleKeyCache.MAG;
         float var32 = var25 >= 50.0 ? (float)(var29 + var23) - cc : (float)var29;
         float var33 = (var27 >= 50.0 ? (float)(var30 + var24) - var22 : (float)var30) + (1.0F - var41) * 4.0F;
         var32 = (float)Math.round(var32 * (float)var31) / (float)var31;
         var33 = (float)Math.round(var33 * (float)var31) / (float)var31;
         var0.createNewRootLayer();
         if (var1.eo) {
            int var34 = StyleKeyCache.PANEL;
            StyleKeyCache.r(
               var0,
               var32,
               var33,
               cc,
               var22,
               6.0F,
               (int)((float)(var34 >>> 24 & (176768471 ^ 176768296)) * var41 + 0.5F) << 24 | var34 & (-1919388541 ^ -1922593924)
            );
         }

         StyleKeyCache.ab(var0, 5, var32 + cc - 17.0F, var33 + 5.0F, 8.0F, (int)(255.0F * var41 + 0.5F) << 24 | StyleKeyCache.A & (-516193205 ^ -507216972));
         Matrix3x2fStack var45 = var0.getMatrices();
         var45.pushMatrix();

         try {
            l(var0, var32, var33, cc, var41, var1.ep, var5);
         } finally {
            var45.popMatrix();
         }

         CoreZoneProcessor.ij = var5;
      }
   }

   private static void b(MinecraftClient var0, boolean var1, long var2) {

      ClientPlayerEntity var4 = var0.player;
      int var5 = 0;
      if (var4 == null) {
         for (int var6 = 0; var6 < bt; var6++) {
            int var7 = bo[var6];
            if (bc[var7] && !bd[var7]) {
               bc[var7] = false;
               bz = true;
            }
         }

         bv = -1;
      } else {
         Map var15 = var4.getActiveStatusEffects();
         int var17 = var15.size();
         int var8 = System.identityHashCode(var4);
         boolean var9 = var17 != bv || var8 != bw || var2 - bx > 1000000000L;

         for (int var10 = 0; var10 < bt; var10++) {
            int var11 = bo[var10];
            if (bc[var11] && !bd[var11]) {
               StatusEffectInstance var12 = (StatusEffectInstance)var15.get(az[var11]);
               if (var12 != null && var12.shouldShowIcon()) {
                  ba[var11] = var12;
                  int var13 = var12.isInfinite() ? -1261676326 ^ -885807323 : var12.getDuration();
                  if (var13 > bj[var11]) {
                     bz = true;
                  }

                  bj[var11] = var13;
                  int var14 = var12.getAmplifier();
                  if (var14 != bk[var11]) {
                     bk[var11] = var14;
                     be[var11] = true;
                  }
               } else {
                  bc[var11] = false;
                  ba[var11] = null;
                  bz = true;
                  var9 = true;
               }
            }
         }

         if (var9) {
            bv = var17;
            bw = var8;
            bx = var2;
            var15.values().forEach(ck);
         }

         for (int var21 = 0; var21 < bt; var21++) {
            int var23 = bo[var21];
            if (bc[var23] && !bd[var23]) {
               var5++;
            }
         }
      }

      boolean var16 = var1 && var5 == 0;
      if (var16 != ca) {
         f(var16);
      }

      if (var16) {
         var5 = 2;
      }

      if (bz) {
         bz = false;
         h();
      }

      int var18 = StyleKeyCache.bb;
      int var19 = StyleKeyCache.ba;
      if (cf != var19) {
         j(var19);
      }

      float var20 = 20.0F;
      ClientWorld var22 = var0.world;
      if (var22 != null) {
         var20 = var22.getTickManager().getTickRate();
         if (!(var20 > 0.0F)) {
            var20 = 20.0F;
         }
      }

      for (int var24 = 0; var24 < bt; var24++) {
         int var25 = bo[var24];
         int var26 = bl[var25];
         if (bd[var25]) {
            var26 = 60;
         } else if (bc[var25]) {
            int var27 = bj[var25];
            var26 = var27 == (-411836625 ^ -1735647024) ? -2 : (int)((float)Math.max(0, var27) / var20);
         }

         byte var28 = 0;
         if (be[var25] || bm[var25] != var18) {
            var28 |= 1;
         }

         if (var26 != bl[var25] || bm[var25] != var18) {
            var28 |= 2;
         }

         if (var28 != 0 || bn[var25] != var19) {
            k(var25, var26, var28);
         }
      }

      bu = var5;
   }

   private static void c(StatusEffectInstance var0) {

      if (var0 != null && var0.shouldShowIcon()) {
         RegistryEntry var1 = var0.getEffectType();

         for (int var2 = 0; var2 < bt; var2++) {
            int var3 = bo[var2];
            if (az[var3] == var1 && !bd[var3]) {
               if (!bc[var3]) {
                  bc[var3] = true;
                  bz = true;
               }

               if (ba[var3] != var0) {
                  ba[var3] = var0;
                  int var4 = var0.isInfinite() ? -955737699 ^ -1191745950 : var0.getDuration();
                  if (var4 > bj[var3]) {
                     bz = true;
                  }

                  bj[var3] = var4;
                  int var5 = var0.getAmplifier();
                  if (var5 != bk[var3]) {
                     bk[var3] = var5;
                     be[var3] = true;
                  }
               }

               return;
            }
         }

         int var6 = d();
         if (var6 >= 0) {
            az[var6] = var1;
            ba[var6] = var0;
            bj[var6] = var0.isInfinite() ? -36010364 ^ -2111473285 : var0.getDuration();
            bk[var6] = var0.getAmplifier();
            bp[var6] = ((StatusEffect)var1.value()).getName().getString();
            bs[var6] = InGameHud.getEffectTexture(var1);
            bz = true;
         }
      }
   }

   private static int d() {

      for (int var0 = 0; var0 < 32; var0++) {
         if (!bb[var0]) {
            bb[var0] = true;
            bc[var0] = true;
            bd[var0] = false;
            be[var0] = true;
            bf[var0] = 0.0F;
            bk[var0] = 0;
            bl[var0] = Integer.MIN_VALUE;
            bm[var0] = Integer.MIN_VALUE;
            bn[var0] = Integer.MIN_VALUE;
            bg[var0] = 0.0F;
            bh[var0] = 0.0F;
            bi[var0] = 0.0F;
            bo[bt++] = var0;
            return var0;
         }
      }

      return -1;
   }

   private static void e(boolean var0) {

      int var1 = 0;

      for (int var2 = 0; var2 < bt; var2++) {
         int var3 = bo[var2];
         if (bc[var3] || !var0 && !(bf[var3] <= 0.0F)) {
            bo[var1++] = var3;
         } else {
            bb[var3] = false;
            az[var3] = null;
            ba[var3] = null;
            bq[var3] = null;
            br[var3] = null;
            bs[var3] = null;
            bp[var3] = null;
            bd[var3] = false;
         }
      }

      bt = var1;
   }

   private static void f(boolean var0) {

      ca = var0;
      boolean var1 = false;
      boolean var2 = false;

      for (int var3 = 0; var3 < bt; var3++) {
         int var4 = bo[var3];
         if (bd[var4]) {
            bc[var4] = var0;
            if (az[var4] == StatusEffects.SPEED) {
               var1 = true;
            } else {
               var2 = true;
            }
         }
      }

      if (var0) {
         if (!var1) {
            g(StatusEffects.SPEED);
         }

         if (!var2) {
            g(StatusEffects.STRENGTH);
         }
      }

      bz = true;
   }

   private static void g(RegistryEntry<StatusEffect> var0) {
      int var1 = 0;
      byte var2 = 0;

      label16:
      while (true) {
         switch (var2) {
            case 0:
            default:
               if (fn != 0) {
                  new Object().hashCode();
                  var2 = 1;
                  break;
               }
            case 1:
               var1 = d();
               if (var1 < 0) {
                  return;
               }
            case 2:
               break label16;
         }
      }

      az[var1] = var0;
      ba[var1] = null;
      bd[var1] = true;
      bj[var1] = 1200;
      bk[var1] = 1;
      bp[var1] = ((StatusEffect)var0.value()).getName().getString();
      bs[var1] = InGameHud.getEffectTexture(var0);
   }

   private static void h() {

      int[] var0 = bo;

      for (int var1 = 1; var1 < bt; var1++) {
         int var2 = var0[var1];

         int var3;
         for (var3 = var1 - 1; var3 >= 0 && i(var0[var3], var2); var3--) {
            var0[var3 + 1] = var0[var3];
         }

         var0[var3 + 1] = var2;
      }
   }

   private static boolean i(int var0, int var1) {

      if (bj[var0] != bj[var1]) {
         return bj[var0] > bj[var1];
      } else {
         String var2 = bp[var0];
         String var3 = bp[var1];
         return var2 != null && var3 != null ? String.CASE_INSENSITIVE_ORDER.compare(var2, var3) > 0 : false;
      }
   }

   private static void j(int var0) {

      TextHandler var1 = MinecraftClient.getInstance().textRenderer.getTextHandler();
      Style var2 = StyleKeyCache.ST[1];
      float var3 = 0.0F;

      for (int var4 = 0; var4 < 10; var4++) {
         var3 = Math.max(var3, var1.getWidth(Text.literal(String.valueOf((char)(48 + var4))).setStyle(var2)));
      }

      cd = var3;
      ce = var1.getWidth(Text.literal(String.valueOf(':')).setStyle(var2));
      cf = var0;
   }

   private static void k(int var0, int var1, int var2) {

      if ((var2 & 1) != 0) {
         StringBuilder var3 = new StringBuilder(24);
         if (bp[var0] != null) {
            var3.append(bp[var0]);
         }

         int var4 = bk[var0];
         if (var4 >= 1) {
            var3.append(' ').append(var4 + 1);
         }

         bq[var0] = Text.literal(var3.toString()).setStyle(StyleKeyCache.ST[2]);
         be[var0] = false;
      }

      int var9 = 0;
      int var10 = 0;
      if (var1 >= 0) {
         var9 = var1 / (309364244 ^ 309364740);
         var10 = var9 > 0 ? var1 / 60 % 60 : var1 / 60;
      }

      if ((var2 & 2) != 0) {
         if (var1 < 0) {
            br[var0] = Text.literal(ad[3]).setStyle(StyleKeyCache.ST[1]);
         } else {
            int var5 = var1 % 60;
            StringBuilder var6 = new StringBuilder(10);
            if (var9 > 0) {
               var6.append(var9).append(':');
               if (var10 < 10) {
                  var6.append('0');
               }
            }

            var6.append(var10).append(':');
            if (var5 < 10) {
               var6.append('0');
            }

            var6.append(var5);
            br[var0] = Text.literal(var6.toString()).setStyle(StyleKeyCache.ST[1]);
         }

         bl[var0] = var1;
      }

      TextHandler var11 = MinecraftClient.getInstance().textRenderer.getTextHandler();
      bg[var0] = bq[var0] == null ? 0.0F : var11.getWidth(bq[var0]);
      float var12 = br[var0] == null ? 0.0F : var11.getWidth(br[var0]);
      bh[var0] = var12;
      if (var1 < 0) {
         bi[var0] = var12;
      } else {
         int var7 = var9 > 0 ? var9 : var10;
         int var8 = (var7 < 10 ? 1 : (var7 < 100 ? 2 : (var7 < (595701869 ^ 595702661) ? 3 : 4))) + (var9 > 0 ? 4 : 2);
         bi[var0] = Math.max(var12, (float)var8 * cd + (float)(var9 > 0 ? 2 : 1) * ce);
      }

      bm[var0] = StyleKeyCache.bb;
      bn[var0] = StyleKeyCache.ba;
   }

   private static void l(DrawContext var0, float var1, float var2, float var3, float var4, boolean var5, long var6) {

      TextRenderer var8 = MinecraftClient.getInstance().textRenderer;
      Matrix3x2fStack var9 = var0.getMatrices();
      av.set(var9);
      int var10 = StyleKeyCache.MAG;
      float var11 = StyleKeyCache.PX;
      float var12 = (float)var10;
      int var13 = StyleKeyCache.SHADOW & (-1704828685 ^ -1700946164);
      int var14 = (int)(var4 * 255.0F + 0.5F);
      Text var15 = cg;
      if (var15 != null && var14 >= 5) {
         var9.set(av);
         var9.translate((float)Math.round((var1 + 9.0F) * (float)var10) / var12, (float)Math.round((var2 + 13.0F - 7.0F) * (float)var10) / var12);
         int var16 = (int)((float)var14 * 0.78F);
         if (var5 && var16 >= 5) {
            var9.translate(var11, var11);
            var0.drawText(var8, var15, 0, 0, var16 << 24 | var13, false);
            var9.translate(-var11, -var11);
         }

         var0.drawText(var8, var15, 0, 0, var14 << 24 | 176411341 ^ 175515450, false);
      }

      float var33 = 0.775F + 0.225F * (float)Math.cos((double)(var6 % 1000000000L) * 1.2566370614359173E-8);
      int var17 = -931238563 ^ -928400767;
      int var18 = StyleKeyCache.A & (-1815870218 ^ -1824785655);
      Object var19 = null;
      float var20 = 0.0F;

      for (int var21 = 0; var21 < bt; var21++) {
         int var22 = bo[var21];
         float var23 = bf[var22];
         float var24 = var23 * var23 * (3.0F - 2.0F * var23);
         float var25 = var2 + 29.5F + 11.5F * var20;
         var20 += var24;
         int var26 = (int)(var23 * var4 * 255.0F + 0.5F);
         if (var26 >= 5) {
            float var27 = (1.0F - var24) * 6.0F;
            int var28 = (int)((float)var26 * 0.78F);
            var19 = bs[var22];
            if (var19 != null) {
               var9.set(av);
               var9.scale(1.0F / (float)var10, 1.0F / (float)var10);
               var0.drawGuiTexture(
                  RenderPipelines.GUI_TEXTURED,
                  (Identifier)var19,
                  Math.round((var1 + 6.0F + var27) * (float)var10),
                  Math.round((var25 - 7.5F) * (float)var10),
                  9 * var10,
                  9 * var10,
                  var26 << 24 | 1244759479 ^ 1255045704
               );
            }

            var15 = bq[var22];
            if (var15 != null) {
               var9.set(av);
               var9.translate((float)Math.round((var1 + 19.0F + var27) * (float)var10) / var12, (float)Math.round((var25 - 7.0F) * (float)var10) / var12);
               if (var5 && var28 >= 5) {
                  var9.translate(var11, var11);
                  var0.drawText(var8, var15, 0, 0, var28 << 24 | var13, false);
                  var9.translate(-var11, -var11);
               }

               var0.drawText(var8, var15, 0, 0, var26 << 24 | var17, false);
            }

            var15 = br[var22];
            if (var15 != null) {
               int var29 = var26;
               if (!bd[var22] && bj[var22] < (74100879 ^ 74100807)) {
                  var29 = (int)((float)var26 * var33);
               }

               if (var29 >= 5) {
                  int var30 = (int)((float)var29 * 0.78F);
                  var9.set(av);
                  var9.translate(
                     (float)Math.round((var1 + var3 - 6.0F - bh[var22] + var27) * (float)var10) / var12,
                     (float)Math.round((var25 - 7.0F) * (float)var10) / var12
                  );
                  if (var5 && var30 >= 5) {
                     var9.translate(var11, var11);
                     var0.drawText(var8, var15, 0, 0, var30 << 24 | var13, false);
                     var9.translate(-var11, -var11);
                  }

                  var0.drawText(var8, var15, 0, 0, var29 << 24 | var18, false);
               }
            }
         }
      }
   }

   static void m(DrawContext var0, CoreZoneProcessor var1, int var2, int var3, boolean var4) {

      long var5 = System.nanoTime();
      if (var5 - dr > 250000000L) {
         dp = 0.0F;
      }

      dr = var5;
      _kwren_do = StyleKeyCache.ST[3];
      if (ef) {
         ef = false;
         q(false);
      }

      if (n(var1)) {
         o();
      }

      int var7 = StyleKeyCache.bb;
      int var8 = StyleKeyCache.ba;
      int var9 = 0;

      for (int var10 = 0; var10 < dd; var10++) {
         int var11 = cz[var10];
         if (cp[var11]) {
            var9++;
         }

         if (cr[var11] || cx[var11] != var7 || cy[var11] != var8) {
            r(var11);
         }
      }

      de = var9;
      boolean var43 = var1.fa[2] && (var9 > 0 || var4);
      float var44 = var1.dn;
      boolean var12 = var43 && dp <= 0.0F;
      dp = var43 ? Math.min(1.0F, dp + var44 / 0.18F) : Math.max(0.0F, dp - var44 / 0.18F);
      float var13 = 1.0F - (float)Math.exp((double)(-var44 * 13.0F));
      float var14 = 0.0F;
      float var15 = 0.0F;
      float var16 = 0.0F;
      int var17 = 0;
      int var18 = 0;
      boolean var19 = false;

      for (int var20 = 0; var20 < dd; var20++) {
         int var21 = cz[var20];
         boolean var22 = cp[var21];
         float var23 = cs[var21];
         if (var12) {
            var23 = var22 ? 1.0F : 0.0F;
         } else if (var43) {
            float var24 = var22 ? 1.0F : 0.0F;
            var23 += (var24 - var23) * var13;
            if (Math.abs(var24 - var23) < 0.004F) {
               var23 = var24;
            }
         }

         cs[var21] = var23;
         if (!var22 && var23 <= 0.0F) {
            var19 = true;
         }

         BuilderFactory var49 = cn[var21];
         float var25 = var49 != null && var49.f ? 1.0F : 0.0F;
         float var26 = ct[var21];
         var26 += (var25 - var26) * var13;
         ct[var21] = Math.abs(var25 - var26) < 0.004F ? var25 : var26;
         if (var17 < 16) {
            var18 = var20 + 1;
            var16 += var23 * var23 * (3.0F - 2.0F * var23);
            if (var22) {
               var17++;
               var14 = Math.max(var14, cu[var21]);
               var15 = Math.max(var15, Math.max(13.0F, cv[var21] + 7.0F));
            }
         }
      }

      int var45 = var9 - var17;
      if (var45 > 0) {
         if (var45 != ea || eb != var7 || ec != var8) {
            s(var45);
         }

         var16++;
         var14 = Math.max(var14, dw);
      }

      if (var43) {
         eg = var9 == 0 && var4;
      }

      boolean var46 = eg;
      if (var46) {
         if (ed != var7 || ee != var8 || du == null) {
            s(0);
         }

         var16++;
         var14 = Math.max(var14, dx);
      }

      int[] var47 = var1.ew[2];
      if (dp <= 0.0F) {
         q(true);
         var47[2] = 0;
      } else {
         if (var19) {
            ef = true;
         }

         float var48 = var1.fb[2];
         float var50 = dp < var48 ? dp : var48;
         float var51 = var50 * var50 * (3.0F - 2.0F * var50);
         if (var51 < 0.02F) {
            var47[2] = 0;
         } else {
            if (dy != var7 || dz != var8) {
               ds = StyleKeyCache.txt(5, ad[1]);
               dv = StyleKeyCache.f(5, ad[1]);
               dy = var7;
               dz = var8;
            }

            float var53 = Math.max(9.0F + dv + 12.0F + 9.0F + 9.0F, 7.5F + var14 + 12.0F + var15 + 6.0F);
            if (var12 || dq <= 0.0F) {
               dq = var53;
            } else if (var43) {
               dq = dq + (var53 - dq) * var13;
            }

            float var27 = 30.5F + 12.0F * Math.max(0.0F, var16 - 1.0F) + 7.5F;
            int var28 = (int)Math.ceil((double)(dq - 0.001F));
            int var29 = (int)Math.ceil((double)(var27 - 0.001F));
            double var30 = var1.kbX.p();
            double var32 = var1.kbY.p();
            int var34 = CoreZoneProcessor.ae(var30, var28, var2);
            int var35 = CoreZoneProcessor.af(var32, var29, var3);
            var47[0] = var34;
            var47[1] = var35;
            var47[2] = var28;
            var47[3] = var29;
            int var36 = StyleKeyCache.MAG;
            if (ej != var36 && !en) {
               w(var36);
            }

            float var37 = var30 >= 50.0 ? (float)(var34 + var28) - dq : (float)var34;
            float var38 = (var32 >= 50.0 ? (float)(var35 + var29) - var27 : (float)var35) + (1.0F - var51) * 4.0F;
            var37 = (float)Math.round(var37 * (float)var36) / (float)var36;
            var38 = (float)Math.round(var38 * (float)var36) / (float)var36;
            var0.createNewRootLayer();
            if (var1.eo) {
               int var39 = StyleKeyCache.PANEL;
               StyleKeyCache.r(
                  var0,
                  var37,
                  var38,
                  dq,
                  var27,
                  6.0F,
                  (int)((float)(var39 >>> 24 & (1365970424 ^ 1365970183)) * var51 + 0.5F) << 24 | var39 & (-1876400256 ^ -1864918913)
               );
            }

            StyleKeyCache.ab(
               var0, 6, var37 + dq - 18.0F, var38 + 5.0F, 9.0F, (int)(255.0F * var51 + 0.5F) << 24 | StyleKeyCache.A & (-1858684514 ^ -1849080223)
            );
            Matrix3x2fStack var56 = var0.getMatrices();
            var56.pushMatrix();

            try {
               x(var0, var37, var38, dq, var51, var1.ep, var18, var45 > 0, var46);
            } finally {
               var56.popMatrix();
            }
         }
      }
   }

   private static boolean n(CoreZoneProcessor var0) {

      assert var0 != null
         && cn.length == (483263570 ^ 483263730)
         && cw.length == (1344144045 ^ 1344143885)
         && cz.length == (-531513714 ^ -531513810)
         && da.length == (-390287567 ^ -390287471)
         && cx.length == (-1228273847 ^ -1228273687)
         && cy.length == (-960693493 ^ -960693333)
         && df.length >= (-261573339 ^ -261573243)
         && dg.length >= (2021091091 ^ 2021091251)
         && dh >= -1
         && dh <= (-977621634 ^ -977621538)
         && dm != null : "kbScan";

      ConfigBridge var1 = ConfigBridge.c;
      if (var1 != dj || dk == null) {
         dj = var1;
         dk = null;
         if (var1 != null) {
            SyncDispatcher var2 = var1.c();
            if (var2 != null) {
               dk = var2.a();
            }
         }
      }

      if (dl == null) {
         dl = var0.q();
      }

      List var10 = dk;
      int var3 = 0;
      boolean var4 = false;

      try {
         if (var10 != null) {
            int var6 = 0;

            for (int var7 = var10.size(); var6 < var7 && var3 < (-1628421634 ^ -1628421794); var6++) {
               BuilderFactory var5 = (BuilderFactory)var10.get(var6);
               int var8 = var5.i.d;
               if (var8 != -1) {
                  if (df[var3] != var5 || dg[var3] != var8) {
                     df[var3] = var5;
                     dg[var3] = var8;
                     var4 = true;
                  }

                  var3++;
               }
            }
         }
      } catch (RuntimeException var9) {
         throw var9;
      }

      int var11 = dl.d;
      if (var3 != dh || var11 != di) {
         var4 = true;
      }

      for (int var12 = var3; var12 < dh && var12 < (273618332 ^ 273618236); var12++) {
         df[var12] = null;
      }

      dh = var3;
      di = var11;
      return var4;
   }

   private static void o() {

      for (int var0 = 0; var0 < dd; var0++) {
         cp[cz[var0]] = false;
      }

      for (int var6 = 0; var6 < dh; var6++) {
         BuilderFactory var1 = df[var6];
         int var2 = dg[var6];
         int var3 = -1;

         for (int var4 = 0; var4 < dd; var4++) {
            int var5 = cz[var4];
            if (!cq[var5] && cn[var5] == var1) {
               var3 = var5;
               break;
            }
         }

         if (var3 < 0) {
            var3 = p();
            if (var3 < 0) {
               break;
            }

            cn[var3] = var1;
            cq[var3] = false;
            ct[var3] = var1.f ? 1.0F : 0.0F;
            dc[var3] = u(var1);
            cw[var3] = var2;
         }

         cp[var3] = true;
         if (cw[var3] != var2) {
            cw[var3] = var2;
            cr[var3] = true;
         }
      }

      if (di != -1) {
         int var7 = -1;

         for (int var9 = 0; var9 < dd; var9++) {
            if (cq[cz[var9]]) {
               var7 = cz[var9];
               break;
            }
         }

         if (var7 < 0) {
            var7 = p();
         }

         if (var7 >= 0) {
            if (!cq[var7]) {
               cq[var7] = true;
               cn[var7] = null;
               ct[var7] = 0.0F;
               dc[var7] = ad[4];
               cw[var7] = di;
               cr[var7] = true;
            }

            cp[var7] = true;
            if (cw[var7] != di) {
               cw[var7] = di;
               cr[var7] = true;
            }
         }
      }

      int[] var8 = cz;

      for (int var10 = 1; var10 < dd; var10++) {
         int var11 = var8[var10];
         String var12 = dc[var11];

         int var13;
         for (var13 = var10 - 1; var13 >= 0 && String.CASE_INSENSITIVE_ORDER.compare(dc[var8[var13]], var12) > 0; var13--) {
            var8[var13 + 1] = var8[var13];
         }

         var8[var13 + 1] = var11;
      }
   }

   private static int p() {
      int var0 = 0;
      byte var1 = 0;

      while (true) {
         switch (var1) {
            case 0:
            default:
               if (fn != 0) {
                  Thread.currentThread().getName().length();
                  var1 = 1;
                  break;
               }
            case 1:
               var0 = 0;
               var1 = 2;
               break;
            case 2:
               if (var0 >= (1226896326 ^ 1226896230)) {
                  return -1;
               }

               if (!co[var0]) {
                  co[var0] = true;
                  cp[var0] = true;
                  cq[var0] = false;
                  cr[var0] = true;
                  cs[var0] = 0.0F;
                  cx[var0] = Integer.MIN_VALUE;
                  cy[var0] = Integer.MIN_VALUE;
                  cu[var0] = 0.0F;
                  cv[var0] = 0.0F;
                  cz[dd++] = var0;
                  return var0;
               }
            case 3:
               var0++;
               var1 = 2;
               break;
            case 4:
               return -1;
         }
      }
   }

   private static void q(boolean var0) {

      int var1 = 0;

      for (int var2 = 0; var2 < dd; var2++) {
         int var3 = cz[var2];
         if (cp[var3] || !var0 && !(cs[var3] <= 0.0F)) {
            cz[var1++] = var3;
         } else {
            co[var3] = false;
            cn[var3] = null;
            cq[var3] = false;
            da[var3] = null;
            db[var3] = null;
            dc[var3] = null;
         }
      }

      dd = var1;
   }

   private static void r(int var0) {

      TextHandler var1 = MinecraftClient.getInstance().textRenderer.getTextHandler();
      int var2 = StyleKeyCache.bb;
      if (cr[var0] || cx[var0] != var2 || db[var0] == null) {
         db[var0] = Text.literal(v(cw[var0])).setStyle(StyleKeyCache.ST[3]);
      }

      if (cq[var0]) {
         da[var0] = StyleKeyCache.txt(3, ad[4]).asOrderedText();
      } else if (cn[var0] != null) {
         da[var0] = StyleKeyCache.p(t(cn[var0]), 3, 80.0F);
      }

      cu[var0] = da[var0] == null ? 0.0F : var1.getWidth(da[var0]);
      cv[var0] = var1.getWidth(db[var0]);
      cr[var0] = false;
      cx[var0] = var2;
      cy[var0] = StyleKeyCache.ba;
   }

   private static void s(int var0) {

      TextHandler var1 = MinecraftClient.getInstance().textRenderer.getTextHandler();
      Style var2 = StyleKeyCache.ST[3];
      if (var0 > 0) {
         dt = Text.literal(new StringBuilder(12).append('+').append(var0).append(ad[6]).toString()).setStyle(var2);
         dw = var1.getWidth(dt);
         ea = var0;
         eb = StyleKeyCache.bb;
         ec = StyleKeyCache.ba;
      } else {
         du = Text.literal(ad[5]).setStyle(var2);
         dx = var1.getWidth(du);
         ed = StyleKeyCache.bb;
         ee = StyleKeyCache.ba;
      }
   }

   private static OrderedText t(BuilderFactory var0) {

      OrderedText var1 = dm.get(var0);
      if (var1 == null) {
         var1 = var1x -> {

            assert var1x != null
               && var0 != null
               && var0.c != null
               && _kwren_do != null
               && cn.length == (-1065943953 ^ -1065943857)
               && cw.length == (838054545 ^ 838054449)
               && cz.length == (-1352661202 ^ -1352661106)
               && da.length == (-1102237146 ^ -1102237050)
               && cx.length == (849661125 ^ 849661029)
               && cy.length == (780982649 ^ 780982745)
               && dm != null
               && df.length >= (-2018512008 ^ -2018511912)
               && dg.length >= (-1749035577 ^ -1749035673) : "kb" + "Vis" + "itor";

            char[] var2 = var0.c;
            int var3 = var0.cK;
            int var4 = var2.length;
            boolean var5 = false;
            if (var4 > 1) {
               char var6 = (char)(var2[1] ^ var3 + 31);
               var5 = var6 == '.' || var6 == (1250579646 ^ 1250601904);
            }

            Style var11 = _kwren_do;

            try {
               int var7 = 0;

               for (int var8 = 0; var7 < var4; var7++) {
                  if (!var5 || var7 != 1) {
                     char var9 = (char)(var2[var7] ^ var3 + var7 * 31);
                     if (var9 >= (2092747421 ^ 2092709276) && var9 <= (1918500158 ^ 1918435936)) {
                        var9 = (char)(var9 - (-1952425732 ^ -1952405988));
                     }

                     if (!var1x.accept(var8++, var11, var9)) {
                        return false;
                     }
                  }
               }

               return true;
            } catch (RuntimeException var10) {
               throw var10;
            }
         };
         dm.put(var0, var1);
      }

      return var1;
   }

   private static String u(BuilderFactory var0) {

      String var1 = dn.get(var0);
      if (var1 == null) {
         char[] var2 = var0.c;
         int var3 = var0.cK;
         int var4 = var2.length;
         boolean var5 = false;
         if (var4 > 1) {
            char var6 = (char)(var2[1] ^ var3 + 31);
            var5 = var6 == '.' || var6 == (-2070708612 ^ -2070707854);
         }

         char[] var10 = new char[var4];
         int var7 = 0;

         for (int var8 = 0; var8 < var4; var8++) {
            if (!var5 || var8 != 1) {
               char var9 = (char)(var2[var8] ^ var3 + var8 * 31);
               if (var9 >= (311664519 ^ 311648390) && var9 <= (-1139654091 ^ -1139622549)) {
                  var9 = (char)(var9 - (-265014332 ^ -264975068));
               }

               var10[var7++] = var9;
            }
         }

         var1 = new String(var10, 0, var7);
         dn.put(var0, var1);
      }

      return var1;
   }

   private static String v(int var0) {

      if (var0 >= 0 && var0 < eh.length && eh[var0] != null) {
         return eh[var0];
      } else {
         String var1 = ad[13];
         if (var0 != 96) {
            var1 = CoreZoneProcessor.ax(var0);
         }

         if (var1 == null) {
            var1 = ad[14];
         }

         String var2 = ad[10];
         String var3 = ad[11];
         if (var1.equalsIgnoreCase(ad[12])) {
            var1 = ad[13];
         } else if (var1.startsWith(var2)) {
            var1 = new StringBuilder(var1.length()).append('R').append(var1, var2.length(), var1.length()).toString();
         } else if (var1.startsWith(var3)) {
            var1 = new StringBuilder(var1.length()).append('L').append(var1, var3.length(), var1.length()).toString();
         }

         if (var1.indexOf(32) >= 0) {
            StringBuilder var4 = new StringBuilder(var1.length());

            for (int var5 = 0; var5 < var1.length(); var5++) {
               char var6 = var1.charAt(var5);
               if (var6 != ' ') {
                  var4.append(var6);
               }
            }

            var1 = var4.toString();
         }

         if (var0 >= 0 && var0 < eh.length) {
            eh[var0] = var1;
         }

         return var1;
      }
   }

   private static void w(int var0) {

      int var1 = Math.round(3.0F * (float)var0);
      int var2 = 9 * var0;
      int var3 = 2 * var1 + 1;
      NativeImageBackedTexture var4 = null;
      NativeImage var5 = null;
      boolean var6 = false;

      try {
         var4 = new NativeImageBackedTexture(ad[9], var3, var2, false);
         var5 = var4.getImage();
         float var7 = (float)var1 * (float)var1;

         for (int var8 = 0; var8 < var2; var8++) {
            for (int var9 = 0; var9 < var3; var9++) {
               int var10 = 0;

               for (int var11 = 0; var11 < 8; var11++) {
                  float var12 = (float)var8 + ((float)var11 + 0.5F) / 8.0F;
                  float var13 = var12 < (float)var1 ? (float)var1 : (var12 > (float)(var2 - var1) ? (float)(var2 - var1) : var12);
                  float var14 = var12 - var13;

                  for (int var15 = 0; var15 < 8; var15++) {
                     float var16 = (float)var9 + ((float)var15 + 0.5F) / 8.0F;
                     float var17 = var16 < (float)var1 ? (float)var1 : (var16 > (float)(var3 - var1) ? (float)(var3 - var1) : var16);
                     float var18 = var16 - var17;
                     if (var18 * var18 + var14 * var14 <= var7) {
                        var10++;
                     }
                  }
               }

               var5.setColorArgb(var9, var8, (var10 * (2010741082 ^ 2010741157) + 32) / 64 << 24 | -496055422 ^ -493800323);
            }
         }

         var4.upload();
         MinecraftClient.getInstance().getTextureManager().registerTexture(au, var4);
         var6 = true;
         ei = var4;
         ej = var0;
         ek = var1;
         el = var2;
         em = var3;
      } catch (Throwable var20) {
         en = true;
         ei = null;
         if (var4 != null && !var6) {
            try {
               var4.close();
            } catch (Throwable var19) {
            }
         }
      }
   }

   private static void x(DrawContext var0, float var1, float var2, float var3, float var4, boolean var5, int var6, boolean var7, boolean var8) {

      TextRenderer var9 = MinecraftClient.getInstance().textRenderer;
      Matrix3x2fStack var10 = var0.getMatrices();
      av.set(var10);
      int var11 = StyleKeyCache.MAG;
      float var12 = StyleKeyCache.PX;
      float var13 = (float)var11;
      int var14 = StyleKeyCache.SHADOW & (461562432 ^ 461184447);
      int var15 = (int)(var4 * 255.0F + 0.5F);
      Text var16 = ds;
      if (var16 != null && var15 >= 5) {
         var10.set(av);
         var10.translate((float)Math.round((var1 + 9.0F) * (float)var11) / var13, (float)Math.round((var2 + 13.0F - 7.0F) * (float)var11) / var13);
         int var17 = (int)((float)var15 * 0.78F);
         if (var5 && var17 >= 5) {
            var10.translate(var12, var12);
            var0.drawText(var9, var16, 0, 0, var17 << 24 | var14, false);
            var10.translate(-var12, -var12);
         }

         var0.drawText(var9, var16, 0, 0, var15 << 24 | 538346449 ^ 551777830, false);
      }

      int var46 = -140729422 ^ 136388208;
      int var18 = StyleKeyCache.ACC_TXT;
      int var19 = StyleKeyCache.KEY_FILL;
      int var20 = var19 >>> 24 & (-1717890938 ^ -1717890951);
      int var21 = StyleKeyCache.KEY_TXT & (-351185066 ^ -336680791);
      boolean var22 = ei != null && ej == var11;
      int var23 = ek;
      int var24 = el;
      int var25 = em;
      Object var26 = null;
      float var27 = 0.0F;

      for (int var28 = 0; var28 < var6; var28++) {
         int var29 = cz[var28];
         float var30 = cs[var29];
         float var31 = var30 * var30 * (3.0F - 2.0F * var30);
         float var32 = var2 + 30.5F + 12.0F * var27;
         var27 += var31;
         int var33 = (int)(var30 * var4 * 255.0F + 0.5F);
         if (var33 >= 5) {
            float var34 = (1.0F - var31) * 6.0F;
            int var35 = (int)((float)var33 * 0.78F);
            float var36 = Math.max(13.0F, cv[var29] + 7.0F);
            float var37 = var1 + var3 - 6.0F - var36 + var34;
            int var38 = (int)((float)var20 * var30 * var4 + 0.5F) << 24 | var19 & (-1039777935 ^ -1023819634);
            if (var22) {
               var10.set(av);
               var10.scale(1.0F / (float)var11, 1.0F / (float)var11);
               int var39 = Math.round(var37 * (float)var11);
               int var40 = Math.round((var37 + var36) * (float)var11);
               int var41 = Math.round((var32 - 7.2F) * (float)var11);
               var0.drawTexture(RenderPipelines.GUI_TEXTURED, au, var39, var41, 0.0F, 0.0F, var23, var24, var23, var24, var25, var24, var38);
               var0.fill(var39 + var23, var41, var40 - var23, var41 + var24, var38);
               var0.drawTexture(RenderPipelines.GUI_TEXTURED, au, var40 - var23, var41, (float)(var23 + 1), 0.0F, var23, var24, var23, var24, var25, var24, var38);
            } else {
               var10.set(av);
               StyleKeyCache.r(var0, var37, var32 - 7.2F, var36, 9.0F, 3.0F, var38);
            }

            var16 = db[var29];
            if (var16 != null) {
               var10.set(av);
               var10.translate(
                  (float)Math.round((var37 + (var36 - cv[var29]) * 0.5F) * (float)var11) / var13, (float)Math.round((var32 - 7.0F) * (float)var11) / var13
               );
               if (var5 && var35 >= 5) {
                  var10.translate(var12, var12);
                  var0.drawText(var9, var16, 0, 0, var35 << 24 | var14, false);
                  var10.translate(-var12, -var12);
               }

               var0.drawText(var9, var16, 0, 0, var33 << 24 | var21, false);
            }

            var26 = da[var29];
            if (var26 != null) {
               float var50 = ct[var29];
               int var51;
               if (var50 <= 0.0F) {
                  var51 = var46 & (56274562 ^ 61165949);
               } else if (var50 >= 1.0F) {
                  var51 = var18 & (1042942799 ^ 1054209200);
               } else {
                  int var52 = (int)(
                     (float)(var46 >> 16 & (1300109692 ^ 1300109699))
                        + (float)((var18 >> 16 & (-1978643317 ^ -1978643340)) - (var46 >> 16 & (-1007295697 ^ -1007295536))) * var50
                        + 0.5F
                  );
                  int var42 = (int)(
                     (float)(var46 >> 8 & (-949880536 ^ -949880361))
                        + (float)((var18 >> 8 & (1508496191 ^ 1508496320)) - (var46 >> 8 & (-238433804 ^ -238434037))) * var50
                        + 0.5F
                  );
                  int var43 = (int)(
                     (float)(var46 & (-936400156 ^ -936400357))
                        + (float)((var18 & (-1209110502 ^ -1209110299)) - (var46 & (1172537756 ^ 1172537699))) * var50
                        + 0.5F
                  );
                  var51 = var52 << 16 | var42 << 8 | var43;
               }

               var10.set(av);
               var10.translate((float)Math.round((var1 + 7.5F + var34) * (float)var11) / var13, (float)Math.round((var32 - 7.0F) * (float)var11) / var13);
               if (var5 && var35 >= 5) {
                  var10.translate(var12, var12);
                  var0.drawText(var9, (OrderedText)var26, 0, 0, var35 << 24 | var14, false);
                  var10.translate(-var12, -var12);
               }

               var0.drawText(var9, (OrderedText)var26, 0, 0, var33 << 24 | var51, false);
            }
         }
      }

      var16 = var7 ? dt : (var8 ? du : null);
      if (var16 != null && var15 >= 5) {
         float var48 = var2 + 30.5F + 12.0F * var27;
         var10.set(av);
         var10.translate((float)Math.round((var1 + 7.5F) * (float)var11) / var13, (float)Math.round((var48 - 7.0F) * (float)var11) / var13);
         int var49 = (int)((float)var15 * 0.78F);
         if (var5 && var49 >= 5) {
            var10.translate(var12, var12);
            var0.drawText(var9, var16, 0, 0, var49 << 24 | var14, false);
            var10.translate(-var12, -var12);
         }

         var0.drawText(var9, var16, 0, 0, var15 << 24 | 115288721 ^ 106013698, false);
      }
   }

   static void y(DrawContext var0, CoreZoneProcessor var1, int var2, int var3, boolean var4) {

      long var5 = System.nanoTime();
      if (var5 - ex > 250000000L) {
         ew = 0.0F;
      }

      ex = var5;
      MinecraftClient var7 = MinecraftClient.getInstance();
      ClientPlayerEntity var8 = var7.player;
      ClientWorld var9 = var7.world;
      if (var8 != null && var9 != null) {
         int var10 = System.identityHashCode(var9);
         int var11 = System.identityHashCode(var8);
         if (var10 != et) {
            et = var10;
            es = var11;
            er = var8.age;
            Arrays.fill(ep, 0.0F);
            ev = 0.0F;
            eu = 0;
            fi = true;
         } else if (var11 != es) {
            es = var11;
            er = var8.age;
         } else if (var8.age != er) {
            int var12 = var8.age - er;
            er = var8.age;
            double var13 = var8.getX() - var8.lastX;
            double var15 = var8.getZ() - var8.lastZ;
            float var17 = (float)(Math.sqrt(var13 * var13 + var15 * var15) * (double)var9.getTickManager().getTickRate());
            if (!(var17 >= 0.0F)) {
               var17 = 0.0F;
            } else if (var17 > 100.0F) {
               var17 = 100.0F;
            }

            int var18 = var12 > 0 && var12 <= 3 ? var12 : 1;

            for (int var19 = 0; var19 < var18; var19++) {
               ep[eq] = var17;
               eq = eq + 1 >= 60 ? 0 : eq + 1;
            }

            eu = var17 == ev ? eu + var18 : var18;
            if (eu <= 62) {
               fi = true;
            }

            ev = var17;
         }
      }

      ew = Math.min(1.0F, ew + var1.dn / 0.18F);
      float var30 = var1.fb[7];
      float var31 = ew < var30 ? ew : var30;
      float var32 = var31 * var31 * (3.0F - 2.0F * var31);
      int[] var33 = var1.ew[7];
      if (var32 < 0.02F) {
         var33[2] = 0;
      } else {
         int var14 = StyleKeyCache.bb;
         if (fd != var14) {
            fc = StyleKeyCache.txt(5, ad[2]);
            fd = var14;
         }

         if (fb == null || fa != var14 || var5 - ey >= 100000000L) {
            int var34 = Math.round(ev * 100.0F);
            if (fb == null || fa != var14 || var34 != ez) {
               fb = Text.literal(String.format(Locale.ROOT, ad[7], (double)var34 / 100.0)).setStyle(StyleKeyCache.ST[1]);
               ez = var34;
               fa = var14;
            }

            ey = var5;
         }

         double var35 = var1.cv.p();
         double var36 = var1.cw.p();
         int var37 = CoreZoneProcessor.ae(var35, 88, var2);
         int var20 = CoreZoneProcessor.af(var36, 36, var3);
         var33[0] = var37;
         var33[1] = var20;
         var33[2] = 88;
         var33[3] = 36;
         int var21 = StyleKeyCache.MAG;
         int var22 = 78 * var21;
         int var23 = Math.round(12.5F * (float)var21);
         if ((fe == null || ff != var22 || fg != var23) && !fh) {
            aa(var22, var23);
         }

         if (fi && fe != null) {
            fi = false;
            ab();
         }

         float var24 = (float)var37;
         float var25 = (float)Math.round(((float)var20 + (1.0F - var32) * 4.0F) * (float)var21) / (float)var21;
         var0.createNewRootLayer();
         if (var1.eo) {
            int var26 = StyleKeyCache.PANEL;
            StyleKeyCache.r(
               var0,
               var24,
               var25,
               88.0F,
               36.0F,
               6.0F,
               (int)((float)(var26 >>> 24 & (1286668976 ^ 1286668879)) * var32 + 0.5F) << 24 | var26 & (1777747171 ^ 1762245404)
            );
         }

         StyleKeyCache.ab(var0, 2, var24 + 71.0F, var25 + 5.0F, 8.0F, (int)(255.0F * var32 + 0.5F) << 24 | StyleKeyCache.A & (-835888310 ^ -825056075));
         Matrix3x2fStack var38 = var0.getMatrices();
         var38.pushMatrix();

         try {
            z(var0, var24, var25, var32, var1.ep);
         } finally {
            var38.popMatrix();
         }
      }
   }

   private static void z(DrawContext var0, float var1, float var2, float var3, boolean var4) {

      TextRenderer var5 = MinecraftClient.getInstance().textRenderer;
      Matrix3x2fStack var6 = var0.getMatrices();
      av.set(var6);
      int var7 = StyleKeyCache.MAG;
      float var8 = StyleKeyCache.PX;
      float var9 = (float)var7;
      int var10 = StyleKeyCache.SHADOW & (1509176531 ^ 1493945132);
      int var11 = (int)(var3 * 255.0F + 0.5F);
      if (var11 >= 5) {
         int var12 = (int)((float)var11 * 0.78F);
         Text var13 = fc;
         if (var13 != null) {
            var6.set(av);
            var6.translate((float)Math.round((var1 + 9.0F) * (float)var7) / var9, (float)Math.round((var2 + 12.0F - 7.0F) * (float)var7) / var9);
            if (var4 && var12 >= 5) {
               var6.translate(var8, var8);
               var0.drawText(var5, var13, 0, 0, var12 << 24 | var10, false);
               var6.translate(-var8, -var8);
            }

            var0.drawText(var5, var13, 0, 0, var11 << 24 | 502098817 ^ 488152694, false);
         }

         if (fe != null) {
            int var14 = StyleKeyCache.GRAPH;
            int var15 = (int)((float)(var14 >>> 24 & (776478390 ^ 776478281)) * var3 + 0.5F);
            var6.set(av);
            var6.scale(1.0F / (float)var7, 1.0F / (float)var7);
            var0.drawTexture(
               RenderPipelines.GUI_TEXTURED,
               at,
               Math.round((var1 + 5.0F) * (float)var7),
               Math.round((var2 + 18.0F) * (float)var7),
               0.0F,
               0.0F,
               ff,
               fg,
               ff,
               fg,
               ff,
               fg,
               var15 << 24 | var14 & (1866329806 ^ 1874989361)
            );
         }

         var13 = fb;
         if (var13 != null) {
            var6.set(av);
            var6.translate((float)Math.round((var1 + 7.0F) * (float)var7) / var9, (float)Math.round((var2 + 25.0F - 7.0F) * (float)var7) / var9);
            if (var12 >= 5) {
               var6.translate(var8, var8);
               var0.drawText(var5, var13, 0, 0, var12 << 24 | var10, false);
               var6.translate(-var8, -var8);
            }

            var0.drawText(var5, var13, 0, 0, var11 << 24 | -40127554 ^ -45325214, false);
         }
      }
   }

   private static void aa(int var0, int var1) {

      NativeImageBackedTexture var2 = null;
      boolean var3 = false;

      try {
         var2 = new NativeImageBackedTexture(ad[8], var0, var1, false);
         MinecraftClient.getInstance().getTextureManager().registerTexture(at, var2);
         var3 = true;
         fe = var2;
         ff = var0;
         fg = var1;
         fj = new int[var0 * var1];
         fi = true;
      } catch (Throwable var7) {
         fh = true;
         fe = null;
         if (var2 != null && !var3) {
            try {
               var2.close();
            } catch (Throwable var6) {
            }
         }
      }
   }

   private static void ab() {

      NativeImageBackedTexture var0 = fe;
      NativeImage var1 = var0.getImage();
      if (var1 != null) {
         int var2 = ff;
         int var3 = fg;
         int[] var4 = fj;
         if (var4.length != var2 * var3) {
            var4 = new int[var2 * var3];
            fj = var4;
         }

         Arrays.fill(var4, 0);
         float var5 = 10.0F;

         for (int var6 = 0; var6 < 60; var6++) {
            var5 = Math.max(var5, ep[var6]);
         }

         float var33 = (float)Math.max(1, Math.round(0.6F * (float)StyleKeyCache.MAG));
         float var7 = var33 * 0.5F;
         float var8 = (float)var3 - var33;
         float var9 = (float)(var2 - 1) / 59.0F;
         float var10 = 0.5F;
         float var11 = 0.0F;

         for (int var12 = 0; var12 < 60; var12++) {
            float var13 = ep[(eq + var12) % 60] / var5;
            var13 = var13 < 0.0F ? 0.0F : (var13 > 1.0F ? 1.0F : var13);
            float var14 = 0.5F + var9 * (float)var12;
            float var15 = var7 + var8 * (1.0F - var13);
            if (var12 == 0) {
               var10 = var14;
               var11 = var15;
            } else {
               float var16 = var14 - var10;
               float var17 = var15 - var11;
               if (Math.abs(var16) >= Math.abs(var17)) {
                  float var40 = var17 / var16;
                  float var41 = var7 * (float)Math.sqrt((double)(1.0F + var40 * var40));
                  int var42 = (int)Math.ceil((double)(var10 - 0.5F));
                  int var43 = (int)Math.floor((double)(var14 - 0.5F));

                  for (int var44 = Math.max(0, var42); var44 <= var43 && var44 < var2; var44++) {
                     float var45 = var11 + ((float)var44 + 0.5F - var10) * var40;
                     float var46 = var45 - var41;
                     float var47 = var45 + var41;
                     int var48 = Math.max(0, (int)Math.floor((double)var46));

                     for (int var49 = Math.min(var3 - 1, (int)Math.floor((double)var47)); var48 <= var49; var48++) {
                        float var50 = Math.min((float)var48 + 1.0F, var47) - Math.max((float)var48, var46);
                        int var51 = (int)(var50 * 255.0F + 0.5F);
                        int var52 = var48 * var2 + var44;
                        if (var51 > var4[var52]) {
                           var4[var52] = var51 > (2078648384 ^ 2078648511) ? 1884101046 ^ 1884100937 : var51;
                        }
                     }
                  }
               } else {
                  float var18 = var16 / var17;
                  float var19 = var7 * (float)Math.sqrt((double)(1.0F + var18 * var18));
                  float var20 = Math.min(var11, var15);
                  float var21 = Math.max(var11, var15);
                  int var22 = (int)Math.ceil((double)(var20 - 0.5F));
                  int var23 = (int)Math.floor((double)(var21 - 0.5F));

                  for (int var24 = Math.max(0, var22); var24 <= var23 && var24 < var3; var24++) {
                     float var25 = var10 + ((float)var24 + 0.5F - var11) * var18;
                     float var26 = var25 - var19;
                     float var27 = var25 + var19;
                     int var28 = Math.max(0, (int)Math.floor((double)var26));

                     for (int var29 = Math.min(var2 - 1, (int)Math.floor((double)var27)); var28 <= var29; var28++) {
                        float var30 = Math.min((float)var28 + 1.0F, var27) - Math.max((float)var28, var26);
                        int var31 = (int)(var30 * 255.0F + 0.5F);
                        int var32 = var24 * var2 + var28;
                        if (var31 > var4[var32]) {
                           var4[var32] = var31 > (989298492 ^ 989298627) ? 351838039 ^ 351838120 : var31;
                        }
                     }
                  }
               }

               var10 = var14;
               var11 = var15;
            }
         }

         int[] var34 = fk;
         if (var34 == null || var34.length != var2 * var3 || var1 != fl) {
            var34 = new int[var2 * var3];
            Arrays.fill(var34, -1);
            fk = var34;
            fl = var1;
         }

         for (int var36 = 0; var36 < var3; var36++) {
            int var37 = var36 * var2;

            for (int var38 = 0; var38 < var2; var38++) {
               int var39 = var4[var37 + var38];
               if (var39 != var34[var37 + var38]) {
                  var34[var37 + var38] = var39;
                  var1.setColorArgb(var38, var36, var39 << 24 | 1880255269 ^ 1894618330);
               }
            }
         }

         var0.upload();
      }
   }
}
