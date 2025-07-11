package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzmn implements Runnable {
    final /* synthetic */ zzr zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzbe zzc;
    final /* synthetic */ Bundle zzd;
    final /* synthetic */ zznk zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmn(zznk zznkVar, boolean z, zzr zzrVar, boolean z2, zzbe zzbeVar, Bundle bundle) {
        this.zza = zzrVar;
        this.zzb = z2;
        this.zzc = zzbeVar;
        this.zzd = bundle;
        Objects.requireNonNull(zznkVar);
        this.zze = zznkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznk zznkVar = this.zze;
        zzga zzZ = zznkVar.zzZ();
        if (zzZ == null) {
            zznkVar.zzu.zzaV().zzb().zza("Failed to send default event parameters to service");
            return;
        }
        if (!zznkVar.zzu.zzc().zzp(null, zzfx.zzbc)) {
            try {
                zzr zzrVar = this.zza;
                Preconditions.checkNotNull(zzrVar);
                zzZ.zzu(this.zzd, zzrVar);
                zznkVar.zzV();
                return;
            } catch (RemoteException e) {
                this.zze.zzu.zzaV().zzb().zzb("Failed to send default event parameters to service", e);
                return;
            }
        }
        zzr zzrVar2 = this.zza;
        Preconditions.checkNotNull(zzrVar2);
        this.zze.zzm(zzZ, this.zzb ? null : this.zzc, zzrVar2);
    }
}
