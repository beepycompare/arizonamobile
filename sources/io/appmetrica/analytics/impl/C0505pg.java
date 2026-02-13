package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.pg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0505pg {

    /* renamed from: a  reason: collision with root package name */
    public final Na f1176a;
    public final InterfaceC0380kg b;
    public final La c;

    public C0505pg(Na na, InterfaceC0380kg interfaceC0380kg, La la) {
        this.f1176a = na;
        this.b = interfaceC0380kg;
        this.c = la;
    }

    public final void a(C0455ng c0455ng) {
        if (this.f1176a.a(c0455ng)) {
            this.b.a(c0455ng);
            this.c.a();
        }
    }

    public final InterfaceC0380kg b() {
        return this.b;
    }

    public final La c() {
        return this.c;
    }

    public final Na a() {
        return this.f1176a;
    }
}
