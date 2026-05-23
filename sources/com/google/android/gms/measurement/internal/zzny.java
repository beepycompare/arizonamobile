package com.google.android.gms.measurement.internal;

import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzny {
    final /* synthetic */ zzoc zza;
    private zznx zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzny(zzoc zzocVar) {
        Objects.requireNonNull(zzocVar);
        this.zza = zzocVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza() {
        zzoc zzocVar = this.zza;
        zzocVar.zzg();
        zznx zznxVar = this.zzb;
        if (zznxVar != null) {
            zzocVar.zzm().removeCallbacks(zznxVar);
        }
        zzocVar.zzu.zzd().zzn.zzb(false);
        zzocVar.zzh(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(long j) {
        zzoc zzocVar = this.zza;
        this.zzb = new zznx(this, zzocVar.zzu.zzba().currentTimeMillis(), j);
        zzocVar.zzm().postDelayed(this.zzb, 2000L);
    }
}
