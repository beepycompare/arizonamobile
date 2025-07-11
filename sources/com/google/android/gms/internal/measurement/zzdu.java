package com.google.android.gms.internal.measurement;

import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.5.0 */
/* loaded from: classes3.dex */
final class zzdu extends zzcw {
    final /* synthetic */ Runnable zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdu(zzdv zzdvVar, Runnable runnable) {
        this.zza = runnable;
        Objects.requireNonNull(zzdvVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzcx
    public final void zze() {
        this.zza.run();
    }
}
