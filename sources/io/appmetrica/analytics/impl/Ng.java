package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public final class Ng implements InterfaceC0227e8 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0597t5 f555a;

    public Ng(InterfaceC0597t5 interfaceC0597t5) {
        this.f555a = interfaceC0597t5;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0227e8
    /* renamed from: b */
    public final Mg a(Context context, C0398l5 c0398l5, K4 k4) {
        return new Mg(context, c0398l5, k4, this.f555a, new C0423m5(), El.a());
    }

    public final InterfaceC0597t5 a() {
        return this.f555a;
    }
}
