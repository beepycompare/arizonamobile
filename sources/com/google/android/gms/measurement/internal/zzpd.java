package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzpd {
    private final zzpf zza;
    private int zzb = 1;
    private long zzc = zzd();

    public zzpd(zzpf zzpfVar) {
        this.zza = zzpfVar;
    }

    private final long zzd() {
        zzpf zzpfVar = this.zza;
        Preconditions.checkNotNull(zzpfVar);
        long longValue = ((Long) zzfx.zzu.zzb(null)).longValue();
        long longValue2 = ((Long) zzfx.zzv.zzb(null)).longValue();
        for (int i = 1; i < this.zzb; i++) {
            longValue += longValue;
            if (longValue >= longValue2) {
                break;
            }
        }
        return zzpfVar.zzaZ().currentTimeMillis() + Math.min(longValue, longValue2);
    }

    public final void zza() {
        this.zzb++;
        this.zzc = zzd();
    }

    public final boolean zzb() {
        return this.zza.zzaZ().currentTimeMillis() >= this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ long zzc() {
        return this.zzc;
    }
}
