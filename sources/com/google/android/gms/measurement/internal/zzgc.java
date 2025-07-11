package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public abstract class zzgc extends com.google.android.gms.internal.measurement.zzbm implements zzgd {
    public zzgc() {
        super("com.google.android.gms.measurement.internal.ITriggerUrisCallback");
    }

    @Override // com.google.android.gms.internal.measurement.zzbm
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            ArrayList createTypedArrayList = parcel.createTypedArrayList(zzog.CREATOR);
            com.google.android.gms.internal.measurement.zzbn.zzf(parcel);
            zze(createTypedArrayList);
            return true;
        }
        return false;
    }
}
