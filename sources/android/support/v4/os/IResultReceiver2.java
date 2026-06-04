package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import kotlin.text.Typography;
/* loaded from: classes.dex */
public interface IResultReceiver2 extends IInterface {
    public static final String DESCRIPTOR = "android$support$v4$os$IResultReceiver2".replace((char) Typography.dollar, '.');
    public static final int VERSION = 1;

    /* loaded from: classes.dex */
    public static class Default implements IResultReceiver2 {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // android.support.v4.os.IResultReceiver2
        public int getInterfaceVersion() {
            return 0;
        }

        @Override // android.support.v4.os.IResultReceiver2
        public void send(int i, Bundle bundle) throws RemoteException {
        }
    }

    int getInterfaceVersion() throws RemoteException;

    void send(int i, Bundle bundle) throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IResultReceiver2 {
        static final int TRANSACTION_getInterfaceVersion = 16777215;
        static final int TRANSACTION_send = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IResultReceiver2 asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IResultReceiver2)) {
                return (IResultReceiver2) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = DESCRIPTOR;
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i == 1598968902) {
                parcel2.writeString(str);
                return true;
            } else if (i == 16777215) {
                parcel2.writeNoException();
                parcel2.writeInt(getInterfaceVersion());
                return true;
            } else if (i == 1) {
                send(parcel.readInt(), (Bundle) parcel.readTypedObject(Bundle.CREATOR));
                return true;
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* loaded from: classes.dex */
        private static class Proxy implements IResultReceiver2 {
            private int mCachedVersion = -1;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

            @Override // android.support.v4.os.IResultReceiver2
            public void send(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeTypedObject(bundle, 0);
                    if (this.mRemote.transact(1, obtain, null, 1)) {
                        return;
                    }
                    throw new RemoteException("Method send is unimplemented.");
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.support.v4.os.IResultReceiver2
            public int getInterfaceVersion() throws RemoteException {
                if (this.mCachedVersion == -1) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(DESCRIPTOR);
                        this.mRemote.transact(16777215, obtain, obtain2, 0);
                        obtain2.readException();
                        this.mCachedVersion = obtain2.readInt();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return this.mCachedVersion;
            }
        }
    }
}
