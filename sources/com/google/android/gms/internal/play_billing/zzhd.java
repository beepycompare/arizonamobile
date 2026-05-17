package com.google.android.gms.internal.play_billing;

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
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes4.dex */
public final class zzhd {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(zzhb zzhbVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzd(zzhbVar, sb, 0);
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
            zzc(i, sb);
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
                String str2 = (String) obj;
                zzev zzevVar = zzev.zza;
                sb.append(zzhz.zza(str2.isEmpty() ? zzev.zza : new zzet(str2.getBytes(zzga.zza))));
                sb.append('\"');
            } else if (obj instanceof zzev) {
                sb.append(": \"");
                sb.append(zzhz.zza((zzev) obj));
                sb.append('\"');
            } else if (obj instanceof zzfu) {
                sb.append(" {");
                zzd((zzfu) obj, sb, i + 2);
                sb.append("\n");
                zzc(i, sb);
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                int i3 = i + 2;
                sb.append(" {");
                Map.Entry entry2 = (Map.Entry) obj;
                zzb(sb, i3, "key", entry2.getKey());
                zzb(sb, i3, "value", entry2.getValue());
                sb.append("\n");
                zzc(i, sb);
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj);
            }
        }
    }

    private static void zzc(int i, StringBuilder sb) {
        while (i > 0) {
            int i2 = 80;
            if (i <= 80) {
                i2 = i;
            }
            sb.append(zza, 0, i2);
            i -= i2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x0186, code lost:
        if (((java.lang.Boolean) r7).booleanValue() == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0188, code lost:
        r13 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0196, code lost:
        if (((java.lang.Integer) r7).intValue() == 0) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01a8, code lost:
        if (java.lang.Float.floatToRawIntBits(((java.lang.Float) r7).floatValue()) == 0) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01be, code lost:
        if (java.lang.Double.doubleToRawLongBits(((java.lang.Double) r7).doubleValue()) == 0) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01d6, code lost:
        if (r13 != false) goto L76;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void zzd(zzhb zzhbVar, StringBuilder sb, int i) {
        int i2;
        boolean booleanValue;
        boolean equals;
        Method method;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zzhbVar.getClass().getDeclaredMethods();
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
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List") && (method2 = (Method) entry.getValue()) != null && method2.getReturnType().equals(List.class)) {
                zzb(sb, i, substring.substring(0, substring.length() - 4), zzfu.zzx(method2, zzhbVar, new Object[0]));
            } else if (substring.endsWith("Map") && !substring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                zzb(sb, i, substring.substring(0, substring.length() - 3), zzfu.zzx(method, zzhbVar, new Object[0]));
            } else if (hashSet.contains("set".concat(String.valueOf(substring))) && (!substring.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(substring.substring(0, substring.length() - 5)))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) hashMap.get("has".concat(String.valueOf(substring)));
                if (method4 != null) {
                    Object zzx = zzfu.zzx(method4, zzhbVar, new Object[0]);
                    if (method5 == null) {
                        if (!(zzx instanceof Boolean)) {
                            if (!(zzx instanceof Integer)) {
                                if (!(zzx instanceof Float)) {
                                    if (!(zzx instanceof Double)) {
                                        if (zzx instanceof String) {
                                            equals = zzx.equals("");
                                        } else if (zzx instanceof zzev) {
                                            equals = zzx.equals(zzev.zza);
                                        } else {
                                            booleanValue = !(zzx instanceof zzhb) ? true : true;
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        booleanValue = ((Boolean) zzfu.zzx(method5, zzhbVar, new Object[0])).booleanValue();
                    }
                    if (booleanValue) {
                        zzb(sb, i, substring, zzx);
                    }
                }
            }
            i2 = 3;
        }
        if (zzhbVar instanceof zzfr) {
            Iterator zzf = ((zzfr) zzhbVar).zzb.zzf();
            if (zzf.hasNext()) {
                zzfs zzfsVar = (zzfs) ((Map.Entry) zzf.next()).getKey();
                throw null;
            }
        }
        zzic zzicVar = ((zzfu) zzhbVar).zzc;
        if (zzicVar != null) {
            zzicVar.zzi(sb, i);
        }
    }
}
