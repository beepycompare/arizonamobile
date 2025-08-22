package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class U4 {

    /* renamed from: a  reason: collision with root package name */
    public final C0173cc f672a;

    public U4() {
        this(Ka.j().k());
    }

    public static Z4 a(S4 s4) {
        return new Z4(new X4(s4), s4);
    }

    public U4(C0173cc c0173cc) {
        this.f672a = c0173cc;
    }

    public final C0491on a(S4 s4, Gm gm) {
        C0491on c0491on = new C0491on(s4, new C0126ah(gm));
        C0173cc c0173cc = this.f672a;
        synchronized (c0173cc) {
            c0173cc.c.add(c0491on);
        }
        return c0491on;
    }
}
