package com.google.android.gms.measurement.internal;

import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzhz implements Runnable {
    final /* synthetic */ zzjr zza;
    final /* synthetic */ zzib zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhz(zzib zzibVar, zzjr zzjrVar) {
        this.zza = zzjrVar;
        Objects.requireNonNull(zzibVar);
        this.zzb = zzibVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzib zzibVar = this.zzb;
        zzjr zzjrVar = this.zza;
        zzibVar.zzK(zzjrVar);
        zzibVar.zza(zzjrVar.zzd);
    }
}
