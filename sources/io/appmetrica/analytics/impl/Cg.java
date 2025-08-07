package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public class Cg {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0333ib f379a;
    public final InterfaceC0711xg b;
    public final InterfaceC0283gb c;

    public Cg(InterfaceC0333ib interfaceC0333ib, InterfaceC0711xg interfaceC0711xg, InterfaceC0283gb interfaceC0283gb) {
        this.f379a = interfaceC0333ib;
        this.b = interfaceC0711xg;
        this.c = interfaceC0283gb;
    }

    public final void a(Ag ag) {
        if (this.f379a.a(ag)) {
            this.b.a(ag);
            this.c.a();
        }
    }

    public final InterfaceC0711xg b() {
        return this.b;
    }

    public final InterfaceC0283gb c() {
        return this.c;
    }

    public final InterfaceC0333ib a() {
        return this.f379a;
    }
}
