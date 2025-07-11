package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzhb {
    final /* synthetic */ zzhg zza;
    private final String zzb;
    private final boolean zzc;
    private boolean zzd;
    private boolean zze;

    public zzhb(zzhg zzhgVar, String str, boolean z) {
        Objects.requireNonNull(zzhgVar);
        this.zza = zzhgVar;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
        this.zzc = z;
    }

    public final boolean zza() {
        if (!this.zzd) {
            this.zzd = true;
            zzhg zzhgVar = this.zza;
            this.zze = zzhgVar.zzd().getBoolean(this.zzb, this.zzc);
        }
        return this.zze;
    }

    public final void zzb(boolean z) {
        SharedPreferences.Editor edit = this.zza.zzd().edit();
        edit.putBoolean(this.zzb, z);
        edit.apply();
        this.zze = z;
    }
}
