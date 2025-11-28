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
/* renamed from: io.appmetrica.analytics.impl.oi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0479oi implements Za {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1042a;
    public final Gf b;
    public final Bi c;
    public final Handler d;
    public final Sl e;
    public final C0747zc f;
    public final LinkedHashMap g;
    public final Gn h;
    public final List i;
    public C0473oc j;
    public C0566s6 k;

    public C0479oi(Context context, Gf gf, Bi bi, Handler handler, Sl sl) {
        this.f1042a = context;
        this.b = gf;
        this.c = bi;
        this.d = handler;
        this.e = sl;
        this.f = new C0747zc(context, gf, bi, sl);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.g = linkedHashMap;
        this.h = new Gn(new C0529qi(linkedHashMap));
        this.i = CollectionsKt.listOf((Object[]) new String[]{"20799a27-fa80-4b36-b2db-0f8141f24180", "0e5e9c33-f8c3-4568-86c5-2e4f57523f72"});
    }

    @Override // io.appmetrica.analytics.impl.Za, io.appmetrica.analytics.impl.InterfaceC0113ab
    public final Za a() {
        return this;
    }

    public final C0479oi b() {
        return this;
    }

    @Override // io.appmetrica.analytics.impl.Za
    /* renamed from: c */
    public final synchronized C0473oc b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0386l0 c0386l0) {
        C0473oc c0473oc;
        c0473oc = this.j;
        if (c0473oc != null) {
            C0747zc c0747zc = this.f;
            c0747zc.getClass();
            publicLogger.info("Update anonymous config with value " + appMetricaConfig.toJson(), new Object[0]);
            c0747zc.f.b.applyFromAnonymousConfig(appMetricaConfig);
        } else {
            this.h.a(appMetricaConfig.apiKey);
            C0747zc c0747zc2 = this.f;
            c0747zc2.getClass();
            publicLogger.info("Update anonymous config with value " + appMetricaConfig.toJson(), new Object[0]);
            c0747zc2.f.b.applyFromAnonymousConfig(appMetricaConfig);
            c0473oc = new C0473oc(this.f);
            c0473oc.i = new C0646vb(this.d, c0473oc);
            Sl sl = this.e;
            Kh kh = c0473oc.b;
            if (sl != null) {
                kh.b.setUuid(sl.g());
            } else {
                kh.getClass();
            }
            c0473oc.a(appMetricaConfig, c0386l0);
            c0473oc.k();
            this.c.f.c = new C0454ni(c0473oc);
            this.g.put(appMetricaConfig.apiKey, c0473oc);
            this.j = c0473oc;
        }
        return c0473oc;
    }

    @Override // io.appmetrica.analytics.impl.Za
    /* renamed from: d */
    public final synchronized C0473oc a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0386l0 c0386l0) {
        C0473oc c0473oc;
        c0473oc = this.j;
        if (c0473oc != null) {
            this.f.a(appMetricaConfig, publicLogger);
            c0473oc.a(appMetricaConfig, c0386l0);
            C0338j4.l().getClass();
            this.g.put(appMetricaConfig.apiKey, c0473oc);
        } else {
            this.h.a(appMetricaConfig.apiKey);
            this.f.a(appMetricaConfig, publicLogger);
            c0473oc = new C0473oc(this.f);
            c0473oc.i = new C0646vb(this.d, c0473oc);
            Sl sl = this.e;
            Kh kh = c0473oc.b;
            if (sl != null) {
                kh.b.setUuid(sl.g());
            } else {
                kh.getClass();
            }
            c0473oc.a(appMetricaConfig, c0386l0);
            c0473oc.k();
            this.c.f.c = new C0454ni(c0473oc);
            this.g.put(appMetricaConfig.apiKey, c0473oc);
            C0338j4.l().getClass();
            this.j = c0473oc;
        }
        return c0473oc;
    }

    @Override // io.appmetrica.analytics.impl.Za
    public final synchronized Ya b(ReporterConfig reporterConfig) {
        Fc fc;
        Ya ya = (Ya) this.g.get(reporterConfig.apiKey);
        fc = ya;
        if (ya == null) {
            if (!this.i.contains(reporterConfig.apiKey)) {
                this.e.i();
            }
            Context context = this.f1042a;
            Fc fc2 = new Fc(context, this.b, reporterConfig, this.c, new T9(context));
            fc2.i = new C0646vb(this.d, fc2);
            Sl sl = this.e;
            Kh kh = fc2.b;
            if (sl != null) {
                kh.b.setUuid(sl.g());
            } else {
                kh.getClass();
            }
            fc2.k();
            this.g.put(reporterConfig.apiKey, fc2);
            fc = fc2;
        }
        return fc;
    }

    @Override // io.appmetrica.analytics.impl.Za
    public final synchronized void a(ReporterConfig reporterConfig) {
        if (this.g.containsKey(reporterConfig.apiKey)) {
            LoggerStorage.getOrCreatePublicLogger(reporterConfig.apiKey).warning("Reporter with apiKey=%s already exists.", ApiKeyUtils.createPartialApiKey(reporterConfig.apiKey));
        } else {
            b(reporterConfig);
            ImportantLogger.INSTANCE.info("AppMetrica", "Activate reporter with APIKey " + ApiKeyUtils.createPartialApiKey(reporterConfig.apiKey), new Object[0]);
        }
    }

    @Override // io.appmetrica.analytics.impl.Za
    public final synchronized InterfaceC0139bb a(AppMetricaConfig appMetricaConfig) {
        C0566s6 c0566s6;
        c0566s6 = this.k;
        if (c0566s6 != null) {
            c0566s6.a(appMetricaConfig);
        } else {
            C0566s6 c0566s62 = new C0566s6(new C0591t6(this.b, this.f.e, this.c, appMetricaConfig));
            this.k = c0566s62;
            c0566s6 = c0566s62;
        }
        return c0566s6;
    }
}
