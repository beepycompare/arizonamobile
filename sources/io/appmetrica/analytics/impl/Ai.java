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
/* loaded from: classes5.dex */
public final class Ai implements InterfaceC0504pb {

    /* renamed from: a  reason: collision with root package name */
    public final B0 f463a;
    public final Uh b;
    public final IHandlerExecutor c;
    public final Context d;
    public final ReporterConfig e;
    public final Ki f;
    public final C0508pf g;

    public Ai(ICommonExecutor iCommonExecutor, Context context, String str) {
        this(context.getApplicationContext(), str, new B0());
    }

    public static InterfaceC0504pb a(B0 b0, Context context, ReporterConfig reporterConfig) {
        b0.getClass();
        return A0.a(context).f().c(reporterConfig);
    }

    public final void c(String str) {
        ReporterConfig build = ReporterConfig.newConfigBuilder(str).build();
        this.b.getClass();
        this.f.getClass();
        this.c.execute(new RunnableC0459ni(this, build));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void clearAppEnvironment() {
        this.b.getClass();
        this.f.getClass();
        this.c.execute(new RunnableC0718xi(this));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final IPluginReporter getPluginExtension() {
        return this.g;
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void pauseSession() {
        this.b.getClass();
        this.f.getClass();
        this.c.execute(new RunnableC0252fi(this));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void putAppEnvironmentValue(String str, String str2) {
        this.b.getClass();
        this.f.getClass();
        this.c.execute(new RunnableC0692wi(this, str, str2));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportAdRevenue(AdRevenue adRevenue) {
        this.b.h.a(adRevenue);
        this.f.getClass();
        this.c.execute(new RunnableC0355ji(this, adRevenue));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportAnr(Map<Thread, StackTraceElement[]> map) {
        this.b.j.a(map);
        this.f.getClass();
        this.c.execute(new RunnableC0614ti(this, CollectionUtils.getListFromMap(map)));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportECommerce(ECommerceEvent eCommerceEvent) {
        this.b.i.a(eCommerceEvent);
        this.f.getClass();
        this.c.execute(new RunnableC0407li(this, eCommerceEvent));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, Throwable th) {
        this.b.b.a(str);
        this.f.getClass();
        if (th == null) {
            th = new C0107a2();
            th.fillInStackTrace();
        }
        this.c.execute(new RunnableC0149bi(this, str, th));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str) {
        this.b.f797a.a(str);
        this.f.getClass();
        this.c.execute(new RunnableC0744yi(this, str));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportRevenue(Revenue revenue) {
        this.b.g.a(revenue);
        this.f.getClass();
        this.c.execute(new RunnableC0329ii(this, revenue));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportUnhandledException(Throwable th) {
        this.b.e.a(th);
        this.f.getClass();
        this.c.execute(new RunnableC0201di(this, th));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportUserProfile(UserProfile userProfile) {
        this.b.f.a(userProfile);
        this.f.getClass();
        this.c.execute(new RunnableC0304hi(this, userProfile));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void resumeSession() {
        this.b.getClass();
        this.f.getClass();
        this.c.execute(new RunnableC0226ei(this));
    }

    @Override // io.appmetrica.analytics.IReporter, io.appmetrica.analytics.IModuleReporter
    public final void sendEventsBuffer() {
        this.b.getClass();
        this.f.getClass();
        this.c.execute(new RunnableC0666vi(this));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void setDataSendingEnabled(boolean z) {
        this.b.getClass();
        this.f.getClass();
        this.c.execute(new RunnableC0433mi(this, z));
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void setSessionExtra(String str, byte[] bArr) {
        this.b.getClass();
        this.f.getClass();
        this.c.execute(new RunnableC0537qi(this, str, bArr));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void setUserProfileID(String str) {
        this.b.getClass();
        this.f.getClass();
        this.c.execute(new RunnableC0278gi(this, str));
    }

    public Ai(Context context, String str, B0 b0) {
        this(context, new Uh(), b0, new Ki(), ReporterConfig.newConfigBuilder(str).build());
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0504pb, io.appmetrica.analytics.impl.InterfaceC0607tb
    public final void a(C0620to c0620to) {
        this.b.d.a(c0620to);
        this.f.getClass();
        this.c.execute(new RunnableC0588si(this, c0620to));
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void reportAdRevenue(AdRevenue adRevenue, boolean z) {
        this.b.h.a(adRevenue);
        this.f.getClass();
        this.c.execute(new RunnableC0562ri(this, adRevenue, z));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str, String str2) {
        this.b.f797a.a(str);
        this.f.getClass();
        this.c.execute(new RunnableC0770zi(this, str, str2));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, String str2) {
        reportError(str, str2, null);
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, String str2, Throwable th) {
        this.b.c.a(str);
        this.f.getClass();
        this.c.execute(new RunnableC0175ci(this, str, str2, th));
    }

    public Ai(Context context, Uh uh, B0 b0, Ki ki, ReporterConfig reporterConfig) {
        this(context, uh, b0, ki, reporterConfig, new C0508pf(new C0381ki(b0, context, reporterConfig)));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0504pb, io.appmetrica.analytics.impl.InterfaceC0312i0
    public final void a(X x) {
        this.b.getClass();
        this.f.getClass();
        this.c.execute(new RunnableC0640ui(this, x));
    }

    public Ai(Context context, Uh uh, B0 b0, Ki ki, ReporterConfig reporterConfig, C0508pf c0508pf) {
        this.c = C0574s4.l().g().a();
        this.d = context;
        this.b = uh;
        this.f463a = b0;
        this.f = ki;
        this.e = reporterConfig;
        this.g = c0508pf;
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str, Map<String, Object> map) {
        this.b.f797a.a(str);
        this.f.getClass();
        this.c.execute(new RunnableC0123ai(this, str, CollectionUtils.getListFromMap(map)));
    }

    public final void a(ReporterConfig reporterConfig) {
        this.b.getClass();
        this.f.getClass();
        this.c.execute(new RunnableC0485oi(this, reporterConfig));
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void reportEvent(ModuleEvent moduleEvent) {
        this.b.getClass();
        this.f.getClass();
        this.c.execute(new RunnableC0511pi(this, moduleEvent));
    }
}
