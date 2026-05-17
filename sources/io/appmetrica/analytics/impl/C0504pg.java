package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.pg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0504pg {

    /* renamed from: a  reason: collision with root package name */
    public final Na f1181a;
    public final InterfaceC0379kg b;
    public final La c;

    public C0504pg(Na na, InterfaceC0379kg interfaceC0379kg, La la) {
        this.f1181a = na;
        this.b = interfaceC0379kg;
        this.c = la;
    }

    public final void a(C0454ng c0454ng) {
        if (this.f1181a.a(c0454ng)) {
            this.b.a(c0454ng);
            this.c.a();
        }
    }

    public final InterfaceC0379kg b() {
        return this.b;
    }

    public final La c() {
        return this.c;
    }

    public final Na a() {
        return this.f1181a;
    }
}
