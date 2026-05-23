package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzmp implements Runnable {
    final /* synthetic */ zzbh zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcs zzc;
    final /* synthetic */ zznl zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmp(zznl zznlVar, zzbh zzbhVar, String str, com.google.android.gms.internal.measurement.zzcs zzcsVar) {
        this.zza = zzbhVar;
        this.zzb = str;
        this.zzc = zzcsVar;
        Objects.requireNonNull(zznlVar);
        this.zzd = zznlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.internal.measurement.zzcs zzcsVar;
        zzpp zzk;
        zznl zznlVar;
        zzgb zzZ;
        byte[] bArr = null;
        try {
            try {
                zznlVar = this.zzd;
                zzZ = zznlVar.zzZ();
            } catch (RemoteException e) {
                this.zzd.zzu.zzaW().zzb().zzb("Failed to send event to the service to bundle", e);
            }
            if (zzZ == null) {
                zzic zzicVar = zznlVar.zzu;
                zzicVar.zzaW().zzb().zza("Discarding data. Failed to send event to service to bundle");
                zzk = zzicVar.zzk();
                zzcsVar = this.zzc;
                zzk.zzar(zzcsVar, bArr);
            }
            bArr = zzZ.zzk(this.zza, this.zzb);
            zznlVar.zzV();
            zznl zznlVar2 = this.zzd;
            zzcsVar = this.zzc;
            zzk = zznlVar2.zzu.zzk();
            zzk.zzar(zzcsVar, bArr);
        } catch (Throwable th) {
            zznl zznlVar3 = this.zzd;
            zznlVar3.zzu.zzk().zzar(this.zzc, null);
            throw th;
        }
    }
}
