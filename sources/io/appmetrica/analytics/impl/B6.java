package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import java.util.Map;
/* loaded from: classes5.dex */
public final class B6 implements InterfaceC0608tb {

    /* renamed from: a  reason: collision with root package name */
    public final C6 f471a;
    public final Zh b;

    public B6(C6 c6) {
        this.f471a = c6;
        this.b = c6.a();
        C0575s4.l().getClass();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0608tb
    public final void a(C0621to c0621to) {
        Qi qi = this.f471a.f491a;
        Ph a2 = qi.a(c0621to, this.b);
        Zh zh = a2.e;
        InterfaceC0567rm interfaceC0567rm = qi.e;
        if (interfaceC0567rm != null) {
            zh.b.setUuid(((C0542qm) interfaceC0567rm).g());
        } else {
            zh.getClass();
        }
        qi.c.b(a2);
        LoggerStorage.getMainPublicOrAnonymousLogger().info("Unhandled exception received: " + c0621to, new Object[0]);
    }

    public final void a(AppMetricaConfig appMetricaConfig) {
        Map<String, String> map = appMetricaConfig.errorEnvironment;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                Zh zh = this.b;
                String key = entry.getKey();
                String value = entry.getValue();
                synchronized (zh) {
                    W8 w8 = zh.c;
                    w8.b.b(w8.f824a, key, value);
                }
            }
        }
    }
}
