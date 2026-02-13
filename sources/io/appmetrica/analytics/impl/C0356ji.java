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
/* renamed from: io.appmetrica.analytics.impl.ji  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0356ji implements Sa {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1066a;
    public final Bf b;
    public final C0681wi c;
    public final Handler d;
    public final Ol e;
    public final C0575sc f;
    public final LinkedHashMap g;
    public final En h;
    public final List i;
    public C0299hc j;
    public C0395l6 k;

    public C0356ji(Context context, Bf bf, C0681wi c0681wi, Handler handler, Ol ol) {
        this.f1066a = context;
        this.b = bf;
        this.c = c0681wi;
        this.d = handler;
        this.e = ol;
        this.f = new C0575sc(context, bf, c0681wi, ol);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.g = linkedHashMap;
        this.h = new En(new C0407li(linkedHashMap));
        this.i = CollectionsKt.listOf((Object[]) new String[]{"20799a27-fa80-4b36-b2db-0f8141f24180", "0e5e9c33-f8c3-4568-86c5-2e4f57523f72"});
    }

    @Override // io.appmetrica.analytics.impl.Sa, io.appmetrica.analytics.impl.Ta
    public final Sa a() {
        return this;
    }

    public final C0356ji b() {
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Sa
    /* renamed from: c */
    public final synchronized C0299hc b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0389l0 c0389l0) {
        C0299hc c0299hc;
        c0299hc = this.j;
        if (c0299hc != null) {
            C0575sc c0575sc = this.f;
            c0575sc.getClass();
            publicLogger.info("Update anonymous config with value " + appMetricaConfig.toJson(), new Object[0]);
            c0575sc.f.b.applyFromAnonymousConfig(appMetricaConfig);
        } else {
            this.h.a(appMetricaConfig.apiKey);
            C0575sc c0575sc2 = this.f;
            c0575sc2.getClass();
            publicLogger.info("Update anonymous config with value " + appMetricaConfig.toJson(), new Object[0]);
            c0575sc2.f.b.applyFromAnonymousConfig(appMetricaConfig);
            c0299hc = new C0299hc(this.f);
            c0299hc.i = new C0475ob(this.d, c0299hc);
            Ol ol = this.e;
            Fh fh = c0299hc.b;
            if (ol != null) {
                fh.b.setUuid(ol.g());
            } else {
                fh.getClass();
            }
            c0299hc.a(appMetricaConfig, c0389l0);
            c0299hc.k();
            this.c.f.c = new C0330ii(c0299hc);
            this.g.put(appMetricaConfig.apiKey, c0299hc);
            this.j = c0299hc;
        }
        return c0299hc;
    }

    @Override // io.appmetrica.analytics.impl.Sa
    /* renamed from: d */
    public final synchronized C0299hc a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0389l0 c0389l0) {
        C0299hc c0299hc;
        c0299hc = this.j;
        if (c0299hc != null) {
            this.f.a(appMetricaConfig, publicLogger);
            c0299hc.a(appMetricaConfig, c0389l0);
            C0136b4.l().getClass();
            this.g.put(appMetricaConfig.apiKey, c0299hc);
        } else {
            this.h.a(appMetricaConfig.apiKey);
            this.f.a(appMetricaConfig, publicLogger);
            c0299hc = new C0299hc(this.f);
            c0299hc.i = new C0475ob(this.d, c0299hc);
            Ol ol = this.e;
            Fh fh = c0299hc.b;
            if (ol != null) {
                fh.b.setUuid(ol.g());
            } else {
                fh.getClass();
            }
            c0299hc.a(appMetricaConfig, c0389l0);
            c0299hc.k();
            this.c.f.c = new C0330ii(c0299hc);
            this.g.put(appMetricaConfig.apiKey, c0299hc);
            C0136b4.l().getClass();
            this.j = c0299hc;
        }
        return c0299hc;
    }

    @Override // io.appmetrica.analytics.impl.Sa
    public final synchronized Ra b(ReporterConfig reporterConfig) {
        C0725yc c0725yc;
        Ra ra = (Ra) this.g.get(reporterConfig.apiKey);
        c0725yc = ra;
        if (ra == null) {
            if (!this.i.contains(reporterConfig.apiKey)) {
                this.e.i();
            }
            Context context = this.f1066a;
            C0725yc c0725yc2 = new C0725yc(context, this.b, reporterConfig, this.c, new M9(context));
            c0725yc2.i = new C0475ob(this.d, c0725yc2);
            Ol ol = this.e;
            Fh fh = c0725yc2.b;
            if (ol != null) {
                fh.b.setUuid(ol.g());
            } else {
                fh.getClass();
            }
            c0725yc2.k();
            this.g.put(reporterConfig.apiKey, c0725yc2);
            c0725yc = c0725yc2;
        }
        return c0725yc;
    }

    @Override // io.appmetrica.analytics.impl.Sa
    public final synchronized void a(ReporterConfig reporterConfig) {
        if (this.g.containsKey(reporterConfig.apiKey)) {
            LoggerStorage.getOrCreatePublicLogger(reporterConfig.apiKey).warning("Reporter with apiKey=%s already exists.", ApiKeyUtils.createPartialApiKey(reporterConfig.apiKey));
        } else {
            b(reporterConfig);
            ImportantLogger.INSTANCE.info("AppMetrica", "Activate reporter with APIKey " + ApiKeyUtils.createPartialApiKey(reporterConfig.apiKey), new Object[0]);
        }
    }

    @Override // io.appmetrica.analytics.impl.Sa
    public final synchronized Ua a(AppMetricaConfig appMetricaConfig) {
        C0395l6 c0395l6;
        c0395l6 = this.k;
        if (c0395l6 != null) {
            c0395l6.a(appMetricaConfig);
        } else {
            C0395l6 c0395l62 = new C0395l6(new C0420m6(this.b, this.f.e, this.c, appMetricaConfig));
            this.k = c0395l62;
            c0395l6 = c0395l62;
        }
        return c0395l6;
    }
}
