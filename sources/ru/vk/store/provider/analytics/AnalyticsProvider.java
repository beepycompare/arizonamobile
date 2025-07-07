package ru.vk.store.provider.analytics;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import ru.vk.store.provider.analytics.AnalyticsProviderCallback;
/* loaded from: classes5.dex */
public interface AnalyticsProvider extends IInterface {
    public static final String DESCRIPTOR = "ru.vk.store.provider.analytics.AnalyticsProvider";

    /* loaded from: classes5.dex */
    public static class Default implements AnalyticsProvider {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // ru.vk.store.provider.analytics.AnalyticsProvider
        public void postAnalytcsEvent(String str, String str2, Bundle bundle, AnalyticsProviderCallback analyticsProviderCallback) throws RemoteException {
        }
    }

    void postAnalytcsEvent(String str, String str2, Bundle bundle, AnalyticsProviderCallback analyticsProviderCallback) throws RemoteException;

    /* loaded from: classes5.dex */
    public static abstract class Stub extends Binder implements AnalyticsProvider {
        static final int TRANSACTION_postAnalytcsEvent = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, AnalyticsProvider.DESCRIPTOR);
        }

        public static AnalyticsProvider asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(AnalyticsProvider.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof AnalyticsProvider)) {
                return (AnalyticsProvider) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(AnalyticsProvider.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(AnalyticsProvider.DESCRIPTOR);
                return true;
            } else if (i == 1) {
                postAnalytcsEvent(parcel.readString(), parcel.readString(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR), AnalyticsProviderCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* loaded from: classes5.dex */
        private static class Proxy implements AnalyticsProvider {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return AnalyticsProvider.DESCRIPTOR;
            }

            @Override // ru.vk.store.provider.analytics.AnalyticsProvider
            public void postAnalytcsEvent(String str, String str2, Bundle bundle, AnalyticsProviderCallback analyticsProviderCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AnalyticsProvider.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    _Parcel.writeTypedObject(obtain, bundle, 0);
                    obtain.writeStrongInterface(analyticsProviderCallback);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
                return;
            }
            parcel.writeInt(0);
        }
    }
}
