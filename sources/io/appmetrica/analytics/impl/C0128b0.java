package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaLibraryAdapterConfig;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.b0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0128b0 {

    /* renamed from: a  reason: collision with root package name */
    public final C0735z0 f806a;
    public final Xk b;
    public final S3 c;
    public final long d = TimeUnit.SECONDS.toMillis(10);

    public C0128b0(C0735z0 c0735z0, Xk xk, S3 s3) {
        this.f806a = c0735z0;
        this.b = xk;
        this.c = s3;
    }

    public final synchronized void a(final Context context, final AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        this.f806a.getClass();
        if (C0735z0.a()) {
            return;
        }
        LoggerStorage.getMainPublicOrAnonymousLogger().info("Session autotracking enabled", new Object[0]);
        this.b.a();
        this.f806a.getClass();
        C0710y0 a2 = C0710y0.a(context);
        a2.d.a(null, a2);
        IHandlerExecutor a3 = this.c.a();
        ((A9) a3).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.b0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0128b0.a(C0128b0.this, context, appMetricaLibraryAdapterConfig);
            }
        });
        this.f806a.getClass();
        C0735z0.b();
    }

    public static final void a(C0128b0 c0128b0, Context context, AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        c0128b0.f806a.getClass();
        C0710y0 a2 = C0710y0.a(context);
        a2.f().a(appMetricaLibraryAdapterConfig);
        C0158c4.l().c.a().execute(new RunnableC0686x1(a2.f1208a));
    }
}
