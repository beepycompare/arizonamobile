package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public class Ag {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0280gb f338a;
    public final InterfaceC0658vg b;
    public final InterfaceC0230eb c;

    public Ag(InterfaceC0280gb interfaceC0280gb, InterfaceC0658vg interfaceC0658vg, InterfaceC0230eb interfaceC0230eb) {
        this.f338a = interfaceC0280gb;
        this.b = interfaceC0658vg;
        this.c = interfaceC0230eb;
    }

    public final void a(C0733yg c0733yg) {
        if (this.f338a.a(c0733yg)) {
            this.b.a(c0733yg);
            this.c.a();
        }
    }

    public final InterfaceC0658vg b() {
        return this.b;
    }

    public final InterfaceC0230eb c() {
        return this.c;
    }

    public final InterfaceC0280gb a() {
        return this.f338a;
    }
}
