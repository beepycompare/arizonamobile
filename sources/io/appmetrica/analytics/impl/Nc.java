package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes5.dex */
public final class Nc implements InterfaceC0705x4 {
    @Override // io.appmetrica.analytics.impl.InterfaceC0705x4
    /* renamed from: b */
    public final Oc a(Context context, C0602t5 c0602t5, C0265g4 c0265g4, G4 g4) {
        Rg rg;
        Pc pc = new Pc(c0265g4.b, c0265g4.f994a);
        Sg sg = new Sg(new Rc());
        synchronized (c0602t5) {
            rg = (Rg) c0602t5.a(pc, g4, sg, c0602t5.f1212a);
        }
        return new Oc(context, rg);
    }
}
