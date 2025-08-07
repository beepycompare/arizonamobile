package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzmp implements Runnable {
    final /* synthetic */ zzbg zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcu zzc;
    final /* synthetic */ zznl zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmp(zznl zznlVar, zzbg zzbgVar, String str, com.google.android.gms.internal.measurement.zzcu zzcuVar) {
        this.zza = zzbgVar;
        this.zzb = str;
        this.zzc = zzcuVar;
        Objects.requireNonNull(zznlVar);
        this.zzd = zznlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.internal.measurement.zzcu zzcuVar;
        zzpp zzk;
        zznl zznlVar;
        zzgb zzZ;
        byte[] bArr = null;
        try {
            try {
                zznlVar = this.zzd;
                zzZ = zznlVar.zzZ();
            } catch (RemoteException e) {
                this.zzd.zzu.zzaV().zzb().zzb("Failed to send event to the service to bundle", e);
            }
            if (zzZ == null) {
                zzic zzicVar = zznlVar.zzu;
                zzicVar.zzaV().zzb().zza("Discarding data. Failed to send event to service to bundle");
                zzk = zzicVar.zzk();
                zzcuVar = this.zzc;
                zzk.zzao(zzcuVar, bArr);
            }
            bArr = zzZ.zzk(this.zza, this.zzb);
            zznlVar.zzV();
            zznl zznlVar2 = this.zzd;
            zzcuVar = this.zzc;
            zzk = zznlVar2.zzu.zzk();
            zzk.zzao(zzcuVar, bArr);
        } catch (Throwable th) {
            zznl zznlVar3 = this.zzd;
            zznlVar3.zzu.zzk().zzao(this.zzc, null);
            throw th;
        }
    }
}
