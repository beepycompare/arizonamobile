package io.appmetrica.analytics.impl;

import android.content.Context;
import android.util.SparseArray;
/* renamed from: io.appmetrica.analytics.impl.d4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0184d4 extends Qc {

    /* renamed from: a  reason: collision with root package name */
    public final C0117af f840a;

    public C0184d4(Context context) {
        this(new C0117af(C0264g7.a(context).b()));
    }

    @Override // io.appmetrica.analytics.impl.Qc
    public final void a(int i) {
        this.f840a.c(i);
    }

    @Override // io.appmetrica.analytics.impl.Qc
    public final int b() {
        return (int) this.f840a.a(-1L);
    }

    @Override // io.appmetrica.analytics.impl.Qc
    public final SparseArray<Pc> c() {
        return new SparseArray<>();
    }

    public C0184d4(C0117af c0117af) {
        this.f840a = c0117af;
    }
}
