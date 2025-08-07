package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public final class Pg implements InterfaceC0305h8 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0600t5 f596a;

    public Pg(InterfaceC0600t5 interfaceC0600t5) {
        this.f596a = interfaceC0600t5;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0305h8
    /* renamed from: b */
    public final Og a(Context context, C0401l5 c0401l5, K4 k4) {
        return new Og(context, c0401l5, k4, this.f596a, new C0426m5(), Hl.a());
    }

    public final InterfaceC0600t5 a() {
        return this.f596a;
    }
}
