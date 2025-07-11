package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzbo extends zzbl implements zzbq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbo(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    @Override // com.google.android.gms.internal.measurement.zzbq
    public final Bundle zze(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzbn.zzc(zza, bundle);
        Parcel zzP = zzP(1, zza);
        Bundle bundle2 = (Bundle) zzbn.zzb(zzP, Bundle.CREATOR);
        zzP.recycle();
        return bundle2;
    }
}
