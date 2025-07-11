package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Zm implements Fn {

    /* renamed from: a  reason: collision with root package name */
    public final Fn f744a;
    public final Object b;

    public Zm(Fn fn, Object obj) {
        this.f744a = fn;
        this.b = obj;
    }

    @Override // io.appmetrica.analytics.impl.Fn
    public final Object a(Object obj) {
        return obj != this.f744a.a(obj) ? this.b : obj;
    }
}
