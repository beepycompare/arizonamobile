package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AppMetricaConfig;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.s6  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0566s6 implements InterfaceC0139bb {

    /* renamed from: a  reason: collision with root package name */
    public final C0591t6 f1107a;
    public final Kh b;

    public C0566s6(C0591t6 c0591t6) {
        this.f1107a = c0591t6;
        this.b = c0591t6.a();
        C0338j4.l().getClass();
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0139bb
    public final void a(Sn sn) {
        Bi bi = this.f1107a.f1127a;
        Ah a2 = bi.a(sn, this.b);
        Kh kh = a2.e;
        Tl tl = bi.e;
        if (tl != null) {
            kh.b.setUuid(((Sl) tl).g());
        } else {
            kh.getClass();
        }
        bi.c.b(a2);
        LoggerStorage.getMainPublicOrAnonymousLogger().info("Unhandled exception received: " + sn, new Object[0]);
    }

    public final void a(AppMetricaConfig appMetricaConfig) {
        Map<String, String> map = appMetricaConfig.errorEnvironment;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                Kh kh = this.b;
                String key = entry.getKey();
                String value = entry.getValue();
                synchronized (kh) {
                    I8 i8 = kh.c;
                    i8.b.b(i8.f523a, key, value);
                }
            }
        }
    }
}
