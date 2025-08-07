package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.0.0 */
/* loaded from: classes3.dex */
final class zzkm implements Runnable {
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcu zza;
    final /* synthetic */ zzlj zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkm(zzlj zzljVar, com.google.android.gms.internal.measurement.zzcu zzcuVar) {
        this.zza = zzcuVar;
        Objects.requireNonNull(zzljVar);
        this.zzb = zzljVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        Long valueOf;
        zzlj zzljVar = this.zzb;
        zzic zzicVar = zzljVar.zzu.zzh().zzu;
        if (zzicVar.zzd().zzl().zzo(zzjk.ANALYTICS_STORAGE)) {
            if (!zzicVar.zzd().zzp(zzicVar.zzaZ().currentTimeMillis()) && zzicVar.zzd().zzl.zza() != 0) {
                valueOf = Long.valueOf(zzicVar.zzd().zzl.zza());
                if (valueOf == null) {
                    zzljVar.zzu.zzk().zzam(this.zza, valueOf.longValue());
                    return;
                }
                try {
                    this.zza.zzb(null);
                    return;
                } catch (RemoteException e) {
                    this.zzb.zzu.zzaV().zzb().zzb("getSessionId failed with exception", e);
                    return;
                }
            }
        } else {
            zzicVar.zzaV().zzh().zza("Analytics storage consent denied; will not get session id");
        }
        valueOf = null;
        if (valueOf == null) {
        }
    }
}
