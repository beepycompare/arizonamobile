package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public class Ag {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0288gb f337a;
    public final InterfaceC0666vg b;
    public final InterfaceC0238eb c;

    public Ag(InterfaceC0288gb interfaceC0288gb, InterfaceC0666vg interfaceC0666vg, InterfaceC0238eb interfaceC0238eb) {
        this.f337a = interfaceC0288gb;
        this.b = interfaceC0666vg;
        this.c = interfaceC0238eb;
    }

    public final void a(C0741yg c0741yg) {
        if (this.f337a.a(c0741yg)) {
            this.b.a(c0741yg);
            this.c.a();
        }
    }

    public final InterfaceC0666vg b() {
        return this.b;
    }

    public final InterfaceC0238eb c() {
        return this.c;
    }

    public final InterfaceC0288gb a() {
        return this.f337a;
    }
}
