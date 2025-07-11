package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzmg implements Runnable {
    final /* synthetic */ zzr zza;
    final /* synthetic */ zznk zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmg(zznk zznkVar, zzr zzrVar) {
        this.zza = zzrVar;
        Objects.requireNonNull(zznkVar);
        this.zzb = zznkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznk zznkVar = this.zzb;
        zzga zzZ = zznkVar.zzZ();
        if (zzZ == null) {
            zznkVar.zzu.zzaV().zzb().zza("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            zzr zzrVar = this.zza;
            Preconditions.checkNotNull(zzrVar);
            zzZ.zzt(zzrVar);
        } catch (RemoteException e) {
            this.zzb.zzu.zzaV().zzb().zzb("Failed to reset data on the service: remote exception", e);
        }
        this.zzb.zzV();
    }
}
