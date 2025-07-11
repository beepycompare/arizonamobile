package com.google.android.gms.measurement.internal;

import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
final class zzit implements Runnable {
    final /* synthetic */ zzpk zza;
    final /* synthetic */ zzr zzb;
    final /* synthetic */ zzjc zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzit(zzjc zzjcVar, zzpk zzpkVar, zzr zzrVar) {
        this.zza = zzpkVar;
        this.zzb = zzrVar;
        Objects.requireNonNull(zzjcVar);
        this.zzc = zzjcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjc zzjcVar = this.zzc;
        zzjcVar.zzL().zzY();
        zzpk zzpkVar = this.zza;
        if (zzpkVar.zza() == null) {
            zzr zzrVar = this.zzb;
            zzjcVar.zzL().zzac(zzpkVar.zzb, zzrVar);
            return;
        }
        zzjcVar.zzL().zzab(zzpkVar, this.zzb);
    }
}
