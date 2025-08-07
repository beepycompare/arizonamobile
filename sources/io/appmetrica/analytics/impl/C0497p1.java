package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.webkit.WebView;
import io.appmetrica.analytics.AdRevenue;
import io.appmetrica.analytics.AnrListener;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.DeferredDeeplinkListener;
import io.appmetrica.analytics.DeferredDeeplinkParametersListener;
import io.appmetrica.analytics.ExternalAttribution;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.Revenue;
import io.appmetrica.analytics.StartupParamsCallback;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.internal.IdentifiersResult;
import io.appmetrica.analytics.internal.js.AppMetricaInitializerJsInterface;
import io.appmetrica.analytics.internal.js.AppMetricaJsInterface;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.ModuleAdRevenueProcessor;
import io.appmetrica.analytics.profile.UserProfile;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.p1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0497p1 {

    /* renamed from: a  reason: collision with root package name */
    public final C0620u0 f994a;
    public final Do b;
    public final Bi c;
    public final Z7 d;
    public final C0318hl e;
    public final M2 f;
    public final C0269fn g;
    public final Xk h;

    public C0497p1(C0620u0 c0620u0, M2 m2, C0318hl c0318hl, Do r4, C0269fn c0269fn, Bi bi, Z7 z7, Xk xk) {
        this.f994a = c0620u0;
        this.b = r4;
        this.c = bi;
        this.d = z7;
        this.f = m2;
        this.g = c0269fn;
        this.e = c0318hl;
        this.h = xk;
    }

    public static IHandlerExecutor c() {
        return C0699x4.l().c.a();
    }

    public final void a(final Context context, final AppMetricaConfig appMetricaConfig) {
        M2 m2 = this.f;
        m2.f.a(context);
        m2.b.a(appMetricaConfig);
        C0269fn c0269fn = this.g;
        Context applicationContext = context.getApplicationContext();
        c0269fn.e.a(applicationContext);
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(appMetricaConfig.apiKey);
        if (((Boolean) WrapUtils.getOrDefault(appMetricaConfig.sessionsAutoTrackingEnabled, Boolean.TRUE)).booleanValue()) {
            orCreatePublicLogger.info("Session auto tracking enabled", new Object[0]);
            c0269fn.d.a();
        } else {
            orCreatePublicLogger.info("Session auto tracking disabled", new Object[0]);
        }
        c0269fn.f852a.getClass();
        C0595t0 a2 = C0595t0.a(applicationContext);
        a2.d.a(appMetricaConfig, a2);
        IHandlerExecutor c = c();
        ((U9) c).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.p1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0497p1.this.b(context, appMetricaConfig);
            }
        });
        this.f994a.getClass();
        synchronized (C0595t0.class) {
            C0595t0.f = true;
        }
    }

    public final String b() {
        this.f994a.getClass();
        C0595t0 c0595t0 = C0595t0.e;
        if (c0595t0 == null) {
            return null;
        }
        return c0595t0.f().e();
    }

    public final Ec d() {
        this.f994a.getClass();
        return C0595t0.e.f().i();
    }

    public final void e() {
        d().f416a.a(this.h.a());
    }

    public final void f() {
        this.f.f541a.a(null);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((U9) c).b.post(new R0(this));
    }

    public final void c(Activity activity) {
        this.f.f541a.a(null);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((U9) c).b.post(new RunnableC0170c1(this, activity));
    }

    public final void b(Context context, AppMetricaConfig appMetricaConfig) {
        C0620u0 c0620u0 = this.f994a;
        Context applicationContext = context.getApplicationContext();
        c0620u0.getClass();
        C0595t0 a2 = C0595t0.a(applicationContext);
        a2.f().b(this.d.a(appMetricaConfig));
        Context context2 = a2.f1059a;
        ((U9) C0699x4.l().c.a()).execute(new RunnableC0571s1(context2));
    }

    public final void e(String str) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((U9) c).b.post(new P0(this, str));
    }

    public final void d(String str) {
        M2 m2 = this.f;
        m2.f541a.a(null);
        m2.j.a(str);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((U9) c).b.post(new K0(this, str));
    }

    public C0497p1() {
        this(C0699x4.l().d(), new Do());
    }

    public final void c(String str, String str2) {
        M2 m2 = this.f;
        m2.f541a.a(null);
        m2.s.a(str);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((U9) c).b.post(new RunnableC0372k1(this, str, str2));
    }

    public C0497p1(C0620u0 c0620u0, Do r11) {
        this(c0620u0, new M2(c0620u0), new C0318hl(c0620u0), r11, new C0269fn(c0620u0, r11), Bi.a(), C0699x4.l().j(), C0699x4.l().o());
    }

    public final void d(String str, String str2) {
        M2 m2 = this.f;
        m2.f541a.a(null);
        if (m2.o.a(str).f975a) {
            this.g.getClass();
            IHandlerExecutor c = c();
            ((U9) c).b.post(new Z0(this, str, str2));
        }
    }

    public final void b(String str) {
        M2 m2 = this.f;
        m2.f541a.a(null);
        m2.s.a(str);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((U9) c).b.post(new RunnableC0347j1(this, str));
    }

    public final void c(boolean z) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((U9) c).b.post(new M0(this, z));
    }

    public final void b(Activity activity) {
        M2 m2 = this.f;
        m2.f541a.a(null);
        m2.c.a(activity);
        this.g.getClass();
        Intent a2 = C0269fn.a(activity);
        IHandlerExecutor c = c();
        ((U9) c).b.post(new H0(this, a2));
    }

    public final void c(String str) {
        if (this.e.a((Void) null).f975a && this.f.n.a(str).f975a) {
            this.g.getClass();
            IHandlerExecutor c = c();
            ((U9) c).b.post(new RunnableC0118a1(this, str));
        }
    }

    public final void b(boolean z) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((U9) c).b.post(new O0(this, z));
    }

    public final void a(Activity activity) {
        this.f.f541a.a(null);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((U9) c).b.post(new RunnableC0323i1(this, activity));
    }

    public final void b(String str, String str2) {
        this.f.l.a(str);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((U9) c).b.post(new X0(this, str, str2));
    }

    public final void a(Application application) {
        this.f.e.a(application);
        this.g.c.a(application);
        IHandlerExecutor c = c();
        ((U9) c).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.p1$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                C0497p1.this.e();
            }
        });
    }

    public final void b(final Object... objArr) {
        this.f.f541a.a(null);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((U9) c).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.p1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C0497p1.a(objArr);
            }
        });
    }

    public final void a(String str, Map<String, Object> map) {
        M2 m2 = this.f;
        m2.f541a.a(null);
        m2.s.a(str);
        this.g.getClass();
        List listFromMap = CollectionUtils.getListFromMap(map);
        IHandlerExecutor c = c();
        ((U9) c).b.post(new RunnableC0397l1(this, str, listFromMap));
    }

    public final void b(Context context) {
        this.f.f.a(context);
        this.g.e.a(context);
        this.f994a.getClass();
        C0595t0.a(context);
    }

    public final void a(String str, Throwable th) {
        M2 m2 = this.f;
        m2.f541a.a(null);
        m2.t.a(str);
        this.g.getClass();
        if (th == null) {
            th = new T1();
            th.fillInStackTrace();
        }
        IHandlerExecutor c = c();
        ((U9) c).b.post(new RunnableC0422m1(this, str, th));
    }

    public final void a(String str, String str2, Throwable th) {
        M2 m2 = this.f;
        m2.f541a.a(null);
        m2.u.a(str);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((U9) c).b.post(new RunnableC0447n1(this, str, str2, th));
    }

    public final void a(Throwable th) {
        M2 m2 = this.f;
        m2.f541a.a(null);
        m2.v.a(th);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((U9) c).b.post(new RunnableC0472o1(this, th));
    }

    public final void a(String str) {
        M2 m2 = this.f;
        m2.f541a.a(null);
        m2.i.a(str);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((U9) c).b.post(new I0(this, str));
    }

    public final void a(Intent intent) {
        M2 m2 = this.f;
        m2.f541a.a(null);
        m2.d.a(intent);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((U9) c).b.post(new J0(this, intent));
    }

    public final void a(Location location) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((U9) c).b.post(new L0(this, location));
    }

    public final void a(boolean z) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((U9) c).b.post(new N0(this, z));
    }

    public final void a(UserProfile userProfile) {
        M2 m2 = this.f;
        m2.f541a.a(null);
        m2.w.a(userProfile);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((U9) c).b.post(new Q0(this, userProfile));
    }

    public final void a(Revenue revenue) {
        M2 m2 = this.f;
        m2.f541a.a(null);
        m2.x.a(revenue);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((U9) c).b.post(new S0(this, revenue));
    }

    public final void a(AdRevenue adRevenue) {
        M2 m2 = this.f;
        m2.f541a.a(null);
        m2.y.a(adRevenue);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((U9) c).b.post(new T0(this, adRevenue));
    }

    public final void a(ECommerceEvent eCommerceEvent) {
        M2 m2 = this.f;
        m2.f541a.a(null);
        m2.z.a(eCommerceEvent);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((U9) c).b.post(new U0(this, eCommerceEvent));
    }

    public final void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        M2 m2 = this.f;
        m2.f541a.a(null);
        m2.g.a(deferredDeeplinkParametersListener);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((U9) c).b.post(new V0(this, deferredDeeplinkParametersListener));
    }

    public final void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        M2 m2 = this.f;
        m2.f541a.a(null);
        m2.g.a(deferredDeeplinkListener);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((U9) c).b.post(new W0(this, deferredDeeplinkListener));
    }

    public final InterfaceC0432mb a(Context context, String str) {
        M2 m2 = this.f;
        m2.f.a(context);
        m2.k.a(str);
        C0269fn c0269fn = this.g;
        c0269fn.e.a(context.getApplicationContext());
        return this.c.a(context.getApplicationContext(), str);
    }

    public final void a(Context context, ReporterConfig reporterConfig) {
        M2 m2 = this.f;
        m2.f.a(context);
        m2.h.a(reporterConfig);
        C0269fn c0269fn = this.g;
        c0269fn.e.a(context.getApplicationContext());
        Bi bi = this.c;
        Context applicationContext = context.getApplicationContext();
        if (((C0613ti) bi.f360a.get(reporterConfig.apiKey)) == null) {
            synchronized (bi.f360a) {
                if (((C0613ti) bi.f360a.get(reporterConfig.apiKey)) == null) {
                    String str = reporterConfig.apiKey;
                    IHandlerExecutor a2 = C0699x4.l().c.a();
                    bi.b.getClass();
                    if (C0595t0.e == null) {
                        ((U9) a2).b.post(new RunnableC0763zi(bi, applicationContext));
                    }
                    C0613ti c0613ti = new C0613ti(applicationContext.getApplicationContext(), str, new C0620u0());
                    bi.f360a.put(str, c0613ti);
                    c0613ti.a(reporterConfig);
                }
            }
        }
    }

    public final void a(WebView webView) {
        M2 m2 = this.f;
        m2.f541a.a(null);
        m2.m.a(webView);
        Do r0 = this.g.b;
        r0.getClass();
        try {
            if (webView.getSettings().getJavaScriptEnabled()) {
                webView.addJavascriptInterface(new AppMetricaJsInterface(this), "AppMetrica");
                webView.addJavascriptInterface(new AppMetricaInitializerJsInterface(this), "AppMetricaInitializer");
                Ao ao = new Ao();
                synchronized (r0) {
                    PublicLogger publicLogger = r0.b;
                    if (publicLogger == null) {
                        r0.f404a.add(ao);
                    } else {
                        ao.consume(publicLogger);
                    }
                }
            } else {
                r0.a(new Bo());
            }
        } catch (Throwable th) {
            r0.a(new Co(th));
        }
        IHandlerExecutor c = c();
        ((U9) c).b.post(new Y0(this));
    }

    public final IdentifiersResult a(Context context) {
        this.f.f.a(context);
        C0269fn c0269fn = this.g;
        Context applicationContext = context.getApplicationContext();
        c0269fn.e.a(applicationContext);
        c0269fn.f.a(applicationContext);
        return C0699x4.l().a(context.getApplicationContext()).a();
    }

    public final void a(String str, String str2) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((U9) c).b.post(new RunnableC0144b1(this, str, str2));
    }

    public final void a() {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((U9) c).b.post(new RunnableC0196d1(this));
    }

    public final void a(Context context, StartupParamsCallback startupParamsCallback, List<String> list) {
        M2 m2 = this.f;
        m2.f.a(context);
        m2.p.a(startupParamsCallback);
        C0269fn c0269fn = this.g;
        c0269fn.e.a(context.getApplicationContext());
        IHandlerExecutor c = c();
        ((U9) c).b.post(new RunnableC0221e1(this, context, startupParamsCallback, list));
    }

    public final void a(AnrListener anrListener) {
        M2 m2 = this.f;
        m2.f541a.a(null);
        m2.q.a(anrListener);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((U9) c).b.post(new RunnableC0247f1(this, anrListener));
    }

    public final void a(ExternalAttribution externalAttribution) {
        M2 m2 = this.f;
        m2.f541a.a(null);
        m2.r.a(externalAttribution);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((U9) c).b.post(new RunnableC0273g1(this, externalAttribution));
    }

    public static /* synthetic */ void a(Object[] objArr) {
        ModuleAdRevenueProcessor b = C0699x4.l().m().b();
        if (b != null) {
            b.process(objArr);
        }
    }

    public final void a(Map<Thread, StackTraceElement[]> map) {
        this.f.A.a(map);
        this.g.getClass();
        List listFromMap = CollectionUtils.getListFromMap(map);
        IHandlerExecutor c = c();
        ((U9) c).b.post(new RunnableC0298h1(this, listFromMap));
    }

    public static InterfaceC0206db a(C0497p1 c0497p1) {
        return c0497p1.d().f416a;
    }
}
