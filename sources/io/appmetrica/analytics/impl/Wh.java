package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes5.dex */
public final class Wh implements InterfaceC0699x4 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0467o5 f831a;

    public Wh(InterfaceC0467o5 interfaceC0467o5) {
        this.f831a = interfaceC0467o5;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0699x4
    /* renamed from: b */
    public final Qg a(Context context, C0596t5 c0596t5, C0259g4 c0259g4, G4 g4) {
        Rg rg;
        C0260g5 c0260g5 = new C0260g5(c0259g4.b, c0259g4.f997a);
        Sg sg = new Sg(this.f831a);
        synchronized (c0596t5) {
            rg = (Rg) c0596t5.a(c0260g5, g4, sg, c0596t5.f1215a);
        }
        return new Qg(context, rg);
    }
}
