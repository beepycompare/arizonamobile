package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes5.dex */
public final class Wh implements InterfaceC0706x4 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0474o5 f828a;

    public Wh(InterfaceC0474o5 interfaceC0474o5) {
        this.f828a = interfaceC0474o5;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0706x4
    /* renamed from: b */
    public final Qg a(Context context, C0603t5 c0603t5, C0266g4 c0266g4, G4 g4) {
        Rg rg;
        C0267g5 c0267g5 = new C0267g5(c0266g4.b, c0266g4.f994a);
        Sg sg = new Sg(this.f828a);
        synchronized (c0603t5) {
            rg = (Rg) c0603t5.a(c0267g5, g4, sg, c0603t5.f1212a);
        }
        return new Qg(context, rg);
    }
}
