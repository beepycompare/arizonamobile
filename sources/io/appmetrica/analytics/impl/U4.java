package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class U4 {

    /* renamed from: a  reason: collision with root package name */
    public final Yb f653a;

    public U4() {
        this(Ga.j().k());
    }

    public static Z4 a(S4 s4) {
        return new Z4(new X4(s4), s4);
    }

    public U4(Yb yb) {
        this.f653a = yb;
    }

    public final C0292gn a(S4 s4, C0739ym c0739ym) {
        C0292gn c0292gn = new C0292gn(s4, new Tg(c0739ym));
        Yb yb = this.f653a;
        synchronized (yb) {
            yb.c.add(c0292gn);
        }
        return c0292gn;
    }
}
