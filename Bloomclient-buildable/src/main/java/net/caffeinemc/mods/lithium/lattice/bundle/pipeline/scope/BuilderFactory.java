package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.module.EventAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.ItemDescriptor;
import net.minecraft.client.MinecraftClient;

public abstract class BuilderFactory {
   protected static final MinecraftClient a = MinecraftClient.getInstance();
   protected final EventAdapter b;
   public char[] c;
   public int cK;
   public char[] d;
   public int dK;
   private final ParserEngine g;
   public boolean f;
   private final List<InitAdapter> k;
   public final ItemDescriptor i;
   private static int l;
   private static final String m = "Keybind";
   private static final Random n = new Random();

   public BuilderFactory(String var1, String var2, ParserEngine var3) {
      int var4 = n();
      this.f = false;
      this.k = new ArrayList<>();
      this.cK = n.nextInt();
      this.c = a(var1, this.cK);
      this.dK = n.nextInt();
      this.d = a(var2, this.dK);
      this.g = var3;
      this.b = ConfigBridge.c.b();
      this.i = new ItemDescriptor(m, -1, true);
      this.k.add(this.i);
      if (InitAdapter.e() == 0) {
         b(++var4);
      }
   }

   public void c() {
   }

   public void d() {
   }

   public void e() {

      this.a(!this.f);
   }

   public void a(boolean var1) {

      BuilderFactory var2;
      label31: {
         int var3 = n();
         boolean var4 = this.f;
         if (var3 != 0) {
            if (this.f == var1) {
               return;
            }

            var2 = this;
            if (var3 == 0) {
               break label31;
            }

            this.f = var1;
            var4 = var1;
         }

         if (var4) {
            this.c();
            if (var3 != 0) {
               return;
            }
         }

         var2 = this;
      }

      var2.d();
   }

   public boolean f() {

      return this.f;
   }

   public String g() {

      char[] var1 = new char[this.c.length];

      for (int var2 = 0; var2 < var1.length; var2++) {
         var1[var2] = (char)(this.c[var2] ^ this.cK + var2 * 31);
      }

      return new String(var1);
   }

   public void setName(char[] var1, int var2, char[] var3, int var4) {

      this.c = var1;
      this.cK = var2;
      this.d = var3;
      this.dK = var4;
   }

   public String h() {

      char[] var1 = new char[this.d.length];

      for (int var2 = 0; var2 < var1.length; var2++) {
         var1[var2] = (char)(this.d[var2] ^ this.dK + var2 * 31);
      }

      return new String(var1);
   }

   public ParserEngine i() {

      return this.g;
   }

   public int j() {

      return this.i.g();
   }

   public void a(int var1) {

      this.i.a(var1);
   }

   public List<InitAdapter> k() {

      return this.k;
   }

   public void a(InitAdapter... var1) {

      InitAdapter[] var2 = var1;
      int var3 = n();
      int var4 = var1.length;
      int var5 = var3;
      int var6 = 0;

      while (var6 < var4) {
         InitAdapter var7 = var2[var6];
         this.k.add(var7);
         var6++;
         if (var5 == 0) {
            break;
         }
      }
   }

   public ItemDescriptor l() {

      return this.i;
   }

   private static char[] a(String var0, int var1) {

      if (var0 == null) {
         var0 = "";
      }

      char[] var2 = var0.toCharArray();
      char[] var3 = new char[var2.length];

      for (int var4 = 0; var4 < var2.length; var4++) {
         var3[var4] = (char)(var2[var4] ^ var1 + var4 * 31);
      }

      return var3;
   }

   public static void b(int var0) {

      l = var0;
   }

   public static int m() {
      return l;
   }

   public static int n() {

      int var0 = m();
      return var0 == 0 ? 18 : 0;
   }

   static {
      b(0);
   }
}
