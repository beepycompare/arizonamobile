package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.Map;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.ca  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0179ca extends AbstractC0237eh {
    public final C0205da b;

    public C0179ca(C0575s5 c0575s5, TimeProvider timeProvider) {
        super(c0575s5);
        this.b = new C0205da(c0575s5, timeProvider);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0237eh
    public final boolean a(C0402l6 c0402l6) {
        long optLong;
        C0205da c0205da = this.b;
        W9 w9 = c0205da.f815a.s().C;
        Long valueOf = w9 != null ? Long.valueOf(w9.f699a) : null;
        if (valueOf != null) {
            uo uoVar = c0205da.f815a.t;
            synchronized (uoVar) {
                optLong = uoVar.f1091a.a().optLong("external_attribution_window_start", -1L);
            }
            if (optLong < 0) {
                optLong = c0205da.b.currentTimeMillis();
                c0205da.f815a.t.a(optLong);
            }
            if (c0205da.b.currentTimeMillis() - optLong <= valueOf.longValue()) {
                V9 v9 = (V9) MessageNano.mergeFrom(new V9(), c0402l6.getValueBytes());
                int i = v9.f683a;
                String str = new String(v9.b, Charsets.UTF_8);
                String str2 = this.b.f815a.c.j().get(Integer.valueOf(i));
                if (str2 != null) {
                    try {
                        if (JsonUtils.isEqualTo(new JSONObject(str), new JSONObject(str2))) {
                            this.f831a.m.info("Ignoring attribution of type `" + AbstractC0256fa.a(i) + "` with value `" + str + "` since it is not new", new Object[0]);
                            return true;
                        }
                    } catch (Throwable unused) {
                    }
                }
                C0205da c0205da2 = this.b;
                Map<Integer, String> j = c0205da2.f815a.c.j();
                j.put(Integer.valueOf(i), str);
                c0205da2.f815a.c.a(j);
                this.f831a.m.info("Handling attribution of type `" + AbstractC0256fa.a(i) + '`', new Object[0]);
                return false;
            }
        }
        this.f831a.m.info("Ignoring attribution since out of collecting interval", new Object[0]);
        return true;
    }
}
