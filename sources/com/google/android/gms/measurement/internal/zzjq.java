package com.google.android.gms.measurement.internal;

import android.util.Log;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzjq implements zzgl {
    final /* synthetic */ zzib zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjq(zzjr zzjrVar, zzib zzibVar) {
        this.zza = zzibVar;
        Objects.requireNonNull(zzjrVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzgl
    public final boolean zza() {
        return Log.isLoggable(this.zza.zzaV().zzn(), 3);
    }
}
