package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes3.dex */
public interface IStatusCallback extends IInterface {

    /* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
    /* loaded from: classes3.dex */
    public static abstract class Stub extends com.google.android.gms.internal.base.zab implements IStatusCallback {
        public Stub() {
            super("com.google.android.gms.common.api.internal.IStatusCallback");
        }

        public static IStatusCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.api.internal.IStatusCallback");
            return queryLocalInterface instanceof IStatusCallback ? (IStatusCallback) queryLocalInterface : new zaby(iBinder);
        }

        @Override // com.google.android.gms.internal.base.zab
        protected final boolean zaa(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                com.google.android.gms.internal.base.zac.zab(parcel);
                onResult((Status) com.google.android.gms.internal.base.zac.zaa(parcel, Status.CREATOR));
                return true;
            }
            return false;
        }
    }

    void onResult(Status status) throws RemoteException;
}
