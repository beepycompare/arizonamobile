package com.google.android.gms.measurement.internal;

import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* loaded from: classes4.dex */
final class zzha implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzhb zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzha(zzhb zzhbVar, boolean z) {
        this.zza = z;
        Objects.requireNonNull(zzhbVar);
        this.zzb = zzhbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzc().zzat(this.zza);
    }
}
