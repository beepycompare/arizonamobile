package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class A4 {

    /* renamed from: a  reason: collision with root package name */
    public final Gb f391a;

    public A4() {
        this(C0471oa.k().l());
    }

    public static F4 a(C0714y4 c0714y4) {
        return new F4(new D4(c0714y4), c0714y4);
    }

    public A4(Gb gb) {
        this.f391a = gb;
    }

    public final C0434mn a(C0714y4 c0714y4, Bm bm) {
        C0434mn c0434mn = new C0434mn(c0714y4, new Jg(bm));
        Gb gb = this.f391a;
        synchronized (gb) {
            gb.c.add(c0434mn);
        }
        return c0434mn;
    }
}
