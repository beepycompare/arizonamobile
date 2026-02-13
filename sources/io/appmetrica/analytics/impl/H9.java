package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.Map;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class H9 extends Rg {
    public final I9 b;

    public H9(X4 x4, TimeProvider timeProvider) {
        super(x4);
        this.b = new I9(x4, timeProvider);
    }

    @Override // io.appmetrica.analytics.impl.Rg
    public final boolean a(P5 p5) {
        long optLong;
        I9 i9 = this.b;
        B9 b9 = i9.f626a.t().B;
        Long valueOf = b9 != null ? Long.valueOf(b9.f515a) : null;
        if (valueOf != null) {
            xo xoVar = i9.f626a.t;
            synchronized (xoVar) {
                optLong = xoVar.f1312a.a().optLong("external_attribution_window_start", -1L);
            }
            if (optLong < 0) {
                optLong = i9.b.currentTimeMillis();
                i9.f626a.t.a(optLong);
            }
            if (i9.b.currentTimeMillis() - optLong <= valueOf.longValue()) {
                A9 a9 = (A9) MessageNano.mergeFrom(new A9(), p5.getValueBytes());
                int i = a9.f496a;
                String str = new String(a9.b, Charsets.UTF_8);
                String str2 = this.b.f626a.c.k().get(Integer.valueOf(i));
                if (str2 != null) {
                    try {
                        if (JsonUtils.isEqualTo(new JSONObject(str), new JSONObject(str2))) {
                            this.f767a.m.info("Ignoring attribution of type `" + K9.a(i) + "` with value `" + str + "` since it is not new", new Object[0]);
                            return true;
                        }
                    } catch (Throwable unused) {
                    }
                }
                I9 i92 = this.b;
                Map<Integer, String> k = i92.f626a.c.k();
                k.put(Integer.valueOf(i), str);
                i92.f626a.c.b(k);
                this.f767a.m.info("Handling attribution of type `" + K9.a(i) + '`', new Object[0]);
                return false;
            }
        }
        this.f767a.m.info("Ignoring attribution since out of collecting interval", new Object[0]);
        return true;
    }
}
