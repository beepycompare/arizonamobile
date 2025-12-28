package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.Map;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class I9 extends Sg {
    public final J9 b;

    public I9(Y4 y4, TimeProvider timeProvider) {
        super(y4);
        this.b = new J9(y4, timeProvider);
    }

    @Override // io.appmetrica.analytics.impl.Sg
    public final boolean a(Q5 q5) {
        long optLong;
        J9 j9 = this.b;
        C9 c9 = j9.f636a.t().B;
        Long valueOf = c9 != null ? Long.valueOf(c9.f525a) : null;
        if (valueOf != null) {
            yo yoVar = j9.f636a.t;
            synchronized (yoVar) {
                optLong = yoVar.f1323a.a().optLong("external_attribution_window_start", -1L);
            }
            if (optLong < 0) {
                optLong = j9.b.currentTimeMillis();
                j9.f636a.t.a(optLong);
            }
            if (j9.b.currentTimeMillis() - optLong <= valueOf.longValue()) {
                B9 b9 = (B9) MessageNano.mergeFrom(new B9(), q5.getValueBytes());
                int i = b9.f506a;
                String str = new String(b9.b, Charsets.UTF_8);
                String str2 = this.b.f636a.c.k().get(Integer.valueOf(i));
                if (str2 != null) {
                    try {
                        if (JsonUtils.isEqualTo(new JSONObject(str), new JSONObject(str2))) {
                            this.f777a.m.info("Ignoring attribution of type `" + L9.a(i) + "` with value `" + str + "` since it is not new", new Object[0]);
                            return true;
                        }
                    } catch (Throwable unused) {
                    }
                }
                J9 j92 = this.b;
                Map<Integer, String> k = j92.f636a.c.k();
                k.put(Integer.valueOf(i), str);
                j92.f636a.c.b(k);
                this.f777a.m.info("Handling attribution of type `" + L9.a(i) + '`', new Object[0]);
                return false;
            }
        }
        this.f777a.m.info("Ignoring attribution since out of collecting interval", new Object[0]);
        return true;
    }
}
