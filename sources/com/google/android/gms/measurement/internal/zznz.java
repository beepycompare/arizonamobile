package com.google.android.gms.measurement.internal;

import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zznz extends zzaz {
    final /* synthetic */ zzoa zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zznz(zzoa zzoaVar, zzjg zzjgVar) {
        super(zzjgVar);
        Objects.requireNonNull(zzoaVar);
        this.zza = zzoaVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzaz
    public final void zza() {
        zzoa zzoaVar = this.zza;
        zzoc zzocVar = zzoaVar.zzc;
        zzocVar.zzg();
        zzic zzicVar = zzocVar.zzu;
        zzoaVar.zzd(false, false, zzicVar.zzba().elapsedRealtime());
        zzocVar.zzu.zzw().zzc(zzicVar.zzba().elapsedRealtime());
    }
}
