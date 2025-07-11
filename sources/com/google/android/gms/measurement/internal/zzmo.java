package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzmo implements Runnable {
    final /* synthetic */ zzbg zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcu zzc;
    final /* synthetic */ zznk zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmo(zznk zznkVar, zzbg zzbgVar, String str, com.google.android.gms.internal.measurement.zzcu zzcuVar) {
        this.zza = zzbgVar;
        this.zzb = str;
        this.zzc = zzcuVar;
        Objects.requireNonNull(zznkVar);
        this.zzd = zznkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.internal.measurement.zzcu zzcuVar;
        zzpo zzk;
        zznk zznkVar;
        zzga zzZ;
        byte[] bArr = null;
        try {
            try {
                zznkVar = this.zzd;
                zzZ = zznkVar.zzZ();
            } catch (RemoteException e) {
                this.zzd.zzu.zzaV().zzb().zzb("Failed to send event to the service to bundle", e);
            }
            if (zzZ == null) {
                zzib zzibVar = zznkVar.zzu;
                zzibVar.zzaV().zzb().zza("Discarding data. Failed to send event to service to bundle");
                zzk = zzibVar.zzk();
                zzcuVar = this.zzc;
                zzk.zzao(zzcuVar, bArr);
            }
            bArr = zzZ.zzk(this.zza, this.zzb);
            zznkVar.zzV();
            zznk zznkVar2 = this.zzd;
            zzcuVar = this.zzc;
            zzk = zznkVar2.zzu.zzk();
            zzk.zzao(zzcuVar, bArr);
        } catch (Throwable th) {
            zznk zznkVar3 = this.zzd;
            zznkVar3.zzu.zzk().zzao(this.zzc, null);
            throw th;
        }
    }
}
