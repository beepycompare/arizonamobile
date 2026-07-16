package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes5.dex */
public final class Ij implements InterfaceC0706x4 {
    @Override // io.appmetrica.analytics.impl.InterfaceC0706x4
    /* renamed from: b */
    public final Hj a(Context context, C0603t5 c0603t5, C0266g4 c0266g4, G4 g4) {
        Rg rg;
        Pc pc = new Pc(c0266g4.b, c0266g4.f994a);
        synchronized (c0603t5) {
            rg = (Rg) c0603t5.f1212a.get(pc.toString());
        }
        return new Hj(rg);
    }
}
