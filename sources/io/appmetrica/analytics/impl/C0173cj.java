package io.appmetrica.analytics.impl;

import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.cj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0173cj extends Wg {
    public C0173cj(C0210e5 c0210e5) {
        super(c0210e5);
        c0210e5.b().a();
    }

    @Override // io.appmetrica.analytics.impl.Wg
    public final boolean a(W5 w5) {
        Object remove;
        for (Map.Entry entry : w5.p.entrySet()) {
            Ok ok = this.f744a.u;
            String str = (String) entry.getKey();
            byte[] bArr = (byte[]) entry.getValue();
            if (bArr != null) {
                ok.getClass();
                if (bArr.length != 0) {
                    remove = ok.b.put(str, bArr);
                    byte[] bArr2 = (byte[]) remove;
                    Sk sk = ok.f624a;
                    sk.d.insert(sk.f688a, sk.c.toByteArray((Rk) sk.b.fromModel(ok.b)));
                }
            }
            remove = ok.b.remove(str);
            byte[] bArr22 = (byte[]) remove;
            Sk sk2 = ok.f624a;
            sk2.d.insert(sk2.f688a, sk2.c.toByteArray((Rk) sk2.b.fromModel(ok.b)));
        }
        return true;
    }
}
