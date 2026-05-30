package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes5.dex */
public final class Lj implements InterfaceC0706x4 {
    @Override // io.appmetrica.analytics.impl.InterfaceC0706x4
    /* renamed from: b */
    public final Hj a(Context context, C0603t5 c0603t5, C0266g4 c0266g4, G4 g4) {
        Rg rg;
        C0267g5 c0267g5 = new C0267g5(c0266g4.b, c0266g4.f992a);
        synchronized (c0603t5) {
            rg = (Rg) c0603t5.f1210a.get(c0267g5.toString());
        }
        return new Hj(rg);
    }
}
