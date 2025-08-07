package com.google.android.gms.measurement.internal;

import java.util.EnumMap;
/* compiled from: com.google.android.gms:play-services-measurement@@23.0.0 */
/* loaded from: classes3.dex */
final class zzan {
    private final EnumMap zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzan() {
        this.zza = new EnumMap(zzjk.class);
    }

    public static zzan zzd(String str) {
        EnumMap enumMap = new EnumMap(zzjk.class);
        if (str.length() >= zzjk.values().length) {
            int i = 0;
            if (str.charAt(0) == '1') {
                zzjk[] values = zzjk.values();
                int length = values.length;
                int i2 = 1;
                while (i < length) {
                    enumMap.put((EnumMap) values[i], (zzjk) zzam.zza(str.charAt(i2)));
                    i++;
                    i2++;
                }
                return new zzan(enumMap);
            }
        }
        return new zzan();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("1");
        for (zzjk zzjkVar : zzjk.values()) {
            zzam zzamVar = (zzam) this.zza.get(zzjkVar);
            if (zzamVar == null) {
                zzamVar = zzam.UNSET;
            }
            sb.append(zzamVar.zzb());
        }
        return sb.toString();
    }

    public final zzam zza(zzjk zzjkVar) {
        zzam zzamVar = (zzam) this.zza.get(zzjkVar);
        return zzamVar == null ? zzam.UNSET : zzamVar;
    }

    public final void zzb(zzjk zzjkVar, int i) {
        zzam zzamVar = zzam.UNSET;
        if (i != -30) {
            if (i != -20) {
                if (i == -10) {
                    zzamVar = zzam.MANIFEST;
                } else if (i != 0) {
                    if (i == 30) {
                        zzamVar = zzam.INITIALIZATION;
                    }
                }
            }
            zzamVar = zzam.API;
        } else {
            zzamVar = zzam.TCF;
        }
        this.zza.put((EnumMap) zzjkVar, (zzjk) zzamVar);
    }

    public final void zzc(zzjk zzjkVar, zzam zzamVar) {
        this.zza.put((EnumMap) zzjkVar, (zzjk) zzamVar);
    }

    private zzan(EnumMap enumMap) {
        EnumMap enumMap2 = new EnumMap(zzjk.class);
        this.zza = enumMap2;
        enumMap2.putAll(enumMap);
    }
}
