package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzdn extends zzeo {
    final /* synthetic */ zzez zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdn(zzez zzezVar) {
        super(zzezVar, true);
        Objects.requireNonNull(zzezVar);
        this.zza = zzezVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeo
    final void zza() throws RemoteException {
        zzez zzezVar = this.zza;
        if (zzezVar.zzP()) {
            ((zzcp) Preconditions.checkNotNull(zzezVar.zzS())).resetAnalyticsDataWithElapsedTime(this.zzi, this.zzj);
        } else {
            ((zzcp) Preconditions.checkNotNull(zzezVar.zzS())).resetAnalyticsData(this.zzi);
        }
    }
}
