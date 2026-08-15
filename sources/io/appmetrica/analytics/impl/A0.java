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
/* loaded from: classes5.dex */
public final class A0 implements InterfaceC0556rb {
    public static volatile A0 e = null;
    public static volatile boolean f = false;
    public static volatile boolean g;

    /* renamed from: a  reason: collision with root package name */
    public final Context f449a;
    public final C0597t0 b;
    public final FutureTask c;
    public final InterfaceC0195db d;

    public A0(Context context) {
        this.f449a = context;
        C0597t0 c = C0575s4.l().c();
        this.b = c;
        this.d = c.a(context, C0575s4.l().g());
        this.c = new FutureTask(new Callable() { // from class: io.appmetrica.analytics.impl.A0$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return A0.this.p();
            }
        });
    }

    public static A0 a(Context context) {
        A0 a0;
        A0 a02 = e;
        if (a02 == null) {
            synchronized (A0.class) {
                a0 = e;
                if (a0 == null) {
                    a0 = new A0(context);
                    a0.j();
                    C0575s4.l().c.a().execute(new RunnableC0753z0(a0));
                    e = a0;
                }
            }
            return a0;
        }
        return a02;
    }

    public static void b(boolean z) {
        c().a(z, true);
    }

    public static void clearAppEnvironment() {
        c().clearAppEnvironment();
    }

    public static synchronized boolean k() {
        boolean z;
        synchronized (A0.class) {
            z = f;
        }
        return z;
    }

    public static boolean l() {
        return g;
    }

    public static synchronized boolean m() {
        boolean z;
        synchronized (A0.class) {
            A0 a0 = e;
            if (a0 != null && a0.c.isDone()) {
                z = a0.f().i() != null;
            }
        }
        return z;
    }

    public static synchronized void n() {
        synchronized (A0.class) {
            e = null;
            f = false;
            g = false;
        }
    }

    public static void putAppEnvironmentValue(String str, String str2) {
        c().putAppEnvironmentValue(str, str2);
    }

    public static synchronized void q() {
        synchronized (A0.class) {
            f = true;
        }
    }

    public static void r() {
        g = true;
    }

    public static A0 s() {
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
        C0575s4.l().c.a().execute(new RunnableC0728y1(this.f449a));
    }

    public final String e() {
        return f().e();
    }

    public final InterfaceC0220eb f() {
        try {
            return (InterfaceC0220eb) this.c.get();
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

    public final Lc i() {
        return f().i();
    }

    public final void j() {
        C0317i4 c0317i4 = C0575s4.l().c;
        Runnable runnable = new Runnable() { // from class: io.appmetrica.analytics.impl.A0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                A0.this.o();
            }
        };
        c0317i4.f1030a.getClass();
        new InterruptionSafeThread(runnable, "IAA-INIT_CORE-" + Zd.f873a.incrementAndGet()).start();
    }

    public final void o() {
        C0575s4.l().s.a(this.f449a);
        C0575s4.l().a(this.f449a).a();
        this.c.run();
    }

    public final InterfaceC0220eb p() {
        InterfaceC0220eb interfaceC0220eb;
        C0597t0 c0597t0 = this.b;
        Context context = this.f449a;
        InterfaceC0195db interfaceC0195db = this.d;
        synchronized (c0597t0) {
            if (c0597t0.d == null) {
                if (c0597t0.a(context)) {
                    c0597t0.d = new G0();
                } else {
                    c0597t0.d = new E0(context, interfaceC0195db);
                }
            }
            interfaceC0220eb = c0597t0.d;
        }
        return interfaceC0220eb;
    }

    public final void b(AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        f().a(appMetricaLibraryAdapterConfig);
        C0575s4.l().c.a().execute(new RunnableC0728y1(this.f449a));
    }

    public final InterfaceC0505pb c(ReporterConfig reporterConfig) {
        return f().c(reporterConfig);
    }

    public static InterfaceC0326id c() {
        if (m()) {
            return e.f();
        }
        return C0575s4.l().b;
    }

    public final C0581sa d() {
        return f().d();
    }

    public final C0653v4 b() {
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

    public static synchronized void a(A0 a0) {
        synchronized (A0.class) {
            e = a0;
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0556rb
    public final InterfaceC0531qb a() {
        return f().a();
    }
}
