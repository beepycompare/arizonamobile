package com.google.android.gms.measurement.internal;

import android.util.Log;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzjr implements zzgm {
    final /* synthetic */ zzic zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjr(zzjs zzjsVar, zzic zzicVar) {
        this.zza = zzicVar;
        Objects.requireNonNull(zzjsVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    public final boolean zza() {
        return Log.isLoggable(this.zza.zzaW().zzn(), 3);
    }
}
