package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class En implements InterfaceC0491oo {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0491oo f535a;
    public final Object b;

    public En(InterfaceC0491oo interfaceC0491oo, Object obj) {
        this.f535a = interfaceC0491oo;
        this.b = obj;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0491oo
    public final Object a(Object obj) {
        return obj != this.f535a.a(obj) ? this.b : obj;
    }
}
