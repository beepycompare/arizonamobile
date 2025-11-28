package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.Map;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class O9 extends Wg {
    public final P9 b;

    public O9(C0210e5 c0210e5, TimeProvider timeProvider) {
        super(c0210e5);
        this.b = new P9(c0210e5, timeProvider);
    }

    @Override // io.appmetrica.analytics.impl.Wg
    public final boolean a(W5 w5) {
        long optLong;
        P9 p9 = this.b;
        I9 i9 = p9.f634a.t().B;
        Long valueOf = i9 != null ? Long.valueOf(i9.f524a) : null;
        if (valueOf != null) {
            zo zoVar = p9.f634a.t;
            synchronized (zoVar) {
                optLong = zoVar.f1238a.a().optLong("external_attribution_window_start", -1L);
            }
            if (optLong < 0) {
                optLong = p9.b.currentTimeMillis();
                p9.f634a.t.a(optLong);
            }
            if (p9.b.currentTimeMillis() - optLong <= valueOf.longValue()) {
                H9 h9 = (H9) MessageNano.mergeFrom(new H9(), w5.getValueBytes());
                int i = h9.f504a;
                String str = new String(h9.b, Charsets.UTF_8);
                String str2 = this.b.f634a.c.k().get(Integer.valueOf(i));
                if (str2 != null) {
                    try {
                        if (JsonUtils.isEqualTo(new JSONObject(str), new JSONObject(str2))) {
                            this.f744a.m.info("Ignoring attribution of type `" + R9.a(i) + "` with value `" + str + "` since it is not new", new Object[0]);
                            return true;
                        }
                    } catch (Throwable unused) {
                    }
                }
                P9 p92 = this.b;
                Map<Integer, String> k = p92.f634a.c.k();
                k.put(Integer.valueOf(i), str);
                p92.f634a.c.b(k);
                this.f744a.m.info("Handling attribution of type `" + R9.a(i) + '`', new Object[0]);
                return false;
            }
        }
        this.f744a.m.info("Ignoring attribution since out of collecting interval", new Object[0]);
        return true;
    }
}
