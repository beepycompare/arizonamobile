package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzpb {
    com.google.android.gms.internal.measurement.zzid zza;
    List zzb;
    List zzc;
    long zzd;
    final /* synthetic */ zzpf zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzpb(zzpf zzpfVar, byte[] bArr) {
        Objects.requireNonNull(zzpfVar);
        this.zze = zzpfVar;
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
            long zzcn = this.zzd + zzhsVar.zzcn();
            zzpf zzpfVar = this.zze;
            if (zzpfVar.zzd().zzp(null, zzfx.zzbe)) {
                if (!this.zzc.isEmpty()) {
                    zzpfVar.zzd();
                    if (zzcn >= zzal.zzG()) {
                        return false;
                    }
                }
            } else {
                zzpfVar.zzd();
                if (zzcn >= zzal.zzG()) {
                    return false;
                }
            }
            this.zzd = zzcn;
            this.zzc.add(zzhsVar);
            this.zzb.add(Long.valueOf(j));
            int size = this.zzc.size();
            zzpfVar.zzd();
            return size < Math.max(1, ((Integer) zzfx.zzj.zzb(null)).intValue());
        }
        return false;
    }
}
