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
public final class C0494p1 {

    /* renamed from: a  reason: collision with root package name */
    public final C0617u0 f984a;
    public final Ao b;
    public final C0760zi c;
    public final W7 d;
    public final C0240el e;
    public final M2 f;
    public final C0191cn g;
    public final Uk h;

    public C0494p1(C0617u0 c0617u0, M2 m2, C0240el c0240el, Ao ao, C0191cn c0191cn, C0760zi c0760zi, W7 w7, Uk uk) {
        this.f984a = c0617u0;
        this.b = ao;
        this.c = c0760zi;
        this.d = w7;
        this.f = m2;
        this.g = c0191cn;
        this.e = c0240el;
        this.h = uk;
    }

    public static IHandlerExecutor c() {
        return C0696x4.l().c.a();
    }

    public final void a(final Context context, final AppMetricaConfig appMetricaConfig) {
        M2 m2 = this.f;
        m2.f.a(context);
        m2.b.a(appMetricaConfig);
        C0191cn c0191cn = this.g;
        Context applicationContext = context.getApplicationContext();
        c0191cn.e.a(applicationContext);
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(appMetricaConfig.apiKey);
        if (((Boolean) WrapUtils.getOrDefault(appMetricaConfig.sessionsAutoTrackingEnabled, Boolean.TRUE)).booleanValue()) {
            orCreatePublicLogger.info("Session auto tracking enabled", new Object[0]);
            c0191cn.d.a();
        } else {
            orCreatePublicLogger.info("Session auto tracking disabled", new Object[0]);
        }
        c0191cn.f790a.getClass();
        C0592t0 a2 = C0592t0.a(applicationContext);
        a2.d.a(appMetricaConfig, a2);
        IHandlerExecutor c = c();
        ((S9) c).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.p1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0494p1.this.b(context, appMetricaConfig);
            }
        });
        this.f984a.getClass();
        synchronized (C0592t0.class) {
            C0592t0.f = true;
        }
    }

    public final String b() {
        this.f984a.getClass();
        C0592t0 c0592t0 = C0592t0.e;
        if (c0592t0 == null) {
            return null;
        }
        return c0592t0.f().e();
    }

    public final Cc d() {
        this.f984a.getClass();
        return C0592t0.e.f().i();
    }

    public final void e() {
        d().f373a.a(this.h.a());
    }

    public final void f() {
        this.f.f528a.a(null);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((S9) c).b.post(new R0(this));
    }

    public final void c(Activity activity) {
        this.f.f528a.a(null);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((S9) c).b.post(new RunnableC0169c1(this, activity));
    }

    public final void b(Context context, AppMetricaConfig appMetricaConfig) {
        C0617u0 c0617u0 = this.f984a;
        Context applicationContext = context.getApplicationContext();
        c0617u0.getClass();
        C0592t0 a2 = C0592t0.a(applicationContext);
        a2.f().b(this.d.a(appMetricaConfig));
        Context context2 = a2.f1053a;
        ((S9) C0696x4.l().c.a()).execute(new RunnableC0568s1(context2));
    }

    public final void e(String str) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((S9) c).b.post(new P0(this, str));
    }

    public final void d(String str) {
        M2 m2 = this.f;
        m2.f528a.a(null);
        m2.j.a(str);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((S9) c).b.post(new K0(this, str));
    }

    public C0494p1() {
        this(C0696x4.l().d(), new Ao());
    }

    public final void c(String str, String str2) {
        M2 m2 = this.f;
        m2.f528a.a(null);
        m2.s.a(str);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((S9) c).b.post(new RunnableC0369k1(this, str, str2));
    }

    public C0494p1(C0617u0 c0617u0, Ao ao) {
        this(c0617u0, new M2(c0617u0), new C0240el(c0617u0), ao, new C0191cn(c0617u0, ao), C0760zi.a(), C0696x4.l().j(), C0696x4.l().o());
    }

    public final void d(String str, String str2) {
        M2 m2 = this.f;
        m2.f528a.a(null);
        if (m2.o.a(str).f913a) {
            this.g.getClass();
            IHandlerExecutor c = c();
            ((S9) c).b.post(new Z0(this, str, str2));
        }
    }

    public final void b(String str) {
        M2 m2 = this.f;
        m2.f528a.a(null);
        m2.s.a(str);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((S9) c).b.post(new RunnableC0344j1(this, str));
    }

    public final void c(boolean z) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((S9) c).b.post(new M0(this, z));
    }

    public final void b(Activity activity) {
        M2 m2 = this.f;
        m2.f528a.a(null);
        m2.c.a(activity);
        this.g.getClass();
        Intent a2 = C0191cn.a(activity);
        IHandlerExecutor c = c();
        ((S9) c).b.post(new H0(this, a2));
    }

    public final void c(String str) {
        if (this.e.a((Void) null).f913a && this.f.n.a(str).f913a) {
            this.g.getClass();
            IHandlerExecutor c = c();
            ((S9) c).b.post(new RunnableC0117a1(this, str));
        }
    }

    public final void b(boolean z) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((S9) c).b.post(new O0(this, z));
    }

    public final void a(Activity activity) {
        this.f.f528a.a(null);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((S9) c).b.post(new RunnableC0320i1(this, activity));
    }

    public final void b(String str, String str2) {
        this.f.l.a(str);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((S9) c).b.post(new X0(this, str, str2));
    }

    public final void a(Application application) {
        this.f.e.a(application);
        this.g.c.a(application);
        IHandlerExecutor c = c();
        ((S9) c).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.p1$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                C0494p1.this.e();
            }
        });
    }

    public final void b(final Object... objArr) {
        this.f.f528a.a(null);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((S9) c).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.p1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C0494p1.a(objArr);
            }
        });
    }

    public final void a(String str, Map<String, Object> map) {
        M2 m2 = this.f;
        m2.f528a.a(null);
        m2.s.a(str);
        this.g.getClass();
        List listFromMap = CollectionUtils.getListFromMap(map);
        IHandlerExecutor c = c();
        ((S9) c).b.post(new RunnableC0394l1(this, str, listFromMap));
    }

    public final void b(Context context) {
        this.f.f.a(context);
        this.g.e.a(context);
        this.f984a.getClass();
        C0592t0.a(context);
    }

    public final void a(String str, Throwable th) {
        M2 m2 = this.f;
        m2.f528a.a(null);
        m2.t.a(str);
        this.g.getClass();
        if (th == null) {
            th = new T1();
            th.fillInStackTrace();
        }
        IHandlerExecutor c = c();
        ((S9) c).b.post(new RunnableC0419m1(this, str, th));
    }

    public final void a(String str, String str2, Throwable th) {
        M2 m2 = this.f;
        m2.f528a.a(null);
        m2.u.a(str);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((S9) c).b.post(new RunnableC0444n1(this, str, str2, th));
    }

    public final void a(Throwable th) {
        M2 m2 = this.f;
        m2.f528a.a(null);
        m2.v.a(th);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((S9) c).b.post(new RunnableC0469o1(this, th));
    }

    public final void a(String str) {
        M2 m2 = this.f;
        m2.f528a.a(null);
        m2.i.a(str);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((S9) c).b.post(new I0(this, str));
    }

    public final void a(Intent intent) {
        M2 m2 = this.f;
        m2.f528a.a(null);
        m2.d.a(intent);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((S9) c).b.post(new J0(this, intent));
    }

    public final void a(Location location) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((S9) c).b.post(new L0(this, location));
    }

    public final void a(boolean z) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((S9) c).b.post(new N0(this, z));
    }

    public final void a(UserProfile userProfile) {
        M2 m2 = this.f;
        m2.f528a.a(null);
        m2.w.a(userProfile);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((S9) c).b.post(new Q0(this, userProfile));
    }

    public final void a(Revenue revenue) {
        M2 m2 = this.f;
        m2.f528a.a(null);
        m2.x.a(revenue);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((S9) c).b.post(new S0(this, revenue));
    }

    public final void a(AdRevenue adRevenue) {
        M2 m2 = this.f;
        m2.f528a.a(null);
        m2.y.a(adRevenue);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((S9) c).b.post(new T0(this, adRevenue));
    }

    public final void a(ECommerceEvent eCommerceEvent) {
        M2 m2 = this.f;
        m2.f528a.a(null);
        m2.z.a(eCommerceEvent);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((S9) c).b.post(new U0(this, eCommerceEvent));
    }

    public final void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        M2 m2 = this.f;
        m2.f528a.a(null);
        m2.g.a(deferredDeeplinkParametersListener);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((S9) c).b.post(new V0(this, deferredDeeplinkParametersListener));
    }

    public final void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        M2 m2 = this.f;
        m2.f528a.a(null);
        m2.g.a(deferredDeeplinkListener);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((S9) c).b.post(new W0(this, deferredDeeplinkListener));
    }

    public final InterfaceC0379kb a(Context context, String str) {
        M2 m2 = this.f;
        m2.f.a(context);
        m2.k.a(str);
        C0191cn c0191cn = this.g;
        c0191cn.e.a(context.getApplicationContext());
        return this.c.a(context.getApplicationContext(), str);
    }

    public final void a(Context context, ReporterConfig reporterConfig) {
        M2 m2 = this.f;
        m2.f.a(context);
        m2.h.a(reporterConfig);
        C0191cn c0191cn = this.g;
        c0191cn.e.a(context.getApplicationContext());
        C0760zi c0760zi = this.c;
        Context applicationContext = context.getApplicationContext();
        if (((C0560ri) c0760zi.f1169a.get(reporterConfig.apiKey)) == null) {
            synchronized (c0760zi.f1169a) {
                if (((C0560ri) c0760zi.f1169a.get(reporterConfig.apiKey)) == null) {
                    String str = reporterConfig.apiKey;
                    IHandlerExecutor a2 = C0696x4.l().c.a();
                    c0760zi.b.getClass();
                    if (C0592t0.e == null) {
                        ((S9) a2).b.post(new RunnableC0710xi(c0760zi, applicationContext));
                    }
                    C0560ri c0560ri = new C0560ri(applicationContext.getApplicationContext(), str, new C0617u0());
                    c0760zi.f1169a.put(str, c0560ri);
                    c0560ri.a(reporterConfig);
                }
            }
        }
    }

    public final void a(WebView webView) {
        M2 m2 = this.f;
        m2.f528a.a(null);
        m2.m.a(webView);
        Ao ao = this.g.b;
        ao.getClass();
        try {
            if (webView.getSettings().getJavaScriptEnabled()) {
                webView.addJavascriptInterface(new AppMetricaJsInterface(this), "AppMetrica");
                webView.addJavascriptInterface(new AppMetricaInitializerJsInterface(this), "AppMetricaInitializer");
                xo xoVar = new xo();
                synchronized (ao) {
                    PublicLogger publicLogger = ao.b;
                    if (publicLogger == null) {
                        ao.f344a.add(xoVar);
                    } else {
                        xoVar.consume(publicLogger);
                    }
                }
            } else {
                ao.a(new yo());
            }
        } catch (Throwable th) {
            ao.a(new zo(th));
        }
        IHandlerExecutor c = c();
        ((S9) c).b.post(new Y0(this));
    }

    public final IdentifiersResult a(Context context) {
        this.f.f.a(context);
        C0191cn c0191cn = this.g;
        Context applicationContext = context.getApplicationContext();
        c0191cn.e.a(applicationContext);
        c0191cn.f.a(applicationContext);
        return C0696x4.l().a(context.getApplicationContext()).a();
    }

    public final void a(String str, String str2) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((S9) c).b.post(new RunnableC0143b1(this, str, str2));
    }

    public final void a() {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((S9) c).b.post(new RunnableC0195d1(this));
    }

    public final void a(Context context, StartupParamsCallback startupParamsCallback, List<String> list) {
        M2 m2 = this.f;
        m2.f.a(context);
        m2.p.a(startupParamsCallback);
        C0191cn c0191cn = this.g;
        c0191cn.e.a(context.getApplicationContext());
        IHandlerExecutor c = c();
        ((S9) c).b.post(new RunnableC0220e1(this, context, startupParamsCallback, list));
    }

    public final void a(AnrListener anrListener) {
        M2 m2 = this.f;
        m2.f528a.a(null);
        m2.q.a(anrListener);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((S9) c).b.post(new RunnableC0245f1(this, anrListener));
    }

    public final void a(ExternalAttribution externalAttribution) {
        M2 m2 = this.f;
        m2.f528a.a(null);
        m2.r.a(externalAttribution);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((S9) c).b.post(new RunnableC0270g1(this, externalAttribution));
    }

    public static /* synthetic */ void a(Object[] objArr) {
        ModuleAdRevenueProcessor b = C0696x4.l().m().b();
        if (b != null) {
            b.process(objArr);
        }
    }

    public final void a(Map<Thread, StackTraceElement[]> map) {
        this.f.A.a(map);
        this.g.getClass();
        List listFromMap = CollectionUtils.getListFromMap(map);
        IHandlerExecutor c = c();
        ((S9) c).b.post(new RunnableC0295h1(this, listFromMap));
    }

    public static InterfaceC0153bb a(C0494p1 c0494p1) {
        return c0494p1.d().f373a;
    }
}
