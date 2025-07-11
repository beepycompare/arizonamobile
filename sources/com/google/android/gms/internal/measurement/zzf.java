package com.google.android.gms.internal.measurement;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzf {
    final zzaw zza;
    final zzg zzb;
    final zzg zzc;
    final zzj zzd;

    public zzf() {
        zzaw zzawVar = new zzaw();
        this.zza = zzawVar;
        zzg zzgVar = new zzg(null, zzawVar);
        this.zzc = zzgVar;
        this.zzb = zzgVar.zzc();
        zzj zzjVar = new zzj();
        this.zzd = zzjVar;
        zzgVar.zze("require", new zzw(zzjVar));
        zzjVar.zza("internal.platform", zze.zza);
        zzgVar.zze("runtime.counter", new zzah(Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)));
    }

    public final zzao zza(zzg zzgVar, zzje... zzjeVarArr) {
        zzao zzaoVar = zzao.zzf;
        for (zzje zzjeVar : zzjeVarArr) {
            zzaoVar = zzi.zzb(zzjeVar);
            zzh.zzl(this.zzc);
            if ((zzaoVar instanceof zzap) || (zzaoVar instanceof zzan)) {
                zzaoVar = this.zza.zzb(zzgVar, zzaoVar);
            }
        }
        return zzaoVar;
    }
}
