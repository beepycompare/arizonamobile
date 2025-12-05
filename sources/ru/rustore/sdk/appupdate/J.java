package ru.rustore.sdk.appupdate;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import ru.rustore.sdk.appupdate.N;
import ru.rustore.sdk.appupdate.P;
import ru.rustore.sdk.appupdate.f0;
import ru.rustore.sdk.appupdate.h0;
/* loaded from: classes6.dex */
public interface J extends IInterface {

    /* loaded from: classes6.dex */
    public static abstract class a extends Binder implements J {

        /* renamed from: ru.rustore.sdk.appupdate.J$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class C0087a implements J {

            /* renamed from: a  reason: collision with root package name */
            public final IBinder f1487a;

            public C0087a(IBinder iBinder) {
                this.f1487a = iBinder;
            }

            @Override // ru.rustore.sdk.appupdate.J
            public final void a(String str, N.a aVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("ru.vk.store.provider.appupdate.AppUpdateProvider");
                    obtain.writeString(str);
                    obtain.writeStrongInterface(aVar);
                    this.f1487a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f1487a;
            }

            @Override // ru.rustore.sdk.appupdate.J
            public final void a(String str, Bundle bundle, P.a aVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("ru.vk.store.provider.appupdate.AppUpdateProvider");
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongInterface(aVar);
                    this.f1487a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // ru.rustore.sdk.appupdate.J
            public final void a(String str, h0.a aVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("ru.vk.store.provider.appupdate.AppUpdateProvider");
                    obtain.writeString(str);
                    obtain.writeStrongInterface(aVar);
                    this.f1487a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // ru.rustore.sdk.appupdate.J
            public final void a(String str, f0.a aVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("ru.vk.store.provider.appupdate.AppUpdateProvider");
                    obtain.writeString(str);
                    obtain.writeStrongInterface(aVar);
                    this.f1487a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static J a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("ru.vk.store.provider.appupdate.AppUpdateProvider");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof J)) ? new C0087a(iBinder) : (J) queryLocalInterface;
        }
    }

    void a(String str, Bundle bundle, P.a aVar);

    void a(String str, N.a aVar);

    void a(String str, f0.a aVar);

    void a(String str, h0.a aVar);
}
