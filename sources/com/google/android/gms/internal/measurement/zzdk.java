package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzdk extends zzeo {
    final /* synthetic */ zzdd zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzez zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdk(zzez zzezVar, zzdd zzddVar, String str, String str2) {
        super(zzezVar, true);
        this.zza = zzddVar;
        this.zzb = str;
        this.zzc = str2;
        Objects.requireNonNull(zzezVar);
        this.zzd = zzezVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeo
    final void zza() throws RemoteException {
        ((zzcp) Preconditions.checkNotNull(this.zzd.zzS())).setCurrentScreenByScionActivityInfo(this.zza, this.zzb, this.zzc, this.zzi);
    }
}
