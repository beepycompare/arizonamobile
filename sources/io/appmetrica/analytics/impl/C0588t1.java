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
/* renamed from: io.appmetrica.analytics.impl.t1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0588t1 {

    /* renamed from: a  reason: collision with root package name */
    public final C0737z0 f1233a;
    public final Ho b;
    public final C0481oi c;
    public final D7 d;
    public final C0307hl e;
    public final A2 f;
    public final C0283gn g;
    public final Wk h;

    public C0588t1(C0737z0 c0737z0, A2 a2, C0307hl c0307hl, Ho ho, C0283gn c0283gn, C0481oi c0481oi, D7 d7, Wk wk) {
        this.f1233a = c0737z0;
        this.b = ho;
        this.c = c0481oi;
        this.d = d7;
        this.f = a2;
        this.g = c0283gn;
        this.e = c0307hl;
        this.h = wk;
    }

    public static IHandlerExecutor c() {
        return C0135b4.l().c.a();
    }

    public final void a(final Context context, final AppMetricaConfig appMetricaConfig) {
        A2 a2 = this.f;
        a2.f.a(context);
        a2.b.a(appMetricaConfig);
        C0283gn c0283gn = this.g;
        Context applicationContext = context.getApplicationContext();
        c0283gn.e.a(applicationContext);
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(appMetricaConfig.apiKey);
        if (((Boolean) WrapUtils.getOrDefault(appMetricaConfig.sessionsAutoTrackingEnabled, Boolean.TRUE)).booleanValue()) {
            orCreatePublicLogger.info("Session auto tracking enabled", new Object[0]);
            c0283gn.d.a();
        } else {
            orCreatePublicLogger.info("Session auto tracking disabled", new Object[0]);
        }
        c0283gn.f1023a.getClass();
        C0712y0 a3 = C0712y0.a(applicationContext);
        a3.d.a(appMetricaConfig, a3);
        IHandlerExecutor c = c();
        ((C0746z9) c).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.t1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C0588t1.this.b(context, appMetricaConfig);
            }
        });
        this.f1233a.getClass();
        C0737z0.b();
    }

    public final String b() {
        this.f1233a.getClass();
        C0712y0 c0712y0 = C0712y0.e;
        if (c0712y0 == null) {
            return null;
        }
        return c0712y0.f().e();
    }

    public final C0349jc d() {
        this.f1233a.getClass();
        return C0712y0.e.f().i();
    }

    public final void e() {
        d().f1067a.a(this.h.a());
    }

    public final void f() {
        this.f.f497a.a(null);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((C0746z9) c).b.post(new W0(this));
    }

    public final void c(Activity activity) {
        this.f.f497a.a(null);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((C0746z9) c).b.post(new RunnableC0287h1(this, activity));
    }

    public final void b(Context context, AppMetricaConfig appMetricaConfig) {
        C0737z0 c0737z0 = this.f1233a;
        Context applicationContext = context.getApplicationContext();
        c0737z0.getClass();
        C0712y0 a2 = C0712y0.a(applicationContext);
        a2.f().b(this.d.a(appMetricaConfig));
        Context context2 = a2.f1319a;
        ((C0746z9) C0135b4.l().c.a()).execute(new RunnableC0663w1(context2));
    }

    public final void d(String str) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((C0746z9) c).b.post(new T0(this, str));
    }

    public C0588t1() {
        this(C0135b4.l().d(), new Ho());
    }

    public final void c(String str, String str2) {
        A2 a2 = this.f;
        a2.f497a.a(null);
        a2.r.a(str);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((C0746z9) c).b.post(new RunnableC0464o1(this, str, str2));
    }

    public final void d(String str, String str2) {
        A2 a2 = this.f;
        a2.f497a.a(null);
        if (a2.n.a(str).f1199a) {
            this.g.getClass();
            IHandlerExecutor c = c();
            ((C0746z9) c).b.post(new RunnableC0184d1(this, str, str2));
        }
    }

    public C0588t1(C0737z0 c0737z0, Ho ho) {
        this(c0737z0, new A2(c0737z0), new C0307hl(c0737z0), ho, new C0283gn(c0737z0, ho), C0481oi.a(), C0135b4.l().j(), C0135b4.l().o());
    }

    public final void b(String str) {
        A2 a2 = this.f;
        a2.f497a.a(null);
        a2.r.a(str);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((C0746z9) c).b.post(new RunnableC0439n1(this, str));
    }

    public final void c(boolean z) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((C0746z9) c).b.post(new Q0(this, z));
    }

    public final void b(Activity activity) {
        A2 a2 = this.f;
        a2.f497a.a(null);
        a2.c.a(activity);
        this.g.getClass();
        Intent a3 = C0283gn.a(activity);
        IHandlerExecutor c = c();
        ((C0746z9) c).b.post(new M0(this, a3));
    }

    public final void c(String str) {
        if (this.e.a((Void) null).f1199a && this.f.m.a(str).f1199a) {
            this.g.getClass();
            IHandlerExecutor c = c();
            ((C0746z9) c).b.post(new RunnableC0209e1(this, str));
        }
    }

    public final void a(Activity activity) {
        this.f.f497a.a(null);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((C0746z9) c).b.post(new RunnableC0414m1(this, activity));
    }

    public final void b(boolean z) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((C0746z9) c).b.post(new S0(this, z));
    }

    public final void b(String str, String str2) {
        this.f.k.a(str);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((C0746z9) c).b.post(new RunnableC0132b1(this, str, str2));
    }

    public final void a(Application application) {
        this.f.e.a(application);
        this.g.c.a(application);
        IHandlerExecutor c = c();
        ((C0746z9) c).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.t1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0588t1.this.e();
            }
        });
    }

    public final void b(final Object... objArr) {
        this.f.f497a.a(null);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((C0746z9) c).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.t1$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                C0588t1.a(objArr);
            }
        });
    }

    public final void a(String str, Map<String, Object> map) {
        A2 a2 = this.f;
        a2.f497a.a(null);
        a2.r.a(str);
        this.g.getClass();
        List listFromMap = CollectionUtils.getListFromMap(map);
        IHandlerExecutor c = c();
        ((C0746z9) c).b.post(new RunnableC0489p1(this, str, listFromMap));
    }

    public final void b(Context context) {
        this.f.f.a(context);
        this.g.e.a(context);
        this.f1233a.getClass();
        C0712y0.a(context);
    }

    public final void a(String str, Throwable th) {
        A2 a2 = this.f;
        a2.f497a.a(null);
        a2.s.a(str);
        this.g.getClass();
        if (th == null) {
            th = new N1();
            th.fillInStackTrace();
        }
        IHandlerExecutor c = c();
        ((C0746z9) c).b.post(new RunnableC0514q1(this, str, th));
    }

    public final void a(String str, String str2, Throwable th) {
        A2 a2 = this.f;
        a2.f497a.a(null);
        a2.t.a(str);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((C0746z9) c).b.post(new RunnableC0538r1(this, str, str2, th));
    }

    public final void a(Throwable th) {
        A2 a2 = this.f;
        a2.f497a.a(null);
        a2.u.a(th);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((C0746z9) c).b.post(new RunnableC0563s1(this, th));
    }

    public final void a(String str) {
        A2 a2 = this.f;
        a2.f497a.a(null);
        a2.i.a(str);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((C0746z9) c).b.post(new N0(this, str));
    }

    public final void a(Intent intent) {
        A2 a2 = this.f;
        a2.f497a.a(null);
        a2.d.a(intent);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((C0746z9) c).b.post(new O0(this, intent));
    }

    public final void a(Location location) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((C0746z9) c).b.post(new P0(this, location));
    }

    public final void a(boolean z) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((C0746z9) c).b.post(new R0(this, z));
    }

    public final void a(UserProfile userProfile) {
        A2 a2 = this.f;
        a2.f497a.a(null);
        a2.v.a(userProfile);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((C0746z9) c).b.post(new U0(this, userProfile));
    }

    public final void a(Revenue revenue) {
        A2 a2 = this.f;
        a2.f497a.a(null);
        a2.w.a(revenue);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((C0746z9) c).b.post(new V0(this, revenue));
    }

    public final void a(AdRevenue adRevenue) {
        A2 a2 = this.f;
        a2.f497a.a(null);
        a2.x.a(adRevenue);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((C0746z9) c).b.post(new X0(this, adRevenue));
    }

    public final void a(ECommerceEvent eCommerceEvent) {
        A2 a2 = this.f;
        a2.f497a.a(null);
        a2.y.a(eCommerceEvent);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((C0746z9) c).b.post(new Y0(this, eCommerceEvent));
    }

    public final void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        A2 a2 = this.f;
        a2.f497a.a(null);
        a2.g.a(deferredDeeplinkParametersListener);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((C0746z9) c).b.post(new Z0(this, deferredDeeplinkParametersListener));
    }

    public final void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        A2 a2 = this.f;
        a2.f497a.a(null);
        a2.g.a(deferredDeeplinkListener);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((C0746z9) c).b.post(new RunnableC0106a1(this, deferredDeeplinkListener));
    }

    public final Ra a(Context context, String str) {
        A2 a2 = this.f;
        a2.f.a(context);
        a2.j.a(str);
        C0283gn c0283gn = this.g;
        c0283gn.e.a(context.getApplicationContext());
        return this.c.a(context.getApplicationContext(), str);
    }

    public final void a(Context context, ReporterConfig reporterConfig) {
        A2 a2 = this.f;
        a2.f.a(context);
        a2.h.a(reporterConfig);
        C0283gn c0283gn = this.g;
        c0283gn.e.a(context.getApplicationContext());
        C0481oi c0481oi = this.c;
        Context applicationContext = context.getApplicationContext();
        if (((C0278gi) c0481oi.f1162a.get(reporterConfig.apiKey)) == null) {
            synchronized (c0481oi.f1162a) {
                if (((C0278gi) c0481oi.f1162a.get(reporterConfig.apiKey)) == null) {
                    String str = reporterConfig.apiKey;
                    IHandlerExecutor a3 = C0135b4.l().c.a();
                    c0481oi.b.getClass();
                    if (C0712y0.e == null) {
                        ((C0746z9) a3).b.post(new RunnableC0431mi(c0481oi, applicationContext));
                    }
                    C0278gi c0278gi = new C0278gi(applicationContext.getApplicationContext(), str, new C0737z0());
                    c0481oi.f1162a.put(str, c0278gi);
                    c0278gi.a(reporterConfig);
                }
            }
        }
    }

    public final void a(WebView webView) {
        A2 a2 = this.f;
        a2.f497a.a(null);
        a2.l.a(webView);
        Ho ho = this.g.b;
        ho.getClass();
        try {
            if (webView.getSettings().getJavaScriptEnabled()) {
                webView.addJavascriptInterface(new AppMetricaJsInterface(this), "AppMetrica");
                webView.addJavascriptInterface(new AppMetricaInitializerJsInterface(this), "AppMetricaInitializer");
                Eo eo = new Eo();
                synchronized (ho) {
                    PublicLogger publicLogger = ho.b;
                    if (publicLogger == null) {
                        ho.f624a.add(eo);
                    } else {
                        eo.consume(publicLogger);
                    }
                }
            } else {
                ho.a(new Fo());
            }
        } catch (Throwable th) {
            ho.a(new Go(th));
        }
        IHandlerExecutor c = c();
        ((C0746z9) c).b.post(new RunnableC0158c1(this));
    }

    public final IdentifiersResult a(Context context) {
        this.f.f.a(context);
        C0283gn c0283gn = this.g;
        Context applicationContext = context.getApplicationContext();
        c0283gn.e.a(applicationContext);
        c0283gn.f.a(applicationContext);
        return C0135b4.l().a(context.getApplicationContext()).a();
    }

    public final void a(String str, String str2) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((C0746z9) c).b.post(new RunnableC0235f1(this, str, str2));
    }

    public final void a() {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((C0746z9) c).b.post(new RunnableC0261g1(this));
    }

    public final void a(Context context, StartupParamsCallback startupParamsCallback, List<String> list) {
        A2 a2 = this.f;
        a2.f.a(context);
        a2.o.a(startupParamsCallback);
        C0283gn c0283gn = this.g;
        c0283gn.e.a(context.getApplicationContext());
        IHandlerExecutor c = c();
        ((C0746z9) c).b.post(new RunnableC0313i1(this, context, startupParamsCallback, list));
    }

    public final void a(AnrListener anrListener) {
        A2 a2 = this.f;
        a2.f497a.a(null);
        a2.p.a(anrListener);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((C0746z9) c).b.post(new RunnableC0338j1(this, anrListener));
    }

    public final void a(ExternalAttribution externalAttribution) {
        A2 a2 = this.f;
        a2.f497a.a(null);
        a2.q.a(externalAttribution);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((C0746z9) c).b.post(new RunnableC0364k1(this, externalAttribution));
    }

    public static /* synthetic */ void a(Object[] objArr) {
        ModuleAdRevenueProcessor b = C0135b4.l().m().b();
        if (b != null) {
            b.process(objArr);
        }
    }

    public final void a(Map<Thread, StackTraceElement[]> map) {
        this.f.z.a(map);
        this.g.getClass();
        List listFromMap = CollectionUtils.getListFromMap(map);
        IHandlerExecutor c = c();
        ((C0746z9) c).b.post(new RunnableC0389l1(this, listFromMap));
    }

    public static Ia a(C0588t1 c0588t1) {
        return c0588t1.d().f1067a;
    }
}
