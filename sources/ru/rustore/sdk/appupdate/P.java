package ru.rustore.sdk.appupdate;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.rustore.sdk.appupdate.J;
import ru.rustore.sdk.appupdate.model.AppUpdateInfo;
import ru.rustore.sdk.appupdate.model.AppUpdateParams;
import ru.rustore.sdk.appupdate.model.AppUpdateParamsKt;
import ru.rustore.sdk.core.exception.RuStoreException;
import ru.rustore.sdk.core.util.ContextExtKt;
/* loaded from: classes6.dex */
public final class P implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1516a;
    public final C0801o b;
    public final String c;
    public final AppUpdateParams d;
    public final Function1<AppUpdateInfo, Unit> e;
    public final Function1<RuStoreException, Unit> f;

    /* loaded from: classes6.dex */
    public static final class a extends O {
        public final /* synthetic */ P b;

        public a(P p) {
            this.b = p;
        }
    }

    public P(Context context, C0801o appUpdateInfoMapper, String applicationId, AppUpdateParams appUpdateParams, C0812z onSuccess, A onError) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appUpdateInfoMapper, "appUpdateInfoMapper");
        Intrinsics.checkNotNullParameter(applicationId, "applicationId");
        Intrinsics.checkNotNullParameter(appUpdateParams, "appUpdateParams");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.f1516a = context;
        this.b = appUpdateInfoMapper;
        this.c = applicationId;
        this.d = appUpdateParams;
        this.e = onSuccess;
        this.f = onError;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName name, IBinder service) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(service, "service");
        try {
            J.a.a(service).a(this.c, AppUpdateParamsKt.toBundle(this.d), new a(this));
        } catch (Exception e) {
            Function1<RuStoreException, Unit> function1 = this.f;
            String message = e.getMessage();
            if (message == null) {
                message = "";
            }
            function1.invoke(new RuStoreException(message));
            ContextExtKt.unbindServiceSafely(this.f1516a, this);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f.invoke(new RuStoreException("onServiceDisconnected"));
        ContextExtKt.unbindServiceSafely(this.f1516a, this);
    }
}
