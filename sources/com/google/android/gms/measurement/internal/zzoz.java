package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzoz implements Callable {
    final /* synthetic */ zzr zza;
    final /* synthetic */ zzpg zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzoz(zzpg zzpgVar, zzr zzrVar) {
        this.zza = zzrVar;
        Objects.requireNonNull(zzpgVar);
        this.zzb = zzpgVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzr zzrVar = this.zza;
        zzpg zzpgVar = this.zzb;
        zzjl zzB = zzpgVar.zzB((String) Preconditions.checkNotNull(zzrVar.zza));
        zzjk zzjkVar = zzjk.ANALYTICS_STORAGE;
        if (!zzB.zzo(zzjkVar) || !zzjl.zzf(zzrVar.zzs, 100).zzo(zzjkVar)) {
            zzpgVar.zzaV().zzk().zza("Analytics storage consent denied. Returning null app instance id");
            return null;
        }
        return zzpgVar.zzao(zzrVar).zzd();
    }
}
