package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzel extends zzeo {
    final /* synthetic */ zzeq zza;
    final /* synthetic */ zzez zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzel(zzez zzezVar, zzeq zzeqVar) {
        super(zzezVar, true);
        this.zza = zzeqVar;
        Objects.requireNonNull(zzezVar);
        this.zzb = zzezVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeo
    final void zza() throws RemoteException {
        ((zzcp) Preconditions.checkNotNull(this.zzb.zzS())).registerOnMeasurementEventListener(this.zza);
    }
}
