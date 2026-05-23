package io.appmetrica.analytics.impl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* renamed from: io.appmetrica.analytics.impl.zb  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractBinderC0765zb extends Binder implements Ab {
    public AbstractBinderC0765zb() {
        attachInterface(this, "ru.vk.store.sdk.install.referrer.InstallReferrerProvider");
    }

    public static Ab a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("ru.vk.store.sdk.install.referrer.InstallReferrerProvider");
        if (queryLocalInterface != null && (queryLocalInterface instanceof Ab)) {
            return (Ab) queryLocalInterface;
        }
        return new C0739yb(iBinder);
    }

    public abstract /* synthetic */ void a(String str, La la) throws RemoteException;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i >= 1 && i <= 16777215) {
            parcel.enforceInterface("ru.vk.store.sdk.install.referrer.InstallReferrerProvider");
        }
        if (i == 1598968902) {
            parcel2.writeString("ru.vk.store.sdk.install.referrer.InstallReferrerProvider");
            return true;
        } else if (i != 1) {
            return super.onTransact(i, parcel, parcel2, i2);
        } else {
            a(parcel.readString(), Ka.a(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }
    }
}
