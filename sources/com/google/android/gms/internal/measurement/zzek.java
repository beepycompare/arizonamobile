package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzek extends zzeq {
    final /* synthetic */ Bundle zza;
    final /* synthetic */ zzfb zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzek(zzfb zzfbVar, Bundle bundle) {
        super(zzfbVar, true);
        this.zza = bundle;
        Objects.requireNonNull(zzfbVar);
        this.zzb = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    final void zza() throws RemoteException {
        ((zzcr) Preconditions.checkNotNull(this.zzb.zzQ())).setDefaultEventParameters(this.zza);
    }
}
