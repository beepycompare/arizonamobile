package com.google.android.gms.internal.play_billing;

import android.os.BadParcelableException;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: com.android.billingclient:billing@@8.3.0 */
/* loaded from: classes4.dex */
public class zzat extends Binder implements IInterface {
    private static zzav globalInterceptor;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzat(String str) {
        attachInterface(this, str);
    }

    static synchronized void installTransactionInterceptorPackagePrivate(zzav zzavVar) {
        synchronized (zzat.class) {
            try {
                if (zzavVar != null) {
                    if (globalInterceptor == null) {
                        globalInterceptor = zzavVar;
                    } else {
                        throw new IllegalStateException("Duplicate TransactionInterceptor installation.");
                    }
                } else {
                    throw new IllegalArgumentException("null interceptor");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean routeToSuperOrEnforceInterface(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i > 16777215) {
            return super.onTransact(i, parcel, parcel2, i2);
        }
        parcel.enforceInterface(getInterfaceDescriptor());
        return false;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    protected boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void enforceNoDataAvail(Parcel parcel) {
        zzav zzavVar = globalInterceptor;
        if (zzavVar != null) {
            zzavVar.zza();
            return;
        }
        int i = zzau.zza;
        int dataAvail = parcel.dataAvail();
        if (dataAvail <= 0) {
            return;
        }
        throw new BadParcelableException("Parcel data not fully consumed, unread size: " + dataAvail);
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (routeToSuperOrEnforceInterface(i, parcel, parcel2, i2)) {
            return true;
        }
        zzav zzavVar = globalInterceptor;
        if (zzavVar == null) {
            return dispatchTransaction(i, parcel, parcel2, i2);
        }
        return zzavVar.zzb();
    }
}
