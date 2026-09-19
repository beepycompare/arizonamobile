package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public abstract class S2 {

    /* renamed from: a  reason: collision with root package name */
    public final AbstractC0276gg f758a;
    public final InterfaceC0271gb b;

    public S2(AbstractC0276gg abstractC0276gg, InterfaceC0271gb interfaceC0271gb) {
        this.f758a = abstractC0276gg;
        this.b = interfaceC0271gb;
    }

    public final boolean a(C0240f6 c0240f6, R2 r2) {
        for (Object obj : ((C0502p9) this.f758a.a(c0240f6.d)).f1147a) {
            if (r2.a(obj, c0240f6)) {
                return true;
            }
        }
        return false;
    }

    public final AbstractC0276gg b() {
        return this.f758a;
    }

    public final InterfaceC0271gb a() {
        return this.b;
    }
}
