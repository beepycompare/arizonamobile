package ru.rustore.sdk.appupdate;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.appupdate.P;
import ru.rustore.sdk.appupdate.errors.RemoteProviderErrors;
import ru.rustore.sdk.core.util.ContextExtKt;
/* loaded from: classes6.dex */
public abstract class O extends Binder implements IInterface {
    public O() {
        attachInterface(this, "ru.vk.store.provider.appupdate.GetAppUpdateInfoCallback");
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i >= 1 && i <= 16777215) {
            parcel.enforceInterface("ru.vk.store.provider.appupdate.GetAppUpdateInfoCallback");
        }
        if (i == 1598968902) {
            parcel2.writeString("ru.vk.store.provider.appupdate.GetAppUpdateInfoCallback");
            return true;
        }
        if (i == 1) {
            Bundle updateInfoBundle = (Bundle) (parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null);
            P.a aVar = (P.a) this;
            Intrinsics.checkNotNullParameter(updateInfoBundle, "updateInfoBundle");
            P.this.e.invoke(P.this.b.a(updateInfoBundle));
            ContextExtKt.unbindServiceSafely(P.this.f1521a, aVar.b);
        } else if (i != 2) {
            return super.onTransact(i, parcel, parcel2, i2);
        } else {
            int readInt = parcel.readInt();
            String errorMessage = parcel.readString();
            P.a aVar2 = (P.a) this;
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            P.this.f.invoke(RemoteProviderErrors.INSTANCE.toRuStoreException(readInt, errorMessage));
            ContextExtKt.unbindServiceSafely(P.this.f1521a, aVar2.b);
        }
        parcel2.writeNoException();
        return true;
    }
}
