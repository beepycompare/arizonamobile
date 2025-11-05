package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzoa {
    protected long zza;
    protected long zzb;
    final /* synthetic */ zzoc zzc;
    private final zzay zzd;

    public zzoa(zzoc zzocVar) {
        Objects.requireNonNull(zzocVar);
        this.zzc = zzocVar;
        this.zzd = new zznz(this, zzocVar.zzu);
        long elapsedRealtime = zzocVar.zzu.zzaZ().elapsedRealtime();
        this.zza = elapsedRealtime;
        this.zzb = elapsedRealtime;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(long j) {
        this.zzc.zzg();
        this.zzd.zzd();
        this.zza = j;
        this.zzb = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(long j) {
        this.zzd.zzd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc() {
        this.zzd.zzd();
        long elapsedRealtime = this.zzc.zzu.zzaZ().elapsedRealtime();
        this.zza = elapsedRealtime;
        this.zzb = elapsedRealtime;
    }

    public final boolean zzd(boolean z, boolean z2, long j) {
        zzoc zzocVar = this.zzc;
        zzocVar.zzg();
        zzocVar.zzb();
        if (zzocVar.zzu.zzB()) {
            zzic zzicVar = zzocVar.zzu;
            zzicVar.zzd().zzk.zzb(zzicVar.zzaZ().currentTimeMillis());
        }
        long j2 = j - this.zza;
        if (z || j2 >= 1000) {
            if (!z2) {
                j2 = j - this.zzb;
                this.zzb = j;
            }
            zzic zzicVar2 = zzocVar.zzu;
            zzicVar2.zzaV().zzk().zzb("Recording user engagement, ms", Long.valueOf(j2));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j2);
            zzic zzicVar3 = zzocVar.zzu;
            zzpp.zzav(zzicVar3.zzs().zzh(!zzicVar2.zzc().zzv()), bundle, true);
            if (!z2) {
                zzicVar3.zzj().zzF("auto", "_e", bundle);
            }
            this.zza = j;
            zzay zzayVar = this.zzd;
            zzayVar.zzd();
            zzayVar.zzb(((Long) zzfy.zzaq.zzb(null)).longValue());
            return true;
        }
        zzocVar.zzu.zzaV().zzk().zzb("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j2));
        return false;
    }
}
