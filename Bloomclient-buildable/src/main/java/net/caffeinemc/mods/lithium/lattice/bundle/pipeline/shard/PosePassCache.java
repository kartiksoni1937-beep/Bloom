package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.CheckerBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.NodeZoneRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.SpecialGuiElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.SpecialGuiElementRegistry.Context;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.item.ItemModelManager;
import net.minecraft.client.gui.render.SpecialGuiElementRenderer;
import net.minecraft.client.render.command.RenderDispatcher;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Arm;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.EntityPose;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.client.render.entity.EntityRenderManager;
import org.joml.Matrix3f;
import org.joml.Matrix3x2fStack;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import net.minecraft.client.render.VertexConsumerProvider;import net.minecraft.entity.Entity;import net.minecraft.client.render.entity.model.BipedEntityModel;import net.minecraft.client.render.DiffuseLighting;
public final class PosePassCache extends SpecialGuiElementRenderer<PoseStateCache> {
   private static final String[] s = new String[]{"l" + "ithi" + "um_preview"};
   private static final float t = (float) (Math.PI / 180.0);
   private static final float u = (float) Math.PI;
   private static final float v = 8.0F;
   private static final float w = 0.18F;
   private static final float x = 0.22F;
   private static final long y = 250000000L;
   private static final long z = 1500000000L;
   private static final float aa = 12.0F;
   private static final float ab = 25.0F;
   private static final float ac = 2.5F;
   private static final float ad = 180.0F;
   private static final float ae = 4.5F;
   private static final float af = 900.0F;
   private static final int ag = 20;
   private static final float ah = 0.55F;
   private static final float ai = 0.45F;
   private static final float aj = 0.004F;
   private static final float ak = 0.8F;
   private static final float al = 2.6F;
   private static final float am = 0.045F;
   private static final float an = 0.002F;
   private static final float ao = 0.6F;
   private static final int ap = 40;
   private static final int aq = 72;
   private static final int ar = 12898022;
   private static final float as = 1.9F;
   private static final float at = 0.35F;
   private static final float au = 0.55F;
   private static final float av = 0.42F;
   private static final float aw = 1.5F;
   private static final float ax = 0.25F;
   private static final float ay = 0.3F;
   private static final float az = 4.3F;
   private static final float ba = 0.45F;
   private static final float bb = 0.8F;
   private static final float bc = 17.2F;
   private static final float bd = 0.86F;
   private static final float be = 943.138F;
   private static final float bf = 0.13F;
   private static final float bg = 1.25F;
   private static final int bh = 8;
   private static final int bi = 36;
   private static final float bj = 0.02F;
   private static final float bk = 0.22F;
   private static final float bl = 0.09F;
   private static final float[] bm = new float[37];
   private static final float[] bn = new float[37];
   private static final int bo = 64;
   private static final int bp = 128;
   private static final int[] bq = new int[]{1, 7, 8, 9, 10, 11, 6, 12};
   private static final int[] br = new int[]{32, 1, 2, 4, 8, 16, 64, 128};
   private static final float[] bs = new float[]{0.7F, 0.95F, 1.45F, 0.9F, 1.05F, 1.2F, 1.15F, 1.15F};
   private static final float[] bt = new float[]{28.0F, 10.0F, 16.0F, 20.0F, 8.0F, 6.0F, 14.0F, 12.0F};
   private static final float[] bu = new float[]{4.8F, 4.0F, 2.4F, 5.0F, 3.4F, 5.6F, 5.6F, 5.2F};
   private static final float[] bv = new float[]{3.0F, 3.0F, 1.8F, 3.0F, 2.6F, 3.6F, 3.4F, 3.6F};
   private static final float[] bw = new float[]{35.0F, 25.0F, 30.0F, 125.0F, 20.0F, 15.0F, 75.0F, 30.0F};
   private static final float bx = 1.5F;
   private static final float by = 0.9F;
   private static final float bz = 1.1F;
   private static final float ca = 3.0F;
   private static final float cb = 0.25F;
   private static final float cc = 1.2F;
   private static final float cd = 2.6F;
   private static final float ce = 0.18F;
   private static final float cf = 0.25F;
   private static final float cg = 0.3F;
   private static final float ch = 0.18F;
   private static final float ci = 0.22F;
   private static final float cj = 0.0F;
   private static final float ck = 1.52F;
   private static final float cl = 1.2F;
   private static final float cm = 0.1F;
   private static final float cn = -1.9F;
   private static final float co = 1.15F;
   private static final float cp = 2.9F;
   private static final float cq = 3.1F;
   private static final float cr = -3.4F;
   private static final float cs = -0.7F;
   private static final float ct = 0.4F;
   private static final float cu = 0.8F;
   private static final int cv = 24;
   private static final int cw = 2062952;
   private static final int cx = 12120804;
   private static final int cy = 11819760;
   private static final float cz = 0.7F;
   private static final float da = 0.45F;
   private static final float db = 0.2F;
   private static final float dc = 1.0F;
   private static final float dd = 0.25F;
   public static volatile boolean dead;
   private static boolean de;
   private static int df;
   private static int dg;
   private static int dh;
   private static int di;
   public static final PoseStateCache POPUP;
   public static final PoseStateCache INSPECT;
   private static boolean dj;
   private static int dk;
   private static long dl;
   private static double dm;
   private static float dn;
   private static float _kwren_do;
   private static float dp;
   private static int dq;
   public static float yawDrag;
   private static long dr;
   private static float ds;
   private static float dt;
   private static float du;
   private static float dv;
   private static float dw;
   private static float dx;
   private static boolean dy;
   private static boolean dz;
   private static boolean ea;
   private static int eb;
   private static final float[] ec;
   private static final double[] ed;
   private static final double[] ee;
   private static final double[] ef;
   private static final float[] eg;
   private static final float[] eh;
   private static final float[] ei;
   private static float ej;
   private static float ek;
   private static float el;
   private static float em;
   private static final float[] en;
   private static final float[] eo;
   private static final int[] ep;
   private static float eq;
   private static float er;
   private static float es;
   private static boolean et;
   private static double eu;
   private static double ev;
   private static int ew;
   private static int ex;
   private static ItemStack ey;
   private static float ez;
   private static float fa;
   private static float fb;
   private static int fc;
   private static final float[] fd;
   private static float fe;
   private static float ff;
   private static float fg;
   private static float fh;
   private static boolean fi;
   private static float fj;
   private static float fk;
   private static float fl;
   private static float fm;
   private static float fn;
   private static float fo;
   private static float fp;
   private static float fq;
   private static float fr;
   private static float fs;
   private static float ft;
   private static int fu;
   public static int lbN;
   public static final float[] LBX;
   public static final float[] LBY;
   public static final int[] LBT;
   public static final int[] LBC;
   public static final int[] LBP;
   private static float fv;
   private static float fw;
   private static float fx;
   private static int fy;
   private final Quaternionf fz = new Quaternionf();
   private final Quaternionf ga = new Quaternionf();
   private final Quaternionf gb = new Quaternionf();
   private final Matrix3f gc = new Matrix3f();
   private final Vector3f gd = new Vector3f();
   private final Vector3f ge = new Vector3f();
   private final Vector3f gf = new Vector3f();
   private final CameraRenderState gg = new CameraRenderState();
   private PlayerEntityRenderState gh;

   public PosePassCache(VertexConsumerProvider.Immediate var1) {
      super(var1);
   }

   public static void install() {

      if (!de) {
         de = true;

         try {
            SpecialGuiElementRegistry.register(PosePassCache::a);
         } catch (Throwable var1) {
            dead = true;
         }
      }
   }

   private static SpecialGuiElementRenderer<?> a(Context var0) {

      return new PosePassCache(var0.vertexConsumers());
   }

   private static int b(int var0) {

      for (int var1 = 0; var1 < bq.length; var1++) {
         if (bq[var1] == var0) {
            return var1;
         }
      }

      return -1;
   }

   public static boolean has3d(int var0) {

      MinecraftClient var1 = MinecraftClient.getInstance();
      return !dead && de && b(var0) >= 0 && var1.player != null && var1.world != null;
   }

   public static boolean draw(DrawContext var0, int var1, int var2, int var3, int var4, int var5) {

      MinecraftClient var6 = MinecraftClient.getInstance();
      Object var7 = null;
      NodeZoneRenderer var8 = null;
      Object var9 = null;
      Object var10 = null;
      PoseStateCache var11 = POPUP;
      int var12 = b(var5);
      lbN = 0;
      if (!dead && de && var12 >= 0 && var0 != null && var6.player != null && var6.world != null) {
         try {
            var7 = var0.getMatrices();
            if (!(Math.abs(((Matrix3x2fStack)var7).m01) > 1.0E-4F)
               && !(Math.abs(((Matrix3x2fStack)var7).m10) > 1.0E-4F)
               && ((Matrix3x2fStack)var7).m00 > 0.0F
               && ((Matrix3x2fStack)var7).m11 > 0.0F) {
               var11.x1 = Math.round(((Matrix3x2fStack)var7).m00 * (float)var1 + ((Matrix3x2fStack)var7).m20);
               var11.y1 = Math.round(((Matrix3x2fStack)var7).m11 * (float)var2 + ((Matrix3x2fStack)var7).m21);
               var11.x2 = Math.round(((Matrix3x2fStack)var7).m00 * (float)(var1 + var3) + ((Matrix3x2fStack)var7).m20);
               var11.y2 = Math.round(((Matrix3x2fStack)var7).m11 * (float)(var2 + var4) + ((Matrix3x2fStack)var7).m21);
               var11.scissor = var0.scissorStack.peekLast();
               var11.visual = var5;
               float var13 = Math.min((float)(var11.x2 - var11.x1) / bu[var12], (float)(var11.y2 - var11.y1) / bv[var12]);
               var11.scale = var13 > 1.0F ? var13 : 1.0F;
               var11.focusY = bs[var12];
               var11.camPitch = bt[var12];
               var11.camYaw = bw[var12];
               boolean var14 = NodeZoneRenderer.ON;
               boolean var15 = false;
               var8 = NodeZoneRenderer.INSTANCE;
               if (var14 && var8 != null) {
                  var9 = var8.u();
                  if (var9 != null && var5 < ((Object[])var9).length && ((Object[])var9)[var5] != null) {
                     var10 = ((NodeZoneRenderer.Vis)((Object[])var9)[var5]).b;
                     var15 = var10 != null && Boolean.TRUE.equals(((CheckerBridge)var10).f());
                  }
               }

               f(var11, var12, System.nanoTime(), var15, var14);
               if (!var11.prepare()) {
                  return false;
               } else {
                  if (br[var12] == 64) {
                     l(var11, ((Matrix3x2fStack)var7).m00, ((Matrix3x2fStack)var7).m11, ((Matrix3x2fStack)var7).m20, ((Matrix3x2fStack)var7).m21);
                  }

                  var0.state.addSpecialElement(var11);
                  return true;
               }
            } else {
               return false;
            }
         } catch (Throwable var16) {
            if (++df >= 20) {
               dead = true;
            }

            return false;
         }
      } else {
         return false;
      }
   }

   public static boolean hasInspect() {

      MinecraftClient var0 = MinecraftClient.getInstance();
      return !dead && !dj && de && var0.player != null && var0.world != null;
   }

   public static boolean drawInspect(DrawContext var0, int var1, int var2, int var3, int var4) {

      MinecraftClient var5 = MinecraftClient.getInstance();
      Object var6 = null;
      PoseStateCache var7 = INSPECT;
      if (!dead && !dj && de && var0 != null && var5.player != null && var5.world != null) {
         try {
            var6 = var0.getMatrices();
            if (!(Math.abs(((Matrix3x2fStack)var6).m01) > 1.0E-4F)
               && !(Math.abs(((Matrix3x2fStack)var6).m10) > 1.0E-4F)
               && ((Matrix3x2fStack)var6).m00 > 0.0F
               && ((Matrix3x2fStack)var6).m11 > 0.0F) {
               var7.x1 = Math.round(((Matrix3x2fStack)var6).m00 * (float)var1 + ((Matrix3x2fStack)var6).m20);
               var7.y1 = Math.round(((Matrix3x2fStack)var6).m11 * (float)var2 + ((Matrix3x2fStack)var6).m21);
               var7.x2 = var7.x1 + Math.round(((Matrix3x2fStack)var6).m00 * (float)var3);
               var7.y2 = var7.y1 + Math.round(((Matrix3x2fStack)var6).m11 * (float)var4);
               var7.scissor = var0.scissorStack.peekLast();
               var7.scale = 1.0F;
               if (!var7.prepare()) {
                  return false;
               } else {
                  var0.state.addSpecialElement(var7);
                  return true;
               }
            } else {
               return false;
            }
         } catch (Throwable var9) {
            if (++dk >= 20) {
               dj = true;
            }

            return false;
         }
      } else {
         return false;
      }
   }

   public Class<PoseStateCache> getElementClass() {

      return PoseStateCache.class;
   }

   protected String getName() {

      return s[0];
   }

   protected float getYOffset(int var1, int var2) {

      return (float)var1 * 0.5F;
   }

   protected void render(PoseStateCache var1, MatrixStack var2) {

      if (var1 == INSPECT) {
         if (ConfigBridge.c != null && ConfigBridge.c.a()) {
            BevelPassCache.y(this.vertexConsumers, var2, var1.x2 - var1.x1, var1.y2 - var1.y1);
         }
      } else {
         MinecraftClient var3 = MinecraftClient.getInstance();
         ClientPlayerEntity var4 = var3.player;
         EntityRenderManager var5 = null;
         PlayerEntityRenderer var6 = null;
         Object var7 = null;
         RenderDispatcher var8 = null;
         float var9 = dp;
         dp = 0.0F;
         if (!dead && var4 != null && var1 != null && b(var1.visual) >= 0 && ConfigBridge.c != null && ConfigBridge.c.a()) {
            try {
               this.fz.rotationYXZ((float) Math.PI - ds * (float) (Math.PI / 180.0), -var1.camPitch * (float) (Math.PI / 180.0), 0.0F);
               this.fz.transform(this.gd.set(1.0F, 0.0F, 0.0F));
               this.fz.transform(this.ge.set(0.0F, 1.0F, 0.0F));
               this.fz.transform(this.gf.set(0.0F, 0.0F, -1.0F));
               this.gc.setRow(0, this.gd.x, this.gd.y, this.gd.z);
               this.gc.setRow(1, -this.ge.x, -this.ge.y, -this.ge.z);
               this.gc.setRow(2, this.gf.x, this.gf.y, this.gf.z);
               this.ga.setFromNormalized(this.gc);
               double var10 = eu;
               double var12 = (double)var1.focusY;
               double var14 = ev;
               int var16 = var3.getWindow().getScaleFactor();
               float var17 = (float)var16 * var1.scale;
               if (var17 * 4.5F > 900.0F) {
                  var2.peek().getPositionMatrix().scale(1.0F, 1.0F, 900.0F / (var17 * 4.5F));
               }

               var2.multiply(this.ga);
               var3.gameRenderer.getDiffuseLighting().setShaderLights(DiffuseLighting.Type.ENTITY_IN_UI);
               var5 = var3.getEntityRenderDispatcher();
               var6 = var5.getPlayerRenderer(var4);
               var7 = this.gh;
               if (var7 == null) {
                  var7 = var6.createRenderState();
                  this.gh = (PlayerEntityRenderState)var7;
               }

               var6.updateRenderState(var4, (PlayerEntityRenderState)var7, 1.0F);
               c((PlayerEntityRenderState)var7);
               if (et) {
                  d((PlayerEntityRenderState)var7, var4, var3);
               }

               this.gc.setRow(0, -this.gd.x, -this.gd.y, -this.gd.z);
               this.gc.setRow(1, this.ge.x, this.ge.y, this.ge.z);
               this.gb.setFromNormalized(this.gc).conjugate().rotateY((float) Math.PI);
               this.gg.orientation = this.gb;
               if (er > 0.002F) {
                  var8 = var3.gameRenderer.getEntityRenderDispatcher();

                  try {
                     var5.render(
                        (EntityRenderState)var7,
                        this.gg,
                        RegionPassCache.pvX - var10,
                        RegionPassCache.pvY - var12,
                        RegionPassCache.pvZ - var14,
                        var2,
                        var8.getQueue()
                     );
                  } finally {
                     var8.render();
                  }

                  this.vertexConsumers.draw();
               }

               double var18 = var10 - (double)(this.gf.x * 8.0F);
               double var20 = var12 - (double)(this.gf.y * 8.0F);
               double var22 = var14 - (double)(this.gf.z * 8.0F);
               float[] var24 = ec;
               var24[0] = this.gd.x;
               var24[1] = this.gd.y;
               var24[2] = this.gd.z;
               var24[3] = this.ge.x;
               var24[4] = this.ge.y;
               var24[5] = this.ge.z;
               var24[6] = this.gf.x;
               var24[7] = this.gf.y;
               var24[8] = this.gf.z;
               if (RegionPassCache.a(var18, var20, var22, var24, var17 * 8.0F, var9)) {
                  try {
                     var2.push();
                     var2.translate((float)(var18 - var10), (float)(var20 - var12), (float)(var22 - var14));
                     q(var18, var20, var22, var17, (float)Math.sin((double)(var1.camPitch * (float) (Math.PI / 180.0))));
                     RegionPassCache.b(this.vertexConsumers, var2.peek(), 1.0F);
                     int var25 = RegionPassCache.bt;
                     if ((var25 & 44) != 0 && dh < 20) {
                        try {
                           h();
                           TracePassCache.h();
                        } catch (Throwable var48) {
                           dh++;
                        }
                     }

                     if (var25 == 16 && dg < 20) {
                        try {
                           DriftPassCache.b();
                        } catch (Throwable var47) {
                           dg++;
                        }
                     }

                     if ((var25 & 3) != 0 && di < 20) {
                        try {
                           HaloPassCache.q();
                        } catch (Throwable var46) {
                           di++;
                        }
                     }

                     if (var25 == (-961261641 ^ -961261769) && ex < 20) {
                        try {
                           EchoPassCache.f();
                           p(var18, var20, var22, var1);
                        } catch (Throwable var45) {
                           ex++;
                        }
                     }

                     RegionPassCache.b(this.vertexConsumers, var2.peek(), RegionPassCache.ae);
                     if (var25 == 32 && ej > 0.0F && r(var18, var20, var22, var1.scale) > 0) {
                        float var26 = ej;
                        RegionPassCache.b(this.vertexConsumers, var2.peek(), var26 * var26 * (3.0F - 2.0F * var26));
                     }

                     if (var25 == 64 && ew < 20) {
                        try {
                           if (m(var18, var20, var22, var1.scale) > 0) {
                              RegionPassCache.b(this.vertexConsumers, var2.peek(), 1.0F);
                           }
                        } catch (Throwable var44) {
                           ew++;
                        }
                     }

                     var2.pop();
                  } finally {
                     RegionPassCache.c();
                  }
               }
            } catch (Throwable var51) {
               if (++df >= 20) {
                  dead = true;
               }
            }

            ea = false;
            dz = false;
            dy = false;
         } else {
            ea = false;
            dz = false;
            dy = false;
         }
      }
   }

   private static void c(PlayerEntityRenderState var0) {

      var0.bodyYaw = RegionPassCache.bp;
      var0.relativeHeadYaw = MathHelper.wrapDegrees(RegionPassCache.bq - RegionPassCache.bp);
      var0.pitch = RegionPassCache.br;
      var0.limbSwingAnimationProgress = dv;
      var0.limbSwingAmplitude = dw;
      var0.handSwingProgress = es;
      var0.hurt = dx > 0.0F || eq > 0.0F;
      var0.light = 1264301940 ^ 1269544836;
      var0.outlineColor = 0;
      var0.shadowPieces.clear();
      var0.displayName = null;
      var0.nameLabelPos = null;
      var0.invisible = false;
      var0.invisibleToPlayer = false;
      var0.spectator = false;
      var0.onFire = false;
      var0.deathTime = eq;
      var0.sneaking = false;
      var0.isInSneakingPose = false;
      var0.pose = EntityPose.STANDING;
      var0.isGliding = false;
      var0.isSwimming = false;
      var0.leaningPitch = 0.0F;
      var0.hasVehicle = false;
      var0.sleepingDirection = null;
      var0.flipUpsideDown = false;
      var0.shaking = false;
      if (var0.baseScale > 0.0F && var0.baseScale != 1.0F) {
         var0.width = var0.width / var0.baseScale;
         var0.height = var0.height / var0.baseScale;
         var0.baseScale = 1.0F;
      }

      if (er < 1.0F) {
         var0.baseScale = er;
      }
   }

   private static void d(PlayerEntityRenderState var0, AbstractClientPlayerEntity var1, MinecraftClient var2) {

      ItemModelManager var3 = var2.getItemModelManager();
      ItemStack var4 = ey;
      if (var4 == null) {
         var4 = new ItemStack(Items.ENDER_PEARL);
         ey = var4;
      }

      if (var0.mainArm == Arm.LEFT) {
         var3.updateForLivingEntity(var0.leftHandItemState, var4, ItemDisplayContext.THIRD_PERSON_LEFT_HAND, var1);
         var0.leftHandItem = var4;
         var0.leftArmPose = BipedEntityModel.ArmPose.ITEM;
      } else {
         var3.updateForLivingEntity(var0.rightHandItemState, var4, ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, var1);
         var0.rightHandItem = var4;
         var0.rightArmPose = BipedEntityModel.ArmPose.ITEM;
      }

      var0.preferredArm = var0.mainArm;
      var0.swingAnimationType = var4.getSwingAnimation().type();
   }

   private static void e(PoseStateCache var0, int var1, boolean var2) {

      dq = var0.visual;
      dm = 0.0;
      _kwren_do = 0.0F;
      dn = 0.0F;
      dp = 0.0F;
      ds = j(360.0F + bw[var1]);
      dt = 12.0F;
      du = 0.0F;
      yawDrag = 0.0F;
      dr = 0L;
      RegionPassCache.pvZ = 0.0;
      RegionPassCache.pvY = 0.0;
      RegionPassCache.pvX = 0.0;
      dx = 0.0F;
      dw = 0.0F;
      dv = 0.0F;
      ea = false;
      dz = false;
      dy = false;

      for (int var3 = 0; var3 < 8; var3++) {
         eh[var3] = 0.0F;
      }

      ej = var2 ? 1.0F : 0.0F;
      int var9 = i();
      ek = (float)(var9 >> 16 & (375590301 ^ 375590242));
      el = (float)(var9 >> 8 & (-213793815 ^ -213794026));
      em = (float)(var9 & (607022788 ^ 607022651));

      try {
         HaloPassCache.r();
      } catch (Throwable var8) {
      }

      try {
         TracePassCache.i();
      } catch (Throwable var7) {
      }

      try {
         DriftPassCache.c();
      } catch (Throwable var6) {
      }

      eq = 0.0F;
      er = 1.0F;
      es = 0.0F;
      et = false;
      ez = 0.0F;
      fc = 0;
      fi = false;
      fp = -1.0F;
      fr = 0.0F;
      fq = 0.0F;
      fs = -1.0F;
      fa = 180.0F;
      fb = 0.0F;
      lbN = 0;
      fv = 0.0F;
      fy = 0;

      try {
         EchoPassCache.e();
      } catch (Throwable var5) {
      }
   }

   private static void f(PoseStateCache var0, int var1, long var2, boolean var4, boolean var5) {

      float var6 = (float)(var2 - dl) / 1.0E9F;
      if (var0.visual != dq || dl == 0L || var2 - dl > 250000000L) {
         e(var0, var1, var5);
         var6 = 0.0F;
      }

      dl = var2;
      var6 = var6 < 0.0F ? 0.0F : (var6 > 0.1F ? 0.1F : var6);
      float var7 = dp + var6;
      dp = var7 > 0.1F ? 0.1F : var7;
      dm += (double)var6;

      for (dn += var6; dn >= 0.05F; RegionPassCache.bu++) {
         dn -= 0.05F;
      }

      if (yawDrag != 0.0F) {
         du = du + yawDrag;
         yawDrag = 0.0F;
         dr = var2;
         dt = 0.0F;
      }

      float var8 = du * (1.0F - (float)Math.exp((double)(-25.0F * var6)));
      du -= var8;
      float var9 = var2 - dr > 1500000000L ? 12.0F : 0.0F;
      dt = dt + (var9 - dt) * (1.0F - (float)Math.exp((double)(-2.5F * var6)));
      ds = j(ds + var8 + dt * var6);
      int var10 = br[var1];
      RegionPassCache.bt = var10;
      MinecraftClient var11 = MinecraftClient.getInstance();
      RegionPassCache.bs = var11.player != null && !var11.player.getEquippedStack(EquipmentSlot.HEAD).isEmpty();
      RegionPassCache.pvH = 1.8F;
      float var12 = 180.0F;
      float var13 = 180.0F;
      float var14 = 0.0F;
      float var15 = 0.0F;
      RegionPassCache.bv = 0.0F;
      if (var10 == 4) {
         RegionPassCache.bv = 4.3F;
         RegionPassCache.pvZ -= (double)(4.3F * var6);
         RegionPassCache.pvX = 0.45F * Math.sin(0.8F * dm);
         float var16 = (float)(0.35999998F * Math.cos(0.8F * dm));
         var12 = (float)Math.toDegrees(Math.atan2((double)(-var16), -4.3F));
         var13 = var12;
         var15 = 0.86F;
         dv += 17.2F * var6;
         if (dv > 943.138F) {
            dv -= 943.138F;
         }
      } else if (var10 == 2) {
         var13 = 180.0F + 28.0F * (float)Math.sin(0.55 * dm);
         var14 = -4.0F + 12.0F * (float)Math.sin(0.37 * dm + 1.0);
      }

      dw = dw + (var15 - dw) * (1.0F - (float)Math.exp((double)(-6.0F * var6)));
      RegionPassCache.bp = var12;
      RegionPassCache.bq = var13;
      RegionPassCache.br = var14;
      RegionPassCache.pvY = 0.0;
      boolean var23 = var4 && var5;
      eq = 0.0F;
      er = 1.0F;
      es = 0.0F;
      et = false;
      if (var10 == 64) {
         RegionPassCache.pvX = 0.0;
         RegionPassCache.pvZ = 1.5;
         if (ew < 20) {
            try {
               k(var6);
            } catch (Throwable var21) {
               ew++;
            }
         }
      } else if (var10 == (-800152264 ^ -800152136) && ex < 20) {
         try {
            o(var6, var23);
         } catch (Throwable var20) {
            ex++;
            eq = 0.0F;
            er = 1.0F;
         }
      }

      eu = RegionPassCache.pvX;
      ev = var10 == 64 ? 0.0 : RegionPassCache.pvZ;
      if (var10 == 32) {
         float var17 = (float)(dm % 1.9F);
         if (_kwren_do < 0.35F && var17 >= 0.35F && var23) {
            g(false, var17 - 0.35F);
         }

         if (_kwren_do < 0.9F && var17 >= 0.9F && var23 && RegionPassCache.cc) {
            g(true, var17 - 0.35F - 0.55F);
         }

         if (var17 > 0.35F && var17 < 0.9F) {
            double var18 = (double)((var17 - 0.35F) / 0.55F);
            RegionPassCache.pvY = 1.68F * var18 * (1.0 - var18);
         }

         _kwren_do = var17;
      } else if (var10 == 8) {
         float var24 = (float)(dm % 1.5);
         if (_kwren_do < 0.25F && var24 >= 0.25F && var23) {
            ea = true;
            dx = 0.3F;
         }

         _kwren_do = var24;
      }

      if (dx > 0.0F) {
         dx = Math.max(0.0F, dx - var6);
      }

      if (var10 == 32) {
         ej = var5 ? Math.min(1.0F, ej + var6 / 0.18F) : Math.max(0.0F, ej - var6 / 0.22F);
         int var25 = i();
         float var26 = 1.0F - (float)Math.exp((double)(-14.0F * var6));
         ek = ek + ((float)(var25 >> 16 & (-1017888479 ^ -1017888290)) - ek) * var26;
         el = el + ((float)(var25 >> 8 & (-1644577691 ^ -1644577638)) - el) * var26;
         em = em + ((float)(var25 & (234663797 ^ 234663818)) - em) * var26;
      }
   }

   private static void g(boolean var0, float var1) {

      if (RegionPassCache.bw >= 3) {
         if (var0) {
            dz = true;
         } else {
            dy = true;
         }
      } else {
         int var2 = Math.max(1, Math.min(4, RegionPassCache.bx));
         float var3 = var0 && RegionPassCache.cd ? 1.25F : 1.0F;
         float var4 = Math.max(0.05F, RegionPassCache.bz / 1000.0F);

         for (int var5 = 0; var5 < var2; var5++) {
            int var6 = 0;
            double var7 = Double.MAX_VALUE;

            for (int var9 = 0; var9 < 8; var9++) {
               if (!(eh[var9] > 0.0F) || dm > ed[var9] + (double)eh[var9] + 0.09F) {
                  var6 = var9;
                  break;
               }

               if (ed[var9] < var7) {
                  var7 = ed[var9];
                  var6 = var9;
               }
            }

            ed[var6] = dm - (double)var1 + (double)((float)var5 * 0.13F);
            ee[var6] = RegionPassCache.pvX;
            ef[var6] = RegionPassCache.pvZ;
            eg[var6] = var3;
            eh[var6] = var4;
            ei[var6] = RegionPassCache.ca;
         }
      }
   }

   private static void h() {

      boolean var0 = dz;
      if (dy || var0) {
         int var1 = RegionPassCache.bw == 4 ? 1 : 0;
         float var2 = var0 && RegionPassCache.cd ? 1.25F : 1.0F;
         int var3 = Math.max(1, Math.min(4, RegionPassCache.bx));
         int var4 = RegionPassCache.rsRgb ? -1 : RegionPassCache.by;

         for (int var5 = 0; var5 < var3; var5++) {
            TracePassCache.b(
               RegionPassCache.pvX, 0.0, RegionPassCache.pvZ, var2, var1, RegionPassCache.bz, RegionPassCache.ca, var4, (float)var5 * 0.13F * 1000.0F
            );
         }
      }

      if (ea) {
         float var6 = -RegionPassCache.fX + 0.6F * (float)eb * RegionPassCache.rX;
         float var7 = -RegionPassCache.fZ + 0.6F * (float)eb * RegionPassCache.rZ;
         float var8 = (float)Math.sqrt((double)(var6 * var6 + var7 * var7));
         if (var8 > 1.0E-4F) {
            var6 /= var8;
            var7 /= var8;
         }

         eb = -eb;
         TracePassCache.d(
            RegionPassCache.pvX, RegionPassCache.pvY + 0.62 * (double)RegionPassCache.pvH, RegionPassCache.pvZ, -var6, 0.0F, -var7, RegionPassCache.pvH
         );
      }

      ea = false;
      dz = false;
      dy = false;
   }

   private static int i() {

      if (RegionPassCache.rsRgb) {
         float var7 = (float)(System.nanoTime() / 1000000L % 2400L) / 400.0F;
         int var1 = (int)var7;
         float var2 = var7 - (float)var1;
         int var3 = 129171301 ^ 129171354;
         byte var4 = 38;
         int var5 = (int)(255.0F * (1.0F - 0.85F * var2) + 0.5F);
         int var6 = (int)(255.0F * (1.0F - 0.85F * (1.0F - var2)) + 0.5F);
         switch (var1) {
            case 0:
               return var3 << 16 | var6 << 8 | var4;
            case 1:
               return var5 << 16 | var3 << 8 | var4;
            case 2:
               return var4 << 16 | var3 << 8 | var6;
            case 3:
               return var4 << 16 | var5 << 8 | var3;
            case 4:
               return var6 << 16 | var4 << 8 | var3;
            default:
               return var3 << 16 | var4 << 8 | var5;
         }
      } else {
         int var0 = RegionPassCache.by;
         if (var0 < 0) {
            RegionPassCache.i();
         }

         return RegionPassCache.col(var0);
      }
   }

   private static float j(float var0) {

      var0 %= 360.0F;
      return var0 < 0.0F ? var0 + 360.0F : var0;
   }

   private static void k(float var0) {

      NodeZoneRenderer var1 = NodeZoneRenderer.INSTANCE;
      float[] var2 = fd;
      if (var1 != null) {
         var1.t(var2);
      } else {
         var2[2] = var2[3] = var2[4] = var2[5] = 0.0F;
      }

      int var3 = Float.floatToRawIntBits(var2[0]) & (-668759414 ^ -656640651);
      float var4 = (float)(var3 >> 16 & (367936421 ^ 367936346));
      float var5 = (float)(var3 >> 8 & (-1924439822 ^ -1924440051));
      float var6 = (float)(var3 & (1117913668 ^ 1117913787));
      if (!fi) {
         fe = var4;
         ff = var5;
         fg = var6;
         fh = var2[6];
         fi = true;
      } else {
         float var7 = 1.0F - (float)Math.exp((double)(-14.0F * var0));
         fe = fe + (var4 - fe) * var7;
         ff = ff + (var5 - ff) * var7;
         fg = fg + (var6 - fg) * var7;
         fh = fh + (var2[6] - fh) * var7;
      }

      ez += var0;
      float var27 = fc == 0 ? 3.0F : 2.6F;
      if (ez >= var27) {
         ez -= var27;
         fc ^= 1;
      }

      int var8 = (int)(fe + 0.5F);
      int var9 = (int)(ff + 0.5F);
      int var10 = (int)(fg + 0.5F);
      float var11;
      float var12;
      if (fc == 0) {
         fj = 0.0F;
         fk = 1.52F;
         fl = 1.2F;
         fm = 0.1F;
         fn = -1.9F;
         fo = 1.15F;
         var11 = 0.9F;
         var12 = 1.1F;
         fu = var8 << 16 | var9 << 8 | var10;
      } else {
         fj = 2.9F;
         fk = 3.1F;
         fl = -3.4F;
         fm = -0.7F;
         fn = 0.4F;
         fo = 0.8F;
         var11 = 0.25F;
         var12 = 1.2F;
         float var13 = fh;
         fu = (int)((float)var8 + (float)((1031699 ^ 1031916) - var8) * var13 + 0.5F) << 16
            | (int)((float)var9 + (float)(75 - var9) * var13 + 0.5F) << 8
            | (int)((float)var10 + (float)(75 - var10) * var13 + 0.5F);
      }

      ft = var12;
      float var28 = ez - var11;
      float var14 = 0.0F;
      if (fc == 0) {
         float var15 = ez / 0.18F;
         var15 = var15 > 1.0F ? 1.0F : var15;
         float var16 = var28 / 0.22F;
         var16 = var16 < 0.0F ? 0.0F : (var16 > 1.0F ? 1.0F : var16);
         var14 = var15 * var15 * (3.0F - 2.0F * var15) * (1.0F - var16 * var16 * (3.0F - 2.0F * var16));
      }

      fq = var14;
      if (var28 < 0.0F) {
         fp = -1.0F;
         fr = 0.0F;
         fs = -1.0F;
      } else {
         fp = var28 < var12 ? var28 / var12 : 1.0F;
         float var30 = var28 / 0.18F;
         var30 = var30 > 1.0F ? 1.0F : var30;
         float var34 = (var28 - var12) / 0.25F;
         var34 = var34 < 0.0F ? 0.0F : (var34 > 1.0F ? 1.0F : var34);
         fr = var30 * var30 * (3.0F - 2.0F * var30) * (1.0F - var34 * var34 * (3.0F - 2.0F * var34));
         fs = var28 >= var12 ? var28 - var12 : -1.0F;
      }

      et = true;
      es = fc == 0 && var28 >= 0.0F && var28 < 0.3F ? var28 / 0.3F : 0.0F;
      float var32 = 180.0F;
      float var36 = 0.0F;
      if (fc == 0) {
         if (var28 < var12 + 0.3F) {
            var36 = -14.0F;
         }
      } else if (var28 > -0.35F && var28 < var12 + 0.3F) {
         float var17 = fp < 0.0F ? 0.0F : fp;
         float var18 = 1.0F - var17;
         float var19 = fj + (fm - fj) * var17;
         float var20 = fk * var18 + 4.0F * fo * var17 * var18;
         float var21 = fl + (fn - fl) * var17;
         float var22 = var19 - (float)RegionPassCache.pvX;
         float var23 = var20 - 1.62F;
         float var24 = var21 - (float)RegionPassCache.pvZ;
         float var25 = (float)Math.toDegrees(Math.atan2((double)(-var22), (double)var24));
         float var26 = MathHelper.wrapDegrees(var25 - 180.0F);
         var26 = var26 > 70.0F ? 70.0F : (var26 < -70.0F ? -70.0F : var26);
         var32 = 180.0F + var26;
         var36 = (float)(-Math.toDegrees(Math.atan2((double)var23, Math.sqrt((double)(var22 * var22 + var24 * var24)))));
         var36 = var36 > 40.0F ? 40.0F : (var36 < -50.0F ? -50.0F : var36);
      }

      float var38 = 1.0F - (float)Math.exp((double)(-7.0F * var0));
      fa = fa + MathHelper.wrapDegrees(var32 - fa) * var38;
      fb = fb + (var36 - fb) * var38;
      RegionPassCache.bq = fa;
      RegionPassCache.br = fb;
   }

   private static void l(PoseStateCache var0, float var1, float var2, float var3, float var4) {

      if (ew < 20) {
         float[] var5 = fd;
         float var6 = var5[4];
         float var7 = var5[5];
         float var8 = fp >= 0.0F ? var6 * fr : 0.0F;
         float var9 = fc == 0 ? var7 * fq * (1.0F - fr) : 0.0F;
         if (!(var9 <= 0.004F) || !(var8 <= 0.004F)) {
            double var10 = (double)((float) Math.PI - ds * (float) (Math.PI / 180.0));
            double var12 = (double)(-var0.camPitch * (float) (Math.PI / 180.0));
            float var14 = (float)Math.cos(var10);
            float var15 = (float)Math.sin(var10);
            float var16 = (float)Math.cos(var12);
            float var17 = (float)Math.sin(var12);
            float var19 = -var15;
            float var20 = var15 * var17;
            float var22 = var14 * var17;
            float var23 = (float)((double)fm - eu);
            float var24 = 0.55F - var0.focusY;
            float var25 = (float)((double)fn - ev);
            float var26 = var0.scale;
            float var27 = (float)(var0.x1 + var0.x2) * 0.5F + var26 * (var14 * var23 + var19 * var25);
            float var28 = (float)(var0.y1 + var0.y2) * 0.5F - var26 * (var20 * var23 + var16 * var24 + var22 * var25);
            float var29 = (var27 - var3) / var1;
            float var30 = (var28 - var4) / var2;
            int var31 = 0;
            if (var9 > 0.004F) {
               int var32 = (int)(144.0F * var9);
               LBX[var31] = var29;
               LBY[var31] = var30;
               LBT[var31] = Math.round(ft * 10.0F);
               LBC[var31] = (int)((float)Math.min(-1683829605 ^ -1683829660, 1747909600 ^ 1747909392) * var9) << 24 | -1380361548 ^ -1387879093;
               LBP[var31] = var32 << 24;
               var31++;
            }

            if (var8 > 0.004F) {
               float var38 = (1.0F - fp) * ft;
               float var33 = 1.0F - var38;
               var33 = var33 < 0.0F ? 0.0F : (var33 > 1.0F ? 1.0F : var33);
               int var34 = fu;
               int var35 = var34 >> 16 & (101003761 ^ 101003534);
               int var36 = var34 >> 8 & (1400741799 ^ 1400741720);
               int var37 = var34 & (-477781082 ^ -477781159);
               LBX[var31] = var29;
               LBY[var31] = var30;
               LBT[var31] = Math.round(var38 * 10.0F);
               LBC[var31] = (int)(255.0F * var8) << 24
                  | (int)((float)var35 + (float)((1701190504 ^ 1701190551) - var35) * var33 + 0.5F) << 16
                  | (int)((float)var36 + (float)((-1483977952 ^ -1483977761) - var36) * var33 + 0.5F) << 8
                  | (int)((float)var37 + (float)((2041430380 ^ 2041430419) - var37) * var33 + 0.5F);
               LBP[var31] = (int)(144.0F * var8) << 24;
               var31++;
            }

            lbN = var31;
         }
      }
   }

   private static int m(double var0, double var2, double var4, float var6) {

      assert RegionPassCache.LT.length == (1783533436 ^ 1783535996)
         && RegionPassCache.ST.length == (1012699603 ^ 1012707795)
         && RegionPassCache.SA.length == (237718807 ^ 237751575)
         && RegionPassCache.nLT >= 0
         && RegionPassCache.nST >= 0
         && RegionPassCache.nSA >= 0
         && fd.length == 8
         && var6 > 0.0F
         && !Double.isNaN(var0)
         && !Double.isNaN(var2)
         && !Double.isNaN(var4) : "pearlFx:" + " bad contra" + "ct";

      int var7 = RegionPassCache.nLT + RegionPassCache.nST + RegionPassCache.nSA;

      try {
         float[] var8 = fd;
         float var9 = var8[1] > 1.0F ? var8[1] : 1.0F;
         float var10 = 2.0F * var9 / (var6 * 0.22F);
         float var11 = (float)((double)fj - var0);
         float var12 = (float)((double)fl - var4);
         float var13 = fm - fj;
         float var14 = fn - fl;
         float var15 = fk;
         float var16 = 4.0F * fo;
         float var17 = (float)var2;
         float var18 = (float)((double)fm - var0);
         float var19 = 0.02F - var17;
         float var20 = (float)((double)fn - var4);
         int var21 = fu;
         int var22 = var21 >> 16 & (1289875311 ^ 1289875344);
         int var23 = var21 >> 8 & (-2116926574 ^ -2116926611);
         int var24 = var21 & (-144179482 ^ -144179687);
         float[] var25 = RegionPassCache.LT;
         int var26 = RegionPassCache.nLT;
         float var27 = fc == 0 ? var8[5] * fq : 0.0F;
         int var28 = (int)(144.0F * var27);
         if (var28 > 1) {
            int var29 = (int)((float)var22 + (float)((1817744177 ^ 1817744334) - var22) * 0.4F + 0.5F) << 16
               | (int)((float)var23 + (float)((-466925451 ^ -466925430) - var23) * 0.4F + 0.5F) << 8
               | (int)((float)var24 + (float)((-192243288 ^ -192243369) - var24) * 0.4F + 0.5F);
            float var30 = Float.intBitsToFloat(var28 << 24 | var29);
            float var31 = var11;
            float var32 = var15 - var17;
            float var33 = var12;

            for (int var34 = 1; var34 <= 24; var34++) {
               float var35 = (float)var34 / 24.0F;
               float var36 = 1.0F - var35;
               float var37 = var11 + var13 * var35;
               float var38 = var15 * var36 + var16 * var35 * var36 - var17;
               float var39 = var12 + var14 * var35;
               if ((var34 & 1) == 1 && var26 < (-1848398671 ^ -1848398159)) {
                  int var40 = var26 * 11;
                  var25[var40] = var31;
                  var25[var40 + 1] = var32;
                  var25[var40 + 2] = var33;
                  var25[var40 + 3] = var37;
                  var25[var40 + 4] = var38;
                  var25[var40 + 5] = var39;
                  var25[var40 + 6] = var10;
                  var25[var40 + 7] = var10;
                  var25[var40 + 8] = var30;
                  var25[var40 + 9] = var30;
                  var25[var40 + 10] = 1.0F;
                  var26++;
               }

               var31 = var37;
               var32 = var38;
               var33 = var39;
            }

            RegionPassCache.nLT = var26;
            n(var18, var19, var20, 0.45F, var10, var30);
            var26 = RegionPassCache.nLT;
         }

         float var51 = fr;
         float var52 = fp;
         if (var52 >= 0.0F && var51 > 0.004F) {
            float var53 = var8[2] * var51;
            float var55 = 1.0F - var52;
            int var57 = (int)Math.ceil((double)(var55 * 24.0F));
            if (var53 > 0.004F && var57 > 0) {
               float var59 = var57 > 1 ? (float)(var57 - 1) : 1.0F;
               float var62 = 1.0F - var52;
               float var66 = var11 + var13 * var52;
               float var69 = var15 * var62 + var16 * var52 * var62 - var17;
               float var71 = var12 + var14 * var52;
               int var73 = 0;

               for (int var75 = 1; var75 <= var57; var75++) {
                  float var41 = var52 + var55 * (float)var75 / (float)var57;
                  float var42 = 1.0F - var41;
                  float var43 = var11 + var13 * var41;
                  float var44 = var15 * var42 + var16 * var41 * var42 - var17;
                  float var45 = var12 + var14 * var41;
                  float var46 = (float)(var75 - 1) / var59;
                  var46 = var46 > 1.0F ? 1.0F : var46;
                  float var47 = 0.55F + 0.45F * var46;
                  int var48 = (int)((80.0F + var46 * 144.0F) * var53) << 24
                     | (int)((float)var22 * var47) << 16
                     | (int)((float)var23 * var47) << 8
                     | (int)((float)var24 * var47);
                  if (var75 == 1) {
                     var73 = var48;
                  }

                  if (var26 < (-1970632333 ^ -1970631821)) {
                     int var49 = var26 * 11;
                     var25[var49] = var66;
                     var25[var49 + 1] = var69;
                     var25[var49 + 2] = var71;
                     var25[var49 + 3] = var43;
                     var25[var49 + 4] = var44;
                     var25[var49 + 5] = var45;
                     var25[var49 + 6] = var10;
                     var25[var49 + 7] = var10;
                     var25[var49 + 8] = Float.intBitsToFloat(var73);
                     var25[var49 + 9] = Float.intBitsToFloat(var48);
                     var25[var49 + 10] = 1.0F;
                     var26++;
                  }

                  var73 = var48;
                  var66 = var43;
                  var69 = var44;
                  var71 = var45;
               }

               RegionPassCache.nLT = var26;
            }

            float var60 = var8[3] * var51;
            if (var60 > 0.004F) {
               float var63 = 0.55F + 0.06F * (float)Math.sin(dm * 7.6923076923076925);
               float var67 = 0.12F + 0.43F * (1.0F - var52);
               n(var18, var19, var20, var63, var10, Float.intBitsToFloat((int)(240.0F * var60) << 24 | var21));
               n(var18, var19, var20, var67, var10, Float.intBitsToFloat((int)(144.0F * var60) << 24 | var21));
            }

            if (var52 < 1.0F) {
               float var64 = 1.0F - var52;
               float var68 = var11 + var13 * var52;
               float var70 = var15 * var64 + var16 * var52 * var64 - var17;
               float var72 = var12 + var14 * var52;
               int var74 = RegionPassCache.nST;
               if (var74 < (1022137444 ^ 1022136420)) {
                  float[] var76 = RegionPassCache.ST;
                  int var78 = var74 * 8;
                  var76[var78] = var68;
                  var76[var78 + 1] = var70;
                  var76[var78 + 2] = var72;
                  var76[var78 + 3] = 0.13F;
                  var76[var78 + 4] = 0.13F;
                  var76[var78 + 5] = 0.0F;
                  var76[var78 + 6] = 8.0F;
                  var76[var78 + 7] = Float.intBitsToFloat((int)(244.0F * var51) << 24 | 746222019 ^ 744819627);
                  RegionPassCache.nST = var74 + 1;
               }

               int var77 = RegionPassCache.nSA;
               if (var77 < (1378773138 ^ 1378777234)) {
                  float[] var79 = RegionPassCache.SA;
                  int var80 = var77 * 8;
                  var79[var80] = var68 - 0.035F * RegionPassCache.rX + 0.035F * RegionPassCache.uX;
                  var79[var80 + 1] = var70 - 0.035F * RegionPassCache.rY + 0.035F * RegionPassCache.uY;
                  var79[var80 + 2] = var72 - 0.035F * RegionPassCache.rZ + 0.035F * RegionPassCache.uZ;
                  var79[var80 + 3] = 0.05F;
                  var79[var80 + 4] = 0.05F;
                  var79[var80 + 5] = 0.0F;
                  var79[var80 + 6] = 3.0F;
                  var79[var80 + 7] = Float.intBitsToFloat((int)(192.0F * var51) << 24 | -1233641242 ^ -1228877310);
                  RegionPassCache.nSA = var77 + 1;
               }
            }
         }

         float var54 = fs;
         if (var54 >= 0.0F && var54 < 0.4F) {
            float var56 = 1.0F - var54 / 0.4F;
            int var58 = RegionPassCache.nSA;
            if (var58 < (1080114125 ^ 1080110029)) {
               float[] var61 = RegionPassCache.SA;
               int var65 = var58 * 8;
               var61[var65] = var18;
               var61[var65 + 1] = var19 + 0.3F;
               var61[var65 + 2] = var20;
               var61[var65 + 3] = 0.45F + 0.5F * var54;
               var61[var65 + 4] = 0.45F + 0.5F * var54;
               var61[var65 + 5] = 0.0F;
               var61[var65 + 6] = 4.0F;
               var61[var65 + 7] = Float.intBitsToFloat((int)(150.0F * var56 * var56) << 24 | 2084596874 ^ 2096379514);
               RegionPassCache.nSA = var58 + 1;
            }
         }

         return RegionPassCache.nLT + RegionPassCache.nST + RegionPassCache.nSA - var7;
      } catch (RuntimeException var50) {
         throw var50;
      }
   }

   private static void n(float var0, float var1, float var2, float var3, float var4, float var5) {

      assert RegionPassCache.LT.length == (838925353 ^ 838920745)
         && RegionPassCache.nLT >= 0
         && bm.length == 37
         && bn.length == 37
         && var3 > 0.0F
         && var4 > 0.0F
         && !Float.isNaN(var0)
         && !Float.isNaN(var1)
         && !Float.isNaN(var2) : "ringL" + "T:" + " bad contract";

      try {
         if (Float.floatToRawIntBits(var5) >>> 24 >= 2) {
            float[] var6 = RegionPassCache.LT;
            int var7 = RegionPassCache.nLT;
            if (var7 + 36 <= (1936035702 ^ 1936035190)) {
               for (int var8 = 0; var8 < 36; var8++) {
                  int var9 = var7 * 11;
                  var6[var9] = var0 + bm[var8] * var3;
                  var6[var9 + 1] = var1;
                  var6[var9 + 2] = var2 + bn[var8] * var3;
                  var6[var9 + 3] = var0 + bm[var8 + 1] * var3;
                  var6[var9 + 4] = var1;
                  var6[var9 + 5] = var2 + bn[var8 + 1] * var3;
                  var6[var9 + 6] = var4;
                  var6[var9 + 7] = var4;
                  var6[var9 + 8] = var5;
                  var6[var9 + 9] = var5;
                  var6[var9 + 10] = 1.0F;
                  var7++;
               }

               RegionPassCache.nLT = var7;
            }
         }
      } catch (RuntimeException var10) {
         throw var10;
      }
   }

   private static void o(float var0, boolean var1) {

      fv += var0;
      if (fy == 0 && fv >= 0.7F) {
         if (var1) {
            EchoPassCache.d(RegionPassCache.pvX, RegionPassCache.pvZ, RegionPassCache.bp);
            fw = EchoPassCache.hi;
            fx = EchoPassCache.hj;
            fy = 1;
            fv = 0.0F;
         } else {
            fv = 0.7F;
         }
      }

      if (fy == 1) {
         float var2 = fw - 0.2F;
         if (fv < var2) {
            float var3 = fv;
            eq = 1.0F + 20.0F * var3;
            if (fx >= 0.0F) {
               er = var3 >= fx ? 0.0F : 1.0F;
            } else {
               float var4 = (var3 - 1.0F) / 0.25F;
               var4 = var4 < 0.0F ? 0.0F : (var4 > 1.0F ? 1.0F : var4);
               er = 1.0F - var4 * var4 * (3.0F - 2.0F * var4);
            }

            return;
         }

         fy = 2;
         fv -= var2;
      }

      if (fy == 2) {
         float var5 = fv / 0.45F;
         if (var5 >= 1.0F) {
            fy = 0;
            fv -= 0.45F;
            er = 1.0F;
         } else {
            er = var5 * var5 * (3.0F - 2.0F * var5);
         }
      }
   }

   private static void p(double var0, double var2, double var4, PoseStateCache var6) {

      boolean var7 = fy == 1 && EchoPassCache.ac && fv < 1.2F;
      boolean var8 = fy == 2;
      if (var7 || var8) {
         int var9 = RegionPassCache.col(EchoPassCache.pal) & (1269482848 ^ 1263876767);
         if (var7) {
            float var10 = fv;
            float var11 = 0.55F * Math.min(1.0F, var10 / 0.04F) * (float)Math.exp((double)(-var10 / 0.18F));
            int var12 = RegionPassCache.nSB;
            if (var11 > 0.004F && var12 < (1622733831 ^ 1622734343)) {
               float var13 = var6.scale;
               float[] var14 = RegionPassCache.SB;
               int var15 = var12 * 8;
               var14[var15] = (float)(eu - var0);
               var14[var15 + 1] = (float)((double)var6.focusY - var2);
               var14[var15 + 2] = (float)(ev - var4);
               var14[var15 + 3] = 1.08F * (float)(var6.x2 - var6.x1) * 0.5F / var13;
               var14[var15 + 4] = 1.08F * (float)(var6.y2 - var6.y1) * 0.5F / var13;
               var14[var15 + 5] = 0.0F;
               var14[var15 + 6] = 23.0F;
               var14[var15 + 7] = Float.intBitsToFloat(Math.min(-287824217 ^ -287824296, (int)(var11 * 255.0F + 0.5F)) << 24 | var9);
               RegionPassCache.nSB = var12 + 1;
            }
         }

         if (var8) {
            float var16 = fv / 0.45F;
            var16 = var16 < 0.0F ? 0.0F : (var16 > 1.0F ? 1.0F : var16);
            float var18 = 1.0F - var16;
            int var19 = RegionPassCache.nSA;
            if (var18 > 0.0F && var19 < (1016411259 ^ 1016407163)) {
               float[] var20 = RegionPassCache.SA;
               int var21 = var19 * 8;
               var20[var21] = (float)(RegionPassCache.pvX - var0);
               var20[var21 + 1] = (float)(0.9 * (double)er - var2);
               var20[var21 + 2] = (float)(RegionPassCache.pvZ - var4);
               var20[var21 + 3] = 0.55F + 0.45F * var16;
               var20[var21 + 4] = 0.75F + 0.55F * var16;
               var20[var21 + 5] = 0.0F;
               var20[var21 + 6] = 4.0F;
               var20[var21 + 7] = Float.intBitsToFloat((int)(140.0F * var18 * var18) << 24 | var9);
               RegionPassCache.nSA = var19 + 1;
            }
         }
      }
   }

   private static void q(double var0, double var2, double var4, float var6, float var7) {

      assert RegionPassCache.QT.length == (-2007243640 ^ -2007337848)
         && RegionPassCache.nQT >= 0
         && var6 > 0.0F
         && var7 >= 0.0F
         && var7 <= 1.0F
         && !Double.isNaN(var0)
         && !Double.isNaN(var2)
         && !Double.isNaN(var4) : "stage: ba" + "d contract";

      try {
         float[] var8 = RegionPassCache.QT;
         int var9 = RegionPassCache.nQT;
         int var10 = 672318526 ^ 672320449;
         double var11 = eu;
         double var13 = ev;
         float var15 = RegionPassCache.rX;
         float var16 = RegionPassCache.rZ;
         float var18 = -var15;
         float var19 = 0.045F;
         float var20 = 1.0F;
         float var21 = 0.6F / ((var7 > 0.05F ? var7 : 0.05F) * var6);
         if (var19 < var21) {
            var20 = var19 / var21;
            var19 = var21;
         }

         float var22 = var15 * 0.045F;
         float var23 = var16 * 0.045F;
         float var24 = var16 * var19;
         float var25 = var18 * var19;
         float var26 = (float)(0.002F - var2);
         float var27 = 6.7599993F;
         int var28 = (int)Math.floor((var11 - 2.6F) / 0.8F);
         int var29 = (int)Math.ceil((var11 + 2.6F) / 0.8F);
         int var30 = (int)Math.floor((var13 - 2.6F) / 0.8F);
         int var31 = (int)Math.ceil((var13 + 2.6F) / 0.8F);
         int var32 = 0;

         for (int var33 = var28; var33 <= var29; var33++) {
            double var34 = (double)var33 * 0.8F;
            float var36 = (float)(var34 - var11);

            for (int var37 = var30; var37 <= var31; var37++) {
               double var38 = (double)var37 * 0.8F;
               float var40 = (float)(var38 - var13);
               float var41 = (var36 * var36 + var40 * var40) / var27;
               if (var41 < 1.0F && var32 < 40 && var9 < var10) {
                  float var42 = 1.0F - var41;
                  int var43 = (int)(72.0F * var42 * var42 * var20 + 0.5F);
                  if (var43 > 0) {
                     float var44 = (float)(var34 - var0);
                     float var45 = (float)(var38 - var4);
                     float var46 = Float.intBitsToFloat(var43 << 24 | 2048327809 ^ 2060701287);
                     int var47 = var9 * 25;
                     var8[var47] = var44 - var22 - var24;
                     var8[var47 + 1] = var26;
                     var8[var47 + 2] = var45 - var23 - var25;
                     var8[var47 + 3] = var44 + var22 - var24;
                     var8[var47 + 4] = var26;
                     var8[var47 + 5] = var45 + var23 - var25;
                     var8[var47 + 6] = var44 + var22 + var24;
                     var8[var47 + 7] = var26;
                     var8[var47 + 8] = var45 + var23 + var25;
                     var8[var47 + 9] = var44 - var22 + var24;
                     var8[var47 + 10] = var26;
                     var8[var47 + 11] = var45 - var23 + var25;
                     var8[var47 + 12] = 0.0F;
                     var8[var47 + 13] = 0.0F;
                     var8[var47 + 14] = 1.0F;
                     var8[var47 + 15] = 0.0F;
                     var8[var47 + 16] = 1.0F;
                     var8[var47 + 17] = 1.0F;
                     var8[var47 + 18] = 0.0F;
                     var8[var47 + 19] = 1.0F;
                     var8[var47 + 20] = 3.0F;
                     var8[var47 + 21] = var46;
                     var8[var47 + 22] = var46;
                     var8[var47 + 23] = var46;
                     var8[var47 + 24] = var46;
                     var9++;
                     var32++;
                  }
               }
            }
         }

         if (var9 < (-1285833749 ^ -1285837845)) {
            double var49 = RegionPassCache.pvY > 0.0 ? RegionPassCache.pvY : 0.0;
            float var35 = 0.55F * (float)(1.0 + 0.3 * var49);
            float var50 = (float)Math.max(0.0, 1.0 - var49 * 1.2) * er;
            int var51 = (int)(0.45F * var50 * 255.0F + 0.5F);
            float var52 = (float)(RegionPassCache.pvX - var0);
            float var39 = (float)(0.004F - var2);
            float var53 = (float)(RegionPassCache.pvZ - var4);
            float var54 = Float.intBitsToFloat(var51 << 24);
            int var55 = var9 * 25;
            var8[var55] = var52 - var35;
            var8[var55 + 1] = var39;
            var8[var55 + 2] = var53 - var35;
            var8[var55 + 3] = var52 + var35;
            var8[var55 + 4] = var39;
            var8[var55 + 5] = var53 - var35;
            var8[var55 + 6] = var52 + var35;
            var8[var55 + 7] = var39;
            var8[var55 + 8] = var53 + var35;
            var8[var55 + 9] = var52 - var35;
            var8[var55 + 10] = var39;
            var8[var55 + 11] = var53 + var35;
            var8[var55 + 12] = 0.0F;
            var8[var55 + 13] = 0.0F;
            var8[var55 + 14] = 1.0F;
            var8[var55 + 15] = 0.0F;
            var8[var55 + 16] = 1.0F;
            var8[var55 + 17] = 1.0F;
            var8[var55 + 18] = 0.0F;
            var8[var55 + 19] = 1.0F;
            var8[var55 + 20] = 4.0F;
            var8[var55 + 21] = var54;
            var8[var55 + 22] = var54;
            var8[var55 + 23] = var54;
            var8[var55 + 24] = var54;
            var9++;
         }

         RegionPassCache.nQT = var9;
      } catch (RuntimeException var48) {
         throw var48;
      }
   }

   private static int r(double var0, double var2, double var4, float var6) {

      assert RegionPassCache.LA.length == (1539737996 ^ 1539828108)
         && RegionPassCache.nLA >= 0
         && bm.length == 37
         && bn.length == 37
         && ed.length == 8
         && eh.length == 8
         && eg.length == 8
         && ei.length == 8
         && ee.length == 8
         && ef.length == 8
         && en.length == 4
         && eo.length == 4
         && ep.length == 4
         && var6 > 0.0F
         && !Double.isNaN(var0)
         && !Double.isNaN(var2)
         && !Double.isNaN(var4) : "hu" + "dRings: bad cont" + "ract";

      int var7 = RegionPassCache.nLA;

      try {
         float[] var8 = RegionPassCache.LA;
         int var9 = var7;
         int var10 = RegionPassCache.bw;
         float var11 = RegionPassCache.cb;
         float var12 = var11 > 2.0F ? var11 : 2.0F;
         float var13 = 1.0F / (var6 * 0.22F);
         int var14 = (int)(ek + 0.5F);
         int var15 = (int)(el + 0.5F);
         int var16 = (int)(em + 0.5F);
         var14 = var14 < 0 ? 0 : (var14 > (1328225271 ^ 1328225032) ? 1396273485 ^ 1396273586 : var14);
         var15 = var15 < 0 ? 0 : (var15 > (-1699137477 ^ -1699137340) ? 1220341498 ^ 1220341253 : var15);
         var16 = var16 < 0 ? 0 : (var16 > (12967846 ^ 12967769) ? -1895053272 ^ -1895053097 : var16);
         int var17 = var14 << 16 | var15 << 8 | var16;
         int var18 = Math.min(1328563662 ^ 1328563505, var14 + 40) << 16
            | Math.min(-1596159417 ^ -1596159304, var15 + 40) << 8
            | Math.min(1523140544 ^ 1523140415, var16 + 40);
         float var19 = (float)(0.02F - var2);

         for (int var20 = 0; var20 < 8; var20++) {
            float var21 = eh[var20];
            if (var21 > 0.0F) {
               double var22 = dm - ed[var20];
               if (var22 > (double)(var21 + 0.09F)) {
                  eh[var20] = 0.0F;
               } else {
                  float var24 = ei[var20] * eg[var20];
                  int var25 = 0;
                  float var26 = (float)(var22 / (double)var21);
                  if (var26 >= 0.0F && var26 < 1.0F) {
                     float var27 = 1.0F - var26;
                     float var28 = 1.0F - var27 * var27 * var27;
                     float var29 = var26 < 0.3F ? 1.0F : (1.0F - var26) / 0.7F;
                     var29 = var29 < 0.0F ? 0.0F : (var29 > 1.0F ? 1.0F : var29);
                     var29 = var29 * var29 * (3.0F - 2.0F * var29);
                     int var30 = (int)(var29 * 210.0F);
                     if (var30 > 4) {
                        float var31 = 0.15F + var28 * var24;
                        float var32 = var11 * (1.0F - 0.3F * var28);
                        var32 = var32 > 2.0F ? var32 : 2.0F;
                        if (var10 == 1) {
                           en[var25] = var31;
                           eo[var25] = var12 * 3.0F;
                           ep[var25] = (int)((float)var30 * 0.16F) << 24 | var17;
                           var25++;
                           en[var25] = var31;
                           eo[var25] = var12 * 2.0F;
                           ep[var25] = (int)((float)var30 * 0.32F) << 24 | var17;
                           var25++;
                           en[var25] = var31;
                           eo[var25] = var32;
                           ep[var25] = var30 << 24 | var18;
                           var25++;
                        } else {
                           en[var25] = var31;
                           eo[var25] = var32;
                           ep[var25] = var30 << 24 | var17;
                           var25++;
                        }
                     }
                  }

                  if (var10 == 2) {
                     float var41 = (float)((var22 - 0.09F) / (double)var21);
                     if (var41 >= 0.0F && var41 < 1.0F) {
                        float var43 = 1.0F - var41;
                        float var47 = 1.0F - var43 * var43 * var43;
                        float var49 = var41 < 0.3F ? 1.0F : (1.0F - var41) / 0.7F;
                        var49 = var49 < 0.0F ? 0.0F : (var49 > 1.0F ? 1.0F : var49);
                        var49 = var49 * var49 * (3.0F - 2.0F * var49);
                        int var53 = (int)(var49 * 157.0F);
                        if (var53 > 4) {
                           en[var25] = (0.15F + var47 * var24) * 0.62F;
                           eo[var25] = var12;
                           ep[var25] = var53 << 24 | var17;
                           var25++;
                        }
                     }
                  }

                  float var42 = (float)(ee[var20] - var0);
                  float var44 = (float)(ef[var20] - var4);

                  for (int var48 = 0; var48 < var25 && var9 + 36 <= (1444521120 ^ 1444512928); var48++) {
                     float var52 = en[var48];
                     float var54 = eo[var48] * var13;
                     float var56 = Float.intBitsToFloat(ep[var48]);

                     for (int var33 = 0; var33 < 36; var33++) {
                        int var34 = var9 * 11;
                        var8[var34] = var42 + bm[var33] * var52;
                        var8[var34 + 1] = var19;
                        var8[var34 + 2] = var44 + bn[var33] * var52;
                        var8[var34 + 3] = var42 + bm[var33 + 1] * var52;
                        var8[var34 + 4] = var19;
                        var8[var34 + 5] = var44 + bn[var33 + 1] * var52;
                        var8[var34 + 6] = var54;
                        var8[var34 + 7] = var54;
                        var8[var34 + 8] = var56;
                        var8[var34 + 9] = var56;
                        var8[var34 + 10] = 1.0F;
                        var9++;
                     }
                  }
               }
            }
         }

         RegionPassCache.nLA = var9;
         return var9 - var7;
      } catch (RuntimeException var35) {
         throw var35;
      }
   }

   static {
      for (int var0 = 0; var0 <= 36; var0++) {
         double var1 = (Math.PI * 2) * (double)(var0 % 36) / 36.0;
         bm[var0] = (float)Math.cos(var1);
         bn[var0] = (float)Math.sin(var1);
      }

      POPUP = new PoseStateCache();
      INSPECT = new PoseStateCache();
      dq = -1;
      eb = 1;
      ec = new float[9];
      ed = new double[8];
      ee = new double[8];
      ef = new double[8];
      eg = new float[8];
      eh = new float[8];
      ei = new float[8];
      en = new float[4];
      eo = new float[4];
      ep = new int[4];
      er = 1.0F;
      fa = 180.0F;
      fd = new float[8];
      fp = -1.0F;
      fs = -1.0F;
      ft = 1.1F;
      LBX = new float[2];
      LBY = new float[2];
      LBT = new int[2];
      LBC = new int[2];
      LBP = new int[2];
      fw = 1.6F;
      fx = -1.0F;
   }
}
