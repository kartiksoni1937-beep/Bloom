package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.element;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import it.unimi.dsi.fastutil.objects.Object2FloatOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import java.awt.Desktop;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Path;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Map.Entry;
import net.caffeinemc.mods.lithium.lattice.bundle.overlay.element.SortableComposer;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.channel.ConfigBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BuilderFactory;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.BundleSync;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.ParserEngine;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.SyncDispatcher;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.BlockCalculator;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.BlockSetE;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.CheckerBridge;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.DialEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.InitAdapter;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.ItemDescriptor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.MaskEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.PlacementEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.SlotEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.SpanEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.TextEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.scope.buffer.TimingEntry;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.BevelPassCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.BlurPaneCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.FieldVolumeCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.HudFont;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.LockD;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.NoticeQueue;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.PosePassCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.RegionPassCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.SceneLayerCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.SyncController;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard.ThemeCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.EventCycleHandler;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.PoolCoordProvider;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.SortCacheUnit;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.SortComparator;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.StepCacheWalker;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.socket.ViewCacheIndex;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.CoreZoneProcessor;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.NodeFilterCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.NodeZoneRenderer;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.NoticeZoneCache;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.StepZoneIterator;
import net.caffeinemc.mods.lithium.lattice.bundle.pipeline.vertex.resource.WrapZoneProvider;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.util.Window;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.client.util.DefaultSkinHelper;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.sound.SoundManager;
import net.minecraft.client.input.CharInput;
import net.minecraft.client.input.KeyInput;
import net.minecraft.client.gui.Click;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.text.Text;
import net.minecraft.text.Style;
import net.minecraft.util.Identifier;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
import net.minecraft.resource.Resource;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Smoother;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.render.Camera;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.MutableText;
import net.minecraft.text.OrderedText;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.gui.PlayerSkinDrawer;
import net.minecraft.client.gui.ScreenRect;
import net.minecraft.entity.player.SkinTextures;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fStack;
import org.lwjgl.glfw.GLFW;
import net.minecraft.client.font.TextRenderer;import net.minecraft.entity.Entity;import net.minecraft.text.StyleSpriteSource;
public final class LoaderDelegate extends Screen {
   public static final MinecraftClient a = MinecraftClient.getInstance();
   private static final int xn = 24;
   private static final int xo = 17;
   private static final int xp = 18;
   private static final int xq = 5;
   private static final int xr = 360;
   private static final ParserEngine[] xs = ParserEngine.values();
   private static int xt;
   private static int xu;
   private static int xv;
   private static int xw;
   private static int xx;
   private static int xy;
   private static int xz;
   private static int ya;
   private static int yb;
   private static int yc;
   private static int yd;
   private static int ye;
   private static int yf;
   private static int yg;
   private static int yh;
   private static int yi;
   private static int yj;
   private static int yk;
   private static int yl;
   private static int ym;
   private static int yn;
   private static int yo;
   private static int yp;
   private static int yq;
   private static int yr;
   private static int ys;
   private static int yt;
   private static int yu;
   private static boolean yv;
   private static final double yw = 0.08;
   private static final boolean yx = true;
   private static float yy = 1.0F;
   private static int yz;
   private static int za;
   private static int zb;
   private static int zc;
   private static int zd;
   private static int ze;
   private static int zf;
   private static int zg;
   private static int zh;
   private static int zi;
   private static int zj;
   private static boolean zk;
   private static int zl;
   private static int zm;
   private static int zn;
   private static int zo;
   private static int zp;
   private static int zq;
   private static int zr;
   private static int zs;
   private static int zt;
   private static int zu;
   private static int zv;
   private static int zw;
   private static int zx;
   private static final int zy = -37711;
   private static int zz;
   private static int aaa;
   private static int aab;
   private static int aac;
   private static int aad;
   private static int aae;
   private static int aaf;
   private static int aag;
   private static int aah;
   private static int aai;
   private static double aaj;
   private static double aak;
   private static double aal;
   private static int aam;
   private static int aan;
   private static int aao;
   private static int aap;
   private static int aaq;
   private static int aar;
   private static int aas;
   private static final int aat = -855819;
   private static final int aau = -1460868368;
   private static final int aav = -2048070928;
   private static final int aaw = 1626139376;
   private static final int aax = 486539263;
   private static final int aay = 452984831;
   private static final int aaz = 335544319;
   private static final int aba = 570425343;
   private static final int abb = 268435455;
   private static final int abc = 402653183;
   private static final int abd = 352321535;
   private static final int abe = 939524096;
   private static final int abf = 452984831;
   private static final int abg = 184549375;
   private static final int abh = 301989887;
   private static final int abi = 855638016;
   private static final int abj = 620756991;
   private static final int abk = 570425343;
   private static final int abl = -329220;
   private static final int abm = 1963197190;
   private static final String[] abn = new String[]{"I'm getting SS'ed", "GUI Settings", "Configs"};
   private static final String[] abo = new String[]{"§lbloom", "v2.2", "Search modules...", " result(s)"};
   private static final String[] abp = new String[]{
      "A" + "n" + "onymo" + "us",
      "Unknown",
      "???",
      "Licensed",
      "Lifetime",
      "Expires today",
      "1 " + "day l" + "eft",
      " days left",
      "_",
      "×",
      "...",
      "All",
      "1 block",
      " blocks"
   };
   private static final String[] abq = new String[]{"None", "RSHIFT", "LSHIFT", "RCTRL", "LCTRL", "SPACE", "TAB", "LMB", "RMB", "MMB", "M", "Key "};
   private int abr = 130;
   private final Map<ParserEngine, Integer> abs = new HashMap<>();
   private final Map<ParserEngine, Integer> abt = new HashMap<>();
   private final Map<ParserEngine, Integer> abu = new HashMap<>();
   private final Set<ParserEngine> abv = new HashSet<>();
   private final Set<BuilderFactory> abw = new HashSet<>();
   private boolean abx = false;
   private String aby = "";
   private final List<BuilderFactory> abz = new ArrayList<>();
   private int aca = 0;
   private ParserEngine acb = null;
   private int acc;
   private int acd;
   private BlockCalculator ace = null;
   private int acf = 0;
   private int acg = 130;
   private int ach = 0;
   private float aci = 0.0F;
   private float acj = 0.0F;
   private float ack = Float.NaN;
   private BlockCalculator acl = null;
   private int acm;
   private int acn;
   private float aco;
   private boolean acp;
   private boolean acq;
   private ItemDescriptor acr = null;
   private int acs = -1;
   private BlockCalculator act = null;
   private String acu = "";
   private boolean acv = false;
   private static final String[] acw = new String[]{"min ", "   max ", "Enter apply   Es" + "c c" + "anc" + "el", "ms"};
   private NodeZoneRenderer acx = null;
   private int acy = -1;
   private boolean acz = false;
   private CoreZoneProcessor ada = null;
   private static final String[] adb = new String[]{
      "HUD",
      "Edit Layout",
      "Done",
      "Only on / off: Edit Layout plac" + "es it",
      "Edit HUD La" + "yout",
      "Drag the card" + "s. Turn it " + "off in GUI S" + "ettings"
   };
   private int adc;
   private int add;
   private int ade;
   private int adf;
   private static boolean adg = false;
   private static final Object adh = new Object();
   private boolean adi = false;
   private boolean adj = false;
   private double adk = 2.0;
   private boolean adl = false;
   private int adm = -1;
   private BuilderFactory adn = null;
   private List<String> ado = new ArrayList<>();
   private String adp = "";
   private String adq = "";
   private boolean adr = false;
   private TextEntry ads = null;
   private BlockSetE adt = null;
   private MaskEntry adu = null;
   private DialEntry adv = null;
   private boolean adw = false;
   private boolean adx = false;
   private int ady = 0;
   private int adz = 0;
   private boolean aea = false;
   private boolean aeb = false;
   private boolean aec = false;
   private boolean aed = false;
   private int aee = -1;
   private boolean aef = false;
   private float aeg;
   private float aeh;
   private int aei = -1;
   private final float[] aej = new float[5];
   private static final float aek = 6.0F;
   private boolean ael = false;
   private long aem = 0L;
   private static final long aen = 250000000L;
   private boolean aeo = false;
   private float aep = 1.0F;
   private float aeq = 1.0F;
   private int aer = -1;
   private float aes = 1.0F;
   private long aet = 0L;
   private static final long[] aeu = new long[]{70000000L, 35000000L, 0L, 35000000L, 70000000L};
   private static final long aev = 105000000L;
   private static final float aew = 0.05F;
   private static final float aex = 1.75F;
   private static final float[] aey = new float[]{0.8F, 1.0F, 1.25F};
   private static final float aez = 0.35F;
   private static boolean afa = false;
   private final int[] afb = new int[]{-1, -1, -1, -1, -1};
   private int afc = -1;
   private final int[] afd = new int[13];
   private final float[] afe = new float[13];
   private final int[] aff = new int[13];
   private int afg;
   private static final Matrix3x2f afh = new Matrix3x2f();
   private int afi = -1;
   private boolean afj = false;
   private ClientWorld afk = null;
   private float afl = 0.0F;
   private boolean afm = false;
   private long afn = 0L;
   private boolean afo = false;
   private boolean afp = true;
   private final int[] afq = new int[7];
   private final boolean[] afr = new boolean[7];
   private int afs = 0;
   private int aft = -1;
   private float afu = -1.0F;
   private final int[] afv = new int[6];
   private int afw = 0;
   private int afx = 0;
   private int afy = 0;
   private static final int afz = 44;
   private static final int aga = 0;
   private static final Object agb = new Object();
   private BlockCalculator agc = null;
   private NodeZoneRenderer agd = null;
   private CoreZoneProcessor age = null;
   private BlockSetE agf = null;
   private MaskEntry agg = null;
   private DialEntry agh = null;
   private static float agi = 1.0F;
   private static final float agj = 0.72F;
   private static final String[] agk = new String[]{
      "Themes",
      "Search",
      "Classic",
      "Position it in Classic view",
      "Point at a panel and click, like the normal GUI",
      "３Ｄ Ｍｅｎｕ",
      "３Ｄ ＧＵＩ",
      "Ｄｅｐｔｈ " + "ｏ" + "ｆ Ｆｉｅｌｄ",
      "Ｍｅｎｕ" + " " + "Ａｍｂｉｅ" + "ｎｃｅ",
      "Ｒｅｄｕｃｅ" + " Ｍｏｔｉｏｎ",
      "Ｃｌｏｓｅ Ｏｎ Ｄａｍ" + "ａｇｅ",
      "3D m" + "enu disab" + "l" + "ed",
      "It hit" + " an error. Re" + "start the game to re-enable it",
      "3D menu pau" + "sed",
      "lithium",
      "gui_o",
      "Turn of" + "f Edit" + " HUD Layout to use the 3D GUI",
      "Menu out" + " o" + "f" + " view",
      "Midd" + "le-click to bring the menu back"
   };
   private static final int agl = 48;
   private static HashMap<ParserEngine, Integer> agm = null;
   private static HashMap<ParserEngine, Integer> agn = null;
   private static HashMap<ParserEngine, Integer> ago = null;
   private static HashSet<ParserEngine> agp = null;
   private static HashSet<BuilderFactory> agq = null;
   private static int agr = -1;
   private static int ags = -1;
   private static int agt = -1;
   private static final float agu = 0.625F;
   private final Map<ParserEngine, List<BuilderFactory>> agv = new HashMap<>();
   private int agw = -1;
   private int agx = 0;
   private static final int agy = 10;
   private static final char[][] agz = new char[3][];
   private static final int[] aha = new int[3];
   private static final int ahb = 10;
   private static final Style[] ahc;
   private static int ahd;
   private static Style ahe;
   private static final Map<String, Text> ahf;
   private final Object2IntOpenHashMap<String> ahg = new Object2IntOpenHashMap();
   private static int ahh;
   private static int ahi;
   private static boolean ahj;
   private static final String[] ahk;
   private static boolean ahl;
   private static float ahm;
   private static final Style[] ahn;
   private static final HashMap<String, Text>[] aho;
   private int ahp = -1;
   private static boolean ahq;
   private static boolean ahr;
   private static boolean ahs;
   private static PaneGlassCache aht;
   private static final PaneGlassCache[] ahu;
   private static final PaneGlassCache[] ahv;
   private static final Identifier ahw;
   private static final int ahx = 128;
   private static boolean ahy;
   private static final int ahz = 10;
   private static boolean aia;
   private static int aib;
   private static final float aic = 0.66F;
   private static final float aid = 0.62F;
   private static final float aie = 0.8F;
   private static final int aif = 1342177280;
   private static final int aig = 805306368;
   private static final int aih = 939524096;
   private static final float aii = 8.0F;
   private static final float aij = 2.0F;
   private static int aik;
   private static final float ail = 10.0F;
   private static boolean aim;
   private static boolean ain;
   private static float aio;
   private static float aip;
   private static PaneGlassCache aiq;
   private static PaneGlassCache air;
   private int ais = 0;
   private static final Identifier ait;
   private static final int aiu = 32;
   private static boolean aiv;
   private final Object2FloatOpenHashMap<Object> aiw = new Object2FloatOpenHashMap();
   private final Object2FloatOpenHashMap<Object> aix = new Object2FloatOpenHashMap();
   private final Object2FloatOpenHashMap<Object> aiy = new Object2FloatOpenHashMap();
   private final Object2FloatOpenHashMap<Object> aiz = new Object2FloatOpenHashMap();
   private final Object2FloatOpenHashMap<Object> aja = new Object2FloatOpenHashMap();
   private final Object2FloatOpenHashMap<Object> ajb = new Object2FloatOpenHashMap();
   private final Object2FloatOpenHashMap<Object> ajc = new Object2FloatOpenHashMap();
   private final Object2FloatOpenHashMap<Object> ajd = new Object2FloatOpenHashMap();
   private static final Object aje;
   private long ajf = 0L;
   private float ajg = 0.016666668F;
   private int ajh = 0;
   private static final float aji = 21.0F;
   private static final float ajj = 24.0F;
   private static final float ajk = 24.0F;
   private static final float ajl = 28.0F;
   private static final float ajm = 19.0F;
   private static final float ajn = 24.0F;
   private static final float ajo = 25.0F;
   private static final float ajp = 16.0F;
   private float ajq = 0.0F;
   private static final int[] ajr;
   private static final int[] ajs;
   private static int ajt;
   private BuilderFactory aju = null;
   private long ajv = 0L;
   private float ajw = 0.0F;
   private BuilderFactory ajx = null;
   private float ajy = 1.0F;
   private boolean ajz = false;
   private static final int[] aka;
   private float akb = 0.0F;
   private long akc = 0L;
   private static final float akd = 0.24F;
   private boolean ake = false;
   private static final float[] akf;
   private static final int[] akg;
   private static final float akh = 10.0F;
   private static final String aki;
   private static final float akj = 1.5F;
   private final int[] akk = new int[]{-1, -1, -1, -1, -1, -1, -1, -1};
   private final int[] akl = new int[]{-1, -1, -1, -1, -1, -1, -1, -1};
   private final int[] akm = new int[8];
   private final String[] akn = new String[8];
   private int ako = -1;
   private static final String[] akp;
   private final int[] akq = new int[512];
   private int akr = -1;
   private final Object2IntOpenHashMap<Object> aks = new Object2IntOpenHashMap();
   private int akt = -1;
   private static final int aku = 9;
   private static final int akv = 26;
   private static final int akw = 10;
   private static final int akx = 12;
   private static final int aky = 8;
   private static final int akz = 4;
   private static final Object[] ala;
   private static final Object alb;
   private static final Object alc;
   private static final Object ald;
   private static final String[] ale;
   private final int[] alf = new int[3];
   private final int[] alg = new int[3];
   private int alh;
   private int ali;
   private int alj;
   private boolean alk;
   private boolean all;
   private String alm = null;
   private int aln = 0;
   private static final int alo = 6;
   private static final Identifier alp;
   private static String alq;
   private static boolean alr;
   private static final String[] als;
   private int alt = Integer.MIN_VALUE;
   private String alu = "";
   private static final String[] alv;
   private static final int alw = 16;
   private static final int alx = 40;
   private static final int aly = 48;
   private static final int alz = 22;
   private static final int ama = 184549375;
   private static final int amb = 318767103;
   private static final int amc = 486539263;
   private static final int amd = 335544319;
   private static final int ame = 570425343;
   private static final int amf = 939524096;
   private static final int amg = 855638016;
   private static final int amh = 452984831;
   private static final int ami = -1017216;
   private static final int amj = 619470952;
   private static final int amk = 1307336808;
   private static final int aml = -2735538;
   private static int amm;
   private static int amn;
   private static int amo;
   private static int amp;
   private static int amq;
   private static int amr;
   private static int ams;
   private static int amt;
   private static int amu;
   private static int amv;
   private static int amw;
   private static int amx;
   private static int amy;
   private static int amz;
   private static final String[] ana;
   private static final Object anb;
   private int anc = 0;
   private int and = 388;
   private int ane = 446;
   private static final int anf = 0;
   private static final int ang = 1;
   private static final int anh = 2;
   private static final int ani = 3;
   private static final int anj = 4;
   private static final int ank = 5;
   private static final int anl = 6;
   private static final IdentityHashMap<String, String> anm;
   private static final String[] ann;
   private final float[] ano = new float[10];
   private float anp = 0.0F;
   private int anq = -1;
   private boolean anr = false;
   private static final char ans = '\ue700';
   private static final HashMap<String, String> ant;
   private static final String[] anu;
   private static final int anv = 256;
   private static final int anw = 254;
   private static final int anx = 440;
   private static final int any = 30;
   private static final int anz = 28;
   private static final int aoa = 6;
   private static final int aob = 21;
   private static final int aoc = 19;
   private static final int aod = 5;
   private static final int aoe = 7;
   private static final int aof = 12;
   private static final int aog = 12;
   private static final int aoh = 15;
   private static final int aoi = 1;
   private static final int aoj = 2;
   private static final int aok = 5;
   private static final int aol = 6;
   private static final int aom = 7;
   private static final int aon = 8;
   private static final int aoo = 9;
   private static final int aop = 10;
   private static final int aoq = 0;
   private static final int aor = 1;
   private static final int aos = 2;
   private static final int aot = 3;
   private static final int aou = 4;
   private static final int aov = 5;
   private static final int aow = 6;
   private static final int aox = 7;
   private static final int aoy = 8;
   private static final int aoz = 9;
   private static final int apa = 10;
   private static final int apb = 11;
   private static final int apc = 12;
   private static final int apd = 13;
   private static final int ape = 14;
   private static final int apf = 15;
   private static final int apg = 16;
   private static final int aph = 17;
   private static final int api = 18;
   private static final int apj = 19;
   private static final int apk = 20;
   private static final int apl = 21;
   private static final int apm = 22;
   private static final int apn = 23;
   private static final int apo = 24;
   private static final int app = 25;
   private static final int apq = 26;
   private static final int apr = 27;
   private static final int aps = 28;
   private static final int[] apt;
   private static final int apu;
   private static final int apv = 5;
   private static final String[] apw;
   private static final String[] apx;
   private static final String[] apy;
   private static final String[] apz;
   private static final String[] aqa;
   private static final int aqb = 16;
   private static final int[] aqc;
   private static final int[] aqd;
   private static final int[] aqe;
   private static final int[] aqf;
   private static final int[] aqg;
   private static final int[] aqh;
   private static final int[] aqi;
   private static final int[] aqj;
   private static final int[] aqk;
   private static final int[] aql;
   private static final int[] aqm;
   private static final int aqn;
   private static final int aqo = 21;
   private static final int aqp = 30;
   private static final int aqq = 50;
   private static final float aqr = 52.0F;
   private static final int aqs = 123;
   private static final int aqt = 118;
   private static final int aqu = 232;
   private static final float aqv = 12.0F;
   private static final float aqw = 192.0F;
   private static final float aqx = 72.0F;
   private static final float aqy = 36.0F;
   private static final int aqz = 28;
   private static final int ara = 29;
   private static final Object[] arb;
   private static final Object[] arc;
   private static final Object[] ard;
   private static final Object[] are;
   private static final Object[] arf;
   private static final Object[] arg;
   private static final Object arh;
   private static final Object ari;
   private int arj = 0;
   private int ark = -1;
   private float arl = 0.0F;
   private int arm = 0;
   private float arn = 0.0F;
   private int aro = 0;
   private float arp = 0.0F;
   private int arq = 0;
   private float arr = 0.0F;
   private int ars = 334;
   private int art = 0;
   private float aru = 0.0F;
   private int arv = 0;
   private long arw = 0L;
   private int arx = -1;
   private int ary = -1;
   private int arz = -2;
   private float asa = 0.0F;
   private int asb = -1;
   private final float[] asc = new float[10];
   private final int[] asd = new int[28];
   private int ase = -1;
   private final String[] asf = new String[28];
   private final int[] asg = new int[28];
   private final String[] ash = new String[29];
   private final int[] asi = new int[29];
   private int asj = -1;
   private final int[] ask = new int[8];
   private final int[] asl = new int[8];
   private final int[] asm = new int[8];
   private int asn = -1;
   private int aso = -1;
   private int asp = -1;
   private String asq = "";
   private final float[][] asr = new float[][]{{0.0F, 0.0F, 0.0F}, {0.0F, 0.0F, 0.0F}};
   private final int[] ass = new int[]{-1, -1};
   private static final int ast = 1543503872;
   private static final int asu = 1073741824;
   private static int asv;
   private static int asw;
   private static int asx;
   private static int asy;
   private static int asz;
   private float ata = 0.0F;
   private float atb = 0.0F;
   private static final int atc = 0;
   private static final int atd = 2;
   private static final String[] ate;
   private static final int atf = 464;
   private static final int atg = 640;
   private static final int ath = 254;
   private static final int ati = 428;
   private static final int atj = 16;
   private static final int atk = 22;
   private static final int atl = 26;
   private static final int atm = 2;
   private static final int atn = 3;
   private static final int ato = 4;
   private static final int atp = 5;
   private static final String[] atq;
   private static final int atr = 0;
   private static final int ats = 1;
   private static final int att = 2;
   private static final int atu = 3;
   private static final int atv = 4;
   private static final int atw = 5;
   private static final int atx = 6;
   private static final int aty = 7;
   private static final int atz = 8;
   private static final int aua = 9;
   private static final int aub = 10;
   private static final int auc = 11;
   private static final int aud = 12;
   private static final int aue = 13;
   private static final int auf = 14;
   private static final int aug = 15;
   private static final int auh = 16;
   private static final int aui = 17;
   private static final int auj = 18;
   private static final int auk = 19;
   private static final int aul = 20;
   private static final int aum = 21;
   private static final int aun = 22;
   private static final int auo = 23;
   private static final int aup = 24;
   private static final int auq = 25;
   private static final int aur = 26;
   private static final int aus = 27;
   private static final int aut = 28;
   private static final int auu = 29;
   private static final int auv = 30;
   private static final int auw = 31;
   private static final int aux = 32;
   private static final int auy = 33;
   private static final int auz = 34;
   private static final int ava = 35;
   private static final int avb = 36;
   private static final int avc = 37;
   private static final int avd = 38;
   private static final int ave = 39;
   private static final int avf = 40;
   private static final int avg = 41;
   private static final int avh = 42;
   private static final int avi = 43;
   private static final int avj = 44;
   private static final int avk = 45;
   private static final int avl = 46;
   private static final int avm = 47;
   private static final int avn = 48;
   private static final int avo = 49;
   private static final int avp = 50;
   private static final int avq = 51;
   private static final int avr = 52;
   private static final int avs = 53;
   private static final int avt = 54;
   private static final int avu = 55;
   private static final int avv = 56;
   private static final int avw = 57;
   private static final int avx = 58;
   private static final int avy = 59;
   private static final int avz = 60;
   private static final int awa = 61;
   private static final int awb = 62;
   private static final int awc = 63;
   private static final int awd = 64;
   private static final int awe = 65;
   private static final int awf = 66;
   private static final int awg = 67;
   private static final int awh = 68;
   private static final int awi = 69;
   private static final int awj = 70;
   private static final int awk = 71;
   private static final int awl = 72;
   private static final int awm = 73;
   private static final int awn = 74;
   private static final int awo = 75;
   private static final int awp = 76;
   private static final int awq = 77;
   private static final int awr = 78;
   private static final int aws = 79;
   private static final int awt = 80;
   private static final int awu = 81;
   private static final int awv = 82;
   private static final int aww = 83;
   private static final int awx = 84;
   private static final int awy = 85;
   private static final int awz = 86;
   private static final int axa = 87;
   private static final int axb = 88;
   private static final int axc = 89;
   private static final int axd = 90;
   private static final int axe = 91;
   private static final int axf = 92;
   private static final String[] axg;
   private static final int axh = 0;
   private static final int axi = 1;
   private static final int axj = 2;
   private static final int axk = 3;
   private static final int axl = 4;
   private static final int axm = 5;
   private static final int axn = 6;
   private static final int axo = 7;
   private static final int axp = 8;
   private static final int axq = 9;
   private static final int axr = 10;
   private static final int axs = 11;
   private static final int axt = 12;
   private static final int axu = 13;
   private static final int axv = 14;
   private static final int axw = 15;
   private static final int axx = 16;
   private static final int axy = 17;
   private static final int axz = 18;
   private static final int aya = 19;
   private static final int ayb = 20;
   private static final int ayc = 21;
   private static final int ayd = 22;
   private static final int aye = 23;
   private static final int ayf = 24;
   private static final int ayg = 25;
   private static final int ayh = 26;
   private static final int ayi = 27;
   private static final int ayj = 28;
   private static final int ayk = 29;
   private static final int ayl = 30;
   private static final int aym = 31;
   private static final int ayn = 32;
   private static final int ayo = 33;
   private static final int ayp = 34;
   private static final int ayq = 35;
   private static final int ayr = 36;
   private static final int ays = 37;
   private static final int ayt = 38;
   private static final int ayu = 39;
   private static final int ayv = 40;
   private static final int ayw = 41;
   private static final int ayx = 42;
   private static final int ayy = 43;
   private static final int ayz = 44;
   private static final int aza = 45;
   private static final int azb = 46;
   private static final int azc = 47;
   private static final int azd = 48;
   private static final int aze = 49;
   private static final int azf = 50;
   private static final int azg = 51;
   private static final int azh = 52;
   private static final int azi = 53;
   private static final int azj = 54;
   private static final int azk = 55;
   private static final int azl = 56;
   private static final int azm = 57;
   private static final int azn = 58;
   private static final int azo = 59;
   private static final int azp = 60;
   private static final int azq = 61;
   private static final int azr = 62;
   private static final int azs = 63;
   private static final int azt = 64;
   private static final int azu = 65;
   private static final int azv = 66;
   private static final int azw = 67;
   private static final int azx = 68;
   private static final int azy = 69;
   private static final int azz = 70;
   private static final int baa = 71;
   private static final int bab = 72;
   private static final int bac = 73;
   private static final int bad = 74;
   private static final int bae = 75;
   private static final int baf = 76;
   private static final int bag = 77;
   private static final int bah = 78;
   private static final int bai = 79;
   private static final int baj = 80;
   private static final int bak = 81;
   private static final int bal = 82;
   private static final int bam = 83;
   private static final int ban = 84;
   private static final int bao = 85;
   private static final int bap = 86;
   private static final int baq = 87;
   private static final int bar = 88;
   private static final int bas = 89;
   private static final int bat = 90;
   private static final int bau = 91;
   private static final int bav = 92;
   private static final int baw = 93;
   private static final int bax = 94;
   private static final int bay = 95;
   private static final int baz = 96;
   private static final int bba = 97;
   private static final String[] bbb;
   private int bbc = 0;
   private String bbd = "";
   private boolean bbe = false;
   private String bbf = "";
   private String bbg = "";
   private boolean bbh = false;
   private boolean bbi = false;
   private int bbj = 0;
   private String bbk = "";
   private boolean bbl = false;
   private String bbm = "";
   private boolean bbn = false;
   private int bbo = 0;
   private float bbp = 0.0F;
   private float bbq = 0.0F;
   private float bbr = 0.0F;
   private float bbs = 0.0F;
   private int bbt = 0;
   private int bbu = 0;
   private float bbv = 1.0F;
   private float bbw = 1.0F;
   private String bbx = null;
   private String bby = null;
   private boolean bbz = false;
   private boolean bca = false;
   private int bcb = -1;
   private int bcc = -1;
   private static String bcd;
   private static final ArrayList<String> bce;
   private static int bcf;
   private boolean bcg = false;
   private String bch = "";
   private boolean bci = false;
   private static int bcj;
   private static int bck;
   private String bcl = "";
   private boolean bcm = true;
   private long bcn = 0L;
   private static final long bco = 7000000000L;
   private boolean bcp = true;
   private static int bcq;
   private static JsonObject bcr;
   private static String bcs;
   private static String bct;
   private static String bcu;
   private static String bcv;
   private static boolean bcw;
   private static long bcx;
   private static int bcy;
   private static final long bcz = 10000000000L;
   private String bda = null;
   private String bdb = null;
   private int bdc = -1;
   private int bdd = 52;
   private int bde = 50;
   private int bdf = 48;
   private int bdg = 102;
   private int bdh = 268;
   private int bdi = 364;
   private int bdj = 414;
   private int bdk = 210;
   private int bdl = 26;
   private boolean bdm = false;
   private boolean bdn = false;
   private static final int bdo = 18;
   private final int[] bdp = new int[3];
   private int bdq = -1;
   private int[] bdr = new int[64];
   private int bds = 0;
   private int bdt = 0;
   private List<BundleSync.Entry> bdu = new ArrayList<>();
   private static List<BundleSync.Entry> bdv;
   private static long bdw;
   private String[] bdx = new String[0];
   private String[] bdy = new String[0];
   private String[] bdz = new String[0];
   private byte[][] bea = new byte[0][];
   private JsonObject[] beb = new JsonObject[0];
   private long[] bec = new long[0];
   private int[] bed = new int[0];
   private int bee = 0;
   private int bef = 0;
   private static final int beg = 0;
   private static final int beh = 1;
   private static final int bei = 2;
   private static final int bej = 3;
   private int[] bek = new int[0];
   private int[] bel = new int[0];
   private int[] bem = new int[0];
   private int[] ben = new int[0];
   private String[] beo = new String[0];
   private String[] bep = new String[0];
   private String[] beq = new String[0];
   private int ber = 0;
   private int bes = 0;
   private int bet = 0;
   private int beu = 0;
   private int bev = 0;
   private String bew = "";
   private String bex = "";
   private String bey = "";
   private int bez = -1;
   private int bfa = -1;
   private int bfb = -1;
   private int bfc = -1;
   private int bfd = -1;
   private String bfe = null;
   private List<BundleSync.Entry> bff = null;
   private String[] bfg = new String[0];
   private List<BundleSync.Entry> bfh = null;
   private String bfi = "";
   private int bfj = -1;
   private String[] bfk = new String[0];
   private int bfl = -1;
   private int bfm = -1;
   private String bfn = "";
   private String[] bfo = new String[0];
   private String[] bfp = new String[0];
   private List<BundleSync.Entry> bfq = null;
   private int bfr = -1;
   private int bfs = -1;
   private static final int bft = 1;
   private static final int bfu = 2;
   private static final int bfv = 3;
   private static final int bfw = 4;
   private final int[][] bfx = new int[2][0];
   private final int[][] bfy = new int[2][0];
   private final String[][] bfz = new String[2][0];
   private final int[] bga = new int[2];
   private final int[] bgb = new int[2];
   private final int[] bgc = new int[2];
   private final int[] bgd = new int[2];
   private final int[] bge = new int[2];
   private final String[][] bgf = new String[2][3];
   private final String[] bgg = new String[]{"", ""};
   private static final int bgh = 0;
   private static final int bgi = 1;
   private static final int bgj = 2;
   private static final int bgk = 3;
   private static final int bgl = 4;
   private static final int bgm = 5;
   private static final int bgn = 6;
   private final int[][] bgo = new int[2][0];
   private final int[][] bgp = new int[2][0];
   private final int[][] bgq = new int[2][0];
   private final int[][] bgr = new int[2][0];
   private final InitAdapter[][] bgs = new InitAdapter[2][0];
   private final String[][] bgt = new String[2][0];
   private final String[][] bgu = new String[2][0];
   private final String[][] bgv = new String[2][0];
   private final int[] bgw = new int[2];
   private final int[] bgx = new int[2];
   private int bgy = -2;
   private int bgz = -1;
   private int bha = -1;
   private int bhb = -1;
   private boolean bhc = false;
   private JsonObject bhd = null;
   private int bhe = 0;
   private int bhf = 0;
   private int bhg = 0;
   private int bhh = 0;
   private String bhi = "";
   private String bhj = "";
   private String bhk = "";
   private String bhl = "";
   private String bhm = "";
   private String bhn = "";
   private int bho = -1;
   private int bhp = -1;
   private static final String[] bhq;
   private static final String[] bhr;
   private static final String[] bhs;
   private static final String[] bht;
   private int[] bhu = new int[0];
   private int bhv = -1;
   private int[] bhw = new int[0];
   private int[] bhx = new int[0];
   private int[] bhy = new int[0];
   private int bhz = 0;
   private int bia = 0;
   private int bib = 0;
   private int bic = 0;
   private int bid = 0;
   private String bie = null;
   private int bif = -1;
   private int big = -1;
   private int bih = -1;
   private int bii = -1;
   private int bij = -1;
   private String bik = null;
   private int bil = -1;
   private int bim = -1;
   private String bin = null;
   private String bio = "";
   private String bip = "";
   private String biq = "";
   private int bir = -1;
   private int bis = -1;
   private static final int bit = 0;
   private static final int biu = 1;
   private static final int biv = 2;
   private static final int biw = 3;
   private static final int bix = 4;
   private static final int biy = 5;
   private static final int biz = 6;
   private static final int bja = 7;
   private static final int bjb = 8;
   private static final int bjc = 9;
   private static final int bjd = 10;
   private static final int bje = 11;
   private static final int bjf = 12;
   private static final int bjg = 13;
   private static final int bjh = 14;
   private static final int bji = 15;
   private static final int bjj = 16;
   private static final int bjk = 17;
   private static final int bjl = 18;
   private static final int bjm = 19;
   private static final int bjn = 20;
   private static final int bjo = 21;
   private static final int bjp = 22;
   private static final int bjq = 23;
   private static final int bjr = 24;
   private static final int bjs = 25;
   private static final int bjt = 26;
   private static final int bju = 27;
   private static final int bjv = 28;
   private static final int bjw = 29;
   private static final int bjx = 30;
   private static final Object[] bjy;
   private static final int[] bjz;
   private final int[] bka = new int[32];
   private final float[] bkb = new float[128];
   private int bkc = 0;
   private boolean bkd;
   private boolean bke;
   private boolean bkf;
   private boolean bkg;
   private float bkh;
   private float bki;
   private float bkj;
   private float bkk;
   private float bkl;
   private float bkm;
   private float bkn;
   private float bko;
   private float bkp;
   private float bkq;
   private float bkr;
   private float bks;
   private float bkt;
   private int bku = -1;
   private int bkv = -1;
   private int bkw = 0;
   private int bkx = -1;
   private int bky = -1;
   private int bkz = -1;
   private int bla = 0;
   private int blb = -1;
   private int blc = -1;
   private int bld = -1;
   private int ble;
   private int blf;
   private int blg;
   private int blh;
   private static final Object bli;
   private static final Object blj;
   private static final Object blk;
   private static final Object bll;
   private static final Object blm;
   private static final Object bln;
   private static final Object[] blo;
   private String blp = null;
   private String blq = "";
   private String blr = null;
   private int bls = -1;
   private int blt = -1;
   private String blu = "";
   private String blv = null;
   private int blw = -1;
   private int blx = -1;
   private String bly = null;
   private String blz = "";
   private int bma = -1;
   private int bmb = -1;
   private boolean bmc = false;
   private float bmd;
   private float bme;
   private float bmf;
   private int bmg = -1;
   private String bmh = "";
   private String bmi = "";
   private static final Object[] bmj;
   private static final int bmk = 472;
   private static final int bml = 428;
   private static final int bmm = 8;
   private static final int bmn = 44;
   private static final int bmo = 32;
   private static final int bmp = 150;
   private static final int bmq = 12;
   private static final int bmr = 24;
   private static final int bms = 28;
   private static final int bmt = 28;
   private static final int bmu = 132;
   private static final int bmv = 16;
   private static final int bmw = 13;
   private static final int bmx = 128;
   private static final int bmy = 84;
   private static final int bmz = 335544319;
   private static final int bna = 268435455;
   private static final int bnb = 402653183;
   private static final int bnc = 352321535;
   private static final int bnd = 251658239;
   private static final int bne = 402653183;
   private static final int bnf = 570425343;
   private static final int bng = -329220;
   private static final int bnh = -351466481;
   private static final int bni = 117440511;
   private static final int bnj = 234881023;
   private static final int bnk = 352321535;
   private static final int bnl = -149547751;
   private static final int bnm = 536870911;
   private static final int bnn = 939524096;
   private static final String[] bno;
   private static final String[] bnp;
   private static final String[] bnq;
   private static final String[] bnr;
   private static final String[] bns;
   private static final int[][] bnt;
   private static final int[] bnu;
   private static final int[][] bnv;
   private static final int bnw = 0;
   private static final int bnx = 1;
   private static final int bny = 2;
   private static final int bnz = 3;
   private static final int boa = 4;
   private static final int bob = 48;
   private final int[] boc = new int[48];
   private final int[] bod = new int[48];
   private final int[] boe = new int[48];
   private final int[] bof = new int[48];
   private int bog = 0;
   private int boh = 0;
   private int boi;
   private int boj;
   private int bok;
   private int bol;
   private int bom;
   private int bon;
   private int boo;
   private int bop;
   private int boq;
   private int bor;
   private int bos;
   private static final Object bot;
   private static final Object bou;
   private static final Object bov;
   private static final Object bow;
   private static final Object box;
   private static final Object boy;
   private static final Object boz;
   private static final Object bpa;
   private static final Object bpb;
   private static final Object bpc;
   private static final Object bpd;
   private static final Object bpe;
   private static final Object bpf;
   private static final Object bpg;
   private static final Object[] bph;
   private static final Object[] bpi;
   private static final Object[] bpj;
   private final float[] bpk = new float[4];
   private static int bpl;
   private static int bpm;
   private int bpn = 0;
   private float bpo = 1.0F;
   private boolean bpp = false;
   private float bpq = 1.0F;
   private float bpr = 1.0F;
   private SlotEntry bps = null;
   private int bpt;
   private int bpu;
   private int bpv;
   private int bpw;
   private final IdentityHashMap<Object, String[]> bpx = new IdentityHashMap<>();
   private static final float bpy = 25.0F;
   private final int[] bpz = new int[2];
   private final float[] bqa = new float[2];
   private final int[] bqb = new int[2];
   private int bqc = -1;
   private float bqd = 0.0F;
   private static final String[] bqe;
   private static final int bqf = 136;
   private boolean bqg = false;
   private boolean bqh = false;
   private float bqi = 0.0F;
   private static final int bqj = -15460574;
   private static final int bqk = -16052972;
   private boolean bql = false;
   private float bqm = 0.0F;
   private boolean bqn = false;
   private int bqo = -1;
   private int bqp;
   private int bqq;
   private int bqr;
   private static boolean bqs;
   private static final String[] bqt;
   private long bqu = 0L;
   private static final int bqv = 184;
   private static final int bqw = 16;
   private static final int bqx = 28;
   private static final int bqy = 18;
   private static final int bqz = 28;
   private static final int bra = 4;
   private static final int brb = 184;
   private static final int brc = 126;
   private static final String[] brd;
   private static final int bre = 184;
   private static final int brf = 58;
   private static final int brg = 28;
   private static final int brh = 202;
   private static final String[] bri;
   private static final int[] brj;
   private static final int brk = -11430;
   private static final int brl = 1442822218;
   private static final int brm = -1644046;
   private static final int brn = -4932917;
   private static final int bro = -1710551528;
   private static final int brp = 1728053247;
   private static final int brq = -1929379841;
   private static final int brr = -9459480;
   private static final int brs = -1535137;
   private static final int brt = -15459786;
   private int bru = 0;
   private int brv = -1;
   private int brw = 0;
   private boolean brx = false;
   private final Smoother bry = new Smoother();
   private final Smoother brz = new Smoother();
   private double bsa = 0.0;
   private double bsb = 0.0;
   private long bsc = 0L;
   private static final int bsd = 0;
   private static final int bse = 1;
   private static final int bsf = 2;
   private static final int bsg = 3;
   private static final float bsh = 26.0F;
   private static final float bsi = 38.0F;
   private static final float bsj = 10.0F;
   private final float[] bsk = new float[4];
   private final float[] bsl = new float[4];
   private final int[] bsm = new int[4];
   private final int[] bsn = new int[4];
   private BlockSetE bso = null;
   private MaskEntry bsp = null;
   private DialEntry bsq = null;
   private BlockCalculator bsr = null;
   private String bss = "";
   private boolean bst = false;
   private float bsu = 1.0F;
   private float bsv = 0.0F;
   private static final int bsw = -1073741824;
   private static final float bsx = 1.9F;
   private static final float bsy = 576.0F;
   private float bsz = 1.0F;
   private float bta = 1.0F;
   private static final float btb = 1.3F;
   private long btc = 0L;
   private static final long btd = 1400000000L;
   private int bte = 0;
   private final int[] btf = new int[14];
   private boolean btg = false;
   private int bth = -1;
   private float bti = 2.0F;
   private static final Matrix3x2f btj;
   private static final Matrix3x2f btk;

   public static void applyTheme() {

      int[] var0 = ThemeCache.e();
      int[] var1 = ThemeCache.f();
      int[] var2 = new int[]{255, 255, 255};
      int[] var3 = new int[]{0, 0, 0};
      xt = ThemeCache.m(var1[0], var1[1], var1[2], -39271239 ^ -39271354);
      xu = ThemeCache.mix(var1, var0, 0.07, -1002121097 ^ -1002121080);
      xv = ThemeCache.mix(var1, var0, 0.11, 1352648265 ^ 1352648374);
      xw = xv;
      xx = ThemeCache.mix(var1, var0, 0.16, -2031534723 ^ -2031534698);
      xy = ThemeCache.mix(var3, var1, 0.8, -1603336021 ^ -1603336108);
      xz = ThemeCache.mix(var1, var0, 0.12, -1704328494 ^ -1704328659);
      ya = ThemeCache.m(var0[0], var0[1], var0[2], -1640414352 ^ -1640414321);
      yb = ThemeCache.mix(var1, var0, 0.72, 13937408 ^ 13937663);
      yc = ThemeCache.mix(var1, var0, 0.15, 2113040877 ^ 2113040658);
      yd = ThemeCache.m(var0[0], var0[1], var0[2], 2106294347 ^ 2106294452);
      ye = ThemeCache.m(0, 0, 0, -1609896859 ^ -1609896740);
      yf = yd;
      yg = ThemeCache.mix(var1, var0, 0.24, 1971885947 ^ 1971885956);
      yh = ThemeCache.mix(var1, var0, 0.36, 54563588 ^ 54563835);
      int[] var4 = ThemeCache.l(var2, var0, 0.15);
      yi = ThemeCache.m(var4[0], var4[1], var4[2], 1934362611 ^ 1934362380);
      yj = ThemeCache.mix(ThemeCache.l(var1, var4, 0.52), var0, 0.1, -1952887030 ^ -1952886795);
      yk = ThemeCache.mix(ThemeCache.l(var1, var4, 0.26), var0, 0.15, -948751574 ^ -948751403);
      yl = ThemeCache.mix(ThemeCache.l(var1, var4, 0.66), var0, 0.1, 444883157 ^ 444882986);
      ym = ThemeCache.mix(ThemeCache.l(var1, var4, 0.4), var0, 0.15, -1722474790 ^ -1722474971);
      yn = ThemeCache.mix(var0, var2, 0.25, 1932205654 ^ 1932205737);
      yo = ThemeCache.mix(var0, var2, 0.52, -838561038 ^ -838561267);
      yp = ThemeCache.mix(var0, var2, 0.06, -336704066 ^ -336704171);
      yq = ThemeCache.m(var0[0], var0[1], var0[2], 60);
      yv = SyncController.t;
      if (yv) {
         int[] var5 = ThemeCache.l(var2, var0, 0.3);
         float var6 = (float)Math.max(25, Math.min(100, SyncController.i)) / 62.0F;
         int[] var7 = ThemeCache.l(var1, var2, 0.08);
         yz = ThemeCache.mix(var7, var0, 0.05, m(-1018013109 ^ -1018012971, var6));
         za = ThemeCache.mix(var7, var0, 0.1, m(-1571161608 ^ -1571161778, var6));
         zb = ThemeCache.mix(var7, var0, 0.18, m(2001904639 ^ 2001904439, var6));
         zc = ThemeCache.m(var5[0], var5[1], var5[2], 44);
         zd = ThemeCache.m(var5[0], var5[1], var5[2], 78);
         ze = ThemeCache.mix(var7, var0, 0.3, 92);
         zf = ThemeCache.mix(var7, var0, 0.24, 78);
         zg = ThemeCache.mix(var3, var7, 0.8, 96);
         zh = ThemeCache.mix(var7, var0, 0.04, m(1417413969 ^ 1417414137, var6));
         zi = ThemeCache.mix(var7, var0, 0.12, m(1892650305 ^ 1892650495, var6));
         zj = ThemeCache.mix(var7, var0, 0.04, m(-2044901681 ^ -2044901863, var6));
         aab = ThemeCache.m(var5[0], var5[1], var5[2], 52);
         aac = ThemeCache.m(var5[0], var5[1], var5[2], 92);
         zz = ThemeCache.mix(var1, var0, 0.06, -1415815211 ^ -1415815405);
         aaa = ThemeCache.mix(var1, var0, 0.12, 1314127886 ^ 1314128086);
         aad = ThemeCache.mix(var3, var1, 0.85, -1761127833 ^ -1761127695);
         aae = ThemeCache.mix(var1, var0, 0.16, 702195973 ^ 702196143);
         aaf = ThemeCache.mix(var1, var0, 0.26, 96);
         aag = ThemeCache.mix(var1, var0, 0.14, -636349520 ^ -636349670);
         aah = ThemeCache.mix(var1, var0, 0.3, 683457885 ^ 683457950);
         aai = ThemeCache.mix(var3, var1, 0.5, -1549688680 ^ -1549688818);
      } else {
         yz = xt;
         za = xu;
         zb = ThemeCache.m(22, 21, 34, 665646084 ^ 665646331);
         zc = yg;
         zd = yh;
         ze = xw;
         zf = xx;
         zg = xy;
         zh = ThemeCache.m(13, 13, 21, 405085503 ^ 405085632);
         zi = ThemeCache.m(19, 18, 30, 436115479 ^ 436115688);
         zj = ThemeCache.m(13, 13, 21, 2067283283 ^ 2067283372);
         aab = yg;
         aac = yh;
         zz = xu;
         aaa = xu;
         aad = xy;
         aae = xx;
         aaf = xx;
         aag = xz;
         aah = yh;
         aai = ye;
      }

      if (yv) {
         float var13 = (float)Math.max(25, Math.min(100, SyncController.i)) / 62.0F;
         b(var0);
         int var15 = c(-894584307 ^ 1540070466);
         int var16 = c(1050126220 ^ -1744725512);
         int var8 = c(39475972 ^ -1761973398);
         int var9 = c(408504605 ^ -210680001);
         int var10 = d(150326684 ^ -150336652);
         int var11 = c(2080846893 ^ -2080850179);
         int var12 = c(-550080909 ^ -1842452377);
         yz = o(var15, m(70, var13));
         za = o(var16, m(94, var13));
         zb = o(var16, m(124, var13));
         zc = o(var10, 64);
         zd = o(var10, -1294067142 ^ -1294067018);
         ze = o(var8, 116);
         zf = o(var16, 70);
         zg = o(var12, 77);
         zh = o(var15, m(80, var13));
         zi = o(var16, m(114, var13));
         zj = o(var9, m(-2079888600 ^ -2079888445, var13));
         aam = o(var10, -1681196810 ^ -1681196978);
         aan = o(var11, 32);
         aao = o(c(-341842575 ^ -1585057946), m(74, var13));
         aap = o(var15, m(1791974068 ^ 1791973925, var13));
         aaq = -370978426 ^ -1155748231;
         aar = o(var10, 573372757 ^ 573372921);
         aas = c(-1458099819 ^ 1458062628);
         yi = d(549588315 ^ -550181981);
         yj = d(-1401143840 ^ 1402990854);
         yk = d(-484515126 ^ 483611932);
         yl = yj;
         ym = yk;
         yn = c(-1313150208 ^ 1313171403);
      }

      aik = yv ? aan : 0;
      yr = yv ? 1918180490 ^ 548070261 : o(yi, yv ? 44 : 26);
      yy = yv ? 1.5F : 1.0F;
      ys = o(yi, 18);
      yt = o(yi, 0);
      yu = o(yd, 1794215568 ^ 1794215512);
      zk = false;
      if (zk) {
         float var14 = (float)Math.max(25, Math.min(100, SyncController.i)) / 62.0F;
         yz = ThemeCache.m(-1006350262 ^ -1006350168, 78, -2078313743 ^ -2078313885, m(457401547 ^ 457401451, var14));
         za = ThemeCache.m(1010332063 ^ 1010332015, 122, 1751648986 ^ 1751648872, m(344081195 ^ 344081287, var14));
         zb = ThemeCache.m(732824178 ^ 732824202, 871923110 ^ 871922992, 2060133509 ^ 2060133441, m(591551456 ^ 591551324, var14));
         zc = -190161899 ^ -1303010326;
         zd = 486072967 ^ 1913068920;
         ze = -2064155068 ^ -1308065349;
         zf = 814275392 ^ 779560127;
         zg = -1616230981 ^ -1557767199;
         zh = ThemeCache.m(1745835409 ^ 1745835379, 78, 999479597 ^ 999479743, m(-1431036648 ^ -1431036483, var14));
         zi = ThemeCache.m(1194056849 ^ 1194056801, 122, -468197475 ^ -468197585, m(727654427 ^ 727654562, var14));
         zj = ThemeCache.m(2026345463 ^ 2026345287, 46, 110, m(-581232262 ^ -581232226, var14));
         yr = -1737699436 ^ -1030541205;
         ys = -662507107 ^ -58913182;
         yt = 1828920281 ^ 1845290022;
         yu = -1088422900 ^ 2011169779;
         yi = -1;
         yj = -330259106 ^ 329939125;
         yk = -1689650695 ^ 1689994542;
         yl = 448240348 ^ -448037076;
         ym = -1970817832 ^ 1970437126;
         zl = -1;
         zm = -1;
         zn = -1;
         zo = -1;
         zp = 755897164 ^ 1626467507;
         zq = -1250483244 ^ 1200151595;
         zr = -1;
         zs = 1331254564 ^ -1329917781;
         zt = -2059658538 ^ -926685911;
         zu = 1379536191 ^ 885387968;
         zv = -1;
         zw = -2132691324 ^ 2132693621;
         zx = -165198399 ^ 165188395;
      } else {
         zl = yd;
         zm = yn;
         zn = yf;
         zo = yo;
         zp = yc;
         zq = yb;
         zr = -86085969 ^ 88668675;
         zs = yi;
         zt = xz;
         zu = -883939454 ^ 544605370;
         zv = ya;
         zw = -189488493 ^ 185871971;
         zx = cq(yk, yn, 0.6F);
      }

      fi(var0, var1);
   }

   private boolean a(DrawContext var1, float var2, float var3, float var4, float var5, int var6) {

      if (yv && !SyncController.u && this.afi < 0 && !aim) {
         float var7 = 0.85F + 0.15F * (0.5F + 0.5F * (float)Math.sin((double)System.nanoTime() / 1.0E9 * Math.PI * 0.4));
         int var8 = o(aar, Math.round((float)(aar >>> 24 & (-2053163095 ^ -2053163178)) * var7));
         ci(var1, var2, var3, var4, var5, (float)var6, true, true, true, true, yy);
         return SheetG.a(var1, var2, var3, var4, var5, var6, dk(aao, agi), dk(aap, agi), dk(aaq, agi), dk(var8, agi));
      } else {
         return false;
      }
   }

   private static void b(int[] var0) {

      double[] var1 = LoaderDelegate.Rb.T;
      f((var0[0] & (-424032368 ^ -424032401)) << 16 | (var0[1] & (1801149414 ^ 1801149209)) << 8 | var0[2] & (153996785 ^ 153996558), var1);
      aaj = e(var1[2], 353.58);
      aak = Math.max(0.0, Math.min(1.3, var1[1] / 0.2401));
      aal = Math.min(1.0, aak);
   }

   private static int c(int var0) {

      double[] var1 = LoaderDelegate.Rb.T;
      f(var0 & (-32724792 ^ -17606857), var1);
      return var0 & (383512995 ^ -371461725) | g(var1[0], var1[1] * aak, var1[2] + aaj);
   }

   private static int d(int var0) {

      double[] var1 = LoaderDelegate.Rb.T;
      f(var0 & (-793163077 ^ -800672444), var1);
      return var0 & (2072192532 ^ -2071779820) | g(var1[0], var1[1] * aal, var1[2] + aaj);
   }

   private static double e(double var0, double var2) {

      double var4 = (var0 - var2 + 540.0) % 360.0;
      if (var4 < 0.0) {
         var4 += 360.0;
      }

      return var4 - 180.0;
   }

   private static void f(int var0, double[] var1) {

      double[] var2 = LoaderDelegate.Rb.LIN;
      double var3 = var2[var0 >> 16 & (-1040390052 ^ -1040389981)];
      double var5 = var2[var0 >> 8 & (533309290 ^ 533309333)];
      double var7 = var2[var0 & (1234293728 ^ 1234293535)];
      double var9 = Math.cbrt(0.4122214708 * var3 + 0.5363325363 * var5 + 0.0514459929 * var7);
      double var11 = Math.cbrt(0.2119034982 * var3 + 0.6806995451 * var5 + 0.1073969566 * var7);
      double var13 = Math.cbrt(0.0883024619 * var3 + 0.2817188376 * var5 + 0.6299787005 * var7);
      double var15 = 0.2104542553 * var9 + 0.793617785 * var11 - 0.0040720468 * var13;
      double var17 = 1.9779984951 * var9 - 2.428592205 * var11 + 0.4505937099 * var13;
      double var19 = 0.0259040371 * var9 + 0.7827717662 * var11 - 0.808675766 * var13;
      var1[0] = var15;
      var1[1] = Math.sqrt(var17 * var17 + var19 * var19);
      double var21 = Math.toDegrees(Math.atan2(var19, var17));
      var1[2] = var21 < 0.0 ? var21 + 360.0 : var21;
   }

   private static int g(double var0, double var2, double var4) {

      var0 = var0 < 0.0 ? 0.0 : (var0 > 1.0 ? 1.0 : var0);
      if (!(var2 > 0.0)) {
         var2 = 0.0;
      }

      double var6 = Math.toRadians(var4);
      double var8 = Math.cos(var6);
      double var10 = Math.sin(var6);
      double var12 = -1.0E-6;
      double var14 = 1.000001;
      double var16 = var2;
      double var18 = 0.0;
      double var20 = var2;

      for (int var22 = -1; var22 < 18; var22++) {
         double var23 = var22 < 0 ? var2 : (var18 + var20) * 0.5;
         double var25 = var23 * var8;
         double var27 = var23 * var10;
         double var29 = var0 + 0.3963377774 * var25 + 0.2158037573 * var27;
         double var31 = var0 - 0.1055613458 * var25 - 0.0638541728 * var27;
         double var33 = var0 - 0.0894841775 * var25 - 1.291485548 * var27;
         double var35 = var29 * var29 * var29;
         double var37 = var31 * var31 * var31;
         double var39 = var33 * var33 * var33;
         double var41 = 4.0767416621 * var35 - 3.3077115913 * var37 + 0.2309699292 * var39;
         double var43 = -1.2684380046 * var35 + 2.6097574011 * var37 - 0.3413193965 * var39;
         double var45 = -0.0041960863 * var35 - 0.7034186147 * var37 + 1.707614701 * var39;
         if (var41 >= -1.0E-6 && var41 <= 1.000001 && var43 >= -1.0E-6 && var43 <= 1.000001 && var45 >= -1.0E-6 && var45 <= 1.000001) {
            if (var22 < 0) {
               break;
            }

            var18 = var23;
         } else {
            var20 = var23;
         }

         var16 = var18;
      }

      double var51 = var16 * var8;
      double var24 = var16 * var10;
      double var26 = var0 + 0.3963377774 * var51 + 0.2158037573 * var24;
      double var28 = var0 - 0.1055613458 * var51 - 0.0638541728 * var24;
      double var30 = var0 - 0.0894841775 * var51 - 1.291485548 * var24;
      double var32 = var26 * var26 * var26;
      double var34 = var28 * var28 * var28;
      double var36 = var30 * var30 * var30;
      double var38 = 4.0767416621 * var32 - 3.3077115913 * var34 + 0.2309699292 * var36;
      double var40 = -1.2684380046 * var32 + 2.6097574011 * var34 - 0.3413193965 * var36;
      double var42 = -0.0041960863 * var32 - 0.7034186147 * var34 + 1.707614701 * var36;
      int var44 = 0;

      for (int var52 = 0; var52 < 3; var52++) {
         double var46 = var52 == 0 ? var38 : (var52 == 1 ? var40 : var42);
         var46 = var46 <= 0.0 ? 0.0 : (var46 >= 1.0 ? 1.0 : var46);
         double var48 = var46 <= 0.0031308 ? 12.92 * var46 : 1.055 * Math.pow(var46, 0.4166666666666667) - 0.055;
         var44 = var44 << 8 | (int)Math.round(var48 * 255.0);
      }

      return var44;
   }

   private static void h() {

      try {
         if (ConfigBridge.c != null && ConfigBridge.c.d() != null) {
            ConfigBridge.c.d().c();
         }
      } catch (Throwable var1) {
      }
   }

   public LoaderDelegate() {
      super(Text.empty());
   }

   protected void init() {

      applyTheme();
      if (SyncController.u) {
         GlyphPassCache.kick();
      }

      this.adk = (double)Math.max(1, Math.min(3, SyncController.a));
      ParserEngine[] var1 = xs;
      int var2 = Math.max(1, var1.length);
      int var3 = this.r();
      this.abr = Math.min(2023524098 ^ 2023524249, Math.max(100, (var3 - 20 - var2 * 6) / var2));
      if (this.abs.isEmpty() && SyncController.aa) {
         this.l(var3, this.s());
      }

      int var4 = 10;

      for (ParserEngine var8 : var1) {
         if (!this.abs.containsKey(var8)) {
            this.abs.put(var8, var4);
            this.abt.put(var8, 48);
            this.abu.put(var8, 0);
         }

         var4 += this.abr + 6;
      }

      this.j();
      if (!this.aea) {
         this.aea = true;
         if (SyncController.u) {
            this.uv();
         }
      }
   }

   private void j() {

      ParserEngine[] var1 = (ParserEngine[])xs.clone();
      Arrays.sort(var1, Comparator.comparingInt(var1x -> {

         return this.abs.getOrDefault(var1x, 0);
      }));
      int var2 = 0;
      int[] var3 = new int[var1.length];
      int[] var4 = new int[var1.length];

      for (ParserEngine var8 : var1) {
         int var9 = this.abs.getOrDefault(var8, 10);
         int var10 = this.abt.getOrDefault(var8, 48);

         for (int var11 = 0; var11 < var2; var11++) {
            if (Math.abs(var10 - var4[var11]) < 24 && var9 < var3[var11] + this.abr + 6 && var9 + this.abr > var3[var11]) {
               var9 = var3[var11] + this.abr + 6;
            }
         }

         if (var9 != this.abs.getOrDefault(var8, 10)) {
            this.abs.put(var8, var9);
         }

         var3[var2] = var9;
         var4[var2] = var10;
         var2++;
      }
   }

   private void k() {

      if (!SyncController.aa) {
         agm = null;
         agn = null;
         ago = null;
         agp = null;
         agq = null;
      } else {
         agm = new HashMap<>(this.abs);
         agn = new HashMap<>(this.abt);
         ago = new HashMap<>(this.abu);
         agp = new HashSet<>(this.abv);
         agq = new HashSet<>(this.abw);
         agr = this.r();
         ags = this.s();
         agt = this.abr;
      }
   }

   private void l(int var1, int var2) {

      if (ago != null && agp != null && agq != null) {
         if (agm != null && agn != null && agr == var1 && ags == var2 && agt == this.abr) {
            this.abs.putAll(agm);
            this.abt.putAll(agn);
            this.abu.putAll(ago);
         }

         this.abv.addAll(agp);
         this.abw.addAll(agq);
      }
   }

   private static int m(int var0, float var1) {

      int var2 = Math.round((float)var0 * var1);
      return var2 < 0 ? 0 : (var2 > (-1785585144 ^ -1785584905) ? -618010522 ^ -618010471 : var2);
   }

   private static int n(int var0, int var1, int var2, int var3) {

      return var3 << 24 | var0 << 16 | var1 << 8 | var2;
   }

   private static int o(int var0, int var1) {

      return var1 << 24 | var0 & (-886469609 ^ -875138072);
   }

   private static void p(float var0) {

      if (SyncController.ae) {
         float var1 = Math.min(1.0F, 0.625F * SyncController.vol());
         if (!(var1 <= 0.0F)) {
            try {
               if (a != null && a.getSoundManager() != null) {
                  a.getSoundManager().play(PositionedSoundInstance.master((SoundEvent)SoundEvents.BLOCK_NOTE_BLOCK_HAT.value(), var0, var1));
               }
            } catch (Throwable var3) {
            }
         }
      }
   }

   private float q() {

      double var1 = (double)a.getWindow().getScaleFactor();
      if (var1 <= 0.0) {
         var1 = 1.0;
      }

      double var3 = Math.max(1.0, Math.min(3.0, (double)Math.round(this.adk)));
      return (float)(var3 / var1);
   }

   private int r() {

      return (int)((float)this.width / this.q());
   }

   private int s() {

      return (int)((float)this.height / this.q());
   }

   private int t(double var1) {

      return (int)(var1 / (double)this.q());
   }

   private int u(double var1) {

      return (int)(var1 / (double)this.q());
   }

   private static String v(String var0) {

      if (var0 == null) {
         return "";
      } else {
         StringBuilder var1 = new StringBuilder(var0.length());

         for (int var2 = 0; var2 < var0.length(); var2++) {
            char var3 = var0.charAt(var2);
            if (var3 >= (2109698447 ^ 2109705870) && var3 <= (364557149 ^ 364530691)) {
               var3 = (char)(var3 - (1190526638 ^ 1190461518));
            }

            var1.append(var3);
         }

         String var4 = var1.toString();
         if (var4.length() > 1 && var4.charAt(1) == '.') {
            var4 = var4.charAt(0) + var4.substring(2);
         }

         return var4;
      }
   }

   private SyncDispatcher w() {

      return ConfigBridge.c != null ? ConfigBridge.c.c() : null;
   }

   private static void x(List<BuilderFactory> var0) {

      int var1 = var0.size();

      for (int var2 = 1; var2 < var1; var2++) {
         BuilderFactory var3 = (BuilderFactory)var0.get(var2);

         int var4;
         for (var4 = var2 - 1; var4 >= 0 && bl((BuilderFactory)var0.get(var4), var3) > 0; var4--) {
            var0.set(var4 + 1, (BuilderFactory)var0.get(var4));
         }

         var0.set(var4 + 1, var3);
      }
   }

   private List<BuilderFactory> y(ParserEngine var1) {

      SyncDispatcher var2 = this.w();
      if (var2 == null) {
         return Collections.emptyList();
      } else {
         int var3 = var2.a().size();
         if (var3 != this.agw || SyncController.ad != this.agx) {
            this.agv.clear();
            this.agw = var3;
            this.agx = SyncController.ad;
         }

         List<BuilderFactory> var4 = this.agv.get(var1);
         if (var4 == null) {
            var4 = new ArrayList();

            for (BuilderFactory var6 : var2.a()) {
               if (var6.i() == var1) {
                  var4.add(var6);
               }
            }

            if (this.agx == 1) {
               x((List<BuilderFactory>)var4);
            }

            if (var1 == ParserEngine.CT) {
               var4 = ao((List<BuilderFactory>)var4);
            }

            this.agv.put(var1, (List<BuilderFactory>)var4);
         }

         return (List<BuilderFactory>)var4;
      }
   }

   private static String z(double var0) {

      if (!Double.isFinite(var0)) {
         return "0.0";
      } else {
         long var2 = Math.round(var0 * 10.0);
         long var4 = Math.abs(var2);
         StringBuilder var6 = new StringBuilder(8);
         if (var2 < 0L) {
            var6.append('-');
         }

         return var6.append(var4 / 10L).append('.').append(var4 % 10L).toString();
      }
   }

   private static String aa(BlockCalculator var0) {

      if (var0 instanceof SpanEntry var1) {
         double var2 = var1.lo();
         double var4 = var1.hi();
         StringBuilder var6 = ab(new StringBuilder(16), var2);
         if (Math.round(var2 * 10.0) != Math.round(var4 * 10.0)) {
            ab(var6.append('-'), var4);
         }

         return var6.append('m').append('s').toString();
      } else {
         return var0 instanceof TimingEntry ? ab(new StringBuilder(10), var0.p()).append('m').append('s').toString() : z(var0.p());
      }
   }

   private static StringBuilder ab(StringBuilder var0, double var1) {

      long var3 = Double.isFinite(var1) ? Math.round(var1 * 10.0) : 0L;
      if (var3 < 0L) {
         var0.append('-');
         var3 = -var3;
      }

      var0.append(var3 / 10L);
      if (var3 % 10L != 0L) {
         var0.append('.').append(var3 % 10L);
      }

      return var0;
   }

   private static double ac(double var0, double var2, double var4) {

      double var6 = var4 - var2;
      double var8 = var6 <= 0.0 ? 0.0 : (var0 - var2) / var6;
      return var8 < 0.0 ? 0.0 : (var8 > 1.0 ? 1.0 : var8);
   }

   private static float ad(int var0, int var1, double var2, float var4) {

      float var5 = (float)((double)var1 * var2);
      return (float)var0 + Math.max(var4 / 2.0F, Math.min((float)var1 - var4 / 2.0F, var5));
   }

   private static int ae(float var0, float var1, float var2, float var3) {

      if (var2 - var1 < 1.0F) {
         return var0 < var1 - var3 ? 0 : (var0 > var2 + var3 ? 1 : 2);
      } else if (var0 <= var1) {
         return 0;
      } else if (var0 >= var2) {
         return 1;
      } else {
         return var0 - var1 <= var2 - var0 ? 0 : 1;
      }
   }

   private static int af(SpanEntry var0, float var1, int var2, int var3, boolean var4) {

      double var5 = var0.i();
      double var7 = var0.j();
      double var9 = ac(var0.lo(), var5, var7);
      double var11 = ac(var0.hi(), var5, var7);
      return var4
         ? ae(var1, (float)var2 + (float)((double)var3 * var9), (float)var2 + (float)((double)var3 * var11), 5.0F)
         : ae(var1, ad(var2, var3, var9, 7.0F), ad(var2, var3, var11, 7.0F), 3.5F);
   }

   private void ag(BlockCalculator var1, int var2, int var3, int var4, boolean var5, boolean var6) {

      this.acl = var1;
      this.acm = var2;
      this.acn = var3;
      this.aco = (float)var4 + 0.5F;
      this.acp = var5;
      this.acq = var6;
   }

   private boolean ah() {

      return this.acl != null
         && this.act == null
         && this.acr == null
         && this.adt == null
         && this.adu == null
         && this.adv == null
         && this.acq == this.nb()
         && (this.adz != 0 || this.acq || !this.adi && !this.adj);
   }

   private void ai(int var1) {

      BlockCalculator var2 = this.acl;
      if (var2 != null && var1 != 0) {
         if (var2 instanceof SpanEntry var3) {
            int var4 = this.ace == var3 ? this.ach : af(var3, this.aco, this.acm, this.acn, this.acq);
            if (var4 == 2) {
               var4 = var1 > 0 ? 1 : 0;
            }

            double var5 = (double)var1 * var3.k();
            if (var4 == 1) {
               var3.d(var3.hi() + var5);
            } else {
               var3.c(var3.lo() + var5);
            }
         } else {
            var2.a(var2.p() + (double)var1 * var2.k());
         }
      }
   }

   private boolean aj(int var1) {

      if (var1 != (-317329596 ^ -317329853) && var1 != (299687475 ^ 299687733)) {
         return false;
      } else if (this.ah() && this.ads == null && !this.abx && !this.adr && !this.bbi) {
         int var2 = var1 == (-430186173 ^ -430186427) ? 1 : -1;
         this.ai(ak() ? var2 * 10 : var2);
         return true;
      } else {
         return false;
      }
   }

   private static boolean ak() {

      long var0 = a.getWindow().getHandle();
      return GLFW.glfwGetKey(var0, -1700110865 ^ -1700111173) == 1 || GLFW.glfwGetKey(var0, 523875530 ^ 523875730) == 1;
   }

   private float al(int var1) {

      float var2 = this.ack;
      return var2 >= (float)var1 && var2 < (float)(var1 + 1) ? var2 : (float)var1 + 0.5F;
   }

   private void am() {

      this.abz.clear();
      SyncDispatcher var1 = this.w();
      if (var1 != null) {
         String var2 = this.aby.toLowerCase();
         if (!var2.isEmpty()) {
            for (BuilderFactory var4 : var1.a()) {
               if (bk(var4, var2)) {
                  this.abz.add(var4);
               }
            }
         }
      }
   }

   private static int an(BuilderFactory var0) {

      if (var0.i() != ParserEngine.CT) {
         return -1;
      } else if (var0 instanceof StepZoneIterator || var0 instanceof SortComparator || var0 instanceof EventCycleHandler || var0 instanceof SortCacheUnit) {
         return 1;
      } else {
         return !(var0 instanceof PoolCoordProvider) && !(var0 instanceof StepCacheWalker) && !(var0 instanceof WrapZoneProvider) ? 0 : 2;
      }
   }

   private static List<BuilderFactory> ao(List<BuilderFactory> var0) {

      ArrayList var1 = new ArrayList(var0.size());

      for (int var2 = 0; var2 < 3; var2++) {
         int var3 = 0;

         for (int var4 = var0.size(); var3 < var4; var3++) {
            BuilderFactory var5 = (BuilderFactory)var0.get(var3);
            if (Math.max(0, an(var5)) == var2) {
               var1.add(var5);
            }
         }
      }

      return var1;
   }

   private void ap(DrawContext var1, int var2, int var3, int var4, int var5) {

      int var6 = var3 + 10;
      this.be(var1, agz[var2], aha[var2], var6, var4 + 1, zk ? zx : (yv ? yn : cq(yk, yn, 0.6F)), false);
      int var7 = var6 + this.bf(agz[var2], aha[var2]) + 6;
      int var8 = var3 + var5 - 10;
      if (var8 > var7) {
         bv(var1, var7, var4 + 5, var8, var4 + 6, zc);
      }
   }

   private int aq(List<BuilderFactory> var1) {

      assert var1 != null
         && this.aiz != null
         && this.aja != null
         && this.aiw != null
         && this.aix != null
         && this.aiy != null
         && this.abw != null
         && xs != null
         && xs.length > 0
         && abn != null
         && abn.length == 3
         && abo != null
         && abo.length > 2
         && abp != null
         && abp.length > 10
         && agk != null
         && agk.length > 2
         && agz != null
         && agz.length == 3
         && xs[0] != null
         && abn[0] != null
         && abn[1] != null
         && abn[2] != null
         && abo[0] != null
         && abo[1] != null
         && agz[0] != null
         && agz[1] != null
         && agz[2] != null
         && abp[0] != null
         && abp[1] != null
         && agk[0] != null
         && agk[1] != null : "listHeight: bad " + "state";

      float var2 = 0.0F;
      boolean var3 = var1 != this.abz && !var1.isEmpty() && ((BuilderFactory)var1.get(0)).i() == ParserEngine.CT;
      int var4 = -1;
      Object var5 = null;

      try {
         int var6 = 0;

         for (int var7 = var1.size(); var6 < var7; var6++) {
            var5 = (BuilderFactory)var1.get(var6);
            int var8 = var3 ? an((BuilderFactory)var5) : -1;
            if (var8 >= 0 && var8 != var4) {
               var2 += 10.0F;
            }

            var4 = var8;
            var2 += 17.0F;
            float var9 = this.aiz.containsKey(var5) ? this.aiz.getFloat(var5) : (this.abw.contains(var5) ? 1.0F : 0.0F);
            if (var9 > 0.001F) {
               var2 += (float)(ar(((BuilderFactory)var5).k()) * 18 + (this.bqg && var5 instanceof ViewCacheIndex ? -1165860500 ^ -1165860380 : 0)) * var9;
            }
         }
      } catch (RuntimeException var10) {
         throw var10;
      }

      return Math.round(var2);
   }

   private static int ar(List<InitAdapter> var0) {

      int var1 = 0;
      int var2 = 0;

      for (int var3 = var0.size(); var2 < var3; var2++) {
         if (!(var0.get(var2) instanceof PlacementEntry)) {
            var1++;
         }
      }

      return var1;
   }

   private void as(int var1) {

      int var2 = var1 < 1 ? 1 : (var1 > 3 ? 3 : var1);
      if (var2 != ahd) {
         ahd = var2;
         ahe = ahc[var2 - 1];
         ahf.clear();
         this.ahg.clear();
      }
   }

   private static Text at(String var0) {

      Object var1 = ahf.get(var0);
      if (var1 == null) {
         var1 = Text.literal(var0).setStyle(ahe);
         if (ahf.size() < (-962028967 ^ -962033063)) {
            ahf.put(var0, (Text)var1);
         }
      }

      return (Text)var1;
   }

   private static Style au() {

      int var0 = ahh;
      int var1 = var0 >= 5 && var0 <= 45 ? var0 - 5 : (var0 == 125 ? 41 : (var0 == (378217411 ^ 378217140) ? 42 : (var0 == (981885035 ^ 981885066) ? 43 : -1)));
      if (var1 < 0) {
         return ahe;
      } else {
         Style var2 = ahn[var1];
         if (var2 == null) {
            var2 = av(var0, var1);
         }

         return var2;
      }
   }

   private static Style av(int var0, int var1) {

      Style var2 = Style.EMPTY.withFont(new StyleSpriteSource.Font(Identifier.of(agk[14], var0 < 10 ? agk[15] + 0 + var0 : agk[15] + var0)));
      ahn[var1] = var2;
      return var2;
   }

   private static Text aw(String var0) {

      int var1 = ahh;
      int var2 = var1 >= 5 && var1 <= 45
         ? var1 - 5
         : (var1 == 125 ? 41 : (var1 == (-1204942465 ^ -1204942840) ? 42 : (var1 == (1611439441 ^ 1611439536) ? 43 : -1)));
      if (var2 < 0) {
         return at(var0);
      } else {
         HashMap var3 = aho[var2];
         if (var3 == null) {
            var3 = new HashMap();
            aho[var2] = var3;
         }

         Text var4 = (Text)var3.get(var0);
         return var4 != null ? var4 : ax(var0, var3);
      }
   }

   private static Text ax(String var0, HashMap<String, Text> var1) {

      MutableText var2 = Text.literal(var0);
      var2.setStyle(au());
      if (var1.size() < (2109677698 ^ 2109678722)) {
         var1.put(var0, var2);
      }

      return var2;
   }

   private void ay(DrawContext var1, String var2, int var3, int var4, int var5, boolean var6) {

      int var7 = agi >= 0.999F ? var5 : dk(var5, agi);
      if (var7 >>> 24 >= 4) {
         if (!ahl
            || !GlyphPassCache.draw(var1, var2, null, 0, var3, var4, var7, this.afi, ahr, afh, this.bti, this.height, this.ajf, this.textRenderer, ahe, ahd)
            )
          {
            if (ba() && var2.indexOf(1277167012 ^ 1277166851) < 0) {
               HudFont.r(var1, var2, (float)var3, (float)var4, 8.0F, var7, var6);
            } else {
               Text var8 = aw(var2);
               if (ahl) {
                  this.az(var1, var8, null, var3, var4, var7);
                  var6 = false;
               }

               var1.drawText(this.textRenderer, var8, var3, var4, var7, var6);
            }
         }
      }
   }

   private void az(DrawContext var1, Text var2, OrderedText var3, int var4, int var5, int var6) {

      int var7 = (int)((float)(var6 >>> 24 & (1587109267 ^ 1587109228)) * 0.62F);
      if (var7 >= 6) {
         Matrix3x2fStack var8 = var1.getMatrices();
         var8.pushMatrix();

         try {
            var8.translate((float)var4 + ahm, (float)var5 + ahm);
            if (var2 != null) {
               var1.drawText(this.textRenderer, var2, 0, 0, var7 << 24 | -1517810036 ^ -1517352832, false);
            } else {
               var1.drawText(this.textRenderer, var3, 0, 0, var7 << 24 | -1970857778 ^ -1971315006, false);
            }
         } finally {
            var8.popMatrix();
         }
      }
   }

   private static boolean ba() {

      return !ahl && !SyncController.u;
   }

   private double bb() {

      return Math.max(1.0, Math.min(3.0, (double)Math.round(this.adk)));
   }

   private int bc() {

      return Math.max(6, (int)Math.round(8.0 * this.bb()));
   }

   private int bd(String var1) {

      if (ba()) {
         int var2 = this.bc();
         if (var2 != this.ahp) {
            this.ahg.clear();
            this.ahp = var2;
         }
      } else if (this.ahp != -1) {
         this.ahg.clear();
         this.ahp = -1;
      }

      if (this.ahg.containsKey(var1)) {
         return this.ahg.getInt(var1);
      } else {
         int var3 = ba() && var1.indexOf(-1084752471 ^ -1084752626) < 0
            ? (int)Math.round((double)HudFont.m(var1, this.ahp) / this.bb())
            : this.textRenderer.getWidth(at(var1));
         if (this.ahg.size() < (-1873380933 ^ -1873385029)) {
            this.ahg.put(var1, var3);
         }

         return var3;
      }
   }

   private void be(DrawContext var1, char[] var2, int var3, int var4, int var5, int var6, boolean var7) {

      int var8 = agi >= 0.999F ? var6 : dk(var6, agi);
      if (var8 >>> 24 >= 4) {
         if (!ahl
            || !GlyphPassCache.draw(
               var1, null, var2, var3, var4, var5, var8, this.afi, ahr, afh, this.bti, this.height, this.ajf, this.textRenderer, ahe, ahd
            )) {
            if (ba()) {
               int var18 = var2.length;
               boolean var10 = bh(var2, var3);
               int[] var11 = HudFont.s(var1, (float)var4, (float)var5, 8.0F);

               try {
                  int var12 = var11[0];

                  for (int var13 = 0; var13 < var18; var13++) {
                     if (!var10 || var13 != 1) {
                        char var14 = (char)(var2[var13] ^ var3 + var13 * 31);
                        if (var14 >= (-974581766 ^ -974524165) && var14 <= (599892179 ^ 599875469)) {
                           var14 = (char)(var14 - (594122668 ^ 594110796));
                        }

                        var12 += HudFont.o(var1, var14, var12, var11[1], var11[2], var8, var7);
                     }
                  }
               } finally {
                  HudFont.aa(var1);
               }
            } else {
               OrderedText var9 = bg(var2, var3, au());
               if (ahl) {
                  this.az(var1, null, var9, var4, var5, var8);
                  var7 = false;
               }

               var1.drawText(this.textRenderer, var9, var4, var5, var8, var7);
            }
         }
      }
   }

   private int bf(char[] var1, int var2) {

      if (!ba()) {
         return (int)Math.ceil((double)this.textRenderer.getTextHandler().getWidth(bg(var1, var2, ahe)));
      } else {
         int var3 = this.bc();
         int var4 = 0;
         int var5 = var1.length;
         boolean var6 = bh(var1, var2);

         for (int var7 = 0; var7 < var5; var7++) {
            if (!var6 || var7 != 1) {
               char var8 = (char)(var1[var7] ^ var2 + var7 * 31);
               if (var8 >= (1251629378 ^ 1251649091) && var8 <= (-1837920612 ^ -1837927998)) {
                  var8 = (char)(var8 - (-1702312647 ^ -1702347815));
               }

               var4 += HudFont.l(var8, var3);
            }
         }

         return (int)Math.ceil((double)var4 / this.bb());
      }
   }

   private static OrderedText bg(char[] var0, int var1, Style var2) {

      return var3 -> {

         assert var3 != null
            && var0 != null
            && var0.length >= 0
            && var2 != null
            && xs != null
            && xs.length > 0
            && abn != null
            && abn.length == 3
            && abo != null
            && abo.length > 2
            && abp != null
            && abp.length > 10
            && agk != null
            && agk.length > 2
            && agz != null
            && agz.length == 3
            && xs[0] != null
            && abn[0] != null
            && abn[1] != null
            && abn[2] != null
            && abo[0] != null
            && abo[1] != null
            && agz[0] != null
            && agz[1] != null
            && agz[2] != null
            && abp[0] != null
            && abp[1] != null
            && agk[0] != null
            && agk[1] != null
            && abp[2] != null
            && abp[3] != null
            && agk[2] != null : "secText: bad name";

         int var4 = var0.length;
         boolean var5 = false;
         if (var4 > 1) {
            char var6 = (char)(var0[1] ^ var1 + 31);
            if (var6 >= (1468063481 ^ 1468015096) && var6 <= (2075642929 ^ 2075603823)) {
               var6 = (char)(var6 - (-1557779203 ^ -1557736931));
            }

            var5 = var6 == '.';
         }

         try {
            int var10 = 0;

            for (int var7 = 0; var10 < var4; var10++) {
               if (!var5 || var10 != 1) {
                  char var8 = (char)(var0[var10] ^ var1 + var10 * 31);
                  if (var8 >= (-1946797876 ^ -1946761267) && var8 <= (2113845310 ^ 2113816416)) {
                     var8 = (char)(var8 - (1043951959 ^ 1043959735));
                  }

                  if (!var3.accept(var7++, var2, var8)) {
                     return false;
                  }
               }
            }

            return true;
         } catch (RuntimeException var9) {
            throw var9;
         }
      };
   }

   private static boolean bh(char[] var0, int var1) {

      if (var0.length <= 1) {
         return false;
      } else {
         char var2 = (char)(var0[1] ^ var1 + 31);
         if (var2 >= (-1278477444 ^ -1278540675) && var2 <= (-1734478683 ^ -1734538245)) {
            var2 = (char)(var2 - (41015164 ^ 40970652));
         }

         return var2 == '.';
      }
   }

   private static int bi(BuilderFactory var0) {

      return bh(var0.c, var0.cK) ? var0.c.length - 1 : var0.c.length;
   }

   private static char bj(BuilderFactory var0, int var1) {

      char[] var2 = var0.c;
      int var3 = var0.cK;
      int var4 = bh(var2, var3) && var1 >= 1 ? var1 + 1 : var1;
      char var5 = (char)(var2[var4] ^ var3 + var4 * 31);
      if (var5 >= (965412895 ^ 965474078) && var5 <= (-325917943 ^ -325968809)) {
         var5 = (char)(var5 - (-390560985 ^ -390562361));
      }

      return Character.toLowerCase(var5);
   }

   private static boolean bk(BuilderFactory var0, String var1) {

      int var2 = var1.length();
      if (var2 == 0) {
         return true;
      } else {
         int var3 = bi(var0);

         for (int var4 = 0; var4 <= var3 - var2; var4++) {
            int var5 = 0;

            while (var5 < var2 && bj(var0, var4 + var5) == var1.charAt(var5)) {
               var5++;
            }

            if (var5 == var2) {
               return true;
            }
         }

         return false;
      }
   }

   private static int bl(BuilderFactory var0, BuilderFactory var1) {

      int var2 = bi(var0);
      int var3 = bi(var1);
      int var4 = Math.min(var2, var3);

      for (int var5 = 0; var5 < var4; var5++) {
         char var6 = bj(var0, var5);
         char var7 = bj(var1, var5);
         if (var6 != var7) {
            return var6 - var7;
         }
      }

      return var2 - var3;
   }

   private static boolean bm(BuilderFactory var0, String var1) {

      char[] var2 = var0.c;
      int var3 = var0.cK;
      if (var1 != null && var1.length() == var2.length) {
         for (int var4 = 0; var4 < var2.length; var4++) {
            if ((char)(var2[var4] ^ var3 + var4 * 31) != var1.charAt(var4)) {
               return false;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   private static JsonElement bn(JsonObject var0, BuilderFactory var1) {

      for (Entry var3 : var0.entrySet()) {
         if (bm(var1, (String)var3.getKey())) {
            return (JsonElement)var3.getValue();
         }
      }

      return null;
   }

   private static void bo(DrawContext var0, int var1, int var2, int var3, int var4, int var5) {

      bz(var0, var1, var2, var3, var4, Math.max(2, Math.min(5, Math.min(var3, var4) / 2)), var5, true, true, true, true);
   }

   private static void bp(DrawContext var0, int var1, int var2, int var3, int var4, int var5) {

      bz(var0, var1, var2, var3, var4, var4 / 2, var5, true, true, true, true);
   }

   private static void bq(DrawContext var0, int var1, int var2, int var3, int var4) {

      bz(var0, var1, var2, var3, var3, var3 / 2, var4, true, true, true, true);
   }

   private static void br(DrawContext var0, float var1, float var2, float var3, float var4, int var5) {

      bt(var0, var1, var2, var3, var4, var4 / 2.0F, var5, true, true, true, true);
   }

   private static void bs(DrawContext var0, float var1, float var2, float var3, int var4) {

      bt(var0, var1, var2, var3, var3, var3 / 2.0F, var4, true, true, true, true);
   }

   private static void bt(
      DrawContext var0, float var1, float var2, float var3, float var4, float var5, int var6, boolean var7, boolean var8, boolean var9, boolean var10
   ) {

      if (var3 > 0.0F && var4 > 0.0F && var6 >>> 24 != 0 && (ahq || !aim)) {
         int var11 = agi >= 0.999F ? var6 : dk(var6, agi);
         float var12 = Math.min(var5, Math.min(var3, var4) * 0.5F);
         if (ahq) {
            if (!ahr && aht != null) {
               if (var12 < 1.0F) {
                  aht.rect(var0.getMatrices(), var1, var2, var1 + var3, var2 + var4, var11, var11);
               } else {
                  aht.round(var0.getMatrices(), var1, var2, var3, var4, var12, var11, var7, var8, var9, var10);
               }
            }

            return;
         }

         if (ch(var0, var1, var2, var3, var4, var12, var11, var7, var8, var9, var10, false)) {
            return;
         }
      }

      int var13 = Math.round(var1);
      int var14 = Math.round(var2);
      bz(
         var0,
         var13,
         var14,
         Math.max(1, Math.round(var1 + var3) - var13),
         Math.max(1, Math.round(var2 + var4) - var14),
         Math.round(var5),
         var6,
         var7,
         var8,
         var9,
         var10
      );
   }

   private static void bu(DrawContext var0, int var1, int var2, int var3, int var4, int var5, int var6) {

      bz(var0, var1, var2, var3, var4, var5, var6, true, true, true, true);
   }

   private static void bv(DrawContext var0, int var1, int var2, int var3, int var4, int var5) {

      int var6 = agi >= 0.999F ? var5 : dk(var5, agi);
      if (ahq) {
         bw(var0, var1, var2, var3, var4, var6, var6);
      } else if (aiq != null) {
         ce(var0, (float)var1, (float)var2, (float)var3, (float)var4, var6, var6);
      } else {
         var0.fill(var1, var2, var3, var4, var6);
      }
   }

   private static void bw(DrawContext var0, int var1, int var2, int var3, int var4, int var5, int var6) {

      if (!ahr && aht != null) {
         aht.rect(var0.getMatrices(), (float)var1, (float)var2, (float)var3, (float)var4, var5, var6);
      }
   }

   private static void bx(DrawContext var0, int var1, int var2, int var3, int var4, int var5, int var6, boolean var7, boolean var8, boolean var9, boolean var10) {

      bz(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
   }

   private static void by() {

      if (!ahy) {
         ahy = true;

         try {
            NativeImage var0 = new NativeImage(NativeImage.Format.RGBA, 1290310370 ^ 1290310242, 838468028 ^ 838467900, false);
            double var1 = 64.0;
            double var3 = 64.0;
            byte var5 = 4;

            for (int var6 = 0; var6 < (1875624728 ^ 1875624856); var6++) {
               for (int var7 = 0; var7 < (1490293369 ^ 1490293497); var7++) {
                  int var8 = 0;

                  for (int var9 = 0; var9 < var5; var9++) {
                     for (int var10 = 0; var10 < var5; var10++) {
                        double var11 = (double)var7 + ((double)var10 + 0.5) / (double)var5;
                        double var13 = (double)var6 + ((double)var9 + 0.5) / (double)var5;
                        double var15 = var11 - var1;
                        double var17 = var13 - var1;
                        if (var15 * var15 + var17 * var17 <= var3 * var3) {
                           var8++;
                        }
                     }
                  }

                  int var20 = (int)Math.round(255.0 * (double)var8 / (double)(var5 * var5));
                  var0.setColorArgb(var7, var6, var20 << 24 | 1297525953 ^ 1302942526);
               }
            }

            a.getTextureManager().registerTexture(ahw, new NativeImageBackedTexture(() -> {

               return "lithiu" + "m-rou" + "nd";
            }, var0));
         } catch (Throwable var19) {
         }
      }
   }

   private static void bz(DrawContext var0, int var1, int var2, int var3, int var4, int var5, int var6, boolean var7, boolean var8, boolean var9, boolean var10) {

      if (var3 > 0 && var4 > 0) {
         var5 = Math.min(var5, Math.min(var3 / 2, var4 / 2));
         int var11 = agi >= 0.999F ? var6 : dk(var6, agi);
         if (ahq) {
            if (!ahr && aht != null) {
               if (var5 < 1) {
                  aht.rect(var0.getMatrices(), (float)var1, (float)var2, (float)(var1 + var3), (float)(var2 + var4), var11, var11);
               } else {
                  aht.round(var0.getMatrices(), (float)var1, (float)var2, (float)var3, (float)var4, (float)var5, var11, var7, var8, var9, var10);
               }
            }
         } else if (var5 >= 1 && (var6 >>> 24 & (-962220444 ^ -962220389)) != 0) {
            if (aim || !ch(var0, (float)var1, (float)var2, (float)var3, (float)var4, (float)var5, var11, var7, var8, var9, var10, false)) {
               if (!ahy) {
                  by();
               }

               byte var12 = 64;
               var0.fill(var1 + var5, var2, var1 + var3 - var5, var2 + var4, var11);
               var0.fill(var1, var2 + var5, var1 + var5, var2 + var4 - var5, var11);
               var0.fill(var1 + var3 - var5, var2 + var5, var1 + var3, var2 + var4 - var5, var11);

               try {
                  if (var7) {
                     var0.drawTexture(
                        RenderPipelines.GUI_TEXTURED,
                        ahw,
                        var1,
                        var2,
                        0.0F,
                        0.0F,
                        var5,
                        var5,
                        var12,
                        var12,
                        1097765342 ^ 1097765214,
                        -1482226021 ^ -1482226149,
                        var11
                     );
                  } else {
                     var0.fill(var1, var2, var1 + var5, var2 + var5, var11);
                  }

                  if (var8) {
                     var0.drawTexture(
                        RenderPipelines.GUI_TEXTURED,
                        ahw,
                        var1 + var3 - var5,
                        var2,
                        (float)var12,
                        0.0F,
                        var5,
                        var5,
                        var12,
                        var12,
                        1550713492 ^ 1550713364,
                        1102630419 ^ 1102630547,
                        var11
                     );
                  } else {
                     var0.fill(var1 + var3 - var5, var2, var1 + var3, var2 + var5, var11);
                  }

                  if (var9) {
                     var0.drawTexture(
                        RenderPipelines.GUI_TEXTURED,
                        ahw,
                        var1,
                        var2 + var4 - var5,
                        0.0F,
                        (float)var12,
                        var5,
                        var5,
                        var12,
                        var12,
                        1725464886 ^ 1725465014,
                        -1786360981 ^ -1786360853,
                        var11
                     );
                  } else {
                     var0.fill(var1, var2 + var4 - var5, var1 + var5, var2 + var4, var11);
                  }

                  if (var10) {
                     var0.drawTexture(
                        RenderPipelines.GUI_TEXTURED,
                        ahw,
                        var1 + var3 - var5,
                        var2 + var4 - var5,
                        (float)var12,
                        (float)var12,
                        var5,
                        var5,
                        var12,
                        var12,
                        -373094209 ^ -373094337,
                        577553550 ^ 577553422,
                        var11
                     );
                  } else {
                     var0.fill(var1 + var3 - var5, var2 + var4 - var5, var1 + var3, var2 + var4, var11);
                  }
               } catch (Throwable var14) {
                  var0.fill(var1, var2, var1 + var5, var2 + var5, var11);
                  var0.fill(var1 + var3 - var5, var2, var1 + var3, var2 + var5, var11);
                  var0.fill(var1, var2 + var4 - var5, var1 + var5, var2 + var4, var11);
                  var0.fill(var1 + var3 - var5, var2 + var4 - var5, var1 + var3, var2 + var4, var11);
               }
            }
         } else if (aiq != null) {
            ce(var0, (float)var1, (float)var2, (float)(var1 + var3), (float)(var2 + var4), var11, var11);
         } else {
            var0.fill(var1, var2, var1 + var3, var2 + var4, var11);
         }
      }
   }

   private void ca() {

      float var1 = (float)a.getWindow().getScaleFactor();
      PaneGlassCache.frame(var1 > 0.01F ? 1.0F / var1 : 0.5F);
      aiq = null;
      air = null;
      aia = false;
      ain = false;
      aio = this.q() * var1;
      aip = this.adz != 0 ? 0.62F : 0.66F;
      PaneGlassCache.frostTex(null, 0.0F, 0.0F);
   }

   private static void cb() {

      ain = true;
      boolean var0 = false;
      if (yv && !aim && !BlurPaneCache.t) {
         BlurPaneCache.b(aio);
         var0 = BlurPaneCache.ok();
      }

      aia = var0;
      if (var0) {
         PaneGlassCache.frostTex(BlurPaneCache.a(), BlurPaneCache.us, BlurPaneCache.vs);
         int var1 = Math.max(0, Math.min(-1712206963 ^ -1712206990, Math.round(255.0F * aip)));
         aib = -1832511834 ^ 1841698470 | var1 << 16 | var1 << 8 | var1;
      }
   }

   private static boolean cc(DrawContext var0, float var1, float var2, float var3, float var4) {

      if (!ahq && !aim && aiq == null) {
         if (!ain) {
            cb();
         }

         Matrix3x2fStack var5 = var0.getMatrices();
         float var6 = var5.m00 * var1 + var5.m10 * var2 + var5.m20;
         float var7 = var5.m01 * var1 + var5.m11 * var2 + var5.m21;
         float var8 = var5.m00 * var3 + var5.m10 * var2 + var5.m20;
         float var9 = var5.m01 * var3 + var5.m11 * var2 + var5.m21;
         float var10 = var5.m00 * var1 + var5.m10 * var4 + var5.m20;
         float var11 = var5.m01 * var1 + var5.m11 * var4 + var5.m21;
         float var12 = var5.m00 * var3 + var5.m10 * var4 + var5.m20;
         float var13 = var5.m01 * var3 + var5.m11 * var4 + var5.m21;
         int var14 = (int)Math.floor((double)Math.min(Math.min(var6, var8), Math.min(var10, var12))) - 1;
         int var15 = (int)Math.floor((double)Math.min(Math.min(var7, var9), Math.min(var11, var13))) - 1;
         int var16 = (int)Math.ceil((double)Math.max(Math.max(var6, var8), Math.max(var10, var12))) + 1;
         int var17 = (int)Math.ceil((double)Math.max(Math.max(var7, var9), Math.max(var11, var13))) + 1;
         if (var16 > var14 && var17 > var15) {
            Object var18 = null;

            try {
               var18 = new ScreenRect(var14, var15, var16 - var14, var17 - var15);
               if (aia) {
                  air = PaneGlassCache.batch((ScreenRect)var18, true);
                  var0.state.addSimpleElement(air);
               }

               aiq = PaneGlassCache.batch((ScreenRect)var18, false);
               var0.state.addSimpleElement(aiq);
               return true;
            } catch (Throwable var20) {
               aim = true;
               aiq = null;
               air = null;
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private static void cd() {

      aiq = null;
      air = null;
   }

   private static void ce(DrawContext var0, float var1, float var2, float var3, float var4, int var5, int var6) {

      PaneGlassCache var7 = aiq;
      var7.clip(var0.scissorStack.peekLast());
      var7.rect(var0.getMatrices(), var1, var2, var3, var4, var5, var6);
   }

   private static int cf(float var0) {

      int var1 = Math.max(0, Math.min(-1809146241 ^ -1809146240, Math.round((float)(aib & (1319765139 ^ 1319765100)) * var0)));
      int var2 = Math.max(0, Math.min(1749467073 ^ 1749466942, Math.round(255.0F * agi)));
      return var2 << 24 | var1 << 16 | var1 << 8 | var1;
   }

   private static int cg(int var0) {

      if (!ain) {
         cb();
      }

      return !aia ? var0 : Math.round((float)(var0 >>> 24) * 0.8F) << 24 | var0 & (-2124007818 ^ -2120627831);
   }

   private static boolean ch(
      DrawContext var0,
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      int var6,
      boolean var7,
      boolean var8,
      boolean var9,
      boolean var10,
      boolean var11
   ) {

      PaneGlassCache var12 = null;
      ScreenRect var13 = var0.scissorStack.peekLast();

      try {
         if (aiq != null) {
            var12 = var11 ? air : aiq;
            if (var12 != null) {
               var12.clip(var13);
               var12.round(var0.getMatrices(), var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
            }

            return true;
         } else {
            var12 = PaneGlassCache.take(var13, var11);
            var12.round(var0.getMatrices(), var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
            var12.addTo(var0.state);
            return true;
         }
      } catch (Throwable var15) {
         aim = true;
         return false;
      }
   }

   private static void ci(
      DrawContext var0, float var1, float var2, float var3, float var4, float var5, boolean var6, boolean var7, boolean var8, boolean var9, float var10
   ) {

      if (!ain) {
         cb();
      }

      if (aia && !aim && var3 > 0.0F && var4 > 0.0F) {
         float var11 = Math.max(0.0F, Math.min(var5, Math.min(var3, var4) * 0.5F));
         int var12 = cf(var10);
         if (ahq) {
            if (!ahr && aht != null) {
               aht.frost(var0.getMatrices(), var1, var2, var3, var4, var11, var12, var6, var7, var8, var9);
            }
         } else {
            ch(var0, var1, var2, var3, var4, var11, var12, var6, var7, var8, var9, true);
         }
      }
   }

   private static void cj(
      DrawContext var0, float var1, float var2, float var3, float var4, float var5, int var6, boolean var7, boolean var8, boolean var9, boolean var10
   ) {

      if (var3 > 0.0F && var4 > 0.0F && var6 >>> 24 != 0) {
         float var11 = Math.min(var5, Math.min(var3, var4) * 0.5F);
         if (ahq) {
            if (!ahr && aht != null) {
               if (var11 < 1.0F) {
                  aht.rect(var0.getMatrices(), var1, var2, var1 + var3, var2 + var4, var6, var6);
               } else {
                  aht.round(var0.getMatrices(), var1, var2, var3, var4, var11, var6, var7, var8, var9, var10);
               }
            }
         } else if (!(var11 >= 1.0F) || aim || !ch(var0, var1, var2, var3, var4, var11, var6, var7, var8, var9, var10, false)) {
            if (aiq != null) {
               ce(var0, (float)Math.round(var1), (float)Math.round(var2), (float)Math.round(var1 + var3), (float)Math.round(var2 + var4), var6, var6);
            } else {
               var0.fill(Math.round(var1), Math.round(var2), Math.round(var1 + var3), Math.round(var2 + var4), var6);
            }
         }
      }
   }

   private float ck() {

      return this.adz != 0 ? 1.0F : 0.8F;
   }

   private void cl(DrawContext var1, int var2, int var3, int var4, int var5, int var6) {

      if (yv && !aim) {
         cm(var1, (float)var2, (float)var3, (float)var4, (float)var5, (float)var6, -1812982734 ^ -1544547278);
         if (aik != 0) {
            cn(var1, (float)var2, (float)var3, (float)var4, (float)var5, (float)var6, 7.0F, 0.0F, aik);
            cn(var1, (float)var2, (float)var3, (float)var4, (float)var5, (float)var6, 1.6F, 0.0F, aam);
         }
      } else {
         bu(var1, var2 - 1, var3 + 1, var4 + 2, var5 + 2, var6 + 1, 2145788070 ^ 1508253862);
      }

      ci(var1, (float)var2, (float)var3, (float)var4, (float)var5, (float)var6, true, true, true, true, yy);
   }

   private static void cm(DrawContext var0, float var1, float var2, float var3, float var4, float var5, int var6) {

      if (yv) {
         cn(var0, var1, var2, var3, var4, var5, 8.0F, 2.0F, var6);
      }
   }

   private static void cn(DrawContext var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, int var8) {

      if (!aim) {
         int var9 = agi >= 0.999F ? var8 : dk(var8, agi);
         float var10 = Math.max(0.0F, Math.min(var5, Math.min(var3, var4) * 0.5F));
         if (ahq) {
            if (!ahr && aht != null) {
               aht.shadow(var0.getMatrices(), var1, var2, var3, var4, var10, var6, var7, var9);
            }
         } else {
            PaneGlassCache var11 = null;
            ScreenRect var12 = var0.scissorStack.peekLast();

            try {
               if (aiq != null && var12 == null) {
                  var11 = aiq;
                  var11.clip(null);
                  var11.shadow(var0.getMatrices(), var1, var2, var3, var4, var10, var6, var7, var9);
                  return;
               }

               var11 = PaneGlassCache.take(var12, false);
               var11.shadow(var0.getMatrices(), var1, var2, var3, var4, var10, var6, var7, var9);
               var11.addTo(var0.state);
            } catch (Throwable var14) {
               aim = true;
            }
         }
      }
   }

   private void co(DrawContext var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {

      int var8 = 24 + var5;
      float var9 = (float)(var3 + 24);
      boolean var10 = agi >= 0.999F;
      int var11 = var10 ? zc : dk(zc, agi);
      int var12 = var10 ? cg(var6) : dk(cg(var6), agi);
      int var13 = var10 ? cg(yz) : dk(cg(yz), agi);
      if (var7) {
         PaneGlassCache var20 = aht;
         if (var20 != null) {
            ahr = false;
            if (yv) {
               var20.shadow(null, (float)var2, (float)var3, (float)var4, (float)var8, 10.0F, 6.0F, 2.0F, dk(-1191705611 ^ -2131229707, agi));
               if (aik != 0) {
                  var20.shadow(null, (float)var2, (float)var3, (float)var4, (float)var8, 10.0F, 10.0F, 0.0F, dk(aik, agi));
                  var20.shadow(null, (float)var2, (float)var3, (float)var4, (float)var8, 10.0F, 1.6F, 0.0F, dk(aam, agi));
               }
            }

            if (aia) {
               var20.frost(null, (float)var2, (float)var3, (float)var4, (float)var8, 10.0F, cf(1.0F), true, true, true, true);
            }

            var20.round(null, (float)var2, (float)var3, (float)var4, (float)var8, 10.0F, var11, true, true, true, true);
            var20.cut(null, (float)(var2 + 1), (float)(var3 + 1), (float)(var4 - 2), (float)(var8 - 2), 9.0F, var12, var9, false);
            if (var5 >= 1) {
               var20.cut(null, (float)(var2 + 1), (float)(var3 + 1), (float)(var4 - 2), (float)(var8 - 2), 9.0F, var13, var9, true);
            }
         }
      } else if (!this.a(var1, (float)var2, (float)var3, (float)var4, (float)var8, 10)) {
         if (!aim) {
            cm(var1, (float)var2, (float)var3, (float)var4, (float)var8, 10.0F, -218029932 ^ -1560207212);
            if (yv && aik != 0) {
               cn(var1, (float)var2, (float)var3, (float)var4, (float)var8, 10.0F, 10.0F, 0.0F, aik);
               cn(var1, (float)var2, (float)var3, (float)var4, (float)var8, 10.0F, 1.6F, 0.0F, aam);
            }

            ci(var1, (float)var2, (float)var3, (float)var4, (float)var8, 10.0F, true, true, true, true, yy);
            PaneGlassCache var14 = null;
            ScreenRect var15 = var1.scissorStack.peekLast();

            try {
               boolean var16 = aiq != null;
               var14 = var16 ? aiq : PaneGlassCache.take(var15, false);
               if (var16) {
                  var14.clip(var15);
               }

               var14.round(var1.getMatrices(), (float)var2, (float)var3, (float)var4, (float)var8, 10.0F, var11, true, true, true, true);
               var14.cut(var1.getMatrices(), (float)(var2 + 1), (float)(var3 + 1), (float)(var4 - 2), (float)(var8 - 2), 9.0F, var12, var9, false);
               if (var5 >= 1) {
                  var14.cut(var1.getMatrices(), (float)(var2 + 1), (float)(var3 + 1), (float)(var4 - 2), (float)(var8 - 2), 9.0F, var13, var9, true);
               }

               if (!var16) {
                  var14.addTo(var1.state);
               }

               return;
            } catch (Throwable var17) {
               aim = true;
            }
         }

         bu(var1, var2, var3, var4, var8, 10, var11);
         boolean var18 = var5 < 1;
         bx(var1, var2 + 1, var3 + 1, var4 - 2, 24 - (var18 ? 2 : 1), 9, var12, true, true, var18, var18);
         if (!var18) {
            bx(var1, var2 + 1, var3 + 24, var4 - 2, var5 - 1, Math.max(1, Math.min(9, (var5 - 1) / 2)), var13, false, false, true, true);
         }
      }
   }

   private static void cp() {

      if (!aiv) {
         aiv = true;

         try {
            NativeImage var0 = new NativeImage(NativeImage.Format.RGBA, 64, 32, false);
            byte var1 = 4;

            for (int var2 = 0; var2 < 32; var2++) {
               for (int var3 = 0; var3 < 64; var3++) {
                  boolean var4 = var3 >= 32;
                  int var5 = var4 ? var3 - 32 : var3;
                  int var6 = 0;

                  for (int var7 = 0; var7 < var1; var7++) {
                     for (int var8 = 0; var8 < var1; var8++) {
                        double var9 = (double)var5 + ((double)var8 + 0.5) / (double)var1;
                        double var11 = (double)var2 + ((double)var7 + 0.5) / (double)var1;
                        boolean var13;
                        if (var4) {
                           var13 = Math.abs(var11 - 16.0) <= 16.0 * (1.0 - var9 / 32.0);
                        } else {
                           var13 = Math.abs(var9 - 16.0) <= 16.0 * (1.0 - var11 / 32.0);
                        }

                        if (var13) {
                           var6++;
                        }
                     }
                  }

                  int var15 = (int)Math.round(255.0 * (double)var6 / (double)(var1 * var1));
                  var0.setColorArgb(var3, var2, var15 << 24 | 343157309 ^ 344708546);
               }
            }

            a.getTextureManager().registerTexture(ait, new NativeImageBackedTexture(() -> {

               return "lithium-" + "tri";
            }, var0));
         } catch (Throwable var14) {
         }
      }
   }

   private static int cq(int var0, int var1, float var2) {

      int var3 = (int)(
         (float)(var0 >>> 24 & (-310985654 ^ -310985547))
            + (float)((var1 >>> 24 & (1921107151 ^ 1921106992)) - (var0 >>> 24 & (1106874478 ^ 1106874513))) * var2
      );
      int var4 = (int)(
         (float)(var0 >> 16 & (1520232096 ^ 1520232031))
            + (float)((var1 >> 16 & (-2129520181 ^ -2129520332)) - (var0 >> 16 & (-800087585 ^ -800087776))) * var2
      );
      int var5 = (int)(
         (float)(var0 >> 8 & (202843051 ^ 202842964)) + (float)((var1 >> 8 & (-1265385454 ^ -1265385235)) - (var0 >> 8 & (849089467 ^ 849089348))) * var2
      );
      int var6 = (int)((float)(var0 & (-518226334 ^ -518226275)) + (float)((var1 & (-1223142212 ^ -1223142333)) - (var0 & (91608257 ^ 91608126))) * var2);
      return var3 << 24 | var4 << 16 | var5 << 8 | var6;
   }

   private float cr(ParserEngine var1) {

      return this.aiy.containsKey(var1) ? this.aiy.getFloat(var1) : (this.abv.contains(var1) ? 0.0F : 1.0F);
   }

   private float cs(BuilderFactory var1) {

      return this.aiz.containsKey(var1) ? this.aiz.getFloat(var1) : (this.abw.contains(var1) ? 1.0F : 0.0F);
   }

   private int ct(List<BuilderFactory> var1) {

      assert var1 != null
         && this.aiz != null
         && this.aja != null
         && this.aiw != null
         && this.aix != null
         && this.aiy != null
         && this.abw != null
         && xs != null
         && xs.length > 0
         && abn != null
         && abn.length == 3
         && abo != null
         && abo.length > 2
         && abp != null
         && abp.length > 10
         && agk != null
         && agk.length > 2
         && agz != null
         && agz.length == 3
         && xs[0] != null
         && abn[0] != null
         && abn[1] != null
         && abn[2] != null
         && abo[0] != null
         && abo[1] != null
         && agz[0] != null
         && agz[1] != null
         && agz[2] != null
         && abp[0] != null
         && abp[1] != null
         && agk[0] != null
         && agk[1] != null : "ti" + "ckExpand: bad st" + "ate";

      float var2 = 0.0F;
      boolean var3 = var1 != this.abz && !var1.isEmpty() && ((BuilderFactory)var1.get(0)).i() == ParserEngine.CT;
      int var4 = -1;
      Object var5 = null;

      try {
         int var6 = 0;

         for (int var7 = var1.size(); var6 < var7; var6++) {
            var5 = (BuilderFactory)var1.get(var6);
            int var8 = var3 ? an((BuilderFactory)var5) : -1;
            if (var8 >= 0 && var8 != var4) {
               var2 += 10.0F;
            }

            var4 = var8;
            boolean var9 = this.abw.contains(var5);
            float var10 = var9 ? 1.0F : 0.0F;
            float var11 = var10;
            if (!this.aiz.containsKey(var5) || this.aiz.getFloat(var5) != var10 || this.aja.getFloat(var5) != 0.0F) {
               var11 = this.cx(this.aiz, this.aja, var5, var10, var9 ? 19.0F : 24.0F);
            }

            var2 += 17.0F;
            if (var11 > 0.001F) {
               var2 += (float)(ar(((BuilderFactory)var5).k()) * 18 + (this.bqg && var5 instanceof ViewCacheIndex ? 1809845771 ^ 1809845891 : 0)) * var11;
            }
         }
      } catch (RuntimeException var12) {
         throw var12;
      }

      return Math.round(var2);
   }

   private void cu() {

      long var1 = System.nanoTime();
      if (this.ajf != 0L) {
         this.ajg = Math.min(0.1F, (float)(var1 - this.ajf) / 1.0E9F);
      }

      this.ajf = var1;
   }

   private float cv(Object2FloatOpenHashMap<Object> var1, Object var2, float var3, float var4) {

      if (var1.containsKey(var2) && !SyncController.x) {
         float var5 = var1.getFloat(var2);
         if (var5 == var3) {
            return var5;
         } else {
            float var6 = var5 + (var3 - var5) * (1.0F - (float)Math.exp((double)(-var4 * this.ajg)));
            if (Math.abs(var3 - var6) < 0.004F) {
               var6 = var3;
            }

            var1.put(var2, var6);
            return var6;
         }
      } else {
         var1.put(var2, var3);
         return var3;
      }
   }

   private float cw(Object var1, boolean var2) {

      return this.cv(this.aiw, var1, var2 ? 1.0F : 0.0F, 21.0F);
   }

   private float cx(Object2FloatOpenHashMap<Object> var1, Object2FloatOpenHashMap<Object> var2, Object var3, float var4, float var5) {

      if (var1.containsKey(var3) && !SyncController.x) {
         float var6 = var1.getFloat(var3);
         float var7 = var2.containsKey(var3) ? var2.getFloat(var3) : 0.0F;
         if (var6 == var4 && var7 == 0.0F) {
            return var6;
         } else {
            float var8 = this.ajg;
            float var9 = (float)Math.exp((double)(-var5 * var8));
            float var10 = var6 - var4;
            float var11 = var7 + var5 * var10;
            float var12 = var4 + (var10 + var11 * var8) * var9;
            float var13 = (var7 - var5 * var11 * var8) * var9;
            if (Math.abs(var12 - var4) < 0.0015F && Math.abs(var13) < 0.02F) {
               var12 = var4;
               var13 = 0.0F;
            }

            var1.put(var3, var12);
            var2.put(var3, var13);
            return var12;
         }
      } else {
         var1.put(var3, var4);
         var2.put(var3, 0.0F);
         return var4;
      }
   }

   private static float cy(float var0, int var1, int var2) {

      float var3 = 0.5F / (float)Math.max(1, var2);
      float var4 = var3 * (float)var1;
      float var5 = (var0 - var4) / Math.max(0.2F, 1.0F - var4);
      var5 = var5 < 0.0F ? 0.0F : (var5 > 1.0F ? 1.0F : var5);
      return var5 * var5 * (3.0F - 2.0F * var5);
   }

   private static int cz(float var0, int var1, int var2) {

      return Math.round((1.0F - cy(var0, var1, var2)) * 8.0F);
   }

   private float da(Object var1, float var2) {

      return this.cx(this.aix, this.ajc, var1, var2, 28.0F);
   }

   private float db(Object2FloatOpenHashMap<Object> var1, Object var2, float var3) {

      return this.cx(var1, this.ajc, var2, var3, 24.0F);
   }

   private float dc(float var1, int var2, int var3, float var4) {

      if (var3 <= 0) {
         return 0.0F;
      } else {
         float var5 = var2 < 0 ? 0.0F : (float)(var2 > var3 ? var3 : var2);
         var1 = var1 < 0.0F ? 0.0F : (var1 > (float)var3 ? (float)var3 : var1);
         if (var1 != var5 && !SyncController.x) {
            var1 += (var5 - var1) * (1.0F - (float)Math.exp((double)(-var4 * this.ajg)));
            if (Math.abs(var5 - var1) * (float)Math.max(1, ahd) < 0.5F) {
               var1 = var5;
            }

            return var1;
         } else {
            return var5;
         }
      }
   }

   private float dd(Object var1, int var2, int var3) {

      float var4;
      if (this.ajd.containsKey(var1)) {
         var4 = this.dc(this.ajd.getFloat(var1), var2, var3, 25.0F);
      } else {
         var4 = var3 <= 0 ? 0.0F : (var2 < 0 ? 0.0F : (float)Math.min(var3, var2));
      }

      this.ajd.put(var1, var4);
      return var4;
   }

   private int de(float var1) {

      if (this.adz != 0) {
         return Math.round(var1);
      } else {
         int var2 = Math.max(1, ahd);
         int var3 = Math.round(var1 * (float)var2);
         return (var3 + var2 - 1) / var2;
      }
   }

   private float df(float var1) {

      if (this.adz != 0) {
         return 0.0F;
      } else {
         int var2 = Math.max(1, ahd);
         int var3 = Math.round(var1 * (float)var2);
         return (float)((var3 + var2 - 1) / var2 * var2 - var3) / (float)var2;
      }
   }

   private int dg(int var1, float var2) {

      if (var2 > 0.0F && var1 > (-603193777 ^ 1007418959)) {
         float var3 = this.ajq;
         if (!(var3 >= (float)var1) || !(var3 < (float)(var1 + 1))) {
            var3 = (float)var1 + 0.5F;
         }

         return (int)Math.floor((double)(var3 - var2));
      } else {
         return var1;
      }
   }

   private static boolean dh(DrawContext var0, float var1) {

      if (!(var1 > 0.0F)) {
         return false;
      } else {
         var0.getMatrices().pushMatrix();
         var0.getMatrices().translate(0.0F, var1);
         return true;
      }
   }

   private static void di(DrawContext var0, boolean var1) {

      if (var1) {
         var0.getMatrices().popMatrix();
      }
   }

   private static void dj() {

      if (SyncController.x) {
         ThemeCache.a();
      } else {
         ThemeCache.b();
      }
   }

   private static int dk(int var0, float var1) {

      int var2 = (int)((float)(var0 >>> 24 & (516993492 ^ 516993323)) * Math.max(0.0F, Math.min(1.0F, var1)));
      return var2 << 24 | var0 & (1755430170 ^ 1751007973);
   }

   private static void dl(DrawContext var0, int var1, int var2, int var3, int var4, int var5) {

      int var6 = agi >= 0.999F ? var5 : dk(var5, agi);
      if (ahq) {
         if (!ahr && aht != null && var3 > 0) {
            if (var4 == 0) {
               aht.tri(var0.getMatrices(), (float)(var1 - var3), (float)var2, (float)(var1 + var3), (float)var2, (float)var1, (float)(var2 + var3), var6);
            } else {
               aht.tri(var0.getMatrices(), (float)var1, (float)(var2 - var3), (float)(var1 + var3), (float)var2, (float)var1, (float)(var2 + var3), var6);
            }
         }
      } else if (aiq != null && var3 > 0) {
         PaneGlassCache var7 = aiq;
         var7.clip(var0.scissorStack.peekLast());
         if (var4 == 0) {
            var7.tri(var0.getMatrices(), (float)(var1 - var3), (float)var2, (float)(var1 + var3), (float)var2, (float)var1, (float)(var2 + var3), var6);
         } else {
            var7.tri(var0.getMatrices(), (float)var1, (float)(var2 - var3), (float)(var1 + var3), (float)var2, (float)var1, (float)(var2 + var3), var6);
         }
      } else {
         if (!aiv) {
            cp();
         }

         try {
            if (var4 == 0) {
               var0.drawTexture(RenderPipelines.GUI_TEXTURED, ait, var1 - var3, var2, 0.0F, 0.0F, var3 * 2, var3, 32, 32, 64, 32, var6);
            } else {
               var0.drawTexture(RenderPipelines.GUI_TEXTURED, ait, var1, var2 - var3, 32.0F, 0.0F, var3, var3 * 2, 32, 32, 64, 32, var6);
            }
         } catch (Throwable var8) {
            dm(var0, var1, var2, var3, var4, var5);
         }
      }
   }

   private static void dm(DrawContext var0, int var1, int var2, int var3, int var4, int var5) {

      if (var3 >= 1) {
         int var6 = var5 >>> 24 & (518139135 ^ 518138880);
         if (var6 > 0) {
            int var7 = var5 & (-710917809 ^ -715145552);

            for (int var8 = 0; var8 < var3; var8++) {
               double var9 = (double)var3 - ((double)var8 + 0.5);
               if (!(var9 <= 0.0)) {
                  int var11 = (int)Math.floor(var9);
                  int var12 = (int)((var9 - (double)var11) * (double)var6);
                  int var13 = var12 >= 4 ? var12 << 24 | var7 : 0;
                  if (var4 == 0) {
                     int var14 = var2 + var8;
                     if (var11 > 0) {
                        bv(var0, var1 - var11, var14, var1 + var11, var14 + 1, var5);
                     }

                     if (var13 != 0) {
                        bv(var0, var1 - var11 - 1, var14, var1 - var11, var14 + 1, var13);
                        bv(var0, var1 + var11, var14, var1 + var11 + 1, var14 + 1, var13);
                     }
                  } else {
                     int var15 = var1 + var8;
                     if (var11 > 0) {
                        bv(var0, var15, var2 - var11, var15 + 1, var2 + var11, var5);
                     }

                     if (var13 != 0) {
                        bv(var0, var15, var2 - var11 - 1, var15 + 1, var2 - var11, var13);
                        bv(var0, var15, var2 + var11, var15 + 1, var2 + var11 + 1, var13);
                     }
                  }
               }
            }
         }
      }
   }

   private static void dn(DrawContext var0, int var1, int var2, int var3) {

      bv(var0, var1 + 2, var2, var1 + 5, var2 + 1, var3);
      bv(var0, var1 + 2, var2 + 6, var1 + 5, var2 + 7, var3);
      bv(var0, var1, var2 + 2, var1 + 1, var2 + 5, var3);
      bv(var0, var1 + 6, var2 + 2, var1 + 7, var2 + 5, var3);
      bv(var0, var1 + 1, var2 + 1, var1 + 2, var2 + 2, var3);
      bv(var0, var1 + 5, var2 + 1, var1 + 6, var2 + 2, var3);
      bv(var0, var1 + 1, var2 + 5, var1 + 2, var2 + 6, var3);
      bv(var0, var1 + 5, var2 + 5, var1 + 6, var2 + 6, var3);
      bv(var0, var1 + 6, var2 + 6, var1 + 8, var2 + 8, var3);
   }

   private static int[] _kwren_do() {

      int var0 = SyncController.j;
      if (var0 != ajt) {
         ajt = var0;
         float var1 = (float)Math.max(0, Math.min(100, var0)) / 70.0F;

         for (int var2 = 0; var2 < 10; var2++) {
            int var3 = ajr[var2];
            int var4 = Math.min(-975079024 ^ -975079057, Math.round((float)(var3 >>> 24) * var1));
            ajs[var2] = var4 << 24 | var3 & (1588984999 ^ 1581908824);
         }
      }

      return ajs;
   }

   public void render(DrawContext var1, int var2, int var3, float var4) {

      HudFont.y();
      this.cu();
      if (this.brv >= 0 && !td(this.brv)) {
         this.brv = -1;
      }

      this.ajh++;
      this.acl = null;
      boolean var5 = false;
      if (this.adz == 0 && !bqs) {
         try {
            var5 = PosePassCache.hasInspect();
         } catch (Throwable var93) {
            bqs = true;
         }
      }

      this.bqg = var5;
      this.ca();
      this.tz();
      if (this.adz != 0) {
         this.vn(var1);
      } else {
         this.as((int)Math.max(1.0, Math.min(3.0, (double)Math.round(this.adk))));
         float var6 = this.q();
         int var7 = (int)((double)var2 / (double)var6);
         int var8 = (int)((double)var3 / (double)var6);
         int var9 = (int)((float)this.width / var6);
         int var10 = (int)((float)this.height / var6);
         this.ajq = (float)var3 / var6;
         var1.getMatrices().pushMatrix();
         var1.getMatrices().scale(var6, var6);
         this.tf(var1, var9, var10);
         float var11 = agi;
         boolean var12 = this.nj();
         agi = var11 * this.bpr;
         if (var12) {
            if (SyncController.q) {
               int[] var13 = _kwren_do();

               for (int var14 = 0; var14 < 10; var14++) {
                  int var15 = var13[var14];
                  var1.fill(0, var10 * var14 / 10, var9, var10 * (var14 + 1) / 10, agi >= 0.999F ? var15 : dk(var15, agi));
               }
            }

            this.ds(var1, var9, var10, var7, var8, var6);
            boolean var95 = this.adi || this.adj || this.nb() || this.adt != null || this.adu != null || this.adv != null || this.act != null;
            int var101 = var95 ? 1840495870 ^ -1380729602 : var7;
            int var103 = var95 ? 1608562420 ^ -1612663052 : var8;
            this.bqh = !var95 && this.acr == null && this.ads == null && !this.abx;
            this.adn = null;
            this.dt(var1, var9);
            String var16 = abo[1];
            this.ay(var1, var16, var9 - this.bd(var16) - 6, var10 - 12, -1047185430 ^ 1304785298, false);
            this.du(var1, var9);
            this.ej(var9);
            boolean var17 = this.em(var101, var103);
            int var18 = var17 ? -573316544 ^ 500425280 : var101;
            int var19 = var17 ? 434050822 ^ -639691002 : var103;
            boolean var20 = !this.aby.isEmpty();
            if (var20 != this.ajz) {
               this.ajz = var20;
               this.ajy = SyncController.x ? 1.0F : 0.0F;
            }

            if (this.ajy < 1.0F) {
               this.ajy = this.ajy + (1.0F - this.ajy) * (1.0F - (float)Math.exp((double)(-21.0F * this.ajg)));
               this.ajy = this.ajy > 0.996F ? 1.0F : this.ajy;
            }

            float var21 = agi;
            agi = var21 * this.ajy;

            try {
               if (var20) {
                  this.ec(var1, var9, var18, var19);
               } else {
                  for (ParserEngine var25 : xs) {
                     this.dw(var1, var25, var18, var19);
                  }
               }
            } finally {
               agi = var21;
            }

            this.el(var1, var101, var103);
            boolean var105 = false;
            if (SyncController.r && this.adn != null) {
               long var106 = System.nanoTime();
               if (this.adn != this.aju) {
                  this.aju = this.adn;
                  this.ajv = var106;
               }

               if (var106 - this.ajv >= (long)SyncController.p * 1000000L) {
                  var105 = true;
                  this.ajx = this.adn;
               }
            } else {
               this.aju = null;
            }

            float var107 = var105 ? 1.0F : 0.0F;
            if (this.ajw != var107) {
               this.ajw = SyncController.x ? var107 : this.ajw + (var107 - this.ajw) * (1.0F - (float)Math.exp((double)(-21.0F * this.ajg)));
               if (Math.abs(var107 - this.ajw) < 0.004F) {
                  this.ajw = var107;
               }
            }

            if (this.ajw > 0.01F && this.ajx != null) {
               float var108 = agi;
               agi = var108 * this.ajw;

               try {
                  this.er(var1, this.ajx, var9, var10);
               } finally {
                  agi = var108;
               }
            } else if (!var105) {
               this.ajx = null;
            }
         }

         agi = var11;
         this.ul();
         if (this.adi || this.adj) {
            boolean var96 = this.uc(var1, 0, var9, var10);

            try {
               this.fp(var1, var9, var10);
               this.fo(var1, var9, var10, this.uf(0, var7, var9), this.ug(0, var8));
            } finally {
               this.ud(var1, var96);
            }
         } else if (this.bsn[0] != 0) {
            this.ui(var1, var9, var10);
         }

         if (this.nb()) {
            this.bqd = (float)var3 / var6;
            boolean var97 = this.uc(var1, 1, var9, var10);

            try {
               this.oh(var1, var9, var10, this.uf(1, var7, var9), this.ug(1, var8));
            } finally {
               this.ud(var1, var97);
            }
         }

         if (this.adt != null || this.adu != null || this.adv != null) {
            boolean var98 = this.uc(var1, 2, var9, var10);
            int var102 = this.uf(2, var7, var9);
            int var104 = this.ug(2, var8);

            try {
               if (this.adt != null) {
                  this.pl(var1, var9, var10, var102, var104);
               }

               if (this.adu != null) {
                  this.pq(var1, var9, var10, var102, var104);
               }

               if (this.adv != null) {
                  this.pz(var1, var9, var10, var102, var104);
               }
            } finally {
               this.ud(var1, var98);
            }
         } else if (this.bsn[2] != 0) {
            this.uj(var1, var9, var10);
         }

         if (this.act != null) {
            boolean var99 = this.uc(var1, 3, var9, var10);

            try {
               this.dq(var1, var9, var10);
            } finally {
               this.ud(var1, var99);
            }
         } else if (this.bsn[3] != 0) {
            this.uk(var1, var9, var10);
         }

         var1.getMatrices().popMatrix();
         if (SyncController.s && !this.nb()) {
            CoreZoneProcessor var100 = this.dp();
            if (var100 != null) {
               try {
                  var100.o(var1, var2, var3, this.acs);
               } catch (Throwable var87) {
               }
            }
         }

         if (ThemeCache.c()) {
            applyTheme();
         }

         try {
            NoticeQueue.d(var1, a.getWindow().getScaledWidth());
         } catch (Throwable var86) {
         }
      }
   }

   private CoreZoneProcessor dp() {

      CoreZoneProcessor var1 = null;

      try {
         if (ConfigBridge.c != null && ConfigBridge.c.c() != null) {
            var1 = ConfigBridge.c.c().a(CoreZoneProcessor.class);
         }
      } catch (Throwable var7) {
      }

      long var2 = System.nanoTime();
      boolean var4 = this.akc == 0L || var2 - this.akc > 250000000L;
      float var5 = var4 ? 0.0F : Math.min(0.1F, (float)(var2 - this.akc) / 1.0E9F);
      this.akc = var2;
      boolean var6 = var1 != null && var1.f;
      this.akb = var6 ? 1.0F : (var4 ? 0.0F : Math.max(0.0F, this.akb - var5 / 0.24F));
      return var1 == null || !var6 && !(this.akb > 0.0F) ? null : var1;
   }

   private void dq(DrawContext var1, int var2, int var3) {

      BlockCalculator var4 = this.act;
      if (var4 != null) {
         this.es(var1, var2, var3);
         int var5 = -1994665119 ^ -1994664969;
         byte var6 = 62;
         int var7 = (var2 - var5) / 2;
         int var8 = (var3 - var6) / 2;
         et(var1, var7, var8, var5, var6, 10);
         ci(var1, (float)(var7 - 1), (float)(var8 - 1), (float)(var5 + 2), (float)(var6 + 2), 11.0F, true, true, true, true, this.ck());
         bu(var1, var7 - 1, var8 - 1, var5 + 2, var6 + 2, 11, aac);
         bu(var1, var7, var8, var5, var6, 10, yv ? cg(zz) : xt);
         bv(
            var1,
            var7 + 10,
            var8 + 1,
            var7 + var5 - 10,
            var8 + 2,
            n(1853123417 ^ 1853123494, -1293475920 ^ -1293476017, -1534220876 ^ -1534220981, yv ? 22 : 14)
         );
         this.be(var1, ((InitAdapter)var4).a, var4.aK, var7 + 10, var8 + 8, yi, false);
         boolean var10 = var4 instanceof TimingEntry;
         String var11 = var10 ? acw[0] + ss(var4.i()) + acw[3] + acw[1] + ss(var4.j()) + acw[3] : acw[0] + ss(var4.i()) + acw[1] + ss(var4.j());
         this.ay(var1, var11, var7 + 10, var8 + 20, yk, false);
         int var12 = var7 + 10;
         int var13 = var8 + 32;
         int var14 = var5 - 20;
         byte var15 = 16;
         bu(var1, var12, var13, var14, var15, 6, this.acv ? n(-1176194804 ^ -1176194638, 80, 92, -1984497781 ^ -1984497887) : (yv ? aac : yg));
         bu(var1, var12 + 1, var13 + 1, var14 - 2, var15 - 2, 5, yv ? aad : n(9, 9, 14, 748420318 ^ 748420129));
         String var16 = System.currentTimeMillis() % 1000L < 500L ? this.acu + abp[8] : this.acu;
         this.ay(var1, var16, var12 + 6, var13 + 4, this.acv ? n(1113869452 ^ 1113869415, 120, 1857013350 ^ 1857013476, 1072713043 ^ 1072713132) : yi, false);
         if (var10) {
            this.ay(var1, acw[3], var12 + var14 - 6 - this.bd(acw[3]), var13 + 4, yk, false);
         }

         String var17 = acw[2];
         this.ay(var1, var17, var7 + (var5 - this.bd(var17)) / 2, var8 + var6 - 11, yk, false);
      }
   }

   private static String dr() {

      int var0 = ConfigBridge.USER_DAYS;
      if (var0 == -2) {
         return abp[3];
      } else if (var0 == -1) {
         return abp[4];
      } else if (var0 <= 0) {
         return abp[5];
      } else {
         return abp[2];
      }
   }

   private void ds(DrawContext var1, int var2, int var3, int var4, int var5, float var6) {

      int var7 = this.ake ? 0 : FieldVolumeCache.m();
      if ((var7 & 2) != 0) {
         try {
            float var8 = var6 * (float)a.getWindow().getScaleFactor();
            SceneLayerCache.c(var1, var2, var3, var8, var4, var5, System.nanoTime());
         } catch (Throwable var9) {
            this.ake = true;
         }
      }
   }

   private void dt(DrawContext var1, int var2) {

      int var3 = aas != 0 ? aas : 1922524877 ^ -1922561412;
      int var4 = cq(var3, -1, 0.5F);
      float var5 = 5.0F;
      if (ba() && yv) {
         float var20 = (float)this.bb();
         int var21 = Math.max(6, Math.round(10.0F * var20));
         float var8 = (float)HudFont.m(aki, var21) / var20;
         float var9 = (float)Math.round(((float)var2 - var8) / 2.0F * var20) / var20;
         int[] var10 = HudFont.s(var1, var9, var5, 10.0F);

         try {
            int var11 = var10[0];
            float var12 = Math.max(1.0F, var8 * var20);
            int var13 = 0;

            for (int var14 = aki.length(); var13 < var14; var13++) {
               float var15 = (float)(var11 - var10[0]) / var12;
               int var16 = cq(var3, var4, var15 < 0.0F ? 0.0F : (var15 > 1.0F ? 1.0F : var15));
               var11 += HudFont.o(var1, aki.charAt(var13), var11, var10[1], var10[2], var16, false);
            }
         } finally {
            HudFont.aa(var1);
         }
      } else {
         float var6 = 1.25F;
         int var7 = Math.round(((float)var2 - (float)this.bd(aki) * var6) / 2.0F);
         this.gq(var1, aki, (float)var7, var5, var6, var3, false);
      }
   }

   private void du(DrawContext var1, int var2) {

      int var3 = (var2 - (-451553898 ^ -451553974)) / 2;
      boolean var4 = cc(var1, (float)var3 - 8.0F - 2.0F, 10.0F, (float)(var3 + (-2014239182 ^ -2014238994)) + 8.0F + 2.0F, 50.0F);

      try {
         this.dv(var1, var2);
      } finally {
         if (var4) {
            cd();
         }
      }
   }

   private void dv(DrawContext var1, int var2) {

      int var3 = -2133214747 ^ -2133214919;
      byte var4 = 18;
      int var5 = (var2 - var3) / 2;
      byte var6 = 20;
      boolean var7 = this.abx;
      int var8 = var4 / 2;
      if (!this.a(var1, (float)var5, (float)var6, (float)var3, (float)var4, var8)) {
         cm(var1, (float)var5, (float)var6, (float)var3, (float)var4, (float)var8, -1961977127 ^ -1156670759);
         ci(var1, (float)var5, (float)var6, (float)var3, (float)var4, (float)var8, true, true, true, true, yy);
         bu(var1, var5, var6, var3, var4, var8, var7 ? zl : zc);
         bu(var1, var5 + 1, var6 + 1, var3 - 2, var4 - 2, var8 - 1, cg(var7 ? zi : zh));
      }

      dn(var1, var5 + 8, var6 + 6, var7 ? zm : yk);
      int var9 = var5 + 21;
      if (this.aby.isEmpty() && !var7) {
         this.ay(var1, abo[2], var9, var6 + 5, yk, false);
      } else {
         String var10 = var7 && System.currentTimeMillis() % 1000L < 500L ? abp[8] : "";
         this.ay(var1, this.aby + var10, var9, var6 + 5, yi, false);
         if (var7 && !this.aby.isEmpty()) {
            this.ay(var1, abp[9], var5 + var3 - 12, var6 + 5, yj, false);
         }
      }
   }

   private void dw(DrawContext var1, ParserEngine var2, int var3, int var4) {

      this.dx(var1, var2, this.abs.getOrDefault(var2, 10), this.abt.getOrDefault(var2, 48), var3, var4);
   }

   private void dx(DrawContext var1, ParserEngine var2, int var3, int var4, int var5, int var6) {

      boolean var7 = this.afi < 0
         && cc(
            var1,
            (float)var3 - 8.0F - 2.0F,
            (float)var4 - 8.0F - 2.0F,
            (float)(var3 + this.abr) + 8.0F + 2.0F,
            (float)(var4 + 24 + (1102877191 ^ 1102877551) + 5) + 8.0F + 2.0F + 2.0F
         );

      try {
         this.eb(var1, var2, var3, var4, var5, var6);
      } finally {
         if (var7) {
            cd();
         }
      }
   }

   private void dy(ParserEngine var1, List<BuilderFactory> var2) {

      assert var1 != null
         && var2 != null
         && this.akn != null
         && this.akk != null
         && this.akn.length == 8
         && this.akk.length == 8
         && this.akl.length == 8
         && this.akm.length == 8
         && anu != null
         && anu.length == (-1718944234 ^ -1718944258)
         && akp != null
         && akp.length == (172344667 ^ 172345179)
         && xs != null
         && xs.length > 0
         && abp != null
         && abp.length > 10 : "countOn:" + " bad s" + "tate";

      int var3 = var1.ordinal() & 7;
      int var4 = 0;

      try {
         int var5 = 0;

         for (int var6 = var2.size(); var5 < var6; var5++) {
            BuilderFactory var7 = (BuilderFactory)var2.get(var5);
            if (var7.f) {
               var4++;
            }
         }
      } catch (RuntimeException var8) {
         throw var8;
      }

      if (var4 != this.akl[var3] || this.akn[var3] == null || this.ako != ahd) {
         if (this.ako != ahd) {
            this.ako = ahd;
            Arrays.fill(this.akl, -1);
         }

         this.akl[var3] = var4;
         this.akn[var3] = gy(var4);
         this.akm[var3] = this.bd(this.akn[var3]);
      }

      this.akk[var3] = this.ajh;
   }

   private void dz(int var1) {

      if (this.akr != ahd) {
         this.akr = ahd;
         Arrays.fill(this.akq, 0);
      }

      String var2 = akp[var1];
      if (var2 == null) {
         var2 = fh(var1);
         akp[var1] = var2;
      }

      this.akq[var1] = this.bd(var2);
   }

   private void ea(BuilderFactory var1) {

      if (this.akt != ahd) {
         this.aks.clear();
         this.akt = ahd;
      }

      this.aks.put(var1, this.bf(var1.c, var1.cK));
   }

   private void eb(DrawContext var1, ParserEngine var2, int var3, int var4, int var5, int var6) {

      int var7 = this.abr;
      byte var8 = 10;
      boolean var9 = this.abv.contains(var2);
      float var10 = var9 ? 0.0F : 1.0F;
      float var11 = this.aiy.getFloat(var2);
      if (var11 != var10 || !this.aiy.containsKey(var2) || this.ajb.getFloat(var2) != 0.0F) {
         var11 = this.cx(this.aiy, this.ajb, var2, var10, var9 ? 24.0F : 19.0F);
      }

      boolean var12 = this.afi >= 0;
      int var13 = var5;
      int var14 = var6;
      int var15 = 1;
      if (var12) {
         var15 = FrameKeeper.u(this.afi, (float)var3, (float)var4, (float)(var3 + var7), (float)(var4 + 24));
         var13 = FrameKeeper.bmx;
         var14 = FrameKeeper.bmy;
         if (ahs) {
            var15 = 1;
         }
      }

      boolean var16 = var11 <= 0.02F;
      boolean var17 = var13 >= var3 && var13 <= var3 + var7 && var14 >= var4 && var14 < var4 + 24;
      float var18 = var17 ? 1.0F : 0.0F;
      float var19 = this.aiw.getFloat(var2);
      if (var19 != var18 || !this.aiw.containsKey(var2)) {
         var19 = this.cv(this.aiw, var2, var18, 21.0F);
      }

      int var20 = var19 <= 0.0F ? za : (var19 >= 1.0F ? zb : cq(za, zb, var19));
      List var21 = this.y(var2);
      int var22 = this.ct(var21);
      int var23 = var22 + 5;
      int var24 = Math.min(2120989479 ^ 2120989263, var23);
      int var25 = Math.max(0, var23 - (56961560 ^ 56961904));
      float var26 = this.dd(var2, this.abu.getOrDefault(var2, 0), var25);
      int var27 = var11 <= 0.002F ? 0 : (var11 >= 0.999F ? var24 : Math.round((float)var24 * var11));
      var27 = var27 < 1 ? 0 : var27;
      this.co(var1, var3, var4, var7, var27, var20, var12);
      if (var12) {
         this.wd(var1, var3, var4, var7, 24, var8, 0, 0, 1, true, true, var16);
      }

      String var28 = null;
      int var29 = 0;
      if (SyncController.ab) {
         int var30 = var2.ordinal() & 7;
         if (this.akk[var30] != this.ajh || this.ako != ahd) {
            this.dy(var2, var21);
         }

         var28 = this.akn[var30];
         var29 = var3 + var7 - 19 - this.akm[var30];
         if ((float)(var3 + 8) + (float)this.wh(var2) * this.aeq + 6.0F > (float)var29) {
            var28 = null;
         }
      }

      float var87 = this.ajg;

      try {
         for (int var31 = 0; var31 < var15; var31++) {
            if (var12) {
               this.wc(var1, var31, var15);
            }

            try {
               if (!yv) {
                  bv(var1, var3 + var8 - 4, var4 + 1, var3 + var7 - var8 + 4, var4 + 2, yr);
                  if (!var16 && var27 >= var8) {
                     bv(var1, var3 + 1, var4 + 24 - 1, var3 + var7 - 1, var4 + 24, zc);
                  }
               }

               int var32 = zk ? -563271381 ^ 563273169 : (yv ? yi : -1234831544 ^ 1233589694);
               int var33 = var19 <= 0.0F ? var32 : (var19 >= 1.0F ? -1 : cq(var32, -1, var19));
               if (this.aeq > 1.001F) {
                  this.wi(var1, var2, var3, var4, var33);
               } else {
                  this.be(var1, var2.a, var2.aK, var3 + 8, var4 + 8, var33, !yv);
               }

               if (var19 > 0.01F && !var16) {
                  float var34 = ((float)this.wh(var2) * this.aeq + 4.0F) * var19;
                  if (var34 > 0.5F) {
                     bt(var1, (float)(var3 + 8), (float)(var4 + 24 - 2), var34, 1.0F, 0.0F, var19 >= 1.0F ? zl : dk(zl, var19), false, false, false, false);
                  }
               }

               if (var28 != null) {
                  this.ay(var1, var28, var29, var4 + 8, var19 <= 0.0F ? yk : cq(yk, yj, var19), false);
               }

               int var93 = var3 + var7 - 11;
               int var35 = var4 + 10;
               int var36 = var19 <= 0.0F ? yk : (var19 >= 1.0F ? zm : cq(yk, zm, var19));
               if (var11 < 0.5F) {
                  dl(var1, var93 - 1, var35, 3, 1, var36);
               } else {
                  dl(var1, var93, var35 - 1, 3, 0, var36);
               }
            } finally {
               if (var12) {
                  var1.getMatrices().popMatrix();
                  if (var15 > 1) {
                     var1.disableScissor();
                  }
               }

               this.ajg = 0.0F;
            }
         }
      } finally {
         this.ajg = var87;
      }

      if (var27 >= 1) {
         int var88 = var4 + 24;
         int var89 = Math.max(1, Math.min(var8, Math.min(var7 / 2, var27 / 2)));
         if (var12) {
            this.wd(var1, var3, var88, var7, var27, var89, 0, 0, 1, false, false, true);
            if (yv && var27 > var8 + 2) {
               int var90 = Math.min(var27 - var8, 28);
               FrameKeeper.cg = true;
               this.wb(var1, (float)(var3 + 1), (float)var88, (float)(var3 + var7 - 1), (float)(var88 + var90));
               FrameKeeper.cg = false;

               try {
                  int var94 = agi >= 1.0F ? ys : dk(ys, agi);
                  int var97 = agi >= 1.0F ? yt : dk(yt, agi);
                  if (ahq) {
                     bw(var1, var3 + 1, var88, var3 + var7 - 1, var88 + var90, var94, var97);
                  } else {
                     var1.fillGradient(var3 + 1, var88, var3 + var7 - 1, var88 + var90, var94, var97);
                  }
               } finally {
                  var1.getMatrices().popMatrix();
               }
            }
         } else if (yv && var27 > var8 + 2) {
            int var91 = agi >= 1.0F ? ys : dk(ys, agi);
            int var95 = agi >= 1.0F ? yt : dk(yt, agi);
            if (aiq != null) {
               ce(var1, (float)(var3 + 1), (float)var88, (float)(var3 + var7 - 1), (float)(var88 + Math.min(var27 - var8, 28)), var91, var95);
            } else {
               var1.fillGradient(var3 + 1, var88, var3 + var7 - 1, var88 + Math.min(var27 - var8, 28), var91, var95);
            }
         }

         int var92 = Math.max(var88, var88 + var27 - 5);
         if (!var12) {
            nr(var1, var3, var88, var3 + var7, var92);
         }

         float var96 = this.df(var26);
         boolean var98 = dh(var1, var96);

         try {
            this.ee(var1, var3, var88, var7, var92, this.de(var26), var21, var5, this.dg(var6, var96));
         } finally {
            di(var1, var98);
         }

         if (!var12) {
            var1.disableScissor();
         }

         if (var23 > var24 && var11 > 0.9F) {
            int var99 = var27 - 10;
            int var37 = Math.max(12, var99 * var24 / Math.max(1, var23));
            int var38 = Math.max(1, var23 - var24);
            float var39 = (float)(var88 + 2) + (float)(var99 - var37) * Math.max(0.0F, Math.min(1.0F, var26 / (float)var38));
            int var40 = var12 ? Math.round(var39) : (int)Math.floor((double)var39);
            float var41 = var12 ? 0.0F : (float)Math.round((var39 - (float)var40) * (float)Math.max(1, ahd)) / (float)Math.max(1, ahd);
            if (var12) {
               FrameKeeper.cg = true;
               this.wb(var1, (float)(var3 + var7 - 4), (float)(var88 + 2), (float)(var3 + var7 - 1), (float)(var88 + 2 + var99));
               FrameKeeper.cg = false;

               try {
                  bv(var1, var3 + var7 - 3, var88 + 2, var3 + var7 - 2, var88 + 2 + var99, -1887180315 ^ -2089019878);
                  bu(var1, var3 + var7 - 4, var40, 3, var37, 1, yu);
               } finally {
                  var1.getMatrices().popMatrix();
               }
            } else {
               bv(var1, var3 + var7 - 3, var88 + 2, var3 + var7 - 2, var88 + 2 + var99, -704224881 ^ -621175184);
               boolean var42 = dh(var1, var41);

               try {
                  bu(var1, var3 + var7 - 4, var40, 3, var37, 1, yu);
               } finally {
                  di(var1, var42);
               }
            }
         }
      }
   }

   private void ec(DrawContext var1, int var2, int var3, int var4) {

      int var5 = this.abr + 40;
      int var6 = (var2 - var5) / 2;
      boolean var7 = cc(var1, (float)var6 - 8.0F - 2.0F, 38.0F, (float)(var6 + var5) + 8.0F + 2.0F, 449.0F);

      try {
         this.ed(var1, var2, var3, var4);
      } finally {
         if (var7) {
            cd();
         }
      }
   }

   private void ed(DrawContext var1, int var2, int var3, int var4) {

      int var5 = this.abr + 40;
      int var6 = (var2 - var5) / 2;
      byte var7 = 48;
      int var8 = this.ct(this.abz) + 5;
      int var9 = Math.min(-1093008117 ^ -1093008285, Math.max(17, var8));
      this.co(var1, var6, var7, var5, var9, za, false);
      bv(var1, var6 + 10 - 4, var7 + 1, var6 + var5 - 10 + 4, var7 + 2, yr);
      bv(var1, var6 + 1, var7 + 24 - 1, var6 + var5 - 1, var7 + 24, zc);
      this.ay(var1, this.abz.size() + abo[3], var6 + 8, var7 + 8, yi, false);
      int var10 = var7 + 24;
      int var11 = Math.max(var10, var10 + var9 - 5);
      int var12 = Math.max(0, var8 - (1854607778 ^ 1854607562));
      if (this.aca > var12) {
         this.aca = var12;
      }

      float var13 = this.dd(aje, this.aca, var12);
      float var14 = this.df(var13);
      var1.enableScissor(var6, var10, var6 + var5, var11);
      boolean var15 = dh(var1, var14);

      try {
         this.ee(var1, var6, var10, var5, var11, this.de(var13), this.abz, var3, this.dg(var4, var14));
      } finally {
         di(var1, var15);
      }

      var1.disableScissor();
   }

   private void ee(DrawContext var1, int var2, int var3, int var4, int var5, int var6, List<BuilderFactory> var7, int var8, int var9) {

      assert var1 != null
         && var7 != null
         && this.aiz != null
         && this.aja != null
         && this.aiw != null
         && this.aix != null
         && this.aiy != null
         && this.abw != null
         && xs != null
         && xs.length > 0
         && abn != null
         && abn.length == 3
         && abo != null
         && abo.length > 2
         && abp != null
         && abp.length > 10
         && agk != null
         && agk.length > 2
         && agz != null
         && agz.length == 3
         && xs[0] != null
         && abn[0] != null
         && abn[1] != null
         && abn[2] != null
         && abo[0] != null
         && abo[1] != null
         && agz[0] != null
         && agz[1] != null
         && agz[2] != null
         && abp[0] != null
         && abp[1] != null
         && agk[0] != null : "renderList: b" + "ad l" + "ist";

      boolean var10 = this.afi >= 0;
      int var11 = var9 >= var3 && var9 < var5 ? var9 : -2061558876 ^ 1159666596;
      float var12 = var1.getMatrices().m11();
      int var13 = var12 > 0.01F ? (int)Math.ceil((double)(1.0F / var12)) + 1 : -1405724445 ^ -1405658909;
      int var14 = var3 - var6;
      boolean var15 = var7 != this.abz && !var7.isEmpty() && ((BuilderFactory)var7.get(0)).i() == ParserEngine.CT;
      int var16 = -1;
      BuilderFactory var17 = null;
      Object var18 = null;

      try {
         int var19 = 0;

         for (int var20 = var7.size(); var19 < var20; var19++) {
            var17 = (BuilderFactory)var7.get(var19);
            int var21 = var15 ? an(var17) : -1;
            if (var21 >= 0 && var21 != var16) {
               if (var10 ? var14 >= var3 && var14 + 10 <= var5 : var14 + 10 > var3 - var13 && var14 < var5) {
                  if (var10) {
                     int var22 = FrameKeeper.u(this.afi, (float)var2, (float)var14, (float)(var2 + var4), (float)(var14 + 10));
                     if (ahs) {
                        var22 = 1;
                     }

                     for (int var23 = 0; var23 < var22; var23++) {
                        this.wc(var1, var23, var22);

                        try {
                           this.ap(var1, var21, var2, var14, var4);
                        } finally {
                           var1.getMatrices().popMatrix();
                           if (var22 > 1) {
                              var1.disableScissor();
                           }
                        }
                     }
                  } else {
                     this.ap(var1, var21, var2, var14, var4);
                  }
               }

               var14 += 10;
            }

            var16 = var21;
            List var96 = var17.k();
            int var97 = var96.size();
            int var24 = 0;

            for (int var25 = 0; var25 < var97; var25++) {
               if (!(var96.get(var25) instanceof PlacementEntry)) {
                  var24++;
               }
            }

            float var98 = this.aiz.containsKey(var17) ? this.aiz.getFloat(var17) : (this.abw.contains(var17) ? 1.0F : 0.0F);
            if (var10 ? var14 < var3 || var14 + 17 > var5 : var14 + 17 <= var3 - var13 || var14 >= var5) {
               if (this.aiw.getFloat(var17) != 0.0F || !this.aiw.containsKey(var17)) {
                  this.cv(this.aiw, var17, 0.0F, 21.0F);
               }

               float var99 = var17.f ? 1.0F : 0.0F;
               if (this.aix.getFloat(var17) != var99 || !this.aix.containsKey(var17)) {
                  this.cv(this.aix, var17, var99, 24.0F);
               }
            } else if (var10) {
               int var26 = FrameKeeper.u(this.afi, (float)var2, (float)var14, (float)(var2 + var4), (float)(var14 + 17));
               int var27 = FrameKeeper.bmx;
               int var28 = FrameKeeper.bmy;
               if (ahs) {
                  var26 = 1;
               }

               float var29 = this.ajg;

               try {
                  for (int var30 = 0; var30 < var26; var30++) {
                     this.wc(var1, var30, var26);

                     try {
                        this.eg(var1, var17, var2, var14, var4, var27, var28, var98, var24);
                     } finally {
                        var1.getMatrices().popMatrix();
                        if (var26 > 1) {
                           var1.disableScissor();
                        }

                        this.ajg = 0.0F;
                     }
                  }
               } finally {
                  this.ajg = var29;
               }
            } else {
               this.eg(var1, var17, var2, var14, var4, var8, var11, var98, var24);
            }

            var14 += 17;
            if (var98 > 0.001F && var24 > 0) {
               int var100 = this.bqg && var17 instanceof ViewCacheIndex ? 73398137 ^ 73398257 : 0;
               int var101 = var100 + var24 * 18;
               int var102 = Math.round((float)var101 * var98);
               var102 = var102 < 0 ? 0 : (var102 > var101 ? var101 : var102);
               float var104 = var100 > 0 ? Math.max(0.0F, Math.min(1.0F, (var98 * (float)var101 - (float)var100) / (float)(var101 - var100))) : var98;
               if (var102 > 0) {
                  int var105 = var98 < 0.999F ? 1563897256 ^ -1657328216 : var9;
                  int var31 = Math.max(var3, var14) - var13;
                  int var32 = Math.min(var5, var14 + var102);
                  if (var10) {
                     var31 = Math.max(var3, var14);
                  } else {
                     nr(var1, var2, var14, var2 + var4, var14 + var102);
                  }

                  try {
                     if (var100 > 0 && !var10) {
                        this.ef(var1, (ViewCacheIndex)var17, var2, var14, var4, var100, var8, var105, var31, var32);
                     }

                     int var33 = var14 + var100;
                     int var34 = 0;

                     for (int var35 = 0; var35 < var97; var35++) {
                        var18 = (InitAdapter)var96.get(var35);
                        if (!(var18 instanceof PlacementEntry)) {
                           this.ais = (var34 == 0 && var100 == 0 ? 1 : 0) | (var34 == var24 - 1 ? 2 : 0);
                           int var36 = var98 >= 1.0F ? var33 : var33 + cz(var104, var34, var24);
                           if (!var10) {
                              this.eh(var1, (InitAdapter)var18, var2, var36, var4, var8, var105, var31, var32);
                           } else if (var36 >= var31 && var36 + 18 <= var32) {
                              int var37 = FrameKeeper.u(this.afi, (float)var2, (float)var36, (float)(var2 + var4), (float)(var36 + 18));
                              int var38 = FrameKeeper.bmx;
                              int var39 = var98 < 0.999F ? -1560378467 ^ 1660847005 : FrameKeeper.bmy;
                              if (ahs) {
                                 var37 = 1;
                              }

                              float var40 = this.ajg;

                              try {
                                 for (int var41 = 0; var41 < var37; var41++) {
                                    this.wc(var1, var41, var37);

                                    try {
                                       this.eh(var1, (InitAdapter)var18, var2, var36, var4, var38, var39, -1042793337 ^ 30948487, -1989925577 ^ -1231299896);
                                    } finally {
                                       var1.getMatrices().popMatrix();
                                       if (var37 > 1) {
                                          var1.disableScissor();
                                       }

                                       this.ajg = 0.0F;
                                    }
                                 }
                              } finally {
                                 this.ajg = var40;
                              }
                           } else {
                              this.eh(
                                 var1, (InitAdapter)var18, var2, var36, var4, var8, 389542076 ^ -684199748, -358475014 ^ -715266811, -2006710696 ^ 1214514776
                              );
                           }

                           var33 += 18;
                           var34++;
                        }
                     }
                  } finally {
                     if (!var10) {
                        var1.disableScissor();
                     }
                  }
               }

               var14 += var102;
            }
         }
      } catch (RuntimeException var93) {
         throw var93;
      }
   }

   private void ef(DrawContext var1, ViewCacheIndex var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {

      boolean var11 = agi >= 0.999F;
      cj(var1, (float)(var3 + 6), (float)var4, (float)(var5 - 9), (float)var6, 4.0F, var11 ? zg : dk(zg, agi), true, true, false, false);
      cj(var1, (float)(var3 + 6), (float)(var4 + 3), 2.0F, (float)(var6 - 3), 1.0F, var11 ? zd : dk(zd, agi), true, true, false, false);
      if (var4 + var6 > var9 && var4 < var10) {
         int var12 = var3 + 11;
         int var13 = var5 - 17;
         int var14 = var4 + 4;
         int var15 = var6 - 7;
         bu(var1, var12 - 1, var14 - 1, var13 + 2, var15 + 2, 4, zd);
         oe(var1, var12, var14, var13, var15);
         boolean var16 = false;

         try {
            var2.b();
            BevelPassCache.w(this.bqh);
            var16 = PosePassCache.drawInspect(var1, var12 + 2, var14 + 2, var13 - 4, var15 - 4);
         } catch (Throwable var20) {
            var16 = false;
         }

         boolean var17 = var16 && var7 >= var12 && var7 < var12 + var13 && var8 >= var14 && var8 < var14 + var15 && var8 >= var9 && var8 < var10;
         this.bqi = this.bqi + ((var17 ? 1.0F : 0.0F) - this.bqi) * (SyncController.x ? 1.0F : 1.0F - (float)Math.exp((double)(-14.0F * this.ajg)));
         int var18 = (int)((float)(yk >>> 24 & (176690888 ^ 176690743)) * this.bqi);
         if (var18 >= 8) {
            String var19 = bqe[1];
            this.ay(var1, var19, var12 + var13 - this.bd(var19) - 5, var14 + var15 - 12, o(yk, var18), false);
         }
      } else {
         this.bqi = 0.0F;
      }
   }

   private void eg(DrawContext var1, BuilderFactory var2, int var3, int var4, int var5, int var6, int var7, float var8, int var9) {

      boolean var10 = var2.f;
      boolean var11 = var6 >= var3 && var6 <= var3 + var5 && var7 >= var4 && var7 < var4 + 17;
      float var12 = var11 ? 1.0F : 0.0F;
      float var13 = this.aiw.getFloat(var2);
      if (var13 != var12 || !this.aiw.containsKey(var2)) {
         var13 = this.cv(this.aiw, var2, var12, 21.0F);
      }

      float var14 = var10 ? 1.0F : 0.0F;
      float var15 = this.aix.getFloat(var2);
      if (var15 != var14 || !this.aix.containsKey(var2)) {
         var15 = this.cv(this.aix, var2, var14, 24.0F);
      }

      boolean var16 = agi >= 0.999F;
      if (var15 > 0.01F) {
         int var17 = var15 >= 1.0F ? ze : dk(ze, var15);
         cj(var1, (float)(var3 + 3), (float)(var4 + 1), (float)(var5 - 6), 15.0F, 4.0F, var16 ? var17 : dk(var17, agi), true, true, true, true);
         int var18 = var13 <= 0.0F ? zn : (var13 >= 1.0F ? zo : cq(zn, zo, var13));
         if (var15 < 1.0F) {
            var18 = dk(var18, var15);
         }

         cj(var1, (float)(var3 + 5), (float)(var4 + 4), 2.0F, 9.0F, 1.0F, var16 ? var18 : dk(var18, agi), true, true, true, true);
      }

      if (var13 > 0.01F && var15 < 0.99F) {
         int var27 = dk(zf, var13 * (1.0F - var15));
         cj(var1, (float)(var3 + 3), (float)(var4 + 1), (float)(var5 - 6), 15.0F, 4.0F, var16 ? var27 : dk(var27, agi), true, true, true, true);
         float var29 = 9.0F;
         float var19 = var29 * var13;
         if (var19 > 0.5F) {
            int var20 = Math.round((float)(var4 + 4) + (var29 - var19) / 2.0F);
            int var21 = dk(zn, 0.55F * var13 * (1.0F - var15));
            cj(var1, (float)(var3 + 5), (float)var20, 2.0F, (float)Math.max(1, Math.round(var19)), 1.0F, var16 ? var21 : dk(var21, agi), true, true, true, true);
         }
      }

      float var28 = Math.max(var13, var15);
      int var30 = var28 <= 0.0F ? yj : (var28 >= 1.0F ? yi : cq(yj, yi, var28));
      int var10004 = var3 + 12;
      int var10005 = var4 + 4;
      if (yv) {
      }

      this.be(var1, var2.c, var2.cK, var10004, var10005, var30, false);
      if (SyncController.ac) {
         int var31 = var2.i.d;
         if (var31 >= 0 && var31 < (-1030669452 ^ -1030669964)) {
            if (this.akr != ahd || this.akq[var31] == 0) {
               this.dz(var31);
            }

            if (this.akt != ahd || !this.aks.containsKey(var2)) {
               this.ea(var2);
            }

            int var33 = var3 + var5 - (var9 > 0 ? 18 : 9) - this.akq[var31];
            if (var33 >= var3 + 12 + this.aks.getInt(var2) + 6) {
               this.ay(var1, akp[var31], var33, var4 + 4, var28 <= 0.0F ? yk : cq(yk, yj, var28), false);
            }
         }
      }

      if (var9 > 0) {
         int var32 = var28 <= 0.0F ? yk : (var28 >= 1.0F ? yi : cq(yk, yi, var28));
         int var34 = var3 + var5 - 11;
         int var35 = var4 + 8;
         float var22 = (float)var34 + 1.5F;
         Matrix3x2fStack var23 = var1.getMatrices();
         var23.pushMatrix();

         try {
            var23.translate(var22, (float)var35);
            var23.rotate(var8 * (float) (Math.PI / 2));
            var23.translate(-var22, (float)(-var35));
            dl(var1, var34, var35, 3, 1, var32);
         } finally {
            var23.popMatrix();
         }
      }

      if (var11 && var2.d.length > 0) {
         this.adn = var2;
      }
   }

   private void eh(DrawContext var1, InitAdapter var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {

      if (var4 + 18 > var8 && var4 < var9) {
         boolean var49 = var6 >= var3 && var6 <= var3 + var5 && var7 >= var4 && var7 < var4 + 18;
         float var11 = var49 ? 1.0F : 0.0F;
         float var12 = this.aiw.getFloat(var2);
         if (var12 != var11 || !this.aiw.containsKey(var2)) {
            var12 = this.cv(this.aiw, var2, var11, 21.0F);
         }

         boolean var13 = agi >= 0.999F;
         boolean var14 = (this.ais & 1) != 0;
         boolean var15 = (this.ais & 2) != 0;
         cj(
            var1,
            (float)(var3 + 6),
            (float)var4,
            (float)(var5 - 9),
            18.0F,
            !var14 && !var15 ? 0.0F : 4.0F,
            var13 ? zg : dk(zg, agi),
            var14,
            var14,
            var15,
            var15
         );
         int var16 = var12 <= 0.0F ? zd : (var12 >= 1.0F ? zl : cq(zd, zl, var12));
         int var17 = var14 ? var4 + 3 : var4;
         int var18 = var15 ? var4 + 18 - 3 : var4 + 18;
         cj(
            var1,
            (float)(var3 + 6),
            (float)var17,
            2.0F,
            (float)(var18 - var17),
            !var14 && !var15 ? 0.0F : 1.0F,
            var13 ? var16 : dk(var16, agi),
            var14,
            var14,
            var15,
            var15
         );
         if (var12 > 0.01F) {
            int var19 = var12 >= 1.0F ? zf : dk(zf, var12);
            cj(
               var1,
               (float)(var3 + 8),
               (float)var4,
               (float)(var5 - 11),
               18.0F,
               !var14 && !var15 ? 0.0F : 4.0F,
               var13 ? var19 : dk(var19, agi),
               var14,
               var14,
               var15,
               var15
            );
         }

         int var50 = var12 <= 0.0F ? yj : (var12 >= 1.0F ? yi : cq(yj, yi, var12));
         char[] var20 = var2.a;
         int var21 = var2.aK;
         if (var2 instanceof CheckerBridge var22) {
            this.be(var1, var20, var21, var3 + 12, var4 + 5, var50, yv);
            int var30 = var3 + var5 - 24;
            byte var31 = 16;
            byte var32 = 8;
            int var33 = var4 + 5;
            boolean var34 = var22.f();
            float var35 = this.da(var22, var34 ? 1.0F : 0.0F);
            if (var12 > 0.35F) {
               bp(var1, var30 - 2, var33 - 2, var31 + 4, var32 + 4, dk(zl, 0.3F * var12));
            }

            bp(var1, var30, var33, var31, var32, var35 <= 0.0F ? zp : (var35 >= 1.0F ? zq : cq(zp, zq, var35)));
            float var36 = (float)(var32 - 2);
            float var37 = (float)(var30 + 1) + var35 * ((float)(var31 - 2) - var36);
            bs(var1, var37, (float)(var33 + 1), var36, var35 <= 0.0F ? zr : (var35 >= 1.0F ? zs : cq(zr, zs, var35)));
         } else if (var2 instanceof DialEntry var23) {
            this.be(var1, var20, var21, var3 + 12, var4 + 5, var50, yv);
            int var51 = var23.a_r91();
            String var59 = DialEntry.c(var51);
            int var66 = this.bd(var59);
            this.ay(var1, var59, var3 + var5 - var66 - 8, var4 + 5, zm, yv);
            bq(
               var1,
               var3 + var5 - var66 - 17,
               var4 + 6,
               6,
               var51 >= (1553412618 ^ 1553400542) && var51 < (-1378007047 ^ -1378018251) ? 1793190779 ^ -1794702711 : 299405883 ^ -299417247
            );
         } else if (var2 instanceof BlockCalculator var24) {
            this.be(var1, var20, var21, var3 + 12, var4 + 3, var50, yv);
            double var52 = var24.p();
            double var67 = var24.i();
            double var73 = var24.j();
            String var74 = aa(var24);
            int var75 = this.bd(var74);
            this.ay(var1, var74, var3 + var5 - var75 - 8, var4 + 3, zm, yv);
            int var38 = var3 + 12;
            int var39 = var5 - 24;
            int var40 = var4 + 12;
            if (var49 && this.acl == null && var7 >= var8 && var7 < var9) {
               this.ag(var24, var38, var39, var6, var7 >= var4 + 10, false);
            }

            int var41 = var12 <= 0.0F ? zt : (var12 >= 1.0F ? zu : cq(zt, zu, var12));
            cj(var1, (float)var38, (float)var40, (float)var39, 3.0F, 1.5F, var13 ? var41 : dk(var41, agi), true, true, true, true);
            if (var24 instanceof SpanEntry var76) {
               this.ei(var1, var76, var38, var40, var39, var12, var6, var13);
               return;
            }

            double var42 = var73 - var67;
            double var44 = var42 <= 0.0 ? 0.0 : (var52 - var67) / var42;
            var44 = Math.max(0.0, Math.min(1.0, var44));
            float var46 = (float)((double)var39 * var44);
            if (var46 > 0.5F) {
               int var47 = var12 <= 0.0F ? zv : (var12 >= 1.0F ? zw : cq(zv, zw, var12));
               cj(var1, (float)var38, (float)var40, Math.max(1.0F, var46), 3.0F, 1.5F, var13 ? var47 : dk(var47, agi), true, true, true, true);
            }

            float var78 = 5.0F + 2.0F * var12;
            float var48 = (float)var38 + Math.max(0.0F, Math.min((float)var39 - var78, var46 - var78 / 2.0F));
            bs(var1, var48, (float)var40 + 1.5F - var78 / 2.0F, var78, yi);
         } else if (var2 instanceof SlotEntry var25) {
            this.be(var1, var20, var21, var3 + 12, var4 + 5, var50, yv);
            String var53 = v(var25.f());
            int var60 = this.bd(var53);
            this.ay(var1, var53, var3 + var5 - var60 - 8, var4 + 5, zm, yv);
         } else if (var2 instanceof ItemDescriptor var26) {
            this.be(var1, var20, var21, var3 + 12, var4 + 5, var50, yv);
            String var54 = this.acr == var26 ? abp[10] : qr(var26.d);
            int var61 = this.bd(var54);
            this.ay(var1, var54, var3 + var5 - var61 - 8, var4 + 5, this.acr == var26 ? zl : zm, yv);
         } else if (var2 instanceof BlockSetE var27) {
            this.be(var1, var20, var21, var3 + 12, var4 + 5, var50, yv);
            int var55 = var27.b();
            String var62 = var55 == 0 ? abp[11] : (var55 == 1 ? abp[12] : var55 + abp[13]);
            int var68 = this.bd(var62);
            this.ay(var1, var62, var3 + var5 - var68 - 8, var4 + 5, zm, yv);
         } else if (var2 instanceof MaskEntry var28) {
            this.be(var1, var20, var21, var3 + 12, var4 + 5, var50, yv);
            int var56 = var28.b();
            String var63 = var56 == 0 ? var28.e_r94() : var56 + brd[var56 == 1 ? 2 : 3];
            int var69 = this.bd(var63);
            this.ay(var1, var63, var3 + var5 - var69 - 8, var4 + 5, zm, yv);
         } else if (var2 instanceof TextEntry var29) {
            this.be(var1, var20, var21, var3 + 12, var4 + 5, var50, yv);
            boolean var57 = this.ads == var29;
            String var64 = var29.f();
            if (var64.isEmpty() && !var57) {
               var64 = abp[10];
            }

            String var70 = var57 ? var64 + abp[8] : var64;
            int var72 = this.bd(var70);
            this.ay(var1, var70, var3 + var5 - var72 - 8, var4 + 5, var57 ? zl : zm, false);
         } else {
            this.be(var1, var20, var21, var3 + 12, var4 + 5, yj, false);
            Object var58 = var2.c();
            if (var58 != null) {
               String var65 = v(String.valueOf(var58));
               int var71 = this.bd(var65);
               this.ay(var1, var65, var3 + var5 - var71 - 8, var4 + 5, zm, false);
            }
         }
      } else {
         if (this.aiw.getFloat(var2) != 0.0F || !this.aiw.containsKey(var2)) {
            this.cv(this.aiw, var2, 0.0F, 21.0F);
         }

         if (var2 instanceof CheckerBridge var10) {
            this.da(var10, var10.f() ? 1.0F : 0.0F);
         }
      }
   }

   private void ei(DrawContext var1, SpanEntry var2, int var3, int var4, int var5, float var6, int var7, boolean var8) {

      double var9 = var2.i();
      double var11 = var2.j();
      double var13 = ac(var2.lo(), var9, var11);
      double var15 = ac(var2.hi(), var9, var11);
      float var17 = (float)((double)var5 * var13);
      float var18 = (float)((double)var5 * var15);
      int var19 = var3 + Math.round(var17);
      int var20 = var3 + Math.round(var18);
      if (var20 > var19) {
         int var21 = var6 <= 0.0F ? zv : (var6 >= 1.0F ? zw : cq(zv, zw, var6));
         cj(var1, (float)var19, (float)var4, (float)(var20 - var19), 3.0F, 1.5F, var8 ? var21 : dk(var21, agi), true, true, true, true);
      }

      int var28 = this.ace == var2 ? this.ach : ae((float)var7 + 0.5F, ad(var3, var5, var13, 7.0F), ad(var3, var5, var15, 7.0F), 3.5F);
      float var22 = 5.0F + 2.0F * var6;
      float var23 = var28 == 1 ? 5.0F : var22;
      float var24 = var28 == 0 ? 5.0F : var22;
      float var25 = (float)var3 + Math.max(0.0F, Math.min((float)var5 - var23, var17 - var23 / 2.0F));
      float var26 = (float)var3 + Math.max(0.0F, Math.min((float)var5 - var24, var18 - var24 / 2.0F));
      boolean var27 = var18 - var17 < 0.5F;
      if (var28 == 1) {
         if (!var27) {
            bs(var1, var25, (float)var4 + 1.5F - var23 / 2.0F, var23, yi);
         }

         bs(var1, var26, (float)var4 + 1.5F - var24 / 2.0F, var24, yi);
      } else {
         if (!var27) {
            bs(var1, var26, (float)var4 + 1.5F - var24 / 2.0F, var24, yi);
         }

         bs(var1, var25, (float)var4 + 1.5F - var23 / 2.0F, var23, yi);
      }
   }

   private void ej(int var1) {

      int var2 = (var1 - (270582270 ^ 270582050)) / 2;
      int var3 = var2 + (-1329983457 ^ -1329983293);
      int var4 = var1 - 10 - (var3 + 8);
      int var5 = 0;

      for (int var6 = 0; var6 < 3; var6++) {
         var5 += this.bd(abn[var6]);
      }

      boolean var13 = 6 + var5 + 72 > var4;
      int var7 = 12;
      if (var13) {
         var5 = 0;

         for (int var8 = 0; var8 < 3; var8++) {
            var5 += this.bd(ale[var8]);
         }

         var7 = Math.max(4, Math.min(8, (var4 - 6 - var5) / 6));
      }

      this.alk = var13;
      int var14 = var1 - 10 - (6 + var5 + 6 * var7);
      this.alh = var14;
      var14 += 3;

      for (int var9 = 0; var9 < 3; var9++) {
         int var10 = var7 + this.bd(var13 ? ale[var9] : abn[var9]) + var7;
         this.alf[var9] = var14;
         this.alg[var9] = var10;
         var14 += var10;
      }

      this.ali = var14 + 3 - this.alh;
      boolean var16 = adg;
      int var17 = ConfigBridge.USER_DAYS;
      if (this.alm == null || var17 != this.aln) {
         this.aln = var17;
         this.alm = dr();
      }

      String var11 = var16 ? abp[2] : this.alm;
      int var12 = Math.max(100, 27 + Math.max(this.bd(ek(var16)), this.bd(var11)) + 12);
      this.all = 10 + var12 > var2 - 8;
      this.adc = 10;
      this.add = 9;
      this.ade = this.all ? 26 : var12;
      this.adf = 26;
   }

   private static String ek(boolean var0) {

      return var0 ? abp[0] : (ConfigBridge.USER_NAME.isEmpty() ? abp[1] : ConfigBridge.USER_NAME);
   }

   private void el(DrawContext var1, int var2, int var3) {

      boolean var4 = cc(var1, (float)this.adc - 8.0F - 2.0F, -1.0F, (float)(this.alh + this.ali) + 8.0F + 2.0F, 66.0F);

      try {
         this.en(var1, var2, var3);
         this.ep(var1, var2, var3);
      } finally {
         if (var4) {
            cd();
         }
      }
   }

   private boolean em(int var1, int var2) {

      return var2 >= 9 && var2 <= 35 && (var1 >= this.adc && var1 <= this.adc + this.ade || var1 >= this.alh && var1 <= this.alh + this.ali);
   }

   private void en(DrawContext var1, int var2, int var3) {

      boolean var4 = adg;
      boolean var5 = var4 || !ConfigBridge.USER_NAME.isEmpty();
      int var6 = this.adc;
      int var7 = this.add;
      int var8 = this.ade;
      int var9 = this.adf;
      int var10 = var9 / 2;
      boolean var11 = var2 >= var6 && var2 <= var6 + var8 && var3 >= var7 && var3 <= var7 + var9;
      float var12 = this.cw(adh, var11);
      if (!this.a(var1, (float)var6, (float)var7, (float)var8, (float)var9, var10)) {
         this.cl(var1, var6, var7, var8, var9, var10);
         bu(var1, var6, var7, var8, var9, var10, var12 <= 0.0F ? zc : cq(zc, zl, var12 * 0.8F));
         bu(var1, var6 + 1, var7 + 1, var8 - 2, var9 - 2, var10 - 1, cg(var12 <= 0.0F ? zh : cq(zh, zi, var12)));
      }

      byte var13 = 16;
      int var14 = var6 + var10 - var13 / 2;
      int var15 = var7 + var10 - var13 / 2;
      ClientPlayerEntity var16 = a.player;
      SkinTextures var17 = !var4 && var16 != null ? var16.getSkin() : DefaultSkinHelper.getSteve();
      int var18 = Math.max(8, Math.round((float)var13 * (float)this.bb()));
      boolean var19 = eo(var17, var18);
      boolean var20 = this.wn(var1, (float)var14, (float)var15, (float)(var14 + var13), (float)(var15 + var13));

      try {
         if (var19) {
            bt(
               var1,
               (float)var14 - 0.5F,
               (float)var15 - 0.5F,
               (float)var13 + 1.0F,
               (float)var13 + 1.0F,
               ((float)var13 + 1.0F) / 2.0F,
               zd,
               true,
               true,
               true,
               true
            );
            var1.drawTexture(RenderPipelines.GUI_TEXTURED, alp, var14, var15, 0.0F, 0.0F, var13, var13, var18, var18, var18, var18);
         } else {
            PlayerSkinDrawer.draw(var1, var17, var14, var15, var13);
         }
      } finally {
         if (var20) {
            var1.getMatrices().popMatrix();
         }
      }

      if (!this.all) {
         int var21 = var14 + var13 + 6;
         boolean var22 = yv;
         this.ay(var1, ek(var4), var21, var7 + 5, var5 ? yi : yj, !var22);
         this.ay(var1, var4 ? abp[2] : this.alm, var21, var7 + 14, var22 ? yn : yk, false);
      }
   }

   private static boolean eo(SkinTextures var0, int var1) {

      Identifier var2;
      try {
         var2 = var0.body().texturePath();
      } catch (Throwable var30) {
         return false;
      }

      String var3 = var2 + "|" + var1;
      if (var3.equals(alq)) {
         return alr;
      } else {
         alq = var3;
         alr = false;
         NativeImage var4 = null;
         boolean var5 = false;

         try {
            label208: {
               if (a.getTextureManager().getTexture(var2) instanceof NativeImageBackedTexture var7 && var7.getImage() != null) {
                  var4 = var7.getImage();
                  break label208;
               }

               try (InputStream var8 = ((Resource)a.getResourceManager().getResource(var2).orElseThrow()).getInputStream()) {
                  var4 = NativeImage.read(var8);
                  var5 = true;
               }
            }

            int var34 = Math.max(1, var4.getWidth() / 64);
            NativeImage var35 = new NativeImage(NativeImage.Format.RGBA, var1, var1, false);
            float var9 = (float)var1 / 2.0F;
            float var10 = var9 * var9;

            for (int var11 = 0; var11 < var1; var11++) {
               int var12 = Math.min(7, var11 * 8 / var1);

               for (int var13 = 0; var13 < var1; var13++) {
                  int var14 = 0;

                  for (int var15 = 0; var15 < 4; var15++) {
                     float var16 = (float)var11 + ((float)var15 + 0.5F) / 4.0F - var9;

                     for (int var17 = 0; var17 < 4; var17++) {
                        float var18 = (float)var13 + ((float)var17 + 0.5F) / 4.0F - var9;
                        if (var18 * var18 + var16 * var16 <= var10) {
                           var14++;
                        }
                     }
                  }

                  if (var14 == 0) {
                     var35.setColorArgb(var13, var11, 0);
                  } else {
                     int var36 = Math.min(7, var13 * 8 / var1);
                     int var37 = var4.getColorArgb((8 + var36) * var34, (8 + var12) * var34);
                     int var38 = var4.getColorArgb((40 + var36) * var34, (8 + var12) * var34);
                     int var39 = var38 >>> 24;
                     int var19;
                     if (var39 >= (1668293034 ^ 1668292949)) {
                        var19 = var38 & (1038392698 ^ 1025204869);
                     } else if (var39 == 0) {
                        var19 = var37 & (-131855608 ^ -119802633);
                     } else {
                        int var20 = (
                              (var38 >> 16 & (-577175186 ^ -577175151)) * var39
                                 + (var37 >> 16 & (1836127908 ^ 1836127835)) * ((-808611717 ^ -808611708) - var39)
                           )
                           / (-966753057 ^ -966753248);
                        int var21 = (
                              (var38 >> 8 & (-498584702 ^ -498584707)) * var39
                                 + (var37 >> 8 & (-877884817 ^ -877884784)) * ((-1564610111 ^ -1564610242) - var39)
                           )
                           / (-877099192 ^ -877099081);
                        int var22 = (
                              (var38 & (1620152746 ^ 1620152661)) * var39 + (var37 & (-2051721910 ^ -2051721803)) * ((-2112393029 ^ -2112393148) - var39)
                           )
                           / (-593598746 ^ -593598951);
                        var19 = var20 << 16 | var21 << 8 | var22;
                     }

                     var35.setColorArgb(var13, var11, var14 * (1911353407 ^ 1911353536) / 16 << 24 | var19);
                  }
               }
            }

            a.getTextureManager().registerTexture(alp, new NativeImageBackedTexture(() -> {

               return "lithi" + "um gui face";
            }, var35));
            alr = true;
         } catch (Throwable var32) {
            alr = false;
         } finally {
            if (var5 && var4 != null) {
               var4.close();
            }
         }

         return alr;
      }
   }

   private void ep(DrawContext var1, int var2, int var3) {

      int var4 = this.alh;
      byte var5 = 9;
      int var6 = this.ali;
      byte var7 = 26;
      int var8 = var7 / 2;
      int var9 = -1;
      if (var3 >= var5 && var3 <= var5 + var7) {
         for (int var10 = 0; var10 < 3; var10++) {
            if (var2 >= this.alf[var10] && var2 < this.alf[var10] + this.alg[var10]) {
               var9 = var10;
            }
         }
      }

      if (!this.a(var1, (float)var4, (float)var5, (float)var6, (float)var7, var8)) {
         this.cl(var1, var4, var5, var6, var7, var8);
         bu(var1, var4, var5, var6, var7, var8, zc);
         bu(var1, var4 + 1, var5 + 1, var6 - 2, var7 - 2, var8 - 1, cg(zh));
      }

      float var22 = this.aiw.getFloat(ald);
      if (var9 >= 0) {
         if (var22 < 0.05F || !this.aiw.containsKey(alb)) {
            this.aiw.put(alb, (float)this.alf[var9]);
            this.aiw.put(alc, (float)this.alg[var9]);
            this.ajc.put(alb, 0.0F);
            this.ajc.put(alc, 0.0F);
         }

         this.alj = var9;
      }

      float var11 = this.cv(this.aiw, ald, var9 >= 0 ? 1.0F : 0.0F, 21.0F);
      float var12;
      float var13;
      if (var9 >= 0) {
         var12 = this.db(this.aiw, alb, (float)this.alf[var9]);
         var13 = this.db(this.aiw, alc, (float)this.alg[var9]);
      } else {
         var12 = this.aiw.getFloat(alb);
         var13 = this.aiw.getFloat(alc);
         this.ajc.put(alb, 0.0F);
         this.ajc.put(alc, 0.0F);
      }

      if (var11 > 0.01F) {
         float var14 = (var12 - (float)this.alf[0]) / Math.max(1.0F, (float)(this.alf[1] - this.alf[0]));
         var14 = var14 < 0.0F ? 0.0F : (var14 > 1.0F ? 1.0F : var14);
         int var15 = var14 <= 0.0F ? 784997417 ^ 1646938691 : (var14 >= 1.0F ? o(zl, 56) : cq(-1673592861 ^ -790713975, o(zl, 56), var14));
         bt(var1, var12 + 1.0F, (float)var5 + 3.0F, var13 - 2.0F, (float)var7 - 6.0F, (float)(var7 - 6) / 2.0F, dk(var15, var11), true, true, true, true);
      }

      for (int var24 = 1; var24 < 3; var24++) {
         int var26 = this.alf[var24];
         boolean var16 = var11 > 0.01F && (this.alj == var24 || this.alj == var24 - 1);
         bv(var1, var26, var5 + 8, var26 + 1, var5 + var7 - 8, var16 ? dk(zc, 1.0F - var11) : zc);
      }

      String[] var25 = this.alk ? ale : abn;

      for (int var27 = 0; var27 < 3; var27++) {
         float var29 = this.cw(ala[var27], var27 == var9);
         boolean var17 = yv;
         int var18 = var27 == 0 ? (var17 ? 332490430 ^ -332523488 : (zk ? -1628921161 ^ 1628914015 : -1841278118 ^ 1839259586)) : (var17 ? yj : yj);
         int var19 = var27 == 0 ? (var17 ? 1924400283 ^ -1924421853 : (zk ? -1 : -1883844771 ^ 1883835799)) : (var17 ? -1 : yi);
         int var20 = var29 <= 0.0F ? var18 : (var29 >= 1.0F ? var19 : cq(var18, var19, var29));
         String var21 = var25[var27];
         this.ay(var1, var21, this.alf[var27] + (this.alg[var27] - this.bd(var21)) / 2, var5 + 9, var20, yv && !var17);
      }

      if (this.alk && var9 >= 0 && ale[var9] != abn[var9]) {
         String var28 = abn[var9];
         int var30 = this.bd(var28) + 12;
         int var31 = Math.min(this.alh + this.ali - var30, this.alf[var9] + this.alg[var9] / 2 - var30 / 2);
         ci(var1, (float)var31, (float)(var5 + var7 + 4), (float)var30, 15.0F, 7.5F, true, true, true, true, 1.0F);
         bu(var1, var31, var5 + var7 + 4, var30, 15, 7, zc);
         bu(var1, var31 + 1, var5 + var7 + 5, var30 - 2, 13, 6, cg(zj));
         this.ay(var1, var28, var31 + 6, var5 + var7 + 8, yj, false);
      }
   }

   private void eq(DrawContext var1, int var2, int var3, String var4, int var5, int var6) {

      byte var7 = 10;
      int var8 = this.bd(var4);
      int var9 = var8 + 28;
      boolean var10 = var5 >= var2 && var5 <= var2 + var9 && var6 >= var3 && var6 <= var3 + 21;
      float var11 = var10 ? 1.0F : 0.0F;
      float var12 = this.aiw.getFloat(var4);
      if (var12 != var11 || !this.aiw.containsKey(var4)) {
         var12 = this.cv(this.aiw, var4, var11, 21.0F);
      }

      this.cl(var1, var2, var3, var9, 21, var7);
      bu(var1, var2, var3, var9, 21, var7, var12 <= 0.0F ? zc : (var12 >= 1.0F ? zd : cq(zc, zd, var12)));
      bu(var1, var2 + 1, var3 + 1, var9 - 2, 19, var7 - 1, cg(var12 <= 0.0F ? zh : (var12 >= 1.0F ? zi : cq(zh, zi, var12))));
      this.ay(var1, var4, var2 + (var9 - var8) / 2, var3 + 7, var12 <= 0.0F ? yj : (var12 >= 1.0F ? zm : cq(yj, zm, var12)), yv);
      if (var12 > 0.01F) {
         float var13 = (float)(var9 - 14) * var12;
         if (var13 > 0.5F) {
            bt(
               var1,
               (float)var2 + ((float)var9 - var13) / 2.0F,
               (float)(var3 + 17),
               var13,
               2.0F,
               1.0F,
               var12 >= 1.0F ? zl : dk(zl, var12),
               true,
               true,
               true,
               true
            );
         }
      }
   }

   private void er(DrawContext var1, BuilderFactory var2, int var3, int var4) {

      char[] var5 = var2.d;
      int var6 = var2.dK;
      int var7 = this.bf(var5, var6);
      int var8 = var7 + 16;
      int var9 = (var3 - var8) / 2;
      int var10 = var4 - 30;
      this.cl(var1, var9, var10, var8, 15, 7);
      bu(var1, var9, var10, var8, 15, 7, zc);
      bu(var1, var9 + 1, var10 + 1, var8 - 2, 13, 6, cg(zj));
      this.be(var1, var5, var6, var9 + 8, var10 + 3, yj, false);
   }

   private void es(DrawContext var1, int var2, int var3) {

      if (this.adz == 0) {
         boolean var4 = this.ue(var1);

         try {
            bv(var1, 0, 0, var2, var3, aai);
            if (!yv) {
               return;
            }

            byte var5 = 8;

            for (int var6 = 0; var6 < var5; var6++) {
               int var7 = var3 * var6 / var5;
               int var8 = var3 * (var6 + 1) / var5;
               bv(var1, 0, var7, var2, var8, aka[var6]);
            }
         } finally {
            if (var4) {
               var1.getMatrices().popMatrix();
            }
         }
      }
   }

   private static void et(DrawContext var0, int var1, int var2, int var3, int var4, int var5) {

      if (yv && !aim) {
         cm(var0, (float)var1, (float)var2, (float)var3, (float)var4, (float)var5, -1110767057 ^ -305460689);
      } else {
         for (int var6 = 4; var6 >= 1; var6--) {
            bu(var0, var1 - var6 * 2, var2 - var6 * 2, var3 + var6 * 4, var4 + var6 * 4, var5 + var6 * 2, 12 + (4 - var6) * 6 << 24);
         }
      }
   }

   private static void eu(DrawContext var0, float var1, float var2, float var3, float var4, float var5, int var6) {

      if (!aim && var6 >>> 24 != 0 && var3 > 0.0F && var4 > 0.0F) {
         int var7 = agi >= 0.999F ? var6 : dk(var6, agi);
         float var8 = Math.max(0.0F, Math.min(var5, Math.min(var3, var4) * 0.5F));
         Matrix3x2fStack var9 = var0.getMatrices();
         float var10 = Math.abs(var9.m00 * var9.m11 - var9.m01 * var9.m10);
         float var11 = 1.5F * PaneGlassCache.PX / (var10 > 1.0E-8F ? (float)Math.sqrt((double)var10) : 1.0F);
         if (ahq) {
            if (!ahr && aht != null && !PaneGlassCache.fuseLast(var9, var1, var2, var3, var4, var8, var7)) {
               aht.stroke(var9, var1, var2, var3, var4, var8, var7);
            }
         } else {
            PaneGlassCache var12 = null;
            ScreenRect var13 = var0.scissorStack.peekLast();

            try {
               if (PaneGlassCache.fuseLast(var9, var1, var2, var3, var4, var8, var7)) {
                  return;
               }

               if (aiq != null) {
                  boolean var14 = var13 == null;
                  if (!var14) {
                     float var15 = var1 - var11;
                     float var16 = var2 - var11;
                     float var17 = var1 + var3 + var11;
                     float var18 = var2 + var4 + var11;
                     float var19 = var9.m00 * var15 + var9.m10 * var16 + var9.m20;
                     float var20 = var9.m01 * var15 + var9.m11 * var16 + var9.m21;
                     float var21 = var9.m00 * var17 + var9.m10 * var18 + var9.m20;
                     float var22 = var9.m01 * var17 + var9.m11 * var18 + var9.m21;
                     float var23 = var9.m00 * var17 + var9.m10 * var16 + var9.m20;
                     float var24 = var9.m01 * var17 + var9.m11 * var16 + var9.m21;
                     float var25 = var9.m00 * var15 + var9.m10 * var18 + var9.m20;
                     float var26 = var9.m01 * var15 + var9.m11 * var18 + var9.m21;
                     var14 = Math.min(Math.min(var19, var21), Math.min(var23, var25)) >= (float)var13.getLeft()
                        && Math.max(Math.max(var19, var21), Math.max(var23, var25)) <= (float)var13.getRight()
                        && Math.min(Math.min(var20, var22), Math.min(var24, var26)) >= (float)var13.getTop()
                        && Math.max(Math.max(var20, var22), Math.max(var24, var26)) <= (float)var13.getBottom();
                  }

                  if (var14) {
                     var12 = aiq;
                     var12.clip(null);
                     var12.stroke(var9, var1, var2, var3, var4, var8, var7);
                     return;
                  }
               }

               var12 = PaneGlassCache.take(var13, false);
               var12.stroke(var9, var1, var2, var3, var4, var8, var7);
               var12.addTo(var0.state);
            } catch (Throwable var27) {
               aim = true;
            }
         }
      }
   }

   private static void ev(DrawContext var0, float var1, float var2, float var3, float var4, int var5) {

      if (var5 >>> 24 != 0 && var3 > var1 && var4 > var2) {
         int var6 = agi >= 0.999F ? var5 : dk(var5, agi);
         if (ahq) {
            if (!ahr && aht != null) {
               aht.rect(var0.getMatrices(), var1, var2, var3, var4, var6, var6);
            }
         } else if (aiq != null) {
            ce(var0, var1, var2, var3, var4, var6, var6);
         } else {
            PaneGlassCache var7 = null;
            ScreenRect var8 = var0.scissorStack.peekLast();
            if (!aim) {
               try {
                  var7 = PaneGlassCache.take(var8, false);
                  var7.rect(var0.getMatrices(), var1, var2, var3, var4, var6, var6);
                  var7.addTo(var0.state);
                  return;
               } catch (Throwable var11) {
                  aim = true;
               }
            }

            int var9 = Math.round(var1);
            int var10 = Math.round(var2);
            var0.fill(var9, var10, Math.max(var9 + 1, Math.round(var3)), Math.max(var10 + 1, Math.round(var4)), var6);
         }
      }
   }

   private static void ew(DrawContext var0, float var1, float var2, float var3, float var4, int var5, int var6) {

      if (var3 > 0.0F && var4 > 0.0F) {
         if (aiq == null && !ahq) {
            ev(var0, var1, var2, var1 + var3, var2 + var4, cq(var5, var6, 0.5F));
         } else {
            int var7 = agi >= 0.999F ? var5 : dk(var5, agi);
            int var8 = agi >= 0.999F ? var6 : dk(var6, agi);
            Matrix3x2fStack var9 = var0.getMatrices();
            var9.pushMatrix();

            try {
               var9.translate(var1, var2 + var4);
               var9.rotate((float) (-Math.PI / 2));
               if (ahq) {
                  if (!ahr && aht != null) {
                     aht.rect(var9, 0.0F, 0.0F, var4, var3, var7, var8);
                  }
               } else {
                  ce(var0, 0.0F, 0.0F, var4, var3, var7, var8);
               }
            } finally {
               var9.popMatrix();
            }
         }
      }
   }

   private String ex(String var1, int var2) {

      if (this.textRenderer.getWidth(Text.literal(var1).setStyle(ahe)) <= var2) {
         return var1;
      } else {
         String var3 = abp[10];
         int var4 = var1.length();

         while (var4 > 0 && this.textRenderer.getWidth(Text.literal(var1.substring(0, var4) + var3).setStyle(ahe)) > var2) {
            var4--;
         }

         return var1.substring(0, var4).trim() + var3;
      }
   }

   private void ey(int var1) {

      switch (var1) {
         case 0:
            SyncController.t = !SyncController.t;
            applyTheme();
         case 1:
         case 2:
         case 4:
         case 6:
         case 7:
         case 9:
         case 14:
         case 20:
         case 22:
         case 23:
         case 24:
         default:
            break;
         case 3:
            SyncController.q = !SyncController.q;
            break;
         case 5:
            SyncController.k = !SyncController.k;
            break;
         case 8:
            SyncController.r = !SyncController.r;
            break;
         case 10:
            SyncController.z = !SyncController.z;
            break;
         case 11:
            SyncController.aa = !SyncController.aa;
            break;
         case 12:
            SyncController.ab = !SyncController.ab;
            break;
         case 13:
            SyncController.ac = !SyncController.ac;
            break;
         case 15:
            SyncController.x = !SyncController.x;
            break;
         case 16:
            SyncController.s = !SyncController.s;
            if (SyncController.s && this.adz != 0) {
               this.va();
            }
            break;
         case 17:
            SyncController.ae = !SyncController.ae;
            break;
         case 18:
            NoticeQueue.m = !NoticeQueue.m;
            if (NoticeQueue.m) {
               NoticeQueue.a(als[0], als[1]);
            }
            break;
         case 19:
            SyncController.w = !SyncController.w;
            break;
         case 21:
            SyncController.u = !SyncController.u;
            if (SyncController.u) {
               this.aed = false;
               this.ux();
            } else if (this.adz != 0) {
               this.va();
            }
            break;
         case 25:
            SyncController.y = !SyncController.y;
      }
   }

   private void ez(int var1, int var2) {

      int var3 = aqd[var1];
      var2 = var2 < 0 ? 0 : (var2 >= var3 ? var3 - 1 : var2);
      switch (var1) {
         case 1:
            SyncController.h = var2;
            break;
         case 6:
            SyncController.l = var2;
            break;
         case 14:
            SyncController.ad = var2;
            break;
         case 22:
            if (SyncController.ag != var2) {
               SyncController.ag = var2;
               if (this.adz != 0 && this.afj) {
                  this.xa();
               }
            }
            break;
         case 23:
            SyncController.ah = var2;
      }
   }

   private void fa(int var1, int var2) {

      int var3 = aqe[var1];
      int var4 = aqf[var1];
      int var5 = Math.max(1, aqg[var1]);
      var2 = var3 + Math.round((float)(var2 - var3) / (float)var5) * var5;
      var2 = var2 < var3 ? var3 : (var2 > var4 ? var4 : var2);
      if (var2 != ig(var1)) {
         switch (var1) {
            case 2:
               SyncController.i = var2;
               applyTheme();
               break;
            case 4:
               SyncController.j = var2;
               break;
            case 9:
               SyncController.p = var2;
               break;
            case 20:
               SyncController.af = var2;
               break;
            case 24:
               SyncController.ai = var2;
         }
      }
   }

   private void fb(int var1, float var2, int var3) {

      int var4 = aqh[var1];
      int var5 = hs(var3, var4);
      int var6 = ht(var3, var4);
      float var7 = (var2 - (float)var5) / (float)Math.max(1, var6 - var5);
      var7 = var7 < 0.0F ? 0.0F : (var7 > 1.0F ? 1.0F : var7);
      this.fa(var1, Math.round(var7 * (float)aqf[var1]));
   }

   private void fc() {

      int var1 = this.arx;
      this.arx = -1;
      if (var1 >= 0) {
         h();
         if (var1 == 20) {
            boolean var2 = SyncController.ae;
            SyncController.ae = true;
            p(1.7F);
            SyncController.ae = var2;
         }
      }
   }

   private boolean fd(int var1) {

      if (var1 == (-519491750 ^ -519492006)) {
         if (this.gz()) {
            this.arw = 0L;
            return true;
         } else if (this.art == 1) {
            this.hl(false);
            return true;
         } else {
            return false;
         }
      } else if ((var1 == (-1579469228 ^ -1579468973) || var1 == (1022322156 ^ 1022321898)) && this.ary >= 0 && this.arx < 0) {
         int var2 = this.ary;
         int var3 = (var1 == (1270405174 ^ 1270405424) ? 1 : -1) * (ak() ? 10 : 1);
         this.fa(var2, ig(var2) + var3 * Math.max(1, aqg[var2]));
         return true;
      } else {
         return false;
      }
   }

   private void fe() {

      SyncController.q = true;
      SyncController.r = true;
      SyncController.s = false;
      SyncController.t = true;
      SyncController.u = false;
      SyncController.w = true;
      SyncController.x = false;
      SyncController.y = true;
      NoticeQueue.m = true;
      SyncController.a = 2;
      SyncController.h = 1;
      SyncController.i = 62;
      SyncController.j = 70;
      SyncController.k = true;
      SyncController.l = 1;
      SyncController.p = 0;
      SyncController.z = true;
      SyncController.aa = true;
      SyncController.ab = false;
      SyncController.ac = false;
      SyncController.ad = 0;
      SyncController.ae = true;
      SyncController.af = 100;
      SyncController.ag = 1;
      SyncController.ah = 0;
      SyncController.ai = 78;
      dj();
      ThemeCache.o = 0;
      int[] var1 = ThemeCache.ALL[7].b;
      int[] var2 = ThemeCache.ALL[7].bg;

      for (int var3 = 0; var3 < 3; var3++) {
         ThemeCache.p[var3] = var1[var3];
         ThemeCache.q[var3] = var2[var3];
      }

      this.adk = 2.0;
      this.arv = 0;
      applyTheme();
      h();
      if (this.adz != 0) {
         this.va();
      }

      NoticeQueue.a(als[2], als[3]);
   }

   private String ff() {

      ItemDescriptor var1 = ta();
      int var2 = var1 != null ? var1.d : 150171271 ^ 150171615;
      if (var2 != this.alt) {
         this.alt = var2;
         this.alu = fh(var2);
      }

      return this.alu;
   }

   private boolean fg() {

      ItemDescriptor var1 = this.acr;
      return var1 != null && var1 == ta();
   }

   private static String fh(int var0) {

      if (var0 < 0) {
         return alv[36];
      } else if (var0 <= 7) {
         return var0 <= 2 ? alv[28 + var0] : alv[31] + (var0 + 1);
      } else if (var0 == 32) {
         return alv[0];
      } else if (var0 >= (1527848899 ^ 1527848642) && var0 <= (1875405584 ^ 1875405341)) {
         return alv[1 + (var0 - (-1364948918 ^ -1364948661))];
      } else if (var0 >= (1627486656 ^ 1627486424) && var0 <= (-1984648687 ^ -1984648435)) {
         return alv[14 + (var0 - (-113274393 ^ -113274625))];
      } else if (var0 >= (1953923922 ^ 1953923696) && var0 <= (1443848402 ^ 1443848680)) {
         return alv[32] + (var0 - (-840603487 ^ -840603261) + 1);
      } else if (var0 >= (-1522901026 ^ -1522901346) && var0 <= (425612983 ^ 425613310)) {
         return alv[33] + (var0 - (258920209 ^ 258920017));
      } else if (var0 >= (-922876057 ^ -922876371) && var0 <= (1019147443 ^ 1019147773)) {
         return alv[37 + (var0 - (-65640414 ^ -65640088))];
      } else if (var0 == (288729986 ^ 288729805)) {
         return alv[34];
      } else if (var0 == (-820537762 ^ -820537586)) {
         return alv[42];
      } else if (var0 >= (1797930320 ^ 1797929988) && var0 <= (1462659144 ^ 1462659348)) {
         return alv[19 + (var0 - (1750758692 ^ 1750758512))];
      } else {
         String var1 = null;

         try {
            var1 = GLFW.glfwGetKeyName(var0, 0);
         } catch (Throwable var3) {
         }

         return var1 != null ? var1.toUpperCase(Locale.ROOT) : alv[35] + var0;
      }
   }

   private static void fi(int[] var0, int[] var1) {

      int[] var2 = new int[]{255, 255, 255};
      int[] var3 = new int[]{0, 0, 0};
      amm = 179119966 ^ -178268245;
      amn = 14888007 ^ -1475361097;
      amo = 667944822 ^ -1573065338;
      amp = -91638260 ^ -1704633092;
      amq = ThemeCache.m(var0[0], var0[1], var0[2], 41);
      amz = ThemeCache.m(var0[0], var0[1], var0[2], 26);
      amr = ThemeCache.m(var0[0], var0[1], var0[2], 56);
      ams = ThemeCache.mix(var0, var2, 0.15, -1667688383 ^ -1667688243);
      amt = 1026749525 ^ 567085994;
      amu = ThemeCache.mix(var1, var3, 0.35, 422998082 ^ 422998205);
      amv = ThemeCache.mix(var2, var0, 0.04, 36);
      amw = ThemeCache.mix(var0, var2, 0.3, -1759584115 ^ -1759584142);
      asv = ThemeCache.mix(var0, var2, 0.55, 44);
      asw = ThemeCache.mix(var0, var2, 0.42, 92);
      asx = ThemeCache.mix(var0, var2, 0.65, 30);
      asy = ThemeCache.mix(var0, var2, 0.3, 40);
      asz = ThemeCache.mix(var0, var2, 0.45, 1866655845 ^ 1866655876);
      int[] var4 = ThemeCache.l(ThemeCache.l(var1, new int[]{24, 22, 28}, 0.4), var0, 0.1);
      int[] var5 = ThemeCache.l(var4, new int[]{24, 23, 27}, 0.3);
      amx = ThemeCache.m(var5[0], var5[1], var5[2], -679706293 ^ -679706188);
      amy = yv ? ThemeCache.m(var4[0], var4[1], var4[2], 1663721745 ^ 1663721949) : ThemeCache.mix(var5, var2, 0.025, 270114579 ^ 270114796);
   }

   private int fj() {

      return this.and;
   }

   private int fk() {

      return this.ane;
   }

   private int fl(int var1) {

      return Math.max(0, (var1 - this.and) / 2);
   }

   private int fm(int var1) {

      return Math.max(0, (var1 - this.ane) / 2);
   }

   private void fn(int var1, int var2) {

      if (this.adj) {
         this.and = Math.max(358004671 ^ 358004335, Math.min(42773347 ^ 42772963, var1 - 16));
         this.ane = Math.max(311242227 ^ 311241997, Math.min(-1719757818 ^ -1719757398, var2 - 16));
         this.jq();
      } else {
         this.and = -59508421 ^ -59508677;
         this.ane = Math.max(470430545 ^ 470430639, Math.min(-96445414 ^ -96445022, var2 - 16));
         this.ha();
      }
   }

   private void fo(DrawContext var1, int var2, int var3, int var4, int var5) {

      int var6 = this.fl(var2);
      int var7 = this.fm(var3);
      int var8 = this.and;
      int var9 = this.ane;
      boolean var10 = cc(var1, (float)var6 - 22.0F, (float)var7 - 14.0F, (float)(var6 + var8) + 22.0F, (float)(var7 + var9) + 22.0F);

      try {
         if (this.adj) {
            this.fr(var1, var6, var7, var8, var9);
            this.lu(var1, var6, var7, var8, var9, var4, var5);
         } else {
            this.ij(var1, var6, var7, var8, var9, var4, var5);
         }
      } finally {
         if (var10) {
            cd();
         }
      }
   }

   private void fp(DrawContext var1, int var2, int var3) {

      if (this.adz == 0) {
         boolean var4 = this.ue(var1);

         try {
            bv(var1, 0, 0, var2, var3, -1420036753 ^ -564136343);
         } finally {
            if (var4) {
               var1.getMatrices().popMatrix();
            }
         }
      }
   }

   private static void fq(DrawContext var0, int var1, int var2, int var3, int var4, int var5) {

      if (yv && !aim) {
         cn(var0, (float)var1, (float)var2, (float)var3, (float)var4, (float)var5, 16.0F, 6.0F, -1056206232 ^ -1492413848);
      } else {
         for (int var6 = 4; var6 >= 1; var6--) {
            bu(var0, var1 - var6 * 2, var2 - var6 * 2, var3 + var6 * 4, var4 + var6 * 4, var5 + var6 * 2, 12 + (4 - var6) * 6 << 24);
         }
      }
   }

   private void fr(DrawContext var1, int var2, int var3, int var4, int var5) {

      fq(var1, var2, var3, var4, var5, 16);
      ci(var1, (float)var2, (float)var3, (float)var4, (float)var5, 16.0F, true, true, true, true, this.ck());
      bt(var1, (float)var2, (float)var3, (float)var4, (float)var5, 16.0F, cg(amy), true, true, true, true);
      eu(var1, (float)var2, (float)var3, (float)var4, (float)var5, 16.0F, amt);
      ev(var1, (float)(var2 + 16), (float)var3, (float)(var2 + var4 - 16), (float)var3 + fs(), 68439950 ^ 518762609);
   }

   private static float fs() {

      return 1.0F / (float)Math.max(1, ahd);
   }

   private static int ft(float var0, float var1) {

      return Math.round(var0 + var1 * 0.5F - 3.9F);
   }

   private static float fu(float var0, float var1) {

      return var0 + var1 * 0.5F - 2.93F;
   }

   private int fv(int var1) {

      return this.adj ? var1 + this.and - 26 - 9 : var1 + this.and - 6 - 18;
   }

   private int fw(int var1) {

      return this.adj ? var1 + this.bdd / 2 + 1 - 9 : var1 + 6;
   }

   private boolean fx(int var1, int var2, int var3, int var4) {

      int var5 = this.fv(var1);
      int var6 = this.fw(var2);
      return var3 >= var5 && var3 < var5 + 18 && var4 >= var6 && var4 < var6 + 18;
   }

   private void fy(DrawContext var1, int var2, int var3, int var4, int var5) {

      int var6 = this.fv(var2);
      int var7 = this.fw(var3);
      float var8 = this.cw(anb, this.fx(var2, var3, var4, var5));
      bs(var1, (float)var6, (float)var7, 18.0F, var8 <= 0.0F ? 2114437506 ^ 1912094333 : cq(-1380471804 ^ -1572318213, 1026389676 ^ 668109139, var8));
      int var9 = var8 <= 0.0F ? amn : cq(amn, amm, var8);
      Matrix3x2fStack var10 = var1.getMatrices();
      var10.pushMatrix();

      try {
         var10.translate((float)var6 + 9.0F, (float)var7 + 9.0F);
         var10.rotate((float) (Math.PI / 4));
         bt(var1, -4.1F, -0.5F, 8.2F, 1.0F, 0.5F, var9, true, true, true, true);
         var10.rotate((float) (Math.PI / 2));
         bt(var1, -4.1F, -0.5F, 8.2F, 1.0F, 0.5F, var9, true, true, true, true);
      } finally {
         var10.popMatrix();
      }
   }

   private void fz(DrawContext var1, float var2, float var3, float var4, float var5, String var6, int var7, Object var8, boolean var9, boolean var10) {

      float var11 = var7 == 6 ? 0.0F : this.cw(var8, var9);
      float var12 = var5 * 0.5F;

      this.ay(
         var1,
         var6,
         Math.round(var2 + (var4 - (float)this.bd(var6)) * 0.5F),
         ft(var3, var5),
         switch (var7) {
            case 0 -> {
               bt(var1, var2, var3, var4, var5, var12, var11 <= 0.0F ? yd : cq(yd, -1, 0.1F * var11), true, true, true, true);
               ev(var1, var2 + var12, var3, var2 + var4 - var12, var3 + fs(), -1923123734 ^ -895448555);
               yield amu;
            }
            case 1, 5 -> {
               if (var10) {
                  bt(var1, var2, var3, var4, var5, var12, -1286642865 ^ -1531929424, true, true, true, true);
                  eu(var1, var2, var3, var4, var5, var12, -1761662229 ^ -1224682220);
                  yield amm;
               } else {
                  bt(
                     var1,
                     var2,
                     var3,
                     var4,
                     var5,
                     var12,
                     var11 <= 0.0F ? 1044365711 ^ 750796400 : cq(1039388401 ^ 789328142, -702058600 ^ -891776921, var11),
                     true,
                     true,
                     true,
                     true
                  );
                  eu(var1, var2, var3, var4, var5, var12, 354249118 ^ 31626849);
                  yield amm;
               }
            }
            case 2 -> {
               if (var11 > 0.01F) {
                  bt(var1, var2, var3, var4, var5, var12, dk(967000617 ^ 912047574, var11), true, true, true, true);
               }

               yield var11 <= 0.0F ? amn : cq(amn, amm, var11);
            }
            case 3 -> {
               bt(
                  var1,
                  var2,
                  var3,
                  var4,
                  var5,
                  var12,
                  var11 <= 0.0F ? 2145908676 ^ -2144225910 : cq(908145227 ^ -906530811, -1, 0.08F * var11),
                  true,
                  true,
                  true,
                  true
               );
               yield -1;
            }
            case 4 -> {
               if (var11 > 0.01F) {
                  bt(var1, var2, var3, var4, var5, var12, dk(542697654 ^ 78940382, var11), true, true, true, true);
               }

               eu(var1, var2, var3, var4, var5, var12, 1284210792 ^ 23584768);
               yield -1399634586 ^ 1399013350;
            }
            default -> {
               bt(var1, var2, var3, var4, var5, var12, -2114670990 ^ -1962192499, true, true, true, true);
               yield amp;
            }
         },
         false
      );
   }

   private void ga(DrawContext var1, float var2, float var3, float var4, float var5, String[] var6, int var7, int var8, int var9, int var10, Object var11) {

      bt(var1, var2, var3, var4, var5, var5 * 0.5F, -1084726936 ^ -1940364952, true, true, true, true);
      eu(var1, var2, var3, var4, var5, var5 * 0.5F, 1775615022 ^ 2049590225);
      float var12 = (var4 - 4.0F) / (float)var8;
      float var13 = this.db(this.aiw, var11, var2 + 2.0F + (float)var9 * var12);
      bt(var1, var13, var3 + 2.0F, var12, var5 - 4.0F, (var5 - 4.0F) * 0.5F, amv, true, true, true, true);
      eu(var1, var13, var3 + 2.0F, var12, var5 - 4.0F, (var5 - 4.0F) * 0.5F, -135011429 ^ -317973404);
      int var14 = ft(var3, var5);

      for (int var15 = 0; var15 < var8; var15++) {
         String var16 = var6[var7 + var15];
         int var17 = var15 == var9 ? amm : (var15 == var10 ? amn : amo);
         this.ay(var1, var16, Math.round(var2 + 2.0F + (float)var15 * var12 + (var12 - (float)this.bd(var16)) * 0.5F), var14, var17, false);
      }
   }

   private static int gb(float var0, float var1, float var2, float var3, int var4, int var5, int var6) {

      if (!((float)var6 < var1) && !((float)var6 >= var1 + var3) && !((float)var5 < var0) && !((float)var5 >= var0 + var2)) {
         int var7 = (int)Math.floor((double)(((float)var5 - var0 - 2.0F) / ((var2 - 4.0F) / (float)var4)));
         return var7 < 0 ? 0 : (var7 >= var4 ? var4 - 1 : var7);
      } else {
         return -1;
      }
   }

   private static void gc(DrawContext var0, float var1, float var2, float var3) {

      gd(var0, var1 + 1.0F, var2 + 1.0F, 22.0F, 12.0F, var3, true);
   }

   private static void gd(DrawContext var0, float var1, float var2, float var3, float var4, float var5, boolean var6) {

      int var7 = var6 ? -1493417540 ^ -2113683901 : 1650561646 ^ 1889430929;
      int var8 = var6 ? yd : o(yd, 89);
      br(var0, var1, var2, var3, var4, var5 <= 0.0F ? var7 : (var5 >= 1.0F ? var8 : cq(var7, var8, var5)));
      float var9 = var4 - 3.0F;
      float var10 = var1 + 1.5F + (var3 - 3.0F - var9) * var5;
      if (var6) {
         bs(var0, var10 - 0.4F, var2 + 1.9F, var9 + 0.8F, -397581096 ^ -968006440);
      }

      bs(var0, var10, var2 + 1.5F, var9, var6 ? -342247449 ^ 342052379 : -583301778 ^ 1371634834);
   }

   private static void ge(DrawContext var0, float var1, float var2, float var3, float var4) {

      bt(var0, var1, var2, var3, var4, 10.0F, 121544268 ^ 230777267, true, true, true, true);
      eu(var0, var1, var2, var3, var4, 10.0F, -1646809558 ^ -1943514667);
   }

   private static void gf(DrawContext var0, float var1, float var2, float var3, float var4, float var5) {

      float var6 = Math.max(18.0F, var3 * Math.min(1.0F, var4));
      bt(var0, var1, var2 + (var3 - var6) * Math.max(0.0F, Math.min(1.0F, var5)), 2.5F, var6, 1.25F, 742400721 ^ 348118318, true, true, true, true);
   }

   private void gg(DrawContext var1, String var2, float var3, float var4, int var5) {

      this.ay(var1, gi(var2), Math.round(var3), Math.round(var4 - 1.0F), var5, false);
   }

   private int gh(String var1) {

      return this.bd(gi(var1));
   }

   private static String gi(String var0) {

      String var1 = anm.get(var0);
      if (var1 == null) {
         boolean var2 = false;
         boolean var3 = false;

         for (int var4 = 0; var4 < var0.length(); var4++) {
            char var5 = var0.charAt(var4);
            var2 |= Character.isLowerCase(var5);
            var3 |= Character.isLetter(var5);
         }

         var1 = !var2 && var3 && var0.length() >= 2 ? var0.charAt(0) + var0.substring(1).toLowerCase(Locale.ROOT) : var0;
         if (anm.size() > (1261344304 ^ 1261343792)) {
            anm.clear();
         }

         anm.put(var0, var1);
      }

      return var1;
   }

   private int gj(String var1) {

      return Math.max(14, this.gh(var1) + 8);
   }

   private int gk(DrawContext var1, float var2, float var3, String var4, int var5) {

      int var6 = this.gj(var4);
      bt(var1, var2, var3, (float)var6, 12.0F, 4.0F, -210269256 ^ -24611769, true, true, true, true);
      eu(var1, var2, var3, (float)var6, 12.0F, 4.0F, -977454973 ^ -515717252);
      this.gg(var1, var4, var2 + (float)(var6 - this.gh(var4)) * 0.5F, fu(var3, 12.0F), var5);
      return var6;
   }

   private int gl(String var1, String var2) {

      return this.gj(var1) + 4 + this.bd(var2);
   }

   private void gm(DrawContext var1, int var2, int var3, int var4, String var5, String var6, String var7, String var8, String var9, String var10) {

      int var11 = 0;
      if (var5 != null) {
         var11 += this.gl(var5, var6);
      }

      if (var7 != null) {
         var11 += (var11 > 0 ? 12 : 0) + this.gl(var7, var8);
      }

      if (var9 != null) {
         var11 += (var11 > 0 ? 12 : 0) + this.gl(var9, var10);
      }

      int var12 = var2 - var11;
      if (var5 != null) {
         var12 = this.gn(var1, var12, var3, var4, var5, var6) + 12;
      }

      if (var7 != null) {
         var12 = this.gn(var1, var12, var3, var4, var7, var8) + 12;
      }

      if (var9 != null) {
         this.gn(var1, var12, var3, var4, var9, var10);
      }
   }

   private int gn(DrawContext var1, int var2, int var3, int var4, String var5, String var6) {

      int var7 = this.gk(var1, (float)var2, (float)(var3 + (var4 - 12) / 2), var5, amn);
      this.ay(var1, var6, var2 + var7 + 4, ft((float)var3, (float)var4), amo, false);
      return var2 + var7 + 4 + this.bd(var6);
   }

   private void go(DrawContext var1, float var2, float var3, float var4, float var5, String var6, String var7, boolean var8, Object var9, boolean var10) {

      float var11 = this.cw(var9, var10 && !var8);
      float var12 = Math.min(8.0F, var5 * 0.5F);
      float var13 = fs();
      bt(var1, var2, var3, var4, var5, var12, -2111351744 ^ -1171827648, true, true, true, true);
      eu(
         var1,
         var2,
         var3,
         var4,
         var5,
         var12,
         var8 ? ams : (var11 <= 0.0F ? 594546560 ^ 965734527 : cq(-975133304 ^ -551593353, 1415007367 ^ 2108207992, var11))
      );
      if (var8) {
         int var14 = o(yd, 77);
         eu(var1, var2 - var13, var3 - var13, var4 + 2.0F * var13, var5 + 2.0F * var13, var12 + var13, var14);
         eu(var1, var2 - 2.0F * var13, var3 - 2.0F * var13, var4 + 4.0F * var13, var5 + 4.0F * var13, var12 + 2.0F * var13, var14);
      }

      int var20 = Math.round(var2) + 8;
      int var15 = Math.round(var4) - 16;
      int var16 = ft(var3, var5);
      boolean var17 = var8 && System.currentTimeMillis() % 1000L < 500L;
      if (var6.isEmpty()) {
         if (!var7.isEmpty()) {
            this.ay(var1, var7, var20, var16, amo, false);
         }

         if (var17) {
            ev(var1, (float)var20 - 0.5F, var3 + 4.5F, (float)var20 + 0.5F, var3 + var5 - 4.5F, amw);
         }
      } else {
         int var18 = this.bd(var6);
         int var19 = Math.max(0, var18 + 3 - var15);
         if (var19 > 0) {
            nr(var1, var20, Math.round(var3) + 2, var20 + var15, Math.round(var3 + var5) - 2);
         }

         this.ay(var1, var6, var20 - var19, var16, amm, false);
         if (var17) {
            ev(var1, (float)(var20 - var19 + var18) + 1.0F, var3 + 4.5F, (float)(var20 - var19 + var18) + 2.0F, var3 + var5 - 4.5F, amw);
         }

         if (var19 > 0) {
            var1.disableScissor();
         }
      }
   }

   private int gp(DrawContext var1, int var2, int var3, String var4, int var5, int var6, int var7) {

      int var8 = this.gh(var4) + 10;
      if (var6 >>> 24 != 0) {
         bt(var1, (float)var2, (float)var3, (float)var8, 11.0F, 5.5F, var6, true, true, true, true);
      }

      if (var7 >>> 24 != 0) {
         eu(var1, (float)var2, (float)var3, (float)var8, 11.0F, 5.5F, var7);
      }

      this.gg(var1, var4, (float)(var2 + 5), fu((float)var3, 11.0F), var5);
      return var8;
   }

   private void gq(DrawContext var1, String var2, float var3, float var4, float var5, int var6, boolean var7) {

      int var8 = ahh;
      float var9 = (var8 >= 5 && var8 <= 45 ? (float)var8 / 10.0F : (float)ahd) * var5;
      int var10 = Math.round(var9 * 100.0F);
      int var11;
      if (var10 == 125 || var10 == (1933713862 ^ 1933713703) || var10 == (-1536932799 ^ -1536932554)) {
         var11 = var10;
      } else if (var10 == 75) {
         var11 = 7;
      } else if (var10 == 50) {
         var11 = 5;
      } else {
         var11 = Math.max(10, Math.min(45, Math.round(var9 * 10.0F)));
      }

      if (var8 < 5 || var8 > 45) {
         var3 = (float)Math.round(var3 * (float)ahd) / (float)ahd;
         var4 = (float)Math.round(var4 * (float)ahd) / (float)ahd;
      }

      Matrix3x2fStack var12 = var1.getMatrices();
      var12.pushMatrix();
      ahh = var11;

      try {
         var12.translate(var3, var4);
         var12.scale(var5, var5);
         this.ay(var1, var2, 0, 0, var6, var7);
      } finally {
         ahh = var8;
         var12.popMatrix();
      }
   }

   private void gr() {

      if (this.anq != ahd) {
         this.anq = ahd;
         float var1 = 0.0F;

         for (int var2 = 0; var2 < 10; var2++) {
            float var3 = this.textRenderer.getTextHandler().getWidth(at(ann[var2]));
            this.ano[var2] = var3;
            var1 = Math.max(var1, var3);
         }

         this.anp = var1;
         boolean var4 = true;

         for (int var5 = 0; var5 < 10 && var4; var5++) {
            var4 = Math.abs(this.textRenderer.getTextHandler().getWidth(at(gt(ann[var5]))) - var1) < 0.05F;
         }

         this.anr = var4;
      }
   }

   private float gs(String var1) {

      return (float)HudFont.m(var1, this.bc()) / (float)this.bb();
   }

   private static String gt(String var0) {

      String var1 = ant.get(var0);
      if (var1 != null) {
         return var1;
      } else {
         StringBuilder var2 = new StringBuilder(var0.length() * 3);
         int var3 = 0;

         for (int var4 = var0.length(); var3 < var4; var3++) {
            char var5 = var0.charAt(var3);
            if (var5 >= '0' && var5 <= '9') {
               var2.append((char)((-1718083855 ^ -1718027791) + (var5 - '0'))).append(var5).append((char)((-2101050206 ^ -2101058638) + (var5 - '0')));
            } else {
               var2.append(var5);
            }
         }

         var1 = var2.toString();
         if (ant.size() < (-1922513697 ^ -1922511649)) {
            ant.put(var0, var1);
         }

         return var1;
      }
   }

   private float gu(String var1) {

      if (ba() && var1.indexOf(1849301479 ^ 1849301312) < 0) {
         return this.gs(var1);
      } else {
         if (this.anq != ahd) {
            this.gr();
         }

         if (!this.anr || ahl || ahh >= 5 && ahh <= 45) {
            float var7 = 0.0F;
            int var3 = -1;
            int var4 = var1.length();

            for (int var5 = 0; var5 < var4; var5++) {
               char var6 = var1.charAt(var5);
               if (var6 >= '0' && var6 <= '9') {
                  if (var3 >= 0) {
                     var7 += this.textRenderer.getTextHandler().getWidth(at(var1.substring(var3, var5)));
                     var3 = -1;
                  }

                  var7 += this.anp;
               } else if (var3 < 0) {
                  var3 = var5;
               }
            }

            if (var3 >= 0) {
               var7 += this.textRenderer.getTextHandler().getWidth(at(var3 == 0 ? var1 : var1.substring(var3)));
            }

            return var7;
         } else {
            String var2 = ant.get(var1);
            return this.textRenderer.getTextHandler().getWidth(at(var2 != null ? var2 : gt(var1)));
         }
      }
   }

   private void gv(DrawContext var1, String var2, float var3, int var4, int var5) {

      if (ba() && var2.indexOf(386589530 ^ 386589693) < 0) {
         this.gx(var1, var2, var3, var4, var5);
      } else {
         if (this.anq != ahd) {
            this.gr();
         }

         if (!this.anr || ahl || ahh >= 5 && ahh <= 45) {
            float var12 = var3;
            int var7 = -1;
            int var8 = var2.length();

            for (int var9 = 0; var9 <= var8; var9++) {
               boolean var10 = var9 < var8 && var2.charAt(var9) >= '0' && var2.charAt(var9) <= '9';
               if ((var10 || var9 == var8) && var7 >= 0) {
                  String var11 = var7 == 0 && var9 == var8 ? var2 : var2.substring(var7, var9);
                  this.gx(var1, var11, var12, var4, var5);
                  var12 += this.textRenderer.getTextHandler().getWidth(at(var11));
                  var7 = -1;
               }

               if (var10) {
                  int var13 = var2.charAt(var9) - '0';
                  this.gx(var1, ann[var13], var12 + (this.anp - this.ano[var13]) * 0.5F, var4, var5);
                  var12 += this.anp;
               } else if (var9 < var8 && var7 < 0) {
                  var7 = var9;
               }
            }
         } else {
            String var6 = ant.get(var2);
            this.gx(var1, var6 != null ? var6 : gt(var2), var3, var4, var5);
         }
      }
   }

   private void gw(DrawContext var1, String var2, float var3, int var4, int var5) {

      if (ba() && var2.indexOf(1662379381 ^ 1662379474) < 0) {
         this.gx(var1, var2, var3 - this.gs(var2), var4, var5);
      } else {
         if (this.anq != ahd) {
            this.gr();
         }

         if (this.anr && !ahl && (ahh < 5 || ahh > 45)) {
            String var6 = ant.get(var2);
            if (var6 == null) {
               var6 = gt(var2);
            }

            this.gx(var1, var6, var3 - this.textRenderer.getTextHandler().getWidth(at(var6)), var4, var5);
         } else {
            this.gv(var1, var2, var3 - this.gu(var2), var4, var5);
         }
      }
   }

   private void gx(DrawContext var1, String var2, float var3, int var4, int var5) {

      float var6 = ahh >= 5 && ahh <= 45 ? 1.0F : (float)Math.max(1, ahd);
      float var7 = (float)Math.round(var3 * var6) / var6;
      int var8 = (int)Math.floor((double)var7);
      float var9 = var7 - (float)var8;
      if (var9 <= 1.0E-4F) {
         this.ay(var1, var2, var8, var4, var5, false);
      } else {
         Matrix3x2fStack var10 = var1.getMatrices();
         var10.pushMatrix();

         try {
            var10.translate(var9, 0.0F);
            this.ay(var1, var2, var8, var4, var5, false);
         } finally {
            var10.popMatrix();
         }
      }
   }

   private static String gy(int var0) {

      if (var0 >= 0 && var0 < anu.length) {
         String var1 = anu[var0];
         if (var1 == null) {
            var1 = Integer.toString(var0);
            anu[var0] = var1;
         }

         return var1;
      } else {
         return Integer.toString(var0);
      }
   }

   private boolean gz() {

      return this.arw != 0L && System.nanoTime() / 1000000L - this.arw < 3000L;
   }

   private void ha() {

      this.ars = Math.max(20, this.ane - 30 - 28 - 12);
      int var1 = this.hb();
      this.arj = Math.max(0, Math.min(var1, this.arj));
      if (this.ark > var1) {
         this.ark = var1;
      }

      if (this.arl > (float)var1) {
         this.arl = (float)var1;
         this.arm = this.de((float)var1);
         this.arn = this.df((float)var1);
      }

      int var2 = this.hd();
      this.aro = Math.max(0, Math.min(var2, this.aro));
      if (this.arp > (float)var2) {
         this.arp = (float)var2;
         this.arq = this.de((float)var2);
         this.arr = this.df((float)var2);
      }
   }

   private int hb() {

      return Math.max(0, aqn - this.ars);
   }

   private static int hc() {

      return ThemeCache.o == 7 ? 590888509 ^ 590888640 : -1440670867 ^ -1440670748;
   }

   private int hd() {

      return Math.max(0, hc() + 2 - this.ars);
   }

   private static int he(int var0) {

      return var0 + 30 + 6;
   }

   private int hf(int var1, int var2) {

      return he(var1) - this.arm + aqj[var2];
   }

   private int hg(int var1) {

      return this.dg(var1, this.arn);
   }

   private int hh(int var1, int var2) {

      int var3 = he(var1);
      if (var2 >= var1 + 30 && var2 < var1 + this.ane - 28) {
         int var4 = var3 - this.arm;

         try {
            for (int var5 = 0; var5 < apu; var5++) {
               int var6 = var4 + aqj[var5];
               if (var2 >= var6 && var2 < var6 + aqk[var5]) {
                  return var5;
               }
            }

            return -1;
         } catch (RuntimeException var7) {
            throw var7;
         }
      } else {
         return -1;
      }
   }

   private void hi() {

      int var1 = this.hb();
      boolean var2 = this.ark >= 0;
      this.arl = this.dc(this.arl, this.arj, var1, var2 ? 16.0F : 25.0F);
      if (var2 && this.arl == (float)Math.max(0, Math.min(var1, this.arj))) {
         this.ark = -1;
      }

      this.arm = this.de(this.arl);
      this.arn = this.df(this.arl);
      this.arp = this.dc(this.arp, this.aro, this.hd(), 16.0F);
      this.arq = this.de(this.arp);
      this.arr = this.df(this.arp);
   }

   private void hj() {

      float var1 = (float)this.art;
      float var2 = this.aru;
      if (var2 != var1) {
         var2 = SyncController.x ? var1 : var2 + (var1 - var2) * (1.0F - (float)Math.exp((double)(-15.0F * this.ajg)));
         this.aru = Math.abs(var1 - var2) < 0.002F ? var1 : var2;
      }
   }

   private boolean hk() {

      return this.aru == (float)this.art;
   }

   private void hl(boolean var1) {

      int var2 = var1 ? 1 : 0;
      if (var2 != this.art) {
         this.art = var2;
         if (this.adm >= 0) {
            h();
         }

         this.fc();
         this.adm = -1;
         this.asb = -1;
      }
   }

   private int hm(int var1) {

      if (this.ase != ahd) {
         this.ase = ahd;
         Arrays.fill(this.asd, 0);
      }

      int var2 = this.asd[var1];
      if (var2 == 0) {
         int var3 = 0;

         for (int var4 = 0; var4 < aqd[var1]; var4++) {
            var3 = Math.max(var3, this.bd(aqa[aqc[var1] + var4]));
         }

         var2 = 3 + aqd[var1] * Math.max(24, var3 + 12);
         this.asd[var1] = var2;
      }

      return var2;
   }

   private static int hn(int var0) {

      return var0 + (-1468207919 ^ -1468207663) - 12;
   }

   private float ho(int var1, int var2) {

      return (float)(hn(var1) - this.hm(var2));
   }

   private static int hp(int var0) {

      return 3;
   }

   private static int hq(int var0) {

      return 15;
   }

   private int hr(int var1, int var2, int var3, int var4, int var5, int var6) {

      return gb(this.ho(var1, var3), (float)(var2 + hp(var4)), (float)this.hm(var3), (float)hq(var4), aqd[var3], var5, var6);
   }

   private static int hs(int var0, int var1) {

      return hn(var0) - 40 - 60;
   }

   private static int ht(int var0, int var1) {

      return hn(var0) - 40;
   }

   private static int hu(int var0, int var1, int var2, int var3) {

      float var4 = (float)(var2 - (var0 + 12));
      float var5 = 60.0F;
      int var6 = var3 - var1;
      if (!(var4 < 0.0F) && var6 >= 0) {
         int var7 = (int)(var4 / var5);
         int var8 = var6 / 50;
         int var9 = var8 * 4 + var7;
         return var7 <= 3 && !(var4 - (float)var7 * var5 >= 52.0F) && var6 - var8 * 50 < 44 && var9 < Math.min(8, ThemeCache.ALL.length) ? var9 : -1;
      } else {
         return -1;
      }
   }

   private static int hv(int var0) {

      return var0 + 12;
   }

   private static int hw(int var0, int var1, int var2, int var3) {

      return gb((float)(hv(var0) + 10), (float)(var1 + 10 + 10), 104.0F, 18.0F, 2, var2, var3);
   }

   private static float hx(int var0) {

      return (float)hv(var0) + 10.0F;
   }

   private static float hy(int var0) {

      return (float)var0 + 36.0F;
   }

   private static float hz(int var0) {

      return (float)(hv(var0) + (411196397 ^ 411196165)) - 10.0F - 12.0F;
   }

   private static int ia(int var0, int var1, int var2, int var3) {

      float var4 = hx(var0);
      float var5 = hy(var1);
      float var6 = hz(var0);
      if ((float)var3 < var5 - 4.0F || (float)var3 > var5 + 72.0F + 4.0F) {
         return -1;
      } else if ((float)var2 >= var4 - 4.0F && (float)var2 <= var4 + 192.0F + 3.0F) {
         return 1;
      } else {
         return (float)var2 >= var6 - 3.0F && (float)var2 <= var6 + 12.0F + 5.0F ? 0 : -1;
      }
   }

   private int ib(String var1) {

      return Math.max(24, this.bd(var1) + 12);
   }

   private int ic() {

      return this.bd(ana[this.gz() ? 21 : 0]) + 18;
   }

   private int id() {

      return 21 + Math.round((float)this.bd(apw[5]) * 1.25F) + 6;
   }

   private static boolean ie(int var0) {

      switch (var0) {
         case 0:
            return SyncController.t;
         case 1:
         case 2:
         case 4:
         case 6:
         case 7:
         case 9:
         case 14:
         case 20:
         case 22:
         case 23:
         case 24:
         default:
            return false;
         case 3:
            return SyncController.q;
         case 5:
            return SyncController.k;
         case 8:
            return SyncController.r;
         case 10:
            return SyncController.z;
         case 11:
            return SyncController.aa;
         case 12:
            return SyncController.ab;
         case 13:
            return SyncController.ac;
         case 15:
            return SyncController.x;
         case 16:
            return SyncController.s;
         case 17:
            return SyncController.ae;
         case 18:
            return NoticeQueue.m;
         case 19:
            return SyncController.w;
         case 21:
            return SyncController.u;
         case 25:
            return SyncController.y;
      }
   }

   private int _kwren_if(int var1) {

      switch (var1) {
         case 1:
            return SyncController.h;
         case 6:
            return SyncController.l;
         case 14:
            return SyncController.ad;
         case 22:
            return SyncController.ag;
         case 23:
            return SyncController.ah;
         case 27:
            return (int)Math.max(1L, Math.min(3L, Math.round(this.adk))) - 1;
         default:
            return 0;
      }
   }

   private static int ig(int var0) {

      switch (var0) {
         case 2:
            return SyncController.i;
         case 4:
            return SyncController.j;
         case 9:
            return SyncController.p;
         case 20:
            return SyncController.af;
         case 24:
            return SyncController.ai;
         default:
            return 0;
      }
   }

   private String ih(int var1) {

      int var2 = ig(var1);
      String var3 = this.asf[var1];
      if (var3 == null || this.asg[var1] != var2) {
         var3 = gy(var2) + (var1 == 9 ? ana[9] : ana[8]);
         this.asf[var1] = var3;
         this.asg[var1] = var2;
      }

      return var3;
   }

   private String ii(int var1, int var2) {

      if (this.asj != ahd) {
         Arrays.fill(this.ash, null);
         this.asj = ahd;
      }

      String var3 = this.ash[var1];
      if (var3 == null || this.asi[var1] != var2) {
         var3 = this.ex(var1 < 28 ? apz[var1] : ana[13], var2);
         this.ash[var1] = var3;
         this.asi[var1] = var2;
      }

      return var3;
   }

   private void ij(DrawContext var1, int var2, int var3, int var4, int var5, int var6, int var7) {

      this.hi();
      this.hj();
      this.ary = -1;
      this.asb = this.art == 1 ? -3 : -1;
      int var8 = he(var3);
      int var9 = this.ars;
      int var10 = var3 + var5 - 28;
      boolean var11 = var6 >= var2 && var6 < var2 + var4 && var7 >= var3 + 30 && var7 < var10 && this.hk();
      float var12 = this.aru;
      boolean var13 = this.hk();
      int var14 = var13 ? var2 - 20 : var2;
      int var15 = var13 ? var2 + var4 + 20 : var2 + var4;
      int var16 = var3 + 15;
      int var17 = var10 + 14;
      int var18 = var3 + 30;
      int var19 = var10;
      float var20 = agi;
      Matrix3x2fStack var21 = var1.getMatrices();

      try {
         float var22 = (float)var4 + 24.0F;
         if (var12 < 0.999F) {
            float var23 = (float)Math.round(-var12 * var22 * (float)ahd) / (float)ahd;
            int var24 = var11 && this.art == 0 ? this.hg(var7) : 1917484787 ^ -1303740685;
            boolean var25 = dh(var1, this.arn);
            var21.pushMatrix();

            try {
               var21.translate(var23, 0.0F);
               this.im(
                  var1,
                  var2,
                  var3,
                  var8,
                  var9,
                  var24 == (-184997851 ^ 888743973) ? -490112477 ^ 583629347 : var6,
                  var24,
                  var14,
                  var15,
                  var16,
                  var17,
                  var18,
                  var19
               );
            } finally {
               var21.popMatrix();
               di(var1, var25);
            }
         }

         if (var12 > 0.001F) {
            float var42 = (float)Math.round((1.0F - var12) * var22 * (float)ahd) / (float)ahd;
            int var44 = var11 && this.art == 1 ? this.dg(var7, this.arr) : 1902003201 ^ -1319222271;
            boolean var46 = dh(var1, this.arr);
            var21.pushMatrix();

            try {
               var21.translate(var42, 0.0F);
               this.iu(
                  var1,
                  var2,
                  var8 - this.arq,
                  var44 == (882158626 ^ -191583198) ? -2027709846 ^ 1193515626 : var6,
                  var44,
                  var14,
                  var15,
                  var16,
                  var17,
                  var18,
                  var19
               );
            } finally {
               var21.popMatrix();
               di(var1, var46);
            }
         }
      } finally {
         agi = var20;
      }

      if (this.fg()) {
         this.asb = 28;
      }

      int var41 = this.art == 0 ? aqn : hc() + 2;
      int var43 = this.art == 0 ? Math.round(this.arl) : Math.round(this.arp);
      if (var41 > var9 && var13) {
         gf(var1, (float)(var2 + var4 + 4), (float)(var8 + 6), (float)(var9 - 12), (float)var9 / (float)var41, (float)var43 / (float)(var41 - var9));
      }

      float var45 = this.cw(are[6], var6 >= var2 && var6 < var2 + var4 && var7 >= var3 && var7 < var3 + 30);
      this.jk(var1, (float)var2, (float)var3, (float)var4, 30.0F, 12.0F, var45, 10.0F, 1.2F);
      this.ik(var1, var2, var3, var6, var7);
      this.fy(var1, var2, var3, var6, var7);
      float var47 = this.cw(are[7], var6 >= var2 && var6 < var2 + var4 && var7 >= var10 && var7 < var10 + 28);
      this.jk(var1, (float)var2, (float)var10, (float)var4, 28.0F, 12.0F, var47, 10.0F, 1.2F);
      this.il(var1, var2, var10, var4, var6, var7);
   }

   private void ik(DrawContext var1, int var2, int var3, int var4, int var5) {

      float var6 = this.aru;
      float var7 = (float)var3 + 10.6F;
      if (var6 < 0.9F) {
         float var8 = 1.0F - var6 / 0.9F;
         this.gq(var1, abn[1], (float)(var2 + 12) - 8.0F * var6, var7, 1.25F, dk(amm, var8), false);
      }

      if (var6 > 0.1F) {
         float var15 = (var6 - 0.1F) / 0.9F;
         float var9 = 8.0F * (1.0F - var6);
         boolean var10 = this.art == 1 && var4 >= var2 && var4 < var2 + this.id() && var5 >= var3 && var5 < var3 + 30;
         float var11 = this.cw(arb[29], var10);
         int var12 = dk(var11 <= 0.0F ? amn : cq(amn, amm, var11), var15);
         float var13 = (float)(var2 + 12) + 2.0F + var9;
         float var14 = (float)var3 + 15.0F;
         pb(var1, var13, var14 - 1.45F, (float) (-Math.PI / 4), var12);
         pb(var1, var13, var14 + 1.45F, (float) (Math.PI / 4), var12);
         this.gq(var1, apw[5], (float)(var2 + 12) + 9.0F + var9, var7, 1.25F, var12, false);
      }
   }

   private void il(DrawContext var1, int var2, int var3, int var4, int var5, int var6) {

      boolean var7 = this.gz();
      if (!var7) {
         this.arw = 0L;
      }

      int var8 = this.ic();
      boolean var9 = var5 >= var2 + 5 && var5 < var2 + 5 + var8 && var6 >= var3 + 5 && var6 < var3 + 23;
      this.fz(var1, (float)(var2 + 5), (float)(var3 + 5), (float)var8, 18.0F, ana[var7 ? 21 : 0], var7 ? 3 : 2, arb[28], var9, false);
      int var10 = this.asb;
      if (var10 != this.arz) {
         this.asa = SyncController.x ? 0.0F : this.asa - this.ajg * 14.0F;
         if (this.asa <= 0.0F) {
            this.asa = 0.0F;
            this.arz = var10;
         }
      } else if (this.asa < 1.0F) {
         this.asa = SyncController.x ? 1.0F : Math.min(1.0F, this.asa + this.ajg * 9.0F);
      }

      float var11 = this.asa;
      if (!(var11 < 0.1F) && this.arz != -2) {
         int var12 = var2 + var4 - 10;
         int var13 = var12 - (var2 + 5 + var8 + 10);
         if (this.arz >= 0) {
            String var14 = this.ii(this.arz, var13);
            this.ay(var1, var14, var12 - this.bd(var14), ft((float)var3, 28.0F), dk(amo, var11), false);
         } else {
            float var22 = agi;
            agi = var22 * var11;

            try {
               String var15 = ana[this.arz == -3 ? 23 : 2];
               int var16 = this.gj(ana[1]);
               int var17 = this.bd(var15);
               int var18 = var12 - var17 - 4 - var16;
               this.gk(var1, (float)var18, (float)var3 + 8.0F, ana[1], dk(amn, var11));
               this.ay(var1, var15, var18 + var16 + 4, ft((float)var3, 28.0F), dk(amo, var11), false);
            } finally {
               agi = var22;
            }
         }
      }
   }

   private void im(DrawContext var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13) {

      assert var1 != null
         && apt != null
         && apt.length == apu * 3
         && aqj != null
         && aqk != null
         && aql != null
         && aqm != null
         && arf != null
         && arg != null
         && are != null
         && arb != null
         && apx != null
         && this.asc != null
         && this.asc.length == 10 : "gsPageMain: bad state";

      int var14 = var4 - this.arm;
      int var15 = var6 == (-1522513920 ^ 1698711552) ? -1 : this.hh(var3, var7);
      if (var15 >= 0 && apt[var15 * 3] == 1) {
         var15 = -1;
      }

      int var16 = var15 >= 0 ? aqi[var15] : -1;
      if (var15 >= 0) {
         this.asb = apt[var15 * 3 + 1];
      }

      float var17 = agi;
      nr(var1, var8, var10, var9, var11);

      try {
         for (int var18 = 0; var18 < 5; var18++) {
            int var19 = var14 + aql[var18];
            int var20 = aqm[var18];
            boolean var21 = var19 + var20 > var10 - 4 && var19 < var11 + 4;
            boolean var22 = var6 != (-1392375483 ^ 1828849989)
               && var6 >= var2
               && var6 < var2 + (348264814 ^ 348264558)
               && var7 >= var19
               && var7 < var19 + var20;
            float var23 = this.cw(are[var18], var22);
            boolean var24 = var16 == var18;
            int var25 = var24 ? apt[var15 * 3 + 2] : -1;
            var24 = var24 && (var25 < 0 || ie(var25));
            float var26 = this.jm(arf[var18], null, arg[var18], var24 ? (float)aqj[var15] : 0.0F, 0.0F, var24, this.asc, var18);
            if (var21) {
               this.jk(var1, (float)var2, (float)var19, 256.0F, (float)var20, 12.0F, var23, -1.0F, 1.0F);
               if (var26 > 0.01F) {
                  bt(var1, (float)var2 + 4.0F, (float)var14 + this.ata, 248.0F, 21.0F, 7.0F, dk(asy, var26), true, true, true, true);
               }
            }
         }
      } catch (RuntimeException var39) {
         throw var39;
      } finally {
         var1.disableScissor();
      }

      nr(var1, var8, var12, var9, var13);

      try {
         if (yv && !aim) {
            for (int var41 = 0; var41 < 5; var41++) {
               int var43 = var14 + aql[var41];
               int var45 = aqm[var41];
               if (var43 + var45 > var12 - 8 && var43 < var13 + 8) {
                  cn(var1, (float)var2, (float)var43, 256.0F, (float)var45, 12.0F, 6.0F, 2.4F, -1203643294 ^ -465445790);
               }
            }
         }

         for (int var42 = 0; var42 < apu; var42++) {
            int var44 = aqk[var42];
            int var46 = var14 + aqj[var42];
            if (var46 + var44 > var12 && var46 < var13) {
               float var47 = in((float)var46 + (float)var44 * 0.5F, var12, var13);
               if (!(var47 < 0.05F)) {
                  agi = var17 * var47;
                  int var48 = apt[var42 * 3];
                  int var49 = apt[var42 * 3 + 1];
                  if (var48 == 1) {
                     this.ay(var1, apw[var49], var2 + 12, var46 + 7, asz, false);
                  } else {
                     this.io(var1, var2, var42, var48, var49, var46, var15 == var42, var6, var7);
                  }
               }
            }
         }
      } catch (RuntimeException var37) {
         throw var37;
      } finally {
         agi = var17;
         var1.disableScissor();
      }
   }

   private static float in(float var0, int var1, int var2) {

      float var3 = Math.min(var0 - (float)var1, (float)var2 - var0) / 12.0F;
      if (var3 >= 1.0F) {
         return 1.0F;
      } else {
         return var3 <= 0.0F ? 0.0F : var3 * var3 * (3.0F - 2.0F * var3);
      }
   }

   private void io(DrawContext var1, int var2, int var3, int var4, int var5, int var6, boolean var7, int var8, int var9) {

      int var10 = hn(var2);
      boolean var11 = var4 == 9 || var4 == 10;
      int var12 = apt[var3 * 3 + 2];
      boolean var13 = var12 < 0 || ie(var12);
      float var14 = this.cw(arb[var5], var7 && var13);
      if (var7 && var13 && (var4 == 7 || var4 == 10)) {
         this.ary = var5;
      }

      int var15 = ft((float)var6, 21.0F);
      if (var11) {
         ev(var1, (float)(var2 + 12) + 2.0F, (float)var6 + 4.0F, (float)(var2 + 12) + 2.0F + fs(), (float)(var6 + 21) - 4.0F, -329702109 ^ -844703012);
         int var19 = !var13 ? amp : (var14 <= 0.0F ? amo : cq(amo, amn, var14));
         this.ay(var1, apy[var5], var2 + 12 + 10, var15, var19, false);
         if (var4 == 10) {
            this.iq(var1, var2, var4, var5, var6, var13);
         } else {
            int var21 = var13 ? this.hr(var2, var6, var5, var4, var8, var9) : -1;
            this.is(
               var1, this.ho(var2, var5), (float)(var6 + hp(var4)), (float)this.hm(var5), 15.0F, aqc[var5], aqd[var5], this._kwren_if(var5), var21, arc[var5], var13
            );
         }
      } else {
         int var16 = var4 == 5 && !ie(var5) ? amn : amm;
         this.ay(var1, apy[var5], var2 + 12, var15, var14 <= 0.0F ? var16 : cq(var16, amm, var14), false);
         switch (var4) {
            case 2:
               this.ip(var1, var10, var6, var14);
               break;
            case 3:
            case 4:
            case 7:
            default:
               this.iq(var1, var2, var4, var5, var6, true);
               break;
            case 5:
               float var20 = this.da(arc[var5], ie(var5) ? 1.0F : 0.0F);
               gd(var1, (float)(var10 - 20), (float)var6 + 5.0F, 20.0F, 11.0F, var20, true);
               break;
            case 6:
               this.is(
                  var1,
                  this.ho(var2, var5),
                  (float)(var6 + hp(var4)),
                  (float)this.hm(var5),
                  15.0F,
                  aqc[var5],
                  aqd[var5],
                  this._kwren_if(var5),
                  this.hr(var2, var6, var5, var4, var8, var9),
                  var5 == 27 ? arh : arc[var5],
                  true
               );
               break;
            case 8:
               boolean var17 = this.fg();
               String var18 = var17 ? ana[6] : this.ff();
               this.it(var1, var10, var6 + hp(var4), var18, var17, var14);
         }
      }
   }

   private void ip(DrawContext var1, int var2, int var3, float var4) {

      float var5 = (float)var3 + 10.5F;
      int var6 = var4 <= 0.0F ? amo : cq(amo, amn, var4);
      pb(var1, (float)var2 - 2.0F, var5 - 1.45F, (float) (Math.PI / 4), var6);
      pb(var1, (float)var2 - 2.0F, var5 + 1.45F, (float) (-Math.PI / 4), var6);
      int var7 = ThemeCache.o >= 0 && ThemeCache.o < ThemeCache.ALL.length ? ThemeCache.o : 0;
      int var8 = var2 - 9 - this.bf(ThemeCache.ALL[var7].nmE, ThemeCache.ALL[var7].nmK);
      this.be(var1, ThemeCache.ALL[var7].nmE, ThemeCache.ALL[var7].nmK, var8, ft((float)var3, 21.0F), var4 <= 0.0F ? amn : cq(amn, amm, var4), false);
      float var9 = (float)var8 - 6.0F - 6.0F;

      try {
         for (int var10 = 0; var10 < 3; var10++) {
            int var11 = var10 == 0 ? var7 : (var7 + var10) % 7;
            int[] var12 = var11 == 7 ? ThemeCache.p : ThemeCache.h(var11);
            int var13 = ThemeCache.m(var12[0], var12[1], var12[2], -941079718 ^ -941079643);
            float var14 = var9 - (float)(2 - var10) * 9.0F;
            bs(var1, var14, var5 - 3.0F, 6.0F, var13);
            eu(var1, var14, var5 - 3.0F, 6.0F, 6.0F, 3.0F, 1695563353 ^ 1575993766);
         }
      } catch (RuntimeException var15) {
         throw var15;
      }
   }

   private void iq(DrawContext var1, int var2, int var3, int var4, int var5, boolean var6) {

      int var7 = hs(var2, var3);
      int var8 = ht(var2, var3);
      int var9 = aqf[var4];
      float var10 = var9 > 0 ? (float)ig(var4) / (float)var9 : 0.0F;
      boolean var11 = this.arx == var4;
      ir(var1, (float)var7, (float)var5 + 10.5F, (float)(var8 - var7), var10, var11, var6);
      this.gw(var1, this.ih(var4), (float)hn(var2), ft((float)var5, 21.0F), !var6 ? amp : amn);
   }

   private static void ir(DrawContext var0, float var1, float var2, float var3, float var4, boolean var5, boolean var6) {

      var4 = var4 < 0.0F ? 0.0F : (var4 > 1.0F ? 1.0F : var4);
      bt(var0, var1, var2 - 1.5F, var3, 3.0F, 1.5F, var6 ? 571061470 ^ 66472737 : 1353789462 ^ 1112461289, true, true, true, true);
      float var7 = var3 * var4;
      if (var7 > 0.5F) {
         bt(var0, var1, var2 - 1.5F, var7, 3.0F, 1.5F, var6 ? yd : 2008446714 ^ 1497991429, true, true, true, true);
      }

      float var8 = 4.5F;
      float var9 = var1 + Math.max(var8 - 1.0F, Math.min(var3 - var8 + 1.0F, var7));
      if (var5) {
         float var10 = var8 + 2.5F;
         eu(var0, var9 - var10, var2 - var10, 2.0F * var10, 2.0F * var10, var10, -1045784395 ^ 1303025845 | yd & (649405553 ^ 642440078));
      }

      if (var6) {
         bs(var0, var9 - var8 - 0.5F, var2 - var8 + 0.2F, 2.0F * var8 + 1.0F, -1649691477 ^ -575949653);
      }

      bs(var0, var9 - var8, var2 - var8, 2.0F * var8, var6 ? 1457207448 ^ -1457405596 : -1445930810 ^ 1447447642);
   }

   private void is(DrawContext var1, float var2, float var3, float var4, float var5, int var6, int var7, int var8, int var9, Object var10, boolean var11) {

      bt(var1, var2, var3, var4, var5, var5 * 0.5F, 833822977 ^ 45293825, true, true, true, true);
      eu(var1, var2, var3, var4, var5, var5 * 0.5F, -2002203341 ^ -1688784180);
      float var12 = (var4 - 3.0F) / (float)var7;
      float var13 = this.db(this.aix, var10, (float)var8 * var12);
      bt(var1, var2 + 1.5F + var13, var3 + 1.5F, var12, var5 - 3.0F, (var5 - 3.0F) * 0.5F, var11 ? amv : dk(amv, 0.5F), true, true, true, true);
      eu(var1, var2 + 1.5F + var13, var3 + 1.5F, var12, var5 - 3.0F, (var5 - 3.0F) * 0.5F, var11 ? -1019693085 ^ -641251300 : 1932948704 ^ 2127137567);
      int var14 = ft(var3, var5);

      try {
         for (int var15 = 0; var15 < var7; var15++) {
            String var16 = aqa[var6 + var15];
            int var17 = !var11 ? amp : (var15 == var8 ? amm : (var15 == var9 ? amn : amo));
            this.ay(var1, var16, Math.round(var2 + 1.5F + (float)var15 * var12 + (var12 - (float)this.bd(var16)) * 0.5F), var14, var17, false);
         }
      } catch (RuntimeException var18) {
         throw var18;
      }
   }

   private void it(DrawContext var1, int var2, int var3, String var4, boolean var5, float var6) {

      int var7 = this.ib(var4);
      int var8 = var2 - var7;
      if (var5) {
         bt(var1, (float)var8, (float)var3, (float)var7, 15.0F, 6.0F, 2144705064 ^ 1205180968, true, true, true, true);
         eu(var1, (float)var8, (float)var3, (float)var7, 15.0F, 6.0F, ams);
         this.ay(var1, var4, var8 + 6, ft((float)var3, 15.0F), amw, false);
         if (System.currentTimeMillis() % 1000L < 500L) {
            float var9 = (float)(var8 + 6 + this.bd(var4)) + 1.5F;
            ev(var1, var9, (float)var3 + 3.5F, var9 + 1.0F, (float)(var3 + 15) - 3.5F, amw);
         }
      } else {
         bt(var1, (float)var8, (float)var3, (float)var7, 15.0F, 6.0F, 1309386028 ^ 1980474668, true, true, true, true);
         eu(
            var1,
            (float)var8,
            (float)var3,
            (float)var7,
            15.0F,
            6.0F,
            var6 <= 0.0F ? 1224975000 ^ 1409047911 : cq(1794641788 ^ 1879568515, 224237525 ^ 1050830890, var6)
         );
         this.ay(var1, var4, var8 + (var7 - this.bd(var4)) / 2, ft((float)var3, 15.0F), amm, false);
      }
   }

   private void iu(DrawContext var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {

      int var12 = hc();
      boolean var13 = var4 != (-1911920068 ^ 1309305404) && var4 >= var2 && var4 < var2 + (-1947751131 ^ -1947751387) && var5 >= var3 && var5 < var3 + var12;
      float var14 = this.cw(are[5], var13);
      nr(var1, var6, var8, var7, var9);

      try {
         this.jk(var1, (float)var2, (float)var3, 256.0F, (float)var12, 12.0F, var14, -1.0F, 1.0F);
      } finally {
         var1.disableScissor();
      }

      nr(var1, var6, var10, var7, var11);
      float var15 = agi;

      try {
         if (yv && !aim) {
            cn(var1, (float)var2, (float)var3, 256.0F, (float)var12, 12.0F, 6.0F, 2.4F, -1085206151 ^ -481226375);
         }

         agi = var15 * in((float)var3 + 11.0F, var10, var11);
         this.ay(var1, apw[5], var2 + 12, var3 + 7, asz, false);
         agi = var15;
         this.ix(var1, var2, var3 + 21, var4, var5);
         if (ThemeCache.o == 7) {
            this.jc(var1, var2, var3 + 123, var4, var5);
         } else {
            this.ay(var1, ana[22], var2 + 12, var3 + 21 + 50 + 30 + 14 + 4, amp, false);
         }
      } finally {
         agi = var15;
         var1.disableScissor();
      }
   }

   private void iv(int var1, int var2) {

      this.asn = var1;
      this.aso = var2;
      int var3 = 0;

      for (int var4 = Math.min(8, ThemeCache.ALL.length); var3 < var4; var3++) {
         int var5 = iw(var3);
         int[] var6 = ThemeCache.h(var3);
         int var7 = ThemeCache.m(var6[0], var6[1], var6[2], 1123800306 ^ 1123800077);
         this.ask[var3] = var5;
         this.asl[var3] = var7;
         this.asm[var3] = o(cq(var5, var7, 0.45F), 1625589572 ^ 1625589644);
      }
   }

   private static int iw(int var0) {

      int[] var1 = ThemeCache.h(var0);
      int[] var2 = ThemeCache.i(var0);
      float var3 = (float)var2[0] + (float)(22 - var2[0]) * 0.55F;
      float var4 = (float)var2[1] + (float)(21 - var2[1]) * 0.55F;
      float var5 = (float)var2[2] + (float)(25 - var2[2]) * 0.55F;
      var3 += ((float)var1[0] - var3) * 0.04F;
      var4 += ((float)var1[1] - var4) * 0.04F;
      var5 += ((float)var1[2] - var5) * 0.04F;
      return ThemeCache.m(Math.round(var3), Math.round(var4), Math.round(var5), 1760093988 ^ 1760094171);
   }

   private void ix(DrawContext var1, int var2, int var3, int var4, int var5) {

      assert var1 != null && ard != null && ard.length == 8 && this.ask != null && this.asl != null && this.asm != null && ThemeCache.ALL != null : "gsChips: "
         + "bad"
         + " "
         + "state";

      int var6 = var4 == (1542550177 ^ -1678675295) ? -1 : hu(var2, var3, var4, var5);
      int var7 = Math.min(8, ThemeCache.ALL.length);
      float var8 = 52.0F;
      float var9 = 30.0F;
      float var10 = fs();
      float var11 = (float)(var2 + 12);
      float var12 = 60.0F;
      int[] var13 = ThemeCache.p;
      int[] var14 = ThemeCache.q;
      int var15 = var13[0] << 16 | var13[1] << 8 | var13[2];
      int var16 = var14[0] << 16 | var14[1] << 8 | var14[2];
      if (var15 != this.asn || var16 != this.aso) {
         this.iv(var15, var16);
      }

      try {
         for (int var17 = 0; var17 < var7; var17++) {
            float var18 = var11 + (float)(var17 & 3) * var12;
            int var19 = var3 + (var17 >> 2) * 50;
            boolean var20 = ThemeCache.o == var17;
            float var21 = this.cw(ard[var17], var6 == var17 && !var20);
            int var22 = this.ask[var17];
            int var23 = this.asl[var17];
            bt(var1, var18, (float)var19, var8, var9, 6.0F, var22, true, true, true, true);
            bt(var1, var18, (float)var19, var8, 7.0F, 6.0F, 469055745 ^ 369805054, true, true, false, false);
            bt(var1, var18 + 7.0F, (float)var19 + 11.0F, var8 - 14.0F, 3.0F, 1.5F, this.asm[var17], true, true, true, true);
            bt(var1, var18 + 3.5F, (float)var19 + 10.0F, 1.5F, 5.0F, 0.75F, var23, true, true, true, true);
            bt(var1, var18 + 7.0F, (float)var19 + 17.0F, var8 - 20.0F, 3.0F, 1.5F, 274153851 ^ 967360132, true, true, true, true);
            bt(var1, var18 + 7.0F, (float)var19 + 23.0F, var8 - 27.0F, 3.0F, 1.5F, -1325634820 ^ -1409051389, true, true, true, true);
            eu(
               var1,
               var18,
               (float)var19,
               var8,
               var9,
               6.0F,
               var21 <= 0.0F ? 752282867 ^ 992547596 : cq(-757325171 ^ -987505294, -2145274174 ^ -1025619651, var21)
            );
            if (var20) {
               for (float var24 = 1.5F; var24 < 2.99F; var24 += var10) {
                  eu(var1, var18 - var24, (float)var19 - var24, var8 + 2.0F * var24, var9 + 2.0F * var24, 6.0F + var24, yd);
               }
            }

            this.be(
               var1,
               ThemeCache.ALL[var17].nmE,
               ThemeCache.ALL[var17].nmK,
               Math.round(var18 + (var8 - (float)this.bf(ThemeCache.ALL[var17].nmE, ThemeCache.ALL[var17].nmK)) * 0.5F),
               var19 + 30 + 5,
               var20 ? amm : (var21 <= 0.0F ? amo : cq(amo, amn, var21)),
               false
            );
         }
      } catch (RuntimeException var25) {
         throw var25;
      }
   }

   private String iy(int[] var1) {

      int var2 = var1[0] << 16 | var1[1] << 8 | var1[2];
      if (var2 != this.asp) {
         char[] var3 = new char[6];

         for (int var4 = 0; var4 < 6; var4++) {
            var3[var4] = Character.toUpperCase(Character.forDigit(var2 >> 20 - 4 * var4 & 15, 16));
         }

         this.asp = var2;
         this.asq = ana[7] + new String(var3);
      }

      return this.asq;
   }

   private float[] iz(int var1) {

      int[] var2 = var1 == 0 ? ThemeCache.p : ThemeCache.q;
      int var3 = var2[0] << 16 | var2[1] << 8 | var2[2];
      float[] var4 = this.asr[var1];
      if (var3 != this.ass[var1]) {
         this.ass[var1] = var3;
         int var5 = var2[0];
         int var6 = var2[1];
         int var7 = var2[2];
         int var8 = Math.max(var5, Math.max(var6, var7));
         int var9 = Math.min(var5, Math.min(var6, var7));
         if (var8 > var9) {
            float var10 = (float)(var8 - var9);
            float var11;
            if (var8 == var5) {
               var11 = (float)(var6 - var7) / var10;
            } else if (var8 == var6) {
               var11 = 2.0F + (float)(var7 - var5) / var10;
            } else {
               var11 = 4.0F + (float)(var5 - var6) / var10;
            }

            var11 /= 6.0F;
            var4[0] = var11 < 0.0F ? var11 + 1.0F : var11;
         }

         if (var8 > 0) {
            var4[1] = (float)(var8 - var9) / (float)var8;
         }

         var4[2] = (float)var8 / 255.0F;
      }

      return var4;
   }

   private void ja(int var1, int var2, float var3) {

      float[] var4 = this.iz(var1);
      var4[var2] = var3 < 0.0F ? 0.0F : (var3 > 1.0F ? 1.0F : var3);
      int[] var5 = var1 == 0 ? ThemeCache.p : ThemeCache.q;
      int var6 = jb(var4[0], var4[1], var4[2]);
      var5[0] = var6 >> 16 & (-617886847 ^ -617886850);
      var5[1] = var6 >> 8 & (-472690360 ^ -472690249);
      var5[2] = var6 & (-1077142606 ^ -1077142707);
      this.ass[var1] = var5[0] << 16 | var5[1] << 8 | var5[2];
      applyTheme();
   }

   private static int jb(float var0, float var1, float var2) {

      float var3 = (var0 >= 1.0F ? 0.0F : var0) * 6.0F;
      int var4 = (int)Math.floor((double)var3);
      float var5 = var3 - (float)var4;
      float var6 = var2 * (1.0F - var1);
      float var7 = var2 * (1.0F - var1 * var5);
      float var8 = var2 * (1.0F - var1 * (1.0F - var5));
      float var9;
      float var10;
      float var11;
      switch (var4) {
         case 0:
            var9 = var2;
            var10 = var8;
            var11 = var6;
            break;
         case 1:
            var9 = var7;
            var10 = var2;
            var11 = var6;
            break;
         case 2:
            var9 = var6;
            var10 = var2;
            var11 = var8;
            break;
         case 3:
            var9 = var6;
            var10 = var7;
            var11 = var2;
            break;
         case 4:
            var9 = var8;
            var10 = var6;
            var11 = var2;
            break;
         default:
            var9 = var2;
            var10 = var6;
            var11 = var7;
      }

      return -980991882 ^ 981942390 | Math.round(var9 * 255.0F) << 16 | Math.round(var10 * 255.0F) << 8 | Math.round(var11 * 255.0F);
   }

   private void jc(DrawContext var1, int var2, int var3, int var4, int var5) {

      int var6 = hv(var2);
      int var7 = -1535389222 ^ -1535389390;
      bt(var1, (float)var6, (float)var3, (float)var7, 118.0F, 9.0F, 231786881 ^ 1053870465, true, true, true, true);
      eu(var1, (float)var6, (float)var3, (float)var7, 118.0F, 9.0F, -1801778144 ^ -2023427105);
      int[] var8 = this.arv == 0 ? ThemeCache.p : ThemeCache.q;
      int var9 = ThemeCache.m(var8[0], var8[1], var8[2], 167202855 ^ 167203032);
      float[] var10 = this.iz(this.arv);
      this.is(
         var1,
         (float)(var6 + 10),
         (float)(var3 + 10),
         104.0F,
         18.0F,
         16,
         2,
         this.arv,
         var4 == (675189274 ^ -398552550) ? -1 : hw(var2, var3 - 10, var4, var5),
         ari,
         true
      );
      float var11 = (float)(var6 + var7 - 10 - 84);
      bt(var1, var11, (float)var3 + 10.0F, 84.0F, 18.0F, 9.0F, 1852140813 ^ 1449487629, true, true, true, true);
      eu(var1, var11, (float)var3 + 10.0F, 84.0F, 18.0F, 9.0F, -1775137015 ^ -1932627722);
      bs(var1, var11 + 5.0F, (float)var3 + 14.0F, 10.0F, var9);
      eu(var1, var11 + 5.0F, (float)var3 + 14.0F, 10.0F, 10.0F, 5.0F, 1213801610 ^ 145152885);
      this.ay(var1, this.iy(var8), Math.round(var11 + 20.0F), ft((float)(var3 + 10), 18.0F), amm, false);
      float var12 = hx(var2);
      float var13 = hy(var3);
      float var14 = 192.0F;
      float var15 = 72.0F;
      int var16 = jb(var10[0], 1.0F, 1.0F);
      jd(var1, var12, var13, var14, var15, 6.0F, -1, var16, true, true, true, true, true);
      jd(var1, var12, var13, var14, var15, 6.0F, 0, -2145153626 ^ 2133036454, false, true, true, true, true);
      eu(var1, var12, var13, var14, var15, 6.0F, 878234152 ^ 279393751);
      float var17 = var12 + var14 * var10[1];
      float var18 = var13 + var15 * (1.0F - var10[2]);
      bs(var1, var17 - 6.5F, var18 - 6.0F, 13.0F, -784091555 ^ -2126268835);
      bs(var1, var17 - 6.0F, var18 - 6.0F, 12.0F, -1);
      bs(var1, var17 - 4.2F, var18 - 4.2F, 8.4F, var9);
      float var19 = hz(var2);

      try {
         for (int var20 = 0; var20 < 6; var20++) {
            float var21 = var13 + var15 * (float)var20 / 6.0F;
            float var22 = var13 + var15 * (float)(var20 + 1) / 6.0F;
            jd(
               var1,
               var19,
               var21,
               12.0F,
               var22 - var21 + (var20 < 5 ? fs() : 0.0F),
               6.0F,
               jb((float)var20 / 6.0F, 1.0F, 1.0F),
               jb((float)(var20 + 1) / 6.0F, 1.0F, 1.0F),
               false,
               var20 == 0,
               var20 == 0,
               var20 == 5,
               var20 == 5
            );
         }
      } catch (RuntimeException var23) {
         throw var23;
      }

      eu(var1, var19, var13, 12.0F, var15, 6.0F, -1726975226 ^ -1108374279);
      float var24 = var13 + var15 * var10[0];
      bt(var1, var19 - 2.5F, var24 - 3.0F, 17.0F, 6.0F, 3.0F, 1934880735 ^ 592703455, true, true, true, true);
      bt(var1, var19 - 2.0F, var24 - 2.5F, 16.0F, 5.0F, 2.5F, -1, true, true, true, true);
      bt(var1, var19, var24 - 1.0F, 12.0F, 2.0F, 1.0F, 943730823 ^ -952094585 | var16, true, true, true, true);
   }

   private static void jd(
      DrawContext var0,
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      int var6,
      int var7,
      boolean var8,
      boolean var9,
      boolean var10,
      boolean var11,
      boolean var12
   ) {

      if (var3 > 0.0F && var4 > 0.0F) {
         int var13 = agi >= 0.999F ? var6 : dk(var6, agi);
         int var14 = agi >= 0.999F ? var7 : dk(var7, agi);
         PaneGlassCache var15 = ahq ? (ahr ? null : aht) : aiq;
         boolean var16 = false;
         Matrix3x2fStack var17 = var0.getMatrices();
         var17.pushMatrix();

         try {
            if (var15 != null && !aim) {
               if (!ahq) {
                  var15.clip(var0.scissorStack.peekLast());
               }

               if (var8) {
                  var17.translate(var1, var2 + var4);
                  var17.rotate((float) (-Math.PI / 2));
                  var16 = var15.roundV(var17, 0.0F, 0.0F, var4, var3, var5, var13, var14, true, true, true, true);
               } else {
                  var16 = var15.roundV(var17, var1, var2, var3, var4, var5, var13, var14, var9, var10, var11, var12);
               }
            }
         } catch (Throwable var22) {
            aim = true;
         } finally {
            var17.popMatrix();
         }

         if (!var16 && (!ahq || !ahr)) {
            if (var8) {
               ew(var0, var1, var2, var3, var4, var6, var7);
            } else if (aiq != null && !ahq) {
               ce(var0, var1, var2, var1 + var3, var2 + var4, var13, var14);
            } else {
               var0.fillGradient(Math.round(var1), Math.round(var2), Math.round(var1 + var3), Math.round(var2 + var4), var13, var14);
            }
         }
      }
   }

   private void je(int var1, int var2) {

      float var3 = this.ho(var2, 27) + 1.5F;
      float var4 = ((float)this.hm(27) - 3.0F) / 3.0F;
      int var5 = (int)Math.floor((double)(((float)var1 - var3) / var4));
      var5 = var5 < 0 ? 0 : (var5 > 2 ? 2 : var5);
      this.adk = Math.max(1.0, Math.min(3.0, (double)Math.round(1.0 + (double)var5)));
      if (SyncController.a != var5 + 1) {
         SyncController.a = var5 + 1;
         h();
      }
   }

   private void jf(int var1, int var2, int var3, int var4, int var5) {

      if (this.adm >= 0) {
         int var6 = he(var2) - this.arq + 123;
         this.jg(var1, var6, (float)var4, (float)this.dg(var5, this.arr));
      }
   }

   private void jg(int var1, int var2, float var3, float var4) {

      int var5 = this.adm / 3;
      float var6 = hy(var2);
      if (this.adm % 3 == 1) {
         this.jh(var5, (var3 - hx(var1)) / 192.0F, 1.0F - (var4 - var6) / 72.0F);
      } else {
         this.ja(var5, 0, (var4 - var6) / 72.0F);
      }
   }

   private void jh(int var1, float var2, float var3) {

      float[] var4 = this.iz(var1);
      var4[1] = var2 < 0.0F ? 0.0F : (var2 > 1.0F ? 1.0F : var2);
      var4[2] = var3 < 0.0F ? 0.0F : (var3 > 1.0F ? 1.0F : var3);
      this.ja(var1, 1, var4[1]);
   }

   private void ji(int var1, int var2, int var3, int var4, int var5) {

      int var6 = this.fl(var1);
      int var7 = this.fm(var2);
      if (var3 >= var6 && var3 < var6 + this.and && var4 >= var7 && var4 < var7 + this.ane) {
         if (this.adj) {
            this.mx(var6, var7, var3, var4, var5);
         } else if (this.art == 1) {
            this.aro = Math.max(0, Math.min(this.hd(), this.aro - var5));
         } else {
            int var8 = this.ark >= 0 ? Math.round(this.arl) : this.arj;
            this.ark = -1;
            this.arj = Math.max(0, Math.min(this.hb(), var8 - var5));
         }
      }
   }

   private void jj(DrawContext var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {

      this.jk(var1, var2, var3, var4, var5, var6, var7, var8, 1.0F);
   }

   private void jk(DrawContext var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9) {

      int var10 = var9 == 1.0F ? amy : o(amy, Math.min(-2139244199 ^ -2139244122, Math.round((float)(amy >>> 24) * var9)));
      if (var8 >= 0.0F) {
         if (yv && !aim) {
            cn(var1, var2, var3, var4, var5, var6, var8, var8 * 0.4F, -1080118241 ^ -476138465);
         } else {
            bt(var1, var2 - 1.0F, var3 + 1.0F, var4 + 2.0F, var5 + 2.0F, var6 + 1.0F, -346187570 ^ -849504050, true, true, true, true);
         }
      }

      ci(var1, var2, var3, var4, var5, var6, true, true, true, true, this.ck());
      bt(var1, var2, var3, var4, var5, var6, yv ? cg(var10) : var10, true, true, true, true);
      jl(var1, var2, var3, var4, var5, var6, asx);
      eu(var1, var2, var3, var4, var5, var6, var7 <= 0.0F ? asv : cq(asv, asw, Math.min(1.0F, var7)));
   }

   private static void jl(DrawContext var0, float var1, float var2, float var3, float var4, float var5, int var6) {

      if (yv && !aim && var6 >>> 24 != 0 && var3 > 0.0F && var4 > 0.0F) {
         int var7 = agi >= 0.999F ? var6 : dk(var6, agi);
         int var8 = var7 & (-2002025098 ^ -2007729527);
         float var9 = fs();
         float var10 = Math.max(0.0F, Math.min(var5, Math.min(var3, var4) * 0.5F) - var9);
         Matrix3x2fStack var11 = var0.getMatrices();
         if (ahq) {
            if (!ahr && aht != null) {
               aht.roundV(var11, var1 + var9, var2 + var9, var3 - 2.0F * var9, var4 - 2.0F * var9, var10, var7, var8, true, true, true, true);
            }
         } else {
            PaneGlassCache var12 = aiq;
            if (var12 != null) {
               try {
                  var12.clip(var0.scissorStack.peekLast());
                  var12.roundV(var11, var1 + var9, var2 + var9, var3 - 2.0F * var9, var4 - 2.0F * var9, var10, var7, var8, true, true, true, true);
               } catch (Throwable var14) {
                  aim = true;
               }
            }
         }
      }
   }

   private float jm(Object var1, Object var2, Object var3, float var4, float var5, boolean var6, float[] var7, int var8) {

      float var9 = this.aiw.containsKey(var3) ? this.aiw.getFloat(var3) : 0.0F;
      float var10 = this.cw(var3, var6);
      if (var6) {
         if (var9 < 0.08F || !this.aix.containsKey(var1)) {
            this.aix.put(var1, var4);
            this.ajc.put(var1, 0.0F);
            if (var2 != null) {
               this.aix.put(var2, var5);
               this.ajc.put(var2, 0.0F);
            }
         }

         var7[2 * var8] = var4;
         var7[2 * var8 + 1] = var5;
      }

      this.ata = this.db(this.aix, var1, var7[2 * var8]);
      if (var2 != null) {
         this.atb = this.db(this.aix, var2, var7[2 * var8 + 1]);
      }

      return var10;
   }

   private void jn() {

      this.bbt = 0;
      this.ady = this.bbt;
      this.bbp = 0.0F;
      this.bbq = 0.0F;
   }

   private void jo(boolean var1, String var2) {

      this.bcl = var2;
      this.bcm = var1;
      this.bcn = System.nanoTime();
   }

   private static boolean jp() {

      return bcq != 0 && bcx != 0L && System.nanoTime() - bcx < 10000000000L;
   }

   private void jq() {

      boolean var1 = this.ane < (1893938045 ^ 1893937705);
      boolean var2 = this.and < (665979199 ^ 665979751);
      this.bdm = var1;
      this.bdn = var2;
      this.bdd = var1 ? 40 : 52;
      this.bde = var1 ? 38 : 50;
      this.bdf = var1 ? 36 : 48;
      this.bdl = var1 ? 22 : 26;
      this.bdg = this.bdd + this.bde;
      this.bdh = this.ane - this.bdg - this.bdf - (var1 ? 4 : 10);
      this.bdk = var2 ? -658721106 ^ -658721250 : 542245903 ^ 542246109;
      this.bdj = this.and - 16 - this.bdk;
      this.bdi = this.bdj - 14 - 16;
      this.kh();
      int var3 = Math.max(0, this.bes + 6 - (this.jr() - 26));
      this.ady = Math.max(0, Math.min(var3, this.ady));
   }

   private int jr() {

      return jp() ? this.bdh - (this.bdm ? 28 : 32) - (this.bdm ? 10 : 14) : this.bdh;
   }

   private int js(int var1) {

      return var1 + 22 + Math.round((float)this.bd(abn[2]) * 1.5F) + 30;
   }

   private int jt(int var1) {

      return var1 + this.bdd - 34;
   }

   private int ju() {

      if (this.bdq != ahd) {
         this.bdq = ahd;

         for (int var1 = 0; var1 < 3; var1++) {
            this.bdp[var1] = this.bd(ate[var1]);
         }
      }

      return this.bdp[0] + this.bdp[1] + this.bdp[2] + 36;
   }

   private int jv(int var1, int var2, int var3, int var4) {

      this.ju();
      int var5 = this.jt(var2);
      if (var4 >= var5 && var4 < var5 + 34) {
         float var6 = (float)this.js(var1);
         float var7 = 9.0F;

         for (int var8 = 0; var8 < 3; var8++) {
            if ((float)var3 >= var6 - var7 && (float)var3 < var6 + (float)this.bdp[var8] + var7) {
               return var8;
            }

            var6 += (float)(this.bdp[var8] + 18);
         }

         return -1;
      } else {
         return -1;
      }
   }

   private void jw(DrawContext var1, int var2, int var3, int var4, int var5) {

      this.ju();
      int var6 = this.js(var2);
      int var7 = this.jt(var3);
      int var8 = this.bbc;
      int var9 = this.jv(var2, var3, var4, var5);
      float var10 = 0.0F;

      for (int var11 = 0; var11 < var8; var11++) {
         var10 += (float)(this.bdp[var11] + 18);
      }

      float var16 = this.db(this.aiw, bli, var10);
      float var12 = this.db(this.aiw, bll, (float)this.bdp[var8]);
      bt(var1, (float)var6 + var16, (float)var7 + 34.0F - 1.5F, var12, 1.5F, 0.75F, yd, true, true, true, true);
      float var13 = (float)var6;
      int var14 = ft((float)var7, 34.0F) - 1;

      for (int var15 = 0; var15 < 3; var15++) {
         this.ay(var1, ate[var15], Math.round(var13), var14, var15 == var8 ? amm : (var15 == var9 ? amn : amo), false);
         var13 += (float)(this.bdp[var15] + 18);
      }
   }

   private BundleSync.Entry jx() {

      if (this.bbd.isEmpty()) {
         return null;
      } else {
         assert this.bbd != null
            && atq != null
            && atq.length > 92
            && bbb != null
            && bbb.length > 36
            && ana != null
            && axg != null
            && axg.length > 95
            && bjy != null
            && bjy.length == 30
            && blo != null
            && blo.length == 48
            && abp != null
            && abp.length > 10
            && abn != null
            && abn.length == 3 : "cfg" + "SelEntry: bad" + " s" + "tate";

         List var1 = BundleSync.LIST;
         BundleSync.Entry var2 = null;

         try {
            int var3 = 0;

            for (int var4 = var1.size(); var3 < var4; var3++) {
               var2 = (BundleSync.Entry)var1.get(var3);
               if (var2.id.equals(this.bbd)) {
                  return var2;
               }
            }

            return null;
         } catch (RuntimeException var5) {
            throw var5;
         }
      }
   }

   private boolean jy() {

      BundleSync.Entry var1 = this.jx();
      return var1 != null && var1.c;
   }

   private boolean jz() {

      BundleSync.Entry var1 = this.jx();
      return var1 != null && abp[0].equals(var1.b);
   }

   private String ka() {

      BundleSync.Entry var1 = this.jx();
      return var1 != null ? var1.a : "";
   }

   private int kb() {

      return this.bcg ? -1 : this.kc(this.adp);
   }

   private int kc(String var1) {

      if (var1 != null && !var1.isEmpty()) {
         assert this.ado != null
            && var1 != null
            && atq != null
            && atq.length > 92
            && bbb != null
            && bbb.length > 36
            && ana != null
            && axg != null
            && axg.length > 95
            && bjy != null
            && bjy.length == 30
            && blo != null
            && blo.length == 48
            && abp != null
            && abp.length > 10
            && abn != null
            && abn.length == 3 : "cfgIdxOf: b" + "ad state";

         List var2 = this.ado;

         try {
            int var3 = 0;

            for (int var4 = var2.size(); var3 < var4; var3++) {
               if (((String)var2.get(var3)).equals(var1)) {
                  return var3;
               }
            }

            return -1;
         } catch (RuntimeException var5) {
            throw var5;
         }
      } else {
         return -1;
      }
   }

   private void kd() {

      List var1;
      String[] var2;
      try {
         var1 = ConfigBridge.c.d().r();
         var2 = ConfigBridge.c.d().t();
      } catch (Throwable var26) {
         var1 = new ArrayList();
         var2 = new String[]{""};
      }

      for (int var3 = var1.size() - 1; var3 >= 0; var3--) {
         if (((String)var1.get(var3)).equalsIgnoreCase(axg[88])) {
            var1.remove(var3);
         }
      }

      int var27 = var1.size();
      long[] var4 = new long[var27];
      JsonObject[] var5 = new JsonObject[var27];
      byte[][] var6 = new byte[var27][];

      for (int var7 = 0; var7 < var27; var7++) {
         String var8 = (String)var1.get(var7);

         try {
            var4[var7] = ConfigBridge.c.d().n(var8);
            var5[var7] = ConfigBridge.c.d().k(var8);
            var6[var7] = var5[var7] == null ? null : ConfigBridge.c.d().m(var5[var7]);
         } catch (Throwable var25) {
            var4[var7] = 0L;
            var5[var7] = null;
            var6[var7] = null;
         }
      }

      int[] var28 = new int[var27];
      int var29 = 0;

      while (var29 < var27) {
         int var9;
         for (var9 = var29; var9 > 0 && var4[var28[var9 - 1]] < var4[var29]; var9--) {
            var28[var9] = var28[var9 - 1];
         }

         var28[var9] = var29++;
      }

      ZoneId var30 = ZoneId.systemDefault();
      LocalDate var31 = LocalDate.now(var30);
      ArrayList var10 = new ArrayList(var27);
      String[] var11 = new String[var27];
      String[] var12 = new String[var27];
      String[] var13 = new String[var27];
      byte[][] var14 = new byte[var27][];
      JsonObject[] var15 = new JsonObject[var27];
      long[] var16 = new long[var27];
      int[] var17 = new int[var27];

      for (int var18 = 0; var18 < var27; var18++) {
         int var19 = var28[var18];
         var10.add((String)var1.get(var19));
         var14[var18] = var6[var19];
         var15[var18] = var5[var19];
         var16[var18] = var4[var19];
         int var20 = 0;
         if (var6[var19] != null) {
            for (byte var24 : var6[var19]) {
               var20 += var24 == 1 ? 1 : 0;
            }
         }

         var17[var18] = var6[var19] == null ? -1 : var20;
         var11[var18] = var6[var19] == null ? atq[89] : var20 + atq[32];
         var12[var18] = var4[var19] > 0L ? kf(var4[var19], var30, var31, false) : atq[89];
         var13[var18] = var4[var19] > 0L ? atq[27] + kf(var4[var19], var30, var31, true) + atq[29] + var11[var18] : var11[var18];
      }

      this.ado = var10;
      this.bdx = var11;
      this.bdy = var12;
      this.bdz = var13;
      this.bea = var14;
      this.beb = var15;
      this.bec = var16;
      this.bed = var17;
      this.bee = var27;
      bcd = this.ke(var2.length > 0 ? var2[0] : "");
      bce.clear();

      for (int var32 = 1; var32 < var2.length; var32++) {
         String var33 = this.ke(var2[var32]);
         if (!var33.isEmpty() && !bce.contains(var33)) {
            bce.add(var33);
         }
      }

      bcf++;
      this.bef++;
      this.bfl = -1;
      this.bcp = true;
   }

   private String ke(String var1) {

      if (var1 != null && !var1.isEmpty()) {
         for (String var3 : this.ado) {
            if (var3.equalsIgnoreCase(var1)) {
               return var3;
            }
         }

         return "";
      } else {
         return "";
      }
   }

   private static String kf(long var0, ZoneId var2, LocalDate var3, boolean var4) {

      LocalDateTime var5 = LocalDateTime.ofInstant(Instant.ofEpochMilli(var0), var2);
      LocalDate var6 = var5.toLocalDate();
      int var7 = var5.getHour();
      int var8 = var5.getMinute();
      String var9 = (var7 < 10 ? "0" : "") + var7 + atq[84] + (var8 < 10 ? "0" : "") + var8;
      long var10 = var3.toEpochDay() - var6.toEpochDay();
      String var12 = var5.getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH)
         + atq[90]
         + var6.getDayOfMonth()
         + (var6.getYear() != var3.getYear() ? atq[83] + var6.getYear() : "");
      if (var4) {
         return var10 == 0L ? atq[81] + var9 : (var10 == 1L ? atq[82] + var9 : var12 + atq[83] + var9);
      } else {
         return var10 == 0L ? atq[79] + var9 : (var10 == 1L ? atq[80] : var12);
      }
   }

   private static long kg(long var0) {

      return var0 <= 0L ? 0L : (var0 < 100000000000L ? var0 * 1000L : var0);
   }

   private void kh() {

      boolean var1 = this.bbc != 0;
      List var2 = BundleSync.LIST;
      int var3 = var1 ? bck : bcj;
      if (this.bez != this.bef
         || this.bfa != this.bbc
         || this.bfe != this.bch
         || this.bfb != var3
         || this.bfc != bcf
         || this.bfd != this.bdl
         || var1 && this.bff != var2) {
         this.bez = this.bef;
         this.bfa = this.bbc;
         this.bfe = this.bch;
         this.bfb = var3;
         this.bfc = bcf;
         this.bfd = this.bdl;
         this.bff = var2;
         if (var2 != bdv) {
            bdv = var2;
            bdw = System.nanoTime();
         }

         String var4 = this.bch.trim().toLowerCase(Locale.ROOT);
         if (var1) {
            this.ko(var2, var4, var3);
         } else {
            this.kl(var4, var3);
         }

         this.bey = axg[34] + this.bch.trim() + axg[34];
         int var5 = var1 ? this.bdt : this.ado.size();
         this.bex = this.beu + axg[32] + var5 + axg[33];
         this.bew = this.bet + axg[35];
         if (var5 != this.bfj) {
            this.bfj = var5;
            this.bfi = axg[31] + var5 + (var5 == 1 ? atq[91] : atq[64]);
         }

         this.bfl = -1;
         this.bfq = null;
      }
   }

   private void ki(int var1) {

      this.bek = new int[var1];
      this.bel = new int[var1];
      this.bem = new int[var1];
      this.ben = new int[var1];
      this.beo = new String[var1];
      this.bep = new String[var1];
      this.beq = new String[var1];
      this.ber = 0;
   }

   private int kj(int var1, int var2, int var3, int var4) {

      int var5 = this.ber++;
      this.bek[var5] = var1;
      this.bel[var5] = var2;
      this.bem[var5] = var3;
      this.ben[var5] = var4;
      return var3 + var4;
   }

   private void kk(int var1, String var2, String var3) {

      if (!var3.isEmpty()) {
         int var4 = var2.toLowerCase(Locale.ROOT).indexOf(var3);
         if (var4 >= 0) {
            this.beo[var1] = var2.substring(0, var4);
            this.bep[var1] = var2.substring(var4, var4 + var3.length());
            this.beq[var1] = var2.substring(var4 + var3.length());
         }
      }
   }

   private void kl(String var1, int var2) {

      List var3 = this.ado;
      int var4 = Math.min(var3.size(), this.bee);
      int[] var5 = new int[var4];
      int[] var6 = new int[var4];
      int var7 = 0;
      int var8 = 0;
      int var9 = 0;

      for (int var10 = 0; var10 < var4; var10++) {
         String var11 = (String)var3.get(var10);
         if (var1.isEmpty() || var11.toLowerCase(Locale.ROOT).contains(var1)) {
            var9++;
            if (var1.isEmpty() && bce.contains(var11)) {
               var5[var7++] = var10;
            } else {
               var6[var8++] = var10;
            }
         }
      }

      this.beu = var9;
      this.bet = var4 - var9;
      var5 = this.km(var5, var7, var2);
      var6 = this.km(var6, var8, var2);
      this.ki(var7 + var8 + 3);
      int var15 = this.bdl;
      int var16 = 0;
      if (var1.isEmpty()) {
         var16 = this.kj(0, -1, 0, var15) + 8;
         if (var7 > 0) {
            var16 = this.kj(1, -1, var16, 20);

            for (int var12 = 0; var12 < var7; var12++) {
               var16 = this.kj(3, var5[var12], var16, var15);
            }
         }

         if (var8 > 0) {
            var16 = this.kj(2, -1, var16 + (var7 > 0 ? 6 : 0), 20);
         }
      }

      for (int var17 = 0; var17 < var8; var17++) {
         this.kk(this.ber, (String)var3.get(var6[var17]), var1);
         var16 = this.kj(3, var6[var17], var16, var15);
      }

      this.bes = var16;
      this.bev = var7 + var8;
   }

   private int[] km(int[] var1, int var2, int var3) {

      int[] var4 = new int[var2];
      if (var3 == 0) {
         String[] var9 = new String[var2];

         for (int var11 = 0; var11 < var2; var11++) {
            var9[var11] = this.ado.get(var1[var11]).toLowerCase(Locale.ROOT) + '\u0000' + (char)var1[var11];
         }

         Arrays.sort((Object[])var9);

         for (int var12 = 0; var12 < var2; var12++) {
            var4[var12] = var9[var12].charAt(var9[var12].length() - 1);
         }

         return var4;
      } else {
         long[] var5 = new long[var2];

         for (int var6 = 0; var6 < var2; var6++) {
            long var7 = var3 == 1 ? (long)this.bed[var1[var6]] + 1L : this.bec[var1[var6]];
            var5[var6] = kn(var7, var6);
         }

         Arrays.sort(var5);

         for (int var10 = 0; var10 < var2; var10++) {
            var4[var10] = var1[(int)(var5[var10] & 65535L)];
         }

         return var4;
      }
   }

   private static long kn(long var0, int var2) {

      long var3 = Math.max(0L, Math.min(70368744177663L, var0));
      return 70368744177663L - var3 << 16 | (long)(var2 & (103804899 ^ 103747612));
   }

   private void ko(List<BundleSync.Entry> var1, String var2, int var3) {

      assert var1 != null
         && this.bdr != null
         && atq != null
         && atq.length > 92
         && bbb != null
         && bbb.length > 36
         && ana != null
         && axg != null
         && axg.length > 95
         && bjy != null
         && bjy.length == 30
         && blo != null
         && blo.length == 48
         && abp != null
         && abp.length > 10
         && abn != null
         && abn.length == 3 : "cfgOrderCl" + "oud: bad state";

      this.bdu = var1;
      int var4 = var1.size();
      int var5 = 0;
      int var6 = 0;
      int[] var7 = new int[var4];
      if (var1 != this.bfh) {
         this.bfh = var1;
         this.bfg = new String[var4];
         ZoneId var8 = ZoneId.systemDefault();
         LocalDate var9 = LocalDate.now(var8);

         for (int var10 = 0; var10 < var4; var10++) {
            long var11 = kg(((BundleSync.Entry)var1.get(var10)).e);
            this.bfg[var10] = var11 > 0L ? kf(var11, var8, var9, false) : atq[89];
         }
      }

      Object var14 = null;

      try {
         for (int var18 = 0; var18 < var4; var18++) {
            var14 = (BundleSync.Entry)var1.get(var18);
            if (this.bbc != 2 || ((BundleSync.Entry)var14).d) {
               var6++;
               if (var2.isEmpty()
                  || ((BundleSync.Entry)var14).a.toLowerCase(Locale.ROOT).contains(var2)
                  || ((BundleSync.Entry)var14).b.toLowerCase(Locale.ROOT).contains(var2)) {
                  var7[var5++] = var18;
               }
            }
         }
      } catch (RuntimeException var13) {
         throw var13;
      }

      this.bdt = var6;
      this.beu = var5;
      this.bet = var6 - var5;
      int[] var19 = new int[var5];
      if (var3 != 0 && var3 != 1) {
         long[] var21 = new long[var5];

         for (int var25 = 0; var25 < var5; var25++) {
            var14 = (BundleSync.Entry)var1.get(var7[var25]);
            var21[var25] = kn(var3 == 2 ? (long)((BundleSync.Entry)var14).f : kg(((BundleSync.Entry)var14).e), var25);
         }

         Arrays.sort(var21);

         for (int var26 = 0; var26 < var5; var26++) {
            var19[var26] = var7[(int)(var21[var26] & 65535L)];
         }
      } else {
         String[] var20 = new String[var5];

         for (int var23 = 0; var23 < var5; var23++) {
            var14 = (BundleSync.Entry)var1.get(var7[var23]);
            var20[var23] = (var3 == 0 ? ((BundleSync.Entry)var14).a : ((BundleSync.Entry)var14).b).toLowerCase(Locale.ROOT) + '\u0000' + (char)var23;
         }

         Arrays.sort((Object[])var20);

         for (int var24 = 0; var24 < var5; var24++) {
            var19[var24] = var7[var20[var24].charAt(var20[var24].length() - 1)];
         }
      }

      if (this.bdr.length < var5) {
         this.bdr = new int[var5 + 16];
      }

      System.arraycopy(var19, 0, this.bdr, 0, var5);
      this.bds = var5;
      this.ki(var5);
      int var22 = 0;

      for (int var27 = 0; var27 < var5; var27++) {
         this.kk(var27, ((BundleSync.Entry)var1.get(var19[var27])).a, var2);
         var22 = this.kj(3, var19[var27], var22, this.bdl);
      }

      this.bes = var22;
      this.bev = var5;
   }

   private int kp(int var1, int var2, int var3, int var4) {

      int var5 = var1 + 16;
      int var6 = var2 + this.bdg;
      if (var3 >= var5 && var3 < var5 + this.bdi && var4 >= var6 + 22 + 1 && var4 < var6 + this.jr()) {
         assert this.bek != null
            && this.bem != null
            && this.ben != null
            && atq != null
            && atq.length > 92
            && axg != null
            && axg.length > 95
            && bjy != null
            && bjy.length == 30
            && blo != null
            && blo.length == 48
            && abp != null
            && abp.length > 10
            && abn != null
            && abn.length == 3 : "cfgItemAt: bad " + "state";

         int var7 = this.dg(var4, this.bbq) - (var6 + 26) + this.bbt;

         try {
            for (int var8 = 0; var8 < this.ber; var8++) {
               if (var7 >= this.bem[var8] && var7 < this.bem[var8] + this.ben[var8]) {
                  return var8;
               }
            }

            return -1;
         } catch (RuntimeException var9) {
            throw var9;
         }
      } else {
         return -1;
      }
   }

   private int kq() {

      assert this.bek != null
         && this.bel != null
         && this.bdu != null
         && atq != null
         && atq.length > 92
         && axg != null
         && axg.length > 95
         && bjy != null
         && bjy.length == 30
         && blo != null
         && blo.length == 48
         && abp != null
         && abp.length > 10
         && abn != null
         && abn.length == 3 : "cfgSelItem" + ":" + " bad" + " state";

      boolean var1 = this.bbc != 0;
      int var2 = var1 ? -1 : this.kb();
      int var3 = this.bdu.size();

      try {
         for (int var4 = 0; var4 < this.ber; var4++) {
            int var5 = this.bek[var4];
            if (var5 == 0 && !var1 && this.bcg) {
               return var4;
            }

            if (var5 == 3) {
               int var6 = this.bel[var4];
               if (var1) {
                  if (var6 >= 0 && var6 < var3 && this.bdu.get(var6).id.equals(this.bbd)) {
                     return var4;
                  }
               } else if (var6 == var2 && var2 >= 0) {
                  return var4;
               }
            }
         }

         return -1;
      } catch (RuntimeException var7) {
         throw var7;
      }
   }

   private String kr(int var1, int var2) {

      if (var2 != this.bfl || ahd != this.bfm || bcd != this.bfn || this.bfk.length != this.ado.size()) {
         this.bfk = new String[this.ado.size()];
         this.bfl = var2;
         this.bfm = ahd;
         this.bfn = bcd;
      }

      String var3 = this.bfk[var1];
      if (var3 == null) {
         String var4 = this.ado.get(var1);
         var3 = this.ex(var4, var4.equals(bcd) ? var2 - this.gh(atq[22]) - 17 : var2);
         this.bfk[var1] = var3;
      }

      return var3;
   }

   private void ks(int var1) {

      List var2 = this.bdu;
      if (var2 != this.bfq || var1 != this.bfr || ahd != this.bfs || this.bfo.length != var2.size()) {
         this.bfo = new String[var2.size()];
         this.bfp = new String[var2.size()];
         this.bfq = var2;
         this.bfr = var1;
         this.bfs = ahd;
      }
   }

   private static String kt(int var0) {

      return var0 < bhq.length ? bhq[var0] : Integer.toString(var0);
   }

   private static List<BuilderFactory> ku() {

      return ConfigBridge.c != null && ConfigBridge.c.c() != null ? ConfigBridge.c.c().a() : null;
   }

   private int kv() {

      return this.kc(bcd);
   }

   private int kw(List<BuilderFactory> var1, int var2) {

      if (this.bhv != ahd || this.bhu.length != var1.size()) {
         this.bhu = new int[var1.size()];
         Arrays.fill(this.bhu, -1);
         this.bhv = ahd;
      }

      int var3 = this.bhu[var2];
      if (var3 < 0) {
         BuilderFactory var4 = (BuilderFactory)var1.get(var2);
         var3 = this.bf(var4.c, var4.cK);
         this.bhu[var2] = var3;
      }

      return var3;
   }

   private static boolean kx(JsonElement var0, JsonElement var1) {

      if (var0 == null || var1 == null) {
         return var0 == var1;
      } else if (var0.equals(var1)) {
         return true;
      } else if (var0.isJsonPrimitive() && var1.isJsonPrimitive()) {
         JsonPrimitive var2 = var0.getAsJsonPrimitive();
         JsonPrimitive var3 = var1.getAsJsonPrimitive();
         if (var2.isNumber() && var3.isNumber()) {
            double var4 = var2.getAsDouble();
            double var6 = var3.getAsDouble();
            return Math.abs(var4 - var6) <= 1.0E-6 * Math.max(1.0, Math.abs(var4));
         } else if (var2.isNumber() && var3.isString()) {
            return var3.getAsString().endsWith(axg[59].trim());
         } else if (var3.isNumber() && var2.isString()) {
            return var2.getAsString().endsWith(axg[59].trim());
         } else {
            return var2.isBoolean() && var3.isBoolean() ? var2.getAsBoolean() == var3.getAsBoolean() : var2.getAsString().equals(var3.getAsString());
         }
      } else {
         return false;
      }
   }

   private static JsonObject ky(JsonObject var0, BuilderFactory var1) {

      JsonElement var2 = var0.get(sj(var1));
      if (var2 == null || !var2.isJsonObject()) {
         var2 = bn(var0, var1);
      }

      return var2 != null && var2.isJsonObject() ? var2.getAsJsonObject() : null;
   }

   private static String kz(double var0, double var2, boolean var4) {

      int var5 = var2 >= 1.0 ? 0 : (var2 >= 0.1 ? 1 : 2);
      String var6 = var5 == 0 ? Long.toString(Math.round(var0)) : BigDecimal.valueOf(var0).setScale(var5, RoundingMode.HALF_UP).toPlainString();
      if (var4 && var6.indexOf(46) >= 0) {
         int var7 = var6.length();

         while (var7 > 0 && var6.charAt(var7 - 1) == '0') {
            var7--;
         }

         if (var7 > 0 && var6.charAt(var7 - 1) == '.') {
            var7--;
         }

         var6 = var6.substring(0, var7);
      }

      return var6;
   }

   private String la(InitAdapter var1, JsonElement var2) {

      if (var2 != null && var2.isJsonPrimitive()) {
         JsonPrimitive var3 = var2.getAsJsonPrimitive();
         if (var1 instanceof CheckerBridge) {
            return var3.getAsBoolean() ? axg[57] : axg[58];
         } else if (var1 instanceof TimingEntry) {
            String var6 = var3.getAsString();
            String var5 = axg[59].trim();
            return var6.endsWith(var5) ? var6.substring(0, var6.length() - var5.length()) + axg[59] : var6;
         } else if (var1 instanceof BlockCalculator) {
            return var3.isNumber() ? kz(var3.getAsDouble(), ((BlockCalculator)var1).k(), false) : var3.getAsString();
         } else if (var1 instanceof ItemDescriptor) {
            return var3.isNumber() ? qr(var3.getAsInt()) : var3.getAsString();
         } else {
            String var4 = var3.getAsString();
            return var4.length() > 40 ? var4.substring(0, 40) + atq[75] : var4;
         }
      } else {
         return atq[89];
      }
   }

   private String lb(String var1, JsonElement var2) {

      if (var2 != null && var2.isJsonPrimitive()) {
         JsonPrimitive var3 = var2.getAsJsonPrimitive();
         if (var3.isBoolean()) {
            return var3.getAsBoolean() ? axg[57] : axg[58];
         } else if (!var3.isNumber()) {
            return var3.getAsString();
         } else if (var1.equals(bhr[3])) {
            int var4 = var3.getAsInt();
            return var4 >= 0 && var4 < ThemeCache.ALL.length ? ThemeCache.ALL[var4].a() : Integer.toString(var4);
         } else {
            return var1.equals(bhr[4]) ? qr(var3.getAsInt()) : kz(var3.getAsDouble(), 0.01, true);
         }
      } else {
         return atq[89];
      }
   }

   private static String lc(String var0) {

      for (byte var1 = 0; var1 + 1 < bht.length; var1 += 2) {
         if (bht[var1].equals(var0)) {
            return bht[var1 + 1];
         }
      }

      StringBuilder var4 = new StringBuilder(var0.length() + 4);

      for (int var2 = 0; var2 < var0.length(); var2++) {
         char var3 = var0.charAt(var2);
         if (var2 == 0) {
            var4.append(Character.toUpperCase(var3));
         } else if (Character.isUpperCase(var3)) {
            var4.append(' ').append(Character.toLowerCase(var3));
         } else {
            var4.append(var3);
         }
      }

      return var4.toString();
   }

   private static boolean ld(String var0) {

      for (String var4 : bhs) {
         if (var4.equals(var0)) {
            return true;
         }
      }

      return false;
   }

   private void le() {

      assert this.bfx != null
         && this.bfy != null
         && this.bgo != null
         && this.bea != null
         && atq != null
         && atq.length > 92
         && this.ado != null
         && this.bdx != null
         && this.bdy != null
         && this.bdz != null
         && this.bfk != null
         && this.bdr != null
         && abp != null
         && abn != null
         && axg != null
         && axg.length > 95 : "cfgDiffTick: bad " + "s" + "ta" + "te";

      List var1 = ku();
      if (var1 == null) {
         this.bhg = 0;
      } else {
         int var2 = var1.size();
         int var3 = 1;
         int var4 = 0;

         try {
            for (int var5 = 0; var5 < var2; var5++) {
               boolean var6 = ((BuilderFactory)var1.get(var5)).f;
               var3 = var3 * 31 + (var6 ? 1 : 2);
               var4 += var6 ? 1 : 0;
            }
         } catch (RuntimeException var7) {
            throw var7;
         }

         this.bhg = var4;
         if (var3 != this.bhf) {
            this.bhf = var3;
            this.bcp = true;
         }

         if (this.bcp) {
            this.lf();
         }

         int var8 = this.bbc == 0 ? this.kb() : -1;
         if (var8 != this.bgy || this.bgz != this.bhe || this.bha != this.bef || this.bhb != ahd) {
            this.bgy = var8;
            this.bgz = this.bhe;
            this.bha = this.bef;
            this.bhb = ahd;
            this.bhc = var8 >= 0 && (var8 >= this.beb.length || this.beb[var8] == null);
            this.lg(0, var8 >= 0 && var8 < this.beb.length ? this.beb[var8] : null, true);
         }
      }
   }

   private void lf() {

      this.bcp = false;
      Object var1 = null;

      try {
         var1 = ConfigBridge.c.d().f();
      } catch (Throwable var7) {
         var1 = null;
      }

      this.bhd = (JsonObject)var1;
      this.bhe++;
      int var2 = this.kv();
      this.lg(1, var2 >= 0 && var2 < this.beb.length ? this.beb[var2] : null, false);
      this.bhh = var2 >= 0 ? this.bgb[1] + this.bgc[1] + this.bgd[1] : 0;
      List<BuilderFactory> var3 = ku();
      int var4 = 0;
      if (var3 != null) {
         for (BuilderFactory var6 : var3) {
            var4 += var6.f ? 1 : 0;
         }
      }

      this.bhg = var4;
      this.bhj = var4 + atq[32];
      if (var2 < 0) {
         this.bhi = axg[6];
         this.bhk = axg[83];
         this.bhm = atq[29] + var4 + atq[42];
         this.bhl = axg[62];
      } else {
         this.bhi = this.bhh > 0 ? bcd + axg[4] : axg[5] + bcd;
         this.bhk = this.bhh > 0 ? this.bhh + axg[7] : axg[8];
         this.bhm = this.bhh > 0 ? atq[29] + this.bhh + axg[84] : atq[29] + var4 + atq[42];
         this.bhl = axg[20] + bcd.toUpperCase(Locale.ROOT);
      }

      this.blr = null;
   }

   private void lg(int var1, JsonObject var2, boolean var3) {

      assert this.bfx != null
         && this.bfy != null
         && this.bgo != null
         && this.bgs != null
         && atq != null
         && atq.length > 92
         && axg != null
         && axg.length > 95
         && bhq != null
         && bhr != null
         && bhr.length == 5
         && abp != null
         && abn != null
         && abn.length == 3 : "cfgCompute:" + " bad s" + "tate";

      this.bge[var1]++;
      List var4 = ku();
      JsonObject var5 = this.bhd;
      int var6 = var4 != null && var5 != null && var2 != null ? var4.size() : 0;
      int[] var7 = new int[var6];
      int[] var8 = new int[var6];
      int[] var9 = new int[var6];
      int[] var10 = new int[var6];
      boolean[] var11 = new boolean[var6];
      byte var12 = 64;
      int var13 = 0;
      int[] var14 = new int[var12];
      InitAdapter[] var15 = new InitAdapter[var12];
      String[] var16 = new String[var12];
      String[] var17 = new String[var12];
      BuilderFactory var18 = null;
      Object var19 = null;
      JsonObject var20 = null;
      JsonObject var21 = null;
      JsonElement var22 = null;
      JsonElement var23 = null;
      JsonElement var24 = null;
      JsonElement var25 = null;

      try {
         for (int var26 = 0; var26 < var6; var26++) {
            var18 = (BuilderFactory)var4.get(var26);
            var20 = ky(var2, var18);
            var21 = ky(var5, var18);
            var9[var26] = var13;
            var11[var26] = var18.f;
            if (var20 != null && var21 != null) {
               var22 = var20.get(bhr[1]);
               var23 = var21.get(bhr[1]);
               boolean var27 = var22 != null && var22.isJsonPrimitive() ? var22.getAsBoolean() : var18.f;
               boolean var28 = var23 != null && var23.isJsonPrimitive() ? var23.getAsBoolean() : var18.f;
               boolean var29 = var3 ? var28 : var27;
               boolean var30 = var3 ? var27 : var28;
               var11[var26] = var30;
               if (var30 && !var29) {
                  var7[var26] = 1;
               } else if (!var30 && var29) {
                  var7[var26] = 2;
               }

               int var31 = 0;
               List var32 = var18.k();
               int var33 = var32 == null ? 0 : var32.size();

               for (int var34 = -1; var34 < var33; var34++) {
                  String var35 = var34 < 0 ? bhr[2] : kt(var34);
                  var22 = var20.get(var35);
                  var23 = var21.get(var35);
                  if (var22 != null && var23 != null && !kx(var22, var23)) {
                     var19 = var34 < 0 ? null : (InitAdapter)var32.get(var34);
                     if (var13 == var12) {
                        var12 *= 2;
                        var14 = Arrays.copyOf(var14, var12);
                        var15 = Arrays.copyOf(var15, var12);
                        var16 = Arrays.copyOf(var16, var12);
                        var17 = Arrays.copyOf(var17, var12);
                     }

                     var24 = var3 ? var23 : var22;
                     var25 = var3 ? var22 : var23;
                     var14[var13] = var34 < 0 ? 2 : 1;
                     var15[var13] = (InitAdapter)var19;
                     if (var34 >= 0) {
                        var16[var13] = this.la((InitAdapter)var19, var24);
                        var17[var13] = this.la((InitAdapter)var19, var25);
                     } else {
                        var16[var13] = var24.isJsonPrimitive() && var24.getAsJsonPrimitive().isNumber() ? qr(var24.getAsInt()) : atq[89];
                        var17[var13] = var25.isJsonPrimitive() && var25.getAsJsonPrimitive().isNumber() ? qr(var25.getAsInt()) : atq[89];
                     }

                     var13++;
                     var31++;
                  }
               }

               var10[var26] = var13;
               var8[var26] = var31;
               if (var7[var26] == 0 && var31 > 0) {
                  var7[var26] = 3;
               }
            } else {
               var10[var26] = var13;
            }
         }
      } catch (RuntimeException var54) {
         throw var54;
      }

      int var65 = 0;
      String[] var66 = new String[8];
      String[] var67 = new String[8];
      String[] var68 = new String[8];
      JsonElement var69 = var2 != null && var5 != null ? var2.get(bhr[0]) : null;
      JsonElement var70 = var5 == null ? null : var5.get(bhr[0]);
      if (var69 != null && var70 != null && var69.isJsonObject() && var70.isJsonObject()) {
         JsonObject var71 = var70.getAsJsonObject();

         for (Entry var75 : var69.getAsJsonObject().entrySet()) {
            String var77 = (String)var75.getKey();
            JsonElement var36 = var71.get(var77);
            if (!ld(var77) && var36 != null && !kx((JsonElement)var75.getValue(), var36)) {
               if (var65 == var66.length) {
                  var66 = Arrays.copyOf(var66, var65 * 2);
                  var67 = Arrays.copyOf(var67, var65 * 2);
                  var68 = Arrays.copyOf(var68, var65 * 2);
               }

               var66[var65] = lc(var77);
               var67[var65] = this.lb(var77, var3 ? var36 : (JsonElement)var75.getValue());
               var68[var65] = this.lb(var77, var3 ? (JsonElement)var75.getValue() : var36);
               var65++;
            }
         }
      }

      int var72 = 0;
      int var74 = 0;
      int var76 = 0;
      int var78 = 0;
      int[] var79 = new int[var6 + 1];
      int[] var37 = new int[var6 + 1];
      String[] var38 = new String[var6 + 1];

      for (int var39 = 1; var39 <= 3; var39++) {
         for (int var40 = 0; var40 < var6; var40++) {
            if (var7[var40] == var39) {
               var79[var72] = var40;
               var37[var72] = var39;
               var38[var72] = var39 == 3 ? gy(var8[var40]) : null;
               var72++;
               if (var39 == 1) {
                  var74++;
               } else if (var39 == 2) {
                  var76++;
               } else {
                  var78++;
               }
            }
         }
      }

      if (var65 > 0) {
         var79[var72] = -1;
         var37[var72] = 4;
         var38[var72] = gy(var65);
         var72++;
         var78++;
      }

      this.bfx[var1] = var79;
      this.bfy[var1] = var37;
      this.bfz[var1] = var38;
      this.bga[var1] = var72;
      this.bgb[var1] = var74;
      this.bgc[var1] = var76;
      this.bgd[var1] = var78;
      this.bgf[var1][0] = var74 > 0 ? atq[87] + var74 + atq[32] : null;
      this.bgf[var1][1] = var76 > 0 ? atq[88] + var76 + atq[33] : null;
      this.bgf[var1][2] = var78 > 0 ? var78 + axg[23] : null;
      this.bgg[var1] = atq[35] + var72;
      int var80 = 0;

      for (int var81 = 0; var81 < var6; var81++) {
         var80 += var11[var81] ? 1 : 0;
      }

      int var82 = var72 + var13 + var65 + 2 + (var1 == 0 && var6 > 0 ? 1 + (var80 + 1) / 2 : 0);
      int[] var41 = new int[var82];
      int[] var42 = new int[var82];
      int[] var43 = new int[var82];
      int[] var44 = new int[var82];
      InitAdapter[] var45 = new InitAdapter[var82];
      String[] var46 = new String[var82];
      String[] var47 = new String[var82];
      String[] var48 = new String[var82];
      int var49 = 0;
      int var50 = 0;

      for (int var51 = 0; var51 < var72; var51++) {
         if (var37[var51] == 4) {
            var41[var49] = 3;
            var44[var49] = var50 + (var49 > 0 ? 4 : 0);
            var50 = var44[var49] + 12;
            var49++;

            for (int var84 = 0; var84 < var65; var84++) {
               var41[var49] = 4;
               var46[var49] = var66[var84];
               var47[var49] = var67[var84];
               var48[var49] = var68[var84];
               var44[var49] = var50;
               var50 += 12;
               var49++;
            }
         } else {
            int var52 = var79[var51];
            var41[var49] = 0;
            var42[var49] = var52;
            var43[var49] = var37[var51];
            var44[var49] = var50 + (var49 <= 0 || var41[var49 - 1] == 0 && var10[var52] <= var9[var52] ? 0 : 4);
            var50 = var44[var49] + 12;
            var49++;

            for (int var53 = var9[var52]; var53 < var10[var52]; var53++) {
               var41[var49] = var14[var53];
               var42[var49] = var52;
               var45[var49] = var15[var53];
               var47[var49] = var16[var53];
               var48[var49] = var17[var53];
               var44[var49] = var50;
               var50 += 12;
               var49++;
            }
         }
      }

      if (var1 == 0 && var6 > 0) {
         var41[var49] = 5;
         var46[var49] = axg[82];
         var47[var49] = gy(var80);
         var44[var49] = var50 + (var49 > 0 ? 8 : 0);
         var50 = var44[var49] + 14;
         var49++;
         int var83 = -1;

         for (int var85 = 0; var85 < var6; var85++) {
            if (var11[var85]) {
               if (var83 < 0) {
                  var83 = var85;
               } else {
                  var41[var49] = 6;
                  var42[var49] = var83;
                  var43[var49] = var85;
                  var47[var49] = var7[var83] == 1 ? atq[85] : null;
                  var48[var49] = var7[var85] == 1 ? atq[85] : null;
                  var44[var49] = var50;
                  var50 += 11;
                  var49++;
                  var83 = -1;
               }
            }
         }

         if (var83 >= 0) {
            var41[var49] = 6;
            var42[var49] = var83;
            var43[var49] = -1;
            var47[var49] = var7[var83] == 1 ? atq[85] : null;
            var44[var49] = var50;
            var50 += 11;
            var49++;
         }
      }

      this.bgo[var1] = var41;
      this.bgp[var1] = var42;
      this.bgq[var1] = var43;
      this.bgs[var1] = var45;
      this.bgt[var1] = var46;
      this.bgu[var1] = var47;
      this.bgv[var1] = var48;
      this.bgr[var1] = var44;
      this.bgw[var1] = var49;
      this.bgx[var1] = var50;
   }

   private int lh(List<BuilderFactory> var1, int var2, int var3) {

      int var4 = this.bfy[var2][var3];
      int var5 = this.bfx[var2][var3];
      int var6 = var4 == 1 ? this.bd(atq[85]) : (var4 == 2 ? this.bd(atq[86]) : 0);
      var6 += var5 >= 0 && var1 != null && var5 < var1.size() ? this.kw(var1, var5) : this.bd(axg[55]);
      String var7 = this.bfz[var2][var3];
      if (var7 != null) {
         var6 += this.bd(atq[90]) + this.bd(var7) + 1;
      }

      return var6 + 12;
   }

   private void li(int var1, int var2, int var3) {

      if (var1 != this.bif || this.bge[var1] != this.big || var2 != this.bih || var3 != this.bii || ahd != this.bij) {
         this.bif = var1;
         this.big = this.bge[var1];
         this.bih = var2;
         this.bii = var3;
         this.bij = ahd;
         List var4 = ku();
         int var5 = this.bga[var1];
         if (this.bhw.length < var5) {
            this.bhw = new int[var5];
            this.bhx = new int[var5];
            this.bhy = new int[var5];
         }

         for (int var6 = 0; var6 < var5; var6++) {
            this.bhy[var6] = this.lh(var4, var1, var6);
         }

         this.bhz = 0;
         this.bie = null;
         this.bid = 0;
         if (var5 != 0 && var2 > 0) {
            for (int var13 = var5; var13 >= 0; var13--) {
               String var7 = var13 == var5 ? this.bgg[var1] : atq[87] + (var5 - var13) + axg[80];
               int var8 = 0;
               int var9 = 0;
               boolean var10 = true;

               for (int var11 = 0; var11 < var13 && var10; var11++) {
                  int var12 = this.bhy[var11];
                  if (var8 > 0 && var8 + var12 > var3) {
                     var8 = 0;
                     var9++;
                  }

                  var10 = var9 < var2;
                  this.bhw[var11] = var8;
                  this.bhx[var11] = var9;
                  var8 += var12 + 5;
               }

               if (var10) {
                  int var14 = this.bd(var7) + 6;
                  if (var8 > 0 && var8 + var14 > var3) {
                     var8 = 0;
                     var9++;
                  }

                  if (var9 < var2) {
                     this.bhz = var13;
                     this.bie = var7;
                     this.bia = var8;
                     this.bib = var9;
                     this.bic = var14;
                     this.bid = var9 + 1;
                     return;
                  }
               }
            }
         }
      }
   }

   private static boolean lj(String var0) {

      String var1 = var0.trim().toLowerCase(Locale.ROOT);
      int var2 = var1.indexOf(46);
      if (var2 >= 0) {
         var1 = var1.substring(0, var2).trim();
      }

      return var1.length() == 3
         ? var1.equals("con") || var1.equals("prn") || var1.equals("aux") || var1.equals("nul")
         : var1.length() == 4 && (var1.startsWith("com") || var1.startsWith("lpt")) && var1.charAt(3) >= '1' && var1.charAt(3) <= '9';
   }

   private void lk() {

      String var1 = this.bbj == 3 ? this.bbg : this.adq;
      if (var1 != this.bik || this.bbj != this.bil || ahd != this.bir || this.bdk != this.bis) {
         this.bik = var1;
         this.bil = this.bbj;
         this.bir = ahd;
         this.bis = this.bdk;
         this.bim = -1;
         this.bin = null;
         String var2 = var1.trim();
         boolean var3 = this.bbj == 1 || this.bbj == 4;
         if (this.bbj == 1 && var2.isEmpty()) {
            var2 = this.ll();
         }

         if (!var2.isEmpty()) {
            if (var3) {
               if (var2.endsWith(".")) {
                  this.bim = 76;
               } else if (lj(var2)) {
                  this.bim = 74;
               } else if (var2.equalsIgnoreCase(axg[88])) {
                  this.bim = 75;
               }

               String var4 = this.ke(var2);
               if (this.bim < 0 && !var4.isEmpty()) {
                  if (this.bbj == 4) {
                     if (!var4.equalsIgnoreCase(this.bbk)) {
                        this.bim = 77;
                     }
                  } else {
                     this.bin = var4;
                     int var5 = this.kc(var4);
                     String var6 = var5 >= 0 && var5 < this.bee && this.bec[var5] > 0L
                        ? kf(this.bec[var5], ZoneId.systemDefault(), LocalDate.now(), true)
                        : atq[89];
                     this.bip = axg[48] + var6 + axg[49];
                  }
               }
            } else if (this.bbj == 2) {
               for (BundleSync.Entry var8 : BundleSync.LIST) {
                  if (var8.c && var8.a.equalsIgnoreCase(var2)) {
                     this.bin = var8.a;
                     this.bip = axg[51];
                     break;
                  }
               }
            }

            if (this.bin != null) {
               this.bio = this.ex(axg[46] + this.bin, this.bdk - 40);
               this.biq = this.ex(this.bin, this.bdk - 44 - this.bd(axg[47]));
            }
         }
      }
   }

   private String ll() {

      return !this.bcg && this.bbc == 0 && this.kc(this.adp) >= 0 ? this.adp : "";
   }

   private void lm(int var1, float var2, float var3, float var4, float var5) {

      int var6 = this.bkc;
      if (var6 < this.bka.length) {
         this.bka[var6] = var1;
         this.bkb[var6 * 4] = var2;
         this.bkb[var6 * 4 + 1] = var3;
         this.bkb[var6 * 4 + 2] = var4;
         this.bkb[var6 * 4 + 3] = var5;
         this.bkc = var6 + 1;
      }
   }

   private int ln(int var1, int var2) {

      for (int var3 = this.bkc - 1; var3 >= 0; var3--) {
         float var4 = this.bkb[var3 * 4];
         float var5 = this.bkb[var3 * 4 + 1];
         if ((float)var1 >= var4 && (float)var1 < var4 + this.bkb[var3 * 4 + 2] && (float)var2 >= var5 && (float)var2 < var5 + this.bkb[var3 * 4 + 3]) {
            return this.bka[var3];
         }
      }

      return -1;
   }

   private String lo(int var1) {

      boolean var2 = this.bdn;
      switch (var1) {
         case 0:
            return var2 ? axg[92] : atq[0];
         case 1:
            return var2 ? axg[93] : atq[1];
         case 2:
            return var2 ? axg[95] : atq[2];
         case 3:
            return var2 ? axg[94] : atq[3];
         case 4:
            return BundleSync.ad ? atq[5] : atq[4];
         case 5:
            return atq[6];
         case 6:
            return atq[7];
         case 7:
         case 10:
            return atq[8];
         case 8:
            return atq[9];
         case 9:
         case 12:
         case 15:
            return atq[10];
         case 11:
            if (this.bin != null && this.bim < 0 && this.bbj != 4) {
               return this.bdm ? axg[46].trim() : this.bio;
            }

            return this.bbj == 2 ? atq[12] : (this.bbj == 4 ? axg[86] : atq[11]);
         case 13:
            return this.bdm ? atq[78] : atq[13];
         case 14:
         case 18:
         case 28:
            return atq[14];
         case 16:
            return atq[15];
         case 17:
         default:
            return atq[16];
         case 19:
            return this.kv() >= 0 ? axg[9] : axg[65];
         case 20:
            return axg[10];
         case 21:
            return axg[18];
         case 22:
            return axg[17];
         case 23:
            return axg[11];
         case 24:
            return axg[12];
         case 25:
            return axg[13];
         case 26:
            return bce.contains(this.adp) ? axg[15] : axg[14];
         case 27:
            return axg[16];
      }
   }

   private int lp(int var1) {

      switch (var1) {
         case 0:
         case 3:
         case 22:
         case 28:
            return 5;
         case 1:
         case 6:
         case 8:
         case 9:
         case 13:
         case 17:
         case 27:
         default:
            return 1;
         case 2:
            return 2;
         case 4:
            return BundleSync.ad ? 6 : 1;
         case 5:
         case 14:
            return 0;
         case 7:
         case 16:
            return 4;
         case 10:
            return 3;
         case 11:
            return this.bim >= 0 ? 6 : 0;
         case 12:
         case 15:
            return 2;
         case 18:
            return this.bhh > 0 ? 0 : 6;
         case 19:
            return this.kv() >= 0 ? 1 : 0;
         case 20:
            return this.bhh > 0 ? 4 : 6;
         case 21:
            return 6;
         case 23:
         case 24:
         case 25:
         case 26:
            return -1;
      }
   }

   private int lq(int var1, int var2, int var3) {

      int var4 = this.bd(this.lo(var1)) + 24;
      this.lm(var1, (float)var2, (float)var3, (float)var4, this.bdm ? 22.0F : 24.0F);
      return var2 + var4 + 6;
   }

   private void lr(int var1, int var2) {

      this.bkc = 0;
      this.bkd = false;
      this.bke = false;
      this.bkf = false;
      this.bkg = false;
      this.bku = -1;
      this.bkv = -1;
      this.bkw = 0;
      this.bkx = -1;
      this.bky = -1;
      this.bkz = -1;
      this.blc = -1;
      boolean var3 = this.bdm;
      boolean var4 = this.bdn;
      boolean var5 = this.bbc != 0;
      this.blb = -1;
      int var6 = var2 + this.bdd + (var3 ? 8 : 14);
      int var7 = var1 + 16;
      if (this.bbc == 0) {
         var7 = this.lq(0, var7, var6);
         var7 = this.lq(1, var7, var6);
         this.lq(2, var7, var6);
      } else if (this.bbc == 1) {
         var7 = this.lq(3, var7, var6);
         this.lq(4, var7, var6);
      } else {
         this.lq(4, var7, var6);
      }

      boolean var8 = this.bbc == 2 && this.bdt == 0;
      if (!var8) {
         this.bkg = true;
         this.bkt = (float)this.bdk;
         this.bkr = (float)(var1 + this.bdj);
         this.bks = (float)var6;
      }

      int var9 = var2 + this.bdg;
      int var10 = this.bdh;
      if (jp() && !var8) {
         this.lt();
         int var11 = var3 ? 28 : 32;
         int var12 = this.bd(axg[17]) + 24;
         int var13 = 14 + this.bd(bcu) + this.bd(this.bda) + 12 + var12 + 8 + this.bd(axg[37]) + 12 + 12;
         this.blg = var13;
         this.blh = var11;
         this.ble = var1 + 16 + (this.bdi - var13) / 2;
         this.blf = var9 + var10 - var11 - (var3 ? 6 : 10);
         int var14 = this.ble + 14 + this.bd(bcu) + this.bd(this.bda) + 12;
         this.lm(22, (float)var14, (float)this.blf + (float)(var11 - 20) / 2.0F, (float)var12, 20.0F);
      }

      if (var8) {
         if (!BundleSync.ad) {
            int var36 = this.bd(atq[16]) + 28;
            int var38 = var9 + var10 / 2 - 14;
            this.lm(17, (float)var1 + (float)(this.and - var36) / 2.0F, (float)(var38 + 40), (float)var36, 22.0F);
         }
      } else {
         int var35 = var1 + this.bdj;
         float var37 = (float)(var35 + 16);
         float var39 = (float)(this.bdk - 32);
         float var40 = (var39 - 6.0F) / 2.0F;
         int var15 = var9 + (var3 ? 34 : 52);
         int var16 = var3 ? 20 : 26;
         int var17 = var15 + var16 + (var3 ? 4 : 8);
         int var18 = var3 ? 20 : 24;
         int var19 = var17 + var18 + (var3 ? 3 : 6);
         int var20 = var3 ? 3 : 10;
         float var21 = (var39 - 8.0F) * 0.64F;
         if (!this.ls(var9, var10, var37, var39, var40, var3)) {
            int var22 = var9 + var10 - 8;
            byte var23 = -1;
            if (var5) {
               BundleSync.Entry var44 = this.jx();
               if (var44 != null) {
                  if (this.bbl) {
                     this.bkz = var15 - 4;
                     this.bla = var3 ? 60 : 68;
                     float var48 = (float)(this.bkz + this.bla - (var3 ? 28 : 30));
                     this.lm(9, var37, var48, var40, 22.0F);
                     this.lm(10, var37 + var40 + 6.0F, var48, var40, 22.0F);
                     this.bku = this.bkz + this.bla + var20 + 2;
                  } else {
                     this.lm(5, var37, (float)var15, var39, (float)var16);
                     if (var44.c) {
                        this.lm(27, var37, (float)var17, var21, (float)var18);
                        this.lm(8, var37 + var21 + 8.0F, (float)var17, var39 - var21 - 8.0F, (float)var18);
                     } else {
                        this.lm(27, var37, (float)var17, var39, (float)var18);
                     }

                     this.blb = var19;
                     this.bku = var19 + var20;
                  }

                  this.bky = var3 ? -1 : var9 + var10 - 12 - 22;
               }
            } else {
               if (this.bcg) {
                  var23 = 1;
                  if (this.kv() < 0) {
                     this.lm(19, var37, (float)var15, var39, (float)var16);
                     this.blb = var15 + var16 + (var3 ? 6 : 10);
                     this.bku = this.blb + var20;
                  } else {
                     this.lm(18, var37, (float)var15, var39, (float)var16);
                     this.lm(19, var37, (float)var17, var21, (float)var18);
                     this.lm(20, var37 + var21 + 8.0F, (float)var17, var39 - var21 - 8.0F, (float)var18);
                     this.blb = var19;
                     this.bku = var19 + var20;
                  }

                  if (!var3 && !this.bbn) {
                     this.bky = var9 + var10 - 12 - 22;
                     var22 = this.bky - 12;
                  }
               } else {
                  int var24 = this.kb();
                  if (var24 < 0) {
                     return;
                  }

                  var23 = 0;
                  if (this.bbl) {
                     this.bkz = var15 - 4;
                     this.bla = var3 ? 60 : 68;
                     float var25 = (float)(this.bkz + this.bla - (var3 ? 28 : 30));
                     this.lm(9, var37, var25, var40, 22.0F);
                     this.lm(10, var37 + var40 + 6.0F, var25, var40, 22.0F);
                     this.bku = this.bkz + this.bla + var20 + 2;
                  } else {
                     boolean var45 = this.adp.equals(bcd) && this.bga[0] == 0;
                     this.lm(var45 ? 21 : 5, var37, (float)var15, var39, (float)var16);
                     this.lm(6, var37, (float)var17, var21, (float)var18);
                     this.lm(7, var37 + var21 + 8.0F, (float)var17, var39 - var21 - 8.0F, (float)var18);
                     this.blb = var19;
                     this.bku = var19 + var20;
                     if (!this.bbn) {
                        this.bkx = var9 + var10 - (var3 ? 3 : 8) - (var3 ? 18 : 22);
                        var22 = this.bkx - (var3 ? 3 : 10);
                        float var26 = var37 - 6.0F;

                        for (int var30 : bjz) {
                           if (var30 != 25 || !var4) {
                              int var31 = this.bd(this.lo(var30)) + 14;
                              this.lm(var30, var26, (float)this.bkx, (float)var31, var3 ? 18.0F : 22.0F);
                              var26 += (float)(var31 + 2);
                           }
                        }
                     }
                  }
               }

               this.bkv = this.bku + (var3 ? 12 : 14);
               if (this.bku > 0 && this.blb < 0 && !this.bbl) {
                  this.blb = this.bku - var20;
               }

               if (this.bbn) {
                  this.blc = this.bku + 15;
                  this.bld = var9 + var10 - 8;
                  String var43 = atq[37];
                  float var47 = (float)this.bd(var43);
                  this.bkf = true;
                  this.bko = var37 + var39 - var47;
                  this.bkp = (float)(this.bku - 2);
                  this.bkq = var47;
               } else {
                  int var42 = !this.bbl && !var3 ? 3 : (var3 ? 1 : 2);
                  int var46 = Math.max(0, Math.floorDiv(var22 - this.bkv - 15, 19) + 1);
                  this.bkw = Math.min(var42, var46);
                  this.li(var23, this.bkw, Math.round(var39));
                  if (this.bie != null && this.bga[var23] > 0) {
                     this.bkf = true;
                     this.bko = var37 + (float)this.bia;
                     this.bkp = (float)(this.bkv + this.bib * 19);
                     this.bkq = (float)this.bic;
                  }
               }
            }
         }
      }
   }

   private boolean ls(int var1, int var2, float var3, float var4, float var5, boolean var6) {

      if (this.bbj == 1 || this.bbj == 2 || this.bbj == 4) {
         this.lk();
         this.bkd = true;
         this.bkh = var3;
         this.bki = (float)(var1 + (var6 ? 50 : 64));
         this.bkj = var4;
         this.bkk = var6 ? 20.0F : 24.0F;
         if (this.bbj == 2) {
            boolean var9 = this.bin != null;
            this.bke = true;
            this.bkl = var3;
            this.bkm = (float)(var1 + (var6 ? 76 : 116) + (var9 ? (var6 ? 12 : 14) : 0));
            this.bkn = var4;
         }

         if (var6) {
            this.lm(12, var3, (float)(var1 + var2 - 30), var5, 22.0F);
            this.lm(11, var3 + var5 + 6.0F, (float)(var1 + var2 - 30), var5, 22.0F);
         } else {
            this.lm(11, var3, (float)(var1 + var2 - 62), var4, 24.0F);
            this.lm(12, var3, (float)(var1 + var2 - 32), var4, 20.0F);
         }

         return true;
      } else if (this.bbj == 3) {
         this.lk();
         this.bkd = true;
         this.bkh = var3;
         this.bki = (float)(var1 + (var6 ? 40 : 56));
         this.bkj = var4;
         this.bkk = var6 ? 20.0F : 24.0F;
         this.bke = true;
         this.bkl = var3;
         this.bkm = (float)(var1 + (var6 ? 66 : 100));
         this.bkn = var4;
         if (this.bbl) {
            this.bkz = var1 + var2 - (var6 ? 64 : 70);
            this.bla = var6 ? 58 : 64;
            float var7 = (float)(this.bkz + this.bla - 27);
            this.lm(9, var3, var7, var5, 20.0F);
            this.lm(10, var3 + var5 + 6.0F, var7, var5, 20.0F);
         } else if (var6) {
            this.lm(13, var3, (float)(var1 + var2 - 56), var5, 20.0F);
            this.lm(16, var3 + var5 + 6.0F, (float)(var1 + var2 - 56), var5, 20.0F);
            this.lm(15, var3, (float)(var1 + var2 - 30), var5, 22.0F);
            this.lm(14, var3 + var5 + 6.0F, (float)(var1 + var2 - 30), var5, 22.0F);
         } else {
            float var8 = (float)(var1 + var2 - 88);
            this.lm(13, var3, var8, var4, 20.0F);
            this.lm(14, var3, var8 + 26.0F, var4, 24.0F);
            this.lm(15, var3, var8 + 56.0F, var5, 20.0F);
            this.lm(16, var3 + var5 + 6.0F, var8 + 56.0F, var5, 20.0F);
         }

         return true;
      } else {
         return false;
      }
   }

   private void lt() {

      if (this.bdb != bct || this.bdc != ahd) {
         this.bdb = bct;
         this.bdc = ahd;
         int var1 = this.bdi - 40 - this.bd(bcu) - this.bd(axg[17]) - 24 - this.bd(axg[37]) - 40;
         this.bda = this.ex(bct, Math.max(20, var1));
      }
   }

   private void lu(DrawContext var1, int var2, int var3, int var4, int var5, int var6, int var7) {

      boolean var8 = this.bbc != 0;
      this.le();
      this.lr(var2, var3);
      boolean var9 = this.bbc == 2 && this.bdt == 0;
      this.gq(var1, abn[2], (float)(var2 + 22), (float)(var3 + Math.round((float)this.bdd * 0.62F) - 10), 1.5F, amm, false);
      this.jw(var1, var2, var3, var6, var7);
      this.fy(var1, var2, var3, var6, var7);
      ev(
         var1,
         (float)var2 + 1.0F,
         (float)(var3 + this.bdd),
         (float)(var2 + var4) - 1.0F,
         (float)(var3 + this.bdd) + 1.0F / (float)Math.max(1, ahd),
         850111932 ^ 559174211
      );
      if (this.bkg) {
         this.lw(var1, var6, var7);
      }

      if (var9) {
         this.mj(var1, var2, var3, var4);
      } else {
         this.md(var1, var2, var3, var8, var6, var7);
         if (this.adp != this.bbx || this.bbd != this.bby || this.bcg != this.bbz || this.bbc != this.bcb || this.bbj != this.bcc || this.bbn != this.bca) {
            this.bbx = this.adp;
            this.bby = this.bbd;
            this.bbz = this.bcg;
            this.bcb = this.bbc;
            this.bcc = this.bbj;
            this.bca = this.bbn;
            this.bbw = SyncController.x ? 1.0F : 0.25F;
         }

         if (this.bbw < 1.0F) {
            this.bbw = this.bbw + (1.0F - this.bbw) * (1.0F - (float)Math.exp((double)(-21.0F * this.ajg)));
            this.bbw = this.bbw > 0.996F ? 1.0F : this.bbw;
         }

         float var10 = agi;
         agi = var10 * this.bbw;

         try {
            this.ml(var1, var2, var3, var8, var6, var7);
         } finally {
            agi = var10;
         }

         if (jp()) {
            this.mu(var1);
         }
      }

      int var21 = this.ln(var6, var7);

      for (int var11 = 0; var11 < this.bkc; var11++) {
         int var12 = this.bka[var11];
         int var13 = this.lp(var12);
         float var14 = this.bkb[var11 * 4];
         float var15 = this.bkb[var11 * 4 + 1];
         float var16 = this.bkb[var11 * 4 + 2];
         float var17 = this.bkb[var11 * 4 + 3];
         if (var13 < 0) {
            this.lv(var1, var14, var15, var16, var17, this.lo(var12), bjy[var12], var21 == var12);
         } else {
            boolean var18 = var12 == 0 && this.bbj == 1 || var12 == 3 && this.bbj == 2;
            this.fz(var1, var14, var15, var16, var17, this.lo(var12), var13, bjy[var12], var21 == var12, var18);
         }
      }

      this.mv(var1, var2, var3, var4, var5, var8, var9, var6, var7);
   }

   private void lv(DrawContext var1, float var2, float var3, float var4, float var5, String var6, Object var7, boolean var8) {

      this.fz(var1, var2, var3, var4, var5, var6, 2, var7, var8, false);
   }

   private void lw(DrawContext var1, int var2, int var3) {

      float var4 = this.bkr;
      float var5 = this.bks;
      float var6 = this.bkt;
      float var7 = this.bdm ? 22.0F : 24.0F;
      float var8 = 8.0F;
      boolean var9 = this.bci;
      boolean var10 = (float)var2 >= var4 && (float)var2 < var4 + var6 && (float)var3 >= var5 && (float)var3 < var5 + var7;
      float var11 = this.cw(bjy[29], var10 && !var9);
      bt(var1, var4, var5, var6, var7, var8, 918816229 ^ 247727589, true, true, true, true);
      eu(
         var1,
         var4,
         var5,
         var6,
         var7,
         var8,
         var9 ? ams : (var11 <= 0.0F ? 1351350658 ^ 1249117821 : cq(-1691486796 ^ -2116941237, -1960866317 ^ -1562349044, var11))
      );
      if (var9) {
         float var12 = fs();
         int var13 = o(yd, 77);
         eu(var1, var4 - var12, var5 - var12, var6 + 2.0F * var12, var7 + 2.0F * var12, var8 + var12, var13);
         eu(var1, var4 - 2.0F * var12, var5 - 2.0F * var12, var6 + 4.0F * var12, var7 + 4.0F * var12, var8 + 2.0F * var12, var13);
      }

      int var21 = Math.round(var4) + 12;
      int var22 = ft(var5, var7);
      String var14 = this.bch;
      String var15 = var14.isEmpty() ? null : this.lx();
      int var16 = var15 == null ? 0 : this.bd(var15) + 6;
      int var17 = Math.round(var6) - 24 - var16;
      boolean var18 = var9 && System.currentTimeMillis() % 1000L < 500L;
      if (var14.isEmpty()) {
         this.ay(var1, this.bdn ? axg[31].trim() : this.bfi, var21, var22, amo, false);
         if (var18) {
            ev(var1, (float)var21 - 0.5F, var5 + 4.5F, (float)var21 + 0.5F, var5 + var7 - 4.5F, amw);
         }
      } else {
         int var19 = this.bd(var14);
         int var20 = Math.max(0, var19 + 3 - var17);
         nr(var1, var21, Math.round(var5) + 2, var21 + Math.max(0, var17), Math.round(var5 + var7) - 2);
         this.ay(var1, var14, var21 - var20, var22, amm, false);
         if (var18) {
            ev(var1, (float)(var21 - var20 + var19) + 1.0F, var5 + 4.5F, (float)(var21 - var20 + var19) + 2.0F, var5 + var7 - 4.5F, amw);
         }

         var1.disableScissor();
         if (var15 != null) {
            this.ly(var1, var15, Math.round(var4 + var6) - 12, var22, amo);
         }
      }
   }

   private String lx() {

      if (this.blp != this.bex) {
         this.blp = this.bex;
         String var1 = this.bex;
         int var2 = var1.lastIndexOf(axg[33]);
         this.blq = var2 > 0 ? var1.substring(0, var2) : var1;
      }

      return this.blq;
   }

   private void ly(DrawContext var1, String var2, int var3, int var4, int var5) {

      this.ay(var1, var2, var3 - this.bd(var2), var4, var5, false);
   }

   private int lz(boolean var1, int var2) {

      int var3 = this.bdi;
      if (!var1) {
         return var2 == 1 ? var3 - (this.bdn ? 92 : 116) : var3 - 12;
      } else if (!this.bdn && !this.bdm) {
         return var2 == 1 ? var3 - 116 : (var2 == 2 ? var3 - 60 : var3 - 12);
      } else {
         return var2 == 1 ? var3 - 60 : var3 - 12;
      }
   }

   private int ma(boolean var1) {

      return var1 ? (!this.bdn && !this.bdm ? 4 : 3) : 3;
   }

   private String mb(boolean var1, int var2) {

      if (var2 == 0) {
         return atq[17];
      } else if (!var1) {
         return var2 == 1 ? atq[18] : atq[19];
      } else {
         return var2 == 1 ? atq[20] : (var2 == 2 ? atq[21] : axg[3]);
      }
   }

   private int mc(int var1, int var2, int var3, int var4) {

      int var5 = var2 + this.bdg;
      int var6 = var1 + 16;
      if (var4 >= var5 && var4 < var5 + 22) {
         boolean var7 = this.bbc != 0;

         for (int var8 = 0; var8 < this.ma(var7); var8++) {
            String var9 = this.mb(var7, var8);
            int var10 = var8 == 0 ? var6 + 12 : var6 + this.lz(var7, var8) - this.bd(var9);
            if (var3 >= var10 - 4 && var3 < var10 + this.bd(var9) + 4) {
               return var8;
            }
         }

         return -1;
      } else {
         return -1;
      }
   }

   private void md(DrawContext var1, int var2, int var3, boolean var4, int var5, int var6) {

      int var7 = var2 + 16;
      int var8 = var3 + this.bdg;
      int var9 = this.bdi;
      int var10 = var8 + this.jr();
      int var11 = Math.max(0, this.bes + 6 - (this.jr() - 26));
      this.bbp = this.dc(this.bbp, this.ady, var11, 25.0F);
      this.bbt = this.de(this.bbp);
      this.bbq = this.df(this.bbp);
      int var12 = Math.round((float)var8 + 11.0F - 3.9F) - 1;
      int var13 = var4 ? bck : bcj;
      int var14 = this.mc(var2, var3, var5, var6);

      for (int var15 = 0; var15 < this.ma(var4); var15++) {
         String var16 = this.mb(var4, var15);
         int var17 = var15 == 0 ? var7 + 12 : var7 + this.lz(var4, var15) - this.bd(var16);
         this.ay(var1, var16, var17, var12, var15 == var13 ? amm : (var15 == var14 ? amn : amo), false);
         if (var15 == var13) {
            bt(var1, (float)var17, (float)(var8 + 22) - 1.5F, (float)this.bd(var16), 1.5F, 0.75F, yd, true, true, true, true);
         }
      }

      ev(var1, (float)var7, (float)(var8 + 22), (float)(var7 + var9), (float)(var8 + 22) + 1.0F / (float)Math.max(1, ahd), 1110259940 ^ 1372768027);
      int var26 = this.bev;
      if (var4 && this.bds == 0 && this.bch.isEmpty()) {
         String var28 = BundleSync.ad ? atq[63] : atq[59];
         String var30 = BundleSync.ad ? null : atq[60];
         int var31 = var8 + 22 + (this.bdh - 22) / 2;
         this.ay(var1, var28, var7 + (var9 - this.bd(var28)) / 2, var31 - 11, amn, false);
         if (var30 != null) {
            this.ay(var1, var30, var7 + (var9 - this.bd(var30)) / 2, var31 + 2, amo, false);
         }
      } else {
         int var27 = this.kp(var2, var3, var5, var6);
         nr(var1, var7 - 2, var8 + 22 + 1, var7 + var9 + 2, var10);
         boolean var29 = dh(var1, this.bbq);
         if (this.bbv < 1.0F) {
            this.bbv = this.bbv + (1.0F - this.bbv) * (SyncController.x ? 1.0F : 1.0F - (float)Math.exp((double)(-21.0F * this.ajg)));
            this.bbv = this.bbv > 0.996F ? 1.0F : this.bbv;
         }

         float var18 = agi;

         try {
            agi = var18 * this.bbv;
            this.mf(var1, var2, var3, var4, var27, var10);
            agi = var18;
            int var19 = var8 + 26 + this.bes - this.bbt;
            if (!this.bch.isEmpty() && var26 == 0) {
               String var33 = axg[36];
               int var35 = var8 + 22 + (this.bdh - 22) / 2 - 6;
               int var36 = this.bd(var33) + this.bd(this.bey);
               this.ay(var1, var33, var7 + (var9 - var36) / 2, var35, amn, false);
               this.ay(var1, this.bey, var7 + (var9 - var36) / 2 + this.bd(var33), var35, amm, false);
            } else if (!this.bch.isEmpty() && this.bet > 0) {
               this.ay(var1, this.bew, var7 + 12, var19 + 8, amp, false);
            } else if (!var4 && var26 == 0) {
               String var20 = atq[61];
               String var21 = atq[62];
               int var22 = var19 + Math.max(8, (var10 - var19) / 2 - 12);
               this.ay(var1, var20, var7 + (var9 - this.bd(var20)) / 2, var22, amn, false);
               this.ay(var1, var21, var7 + (var9 - this.bd(var21)) / 2, var22 + 13, amo, false);
            }
         } finally {
            agi = var18;
            di(var1, var29);
            var1.disableScissor();
         }

         int var32 = this.bes + 6;
         int var34 = var10 - var8 - 26;
         if (var32 > var34) {
            gf(
               var1,
               (float)(var7 + var9) + 5.0F,
               (float)(var8 + 26 + 2),
               (float)(var10 - var8 - 26 - 6),
               (float)var34 / (float)var32,
               this.bbp / (float)Math.max(1, var32 - var34)
            );
         }
      }
   }

   private void me(DrawContext var1, int var2, int var3, int var4, int var5, int var6, boolean var7, boolean var8) {

      boolean var9 = var8 && !var7;
      float var10 = var6 < blo.length ? this.cw(blo[var6], var9) : (var9 ? 1.0F : 0.0F);
      if (var7) {
         bt(var1, (float)var2, (float)var3, (float)var4, (float)var5, 6.0F, -1824730579 ^ -2067583534, true, true, true, true);
         eu(var1, (float)var2, (float)var3, (float)var4, (float)var5, 6.0F, -2105448336 ^ -1770088561);
      } else if (var10 > 0.01F) {
         bt(var1, (float)var2, (float)var3, (float)var4, (float)var5, 6.0F, dk(-1136205297 ^ -1279713808, var10), true, true, true, true);
      }
   }

   private void mf(DrawContext var1, int var2, int var3, boolean var4, int var5, int var6) {

      assert var1 != null
         && this.ado != null
         && this.bdx != null
         && this.bdy != null
         && this.bfk != null
         && blo != null
         && blo.length == 48
         && atq != null
         && atq.length > 92
         && this.aiw != null
         && abp != null
         && abn != null
         && abn.length == 3
         && axg != null
         && axg.length > 95
         && this.bek != null
         && this.bem != null : "cfgRowsDra" + "w: ba" + "d state";

      int var7 = var2 + 16;
      int var8 = this.bdi;
      int var9 = var3 + this.bdg;
      int var10 = var9 + 26 - this.bbt;
      int var11 = this.kq();
      if (var4) {
         this.ks(var8);
      }

      int var12 = this.lz(false, 1) - 34 - 12 - 12;
      Object var13 = null;

      try {
         for (int var14 = 0; var14 < this.ber; var14++) {
            int var15 = var10 + this.bem[var14];
            int var16 = this.ben[var14];
            if (var15 + var16 > var9 + 22 && var15 < var6) {
               int var17 = this.bek[var14];
               if (var17 != 1 && var17 != 2) {
                  this.me(var1, var7, var15, var8, var16, var14, var14 == var11, var14 == var5);
                  int var18 = Math.round((float)var15 + (float)var16 * 0.5F - 3.9F);
                  if (var17 == 0) {
                     this.mh(var1, var7, var15, var18, var8);
                  } else {
                     int var19 = this.bel[var14];
                     if (!var4) {
                        String var20 = this.kr(var19, var12);
                        int var21 = this.mg(var1, var14, var20, this.ado.get(var19), var7 + 12, var18);
                        if (!bcd.isEmpty() && bcd.equals(this.ado.get(var19))) {
                           this.gp(var1, var21 + 7, var15 + (var16 - 11) / 2, atq[22], amw, amq, 0);
                        }

                        if (var19 < this.bee) {
                           int var22 = var14 == var11 ? amm : amn;
                           this.gw(var1, this.bdx[var19], (float)(var7 + this.lz(false, 1)), var18, var22);
                           this.ly(var1, this.bdy[var19], var7 + this.lz(false, 2), var18, var22);
                        }
                     } else {
                        var13 = this.bdu.get(var19);
                        this.mi(var1, (BundleSync.Entry)var13, var19, var14, var7, var15, var18, var16);
                     }
                  }
               } else {
                  this.gg(var1, var17 == 1 ? axg[1] : axg[2], (float)(var7 + 12), (float)var15 + 8.3F, amo);
               }
            }
         }
      } catch (RuntimeException var23) {
         throw var23;
      }
   }

   private int mg(DrawContext var1, int var2, String var3, String var4, int var5, int var6) {

      String var7 = var2 < this.beo.length ? this.beo[var2] : null;
      if (var7 != null && (var3 == var4 || var3.equals(var4))) {
         this.ay(var1, var7, var5, var6, amm, false);
         int var8 = var5 + this.bd(var7);
         this.ay(var1, this.bep[var2], var8, var6, amw, false);
         int var9 = var8 + this.bd(this.bep[var2]);
         this.ay(var1, this.beq[var2], var9, var6, amm, false);
         return var9 + this.bd(this.beq[var2]);
      } else {
         this.ay(var1, var3, var5, var6, amm, false);
         return var5 + this.bd(var3);
      }
   }

   private void mh(DrawContext var1, int var2, int var3, int var4, int var5) {

      String var6 = axg[0];
      this.ay(var1, var6, var2 + 12, var4, amm, false);
      int var7 = var2 + 12 + this.bd(var6) + 8;
      int var8 = var2 + this.lz(false, 1) - this.bd(this.bhj) - 10 - var7;
      if (this.blr == null || this.bls != ahd || this.blt != var8) {
         this.bls = ahd;
         this.blt = var8;
         this.blr = this.ex(this.bhi, Math.max(10, var8));
      }

      this.ay(var1, this.blr, var7, var4, amo, false);
      this.gw(var1, this.bhj, (float)(var2 + this.lz(false, 1)), var4, amn);
      this.gw(var1, this.bhk, (float)(var2 + this.lz(false, 2)), var4, this.bhh > 0 ? amw : amo);
      ev(
         var1,
         (float)var2,
         (float)(var3 + this.bdl) + 4.0F,
         (float)(var2 + var5),
         (float)(var3 + this.bdl) + 4.0F + 1.0F / (float)Math.max(1, ahd),
         -289876403 ^ -45667918
      );
   }

   private void mi(DrawContext var1, BundleSync.Entry var2, int var3, int var4, int var5, int var6, int var7, int var8) {

      int var9 = this.gh(atq[23]) + 10;
      int var10 = this.bd(atq[24]);
      int var11 = var5 + this.lz(true, 1);
      String var12 = var3 < this.bfp.length ? this.bfp[var3] : null;
      if (var12 == null) {
         var12 = this.ex(var2.b, var2.c ? 100 - var10 - 3 : 100);
         if (var3 < this.bfp.length) {
            this.bfp[var3] = var12;
         }
      }

      String var13 = var3 < this.bfo.length ? this.bfo[var3] : null;
      if (var13 == null) {
         int var14 = var11 - (var2.c ? var10 + 3 : 0) - this.bd(var12) - 10;
         var13 = this.ex(var2.a, var14 - (var5 + 12) - (var2.d ? var9 + 6 : 0));
         if (var3 < this.bfo.length) {
            this.bfo[var3] = var13;
         }
      }

      int var15 = this.mg(var1, var4, var13, var2.a, var5 + 12, var7);
      if (var2.d) {
         this.gp(var1, var15 + 6, var6 + (var8 - 11) / 2, atq[23], amn, -934890815 ^ -625390274, -6586812 ^ -446398021);
      }

      if (var2.c) {
         this.ly(var1, atq[24], var11, var7, amo);
         this.ly(var1, var12, var11 - var10 - 3, var7, amn);
      } else {
         this.ly(var1, var12, var11, var7, abp[0].equals(var2.b) ? amo : amn);
      }

      this.gw(var1, gy(var2.f), (float)(var5 + this.lz(true, 2)), var7, amn);
      if (!this.bdn && !this.bdm && var3 < this.bfg.length) {
         this.ly(var1, this.bfg[var3], var5 + this.lz(true, 3), var7, amn);
      }
   }

   private void mj(DrawContext var1, int var2, int var3, int var4) {

      int var5 = var3 + this.bdg;
      int var6 = this.bdh;
      ge(var1, (float)(var2 + 16), (float)var5, (float)(var4 - 32), (float)var6);
      int var7 = var2 + var4 / 2;
      int var8 = var5 + var6 / 2 - 14;
      String var9 = BundleSync.ad ? atq[63] : atq[56];
      this.gq(var1, var9, (float)var7 - (float)this.bd(var9) * 0.75F, (float)(var8 - 10), 1.5F, amm, false);
      if (!BundleSync.ad) {
         String var10 = atq[57];
         String var11 = atq[58];
         this.ay(var1, var10, var7 - this.bd(var10) / 2, var8 + 9, amn, false);
         this.ay(var1, var11, var7 - this.bd(var11) / 2, var8 + 21, amn, false);
      }
   }

   private void mk(DrawContext var1, String var2, int var3, int var4, int var5) {

      if (var2 != this.bly || ahd != this.bma || var5 != this.bmb) {
         this.bly = var2;
         this.bma = ahd;
         this.bmb = var5;
         this.blz = this.ex(var2, (int)((float)var5 / 1.5F));
      }

      this.gq(var1, this.blz, (float)var3, (float)var4, 1.5F, amm, false);
   }

   private void ml(DrawContext var1, int var2, int var3, boolean var4, int var5, int var6) {

      int var7 = var2 + this.bdj;
      int var8 = var3 + this.bdg;
      int var9 = this.bdh;
      ge(var1, (float)var7, (float)var8, (float)this.bdk, (float)var9);
      int var10 = var7 + 16;
      int var11 = this.bdk - 32;
      boolean var12 = this.bdm;
      int var13 = var8 + (var12 ? 10 : 15);
      int var14 = var8 + (var12 ? 23 : 33);
      if (this.blb > 0 && this.bbj == 0) {
         ev(var1, (float)var10, (float)this.blb, (float)(var10 + var11), (float)this.blb + 1.0F / (float)Math.max(1, ahd), 416683492 ^ 187296283);
      }

      if (this.bkx > 0 && this.bbj == 0 && !this.bbl && !var12) {
         ev(var1, (float)var10, (float)(this.bkx - 6), (float)(var10 + var11), (float)(this.bkx - 6) + 1.0F / (float)Math.max(1, ahd), 1647612042 ^ 1909157749);
      }

      if (this.bbj == 1 || this.bbj == 2 || this.bbj == 4) {
         this.mr(var1, var10, var8, var11, var5, var6);
      } else if (this.bbj == 3) {
         this.ms(var1, var10, var8, var11, var9, var5, var6);
      } else if (var4) {
         BundleSync.Entry var21 = this.jx();
         if (var21 == null) {
            this.ay(var1, atq[25], var10, var8 + 12, amn, false);
            this.ay(var1, atq[26], var10, var8 + 24, amo, false);
         } else {
            int var24 = var21.d ? this.gh(atq[23]) + 10 : 0;
            this.mk(var1, var21.a, var10, var13, var11 - (var24 > 0 ? var24 + 8 : 0));
            if (var21.d) {
               this.gp(var1, var10 + var11 - var24, var13 + 2, atq[23], amn, 67487590 ^ 385497241, -980723424 ^ -546003233);
            }

            this.mo(var1, var21, var10, var14, var11);
            if (this.bbl) {
               this.mn(var1, var7, var10);
            }

            int var26 = this.bku;
            this.gg(var1, axg[19], (float)var10, (float)var26 + 1.2F, amo);
            this.ay(var1, axg[71], var10, var26 + 16, amn, false);
            this.ay(var1, axg[72], var10, var26 + 28, amo, false);
            if (this.bky > 0) {
               ev(
                  var1,
                  (float)var10,
                  (float)(this.bky - 8),
                  (float)(var10 + var11),
                  (float)(this.bky - 8) + 1.0F / (float)Math.max(1, ahd),
                  1961268189 ^ 1729719330
               );
               int var28 = this.bdu.indexOf(var21);
               String var19 = var28 >= 0 && var28 < this.bfg.length ? this.bfg[var28] : atq[89];
               this.ay(var1, axg[73], var10, this.bky, amo, false);
               this.ay(var1, var19, var10 + this.bd(axg[73]), this.bky, amo, false);
               this.ay(var1, atq[77], var10, this.bky + 12, amo, false);
            }
         }
      } else if (this.bcg) {
         this.mk(var1, axg[0], var10, var13, var11);
         boolean var20 = this.kv() >= 0;
         if (var20) {
            String var22 = axg[24];
            this.ay(var1, var22, var10, var14, amn, false);
            int var25 = var10 + this.bd(var22);
            this.ay(var1, bcd, var25, var14, amm, false);
            if (!var12) {
               int var27 = var25 + this.bd(bcd);
               this.ay(var1, atq[29], var27, var14, amn, false);
               this.ay(var1, this.bhj, var27 + this.bd(atq[29]), var14, amn, false);
            }
         } else {
            this.ay(var1, this.bhj, var10, var14, amn, false);
         }

         int var23 = this.bku;
         if (!var20) {
            this.gg(var1, axg[62], (float)var10, (float)var23 + 1.2F, amo);
            this.ay(var1, axg[63], var10, var23 + 16, amn, false);
            this.ay(var1, axg[64], var10, var23 + 28, amn, false);
         } else {
            this.mm(var1, 1, this.bhl, var10, var11, var5, var6);
         }

         if (this.bky > 0 && var20) {
            ev(var1, (float)var10, (float)(this.bky - 8), (float)(var10 + var11), (float)(this.bky - 8) + 1.0F / (float)Math.max(1, ahd), 923149277 ^ 620354594);
            this.ay(var1, axg[25], var10, this.bky, amo, false);
            this.ay(var1, axg[26], var10, this.bky + 12, amo, false);
            this.ay(var1, bcd, var10 + this.bd(axg[26]), this.bky + 12, amo, false);
         }
      } else {
         int var15 = this.kb();
         if (var15 < 0) {
            this.ay(var1, atq[25], var10, var8 + 12, amn, false);
            this.ay(var1, atq[26], var10, var8 + 24, amo, false);
         } else {
            String var16 = this.ado.get(var15);
            boolean var17 = var16.equals(bcd);
            int var18 = var17 ? this.gh(atq[22]) + 10 : 0;
            this.mk(var1, var16, var10, var13, var11 - (var18 > 0 ? var18 + 8 : 0));
            if (var17) {
               this.gp(var1, var10 + var11 - var18, var13 + 2, atq[22], amw, amq, 0);
            }

            if (var15 < this.bee) {
               this.ay(var1, this.bdz[var15], var10, var14, amo, false);
            }

            if (this.bbl) {
               this.mn(var1, var7, var10);
            }

            this.mm(var1, 0, axg[19], var10, var11, var5, var6);
         }
      }
   }

   private void mm(DrawContext var1, int var2, String var3, int var4, int var5, int var6, int var7) {

      int var8 = this.bku;
      boolean var9 = this.bkf && (float)var6 >= this.bko && (float)var6 < this.bko + this.bkq && (float)var7 >= this.bkp && (float)var7 < this.bkp + 16.0F;
      String[] var10 = this.bgf[var2];
      int var11 = this.gh(var3);
      int var12 = var10[0] != null ? this.bd(var10[0]) : 0;
      int var13 = var10[1] != null ? this.bd(var10[1]) + 7 : 0;
      int var14 = var10[2] != null ? this.bd(var10[2]) + 7 : 0;
      int var15 = var5 - var11 - 8;
      boolean var16 = !this.bbn && this.bga[var2] > 0;
      int var17 = !var16 ? 0 : (var12 + var13 + var14 <= var15 ? 3 : (var12 + var13 <= var15 ? 2 : (var12 <= var15 ? 1 : 0)));
      int var18 = this.bbn ? this.bd(atq[37]) + 8 : (var17 == 3 ? var12 + var13 + var14 + 8 : (var17 == 2 ? var12 + var13 + 8 : (var17 == 1 ? var12 + 8 : 0)));
      if (var3 != this.blv || var5 - var18 != this.blw || ahd != this.blx) {
         this.blv = var3;
         this.blw = var5 - var18;
         this.blx = ahd;
         this.blu = this.ex(gi(var3), Math.max(20, var5 - var18));
      }

      this.gg(var1, this.blu, (float)var4, (float)var8 + 1.2F, amo);
      if (this.bbn) {
         this.ay(var1, atq[37], Math.round(this.bko), var8, var9 ? amm : amw, false);
         this.mq(var1, var2, var4, var5);
      } else if (var2 == 0 && this.bhc) {
         this.ay(var1, axg[97], var4, var8 + 16, -629236501 ^ 630122091, false);
      } else if (this.bga[var2] == 0) {
         this.ay(var1, var2 == 0 ? axg[27] : axg[29], var4, var8 + 16, amn, false);
         this.ay(var1, var2 == 0 ? axg[28] : axg[30], var4, var8 + 28, amn, false);
      } else {
         int var19 = var4 + var5;
         if (var17 >= 3 && var10[2] != null) {
            var19 -= this.bd(var10[2]);
            this.ay(var1, var10[2], var19, var8, amn, false);
            var19 -= 7;
         }

         if (var17 >= 2 && var10[1] != null) {
            var19 -= this.bd(var10[1]);
            this.ay(var1, var10[1], var19, var8, amn, false);
            var19 -= 7;
         }

         if (var17 >= 1 && var10[0] != null) {
            this.ay(var1, var10[0], var19 - this.bd(var10[0]), var8, amw, false);
         }

         this.mp(var1, var2, var4, this.bkv);
         if (this.bkf && this.bie != null) {
            this.ay(var1, this.bie, Math.round(this.bko) + 3, Math.round(this.bkp + 8.0F - 3.9F), var9 ? amm : amw, false);
         }
      }
   }

   private void mn(DrawContext var1, int var2, int var3) {

      float var4 = (float)this.bkz;
      bt(var1, (float)var2 + 8.0F, var4, (float)this.bdk - 16.0F, (float)this.bla, 8.0F, 1664442610 ^ 1205403802, true, true, true, true);
      eu(var1, (float)var2 + 8.0F, var4, (float)this.bdk - 16.0F, (float)this.bla, 8.0F, -1101271791 ^ -206074503);
      this.ay(var1, this.bbm, var3, Math.round(var4) + 8, amm, false);
      boolean var5 = this.bbc != 0;
      this.ay(var1, var5 ? axg[96] : axg[66], var3, Math.round(var4) + 20, amn, false);
   }

   private void mo(DrawContext var1, BundleSync.Entry var2, int var3, int var4, int var5) {

      String var6 = atq[28];
      String var7 = atq[24];
      String var8 = atq[29];
      String var9 = atq[30];
      String var10 = gy(var2.f);
      int var11 = this.bd(var6);
      int var12 = this.bd(var2.b);
      int var13 = var2.c ? this.bd(var7) + 3 : 0;
      int var14 = this.bd(var8);
      boolean var15 = var11 + var12 + var13 + var14 + this.bd(var10) + this.bd(var9) > var5;
      if (var15) {
         nr(var1, var3, var4 - 2, var3 + Math.max(0, var5), var4 + 10);
      }

      this.ay(var1, var6, var3, var4, amn, false);
      this.ay(var1, var2.b, var3 + var11, var4, amm, false);
      if (var2.c) {
         this.ay(var1, var7, var3 + var11 + var12 + 3, var4, amw, false);
      }

      int var16 = var3 + var11 + var12 + var13;
      this.ay(var1, var8, var16, var4, amn, false);
      this.ay(var1, var10, var16 + var14, var4, amn, false);
      this.ay(var1, var9, var16 + var14 + this.bd(var10), var4, amn, false);
      if (var15) {
         var1.disableScissor();
      }
   }

   private void mp(DrawContext var1, int var2, int var3, int var4) {

      assert var1 != null
         && this.bhw != null
         && this.bhx != null
         && this.bfx != null
         && atq != null
         && atq.length > 92
         && bbb != null
         && bbb.length > 36
         && ana != null
         && axg != null
         && axg.length > 95
         && bjy != null
         && bjy.length == 30
         && blo != null
         && blo.length == 48
         && abp != null
         && abp.length > 10
         && abn != null
         && abn.length == 3 : "cf" + "gChips: bad sta" + "te";

      List var5 = ku();
      int var6 = amz;
      int var7 = o(yd, 77);
      int var8 = this.bd(atq[85]);
      int var9 = this.bd(atq[86]);
      Object var10 = null;

      try {
         for (int var11 = 0; var11 < this.bhz; var11++) {
            int var12 = this.bfy[var2][var11];
            int var13 = this.bfx[var2][var11];
            float var14 = (float)(var3 + this.bhw[var11]);
            float var15 = (float)(var4 + this.bhx[var11] * 19);
            int var16 = this.bhy[var11];
            int var17 = ft(var15, 15.0F);
            int var18 = Math.round(var14) + 6;
            int var19 = var12 == 1 ? var6 : 1216735655 ^ 1165629016;
            int var20 = var12 == 1 ? var7 : 9919821 ^ 392733362;
            int var21 = var12 == 1 ? amw : (var12 == 2 ? amo : amn);
            bt(var1, var14, var15, (float)var16, 15.0F, 7.5F, var19, true, true, true, true);
            eu(var1, var14, var15, (float)var16, 15.0F, 7.5F, var20);
            int var22 = 0;
            if (var12 == 1) {
               this.ay(var1, atq[85], var18, var17, var21, false);
               var22 = var8;
            } else if (var12 == 2) {
               this.ay(var1, atq[86], var18, var17, var21, false);
               var22 = var9;
            }

            int var23;
            if (var13 >= 0 && var5 != null && var13 < var5.size()) {
               var10 = (BuilderFactory)var5.get(var13);
               this.be(var1, ((BuilderFactory)var10).c, ((BuilderFactory)var10).cK, var18 + var22, var17, var21, false);
               var23 = this.kw(var5, var13);
            } else {
               this.ay(var1, axg[55], var18 + var22, var17, var21, false);
               var23 = this.bd(axg[55]);
            }

            if (var12 == 2) {
               ev(var1, (float)(var18 + var22) - 0.5F, var15 + 7.5F - 0.375F, (float)(var18 + var22 + var23) + 0.5F, var15 + 7.5F + 0.375F, amo);
            }

            String var24 = this.bfz[var2][var11];
            if (var24 != null) {
               this.ay(var1, var24, var18 + var22 + var23 + this.bd(atq[90]) + 1, var17, amo, false);
            }
         }
      } catch (RuntimeException var25) {
         throw var25;
      }
   }

   private void mq(DrawContext var1, int var2, int var3, int var4) {

      assert var1 != null
         && this.bgo != null
         && this.bgr != null
         && var4 > 0
         && atq != null
         && atq.length > 92
         && bbb != null
         && bbb.length > 36
         && ana != null
         && axg != null
         && axg.length > 95
         && bjy != null
         && bjy.length == 30
         && blo != null
         && blo.length == 48
         && abp != null
         && abp.length > 10
         && abn != null
         && abn.length == 3 : "cfgAllList: bad state";

      List var5 = ku();
      int var6 = this.blc;
      int var7 = this.bld;
      if (var5 != null && var7 > var6) {
         int var8 = this.bgw[var2];
         int var9 = Math.max(0, this.bgx[var2] - (var7 - var6));
         this.bbo = Math.max(0, Math.min(var9, this.bbo));
         this.bbr = this.dc(this.bbr, this.bbo, var9, 25.0F);
         this.bbu = this.de(this.bbr);
         this.bbs = this.df(this.bbr);
         int[] var10 = this.bgo[var2];
         int[] var11 = this.bgr[var2];
         int[] var12 = this.bgp[var2];
         int[] var13 = this.bgq[var2];
         String var14 = axg[56];
         int var15 = this.bd(var14);
         int var16 = var4 / 2;
         Object var17 = null;
         Object var18 = null;
         nr(var1, var3 - 2, var6, var3 + var4 + 2, var7);
         boolean var19 = dh(var1, this.bbs);

         try {
            for (int var20 = 0; var20 < var8; var20++) {
               int var21 = var6 + var11[var20] - this.bbu;
               if (var21 + 12 > var6 && var21 < var7) {
                  int var22 = var10[var20];
                  if (var22 == 0) {
                     int var41 = var12[var20];
                     if (var41 >= 0 && var41 < var5.size()) {
                        var17 = (BuilderFactory)var5.get(var41);
                        this.be(var1, ((BuilderFactory)var17).c, ((BuilderFactory)var17).cK, var3, var21, amm, false);
                     }

                     if (var13[var20] == 1 || var13[var20] == 2) {
                        boolean var43 = var13[var20] == 1;
                        this.ly(var1, var43 ? axg[60] : axg[61], var3 + var4, var21, var43 ? amw : amo);
                     }
                  } else if (var22 == 3) {
                     this.ay(var1, axg[55], var3, var21, amm, false);
                  } else if (var22 == 5) {
                     this.ay(var1, this.bgt[var2][var20], var3, var21, amw, false);
                     this.ly(var1, this.bgu[var2][var20], var3 + var4, var21, amo);
                  } else if (var22 == 6) {
                     for (int var40 = 0; var40 < 2; var40++) {
                        int var42 = var40 == 0 ? var12[var20] : var13[var20];
                        if (var42 >= 0 && var42 < var5.size()) {
                           var17 = (BuilderFactory)var5.get(var42);
                           boolean var44 = (var40 == 0 ? this.bgu[var2][var20] : this.bgv[var2][var20]) != null;
                           int var45 = var3 + var40 * var16;
                           int var46 = this.kw(var5, var42);
                           if (var46 > var16 - 6) {
                              nr(var1, var45, var21 - 1, var45 + var16 - 6, var21 + 11);
                           }

                           this.be(var1, ((BuilderFactory)var17).c, ((BuilderFactory)var17).cK, var45, var21, var44 ? amw : amn, false);
                           if (var46 > var16 - 6) {
                              var1.disableScissor();
                           }
                        }
                     }
                  } else {
                     String var23 = this.bgu[var2][var20];
                     String var24 = this.bgv[var2][var20];
                     int var25 = this.bd(var24);
                     int var26 = this.bd(var23);
                     int var27 = var3 + var4;
                     this.ay(var1, var24, var27 - var25, var21, amm, false);
                     this.ay(var1, var14, var27 - var25 - 4 - var15, var21, amo, false);
                     this.ay(var1, var23, var27 - var25 - 8 - var15 - var26, var21, amo, false);
                     int var28 = var4 - var25 - var26 - var15 - 14;
                     var18 = this.bgs[var2][var20];
                     int var29;
                     if (var22 == 1 && var18 != null) {
                        var29 = this.bf(((InitAdapter)var18).a, ((InitAdapter)var18).aK);
                     } else {
                        var29 = this.bd(var22 == 2 ? axg[54] : this.bgt[var2][var20]);
                     }

                     boolean var30 = var29 > var28;
                     if (var30) {
                        nr(var1, var3, var21 - 1, var3 + Math.max(0, var28), var21 + 11);
                     }

                     if (var22 == 1 && var18 != null) {
                        this.be(var1, ((InitAdapter)var18).a, ((InitAdapter)var18).aK, var3, var21, amn, false);
                     } else {
                        this.ay(var1, var22 == 2 ? axg[54] : this.bgt[var2][var20], var3, var21, amn, false);
                     }

                     if (var30) {
                        var1.disableScissor();
                     }
                  }
               }
            }
         } catch (RuntimeException var34) {
            throw var34;
         } finally {
            di(var1, var19);
            var1.disableScissor();
         }

         int var39 = var7 - var6;
         if (this.bgx[var2] > var39) {
            gf(var1, (float)(var3 + var4) + 6.0F, (float)var6, (float)var39, (float)var39 / (float)this.bgx[var2], this.bbr / (float)Math.max(1, var9));
         }
      }
   }

   private void mr(DrawContext var1, int var2, int var3, int var4, int var5, int var6) {

      boolean var7 = this.bbj == 2;
      boolean var8 = this.bbj == 4;
      boolean var9 = this.bdm;
      String var10 = var7 ? atq[3] : (var8 ? axg[52] : atq[0]);
      String var11 = var7 ? atq[39] : (var8 ? axg[53] : atq[38]);
      this.gq(var1, var10, (float)var2, (float)(var3 + (var9 ? 12 : 15)), 1.5F, amm, false);
      this.ay(var1, var11, var2, var3 + (var9 ? 28 : 33), amo, false);
      this.gg(var1, axg[21], (float)var2, this.bki - (float)(var9 ? 9 : 11), amo);
      String var12 = this.bbj == 1 ? this.ll() : "";
      String var13 = !var12.isEmpty() ? var12 : atq[40];
      boolean var14 = (float)var5 >= this.bkh && (float)var5 < this.bkh + this.bkj && (float)var6 >= this.bki && (float)var6 < this.bki + this.bkk;
      this.go(var1, this.bkh, this.bki, this.bkj, this.bkk, this.adq, var13, this.adr, blj, var14);
      int var15 = Math.round(this.bki + this.bkk) + (var9 ? 6 : 8);
      if (this.bim >= 0) {
         this.ay(var1, axg[this.bim], var2, var15, -1988057309 ^ 1987108259, false);
      } else if (this.bin != null && !var7) {
         if (var9) {
            this.ay(var1, this.bin, var2, var15, amm, false);
            this.ay(var1, axg[47], var2 + this.bd(this.bin), var15, amn, false);
         } else {
            bt(var1, (float)var2, (float)var15, (float)var4, 40.0F, 8.0F, 1018462639 ^ 910917200, true, true, true, true);
            eu(var1, (float)var2, (float)var15, (float)var4, 40.0F, 8.0F, -1509617750 ^ -1241845675);
            String var16 = this.biq;
            this.ay(var1, var16, var2 + 10, var15 + 8, amm, false);
            this.ay(var1, axg[47], var2 + 10 + this.bd(var16), var15 + 8, amn, false);
            this.ay(var1, this.bip, var2 + 10, var15 + 21, amn, false);
         }
      } else if (this.bin != null) {
         this.ay(var1, this.bip, var2, var15, amw, false);
      } else if (!var7 && !var8 && !var9) {
         if (this.bho != this.bhg || this.bhp != ThemeCache.o) {
            this.bho = this.bhg;
            this.bhp = ThemeCache.o;
            this.bhn = this.bhg + axg[81] + ThemeCache.k() + axg[69];
         }

         this.ay(var1, this.bhn, var2, var15, amo, false);
         this.ay(var1, axg[68], var2, var15 + 12, amo, false);
      }

      if (var7) {
         if (!var9) {
            this.gg(var1, axg[22], (float)var2, this.bkm - 11.0F, amo);
         }

         this.mt(var1, this.bbe, blm, var5, var6);
      }
   }

   private void ms(DrawContext var1, int var2, int var3, int var4, int var5, int var6, int var7) {

      boolean var8 = this.bdm;
      this.gq(var1, atq[92], (float)var2, (float)(var3 + (var8 ? 12 : 15)), 1.5F, amm, false);
      BundleSync.Entry var9 = this.jx();
      if (!var8 && var9 != null) {
         int var10 = this.bdu.indexOf(var9);
         String var11 = var10 >= 0 && var10 < this.bfg.length ? this.bfg[var10] : atq[89];
         this.ay(var1, axg[70], var2, var3 + 28, amn, false);
         int var12 = var2 + this.bd(axg[70]);
         this.ay(var1, var11, var12, var3 + 28, amn, false);
         var12 += this.bd(var11);
         this.ay(var1, atq[29], var12, var3 + 28, amn, false);
         var12 += this.bd(atq[29]);
         this.ay(var1, gy(var9.f), var12, var3 + 28, amn, false);
         this.ay(var1, atq[30], var12 + this.bd(gy(var9.f)), var3 + 28, amn, false);
      }

      this.gg(var1, axg[21], (float)var2, this.bki - (float)(var8 ? 9 : 10), amo);
      boolean var13 = (float)var6 >= this.bkh && (float)var6 < this.bkh + this.bkj && (float)var7 >= this.bki && (float)var7 < this.bki + this.bkk;
      this.go(var1, this.bkh, this.bki, this.bkj, this.bkk, this.bbg, atq[40], this.bbi, blj, var13);
      if (!var8) {
         this.gg(var1, axg[22], (float)var2, this.bkm - 10.0F, amo);
      }

      this.mt(var1, this.bbh, bln, var6, var7);
      if (this.bbl) {
         this.mn(var1, var2 - 12, var2);
      }
   }

   private void mt(DrawContext var1, boolean var2, Object var3, int var4, int var5) {

      int var6 = Math.round(this.bkl);
      int var7 = Math.round(this.bkm);
      int var8 = Math.round(this.bkn);
      boolean var9 = var4 >= var6 && var4 < var6 + var8 && var5 >= var7 && var5 < var7 + 24;
      float var10 = this.cw(blk, var9);
      this.ay(var1, atq[43], var6, var7 + 2, var10 <= 0.0F ? amm : cq(amm, -1, var10), false);
      String var11 = atq[44];
      String var12 = var2 ? atq[45] : (ConfigBridge.USER_NAME.isEmpty() ? atq[46] : ConfigBridge.USER_NAME);
      this.ay(var1, var11, var6, var7 + 14, amn, false);
      this.ay(var1, var12, var6 + this.bd(var11), var7 + 14, amm, false);
      float var13 = this.da(var3, var2 ? 1.0F : 0.0F);
      gc(var1, (float)(var6 + var8 - 24), (float)(var7 + 2), var13);
   }

   private void mu(DrawContext var1) {

      float var2 = (float)this.ble;
      float var3 = (float)this.blf;
      float var4 = (float)this.blg;
      float var5 = (float)this.blh;
      float var6 = var5 * 0.5F;
      bt(var1, var2, var3 + 2.0F, var4, var5, var6, -1425424541 ^ -351682717, true, true, true, true);
      bt(var1, var2, var3, var4, var5, var6, o(cq(amx, -510199525 ^ 513210651, 0.2F), 1889514997 ^ 1889514759), true, true, true, true);
      eu(var1, var2, var3, var4, var5, var6, 1189991801 ^ 1863461510);
      long var7 = 10000000000L - (System.nanoTime() - bcx);
      float var9 = Math.max(0.0F, Math.min(1.0F, (float)var7 / 1.0E10F));
      ev(var1, var2 + var6, var3 + var5 - 1.5F, var2 + var6 + (var4 - 2.0F * var6) * var9, var3 + var5 - 0.5F, o(yd, 906402294 ^ 906402110));
      int var10 = ft(var3, var5);
      int var11 = Math.round(var2) + 14;
      this.ay(var1, bcu, var11, var10, amn, false);
      var11 += this.bd(bcu);
      this.ay(var1, this.bda, var11, var10, amm, false);
      var11 += this.bd(this.bda) + 12 + this.bd(axg[17]) + 24 + 8;
      int var12 = (int)Math.max(1L, Math.min(10L, (var7 + 999999999L) / 1000000000L));
      String var13 = gy(var12);
      this.ay(var1, var13, var11, var10, amo, false);
      this.ay(var1, axg[37], var11 + this.bd(var13), var10, amo, false);
   }

   private void mv(DrawContext var1, int var2, int var3, int var4, int var5, boolean var6, boolean var7, int var8, int var9) {

      int var10 = var3 + var5 - this.bdf;
      int var11 = this.bdf;
      ev(var1, (float)var2 + 1.0F, (float)var10, (float)(var2 + var4) - 1.0F, (float)var10 + 1.0F / (float)Math.max(1, ahd), 2097420402 ^ 1862002573);
      String var12 = atq[70];
      String var13 = atq[71];
      String var14 = atq[72];
      Object var15 = null;
      String var16 = null;
      String var17 = null;
      int var18 = 0;
      String var19 = null;
      String var20 = null;
      String var21 = null;
      String var22 = null;
      String var24 = atq[74];
      boolean var25 = var6 ? this.jx() != null : this.bcg || this.kb() >= 0;
      boolean var26 = false;
      if (var6 && BundleSync.ad) {
         var15 = BundleSync.ae;
         var16 = atq[75];
         var18 = yd;
      } else if (this.bbl) {
         var15 = var6 ? atq[50] : atq[49];
         var18 = 799074337 ^ -800025951;
         var19 = var12;
         var20 = atq[8];
         var24 = atq[10];
      } else if (this.bbj != 1 && this.bbj != 2 && this.bbj != 4) {
         if (this.bbj == 3) {
            var15 = atq[52];
            var16 = this.bbg;
            var19 = var12;
            var20 = atq[11];
            var24 = atq[10];
         } else if (!this.bcl.isEmpty() && System.nanoTime() - this.bcn < 7000000000L) {
            var15 = this.bcl;
            var18 = this.bcm ? yd : 559328057 ^ -559492679;
         } else if (!this.bch.isEmpty()) {
            var15 = this.bex;
            var16 = this.bey;
         } else if (var7) {
            this.mw();
            var15 = this.bmi;
         } else if (var6) {
            var15 = atq[55];
         } else if (this.kv() >= 0) {
            var15 = atq[53];
            var16 = bcd;
            var17 = this.bhm;
            var18 = yd;
            var26 = this.bhh > 0;
         } else {
            var15 = this.bhj;
            var16 = this.bhk.isEmpty() ? null : atq[29];
            var17 = this.bhk;
         }
      } else {
         boolean var27 = this.bin != null && this.bim < 0 && this.bbj != 4;
         var15 = var27 ? (this.bbj == 2 ? axg[85] : axg[50]) : atq[51];
         var19 = var12;
         var20 = var27 ? axg[46].trim() : (this.bbj == 2 ? atq[12] : (this.bbj == 4 ? axg[86] : atq[11]));
         var24 = atq[10];
      }

      if (this.bbj == 0 && !this.bbl && (!var6 || !BundleSync.ad)) {
         if (!this.bch.isEmpty()) {
            var19 = axg[43];
            var20 = axg[44];
            var21 = var12;
            var22 = atq[73];
            var24 = axg[45];
         } else if (var25) {
            boolean var39 = jp();
            var19 = var39 ? axg[42] : var12;
            var20 = var39 ? axg[90] : (this.bcg ? atq[11] : atq[73]);
            if (this.bcg && !var39 && this.bhh <= 0) {
               var19 = null;
               var20 = null;
            }

            if (!var6 && !this.bcg || var6 && this.jy()) {
               var21 = var13;
               var22 = atq[8];
            }
         }
      }

      int var40 = var2 + 22;
      int var28 = Math.round((float)var10 + (float)var11 * 0.5F - 3.9F);
      if (var18 != 0) {
         bs(var1, (float)var40, (float)var10 + (float)var11 * 0.5F - 2.6F, 5.2F, var18);
         var40 += 10;
      }

      int var29 = (var19 != null ? this.gl(var19, var20) + 12 : 0) + (var21 != null ? this.gl(var21, var22) + 12 : 0) + this.gl(var14, var24);
      int var30 = this.bd((String)var15) + (var16 != null ? this.bd(var16) : 0) + (var17 != null ? this.bd(var17) : 0);
      int var31 = var26 ? this.bd(atq[14]) + 22 : 0;
      int var32 = var2 + var4 - 22 - var29 - 12 - var40 - (var26 ? var31 + 10 : 0);
      if (var26 && var30 > var32) {
         var26 = false;
         var32 += var31 + 10;
      }

      boolean var33 = var30 > var32;
      if (var33) {
         nr(var1, var40, var10 + 2, var40 + Math.max(0, var32), var10 + var11 - 2);
      }

      this.ay(var1, (String)var15, var40, var28, var15 == atq[53] ? amo : amn, false);
      int var34 = var40 + this.bd((String)var15);
      if (var16 != null) {
         boolean var35 = var6 && BundleSync.ad || var16 == atq[29];
         this.ay(var1, var16, var34, var28, var35 ? amn : amm, false);
         var34 += this.bd(var16);
      }

      if (var17 != null) {
         this.ay(var1, var17, var34, var28, amn, false);
         var34 += this.bd(var17);
      }

      if (var33) {
         var1.disableScissor();
      }

      this.bmc = var26;
      if (var26) {
         float var41 = this.bdm ? 22.0F : 24.0F;
         float var36 = (float)var34 + 12.0F;
         float var37 = (float)var10 + ((float)var11 - var41) / 2.0F;
         this.bmd = var36;
         this.bme = var37;
         this.bmf = (float)var31;
         this.fz(
            var1,
            var36,
            var37,
            (float)var31,
            var41,
            atq[14],
            1,
            bjy[28],
            (float)var8 >= var36 && (float)var8 < var36 + (float)var31 && (float)var9 >= var37 && (float)var9 < var37 + var41,
            false
         );
      }

      this.gm(var1, var2 + var4 - 20, var10, var11, var19, var20, var21, var22, var14, var24);
   }

   private void mw() {

      int var1 = (int)Math.min(9999L, (System.nanoTime() - bdw) / 60000000000L);
      if (var1 != this.bmg) {
         this.bmg = var1;
         this.bmh = var1 < 1 ? atq[65] : atq[66] + var1 + atq[67];
         this.bmi = var1 < 1 ? atq[68] : atq[69] + var1 + atq[67];
      }
   }

   private void mx(int var1, int var2, int var3, int var4, int var5) {

      int var6 = var2 + this.bdg;
      if (var3 >= var1 + this.bdj && var4 >= var6 && var4 < var6 + this.bdh) {
         if (this.bbn) {
            this.bbo = Math.max(0, this.bbo - var5);
         }
      } else {
         if (var3 >= var1 + 16 && var3 < var1 + 16 + this.bdi && var4 >= var6 && var4 < var6 + this.bdh) {
            int var7 = Math.max(0, this.bes + 6 - (this.jr() - 26));
            this.ady = Math.max(0, Math.min(var7, this.ady - var5));
         }
      }
   }

   private void my(NodeZoneRenderer var1) {

      if (!var1.f()) {
         var1.a(true);
      }

      this.ada = null;
      this.age = null;
      this.acx = var1;
      this.na();
   }

   private void mz(CoreZoneProcessor var1) {

      if (!var1.f) {
         var1.a(true);
      }

      this.acx = null;
      this.agd = null;
      this.ada = var1;
      this.na();
   }

   private void na() {

      int var1 = this.nd().length;
      int var2 = this.ada != null ? bpm : bpl;
      this.acy = var2 >= 0 && var2 < var1 ? var2 : 0;
      this.acz = false;
      this.acs = -1;
      this.bpz[0] = 0;
      this.bqa[0] = 0.0F;
      this.bqb[0] = 0;
      this.bqc = -1;
      this.bqo = -1;
      this.bqu = 0L;
      this.bpn = 2;
      this.bpo = 1.0F;
      this.bpp = false;
      this.bpq = 1.0F;
      this.bps = null;

      for (Object var6 : bph) {
         this.aiw.removeFloat(var6);
      }

      for (Object var13 : bpi) {
         this.aiw.removeFloat(var13);
      }

      for (Object var14 : bpj) {
         this.aiw.removeFloat(var14);
      }

      if (this.acy < bpi.length) {
         this.aiw.put(bpi[this.acy], 1.0F);
      }
   }

   private boolean nb() {

      return this.acx != null || this.ada != null;
   }

   private void nc() {

      this.acx = null;
      this.ada = null;
      this.bps = null;
      this.bpp = false;
   }

   private NodeZoneRenderer.Vis[] nd() {

      CoreZoneProcessor var1 = this.ada;
      return var1 != null ? var1.a() : this.acx.u();
   }

   private void ne(int var1) {

      if (var1 != this.acy) {
         this.acy = var1;
         if (this.ada != null) {
            bpm = var1;
         } else {
            bpl = var1;
         }

         this.bqu = 0L;
         this.bps = null;
         this.bql = false;
         this.bpo = SyncController.x ? 1.0F : 0.0F;
      }
   }

   private void nf(int var1) {

      int var2 = this.nd().length;
      int var3 = this.acy + var1;
      this.ne(var3 < 0 ? 0 : (var3 >= var2 ? var2 - 1 : var3));
      this.bpn = 1;
   }

   private static int ng(int var0) {

      return Math.max(-1635644977 ^ -1635645345, Math.min(-1065257161 ^ -1065257233, var0 - 16));
   }

   private static int nh(int var0) {

      return Math.max(2711731 ^ 2711663, Math.min(553348950 ^ 553348858, var0 - 16));
   }

   private void ni(int var1, int var2) {

      int var3 = this.adz != 0 ? var1 : ng(var1);
      int var4 = this.adz != 0 ? var2 : nh(var2);
      this.bok = var3;
      this.bol = var4;
      this.boi = (var1 - var3) / 2;
      this.boj = (var2 - var4) / 2;
   }

   private boolean nj() {

      float var1 = this.ada != null ? 0.0F : 1.0F;
      float var2 = this.bpr;
      if (var2 != var1) {
         var2 = SyncController.x ? var1 : var2 + (var1 - var2) * (1.0F - (float)Math.exp((double)(-21.0F * this.ajg)));
         this.bpr = Math.abs(var1 - var2) < 0.004F ? var1 : var2;
      }

      return this.bpr > 0.004F;
   }

   private void nk() {

      if (this.bps != null) {
         this.bps = null;
      } else if (this.bpp) {
         this.bpp = false;
      } else {
         this.nc();
      }
   }

   private void nl(DrawContext var1, CoreZoneProcessor var2) {

      if (var2 != null) {
         Matrix3x2fStack var3 = var1.getMatrices();
         float var4 = this.q();
         boolean var5 = this.ue(var1);
         var3.pushMatrix();

         try {
            var3.scale(1.0F / var4, 1.0F / var4);
            var2.o(var1, 32130300 ^ -32130843, 557720871 ^ -557721282, -2);
         } catch (Throwable var10) {
         } finally {
            var3.popMatrix();
            if (var5) {
               var3.popMatrix();
            }
         }
      }
   }

   private int nm() {

      return (int)Math.max(1L, Math.min(3L, Math.round(this.adk)));
   }

   private int nn(int var1, int var2, int var3) {

      int var4 = this.bpz[var1];
      float var5 = this.bqa[var1];
      if (var2 <= 0) {
         var4 = 0;
         var5 = 0.0F;
      } else {
         var4 = var4 < 0 ? 0 : (var4 > var2 ? var2 : var4);
         var5 = var5 < 0.0F ? 0.0F : (var5 > (float)var2 ? (float)var2 : var5);
         var5 += ((float)var4 - var5) * (1.0F - (float)Math.exp((double)(-25.0F * this.ajg)));
         if (SyncController.x || Math.abs((float)var4 - var5) * (float)var3 < 0.5F) {
            var5 = (float)var4;
         }
      }

      this.bpz[var1] = var4;
      this.bqa[var1] = var5;
      int var6 = Math.round(var5 * (float)var3);
      this.bqb[var1] = var6;
      return var6;
   }

   private int no(int var1, int var2, int var3) {

      if (var2 > 0 && (var1 != 1 || this.bqc == this.acy)) {
         int var4 = this.bqb[var1];
         return var4 < 0 ? 0 : Math.min(var4, var2 * var3);
      } else {
         return 0;
      }
   }

   private int np(int var1, int var2, int var3) {

      if (var2 == 0) {
         return var1;
      } else {
         float var4 = this.bqd;
         if (!(var4 >= (float)var1) || !(var4 < (float)(var1 + 1))) {
            var4 = (float)var1 + 0.5F;
         }

         return (int)Math.floor((double)(var4 + (float)var2 / (float)var3));
      }
   }

   private static void nq(DrawContext var0, int var1, int var2, int var3, int var4, int var5, int var6) {

      Matrix3x2fStack var7 = var0.getMatrices();
      float var8 = var7.m00;
      float var9 = var7.m11;
      float var10 = var7.m20;
      float var11 = var7.m21;
      int var12 = (int)Math.floor((double)(var8 * (float)var1 + var10 + 0.001F));
      int var13 = (int)Math.ceil((double)(var9 * (float)var2 + var11 - 0.001F));
      int var14 = (int)Math.ceil((double)(var8 * (float)var3 + var10 - 0.001F));
      int var15 = (int)Math.floor((double)(var9 * (float)var4 + var11 + 0.001F));
      var7.pushMatrix();
      var7.identity();
      var0.enableScissor(var12, var13, Math.max(var12, var14), Math.max(var13, var15));
      var7.popMatrix();
      var7.pushMatrix();
      var7.translate(0.0F, -((float)var5) / (float)var6);
   }

   private static void nr(DrawContext var0, int var1, int var2, int var3, int var4) {

      Matrix3x2fStack var5 = var0.getMatrices();
      float var6 = var5.m00;
      float var7 = var5.m01;
      float var8 = var5.m10;
      float var9 = var5.m11;
      if (var7 == 0.0F && var8 == 0.0F && var6 > 0.0F && var9 > 0.0F) {
         var0.enableScissor(var1, var2, var3, var4);
         if (ahq && GlyphPassCache.batching()) {
            GlyphPassCache.clip(var0, afh, (float)var1, (float)var2, (float)var3, (float)var4);
         }
      } else {
         float var10 = var5.m20;
         float var11 = var5.m21;
         float var12 = var6 * (float)var1 + var8 * (float)var2;
         float var13 = var6 * (float)var3 + var8 * (float)var2;
         float var14 = var6 * (float)var1 + var8 * (float)var4;
         float var15 = var6 * (float)var3 + var8 * (float)var4;
         float var16 = var7 * (float)var1 + var9 * (float)var2;
         float var17 = var7 * (float)var3 + var9 * (float)var2;
         float var18 = var7 * (float)var1 + var9 * (float)var4;
         float var19 = var7 * (float)var3 + var9 * (float)var4;
         int var20 = (int)Math.floor((double)(var10 + Math.min(Math.min(var12, var13), Math.min(var14, var15))));
         int var21 = (int)Math.ceil((double)(var10 + Math.max(Math.max(var12, var13), Math.max(var14, var15))));
         int var22 = (int)Math.floor((double)(var11 + Math.min(Math.min(var16, var17), Math.min(var18, var19))));
         int var23 = (int)Math.ceil((double)(var11 + Math.max(Math.max(var16, var17), Math.max(var18, var19))));
         var5.pushMatrix();
         var5.identity();
         var0.enableScissor(var20, var22, Math.max(var20, var21), Math.max(var22, var23));
         var5.popMatrix();
         if (ahq && GlyphPassCache.batching()) {
            GlyphPassCache.clip(var0, afh, (float)var1, (float)var2, (float)var3, (float)var4);
         }
      }
   }

   private static void ns(DrawContext var0) {

      var0.getMatrices().popMatrix();
      var0.disableScissor();
   }

   private void nt(DrawContext var1, int var2, int var3, int var4, int var5, int var6, int var7) {

      if (this.adz == 0) {
         nq(var1, var2, var3, var4, var5, var6, var7);
      } else {
         nr(var1, var2, var3, var4, var5);
         var1.getMatrices().pushMatrix();
         var1.getMatrices().translate(0.0F, -((float)var6) / (float)var7);
      }
   }

   private void nu(int var1, int var2, int var3, int var4, int var5) {

      if (this.nb() && var5 != 0 && !this.bpp) {
         this.ni(var1, var2);
         int var6 = this.boi;
         int var7 = this.boj;
         int var8 = this.bok;
         int var9 = this.bol;
         if (this.bps != null) {
            this.qm(var6, var7, var3, var4, var5);
         } else {
            int var10 = var7 + 44;
            int var11 = var7 + var9 - 32;
            int var12 = var6 + (-864917419 ^ -864917309) + 12;
            byte var13;
            int var14;
            if (var3 >= var6 && var3 < var6 + (-470555217 ^ -470555335) && var4 >= var10 && var4 < var7 + var9) {
               var13 = 0;
               var14 = this.nd().length * 28 - 4 - (var7 + var9 - var10);
            } else {
               if (var3 < var12 || var3 >= var6 + var8 || var4 < var10 || var4 >= var11) {
                  return;
               }

               if (this.bqc != this.acy) {
                  return;
               }

               this.nv(var2);
               var13 = 1;
               var14 = 13 + this.boh - (var11 - var10 - 6);
            }

            if (var14 > 0) {
               int var15 = this.bpz[var13] - var5;
               this.bpz[var13] = var15 < 0 ? 0 : (var15 > var14 ? var14 : var15);
            }
         }
      }
   }

   private void nv(int var1) {

      NodeZoneRenderer var2 = this.acx;
      int var3 = this.acy;
      int var4 = this.bqo == var3 && this.bqp == var1 && this.bqq == this.adz ? this.bqr : this.nw(var2, var3);
      this.nx(this.nd()[var3], var3, var4);
   }

   private int nw(NodeZoneRenderer var1, int var2) {

      if (var1 == null) {
         return 0;
      } else {
         boolean var3 = false;
         if (this.adz == 0 && !bqs) {
            try {
               var3 = PosePassCache.has3d(var2);
            } catch (Throwable var5) {
               bqs = true;
               var3 = false;
            }
         }

         if (var3) {
            return 1994580291 ^ 1994580419;
         } else {
            return var1.ad(var2) ? 84 : 0;
         }
      }
   }

   private void nx(NodeZoneRenderer.Vis var1, int var2, int var3) {

      boolean var4 = this.ada != null;
      InitAdapter[] var5 = var1.c;
      int[] var6 = nz(var4, var2, var5.length);
      int var7 = 0;
      int var8 = 36;
      byte var9 = 0;
      if (var3 > 0) {
         var7 = this.ny(var7, 4, 0, var8, var3);
         var8 += var3 + 14;
      }

      for (int var10 = 0; var10 < var5.length && var7 < 44; var10++) {
         if (var9 + 1 < var6.length && var6[var9] == var10) {
            if (var7 > 0 && this.boc[var7 - 1] != 4) {
               var8 += 6;
            }

            var7 = this.ny(var7, 0, var6[var9 + 1], var8, 16);
            var8 += 16;
            var9 += 2;
         }

         int var11 = oa(var4, var2, var10) >= 0 ? 34 : 28;
         var7 = this.ny(var7, 1, var10, var8, var11);
         var8 += var11;
      }

      NodeZoneRenderer var15 = this.acx;
      if (var15 != null && var15.w(var2)) {
         var8 += var7 > 0 ? 6 : 0;
         var7 = this.ny(var7, 0, 15, var8, 16);
         var8 += 16;
         var7 = this.ny(var7, 2, 0, var8, 34);
         var8 += 34;
      } else if (var4 && var5.length == 0) {
         var7 = this.ny(var7, 3, 0, var8, 34);
         var8 += 34;
      }

      this.bog = var7;
      this.boh = var8 + 16;
   }

   private int ny(int var1, int var2, int var3, int var4, int var5) {

      this.boc[var1] = var2;
      this.bod[var1] = var3;
      this.boe[var1] = var4;
      this.bof[var1] = var5;
      return var1 + 1;
   }

   private static int[] nz(boolean var0, int var1, int var2) {

      if (var0) {
         return var1 >= 0 && var1 < bnv.length ? bnv[var1] : bnv[5];
      } else if (var1 == 2 && var2 == 10) {
         return bnu;
      } else {
         return var1 >= 0 && var1 < bnt.length ? bnt[var1] : bnv[5];
      }
   }

   private static int oa(boolean var0, int var1, int var2) {

      if (var0 && var1 == 0) {
         return var2 == 4 ? 16 : (var2 == 5 ? 17 : -1);
      } else {
         return -1;
      }
   }

   private static boolean ob(BlockCalculator var0) {

      double var1 = var0.i();
      double var3 = var0.j();
      double var5 = var0.k();
      return !(var0 instanceof TimingEntry) && var5 >= 1.0 && var1 >= 1.0 && var3 <= 3.0 && var3 > var1 && (var3 - var1) / var5 <= 2.0001;
   }

   private String[] oc(SlotEntry var1) {

      List var2 = var1.g();
      String[] var3 = this.bpx.get(var1);
      if (var3 == null || var3.length != var2.size()) {
         var3 = new String[var2.size()];

         for (int var4 = 0; var4 < var3.length; var4++) {
            var3[var4] = v((String)var2.get(var4));
         }

         this.bpx.put(var1, var3);
      }

      return var3;
   }

   private static int od(SlotEntry var0) {

      int var1 = var0.g().indexOf(var0.f());
      return var1 < 0 ? 0 : var1;
   }

   private static void oe(DrawContext var0, int var1, int var2, int var3, int var4) {

      bz(var0, var1, var2, var3, var4, 3, -1730872874 ^ 1742730434, true, true, true, true);
      bz(var0, var1, var2, var3, 6, 3, -228315958 ^ 225459176, true, true, false, false);
      var0.fillGradient(var1, var2 + 3, var1 + var3, var2 + var4 - 3, 1060966923 ^ -1071053527, -84141629 ^ 100078807);
      if (!ahy) {
         by();
      }

      int var5 = var1 + var3 / 2;
      int var6 = var2 + var4 * 11 / 20;
      int var7 = var4 * 9 / 10 - 4;

      for (int var8 = 0; var8 < 5; var8++) {
         int var9 = var7 * (100 - 19 * var8) / 100;
         int var10 = Math.min(var3 - 8, var9 * 4 / 3);
         if (var9 < 4 || var10 < 4) {
            break;
         }

         int var11 = o(yd, 6 + var8 * 3 / 2);
         var0.drawTexture(
            RenderPipelines.GUI_TEXTURED,
            ahw,
            var5 - var10 / 2,
            var6 - var9 / 2,
            0.0F,
            0.0F,
            var10,
            var9,
            -556403690 ^ -556403562,
            -1168256814 ^ -1168256942,
            -834208790 ^ -834208918,
            -1264223044 ^ -1264223172,
            var11
         );
      }
   }

   private void of(DrawContext var1, int var2, int var3, int var4, int var5) {

      int var6 = Math.min(PosePassCache.lbN, PosePassCache.LBX.length);
      Matrix3x2fStack var7 = var1.getMatrices();

      for (int var8 = 0; var8 < var6; var8++) {
         int var9 = PosePassCache.LBC[var8];
         int var10 = PosePassCache.LBP[var8];
         int var11 = var9 >>> 24;
         int var12 = var10 >>> 24;
         if (var11 >= 8 || var12 >= 2) {
            int var13 = PosePassCache.LBT[var8];
            String var14 = bqt[var13 < 0 ? 0 : (var13 > 99 ? 99 : var13)];
            int var15 = this.bd(var14);
            float var16 = PosePassCache.LBX[var8] - (float)var15 * 0.5F;
            float var17 = PosePassCache.LBY[var8] - 4.0F;
            var16 = Math.max((float)var2 + 5.0F, Math.min((float)(var2 + var4) - 5.0F - (float)var15, var16));
            var17 = Math.max((float)var3 + 4.0F, Math.min((float)(var3 + var5) - 11.0F, var17));
            var16 = (float)Math.round(var16 * (float)ahd) / (float)ahd;
            var17 = (float)Math.round(var17 * (float)ahd) / (float)ahd;
            var7.pushMatrix();

            try {
               var7.translate(var16, var17);
               if (var12 >= 2) {
                  bu(var1, -3, -2, var15 + 6, 12, 3, var10);
               }

               if (var11 >= 8) {
                  this.ay(var1, var14, 0, 0, var9, true);
               }
            } finally {
               var7.popMatrix();
            }
         }
      }
   }

   private boolean og() {

      return this.bqu != 0L && System.nanoTime() / 1000000L - this.bqu < 3000L;
   }

   private void oh(DrawContext var1, int var2, int var3, int var4, int var5) {

      boolean var6 = this.ada != null;
      if (var6) {
         this.oi(var1, var2, var3);
      } else {
         this.fp(var1, var2, var3);
      }

      if (this.nb()) {
         if (this.adz == 0) {
            if (var6) {
               this.nl(var1, this.ada);
            } else if (SyncController.s) {
               this.nl(var1, this.dp());
            }
         }

         NodeZoneRenderer var7 = this.acx;
         NodeZoneRenderer.Vis[] var8 = this.nd();
         if (this.acy < 0 || this.acy >= var8.length) {
            this.acy = 0;
         }

         int var9 = this.acy;
         boolean var10 = var7 != null && this.adz == 0 && var7.w(var9);
         boolean var11 = this.bpp && var10;
         this.bpp = var11;
         float var12 = this.bpq;
         float var13 = var11 ? 0.0F : 1.0F;
         if (var12 != var13) {
            var12 = SyncController.x ? var13 : var12 + (var13 - var12) * (1.0F - (float)Math.exp((double)(-21.0F * this.ajg)));
            this.bpq = Math.abs(var13 - var12) < 0.004F ? var13 : var12;
            var12 = this.bpq;
         }

         float var14 = agi;
         if (var10 && var12 < 0.999F) {
            agi = var14 * (1.0F - var12);

            try {
               this.qd(var1, var2, var3, var4, var5);
               this.qe(var1, var2);
            } finally {
               agi = var14;
            }
         }

         if (!(var12 <= 0.004F)) {
            boolean var15 = !var11 && this.bps == null;
            int var16 = var15 ? var4 : -50471577 ^ 1023270247;
            int var17 = var15 ? var5 : 1928065558 ^ -1293159914;
            this.ni(var2, var3);
            int var18 = this.boi;
            int var19 = this.boj;
            int var20 = this.bok;
            int var21 = this.bol;
            int var22 = var19 + 44;
            int var23 = var19 + var21 - 32;
            int var24 = var18 + (1197603967 ^ 1197604073) + 12;
            agi = var14 * var12;
            boolean var25 = cc(var1, (float)var18 - 22.0F, (float)var19 - 14.0F, (float)(var18 + var20) + 22.0F, (float)(var19 + var21) + 22.0F);

            try {
               this.oj(var1, var18, var19, var20, var6, var16, var17);
               this.om(var1, var8, var18, var22, var19 + var21, var16, var17);
               float var26 = this.cw(bpb, var16 >= var24 && var16 < var18 + var20 && var17 >= var22 && var17 < var23);
               this.jj(var1, (float)var24, (float)var22, (float)(var18 + var20 - var24), (float)(var23 - var22), 16.0F, var26, 10.0F);
               this.op(var1, var7, var8[var9], var9, var3, var24, var22 + 3, var18 + var20, var23 - 3, var16, var17);
               this.ph(var1, var8[var9], var18, var19, var20, var21, var6, var16, var17);
            } finally {
               if (var25) {
                  cd();
               }

               agi = var14;
            }

            if (this.bps != null && !var11) {
               agi = var14 * var12;

               try {
                  this.pi(var1, var18, var19, var4, var5);
               } finally {
                  agi = var14;
               }
            }
         }
      }
   }

   private void oi(DrawContext var1, int var2, int var3) {

      if (this.adz == 0) {
         boolean var4 = this.ue(var1);

         try {
            bv(var1, 0, 0, var2, var3, -1415178020 ^ -1817831204);
         } finally {
            if (var4) {
               var1.getMatrices().popMatrix();
            }
         }
      }
   }

   private void oj(DrawContext var1, int var2, int var3, int var4, boolean var5, int var6, int var7) {

      String var8 = var5 ? adb[0] : bno[0];
      String var9 = bno[var5 ? 2 : 1];
      int var10 = Math.round((float)this.bd(var8) * 1.25F);
      int var11 = this.bd(var9);
      int var12 = Math.max(var10 + 28, Math.min(var4 - 40, 14 + var10 + 9 + var11 + 14));
      int var13 = var3 + 2;
      float var14 = this.cw(bpa, var6 >= var2 && var6 < var2 + var12 && var7 >= var13 && var7 < var13 + 28);
      this.jj(var1, (float)var2, (float)var13, (float)var12, 28.0F, 14.0F, var14, 10.0F);
      this.gq(var1, var8, (float)(var2 + 14), (float)var13 + 9.1F, 1.25F, amm, false);
      int var15 = var2 + 14 + var10 + 9;
      int var16 = var2 + var12 - 12 - var15;
      if (var16 > 30) {
         this.ay(var1, var11 <= var16 ? var9 : this.ex(var9, var16), var15, ft((float)var13, 28.0F), amo, false);
      }

      this.ok(var1, var2, var3, var4, var6, var7);
   }

   private void ok(DrawContext var1, int var2, int var3, int var4, int var5, int var6) {

      int var7 = var2 + var4 - 24;
      int var8 = var3 + 4;
      float var9 = this.cw(bou, ol(var2, var3, var4, var5, var6));
      this.jj(var1, (float)var7, (float)var8, 24.0F, 24.0F, 12.0F, var9, 10.0F);
      int var10 = var9 <= 0.0F ? amn : cq(amn, amm, var9);
      Matrix3x2fStack var11 = var1.getMatrices();
      var11.pushMatrix();

      try {
         var11.translate((float)var7 + 12.0F, (float)var8 + 12.0F);
         var11.rotate((float) (Math.PI / 4));
         bt(var1, -4.25F, -0.6F, 8.5F, 1.2F, 0.6F, var10, true, true, true, true);
         var11.rotate((float) (Math.PI / 2));
         bt(var1, -4.25F, -0.6F, 8.5F, 1.2F, 0.6F, var10, true, true, true, true);
      } finally {
         var11.popMatrix();
      }
   }

   private static boolean ol(int var0, int var1, int var2, int var3, int var4) {

      int var5 = var0 + var2 - 24;
      int var6 = var1 + 4;
      return var3 >= var5 && var3 < var5 + 24 && var4 >= var6 && var4 < var6 + 24;
   }

   private void om(DrawContext var1, NodeZoneRenderer.Vis[] var2, int var3, int var4, int var5, int var6, int var7) {

      int var8 = var2.length;
      int var9 = this.acy;
      int var10 = var5 - var4;
      int var11 = var8 * 28 - 4 - var10;
      if (this.bpn != 0) {
         int var12 = this.bpz[0];
         int var13 = var9 * 28;
         int var14 = var9 * 28 + 24;
         var12 = var13 < var12 ? var13 : (var14 > var12 + var10 ? var14 - var10 : var12);
         var12 = var11 <= 0 ? 0 : (var12 < 0 ? 0 : (var12 > var11 ? var11 : var12));
         this.bpz[0] = var12;
         if (this.bpn == 2) {
            this.bqa[0] = (float)var12;
         }

         this.bpn = 0;
      }

      int var30 = this.nm();
      int var31 = this.nn(0, var11, var30);
      boolean var32 = var11 > 0;
      int var15 = var6 >= var3 && var6 < var3 + (-116905235 ^ -116905349) && var7 >= var4 && var7 < var5
         ? (var32 ? this.np(var7, var31, var30) : var7)
         : -1090275941 ^ 2130949531;
      int var16 = var4 + var31 / var30;
      int var17 = var5 + (var31 + var30 - 1) / var30;
      int var18 = -1;
      if (var15 != (1941886343 ^ -1279339129)) {
         int var19 = var15 - var4;
         int var20 = var19 / 28;
         if (var19 >= 0 && var20 < var8 && var19 - var20 * 28 < 24) {
            var18 = var20;
         }
      }

      if (var32) {
         this.nt(var1, var3 - 16, var4, var3 + (-1915627810 ^ -1915627960) + 16, var5, var31, var30);
      }

      assert var1 != null && var2 != null && bpi != null && this.bpk != null && this.bpk.length == 4 : "vdList: bad" + " st" + "ate";

      try {
         if (yv && !aim && !var32) {
            for (int var33 = 0; var33 < var8; var33++) {
               int var35 = var4 + var33 * 28;
               if (var35 + 24 > var16 && var35 < var17) {
                  cn(var1, (float)var3, (float)var35, 150.0F, 24.0F, 12.0F, 9.0F, 3.0F, -1705986315 ^ -632244491);
               }
            }
         }

         float var34 = agi;

         for (int var36 = 0; var36 < var8; var36++) {
            int var21 = var4 + var36 * 28;
            if (var21 + 24 > var16 && var21 < var17) {
               agi = var34 * (var32 ? in((float)var21 + 12.0F, var16, var17) : 1.0F);
               this.on(var1, var2[var36], var36, var36 == var9, var3, var21, var18 == var36);
            }
         }

         agi = var34;
         float var37 = this.jm(bpg, null, bpf, var18 >= 0 ? (float)(var18 * 28) : 0.0F, 0.0F, var18 >= 0, this.bpk, 1);
         if (var37 > 0.01F) {
            bt(var1, (float)var3, (float)var4 + this.ata, 150.0F, 24.0F, 12.0F, dk(asy, var37), true, true, true, true);
         }

         for (int var38 = 0; var38 < var8; var38++) {
            int var22 = var4 + var38 * 28;
            if (var22 + 24 > var16 && var22 < var17) {
               agi = var34 * (var32 ? in((float)var22 + 12.0F, var16, var17) : 1.0F);
               this.oo(var1, var2[var38], var38 == var9, var3, var22, var18 == var38);
            }
         }

         agi = var34;
      } catch (RuntimeException var26) {
         throw var26;
      } finally {
         if (var32) {
            ns(var1);
         }
      }

      if (var32) {
         gf(
            var1,
            (float)(var3 + (-1775181561 ^ -1775181423) + 4),
            (float)(var4 + 6),
            (float)(var10 - 12),
            (float)var10 / (float)(var10 + var11),
            (float)var31 / (float)(var11 * var30)
         );
      }
   }

   private void on(DrawContext var1, NodeZoneRenderer.Vis var2, int var3, boolean var4, int var5, int var6, boolean var7) {

      float var8 = var3 < bpi.length ? this.cw(bpi[var3], var4) : (var4 ? 1.0F : 0.0F);
      float var9 = this.cw(var2, var7 && !var4);
      float var10 = 150.0F;
      float var11 = 24.0F;
      float var12 = 12.0F;
      ci(var1, (float)var5, (float)var6, var10, var11, var12, true, true, true, true, this.ck());
      int var13 = yv ? o(amy, (amy >>> 24) * 85 / 100) : amy;
      if (var8 > 0.004F) {
         var13 = cq(var13, o(cq(var13 | -868008712 ^ 860044536, yd, 0.2F), var13 >>> 24), var8);
      }

      bt(var1, (float)var5, (float)var6, var10, var11, var12, yv ? cg(var13) : var13, true, true, true, true);
      jl(var1, (float)var5, (float)var6, var10, var11, var12, asx);
      int var14 = var9 <= 0.0F ? asv : cq(asv, asw, var9);
      if (var8 > 0.004F) {
         var14 = cq(var14, o(yd, 644581205 ^ 644581323), var8);
      }

      eu(var1, (float)var5, (float)var6, var10, var11, var12, var14);
   }

   private void oo(DrawContext var1, NodeZoneRenderer.Vis var2, boolean var3, int var4, int var5, boolean var6) {

      CheckerBridge var7 = var2.b;
      boolean var8 = var7 == null || var7.f();
      float var9 = this.aiw.containsKey(var2) ? this.aiw.getFloat(var2) : 0.0F;
      int var10 = !var3 && !var8 ? (var9 <= 0.0F ? amn : cq(amn, amm, var9)) : amm;
      int var11 = ft((float)var5, 24.0F);
      if (var2.a != null) {
         this.ay(var1, var2.a, var4 + 12, var11, var10, false);
      } else if (var7 != null) {
         this.be(var1, ((InitAdapter)var7).a, var7.aK, var4 + 12, var11, var10, false);
      }

      if (var7 != null) {
         oy(var1, (float)(var4 + (935491521 ^ 935491415) - 27), (float)var5 + 7.75F, 15.0F, 8.5F, this.da(var2, var8 ? 1.0F : 0.0F), true);
      }
   }

   private void op(
      DrawContext var1, NodeZoneRenderer var2, NodeZoneRenderer.Vis var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11
   ) {

      int var12 = this.nw(var2, var4);
      this.bqo = var4;
      this.bqp = var5;
      this.bqq = this.adz;
      this.bqr = var12;
      this.nx(var3, var4, var12);
      if (this.bqc != var4) {
         this.bqc = var4;
         this.bpz[1] = 0;
         this.bqa[1] = 0.0F;
      }

      int var13 = var9 - var7;
      int var14 = 13 + this.boh - var13;
      int var15 = this.nm();
      int var16 = this.nn(1, var14, var15);
      boolean var17 = var14 > 0;
      boolean var18 = var10 >= var6 && var10 < var8 && var11 >= var7 && var11 < var9;
      int var19 = !var18 ? -51084254 ^ 1022657570 : (var17 ? this.np(var11, var16, var15) : var11);
      int var20 = var18 ? var10 : 1335629293 ^ -1885596179;
      int var21 = var7 + var16 / var15;
      int var22 = var9 + (var16 + var15 - 1) / var15;
      int var23 = -1;
      int var24 = var7 + 13;
      int var25 = var6 + 16;
      int var26 = var8 - var6 - 32;
      if (var19 != (1028858555 ^ -44883269) && var20 >= var25 - 8 && var20 < var25 + var26 + 8) {
         try {
            for (int var27 = 0; var27 < this.bog; var27++) {
               int var28 = this.boc[var27];
               int var29 = var24 + this.boe[var27];
               if ((var28 == 1 || var28 == 2 || var28 == 3) && var19 >= var29 && var19 < var29 + this.bof[var27]) {
                  var23 = var27;
                  break;
               }
            }
         } catch (RuntimeException var44) {
            throw var44;
         }
      }

      float var45 = this.bpo;
      if (var45 < 1.0F) {
         var45 = SyncController.x ? 1.0F : var45 + (1.0F - var45) * (1.0F - (float)Math.exp((double)(-21.0F * this.ajg)));
         this.bpo = var45 > 0.996F ? 1.0F : var45;
      }

      float var47 = agi;
      agi = var47 * this.bpo;
      boolean var48 = false;
      if (var17) {
         this.nt(var1, var6, var7, var8, var9, var16, var15);
      }

      try {
         int var30 = var25;
         int var31 = var26;
         int var32 = var24;
         float var33 = this.jm(bpd, bpe, bpc, var23 >= 0 ? (float)this.boe[var23] : 0.0F, var23 >= 0 ? (float)this.bof[var23] : 0.0F, var23 >= 0, this.bpk, 0);
         if (var33 > 0.01F) {
            bt(var1, (float)(var25 - 8), (float)var24 + this.ata, (float)(var26 + 16), this.atb, 7.0F, dk(asy, var33), true, true, true, true);
         }

         if (var24 + 36 > var21) {
            float var34 = agi;
            agi = var34 * (var17 ? in((float)var24 + 16.0F, var21, var22) : 1.0F);
            this.oq(var1, var3, var4, var25, var24, var26);
            agi = var34;
         }

         float var49 = agi;

         for (int var35 = 0; var35 < this.bog; var35++) {
            int var36 = var32 + this.boe[var35];
            int var37 = this.bof[var35];
            if (var36 + var37 > var21 && var36 < var22) {
               float var38 = var17 ? in((float)var36 + (float)var37 * 0.5F, var21, var22) : 1.0F;
               if (!(var38 < 0.05F) || this.boc[var35] == 4) {
                  agi = var49 * (this.boc[var35] == 4 ? 1.0F : var38);
                  int var39 = this.bod[var35];
                  switch (this.boc[var35]) {
                     case 0:
                        this.gg(var1, bnr[var39], (float)var30, (float)var36 + 5.4F, asz);
                        break;
                     case 1:
                        this.ou(var1, var3.c[var39], var39, var4, var30, var36, var31, var37, var20, var19);
                        break;
                     case 2:
                        this.pd(var1, 11, this.adz != 0 ? 19 : 12, 10, boy, var30, var36, var31, var37, var20, var19);
                        break;
                     case 3:
                     default:
                        this.pd(var1, 15, 21, 9, boz, var30, var36, var31, var37, var20, var19);
                        break;
                     case 4:
                        var48 = this.os(var1, var2, var4, var30, var36, var31, var37, var20, var19);
                  }
               }
            }
         }
      } finally {
         if (var17) {
            ns(var1);
         }

         agi = var47;
      }

      this.bqn = var48;
      if (var17) {
         gf(var1, (float)(var8 - 6), (float)(var7 + 6), (float)(var13 - 12), (float)var13 / (float)(var13 + var14), (float)var16 / (float)(var14 * var15));
      }
   }

   private void oq(DrawContext var1, NodeZoneRenderer.Vis var2, int var3, int var4, int var5, int var6) {

      CheckerBridge var7 = var2.b;
      if (var2.a != null) {
         this.gq(var1, var2.a, (float)var4, (float)var5 + 1.0F, 1.25F, amm, false);
      } else if (var7 != null) {
         this.or(var1, var7, (float)var4, (float)var5 + 1.0F, 1.25F, amm);
      }

      String[] var8 = this.ada != null ? bnq : bnp;
      if (var3 < var8.length) {
         String var9 = var8[var3];
         int var10 = var6 - (var7 != null ? 34 : 0);
         this.ay(var1, this.bd(var9) <= var10 ? var9 : this.ex(var9, var10), var4, var5 + 17, amo, false);
      }

      if (var7 != null) {
         oy(var1, (float)(var4 + var6 - 22), (float)var5 + 3.0F, 22.0F, 12.0F, this.da(var7, var7.f() ? 1.0F : 0.0F), false);
      }
   }

   private void or(DrawContext var1, InitAdapter var2, float var3, float var4, float var5, int var6) {

      int var7 = ahh;
      float var8 = (var7 >= 5 && var7 <= 45 ? (float)var7 / 10.0F : (float)ahd) * var5;
      int var9 = Math.round(var8 * 100.0F);
      int var10 = var9 % 10 == 0 ? var9 / 10 : (var9 != 125 && var9 != (-444676560 ^ -444676281) ? Math.round(var8 * 10.0F) : var9);
      var10 = var10 >= 100 ? var10 : Math.max(10, Math.min(45, var10));
      if (var7 < 5 || var7 > 45) {
         var3 = (float)Math.round(var3 * (float)ahd) / (float)ahd;
         var4 = (float)Math.round(var4 * (float)ahd) / (float)ahd;
      }

      Matrix3x2fStack var11 = var1.getMatrices();
      var11.pushMatrix();
      ahh = var10;

      try {
         var11.translate(var3, var4);
         var11.scale(var5, var5);
         this.be(var1, var2.a, var2.aK, 0, 0, var6, false);
      } finally {
         ahh = var7;
         var11.popMatrix();
      }
   }

   private boolean os(DrawContext var1, NodeZoneRenderer var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {

      boolean var10 = var7 > 84;
      bt(var1, (float)var4, (float)var5, (float)var6, (float)var7, 5.0F, 1182935911 ^ -1383127192, true, true, true, true);
      eu(var1, (float)var4, (float)var5, (float)var6, (float)var7, 5.0F, 748291210 ^ 946207605);
      if (var10) {
         float var11 = (float)var5 + (float)var7 * 0.72F;
         bt(var1, (float)var4, var11, (float)var6, (float)(var5 + var7) - var11, 5.0F, -1384237588 ^ -1417557485, false, false, true, true);
         ev(var1, (float)var4 + 1.0F, var11, (float)(var4 + var6) - 1.0F, var11 + fs(), -2122665878 ^ -1937420395);
      }

      if (var2 == null) {
         return false;
      } else if (!var10) {
         var2.ae(var3, var1, var4 + 2, var5 + 2, var6 - 4, var7 - 4);
         return false;
      } else {
         if (this.bql && PosePassCache.yawDrag == 0.0F) {
            PosePassCache.yawDrag = Float.MIN_VALUE;
         }

         boolean var14 = PosePassCache.draw(var1, var4 + 2, var5 + 2, var6 - 4, var7 - 4, var3);
         if (!var14 && var2.ad(var3)) {
            var2.ae(var3, var1, var4 + 2, var5 + 2, var6 - 4, var7 - 4);
         }

         if (var14) {
            if (PosePassCache.lbN > 0) {
               this.ot(var1, var4, var5, var6, var7);
            }

            boolean var12 = this.bql || var8 >= var4 && var8 < var4 + var6 && var9 >= var5 && var9 < var5 + var7;
            String var13 = bno[13];
            this.ay(var1, var13, var4 + var6 - this.bd(var13) - 10, var5 + var7 - 15, var12 ? amn : amo, false);
         }

         return var14;
      }
   }

   private void ot(DrawContext var1, int var2, int var3, int var4, int var5) {

      PaneGlassCache var6 = aiq;
      PaneGlassCache var7 = air;
      aiq = null;
      air = null;

      try {
         this.of(var1, var2, var3, var4, var5);
      } finally {
         aiq = var6;
         air = var7;
      }
   }

   private void ou(DrawContext var1, InitAdapter var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {

      int var11 = oa(this.ada != null, var4, var3);
      boolean var12 = var10 >= var6 && var10 < var6 + var8 && var9 >= var5 - 8 && var9 < var5 + var7 + 8;
      float var13 = var3 >= 0 && var3 < bpj.length ? this.cw(bpj[var3], var12) : 0.0F;
      int var14 = var13 <= 0.0F ? amn : cq(amn, amm, var13);
      if (var11 >= 0) {
         this.be(var1, var2.a, var2.aK, var5, var6 + 6, var14, false);
         this.ay(var1, bno[var11], var5, var6 + 18, amp, false);
      } else {
         this.be(var1, var2.a, var2.aK, var5, ft((float)var6, (float)var8), var14, false);
      }

      var12 = var12 && var9 >= var5 && var9 < var5 + var7;
      int var15 = var5 + var7 - (-959096422 ^ -959096546);
      float var16 = (float)var6 + (float)(var8 - 20) * 0.5F;
      if (var2 instanceof CheckerBridge var17) {
         oy(var1, (float)(var5 + var7 - 22), (float)var6 + (float)(var8 - 12) * 0.5F, 22.0F, 12.0F, this.da(var17, var17.f() ? 1.0F : 0.0F), false);
      } else if (var2 instanceof SlotEntry var18) {
         String[] var23 = this.oc(var18);
         int var24 = od(var18);
         if (var23.length > 0 && var23.length <= 3) {
            this.ga(
               var1,
               (float)var15,
               var16,
               132.0F,
               20.0F,
               var23,
               0,
               var23.length,
               var24 < var23.length ? var24 : 0,
               var12 ? gb((float)var15, var16, 132.0F, 20.0F, var23.length, var9, var10) : -1,
               var23
            );
         } else if (var23.length > 0) {
            this.oz(
               var1,
               (float)var15,
               var16,
               132.0F,
               20.0F,
               var23[var24 < var23.length ? var24 : 0],
               this.ov(var2, var4, var3),
               this.cw(var2, var12 && var9 >= var15),
               this.bps == var18
            );
         }
      } else if (var2 instanceof DialEntry var19) {
         this.oz(var1, (float)var15, var16, 132.0F, 20.0F, aa(var19), -1, this.cw(var2, var12 && var9 >= var15), this.adv == var19);
      } else if (var2 instanceof BlockCalculator var20) {
         this.ow(var1, var20, var5, var6, var7, var8, var9, var10, var12);
      } else if (var2 instanceof ItemDescriptor var21) {
         this.pc(var1, var21, var5 + var7, var16, this.cw(var2, var12));
      } else if (var2 instanceof TextEntry var22) {
         this.oz(var1, (float)var15, var16, 132.0F, 20.0F, var22.f(), -1, this.cw(var2, var12 && var9 >= var15), this.ads == var22);
      }
   }

   private int ov(InitAdapter var1, int var2, int var3) {

      NodeZoneRenderer var4 = this.acx;
      if (var4 != null) {
         return var4.v(var1);
      } else if (var2 == 0 && var3 == 0) {
         try {
            return RegionPassCache.i() & (-679919777 ^ -679034720);
         } catch (Throwable var6) {
            return -1;
         }
      } else {
         return -1;
      }
   }

   private void ow(DrawContext var1, BlockCalculator var2, int var3, int var4, int var5, int var6, int var7, int var8, boolean var9) {

      int var10 = var3 + var5 - (956465082 ^ 956464958);
      if (ob(var2)) {
         int var19 = (int)Math.round(var2.i());
         int var20 = (int)Math.round((var2.j() - var2.i()) / var2.k()) + 1;
         int var21 = (int)Math.round((var2.p() - var2.i()) / var2.k());
         float var22 = (float)var4 + (float)(var6 - 20) * 0.5F;
         this.ga(
            var1,
            (float)var10,
            var22,
            132.0F,
            20.0F,
            bns,
            var19 - 1,
            var20,
            var21 < 0 ? 0 : (var21 >= var20 ? var20 - 1 : var21),
            var9 ? gb((float)var10, var22, 132.0F, 20.0F, var20, var7, var8) : -1,
            bns
         );
      } else {
         int var11 = var2 instanceof SpanEntry ? 52 : 34;
         int var12 = (803588344 ^ 803588220) - var11;
         String var13 = aa(var2);
         int var14 = this.bd(var13);
         if (var9 && var7 >= var3 + var5 - var11) {
            bt(
               var1,
               (float)(var3 + var5 - var14 - 4),
               (float)var4 + (float)(var6 - 16) * 0.5F,
               (float)(var14 + 8),
               16.0F,
               5.0F,
               -1972926874 ^ -2053604967,
               true,
               true,
               true,
               true
            );
         }

         this.ay(var1, var13, var3 + var5 - var14, ft((float)var4, (float)var6), amm, false);
         if (var9 && this.acl == null) {
            this.ag(var2, var10, var12, var7, true, true);
         }

         float var15 = (float)var4 + (float)var6 * 0.5F;
         br(var1, (float)var10, var15 - 1.5F, (float)var12, 3.0F, -1403831910 ^ -1918056859);
         if (var2 instanceof SpanEntry var23) {
            float var17 = (float)ac(var23.lo(), var23.i(), var23.j());
            float var18 = (float)ac(var23.hi(), var23.i(), var23.j());
            if (var18 > var17) {
               br(var1, (float)var10 + (float)var12 * var17, var15 - 1.5F, Math.max(3.0F, (float)var12 * (var18 - var17)), 3.0F, yd);
            }

            ox(var1, (float)var10 + (float)var12 * var17, var15);
            ox(var1, (float)var10 + (float)var12 * var18, var15);
         } else {
            float var16 = (float)ac(var2.p(), var2.i(), var2.j());
            if (var16 > 0.0F) {
               br(var1, (float)var10, var15 - 1.5F, Math.max(3.0F, (float)var12 * var16), 3.0F, yd);
            }

            ox(var1, (float)var10 + (float)var12 * var16, var15);
         }
      }
   }

   private static void ox(DrawContext var0, float var1, float var2) {

      bs(var0, var1 - 5.5F, var2 - 4.5F, 11.0F, 1820625973 ^ 746884149);
      bs(var0, var1 - 5.0F, var2 - 5.0F, 10.0F, -2077235749 ^ 2077563943);
   }

   private static void oy(DrawContext var0, float var1, float var2, float var3, float var4, float var5, boolean var6) {

      int var7 = -559482361 ^ -145160712;
      br(var0, var1, var2, var3, var4, var5 <= 0.0F ? var7 : (var5 >= 1.0F ? yd : cq(var7, yd, var5)));
      if (var5 < 1.0F) {
         eu(var0, var1, var2, var3, var4, var4 * 0.5F, dk(-332614598 ^ -153924667, 1.0F - var5));
      }

      float var8 = var4 >= 12.0F ? 2.0F : 1.5F;
      float var9 = var4 - 2.0F * var8;
      float var10 = var1 + var8 + (var3 - 2.0F * var8 - var9) * var5;
      bs(var0, var10 - 0.5F, var2 + var8, var9 + 1.0F, 1222769355 ^ 1893857995);
      int var11 = var6 ? -1233432687 ^ 680766839 : -1854000260 ^ 1855377818;
      bs(var0, var10, var2 + var8, var9, var5 <= 0.0F ? var11 : (var5 >= 1.0F ? -1 : cq(var11, -1, var5)));
   }

   private void oz(DrawContext var1, float var2, float var3, float var4, float var5, String var6, int var7, float var8, boolean var9) {

      float var10 = var9 ? 1.0F : var8;
      bt(
         var1,
         var2,
         var3,
         var4,
         var5,
         7.0F,
         var10 <= 0.0F ? 470213584 ^ 318315567 : cq(154817208 ^ 130395463, 1381316860 ^ 1168819971, var10),
         true,
         true,
         true,
         true
      );
      eu(var1, var2, var3, var4, var5, 7.0F, var9 ? o(yd, -1922637242 ^ -1922637104) : -304693287 ^ -97959898);
      float var11 = var2 + 9.0F;
      if (var7 >= 0) {
         float var12 = var3 + var5 * 0.5F - 3.5F;
         bs(var1, var2 + 7.0F, var12, 7.0F, 1883368499 ^ -1891505101 | var7);
         eu(var1, var2 + 7.0F, var12, 7.0F, 7.0F, 3.5F, -1256420960 ^ -169642401);
         var11 = var2 + 19.0F;
      }

      int var13 = Math.round(var2 + var4 - 16.0F - var11);
      this.ay(var1, this.bd(var6) <= var13 ? var6 : this.ex(var6, var13), Math.round(var11), ft(var3, var5), amm, false);
      pa(var1, var2 + var4 - 9.0F, var3 + var5 * 0.5F, amo);
   }

   private static void pa(DrawContext var0, float var1, float var2, int var3) {

      pb(var0, var1 - 1.1F, var2 - 2.4F, (float) (-Math.PI / 4), var3);
      pb(var0, var1 + 1.1F, var2 - 2.4F, (float) (Math.PI / 4), var3);
      pb(var0, var1 - 1.1F, var2 + 2.4F, (float) (Math.PI / 4), var3);
      pb(var0, var1 + 1.1F, var2 + 2.4F, (float) (-Math.PI / 4), var3);
   }

   private static void pb(DrawContext var0, float var1, float var2, float var3, int var4) {

      Matrix3x2fStack var5 = var0.getMatrices();
      var5.pushMatrix();

      try {
         var5.translate(var1, var2);
         var5.rotate(var3);
         bt(var0, -1.95F, -0.45F, 3.9F, 0.9F, 0.45F, var4, true, true, true, true);
      } finally {
         var5.popMatrix();
      }
   }

   private void pc(DrawContext var1, ItemDescriptor var2, int var3, float var4, float var5) {

      boolean var6 = this.acr == var2;
      String var7 = var6 ? bno[18] : qr(var2.d);
      int var8 = Math.max(28, this.bd(var7) + 14);
      float var9 = (float)(var3 - var8);
      bt(var1, var9, var4, (float)var8, 20.0F, 6.0F, 155051731 ^ 826140371, true, true, true, true);
      eu(
         var1,
         var9,
         var4,
         (float)var8,
         20.0F,
         6.0F,
         var6 ? yd : (var5 <= 0.0F ? -1204524065 ^ -1563716576 : cq(-249658740 ^ -337543821, -330913698 ^ -776382559, var5))
      );
      this.ay(var1, var7, Math.round(var9 + (float)(var8 - this.bd(var7)) * 0.5F), ft(var4, 20.0F), var6 ? amw : (var2.d < 0 ? amo : amm), false);
   }

   private void pd(DrawContext var1, int var2, int var3, int var4, Object var5, int var6, int var7, int var8, int var9, int var10, int var11) {

      String var12 = bno[var4];
      int var13 = this.pe(var6, var8, var4);
      float var14 = (float)var7 + (float)(var9 - 22) * 0.5F;
      this.ay(var1, bno[var2], var6, var7 + 6, amn, false);
      String var15 = bno[var3];
      int var16 = var13 - 10 - var6;
      this.ay(var1, this.bd(var15) <= var16 ? var15 : this.ex(var15, var16), var6, var7 + 18, amp, false);
      this.fz(
         var1,
         (float)var13,
         var14,
         (float)(var6 + var8 - var13),
         22.0F,
         var12,
         1,
         var5,
         var10 >= var13 && var10 < var6 + var8 && (float)var11 >= var14 && (float)var11 < var14 + 22.0F,
         false
      );
   }

   private int pe(int var1, int var2, int var3) {

      return var1 + var2 - this.bd(bno[var3]) - 24;
   }

   private void pf(NodeZoneRenderer.Vis var1, int var2, int var3, int var4, int var5, boolean var6) {

      this.bos = var3 + var5 - 24;
      this.bor = this.bd(bno[8]) + 32;
      this.boq = var2 + var4 - this.bor;
      if (var6) {
         this.bop = this.bd(bno[9]) + 24;
         this.boo = this.boq - 8 - this.bop;
      } else {
         this.bop = 0;
         this.boo = this.boq;
      }

      int var7 = this.og() ? this.bd(bno[6]) + this.pg(var1) + this.bd(bno[7]) : this.bd(bno[var6 ? 5 : 4]);
      this.bom = var2 + (-1772523410 ^ -1772523272) + 12;
      this.bon = var7 + 24;
   }

   private int pg(NodeZoneRenderer.Vis var1) {

      if (var1.a != null) {
         return this.bd(var1.a);
      } else {
         CheckerBridge var2 = var1.b;
         return var2 == null ? 0 : this.bf(((InitAdapter)var2).a, var2.aK);
      }
   }

   private void ph(DrawContext var1, NodeZoneRenderer.Vis var2, int var3, int var4, int var5, int var6, boolean var7, int var8, int var9) {

      this.pf(var2, var3, var4, var5, var6, var7);
      int var10 = this.bos;
      boolean var11 = var9 >= var10 && var9 < var10 + 24;
      this.fz(var1, (float)this.boq, (float)var10, (float)this.bor, 24.0F, bno[8], 0, box, var11 && var8 >= this.boq && var8 < this.boq + this.bor, false);
      if (var7) {
         this.fz(var1, (float)this.boo, (float)var10, (float)this.bop, 24.0F, bno[9], 1, bow, var11 && var8 >= this.boo && var8 < this.boo + this.bop, false);
      }

      boolean var12 = var11 && var8 >= this.bom && var8 < this.bom + this.bon;
      if (!this.og()) {
         float var18 = this.aiw.containsKey(bov) ? this.aiw.getFloat(bov) : 0.0F;
         if (yv && !aim) {
            cn(var1, (float)this.bom, (float)var10, (float)this.bon, 24.0F, 12.0F, 9.0F, 3.0F, -1607636559 ^ -533894735);
         }

         ci(var1, (float)this.bom, (float)var10, (float)this.bon, 24.0F, 12.0F, true, true, true, true, this.ck());
         int var19 = yv ? o(amy, (amy >>> 24) * 85 / 100) : amy;
         bt(var1, (float)this.bom, (float)var10, (float)this.bon, 24.0F, 12.0F, yv ? cg(var19) : var19, true, true, true, true);
         eu(var1, (float)this.bom, (float)var10, (float)this.bon, 24.0F, 12.0F, var18 <= 0.0F ? asv : cq(asv, asw, var18));
         this.fz(var1, (float)this.bom, (float)var10, (float)this.bon, 24.0F, bno[var7 ? 5 : 4], 2, bov, var12, false);
         String var20 = bno[3];
         int var16 = this.bom + this.bon + 10;
         if (var16 + this.bd(var20) <= this.boo - 12) {
            this.ay(var1, var20, var16, ft((float)var10, 24.0F), amo, false);
         }
      } else {
         this.fz(var1, (float)this.bom, (float)var10, (float)this.bon, 24.0F, bno[22], 3, bov, var12, false);
         int var13 = this.bom + 12;
         int var14 = ft((float)var10, 24.0F);
         this.ay(var1, bno[6], var13, var14, -1, false);
         var13 += this.bd(bno[6]);
         CheckerBridge var15 = var2.b;
         if (var2.a != null) {
            this.ay(var1, var2.a, var13, var14, -1, false);
         } else if (var15 != null) {
            this.be(var1, ((InitAdapter)var15).a, var15.aK, var13, var14, -1, false);
         }

         this.ay(var1, bno[7], var13 + this.pg(var2), var14, -1, false);
      }
   }

   private void pi(DrawContext var1, int var2, int var3, int var4, int var5) {

      SlotEntry var6 = this.bps;
      String[] var7 = this.oc(var6);
      int var8 = var7.length;
      int var9 = Math.min(8, var8);
      int var10 = var2 + this.bpt;
      int var11 = var3 + this.bpu;
      int var12 = this.bpv;
      int var13 = var9 * 18 + 8;
      int var14 = od(var6);
      fq(var1, var10, var11, var12, var13, 8);
      bt(var1, (float)var10, (float)var11, (float)var12, (float)var13, 8.0F, -639857279 ^ 785029272, true, true, true, true);
      eu(var1, (float)var10, (float)var11, (float)var12, (float)var13, 8.0F, 2127555294 ^ 1630541089);

      for (int var15 = 0; var15 < var9; var15++) {
         int var16 = this.bpw + var15;
         if (var16 >= var8) {
            break;
         }

         int var17 = var11 + 4 + var15 * 18;
         boolean var18 = var4 >= var10 + 4 && var4 < var10 + var12 - 4 && var5 >= var17 && var5 < var17 + 18;
         if (var16 == var14 || var18) {
            bt(
               var1,
               (float)(var10 + 4),
               (float)var17,
               (float)(var12 - 8),
               18.0F,
               5.0F,
               var16 == var14 ? -555841826 ^ -920553183 : 1685022998 ^ 1804637929,
               true,
               true,
               true,
               true
            );
         }

         this.ay(var1, var7[var16], var10 + 12, ft((float)var17, 18.0F), var16 != var14 && !var18 ? amn : amm, false);
      }

      if (var8 > var9) {
         gf(var1, (float)(var10 + var12 - 6), (float)(var11 + 5), (float)(var13 - 10), (float)var9 / (float)var8, (float)this.bpw / (float)(var8 - var9));
      }
   }

   private void pj(DrawContext var1, int var2, int var3, int var4, int var5, String var6, InitAdapter var7, int var8, int var9) {

      et(var1, var2, var3, var4, var5, 10);
      ci(var1, (float)(var2 - 1), (float)(var3 - 1), (float)(var4 + 2), (float)(var5 + 2), 11.0F, true, true, true, true, this.ck());
      bu(var1, var2 - 1, var3 - 1, var4 + 2, var5 + 2, 11, aac);
      bu(var1, var2, var3, var4, var5, 10, yv ? cg(zz) : xt);
      bx(var1, var2 + 1, var3 + 1, var4 - 2, 20, 9, cg(aaa), true, true, false, false);
      bv(var1, var2 + 11, var3 + 1, var2 + var4 - 11, var3 + 2, n(-517190519 ^ -517190538, 2132451200 ^ 2132451199, 58641800 ^ 58641783, yv ? 22 : 14));
      bu(var1, var2 + 9, var3 + 8, 2, 8, 1, yf);
      if (var7 != null) {
         this.be(var1, var7.a, var7.aK, var2 + 16, var3 + 8, yi, false);
      } else {
         this.ay(var1, var6, var2 + 16, var3 + 8, yi, false);
      }

      bv(var1, var2 + 1, var3 + 20, var2 + var4 - 1, var3 + 21, aab);
      boolean var10 = var8 >= var2 + var4 - 18 && var8 <= var2 + var4 - 5 && var9 >= var3 + 6 && var9 <= var3 + 17;
      if (var10) {
         bu(var1, var2 + var4 - 18, var3 + 6, 13, 12, 4, aaf);
      }

      this.ay(var1, "×", var2 + var4 - 13, var3 + 7, var10 ? yi : yj, false);
   }

   private void pk(DrawContext var1, Object var2, int var3, int var4, int var5, int var6, boolean var7) {

      float var8 = var2 == null ? (var7 ? 1.0F : 0.0F) : this.da(var2, var7 ? 1.0F : 0.0F);
      bp(var1, var3, var4, var5, var6, var8 <= 0.0F ? yc : (var8 >= 1.0F ? yb : cq(yc, yb, var8)));
      bs(var1, (float)(var3 + 1) + var8 * (float)(var5 - var6), (float)(var4 + 1), (float)(var6 - 2), yi);
   }

   private void pl(DrawContext var1, int var2, int var3, int var4, int var5) {

      this.es(var1, var2, var3);
      BlockSetE var6 = this.adt;
      if (var6 != null) {
         BlockSetE.Opt[] var7 = BlockSetE.OPTIONS;
         int var8 = var7.length;
         int var9 = -526112437 ^ -526112269;
         int var10 = 28 + var8 * 16 + 16;
         int var11 = (var2 - var9) / 2;
         int var12 = (var3 - var10) / 2;
         this.pj(var1, var11, var12, var9, var10, null, var6, var4, var5);
         Set var13 = var6.ids();
         int var14 = var12 + 28;

         for (int var15 = 0; var15 < var8; var15++) {
            this.pm(var1, var11, var14, var9, var7[var15].a, var13.contains(var7[var15].id), var4, var5);
            var14 += 16;
         }

         String var16 = var13.isEmpty() ? "none = e" + "very block" : var13.size() + " " + "selected";
         this.ay(var1, var16, var11 + 10, var12 + var10 - 12, yk, false);
      }
   }

   private void pm(DrawContext var1, int var2, int var3, int var4, String var5, boolean var6, int var7, int var8) {

      boolean var9 = var7 >= var2 + 6 && var7 <= var2 + var4 - 6 && var8 >= var3 && var8 < var3 + 16;
      float var10 = this.cw(var5, var9);
      if (var10 > 0.01F) {
         bo(var1, var2 + 5, var3 + 1, var4 - 10, 14, var10 >= 1.0F ? xx : dk(xx, var10));
      }

      float var11 = Math.max(var10, var6 ? 1.0F : 0.0F);
      this.ay(var1, var5, var2 + 12, var3 + 4, var11 <= 0.0F ? yj : (var11 >= 1.0F ? yi : cq(yj, yi, var11)), false);
      byte var12 = 18;
      byte var13 = 9;
      int var14 = var2 + var4 - var12 - 8;
      int var15 = var3 + (16 - var13) / 2;
      this.pk(var1, var5, var14, var15, var12, var13, var6);
   }

   private void pn(int var1, int var2, int var3, int var4, int var5) {

      BlockSetE var6 = this.adt;
      if (var6 != null) {
         BlockSetE.Opt[] var7 = BlockSetE.OPTIONS;
         int var8 = var7.length;
         int var9 = 716860397 ^ 716860245;
         int var10 = 28 + var8 * 16 + 16;
         int var11 = (var1 - var9) / 2;
         int var12 = (var2 - var10) / 2;
         if (var3 >= var11 + var9 - 18 && var3 <= var11 + var9 - 5 && var4 >= var12 + 6 && var4 <= var12 + 17) {
            this.adt = null;
         } else if (var3 >= var11 && var3 <= var11 + var9 && var4 >= var12 && var4 <= var12 + var10) {
            if (var5 == 0) {
               int var13 = var12 + 28;

               for (int var14 = 0; var14 < var8; var14++) {
                  if (var4 >= var13 && var4 < var13 + 16 && var3 >= var11 + 6 && var3 <= var11 + var9 - 6) {
                     var6.a(var7[var14].id);
                     return;
                  }

                  var13 += 16;
               }
            }
         } else {
            this.adt = null;
         }
      }
   }

   private static int po(int var0, int var1) {

      return var1 == 3 ? var0 : 9 + var1 * 9 + var0;
   }

   private static int pp(int var0, int var1) {

      return var0 + 28 + var1 * 18 + (var1 == 3 ? 4 : 0);
   }

   private void pq(DrawContext var1, int var2, int var3, int var4, int var5) {

      this.es(var1, var2, var3);
      MaskEntry var6 = this.adu;
      if (var6 != null) {
         int var7 = 1134274468 ^ 1134274332;
         byte var8 = 126;
         int var9 = (var2 - var7) / 2;
         int var10 = (var3 - var8) / 2;
         this.pj(var1, var9, var10, var7, var8, null, var6, var4, var5);
         long var11 = var6.a_r92();
         PlayerInventory var13 = a.player != null ? a.player.getInventory() : null;
         boolean var14 = var13 != null && agi > 0.6F;

         for (int var15 = 0; var15 < 4; var15++) {
            int var16 = pp(var10, var15);

            for (int var17 = 0; var17 < 9; var17++) {
               int var18 = var9 + 11 + var17 * 18;
               int var19 = po(var17, var15);
               boolean var20 = (var11 & 1L << var19) != 0L;
               boolean var21 = var4 >= var18 && var4 < var18 + 18 && var5 >= var16 && var5 < var16 + 18;
               if (var20) {
                  bu(var1, var18 + 1, var16 + 1, 16, 16, 4, yd);
                  bu(var1, var18 + 2, var16 + 2, 14, 14, 3, var21 ? xx : xy);
                  bu(var1, var18 + 2, var16 + 2, 14, 14, 3, yq);
               } else {
                  bu(var1, var18 + 1, var16 + 1, 16, 16, 3, var21 ? xx : xy);
               }

               if (var14) {
                  ItemStack var22 = var13.getStack(var19);
                  if (!var22.isEmpty()) {
                     var1.drawItem(var22, var18 + 1, var16 + 1);
                     var1.drawStackOverlay(a.textRenderer, var22, var18 + 1, var16 + 1);
                  }
               }
            }
         }

         int var23 = var6.b();
         String var24 = var23 == 0 ? var6.e_r94() : var23 + brd[1];
         this.ay(var1, var24, var9 + 11, var10 + var8 - 14, yk, false);
         if (var23 > 0) {
            int var25 = this.bd(brd[0]);
            int var26 = var9 + var7 - 11 - var25;
            boolean var27 = var4 >= var26 - 4 && var4 <= var26 + var25 + 4 && var5 >= var10 + var8 - 17 && var5 <= var10 + var8 - 4;
            if (var27) {
               bu(var1, var26 - 4, var10 + var8 - 17, var25 + 8, 13, 4, aaf);
            }

            this.ay(var1, brd[0], var26, var10 + var8 - 14, var27 ? yi : yj, false);
         }
      }
   }

   private void pr(int var1, int var2, int var3, int var4, int var5) {

      MaskEntry var6 = this.adu;
      if (var6 != null) {
         int var7 = -1529657191 ^ -1529657311;
         byte var8 = 126;
         int var9 = (var1 - var7) / 2;
         int var10 = (var2 - var8) / 2;
         if (var3 >= var9 + var7 - 18 && var3 <= var9 + var7 - 5 && var4 >= var10 + 6 && var4 <= var10 + 17) {
            this.adu = null;
         } else if (var3 >= var9 && var3 <= var9 + var7 && var4 >= var10 && var4 <= var10 + var8) {
            if (var5 == 0) {
               for (int var11 = 0; var11 < 4; var11++) {
                  int var12 = pp(var10, var11);
                  if (var4 >= var12 && var4 < var12 + 18) {
                     for (int var13 = 0; var13 < 9; var13++) {
                        int var14 = var9 + 11 + var13 * 18;
                        if (var3 >= var14 && var3 < var14 + 18) {
                           var6.c(po(var13, var11));
                           return;
                        }
                     }
                  }
               }

               if (var6.b() > 0) {
                  int var15 = this.bd(brd[0]);
                  int var16 = var9 + var7 - 11 - var15;
                  if (var3 >= var16 - 4 && var3 <= var16 + var15 + 4 && var4 >= var10 + var8 - 17 && var4 <= var10 + var8 - 4) {
                     var6.d_r93();
                  }
               }
            }
         } else {
            this.adu = null;
         }
      }
   }

   private static int ps(int var0) {

      return var0 + 92;
   }

   private static int pt(int var0) {

      return var0 + 28 + 6 + 58;
   }

   private static double pu(int var0) {

      return (double)(var0 - (-1758141971 ^ -1758136675)) / 24000.0 * Math.PI * 2.0;
   }

   private static int pv(int var0, int var1) {

      return Math.floorMod(var0 - var1 + (-1018897049 ^ -1018891385), -517229709 ^ -517214541) - (708238191 ^ 708244879);
   }

   private static int pw(float var0) {

      float var1 = var0 < -0.05F ? 0.0F : (var0 > 0.35F ? 1.0F : (var0 + 0.05F) / 0.4F);
      int var2 = cq(-1143798373 ^ 1153900461, -1251277477 ^ 1241820595, var1 * var1 * (3.0F - 2.0F * var1));
      float var3 = 1.0F - Math.min(1.0F, Math.abs(var0) / 0.3F);
      return cq(var2, 1996204781 ^ -1995228750, var3 * 0.7F);
   }

   private static int px(int var0) {

      return var0 >= (2060101939 ^ 2060102363) && var0 < (-1947458823 ^ -1947465727)
         ? 4
         : (
            var0 >= (-1715739153 ^ -1715745001) && var0 < (955773575 ^ 955762235)
               ? 6
               : (var0 >= (1463690800 ^ 1463685772) && var0 < (-789690554 ^ -789704542) ? 5 : 7)
         );
   }

   private static int py(int var0, int var1, int var2, int var3, int var4) {

      int var5 = var2 - var0;
      int var6 = var3 - var1;
      if (var5 * var5 + var6 * var6 > (1845487732 ^ 1845491828)) {
         return 0;
      } else {
         double var7 = Math.atan2((double)var5, (double)(-var6));
         double var9 = pu(var4);
         double var11 = Math.abs(Math.IEEEremainder(var7 - var9, Math.PI * 2));
         double var13 = Math.abs(Math.IEEEremainder(var7 - var9 - Math.PI, Math.PI * 2));
         return var11 <= var13 ? 1 : 2;
      }
   }

   private void pz(DrawContext var1, int var2, int var3, int var4, int var5) {

      this.es(var1, var2, var3);
      DialEntry var6 = this.adv;
      if (var6 != null) {
         int var7 = 1162812991 ^ 1162813063;
         int var8 = 1692613332 ^ 1692613150;
         int var9 = (var2 - var7) / 2;
         int var10 = (var3 - var8) / 2;
         this.pj(var1, var9, var10, var7, var8, null, var6, var4, var5);
         int var11 = var6.a_r91();
         int var12 = ps(var9);
         int var13 = pt(var10);
         byte var14 = 58;
         double var15 = pu(var11);
         float var17 = (float)Math.sin(var15);
         float var18 = (float)Math.cos(var15);
         bq(var1, var12 - var14 - 2, var13 - var14 - 2, 2 * var14 + 4, aac);
         bq(var1, var12 - var14, var13 - var14, 2 * var14, pw(var18));

         for (byte var19 = 1; var19 < var14; var19 += 2) {
            int var20 = (int)Math.sqrt((double)(var14 * var14 - var19 * var19));
            bv(var1, var12 - var20, var13 + var19, var12 + var20, var13 + var19 + 2, -1016750035 ^ 1500425781);
         }

         bv(var1, var12 - var14 + 3, var13, var12 + var14 - 3, var13 + 1, -1716985674 ^ -11067575);

         for (int var38 = 0; var38 < 8; var38++) {
            double var40 = (double)var38 * Math.PI / 4.0;
            int var22 = var12 + (int)Math.round(Math.sin(var40) * (double)(var14 - 5));
            int var23 = var13 - (int)Math.round(Math.cos(var40) * (double)(var14 - 5));
            int var24 = var38 % 2 == 0 ? 3 : 2;
            bq(var1, var22 - var24 / 2, var23 - var24 / 2, var24, 1407050738 ^ -551412723);
         }

         int var39 = var14 - 13;
         int var41 = var12 + Math.round(var17 * (float)var39);
         int var21 = var13 - Math.round(var18 * (float)var39);
         int var42 = var12 - Math.round(var17 * (float)var39);
         int var43 = var13 + Math.round(var18 * (float)var39);
         int var44 = this.adw ? (this.adx ? 2 : 1) : py(var12, var13, var4, var5, var11);
         if (var44 == 1) {
            bq(var1, var41 - 11, var21 - 11, 22, o(yd, 110));
         } else if (var44 == 2) {
            bq(var1, var42 - 10, var43 - 10, 20, o(yd, 110));
         }

         bq(var1, var41 - 9, var21 - 9, 18, 265943063 ^ 1512456285);
         bq(var1, var41 - 6, var21 - 6, 12, -1332426338 ^ 1332419268);
         bq(var1, var42 - 6, var43 - 6, 12, -1552171082 ^ 1553815108);
         bq(var1, var42 - 3, var43 - 3, 3, 115327511 ^ -110397220);
         bq(var1, var42 + 1, var43 + 1, 2, -1592414659 ^ 1587614966);
         String var25 = DialEntry.c(var11);
         String var26 = bri[px(var11)];
         int var27 = this.bd(var25);
         int var28 = this.bd(var26);
         int var29 = var12 - (var27 + 6 + var28) / 2;
         int var30 = var10 + 28 + 2 * var14 + 18;
         this.ay(var1, var25, var29, var30, yi, false);
         this.ay(var1, var26, var29 + var27 + 6, var30, yk, false);
         int var31 = var10 + var8 - 26;
         int var32 = (var7 - 20 - 9) / 4;

         for (int var33 = 0; var33 < 4; var33++) {
            int var34 = var9 + 10 + var33 * (var32 + 3);
            boolean var35 = Math.abs(pv(var11, brj[var33])) < (1546903358 ^ 1546903492);
            boolean var36 = var4 >= var34 && var4 < var34 + var32 && var5 >= var31 && var5 < var31 + 16;
            bu(var1, var34, var31, var32, 16, 5, var35 ? yq : (var36 ? aaf : xy));
            String var37 = bri[var33];
            this.ay(var1, var37, var34 + (var32 - this.bd(var37)) / 2, var31 + 4, !var35 && !var36 ? yj : yi, false);
         }
      }
   }

   private void qa(int var1, int var2, int var3, int var4, int var5) {

      DialEntry var6 = this.adv;
      if (var6 != null) {
         int var7 = -2145769395 ^ -2145769227;
         int var8 = 360944518 ^ 360944460;
         int var9 = (var1 - var7) / 2;
         int var10 = (var2 - var8) / 2;
         if (var3 >= var9 + var7 - 18 && var3 <= var9 + var7 - 5 && var4 >= var10 + 6 && var4 <= var10 + 17) {
            this.adv = null;
         } else if (var3 < var9 || var3 > var9 + var7 || var4 < var10 || var4 > var10 + var8) {
            this.adv = null;
         } else if (var5 == 0) {
            int var11 = ps(var9);
            int var12 = pt(var10);
            int var13 = py(var11, var12, var3, var4, var6.a_r91());
            if (var13 != 0) {
               this.adw = true;
               this.adx = var13 == 2;
               this.qb(var11, var12, var3, var4);
            } else {
               int var14 = var10 + var8 - 26;
               int var15 = (var7 - 20 - 9) / 4;
               if (var4 >= var14 && var4 < var14 + 16) {
                  for (int var16 = 0; var16 < 4; var16++) {
                     int var17 = var9 + 10 + var16 * (var15 + 3);
                     if (var3 >= var17 && var3 < var17 + var15) {
                        var6.b((double)brj[var16]);
                        return;
                     }
                  }
               }
            }
         }
      }
   }

   private void qb(int var1, int var2, int var3, int var4) {

      DialEntry var5 = this.adv;
      if (var5 != null && (var3 != var1 || var4 != var2)) {
         double var6 = Math.atan2((double)(var3 - var1), (double)(-(var4 - var2)));
         if (this.adx) {
            var6 += Math.PI;
         }

         var5.b(var6 / (Math.PI * 2) * 24000.0 + 6000.0);
      }
   }

   private void qc(int var1, int var2, int var3, int var4) {

      this.qb(ps((var1 - (2045976050 ^ 2045975882)) / 2), pt((var2 - (1673821337 ^ 1673821267)) / 2), var3, var4);
   }

   private void qd(DrawContext var1, int var2, int var3, int var4, int var5) {

      NodeZoneRenderer var6 = this.acx;
      double var7 = var6.x(this.acy);
      double var9 = var6.y(this.acy);
      int var11 = (int)(var7 * (double)var2);
      int var12 = (int)(var9 * (double)var3);
      var6.db(this.acy, var1, var11, var12);
      int[] var13 = var6.aa(this.acy);
      int var14 = var13[0];
      int var15 = var13[1];
      boolean var16 = var4 >= var11 - var14 && var4 <= var11 + var14 && var5 >= var12 - var15 && var5 <= var12 + var15;
      if (var16 || this.acz) {
         eu(var1, (float)(var11 - var14), (float)(var12 - var15), (float)(2 * var14), (float)(2 * var15), 6.0F, o(yd, 300121710 ^ 300121796));
      }

      String var17 = new StringBuilder(8).append((int)(var7 * 100.0)).append(',').append(' ').append((int)(var9 * 100.0)).toString();
      this.ay(var1, var17, var11 - this.bd(var17) / 2, var12 + var15 + 3, amo, false);
   }

   private void qe(DrawContext var1, int var2) {

      String var3 = bno[14];
      String var4 = bno[20];
      int var5 = this.bd(var3) + 10 + this.bd(var4) + 28;
      int var6 = (var2 - var5) / 2;
      byte var7 = 14;
      fq(var1, var6, var7, var5, 24, 12);
      bt(var1, (float)var6, (float)var7, (float)var5, 24.0F, 12.0F, 1191465676 ^ -1340979243, true, true, true, true);
      eu(var1, (float)var6, (float)var7, (float)var5, 24.0F, 12.0F, -917361286 ^ -693251451);
      this.ay(var1, var3, var6 + 14, ft((float)var7, 24.0F), amm, false);
      this.ay(var1, var4, var6 + 24 + this.bd(var3), ft((float)var7, 24.0F), amo, false);
   }

   private void qf(int var1, int var2, int var3, int var4, int var5) {

      if ((var5 == 0 || var5 == 1) && this.nb()) {
         this.ni(var1, var2);
         int var6 = this.boi;
         int var7 = this.boj;
         int var8 = this.bok;
         int var9 = this.bol;
         NodeZoneRenderer var10 = this.acx;
         this.bql = false;
         if (this.bpp) {
            if (var5 == 0 && this.qq(var10, var1, var2, var3, var4)) {
               this.acz = true;
            } else {
               this.bpp = false;
            }
         } else if (this.bps != null) {
            this.ql(var6, var7, var3, var4, var5);
         } else if (var3 >= var6 && var3 < var6 + var8 && var4 >= var7 && var4 < var7 + var9) {
            if (var5 == 0 && ol(var6, var7, var8, var3, var4)) {
               this.nc();
            } else {
               NodeZoneRenderer.Vis[] var11 = this.nd();
               int var12 = this.acy >= 0 && this.acy < var11.length ? this.acy : 0;
               int var13 = var7 + 44;
               int var14 = var7 + var9 - 32;
               int var15 = var6 + (-1409766570 ^ -1409766464) + 12;
               if (var4 >= var7 + var9 - 24 && var3 >= var15) {
                  if (var5 == 0) {
                     this.qn(var11[var12], var6, var7, var8, var9, var3, var4);
                  }
               } else if (var4 >= var13) {
                  if (var3 < var6 + (1888958899 ^ 1888958757)) {
                     this.qg(var11, var6, var13, var7 + var9, var3, var4, var5);
                  } else {
                     if (var3 >= var15 && var4 < var14) {
                        this.qh(var11[var12], var12, var2, var15, var13 + 3, var6 + var8, var14 - 3, var3, var4, var5);
                     }
                  }
               }
            }
         } else {
            if (var5 == 0) {
               this.nc();
            }
         }
      }
   }

   private void qg(NodeZoneRenderer.Vis[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {

      int var8 = var1.length * 28 - 4 - (var4 - var3);
      int var9 = this.nm();
      int var10 = var8 > 0 ? this.np(var6, this.no(0, var8, var9), var9) : var6;
      int var11 = var10 - var3;
      if (var11 >= 0 && var5 >= var2 && var5 < var2 + (-1406532184 ^ -1406532290)) {
         int var12 = var11 / 28;
         if (var12 < var1.length && var11 - var12 * 28 < 24) {
            CheckerBridge var13 = var1[var12].b;
            if (var7 == 0 && var13 != null && var5 >= var2 + (2049223801 ^ 2049223919) - 34) {
               var13.a(!var13.f());
            } else {
               this.ne(var12);
            }
         }
      }
   }

   private void qh(NodeZoneRenderer.Vis var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {

      this.nv(var3);
      int var11 = 13 + this.boh - (var7 - var5);
      int var12 = this.nm();
      int var13 = var11 > 0 ? this.no(1, var11, var12) : 0;
      int var14 = var13 > 0 ? this.np(var9, var13, var12) : var9;
      int var15 = var4 + 16;
      int var16 = var6 - var4 - 32;
      int var17 = var5 + 13;
      CheckerBridge var18 = var1.b;
      if (var10 == 0 && var18 != null && var8 >= var15 + var16 - 26 && var8 < var15 + var16 + 4 && var14 >= var17 && var14 < var17 + 20) {
         var18.a(!var18.f());
      } else {
         for (int var19 = 0; var19 < this.bog; var19++) {
            int var20 = var17 + this.boe[var19];
            int var21 = this.bof[var19];
            if (var14 >= var20 && var14 < var20 + var21) {
               int var22 = this.boc[var19];
               if (var22 == 4) {
                  if (var10 == 0 && this.bqn && var21 > 84 && var8 >= var15 && var8 < var15 + var16) {
                     this.bql = true;
                     this.bqm = this.al(var8);
                  }
               } else if (var22 == 1) {
                  this.qi(var1.c[this.bod[var19]], var15, var20, var16, var21, var8, var14, var10, (float)var13 / (float)var12);
               } else if (var10 == 0 && var8 >= this.pe(var15, var16, var22 == 2 ? 10 : 9) && var8 < var15 + var16) {
                  float var23 = (float)var20 + (float)(var21 - 22) * 0.5F;
                  if ((float)var14 >= var23 && (float)var14 < var23 + 22.0F) {
                     if (var22 == 2) {
                        this.qo();
                     } else {
                        this.qp();
                     }
                  }
               }

               return;
            }
         }
      }
   }

   private void qi(InitAdapter var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, float var9) {

      int var10 = var2 + var4 - (-1225715500 ^ -1225715632);
      float var11 = (float)var3 + (float)(var5 - 20) * 0.5F;
      if (var8 == 1) {
         if (var1 instanceof SlotEntry var17) {
            List var18 = var17.g();
            if (!var18.isEmpty()) {
               int var19 = Math.max(0, var18.indexOf(var17.f()));
               var17.a(var18.get((var19 - 1 + var18.size()) % var18.size()));
            }
         }
      } else {
         if (var1 instanceof CheckerBridge var12) {
            var12.g();
         } else if (var1 instanceof SlotEntry var13) {
            int var15 = this.oc(var13).length;
            if (var15 > 0 && var15 <= 3) {
               int var16 = gb((float)var10, var11, 132.0F, 20.0F, var15, var6, var7);
               if (var16 >= 0) {
                  var13.a(var13.g().get(var16));
               } else {
                  var13.h();
               }
            } else if (var15 > 0) {
               this.qk(var13, (float)var10, var11 - var9);
            }
         } else if (var1 instanceof DialEntry) {
            this.so(var1, var6, var7, var3, var2, var4, 0);
         } else if (var1 instanceof BlockCalculator var14) {
            this.qj(var14, var2, var3, var4, var5, var6, var7);
         } else {
            this.so(var1, var6, var7, var3, var2, var4, 0);
         }
      }
   }

   private void qj(BlockCalculator var1, int var2, int var3, int var4, int var5, int var6, int var7) {

      int var8 = var2 + var4 - (-2074869363 ^ -2074869495);
      if (ob(var1)) {
         int var13 = (int)Math.round((var1.j() - var1.i()) / var1.k()) + 1;
         int var14 = gb((float)var8, (float)var3 + (float)(var5 - 20) * 0.5F, 132.0F, 20.0F, var13, var6, var7);
         if (var14 >= 0) {
            var1.a(var1.i() + (double)var14 * var1.k());
         }
      } else {
         int var9 = var1 instanceof SpanEntry ? 52 : 34;
         int var10 = (-1363313027 ^ -1363312903) - var9;
         if (var6 >= var2 + var4 - var9) {
            this.sr(var1);
         } else {
            if (var6 >= var8 - 6 && var6 <= var8 + var10 + 6) {
               float var11 = this.al(var6);
               if (var1 instanceof SpanEntry var12) {
                  this.sp(var12, var11, var8, var10);
               }

               this.ace = var1;
               this.acf = var8 - 12;
               this.acg = var10 + 24;
               this.sx(var1, var11, var8 - 12, var10 + 24);
            }
         }
      }
   }

   private void qk(SlotEntry var1, float var2, float var3) {

      int var4 = this.oc(var1).length;
      int var5 = Math.min(8, var4);
      int var6 = var5 * 18 + 8;
      int var7 = Math.round(var3) + 23;
      if (var7 + var6 > this.boj + this.bol - 6) {
         var7 = Math.max(this.boj + 6, Math.round(var3) - 3 - var6);
      }

      this.bps = var1;
      this.bpt = Math.round(var2) - this.boi;
      this.bpu = var7 - this.boj;
      this.bpv = 536866821 ^ 536866945;
      this.bpw = Math.max(0, Math.min(var4 - var5, od(var1) - var5 / 2));
   }

   private void ql(int var1, int var2, int var3, int var4, int var5) {

      SlotEntry var6 = this.bps;
      this.bps = null;
      int var7 = this.oc(var6).length;
      int var8 = Math.min(8, var7);
      int var9 = var1 + this.bpt;
      int var10 = var2 + this.bpu;
      if (var5 == 0 && var3 >= var9 && var3 < var9 + this.bpv && var4 >= var10 + 4 && var4 < var10 + 4 + var8 * 18) {
         int var11 = this.bpw + (var4 - var10 - 4) / 18;
         List var12 = var6.g();
         if (var11 >= 0 && var11 < var12.size()) {
            var6.a(var12.get(var11));
         }
      }
   }

   private void qm(int var1, int var2, int var3, int var4, int var5) {

      int var6 = this.oc(this.bps).length;
      int var7 = Math.min(8, var6);
      int var8 = var1 + this.bpt;
      int var9 = var2 + this.bpu;
      if (var6 > var7 && var3 >= var8 && var3 < var8 + this.bpv && var4 >= var9 && var4 < var9 + var7 * 18 + 8) {
         int var10 = this.bpw + (var5 < 0 ? 1 : -1);
         this.bpw = var10 < 0 ? 0 : (var10 > var6 - var7 ? var6 - var7 : var10);
      }
   }

   private void qn(NodeZoneRenderer.Vis var1, int var2, int var3, int var4, int var5, int var6, int var7) {

      boolean var8 = this.ada != null;
      this.pf(var1, var2, var3, var4, var5, var8);
      int var9 = this.bos;
      if (var7 >= var9 && var7 < var9 + 24) {
         if (var6 >= this.boq && var6 < this.boq + this.bor) {
            this.nc();
         } else if (var8 && var6 >= this.boo && var6 < this.boo + this.bop) {
            this.qp();
         } else {
            if (var6 >= this.bom && var6 < this.bom + this.bon) {
               if (this.og()) {
                  NodeZoneRenderer var10 = this.acx;
                  if (var10 != null) {
                     var10.ab(this.acy);
                  } else {
                     this.ada.b_r101(this.acy);
                  }

                  this.bqu = 0L;
               } else {
                  this.bqu = System.nanoTime() / 1000000L;
               }
            }
         }
      }
   }

   private void qo() {

      if (this.adz != 0) {
         this.va();
      }

      this.bpp = true;
      this.bps = null;
   }

   private void qp() {

      this.nc();
      if (!SyncController.s) {
         SyncController.s = true;
         if (this.adz != 0) {
            this.va();
         }

         NoticeQueue.a(adb[4], adb[5]);
      }
   }

   private boolean qq(NodeZoneRenderer var1, int var2, int var3, int var4, int var5) {

      if (this.adz == 0 && var1 != null && var1.w(this.acy)) {
         int var6 = (int)(var1.x(this.acy) * (double)var2);
         int var7 = (int)(var1.y(this.acy) * (double)var3);
         int[] var8 = var1.aa(this.acy);
         return var4 >= var6 - var8[0] && var4 <= var6 + var8[0] && var5 >= var7 - var8[1] && var5 <= var7 + var8[1];
      } else {
         return false;
      }
   }

   private static String qr(int var0) {

      if (var0 < 0) {
         return abq[0];
      } else {
         switch (var0) {
            case 0:
               return abq[7];
            case 1:
               return abq[8];
            case 2:
               return abq[9];
            case 32:
               return abq[5];
            case 258:
               return abq[6];
            case 340:
               return abq[2];
            case 341:
               return abq[4];
            case 344:
               return abq[1];
            case 345:
               return abq[3];
            default:
               if (var0 >= 3 && var0 <= 7) {
                  return abq[10] + (var0 + 1);
               } else {
                  String var1 = GLFW.glfwGetKeyName(var0, 0);
                  return var1 != null ? var1.toUpperCase() : abq[11] + var0;
               }
         }
      }
   }

   public boolean mouseClicked(Click var1, boolean var2) {

      boolean var3 = this.adz != 0 ? this.wx(var1) : this.qs(var1, var2);
      if (var3) {
         p(1.7F);
      }

      return var3;
   }

   private boolean qs(Click var1, boolean var2) {

      int var3 = this.t(var1.x());
      int var4 = this.u(var1.y());
      this.ack = (float)(var1.x() / (double)this.q());
      this.ajq = (float)(var1.y() / (double)this.q());
      int var5 = var1.button();
      int var6 = this.r();
      int var7 = this.s();
      int var8 = this.uh();
      if (var8 >= 0 && this.bsk[var8] < 0.999F) {
         var3 = this.uf(var8, var3, var6);
         var4 = this.ug(var8, var4);
      }

      if (SyncController.s && var5 == 0 && this.act == null && !this.adi && !this.adj && !this.nb() && this.adt == null && this.adu == null && this.adv == null
         )
       {
         try {
            if (ConfigBridge.c != null && ConfigBridge.c.c() != null) {
               CoreZoneProcessor var9 = ConfigBridge.c.c().a(CoreZoneProcessor.class);
               if (var9 != null && var9.f()) {
                  int var10 = var9.z((int)var1.x(), (int)var1.y());
                  if (var10 != -1) {
                     this.acs = var10;
                     return true;
                  }
               }
            }
         } catch (Throwable var13) {
         }
      }

      if (this.act == null) {
         if (this.acr != null) {
            this.tc(var5);
            return true;
         } else if (!this.adi && !this.adj) {
            if (this.nb()) {
               this.bqd = (float)(var1.y() / (double)this.q());
               this.qf(var6, var7, var3, var4, var5);
               return true;
            } else if (this.adt != null) {
               this.pn(var6, var7, var3, var4, var5);
               return true;
            } else if (this.adu != null) {
               this.pr(var6, var7, var3, var4, var5);
               return true;
            } else if (this.adv != null) {
               this.qa(var6, var7, var3, var4, var5);
               return true;
            } else {
               this.ej(var6);
               if (this.em(var3, var4)) {
                  if (var5 == 1 && var3 >= this.adc && var3 <= this.adc + this.ade) {
                     adg = !adg;
                     return true;
                  } else {
                     this.abx = false;

                     for (int var16 = 0; var16 < abn.length; var16++) {
                        if (var5 == 0 && var3 >= this.alf[var16] && var3 < this.alf[var16] + this.alg[var16]) {
                           if (var16 == 0) {
                              if (ConfigBridge.c != null) {
                                 ConfigBridge.c.Z9();
                              }

                              this.close();
                           } else if (var16 == 1) {
                              this.adi = true;
                           } else {
                              this.uq();
                           }

                           return true;
                        }
                     }

                     return true;
                  }
               } else if (this.um(var6, var3, var4)) {
                  return true;
               } else {
                  this.abx = false;
                  if (!this.aby.isEmpty()) {
                     this.un(var6, var3, var4, var5);
                     return true;
                  } else {
                     for (ParserEngine var20 : xs) {
                        if (this.sk(var20, var3, var4, var5)) {
                           return true;
                        }
                     }

                     return super.mouseClicked(var1, var2);
                  }
               }
            }
         } else {
            this.qt(var6, var7, var3, var4, var5);
            return true;
         }
      } else {
         int var14 = -1798224215 ^ -1798224321;
         byte var17 = 62;
         int var11 = (var6 - var14) / 2;
         int var12 = (var7 - var17) / 2;
         if (var3 < var11 || var3 > var11 + var14 || var4 < var12 || var4 > var12 + var17) {
            this.st();
            this.sw();
         }

         return true;
      }
   }

   private void qt(int var1, int var2, int var3, int var4, int var5) {

      if (var5 == 0 || this.adj) {
         int var6 = this.fl(var1);
         int var7 = this.fm(var2);
         int var8 = this.fj();
         int var9 = this.fk();
         if (this.fx(var6, var7, var3, var4)) {
            this.adi = false;
            this.adj = false;
            this.adr = false;
            this.bbi = false;
            this.bci = false;
         } else {
            if (this.adj) {
               this.qw(var6, var7, var8, var9, var3, var4, var5);
            } else if (this.adi) {
               this.qu(var6, var7, var3, var4);
            }
         }
      }
   }

   private void qu(int var1, int var2, int var3, int var4) {

      int var5 = this.fj();
      int var6 = this.fk();
      if (var3 >= var1 && var3 < var1 + var5 && var4 >= var2 && var4 < var2 + var6) {
         int var7 = var2 + var6 - 28;
         if (var4 >= var7) {
            if (var3 >= var1 + 5 && var3 < var1 + 5 + this.ic() && var4 >= var7 + 5 && var4 < var7 + 23) {
               if (this.gz()) {
                  this.arw = 0L;
                  this.fe();
               } else {
                  this.arw = System.nanoTime() / 1000000L;
               }
            }
         } else {
            this.arw = 0L;
            if (var4 < var2 + 30) {
               if (this.art == 1 && var3 < var1 + this.id()) {
                  this.hl(false);
               }
            } else {
               int var8 = he(var2);
               if (var4 >= var2 + 30 && var4 < var2 + var6 - 28 && this.hk()) {
                  if (this.art == 1) {
                     this.qv(var1, var8 - this.arq, var3, this.dg(var4, this.arr));
                  } else {
                     var4 = this.hg(var4);
                     int var9 = this.hh(var2, var4);
                     if (var9 >= 0) {
                        int var10 = apt[var9 * 3];
                        int var11 = apt[var9 * 3 + 1];
                        int var12 = apt[var9 * 3 + 2];
                        int var13 = this.hf(var2, var9);
                        if (var12 < 0 || ie(var12)) {
                           if (var10 == 2) {
                              this.hl(true);
                           } else if (var10 == 5) {
                              this.ey(var11);
                           } else if (var10 == 6 || var10 == 9) {
                              int var16 = this.hr(var1, var13, var11, var10, var3, var4);
                              if (var16 >= 0) {
                                 if (var11 == 27) {
                                    this.je(var3, var1);
                                    this.adl = this.adz != 0;
                                 } else {
                                    this.ez(var11, var16);
                                 }
                              }
                           } else if (var10 == 7 || var10 == 10) {
                              if (var3 >= hs(var1, var10) - 6 && var3 <= ht(var1, var10) + 6) {
                                 this.arx = var11;
                                 this.fb(var11, this.al(var3), var1);
                              }
                           } else if (var10 == 8) {
                              ItemDescriptor var14 = ta();
                              if (var14 != null) {
                                 this.acr = var14;
                                 var14.a(true);
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      } else {
         this.arw = 0L;
      }
   }

   private void qv(int var1, int var2, int var3, int var4) {

      int var5 = hu(var1, var2 + 21, var3, var4);
      if (var5 >= 0) {
         boolean var9 = ThemeCache.o == 7;
         dj();
         ThemeCache.o = var5;
         applyTheme();
         h();
         if (var5 == 7 && !var9) {
            this.aro = this.hd();
         }
      } else if (ThemeCache.o == 7) {
         int var6 = var2 + 123;
         int var7 = hw(var1, var6 - 10, var3, var4);
         if (var7 >= 0) {
            this.arv = var7;
         } else {
            int var8 = ia(var1, var6, var3, var4);
            if (var8 >= 0) {
               this.adm = this.arv * 3 + var8;
               this.jg(var1, var6, this.al(var3), (float)var4 + 0.5F);
            }
         }
      }
   }

   private void qw(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {

      boolean var8 = this.bbc != 0;
      this.jq();
      this.lr(var1, var2);
      if (this.bmc) {
         this.lm(28, this.bmd, this.bme, this.bmf, this.bdm ? 22.0F : 24.0F);
      }

      if (var7 == 1) {
         if (var8) {
            int var14 = this.kp(var1, var2, var5, var6);
            int var15 = var14 >= 0 && this.bek[var14] == 3 ? this.bel[var14] : -1;
            BundleSync.Entry var16 = var15 >= 0 && var15 < this.bdu.size() ? this.bdu.get(var15) : null;
            if (var16 != null) {
               this.bbd = var16.id;
               if (var16.c) {
                  this.rd(var16);
               } else {
                  NoticeQueue.a(bbb[2], bbb[6]);
               }
            }
         }
      } else if (var7 == 0) {
         int var9 = this.jv(var1, var2, var5, var6);
         if (var9 >= 0) {
            this.ra(var9);
         } else {
            int var10 = this.ln(var5, var6);
            if (var10 >= 0) {
               this.rf(var10, var8);
            } else if (this.bkg
               && (float)var5 >= this.bkr
               && (float)var5 < this.bkr + this.bkt
               && (float)var6 >= this.bks
               && (float)var6 < this.bks + (float)(this.bdm ? 22 : 24)) {
               this.qx();
               this.bci = true;
            } else {
               int var11 = this.mc(var1, var2, var5, var6);
               if (var11 >= 0) {
                  if (var8) {
                     bck = var11;
                  } else {
                     bcj = var11;
                  }

                  this.jn();
               } else if (this.bkd
                  && (float)var5 >= this.bkh
                  && (float)var5 < this.bkh + this.bkj
                  && (float)var6 >= this.bki
                  && (float)var6 < this.bki + this.bkk) {
                  this.qx();
                  if (this.bbj == 3) {
                     this.bbi = true;
                  } else {
                     this.adr = true;
                  }
               } else if (this.bke && (float)var5 >= this.bkl && (float)var5 < this.bkl + this.bkn && (float)var6 >= this.bkm && (float)var6 < this.bkm + 24.0F
                  )
                {
                  if (this.bbj == 3) {
                     this.bbh = !this.bbh;
                  } else {
                     this.bbe = !this.bbe;
                  }

                  this.qx();
               } else if (this.bkf
                  && this.bbj == 0
                  && (float)var5 >= this.bko
                  && (float)var5 < this.bko + this.bkq
                  && (float)var6 >= this.bkp
                  && (float)var6 < this.bkp + 16.0F) {
                  this.bbn = !this.bbn;
                  this.bbo = 0;
                  this.bbr = 0.0F;
                  this.bbu = 0;
                  this.bbs = 0.0F;
               } else {
                  int var12 = var2 + this.bdg;
                  if (var5 >= var1 + 16 && var5 < var1 + 16 + this.bdi && var6 >= var12 + 22 && var6 < var12 + this.bdh) {
                     this.qx();
                     int var13 = this.kp(var1, var2, var5, var6);
                     if (var13 >= 0 && (this.bek[var13] == 3 || this.bek[var13] == 0)) {
                        this.qy(var13);
                     }
                  } else {
                     this.qx();
                  }
               }
            }
         }
      }
   }

   private void qx() {

      this.adr = false;
      this.bbi = false;
      this.bci = false;
   }

   private void qy(int var1) {

      if (var1 >= 0 && var1 < this.ber) {
         int var2 = this.bek[var1];
         if (var2 == 0) {
            if (!this.bcg) {
               this.bbn = false;
            }

            this.bcg = true;
         } else {
            if (var2 != 3) {
               return;
            }

            int var3 = this.bel[var1];
            if (this.bbc != 0) {
               if (var3 < 0 || var3 >= this.bdu.size()) {
                  return;
               }

               BundleSync.Entry var4 = this.bdu.get(var3);
               if (!var4.id.equals(this.bbd)) {
                  this.bbn = false;
               }

               this.bbd = var4.id;
            } else {
               if (var3 < 0 || var3 >= this.ado.size()) {
                  return;
               }

               String var5 = this.ado.get(var3);
               if (this.bcg || !var5.equals(this.adp)) {
                  this.bbn = false;
               }

               this.adp = var5;
               this.bcg = false;
            }
         }

         this.rb();
      }
   }

   private void qz(int var1) {

      int var2 = this.kq();
      int var3 = this.ber;
      int var4 = var2 < 0 ? (var1 > 0 ? -1 : var3) : var2;
      int var5 = 0;

      while (var5 <= var3) {
         var4 += var1;
         if (var4 >= 0 && var4 < var3) {
            if (this.bek[var4] != 3 && this.bek[var4] != 0) {
               var5++;
               continue;
            }

            this.qy(var4);
            int var6 = this.jr() - 22;
            int var7 = this.bem[var4];
            int var8 = this.ben[var4];
            if (var7 < this.ady) {
               boolean var9 = var4 > 0 && (this.bek[var4 - 1] == 1 || this.bek[var4 - 1] == 2);
               this.ady = Math.max(0, var9 ? this.bem[var4 - 1] : (var4 == 0 ? 0 : var7));
            } else if (var7 + var8 > this.ady + var6) {
               this.ady = var7 + var8 - var6;
            }

            return;
         }

         return;
      }
   }

   private void ra(int var1) {

      if (this.bbc != var1) {
         this.bbc = var1;
         this.jn();
         this.bbv = 0.0F;
         this.qx();
         this.bch = "";
         this.rb();
         this.bbn = false;

         for (Object var5 : blo) {
            this.aiw.removeFloat(var5);
         }

         if (var1 != 0 && BundleSync.LIST.isEmpty() && !BundleSync.ad) {
            BundleSync.j(true);
         }
      }
   }

   private void rb() {

      this.bbj = 0;
      this.bbl = false;
      this.bbf = "";
      this.bbk = "";
      this.bbi = false;
      this.adr = false;
   }

   private void rc(int var1, String var2) {

      this.rb();
      this.bci = false;
      this.bbn = false;
      this.bbj = var1;
      this.adq = var2;
      this.adr = true;
      this.aiw.removeFloat(bjy[11]);
      this.aiw.removeFloat(bjy[12]);
   }

   private void rd(BundleSync.Entry var1) {

      this.bbd = var1.id;
      this.bbf = var1.id;
      this.bbg = var1.a;
      this.bbh = abp[0].equals(var1.b);
      this.qx();
      this.bbj = 3;
      this.bbl = false;
      this.bbn = false;
      this.aiw.removeFloat(bjy[13]);
      this.aiw.removeFloat(bjy[14]);
      this.aiw.removeFloat(bjy[15]);
      this.aiw.removeFloat(bjy[16]);
      this.aix.removeFloat(bln);
   }

   private void re(boolean var1) {

      String var2;
      if (var1) {
         if (!this.jy()) {
            this.rw(false, true);
            return;
         }

         var2 = this.ka();
      } else {
         if (this.bcg || this.adp.isEmpty()) {
            return;
         }

         var2 = this.adp;
      }

      this.bbl = true;
      this.bbn = false;
      this.qx();
      this.bbm = this.ex(atq[48] + var2 + atq[47], this.bdk - 24);
      this.aiw.removeFloat(bjy[9]);
      this.aiw.removeFloat(bjy[10]);
   }

   private void rf(int var1, boolean var2) {

      switch (var1) {
         case 0:
         case 3:
            int var3 = var1 == 0 ? 1 : 2;
            if (this.bbj == var3) {
               this.rb();
            } else {
               this.rc(var3, "");
            }
            break;
         case 1:
            this.se(3);
            break;
         case 2:
            this.se(4);
            break;
         case 4:
            this.sd(5);
            break;
         case 5:
            this.rw(true, var2);
            break;
         case 6:
            this.se(2);
            break;
         case 7:
         case 16:
            this.re(var2);
            break;
         case 8:
            BundleSync.Entry var4 = this.jx();
            if (var4 != null && var4.c) {
               this.rd(var4);
            }
            break;
         case 9:
            this.bbl = false;
            break;
         case 10:
            this.bbl = false;
            this.rw(false, var2);
            if (var2) {
               this.bbj = 0;
               this.bbf = "";
               this.bbi = false;
            }
            break;
         case 11:
            this.rg(var2);
            break;
         case 12:
            this.rb();
            break;
         case 13:
            this.rh(1);
            break;
         case 14:
            this.rh(0);
            break;
         case 15:
            this.rh(3);
            break;
         case 17:
         default:
            this.ra(1);
            break;
         case 18:
         case 28:
            this.rx();
            break;
         case 19:
            this.rc(1, "");
            break;
         case 20:
            if (this.bhh > 0 && this.kv() >= 0) {
               this.rv(bcd, true);
            }
            break;
         case 21:
            this.jo(true, bbb[57]);
            break;
         case 22:
            this.rs();
            break;
         case 23:
            if (this.kb() >= 0) {
               this.rc(4, this.adp);
               this.bbk = this.adp;
            }
            break;
         case 24:
            this.rz();
            break;
         case 25:
            this.sa();
            break;
         case 26:
            this.sb();
            break;
         case 27:
            this.sc();
      }
   }

   private void rg(boolean var1) {

      if (this.bbj == 4) {
         this.ry();
      } else if (this.sf(var1)) {
         this.bbj = 0;
      }
   }

   private void rh(int var1) {

      String var2 = this.bbf;
      String var3 = this.bbg.trim().isEmpty() ? this.ka() : this.bbg.trim();
      if (var1 == 0) {
         boolean var4 = false;
         if (!var3.equals(this.ka())) {
            BundleSync.p(var2, var3);
            var4 = true;
         }

         if (this.bbh != this.jz()) {
            BundleSync.q(var2, this.bbh);
            var4 = true;
         }

         if (!var4) {
            NoticeQueue.a(bbb[24], bbb[25]);
         } else {
            this.jo(true, bbb[33] + var3);
         }
      } else if (var1 == 1) {
         BundleSync.k(this.ka(), this.bbh);
         this.jo(true, bbb[34] + this.ka());
      }

      this.bbf = "";
      this.bbi = false;
      this.bbj = 0;
   }

   private boolean ri(int var1, int var2) {

      this.jq();
      boolean var3 = this.bbc != 0;
      if ((var2 & 1) != 0) {
         return this.rj(var1, var2, var3);
      } else if (var1 != (1366095510 ^ 1366095767) && var1 != (64200834 ^ 64201165)) {
         if (var1 == (1045901246 ^ 1045900987)) {
            if (!this.bbl && this.bbj == 0) {
               this.re(var3);
            }

            return true;
         } else if (var1 != (-81944052 ^ -81943803) && var1 != (1876639507 ^ 1876639259)) {
            return false;
         } else {
            if (!this.bbl && this.bbj == 0) {
               this.qz(var1 == (1727246269 ^ 1727246005) ? 1 : -1);
            }

            return true;
         }
      } else {
         if (this.bbl) {
            this.rf(10, var3);
         } else if (this.bbj == 1 || this.bbj == 2 || this.bbj == 4) {
            this.rg(var3);
         } else if (this.bbj == 3) {
            this.rh(0);
         } else if (!var3 && this.bcg) {
            if (this.bhh > 0 && this.kv() >= 0) {
               this.rx();
            }
         } else if (var3 ? !this.bbd.isEmpty() : this.kb() >= 0) {
            this.rw(true, var3);
         }

         return true;
      }
   }

   private boolean rj(int var1, int var2, boolean var3) {

      boolean var4 = this.adr || this.bbi || this.bci;
      if (var1 != 83) {
         if ((var2 & 4) == 0 && var1 != 86) {
            if ((var2 & 2) == 0 && var1 != 67) {
               if (var1 == 90) {
                  if (!var4) {
                     this.rs();
                  }

                  return true;
               } else if (var1 == 70) {
                  if (this.bkg) {
                     this.qx();
                     this.bci = true;
                  }

                  return true;
               } else {
                  return false;
               }
            } else {
               if (!var4 && !var3 && this.bbj == 0) {
                  this.se(2);
               }

               return true;
            }
         } else {
            if (var4) {
               this.rn();
            } else if (this.bbj == 0 && !this.bbl) {
               this.se(3);
            }

            return true;
         }
      } else {
         if (this.bbj == 1 || this.bbj == 2 || this.bbj == 4) {
            this.rg(var3);
         } else if (this.bbj == 3) {
            this.rh(0);
         } else if (this.kv() >= 0 && this.bhh > 0) {
            this.rx();
         } else {
            this.ra(0);
            this.rc(1, "");
         }

         return true;
      }
   }

   private void rk(int var1, int var2) {

      if ((var2 & 1) != 0) {
         this.ri(var1, var2);
      } else {
         boolean var3 = var1 == (-32403275 ^ -32403020) || var1 == (396305814 ^ 396305625);
         if (this.bbi) {
            if (var1 == (-450131907 ^ -450131650)) {
               if (!this.bbg.isEmpty()) {
                  this.bbg = this.bbg.substring(0, this.bbg.length() - 1);
               }
            } else if (var3) {
               this.bbi = false;
               this.rh(0);
            }
         } else if (this.adr) {
            if (var1 == (192782603 ^ 192782344)) {
               if (!this.adq.isEmpty()) {
                  this.adq = this.adq.substring(0, this.adq.length() - 1);
               }
            } else if (var3) {
               if (this.bbj != 1 && this.bbj != 2 && this.bbj != 4) {
                  this.adr = false;
               } else {
                  this.rg(this.bbc != 0);
               }
            }
         } else if (!this.bci) {
            this.ri(var1, var2);
         } else {
            if (var1 == (-1466481295 ^ -1466481550)) {
               if (!this.bch.isEmpty()) {
                  this.bch = this.bch.substring(0, this.bch.length() - 1);
                  this.jn();
               }
            } else if (var3) {
               this.bci = false;
               this.jq();
               if (this.kq() >= 0) {
                  this.ri(-1374136453 ^ -1374136710, 0);
               } else {
                  this.qz(1);
               }
            } else if (var1 == (1070936702 ^ 1070936951) || var1 == (373374417 ^ 373374169)) {
               this.ri(var1, 0);
            }
         }
      }
   }

   private boolean rl(int var1) {

      if (var1 >= 32 && var1 != 127 && var1 <= (-1061129340 ^ -1061122949)) {
         char var2 = (char)var1;
         if (this.bbi) {
            if (rm(var1) && this.bbg.length() < 32) {
               this.bbg = this.bbg + var2;
            }

            return true;
         } else if (this.adr) {
            if (rm(var1) && this.adq.length() < 32) {
               this.adq = this.adq + var2;
            }

            return true;
         } else if (this.bci) {
            if (this.bch.length() < 32) {
               this.bch = this.bch + var2;
               this.jn();
            }

            return true;
         } else if (this.adz == 0 && SyncController.z && this.bbj == 0 && !this.bbl && this.bkg && Character.isLetterOrDigit(var1)) {
            this.bci = true;
            this.bch = String.valueOf(var2);
            this.jn();
            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private static boolean rm(int var0) {

      return var0 >= (1937648620 ^ 1937648428) && var0 < (-808746863 ^ -808746303)
         ? Character.isLetter(var0)
         : var0 >= 32
            && var0 < 127
            && var0 != 60
            && var0 != 62
            && var0 != 58
            && var0 != 34
            && var0 != 47
            && var0 != 92
            && var0 != 124
            && var0 != 63
            && var0 != 42;
   }

   private void rn() {

      String var1 = "";

      try {
         var1 = a.keyboard.getClipboard();
      } catch (Throwable var4) {
      }

      if (var1 != null) {
         for (int var2 = 0; var2 < var1.length(); var2++) {
            char var3 = var1.charAt(var2);
            if (var3 == '\n' || var3 == '\r') {
               break;
            }

            if (this.bci) {
               if (this.bch.length() < 32 && var3 >= ' ') {
                  this.bch = this.bch + var3;
               }
            } else if (rm(var3)) {
               if (this.bbi && this.bbg.length() < 32) {
                  this.bbg = this.bbg + var3;
               } else if (this.adr && this.adq.length() < 32) {
                  this.adq = this.adq + var3;
               }
            }
         }

         if (this.bci) {
            this.jn();
         }
      }
   }

   private boolean ro() {

      if (this.bci) {
         this.bci = false;
         this.bch = "";
         this.jn();
         return true;
      } else if (this.bbl) {
         this.bbl = false;
         return true;
      } else if (this.bbj != 0) {
         this.rb();
         return true;
      } else if (this.bbn) {
         this.bbn = false;
         return true;
      } else if (!this.bch.isEmpty()) {
         this.bch = "";
         this.jn();
         return true;
      } else {
         return false;
      }
   }

   private JsonObject rp() {

      JsonObject var1 = null;

      try {
         var1 = ConfigBridge.c.d().f();
      } catch (Throwable var3) {
         var1 = null;
      }

      return var1;
   }

   private static void rq(int var0, String var1, String var2, JsonObject var3, String var4, boolean var5) {

      bcq = var0;
      bcu = var1;
      bct = var2;
      bcr = var3;
      bcs = var4;
      bcv = "";
      bcw = false;
      bcx = var5 ? 0L : System.nanoTime();
      bcy = var5 ? BundleSync.af : -1;
   }

   private static void rr() {

      bcq = 0;
      bcr = null;
      bcx = 0L;
      bcy = -1;
   }

   private void rs() {

      if (!jp()) {
         this.jo(false, bbb[58]);
      } else {
         int var1 = bcq;
         String var2 = bct;
         String var3 = bcs;
         String var4 = bcv;
         boolean var5 = bcw;
         JsonObject var6 = bcr;
         rr();
         if (var1 == 2) {
            Object var7 = null;

            try {
               var7 = ConfigBridge.c.d().ad(var4, var2);
            } catch (Throwable var9) {
               var7 = null;
            }

            if (var7 == null) {
               NoticeQueue.err(bbb[5], var2);
               this.jo(false, bbb[5]);
            } else {
               if (var5 && !bce.contains(var7)) {
                  bce.add((String)var7);
               }

               if (var3.equals(var2)) {
                  bcd = (String)var7;
               }

               this.ru();
               this.kd();
               this.adp = (String)var7;
               this.bcg = false;
               NoticeQueue.ok(bbb[38].trim(), (String)var7);
               this.jo(true, bbb[38] + var7);
            }
         } else if (var6 != null) {
            try {
               dj();
               ConfigBridge.c.d().a(var6);
               applyTheme();
               ConfigBridge.c.d().c();
            } catch (Throwable var10) {
               NoticeQueue.err(bbb[1], var2);
               this.jo(false, bbb[1]);
               return;
            }

            this.rt(var3);
            this.kd();
            NoticeQueue.ok(bbb[37], var2.isEmpty() ? var3 : var2);
            this.jo(true, bbb[37]);
         }
      }
   }

   private void rt(String var1) {

      bcd = var1 == null ? "" : var1;
      this.ru();
      this.bcp = true;
   }

   private void ru() {

      try {
         ConfigBridge.c.d().u(bcd, bce);
      } catch (Throwable var2) {
      }

      bcf++;
   }

   private void rv(String var1, boolean var2) {

      JsonObject var3 = this.rp();
      String var4 = bcd;

      try {
         dj();
         ConfigBridge.c.d().q(var1);
         applyTheme();
         NoticeQueue.ok(var2 ? bbb[47] : bbb[0], var1);
         this.rt(var1);
         this.jo(true, (var2 ? bbb[61] : bbb[26]) + var1);
         if (var3 != null) {
            rq(1, var2 ? axg[41] + atq[90] : axg[38], var2 ? "" : var1, var3, var4, false);
         }
      } catch (Exception var6) {
         NoticeQueue.err(bbb[1], var1);
         this.jo(false, bbb[1]);
      }
   }

   private void rw(boolean var1, boolean var2) {

      if (var1) {
         if (var2) {
            if (!this.bbd.isEmpty()) {
               if (BundleSync.ad) {
                  NoticeQueue.a(bbb[48], bbb[49]);
                  return;
               }

               JsonObject var8 = this.rp();
               String var10 = bcd;
               String var11 = this.ka();
               BundleSync.l(this.bbd, var11);
               this.rt("");
               if (var8 != null) {
                  rq(1, axg[38], var11, var8, var10, true);
               }

               this.jo(true, bbb[32] + var11);
            }
         } else if (this.kb() >= 0) {
            this.rv(this.adp, false);
         }
      } else {
         if (var2) {
            if (this.jy()) {
               BundleSync.o(this.bbd, this.ka());
               this.jo(true, bbb[35] + this.ka());
               this.bbd = "";
            } else if (!this.bbd.isEmpty()) {
               NoticeQueue.err(bbb[2], bbb[3]);
            }
         } else if (!this.adp.isEmpty() && !this.bcg) {
            String var3 = this.adp;
            Object var4 = null;

            try {
               var4 = ConfigBridge.c.d().aa(var3);
            } catch (Throwable var7) {
               var4 = null;
            }

            if (var4 == null) {
               NoticeQueue.err(bbb[5], var3);
               this.jo(false, bbb[5]);
               return;
            }

            boolean var5 = bce.remove(var3);
            String var6 = bcd;
            if (var3.equals(bcd)) {
               bcd = "";
            }

            rq(2, axg[40], var3, null, var6, false);
            bcv = (String)var4;
            bcw = var5;
            this.ru();
            this.kd();
            NoticeQueue.ok(bbb[4], var3);
            this.jo(true, bbb[60] + var3);
            this.adp = "";
         }
      }
   }

   private void rx() {

      if (this.kv() < 0) {
         this.ra(0);
         this.rc(1, "");
      } else if (this.bhh <= 0) {
         this.jo(true, bbb[62]);
      } else {
         String var1 = bcd;

         try {
            ConfigBridge.c.d().e(var1);
         } catch (Throwable var3) {
            NoticeQueue.err(bbb[22], var1);
            this.jo(false, bbb[22]);
            return;
         }

         this.kd();
         NoticeQueue.ok(bbb[21], var1);
         this.jo(true, bbb[27] + var1);
      }
   }

   private boolean ry() {

      this.bik = null;
      this.lk();
      String var1 = this.bbk;
      String var2 = this.adq.trim();
      if (var2.isEmpty()) {
         NoticeQueue.err(bbb[19], bbb[7]);
         return false;
      } else if (this.bim >= 0) {
         NoticeQueue.err(bbb[59], axg[this.bim]);
         this.jo(false, axg[this.bim]);
         return false;
      } else if (var2.equals(var1)) {
         this.rb();
         return true;
      } else {
         int var3;
         try {
            var3 = ConfigBridge.c.d().x(var1, var2);
         } catch (Throwable var5) {
            var3 = 3;
         }

         if (var3 != 0) {
            NoticeQueue.err(bbb[40], var3 == 1 ? axg[77] : var1);
            this.jo(false, bbb[40]);
            return false;
         } else {
            int var4 = bce.indexOf(var1);
            if (var4 >= 0) {
               bce.set(var4, var2);
            }

            if (var1.equals(bcd)) {
               bcd = var2;
            }

            if (var1.equals(bcs)) {
               bcs = var2;
            }

            this.ru();
            this.adp = var2;
            this.bcg = false;
            this.adq = "";
            this.rb();
            this.kd();
            NoticeQueue.ok(bbb[39], var2);
            this.jo(true, bbb[39] + atq[29] + var2);
            return true;
         }
      }
   }

   private void rz() {

      if (this.kb() >= 0) {
         Object var1 = null;

         try {
            var1 = ConfigBridge.c.d().y(this.adp);
         } catch (Throwable var3) {
            var1 = null;
         }

         if (var1 == null) {
            NoticeQueue.err(bbb[42], this.adp);
            this.jo(false, bbb[42]);
         } else {
            this.kd();
            this.adp = (String)var1;
            NoticeQueue.ok(bbb[41], (String)var1);
            this.jo(true, bbb[41] + atq[29] + var1);
         }
      }
   }

   private void sa() {

      if (this.kb() >= 0) {
         Path var1 = null;

         try {
            var1 = ConfigBridge.c.d().z(this.adp);
         } catch (Throwable var5) {
            var1 = null;
         }

         if (var1 == null) {
            NoticeQueue.err(bbb[44], this.adp);
            this.jo(false, bbb[44]);
         } else {
            String var2 = bbb[56] + '/' + var1.getFileName();
            NoticeQueue.ok(bbb[43], var2);
            this.jo(true, bbb[43] + atq[29] + var2);

            try {
               Desktop.getDesktop().open(var1.getParent().toFile());
            } catch (Exception var4) {
            }
         }
      }
   }

   private void sb() {

      if (this.kb() >= 0) {
         String var1 = this.adp;
         boolean var2 = bce.remove(var1);
         if (!var2) {
            bce.add(var1);
         }

         this.ru();
         this.jo(true, (var2 ? bbb[46] : bbb[45]) + var1);
      }
   }

   private void sc() {

      BundleSync.Entry var1 = this.jx();
      if (var1 != null) {
         if (BundleSync.ad) {
            NoticeQueue.a(bbb[48], bbb[49]);
         } else {
            BundleSync.m(var1.id, var1.a);
            this.jo(true, bbb[50] + var1.a);
         }
      }
   }

   private void sd(int var1) {

      if (var1 == 5) {
         BundleSync.j(false);
      }
   }

   private void se(int var1) {

      if (var1 == 2) {
         String var2 = null;
         if (!this.bcg && this.kb() >= 0) {
            var2 = ConfigBridge.c.d().h(this.adp);
         }

         if (var2 == null) {
            var2 = ConfigBridge.c.d().g();
         }

         if (var2 == null) {
            NoticeQueue.err(bbb[9], bbb[10]);
            this.jo(false, bbb[9]);
         } else {
            a.keyboard.setClipboard(var2);
            NoticeQueue.ok(bbb[11], var2.length() + bbb[12]);
            this.jo(true, bbb[29] + var2.length() + bbb[12]);
         }
      } else if (var1 == 3) {
         String var7 = "";

         try {
            var7 = a.keyboard.getClipboard();
         } catch (Throwable var6) {
         }

         if (var7 != null && !var7.trim().isEmpty()) {
            JsonObject var3 = this.rp();
            String var4 = bcd;
            dj();
            if (ConfigBridge.c.d().o(var7)) {
               applyTheme();
               this.rt("");
               this.kd();
               if (var3 != null) {
                  rq(1, axg[39], "", var3, var4, false);
               }

               NoticeQueue.ok(bbb[15], bbb[16]);
               this.jo(true, bbb[30]);
            } else {
               NoticeQueue.err(bbb[17], bbb[18]);
               this.jo(false, bbb[17]);
            }
         } else {
            NoticeQueue.err(bbb[13], bbb[14]);
            this.jo(false, bbb[13]);
         }
      } else if (var1 == 4) {
         try {
            Desktop.getDesktop().open(ConfigBridge.c.d().s().toFile());
         } catch (Exception var5) {
         }
      }
   }

   private boolean sf(boolean var1) {

      this.bik = null;
      this.lk();
      String var2 = this.adq.trim().isEmpty() ? (var1 ? "" : this.ll()) : this.adq.trim();
      if (var1) {
         if (!var2.isEmpty()) {
            BundleSync.k(var2, this.bbe);
            this.jo(true, bbb[31] + var2 + bbb[36] + (this.bbe ? atq[45] : (ConfigBridge.USER_NAME.isEmpty() ? atq[46] : ConfigBridge.USER_NAME)));
            this.adq = "";
            this.adr = false;
            return true;
         }

         NoticeQueue.err(bbb[19], bbb[20]);
      } else if (!var2.isEmpty()) {
         if (this.bim >= 0) {
            NoticeQueue.err(bbb[59], axg[this.bim]);
            this.jo(false, axg[this.bim]);
            return false;
         }

         String var3 = this.ke(var2);
         if (!var3.isEmpty()) {
            var2 = var3;
         }

         try {
            ConfigBridge.c.d().e(var2);
            this.rt(var2);
            this.kd();
            this.adp = var2;
            this.bcg = false;
            this.adq = "";
            this.adr = false;
            NoticeQueue.ok(bbb[21], var2);
            this.jo(true, bbb[27] + var2);
            return true;
         } catch (Exception var5) {
            NoticeQueue.err(bbb[22], var2);
            this.jo(false, bbb[22]);
         }
      } else {
         NoticeQueue.err(bbb[19], bbb[23]);
      }

      return false;
   }

   private void sg() {

      if (bcq != 0 && bcx == 0L && bcy >= 0 && BundleSync.af != bcy) {
         bcx = System.nanoTime();
         bcy = -1;
         this.bcp = true;
      }

      if (bcq != 0 && bcx != 0L && !jp()) {
         rr();
      }

      if (this.adj && BundleSync.ag != this.bru) {
         this.bru = BundleSync.ag;
         this.kd();
         String var1 = BundleSync.ah;
         if (var1 != null && !var1.isEmpty()) {
            this.jo(true, bbb[51] + var1);
         }
      }
   }

   private void sh(List<Path> var1) {

      if (var1 != null && !var1.isEmpty()) {
         if (!this.adj) {
            if (this.adz != 0) {
               this.xg(true);
            } else {
               this.adi = false;
               this.uq();
            }
         }

         this.ra(0);
         this.rb();
         int var2 = 0;
         int var3 = 0;
         String var4 = null;
         String var5 = null;

         for (Path var7 : var1) {
            Object var8 = null;

            try {
               var8 = ConfigBridge.c.d().ag(var7);
            } catch (Throwable var10) {
               var8 = null;
            }

            if (var8 != null) {
               var2++;
               if (var4 == null) {
                  var4 = (String)var8;
               }
            } else {
               var3++;
               if (var5 == null) {
                  var5 = String.valueOf(var7.getFileName());
               }
            }
         }

         this.kd();
         if (var4 != null) {
            this.adp = var4;
            this.bcg = false;
            this.bbn = false;
         }

         if (var2 > 0) {
            String var11 = var2 == 1 ? var4 : var2 + bbb[54];
            NoticeQueue.ok(bbb[15], var11);
            this.jo(true, bbb[52] + var11 + (var3 > 0 ? atq[29] + bbb[55] + var5 : ""));
         } else {
            NoticeQueue.err(bbb[53], bbb[55] + var5);
            this.jo(false, bbb[55] + var5);
         }
      }
   }

   public void onFilesDropped(List<Path> var1) {

      try {
         this.sh(var1);
      } catch (Throwable var3) {
      }
   }

   private boolean si(int var1) {

      for (int var2 = 0; var2 < 7; var2++) {
         if (!this.afr[var2] && this.afq[var2] == var1) {
            return true;
         }
      }

      return false;
   }

   private static String sj(BuilderFactory var0) {

      return var0.getClass().getSimpleName();
   }

   private boolean sk(ParserEngine var1, int var2, int var3, int var4) {

      return this.sl(var1, this.abs.getOrDefault(var1, 10), this.abt.getOrDefault(var1, 48), var2, var3, var4);
   }

   private boolean sl(ParserEngine var1, int var2, int var3, int var4, int var5, int var6) {

      int var7 = this.abr;
      if (var4 >= var2 && var4 <= var2 + var7 && var5 >= var3 && var5 < var3 + 24) {
         if (var6 == 1) {
            if (this.abv.contains(var1)) {
               this.abv.remove(var1);
            } else {
               this.abv.add(var1);
            }
         } else if (var6 == 0 && this.adz == 0) {
            this.acb = var1;
            this.acc = var4 - var2;
            this.acd = var5 - var3;
         }

         return true;
      } else {
         float var8 = this.cr(var1);
         if (var8 <= 0.02F) {
            return false;
         } else {
            List var9 = this.y(var1);
            int var10 = this.aq(var9) + 5;
            int var11 = Math.round((float)Math.min(-1847033912 ^ -1847034208, var10) * var8);
            int var12 = var3 + 24;
            if (var4 >= var2 && var4 < var2 + var7 && var5 >= var12 && var5 < var12 + var11) {
               float var13 = this.ajd.getFloat(var1);
               return this.sm(var2, var12, var7, this.de(var13), var9, var4, this.dg(var5, this.df(var13)), var6);
            } else {
               return false;
            }
         }
      }
   }

   private boolean sm(int var1, int var2, int var3, int var4, List<BuilderFactory> var5, int var6, int var7, int var8) {

      int var9 = var2 - var4;
      boolean var10 = var5 != this.abz && !var5.isEmpty() && ((BuilderFactory)var5.get(0)).i() == ParserEngine.CT;
      int var11 = -1;

      for (BuilderFactory var13 : var5) {
         int var14 = var10 ? an(var13) : -1;
         if (var14 >= 0 && var14 != var11) {
            var9 += 10;
         }

         var11 = var14;
         if (var7 >= var9 && var7 < var9 + 17) {
            if (var13 instanceof NodeZoneRenderer var33) {
               if (var8 != 1 && (var8 != 0 || var6 < var1 + var3 - 16)) {
                  if (var8 == 0) {
                     var13.e();

                     try {
                        NoticeZoneCache.d(var13, var13.f);
                     } catch (Throwable var28) {
                     }
                  }
               } else {
                  this.my(var33);
               }

               return true;
            }

            if (var13 instanceof CoreZoneProcessor) {
               if (var8 != 1 && (var8 != 0 || var6 < var1 + var3 - 16)) {
                  if (var8 == 0) {
                     var13.e();

                     try {
                        NoticeZoneCache.d(var13, var13.f);
                     } catch (Throwable var29) {
                     }
                  }
               } else {
                  this.mz((CoreZoneProcessor)var13);
               }

               return true;
            }

            boolean var32 = ar(var13.k()) > 0;
            boolean var34 = var32 && var6 >= var1 + var3 - 16;
            if (var8 == 0) {
               if (var34) {
                  this.sn(var13);
               } else {
                  var13.e();

                  try {
                     NoticeZoneCache.d(var13, var13.f);
                  } catch (Throwable var30) {
                  }
               }
            } else if (var8 == 1 && var32) {
               this.sn(var13);
            }

            return true;
         }

         var9 += 17;
         float var15 = this.cs(var13);
         List var16 = var13.k();
         int var17 = ar(var16);
         if (var15 > 0.001F && var17 > 0) {
            int var18 = this.bqg && var13 instanceof ViewCacheIndex ? -1767610332 ^ -1767610196 : 0;
            int var19 = var18 + var17 * 18;
            int var20 = Math.round((float)var19 * var15);
            var20 = var20 < 0 ? 0 : (var20 > var19 ? var19 : var20);
            float var21 = var18 > 0 ? Math.max(0.0F, Math.min(1.0F, (var15 * (float)var19 - (float)var18) / (float)(var19 - var18))) : var15;
            if (var18 > 0 && var7 >= var9 && var7 < var9 + var18 && var7 < var9 + var20) {
               if (var8 == 0 && var6 >= var1 + 11 && var6 < var1 + var3 - 6 && var7 >= var9 + 4 && var7 < var9 + var18 - 3) {
                  try {
                     BevelPassCache.x();
                  } catch (Throwable var31) {
                  }
               }

               return true;
            }

            int var22 = var9 + var18;
            int var23 = 0;
            int var24 = 0;

            for (int var25 = var16.size(); var24 < var25; var24++) {
               InitAdapter var26 = (InitAdapter)var16.get(var24);
               if (!(var26 instanceof PlacementEntry)) {
                  int var27 = var22 + cz(var21, var23, var17);
                  if (var7 >= var27 && var7 < var27 + 18 && var7 >= var9 && var7 < var9 + var20) {
                     this.so(var26, var6, var7, var27, var1, var3, var8);
                     return true;
                  }

                  var22 += 18;
                  var23++;
               }
            }

            var9 += var20;
         }
      }

      return true;
   }

   private void sn(BuilderFactory var1) {

      if (this.abw.contains(var1)) {
         this.abw.remove(var1);
      } else {
         this.abw.add(var1);
      }
   }

   private void so(InitAdapter var1, int var2, int var3, int var4, int var5, int var6, int var7) {

      if (var7 != 0) {
         if (var7 == 1 && var1 instanceof SlotEntry var24) {
            List var25 = var24.g();
            if (!var25.isEmpty()) {
               int var26 = Math.max(0, var25.indexOf(var24.f()));
               var24.a(var25.get((var26 - 1 + var25.size()) % var25.size()));
            }
         }
      } else {
         if (var1 instanceof CheckerBridge var8) {
            var8.g();
         } else if (var1 instanceof SlotEntry var9) {
            var9.h();
         } else if (var1 instanceof ItemDescriptor var10) {
            this.acr = var10;
            var10.a(true);
         } else if (var1 instanceof BlockSetE var11) {
            this.ads = null;
            this.adt = this.adt == var11 ? null : var11;
         } else if (var1 instanceof DialEntry var12) {
            this.ads = null;
            this.adv = this.adv == var12 ? null : var12;
         } else if (var1 instanceof MaskEntry var13) {
            this.ads = null;
            this.adu = this.adu == var13 ? null : var13;
         } else if (var1 instanceof TextEntry var14) {
            this.ads = this.ads == var14 ? null : var14;
         } else if (var1 instanceof BlockCalculator var15) {
            String var16 = aa(var15);
            int var17 = this.bd(var16);
            int var18 = var5 + var6 - var17 - 10;
            int var19 = var5 + var6 - 4;
            if (var2 >= var18 && var2 <= var19 && var3 >= var4 && var3 < var4 + 12) {
               this.sr(var15);
               return;
            }

            int var20 = var5 + 12;
            int var21 = var6 - 24;
            if (var2 >= var20 - 2 && var2 <= var20 + var21 + 2) {
               float var22 = this.al(var2);
               if (var15 instanceof SpanEntry var23) {
                  this.sp(var23, var22, var20, var21);
               }

               this.ace = var15;
               this.acf = var5;
               this.acg = var6;
               this.sx(var15, var22, var5, var6);
            }
         }
      }
   }

   private void sp(SpanEntry var1, float var2, int var3, int var4) {

      int var5 = af(var1, var2, var3, var4, this.nb());
      this.ach = var5;
      this.aci = var2;
      this.acj = var5 == 2 ? (float)((double)var2 - ((double)var3 + (double)var4 * ac(var1.lo(), var1.i(), var1.j()))) : 0.0F;
   }

   private void sq(SpanEntry var1, float var2, int var3, int var4) {

      int var5 = this.ach;
      if (var5 == 2) {
         float var6 = var2 - this.aci;
         if (var6 > -0.5F && var6 < 0.5F) {
            return;
         }

         var5 = var6 < 0.0F ? 0 : 1;
         this.ach = var5;
         this.acj = (float)((double)this.aci - ((double)var3 + (double)var4 * ac(var5 == 1 ? var1.hi() : var1.lo(), var1.i(), var1.j())));
      }

      double var10 = var4 <= 0 ? 0.0 : (double)((var2 - this.acj - (float)var3) / (float)var4);
      var10 = var10 < 0.0 ? 0.0 : (var10 > 1.0 ? 1.0 : var10);
      double var8 = var1.i() + var10 * (var1.j() - var1.i());
      if (var5 == 1) {
         var1.d(var8);
      } else {
         var1.c(var8);
      }
   }

   private void sr(BlockCalculator var1) {

      this.act = var1;
      this.acu = var1 instanceof SpanEntry var2 ? ss(var2.lo()) + '-' + ss(var2.hi()) : ss(var1.f());
      this.acv = false;
      this.ace = null;
   }

   private static String ss(double var0) {

      String var2 = String.format(Locale.ROOT, "%.2f", var0);

      while (var2.contains(".") && (var2.endsWith("0") || var2.endsWith("."))) {
         var2 = var2.substring(0, var2.length() - 1);
      }

      return var2.isEmpty() ? "0" : var2;
   }

   private void st() {

      BlockCalculator var1 = this.act;
      if (var1 != null) {
         String var2 = this.acu.trim();
         if (var1 instanceof SpanEntry var7) {
            if (!su(var7, var2)) {
               this.acv = true;
            } else {
               this.act = null;
               this.acu = "";
               this.acv = false;
            }
         } else if (!var2.isEmpty() && !var2.equals("-") && !var2.equals(".") && !var2.equals("-.")) {
            double var3;
            try {
               var3 = Double.parseDouble(var2);
            } catch (NumberFormatException var6) {
               this.acv = true;
               return;
            }

            if (!Double.isFinite(var3)) {
               this.acv = true;
            } else {
               var1.a(var3);
               this.act = null;
               this.acu = "";
               this.acv = false;
            }
         } else {
            this.acv = true;
         }
      }
   }

   private static boolean su(SpanEntry var0, String var1) {

      int var2 = var1.indexOf(45, 1);

      double var3;
      double var5;
      try {
         if (var2 < 0) {
            var3 = Double.parseDouble(var1);
            var5 = var3;
         } else {
            String var7 = var1.substring(var2 + 1).trim();
            var3 = Double.parseDouble(var1.substring(0, var2).trim());
            var5 = var7.isEmpty() ? var3 : Double.parseDouble(var7);
         }
      } catch (NumberFormatException var8) {
         return false;
      }

      if (Double.isFinite(var3) && Double.isFinite(var5)) {
         var0.e(var3, var5);
         return true;
      } else {
         return false;
      }
   }

   private boolean sv(int var1) {

      String var2 = this.acu;
      boolean var3 = this.act instanceof SpanEntry;
      if (var2.length() >= (var3 ? 16 : 12)) {
         return false;
      } else if (var1 >= 48 && var1 <= 57) {
         return true;
      } else {
         int var4 = var3 ? var2.indexOf(45, 1) : -1;
         if (var1 == 46) {
            return var2.indexOf(46, var4 + 1) < 0;
         } else {
            return var1 != 45 ? false : var2.isEmpty() || var3 && var4 < 0 && var2.charAt(var2.length() - 1) != '-';
         }
      }
   }

   private void sw() {

      this.act = null;
      this.acu = "";
      this.acv = false;
   }

   private void sx(BlockCalculator var1, float var2, int var3, int var4) {

      int var5 = var3 + 12;
      int var6 = var4 - 24;
      if (var1 instanceof SpanEntry var12) {
         this.sq(var12, var2, var5, var6);
      } else {
         double var7 = var6 <= 0 ? 0.0 : (double)((var2 - (float)var5) / (float)var6);
         var7 = Math.max(0.0, Math.min(1.0, var7));
         double var9 = var1.i() + var7 * (var1.j() - var1.i());
         var1.a(var9);
      }
   }

   public boolean mouseDragged(Click var1, double var2, double var4) {

      if (this.adz != 0) {
         try {
            this.wt(var2, var4);
         } catch (Throwable var14) {
            this.uz();
         }

         return true;
      } else {
         if (this.bql) {
            if (this.acx != null && this.acy >= 0) {
               float var16 = (float)(var1.x() / (double)this.q());
               PosePassCache.yawDrag = PosePassCache.yawDrag + (var16 - this.bqm) * 0.9F;
               this.bqm = var16;
               return true;
            }

            this.bql = false;
         }

         int var6 = this.t(var1.x());
         int var7 = this.u(var1.y());
         if (this.adl) {
            this.je(var6, this.fl(this.r()));
            return true;
         } else if (this.adm >= 0) {
            int var18 = this.r();
            int var19 = this.s();
            this.jf(this.fl(var18), this.fm(var19), this.fj(), var6, var7);
            return true;
         } else if (this.arx >= 0) {
            this.fb(this.arx, (float)(var1.x() / (double)this.q()), this.fl(this.r()));
            return true;
         } else if (this.adw && this.adv != null) {
            this.qc(this.r(), this.s(), var6, var7);
            return true;
         } else if (this.acs == -1) {
            if (this.acz && this.acx != null) {
               int var17 = this.r();
               int var9 = this.s();
               double var10 = Math.max(0.0, Math.min(1.0, (double)var6 / (double)var17));
               double var12 = Math.max(0.0, Math.min(1.0, (double)var7 / (double)var9));
               this.acx.z(this.acy, var10, var12);
               return true;
            } else if (this.acb != null) {
               this.abs.put(this.acb, var6 - this.acc);
               this.abt.put(this.acb, var7 - this.acd);
               return true;
            } else if (this.ace != null) {
               this.sx(this.ace, (float)(var1.x() / (double)this.q()), this.acf, this.acg);
               return true;
            } else {
               return super.mouseDragged(var1, var2, var4);
            }
         } else {
            try {
               CoreZoneProcessor var8 = ConfigBridge.c != null && ConfigBridge.c.c() != null ? ConfigBridge.c.c().a(CoreZoneProcessor.class) : null;
               if (var8 != null) {
                  var8.aa(this.acs, (int)var1.x(), (int)var1.y());
               }
            } catch (Throwable var15) {
            }

            return true;
         }
      }
   }

   public boolean mouseReleased(Click var1) {

      this.bcp = this.bcp | this.adz != 0;
      this.aef = false;
      this.aee = -1;
      this.acb = null;
      this.ace = null;
      this.bql = false;
      if (this.acz) {
         this.bpp = false;
      }

      this.acz = false;
      this.acs = -1;
      this.adl = false;
      this.adw = false;
      if (this.adm >= 0) {
         this.adm = -1;
         h();
      }

      this.fc();
      return super.mouseReleased(var1);
   }

   public boolean mouseScrolled(double var1, double var3, double var5, double var7) {

      if (this.adz != 0) {
         try {
            this.ww(var7);
         } catch (Throwable var17) {
            this.uz();
         }

         return true;
      } else {
         int var9 = this.t(var1);
         int var10 = this.u(var3);
         int var11 = this.r();
         int var12 = (int)(var7 * 14.0);
         if (this.nb()) {
            if (this.act == null && this.adt == null && this.adu == null && this.adv == null) {
               this.nu(var11, this.s(), var9, var10, var12);
            }

            return true;
         } else if (this.adt != null || this.adu != null || this.adv != null) {
            return true;
         } else if (this.act != null) {
            return true;
         } else if (!this.adi && !this.adj) {
            if (!this.aby.isEmpty()) {
               this.uo(var11, var9, var10, var12);
               return true;
            } else {
               for (ParserEngine var16 : xs) {
                  if (this.up(var16, this.abs.getOrDefault(var16, 10), this.abt.getOrDefault(var16, 48), var9, var10, var12)) {
                     return true;
                  }
               }

               return super.mouseScrolled(var1, var3, var5, var7);
            }
         } else {
            this.ji(var11, this.s(), var9, var10, var12);
            return true;
         }
      }
   }

   public boolean keyPressed(KeyInput var1) {

      int var2 = var1.key();
      if (this.adz != 0 && this.wy(var1, var2)) {
         return true;
      } else if (this.act != null) {
         if (var2 == (-1649293240 ^ -1649292984)) {
            this.sw();
         } else if (var2 == (-1711610280 ^ -1711610023) || var2 == (-1843352652 ^ -1843352837)) {
            this.st();
         } else if (var2 == (-1103899288 ^ -1103899541) && !this.acu.isEmpty()) {
            this.acu = this.acu.substring(0, this.acu.length() - 1);
            this.acv = false;
         }

         return true;
      } else if (this.acr != null) {
         ItemDescriptor var4 = this.acr;
         if (var2 == (1872475219 ^ 1872475475) && var4 == ta()) {
            var4.a(false);
         } else {
            var4.a(var2 == (11935402 ^ 11935658) ? -1 : var2);
            var4.a(false);
            this.tb(var4, var2);
         }

         this.acr = null;
         return true;
      } else if (this.ads != null) {
         if (var2 == (1795013444 ^ 1795013188) || var2 == (-641697652 ^ -641697395)) {
            this.ads = null;
         } else if (var2 == (374468642 ^ 374468897)) {
            String var3 = this.ads.f();
            if (!var3.isEmpty()) {
               this.ads.b(var3.substring(0, var3.length() - 1));
            }
         }

         return true;
      } else if (this.nb()) {
         if (var2 == (405004164 ^ 405003908)) {
            this.nk();
         } else if ((var2 == (-688747408 ^ -688747143) || var2 == (83079661 ^ 83079397)) && this.bps == null && !this.bpp) {
            this.nf(var2 == (-1463485664 ^ -1463485911) ? -1 : 1);
         } else {
            this.aj(var2);
         }

         return true;
      } else if (this.adt != null) {
         if (var2 == (1285525455 ^ 1285525199)) {
            this.adt = null;
         }

         return true;
      } else if (this.adu != null) {
         if (var2 == (636015217 ^ 636015473)) {
            this.adu = null;
         }

         return true;
      } else if (this.adv != null) {
         if (var2 == (-1826424271 ^ -1826424015)) {
            this.adv = null;
            this.adw = false;
         }

         return true;
      } else if (this.adi && !this.adj && this.fd(var2)) {
         return true;
      } else if (!this.adi && !this.adj) {
         if (this.abx) {
            this.sz(var2);
            return true;
         } else if (this.adz == 0 && this.sy(var1, var2)) {
            return true;
         } else if (this.aj(var2)) {
            return true;
         } else if (this.adz == 0 && SyncController.u && !FrameKeeper.ah && a.options.togglePerspectiveKey.matchesKey(var1)) {
            this.aed = false;
            this.ux();
            return true;
         } else if (var2 == (1858594903 ^ 1858595159)) {
            this.close();
            return true;
         } else {
            return super.keyPressed(var1);
         }
      } else {
         if (var2 == (1120759070 ^ 1120758814)) {
            if (this.bbi) {
               this.bbi = false;
            } else if (this.adr) {
               this.adr = false;
            } else if (!this.adj || !this.ro()) {
               this.adi = false;
               this.adj = false;
            }
         } else if (this.adj) {
            this.rk(var2, (var1.hasCtrlOrCmd() ? 1 : 0) | (var1.isCopy() ? 2 : 0) | (var1.isPaste() ? 4 : 0));
         }

         return true;
      }
   }

   public boolean charTyped(CharInput var1) {

      if (this.adz != 0 && this.brx) {
         this.brx = false;
         return true;
      } else if (this.act != null) {
         int var4 = var1.codepoint();
         if (this.sv(var4)) {
            this.acu = this.acu + (char)var4;
            this.acv = false;
         }

         return true;
      } else if (this.ads == null) {
         return this.adj && this.rl(var1.codepoint()) ? true : super.charTyped(var1);
      } else {
         int var2 = var1.codepoint();
         if (var2 == 95 || var2 >= 48 && var2 <= 57 || var2 >= 65 && var2 <= 90 || var2 >= 97 && var2 <= 122) {
            String var3 = this.ads.f();
            if (var3.length() < this.ads.g()) {
               this.ads.b(var3 + (char)var2);
            }
         }

         return true;
      }
   }

   private boolean sy(KeyInput var1, int var2) {

      if (!SyncController.z) {
         return false;
      } else {
         boolean var3 = var2 >= 65 && var2 <= 90;
         if (var3 || var2 >= 48 && var2 <= 57) {
            if ((var1.modifiers() & 14) != 0) {
               return false;
            } else {
               ItemDescriptor var4 = ta();
               if (var4 != null && var4.d == var2) {
                  return false;
               } else if (this.acr == null && this.ads == null && this.act == null && !this.adr && !this.bbi && !this.adi && !this.adj && !this.nb()) {
                  this.abx = true;
                  this.sz(var2);
                  return true;
               } else {
                  return false;
               }
            }
         } else {
            return false;
         }
      }
   }

   private void sz(int var1) {

      if (var1 == (1386536444 ^ 1386536191)) {
         if (!this.aby.isEmpty()) {
            this.aby = this.aby.substring(0, this.aby.length() - 1);
         }
      } else if (var1 == (2036436394 ^ 2036436138) || var1 == (92021313 ^ 92021568)) {
         this.abx = false;
      } else if (var1 >= 65 && var1 <= 90) {
         this.aby = this.aby + (char)(var1 + 32);
      } else if (var1 >= 48 && var1 <= 57) {
         this.aby = this.aby + (char)var1;
      } else if (var1 == 32) {
         this.aby = this.aby + ' ';
      }

      this.am();
   }

   public boolean shouldPause() {

      return false;
   }

   public void i() {

      if (this.brv >= 0) {
         this.brv = -1;
      } else {
         this.close();
      }
   }

   private static ItemDescriptor ta() {

      CoreZoneProcessor var0 = CoreZoneProcessor.I;
      return var0 != null ? var0.q() : null;
   }

   private void tb(ItemDescriptor var1, int var2) {

      if (var1 != null && var1 == ta()) {
         this.brv = var2;
         h();
      }
   }

   private void tc(int var1) {

      ItemDescriptor var2 = this.acr;
      this.acr = null;
      if (var2 != null) {
         if ((var1 == 0 || var1 == 1) && var2 == ta()) {
            var2.a(false);
         } else {
            var2.a(var1);
            var2.a(false);
            this.tb(var2, var1);
         }
      }
   }

   private static boolean td(int var0) {

      try {
         long var1 = a.getWindow().getHandle();
         return var0 >= 0 && var0 <= 7
            ? GLFW.glfwGetMouseButton(var1, var0) == 1
            : var0 >= 32 && var0 < (1373964426 ^ 1373964938) && GLFW.glfwGetKey(var1, var0) == 1;
      } catch (Throwable var3) {
         return false;
      }
   }

   public void close() {

      if (this.adz != 0 && !FrameKeeper.ah && !this.afm && !SyncController.x) {
         this.ur();
         this.afm = true;
         this.afn = System.nanoTime();
         tw(false);
      } else {
         this.te(false);
      }
   }

   private void te(boolean var1) {

      this.adt = null;
      this.adu = null;
      this.adv = null;
      this.adw = false;

      try {
         if (ConfigBridge.c != null) {
            ConfigBridge.c.d().c();
         }
      } catch (Throwable var3) {
      }

      if (a != null && (!var1 || a.currentScreen == this)) {
         a.setScreen(null);
      }
   }

   public void renderBackground(DrawContext var1, int var2, int var3, float var4) {

      if (this.adz != 0) {
         this.tg();
      } else {
         super.renderBackground(var1, var2, var3, var4);
      }
   }

   protected void applyBlur(DrawContext var1) {

      if (SyncController.k && BlurPaneCache.t) {
         super.applyBlur(var1);
      }
   }

   private void tf(DrawContext var1, int var2, int var3) {

      if (SyncController.k && !ahq && !aim && !BlurPaneCache.t) {
         if (!ain) {
            cb();
         }

         if (!aia) {
            try {
               BlurPaneCache.b(aio);
               if (!BlurPaneCache.ok()) {
                  return;
               }

               PaneGlassCache.frostTex(BlurPaneCache.a(), BlurPaneCache.us, BlurPaneCache.vs);
            } catch (Throwable var5) {
               return;
            }
         }

         ch(var1, -2.0F, -2.0F, (float)var2 + 4.0F, (float)var3 + 4.0F, 0.0F, -1, true, true, true, true, true);
      }
   }

   private void tg() {

      this.brx = false;

      try {
         this.th();
         this.ts();
         boolean var1 = a.isWindowFocused();
         if (var1 && !this.afp && this.afo) {
            this.tp();
         }

         this.afp = var1;
         boolean var2 = this.us();
         if (var2) {
            this.brw = this.brw | this.afs;
         }

         this.tm(var1 && !this.aef && !var2);
      } catch (Throwable var3) {
         this.uz();
      }
   }

   private void th() {

      if (this.aef) {
         boolean var1 = false;

         try {
            var1 = a.isWindowFocused() && GLFW.glfwGetMouseButton(a.getWindow().getHandle(), 0) == 1;
         } catch (Throwable var3) {
         }

         if (!var1 || !this.ti()) {
            this.ur();
         }
      }
   }

   private boolean ti() {

      return this.ace != null || this.adl || this.adm >= 0 || this.adw || this.arx >= 0;
   }

   private int tj(int var1) {

      int var2 = this.afs | this.brw;

      for (int var3 = 0; var3 < 7; var3++) {
         if ((var2 & 1 << var3) != 0 && !this.afr[var3] && this.afq[var3] == var1) {
            return 1 << var3;
         }
      }

      return 0;
   }

   private static KeyBinding tk(GameOptions var0, int var1) {

      switch (var1) {
         case 0:
            return var0.forwardKey;
         case 1:
            return var0.backKey;
         case 2:
            return var0.leftKey;
         case 3:
            return var0.rightKey;
         case 4:
            return var0.jumpKey;
         case 5:
            return var0.sneakKey;
         default:
            return var0.sprintKey;
      }
   }

   private void tl() {

      GameOptions var1 = a.options;
      InputUtil.Key var2 = null;

      for (int var3 = 0; var3 < 7; var3++) {
         int var4 = -1;
         boolean var5 = false;

         try {
            var2 = InputUtil.fromTranslationKey(tk(var1, var3).getBoundKeyTranslationKey());
            if (var2.getCategory() == InputUtil.Type.MOUSE) {
               var4 = var2.getCode();
               var5 = true;
            } else if (var2.getCategory() == InputUtil.Type.KEYSYM) {
               var4 = var2.getCode();
            }
         } catch (Throwable var7) {
         }

         this.afq[var3] = var4;
         this.afr[var3] = var5;
      }
   }

   private void tm(boolean var1) {

      GameOptions var2 = a.options;
      long var3 = a.getWindow().getHandle();
      int var5 = 0;

      for (int var6 = 0; var6 < 7; var6++) {
         int var7 = this.afq[var6];
         if (var7 >= 0) {
            boolean var8 = this.afr[var6] ? GLFW.glfwGetMouseButton(var3, var7) == 1 : GLFW.glfwGetKey(var3, var7) == 1;
            if (var8) {
               var5 |= 1 << var6;
            }
         }
      }

      this.brw &= var5;
      int var9 = var1 ? var5 & ~this.brw : 0;
      int var10 = var9 ^ this.afs;
      if (var10 != 0) {
         for (int var11 = 0; var11 < 7; var11++) {
            if ((var10 & 1 << var11) != 0) {
               tk(var2, var11).setPressed((var9 & 1 << var11) != 0);
            }
         }

         this.afs = var9;
      }
   }

   private int tn() {

      GameOptions var1 = a.options;
      long var2 = a.getWindow().getHandle();
      int var4 = 0;

      for (int var5 = 5; var5 < 7; var5++) {
         int var6 = this.afq[var5];
         boolean var7 = var5 == 5 ? (Boolean)var1.getSneakToggled().getValue() : (Boolean)var1.getSprintToggled().getValue();
         if (var7 && var6 >= 0) {
            boolean var8 = this.afr[var5] ? GLFW.glfwGetMouseButton(var2, var6) == 1 : GLFW.glfwGetKey(var2, var6) == 1;
            if (var8) {
               var4 |= 1 << var5;
            }
         }
      }

      return var4;
   }

   private void to() {

      int var1 = this.afs;
      this.afs = 0;
      if (var1 != 0 && a != null && a.options != null) {
         GameOptions var2 = a.options;

         for (int var3 = 0; var3 < 7; var3++) {
            if ((var1 & 1 << var3) != 0) {
               try {
                  tk(var2, var3).setPressed(false);
               } catch (Throwable var5) {
               }
            }
         }
      }
   }

   private void tp() {

      Window var1 = null;
      SortableComposer var2 = null;

      try {
         var1 = a.getWindow();
         double var3 = (double)var1.getWidth() / 2.0;
         double var5 = (double)var1.getHeight() / 2.0;
         var2 = (SortableComposer)a.mouse;
         var2.g3SetX(var3);
         var2.g3SetY(var5);
         InputUtil.setCursorParameters(var1, 880392544 ^ 880474467, var3, var5);
         a.mouse.setResolutionChanged();
         this.afo = true;
      } catch (Throwable var7) {
      }
   }

   private void tq() {

      Window var1 = null;
      SortableComposer var2 = null;
      this.afo = false;

      try {
         var1 = a.getWindow();
         double var3 = (double)var1.getWidth() / 2.0;
         double var5 = (double)var1.getHeight() / 2.0;
         var2 = (SortableComposer)a.mouse;
         var2.g3SetX(var3);
         var2.g3SetY(var5);
         InputUtil.setCursorParameters(var1, 1018929767 ^ 1018749542, var3, var5);
      } catch (Throwable var7) {
      }
   }

   private void tr() {

      if (this.afo && !this.aef && a.isWindowFocused()) {
         ClientPlayerEntity var1 = a.player;
         if (var1 != null) {
            SortableComposer var2 = (SortableComposer)a.mouse;
            double var3 = var2.g3Dx();
            double var5 = var2.g3Dy();
            if ((var3 != 0.0 || var5 != 0.0) && !(var3 > 4000.0) && !(var3 < -4000.0) && !(var5 > 4000.0) && !(var5 < -4000.0)) {
               GameOptions var7 = a.options;
               if (var7.smoothCameraEnabled) {
                  this.bsa += var3;
                  this.bsb += var5;
               } else {
                  double var8 = (Double)var7.getMouseSensitivity().getValue() * 0.6 + 0.2;
                  double var10 = var8 * var8 * var8 * (var7.getPerspective().isFirstPerson() && var1.isUsingSpyglass() ? 1.0 : 8.0);
                  this.tt(var1, var7, var3 * var10, var5 * var10);
               }
            }
         }
      }
   }

   private void ts() {

      long var1 = System.nanoTime();
      double var3 = this.bsc == 0L ? 0.0 : Math.min(0.1, (double)(var1 - this.bsc) * 1.0E-9);
      this.bsc = var1;
      GameOptions var5 = a.options;
      ClientPlayerEntity var6 = a.player;
      if (var5.smoothCameraEnabled && this.afo && !this.aef && var6 != null) {
         double var7 = (Double)var5.getMouseSensitivity().getValue() * 0.6 + 0.2;
         double var9 = var7 * var7 * var7 * 8.0;
         double var11 = this.bry.smooth(this.bsa * var9, var3 * var9);
         double var13 = this.brz.smooth(this.bsb * var9, var3 * var9);
         this.bsa = 0.0;
         this.bsb = 0.0;
         if (var11 != 0.0 || var13 != 0.0) {
            this.tt(var6, var5, var11, var13);
         }
      } else {
         this.bry.clear();
         this.brz.clear();
         this.bsa = 0.0;
         this.bsb = 0.0;
      }
   }

   private void tt(ClientPlayerEntity var1, GameOptions var2, double var3, double var5) {

      if ((Boolean)var2.getInvertMouseX().getValue()) {
         var3 = -var3;
      }

      if ((Boolean)var2.getInvertMouseY().getValue()) {
         var5 = -var5;
      }

      if (System.nanoTime() >= LockD.b) {
         if (ConfigBridge.c != null && LockD.g) {
            SyncDispatcher var7 = null;
            NodeFilterCache var8 = null;
            Object var9 = null;

            try {
               if (ConfigBridge.c.a() && (var7 = ConfigBridge.c.c()) != null) {
                  var8 = var7.a(NodeFilterCache.class);
                  if (var8 != null && var8.f() && var8.d_r26()) {
                     var8.c(var3, var5);
                     return;
                  }
               }
            } catch (Throwable var11) {
            }
         }

         var1.changeLookDirection(var3, var5);
      }
   }

   private void tu() {

      try {
         if (this.afo) {
            this.tq();
         }
      } catch (Throwable var3) {
      }

      try {
         this.to();
      } catch (Throwable var2) {
      }

      FrameKeeper.ag = false;
      this.afm = false;
      this.afl = 0.0F;
      this.brw = 0;
      this.ur();
      this.ael = false;
      this.aeo = false;
      agi = 1.0F;
      ahh = -1;
      this.aeq = 1.0F;
   }

   public void removed() {

      if (this.adz != 0 || this.afo) {
         this.adz = 0;
         this.tu();
      }

      BlurPaneCache.c();

      try {
         this.k();
      } catch (Throwable var2) {
      }

      super.removed();
   }

   public void mouseMoved(double var1, double var3) {

      if (this.adz != 0) {
         try {
            this.tr();
         } catch (Throwable var6) {
            this.uz();
         }
      } else {
         super.mouseMoved(var1, var3);
      }
   }

   public void tick() {

      super.tick();

      try {
         this.sg();
      } catch (Throwable var3) {
      }

      if (this.adz != 0) {
         try {
            if (this.afm) {
               if (System.nanoTime() - this.afn > 500000000L) {
                  this.te(false);
               }

               return;
            }

            if (this.tv()) {
               this.te(false);
            }
         } catch (Throwable var2) {
            this.uz();
         }
      }
   }

   private boolean tv() {

      ClientPlayerEntity var1 = a.player;
      if (var1 == null) {
         return false;
      } else {
         int var2 = var1.hurtTime;
         float var3 = var1.getHealth();
         boolean var4 = this.aft >= 0 && (var2 > this.aft || this.afu - var3 > 0.01F);
         this.aft = var2;
         this.afu = var3;
         return var4 && SyncController.y;
      }
   }

   private static void tw(boolean var0) {

      if (SyncController.w) {
         float var1 = 0.18F * SyncController.vol();
         if (!(var1 <= 0.0F)) {
            SoundManager var2 = null;

            try {
               var2 = a.getSoundManager();
               if (var2 != null) {
                  var2.play(PositionedSoundInstance.master(SoundEvents.ITEM_BOOK_PAGE_TURN, var0 ? 1.15F : 0.9F, var1));
               }
            } catch (Throwable var4) {
            }
         }
      }
   }

   private float tx(int var1) {

      float var2 = (1.0F - this.bsk[var1]) * 10.0F;
      return (float)Math.round(var2 * (float)ahd) / (float)ahd;
   }

   private int ty(int var1) {

      if (var1 == 0) {
         return this.adj ? 2 : (this.adi ? 1 : 0);
      } else if (var1 == 1) {
         return this.acx != null ? 1 : (this.ada != null ? 2 : 0);
      } else if (var1 == 2) {
         return this.adt != null ? 1 : (this.adu != null ? 2 : (this.adv != null ? 3 : 0));
      } else {
         return this.act != null ? 1 : 0;
      }
   }

   private void tz() {

      this.ua(0);
      this.ua(1);
      this.ua(2);
      this.ua(3);
      if (this.bsm[2] != 0) {
         this.bso = this.adt;
         this.bsp = this.adu;
         this.bsq = this.adv;
      } else if (this.bsn[2] == 0) {
         this.bso = null;
         this.bsp = null;
         this.bsq = null;
      }

      if (this.act != null) {
         this.bsr = this.act;
         this.bss = this.acu;
         this.bst = this.acv;
      } else if (this.bsn[3] == 0) {
         this.bsr = null;
      }
   }

   private void ua(int var1) {

      int var2 = this.ty(var1);
      int var3 = this.bsm[var1];
      this.bsm[var1] = var2;
      boolean var4 = SyncController.x || this.adz != 0;
      if (var2 != 0) {
         if (var2 != var3 && this.bsn[var1] != var2) {
            this.bsk[var1] = var4 ? 1.0F : 0.0F;
            this.bsl[var1] = 0.0F;
         }

         this.bsn[var1] = 0;
         this.ub(var1, 1.0F, 26.0F, var4);
      } else {
         if (var3 != 0 && !var4 && var1 != 1) {
            this.bsn[var1] = var3;
         }

         if (this.bsn[var1] != 0) {
            this.ub(var1, 0.0F, 38.0F, var4);
            if (this.bsk[var1] <= 0.02F) {
               this.bsn[var1] = 0;
            }
         } else {
            this.bsk[var1] = 0.0F;
            this.bsl[var1] = 0.0F;
         }
      }
   }

   private void ub(int var1, float var2, float var3, boolean var4) {

      float var5 = this.bsk[var1];
      float var6 = this.bsl[var1];
      if (var4) {
         var5 = var2;
         var6 = 0.0F;
      } else if (var5 != var2 || var6 != 0.0F) {
         float var7 = this.ajg;
         float var8 = (float)Math.exp((double)(-var3 * var7));
         float var9 = var5 - var2;
         float var10 = var6 + var3 * var9;
         var5 = var2 + (var9 + var10 * var7) * var8;
         var6 = (var6 - var3 * var10 * var7) * var8;
         if (Math.abs(var5 - var2) < 0.002F && Math.abs(var6) < 0.02F) {
            var5 = var2;
            var6 = 0.0F;
         }
      }

      this.bsk[var1] = var5 < 0.0F ? 0.0F : (var5 > 1.0F ? 1.0F : var5);
      this.bsl[var1] = var6;
   }

   private boolean uc(DrawContext var1, int var2, int var3, int var4) {

      float var5 = this.bsk[var2];
      if (!(var5 >= 0.999F) && this.adz == 0) {
         this.bsu = agi;
         agi *= var5;
         float var6 = this.tx(var2);
         this.bsv = var6;
         Matrix3x2fStack var7 = var1.getMatrices();
         var7.pushMatrix();
         var7.translate(0.0F, var6);
         return true;
      } else {
         return false;
      }
   }

   private void ud(DrawContext var1, boolean var2) {

      if (var2) {
         var1.getMatrices().popMatrix();
         agi = this.bsu;
         this.bsv = 0.0F;
      }
   }

   private boolean ue(DrawContext var1) {

      if (this.bsv != 0.0F && this.adz == 0) {
         Matrix3x2fStack var2 = var1.getMatrices();
         var2.pushMatrix();
         var2.translate(0.0F, -this.bsv);
         return true;
      } else {
         return false;
      }
   }

   private int uf(int var1, int var2, int var3) {

      return var2;
   }

   private int ug(int var1, int var2) {

      float var3 = this.bsk[var1];
      return !(var3 >= 0.999F) && this.adz == 0 && var2 > (731492334 ^ -879120402) ? Math.round((float)var2 - this.tx(var1)) : var2;
   }

   private int uh() {

      if (this.act != null) {
         return 3;
      } else if (this.adi || this.adj) {
         return 0;
      } else if (this.nb()) {
         return 1;
      } else {
         return this.adt == null && this.adu == null && this.adv == null ? -1 : 2;
      }
   }

   private void ui(DrawContext var1, int var2, int var3) {

      boolean var4 = this.adi;
      boolean var5 = this.adj;
      int var6 = this.bsn[0];
      boolean var7 = this.uc(var1, 0, var2, var3);

      try {
         this.adi = var6 == 1;
         this.adj = var6 == 2;
         this.fp(var1, var2, var3);
         this.fo(var1, var2, var3, -864837505 ^ 208904319, 697935363 ^ -375806461);
      } catch (Throwable var12) {
         this.bsn[0] = 0;
      } finally {
         this.adi = var4;
         this.adj = var5;
         this.ud(var1, var7);
      }
   }

   private void uj(DrawContext var1, int var2, int var3) {

      int var4 = this.bsn[2];
      boolean var5 = this.uc(var1, 2, var2, var3);

      try {
         if (var4 == 1 && this.bso != null) {
            this.adt = this.bso;
            this.pl(var1, var2, var3, 747293181 ^ -326448643, -613355648 ^ 460386176);
         } else if (var4 == 2 && this.bsp != null) {
            this.adu = this.bsp;
            this.pq(var1, var2, var3, 1814459706 ^ -1406765766, -1936030373 ^ 1285195099);
         } else if (var4 == 3 && this.bsq != null) {
            this.adv = this.bsq;
            this.pz(var1, var2, var3, 1880735599 ^ -1340489873, -194388397 ^ 879353427);
         }
      } catch (Throwable var10) {
         this.bsn[2] = 0;
      } finally {
         this.adt = null;
         this.adu = null;
         this.adv = null;
         this.ud(var1, var5);
      }
   }

   private void uk(DrawContext var1, int var2, int var3) {

      String var4 = this.acu;
      boolean var5 = this.acv;
      boolean var6 = this.uc(var1, 3, var2, var3);

      try {
         if (this.bsr != null) {
            this.act = this.bsr;
            this.acu = this.bss;
            this.acv = this.bst;
            this.dq(var1, var2, var3);
         }
      } catch (Throwable var11) {
         this.bsn[3] = 0;
      } finally {
         this.act = null;
         this.acu = var4;
         this.acv = var5;
         this.ud(var1, var6);
      }
   }

   private void ul() {

      int var1 = this.adj ? 2 : (this.adi ? 1 : 0);
      if (var1 != this.anc) {
         this.anc = var1;

         for (Object var5 : bmj) {
            this.aiw.removeFloat(var5);
         }

         if (var1 == 1) {
            this.art = 0;
            this.aru = 0.0F;
            this.arz = -1;
            this.asa = 1.0F;
            this.arw = 0L;
         }
      }

      if (var1 != 0) {
         int var6 = this.r();
         int var7 = this.s();
         if (this.adz != 0) {
            var6 = (int)((float)var6 / 1.3F);
            var7 = (int)((float)var7 / 1.3F);
         }

         this.fn(var6, var7);
      }
   }

   private boolean um(int var1, int var2, int var3) {

      int var4 = 469752306 ^ 469752110;
      int var5 = (var1 - var4) / 2;
      if (var2 >= var5 && var2 <= var5 + var4 && var3 >= 20 && var3 <= 38) {
         if (this.abx && !this.aby.isEmpty() && var2 >= var5 + var4 - 14) {
            this.aby = "";
            this.am();
         }

         this.abx = true;
         return true;
      } else {
         return false;
      }
   }

   private void un(int var1, int var2, int var3, int var4) {

      int var5 = this.abr + 40;
      int var6 = (var1 - var5) / 2;
      byte var7 = 72;
      int var8 = Math.min(1823952984 ^ 1823953200, Math.max(17, this.aq(this.abz) + 5));
      if (var2 >= var6 && var2 < var6 + var5 && var3 >= var7 && var3 < var7 + var8) {
         float var9 = this.ajd.getFloat(aje);
         this.sm(var6, var7, var5, this.de(var9), this.abz, var2, this.dg(var3, this.df(var9)), var4);
      }
   }

   private void uo(int var1, int var2, int var3, int var4) {

      int var5 = this.abr + 40;
      int var6 = (var1 - var5) / 2;
      byte var7 = 72;
      int var8 = this.aq(this.abz) + 5;
      int var9 = Math.max(0, var8 - (-425802707 ^ -425802427));
      if (var2 >= var6 && var2 < var6 + var5 && var3 >= var7 && var3 < var7 + (-776538548 ^ -776538332)) {
         this.aca = Math.max(0, Math.min(var9, Math.min(var9, this.aca) - var4));
      }
   }

   private boolean up(ParserEngine var1, int var2, int var3, int var4, int var5, int var6) {

      if (this.abv.contains(var1)) {
         return false;
      } else {
         int var7 = this.aq(this.y(var1)) + 5;
         int var8 = Math.min(-2059881622 ^ -2059881982, var7);
         int var9 = var3 + 24;
         if (var4 >= var2 && var4 < var2 + this.abr && var5 >= var9 && var5 < var9 + var8) {
            int var10 = Math.max(0, var7 - (-65061533 ^ -65061877));
            int var11 = Math.min(var10, this.abu.getOrDefault(var1, 0));
            this.abu.put(var1, Math.max(0, Math.min(var10, var11 - var6)));
            return true;
         } else {
            return false;
         }
      }
   }

   private void uq() {

      this.adj = true;
      this.rb();
      this.bbn = false;
      this.adq = "";
      this.bcl = "";
      this.bch = "";
      this.bci = false;
      this.bru = BundleSync.ag;
      if (this.bbc != 0 && !BundleSync.ad) {
         BundleSync.j(true);
      }

      this.kd();
      if (!this.bcg && this.kc(this.adp) < 0) {
         this.bcg = this.kc(bcd) < 0;
         this.adp = this.bcg ? "" : bcd;
      }
   }

   private void ur() {

      this.acb = null;
      this.adw = false;
      this.ace = null;
      this.bql = false;
      this.acz = false;
      this.acs = -1;
      this.adl = false;
      if (this.adm >= 0) {
         this.adm = -1;
         h();
      }

      this.fc();
      this.aee = -1;
      this.aef = false;
   }

   private boolean us() {

      return this.act != null || this.acr != null || this.ads != null || this.abx || this.adj && (this.adr || this.bbi || this.bci);
   }

   private void ut() {

      float var1 = (float)Math.toRadians((double)FrameKeeper.yaw) - FrameKeeper.ar;
      var1 -= (float) (Math.PI * 2) * (float)Math.floor((double)((var1 + (float) Math.PI) / (float) (Math.PI * 2)));
      boolean var2 = var1 >= 0.0F;
      float var3 = FrameKeeper.cs;
      float var4 = Math.max(FrameKeeper.ct, (float)this.afw) * 0.5F;
      FrameKeeper.PV[10] = var2 ? 0.0F : 1.0F;
      FrameKeeper.PV[11] = 0.0F;
      float var5 = FrameKeeper.g(5, (var4 + 6.0F) * (var2 ? 1.0F : -1.0F), var3, FrameKeeper.as + 44.0F * var3);
      FrameKeeper.PHYS[5] = true;
      FrameKeeper.PMUL[5] = 1.3F * var5 / 2.0F;
      FrameKeeper.PDIST[5] = var5;
      this.btc = System.nanoTime();
   }

   private void uu() {

      if (this.adi || this.adj) {
         this.ut();
      }

      if (this.nb() || this.adt != null || this.adu != null || this.adv != null) {
         FrameKeeper.j(9, 2.0F);
      }

      if (this.act != null) {
         FrameKeeper.j(10, 1.9F);
      }

      if (this.aeo) {
         FrameKeeper.j(6, 2.0F);
         FrameKeeper.DYN[19] = FrameKeeper.DYN[19] + 0.35F;
      }

      this.ael = false;
      this.agd = this.acx;
      this.age = this.ada;
      this.agf = this.adt;
      this.agg = this.adu;
      this.agh = this.adv;
      this.agc = this.act;
   }

   private void uv() {

      if (this.adz == 0 && a != null && a.world != null && a.player != null) {
         if (FrameKeeper.ah) {
            if (!this.aed) {
               this.aed = true;
               NoticeQueue.a(agk[11], agk[12]);
            }
         } else if (SyncController.s) {
            if (!this.aed) {
               this.aed = true;
               NoticeQueue.a(agk[13], agk[16]);
            }
         } else {
            this.ur();

            try {
               this.adz = 1;
               this.bqg = false;
               FrameKeeper.af();
               FrameKeeper.ag = true;
               this.aeb = false;
               this.afm = false;
               this.afl = SyncController.x ? 1.0F : 0.0F;
               this.aet = System.nanoTime();
               this.bte = 0;
               this.afj = false;
               this.afk = null;
               this.ael = false;
               this.abx = false;
               this.aeo = !this.aby.isEmpty();
               this.aec = true;
               this.aft = -1;
               this.afu = -1.0F;
               this.brw = 0;
               uw();
               this.tl();
               this.afs = this.tn();
               this.tp();
               KeyBinding.restoreToggleStates();
               this.afp = a.isWindowFocused();
               tw(true);
            } catch (Throwable var2) {
               this.uz();
            }
         }
      }
   }

   private static void uw() {

      GlyphPassCache.kick();
      if (!ahj) {
         ahj = true;

         try {
            if (a.getResourceManager().getResource(Identifier.of(agk[14], ahk[0])).isPresent()) {
               ahi = 5;
            }
         } catch (Throwable var1) {
         }
      }
   }

   private void ux() {

      if (this.adz == 0) {
         this.uv();
      }
   }

   private void uy() {

      if (this.adz != 0 || this.afo) {
         this.adz = 0;
         this.tu();
      }
   }

   private void uz() {

      FrameKeeper.ah = true;
      agi = 1.0F;
      ahh = -1;
      this.uy();
   }

   private void va() {

      this.uy();
   }

   private float vb() {

      return this.aef ? this.aeg : (float)((this.width - 15) / 2) + 7.5F;
   }

   private float vc() {

      return this.aef ? this.aeh : (float)((this.height - 15) / 2) + 7.5F;
   }

   private boolean vd() {

      return !this.afm && this.afl > 0.6F;
   }

   private boolean ve(KeyInput var1, int var2) {

      if (this.afm) {
         if (var2 == (1176640501 ^ 1176640245)) {
            this.te(false);
         }

         return true;
      } else if (this.us()) {
         int var3 = this.tj(var2);
         if (var3 != 0) {
            this.brw |= var3;
            this.brx = true;
            return true;
         } else if (!this.abx || this.act != null || this.acr != null || this.ads != null || this.adj && (this.adr || this.bbi || this.bci)) {
            return false;
         } else {
            this.sz(var2);
            return true;
         }
      } else if (a.options.togglePerspectiveKey.matchesKey(var1)) {
         this.va();
         return true;
      } else if (this.adi && !this.adj && this.fd(var2)) {
         return true;
      } else if (this.aj(var2)) {
         return true;
      } else if (this.adj && this.ri(var2, this.si(var2) ? 0 : (var1.hasCtrlOrCmd() ? 1 : 0) | (var1.isCopy() ? 2 : 0) | (var1.isPaste() ? 4 : 0))) {
         return true;
      } else if (var2 == (-592923999 ^ -592923743)) {
         if (!this.vf()) {
            this.close();
         }

         return true;
      } else {
         return true;
      }
   }

   private boolean vf() {

      if (this.nb()) {
         this.nk();
         return true;
      } else if (this.adt != null) {
         this.adt = null;
         return true;
      } else if (this.adu != null) {
         this.adu = null;
         return true;
      } else if (this.adv != null) {
         this.adv = null;
         this.adw = false;
         return true;
      } else if (!this.adi && !this.adj) {
         if (this.ael) {
            this.ael = false;
            return true;
         } else if (this.aeo) {
            this.aeo = false;
            return true;
         } else {
            return false;
         }
      } else {
         if (!this.adj || !this.ro()) {
            this.adi = false;
            this.adj = false;
            this.adr = false;
            this.bci = false;
         }

         return true;
      }
   }

   private int vg() {

      return ng(this.r());
   }

   private int vh() {

      return !this.nb() ? 60 : nh(this.s());
   }

   private static int vi() {

      return 28 + BlockSetE.OPTIONS.length * 16 + 16;
   }

   private int vj() {

      if (this.act != null) {
         return 583218584 ^ 583217560;
      } else if (!this.nb() && this.adt == null && this.adu == null && this.adv == null) {
         int var1 = this.bte;
         if (this.adi || this.adj) {
            var1 |= 32;
         }

         if (this.aeo) {
            var1 |= 64;
         }

         if (this.ael) {
            var1 |= 683570442 ^ 683570570;
         }

         return var1;
      } else {
         return -21202971 ^ -21203483;
      }
   }

   private void vk(boolean var1) {

      if (var1 != this.btg) {
         int[] var2 = this.btf;
         if (var1 && yv) {
            var2[0] = yz;
            var2[1] = za;
            var2[2] = zb;
            var2[3] = zc;
            var2[4] = zd;
            var2[5] = zh;
            var2[6] = zi;
            var2[7] = zz;
            var2[8] = aaa;
            var2[9] = aab;
            var2[10] = aac;
            var2[11] = yj;
            var2[12] = yk;
            float var4 = (float)Math.max(70, Math.min(100, SyncController.ai)) / 78.0F;
            yz = vl(var2[0], m(643826421 ^ 643826237, var4));
            za = vl(var2[1], m(529758621 ^ 529758538, var4));
            zb = vl(var2[2], m(746637567 ^ 746637342, var4));
            zh = vl(var2[5], m(-1739809207 ^ -1739809148, var4));
            zi = vl(var2[6], m(-1026439788 ^ -1026439869, var4));
            zz = vl(var2[7], -105337434 ^ -105337482);
            var2[13] = amy;
            amy = vl(var2[13], 541817956 ^ 541818036);
            aaa = vl(var2[8], 267361312 ^ 267361532);
            yj = yl;
            yk = ym;
            this.btg = true;
         } else {
            if (var1) {
               int var3 = this.afg;
               var2[0] = yz;
               var2[1] = za;
               var2[2] = zb;
               var2[3] = zc;
               var2[4] = zd;
               var2[5] = zh;
               var2[6] = zi;
               var2[7] = zz;
               var2[8] = aaa;
               var2[9] = aab;
               var2[10] = aac;
               var2[11] = yj;
               var2[12] = yk;
               yz = vm(var2[0], var3);
               za = vm(var2[1], var3);
               zb = vm(var2[2], var3);
               zc = vm(var2[3], var3);
               zd = vm(var2[4], var3);
               zh = vm(var2[5], var3);
               zi = vm(var2[6], var3);
               zz = vm(var2[7], var3);
               var2[13] = amy;
               amy = vm(var2[13], var3);
               aaa = vm(var2[8], var3);
               aab = vm(var2[9], var3);
               aac = vm(var2[10], var3);
               yj = yl;
               yk = ym;
            } else {
               yz = var2[0];
               za = var2[1];
               zb = var2[2];
               zc = var2[3];
               zd = var2[4];
               zh = var2[5];
               zi = var2[6];
               zz = var2[7];
               amy = var2[13];
               aaa = var2[8];
               aab = var2[9];
               aac = var2[10];
               yj = var2[11];
               yk = var2[12];
            }

            this.btg = var1;
         }
      }
   }

   private static int vl(int var0, int var1) {

      int var2 = Math.max(var0 >>> 24, var1);
      return cq(var0 | 2090512174 ^ -2087014610, -453690052 ^ 469056828, 0.3F) & (-1374291121 ^ -1360395088) | var2 << 24;
   }

   private static int vm(int var0, int var1) {

      int var2 = var0 >>> 24;
      return var2 >= (668454387 ^ 668454156) ? var0 : cq(var1 | 1447301175 ^ -1455157193, var0 | -97688954 ^ 86860422, (float)var2 / 255.0F);
   }

   private void vn(DrawContext var1) {

      try {
         this.vo(var1);
      } catch (Throwable var3) {
         this.uz();
      }

      if (ThemeCache.c()) {
         applyTheme();
      }
   }

   private void vo(DrawContext var1) {

      try {
         float var2 = (float)a.getWindow().getScaleFactor();
         int var3 = a.getWindow().getFramebufferWidth();
         int var4 = a.getWindow().getFramebufferHeight();
         this.as((int)Math.max(1.0, Math.min(3.0, (double)Math.round(this.adk))));
         if (!this.adl) {
            this.aep = this.q();
         }

         float var5 = this.aep;
         ParserEngine[] var6 = xs;
         this.ul();
         if (this.vp()) {
            this.bsz = var2 > 0.0F && var3 > 0 ? (float)var3 / var2 : (float)this.width;
            this.bta = var2 > 0.0F && var4 > 0 ? (float)var4 / var2 : (float)this.height;
            FrameKeeper.m(this.bsz, this.bta, var4 > 0 ? (float)var3 / (float)var4 : 0.0F);
            FrameKeeper.cs = this.vs(var5);
            this.vr();
            FrameKeeper.av = SyncController.ah == 1 ? 0.35F : 0.0F;
            FrameKeeper.ct = (float)(Math.min(5, var6.length) * this.abr) + (float)(Math.min(5, var6.length) - 1) * 6.0F;
            if (!this.afj || this.afk != a.world || FrameKeeper.d() > 576.0F) {
               this.vq();
               this.aec = true;
            }

            if (this.aec) {
               this.aec = false;
               this.uu();
            }

            int var7 = this.vt(var6, var5, var2);
            float var8 = this.vb();
            float var9 = this.vc();
            int var10 = this.vd() ? FrameKeeper.ac(var8, var9, this.vj()) : -1;
            FrameKeeper.ptrS = var10;
            FrameKeeper.ptrX = var8;
            FrameKeeper.ptrY = var9;
            this.aei = var10;
            this.adn = null;
            float var11 = this.afl;
            this.afg = cq(xt | -1931996701 ^ 1943540195, 455049593 ^ -468350611, 0.45F);
            this.vk(true);

            for (int var12 = 0; var12 < var7; var12++) {
               int var13 = this.afd[var12];
               int var14 = var13 == var10 ? FrameKeeper.aa(var13, var8, var9) : -1836095186 ^ 1385130286;
               int var15 = var13 == var10 ? FrameKeeper.ab(var13, var8, var9) : 82779720 ^ -990962104;
               this.vx(var1, var13, var6, var14, var15, var11, var2, var5);
            }

            this.vk(false);
            this.wp(var1, var10 >= 0);
            return;
         }

         this.uy();
      } finally {
         this.vk(false);
         GlyphPassCache.boardAbort();
         ahs = false;
         ahq = false;
         ahr = false;
         aht = null;
         ahl = false;
         ahh = -1;
         agi = 1.0F;
         this.aeq = 1.0F;
      }
   }

   private boolean vp() {

      if (a.player != null && a.world != null && a.gameRenderer != null) {
         Camera var1 = a.gameRenderer.getCamera();
         if (var1 == null) {
            return false;
         } else {
            Vec3d var2 = var1.getCameraPos();
            if (var2 == null) {
               return false;
            } else {
               int var3 = (Integer)a.options.getFov().getValue();
               FrameKeeper.ae(var2.x, var2.y, var2.z, var1.getYaw(), var1.getPitch(), (float)var3);
               return true;
            }
         }
      } else {
         return false;
      }
   }

   private void vq() {

      double var1 = 70.0;

      try {
         var1 = (double)((Integer)a.options.getFov().getValue()).intValue();
      } catch (Throwable var14) {
      }

      var1 = var1 < 30.0 ? 30.0 : (var1 > 110.0 ? 110.0 : var1);
      double var3 = var1 < 60.0 ? 60.0 : (var1 > 85.0 ? 85.0 : var1);
      float var5 = (float)Math.tan(Math.toRadians(var3) * 0.5);
      float var6 = (float)Math.tan(Math.toRadians(var1) * 0.5);
      float var7 = 2.5F * var5 / var6;
      var7 = var7 < 1.75F ? 1.75F : (var7 > 2.5F ? 2.5F : var7);
      int var8 = SyncController.ag;
      var7 *= aey[var8 <= 0 ? 0 : (var8 >= 2 ? 2 : 1)];
      float var9 = 0.45F * var7 * var5;
      ParserEngine[] var10 = xs;
      int var11 = Math.min(5, var10.length);
      int var12 = 0;

      for (int var13 = 0; var13 < var11; var13++) {
         var12 = Math.max(var12, 24 + Math.min(-1971644742 ^ -1971644462, this.aq(this.y(var10[var13])) + 5));
      }

      ClientPlayerEntity var18 = a.player;
      if (var18 != null) {
         var9 = Math.max(var9, (float)var12 * FrameKeeper.cs - (float)(FrameKeeper.ak - var18.getY() - 0.1));
      }

      FrameKeeper.c(FrameKeeper.aj, FrameKeeper.ak, FrameKeeper.al, FrameKeeper.yaw, var9, var7);
      this.aes = 0.72F * var7 * var6 / (2.0F * var5);
      this.afj = true;
      this.afk = a.world;
   }

   private void vr() {

      float var1 = this.ajg;
      if (this.afm) {
         this.afl = SyncController.x ? 0.0F : Math.max(0.0F, this.afl - var1 / 0.14F);
         if (this.afl <= 0.0F && !this.aeb) {
            this.aeb = true;
            a.send(() -> {

               this.te(true);
            });
         }
      } else if (this.afl < 1.0F) {
         this.afl = SyncController.x ? 1.0F : Math.min(1.0F, this.afl + var1 / 0.18F);
      }
   }

   private float vs(float var1) {

      double var2 = 70.0;

      try {
         var2 = (double)((Integer)a.options.getFov().getValue()).intValue();
      } catch (Throwable var5) {
      }

      var2 = var2 < 60.0 ? 60.0 : (var2 > 85.0 ? 85.0 : var2);
      float var4 = (float)Math.tan(Math.toRadians(var2) * 0.5);
      return 2.0F * var1 * 2.0F * var4 / (float)Math.max(1, this.height);
   }

   private int vt(ParserEngine[] var1, float var2, float var3) {

      boolean var4 = this.adi || this.adj;
      boolean var5 = this.nb() || this.adt != null || this.adu != null || this.adv != null;
      long var6 = System.nanoTime() - this.aet;
      boolean var8 = SyncController.x;
      boolean var9 = !this.afm;

      for (int var10 = 0; var10 < 5; var10++) {
         FrameKeeper.cx[var10] = var10 < var1.length && var9 && (var8 || var6 >= aeu[var10]);
      }

      boolean var19 = var9 && (var8 || var6 >= 105000000L);
      FrameKeeper.cx[5] = var4;
      FrameKeeper.cx[6] = this.aeo;
      FrameKeeper.cx[7] = this.ael;
      FrameKeeper.cx[8] = var19;
      FrameKeeper.cx[11] = var19;
      FrameKeeper.cx[12] = var19;
      FrameKeeper.cx[9] = var5;
      FrameKeeper.cx[10] = this.act != null;
      if (!var5) {
         this.agd = null;
         this.age = null;
         this.agf = null;
         this.agg = null;
         this.agh = null;
      }

      if (this.act == null) {
         this.agc = null;
      }

      FrameKeeper.ad(SyncController.x ? 1.0F : this.ajg);
      int var11 = Math.min(5, var1.length);
      float var12 = 0.0F;

      for (int var13 = 0; var13 < var11; var13++) {
         int var14 = Math.min(-2118497784 ^ -2118497440, this.aq(this.y(var1[var13])) + 5);
         this.aej[var13] = (float)(24 + Math.round((float)var14 * this.cr(var1[var13])));
         var12 = Math.max(var12, this.aej[var13]);
      }

      FrameKeeper.ct = (float)(var11 * this.abr) + (float)(var11 - 1) * 6.0F;
      FrameKeeper.cu = var12;
      this.vu();
      int var20 = 0;
      int var21 = 0;

      for (int var15 = 0; var15 < 13; var15++) {
         boolean var16 = FrameKeeper.cx[var15] || FrameKeeper.cv[var15] > 0.004F && (var15 == 6 || var15 == 7 || FrameKeeper.PLANE[var15]);
         if (FrameKeeper.PLANE[var15] && FrameKeeper.cx[var15] && FrameKeeper.cv[var15] >= 0.25F) {
            var21 |= 1 << var15;
         }

         if (!var16) {
            FrameKeeper.vis[var15] = false;
         } else {
            this.vw(var15, var1, var2, var3);
            if (FrameKeeper.vis[var15]) {
               this.afd[var20++] = var15;
            }
         }
      }

      this.bte = var21;
      float[] var22 = this.afe;

      for (int var23 = 0; var23 < var20; var23++) {
         int var17 = this.afd[var23];
         var22[var17] = var17 == 10 ? -3000.0F : (var17 == 9 ? -2000.0F : FrameKeeper.dep[var17]);
      }

      for (int var24 = 1; var24 < var20; var24++) {
         int var25 = this.afd[var24];

         int var18;
         for (var18 = var24 - 1; var18 >= 0 && var22[this.afd[var18]] < var22[var25]; var18--) {
            this.afd[var18 + 1] = this.afd[var18];
         }

         this.afd[var18 + 1] = var25;
      }

      return var20;
   }

   private void vu() {

      int var1 = Math.max(-1268263383 ^ -1268263027, Math.round(FrameKeeper.ct));
      this.afw = var1;
      this.ej(var1);
      int var2 = (var1 - (-1362676268 ^ -1362676472)) / 2;
      int var3 = this.bd(agk[2]) + 22;
      int var4 = this.adc + this.ade + 6;
      int var5 = this.alh - 6 - var3;
      if (var4 + var3 <= var2 - 6) {
         this.afx = var4;
         this.afy = var3;
      } else if (var5 >= var2 + (-2048891124 ^ -2048890898)) {
         this.afx = var5;
         this.afy = var3;
      } else {
         this.afx = 0;
         this.afy = 0;
      }

      boolean var6 = this.afy > 0 && this.afx < var2;
      this.afv[0] = this.adc - 4;
      this.afv[1] = var6 ? this.afx + this.afy + 4 : this.adc + this.ade + 4;
      this.afv[2] = var2 - 4;
      this.afv[3] = var2 + (-669948878 ^ -669948718);
      this.afv[4] = this.afy > 0 && !var6 ? this.afx - 4 : this.alh - 4;
      this.afv[5] = this.alh + this.ali + 4;
   }

   private void vv(int var1) {

      float var2 = FrameKeeper.cs;
      float var3 = 1.0F - FrameKeeper.cv[var1];
      float var4 = FrameKeeper.as - (SyncController.x ? 0.0F : var3 * var3 * 0.05F);
      if (var1 < 5) {
         float var5 = (float)this.abr;
         float var6 = (float)var1 * (var5 + 6.0F) + var5 * 0.5F - FrameKeeper.ct * 0.5F;
         FrameKeeper.e(var1, 0.0F, 0.0F, var5, this.aej[var1], var2, var6, var4);
      } else {
         int var9 = var1 == 8 ? 0 : (var1 == 11 ? 2 : 4);
         int var10 = this.afv[var9];
         int var7 = this.afv[var9 + 1];
         if (var7 - var10 < 2) {
            FrameKeeper.vis[var1] = false;
            return;
         }

         float var8 = (float)(var10 + var7) * 0.5F - (float)this.afw * 0.5F;
         FrameKeeper.e(var1, (float)var10, 0.0F, (float)(var7 - var10), 44.0F, var2, var8, var4 + 0.0F * var2);
      }

      if (FrameKeeper.vis[var1]) {
         if (FrameKeeper.bx1[var1] < -8.0F
            || FrameKeeper.bx0[var1] > (float)this.width + 8.0F
            || FrameKeeper.by1[var1] < -8.0F
            || FrameKeeper.by0[var1] > (float)this.height + 8.0F) {
            FrameKeeper.vis[var1] = false;
         }
      }
   }

   private void vw(int var1, ParserEngine[] var2, float var3, float var4) {

      if (FrameKeeper.PLANE[var1]) {
         this.vv(var1);
      } else {
         float var5 = 0.0F;
         float var6;
         float var7;
         if (var1 == 5) {
            var6 = (float)this.fj();
            var7 = (float)this.fk();
         } else if (var1 == 6) {
            var5 = 20.0F;
            var6 = 220.0F;
            if (this.aby.isEmpty()) {
               var7 = 18.0F;
            } else {
               var7 = (float)(52 + Math.min(1198895009 ^ 1198894793, Math.max(17, this.aq(this.abz) + 5)));
            }
         } else if (var1 == 7) {
            var6 = (float)(this.bd(abn[0]) + 28);
            var7 = 21.0F;
         } else if (var1 == 9) {
            boolean var8 = this.nb();
            var6 = var8
               ? (float)this.vg()
               : (float)(this.adu != null ? -1890914536 ^ -1890914400 : (this.adv != null ? 1975803312 ^ 1975803144 : -1800947710 ^ -1800947526));
            var7 = var8 ? (float)this.vh() : (float)(this.adu != null ? 126 : (this.adv != null ? -79572447 ^ -79572245 : vi()));
         } else {
            var6 = 150.0F;
            var7 = 62.0F;
         }

         FrameKeeper.p(var1, 0.0F, var5, var6, var7, var3);
         if (FrameKeeper.vis[var1]) {
            if (FrameKeeper.cv[var1] < 1.0F) {
               FrameKeeper.y(var1, 0.85F + 0.15F * FrameKeeper.cv[var1]);
            }

            FrameKeeper.z(var1, var4);
            if (FrameKeeper.bx1[var1] < -8.0F
               || FrameKeeper.bx0[var1] > (float)this.width + 8.0F
               || FrameKeeper.by1[var1] < -8.0F
               || FrameKeeper.by0[var1] > (float)this.height + 8.0F) {
               FrameKeeper.vis[var1] = false;
            }
         }
      }
   }

   private void vx(DrawContext var1, int var2, ParserEngine[] var3, int var4, int var5, float var6, float var7, float var8) {

      boolean var9 = var2 == 8 || var2 == 11 || var2 == 12;
      boolean var10 = FrameKeeper.bw[var2];
      agi = Math.max(0.0F, Math.min(1.0F, FrameKeeper.cv[var2] * var6 * FrameKeeper.ao[var2]));
      if (!(agi < 0.01F) && (!var9 || var10)) {
         float var11 = FrameKeeper.sc[var2];
         boolean var12 = FrameKeeper.cd[var2];
         float var13 = var12
            ? Math.min(
               (float)Math.hypot((double)FrameKeeper.m00[var2], (double)FrameKeeper.m01[var2]),
               (float)Math.hypot((double)FrameKeeper.m10[var2], (double)FrameKeeper.m11[var2])
            )
            : var11;
         ahh = this.wf(var2, var13 * var7);
         this.bth = ahh;
         this.bti = var7;
         ahm = var13 * var7 > 0.05F ? 1.0F / (var13 * var7) : 0.5F;
         ahl = true;
         if (var2 < 5) {
            this.wg(var3[var2], var11, var8, var7);
         }

         float var14 = FrameKeeper.m00[var2];
         float var15 = FrameKeeper.m01[var2];
         float var16 = FrameKeeper.m10[var2];
         float var17 = FrameKeeper.m11[var2];
         float var18 = FrameKeeper.tx[var2];
         float var19 = FrameKeeper.ty[var2];
         if (!var10) {
            float var20 = 2.0F * FrameKeeper.lx0[var2] + FrameKeeper.lw[var2];
            var18 += var14 * var20;
            var19 += var15 * var20;
            var14 = -var14;
            var15 = -var15;
         }

         Matrix3x2fStack var24 = var1.getMatrices();
         var24.pushMatrix();

         try {
            if (!var12) {
               var24.mul(afh.set(var14, var15, var16, var17, var18, var19));
            } else {
               FrameKeeper.TN[var2] = 0;
               this.afi = var2;
               this.vz(var1, var2);
               ahs = var10 && GlyphPassCache.boardBegin(var2, this.ajf);
            }

            if (!var10) {
               this.wa(var1, var2);
            } else if (var9) {
               this.wk(var1, var2);
            } else {
               this.wj(var1, var2, var3, var4, var5);
               if (var2 == 5) {
                  this.vy(var1);
               }
            }

            if (ahs) {
               GlyphPassCache.boardEnd(var1);
            }
         } finally {
            GlyphPassCache.boardAbort();
            ahs = false;
            this.afi = -1;
            ahq = false;
            ahr = false;
            aht = null;
            ahl = false;
            var24.popMatrix();
            agi = 1.0F;
            ahh = -1;
            this.aeq = 1.0F;
         }
      } else {
         agi = 1.0F;
      }
   }

   private void vy(DrawContext var1) {

      long var2 = System.nanoTime() - this.btc;
      if (var2 >= 0L && var2 < 1400000000L && !SyncController.x) {
         float var4 = 1.0F - (float)var2 / 1.4E9F;
         int var5 = Math.round(230.0F * var4 * var4);
         if (var5 >= 4) {
            int var6 = o(yo, var5);
            int var7 = this.fj();
            int var8 = this.fk();
            if (!aim) {
               cn(var1, -1.0F, -1.0F, (float)(var7 + 2), (float)(var8 + 2), 17.0F, 9.0F, 0.0F, var6);
            } else {
               bv(var1, -5, -5, var7 + 5, -3, var6);
               bv(var1, -5, var8 + 3, var7 + 5, var8 + 5, var6);
               bv(var1, -5, -3, -3, var8 + 3, var6);
               bv(var1, var7 + 3, -3, var7 + 5, var8 + 3, var6);
            }
         }
      }
   }

   private void vz(DrawContext var1, int var2) {

      PaneGlassCache var3 = ahu[var2];
      if (var3 == null) {
         var3 = new PaneGlassCache();
         ahu[var2] = var3;
      }

      float var4 = 24.0F * Math.max(0.2F, FrameKeeper.sc[var2]) + 2.0F;
      int var5 = (int)Math.floor((double)(FrameKeeper.bx0[var2] - var4));
      int var6 = (int)Math.floor((double)(FrameKeeper.by0[var2] - var4));
      int var7 = (int)Math.ceil((double)(FrameKeeper.bx1[var2] + var4));
      int var8 = (int)Math.ceil((double)(FrameKeeper.by1[var2] + var4));
      float var9 = 2.0F * FrameKeeper.lx0[var2] + FrameKeeper.lw[var2];
      var3.twin = null;
      if (!ain) {
         cb();
      }

      if (aia && !aim) {
         PaneGlassCache var10 = ahv[var2];
         if (var10 == null) {
            var10 = new PaneGlassCache();
            ahv[var2] = var10;
         }

         var10.begin(var2, !FrameKeeper.bw[var2], var9, var5, var6, var7, var8, var1.getMatrices(), true);
         var1.state.addSimpleElement(var10);
         var3.twin = var10;
      }

      var3.begin(var2, !FrameKeeper.bw[var2], var9, var5, var6, var7, var8, var1.getMatrices(), false);
      var1.state.addSimpleElement(var3);
      aht = var3;
      ahq = true;
      ahr = false;
   }

   private void wa(DrawContext var1, int var2) {

      int var3 = Math.round(FrameKeeper.lx0[var2]);
      int var4 = Math.round(FrameKeeper.ly0[var2]);
      int var5 = Math.round(FrameKeeper.lw[var2]);
      int var6 = Math.round(FrameKeeper.lh[var2]);
      byte var7 = 10;
      int var8 = yv ? yz : cq(this.afg, -218717118 ^ 234267714, 0.22F);
      if (this.afi >= 0) {
         this.wd(var1, var3, var4, var5, var6, var7, zc, var8, 1, true, true, true);
      } else {
         bu(var1, var3, var4, var5, var6, var7, zc);
         bu(var1, var3 + 1, var4 + 1, var5 - 2, var6 - 2, var7 - 1, var8);
      }
   }

   private void wb(DrawContext var1, float var2, float var3, float var4, float var5) {

      int var6 = this.afi;
      FrameKeeper.t(var6, var2, var3, var4, var5);
      float var7 = FrameKeeper.b00;
      float var8 = FrameKeeper.b01;
      float var9 = FrameKeeper.b10;
      float var10 = FrameKeeper.b11;
      float var11 = FrameKeeper.btx;
      float var12 = FrameKeeper.bty;
      boolean var13 = FrameKeeper.bw[var6];
      if (!var13) {
         float var14 = 2.0F * FrameKeeper.lx0[var6] + FrameKeeper.lw[var6];
         var11 += var7 * var14;
         var12 += var8 * var14;
         var7 = -var7;
         var8 = -var8;
      }

      if (!(var7 * var10 - var9 * var8 > 0.0F)) {
         var7 = 0.0F;
         var8 = 0.0F;
         var9 = 0.0F;
         var10 = 0.0F;
      }

      if (ahq) {
         ahr = false;
         aht.pose(var7, var8, var9, var10, var11, var12);
      }

      if (this.bth >= 0) {
         ahh = this.bth;
      }

      Matrix3x2fStack var15 = var1.getMatrices();
      var15.pushMatrix();
      var15.mul(afh.set(var7, var8, var9, var10, var11, var12));
   }

   private void wc(DrawContext var1, int var2, int var3) {

      Matrix3x2fStack var4 = var1.getMatrices();
      if (var3 > 1) {
         float[] var5 = FrameKeeper.PKX;
         boolean var6 = var5[var3] >= var5[0];
         int var7 = var6 ? var2 : var3 - 1 - var2;
         float var8 = var6 ? var5[var2] : var5[var2 + 1];
         float var9 = var6 ? var5[var2 + 1] : var5[var2];
         int var10 = var7 == 0 ? 0 : Math.round(var8);
         int var11 = var7 == var3 - 1 ? this.width : Math.round(var9);
         var10 = var10 < 0 ? 0 : (var10 > this.width ? this.width : var10);
         var11 = var11 < var10 ? var10 : (var11 > this.width ? this.width : var11);
         var4.pushMatrix();

         try {
            var4.identity();
            var1.enableScissor(var10, 0, var11, this.height);
         } finally {
            var4.popMatrix();
         }
      }

      int var15 = (this.afi * (1226590211 ^ 1226590723) + FrameKeeper.pk0 + var2) * 10;
      float[] var16 = FrameKeeper.TB;
      float var17 = var16[var15 + 4];
      float var18 = var16[var15 + 5];
      float var19 = var16[var15 + 6];
      float var21 = var16[var15 + 7];
      if (!(var17 * var21 - var19 * var18 > 0.0F)) {
         var17 = 0.0F;
         var18 = 0.0F;
         var19 = 0.0F;
         var21 = 0.0F;
      }

      if (ahq) {
         ahr = var2 > 0;
         if (var2 == 0) {
            aht.pose(var17, var18, var19, var21, var16[var15 + 8], var16[var15 + 9]);
         }
      }

      if (var2 == 0 && this.bth >= 0) {
         float var23 = Math.min((float)Math.hypot((double)var17, (double)var18), (float)Math.hypot((double)var19, (double)var21)) * this.bti;
         if (var23 > 0.05F) {
            int var12 = (int)Math.floor((double)(var23 * 10.0F + 0.2F));
            var12 = var12 < ahi ? ahi : (var12 > 45 ? 45 : var12);
            ahh = Math.abs(var12 - this.bth) <= 2 ? this.bth : var12;
            ahm = 1.0F / var23;
         }
      }

      var4.pushMatrix();
      var4.mul(afh.set(var17, var18, var19, var21, var16[var15 + 8], var16[var15 + 9]));
   }

   private void wd(DrawContext var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, boolean var10, boolean var11, boolean var12) {

      if (var4 >= 2 * var9 + 1 && var5 >= 2) {
         if (ahq) {
            this.we(var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12);
         } else {
            int var13 = this.afi;
            int var14 = FrameKeeper.v(var13, (float)var2, (float)var3, (float)(var2 + var4), (float)(var3 + var5));
            int var15 = Math.max(1, var5 / 2);
            var14 = var14 > var15 ? var15 : var14;
            if (var14 > 1) {
               int var16 = (int)(((float)var5 / (float)var14 - 1.0F) * 0.5F);
               var6 = var16 < var6 ? (var16 < 0 ? 0 : var16) : var6;
            }

            int var42 = 2 * var6 + 1;
            int var17 = Math.round((float)var5 / (float)var14);
            int var18 = var17;
            if (var14 > 1) {
               var17 = var11 && var17 < var42 ? var42 : var17;
               var18 = var12 && var18 < var42 ? var42 : var18;
               if (var14 == 2) {
                  var17 = Math.max(var11 ? var42 : 1, Math.min(var5 - (var12 ? var42 : 1), var5 / 2));
                  var18 = var5 - var17;
               }

               if (var17 + var18 > var5) {
                  var14 = 1;
               }
            }

            Matrix3x2fStack var19 = var1.getMatrices();
            int var20 = var3;
            FrameKeeper.cg = true;

            try {
               for (int var21 = 0; var21 < var14; var21++) {
                  int var22 = var21 == var14 - 1
                     ? var3 + var5
                     : (
                        var21 == 0
                           ? var3 + var17
                           : (
                              var21 == var14 - 2
                                 ? var3 + var5 - var18
                                 : var3 + var17 + Math.round((float)((var5 - var17 - var18) * var21) / (float)(var14 - 2))
                           )
                     );
                  boolean var23 = var21 == 0;
                  boolean var24 = var21 == var14 - 1;
                  boolean var25 = var21 < (var14 + 1) / 2;
                  int var26 = !var25 && !var23 ? var20 - 1 : var20;
                  int var27 = var25 && !var24 ? var22 + 1 : var22;
                  FrameKeeper.ch = var14 == 1 ? 0 : (var25 ? 1 : 2);
                  this.wb(var1, (float)var2, (float)var26, (float)(var2 + var4), (float)var27);
                  FrameKeeper.ch = 0;

                  try {
                     boolean var28 = var23 && var11 && var6 > 0;
                     boolean var29 = var24 && var12 && var6 > 0;
                     int var30 = var23 && var10 ? var9 : 0;
                     int var31 = var24 ? var9 : 0;
                     int var32 = var23 ? var30 : -1;
                     if (FrameKeeper.cj) {
                        if (!var28 && !var29) {
                           bv(var1, var2, var26, var2 + var4, var27, var7);
                           bv(var1, var2 + var9, var26 + var32, var2 + var4 - var9, var27 - var31, var8);
                        } else {
                           bx(var1, var2, var26, var4, var27 - var26, var6, var7, var28, var28, var29, var29);
                           bx(
                              var1,
                              var2 + var9,
                              var26 + var32,
                              var4 - 2 * var9,
                              var27 - var26 - var32 - var31,
                              Math.max(1, var6 - var9),
                              var8,
                              var28,
                              var28,
                              var29,
                              var29
                           );
                        }
                     }
                  } finally {
                     var19.popMatrix();
                  }

                  var20 = var22;
               }
            } finally {
               FrameKeeper.cg = false;
               FrameKeeper.ch = 0;
            }
         }
      }
   }

   private void we(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, boolean var9, boolean var10, boolean var11) {

      int var12 = this.afi;
      int var13 = FrameKeeper.v(var12, (float)var1, (float)var2, (float)(var1 + var3), (float)(var2 + var4));
      int var14 = Math.max(1, var4 / 2);
      var13 = var13 > var14 ? var14 : var13;
      FrameKeeper.s(var12, var1, var2, var3, var4, var13);
      ahr = false;
      var5 = Math.min(var5, Math.min(var3 / 2, var4 / 2));
      int var15 = var9 ? var8 : 0;
      if (aia && (var6 | var7) >>> 24 != 0) {
         aht.frost(null, (float)var1, (float)var2, (float)var3, (float)var4, (float)var5, cf(1.0F), var10, var10, var11, var11);
         var7 = cg(var7);
      }

      int var16 = agi >= 0.999F ? var6 : dk(var6, agi);
      int var17 = agi >= 0.999F ? var7 : dk(var7, agi);
      aht.round(null, (float)var1, (float)var2, (float)var3, (float)var4, (float)var5, var16, var10, var10, var11, var11);
      int var18 = var3 - 2 * var8;
      int var19 = var4 - var15 - var8;
      if (var18 > 0 && var19 > 0) {
         int var20 = Math.max(1, Math.min(var5 - var8, Math.min(var18 / 2, var19 / 2)));
         aht.round(null, (float)(var1 + var8), (float)(var2 + var15), (float)var18, (float)var19, (float)var20, var17, var10, var10, var11, var11);
      }
   }

   private int wf(int var1, float var2) {

      float var3 = var2 * 10.0F;
      int var4 = this.aff[var1];
      int var5 = ahi;
      if (var4 < var5 || var4 > 45 || var3 < (float)var4 - 0.5F || var3 > (float)var4 + 1.2F) {
         var4 = (int)Math.floor((double)(var3 + 0.2F));
      }

      var4 = var4 < var5 ? var5 : (var4 > 45 ? 45 : var4);
      this.aff[var1] = var4;
      return var4;
   }

   private void wg(ParserEngine var1, float var2, float var3, float var4) {

      float var5 = this.aes;
      if (var5 <= 1.001F) {
         this.aeq = 1.0F;
      } else {
         int var6 = this.wh(var1);
         float var7 = var6 > 0 ? ((float)this.abr - 30.0F) / (float)var6 : 1.0F;
         var5 = Math.min(var5, Math.min(2.3F, var7));
         this.aeq = var5 < 1.0F ? 1.0F : var5;
         int var8 = (int)Math.floor((double)(var2 * this.aeq * var4 * 10.0F + 0.2F));
         this.aer = var8 < ahi ? ahi : (var8 > 45 ? 45 : var8);
      }
   }

   private int wh(ParserEngine var1) {

      if (this.afc != ahd) {
         Arrays.fill(this.afb, -1);
         this.afc = ahd;
      }

      int var2 = var1.ordinal();
      int var3 = var2 < 5 ? this.afb[var2] : -1;
      if (var3 < 0) {
         var3 = this.bf(var1.a, var1.aK);
         if (var2 < 5) {
            this.afb[var2] = var3;
         }
      }

      return var3;
   }

   private void wi(DrawContext var1, ParserEngine var2, int var3, int var4, int var5) {

      Matrix3x2fStack var6 = var1.getMatrices();
      int var7 = ahh;
      var6.pushMatrix();

      try {
         var6.translate((float)(var3 + 8), (float)(var4 + 12));
         var6.scale(this.aeq, this.aeq);
         ahh = this.aer;
         this.be(var1, var2.a, var2.aK, 0, -4, var5, true);
      } finally {
         ahh = var7;
         var6.popMatrix();
      }
   }

   private void wj(DrawContext var1, int var2, ParserEngine[] var3, int var4, int var5) {

      if (var2 < 5) {
         this.dx(var1, var3[var2], 0, 0, var4, var5);
      } else if (var2 == 5) {
         this.fo(var1, this.fj(), this.fk(), var4, var5);
      } else if (var2 == 6) {
         this.du(var1, 1114379545 ^ 1114379717);
         if (!this.aby.isEmpty()) {
            this.ec(var1, 396077187 ^ 396077151, var4, var5);
         }
      } else if (var2 == 7) {
         this.eq(var1, 0, 0, abn[0], var4, var5);
      } else if (var2 == 9) {
         if (this.nb()) {
            this.oh(var1, this.vg(), this.vh(), var4, var5);
         } else if (this.adt != null) {
            this.pl(var1, 712854277 ^ 712854461, vi(), var4, var5);
         } else if (this.adu != null) {
            this.pq(var1, 1002708850 ^ 1002708938, 126, var4, var5);
         } else if (this.adv != null) {
            this.pz(var1, -1800923251 ^ -1800923339, -858935866 ^ -858936052, var4, var5);
         }
      } else if (var2 == 10) {
         this.dq(var1, 1529194088 ^ 1529194238, 62);
      }
   }

   private void wk(DrawContext var1, int var2) {

      int var3 = this.afw;
      int var4 = (var3 - (-2121531816 ^ -2121531772)) / 2;
      boolean var5 = this.afy > 0;
      if (var2 == 8) {
         this.wl(var1, 0, this.adc - 2, this.add - 1, this.adc + this.ade + 2, this.add + this.adf + 4);
         if (var5 && this.afx < var4) {
            this.wl(var1, 1, this.afx - 2, 11, this.afx + this.afy + 2, 34);
         }
      } else if (var2 == 11) {
         this.wl(var1, 2, var4, 0, var4 + (1613476058 ^ 1613475846), 19);
         this.wl(var1, 3, var4, 20, var4 + (-413528456 ^ -413528412), 38);
      } else {
         this.wl(var1, 4, this.alh - 2, 8, this.alh + this.ali + 2, 39);
         if (var5 && this.afx >= var4) {
            this.wl(var1, 1, this.afx - 2, 11, this.afx + this.afy + 2, 34);
         }
      }
   }

   private void wl(DrawContext var1, int var2, int var3, int var4, int var5, int var6) {

      int var7 = this.afw;
      float var8 = var2 == 2 ? this.wm() : 1.0F;
      if (var8 > 1.001F) {
         var4 = (int)Math.floor((double)(19.0F - 19.0F * var8));
      }

      int var9 = FrameKeeper.u(this.afi, (float)var3, (float)var4, (float)var5, (float)var6);
      int var10 = FrameKeeper.bmx;
      int var11 = FrameKeeper.bmy;
      if (ahs) {
         var9 = 1;
      }

      float var12 = this.ajg;
      int var13 = ahh;
      int var14 = -1;
      float var15 = ahm;
      float var16 = var15;
      Matrix3x2fStack var17 = var1.getMatrices();

      try {
         for (int var18 = 0; var18 < var9; var18++) {
            this.wc(var1, var18, var9);

            try {
               if (var2 == 0) {
                  this.en(var1, var10, var11);
               } else if (var2 == 1) {
                  this.wo(var1, var10, var11);
               } else if (var2 == 2) {
                  if (var8 > 1.001F) {
                     if (var14 < 0) {
                        var14 = (int)Math.floor((double)((float)ahh * var8 + 0.2F));
                        var14 = var14 < ahi ? ahi : (var14 > 45 ? 45 : var14);
                        var16 = ahm / var8;
                     }

                     ahh = var14;
                     ahm = var16;
                     var17.translate((float)var7 * 0.5F, 19.0F);
                     var17.scale(var8, var8);
                     var17.translate((float)(-var7) * 0.5F, -19.0F);
                  }

                  float var19 = (float)this.bd(abo[0]) * 1.5F;
                  int var20 = Math.round(((float)var7 - (var19 + 18.0F)) / 2.0F) - 9;
                  int var21 = Math.round(((float)var7 + var19 + 18.0F) / 2.0F) + 9;
                  ci(var1, (float)var20, 1.0F, (float)(var21 - var20), 18.0F, 9.0F, true, true, true, true, 1.0F);
                  bu(var1, var20, 1, var21 - var20, 18, 9, cg(zh));
                  this.dt(var1, var7);
               } else if (var2 == 3) {
                  this.du(var1, var7);
               } else {
                  this.ep(var1, var10, var11);
               }
            } finally {
               var1.getMatrices().popMatrix();
               if (var9 > 1) {
                  var1.disableScissor();
               }

               this.ajg = 0.0F;
            }
         }
      } finally {
         this.ajg = var12;
         if (var8 > 1.001F) {
            ahh = var13;
            ahm = var15;
         }
      }
   }

   private float wm() {

      float var1 = this.aes;
      return var1 <= 1.001F ? 1.0F : Math.min(2.3F, var1);
   }

   private boolean wn(DrawContext var1, float var2, float var3, float var4, float var5) {

      int var6 = this.afi;
      if (var6 >= 0 && ahs && FrameKeeper.bw[var6]) {
         if (!(afh.m00 * afh.m11 - afh.m10 * afh.m01 > 1.0E-12F)) {
            return false;
         } else {
            Matrix3x2fStack var7 = var1.getMatrices();
            afh.invert(btj).mul(var7);
            float var8 = btj.m00 * var2 + btj.m10 * var3 + btj.m20;
            float var9 = btj.m01 * var2 + btj.m11 * var3 + btj.m21;
            float var10 = btj.m00 * var4 + btj.m10 * var5 + btj.m20;
            float var11 = btj.m01 * var4 + btj.m11 * var5 + btj.m21;
            if (!FrameKeeper.fit(var6, Math.min(var8, var10), Math.min(var9, var11), Math.max(var8, var10), Math.max(var9, var11))) {
               return false;
            } else {
               btk.set(FrameKeeper.b00, FrameKeeper.b01, FrameKeeper.b10, FrameKeeper.b11, FrameKeeper.btx, FrameKeeper.bty).mul(btj);
               var7.pushMatrix();
               var7.set(btk);
               return true;
            }
         }
      } else {
         return false;
      }
   }

   private void wo(DrawContext var1, int var2, int var3) {

      int var4 = this.afx;
      byte var5 = 12;
      int var6 = this.afy;
      byte var7 = 20;
      int var8 = var7 / 2;
      boolean var9 = var2 >= var4 && var2 < var4 + var6 && var3 >= var5 && var3 < var5 + var7;
      float var10 = this.cw(agb, var9);
      if (!this.a(var1, (float)var4, (float)var5, (float)var6, (float)var7, var8)) {
         this.cl(var1, var4, var5, var6, var7, var8);
         bu(var1, var4, var5, var6, var7, var8, var10 <= 0.0F ? zc : cq(zc, zl, var10 * 0.8F));
         bu(var1, var4 + 1, var5 + 1, var6 - 2, var7 - 2, var8 - 1, cg(var10 <= 0.0F ? zh : cq(zh, zi, var10)));
      }

      String var11 = agk[2];
      this.ay(var1, var11, var4 + (var6 - this.bd(var11)) / 2, var5 + (var7 - 8) / 2, var10 <= 0.0F ? yj : cq(yj, yi, var10), yv);
   }

   private void wp(DrawContext var1, boolean var2) {

      Matrix3x2fStack var3 = var1.getMatrices();
      float var4 = this.q();
      int var5 = (int)((float)this.width / var4);
      int var6 = (int)((float)this.height / var4);
      float var7 = this.vb();
      float var8 = this.vc();
      int var9 = 0;
      if ((this.adi || this.adj) && !this.afm) {
         var9 = FrameKeeper.h(5);
         if (var9 != 0) {
            this.wq(var1, var9);
         }
      }

      boolean[] var10 = FrameKeeper.vis;
      if (FrameKeeper.at
         && FrameKeeper.cx[11]
         && !this.afm
         && !var10[0]
         && !var10[1]
         && !var10[2]
         && !var10[3]
         && !var10[4]
         && !var10[8]
         && !var10[11]
         && !var10[12]) {
         int var11 = FrameKeeper.f();
         if (var11 != var9) {
            this.wq(var1, var11);
         }

         if (!afa) {
            afa = true;
            NoticeQueue.a(agk[17], agk[18]);
         }
      }

      wr(var1, var7 - 7.5F, var8 - 7.5F, !var2 && !this.aef ? 6965031 ^ -258623272 : yo);
      var3.pushMatrix();

      try {
         var3.scale(var4, var4);
         agi = 1.0F;
         if (SyncController.r && this.adn != null) {
            this.ws(var1, var5, var6, Math.round(var7 / var4), Math.round(var8 / var4));
         }
      } finally {
         var3.popMatrix();
      }

      try {
         NoticeQueue.d(var1, a.getWindow().getScaledWidth());
      } catch (Throwable var15) {
      }
   }

   private void wq(DrawContext var1, int var2) {

      float var3 = 0.6F + 0.4F * (float)Math.sin((double)System.nanoTime() * 5.0E-9);
      int var4 = o(yo, Math.round(235.0F * var3));
      float var5 = var2 > 0 ? (float)this.width - 18.0F : 18.0F;
      float var6 = (float)this.height * 0.5F;
      Matrix3x2fStack var7 = var1.getMatrices();
      var7.pushMatrix();

      try {
         var7.translate(var5, var6);
         if (var2 < 0) {
            var7.rotate((float) Math.PI);
         }

         bq(var1, -12, -12, 24, 1207643666 ^ -873388538);
         dm(var1, -3, 0, 7, 1, var4);
      } finally {
         var7.popMatrix();
      }
   }

   private static void wr(DrawContext var0, float var1, float var2, int var3) {

      Matrix3x2fStack var4 = var0.getMatrices();
      var4.pushMatrix();

      try {
         var4.translate(var1, var2);
         var0.fill(6, 2, 9, 13, -1509702574 ^ -167525294);
         var0.fill(2, 6, 6, 9, -843460036 ^ -1648766404);
         var0.fill(9, 6, 13, 9, 305502215 ^ 1110808583);
         var0.fill(7, 3, 8, 12, var3);
         var0.fill(3, 7, 7, 8, var3);
         var0.fill(8, 7, 12, 8, var3);
      } finally {
         var4.popMatrix();
      }
   }

   private void ws(DrawContext var1, int var2, int var3, int var4, int var5) {

      BuilderFactory var6 = this.adn;
      char[] var7 = var6.d;
      int var8 = var6.dK;
      int var9 = this.bf(var7, var8) + 16;
      int var10 = var4 + 12;
      int var11 = var5 + 9;
      if (var10 + var9 > var2 - 4) {
         var10 = var4 - 12 - var9;
      }

      var10 = var10 < 4 ? 4 : var10;
      if (var11 + 15 > var3 - 4) {
         var11 = var5 - 24;
      }

      int var12 = this.afg;
      bu(var1, var10, var11, var9, 15, 7, vm(zd, var12));
      bu(var1, var10 + 1, var11 + 1, var9 - 2, 13, 6, vm(zj, var12));
      this.be(var1, var7, var8, var10 + 8, var11 + 3, yi, false);
   }

   private void wt(double var1, double var3) {

      if (this.aef) {
         if (!(var1 > (double)this.width)
            && !(var1 < (double)(-this.width))
            && !(var3 > (double)this.height)
            && !(var3 < (double)(-this.height))) {
            float var5 = this.aeg + (float)var1;
            float var6 = this.aeh + (float)var3;
            this.aeg = var5 < 0.0F ? 0.0F : (var5 > (float)this.width ? (float)this.width : var5);
            this.aeh = var6 < 0.0F ? 0.0F : (var6 > (float)this.height ? (float)this.height : var6);
            this.wv();
         }
      }
   }

   private static float wu(int var0, float var1, float var2) {

      int var3 = FrameKeeper.aa(var0, var1, var2);
      if (var3 == (-862914167 ^ 210827657)) {
         return (float)var3;
      } else {
         float[] var4 = FrameKeeper.TB;
         if (FrameKeeper.cd[var0]) {
            for (int var5 = Math.min(FrameKeeper.TN[var0], -977897739 ^ -977898251) - 1; var5 >= 0; var5--) {
               int var6 = (var0 * (-1020370146 ^ -1020370658) + var5) * 10;
               float var7 = var4[var6 + 4];
               float var8 = var4[var6 + 5];
               float var9 = var4[var6 + 6];
               float var10 = var4[var6 + 7];
               float var11 = var7 * var10 - var9 * var8;
               if (var11 > 1.0E-9F) {
                  float var12 = var1 - var4[var6 + 8];
                  float var13 = var2 - var4[var6 + 9];
                  float var14 = (var10 * var12 - var9 * var13) / var11;
                  float var15 = (var7 * var13 - var8 * var12) / var11;
                  if (var14 >= var4[var6]
                     && var14 < var4[var6 + 2]
                     && var15 >= var4[var6 + 1]
                     && var15 < var4[var6 + 3]
                     && (int)Math.floor((double)var14) == var3) {
                     return var14;
                  }
               }
            }
         }

         float var16 = FrameKeeper.m00[var0] * FrameKeeper.m11[var0] - FrameKeeper.m10[var0] * FrameKeeper.m01[var0];
         if (var16 != 0.0F) {
            float var17 = (FrameKeeper.m11[var0] * (var1 - FrameKeeper.tx[var0]) - FrameKeeper.m10[var0] * (var2 - FrameKeeper.ty[var0])) / var16;
            if ((int)Math.floor((double)var17) == var3) {
               return var17;
            }
         }

         return (float)var3 + 0.5F;
      }
   }

   private void wv() {

      float var1 = this.vb();
      float var2 = this.vc();
      int var3 = this.aee;
      if (this.ace != null && var3 >= 0 && var3 < 13 && FrameKeeper.vis[var3]) {
         this.sx(this.ace, wu(var3, var1, var2), this.acf, this.acg);
      }

      if (this.adl && FrameKeeper.vis[5]) {
         this.je(FrameKeeper.aa(5, var1, var2), 0);
      }

      if (this.adm >= 0 && FrameKeeper.vis[5]) {
         this.jf(0, 0, this.fj(), FrameKeeper.aa(5, var1, var2), FrameKeeper.ab(5, var1, var2));
      }

      if (this.arx >= 0 && FrameKeeper.vis[5]) {
         this.fb(this.arx, wu(5, var1, var2), 0);
      }

      if (this.adw && this.adv != null && FrameKeeper.vis[9]) {
         this.qc(1096736202 ^ 1096736114, 1545341526 ^ 1545341596, FrameKeeper.aa(9, var1, var2), FrameKeeper.ab(9, var1, var2));
      }
   }

   private void ww(double var1) {

      if (this.vd() && !this.aef) {
         this.bcp = true;
         if (this.nb() && this.act == null && this.adt == null && this.adu == null && this.adv == null) {
            float var9 = this.vb();
            float var10 = this.vc();
            if (FrameKeeper.ac(var9, var10, this.vj()) == 9) {
               this.nu(this.vg(), this.vh(), FrameKeeper.aa(9, var9, var10), FrameKeeper.ab(9, var9, var10), (int)(var1 * 14.0));
            }
         } else if (this.act == null && !this.nb() && this.adt == null && this.adu == null && this.adv == null) {
            int var3 = (int)(var1 * 14.0);
            float var4 = this.vb();
            float var5 = this.vc();
            int var6 = FrameKeeper.ac(var4, var5, this.vj());
            if (var6 >= 0) {
               int var7 = FrameKeeper.aa(var6, var4, var5);
               int var8 = FrameKeeper.ab(var6, var4, var5);
               if (var6 < 5) {
                  this.up(xs[var6], 0, 0, var7, var8, var3);
               } else if (var6 == 6 && !this.aby.isEmpty()) {
                  this.uo(-1081736792 ^ -1081736844, var7, var8, var3);
               } else if (var6 == 5) {
                  this.ji(this.fj(), this.fk(), var7, var8, var3);
               }
            }
         }
      }
   }

   private boolean wx(Click var1) {

      try {
         return this.wz(var1);
      } catch (Throwable var3) {
         this.uz();
         return true;
      }
   }

   private boolean wy(KeyInput var1, int var2) {

      try {
         return this.ve(var1, var2);
      } catch (Throwable var4) {
         this.uz();
         return true;
      }
   }

   private boolean wz(Click var1) {

      int var2 = var1.button();
      this.bcp = true;
      if (!this.vd()) {
         return false;
      } else if (this.acr != null) {
         this.tc(var2);
         return true;
      } else {
         float var3 = this.vb();
         float var4 = this.vc();
         if (this.act == null) {
            int var8 = FrameKeeper.ac(var3, var4, this.vj());
            int var9 = var8 >= 0 ? FrameKeeper.aa(var8, var3, var4) : -1457638737 ^ 1763586735;
            int var7 = var8 >= 0 ? FrameKeeper.ab(var8, var3, var4) : 259678043 ^ -814063781;
            this.ack = var8 >= 0 ? wu(var8, var3, var4) : Float.NaN;
            if (this.nb() || this.adt != null || this.adu != null || this.adv != null) {
               return this.xb(var9, var7, var2);
            } else if (var8 == 7) {
               if (var2 == 0 && FrameKeeper.cv[7] > 0.9F && System.nanoTime() - this.aem >= 250000000L) {
                  if (ConfigBridge.c != null) {
                     ConfigBridge.c.Z9();
                  }

                  this.te(false);
               }

               return true;
            } else {
               this.ael = false;
               if (var8 == 5) {
                  this.aee = var8;
                  this.qt(this.fj(), this.fk(), var9, var7, var2);
                  this.xc(var8);
                  return true;
               } else {
                  this.adr = false;
                  this.bbi = false;
                  this.bci = false;
                  if (var8 == 6) {
                     this.aee = var8;
                     if (!this.um(2078631110 ^ 2078630938, var9, var7)) {
                        this.abx = false;
                        if (!this.aby.isEmpty()) {
                           this.un(-462066569 ^ -462066517, var9, var7, var2);
                           this.xc(var8);
                        }
                     }

                     return true;
                  } else if (var8 >= 0 && ((1486937548 ^ 1486931148) & 1 << var8) != 0) {
                     return this.xd(var8, var9, var7, var2);
                  } else {
                     this.abx = false;
                     if (var8 >= 0 && var8 < 5 && FrameKeeper.x(var8, var3, var4)) {
                        return true;
                     } else if (var8 >= 0 && var8 < 5) {
                        this.aee = var8;
                        FrameKeeper.k(var8, var9, var7);
                        this.sl(xs[var8], 0, 0, var9, var7, var2);
                        this.xc(var8);
                        return true;
                     } else if (var2 == 2 && var8 < 0) {
                        this.xa();
                        return true;
                     } else {
                        return false;
                     }
                  }
               }
            }
         } else {
            int var5 = FrameKeeper.aa(10, var3, var4);
            int var6 = FrameKeeper.ab(10, var3, var4);
            if (!FrameKeeper.vis[10] || var5 < 0 || var5 > (-1419866552 ^ -1419866402) || var6 < 0 || var6 > 62) {
               this.st();
               this.sw();
            }

            return true;
         }
      }
   }

   private void xa() {

      this.vq();
      this.uu();

      for (int var1 = 0; var1 < 13; var1++) {
         if (FrameKeeper.PLANE[var1]) {
            FrameKeeper.cv[var1] = 0.0F;
            FrameKeeper.cw[var1] = 0.0F;
         }
      }

      this.bte = 0;
      this.aet = System.nanoTime();
      tw(true);
   }

   private boolean xb(int var1, int var2, int var3) {

      if (this.nb()) {
         this.aee = 9;
         this.qf(this.vg(), this.vh(), var1, var2, var3);
         this.xc(9);
      } else if (this.adt != null) {
         this.pn(1378969433 ^ 1378969569, vi(), var1, var2, var3);
      } else if (this.adu != null) {
         this.pr(-1302852388 ^ -1302852508, 126, var1, var2, var3);
      } else if (this.adv != null) {
         this.aee = 9;
         this.qa(1644854622 ^ 1644854758, -2017484922 ^ -2017484980, var1, var2, var3);
         this.xc(9);
      }

      return true;
   }

   private void xc(int var1) {

      this.xe(var1);
      this.xf(var1);
      if (this.ti()) {
         this.aee = var1;
         this.aef = true;
         this.aeg = (float)((this.width - 15) / 2) + 7.5F;
         this.aeh = (float)((this.height - 15) / 2) + 7.5F;
      }
   }

   private boolean xd(int var1, int var2, int var3, int var4) {

      this.vu();
      FrameKeeper.k(var1, var2, var3);
      if (this.afy > 0 && var2 >= this.afx && var2 < this.afx + this.afy && var3 >= 12 && var3 < 32) {
         if (var4 == 0) {
            this.va();
         }

         return true;
      } else if (this.em(var2, var3)) {
         if (var4 == 1 && var2 >= this.adc && var2 <= this.adc + this.ade) {
            adg = !adg;
            return true;
         } else {
            this.abx = false;

            for (int var5 = 0; var5 < abn.length; var5++) {
               if (var4 == 0 && var2 >= this.alf[var5] && var2 < this.alf[var5] + this.alg[var5]) {
                  if (var5 == 0) {
                     this.ael = true;
                     FrameKeeper.l(7, var1, 0.3F);
                     FrameKeeper.DYN[22] = FrameKeeper.DYN[22] - 0.15F;
                     FrameKeeper.cv[7] = 0.0F;
                     FrameKeeper.cw[7] = 0.0F;
                     this.aem = System.nanoTime();
                  } else {
                     this.xg(var5 == 2);
                  }

                  return true;
               }
            }

            return true;
         }
      } else if (this.um(this.afw, var2, var3)) {
         if (!this.aeo) {
            this.aeo = true;
            FrameKeeper.l(6, var1, 0.3F);
            FrameKeeper.cv[6] = 0.0F;
            FrameKeeper.cw[6] = 0.0F;
         }

         return true;
      } else {
         return false;
      }
   }

   private void xe(int var1) {

      if (this.act != null && this.act != this.agc) {
         this.agc = this.act;
         if (var1 == 5) {
            FrameKeeper.j(10, 1.9F);
         } else {
            FrameKeeper.l(10, var1, 0.6F);
         }

         FrameKeeper.cv[10] = 0.0F;
         FrameKeeper.cw[10] = 0.0F;
      }
   }

   private void xf(int var1) {

      boolean var2 = false;
      if (this.acx != null && this.acx != this.agd) {
         this.agd = this.acx;
         var2 = true;
      }

      if (this.ada != null && this.ada != this.age) {
         this.age = this.ada;
         var2 = true;
      }

      if (this.adt != null && this.adt != this.agf) {
         this.agf = this.adt;
         var2 = true;
      }

      if (this.adu != null && this.adu != this.agg) {
         this.agg = this.adu;
         var2 = true;
      }

      if (this.adv != null && this.adv != this.agh) {
         this.agh = this.adv;
         var2 = true;
      }

      if (var2) {
         if (var1 == 5) {
            FrameKeeper.j(9, 2.0F);
         } else {
            FrameKeeper.l(9, var1, 0.35F);
         }

         FrameKeeper.cv[9] = 0.0F;
         FrameKeeper.cw[9] = 0.0F;
      }
   }

   private void xg(boolean var1) {

      if (this.adm >= 0) {
         this.adm = -1;
         h();
      }

      this.fc();
      this.adi = false;
      this.adj = false;
      this.adr = false;
      if (var1) {
         this.uq();
      } else {
         this.adi = true;
      }

      this.ut();
      FrameKeeper.cv[5] = 0.0F;
      FrameKeeper.cw[5] = 0.0F;
   }

   static {
      applyTheme();
      String[] var0 = new String[]{"Crystal", "Mace", "Sword"};
      Random var1 = new Random();

      for (int var2 = 0; var2 < 3; var2++) {
         int var3 = var1.nextInt();
         char[] var4 = new char[var0[var2].length()];

         for (int var5 = 0; var5 < var4.length; var5++) {
            var4[var5] = (char)(var0[var2].charAt(var5) ^ var3 + var5 * 31);
         }

         agz[var2] = var4;
         aha[var2] = var3;
      }

      ahc = new Style[]{
         Style.EMPTY.withFont(new StyleSpriteSource.Font(Identifier.of("lithium", "gui_1"))),
         Style.EMPTY.withFont(new StyleSpriteSource.Font(Identifier.of("lithium", "gui_2"))),
         Style.EMPTY.withFont(new StyleSpriteSource.Font(Identifier.of("lithium", "gui_3")))
      };
      ahd = 2;
      ahe = ahc[1];
      ahf = new HashMap<>();
      ahh = -1;
      ahi = 10;
      ahj = false;
      ahk = new String[]{"font/gui" + "_o05.j" + "s" + "on"};
      ahl = false;
      ahm = 0.5F;
      ahn = new Style[44];
      aho = new HashMap[44];
      ahq = false;
      ahr = false;
      ahs = false;
      aht = null;
      ahu = new PaneGlassCache[13];
      ahv = new PaneGlassCache[13];
      ahw = Identifier.of("lithium", "round_" + "mask");
      ahy = false;
      aia = false;
      aib = -1;
      aim = false;
      ain = false;
      aio = 2.0F;
      aip = 0.66F;
      aiq = null;
      air = null;
      ait = Identifier.of("lithium", "tri_mask");
      aiv = false;
      aje = new Object();
      ajr = new int[10];
      ajs = new int[10];
      ajt = -1;
      aka = new int[8];

      for (int var7 = 0; var7 < 10; var7++) {
         float var23 = ((float)var7 + 0.5F) / 10.0F;
         float var27 = Math.abs(var23 - 0.5F) * 2.0F;
         int var31 = (int)(150.0F + 55.0F * var27);
         ajr[var7] = cq(n(10, 8, 20, var31), n(4, 4, 10, var31), var27);
      }

      for (int var8 = 0; var8 < 8; var8++) {
         float var24 = Math.abs(((float)var8 + 0.5F) / 8.0F - 0.5F) * 2.0F;
         aka[var8] = n(0, 0, 0, (int)(16.0F + 30.0F * var24));
      }

      akf = new float[]{1.15F, 1.7F, 2.4F, 3.3F};
      akg = new int[]{46, 30, 18, 10};
      aki = ("bloomclient.vip" + "" + "").intern();
      akp = new String[512];
      ala = new Object[]{new Object(), new Object(), new Object()};
      alb = new Object();
      alc = new Object();
      ald = new Object();
      ale = new String[]{abn[0].substring(abn[0].lastIndexOf(32) + 1), abn[1].indexOf(32) > 0 ? abn[1].substring(0, abn[1].indexOf(32)) : abn[1], abn[2]};
      alp = Identifier.of("lithium", "gui_face");
      alq = null;
      alr = false;
      als = new String[]{"Sound on", "Notification chime enabled", "GUI" + " Se" + "t" + "tings", "Back to" + " the defaults"};
      alv = new String[]{
         "Space",
         "Enter",
         "Tab",
         "Backspace",
         "Insert",
         "Delete",
         "Right",
         "Left",
         "Down",
         "Up",
         "Page Up",
         "Pa" + "g" + "e Down",
         "Home",
         "End",
         "Caps Lock",
         "Scroll " + "Lock",
         "Num Lock",
         "Print S" + "c" + "re" + "en",
         "Pause",
         "Left Shift",
         "Left" + " Ctrl",
         "Left Alt",
         "Left S" + "u" + "p" + "er",
         "R" + "ight" + " Shi" + "ft",
         "Rig" + "ht" + " C" + "trl",
         "Right" + " A" + "lt",
         "Right " + "Su" + "p" + "er",
         "Menu",
         "Left M" + "o" + "use",
         "Right Mo" + "use",
         "Middle Mouse",
         "Mouse ",
         "F",
         "Num ",
         "Num Enter",
         "Key ",
         "None",
         "Num .",
         "Num /",
         "Num *",
         "Num -",
         "Num +",
         "Num ="
      };
      ana = new String[]{
         "Res" + "et to de" + "faults",
         "Esc",
         "Close",
         "Reset every GU" + "I " + "setting?",
         "Reset",
         "Cancel",
         "Pre" + "ss a" + " key" + "...",
         "#",
         "%",
         " ms",
         "R",
         "G",
         "B",
         "Esc ca" + "ncels and keeps the old key",
         "...",
         "°",
         "Hue",
         "Satura" + "t" + "ion",
         "Bri" + "ghtne" + "ss",
         "Edit",
         "Editing",
         "Reset everything?",
         "Custom opens the colour editor" + " under the tiles",
         "Back"
      };
      anb = new Object();
      anm = new IdentityHashMap<>();
      ann = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
      ant = new HashMap<>();
      anu = new String[1000];
      apt = new int[]{
         1,
         0,
         -1,
         2,
         26,
         -1,
         6,
         27,
         -1,
         5,
         0,
         -1,
         9,
         1,
         0,
         10,
         2,
         0,
         1,
         1,
         -1,
         5,
         3,
         -1,
         10,
         4,
         3,
         5,
         5,
         -1,
         6,
         6,
         -1,
         1,
         2,
         -1,
         8,
         7,
         -1,
         5,
         8,
         -1,
         10,
         9,
         8,
         5,
         10,
         -1,
         5,
         11,
         -1,
         5,
         12,
         -1,
         5,
         13,
         -1,
         6,
         14,
         -1,
         5,
         15,
         -1,
         5,
         16,
         -1,
         1,
         3,
         -1,
         5,
         17,
         -1,
         5,
         18,
         -1,
         5,
         19,
         -1,
         7,
         20,
         -1,
         1,
         4,
         -1,
         5,
         21,
         -1,
         9,
         22,
         21,
         9,
         23,
         21,
         10,
         24,
         21,
         5,
         25,
         -1
      };
      apu = apt.length / 3;
      apw = new String[]{"Appear" + "a" + "n" + "ce", "B" + "ackgr" + "ound", "Interface", "Sound", "3D Menu", "Themes"};
      apx = new String[apw.length];
      apy = new String[]{
         "Glass" + " Panels",
         "Frost",
         "Opacity",
         "Background Dim",
         "Amount",
         "Backg" + "round Blur",
         "Falli" + "ng" + " Petals",
         "Menu Key",
         "Tooltips",
         "Delay",
         "Type to " + "Sear" + "ch",
         "Remember Layout",
         "Panel Counts",
         "Show K" + "eybinds",
         "Module Order",
         "Reduce Motion",
         "Edit HUD Layout",
         "C" + "lick Sou" + "nds",
         "Notification" + " So" + "u" + "nd",
         "Men" + "u Ambience",
         "Volume",
         "3D GUI",
         "Distance",
         "Shape",
         "Opacity",
         "Close " + "On D" + "amage",
         "Theme",
         "GUI Scale"
      };
      apz = new String[]{
         "Frosted, see-through panels",
         "Ho" + "w much the glass blurs behind it",
         "How solid the" + " panels " + "are",
         "Da" + "rken the world behind " + "the" + " menu",
         "How dark the " + "dim gets",
         "Soften the world behind the menu",
         "Sakura behind the " + "p" + "anels",
         "Opens an" + "d closes th" + "is " + "menu",
         "Describe a module on hover",
         "Wait before " + "a tooltip shows",
         "Start typing anywhere to fin" + "d " + "a module",
         "Keep pane" + "l spots, scroll and op" + "en modules",
         "How many modules are on, i" + "n each header",
         "Each module's key at the end of its row",
         "How each panel lists " + "its mo" + "d" + "ules",
         "Shorter, calmer anima" + "ti" + "ons",
         "Drag the HUD" + " cards into place",
         "A" + " soft tick when you click",
         "Chime wi" + "th every" + " notification",
         "A page turn as the 3D menu opens and c" + "lo" + "ses",
         "For every sound above",
         "Panels float in the " + "wo" + "rld around you",
         "How far the panels float",
         "A flat row or a gentle curve",
         "Ho" + "w s" + "olid the 3" + "D panels are",
         "Close the menu when you take damage",
         "Colours for the " + "w" + "hole menu",
         "S" + "i" + "ze of the whole menu"
      };
      aqa = new String[]{
         "Light", "Normal", "Strong", "Few", "Normal", "Many", "Default", "A-Z", "Near", "Normal", "Far", "Flat", "Curved", "1x", "2x", "3x", "Accent", "Panel"
      };
      aqc = new int[28];
      aqd = new int[28];
      aqe = new int[28];
      aqf = new int[28];
      aqg = new int[28];
      aqh = new int[28];
      aqi = new int[apu];
      aqj = new int[apu];
      aqk = new int[apu];
      aql = new int[5];
      aqm = new int[5];

      for (int var9 = 0; var9 < apw.length; var9++) {
         apx[var9] = apw[var9].toUpperCase(Locale.ROOT);
      }

      int[][] var10 = new int[][]{{1, 0, 3}, {6, 3, 3}, {14, 6, 2}, {22, 8, 3}, {23, 11, 2}, {27, 13, 3}};

      for (int[] var35 : var10) {
         aqc[var35[0]] = var35[1];
         aqd[var35[0]] = var35[2];
      }

      int[][] var26 = new int[][]{{2, 25, 100, 1}, {4, 10, 100, 1}, {9, 0, 1000, 10}, {20, 0, 150, 1}, {24, 70, 100, 1}};

      for (int[] var38 : var26) {
         aqe[var38[0]] = var38[1];
         aqf[var38[0]] = var38[2];
         aqg[var38[0]] = var38[3];
      }

      int var30 = -1;
      byte var34 = 0;

      for (int var37 = 0; var37 < apu; var37++) {
         int var39 = apt[var37 * 3];
         int var6 = apt[var37 * 3 + 1];
         if (var39 == 1) {
            if (var30 >= 0) {
               aqm[var30] = var34 + 5 - aql[var30];
               var34 += 12;
            }

            var30 = var6;
            aql[var6] = var34;
            aqj[var37] = var34;
            aqk[var37] = 19;
            var34 += 19;
         } else {
            aqh[var6] = var39;
            aqj[var37] = var34;
            aqk[var37] = 21;
            var34 += 21;
         }

         aqi[var37] = var30;
      }

      aqm[var30] = var34 + 5 - aql[var30];
      aqn = var34 + 5 + 2;
      arb = new Object[30];
      arc = new Object[28];
      ard = new Object[8];
      are = new Object[8];
      arf = new Object[5];
      arg = new Object[5];
      arh = new Object();
      ari = new Object();

      for (int var11 = 0; var11 < arb.length; var11++) {
         arb[var11] = new Object();
      }

      for (int var12 = 0; var12 < arc.length; var12++) {
         arc[var12] = new Object();
      }

      for (int var13 = 0; var13 < ard.length; var13++) {
         ard[var13] = new Object();
      }

      for (int var14 = 0; var14 < are.length; var14++) {
         are[var14] = new Object();
      }

      for (int var15 = 0; var15 < 5; var15++) {
         arf[var15] = new Object();
         arg[var15] = new Object();
      }

      ate = new String[]{"Local", "Cloud", "Verified"};
      atq = new String[]{
         "Save" + " current set" + "up",
         "Paste share code",
         "Op" + "en folder",
         "Upload current setup",
         "Refresh",
         "Syncin" + "g" + "." + "..",
         "Load co" + "nf" + "ig",
         "Co" + "py " + "share code",
         "Delete",
         "Edit up" + "load",
         "Cancel",
         "Save",
         "Upload",
         "Re-" + "upload curr" + "ent setup",
         "Save changes",
         "Delet" + "e u" + "plo" + "ad",
         "Browse Cl" + "o" + "ud",
         "Name",
         "Modules",
         "Las" + "t saved",
         "Author",
         "Downl" + "oa" + "ds",
         "IN USE",
         "VERIFIED",
         "(you)",
         "No config selected",
         "Pick on" + "e from the l" + "i" + "st",
         "Saved ",
         "by ",
         "  ·  ",
         " d" + "o" + "wn" + "loads",
         "If you l" + "oad " + "it",
         " on",
         " off",
         " uncha" + "nged",
         "See all ",
         " modules",
         "Show" + " l" + "e" + "ss",
         "Every module and settin" + "g, " + "as n" + "ow",
         "Anyone can find and loa" + "d" + " it",
         "Name " + "your con" + "fig",
         "Right" + " now: ",
         " mo" + "dul" + "es" + " on",
         "Pu" + "blish as A" + "nonymous",
         "Shown as ",
         "Anon" + "y" + "mous",
         "your name",
         "?",
         "Delete ",
         "Moves the file to the trash " + "folder: Undo brings it back",
         "Removes it from the cloud library. This can't be undone.",
         "Type a name, then press Enter",
         "Editing ",
         "In use: ",
         " modules on right now",
         "Loading a config replaces your " + "current" + " s" + "etup",
         "No verifi" + "ed configs yet",
         "Configs ch" + "ecked by staff show up here.",
         "Until the" + "n, everything shared by players is in Cloud.",
         "No cloud configs yet",
         "Share yours with Upload current setup.",
         "No saved con" + "figs",
         "Save current setup to make" + " one",
         "Loading...",
         " configs",
         "up" + "dated just" + " n" + "ow",
         "updated ",
         " min ago",
         "Checked just" + " now",
         "Checked ",
         "Enter",
         "Del",
         "Esc",
         "Load",
         "Close",
         "...",
         "Replaces your c" + "urrent set" + "up.",
         "Load " + "it to a" + "p" + "ply.",
         "Re-" + "upl" + "o" + "ad",
         "Today, ",
         "Y" + "esterday",
         "today, ",
         "yest" + "er" + "da" + "y, ",
         ", ",
         ":",
         "+ ",
         "− ",
         "+",
         "−",
         "—",
         " ",
         " config",
         "Edit upload"
      };
      axg = new String[]{
         "Curre" + "nt set" + "up",
         "PINNED",
         "ALL" + " " + "C" + "ONFIGS",
         "Updated",
         ", edited",
         "matches ",
         "not saved as a c" + "onf" + "ig",
         " unsaved",
         "Saved",
         "Save as" + " new",
         "Discard",
         "Rename",
         "Duplicate",
         "Export",
         "Pin",
         "Unpin",
         "Sa" + "ve " + "a copy",
         "Undo",
         "In use",
         "I" + "F YOU LOAD " + "IT",
         "SINCE ",
         "NAME",
         "VISIBILITY",
         " tuned",
         "Based" + " " + "on ",
         "Kept for you wh" + "en the menu clos" + "e" + "s.",
         "Discard goes back to ",
         "Nothing changes: it mat" + "ches y" + "our",
         "cu" + "rrent se" + "t" + "up.",
         "Nothing changed since you loaded",
         "or " + "sa" + "v" + "ed it.",
         "Search ",
         " of ",
         " match ",
         "\"",
         " hidden by " + "the search",
         "No" + " " + "configs" + " match ",
         " s",
         "Loaded ",
         "Pasted share code",
         "Deleted ",
         "Discarded cha" + "n" + "g" + "es",
         "Ctrl+Z",
         "↑ ↓",
         "Select",
         "Clear",
         "Replace ",
         " alread" + "y exi" + "sts",
         "Saving replaces it (",
         ")",
         "Same name as a saved co" + "nfig",
         "Uploading replaces your uplo" + "ad",
         "R" + "e" + "name config",
         "Renames the file in your configs folder",
         "Keybind",
         "GU" + "I se" + "t" + "tings",
         "→",
         "On",
         "Off",
         " ms",
         "turns on",
         "tur" + "ns" + " o" + "ff",
         "NOT" + " SA" + "VED Y" + "ET",
         "Loaded from a share code or the",
         "cloud, or never saved. Save it to keep it.",
         "Save a" + "s new" + " config",
         "Moves to the trash folder.",
         "Undo brings " + "it back for 10 s.",
         "It becomes the conf" + "ig in us" + "e.",
         " theme",
         "Up" + "loa" + "d" + "ed ",
         "Replaces your current setup.",
         "You can undo a load for 10 s.",
         "Updated ",
         "Reserved na" + "me on W" + "ind" + "ows",
         "\"default\" is the autosave",
         "Can" + "'t end wit" + "h" + " a dot",
         "A conf" + "ig with that name exists",
         "No c" + "han" + "ges",
         "Ctrl+S",
         " more",
         " modules on  ·  ",
         "ON AFT" + "ER" + " LO" + "ADING",
         "No" + "t " + "saved",
         " unsa" + "ved" + " changes",
         "Same name as y" + "our up" + "lo" + "ad",
         "Rename",
         "S" + "ave chan" + "g" + "es",
         "default",
         "Restored ",
         "Undo",
         "Already in use",
         "Save se" + "t" + "up",
         "Past" + "e" + " c" + "ode",
         "Upload" + " setup",
         "Folder",
         "It leaves the" + " cloud library for go" + "o" + "d.",
         "Ca" + "n't read this config f" + "ile."
      };
      bbb = new String[]{
         "C" + "onfig loaded",
         "Load failed",
         "Not y" + "ours",
         "You can" + " only delete configs you uplo" + "aded",
         "Deleted",
         "Delete failed",
         "You can only edit configs you uploaded",
         "Type a new na" + "me",
         "Use the name box, then press" + " R" + "ename",
         "Copy failed",
         "Coul" + "d not seria" + "l" + "ise your config",
         "Copied to clipb" + "oa" + "rd",
         " " + "characters",
         "Clipboard e" + "m" + "p" + "ty",
         "Copy a config strin" + "g " + "first",
         "Conf" + "ig imported",
         "Applied from cl" + "i" + "p" + "board",
         "Invalid config string",
         "That does not look like a config",
         "Name r" + "equired",
         "T" + "ype a name for your cloud config",
         "Config " + "saved",
         "Save f" + "a" + "iled",
         "Type a name or pick a config first",
         "Not" + "hing chang" + "ed",
         "Name and visibility ar" + "e unchanged",
         "Loaded ",
         "Saved ",
         "Deleted ",
         "Copied " + "share code  ·  ",
         "Im" + "ported from clipboard",
         "Uplo" + "adi" + "ng ",
         "Downloading ",
         "Updatin" + "g ",
         "Re-u" + "ploading ",
         "De" + "leting ",
         "  ·" + " " + " shown as ",
         "Undone",
         "Rest" + "ored ",
         "Renamed",
         "R" + "ename fa" + "il" + "ed",
         "Dup" + "l" + "icated",
         "Duplica" + "te f" + "ail" + "ed",
         "Exported",
         "E" + "x" + "p" + "ort failed",
         "Pinned ",
         "Unpi" + "nn" + "ed ",
         "Changes dis" + "car" + "d" + "ed",
         "Please " + "w" + "a" + "it",
         "Another sync " + "i" + "s" + " running",
         "Saving a co" + "py of ",
         "Saved a copy: ",
         "Impor" + "ted ",
         "Import failed",
         " configs",
         "Not a confi" + "g" + ": ",
         "exports",
         "Alrea" + "dy in u" + "se",
         "Nothin" + "g to" + " undo",
         "Can't us" + "e that name",
         "Moved to the trash: ",
         "Discarded ch" + "an" + "ges to ",
         "Nothi" + "ng to save: no changes"
      };
      bcd = "";
      bce = new ArrayList<>();
      bcf = 0;
      bcj = 2;
      bck = 2;
      bcq = 0;
      bcr = null;
      bcs = "";
      bct = "";
      bcu = "";
      bcv = "";
      bcw = false;
      bcx = 0L;
      bcy = -1;
      bdv = null;
      bdw = 0L;
      bhq = new String[64];
      bhr = new String[]{"guiSetti" + "n" + "gs", "enabled", new String(new byte[]{107, 101, 121, 66, 105, 110, 100}), "themeIn" + "d" + "ex", "guiKey"};
      bhs = new String[]{"russianT" + "he" + "me", "redColor", "greenColor", "blueColor", "bgRed", "bgGreen", "bgBlue", "gui3dDof"};
      bht = new String[]{
         "th" + "emeIndex",
         "Theme",
         "themeAc" + "ce" + "n" + "tR",
         "Cus" + "tom a" + "ccent" + " R",
         "themeAc" + "ce" + "n" + "tG",
         "Custom accen" + "t G",
         "themeAcce" + "n" + "tB",
         "Custom accent B",
         "themeBgR",
         "Custom panel" + " R",
         "themeBgG",
         "Custom p" + "a" + "nel G",
         "themeBgB",
         "Custom panel B",
         "clickGui" + "Sc" + "a" + "le",
         "Menu s" + "c" + "a" + "le",
         "b" + "ackg" + "rou" + "ndDim",
         "Background dim",
         "tooltips",
         "Tooltips",
         "editHudLa" + "y" + "out",
         "E" + "di" + "t HUD layout",
         "glassPanels",
         "Glass p" + "a" + "n" + "els",
         "gui3d",
         "3D GUI",
         "gui3dAmbience",
         "3D am" + "b" + "ience",
         "gui3dRed" + "uceMo" + "tion",
         "Red" + "u" + "ce motion",
         "gui3dCl" + "oseOnDa" + "ma" + "ge",
         "Close " + "on d" + "amage",
         "guiKey",
         "Menu key",
         "guiScale",
         "GU" + "I scale",
         "notifyS" + "o" + "u" + "nd",
         "Notificat" + "ion sound"
      };

      for (int var16 = 0; var16 < bhq.length; var16++) {
         bhq[var16] = Integer.toString(var16);
      }

      bjy = new Object[30];
      bjz = new int[]{23, 24, 25, 26};
      bli = new Object();
      blj = new Object();
      blk = new Object();
      bll = new Object();
      blm = new Object();
      bln = new Object();
      blo = new Object[48];

      for (int var17 = 0; var17 < 30; var17++) {
         bjy[var17] = new Object();
      }

      for (int var18 = 0; var18 < blo.length; var18++) {
         blo[var18] = new Object();
      }

      ArrayList var19 = new ArrayList();
      var19.add(anb);
      var19.add(arh);
      var19.add(ari);
      var19.add(bli);
      var19.add(bll);
      var19.add(blj);
      var19.add(blk);
      Collections.addAll(var19, arb);
      Collections.addAll(var19, ard);
      Collections.addAll(var19, are);
      Collections.addAll(var19, arg);
      Collections.addAll(var19, bjy);
      Collections.addAll(var19, blo);
      bmj = var19.toArray();
      bno = new String[]{
         "Visuals",
         "Effects dr" + "awn in the world and on screen",
         "Ca" + "rds on your screen, l" + "i" + "ve behind this window",
         "Changes apply l" + "ive",
         "Reset",
         "Reset " + "section",
         "Reset ",
         "?",
         "Done",
         "Edi" + "t" + " Layo" + "ut",
         "Place on scre" + "en",
         "On " + "sc" + "r" + "een",
         "Hides this window while" + " you " + "dra" + "g the card",
         "Drag to " + "t" + "u" + "rn",
         "Drag the" + " card w" + "here you want it",
         "Only on / of" + "f here",
         "Turns the" + " HUD on an" + "d off",
         "Opens this menu",
         "...",
         "Opens Classic view to place it",
         "Click outside it to come back",
         "Edit" + " Layout places the card",
         ""
      };
      bnp = new String[]{
         "Your crosshair, drawn your way",
         "Rings where players jump " + "and la" + "nd",
         "A card for the player " + "you fi" + "g" + "ht",
         "How your held item" + " swings",
         "Sky color," + " stars and fog",
         "See in th" + "e dark",
         "Where pearls fly, an" + "d wh" + "en they land",
         "Around your target, in the" + " " + "w" + "orld",
         "A cone above players' heads",
         "Tr" + "ails behind moving players",
         "A burst where your hits " + "land",
         "Ambien" + "t particles" + " round you",
         "An effect when a player dies"
      };
      bnq = new String[]{
         "Style and keys for every HUD" + " c" + "a" + "rd",
         "Your name, server" + ", FPS and the time",
         "The client's mark in the cor" + "n" + "er",
         "Wher" + "e you are, with a compass",
         "The modules you have on",
         "Modules that have a key, and the key",
         "Players watching you, vanished or spectating",
         "Your active effects",
         "How fa" + "st you are " + "moving",
         "Replaces the van" + "illa hotbar",
         "A no" + "te when a module turns " + "on or " + "off"
      };
      bnr = new String[]{
         "LOOK",
         "SIZE",
         "EXTRAS",
         "EFFECT",
         "RINGS",
         "STYLE",
         "SHOWS",
         "ITEM",
         "COLOR",
         "WORLD",
         "LIGHT",
         "GLOW",
         "KEYS",
         "DETEC" + "T" + "I" + "ON",
         "ORDER",
         "POSITION",
         "MOTION"
      };
      bns = new String[]{"1x", "2x", "3x"};
      bnt = new int[][]{
         {0, 0, 3, 1, 6, 2},
         {0, 3, 1, 0, 4, 4, 8, 2},
         {0, 5, 2, 6},
         {0, 16, 1, 7, 5, 2},
         {0, 8, 6, 9},
         {0, 10},
         {0, 6, 4, 0, 7, 2},
         {0, 3, 2, 0, 5, 11},
         {0, 3, 1, 0},
         {0, 3, 2, 0},
         {0, 3, 1, 0},
         {0, 0, 2, 6},
         {0, 3, 2, 0, 5, 2}
      };
      bnu = new int[]{0, 5, 5, 6};
      bnv = new int[][]{{0, 5, 4, 12}, {0, 6}, {0, 0}, {0, 6}, {0, 0}, new int[0], {0, 13, 2, 14}, new int[0], new int[0], {0, 0, 1, 6}, new int[0]};
      bot = new Object();
      bou = new Object();
      bov = new Object();
      bow = new Object();
      box = new Object();
      boy = new Object();
      boz = new Object();
      bpa = new Object();
      bpb = new Object();
      bpc = new Object();
      bpd = new Object();
      bpe = new Object();
      bpf = new Object();
      bpg = new Object();
      bph = new Object[]{bot, bou, bov, bow, box, boy, boz, bpa, bpb, bpc, bpf};
      bpi = new Object[24];
      bpj = new Object[48];

      for (int var20 = 0; var20 < bpi.length; var20++) {
         bpi[var20] = new Object();
      }

      for (int var21 = 0; var21 < bpj.length; var21++) {
         bpj[var21] = new Object();
      }

      bpl = 0;
      bpm = 0;
      bqe = new String[]{"drag to turn", "click to ins" + "pe" + "ct"};
      bqs = false;
      bqt = new String[100];

      for (int var22 = 0; var22 < bqt.length; var22++) {
         bqt[var22] = var22 / 10 + "." + var22 % 10 + "s";
      }

      brd = new String[]{"Clear", " sel" + "ect" + "ed", " slot", " slots"};
      bri = new String[]{"Sunrise", "Noon", "Sunset", "Midnight", "Day", "Night", "Dusk", "Dawn"};
      brj = new int[]{0, 6000, 12000, 18000};
      btj = new Matrix3x2f();
      btk = new Matrix3x2f();
   }

   private static final class Rb {
      static final double[] T = new double[3];
      static final double[] LIN = new double[256];
      private static int a = Runtime.getRuntime().availableProcessors() - Runtime.getRuntime().availableProcessors();

      static {
         for (int var0 = 0; var0 < 256; var0++) {
            double var1 = (double)var0 / 255.0;
            LIN[var0] = var1 <= 0.04045 ? var1 / 12.92 : Math.pow((var1 + 0.055) / 1.055, 2.4);
         }
      }
   }
}
