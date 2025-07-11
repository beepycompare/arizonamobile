package com.google.android.gms.internal.measurement;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.5.0 */
/* loaded from: classes3.dex */
public final class zznn {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(zznl zznlVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzc(zznlVar, sb, 0);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzb(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                zzb(sb, i, str, obj2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                zzb(sb, i, str, entry);
            }
        } else {
            sb.append('\n');
            zzd(i, sb);
            if (!str.isEmpty()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Character.toLowerCase(str.charAt(0)));
                for (int i2 = 1; i2 < str.length(); i2++) {
                    char charAt = str.charAt(i2);
                    if (Character.isUpperCase(charAt)) {
                        sb2.append("_");
                    }
                    sb2.append(Character.toLowerCase(charAt));
                }
                str = sb2.toString();
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                zzlg zzlgVar = zzlg.zzb;
                sb.append(zzof.zza(new zzlf(((String) obj).getBytes(zzmo.zza))));
                sb.append('\"');
            } else if (obj instanceof zzlg) {
                sb.append(": \"");
                sb.append(zzof.zza((zzlg) obj));
                sb.append('\"');
            } else if (obj instanceof zzme) {
                sb.append(" {");
                zzc((zzme) obj, sb, i + 2);
                sb.append("\n");
                zzd(i, sb);
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                int i3 = i + 2;
                sb.append(" {");
                Map.Entry entry2 = (Map.Entry) obj;
                zzb(sb, i3, "key", entry2.getKey());
                zzb(sb, i3, "value", entry2.getValue());
                sb.append("\n");
                zzd(i, sb);
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj);
            }
        }
    }

    private static void zzc(zznl zznlVar, StringBuilder sb, int i) {
        int i2;
        boolean equals;
        Method method;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zznlVar.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i3 = 0;
        while (true) {
            i2 = 3;
            if (i3 >= length) {
                break;
            }
            Method method3 = declaredMethods[i3];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        hashMap.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i3++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String substring = ((String) entry.getKey()).substring(i2);
            if (!substring.endsWith("List") || substring.endsWith("OrBuilderList") || substring.equals("List") || (method2 = (Method) entry.getValue()) == null || !method2.getReturnType().equals(List.class)) {
                if (!substring.endsWith("Map") || substring.equals("Map") || (method = (Method) entry.getValue()) == null || !method.getReturnType().equals(Map.class) || method.isAnnotationPresent(Deprecated.class) || !Modifier.isPublic(method.getModifiers())) {
                    String.valueOf(substring);
                    if (hashSet.contains("set".concat(String.valueOf(substring)))) {
                        if (substring.endsWith("Bytes")) {
                            String substring2 = substring.substring(0, substring.length() - 5);
                            String.valueOf(substring2);
                            if (treeMap.containsKey("get".concat(String.valueOf(substring2)))) {
                            }
                        }
                        Method method4 = (Method) entry.getValue();
                        String.valueOf(substring);
                        Method method5 = (Method) hashMap.get("has".concat(String.valueOf(substring)));
                        if (method4 != null) {
                            Object zzcr = zzme.zzcr(method4, zznlVar, new Object[0]);
                            if (method5 == null) {
                                if (zzcr instanceof Boolean) {
                                    if (!((Boolean) zzcr).booleanValue()) {
                                    }
                                    zzb(sb, i, substring, zzcr);
                                } else if (zzcr instanceof Integer) {
                                    if (((Integer) zzcr).intValue() == 0) {
                                    }
                                    zzb(sb, i, substring, zzcr);
                                } else if (zzcr instanceof Float) {
                                    if (Float.floatToRawIntBits(((Float) zzcr).floatValue()) == 0) {
                                    }
                                    zzb(sb, i, substring, zzcr);
                                } else if (zzcr instanceof Double) {
                                    if (Double.doubleToRawLongBits(((Double) zzcr).doubleValue()) == 0) {
                                    }
                                    zzb(sb, i, substring, zzcr);
                                } else {
                                    if (zzcr instanceof String) {
                                        equals = zzcr.equals("");
                                    } else if (zzcr instanceof zzlg) {
                                        equals = zzcr.equals(zzlg.zzb);
                                    } else if (zzcr instanceof zznl) {
                                        if (zzcr == ((zznl) zzcr).zzcE()) {
                                        }
                                        zzb(sb, i, substring, zzcr);
                                    } else {
                                        if ((zzcr instanceof Enum) && ((Enum) zzcr).ordinal() == 0) {
                                        }
                                        zzb(sb, i, substring, zzcr);
                                    }
                                    if (equals) {
                                    }
                                    zzb(sb, i, substring, zzcr);
                                }
                            } else {
                                if (!((Boolean) zzme.zzcr(method5, zznlVar, new Object[0])).booleanValue()) {
                                }
                                zzb(sb, i, substring, zzcr);
                            }
                        }
                    }
                } else {
                    zzb(sb, i, substring.substring(0, substring.length() - 3), zzme.zzcr(method, zznlVar, new Object[0]));
                }
            } else {
                zzb(sb, i, substring.substring(0, substring.length() - 4), zzme.zzcr(method2, zznlVar, new Object[0]));
            }
            i2 = 3;
        }
        if (zznlVar instanceof zzmb) {
            Iterator zzc = ((zzmb) zznlVar).zzb.zzc();
            if (zzc.hasNext()) {
                zzmc zzmcVar = (zzmc) ((Map.Entry) zzc.next()).getKey();
                throw null;
            }
        }
        zzoi zzoiVar = ((zzme) zznlVar).zzc;
        if (zzoiVar != null) {
            zzoiVar.zzj(sb, i);
        }
    }

    private static void zzd(int i, StringBuilder sb) {
        while (i > 0) {
            int i2 = 80;
            if (i <= 80) {
                i2 = i;
            }
            sb.append(zza, 0, i2);
            i -= i2;
        }
    }
}
