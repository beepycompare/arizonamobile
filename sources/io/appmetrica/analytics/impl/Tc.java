package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.PreloadInfo;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes5.dex */
public final class Tc {

    /* renamed from: a  reason: collision with root package name */
    public final Context f775a;
    public final Qi b;
    public final C0147be c;
    public final C0298ha d;
    public final W8 e;
    public final Zh f;
    public final C0548r2 g;
    public final J6 h;
    public final C0520q i;
    public final C0380kf j;
    public final C0648uo k;
    public final Ug l;
    public final N6 m;
    public final C0236f0 n;

    public Tc(Context context, C0175cg c0175cg, Qi qi, C0543qm c0543qm) {
        this.f775a = context;
        this.b = qi;
        this.c = new C0147be(c0175cg);
        C0298ha c0298ha = new C0298ha(context);
        this.d = c0298ha;
        W8 w8 = new W8(new Wl(LoggerStorage.getMainPublicOrAnonymousLogger(), "Crash Environment"));
        this.e = w8;
        this.f = new Zh(c0175cg, new CounterConfiguration(CounterConfigurationReporterType.MAIN), w8);
        this.g = new C0548r2();
        this.h = C0576s4.l().n();
        this.i = new C0520q();
        this.j = new C0380kf(c0298ha);
        this.k = new C0648uo();
        this.l = new Ug();
        this.m = new N6();
        this.n = new C0236f0();
    }

    public final C0236f0 a() {
        return this.n;
    }

    public final Context b() {
        return this.f775a;
    }

    public final N6 c() {
        return this.m;
    }

    public final C0298ha d() {
        return this.d;
    }

    public final C0380kf e() {
        return this.j;
    }

    public final J6 f() {
        return this.h;
    }

    public final Ug g() {
        return this.l;
    }

    public final Zh h() {
        return this.f;
    }

    public final Qi i() {
        return this.b;
    }

    public final C0648uo j() {
        return this.k;
    }

    public final void a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger) {
        publicLogger.info("Update anonymous config with value " + appMetricaConfig.toJson(), new Object[0]);
        this.f.b.applyFromAnonymousConfig(appMetricaConfig);
        Zh zh = this.f;
        String str = appMetricaConfig.userProfileID;
        synchronized (zh) {
            zh.f = str;
        }
        Zh zh2 = this.f;
        PreloadInfo preloadInfo = appMetricaConfig.preloadInfo;
        Boolean bool = (Boolean) appMetricaConfig.additionalConfig.get("YMM_preloadInfoAutoTracking");
        zh2.d = new Uf(preloadInfo, publicLogger, bool != null ? bool.booleanValue() : false);
    }

    public final void b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger) {
        publicLogger.info("Update config with value " + appMetricaConfig.toJson(), new Object[0]);
        this.f.b.applyFromConfig(appMetricaConfig);
        Zh zh = this.f;
        String str = appMetricaConfig.userProfileID;
        synchronized (zh) {
            zh.f = str;
        }
        Zh zh2 = this.f;
        PreloadInfo preloadInfo = appMetricaConfig.preloadInfo;
        Boolean bool = (Boolean) appMetricaConfig.additionalConfig.get("YMM_preloadInfoAutoTracking");
        zh2.d = new Uf(preloadInfo, publicLogger, bool != null ? bool.booleanValue() : false);
        StringBuilder sb = new StringBuilder("Actual session timeout is ");
        Integer num = appMetricaConfig.sessionTimeout;
        if (num == null) {
            num = 10;
        }
        publicLogger.info(sb.append(num.intValue()).toString(), new Object[0]);
    }
}
