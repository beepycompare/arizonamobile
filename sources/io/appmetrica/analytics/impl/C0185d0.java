package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaLibraryAdapterConfig;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.d0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0185d0 {

    /* renamed from: a  reason: collision with root package name */
    public final B0 f934a;
    public final Bl b;
    public final C0318i4 c;
    public final long d = TimeUnit.SECONDS.toMillis(10);

    public C0185d0(B0 b0, Bl bl, C0318i4 c0318i4) {
        this.f934a = b0;
        this.b = bl;
        this.c = c0318i4;
    }

    public final synchronized void a(final Context context, final AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        this.f934a.getClass();
        if (B0.a()) {
            return;
        }
        LoggerStorage.getMainPublicOrAnonymousLogger().info("Session autotracking enabled", new Object[0]);
        this.b.a();
        this.f934a.getClass();
        A0 a2 = A0.a(context);
        a2.d.a(null, a2);
        IHandlerExecutor a3 = this.c.a();
        ((U9) a3).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.d0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0185d0.a(C0185d0.this, context, appMetricaLibraryAdapterConfig);
            }
        });
        this.f934a.getClass();
        B0.b();
    }

    public static final void a(C0185d0 c0185d0, Context context, AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        c0185d0.f934a.getClass();
        A0 a2 = A0.a(context);
        a2.f().a(appMetricaLibraryAdapterConfig);
        C0576s4.l().c.a().execute(new RunnableC0729y1(a2.f446a));
    }
}
