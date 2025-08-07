package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class U4 {

    /* renamed from: a  reason: collision with root package name */
    public final C0129ac f664a;

    public U4() {
        this(Ia.j().k());
    }

    public static Z4 a(S4 s4) {
        return new Z4(new X4(s4), s4);
    }

    public U4(C0129ac c0129ac) {
        this.f664a = c0129ac;
    }

    public final C0369jn a(S4 s4, Bm bm) {
        C0369jn c0369jn = new C0369jn(s4, new Vg(bm));
        C0129ac c0129ac = this.f664a;
        synchronized (c0129ac) {
            c0129ac.c.add(c0369jn);
        }
        return c0369jn;
    }
}
