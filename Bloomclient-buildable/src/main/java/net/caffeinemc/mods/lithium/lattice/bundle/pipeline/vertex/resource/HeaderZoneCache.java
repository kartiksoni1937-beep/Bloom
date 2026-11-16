package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Optional;
import java.util.TimeZone;
import java.util.function.Supplier;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.RasterCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.StyleKeyCache;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.client.util.DefaultSkinHelper;
import net.minecraft.text.Text;
import net.minecraft.text.Style;
import net.minecraft.util.Identifier;
import net.minecraft.client.MinecraftClient;
import net.minecraft.resource.Resource;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.CharacterVisitor;
import net.minecraft.text.OrderedText;
import net.minecraft.client.network.ServerInfo;
import net.minecraft.client.gui.PlayerSkinDrawer;
import net.minecraft.entity.player.SkinTextures;
import org.joml.Matrix3x2fStack;
import net.minecraft.client.font.TextRenderer;import net.minecraft.entity.Entity;
public final class HeaderZoneCache {
   private static final String[] u = new String[]{" fps", " ms", " tps", "--", "lithium-hu" + "d2-head"};
   private static final int v = 0;
   private static final int w = 1;
   private static final int x = 2;
   private static final int y = 3;
   private static final int z = 4;
   private static final float aa = 20.0F;
   private static final float ab = 20.0F;
   private static final float ac = 7.0F;
   private static final float ad = 18.0F;
   private static final float ae = 14.0F;
   private static final float af = 2.8F;
   private static final float ag = 6.0F;
   private static final float ah = 6.0F;
   private static final float ai = 12.0F;
   private static final float aj = 13.0F;
   private static final float ak = 3.5F;
   private static final float al = 6.0F;
   private static final float am = 11.0F;
   private static final float an = 4.5F;
   private static final float ao = 4.5F;
   private static final float ap = 9.0F;
   private static final float aq = 5.0F;
   private static final float ar = 10.0F;
   private static final float as = 13.8F;
   private static final float at = 9.0F;
   private static final float au = 7.0F;
   private static final float av = 110.0F;
   private static final float aw = 150.0F;
   private static final long ax = 250000000L;
   private static final long ay = 250000000L;
   private static final int az = 199;
   private static final int ba = 0;
   private static final int bb = 1;
   private static final int bc = 2;
   private static final int bd = 3;
   private static final int be = 4;
   private static final int bf = 5;
   private static final int bg = 6;
   private static final int[] bh = new int[]{-1, 1, 2, 17, 18, 3};
   private static final boolean[] bi = new boolean[6];
   private static boolean bj = true;
   private static double bk = 50.0;
   private static double bl = 1.2;
   private static double bm = 50.0;
   private static double bn = 1.2;
   private static long bo = 0L;
   private static long bp = 0L;
   private static long bq = 0L;
   private static boolean br = false;
   private static final float[] bs = new float[6];
   private static final float[] bt = new float[6];
   private static final float[] bu = new float[6];
   private static final Text[] bv = new Text[6];
   private static final String[] bw = new String[6];
   private static final String[] bx = new String[6];
   private static final int[] by = new int[6];
   private static final int[] bz = new int[6];
   private static float ca = 0.0F;
   private static int cb = Integer.MIN_VALUE;
   private static String cc;
   private static boolean cd = false;
   private static long ce = Long.MIN_VALUE;
   private static int cf = -1;
   private static final float[] cg = new float[6];
   private static final float[] ch = new float[6];
   private static final int ci = 0;
   private static final int cj = 1;
   private static final int ck = 2;
   private static final int cl = 1024;
   private static final int cm = 4096;
   private static final Text[][] cn = new Text[][]{new Text[4096], new Text[1024], new Text[1024]};
   private static final float[][] co = new float[][]{new float[4096], new float[1024], new float[1024]};
   private static final int[][] cp = new int[][]{new int[4096], new int[1024], new int[1024]};
   private static final StringBuilder cq = new StringBuilder(16);
   private static final int cr = 4;
   private static final Identifier[] cs = new Identifier[4];
   private static final Identifier[] ct = new Identifier[4];
   private static final int[] cu = new int[4];
   private static final boolean[] cv = new boolean[4];
   private static final long[] cw = new long[4];
   private static long cx = 0L;
   private static int cy = -1;
   private static int cz = -1;
   private static int da = 8;
   private static Identifier db;
   private static SkinTextures dc;
   private static final Supplier<String> dd = () -> {
      if (HeaderZoneCache.dr != 0) {
         System.nanoTime();
      }

      return u[4];
   };
   private static int[] de;
   private static int df;
   private static Style dg;
   private static Style dh;
   private static int di;
   private static int dj;
   private static int dk;
   private static float dl;
   private static int[] dm;
   private static int dn;
   private static final CharacterVisitor _kwren_do;
   private static final OrderedText dp;
   private static final OrderedText dq;
   private static int dr = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   private HeaderZoneCache() {
   }

   static void a(DrawContext var0, CoreZoneProcessor var1, int var2, int var3, boolean var4) {

      MinecraftClient var5 = MinecraftClient.getInstance();
      SkinTextures var6 = null;
      Identifier var7 = null;
      ServerInfo var8 = null;
      Matrix3x2fStack var9 = null;
      Text var10 = null;
      long var11 = System.nanoTime();
      boolean var13 = !br || var11 - bp > 250000000L;
      bp = var11;
      if (var4 || var13 || var11 - bo > 250000000L) {
         bo = var11;
         b(var1);
      }

      int var14 = StyleKeyCache.bb;
      int var15 = StyleKeyCache.ba;
      if (var14 != cb) {
         cb = var14;

         for (int var16 = 0; var16 < 3; var16++) {
            Arrays.fill(cn[var16], null);
         }

         Arrays.fill(bv, null);
         Arrays.fill(bx, null);
         Arrays.fill(bw, null);
         Arrays.fill(by, -158770185 ^ 1988713463);
         cd = false;
      }

      if (bi[0]) {
         String var51 = EntityProfileCache.ON ? EntityProfileCache.FAKE : var5.getSession().getUsername();
         if (var51 != bw[0] || bz[0] != var15) {
            c(0, var51, 110.0F);
         }

         var6 = var5.player != null ? var5.player.getSkin() : DefaultSkinHelper.getSteve();
         var7 = var6.body().texturePath();
         int var17 = Math.round(13.0F * (float)StyleKeyCache.MAG);
         if (var7 != db || var17 != cz) {
            h((SkinTextures)var6, (Identifier)var7, var17);
         }
      }

      if (bi[1]) {
         var8 = var5.getCurrentServerEntry();
         String var52 = var8 == null ? null : var8.address;
         if (!cd || var52 != cc || bz[1] != var15) {
            cd = true;
            cc = var52;
            c(1, var1.bd(), 150.0F);
         }
      }

      if (bi[2]) {
         float var53 = CoreZoneProcessor.fj;
         int var58 = Math.round(var53 < 0.0F ? (float)var5.getCurrentFps() : var53);
         if (var58 != by[2] || bz[2] != var15) {
            d(2, 0, var58);
         }
      }

      if (bi[3]) {
         float var54 = CoreZoneProcessor.fk;
         int var59 = var54 < 0.0F ? 0 : Math.round(var54);
         if (var59 != by[3] || bz[3] != var15) {
            d(3, 1, var59);
         }
      }

      if (bi[4]) {
         int var55 = var1.ah();
         if (var55 != by[4] || bz[4] != var15) {
            d(4, 2, var55);
         }
      }

      if (bi[5]) {
         long var56 = System.currentTimeMillis();
         long var18 = Math.floorDiv(var56, 60000L);
         if (var18 != ce) {
            ce = var18;
            cf = (int)Math.floorMod(Math.floorDiv(var56 + (long)TimeZone.getDefault().getOffset(var56), 60000L), 1440L);
         }

         if (cf != by[5] || bz[5] != var15) {
            e(cf);
         }
      }

      float var57 = var13 ? 1.0F : 1.0F - (float)Math.exp((double)(-var1.dn * 13.0F));
      br = true;
      float var60 = bj ? 1.0F : 0.0F;
      float var61 = ca + (var60 - ca) * var57;
      if (Math.abs(var60 - var61) < 0.004F) {
         var61 = var60;
      }

      ca = var61;
      float var19 = 0.0F;
      float var20 = 0.0F;

      for (int var21 = 0; var21 < 6; var21++) {
         float var22 = bi[var21] ? 1.0F : 0.0F;
         float var23 = bs[var21] + (var22 - bs[var21]) * var57;
         if (Math.abs(var22 - var23) < 0.004F) {
            var23 = var22;
         }

         bs[var21] = var23;
         float var24 = bt[var21] + (bu[var21] - bt[var21]) * var57;
         if (Math.abs(bu[var21] - var24) < 0.05F) {
            var24 = bu[var21];
         }

         bt[var21] = var24;
         if (var23 > 0.0F) {
            var19 += Math.min(var23, var20) * 18.0F + var23 * ((var21 == 0 ? 19.0F : 15.5F) + var24);
            if (var23 > var20) {
               var20 = var23;
            }
         }
      }

      float var62 = var20 > 0.0F ? var20 * 24.0F + var19 : 0.0F;
      float var63 = var61 * 20.0F + Math.min(var61, var20) * 6.0F + var62;
      int[] var64 = var1.ew[0];
      float var65 = var1.fc[0];
      if (!(var63 <= 0.01F) && !(var65 < 0.02F)) {
         int var25 = StyleKeyCache.MAG;
         float var26 = (float)(bk / 100.0 * (double)var2) - var63 * 0.5F;
         float var27 = Math.max(2.0F, (float)var2 - var63 - 2.0F);
         var26 = var26 < 2.0F ? 2.0F : (var26 > var27 ? var27 : var26);
         float var28 = (float)(bl / 100.0 * (double)var3);
         var27 = Math.max(2.0F, (float)var3 - 20.0F - 2.0F);
         var28 = var28 < 2.0F ? 2.0F : (var28 > var27 ? var27 : var28);
         var26 = (float)Math.round(var26 * (float)var25) / (float)var25;
         var28 = (float)Math.round(var28 * (float)var25) / (float)var25;
         int var29 = (int)Math.floor((double)var26);
         int var30 = (int)Math.floor((double)var28);
         var64[0] = var29;
         var64[1] = var30;
         var64[2] = Math.max(1, (int)Math.ceil((double)(var26 + var63)) - var29);
         var64[3] = (int)Math.ceil((double)(var28 + 20.0F)) - var30;
         var28 = (float)Math.round((var28 + (1.0F - var65) * 4.0F) * (float)var25) / (float)var25;
         var0.createNewRootLayer();
         if (var61 > 0.0F) {
            float var31 = var61 * var65;
            int var32 = StyleKeyCache.TILE;
            StyleKeyCache.r(var0, var26, var28, 20.0F, 20.0F, 7.0F, (int)((float)(var32 >>> 24) * var31 + 0.5F) << 24 | var32 & (-265493275 ^ -254600422));
            if (var1.dl == 1) {
               g(var0, var26, var28, var31);
            } else {
               StyleKeyCache.ab(var0, 0, var26 + 1.0F, var28 + 1.0F, 18.0F, (int)(255.0F * var31 + 0.5F) << 24 | 187123140 ^ 198752827);
            }
         }

         if (!(var20 <= 0.0F)) {
            float var72 = var26 + var61 * 20.0F + Math.min(var61, var20) * 6.0F;
            if (var1.eo) {
               int var73 = StyleKeyCache.PANEL;
               StyleKeyCache.r(
                  var0, var72, var28, var62, 20.0F, 6.0F, (int)((float)(var73 >>> 24) * var20 * var65 + 0.5F) << 24 | var73 & (-1267167378 ^ -1266192239)
               );
            }

            boolean var74 = var1.ep;
            int var33 = 515143698 ^ 507612645;
            float var34 = var72 + var20 * 12.0F;
            float var35 = 0.0F;
            int var36 = 0;

            for (int var37 = 0; var37 < 6; var37++) {
               float var38 = bs[var37];
               if (!(var38 <= 0.0F)) {
                  float var39 = Math.min(var38, var35);
                  if (var39 > 0.0F) {
                     cg[var36] = var34 + var39 * 9.0F;
                     ch[var36] = var39;
                     var36++;
                     var34 += var39 * 18.0F;
                  }

                  if (var38 > var35) {
                     var35 = var38;
                  }

                  int var40 = (int)(255.0F * var38 * var38 * var65 + 0.5F);
                  float var41;
                  if (var37 == 0) {
                     var41 = 19.0F;
                     int var80 = cy;
                     if (var80 >= 0 && cv[var80]) {
                        StyleKeyCache.u(var0, cs[var80], var34, var28 + 3.5F, 13.0F, 13.0F, cu[var80], cu[var80], var40 << 24 | -794484512 ^ -799351009);
                     } else if (dc != null) {
                        n(var0, var34, var28 + 3.5F, var40);
                     }
                  } else {
                     var41 = 15.5F;
                     int var42 = var37 == 5 ? StyleKeyCache.A : StyleKeyCache.A2;
                     StyleKeyCache.ae(var0, bh[var37], var34, var28 + 4.5F, 11.0F, var40 << 24 | var42 & (-316128540 ^ -304628453));
                  }

                  var10 = bv[var37];
                  if (var10 != null) {
                     StyleKeyCache.i(var0, (Text)var10, var34 + var41, var28 + 13.8F, var40 << 24 | var33, var74);
                  }

                  var34 += var38 * (var41 + bt[var37]);
               }
            }

            if (var36 > 0) {
               int var75 = -1454605201 ^ -1212972144;
               int var76 = Math.round((var28 + 5.0F) * (float)var25);
               int var77 = Math.max(var76 + 1, Math.round((var28 + 5.0F + 10.0F) * (float)var25));
               var9 = var0.getMatrices();
               var9.pushMatrix();

               try {
                  var9.scale(1.0F / (float)var25, 1.0F / (float)var25);

                  for (int var78 = 0; var78 < var36; var78++) {
                     int var79 = Math.round(cg[var78] * (float)var25);
                     var0.fill(
                        var79, var76, var79 + 1, var77, (int)((float)(var75 >>> 24) * ch[var78] * var65 + 0.5F) << 24 | var75 & (1872491633 ^ 1868827534)
                     );
                  }
               } finally {
                  var9.popMatrix();
               }
            }
         }
      } else {
         var64[2] = 0;
      }
   }

   private static void b(CoreZoneProcessor var0) {

      bi[0] = var0.ck.f();
      bi[1] = var0.cl.f();
      bi[2] = var0.cm.f();
      bi[3] = var0.cn.f();
      bi[4] = var0.co.f();
      bi[5] = var0.cp.f();
      bj = var0.wm.f();
      bk = var0.bu.p();
      bl = var0.bv.p();
   }

   private static void c(int var0, String var1, float var2) {

      Text var3 = bv[var0];
      if (var3 != null && bz[var0] == StyleKeyCache.ba && var1 != null && var1.equals(bw[var0])) {
         bw[var0] = var1;
      } else {
         String var4 = StyleKeyCache.o(var1, 10, var2);
         if (var3 == null || !var4.equals(bx[var0])) {
            var3 = f(var4);
            bv[var0] = var3;
            bx[var0] = var4;
         }

         bu[var0] = MinecraftClient.getInstance().textRenderer.getTextHandler().getWidth(var3);
         bw[var0] = var1;
         bz[var0] = StyleKeyCache.ba;
      }
   }

   private static void d(int var0, int var1, int var2) {

      int var3 = var1 == 2 ? var2 + 1 : var2;
      boolean var4 = var3 >= 0 && var3 < cn[var1].length;
      Text var5 = var4 ? cn[var1][var3] : null;
      if (var5 == null) {
         StringBuilder var6 = cq;
         var6.setLength(0);
         if (var1 == 2) {
            if (var2 < 0) {
               var6.append(u[3]);
            } else {
               var6.append(var2 / 10).append('.').append(var2 % 10);
            }

            var6.append(u[2]);
         } else {
            var6.append(var2).append(u[var1 == 0 ? 0 : 1]);
         }

         var5 = f(var6.toString());
         if (var4) {
            cn[var1][var3] = var5;
            cp[var1][var3] = 0;
         }
      }

      int var8 = StyleKeyCache.ba + 1;
      float var7;
      if (var4 && cp[var1][var3] == var8) {
         var7 = co[var1][var3];
      } else {
         var7 = MinecraftClient.getInstance().textRenderer.getTextHandler().getWidth(var5);
         if (var4) {
            co[var1][var3] = var7;
            cp[var1][var3] = var8;
         }
      }

      bv[var0] = var5;
      bu[var0] = var7;
      by[var0] = var2;
      bz[var0] = StyleKeyCache.ba;
   }

   private static void e(int var0) {

      Text var1 = bv[5];
      if (var1 == null || by[5] != var0) {
         int var2 = var0 / 60;
         int var3 = var0 % 60;
         StringBuilder var4 = cq;
         var4.setLength(0);
         var4.append((char)(48 + var2 / 10)).append((char)(48 + var2 % 10)).append(':').append((char)(48 + var3 / 10)).append((char)(48 + var3 % 10));
         var1 = f(var4.toString());
         bv[5] = var1;
      }

      bu[5] = MinecraftClient.getInstance().textRenderer.getTextHandler().getWidth(var1);
      by[5] = var0;
      bz[5] = StyleKeyCache.ba;
   }

   private static Text f(String var0) {

      return Text.literal(var0).setStyle(StyleKeyCache.ST[10]);
   }

   private static void g(DrawContext var0, float var1, float var2, float var3) {

      int var4 = StyleKeyCache.MAG;
      int var5 = Math.round(14.0F * (float)var4);
      int var6 = Math.round((var1 + 3.0F) * (float)var4);
      int var7 = Math.round((var2 + 3.0F) * (float)var4);
      int var8 = StyleKeyCache.PETAL;
      int var9 = -1076262960 ^ 1076253020;
      Matrix3x2fStack var10 = var0.getMatrices();
      var10.pushMatrix();

      try {
         var10.scale(1.0F / (float)var4, 1.0F / (float)var4);
         RasterCache.glyph(var0, 3, var6, var7, var5, (int)((float)(var8 >>> 24) * var3 + 0.5F) << 24 | var8 & (1666241804 ^ 1672424179));
      } finally {
         var10.popMatrix();
      }

      StyleKeyCache.t(var0, var1 + 10.0F, var2 + 10.0F, 2.8F, (int)((float)(var9 >>> 24) * var3 + 0.5F) << 24 | var9 & (-1938584991 ^ -1936951906));
   }

   private static void h(SkinTextures var0, Identifier var1, int var2) {

      db = var1;
      cz = var2;
      dc = var0;
      long var3 = ++cx;

      for (int var5 = 0; var5 < 4; var5++) {
         if (cu[var5] == var2 && var1.equals(ct[var5])) {
            cy = var5;
            cw[var5] = var3;
            return;
         }
      }

      int var7 = 0;

      for (int var6 = 1; var6 < 4; var6++) {
         if (cw[var6] < cw[var7]) {
            var7 = var6;
         }
      }

      cy = var7;
      cw[var7] = var3;
      ct[var7] = var1;
      cu[var7] = var2;
      cv[var7] = false;
      int[] var8 = i(var1);
      if (var8 != null) {
         cv[var7] = m(var7, l(var8, da, var2), var2);
      }
   }

   private static int[] i(Identifier var0) {

      MinecraftClient var1 = MinecraftClient.getInstance();
      Object var2 = null;
      Object var3 = null;

      try {
         var2 = var1.getTextureManager().getTexture(var0);
      } catch (Throwable var5) {
         var2 = null;
      }

      if (var2 instanceof NativeImageBackedTexture) {
         var3 = ((NativeImageBackedTexture)var2).getImage();
         int[] var4 = k((NativeImage)var3);
         if (var4 != null) {
            return var4;
         }
      }

      return j(var1, var0);
   }

   private static int[] j(MinecraftClient var0, Identifier var1) {

      Resource var2 = null;
      NativeImage var3 = null;
      InputStream var4 = null;

      Object var25;
      try {
         Optional var5 = var0.getResourceManager().getResource(var1);
         if (!var5.isEmpty()) {
            var2 = (Resource)var5.get();
            var4 = var2.getInputStream();
            var3 = NativeImage.read(var4);
            return k(var3);
         }

         var25 = null;
      } catch (Throwable var22) {
         return null;
      } finally {
         if (var3 != null) {
            try {
               var3.close();
            } catch (Throwable var21) {
            }
         }

         if (var4 != null) {
            try {
               var4.close();
            } catch (Throwable var20) {
            }
         }
      }

      return (int[])var25;
   }

   private static int[] k(NativeImage var0) {

      if (var0 == null) {
         return null;
      } else {
         try {
            int var1 = var0.getWidth() / 64;
            if (var1 >= 1 && var0.getHeight() >= 16 * var1) {
               int var2 = 8 * var1;
               int[] var3 = new int[var2 * var2];

               for (int var4 = 0; var4 < var2; var4++) {
                  for (int var5 = 0; var5 < var2; var5++) {
                     int var6 = var0.getColorArgb(var2 + var5, var2 + var4) | -1261699409 ^ 1271660207;
                     int var7 = var0.getColorArgb(5 * var2 + var5, var2 + var4);
                     int var8 = var7 >>> 24;
                     if (var8 >= (-11354202 ^ -11354279)) {
                        var6 = var7;
                     } else if (var8 > 0) {
                        int var9 = (1131289375 ^ 1131289568) - var8;
                        int var10 = ((var7 >> 16 & (-441850885 ^ -441851132)) * var8 + (var6 >> 16 & (-1996433466 ^ -1996433607)) * var9 + 127)
                           / (543273557 ^ 543273642);
                        int var11 = ((var7 >> 8 & (1319261368 ^ 1319261255)) * var8 + (var6 >> 8 & (22051284 ^ 22051115)) * var9 + 127)
                           / (1460770543 ^ 1460770320);
                        int var12 = ((var7 & (-1099702625 ^ -1099702688)) * var8 + (var6 & (-860514363 ^ -860514502)) * var9 + 127) / (-412884014 ^ -412884179);
                        var6 = -1802272753 ^ 1804828687 | var10 << 16 | var11 << 8 | var12;
                     }

                     var3[var4 * var2 + var5] = var6;
                  }
               }

               da = var2;
               return var3;
            } else {
               return null;
            }
         } catch (Throwable var13) {
            return null;
         }
      }
   }

   private static int[] l(int[] var0, int var1, int var2) {

      int[] var3 = new int[var2 * var2];
      float var4 = (float)var2 * 0.5F;
      float var5 = var4 * var4;
      float var6 = (float)var1 / (float)var2;

      for (int var7 = 0; var7 < var2; var7++) {
         for (int var8 = 0; var8 < var2; var8++) {
            int var9 = 0;
            int var10 = 0;
            int var11 = 0;
            int var12 = 0;

            for (int var13 = 0; var13 < 4; var13++) {
               float var14 = (float)var7 + ((float)var13 + 0.5F) * 0.25F;
               float var15 = var14 - var4;
               int var16 = Math.min(var1 - 1, (int)(var14 * var6));

               for (int var17 = 0; var17 < 4; var17++) {
                  float var18 = (float)var8 + ((float)var17 + 0.5F) * 0.25F;
                  float var19 = var18 - var4;
                  if (!(var19 * var19 + var15 * var15 > var5)) {
                     int var20 = var0[var16 * var1 + Math.min(var1 - 1, (int)(var18 * var6))];
                     var9++;
                     var10 += var20 >> 16 & (-1606357187 ^ -1606357054);
                     var11 += var20 >> 8 & (300104672 ^ 300104479);
                     var12 += var20 & (-1028494504 ^ -1028494425);
                  }
               }
            }

            if (var9 > 0) {
               int var21 = (var9 * (27950512 ^ 27950415) + 8) / 16;
               var3[var7 * var2 + var8] = var21 << 24 | (var10 + var9 / 2) / var9 << 16 | (var11 + var9 / 2) / var9 << 8 | (var12 + var9 / 2) / var9;
            }
         }
      }

      return var3;
   }

   private static boolean m(int var0, int[] var1, int var2) {

      NativeImage var3 = null;
      boolean var4 = false;

      boolean var6;
      try {
         var3 = new NativeImage(NativeImage.Format.RGBA, var2, var2, false);

         for (int var5 = 0; var5 < var2; var5++) {
            for (int var19 = 0; var19 < var2; var19++) {
               var3.setColorArgb(var19, var5, var1[var5 * var2 + var19]);
            }
         }

         MinecraftClient.getInstance().getTextureManager().registerTexture(cs[var0], new NativeImageBackedTexture(dd, var3));
         var4 = true;
         return true;
      } catch (Throwable var16) {
         var6 = false;
      } finally {
         if (!var4 && var3 != null) {
            try {
               var3.close();
            } catch (Throwable var15) {
            }
         }
      }

      return var6;
   }

   private static void n(DrawContext var0, float var1, float var2, int var3) {

      SkinTextures var4 = dc;
      int var5 = StyleKeyCache.MAG;
      int var6 = Math.round(var1 * (float)var5);
      int var7 = Math.round(var2 * (float)var5);
      int var8 = Math.round(13.0F * (float)var5);
      Matrix3x2fStack var9 = var0.getMatrices();
      var9.pushMatrix();

      try {
         var9.scale(1.0F / (float)var5, 1.0F / (float)var5);
         PlayerSkinDrawer.draw(var0, var4, var6, var7, var8, var3 << 24 | -1961834046 ^ -1947257283);
      } finally {
         var9.popMatrix();
      }
   }

   static void o(DrawContext var0, CoreZoneProcessor var1, int var2, int var3, boolean var4, boolean var5) {

      int[] var6 = var1.ew[5];
      float var7 = var1.fc[5];
      if (var1.ew[0][2] > 0) {
         float var8 = var1.ey[0];
         var7 *= 1.0F - var8 * var8 * (3.0F - 2.0F * var8);
      }

      if (var7 < 0.02F) {
         var6[2] = 0;
      } else {
         long var24 = System.nanoTime();
         if (var5 || var24 - bq > 250000000L) {
            bq = var24;
            bm = var1.wmX.p();
            bn = var1.wmY.p();
         }

         if (de == null || StyleKeyCache.bb != di || StyleKeyCache.gen != dj || StyleKeyCache.ba != dk) {
            p(var1);
         }

         float var10 = 26.0F + dl + 9.0F;
         int var11 = StyleKeyCache.MAG;
         float var12 = (float)(bm / 100.0 * (double)var2) - var10 * 0.5F;
         float var13 = Math.max(2.0F, (float)var2 - var10 - 2.0F);
         var12 = var12 < 2.0F ? 2.0F : (var12 > var13 ? var13 : var12);
         float var14 = (float)(bn / 100.0 * (double)var3);
         float var15 = Math.max(2.0F, (float)var3 - 20.0F - 2.0F);
         var14 = var14 < 2.0F ? 2.0F : (var14 > var15 ? var15 : var14);
         int[] var16 = var1.ew[4];
         if (var4
            && var16[2] > 0
            && var12 < (float)(var16[0] + var16[2])
            && var12 + var10 > (float)var16[0]
            && var14 < (float)(var16[1] + var16[3] + 3)
            && var14 + 20.0F > (float)var16[1]) {
            var14 = Math.min(var15, (float)(var16[1] + var16[3]) + 3.0F);
         }

         var12 = (float)Math.round(var12 * (float)var11) / (float)var11;
         var14 = (float)Math.round(var14 * (float)var11) / (float)var11;
         int var17 = (int)Math.floor((double)var12);
         int var18 = (int)Math.floor((double)var14);
         var6[0] = var17;
         var6[1] = var18;
         var6[2] = Math.max(1, (int)Math.ceil((double)(var12 + var10)) - var17);
         var6[3] = (int)Math.ceil((double)(var14 + 20.0F)) - var18;
         var14 = (float)Math.round((var14 + (1.0F - var7) * 4.0F) * (float)var11) / (float)var11;
         var0.createNewRootLayer();
         if (var1.eo) {
            int var19 = StyleKeyCache.PANEL;
            StyleKeyCache.r(var0, var12, var14, var10, 20.0F, 7.0F, (int)((float)(var19 >>> 24) * var7 + 0.5F) << 24 | var19 & (1595939692 ^ 1608508563));
         }

         int var30 = StyleKeyCache.TILE;
         StyleKeyCache.r(var0, var12, var14, 20.0F, 20.0F, 7.0F, (int)((float)(var30 >>> 24) * var7 + 0.5F) << 24 | var30 & (1015519275 ^ 1014523860));
         int var20 = (int)(255.0F * var7 + 0.5F);
         if (var1.dl == 1) {
            g(var0, var12, var14, var7);
         } else {
            StyleKeyCache.ab(var0, 0, var12 + 1.0F, var14 + 1.0F, 18.0F, var20 << 24 | -245475498 ^ -241063767);
         }

         float var21 = var12 + 20.0F + 6.0F;
         float var22 = var14 + 13.8F;
         if (var1.ep) {
            float var23 = StyleKeyCache.PX;
            StyleKeyCache.j(var0, dq, var21 + var23, var22 + var23, (int)(199.0F * var7) << 24 | StyleKeyCache.SHADOW, false);
         }

         StyleKeyCache.j(var0, dp, var21, var22, var20 << 24 | 693937007 ^ 698963608, false);
      }
   }

   private static void p(CoreZoneProcessor var0) {

      OrderedText var1 = null;
      if (de == null) {
         var0.ao();
         var1 = var0.er;
         int[] var2 = new int[64];
         dm = var2;
         dn = 0;

         try {
            if (var1 != null) {
               var1.accept(_kwren_do);
            }
         } catch (Throwable var6) {
            dn = 0;
         }

         dm = null;
         int[] var3 = Arrays.copyOf(var2, dn);
         int var4 = -1;

         for (int var5 = 0; var5 < var3.length; var5++) {
            if (var3[var5] == 46) {
               var4 = var5;
            }
         }

         df = var4;
         de = var3;
      }

      int var8 = StyleKeyCache.bb;
      if (var8 != di || StyleKeyCache.gen != dj) {
         if (var8 != di) {
            dk = -1433957493 ^ 713526155;
         }

         di = var8;
         dj = StyleKeyCache.gen;
         dg = StyleKeyCache.ST[10];
         dh = dg.withColor(StyleKeyCache.A & (146358312 ^ 138854359));
      }

      if (StyleKeyCache.ba != dk) {
         dk = StyleKeyCache.ba;
         dl = MinecraftClient.getInstance().textRenderer.getTextHandler().getWidth(dp);
      }
   }

   static {
      for (int var0 = 0; var0 < 4; var0++) {
         cs[var0] = Identifier.of("lithium", "h" + "ud2_he" + "a" + "d_" + var0);
      }

      df = -1;
      dg = Style.EMPTY;
      dh = Style.EMPTY;
      di = Integer.MIN_VALUE;
      dj = Integer.MIN_VALUE;
      dk = Integer.MIN_VALUE;
      dl = 0.0F;
      _kwren_do = (var0x, var1, var2) -> {
         byte var3 = 0;

         label16:
         while (true) {
            switch (var3) {
               case 0:
               default:
                  if (dr != 0) {
                     new Object().hashCode();
                     var3 = 1;
                     break;
                  }
               case 1:
                  if (dn >= dm.length) {
                     return false;
                  }
               case 2:
                  break label16;
            }
         }

         dm[dn++] = var2;
         return true;
      };
      dp = var0x -> {

         int[] var1 = de;
         if (var1 == null) {
            return true;
         } else {
            Style var2 = dg;
            Style var3 = dh;
            int var4 = df;

            for (int var5 = 0; var5 < var1.length; var5++) {
               if (!var0x.accept(var5, var5 == var4 ? var3 : var2, var1[var5])) {
                  return false;
               }
            }

            return true;
         }
      };
      dq = var0x -> {

         int[] var1 = de;
         if (var1 == null) {
            return true;
         } else {
            Style var2 = dg;

            for (int var3 = 0; var3 < var1.length; var3++) {
               if (!var0x.accept(var3, var2, var1[var3])) {
                  return false;
               }
            }

            return true;
         }
      };
   }
}
