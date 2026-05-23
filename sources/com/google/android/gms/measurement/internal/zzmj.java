package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzmj implements Runnable {
    final /* synthetic */ zzr zza;
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcs zzb;
    final /* synthetic */ zznl zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmj(zznl zznlVar, zzr zzrVar, com.google.android.gms.internal.measurement.zzcs zzcsVar) {
        this.zza = zzrVar;
        this.zzb = zzcsVar;
        Objects.requireNonNull(zznlVar);
        this.zzc = zznlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.internal.measurement.zzcs zzcsVar;
        zzpp zzk;
        zznl zznlVar;
        zzic zzicVar;
        String str = null;
        try {
            try {
                zznlVar = this.zzc;
                zzicVar = zznlVar.zzu;
            } catch (RemoteException e) {
                this.zzc.zzu.zzaW().zzb().zzb("Failed to get app instance id", e);
            }
            if (zzicVar.zzd().zzl().zzo(zzjk.ANALYTICS_STORAGE)) {
                zzgb zzZ = zznlVar.zzZ();
                if (zzZ != null) {
                    zzr zzrVar = this.zza;
                    Preconditions.checkNotNull(zzrVar);
                    str = zzZ.zzm(zzrVar);
                    if (str != null) {
                        zznlVar.zzu.zzj().zzQ(str);
                        zzicVar.zzd().zze.zzb(str);
                    }
                    zznlVar.zzV();
                    zznl zznlVar2 = this.zzc;
                    zzcsVar = this.zzb;
                    zzk = zznlVar2.zzu.zzk();
                    zzk.zzao(zzcsVar, str);
                }
                zzicVar.zzaW().zzb().zza("Failed to get app instance id");
            } else {
                zzicVar.zzaW().zzh().zza("Analytics storage consent denied; will not get app instance id");
                zznlVar.zzu.zzj().zzQ(null);
                zzicVar.zzd().zze.zzb(null);
            }
            zzk = zzicVar.zzk();
            zzcsVar = this.zzb;
            zzk.zzao(zzcsVar, str);
        } catch (Throwable th) {
            zznl zznlVar3 = this.zzc;
            zznlVar3.zzu.zzk().zzao(this.zzb, null);
            throw th;
        }
    }
}
