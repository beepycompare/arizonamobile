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
    public final C0685x0 f808a;
    public final C0149bl b;
    public final Z3 c;
    public final long d = TimeUnit.SECONDS.toMillis(10);

    public C0128b0(C0685x0 c0685x0, C0149bl c0149bl, Z3 z3) {
        this.f808a = c0685x0;
        this.b = c0149bl;
        this.c = z3;
    }

    public final synchronized void a(final Context context, final AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        this.f808a.getClass();
        if (C0685x0.a()) {
            return;
        }
        LoggerStorage.getMainPublicOrAnonymousLogger().info("Session autotracking enabled", new Object[0]);
        this.b.a();
        this.f808a.getClass();
        C0660w0 a2 = C0660w0.a(context);
        a2.d.a(null, a2);
        IHandlerExecutor a3 = this.c.a();
        ((G9) a3).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.b0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0128b0.a(C0128b0.this, context, appMetricaLibraryAdapterConfig);
            }
        });
        this.f808a.getClass();
        C0685x0.b();
    }

    public static final void a(C0128b0 c0128b0, Context context, AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        c0128b0.f808a.getClass();
        C0660w0 a2 = C0660w0.a(context);
        a2.f().a(appMetricaLibraryAdapterConfig);
        C0338j4.l().c.a().execute(new RunnableC0636v1(a2.f1177a));
    }
}
