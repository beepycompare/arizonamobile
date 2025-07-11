package com.google.android.gms.measurement.internal;

import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzka extends zzay {
    final /* synthetic */ zzli zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzka(zzli zzliVar, zzjf zzjfVar) {
        super(zzjfVar);
        Objects.requireNonNull(zzliVar);
        this.zza = zzliVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzay
    public final void zza() {
        this.zza.zzD();
    }
}
