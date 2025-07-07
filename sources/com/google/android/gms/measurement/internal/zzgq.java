package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public abstract class zzgq extends com.google.android.gms.internal.measurement.zzbn implements zzgr {
    public zzgq() {
        super("com.google.android.gms.measurement.internal.IUploadBatchesCallback");
    }

    @Override // com.google.android.gms.internal.measurement.zzbn
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
            zze((zzpe) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzpe.CREATOR));
            return true;
        }
        return false;
    }
}
