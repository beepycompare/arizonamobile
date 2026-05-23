package com.google.android.gms.internal.measurement;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.Collection;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzqs {
    private final boolean zza = true;
    private final String zzb;
    private final zzacr zzc;
    private final ImmutableMap zzd;
    private final zzqr zze;

    private zzqs(zznd zzndVar, zzqr zzqrVar) {
        zzndVar.zzi();
        this.zzb = zzndVar.zzd();
        this.zzc = zzndVar.zzg();
        zzndVar.zze();
        zzndVar.zzf();
        Map zzh = zzndVar.zzh();
        if (zzh != null) {
            ImmutableSet.copyOf((Collection) zzh.keySet());
        } else {
            ImmutableSet.of();
        }
        zzmw zzc = zzndVar.zzc();
        ImmutableMap.Builder builderWithExpectedSize = ImmutableMap.builderWithExpectedSize(zzc.zzf() + 3);
        zzc.zzc(builderWithExpectedSize);
        builderWithExpectedSize.put("__phenotype_server_token", zzndVar.zze()).put("__phenotype_snapshot_token", zzndVar.zzd()).put("__phenotype_configuration_version", Long.valueOf(zzndVar.zzf()));
        this.zzd = builderWithExpectedSize.buildKeepingLast();
        this.zze = zzqrVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzqs zza(zzqv zzqvVar, zzqr zzqrVar) {
        return new zzqs(zzqvVar, zzqrVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzqs zzb(zzqv zzqvVar, zzqs zzqsVar) {
        return new zzqs(zzqvVar, zzqsVar.zze);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzqs zzc(zznd zzndVar, zzqr zzqrVar) {
        return new zzqs(zzndVar, zzqrVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzd() {
        return this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzacr zze() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ImmutableMap zzf() {
        return this.zzd;
    }

    public final boolean zzg() {
        return this.zze.zzc() == 3;
    }

    public final boolean zzh() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzmd zzi() {
        return this.zze.zza();
    }

    public final boolean zzj() {
        return this.zze.zzb() == 17;
    }

    public final boolean zzk() {
        int zzb = this.zze.zzb() - 2;
        return zzb == 15 || zzb == 16;
    }

    private zzqs(zzqv zzqvVar, zzqr zzqrVar) {
        zzqv.zzi().equals(zzqvVar);
        this.zzb = zzqvVar.zza();
        this.zzc = zzqvVar.zzb();
        zzqvVar.zzc();
        zzqvVar.zzd();
        ImmutableSet.of();
        ImmutableMap.Builder builderWithExpectedSize = ImmutableMap.builderWithExpectedSize(zzqvVar.zzf() + 3);
        for (zzqx zzqxVar : zzqvVar.zze()) {
            int zzp = zzqxVar.zzp();
            int i = zzp - 1;
            if (zzp == 0) {
                throw null;
            }
            if (i == 0) {
                builderWithExpectedSize.put(zzqxVar.zza(), Long.valueOf(zzqxVar.zzb()));
            } else if (i == 1) {
                builderWithExpectedSize.put(zzqxVar.zza(), Boolean.valueOf(zzqxVar.zzc()));
            } else if (i == 2) {
                builderWithExpectedSize.put(zzqxVar.zza(), Double.valueOf(zzqxVar.zzd()));
            } else if (i == 3) {
                builderWithExpectedSize.put(zzqxVar.zza(), zzqxVar.zze());
            } else if (i == 4) {
                builderWithExpectedSize.put(zzqxVar.zza(), zzqxVar.zzf().zzm());
            }
        }
        builderWithExpectedSize.put("__phenotype_server_token", zzqvVar.zzc());
        builderWithExpectedSize.put("__phenotype_snapshot_token", zzqvVar.zza());
        builderWithExpectedSize.put("__phenotype_configuration_version", Long.valueOf(zzqvVar.zzd()));
        this.zzd = builderWithExpectedSize.buildKeepingLast();
        this.zze = zzqrVar;
    }
}
