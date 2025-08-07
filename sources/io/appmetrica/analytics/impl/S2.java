package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public abstract class S2 {

    /* renamed from: a  reason: collision with root package name */
    public final Qf f630a;
    public final Za b;

    public S2(Qf qf, Za za) {
        this.f630a = qf;
        this.b = za;
    }

    public final boolean a(C0402l6 c0402l6, R2 r2) {
        for (Object obj : ((C0530q9) this.f630a.a(c0402l6.d)).f1015a) {
            if (r2.a(obj, c0402l6)) {
                return true;
            }
        }
        return false;
    }

    public final Qf b() {
        return this.f630a;
    }

    public final Za a() {
        return this.b;
    }
}
