package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.cn  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0191cn implements In {

    /* renamed from: a  reason: collision with root package name */
    public final In f805a;
    public final Object b;

    public C0191cn(In in, Object obj) {
        this.f805a = in;
        this.b = obj;
    }

    @Override // io.appmetrica.analytics.impl.In
    public final Object a(Object obj) {
        return obj != this.f805a.a(obj) ? this.b : obj;
    }
}
