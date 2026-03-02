package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaLibraryAdapterConfig;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.b0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0131b0 {

    /* renamed from: a  reason: collision with root package name */
    public final C0737z0 f909a;
    public final Wk b;
    public final R3 c;
    public final long d = TimeUnit.SECONDS.toMillis(10);

    public C0131b0(C0737z0 c0737z0, Wk wk, R3 r3) {
        this.f909a = c0737z0;
        this.b = wk;
        this.c = r3;
    }

    public final synchronized void a(final Context context, final AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        this.f909a.getClass();
        if (C0737z0.a()) {
            return;
        }
        LoggerStorage.getMainPublicOrAnonymousLogger().info("Session autotracking enabled", new Object[0]);
        this.b.a();
        this.f909a.getClass();
        C0712y0 a2 = C0712y0.a(context);
        a2.d.a(null, a2);
        IHandlerExecutor a3 = this.c.a();
        ((C0746z9) a3).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.b0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0131b0.a(C0131b0.this, context, appMetricaLibraryAdapterConfig);
            }
        });
        this.f909a.getClass();
        C0737z0.b();
    }

    public static final void a(C0131b0 c0131b0, Context context, AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        c0131b0.f909a.getClass();
        C0712y0 a2 = C0712y0.a(context);
        a2.f().a(appMetricaLibraryAdapterConfig);
        C0135b4.l().c.a().execute(new RunnableC0663w1(a2.f1314a));
    }
}
