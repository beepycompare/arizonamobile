package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public abstract class S2 {

    /* renamed from: a  reason: collision with root package name */
    public final AbstractC0271gg f761a;
    public final InterfaceC0266gb b;

    public S2(AbstractC0271gg abstractC0271gg, InterfaceC0266gb interfaceC0266gb) {
        this.f761a = abstractC0271gg;
        this.b = interfaceC0266gb;
    }

    public final boolean a(C0235f6 c0235f6, R2 r2) {
        for (Object obj : ((C0497p9) this.f761a.a(c0235f6.d)).f1150a) {
            if (r2.a(obj, c0235f6)) {
                return true;
            }
        }
        return false;
    }

    public final AbstractC0271gg b() {
        return this.f761a;
    }

    public final InterfaceC0266gb a() {
        return this.b;
    }
}
