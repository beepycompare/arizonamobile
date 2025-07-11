package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzef extends zzeq {
    final /* synthetic */ String zza;
    final /* synthetic */ zzco zzb;
    final /* synthetic */ zzfb zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzef(zzfb zzfbVar, String str, zzco zzcoVar) {
        super(zzfbVar, true);
        this.zza = str;
        this.zzb = zzcoVar;
        Objects.requireNonNull(zzfbVar);
        this.zzc = zzfbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    final void zza() throws RemoteException {
        ((zzcr) Preconditions.checkNotNull(this.zzc.zzQ())).getMaxUserProperties(this.zza, this.zzb);
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    protected final void zzb() {
        this.zzb.zzb(null);
    }
}
