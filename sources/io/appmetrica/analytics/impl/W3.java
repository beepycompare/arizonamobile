package io.appmetrica.analytics.impl;

import android.content.Context;
import android.util.SparseArray;
/* loaded from: classes5.dex */
public final class W3 extends Kc {

    /* renamed from: a  reason: collision with root package name */
    public final We f733a;

    public W3(Context context) {
        this(new We(C0158c4.l().c(context).b(context)));
    }

    @Override // io.appmetrica.analytics.impl.Kc
    public final void a(int i) {
        this.f733a.c(i);
    }

    @Override // io.appmetrica.analytics.impl.Kc
    public final int b() {
        return (int) this.f733a.a(-1L);
    }

    @Override // io.appmetrica.analytics.impl.Kc
    public final SparseArray<Jc> c() {
        return new SparseArray<>();
    }

    public W3(We we) {
        this.f733a = we;
    }
}
