package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
final class zzio implements Runnable {
    final /* synthetic */ zzr zza;
    final /* synthetic */ zzjc zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzio(zzjc zzjcVar, zzr zzrVar) {
        this.zza = zzrVar;
        Objects.requireNonNull(zzjcVar);
        this.zzb = zzjcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjc zzjcVar = this.zzb;
        zzjcVar.zzL().zzY();
        zzpf zzL = zzjcVar.zzL();
        zzL.zzaW().zzg();
        zzL.zzu();
        zzr zzrVar = this.zza;
        Preconditions.checkNotEmpty(zzrVar.zza);
        zzL.zzv(zzrVar);
        zzL.zzw(zzrVar);
    }
}
