package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzag implements zzao {
    private final zzao zza;
    private final String zzb;

    public zzag() {
        this.zza = zzf;
        this.zzb = "return";
    }

    public zzag(String str) {
        this.zza = zzf;
        this.zzb = str;
    }

    public zzag(String str, zzao zzaoVar) {
        this.zza = zzaoVar;
        this.zzb = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzag) {
            zzag zzagVar = (zzag) obj;
            return this.zzb.equals(zzagVar.zzb) && this.zza.equals(zzagVar.zza);
        }
        return false;
    }

    public final int hashCode() {
        return (this.zzb.hashCode() * 31) + this.zza.hashCode();
    }

    public final zzao zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final String zzc() {
        throw new IllegalStateException("Control is not a String");
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final zzao zzcA(String str, zzg zzgVar, List list) {
        throw new IllegalStateException("Control does not have functions");
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Double zzd() {
        throw new IllegalStateException("Control is not a double");
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Boolean zze() {
        throw new IllegalStateException("Control is not a boolean");
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Iterator zzf() {
        return null;
    }

    public final String zzg() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final zzao zzt() {
        return new zzag(this.zzb, this.zza.zzt());
    }
}
