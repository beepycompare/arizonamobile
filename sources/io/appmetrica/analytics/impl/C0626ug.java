package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ug  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0626ug {

    /* renamed from: a  reason: collision with root package name */
    public final Ua f1152a;
    public final InterfaceC0502pg b;
    public final Sa c;

    public C0626ug(Ua ua, InterfaceC0502pg interfaceC0502pg, Sa sa) {
        this.f1152a = ua;
        this.b = interfaceC0502pg;
        this.c = sa;
    }

    public final void a(C0576sg c0576sg) {
        if (this.f1152a.a(c0576sg)) {
            this.b.a(c0576sg);
            this.c.a();
        }
    }

    public final InterfaceC0502pg b() {
        return this.b;
    }

    public final Sa c() {
        return this.c;
    }

    public final Ua a() {
        return this.f1152a;
    }
}
