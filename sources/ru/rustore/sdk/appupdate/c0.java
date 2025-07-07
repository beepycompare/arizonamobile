package ru.rustore.sdk.appupdate;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.appupdate.d0;
import ru.rustore.sdk.appupdate.errors.RemoteProviderErrors;
import ru.rustore.sdk.appupdate.u;
import ru.rustore.sdk.core.exception.RuStoreException;
import ru.rustore.sdk.core.util.ContextExtKt;
/* loaded from: classes5.dex */
public final class c0 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1340a;
    public final String b;
    public final Function0<Unit> c;
    public final Function1<RuStoreException, Unit> d;

    public c0(Context context, String applicationId, q onSuccess, s onError) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.f1340a = context;
        this.b = applicationId;
        this.c = onSuccess;
        this.d = onError;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName name, IBinder service) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(service, "service");
        try {
            u.a.a(service).a(this.b, new a(this));
        } catch (Exception e) {
            Function1<RuStoreException, Unit> function1 = this.d;
            String message = e.getMessage();
            if (message == null) {
                message = "";
            }
            function1.invoke(new RuStoreException(message));
            ContextExtKt.unbindServiceSafely(this.f1340a, this);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.d.invoke(new RuStoreException("onServiceDisconnected"));
        ContextExtKt.unbindServiceSafely(this.f1340a, this);
    }

    /* loaded from: classes5.dex */
    public static final class a extends d0.a {
        public final /* synthetic */ c0 b;

        public a(c0 c0Var) {
            this.b = c0Var;
        }

        @Override // ru.rustore.sdk.appupdate.d0
        public final void a(int i, String errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            c0.this.d.invoke(RemoteProviderErrors.INSTANCE.toRuStoreException(i, errorMessage));
            ContextExtKt.unbindServiceSafely(c0.this.f1340a, this.b);
        }

        @Override // ru.rustore.sdk.appupdate.d0
        public final void a() {
            c0.this.c.invoke();
            ContextExtKt.unbindServiceSafely(c0.this.f1340a, this.b);
        }
    }
}
