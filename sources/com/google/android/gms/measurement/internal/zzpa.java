package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* loaded from: classes4.dex */
final class zzpa implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Bundle zzc;
    final /* synthetic */ zzpb zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpa(zzpb zzpbVar, String str, String str2, Bundle bundle) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = bundle;
        Objects.requireNonNull(zzpbVar);
        this.zzd = zzpbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzpg zzpgVar = this.zzd.zza;
        zzpp zzt = zzpgVar.zzt();
        long currentTimeMillis = zzpgVar.zzba().currentTimeMillis();
        long elapsedRealtime = zzpgVar.zzd().zzp(null, zzfy.zzbe) ? zzpgVar.zzba().elapsedRealtime() : 0L;
        Bundle bundle = this.zzc;
        String str = this.zzb;
        String str2 = this.zza;
        zzpgVar.zzD((zzbh) Preconditions.checkNotNull(zzt.zzaf(str2, str, bundle, "auto", currentTimeMillis, elapsedRealtime, false, true)), str2);
    }
}
