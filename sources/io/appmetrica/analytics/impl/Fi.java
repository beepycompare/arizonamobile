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
public final class Fi implements InterfaceC0582sb {

    /* renamed from: a  reason: collision with root package name */
    public final Context f448a;
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
        this.f448a = context;
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

    @Override // io.appmetrica.analytics.impl.InterfaceC0582sb, io.appmetrica.analytics.impl.InterfaceC0607tb
    public final InterfaceC0582sb a() {
        return this;
    }

    public final Fi b() {
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0582sb
    /* renamed from: c */
    public final synchronized Hc b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0367k0 c0367k0) {
        Hc hc;
        hc = this.j;
        if (hc == null) {
            this.h.a(appMetricaConfig.apiKey);
            this.f.a(appMetricaConfig, publicLogger);
            hc = new Hc(this.f);
            hc.i = new Ob(this.d, hc);
            Xl xl = this.e;
            C0153bi c0153bi = hc.b;
            if (xl != null) {
                c0153bi.b.setUuid(xl.g());
            } else {
                c0153bi.getClass();
            }
            hc.a(appMetricaConfig, c0367k0);
            hc.k();
            this.c.f.c = new Ei(hc);
            this.g.put(appMetricaConfig.apiKey, hc);
            this.j = hc;
        }
        return hc;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0582sb
    /* renamed from: d */
    public final synchronized Hc a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0367k0 c0367k0) {
        Hc hc;
        hc = this.j;
        if (hc != null) {
            this.f.a(appMetricaConfig, publicLogger);
            hc.a(appMetricaConfig, c0367k0);
            A4.l().getClass();
            this.g.put(appMetricaConfig.apiKey, hc);
        } else {
            this.h.a(appMetricaConfig.apiKey);
            this.f.a(appMetricaConfig, publicLogger);
            hc = new Hc(this.f);
            hc.i = new Ob(this.d, hc);
            Xl xl = this.e;
            C0153bi c0153bi = hc.b;
            if (xl != null) {
                c0153bi.b.setUuid(xl.g());
            } else {
                c0153bi.getClass();
            }
            hc.a(appMetricaConfig, c0367k0);
            hc.k();
            this.c.f.c = new Ei(hc);
            this.g.put(appMetricaConfig.apiKey, hc);
            A4.l().getClass();
            this.j = hc;
        }
        return hc;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0582sb
    public final synchronized InterfaceC0557rb b(ReporterConfig reporterConfig) {
        Yc yc;
        InterfaceC0557rb interfaceC0557rb = (InterfaceC0557rb) this.g.get(reporterConfig.apiKey);
        yc = interfaceC0557rb;
        if (interfaceC0557rb == null) {
            if (!this.i.contains(reporterConfig.apiKey)) {
                this.e.i();
            }
            Context context = this.f448a;
            Yc yc2 = new Yc(context, this.b, reporterConfig, this.c, new C0429ma(context));
            yc2.i = new Ob(this.d, yc2);
            Xl xl = this.e;
            C0153bi c0153bi = yc2.b;
            if (xl != null) {
                c0153bi.b.setUuid(xl.g());
            } else {
                c0153bi.getClass();
            }
            yc2.k();
            this.g.put(reporterConfig.apiKey, yc2);
            yc = yc2;
        }
        return yc;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0582sb
    public final synchronized void a(ReporterConfig reporterConfig) {
        if (this.g.containsKey(reporterConfig.apiKey)) {
            LoggerStorage.getOrCreatePublicLogger(reporterConfig.apiKey).warning("Reporter with apiKey=%s already exists.", ApiKeyUtils.createPartialApiKey(reporterConfig.apiKey));
        } else {
            b(reporterConfig);
            ImportantLogger.INSTANCE.info("AppMetrica", "Activate reporter with APIKey " + ApiKeyUtils.createPartialApiKey(reporterConfig.apiKey), new Object[0]);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0582sb
    public final synchronized InterfaceC0632ub a(AppMetricaConfig appMetricaConfig) {
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
