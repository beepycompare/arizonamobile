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
public final class C0712y0 implements Ta {
    public static volatile C0712y0 e = null;
    public static volatile boolean f = false;
    public static volatile boolean g;

    /* renamed from: a  reason: collision with root package name */
    public final Context f1314a;
    public final C0537r0 b;
    public final FutureTask c;
    public final Ba d;

    public C0712y0(Context context) {
        this.f1314a = context;
        C0537r0 c = C0135b4.l().c();
        this.b = c;
        this.d = c.a(context, C0135b4.l().g());
        this.c = new FutureTask(new Callable() { // from class: io.appmetrica.analytics.impl.y0$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return C0712y0.this.p();
            }
        });
    }

    public static C0712y0 a(Context context) {
        C0712y0 c0712y0;
        C0712y0 c0712y02 = e;
        if (c0712y02 == null) {
            synchronized (C0712y0.class) {
                c0712y0 = e;
                if (c0712y0 == null) {
                    c0712y0 = new C0712y0(context);
                    c0712y0.j();
                    C0135b4.l().c.a().execute(new RunnableC0687x0(c0712y0));
                    e = c0712y0;
                }
            }
            return c0712y0;
        }
        return c0712y02;
    }

    public static void b(boolean z) {
        c().a(z, true);
    }

    public static void clearAppEnvironment() {
        c().clearAppEnvironment();
    }

    public static synchronized boolean k() {
        boolean z;
        synchronized (C0712y0.class) {
            z = f;
        }
        return z;
    }

    public static boolean l() {
        return g;
    }

    public static synchronized boolean m() {
        boolean z;
        synchronized (C0712y0.class) {
            C0712y0 c0712y0 = e;
            if (c0712y0 != null && c0712y0.c.isDone()) {
                z = c0712y0.f().i() != null;
            }
        }
        return z;
    }

    public static synchronized void n() {
        synchronized (C0712y0.class) {
            e = null;
            f = false;
            g = false;
        }
    }

    public static void putAppEnvironmentValue(String str, String str2) {
        c().putAppEnvironmentValue(str, str2);
    }

    public static synchronized void q() {
        synchronized (C0712y0.class) {
            f = true;
        }
    }

    public static void r() {
        g = true;
    }

    public static C0712y0 s() {
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
        C0135b4.l().c.a().execute(new RunnableC0663w1(this.f1314a));
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

    public final C0349jc i() {
        return f().i();
    }

    public final void j() {
        R3 r3 = C0135b4.l().c;
        Runnable runnable = new Runnable() { // from class: io.appmetrica.analytics.impl.y0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0712y0.this.o();
            }
        };
        r3.f759a.getClass();
        new InterruptionSafeThread(runnable, "IAA-INIT_CORE-" + ThreadFactoryC0750zd.f1332a.incrementAndGet()).start();
    }

    public final void o() {
        C0135b4.l().r.a(this.f1314a);
        new V3(this.f1314a).a(this.f1314a);
        C0135b4.l().a(this.f1314a).a();
        this.c.run();
    }

    public final Ca p() {
        Ca ca;
        C0537r0 c0537r0 = this.b;
        Context context = this.f1314a;
        Ba ba = this.d;
        synchronized (c0537r0) {
            if (c0537r0.d == null) {
                if (c0537r0.a(context)) {
                    c0537r0.d = new E0();
                } else {
                    c0537r0.d = new C0(context, ba);
                }
            }
            ca = c0537r0.d;
        }
        return ca;
    }

    public final void b(AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        f().a(appMetricaLibraryAdapterConfig);
        C0135b4.l().c.a().execute(new RunnableC0663w1(this.f1314a));
    }

    public final Ra c(ReporterConfig reporterConfig) {
        return f().c(reporterConfig);
    }

    public static Hc c() {
        if (m()) {
            return e.f();
        }
        return C0135b4.l().b;
    }

    public final X9 d() {
        return f().d();
    }

    public final C0212e4 b() {
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

    public static synchronized void a(C0712y0 c0712y0) {
        synchronized (C0712y0.class) {
            e = c0712y0;
        }
    }

    @Override // io.appmetrica.analytics.impl.Ta
    public final Sa a() {
        return f().a();
    }
}
