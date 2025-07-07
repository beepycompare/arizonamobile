package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import java.util.Map;
/* loaded from: classes4.dex */
public final class E6 implements InterfaceC0462nb {

    /* renamed from: a  reason: collision with root package name */
    public final F6 f402a;
    public final Qh b;

    public E6(F6 f6) {
        this.f402a = f6;
        this.b = f6.a();
        C0704x4.l().getClass();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0462nb
    public final void a(Kn kn) {
        Gi gi = this.f402a.f424a;
        Gh a2 = gi.a(kn, this.b);
        Qh qh = a2.e;
        Ml ml = gi.e;
        if (ml != null) {
            qh.b.setUuid(((Ll) ml).g());
        } else {
            qh.getClass();
        }
        gi.c.b(a2);
        LoggerStorage.getMainPublicOrAnonymousLogger().info("Unhandled exception received: " + kn, new Object[0]);
    }

    public final void a(AppMetricaConfig appMetricaConfig) {
        Map<String, String> map = appMetricaConfig.errorEnvironment;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                Qh qh = this.b;
                String key = entry.getKey();
                String value = entry.getValue();
                synchronized (qh) {
                    T8 t8 = qh.c;
                    t8.b.b(t8.f637a, key, value);
                }
            }
        }
    }
}
