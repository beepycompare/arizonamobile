package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ln  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0416ln implements Rn {

    /* renamed from: a  reason: collision with root package name */
    public final Rn f980a;
    public final Object b;

    public C0416ln(Rn rn, Object obj) {
        this.f980a = rn;
        this.b = obj;
    }

    @Override // io.appmetrica.analytics.impl.Rn
    public final Object a(Object obj) {
        return obj != this.f980a.a(obj) ? this.b : obj;
    }
}
