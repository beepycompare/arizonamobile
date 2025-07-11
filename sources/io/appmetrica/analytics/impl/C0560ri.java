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
/* renamed from: io.appmetrica.analytics.impl.ri  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0560ri implements InterfaceC0379kb {

    /* renamed from: a  reason: collision with root package name */
    public final C0617u0 f1029a;
    public final Lh b;
    public final IHandlerExecutor c;
    public final Context d;
    public final ReporterConfig e;
    public final Ai f;
    public final C0131af g;

    public C0560ri(ICommonExecutor iCommonExecutor, Context context, String str) {
        this(context.getApplicationContext(), str, new C0617u0());
    }

    public static InterfaceC0379kb a(C0617u0 c0617u0, Context context, ReporterConfig reporterConfig) {
        c0617u0.getClass();
        return C0592t0.a(context).f().c(reporterConfig);
    }

    public final void c(String str) {
        ReporterConfig build = ReporterConfig.newConfigBuilder(str).build();
        this.b.getClass();
        this.f.getClass();
        this.c.execute(new RunnableC0237ei(this, build));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void clearAppEnvironment() {
        this.b.getClass();
        this.f.getClass();
        this.c.execute(new RunnableC0486oi(this));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final IPluginReporter getPluginExtension() {
        return this.g;
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void pauseSession() {
        this.b.getClass();
        this.f.getClass();
        this.c.execute(new Wh(this));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void putAppEnvironmentValue(String str, String str2) {
        this.b.getClass();
        this.f.getClass();
        this.c.execute(new RunnableC0461ni(this, str, str2));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportAdRevenue(AdRevenue adRevenue) {
        this.b.h.a(adRevenue);
        this.f.getClass();
        this.c.execute(new RunnableC0134ai(this, adRevenue));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportAnr(Map<Thread, StackTraceElement[]> map) {
        this.b.j.a(map);
        this.f.getClass();
        this.c.execute(new RunnableC0386ki(this, CollectionUtils.getListFromMap(map)));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportECommerce(ECommerceEvent eCommerceEvent) {
        this.b.i.a(eCommerceEvent);
        this.f.getClass();
        this.c.execute(new RunnableC0186ci(this, eCommerceEvent));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, Throwable th) {
        this.b.b.a(str);
        this.f.getClass();
        if (th == null) {
            th = new T1();
            th.fillInStackTrace();
        }
        this.c.execute(new Sh(this, str, th));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str) {
        this.b.f520a.a(str);
        this.f.getClass();
        this.c.execute(new RunnableC0511pi(this, str));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportRevenue(Revenue revenue) {
        this.b.g.a(revenue);
        this.f.getClass();
        this.c.execute(new Zh(this, revenue));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportUnhandledException(Throwable th) {
        this.b.e.a(th);
        this.f.getClass();
        this.c.execute(new Uh(this, th));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportUserProfile(UserProfile userProfile) {
        this.b.f.a(userProfile);
        this.f.getClass();
        this.c.execute(new Yh(this, userProfile));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void resumeSession() {
        this.b.getClass();
        this.f.getClass();
        this.c.execute(new Vh(this));
    }

    @Override // io.appmetrica.analytics.IReporter, io.appmetrica.analytics.IModuleReporter
    public final void sendEventsBuffer() {
        this.b.getClass();
        this.f.getClass();
        this.c.execute(new RunnableC0436mi(this));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void setDataSendingEnabled(boolean z) {
        this.b.getClass();
        this.f.getClass();
        this.c.execute(new RunnableC0212di(this, z));
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void setSessionExtra(String str, byte[] bArr) {
        this.b.getClass();
        this.f.getClass();
        this.c.execute(new RunnableC0312hi(this, str, bArr));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void setUserProfileID(String str) {
        this.b.getClass();
        this.f.getClass();
        this.c.execute(new Xh(this, str));
    }

    public C0560ri(Context context, String str, C0617u0 c0617u0) {
        this(context, new Lh(), c0617u0, new Ai(), ReporterConfig.newConfigBuilder(str).build());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0379kb, io.appmetrica.analytics.impl.InterfaceC0454nb
    public final void a(Kn kn) {
        this.b.d.a(kn);
        this.f.getClass();
        this.c.execute(new RunnableC0361ji(this, kn));
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void reportAdRevenue(AdRevenue adRevenue, boolean z) {
        this.b.h.a(adRevenue);
        this.f.getClass();
        this.c.execute(new RunnableC0336ii(this, adRevenue, z));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str, String str2) {
        this.b.f520a.a(str);
        this.f.getClass();
        this.c.execute(new RunnableC0536qi(this, str, str2));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, String str2) {
        reportError(str, str2, null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, String str2, Throwable th) {
        this.b.c.a(str);
        this.f.getClass();
        this.c.execute(new Th(this, str, str2, th));
    }

    public C0560ri(Context context, Lh lh, C0617u0 c0617u0, Ai ai, ReporterConfig reporterConfig) {
        this(context, lh, c0617u0, ai, reporterConfig, new C0131af(new C0160bi(c0617u0, context, reporterConfig)));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0379kb, io.appmetrica.analytics.impl.InterfaceC0219e0
    public final void a(U u) {
        this.b.getClass();
        this.f.getClass();
        this.c.execute(new RunnableC0411li(this, u));
    }

    public C0560ri(Context context, Lh lh, C0617u0 c0617u0, Ai ai, ReporterConfig reporterConfig, C0131af c0131af) {
        this.c = C0696x4.l().g().a();
        this.d = context;
        this.b = lh;
        this.f1029a = c0617u0;
        this.f = ai;
        this.e = reporterConfig;
        this.g = c0131af;
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str, Map<String, Object> map) {
        this.b.f520a.a(str);
        this.f.getClass();
        this.c.execute(new Rh(this, str, CollectionUtils.getListFromMap(map)));
    }

    public final void a(ReporterConfig reporterConfig) {
        this.b.getClass();
        this.f.getClass();
        this.c.execute(new RunnableC0262fi(this, reporterConfig));
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void reportEvent(ModuleEvent moduleEvent) {
        this.b.getClass();
        this.f.getClass();
        this.c.execute(new RunnableC0287gi(this, moduleEvent));
    }
}
