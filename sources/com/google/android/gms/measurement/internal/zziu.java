package com.google.android.gms.measurement.internal;

import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement@@23.0.0 */
/* loaded from: classes3.dex */
final class zziu implements Runnable {
    final /* synthetic */ zzpl zza;
    final /* synthetic */ zzr zzb;
    final /* synthetic */ zzjd zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zziu(zzjd zzjdVar, zzpl zzplVar, zzr zzrVar) {
        this.zza = zzplVar;
        this.zzb = zzrVar;
        Objects.requireNonNull(zzjdVar);
        this.zzc = zzjdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjd zzjdVar = this.zzc;
        zzjdVar.zzL().zzZ();
        zzpl zzplVar = this.zza;
        if (zzplVar.zza() == null) {
            zzr zzrVar = this.zzb;
            zzjdVar.zzL().zzad(zzplVar.zzb, zzrVar);
            return;
        }
        zzjdVar.zzL().zzac(zzplVar, this.zzb);
    }
}
