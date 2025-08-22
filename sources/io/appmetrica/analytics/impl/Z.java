package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaLibraryAdapterConfig;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes4.dex */
public final class Z {

    /* renamed from: a  reason: collision with root package name */
    public final C0617u0 f749a;
    public final C0182cl b;
    public final C0447n4 c;

    public Z(C0617u0 c0617u0, C0182cl c0182cl, C0447n4 c0447n4) {
        this.f749a = c0617u0;
        this.b = c0182cl;
        this.c = c0447n4;
    }

    public final void a(final Context context, final AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        boolean z;
        PublicLogger mainPublicOrAnonymousLogger = LoggerStorage.getMainPublicOrAnonymousLogger();
        this.f749a.getClass();
        synchronized (C0592t0.class) {
            z = C0592t0.f;
        }
        if (!z) {
            mainPublicOrAnonymousLogger.info("Session autotracking enabled", new Object[0]);
            this.b.a();
        }
        this.f749a.getClass();
        C0592t0 a2 = C0592t0.a(context);
        a2.d.a(null, a2);
        IHandlerExecutor a3 = this.c.a();
        ((W9) a3).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.Z$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Z.a(Z.this, context, appMetricaLibraryAdapterConfig);
            }
        });
        this.f749a.getClass();
        C0617u0.a();
    }

    public static final void a(Z z, Context context, AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        z.f749a.getClass();
        C0592t0 a2 = C0592t0.a(context);
        a2.f().a(appMetricaLibraryAdapterConfig);
        C0696x4.l().c.a().execute(new RunnableC0568s1(a2.f1069a));
    }
}
