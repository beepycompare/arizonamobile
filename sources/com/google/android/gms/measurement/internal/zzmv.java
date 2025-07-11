package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzmv implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzr zzc;
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcu zzd;
    final /* synthetic */ zznk zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmv(zznk zznkVar, String str, String str2, zzr zzrVar, com.google.android.gms.internal.measurement.zzcu zzcuVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzrVar;
        this.zzd = zzcuVar;
        Objects.requireNonNull(zznkVar);
        this.zze = zznkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.internal.measurement.zzcu zzcuVar;
        zzpo zzk;
        zznk zznkVar;
        zzga zzZ;
        ArrayList arrayList = new ArrayList();
        try {
            try {
                zznkVar = this.zze;
                zzZ = zznkVar.zzZ();
            } catch (RemoteException e) {
                this.zze.zzu.zzaV().zzb().zzd("Failed to get conditional properties; remote exception", this.zza, this.zzb, e);
            }
            if (zzZ == null) {
                zzib zzibVar = zznkVar.zzu;
                zzibVar.zzaV().zzb().zzc("Failed to get conditional properties; not connected to service", this.zza, this.zzb);
                zzk = zzibVar.zzk();
                zzcuVar = this.zzd;
                zzk.zzar(zzcuVar, arrayList);
            }
            zzr zzrVar = this.zzc;
            Preconditions.checkNotNull(zzrVar);
            arrayList = zzpo.zzas(zzZ.zzr(this.zza, this.zzb, zzrVar));
            zznkVar.zzV();
            zznk zznkVar2 = this.zze;
            zzcuVar = this.zzd;
            zzk = zznkVar2.zzu.zzk();
            zzk.zzar(zzcuVar, arrayList);
        } catch (Throwable th) {
            zznk zznkVar3 = this.zze;
            zznkVar3.zzu.zzk().zzar(this.zzd, arrayList);
            throw th;
        }
    }
}
