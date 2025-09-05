package io.appmetrica.analytics.impl;

import android.content.Context;
import android.util.SparseArray;
/* renamed from: io.appmetrica.analytics.impl.u4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0625u4 extends AbstractC0354jd {

    /* renamed from: a  reason: collision with root package name */
    public final C0512pf f1100a;

    public C0625u4(Context context) {
        this(new C0512pf(C0728y7.a(context).b()));
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0354jd
    public final void a(int i) {
        this.f1100a.c(i);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0354jd
    public final int b() {
        return (int) this.f1100a.a(-1L);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0354jd
    public final SparseArray<InterfaceC0329id> c() {
        return new SparseArray<>();
    }

    public C0625u4(C0512pf c0512pf) {
        this.f1100a = c0512pf;
    }
}
