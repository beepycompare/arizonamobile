package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class A4 {

    /* renamed from: a  reason: collision with root package name */
    public final Gb f474a;

    public A4() {
        this(C0470oa.k().l());
    }

    public static F4 a(C0713y4 c0713y4) {
        return new F4(new D4(c0713y4), c0713y4);
    }

    public A4(Gb gb) {
        this.f474a = gb;
    }

    public final C0433mn a(C0713y4 c0713y4, Bm bm) {
        C0433mn c0433mn = new C0433mn(c0713y4, new Jg(bm));
        Gb gb = this.f474a;
        synchronized (gb) {
            gb.c.add(c0433mn);
        }
        return c0433mn;
    }
}
