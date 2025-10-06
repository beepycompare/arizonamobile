package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.PreloadInfo;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes4.dex */
public final class Sc {

    /* renamed from: a  reason: collision with root package name */
    public final Context f671a;
    public final Si b;
    public final Wd c;
    public final C0430ma d;
    public final C0145b9 e;
    public final C0154bi f;
    public final C0422m2 g;
    public final Q6 h;
    public final C0497p i;
    public final C0203df j;
    public final Xn k;
    public final C0127ah l;
    public final U6 m;
    public final C0162c0 n;

    public Sc(Context context, Vf vf, Si si, Xl xl) {
        this.f671a = context;
        this.b = si;
        this.c = new Wd(vf);
        C0430ma c0430ma = new C0430ma(context);
        this.d = c0430ma;
        C0145b9 c0145b9 = new C0145b9(new Al(LoggerStorage.getMainPublicOrAnonymousLogger(), "Crash Environment"));
        this.e = c0145b9;
        this.f = new C0154bi(vf, new CounterConfiguration(CounterConfigurationReporterType.MAIN), c0145b9);
        this.g = new C0422m2();
        this.h = A4.l().n();
        this.i = new C0497p();
        this.j = new C0203df(c0430ma);
        this.k = new Xn();
        this.l = new C0127ah();
        this.m = new U6();
        this.n = new C0162c0();
    }

    public final C0162c0 a() {
        return this.n;
    }

    public final Context b() {
        return this.f671a;
    }

    public final U6 c() {
        return this.m;
    }

    public final C0430ma d() {
        return this.d;
    }

    public final C0203df e() {
        return this.j;
    }

    public final Q6 f() {
        return this.h;
    }

    public final C0127ah g() {
        return this.l;
    }

    public final C0154bi h() {
        return this.f;
    }

    public final Si i() {
        return this.b;
    }

    public final Xn j() {
        return this.k;
    }

    public final void a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger) {
        this.f.b.applyFromConfig(appMetricaConfig);
        C0154bi c0154bi = this.f;
        String str = appMetricaConfig.userProfileID;
        synchronized (c0154bi) {
            c0154bi.f = str;
        }
        C0154bi c0154bi2 = this.f;
        PreloadInfo preloadInfo = appMetricaConfig.preloadInfo;
        Boolean bool = (Boolean) appMetricaConfig.additionalConfig.get("YMM_preloadInfoAutoTracking");
        c0154bi2.d = new Of(preloadInfo, publicLogger, bool != null ? bool.booleanValue() : false);
        StringBuilder sb = new StringBuilder("Actual session timeout is ");
        Integer num = appMetricaConfig.sessionTimeout;
        if (num == null) {
            num = 10;
        }
        publicLogger.info(sb.append(num.intValue()).toString(), new Object[0]);
    }
}
