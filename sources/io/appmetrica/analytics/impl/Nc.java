package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes5.dex */
public final class Nc implements InterfaceC0704x4 {
    @Override // io.appmetrica.analytics.impl.InterfaceC0704x4
    /* renamed from: b */
    public final Oc a(Context context, C0601t5 c0601t5, C0264g4 c0264g4, G4 g4) {
        Rg rg;
        Pc pc = new Pc(c0264g4.b, c0264g4.f994a);
        Sg sg = new Sg(new Rc());
        synchronized (c0601t5) {
            rg = (Rg) c0601t5.a(pc, g4, sg, c0601t5.f1212a);
        }
        return new Oc(context, rg);
    }
}
