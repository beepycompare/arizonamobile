package io.appmetrica.analytics.impl;

import android.content.Context;
import android.util.SparseArray;
/* renamed from: io.appmetrica.analytics.impl.r4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0549r4 extends AbstractC0233ed {

    /* renamed from: a  reason: collision with root package name */
    public final C0361jf f1030a;

    public C0549r4(Context context) {
        this(new C0361jf(C0627u7.a(context).b()));
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0233ed
    public final void a(int i) {
        this.f1030a.c(i);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0233ed
    public final int b() {
        return (int) this.f1030a.a(-1L);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0233ed
    public final SparseArray<InterfaceC0208dd> c() {
        return new SparseArray<>();
    }

    public C0549r4(C0361jf c0361jf) {
        this.f1030a = c0361jf;
    }
}
