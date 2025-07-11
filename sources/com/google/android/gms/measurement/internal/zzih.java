package com.google.android.gms.measurement.internal;

import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
final class zzih implements Runnable {
    final /* synthetic */ zzah zza;
    final /* synthetic */ zzjc zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzih(zzjc zzjcVar, zzah zzahVar) {
        this.zza = zzahVar;
        Objects.requireNonNull(zzjcVar);
        this.zzb = zzjcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjc zzjcVar = this.zzb;
        zzjcVar.zzL().zzY();
        zzah zzahVar = this.zza;
        if (zzahVar.zzc.zza() == null) {
            zzjcVar.zzL().zzak(zzahVar);
        } else {
            zzjcVar.zzL().zzai(zzahVar);
        }
    }
}
