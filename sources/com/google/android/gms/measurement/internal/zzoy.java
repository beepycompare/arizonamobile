package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzoy implements Callable {
    final /* synthetic */ zzr zza;
    final /* synthetic */ zzpf zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzoy(zzpf zzpfVar, zzr zzrVar) {
        this.zza = zzrVar;
        Objects.requireNonNull(zzpfVar);
        this.zzb = zzpfVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzr zzrVar = this.zza;
        zzpf zzpfVar = this.zzb;
        zzjk zzB = zzpfVar.zzB((String) Preconditions.checkNotNull(zzrVar.zza));
        zzjj zzjjVar = zzjj.ANALYTICS_STORAGE;
        if (!zzB.zzo(zzjjVar) || !zzjk.zzf(zzrVar.zzs, 100).zzo(zzjjVar)) {
            zzpfVar.zzaV().zzk().zza("Analytics storage consent denied. Returning null app instance id");
            return null;
        }
        return zzpfVar.zzan(zzrVar).zzd();
    }
}
