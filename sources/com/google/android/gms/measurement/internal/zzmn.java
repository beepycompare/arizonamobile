package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzmn implements Runnable {
    final /* synthetic */ zzlu zza;
    final /* synthetic */ zznl zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmn(zznl zznlVar, zzlu zzluVar) {
        this.zza = zzluVar;
        Objects.requireNonNull(zznlVar);
        this.zzb = zznlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznl zznlVar = this.zzb;
        zzgb zzZ = zznlVar.zzZ();
        if (zzZ == null) {
            zznlVar.zzu.zzaW().zzb().zza("Failed to send current screen to service");
            return;
        }
        try {
            zzlu zzluVar = this.zza;
            if (zzluVar == null) {
                zzZ.zzl(0L, null, null, zznlVar.zzu.zzaZ().getPackageName());
            } else {
                zzZ.zzl(zzluVar.zzc, zzluVar.zza, zzluVar.zzb, zznlVar.zzu.zzaZ().getPackageName());
            }
            zznlVar.zzV();
        } catch (RemoteException e) {
            this.zzb.zzu.zzaW().zzb().zzb("Failed to send current screen to the service", e);
        }
    }
}
