package io.appmetrica.analytics.impl;

import java.util.Map;
/* loaded from: classes5.dex */
public final class Yi extends Sg {
    public Yi(Y4 y4) {
        super(y4);
        y4.b().a();
    }

    @Override // io.appmetrica.analytics.impl.Sg
    public final boolean a(Q5 q5) {
        Object remove;
        for (Map.Entry entry : q5.p.entrySet()) {
            Kk kk = this.f762a.u;
            String str = (String) entry.getKey();
            byte[] bArr = (byte[]) entry.getValue();
            if (bArr != null) {
                kk.getClass();
                if (bArr.length != 0) {
                    remove = kk.b.put(str, bArr);
                    byte[] bArr2 = (byte[]) remove;
                    Ok ok = kk.f641a;
                    ok.d.insert(ok.f708a, ok.c.toByteArray((Nk) ok.b.fromModel(kk.b)));
                }
            }
            remove = kk.b.remove(str);
            byte[] bArr22 = (byte[]) remove;
            Ok ok2 = kk.f641a;
            ok2.d.insert(ok2.f708a, ok2.c.toByteArray((Nk) ok2.b.fromModel(kk.b)));
        }
        return true;
    }
}
