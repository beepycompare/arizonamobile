package com.google.android.gms.measurement.internal;

import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
final class zznt implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzob zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznt(zzob zzobVar, long j) {
        this.zza = j;
        Objects.requireNonNull(zzobVar);
        this.zzb = zzobVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzk(this.zza);
    }
}
