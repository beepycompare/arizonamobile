package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaLibraryAdapterConfig;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes4.dex */
public final class Z {

    /* renamed from: a  reason: collision with root package name */
    public final C0620u0 f739a;
    public final Xk b;
    public final C0450n4 c;

    public Z(C0620u0 c0620u0, Xk xk, C0450n4 c0450n4) {
        this.f739a = c0620u0;
        this.b = xk;
        this.c = c0450n4;
    }

    public final void a(final Context context, final AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        boolean z;
        PublicLogger mainPublicOrAnonymousLogger = LoggerStorage.getMainPublicOrAnonymousLogger();
        this.f739a.getClass();
        synchronized (C0595t0.class) {
            z = C0595t0.f;
        }
        if (!z) {
            mainPublicOrAnonymousLogger.info("Session autotracking enabled", new Object[0]);
            this.b.a();
        }
        this.f739a.getClass();
        C0595t0 a2 = C0595t0.a(context);
        a2.d.a(null, a2);
        IHandlerExecutor a3 = this.c.a();
        ((U9) a3).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.Z$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Z.a(Z.this, context, appMetricaLibraryAdapterConfig);
            }
        });
        this.f739a.getClass();
        C0620u0.a();
    }

    public static final void a(Z z, Context context, AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        z.f739a.getClass();
        C0595t0 a2 = C0595t0.a(context);
        a2.f().a(appMetricaLibraryAdapterConfig);
        C0699x4.l().c.a().execute(new RunnableC0571s1(a2.f1059a));
    }
}
