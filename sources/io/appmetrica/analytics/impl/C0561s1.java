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
/* renamed from: io.appmetrica.analytics.impl.s1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0561s1 {

    /* renamed from: a  reason: collision with root package name */
    public final C0685x0 f1103a;
    public final Io b;
    public final C0603ti c;
    public final L7 d;
    public final C0407ll e;
    public final I2 f;
    public final C0357jn g;
    public final C0149bl h;

    public C0561s1(C0685x0 c0685x0, I2 i2, C0407ll c0407ll, Io io2, C0357jn c0357jn, C0603ti c0603ti, L7 l7, C0149bl c0149bl) {
        this.f1103a = c0685x0;
        this.b = io2;
        this.c = c0603ti;
        this.d = l7;
        this.f = i2;
        this.g = c0357jn;
        this.e = c0407ll;
        this.h = c0149bl;
    }

    public static IHandlerExecutor c() {
        return C0338j4.l().c.a();
    }

    public final void a(final Context context, final AppMetricaConfig appMetricaConfig) {
        I2 i2 = this.f;
        i2.f.a(context);
        i2.b.a(appMetricaConfig);
        C0357jn c0357jn = this.g;
        Context applicationContext = context.getApplicationContext();
        c0357jn.e.a(applicationContext);
        PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(appMetricaConfig.apiKey);
        if (((Boolean) WrapUtils.getOrDefault(appMetricaConfig.sessionsAutoTrackingEnabled, Boolean.TRUE)).booleanValue()) {
            orCreatePublicLogger.info("Session auto tracking enabled", new Object[0]);
            c0357jn.d.a();
        } else {
            orCreatePublicLogger.info("Session auto tracking disabled", new Object[0]);
        }
        c0357jn.f960a.getClass();
        C0660w0 a2 = C0660w0.a(applicationContext);
        a2.d.a(appMetricaConfig, a2);
        IHandlerExecutor c = c();
        ((G9) c).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.s1$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                C0561s1.this.b(context, appMetricaConfig);
            }
        });
        this.f1103a.getClass();
        C0685x0.b();
    }

    public final String b() {
        this.f1103a.getClass();
        C0660w0 c0660w0 = C0660w0.e;
        if (c0660w0 == null) {
            return null;
        }
        return c0660w0.f().e();
    }

    public final C0523qc d() {
        this.f1103a.getClass();
        return C0660w0.e.f().i();
    }

    public final void e() {
        d().f1072a.a(this.h.a());
    }

    public final void f() {
        this.f.f518a.a(null);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((G9) c).b.post(new U0(this));
    }

    public final void c(Activity activity) {
        this.f.f518a.a(null);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((G9) c).b.post(new RunnableC0232f1(this, activity));
    }

    public final void b(Context context, AppMetricaConfig appMetricaConfig) {
        C0685x0 c0685x0 = this.f1103a;
        Context applicationContext = context.getApplicationContext();
        c0685x0.getClass();
        C0660w0 a2 = C0660w0.a(applicationContext);
        a2.f().b(this.d.a(appMetricaConfig));
        Context context2 = a2.f1177a;
        ((G9) C0338j4.l().c.a()).execute(new RunnableC0636v1(context2));
    }

    public final void e(String str) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((G9) c).b.post(new S0(this, str));
    }

    public final void d(String str) {
        I2 i2 = this.f;
        i2.f518a.a(null);
        i2.j.a(str);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((G9) c).b.post(new N0(this, str));
    }

    public C0561s1() {
        this(C0338j4.l().d(), new Io());
    }

    public final void c(String str, String str2) {
        I2 i2 = this.f;
        i2.f518a.a(null);
        i2.s.a(str);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((G9) c).b.post(new RunnableC0437n1(this, str, str2));
    }

    public C0561s1(C0685x0 c0685x0, Io io2) {
        this(c0685x0, new I2(c0685x0), new C0407ll(c0685x0), io2, new C0357jn(c0685x0, io2), C0603ti.a(), C0338j4.l().j(), C0338j4.l().o());
    }

    public final void d(String str, String str2) {
        I2 i2 = this.f;
        i2.f518a.a(null);
        if (i2.o.a(str).f1120a) {
            this.g.getClass();
            IHandlerExecutor c = c();
            ((G9) c).b.post(new RunnableC0155c1(this, str, str2));
        }
    }

    public final void b(String str) {
        I2 i2 = this.f;
        i2.f518a.a(null);
        i2.s.a(str);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((G9) c).b.post(new RunnableC0412m1(this, str));
    }

    public final void c(boolean z) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((G9) c).b.post(new P0(this, z));
    }

    public final void b(Activity activity) {
        I2 i2 = this.f;
        i2.f518a.a(null);
        i2.c.a(activity);
        this.g.getClass();
        Intent a2 = C0357jn.a(activity);
        IHandlerExecutor c = c();
        ((G9) c).b.post(new K0(this, a2));
    }

    public final void c(String str) {
        if (this.e.a((Void) null).f1120a && this.f.n.a(str).f1120a) {
            this.g.getClass();
            IHandlerExecutor c = c();
            ((G9) c).b.post(new RunnableC0181d1(this, str));
        }
    }

    public final void a(Activity activity) {
        this.f.f518a.a(null);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((G9) c).b.post(new RunnableC0387l1(this, activity));
    }

    public final void b(boolean z) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((G9) c).b.post(new R0(this, z));
    }

    public final void b(String str, String str2) {
        this.f.l.a(str);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((G9) c).b.post(new RunnableC0103a1(this, str, str2));
    }

    public final void a(Application application) {
        this.f.e.a(application);
        this.g.c.a(application);
        IHandlerExecutor c = c();
        ((G9) c).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.s1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C0561s1.this.e();
            }
        });
    }

    public final void b(final Object... objArr) {
        this.f.f518a.a(null);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((G9) c).b.post(new Runnable() { // from class: io.appmetrica.analytics.impl.s1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C0561s1.a(objArr);
            }
        });
    }

    public final void a(String str, Map<String, Object> map) {
        I2 i2 = this.f;
        i2.f518a.a(null);
        i2.s.a(str);
        this.g.getClass();
        List listFromMap = CollectionUtils.getListFromMap(map);
        IHandlerExecutor c = c();
        ((G9) c).b.post(new RunnableC0462o1(this, str, listFromMap));
    }

    public final void b(Context context) {
        this.f.f.a(context);
        this.g.e.a(context);
        this.f1103a.getClass();
        C0660w0.a(context);
    }

    public final void a(String str, Throwable th) {
        I2 i2 = this.f;
        i2.f518a.a(null);
        i2.t.a(str);
        this.g.getClass();
        if (th == null) {
            th = new W1();
            th.fillInStackTrace();
        }
        IHandlerExecutor c = c();
        ((G9) c).b.post(new RunnableC0487p1(this, str, th));
    }

    public final void a(String str, String str2, Throwable th) {
        I2 i2 = this.f;
        i2.f518a.a(null);
        i2.u.a(str);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((G9) c).b.post(new RunnableC0512q1(this, str, str2, th));
    }

    public final void a(Throwable th) {
        I2 i2 = this.f;
        i2.f518a.a(null);
        i2.v.a(th);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((G9) c).b.post(new RunnableC0536r1(this, th));
    }

    public final void a(String str) {
        I2 i2 = this.f;
        i2.f518a.a(null);
        i2.i.a(str);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((G9) c).b.post(new L0(this, str));
    }

    public final void a(Intent intent) {
        I2 i2 = this.f;
        i2.f518a.a(null);
        i2.d.a(intent);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((G9) c).b.post(new M0(this, intent));
    }

    public final void a(Location location) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((G9) c).b.post(new O0(this, location));
    }

    public final void a(boolean z) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((G9) c).b.post(new Q0(this, z));
    }

    public final void a(UserProfile userProfile) {
        I2 i2 = this.f;
        i2.f518a.a(null);
        i2.w.a(userProfile);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((G9) c).b.post(new T0(this, userProfile));
    }

    public final void a(Revenue revenue) {
        I2 i2 = this.f;
        i2.f518a.a(null);
        i2.x.a(revenue);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((G9) c).b.post(new V0(this, revenue));
    }

    public final void a(AdRevenue adRevenue) {
        I2 i2 = this.f;
        i2.f518a.a(null);
        i2.y.a(adRevenue);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((G9) c).b.post(new W0(this, adRevenue));
    }

    public final void a(ECommerceEvent eCommerceEvent) {
        I2 i2 = this.f;
        i2.f518a.a(null);
        i2.z.a(eCommerceEvent);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((G9) c).b.post(new X0(this, eCommerceEvent));
    }

    public final void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        I2 i2 = this.f;
        i2.f518a.a(null);
        i2.g.a(deferredDeeplinkParametersListener);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((G9) c).b.post(new Y0(this, deferredDeeplinkParametersListener));
    }

    public final void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        I2 i2 = this.f;
        i2.f518a.a(null);
        i2.g.a(deferredDeeplinkListener);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((G9) c).b.post(new Z0(this, deferredDeeplinkListener));
    }

    public final Ya a(Context context, String str) {
        I2 i2 = this.f;
        i2.f.a(context);
        i2.k.a(str);
        C0357jn c0357jn = this.g;
        c0357jn.e.a(context.getApplicationContext());
        return this.c.a(context.getApplicationContext(), str);
    }

    public final void a(Context context, ReporterConfig reporterConfig) {
        I2 i2 = this.f;
        i2.f.a(context);
        i2.h.a(reporterConfig);
        C0357jn c0357jn = this.g;
        c0357jn.e.a(context.getApplicationContext());
        C0603ti c0603ti = this.c;
        Context applicationContext = context.getApplicationContext();
        if (((C0404li) c0603ti.f1135a.get(reporterConfig.apiKey)) == null) {
            synchronized (c0603ti.f1135a) {
                if (((C0404li) c0603ti.f1135a.get(reporterConfig.apiKey)) == null) {
                    String str = reporterConfig.apiKey;
                    IHandlerExecutor a2 = C0338j4.l().c.a();
                    c0603ti.b.getClass();
                    if (C0660w0.e == null) {
                        ((G9) a2).b.post(new RunnableC0553ri(c0603ti, applicationContext));
                    }
                    C0404li c0404li = new C0404li(applicationContext.getApplicationContext(), str, new C0685x0());
                    c0603ti.f1135a.put(str, c0404li);
                    c0404li.a(reporterConfig);
                }
            }
        }
    }

    public final void a(WebView webView) {
        I2 i2 = this.f;
        i2.f518a.a(null);
        i2.m.a(webView);
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
                        io2.f535a.add(fo);
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
        ((G9) c).b.post(new RunnableC0129b1(this));
    }

    public final IdentifiersResult a(Context context) {
        this.f.f.a(context);
        C0357jn c0357jn = this.g;
        Context applicationContext = context.getApplicationContext();
        c0357jn.e.a(applicationContext);
        c0357jn.f.a(applicationContext);
        return C0338j4.l().a(context.getApplicationContext()).a();
    }

    public final void a(String str, String str2) {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((G9) c).b.post(new RunnableC0206e1(this, str, str2));
    }

    public final void a() {
        this.f.getClass();
        this.g.getClass();
        IHandlerExecutor c = c();
        ((G9) c).b.post(new RunnableC0258g1(this));
    }

    public final void a(Context context, StartupParamsCallback startupParamsCallback, List<String> list) {
        I2 i2 = this.f;
        i2.f.a(context);
        i2.p.a(startupParamsCallback);
        C0357jn c0357jn = this.g;
        c0357jn.e.a(context.getApplicationContext());
        IHandlerExecutor c = c();
        ((G9) c).b.post(new RunnableC0284h1(this, context, startupParamsCallback, list));
    }

    public final void a(AnrListener anrListener) {
        I2 i2 = this.f;
        i2.f518a.a(null);
        i2.q.a(anrListener);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((G9) c).b.post(new RunnableC0310i1(this, anrListener));
    }

    public final void a(ExternalAttribution externalAttribution) {
        I2 i2 = this.f;
        i2.f518a.a(null);
        i2.r.a(externalAttribution);
        this.g.getClass();
        IHandlerExecutor c = c();
        ((G9) c).b.post(new RunnableC0335j1(this, externalAttribution));
    }

    public static /* synthetic */ void a(Object[] objArr) {
        ModuleAdRevenueProcessor b = C0338j4.l().m().b();
        if (b != null) {
            b.process(objArr);
        }
    }

    public final void a(Map<Thread, StackTraceElement[]> map) {
        this.f.A.a(map);
        this.g.getClass();
        List listFromMap = CollectionUtils.getListFromMap(map);
        IHandlerExecutor c = c();
        ((G9) c).b.post(new RunnableC0361k1(this, listFromMap));
    }

    public static Pa a(C0561s1 c0561s1) {
        return c0561s1.d().f1072a;
    }
}
