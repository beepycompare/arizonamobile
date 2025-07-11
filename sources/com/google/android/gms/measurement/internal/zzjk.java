package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.EnumMap;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzjk {
    public static final zzjk zza = new zzjk(null, null, 100);
    private final EnumMap zzb;
    private final int zzc;

    public zzjk(Boolean bool, Boolean bool2, int i) {
        EnumMap enumMap = new EnumMap(zzjj.class);
        this.zzb = enumMap;
        enumMap.put((EnumMap) zzjj.AD_STORAGE, (zzjj) zzh(null));
        enumMap.put((EnumMap) zzjj.ANALYTICS_STORAGE, (zzjj) zzh(null));
        this.zzc = i;
    }

    public static zzjk zza(zzjh zzjhVar, zzjh zzjhVar2, int i) {
        EnumMap enumMap = new EnumMap(zzjj.class);
        enumMap.put((EnumMap) zzjj.AD_STORAGE, (zzjj) zzjhVar);
        enumMap.put((EnumMap) zzjj.ANALYTICS_STORAGE, (zzjj) zzjhVar2);
        return new zzjk(enumMap, -10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzd(int i) {
        return i != -30 ? i != -20 ? i != -10 ? i != 0 ? i != 30 ? i != 90 ? i != 100 ? "OTHER" : "UNKNOWN" : "REMOTE_CONFIG" : "1P_INIT" : "1P_API" : "MANIFEST" : "API" : "TCF";
    }

    public static zzjk zze(Bundle bundle, int i) {
        zzjj[] zzb;
        if (bundle == null) {
            return new zzjk(null, null, i);
        }
        EnumMap enumMap = new EnumMap(zzjj.class);
        for (zzjj zzjjVar : zzji.STORAGE.zzb()) {
            enumMap.put((EnumMap) zzjjVar, (zzjj) zzg(bundle.getString(zzjjVar.zze)));
        }
        return new zzjk(enumMap, i);
    }

    public static zzjk zzf(String str, int i) {
        EnumMap enumMap = new EnumMap(zzjj.class);
        zzjj[] zza2 = zzji.STORAGE.zza();
        for (int i2 = 0; i2 < zza2.length; i2++) {
            String str2 = str == null ? "" : str;
            zzjj zzjjVar = zza2[i2];
            int i3 = i2 + 2;
            if (i3 < str2.length()) {
                enumMap.put((EnumMap) zzjjVar, (zzjj) zzj(str2.charAt(i3)));
            } else {
                enumMap.put((EnumMap) zzjjVar, (zzjj) zzjh.UNINITIALIZED);
            }
        }
        return new zzjk(enumMap, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzjh zzg(String str) {
        if (str == null) {
            return zzjh.UNINITIALIZED;
        }
        if (str.equals("granted")) {
            return zzjh.GRANTED;
        }
        if (str.equals("denied")) {
            return zzjh.DENIED;
        }
        return zzjh.UNINITIALIZED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzjh zzh(Boolean bool) {
        if (bool == null) {
            return zzjh.UNINITIALIZED;
        }
        if (bool.booleanValue()) {
            return zzjh.GRANTED;
        }
        return zzjh.DENIED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzi(zzjh zzjhVar) {
        int ordinal = zzjhVar.ordinal();
        if (ordinal != 2) {
            if (ordinal != 3) {
                return null;
            }
            return "granted";
        }
        return "denied";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static char zzm(zzjh zzjhVar) {
        if (zzjhVar != null) {
            int ordinal = zzjhVar.ordinal();
            if (ordinal != 1) {
                if (ordinal != 2) {
                    return ordinal != 3 ? '-' : '1';
                }
                return '0';
            }
            return '+';
        }
        return '-';
    }

    public static boolean zzu(int i, int i2) {
        int i3 = -30;
        if (i == -20) {
            if (i2 == -30) {
                return true;
            }
            i = -20;
        }
        if (i != -30) {
            i3 = i;
        } else if (i2 == -20) {
            return true;
        }
        return i3 == i2 || i < i2;
    }

    public final boolean equals(Object obj) {
        zzjj[] zzb;
        if (obj instanceof zzjk) {
            zzjk zzjkVar = (zzjk) obj;
            for (zzjj zzjjVar : zzji.STORAGE.zzb()) {
                if (this.zzb.get(zzjjVar) != zzjkVar.zzb.get(zzjjVar)) {
                    return false;
                }
            }
            return this.zzc == zzjkVar.zzc;
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzc * 17;
        for (zzjh zzjhVar : this.zzb.values()) {
            i = (i * 31) + zzjhVar.hashCode();
        }
        return i;
    }

    public final String toString() {
        zzjj[] zzb;
        StringBuilder sb = new StringBuilder("source=");
        sb.append(zzd(this.zzc));
        for (zzjj zzjjVar : zzji.STORAGE.zzb()) {
            sb.append(StringUtils.COMMA);
            sb.append(zzjjVar.zze);
            sb.append("=");
            zzjh zzjhVar = (zzjh) this.zzb.get(zzjjVar);
            if (zzjhVar == null) {
                zzjhVar = zzjh.UNINITIALIZED;
            }
            sb.append(zzjhVar);
        }
        return sb.toString();
    }

    public final int zzb() {
        return this.zzc;
    }

    public final boolean zzc() {
        for (zzjh zzjhVar : this.zzb.values()) {
            if (zzjhVar != zzjh.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }

    public final String zzk() {
        int ordinal;
        StringBuilder sb = new StringBuilder("G1");
        for (zzjj zzjjVar : zzji.STORAGE.zza()) {
            zzjh zzjhVar = (zzjh) this.zzb.get(zzjjVar);
            char c = '-';
            if (zzjhVar != null && (ordinal = zzjhVar.ordinal()) != 0) {
                if (ordinal != 1) {
                    if (ordinal == 2) {
                        c = '0';
                    } else if (ordinal != 3) {
                    }
                }
                c = '1';
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public final String zzl() {
        StringBuilder sb = new StringBuilder("G1");
        for (zzjj zzjjVar : zzji.STORAGE.zza()) {
            sb.append(zzm((zzjh) this.zzb.get(zzjjVar)));
        }
        return sb.toString();
    }

    public final Bundle zzn() {
        Bundle bundle = new Bundle();
        for (Map.Entry entry : this.zzb.entrySet()) {
            String zzi = zzi((zzjh) entry.getValue());
            if (zzi != null) {
                bundle.putString(((zzjj) entry.getKey()).zze, zzi);
            }
        }
        return bundle;
    }

    public final boolean zzo(zzjj zzjjVar) {
        return ((zzjh) this.zzb.get(zzjjVar)) != zzjh.DENIED;
    }

    public final zzjh zzp() {
        zzjh zzjhVar = (zzjh) this.zzb.get(zzjj.AD_STORAGE);
        return zzjhVar == null ? zzjh.UNINITIALIZED : zzjhVar;
    }

    public final zzjh zzq() {
        zzjh zzjhVar = (zzjh) this.zzb.get(zzjj.ANALYTICS_STORAGE);
        return zzjhVar == null ? zzjh.UNINITIALIZED : zzjhVar;
    }

    public final boolean zzr(zzjk zzjkVar) {
        zzjj[] zzjjVarArr;
        EnumMap enumMap = this.zzb;
        for (zzjj zzjjVar : (zzjj[]) enumMap.keySet().toArray(new zzjj[0])) {
            zzjh zzjhVar = (zzjh) enumMap.get(zzjjVar);
            zzjh zzjhVar2 = (zzjh) zzjkVar.zzb.get(zzjjVar);
            zzjh zzjhVar3 = zzjh.DENIED;
            if (zzjhVar == zzjhVar3 && zzjhVar2 != zzjhVar3) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0047 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzjk zzs(zzjk zzjkVar) {
        zzjj[] zzb;
        EnumMap enumMap = new EnumMap(zzjj.class);
        for (zzjj zzjjVar : zzji.STORAGE.zzb()) {
            zzjh zzjhVar = (zzjh) this.zzb.get(zzjjVar);
            zzjh zzjhVar2 = (zzjh) zzjkVar.zzb.get(zzjjVar);
            if (zzjhVar != null) {
                if (zzjhVar2 != null) {
                    zzjh zzjhVar3 = zzjh.UNINITIALIZED;
                    if (zzjhVar != zzjhVar3) {
                        if (zzjhVar2 != zzjhVar3) {
                            zzjh zzjhVar4 = zzjh.POLICY;
                            if (zzjhVar != zzjhVar4) {
                                if (zzjhVar2 != zzjhVar4) {
                                    zzjh zzjhVar5 = zzjh.DENIED;
                                    zzjhVar = (zzjhVar == zzjhVar5 || zzjhVar2 == zzjhVar5) ? zzjhVar5 : zzjh.GRANTED;
                                }
                            }
                        }
                    }
                }
                if (zzjhVar == null) {
                    enumMap.put((EnumMap) zzjjVar, (zzjj) zzjhVar);
                }
            }
            zzjhVar = zzjhVar2;
            if (zzjhVar == null) {
            }
        }
        return new zzjk(enumMap, 100);
    }

    public final zzjk zzt(zzjk zzjkVar) {
        zzjj[] zzb;
        EnumMap enumMap = new EnumMap(zzjj.class);
        for (zzjj zzjjVar : zzji.STORAGE.zzb()) {
            zzjh zzjhVar = (zzjh) this.zzb.get(zzjjVar);
            if (zzjhVar == zzjh.UNINITIALIZED) {
                zzjhVar = (zzjh) zzjkVar.zzb.get(zzjjVar);
            }
            if (zzjhVar != null) {
                enumMap.put((EnumMap) zzjjVar, (zzjj) zzjhVar);
            }
        }
        return new zzjk(enumMap, this.zzc);
    }

    private zzjk(EnumMap enumMap, int i) {
        EnumMap enumMap2 = new EnumMap(zzjj.class);
        this.zzb = enumMap2;
        enumMap2.putAll(enumMap);
        this.zzc = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzjh zzj(char c) {
        if (c != '+') {
            if (c != '0') {
                if (c == '1') {
                    return zzjh.GRANTED;
                }
                return zzjh.UNINITIALIZED;
            }
            return zzjh.DENIED;
        }
        return zzjh.POLICY;
    }
}
