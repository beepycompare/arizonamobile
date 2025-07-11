package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.util.SparseArray;
import com.google.common.util.concurrent.FutureCallback;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzjv implements FutureCallback {
    final /* synthetic */ zzog zza;
    final /* synthetic */ zzli zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjv(zzli zzliVar, zzog zzogVar) {
        this.zza = zzogVar;
        Objects.requireNonNull(zzliVar);
        this.zzb = zzliVar;
    }

    private final void zza() {
        zzib zzibVar = this.zzb.zzu;
        SparseArray zzf = zzibVar.zzd().zzf();
        zzog zzogVar = this.zza;
        zzf.put(zzogVar.zzc, Long.valueOf(zzogVar.zzb));
        zzhg zzd = zzibVar.zzd();
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
        zzli zzliVar = this.zzb;
        zzliVar.zzg();
        zzliVar.zzal(false);
        zzib zzibVar = zzliVar.zzu;
        int zzap = (zzibVar.zzc().zzp(null, zzfx.zzaT) ? zzliVar.zzap(th) : 2) - 1;
        if (zzap == 0) {
            zzibVar.zzaV().zze().zzc("registerTriggerAsync failed with retriable error. Will try later. App ID, throwable", zzgt.zzl(zzliVar.zzu.zzv().zzj()), zzgt.zzl(th.toString()));
            zzliVar.zzan(1);
            zzliVar.zzy().add(this.zza);
        } else if (zzap != 1) {
            zzibVar.zzaV().zzb().zzc("registerTriggerAsync failed. Dropping URI. App ID, Throwable", zzgt.zzl(zzliVar.zzu.zzv().zzj()), th);
            zza();
            zzliVar.zzan(1);
            zzliVar.zzz();
        } else {
            zzliVar.zzy().add(this.zza);
            if (zzliVar.zzam() > ((Integer) zzfx.zzaw.zzb(null)).intValue()) {
                zzliVar.zzan(1);
                zzibVar.zzaV().zze().zzc("registerTriggerAsync failed. May try later. App ID, throwable", zzgt.zzl(zzliVar.zzu.zzv().zzj()), zzgt.zzl(th.toString()));
                return;
            }
            zzibVar.zzaV().zze().zzd("registerTriggerAsync failed. App ID, delay in seconds, throwable", zzgt.zzl(zzliVar.zzu.zzv().zzj()), zzgt.zzl(String.valueOf(zzliVar.zzam())), zzgt.zzl(th.toString()));
            zzliVar.zzah(zzliVar.zzam());
            int zzam = zzliVar.zzam();
            zzliVar.zzan(zzam + zzam);
        }
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onSuccess(Object obj) {
        zzli zzliVar = this.zzb;
        zzliVar.zzg();
        zza();
        zzliVar.zzal(false);
        zzliVar.zzan(1);
        zzliVar.zzu.zzaV().zzj().zzb("Successfully registered trigger URI", this.zza.zza);
        zzliVar.zzz();
    }
}
