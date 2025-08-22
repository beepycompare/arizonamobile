package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* loaded from: classes4.dex */
public abstract class O4 extends Rd {
    public final Object f;

    public O4(int i, String str, Object obj, uo uoVar, W2 w2) {
        super(i, str, uoVar, w2);
        this.f = obj;
    }

    @Override // io.appmetrica.analytics.impl.Rd, io.appmetrica.analytics.impl.InterfaceC0288go
    public final void a(C0262fo c0262fo) {
        if (f()) {
            W2 w2 = this.d;
            int i = this.b;
            C0314ho a2 = w2.a(c0262fo, (C0314ho) ((HashMap) c0262fo.f860a.get(i)).get(this.f634a), this);
            if (a2 != null) {
                a(a2);
            }
        }
    }

    public abstract void a(C0314ho c0314ho);

    public final Object g() {
        return this.f;
    }
}
