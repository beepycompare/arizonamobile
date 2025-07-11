package com.google.android.gms.measurement.internal;

import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzgr {
    final /* synthetic */ zzgt zza;
    private final int zzb;
    private final boolean zzc;
    private final boolean zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgr(zzgt zzgtVar, int i, boolean z, boolean z2) {
        Objects.requireNonNull(zzgtVar);
        this.zza = zzgtVar;
        this.zzb = i;
        this.zzc = z;
        this.zzd = z2;
    }

    public final void zza(String str) {
        this.zza.zzm(this.zzb, this.zzc, this.zzd, str, null, null, null);
    }

    public final void zzb(String str, Object obj) {
        this.zza.zzm(this.zzb, this.zzc, this.zzd, str, obj, null, null);
    }

    public final void zzc(String str, Object obj, Object obj2) {
        this.zza.zzm(this.zzb, this.zzc, this.zzd, str, obj, obj2, null);
    }

    public final void zzd(String str, Object obj, Object obj2, Object obj3) {
        this.zza.zzm(this.zzb, this.zzc, this.zzd, str, obj, obj2, obj3);
    }
}
