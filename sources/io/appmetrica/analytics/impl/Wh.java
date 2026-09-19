package io.appmetrica.analytics.impl;

import android.content.Context;
/* loaded from: classes5.dex */
public final class Wh implements InterfaceC0704x4 {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0472o5 f828a;

    public Wh(InterfaceC0472o5 interfaceC0472o5) {
        this.f828a = interfaceC0472o5;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0704x4
    /* renamed from: b */
    public final Qg a(Context context, C0601t5 c0601t5, C0264g4 c0264g4, G4 g4) {
        Rg rg;
        C0265g5 c0265g5 = new C0265g5(c0264g4.b, c0264g4.f994a);
        Sg sg = new Sg(this.f828a);
        synchronized (c0601t5) {
            rg = (Rg) c0601t5.a(c0265g5, g4, sg, c0601t5.f1212a);
        }
        return new Qg(context, rg);
    }
}
