package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
final class zzhm implements com.google.android.gms.internal.measurement.zzr {
    final /* synthetic */ zzhs zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhm(zzhs zzhsVar) {
        Objects.requireNonNull(zzhsVar);
        this.zza = zzhsVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzr
    public final void zza(int i, String str, List list, boolean z, boolean z2) {
        zzgr zzj;
        int i2 = i - 1;
        if (i2 == 0) {
            zzj = this.zza.zzu.zzaV().zzj();
        } else if (i2 != 1) {
            if (i2 == 3) {
                zzj = this.zza.zzu.zzaV().zzk();
            } else if (i2 != 4) {
                zzj = this.zza.zzu.zzaV().zzi();
            } else if (z) {
                zzj = this.zza.zzu.zzaV().zzf();
            } else if (!z2) {
                zzj = this.zza.zzu.zzaV().zzh();
            } else {
                zzj = this.zza.zzu.zzaV().zze();
            }
        } else if (z) {
            zzj = this.zza.zzu.zzaV().zzc();
        } else if (!z2) {
            zzj = this.zza.zzu.zzaV().zzd();
        } else {
            zzj = this.zza.zzu.zzaV().zzb();
        }
        int size = list.size();
        if (size == 1) {
            zzj.zzb(str, list.get(0));
        } else if (size == 2) {
            zzj.zzc(str, list.get(0), list.get(1));
        } else if (size == 3) {
            zzj.zzd(str, list.get(0), list.get(1), list.get(2));
        } else {
            zzj.zza(str);
        }
    }
}
