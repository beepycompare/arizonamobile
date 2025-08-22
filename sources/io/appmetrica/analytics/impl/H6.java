package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import java.util.Map;
/* loaded from: classes4.dex */
public final class H6 implements InterfaceC0553rb {

    /* renamed from: a  reason: collision with root package name */
    public final I6 f471a;
    public final Xh b;

    public H6(I6 i6) {
        this.f471a = i6;
        this.b = i6.a();
        C0696x4.l().getClass();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0553rb
    public final void a(Sn sn) {
        Oi oi = this.f471a.f491a;
        Nh a2 = oi.a(sn, this.b);
        Xh xh = a2.e;
        Ul ul = oi.e;
        if (ul != null) {
            xh.b.setUuid(((Tl) ul).g());
        } else {
            xh.getClass();
        }
        oi.c.b(a2);
        LoggerStorage.getMainPublicOrAnonymousLogger().info("Unhandled exception received: " + sn, new Object[0]);
    }

    public final void a(AppMetricaConfig appMetricaConfig) {
        Map<String, String> map = appMetricaConfig.errorEnvironment;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                Xh xh = this.b;
                String key = entry.getKey();
                String value = entry.getValue();
                synchronized (xh) {
                    Y8 y8 = xh.c;
                    y8.b.b(y8.f738a, key, value);
                }
            }
        }
    }
}
