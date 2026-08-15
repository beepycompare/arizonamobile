package io.appmetrica.analytics.impl;

import android.util.SparseArray;
/* renamed from: io.appmetrica.analytics.impl.m4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0420m4 extends AbstractC0377kd {

    /* renamed from: a  reason: collision with root package name */
    public final C0664vf f1093a;

    public C0420m4(C0664vf c0664vf) {
        this.f1093a = c0664vf;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0377kd
    public final void a(int i) {
        this.f1093a.c(i);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0377kd
    public final int b() {
        return (int) this.f1093a.a(-1L);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0377kd
    public final SparseArray<InterfaceC0351jd> c() {
        return new SparseArray<>();
    }
}
