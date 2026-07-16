package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.Map;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.ca  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0169ca extends AbstractC0305hh {
    public final C0195da b;

    public C0169ca(C0448n5 c0448n5, TimeProvider timeProvider) {
        super(c0448n5);
        this.b = new C0195da(c0448n5, timeProvider);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0305hh
    public final boolean a(C0242f6 c0242f6) {
        long optLong;
        C0195da c0195da = this.b;
        W9 w9 = c0195da.f944a.t().B;
        Long valueOf = w9 != null ? Long.valueOf(w9.f825a) : null;
        if (valueOf != null) {
            ap apVar = c0195da.f944a.t;
            synchronized (apVar) {
                optLong = apVar.f896a.a().optLong("external_attribution_window_start", -1L);
            }
            if (optLong < 0) {
                optLong = c0195da.b.currentTimeMillis();
                c0195da.f944a.t.a(optLong);
            }
            if (c0195da.b.currentTimeMillis() - optLong <= valueOf.longValue()) {
                V9 v9 = (V9) MessageNano.mergeFrom(new V9(), c0242f6.getValueBytes());
                int i = v9.f809a;
                String str = new String(v9.b, Charsets.UTF_8);
                String str2 = this.b.f944a.c.k().get(Integer.valueOf(i));
                if (str2 != null) {
                    try {
                        if (JsonUtils.isEqualTo(new JSONObject(str), new JSONObject(str2))) {
                            this.f1019a.m.info("Ignoring attribution of type `" + AbstractC0246fa.a(i) + "` with value `" + str + "` since it is not new", new Object[0]);
                            return true;
                        }
                    } catch (Throwable unused) {
                    }
                }
                C0195da c0195da2 = this.b;
                Map<Integer, String> k = c0195da2.f944a.c.k();
                k.put(Integer.valueOf(i), str);
                c0195da2.f944a.c.b(k);
                this.f1019a.m.info("Handling attribution of type `" + AbstractC0246fa.a(i) + '`', new Object[0]);
                return false;
            }
        }
        this.f1019a.m.info("Ignoring attribution since out of collecting interval", new Object[0]);
        return true;
    }
}
