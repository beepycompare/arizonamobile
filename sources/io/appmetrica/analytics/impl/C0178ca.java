package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.Map;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.ca  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0178ca extends AbstractC0236eh {
    public final C0204da b;

    public C0178ca(C0574s5 c0574s5, TimeProvider timeProvider) {
        super(c0574s5);
        this.b = new C0204da(c0574s5, timeProvider);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0236eh
    public final boolean a(C0401l6 c0401l6) {
        long optLong;
        C0204da c0204da = this.b;
        W9 w9 = c0204da.f816a.s().C;
        Long valueOf = w9 != null ? Long.valueOf(w9.f700a) : null;
        if (valueOf != null) {
            uo uoVar = c0204da.f816a.t;
            synchronized (uoVar) {
                optLong = uoVar.f1092a.a().optLong("external_attribution_window_start", -1L);
            }
            if (optLong < 0) {
                optLong = c0204da.b.currentTimeMillis();
                c0204da.f816a.t.a(optLong);
            }
            if (c0204da.b.currentTimeMillis() - optLong <= valueOf.longValue()) {
                V9 v9 = (V9) MessageNano.mergeFrom(new V9(), c0401l6.getValueBytes());
                int i = v9.f684a;
                String str = new String(v9.b, Charsets.UTF_8);
                String str2 = this.b.f816a.c.j().get(Integer.valueOf(i));
                if (str2 != null) {
                    try {
                        if (JsonUtils.isEqualTo(new JSONObject(str), new JSONObject(str2))) {
                            this.f832a.m.info("Ignoring attribution of type `" + AbstractC0255fa.a(i) + "` with value `" + str + "` since it is not new", new Object[0]);
                            return true;
                        }
                    } catch (Throwable unused) {
                    }
                }
                C0204da c0204da2 = this.b;
                Map<Integer, String> j = c0204da2.f816a.c.j();
                j.put(Integer.valueOf(i), str);
                c0204da2.f816a.c.a(j);
                this.f832a.m.info("Handling attribution of type `" + AbstractC0255fa.a(i) + '`', new Object[0]);
                return false;
            }
        }
        this.f832a.m.info("Ignoring attribution since out of collecting interval", new Object[0]);
        return true;
    }
}
