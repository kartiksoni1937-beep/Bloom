package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.BlockCalculator;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.CheckerBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.ItemDescriptor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.SlotEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.TextEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.TimingEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.NoticeQueue;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.SyncController;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.ThemeCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.CoreZoneProcessor;

public final class LoaderBridge {
   private final Gson al = new GsonBuilder().setPrettyPrinting().create();
   private Path am;
   private Path an;
   private static final String ao = "DQC1:";
   private static final String ap = "profiles" + ".meta";
   private static final String aq = ".trash";
   private static final String ar = "exports";
   private static final int as = 20;
   private static final long at = 4194304L;
   private static final byte[] au = new byte[]{55, -101, 17, -60, 94, 42, -48, 99};

   public LoaderBridge() {
      String var1 = System.getProperty("u" + "ser.h" + "o" + "me");
      String var2;
      if (System.getProperty("os.name").toLowerCase().contains("win")) {
         var2 = "AppData/Roaming/.minecraft/.mcClient-renderer-cache";
      } else {
         var2 = ".minecr" + "aft/.mcClient-renderer-cache";
      }

      this.am = Paths.get(var1, var2);
      this.an = this.am.resolve("defaul" + "t." + "json");
   }

   public void a() {

      try {
         if (!Files.isRegularFile(this.an)) {
            return;
         }

         byte[] var1 = Files.readAllBytes(this.an);
         if (var1.length == 0) {
            return;
         }

         String var2;
         boolean var3;
         if (var1[0] != 123 && var1[0] != 32 && var1[0] != 10 && var1[0] != 13 && var1[0] != 9) {
            var2 = ak(var1);
            var3 = false;
         } else {
            var2 = new String(var1, StandardCharsets.UTF_8);
            var3 = true;
         }

         JsonObject var4 = (JsonObject)this.al.fromJson(var2, JsonObject.class);
         if (var4 == null) {
            return;
         }

         if (var3) {
            try {
               Files.write(this.an, aj(var2));
            } catch (Exception var6) {
            }
         }

         this.a(var4);
      } catch (Exception var7) {
      }
   }

   public void a(JsonObject var1) {

      try {
         if (var1 == null) {
            return;
         }

         JsonElement var2 = var1.get("guiS" + "e" + "tti" + "ngs");
         if (var2 != null && var2.isJsonObject()) {
            JsonObject var3 = var2.getAsJsonObject();

            try {
               if (var3.has("clickGuiScale")) {
                  SyncController.n = var3.get("clickGui" + "Sc" + "a" + "le").getAsFloat();
               }
            } catch (Exception var33) {
            }

            try {
               if (var3.has("russ" + "ianTh" + "e" + "me")) {
                  SyncController.m = var3.get("russia" + "nT" + "heme").getAsBoolean();
               }
            } catch (Exception var32) {
            }

            try {
               if (var3.has("redColor")) {
                  SyncController.b = var3.get("redColor").getAsInt();
               }
            } catch (Exception var31) {
            }

            try {
               if (var3.has("gr" + "eenC" + "o" + "lor")) {
                  SyncController.c = var3.get("greenColor").getAsInt();
               }
            } catch (Exception var30) {
            }

            try {
               if (var3.has("blu" + "eC" + "ol" + "or")) {
                  SyncController.d = var3.get("bl" + "ueColor").getAsInt();
               }
            } catch (Exception var29) {
            }

            try {
               if (var3.has("bgRed")) {
                  SyncController.e = var3.get("bgRed").getAsInt();
               }
            } catch (Exception var28) {
            }

            try {
               if (var3.has("bgGreen")) {
                  SyncController.f = var3.get("bgGreen").getAsInt();
               }
            } catch (Exception var27) {
            }

            try {
               if (var3.has("bgBlue")) {
                  SyncController.g = var3.get("bgBlue").getAsInt();
               }
            } catch (Exception var26) {
            }

            try {
               if (var3.has("themeIn" + "d" + "ex")) {
                  int var4 = var3.get("them" + "eIndex").getAsInt();
                  ThemeCache.o = var4 >= 0 && var4 < ThemeCache.ALL.length ? var4 : 0;
               }
            } catch (Exception var34) {
            }

            try {
               if (var3.has("th" + "emeAccentR")) {
                  ThemeCache.p[0] = ThemeCache.n(var3.get("themeA" + "c" + "cen" + "tR").getAsInt());
               }

               if (var3.has("themeA" + "ccentG")) {
                  ThemeCache.p[1] = ThemeCache.n(var3.get("themeAc" + "c" + "en" + "tG").getAsInt());
               }

               if (var3.has("the" + "meAccen" + "tB")) {
                  ThemeCache.p[2] = ThemeCache.n(var3.get("theme" + "AccentB").getAsInt());
               }

               if (var3.has("themeBgR")) {
                  ThemeCache.q[0] = ThemeCache.n(var3.get("themeBgR").getAsInt());
               }

               if (var3.has("themeBgG")) {
                  ThemeCache.q[1] = ThemeCache.n(var3.get("themeBgG").getAsInt());
               }

               if (var3.has("themeBgB")) {
                  ThemeCache.q[2] = ThemeCache.n(var3.get("themeBgB").getAsInt());
               }
            } catch (Exception var25) {
            }

            try {
               if (var3.has("backgrou" + "ndDim")) {
                  SyncController.q = var3.get("backgro" + "u" + "n" + "dDim").getAsBoolean();
               }

               if (var3.has("tooltips")) {
                  SyncController.r = var3.get("tooltips").getAsBoolean();
               }

               if (var3.has("editHudLayout")) {
                  SyncController.s = var3.get("editHudLayout").getAsBoolean();
               }

               if (var3.has("glassPa" + "n" + "e" + "ls")) {
                  SyncController.t = var3.get("gla" + "ssPa" + "n" + "els").getAsBoolean();
               }

               if (var3.has("gui3d")) {
                  SyncController.u = var3.get("gui3d").getAsBoolean();
               }

               if (var3.has("gui3dDof")) {
                  SyncController.v = var3.get("gui3dDof").getAsBoolean();
               }

               if (var3.has("gu" + "i3dAmbience")) {
                  SyncController.w = var3.get("gui3dAmbi" + "en" + "ce").getAsBoolean();
               }

               if (var3.has("gui3dReduceMotion")) {
                  SyncController.x = var3.get("gui3dReduc" + "eMot" + "ion").getAsBoolean();
               }

               if (var3.has("gui3dCloseOnD" + "amage")) {
                  SyncController.y = var3.get("gui3dCloseOnDamage").getAsBoolean();
               }
            } catch (Exception var24) {
            }

            try {
               if (var3.has("guiScale")) {
                  SyncController.a = Math.max(1, Math.min(3, var3.get("guiScale").getAsInt()));
               }
            } catch (Exception var23) {
            }

            try {
               if (var3.has("notifyS" + "o" + "u" + "nd")) {
                  NoticeQueue.m = var3.get("notifySound").getAsBoolean();
               }
            } catch (Exception var22) {
            }

            try {
               if (var3.has("glas" + "sFrost")) {
                  SyncController.h = Math.max(0, Math.min(2, var3.get("glassFrost").getAsInt()));
               }
            } catch (Exception var21) {
            }

            try {
               if (var3.has("panel" + "O" + "p" + "acity")) {
                  SyncController.i = Math.max(25, Math.min(100, var3.get("pan" + "elOp" + "ac" + "ity").getAsInt()));
               }
            } catch (Exception var20) {
            }

            try {
               if (var3.has("dim" + "Amo" + "u" + "nt")) {
                  SyncController.j = Math.max(10, Math.min(100, var3.get("dimAmount").getAsInt()));
               }
            } catch (Exception var19) {
            }

            try {
               if (var3.has("backgroundBl" + "ur")) {
                  SyncController.k = var3.get("backgroundBlur").getAsBoolean();
               }
            } catch (Exception var18) {
            }

            try {
               if (var3.has("fallingPet" + "a" + "ls")) {
                  SyncController.l = Math.max(0, Math.min(2, var3.get("fallingP" + "e" + "tals").getAsInt()));
               }
            } catch (Exception var17) {
            }

            try {
               if (var3.has("tooltipD" + "elay")) {
                  SyncController.p = Math.max(0, Math.min(-1209973962 ^ -1209974562, var3.get("tooltipDelay").getAsInt()));
               }
            } catch (Exception var16) {
            }

            try {
               if (var3.has("ty" + "peToSearch")) {
                  SyncController.z = var3.get("typeToSea" + "r" + "ch").getAsBoolean();
               }
            } catch (Exception var15) {
            }

            try {
               if (var3.has("remembe" + "rLa" + "yout")) {
                  SyncController.aa = var3.get("rememb" + "erLa" + "yout").getAsBoolean();
               }
            } catch (Exception var14) {
            }

            try {
               if (var3.has("panel" + "Co" + "unts")) {
                  SyncController.ab = var3.get("pa" + "nelCou" + "nts").getAsBoolean();
               }
            } catch (Exception var13) {
            }

            try {
               if (var3.has("show" + "K" + "e" + "ybinds")) {
                  SyncController.ac = var3.get("showK" + "eybi" + "n" + "ds").getAsBoolean();
               }
            } catch (Exception var12) {
            }

            try {
               if (var3.has("moduleOrder")) {
                  SyncController.ad = Math.max(0, Math.min(1, var3.get("m" + "oduleOrder").getAsInt()));
               }
            } catch (Exception var11) {
            }

            try {
               if (var3.has("cli" + "ckSounds")) {
                  SyncController.ae = var3.get("clic" + "k" + "Soun" + "ds").getAsBoolean();
               }
            } catch (Exception var10) {
            }

            try {
               if (var3.has("uiVolume")) {
                  SyncController.af = Math.max(0, Math.min(-1016578802 ^ -1016578664, var3.get("uiVolume").getAsInt()));
               }
            } catch (Exception var9) {
            }

            try {
               if (var3.has("gui3dDis" + "ta" + "n" + "ce")) {
                  SyncController.ag = Math.max(0, Math.min(2, var3.get("gui3dDistan" + "ce").getAsInt()));
               }
            } catch (Exception var8) {
            }

            try {
               if (var3.has("gui3dShape")) {
                  SyncController.ah = Math.max(0, Math.min(1, var3.get("gui3" + "dSh" + "a" + "pe").getAsInt()));
               }
            } catch (Exception var7) {
            }

            try {
               if (var3.has("gui3dOpacity")) {
                  SyncController.ai = Math.max(70, Math.min(100, var3.get("gui3dOpacity").getAsInt()));
               }
            } catch (Exception var6) {
            }

            try {
               if (var3.has("guiKey")) {
                  CoreZoneProcessor var36 = ConfigBridge.c.c().a(CoreZoneProcessor.class);
                  if (var36 != null) {
                     var36.d(var3.get("guiKey").getAsInt());
                  }
               }
            } catch (Exception var5) {
            }
         }

         this.d(var1);
      } catch (Exception var35) {
      }
   }

   private static JsonElement b(JsonObject var0, BuilderFactory var1) {

      char[] var2 = var1.c;
      int var3 = var1.cK;

      for (Entry var5 : var0.entrySet()) {
         String var6 = (String)var5.getKey();
         if (var6.length() == var2.length) {
            boolean var7 = true;

            for (int var8 = 0; var8 < var2.length; var8++) {
               if ((char)(var2[var8] ^ var3 + var8 * 31) != var6.charAt(var8)) {
                  var7 = false;
                  break;
               }
            }

            if (var7) {
               return (JsonElement)var5.getValue();
            }
         }
      }

      return null;
   }

   private static JsonElement c(JsonObject var0, InitAdapter var1) {

      char[] var2 = var1.a;
      int var3 = var1.aK;

      for (Entry var5 : var0.entrySet()) {
         String var6 = (String)var5.getKey();
         if (var6.length() == var2.length) {
            boolean var7 = true;

            for (int var8 = 0; var8 < var2.length; var8++) {
               if ((char)(var2[var8] ^ var3 + var8 * 31) != var6.charAt(var8)) {
                  var7 = false;
                  break;
               }
            }

            if (var7) {
               return (JsonElement)var5.getValue();
            }
         }
      }

      return null;
   }

   private void d(JsonObject var1) {

      if (ConfigBridge.c != null && ConfigBridge.c.c() != null) {
         SyncDispatcher var2 = ConfigBridge.c.c();

         for (BuilderFactory var4 : var2.a()) {
            JsonElement var5 = var1.get(var4.getClass().getSimpleName());
            if (var5 == null || !var5.isJsonObject()) {
               var5 = b(var1, var4);
            }

            if (var5 != null && var5.isJsonObject()) {
               JsonObject var6 = var5.getAsJsonObject();
               JsonElement var7 = var6.get("enabled");

               try {
                  if (var7 != null && var7.isJsonPrimitive() && !var7.getAsBoolean()) {
                     var4.a(false);
                  }
               } catch (Exception var23) {
               }

               try {
                  JsonElement var8 = var6.get(new String(new byte[]{107, 101, 121, 66, 105, 110, 100}));
                  if (var8 != null && var8.isJsonPrimitive()) {
                     var4.a(var8.getAsInt());
                  }
               } catch (Exception var22) {
               }

               int var24 = 0;

               for (InitAdapter var10 : var4.k()) {
                  JsonElement var11 = var6.get(Integer.toString(var24++));
                  if (var11 == null) {
                     var11 = c(var6, var10);
                  }

                  if (var11 == null) {
                     if (var4 instanceof CoreZoneProcessor) {
                        try {
                           ((CoreZoneProcessor)var4).i(var10);
                        } catch (Exception var21) {
                        }
                     }
                  } else {
                     try {
                        if (var10 instanceof CheckerBridge var12) {
                           var12.a(var11.getAsBoolean());
                        } else if (var10 instanceof TimingEntry var13) {
                           var13.load(var11.getAsJsonPrimitive().isNumber(), var11.getAsString());
                        } else if (var10 instanceof BlockCalculator var14) {
                           var14.a(var11.getAsDouble());
                        } else if (var10 instanceof ItemDescriptor var15) {
                           var15.a(var11.getAsInt());
                           if (var15.i()) {
                              var4.a(var11.getAsInt());
                           }
                        } else if (var10 instanceof SlotEntry var16) {
                           String var18 = var11.getAsString();
                           if (var16.g().contains(var18)) {
                              var16.a(var18);
                           }
                        } else if (var10 instanceof TextEntry var17) {
                           var17.b(var11.getAsString());
                        }
                     } catch (Exception var20) {
                     }
                  }
               }

               try {
                  if (var7 != null && var7.isJsonPrimitive() && var7.getAsBoolean()) {
                     var4.a(true);
                  }
               } catch (Exception var19) {
               }
            }
         }
      }
   }

   public void c() {

      this.e("default");
   }

   public void e(String var1) {

      try {
         Files.createDirectories(this.am);
         Path var2 = this.am.resolve(var1 + ".json");
         Files.write(var2, aj(this.al.toJson(this.f())));
      } catch (Exception var3) {
      }
   }

   public JsonObject f() {

      JsonObject var1 = new JsonObject();
      JsonObject var2 = new JsonObject();
      var2.addProperty("c" + "lickGuiScale", SyncController.n);
      var2.addProperty("russianTh" + "eme", SyncController.m);
      var2.addProperty("redColor", SyncController.b);
      var2.addProperty("greenC" + "o" + "l" + "or", SyncController.c);
      var2.addProperty("bl" + "ueColor", SyncController.d);
      var2.addProperty("bgRed", SyncController.e);
      var2.addProperty("bgGreen", SyncController.f);
      var2.addProperty("bgBlue", SyncController.g);
      var2.addProperty("th" + "emeIn" + "dex", ThemeCache.o);
      var2.addProperty("themeAcc" + "en" + "tR", ThemeCache.p[0]);
      var2.addProperty("themeAc" + "ce" + "ntG", ThemeCache.p[1]);
      var2.addProperty("themeAccentB", ThemeCache.p[2]);
      var2.addProperty("themeBgR", ThemeCache.q[0]);
      var2.addProperty("themeBgG", ThemeCache.q[1]);
      var2.addProperty("themeBgB", ThemeCache.q[2]);
      var2.addProperty("back" + "groundDim", SyncController.q);
      var2.addProperty("tooltips", SyncController.r);
      var2.addProperty("editHudLayout", SyncController.s);
      var2.addProperty("gla" + "ssPan" + "els", SyncController.t);
      var2.addProperty("gui3d", SyncController.u);
      var2.addProperty("gui3dDof", SyncController.v);
      var2.addProperty("gui3dAm" + "bi" + "ence", SyncController.w);
      var2.addProperty("gui3" + "dReduceM" + "otion", SyncController.x);
      var2.addProperty("gu" + "i3dClose" + "O" + "nDamage", SyncController.y);
      var2.addProperty("guiScale", SyncController.a);
      var2.addProperty("no" + "ti" + "fySo" + "und", NoticeQueue.m);
      var2.addProperty("gla" + "ss" + "Fr" + "ost", SyncController.h);
      var2.addProperty("panelOpa" + "c" + "i" + "ty", SyncController.i);
      var2.addProperty("d" + "imAmount", SyncController.j);
      var2.addProperty("backgroundBlur", SyncController.k);
      var2.addProperty("f" + "allingPetals", SyncController.l);
      var2.addProperty("tooltipDe" + "l" + "ay", SyncController.p);
      var2.addProperty("t" + "yp" + "eToSearch", SyncController.z);
      var2.addProperty("rememberLayout", SyncController.aa);
      var2.addProperty("panelCounts", SyncController.ab);
      var2.addProperty("show" + "Ke" + "y" + "binds", SyncController.ac);
      var2.addProperty("m" + "o" + "duleOr" + "der", SyncController.ad);
      var2.addProperty("clickSounds", SyncController.ae);
      var2.addProperty("uiVolume", SyncController.af);
      var2.addProperty("gui3dD" + "i" + "st" + "ance", SyncController.ag);
      var2.addProperty("gui3dSh" + "a" + "pe", SyncController.ah);
      var2.addProperty("gui3dOpacity", SyncController.ai);

      try {
         CoreZoneProcessor var3 = ConfigBridge.c.c().a(CoreZoneProcessor.class);
         if (var3 != null) {
            var2.addProperty("guiKey", var3.p());
         }
      } catch (Exception var18) {
      }

      var1.add("gu" + "iS" + "etti" + "ngs", var2);
      SyncDispatcher var19 = ConfigBridge.c.c();

      for (BuilderFactory var5 : var19.a()) {
         JsonObject var6 = new JsonObject();
         var6.addProperty("enabled", var5.f());
         var6.addProperty(new String(new byte[]{107, 101, 121, 66, 105, 110, 100}), var5.j());
         int var7 = 0;

         for (InitAdapter var9 : var5.k()) {
            String var10 = Integer.toString(var7++);

            try {
               if (var9 instanceof CheckerBridge var11) {
                  var6.addProperty(var10, var11.f());
               } else if (var9 instanceof TimingEntry var12) {
                  var6.addProperty(var10, var12.save());
               } else if (var9 instanceof BlockCalculator var13) {
                  var6.addProperty(var10, var13.f());
               } else if (var9 instanceof ItemDescriptor var14) {
                  var6.addProperty(var10, var14.g());
               } else if (var9 instanceof SlotEntry var15) {
                  var6.addProperty(var10, var15.f());
               } else if (var9 instanceof TextEntry var16) {
                  var6.addProperty(var10, var16.f());
               }
            } catch (Exception var17) {
            }
         }

         var1.add(var5.getClass().getSimpleName(), var6);
      }

      return var1;
   }

   public String g() {

      try {
         return this.i(this.f());
      } catch (Throwable var2) {
         return null;
      }
   }

   public String h(String var1) {

      JsonObject var2 = this.j(var1);
      if (var2 == null) {
         return null;
      } else {
         try {
            return this.i(var2);
         } catch (Throwable var4) {
            return null;
         }
      }
   }

   private String i(JsonObject var1) throws IOException {

      byte[] var2 = this.al.toJson(var1).getBytes(StandardCharsets.UTF_8);
      ByteArrayOutputStream var3 = new ByteArrayOutputStream();

      try (GZIPOutputStream var4 = new GZIPOutputStream(var3)) {
         var4.write(var2);
      }

      return "DQC1:" + Base64.getUrlEncoder().withoutPadding().encodeToString(var3.toByteArray());
   }

   private JsonObject j(String var1) {

      return this.l(this.am.resolve(var1 + ".json"));
   }

   public JsonObject k(String var1) {

      return this.j(var1);
   }

   public JsonObject l(Path var1) {

      try {
         if (Files.isRegularFile(var1) && Files.size(var1) <= 4194304L) {
            byte[] var2 = Files.readAllBytes(var1);
            if (var2.length == 0) {
               return null;
            } else {
               boolean var3 = var2[0] == 123 || var2[0] == 32 || var2[0] == 10 || var2[0] == 13 || var2[0] == 9;
               String var4 = var3 ? new String(var2, StandardCharsets.UTF_8) : ak(var2);
               return (JsonObject)this.al.fromJson(var4, JsonObject.class);
            }
         } else {
            return null;
         }
      } catch (Exception var5) {
         return null;
      }
   }

   public byte[] m(JsonObject var1) {

      if (ConfigBridge.c == null || ConfigBridge.c.c() == null) {
         return null;
      } else if (var1 == null) {
         return null;
      } else {
         List var2 = ConfigBridge.c.c().a();
         byte[] var3 = new byte[var2.size()];

         for (int var4 = 0; var4 < var3.length; var4++) {
            BuilderFactory var5 = (BuilderFactory)var2.get(var4);
            int var6 = -1;
            JsonElement var7 = null;
            JsonElement var8 = null;

            try {
               var7 = var1.get(var5.getClass().getSimpleName());
               if (var7 == null || !var7.isJsonObject()) {
                  var7 = b(var1, var5);
               }

               if (var7 != null && var7.isJsonObject()) {
                  var8 = var7.getAsJsonObject().get("enabled");
                  if (var8 != null && var8.isJsonPrimitive()) {
                     var6 = var8.getAsBoolean() ? 1 : 0;
                  }
               }
            } catch (Exception var10) {
            }

            var3[var4] = (byte)var6;
         }

         return var3;
      }
   }

   public long n(String var1) {

      try {
         return Files.getLastModifiedTime(this.am.resolve(var1 + ".json")).toMillis();
      } catch (Exception var3) {
         return 0L;
      }
   }

   public boolean o(String var1) {

      JsonObject var2 = this.p(var1);
      if (var2 == null) {
         return false;
      } else {
         try {
            this.a(var2);
            this.c();
            return true;
         } catch (Throwable var4) {
            return false;
         }
      }
   }

   public JsonObject p(String var1) {

      try {
         if (var1 == null) {
            return null;
         } else {
            String var2 = var1.trim();
            if (var2.startsWith("DQC1:")) {
               var2 = var2.substring("DQC1:".length());
            }

            var2 = var2.replaceAll("\\s+", "");
            if (var2.isEmpty()) {
               return null;
            } else {
               byte[] var3;
               try {
                  var3 = Base64.getUrlDecoder().decode(var2);
               } catch (IllegalArgumentException var10) {
                  var3 = Base64.getDecoder().decode(var2.replace('-', '+').replace('_', '/'));
               }

               ByteArrayOutputStream var4 = new ByteArrayOutputStream();
               GZIPInputStream var5 = new GZIPInputStream(new ByteArrayInputStream(var3));

               Object var8;
               label76: {
                  try {
                     byte[] var6 = new byte[8192];

                     int var7;
                     while ((var7 = var5.read(var6)) > 0) {
                        var4.write(var6, 0, var7);
                        if ((long)var4.size() > 4194304L) {
                           var8 = null;
                           break label76;
                        }
                     }
                  } catch (Throwable var11) {
                     try {
                        var5.close();
                     } catch (Throwable var9) {
                        var11.addSuppressed(var9);
                     }

                     throw var11;
                  }

                  var5.close();
                  JsonObject var14 = (JsonObject)this.al.fromJson(var4.toString("UTF-8"), JsonObject.class);
                  if (var14 != null && var14.size() != 0) {
                     return var14;
                  }

                  return null;
               }

               var5.close();
               return (JsonObject)var8;
            }
         }
      } catch (Throwable var12) {
         return null;
      }
   }

   public void q(String var1) {

      try {
         Path var2 = this.am.resolve(var1 + ".json");
         if (!Files.isRegularFile(var2)) {
            return;
         }

         this.an = var2;
         this.a();
         this.an = this.am.resolve("default.json");
      } catch (Exception var3) {
      }
   }

   public List<String> r() {

      ArrayList var1 = new ArrayList();

      try {
         File var2 = this.am.toFile();
         if (var2.exists() && var2.isDirectory()) {
            File[] var3 = var2.listFiles();
            if (var3 != null) {
               for (File var7 : var3) {
                  if (var7.getName().endsWith(".json")) {
                     var1.add(var7.getName().replace(".json", ""));
                  }
               }
            }
         }
      } catch (Exception var8) {
      }

      return var1;
   }

   public Path s() {

      return this.am;
   }

   public String[] t() {

      ArrayList var1 = new ArrayList();
      String var2 = "";

      try {
         Path var3 = this.am.resolve("profiles" + ".meta");
         if (Files.isRegularFile(var3)) {
            for (String var5 : Files.readAllLines(var3, StandardCharsets.UTF_8)) {
               if (var5.length() >= 3 && var5.charAt(1) == '\t') {
                  String var6 = var5.substring(2);
                  if (var5.charAt(0) == 'u') {
                     var2 = var6;
                  } else if (var5.charAt(0) == 'p' && !var1.contains(var6)) {
                     var1.add(var6);
                  }
               }
            }
         }
      } catch (Exception var7) {
      }

      String[] var8 = new String[var1.size() + 1];
      var8[0] = var2;

      for (int var9 = 0; var9 < var1.size(); var9++) {
         var8[var9 + 1] = (String)var1.get(var9);
      }

      return var8;
   }

   public void u(String var1, List<String> var2) {

      try {
         Files.createDirectories(this.am);
         StringBuilder var3 = new StringBuilder();
         if (var1 != null && !var1.isEmpty()) {
            var3.append('u').append('\t').append(var1).append('\n');
         }

         if (var2 != null) {
            for (String var5 : var2) {
               if (var5 != null && !var5.isEmpty()) {
                  var3.append('p').append('\t').append(var5).append('\n');
               }
            }
         }

         Files.write(this.am.resolve("profiles" + ".m" + "e" + "ta"), var3.toString().getBytes(StandardCharsets.UTF_8));
      } catch (Exception var6) {
      }
   }

   public String v(String var1) {

      for (String var3 : this.r()) {
         if (var3.equalsIgnoreCase(var1)) {
            return var3;
         }
      }

      return null;
   }

   public String w(String var1) {

      List var2 = this.r();
      String var3 = var1;

      for (int var4 = 2; var4 < (-1493719394 ^ -1493728882); var4++) {
         boolean var5 = var3.equalsIgnoreCase("default");

         for (int var6 = 0; var6 < var2.size() && !var5; var6++) {
            var5 = ((String)var2.get(var6)).equalsIgnoreCase(var3);
         }

         if (!var5) {
            return var3;
         }

         var3 = var1 + " " + var4;
      }

      return var1 + " " + System.currentTimeMillis();
   }

   public int x(String var1, String var2) {

      try {
         Path var3 = this.am.resolve(var1 + ".json");
         if (!Files.isRegularFile(var3)) {
            return 2;
         } else if (var1.equals(var2)) {
            return 0;
         } else {
            String var4 = this.v(var2);
            if (var4 != null && !var4.equalsIgnoreCase(var1)) {
               return 1;
            } else {
               Path var5 = this.am.resolve(var2 + ".json");
               if (var1.equalsIgnoreCase(var2)) {
                  Path var6 = this.am.resolve(var1 + ".renaming");
                  Files.move(var3, var6);
                  Files.move(var6, var5);
               } else {
                  Files.move(var3, var5);
               }

               return 0;
            }
         }
      } catch (Exception var7) {
         return 3;
      }
   }

   public String y(String var1) {

      try {
         Path var2 = this.am.resolve(var1 + ".json");
         if (!Files.isRegularFile(var2)) {
            return null;
         } else {
            String var3 = this.w(var1 + " copy");
            Files.copy(var2, this.am.resolve(var3 + ".json"));
            return var3;
         }
      } catch (Exception var4) {
         return null;
      }
   }

   public Path z(String var1) {

      String var2 = this.h(var1);
      if (var2 == null) {
         return null;
      } else {
         try {
            Path var3 = this.am.resolve("exports");
            Files.createDirectories(var3);
            Path var4 = var3.resolve(var1 + ".txt");
            Files.write(var4, var2.getBytes(StandardCharsets.UTF_8));
            return var4;
         } catch (Exception var5) {
            return null;
         }
      }
   }

   public String aa(String var1) {

      try {
         Path var2 = this.am.resolve(var1 + ".json");
         if (!Files.isRegularFile(var2)) {
            return null;
         } else {
            Path var3 = this.am.resolve(".trash");
            Files.createDirectories(var3);
            Path var4 = var3.resolve(var1 + "." + System.currentTimeMillis() + ".json");
            Files.move(var2, var4, StandardCopyOption.REPLACE_EXISTING);
            this.ab(var3);
            return var4.toString();
         }
      } catch (Exception var5) {
         return null;
      }
   }

   private void ab(Path var1) {

      File[] var2 = var1.toFile().listFiles();
      if (var2 != null && var2.length > 20) {
         long[] var3 = new long[var2.length];

         for (int var4 = 0; var4 < var2.length; var4++) {
            var3[var4] = ac(var2[var4].getName());
         }

         long[] var11 = (long[])var3.clone();
         Arrays.sort(var11);
         long var5 = var11[var11.length - 20];
         int var7 = 0;

         for (int var8 = var2.length - 1; var8 >= 0; var8--) {
            if (var3[var8] <= var5 && (var3[var8] != var5 || var7 >= 20)) {
               try {
                  Files.deleteIfExists(var2[var8].toPath());
               } catch (Exception var10) {
               }
            } else {
               var7++;
            }
         }
      }
   }

   private static long ac(String var0) {

      int var1 = var0.lastIndexOf(46);
      int var2 = var1 > 0 ? var0.lastIndexOf(46, var1 - 1) : -1;
      if (var2 < 0) {
         return 0L;
      } else {
         try {
            return Long.parseLong(var0.substring(var2 + 1, var1));
         } catch (NumberFormatException var4) {
            return 0L;
         }
      }
   }

   public String ad(String var1, String var2) {

      try {
         Path var3 = Paths.get(var1).toAbsolutePath().normalize();
         Path var4 = this.am.resolve(".trash").toAbsolutePath().normalize();
         if (var3.startsWith(var4) && Files.isRegularFile(var3)) {
            String var5 = this.w(var2);
            Files.move(var3, this.am.resolve(var5 + ".json"));
            return var5;
         } else {
            return null;
         }
      } catch (Exception var6) {
         return null;
      }
   }

   public boolean ae(String var1, JsonObject var2) {

      try {
         Files.createDirectories(this.am);
         Files.write(this.am.resolve(var1 + ".json"), aj(this.al.toJson(var2)));
         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   public static boolean af(JsonObject var0) {

      if (var0 != null && var0.size() != 0) {
         if (var0.has("guiSettings") && var0.get("guiSet" + "tings").isJsonObject()) {
            return true;
         } else {
            for (Entry var2 : var0.entrySet()) {
               if (((JsonElement)var2.getValue()).isJsonObject() && ((JsonElement)var2.getValue()).getAsJsonObject().has("enabled")) {
                  return true;
               }
            }

            return false;
         }
      } else {
         return false;
      }
   }

   public String ag(Path var1) {

      Object var2 = null;

      try {
         if (var1 != null && Files.isRegularFile(var1) && Files.size(var1) <= 4194304L) {
            String var3 = String.valueOf(var1.getFileName());
            int var4 = var3.lastIndexOf(46);
            String var5 = var4 > 0 ? var3.substring(0, var4) : var3;
            String var6 = var4 > 0 ? var3.substring(var4 + 1).toLowerCase(Locale.ROOT) : "";
            if (var6.equals("json")) {
               var2 = this.l(var1);
            } else {
               var2 = this.p(new String(Files.readAllBytes(var1), StandardCharsets.UTF_8));
            }

            if (!af((JsonObject)var2)) {
               return null;
            } else {
               String var7 = this.w(ah(var5));
               return this.ae(var7, (JsonObject)var2) ? var7 : null;
            }
         } else {
            return null;
         }
      } catch (Exception var8) {
         return null;
      }
   }

   public static String ah(String var0) {

      StringBuilder var1 = new StringBuilder();
      String var2 = var0 == null ? "" : var0;

      for (int var3 = 0; var3 < var2.length() && var1.length() < 32; var3++) {
         char var4 = var2.charAt(var3);
         boolean var5 = var4 < ' '
            || var4 == 127
            || var4 == '<'
            || var4 == '>'
            || var4 == ':'
            || var4 == '"'
            || var4 == '/'
            || var4 == '\\'
            || var4 == '|'
            || var4 == '?'
            || var4 == '*';
         var1.append(var5 ? '-' : var4);
      }

      String var6 = var1.toString().trim();

      while (var6.endsWith(".")) {
         var6 = var6.substring(0, var6.length() - 1).trim();
      }

      while (var6.startsWith(".")) {
         var6 = var6.substring(1).trim();
      }

      if (var6.isEmpty()) {
         var6 = "config";
      }

      if (ai(var6) || var6.equalsIgnoreCase("default")) {
         var6 = var6 + " config";
      }

      return var6;
   }

   public static boolean ai(String var0) {

      String var1 = var0.trim().toLowerCase(Locale.ROOT);
      int var2 = var1.indexOf(46);
      if (var2 >= 0) {
         var1 = var1.substring(0, var2).trim();
      }

      return var1.length() == 3
         ? var1.equals("con") || var1.equals("prn") || var1.equals("aux") || var1.equals("nul")
         : var1.length() == 4 && (var1.startsWith("com") || var1.startsWith("lpt")) && var1.charAt(3) >= '1' && var1.charAt(3) <= '9';
   }

   private static byte[] aj(String var0) {

      byte[] var1 = var0.getBytes(StandardCharsets.UTF_8);

      for (int var2 = 0; var2 < var1.length; var2++) {
         var1[var2] = (byte)(var1[var2] ^ au[var2 % au.length] + var2 * 31);
      }

      return var1;
   }

   private static String ak(byte[] var0) {

      byte[] var1 = new byte[var0.length];

      for (int var2 = 0; var2 < var0.length; var2++) {
         var1[var2] = (byte)(var0[var2] ^ au[var2 % au.length] + var2 * 31);
      }

      return new String(var1, StandardCharsets.UTF_8);
   }
}
