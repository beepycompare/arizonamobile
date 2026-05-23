package com.google.android.gms.measurement.internal;

import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
final class zzjy implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzlj zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjy(zzlj zzljVar, boolean z) {
        this.zza = z;
        Objects.requireNonNull(zzljVar);
        this.zzb = zzljVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlj zzljVar = this.zzb;
        zzic zzicVar = zzljVar.zzu;
        boolean zzB = zzicVar.zzB();
        boolean zzA = zzicVar.zzA();
        boolean z = this.zza;
        zzicVar.zzz(z);
        if (zzA == z) {
            zzicVar.zzaW().zzk().zzb("Default data collection state already set to", Boolean.valueOf(z));
        }
        if (zzicVar.zzB() == zzB || zzicVar.zzB() != zzicVar.zzA()) {
            zzicVar.zzaW().zzh().zzc("Default data collection is different than actual status", Boolean.valueOf(z), Boolean.valueOf(zzB));
        }
        zzljVar.zzak();
    }
}
