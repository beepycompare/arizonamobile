package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzks implements Runnable {
    final /* synthetic */ zzaz zza;
    final /* synthetic */ zzli zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzks(zzli zzliVar, zzaz zzazVar) {
        this.zza = zzazVar;
        Objects.requireNonNull(zzliVar);
        this.zzb = zzliVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzli zzliVar = this.zzb;
        zzib zzibVar = zzliVar.zzu;
        zzhg zzd = zzibVar.zzd();
        zzib zzibVar2 = zzd.zzu;
        zzd.zzg();
        zzaz zzj = zzd.zzj();
        zzaz zzazVar = this.zza;
        if (zzjk.zzu(zzazVar.zzb(), zzj.zzb())) {
            SharedPreferences.Editor edit = zzd.zzd().edit();
            edit.putString("dma_consent_settings", zzazVar.zze());
            edit.apply();
            zzibVar.zzaV().zzk().zzb("Setting DMA consent(FE)", zzazVar);
            zzib zzibVar3 = zzliVar.zzu;
            if (zzibVar3.zzt().zzP()) {
                zzibVar3.zzt().zzl();
                return;
            } else {
                zzibVar3.zzt().zzj(false);
                return;
            }
        }
        zzibVar.zzaV().zzi().zzb("Lower precedence consent source ignored, proposed source", Integer.valueOf(zzazVar.zzb()));
    }
}
