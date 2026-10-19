package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class En implements InterfaceC0486oo {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0486oo f538a;
    public final Object b;

    public En(InterfaceC0486oo interfaceC0486oo, Object obj) {
        this.f538a = interfaceC0486oo;
        this.b = obj;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0486oo
    public final Object a(Object obj) {
        return obj != this.f538a.a(obj) ? this.b : obj;
    }
}
