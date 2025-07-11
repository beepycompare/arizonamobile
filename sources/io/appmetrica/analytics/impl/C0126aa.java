package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.Map;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.aa  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0126aa extends AbstractC0185ch {
    public final C0152ba b;

    public C0126aa(C0572s5 c0572s5, TimeProvider timeProvider) {
        super(c0572s5);
        this.b = new C0152ba(c0572s5, timeProvider);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0185ch
    public final boolean a(C0325i6 c0325i6) {
        long optLong;
        C0152ba c0152ba = this.b;
        U9 u9 = c0152ba.f769a.s().C;
        Long valueOf = u9 != null ? Long.valueOf(u9.f657a) : null;
        if (valueOf != null) {
            ro roVar = c0152ba.f769a.t;
            synchronized (roVar) {
                optLong = roVar.f1034a.a().optLong("external_attribution_window_start", -1L);
            }
            if (optLong < 0) {
                optLong = c0152ba.b.currentTimeMillis();
                c0152ba.f769a.t.a(optLong);
            }
            if (c0152ba.b.currentTimeMillis() - optLong <= valueOf.longValue()) {
                T9 t9 = (T9) MessageNano.mergeFrom(new T9(), c0325i6.getValueBytes());
                int i = t9.f639a;
                String str = new String(t9.b, Charsets.UTF_8);
                String str2 = this.b.f769a.c.j().get(Integer.valueOf(i));
                if (str2 != null) {
                    try {
                        if (JsonUtils.isEqualTo(new JSONObject(str), new JSONObject(str2))) {
                            this.f786a.m.info("Ignoring attribution of type `" + AbstractC0204da.a(i) + "` with value `" + str + "` since it is not new", new Object[0]);
                            return true;
                        }
                    } catch (Throwable unused) {
                    }
                }
                C0152ba c0152ba2 = this.b;
                Map<Integer, String> j = c0152ba2.f769a.c.j();
                j.put(Integer.valueOf(i), str);
                c0152ba2.f769a.c.a(j);
                this.f786a.m.info("Handling attribution of type `" + AbstractC0204da.a(i) + '`', new Object[0]);
                return false;
            }
        }
        this.f786a.m.info("Ignoring attribution since out of collecting interval", new Object[0]);
        return true;
    }
}
