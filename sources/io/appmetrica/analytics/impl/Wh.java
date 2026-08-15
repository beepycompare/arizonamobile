package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes5.dex */
public final class Wh implements InterfaceC0705x4 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0473o5 f828a;

    public Wh(InterfaceC0473o5 interfaceC0473o5) {
        this.f828a = interfaceC0473o5;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0705x4
    /* renamed from: b */
    public final Qg a(Context context, C0602t5 c0602t5, C0265g4 c0265g4, G4 g4) {
        Rg rg;
        C0266g5 c0266g5 = new C0266g5(c0265g4.b, c0265g4.f994a);
        Sg sg = new Sg(this.f828a);
        synchronized (c0602t5) {
            rg = (Rg) c0602t5.a(c0266g5, g4, sg, c0602t5.f1212a);
        }
        return new Qg(context, rg);
    }
}
