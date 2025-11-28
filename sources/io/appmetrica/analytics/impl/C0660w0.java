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
/* renamed from: io.appmetrica.analytics.impl.w0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0660w0 implements InterfaceC0113ab {
    public static volatile C0660w0 e = null;
    public static volatile boolean f = false;
    public static volatile boolean g;

    /* renamed from: a  reason: collision with root package name */
    public final Context f1177a;
    public final C0535r0 b;
    public final FutureTask c;
    public final Ia d;

    public C0660w0(Context context) {
        this.f1177a = context;
        C0535r0 c = C0338j4.l().c();
        this.b = c;
        this.d = c.a(context, C0338j4.l().g());
        this.c = new FutureTask(new Callable() { // from class: io.appmetrica.analytics.impl.w0$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return C0660w0.this.p();
            }
        });
    }

    public static C0660w0 a(Context context) {
        C0660w0 c0660w0;
        C0660w0 c0660w02 = e;
        if (c0660w02 == null) {
            synchronized (C0660w0.class) {
                c0660w0 = e;
                if (c0660w0 == null) {
                    c0660w0 = new C0660w0(context);
                    c0660w0.j();
                    C0338j4.l().c.a().execute(new RunnableC0635v0(c0660w0));
                    e = c0660w0;
                }
            }
            return c0660w0;
        }
        return c0660w02;
    }

    public static void b(boolean z) {
        c().a(z, true);
    }

    public static void clearAppEnvironment() {
        c().clearAppEnvironment();
    }

    public static synchronized boolean k() {
        boolean z;
        synchronized (C0660w0.class) {
            z = f;
        }
        return z;
    }

    public static boolean l() {
        return g;
    }

    public static synchronized boolean m() {
        boolean z;
        synchronized (C0660w0.class) {
            C0660w0 c0660w0 = e;
            if (c0660w0 != null && c0660w0.c.isDone()) {
                z = c0660w0.f().i() != null;
            }
        }
        return z;
    }

    public static synchronized void n() {
        synchronized (C0660w0.class) {
            e = null;
            f = false;
            g = false;
        }
    }

    public static void putAppEnvironmentValue(String str, String str2) {
        c().putAppEnvironmentValue(str, str2);
    }

    public static synchronized void q() {
        synchronized (C0660w0.class) {
            f = true;
        }
    }

    public static void r() {
        g = true;
    }

    public static C0660w0 s() {
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
        C0338j4.l().c.a().execute(new RunnableC0636v1(this.f1177a));
    }

    public final String e() {
        return f().e();
    }

    public final Ja f() {
        try {
            return (Ja) this.c.get();
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

    public final C0523qc i() {
        return f().i();
    }

    public final void j() {
        Z3 z3 = C0338j4.l().c;
        Runnable runnable = new Runnable() { // from class: io.appmetrica.analytics.impl.w0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0660w0.this.o();
            }
        };
        z3.f780a.getClass();
        new InterruptionSafeThread(runnable, "IAA-INIT_CORE-" + Gd.f490a.incrementAndGet()).start();
    }

    public final void o() {
        C0338j4.l().r.a(this.f1177a);
        new C0184d4(this.f1177a).a(this.f1177a);
        C0338j4.l().a(this.f1177a).a();
        this.c.run();
    }

    public final Ja p() {
        Ja ja;
        C0535r0 c0535r0 = this.b;
        Context context = this.f1177a;
        Ia ia = this.d;
        synchronized (c0535r0) {
            if (c0535r0.d == null) {
                if (c0535r0.a(context)) {
                    c0535r0.d = new C0();
                } else {
                    c0535r0.d = new A0(context, ia);
                }
            }
            ja = c0535r0.d;
        }
        return ja;
    }

    public final void b(AppMetricaLibraryAdapterConfig appMetricaLibraryAdapterConfig) {
        f().a(appMetricaLibraryAdapterConfig);
        C0338j4.l().c.a().execute(new RunnableC0636v1(this.f1177a));
    }

    public final Ya c(ReporterConfig reporterConfig) {
        return f().c(reporterConfig);
    }

    public static Oc c() {
        if (m()) {
            return e.f();
        }
        return C0338j4.l().b;
    }

    public final C0215ea d() {
        return f().d();
    }

    public final C0390l4 b() {
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

    public static synchronized void a(C0660w0 c0660w0) {
        synchronized (C0660w0.class) {
            e = c0660w0;
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0113ab
    public final Za a() {
        return f().a();
    }
}
