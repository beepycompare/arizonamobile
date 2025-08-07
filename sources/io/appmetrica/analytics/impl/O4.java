package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* loaded from: classes4.dex */
public abstract class O4 extends Pd {
    public final Object f;

    public O4(int i, String str, Object obj, po poVar, W2 w2) {
        super(i, str, poVar, w2);
        this.f = obj;
    }

    @Override // io.appmetrica.analytics.impl.Pd, io.appmetrica.analytics.impl.InterfaceC0167bo
    public final void a(C0141ao c0141ao) {
        if (f()) {
            W2 w2 = this.d;
            int i = this.b;
            C0193co a2 = w2.a(c0141ao, (C0193co) ((HashMap) c0141ao.f773a.get(i)).get(this.f594a), this);
            if (a2 != null) {
                a(a2);
            }
        }
    }

    public abstract void a(C0193co c0193co);

    public final Object g() {
        return this.f;
    }
}
