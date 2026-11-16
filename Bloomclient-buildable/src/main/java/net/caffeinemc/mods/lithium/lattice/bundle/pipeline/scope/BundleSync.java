package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.NoticeQueue;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.SortableData;
import net.minecraft.client.MinecraftClient;

public final class BundleSync {
   public static volatile List<BundleSync.Entry> LIST = new ArrayList<>();
   public static volatile boolean ad = false;
   public static volatile String ae = "";
   public static volatile int af = 0;
   public static volatile int ag = 0;
   public static volatile String ah = "";
   private static final Object ai = new Object();
   private static String aj;
   private static Runnable ak;
   private static int al = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

   private BundleSync() {
   }

   private static String a() {
      return ConfigBridge.apiBase();
   }

   private static String b() {

      try {
         byte[] var0 = SortableData.c[0];
         return var0 == null ? "" : new String(var0, StandardCharsets.UTF_8);
      } catch (Throwable var1) {
         return "";
      }
   }

   private static void c(String var0, Runnable var1) {

      e(var0, var1, false);
   }

   private static void d(String var0, Runnable var1) {

      e(var0, var1, true);
   }

   private static void e(String var0, Runnable var1, boolean var2) {
   }

   private static void f(String var0, Runnable var1) {

      String var2 = var0;
      Runnable var3 = var1;

      while (var3 != null) {
         try {
            var3.run();
         } catch (Throwable var7) {
            NoticeQueue.err("Cloud " + "error", var7.getMessage() == null ? var2 + " failed" : var7.getMessage());
         }

         synchronized (ai) {
            var3 = ak;
            var2 = aj;
            ak = null;
            aj = null;
            if (var3 == null) {
               ad = false;
               ae = "";
            } else {
               ae = var2;
            }
         }
      }
   }

   private static JsonObject g(String var0, JsonObject var1) throws Exception {
      return null;
   }

   private static JsonObject h() {

      JsonObject var0 = new JsonObject();
      var0.addProperty("hwid", b());
      return var0;
   }

   private static String i(JsonObject var0) {

      return var0.has("error") && !var0.get("error").isJsonNull() ? var0.get("error").getAsString() : "Unknown " + "e" + "r" + "ror";
   }

   public static void j(boolean var0) {

      c("Loading", () -> {

         try {
            JsonObject var1 = g("/api/configs/list", h());
            if (!var1.has("ok") || !var1.get("ok").getAsBoolean()) {
               NoticeQueue.err("Cloud", i(var1));
               return;
            }

            List var2 = s(var1);
            LIST = var2;
            if (!var0) {
               NoticeQueue.ok("Cloud " + "synced", var2.size() + " config" + (var2.size() == 1 ? "" : "s") + " " + "availa" + "ble");
            }
         } catch (Exception var3) {
            NoticeQueue.err("Cloud unr" + "eac" + "h" + "able", "Could not " + "load th" + "e co" + "nfig library");
         }
      });
   }

   public static void k(String var0, boolean var1) {

      String var2 = var0 == null ? "" : var0.trim();
      if (var2.isEmpty()) {
         NoticeQueue.err("Name required", "Give the config a name first");
      } else {
         c("U" + "pload" + "i" + "ng", () -> {

            try {
               String var2x = ConfigBridge.c.d().g();
               if (var2x == null) {
                  NoticeQueue.err("Upload " + "failed", "Coul" + "d not serialise your con" + "f" + "ig");
                  return;
               }

               JsonObject var3 = h();
               var3.addProperty("name", var2);
               var3.addProperty("anonymous", var1);
               var3.addProperty("data", var2x);
               JsonObject var4 = g("/api/con" + "figs/save", var3);
               if (!var4.has("ok") || !var4.get("ok").getAsBoolean()) {
                  NoticeQueue.err("Upload failed", i(var4));
                  return;
               }

               boolean var5 = var4.has("updated") && var4.get("updated").getAsBoolean();
               NoticeQueue.ok(var5 ? "Confi" + "g upd" + "at" + "ed" : "Config " + "u" + "ploaded", var2 + (var1 ? " · A" + "nonym" + "ous" : ""));
               r();
            } catch (Exception var6) {
               NoticeQueue.err("Upload failed", "Could not reach the server");
            }
         });
      }
   }

   public static void l(String var0, String var1) {

      c("Down" + "l" + "oading", () -> {

         try {
            JsonObject var2 = h();
            var2.addProperty("id", var0);
            JsonObject var3 = g("/api/configs/get", var2);
            if (!var3.has("ok") || !var3.get("ok").getAsBoolean()) {
               NoticeQueue.err("D" + "ownloa" + "d failed", i(var3));
               return;
            }

            String var4 = var3.get("data").getAsString();
            MinecraftClient.getInstance().execute(() -> {
               byte var2x = 0;

               while (true) {
                  switch (var2x) {
                     case 0:
                     default:
                        if (al != 0) {
                           new Object().hashCode();
                           var2x = 2;
                           break;
                        }
                     case 2:
                        if (ConfigBridge.c.d().o(var4)) {
                           af++;
                           NoticeQueue.ok("Config loaded", var1);
                           var2x = 3;
                           break;
                        }
                     case 1:
                        NoticeQueue.err("I" + "nvalid co" + "nfig", "The downloaded data could not be read");
                        var2x = 3;
                        break;
                     case 3:
                        return;
                  }
               }
            });
         } catch (Exception var5) {
            NoticeQueue.err("Download f" + "ailed", "Could not reach the server");
         }
      });
   }

   public static void m(String var0, String var1) {

      c("Downloading", () -> {

         try {
            JsonObject var2 = h();
            var2.addProperty("id", var0);
            JsonObject var3 = g("/api/configs/g" + "et", var2);
            if (!var3.has("ok") || !var3.get("ok").getAsBoolean()) {
               NoticeQueue.err("Down" + "load f" + "ail" + "ed", i(var3));
               return;
            }

            String var4 = var3.get("data").getAsString();
            MinecraftClient.getInstance().execute(() -> {

               n(var4, var1);
            });
         } catch (Exception var5) {
            NoticeQueue.err("Download failed", "Could not reach the " + "se" + "r" + "ver");
         }
      });
   }

   private static void n(String var0, String var1) {

      LoaderBridge var2 = ConfigBridge.c.d();
      JsonObject var3 = var2.p(var0);
      if (!LoaderBridge.af(var3)) {
         NoticeQueue.err("Invalid c" + "onfig", "The downlo" + "aded data could not be" + " r" + "ead");
      } else {
         String var4 = var2.w(LoaderBridge.ah(var1));
         if (var2.ae(var4, var3)) {
            ah = var4;
            ag++;
            NoticeQueue.ok("Saved" + " " + "a co" + "py", var4);
         } else {
            NoticeQueue.err("Save" + " fai" + "l" + "ed", var4);
         }
      }
   }

   public static void o(String var0, String var1) {

      c("Deleting", () -> {

         try {
            JsonObject var2 = h();
            var2.addProperty("id", var0);
            JsonObject var3 = g("/api/conf" + "igs/delete", var2);
            if (!var3.has("ok") || !var3.get("ok").getAsBoolean()) {
               NoticeQueue.err("Delete f" + "a" + "i" + "led", i(var3));
               return;
            }

            NoticeQueue.ok("Deleted", var1);
            r();
         } catch (Exception var4) {
            NoticeQueue.err("Del" + "ete f" + "ail" + "ed", "C" + "ould not reac" + "h the se" + "rver");
         }
      });
   }

   public static void p(String var0, String var1) {

      String var2 = var1 == null ? "" : var1.trim();
      if (var2.isEmpty()) {
         NoticeQueue.err("Name required", "Type the n" + "ew name first");
      } else {
         d("Renaming", () -> {

            try {
               JsonObject var2x = h();
               var2x.addProperty("id", var0);
               var2x.addProperty("name", var2);
               JsonObject var3 = g("/api/configs/rename", var2x);
               if (!var3.has("ok") || !var3.get("ok").getAsBoolean()) {
                  NoticeQueue.err("Rename fail" + "ed", i(var3));
                  return;
               }

               NoticeQueue.ok("Renamed", var2);
               r();
            } catch (Exception var4) {
               NoticeQueue.err("Rename failed", "Could not reach the server");
            }
         });
      }
   }

   public static void q(String var0, boolean var1) {

      d("Updating", () -> {

         try {
            JsonObject var2 = h();
            var2.addProperty("id", var0);
            var2.addProperty("an" + "on" + "ym" + "ous", var1);
            JsonObject var3 = g("/api/configs/anon", var2);
            if (!var3.has("ok") || !var3.get("ok").getAsBoolean()) {
               NoticeQueue.err("Update failed", i(var3));
               return;
            }

            NoticeQueue.ok(var1 ? "Now ano" + "n" + "ym" + "ous" : "Name now" + " sh" + "o" + "wn", "Confi" + "g" + " " + "updated");
            r();
         } catch (Exception var4) {
            NoticeQueue.err("Update fa" + "iled", "Could not reach th" + "e s" + "er" + "ver");
         }
      });
   }

   private static void r() {

      try {
         JsonObject var0 = g("/api/configs/list", h());
         if (!var0.has("ok") || !var0.get("ok").getAsBoolean()) {
            return;
         }

         LIST = s(var0);
      } catch (Exception var1) {
      }
   }

   private static List<BundleSync.Entry> s(JsonObject var0) {

      ArrayList var1 = new ArrayList();

      for (JsonElement var4 : var0.getAsJsonArray("configs")) {
         JsonObject var5 = var4.getAsJsonObject();
         var1.add(
            new BundleSync.Entry(
               var5.get("id").getAsString(),
               var5.get("name").getAsString(),
               var5.has("author") && !var5.get("author").isJsonNull() ? var5.get("author").getAsString() : "Unknown",
               var5.has("mine") && var5.get("mine").getAsBoolean(),
               var5.has("verified") && var5.get("verified").getAsBoolean(),
               var5.has("updat" + "ed" + "At") && !var5.get("up" + "d" + "a" + "tedAt").isJsonNull() ? var5.get("upd" + "atedAt").getAsLong() : 0L,
               var5.has("dow" + "nlo" + "a" + "ds") && !var5.get("do" + "wn" + "loads").isJsonNull() ? var5.get("d" + "ownl" + "oa" + "ds").getAsInt() : 0
            )
         );
      }

      return var1;
   }

   public static final class Entry {
      public final String id;
      public final String a;
      public final String b;
      public final boolean c;
      public final boolean d;
      public final long e;
      public final int f;
      private static int g = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

      Entry(String var1, String var2, String var3, boolean var4, boolean var5, long var6, int var8) {
         this.id = var1;
         this.a = var2;
         this.b = var3;
         this.c = var4;
         this.d = var5;
         this.e = var6;
         this.f = var8;
      }
   }
}
