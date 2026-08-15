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
/* renamed from: io.appmetrica.analytics.impl.v1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0650v1 {

    /* renamed from: a  reason: collision with root package name */
    public final B0 f1243a;
    public final lp b;
    public final Ii c;
    public final V7 d;
    public final Ml e;
    public final N2 f;
    public final Hn g;
    public final Bl h;

    public C0650v1(B0 b0, N2 n2, Ml ml, lp lpVar, Hn hn, Ii ii, V7 v7, Bl bl) {
        this.f1243a = b0;
        this.b = lpVar;
        this.c = ii;
        this.d = v7;
        this.f = n2;
        this.g = hn;
        this.e = ml;
        this.h = bl;
    }

    public static IHandlerExecutor b() {
        return C0575s4.l().c.a();
    }

    public final void a(final Context context, final AppMetricaConfig appMetricaConfig) {
        N2 n2 = this.f;
        n2.f.a(context);
        n2.b.a(appMetricaConfig);
        Hn hn = this.g;
        Context applicationContext = context.getApplicationContext();
        hn.e.a(applicationContext);
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(appMetricaConfig.apiKey);
        if (((Boolean) WrapUtils.getOrDefault(appMetricaConfig.sessionsAutoTrackingEnabled, Boolean.TRUE)).booleanValue()) {
            orCreatePublicLogger.info("Session auto tracking enabled", new Object[0]);
            hn.d.a();
        } else {
            orCreatePublicLogger.info("Session auto tracking disabled", new Object[0]);
        }
        hn.f585a.getClass();
        A0 a2 = A0.a(applicationContext);
        a2.d.a(appMetricaConfig, a2);
        IHandlerExecutor b = b();
        ((U9) b).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.v1$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                C0650v1.this.b(context, appMetricaConfig);
            }
        });
        this.f1243a.getClass();
        B0.b();
    }

    public final Lc c() {
        this.f1243a.getClass();
        return A0.e.f().i();
    }

    public final void d() {
        c().f647a.a(this.h.a());
    }

    public final void e() {
        this.f.f677a.a(null);
        this.g.getClass();
        IHandlerExecutor b = b();
        ((U9) b).b.post(new Y0(this));
    }

    public final void b(Context context, AppMetricaConfig appMetricaConfig) {
        B0 b0 = this.f1243a;
        Context applicationContext = context.getApplicationContext();
        b0.getClass();
        A0 a2 = A0.a(applicationContext);
        a2.f().b(this.d.d(appMetricaConfig));
        Context context2 = a2.f449a;
        ((U9) C0575s4.l().c.a()).execute(new RunnableC0728y1(context2));
    }

    public final void d(String str) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor b = b();
        ((U9) b).b.post(new V0(this, str));
    }

    public final void c(Activity activity) {
        this.f.f677a.a(null);
        this.g.getClass();
        IHandlerExecutor b = b();
        ((U9) b).b.post(new RunnableC0339j1(this, activity));
    }

    public C0650v1() {
        this(C0575s4.l().d(), new lp());
    }

    public final void d(String str, String str2) {
        N2 n2 = this.f;
        n2.f677a.a(null);
        if (n2.n.a(str).f784a) {
            this.g.getClass();
            IHandlerExecutor b = b();
            ((U9) b).b.post(new RunnableC0236f1(this, str, str2));
        }
    }

    public C0650v1(B0 b0, lp lpVar) {
        this(b0, new N2(b0), new Ml(b0), lpVar, new Hn(b0, lpVar), Ii.a(), C0575s4.l().j(), C0575s4.l().o());
    }

    public final void c(String str, String str2) {
        N2 n2 = this.f;
        n2.f677a.a(null);
        n2.r.a(str);
        this.g.getClass();
        IHandlerExecutor b = b();
        ((U9) b).b.post(new RunnableC0521q1(this, str, str2));
    }

    public final void b(String str) {
        N2 n2 = this.f;
        n2.f677a.a(null);
        n2.r.a(str);
        this.g.getClass();
        IHandlerExecutor b = b();
        ((U9) b).b.post(new RunnableC0495p1(this, str));
    }

    public final void c(boolean z) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor b = b();
        ((U9) b).b.post(new S0(this, z));
    }

    public final void b(Activity activity) {
        N2 n2 = this.f;
        n2.f677a.a(null);
        n2.c.a(activity);
        this.g.getClass();
        Intent a2 = Hn.a(activity);
        IHandlerExecutor b = b();
        ((U9) b).b.post(new O0(this, a2));
    }

    public final void c(String str) {
        if (this.e.a((Void) null).f784a && this.f.m.a(str).f784a) {
            this.g.getClass();
            IHandlerExecutor b = b();
            ((U9) b).b.post(new RunnableC0262g1(this, str));
        }
    }

    public final void b(boolean z) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor b = b();
        ((U9) b).b.post(new U0(this, z));
    }

    public final void a(Activity activity) {
        this.f.f677a.a(null);
        this.g.getClass();
        IHandlerExecutor b = b();
        ((U9) b).b.post(new RunnableC0469o1(this, activity));
    }

    public final void b(String str, String str2) {
        this.f.k.a(str);
        this.g.getClass();
        IHandlerExecutor b = b();
        ((U9) b).b.post(new RunnableC0185d1(this, str, str2));
    }

    public final void c(Context context) {
        this.f.f.a(context);
        this.g.e.a(context);
        this.f1243a.getClass();
        A0.a(context);
    }

    public final void a(Application application) {
        this.f.e.a(application);
        this.g.c.a(application);
        IHandlerExecutor b = b();
        ((U9) b).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.v1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0650v1.this.d();
            }
        });
    }

    public final IdentifiersResult b(Context context) {
        this.f.f.a(context);
        Hn hn = this.g;
        Context applicationContext = context.getApplicationContext();
        hn.e.a(applicationContext);
        hn.f.a(applicationContext);
        return C0575s4.l().a(context.getApplicationContext()).a();
    }

    public final void a(String str, Map<String, Object> map) {
        N2 n2 = this.f;
        n2.f677a.a(null);
        n2.r.a(str);
        this.g.getClass();
        List listFromMap = CollectionUtils.getListFromMap(map);
        IHandlerExecutor b = b();
        ((U9) b).b.post(new RunnableC0546r1(this, str, listFromMap));
    }

    public final void b(final Object... objArr) {
        this.f.f677a.a(null);
        this.g.getClass();
        IHandlerExecutor b = b();
        ((U9) b).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.v1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C0650v1.a(objArr);
            }
        });
    }

    public final void a(String str, Throwable th) {
        N2 n2 = this.f;
        n2.f677a.a(null);
        n2.s.a(str);
        this.g.getClass();
        if (th == null) {
            th = new C0108a2();
            th.fillInStackTrace();
        }
        IHandlerExecutor b = b();
        ((U9) b).b.post(new RunnableC0572s1(this, str, th));
    }

    public final void a(String str, String str2, Throwable th) {
        N2 n2 = this.f;
        n2.f677a.a(null);
        n2.t.a(str);
        this.g.getClass();
        IHandlerExecutor b = b();
        ((U9) b).b.post(new RunnableC0598t1(this, str, str2, th));
    }

    public final void a(Throwable th) {
        N2 n2 = this.f;
        n2.f677a.a(null);
        n2.u.a(th);
        this.g.getClass();
        IHandlerExecutor b = b();
        ((U9) b).b.post(new RunnableC0624u1(this, th));
    }

    public final void a(String str) {
        N2 n2 = this.f;
        n2.f677a.a(null);
        n2.i.a(str);
        this.g.getClass();
        IHandlerExecutor b = b();
        ((U9) b).b.post(new P0(this, str));
    }

    public final void a(Intent intent) {
        N2 n2 = this.f;
        n2.f677a.a(null);
        n2.d.a(intent);
        this.g.getClass();
        IHandlerExecutor b = b();
        ((U9) b).b.post(new Q0(this, intent));
    }

    public final void a(Location location) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor b = b();
        ((U9) b).b.post(new R0(this, location));
    }

    public final void a(boolean z) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor b = b();
        ((U9) b).b.post(new T0(this, z));
    }

    public final void a(UserProfile userProfile) {
        N2 n2 = this.f;
        n2.f677a.a(null);
        n2.v.a(userProfile);
        this.g.getClass();
        IHandlerExecutor b = b();
        ((U9) b).b.post(new W0(this, userProfile));
    }

    public final void a(Revenue revenue) {
        N2 n2 = this.f;
        n2.f677a.a(null);
        n2.w.a(revenue);
        this.g.getClass();
        IHandlerExecutor b = b();
        ((U9) b).b.post(new X0(this, revenue));
    }

    public final void a(AdRevenue adRevenue) {
        N2 n2 = this.f;
        n2.f677a.a(null);
        n2.x.a(adRevenue);
        this.g.getClass();
        IHandlerExecutor b = b();
        ((U9) b).b.post(new Z0(this, adRevenue));
    }

    public final void a(ECommerceEvent eCommerceEvent) {
        N2 n2 = this.f;
        n2.f677a.a(null);
        n2.y.a(eCommerceEvent);
        this.g.getClass();
        IHandlerExecutor b = b();
        ((U9) b).b.post(new RunnableC0107a1(this, eCommerceEvent));
    }

    public final void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        N2 n2 = this.f;
        n2.f677a.a(null);
        n2.g.a(deferredDeeplinkParametersListener);
        this.g.getClass();
        IHandlerExecutor b = b();
        ((U9) b).b.post(new RunnableC0133b1(this, deferredDeeplinkParametersListener));
    }

    public final void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        N2 n2 = this.f;
        n2.f677a.a(null);
        n2.g.a(deferredDeeplinkListener);
        this.g.getClass();
        IHandlerExecutor b = b();
        ((U9) b).b.post(new RunnableC0159c1(this, deferredDeeplinkListener));
    }

    public final InterfaceC0505pb a(Context context, String str) {
        N2 n2 = this.f;
        n2.f.a(context);
        n2.j.a(str);
        Hn hn = this.g;
        hn.e.a(context.getApplicationContext());
        return this.c.a(context.getApplicationContext(), str);
    }

    public final void a(Context context, ReporterConfig reporterConfig) {
        N2 n2 = this.f;
        n2.f.a(context);
        n2.h.a(reporterConfig);
        Hn hn = this.g;
        hn.e.a(context.getApplicationContext());
        Ii ii = this.c;
        Context applicationContext = context.getApplicationContext();
        if (((Ai) ii.f599a.get(reporterConfig.apiKey)) == null) {
            synchronized (ii.f599a) {
                if (((Ai) ii.f599a.get(reporterConfig.apiKey)) == null) {
                    String str = reporterConfig.apiKey;
                    IHandlerExecutor a2 = C0575s4.l().c.a();
                    ii.b.getClass();
                    if (A0.e == null) {
                        ((U9) a2).b.post(new Gi(ii, applicationContext));
                    }
                    Ai ai = new Ai(applicationContext.getApplicationContext(), str, new B0());
                    ii.f599a.put(str, ai);
                    ai.a(reporterConfig);
                }
            }
        }
    }

    public final void a(WebView webView) {
        N2 n2 = this.f;
        n2.f677a.a(null);
        n2.l.a(webView);
        lp lpVar = this.g.b;
        lpVar.getClass();
        try {
            if (webView.getSettings().getJavaScriptEnabled()) {
                webView.addJavascriptInterface(new AppMetricaJsInterface(this), "AppMetrica");
                webView.addJavascriptInterface(new AppMetricaInitializerJsInterface(this), "AppMetricaInitializer");
                ip ipVar = new ip();
                synchronized (lpVar) {
                    PublicLogger publicLogger = lpVar.b;
                    if (publicLogger == null) {
                        lpVar.f1087a.add(ipVar);
                    } else {
                        ipVar.consume(publicLogger);
                    }
                }
            } else {
                lpVar.a(new jp());
            }
        } catch (Throwable th) {
            lpVar.a(new kp(th));
        }
        IHandlerExecutor b = b();
        ((U9) b).b.post(new RunnableC0210e1(this));
    }

    public final String a(Context context) {
        this.f.f.a(context);
        Hn hn = this.g;
        hn.e.a(context.getApplicationContext());
        IdentifiersResult identifiersResult = (IdentifiersResult) C0575s4.l().d(context.getApplicationContext()).b.get(StartupParamsCallback.APPMETRICA_DEVICE_ID);
        if (identifiersResult == null) {
            return null;
        }
        return identifiersResult.id;
    }

    public final void a(String str, String str2) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor b = b();
        ((U9) b).b.post(new RunnableC0288h1(this, str, str2));
    }

    public final void a() {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor b = b();
        ((U9) b).b.post(new RunnableC0314i1(this));
    }

    public final void a(Context context, StartupParamsCallback startupParamsCallback, List<String> list) {
        N2 n2 = this.f;
        n2.f.a(context);
        n2.o.a(startupParamsCallback);
        Hn hn = this.g;
        hn.e.a(context.getApplicationContext());
        IHandlerExecutor b = b();
        ((U9) b).b.post(new RunnableC0365k1(this, context, startupParamsCallback, list));
    }

    public final void a(AnrListener anrListener) {
        N2 n2 = this.f;
        n2.f677a.a(null);
        n2.p.a(anrListener);
        this.g.getClass();
        IHandlerExecutor b = b();
        ((U9) b).b.post(new RunnableC0391l1(this, anrListener));
    }

    public final void a(ExternalAttribution externalAttribution) {
        N2 n2 = this.f;
        n2.f677a.a(null);
        n2.q.a(externalAttribution);
        this.g.getClass();
        IHandlerExecutor b = b();
        ((U9) b).b.post(new RunnableC0417m1(this, externalAttribution));
    }

    public static /* synthetic */ void a(Object[] objArr) {
        ModuleAdRevenueProcessor b = C0575s4.l().m().b();
        if (b != null) {
            b.process(objArr);
        }
    }

    public final void a(Map<Thread, StackTraceElement[]> map) {
        this.f.z.a(map);
        this.g.getClass();
        List listFromMap = CollectionUtils.getListFromMap(map);
        IHandlerExecutor b = b();
        ((U9) b).b.post(new RunnableC0443n1(this, listFromMap));
    }

    public static InterfaceC0375kb a(C0650v1 c0650v1) {
        return c0650v1.c().f647a;
    }
}
