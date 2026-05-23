package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzeg extends zzeo {
    final /* synthetic */ zzcm zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzez zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzeg(zzez zzezVar, zzcm zzcmVar, int i) {
        super(zzezVar, true);
        this.zza = zzcmVar;
        this.zzb = i;
        Objects.requireNonNull(zzezVar);
        this.zzc = zzezVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeo
    final void zza() throws RemoteException {
        ((zzcp) Preconditions.checkNotNull(this.zzc.zzS())).getTestFlag(this.zza, this.zzb);
    }

    @Override // com.google.android.gms.internal.measurement.zzeo
    protected final void zzb() {
        this.zza.zzb(null);
    }
}
