package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.u4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0613u4 extends Bd {
    public final Object f;

    public AbstractC0613u4(int i, String str, Object obj, to toVar, K2 k2) {
        super(i, str, toVar, k2);
        this.f = obj;
    }

    @Override // io.appmetrica.analytics.impl.Bd, io.appmetrica.analytics.impl.InterfaceC0254fo
    public final void a(C0228eo c0228eo) {
        if (f()) {
            K2 k2 = this.d;
            int i = this.b;
            C0280go a2 = k2.a(c0228eo, (C0280go) ((HashMap) c0228eo.f960a.get(i)).get(this.f493a), this);
            if (a2 != null) {
                a(a2);
            }
        }
    }

    public abstract void a(C0280go c0280go);

    public final Object g() {
        return this.f;
    }
}
