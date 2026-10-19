package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class P4 {

    /* renamed from: a  reason: collision with root package name */
    public final C0293hc f717a;

    public P4() {
        this(Na.k().l());
    }

    public static U4 a(N4 n4) {
        return new U4(new S4(n4), n4);
    }

    public P4(C0293hc c0293hc) {
        this.f717a = c0293hc;
    }

    public final Mn a(N4 n4, C0175cn c0175cn) {
        Mn mn = new Mn(n4, new Yg(c0175cn));
        C0293hc c0293hc = this.f717a;
        synchronized (c0293hc) {
            c0293hc.c.add(mn);
        }
        return mn;
    }
}
