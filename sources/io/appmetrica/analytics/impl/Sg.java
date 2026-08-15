package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes5.dex */
public final class Sg implements InterfaceC0269g8 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0473o5 f766a;

    public Sg(InterfaceC0473o5 interfaceC0473o5) {
        this.f766a = interfaceC0473o5;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0269g8
    /* renamed from: b */
    public final Rg a(Context context, C0266g5 c0266g5, G4 g4) {
        return new Rg(context, c0266g5, g4, this.f766a, new C0292h5(), C0360jm.a());
    }

    public final InterfaceC0473o5 a() {
        return this.f766a;
    }
}
