package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.en  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0228en implements Mn {

    /* renamed from: a  reason: collision with root package name */
    public final Mn f876a;
    public final Object b;

    public C0228en(Mn mn, Object obj) {
        this.f876a = mn;
        this.b = obj;
    }

    @Override // io.appmetrica.analytics.impl.Mn
    public final Object a(Object obj) {
        return obj != this.f876a.a(obj) ? this.b : obj;
    }
}
