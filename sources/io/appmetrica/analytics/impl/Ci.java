package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AdRevenue;
import io.appmetrica.analytics.ModuleEvent;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.Revenue;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.collection.CollectionUtils;
import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.plugins.IPluginReporter;
import io.appmetrica.analytics.profile.UserProfile;
import java.util.Map;
/* loaded from: classes4.dex */
public final class Ci implements InterfaceC0558rb {

    /* renamed from: a  reason: collision with root package name */
    public final C0672w0 f393a;
    public final Wh b;
    public final IHandlerExecutor c;
    public final Context d;
    public final ReporterConfig e;
    public final Mi f;
    public final Cif g;

    public Ci(ICommonExecutor iCommonExecutor, Context context, String str) {
        this(context.getApplicationContext(), str, new C0672w0());
    }

    public static InterfaceC0558rb a(C0672w0 c0672w0, Context context, ReporterConfig reporterConfig) {
        c0672w0.getClass();
        return C0647v0.a(context).f().c(reporterConfig);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void clearAppEnvironment() {
        this.b.getClass();
        this.f.getClass();
        this.c.execute(new RunnableC0765zi(this));
    }

    public final void d(String str) {
        ReporterConfig build = ReporterConfig.newConfigBuilder(str).build();
        this.b.getClass();
        this.f.getClass();
        this.c.execute(new RunnableC0516pi(this, build));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final IPluginReporter getPluginExtension() {
        return this.g;
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void pauseSession() {
        this.b.getClass();
        this.f.getClass();
        this.c.execute(new RunnableC0309hi(this));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void putAppEnvironmentValue(String str, String str2) {
        this.b.getClass();
        this.f.getClass();
        this.c.execute(new RunnableC0740yi(this, str, str2));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportAdRevenue(AdRevenue adRevenue) {
        this.b.h.a(adRevenue);
        this.f.getClass();
        this.c.execute(new RunnableC0412li(this, adRevenue));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportAnr(Map<Thread, StackTraceElement[]> map) {
        this.b.j.a(map);
        this.f.getClass();
        this.c.execute(new RunnableC0665vi(this, CollectionUtils.getListFromMap(map)));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportECommerce(ECommerceEvent eCommerceEvent) {
        this.b.i.a(eCommerceEvent);
        this.f.getClass();
        this.c.execute(new RunnableC0464ni(this, eCommerceEvent));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, Throwable th) {
        this.b.b.a(str);
        this.f.getClass();
        if (th == null) {
            th = new V1();
            th.fillInStackTrace();
        }
        this.c.execute(new RunnableC0206di(this, str, th));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str) {
        this.b.f729a.a(str);
        this.f.getClass();
        this.c.execute(new Ai(this, str));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportRevenue(Revenue revenue) {
        this.b.g.a(revenue);
        this.f.getClass();
        this.c.execute(new RunnableC0386ki(this, revenue));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportUnhandledException(Throwable th) {
        this.b.e.a(th);
        this.f.getClass();
        this.c.execute(new RunnableC0257fi(this, th));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportUserProfile(UserProfile userProfile) {
        this.b.f.a(userProfile);
        this.f.getClass();
        this.c.execute(new RunnableC0360ji(this, userProfile));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void resumeSession() {
        this.b.getClass();
        this.f.getClass();
        this.c.execute(new RunnableC0283gi(this));
    }

    @Override // io.appmetrica.analytics.IReporter, io.appmetrica.analytics.IModuleReporter
    public final void sendEventsBuffer() {
        this.b.getClass();
        this.f.getClass();
        this.c.execute(new RunnableC0715xi(this));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void setDataSendingEnabled(boolean z) {
        this.b.getClass();
        this.f.getClass();
        this.c.execute(new RunnableC0490oi(this, z));
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void setSessionExtra(String str, byte[] bArr) {
        this.b.getClass();
        this.f.getClass();
        this.c.execute(new RunnableC0590si(this, str, bArr));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void setUserProfileID(String str) {
        this.b.getClass();
        this.f.getClass();
        this.c.execute(new RunnableC0334ii(this, str));
    }

    public Ci(Context context, String str, C0672w0 c0672w0) {
        this(context, new Wh(), c0672w0, new Mi(), ReporterConfig.newConfigBuilder(str).build());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0558rb, io.appmetrica.analytics.impl.InterfaceC0633ub
    public final void a(Wn wn) {
        this.b.d.a(wn);
        this.f.getClass();
        this.c.execute(new RunnableC0640ui(this, wn));
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void reportAdRevenue(AdRevenue adRevenue, boolean z) {
        this.b.h.a(adRevenue);
        this.f.getClass();
        this.c.execute(new RunnableC0615ti(this, adRevenue, z));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str, String str2) {
        this.b.f729a.a(str);
        this.f.getClass();
        this.c.execute(new Bi(this, str, str2));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, String str2) {
        reportError(str, str2, null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, String str2, Throwable th) {
        this.b.c.a(str);
        this.f.getClass();
        this.c.execute(new RunnableC0231ei(this, str, str2, th));
    }

    public Ci(Context context, Wh wh, C0672w0 c0672w0, Mi mi, ReporterConfig reporterConfig) {
        this(context, wh, c0672w0, mi, reporterConfig, new Cif(new C0438mi(c0672w0, context, reporterConfig)));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0558rb, io.appmetrica.analytics.impl.InterfaceC0239f0
    public final void a(U u) {
        this.b.getClass();
        this.f.getClass();
        this.c.execute(new RunnableC0690wi(this, u));
    }

    public Ci(Context context, Wh wh, C0672w0 c0672w0, Mi mi, ReporterConfig reporterConfig, Cif cif) {
        this.c = A4.l().g().a();
        this.d = context;
        this.b = wh;
        this.f393a = c0672w0;
        this.f = mi;
        this.e = reporterConfig;
        this.g = cif;
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str, Map<String, Object> map) {
        this.b.f729a.a(str);
        this.f.getClass();
        this.c.execute(new RunnableC0180ci(this, str, CollectionUtils.getListFromMap(map)));
    }

    public final void a(ReporterConfig reporterConfig) {
        this.b.getClass();
        this.f.getClass();
        this.c.execute(new RunnableC0541qi(this, reporterConfig));
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void reportEvent(ModuleEvent moduleEvent) {
        this.b.getClass();
        this.f.getClass();
        this.c.execute(new RunnableC0565ri(this, moduleEvent));
    }
}
