package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class P4 {

    /* renamed from: a  reason: collision with root package name */
    public final C0299hc f714a;

    public P4() {
        this(Na.k().l());
    }

    public static U4 a(N4 n4) {
        return new U4(new S4(n4), n4);
    }

    public P4(C0299hc c0299hc) {
        this.f714a = c0299hc;
    }

    public final Mn a(N4 n4, C0181cn c0181cn) {
        Mn mn = new Mn(n4, new Yg(c0181cn));
        C0299hc c0299hc = this.f714a;
        synchronized (c0299hc) {
            c0299hc.c.add(mn);
        }
        return mn;
    }
}
