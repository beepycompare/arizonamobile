package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public abstract class S2 {

    /* renamed from: a  reason: collision with root package name */
    public final Of f619a;
    public final Xa b;

    public S2(Of of, Xa xa) {
        this.f619a = of;
        this.b = xa;
    }

    public final boolean a(C0325i6 c0325i6, R2 r2) {
        for (Object obj : ((C0452n9) this.f619a.a(c0325i6.d)).f954a) {
            if (r2.a(obj, c0325i6)) {
                return true;
            }
        }
        return false;
    }

    public final Of b() {
        return this.f619a;
    }

    public final Xa a() {
        return this.b;
    }
}
