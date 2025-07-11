package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.5.0 */
/* loaded from: classes3.dex */
public abstract class zzcz extends zzbm implements zzda {
    public zzcz() {
        super("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override // com.google.android.gms.internal.measurement.zzbm
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            long readLong = parcel.readLong();
            zzbn.zzf(parcel);
            zze(parcel.readString(), parcel.readString(), (Bundle) zzbn.zzb(parcel, Bundle.CREATOR), readLong);
            parcel2.writeNoException();
        } else if (i != 2) {
            return false;
        } else {
            int zzf = zzf();
            parcel2.writeNoException();
            parcel2.writeInt(zzf);
        }
        return true;
    }
}
