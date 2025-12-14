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
public final class C0709y0 implements Ua {
    public static volatile C0709y0 e = null;
    public static volatile boolean f = false;
    public static volatile boolean g;

    /* renamed from: a  reason: collision with root package name */
    public final Context f1305a;
    public final C0534r0 b;
    public final FutureTask c;
    public final Ca d;

    public C0709y0(Context context) {
        this.f1305a = context;
        C0534r0 c = C0157c4.l().c();
        this.b = c;
        this.d = c.a(context, C0157c4.l().g());
        this.c = new FutureTask(new Callable() { // from class: io.appmetrica.analytics.impl.y0$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return C0709y0.this.p();
            }
        });
    }

    public static C0709y0 a(Context context) {
        C0709y0 c0709y0;
        C0709y0 c0709y02 = e;
        if (c0709y02 == null) {
            synchronized (C0709y0.class) {
                c0709y0 = e;
                if (c0709y0 == null) {
                    c0709y0 = new C0709y0(context);
                    c0709y0.j();
                    C0157c4.l().c.a().execute(new RunnableC0684x0(c0709y0));
                    e = c0709y0;
                }
            }
            return c0709y0;
        }
        return c0709y02;
    }

    public static void b(boolean z) {
        c().a(z, true);
    }

    public static void clearAppEnvironment() {
        c().clearAppEnvironment();
    }

    public static synchronized boolean k() {
        boolean z;
        synchronized (C0709y0.class) {
            z = f;
        }
        return z;
    }

    public static boolean l() {
        return g;
    }

    public static synchronized boolean m() {
        boolean z;
        synchronized (C0709y0.class) {
            C0709y0 c0709y0 = e;
            if (c0709y0 != null && c0709y0.c.isDone()) {
                z = c0709y0.f().i() != null;
            }
        }
        return z;
    }

    public static synchronized void n() {
        synchronized (C0709y0.class) {
            e = null;
            f = false;
            g = false;
        }
    }

    public static void putAppEnvironmentValue(String str, String str2) {
        c().putAppEnvironmentValue(str, str2);
    }

    public static synchronized void q() {
        synchronized (C0709y0.class) {
            f = true;
        }
    }

    public static void r() {
        g = true;
    }

    public static C0709y0 s() {
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
        C0157c4.l().c.a().execute(new RunnableC0685x1(this.f1305a));
    }

    public final String e() {
        return f().e();
    }

    public final Da f() {
        try {
            return (Da) this.c.get();
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

    public final C0371kc i() {
        return f().i();
    }

    public final void j() {
        S3 s3 = C0157c4.l().c;
        Runnable runnable = new Runnable() { // from class: io.appmetrica.analytics.impl.y0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0709y0.this.o();
            }
        };
        s3.f768a.getClass();
        new InterruptionSafeThread(runnable, "IAA-INIT_CORE-" + Ad.f492a.incrementAndGet()).start();
    }

    public final void o() {
        C0157c4.l().r.a(this.f1305a);
        new W3(this.f1305a).a(this.f1305a);
        C0157c4.l().a(this.f1305a).a();
        this.c.run();
    }

    public final Da p() {
        Da da;
        C0534r0 c0534r0 = this.b;
        Context context = this.f1305a;
        Ca ca = this.d;
        synchronized (c0534r0) {
            if (c0534r0.d == null) {
                if (c0534r0.a(context)) {
                    c0534r0.d = new E0();
                } else {
                    c0534r0.d = new C0(context, ca);
                }
            }
            da = c0534r0.d;
        }
        return da;
    }

    public final void b(AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        f().a(appMetricaLibraryAdapterConfig);
        C0157c4.l().c.a().execute(new RunnableC0685x1(this.f1305a));
    }

    public final Sa c(ReporterConfig reporterConfig) {
        return f().c(reporterConfig);
    }

    public static Ic c() {
        if (m()) {
            return e.f();
        }
        return C0157c4.l().b;
    }

    public final Y9 d() {
        return f().d();
    }

    public final C0234f4 b() {
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

    public static synchronized void a(C0709y0 c0709y0) {
        synchronized (C0709y0.class) {
            e = c0709y0;
        }
    }

    @Override // io.appmetrica.analytics.impl.Ua
    public final Ta a() {
        return f().a();
    }
}
