package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.util.SparseArray;
import com.google.common.util.concurrent.FutureCallback;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzjw implements FutureCallback {
    final /* synthetic */ zzoh zza;
    final /* synthetic */ zzlj zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjw(zzlj zzljVar, zzoh zzohVar) {
        this.zza = zzohVar;
        Objects.requireNonNull(zzljVar);
        this.zzb = zzljVar;
    }

    private final void zza() {
        zzic zzicVar = this.zzb.zzu;
        SparseArray zzf = zzicVar.zzd().zzf();
        zzoh zzohVar = this.zza;
        zzf.put(zzohVar.zzc, Long.valueOf(zzohVar.zzb));
        zzhh zzd = zzicVar.zzd();
        int[] iArr = new int[zzf.size()];
        long[] jArr = new long[zzf.size()];
        for (int i = 0; i < zzf.size(); i++) {
            iArr[i] = zzf.keyAt(i);
            jArr[i] = ((Long) zzf.valueAt(i)).longValue();
        }
        Bundle bundle = new Bundle();
        bundle.putIntArray("uriSources", iArr);
        bundle.putLongArray("uriTimestamps", jArr);
        zzd.zzi.zzb(bundle);
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onFailure(Throwable th) {
        zzlj zzljVar = this.zzb;
        zzljVar.zzg();
        zzljVar.zzam(false);
        zzic zzicVar = zzljVar.zzu;
        int zzaq = (zzicVar.zzc().zzp(null, zzfy.zzaT) ? zzljVar.zzaq(th) : 2) - 1;
        if (zzaq == 0) {
            zzicVar.zzaV().zze().zzc("registerTriggerAsync failed with retriable error. Will try later. App ID, throwable", zzgu.zzl(zzljVar.zzu.zzv().zzj()), zzgu.zzl(th.toString()));
            zzljVar.zzao(1);
            zzljVar.zzy().add(this.zza);
        } else if (zzaq != 1) {
            zzicVar.zzaV().zzb().zzc("registerTriggerAsync failed. Dropping URI. App ID, Throwable", zzgu.zzl(zzljVar.zzu.zzv().zzj()), th);
            zza();
            zzljVar.zzao(1);
            zzljVar.zzz();
        } else {
            zzljVar.zzy().add(this.zza);
            if (zzljVar.zzan() > ((Integer) zzfy.zzaw.zzb(null)).intValue()) {
                zzljVar.zzao(1);
                zzicVar.zzaV().zze().zzc("registerTriggerAsync failed. May try later. App ID, throwable", zzgu.zzl(zzljVar.zzu.zzv().zzj()), zzgu.zzl(th.toString()));
                return;
            }
            zzicVar.zzaV().zze().zzd("registerTriggerAsync failed. App ID, delay in seconds, throwable", zzgu.zzl(zzljVar.zzu.zzv().zzj()), zzgu.zzl(String.valueOf(zzljVar.zzan())), zzgu.zzl(th.toString()));
            zzljVar.zzai(zzljVar.zzan());
            int zzan = zzljVar.zzan();
            zzljVar.zzao(zzan + zzan);
        }
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onSuccess(Object obj) {
        zzlj zzljVar = this.zzb;
        zzljVar.zzg();
        zza();
        zzljVar.zzam(false);
        zzljVar.zzao(1);
        zzljVar.zzu.zzaV().zzj().zzb("Successfully registered trigger URI", this.zza.zza);
        zzljVar.zzz();
    }
}
