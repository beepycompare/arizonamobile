package com.google.android.gms.measurement.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzge extends com.google.android.gms.internal.measurement.zzbl implements zzgg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzge(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IUploadBatchesCallback");
    }

    @Override // com.google.android.gms.measurement.internal.zzgg
    public final void zze(zzop zzopVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.measurement.zzbn.zzc(zza, zzopVar);
        zzd(2, zza);
    }
}
