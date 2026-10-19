package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.yj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0740yj extends AbstractC0298hh {
    public C0740yj(C0441n5 c0441n5) {
        super(c0441n5);
        c0441n5.a().a();
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0298hh
    public final boolean a(C0235f6 c0235f6) {
        Object remove;
        for (Map.Entry entry : c0235f6.p.entrySet()) {
            C0431ml c0431ml = this.f1022a.u;
            String str = (String) entry.getKey();
            byte[] bArr = (byte[]) entry.getValue();
            if (bArr != null) {
                c0431ml.getClass();
                if (bArr.length != 0) {
                    remove = c0431ml.b.put(str, bArr);
                    byte[] bArr2 = (byte[]) remove;
                    C0535ql c0535ql = c0431ml.f1105a;
                    c0535ql.d.insert(c0535ql.f1174a, c0535ql.c.toByteArray((C0509pl) c0535ql.b.fromModel(c0431ml.b)));
                }
            }
            remove = c0431ml.b.remove(str);
            byte[] bArr22 = (byte[]) remove;
            C0535ql c0535ql2 = c0431ml.f1105a;
            c0535ql2.d.insert(c0535ql2.f1174a, c0535ql2.c.toByteArray((C0509pl) c0535ql2.b.fromModel(c0431ml.b)));
        }
        return true;
    }
}
