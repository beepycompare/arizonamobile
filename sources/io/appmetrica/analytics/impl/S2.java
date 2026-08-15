package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public abstract class S2 {

    /* renamed from: a  reason: collision with root package name */
    public final AbstractC0277gg f758a;
    public final InterfaceC0272gb b;

    public S2(AbstractC0277gg abstractC0277gg, InterfaceC0272gb interfaceC0272gb) {
        this.f758a = abstractC0277gg;
        this.b = interfaceC0272gb;
    }

    public final boolean a(C0241f6 c0241f6, R2 r2) {
        for (Object obj : ((C0503p9) this.f758a.a(c0241f6.d)).f1147a) {
            if (r2.a(obj, c0241f6)) {
                return true;
            }
        }
        return false;
    }

    public final AbstractC0277gg b() {
        return this.f758a;
    }

    public final InterfaceC0272gb a() {
        return this.b;
    }
}
