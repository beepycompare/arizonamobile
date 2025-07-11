package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
final class zzoz implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Bundle zzc;
    final /* synthetic */ zzpa zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzoz(zzpa zzpaVar, String str, String str2, Bundle bundle) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = bundle;
        Objects.requireNonNull(zzpaVar);
        this.zzd = zzpaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzpf zzpfVar = this.zzd.zza;
        zzpo zzt = zzpfVar.zzt();
        long currentTimeMillis = zzpfVar.zzaZ().currentTimeMillis();
        String str = this.zza;
        zzpfVar.zzD((zzbg) Preconditions.checkNotNull(zzt.zzac(str, this.zzb, this.zzc, "auto", currentTimeMillis, false, true)), str);
    }
}
