package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.l6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0394l6 implements Ua {

    /* renamed from: a  reason: collision with root package name */
    public final C0419m6 f1092a;
    public final Fh b;

    public C0394l6(C0419m6 c0419m6) {
        this.f1092a = c0419m6;
        this.b = c0419m6.a();
        C0135b4.l().getClass();
    }

    @Override // io.appmetrica.analytics.impl.Ua
    public final void a(Qn qn) {
        C0680wi c0680wi = this.f1092a.f1111a;
        C0654vh a2 = c0680wi.a(qn, this.b);
        Fh fh = a2.e;
        Pl pl = c0680wi.e;
        if (pl != null) {
            fh.b.setUuid(((Ol) pl).g());
        } else {
            fh.getClass();
        }
        c0680wi.c.b(a2);
        LoggerStorage.getMainPublicOrAnonymousLogger().info("Unhandled exception received: " + qn, new Object[0]);
    }

    public final void a(AppMetricaConfig appMetricaConfig) {
        Map<String, String> map = appMetricaConfig.errorEnvironment;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                Fh fh = this.b;
                String key = entry.getKey();
                String value = entry.getValue();
                synchronized (fh) {
                    D8 d8 = fh.c;
                    d8.b.b(d8.f546a, key, value);
                }
            }
        }
    }
}
