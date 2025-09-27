package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import java.util.Map;
/* loaded from: classes4.dex */
public final class K6 implements InterfaceC0632ub {

    /* renamed from: a  reason: collision with root package name */
    public final L6 f534a;
    public final C0153bi b;

    public K6(L6 l6) {
        this.f534a = l6;
        this.b = l6.a();
        A4.l().getClass();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0632ub
    public final void a(Wn wn) {
        Si si = this.f534a.f554a;
        Rh a2 = si.a(wn, this.b);
        C0153bi c0153bi = a2.e;
        Yl yl = si.e;
        if (yl != null) {
            c0153bi.b.setUuid(((Xl) yl).g());
        } else {
            c0153bi.getClass();
        }
        si.c.b(a2);
        LoggerStorage.getMainPublicOrAnonymousLogger().info("Unhandled exception received: " + wn, new Object[0]);
    }

    public final void a(AppMetricaConfig appMetricaConfig) {
        Map<String, String> map = appMetricaConfig.errorEnvironment;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                C0153bi c0153bi = this.b;
                String key = entry.getKey();
                String value = entry.getValue();
                synchronized (c0153bi) {
                    C0144b9 c0144b9 = c0153bi.c;
                    c0144b9.b.b(c0144b9.f808a, key, value);
                }
            }
        }
    }
}
