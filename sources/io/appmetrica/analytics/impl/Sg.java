package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes5.dex */
public final class Sg implements InterfaceC0263g8 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0467o5 f769a;

    public Sg(InterfaceC0467o5 interfaceC0467o5) {
        this.f769a = interfaceC0467o5;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0263g8
    /* renamed from: b */
    public final Rg a(Context context, C0260g5 c0260g5, G4 g4) {
        return new Rg(context, c0260g5, g4, this.f769a, new C0286h5(), C0354jm.a());
    }

    public final InterfaceC0467o5 a() {
        return this.f769a;
    }
}
