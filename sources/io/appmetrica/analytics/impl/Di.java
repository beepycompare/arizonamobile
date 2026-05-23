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
/* loaded from: classes5.dex */
public final class Di implements InterfaceC0532qb {

    /* renamed from: a  reason: collision with root package name */
    public final Context f513a;
    public final C0175cg b;
    public final Qi c;
    public final Handler d;
    public final C0543qm e;
    public final Tc f;
    public final LinkedHashMap g;
    public final C0312ho h;
    public final List i;
    public Jc j;
    public B6 k;

    public Di(Context context, C0175cg c0175cg, Qi qi, Handler handler, C0543qm c0543qm) {
        this.f513a = context;
        this.b = c0175cg;
        this.c = qi;
        this.d = handler;
        this.e = c0543qm;
        this.f = new Tc(context, c0175cg, qi, c0543qm);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.g = linkedHashMap;
        this.h = new C0312ho(new Fi(linkedHashMap));
        this.i = CollectionsKt.listOf((Object[]) new String[]{"20799a27-fa80-4b36-b2db-0f8141f24180", "0e5e9c33-f8c3-4568-86c5-2e4f57523f72"});
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0532qb, io.appmetrica.analytics.impl.InterfaceC0557rb
    public final InterfaceC0532qb a() {
        return this;
    }

    public final Di b() {
        return this;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0532qb
    /* renamed from: c */
    public final synchronized Jc b(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0443n0 c0443n0) {
        Jc jc;
        jc = this.j;
        if (jc != null) {
            this.f.a(appMetricaConfig, publicLogger);
        } else {
            this.h.a(appMetricaConfig.apiKey);
            this.f.a(appMetricaConfig, publicLogger);
            jc = new Jc(this.f);
            jc.i = new Qb(this.d, jc);
            C0543qm c0543qm = this.e;
            Zh zh = jc.b;
            if (c0543qm != null) {
                zh.b.setUuid(c0543qm.g());
            } else {
                zh.getClass();
            }
            jc.a(appMetricaConfig, c0443n0);
            jc.k();
            this.c.f.c = new Ci(jc);
            this.g.put(appMetricaConfig.apiKey, jc);
            this.j = jc;
        }
        return jc;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0532qb
    /* renamed from: d */
    public final synchronized Jc a(AppMetricaConfig appMetricaConfig, PublicLogger publicLogger, C0443n0 c0443n0) {
        Jc jc;
        jc = this.j;
        if (jc != null) {
            this.f.b(appMetricaConfig, publicLogger);
            jc.a(appMetricaConfig, c0443n0);
            C0576s4.l().getClass();
            this.g.put(appMetricaConfig.apiKey, jc);
        } else {
            this.h.a(appMetricaConfig.apiKey);
            this.f.b(appMetricaConfig, publicLogger);
            jc = new Jc(this.f);
            jc.i = new Qb(this.d, jc);
            C0543qm c0543qm = this.e;
            Zh zh = jc.b;
            if (c0543qm != null) {
                zh.b.setUuid(c0543qm.g());
            } else {
                zh.getClass();
            }
            jc.a(appMetricaConfig, c0443n0);
            jc.k();
            this.c.f.c = new Ci(jc);
            this.g.put(appMetricaConfig.apiKey, jc);
            C0576s4.l().getClass();
            this.j = jc;
        }
        return jc;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0532qb
    public final synchronized InterfaceC0506pb b(ReporterConfig reporterConfig) {
        Zc zc;
        InterfaceC0506pb interfaceC0506pb = (InterfaceC0506pb) this.g.get(reporterConfig.apiKey);
        zc = interfaceC0506pb;
        if (interfaceC0506pb == null) {
            if (!this.i.contains(reporterConfig.apiKey)) {
                this.e.i();
            }
            Context context = this.f513a;
            Zc zc2 = new Zc(context, this.b, reporterConfig, this.c, new C0298ha(context));
            zc2.i = new Qb(this.d, zc2);
            C0543qm c0543qm = this.e;
            Zh zh = zc2.b;
            if (c0543qm != null) {
                zh.b.setUuid(c0543qm.g());
            } else {
                zh.getClass();
            }
            zc2.k();
            this.g.put(reporterConfig.apiKey, zc2);
            zc = zc2;
        }
        return zc;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0532qb
    public final synchronized void a(ReporterConfig reporterConfig) {
        if (this.g.containsKey(reporterConfig.apiKey)) {
            LoggerStorage.getOrCreatePublicLogger(reporterConfig.apiKey).warning("Reporter with apiKey=%s already exists.", ApiKeyUtils.createPartialApiKey(reporterConfig.apiKey));
        } else {
            b(reporterConfig);
            ImportantLogger.INSTANCE.info("AppMetrica", "Activate reporter with APIKey " + ApiKeyUtils.createPartialApiKey(reporterConfig.apiKey), new Object[0]);
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0532qb
    public final synchronized InterfaceC0609tb a(AppMetricaConfig appMetricaConfig) {
        B6 b6;
        b6 = this.k;
        if (b6 != null) {
            b6.a(appMetricaConfig);
        } else {
            B6 b62 = new B6(new C6(this.b, this.f.e, this.c, appMetricaConfig));
            this.k = b62;
            b6 = b62;
        }
        return b6;
    }
}
