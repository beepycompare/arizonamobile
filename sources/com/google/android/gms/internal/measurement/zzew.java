package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.5.0 */
/* loaded from: classes3.dex */
final class zzew extends zzeq {
    final /* synthetic */ Activity zza;
    final /* synthetic */ zzfa zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzew(zzfa zzfaVar, Activity activity) {
        super(zzfaVar.zza, true);
        this.zza = activity;
        Objects.requireNonNull(zzfaVar);
        this.zzb = zzfaVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    final void zza() throws RemoteException {
        ((zzcr) Preconditions.checkNotNull(this.zzb.zza.zzQ())).onActivityPausedByScionActivityInfo(zzdf.zza(this.zza), this.zzi);
    }
}
