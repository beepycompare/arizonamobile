package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public class Hg {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0378kb f478a;
    public final Cg b;
    public final InterfaceC0327ib c;

    public Hg(InterfaceC0378kb interfaceC0378kb, Cg cg, InterfaceC0327ib interfaceC0327ib) {
        this.f478a = interfaceC0378kb;
        this.b = cg;
        this.c = interfaceC0327ib;
    }

    public final void a(Fg fg) {
        if (this.f478a.a(fg)) {
            this.b.a(fg);
            this.c.a();
        }
    }

    public final Cg b() {
        return this.b;
    }

    public final InterfaceC0327ib c() {
        return this.c;
    }

    public final InterfaceC0378kb a() {
        return this.f478a;
    }
}
