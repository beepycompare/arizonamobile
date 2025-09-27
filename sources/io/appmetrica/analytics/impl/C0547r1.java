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
/* renamed from: io.appmetrica.analytics.impl.r1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0547r1 {

    /* renamed from: a  reason: collision with root package name */
    public final C0671w0 f1059a;
    public final Mo b;
    public final Ki c;
    public final C0195d8 d;
    public final C0543ql e;
    public final P2 f;
    public final C0494on g;
    public final C0285gl h;

    public C0547r1(C0671w0 c0671w0, P2 p2, C0543ql c0543ql, Mo mo, C0494on c0494on, Ki ki, C0195d8 c0195d8, C0285gl c0285gl) {
        this.f1059a = c0671w0;
        this.b = mo;
        this.c = ki;
        this.d = c0195d8;
        this.f = p2;
        this.g = c0494on;
        this.e = c0543ql;
        this.h = c0285gl;
    }

    public static IHandlerExecutor c() {
        return A4.l().c.a();
    }

    public final void a(final Context context, final AppMetricaConfig appMetricaConfig) {
        P2 p2 = this.f;
        p2.f.a(context);
        p2.b.a(appMetricaConfig);
        C0494on c0494on = this.g;
        Context applicationContext = context.getApplicationContext();
        c0494on.e.a(applicationContext);
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(appMetricaConfig.apiKey);
        if (((Boolean) WrapUtils.getOrDefault(appMetricaConfig.sessionsAutoTrackingEnabled, Boolean.TRUE)).booleanValue()) {
            orCreatePublicLogger.info("Session auto tracking enabled", new Object[0]);
            c0494on.d.a();
        } else {
            orCreatePublicLogger.info("Session auto tracking disabled", new Object[0]);
        }
        c0494on.f1026a.getClass();
        C0646v0 a2 = C0646v0.a(applicationContext);
        a2.d.a(appMetricaConfig, a2);
        IHandlerExecutor c = c();
        ((Z9) c).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.r1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C0547r1.this.b(context, appMetricaConfig);
            }
        });
        this.f1059a.getClass();
        synchronized (C0646v0.class) {
            C0646v0.f = true;
        }
    }

    public final String b() {
        this.f1059a.getClass();
        C0646v0 c0646v0 = C0646v0.e;
        if (c0646v0 == null) {
            return null;
        }
        return c0646v0.f().e();
    }

    public final Jc d() {
        this.f1059a.getClass();
        return C0646v0.e.f().i();
    }

    public final void e() {
        d().f517a.a(this.h.a());
    }

    public final void f() {
        this.f.f619a.a(null);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((Z9) c).b.post(new T0(this));
    }

    public final void c(Activity activity) {
        this.f.f619a.a(null);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((Z9) c).b.post(new RunnableC0213e1(this, activity));
    }

    public final void b(Context context, AppMetricaConfig appMetricaConfig) {
        C0671w0 c0671w0 = this.f1059a;
        Context applicationContext = context.getApplicationContext();
        c0671w0.getClass();
        C0646v0 a2 = C0646v0.a(applicationContext);
        a2.f().b(this.d.a(appMetricaConfig));
        Context context2 = a2.f1118a;
        ((Z9) A4.l().c.a()).execute(new RunnableC0622u1(context2));
    }

    public final void e(String str) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((Z9) c).b.post(new R0(this, str));
    }

    public final void d(String str) {
        P2 p2 = this.f;
        p2.f619a.a(null);
        p2.j.a(str);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((Z9) c).b.post(new M0(this, str));
    }

    public C0547r1() {
        this(A4.l().d(), new Mo());
    }

    public final void c(String str, String str2) {
        P2 p2 = this.f;
        p2.f619a.a(null);
        p2.s.a(str);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((Z9) c).b.post(new RunnableC0420m1(this, str, str2));
    }

    public C0547r1(C0671w0 c0671w0, Mo mo) {
        this(c0671w0, new P2(c0671w0), new C0543ql(c0671w0), mo, new C0494on(c0671w0, mo), Ki.a(), A4.l().j(), A4.l().o());
    }

    public final void d(String str, String str2) {
        P2 p2 = this.f;
        p2.f619a.a(null);
        if (p2.o.a(str).f1146a) {
            this.g.getClass();
            IHandlerExecutor c = c();
            ((Z9) c).b.post(new RunnableC0136b1(this, str, str2));
        }
    }

    public final void b(String str) {
        P2 p2 = this.f;
        p2.f619a.a(null);
        p2.s.a(str);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((Z9) c).b.post(new RunnableC0394l1(this, str));
    }

    public final void c(boolean z) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((Z9) c).b.post(new O0(this, z));
    }

    public final void b(Activity activity) {
        P2 p2 = this.f;
        p2.f619a.a(null);
        p2.c.a(activity);
        this.g.getClass();
        Intent a2 = C0494on.a(activity);
        IHandlerExecutor c = c();
        ((Z9) c).b.post(new J0(this, a2));
    }

    public final void c(String str) {
        if (this.e.a((Void) null).f1146a && this.f.n.a(str).f1146a) {
            this.g.getClass();
            IHandlerExecutor c = c();
            ((Z9) c).b.post(new RunnableC0162c1(this, str));
        }
    }

    public final void b(boolean z) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((Z9) c).b.post(new Q0(this, z));
    }

    public final void a(Activity activity) {
        this.f.f619a.a(null);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((Z9) c).b.post(new RunnableC0368k1(this, activity));
    }

    public final void b(String str, String str2) {
        this.f.l.a(str);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((Z9) c).b.post(new Z0(this, str, str2));
    }

    public final void a(Application application) {
        this.f.e.a(application);
        this.g.c.a(application);
        IHandlerExecutor c = c();
        ((Z9) c).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.r1$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                C0547r1.this.e();
            }
        });
    }

    public final void b(final Object... objArr) {
        this.f.f619a.a(null);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((Z9) c).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.r1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0547r1.a(objArr);
            }
        });
    }

    public final void a(String str, Map<String, Object> map) {
        P2 p2 = this.f;
        p2.f619a.a(null);
        p2.s.a(str);
        this.g.getClass();
        List listFromMap = CollectionUtils.getListFromMap(map);
        IHandlerExecutor c = c();
        ((Z9) c).b.post(new RunnableC0446n1(this, str, listFromMap));
    }

    public final void b(Context context) {
        this.f.f.a(context);
        this.g.e.a(context);
        this.f1059a.getClass();
        C0646v0.a(context);
    }

    public final void a(String str, Throwable th) {
        P2 p2 = this.f;
        p2.f619a.a(null);
        p2.t.a(str);
        this.g.getClass();
        if (th == null) {
            th = new V1();
            th.fillInStackTrace();
        }
        IHandlerExecutor c = c();
        ((Z9) c).b.post(new RunnableC0472o1(this, str, th));
    }

    public final void a(String str, String str2, Throwable th) {
        P2 p2 = this.f;
        p2.f619a.a(null);
        p2.u.a(str);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((Z9) c).b.post(new RunnableC0498p1(this, str, str2, th));
    }

    public final void a(Throwable th) {
        P2 p2 = this.f;
        p2.f619a.a(null);
        p2.v.a(th);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((Z9) c).b.post(new RunnableC0523q1(this, th));
    }

    public final void a(String str) {
        P2 p2 = this.f;
        p2.f619a.a(null);
        p2.i.a(str);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((Z9) c).b.post(new K0(this, str));
    }

    public final void a(Intent intent) {
        P2 p2 = this.f;
        p2.f619a.a(null);
        p2.d.a(intent);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((Z9) c).b.post(new L0(this, intent));
    }

    public final void a(Location location) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((Z9) c).b.post(new N0(this, location));
    }

    public final void a(boolean z) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((Z9) c).b.post(new P0(this, z));
    }

    public final void a(UserProfile userProfile) {
        P2 p2 = this.f;
        p2.f619a.a(null);
        p2.w.a(userProfile);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((Z9) c).b.post(new S0(this, userProfile));
    }

    public final void a(Revenue revenue) {
        P2 p2 = this.f;
        p2.f619a.a(null);
        p2.x.a(revenue);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((Z9) c).b.post(new U0(this, revenue));
    }

    public final void a(AdRevenue adRevenue) {
        P2 p2 = this.f;
        p2.f619a.a(null);
        p2.y.a(adRevenue);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((Z9) c).b.post(new V0(this, adRevenue));
    }

    public final void a(ECommerceEvent eCommerceEvent) {
        P2 p2 = this.f;
        p2.f619a.a(null);
        p2.z.a(eCommerceEvent);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((Z9) c).b.post(new W0(this, eCommerceEvent));
    }

    public final void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        P2 p2 = this.f;
        p2.f619a.a(null);
        p2.g.a(deferredDeeplinkParametersListener);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((Z9) c).b.post(new X0(this, deferredDeeplinkParametersListener));
    }

    public final void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        P2 p2 = this.f;
        p2.f619a.a(null);
        p2.g.a(deferredDeeplinkListener);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((Z9) c).b.post(new Y0(this, deferredDeeplinkListener));
    }

    public final InterfaceC0557rb a(Context context, String str) {
        P2 p2 = this.f;
        p2.f.a(context);
        p2.k.a(str);
        C0494on c0494on = this.g;
        c0494on.e.a(context.getApplicationContext());
        return this.c.a(context.getApplicationContext(), str);
    }

    public final void a(Context context, ReporterConfig reporterConfig) {
        P2 p2 = this.f;
        p2.f.a(context);
        p2.h.a(reporterConfig);
        C0494on c0494on = this.g;
        c0494on.e.a(context.getApplicationContext());
        Ki ki = this.c;
        Context applicationContext = context.getApplicationContext();
        if (((Ci) ki.f542a.get(reporterConfig.apiKey)) == null) {
            synchronized (ki.f542a) {
                if (((Ci) ki.f542a.get(reporterConfig.apiKey)) == null) {
                    String str = reporterConfig.apiKey;
                    IHandlerExecutor a2 = A4.l().c.a();
                    ki.b.getClass();
                    if (C0646v0.e == null) {
                        ((Z9) a2).b.post(new Ii(ki, applicationContext));
                    }
                    Ci ci = new Ci(applicationContext.getApplicationContext(), str, new C0671w0());
                    ki.f542a.put(str, ci);
                    ci.a(reporterConfig);
                }
            }
        }
    }

    public final void a(WebView webView) {
        P2 p2 = this.f;
        p2.f619a.a(null);
        p2.m.a(webView);
        Mo mo = this.g.b;
        mo.getClass();
        try {
            if (webView.getSettings().getJavaScriptEnabled()) {
                webView.addJavascriptInterface(new AppMetricaJsInterface(this), "AppMetrica");
                webView.addJavascriptInterface(new AppMetricaInitializerJsInterface(this), "AppMetricaInitializer");
                Jo jo = new Jo();
                synchronized (mo) {
                    PublicLogger publicLogger = mo.b;
                    if (publicLogger == null) {
                        mo.f585a.add(jo);
                    } else {
                        jo.consume(publicLogger);
                    }
                }
            } else {
                mo.a(new Ko());
            }
        } catch (Throwable th) {
            mo.a(new Lo(th));
        }
        IHandlerExecutor c = c();
        ((Z9) c).b.post(new RunnableC0110a1(this));
    }

    public final IdentifiersResult a(Context context) {
        this.f.f.a(context);
        C0494on c0494on = this.g;
        Context applicationContext = context.getApplicationContext();
        c0494on.e.a(applicationContext);
        c0494on.f.a(applicationContext);
        return A4.l().a(context.getApplicationContext()).a();
    }

    public final void a(String str, String str2) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((Z9) c).b.post(new RunnableC0188d1(this, str, str2));
    }

    public final void a() {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((Z9) c).b.post(new RunnableC0239f1(this));
    }

    public final void a(Context context, StartupParamsCallback startupParamsCallback, List<String> list) {
        P2 p2 = this.f;
        p2.f.a(context);
        p2.p.a(startupParamsCallback);
        C0494on c0494on = this.g;
        c0494on.e.a(context.getApplicationContext());
        IHandlerExecutor c = c();
        ((Z9) c).b.post(new RunnableC0265g1(this, context, startupParamsCallback, list));
    }

    public final void a(AnrListener anrListener) {
        P2 p2 = this.f;
        p2.f619a.a(null);
        p2.q.a(anrListener);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((Z9) c).b.post(new RunnableC0291h1(this, anrListener));
    }

    public final void a(ExternalAttribution externalAttribution) {
        P2 p2 = this.f;
        p2.f619a.a(null);
        p2.r.a(externalAttribution);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((Z9) c).b.post(new RunnableC0317i1(this, externalAttribution));
    }

    public static /* synthetic */ void a(Object[] objArr) {
        ModuleAdRevenueProcessor b = A4.l().m().b();
        if (b != null) {
            b.process(objArr);
        }
    }

    public final void a(Map<Thread, StackTraceElement[]> map) {
        this.f.A.a(map);
        this.g.getClass();
        List listFromMap = CollectionUtils.getListFromMap(map);
        IHandlerExecutor c = c();
        ((Z9) c).b.post(new RunnableC0342j1(this, listFromMap));
    }

    public static InterfaceC0327ib a(C0547r1 c0547r1) {
        return c0547r1.d().f517a;
    }
}
