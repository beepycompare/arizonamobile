package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzmk implements Runnable {
    final /* synthetic */ zzr zza;
    final /* synthetic */ zznl zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmk(zznl zznlVar, zzr zzrVar, boolean z) {
        this.zza = zzrVar;
        Objects.requireNonNull(zznlVar);
        this.zzb = zznlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznl zznlVar = this.zzb;
        zzgb zzZ = zznlVar.zzZ();
        if (zzZ == null) {
            zznlVar.zzu.zzaW().zzb().zza("Discarding data. Failed to send app launch");
            return;
        }
        try {
            zzr zzrVar = this.zza;
            Preconditions.checkNotNull(zzrVar);
            zzic zzicVar = zznlVar.zzu;
            zzal zzc = zzicVar.zzc();
            zzfx zzfxVar = zzfy.zzaW;
            if (zzc.zzp(null, zzfxVar)) {
                zznlVar.zzm(zzZ, null, zzrVar);
            }
            zzZ.zzg(zzrVar);
            zznlVar.zzu.zzm().zzo();
            zzicVar.zzc().zzp(null, zzfxVar);
            zznlVar.zzm(zzZ, null, zzrVar);
            zznlVar.zzV();
        } catch (RemoteException e) {
            this.zzb.zzu.zzaW().zzb().zzb("Failed to send app launch to the service", e);
        }
    }
}
