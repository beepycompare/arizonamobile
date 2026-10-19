package io.appmetrica.analytics.impl;

import android.util.SparseArray;
/* renamed from: io.appmetrica.analytics.impl.m4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0414m4 extends AbstractC0371kd {

    /* renamed from: a  reason: collision with root package name */
    public final C0658vf f1096a;

    public C0414m4(C0658vf c0658vf) {
        this.f1096a = c0658vf;
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0371kd
    public final void a(int i) {
        this.f1096a.c(i);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0371kd
    public final int b() {
        return (int) this.f1096a.a(-1L);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0371kd
    public final SparseArray<InterfaceC0345jd> c() {
        return new SparseArray<>();
    }
}
