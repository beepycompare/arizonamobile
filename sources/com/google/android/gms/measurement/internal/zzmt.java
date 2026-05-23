package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzmt implements Runnable {
    final /* synthetic */ zzr zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzbh zzc;
    final /* synthetic */ zznl zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmt(zznl zznlVar, boolean z, zzr zzrVar, boolean z2, zzbh zzbhVar, String str) {
        this.zza = zzrVar;
        this.zzb = z2;
        this.zzc = zzbhVar;
        Objects.requireNonNull(zznlVar);
        this.zzd = zznlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznl zznlVar = this.zzd;
        zzgb zzZ = zznlVar.zzZ();
        if (zzZ == null) {
            zznlVar.zzu.zzaW().zzb().zza("Discarding data. Failed to send event to service");
            return;
        }
        zzr zzrVar = this.zza;
        Preconditions.checkNotNull(zzrVar);
        zznlVar.zzm(zzZ, this.zzb ? null : this.zzc, zzrVar);
        zznlVar.zzV();
    }
}
