package com.google.android.gms.measurement.internal;

import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
final class zzjx implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzli zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjx(zzli zzliVar, boolean z) {
        this.zza = z;
        Objects.requireNonNull(zzliVar);
        this.zzb = zzliVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzli zzliVar = this.zzb;
        zzib zzibVar = zzliVar.zzu;
        boolean zzB = zzibVar.zzB();
        boolean zzA = zzibVar.zzA();
        boolean z = this.zza;
        zzibVar.zzz(z);
        if (zzA == z) {
            zzibVar.zzaV().zzk().zzb("Default data collection state already set to", Boolean.valueOf(z));
        }
        if (zzibVar.zzB() == zzB || zzibVar.zzB() != zzibVar.zzA()) {
            zzibVar.zzaV().zzh().zzc("Default data collection is different than actual status", Boolean.valueOf(z), Boolean.valueOf(zzB));
        }
        zzliVar.zzak();
    }
}
