package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.yggdrasil.ProfileResult;
import java.net.HttpURLConnection;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.cluster.InitNotifier;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.ParserEngine;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.CheckerBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.PlacementEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.TextEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.ProfileTextCache;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.entity.player.SkinTextures;
import net.minecraft.entity.Entity;
public final class EntityProfileCache extends BuilderFactory implements InitNotifier {
   public static volatile boolean ON = false;
   public static volatile String FAKE = "";
   public static volatile String REAL = "";
   public static volatile boolean SKIN_ON = true;
   public static volatile SkinTextures SKIN = null;
   private final TextEntry h;
   private final PlacementEntry i;
   private final PlacementEntry j;
   private final PlacementEntry k;
   private final PlacementEntry l;
   private final CheckerBridge m;
   private String n;
   private int o;
   private final String[] p;

   public EntityProfileCache() {
      super("", "", ParserEngine.Z3);
      this.setName(
         new char[]{'ⵈ', 'ⴋ', 'ⴥ', 'ⴎ', 'ⷧ', 'ⶁ', 'ⶐ', 'ⶭ', 'ⶑ', '\u2e69', '⹙', '⸸', '⸎'},
         452996358,
         new char[]{
            '\ud9cb',
            '\ud9df',
            '\ud9b9',
            '\ud982',
            '\uda34',
            '\uda52',
            '\uda3c',
            '\uda1e',
            '\udae4',
            '\udac7',
            '\udaab',
            '\uda9f',
            '\udb2c',
            '\udb45',
            '\udb2b',
            '\udb04',
            '\udbed',
            '\udb87',
            '\udbaf',
            '\udb8b',
            '\udc77',
            '\udc57',
            '\udc27',
            '\udc00',
            '\udce4',
            '\udcbf',
            '\udcd1',
            '\udcbb',
            '\udcdc',
            '\udd62',
            '\udd55',
            '\udd2c',
            '\udd0a',
            '\udde4',
            '\udd9a',
            '\uddf5',
            '\udd9b',
            '\ude7d',
            '\ude5e',
            '\ude28',
            '\ude50',
            '\udee0',
            '\udec0',
            '\udeed',
            '\ude95',
            '\udf64',
            '\udf5f',
            '\udf3b',
            '\udf48',
            '\udff4',
            '\udfc5',
            '\udfb7',
            '\udf81',
            '\ue066',
            '\ue04c'
         },
         -1624516200
      );
      TextEntry var10001 = new TextEntry("", "Player", 16);
      var10001.n(new char[]{'\uf551', '\uf55f', '\uf530', '\uf519'}, 1539175711);
      this.h = var10001;
      PlacementEntry var1 = new PlacementEntry("", 1.0, 0.0, 1.0, 1.0);
      var1.n(new char[]{'\uf635', '\uf6e1', '\uf6fd', '\uf69e', '\uf691', '\uf695', '\uf768', '\uf74e'}, 147912289);
      this.i = var1;
      PlacementEntry var2 = new PlacementEntry("", 1.0, 0.0, 1.0, 1.0);
      var2.n(new char[]{'忼', '徰', '徝', '恪', '恚', '怬', '怋', '惸'}, 1666015154);
      this.j = var2;
      PlacementEntry var3 = new PlacementEntry("", 1.0, 0.0, 1.0, 1.0);
      var3.n(new char[]{'\udc7f', '\udc33', '\udc1b', '\udced'}, 993254460);
      this.k = var3;
      PlacementEntry var4 = new PlacementEntry("", 1.0, 0.0, 1.0, 1.0);
      var4.n(new char[]{'ꇘ', 'ꇂ', 'ꆾ', 'ꆅ', 'ꉭ', 'ꉔ'}, -1897029236);
      this.l = var4;
      CheckerBridge var5 = new CheckerBridge("", true);
      var5.n(new char[]{'朱', '柾', '柀', '架', '柎', '桞', '桇', '栢', '栄'}, -1541118094);
      this.m = var5;
      this.n = "";
      this.o = 0;
      this.p = new String[2];
      this.a(new InitAdapter[]{this.h, this.i, this.j, this.k, this.l, this.m});
   }

   @Override
   public void c() {

      this.b.a(InitNotifier.class, this);
      super.c();
      this.a_r105(true);
   }

   @Override
   public void d() {

      this.b.b(InitNotifier.class, this);
      ON = false;
      SKIN = null;
      this.n = "";
      ProfileTextCache.set(false, this.p, "");
      ProfileTextCache.EDIT = false;
      this.b();
      super.d();
   }

   @Override
   public void a() {

      try {
         this.a_r105(super.f);
      } catch (Throwable var2) {
      }
   }

   private void a_r105(boolean var1) {

      ProfileTextCache.EDIT = false;
      String var2 = a.getSession() != null ? a.getSession().getUsername() : "";
      REAL = var2 == null ? "" : var2;
      String var3 = this.h.f();
      String var4 = var3 == null ? "" : var3.trim();
      FAKE = var4;
      SKIN_ON = this.m.f();
      ON = var1 && !var4.isEmpty();
      String[] var5 = this.p;
      var5[0] = REAL;
      var5[1] = a.player != null && a.player.getGameProfile() != null ? a.player.getGameProfile().name() : null;
      ProfileTextCache.set(ON, var5, var4);
      if (ProfileTextCache.GEN != this.o) {
         this.b();
      }

      if (ON && SKIN_ON && a.player != null) {
         if (!var4.equalsIgnoreCase(this.n)) {
            this.n = var4;
            SKIN = null;
            PlayerListEntry var6 = a.getNetworkHandler() != null ? a.getNetworkHandler().getCaseInsensitivePlayerInfo(var4) : null;
            if (var6 != null) {
               SKIN = var6.getSkinTextures();
            } else {
               c(var4);
            }
         }
      } else if (!ON || !SKIN_ON) {
         SKIN = null;
         this.n = "";
      }
   }

   private void b() {

      this.o = ProfileTextCache.GEN;

      try {
         if (a.inGameHud != null) {
            ChatHud var1 = a.inGameHud.getChatHud();
            if (var1 != null) {
               var1.reset();
            }
         }
      } catch (Throwable var2) {
      }
   }

   private static void c(String var0) {

      CompletableFuture.runAsync(() -> {

         try {
            String var1 = d(var0);
            if (var1 == null) {
               return;
            }

            UUID var2 = e(var1);
            GameProfile var3 = new GameProfile(var2, var0);
            ProfileResult var4 = a.getApiServices().sessionService().fetchProfile(var2, false);
            GameProfile var5 = var4 != null ? var4.profile() : var3;
            a.getSkinProvider().fetchSkinTextures(var5).thenAccept(var1x -> {

               if (var1x != null && var1x.isPresent() && var0.equalsIgnoreCase(FAKE)) {
                  SKIN = (SkinTextures)var1x.get();
               }
            });
         } catch (Throwable var6) {
         }
      });
   }

   private static String d(String var0) {

      try {
         HttpURLConnection var1 = (HttpURLConnection)URI.create("http://127.0.0.1:1/users/profil" + "es/minecraft/" + var0).toURL().openConnection();
         var1.setConnectTimeout(-2031839493 ^ -2031843981);
         var1.setReadTimeout(612091005 ^ 612095989);
         if (var1.getResponseCode() != (898007379 ^ 898007451)) {
            return null;
         } else {
            String var2 = new String(var1.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
            JsonObject var3 = JsonParser.parseString(var2).getAsJsonObject();
            return var3.has("id") ? var3.get("id").getAsString() : null;
         }
      } catch (Throwable var4) {
         return null;
      }
   }

   private static UUID e(String var0) {

      return UUID.fromString(var0.replaceFirst("(.{8})(.{4})(.{4})(." + "{4})(.{12})", "$1-$2-$3-$4-$5"));
   }
}
