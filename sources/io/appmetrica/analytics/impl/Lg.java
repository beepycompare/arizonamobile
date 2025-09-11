package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public class Lg {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0456nb f560a;
    public final Gg b;
    public final InterfaceC0404lb c;

    public Lg(InterfaceC0456nb interfaceC0456nb, Gg gg, InterfaceC0404lb interfaceC0404lb) {
        this.f560a = interfaceC0456nb;
        this.b = gg;
        this.c = interfaceC0404lb;
    }

    public final void a(Jg jg) {
        if (this.f560a.a(jg)) {
            this.b.a(jg);
            this.c.a();
        }
    }

    public final Gg b() {
        return this.b;
    }

    public final InterfaceC0404lb c() {
        return this.c;
    }

    public final InterfaceC0456nb a() {
        return this.f560a;
    }
}
