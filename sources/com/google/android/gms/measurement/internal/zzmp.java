package com.google.android.gms.measurement.internal;

import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzmp extends zzay {
    final /* synthetic */ zznk zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzmp(zznk zznkVar, zzjf zzjfVar) {
        super(zzjfVar);
        Objects.requireNonNull(zznkVar);
        this.zza = zznkVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzay
    public final void zza() {
        this.zza.zzu.zzaV().zze().zza("Tasks have been queued for a long time");
    }
}
