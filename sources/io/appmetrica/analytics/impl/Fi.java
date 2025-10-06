package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Handler;
import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.ReporterConfig;
import io.appmetrica.analytics.coreutils.internal.ApiKeyUtils;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.logger.appmetrica.internal.ImportantLogger;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* loaded from: classes4.dex */
public final class Fi implements InterfaceC0583sb {

    /* renamed from: a  reason: collision with root package name */
    public final Context f449a;
    public final Vf b;
    public final Si c;
    public final Handler d;
    public final Xl e;
    public final Sc f;
    public final LinkedHashMap g;
    public final Kn h;
    public final List i;
    public Hc j;
    public K6 k;

    public Fi(Context context, Vf vf, Si si, Handler handler, Xl xl) {
        this.f449a = context;
        this.b = vf;
        this.c = si;
        this.d = handler;
        this.e = xl;
        this.f = new Sc(context, vf, si, xl);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.g = linkedHashMap;
        this.h = new Kn(new Hi(linkedHashMap));
        this.i = CollectionsKt.listOf((Object[]) new String[]{"20799a27-fa80-4b36-b2db-0f8141f24180", "0e5e9c33-f8c3-4568-86c5-2e4f57523f72"});
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0583sb, io.appmetrica.analytics.impl.InterfaceC0608tb
    public final InterfaceC0583sb a() {
        return this;
    }

    public final Fi b() {
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0583sb
    /* renamed from: c */
    public final synchronized Hc b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0368k0 c0368k0) {
        Hc hc;
        hc = this.j;
        if (hc == null) {
            this.h.a(appMetricaConfig.apiKey);
            this.f.a(appMetricaConfig, publicLogger);
            hc = new Hc(this.f);
            hc.i = new Ob(this.d, hc);
            Xl xl = this.e;
            C0154bi c0154bi = hc.b;
            if (xl != null) {
                c0154bi.b.setUuid(xl.g());
            } else {
                c0154bi.getClass();
            }
            hc.a(appMetricaConfig, c0368k0);
            hc.k();
            this.c.f.c = new Ei(hc);
            this.g.put(appMetricaConfig.apiKey, hc);
            this.j = hc;
        }
        return hc;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0583sb
    /* renamed from: d */
    public final synchronized Hc a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0368k0 c0368k0) {
        Hc hc;
        hc = this.j;
        if (hc != null) {
            this.f.a(appMetricaConfig, publicLogger);
            hc.a(appMetricaConfig, c0368k0);
            A4.l().getClass();
            this.g.put(appMetricaConfig.apiKey, hc);
        } else {
            this.h.a(appMetricaConfig.apiKey);
            this.f.a(appMetricaConfig, publicLogger);
            hc = new Hc(this.f);
            hc.i = new Ob(this.d, hc);
            Xl xl = this.e;
            C0154bi c0154bi = hc.b;
            if (xl != null) {
                c0154bi.b.setUuid(xl.g());
            } else {
                c0154bi.getClass();
            }
            hc.a(appMetricaConfig, c0368k0);
            hc.k();
            this.c.f.c = new Ei(hc);
            this.g.put(appMetricaConfig.apiKey, hc);
            A4.l().getClass();
            this.j = hc;
        }
        return hc;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0583sb
    public final synchronized InterfaceC0558rb b(ReporterConfig reporterConfig) {
        Yc yc;
        InterfaceC0558rb interfaceC0558rb = (InterfaceC0558rb) this.g.get(reporterConfig.apiKey);
        yc = interfaceC0558rb;
        if (interfaceC0558rb == null) {
            if (!this.i.contains(reporterConfig.apiKey)) {
                this.e.i();
            }
            Context context = this.f449a;
            Yc yc2 = new Yc(context, this.b, reporterConfig, this.c, new C0430ma(context));
            yc2.i = new Ob(this.d, yc2);
            Xl xl = this.e;
            C0154bi c0154bi = yc2.b;
            if (xl != null) {
                c0154bi.b.setUuid(xl.g());
            } else {
                c0154bi.getClass();
            }
            yc2.k();
            this.g.put(reporterConfig.apiKey, yc2);
            yc = yc2;
        }
        return yc;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0583sb
    public final synchronized void a(ReporterConfig reporterConfig) {
        if (this.g.containsKey(reporterConfig.apiKey)) {
            LoggerStorage.getOrCreatePublicLogger(reporterConfig.apiKey).warning("Reporter with apiKey=%s already exists.", ApiKeyUtils.createPartialApiKey(reporterConfig.apiKey));
        } else {
            b(reporterConfig);
            ImportantLogger.INSTANCE.info("AppMetrica", "Activate reporter with APIKey " + ApiKeyUtils.createPartialApiKey(reporterConfig.apiKey), new Object[0]);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0583sb
    public final synchronized InterfaceC0633ub a(AppMetricaConfig appMetricaConfig) {
        K6 k6;
        k6 = this.k;
        if (k6 != null) {
            k6.a(appMetricaConfig);
        } else {
            K6 k62 = new K6(new L6(this.b, this.f.e, this.c, appMetricaConfig));
            this.k = k62;
            k6 = k62;
        }
        return k6;
    }
}
