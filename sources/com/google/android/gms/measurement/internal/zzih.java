package com.google.android.gms.measurement.internal;

import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* loaded from: classes4.dex */
final class zzih implements Runnable {
    final /* synthetic */ zzah zza;
    final /* synthetic */ zzr zzb;
    final /* synthetic */ zzjd zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzih(zzjd zzjdVar, zzah zzahVar, zzr zzrVar) {
        this.zza = zzahVar;
        this.zzb = zzrVar;
        Objects.requireNonNull(zzjdVar);
        this.zzc = zzjdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjd zzjdVar = this.zzc;
        zzjdVar.zzL().zzaa();
        zzah zzahVar = this.zza;
        Object zza = zzahVar.zzc.zza();
        zzr zzrVar = this.zzb;
        if (zza == null) {
            zzjdVar.zzL().zzan(zzahVar, zzrVar);
        } else {
            zzjdVar.zzL().zzal(zzahVar, zzrVar);
        }
    }
}
