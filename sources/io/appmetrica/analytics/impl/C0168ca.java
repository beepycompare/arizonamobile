package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.Map;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.ca  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0168ca extends AbstractC0304hh {
    public final C0194da b;

    public C0168ca(C0447n5 c0447n5, TimeProvider timeProvider) {
        super(c0447n5);
        this.b = new C0194da(c0447n5, timeProvider);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0304hh
    public final boolean a(C0241f6 c0241f6) {
        long optLong;
        C0194da c0194da = this.b;
        W9 w9 = c0194da.f944a.t().B;
        Long valueOf = w9 != null ? Long.valueOf(w9.f825a) : null;
        if (valueOf != null) {
            ap apVar = c0194da.f944a.t;
            synchronized (apVar) {
                optLong = apVar.f896a.a().optLong("external_attribution_window_start", -1L);
            }
            if (optLong < 0) {
                optLong = c0194da.b.currentTimeMillis();
                c0194da.f944a.t.a(optLong);
            }
            if (c0194da.b.currentTimeMillis() - optLong <= valueOf.longValue()) {
                V9 v9 = (V9) MessageNano.mergeFrom(new V9(), c0241f6.getValueBytes());
                int i = v9.f809a;
                String str = new String(v9.b, Charsets.UTF_8);
                String str2 = this.b.f944a.c.k().get(Integer.valueOf(i));
                if (str2 != null) {
                    try {
                        if (JsonUtils.isEqualTo(new JSONObject(str), new JSONObject(str2))) {
                            this.f1019a.m.info("Ignoring attribution of type `" + AbstractC0245fa.a(i) + "` with value `" + str + "` since it is not new", new Object[0]);
                            return true;
                        }
                    } catch (Throwable unused) {
                    }
                }
                C0194da c0194da2 = this.b;
                Map<Integer, String> k = c0194da2.f944a.c.k();
                k.put(Integer.valueOf(i), str);
                c0194da2.f944a.c.b(k);
                this.f1019a.m.info("Handling attribution of type `" + AbstractC0245fa.a(i) + '`', new Object[0]);
                return false;
            }
        }
        this.f1019a.m.info("Ignoring attribution since out of collecting interval", new Object[0]);
        return true;
    }
}
