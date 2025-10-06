package io.appmetrica.analytics.impl;

import android.content.Context;
import android.util.SparseArray;
/* renamed from: io.appmetrica.analytics.impl.u4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0626u4 extends AbstractC0355jd {

    /* renamed from: a  reason: collision with root package name */
    public final C0513pf f1105a;

    public C0626u4(Context context) {
        this(new C0513pf(C0729y7.a(context).b()));
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0355jd
    public final void a(int i) {
        this.f1105a.c(i);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0355jd
    public final int b() {
        return (int) this.f1105a.a(-1L);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0355jd
    public final SparseArray<InterfaceC0330id> c() {
        return new SparseArray<>();
    }

    public C0626u4(C0513pf c0513pf) {
        this.f1105a = c0513pf;
    }
}
