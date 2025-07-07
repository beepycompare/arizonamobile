package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.parsing.JsonUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.Map;
import kotlin.text.Charsets;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.aa  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0134aa extends AbstractC0193ch {
    public final C0160ba b;

    public C0134aa(C0580s5 c0580s5, TimeProvider timeProvider) {
        super(c0580s5);
        this.b = new C0160ba(c0580s5, timeProvider);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0193ch
    public final boolean a(C0333i6 c0333i6) {
        long optLong;
        C0160ba c0160ba = this.b;
        U9 u9 = c0160ba.f768a.s().C;
        Long valueOf = u9 != null ? Long.valueOf(u9.f656a) : null;
        if (valueOf != null) {
            ro roVar = c0160ba.f768a.t;
            synchronized (roVar) {
                optLong = roVar.f1033a.a().optLong("external_attribution_window_start", -1L);
            }
            if (optLong < 0) {
                optLong = c0160ba.b.currentTimeMillis();
                c0160ba.f768a.t.a(optLong);
            }
            if (c0160ba.b.currentTimeMillis() - optLong <= valueOf.longValue()) {
                T9 t9 = (T9) MessageNano.mergeFrom(new T9(), c0333i6.getValueBytes());
                int i = t9.f638a;
                String str = new String(t9.b, Charsets.UTF_8);
                String str2 = this.b.f768a.c.j().get(Integer.valueOf(i));
                if (str2 != null) {
                    try {
                        if (JsonUtils.isEqualTo(new JSONObject(str), new JSONObject(str2))) {
                            this.f785a.m.info("Ignoring attribution of type `" + AbstractC0212da.a(i) + "` with value `" + str + "` since it is not new", new Object[0]);
                            return true;
                        }
                    } catch (Throwable unused) {
                    }
                }
                C0160ba c0160ba2 = this.b;
                Map<Integer, String> j = c0160ba2.f768a.c.j();
                j.put(Integer.valueOf(i), str);
                c0160ba2.f768a.c.a(j);
                this.f785a.m.info("Handling attribution of type `" + AbstractC0212da.a(i) + '`', new Object[0]);
                return false;
            }
        }
        this.f785a.m.info("Ignoring attribution since out of collecting interval", new Object[0]);
        return true;
    }
}
