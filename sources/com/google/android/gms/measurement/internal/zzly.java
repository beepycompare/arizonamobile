package com.google.android.gms.measurement.internal;

import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzly implements Runnable {
    final /* synthetic */ zzlt zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzma zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzly(zzma zzmaVar, zzlt zzltVar, long j) {
        this.zza = zzltVar;
        this.zzb = j;
        Objects.requireNonNull(zzmaVar);
        this.zzc = zzmaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzma zzmaVar = this.zzc;
        zzmaVar.zzv(this.zza, false, this.zzb);
        zzmaVar.zza = null;
        zzmaVar.zzu.zzt().zzG(null);
    }
}
