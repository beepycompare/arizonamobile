package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.u4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0614u4 extends Bd {
    public final Object f;

    public AbstractC0614u4(int i, String str, Object obj, to toVar, K2 k2) {
        super(i, str, toVar, k2);
        this.f = obj;
    }

    @Override // io.appmetrica.analytics.impl.Bd, io.appmetrica.analytics.impl.InterfaceC0255fo
    public final void a(C0229eo c0229eo) {
        if (f()) {
            K2 k2 = this.d;
            int i = this.b;
            C0281go a2 = k2.a(c0229eo, (C0281go) ((HashMap) c0229eo.f877a.get(i)).get(this.f410a), this);
            if (a2 != null) {
                a(a2);
            }
        }
    }

    public abstract void a(C0281go c0281go);

    public final Object g() {
        return this.f;
    }
}
