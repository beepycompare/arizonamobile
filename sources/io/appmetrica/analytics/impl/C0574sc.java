package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.PreloadInfo;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.sc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0574sc {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1226a;
    public final C0680wi b;
    public final Bd c;
    public final M9 d;
    public final D8 e;
    public final Fh f;
    public final C0210e2 g;
    public final C0543r6 h;
    public final C0512q i;
    public final Je j;
    public final Rn k;
    public final Eg l;
    public final C0643v6 m;
    public final C0183d0 n;

    public C0574sc(Context context, Bf bf, C0680wi c0680wi, Ol ol) {
        this.f1226a = context;
        this.b = c0680wi;
        this.c = new Bd(bf);
        M9 m9 = new M9(context);
        this.d = m9;
        D8 d8 = new D8(new C0558rl(LoggerStorage.getMainPublicOrAnonymousLogger(), "Crash Environment"));
        this.e = d8;
        this.f = new Fh(bf, new CounterConfiguration(CounterConfigurationReporterType.MAIN), d8);
        this.g = new C0210e2();
        this.h = C0135b4.l().n();
        this.i = new C0512q();
        this.j = new Je(m9);
        this.k = new Rn();
        this.l = new Eg();
        this.m = new C0643v6();
        this.n = new C0183d0();
    }

    public final C0183d0 a() {
        return this.n;
    }

    public final Context b() {
        return this.f1226a;
    }

    public final C0643v6 c() {
        return this.m;
    }

    public final M9 d() {
        return this.d;
    }

    public final Je e() {
        return this.j;
    }

    public final C0543r6 f() {
        return this.h;
    }

    public final Eg g() {
        return this.l;
    }

    public final Fh h() {
        return this.f;
    }

    public final C0680wi i() {
        return this.b;
    }

    public final Rn j() {
        return this.k;
    }

    public final void a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger) {
        publicLogger.info("Update config with value " + appMetricaConfig.toJson(), new Object[0]);
        this.f.b.applyFromConfig(appMetricaConfig);
        Fh fh = this.f;
        String str = appMetricaConfig.userProfileID;
        synchronized (fh) {
            fh.f = str;
        }
        Fh fh2 = this.f;
        PreloadInfo preloadInfo = appMetricaConfig.preloadInfo;
        Boolean bool = (Boolean) appMetricaConfig.additionalConfig.get("YMM_preloadInfoAutoTracking");
        fh2.d = new C0627uf(preloadInfo, publicLogger, bool != null ? bool.booleanValue() : false);
        StringBuilder sb = new StringBuilder("Actual session timeout is ");
        Integer num = appMetricaConfig.sessionTimeout;
        if (num == null) {
            num = 10;
        }
        publicLogger.info(sb.append(num.intValue()).toString(), new Object[0]);
    }
}
