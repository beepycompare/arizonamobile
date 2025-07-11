package com.google.android.gms.measurement.internal;

import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
final class zzjz implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzli zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjz(zzli zzliVar, long j) {
        this.zza = j;
        Objects.requireNonNull(zzliVar);
        this.zzb = zzliVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzib zzibVar = this.zzb.zzu;
        zzhd zzhdVar = zzibVar.zzd().zzf;
        long j = this.zza;
        zzhdVar.zzb(j);
        zzibVar.zzaV().zzj().zzb("Session timeout duration set", Long.valueOf(j));
    }
}
