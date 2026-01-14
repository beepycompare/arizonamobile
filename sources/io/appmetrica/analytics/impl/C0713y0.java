package io.appmetrica.analytics.impl;

import android.content.Context;
import android.location.Location;
import io.appmetrica.analytics.AdvIdentifiersResult;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.AppMetricaLibraryAdapterConfig;
import io.appmetrica.analytics.DeferredDeeplinkListener;
import io.appmetrica.analytics.DeferredDeeplinkParametersListener;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.StartupParamsCallback;
import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* renamed from: io.appmetrica.analytics.impl.y0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0713y0 implements Ta {
    public static volatile C0713y0 e = null;
    public static volatile boolean f = false;
    public static volatile boolean g;

    /* renamed from: a  reason: collision with root package name */
    public final Context f1315a;
    public final C0538r0 b;
    public final FutureTask c;
    public final Ba d;

    public C0713y0(Context context) {
        this.f1315a = context;
        C0538r0 c = C0136b4.l().c();
        this.b = c;
        this.d = c.a(context, C0136b4.l().g());
        this.c = new FutureTask(new Callable() { // from class: io.appmetrica.analytics.impl.y0$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return C0713y0.this.p();
            }
        });
    }

    public static C0713y0 a(Context context) {
        C0713y0 c0713y0;
        C0713y0 c0713y02 = e;
        if (c0713y02 == null) {
            synchronized (C0713y0.class) {
                c0713y0 = e;
                if (c0713y0 == null) {
                    c0713y0 = new C0713y0(context);
                    c0713y0.j();
                    C0136b4.l().c.a().execute(new RunnableC0688x0(c0713y0));
                    e = c0713y0;
                }
            }
            return c0713y0;
        }
        return c0713y02;
    }

    public static void b(boolean z) {
        c().a(z, true);
    }

    public static void clearAppEnvironment() {
        c().clearAppEnvironment();
    }

    public static synchronized boolean k() {
        boolean z;
        synchronized (C0713y0.class) {
            z = f;
        }
        return z;
    }

    public static boolean l() {
        return g;
    }

    public static synchronized boolean m() {
        boolean z;
        synchronized (C0713y0.class) {
            C0713y0 c0713y0 = e;
            if (c0713y0 != null && c0713y0.c.isDone()) {
                z = c0713y0.f().i() != null;
            }
        }
        return z;
    }

    public static synchronized void n() {
        synchronized (C0713y0.class) {
            e = null;
            f = false;
            g = false;
        }
    }

    public static void putAppEnvironmentValue(String str, String str2) {
        c().putAppEnvironmentValue(str, str2);
    }

    public static synchronized void q() {
        synchronized (C0713y0.class) {
            f = true;
        }
    }

    public static void r() {
        g = true;
    }

    public static C0713y0 s() {
        return e;
    }

    public static void setDataSendingEnabled(boolean z) {
        c().setDataSendingEnabled(z);
    }

    public static void setUserProfileID(String str) {
        c().setUserProfileID(str);
    }

    public final void c(AppMetricaConfig appMetricaConfig) {
        this.d.a(appMetricaConfig, this);
    }

    public final void d(AppMetricaConfig appMetricaConfig) {
        f().b(appMetricaConfig);
        C0136b4.l().c.a().execute(new RunnableC0664w1(this.f1315a));
    }

    public final String e() {
        return f().e();
    }

    public final Ca f() {
        try {
            return (Ca) this.c.get();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public final Map<String, String> g() {
        return f().g();
    }

    public final AdvIdentifiersResult h() {
        return f().h();
    }

    public final C0350jc i() {
        return f().i();
    }

    public final void j() {
        R3 r3 = C0136b4.l().c;
        Runnable runnable = new Runnable() { // from class: io.appmetrica.analytics.impl.y0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0713y0.this.o();
            }
        };
        r3.f760a.getClass();
        new InterruptionSafeThread(runnable, "IAA-INIT_CORE-" + ThreadFactoryC0751zd.f1333a.incrementAndGet()).start();
    }

    public final void o() {
        C0136b4.l().r.a(this.f1315a);
        new V3(this.f1315a).a(this.f1315a);
        C0136b4.l().a(this.f1315a).a();
        this.c.run();
    }

    public final Ca p() {
        Ca ca;
        C0538r0 c0538r0 = this.b;
        Context context = this.f1315a;
        Ba ba = this.d;
        synchronized (c0538r0) {
            if (c0538r0.d == null) {
                if (c0538r0.a(context)) {
                    c0538r0.d = new E0();
                } else {
                    c0538r0.d = new C0(context, ba);
                }
            }
            ca = c0538r0.d;
        }
        return ca;
    }

    public final void b(AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        f().a(appMetricaLibraryAdapterConfig);
        C0136b4.l().c.a().execute(new RunnableC0664w1(this.f1315a));
    }

    public final Ra c(ReporterConfig reporterConfig) {
        return f().c(reporterConfig);
    }

    public static Hc c() {
        if (m()) {
            return e.f();
        }
        return C0136b4.l().b;
    }

    public final X9 d() {
        return f().d();
    }

    public final C0213e4 b() {
        return this.d.a();
    }

    public static void a(Location location) {
        c().a(location);
    }

    public static void a(boolean z) {
        c().a(z);
    }

    public static void a(String str, String str2) {
        c().a(str, str2);
    }

    public static void a(String str) {
        c().a(str);
    }

    public final void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        f().a(deferredDeeplinkParametersListener);
    }

    public final void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        f().a(deferredDeeplinkListener);
    }

    public final void a(ReporterConfig reporterConfig) {
        f().a(reporterConfig);
    }

    public final void a(StartupParamsCallback startupParamsCallback, List<String> list) {
        f().a(startupParamsCallback, list);
    }

    public static synchronized void a(C0713y0 c0713y0) {
        synchronized (C0713y0.class) {
            e = c0713y0;
        }
    }

    @Override // io.appmetrica.analytics.impl.Ta
    public final Sa a() {
        return f().a();
    }
}
