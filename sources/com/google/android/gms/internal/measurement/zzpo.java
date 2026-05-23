package com.google.android.gms.internal.measurement;

import com.google.common.base.Preconditions;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzpo {
    private final AtomicReferenceArray zza;
    private final zzog zzb;

    public zzpo(zzog zzogVar, int i) {
        this.zzb = zzogVar;
        this.zza = new AtomicReferenceArray(i);
    }

    public final zzom zza(int i, String str, boolean z) {
        AtomicReferenceArray atomicReferenceArray = this.zza;
        zzom zzomVar = (zzom) atomicReferenceArray.get(i);
        if (zzomVar == null) {
            zzom zza = this.zzb.zza(str, z);
            return !zzah$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceArray, i, null, zza) ? (zzom) Preconditions.checkNotNull((zzom) atomicReferenceArray.get(i)) : zza;
        }
        return zzomVar;
    }

    public final zzom zzb(int i, String str, long j) {
        AtomicReferenceArray atomicReferenceArray = this.zza;
        zzom zzomVar = (zzom) atomicReferenceArray.get(i);
        if (zzomVar == null) {
            zzom zzb = this.zzb.zzb(str, j);
            return !zzah$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceArray, i, null, zzb) ? (zzom) Preconditions.checkNotNull((zzom) atomicReferenceArray.get(i)) : zzb;
        }
        return zzomVar;
    }

    public final zzom zzc(int i, String str, double d) {
        AtomicReferenceArray atomicReferenceArray = this.zza;
        zzom zzomVar = (zzom) atomicReferenceArray.get(2);
        if (zzomVar == null) {
            zzom zzc = this.zzb.zzc("measurement.test.double_flag", -3.0d);
            return !zzah$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceArray, 2, null, zzc) ? (zzom) Preconditions.checkNotNull((zzom) atomicReferenceArray.get(2)) : zzc;
        }
        return zzomVar;
    }

    public final zzom zzd(int i, String str, String str2) {
        AtomicReferenceArray atomicReferenceArray = this.zza;
        zzom zzomVar = (zzom) atomicReferenceArray.get(i);
        if (zzomVar == null) {
            zzom zzd = this.zzb.zzd(str, str2);
            return !zzah$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceArray, i, null, zzd) ? (zzom) Preconditions.checkNotNull((zzom) atomicReferenceArray.get(i)) : zzd;
        }
        return zzomVar;
    }
}
