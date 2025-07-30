package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public final class Pg implements InterfaceC0304h8 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0599t5 f597a;

    public Pg(InterfaceC0599t5 interfaceC0599t5) {
        this.f597a = interfaceC0599t5;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0304h8
    /* renamed from: b */
    public final Og a(Context context, C0400l5 c0400l5, K4 k4) {
        return new Og(context, c0400l5, k4, this.f597a, new C0425m5(), Hl.a());
    }

    public final InterfaceC0599t5 a() {
        return this.f597a;
    }
}
