package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* loaded from: classes4.dex */
public abstract class O4 extends Nd {
    public final Object f;

    public O4(int i, String str, Object obj, mo moVar, W2 w2) {
        super(i, str, moVar, w2);
        this.f = obj;
    }

    @Override // io.appmetrica.analytics.impl.Nd, io.appmetrica.analytics.impl.Yn
    public final void a(Xn xn) {
        if (f()) {
            W2 w2 = this.d;
            int i = this.b;
            Zn a2 = w2.a(xn, (Zn) ((HashMap) xn.f711a.get(i)).get(this.f552a), this);
            if (a2 != null) {
                a(a2);
            }
        }
    }

    public abstract void a(Zn zn);

    public final Object g() {
        return this.f;
    }
}
