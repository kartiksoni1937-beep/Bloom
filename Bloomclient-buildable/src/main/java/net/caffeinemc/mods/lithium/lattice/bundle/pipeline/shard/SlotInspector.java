package net.caffeinemc.mods.lithium.lattice.bundle.pipeline.shard;

import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFW;

public class SlotInspector {
   private static final MinecraftClient g;
   private static final boolean[] h;
   private static final boolean[] i;
   private static int[] j;
   private static final String[] k;
   private static final String[] l;

   public static boolean a(int var0) {

      if (g.getWindow() == null) {
         return false;
      } else if (var0 >= 0 && var0 <= 7) {
         return GLFW.glfwGetMouseButton(g.getWindow().getHandle(), var0) == 1;
      } else {
         return var0 >= 32 && var0 < (-494456964 ^ -494457476) ? GLFW.glfwGetKey(g.getWindow().getHandle(), var0) == 1 : false;
      }
   }

   public static boolean b(int var0) {

      if (g.getWindow() == null) {
         return false;
      } else {
         boolean var1 = a(var0);
         boolean var2;
         if (var0 >= 0 && var0 <= 7) {
            var2 = var1 && !i[var0];
            i[var0] = var1;
         } else {
            if (var0 < 32 || var0 >= (-1313738991 ^ -1313739503)) {
               return false;
            }

            var2 = var1 && !h[var0];
            h[var0] = var1;
         }

         return var2;
      }
   }

   public static String c(int var0) {

      int var1 = InitExecutor.c();
      int var2 = var0;
      if (var1 == 0) {
         if (var0 == -1) {
            return b(1547014874 ^ -1547022978, 1114182941 ^ -1114196832);
         }

         var2 = var0;
      }

      byte var3;
      label72: {
         if (var1 == 0) {
            if (var2 >= 0) {
               var2 = var0;
               var3 = 7;
               if (var1 != 0) {
                  break label72;
               }

               if (var0 <= 7) {
                  var2 = var0;
                  if (var1 == 0) {
                     switch (var0) {
                        case 0:
                           return b(1323341544 ^ -1323349673, 318342929 ^ -318358448);
                        case 1:
                           return b(-765122632 ^ 765130769, -1264165812 ^ -1264175208);
                        case 2:
                           return b(1327697705 ^ -1327705956, 1974620637 ^ 1974607900);
                        default:
                           var2 = var0 + 1;
                     }
                  }

                  return b(-1228950356 ^ 1228958468, 1521175036 ^ -1521162434) + var2;
               }
            }

            var2 = var0;
         }

         var3 = 0;
      }

      String var4 = GLFW.glfwGetKeyName(var2, var3);
      String var5 = var4;
      if (var1 == 0) {
         if (var4 == null) {
            var2 = var0;
            if (var1 == 0) {
               switch (var0) {
                  case 32:
                     return b(-2043918325 ^ 2043910067, 472985060 ^ -472998003);
                  case 256:
                     return b(1054180863 ^ -1054188964, 433131265 ^ 433135240);
                  case 257:
                     return b(998632738 ^ -998624631, -822327663 ^ -822337908);
                  case 258:
                     return b(-1381765532 ^ 1381773790, 992374296 ^ 992371180);
                  case 260:
                     return b(-962797770 ^ 962789523, -212345373 ^ 212341634);
                  case 261:
                     return b(-1800080105 ^ 1800088241, 932345047 ^ -932319690);
                  case 262:
                     return b(726968998 ^ -726960878, 1744068914 ^ -1744051118);
                  case 263:
                     return b(-919975699 ^ 919967553, 1636269860 ^ -1636245348);
                  case 264:
                     return b(740212798 ^ -740221031, -200796868 ^ -200794487);
                  case 265:
                     return b(-587770146 ^ 587762021, 241972918 ^ 241978383);
                  case 266:
                     return b(-1393563795 ^ 1393572044, -646024562 ^ -646021420);
                  case 267:
                     return b(-1998001811 ^ 1998010051, 1081648328 ^ 1081659347);
                  case 268:
                     return b(-1856476972 ^ 1856485225, -1744855623 ^ 1744862129);
                  case 269:
                     return b(734421199 ^ -734412941, -1872984796 ^ -1872985263);
                  case 340:
                     return b(1608838691 ^ -1608830580, -1446042445 ^ -1446033559);
                  case 341:
                     return b(799073602 ^ -799065374, 50901353 ^ -50902229);
                  case 342:
                     return b(-1256926836 ^ 1256918574, -444929186 ^ 444955965);
                  case 344:
                     return b(2114384193 ^ -2114375944, 2010734575 ^ -2010715247);
                  case 345:
                     return b(-54520508 ^ 54512366, 2137915661 ^ -2137920033);
                  case 346:
                     return b(-2145711408 ^ 2145703293, 1906403292 ^ 1906404306);
                  default:
                     var2 = var0;
               }
            }

            return b(154305962 ^ -154314220, 3023604 ^ 3030819) + var2;
         }

         var5 = var4.toUpperCase();
      }

      return var5;
   }

   public static void b(int[] var0) {

      j = var0;
   }

   private static String b(int var0, int var1) {

      int var2 = (var0 ^ 640093204 ^ -640101448) & (333013193 ^ 333029174);
      if (l[var2] == null) {
         char[] var3 = k[var2].toCharArray();

         int var4 = switch (var3[0] & (1216338989 ^ 1216339154)) {
            case 0 -> 51;
            case 1 -> 32723561 ^ 32723702;
            case 2 -> 47;
            case 3 -> 453265624 ^ 453265497;
            case 4 -> 1851975640 ^ 1851975434;
            case 5 -> 26;
            case 6 -> -540852986 ^ -540852788;
            case 7 -> 65;
            case 8 -> 1;
            case 9 -> -1294423742 ^ -1294423666;
            case 10 -> 19;
            case 11 -> -604613789 ^ -604613736;
            case 12 -> 67;
            case 13 -> 43;
            case 14 -> 38;
            case 15 -> 50757981 ^ 50758139;
            case 16 -> 93;
            case 17 -> -1454674175 ^ -1454673959;
            case 18 -> 1451962914 ^ 1451963107;
            case 19 -> -2135720578 ^ -2135720547;
            case 20 -> 453901362 ^ 453901479;
            case 21 -> 425416088 ^ 425415947;
            case 22 -> -488946727 ^ -488946851;
            case 23 -> 127;
            case 24 -> -565141569 ^ -565141726;
            case 25 -> 110;
            case 26 -> 644585451 ^ 644585329;
            case 27 -> -1293643459 ^ -1293643284;
            case 28 -> -624386188 ^ -624386098;
            case 29 -> -289328977 ^ -289329066;
            case 30 -> 109;
            case 31 -> 5;
            case 32 -> 396539222 ^ 396539284;
            case 33 -> 102;
            case 34 -> 97;
            case 35 -> 111;
            case 36 -> 114;
            case 37 -> 73;
            case 38 -> -1145384464 ^ -1145384694;
            case 39 -> -860957585 ^ -860957534;
            case 40 -> -603905315 ^ -603905532;
            case 41 -> 89;
            case 42 -> 52;
            case 43 -> 6;
            case 44 -> 585083345 ^ 585083258;
            case 45 -> 817445462 ^ 817445558;
            case 46 -> 74;
            case 47 -> 1350782137 ^ 1350782036;
            case 48 -> 1403036689 ^ 1403036916;
            case 49 -> 1842311929 ^ 1842311758;
            case 50 -> -1788795399 ^ -1788795641;
            case 51 -> -1137059410 ^ -1137059549;
            case 52 -> 106;
            case 53 -> 124;
            case 54 -> -1288010899 ^ -1288010863;
            case 55 -> 104;
            case 56 -> 2;
            case 57 -> 4;
            case 58 -> 767376903 ^ 767377103;
            case 59 -> 126;
            case 60 -> 80;
            case 61 -> 123;
            case 62 -> 16;
            case 63 -> -1117437783 ^ -1117437915;
            case 64 -> 59;
            case 65 -> -998529390 ^ -998529531;
            case 66 -> 46;
            case 67 -> 50;
            case 68 -> 63;
            case 69 -> -1950092942 ^ -1950092853;
            case 70 -> 11;
            case 71 -> -1551578717 ^ -1551578777;
            case 72 -> 13;
            case 73 -> 49;
            case 74 -> 64;
            case 75 -> 10;
            case 76 -> 201638445 ^ 201638595;
            case 77 -> 105;
            case 78 -> 23;
            case 79 -> -500710801 ^ -500710692;
            case 80 -> 118;
            case 81 -> -1355876388 ^ -1355876546;
            case 82 -> 78;
            case 83 -> -431627810 ^ -431627908;
            case 84 -> 88;
            case 85 -> -2125571566 ^ -2125571347;
            case 86 -> 101;
            case 87 -> 44;
            case 88 -> 75;
            case 89 -> 148094787 ^ 148094951;
            case 90 -> 1472648997 ^ 1472649107;
            case 91 -> -1615415599 ^ -1615415804;
            case 92 -> 116;
            case 93 -> -258283612 ^ -258283773;
            case 94 -> 0;
            case 95 -> 586550422 ^ 586550394;
            case 96 -> 2101353933 ^ 2101353766;
            case 97 -> -1263028862 ^ -1263028897;
            case 98 -> 22;
            case 99 -> -770950216 ^ -770950396;
            case 100 -> -53801946 ^ -53801743;
            case 101 -> 87;
            case 102 -> 3;
            case 103 -> 94;
            case 104 -> 2129406284 ^ 2129406441;
            case 105 -> 33;
            case 106 -> 1537545963 ^ 1537545824;
            case 107 -> -1159956775 ^ -1159956976;
            case 108 -> 312548194 ^ 312548322;
            case 109 -> 1998221923 ^ 1998221959;
            case 110 -> 62;
            case 111 -> -1257284054 ^ -1257283924;
            case 112 -> -636572465 ^ -636572633;
            case 113 -> -649663898 ^ -649663855;
            case 114 -> 83;
            case 115 -> -1078999195 ^ -1078999092;
            case 116 -> -1941603601 ^ -1941603769;
            case 117 -> 125;
            case 118 -> 416934069 ^ 416933942;
            case 119 -> 52098099 ^ 52098216;
            case 120 -> 68;
            case 121 -> -39955716 ^ -39955901;
            case 122 -> 79;
            case 123 -> 9;
            case 124 -> 61;
            case 125 -> 951072948 ^ 951072875;
            case 126 -> 741591754 ^ 741591636;
            case 127 -> 103;
            case 128 -> 1626471307 ^ 1626471207;
            case 129 -> -428923675 ^ -428923872;
            case 130 -> -2002239128 ^ -2002239076;
            case 131 -> 24;
            case 132 -> -9419097 ^ -9419192;
            case 133 -> -420103610 ^ -420103528;
            case 134 -> 56;
            case 135 -> 39;
            case 136 -> 29;
            case 137 -> 120;
            case 138 -> 2058913276 ^ 2058913120;
            case 139 -> 32;
            case 140 -> 90;
            case 141 -> 60;
            case 142 -> 1466751498 ^ 1466751736;
            case 143 -> 15;
            case 144 -> 725632679 ^ 725632590;
            case 145 -> 570183734 ^ 570183815;
            case 146 -> 40;
            case 147 -> 77;
            case 148 -> -1603641603 ^ -1603641810;
            case 149 -> 71;
            case 150 -> -1284306346 ^ -1284306221;
            case 151 -> 84;
            case 152 -> 119;
            case 153 -> 117;
            case 154 -> 1890662050 ^ 1890661914;
            case 155 -> 58;
            case 156 -> 7;
            case 157 -> -856947543 ^ -856947663;
            case 158 -> 42;
            case 159 -> -2104728761 ^ -2104728696;
            case 160 -> -576064909 ^ -576064893;
            case 161 -> 2037103244 ^ 2037103133;
            case 162 -> -288987461 ^ -288987525;
            case 163 -> 31;
            case 164 -> 1738533552 ^ 1738533410;
            case 165 -> 48;
            case 166 -> 28;
            case 167 -> 85;
            case 168 -> -1765117533 ^ -1765117577;
            case 169 -> 66;
            case 170 -> 54;
            case 171 -> 96;
            case 172 -> -40888405 ^ -40888570;
            case 173 -> -466551356 ^ -466551515;
            case 174 -> 1989247812 ^ 1989247882;
            case 175 -> 12;
            case 176 -> 580216100 ^ 580216206;
            case 177 -> 947064140 ^ 947064203;
            case 178 -> 70;
            case 179 -> 99;
            case 180 -> 57;
            case 181 -> 41;
            case 182 -> 55;
            case 183 -> 34;
            case 184 -> 1375792553 ^ 1375792447;
            case 185 -> 30;
            case 186 -> 82;
            case 187 -> 843368811 ^ 843368844;
            case 188 -> 69;
            case 189 -> 107;
            case 190 -> -1287316365 ^ -1287316315;
            case 191 -> -1603916062 ^ -1603916184;
            case 192 -> 122;
            case 193 -> 25;
            case 194 -> 115;
            case 195 -> 1286756376 ^ 1286756571;
            case 196 -> -7931119 ^ -7930921;
            case 197 -> -156513329 ^ -156513422;
            case 198 -> 81;
            case 199 -> -1092425121 ^ -1092425049;
            case 200 -> 100;
            case 201 -> 168518910 ^ 168518659;
            case 202 -> 1725649670 ^ 1725649888;
            case 203 -> 113;
            case 204 -> 27;
            case 205 -> 121;
            case 206 -> 72;
            case 207 -> 86;
            case 208 -> 45;
            case 209 -> -1144906447 ^ -1144906352;
            case 210 -> 18;
            case 211 -> 91;
            case 212 -> 112;
            case 213 -> 98;
            case 214 -> 36;
            case 215 -> -299899689 ^ -299899870;
            case 216 -> 108;
            case 217 -> 20;
            case 218 -> 1907758107 ^ 1907758317;
            case 219 -> -1386335306 ^ -1386335482;
            case 220 -> -402247083 ^ -402246950;
            case 221 -> -1953742088 ^ -1953742266;
            case 222 -> -2036628513 ^ -2036628627;
            case 223 -> -198537667 ^ -198537482;
            case 224 -> 17;
            case 225 -> 53;
            case 226 -> 76;
            case 227 -> -1724080857 ^ -1724080645;
            case 228 -> 8;
            case 229 -> -1004204143 ^ -1004204263;
            case 230 -> 21;
            case 231 -> 1350437667 ^ 1350437802;
            case 232 -> 243220734 ^ 243220560;
            case 233 -> -1893058331 ^ -1893058491;
            case 234 -> -1403723521 ^ -1403723651;
            case 235 -> 92;
            case 236 -> -84445052 ^ -84445164;
            case 237 -> 1385699076 ^ 1385699210;
            case 238 -> 452386329 ^ 452386498;
            case 239 -> -1991356116 ^ -1991355979;
            case 240 -> 37;
            case 241 -> -673491398 ^ -673491307;
            case 242 -> -1710695228 ^ -1710695404;
            case 243 -> 35;
            case 244 -> 95;
            case 245 -> 1951820860 ^ 1951820936;
            case 246 -> -2116677229 ^ -2116677336;
            case 247 -> -699601428 ^ -699601658;
            case 248 -> -1566140082 ^ -1566139971;
            case 249 -> -1466530076 ^ -1466530223;
            case 250 -> -797342060 ^ -797342107;
            case 251 -> 14;
            case 252 -> -2133098384 ^ -2133098268;
            case 253 -> -621944585 ^ -621944748;
            case 254 -> 1652886416 ^ 1652886346;
            default -> -981773088 ^ -981773209;
         };
         int var5 = (var1 & (1525606076 ^ 1525605955)) - var4;
         if (var5 < 0) {
            var5 += 256;
         }

         int var6 = ((var1 & (312092269 ^ 312138130)) >>> 8) - var4;
         if (var6 < 0) {
            var6 += 256;
         }

         for (int var7 = 0; var7 < var3.length; var7++) {
            int var8 = var7 % 2;
            char var9 = var3[var7];
            if (var8 == 0) {
               var3[var7] = (char)(var9 ^ var5);
               var5 = ((var5 >>> 3 | var5 << 5) ^ var3[var7]) & (-1525923884 ^ -1525924053);
            } else {
               var3[var7] = (char)(var9 ^ var6);
               var6 = ((var6 >>> 3 | var6 << 5) ^ var3[var7]) & (-1416676122 ^ -1416676327);
            }
         }

         l[var2] = new String(var3).intern();
      }

      return l[var2];
   }

   static {
      Object var0 = null;
      String[] var1 = new String[26];
      int var2 = 0;
      int[] var3 = new int[2];
      String var4 = "T¯\u0002k\u0005\u009cÚá\u009c3\u0004"
         + "\u009eBæ\u008e\u0007-î\u0018\u001eA\u0012)\u0006\u0010\u001d¸q»Á\u0007 \rtfÞ\u009cÅ\u0006\nt1Qmn\u0005y,\u009d`)\u0004\u0017i é\u0006Ö_â\u000e!®\u0006"
         + "Æ\u0013SííÃ\u0004\u007fÕ\u007fu\u0006\u0002àíÃö<\u0004Í\u0013\u009dº\u0005\fc.«Ê\u0006\u0088\r´þû%\u0003;TÅ\u0004:\u0004@D\u0004*ù5õ\u0007$"
         + "Ä)_u»°\u0005áFOöÓ\u0007\u0089\u0017Q!hõ\f\u0003\b#\u0096\u00025h";
      int var5 = ("T¯\u0002k\u0005\u009cÚá\u009c3\u0004\u009eBæ\u008e\u0007-î\u0018\u001eA\u0012)\u0006\u0010\u001d¸q»Á\u0007 \rtfÞ\u009cÅ\u0006\nt1Qmn\u0005y,\u009d`)\u0004\u0017i é\u0006Ö_â\u000e!®\u0006Æ\u0013SííÃ\u0004\u007fÕ\u007fu\u0006\u0002àíÃö<\u0004Í\u0013\u009dº\u0005\fc.«Ê\u0006\u0088\r´þû%\u0003;TÅ\u0004:\u0004@D\u0004"
            + "*ù5õ\u0007$Ä)_u»°\u0005áFOöÓ\u0007\u0089\u0017Q!hõ\f\u0003\b#\u0096\u00025h")
         .length();
      char var6 = 4;
      int var21 = -1;
      b(var3);

      label54:
      while (true) {
         byte var8 = 41;
         String var9 = var4.substring(++var21, var21 + var6);
         byte var10 = -1;

         while (true) {
            label49: {
               char[] var11 = var9.toCharArray();
               int var12 = var11.length;
               int var13 = 0;
               byte var14 = var8;
               var0 = var11;
               int var15 = var12;
               byte var16;
               char[] var17;
               int var18;
               if (var12 <= 1) {
                  var17 = var11;
                  var16 = var8;
                  var18 = var13;
               } else {
                  var14 = var8;
                  var15 = var12;
                  if (var12 <= var13) {
                     break label49;
                  }

                  var17 = var11;
                  var16 = var8;
                  var18 = var13;
               }

               while (true) {
                  var17[var18] = (char)(var17[var18] ^ var16 ^ switch (var13 % 7) {
                     case 0 -> 32;
                     case 1 -> 27;
                     case 2 -> 35;
                     case 3 -> 76;
                     case 4 -> 122;
                     case 5 -> 87;
                     default -> 114;
                  });
                  var13++;
                  if (var14 == 0) {
                     var18 = var14;
                     var17 = (char[])var0;
                     var16 = var14;
                  } else {
                     if (var15 <= var13) {
                        break;
                     }

                     var17 = (char[])var0;
                     var16 = var14;
                     var18 = var13;
                  }
               }
            }

            String var22 = new String((char[])var0).intern();
            switch (var10) {
               case 0:
                  var1[var2++] = var22;
                  if ((var21 += var6) >= var5) {
                     k = var1;
                     l = new String[26];
                     g = MinecraftClient.getInstance();
                     h = new boolean[512];
                     i = new boolean[8];
                     break label54;
                  }

                  var6 = var4.charAt(var21);
                  break;
               default:
                  var1[var2++] = var22;
                  if ((var21 += var6) < var5) {
                     var6 = var4.charAt(var21);
                     continue label54;
                  }

                  var4 = "\u0099" + "â#\u0017Í\u0007Íæq" + "_:ÿ\u001d";
                  var5 = ("\u0099â#\u0017Í\u0007Íæ" + "q_:ÿ\u001d").length();
                  var6 = 5;
                  var21 = -1;
            }

            var8 = 64;
            var9 = var4.substring(++var21, var21 + var6);
            var10 = 0;
         }
      }
   }
}
