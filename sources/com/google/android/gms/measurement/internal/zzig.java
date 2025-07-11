package com.google.android.gms.measurement.internal;

import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
final class zzig implements Runnable {
    final /* synthetic */ zzah zza;
    final /* synthetic */ zzr zzb;
    final /* synthetic */ zzjc zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzig(zzjc zzjcVar, zzah zzahVar, zzr zzrVar) {
        this.zza = zzahVar;
        this.zzb = zzrVar;
        Objects.requireNonNull(zzjcVar);
        this.zzc = zzjcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjc zzjcVar = this.zzc;
        zzjcVar.zzL().zzY();
        zzah zzahVar = this.zza;
        if (zzahVar.zzc.zza() == null) {
            zzjcVar.zzL().zzal(zzahVar, this.zzb);
            return;
        }
        zzjcVar.zzL().zzaj(zzahVar, this.zzb);
    }
}
