package io.appmetrica.analytics.impl;

import android.util.SparseArray;
/* renamed from: io.appmetrica.analytics.impl.m4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0421m4 extends AbstractC0378kd {

    /* renamed from: a  reason: collision with root package name */
    public final C0665vf f1091a;

    public C0421m4(C0665vf c0665vf) {
        this.f1091a = c0665vf;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0378kd
    public final void a(int i) {
        this.f1091a.c(i);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0378kd
    public final int b() {
        return (int) this.f1091a.a(-1L);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0378kd
    public final SparseArray<InterfaceC0352jd> c() {
        return new SparseArray<>();
    }
}
