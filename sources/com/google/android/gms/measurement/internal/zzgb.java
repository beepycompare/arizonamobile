package com.google.android.gms.measurement.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzgb extends com.google.android.gms.internal.measurement.zzbl implements zzgd {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.ITriggerUrisCallback");
    }

    @Override // com.google.android.gms.measurement.internal.zzgd
    public final void zze(List list) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzd(2, zza);
    }
}
