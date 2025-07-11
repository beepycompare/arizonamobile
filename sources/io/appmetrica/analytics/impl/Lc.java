package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.PreloadInfo;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes4.dex */
public final class Lc {

    /* renamed from: a  reason: collision with root package name */
    public final Context f518a;
    public final Gi b;
    public final Od c;
    public final C0254fa d;
    public final T8 e;
    public final Qh f;
    public final C0370k2 g;
    public final J6 h;
    public final C0492p i;
    public final Ve j;
    public final Ln k;
    public final Pg l;
    public final N6 m;
    public final C0142b0 n;

    public Lc(Context context, Nf nf, Gi gi, Ll ll) {
        this.f518a = context;
        this.b = gi;
        this.c = new Od(nf);
        C0254fa c0254fa = new C0254fa(context);
        this.d = c0254fa;
        T8 t8 = new T8(new C0489ol(LoggerStorage.getMainPublicOrAnonymousLogger(), "Crash Environment"));
        this.e = t8;
        this.f = new Qh(nf, new CounterConfiguration(CounterConfigurationReporterType.MAIN), t8);
        this.g = new C0370k2();
        this.h = C0696x4.l().n();
        this.i = new C0492p();
        this.j = new Ve(c0254fa);
        this.k = new Ln();
        this.l = new Pg();
        this.m = new N6();
        this.n = new C0142b0();
    }

    public final C0142b0 a() {
        return this.n;
    }

    public final Context b() {
        return this.f518a;
    }

    public final N6 c() {
        return this.m;
    }

    public final C0254fa d() {
        return this.d;
    }

    public final Ve e() {
        return this.j;
    }

    public final J6 f() {
        return this.h;
    }

    public final Pg g() {
        return this.l;
    }

    public final Qh h() {
        return this.f;
    }

    public final Gi i() {
        return this.b;
    }

    public final Ln j() {
        return this.k;
    }

    public final void a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger) {
        this.f.b.applyFromConfig(appMetricaConfig);
        Qh qh = this.f;
        String str = appMetricaConfig.userProfileID;
        synchronized (qh) {
            qh.f = str;
        }
        Qh qh2 = this.f;
        PreloadInfo preloadInfo = appMetricaConfig.preloadInfo;
        Boolean bool = (Boolean) appMetricaConfig.additionalConfig.get("YMM_preloadInfoAutoTracking");
        qh2.d = new Gf(preloadInfo, publicLogger, bool != null ? bool.booleanValue() : false);
        StringBuilder sb = new StringBuilder("Actual session timeout is ");
        Integer num = appMetricaConfig.sessionTimeout;
        if (num == null) {
            num = 10;
        }
        publicLogger.info(sb.append(num.intValue()).toString(), new Object[0]);
    }
}
