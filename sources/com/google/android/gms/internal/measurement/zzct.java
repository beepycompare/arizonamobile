package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.5.0 */
/* loaded from: classes3.dex */
public abstract class zzct extends zzbm implements zzcu {
    public zzct() {
        super("com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    @Override // com.google.android.gms.internal.measurement.zzbm
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzbn.zzf(parcel);
            zzb((Bundle) zzbn.zzb(parcel, Bundle.CREATOR));
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}
