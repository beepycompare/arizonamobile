package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.yj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0746yj extends AbstractC0304hh {
    public C0746yj(C0447n5 c0447n5) {
        super(c0447n5);
        c0447n5.a().a();
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0304hh
    public final boolean a(C0241f6 c0241f6) {
        Object remove;
        for (Map.Entry entry : c0241f6.p.entrySet()) {
            C0437ml c0437ml = this.f1019a.u;
            String str = (String) entry.getKey();
            byte[] bArr = (byte[]) entry.getValue();
            if (bArr != null) {
                c0437ml.getClass();
                if (bArr.length != 0) {
                    remove = c0437ml.b.put(str, bArr);
                    byte[] bArr2 = (byte[]) remove;
                    C0541ql c0541ql = c0437ml.f1102a;
                    c0541ql.d.insert(c0541ql.f1171a, c0541ql.c.toByteArray((C0515pl) c0541ql.b.fromModel(c0437ml.b)));
                }
            }
            remove = c0437ml.b.remove(str);
            byte[] bArr22 = (byte[]) remove;
            C0541ql c0541ql2 = c0437ml.f1102a;
            c0541ql2.d.insert(c0541ql2.f1171a, c0541ql2.c.toByteArray((C0515pl) c0541ql2.b.fromModel(c0437ml.b)));
        }
        return true;
    }
}
