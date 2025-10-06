package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaLibraryAdapterConfig;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.a0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0110a0 {

    /* renamed from: a  reason: collision with root package name */
    public final C0672w0 f782a;
    public final C0286gl b;
    public final C0527q4 c;
    public final long d = TimeUnit.SECONDS.toMillis(10);

    public C0110a0(C0672w0 c0672w0, C0286gl c0286gl, C0527q4 c0527q4) {
        this.f782a = c0672w0;
        this.b = c0286gl;
        this.c = c0527q4;
    }

    public final void a(final Context context, final AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        boolean z;
        PublicLogger mainPublicOrAnonymousLogger = LoggerStorage.getMainPublicOrAnonymousLogger();
        this.f782a.getClass();
        synchronized (C0647v0.class) {
            z = C0647v0.f;
        }
        if (!z) {
            mainPublicOrAnonymousLogger.info("Session autotracking enabled", new Object[0]);
            this.b.a();
        }
        this.f782a.getClass();
        C0647v0 a2 = C0647v0.a(context);
        a2.d.a(null, a2);
        IHandlerExecutor a3 = this.c.a();
        ((Z9) a3).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.a0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0110a0.a(C0110a0.this, context, appMetricaLibraryAdapterConfig);
            }
        });
        this.f782a.getClass();
        C0672w0.a();
    }

    public static final void a(C0110a0 c0110a0, Context context, AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        c0110a0.f782a.getClass();
        C0647v0 a2 = C0647v0.a(context);
        a2.f().a(appMetricaLibraryAdapterConfig);
        A4.l().c.a().execute(new RunnableC0623u1(a2.f1118a));
    }
}
