package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaLibraryAdapterConfig;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes4.dex */
public final class Z {

    /* renamed from: a  reason: collision with root package name */
    public final C0625u0 f727a;
    public final Uk b;
    public final C0455n4 c;

    public Z(C0625u0 c0625u0, Uk uk, C0455n4 c0455n4) {
        this.f727a = c0625u0;
        this.b = uk;
        this.c = c0455n4;
    }

    public final void a(final Context context, final AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        boolean z;
        PublicLogger mainPublicOrAnonymousLogger = LoggerStorage.getMainPublicOrAnonymousLogger();
        this.f727a.getClass();
        synchronized (C0600t0.class) {
            z = C0600t0.f;
        }
        if (!z) {
            mainPublicOrAnonymousLogger.info("Session autotracking enabled", new Object[0]);
            this.b.a();
        }
        this.f727a.getClass();
        C0600t0 a2 = C0600t0.a(context);
        a2.d.a(null, a2);
        IHandlerExecutor a3 = this.c.a();
        ((S9) a3).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.Z$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Z.a(Z.this, context, appMetricaLibraryAdapterConfig);
            }
        });
        this.f727a.getClass();
        C0625u0.a();
    }

    public static final void a(Z z, Context context, AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        z.f727a.getClass();
        C0600t0 a2 = C0600t0.a(context);
        a2.f().a(appMetricaLibraryAdapterConfig);
        C0704x4.l().c.a().execute(new RunnableC0576s1(a2.f1052a));
    }
}
