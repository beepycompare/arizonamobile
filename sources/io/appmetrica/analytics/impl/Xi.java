package io.appmetrica.analytics.impl;

import java.util.Map;
/* loaded from: classes5.dex */
public final class Xi extends Rg {
    public Xi(X4 x4) {
        super(x4);
        x4.b().a();
    }

    @Override // io.appmetrica.analytics.impl.Rg
    public final boolean a(P5 p5) {
        Object remove;
        for (Map.Entry entry : p5.p.entrySet()) {
            Jk jk = this.f767a.u;
            String str = (String) entry.getKey();
            byte[] bArr = (byte[]) entry.getValue();
            if (bArr != null) {
                jk.getClass();
                if (bArr.length != 0) {
                    remove = jk.b.put(str, bArr);
                    byte[] bArr2 = (byte[]) remove;
                    Nk nk = jk.f647a;
                    nk.d.insert(nk.f713a, nk.c.toByteArray((Mk) nk.b.fromModel(jk.b)));
                }
            }
            remove = jk.b.remove(str);
            byte[] bArr22 = (byte[]) remove;
            Nk nk2 = jk.f647a;
            nk2.d.insert(nk2.f713a, nk2.c.toByteArray((Mk) nk2.b.fromModel(jk.b)));
        }
        return true;
    }
}
