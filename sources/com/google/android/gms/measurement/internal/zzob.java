package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzob {
    final /* synthetic */ zzoc zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzob(zzoc zzocVar) {
        Objects.requireNonNull(zzocVar);
        this.zza = zzocVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza() {
        zzoc zzocVar = this.zza;
        zzocVar.zzg();
        zzic zzicVar = zzocVar.zzu;
        if (zzicVar.zzd().zzp(zzicVar.zzaZ().currentTimeMillis())) {
            zzicVar.zzd().zzg.zzb(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                zzicVar.zzaV().zzk().zza("Detected application was in foreground");
                zzc(zzicVar.zzaZ().currentTimeMillis(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(long j, boolean z) {
        zzoc zzocVar = this.zza;
        zzocVar.zzg();
        zzocVar.zzj();
        zzic zzicVar = zzocVar.zzu;
        if (zzicVar.zzd().zzp(j)) {
            zzicVar.zzd().zzg.zzb(true);
            zzocVar.zzu.zzv().zzi();
        }
        zzicVar.zzd().zzk.zzb(j);
        if (zzicVar.zzd().zzg.zza()) {
            zzc(j, z);
        }
    }

    final void zzc(long j, boolean z) {
        zzoc zzocVar = this.zza;
        zzocVar.zzg();
        if (zzocVar.zzu.zzB()) {
            zzic zzicVar = zzocVar.zzu;
            zzicVar.zzd().zzk.zzb(j);
            zzicVar.zzaV().zzk().zzb("Session started, time", Long.valueOf(zzicVar.zzaZ().elapsedRealtime()));
            zzic zzicVar2 = zzocVar.zzu;
            Long valueOf = Long.valueOf(j / 1000);
            zzicVar2.zzj().zzN("auto", "_sid", valueOf, j);
            zzicVar.zzd().zzl.zzb(valueOf.longValue());
            zzicVar.zzd().zzg.zzb(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", valueOf.longValue());
            zzicVar2.zzj().zzG("auto", "_s", j, bundle);
            String zza = zzicVar.zzd().zzq.zza();
            if (TextUtils.isEmpty(zza)) {
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("_ffr", zza);
            zzicVar2.zzj().zzG("auto", "_ssr", j, bundle2);
        }
    }
}
