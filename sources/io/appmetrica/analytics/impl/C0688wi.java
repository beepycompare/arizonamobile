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
/* renamed from: io.appmetrica.analytics.impl.wi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0688wi implements InterfaceC0457nb {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1123a;
    public final Pf b;
    public final Ji c;
    public final Handler d;
    public final Ol e;
    public final Nc f;
    public final LinkedHashMap g;
    public final Bn h;
    public final List i;
    public Cc j;
    public H6 k;

    public C0688wi(Context context, Pf pf, Ji ji, Handler handler, Ol ol) {
        this.f1123a = context;
        this.b = pf;
        this.c = ji;
        this.d = handler;
        this.e = ol;
        this.f = new Nc(context, pf, ji, ol);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.g = linkedHashMap;
        this.h = new Bn(new C0738yi(linkedHashMap));
        this.i = CollectionsKt.listOf((Object[]) new String[]{"20799a27-fa80-4b36-b2db-0f8141f24180", "0e5e9c33-f8c3-4568-86c5-2e4f57523f72"});
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0457nb, io.appmetrica.analytics.impl.InterfaceC0482ob
    public final InterfaceC0457nb a() {
        return this;
    }

    public final C0688wi b() {
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0457nb
    /* renamed from: c */
    public final synchronized Cc a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, boolean z) {
        Cc cc;
        cc = this.j;
        if (cc == null) {
            this.h.a(appMetricaConfig.apiKey);
            this.f.a(appMetricaConfig, publicLogger);
            cc = new Cc(this.f);
            cc.i = new Jb(this.d, cc);
            Ol ol = this.e;
            Sh sh = cc.b;
            if (ol != null) {
                sh.b.setUuid(ol.g());
            } else {
                sh.getClass();
            }
            cc.a(appMetricaConfig, z);
            cc.k();
            this.c.f.c = new C0663vi(cc);
            this.g.put(appMetricaConfig.apiKey, cc);
            this.j = cc;
        }
        return cc;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0457nb
    /* renamed from: d */
    public final synchronized Cc b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, boolean z) {
        Cc cc;
        cc = this.j;
        if (cc != null) {
            this.f.a(appMetricaConfig, publicLogger);
            cc.a(appMetricaConfig, z);
            C0699x4.l().getClass();
            this.g.put(appMetricaConfig.apiKey, cc);
        } else {
            this.h.a(appMetricaConfig.apiKey);
            this.f.a(appMetricaConfig, publicLogger);
            cc = new Cc(this.f);
            cc.i = new Jb(this.d, cc);
            Ol ol = this.e;
            Sh sh = cc.b;
            if (ol != null) {
                sh.b.setUuid(ol.g());
            } else {
                sh.getClass();
            }
            cc.a(appMetricaConfig, z);
            cc.k();
            this.c.f.c = new C0663vi(cc);
            this.g.put(appMetricaConfig.apiKey, cc);
            C0699x4.l().getClass();
            this.j = cc;
        }
        return cc;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0457nb
    public final synchronized InterfaceC0432mb b(ReporterConfig reporterConfig) {
        Tc tc;
        InterfaceC0432mb interfaceC0432mb = (InterfaceC0432mb) this.g.get(reporterConfig.apiKey);
        tc = interfaceC0432mb;
        if (interfaceC0432mb == null) {
            if (!this.i.contains(reporterConfig.apiKey)) {
                this.e.i();
            }
            Context context = this.f1123a;
            Tc tc2 = new Tc(context, this.b, reporterConfig, this.c, new C0307ha(context));
            tc2.i = new Jb(this.d, tc2);
            Ol ol = this.e;
            Sh sh = tc2.b;
            if (ol != null) {
                sh.b.setUuid(ol.g());
            } else {
                sh.getClass();
            }
            tc2.k();
            this.g.put(reporterConfig.apiKey, tc2);
            tc = tc2;
        }
        return tc;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0457nb
    public final synchronized void a(ReporterConfig reporterConfig) {
        if (this.g.containsKey(reporterConfig.apiKey)) {
            LoggerStorage.getOrCreatePublicLogger(reporterConfig.apiKey).warning("Reporter with apiKey=%s already exists.", ApiKeyUtils.createPartialApiKey(reporterConfig.apiKey));
        } else {
            b(reporterConfig);
            ImportantLogger.INSTANCE.info("AppMetrica", "Activate reporter with APIKey " + ApiKeyUtils.createPartialApiKey(reporterConfig.apiKey), new Object[0]);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0457nb
    public final synchronized InterfaceC0507pb a(AppMetricaConfig appMetricaConfig) {
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
