package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.Map;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.ca  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0162ca extends AbstractC0298hh {
    public final C0188da b;

    public C0162ca(C0441n5 c0441n5, TimeProvider timeProvider) {
        super(c0441n5);
        this.b = new C0188da(c0441n5, timeProvider);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0298hh
    public final boolean a(C0235f6 c0235f6) {
        long optLong;
        C0188da c0188da = this.b;
        W9 w9 = c0188da.f947a.t().B;
        Long valueOf = w9 != null ? Long.valueOf(w9.f828a) : null;
        if (valueOf != null) {
            ap apVar = c0188da.f947a.t;
            synchronized (apVar) {
                optLong = apVar.f899a.a().optLong("external_attribution_window_start", -1L);
            }
            if (optLong < 0) {
                optLong = c0188da.b.currentTimeMillis();
                c0188da.f947a.t.a(optLong);
            }
            if (c0188da.b.currentTimeMillis() - optLong <= valueOf.longValue()) {
                V9 v9 = (V9) MessageNano.mergeFrom(new V9(), c0235f6.getValueBytes());
                int i = v9.f812a;
                String str = new String(v9.b, Charsets.UTF_8);
                String str2 = this.b.f947a.c.k().get(Integer.valueOf(i));
                if (str2 != null) {
                    try {
                        if (JsonUtils.isEqualTo(new JSONObject(str), new JSONObject(str2))) {
                            this.f1022a.m.info("Ignoring attribution of type `" + AbstractC0239fa.a(i) + "` with value `" + str + "` since it is not new", new Object[0]);
                            return true;
                        }
                    } catch (Throwable unused) {
                    }
                }
                C0188da c0188da2 = this.b;
                Map<Integer, String> k = c0188da2.f947a.c.k();
                k.put(Integer.valueOf(i), str);
                c0188da2.f947a.c.b(k);
                this.f1022a.m.info("Handling attribution of type `" + AbstractC0239fa.a(i) + '`', new Object[0]);
                return false;
            }
        }
        this.f1022a.m.info("Ignoring attribution since out of collecting interval", new Object[0]);
        return true;
    }
}
