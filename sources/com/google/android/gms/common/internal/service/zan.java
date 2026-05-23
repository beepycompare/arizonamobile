package com.google.android.gms.common.internal.service;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.google.android.gms:play-services-base@@18.9.0 */
/* loaded from: classes4.dex */
public final class zan extends com.google.android.gms.internal.base.zaa implements IInterface {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zan(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.ICommonService");
    }

    public final void zae(zam zamVar) throws RemoteException {
        Parcel zaa = zaa();
        com.google.android.gms.internal.base.zac.zac(zaa, zamVar);
        zad(1, zaa);
    }
}
