package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes5.dex */
public final class Sg implements InterfaceC0268g8 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0472o5 f766a;

    public Sg(InterfaceC0472o5 interfaceC0472o5) {
        this.f766a = interfaceC0472o5;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0268g8
    /* renamed from: b */
    public final Rg a(Context context, C0265g5 c0265g5, G4 g4) {
        return new Rg(context, c0265g5, g4, this.f766a, new C0291h5(), C0359jm.a());
    }

    public final InterfaceC0472o5 a() {
        return this.f766a;
    }
}
