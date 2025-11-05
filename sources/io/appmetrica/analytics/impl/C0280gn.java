package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.gn  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0280gn implements Nn {

    /* renamed from: a  reason: collision with root package name */
    public final Nn f902a;
    public final Object b;

    public C0280gn(Nn nn, Object obj) {
        this.f902a = nn;
        this.b = obj;
    }

    @Override // io.appmetrica.analytics.impl.Nn
    public final Object a(Object obj) {
        return obj != this.f902a.a(obj) ? this.b : obj;
    }
}
