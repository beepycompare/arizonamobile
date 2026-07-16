package ru.rustore.sdk.appupdate;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.appupdate.J;
import ru.rustore.sdk.core.exception.RuStoreException;
import ru.rustore.sdk.core.util.ContextExtKt;
/* loaded from: classes6.dex */
public final class N implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1494a;
    public final String b;
    public final Function0<Unit> c;
    public final Function1<RuStoreException, Unit> d;

    /* loaded from: classes6.dex */
    public static final class a extends M {
        public final /* synthetic */ N b;

        public a(N n) {
            this.b = n;
        }
    }

    public N(Context context, String applicationId, C0818s onSuccess, C0819t onError) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.f1494a = context;
        this.b = applicationId;
        this.c = onSuccess;
        this.d = onError;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName name, IBinder service) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(service, "service");
        try {
            J.a.a(service).a(this.b, new a(this));
        } catch (Exception e) {
            Function1<RuStoreException, Unit> function1 = this.d;
            String message = e.getMessage();
            if (message == null) {
                message = "";
            }
            function1.invoke(new RuStoreException(message));
            ContextExtKt.unbindServiceSafely(this.f1494a, this);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.d.invoke(new RuStoreException("onServiceDisconnected"));
        ContextExtKt.unbindServiceSafely(this.f1494a, this);
    }
}
