package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzmo implements Runnable {
    final /* synthetic */ zzr zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzbf zzc;
    final /* synthetic */ Bundle zzd;
    final /* synthetic */ zznl zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmo(zznl zznlVar, boolean z, zzr zzrVar, boolean z2, zzbf zzbfVar, Bundle bundle) {
        this.zza = zzrVar;
        this.zzb = z2;
        this.zzc = zzbfVar;
        this.zzd = bundle;
        Objects.requireNonNull(zznlVar);
        this.zze = zznlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznl zznlVar = this.zze;
        zzgb zzZ = zznlVar.zzZ();
        if (zzZ == null) {
            zznlVar.zzu.zzaW().zzb().zza("Failed to send default event parameters to service");
            return;
        }
        boolean zzp = zznlVar.zzu.zzc().zzp(null, zzfy.zzaW);
        zzr zzrVar = this.zza;
        if (zzp) {
            Preconditions.checkNotNull(zzrVar);
            zznlVar.zzm(zzZ, this.zzb ? null : this.zzc, zzrVar);
            return;
        }
        try {
            Preconditions.checkNotNull(zzrVar);
            zzZ.zzu(this.zzd, zzrVar);
            zznlVar.zzV();
        } catch (RemoteException e) {
            this.zze.zzu.zzaW().zzb().zzb("Failed to send default event parameters to service", e);
        }
    }
}
