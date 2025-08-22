package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.Map;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.ea  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0222ea extends AbstractC0358jh {
    public final C0248fa b;

    public C0222ea(C0572s5 c0572s5, TimeProvider timeProvider) {
        super(c0572s5);
        this.b = new C0248fa(c0572s5, timeProvider);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0358jh
    public final boolean a(C0399l6 c0399l6) {
        long optLong;
        C0248fa c0248fa = this.b;
        Y9 y9 = c0248fa.f855a.s().C;
        Long valueOf = y9 != null ? Long.valueOf(y9.f739a) : null;
        if (valueOf != null) {
            zo zoVar = c0248fa.f855a.t;
            synchronized (zoVar) {
                optLong = zoVar.f1187a.a().optLong("external_attribution_window_start", -1L);
            }
            if (optLong < 0) {
                optLong = c0248fa.b.currentTimeMillis();
                c0248fa.f855a.t.a(optLong);
            }
            if (c0248fa.b.currentTimeMillis() - optLong <= valueOf.longValue()) {
                X9 x9 = (X9) MessageNano.mergeFrom(new X9(), c0399l6.getValueBytes());
                int i = x9.f724a;
                String str = new String(x9.b, Charsets.UTF_8);
                String str2 = this.b.f855a.c.j().get(Integer.valueOf(i));
                if (str2 != null) {
                    try {
                        if (JsonUtils.isEqualTo(new JSONObject(str), new JSONObject(str2))) {
                            this.f925a.m.info("Ignoring attribution of type `" + AbstractC0300ha.a(i) + "` with value `" + str + "` since it is not new", new Object[0]);
                            return true;
                        }
                    } catch (Throwable unused) {
                    }
                }
                C0248fa c0248fa2 = this.b;
                Map<Integer, String> j = c0248fa2.f855a.c.j();
                j.put(Integer.valueOf(i), str);
                c0248fa2.f855a.c.a(j);
                this.f925a.m.info("Handling attribution of type `" + AbstractC0300ha.a(i) + '`', new Object[0]);
                return false;
            }
        }
        this.f925a.m.info("Ignoring attribution since out of collecting interval", new Object[0]);
        return true;
    }
}
