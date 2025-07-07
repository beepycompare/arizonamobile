package com.bda.controller;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.bda.controller.IControllerListener;
import com.bda.controller.IControllerMonitor;
/* loaded from: classes3.dex */
public interface IControllerService extends IInterface {

    /* loaded from: classes3.dex */
    public static abstract class Stub extends Binder implements IControllerService {
        private static final String DESCRIPTOR = "com.bda.controller.IControllerService";
        static final int TRANSACTION_allowNewConnections = 12;
        static final int TRANSACTION_disallowNewConnections = 13;
        static final int TRANSACTION_getAxisValue = 7;
        static final int TRANSACTION_getInfo = 5;
        static final int TRANSACTION_getKeyCode = 6;
        static final int TRANSACTION_getKeyCode2 = 11;
        static final int TRANSACTION_getState = 8;
        static final int TRANSACTION_isAllowingNewConnections = 14;
        static final int TRANSACTION_registerListener = 1;
        static final int TRANSACTION_registerListener2 = 10;
        static final int TRANSACTION_registerMonitor = 3;
        static final int TRANSACTION_sendMessage = 9;
        static final int TRANSACTION_unregisterListener = 2;
        static final int TRANSACTION_unregisterMonitor = 4;

        /* loaded from: classes3.dex */
        private static class Proxy implements IControllerService {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.bda.controller.IControllerService
            public void allowNewConnections() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.bda.controller.IControllerService
            public void disallowNewConnections() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bda.controller.IControllerService
            public float getAxisValue(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readFloat();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bda.controller.IControllerService
            public int getInfo(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.bda.controller.IControllerService
            public int getKeyCode(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bda.controller.IControllerService
            public int getKeyCode2(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bda.controller.IControllerService
            public int getState(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bda.controller.IControllerService
            public boolean isAllowingNewConnections() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bda.controller.IControllerService
            public void registerListener(IControllerListener iControllerListener, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iControllerListener != null ? iControllerListener.asBinder() : null);
                    obtain.writeInt(i);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bda.controller.IControllerService
            public void registerListener2(IControllerListener iControllerListener, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iControllerListener != null ? iControllerListener.asBinder() : null);
                    obtain.writeInt(i);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bda.controller.IControllerService
            public void registerMonitor(IControllerMonitor iControllerMonitor, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iControllerMonitor != null ? iControllerMonitor.asBinder() : null);
                    obtain.writeInt(i);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bda.controller.IControllerService
            public void sendMessage(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bda.controller.IControllerService
            public void unregisterListener(IControllerListener iControllerListener, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iControllerListener != null ? iControllerListener.asBinder() : null);
                    obtain.writeInt(i);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bda.controller.IControllerService
            public void unregisterMonitor(IControllerMonitor iControllerMonitor, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iControllerMonitor != null ? iControllerMonitor.asBinder() : null);
                    obtain.writeInt(i);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IControllerService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IControllerService)) ? new Proxy(iBinder) : (IControllerService) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerListener(IControllerListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterListener(IControllerListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerMonitor(IControllerMonitor.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterMonitor(IControllerMonitor.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    int info = getInfo(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(info);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    int keyCode = getKeyCode(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(keyCode);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    float axisValue = getAxisValue(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeFloat(axisValue);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    int state = getState(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(state);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    sendMessage(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerListener2(IControllerListener.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    int keyCode2 = getKeyCode2(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(keyCode2);
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    allowNewConnections();
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    disallowNewConnections();
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isAllowingNewConnections = isAllowingNewConnections();
                    parcel2.writeNoException();
                    parcel2.writeInt(isAllowingNewConnections ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void allowNewConnections() throws RemoteException;

    void disallowNewConnections() throws RemoteException;

    float getAxisValue(int i, int i2) throws RemoteException;

    int getInfo(int i) throws RemoteException;

    int getKeyCode(int i, int i2) throws RemoteException;

    int getKeyCode2(int i, int i2) throws RemoteException;

    int getState(int i, int i2) throws RemoteException;

    boolean isAllowingNewConnections() throws RemoteException;

    void registerListener(IControllerListener iControllerListener, int i) throws RemoteException;

    void registerListener2(IControllerListener iControllerListener, int i) throws RemoteException;

    void registerMonitor(IControllerMonitor iControllerMonitor, int i) throws RemoteException;

    void sendMessage(int i, int i2) throws RemoteException;

    void unregisterListener(IControllerListener iControllerListener, int i) throws RemoteException;

    void unregisterMonitor(IControllerMonitor iControllerMonitor, int i) throws RemoteException;
}
