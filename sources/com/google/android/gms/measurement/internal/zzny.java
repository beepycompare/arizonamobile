package com.google.android.gms.measurement.internal;

import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzny extends zzay {
    final /* synthetic */ zznz zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzny(zznz zznzVar, zzjf zzjfVar) {
        super(zzjfVar);
        Objects.requireNonNull(zznzVar);
        this.zza = zznzVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzay
    public final void zza() {
        zznz zznzVar = this.zza;
        zzob zzobVar = zznzVar.zzc;
        zzobVar.zzg();
        zzib zzibVar = zzobVar.zzu;
        zznzVar.zzd(false, false, zzibVar.zzaZ().elapsedRealtime());
        zzobVar.zzu.zzw().zzc(zzibVar.zzaZ().elapsedRealtime());
    }
}
