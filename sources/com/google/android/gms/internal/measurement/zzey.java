package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.5.0 */
/* loaded from: classes3.dex */
final class zzey extends zzeq {
    final /* synthetic */ Activity zza;
    final /* synthetic */ zzco zzb;
    final /* synthetic */ zzfa zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzey(zzfa zzfaVar, Activity activity, zzco zzcoVar) {
        super(zzfaVar.zza, true);
        this.zza = activity;
        this.zzb = zzcoVar;
        Objects.requireNonNull(zzfaVar);
        this.zzc = zzfaVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    final void zza() throws RemoteException {
        ((zzcr) Preconditions.checkNotNull(this.zzc.zza.zzQ())).onActivitySaveInstanceStateByScionActivityInfo(zzdf.zza(this.zza), this.zzb, this.zzi);
    }
}
