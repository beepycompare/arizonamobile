package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.PreloadInfo;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes4.dex */
public final class Pc {

    /* renamed from: a  reason: collision with root package name */
    public final Context f604a;
    public final Oi b;
    public final Sd c;
    public final C0351ja d;
    public final Y8 e;
    public final Xh f;
    public final C0369k2 g;
    public final N6 h;
    public final C0492p i;
    public final Ze j;
    public final Tn k;
    public final Wg l;
    public final R6 m;
    public final C0135b0 n;

    public Pc(Context context, Rf rf, Oi oi, Tl tl) {
        this.f604a = context;
        this.b = oi;
        this.c = new Sd(rf);
        C0351ja c0351ja = new C0351ja(context);
        this.d = c0351ja;
        Y8 y8 = new Y8(new C0688wl(LoggerStorage.getMainPublicOrAnonymousLogger(), "Crash Environment"));
        this.e = y8;
        this.f = new Xh(rf, new CounterConfiguration(CounterConfigurationReporterType.MAIN), y8);
        this.g = new C0369k2();
        this.h = C0696x4.l().n();
        this.i = new C0492p();
        this.j = new Ze(c0351ja);
        this.k = new Tn();
        this.l = new Wg();
        this.m = new R6();
        this.n = new C0135b0();
    }

    public final C0135b0 a() {
        return this.n;
    }

    public final Context b() {
        return this.f604a;
    }

    public final R6 c() {
        return this.m;
    }

    public final C0351ja d() {
        return this.d;
    }

    public final Ze e() {
        return this.j;
    }

    public final N6 f() {
        return this.h;
    }

    public final Wg g() {
        return this.l;
    }

    public final Xh h() {
        return this.f;
    }

    public final Oi i() {
        return this.b;
    }

    public final Tn j() {
        return this.k;
    }

    public final void a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger) {
        this.f.b.applyFromConfig(appMetricaConfig);
        Xh xh = this.f;
        String str = appMetricaConfig.userProfileID;
        synchronized (xh) {
            xh.f = str;
        }
        Xh xh2 = this.f;
        PreloadInfo preloadInfo = appMetricaConfig.preloadInfo;
        Boolean bool = (Boolean) appMetricaConfig.additionalConfig.get("YMM_preloadInfoAutoTracking");
        xh2.d = new Kf(preloadInfo, publicLogger, bool != null ? bool.booleanValue() : false);
        StringBuilder sb = new StringBuilder("Actual session timeout is ");
        Integer num = appMetricaConfig.sessionTimeout;
        if (num == null) {
            num = 10;
        }
        publicLogger.info(sb.append(num.intValue()).toString(), new Object[0]);
    }
}
