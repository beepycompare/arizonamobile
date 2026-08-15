package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class En implements InterfaceC0492oo {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0492oo f535a;
    public final Object b;

    public En(InterfaceC0492oo interfaceC0492oo, Object obj) {
        this.f535a = interfaceC0492oo;
        this.b = obj;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0492oo
    public final Object a(Object obj) {
        return obj != this.f535a.a(obj) ? this.b : obj;
    }
}
