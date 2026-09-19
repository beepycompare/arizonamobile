package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.yj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0745yj extends AbstractC0303hh {
    public C0745yj(C0446n5 c0446n5) {
        super(c0446n5);
        c0446n5.a().a();
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0303hh
    public final boolean a(C0240f6 c0240f6) {
        Object remove;
        for (Map.Entry entry : c0240f6.p.entrySet()) {
            C0436ml c0436ml = this.f1019a.u;
            String str = (String) entry.getKey();
            byte[] bArr = (byte[]) entry.getValue();
            if (bArr != null) {
                c0436ml.getClass();
                if (bArr.length != 0) {
                    remove = c0436ml.b.put(str, bArr);
                    byte[] bArr2 = (byte[]) remove;
                    C0540ql c0540ql = c0436ml.f1102a;
                    c0540ql.d.insert(c0540ql.f1171a, c0540ql.c.toByteArray((C0514pl) c0540ql.b.fromModel(c0436ml.b)));
                }
            }
            remove = c0436ml.b.remove(str);
            byte[] bArr22 = (byte[]) remove;
            C0540ql c0540ql2 = c0436ml.f1102a;
            c0540ql2.d.insert(c0540ql2.f1171a, c0540ql2.c.toByteArray((C0514pl) c0540ql2.b.fromModel(c0436ml.b)));
        }
        return true;
    }
}
