package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaLibraryAdapterConfig;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.b0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0127b0 {

    /* renamed from: a  reason: collision with root package name */
    public final C0734z0 f889a;
    public final Xk b;
    public final S3 c;
    public final long d = TimeUnit.SECONDS.toMillis(10);

    public C0127b0(C0734z0 c0734z0, Xk xk, S3 s3) {
        this.f889a = c0734z0;
        this.b = xk;
        this.c = s3;
    }

    public final synchronized void a(final Context context, final AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        this.f889a.getClass();
        if (C0734z0.a()) {
            return;
        }
        LoggerStorage.getMainPublicOrAnonymousLogger().info("Session autotracking enabled", new Object[0]);
        this.b.a();
        this.f889a.getClass();
        C0709y0 a2 = C0709y0.a(context);
        a2.d.a(null, a2);
        IHandlerExecutor a3 = this.c.a();
        ((A9) a3).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.b0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0127b0.a(C0127b0.this, context, appMetricaLibraryAdapterConfig);
            }
        });
        this.f889a.getClass();
        C0734z0.b();
    }

    public static final void a(C0127b0 c0127b0, Context context, AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        c0127b0.f889a.getClass();
        C0709y0 a2 = C0709y0.a(context);
        a2.f().a(appMetricaLibraryAdapterConfig);
        C0157c4.l().c.a().execute(new RunnableC0685x1(a2.f1291a));
    }
}
