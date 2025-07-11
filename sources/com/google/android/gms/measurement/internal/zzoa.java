package com.google.android.gms.measurement.internal;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzoa {
    final /* synthetic */ zzob zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzoa(zzob zzobVar) {
        Objects.requireNonNull(zzobVar);
        this.zza = zzobVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza() {
        zzob zzobVar = this.zza;
        zzobVar.zzg();
        zzib zzibVar = zzobVar.zzu;
        if (zzibVar.zzd().zzp(zzibVar.zzaZ().currentTimeMillis())) {
            zzibVar.zzd().zzg.zzb(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                zzibVar.zzaV().zzk().zza("Detected application was in foreground");
                zzc(zzibVar.zzaZ().currentTimeMillis(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(long j, boolean z) {
        zzob zzobVar = this.zza;
        zzobVar.zzg();
        zzobVar.zzj();
        zzib zzibVar = zzobVar.zzu;
        if (zzibVar.zzd().zzp(j)) {
            zzibVar.zzd().zzg.zzb(true);
            zzobVar.zzu.zzv().zzi();
        }
        zzibVar.zzd().zzk.zzb(j);
        if (zzibVar.zzd().zzg.zza()) {
            zzc(j, z);
        }
    }

    final void zzc(long j, boolean z) {
        zzob zzobVar = this.zza;
        zzobVar.zzg();
        if (zzobVar.zzu.zzB()) {
            zzib zzibVar = zzobVar.zzu;
            zzibVar.zzd().zzk.zzb(j);
            zzibVar.zzaV().zzk().zzb("Session started, time", Long.valueOf(zzibVar.zzaZ().elapsedRealtime()));
            zzib zzibVar2 = zzobVar.zzu;
            Long valueOf = Long.valueOf(j / 1000);
            zzibVar2.zzj().zzN("auto", "_sid", valueOf, j);
            zzibVar.zzd().zzl.zzb(valueOf.longValue());
            zzibVar.zzd().zzg.zzb(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", valueOf.longValue());
            zzibVar2.zzj().zzG("auto", "_s", j, bundle);
            String zza = zzibVar.zzd().zzq.zza();
            if (TextUtils.isEmpty(zza)) {
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("_ffr", zza);
            zzibVar2.zzj().zzG("auto", "_ssr", j, bundle2);
        }
    }
}
