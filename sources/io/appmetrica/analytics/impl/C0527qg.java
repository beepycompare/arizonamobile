package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.qg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0527qg {

    /* renamed from: a  reason: collision with root package name */
    public final Oa f1089a;
    public final InterfaceC0402lg b;
    public final Ma c;

    public C0527qg(Oa oa, InterfaceC0402lg interfaceC0402lg, Ma ma) {
        this.f1089a = oa;
        this.b = interfaceC0402lg;
        this.c = ma;
    }

    public final void a(C0477og c0477og) {
        if (this.f1089a.a(c0477og)) {
            this.b.a(c0477og);
            this.c.a();
        }
    }

    public final InterfaceC0402lg b() {
        return this.b;
    }

    public final Ma c() {
        return this.c;
    }

    public final Oa a() {
        return this.f1089a;
    }
}
