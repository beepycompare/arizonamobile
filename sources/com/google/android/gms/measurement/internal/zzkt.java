package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzkt implements Runnable {
    final /* synthetic */ zzaz zza;
    final /* synthetic */ zzlj zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkt(zzlj zzljVar, zzaz zzazVar) {
        this.zza = zzazVar;
        Objects.requireNonNull(zzljVar);
        this.zzb = zzljVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlj zzljVar = this.zzb;
        zzic zzicVar = zzljVar.zzu;
        zzhh zzd = zzicVar.zzd();
        zzic zzicVar2 = zzd.zzu;
        zzd.zzg();
        zzaz zzj = zzd.zzj();
        zzaz zzazVar = this.zza;
        if (zzjl.zzu(zzazVar.zzb(), zzj.zzb())) {
            SharedPreferences.Editor edit = zzd.zzd().edit();
            edit.putString("dma_consent_settings", zzazVar.zze());
            edit.apply();
            zzicVar.zzaV().zzk().zzb("Setting DMA consent(FE)", zzazVar);
            zzic zzicVar3 = zzljVar.zzu;
            if (zzicVar3.zzt().zzP()) {
                zzicVar3.zzt().zzl();
                return;
            } else {
                zzicVar3.zzt().zzj(false);
                return;
            }
        }
        zzicVar.zzaV().zzi().zzb("Lower precedence consent source ignored, proposed source", Integer.valueOf(zzazVar.zzb()));
    }
}
