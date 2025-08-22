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
public final class Bi implements InterfaceC0504pb {

    /* renamed from: a  reason: collision with root package name */
    public final Context f366a;
    public final Rf b;
    public final Oi c;
    public final Handler d;
    public final Tl e;
    public final Pc f;
    public final LinkedHashMap g;
    public final Gn h;
    public final List i;
    public Ec j;
    public H6 k;

    public Bi(Context context, Rf rf, Oi oi, Handler handler, Tl tl) {
        this.f366a = context;
        this.b = rf;
        this.c = oi;
        this.d = handler;
        this.e = tl;
        this.f = new Pc(context, rf, oi, tl);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.g = linkedHashMap;
        this.h = new Gn(new Di(linkedHashMap));
        this.i = CollectionsKt.listOf((Object[]) new String[]{"20799a27-fa80-4b36-b2db-0f8141f24180", "0e5e9c33-f8c3-4568-86c5-2e4f57523f72"});
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0504pb, io.appmetrica.analytics.impl.InterfaceC0529qb
    public final InterfaceC0504pb a() {
        return this;
    }

    public final Bi b() {
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0504pb
    /* renamed from: c */
    public final synchronized Ec a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, boolean z) {
        Ec ec;
        ec = this.j;
        if (ec == null) {
            this.h.a(appMetricaConfig.apiKey);
            this.f.a(appMetricaConfig, publicLogger);
            ec = new Ec(this.f);
            ec.i = new Lb(this.d, ec);
            Tl tl = this.e;
            Xh xh = ec.b;
            if (tl != null) {
                xh.b.setUuid(tl.g());
            } else {
                xh.getClass();
            }
            ec.a(appMetricaConfig, z);
            ec.k();
            this.c.f.c = new Ai(ec);
            this.g.put(appMetricaConfig.apiKey, ec);
            this.j = ec;
        }
        return ec;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0504pb
    /* renamed from: d */
    public final synchronized Ec b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, boolean z) {
        Ec ec;
        ec = this.j;
        if (ec != null) {
            this.f.a(appMetricaConfig, publicLogger);
            ec.a(appMetricaConfig, z);
            C0696x4.l().getClass();
            this.g.put(appMetricaConfig.apiKey, ec);
        } else {
            this.h.a(appMetricaConfig.apiKey);
            this.f.a(appMetricaConfig, publicLogger);
            ec = new Ec(this.f);
            ec.i = new Lb(this.d, ec);
            Tl tl = this.e;
            Xh xh = ec.b;
            if (tl != null) {
                xh.b.setUuid(tl.g());
            } else {
                xh.getClass();
            }
            ec.a(appMetricaConfig, z);
            ec.k();
            this.c.f.c = new Ai(ec);
            this.g.put(appMetricaConfig.apiKey, ec);
            C0696x4.l().getClass();
            this.j = ec;
        }
        return ec;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0504pb
    public final synchronized InterfaceC0479ob b(ReporterConfig reporterConfig) {
        Vc vc;
        InterfaceC0479ob interfaceC0479ob = (InterfaceC0479ob) this.g.get(reporterConfig.apiKey);
        vc = interfaceC0479ob;
        if (interfaceC0479ob == null) {
            if (!this.i.contains(reporterConfig.apiKey)) {
                this.e.i();
            }
            Context context = this.f366a;
            Vc vc2 = new Vc(context, this.b, reporterConfig, this.c, new C0351ja(context));
            vc2.i = new Lb(this.d, vc2);
            Tl tl = this.e;
            Xh xh = vc2.b;
            if (tl != null) {
                xh.b.setUuid(tl.g());
            } else {
                xh.getClass();
            }
            vc2.k();
            this.g.put(reporterConfig.apiKey, vc2);
            vc = vc2;
        }
        return vc;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0504pb
    public final synchronized void a(ReporterConfig reporterConfig) {
        if (this.g.containsKey(reporterConfig.apiKey)) {
            LoggerStorage.getOrCreatePublicLogger(reporterConfig.apiKey).warning("Reporter with apiKey=%s already exists.", ApiKeyUtils.createPartialApiKey(reporterConfig.apiKey));
        } else {
            b(reporterConfig);
            ImportantLogger.INSTANCE.info("AppMetrica", "Activate reporter with APIKey " + ApiKeyUtils.createPartialApiKey(reporterConfig.apiKey), new Object[0]);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0504pb
    public final synchronized InterfaceC0553rb a(AppMetricaConfig appMetricaConfig) {
        H6 h6;
        h6 = this.k;
        if (h6 != null) {
            h6.a(appMetricaConfig);
        } else {
            H6 h62 = new H6(new I6(this.b, this.f.e, this.c, appMetricaConfig));
            this.k = h62;
            h6 = h62;
        }
        return h6;
    }
}
