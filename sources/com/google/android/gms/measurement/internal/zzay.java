package com.google.android.gms.measurement.internal;

import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
final class zzay implements Runnable {
    final /* synthetic */ zzjg zza;
    final /* synthetic */ zzaz zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzay(zzaz zzazVar, zzjg zzjgVar) {
        this.zza = zzjgVar;
        Objects.requireNonNull(zzazVar);
        this.zzb = zzazVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjg zzjgVar = this.zza;
        zzjgVar.zzaV();
        if (zzae.zza()) {
            zzjgVar.zzaX().zzj(this);
            return;
        }
        zzaz zzazVar = this.zzb;
        boolean zzc = zzazVar.zzc();
        zzazVar.zze(0L);
        if (zzc) {
            zzazVar.zza();
        }
    }
}
