package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes5.dex */
public final class Sg implements InterfaceC0270g8 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0474o5 f764a;

    public Sg(InterfaceC0474o5 interfaceC0474o5) {
        this.f764a = interfaceC0474o5;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0270g8
    /* renamed from: b */
    public final Rg a(Context context, C0267g5 c0267g5, G4 g4) {
        return new Rg(context, c0267g5, g4, this.f764a, new C0293h5(), C0361jm.a());
    }

    public final InterfaceC0474o5 a() {
        return this.f764a;
    }
}
