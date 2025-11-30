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
public final class C0378ki implements Ta {

    /* renamed from: a  reason: collision with root package name */
    public final Context f979a;
    public final Cf b;
    public final C0703xi c;
    public final Handler d;
    public final Pl e;
    public final C0597tc f;
    public final LinkedHashMap g;
    public final Fn h;
    public final List i;
    public C0321ic j;
    public C0417m6 k;

    public C0378ki(Context context, Cf cf, C0703xi c0703xi, Handler handler, Pl pl) {
        this.f979a = context;
        this.b = cf;
        this.c = c0703xi;
        this.d = handler;
        this.e = pl;
        this.f = new C0597tc(context, cf, c0703xi, pl);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.g = linkedHashMap;
        this.h = new Fn(new C0429mi(linkedHashMap));
        this.i = CollectionsKt.listOf((Object[]) new String[]{"20799a27-fa80-4b36-b2db-0f8141f24180", "0e5e9c33-f8c3-4568-86c5-2e4f57523f72"});
    }

    @Override // io.appmetrica.analytics.impl.Ta, io.appmetrica.analytics.impl.Ua
    public final Ta a() {
        return this;
    }

    public final C0378ki b() {
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Ta
    /* renamed from: c */
    public final synchronized C0321ic b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0386l0 c0386l0) {
        C0321ic c0321ic;
        c0321ic = this.j;
        if (c0321ic != null) {
            C0597tc c0597tc = this.f;
            c0597tc.getClass();
            publicLogger.info("Update anonymous config with value " + appMetricaConfig.toJson(), new Object[0]);
            c0597tc.f.b.applyFromAnonymousConfig(appMetricaConfig);
        } else {
            this.h.a(appMetricaConfig.apiKey);
            C0597tc c0597tc2 = this.f;
            c0597tc2.getClass();
            publicLogger.info("Update anonymous config with value " + appMetricaConfig.toJson(), new Object[0]);
            c0597tc2.f.b.applyFromAnonymousConfig(appMetricaConfig);
            c0321ic = new C0321ic(this.f);
            c0321ic.i = new C0497pb(this.d, c0321ic);
            Pl pl = this.e;
            Gh gh = c0321ic.b;
            if (pl != null) {
                gh.b.setUuid(pl.g());
            } else {
                gh.getClass();
            }
            c0321ic.a(appMetricaConfig, c0386l0);
            c0321ic.k();
            this.c.f.c = new C0352ji(c0321ic);
            this.g.put(appMetricaConfig.apiKey, c0321ic);
            this.j = c0321ic;
        }
        return c0321ic;
    }

    @Override // io.appmetrica.analytics.impl.Ta
    /* renamed from: d */
    public final synchronized C0321ic a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0386l0 c0386l0) {
        C0321ic c0321ic;
        c0321ic = this.j;
        if (c0321ic != null) {
            this.f.a(appMetricaConfig, publicLogger);
            c0321ic.a(appMetricaConfig, c0386l0);
            C0158c4.l().getClass();
            this.g.put(appMetricaConfig.apiKey, c0321ic);
        } else {
            this.h.a(appMetricaConfig.apiKey);
            this.f.a(appMetricaConfig, publicLogger);
            c0321ic = new C0321ic(this.f);
            c0321ic.i = new C0497pb(this.d, c0321ic);
            Pl pl = this.e;
            Gh gh = c0321ic.b;
            if (pl != null) {
                gh.b.setUuid(pl.g());
            } else {
                gh.getClass();
            }
            c0321ic.a(appMetricaConfig, c0386l0);
            c0321ic.k();
            this.c.f.c = new C0352ji(c0321ic);
            this.g.put(appMetricaConfig.apiKey, c0321ic);
            C0158c4.l().getClass();
            this.j = c0321ic;
        }
        return c0321ic;
    }

    @Override // io.appmetrica.analytics.impl.Ta
    public final synchronized Sa b(ReporterConfig reporterConfig) {
        C0747zc c0747zc;
        Sa sa = (Sa) this.g.get(reporterConfig.apiKey);
        c0747zc = sa;
        if (sa == null) {
            if (!this.i.contains(reporterConfig.apiKey)) {
                this.e.i();
            }
            Context context = this.f979a;
            C0747zc c0747zc2 = new C0747zc(context, this.b, reporterConfig, this.c, new N9(context));
            c0747zc2.i = new C0497pb(this.d, c0747zc2);
            Pl pl = this.e;
            Gh gh = c0747zc2.b;
            if (pl != null) {
                gh.b.setUuid(pl.g());
            } else {
                gh.getClass();
            }
            c0747zc2.k();
            this.g.put(reporterConfig.apiKey, c0747zc2);
            c0747zc = c0747zc2;
        }
        return c0747zc;
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
        C0417m6 c0417m6;
        c0417m6 = this.k;
        if (c0417m6 != null) {
            c0417m6.a(appMetricaConfig);
        } else {
            C0417m6 c0417m62 = new C0417m6(new C0442n6(this.b, this.f.e, this.c, appMetricaConfig));
            this.k = c0417m62;
            c0417m6 = c0417m62;
        }
        return c0417m6;
    }
}
