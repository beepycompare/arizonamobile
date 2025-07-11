package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzkg implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzli zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkg(zzli zzliVar, long j) {
        this.zza = j;
        Objects.requireNonNull(zzliVar);
        this.zzb = zzliVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzli zzliVar = this.zzb;
        zzliVar.zzg();
        zzliVar.zzb();
        zzib zzibVar = zzliVar.zzu;
        zzibVar.zzaV().zzj().zza("Resetting analytics data (FE)");
        zzib zzibVar2 = zzliVar.zzu;
        zzob zzh = zzibVar2.zzh();
        zzh.zzg();
        zzoa zzoaVar = zzh.zza;
        zzh.zzb.zzc();
        zzibVar2.zzv().zzi();
        boolean z = !zzliVar.zzu.zzB();
        zzhg zzd = zzibVar.zzd();
        zzd.zzc.zzb(this.zza);
        zzib zzibVar3 = zzd.zzu;
        if (!TextUtils.isEmpty(zzibVar3.zzd().zzq.zza())) {
            zzd.zzq.zzb(null);
        }
        zzd.zzk.zzb(0L);
        zzd.zzl.zzb(0L);
        if (!zzibVar3.zzc().zzt()) {
            zzd.zzn(z);
        }
        zzd.zzr.zzb(null);
        zzd.zzs.zzb(0L);
        zzd.zzt.zzb(null);
        zzibVar2.zzt().zzB();
        zzibVar2.zzh().zza.zza();
        zzliVar.zzc = z;
        zzibVar2.zzt().zzC(new AtomicReference());
    }
}
