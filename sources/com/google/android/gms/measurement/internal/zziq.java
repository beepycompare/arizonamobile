package com.google.android.gms.measurement.internal;

import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
final class zziq implements Runnable {
    final /* synthetic */ zzbg zza;
    final /* synthetic */ zzr zzb;
    final /* synthetic */ zzjc zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zziq(zzjc zzjcVar, zzbg zzbgVar, zzr zzrVar) {
        this.zza = zzbgVar;
        this.zzb = zzrVar;
        Objects.requireNonNull(zzjcVar);
        this.zzc = zzjcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbg zzbgVar = this.zza;
        zzr zzrVar = this.zzb;
        zzjc zzjcVar = this.zzc;
        zzjcVar.zzb(zzjcVar.zzc(zzbgVar, zzrVar), zzrVar);
    }
}
