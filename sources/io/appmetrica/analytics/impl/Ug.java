package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes4.dex */
public final class Ug implements InterfaceC0349j8 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0597t5 f678a;

    public Ug(InterfaceC0597t5 interfaceC0597t5) {
        this.f678a = interfaceC0597t5;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0349j8
    /* renamed from: b */
    public final Tg a(Context context, C0398l5 c0398l5, K4 k4) {
        return new Tg(context, c0398l5, k4, this.f678a, new C0423m5(), Ml.a());
    }

    public final InterfaceC0597t5 a() {
        return this.f678a;
    }
}
