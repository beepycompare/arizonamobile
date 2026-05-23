package com.google.android.gms.internal.measurement;

import java.util.Objects;
import java.util.logging.Level;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
final class zzxq extends zzxo implements zzxp {
    final /* synthetic */ zzxs zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzxq(zzxs zzxsVar, Level level, boolean z) {
        super(level, false);
        Objects.requireNonNull(zzxsVar);
        this.zza = zzxsVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzxz
    protected final /* synthetic */ zzxi zzc() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzxz
    protected final /* bridge */ /* synthetic */ zzyi zzd() {
        return this;
    }
}
