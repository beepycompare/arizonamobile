package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.dn  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0207dn implements Ln {

    /* renamed from: a  reason: collision with root package name */
    public final Ln f963a;
    public final Object b;

    public C0207dn(Ln ln, Object obj) {
        this.f963a = ln;
        this.b = obj;
    }

    @Override // io.appmetrica.analytics.impl.Ln
    public final Object a(Object obj) {
        return obj != this.f963a.a(obj) ? this.b : obj;
    }
}
