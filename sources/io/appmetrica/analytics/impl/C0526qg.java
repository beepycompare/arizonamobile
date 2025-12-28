package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.qg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0526qg {

    /* renamed from: a  reason: collision with root package name */
    public final Oa f1187a;
    public final InterfaceC0401lg b;
    public final Ma c;

    public C0526qg(Oa oa, InterfaceC0401lg interfaceC0401lg, Ma ma) {
        this.f1187a = oa;
        this.b = interfaceC0401lg;
        this.c = ma;
    }

    public final void a(C0476og c0476og) {
        if (this.f1187a.a(c0476og)) {
            this.b.a(c0476og);
            this.c.a();
        }
    }

    public final InterfaceC0401lg b() {
        return this.b;
    }

    public final Ma c() {
        return this.c;
    }

    public final Oa a() {
        return this.f1187a;
    }
}
