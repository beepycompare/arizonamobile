package com.google.android.gms.internal.measurement;

import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@23.2.0 */
/* loaded from: classes4.dex */
final class zzds extends zzcu {
    final /* synthetic */ Runnable zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzds(zzdt zzdtVar, Runnable runnable) {
        this.zza = runnable;
        Objects.requireNonNull(zzdtVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzcv
    public final void zze() {
        this.zza.run();
    }
}
