package io.appmetrica.analytics.impl;

import android.content.Context;
import android.util.SparseArray;
/* renamed from: io.appmetrica.analytics.impl.r4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0546r4 extends AbstractC0181cd {

    /* renamed from: a  reason: collision with root package name */
    public final C0309hf f1019a;

    public C0546r4(Context context) {
        this(new C0309hf(C0549r7.a(context).b()));
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0181cd
    public final void a(int i) {
        this.f1019a.c(i);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0181cd
    public final int b() {
        return (int) this.f1019a.a(-1L);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0181cd
    public final SparseArray<InterfaceC0155bd> c() {
        return new SparseArray<>();
    }

    public C0546r4(C0309hf c0309hf) {
        this.f1019a = c0309hf;
    }
}
