package com.google.android.gms.common.internal.service;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.TelemetryData;
/* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
/* loaded from: classes4.dex */
public final class zak extends com.google.android.gms.internal.base.zaa implements IInterface {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zak(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService");
    }

    public final void zae(TelemetryData telemetryData) throws RemoteException {
        Parcel zaa = zaa();
        com.google.android.gms.internal.base.zac.zab(zaa, telemetryData);
        zad(1, zaa);
    }
}
