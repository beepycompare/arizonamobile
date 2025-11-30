package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.m6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0417m6 implements Va {

    /* renamed from: a  reason: collision with root package name */
    public final C0442n6 f1005a;
    public final Gh b;

    public C0417m6(C0442n6 c0442n6) {
        this.f1005a = c0442n6;
        this.b = c0442n6.a();
        C0158c4.l().getClass();
    }

    @Override // io.appmetrica.analytics.impl.Va
    public final void a(Rn rn) {
        C0703xi c0703xi = this.f1005a.f1024a;
        C0677wh a2 = c0703xi.a(rn, this.b);
        Gh gh = a2.e;
        Ql ql = c0703xi.e;
        if (ql != null) {
            gh.b.setUuid(((Pl) ql).g());
        } else {
            gh.getClass();
        }
        c0703xi.c.b(a2);
        LoggerStorage.getMainPublicOrAnonymousLogger().info("Unhandled exception received: " + rn, new Object[0]);
    }

    public final void a(AppMetricaConfig appMetricaConfig) {
        Map<String, String> map = appMetricaConfig.errorEnvironment;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                Gh gh = this.b;
                String key = entry.getKey();
                String value = entry.getValue();
                synchronized (gh) {
                    E8 e8 = gh.c;
                    e8.b.b(e8.f457a, key, value);
                }
            }
        }
    }
}
