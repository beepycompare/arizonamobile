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
public final class C0355ji implements Sa {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1066a;
    public final Bf b;
    public final C0680wi c;
    public final Handler d;
    public final Ol e;
    public final C0574sc f;
    public final LinkedHashMap g;
    public final En h;
    public final List i;
    public C0298hc j;
    public C0394l6 k;

    public C0355ji(Context context, Bf bf, C0680wi c0680wi, Handler handler, Ol ol) {
        this.f1066a = context;
        this.b = bf;
        this.c = c0680wi;
        this.d = handler;
        this.e = ol;
        this.f = new C0574sc(context, bf, c0680wi, ol);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.g = linkedHashMap;
        this.h = new En(new C0406li(linkedHashMap));
        this.i = CollectionsKt.listOf((Object[]) new String[]{"20799a27-fa80-4b36-b2db-0f8141f24180", "0e5e9c33-f8c3-4568-86c5-2e4f57523f72"});
    }

    @Override // io.appmetrica.analytics.impl.Sa, io.appmetrica.analytics.impl.Ta
    public final Sa a() {
        return this;
    }

    public final C0355ji b() {
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Sa
    /* renamed from: c */
    public final synchronized C0298hc b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0388l0 c0388l0) {
        C0298hc c0298hc;
        c0298hc = this.j;
        if (c0298hc != null) {
            C0574sc c0574sc = this.f;
            c0574sc.getClass();
            publicLogger.info("Update anonymous config with value " + appMetricaConfig.toJson(), new Object[0]);
            c0574sc.f.b.applyFromAnonymousConfig(appMetricaConfig);
        } else {
            this.h.a(appMetricaConfig.apiKey);
            C0574sc c0574sc2 = this.f;
            c0574sc2.getClass();
            publicLogger.info("Update anonymous config with value " + appMetricaConfig.toJson(), new Object[0]);
            c0574sc2.f.b.applyFromAnonymousConfig(appMetricaConfig);
            c0298hc = new C0298hc(this.f);
            c0298hc.i = new C0474ob(this.d, c0298hc);
            Ol ol = this.e;
            Fh fh = c0298hc.b;
            if (ol != null) {
                fh.b.setUuid(ol.g());
            } else {
                fh.getClass();
            }
            c0298hc.a(appMetricaConfig, c0388l0);
            c0298hc.k();
            this.c.f.c = new C0329ii(c0298hc);
            this.g.put(appMetricaConfig.apiKey, c0298hc);
            this.j = c0298hc;
        }
        return c0298hc;
    }

    @Override // io.appmetrica.analytics.impl.Sa
    /* renamed from: d */
    public final synchronized C0298hc a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0388l0 c0388l0) {
        C0298hc c0298hc;
        c0298hc = this.j;
        if (c0298hc != null) {
            this.f.a(appMetricaConfig, publicLogger);
            c0298hc.a(appMetricaConfig, c0388l0);
            C0135b4.l().getClass();
            this.g.put(appMetricaConfig.apiKey, c0298hc);
        } else {
            this.h.a(appMetricaConfig.apiKey);
            this.f.a(appMetricaConfig, publicLogger);
            c0298hc = new C0298hc(this.f);
            c0298hc.i = new C0474ob(this.d, c0298hc);
            Ol ol = this.e;
            Fh fh = c0298hc.b;
            if (ol != null) {
                fh.b.setUuid(ol.g());
            } else {
                fh.getClass();
            }
            c0298hc.a(appMetricaConfig, c0388l0);
            c0298hc.k();
            this.c.f.c = new C0329ii(c0298hc);
            this.g.put(appMetricaConfig.apiKey, c0298hc);
            C0135b4.l().getClass();
            this.j = c0298hc;
        }
        return c0298hc;
    }

    @Override // io.appmetrica.analytics.impl.Sa
    public final synchronized Ra b(ReporterConfig reporterConfig) {
        C0724yc c0724yc;
        Ra ra = (Ra) this.g.get(reporterConfig.apiKey);
        c0724yc = ra;
        if (ra == null) {
            if (!this.i.contains(reporterConfig.apiKey)) {
                this.e.i();
            }
            Context context = this.f1066a;
            C0724yc c0724yc2 = new C0724yc(context, this.b, reporterConfig, this.c, new M9(context));
            c0724yc2.i = new C0474ob(this.d, c0724yc2);
            Ol ol = this.e;
            Fh fh = c0724yc2.b;
            if (ol != null) {
                fh.b.setUuid(ol.g());
            } else {
                fh.getClass();
            }
            c0724yc2.k();
            this.g.put(reporterConfig.apiKey, c0724yc2);
            c0724yc = c0724yc2;
        }
        return c0724yc;
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
        C0394l6 c0394l6;
        c0394l6 = this.k;
        if (c0394l6 != null) {
            c0394l6.a(appMetricaConfig);
        } else {
            C0394l6 c0394l62 = new C0394l6(new C0419m6(this.b, this.f.e, this.c, appMetricaConfig));
            this.k = c0394l62;
            c0394l6 = c0394l62;
        }
        return c0394l6;
    }
}
