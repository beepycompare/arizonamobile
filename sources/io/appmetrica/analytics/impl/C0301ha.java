package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.Map;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.ha  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0301ha extends AbstractC0463nh {
    public final C0327ia b;

    public C0301ha(C0652v5 c0652v5, TimeProvider timeProvider) {
        super(c0652v5);
        this.b = new C0327ia(c0652v5, timeProvider);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0463nh
    public final boolean a(C0478o6 c0478o6) {
        long optLong;
        C0327ia c0327ia = this.b;
        C0146ba c0146ba = c0327ia.f922a.t().C;
        Long valueOf = c0146ba != null ? Long.valueOf(c0146ba.f809a) : null;
        if (valueOf != null) {
            Do r4 = c0327ia.f922a.t;
            synchronized (r4) {
                optLong = r4.f418a.a().optLong("external_attribution_window_start", -1L);
            }
            if (optLong < 0) {
                optLong = c0327ia.b.currentTimeMillis();
                c0327ia.f922a.t.a(optLong);
            }
            if (c0327ia.b.currentTimeMillis() - optLong <= valueOf.longValue()) {
                C0120aa c0120aa = (C0120aa) MessageNano.mergeFrom(new C0120aa(), c0478o6.getValueBytes());
                int i = c0120aa.f791a;
                String str = new String(c0120aa.b, Charsets.UTF_8);
                String str2 = this.b.f922a.c.k().get(Integer.valueOf(i));
                if (str2 != null) {
                    try {
                        if (JsonUtils.isEqualTo(new JSONObject(str), new JSONObject(str2))) {
                            this.f1006a.m.info("Ignoring attribution of type `" + AbstractC0378ka.a(i) + "` with value `" + str + "` since it is not new", new Object[0]);
                            return true;
                        }
                    } catch (Throwable unused) {
                    }
                }
                C0327ia c0327ia2 = this.b;
                Map<Integer, String> k = c0327ia2.f922a.c.k();
                k.put(Integer.valueOf(i), str);
                c0327ia2.f922a.c.b(k);
                this.f1006a.m.info("Handling attribution of type `" + AbstractC0378ka.a(i) + '`', new Object[0]);
                return false;
            }
        }
        this.f1006a.m.info("Ignoring attribution since out of collecting interval", new Object[0]);
        return true;
    }
}
