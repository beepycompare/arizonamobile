package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public abstract class S2 {

    /* renamed from: a  reason: collision with root package name */
    public final Vf f644a;
    public final InterfaceC0146bb b;

    public S2(Vf vf, InterfaceC0146bb interfaceC0146bb) {
        this.f644a = vf;
        this.b = interfaceC0146bb;
    }

    public final boolean a(C0399l6 c0399l6, R2 r2) {
        for (Object obj : ((C0576s9) this.f644a.a(c0399l6.d)).f1057a) {
            if (r2.a(obj, c0399l6)) {
                return true;
            }
        }
        return false;
    }

    public final Vf b() {
        return this.f644a;
    }

    public final InterfaceC0146bb a() {
        return this.b;
    }
}
