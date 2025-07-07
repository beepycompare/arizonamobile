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
/* renamed from: io.appmetrica.analytics.impl.ui  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0643ui implements InterfaceC0412lb {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1077a;
    public final Nf b;
    public final Gi c;
    public final Handler d;
    public final Ll e;
    public final Lc f;
    public final LinkedHashMap g;
    public final C0748yn h;
    public final List i;
    public Ac j;
    public E6 k;

    public C0643ui(Context context, Nf nf, Gi gi, Handler handler, Ll ll) {
        this.f1077a = context;
        this.b = nf;
        this.c = gi;
        this.d = handler;
        this.e = ll;
        this.f = new Lc(context, nf, gi, ll);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.g = linkedHashMap;
        this.h = new C0748yn(new C0693wi(linkedHashMap));
        this.i = CollectionsKt.listOf((Object[]) new String[]{"20799a27-fa80-4b36-b2db-0f8141f24180", "0e5e9c33-f8c3-4568-86c5-2e4f57523f72"});
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0412lb, io.appmetrica.analytics.impl.InterfaceC0437mb
    public final InterfaceC0412lb a() {
        return this;
    }

    public final C0643ui b() {
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0412lb
    /* renamed from: c */
    public final synchronized Ac a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, boolean z) {
        Ac ac;
        ac = this.j;
        if (ac == null) {
            this.h.a(appMetricaConfig.apiKey);
            this.f.a(appMetricaConfig, publicLogger);
            ac = new Ac(this.f);
            ac.i = new Hb(this.d, ac);
            Ll ll = this.e;
            Qh qh = ac.b;
            if (ll != null) {
                qh.b.setUuid(ll.g());
            } else {
                qh.getClass();
            }
            ac.a(appMetricaConfig, z);
            ac.k();
            this.c.f.c = new C0618ti(ac);
            this.g.put(appMetricaConfig.apiKey, ac);
            this.j = ac;
        }
        return ac;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0412lb
    /* renamed from: d */
    public final synchronized Ac b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, boolean z) {
        Ac ac;
        ac = this.j;
        if (ac != null) {
            this.f.a(appMetricaConfig, publicLogger);
            ac.a(appMetricaConfig, z);
            C0704x4.l().getClass();
            this.g.put(appMetricaConfig.apiKey, ac);
        } else {
            this.h.a(appMetricaConfig.apiKey);
            this.f.a(appMetricaConfig, publicLogger);
            ac = new Ac(this.f);
            ac.i = new Hb(this.d, ac);
            Ll ll = this.e;
            Qh qh = ac.b;
            if (ll != null) {
                qh.b.setUuid(ll.g());
            } else {
                qh.getClass();
            }
            ac.a(appMetricaConfig, z);
            ac.k();
            this.c.f.c = new C0618ti(ac);
            this.g.put(appMetricaConfig.apiKey, ac);
            C0704x4.l().getClass();
            this.j = ac;
        }
        return ac;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0412lb
    public final synchronized InterfaceC0387kb b(ReporterConfig reporterConfig) {
        Rc rc;
        InterfaceC0387kb interfaceC0387kb = (InterfaceC0387kb) this.g.get(reporterConfig.apiKey);
        rc = interfaceC0387kb;
        if (interfaceC0387kb == null) {
            if (!this.i.contains(reporterConfig.apiKey)) {
                this.e.i();
            }
            Context context = this.f1077a;
            Rc rc2 = new Rc(context, this.b, reporterConfig, this.c, new C0262fa(context));
            rc2.i = new Hb(this.d, rc2);
            Ll ll = this.e;
            Qh qh = rc2.b;
            if (ll != null) {
                qh.b.setUuid(ll.g());
            } else {
                qh.getClass();
            }
            rc2.k();
            this.g.put(reporterConfig.apiKey, rc2);
            rc = rc2;
        }
        return rc;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0412lb
    public final synchronized void a(ReporterConfig reporterConfig) {
        if (this.g.containsKey(reporterConfig.apiKey)) {
            LoggerStorage.getOrCreatePublicLogger(reporterConfig.apiKey).warning("Reporter with apiKey=%s already exists.", ApiKeyUtils.createPartialApiKey(reporterConfig.apiKey));
        } else {
            b(reporterConfig);
            ImportantLogger.INSTANCE.info("AppMetrica", "Activate reporter with APIKey " + ApiKeyUtils.createPartialApiKey(reporterConfig.apiKey), new Object[0]);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0412lb
    public final synchronized InterfaceC0462nb a(AppMetricaConfig appMetricaConfig) {
        E6 e6;
        e6 = this.k;
        if (e6 != null) {
            e6.a(appMetricaConfig);
        } else {
            E6 e62 = new E6(new F6(this.b, this.f.e, this.c, appMetricaConfig));
            this.k = e62;
            e6 = e62;
        }
        return e6;
    }
}
