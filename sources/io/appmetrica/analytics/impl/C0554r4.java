package io.appmetrica.analytics.impl;

import android.content.Context;
import android.util.SparseArray;
/* renamed from: io.appmetrica.analytics.impl.r4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0554r4 extends AbstractC0189cd {

    /* renamed from: a  reason: collision with root package name */
    public final C0317hf f1018a;

    public C0554r4(Context context) {
        this(new C0317hf(C0557r7.a(context).b()));
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0189cd
    public final void a(int i) {
        this.f1018a.c(i);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0189cd
    public final int b() {
        return (int) this.f1018a.a(-1L);
    }

    @Override // io.appmetrica.analytics.impl.AbstractC0189cd
    public final SparseArray<InterfaceC0163bd> c() {
        return new SparseArray<>();
    }

    public C0554r4(C0317hf c0317hf) {
        this.f1018a = c0317hf;
    }
}
