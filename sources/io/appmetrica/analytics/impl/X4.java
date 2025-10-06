package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class X4 {

    /* renamed from: a  reason: collision with root package name */
    public final C0251fc f737a;

    public X4() {
        this(Na.j().k());
    }

    public static C0167c5 a(V4 v4) {
        return new C0167c5(new C0115a5(v4), v4);
    }

    public X4(C0251fc c0251fc) {
        this.f737a = c0251fc;
    }

    public final C0595sn a(V4 v4, Km km) {
        C0595sn c0595sn = new C0595sn(v4, new C0230eh(km));
        C0251fc c0251fc = this.f737a;
        synchronized (c0251fc) {
            c0251fc.c.add(c0595sn);
        }
        return c0595sn;
    }
}
