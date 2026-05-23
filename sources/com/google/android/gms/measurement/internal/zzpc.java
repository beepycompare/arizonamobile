package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzpc {
    com.google.android.gms.internal.measurement.zzid zza;
    List zzb;
    List zzc;
    long zzd;
    final /* synthetic */ zzpg zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzpc(zzpg zzpgVar, byte[] bArr) {
        Objects.requireNonNull(zzpgVar);
        this.zze = zzpgVar;
    }

    private static final long zzb(com.google.android.gms.internal.measurement.zzhs zzhsVar) {
        return ((zzhsVar.zzf() / 1000) / 60) / 60;
    }

    public final boolean zza(long j, com.google.android.gms.internal.measurement.zzhs zzhsVar) {
        Preconditions.checkNotNull(zzhsVar);
        if (this.zzc == null) {
            this.zzc = new ArrayList();
        }
        if (this.zzb == null) {
            this.zzb = new ArrayList();
        }
        if (this.zzc.isEmpty() || zzb((com.google.android.gms.internal.measurement.zzhs) this.zzc.get(0)) == zzb(zzhsVar)) {
            long zzcq = this.zzd + zzhsVar.zzcq();
            zzpg zzpgVar = this.zze;
            if (zzpgVar.zzd().zzp(null, zzfy.zzaY)) {
                if (!this.zzc.isEmpty()) {
                    zzpgVar.zzd();
                    if (zzcq >= zzal.zzG()) {
                        return false;
                    }
                }
            } else {
                zzpgVar.zzd();
                if (zzcq >= zzal.zzG()) {
                    return false;
                }
            }
            this.zzd = zzcq;
            this.zzc.add(zzhsVar);
            this.zzb.add(Long.valueOf(j));
            com.google.android.gms.internal.measurement.zzid zzidVar = this.zza;
            return this.zzc.size() < Math.max(1, zzpgVar.zzd().zzm(zzidVar != null ? zzidVar.zzA() : null, zzfy.zzj));
        }
        return false;
    }
}
