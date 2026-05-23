package com.google.android.gms.internal.measurement;

import android.os.Bundle;
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@23.2.0 */
/* loaded from: classes4.dex */
final class zzep extends zzcx {
    private final com.google.android.gms.measurement.internal.zzjp zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzep(com.google.android.gms.measurement.internal.zzjp zzjpVar) {
        this.zza = zzjpVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzcy
    public final void zze(String str, String str2, Bundle bundle, long j) {
        this.zza.interceptEvent(str, str2, bundle, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzcy
    public final int zzf() {
        return System.identityHashCode(this.zza);
    }
}
