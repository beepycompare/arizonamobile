package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes5.dex */
public final class Nc implements InterfaceC0699x4 {
    @Override // io.appmetrica.analytics.impl.InterfaceC0699x4
    /* renamed from: b */
    public final Oc a(Context context, C0596t5 c0596t5, C0259g4 c0259g4, G4 g4) {
        Rg rg;
        Pc pc = new Pc(c0259g4.b, c0259g4.f997a);
        Sg sg = new Sg(new Rc());
        synchronized (c0596t5) {
            rg = (Rg) c0596t5.a(pc, g4, sg, c0596t5.f1215a);
        }
        return new Oc(context, rg);
    }
}
