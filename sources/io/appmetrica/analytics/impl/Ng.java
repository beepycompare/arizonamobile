package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public final class Ng implements InterfaceC0235e8 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0605t5 f554a;

    public Ng(InterfaceC0605t5 interfaceC0605t5) {
        this.f554a = interfaceC0605t5;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0235e8
    /* renamed from: b */
    public final Mg a(Context context, C0406l5 c0406l5, K4 k4) {
        return new Mg(context, c0406l5, k4, this.f554a, new C0431m5(), El.a());
    }

    public final InterfaceC0605t5 a() {
        return this.f554a;
    }
}
