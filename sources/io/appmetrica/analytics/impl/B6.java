package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import java.util.Map;
/* loaded from: classes5.dex */
public final class B6 implements InterfaceC0602tb {

    /* renamed from: a  reason: collision with root package name */
    public final C6 f474a;
    public final Zh b;

    public B6(C6 c6) {
        this.f474a = c6;
        this.b = c6.a();
        C0569s4.l().getClass();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0602tb
    public final void a(C0615to c0615to) {
        Qi qi = this.f474a.f494a;
        Ph a2 = qi.a(c0615to, this.b);
        Zh zh = a2.e;
        InterfaceC0561rm interfaceC0561rm = qi.e;
        if (interfaceC0561rm != null) {
            zh.b.setUuid(((C0536qm) interfaceC0561rm).g());
        } else {
            zh.getClass();
        }
        qi.c.b(a2);
        LoggerStorage.getMainPublicOrAnonymousLogger().info("Unhandled exception received: " + c0615to, new Object[0]);
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
                    w8.b.b(w8.f827a, key, value);
                }
            }
        }
    }
}
