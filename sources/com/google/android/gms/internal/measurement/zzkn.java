package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public abstract class zzkn extends zzbm implements zzko {
    public zzkn() {
        super("com.google.android.gms.phenotype.internal.IFlagUpdateListener");
    }

    @Override // com.google.android.gms.internal.measurement.zzbm
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            byte[] createByteArray = parcel.createByteArray();
            zzbn.zzf(parcel);
            zzb(createByteArray);
            return true;
        }
        return false;
    }
}
