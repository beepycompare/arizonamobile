package ru.rustore.sdk.appupdate;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.appupdate.errors.RemoteProviderErrors;
import ru.rustore.sdk.appupdate.w;
import ru.rustore.sdk.core.util.ContextExtKt;
/* loaded from: classes5.dex */
public abstract class v extends Binder implements IInterface {
    public v() {
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
            w.a aVar = (w.a) this;
            w.this.c.invoke();
            ContextExtKt.unbindServiceSafely(w.this.f1364a, aVar.b);
        } else if (i != 2) {
            return super.onTransact(i, parcel, parcel2, i2);
        } else {
            int readInt = parcel.readInt();
            String errorMessage = parcel.readString();
            w.a aVar2 = (w.a) this;
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            w.this.d.invoke(RemoteProviderErrors.INSTANCE.toRuStoreException(readInt, errorMessage));
            ContextExtKt.unbindServiceSafely(w.this.f1364a, aVar2.b);
        }
        parcel2.writeNoException();
        return true;
    }
}
