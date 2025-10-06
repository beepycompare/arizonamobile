package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public class Lg {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0457nb f561a;
    public final Gg b;
    public final InterfaceC0405lb c;

    public Lg(InterfaceC0457nb interfaceC0457nb, Gg gg, InterfaceC0405lb interfaceC0405lb) {
        this.f561a = interfaceC0457nb;
        this.b = gg;
        this.c = interfaceC0405lb;
    }

    public final void a(Jg jg) {
        if (this.f561a.a(jg)) {
            this.b.a(jg);
            this.c.a();
        }
    }

    public final Gg b() {
        return this.b;
    }

    public final InterfaceC0405lb c() {
        return this.c;
    }

    public final InterfaceC0457nb a() {
        return this.f561a;
    }
}
