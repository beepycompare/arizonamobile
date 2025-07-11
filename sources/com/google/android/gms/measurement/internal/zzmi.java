package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzmi implements Runnable {
    final /* synthetic */ zzr zza;
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcu zzb;
    final /* synthetic */ zznk zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmi(zznk zznkVar, zzr zzrVar, com.google.android.gms.internal.measurement.zzcu zzcuVar) {
        this.zza = zzrVar;
        this.zzb = zzcuVar;
        Objects.requireNonNull(zznkVar);
        this.zzc = zznkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.internal.measurement.zzcu zzcuVar;
        zzpo zzk;
        zznk zznkVar;
        zzib zzibVar;
        String str = null;
        try {
            try {
                zznkVar = this.zzc;
                zzibVar = zznkVar.zzu;
            } catch (RemoteException e) {
                this.zzc.zzu.zzaV().zzb().zzb("Failed to get app instance id", e);
            }
            if (zzibVar.zzd().zzl().zzo(zzjj.ANALYTICS_STORAGE)) {
                zzga zzZ = zznkVar.zzZ();
                if (zzZ != null) {
                    zzr zzrVar = this.zza;
                    Preconditions.checkNotNull(zzrVar);
                    str = zzZ.zzm(zzrVar);
                    if (str != null) {
                        zznkVar.zzu.zzj().zzR(str);
                        zzibVar.zzd().zze.zzb(str);
                    }
                    zznkVar.zzV();
                    zznk zznkVar2 = this.zzc;
                    zzcuVar = this.zzb;
                    zzk = zznkVar2.zzu.zzk();
                    zzk.zzal(zzcuVar, str);
                }
                zzibVar.zzaV().zzb().zza("Failed to get app instance id");
            } else {
                zzibVar.zzaV().zzh().zza("Analytics storage consent denied; will not get app instance id");
                zznkVar.zzu.zzj().zzR(null);
                zzibVar.zzd().zze.zzb(null);
            }
            zzk = zzibVar.zzk();
            zzcuVar = this.zzb;
            zzk.zzal(zzcuVar, str);
        } catch (Throwable th) {
            zznk zznkVar3 = this.zzc;
            zznkVar3.zzu.zzk().zzal(this.zzb, null);
            throw th;
        }
    }
}
