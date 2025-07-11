package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzmf implements Runnable {
    final /* synthetic */ zzr zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzpk zzc;
    final /* synthetic */ zznk zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmf(zznk zznkVar, zzr zzrVar, boolean z, zzpk zzpkVar) {
        this.zza = zzrVar;
        this.zzb = z;
        this.zzc = zzpkVar;
        Objects.requireNonNull(zznkVar);
        this.zzd = zznkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznk zznkVar = this.zzd;
        zzga zzZ = zznkVar.zzZ();
        if (zzZ == null) {
            zznkVar.zzu.zzaV().zzb().zza("Discarding data. Failed to set user property");
            return;
        }
        zzr zzrVar = this.zza;
        Preconditions.checkNotNull(zzrVar);
        zznkVar.zzm(zzZ, this.zzb ? null : this.zzc, zzrVar);
        zznkVar.zzV();
    }
}
