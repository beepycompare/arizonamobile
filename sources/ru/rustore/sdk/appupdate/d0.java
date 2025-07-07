package ru.rustore.sdk.appupdate;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes5.dex */
public interface d0 extends IInterface {

    /* loaded from: classes5.dex */
    public static abstract class a extends Binder implements d0 {
        public a() {
            attachInterface(this, "ru.vk.store.provider.appupdate.StartUpdateFlowCallback");
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface("ru.vk.store.provider.appupdate.StartUpdateFlowCallback");
            }
            if (i == 1598968902) {
                parcel2.writeString("ru.vk.store.provider.appupdate.StartUpdateFlowCallback");
                return true;
            }
            if (i == 1) {
                a();
            } else if (i != 2) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                a(parcel.readInt(), parcel.readString());
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void a();

    void a(int i, String str);
}
