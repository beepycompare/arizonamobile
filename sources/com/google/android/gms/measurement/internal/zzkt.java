package com.google.android.gms.measurement.internal;

import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzkt implements Runnable {
    final /* synthetic */ zzjk zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ boolean zzc;
    final /* synthetic */ zzli zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkt(zzli zzliVar, zzjk zzjkVar, long j, boolean z) {
        this.zza = zzjkVar;
        this.zzb = j;
        this.zzc = z;
        Objects.requireNonNull(zzliVar);
        this.zzd = zzliVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzli zzliVar = this.zzd;
        zzjk zzjkVar = this.zza;
        zzliVar.zzA(zzjkVar);
        zzliVar.zzaj(zzjkVar, this.zzb, true, this.zzc);
    }
}
