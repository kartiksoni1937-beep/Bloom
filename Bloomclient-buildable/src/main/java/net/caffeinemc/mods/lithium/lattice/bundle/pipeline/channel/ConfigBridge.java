package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.List;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.module.EventAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.element.LoaderDelegate;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.LoaderBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.SyncDispatcher;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.VerificationGuard;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.BlockGatherer;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.BuilderDelegate;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.CheckerFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.ItemHandler;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.PoolScheduler;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.SlotInspector;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.SyncController;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.BindingBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.SortableData;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.CoreZoneProcessor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.NoticeZoneCache;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;

public class ConfigBridge implements ClientModInitializer {
   public static final String a;
   public static final String b;
   public static ConfigBridge c;
   public static final MinecraftClient d;
   private EventAdapter u;
   private SyncDispatcher v;
   private LoaderBridge w;
   private BindingBridge x;
   private PoolScheduler y;
   private volatile boolean z = false;
   private volatile boolean aa = false;
   private volatile int ab = 0;
   private volatile long ac = 0L;
   private volatile boolean ad = false;
   private volatile int ae = 0;
   private volatile long af = 0L;
   private static final byte[] ag = new byte[]{122, 49, -60, 5, -98, 107, -46, 24, 79, -93, 32, -25, 17, -116, 83, -67};
   private static final byte[] ah = new byte[]{
      48,
      42,
      48,
      5,
      6,
      3,
      43,
      101,
      112,
      3,
      33,
      0,
      50,
      -22,
      23,
      -100,
      103,
      34,
      76,
      107,
      126,
      117,
      41,
      -113,
      -77,
      -42,
      -17,
      -37,
      10,
      -1,
      -50,
      104,
      88,
      -45,
      -68,
      -41,
      -119,
      -103,
      56,
      -81,
      29,
      85,
      17,
      -87
   };
   private static final boolean ai = true;
   private static final boolean aj = false;
   private static final boolean ak = false;
   private static volatile byte[] al;
   public static volatile String USER_NAME = "";
   private static volatile String am = "";
   public static volatile String USER_EXPIRES = "";
   public static volatile int USER_DAYS = -2;
   public static final int DAYS_LIFETIME = -1;
   public static final int DAYS_UNKNOWN = -2;
   private boolean[] an = new boolean[0];
   private boolean ao = false;
   private int ap = 0;
   private static String[] aq;
   private static final String[] ar;
   private static final String[] as;

   public void onInitializeClient() {

      CheckerFactory.b(0.0, 0.0);
      BuilderDelegate.a(0);
      net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.LoaderBridge.b();
      BlockGatherer.c();
      ItemHandler.c();
      e_r3();
      boolean var1 = true;

      try {
         var1 = VerificationGuard.a();
      } catch (Throwable var7) {
      }

      boolean var2 = var1 && this.h_r4();
      boolean var3 = var2 && q();
      boolean var4 = var1 && var2 && var3;
      this.z = var4;
      SortableData.d[0] = var4 ? 1 : 2;
      this.ab = var4 ? l() : 0;
      this.ac = var4 ? (long)l() ^ 2654435769L : 0L;
      this.ae = var4 ? this.p() : 0;
      SortableData.d[1] = this.ae;
      if (var4) {
         c = this;
         this.u = new EventAdapter();
         this.v = new SyncDispatcher();
         this.w = new LoaderBridge();
         this.x = new BindingBridge();
         this.y = new PoolScheduler();
         ClientTickEvents.END_CLIENT_TICK.register(this::r);
         this.w.a();
         ClientLifecycleEvents.CLIENT_STOPPING.register(this::a);
         this.b_r0();
      } else {
         try {
            byte[] var5 = SortableData.c[0];
            String var6 = am;
            System.out.println("[Bloom] Sign" + "-in failed: " + (var6 != null && !var6.isEmpty() ? var6 : "n" + "ot authorised"));
            if (var5 != null) {
               System.out.println("HWID: " + new String(var5, StandardCharsets.UTF_8));
               System.out.println("[Bloom] Set this HWID as your Bloom machine on the dashboard, then restart the game.");
            }
         } catch (Throwable var8) {
         }
      }
   }

   private void a(MinecraftClient var1) {

      try {
         this.w.c();
      } catch (Throwable var3) {
      }
   }

   private void b_r0() {

      Thread var1 = new Thread(() -> {

         int var1x = 0;

         while (!this.aa) {
            try {
               Thread.sleep(300000L);
            } catch (InterruptedException var5) {
               return;
            }

            if (this.aa) {
               return;
            }

            boolean var2;
            boolean var3;
            try {
               var2 = this.h_r4();
               var3 = this.ad;
            } catch (Throwable var6) {
               this.c_r1();
               continue;
            }

            if (var2) {
               var1x = 0;
               this.c_r1();
            } else if (var3) {
               if (++var1x >= 2) {
                  this.d_r2();
                  return;
               }

               this.c_r1();
            } else {
               var1x = 0;
               this.c_r1();
            }
         }
      }, "cfg-heartbeat");
      var1.setDaemon(true);
      var1.start();
   }

   private void c_r1() {

      if (!this.aa) {
         this.z = true;
         SortableData.d[0] = 1;
         this.ab = l();
         this.ac = (long)l() ^ 2654435769L;
         this.af = o();
         this.ae = this.p();
         SortableData.d[1] = this.ae;
      }
   }

   private void d_r2() {
   }

   private static void e_r3() {

      try {
         byte[] var0 = SortableData.c[0];
         if (var0 != null && var0.length == 64) {
            return;
         }

         String var1 = System.getProperty("user.name") + System.getProperty("os.name") + System.getProperty("os.arch");
         MessageDigest var2 = MessageDigest.getInstance("SHA-256");
         byte[] var3 = var2.digest(var1.getBytes(StandardCharsets.UTF_8));
         StringBuilder var4 = new StringBuilder(var3.length * 2);

         for (byte var8 : var3) {
            var4.append(Character.forDigit(var8 >> 4 & 15, 16)).append(Character.forDigit(var8 & 15, 16));
         }

         SortableData.c[0] = var4.toString().getBytes(StandardCharsets.UTF_8);
      } catch (Throwable var9) {
      }
   }

   private static String f(int var0, String var1) {
      return null;
   }

   private static void g(String var0) {
   }

   public static String apiBase() {
      return "";
   }

   private boolean h_r4() {
      e_r3();
      this.ad = true;
      am = "";
      USER_NAME = "Anonymous";
      USER_EXPIRES = "lifetime";
      USER_DAYS = 648;
      SortableData.d[0] = 1;
      this.af = o();
      return true;
   }

   private static String i() {
      return null;
   }

   private static boolean j(String var0, String var1, String var2) {
      return false;
   }

   private static Object[] k(String var0, String var1) throws Exception {
      return null;
   }

   public boolean a() {
      return true;
   }

   public void Z9() {

      this.aa = true;
   }

   public EventAdapter b() {

      return !this.aa && this.z && SortableData.d[0] == 1 && this.ab == l() ? this.u : null;
   }

   private static int l() {

      byte[] var0 = SortableData.c[0];
      if (var0 != null && var0.length != 0) {
         int var1 = -2121201808 ^ 9280181;

         for (byte var5 : var0) {
            var1 ^= var5 & (-1348451392 ^ -1348451521);
            var1 *= -511587141 ^ -528364248;
         }

         return var1 == 0 ? 1 : var1;
      } else {
         return 0;
      }
   }

   private static byte[] m() {
      return ag;
   }

   private static int n() {

      int var0 = 378823115 ^ -1752630258;

      for (byte var4 : m()) {
         var0 ^= var4 & (1353352744 ^ 1353352919);
         var0 *= 677406780 ^ 694184367;
      }

      return var0;
   }

   private static long o() {

      long var0 = -3750763034362895579L;

      for (byte var5 : m()) {
         var0 ^= (long)(var5 & (1651232030 ^ 1651232225));
         var0 *= 1099511628211L;
      }

      return var0;
   }

   private int p() {

      long var1 = this.af ^ o();
      int var3 = (int)var1 ^ (int)(var1 >>> 32);
      return n() ^ var3;
   }

   private static boolean q() {
      return true;
   }

   public SyncDispatcher c() {

      return this.v;
   }

   public LoaderBridge d() {

      return this.w;
   }

   public BindingBridge e() {

      return this.x;
   }

   private void r(MinecraftClient var1) {

      if (!this.aa && this.z && SortableData.d[0] == 1 && this.ab == l()) {
         String[] var2 = h();
         int var3 = this.z ? 1 : 0;
         if (var2 == null) {
            if (!this.z || this.aa) {
               return;
            }

            this.ap++;
            var3 = this.ap % (252660020 ^ 252660588);
         }

         label182:
         if (var2 == null) {
            if (var3 == 0) {
               var3 = SortableData.d[0];
               if (var2 != null) {
                  break label182;
               }

               if (var3 == 2) {
                  this.z = false;
                  return;
               }
            }

            var3 = SyncController.o ? 1 : 0;
         }

         if (var3 == 0) {
            label222: {
               CoreZoneProcessor var4 = CoreZoneProcessor.I;
               CoreZoneProcessor var5 = var4;
               if (var2 == null) {
                  if (var4 == null) {
                     break label222;
                  }

                  var5 = var4;
               }

               int var6 = var5.q().d;
               var3 = var6;
               if (var2 == null) {
                  if (var6 == -1) {
                     break label222;
                  }

                  var3 = SlotInspector.a(var6) ? 1 : 0;
               }

               label168: {
                  var3 = var3;
                  if (var2 == null) {
                     if (var3 == 0 || var2 != null) {
                        break label168;
                     }

                     var3 = this.ao ? 1 : 0;
                  }

                  label163:
                  if (var3 == 0) {
                     Screen var8 = var1.currentScreen;
                     if (var2 == null) {
                        if (!(var1.currentScreen instanceof LoaderDelegate)) {
                           var1.setScreen(new LoaderDelegate());
                           if (var2 == null) {
                              break label163;
                           }
                        }

                        var8 = var1.currentScreen;
                     }

                     Screen var10 = var8;
                     if (var2 == null) {
                        if (!(var8 instanceof LoaderDelegate)) {
                           break label163;
                        }

                        var10 = var8;
                     }

                     LoaderDelegate var11 = (LoaderDelegate)var10;
                     var11.i();
                  }
               }

               this.ao = var3 != 0;
            }

            if (var1.currentScreen == null) {
               List var17 = this.v.a();
               boolean[] var18 = this.an;
               if (var18.length != var17.size()) {
                  var18 = new boolean[var17.size()];
                  this.an = var18;
               }

               for (int var19 = 0; var19 < var17.size(); var19++) {
                  label211: {
                     BuilderFactory var20 = (BuilderFactory)var17.get(var19);
                     int var21 = var20.i.d;
                     var3 = var21;
                     if (var2 == null) {
                        if (var21 == -1) {
                           var18[var19] = false;
                           break label211;
                        }

                        var3 = SlotInspector.a(var21) ? 1 : 0;
                     }

                     label131: {
                        boolean var22 = var18[var19];
                        var3 = var3;
                        if (var2 == null) {
                           if (var3 == 0) {
                              break label131;
                           }

                           var3 = var22 ? 1 : 0;
                        }

                        if (var3 == 0) {
                           var20.e();

                           try {
                              NoticeZoneCache.d(var20, var20.f);
                           } catch (Throwable var12) {
                           }
                        }
                     }

                     var18[var19] = var3 != 0;
                  }

                  if (var2 != null) {
                     break;
                  }
               }
            }
         }
      }
   }

   public static void b(String[] var0) {

      aq = var0;
   }

   public static String[] h() {
      return aq;
   }

   private static String s(int var0, int var1) {

      int var2 = (var0 ^ -1423468247 ^ -1423447464) & (-1154038382 ^ -1154074003);
      if (as[var2] == null) {
         char[] var3 = ar[var2].toCharArray();

         int var4 = switch (var3[0] & (-1955925284 ^ -1955925469)) {
            case 0 -> 50;
            case 1 -> 86;
            case 2 -> 1287933380 ^ 1287933293;
            case 3 -> -163728493 ^ -163728593;
            case 4 -> 90;
            case 5 -> -1083336033 ^ -1083336077;
            case 6 -> 38;
            case 7 -> -2005451043 ^ -2005451191;
            case 8 -> -2000726792 ^ -2000726930;
            case 9 -> 64137572 ^ 64137696;
            case 10 -> 98;
            case 11 -> 96;
            case 12 -> 8;
            case 13 -> 1223568145 ^ 1223568344;
            case 14 -> 107;
            case 15 -> 52;
            case 16 -> -1585111295 ^ -1585111112;
            case 17 -> 124;
            case 18 -> 70;
            case 19 -> 46;
            case 20 -> -677499754 ^ -677499796;
            case 21 -> -1249991448 ^ -1249991606;
            case 22 -> 1178723543 ^ 1178723360;
            case 23 -> 14;
            case 24 -> -1261341623 ^ -1261341492;
            case 25 -> -1295835370 ^ -1295835191;
            case 26 -> 43;
            case 27 -> 114;
            case 28 -> 12;
            case 29 -> -1917848366 ^ -1917848531;
            case 30 -> 51;
            case 31 -> 1536337036 ^ 1536336909;
            case 32 -> 933284951 ^ 933285014;
            case 33 -> 49;
            case 34 -> 523275571 ^ 523275667;
            case 35 -> 47938237 ^ 47938082;
            case 36 -> -1877376747 ^ -1877376628;
            case 37 -> 36;
            case 38 -> -516639687 ^ -516639502;
            case 39 -> 781263095 ^ 781262860;
            case 40 -> -1968803027 ^ -1968802869;
            case 41 -> 10;
            case 42 -> -836875450 ^ -836875311;
            case 43 -> -998288112 ^ -998287913;
            case 44 -> 23;
            case 45 -> 29;
            case 46 -> 1471047636 ^ 1471047526;
            case 47 -> 31;
            case 48 -> 2015525332 ^ 2015525194;
            case 49 -> -1490506432 ^ -1490506304;
            case 50 -> 117;
            case 51 -> 82;
            case 52 -> 13;
            case 53 -> 1;
            case 54 -> 1780804933 ^ 1780805104;
            case 55 -> 258989173 ^ 258989262;
            case 56 -> 2093440347 ^ 2093440502;
            case 57 -> 73;
            case 58 -> 116;
            case 59 -> -63532525 ^ -63532402;
            case 60 -> 1296041096 ^ 1296041068;
            case 61 -> 121;
            case 62 -> 88;
            case 63 -> -191327972 ^ -191327829;
            case 64 -> 75;
            case 65 -> 67;
            case 66 -> 101;
            case 67 -> 1046341783 ^ 1046341708;
            case 68 -> -522080213 ^ -522080088;
            case 69 -> 18;
            case 70 -> 257320135 ^ 257319953;
            case 71 -> -686157907 ^ -686158041;
            case 72 -> 1875482081 ^ 1875481891;
            case 73 -> 61;
            case 74 -> 2056805961 ^ 2056806099;
            case 75 -> 100;
            case 76 -> 1211773767 ^ 1211773847;
            case 77 -> 122;
            case 78 -> 95;
            case 79 -> 85;
            case 80 -> -1137235611 ^ -1137235475;
            case 81 -> 41;
            case 82 -> 248437489 ^ 248437283;
            case 83 -> 1219237719 ^ 1219237780;
            case 84 -> 45;
            case 85 -> 376684468 ^ 376684339;
            case 86 -> 7;
            case 87 -> 15;
            case 88 -> -1827025252 ^ -1827025356;
            case 89 -> 1758894983 ^ 1758894967;
            case 90 -> 1631211120 ^ 1631211217;
            case 91 -> 1770375048 ^ 1770375025;
            case 92 -> 92;
            case 93 -> 84;
            case 94 -> -1238694136 ^ -1238693892;
            case 95 -> -611923925 ^ -611923775;
            case 96 -> 32;
            case 97 -> 57;
            case 98 -> -669352623 ^ -669352520;
            case 99 -> 9;
            case 100 -> 72;
            case 101 -> 1646750116 ^ 1646750022;
            case 102 -> 883739467 ^ 883739544;
            case 103 -> 125;
            case 104 -> -1491905043 ^ -1491905202;
            case 105 -> 34;
            case 106 -> -230258614 ^ -230258465;
            case 107 -> 42;
            case 108 -> 63;
            case 109 -> 1655436189 ^ 1655436133;
            case 110 -> 62;
            case 111 -> 58;
            case 112 -> -1710669084 ^ -1710669205;
            case 113 -> -961937585 ^ -961937526;
            case 114 -> 60;
            case 115 -> 112;
            case 116 -> -1746869233 ^ -1746869077;
            case 117 -> 1686256743 ^ 1686256849;
            case 118 -> 103;
            case 119 -> -448553160 ^ -448552970;
            case 120 -> -2104583325 ^ -2104583242;
            case 121 -> -347202713 ^ -347202570;
            case 122 -> 115;
            case 123 -> 127;
            case 124 -> -1808117717 ^ -1808117581;
            case 125 -> 77;
            case 126 -> 1328726964 ^ 1328726801;
            case 127 -> 69;
            case 128 -> 99;
            case 129 -> 119;
            case 130 -> 35;
            case 131 -> 64;
            case 132 -> 648336640 ^ 648336855;
            case 133 -> 93;
            case 134 -> 722312232 ^ 722312428;
            case 135 -> 30;
            case 136 -> 91;
            case 137 -> -585530482 ^ -585530515;
            case 138 -> 94;
            case 139 -> 102;
            case 140 -> 108;
            case 141 -> 59;
            case 142 -> -1980880969 ^ -1980881032;
            case 143 -> 41918043 ^ 41918193;
            case 144 -> 1482158234 ^ 1482158133;
            case 145 -> 80;
            case 146 -> 28;
            case 147 -> 221398034 ^ 221398254;
            case 148 -> 1129966424 ^ 1129966473;
            case 149 -> 350075384 ^ 350075253;
            case 150 -> 2;
            case 151 -> 126;
            case 152 -> 37;
            case 153 -> 877051558 ^ 877051480;
            case 154 -> 1148601557 ^ 1148601415;
            case 155 -> -532222317 ^ -532222389;
            case 156 -> -1224861624 ^ -1224861449;
            case 157 -> 1387087795 ^ 1387087710;
            case 158 -> -108087080 ^ -108087170;
            case 159 -> 56;
            case 160 -> -647476964 ^ -647476814;
            case 161 -> 1806567919 ^ 1806567715;
            case 162 -> 79;
            case 163 -> 2064527480 ^ 2064527541;
            case 164 -> 21;
            case 165 -> -1615863212 ^ -1615863134;
            case 166 -> 33;
            case 167 -> 27;
            case 168 -> -1615876672 ^ -1615876832;
            case 169 -> -39956621 ^ -39956495;
            case 170 -> -1350185571 ^ -1350185641;
            case 171 -> -832954939 ^ -832955105;
            case 172 -> 113;
            case 173 -> 65;
            case 174 -> 11;
            case 175 -> 55;
            case 176 -> -155820810 ^ -155821009;
            case 177 -> 44;
            case 178 -> 665567111 ^ 665566999;
            case 179 -> 74;
            case 180 -> -1253161729 ^ -1253161941;
            case 181 -> 26;
            case 182 -> 944508066 ^ 944507987;
            case 183 -> 105;
            case 184 -> 106;
            case 185 -> 22;
            case 186 -> -772745955 ^ -772745811;
            case 187 -> -1684346781 ^ -1684346689;
            case 188 -> 1156921389 ^ 1156921515;
            case 189 -> 386843864 ^ 386843744;
            case 190 -> 118;
            case 191 -> 104;
            case 192 -> 109;
            case 193 -> -1060673959 ^ -1060673817;
            case 194 -> 5;
            case 195 -> -678564876 ^ -678564998;
            case 196 -> 1605425514 ^ 1605425606;
            case 197 -> 87;
            case 198 -> 1572731108 ^ 1572730947;
            case 199 -> 16;
            case 200 -> 17;
            case 201 -> 646852510 ^ 646852394;
            case 202 -> 54;
            case 203 -> -2089383501 ^ -2089383565;
            case 204 -> 364673985 ^ 364673799;
            case 205 -> -985954610 ^ -985954779;
            case 206 -> -235186322 ^ -235186298;
            case 207 -> 624295508 ^ 624295655;
            case 208 -> 495131464 ^ 495131637;
            case 209 -> -417401854 ^ -417401615;
            case 210 -> 24;
            case 211 -> 1549959750 ^ 1549959893;
            case 212 -> 89;
            case 213 -> -1354806456 ^ -1354806316;
            case 214 -> 97;
            case 215 -> 1725989158 ^ 1725989309;
            case 216 -> 1218885595 ^ 1218885414;
            case 217 -> -941049572 ^ -941049349;
            case 218 -> 39;
            case 219 -> 111;
            case 220 -> -1985485807 ^ -1985485584;
            case 221 -> 76;
            case 222 -> 47;
            case 223 -> -1356347513 ^ -1356347634;
            case 224 -> 4;
            case 225 -> 40;
            case 226 -> 25;
            case 227 -> -1527101951 ^ -1527101714;
            case 228 -> 68;
            case 229 -> 3;
            case 230 -> -44803873 ^ -44803986;
            case 231 -> 870186753 ^ 870186972;
            case 232 -> 2083030728 ^ 2083030596;
            case 233 -> 53;
            case 234 -> 81;
            case 235 -> -2090242138 ^ -2090242194;
            case 236 -> 1917893670 ^ 1917893880;
            case 237 -> 0;
            case 238 -> 19;
            case 239 -> -319099273 ^ -319099239;
            case 240 -> 110;
            case 241 -> 123;
            case 242 -> -1403387581 ^ -1403387448;
            case 243 -> 48;
            case 244 -> 20;
            case 245 -> 120;
            case 246 -> 1413896108 ^ 1413896030;
            case 247 -> -1875525119 ^ -1875524933;
            case 248 -> 71;
            case 249 -> 354107086 ^ 354106939;
            case 250 -> 66;
            case 251 -> 78;
            case 252 -> 2061889054 ^ 2061889205;
            case 253 -> -490921927 ^ -490921764;
            case 254 -> 6;
            default -> 83;
         };
         int var5 = (var1 & (366954121 ^ 366954102)) - var4;
         if (var5 < 0) {
            var5 += 256;
         }

         int var6 = ((var1 & (1250784036 ^ 1250790619)) >>> 8) - var4;
         if (var6 < 0) {
            var6 += 256;
         }

         for (int var7 = 0; var7 < var3.length; var7++) {
            int var8 = var7 % 2;
            char var9 = var3[var7];
            if (var8 == 0) {
               var3[var7] = (char)(var9 ^ var5);
               var5 = ((var5 >>> 3 | var5 << 5) ^ var3[var7]) & (-708655808 ^ -708655681);
            } else {
               var3[var7] = (char)(var9 ^ var6);
               var6 = ((var6 >>> 3 | var6 << 5) ^ var3[var7]) & (-320523646 ^ -320523651);
            }
         }

         as[var2] = new String(var3).intern();
      }

      return as[var2];
   }

   static {
      String[] var0 = new String[3];
      int var1 = 0;
      b(null);
      String var2 = "\u009d\u0092Öm¡:\u0011Ãæûª" + "B5Üw\n\u0000\u0081i" + "pd}\rx" + "\u0003ôû;";
      int var3 = ("\u009d\u0092Öm¡:\u0011ÃæûªB5Üw\n\u0000\u0081ipd}\r" + "x\u0003ôû;").length();
      char var4 = 6;
      int var5 = -1;

      labelCLINIT: while (true) {
         char[] var6;
         label38: {
            char[] var7 = var2.substring(++var5, var5 + var4).toCharArray();
            int var8 = var7.length;
            int var9 = 0;
            byte var10 = 123;
            var6 = var7;
            int var11 = var8;
            byte var12;
            char[] var13;
            int var14;
            if (var8 <= 1) {
               var13 = var7;
               var12 = 123;
               var14 = var9;
            } else {
               var10 = 123;
               var11 = var8;
               if (var8 <= var9) {
                  break label38;
               }

               var13 = var7;
               var12 = 123;
               var14 = var9;
            }

            while (true) {
               var13[var14] = (char)(var13[var14] ^ var12 ^ switch (var9 % 7) {
                  case 0 -> 67;
                  case 1 -> 85;
                  case 2 -> 17;
                  case 3 -> 120;
                  case 4 -> 23;
                  case 5 -> 96;
                  default -> 39;
               });
               var9++;
               if (var10 == 0) {
                  var14 = var10;
                  var13 = var6;
                  var12 = var10;
               } else {
                  if (var11 <= var9) {
                     break;
                  }

                  var13 = var6;
                  var12 = var10;
                  var14 = var9;
               }
            }
         }

         String var16 = new String(var6).intern();
         byte var17 = -1;
         var0[var1++] = var16;
         if ((var5 += var4) >= var3) {
            ar = var0;
            as = new String[3];
            a = s(29555, 32384);
            b = s(29552, -1029);
            d = MinecraftClient.getInstance();
            break labelCLINIT;
         }

         var4 = var2.charAt(var5);
      }
   }
}
