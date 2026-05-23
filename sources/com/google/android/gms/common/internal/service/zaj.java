package com.google.android.gms.common.internal.service;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
/* loaded from: classes4.dex */
public final class zaj extends com.google.android.gms.internal.base.zaa implements IInterface {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zaj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.IClientNotificationTelemetryService");
    }

    public final void zae(com.google.android.gms.common.internal.zab zabVar) throws RemoteException {
        Parcel zaa = zaa();
        com.google.android.gms.internal.base.zac.zab(zaa, zabVar);
        zad(1, zaa);
    }
}
