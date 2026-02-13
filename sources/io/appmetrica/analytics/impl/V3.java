package io.appmetrica.analytics.impl;

import android.content.Context;
import android.util.SparseArray;
/* loaded from: classes5.dex */
public final class V3 extends Jc {

    /* renamed from: a  reason: collision with root package name */
    public final Ve f821a;

    public V3(Context context) {
        this(new Ve(C0136b4.l().c(context).b(context)));
    }

    @Override // io.appmetrica.analytics.impl.Jc
    public final void a(int i) {
        this.f821a.c(i);
    }

    @Override // io.appmetrica.analytics.impl.Jc
    public final int b() {
        return (int) this.f821a.a(-1L);
    }

    @Override // io.appmetrica.analytics.impl.Jc
    public final SparseArray<Ic> c() {
        return new SparseArray<>();
    }

    public V3(Ve ve) {
        this.f821a = ve;
    }
}
