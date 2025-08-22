package io.appmetrica.analytics.impl;

import android.content.Context;
import android.util.SparseArray;
/* renamed from: io.appmetrica.analytics.impl.r4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0546r4 extends AbstractC0277gd {

    /* renamed from: a  reason: collision with root package name */
    public final C0408lf f1038a;

    public C0546r4(Context context) {
        this(new C0408lf(C0649v7.a(context).b()));
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0277gd
    public final void a(int i) {
        this.f1038a.c(i);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0277gd
    public final int b() {
        return (int) this.f1038a.a(-1L);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0277gd
    public final SparseArray<InterfaceC0251fd> c() {
        return new SparseArray<>();
    }

    public C0546r4(C0408lf c0408lf) {
        this.f1038a = c0408lf;
    }
}
