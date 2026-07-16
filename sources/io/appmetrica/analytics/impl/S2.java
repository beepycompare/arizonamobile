package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public abstract class S2 {

    /* renamed from: a  reason: collision with root package name */
    public final AbstractC0278gg f758a;
    public final InterfaceC0273gb b;

    public S2(AbstractC0278gg abstractC0278gg, InterfaceC0273gb interfaceC0273gb) {
        this.f758a = abstractC0278gg;
        this.b = interfaceC0273gb;
    }

    public final boolean a(C0242f6 c0242f6, R2 r2) {
        for (Object obj : ((C0504p9) this.f758a.a(c0242f6.d)).f1147a) {
            if (r2.a(obj, c0242f6)) {
                return true;
            }
        }
        return false;
    }

    public final AbstractC0278gg b() {
        return this.f758a;
    }

    public final InterfaceC0273gb a() {
        return this.b;
    }
}
