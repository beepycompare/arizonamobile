package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public abstract class S2 {

    /* renamed from: a  reason: collision with root package name */
    public final Of f618a;
    public final Xa b;

    public S2(Of of, Xa xa) {
        this.f618a = of;
        this.b = xa;
    }

    public final boolean a(C0333i6 c0333i6, R2 r2) {
        for (Object obj : ((C0460n9) this.f618a.a(c0333i6.d)).f953a) {
            if (r2.a(obj, c0333i6)) {
                return true;
            }
        }
        return false;
    }

    public final Of b() {
        return this.f618a;
    }

    public final Xa a() {
        return this.b;
    }
}
