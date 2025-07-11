package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzdq extends zzeq {
    final /* synthetic */ long zza;
    final /* synthetic */ zzfb zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdq(zzfb zzfbVar, long j) {
        super(zzfbVar, true);
        this.zza = j;
        Objects.requireNonNull(zzfbVar);
        this.zzb = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    final void zza() throws RemoteException {
        ((zzcr) Preconditions.checkNotNull(this.zzb.zzQ())).setSessionTimeoutDuration(this.zza);
    }
}
