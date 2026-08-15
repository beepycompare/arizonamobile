package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaLibraryAdapterConfig;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.d0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0184d0 {

    /* renamed from: a  reason: collision with root package name */
    public final B0 f937a;
    public final Bl b;
    public final C0317i4 c;
    public final long d = TimeUnit.SECONDS.toMillis(10);

    public C0184d0(B0 b0, Bl bl, C0317i4 c0317i4) {
        this.f937a = b0;
        this.b = bl;
        this.c = c0317i4;
    }

    public final synchronized void a(final Context context, final AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        this.f937a.getClass();
        if (B0.a()) {
            return;
        }
        LoggerStorage.getMainPublicOrAnonymousLogger().info("Session autotracking enabled", new Object[0]);
        this.b.a();
        this.f937a.getClass();
        A0 a2 = A0.a(context);
        a2.d.a(null, a2);
        IHandlerExecutor a3 = this.c.a();
        ((U9) a3).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.d0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0184d0.a(C0184d0.this, context, appMetricaLibraryAdapterConfig);
            }
        });
        this.f937a.getClass();
        B0.b();
    }

    public static final void a(C0184d0 c0184d0, Context context, AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        c0184d0.f937a.getClass();
        A0 a2 = A0.a(context);
        a2.f().a(appMetricaLibraryAdapterConfig);
        C0575s4.l().c.a().execute(new RunnableC0728y1(a2.f449a));
    }
}
