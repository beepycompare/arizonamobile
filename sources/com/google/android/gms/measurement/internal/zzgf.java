package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public abstract class zzgf extends com.google.android.gms.internal.measurement.zzbm implements zzgg {
    public zzgf() {
        super("com.google.android.gms.measurement.internal.IUploadBatchesCallback");
    }

    @Override // com.google.android.gms.internal.measurement.zzbm
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
            zze((zzop) com.google.android.gms.internal.measurement.zzbn.zzb(parcel, zzop.CREATOR));
            return true;
        }
        return false;
    }
}
