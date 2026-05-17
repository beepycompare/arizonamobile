package ru.rustore.sdk.appupdate;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.appupdate.N;
import ru.rustore.sdk.appupdate.errors.RemoteProviderErrors;
import ru.rustore.sdk.core.util.ContextExtKt;
/* loaded from: classes6.dex */
public abstract class M extends Binder implements IInterface {
    public M() {
        attachInterface(this, "ru.vk.store.provider.appupdate.CompleteUpdateFlowCallback");
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i >= 1 && i <= 16777215) {
            parcel.enforceInterface("ru.vk.store.provider.appupdate.CompleteUpdateFlowCallback");
        }
        if (i == 1598968902) {
            parcel2.writeString("ru.vk.store.provider.appupdate.CompleteUpdateFlowCallback");
            return true;
        }
        if (i == 1) {
            N.a aVar = (N.a) this;
            N.this.c.invoke();
            ContextExtKt.unbindServiceSafely(N.this.f1519a, aVar.b);
        } else if (i != 2) {
            return super.onTransact(i, parcel, parcel2, i2);
        } else {
            int readInt = parcel.readInt();
            String errorMessage = parcel.readString();
            N.a aVar2 = (N.a) this;
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            N.this.d.invoke(RemoteProviderErrors.INSTANCE.toRuStoreException(readInt, errorMessage));
            ContextExtKt.unbindServiceSafely(N.this.f1519a, aVar2.b);
        }
        parcel2.writeNoException();
        return true;
    }
}
