package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public abstract class zzkp extends zzbm implements zzkq {
    public zzkp() {
        super("com.google.android.gms.phenotype.internal.IGetStorageInfoCallbacks");
    }

    @Override // com.google.android.gms.internal.measurement.zzbm
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            byte[] createByteArray = parcel.createByteArray();
            zzbn.zzf(parcel);
            zzb((Status) zzbn.zzb(parcel, Status.CREATOR), createByteArray);
            return true;
        }
        return false;
    }
}
