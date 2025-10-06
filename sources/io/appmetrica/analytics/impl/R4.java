package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* loaded from: classes4.dex */
public abstract class R4 extends Vd {
    public final Object f;

    public R4(int i, String str, Object obj, yo yoVar, Z2 z2) {
        super(i, str, yoVar, z2);
        this.f = obj;
    }

    @Override // io.appmetrica.analytics.impl.Vd, io.appmetrica.analytics.impl.InterfaceC0392ko
    public final void a(C0366jo c0366jo) {
        if (f()) {
            Z2 z2 = this.d;
            int i = this.b;
            C0418lo a2 = z2.a(c0366jo, (C0418lo) ((HashMap) c0366jo.f944a.get(i)).get(this.f712a), this);
            if (a2 != null) {
                a(a2);
            }
        }
    }

    public abstract void a(C0418lo c0418lo);

    public final Object g() {
        return this.f;
    }
}
