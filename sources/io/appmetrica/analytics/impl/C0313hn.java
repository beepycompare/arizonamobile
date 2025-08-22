package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.hn  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0313hn implements Nn {

    /* renamed from: a  reason: collision with root package name */
    public final Nn f895a;
    public final Object b;

    public C0313hn(Nn nn, Object obj) {
        this.f895a = nn;
        this.b = obj;
    }

    @Override // io.appmetrica.analytics.impl.Nn
    public final Object a(Object obj) {
        return obj != this.f895a.a(obj) ? this.b : obj;
    }
}
