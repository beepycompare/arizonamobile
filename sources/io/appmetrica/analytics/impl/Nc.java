package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.PreloadInfo;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes4.dex */
public final class Nc {

    /* renamed from: a  reason: collision with root package name */
    public final Context f563a;
    public final Ji b;
    public final Qd c;
    public final C0307ha d;
    public final W8 e;
    public final Sh f;
    public final C0373k2 g;
    public final M6 h;
    public final C0495p i;
    public final Xe j;
    public final On k;
    public final Rg l;
    public final Q6 m;
    public final C0143b0 n;

    public Nc(Context context, Pf pf, Ji ji, Ol ol) {
        this.f563a = context;
        this.b = ji;
        this.c = new Qd(pf);
        C0307ha c0307ha = new C0307ha(context);
        this.d = c0307ha;
        W8 w8 = new W8(new C0566rl(LoggerStorage.getMainPublicOrAnonymousLogger(), "Crash Environment"));
        this.e = w8;
        this.f = new Sh(pf, new CounterConfiguration(CounterConfigurationReporterType.MAIN), w8);
        this.g = new C0373k2();
        this.h = C0699x4.l().n();
        this.i = new C0495p();
        this.j = new Xe(c0307ha);
        this.k = new On();
        this.l = new Rg();
        this.m = new Q6();
        this.n = new C0143b0();
    }

    public final C0143b0 a() {
        return this.n;
    }

    public final Context b() {
        return this.f563a;
    }

    public final Q6 c() {
        return this.m;
    }

    public final C0307ha d() {
        return this.d;
    }

    public final Xe e() {
        return this.j;
    }

    public final M6 f() {
        return this.h;
    }

    public final Rg g() {
        return this.l;
    }

    public final Sh h() {
        return this.f;
    }

    public final Ji i() {
        return this.b;
    }

    public final On j() {
        return this.k;
    }

    public final void a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger) {
        this.f.b.applyFromConfig(appMetricaConfig);
        Sh sh = this.f;
        String str = appMetricaConfig.userProfileID;
        synchronized (sh) {
            sh.f = str;
        }
        Sh sh2 = this.f;
        PreloadInfo preloadInfo = appMetricaConfig.preloadInfo;
        Boolean bool = (Boolean) appMetricaConfig.additionalConfig.get("YMM_preloadInfoAutoTracking");
        sh2.d = new If(preloadInfo, publicLogger, bool != null ? bool.booleanValue() : false);
        StringBuilder sb = new StringBuilder("Actual session timeout is ");
        Integer num = appMetricaConfig.sessionTimeout;
        if (num == null) {
            num = 10;
        }
        publicLogger.info(sb.append(num.intValue()).toString(), new Object[0]);
    }
}
