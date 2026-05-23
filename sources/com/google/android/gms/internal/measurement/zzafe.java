package com.google.android.gms.internal.measurement;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzafe {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(zzafc zzafcVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzc(zzafcVar, sb, 0);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzb(StringBuilder sb, int i, String str, Object obj) {
        String replace;
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
                String str2 = (String) obj;
                boolean z = false;
                boolean z2 = false;
                boolean z3 = false;
                for (int i3 = 0; i3 < str2.length(); i3++) {
                    char charAt2 = str2.charAt(i3);
                    if (charAt2 < ' ' || charAt2 > '~') {
                        replace = zzafx.zza(str2.getBytes(StandardCharsets.UTF_8));
                        break;
                    }
                    if (charAt2 == '\"') {
                        z3 = true;
                    } else if (charAt2 == '\'') {
                        z2 = true;
                    } else if (charAt2 == '\\') {
                        z = true;
                    }
                }
                if (z) {
                    str2 = str2.replace("\\", "\\\\");
                }
                replace = z2 ? str2.replace("'", "\\'") : str2;
                if (z3) {
                    replace = replace.replace("\"", "\\\"");
                }
                sb.append(replace);
                sb.append('\"');
            } else if (obj instanceof zzacr) {
                sb.append(": \"");
                sb.append(zzafx.zza(((zzacr) obj).zzm()));
                sb.append('\"');
            } else if (obj instanceof zzadu) {
                sb.append(" {");
                zzc((zzadu) obj, sb, i + 2);
                sb.append("\n");
                zzd(i, sb);
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                int i4 = i + 2;
                sb.append(" {");
                Map.Entry entry2 = (Map.Entry) obj;
                zzb(sb, i4, "key", entry2.getKey());
                zzb(sb, i4, "value", entry2.getValue());
                sb.append("\n");
                zzd(i, sb);
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x018f, code lost:
        if (((java.lang.Boolean) r7).booleanValue() == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0191, code lost:
        r13 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x019f, code lost:
        if (((java.lang.Integer) r7).intValue() == 0) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01b1, code lost:
        if (java.lang.Float.floatToRawIntBits(((java.lang.Float) r7).floatValue()) == 0) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01c7, code lost:
        if (java.lang.Double.doubleToRawLongBits(((java.lang.Double) r7).doubleValue()) == 0) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01df, code lost:
        if (r13 != false) goto L76;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void zzc(zzafc zzafcVar, StringBuilder sb, int i) {
        int i2;
        boolean booleanValue;
        boolean equals;
        Method method;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zzafcVar.getClass().getDeclaredMethods();
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
                zzb(sb, i, substring.substring(0, substring.length() - 4), zzadu.zzcu(method2, zzafcVar, new Object[0]));
            } else if (substring.endsWith("Map") && !substring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                zzb(sb, i, substring.substring(0, substring.length() - 3), zzadu.zzcu(method, zzafcVar, new Object[0]));
            } else {
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
                        Object zzcu = zzadu.zzcu(method4, zzafcVar, new Object[0]);
                        if (method5 == null) {
                            if (!(zzcu instanceof Boolean)) {
                                if (!(zzcu instanceof Integer)) {
                                    if (!(zzcu instanceof Float)) {
                                        if (!(zzcu instanceof Double)) {
                                            if (zzcu instanceof String) {
                                                equals = zzcu.equals("");
                                            } else if (zzcu instanceof zzacr) {
                                                equals = zzcu.equals(zzacr.zza);
                                            } else {
                                                booleanValue = !(zzcu instanceof zzafc) ? true : true;
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            booleanValue = ((Boolean) zzadu.zzcu(method5, zzafcVar, new Object[0])).booleanValue();
                        }
                        if (booleanValue) {
                            zzb(sb, i, substring, zzcu);
                        }
                    }
                }
            }
            i2 = 3;
        }
        if (zzafcVar instanceof zzadr) {
            Iterator zzc = ((zzadr) zzafcVar).zzb.zzc();
            if (zzc.hasNext()) {
                zzads zzadsVar = (zzads) ((Map.Entry) zzc.next()).getKey();
                throw null;
            }
        }
        zzaga zzagaVar = ((zzadu) zzafcVar).zzc;
        if (zzagaVar != null) {
            zzagaVar.zzj(sb, i);
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
