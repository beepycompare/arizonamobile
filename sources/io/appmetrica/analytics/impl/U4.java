package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class U4 {

    /* renamed from: a  reason: collision with root package name */
    public final C0128ac f665a;

    public U4() {
        this(Ia.j().k());
    }

    public static Z4 a(S4 s4) {
        return new Z4(new X4(s4), s4);
    }

    public U4(C0128ac c0128ac) {
        this.f665a = c0128ac;
    }

    public final C0368jn a(S4 s4, Bm bm) {
        C0368jn c0368jn = new C0368jn(s4, new Vg(bm));
        C0128ac c0128ac = this.f665a;
        synchronized (c0128ac) {
            c0128ac.c.add(c0368jn);
        }
        return c0368jn;
    }
}
