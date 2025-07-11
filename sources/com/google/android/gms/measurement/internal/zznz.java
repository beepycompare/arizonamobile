package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zznz {
    protected long zza;
    protected long zzb;
    final /* synthetic */ zzob zzc;
    private final zzay zzd;

    public zznz(zzob zzobVar) {
        Objects.requireNonNull(zzobVar);
        this.zzc = zzobVar;
        this.zzd = new zzny(this, zzobVar.zzu);
        long elapsedRealtime = zzobVar.zzu.zzaZ().elapsedRealtime();
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
        zzob zzobVar = this.zzc;
        zzobVar.zzg();
        zzobVar.zzb();
        if (zzobVar.zzu.zzB()) {
            zzib zzibVar = zzobVar.zzu;
            zzibVar.zzd().zzk.zzb(zzibVar.zzaZ().currentTimeMillis());
        }
        long j2 = j - this.zza;
        if (z || j2 >= 1000) {
            if (!z2) {
                j2 = j - this.zzb;
                this.zzb = j;
            }
            zzib zzibVar2 = zzobVar.zzu;
            zzibVar2.zzaV().zzk().zzb("Recording user engagement, ms", Long.valueOf(j2));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j2);
            zzib zzibVar3 = zzobVar.zzu;
            zzpo.zzav(zzibVar3.zzs().zzh(!zzibVar2.zzc().zzv()), bundle, true);
            if (!z2) {
                zzibVar3.zzj().zzF("auto", "_e", bundle);
            }
            this.zza = j;
            zzay zzayVar = this.zzd;
            zzayVar.zzd();
            zzayVar.zzb(((Long) zzfx.zzaq.zzb(null)).longValue());
            return true;
        }
        zzobVar.zzu.zzaV().zzk().zzb("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j2));
        return false;
    }
}
