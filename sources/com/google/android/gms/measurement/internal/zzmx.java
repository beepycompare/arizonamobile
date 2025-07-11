package com.google.android.gms.measurement.internal;

import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
final class zzmx implements Runnable {
    final /* synthetic */ zzga zza;
    final /* synthetic */ zzne zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmx(zzne zzneVar, zzga zzgaVar) {
        this.zza = zzgaVar;
        Objects.requireNonNull(zzneVar);
        this.zzb = zzneVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzne zzneVar = this.zzb;
        synchronized (zzneVar) {
            zzneVar.zzd(false);
            zznk zznkVar = zzneVar.zza;
            if (!zznkVar.zzh()) {
                zznkVar.zzu.zzaV().zzk().zza("Connected to service");
                zznkVar.zzL(this.zza);
            }
        }
    }
}
