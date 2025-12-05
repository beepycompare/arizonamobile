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
/* renamed from: io.appmetrica.analytics.impl.ki  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0377ki implements Ta {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1062a;
    public final Cf b;
    public final C0702xi c;
    public final Handler d;
    public final Pl e;
    public final C0596tc f;
    public final LinkedHashMap g;
    public final Fn h;
    public final List i;
    public C0320ic j;
    public C0416m6 k;

    public C0377ki(Context context, Cf cf, C0702xi c0702xi, Handler handler, Pl pl) {
        this.f1062a = context;
        this.b = cf;
        this.c = c0702xi;
        this.d = handler;
        this.e = pl;
        this.f = new C0596tc(context, cf, c0702xi, pl);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.g = linkedHashMap;
        this.h = new Fn(new C0428mi(linkedHashMap));
        this.i = CollectionsKt.listOf((Object[]) new String[]{"20799a27-fa80-4b36-b2db-0f8141f24180", "0e5e9c33-f8c3-4568-86c5-2e4f57523f72"});
    }

    @Override // io.appmetrica.analytics.impl.Ta, io.appmetrica.analytics.impl.Ua
    public final Ta a() {
        return this;
    }

    public final C0377ki b() {
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Ta
    /* renamed from: c */
    public final synchronized C0320ic b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0385l0 c0385l0) {
        C0320ic c0320ic;
        c0320ic = this.j;
        if (c0320ic != null) {
            C0596tc c0596tc = this.f;
            c0596tc.getClass();
            publicLogger.info("Update anonymous config with value " + appMetricaConfig.toJson(), new Object[0]);
            c0596tc.f.b.applyFromAnonymousConfig(appMetricaConfig);
        } else {
            this.h.a(appMetricaConfig.apiKey);
            C0596tc c0596tc2 = this.f;
            c0596tc2.getClass();
            publicLogger.info("Update anonymous config with value " + appMetricaConfig.toJson(), new Object[0]);
            c0596tc2.f.b.applyFromAnonymousConfig(appMetricaConfig);
            c0320ic = new C0320ic(this.f);
            c0320ic.i = new C0496pb(this.d, c0320ic);
            Pl pl = this.e;
            Gh gh = c0320ic.b;
            if (pl != null) {
                gh.b.setUuid(pl.g());
            } else {
                gh.getClass();
            }
            c0320ic.a(appMetricaConfig, c0385l0);
            c0320ic.k();
            this.c.f.c = new C0351ji(c0320ic);
            this.g.put(appMetricaConfig.apiKey, c0320ic);
            this.j = c0320ic;
        }
        return c0320ic;
    }

    @Override // io.appmetrica.analytics.impl.Ta
    /* renamed from: d */
    public final synchronized C0320ic a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0385l0 c0385l0) {
        C0320ic c0320ic;
        c0320ic = this.j;
        if (c0320ic != null) {
            this.f.a(appMetricaConfig, publicLogger);
            c0320ic.a(appMetricaConfig, c0385l0);
            C0157c4.l().getClass();
            this.g.put(appMetricaConfig.apiKey, c0320ic);
        } else {
            this.h.a(appMetricaConfig.apiKey);
            this.f.a(appMetricaConfig, publicLogger);
            c0320ic = new C0320ic(this.f);
            c0320ic.i = new C0496pb(this.d, c0320ic);
            Pl pl = this.e;
            Gh gh = c0320ic.b;
            if (pl != null) {
                gh.b.setUuid(pl.g());
            } else {
                gh.getClass();
            }
            c0320ic.a(appMetricaConfig, c0385l0);
            c0320ic.k();
            this.c.f.c = new C0351ji(c0320ic);
            this.g.put(appMetricaConfig.apiKey, c0320ic);
            C0157c4.l().getClass();
            this.j = c0320ic;
        }
        return c0320ic;
    }

    @Override // io.appmetrica.analytics.impl.Ta
    public final synchronized Sa b(ReporterConfig reporterConfig) {
        C0746zc c0746zc;
        Sa sa = (Sa) this.g.get(reporterConfig.apiKey);
        c0746zc = sa;
        if (sa == null) {
            if (!this.i.contains(reporterConfig.apiKey)) {
                this.e.i();
            }
            Context context = this.f1062a;
            C0746zc c0746zc2 = new C0746zc(context, this.b, reporterConfig, this.c, new N9(context));
            c0746zc2.i = new C0496pb(this.d, c0746zc2);
            Pl pl = this.e;
            Gh gh = c0746zc2.b;
            if (pl != null) {
                gh.b.setUuid(pl.g());
            } else {
                gh.getClass();
            }
            c0746zc2.k();
            this.g.put(reporterConfig.apiKey, c0746zc2);
            c0746zc = c0746zc2;
        }
        return c0746zc;
    }

    @Override // io.appmetrica.analytics.impl.Ta
    public final synchronized void a(ReporterConfig reporterConfig) {
        if (this.g.containsKey(reporterConfig.apiKey)) {
            LoggerStorage.getOrCreatePublicLogger(reporterConfig.apiKey).warning("Reporter with apiKey=%s already exists.", ApiKeyUtils.createPartialApiKey(reporterConfig.apiKey));
        } else {
            b(reporterConfig);
            ImportantLogger.INSTANCE.info("AppMetrica", "Activate reporter with APIKey " + ApiKeyUtils.createPartialApiKey(reporterConfig.apiKey), new Object[0]);
        }
    }

    @Override // io.appmetrica.analytics.impl.Ta
    public final synchronized Va a(AppMetricaConfig appMetricaConfig) {
        C0416m6 c0416m6;
        c0416m6 = this.k;
        if (c0416m6 != null) {
            c0416m6.a(appMetricaConfig);
        } else {
            C0416m6 c0416m62 = new C0416m6(new C0441n6(this.b, this.f.e, this.c, appMetricaConfig));
            this.k = c0416m62;
            c0416m6 = c0416m62;
        }
        return c0416m6;
    }
}
