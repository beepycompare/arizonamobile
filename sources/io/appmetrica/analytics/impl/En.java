package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class En implements InterfaceC0493oo {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0493oo f532a;
    public final Object b;

    public En(InterfaceC0493oo interfaceC0493oo, Object obj) {
        this.f532a = interfaceC0493oo;
        this.b = obj;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0493oo
    public final Object a(Object obj) {
        return obj != this.f532a.a(obj) ? this.b : obj;
    }
}
