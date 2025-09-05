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
/* renamed from: io.appmetrica.analytics.impl.v0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0646v0 implements InterfaceC0607tb {
    public static volatile C0646v0 e = null;
    public static volatile boolean f = false;
    public static volatile boolean g;

    /* renamed from: a  reason: collision with root package name */
    public final Context f1113a;
    public final C0522q0 b;
    public final FutureTask c;
    public final InterfaceC0146bb d;

    public C0646v0(Context context) {
        this.f1113a = context;
        C0522q0 c = A4.l().c();
        this.b = c;
        this.d = c.a(context, A4.l().g());
        this.c = new FutureTask(new Callable() { // from class: io.appmetrica.analytics.impl.v0$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return C0646v0.this.p();
            }
        });
    }

    public static C0646v0 a(Context context) {
        C0646v0 c0646v0;
        C0646v0 c0646v02 = e;
        if (c0646v02 == null) {
            synchronized (C0646v0.class) {
                c0646v0 = e;
                if (c0646v0 == null) {
                    c0646v0 = new C0646v0(context);
                    c0646v0.j();
                    A4.l().c.a().execute(new RunnableC0621u0(c0646v0));
                    e = c0646v0;
                }
            }
            return c0646v0;
        }
        return c0646v02;
    }

    public static void b(boolean z) {
        c().b(z);
    }

    public static void clearAppEnvironment() {
        c().clearAppEnvironment();
    }

    public static synchronized boolean k() {
        boolean z;
        synchronized (C0646v0.class) {
            z = f;
        }
        return z;
    }

    public static boolean l() {
        return g;
    }

    public static synchronized boolean m() {
        boolean z;
        synchronized (C0646v0.class) {
            C0646v0 c0646v0 = e;
            if (c0646v0 != null && c0646v0.c.isDone()) {
                z = c0646v0.f().i() != null;
            }
        }
        return z;
    }

    public static synchronized void n() {
        synchronized (C0646v0.class) {
            e = null;
            f = false;
            g = false;
        }
    }

    public static void putAppEnvironmentValue(String str, String str2) {
        c().putAppEnvironmentValue(str, str2);
    }

    public static synchronized void q() {
        synchronized (C0646v0.class) {
            f = true;
        }
    }

    public static void r() {
        g = true;
    }

    public static C0646v0 s() {
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
        A4.l().c.a().execute(new RunnableC0622u1(this.f1113a));
    }

    public final String e() {
        return f().e();
    }

    public final InterfaceC0172cb f() {
        try {
            return (InterfaceC0172cb) this.c.get();
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

    public final Jc i() {
        return f().i();
    }

    public final void j() {
        C0526q4 c0526q4 = A4.l().c;
        Runnable runnable = new Runnable() { // from class: io.appmetrica.analytics.impl.v0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0646v0.this.o();
            }
        };
        c0526q4.f1041a.getClass();
        new InterruptionSafeThread(runnable, "IAA-INIT_CORE-" + Ud.f695a.incrementAndGet()).start();
    }

    public final void o() {
        A4.l().r.a(this.f1113a);
        new C0625u4(this.f1113a).a(this.f1113a);
        A4.l().a(this.f1113a).a();
        this.c.run();
    }

    public final InterfaceC0172cb p() {
        InterfaceC0172cb interfaceC0172cb;
        C0522q0 c0522q0 = this.b;
        Context context = this.f1113a;
        InterfaceC0146bb interfaceC0146bb = this.d;
        synchronized (c0522q0) {
            if (c0522q0.d == null) {
                if (c0522q0.a(context)) {
                    c0522q0.d = new B0();
                } else {
                    c0522q0.d = new C0746z0(context, interfaceC0146bb);
                }
            }
            interfaceC0172cb = c0522q0.d;
        }
        return interfaceC0172cb;
    }

    public final void b(AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        f().a(appMetricaLibraryAdapterConfig);
        A4.l().c.a().execute(new RunnableC0622u1(this.f1113a));
    }

    public final InterfaceC0557rb c(ReporterConfig reporterConfig) {
        return f().c(reporterConfig);
    }

    public static InterfaceC0303hd c() {
        if (m()) {
            return e.f();
        }
        return A4.l().b;
    }

    public final C0706xa d() {
        return f().d();
    }

    public final C4 b() {
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

    public static synchronized void a(C0646v0 c0646v0) {
        synchronized (C0646v0.class) {
            e = c0646v0;
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0607tb
    public final InterfaceC0582sb a() {
        return f().a();
    }
}
