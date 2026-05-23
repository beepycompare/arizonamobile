package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@23.2.0 */
/* loaded from: classes4.dex */
final class zzes extends zzeo {
    final /* synthetic */ Activity zza;
    final /* synthetic */ zzey zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzes(zzey zzeyVar, Activity activity) {
        super(zzeyVar.zza, true);
        this.zza = activity;
        Objects.requireNonNull(zzeyVar);
        this.zzb = zzeyVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeo
    final void zza() throws RemoteException {
        ((zzcp) Preconditions.checkNotNull(this.zzb.zza.zzS())).onActivityStartedByScionActivityInfo(zzdd.zza(this.zza), this.zzj);
    }
}
