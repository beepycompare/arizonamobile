package io.appmetrica.analytics.impl;

import android.util.SparseArray;
/* renamed from: io.appmetrica.analytics.impl.m4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0419m4 extends AbstractC0376kd {

    /* renamed from: a  reason: collision with root package name */
    public final C0663vf f1093a;

    public C0419m4(C0663vf c0663vf) {
        this.f1093a = c0663vf;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0376kd
    public final void a(int i) {
        this.f1093a.c(i);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0376kd
    public final int b() {
        return (int) this.f1093a.a(-1L);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0376kd
    public final SparseArray<InterfaceC0350jd> c() {
        return new SparseArray<>();
    }
}
