package ru.vk.store.provider.analytics;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes5.dex */
public interface AnalyticsProviderCallback extends IInterface {
    public static final String DESCRIPTOR = "ru.vk.store.provider.analytics.AnalyticsProviderCallback";

    /* loaded from: classes5.dex */
    public static class Default implements AnalyticsProviderCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // ru.vk.store.provider.analytics.AnalyticsProviderCallback
        public void onError(int i, String str) throws RemoteException {
        }

        @Override // ru.vk.store.provider.analytics.AnalyticsProviderCallback
        public void onSuccess() throws RemoteException {
        }
    }

    void onError(int i, String str) throws RemoteException;

    void onSuccess() throws RemoteException;

    /* loaded from: classes5.dex */
    public static abstract class Stub extends Binder implements AnalyticsProviderCallback {
        static final int TRANSACTION_onError = 2;
        static final int TRANSACTION_onSuccess = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, AnalyticsProviderCallback.DESCRIPTOR);
        }

        public static AnalyticsProviderCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(AnalyticsProviderCallback.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof AnalyticsProviderCallback)) {
                return (AnalyticsProviderCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(AnalyticsProviderCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(AnalyticsProviderCallback.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                onSuccess();
                parcel2.writeNoException();
            } else if (i == 2) {
                onError(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            return true;
        }

        /* loaded from: classes5.dex */
        private static class Proxy implements AnalyticsProviderCallback {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return AnalyticsProviderCallback.DESCRIPTOR;
            }

            @Override // ru.vk.store.provider.analytics.AnalyticsProviderCallback
            public void onSuccess() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AnalyticsProviderCallback.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // ru.vk.store.provider.analytics.AnalyticsProviderCallback
            public void onError(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AnalyticsProviderCallback.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
