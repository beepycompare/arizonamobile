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
/* renamed from: io.appmetrica.analytics.impl.u1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0610u1 {

    /* renamed from: a  reason: collision with root package name */
    public final C0734z0 f1224a;
    public final Io b;
    public final C0503pi c;
    public final E7 d;
    public final C0328il e;
    public final B2 f;
    public final C0305hn g;
    public final Xk h;

    public C0610u1(C0734z0 c0734z0, B2 b2, C0328il c0328il, Io io2, C0305hn c0305hn, C0503pi c0503pi, E7 e7, Xk xk) {
        this.f1224a = c0734z0;
        this.b = io2;
        this.c = c0503pi;
        this.d = e7;
        this.f = b2;
        this.g = c0305hn;
        this.e = c0328il;
        this.h = xk;
    }

    public static IHandlerExecutor c() {
        return C0157c4.l().c.a();
    }

    public final void a(final Context context, final AppMetricaConfig appMetricaConfig) {
        B2 b2 = this.f;
        b2.f.a(context);
        b2.b.a(appMetricaConfig);
        C0305hn c0305hn = this.g;
        Context applicationContext = context.getApplicationContext();
        c0305hn.e.a(applicationContext);
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(appMetricaConfig.apiKey);
        if (((Boolean) WrapUtils.getOrDefault(appMetricaConfig.sessionsAutoTrackingEnabled, Boolean.TRUE)).booleanValue()) {
            orCreatePublicLogger.info("Session auto tracking enabled", new Object[0]);
            c0305hn.d.a();
        } else {
            orCreatePublicLogger.info("Session auto tracking disabled", new Object[0]);
        }
        c0305hn.f1012a.getClass();
        C0709y0 a2 = C0709y0.a(applicationContext);
        a2.d.a(appMetricaConfig, a2);
        IHandlerExecutor c = c();
        ((A9) c).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.u1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0610u1.this.b(context, appMetricaConfig);
            }
        });
        this.f1224a.getClass();
        C0734z0.b();
    }

    public final String b() {
        this.f1224a.getClass();
        C0709y0 c0709y0 = C0709y0.e;
        if (c0709y0 == null) {
            return null;
        }
        return c0709y0.f().e();
    }

    public final C0371kc d() {
        this.f1224a.getClass();
        return C0709y0.e.f().i();
    }

    public final void e() {
        d().f1058a.a(this.h.a());
    }

    public final void f() {
        this.f.f487a.a(null);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((A9) c).b.post(new W0(this));
    }

    public final void c(Activity activity) {
        this.f.f487a.a(null);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((A9) c).b.post(new RunnableC0283h1(this, activity));
    }

    public final void b(Context context, AppMetricaConfig appMetricaConfig) {
        C0734z0 c0734z0 = this.f1224a;
        Context applicationContext = context.getApplicationContext();
        c0734z0.getClass();
        C0709y0 a2 = C0709y0.a(applicationContext);
        a2.f().b(this.d.a(appMetricaConfig));
        Context context2 = a2.f1291a;
        ((A9) C0157c4.l().c.a()).execute(new RunnableC0685x1(context2));
    }

    public final void e(String str) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((A9) c).b.post(new U0(this, str));
    }

    public final void d(String str) {
        B2 b2 = this.f;
        b2.f487a.a(null);
        b2.j.a(str);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((A9) c).b.post(new P0(this, str));
    }

    public C0610u1() {
        this(C0157c4.l().d(), new Io());
    }

    public final void c(String str, String str2) {
        B2 b2 = this.f;
        b2.f487a.a(null);
        b2.s.a(str);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((A9) c).b.post(new RunnableC0486p1(this, str, str2));
    }

    public C0610u1(C0734z0 c0734z0, Io io2) {
        this(c0734z0, new B2(c0734z0), new C0328il(c0734z0), io2, new C0305hn(c0734z0, io2), C0503pi.a(), C0157c4.l().j(), C0157c4.l().o());
    }

    public final void d(String str, String str2) {
        B2 b2 = this.f;
        b2.f487a.a(null);
        if (b2.o.a(str).f1190a) {
            this.g.getClass();
            IHandlerExecutor c = c();
            ((A9) c).b.post(new RunnableC0205e1(this, str, str2));
        }
    }

    public final void b(String str) {
        B2 b2 = this.f;
        b2.f487a.a(null);
        b2.s.a(str);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((A9) c).b.post(new RunnableC0461o1(this, str));
    }

    public final void c(boolean z) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((A9) c).b.post(new R0(this, z));
    }

    public final void b(Activity activity) {
        B2 b2 = this.f;
        b2.f487a.a(null);
        b2.c.a(activity);
        this.g.getClass();
        Intent a2 = C0305hn.a(activity);
        IHandlerExecutor c = c();
        ((A9) c).b.post(new M0(this, a2));
    }

    public final void c(String str) {
        if (this.e.a((Void) null).f1190a && this.f.n.a(str).f1190a) {
            this.g.getClass();
            IHandlerExecutor c = c();
            ((A9) c).b.post(new RunnableC0231f1(this, str));
        }
    }

    public final void a(Activity activity) {
        this.f.f487a.a(null);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((A9) c).b.post(new RunnableC0436n1(this, activity));
    }

    public final void b(boolean z) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((A9) c).b.post(new T0(this, z));
    }

    public final void b(String str, String str2) {
        this.f.l.a(str);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((A9) c).b.post(new RunnableC0154c1(this, str, str2));
    }

    public final void a(Application application) {
        this.f.e.a(application);
        this.g.c.a(application);
        IHandlerExecutor c = c();
        ((A9) c).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.u1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C0610u1.this.e();
            }
        });
    }

    public final void b(final Object... objArr) {
        this.f.f487a.a(null);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((A9) c).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.u1$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                C0610u1.a(objArr);
            }
        });
    }

    public final void a(String str, Map<String, Object> map) {
        B2 b2 = this.f;
        b2.f487a.a(null);
        b2.s.a(str);
        this.g.getClass();
        List listFromMap = CollectionUtils.getListFromMap(map);
        IHandlerExecutor c = c();
        ((A9) c).b.post(new RunnableC0511q1(this, str, listFromMap));
    }

    public final void b(Context context) {
        this.f.f.a(context);
        this.g.e.a(context);
        this.f1224a.getClass();
        C0709y0.a(context);
    }

    public final void a(String str, Throwable th) {
        B2 b2 = this.f;
        b2.f487a.a(null);
        b2.t.a(str);
        this.g.getClass();
        if (th == null) {
            th = new O1();
            th.fillInStackTrace();
        }
        IHandlerExecutor c = c();
        ((A9) c).b.post(new RunnableC0535r1(this, str, th));
    }

    public final void a(String str, String str2, Throwable th) {
        B2 b2 = this.f;
        b2.f487a.a(null);
        b2.u.a(str);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((A9) c).b.post(new RunnableC0560s1(this, str, str2, th));
    }

    public final void a(Throwable th) {
        B2 b2 = this.f;
        b2.f487a.a(null);
        b2.v.a(th);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((A9) c).b.post(new RunnableC0585t1(this, th));
    }

    public final void a(String str) {
        B2 b2 = this.f;
        b2.f487a.a(null);
        b2.i.a(str);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((A9) c).b.post(new N0(this, str));
    }

    public final void a(Intent intent) {
        B2 b2 = this.f;
        b2.f487a.a(null);
        b2.d.a(intent);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((A9) c).b.post(new O0(this, intent));
    }

    public final void a(Location location) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((A9) c).b.post(new Q0(this, location));
    }

    public final void a(boolean z) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((A9) c).b.post(new S0(this, z));
    }

    public final void a(UserProfile userProfile) {
        B2 b2 = this.f;
        b2.f487a.a(null);
        b2.w.a(userProfile);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((A9) c).b.post(new V0(this, userProfile));
    }

    public final void a(Revenue revenue) {
        B2 b2 = this.f;
        b2.f487a.a(null);
        b2.x.a(revenue);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((A9) c).b.post(new X0(this, revenue));
    }

    public final void a(AdRevenue adRevenue) {
        B2 b2 = this.f;
        b2.f487a.a(null);
        b2.y.a(adRevenue);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((A9) c).b.post(new Y0(this, adRevenue));
    }

    public final void a(ECommerceEvent eCommerceEvent) {
        B2 b2 = this.f;
        b2.f487a.a(null);
        b2.z.a(eCommerceEvent);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((A9) c).b.post(new Z0(this, eCommerceEvent));
    }

    public final void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        B2 b2 = this.f;
        b2.f487a.a(null);
        b2.g.a(deferredDeeplinkParametersListener);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((A9) c).b.post(new RunnableC0102a1(this, deferredDeeplinkParametersListener));
    }

    public final void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        B2 b2 = this.f;
        b2.f487a.a(null);
        b2.g.a(deferredDeeplinkListener);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((A9) c).b.post(new RunnableC0128b1(this, deferredDeeplinkListener));
    }

    public final Sa a(Context context, String str) {
        B2 b2 = this.f;
        b2.f.a(context);
        b2.k.a(str);
        C0305hn c0305hn = this.g;
        c0305hn.e.a(context.getApplicationContext());
        return this.c.a(context.getApplicationContext(), str);
    }

    public final void a(Context context, ReporterConfig reporterConfig) {
        B2 b2 = this.f;
        b2.f.a(context);
        b2.h.a(reporterConfig);
        C0305hn c0305hn = this.g;
        c0305hn.e.a(context.getApplicationContext());
        C0503pi c0503pi = this.c;
        Context applicationContext = context.getApplicationContext();
        if (((C0300hi) c0503pi.f1153a.get(reporterConfig.apiKey)) == null) {
            synchronized (c0503pi.f1153a) {
                if (((C0300hi) c0503pi.f1153a.get(reporterConfig.apiKey)) == null) {
                    String str = reporterConfig.apiKey;
                    IHandlerExecutor a2 = C0157c4.l().c.a();
                    c0503pi.b.getClass();
                    if (C0709y0.e == null) {
                        ((A9) a2).b.post(new RunnableC0453ni(c0503pi, applicationContext));
                    }
                    C0300hi c0300hi = new C0300hi(applicationContext.getApplicationContext(), str, new C0734z0());
                    c0503pi.f1153a.put(str, c0300hi);
                    c0300hi.a(reporterConfig);
                }
            }
        }
    }

    public final void a(WebView webView) {
        B2 b2 = this.f;
        b2.f487a.a(null);
        b2.m.a(webView);
        Io io2 = this.g.b;
        io2.getClass();
        try {
            if (webView.getSettings().getJavaScriptEnabled()) {
                webView.addJavascriptInterface(new AppMetricaJsInterface(this), "AppMetrica");
                webView.addJavascriptInterface(new AppMetricaInitializerJsInterface(this), "AppMetricaInitializer");
                Fo fo = new Fo();
                synchronized (io2) {
                    PublicLogger publicLogger = io2.b;
                    if (publicLogger == null) {
                        io2.f613a.add(fo);
                    } else {
                        fo.consume(publicLogger);
                    }
                }
            } else {
                io2.a(new Go());
            }
        } catch (Throwable th) {
            io2.a(new Ho(th));
        }
        IHandlerExecutor c = c();
        ((A9) c).b.post(new RunnableC0180d1(this));
    }

    public final IdentifiersResult a(Context context) {
        this.f.f.a(context);
        C0305hn c0305hn = this.g;
        Context applicationContext = context.getApplicationContext();
        c0305hn.e.a(applicationContext);
        c0305hn.f.a(applicationContext);
        return C0157c4.l().a(context.getApplicationContext()).a();
    }

    public final void a(String str, String str2) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((A9) c).b.post(new RunnableC0257g1(this, str, str2));
    }

    public final void a() {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((A9) c).b.post(new RunnableC0309i1(this));
    }

    public final void a(Context context, StartupParamsCallback startupParamsCallback, List<String> list) {
        B2 b2 = this.f;
        b2.f.a(context);
        b2.p.a(startupParamsCallback);
        C0305hn c0305hn = this.g;
        c0305hn.e.a(context.getApplicationContext());
        IHandlerExecutor c = c();
        ((A9) c).b.post(new RunnableC0334j1(this, context, startupParamsCallback, list));
    }

    public final void a(AnrListener anrListener) {
        B2 b2 = this.f;
        b2.f487a.a(null);
        b2.q.a(anrListener);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((A9) c).b.post(new RunnableC0360k1(this, anrListener));
    }

    public final void a(ExternalAttribution externalAttribution) {
        B2 b2 = this.f;
        b2.f487a.a(null);
        b2.r.a(externalAttribution);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((A9) c).b.post(new RunnableC0386l1(this, externalAttribution));
    }

    public static /* synthetic */ void a(Object[] objArr) {
        ModuleAdRevenueProcessor b = C0157c4.l().m().b();
        if (b != null) {
            b.process(objArr);
        }
    }

    public final void a(Map<Thread, StackTraceElement[]> map) {
        this.f.A.a(map);
        this.g.getClass();
        List listFromMap = CollectionUtils.getListFromMap(map);
        IHandlerExecutor c = c();
        ((A9) c).b.post(new RunnableC0411m1(this, listFromMap));
    }

    public static Ja a(C0610u1 c0610u1) {
        return c0610u1.d().f1058a;
    }
}
