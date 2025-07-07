package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class U4 {

    /* renamed from: a  reason: collision with root package name */
    public final Yb f652a;

    public U4() {
        this(Ga.j().k());
    }

    public static Z4 a(S4 s4) {
        return new Z4(new X4(s4), s4);
    }

    public U4(Yb yb) {
        this.f652a = yb;
    }

    public final C0300gn a(S4 s4, C0747ym c0747ym) {
        C0300gn c0300gn = new C0300gn(s4, new Tg(c0747ym));
        Yb yb = this.f652a;
        synchronized (yb) {
            yb.c.add(c0300gn);
        }
        return c0300gn;
    }
}
