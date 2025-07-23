package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public class Cg {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0332ib f379a;
    public final InterfaceC0710xg b;
    public final InterfaceC0282gb c;

    public Cg(InterfaceC0332ib interfaceC0332ib, InterfaceC0710xg interfaceC0710xg, InterfaceC0282gb interfaceC0282gb) {
        this.f379a = interfaceC0332ib;
        this.b = interfaceC0710xg;
        this.c = interfaceC0282gb;
    }

    public final void a(Ag ag) {
        if (this.f379a.a(ag)) {
            this.b.a(ag);
            this.c.a();
        }
    }

    public final InterfaceC0710xg b() {
        return this.b;
    }

    public final InterfaceC0282gb c() {
        return this.c;
    }

    public final InterfaceC0332ib a() {
        return this.f379a;
    }
}
