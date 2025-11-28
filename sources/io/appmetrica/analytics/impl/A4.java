package io.appmetrica.analytics.impl;

import java.util.HashMap;
/* loaded from: classes5.dex */
public abstract class A4 extends Hd {
    public final Object f;

    public A4(int i, String str, Object obj, uo uoVar, R2 r2) {
        super(i, str, uoVar, r2);
        this.f = obj;
    }

    @Override // io.appmetrica.analytics.impl.Hd, io.appmetrica.analytics.impl.InterfaceC0281go
    public final void a(C0255fo c0255fo) {
        if (f()) {
            R2 r2 = this.d;
            int i = this.b;
            C0307ho a2 = r2.a(c0255fo, (C0307ho) ((HashMap) c0255fo.f882a.get(i)).get(this.f506a), this);
            if (a2 != null) {
                a(a2);
            }
        }
    }

    public abstract void a(C0307ho c0307ho);

    public final Object g() {
        return this.f;
    }
}
