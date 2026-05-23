package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.util.SparseArray;
import com.google.common.util.concurrent.FutureCallback;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
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

    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onFailure(Throwable th) {
        zzlj zzljVar = this.zzb;
        zzljVar.zzg();
        zzljVar.zzal(false);
        zzljVar.zzx().add(this.zza);
        if (zzljVar.zzam() > ((Integer) zzfy.zzav.zzb(null)).intValue()) {
            zzljVar.zzan(1);
            zzljVar.zzu.zzaW().zze().zzc("registerTriggerAsync failed. May try later. App ID, throwable", zzgu.zzl(zzljVar.zzu.zzv().zzj()), zzgu.zzl(th.toString()));
            return;
        }
        zzljVar.zzu.zzaW().zze().zzd("registerTriggerAsync failed. App ID, delay in seconds, throwable", zzgu.zzl(zzljVar.zzu.zzv().zzj()), zzgu.zzl(String.valueOf(zzljVar.zzam())), zzgu.zzl(th.toString()));
        zzljVar.zzah(zzljVar.zzam());
        int zzam = zzljVar.zzam();
        zzljVar.zzan(zzam + zzam);
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onSuccess(Object obj) {
        zzlj zzljVar = this.zzb;
        zzljVar.zzg();
        zzic zzicVar = zzljVar.zzu;
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
        zzljVar.zzal(false);
        zzljVar.zzan(1);
        zzicVar.zzaW().zzj().zzb("Successfully registered trigger URI", zzohVar.zza);
        zzljVar.zzy();
    }
}
