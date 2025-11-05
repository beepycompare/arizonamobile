package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.PreloadInfo;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.zc  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0747zc {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1229a;
    public final Bi b;
    public final Id c;
    public final T9 d;
    public final I8 e;
    public final Kh f;
    public final C0438n2 g;
    public final C0716y6 h;
    public final C0510q i;
    public final Oe j;
    public final Tn k;
    public final Jg l;
    public final C6 m;
    public final C0180d0 n;

    public C0747zc(Context context, Gf gf, Bi bi, Sl sl) {
        this.f1229a = context;
        this.b = bi;
        this.c = new Id(gf);
        T9 t9 = new T9(context);
        this.d = t9;
        I8 i8 = new I8(new C0656vl(LoggerStorage.getMainPublicOrAnonymousLogger(), "Crash Environment"));
        this.e = i8;
        this.f = new Kh(gf, new CounterConfiguration(CounterConfigurationReporterType.MAIN), i8);
        this.g = new C0438n2();
        this.h = C0338j4.l().n();
        this.i = new C0510q();
        this.j = new Oe(t9);
        this.k = new Tn();
        this.l = new Jg();
        this.m = new C6();
        this.n = new C0180d0();
    }

    public final C0180d0 a() {
        return this.n;
    }

    public final Context b() {
        return this.f1229a;
    }

    public final C6 c() {
        return this.m;
    }

    public final T9 d() {
        return this.d;
    }

    public final Oe e() {
        return this.j;
    }

    public final C0716y6 f() {
        return this.h;
    }

    public final Jg g() {
        return this.l;
    }

    public final Kh h() {
        return this.f;
    }

    public final Bi i() {
        return this.b;
    }

    public final Tn j() {
        return this.k;
    }

    public final void a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger) {
        publicLogger.info("Update config with value " + appMetricaConfig.toJson(), new Object[0]);
        this.f.b.applyFromConfig(appMetricaConfig);
        Kh kh = this.f;
        String str = appMetricaConfig.userProfileID;
        synchronized (kh) {
            kh.f = str;
        }
        Kh kh2 = this.f;
        PreloadInfo preloadInfo = appMetricaConfig.preloadInfo;
        Boolean bool = (Boolean) appMetricaConfig.additionalConfig.get("YMM_preloadInfoAutoTracking");
        kh2.d = new C0750zf(preloadInfo, publicLogger, bool != null ? bool.booleanValue() : false);
        StringBuilder sb = new StringBuilder("Actual session timeout is ");
        Integer num = appMetricaConfig.sessionTimeout;
        if (num == null) {
            num = 10;
        }
        publicLogger.info(sb.append(num.intValue()).toString(), new Object[0]);
    }
}
