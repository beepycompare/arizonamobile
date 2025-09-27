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
    public final C0429ma d;
    public final C0144b9 e;
    public final C0153bi f;
    public final C0421m2 g;
    public final Q6 h;
    public final C0496p i;
    public final C0202df j;
    public final Xn k;
    public final C0126ah l;
    public final U6 m;
    public final C0161c0 n;

    public Sc(Context context, Vf vf, Si si, Xl xl) {
        this.f671a = context;
        this.b = si;
        this.c = new Wd(vf);
        C0429ma c0429ma = new C0429ma(context);
        this.d = c0429ma;
        C0144b9 c0144b9 = new C0144b9(new Al(LoggerStorage.getMainPublicOrAnonymousLogger(), "Crash Environment"));
        this.e = c0144b9;
        this.f = new C0153bi(vf, new CounterConfiguration(CounterConfigurationReporterType.MAIN), c0144b9);
        this.g = new C0421m2();
        this.h = A4.l().n();
        this.i = new C0496p();
        this.j = new C0202df(c0429ma);
        this.k = new Xn();
        this.l = new C0126ah();
        this.m = new U6();
        this.n = new C0161c0();
    }

    public final C0161c0 a() {
        return this.n;
    }

    public final Context b() {
        return this.f671a;
    }

    public final U6 c() {
        return this.m;
    }

    public final C0429ma d() {
        return this.d;
    }

    public final C0202df e() {
        return this.j;
    }

    public final Q6 f() {
        return this.h;
    }

    public final C0126ah g() {
        return this.l;
    }

    public final C0153bi h() {
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
        C0153bi c0153bi = this.f;
        String str = appMetricaConfig.userProfileID;
        synchronized (c0153bi) {
            c0153bi.f = str;
        }
        C0153bi c0153bi2 = this.f;
        PreloadInfo preloadInfo = appMetricaConfig.preloadInfo;
        Boolean bool = (Boolean) appMetricaConfig.additionalConfig.get("YMM_preloadInfoAutoTracking");
        c0153bi2.d = new Of(preloadInfo, publicLogger, bool != null ? bool.booleanValue() : false);
        StringBuilder sb = new StringBuilder("Actual session timeout is ");
        Integer num = appMetricaConfig.sessionTimeout;
        if (num == null) {
            num = 10;
        }
        publicLogger.info(sb.append(num.intValue()).toString(), new Object[0]);
    }
}
