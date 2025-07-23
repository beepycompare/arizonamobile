package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* loaded from: classes4.dex */
public abstract class O4 extends Pd {
    public final Object f;

    public O4(int i, String str, Object obj, po poVar, W2 w2) {
        super(i, str, poVar, w2);
        this.f = obj;
    }

    @Override // io.appmetrica.analytics.impl.Pd, io.appmetrica.analytics.impl.InterfaceC0166bo
    public final void a(C0140ao c0140ao) {
        if (f()) {
            W2 w2 = this.d;
            int i = this.b;
            C0192co a2 = w2.a(c0140ao, (C0192co) ((HashMap) c0140ao.f773a.get(i)).get(this.f594a), this);
            if (a2 != null) {
                a(a2);
            }
        }
    }

    public abstract void a(C0192co c0192co);

    public final Object g() {
        return this.f;
    }
}
