package ru.rustore.sdk.appupdate;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import ru.rustore.sdk.appupdate.c0;
import ru.rustore.sdk.appupdate.e0;
import ru.rustore.sdk.appupdate.w;
import ru.rustore.sdk.appupdate.y;
/* loaded from: classes5.dex */
public interface u extends IInterface {

    /* loaded from: classes5.dex */
    public static abstract class a extends Binder implements u {

        /* renamed from: ru.rustore.sdk.appupdate.u$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static class C0114a implements u {

            /* renamed from: a  reason: collision with root package name */
            public final IBinder f1363a;

            public C0114a(IBinder iBinder) {
                this.f1363a = iBinder;
            }

            @Override // ru.rustore.sdk.appupdate.u
            public final void a(String str, w.a aVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("ru.vk.store.provider.appupdate.AppUpdateProvider");
                    obtain.writeString(str);
                    obtain.writeStrongInterface(aVar);
                    this.f1363a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f1363a;
            }

            @Override // ru.rustore.sdk.appupdate.u
            public final void a(String str, Bundle bundle, y.a aVar) {
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
                    this.f1363a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // ru.rustore.sdk.appupdate.u
            public final void a(String str, e0.a aVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("ru.vk.store.provider.appupdate.AppUpdateProvider");
                    obtain.writeString(str);
                    obtain.writeStrongInterface(aVar);
                    this.f1363a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // ru.rustore.sdk.appupdate.u
            public final void a(String str, c0.a aVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("ru.vk.store.provider.appupdate.AppUpdateProvider");
                    obtain.writeString(str);
                    obtain.writeStrongInterface(aVar);
                    this.f1363a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static u a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("ru.vk.store.provider.appupdate.AppUpdateProvider");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof u)) ? new C0114a(iBinder) : (u) queryLocalInterface;
        }
    }

    void a(String str, Bundle bundle, y.a aVar);

    void a(String str, c0.a aVar);

    void a(String str, e0.a aVar);

    void a(String str, w.a aVar);
}
