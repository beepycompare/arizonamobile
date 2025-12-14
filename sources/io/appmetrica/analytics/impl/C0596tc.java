package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.PreloadInfo;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.tc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0596tc {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1230a;
    public final C0702xi b;
    public final Cd c;
    public final N9 d;
    public final E8 e;
    public final Gh f;
    public final C0232f2 g;
    public final C0565s6 h;
    public final C0509q i;
    public final Ke j;
    public final Sn k;
    public final Fg l;
    public final C0665w6 m;
    public final C0179d0 n;

    public C0596tc(Context context, Cf cf, C0702xi c0702xi, Pl pl) {
        this.f1230a = context;
        this.b = c0702xi;
        this.c = new Cd(cf);
        N9 n9 = new N9(context);
        this.d = n9;
        E8 e8 = new E8(new C0580sl(LoggerStorage.getMainPublicOrAnonymousLogger(), "Crash Environment"));
        this.e = e8;
        this.f = new Gh(cf, new CounterConfiguration(CounterConfigurationReporterType.MAIN), e8);
        this.g = new C0232f2();
        this.h = C0157c4.l().n();
        this.i = new C0509q();
        this.j = new Ke(n9);
        this.k = new Sn();
        this.l = new Fg();
        this.m = new C0665w6();
        this.n = new C0179d0();
    }

    public final C0179d0 a() {
        return this.n;
    }

    public final Context b() {
        return this.f1230a;
    }

    public final C0665w6 c() {
        return this.m;
    }

    public final N9 d() {
        return this.d;
    }

    public final Ke e() {
        return this.j;
    }

    public final C0565s6 f() {
        return this.h;
    }

    public final Fg g() {
        return this.l;
    }

    public final Gh h() {
        return this.f;
    }

    public final C0702xi i() {
        return this.b;
    }

    public final Sn j() {
        return this.k;
    }

    public final void a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger) {
        publicLogger.info("Update config with value " + appMetricaConfig.toJson(), new Object[0]);
        this.f.b.applyFromConfig(appMetricaConfig);
        Gh gh = this.f;
        String str = appMetricaConfig.userProfileID;
        synchronized (gh) {
            gh.f = str;
        }
        Gh gh2 = this.f;
        PreloadInfo preloadInfo = appMetricaConfig.preloadInfo;
        Boolean bool = (Boolean) appMetricaConfig.additionalConfig.get("YMM_preloadInfoAutoTracking");
        gh2.d = new C0649vf(preloadInfo, publicLogger, bool != null ? bool.booleanValue() : false);
        StringBuilder sb = new StringBuilder("Actual session timeout is ");
        Integer num = appMetricaConfig.sessionTimeout;
        if (num == null) {
            num = 10;
        }
        publicLogger.info(sb.append(num.intValue()).toString(), new Object[0]);
    }
}
