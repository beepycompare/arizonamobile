package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class X4 {

    /* renamed from: a  reason: collision with root package name */
    public final C0250fc f736a;

    public X4() {
        this(Na.j().k());
    }

    public static C0166c5 a(V4 v4) {
        return new C0166c5(new C0114a5(v4), v4);
    }

    public X4(C0250fc c0250fc) {
        this.f736a = c0250fc;
    }

    public final C0594sn a(V4 v4, Km km) {
        C0594sn c0594sn = new C0594sn(v4, new C0229eh(km));
        C0250fc c0250fc = this.f736a;
        synchronized (c0250fc) {
            c0250fc.c.add(c0594sn);
        }
        return c0594sn;
    }
}
