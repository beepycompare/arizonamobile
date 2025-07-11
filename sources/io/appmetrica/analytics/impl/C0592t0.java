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
/* renamed from: io.appmetrica.analytics.impl.t0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0592t0 implements InterfaceC0429mb {
    public static volatile C0592t0 e = null;
    public static volatile boolean f = false;
    public static volatile boolean g;

    /* renamed from: a  reason: collision with root package name */
    public final Context f1053a;
    public final C0468o0 b;
    public final FutureTask c;
    public final Ua d;

    public C0592t0(Context context) {
        this.f1053a = context;
        C0468o0 c = C0696x4.l().c();
        this.b = c;
        this.d = c.a(context, C0696x4.l().g());
        this.c = new FutureTask(new Callable() { // from class: io.appmetrica.analytics.impl.t0$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return C0592t0.this.p();
            }
        });
    }

    public static C0592t0 a(Context context) {
        C0592t0 c0592t0;
        C0592t0 c0592t02 = e;
        if (c0592t02 == null) {
            synchronized (C0592t0.class) {
                c0592t0 = e;
                if (c0592t0 == null) {
                    c0592t0 = new C0592t0(context);
                    c0592t0.j();
                    C0696x4.l().c.a().execute(new RunnableC0567s0(c0592t0));
                    e = c0592t0;
                }
            }
            return c0592t0;
        }
        return c0592t02;
    }

    public static void b(boolean z) {
        c().b(z);
    }

    public static void clearAppEnvironment() {
        c().clearAppEnvironment();
    }

    public static synchronized boolean k() {
        boolean z;
        synchronized (C0592t0.class) {
            z = f;
        }
        return z;
    }

    public static boolean l() {
        return g;
    }

    public static synchronized boolean m() {
        boolean z;
        synchronized (C0592t0.class) {
            C0592t0 c0592t0 = e;
            if (c0592t0 != null && c0592t0.c.isDone()) {
                z = c0592t0.f().i() != null;
            }
        }
        return z;
    }

    public static synchronized void n() {
        synchronized (C0592t0.class) {
            e = null;
            f = false;
            g = false;
        }
    }

    public static void putAppEnvironmentValue(String str, String str2) {
        c().putAppEnvironmentValue(str, str2);
    }

    public static synchronized void q() {
        synchronized (C0592t0.class) {
            f = true;
        }
    }

    public static void r() {
        g = true;
    }

    public static C0592t0 s() {
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
        C0696x4.l().c.a().execute(new RunnableC0568s1(this.f1053a));
    }

    public final String e() {
        return f().e();
    }

    public final Va f() {
        try {
            return (Va) this.c.get();
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

    public final Cc i() {
        return f().i();
    }

    public final void j() {
        C0447n4 c0447n4 = C0696x4.l().c;
        Runnable runnable = new Runnable() { // from class: io.appmetrica.analytics.impl.t0$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C0592t0.this.o();
            }
        };
        c0447n4.f952a.getClass();
        new InterruptionSafeThread(runnable, "IAA-INIT_CORE-" + Md.f536a.incrementAndGet()).start();
    }

    public final void o() {
        C0696x4.l().r.a(this.f1053a);
        new C0546r4(this.f1053a).a(this.f1053a);
        C0696x4.l().a(this.f1053a).a();
        this.c.run();
    }

    public final Va p() {
        Va va;
        C0468o0 c0468o0 = this.b;
        Context context = this.f1053a;
        Ua ua = this.d;
        synchronized (c0468o0) {
            if (c0468o0.d == null) {
                if (c0468o0.a(context)) {
                    c0468o0.d = new C0742z0();
                } else {
                    c0468o0.d = new C0692x0(context, ua);
                }
            }
            va = c0468o0.d;
        }
        return va;
    }

    public final void b(AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        f().a(appMetricaLibraryAdapterConfig);
        C0696x4.l().c.a().execute(new RunnableC0568s1(this.f1053a));
    }

    public final InterfaceC0379kb c(ReporterConfig reporterConfig) {
        return f().c(reporterConfig);
    }

    public static InterfaceC0129ad c() {
        if (m()) {
            return e.f();
        }
        return C0696x4.l().b;
    }

    public final C0528qa d() {
        return f().d();
    }

    public final C0746z4 b() {
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

    public static synchronized void a(C0592t0 c0592t0) {
        synchronized (C0592t0.class) {
            e = c0592t0;
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0429mb
    public final InterfaceC0404lb a() {
        return f().a();
    }
}
