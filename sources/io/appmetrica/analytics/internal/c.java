package io.appmetrica.analytics.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
/* loaded from: classes4.dex */
public final class c implements IAppMetricaService {

    /* renamed from: a  reason: collision with root package name */
    public final IBinder f1179a;

    public c(IBinder iBinder) {
        this.f1179a = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f1179a;
    }

    @Override // io.appmetrica.analytics.internal.IAppMetricaService
    public final void pauseUserSession(Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(IAppMetricaService.DESCRIPTOR);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f1179a.transact(2, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    @Override // io.appmetrica.analytics.internal.IAppMetricaService
    public final void reportData(int i, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(IAppMetricaService.DESCRIPTOR);
            obtain.writeInt(i);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f1179a.transact(3, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    @Override // io.appmetrica.analytics.internal.IAppMetricaService
    public final void resumeUserSession(Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(IAppMetricaService.DESCRIPTOR);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f1179a.transact(1, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
