package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.yj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0747yj extends AbstractC0305hh {
    public C0747yj(C0448n5 c0448n5) {
        super(c0448n5);
        c0448n5.a().a();
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0305hh
    public final boolean a(C0242f6 c0242f6) {
        Object remove;
        for (Map.Entry entry : c0242f6.p.entrySet()) {
            C0438ml c0438ml = this.f1017a.u;
            String str = (String) entry.getKey();
            byte[] bArr = (byte[]) entry.getValue();
            if (bArr != null) {
                c0438ml.getClass();
                if (bArr.length != 0) {
                    remove = c0438ml.b.put(str, bArr);
                    byte[] bArr2 = (byte[]) remove;
                    C0542ql c0542ql = c0438ml.f1100a;
                    c0542ql.d.insert(c0542ql.f1169a, c0542ql.c.toByteArray((C0516pl) c0542ql.b.fromModel(c0438ml.b)));
                }
            }
            remove = c0438ml.b.remove(str);
            byte[] bArr22 = (byte[]) remove;
            C0542ql c0542ql2 = c0438ml.f1100a;
            c0542ql2.d.insert(c0542ql2.f1169a, c0542ql2.c.toByteArray((C0516pl) c0542ql2.b.fromModel(c0438ml.b)));
        }
        return true;
    }
}
