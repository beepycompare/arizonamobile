package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public abstract class N2 {

    /* renamed from: a  reason: collision with root package name */
    public final Kf f600a;
    public final La b;

    public N2(Kf kf, La la) {
        this.f600a = kf;
        this.b = la;
    }

    public final boolean a(W5 w5, M2 m2) {
        for (Object obj : ((C0163c9) this.f600a.a(w5.d)).f826a) {
            if (m2.a(obj, w5)) {
                return true;
            }
        }
        return false;
    }

    public final Kf b() {
        return this.f600a;
    }

    public final La a() {
        return this.b;
    }
}
