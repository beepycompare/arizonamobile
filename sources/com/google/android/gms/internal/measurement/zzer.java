package com.google.android.gms.internal.measurement;

import android.os.Bundle;
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.5.0 */
/* loaded from: classes3.dex */
final class zzer extends zzcz {
    private final com.google.android.gms.measurement.internal.zzjo zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzer(com.google.android.gms.measurement.internal.zzjo zzjoVar) {
        this.zza = zzjoVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzda
    public final void zze(String str, String str2, Bundle bundle, long j) {
        this.zza.interceptEvent(str, str2, bundle, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzda
    public final int zzf() {
        return System.identityHashCode(this.zza);
    }
}
