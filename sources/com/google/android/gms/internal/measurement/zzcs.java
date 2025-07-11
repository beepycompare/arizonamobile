package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-measurement-base@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzcs extends zzbl implements zzcu {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    @Override // com.google.android.gms.internal.measurement.zzcu
    public final void zzb(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, bundle);
        zzc(1, zza);
    }
}
