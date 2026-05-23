package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class P4 {

    /* renamed from: a  reason: collision with root package name */
    public final C0300hc f711a;

    public P4() {
        this(Na.k().l());
    }

    public static U4 a(N4 n4) {
        return new U4(new S4(n4), n4);
    }

    public P4(C0300hc c0300hc) {
        this.f711a = c0300hc;
    }

    public final Mn a(N4 n4, C0182cn c0182cn) {
        Mn mn = new Mn(n4, new Yg(c0182cn));
        C0300hc c0300hc = this.f711a;
        synchronized (c0300hc) {
            c0300hc.c.add(mn);
        }
        return mn;
    }
}
