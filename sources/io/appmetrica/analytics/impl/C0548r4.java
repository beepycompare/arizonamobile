package io.appmetrica.analytics.impl;

import android.content.Context;
import android.util.SparseArray;
/* renamed from: io.appmetrica.analytics.impl.r4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0548r4 extends AbstractC0232ed {

    /* renamed from: a  reason: collision with root package name */
    public final C0360jf f1031a;

    public C0548r4(Context context) {
        this(new C0360jf(C0626u7.a(context).b()));
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0232ed
    public final void a(int i) {
        this.f1031a.c(i);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0232ed
    public final int b() {
        return (int) this.f1031a.a(-1L);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0232ed
    public final SparseArray<InterfaceC0207dd> c() {
        return new SparseArray<>();
    }

    public C0548r4(C0360jf c0360jf) {
        this.f1031a = c0360jf;
    }
}
