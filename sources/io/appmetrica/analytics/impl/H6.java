package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import java.util.Map;
/* loaded from: classes4.dex */
public final class H6 implements InterfaceC0506pb {

    /* renamed from: a  reason: collision with root package name */
    public final I6 f466a;
    public final Sh b;

    public H6(I6 i6) {
        this.f466a = i6;
        this.b = i6.a();
        C0698x4.l().getClass();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0506pb
    public final void a(Nn nn) {
        Ji ji = this.f466a.f485a;
        Ih a2 = ji.a(nn, this.b);
        Sh sh = a2.e;
        Pl pl = ji.e;
        if (pl != null) {
            sh.b.setUuid(((Ol) pl).g());
        } else {
            sh.getClass();
        }
        ji.c.b(a2);
        LoggerStorage.getMainPublicOrAnonymousLogger().info("Unhandled exception received: " + nn, new Object[0]);
    }

    public final void a(AppMetricaConfig appMetricaConfig) {
        Map<String, String> map = appMetricaConfig.errorEnvironment;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                Sh sh = this.b;
                String key = entry.getKey();
                String value = entry.getValue();
                synchronized (sh) {
                    W8 w8 = sh.c;
                    w8.b.b(w8.f698a, key, value);
                }
            }
        }
    }
}
