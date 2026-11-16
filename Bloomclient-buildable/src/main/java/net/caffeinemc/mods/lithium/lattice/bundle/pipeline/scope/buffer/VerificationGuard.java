package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer;

import java.lang.management.ManagementFactory;

public final class VerificationGuard {
   private static final String[] f = new String[]{
      "recaf",
      "by" + "tec" + "odeviewer",
      "byte" + "code-viewer",
      "byteman",
      "javassist." + "ag" + "e" + "nt",
      "helios",
      "jd-gui",
      "cfr",
      "procyon",
      "f" + "ernflo" + "wer",
      "vineflower",
      "krakatau",
      "jadx"
   };

   private VerificationGuard() {
   }

   public static boolean a() {
      return true;
   }

   private static boolean d() {

      try {
         for (String var2 : ManagementFactory.getRuntimeMXBean().getInputArguments()) {
            String var3 = var2.toLowerCase();

            for (String var7 : f) {
               if (var3.contains(var7)) {
                  return false;
               }
            }
         }
      } catch (Exception var8) {
      }

      return true;
   }

   private static boolean e() {

      try {
         for (String var2 : ManagementFactory.getRuntimeMXBean().getInputArguments()) {
            String var3 = var2.toLowerCase();
            if (var3.contains("jdwp") || var3.contains("suspend=") || var3.contains("transp" + "ort=dt_socket")) {
               return false;
            }
         }
      } catch (Exception var5) {
      }

      try {
         String var6 = System.getProperty("c" + "om." + "sun.management.j" + "mxremote");
      } catch (Exception var4) {
      }

      return true;
   }
}
