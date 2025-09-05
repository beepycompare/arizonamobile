package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.Map;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.ha  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0300ha extends AbstractC0462nh {
    public final C0326ia b;

    public C0300ha(C0651v5 c0651v5, TimeProvider timeProvider) {
        super(c0651v5);
        this.b = new C0326ia(c0651v5, timeProvider);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0462nh
    public final boolean a(C0477o6 c0477o6) {
        long optLong;
        C0326ia c0326ia = this.b;
        C0145ba c0145ba = c0326ia.f917a.t().C;
        Long valueOf = c0145ba != null ? Long.valueOf(c0145ba.f804a) : null;
        if (valueOf != null) {
            Do r4 = c0326ia.f917a.t;
            synchronized (r4) {
                optLong = r4.f413a.a().optLong("external_attribution_window_start", -1L);
            }
            if (optLong < 0) {
                optLong = c0326ia.b.currentTimeMillis();
                c0326ia.f917a.t.a(optLong);
            }
            if (c0326ia.b.currentTimeMillis() - optLong <= valueOf.longValue()) {
                C0119aa c0119aa = (C0119aa) MessageNano.mergeFrom(new C0119aa(), c0477o6.getValueBytes());
                int i = c0119aa.f786a;
                String str = new String(c0119aa.b, Charsets.UTF_8);
                String str2 = this.b.f917a.c.k().get(Integer.valueOf(i));
                if (str2 != null) {
                    try {
                        if (JsonUtils.isEqualTo(new JSONObject(str), new JSONObject(str2))) {
                            this.f1001a.m.info("Ignoring attribution of type `" + AbstractC0377ka.a(i) + "` with value `" + str + "` since it is not new", new Object[0]);
                            return true;
                        }
                    } catch (Throwable unused) {
                    }
                }
                C0326ia c0326ia2 = this.b;
                Map<Integer, String> k = c0326ia2.f917a.c.k();
                k.put(Integer.valueOf(i), str);
                c0326ia2.f917a.c.b(k);
                this.f1001a.m.info("Handling attribution of type `" + AbstractC0377ka.a(i) + '`', new Object[0]);
                return false;
            }
        }
        this.f1001a.m.info("Ignoring attribution since out of collecting interval", new Object[0]);
        return true;
    }
}
