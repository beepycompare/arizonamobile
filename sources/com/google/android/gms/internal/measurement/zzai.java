package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public abstract class zzai implements zzao, zzak {
    protected final String zzd;
    protected final Map zze = new HashMap();

    public zzai(String str) {
        this.zzd = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzai) {
            zzai zzaiVar = (zzai) obj;
            String str = this.zzd;
            if (str != null) {
                return str.equals(zzaiVar.zzd);
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zzd;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public abstract zzao zza(zzg zzgVar, List list);

    @Override // com.google.android.gms.internal.measurement.zzao
    public final String zzc() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final zzao zzcA(String str, zzg zzgVar, List list) {
        if ("toString".equals(str)) {
            return new zzas(this.zzd);
        }
        return zzak.zzu(this, new zzas(str), zzgVar, list);
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Double zzd() {
        return Double.valueOf(Double.NaN);
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Boolean zze() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Iterator zzf() {
        return zzak.zzv(this.zze);
    }

    public final String zzg() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzak
    public final boolean zzj(String str) {
        return this.zze.containsKey(str);
    }

    @Override // com.google.android.gms.internal.measurement.zzak
    public final zzao zzk(String str) {
        Map map = this.zze;
        return map.containsKey(str) ? (zzao) map.get(str) : zzf;
    }

    @Override // com.google.android.gms.internal.measurement.zzak
    public final void zzm(String str, zzao zzaoVar) {
        if (zzaoVar == null) {
            this.zze.remove(str);
        } else {
            this.zze.put(str, zzaoVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public zzao zzt() {
        return this;
    }
}
